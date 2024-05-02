package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;

import com.entity.JieyueEntity;
import com.entity.ShujiaEntity;
import com.entity.YonghuEntity;
import com.service.*;
import jdk.nashorn.internal.runtime.ScriptFunctionData;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;

import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.TushuEntity;

import com.entity.view.TushuView;

import com.utils.PageUtils;
import com.utils.R;

/**
 * 图书
 * 后端接口
 * @author
 * @email
 * @date 2021-04-17
*/
@RestController
@Controller
@RequestMapping("/tushu")
public class TushuController {
    private static final Logger logger = LoggerFactory.getLogger(TushuController.class);

    @Autowired
    private TushuService tushuService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private YonghuService yonghuService;

    @Autowired
    private JieyueService jieyueService;

    @Autowired
    private ShujiaService shujiaService;




    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isNotEmpty(role) && "用户".equals(role)){
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        }
        params.put("orderBy","id");
        PageUtils page = tushuService.queryPage(params);

        //字典表数据转换
        List<TushuView> list =(List<TushuView>)page.getList();
        for(TushuView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        TushuEntity tushu = tushuService.selectById(id);
        if(tushu !=null){
            //entity转view
            TushuView view = new TushuView();
            BeanUtils.copyProperties( tushu , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody TushuEntity tushu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,tushu:{}",this.getClass().getName(),tushu.toString());
        Wrapper<TushuEntity> queryWrapper = new EntityWrapper<TushuEntity>()
            .eq("tushu_bianhao", tushu.getTushuBianhao())
            .eq("tushu_name", tushu.getTushuName())
            .eq("tushu_zuozhe", tushu.getTushuZuozhe())
            .eq("tushu_types", tushu.getTushuTypes())
            .eq("chubanshe_types", tushu.getChubansheTypes())
            .eq("tushu_kuchuen", tushu.getTushuKuchuen())
            .eq("tushu_jieyue", tushu.getTushuJieyue())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        TushuEntity tushuEntity = tushuService.selectOne(queryWrapper);
        if(tushuEntity==null){
            tushu.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      tushu.set
        //  }
            tushuService.insert(tushu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody TushuEntity tushu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,tushu:{}",this.getClass().getName(),tushu.toString());
        //根据字段查询是否有相同数据
        Wrapper<TushuEntity> queryWrapper = new EntityWrapper<TushuEntity>()
            .notIn("id",tushu.getId())
            .andNew()
            .eq("tushu_bianhao", tushu.getTushuBianhao())
            .eq("tushu_name", tushu.getTushuName())
            .eq("tushu_zuozhe", tushu.getTushuZuozhe())
            .eq("tushu_types", tushu.getTushuTypes())
            .eq("chubanshe_types", tushu.getChubansheTypes())
            .eq("tushu_kuchuen", tushu.getTushuKuchuen())
            .eq("tushu_jieyue", tushu.getTushuJieyue())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        TushuEntity tushuEntity = tushuService.selectOne(queryWrapper);
        if("".equals(tushu.getTushuPhoto()) || "null".equals(tushu.getTushuPhoto())){
                tushu.setTushuPhoto(null);
        }
        if(tushuEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      tushu.set
            //  }
            tushuService.updateById(tushu);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        tushuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
    * 还书
    */
    @RequestMapping("/huanshu")
    public R huanshu(Integer ids, HttpServletRequest request) {
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        YonghuEntity yonghu = yonghuService.selectById(userId);
        JieyueEntity jieyue = jieyueService.selectById(ids);
        TushuEntity tushu = tushuService.selectById(jieyue.getTushuId());
        jieyue.setJieyueTypes(2);
        boolean b = jieyueService.updateById(jieyue);
        if(b){
            yonghu.setJieyueshuliang(yonghu.getJieyueshuliang()-1);
            yonghuService.updateById(yonghu);
            tushu.setTushuKuchuen(tushu.getTushuKuchuen()+1);
            tushuService.updateById(tushu);
            return R.ok();
        }
        return R.error();
    }
    /**
    * 续借
    */
    @RequestMapping("/xujie")
    public R xujie(Integer ids, HttpServletRequest request) {
        JieyueEntity jieyue = jieyueService.selectById(ids);
        if(jieyue == null){
            return R.error();
        }
        jieyue.setHuanshuTime(new Date(Long.valueOf(jieyue.getHuanshuTime().getTime()+30*24*60*60*1000L)));
        boolean b = jieyueService.updateById(jieyue);
        if(b){
            return R.ok();
        }

        return R.error();
    }
    /**
    * 加入书架
    */
    @RequestMapping("/jiarushujia")
    public R jiarushujia(Integer ids, HttpServletRequest request){
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        ShujiaEntity shujia = new ShujiaEntity();
        shujia.setCreateTime(new Date());
        shujia.setInsertTime(new Date());
        shujia.setTushuId(ids);
        shujia.setYonghuId(userId);
        Wrapper<ShujiaEntity> queryWrapper = new EntityWrapper<ShujiaEntity>()
                .eq("yonghu_id", shujia.getYonghuId())
                .eq("tushu_id", shujia.getTushuId())
                ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShujiaEntity shujiaEntity = shujiaService.selectOne(queryWrapper);
        if(shujiaEntity==null){
            shujiaService.insert(shujia);
            return R.ok();
        }else {
            return R.error(511,"您的书架中已经有这本书了");
        }
    }

    /**
    * 借阅
    */
    @RequestMapping("/jieyue")
    public R jieyue(Integer ids, HttpServletRequest request){
        YonghuEntity userId = yonghuService.selectById((Integer) request.getSession().getAttribute("userId"));
        if(userId.getJieyueshuliang() == null || userId.getJieyueshuliang() < 0){
            userId.setJieyueshuliang(0);
        }
        if(userId.getJieyueshuliang() >= 3){
            return R.error("您已经借阅三本书了");
        }
        userId.setJieyueshuliang(userId.getJieyueshuliang()+1);
        TushuEntity tushu = tushuService.selectById(ids);
        if(tushu == null){
            return R.error();
        }
        if(tushu.getTushuKuchuen() <= 0){
            return R.error("此书库存不足");
        }
        JieyueEntity jieyue = new JieyueEntity();
        jieyue.setCreateTime(new Date());
        jieyue.setJieyueTypes(1);
        jieyue.setJieyueTime(new Date());
        jieyue.setTushuId(ids);
        jieyue.setYonghuId((Integer) request.getSession().getAttribute("userId"));
        jieyue.setHuanshuTime(new Date(new Date().getTime()+Long.valueOf(tushu.getTushuJieyue())*24*60*60*1000));
        Wrapper<JieyueEntity> queryWrapper = new EntityWrapper<JieyueEntity>()
                .eq("yonghu_id", jieyue.getYonghuId())
                .eq("tushu_id", jieyue.getTushuId())
                ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JieyueEntity jieyueEntity = jieyueService.selectOne(queryWrapper);
        if(jieyueEntity!=null && jieyueEntity.getJieyueTypes()!=2){
            return R.error("你已经借阅过这本书了");
        }
        tushu.setTushuKuchuen(tushu.getTushuKuchuen()-1);
        tushuService.updateById(tushu);
        yonghuService.updateById(userId);
        jieyueService.insert(jieyue);
        return R.ok();
    }



    /**
    * 前端列表
    */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isNotEmpty(role) && "用户".equals(role)){
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        }
        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = tushuService.queryPage(params);

        //字典表数据转换
        List<TushuView> list =(List<TushuView>)page.getList();
        for(TushuView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        TushuEntity tushu = tushuService.selectById(id);
            if(tushu !=null){
                //entity转view
        TushuView view = new TushuView();
                BeanUtils.copyProperties( tushu , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody TushuEntity tushu, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,tushu:{}",this.getClass().getName(),tushu.toString());
        Wrapper<TushuEntity> queryWrapper = new EntityWrapper<TushuEntity>()
            .eq("tushu_bianhao", tushu.getTushuBianhao())
            .eq("tushu_name", tushu.getTushuName())
            .eq("tushu_zuozhe", tushu.getTushuZuozhe())
            .eq("tushu_types", tushu.getTushuTypes())
            .eq("chubanshe_types", tushu.getChubansheTypes())
            .eq("tushu_kuchuen", tushu.getTushuKuchuen())
            .eq("tushu_jieyue", tushu.getTushuJieyue())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
    TushuEntity tushuEntity = tushuService.selectOne(queryWrapper);
        if(tushuEntity==null){
            tushu.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      tushu.set
        //  }
        tushuService.insert(tushu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}

