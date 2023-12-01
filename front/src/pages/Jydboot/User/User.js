import React, { PureComponent } from 'react';
import { connect } from 'dva';
import { Button, Col, Form, Input, Row } from 'antd';
import Panel from '../../../components/Panel';
import { USER_LIST } from '../../../actions/user';
import Grid from '../../../components/Sword/Grid';

const FormItem = Form.Item;

@connect(({ user, loading }) => ({
  user,
  loading: loading.models.user,
}))
@Form.create()
class User extends PureComponent {
  // ============ 查询 ===============
  handleSearch = params => {
    const { dispatch } = this.props;
    dispatch(USER_LIST(params));
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
    const code = 'user';

    const {
      form,
      loading,
      user: { data },
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
        title: '账号',
        dataIndex: 'account',
      },
      {
        title: '密码',
        dataIndex: 'password',
      },
      {
        title: '手机号',
        dataIndex: 'telephone',
      },
      {
        title: '备注',
        dataIndex: 'mark',
      },
      {
        title: '头像',
        dataIndex: 'headerImage',
      },
      {
        title: '姓名',
        dataIndex: 'realName',
      },
      {
        title: '身份证',
        dataIndex: 'idNumber',
      },
      {
        title: '性别 1男2女0未知',
        dataIndex: 'sex',
      },
      {
        title: '昵称',
        dataIndex: 'nickName',
      },
      {
        title: '生日',
        dataIndex: 'birthday',
      },
      {
        title: '邮箱',
        dataIndex: 'email',
      },
      {
        title: '地址',
        dataIndex: 'address',
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
export default User;
