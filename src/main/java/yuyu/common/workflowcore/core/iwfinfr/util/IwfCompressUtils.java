package yuyu.common.workflowcore.core.iwfinfr.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

/**
 */
public class IwfCompressUtils {

    public static byte[] compress(String src) {

        Deflater zipCompresser = new Deflater();
        try {
            zipCompresser.setInput(src.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        zipCompresser.finish();
        int size;
        byte[] buffer = new byte[1024];
        byte[] compressed = null;

        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        while (true) {
            size = zipCompresser.deflate(buffer);
            stream.write(buffer, 0, size);
            if (zipCompresser.finished()) {
                break;
            }
        }
        compressed = stream.toByteArray();
        try {
            stream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return compressed;

    }

    public static String uncompress(byte[] compressed) {

        Inflater zipDecompresser = new Inflater();
        zipDecompresser.setInput(compressed);

        int size;
        byte[] result = null;
        byte[] buffer = new byte[1024];

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        try {

            while (true) {
                size = zipDecompresser.inflate(buffer);
                stream.write(buffer, 0, size);
                if (zipDecompresser.finished()) {
                    break;
                }
            }
            result = stream.toByteArray();
        } catch (DataFormatException e) {
            throw new RuntimeException("zip圧縮ではありません。", e);
        }

        try {
            stream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            return new String(result, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

}
