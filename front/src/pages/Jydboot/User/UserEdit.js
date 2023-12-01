import React, { PureComponent } from 'react';
import { Form, Input, Card, Button } from 'antd';
import { connect } from 'dva';
import Panel from '../../../components/Panel';
import styles from '../../../layouts/Sword.less';
import { USER_DETAIL, USER_SUBMIT } from '../../../actions/user';

const FormItem = Form.Item;

@connect(({ user, loading }) => ({
  user,
  submitting: loading.effects['user/submit'],
}))
@Form.create()
class UserEdit extends PureComponent {
  componentWillMount() {
    const {
      dispatch,
      match: {
        params: { id },
      },
    } = this.props;
    dispatch(USER_DETAIL(id));
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
        dispatch(USER_SUBMIT(params));
      }
    });
  };

  render() {
    const {
      form: { getFieldDecorator },
      user: { detail },
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
      <Panel title="修改" back="/jydboot/user" action={action}>
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
            <FormItem {...formItemLayout} label="姓名">
              {getFieldDecorator('realName', {
                rules: [
                  {
                    required: true,
                    message: '请输入姓名',
                  },
                ],
                initialValue: detail.realName,
              })(<Input placeholder="请输入姓名" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="身份证">
              {getFieldDecorator('idNumber', {
                rules: [
                  {
                    required: true,
                    message: '请输入身份证',
                  },
                ],
                initialValue: detail.idNumber,
              })(<Input placeholder="请输入身份证" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="性别 1男2女0未知">
              {getFieldDecorator('sex', {
                rules: [
                  {
                    required: true,
                    message: '请输入性别 1男2女0未知',
                  },
                ],
                initialValue: detail.sex,
              })(<Input placeholder="请输入性别 1男2女0未知" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="昵称">
              {getFieldDecorator('nickName', {
                rules: [
                  {
                    required: true,
                    message: '请输入昵称',
                  },
                ],
                initialValue: detail.nickName,
              })(<Input placeholder="请输入昵称" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="生日">
              {getFieldDecorator('birthday', {
                rules: [
                  {
                    required: true,
                    message: '请输入生日',
                  },
                ],
                initialValue: detail.birthday,
              })(<Input placeholder="请输入生日" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="邮箱">
              {getFieldDecorator('email', {
                rules: [
                  {
                    required: true,
                    message: '请输入邮箱',
                  },
                ],
                initialValue: detail.email,
              })(<Input placeholder="请输入邮箱" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="地址">
              {getFieldDecorator('address', {
                rules: [
                  {
                    required: true,
                    message: '请输入地址',
                  },
                ],
                initialValue: detail.address,
              })(<Input placeholder="请输入地址" />)}
            </FormItem>
          </Card>
        </Form>
      </Panel>
    );
  }
}

export default UserEdit;
