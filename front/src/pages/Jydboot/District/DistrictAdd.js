import React, { PureComponent } from 'react';
import { Form, Input, Card, Button } from 'antd';
import { connect } from 'dva';
import Panel from '../../../components/Panel';
import styles from '../../../layouts/Sword.less';
import { DISTRICT_SUBMIT } from '../../../actions/district';

const FormItem = Form.Item;

@connect(({ loading }) => ({
  submitting: loading.effects['district/submit'],
}))
@Form.create()
class DistrictAdd extends PureComponent {
  handleSubmit = e => {
    e.preventDefault();
    const { dispatch, form } = this.props;
    form.validateFieldsAndScroll((err, values) => {
      if (!err) {
        dispatch(DISTRICT_SUBMIT(values));
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
      <Panel title="新增" back="/jydboot/district" action={action}>
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
            <FormItem {...formItemLayout} label="区划代码">
              {getFieldDecorator('districtCode', {
                rules: [
                  {
                    required: true,
                    message: '请输入区划代码',
                  },
                ],
              })(<Input placeholder="请输入区划代码" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="区划名称">
              {getFieldDecorator('districtName', {
                rules: [
                  {
                    required: true,
                    message: '请输入区划名称',
                  },
                ],
              })(<Input placeholder="请输入区划名称" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="父级id">
              {getFieldDecorator('parentId', {
                rules: [
                  {
                    required: true,
                    message: '请输入父级id',
                  },
                ],
              })(<Input placeholder="请输入父级id" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="行政级别">
              {getFieldDecorator('levelCode', {
                rules: [
                  {
                    required: true,
                    message: '请输入行政级别',
                  },
                ],
              })(<Input placeholder="请输入行政级别" />)}
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
            <FormItem {...formItemLayout} label="创建人">
              {getFieldDecorator('createUser', {
                rules: [
                  {
                    required: true,
                    message: '请输入创建人',
                  },
                ],
              })(<Input placeholder="请输入创建人" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="创建时间">
              {getFieldDecorator('createTime', {
                rules: [
                  {
                    required: true,
                    message: '请输入创建时间',
                  },
                ],
              })(<Input placeholder="请输入创建时间" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="修改人">
              {getFieldDecorator('updateUser', {
                rules: [
                  {
                    required: true,
                    message: '请输入修改人',
                  },
                ],
              })(<Input placeholder="请输入修改人" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="修改时间">
              {getFieldDecorator('updateTime', {
                rules: [
                  {
                    required: true,
                    message: '请输入修改时间',
                  },
                ],
              })(<Input placeholder="请输入修改时间" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="状态">
              {getFieldDecorator('status', {
                rules: [
                  {
                    required: true,
                    message: '请输入状态',
                  },
                ],
              })(<Input placeholder="请输入状态" />)}
            </FormItem>
            <FormItem {...formItemLayout} label="是否已删除">
              {getFieldDecorator('deleted', {
                rules: [
                  {
                    required: true,
                    message: '请输入是否已删除',
                  },
                ],
              })(<Input placeholder="请输入是否已删除" />)}
            </FormItem>
          </Card>
        </Form>
      </Panel>
    );
  }
}

export default DistrictAdd;
