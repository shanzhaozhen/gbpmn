import {
  PageContainer,
} from '@ant-design/pro-components';
import React from 'react';
import X6Editor from "@/components/X6Editor";

const FlowDraw: React.FC = () => {

  return (
    <PageContainer>
      {/*<FlowEditor meta={{flowId: 'ddd'}}/>*/}
      {/*<DAGEditor meta={{flowId: 'ddd'}}/>*/}
      <X6Editor/>
    </PageContainer>
  );
};

export default FlowDraw;
