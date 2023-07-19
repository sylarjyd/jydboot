import React, { PureComponent } from 'react';
import { Form, Input, Card, Button } from 'antd';
import { connect } from 'dva';
import Panel from '../../../components/Panel';
import styles from '../../../layouts/Sword.less';
import { PORTALUSER_DETAIL, PORTALUSER_SUBMIT } from '../../../actions/portalUser';

const FormItem = Form.Item;

@connect(({ portalUser, loading }) => ({
  portalUser,
  submitting: loading.effects['portalUser/submit'],
}))
@Form.create()
class PortalUserEdit extends PureComponent {
  componentWillMount() {
    const {
      dispatch,
      match: {
        params: { id },
      },
    } = this.props;
    dispatch(PORTALUSER_DETAIL(id));
  }

  handleSubmit = e => {
    e.preventDefault();
    const {
      dispatch,
      match: {
        params: { id },
      },
      form,
    } = this.props;
    form.validateFieldsAndScroll((err, values) => {
      if (!err) {
        const params = {
          id,
          ...values,
        };
        console.log(params);
        dispatch(PORTALUSER_SUBMIT(params));
      }
    });
  };

  render() {
    const {
      form: { getFieldDecorator },
      portalUser: { detail },
      submitting,
    } = this.props;

    const formItemLayout = {
      labelCol: {
        xs: { span: 24 },
        sm: { span: 7 },
      },
      wrapperCol: {
        xs: { span: 24 },
        sm: { span: 12 },
        md: { span: 10 },
      },
    };

    const action = (
      <Button type="primary" onClick={this.handleSubmit} loading={submitting}>
        提交
      </Button>
    );

    return (
      <Panel title="修改" back="/jydboot/portalUser" action={action}>
        <Form hideRequiredMark style={{ marginTop: 8 }}>
          <Card className={styles.card} bordered={false}>
            <FormItem {...formItemLayout} label="ID">
              {getFieldDecorator('id', {
                rules: [
                  {
                    required: true,
                    message: '请输入ID',
                  },
                ],
                initialValue: detail.id,
              })(<Input placeholder="请输入ID" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="创建时间">
              {getFieldDecorator('createTime', {
                rules: [
                  {
                    required: true,
                    message: '请输入创建时间',
                  },
                ],
                initialValue: detail.createTime,
              })(<Input placeholder="请输入创建时间" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="更新时间">
              {getFieldDecorator('updateTime', {
                rules: [
                  {
                    required: true,
                    message: '请输入更新时间',
                  },
                ],
                initialValue: detail.updateTime,
              })(<Input placeholder="请输入更新时间" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="创建人">
              {getFieldDecorator('createUser', {
                rules: [
                  {
                    required: true,
                    message: '请输入创建人',
                  },
                ],
                initialValue: detail.createUser,
              })(<Input placeholder="请输入创建人" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="更新人">
              {getFieldDecorator('updateUser', {
                rules: [
                  {
                    required: true,
                    message: '请输入更新人',
                  },
                ],
                initialValue: detail.updateUser,
              })(<Input placeholder="请输入更新人" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="状态 0正常 1锁定">
              {getFieldDecorator('status', {
                rules: [
                  {
                    required: true,
                    message: '请输入状态 0正常 1锁定',
                  },
                ],
                initialValue: detail.status,
              })(<Input placeholder="请输入状态 0正常 1锁定" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="删除标记 0正常 1删除">
              {getFieldDecorator('deleted', {
                rules: [
                  {
                    required: true,
                    message: '请输入删除标记 0正常 1删除',
                  },
                ],
                initialValue: detail.deleted,
              })(<Input placeholder="请输入删除标记 0正常 1删除" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="账号">
              {getFieldDecorator('account', {
                rules: [
                  {
                    required: true,
                    message: '请输入账号',
                  },
                ],
                initialValue: detail.account,
              })(<Input placeholder="请输入账号" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="密码">
              {getFieldDecorator('password', {
                rules: [
                  {
                    required: true,
                    message: '请输入密码',
                  },
                ],
                initialValue: detail.password,
              })(<Input placeholder="请输入密码" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="手机号">
              {getFieldDecorator('telephone', {
                rules: [
                  {
                    required: true,
                    message: '请输入手机号',
                  },
                ],
                initialValue: detail.telephone,
              })(<Input placeholder="请输入手机号" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="备注">
              {getFieldDecorator('mark', {
                rules: [
                  {
                    required: true,
                    message: '请输入备注',
                  },
                ],
                initialValue: detail.mark,
              })(<Input placeholder="请输入备注" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="头像">
              {getFieldDecorator('headerImage', {
                rules: [
                  {
                    required: true,
                    message: '请输入头像',
                  },
                ],
                initialValue: detail.headerImage,
              })(<Input placeholder="请输入头像" />)}
            </FormItem>
          </Card>
        </Form>
      </Panel>
    );
  }
}

export default PortalUserEdit;
