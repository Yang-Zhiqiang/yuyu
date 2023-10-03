package yuyu.batch.suuri.srsuuritoukei.srsibouriturendou;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.SV_SibourituRendou;
import yuyu.def.db.entity.ZT_SbRituRendouTy;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 死亡率用連動情報作成クラス
 */
public class SrSibourituRendou implements Batch {

    @Inject
    private SrSibourituRendouBatchParam srSibourituRendouBatchParam;

    @Inject
    private BatchLogger batchLogger;

    @Override
    public BatchParam getParam() {

        return srSibourituRendouBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        srSibourituRendouBatchParam.setParam();

        SrSibourituRendouDbaStatement srSibouRituRendouDbaStatement = SWAKInjector
            .getInstance(SrSibourituRendouDbaStatement.class);

        try (EntityInserter<ZT_SbRituRendouTy> sbRituRenouTyLst = new EntityInserter<>();
            ExDBResults<SV_SibourituRendou> sibouRituRendouLst = srSibouRituRendouDbaStatement.getSkSeirituDate(
                srSibourituRendouBatchParam.getTysyttaisyouym(), C_SeirituKbn.SEIRITU);) {

            for (SV_SibourituRendou sibouRituRendou : sibouRituRendouLst) {

                ZT_SbRituRendouTy sbRituRendouTy = new ZT_SbRituRendouTy();

                List<HT_MosSyouhn> mosSyouhnLst = srSibouRituRendouDbaStatement.getMosJyouhouDate(
                    sibouRituRendou.getMosno(), C_SyutkKbn.SYU);

                for (HT_MosSyouhn mosSyouhn : mosSyouhnLst) {

                    int syohinHanteiKbn  = SyouhinUtil.hantei(mosSyouhn.getSyouhncd());

                    SrSibourituRendouItemEditor srSibouRituRendouItemEditor = SWAKInjector
                        .getInstance(SrSibourituRendouItemEditor.class);

                    Boolean errorFlag = srSibouRituRendouItemEditor.editKoumoku(srSibourituRendouBatchParam,
                        sibouRituRendou, mosSyouhn, sbRituRendouTy, syohinHanteiKbn);

                    if (!errorFlag) {

                        BizPropertyInitializer.initialize(sbRituRendouTy);

                        SrSibourituRendouConverter.convertPadding(sbRituRendouTy);

                        sbRituRenouTyLst.add(sbRituRendouTy);

                        srSibourituRendouBatchParam.setSyorikensuu(srSibourituRendouBatchParam.getSyorikensuu() + 1);
                    }

                    break;
                }
            }
        }

        if (SrSibourituRendouBatchParam.RGHGM.equals(srSibourituRendouBatchParam.getIbKakutyoujobcd()) &&
            srSibourituRendouBatchParam.getErrorkensuu() != 0) {

            throw new BizAppException(MessageId.ISA1001, "数理用エラー情報テーブル",
                String.valueOf(srSibourituRendouBatchParam.getErrorkensuu()));
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, "死亡率用連動Fテーブル（中）",
            String.valueOf(srSibourituRendouBatchParam.getSyorikensuu())));
        batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, "数理用エラー情報テーブル",
            String.valueOf(srSibourituRendouBatchParam.getErrorkensuu())));
    }
}
