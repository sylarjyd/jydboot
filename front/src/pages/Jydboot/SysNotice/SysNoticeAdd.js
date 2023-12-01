import React, { PureComponent } from 'react';
import { Form, Input, Card, Button } from 'antd';
import { connect } from 'dva';
import Panel from '../../../components/Panel';
import styles from '../../../layouts/Sword.less';
import { SYSNOTICE_SUBMIT } from '../../../actions/sysNotice';

const FormItem = Form.Item;

@connect(({ loading }) => ({
  submitting: loading.effects['sysNotice/submit'],
}))
@Form.create()
class SysNoticeAdd extends PureComponent {
  handleSubmit = e => {
    e.preventDefault();
    const { dispatch, form } = this.props;
    form.validateFieldsAndScroll((err, values) => {
      if (!err) {
        dispatch(SYSNOTICE_SUBMIT(values));
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
      <Panel title="新增" back="/jydboot/sysNotice" action={action}>
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
              })(<Input placeholder="请输入删除标记 0正常 1删除" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="内容">
              {getFieldDecorator('content', {
                rules: [
                  {
                    required: true,
                    message: '请输入内容',
                  },
                ],
              })(<Input placeholder="请输入内容" />)}
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
            <FormItem {...formItemLayout} label="副标题">
              {getFieldDecorator('subTitle', {
                rules: [
                  {
                    required: true,
                    message: '请输入副标题',
                  },
                ],
              })(<Input placeholder="请输入副标题" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="发布人">
              {getFieldDecorator('postUser', {
                rules: [
                  {
                    required: true,
                    message: '请输入发布人',
                  },
                ],
              })(<Input placeholder="请输入发布人" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="发布时间">
              {getFieldDecorator('postTime', {
                rules: [
                  {
                    required: true,
                    message: '请输入发布时间',
                  },
                ],
              })(<Input placeholder="请输入发布时间" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="来源">
              {getFieldDecorator('source', {
                rules: [
                  {
                    required: true,
                    message: '请输入来源',
                  },
                ],
              })(<Input placeholder="请输入来源" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="类型1、新闻 2通知公告">
              {getFieldDecorator('type', {
                rules: [
                  {
                    required: true,
                    message: '请输入类型1、新闻 2通知公告',
                  },
                ],
              })(<Input placeholder="请输入类型1、新闻 2通知公告" />)}
            </FormItem>
          </Card>
        </Form>
      </Panel>
    );
  }
}

export default SysNoticeAdd;
