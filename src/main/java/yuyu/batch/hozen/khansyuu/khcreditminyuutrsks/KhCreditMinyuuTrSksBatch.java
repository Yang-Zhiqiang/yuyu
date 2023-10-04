package yuyu.batch.hozen.khansyuu.khcreditminyuutrsks;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityDeleter;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khansyuu.khcreditminyuutrsks.dba.KhCreditMinyuuTrSksDao;
import yuyu.batch.hozen.khansyuu.khcreditminyuutrsks.dba.TRCreditKurikosiMinyuuBean;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.db.entity.IT_TRCreditKurikosiMinyuu;
import yuyu.def.db.entity.IT_TRMinyuu;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 案内収納 クレカ未入ＴＲ作成
 */
public class KhCreditMinyuuTrSksBatch implements Batch {

    private static final String TABLEID = IT_TRCreditKurikosiMinyuu.TABLE_NAME;

    private static final String FILTERID = "Bz001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhCreditMinyuuTrSksDao khCreditMinyuuTrSksDao;

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

        long syoriCnt = 0;
        long renno = 0;
        String trMinyuuRenno = "";
        String syono = "";
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        String kinouID = khozenCommonParam.getFunctionId();
        String userID = khozenCommonParam.getUserID();
        String sysDateTime = BizDate.getSysDateTimeMilli();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(bzBatchParam.getSyoriYmd())));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018),
            bzBatchParam.getIbKakutyoujobcd()));

        try (ExDBResults<TRCreditKurikosiMinyuuBean> creditKurikosiMinyuuBeanList =
            khCreditMinyuuTrSksDao.getTRCreditKurikosiMinyuuBeans(bzBatchParam.getIbKakutyoujobcd());

            EntityInserter<IT_TRMinyuu> entityInserter = new EntityInserter<>();
            EntityDeleter<IT_TRCreditKurikosiMinyuu> entityDeleter = new EntityDeleter<>()) {

            for (TRCreditKurikosiMinyuuBean creditKurikosiMinyuuBean : creditKurikosiMinyuuBeanList) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(TABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(creditKurikosiMinyuuBean.getSyono());

                if (syono.equals(creditKurikosiMinyuuBean.getSyono())) {
                    renno++;
                }
                else {
                    renno = 1;
                    syono = creditKurikosiMinyuuBean.getSyono();
                }

                trMinyuuRenno = sysDateTime + renno;

                IT_TRMinyuu trMinyuu = new IT_TRMinyuu(creditKurikosiMinyuuBean.getSyono(),
                    bzBatchParam.getSyoriYmd(), trMinyuuRenno);

                trMinyuu.setNykkeiro(creditKurikosiMinyuuBean.getNykkeiro());
                trMinyuu.setNyknaiyoukbn(creditKurikosiMinyuuBean.getNyknaiyoukbn());
                trMinyuu.setJyuutouym(creditKurikosiMinyuuBean.getJyuutouym());
                trMinyuu.setJyutoukaisuuy(creditKurikosiMinyuuBean.getJyutoukaisuuy());
                trMinyuu.setJyutoukaisuum(creditKurikosiMinyuuBean.getJyutoukaisuum());
                trMinyuu.setRsgaku(creditKurikosiMinyuuBean.getRsgaku());
                trMinyuu.setRyosyuymd(creditKurikosiMinyuuBean.getRyosyuymd());
                trMinyuu.setHurihunokbn(creditKurikosiMinyuuBean.getHurihunokbn());
                trMinyuu.setBankcd(creditKurikosiMinyuuBean.getBankcd());
                trMinyuu.setSitencd(creditKurikosiMinyuuBean.getSitencd());
                trMinyuu.setYokinkbn(creditKurikosiMinyuuBean.getYokinkbn());
                trMinyuu.setKouzano(creditKurikosiMinyuuBean.getKouzano());
                trMinyuu.setDantaikobetukbn(creditKurikosiMinyuuBean.getDantaikobetukbn());
                trMinyuu.setHrkkaisuu(creditKurikosiMinyuuBean.getHrkkaisuu());
                trMinyuu.setKzhurikaetkbtannaihyj(creditKurikosiMinyuuBean.getKzhurikaetkbtannaihyj());
                trMinyuu.setTikiktbrisyuruikbn(creditKurikosiMinyuuBean.getTikiktbrisyuruikbn());
                trMinyuu.setCreditkessaiyouno(creditKurikosiMinyuuBean.getCreditkessaiyouno());
                trMinyuu.setCredituriagengjiyuu(creditKurikosiMinyuuBean.getCredituriagengjiyuu());
                trMinyuu.setGyoumuKousinKinou(kinouID);
                trMinyuu.setGyoumuKousinsyaId(userID);
                trMinyuu.setGyoumuKousinTime(sysDateTime);

                BizPropertyInitializer.initialize(trMinyuu);

                entityInserter.add(trMinyuu);

                IT_TRCreditKurikosiMinyuu trCreditKurikosiMinyuuDel =
                    hozenDomManager.getTRCreditKurikosiMinyuu(
                        creditKurikosiMinyuuBean.getSyono(),
                        creditKurikosiMinyuuBean.getSyoriYmd(),
                        creditKurikosiMinyuuBean.getMinyuutrrenno());

                entityDeleter.add(trCreditKurikosiMinyuuDel);

                syoriCnt++;
            }

            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0020, String.valueOf(syoriCnt)));

    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector
            .getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }

}
