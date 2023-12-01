import React, { PureComponent } from 'react';
import { Form, Input, Card, Button } from 'antd';
import { connect } from 'dva';
import Panel from '../../../components/Panel';
import styles from '../../../layouts/Sword.less';
import { FILE_DETAIL, FILE_SUBMIT } from '../../../actions/file';

const FormItem = Form.Item;

@connect(({ file, loading }) => ({
  file,
  submitting: loading.effects['file/submit'],
}))
@Form.create()
class FileEdit extends PureComponent {
  componentWillMount() {
    const {
      dispatch,
      match: {
        params: { id },
      },
    } = this.props;
    dispatch(FILE_DETAIL(id));
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
        dispatch(FILE_SUBMIT(params));
      }
    });
  };

  render() {
    const {
      form: { getFieldDecorator },
      file: { detail },
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
      <Panel title="修改" back="/jydboot/file" action={action}>
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
            <FormItem {...formItemLayout} label="资源编号">
              {getFieldDecorator('fileName', {
                rules: [
                  {
                    required: true,
                    message: '请输入资源编号',
                  },
                ],
                initialValue: detail.fileName,
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
                initialValue: detail.originalName,
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
                initialValue: detail.fileType,
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
                initialValue: detail.fileSize,
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
                initialValue: detail.auth,
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
                initialValue: detail.createUser,
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
                initialValue: detail.createTime,
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
                initialValue: detail.updateUser,
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
                initialValue: detail.updateTime,
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
                initialValue: detail.status,
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
                initialValue: detail.deleted,
              })(<Input placeholder="请输入是否已删除" />)}
            </FormItem>
          </Card>
        </Form>
      </Panel>
    );
  }
}

export default FileEdit;
