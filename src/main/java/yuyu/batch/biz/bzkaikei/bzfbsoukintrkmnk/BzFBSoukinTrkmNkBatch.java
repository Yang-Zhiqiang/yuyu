package yuyu.batch.biz.bzkaikei.bzfbsoukintrkmnk;

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
 * 業務共通 経理・会計 ＦＢ送金データ取込（年金支払）
 */
public class BzFBSoukinTrkmNkBatch implements Batch {

    @Inject
    private BzBatchParam bzBatchParam;
    // 2016/11/07 熊谷 年金削除対応
    //    @Inject
    //    private NenkinDomManager nekinDomManager;
    //
    //    @Inject
    //    private BatchLogger batchLogger;
    //
    //    @Inject
    //    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    public final String onLine = "RGDDD001";

    public final String tableID = "KT_NkFBSoukinData";

    public final String filterID = "Bz107";

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {
        // 2016/11/07 熊谷 年金削除対応
        //        int syoriKensuu = 0;
        //
        //        BT_FBSoukinData btFBSoukinData = null;
        //        BzFbSoukinTrkmHensyu bzFbSoukinTrkmHensyu = SWAKInjector.getInstance(BzFbSoukinTrkmHensyu.class);
        //
        //        String syoriYmd = bzBatchParam.getSyoriYmd().toString();
        //
        //        String message =
        //            MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003), syoriYmd);
        //
        //        batchLogger.info(message);
        //
        //        try (ExDBResults<KT_NkFBSoukinData> nkFBSoukinDataList =
        //            getList(bzBatchParam.getIbKakutyoujobcd(),bzBatchParam.getSyoriYmd());
        //            EntityInserter<BT_FBSoukinData> fBSoukinDataLst = new EntityInserter<>()) {
        //
        //            Iterator<KT_NkFBSoukinData> iterator = nkFBSoukinDataList.iterator();
        //            if(!iterator.hasNext()) {
        //
        //                batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
        //                return;
        //            }
        //
        //            while (iterator.hasNext()) {
        //
        //
        //                KT_NkFBSoukinData nkFBSoukinData = iterator.next();
        //                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
        //                bzRecoveryDatasikibetuBean.setIbTableid(tableID);
        //                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(filterID);
        //                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(nkFBSoukinData.getFbsoukindatasikibetukey());
        //
        //                btFBSoukinData = bzFbSoukinTrkmHensyu.exec(nkFBSoukinData);
        //
        //                BizPropertyInitializer.initialize(btFBSoukinData);
        //
        //                fBSoukinDataLst.add(btFBSoukinData);
        //
        //                syoriKensuu++;
        //
        //            }
        //
        //            bzRecoveryDatasikibetuBean.initializeBlank();
        //
        //            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
        //        }
    }
    // 2016/11/07 熊谷 年金削除対応
    //    private ExDBResults<KT_NkFBSoukinData> getList(String jobCd , BizDate syoriYmd ) {
    //
    //        if (onLine.equals(jobCd)) {
    //
    //            return nekinDomManager.getNkFBSoukinDatasByKakutyoujobcdSyoriYmdGyoumucd(
    //                jobCd, syoriYmd, C_Gyoumucd.GK_YENSOUKIN_KH_SI, C_Gyoumucd.GK_YENSOUKIN_NK);
    //
    //        }
    //
    //        return  nekinDomManager.getNkFBSoukinDatasByKakutyoujobcdSyoriYmdGyoumucd(
    //            jobCd, syoriYmd, C_Gyoumucd.GK_YENSOUKIN_NK_JIDOU);
    //
    //
    //    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}