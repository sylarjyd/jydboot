import React, { PureComponent } from 'react';
import { Form, Input, Card, Button } from 'antd';
import { connect } from 'dva';
import Panel from '../../../components/Panel';
import styles from '../../../layouts/Sword.less';
import { SYSLOG_SUBMIT } from '../../../actions/sysLog';

const FormItem = Form.Item;

@connect(({ loading }) => ({
  submitting: loading.effects['sysLog/submit'],
}))
@Form.create()
class SysLogAdd extends PureComponent {
  handleSubmit = e => {
    e.preventDefault();
    const { dispatch, form } = this.props;
    form.validateFieldsAndScroll((err, values) => {
      if (!err) {
        dispatch(SYSLOG_SUBMIT(values));
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
      <Panel title="新增" back="/jydboot/sysLog" action={action}>
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
            <FormItem {...formItemLayout} label="服务器IP地址">
              {getFieldDecorator('serverIp', {
                rules: [
                  {
                    required: true,
                    message: '请输入服务器IP地址',
                  },
                ],
              })(<Input placeholder="请输入服务器IP地址" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="操作地址ip">
              {getFieldDecorator('remoteIp', {
                rules: [
                  {
                    required: true,
                    message: '请输入操作地址ip',
                  },
                ],
              })(<Input placeholder="请输入操作地址ip" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="服务名称">
              {getFieldDecorator('serviceName', {
                rules: [
                  {
                    required: true,
                    message: '请输入服务名称',
                  },
                ],
              })(<Input placeholder="请输入服务名称" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="系统模块">
              {getFieldDecorator('optModule', {
                rules: [
                  {
                    required: true,
                    message: '请输入系统模块',
                  },
                ],
              })(<Input placeholder="请输入系统模块" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="操作类型">
              {getFieldDecorator('optType', {
                rules: [
                  {
                    required: true,
                    message: '请输入操作类型',
                  },
                ],
              })(<Input placeholder="请输入操作类型" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="日志类型1管理端2门户3移动端">
              {getFieldDecorator('type', {
                rules: [
                  {
                    required: true,
                    message: '请输入日志类型1管理端2门户3移动端',
                  },
                ],
              })(<Input placeholder="请输入日志类型1管理端2门户3移动端" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="请求方法">
              {getFieldDecorator('method', {
                rules: [
                  {
                    required: true,
                    message: '请输入请求方法',
                  },
                ],
              })(<Input placeholder="请输入请求方法" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="请求路径">
              {getFieldDecorator('requestUri', {
                rules: [
                  {
                    required: true,
                    message: '请输入请求路径',
                  },
                ],
              })(<Input placeholder="请输入请求路径" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="返回结果">
              {getFieldDecorator('response', {
                rules: [
                  {
                    required: true,
                    message: '请输入返回结果',
                  },
                ],
              })(<Input placeholder="请输入返回结果" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="方法名">
              {getFieldDecorator('methodName', {
                rules: [
                  {
                    required: true,
                    message: '请输入方法名',
                  },
                ],
              })(<Input placeholder="请输入方法名" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="方法类">
              {getFieldDecorator('methodClass', {
                rules: [
                  {
                    required: true,
                    message: '请输入方法类',
                  },
                ],
              })(<Input placeholder="请输入方法类" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="操作提交的数据">
              {getFieldDecorator('params', {
                rules: [
                  {
                    required: true,
                    message: '请输入操作提交的数据',
                  },
                ],
              })(<Input placeholder="请输入操作提交的数据" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="操作状态0成功1失败">
              {getFieldDecorator('status', {
                rules: [
                  {
                    required: true,
                    message: '请输入操作状态0成功1失败',
                  },
                ],
              })(<Input placeholder="请输入操作状态0成功1失败" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="创建者">
              {getFieldDecorator('createUser', {
                rules: [
                  {
                    required: true,
                    message: '请输入创建者',
                  },
                ],
              })(<Input placeholder="请输入创建者" />)}
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
          </Card>
        </Form>
      </Panel>
    );
  }
}

export default SysLogAdd;
