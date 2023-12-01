import React, { PureComponent } from 'react';
import { connect } from 'dva';
import { Button, Col, Form, Input, Row } from 'antd';
import Panel from '../../../components/Panel';
import { AUDITLOG_LIST } from '../../../actions/auditLog';
import Grid from '../../../components/Sword/Grid';

const FormItem = Form.Item;

@connect(({ auditLog, loading }) => ({
  auditLog,
  loading: loading.models.auditLog,
}))
@Form.create()
class AuditLog extends PureComponent {
  // ============ 查询 ===============
  handleSearch = params => {
    const { dispatch } = this.props;
    dispatch(AUDITLOG_LIST(params));
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
    const code = 'auditLog';

    const {
      form,
      loading,
      auditLog: { data },
    } = this.props;

    const columns = [
      {
        title: '主键',
        dataIndex: 'id',
      },
      {
        title: '审核时间',
        dataIndex: 'createTime',
      },
      {
        title: '审核人ID',
        dataIndex: 'createUser',
      },
      {
        title: '审核人姓名',
        dataIndex: 'createUserName',
      },
      {
        title: '审核部门ID',
        dataIndex: 'createDept',
      },
      {
        title: '审核部门名称',
        dataIndex: 'createDeptName',
      },
      {
        title: '类型',
        dataIndex: 'type',
      },
      {
        title: '审核状态1通过2不通过3退回',
        dataIndex: 'status',
      },
      {
        title: '审核意见',
        dataIndex: 'remark',
      },
      {
        title: '业务ID',
        dataIndex: 'businessId',
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
export default AuditLog;
