package org.shanzhaozhen.gbpmn.core.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@TableName("g_edge")
@Schema(description = "线")
public class GEdge {

    @Schema(description = "主键ID")
    private String id;

    @Schema(description = "类型")
    private String type;

    @Schema(description = "源节点")
    private GNode source;

    @Schema(description = "目标节点")
    private GNode target;

}
