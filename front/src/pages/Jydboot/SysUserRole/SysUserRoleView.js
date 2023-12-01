import React, { PureComponent } from 'react';
import router from 'umi/router';
import { Form, Card, Button } from 'antd';
import { connect } from 'dva';
import Panel from '../../../components/Panel';
import styles from '../../../layouts/Sword.less';
import { SYSUSERROLE_DETAIL } from '../../../actions/sysUserRole';

const FormItem = Form.Item;

@connect(({ sysUserRole }) => ({
  sysUserRole,
}))
@Form.create()
class SysUserRoleView extends PureComponent {
  componentWillMount() {
    const {
      dispatch,
      match: {
        params: { id },
      },
    } = this.props;
    dispatch(SYSUSERROLE_DETAIL(id));
  }

  handleEdit = () => {
    const {
      match: {
        params: { id },
      },
    } = this.props;
    router.push(`/jydboot/sysUserRole/edit/${id}`);
  };

  render() {
    const {
      sysUserRole: { detail },
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
      <Button type="primary" onClick={this.handleEdit}>
        修改
      </Button>
    );

    return (
      <Panel title="查看" back="/jydboot/sysUserRole" action={action}>
        <Form hideRequiredMark style={{ marginTop: 8 }}>
          <Card className={styles.card} bordered={false}>
            <FormItem {...formItemLayout} label="ID">
              <span>{detail.id}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="用户ID">
              <span>{detail.userId}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="角色ID">
              <span>{detail.roleId}</span>
            </FormItem>
          </Card>
        </Form>
      </Panel>
    );
  }
}
export default SysUserRoleView;
