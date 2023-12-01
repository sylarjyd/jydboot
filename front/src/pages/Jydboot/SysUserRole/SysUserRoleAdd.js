import React, { PureComponent } from 'react';
import { Form, Input, Card, Button } from 'antd';
import { connect } from 'dva';
import Panel from '../../../components/Panel';
import styles from '../../../layouts/Sword.less';
import { SYSUSERROLE_SUBMIT } from '../../../actions/sysUserRole';

const FormItem = Form.Item;

@connect(({ loading }) => ({
  submitting: loading.effects['sysUserRole/submit'],
}))
@Form.create()
class SysUserRoleAdd extends PureComponent {
  handleSubmit = e => {
    e.preventDefault();
    const { dispatch, form } = this.props;
    form.validateFieldsAndScroll((err, values) => {
      if (!err) {
        dispatch(SYSUSERROLE_SUBMIT(values));
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
      <Panel title="新增" back="/jydboot/sysUserRole" action={action}>
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
            <FormItem {...formItemLayout} label="角色ID">
              {getFieldDecorator('roleId', {
                rules: [
                  {
                    required: true,
                    message: '请输入角色ID',
                  },
                ],
              })(<Input placeholder="请输入角色ID" />)}
            </FormItem>
          </Card>
        </Form>
      </Panel>
    );
  }
}

export default SysUserRoleAdd;
