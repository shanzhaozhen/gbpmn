package org.shanzhaozhen.gbpmn.core.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @Author: shanzhaozhen
 * @Date: 2023-01-29
 * @Description: 流程实例持久化
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("g_process_record")
@Schema(description = "流程实例")
public class ProcessInstance extends BaseEntity {

    private static final long serialVersionUID = 7145679871323543398L;

    @Schema(description = "主键ID")
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    @Schema(description = "流程编码")
    private String number;

    @Schema(description = "流程主题")
    private String subject;

    @Schema(description = "模板ID")
    private String templateId;

    @Schema(description = "模板版本")
    private String templateVersion;

    @Schema(description = "上下文数据（JSON）")
    private String dataJson;

    @Schema(description = "流程状态")
    private String status;

    @Schema(description = "发布时间")
    private LocalDateTime publishDate;

}
