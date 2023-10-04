package yuyu.batch.sinkeiyaku.sksonota.skthankscallkeiyakuitiransks;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.sinkeiyaku.sksonota.skthankscallkeiyakuitiransks.dba.SkThanksCallKeiyakuInfoBean;
import yuyu.batch.sinkeiyaku.sksonota.skthankscallkeiyakuitiransks.dba.SkThanksCallKeiyakuItiranSksDao;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.biz.bzdairiten.BzGetBsInfo;
import yuyu.common.biz.bzdairiten.BzGetBsInfoBean;
import yuyu.common.biz.bzfiledl.BzFileUploadUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_DiritenjyouhouKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_Kyksei;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.file.excel.SkThanksCallKeiyakuItiranLayoutFile;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 新契約 その他 サンクスコール対象契約一覧作成
 */
public class SkThanksCallKeiyakuItiranSksBatch implements Batch {

    private static final String TYSYTTAISYOU_TABLE_ID = HT_SyoriCTL.TABLE_NAME;

    private static final String RECOVERY_FILTER_KBNID = "Sk001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private SkThanksCallKeiyakuItiranSksDao skThanksCallKeiyakuItiranSksDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        String ibKakutyoujobCd = bzBatchParam.getIbKakutyoujobcd();
        long syoriKensuu = 0;
        List<SkThanksCallKeiyakuItiranLayoutFile> skThanksCallKeiyakuItiranLayoutFileList = new ArrayList<>();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW0003), String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW1018), ibKakutyoujobCd));

        try (
            ExDBResults<SkThanksCallKeiyakuInfoBean> skThanksCallKeiyakuInfoBeanList =
            skThanksCallKeiyakuItiranSksDao.getSkThanksCallKeiyakuInfo(ibKakutyoujobCd, syoriYmd);) {

            for (SkThanksCallKeiyakuInfoBean skThanksCallKeiyakuInfoBean : skThanksCallKeiyakuInfoBeanList) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(ibKakutyoujobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOU_TABLE_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERY_FILTER_KBNID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(skThanksCallKeiyakuInfoBean.getMosno());

                int kyknen = 0;

                if (C_KykKbn.KEIHI_BETU.eq(skThanksCallKeiyakuInfoBean.getKykkbn())) {

                    kyknen = skThanksCallKeiyakuInfoBean.getKyknen();
                }
                else {

                    kyknen = skThanksCallKeiyakuInfoBean.getHhknnen();
                }

                if (kyknen < 70 || kyknen > 79) {

                    continue;
                }

                HT_SyoriCTL syoriCTL = sinkeiyakuDomManager.getSyoriCTL(skThanksCallKeiyakuInfoBean.getMosno());
                HT_MosKihon mosKihon = syoriCTL.getMosKihon();
                HT_MosDairiten mosDairiten1 = syoriCTL.getMosDairitenByRenno(1);
                HT_MosDairiten mosDairiten2 = syoriCTL.getMosDairitenByRenno(2);

                String kyknmKj = "";
                String kyknmKn = "";
                String kykseiYmd = "";
                String kykSei = "";

                if (C_KykKbn.KEIHI_BETU.eq(skThanksCallKeiyakuInfoBean.getKykkbn())) {

                    kyknmKj = mosKihon.getKyknmkj();
                    kyknmKn = mosKihon.getKyknmkn();
                    kykseiYmd = mosKihon.getKykseiymd().toString();
                    kykSei = mosKihon.getKyksei().getContent(C_Kyksei.PATTERN_RYAKU);
                }
                else {

                    kyknmKj = mosKihon.getHhknnmkj();
                    kyknmKn = mosKihon.getHhknnmkn();
                    kykseiYmd = mosKihon.getHhknseiymd().toString();
                    kykSei = mosKihon.getHhknsei().getContent(C_Hhknsei.PATTERN_RYAKU);
                }

                String drtenNm = "";
                BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);

                List<BzGetAgInfoBean> bzGetAgInfoBeanList = bzGetAgInfo.exec(mosDairiten1.getTratkiagcd());

                for (BzGetAgInfoBean bzGetAgInfoBean : bzGetAgInfoBeanList) {

                    if (C_DiritenjyouhouKbn.KEISYOUKO.eq(bzGetAgInfoBean.getDiritenJyouhouKbn())) {

                        drtenNm = bzGetAgInfoBean.getKanjiDairitenNm();
                    }
                }

                String bosyuuninNm1 = "";
                String bosyuuninNm2 = "";
                BzGetBsInfo bzGetBsInfo = SWAKInjector.getInstance(BzGetBsInfo.class);

                BzGetBsInfoBean bzGetBsInfoBean = bzGetBsInfo.exec(mosDairiten1.getBosyuucd());
                if (bzGetBsInfoBean != null) {
                    bosyuuninNm1 = bzGetBsInfoBean.getKanjiBosyuuninNm();
                }

                if (mosDairiten2 != null) {

                    BzGetBsInfoBean bzGetBsInfoBean2 = bzGetBsInfo.exec(mosDairiten2.getBosyuucd());
                    if (bzGetBsInfoBean2 != null) {
                        bosyuuninNm2 = bzGetBsInfoBean2.getKanjiBosyuuninNm();
                    }
                }

                BizCurrency pYen = BizCurrency.valueOf(0);
                GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
                KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                if (C_Tuukasyu.JPY.eq(mosKihon.getHrktuukasyu())) {

                    pYen = mosKihon.getFstphrkgk();
                }
                else {

                    C_ErrorKbn kekkaKbn = getKawaseRate.execHyoukagk(
                        syoriCTL.getRyosyuymd(),
                        mosKihon.getKyktuukasyu(),
                        C_Tuukasyu.JPY,
                        C_YouhiKbn.YOU,
                        mosKihon.getHrkkaisuu(),
                        mosKihon.getZennoumousideumu(),
                        mosKihon.getIkkatubaraikbn());

                    if (C_ErrorKbn.ERROR.eq(kekkaKbn)) {

                        throw new CommonBizAppException("評価額算出用為替レート（契約時）取得に失敗しました。" +
                            "領収日：" + syoriCTL.getRyosyuymd().toString() +
                            "元通貨：" + mosKihon.getKyktuukasyu().getValue() +
                            "換算通貨：" + C_Tuukasyu.JPY.getValue() +
                            "前営業日為替レート取得要否：" + C_YouhiKbn.YOU.getValue() +
                            "払込回数：" + mosKihon.getHrkkaisuu().getValue() +
                            "前納申出有無：" + mosKihon.getZennoumousideumu().getValue() +
                            "一括払区分：" + mosKihon.getIkkatubaraikbn().getValue());
                    }

                    pYen = keisanGaikakanzan.exec(
                        C_Tuukasyu.JPY,
                        mosKihon.getSeitoufstpkei(),
                        getKawaseRate.getKawaserate(),
                        C_HasuusyoriKbn.SUTE);
                }

                String paperlessmosHyj = "";

                if (C_MosUketukeKbn.PAPERLESS.eq(syoriCTL.getMosuketukekbn())) {

                    paperlessmosHyj = "1";
                }
                else {

                    paperlessmosHyj = "0";
                }

                SkThanksCallKeiyakuItiranLayoutFile skThanksCallKeiyakuItiranLayoutFile =
                    SWAKInjector.getInstance(SkThanksCallKeiyakuItiranLayoutFile.class);

                skThanksCallKeiyakuItiranLayoutFile.setIfeSyono(syoriCTL.getSyono());
                skThanksCallKeiyakuItiranLayoutFile.setIfeKyknmkj(kyknmKj);
                skThanksCallKeiyakuItiranLayoutFile.setIfeKyknmkn(kyknmKn);
                skThanksCallKeiyakuItiranLayoutFile.setIfeKykseiymd(kykseiYmd);
                skThanksCallKeiyakuItiranLayoutFile.setIfeKykseistr(kykSei);
                skThanksCallKeiyakuItiranLayoutFile.setIfeKyksyokugyou("");
                skThanksCallKeiyakuItiranLayoutFile.setIfeHhknnmkj(mosKihon.getHhknnmkj());
                skThanksCallKeiyakuItiranLayoutFile.setIfeTelno(mosKihon.getTsintelno());
                skThanksCallKeiyakuItiranLayoutFile.setIfeTelno2(mosKihon.getDai2tsintelno());
                skThanksCallKeiyakuItiranLayoutFile.setIfeTratkiagnm(drtenNm);
                skThanksCallKeiyakuItiranLayoutFile.setIfeBosyuunm1(bosyuuninNm1);
                skThanksCallKeiyakuItiranLayoutFile.setIfeBosyuunm2(bosyuuninNm2);
                skThanksCallKeiyakuItiranLayoutFile.setIfeSeirituymd(syoriCTL.getSrsyoriymd().toString());
                skThanksCallKeiyakuItiranLayoutFile.setIfeMosymd(mosKihon.getMosymd().toString());
                skThanksCallKeiyakuItiranLayoutFile.setIfeKykymd(mosKihon.getKykymd().toString());
                skThanksCallKeiyakuItiranLayoutFile.setIfeSyoukenttykymd(syoriCTL.getSrsyoriymd().addBusinessDays(4).toString());
                skThanksCallKeiyakuItiranLayoutFile.setIfeCoolingoffymd(mosKihon.getMosymd().addDays(7).toString());
                skThanksCallKeiyakuItiranLayoutFile.setIfeAisyoumei(mosKihon.getAisyoumeikbn().getContent());
                skThanksCallKeiyakuItiranLayoutFile.setIfeHrktuuka(mosKihon.getHrktuukasyu().getContent());
                skThanksCallKeiyakuItiranLayoutFile.setIfeSiteituuka(mosKihon.getKyktuukasyu().getContent());
                skThanksCallKeiyakuItiranLayoutFile.setIfePgaika(mosKihon.getSeitoufstpkei().toString(new DecimalFormat("0.00")));
                skThanksCallKeiyakuItiranLayoutFile.setIfePyen(pYen.toString());
                skThanksCallKeiyakuItiranLayoutFile.setIfePaperlessmoshyj(paperlessmosHyj);

                skThanksCallKeiyakuItiranLayoutFileList.add(skThanksCallKeiyakuItiranLayoutFile);

                syoriKensuu = syoriKensuu + 1;
            }

            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        BzFileUploadUtil bzFileUploadUtil = SWAKInjector.getInstance(BzFileUploadUtil.class);

        bzFileUploadUtil.exec(
            C_FileSyuruiCdKbn.SK_THANKSCALLKEIYAKUITIRAN,
            skThanksCallKeiyakuItiranLayoutFileList,
            true);


        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKensuu),
            C_FileSyuruiCdKbn.SK_THANKSCALLKEIYAKUITIRAN.getContent()));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);
        bzBatchAbendCommonRecovery.exec();
    }
}
