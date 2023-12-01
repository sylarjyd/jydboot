import React, { PureComponent } from 'react';
import { Form, Input, Card, Button } from 'antd';
import { connect } from 'dva';
import Panel from '../../../components/Panel';
import styles from '../../../layouts/Sword.less';
import { AUDITLOG_DETAIL, AUDITLOG_SUBMIT } from '../../../actions/auditLog';

const FormItem = Form.Item;

@connect(({ auditLog, loading }) => ({
  auditLog,
  submitting: loading.effects['auditLog/submit'],
}))
@Form.create()
class AuditLogEdit extends PureComponent {
  componentWillMount() {
    const {
      dispatch,
      match: {
        params: { id },
      },
    } = this.props;
    dispatch(AUDITLOG_DETAIL(id));
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
        dispatch(AUDITLOG_SUBMIT(params));
      }
    });
  };

  render() {
    const {
      form: { getFieldDecorator },
      auditLog: { detail },
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
      <Panel title="修改" back="/jydboot/auditLog" action={action}>
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
            <FormItem {...formItemLayout} label="审核时间">
              {getFieldDecorator('createTime', {
                rules: [
                  {
                    required: true,
                    message: '请输入审核时间',
                  },
                ],
                initialValue: detail.createTime,
              })(<Input placeholder="请输入审核时间" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="审核人ID">
              {getFieldDecorator('createUser', {
                rules: [
                  {
                    required: true,
                    message: '请输入审核人ID',
                  },
                ],
                initialValue: detail.createUser,
              })(<Input placeholder="请输入审核人ID" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="审核人姓名">
              {getFieldDecorator('createUserName', {
                rules: [
                  {
                    required: true,
                    message: '请输入审核人姓名',
                  },
                ],
                initialValue: detail.createUserName,
              })(<Input placeholder="请输入审核人姓名" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="审核部门ID">
              {getFieldDecorator('createDept', {
                rules: [
                  {
                    required: true,
                    message: '请输入审核部门ID',
                  },
                ],
                initialValue: detail.createDept,
              })(<Input placeholder="请输入审核部门ID" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="审核部门名称">
              {getFieldDecorator('createDeptName', {
                rules: [
                  {
                    required: true,
                    message: '请输入审核部门名称',
                  },
                ],
                initialValue: detail.createDeptName,
              })(<Input placeholder="请输入审核部门名称" />)}
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
            <FormItem {...formItemLayout} label="审核状态1通过2不通过3退回">
              {getFieldDecorator('status', {
                rules: [
                  {
                    required: true,
                    message: '请输入审核状态1通过2不通过3退回',
                  },
                ],
                initialValue: detail.status,
              })(<Input placeholder="请输入审核状态1通过2不通过3退回" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="审核意见">
              {getFieldDecorator('remark', {
                rules: [
                  {
                    required: true,
                    message: '请输入审核意见',
                  },
                ],
                initialValue: detail.remark,
              })(<Input placeholder="请输入审核意见" />)}
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
          </Card>
        </Form>
      </Panel>
    );
  }
}

export default AuditLogEdit;
