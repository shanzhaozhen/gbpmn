import React, {
  useContext,
  useRef,
  useEffect,
  FC,
  useLayoutEffect,
} from 'react'
import { Graph } from '@antv/x6'
import {GraphOptions} from "@/components/X6Editor/types";
import GraphContext from "@/components/X6Editor/GraphContext";
import {preprocess} from "@/components/X6Editor/util/model";

const XFlowGraph: FC<GraphOptions> = (props) => {
  const container = useRef<HTMLDivElement>(null)
  const { graph, setGraph } = useContext(GraphContext)

  useEffect(() => {
    const graph = new Graph({
      container: container.current!,
      autoResize: true,
      ...props.configs,
    })

    setGraph(graph)
  }, [])

  useLayoutEffect(() => {
    if (graph && props.data.length > 0) {
      const { data, defaultNodeOptions, defaultEdgeOptions, centerContent } =
        props
      const model = preprocess(
        data,
        defaultNodeOptions,
        defaultEdgeOptions,
      )
      graph.fromJSON(model)

      if (centerContent) {
        graph.centerContent()
      }
    }
  }, [graph, props.data])

  return (
    <div style={{ width: '100%', height: '100%' }}>
      <div ref={container} style={{ width: '100%', height: '100%' }} />
    </div>
  )
};

export default XFlowGraph;
