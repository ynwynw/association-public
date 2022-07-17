package com.muxi.association.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.muxi.association.mapper.OrganizationMapper;
import com.muxi.association.pojo.entity.Organization;
import com.muxi.association.service.OrganizationService;
import com.muxi.association.util.PagingDealUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author ZXW
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Resource
    private OrganizationMapper organizationMapper;

    @Override
    public Map<String, Object> getOrganizationList(String name, Long pageNum, Integer limit) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (name != null) {
            queryWrapper.like("name", name);
        }
        Page<Organization> page = new Page<>(pageNum, limit);
        return PagingDealUtil.pageReturnValueDeal(organizationMapper, page, queryWrapper);
    }

    @Override
    public List<Organization> getOrganizationAll() {
        return organizationMapper.selectList(new QueryWrapper());
    }

    @Override
    public void saveOrganization(Organization organization) {
        organizationMapper.insert(organization);
    }

    @Override
    public Organization getOrganizationOne(Integer id) {
        return organizationMapper.selectById(id);
    }

    @Override
    public void updateOrganizationOne(Organization organization) {
        organizationMapper.updateById(organization);
    }

    @Override
    public void deleteOrganizations(List<Integer> ids) {
        organizationMapper.deleteBatchIds(ids);
    }
}
