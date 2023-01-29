package org.shanzhaozhen.gbpmn.core.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: shanzhaozhen
 * @Date: 2023-01-29
 * @Description: 审批流程模板
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("process_diagram_template")
@Schema(description = "流程图模板")
public class ProcessDiagramTemplate extends BaseEntity {

    private static final long serialVersionUID = 7145679871323543398L;

    @Schema(description = "主键ID")
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    @Schema(description = "模板版本")
    private String templateVersion;

    @Schema(description = "流程图数据")
    private String detail;


}
