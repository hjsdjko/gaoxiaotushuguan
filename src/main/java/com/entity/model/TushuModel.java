package com.entity.model;

import com.entity.TushuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 图书
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-04-17
 */
public class TushuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 图书编号
     */
    private String tushuBianhao;


    /**
     * 图书名称
     */
    private String tushuName;


    /**
     * 作者
     */
    private String tushuZuozhe;


    /**
     * 图书封面
     */
    private String tushuPhoto;


    /**
     * 图书类型
     */
    private Integer tushuTypes;


    /**
     * 出版社
     */
    private Integer chubansheTypes;


    /**
     * 图书库存
     */
    private Integer tushuKuchuen;


    /**
     * 可借阅天数
     */
    private Integer tushuJieyue;


    /**
     * 详情信息
     */
    private String tushuContent;


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
	 * 获取：图书编号
	 */
    public String getTushuBianhao() {
        return tushuBianhao;
    }


    /**
	 * 设置：图书编号
	 */
    public void setTushuBianhao(String tushuBianhao) {
        this.tushuBianhao = tushuBianhao;
    }
    /**
	 * 获取：图书名称
	 */
    public String getTushuName() {
        return tushuName;
    }


    /**
	 * 设置：图书名称
	 */
    public void setTushuName(String tushuName) {
        this.tushuName = tushuName;
    }
    /**
	 * 获取：作者
	 */
    public String getTushuZuozhe() {
        return tushuZuozhe;
    }


    /**
	 * 设置：作者
	 */
    public void setTushuZuozhe(String tushuZuozhe) {
        this.tushuZuozhe = tushuZuozhe;
    }
    /**
	 * 获取：图书封面
	 */
    public String getTushuPhoto() {
        return tushuPhoto;
    }


    /**
	 * 设置：图书封面
	 */
    public void setTushuPhoto(String tushuPhoto) {
        this.tushuPhoto = tushuPhoto;
    }
    /**
	 * 获取：图书类型
	 */
    public Integer getTushuTypes() {
        return tushuTypes;
    }


    /**
	 * 设置：图书类型
	 */
    public void setTushuTypes(Integer tushuTypes) {
        this.tushuTypes = tushuTypes;
    }
    /**
	 * 获取：出版社
	 */
    public Integer getChubansheTypes() {
        return chubansheTypes;
    }


    /**
	 * 设置：出版社
	 */
    public void setChubansheTypes(Integer chubansheTypes) {
        this.chubansheTypes = chubansheTypes;
    }
    /**
	 * 获取：图书库存
	 */
    public Integer getTushuKuchuen() {
        return tushuKuchuen;
    }


    /**
	 * 设置：图书库存
	 */
    public void setTushuKuchuen(Integer tushuKuchuen) {
        this.tushuKuchuen = tushuKuchuen;
    }
    /**
	 * 获取：可借阅天数
	 */
    public Integer getTushuJieyue() {
        return tushuJieyue;
    }


    /**
	 * 设置：可借阅天数
	 */
    public void setTushuJieyue(Integer tushuJieyue) {
        this.tushuJieyue = tushuJieyue;
    }
    /**
	 * 获取：详情信息
	 */
    public String getTushuContent() {
        return tushuContent;
    }


    /**
	 * 设置：详情信息
	 */
    public void setTushuContent(String tushuContent) {
        this.tushuContent = tushuContent;
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
