package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.JieyueEntity;

import com.service.JieyueService;
import com.entity.view.JieyueView;
import com.service.TushuService;
import com.entity.TushuEntity;
import com.service.YonghuService;
import com.entity.YonghuEntity;

import com.utils.PageUtils;
import com.utils.R;

/**
 * 借阅记录
 * 后端接口
 * @author
 * @email
 * @date 2021-04-17
*/
@RestController
@Controller
@RequestMapping("/jieyue")
public class JieyueController {
    private static final Logger logger = LoggerFactory.getLogger(JieyueController.class);

    @Autowired
    private JieyueService jieyueService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service
    @Autowired
    private TushuService tushuService;
    @Autowired
    private YonghuService yonghuService;


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
        PageUtils page = jieyueService.queryPage(params);

        //字典表数据转换
        List<JieyueView> list =(List<JieyueView>)page.getList();
        for(JieyueView c:list){
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
        JieyueEntity jieyue = jieyueService.selectById(id);
        if(jieyue !=null){
            //entity转view
            JieyueView view = new JieyueView();
            BeanUtils.copyProperties( jieyue , view );//把实体数据重构到view中

            //级联表
            TushuEntity tushu = tushuService.selectById(jieyue.getTushuId());
            if(tushu != null){
                BeanUtils.copyProperties( tushu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setTushuId(tushu.getId());
            }
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(jieyue.getYonghuId());
            if(yonghu != null){
                BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setYonghuId(yonghu.getId());
            }
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
    public R save(@RequestBody JieyueEntity jieyue, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jieyue:{}",this.getClass().getName(),jieyue.toString());
        Wrapper<JieyueEntity> queryWrapper = new EntityWrapper<JieyueEntity>()
            .eq("yonghu_id", jieyue.getYonghuId())
            .eq("tushu_id", jieyue.getTushuId())
            .eq("jieyue_types", jieyue.getJieyueTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JieyueEntity jieyueEntity = jieyueService.selectOne(queryWrapper);
        if(jieyueEntity==null){
            jieyue.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      jieyue.set
        //  }
            jieyueService.insert(jieyue);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JieyueEntity jieyue, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,jieyue:{}",this.getClass().getName(),jieyue.toString());
        //根据字段查询是否有相同数据
        Wrapper<JieyueEntity> queryWrapper = new EntityWrapper<JieyueEntity>()
            .notIn("id",jieyue.getId())
            .andNew()
            .eq("yonghu_id", jieyue.getYonghuId())
            .eq("tushu_id", jieyue.getTushuId())
            .eq("jieyue_types", jieyue.getJieyueTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JieyueEntity jieyueEntity = jieyueService.selectOne(queryWrapper);
        if(jieyueEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      jieyue.set
            //  }
            jieyueService.updateById(jieyue);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        Integer userId = (Integer)request.getSession().getAttribute("userId");
        YonghuEntity yonghuEntity = yonghuService.selectById(userId);
        yonghuEntity.setJieyueshuliang(yonghuEntity.getJieyueshuliang()-ids.length);
        yonghuService.updateById(yonghuEntity);
        jieyueService.deleteBatchIds(Arrays.asList(ids));
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
        PageUtils page = jieyueService.queryPage(params);

        //字典表数据转换
        List<JieyueView> list =(List<JieyueView>)page.getList();
        for(JieyueView c:list){
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
        JieyueEntity jieyue = jieyueService.selectById(id);
            if(jieyue !=null){
                //entity转view
        JieyueView view = new JieyueView();
                BeanUtils.copyProperties( jieyue , view );//把实体数据重构到view中

                //级联表
                    TushuEntity tushu = tushuService.selectById(jieyue.getTushuId());
                if(tushu != null){
                    BeanUtils.copyProperties( tushu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setTushuId(tushu.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(jieyue.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
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
    public R add(@RequestBody JieyueEntity jieyue, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,jieyue:{}",this.getClass().getName(),jieyue.toString());
        Wrapper<JieyueEntity> queryWrapper = new EntityWrapper<JieyueEntity>()
            .eq("yonghu_id", jieyue.getYonghuId())
            .eq("tushu_id", jieyue.getTushuId())
            .eq("jieyue_types", jieyue.getJieyueTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
    JieyueEntity jieyueEntity = jieyueService.selectOne(queryWrapper);
        if(jieyueEntity==null){
            jieyue.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      jieyue.set
        //  }
        jieyueService.insert(jieyue);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}

