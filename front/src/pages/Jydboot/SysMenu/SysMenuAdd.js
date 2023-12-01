import React, { PureComponent } from 'react';
import { Form, Input, Card, Button } from 'antd';
import { connect } from 'dva';
import Panel from '../../../components/Panel';
import styles from '../../../layouts/Sword.less';
import { SYSMENU_SUBMIT } from '../../../actions/sysMenu';

const FormItem = Form.Item;

@connect(({ loading }) => ({
  submitting: loading.effects['sysMenu/submit'],
}))
@Form.create()
class SysMenuAdd extends PureComponent {
  handleSubmit = e => {
    e.preventDefault();
    const { dispatch, form } = this.props;
    form.validateFieldsAndScroll((err, values) => {
      if (!err) {
        dispatch(SYSMENU_SUBMIT(values));
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
      <Panel title="新增" back="/jydboot/sysMenu" action={action}>
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
            <FormItem {...formItemLayout} label="权限编码">
              {getFieldDecorator('code', {
                rules: [
                  {
                    required: true,
                    message: '请输入权限编码',
                  },
                ],
              })(<Input placeholder="请输入权限编码" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="权限名称">
              {getFieldDecorator('name', {
                rules: [
                  {
                    required: true,
                    message: '请输入权限名称',
                  },
                ],
              })(<Input placeholder="请输入权限名称" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="路由">
              {getFieldDecorator('path', {
                rules: [
                  {
                    required: true,
                    message: '请输入路由',
                  },
                ],
              })(<Input placeholder="请输入路由" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="图标">
              {getFieldDecorator('source', {
                rules: [
                  {
                    required: true,
                    message: '请输入图标',
                  },
                ],
              })(<Input placeholder="请输入图标" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="备注">
              {getFieldDecorator('remark', {
                rules: [
                  {
                    required: true,
                    message: '请输入备注',
                  },
                ],
              })(<Input placeholder="请输入备注" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="序号">
              {getFieldDecorator('sort', {
                rules: [
                  {
                    required: true,
                    message: '请输入序号',
                  },
                ],
              })(<Input placeholder="请输入序号" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="1菜单2按钮3数据">
              {getFieldDecorator('category', {
                rules: [
                  {
                    required: true,
                    message: '请输入1菜单2按钮3数据',
                  },
                ],
              })(<Input placeholder="请输入1菜单2按钮3数据" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="父级ID">
              {getFieldDecorator('parentId', {
                rules: [
                  {
                    required: true,
                    message: '请输入父级ID',
                  },
                ],
              })(<Input placeholder="请输入父级ID" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="别名">
              {getFieldDecorator('alias', {
                rules: [
                  {
                    required: true,
                    message: '请输入别名',
                  },
                ],
              })(<Input placeholder="请输入别名" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="操作按钮类型">
              {getFieldDecorator('action', {
                rules: [
                  {
                    required: true,
                    message: '请输入操作按钮类型',
                  },
                ],
              })(<Input placeholder="请输入操作按钮类型" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="是否隐藏">
              {getFieldDecorator('isHidden', {
                rules: [
                  {
                    required: true,
                    message: '请输入是否隐藏',
                  },
                ],
              })(<Input placeholder="请输入是否隐藏" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="是否打开新页面">
              {getFieldDecorator('isOpen', {
                rules: [
                  {
                    required: true,
                    message: '请输入是否打开新页面',
                  },
                ],
              })(<Input placeholder="请输入是否打开新页面" />)}
            </FormItem>
          </Card>
        </Form>
      </Panel>
    );
  }
}

export default SysMenuAdd;
