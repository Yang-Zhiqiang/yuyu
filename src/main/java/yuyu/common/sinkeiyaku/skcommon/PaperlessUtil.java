package yuyu.common.sinkeiyaku.skcommon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.util.string.StringUtil;
import yuyu.common.biz.bzcommon.BzGetImageProps;
import yuyu.common.biz.bzcommon.BzGetImagePropsInBean;
import yuyu.common.biz.bzcommon.BzGetImagePropsOutBean;
import yuyu.def.MessageId;
import yuyu.def.base.configuration.YuyuBaseConfig;
import yuyu.def.classification.C_Kouteikanristatus;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.infr.file.FileControlManager;

import com.google.common.collect.Lists;

/**
 * 新契約 ペーパーレスユーティリティ
 */
public class PaperlessUtil {

    public static final String UNZIP_COMMAND  = "unzip -q";

    public static final String UNZIP_PARAM    = "-d";

    public static final String ERROR_MOS_NO   = "000000000";

    public static final int MOS_NO_LENGTH     = 9;

    public PaperlessUtil() {
        super();
    }

    public static byte[] readFileByte(String pFilePath) {

        File file = null;
        @SuppressWarnings("resource")
        FileInputStream fileInputStream = null;
        byte[] imageData;

        try {
            file = new File(pFilePath);
            imageData = new byte[(int) file.length()];

            fileInputStream = new FileInputStream(pFilePath);
            fileInputStream.read(imageData);

        } catch (Exception e) {
            throw new BizAppException(e, MessageUtil.getMessage(MessageId.EBF0011));
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e) {
                    throw new BizAppException(e, MessageUtil.getMessage(MessageId.EBF0011));
                }
            }
        }
        return imageData;
    }


    public static String[] readFileString(String pFilePath) {
        BufferedReader inputBufferedReader = null;
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;

        List<String> dataList = new ArrayList<String>();
        String[] datas = null;

        try {
            fileInputStream = new FileInputStream(pFilePath);
            inputStreamReader = new InputStreamReader(fileInputStream, "MS932");
            inputBufferedReader = new BufferedReader(inputStreamReader);

            String data = "";
            while ((data = inputBufferedReader.readLine()) != null) {
                dataList.add(data);
            }
            datas = dataList.toArray(new String[dataList.size()]);
        } catch (Exception e) {
            throw new BizAppException(e, MessageUtil.getMessage(MessageId.EBF0011));
        } finally {
            if (inputBufferedReader != null) {
                try {
                    inputBufferedReader.close();
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
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e) {
                    throw new BizAppException(e, MessageUtil.getMessage(MessageId.EBF0011));
                }
            }
        }
        return datas;
    }

    public static List<Map<String, String>> readFileData(String pPath) {

        List<Map<String, String>> fileDataList = Lists.newArrayList();
        Map<String, String> fileData;

        String[] fileInfoDatas = PaperlessUtil.readFileString(pPath);

        for (String fileInfo : fileInfoDatas) {

            fileData = new HashMap<String, String>();
            fileData.put(ISkCommonKoumoku.TYOHYOU_SAKUSEI_KBN, fileInfo.substring(16, 18));
            fileData.put(ISkCommonKoumoku.MOS_NO, fileInfo.substring(73, 83));
            fileData.put(ISkCommonKoumoku.IMG_FILE_NAME, fileInfo.substring(209, 230).trim());
            fileDataList.add(fileData);
        }

        return fileDataList;
    }


    public static String getFilename(String pPath) {

        int index = getSeparatorPosition(pPath);

        if (index < 0) {
            return pPath;
        }

        return pPath.substring(index + 1);
    }

    public static int getSeparatorPosition(String pPath) {

        int index1 = pPath.lastIndexOf("/");
        int index2 = pPath.lastIndexOf("\\");

        if (index2 > index1) {
            return index2;
        }

        return index1;
    }

    public static String joinPath(String pPrePath, String pPostPath) {

        StringBuilder sbPath = new StringBuilder(pPrePath);

        if ((!pPrePath.endsWith("/")) && (!pPrePath.endsWith("\\"))) {

            if ((!pPostPath.startsWith("/")) && (!pPostPath.startsWith("\\"))) {
                sbPath.append('/');
                sbPath.append(pPostPath);
            } else {
                sbPath.append(pPostPath);
            }
        } else {
            if ((!pPostPath.startsWith("/")) && (!pPostPath.startsWith("\\"))) {
                sbPath.append(pPostPath);
            } else {
                sbPath.append(pPostPath.substring(1));
            }
        }
        return sbPath.toString();
    }

    public static String openArchiveFile(String pPath) {

        String workDir = createWorkDir(pPath);

        String shellCommand = UNZIP_COMMAND + ISkCommonKoumoku.HALF_SPACE + pPath
            + ISkCommonKoumoku.HALF_SPACE + UNZIP_PARAM + ISkCommonKoumoku.HALF_SPACE + workDir;
        ShellUtil shellUtil = SWAKInjector.getInstance(ShellUtil.class);

        shellUtil.exec(shellCommand, workDir);

        if (shellUtil.getExeValue() != 0) {

            throw new BizAppException(MessageUtil.getMessage(MessageId.EHF1007, PaperlessUtil.getFilename(pPath)));

        }

        return workDir;
    }

    public static boolean checkFileReadable(String pPath) {

        File file = new File(pPath);

        if (!file.exists() || !file.canRead()) {
            return false;
        }
        return true;
    }

    public static boolean checkDirNm(String pDir) {

        if (pDir.length() != MOS_NO_LENGTH
            || ERROR_MOS_NO.equals(pDir)
            || !StringUtil.isDigit(pDir)) {

            return false;
        }
        return true;
    }

    public static String createWorkDir(String pPath) {

        YuyuBaseConfig config = YuyuBaseConfig.getInstance();
        String workDir = config.getBatchOutputDir();

        String fileName = PaperlessUtil.getFilename(pPath);

        int idx = fileName.lastIndexOf('.');

        if (idx > 0) {

            workDir = PaperlessUtil.joinPath(workDir, fileName.substring(0, idx));

            removeWorkDir(workDir);

            FileControlManager fileControlManager = SWAKInjector.getInstance(FileControlManager.class);

            fileControlManager.createDir(workDir);

        }

        return workDir;

    }

    public static void removeWorkDir(String pPath) {

        File file = new File(pPath);

        if (file.exists()) {

            FileControlManager fileControlManager = SWAKInjector.getInstance(FileControlManager.class);

            fileControlManager.remove(pPath);
        }
    }

    public static boolean getImageProps(C_SyoruiCdKbn pSyoruiCdKbn, String pKouteiKanriId) {

        BzGetImageProps bzGetImageProps = SWAKInjector.getInstance(BzGetImageProps.class);
        BzGetImagePropsInBean imagePropsInBean = SWAKInjector.getInstance(BzGetImagePropsInBean.class);

        imagePropsInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);
        imagePropsInBean.setKouteiKanriId(pKouteiKanriId);
        imagePropsInBean.setSyoruiCd(pSyoruiCdKbn);
        imagePropsInBean.setKouteiKanriStatus(C_Kouteikanristatus.SYORITYUU);

        BzGetImagePropsOutBean outBean = bzGetImageProps.exec(imagePropsInBean);

        if (outBean.getBzGetImagePropsBeanLst().size() != 0) {
            return true;

        }
        return false;
    }

}
