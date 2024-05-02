package com.entity.vo;

import com.entity.TushuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 图书
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-04-17
 */
@TableName("tushu")
public class TushuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 图书编号
     */

    @TableField(value = "tushu_bianhao")
    private String tushuBianhao;


    /**
     * 图书名称
     */

    @TableField(value = "tushu_name")
    private String tushuName;


    /**
     * 作者
     */

    @TableField(value = "tushu_zuozhe")
    private String tushuZuozhe;


    /**
     * 图书封面
     */

    @TableField(value = "tushu_photo")
    private String tushuPhoto;


    /**
     * 图书类型
     */

    @TableField(value = "tushu_types")
    private Integer tushuTypes;


    /**
     * 出版社
     */

    @TableField(value = "chubanshe_types")
    private Integer chubansheTypes;


    /**
     * 图书库存
     */

    @TableField(value = "tushu_kuchuen")
    private Integer tushuKuchuen;


    /**
     * 可借阅天数
     */

    @TableField(value = "tushu_jieyue")
    private Integer tushuJieyue;


    /**
     * 详情信息
     */

    @TableField(value = "tushu_content")
    private String tushuContent;


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
	 * 设置：图书编号
	 */
    public String getTushuBianhao() {
        return tushuBianhao;
    }


    /**
	 * 获取：图书编号
	 */

    public void setTushuBianhao(String tushuBianhao) {
        this.tushuBianhao = tushuBianhao;
    }
    /**
	 * 设置：图书名称
	 */
    public String getTushuName() {
        return tushuName;
    }


    /**
	 * 获取：图书名称
	 */

    public void setTushuName(String tushuName) {
        this.tushuName = tushuName;
    }
    /**
	 * 设置：作者
	 */
    public String getTushuZuozhe() {
        return tushuZuozhe;
    }


    /**
	 * 获取：作者
	 */

    public void setTushuZuozhe(String tushuZuozhe) {
        this.tushuZuozhe = tushuZuozhe;
    }
    /**
	 * 设置：图书封面
	 */
    public String getTushuPhoto() {
        return tushuPhoto;
    }


    /**
	 * 获取：图书封面
	 */

    public void setTushuPhoto(String tushuPhoto) {
        this.tushuPhoto = tushuPhoto;
    }
    /**
	 * 设置：图书类型
	 */
    public Integer getTushuTypes() {
        return tushuTypes;
    }


    /**
	 * 获取：图书类型
	 */

    public void setTushuTypes(Integer tushuTypes) {
        this.tushuTypes = tushuTypes;
    }
    /**
	 * 设置：出版社
	 */
    public Integer getChubansheTypes() {
        return chubansheTypes;
    }


    /**
	 * 获取：出版社
	 */

    public void setChubansheTypes(Integer chubansheTypes) {
        this.chubansheTypes = chubansheTypes;
    }
    /**
	 * 设置：图书库存
	 */
    public Integer getTushuKuchuen() {
        return tushuKuchuen;
    }


    /**
	 * 获取：图书库存
	 */

    public void setTushuKuchuen(Integer tushuKuchuen) {
        this.tushuKuchuen = tushuKuchuen;
    }
    /**
	 * 设置：可借阅天数
	 */
    public Integer getTushuJieyue() {
        return tushuJieyue;
    }


    /**
	 * 获取：可借阅天数
	 */

    public void setTushuJieyue(Integer tushuJieyue) {
        this.tushuJieyue = tushuJieyue;
    }
    /**
	 * 设置：详情信息
	 */
    public String getTushuContent() {
        return tushuContent;
    }


    /**
	 * 获取：详情信息
	 */

    public void setTushuContent(String tushuContent) {
        this.tushuContent = tushuContent;
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
