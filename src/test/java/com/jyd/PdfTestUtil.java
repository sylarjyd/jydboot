package com.jyd;

import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.pdmodel.interactive.action.PDActionJavaScript;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

/**
 * 1	(File) 此属性保存文件的名称。
 * 2	（Title）使用此属性，您可以设置文档的标题。
 * 3	（Author）使用此属性，您可以设置文档的作者姓名。
 * 4	（Subject）使用此属性，您可以指定PDF文档的主题。
 * 5	（Keywords）使用此属性，您可以列出我们可以搜索文档的关键字。
 * 6	（Created）使用此属性，您可以设置为文档创建的日期。
 * 7	（Modified）使用此属性，您可以设置为文档修改的日期。
 * 8	（Application）使用此属性，您可以设置文档的应用程序。
 */
public class PdfTestUtil {

    /**
     * 创建一个空白pdf
     */
    @Test
    public void Test2() throws IOException {
        //1创建一个空的pdf
        PDDocument document = new PDDocument();
        //2创建一个空白页
        PDPage page = new PDPage();
        //3向文档添加一个空白页
        document.addPage(page);
        //4保存文档路径
        document.save("C:\\Users\\jyd\\Desktop\\1.pdf");
        //5关闭文档
        document.close();
    }

    /**
     * 批量添加空白页
     */
    @Test
    public void Test21() throws IOException {
        //1创建一个空的pdf
        PDDocument document = new PDDocument();
        //批量创建空白页
        for (int i = 0; i < 10; i++) {
            //2创建一个空白页
            PDPage page = new PDPage();
            //3向文档添加一个空白页
            document.addPage(page);
        }
        //4保存文档路径
        document.save("C:\\Users\\jyd\\Desktop\\1.pdf");
        //5关闭文档
        document.close();
    }

    /**
     * 加载一个现有的pdf
     */
    @Test
    public void Test3() throws IOException {
        //1加载现有的pdf
        File file = new File("C:\\Users\\jyd\\Desktop\\1.pdf");
        //2加载pdf
        PDDocument document  = PDDocument.load(file);
        //3加入一个空白页面
        document.addPage(new PDPage());
        //4重新保存一个路径
        document.save("C:\\Users\\jyd\\Desktop\\2.pdf");
        //5关闭文档
        document.close();
    }

    /**
     * 从文档中删除页面
     */
    @Test
    public void Test4() throws IOException {
        //1加载现有的pdf
        File file = new File("C:\\Users\\jyd\\Desktop\\1.pdf");
        PDDocument document = PDDocument.load(file);
        //2列出页数
        int nofPages = document.getNumberOfPages();
        System.out.println("总页数为："+nofPages);
        //3删除页面（使用PDDocument类的removePage()方法从pdf里删除页面）
        document.removePage(1);
        //4删除后保存
        document.save("C:\\Users\\jyd\\Desktop\\1.pdf");
        //5关闭文档
        document.close();
    }

    /**
     * 设置PDF的属性
     */
    @Test
    public void Test5() throws IOException {
        //1创建一个pdf
        PDDocument document = new PDDocument();
        //2创建一个空白的页面
        PDPage page = new PDPage();
        //3把页面添加到pdf里
        document.addPage(page);
        //4创建一个PDDocumentInformation()对象来给文档添加属性
        PDDocumentInformation pdd = new PDDocumentInformation();
        //设置作者
        pdd.setAuthor("PDFAuthor");
        //设置头部的名字
        pdd.setTitle("PDFTitle");
        //设置创作者
        pdd.setCreator("PDFCreator");
        //设置主题
        pdd.setSubject("PDFSubject");
        //创建时间
        Calendar data = new GregorianCalendar();
        data.set(2020,6,18);
        pdd.setCreationDate(data);
        //修改时间
        data.set(2020,6,20);
        pdd.setModificationDate(data);
        //文档的关键字
        pdd.setKeywords("PDFKeywords");

        //5保存文档
        document.save("C:\\Users\\jyd\\Desktop\\1.pdf");
        //6获取文档的属性
        System.out.println("获取到的作者："+pdd.getAuthor()+"\n获取到的主题："+pdd.getSubject());
        //6关闭文档
        document.close();
    }

    /**
     * 给pdf添加文本
     */
    @Test
    public void  Test6() throws IOException {
        //1加载pdf
        File file = new File("C:\\Users\\jyd\\Desktop\\1.pdf");
        PDDocument document = PDDocument.load(file);

        //2获取页面
        PDPage page = document.getPage(0);

        //3 准备内容流
        PDPageContentStream contentStream = new PDPageContentStream(document,page);

        //4开始文本
        contentStream.beginText();//起始文本
        //加载本机字体
        PDFont font = PDType0Font.load(document, new File("C:\\Windows\\Fonts\\simkai.ttf"));
        contentStream.setFont(font,12);//设置字体
        contentStream.newLineAtOffset(25,700);//设置文本位置
        String text = "这是一个PDF！这是一个PDF！这是一个PDF！这是一个PDF！这是一个PDF！这是一个PDF！这是！";
        contentStream.setLeading(15.5f);//设置文本的前导
        contentStream.showText(text);//写入到PDF文档里
        contentStream.endText();//结束文本

        //5关闭内容流
        contentStream.close();

        //6保存PDF位置
        document.save("C:\\Users\\jyd\\Desktop\\1.pdf");

        //7关闭文档
        document.close();
    }

    /**
     * 给pdf添加文本
     */
    @Test
    public void  Test61() throws IOException {
        //1加载pdf
        File file = new File("C:\\Users\\jyd\\Desktop\\1.pdf");
        PDDocument document = PDDocument.load(file);

        //2获取页面
        PDPage page = document.getPage(0);

        //3 准备内容流
        PDPageContentStream contentStream = new PDPageContentStream(document,page);

        //4开始文本
        contentStream.beginText();//起始文本
        //加载本机字体
        PDFont font = PDType0Font.load(document, new File("C:\\Windows\\Fonts\\simkai.ttf"));
        contentStream.setFont(font,12);//设置字体
        contentStream.newLineAtOffset(25,700);//设置文本位置
        String text = "这是一个PDF！这是一个PDF！这是一个PDF！这是一个PDF！这是一个PDF！这是一个PDF！这是！";
        String text2 = "换行了！换行了！换行了！换行了！换行了！换行了！换行了！换行了！换行了！换行了！";

        contentStream.setLeading(15.5f);//设置文本的前导


        contentStream.showText(text);
        contentStream.newLine();//使用换行将他们分开
        contentStream.showText(text2);

        contentStream.endText();//结束文本

        //5关闭内容流
        contentStream.close();
        //6保存PDF位置
        document.save("C:\\Users\\jyd\\Desktop\\1.pdf");
        //7关闭文档
        document.close();
    }

    /**
     * 从现有的PDF中提取文本
     */
    @Test
    public void Test7() throws IOException {
        //1加载现有的pdf
        File file = new File("C:\\Users\\jyd\\Desktop\\1.pdf");
        PDDocument document = PDDocument.load(file);
        //2实例化PDFTextStripper
        PDFTextStripper stripper = new PDFTextStripper();
        //3检索文本
        String text = stripper.getText(document);
        System.out.println("数据是:\n" + text);
        //4关闭文件
        document.close();
    }

    /**
     * 将图片插入到pdf
     */
    @Test
    public void test8() throws IOException {
        //1获取现有的pdf
        File file = new File("C:\\Users\\jyd\\Desktop\\2.pdf");
        PDDocument document = PDDocument.load(file);

        //2获取页面
        PDPage page = document.getPage(0);

        //3创建PDImageXObject对象来进行获取图片进行设置
        PDImageXObject pdImage = PDImageXObject.createFromFile("C:\\Users\\jyd\\Desktop\\图片\\image1.jpg",document);

        //4准备内容流
        PDPageContentStream contentStream = new PDPageContentStream(document,page);

        //5在pdf中绘制图片位置及宽高
        contentStream.drawImage(pdImage,80f,250f,500f,500f);

        //养成好习惯用完保存关闭
        //6关闭PDPageContentStream
        contentStream.close();
        //7保存文档
        document.save("C:\\Users\\jyd\\Desktop\\2.pdf");
        //8关闭文件
        document.close();
    }

    /**
     * 加密pdf
     * AccessPermission类用于通过为其分配访问权限来保护PDF文档。 使用此类，您可以限制用户执行以下操作。
     *
     * 打印文档
     * 修改文档的内容
     * 复制或提取文档的内容
     * 添加或修改注释
     * 填写交互式表单字段
     * 提取文本和图形，以便为视障人士提供便利
     * 组装文档
     */
    @Test
    public void test9() throws IOException {
        //1加载Pdf文档
        File file = new File("C:\\Users\\jyd\\Desktop\\2.pdf");
        PDDocument document = PDDocument.load(file);

        //2创建访问对象
        AccessPermission accessPermission = new AccessPermission();

        //3创建StandardProtectionPolicy对象
        //用来传递所有者密码，用户名密码和AccessPermission对象来实例化StandardProtectionPolicy类
        StandardProtectionPolicy spp = new StandardProtectionPolicy("123","123",accessPermission);
        spp.setEncryptionKeyLength(128);//设置加密密钥长度
        spp.setPermissions(accessPermission);//设置权限

        //4保护文档
        document.protect(spp);

        //5保存文档
        document.save("C:\\Users\\jyd\\Desktop\\2.pdf");

        //6关闭文档
        document.close();
    }

    /**
     * 震惊PDF里竟然可以写javascript脚本
     */
    @Test
    public void test10() throws IOException {
        //1首先来到操作文件的万年第一步加载文件
        File file = new File("C:\\Users\\jyd\\Desktop\\1.pdf");
        PDDocument document = PDDocument.load(file);

        //2接下来我们把PDActionJavaScript对象创建出来
        String javascript = "app.alert( {cMsg: '这是一个消息弹框，具体没有什么用。', nIcon: 1,"
                + " nType: 0,cTitle: '我来测试一下javaScript！！' } );";
        PDActionJavaScript script = new PDActionJavaScript(javascript);

        //3然后我们把javascript脚本放到pdf文档里
        document.getDocumentCatalog().setOpenAction(script);

        //4最后要养成好习惯保存关闭文档
        document.save("C:\\Users\\jyd\\Desktop\\1.pdf");
        document.close();
    }

    /**
     * 拆分PDF文档的页面
     */
    @Test
    public void test11() throws IOException {
        //1加载pdf文件
        File file = new File("C:\\Users\\jyd\\Desktop\\1.pdf");
        PDDocument document = PDDocument.load(file);

        //2实例化Splitter类
        Splitter splitter =new Splitter();

        //3拆分PDF页面
        List<PDDocument> pages = splitter.split(document);

        //4创建迭代器
        Iterator<PDDocument> iterator = pages.listIterator();

        //5循环进行拆分
        int i = 1;
        while(iterator.hasNext()) {
            PDDocument pd = iterator.next();
            pd.save("C:\\Users\\jyd\\Desktop\\"+i+"1.pdf");
        }

        //5关闭文档
        document.close();
    }

    /**
     * 合并多个PDF
     */
    @Test
    public void test12() throws IOException {
        //1加载pdf文件（这里加载了两个PDf进行合并）
        File file = new File("C:\\Users\\jyd\\Desktop\\1.pdf");
        File file1 = new File("C:\\Users\\jyd\\Desktop\\11.pdf");
        PDDocument document = PDDocument.load(file);
        PDDocument document1 = PDDocument.load(file1);

        //2实例化PDFMergerUtility类
        PDFMergerUtility pdfMerger = new PDFMergerUtility();

        //3设置目标文件
        pdfMerger.setDestinationFileName("C:\\Users\\jyd\\Desktop\\3.pdf");

        //4设置源文件
        pdfMerger.addSource(file);
        pdfMerger.addSource(file1);

        //5合并文档
        pdfMerger.mergeDocuments();

        //6关闭文档
        document.close();
    }

    /**
     * 将pdf文件生成图像
     */
    @Test
    public void test13() throws IOException {
        //1加载pdf文件
        File file = new File("C:\\Users\\jyd\\Desktop\\1.pdf");
        PDDocument document = PDDocument.load(file);

        //2实例化PDFRenderer对象
        PDFRenderer pdfRenderer = new PDFRenderer(document);

        //3从PDF文档渲染图像
        BufferedImage image = pdfRenderer.renderImage(0);//设置读第几页默认下标从0开始

        //4将图像写入文件
        ImageIO.write(image,"jpg",new File("C:\\Users\\jyd\\Desktop\\1.jpg"));

        //5关闭文档
        document.close();
    }

    /**
     * 在PDF里创建一个矩形
     */
    @Test
    public void test14() throws IOException {
        //1加载pdf文件
        File file = new File("C:\\Users\\jyd\\Desktop\\1.pdf");
        PDDocument document = PDDocument.load(file);
        //2获取页面对象
        PDPage page = document.getPage(0);
        //3准备内容流
        PDPageContentStream stream = new PDPageContentStream(document,page);

        //4设置颜色
        stream.setNonStrokingColor(Color.blue);

        //5绘制矩形
        stream.addRect(200, 650, 100, 100);

        //6填充矩形
        stream.fill();

        //7关闭流
        stream.close();
        //8保存文档位置
        document.save("C:\\Users\\jyd\\Desktop\\1.pdf");
        //9关闭文档
        document.close();

    }


}
