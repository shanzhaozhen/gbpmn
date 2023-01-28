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

    public String id;

    public String type;

    public List<GEdge> in = new ArrayList<>();

    public List<GEdge> out = new ArrayList<>();

    public GEdge outWithID(String nextPeEdgeID) {
        return out.stream().filter(e -> e.id.equals(nextPeEdgeID)).findFirst().get();
    }

    public GEdge outWithOutID(String nextPeEdgeID) {
        return out.stream().filter(e -> !e.id.equals(nextPeEdgeID)).findFirst().get();
    }

    public GEdge onlyOneOut() {
        return null;
    }
}
