import React, { PureComponent } from 'react';
import { Form, Input, Card, Button } from 'antd';
import { connect } from 'dva';
import Panel from '../../../components/Panel';
import styles from '../../../layouts/Sword.less';
import { SYSROLE_SUBMIT } from '../../../actions/sysRole';

const FormItem = Form.Item;

@connect(({ loading }) => ({
  submitting: loading.effects['sysRole/submit'],
}))
@Form.create()
class SysRoleAdd extends PureComponent {
  handleSubmit = e => {
    e.preventDefault();
    const { dispatch, form } = this.props;
    form.validateFieldsAndScroll((err, values) => {
      if (!err) {
        dispatch(SYSROLE_SUBMIT(values));
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
      <Panel title="新增" back="/jydboot/sysRole" action={action}>
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
            <FormItem {...formItemLayout} label="角色名称">
              {getFieldDecorator('roleName', {
                rules: [
                  {
                    required: true,
                    message: '请输入角色名称',
                  },
                ],
              })(<Input placeholder="请输入角色名称" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="备注">
              {getFieldDecorator('mark', {
                rules: [
                  {
                    required: true,
                    message: '请输入备注',
                  },
                ],
              })(<Input placeholder="请输入备注" />)}
            </FormItem>
          </Card>
        </Form>
      </Panel>
    );
  }
}

export default SysRoleAdd;
