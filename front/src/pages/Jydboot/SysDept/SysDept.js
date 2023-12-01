import React, { PureComponent } from 'react';
import { connect } from 'dva';
import { Button, Col, Form, Input, Row } from 'antd';
import Panel from '../../../components/Panel';
import { SYSDEPT_LIST } from '../../../actions/sysDept';
import Grid from '../../../components/Sword/Grid';

const FormItem = Form.Item;

@connect(({ sysDept, loading }) => ({
  sysDept,
  loading: loading.models.sysDept,
}))
@Form.create()
class SysDept extends PureComponent {
  // ============ 查询 ===============
  handleSearch = params => {
    const { dispatch } = this.props;
    dispatch(SYSDEPT_LIST(params));
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
    const code = 'sysDept';

    const {
      form,
      loading,
      sysDept: { data },
    } = this.props;

    const columns = [
      {
        title: 'ID',
        dataIndex: 'id',
      },
      {
        title: '创建时间',
        dataIndex: 'createTime',
      },
      {
        title: '更新时间',
        dataIndex: 'updateTime',
      },
      {
        title: '创建人',
        dataIndex: 'createUser',
      },
      {
        title: '更新人',
        dataIndex: 'updateUser',
      },
      {
        title: '状态 0正常 1锁定',
        dataIndex: 'status',
      },
      {
        title: '删除标记 0正常 1删除',
        dataIndex: 'deleted',
      },
      {
        title: '部门编码',
        dataIndex: 'deptCode',
      },
      {
        title: '部门名称',
        dataIndex: 'deptName',
      },
      {
        title: '备注',
        dataIndex: 'mark',
      },
      {
        title: '上级部门',
        dataIndex: 'parentId',
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
export default SysDept;
