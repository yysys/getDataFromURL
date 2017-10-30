import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class getData {

    public static final int sleepTime = 1000;
    public static final String savePath = "c:/KnnData";
    public static final int total = 200;

    public static void  downLoadFromUrl(String urlStr,String fileName,String savePath) throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();

        conn.setConnectTimeout(3*1000);

        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

        InputStream inputStream = conn.getInputStream();

        byte[] getData = readInputStream(inputStream);

        File saveDir = new File(savePath);
        if(!saveDir.exists()){
            saveDir.mkdir();
        }
        File file = new File(saveDir+File.separator+fileName);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(getData);
        if(fos!=null){
            fos.close();
        }
        if(inputStream!=null){
            inputStream.close();
        }

        System.out.println("info:"+url+" download success");
    }

    public static  byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }

    public static void main(String[] args) throws InterruptedException {

        for (int i = 1; i <= total; i++) {
            String fileName = "CAPTCHA" + i + ".jpg";
            try {
                downLoadFromUrl("http://jwbinfosys.zju.edu.cn/CheckCode.aspx",
                        fileName, savePath);
            } catch (Exception e) {
                e.printStackTrace();
            }

            Thread.sleep(sleepTime);
        }
    }
}
