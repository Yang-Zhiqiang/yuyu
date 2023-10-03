package yuyu.batch.suuri.srsuuritoukei.srzitkazukarikinsrrendou;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.def.MessageId;
import yuyu.def.db.entity.IT_AzukarikinKessankanri;
import yuyu.def.db.entity.ZT_ZitkAzukarikinSrRendouTy;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 数理統計 数理統計 税適預り金数理連動情報作成
 */
public class SrZitkAzukarikinSrRendouBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private SrZitkAzukarikinSrRendouBatchParam srZitkAzukarikinSrRendouBatchParam;

    private long tableTourokuCount;

    @Override
    public BatchParam getParam() {
        return srZitkAzukarikinSrRendouBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        tableTourokuCount = 0;
        SrZitkAzukarikinSrRendouBatchDbAccess srZitkAzukarikinSrRendouBatchDbAccess =
            SWAKInjector.getInstance(SrZitkAzukarikinSrRendouBatchDbAccess.class);

        try (
            ExDBResults<IT_AzukarikinKessankanri> azukarikinKessankanriLst =
            srZitkAzukarikinSrRendouBatchDbAccess.getAzukarikinKessankanris(srZitkAzukarikinSrRendouBatchParam.getKijyunymd());
            EntityInserter<ZT_ZitkAzukarikinSrRendouTy> zitkAzukarikinSrRendouTyList = new EntityInserter<>();) {

            for (IT_AzukarikinKessankanri azukarikinKessankanri : azukarikinKessankanriLst) {

                ZT_ZitkAzukarikinSrRendouTy zitkAzukarikinSrRendouTy = new ZT_ZitkAzukarikinSrRendouTy();

                SrZitkAzukarikinSrRendouBatchEdit srZitkAzukarikinSrRendouBatchEdit =
                    SWAKInjector.getInstance(SrZitkAzukarikinSrRendouBatchEdit.class);

                srZitkAzukarikinSrRendouBatchEdit.editKoumoku(srZitkAzukarikinSrRendouBatchParam,
                    azukarikinKessankanri, zitkAzukarikinSrRendouTy);

                BizPropertyInitializer.initialize(zitkAzukarikinSrRendouTy);

                zitkAzukarikinSrRendouTyList.add(zitkAzukarikinSrRendouTy);

                tableTourokuCount++;
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, "税適預り金数理連動Ｆテーブル（中）",
            String.valueOf(tableTourokuCount)));

        batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, "数理用エラー情報テーブル",
            String.valueOf(srZitkAzukarikinSrRendouBatchParam.getErrorCount())));

    }
}