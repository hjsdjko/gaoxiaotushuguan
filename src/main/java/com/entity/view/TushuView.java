package com.entity.view;

import com.entity.TushuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 图书
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-04-17
 */
@TableName("tushu")
public class TushuView extends TushuEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 图书类型的值
		*/
		private String tushuValue;
		/**
		* 出版社的值
		*/
		private String chubansheValue;



	public TushuView() {

	}

	public TushuView(TushuEntity tushuEntity) {
		try {
			BeanUtils.copyProperties(this, tushuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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











}
