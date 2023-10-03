package yuyu.batch.suuri.srsuuritoukei.srrayjigyohi;

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
import yuyu.def.db.entity.ZT_KsnRayJigyohiTy;
import yuyu.def.db.entity.ZT_RayJigyohiTy;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 数理 数理統計 ＲＡＹ事業費情報作成
 */
public class SrRayJigyohiBatch implements Batch {

    private static final String SUURIYOUERRJYOUHOUNM = "数理用エラー情報テーブル";

    private static final String RAYJIGYOHITYNM = "ＲＡＹ事業費Ｆテーブル（中）";

    private static final String KSNRAYJIGYOHITYNM = "決算計上用ＲＡＹ事業費Ｆテーブル（中）";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private SrRayJigyohiBatchParam srRayJigyohiBatchParam;

    private int regetuTableKns;

    private int kessanTableKns;

    @Override
    public BatchParam getParam() {
        return srRayJigyohiBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate kijyunYmd = srRayJigyohiBatchParam.getKijyunymd();
        String ibKakutyoujobcd = srRayJigyohiBatchParam.getIbKakutyoujobcd();
        regetuTableKns = 0;
        kessanTableKns = 0;
        C_KessanKbn kessanKbn = C_KessanKbn.TUUJYOU;
        String kakutyouJobcd = "";

        boolean result = SrDateUtil.isKessanTuki(kijyunYmd);

        if (result) {
            kessanKbn = C_KessanKbn.KESSAN;
        }

        SrRayJigyohiBatchDbAccess srRayJigyohiBatchDbAccess = SWAKInjector
            .getInstance(SrRayJigyohiBatchDbAccess.class);

        if (SrRayJigyohiBatchParam.RGJQM000.equals(ibKakutyoujobcd)) {

            kakutyouJobcd = SrCommonConstants.KAKUTYOUJOBCD_REIGETSU_HY;
        }
        else if (SrRayJigyohiBatchParam.RGJQM001.equals(ibKakutyoujobcd)) {

            kakutyouJobcd = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIJIZEN1_HY;
        }
        else if (SrRayJigyohiBatchParam.RGJQM002.equals(ibKakutyoujobcd)) {

            kakutyouJobcd = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIJIZEN2_HY;
        }
        else if (SrRayJigyohiBatchParam.RGJQM003.equals(ibKakutyoujobcd)) {

            kakutyouJobcd = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIJIZEN3_HY;
        }
        else if (SrRayJigyohiBatchParam.RGJQM004.equals(ibKakutyoujobcd)) {

            kakutyouJobcd = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIHONBAN_HY;
        }

        try (ExDBResults<ST_HoyuuMeisaiTyukeiyouItzHzn> hoyuuMeisaiTyukeiyouItzHznLst =
            srRayJigyohiBatchDbAccess.getHoyuuMeisaiTyukeiyouItzHzns(kijyunYmd.getBizDateYM().toString(),
                kakutyouJobcd, SrCommonConstants.HKNSYUKIGOU_RAY_ARRAY);

            EntityInserter<ZT_RayJigyohiTy> rayJigyohiTyEntityInserter = new EntityInserter<>();

            EntityInserter<ZT_KsnRayJigyohiTy> ksnRayJigyohiTyEntityInserter = new EntityInserter<>();) {

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

                        IT_KykKihon kykKihon = srRayJigyohiBatchDbAccess
                            .getKykKihon(hoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino());

                        if (BizDateUtil.compareYm(kykKihon.getSkeikeijyouym(),
                            kijyunYmd.getBizDateYM()) == BizDateUtil.COMPARE_EQUAL) {
                            regetuTaisyouKns++;
                        }
                    }
                }

                List<SV_KiykSyuhnData> kiykSyuhnDataLst = srRayJigyohiBatchDbAccess.getKiykSyuhnDatas(
                    hoyuuMeisaiTyukeiyouItzHzn.getZtydatakanrino(), C_SyutkKbn.SYU);

                SrGetTokutejitenSyohnInfo srGetTokutejitenSyohnInfo = SWAKInjector
                    .getInstance(SrGetTokutejitenSyohnInfo.class);

                BizDate tkJitehanteiKijyunymd;
                if (BizDateUtil.compareYmd(BizDate.valueOf(hoyuuMeisaiTyukeiyouItzHzn.getZtykykymd()),
                    kijyunYmd) == BizDateUtil.COMPARE_GREATER) {
                    tkJitehanteiKijyunymd = srRayJigyohiBatchParam.getKijyunymd() ;
                }
                else {
                    tkJitehanteiKijyunymd = BizDate.valueOf(srRayJigyohiBatchParam.getKijyunymd().
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
                    srRayJigyohiBatchParam.getKijyunymd(),
                    "",
                    kiykSyuhnDataLst);

                TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBean_gmjiten = tkJitenKeiyakuSyouhinBean2
                    .getTkJitenKeiyakuSyouhinKijyunBeanAto();

                List<ZT_RayJigyohiTy> rayJigyohiTyLst = new ArrayList<ZT_RayJigyohiTy>();
                ZT_KsnRayJigyohiTy ksnRayJigyohiTy = new ZT_KsnRayJigyohiTy();
                Boolean errorFlag = false;
                Boolean errorFlagResult = false;

                for (int m = 0; m < regetuTaisyouKns; m++) {

                    SrRayJigyohiBatchEdit srRayJigyohiBatchEdit = SWAKInjector
                        .getInstance(SrRayJigyohiBatchEdit.class);
                    ZT_RayJigyohiTy rayJigyohiTy = new ZT_RayJigyohiTy();

                    errorFlag = srRayJigyohiBatchEdit.editKoumoku(
                        srRayJigyohiBatchParam,
                        C_KessanKbn.TUUJYOU,
                        m,
                        hoyuuMeisaiTyukeiyouItzHzn,
                        tkJitenKeiyakuSyouhinKijyunBean,
                        rayJigyohiTy,
                        null,
                        tkJitenKeiyakuSyouhinKijyunBean_gmjiten);

                    rayJigyohiTyLst.add(rayJigyohiTy);

                    if (errorFlag) {
                        errorFlagResult = true;
                    }
                }

                if (kessanTaisyouKns > SrCommonConstants.DEFAULT_INT_ZERO) {

                    SrRayJigyohiBatchEdit srRayJigyohiBatchEdit = SWAKInjector
                        .getInstance(SrRayJigyohiBatchEdit.class);

                    errorFlag = srRayJigyohiBatchEdit.editKoumoku(
                        srRayJigyohiBatchParam,
                        C_KessanKbn.KESSAN,
                        SrCommonConstants.DEFAULT_INT_ZERO,
                        hoyuuMeisaiTyukeiyouItzHzn,
                        tkJitenKeiyakuSyouhinKijyunBean,
                        null,
                        ksnRayJigyohiTy,
                        tkJitenKeiyakuSyouhinKijyunBean_gmjiten);

                    if (errorFlag) {
                        errorFlagResult = true;
                    }
                }

                if (errorFlagResult) {
                    continue;
                }
                for (int i = 0; i < regetuTaisyouKns; i++) {
                    BizPropertyInitializer.initialize(rayJigyohiTyLst.get(i));

                    rayJigyohiTyEntityInserter.add(rayJigyohiTyLst.get(i));

                    regetuTableKns++;
                }

                if (C_KessanKbn.KESSAN.eq(kessanKbn) && kessanTaisyouKns != SrCommonConstants.DEFAULT_INT_ZERO) {
                    BizPropertyInitializer.initialize(ksnRayJigyohiTy);

                    ksnRayJigyohiTyEntityInserter.add(ksnRayJigyohiTy);

                    kessanTableKns++;
                }
            }

            if (srRayJigyohiBatchParam.getZokkouErrorSyoriCount() != 0
                && (SrRayJigyohiBatchParam.RGJQM000.equals(ibKakutyoujobcd) ||
                    SrRayJigyohiBatchParam.RGJQM004.equals(ibKakutyoujobcd))) {

                throw new BizAppException(MessageId.ISA1001, SUURIYOUERRJYOUHOUNM,
                    String.valueOf(srRayJigyohiBatchParam.getZokkouErrorSyoriCount()));
            }
            batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, RAYJIGYOHITYNM,
                String.valueOf(regetuTableKns)));

            if (kessanKbn.eq(C_KessanKbn.KESSAN)) {
                batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, KSNRAYJIGYOHITYNM,
                    String.valueOf(kessanTableKns)));
            }

            batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, SUURIYOUERRJYOUHOUNM,
                String.valueOf(srRayJigyohiBatchParam.getZokkouErrorSyoriCount())));
        }
    }
}
