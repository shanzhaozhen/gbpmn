package org.shanzhaozhen.gbpmn.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.shanzhaozhen.gbpmn.core.pojo.entity.ProcessDiagramTemplate;

/**
 * @Author: shanzhaozhen
 * @Date: 2023-01-29
 * @Description:
 */
public interface ProcessDiagramTemplateMapper extends BaseMapper<ProcessDiagramTemplate> {

    ProcessDiagramTemplate getProcessDiagramTemplateByIdAndVersion(String templateId, String templateVersion);

}
