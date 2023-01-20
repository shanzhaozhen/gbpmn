import React, { FC, useCallback, useEffect } from 'react'
import { Snapline as X6Snapline } from '@antv/x6-plugin-snapline'
import { useGraph } from '../../hooks/graph'

export const Snapline: FC<X6Snapline.Options> = (props) => {
  const graph = useGraph()

  const initSnapline = useCallback(() => {
    if (graph) {
      const snapline = graph.getPlugin<X6Snapline>(X6Snapline.name)

      if (snapline) {
        // TODO: add setOption function
        // snapline.setOption(props)
      } else {
        const graphSnapline = new X6Snapline(props)

        graph.use(graphSnapline)
      }
    }
  }, [graph, props])

  useEffect(() => {
    initSnapline()
  }, [graph])

  return <></>
}
