package yuyu.batch.hozen.khinterf.khauthorikekkatorikomi;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khinterf.khauthorikekkatorikomi.dba.AuthoriKekkaDataBean;
import yuyu.batch.hozen.khinterf.khauthorikekkatorikomi.dba.KhAuthoriKekkaTorikomiDao;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.db.entity.IT_BunrimaeAuthoriKekka;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 インターフェイス オーソリ結果Ｆ取込クラス
 */
public class KhAuthoriKekkaTorikomiBatch implements Batch {

    private static final String TYSYTTAISYOUTABLEID = "ZT_AuthoriKekkaTr";

    private static final String RECOVERYFILTERIDKBNID = "Kh003";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhAuthoriKekkaTorikomiDao khAuthoriKekkaTorikomiDao;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {

        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        long syoriKensuu = 0;
        BizDate syoriYMD = bzBatchParam.getSyoriYmd();
        String kakutyoujobCd = bzBatchParam.getIbKakutyoujobcd();
        String kinouID = khozenCommonParam.getFunctionId();
        String sousasyaCd  = khozenCommonParam.getUserID();
        String kosTime = BizDate.getSysDateTimeMilli();
        String maerecordkessaiyouno = "";
        String maerecorddatajyusinymd = "";

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW0003), String.valueOf(syoriYMD)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(
            MessageId.IBW1018), kakutyoujobCd));

        khAuthoriKekkaTorikomiDao.deleteBunrimaeAuthoriKekka();

        try (
            ExDBResults<AuthoriKekkaDataBean> authoriKekkaDataBeanList =
            khAuthoriKekkaTorikomiDao.getAuthoriKekkaDataBeans(kakutyoujobCd);
            EntityInserter<IT_BunrimaeAuthoriKekka> entityInserter = new EntityInserter<>()) {

            for (AuthoriKekkaDataBean authoriKekkaDataBean : authoriKekkaDataBeanList) {

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOUTABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERYFILTERIDKBNID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(authoriKekkaDataBean.getZtrcreditkessaiyouno());

                if (maerecordkessaiyouno.equals(authoriKekkaDataBean.getZtrcreditkessaiyouno()) &&
                    maerecorddatajyusinymd.equals(authoriKekkaDataBean.getZtrdatajyusinymd())) {
                    continue;
                }
                else {
                    maerecordkessaiyouno = authoriKekkaDataBean.getZtrcreditkessaiyouno();
                    maerecorddatajyusinymd = authoriKekkaDataBean.getZtrdatajyusinymd();
                }

                IT_BunrimaeAuthoriKekka bunrimaeAuthoriKekka = new IT_BunrimaeAuthoriKekka(
                    authoriKekkaDataBean.getZtrcreditkessaiyouno(),
                    authoriKekkaDataBean.getZtrdatajyusinymd());

                bunrimaeAuthoriKekka.setSyoriYmd (syoriYMD);
                bunrimaeAuthoriKekka.setKaiintourokukbn(authoriKekkaDataBean.getZtrkaiintourokukbn());
                bunrimaeAuthoriKekka.setCreditcardno(authoriKekkaDataBean.getZtrcardno());
                bunrimaeAuthoriKekka.setCardyuukoukigen4keta(authoriKekkaDataBean.getZtrcardyuukoukigen());
                bunrimaeAuthoriKekka.setAuthorigk7keta(authoriKekkaDataBean.getZtrauthorigkjyusin());
                bunrimaeAuthoriKekka.setAuthorikekkaerrorcd(authoriKekkaDataBean.getZtrauthorikekkaerrorcd());
                bunrimaeAuthoriKekka.setBluegateerrorcd(authoriKekkaDataBean.getZtrbluegateerrorcd());
                bunrimaeAuthoriKekka.setHisimukekaisyacd(authoriKekkaDataBean.getZtrhisimukekaisyacd());
                bunrimaeAuthoriKekka.setWentryuserid(authoriKekkaDataBean.getZtrwentryuserid());
                bunrimaeAuthoriKekka.setErrorcomment(authoriKekkaDataBean.getZtrerrorcomment());
                bunrimaeAuthoriKekka.setNiniinfo(authoriKekkaDataBean.getZtrniniinfo());
                bunrimaeAuthoriKekka.setDatasyorijyoukyou(authoriKekkaDataBean.getZtrdatasyorijyoukyou());
                bunrimaeAuthoriKekka.setGyoumuKousinKinou(kinouID);
                bunrimaeAuthoriKekka.setGyoumuKousinsyaId(sousasyaCd);
                bunrimaeAuthoriKekka.setGyoumuKousinTime(kosTime);

                BizPropertyInitializer.initialize(bunrimaeAuthoriKekka);

                entityInserter.add(bunrimaeAuthoriKekka);

                syoriKensuu = syoriKensuu + 1;
            }

            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector
            .getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }

}
