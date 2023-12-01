import React, { PureComponent } from 'react';
import router from 'umi/router';
import { Form, Card, Button } from 'antd';
import { connect } from 'dva';
import Panel from '../../../components/Panel';
import styles from '../../../layouts/Sword.less';
import { DICT_DETAIL } from '../../../actions/dict';

const FormItem = Form.Item;

@connect(({ dict }) => ({
  dict,
}))
@Form.create()
class DictView extends PureComponent {
  componentWillMount() {
    const {
      dispatch,
      match: {
        params: { id },
      },
    } = this.props;
    dispatch(DICT_DETAIL(id));
  }

  handleEdit = () => {
    const {
      match: {
        params: { id },
      },
    } = this.props;
    router.push(`/jydboot/dict/edit/${id}`);
  };

  render() {
    const {
      dict: { detail },
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
      <Panel title="查看" back="/jydboot/dict" action={action}>
        <Form hideRequiredMark style={{ marginTop: 8 }}>
          <Card className={styles.card} bordered={false}>
            <FormItem {...formItemLayout} label="主键">
              <span>{detail.id}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="字典码">
              <span>{detail.code}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="字典名称">
              <span>{detail.dictKey}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="字典值">
              <span>{detail.dictValue}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="排序">
              <span>{detail.sort}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="字典备注">
              <span>{detail.remark}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="是否已删除0正常1删除">
              <span>{detail.deleted}</span>
            </FormItem>
          </Card>
        </Form>
      </Panel>
    );
  }
}
export default DictView;
