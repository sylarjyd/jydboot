import React, { PureComponent } from 'react';
import { connect } from 'dva';
import { Button, Col, Form, Input, Row } from 'antd';
import Panel from '../../../components/Panel';
import { SYSMENU_LIST } from '../../../actions/sysMenu';
import Grid from '../../../components/Sword/Grid';

const FormItem = Form.Item;

@connect(({ sysMenu, loading }) => ({
  sysMenu,
  loading: loading.models.sysMenu,
}))
@Form.create()
class SysMenu extends PureComponent {
  // ============ 查询 ===============
  handleSearch = params => {
    const { dispatch } = this.props;
    dispatch(SYSMENU_LIST(params));
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
    const code = 'sysMenu';

    const {
      form,
      loading,
      sysMenu: { data },
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
        title: '权限编码',
        dataIndex: 'code',
      },
      {
        title: '权限名称',
        dataIndex: 'name',
      },
      {
        title: '路由',
        dataIndex: 'path',
      },
      {
        title: '图标',
        dataIndex: 'source',
      },
      {
        title: '备注',
        dataIndex: 'remark',
      },
      {
        title: '序号',
        dataIndex: 'sort',
      },
      {
        title: '1菜单2按钮3数据',
        dataIndex: 'category',
      },
      {
        title: '父级ID',
        dataIndex: 'parentId',
      },
      {
        title: '别名',
        dataIndex: 'alias',
      },
      {
        title: '操作按钮类型',
        dataIndex: 'action',
      },
      {
        title: '是否隐藏',
        dataIndex: 'isHidden',
      },
      {
        title: '是否打开新页面',
        dataIndex: 'isOpen',
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
export default SysMenu;
