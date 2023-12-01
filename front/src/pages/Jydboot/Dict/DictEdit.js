import React, { PureComponent } from 'react';
import { Form, Input, Card, Button } from 'antd';
import { connect } from 'dva';
import Panel from '../../../components/Panel';
import styles from '../../../layouts/Sword.less';
import { DICT_DETAIL, DICT_SUBMIT } from '../../../actions/dict';

const FormItem = Form.Item;

@connect(({ dict, loading }) => ({
  dict,
  submitting: loading.effects['dict/submit'],
}))
@Form.create()
class DictEdit extends PureComponent {
  componentWillMount() {
    const {
      dispatch,
      match: {
        params: { id },
      },
    } = this.props;
    dispatch(DICT_DETAIL(id));
  }

  handleSubmit = e => {
    e.preventDefault();
    const {
      dispatch,
      match: {
        params: { id },
      },
      form,
    } = this.props;
    form.validateFieldsAndScroll((err, values) => {
      if (!err) {
        const params = {
          id,
          ...values,
        };
        console.log(params);
        dispatch(DICT_SUBMIT(params));
      }
    });
  };

  render() {
    const {
      form: { getFieldDecorator },
      dict: { detail },
      submitting,
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
      <Button type="primary" onClick={this.handleSubmit} loading={submitting}>
        提交
      </Button>
    );

    return (
      <Panel title="修改" back="/jydboot/dict" action={action}>
        <Form hideRequiredMark style={{ marginTop: 8 }}>
          <Card className={styles.card} bordered={false}>
            <FormItem {...formItemLayout} label="主键">
              {getFieldDecorator('id', {
                rules: [
                  {
                    required: true,
                    message: '请输入主键',
                  },
                ],
                initialValue: detail.id,
              })(<Input placeholder="请输入主键" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="字典码">
              {getFieldDecorator('code', {
                rules: [
                  {
                    required: true,
                    message: '请输入字典码',
                  },
                ],
                initialValue: detail.code,
              })(<Input placeholder="请输入字典码" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="字典名称">
              {getFieldDecorator('dictKey', {
                rules: [
                  {
                    required: true,
                    message: '请输入字典名称',
                  },
                ],
                initialValue: detail.dictKey,
              })(<Input placeholder="请输入字典名称" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="字典值">
              {getFieldDecorator('dictValue', {
                rules: [
                  {
                    required: true,
                    message: '请输入字典值',
                  },
                ],
                initialValue: detail.dictValue,
              })(<Input placeholder="请输入字典值" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="排序">
              {getFieldDecorator('sort', {
                rules: [
                  {
                    required: true,
                    message: '请输入排序',
                  },
                ],
                initialValue: detail.sort,
              })(<Input placeholder="请输入排序" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="字典备注">
              {getFieldDecorator('remark', {
                rules: [
                  {
                    required: true,
                    message: '请输入字典备注',
                  },
                ],
                initialValue: detail.remark,
              })(<Input placeholder="请输入字典备注" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="是否已删除0正常1删除">
              {getFieldDecorator('deleted', {
                rules: [
                  {
                    required: true,
                    message: '请输入是否已删除0正常1删除',
                  },
                ],
                initialValue: detail.deleted,
              })(<Input placeholder="请输入是否已删除0正常1删除" />)}
            </FormItem>
          </Card>
        </Form>
      </Panel>
    );
  }
}

export default DictEdit;
