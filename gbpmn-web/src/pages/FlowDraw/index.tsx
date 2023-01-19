import {
  PageContainer,
} from '@ant-design/pro-components';
import React from 'react';
import DAGEditor from "@/components/DAGEditor/basic";
import FlowEditor from "@/components/FlowEditor";
import X6Editor from "@/components/X6Editor";

const FlowDraw: React.FC = () => {

  return (
    <PageContainer>
      {/*<FlowEditor meta={{flowId: 'ddd'}}/>*/}
      {/*<DAGEditor meta={{flowId: 'ddd'}}/>*/}
      <X6Editor meta={{flowId: 'ddd'}}/>
    </PageContainer>
  );
};

export default FlowDraw;
