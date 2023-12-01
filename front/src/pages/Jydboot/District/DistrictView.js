import React, { PureComponent } from 'react';
import router from 'umi/router';
import { Form, Card, Button } from 'antd';
import { connect } from 'dva';
import Panel from '../../../components/Panel';
import styles from '../../../layouts/Sword.less';
import { DISTRICT_DETAIL } from '../../../actions/district';

const FormItem = Form.Item;

@connect(({ district }) => ({
  district,
}))
@Form.create()
class DistrictView extends PureComponent {
  componentWillMount() {
    const {
      dispatch,
      match: {
        params: { id },
      },
    } = this.props;
    dispatch(DISTRICT_DETAIL(id));
  }

  handleEdit = () => {
    const {
      match: {
        params: { id },
      },
    } = this.props;
    router.push(`/jydboot/district/edit/${id}`);
  };

  render() {
    const {
      district: { detail },
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
      <Panel title="查看" back="/jydboot/district" action={action}>
        <Form hideRequiredMark style={{ marginTop: 8 }}>
          <Card className={styles.card} bordered={false}>
            <FormItem {...formItemLayout} label="主键">
              <span>{detail.id}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="区划代码">
              <span>{detail.districtCode}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="区划名称">
              <span>{detail.districtName}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="父级id">
              <span>{detail.parentId}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="行政级别">
              <span>{detail.levelCode}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="排序">
              <span>{detail.sort}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="创建人">
              <span>{detail.createUser}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="创建时间">
              <span>{detail.createTime}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="修改人">
              <span>{detail.updateUser}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="修改时间">
              <span>{detail.updateTime}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="状态">
              <span>{detail.status}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="是否已删除">
              <span>{detail.deleted}</span>
            </FormItem>
          </Card>
        </Form>
      </Panel>
    );
  }
}
export default DistrictView;
