import React, { PureComponent } from 'react';
import router from 'umi/router';
import { Form, Card, Button } from 'antd';
import { connect } from 'dva';
import Panel from '../../../components/Panel';
import styles from '../../../layouts/Sword.less';
import { SYSLOG_DETAIL } from '../../../actions/sysLog';

const FormItem = Form.Item;

@connect(({ sysLog }) => ({
  sysLog,
}))
@Form.create()
class SysLogView extends PureComponent {
  componentWillMount() {
    const {
      dispatch,
      match: {
        params: { id },
      },
    } = this.props;
    dispatch(SYSLOG_DETAIL(id));
  }

  handleEdit = () => {
    const {
      match: {
        params: { id },
      },
    } = this.props;
    router.push(`/jydboot/sysLog/edit/${id}`);
  };

  render() {
    const {
      sysLog: { detail },
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
      <Panel title="查看" back="/jydboot/sysLog" action={action}>
        <Form hideRequiredMark style={{ marginTop: 8 }}>
          <Card className={styles.card} bordered={false}>
            <FormItem {...formItemLayout} label="主键">
              <span>{detail.id}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="服务器IP地址">
              <span>{detail.serverIp}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="操作地址ip">
              <span>{detail.remoteIp}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="服务名称">
              <span>{detail.serviceName}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="系统模块">
              <span>{detail.optModule}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="操作类型">
              <span>{detail.optType}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="日志类型1管理端2门户3移动端">
              <span>{detail.type}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="请求方法">
              <span>{detail.method}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="请求路径">
              <span>{detail.requestUri}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="返回结果">
              <span>{detail.response}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="方法名">
              <span>{detail.methodName}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="方法类">
              <span>{detail.methodClass}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="操作提交的数据">
              <span>{detail.params}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="操作状态0成功1失败">
              <span>{detail.status}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="创建者">
              <span>{detail.createUser}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="创建时间">
              <span>{detail.createTime}</span>
            </FormItem>
          </Card>
        </Form>
      </Panel>
    );
  }
}
export default SysLogView;
