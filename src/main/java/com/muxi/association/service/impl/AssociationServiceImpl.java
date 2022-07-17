package com.muxi.association.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.muxi.association.mapper.AssociationMapper;
import com.muxi.association.pojo.entity.Association;
import com.muxi.association.pojo.entity.LabelType;
import com.muxi.association.service.AssociationService;
import com.muxi.association.util.PagingDealUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author ZXW
 */
@Service
public class AssociationServiceImpl implements AssociationService {

    @Resource
    private AssociationMapper associationMapper;

    @Override
    public Map<String, Object> getAssociationList(String name, Long pageNum, Integer limit) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (name != null) {
            queryWrapper.like("name", name);
        }
        Page<LabelType> page = new Page<>(pageNum, limit);
        return PagingDealUtil.pageReturnValueDeal(associationMapper, page, queryWrapper);
    }

    @Override
    public List<Association> getAssociationAll() {
        return associationMapper.selectList(new QueryWrapper());
    }

    @Override
    public void saveAssociation(Association association) {
        associationMapper.insert(association);
    }

    @Override
    public Association getAssociationOne(Integer id) {
        return associationMapper.selectById(id);
    }

    @Override
    public void updateAssociationOne(Association association) {
        associationMapper.updateById(association);
    }

    @Override
    public void deleteAssociations(List<Integer> ids) {
        associationMapper.deleteBatchIds(ids);
    }
}
