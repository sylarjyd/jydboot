import React, { PureComponent } from 'react';
import { Form, Input, Card, Button } from 'antd';
import { connect } from 'dva';
import Panel from '../../../components/Panel';
import styles from '../../../layouts/Sword.less';
import { SYSROLEMENU_DETAIL, SYSROLEMENU_SUBMIT } from '../../../actions/sysRoleMenu';

const FormItem = Form.Item;

@connect(({ sysRoleMenu, loading }) => ({
  sysRoleMenu,
  submitting: loading.effects['sysRoleMenu/submit'],
}))
@Form.create()
class SysRoleMenuEdit extends PureComponent {
  componentWillMount() {
    const {
      dispatch,
      match: {
        params: { id },
      },
    } = this.props;
    dispatch(SYSROLEMENU_DETAIL(id));
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
        dispatch(SYSROLEMENU_SUBMIT(params));
      }
    });
  };

  render() {
    const {
      form: { getFieldDecorator },
      sysRoleMenu: { detail },
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
      <Panel title="修改" back="/jydboot/sysRoleMenu" action={action}>
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
            <FormItem {...formItemLayout} label="权限ID">
              {getFieldDecorator('menuId', {
                rules: [
                  {
                    required: true,
                    message: '请输入权限ID',
                  },
                ],
                initialValue: detail.menuId,
              })(<Input placeholder="请输入权限ID" />)}
            </FormItem>
          </Card>
        </Form>
      </Panel>
    );
  }
}

export default SysRoleMenuEdit;
