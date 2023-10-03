package yuyu.batch.suuri.srsuuritoukei.srkbkssurnduhknvknsyuyu;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.suuri.srcommon.SrCommonConstants;
import yuyu.common.suuri.suuricommon.SrGetTokutejitenSyohnInfo;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TokutejitenSyoriKbn;
import yuyu.def.db.entity.ST_HoyuuMeisaiTyukeiyouItzHzn;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.db.entity.ZT_SrKbkSsuRnduHknVKnsyuyuTy;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 数理 数理統計 株価指数連動保険Ｖ検証用情報作成バッチクラス
 */
public class SrKbkSsuRnduHknVKnsyuyuBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private SrKbkSsuRnduHknVKnsyuyuBatchParam batchParam;

    @Override
    public BatchParam getParam() {
        return batchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        int tableCount = 0;
        String kakutyouJobcd = "";

        SrKbkSsuRnduHknVKnsyuyuBatchEdit batchEdit = SWAKInjector.getInstance(SrKbkSsuRnduHknVKnsyuyuBatchEdit.class);
        SrKbkSsuRnduHknVKnsyuyuBatchDbAccess batchDbAccess =
            SWAKInjector.getInstance(SrKbkSsuRnduHknVKnsyuyuBatchDbAccess.class);
        SrGetTokutejitenSyohnInfo srGetTokutejitenSyohnInfo = SWAKInjector.getInstance(SrGetTokutejitenSyohnInfo.class);

        if (SrKbkSsuRnduHknVKnsyuyuBatchParam.RGJPM001.equals(batchParam.getIbKakutyoujobcd())) {
            kakutyouJobcd = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIJIZEN1_HY;
        }
        else if (SrKbkSsuRnduHknVKnsyuyuBatchParam.RGJPM002.equals(batchParam.getIbKakutyoujobcd())) {
            kakutyouJobcd = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIJIZEN2_HY;
        }
        else if (SrKbkSsuRnduHknVKnsyuyuBatchParam.RGJPM003.equals(batchParam.getIbKakutyoujobcd())) {
            kakutyouJobcd = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIJIZEN3_HY;
        }
        else if (SrKbkSsuRnduHknVKnsyuyuBatchParam.RGJPM004.equals(batchParam.getIbKakutyoujobcd())) {
            kakutyouJobcd = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIHONBAN_HY;
        }

        try (ExDBResults<ST_HoyuuMeisaiTyukeiyouItzHzn> hoyuuMeisaiTyukeiyouItzHznLst =null;
            EntityInserter<ZT_SrKbkSsuRnduHknVKnsyuyuTy> entityInserter = new EntityInserter<>();) {

            for (ST_HoyuuMeisaiTyukeiyouItzHzn hoyuuMeisaiTyukeiyouItzHzn : hoyuuMeisaiTyukeiyouItzHznLst) {

                List<SV_KiykSyuhnData> kiykSyuhnLst = batchDbAccess.getKiykSyuhnLst(
                    hoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino(), C_SyutkKbn.SYU);

                TkJitenKeiyakuSyouhinBean tkJitenKeiyakuSyouhinBean = srGetTokutejitenSyohnInfo.exec(
                    C_TokutejitenSyoriKbn.KIJYUNBIJITENSYOUHININFO,
                    hoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino(),
                    batchParam.getKijyunymd(),
                    "",
                    kiykSyuhnLst);

                ZT_SrKbkSsuRnduHknVKnsyuyuTy srKbkSsuRnduHknVKnsyuyuTy = new ZT_SrKbkSsuRnduHknVKnsyuyuTy();

                batchEdit.editKoumoku(
                    batchParam,
                    hoyuuMeisaiTyukeiyouItzHzn,
                    tkJitenKeiyakuSyouhinBean.getTkJitenKeiyakuSyouhinKijyunBeanAto(),
                    srKbkSsuRnduHknVKnsyuyuTy,
                    kiykSyuhnLst);

                BizPropertyInitializer.initialize(srKbkSsuRnduHknVKnsyuyuTy);
                entityInserter.add(srKbkSsuRnduHknVKnsyuyuTy);
                tableCount++;
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, "株価指数連動保険Ｖ検証用Ｆテーブル（中）",
            String.valueOf(tableCount)));

        batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, "数理用エラー情報テーブル",
            String.valueOf(batchParam.getErrorSyoriKensuu())));

    }
}