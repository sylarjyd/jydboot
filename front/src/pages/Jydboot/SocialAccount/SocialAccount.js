import React, { PureComponent } from 'react';
import { connect } from 'dva';
import { Button, Col, Form, Input, Row } from 'antd';
import Panel from '../../../components/Panel';
import { SOCIALACCOUNT_LIST } from '../../../actions/socialAccount';
import Grid from '../../../components/Sword/Grid';

const FormItem = Form.Item;

@connect(({ socialAccount, loading }) => ({
  socialAccount,
  loading: loading.models.socialAccount,
}))
@Form.create()
class SocialAccount extends PureComponent {
  // ============ 查询 ===============
  handleSearch = params => {
    const { dispatch } = this.props;
    dispatch(SOCIALACCOUNT_LIST(params));
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
    const code = 'socialAccount';

    const {
      form,
      loading,
      socialAccount: { data },
    } = this.props;

    const columns = [
      {
        title: '主键',
        dataIndex: 'id',
      },
      {
        title: '用户ID',
        dataIndex: 'userId',
      },
      {
        title: '用户类型，1系统用户，2客户端用户',
        dataIndex: 'userType',
      },
      {
        title: '社交应用类型，例如qq，weixin',
        dataIndex: 'socialCode',
      },
      {
        title: '社交账号信息',
        dataIndex: 'socialAccount',
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
export default SocialAccount;
