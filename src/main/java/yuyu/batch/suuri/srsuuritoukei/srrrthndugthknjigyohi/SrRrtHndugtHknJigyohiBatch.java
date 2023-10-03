package yuyu.batch.suuri.srsuuritoukei.srrrthndugthknjigyohi;

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
import yuyu.common.suuri.srcommon.SrDateUtil;
import yuyu.common.suuri.suuricommon.SrGetTokutejitenSyohnInfo;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinBean;
import yuyu.common.suuri.suuricommon.TkJitenKeiyakuSyouhinKijyunBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_KessanKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TokutejitenSyoriKbn;
import yuyu.def.db.entity.IT_HokenryouTmttkn;
import yuyu.def.db.entity.ST_SynypTukiTugtTykiyuHozon;
import yuyu.def.db.entity.ST_SynypTukiYkgtIkouHozon;
import yuyu.def.db.entity.SV_HoyuuMeisai;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.db.entity.ZT_RrtHndugtHknJigyohiTy;
import yuyu.def.db.entity.ZT_RrtHndugtHknKsnJigyohiTy;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 数理 数理統計 利率変動型保険事業費情報作成
 */
public class SrRrtHndugtHknJigyohiBatch implements Batch {

    private static final String SUURIYOUERRJYOUHOUNM = "数理用エラー情報テーブル";

    private static final String RRTHNDUGTHKNJIGYOHITYNM = "利率変動型保険事業費Ｆテーブル（中）";

    private static final String RRTHNDUGTHKNKSNJIGYOHITYNM = "利率変動型保険決算用事業費Ｆテーブル（中）";

    private static final String SYNYPTUKIYKGTIKOUHOZONNM = "収入Ｐ統計翌月以降保存テーブル";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private SrRrtHndugtHknJigyohiBatchParam srRrtHndugtHknJigyohiBatchParam;

    private int regetuTableKns;

    private int kessanTableKns;

    private int yokugetuTableKns;

    @Override
    public BatchParam getParam() {
        return srRrtHndugtHknJigyohiBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        regetuTableKns = 0;
        kessanTableKns = 0;
        yokugetuTableKns = 0;

        BizDate kijyunYmd = srRrtHndugtHknJigyohiBatchParam.getKijyunymd();
        BizDateYM kijyunYm = srRrtHndugtHknJigyohiBatchParam.getKijyunymd().getBizDateYM();
        String ibKakutyoujobcd = srRrtHndugtHknJigyohiBatchParam.getIbKakutyoujobcd();

        C_KessanKbn kessanKbn;

        boolean result = SrDateUtil.isKessanTuki(kijyunYmd);

        if (result) {
            kessanKbn = C_KessanKbn.KESSAN;
        }
        else {
            kessanKbn = C_KessanKbn.TUUJYOU;
        }

        SrRrtHndugtHknJigyohiBatchDbAccess srRrtHndugtHknJigyohiBatchDbAccess = SWAKInjector
            .getInstance(SrRrtHndugtHknJigyohiBatchDbAccess.class);

        BizDateYM tkJitehanteiKijyunym = kijyunYm.addMonths(-SrCommonConstants.KIKAN_1M).getRekijyou();

        BizDate tkJitehanteiKijyunymd = tkJitehanteiKijyunym.getLastDay();

        try (ExDBResults<ST_SynypTukiYkgtIkouHozon> synypTukiYkgtIkouHozonLst =
            srRrtHndugtHknJigyohiBatchDbAccess.getHoyuuMeisaiTyukeiyouItzHzns(kijyunYm);

            EntityInserter<ZT_RrtHndugtHknJigyohiTy> rrtHndugtHknJigyohiTyEntityInserter = new EntityInserter<>();) {

            for (ST_SynypTukiYkgtIkouHozon synypTukiYkgtIkouHozon : synypTukiYkgtIkouHozonLst) {

                List<SV_KiykSyuhnData> kiykSyuhnDataLst = srRrtHndugtHknJigyohiBatchDbAccess.getKiykSyuhnDatas(
                    synypTukiYkgtIkouHozon.getSyono(), C_SyutkKbn.SYU);

                SrGetTokutejitenSyohnInfo srGetTokutejitenSyohnInfo =
                    SWAKInjector.getInstance(SrGetTokutejitenSyohnInfo.class);

                TkJitenKeiyakuSyouhinBean tkJitenKeiyakuSyouhinBean = srGetTokutejitenSyohnInfo.exec(
                    C_TokutejitenSyoriKbn.KIJYUNBIJITENSYOUHININFO,
                    synypTukiYkgtIkouHozon.getSyono(),
                    tkJitehanteiKijyunymd,
                    "",
                    kiykSyuhnDataLst);

                TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBean = tkJitenKeiyakuSyouhinBean
                    .getTkJitenKeiyakuSyouhinKijyunBeanAto();

                insertZtydata(C_KessanKbn.TUUJYOU,
                    synypTukiYkgtIkouHozon.getSyono(),
                    kijyunYm,
                    synypTukiYkgtIkouHozon.getTaisyakukbn(),
                    synypTukiYkgtIkouHozon.getDenymd(),
                    synypTukiYkgtIkouHozon.getSyoricd(),
                    synypTukiYkgtIkouHozon.getSyoriYmd(),
                    synypTukiYkgtIkouHozon.getSeg1cd(),
                    synypTukiYkgtIkouHozon.getZennoujiikkatubaraijytgk(),
                    synypTukiYkgtIkouHozon.getDenrenno(),
                    tkJitenKeiyakuSyouhinKijyunBean,
                    kiykSyuhnDataLst,
                    rrtHndugtHknJigyohiTyEntityInserter,
                    null);
            }
        }

        String kakutyoujobcdSkSynyp = "";
        String kakutyoujobcdGekkanHnkSynyp = "";

        if (SrRrtHndugtHknJigyohiBatchParam.RGKCM000.equals(ibKakutyoujobcd)) {
            kakutyoujobcdSkSynyp = SrCommonConstants.KAKUTYOUJOBCD_REIGETSU_SKEISYNYP;
            kakutyoujobcdGekkanHnkSynyp = SrCommonConstants.KAKUTYOUJOBCD_REIGETSU_GKKNHNKUSYNYP;
        }
        else if (SrRrtHndugtHknJigyohiBatchParam.RGKCM002.equals(ibKakutyoujobcd)) {
            kakutyoujobcdSkSynyp = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIJIZEN2_SKEISYNYP;
            kakutyoujobcdGekkanHnkSynyp = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIJIZEN2_GKKNHNKUSYNYP;
        }
        else if (SrRrtHndugtHknJigyohiBatchParam.RGKCM003.equals(ibKakutyoujobcd)) {
            kakutyoujobcdSkSynyp = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIJIZEN3_SKEISYNYP;
            kakutyoujobcdGekkanHnkSynyp = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIJIZEN3_GKKNHNKUSYNYP;
        }
        else if (SrRrtHndugtHknJigyohiBatchParam.RGKCM004.equals(ibKakutyoujobcd)) {
            kakutyoujobcdSkSynyp = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIHONBAN_SKEISYNYP;
            kakutyoujobcdGekkanHnkSynyp = SrCommonConstants.KAKUTYOUJOBCD_KESSANKIHONBAN_GKKNHNKUSYNYP;
        }

        try (ExDBResults<ST_SynypTukiTugtTykiyuHozon> synypTukiTugtTykiyuHozonLst =
            srRrtHndugtHknJigyohiBatchDbAccess.getSynypTukiTugtTykiyuHozons(kijyunYm, kakutyoujobcdSkSynyp, kakutyoujobcdGekkanHnkSynyp);

            EntityInserter<ZT_RrtHndugtHknJigyohiTy> rrtHndugtHknJigyohiTyEntityInserter = new EntityInserter<>();
            EntityInserter<ZT_RrtHndugtHknKsnJigyohiTy> rrtHndugtHknKsnJigyohiTyEntityInserter = new EntityInserter<>();
            EntityInserter<ST_SynypTukiYkgtIkouHozon> synypTukiYkgtIkouHozonEntityInserter = new EntityInserter<>();) {

            for (ST_SynypTukiTugtTykiyuHozon synypTukiTugtTykiyuHozon : synypTukiTugtTykiyuHozonLst) {

                if (SrCommonConstants.SYORICD_GENGAKU.equals(synypTukiTugtTykiyuHozon.getZtysyoricd())) {

                    continue;
                }

                BizDateYM jyutouStartYm = null;
                int jyutoukaisuuy = 0;
                int jyutoukaisuum = 0;
                int jyuutoutukisuu = 0;
                BizDateYM jyutouEndYm = null;

                jyutouStartYm = BizDateYM.valueOf(synypTukiTugtTykiyuHozon.getZtyjyuutouym());
                jyutoukaisuuy = Integer.parseInt(synypTukiTugtTykiyuHozon.getZtyjyuutoukaisuu().substring(0 ,2));
                jyutoukaisuum = Integer.parseInt(synypTukiTugtTykiyuHozon.getZtyjyuutoukaisuu().substring(2));
                jyuutoutukisuu = (jyutoukaisuuy * SrCommonConstants.KIKAN_12M) + jyutoukaisuum;
                jyutouEndYm = jyutouStartYm.addMonths(jyuutoutukisuu - SrCommonConstants.KIKAN_1M).getRekijyou();

                List<SV_KiykSyuhnData> kiykSyuhnDataList = srRrtHndugtHknJigyohiBatchDbAccess.getKiykSyuhnDatas(
                    synypTukiTugtTykiyuHozon.getZtydatakanrino(), C_SyutkKbn.SYU);

                if (C_KessanKbn.KESSAN.eq(kessanKbn)
                    && BizDateUtil.compareYmd(kijyunYmd, kiykSyuhnDataList.get(kiykSyuhnDataList.size() - 1)
                        .getKykymd()) == BizDateUtil.COMPARE_LESSER
                        && BizDateUtil.compareYm(jyutouStartYm, kiykSyuhnDataList.get(kiykSyuhnDataList.size() - 1)
                            .getKykymd().getBizDateYM()) == BizDateUtil.COMPARE_EQUAL) {

                    SrGetTokutejitenSyohnInfo srGetTokutejitenSyohnInfo1 =
                        SWAKInjector.getInstance(SrGetTokutejitenSyohnInfo.class);

                    TkJitenKeiyakuSyouhinBean tkJitenKeiyakuSyouhinBean = srGetTokutejitenSyohnInfo1.exec(
                        C_TokutejitenSyoriKbn.KIJYUNBIJITENSYOUHININFO,
                        synypTukiTugtTykiyuHozon.getZtydatakanrino(),
                        kijyunYmd,
                        "",
                        kiykSyuhnDataList);

                    TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBean1 = tkJitenKeiyakuSyouhinBean
                        .getTkJitenKeiyakuSyouhinKijyunBeanAto();

                    insertZtydata(C_KessanKbn.KESSAN,
                        synypTukiTugtTykiyuHozon.getZtydatakanrino(),
                        jyutouStartYm,
                        C_TaisyakuKbn.valueOf(synypTukiTugtTykiyuHozon.getZtyrecordkbn()),
                        BizDate.valueOf(synypTukiTugtTykiyuHozon.getZtydenymd()),
                        synypTukiTugtTykiyuHozon.getZtysyoricd(),
                        BizDate.valueOf(synypTukiTugtTykiyuHozon.getZtyhenkousyoriymd()),
                        C_Segcd.valueOf(synypTukiTugtTykiyuHozon.getZtykbnkeiriyousegmentcd()),
                        synypTukiTugtTykiyuHozon.getZtyzennoujiikkatubaraijytgk(),
                        synypTukiTugtTykiyuHozon.getZtysrdenrenno(),
                        tkJitenKeiyakuSyouhinKijyunBean1,
                        kiykSyuhnDataList,
                        null,
                        rrtHndugtHknKsnJigyohiTyEntityInserter);
                }

                if (BizDateUtil.compareYm(jyutouStartYm, kijyunYm) == BizDateUtil.COMPARE_LESSER ||
                    BizDateUtil.compareYm(jyutouStartYm, kijyunYm) == BizDateUtil.COMPARE_EQUAL) {

                    BizDateYM pjytoym = jyutouStartYm;
                    BizDateYM outendym = null;

                    if (BizDateUtil.compareYm(jyutouEndYm, kijyunYm) == BizDateUtil.COMPARE_LESSER) {
                        outendym = jyutouEndYm;
                    }
                    else {
                        outendym = kijyunYm;
                    }

                    while (!(BizDateUtil.compareYm(pjytoym, outendym) == BizDateUtil.COMPARE_GREATER))  {

                        SrGetTokutejitenSyohnInfo srGetTokutejitenSyohnInfo =
                            SWAKInjector.getInstance(SrGetTokutejitenSyohnInfo.class);

                        TkJitenKeiyakuSyouhinBean tkJitenKeiyakuSyouhinBean = srGetTokutejitenSyohnInfo.exec(
                            C_TokutejitenSyoriKbn.KIJYUNBIJITENSYOUHININFO,
                            synypTukiTugtTykiyuHozon.getZtydatakanrino(),
                            pjytoym.getLastDay(),
                            "",
                            kiykSyuhnDataList);

                        TkJitenKeiyakuSyouhinKijyunBean tkJitenKeiyakuSyouhinKijyunBean = tkJitenKeiyakuSyouhinBean
                            .getTkJitenKeiyakuSyouhinKijyunBeanAto();

                        insertZtydata(C_KessanKbn.TUUJYOU,
                            synypTukiTugtTykiyuHozon.getZtydatakanrino(),
                            pjytoym,
                            C_TaisyakuKbn.valueOf(synypTukiTugtTykiyuHozon.getZtyrecordkbn()),
                            BizDate.valueOf(synypTukiTugtTykiyuHozon.getZtydenymd()),
                            synypTukiTugtTykiyuHozon.getZtysyoricd(),
                            BizDate.valueOf(synypTukiTugtTykiyuHozon.getZtyhenkousyoriymd()),
                            C_Segcd.valueOf(synypTukiTugtTykiyuHozon.getZtykbnkeiriyousegmentcd()),
                            synypTukiTugtTykiyuHozon.getZtyzennoujiikkatubaraijytgk(),
                            synypTukiTugtTykiyuHozon.getZtysrdenrenno(),
                            tkJitenKeiyakuSyouhinKijyunBean,
                            kiykSyuhnDataList,
                            rrtHndugtHknJigyohiTyEntityInserter,
                            null);

                        pjytoym = pjytoym.addMonths(SrCommonConstants.KIKAN_1M).getRekijyou();
                    }
                }

                if (BizDateUtil.compareYm(kijyunYm, jyutouEndYm) == BizDateUtil.COMPARE_LESSER) {

                    if (SrRrtHndugtHknJigyohiBatchParam.RGKCM000.equals(ibKakutyoujobcd) ||
                        SrRrtHndugtHknJigyohiBatchParam.RGKCM004.equals(ibKakutyoujobcd)) {

                        ST_SynypTukiYkgtIkouHozon synypTukiYkgtIkouHozon = new ST_SynypTukiYkgtIkouHozon();
                        synypTukiYkgtIkouHozon.setSrkijyunym(String.valueOf(kijyunYm));
                        synypTukiYkgtIkouHozon.setSequenceno(yokugetuTableKns);
                        synypTukiYkgtIkouHozon.setSyono(synypTukiTugtTykiyuHozon.getZtydatakanrino());
                        synypTukiYkgtIkouHozon.setJyutoustartym(BizDateYM.valueOf(synypTukiTugtTykiyuHozon.getZtyjyuutouym()));
                        synypTukiYkgtIkouHozon.setJyutouendym(jyutouEndYm);
                        synypTukiYkgtIkouHozon.setTaisyakukbn(C_TaisyakuKbn.valueOf(synypTukiTugtTykiyuHozon.getZtyrecordkbn()));
                        synypTukiYkgtIkouHozon.setDenymd(BizDate.valueOf(synypTukiTugtTykiyuHozon.getZtydenymd()));
                        synypTukiYkgtIkouHozon.setSyoricd(synypTukiTugtTykiyuHozon.getZtysyoricd());
                        synypTukiYkgtIkouHozon.setSyoriYmd(BizDate.valueOf(synypTukiTugtTykiyuHozon.getZtyhenkousyoriymd()));
                        synypTukiYkgtIkouHozon.setSeg1cd(C_Segcd.valueOf(synypTukiTugtTykiyuHozon.getZtykbnkeiriyousegmentcd()));
                        synypTukiYkgtIkouHozon.setZennoujiikkatubaraijytgk(synypTukiTugtTykiyuHozon.getZtyzennoujiikkatubaraijytgk());
                        synypTukiYkgtIkouHozon.setDenrenno(synypTukiTugtTykiyuHozon.getZtysrdenrenno());

                        BizPropertyInitializer.initialize(synypTukiYkgtIkouHozon);
                        synypTukiYkgtIkouHozonEntityInserter.add(synypTukiYkgtIkouHozon);

                        yokugetuTableKns++;
                    }
                }
            }
        }

        if (srRrtHndugtHknJigyohiBatchParam.getZokkouerrsyoriKensuu() != 0 &&
            (SrRrtHndugtHknJigyohiBatchParam.RGKCM000.equals(ibKakutyoujobcd) ||
                SrRrtHndugtHknJigyohiBatchParam.RGKCM004.equals(ibKakutyoujobcd))) {

            throw new BizAppException(MessageId.ISA1001, SUURIYOUERRJYOUHOUNM,
                String.valueOf(srRrtHndugtHknJigyohiBatchParam.getZokkouerrsyoriKensuu()));
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, RRTHNDUGTHKNJIGYOHITYNM,
            String.valueOf(regetuTableKns)));

        if (C_KessanKbn.KESSAN.eq(kessanKbn)) {
            batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, RRTHNDUGTHKNKSNJIGYOHITYNM,
                String.valueOf(kessanTableKns)));
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, SYNYPTUKIYKGTIKOUHOZONNM,
            String.valueOf(yokugetuTableKns)));

        batchLogger.info(MessageUtil.getMessage(MessageId.ISA1001, SUURIYOUERRJYOUHOUNM,
            String.valueOf(srRrtHndugtHknJigyohiBatchParam.getZokkouerrsyoriKensuu())));
    }

    private void insertZtydata(C_KessanKbn pOuttisyKbn, String pSyono, BizDateYM pPjytoym,
        C_TaisyakuKbn pTaisyakuKbn, BizDate pDenymd, String pSyoricd,
        BizDate pSyoriYmd, C_Segcd pSeg1cd, Long pZennoujiikkatubaraijytgk,
        String pDenrenno, TkJitenKeiyakuSyouhinKijyunBean pTkJitenKeiyakuSyouhinKijyunBean,
        List<SV_KiykSyuhnData> pKiykSyuhnDataLst,
        EntityInserter<ZT_RrtHndugtHknJigyohiTy> pRrtHndugtHknJigyohiTyEntityInserter,
        EntityInserter<ZT_RrtHndugtHknKsnJigyohiTy> pRrtHndugtHknKsnJigyohiTyEntityInserter) {

        Boolean errorFlag = false;

        SrRrtHndugtHknJigyohiBatchEdit srRrtHndugtHknJigyohiBatchEdit = SWAKInjector
            .getInstance(SrRrtHndugtHknJigyohiBatchEdit.class);

        BizDate jyuutoutukiLastDay = pPjytoym.getLastDay();
        String syoumetuHyouji = "";

        if (pKiykSyuhnDataLst.get(0).getSyoumetuymd() != null &&
            (BizDateUtil.compareYmd(pKiykSyuhnDataLst.get(0).getSyoumetuymd(), jyuutoutukiLastDay) == BizDateUtil.COMPARE_LESSER ||
            BizDateUtil.compareYmd(pKiykSyuhnDataLst.get(0).getSyoumetuymd(), jyuutoutukiLastDay) == BizDateUtil.COMPARE_EQUAL) &&
            (BizDateUtil.compareYmd(pKiykSyuhnDataLst.get(0).getSyoriYmd(), jyuutoutukiLastDay) == BizDateUtil.COMPARE_LESSER ||
            BizDateUtil.compareYmd(pKiykSyuhnDataLst.get(0).getSyoriYmd(), jyuutoutukiLastDay) == BizDateUtil.COMPARE_EQUAL)) {
            syoumetuHyouji = SrCommonConstants.HYOUJI_ARI;
        }
        else {
            syoumetuHyouji = SrCommonConstants.HYOUJI_NASI;
        }

        SrRrtHndugtHknJigyohiBatchDbAccess srRrtHndugtHknJigyohiBatchDbAccess = SWAKInjector
            .getInstance(SrRrtHndugtHknJigyohiBatchDbAccess.class);

        SV_HoyuuMeisai hHoyuuMeisai = srRrtHndugtHknJigyohiBatchDbAccess.getHoyuuMeisai(pSyono);

        List<IT_HokenryouTmttkn> hokenryouTmttknLst =
            srRrtHndugtHknJigyohiBatchDbAccess.getHokenryouTmttknsBySyonoTmttknkouryokukaisiymdDesc(
                pSyono, BizDateYM.valueOf(SrCommonConstants.YM_ALL9));

        if (C_KessanKbn.TUUJYOU.eq(pOuttisyKbn)) {

            ZT_RrtHndugtHknJigyohiTy rrtHndugtHknJigyohiTy = new ZT_RrtHndugtHknJigyohiTy();

            errorFlag = srRrtHndugtHknJigyohiBatchEdit.editKoumoku(
                srRrtHndugtHknJigyohiBatchParam, pOuttisyKbn, pPjytoym, pTaisyakuKbn,
                pDenymd, pSyoricd, pSyoriYmd, pSeg1cd,
                pZennoujiikkatubaraijytgk, pDenrenno, syoumetuHyouji, pTkJitenKeiyakuSyouhinKijyunBean, pKiykSyuhnDataLst,
                hHoyuuMeisai, hokenryouTmttknLst, rrtHndugtHknJigyohiTy, null);

            if (errorFlag) {
                return;
            }

            BizPropertyInitializer.initialize(rrtHndugtHknJigyohiTy);

            SrRrtHndugtHknJigyohiConverter.convertPadding(rrtHndugtHknJigyohiTy);

            pRrtHndugtHknJigyohiTyEntityInserter.add(rrtHndugtHknJigyohiTy);

            regetuTableKns++;
        }
        else {

            ZT_RrtHndugtHknKsnJigyohiTy rrtHndugtHknKsnJigyohiTy = new ZT_RrtHndugtHknKsnJigyohiTy();

            errorFlag = srRrtHndugtHknJigyohiBatchEdit.editKoumoku(
                srRrtHndugtHknJigyohiBatchParam, pOuttisyKbn, pPjytoym, pTaisyakuKbn,
                pDenymd, pSyoricd, pSyoriYmd, pSeg1cd,
                pZennoujiikkatubaraijytgk, pDenrenno, syoumetuHyouji, pTkJitenKeiyakuSyouhinKijyunBean, pKiykSyuhnDataLst,
                hHoyuuMeisai, hokenryouTmttknLst, null, rrtHndugtHknKsnJigyohiTy);

            if (errorFlag) {
                return;
            }

            BizPropertyInitializer.initialize(rrtHndugtHknKsnJigyohiTy);

            SrRrtHndugtHknJigyohiConverter.convertPadding(rrtHndugtHknKsnJigyohiTy);

            pRrtHndugtHknKsnJigyohiTyEntityInserter.add(rrtHndugtHknKsnJigyohiTy);

            kessanTableKns++;
        }
    }
}
