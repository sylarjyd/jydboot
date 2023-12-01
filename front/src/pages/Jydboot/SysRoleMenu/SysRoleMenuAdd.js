import React, { PureComponent } from 'react';
import { Form, Input, Card, Button } from 'antd';
import { connect } from 'dva';
import Panel from '../../../components/Panel';
import styles from '../../../layouts/Sword.less';
import { SYSROLEMENU_SUBMIT } from '../../../actions/sysRoleMenu';

const FormItem = Form.Item;

@connect(({ loading }) => ({
  submitting: loading.effects['sysRoleMenu/submit'],
}))
@Form.create()
class SysRoleMenuAdd extends PureComponent {
  handleSubmit = e => {
    e.preventDefault();
    const { dispatch, form } = this.props;
    form.validateFieldsAndScroll((err, values) => {
      if (!err) {
        dispatch(SYSROLEMENU_SUBMIT(values));
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
      <Panel title="新增" back="/jydboot/sysRoleMenu" action={action}>
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
            <FormItem {...formItemLayout} label="权限ID">
              {getFieldDecorator('menuId', {
                rules: [
                  {
                    required: true,
                    message: '请输入权限ID',
                  },
                ],
              })(<Input placeholder="请输入权限ID" />)}
            </FormItem>
          </Card>
        </Form>
      </Panel>
    );
  }
}

export default SysRoleMenuAdd;
