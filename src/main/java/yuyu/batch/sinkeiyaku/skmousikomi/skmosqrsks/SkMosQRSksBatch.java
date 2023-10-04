package yuyu.batch.sinkeiyaku.skmousikomi.skmosqrsks;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.common.sinkeiyaku.skcommon.MousikomiNoUtil;
import yuyu.common.sinkeiyaku.skcommon.MousikomiNoUtilForBatch;
import yuyu.common.sinkeiyaku.skcommon.SkPreSyoruiTorikomi;
import yuyu.def.MessageId;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_MosnoSaibanKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.HT_GaibuQrYoyaku2;
import yuyu.def.sinkeiyaku.file.csv.SkMosQRSakuseiLayoutFile;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.collect.Lists;

/**
 * 新契約 申込入力 申込書類用ＱＲ作成
 */
public class SkMosQRSksBatch implements Batch {

    private static final int MAX_TRANSACTION = 1000;

    private final int FILE_SAVE_MAX_LIST_COUNT = 50000;

    private static final String ZENKAKUSPACE = "　";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW0003), bzBatchParam.getSyoriYmd().toString()));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW1018), bzBatchParam.getIbKakutyoujobcd()));

        int qrSakuseikensuuAll = 0;
        MousikomiNoUtil mousikomiNoUtil = SWAKInjector.getInstance(MousikomiNoUtil.class);

        List<HT_GaibuQrYoyaku2> gaibuQrYoyaku2Lst = selGaibuQrYoyakuData2();

        batchLogger
        .info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(gaibuQrYoyaku2Lst.size()), "QR作成予約件数"));

        if (gaibuQrYoyaku2Lst.size() >= 1) {

            for (int n = 0; n < gaibuQrYoyaku2Lst.size(); n++) {

                List<String> mosnoList = new ArrayList<String>();
                C_FileSyuruiCdKbn fileSyuruiCdKbn = C_FileSyuruiCdKbn.BLNK;
                String fileSuffix = "";
                int qrSakuseiSyorikensuu = 0;
                List<SkMosQRSakuseiLayoutFile> gaibuQrYoyakuBeanLst = new ArrayList<SkMosQRSakuseiLayoutFile>();
                int mosnoSyutokuBaisuu = gaibuQrYoyaku2Lst.get(n).getMosnosaibansuu();

                C_MosUketukeKbn mosUketukeKbn = C_MosUketukeKbn.BLNK;

                if (C_MosnoSaibanKbn.PPLESSNIT.eq(gaibuQrYoyaku2Lst.get(n).getMosnosaibankbn())) {

                    mosUketukeKbn = C_MosUketukeKbn.PAPERLESSNIT;
                }
                else {

                    mosUketukeKbn = C_MosUketukeKbn.MOSKIT;
                }

                try {

                    String mosnoChannel = mousikomiNoUtil.getMosChannel(gaibuQrYoyaku2Lst.get(n).getSkeijimukbn(),
                        mosUketukeKbn);

                    int kennsuu = gaibuQrYoyaku2Lst.get(n).getSakuseikensuu();
                    BizDate syoriYmd = bzBatchParam.getSyoriYmd();
                    mosnoList = MousikomiNoUtilForBatch.getMousikomiNo(mosnoChannel, kennsuu * mosnoSyutokuBaisuu,
                        syoriYmd);
                    batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(mosnoList.size()),
                        "申込番号採番処理を完了しました。"));

                } catch (Exception e) {

                    continue;
                }
                int loopCount = mosnoList.size() / mosnoSyutokuBaisuu;

                for (int m = 0; m < loopCount;) {

                    int syorikensuu = 0;

                    if (loopCount - m >= MAX_TRANSACTION) {
                        syorikensuu = MAX_TRANSACTION;
                    } else {
                        syorikensuu = loopCount - m;
                    }

                    try {
                        getGaibuQrYoyakuData(
                            gaibuQrYoyakuBeanLst,
                            mosnoList,
                            gaibuQrYoyaku2Lst.get(n).getSkeijimukbn(),
                            gaibuQrYoyaku2Lst.get(n).getHknsyuruino(),
                            syorikensuu,
                            m * mosnoSyutokuBaisuu,
                            mosnoSyutokuBaisuu,
                            mosUketukeKbn);
                    } catch (Exception e) {

                        throw new BizAppException(e, MessageUtil.getMessage(MessageId.EHA1051, "規定件数新契約書類取込前処理呼出処理",
                            "処理済件数", String.valueOf(m)));
                    }

                    m = m + syorikensuu;

                    qrSakuseiSyorikensuu = qrSakuseiSyorikensuu + syorikensuu;

                }

                fileSyuruiCdKbn = C_FileSyuruiCdKbn.SK_QRDATA;

                if (C_MosUketukeKbn.MOSKIT.eq(mosUketukeKbn)) {

                    fileSuffix = C_SkeijimuKbn.getContentByValue(C_SkeijimuKbn.PATTERN_QRDATA,
                        gaibuQrYoyaku2Lst.get(n).getSkeijimukbn().getValue()) + "_"
                        + gaibuQrYoyaku2Lst.get(n).getHknsyuruino();
                }
                else {

                    fileSuffix = "Nit" + "_" + gaibuQrYoyaku2Lst.get(n).getHknsyuruino();
                }

                updGaibuQrYoyakuData(gaibuQrYoyaku2Lst.get(n), gaibuQrYoyakuBeanLst, fileSyuruiCdKbn, fileSuffix);

                batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(qrSakuseiSyorikensuu),
                    gaibuQrYoyaku2Lst.get(n).getSkeijimukbn().getContent() + ZENKAKUSPACE +
                    gaibuQrYoyaku2Lst.get(n).getHknsyuruino().getContent(C_HknsyuruiNo.PATTERN_QRSKSYOYAKU)
                    + ZENKAKUSPACE +
                    mosUketukeKbn.getContent()));

                qrSakuseikensuuAll = qrSakuseikensuuAll + qrSakuseiSyorikensuu;

            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(qrSakuseikensuuAll), "外部用QR情報（合計）"));

    }

    private List<HT_GaibuQrYoyaku2> selGaibuQrYoyakuData2() {

        List<HT_GaibuQrYoyaku2> pGaibuQrYoyaku2 = sinkeiyakuDomManager.getGaibuQrYoyaku2sByQrsakuseiymdNull();

        return pGaibuQrYoyaku2;
    }

    @Transactional
    public void getGaibuQrYoyakuData(List<SkMosQRSakuseiLayoutFile> pGaibuQrYoyakuLst, List<String> pMosnoList,
        C_SkeijimuKbn pSkeijimukbn, C_HknsyuruiNo pDisphknsyuruino, int pSyoriKaisuu, int pSoezi, int pBaisuu,
        C_MosUketukeKbn pMosUketukeKbn) {

        SkPreSyoruiTorikomi skPreSyoruiTorikomi = SWAKInjector.getInstance(SkPreSyoruiTorikomi.class);

        for (int m = 0; m < pSyoriKaisuu; m++) {

            SkMosQRSakuseiLayoutFile skMosQRSakuseiLayoutFile = SWAKInjector
                .getInstance(SkMosQRSakuseiLayoutFile.class);

            List<C_SyoruiCdKbn> syoruiCdLst = new ArrayList<>();
            if (C_MosUketukeKbn.MOSKIT.eq(pMosUketukeKbn)) {
                syoruiCdLst.add(C_SyoruiCdKbn.SK_MOSSYO);
                syoruiCdLst.add(C_SyoruiCdKbn.SK_TORIHOUSYO);
                syoruiCdLst.add(C_SyoruiCdKbn.SK_UKTHUKUSUUSITEI);
            }

            String setmosno1 = "";
            if (pBaisuu == 2) {

                setmosno1 = pMosnoList.get(pSoezi + m * pBaisuu + 1);
            }

            String[] qrCd = skPreSyoruiTorikomi.sinkykSyoruiTorikomiMany(
                pMosnoList.get(pSoezi + m * pBaisuu),
                syoruiCdLst.toArray(new C_SyoruiCdKbn[syoruiCdLst.size()]),
                pSkeijimukbn,
                pDisphknsyuruino,
                pMosUketukeKbn,
                null,
                setmosno1);

            skMosQRSakuseiLayoutFile.setIfcSkeijimukbn(pSkeijimukbn.getContent());
            skMosQRSakuseiLayoutFile.setIfcHknsyuruino(pDisphknsyuruino.getContent(C_HknsyuruiNo.PATTERN_QRSKSYOYAKU));
            skMosQRSakuseiLayoutFile.setIfcMosno(pMosnoList.get(pSoezi + m * pBaisuu));

            if (C_MosUketukeKbn.MOSKIT.eq(pMosUketukeKbn)) {

                skMosQRSakuseiLayoutFile.setIfcQrmotodata1(qrCd[0]);
                skMosQRSakuseiLayoutFile.setIfcQrmotodata2(qrCd[1]);
                skMosQRSakuseiLayoutFile.setIfcQrmotodata3(qrCd[2]);
            }
            else {

                skMosQRSakuseiLayoutFile.setIfcQrmotodata1(null);
                skMosQRSakuseiLayoutFile.setIfcQrmotodata2(null);
                skMosQRSakuseiLayoutFile.setIfcQrmotodata3(null);
            }

            skMosQRSakuseiLayoutFile.setIfcQrmotodata4(null);
            skMosQRSakuseiLayoutFile.setIfcQrmotodata5(null);
            skMosQRSakuseiLayoutFile.setIfcQrmotodata6(null);
            skMosQRSakuseiLayoutFile.setIfcSetmosno1(setmosno1);

            pGaibuQrYoyakuLst.add(skMosQRSakuseiLayoutFile);
        }
    }

    @Transactional
    public void updGaibuQrYoyakuData(
        HT_GaibuQrYoyaku2 pHtGaibuQrYoyaku2,
        List<SkMosQRSakuseiLayoutFile> pGaibuQrYoyakuLst,
        C_FileSyuruiCdKbn pCFileSyuruiCdKbn,
        String pFileSuffix) {

        int renNo = 1;

        BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);

        if (!pGaibuQrYoyakuLst.isEmpty()) {

            List<List<SkMosQRSakuseiLayoutFile>> lls = Lists.partition(pGaibuQrYoyakuLst, FILE_SAVE_MAX_LIST_COUNT);

            for (List<SkMosQRSakuseiLayoutFile> list : lls) {
                bzFileUploadUtil.exec(pCFileSyuruiCdKbn, list, true, pFileSuffix + "_" + renNo);
                renNo = renNo + 1;

            }

        }

        pHtGaibuQrYoyaku2.setQrsakuseiymd(bzBatchParam.getSyoriYmd());
        pHtGaibuQrYoyaku2.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        pHtGaibuQrYoyaku2.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

        sinkeiyakuDomManager.update(pHtGaibuQrYoyaku2);

    }
}
