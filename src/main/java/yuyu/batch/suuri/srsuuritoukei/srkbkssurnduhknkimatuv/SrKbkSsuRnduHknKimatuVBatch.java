package yuyu.batch.suuri.srsuuritoukei.srkbkssurnduhknkimatuv;

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
import yuyu.common.suuri.srcommon.SrCommonConstants;
import yuyu.common.suuri.suuricommon.SrGetTokutejitenSyohnInfo;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinBean;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinKijyunBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TokutejitenSyoriKbn;
import yuyu.def.db.entity.ST_HoyuuMeisaiTyukeiyouItzHzn;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.db.entity.ZT_KbkSsuRnduHknKimatuVTy;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 数理統計 数理統計 株価指数連動保険期末Ｖ情報作成
 */
public class SrKbkSsuRnduHknKimatuVBatch implements Batch {

    private static final String SUURIYOUERRJYOUHOUTBL_NAME = "数理用エラー情報テーブル";

    private static final String KBKSSURNDUHKNKIMATUVTY_NAME = "株価指数連動保険期末ＶＦテーブル（中）";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private SrKbkSsuRnduHknKimatuVBatchParam batchParam;

    private int tableCount;

    @Override
    public BatchParam getParam() {
        return batchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        tableCount = 0;
        String ibKakutyouJobCd = batchParam.getIbKakutyoujobcd();
        String kakutyouJobCd = "";

        if (SrKbkSsuRnduHknKimatuVBatchParam.RGJMM000.equals(ibKakutyouJobCd)) {

            kakutyouJobCd = SrCommonConstants.KAKUTYOUJOBCD_REIGETSU_HY;
        }
        else if (SrKbkSsuRnduHknKimatuVBatchParam.RGJMM001.equals(ibKakutyouJobCd)) {

            kakutyouJobCd = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIJIZEN1_HY;
        }
        else if (SrKbkSsuRnduHknKimatuVBatchParam.RGJMM002.equals(ibKakutyouJobCd)) {

            kakutyouJobCd = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIJIZEN2_HY;
        }
        else if (SrKbkSsuRnduHknKimatuVBatchParam.RGJMM003.equals(ibKakutyouJobCd)) {

            kakutyouJobCd = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIJIZEN3_HY;
        }
        else if (SrKbkSsuRnduHknKimatuVBatchParam.RGJMM004.equals(ibKakutyouJobCd)) {

            kakutyouJobCd = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIHONBAN_HY;
        }

        SrKbkSsuRnduHknKimatuVBatchDbAccess dbAccess =
            SWAKInjector.getInstance(SrKbkSsuRnduHknKimatuVBatchDbAccess.class);

        try (
            ExDBResults<ST_HoyuuMeisaiTyukeiyouItzHzn> hoyuuMeisaiTyukeiyouItzHznList =null;
            EntityInserter<ZT_KbkSsuRnduHknKimatuVTy> kbkSsuRnduHknKimatuVTyInserter = new EntityInserter<>(); ) {

            SrGetTokutejitenSyohnInfo srGetTokutejitenSyohnInfo = SWAKInjector.getInstance(SrGetTokutejitenSyohnInfo.class);
            SrKbkSsuRnduHknKimatuVBatchEdit editKoumoku = null;
            ZT_KbkSsuRnduHknKimatuVTy kbkSsuRnduHknKimatuVTy;

            for (ST_HoyuuMeisaiTyukeiyouItzHzn hoyuuMeisaiTyukeiyouItzHzn : hoyuuMeisaiTyukeiyouItzHznList) {

                List<SV_KiykSyuhnData> kiykSyuhnDataLst =
                    dbAccess.getKiykSyuhnData(hoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino(), C_SyutkKbn.SYU);

                TkJitenKeiyakuSyouhinBean tkJitenKeiyakuSyouhinBean = srGetTokutejitenSyohnInfo.exec(
                    C_TokutejitenSyoriKbn.KIJYUNBIJITENSYOUHININFO,
                    hoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino(),
                    batchParam.getKijyunymd(),
                    "",
                    kiykSyuhnDataLst);

                TkJitenKeiyakuSyouhinKijyunBean tkjtSyouhinInfo =
                    tkJitenKeiyakuSyouhinBean.getTkJitenKeiyakuSyouhinKijyunBeanAto();

                editKoumoku = SWAKInjector.getInstance(SrKbkSsuRnduHknKimatuVBatchEdit.class);

                kbkSsuRnduHknKimatuVTy = new ZT_KbkSsuRnduHknKimatuVTy();

                boolean editKoumokuErrorFlag = editKoumoku.editKoumoku(
                    batchParam,
                    hoyuuMeisaiTyukeiyouItzHzn,
                    tkjtSyouhinInfo,
                    kbkSsuRnduHknKimatuVTy,
                    kiykSyuhnDataLst);

                if (editKoumokuErrorFlag) {

                    continue;
                }


                BizPropertyInitializer.initialize(kbkSsuRnduHknKimatuVTy);

                kbkSsuRnduHknKimatuVTyInserter.add(kbkSsuRnduHknKimatuVTy);

                tableCount++;
            }
        }

        if (batchParam.getErrorSyoriKensuu() != 0 &&
            (SrKbkSsuRnduHknKimatuVBatchParam.RGJMM000.equals(ibKakutyouJobCd) ||
                SrKbkSsuRnduHknKimatuVBatchParam.RGJMM004.equals(ibKakutyouJobCd))) {

            throw new BizAppException(MessageId.ISA1001, SUURIYOUERRJYOUHOUTBL_NAME,
                String.valueOf(batchParam.getErrorSyoriKensuu()));
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, KBKSSURNDUHKNKIMATUVTY_NAME,
            String.valueOf(tableCount)));

        batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, SUURIYOUERRJYOUHOUTBL_NAME,
            String.valueOf(batchParam.getErrorSyoriKensuu())));
    }
}
