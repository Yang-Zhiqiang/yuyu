package yuyu.common.sinkeiyaku.skcommon;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.def.MessageId;

/**
 * 新契約 シェルスクリプト実行ユーティリティクラス
 */
public class ShellUtil {

    private int exeValue = -1;

    private String stdOut = null;

    public ShellUtil() {
        super();
    }

    public void exec(String pCommand, String[] pParams, String pDir) {

        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader br = null;

        try {

            Process process;

            if (pDir == null) {
                process = Runtime.getRuntime().exec(pCommand, pParams);
            } else {
                File fileDir = new File(pDir);
                process = Runtime.getRuntime().exec(pCommand, pParams, fileDir);
            }

            process.waitFor();

            exeValue = process.exitValue();

            inputStream = process.getInputStream();

            if (inputStream != null) {

                inputStreamReader = new InputStreamReader(inputStream);
                br = new BufferedReader(inputStreamReader);

                @SuppressWarnings("hiding")
                String stdOut;
                StringBuffer sbStdOut = new StringBuffer();

                while ((stdOut = br.readLine()) != null) {
                    sbStdOut.append(stdOut);
                    sbStdOut.append(ISkCommonKoumoku.KAIGYOU_CD);
                }

                stdOut = sbStdOut.toString();
            }
        } catch (Exception e) {
            throw new BizAppException(e, MessageUtil.getMessage(MessageId.EBF0011));
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e) {
                    throw new BizAppException(e, MessageUtil.getMessage(MessageId.EBF0011));
                }
            }
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (Exception e) {
                    throw new BizAppException(e, MessageUtil.getMessage(MessageId.EBF0011));
                }
            }
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                    throw new BizAppException(e, MessageUtil.getMessage(MessageId.EBF0011));
                }
            }
        }
    }

    public void exec(String pCommand, String pDir) {
        exec(pCommand, null, pDir);
    }

    public String getStdOut() {
        return stdOut;
    }

    public int getExeValue() {
        return exeValue;
    }

}
