package yuyu.batch.hozen.khozen.khkanyuusyanoinfosakujyo;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityUpdater;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.hozen.khozen.khkanyuusyanoinfosakujyo.dba.KhKanyuusyanoInfoSakujyoDao;
import yuyu.batch.hozen.khozen.khkanyuusyanoinfosakujyo.dba.KhLincSousinDataBean;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.db.entity.IT_KhLincSousinData;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 契約保全 契約保全 契約保全加入者番号情報削除
 */
public class KhKanyuusyanoInfoSakujyoBatch implements Batch {

    private static final String TYSYTTAISYOU_TABLE_ID = IT_KhLincSousinData.TABLE_NAME;

    private static final String RECOVERY_FILTER_KBNID = "Kh001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private KhKanyuusyanoInfoSakujyoDao khKanyuusyanoInfoSakujyoDao;

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

        String kakutyoujobcd = bzBatchParam.getIbKakutyoujobcd();

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW0003), String.valueOf(syoriYmd)));

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016,
            MessageUtil.getMessage(MessageId.IBW1018), kakutyoujobcd));

        long count = 0;
        String key = "";
        String syono = "";

        try(ExDBResults<KhLincSousinDataBean> khLincSousinDataBeanLst = khKanyuusyanoInfoSakujyoDao.
            getKhLincSousinData(kakutyoujobcd, syoriYmd);
            EntityUpdater<IT_KykKihon> khKykKihonUpdLst = new EntityUpdater<>()){

            for (KhLincSousinDataBean khLincSousinDataBean:khLincSousinDataBeanLst) {
                key = khLincSousinDataBean.getKbnkey();
                syono = khLincSousinDataBean.getSyono();

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyoujobcd);
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOU_TABLE_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERY_FILTER_KBNID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(key);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(syono);

                if (YuyuBizConfig.getInstance().getLinchenkoutypesakujyo().equals(khLincSousinDataBean.getLinchenkoutype())) {
                    IT_KykKihon kykKihon = hozenDomManager.getKykKihon(syono);

                    kykKihon.setKhLincKihon(null);

                    khKykKihonUpdLst.add(kykKihon);

                    count = count + 1;
                }
            }
            bzRecoveryDatasikibetuBean.initializeBlank();
        }
        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(count)));
    }


    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}