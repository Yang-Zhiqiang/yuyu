package yuyu.batch.biz.bzkaikei.bzkeiridendatatblsksnk;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;

/**
 * 業務共通 経理･会計 経理伝票データテーブル作成（年金支払）
 */
public class BzKeiriDenDataTblSksNkBatch implements Batch {
    // 2016/11/07 熊谷 年金削除対応
    //    private static final String TABLE_ID = "KT_NkDenpyoData";
    //
    //    private static final String FILTER_ID = "Bz105";
    //
    //    @Inject
    //    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;
    // 2016/11/07 熊谷 年金削除対応
    //    @Inject
    //    private BaseUserInfo baseUserInfo;
    //
    //    @Inject
    //    private NenkinDomManager nenkinDomManager;
    //
    //    @Inject
    //    private BizDomManager bizDomManager;
    //
    //    @Inject
    //    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {
        // 2016/11/07 熊谷 年金削除対応
        //        BizDate syoriYmd = bzBatchParam.getSyoriYmd();
        //        BzKeiriDenDataSksKyoutuu bzKeiriDenDataSksKyoutuu = SWAKInjector.getInstance(BzKeiriDenDataSksKyoutuu.class);
        //        long syoriKensu = 0;
        //
        //        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
        //            String.valueOf(syoriYmd)));
        //
        //        try (EntityInserter<BT_DenpyoData> denpyoDataInsLst = new EntityInserter<>()) {
        //
        //            bzKeiriDenDataSksKyoutuu.init(syoriYmd, baseUserInfo);
        //
        //            try (ExDBUpdatableResults<KT_NkDenpyoData> nkDenpyoDataLst = nenkinDomManager
        //                .getNkDenpyoDatasByKakutyoujobcdSyoriYmd(bzBatchParam.getIbKakutyoujobcd(), syoriYmd)) {
        //
        //                for (KT_NkDenpyoData nkDenpyoData : nkDenpyoDataLst) {
        //                    bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
        //                    bzRecoveryDatasikibetuBean.setIbTableid(TABLE_ID);
        //                    bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(FILTER_ID);
        //                    bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(nkDenpyoData.getDensyskbn().toString());
        //                    bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey2(nkDenpyoData.getDenrenno());
        //
        //                    BT_DenpyoData denpyoData = bzKeiriDenDataSksKyoutuu.setKeiriDenpyoData(nkDenpyoData);
        //
        //                    if (C_Tuukasyu.USD.eq(denpyoData.getTuukasyu())
        //                        || C_Tuukasyu.AUD.eq(denpyoData.getTuukasyu())
        //                        || C_Tuukasyu.EUR.eq(denpyoData.getTuukasyu())) {
        //
        //                        bzKeiriDenDataSksKyoutuu.changeGaikaData(denpyoData);
        //
        //                        nkDenpyoData.setDenyenkagk(denpyoData.getDenyenkagk());
        //                        nkDenpyoData.setDenkawaserate(denpyoData.getDenkawaserate());
        //                    }
        //                    denpyoDataInsLst.add(denpyoData);
        //                    syoriKensu = syoriKensu + 1;
        //                }
        //                bzRecoveryDatasikibetuBean.initializeBlank();
        //            }
        //        }
        //
        //        List<BzTaisyakuFuittiInfoBean> taisyakuInfoLst = Lists.newArrayList();
        //        taisyakuInfoLst = bzKeiriDenDataSksKyoutuu.getGaikaTaisyakuFuittiInfo();
        //
        //        for (BzTaisyakuFuittiInfoBean taisyakuInfo: taisyakuInfoLst) {
        //
        //            BT_DenpyoData btDenpyoData = bizDomManager.getDenpyoData(taisyakuInfo.getDensysKbn(), taisyakuInfo.getDenrenNo(), taisyakuInfo.getEdaNo());
        //            btDenpyoData.setDenyenkagk(taisyakuInfo.getKagk());
        //            bizDomManager.update(btDenpyoData);
        //
        //            KT_NkDenpyoData nkDenpyoData = nenkinDomManager.getNkDenpyoData(taisyakuInfo.getDenrenNo(), taisyakuInfo.getEdaNo());
        //            nkDenpyoData.setDenyenkagk(taisyakuInfo.getKagk());
        //            nenkinDomManager.update(nkDenpyoData);
        //
        //        }
        //        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensu)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
