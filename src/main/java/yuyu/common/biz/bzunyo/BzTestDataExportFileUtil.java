package yuyu.common.biz.bzunyo;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.inject.Inject;

import jp.co.slcs.swak.SWAK;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.file.FileType;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.FilePathUtil;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BT_TestKykData;
import yuyu.infr.file.BytesSerializer;
import yuyu.infr.file.FileControlManager;

import com.google.common.io.Files;

/**
 * 業務共通 運用 テストデータ抽出用ファイルユーティリティ <br />
 */
public class BzTestDataExportFileUtil {

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private static Logger logger;

    public <T> boolean fileUpload(String pUniqueId, String pFileName, List<T> pBeanLst) {

        logger.debug("▽ ファイルアップロード 開始");

        if (BizUtil.isBlank(pUniqueId)) {

            logger.debug("△ ファイルアップロード 終了");

            return false;
        }

        if (BizUtil.isBlank(pFileName)) {

            logger.debug("△ ファイルアップロード 終了");

            return false;
        }

        if (pBeanLst == null || pBeanLst.size() == 0) {

            logger.debug("△ ファイルアップロード 終了");

            return false;
        }

        String filePath = SWAK.getApplicationRootPath() + YuyuBizConfig.getInstance().getItijiFileHozonsaki() + "/" + pFileName;

        String fileName1 = "";

        if (pFileName.matches(".*\\..*")) {

            fileName1 = pFileName.split("\\.")[0];
        } else {

            fileName1 = pFileName;
        }

        String dataLayoutBeanClass = "yuyu.def.biz.file.excel." + "Bz" + fileName1.substring(3) + "LayoutFile";

        FileControlManager fileControlManager = SWAKInjector.getInstance(FileControlManager.class);

        try {

            @SuppressWarnings("unchecked")
            Class<T> className = (Class<T>)Class.forName(dataLayoutBeanClass);

            fileControlManager.writeFileData(filePath, pBeanLst, className, FileType.XLSX);

            BT_TestKykData bTTestKykData = new BT_TestKykData();

            File file =  new File(filePath);

            bTTestKykData.setUniqueId(pUniqueId);

            bTTestKykData.setFileNm(pFileName);

            bTTestKykData.setTestfilecontents(BytesSerializer.zip(Files.toByteArray(file)));

            bizDomManager.insert(bTTestKykData);

        } catch (Exception e) {

            logger.debug("△ ファイルアップロード 終了");

            return false;
        }

        fileControlManager.remove(filePath);

        logger.debug("△ ファイルアップロード 終了");

        return true;
    }

    public BzTestDataExportFileUtilBean fileDownload(String pZipFileName) {

        logger.debug("▽ ファイルダウンロード 開始");

        BzTestDataExportFileUtilBean bzTestDataExportFileUtilBean = SWAKInjector.getInstance(BzTestDataExportFileUtilBean.class);

        if (BizUtil.isBlank(pZipFileName)) {

            bzTestDataExportFileUtilBean.setResult(false);

            logger.debug("△ ファイルダウンロード 終了");

            return bzTestDataExportFileUtilBean;
        }

        List <BT_TestKykData> bTTestKykDataList = bizDomManager.getAllTestKykData();

        if (bTTestKykDataList.size() == 0) {

            bzTestDataExportFileUtilBean.setResult(true);

            bzTestDataExportFileUtilBean.setCount(String.valueOf(bTTestKykDataList.size()));

            logger.debug("△ ファイルダウンロード 終了");

            return bzTestDataExportFileUtilBean;
        }

        String filePath = FilePathUtil.getBatchOutDataPath() + "/"
                + pZipFileName + ".zip";

        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(filePath));) {
            for (BT_TestKykData bTTestKykData : bTTestKykDataList) {
                zipOutputStream.putNextEntry(new ZipEntry(bTTestKykData.getFileNm()));

                zipOutputStream.write(BytesSerializer.unzip(bTTestKykData.getTestfilecontents()));

            }
            zipOutputStream.close();
        } catch (Exception e) {

            bzTestDataExportFileUtilBean.setResult(false);

            logger.debug("△ ファイルダウンロード 終了");

            return bzTestDataExportFileUtilBean;
        }

        bzTestDataExportFileUtilBean.setResult(true);

        bzTestDataExportFileUtilBean.setCount(String.valueOf(bTTestKykDataList.size()));

        logger.debug("△ ファイルダウンロード 終了");

        return bzTestDataExportFileUtilBean;

    }
}