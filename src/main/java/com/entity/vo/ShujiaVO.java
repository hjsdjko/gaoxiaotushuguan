package com.entity.vo;

import com.entity.ShujiaEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 虚拟书架
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-04-17
 */
@TableName("shujia")
public class ShujiaVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 书架主人
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 图书名称
     */

    @TableField(value = "tushu_id")
    private Integer tushuId;


    /**
     * 加入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


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
	 * 设置：书架主人
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：书架主人
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：图书名称
	 */
    public Integer getTushuId() {
        return tushuId;
    }


    /**
	 * 获取：图书名称
	 */

    public void setTushuId(Integer tushuId) {
        this.tushuId = tushuId;
    }
    /**
	 * 设置：加入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：加入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
