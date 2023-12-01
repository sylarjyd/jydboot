import React, { PureComponent } from 'react';
import { Form, Input, Card, Button } from 'antd';
import { connect } from 'dva';
import Panel from '../../../components/Panel';
import styles from '../../../layouts/Sword.less';
import { SOCIALACCOUNT_SUBMIT } from '../../../actions/socialAccount';

const FormItem = Form.Item;

@connect(({ loading }) => ({
  submitting: loading.effects['socialAccount/submit'],
}))
@Form.create()
class SocialAccountAdd extends PureComponent {
  handleSubmit = e => {
    e.preventDefault();
    const { dispatch, form } = this.props;
    form.validateFieldsAndScroll((err, values) => {
      if (!err) {
        dispatch(SOCIALACCOUNT_SUBMIT(values));
      }
    });
  };

  render() {
    const {
      form: { getFieldDecorator },
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
      <Panel title="新增" back="/jydboot/socialAccount" action={action}>
        <Form hideRequiredMark style={{ marginTop: 8 }}>
          <Card className={styles.card} bordered={false}>
            <FormItem {...formItemLayout} label="主键">
              {getFieldDecorator('id', {
                rules: [
                  {
                    required: true,
                    message: '请输入主键',
                  },
                ],
              })(<Input placeholder="请输入主键" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="用户ID">
              {getFieldDecorator('userId', {
                rules: [
                  {
                    required: true,
                    message: '请输入用户ID',
                  },
                ],
              })(<Input placeholder="请输入用户ID" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="用户类型，1系统用户，2客户端用户">
              {getFieldDecorator('userType', {
                rules: [
                  {
                    required: true,
                    message: '请输入用户类型，1系统用户，2客户端用户',
                  },
                ],
              })(<Input placeholder="请输入用户类型，1系统用户，2客户端用户" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="社交应用类型，例如qq，weixin">
              {getFieldDecorator('socialCode', {
                rules: [
                  {
                    required: true,
                    message: '请输入社交应用类型，例如qq，weixin',
                  },
                ],
              })(<Input placeholder="请输入社交应用类型，例如qq，weixin" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="社交账号信息">
              {getFieldDecorator('socialAccount', {
                rules: [
                  {
                    required: true,
                    message: '请输入社交账号信息',
                  },
                ],
              })(<Input placeholder="请输入社交账号信息" />)}
            </FormItem>
          </Card>
        </Form>
      </Panel>
    );
  }
}

export default SocialAccountAdd;
