package yuyu.batch.suuri.srsuuritoukei.srkbkssurnduhknjigyohi;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.suuri.srcommon.SrCommonConstants;
import yuyu.common.suuri.srcommon.SrDateUtil;
import yuyu.common.suuri.suuricommon.SrGetTokutejitenSyohnInfo;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinBean;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinKijyunBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_KessanKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TokutejitenSyoriKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.ST_HoyuuMeisaiTyukeiyouItzHzn;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.db.entity.ZT_KbkSsuRnduHknJigyohiTy;
import yuyu.def.db.entity.ZT_KsnKbkSsuRnduHknJigyohiTy;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 数理 数理統計 株価指数連動保険事業費情報作成
 */
public class SrKbkSsuRnduHknJigyohiBatch implements Batch {

    private static final String SUURIYOUERRJYOUHOUNM = "数理用エラー情報テーブル";

    private static final String SUURIYOUERRJYOUHOUNM_KEIKOKU = "数理用エラー情報テーブル（警告）";

    private static final String KBKSSURNDUHKNJIGYOHITYNM = "株価指数連動保険事業費Ｆテーブル（中）";

    private static final String KSNKBKSSURNDUHKNJIGYOHITYNM = "決算計上用株価指数連動保険事業費Ｆテーブル（中）";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private SrKbkSsuRnduHknJigyohiBatchParam srKbkSsuRnduHknJigyohiBatchParam;

    private int regetuTableKns;

    private int kessanTableKns;

    @Override
    public BatchParam getParam() {
        return srKbkSsuRnduHknJigyohiBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate kijyunYmd = srKbkSsuRnduHknJigyohiBatchParam.getKijyunymd();
        String ibKakutyoujobcd = srKbkSsuRnduHknJigyohiBatchParam.getIbKakutyoujobcd();
        regetuTableKns = 0;
        kessanTableKns = 0;
        C_KessanKbn kessanKbn = C_KessanKbn.TUUJYOU;
        String kakutyouJobcd = "";

        boolean result = SrDateUtil.isKessanTuki(kijyunYmd);

        if (result) {
            kessanKbn = C_KessanKbn.KESSAN;
        }

        SrKbkSsuRnduHknJigyohiBatchDbAccess srKbkSsuRnduHknJigyohiBatchDbAccess = SWAKInjector
            .getInstance(SrKbkSsuRnduHknJigyohiBatchDbAccess.class);

        if (SrKbkSsuRnduHknJigyohiBatchParam.RGJQM000.equals(ibKakutyoujobcd)) {

            kakutyouJobcd = SrCommonConstants.KAKUTYOUJOBCD_REIGETSU_HY;
        }
        else if (SrKbkSsuRnduHknJigyohiBatchParam.RGJQM001.equals(ibKakutyoujobcd)) {

            kakutyouJobcd = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIJIZEN1_HY;
        }
        else if (SrKbkSsuRnduHknJigyohiBatchParam.RGJQM002.equals(ibKakutyoujobcd)) {

            kakutyouJobcd = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIJIZEN2_HY;
        }
        else if (SrKbkSsuRnduHknJigyohiBatchParam.RGJQM003.equals(ibKakutyoujobcd)) {

            kakutyouJobcd = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIJIZEN3_HY;
        }
        else if (SrKbkSsuRnduHknJigyohiBatchParam.RGJQM004.equals(ibKakutyoujobcd)) {

            kakutyouJobcd = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIHONBAN_HY;
        }

        try (ExDBResults<ST_HoyuuMeisaiTyukeiyouItzHzn> hoyuuMeisaiTyukeiyouItzHznLst =null;

            EntityInserter<ZT_KbkSsuRnduHknJigyohiTy> kbkSsuRnduHknJigyohiTyEntityInserter = new EntityInserter<>();

            EntityInserter<ZT_KsnKbkSsuRnduHknJigyohiTy> ksnKbkSsuRnduHknJigyohiTyEntityInserter = new EntityInserter<>();) {

            for (ST_HoyuuMeisaiTyukeiyouItzHzn hoyuuMeisaiTyukeiyouItzHzn : hoyuuMeisaiTyukeiyouItzHznLst) {

                int kessanTaisyouKns = SrCommonConstants.DEFAULT_INT_ZERO;
                int regetuTaisyouKns = SrCommonConstants.DEFAULT_INT_ZERO;

                regetuTaisyouKns++;

                if (BizDateUtil.compareYmd(BizDate.valueOf(hoyuuMeisaiTyukeiyouItzHzn.getZtykykymd()),
                    kijyunYmd) == BizDateUtil.COMPARE_GREATER) {
                    if (kessanKbn.eq(C_KessanKbn.KESSAN)) {
                        kessanTaisyouKns++;
                    }
                }
                else {
                    if (BizDateUtil.compareYm(BizDate.valueOf(hoyuuMeisaiTyukeiyouItzHzn.getZtykykymd())
                        .getBizDateYM(), kijyunYmd.getBizDateYM()) == BizDateUtil.COMPARE_LESSER) {

                        IT_KykKihon kykKihon = srKbkSsuRnduHknJigyohiBatchDbAccess
                            .getKykKihon(hoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino());

                        if (BizDateUtil.compareYm(kykKihon.getSkeikeijyouym(),
                            kijyunYmd.getBizDateYM()) == BizDateUtil.COMPARE_EQUAL) {
                            regetuTaisyouKns++;
                        }
                    }
                }

                List<SV_KiykSyuhnData> kiykSyuhnDataLst = srKbkSsuRnduHknJigyohiBatchDbAccess.getKiykSyuhnDatas(
                    hoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino(), C_SyutkKbn.SYU);

                SrGetTokutejitenSyohnInfo srGetTokutejitenSyohnInfo = SWAKInjector
                    .getInstance(SrGetTokutejitenSyohnInfo.class);

                BizDate tkJitehanteiKijyunymd;
                if (BizDateUtil.compareYmd(BizDate.valueOf(hoyuuMeisaiTyukeiyouItzHzn.getZtykykymd()),
                    kijyunYmd) == BizDateUtil.COMPARE_GREATER) {
                    tkJitehanteiKijyunymd = srKbkSsuRnduHknJigyohiBatchParam.getKijyunymd() ;
                }
                else {
                    tkJitehanteiKijyunymd = BizDate.valueOf(srKbkSsuRnduHknJigyohiBatchParam.getKijyunymd().
                        getBizDateYM(), BizDate.valueOf(hoyuuMeisaiTyukeiyouItzHzn.getZtykykymd()).getDay()).getRekijyou() ;
                }

                TkJitenKeiyakuSyouhinBean tkJitenKeiyakuSyouhinBean = srGetTokutejitenSyohnInfo.exec(
                    C_TokutejitenSyoriKbn.KIJYUNBIJITENSYOUHININFO,
                    hoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino(),
                    tkJitehanteiKijyunymd,
                    "",
                    kiykSyuhnDataLst);

                TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBean = tkJitenKeiyakuSyouhinBean
                    .getTkJitenKeiyakuSyouhinKijyunBeanAto();

                TkJitenKeiyakuSyouhinBean tkJitenKeiyakuSyouhinBean2 = srGetTokutejitenSyohnInfo.exec(
                    C_TokutejitenSyoriKbn.KIJYUNBIJITENSYOUHININFO,
                    hoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino(),
                    srKbkSsuRnduHknJigyohiBatchParam.getKijyunymd(),
                    "",
                    kiykSyuhnDataLst);

                TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBean_gmjiten = tkJitenKeiyakuSyouhinBean2
                    .getTkJitenKeiyakuSyouhinKijyunBeanAto();

                List<ZT_KbkSsuRnduHknJigyohiTy> kbkSsuRnduHknJigyohiTyLst = new ArrayList<ZT_KbkSsuRnduHknJigyohiTy>();
                ZT_KsnKbkSsuRnduHknJigyohiTy ksnKbkSsuRnduHknJigyohiTy = new ZT_KsnKbkSsuRnduHknJigyohiTy();
                Boolean errorFlag = false;
                Boolean errorFlagResult = false;

                for (int m = 0; m < regetuTaisyouKns; m++) {

                    SrKbkSsuRnduHknJigyohiBatchEdit srKbkSsuRnduHknJigyohiBatchEdit = SWAKInjector
                        .getInstance(SrKbkSsuRnduHknJigyohiBatchEdit.class);
                    ZT_KbkSsuRnduHknJigyohiTy kbkSsuRnduHknJigyohiTy = new ZT_KbkSsuRnduHknJigyohiTy();

                    errorFlag = srKbkSsuRnduHknJigyohiBatchEdit.editKoumoku(
                        srKbkSsuRnduHknJigyohiBatchParam,
                        C_KessanKbn.TUUJYOU,
                        m,
                        hoyuuMeisaiTyukeiyouItzHzn,
                        tkJitenKeiyakuSyouhinKijyunBean,
                        kbkSsuRnduHknJigyohiTy,
                        null,
                        tkJitenKeiyakuSyouhinKijyunBean_gmjiten);

                    kbkSsuRnduHknJigyohiTyLst.add(kbkSsuRnduHknJigyohiTy);

                    if (errorFlag) {
                        errorFlagResult = true;
                    }
                }

                if (kessanTaisyouKns > SrCommonConstants.DEFAULT_INT_ZERO) {

                    SrKbkSsuRnduHknJigyohiBatchEdit srKbkSsuRnduHknJigyohiBatchEdit = SWAKInjector
                        .getInstance(SrKbkSsuRnduHknJigyohiBatchEdit.class);

                    errorFlag = srKbkSsuRnduHknJigyohiBatchEdit.editKoumoku(
                        srKbkSsuRnduHknJigyohiBatchParam,
                        C_KessanKbn.KESSAN,
                        SrCommonConstants.DEFAULT_INT_ZERO,
                        hoyuuMeisaiTyukeiyouItzHzn,
                        tkJitenKeiyakuSyouhinKijyunBean,
                        null,
                        ksnKbkSsuRnduHknJigyohiTy,
                        tkJitenKeiyakuSyouhinKijyunBean_gmjiten);

                    if (errorFlag) {
                        errorFlagResult = true;
                    }
                }

                if (errorFlagResult) {
                    continue;
                }
                for (int i = 0; i < regetuTaisyouKns; i++) {
                    BizPropertyInitializer.initialize(kbkSsuRnduHknJigyohiTyLst.get(i));

                    kbkSsuRnduHknJigyohiTyEntityInserter.add(kbkSsuRnduHknJigyohiTyLst.get(i));

                    regetuTableKns++;
                }

                if (C_KessanKbn.KESSAN.eq(kessanKbn) && kessanTaisyouKns != SrCommonConstants.DEFAULT_INT_ZERO) {
                    BizPropertyInitializer.initialize(ksnKbkSsuRnduHknJigyohiTy);

                    ksnKbkSsuRnduHknJigyohiTyEntityInserter.add(ksnKbkSsuRnduHknJigyohiTy);

                    kessanTableKns++;
                }
            }

            if (srKbkSsuRnduHknJigyohiBatchParam.getZokkouErrorSyoriCount() != 0
                && (SrKbkSsuRnduHknJigyohiBatchParam.RGJQM000.equals(ibKakutyoujobcd) ||
                    SrKbkSsuRnduHknJigyohiBatchParam.RGJQM004.equals(ibKakutyoujobcd))) {

                throw new BizAppException(MessageId.ISA1001, SUURIYOUERRJYOUHOUNM,
                    String.valueOf(srKbkSsuRnduHknJigyohiBatchParam.getZokkouErrorSyoriCount()));
            }
            batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, KBKSSURNDUHKNJIGYOHITYNM,
                String.valueOf(regetuTableKns)));

            if (kessanKbn.eq(C_KessanKbn.KESSAN)) {
                batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, KSNKBKSSURNDUHKNJIGYOHITYNM,
                    String.valueOf(kessanTableKns)));
            }

            batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, SUURIYOUERRJYOUHOUNM,
                String.valueOf(srKbkSsuRnduHknJigyohiBatchParam.getZokkouErrorSyoriCount())));

            batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, SUURIYOUERRJYOUHOUNM_KEIKOKU,
                String.valueOf(srKbkSsuRnduHknJigyohiBatchParam.getKeikokuSyoriCount())));

        }
    }
}
