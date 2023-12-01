import React, { PureComponent } from 'react';
import router from 'umi/router';
import { Form, Card, Button } from 'antd';
import { connect } from 'dva';
import Panel from '../../../components/Panel';
import styles from '../../../layouts/Sword.less';
import { SOCIALACCOUNT_DETAIL } from '../../../actions/socialAccount';

const FormItem = Form.Item;

@connect(({ socialAccount }) => ({
  socialAccount,
}))
@Form.create()
class SocialAccountView extends PureComponent {
  componentWillMount() {
    const {
      dispatch,
      match: {
        params: { id },
      },
    } = this.props;
    dispatch(SOCIALACCOUNT_DETAIL(id));
  }

  handleEdit = () => {
    const {
      match: {
        params: { id },
      },
    } = this.props;
    router.push(`/jydboot/socialAccount/edit/${id}`);
  };

  render() {
    const {
      socialAccount: { detail },
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
      <Panel title="查看" back="/jydboot/socialAccount" action={action}>
        <Form hideRequiredMark style={{ marginTop: 8 }}>
          <Card className={styles.card} bordered={false}>
            <FormItem {...formItemLayout} label="主键">
              <span>{detail.id}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="用户ID">
              <span>{detail.userId}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="用户类型，1系统用户，2客户端用户">
              <span>{detail.userType}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="社交应用类型，例如qq，weixin">
              <span>{detail.socialCode}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="社交账号信息">
              <span>{detail.socialAccount}</span>
            </FormItem>
          </Card>
        </Form>
      </Panel>
    );
  }
}
export default SocialAccountView;
