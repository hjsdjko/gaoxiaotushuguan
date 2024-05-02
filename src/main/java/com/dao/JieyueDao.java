package com.dao;

import com.entity.JieyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JieyueView;

/**
 * 借阅记录 Dao 接口
 *
 * @author 
 * @since 2021-04-17
 */
public interface JieyueDao extends BaseMapper<JieyueEntity> {

   List<JieyueView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
