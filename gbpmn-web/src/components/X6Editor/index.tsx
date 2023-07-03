import {FC, useEffect, useRef, useState} from "react";
import X6Flow from "@/components/X6Editor/X6Flow";
import FlowGraph from "@/components/X6Editor/FlowGraph";
import {EdgeMeta, GraphData, NodeMeta} from "@/components/X6Editor/types";
import {Minimap} from "@/components/X6Editor/plugins/minimap";

import {GraphToolbar} from "@/components/GraphToolbar";

import './index.less'
import {ScaleToolbar} from "@/components/X6Editor/plugins/ScaleToolbar";

const defaultNodeOptions: NodeMeta = {
  width: 100,
  height: 40,
  attrs: {
    body: {
      stroke: "#8f8f8f",
      strokeWidth: 1,
      fill: "#fff",
      rx: 6,
      ry: 6
    },
  }
}

const defaultEdgeOptions: EdgeMeta = {
  attrs: {
    line: {
      stroke: "#8f8f8f",
      strokeWidth: 1,
      targetMarker: {
        name: 'classic',
        size: 6,
      },
    }
  }
}

const graphConfig = {
  background: {
    // color: "#F2F7FA"
  },
  grid: {
    visible: true,
    type: 'dot',
    size: 10,
    args: {
      color: '#a0a0a0', // 网格线/点颜色
      thickness: 1,     // 网格线宽度/网格点大小
    },
  }
}


const X6Editor: FC = () => {
  const container = useRef<HTMLDivElement>(null)

  const [data, setData] = useState<GraphData>([]);

  const getGraphData = () => {
    setData([
      {
        id: '1',
        shape: 'rect',
        x: 100,
        y: 100,
        label: 'source',
      },
      {
        id: '2',
        shape: 'rect',
        x: 300,
        y: 300,
        label: 'target',
      },
      {
        id: '3',
        shape: 'edge',
        source: '1',
        target: '2',
        label: 'text'
      }
    ])
  };

  useEffect(() => {
    getGraphData()
  }, [])


  return (
    <div className="background-grid-app" ref={container}>
      <X6Flow>
        <FlowGraph
          data={data}
          nodeOptions={defaultNodeOptions}
          edgeOptions={defaultEdgeOptions}
          configs={graphConfig}
          centerContent
        />
        <GraphToolbar className="fdfd" items={[]}></GraphToolbar>
        <Minimap width={200} height={120} padding={8} position={{bottom: 12, right:12}} />
        <ScaleToolbar layout="vertical" position={{ top: 12, left: 12 }} />
      </X6Flow>
    </div>
  )
}

export default X6Editor
