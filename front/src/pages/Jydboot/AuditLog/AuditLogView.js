import React, { PureComponent } from 'react';
import router from 'umi/router';
import { Form, Card, Button } from 'antd';
import { connect } from 'dva';
import Panel from '../../../components/Panel';
import styles from '../../../layouts/Sword.less';
import { AUDITLOG_DETAIL } from '../../../actions/auditLog';

const FormItem = Form.Item;

@connect(({ auditLog }) => ({
  auditLog,
}))
@Form.create()
class AuditLogView extends PureComponent {
  componentWillMount() {
    const {
      dispatch,
      match: {
        params: { id },
      },
    } = this.props;
    dispatch(AUDITLOG_DETAIL(id));
  }

  handleEdit = () => {
    const {
      match: {
        params: { id },
      },
    } = this.props;
    router.push(`/jydboot/auditLog/edit/${id}`);
  };

  render() {
    const {
      auditLog: { detail },
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
      <Panel title="查看" back="/jydboot/auditLog" action={action}>
        <Form hideRequiredMark style={{ marginTop: 8 }}>
          <Card className={styles.card} bordered={false}>
            <FormItem {...formItemLayout} label="主键">
              <span>{detail.id}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="审核时间">
              <span>{detail.createTime}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="审核人ID">
              <span>{detail.createUser}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="审核人姓名">
              <span>{detail.createUserName}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="审核部门ID">
              <span>{detail.createDept}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="审核部门名称">
              <span>{detail.createDeptName}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="类型">
              <span>{detail.type}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="审核状态1通过2不通过3退回">
              <span>{detail.status}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="审核意见">
              <span>{detail.remark}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="业务ID">
              <span>{detail.businessId}</span>
            </FormItem>
          </Card>
        </Form>
      </Panel>
    );
  }
}
export default AuditLogView;
