import React, { PureComponent } from 'react';
import { connect } from 'dva';
import { Button, Col, Form, Input, Row } from 'antd';
import Panel from '../../../components/Panel';
import { DISTRICT_LIST } from '../../../actions/district';
import Grid from '../../../components/Sword/Grid';

const FormItem = Form.Item;

@connect(({ district, loading }) => ({
  district,
  loading: loading.models.district,
}))
@Form.create()
class District extends PureComponent {
  // ============ 查询 ===============
  handleSearch = params => {
    const { dispatch } = this.props;
    dispatch(DISTRICT_LIST(params));
  };

  // ============ 查询表单 ===============
  renderSearchForm = onReset => {
    const { form } = this.props;
    const { getFieldDecorator } = form;

    return (
      <Row gutter={{ md: 8, lg: 24, xl: 48 }}>
        <Col md={6} sm={24}>
          <FormItem label="查询名称">
            {getFieldDecorator('name')(<Input placeholder="查询名称" />)}
          </FormItem>
        </Col>
        <Col>
          <div style={{ float: 'right' }}>
            <Button type="primary" htmlType="submit">
              查询
            </Button>
            <Button style={{ marginLeft: 8 }} onClick={onReset}>
              重置
            </Button>
          </div>
        </Col>
      </Row>
    );
  };

  render() {
    const code = 'district';

    const {
      form,
      loading,
      district: { data },
    } = this.props;

    const columns = [
      {
        title: '主键',
        dataIndex: 'id',
      },
      {
        title: '区划代码',
        dataIndex: 'districtCode',
      },
      {
        title: '区划名称',
        dataIndex: 'districtName',
      },
      {
        title: '父级id',
        dataIndex: 'parentId',
      },
      {
        title: '行政级别',
        dataIndex: 'levelCode',
      },
      {
        title: '排序',
        dataIndex: 'sort',
      },
      {
        title: '创建人',
        dataIndex: 'createUser',
      },
      {
        title: '创建时间',
        dataIndex: 'createTime',
      },
      {
        title: '修改人',
        dataIndex: 'updateUser',
      },
      {
        title: '修改时间',
        dataIndex: 'updateTime',
      },
      {
        title: '状态',
        dataIndex: 'status',
      },
      {
        title: '是否已删除',
        dataIndex: 'deleted',
      },
    ];

    return (
      <Panel>
        <Grid
          code={code}
          form={form}
          onSearch={this.handleSearch}
          renderSearchForm={this.renderSearchForm}
          loading={loading}
          data={data}
          columns={columns}
        />
      </Panel>
    );
  }
}
export default District;
