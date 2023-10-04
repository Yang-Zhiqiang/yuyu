package yuyu.batch.hozen.khansyuu.khkzhuriminyuutrkurikosi;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khansyuu.khkzhuriminyuutrkurikosi.dba.KhKzhuriMinyuuTrKurikosiDao;
import yuyu.batch.hozen.khansyuu.khkzhuriminyuutrkurikosi.dba.TRKzhuriKurikosiMinyuuBean;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.db.entity.IT_TRKzhuriKurikosiMinyuu;
import yuyu.def.db.entity.IT_TRMinyuu;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 案内収納 口座振替未入ＴＲ繰越処理クラス
 */
public class KhKzhuriMinyuuTrKurikosiBatch implements Batch {

    private static final String TABLEID = IT_TRKzhuriKurikosiMinyuu.TABLE_NAME;

    private static final String RECOVERY_FILTER_KBNID = "Kh001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhKzhuriMinyuuTrKurikosiDao khKzhuriMinyuuTrKurikosiDao;

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

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            String.valueOf(bzBatchParam.getIbKakutyoujobcd())));

        int syoriKensuu = 0;
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        String kinouId = khozenCommonParam.getFunctionId();
        String userId = khozenCommonParam.getUserID();
        String sysDateTimeMilli = BizDate.getSysDateTimeMilli();
        String kakutyouJobCd = bzBatchParam.getIbKakutyoujobcd();

        try (ExDBResults<TRKzhuriKurikosiMinyuuBean> tRKzhuriKurikosiMinyuuBeanLst = khKzhuriMinyuuTrKurikosiDao.
            getTRKzhuriKurikosiMinyuuBeans(kakutyouJobCd);
            EntityInserter<IT_TRMinyuu> entityInserter = new EntityInserter<>(); ) {

            for (TRKzhuriKurikosiMinyuuBean tRKzhuriKurikosiMinyuuBean : tRKzhuriKurikosiMinyuuBeanLst) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyouJobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERY_FILTER_KBNID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(tRKzhuriKurikosiMinyuuBean.getKbnkey());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(tRKzhuriKurikosiMinyuuBean.getSyono());

                IT_TRMinyuu tRMinyuu = new IT_TRMinyuu(tRKzhuriKurikosiMinyuuBean.getSyono(),
                    tRKzhuriKurikosiMinyuuBean.getSyoriYmd(), tRKzhuriKurikosiMinyuuBean.getMinyuutrrenno());

                tRMinyuu.setNykkeiro(tRKzhuriKurikosiMinyuuBean.getNykkeiro());
                tRMinyuu.setNyknaiyoukbn(tRKzhuriKurikosiMinyuuBean.getNyknaiyoukbn());
                tRMinyuu.setJyuutouym(tRKzhuriKurikosiMinyuuBean.getJyuutouym());
                tRMinyuu.setJyutoukaisuuy(tRKzhuriKurikosiMinyuuBean.getJyutoukaisuuy());
                tRMinyuu.setJyutoukaisuum(tRKzhuriKurikosiMinyuuBean.getJyutoukaisuum());
                tRMinyuu.setRsgaku(tRKzhuriKurikosiMinyuuBean.getRsgaku());
                tRMinyuu.setRyosyuymd(tRKzhuriKurikosiMinyuuBean.getRyosyuymd());
                tRMinyuu.setHurihunokbn(tRKzhuriKurikosiMinyuuBean.getHurihunokbn());
                tRMinyuu.setBankcd(tRKzhuriKurikosiMinyuuBean.getBankcd());
                tRMinyuu.setSitencd(tRKzhuriKurikosiMinyuuBean.getSitencd());
                tRMinyuu.setYokinkbn(tRKzhuriKurikosiMinyuuBean.getYokinkbn());
                tRMinyuu.setKouzano(tRKzhuriKurikosiMinyuuBean.getKouzano());
                tRMinyuu.setDantaikobetukbn(tRKzhuriKurikosiMinyuuBean.getDantaikobetukbn());
                tRMinyuu.setHrkkaisuu(tRKzhuriKurikosiMinyuuBean.getHrkkaisuu());
                tRMinyuu.setKzhurikaetkbtannaihyj(tRKzhuriKurikosiMinyuuBean.getKzhurikaetkbtannaihyj());
                tRMinyuu.setTikiktbrisyuruikbn(tRKzhuriKurikosiMinyuuBean.getTikiktbrisyuruikbn());
                tRMinyuu.setCreditkessaiyouno(tRKzhuriKurikosiMinyuuBean.getCreditkessaiyouno());
                tRMinyuu.setCredituriagengjiyuu(tRKzhuriKurikosiMinyuuBean.getCredituriagengjiyuu());
                tRMinyuu.setGyoumuKousinKinou(kinouId);
                tRMinyuu.setGyoumuKousinsyaId(userId);
                tRMinyuu.setGyoumuKousinTime(sysDateTimeMilli);

                BizPropertyInitializer.initialize(tRMinyuu);

                entityInserter.add(tRMinyuu);

                syoriKensuu = syoriKensuu + 1;
            }

            khKzhuriMinyuuTrKurikosiDao.deleteTRKzhuriKurikosiMinyuu();
        }

        bzRecoveryDatasikibetuBean.initializeBlank();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));

    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {
        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector
            .getInstance(BzBatchAbendCommonRecovery.class);
        bzBatchAbendCommonRecovery.exec();
    }
}
