package com.muxi.association.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.muxi.association.mapper.LabelTypeMapper;
import com.muxi.association.pojo.entity.LabelType;
import com.muxi.association.service.LabelTypeService;
import com.muxi.association.util.PagingDealUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author ZXW
 */
@Service
public class LabelTypeServiceImpl implements LabelTypeService {

    @Resource
    private LabelTypeMapper labelTypeMapper;


    @Override
    public Map<String, Object> getLabelTypeList(String type, Long pageNum, Integer limit) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (type != null) {
            queryWrapper.like("type", type);
        }
        Page<LabelType> page = new Page<>(pageNum, limit);
        return PagingDealUtil.pageReturnValueDeal(labelTypeMapper, page, queryWrapper);
    }

    @Override
    public List<LabelType> getLabelTypeAll() {
        return labelTypeMapper.selectList(new QueryWrapper());
    }

    @Override
    public void saveLabelType(LabelType labelType) {
        labelTypeMapper.insert(labelType);
    }

    @Override
    public LabelType getLabelTypeOne(Integer id) {
        return labelTypeMapper.selectById(id);
    }

    @Override
    public void updateLabelTypeOne(LabelType labelType) {
        labelTypeMapper.updateById(labelType);
    }

    @Override
    public void deleteLabelTypes(List<Integer> ids) {
        labelTypeMapper.deleteBatchIds(ids);
    }
}
