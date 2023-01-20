import React, { FC, useCallback, useEffect } from 'react'
import { Transform as X6Transform } from '@antv/x6-plugin-transform'
import { useGraph } from '../../hooks/graph'

export const Transform: FC<X6Transform.Options> = (props) => {
  const graph = useGraph()

  const initTransform = useCallback(() => {
    if (graph) {
      if (!graph.getPlugin<X6Transform>(X6Transform.name)) {
        const transform = new X6Transform(props)

        graph.use(transform)
      }
    } else {
      console.error('Transform has been initialized, can not initialize again!')
    }
  }, [graph, props])

  useEffect(() => {
    initTransform()
  }, [graph])

  return <></>
}
