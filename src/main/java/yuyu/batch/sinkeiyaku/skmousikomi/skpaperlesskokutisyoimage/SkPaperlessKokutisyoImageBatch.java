package yuyu.batch.sinkeiyaku.skmousikomi.skpaperlesskokutisyoimage;

import java.io.File;
import java.io.FilenameFilter;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
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
 * 新契約 ペーパーレス告知書イメージ取込
 */
public class SkPaperlessKokutisyoImageBatch implements Batch {

    public static final String JOB_ID  = "RAZP7001Z";

    public static final String SK_PPLESSKOKUSYO_SEIHOWEB  = "02";

    public static final String PUtIMAGE_KEKKA_NG  = "9";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam batchParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    private long errorCount = 0l;

    private long successCount = 0l;

    @Override
    public BatchParam getParam() {
        return batchParam;
    }

    @Execute
    public void execute() {

        String syoriYmd = batchParam.getSyoriYmd().toString();
        String kakutyouJobCd = batchParam.getIbKakutyoujobcd();

        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003), String.valueOf(syoriYmd)));
        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018), String.valueOf(kakutyouJobCd)));

        YuyuBaseConfig config = YuyuBaseConfig.getInstance();
        String filePath = config.getBatchInputDir();

        File[] arcFiles = new File(filePath).listFiles(
            new FilenameFilter() {
                @Override
                public boolean accept (File dir, String name) {
                    if (name.startsWith(JOB_ID)) {
                        return true;
                    }
                    return false;
                }
            });

        if (arcFiles.length == 0) {

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0003));
        }

        for (int i = 0; i < arcFiles.length; i++) {

            addPaperlessImageFile(arcFiles[i].getAbsolutePath());
        }

        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBF0002, String.valueOf(successCount), "ペーパレス告知書イメージデータ取込OK"));
        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBF0002, String.valueOf(errorCount), "ペーパレス告知書イメージデータ取込NG"));
    }

    @Transactional
    void addPaperlessImageFile(String pFilePath) {

        String workDir = PaperlessUtil.openArchiveFile(pFilePath);

        File[] mosNoDir = new File(workDir).listFiles();

        if (mosNoDir.length == 0) {
            throw new BizAppException(MessageUtil.getMessage(MessageId.EHF1008, PaperlessUtil.getFilename(pFilePath)));
        }

        SkProcessCreate processCreate;

        for (int j = 0; j < mosNoDir.length; j++) {

            if (!mosNoDir[j].isDirectory()) {
                continue;
            }

            String mosNo = mosNoDir[j].getName();

            if (!PaperlessUtil.checkDirNm(mosNo)) {
                batchLogger.error(MessageUtil.getMessage(MessageId.EHF1009, mosNo));
                continue;
            }

            String tyouhyouInfoPath = PaperlessUtil.joinPath(mosNoDir[j].getPath(), mosNo
                + ISkCommonKoumoku.CHOHYO_JOHO_DATA_EXT);

            if (!PaperlessUtil.checkFileReadable(tyouhyouInfoPath)) {

                batchLogger.error(MessageUtil.getMessage(MessageId.EHF1010, mosNo));

                continue;
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

            addImages(mosNoDir[j].getPath(), listChohyoJohoDatas, kouteiKanriId);

        }

        PaperlessUtil.removeWorkDir(workDir);
    }

    private void addImages(String pMosImagePath, List<Map<String, String>> pImageDatas, String pKouteiKanriId) {

        Map<String, String> imageData;

        for (int i = 0; i < pImageDatas.size(); i++) {

            imageData = pImageDatas.get(i);

            C_SyoruiCdKbn syoruiCd = null;
            String tyouhyouSakuseiKbn = imageData.get(ISkCommonKoumoku.TYOHYOU_SAKUSEI_KBN);

            if (SK_PPLESSKOKUSYO_SEIHOWEB.equals(tyouhyouSakuseiKbn)) {
                syoruiCd = C_SyoruiCdKbn.SK_PPLESSKOKUSYO;
            } else {
                continue;
            }

            String imageFilePath = PaperlessUtil.joinPath(pMosImagePath,
                imageData.get(ISkCommonKoumoku.IMG_FILE_NAME));

            File file = new File(imageFilePath);

            if (!file.exists()) {
                batchLogger.error(MessageUtil.getMessage(MessageId.EHF1011, PaperlessUtil.getFilename(pMosImagePath)));
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

            if (PaperlessUtil.getImageProps(C_SyoruiCdKbn.SK_PPLESSKOKUSYO, pKouteiKanriId)) {
                errorCount++;
                continue;
            }

            BzPutImage bzPutImage = SWAKInjector.getInstance(BzPutImage.class);
            BzPutImageInputBean imageInBean = SWAKInjector.getInstance(BzPutImageInputBean.class);
            imageInBean.setSyoruiCd(syoruiCd);
            imageInBean.setUserId(batchParam.getUserId());
            imageInBean.setImageDatas(decriptedImage);
            imageInBean.setKouteiKanriId(pKouteiKanriId);
            imageInBean.setSyoruiTtykYmdTime(BizDate.getSysDateTimeMilli());
            imageInBean.setTourokuYmdTime(BizDate.getSysDateTimeMilli());
            BzPutImageOutputBean bzPutImageOutputBean = bzPutImage.exec(imageInBean);

            if (PUtIMAGE_KEKKA_NG.equals(bzPutImageOutputBean.getKekkaStatus())) {
                errorCount++;
            } else {
                successCount++;
            }

            BzOutputProcessRecord bzOutputProcessRecord = SWAKInjector.getInstance(BzOutputProcessRecord.class);

            bzOutputProcessRecord.exec(pKouteiKanriId,
                ISkCommonKoumoku.JIMUTETUZUKICD_SKMAINDAIRITEN,
                C_SyoruiCdKbn.getContentByValue(C_UmuKbn.PATTERN_DEFAULT, String.valueOf(syoruiCd)),
                "ペーパーレス告知書イメージ取込",
                C_SyorikekkaKbn.BLNK);
        }
    }
}
