package yuyu.batch.biz.bzkaikei.bzgkfbsoukintrkmnk;

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
 * 業務共通 経理・会計 外貨ＦＢ送金データ取込（年金支払）クラス
 */
public class BzGkFBSoukinTrkmNkBatch implements Batch {

    @Inject
    private BzBatchParam bzBatchParam;
    // 2016/11/07 熊谷 年金削除対応
    //    @Inject
    //    private NenkinDomManager nekinDomManager;
    //
    //    @Inject
    //    private BaseUserInfo baseUserInfo;
    //
    //    @Inject
    //    private BatchLogger batchLogger;
    //
    //    @Inject
    //    private AS_Kinou kinou;

    public final String onLine = "RGEDD001";

    public final String tableID = "KT_NkGaikaFBSoukinData";

    public final String filterID = "Bz107";
    // 2016/11/07 熊谷 年金削除対応
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
        //        int syoriKensuu = 0;
        //
        //        BT_GkFBSoukinData btGkFBSoukinData = null;
        //        BzGkFbSoukinTrkmHensyu bzGkFbSoukinTrkmHensyu = SWAKInjector.getInstance(BzGkFbSoukinTrkmHensyu.class);
        //
        //        String syoriYmd = bzBatchParam.getSyoriYmd().toString();
        //
        //        String message =
        //            MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003), syoriYmd);
        //
        //        batchLogger.info(message);
        //
        //        try (ExDBResults<KT_NkGaikaFBSoukinData> ktNkGaikaFBSoukinDataList =
        //            getList(bzBatchParam.getIbKakutyoujobcd(), bzBatchParam.getSyoriYmd());
        //            EntityInserter<BT_GkFBSoukinData> gkFBSoukinDataLst = new EntityInserter<>()) {
        //
        //            Iterator<KT_NkGaikaFBSoukinData> iterator = ktNkGaikaFBSoukinDataList.iterator();
        //
        //            if (!iterator.hasNext()) {
        //
        //                batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
        //                return;
        //
        //            }
        //
        //            String sysDateTimeMilli = BizDate.getSysDateTimeMilli();
        //
        //            while (iterator.hasNext()) {
        //
        //                KT_NkGaikaFBSoukinData nkGaikaFBSoukinData = iterator.next();
        //                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
        //                bzRecoveryDatasikibetuBean.setIbTableid(tableID);
        //                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(filterID);
        //                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(nkGaikaFBSoukinData.getFbsoukindatasikibetukey());
        //
        //                btGkFBSoukinData = bzGkFbSoukinTrkmHensyu.exec(nkGaikaFBSoukinData);
        //
        //                // btGkFBSoukinData.setGyoumuKousinKinou(kinou.getKinouId());
        //                // btGkFBSoukinData.setGyoumuKousinsyaId(baseUserInfo.getUserId());
        //                // btGkFBSoukinData.setGyoumuKousinTime(sysDateTimeMilli);
        //
        //                BizPropertyInitializer.initialize(btGkFBSoukinData);
        //
        //                gkFBSoukinDataLst.add(btGkFBSoukinData);
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
    //    private ExDBResults<KT_NkGaikaFBSoukinData> getList(String jobCd, BizDate syoriYmd) {
    //
    //        if (onLine.equals(jobCd)) {
    //
    //            return nekinDomManager.getNkGaikaFBSoukinDatasByKakutyoujobcdSyoriYmdGkgyoumucds(
    //                jobCd, syoriYmd, C_Gkgyoumucd.GK_GKSOUKIN_KH_SI);
    //
    //        }
    //
    //        return nekinDomManager.getNkGaikaFBSoukinDatasByKakutyoujobcdSyoriYmdGkgyoumucds(
    //            jobCd, syoriYmd, C_Gkgyoumucd.GK_GKNSOUKIN_NK_JIDOU_2EIGO, C_Gkgyoumucd.GK_GKNSOUKIN_NK_JIDOU_3EIGO);
    //
    //    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}