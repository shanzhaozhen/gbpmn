package org.shanzhaozhen.gbpmn.core.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@TableName("g_node")
@Schema(description = "节点")
public class GNode {

    @Schema(description = "主键ID")
    private String id;

    @Schema(description = "节点类型")
    private String type;

    @Schema(description = "入线")
    private List<GEdge> in = new ArrayList<>();

    @Schema(description = "出线")
    private List<GEdge> out = new ArrayList<>();

    public GEdge outWithID(String nextPeEdgeID) {
        return out.stream().filter(e -> e.getId().equals(nextPeEdgeID)).findFirst().get();
    }

    public GEdge outWithOutID(String nextPeEdgeID) {
        return out.stream().filter(e -> !e.getId().equals(nextPeEdgeID)).findFirst().get();
    }

    public GEdge onlyOneOut() {
        return null;
    }
}
