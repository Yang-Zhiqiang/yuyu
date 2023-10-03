package yuyu.batch.suuri.srsuuritoukei.srrayvknsyuyu;

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
import yuyu.def.db.entity.ZT_RayVKnsyuyuTy;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 数理 数理統計 ＲＡＹＶ検証用情報作成バッチクラス
 */
public class SrRayVKnsyuyuBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private SrRayVKnsyuyuBatchParam batchParam;

    @Override
    public BatchParam getParam() {
        return batchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        int tableCount = 0;
        String kakutyouJobcd = "";

        SrRayVKnsyuyuBatchEdit batchEdit = SWAKInjector.getInstance(SrRayVKnsyuyuBatchEdit.class);
        SrRayVKnsyuyuBatchDbAccess batchDbAccess =
            SWAKInjector.getInstance(SrRayVKnsyuyuBatchDbAccess.class);
        SrGetTokutejitenSyohnInfo srGetTokutejitenSyohnInfo = SWAKInjector.getInstance(SrGetTokutejitenSyohnInfo.class);

        if (SrRayVKnsyuyuBatchParam.RGJPM001.equals(batchParam.getIbKakutyoujobcd())) {
            kakutyouJobcd = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIJIZEN1_HY;
        }
        else if (SrRayVKnsyuyuBatchParam.RGJPM002.equals(batchParam.getIbKakutyoujobcd())) {
            kakutyouJobcd = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIJIZEN2_HY;
        }
        else if (SrRayVKnsyuyuBatchParam.RGJPM003.equals(batchParam.getIbKakutyoujobcd())) {
            kakutyouJobcd = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIJIZEN3_HY;
        }
        else if (SrRayVKnsyuyuBatchParam.RGJPM004.equals(batchParam.getIbKakutyoujobcd())) {
            kakutyouJobcd = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIHONBAN_HY;
        }

        try (ExDBResults<ST_HoyuuMeisaiTyukeiyouItzHzn> hoyuuMeisaiTyukeiyouItzHznLst =
            batchDbAccess.getHoyuuMeisaiTyukeiyouItzHznLst(batchParam.getKijyunymd().getBizDateYM(), kakutyouJobcd, SrCommonConstants.HKNSYUKIGOU_RAY_ARRAY);
            EntityInserter<ZT_RayVKnsyuyuTy> entityInserter = new EntityInserter<>();) {

            for (ST_HoyuuMeisaiTyukeiyouItzHzn hoyuuMeisaiTyukeiyouItzHzn : hoyuuMeisaiTyukeiyouItzHznLst) {

                List<SV_KiykSyuhnData> kiykSyuhnLst = batchDbAccess.getKiykSyuhnLst(
                    hoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino(), C_SyutkKbn.SYU);

                TkJitenKeiyakuSyouhinBean tkJitenKeiyakuSyouhinBean = srGetTokutejitenSyohnInfo.exec(
                    C_TokutejitenSyoriKbn.KIJYUNBIJITENSYOUHININFO,
                    hoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino(),
                    batchParam.getKijyunymd(),
                    "",
                    kiykSyuhnLst);

                ZT_RayVKnsyuyuTy rayVKnsyuyuTy = new ZT_RayVKnsyuyuTy();

                batchEdit.editKoumoku(
                    batchParam,
                    hoyuuMeisaiTyukeiyouItzHzn,
                    tkJitenKeiyakuSyouhinBean.getTkJitenKeiyakuSyouhinKijyunBeanAto(),
                    rayVKnsyuyuTy,
                    kiykSyuhnLst);

                BizPropertyInitializer.initialize(rayVKnsyuyuTy);
                entityInserter.add(rayVKnsyuyuTy);
                tableCount++;
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, "ＲＡＹＶ検証用Ｆテーブル（中）",
            String.valueOf(tableCount)));

        batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, "数理用エラー情報テーブル",
            String.valueOf(batchParam.getErrorSyoriKensuu())));

    }
}