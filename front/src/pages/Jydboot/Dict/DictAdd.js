import React, { PureComponent } from 'react';
import { Form, Input, Card, Button } from 'antd';
import { connect } from 'dva';
import Panel from '../../../components/Panel';
import styles from '../../../layouts/Sword.less';
import { DICT_SUBMIT } from '../../../actions/dict';

const FormItem = Form.Item;

@connect(({ loading }) => ({
  submitting: loading.effects['dict/submit'],
}))
@Form.create()
class DictAdd extends PureComponent {
  handleSubmit = e => {
    e.preventDefault();
    const { dispatch, form } = this.props;
    form.validateFieldsAndScroll((err, values) => {
      if (!err) {
        dispatch(DICT_SUBMIT(values));
      }
    });
  };

  render() {
    const {
      form: { getFieldDecorator },
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
      <Panel title="新增" back="/jydboot/dict" action={action}>
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
              })(<Input placeholder="请输入是否已删除0正常1删除" />)}
            </FormItem>
          </Card>
        </Form>
      </Panel>
    );
  }
}

export default DictAdd;
