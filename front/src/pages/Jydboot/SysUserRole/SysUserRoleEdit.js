import React, { PureComponent } from 'react';
import { Form, Input, Card, Button } from 'antd';
import { connect } from 'dva';
import Panel from '../../../components/Panel';
import styles from '../../../layouts/Sword.less';
import { SYSUSERROLE_DETAIL, SYSUSERROLE_SUBMIT } from '../../../actions/sysUserRole';

const FormItem = Form.Item;

@connect(({ sysUserRole, loading }) => ({
  sysUserRole,
  submitting: loading.effects['sysUserRole/submit'],
}))
@Form.create()
class SysUserRoleEdit extends PureComponent {
  componentWillMount() {
    const {
      dispatch,
      match: {
        params: { id },
      },
    } = this.props;
    dispatch(SYSUSERROLE_DETAIL(id));
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
        dispatch(SYSUSERROLE_SUBMIT(params));
      }
    });
  };

  render() {
    const {
      form: { getFieldDecorator },
      sysUserRole: { detail },
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
      <Panel title="修改" back="/jydboot/sysUserRole" action={action}>
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
            <FormItem {...formItemLayout} label="角色ID">
              {getFieldDecorator('roleId', {
                rules: [
                  {
                    required: true,
                    message: '请输入角色ID',
                  },
                ],
                initialValue: detail.roleId,
              })(<Input placeholder="请输入角色ID" />)}
            </FormItem>
          </Card>
        </Form>
      </Panel>
    );
  }
}

export default SysUserRoleEdit;
