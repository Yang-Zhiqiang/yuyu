package yuyu.batch.suuri.srkessan.srskkessanoikmdata;

import java.util.Iterator;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.def.MessageId;
import yuyu.def.db.entity.ST_SkOikmTyouseiDenpyou;
import yuyu.batch.suuri.srkessan.srskkessanoikmdata.SrSkKessanOikmDataBatchParam;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 新契約決算用追込データ作成クラス
 */
public class SrSkKessanOikmData implements Batch {

    @Inject
    private SrSkKessanOikmDataBatchParam srSkKessanOikmDataBatchParam;

    @Inject
    private BatchLogger batchLogger;

    private static final String TABLE_NAME_ST_SKKESSANSYUKEI = "新契約決算用集計元データテーブル";

    @Override
    public BatchParam getParam() {

        return srSkKessanOikmDataBatchParam;
    }

    @Execute
    @Transactional
    public void exec() {

        srSkKessanOikmDataBatchParam.setParam();

        SrSkKessanOikmDataDbaStatement srSkKessanOikmDataDbaStatement =
            SWAKInjector.getInstance(SrSkKessanOikmDataDbaStatement.class);

        try (ExDBResults<ST_SkOikmTyouseiDenpyou> skOikmTyouseiDenpyouLst =
            srSkKessanOikmDataDbaStatement.getSkOikmTyouseiDenpyous()) {

            Iterator<ST_SkOikmTyouseiDenpyou> skOikmTyouseiDenpyouIter = skOikmTyouseiDenpyouLst.iterator();

            if (!skOikmTyouseiDenpyouIter.hasNext()) {

                batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
                    String.valueOf(srSkKessanOikmDataBatchParam.getIbSyorikensuu()), TABLE_NAME_ST_SKKESSANSYUKEI));

                return;
            }

            SrSkKessanOikmDataItemEditor srSkKessanOikmDataItemEditor =
                SWAKInjector.getInstance(SrSkKessanOikmDataItemEditor.class);

            srSkKessanOikmDataItemEditor.editKoumoku(skOikmTyouseiDenpyouIter, srSkKessanOikmDataBatchParam);
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
            String.valueOf(srSkKessanOikmDataBatchParam.getIbSyorikensuu()), TABLE_NAME_ST_SKKESSANSYUKEI));
    }
}
