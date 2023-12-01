import React, { PureComponent } from 'react';
import router from 'umi/router';
import { Form, Card, Button } from 'antd';
import { connect } from 'dva';
import Panel from '../../../components/Panel';
import styles from '../../../layouts/Sword.less';
import { SYSMENU_DETAIL } from '../../../actions/sysMenu';

const FormItem = Form.Item;

@connect(({ sysMenu }) => ({
  sysMenu,
}))
@Form.create()
class SysMenuView extends PureComponent {
  componentWillMount() {
    const {
      dispatch,
      match: {
        params: { id },
      },
    } = this.props;
    dispatch(SYSMENU_DETAIL(id));
  }

  handleEdit = () => {
    const {
      match: {
        params: { id },
      },
    } = this.props;
    router.push(`/jydboot/sysMenu/edit/${id}`);
  };

  render() {
    const {
      sysMenu: { detail },
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
      <Panel title="查看" back="/jydboot/sysMenu" action={action}>
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
            <FormItem {...formItemLayout} label="权限编码">
              <span>{detail.code}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="权限名称">
              <span>{detail.name}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="路由">
              <span>{detail.path}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="图标">
              <span>{detail.source}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="备注">
              <span>{detail.remark}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="序号">
              <span>{detail.sort}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="1菜单2按钮3数据">
              <span>{detail.category}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="父级ID">
              <span>{detail.parentId}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="别名">
              <span>{detail.alias}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="操作按钮类型">
              <span>{detail.action}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="是否隐藏">
              <span>{detail.isHidden}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="是否打开新页面">
              <span>{detail.isOpen}</span>
            </FormItem>
          </Card>
        </Form>
      </Panel>
    );
  }
}
export default SysMenuView;
