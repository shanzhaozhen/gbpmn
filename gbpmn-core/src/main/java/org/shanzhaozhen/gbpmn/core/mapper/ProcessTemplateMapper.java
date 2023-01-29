package org.shanzhaozhen.gbpmn.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.shanzhaozhen.gbpmn.core.pojo.entity.ProcessTemplate;

/**
 * @Author: shanzhaozhen
 * @Date: 2023-01-29
 * @Description:
 */
public interface ProcessTemplateMapper extends BaseMapper<ProcessTemplate> {

    ProcessTemplate getProcessTemplateByIdAndVersion(String templateId, String templateVersion);

}
