import React, { FC, ReactElement } from 'react'
import { Tooltip } from 'antd'
import classnames from 'classnames'
import style from './index.less'

export enum Direction {
  vertical = 'vertical',
  horizontal = 'horizontal',
}

export interface GraphToolbarItem {
  name: string
  text?: string
  tooltip: string
  disabled?: boolean
  icon: ReactElement
  onClick: () => void
}

export interface GraphToolbarProps {
  className: string
  items: GraphToolbarItem[]
  direction?: Direction
}

const ToolbarItem: FC<GraphToolbarItem> = (props) => {
  const { name, text, icon, disabled, onClick } = props

  return (
    <button
      key={name}
      disabled={disabled}
      onClick={() => disabled && onClick()}
      className={classnames(style.item, { [style.disabled]: disabled })}
    >
      {icon}
      {text}
    </button>
  )
}

export const GraphToolbar: FC<GraphToolbarProps> = (props) => {
  const { className, items, direction } = props

  return (
    <div
      className={classnames(className, style.graphToolbar, {
        [style.vertical]: direction === Direction.vertical,
        [style.horizontal]: direction === Direction.horizontal,
      })}
    >
      {items.map((item) =>
        item.tooltip ? (
          <Tooltip key={item.name} title={item.tooltip}>
            <ToolbarItem {...item} />
          </Tooltip>
        ) : (
          <ToolbarItem {...item} />
        ),
      )}
    </div>
  )
}
