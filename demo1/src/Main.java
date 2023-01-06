import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        System.out.println("Hello world!");
        System.out.println("yunis learn java");
        //获取当前线程 Thread[main,5,main]
        System.out.println(Thread.currentThread());

        //thread demo
        threadMethod();
        //file demo
        fileMethod();
        // mac file
        editMACFile();


    }

    /**
     * 线程方法
     */
    public static void threadMethod() {
        //开启新线程
        Thread thread = new Thread(() -> {
            System.out.println("开启一个新线程"+ Thread.currentThread());
        });
        thread.start();

        //新建子类 内部实现 run
        SYThead thread1 = new SYThead();
        thread1.start();
    }

    /**
     * IO方法
     */
    public static void fileMethod() {

        File file = new File("/Desktop/code.txt");

        String name = file.getName();
        System.out.println("name :" + name);

        String parent = file.getParent();
        System.out.println("parent :" + parent);

        String path = file.getPath();
        System.out.println("path :" + path);

        String absolutePath = file.getAbsolutePath();
        System.out.println("absolutePath :" + absolutePath);

        File parentFile = file.getParentFile();
        System.out.println("parentFile :" + parentFile);

        File absoluteFile = file.getAbsoluteFile();
        System.out.println("absoluteFile :" + absoluteFile);

        long lastModified = file.lastModified();
        System.out.println("lastModified :" + lastModified);

        System.out.println(File.separator + "  " + File.pathSeparator);







    }

    public static void editMACFile() throws IOException, InterruptedException {
//        String desktop = System.getProperty ("user.home") + "/Desktop/";
        String home = System.getProperty("user.home");
        System.out.println("home :" + home);
        String desktop =  "/Users/tan/Desktop/";

        System.out.println("desktop : " + desktop);
        File deskFile = new File (desktop );
        System.out.println(deskFile.isDirectory());

        System.out.println(deskFile.getName());
        System.out.println(deskFile.isDirectory());
        System.out.println(deskFile.isFile());
        String[] files = deskFile.list();
        System.out.println( Arrays.toString(files));

        String separator = File.separator;
        String pathSeparator = File.pathSeparator;

        System.out.println("separator : " + separator);
        System.out.println("pathSeparator : " + pathSeparator);

        //创建文件
        String deleteFilePath =  "/Users/tan/Desktop/1.txt";
        File creatFile = new File (deleteFilePath );
        boolean sucess = creatFile.createNewFile();
        System.out.println("新建文件成功");



        if (sucess) {
            //延迟 2秒钟
            Thread.sleep(2 * 1000);
            //剪切文件
            File deleteFile = new File (deleteFilePath );
            File renameFilePath = new File ("/Users/tan/Desktop/111111.txt" );
            deleteFile.renameTo(renameFilePath);
            System.out.println("剪切成功，可以修改路径、文件名");

            Thread.sleep(2 * 1000);
            //delete 不轻易尝试，省的删错文件。
            renameFilePath.delete();
            System.out.println("删除成功");
        }

        //mkdir() 创建文件夹
        String mkdirFilePath =  "/Users/tan/Desktop/test";
        File mkdirFile = new File (mkdirFilePath );
        mkdirFile.mkdir();

    }
}