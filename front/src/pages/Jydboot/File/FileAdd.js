import React, { PureComponent } from 'react';
import { Form, Input, Card, Button } from 'antd';
import { connect } from 'dva';
import Panel from '../../../components/Panel';
import styles from '../../../layouts/Sword.less';
import { FILE_SUBMIT } from '../../../actions/file';

const FormItem = Form.Item;

@connect(({ loading }) => ({
  submitting: loading.effects['file/submit'],
}))
@Form.create()
class FileAdd extends PureComponent {
  handleSubmit = e => {
    e.preventDefault();
    const { dispatch, form } = this.props;
    form.validateFieldsAndScroll((err, values) => {
      if (!err) {
        dispatch(FILE_SUBMIT(values));
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
      <Panel title="新增" back="/jydboot/file" action={action}>
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
            <FormItem {...formItemLayout} label="资源编号">
              {getFieldDecorator('fileName', {
                rules: [
                  {
                    required: true,
                    message: '请输入资源编号',
                  },
                ],
              })(<Input placeholder="请输入资源编号" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="文件名称">
              {getFieldDecorator('originalName', {
                rules: [
                  {
                    required: true,
                    message: '请输入文件名称',
                  },
                ],
              })(<Input placeholder="请输入文件名称" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="文件类型后缀">
              {getFieldDecorator('fileType', {
                rules: [
                  {
                    required: true,
                    message: '请输入文件类型后缀',
                  },
                ],
              })(<Input placeholder="请输入文件类型后缀" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="文件大小KB">
              {getFieldDecorator('fileSize', {
                rules: [
                  {
                    required: true,
                    message: '请输入文件大小KB',
                  },
                ],
              })(<Input placeholder="请输入文件大小KB" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="是否需要鉴权，1是，0否，默认0">
              {getFieldDecorator('auth', {
                rules: [
                  {
                    required: true,
                    message: '请输入是否需要鉴权，1是，0否，默认0',
                  },
                ],
              })(<Input placeholder="请输入是否需要鉴权，1是，0否，默认0" />)}
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
            <FormItem {...formItemLayout} label="修改人">
              {getFieldDecorator('updateUser', {
                rules: [
                  {
                    required: true,
                    message: '请输入修改人',
                  },
                ],
              })(<Input placeholder="请输入修改人" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="修改时间">
              {getFieldDecorator('updateTime', {
                rules: [
                  {
                    required: true,
                    message: '请输入修改时间',
                  },
                ],
              })(<Input placeholder="请输入修改时间" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="状态">
              {getFieldDecorator('status', {
                rules: [
                  {
                    required: true,
                    message: '请输入状态',
                  },
                ],
              })(<Input placeholder="请输入状态" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="是否已删除">
              {getFieldDecorator('deleted', {
                rules: [
                  {
                    required: true,
                    message: '请输入是否已删除',
                  },
                ],
              })(<Input placeholder="请输入是否已删除" />)}
            </FormItem>
          </Card>
        </Form>
      </Panel>
    );
  }
}

export default FileAdd;
