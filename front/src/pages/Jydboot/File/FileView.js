import React, { PureComponent } from 'react';
import router from 'umi/router';
import { Form, Card, Button } from 'antd';
import { connect } from 'dva';
import Panel from '../../../components/Panel';
import styles from '../../../layouts/Sword.less';
import { FILE_DETAIL } from '../../../actions/file';

const FormItem = Form.Item;

@connect(({ file }) => ({
  file,
}))
@Form.create()
class FileView extends PureComponent {
  componentWillMount() {
    const {
      dispatch,
      match: {
        params: { id },
      },
    } = this.props;
    dispatch(FILE_DETAIL(id));
  }

  handleEdit = () => {
    const {
      match: {
        params: { id },
      },
    } = this.props;
    router.push(`/jydboot/file/edit/${id}`);
  };

  render() {
    const {
      file: { detail },
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
      <Panel title="查看" back="/jydboot/file" action={action}>
        <Form hideRequiredMark style={{ marginTop: 8 }}>
          <Card className={styles.card} bordered={false}>
            <FormItem {...formItemLayout} label="主键">
              <span>{detail.id}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="资源编号">
              <span>{detail.fileName}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="文件名称">
              <span>{detail.originalName}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="文件类型后缀">
              <span>{detail.fileType}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="文件大小KB">
              <span>{detail.fileSize}</span>
            </FormItem>
            <FormItem {...formItemLayout} label="是否需要鉴权，1是，0否，默认0">
              <span>{detail.auth}</span>
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
export default FileView;
