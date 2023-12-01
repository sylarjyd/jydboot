import React, { PureComponent } from 'react';
import { connect } from 'dva';
import { Button, Col, Form, Input, Row } from 'antd';
import Panel from '../../../components/Panel';
import { MESSAGELOG_LIST } from '../../../actions/messageLog';
import Grid from '../../../components/Sword/Grid';

const FormItem = Form.Item;

@connect(({ messageLog, loading }) => ({
  messageLog,
  loading: loading.models.messageLog,
}))
@Form.create()
class MessageLog extends PureComponent {
  // ============ 查询 ===============
  handleSearch = params => {
    const { dispatch } = this.props;
    dispatch(MESSAGELOG_LIST(params));
  };

  // ============ 查询表单 ===============
  renderSearchForm = onReset => {
    const { form } = this.props;
    const { getFieldDecorator } = form;

    return (
      <Row gutter={{ md: 8, lg: 24, xl: 48 }}>
        <Col md={6} sm={24}>
          <FormItem label="查询名称">
            {getFieldDecorator('name')(<Input placeholder="查询名称" />)}
          </FormItem>
        </Col>
        <Col>
          <div style={{ float: 'right' }}>
            <Button type="primary" htmlType="submit">
              查询
            </Button>
            <Button style={{ marginLeft: 8 }} onClick={onReset}>
              重置
            </Button>
          </div>
        </Col>
      </Row>
    );
  };

  render() {
    const code = 'messageLog';

    const {
      form,
      loading,
      messageLog: { data },
    } = this.props;

    const columns = [
      {
        title: '主键',
        dataIndex: 'id',
      },
      {
        title: '创建时间',
        dataIndex: 'createTime',
      },
      {
        title: '创建人',
        dataIndex: 'createUser',
      },
      {
        title: '类型',
        dataIndex: 'type',
      },
      {
        title: '消息状态0成功1失败',
        dataIndex: 'status',
      },
      {
        title: '标题',
        dataIndex: 'title',
      },
      {
        title: '消息内容',
        dataIndex: 'content',
      },
      {
        title: '业务ID',
        dataIndex: 'businessId',
      },
      {
        title: '用户ID',
        dataIndex: 'userId',
      },
    ];

    return (
      <Panel>
        <Grid
          code={code}
          form={form}
          onSearch={this.handleSearch}
          renderSearchForm={this.renderSearchForm}
          loading={loading}
          data={data}
          columns={columns}
        />
      </Panel>
    );
  }
}
export default MessageLog;
