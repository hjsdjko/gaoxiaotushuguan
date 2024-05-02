package com.entity.view;

import com.entity.JieyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 借阅记录
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-04-17
 */
@TableName("jieyue")
public class JieyueView extends JieyueEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 借阅状态的值
		*/
		private String jieyueValue;



		//级联表 tushu
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
				* 图书类型的值
				*/
				private String tushuValue;
			/**
			* 出版社
			*/
			private Integer chubansheTypes;
				/**
				* 出版社的值
				*/
				private String chubansheValue;
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

		//级联表 yonghu
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
				* 性别的值
				*/
				private String sexValue;
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

	public JieyueView() {

	}

	public JieyueView(JieyueEntity jieyueEntity) {
		try {
			BeanUtils.copyProperties(this, jieyueEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 借阅状态的值
			*/
			public String getJieyueValue() {
				return jieyueValue;
			}
			/**
			* 设置： 借阅状态的值
			*/
			public void setJieyueValue(String jieyueValue) {
				this.jieyueValue = jieyueValue;
			}




















				//级联表的get和set tushu
					/**
					* 获取： 图书编号
					*/
					public String getTushuBianhao() {
						return tushuBianhao;
					}
					/**
					* 设置： 图书编号
					*/
					public void setTushuBianhao(String tushuBianhao) {
						this.tushuBianhao = tushuBianhao;
					}
					/**
					* 获取： 图书名称
					*/
					public String getTushuName() {
						return tushuName;
					}
					/**
					* 设置： 图书名称
					*/
					public void setTushuName(String tushuName) {
						this.tushuName = tushuName;
					}
					/**
					* 获取： 作者
					*/
					public String getTushuZuozhe() {
						return tushuZuozhe;
					}
					/**
					* 设置： 作者
					*/
					public void setTushuZuozhe(String tushuZuozhe) {
						this.tushuZuozhe = tushuZuozhe;
					}
					/**
					* 获取： 图书封面
					*/
					public String getTushuPhoto() {
						return tushuPhoto;
					}
					/**
					* 设置： 图书封面
					*/
					public void setTushuPhoto(String tushuPhoto) {
						this.tushuPhoto = tushuPhoto;
					}
					/**
					* 获取： 图书类型
					*/
					public Integer getTushuTypes() {
						return tushuTypes;
					}
					/**
					* 设置： 图书类型
					*/
					public void setTushuTypes(Integer tushuTypes) {
						this.tushuTypes = tushuTypes;
					}


						/**
						* 获取： 图书类型的值
						*/
						public String getTushuValue() {
							return tushuValue;
						}
						/**
						* 设置： 图书类型的值
						*/
						public void setTushuValue(String tushuValue) {
							this.tushuValue = tushuValue;
						}
					/**
					* 获取： 出版社
					*/
					public Integer getChubansheTypes() {
						return chubansheTypes;
					}
					/**
					* 设置： 出版社
					*/
					public void setChubansheTypes(Integer chubansheTypes) {
						this.chubansheTypes = chubansheTypes;
					}


						/**
						* 获取： 出版社的值
						*/
						public String getChubansheValue() {
							return chubansheValue;
						}
						/**
						* 设置： 出版社的值
						*/
						public void setChubansheValue(String chubansheValue) {
							this.chubansheValue = chubansheValue;
						}
					/**
					* 获取： 图书库存
					*/
					public Integer getTushuKuchuen() {
						return tushuKuchuen;
					}
					/**
					* 设置： 图书库存
					*/
					public void setTushuKuchuen(Integer tushuKuchuen) {
						this.tushuKuchuen = tushuKuchuen;
					}
					/**
					* 获取： 可借阅天数
					*/
					public Integer getTushuJieyue() {
						return tushuJieyue;
					}
					/**
					* 设置： 可借阅天数
					*/
					public void setTushuJieyue(Integer tushuJieyue) {
						this.tushuJieyue = tushuJieyue;
					}
					/**
					* 获取： 详情信息
					*/
					public String getTushuContent() {
						return tushuContent;
					}
					/**
					* 设置： 详情信息
					*/
					public void setTushuContent(String tushuContent) {
						this.tushuContent = tushuContent;
					}





				//级联表的get和set yonghu
					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}
					/**
					* 获取： 学号
					*/
					public String getYonghuXuehao() {
						return yonghuXuehao;
					}
					/**
					* 设置： 学号
					*/
					public void setYonghuXuehao(String yonghuXuehao) {
						this.yonghuXuehao = yonghuXuehao;
					}
					/**
					* 获取： 性别
					*/
					public Integer getSexTypes() {
						return sexTypes;
					}
					/**
					* 设置： 性别
					*/
					public void setSexTypes(Integer sexTypes) {
						this.sexTypes = sexTypes;
					}


						/**
						* 获取： 性别的值
						*/
						public String getSexValue() {
							return sexValue;
						}
						/**
						* 设置： 性别的值
						*/
						public void setSexValue(String sexValue) {
							this.sexValue = sexValue;
						}
					/**
					* 获取： 身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}
					/**
					* 获取： 手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}
					/**
					* 获取： 住址
					*/
					public String getYonghuZhuzhi() {
						return yonghuZhuzhi;
					}
					/**
					* 设置： 住址
					*/
					public void setYonghuZhuzhi(String yonghuZhuzhi) {
						this.yonghuZhuzhi = yonghuZhuzhi;
					}
					/**
					* 获取： 照片
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 照片
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}
					/**
					* 获取： 学院
					*/
					public String getYonghuXueyuan() {
						return yonghuXueyuan;
					}
					/**
					* 设置： 学院
					*/
					public void setYonghuXueyuan(String yonghuXueyuan) {
						this.yonghuXueyuan = yonghuXueyuan;
					}
					/**
					* 获取： 专业
					*/
					public String getYonghuZhanye() {
						return yonghuZhanye;
					}
					/**
					* 设置： 专业
					*/
					public void setYonghuZhanye(String yonghuZhanye) {
						this.yonghuZhanye = yonghuZhanye;
					}
					/**
					* 获取： 班级
					*/
					public String getYonghuBanji() {
						return yonghuBanji;
					}
					/**
					* 设置： 班级
					*/
					public void setYonghuBanji(String yonghuBanji) {
						this.yonghuBanji = yonghuBanji;
					}




}
