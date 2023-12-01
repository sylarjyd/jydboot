import React, { PureComponent } from 'react';
import router from 'umi/router';
import { Form, Card, Button } from 'antd';
import { connect } from 'dva';
import Panel from '../../../components/Panel';
import styles from '../../../layouts/Sword.less';
import { MESSAGELOG_DETAIL } from '../../../actions/messageLog';

const FormItem = Form.Item;

@connect(({ messageLog }) => ({
  messageLog,
}))
@Form.create()
class MessageLogView extends PureComponent {
  componentWillMount() {
    const {
      dispatch,
      match: {
        params: { id },
      },
    } = this.props;
    dispatch(MESSAGELOG_DETAIL(id));
  }

  handleEdit = () => {
    const {
      match: {
        params: { id },
      },
    } = this.props;
    router.push(`/jydboot/messageLog/edit/${id}`);
  };

  render() {
    const {
      messageLog: { detail },
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
      <Panel title="查看" back="/jydboot/messageLog" action={action}>
        <Form hideRequiredMark style={{ marginTop: 8 }}>
          <Card className={styles.card} bordered={false}>
            <FormItem {...formItemLayout} label="主键">
              <span>{detail.id}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="创建时间">
              <span>{detail.createTime}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="创建人">
              <span>{detail.createUser}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="类型">
              <span>{detail.type}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="消息状态0成功1失败">
              <span>{detail.status}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="标题">
              <span>{detail.title}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="消息内容">
              <span>{detail.content}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="业务ID">
              <span>{detail.businessId}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="用户ID">
              <span>{detail.userId}</span>
            </FormItem>
          </Card>
        </Form>
      </Panel>
    );
  }
}
export default MessageLogView;
