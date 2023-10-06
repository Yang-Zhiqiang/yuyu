package yuyu.batch.biz.bzkaikei.bzsikinidoulistdatasks;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BT_DenpyoData;
import yuyu.def.db.entity.BT_SikinIdouListSks;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 業務共通 経理･会計 資金移動リストデータ作成のバッチクラスです。
 */
public class BzSikinIdouListDataSksBatch implements Batch {

    private static final String TABLE_ID = "BT_DenpyoData";

    private static final String FILTER_ID = "Bz105";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {
        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        String kakutyouJobCd = bzBatchParam.getIbKakutyoujobcd();
        long syoriKensuu = 0;

        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003), String.valueOf(syoriYmd)));

        try (
            ExDBResults<BT_DenpyoData> denpyoDataLst =
            bizDomManager.getDenpyoDatasByKakutyoujobcdSyoriYmdKanjyoukmkcds(kakutyouJobCd, syoriYmd);
            EntityInserter<BT_SikinIdouListSks> sikinIdouListSksInsLst = new EntityInserter<>()) {

            DenpyouSiwakeInfoBean denpyouSiwakeInfoBean = SWAKInjector.getInstance(DenpyouSiwakeInfoBean.class);
            List<BT_SikinIdouListSks> sikinIdouListSksLst = null;

            for (BT_DenpyoData denpyoData : denpyoDataLst) {
                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyouJobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TABLE_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTER_ID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(denpyoData.getDensyskbn().getValue());
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(denpyoData.getDenrenno());

                if (denpyouSiwakeInfoBean.getDenSysKbn() == null) {
                    denpyouSiwakeInfoBean.setSyoriYmd(syoriYmd);
                    denpyouSiwakeInfoBean.setDenSysKbn(denpyoData.getDensyskbn());
                    denpyouSiwakeInfoBean.setDenRenno(denpyoData.getDenrenno());

                    denpyouSiwakeInfoBean.addDenpyouData(denpyoData);
                }
                else {
                    if (denpyouSiwakeInfoBean.getDenSysKbn().eq(denpyoData.getDensyskbn()) &&
                        denpyouSiwakeInfoBean.getDenRenno().equals(denpyoData.getDenrenno())) {
                        denpyouSiwakeInfoBean.addDenpyouData(denpyoData);
                    }
                    else {
                        sikinIdouListSksLst = denpyouSiwakeInfoBean.editSikinIdouListData();

                        for (BT_SikinIdouListSks sikinIdouListSks : sikinIdouListSksLst) {
                            sikinIdouListSksInsLst.add(sikinIdouListSks);
                        }

                        denpyouSiwakeInfoBean.clear();
                        denpyouSiwakeInfoBean = SWAKInjector.getInstance(DenpyouSiwakeInfoBean.class);

                        denpyouSiwakeInfoBean.setSyoriYmd(syoriYmd);
                        denpyouSiwakeInfoBean.setDenSysKbn(denpyoData.getDensyskbn());
                        denpyouSiwakeInfoBean.setDenRenno(denpyoData.getDenrenno());

                        denpyouSiwakeInfoBean.addDenpyouData(denpyoData);
                    }
                }

                syoriKensuu++;
            }

            sikinIdouListSksLst = denpyouSiwakeInfoBean.editSikinIdouListData();

            for (BT_SikinIdouListSks sikinIdouListSks : sikinIdouListSksLst) {
                sikinIdouListSksInsLst.add(sikinIdouListSks);
            }

            bzRecoveryDatasikibetuBean.initializeBlank();
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {
        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery = SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);
        bzBatchAbendCommonRecovery.exec();
    }
}