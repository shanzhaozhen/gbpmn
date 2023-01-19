import React from 'react'
import {CarryOutTwoTone} from "@ant-design/icons";
import {Space} from "antd";
import {useEmotionCss} from "@ant-design/use-emotion-css";

interface EndNodeProps {
  size?: {
    width: number;
    height: number
  } | undefined;
  data: any
}

const EndNode: React.FC<EndNodeProps> = (props) => {
  const { size = { width: 120, height: 40 }, data } = props
  const { width, height } = size
  const { label, stroke, fill, fontFill, fontSize } = data

  const endNodeClassName = useEmotionCss(() => ({
    position: 'relative',
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'center',
    padding: '10px 12px',
    overflow: 'hidden',
    background: '#fff',
    border: '1px solid #84b2e8',
    borderRadius: '20px',
    boxShadow: '0 1px 4px 0 rgba(0, 0, 0, 0.2)',
  }));

  return (
    <div
      className={endNodeClassName}
      style={{
        width,
        height,
        borderColor: stroke,
        backgroundColor: fill,
        color: fontFill,
        fontSize,
      }}
    >
      <Space>
        <CarryOutTwoTone />
        <span>{label}</span>
      </Space>
    </div>
  )
};

export default EndNode;

