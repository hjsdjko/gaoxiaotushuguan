package com.entity.model;

import com.entity.YonghuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 用户
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-04-17
 */
public class YonghuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 用户姓名
     */
    private String yonghuName;


    /**
     * 学号
     */
    private String yonghuXuehao;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 身份证号
     */
    private String yonghuIdNumber;


    /**
     * 手机号
     */
    private String yonghuPhone;


    /**
     * 住址
     */
    private String yonghuZhuzhi;


    /**
     * 照片
     */
    private String yonghuPhoto;


    /**
     * 学院
     */
    private String yonghuXueyuan;


    /**
     * 专业
     */
    private String yonghuZhanye;


    /**
     * 班级
     */
    private String yonghuBanji;


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
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：用户姓名
	 */
    public String getYonghuName() {
        return yonghuName;
    }


    /**
	 * 设置：用户姓名
	 */
    public void setYonghuName(String yonghuName) {
        this.yonghuName = yonghuName;
    }
    /**
	 * 获取：学号
	 */
    public String getYonghuXuehao() {
        return yonghuXuehao;
    }


    /**
	 * 设置：学号
	 */
    public void setYonghuXuehao(String yonghuXuehao) {
        this.yonghuXuehao = yonghuXuehao;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：身份证号
	 */
    public String getYonghuIdNumber() {
        return yonghuIdNumber;
    }


    /**
	 * 设置：身份证号
	 */
    public void setYonghuIdNumber(String yonghuIdNumber) {
        this.yonghuIdNumber = yonghuIdNumber;
    }
    /**
	 * 获取：手机号
	 */
    public String getYonghuPhone() {
        return yonghuPhone;
    }


    /**
	 * 设置：手机号
	 */
    public void setYonghuPhone(String yonghuPhone) {
        this.yonghuPhone = yonghuPhone;
    }
    /**
	 * 获取：住址
	 */
    public String getYonghuZhuzhi() {
        return yonghuZhuzhi;
    }


    /**
	 * 设置：住址
	 */
    public void setYonghuZhuzhi(String yonghuZhuzhi) {
        this.yonghuZhuzhi = yonghuZhuzhi;
    }
    /**
	 * 获取：照片
	 */
    public String getYonghuPhoto() {
        return yonghuPhoto;
    }


    /**
	 * 设置：照片
	 */
    public void setYonghuPhoto(String yonghuPhoto) {
        this.yonghuPhoto = yonghuPhoto;
    }
    /**
	 * 获取：学院
	 */
    public String getYonghuXueyuan() {
        return yonghuXueyuan;
    }


    /**
	 * 设置：学院
	 */
    public void setYonghuXueyuan(String yonghuXueyuan) {
        this.yonghuXueyuan = yonghuXueyuan;
    }
    /**
	 * 获取：专业
	 */
    public String getYonghuZhanye() {
        return yonghuZhanye;
    }


    /**
	 * 设置：专业
	 */
    public void setYonghuZhanye(String yonghuZhanye) {
        this.yonghuZhanye = yonghuZhanye;
    }
    /**
	 * 获取：班级
	 */
    public String getYonghuBanji() {
        return yonghuBanji;
    }


    /**
	 * 设置：班级
	 */
    public void setYonghuBanji(String yonghuBanji) {
        this.yonghuBanji = yonghuBanji;
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
