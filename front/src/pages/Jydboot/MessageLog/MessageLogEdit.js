import React, { PureComponent } from 'react';
import { Form, Input, Card, Button } from 'antd';
import { connect } from 'dva';
import Panel from '../../../components/Panel';
import styles from '../../../layouts/Sword.less';
import { MESSAGELOG_DETAIL, MESSAGELOG_SUBMIT } from '../../../actions/messageLog';

const FormItem = Form.Item;

@connect(({ messageLog, loading }) => ({
  messageLog,
  submitting: loading.effects['messageLog/submit'],
}))
@Form.create()
class MessageLogEdit extends PureComponent {
  componentWillMount() {
    const {
      dispatch,
      match: {
        params: { id },
      },
    } = this.props;
    dispatch(MESSAGELOG_DETAIL(id));
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
        dispatch(MESSAGELOG_SUBMIT(params));
      }
    });
  };

  render() {
    const {
      form: { getFieldDecorator },
      messageLog: { detail },
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
      <Panel title="修改" back="/jydboot/messageLog" action={action}>
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
                initialValue: detail.id,
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
                initialValue: detail.createTime,
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
                initialValue: detail.createUser,
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
                initialValue: detail.type,
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
                initialValue: detail.status,
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
                initialValue: detail.title,
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
                initialValue: detail.content,
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
                initialValue: detail.businessId,
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
                initialValue: detail.userId,
              })(<Input placeholder="请输入用户ID" />)}
            </FormItem>
          </Card>
        </Form>
      </Panel>
    );
  }
}

export default MessageLogEdit;
