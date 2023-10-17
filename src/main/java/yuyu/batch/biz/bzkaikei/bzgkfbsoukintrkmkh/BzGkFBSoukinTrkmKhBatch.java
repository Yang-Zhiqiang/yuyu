package yuyu.batch.biz.bzkaikei.bzgkfbsoukintrkmkh;

import java.util.Iterator;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.kaikei.BzGkFbSoukinTrkmHensyu;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.db.entity.BT_GkFBSoukinData;
import yuyu.def.db.entity.IT_KhGaikaFBSoukinData;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 業務共通 経理・会計 外貨ＦＢ送金データ取込（契約保全）クラス
 */
public class BzGkFBSoukinTrkmKhBatch implements Batch {

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    public final String tableID = "IT_KhGaikaFBSoukinData";

    public final String filterID = "Bz107";

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        int syoriKensuu = 0;

        BT_GkFBSoukinData btGaikaFBSoukinData = null;
        BzGkFbSoukinTrkmHensyu bzGkFbSoukinTrkmHensyu = SWAKInjector.getInstance(BzGkFbSoukinTrkmHensyu.class);

        String syoriYmd = bzBatchParam.getSyoriYmd().toString();

        String message =
            MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003), syoriYmd);

        batchLogger.info(message);

        try( ExDBResults<IT_KhGaikaFBSoukinData> khGaikaFBSoukinDataList =
            hozenDomManager.getKhGaikaFBSoukinDatasByKakutyoujobcdSyoriYmd
            (bzBatchParam.getIbKakutyoujobcd(), bzBatchParam.getSyoriYmd());
            EntityInserter<BT_GkFBSoukinData> gkFBSoukinDataLst = new  EntityInserter<>()){

            Iterator<IT_KhGaikaFBSoukinData> khGaikaFBSoukinDataIter = khGaikaFBSoukinDataList.iterator();

            if(!khGaikaFBSoukinDataIter.hasNext()) {

                batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
                return;
            }

            while (khGaikaFBSoukinDataIter.hasNext()) {


                IT_KhGaikaFBSoukinData khGaikaFBSoukinData = khGaikaFBSoukinDataIter.next();
                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(bzBatchParam.getIbKakutyoujobcd());
                bzRecoveryDatasikibetuBean.setIbTableid(tableID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(filterID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(khGaikaFBSoukinData.getFbsoukindatasikibetukey());

                btGaikaFBSoukinData = bzGkFbSoukinTrkmHensyu.exec(khGaikaFBSoukinData);

                BizPropertyInitializer.initialize(btGaikaFBSoukinData);

                gkFBSoukinDataLst.add(btGaikaFBSoukinData);

                syoriKensuu++;

            }
        }

        bzRecoveryDatasikibetuBean.initializeBlank();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0001, String.valueOf(syoriKensuu)));
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
