package yuyu.common.workflowcore.core.iwfinfr.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * シリアライズ可能なオブジェクトをバイナリデータに変換するための<br />
 * 各種メソッドを提供するユーティリティクラスです。
 */
public class IwfBytesSerializer {

    public static final String sZIPENTRY_NAME = "data.txt";

    public static byte[] serialize(Serializable pObj) {


        try(ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(baos)){


            oos.writeObject(pObj);


            oos.flush();


            byte[] bytes = baos.toByteArray();


            return bytes;
        }catch (Exception e1) {

            throw new RuntimeException(e1);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T extends Serializable> T deserialize(byte[] bytes) {

        try{

            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bytes));


            T obj = (T)ois.readObject();


            return obj;
        }catch (Exception e1) {

            throw new RuntimeException(e1);
        }
    }

    public static byte[] zipSerialize(Serializable pObj) {


        byte[] bytes = serialize(pObj);


        return zip(bytes);

    }

    @SuppressWarnings("unchecked")
    public static <T extends Serializable> T unzipDeserialize(byte[] pSrc) {


        byte[] bytes = unzip(pSrc);


        if(pSrc.length > 0 && bytes.length == 0){


            bytes = pSrc;
        }


        return (T)deserialize(bytes);
    }

    public static byte[] zip(byte[] pSrc) {


        try(ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ZipOutputStream zos = new ZipOutputStream(baos);){

            ZipEntry ze = new ZipEntry(sZIPENTRY_NAME);
            zos.putNextEntry(ze);


            zos.write(pSrc);


            zos.finish();
            zos.closeEntry();


            byte[] bytes = baos.toByteArray();

            return bytes;
        }catch (Exception e1) {

            throw new RuntimeException(e1);
        }
    }

    public static byte[] unzip(byte[] pSrc) {

        byte[] bytes;

        try (ZipInputStream zis  = new ZipInputStream(new ByteArrayInputStream(pSrc))) {
            zis.getNextEntry();


            try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

                int data;
                while ((data = zis.read()) >= 0) {
                    baos.write(data);
                }
                bytes  = baos.toByteArray();
            }

        } catch (IOException e) {

            throw new RuntimeException(e);
        }

        return bytes;
    }
}

