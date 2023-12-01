import React, { PureComponent } from 'react';
import router from 'umi/router';
import { Form, Card, Button } from 'antd';
import { connect } from 'dva';
import Panel from '../../../components/Panel';
import styles from '../../../layouts/Sword.less';
import { SYSUSER_DETAIL } from '../../../actions/sysUser';

const FormItem = Form.Item;

@connect(({ sysUser }) => ({
  sysUser,
}))
@Form.create()
class SysUserView extends PureComponent {
  componentWillMount() {
    const {
      dispatch,
      match: {
        params: { id },
      },
    } = this.props;
    dispatch(SYSUSER_DETAIL(id));
  }

  handleEdit = () => {
    const {
      match: {
        params: { id },
      },
    } = this.props;
    router.push(`/jydboot/sysUser/edit/${id}`);
  };

  render() {
    const {
      sysUser: { detail },
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
      <Panel title="查看" back="/jydboot/sysUser" action={action}>
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
            <FormItem {...formItemLayout} label="姓名">
              <span>{detail.realName}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="身份证">
              <span>{detail.idNumber}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="性别 1男2女0未知">
              <span>{detail.sex}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="昵称">
              <span>{detail.nickName}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="生日">
              <span>{detail.birthday}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="邮箱">
              <span>{detail.email}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="地址">
              <span>{detail.address}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="部门ID">
              <span>{detail.deptId}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="岗位ID">
              <span>{detail.postId}</span>
            </FormItem>
          </Card>
        </Form>
      </Panel>
    );
  }
}
export default SysUserView;
