import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Project name(项目名称)：File类
 * Package(包名): PACKAGE_NAME
 * Class(类名): test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/18
 * Time(创建时间)： 13:42
 * Version(版本): 1.0
 * Description(描述)：
 * File 类是 java.io 包中唯一代表磁盘文件本身的对象，也就是说，如果希望在程序中操作文件和目录，则都可以通过 File 类来完成。
 * File 类定义了一些方法来操作文件，如新建、删除、重命名文件和目录等。
 * File 类不能访问文件内容本身，如果需要访问文件内容本身，则需要使用输入/输出流。
 * File 类提供了如下三种形式构造方法。
 * File(String path)：如果 path 是实际存在的路径，则该 File 对象表示的是目录；如果 path 是文件名，则该 File 对象表示的是文件。
 * File(String path, String name)：path 是路径名，name 是文件名。
 * File(File dir, String name)：dir 是路径对象，name 是文件名。
 * 使用任意一个构造方法都可以创建一个 File 对象，然后调用其提供的方法对文件进行操作。
 * 方法名称	            说明
 * boolean canRead()	测试应用程序是否能从指定的文件中进行读取
 * boolean canWrite()	测试应用程序是否能写当前文件
 * boolean delete()	  删除当前对象指定的文件
 * boolean exists()	   测试当前 File 是否存在
 * String getAbsolutePath()	返回由该对象表示的文件的绝对路径名
 * String getName()	返回表示当前对象的文件名或路径名（如果是路径，则返回最后一级子路径名）
 * String getParent()	返回当前 File 对象所对应目录（最后一级子目录）的父目录名
 * boolean isAbsolute()	测试当前 File 对象表示的文件是否为一个绝对路径名。该方法消除了不同平台的差异，
 * 可以直接判断 file 对象是否为绝对路径。在 UNIX/Linux/BSD 等系统上，如果路径名开头是一条斜线/，则表明该 File 对象对应一个绝对路径；
 * 在 Windows 等系统上，如果路径开头是盘符，则说明它是一个绝对路径。
 * boolean isDirectory()	测试当前 File 对象表示的文件是否为一个路径
 * boolean isFile()	测试当前 File 对象表示的文件是否为一个“普通”文件
 * long lastModified()	返回当前 File 对象表示的文件最后修改的时间
 * long length()	返回当前 File 对象表示的文件长度
 * String[] list()	返回当前 File 对象指定的路径文件列表
 * String[] list(FilenameFilter)	返回当前 File 对象指定的目录中满足指定过滤器的文件列表
 * boolean mkdir()	创建一个目录，它的路径名由当前 File 对象指定
 * boolean mkdirs()	创建一个目录，它的路径名由当前 File 对象指定
 * boolean renameTo(File)	将当前 File 对象指定的文件更名为给定参数 File 指定的路径名
 */

public class test
{
    public static void main(String[] args)
    {
        //获取文件属性
        String path = "src\\main\\java"; // 指定文件所在的目录
        File file = new File(path, "test.java"); // 建立File变量,并设定由f变量引用
        System.out.println("文件信息如下：");
        System.out.println("============================================");
        System.out.println("是否存在：" + file.exists());
        System.out.println("是否能读：" + file.canRead());
        System.out.println("是否能写：" + file.canWrite());
        System.out.println("文件长度：" + file.length() + "字节");
        System.out.println("文件或者目录：" + (file.isFile() ? "是文件" : "不是文件"));
        System.out.println("文件或者目录：" + (file.isDirectory() ? "是目录" : "不是目录"));
        System.out.println("是否可读：" + (file.canRead() ? "可读取" : "不可读取"));
        System.out.println("是否可写：" + (file.canWrite() ? "可写入" : "不可写入"));
        System.out.println("是否隐藏：" + (file.isHidden() ? "是隐藏文件" : "不是隐藏文件"));
        System.out.println("最后修改日期：" + new Date(file.lastModified()));
        System.out.println("文件名称：" + file.getName());
        System.out.println("文件路径：" + file.getPath());
        System.out.println("绝对路径：" + file.getAbsolutePath());
        System.out.println();

        //创建和删除文件
        File file1 = new File("test.txt"); // 创建指向文件的File对象

        if (file1.exists()) // 判断文件是否存在
        {

            boolean result = file1.delete(); // 存在则先删除
            if (result)
            {
                System.out.println("文件删除成功");
            }
            else
            {
                System.out.println("文件删除失败");
            }
        }
        try
        {
            file1.createNewFile(); // 再创建
            System.out.println("文件已创建");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        System.out.println(file1.getAbsolutePath());
        System.out.println();

        //创建和删除目录
        String path1 = "t\\t1"; // 指定目录位置
        File file2 = new File(path1); // 创建File对象
        System.out.println(file2.getAbsolutePath());
        if (file2.exists())
        {
            System.out.println("目录已存在");
            boolean result = file2.delete();
            if (result)
            {
                System.out.println("目录删除成功");
            }
            else
            {
                System.out.println("目录删除失败");
            }
        }
        else
        {
            boolean result1 = file2.mkdirs(); // 创建目录
            System.out.println("目录不存在");
            if (result1)
            {
                System.out.println("目录创建成功");
            }
            else
            {
                System.out.println("目录创建失败");
            }
        }
        System.out.println();
    }
}

