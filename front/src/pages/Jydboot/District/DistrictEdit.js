import React, { PureComponent } from 'react';
import { Form, Input, Card, Button } from 'antd';
import { connect } from 'dva';
import Panel from '../../../components/Panel';
import styles from '../../../layouts/Sword.less';
import { DISTRICT_DETAIL, DISTRICT_SUBMIT } from '../../../actions/district';

const FormItem = Form.Item;

@connect(({ district, loading }) => ({
  district,
  submitting: loading.effects['district/submit'],
}))
@Form.create()
class DistrictEdit extends PureComponent {
  componentWillMount() {
    const {
      dispatch,
      match: {
        params: { id },
      },
    } = this.props;
    dispatch(DISTRICT_DETAIL(id));
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
        dispatch(DISTRICT_SUBMIT(params));
      }
    });
  };

  render() {
    const {
      form: { getFieldDecorator },
      district: { detail },
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
      <Panel title="修改" back="/jydboot/district" action={action}>
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
            <FormItem {...formItemLayout} label="区划代码">
              {getFieldDecorator('districtCode', {
                rules: [
                  {
                    required: true,
                    message: '请输入区划代码',
                  },
                ],
                initialValue: detail.districtCode,
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
                initialValue: detail.districtName,
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
                initialValue: detail.parentId,
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
                initialValue: detail.levelCode,
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
                initialValue: detail.sort,
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
                initialValue: detail.createUser,
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
                initialValue: detail.createTime,
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
                initialValue: detail.updateUser,
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
                initialValue: detail.updateTime,
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
                initialValue: detail.status,
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
                initialValue: detail.deleted,
              })(<Input placeholder="请输入是否已删除" />)}
            </FormItem>
          </Card>
        </Form>
      </Panel>
    );
  }
}

export default DistrictEdit;
