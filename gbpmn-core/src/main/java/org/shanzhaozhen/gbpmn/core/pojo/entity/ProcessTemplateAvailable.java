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
@TableName("process_template_available")
@Schema(description = "流程模板可使用范围")
public class ProcessTemplateAvailable extends BaseEntity {

    private static final long serialVersionUID = -9013483163913724363L;

    @Schema(description = "主键ID")
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    @Schema(description = "模板ID")
    private String templateId;

    @Schema(description = "可使用用户ID")
    private String userId;

}
