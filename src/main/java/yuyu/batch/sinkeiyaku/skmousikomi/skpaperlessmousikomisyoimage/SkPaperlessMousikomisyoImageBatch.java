package yuyu.batch.sinkeiyaku.skmousikomi.skpaperlessmousikomisyoimage;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BzPutImage;
import yuyu.common.biz.bzcommon.BzPutImageInputBean;
import yuyu.common.biz.bzcommon.BzPutImageOutputBean;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.koutei.BzOutputProcessRecord;
import yuyu.common.sinkeiyaku.koutei.SkProcessCreate;
import yuyu.common.sinkeiyaku.koutei.SkProcessCreateInBean;
import yuyu.common.sinkeiyaku.skcommon.ISkCommonKoumoku;
import yuyu.common.sinkeiyaku.skcommon.PaperlessUtil;
import yuyu.def.MessageId;
import yuyu.def.base.configuration.YuyuBaseConfig;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_MosMikakuteiJyouhouKanri;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;
import yuyu.infrext.encrypt.RayAes128Ecryptor;

/**
 * 新契約 申込入力 ペーパーレス申込書イメージ取込
 */
public class SkPaperlessMousikomisyoImageBatch implements Batch {

    public static final String JOB_ID  = "RAZP7AK1Z";

    public static final String SK_PPLESSMOSIKOUKAKSYO_SEIHOWEB    = "01";

    public static final String SK_PPLESSTORIHOUSYO_SEIHOWEB       = "83";

    public static final String PUtIMAGE_KEKKA_NG  = "9";

    public static final int MAX_SYORI_CNT  = 2;

    public static final String SEARCH_KEY_KR  = "KR";

    public static final char SEARCH_KEY_AM  = '0';

    public static final char SEARCH_KEY_PM  = '1';

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private SkPaperlessMousikomisyoImageBatchParam skPaperlessMousikomisyoImageBatchParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    private long errorCount = 0l;

    private long successCount = 0l;

    private SkProcessCreate processCreate = null;

    @Override
    public BatchParam getParam() {

        return skPaperlessMousikomisyoImageBatchParam;
    }

    public String syoriYmd = "";

    @Execute
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW0003), String.valueOf(skPaperlessMousikomisyoImageBatchParam.getSyoriYmd())));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW1018), skPaperlessMousikomisyoImageBatchParam.getIbKakutyoujobcd()));

        String torikomumotocd = skPaperlessMousikomisyoImageBatchParam.getTorikomumotocd();

        syoriYmd = skPaperlessMousikomisyoImageBatchParam.getSyoriYmd().toString();

        YuyuBaseConfig config = YuyuBaseConfig.getInstance();
        String filePath = "";

        List<String> fileNames= new ArrayList<String>();
        int syoriCnt = 0;
        int maxKurikosiNm = 300;

        File batchIn = new File(config.getBatchInputDir());

        FilenameFilter fileterKR = new FilenameFilter(){
            @Override
            public boolean accept(File pFrile, String pStr){
                if(pStr.indexOf(JOB_ID) != -1 &&
                    pStr.indexOf(SEARCH_KEY_KR) != -1){
                    return true;
                }
                return false;
            }
        };

        File[] listFilesKR = batchIn.listFiles(fileterKR);

        if(listFilesKR != null && listFilesKR.length > 0){
            List<String> fileNamesKR = new ArrayList<String>();
            for(File file : listFilesKR){
                fileNamesKR.add(file.getName());
            }
            Collections.sort(fileNamesKR);

            for(String filename : fileNamesKR){
                if(syoriCnt < MAX_SYORI_CNT){
                    fileNames.add(filename);
                    syoriCnt++;
                }else{
                    break;
                }
            }

            String last = fileNamesKR.get(fileNamesKR.size()-1);
            int idx = last.indexOf(SEARCH_KEY_KR);
            maxKurikosiNm = Integer.parseInt(last.substring(idx+2, idx+5));
        }

        File[] listFilesToujitu = null;

        if ("1".equals(torikomumotocd)) {
            FilenameFilter fileterAM = new FilenameFilter(){
                @Override
                public boolean accept(File pFrile, String pStr){
                    if(pStr.indexOf(JOB_ID + syoriYmd) != -1 &&
                        SEARCH_KEY_AM == pStr.charAt(19)){
                        return true;
                    }
                    return false;
                }
            };
            listFilesToujitu = batchIn.listFiles(fileterAM);
        }
        else {
            FilenameFilter fileterPM = new FilenameFilter(){
                @Override
                public boolean accept(File pFrile, String pStr){
                    if(pStr.indexOf(JOB_ID + syoriYmd) != -1 &&
                        SEARCH_KEY_PM == pStr.charAt(19)){
                        return true;
                    }
                    return false;
                }
            };
            listFilesToujitu = batchIn.listFiles(fileterPM);
        }

        if(listFilesToujitu != null && listFilesToujitu.length > 0){
            List<String> fileNamesToujitu = new ArrayList<String>();
            for(File file : listFilesToujitu){
                fileNamesToujitu.add(file.getName());
            }
            Collections.sort(fileNamesToujitu);

            for(String filename : fileNamesToujitu){
                if(syoriCnt < MAX_SYORI_CNT){
                    fileNames.add(filename);
                    syoriCnt++;
                }else{
                    maxKurikosiNm++;
                    String renameZipFileNm =
                        JOB_ID +
                        syoriYmd +
                        SEARCH_KEY_KR+
                        String.valueOf(maxKurikosiNm)+
                        ISkCommonKoumoku.ZIP_EXT;

                    File renameTo = new File(PaperlessUtil.joinPath(config.getBatchInputDir(),
                        renameZipFileNm));
                    File renameFrom = new File(PaperlessUtil.joinPath(config.getBatchInputDir(),
                        filename));
                    renameFrom.renameTo(renameTo);
                    batchLogger.info("繰越対象あり：" + filename + " ⇒ "+ renameZipFileNm);
                }
            }
        }

        for (String fileName : fileNames) {

            batchLogger.info("処理対象：" + fileName);
            filePath = PaperlessUtil.joinPath(config.getBatchInputDir(), fileName);

            String workDir = PaperlessUtil.openArchiveFile(filePath);

            File[] mosNoDir = new File(workDir).listFiles();

            if (mosNoDir.length == 0) {
                throw new BizAppException(MessageUtil.getMessage(MessageId.EHF1008, PaperlessUtil.getFilename(filePath)));
            }

            for (int i = 0; i < mosNoDir.length; i++) {
                execMosNoDir(mosNoDir[i]);
            }

            PaperlessUtil.removeWorkDir(workDir);
            PaperlessUtil.removeWorkDir(filePath);
        }

        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBF0002, String.valueOf(successCount), "ペーパレス申込書イメージデータ取込OK"));
        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBF0002, String.valueOf(errorCount), "ペーパレス申込書イメージデータ取込NG"));
    }

    @Transactional
    void execMosNoDir(File pMosNoDir) {

        if (!pMosNoDir.isDirectory()) {
            return;
        }

        String mosNo = pMosNoDir.getName();

        if (!PaperlessUtil.checkDirNm(mosNo)) {
            batchLogger.error(MessageUtil.getMessage(MessageId.EHF1009, mosNo));
            return;
        }

        String tyouhyouInfoPath = PaperlessUtil.joinPath(pMosNoDir.getPath(), mosNo
            + ISkCommonKoumoku.CHOHYO_JOHO_DATA_EXT);

        if (!PaperlessUtil.checkFileReadable(tyouhyouInfoPath)) {
            batchLogger.error(MessageUtil.getMessage(MessageId.EHF1010, mosNo));

            return;
        }

        List<Map<String, String>> listChohyoJohoDatas = PaperlessUtil.readFileData(tyouhyouInfoPath);

        SkProcessCreateInBean processCreatInBean = SWAKInjector.getInstance(SkProcessCreateInBean.class);

        HT_MosMikakuteiJyouhouKanri mosMikakuteiJyouhouKanri = sinkeiyakuDomManager.getMosMikakuteiJyouhouKanri(mosNo);

        if (mosMikakuteiJyouhouKanri == null) {
            batchLogger.error(MessageUtil.getMessage(MessageId.EBS0004, "HT_MosMikakuteiJyouhouKanri", "申込番号", mosNo));
            throw new CommonBizAppException("申込番号 = " + mosNo);
        }

        processCreatInBean.setSkeiJimuKbn(mosMikakuteiJyouhouKanri.getSkeijimukbn());
        processCreatInBean.setMosUketukeKbn(C_MosUketukeKbn.PAPERLESS);
        processCreatInBean.setHknSyuruiNo(mosMikakuteiJyouhouKanri.getHknsyuruino());
        processCreatInBean.setJimuStartYmd(BizDate.getSysDateTimeMilli());
        processCreatInBean.setMosNo(mosNo);
        processCreatInBean.setJimuTetuzukiCd(ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN);

        processCreate = SWAKInjector.getInstance(SkProcessCreate.class);
        String kouteiKanriId = processCreate.exec(processCreatInBean);

        addImages(pMosNoDir.getPath(), listChohyoJohoDatas, kouteiKanriId);

    }

    private void addImages(String pMosImagePath, List<Map<String, String>> pImageDatas, String pKouteiKanriId) {

        Map<String, String> imageData;

        for (int i = 0; i < pImageDatas.size(); i++) {

            imageData = pImageDatas.get(i);

            C_SyoruiCdKbn syoruiCd = null;
            String tyouhyouSakuseiKbn = imageData.get(ISkCommonKoumoku.TYOHYOU_SAKUSEI_KBN);
            if (SK_PPLESSMOSIKOUKAKSYO_SEIHOWEB.equals(tyouhyouSakuseiKbn)) {
                syoruiCd = C_SyoruiCdKbn.SK_PPLESSMOSIKOUKAKSYO;
            } else if (SK_PPLESSTORIHOUSYO_SEIHOWEB.equals(tyouhyouSakuseiKbn)) {
                syoruiCd = C_SyoruiCdKbn.SK_PPLESSTORIHOUSYO;
            } else {
                continue;
            }

            String imageFilePath = PaperlessUtil.joinPath(pMosImagePath,
                imageData.get(ISkCommonKoumoku.IMG_FILE_NAME));

            File file = new File(imageFilePath);

            if (!file.exists()) {

                batchLogger.error(MessageUtil.getMessage(
                    MessageId.EHF1011, PaperlessUtil.getFilename(pMosImagePath)));

                continue;
            }

            byte[] image = PaperlessUtil.readFileByte(imageFilePath);

            RayAes128Ecryptor encriptor = SWAKInjector.getInstance(RayAes128Ecryptor.class);

            byte[] decriptedImage = encriptor.decrypt(image);

            if ((decriptedImage.length == 0) || (decriptedImage.length > ISkCommonKoumoku.IMAGE_SIZE_LIMIT)) {
                batchLogger.error(MessageUtil.getMessage(MessageId.EHF1012,
                    PaperlessUtil.getFilename(pMosImagePath)));
                continue;
            }

            if (PaperlessUtil.getImageProps(C_SyoruiCdKbn.SK_PPLESSMOSIKOUKAKSYO, pKouteiKanriId)
                || PaperlessUtil.getImageProps(C_SyoruiCdKbn.SK_PPLESSTORIHOUSYO, pKouteiKanriId)) {
                errorCount++;
                continue;
            }

            BzPutImage bzPutImage = SWAKInjector.getInstance(BzPutImage.class);
            BzPutImageInputBean imageInBean = SWAKInjector.getInstance(BzPutImageInputBean.class);
            imageInBean.setSyoruiCd(syoruiCd);
            imageInBean.setUserId(skPaperlessMousikomisyoImageBatchParam.getUserId());
            imageInBean.setImageDatas(decriptedImage);
            imageInBean.setKouteiKanriId(pKouteiKanriId);
            imageInBean.setSyoruiTtykYmdTime(BizDate.getSysDateTimeMilli());
            imageInBean.setTourokuYmdTime(BizDate.getSysDateTimeMilli());
            BzPutImageOutputBean bzPutImageOutputBean = bzPutImage.exec(imageInBean);

            if (PUtIMAGE_KEKKA_NG.equals(bzPutImageOutputBean.getKekkaStatus())) {
                errorCount++;
            }
            else if (C_SyoruiCdKbn.SK_PPLESSMOSIKOUKAKSYO.eq(syoruiCd)) {

                successCount++;
            }

            BzOutputProcessRecord bzOutputProcessRecord = SWAKInjector.getInstance(BzOutputProcessRecord.class);

            bzOutputProcessRecord.exec(pKouteiKanriId,
                ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN,
                C_SyoruiCdKbn.getContentByValue(C_UmuKbn.PATTERN_DEFAULT, String.valueOf(syoruiCd)),
                "ペーパーレス申込書イメージ取込",
                C_SyorikekkaKbn.BLNK);
        }
    }
}
