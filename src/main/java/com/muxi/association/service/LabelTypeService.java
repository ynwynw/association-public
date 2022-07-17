package com.muxi.association.service;

import com.muxi.association.pojo.entity.LabelType;

import java.util.List;
import java.util.Map;

/**
 * @author ZXW
 */
public interface LabelTypeService {
    /**
     * 根据条件获取标签列表
     * @param type
     * @param pageNum
     * @param limit
     * @return
     */
    Map<String, Object> getLabelTypeList(String type, Long pageNum, Integer limit);

    /**
     * 获得所有标签类型
     * @return
     */
    List<LabelType> getLabelTypeAll();

    /**
     * 报存标签类型
     * @param labelType
     */
    void saveLabelType(LabelType labelType);

    /**
     * 通过id获取对象
     * @param id
     * @return
     */
    LabelType getLabelTypeOne(Integer id);

    /**
     * 更新label对象
     * @param labelType
     */
    void updateLabelTypeOne(LabelType labelType);

    /**
     *  根据id删出
     * @param ids
     */
    void deleteLabelTypes(List<Integer> ids);
}
