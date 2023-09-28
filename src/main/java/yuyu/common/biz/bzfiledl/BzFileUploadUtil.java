package yuyu.common.biz.bzfiledl;

import java.io.File;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.SWAK;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.configuration.CoreConfig;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.file.FileType;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_FileSyurui;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.infr.file.FileControlManager;
import yuyu.infr.file.FileHozonUtil;

import com.google.common.base.Strings;

/**
 * 業務共通 ファイルダウンロード ファイルアップロードユーティリティ <br />
 */
public class BzFileUploadUtil {

    @Inject
    private static Logger logger;

    @Inject
    private BaseDomManager baseDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BzBatchParam bzBatchParam;

    public BzFileUploadUtil() {
        super();
    }

    public <T> C_ErrorKbn exec(C_FileSyuruiCdKbn pFileSyuruiCdKbn, List<T> pBeanLst, boolean pfileDateFlg) {

        logger.debug("▽ ファイルアップロードユーティリティ 開始");

        if (pFileSyuruiCdKbn == null) {
            logger.debug("△ ファイルアップロードユーティリティ 終了");
            return C_ErrorKbn.ERROR;
        }

        FileHozonUtil fileHozonUtil = SWAKInjector.getInstance(FileHozonUtil.class);

        FileControlManager fileControlManager = SWAKInjector.getInstance(FileControlManager.class);

        AS_FileSyurui fileSyurui = baseDomManager.getFileSyurui(pFileSyuruiCdKbn);

        if (fileSyurui == null) {
            logger.debug("△ ファイルアップロードユーティリティ 終了");
            return C_ErrorKbn.ERROR;
        }

        String fileName = fileSyurui.getDownloadFileNm();
        String fileType = fileSyurui.getFileType();
        String dataLayoutBeanClass = fileSyurui.getDataLayoutBeanClass();
        C_UmuKbn createEmptyFileUmuKbn = fileSyurui.getCreateEmptyFileUmuKbn();

        if (BizUtil.isBlank(fileName)) {
            logger.debug("△ ファイルアップロードユーティリティ 終了");
            return C_ErrorKbn.ERROR;
        }

        if (BizUtil.isBlank(fileType)) {
            logger.debug("△ ファイルアップロードユーティリティ 終了");
            return C_ErrorKbn.ERROR;
        }

        if (BizUtil.isBlank(dataLayoutBeanClass)) {
            logger.debug("△ ファイルアップロードユーティリティ 終了");
            return C_ErrorKbn.ERROR;
        }

        if (createEmptyFileUmuKbn == null) {
            logger.debug("△ ファイルアップロードユーティリティ 終了");
            return C_ErrorKbn.ERROR;
        }

        String fileName1 = "";
        String fileName2 = "";

        if (pfileDateFlg) {
            if (fileName.matches(".*\\..*")) {
                fileName1 = fileName.split("\\.")[0];
                fileName2 =  "." + fileName.split("\\.")[1];
            }
            else {
                fileName1 = fileName;
            }

            if (CoreConfig.getInstance().isBatchProduct()) {
                BizDate batchSyoriYmd =  bzBatchParam.getSyoriYmd();
                fileName = fileName1 + "_"+ batchSyoriYmd.toString() + fileName2;
            }
            else {
                fileName = fileName1 + "_"+ BizDate.getSysDate().toString() + fileName2;
            }
        }

        File  file =  new File(SWAK.getApplicationRootFile() + YuyuBizConfig.getInstance().getItijiFileHozonsaki()
                + "/" + fileName);

        boolean createEmptyFile = false;
        if (C_UmuKbn.ARI.eq(createEmptyFileUmuKbn)) {
            createEmptyFile = true;
        }
        try {
            @SuppressWarnings("unchecked")
            Class<T> className = (Class<T>)Class.forName(dataLayoutBeanClass);
            fileControlManager.writeFileData(file.getPath(), pBeanLst, className, FileType.valueOf(fileType), createEmptyFile);

        } catch (Exception e) {
            throw new BizAppException(e, MessageId.EBF0163, file.getName());
        }

        fileHozonUtil.putFile(YuyuBizConfig.getInstance().getItijiFileHozonsaki() + "/" + fileName, pFileSyuruiCdKbn,
                "", kinou.getKinouId());

        fileControlManager.remove(file.getPath());

        logger.debug("△ ファイルアップロードユーティリティ 終了");

        return C_ErrorKbn.OK;

    }

    public <T> C_ErrorKbn exec(C_FileSyuruiCdKbn pFileSyuruiCdKbn, List<T> pBeanLst, boolean pfileDateFlg, String pExFileNm) {

        logger.debug("▽ ファイルアップロードユーティリティ 開始");

        if (pFileSyuruiCdKbn == null) {
            logger.debug("△ ファイルアップロードユーティリティ 終了");
            return C_ErrorKbn.ERROR;
        }

        FileHozonUtil fileHozonUtil = SWAKInjector.getInstance(FileHozonUtil.class);

        FileControlManager fileControlManager = SWAKInjector.getInstance(FileControlManager.class);

        AS_FileSyurui fileSyurui = baseDomManager.getFileSyurui(pFileSyuruiCdKbn);

        if (fileSyurui == null) {
            logger.debug("△ ファイルアップロードユーティリティ 終了");
            return C_ErrorKbn.ERROR;
        }

        String fileName = fileSyurui.getDownloadFileNm();
        String fileType = fileSyurui.getFileType();
        String dataLayoutBeanClass = fileSyurui.getDataLayoutBeanClass();
        C_UmuKbn createEmptyFileUmuKbn = fileSyurui.getCreateEmptyFileUmuKbn();

        if (BizUtil.isBlank(fileName)) {
            logger.debug("△ ファイルアップロードユーティリティ 終了");
            return C_ErrorKbn.ERROR;
        }

        if (BizUtil.isBlank(fileType)) {
            logger.debug("△ ファイルアップロードユーティリティ 終了");
            return C_ErrorKbn.ERROR;
        }

        if (BizUtil.isBlank(dataLayoutBeanClass)) {
            logger.debug("△ ファイルアップロードユーティリティ 終了");
            return C_ErrorKbn.ERROR;
        }

        if (createEmptyFileUmuKbn == null) {
            logger.debug("△ ファイルアップロードユーティリティ 終了");
            return C_ErrorKbn.ERROR;
        }

        String fileName1 = "";
        String fileName2 = "";

        if (fileName.matches(".*\\..*")) {
            fileName1 = fileName.split("\\.")[0];
            fileName2 =  "." + fileName.split("\\.")[1];
        } else {
            fileName1 = fileName;
        }

        if (pfileDateFlg) {

            if (CoreConfig.getInstance().isBatchProduct()) {
                BizDate batchSyoriYmd =  bzBatchParam.getSyoriYmd();
                fileName1 = fileName1 + "_"+ batchSyoriYmd.toString();
            }
            else {
                fileName1 = fileName1 + "_"+ BizDate.getSysDate().toString();
            }
        }

        if (!Strings.isNullOrEmpty(pExFileNm)) {
            fileName = fileName1 + "_"+ pExFileNm +  fileName2;
        } else {
            fileName = fileName1 + fileName2;
        }

        if (fileName.length() > 100) {
            logger.debug("△ ファイルアップロードユーティリティ 終了");
            return C_ErrorKbn.ERROR;
        }

        File  file =  new File(SWAK.getApplicationRootFile() + YuyuBizConfig.getInstance().getItijiFileHozonsaki()
                + "/" + fileName);

        boolean createEmptyFile = false;
        if (C_UmuKbn.ARI.eq(createEmptyFileUmuKbn)) {
            createEmptyFile = true;
        }
        try {
            @SuppressWarnings("unchecked")
            Class<T> className = (Class<T>)Class.forName(dataLayoutBeanClass);
            fileControlManager.writeFileData(file.getPath(), pBeanLst, className, FileType.valueOf(fileType), createEmptyFile);

        } catch (Exception e) {
            throw new BizAppException(e, MessageId.EBF0163, file.getName());
        }

        fileHozonUtil.putFile(YuyuBizConfig.getInstance().getItijiFileHozonsaki() + "/" + fileName, pFileSyuruiCdKbn,
                "", kinou.getKinouId());

        fileControlManager.remove(file.getPath());

        logger.debug("△ ファイルアップロードユーティリティ 終了");

        return C_ErrorKbn.OK;

    }

}