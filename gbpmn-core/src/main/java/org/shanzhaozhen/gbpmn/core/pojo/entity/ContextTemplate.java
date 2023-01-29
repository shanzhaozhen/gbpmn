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
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("g_process_record")
@Schema(description = "表单模板")
public class ContextTemplate extends BaseEntity {

    private static final long serialVersionUID = -6449564317696470146L;

    @Schema(description = "主键ID")
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    @Schema(description = "模板版本")
    private String templateVersion;

    @Schema(description = "表单数据")
    private String detail;


}
