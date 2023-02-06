package org.shanzhaozhen.gbpmn.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.shanzhaozhen.gbpmn.core.pojo.entity.ProcessRuntime;

/**
 * @Author: shanzhaozhen
 * @Date: 2023-01-29
 * @Description:
 */
public interface ProcessRuntimeMapper extends BaseMapper<ProcessRuntime> {

    ProcessRuntime getProcessRuntimeByProcessId(@Param("processId") String processId);

}
