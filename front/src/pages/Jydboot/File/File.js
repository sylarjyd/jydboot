import React, { PureComponent } from 'react';
import { connect } from 'dva';
import { Button, Col, Form, Input, Row } from 'antd';
import Panel from '../../../components/Panel';
import { FILE_LIST } from '../../../actions/file';
import Grid from '../../../components/Sword/Grid';

const FormItem = Form.Item;

@connect(({ file, loading }) => ({
  file,
  loading: loading.models.file,
}))
@Form.create()
class File extends PureComponent {
  // ============ 查询 ===============
  handleSearch = params => {
    const { dispatch } = this.props;
    dispatch(FILE_LIST(params));
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
    const code = 'file';

    const {
      form,
      loading,
      file: { data },
    } = this.props;

    const columns = [
      {
        title: '主键',
        dataIndex: 'id',
      },
      {
        title: '资源编号',
        dataIndex: 'fileName',
      },
      {
        title: '文件名称',
        dataIndex: 'originalName',
      },
      {
        title: '文件类型后缀',
        dataIndex: 'fileType',
      },
      {
        title: '文件大小KB',
        dataIndex: 'fileSize',
      },
      {
        title: '是否需要鉴权，1是，0否，默认0',
        dataIndex: 'auth',
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
export default File;
