/*
    @author Heroxin
    @create 2022-09-11-11:22

    @Description:
*/

import com.taotao.common.utils.FtpUtil;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FtpTest {
   @Test
   public void test(){
      String hostname = "192.168.196.103";
      int port = 21;
      FTPClient ftpClient = new FTPClient();
      ftpClient.setControlEncoding("utf-8");

      System.out.println("connecting...ftp服务器:" + hostname + ":" + port);
      try {

         ftpClient.connect(hostname, port);
         // 连接ftp服务器
         ftpClient.login("Heroxin", "heroxin1110."); // 登录ftp服务器
         ftpClient.enterLocalPassiveMode();

         int replyCode = ftpClient.getReplyCode(); // 是否成功登录服务器
         if (!FTPReply.isPositiveCompletion(replyCode)) {
            System.out.println("connect failed...ftp服务器:" + hostname + ":" + port);
         }
         ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
         boolean boo = ftpClient.changeWorkingDirectory("/home/Heroxin/www/images");
         if (boo) {
            System.out.println("进入文件夹成功");
         }
         InputStream inputStream = new FileInputStream("C:\\Users\\hero_\\Desktop\\97793668_p1.jpg");
         System.out.println(ftpClient.storeFile("a.jpg", inputStream));
         inputStream.close();
         ftpClient.logout();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   @Test
   public void testFtpUtils() throws FileNotFoundException {
      InputStream inputStream = new FileInputStream(
              "C:\\Users\\hero_\\Pictures\\new\\66838_p0_master1200.jpg");
      FtpUtil.uploadFile(
              "192.168.196.103",21,"Heroxin","heroxin1110.","/home/Heroxin/www/images",
              "/2022/09/11","hello06.jpg",inputStream);
   }
}
