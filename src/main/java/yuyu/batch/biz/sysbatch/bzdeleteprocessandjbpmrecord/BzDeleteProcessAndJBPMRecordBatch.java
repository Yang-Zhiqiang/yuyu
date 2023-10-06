package yuyu.batch.biz.sysbatch.bzdeleteprocessandjbpmrecord;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.workflow.IwfDataClient;
import yuyu.common.biz.workflow.io.data.DeleteProcessAndJBPMRecordInBean;
import yuyu.common.biz.workflow.io.data.DeleteProcessAndJBPMRecordOutBean;
import yuyu.common.workflowcore.core.webservice.provide.datakanri.deleteprocessandjbpmrecord.DeleteProcessAndJBPMRecordBean;
import yuyu.def.MessageId;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;

/**
 * 業務共通 工程 工程履歴・JBPMデータ削除クラス
 */
public class BzDeleteProcessAndJBPMRecordBatch implements Batch {

    private int syoriKensuu = 0;

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private IwfDataClient iwfDataClient;

    @Inject
    private BzDeleteProcessAndJBPMRecordDao bzDeleteProcessAndJBPMRecordDao;

    @Inject
    private BzDeleteProcessAndJBPMRecordBatchParam bzDeleteProcessAndJBPMRecordBatchParam;

    @Override
    public BatchParam getParam() {
        return bzDeleteProcessAndJBPMRecordBatchParam;
    }

    @Inject
    private AS_Kinou kinou;

    @Execute
    @Transactional
    public void exec() {

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            String.valueOf(bzDeleteProcessAndJBPMRecordBatchParam.getSyoriYmd())));

        int skjtsgkkntksu;

        if (Strings.isNullOrEmpty(bzDeleteProcessAndJBPMRecordBatchParam.getIbSkjtsgkkntksu())) {
            batchLogger.info("引数が不正です。");

            skjtsgkkntksu = 3;

        }
        else {
            skjtsgkkntksu = Integer.parseInt(bzDeleteProcessAndJBPMRecordBatchParam.getIbSkjtsgkkntksu());

            if (skjtsgkkntksu < 3) {
                skjtsgkkntksu = 3;
            }
        }

        List<DelKouteiInfosByKouteiKanryouYmdBean> delKouteiInfosLst = bzDeleteProcessAndJBPMRecordDao
            .getDelKouteiInfosByKouteiKanryouYmd(bzDeleteProcessAndJBPMRecordBatchParam.getSyoriYmd()
                .addMonths(-skjtsgkkntksu).getRekijyou());

        if (!(delKouteiInfosLst == null || delKouteiInfosLst.size() == 0)) {


            try {
                bzDeleteProcessAndJBPMRecordDao.lockKouteiRireki();
            } catch (Exception e) {
            }

            try {
                bzDeleteProcessAndJBPMRecordDao.lockJBPMProcessInstance();
            } catch (Exception e) {
            }
            try {
                bzDeleteProcessAndJBPMRecordDao.lockJBPMModuleInstance();
            } catch (Exception e) {
            }

            try {
                bzDeleteProcessAndJBPMRecordDao.lockJBPMVariableInstance();
            } catch (Exception e) {
            }

            try {
                bzDeleteProcessAndJBPMRecordDao.lockJBPMToken();
            } catch (Exception e) {
            }

            try {
                bzDeleteProcessAndJBPMRecordDao.lockJBPMTokenVariableMap();
            } catch (Exception e) {
            }

            try {
                bzDeleteProcessAndJBPMRecordDao.lockJBPMTaskInstance();
            } catch (Exception e) {
            }



            int skjtsjygnkensuu;

            if (Strings.isNullOrEmpty(bzDeleteProcessAndJBPMRecordBatchParam.getSkjtsjygnkensuu())) {
                batchLogger.info("引数が不正です。");

                skjtsjygnkensuu = 100000;
            }
            else {
                skjtsjygnkensuu = Integer.parseInt(bzDeleteProcessAndJBPMRecordBatchParam.getSkjtsjygnkensuu());

                if (skjtsjygnkensuu > 100000) {
                    skjtsjygnkensuu = 100000;
                }
            }

            if (delKouteiInfosLst.size() > skjtsjygnkensuu) {
                delKouteiInfosLst = delKouteiInfosLst.subList(0, skjtsjygnkensuu);
            }

            List<List<DelKouteiInfosByKouteiKanryouYmdBean>> delKouteiInfosLstLst = Lists.partition(delKouteiInfosLst, 10000);


            DeleteProcessAndJBPMRecordInBean deleteProcessAndJBPMRecordInBean = SWAKInjector.getInstance(DeleteProcessAndJBPMRecordInBean.class);
            List<DeleteProcessAndJBPMRecordBean> deleteProcessAndJBPMRecordBeanList = new ArrayList<>();
            deleteProcessAndJBPMRecordInBean.setDeleteProcessAndJBPMRecordBeanList(deleteProcessAndJBPMRecordBeanList);

            for (int n = 0; n < delKouteiInfosLstLst.size(); n++) {

                for (int m = 0; m < delKouteiInfosLstLst.get(n).size(); m++) {

                    DeleteProcessAndJBPMRecordBean deleteProcessAndJBPMRecordBean = SWAKInjector
                        .getInstance(DeleteProcessAndJBPMRecordBean.class);

                    deleteProcessAndJBPMRecordBean.setFlowid(delKouteiInfosLstLst.get(n).get(m).getFlowId());

                    deleteProcessAndJBPMRecordBean.setGyoumukey(delKouteiInfosLstLst.get(n).get(m).getGyoumuKey());

                    deleteProcessAndJBPMRecordInBean.getDeleteProcessAndJBPMRecordBeanList().add(deleteProcessAndJBPMRecordBean);
                }

                DeleteProcessAndJBPMRecordOutBean deleteProcessAndJBPMRecordBatchOutBean = iwfDataClient
                    .execDeleteProcessAndJBPMRecord(deleteProcessAndJBPMRecordInBean);

                if (!"0".equals(deleteProcessAndJBPMRecordBatchOutBean.getKekkastatus())) {
                    batchLogger.error("エラーコード" + deleteProcessAndJBPMRecordBatchOutBean.getSyousaimsgcd());
                    batchLogger.error("エラーメッセージ" + deleteProcessAndJBPMRecordBatchOutBean.getSyousaimsg());
                    throw new BizAppException(MessageId.EBF0129, kinou.getKinouNm());
                }

                deleteProcessAndJBPMRecordBeanList = new ArrayList<>();
                deleteProcessAndJBPMRecordInBean.setDeleteProcessAndJBPMRecordBeanList(deleteProcessAndJBPMRecordBeanList);
            }

            syoriKensuu = delKouteiInfosLst.size();
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKensuu), "工程完了案件データ"));

    }
}
