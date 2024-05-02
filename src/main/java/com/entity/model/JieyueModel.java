package com.entity.model;

import com.entity.JieyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 借阅记录
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-04-17
 */
public class JieyueModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 借阅用户
     */
    private Integer yonghuId;


    /**
     * 借阅书
     */
    private Integer tushuId;


    /**
     * 借阅时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date jieyueTime;


    /**
     * 最晚还书时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date huanshuTime;


    /**
     * 借阅状态
     */
    private Integer jieyueTypes;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：借阅用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：借阅用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：借阅书
	 */
    public Integer getTushuId() {
        return tushuId;
    }


    /**
	 * 设置：借阅书
	 */
    public void setTushuId(Integer tushuId) {
        this.tushuId = tushuId;
    }
    /**
	 * 获取：借阅时间
	 */
    public Date getJieyueTime() {
        return jieyueTime;
    }


    /**
	 * 设置：借阅时间
	 */
    public void setJieyueTime(Date jieyueTime) {
        this.jieyueTime = jieyueTime;
    }
    /**
	 * 获取：最晚还书时间
	 */
    public Date getHuanshuTime() {
        return huanshuTime;
    }


    /**
	 * 设置：最晚还书时间
	 */
    public void setHuanshuTime(Date huanshuTime) {
        this.huanshuTime = huanshuTime;
    }
    /**
	 * 获取：借阅状态
	 */
    public Integer getJieyueTypes() {
        return jieyueTypes;
    }


    /**
	 * 设置：借阅状态
	 */
    public void setJieyueTypes(Integer jieyueTypes) {
        this.jieyueTypes = jieyueTypes;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
