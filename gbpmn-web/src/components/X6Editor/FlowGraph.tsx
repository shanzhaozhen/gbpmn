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
      panning: true,
      mousewheel: true,
      ...props.configs,
    })

    setGraph(graph)
  }, [])

  useLayoutEffect(() => {
    if (graph && props.data.length > 0) {
      const { data, nodeOptions, edgeOptions, centerContent } = props
      const model = preprocess(
        data,
        nodeOptions,
        edgeOptions,
      )
      graph.fromJSON(model)

      if (centerContent) {
        graph.centerContent()
      }
    }
  }, [graph, props.data])

  return (
    <div className="app-content" ref={container}/>
  )
};

export default XFlowGraph;
