import React, { PureComponent } from 'react';
import router from 'umi/router';
import { Form, Card, Button } from 'antd';
import { connect } from 'dva';
import Panel from '../../../components/Panel';
import styles from '../../../layouts/Sword.less';
import { SYSNOTICE_DETAIL } from '../../../actions/sysNotice';

const FormItem = Form.Item;

@connect(({ sysNotice }) => ({
  sysNotice,
}))
@Form.create()
class SysNoticeView extends PureComponent {
  componentWillMount() {
    const {
      dispatch,
      match: {
        params: { id },
      },
    } = this.props;
    dispatch(SYSNOTICE_DETAIL(id));
  }

  handleEdit = () => {
    const {
      match: {
        params: { id },
      },
    } = this.props;
    router.push(`/jydboot/sysNotice/edit/${id}`);
  };

  render() {
    const {
      sysNotice: { detail },
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
      <Panel title="查看" back="/jydboot/sysNotice" action={action}>
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
            <FormItem {...formItemLayout} label="内容">
              <span>{detail.content}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="标题">
              <span>{detail.title}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="副标题">
              <span>{detail.subTitle}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="发布人">
              <span>{detail.postUser}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="发布时间">
              <span>{detail.postTime}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="来源">
              <span>{detail.source}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="类型1、新闻 2通知公告">
              <span>{detail.type}</span>
            </FormItem>
          </Card>
        </Form>
      </Panel>
    );
  }
}
export default SysNoticeView;
