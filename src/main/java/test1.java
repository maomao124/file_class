import java.io.File;

/**
 * Project name(项目名称)：File类
 * Package(包名): PACKAGE_NAME
 * Class(类名): test1
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2021/11/18
 * Time(创建时间)： 14:16
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class test1
{
    public static void main(String[] args)
    {
        //遍历目录
        //通过遍历目录可以在指定的目录中查找文件，或者显示所有的文件列表。File 类的 list() 方法提供了遍历目录功能，该方法有如下两种重载形式。
        //1. String[] list()
        //该方法表示返回由 File 对象表示目录中所有文件和子目录名称组成的字符串数组，如果调用的 File 对象不是目录，则返回 null。
        //提示：list() 方法返回的数组中仅包含文件名称，而不包含路径。但不保证所得数组中的相同字符串将以特定顺序出现，特别是不保证它们按字母顺序出现。
        //2. String[] list(FilenameFilter filter)
        //该方法的作用与 list() 方法相同，不同的是返回数组中仅包含符合 filter 过滤器的文件和目录，如果 filter 为 null，则接受所有名称。
        String path2 = ".";
        File file3 = new File(path2);
        String[] str = file3.list();
        assert str != null;
        for (String str1 : str)
        {
            System.out.println(str1);
        }
        for (int i = 0; i < str.length; i++)
        { // 遍历返回的字符数组
            System.out.print(str[i] + "\t\t");
            System.out.print((new File(str[i])).isFile() ? "文件" + "\t\t" : "文件夹" + "\t\t");
            System.out.println((new File(str[i])).length() + "字节");
        }
    }
}
