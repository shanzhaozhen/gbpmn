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
@TableName("process_template")
@Schema(description = "流程模板")
public class ProcessTemplate extends BaseEntity {

    private static final long serialVersionUID = 7145679871323543398L;

    @Schema(description = "主键ID")
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    @Schema(description = "是否开放")
    private Boolean open;

    @Schema(description = "主题编码规则")
    private String subjectRule;

    @Schema(description = "编码规则")
    private String numberRuleId;

    @Schema(description = "表单模板ID")
    private String contextTemplateId;

    @Schema(description = "表单模板版本")
    private String contextTemplateVersion;

    @Schema(description = "流程图模板ID")
    private String processDiagramTemplateId;

    @Schema(description = "流程图模板版本")
    private String processDiagramTemplateVersion;

}
