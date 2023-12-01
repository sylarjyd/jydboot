import React, { PureComponent } from 'react';
import { connect } from 'dva';
import { Button, Col, Form, Input, Row } from 'antd';
import Panel from '../../../components/Panel';
import { SYSLOG_LIST } from '../../../actions/sysLog';
import Grid from '../../../components/Sword/Grid';

const FormItem = Form.Item;

@connect(({ sysLog, loading }) => ({
  sysLog,
  loading: loading.models.sysLog,
}))
@Form.create()
class SysLog extends PureComponent {
  // ============ 查询 ===============
  handleSearch = params => {
    const { dispatch } = this.props;
    dispatch(SYSLOG_LIST(params));
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
    const code = 'sysLog';

    const {
      form,
      loading,
      sysLog: { data },
    } = this.props;

    const columns = [
      {
        title: '主键',
        dataIndex: 'id',
      },
      {
        title: '服务器IP地址',
        dataIndex: 'serverIp',
      },
      {
        title: '操作地址ip',
        dataIndex: 'remoteIp',
      },
      {
        title: '服务名称',
        dataIndex: 'serviceName',
      },
      {
        title: '系统模块',
        dataIndex: 'optModule',
      },
      {
        title: '操作类型',
        dataIndex: 'optType',
      },
      {
        title: '日志类型1管理端2门户3移动端',
        dataIndex: 'type',
      },
      {
        title: '请求方法',
        dataIndex: 'method',
      },
      {
        title: '请求路径',
        dataIndex: 'requestUri',
      },
      {
        title: '返回结果',
        dataIndex: 'response',
      },
      {
        title: '方法名',
        dataIndex: 'methodName',
      },
      {
        title: '方法类',
        dataIndex: 'methodClass',
      },
      {
        title: '操作提交的数据',
        dataIndex: 'params',
      },
      {
        title: '操作状态0成功1失败',
        dataIndex: 'status',
      },
      {
        title: '创建者',
        dataIndex: 'createUser',
      },
      {
        title: '创建时间',
        dataIndex: 'createTime',
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
export default SysLog;
