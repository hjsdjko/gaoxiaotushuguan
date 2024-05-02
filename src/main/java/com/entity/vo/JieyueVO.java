package com.entity.vo;

import com.entity.JieyueEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 借阅记录
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-04-17
 */
@TableName("jieyue")
public class JieyueVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 借阅用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 借阅书
     */

    @TableField(value = "tushu_id")
    private Integer tushuId;


    /**
     * 借阅时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "jieyue_time")
    private Date jieyueTime;


    /**
     * 最晚还书时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "huanshu_time")
    private Date huanshuTime;


    /**
     * 借阅状态
     */

    @TableField(value = "jieyue_types")
    private Integer jieyueTypes;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：借阅用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：借阅用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：借阅书
	 */
    public Integer getTushuId() {
        return tushuId;
    }


    /**
	 * 获取：借阅书
	 */

    public void setTushuId(Integer tushuId) {
        this.tushuId = tushuId;
    }
    /**
	 * 设置：借阅时间
	 */
    public Date getJieyueTime() {
        return jieyueTime;
    }


    /**
	 * 获取：借阅时间
	 */

    public void setJieyueTime(Date jieyueTime) {
        this.jieyueTime = jieyueTime;
    }
    /**
	 * 设置：最晚还书时间
	 */
    public Date getHuanshuTime() {
        return huanshuTime;
    }


    /**
	 * 获取：最晚还书时间
	 */

    public void setHuanshuTime(Date huanshuTime) {
        this.huanshuTime = huanshuTime;
    }
    /**
	 * 设置：借阅状态
	 */
    public Integer getJieyueTypes() {
        return jieyueTypes;
    }


    /**
	 * 获取：借阅状态
	 */

    public void setJieyueTypes(Integer jieyueTypes) {
        this.jieyueTypes = jieyueTypes;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
