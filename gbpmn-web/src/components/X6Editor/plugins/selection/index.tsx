import React, { FC, useCallback, useEffect } from 'react'
import { Selection as X6Selection } from '@antv/x6-plugin-selection'
import { useGraph } from '../../hooks/graph'

export const Selection: FC<X6Selection.Options> = (props) => {
  const graph = useGraph()
  const initSelection = useCallback(() => {
    if (graph) {
      const selection = graph.getPlugin<X6Selection>(X6Selection.name)

      if (selection) {
        // TODO: add setOptions function to handle
        // selection.setOptions(options)
      } else {
        const xflowSelection = new X6Selection(props)

        graph.use(xflowSelection)
      }
    }
  }, [graph, props])

  useEffect(() => {
    initSelection()
  }, [graph])

  return <></>
}
