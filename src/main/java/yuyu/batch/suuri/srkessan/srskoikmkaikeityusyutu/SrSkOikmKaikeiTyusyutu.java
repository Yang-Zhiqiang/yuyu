package yuyu.batch.suuri.srkessan.srskoikmkaikeityusyutu;

import java.util.Iterator;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.def.MessageId;
import yuyu.def.db.entity.BT_DenpyoData;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 新契約追込会計取引データ抽出クラス
 */
public class SrSkOikmKaikeiTyusyutu implements Batch {

    @Inject
    private SrSkOikmKaikeiTyusyutuBatchParam srSkOikmKaikeiTyusyutuBatchParam;

    @Inject
    private BatchLogger batchLogger;

    @Override
    public BatchParam getParam() {

        return srSkOikmKaikeiTyusyutuBatchParam;
    }

    @Execute
    @Transactional
    public void exec() {

        srSkOikmKaikeiTyusyutuBatchParam.setParam();

        SrSkOikmKaikeiTyusyutuDbaStatement srSkOikmKaikeiTyusyutuDbaStatement =
            SWAKInjector.getInstance(SrSkOikmKaikeiTyusyutuDbaStatement.class);

        try(ExDBResults<BT_DenpyoData> denpyoDataLst =
            srSkOikmKaikeiTyusyutuDbaStatement.getDenpyoDatasByDenymdSyoriYmdFstpryosyuymd(
                srSkOikmKaikeiTyusyutuBatchParam.getKsnyokugetufirstdayymd(),
                srSkOikmKaikeiTyusyutuBatchParam.getKsndensimeymd(),
                srSkOikmKaikeiTyusyutuBatchParam.getKsnbiymd())) {

            Iterator<BT_DenpyoData> denpyoDataIter = denpyoDataLst.iterator();

            if (!denpyoDataIter.hasNext()) {

                batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
                    String.valueOf(srSkOikmKaikeiTyusyutuBatchParam.getSyorikensuu()),
                    "新契約追込会計取引データテーブル"));

                return;
            }

            SrSkOikmKaikeiTyusyutuItemEditor srSkOikmKaikeiTyusyutuItemEditor =
                SWAKInjector.getInstance(SrSkOikmKaikeiTyusyutuItemEditor.class);

            srSkOikmKaikeiTyusyutuItemEditor.editKoumoku(denpyoDataIter, srSkOikmKaikeiTyusyutuBatchParam);
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002,
            String.valueOf(srSkOikmKaikeiTyusyutuBatchParam.getSyorikensuu()), "新契約追込会計取引データテーブル"));
    }
}
