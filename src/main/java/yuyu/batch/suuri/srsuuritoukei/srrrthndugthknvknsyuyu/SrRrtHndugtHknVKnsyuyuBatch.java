package yuyu.batch.suuri.srsuuritoukei.srrrthndugthknvknsyuyu;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.suuri.srcommon.SrCommonConstants;
import yuyu.common.suuri.suuricommon.SrGetTokutejitenSyohnInfo;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinKijyunBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TokutejitenSyoriKbn;
import yuyu.def.db.entity.IT_HokenryouTmttkn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.ST_HoyuuMeisaiTyukeiyouItzHzn;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.db.entity.ZT_RrtHndugtHknVKnsyuyuTy;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 利率変動型保険Ｖ検証用情報作成クラス
 */
public class SrRrtHndugtHknVKnsyuyuBatch implements Batch {

    @Inject
    private SrRrtHndugtHknVKnsyuyuBatchParam srRrtHndugtHknVKnsyuyuParam;

    @Inject
    private BatchLogger batchLogger;

    private long tableinsKns = 0;

    @Override
    public BatchParam getParam() {

        return srRrtHndugtHknVKnsyuyuParam;
    }

    @Execute
    @Transactional
    public void execute() {

        String kakutyouJobcd = "";

        SrRrtHndugtHknVKnsyuyuDbaStatement srRrtHndugtHknVKnsyuyuDbaStatement = SWAKInjector
            .getInstance(SrRrtHndugtHknVKnsyuyuDbaStatement.class);

        if (SrRrtHndugtHknVKnsyuyuBatchParam.RGKBM001.equals(srRrtHndugtHknVKnsyuyuParam.getIbKakutyoujobcd())) {

            kakutyouJobcd = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIJIZEN1_HY;
        }
        else if (SrRrtHndugtHknVKnsyuyuBatchParam.RGKBM002.equals(srRrtHndugtHknVKnsyuyuParam.getIbKakutyoujobcd())) {

            kakutyouJobcd = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIJIZEN2_HY;
        }
        else if (SrRrtHndugtHknVKnsyuyuBatchParam.RGKBM003.equals(srRrtHndugtHknVKnsyuyuParam.getIbKakutyoujobcd())) {

            kakutyouJobcd = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIJIZEN3_HY;
        }
        else if (SrRrtHndugtHknVKnsyuyuBatchParam.RGKBM004.equals(srRrtHndugtHknVKnsyuyuParam.getIbKakutyoujobcd())) {

            kakutyouJobcd = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIHONBAN_HY;
        }

        try (EntityInserter<ZT_RrtHndugtHknVKnsyuyuTy> rrtHndugtHknVKnsyuyuTyLst = new EntityInserter<>();
            ExDBResults<ST_HoyuuMeisaiTyukeiyouItzHzn> hoyuuMeisaiTyukeiyouItzHznLst = srRrtHndugtHknVKnsyuyuDbaStatement
                .getHoyuuMeisaiTyukeiyouItzHzns(srRrtHndugtHknVKnsyuyuParam.getKijyunymd().getBizDateYM().toString(),
                    kakutyouJobcd, SrCommonConstants.HKNSYUKIGOU_YOTEIRIRITUHENDOU_ARRAY);) {

            for (ST_HoyuuMeisaiTyukeiyouItzHzn hoyuuMeisaiTyukeiyouItzHzn : hoyuuMeisaiTyukeiyouItzHznLst) {

                ZT_RrtHndugtHknVKnsyuyuTy rrtHndugtHknVKnsyuyuTy = new ZT_RrtHndugtHknVKnsyuyuTy();

                List<SV_KiykSyuhnData> kiykSyuhnDataLst = srRrtHndugtHknVKnsyuyuDbaStatement
                    .getKiykSyuhnDatasBySyonoSyutkkbn(hoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino(), C_SyutkKbn.SYU);

                SrGetTokutejitenSyohnInfo srGetTokutejitenSyohnInfo = SWAKInjector.getInstance(SrGetTokutejitenSyohnInfo.class);

                TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBean = srGetTokutejitenSyohnInfo.exec(
                    C_TokutejitenSyoriKbn.KIJYUNBIJITENSYOUHININFO,
                    hoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino(),
                    srRrtHndugtHknVKnsyuyuParam.getKijyunymd(),
                    "",
                    kiykSyuhnDataLst).getTkJitenKeiyakuSyouhinKijyunBeanAto();

                IT_KykKihon kykKihon = srRrtHndugtHknVKnsyuyuDbaStatement.getKykKihon(hoyuuMeisaiTyukeiyouItzHzn
                    .getZtydatakanrino());

                BizDateYM kijyunym = null;

                if (BizDateUtil.compareYmd(srRrtHndugtHknVKnsyuyuParam.getKijyunymd(),
                    BizDate.valueOf(hoyuuMeisaiTyukeiyouItzHzn.getZtykykymd())) == BizDateUtil.COMPARE_GREATER
                    || BizDateUtil.compareYmd(srRrtHndugtHknVKnsyuyuParam.getKijyunymd(),
                        BizDate.valueOf(hoyuuMeisaiTyukeiyouItzHzn.getZtykykymd())) == BizDateUtil.COMPARE_EQUAL) {

                    kijyunym = srRrtHndugtHknVKnsyuyuParam.getKijyunymd().getBizDateYM();
                }

                List<IT_HokenryouTmttkn> hokenryouTmttknLst = srRrtHndugtHknVKnsyuyuDbaStatement.getHokenryouTmttkns(
                    hoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino(),
                    BizDateYM.valueOf(SrCommonConstants.YM_ALL9));

                SrRrtHndugtHknVKnsyuyuItemEditor srRrtHndugtHknVKnsyuyuItemEditor =
                    SWAKInjector.getInstance(SrRrtHndugtHknVKnsyuyuItemEditor.class);

                Boolean result = srRrtHndugtHknVKnsyuyuItemEditor.editKoumoku(srRrtHndugtHknVKnsyuyuParam,
                    hoyuuMeisaiTyukeiyouItzHzn, tkJitenKeiyakuSyouhinKijyunBean, kiykSyuhnDataLst, kykKihon,
                    hokenryouTmttknLst, rrtHndugtHknVKnsyuyuTy);

                if (result) {
                    continue;
                }

                BizPropertyInitializer.initialize(rrtHndugtHknVKnsyuyuTy);

                rrtHndugtHknVKnsyuyuTyLst.add(rrtHndugtHknVKnsyuyuTy);

                tableinsKns++;

            }

            if (srRrtHndugtHknVKnsyuyuParam.getZokkouErrorSyoriKns() != 0 &&
                SrRrtHndugtHknVKnsyuyuBatchParam.RGKBM004.equals(srRrtHndugtHknVKnsyuyuParam.getIbKakutyoujobcd())) {
                throw new BizAppException(MessageUtil.getMessage(MessageId.ISA1001, "数理用エラー情報テーブル",
                    String.valueOf(srRrtHndugtHknVKnsyuyuParam.getZokkouErrorSyoriKns())));
            }

            batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, "利率変動型保険Ｖ検証用Ｆテーブル（中）",
                String.valueOf(tableinsKns)));

            batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, "数理用エラー情報テーブル",
                String.valueOf(srRrtHndugtHknVKnsyuyuParam.getZokkouErrorSyoriKns())));
        }
    }
}
