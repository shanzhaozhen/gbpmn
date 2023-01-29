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
 * @Description: 编码规则
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("number_rule")
@Schema(description = "编码规则")
public class NumberRule extends BaseEntity {

    private static final long serialVersionUID = -9051086689975733604L;

    @Schema(description = "主键ID")
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    @Schema(description = "编码规则")
    private String rule;

}
