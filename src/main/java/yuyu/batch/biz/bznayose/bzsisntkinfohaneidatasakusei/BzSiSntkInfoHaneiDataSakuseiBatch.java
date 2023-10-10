package yuyu.batch.biz.bznayose.bzsisntkinfohaneidatasakusei;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.google.common.base.Strings;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_KankeisyaKbn;
import yuyu.def.classification.C_KdssSiharaiJyoutaiKbn;
import yuyu.def.classification.C_SntkInfoTourokuSysKbn;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.JT_SiSentakuInfoTouroku;
import yuyu.def.db.entity.ZT_SntkInfoTourokuTy;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 業務共通 名寄せ 保険金給付金用選択情報反映データ作成クラス
 */
public class BzSiSntkInfoHaneiDataSakuseiBatch implements Batch {

    private final String SYONORENNOFILTERID = "Bz002";

    private final String SNTKINFOKBN = "00";

    private final String SISENTAKUINFOTOUROKUID = "JT_SiSentakuInfoTouroku";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {

        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(bzBatchParam.getSyoriYmd())));

        try (ExDBUpdatableResults<JT_SiSentakuInfoTouroku> siSentakuInfoTourokuLst =
            siharaiDomManager.getSiSentakuInfoTourokusByKakutyoujobcdSyorizumiflg(bzBatchParam.getIbKakutyoujobcd(),
                C_Syorizumiflg.MISYORI);

            EntityInserter<ZT_SntkInfoTourokuTy> sntkInfoTourokuTyInserter = new EntityInserter<>()) {
            long syoriKensuu = 0;

            for (JT_SiSentakuInfoTouroku siSentakuInfoTouroku : siSentakuInfoTourokuLst) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(SISENTAKUINFOTOUROKUID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(SYONORENNOFILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(siSentakuInfoTouroku.getSyono());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(siSentakuInfoTouroku.getRenno().toString());

                ZT_SntkInfoTourokuTy sntkInfoTourokuTy = new ZT_SntkInfoTourokuTy();

                sntkInfoTourokuTy.setZtysntkinfono(siSentakuInfoTouroku.getSyono());
                sntkInfoTourokuTy.setZtyrenno(Strings.padStart(
                    siSentakuInfoTouroku.getRenno().toString(), 2, '0'));
                sntkInfoTourokuTy.setZtysntkinfotourokusyskbn(C_SntkInfoTourokuSysKbn.SIHARAI.getValue());
                if (siSentakuInfoTouroku.getSyoriYmd() != null) {

                    sntkInfoTourokuTy.setZtysyoriymd(String.valueOf(siSentakuInfoTouroku.getSyoriYmd()));
                }
                sntkInfoTourokuTy.setZtyhuho2kyknokbn(siSentakuInfoTouroku.getHuho2kyknokbn().getValue());
                sntkInfoTourokuTy.setZtyhuho2kykno(siSentakuInfoTouroku.getHuho2kykno());
                sntkInfoTourokuTy.setZtysyouhncd(siSentakuInfoTouroku.getSyouhncd());
                sntkInfoTourokuTy.setZtysntkinfofkojinkbn(SNTKINFOKBN);
                sntkInfoTourokuTy.setZtytaisyounm(siSentakuInfoTouroku.getTaisyounmkn());
                sntkInfoTourokuTy.setZtykjtaisyounm(siSentakuInfoTouroku.getTaisyounmkj());
                if (siSentakuInfoTouroku.getTaisyouseiymd() != null) {

                    sntkInfoTourokuTy.setZtytaisyouseiymd(String.valueOf(siSentakuInfoTouroku.getTaisyouseiymd()));
                }

                sntkInfoTourokuTy.setZtytaisyouseibetu(siSentakuInfoTouroku.getTaisyouseibetu().getValue());
                if (siSentakuInfoTouroku.getKdsssiharaiymd() != null) {

                    sntkInfoTourokuTy.setZtykdsssiharaiymd(String.valueOf(siSentakuInfoTouroku.getKdsssiharaiymd()));
                }
                if (siSentakuInfoTouroku.getKdsymd() != null) {

                    sntkInfoTourokuTy.setZtykdsymd(String.valueOf(siSentakuInfoTouroku.getKdsymd()));
                }

                sntkInfoTourokuTy.setZtykdssiharaisosikicd(siSentakuInfoTouroku.getKdssiharaisosikicd());

                if (C_KankeisyaKbn.BLNK.eq(siSentakuInfoTouroku.getSntkinfokankeisyakbn())) {

                    sntkInfoTourokuTy.setZtysntkinfofsegkbn("");
                }
                else {
                    sntkInfoTourokuTy.setZtysntkinfofsegkbn(
                        siSentakuInfoTouroku.getSntkinfokankeisyakbn().getValue());
                }

                if (C_KdssSiharaiJyoutaiKbn.BLNK.eq(siSentakuInfoTouroku.getKdsssiharaijyoutaikbn())) {

                    sntkInfoTourokuTy.setZtykdsssiharaijyoutaikbn("");
                }
                else {
                    sntkInfoTourokuTy.setZtykdsssiharaijyoutaikbn(
                        siSentakuInfoTouroku.getKdsssiharaijyoutaikbn().getValue());
                }

                sntkInfoTourokuTy.setZtydakuhiketnaiyouarihyj(
                    convBlnktkumukbn(siSentakuInfoTouroku.getDakuhiketnaiyouumukbn()));

                sntkInfoTourokuTy.setZtykktnaiyouarihyj(
                    convBlnktkumukbn(siSentakuInfoTouroku.getKktnaiyouumukbn()));

                sntkInfoTourokuTy.setZtykijinaiyouarihyj(
                    convBlnktkumukbn(siSentakuInfoTouroku.getKijinaiyouumukbn()));

                sntkInfoTourokuTy.setZtymrarihyj(convBlnktkumukbn(siSentakuInfoTouroku.getMrumukbn()));

                sntkInfoTourokuTy.setZtykoudosyougaiarihyj(
                    convBlnktkumukbn(siSentakuInfoTouroku.getKoudosyougaiumukbn()));

                sntkInfoTourokuTy.setZtytorikaijoarihyj(convBlnktkumukbn(siSentakuInfoTouroku.getTorikaijoumukbn()));

                BizPropertyInitializer.initialize(sntkInfoTourokuTy);

                siSentakuInfoTouroku.setSyorizumiflg(C_Syorizumiflg.SYORIZUMI);
                siSentakuInfoTouroku.setGyoumuKousinKinou(kinou.getKinouId());
                siSentakuInfoTouroku.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                siSentakuInfoTouroku.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                sntkInfoTourokuTyInserter.add(sntkInfoTourokuTy);

                syoriKensuu++;
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
                String.valueOf(syoriKensuu), kinou.getKinouNm()));
        }
    }

    private String convBlnktkumukbn(C_BlnktkumuKbn pBefore) {

        String after = "";

        if (C_BlnktkumuKbn.BLNK.eq(pBefore)) {
            after = "";
        }
        else if (C_BlnktkumuKbn.ARI.eq(pBefore)) {
            after = "1";
        }
        else {
            after = "0";
        }
        return after;
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
