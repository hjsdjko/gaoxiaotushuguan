package com.dao;

import com.entity.ShujiaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShujiaView;

/**
 * 虚拟书架 Dao 接口
 *
 * @author 
 * @since 2021-04-17
 */
public interface ShujiaDao extends BaseMapper<ShujiaEntity> {

   List<ShujiaView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
