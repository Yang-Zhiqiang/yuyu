package yuyu.batch.hozen.khansyuu.khuriageseikyuuminyuukkhanei;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityUpdater;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khansyuu.khuriageseikyuuminyuukkhanei.dba.KhUriageSeikyuuMinyuuKkHaneiDao;
import yuyu.batch.hozen.khansyuu.khuriageseikyuuminyuukkhanei.dba.TRCreditKurikosiMinyuuBean;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.classification.C_AnnaijkKbn;
import yuyu.def.classification.C_CreditUriageNgJiyuuKbn;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_AnsyuRireki;
import yuyu.def.db.mapping.GenIT_TRCreditKurikosiMinyuu;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 案内収納 売上請求未入結果反映のバッチクラスです。
 */
public class KhUriageSeikyuuMinyuuKkHaneiBatch implements Batch {

    private static final String TABLEID = GenIT_TRCreditKurikosiMinyuu.TABLE_NAME;

    private static final String FILTERID = "Kh001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private KhUriageSeikyuuMinyuuKkHaneiDao khUriageSeikyuuMinyuuKkHaneiDao;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Inject
    private HozenDomManager hozenDomManager;

    @Override
    public BatchParam getParam() {

        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        String kakutyouJobCd = bzBatchParam.getIbKakutyoujobcd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW0003), String.valueOf(syoriYmd)));
        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW1018), String.valueOf(kakutyouJobCd)));

        long syorikensuu = 0;
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        String kinouId = khozenCommonParam.getFunctionId();
        String userId = khozenCommonParam.getUserID();
        String systemYmdTime = BizDate.getSysDateTimeMilli();

        try(
            ExDBResults<TRCreditKurikosiMinyuuBean> tRCreditKurikosiMinyuuBeanList =
            khUriageSeikyuuMinyuuKkHaneiDao.getTRCreditMinyuus(kakutyouJobCd, syoriYmd);

            EntityUpdater<IT_AnsyuKihon> updater = new EntityUpdater<IT_AnsyuKihon>();) {

            for (TRCreditKurikosiMinyuuBean tRCreditKurikosiMinyuuBean : tRCreditKurikosiMinyuuBeanList) {
                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyouJobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(tRCreditKurikosiMinyuuBean.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(tRCreditKurikosiMinyuuBean.getSyono());

                IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(tRCreditKurikosiMinyuuBean.getSyono());

                List<IT_AnsyuRireki> ansyuRirekiList = khUriageSeikyuuMinyuuKkHaneiDao.getAnsyuRirekis(
                    ansyuKihon, tRCreditKurikosiMinyuuBean.getNyknaiyoukbn(),
                    tRCreditKurikosiMinyuuBean.getJyuutouym(), tRCreditKurikosiMinyuuBean.getNykkeiro(),
                    tRCreditKurikosiMinyuuBean.getJyutoukaisuuy(), tRCreditKurikosiMinyuuBean.getJyutoukaisuum(),
                    tRCreditKurikosiMinyuuBean.getRsgaku(), tRCreditKurikosiMinyuuBean.getRyosyuymd(),
                    C_AnnaijkKbn.ANNAI);

                if (ansyuRirekiList.size() != 0) {

                    IT_AnsyuRireki ansyuRireki = ansyuRirekiList.get(0);

                    if (!tRCreditKurikosiMinyuuBean.getCredituriagengjiyuu().eq(C_CreditUriageNgJiyuuKbn.SEIJYOU)) {
                        ansyuRireki.setAnnaijkkbn(C_AnnaijkKbn.MINYUU);
                    }
                    ansyuRireki.setCredituriagengjiyuu(tRCreditKurikosiMinyuuBean.getCredituriagengjiyuu());
                    ansyuRireki.setGyoumuKousinKinou(kinouId);
                    ansyuRireki.setGyoumuKousinsyaId(userId);
                    ansyuRireki.setGyoumuKousinTime(systemYmdTime);

                    updater.add(ansyuKihon);
                }

                syorikensuu++;
            }
            bzRecoveryDatasikibetuBean.initializeBlank();
        }
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syorikensuu)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }

}
