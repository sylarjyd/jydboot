import React, { PureComponent } from 'react';
import { Form, Input, Card, Button } from 'antd';
import { connect } from 'dva';
import Panel from '../../../components/Panel';
import styles from '../../../layouts/Sword.less';
import { MESSAGELOG_SUBMIT } from '../../../actions/messageLog';

const FormItem = Form.Item;

@connect(({ loading }) => ({
  submitting: loading.effects['messageLog/submit'],
}))
@Form.create()
class MessageLogAdd extends PureComponent {
  handleSubmit = e => {
    e.preventDefault();
    const { dispatch, form } = this.props;
    form.validateFieldsAndScroll((err, values) => {
      if (!err) {
        dispatch(MESSAGELOG_SUBMIT(values));
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
      <Panel title="新增" back="/jydboot/messageLog" action={action}>
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
            <FormItem {...formItemLayout} label="创建时间">
              {getFieldDecorator('createTime', {
                rules: [
                  {
                    required: true,
                    message: '请输入创建时间',
                  },
                ],
              })(<Input placeholder="请输入创建时间" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="创建人">
              {getFieldDecorator('createUser', {
                rules: [
                  {
                    required: true,
                    message: '请输入创建人',
                  },
                ],
              })(<Input placeholder="请输入创建人" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="类型">
              {getFieldDecorator('type', {
                rules: [
                  {
                    required: true,
                    message: '请输入类型',
                  },
                ],
              })(<Input placeholder="请输入类型" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="消息状态0成功1失败">
              {getFieldDecorator('status', {
                rules: [
                  {
                    required: true,
                    message: '请输入消息状态0成功1失败',
                  },
                ],
              })(<Input placeholder="请输入消息状态0成功1失败" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="标题">
              {getFieldDecorator('title', {
                rules: [
                  {
                    required: true,
                    message: '请输入标题',
                  },
                ],
              })(<Input placeholder="请输入标题" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="消息内容">
              {getFieldDecorator('content', {
                rules: [
                  {
                    required: true,
                    message: '请输入消息内容',
                  },
                ],
              })(<Input placeholder="请输入消息内容" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="业务ID">
              {getFieldDecorator('businessId', {
                rules: [
                  {
                    required: true,
                    message: '请输入业务ID',
                  },
                ],
              })(<Input placeholder="请输入业务ID" />)}
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
          </Card>
        </Form>
      </Panel>
    );
  }
}

export default MessageLogAdd;
