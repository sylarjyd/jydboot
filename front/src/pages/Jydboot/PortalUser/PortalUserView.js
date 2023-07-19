import React, { PureComponent } from 'react';
import router from 'umi/router';
import { Form, Card, Button } from 'antd';
import { connect } from 'dva';
import Panel from '../../../components/Panel';
import styles from '../../../layouts/Sword.less';
import { PORTALUSER_DETAIL } from '../../../actions/portalUser';

const FormItem = Form.Item;

@connect(({ portalUser }) => ({
  portalUser,
}))
@Form.create()
class PortalUserView extends PureComponent {
  componentWillMount() {
    const {
      dispatch,
      match: {
        params: { id },
      },
    } = this.props;
    dispatch(PORTALUSER_DETAIL(id));
  }

  handleEdit = () => {
    const {
      match: {
        params: { id },
      },
    } = this.props;
    router.push(`/jydboot/portalUser/edit/${id}`);
  };

  render() {
    const {
      portalUser: { detail },
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
      <Panel title="查看" back="/jydboot/portalUser" action={action}>
        <Form hideRequiredMark style={{ marginTop: 8 }}>
          <Card className={styles.card} bordered={false}>
            <FormItem {...formItemLayout} label="ID">
              <span>{detail.id}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="创建时间">
              <span>{detail.createTime}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="更新时间">
              <span>{detail.updateTime}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="创建人">
              <span>{detail.createUser}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="更新人">
              <span>{detail.updateUser}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="状态 0正常 1锁定">
              <span>{detail.status}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="删除标记 0正常 1删除">
              <span>{detail.deleted}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="账号">
              <span>{detail.account}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="密码">
              <span>{detail.password}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="手机号">
              <span>{detail.telephone}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="备注">
              <span>{detail.mark}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="头像">
              <span>{detail.headerImage}</span>
            </FormItem>
          </Card>
        </Form>
      </Panel>
    );
  }
}
export default PortalUserView;
