package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfo;
import yuyu.common.biz.bzcommon.BzGetSosikiMadogutiInfoKekkaBean;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_HassouKbn;
import yuyu.def.classification.C_KykdrtkykttdkKbn;
import yuyu.def.classification.C_KzkTrkServicettdkKbn;
import yuyu.def.classification.C_MousideninKbn;
import yuyu.def.classification.C_StdrsktkyhnkKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TantousituKbn;
import yuyu.def.classification.C_TetudukisyuKbn;
import yuyu.def.classification.C_TrkKzkHnkKbn;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.classification.C_TrkkzkttdkKbn;
import yuyu.def.classification.C_TuutisakuseitaisyouKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_TtdkKan;

import com.google.common.base.Strings;

/**
 * 契約保全 契約保全共通 保全直送用手続完了ＴＢＬ編集
 */
public class EditKhTyokusouTtdkKanryouTbl {

    @Inject
    private static Logger logger;

    private static final String KZKTOUROKU_SAKUSEITAISYOUTUUTIKBN1 = "01";

    private static final String KZKTOUROKU_SAKUSEITAISYOUTUUTIKBN2 = "02";

    private static final String KZKTOUROKU_SAKUSEITAISYOUTUUTIKBN5 = "05";

    private static final String KZKTOUROKU_AISTMSGKBN7 = "07";

    private static final String KZKTOUROKU_AISTMSGKBN8 = "08";

    private static final String KZKTOUROKU_AISTMSGKBN9 = "09";

    private static final String KZKTOUROKU_AISTMSGKBN10 = "10";

    private static final String KZKTOUROKU_AISTMSGKBN11 = "11";

    private static final String KZKTOUROKU_AISTMSGKBN22 = "22";

    private static final String KZKTOUROKU_AISTMSGKBN23 = "23";

    private static final String KZKTOUROKU_AISTMSGKBN27 = "27";

    private static final String KZKTOUROKU_AISTMSGKBN28 = "28";

    private static final String KZKTOUROKU_AISTMSGKBN29 = "29";

    private static final String KZKTOUROKU_AISTMSGKBN30 = "30";

    private static final String KZKTOUROKU_AISTMSGKBN31 = "31";

    private static final String KZKTOUROKU_AISTMSGKBN41 = "41";

    private static final String KZKTOUROKU_AISTMSGKBN42 = "42";

    private static final String KZKTOUROKU_MOSHNKNIYMSGKBN11 = "11";

    private static final String KZKTOUROKU_MOSHNKNIYMSGKBN12 = "12";

    private static final String KZKTOUROKU_MOSHNKNIYMSGKBN13 = "13";

    private static final String KZKTOUROKU_MOSHNKNIYMSGKBN14 = "14";

    private static final String KZKTOUROKU_MOSHNKNIYMSGKBN31 = "31";

    private static final String KZKTOUROKU_HHKDRMSG11 = "11";

    private static final String KZKTOUROKU_DUHUBUTUMSG1 = "01";

    private static final String KZKTOUROKU_DUHUBUTUMSG2 = "02";

    private static final String KZKTOUROKU_DUHUBUTUMSG3 = "03";

    private static final String KZKTOUROKU_HUNYUUHYOUJI1 = "1";

    private static final String KZKTOUROKU_KZKTAISYOUKYKKBN2 = "2";

    public List<IT_TtdkKan> main(KhozenCommonParam pKcp,
        IT_KykKihon pKykKihon,
        List<IT_KykSyouhn> pKykSyouhnLst,
        IT_KykSya pKykSya,
        IT_HhknSya pHhknSya,
        EditTtdkKanryouParam pTtdkKanryouParam,
        IT_KykSonotaTkyk pKykSonotaTkyk,
        BizDate pSyoriymd,
        C_HassouKbn pHassouKbn,
        C_SyoruiCdKbn pSyoruiCd) {

        logger.debug("▽ 保全直送用手続完了ＴＢＬ編集 開始");

        BzGetSosikiMadogutiInfo bzGetSosikiMadogutiInfo = SWAKInjector.getInstance(BzGetSosikiMadogutiInfo.class);
        String callcenterSosikicd = YuyuBizConfig.getInstance().getCallcentersosikicd();
        String hknkaisyanmkj = YuyuBizConfig.getInstance().getHokenKaisyaNmKanji();
        String toiawaseTelUktkKanou1 = YuyuBizConfig.getInstance().getUketimecallcenter1();
        String toiawaseTelUktkKanou2 = YuyuBizConfig.getInstance().getUketimecallcenter2();

        BzGetSosikiMadogutiInfoKekkaBean sosikiCdGetSosikiMadogutiInfoKekkaBean = bzGetSosikiMadogutiInfo.exec(callcenterSosikicd);

        List<IT_TtdkKan> ttdkKanList = new ArrayList<>();
        String henkousikibetuKey = pKcp.getSikibetuKey(pKykKihon.getSyono());

        List<TyokusouTaisyouBean> tyokusouTaisyouBeanList = pTtdkKanryouParam.getTyokusouTaisyouList();

        for (TyokusouTaisyouBean tyokusouTaisyouBean : tyokusouTaisyouBeanList) {


            C_TrkKzkHnkKbn trkKzkHnkNiyuKbn = C_TrkKzkHnkKbn.BLNK;
            C_TrkkzkttdkKbn trkkzkttdkKbn = C_TrkkzkttdkKbn.BLNK;
            C_UktKbn uktKbnTrkkzk = C_UktKbn.BLNK;
            C_TrkKzkKbn trkKzkKbn1 = C_TrkKzkKbn.BLNK;
            String trkkzknmkj1 = "";
            BizDate trkkzkseiymd1 = null;
            String trkkzkyno1 = "";
            String trkkzkadr1kj1 = "";
            String trkkzkadr2kj1 = "";
            String trkkzkadr3kj1 = "";
            String trkkzktelno1 = "";

            if (C_TuutisakuseitaisyouKbn.TRKKZK1.eq(tyokusouTaisyouBean.getTuutiSakuseiTaisyouKbn()) ||
                C_TuutisakuseitaisyouKbn.OLDTRKKZK1.eq(tyokusouTaisyouBean.getTuutiSakuseiTaisyouKbn()) ||
                (C_TuutisakuseitaisyouKbn.OLDKYKDRN.eq(tyokusouTaisyouBean.getTuutiSakuseiTaisyouKbn()) &&
                    C_UktKbn.TOUROKUKAZOKU1.eq(pTtdkKanryouParam.getBfrKykdairinKbn())) ||
                    (C_TuutisakuseitaisyouKbn.OLDHHKNDRNIN.eq(tyokusouTaisyouBean.getTuutiSakuseiTaisyouKbn()) &&
                        C_UktKbn.TOUROKUKAZOKU1.eq(pTtdkKanryouParam.getStdruktkbn()))) {

                trkKzkHnkNiyuKbn = pTtdkKanryouParam.getTrkKzkHnkNiyuKbn1();
                trkkzkttdkKbn = pTtdkKanryouParam.getTrkkzkttdkKbn1();
                uktKbnTrkkzk = C_UktKbn.TOUROKUKAZOKU1;
            }
            else if (C_TuutisakuseitaisyouKbn.TRKKZK2.eq(tyokusouTaisyouBean.getTuutiSakuseiTaisyouKbn()) ||
                C_TuutisakuseitaisyouKbn.OLDTRKKZK2.eq(tyokusouTaisyouBean.getTuutiSakuseiTaisyouKbn()) ||
                (C_TuutisakuseitaisyouKbn.OLDKYKDRN.eq(tyokusouTaisyouBean.getTuutiSakuseiTaisyouKbn()) &&
                    C_UktKbn.TOUROKUKAZOKU2.eq(pTtdkKanryouParam.getBfrKykdairinKbn())) ||
                    (C_TuutisakuseitaisyouKbn.OLDHHKNDRNIN.eq(tyokusouTaisyouBean.getTuutiSakuseiTaisyouKbn()) &&
                        C_UktKbn.TOUROKUKAZOKU2.eq(pTtdkKanryouParam.getStdruktkbn()))) {

                trkKzkHnkNiyuKbn = pTtdkKanryouParam.getTrkKzkHnkNiyuKbn2();
                trkkzkttdkKbn = pTtdkKanryouParam.getTrkkzkttdkKbn2();
                uktKbnTrkkzk = C_UktKbn.TOUROKUKAZOKU2;
            }


            if (C_TuutisakuseitaisyouKbn.TRKKZK1.eq(tyokusouTaisyouBean.getTuutiSakuseiTaisyouKbn()) ||
                C_TuutisakuseitaisyouKbn.TRKKZK2.eq(tyokusouTaisyouBean.getTuutiSakuseiTaisyouKbn())) {

                trkKzkKbn1 = C_TrkKzkKbn.TRKKZK1;
                trkkzknmkj1 = tyokusouTaisyouBean.getNmkj();
                trkkzkseiymd1 = tyokusouTaisyouBean.getSeiYmd();
                trkkzkyno1 = tyokusouTaisyouBean.getYno();
                trkkzkadr1kj1 = tyokusouTaisyouBean.getAdr1kj();
                trkkzkadr2kj1 = tyokusouTaisyouBean.getAdr2kj();
                trkkzkadr3kj1 = tyokusouTaisyouBean.getAdr3kj();
                trkkzktelno1 = tyokusouTaisyouBean.getTelno();
            }

            TuutiKbnBean tuutiKbnBean = getTuutiKbn(
                tyokusouTaisyouBean.getTuutiSakuseiTaisyouKbn(),
                pTtdkKanryouParam.getTetudukiSyu(),
                pTtdkKanryouParam.getMousideninKbn(),
                pTtdkKanryouParam.getTrkKzkServicettdkKbn(),
                trkKzkHnkNiyuKbn,
                pTtdkKanryouParam.getKykdrtkykttdkKbn(),
                pTtdkKanryouParam.getBfrKykdairinKbn(),
                pTtdkKanryouParam.getAftKykdairinKbn(),
                pTtdkKanryouParam.getStdruktkbn(),
                uktKbnTrkkzk,
                trkkzkttdkKbn,
                pTtdkKanryouParam.getStdrsktkyhnkKbn(),
                pTtdkKanryouParam.getKykdairinmkj());

            String kzkaistmsgkbn1 = getAistmsgKbn(
                tyokusouTaisyouBean.getTuutiSakuseiTaisyouKbn(),
                pTtdkKanryouParam.getTetudukiSyu(),
                pTtdkKanryouParam.getMousideninKbn(),
                pTtdkKanryouParam.getTrkKzkServicettdkKbn(),
                trkKzkHnkNiyuKbn,
                pTtdkKanryouParam.getKykdrtkykttdkKbn(),
                pTtdkKanryouParam.getBfrKykdairinKbn(),
                pTtdkKanryouParam.getAftKykdairinKbn(),
                pTtdkKanryouParam.getStdruktkbn(),
                uktKbnTrkkzk,
                trkkzkttdkKbn,
                pTtdkKanryouParam.getStdrsktkyhnkKbn(),
                pTtdkKanryouParam.getKykdairinmkj());

            String kzkmoshnkniymsg21 = getMoshnkniymsgKbn(
                tyokusouTaisyouBean.getTuutiSakuseiTaisyouKbn(),
                pTtdkKanryouParam.getTetudukiSyu(),
                pTtdkKanryouParam.getMousideninKbn(),
                pTtdkKanryouParam.getTrkKzkServicettdkKbn(),
                trkKzkHnkNiyuKbn,
                pTtdkKanryouParam.getKykdrtkykttdkKbn(),
                pTtdkKanryouParam.getAftKykdairinKbn(),
                uktKbnTrkkzk,
                trkkzkttdkKbn,
                pTtdkKanryouParam.getStdrsktkyhnkKbn());

            String kzkhhkdrmsg1 = getHhkdrmsgKbn(
                tyokusouTaisyouBean.getTuutiSakuseiTaisyouKbn(),
                pTtdkKanryouParam.getTetudukiSyu(),
                pTtdkKanryouParam.getStdruktkbn(),
                uktKbnTrkkzk,
                pTtdkKanryouParam.getStdrsknmkj());

            List<String> kykigaidhbtmsgList = getKykigaiDuhubutumsgKbnList(
                tyokusouTaisyouBean.getTuutiSakuseiTaisyouKbn(),
                pTtdkKanryouParam.getTetudukiSyu(),
                trkKzkHnkNiyuKbn,
                pTtdkKanryouParam.getKykdrtkykttdkKbn(),
                pTtdkKanryouParam.getBfrKykdairinKbn(),
                pTtdkKanryouParam.getAftKykdairinKbn(),
                pTtdkKanryouParam.getStdruktkbn(),
                uktKbnTrkkzk,
                pTtdkKanryouParam.getStdrsktkyhnkKbn());

            henkousikibetuKey = incrementHenkouSikibetukey(henkousikibetuKey);

            IT_TtdkKan ttdkKan = pKykKihon.createTtdkKan();

            ttdkKan.setHenkousikibetukey(henkousikibetuKey);
            ttdkKan.setSyoruiCd(pSyoruiCd);
            ttdkKan.setTyouhyouymd(pSyoriymd);
            ttdkKan.setHassoukbn(pHassouKbn);
            ttdkKan.setTantousitukbn(C_TantousituKbn.HOZENHENKOUSV);
            ttdkKan.setShskyno(tyokusouTaisyouBean.getYno());
            ttdkKan.setShsadr1kj(tyokusouTaisyouBean.getAdr1kj());
            ttdkKan.setShsadr2kj(tyokusouTaisyouBean.getAdr2kj());
            ttdkKan.setShsadr3kj(tyokusouTaisyouBean.getAdr3kj());
            ttdkKan.setShsnmkj(tyokusouTaisyouBean.getNmkj());
            ttdkKan.setToiawasesosikinmkj(sosikiCdGetSosikiMadogutiInfoKekkaBean.getKanjisosikinm());
            ttdkKan.setToiawaseyno(sosikiCdGetSosikiMadogutiInfoKekkaBean.getPostalCd());
            ttdkKan.setToiawaseadr1kj(sosikiCdGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr1());
            ttdkKan.setToiawaseadr2kj(sosikiCdGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr2());
            ttdkKan.setToiawaseadr3kj(sosikiCdGetSosikiMadogutiInfoKekkaBean.getKanjisosikiadr3());
            ttdkKan.setToiawasekaisyanmkj(hknkaisyanmkj);
            ttdkKan.setToiawasetelno(sosikiCdGetSosikiMadogutiInfoKekkaBean.getTelno());
            ttdkKan.setToiawaseteluktkkanou1(toiawaseTelUktkKanou1);
            ttdkKan.setToiawaseteluktkkanou2(toiawaseTelUktkKanou2);
            ttdkKan.setShrumu(pTtdkKanryouParam.getSiharaiUmu());
            ttdkKan.setSyorikbn(pTtdkKanryouParam.getSyorikbn());
            ttdkKan.setKyknmkj(pKykSya.getKyknmkj());
            ttdkKan.setKykymd(pKykSyouhnLst.get(0).getKykymd());
            ttdkKan.setSyouhnnm(pKykSyouhnLst.get(0).getSyouhnZokusei().getSyouhnnmsyouken());
            ttdkKan.setHhknnmkj(pHhknSya.getHhknnmkj());
            ttdkKan.setGyoumuKousinKinou(pKcp.getFunctionId());
            ttdkKan.setGyoumuKousinsyaId(pKcp.getUserID());
            ttdkKan.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
            ttdkKan.setDocumentid(pTtdkKanryouParam.getDocumentId());
            ttdkKan.setSksmongonkbn1(pTtdkKanryouParam.getSksmongonKbn1());
            ttdkKan.setSksmongonkbn2(pTtdkKanryouParam.getSksmongonKbn2());
            ttdkKan.setHozonKikan(pTtdkKanryouParam.getHozonKikanY());
            ttdkKan.setTsintelno(pKykSya.getTsintelno());
            ttdkKan.setTrkkzkkbn1(trkKzkKbn1);
            ttdkKan.setTrkkzknmkj1(trkkzknmkj1);
            ttdkKan.setTrkkzkseiymd1(trkkzkseiymd1);
            ttdkKan.setTrkkzkyno1(trkkzkyno1);
            ttdkKan.setTrkkzkadr1kj1(trkkzkadr1kj1);
            ttdkKan.setTrkkzkadr2kj1(trkkzkadr2kj1);
            ttdkKan.setTrkkzkadr3kj1(trkkzkadr3kj1);
            ttdkKan.setTrkkzktelno1(trkkzktelno1);
            ttdkKan.setKzkomttutkbn1(tuutiKbnBean.getOmttutKbn());
            ttdkKan.setKzkurtutkbn1(tuutiKbnBean.getUrtutKbn());
            ttdkKan.setKzkaistmsgkbn1(kzkaistmsgkbn1);
            ttdkKan.setKzktaisyoukykkbn(KZKTOUROKU_KZKTAISYOUKYKKBN2);
            ttdkKan.setKzkmoshnkniymsg21(kzkmoshnkniymsg21);
            ttdkKan.setKzkhhkdrmsg1(kzkhhkdrmsg1);

            if (kykigaidhbtmsgList.size() > 0) {
                ttdkKan.setKykigaidhbtmsg1(kykigaidhbtmsgList.get(0));
            }

            if (kykigaidhbtmsgList.size() > 1) {
                ttdkKan.setKykigaidhbtmsg2(kykigaidhbtmsgList.get(1));
            }

            if (kykigaidhbtmsgList.size() > 2) {
                ttdkKan.setKykigaidhbtmsg3(kykigaidhbtmsgList.get(2));
            }

            if (kykigaidhbtmsgList.contains(KZKTOUROKU_DUHUBUTUMSG1)) {
                ttdkKan.setKzktrktrshuunyuuhyouji1(KZKTOUROKU_HUNYUUHYOUJI1);
            }

            if (kykigaidhbtmsgList.contains(KZKTOUROKU_DUHUBUTUMSG2)) {
                ttdkKan.setKykdrhuunyuuhyouji(KZKTOUROKU_HUNYUUHYOUJI1);
            }

            if (kykigaidhbtmsgList.contains(KZKTOUROKU_DUHUBUTUMSG3)) {
                ttdkKan.setHhkdrhuunyuuhyouji(KZKTOUROKU_HUNYUUHYOUJI1);
            }

            BizPropertyInitializer.initialize(ttdkKan);

            ttdkKanList.add(ttdkKan);
        }

        logger.debug("△ 保全直送用手続完了ＴＢＬ編集 終了");

        return ttdkKanList;
    }

    private TuutiKbnBean getTuutiKbn(
        C_TuutisakuseitaisyouKbn pTuutisakuseitaisyouKbn,
        C_TetudukisyuKbn pTetudukisyuKbn,
        C_MousideninKbn pMousideninKbn,
        C_KzkTrkServicettdkKbn pKzkTrkServicettdkKbn,
        C_TrkKzkHnkKbn pTrkKzkHnkKbn,
        C_KykdrtkykttdkKbn pKykdrtkykttdkKbn,
        C_UktKbn pBfrKykdairinKbn,
        C_UktKbn pAftKykdairinKbn,
        C_UktKbn pStdruktKbn,
        C_UktKbn pUktKbnTrkkzk,
        C_TrkkzkttdkKbn pTrkkzkttdkKbn,
        C_StdrsktkyhnkKbn pStdrsktkyhnkKbn,
        String pKykdairinmkj) {

        String omttutKbn = null;
        String urtutKbn = null;
        TuutiKbnBean tuutiKbnBean = SWAKInjector.getInstance(TuutiKbnBean.class);

        if (C_TetudukisyuKbn.KZKTRKKYKDRHNK.eq(pTetudukisyuKbn)) {

            if (C_MousideninKbn.KYKHONNIN.eq(pMousideninKbn)) {

                if (C_KzkTrkServicettdkKbn.TOUROKU.eq(pKzkTrkServicettdkKbn) ||
                    C_KzkTrkServicettdkKbn.HENKOU.eq(pKzkTrkServicettdkKbn)) {

                    if (C_TrkKzkHnkKbn.TOUROKU.eq(pTrkKzkHnkKbn)) {

                        if (C_TuutisakuseitaisyouKbn.OLDKYKDRN.eq(pTuutisakuseitaisyouKbn)) {

                            omttutKbn = KZKTOUROKU_SAKUSEITAISYOUTUUTIKBN1;
                        }
                        else {

                            omttutKbn = KZKTOUROKU_SAKUSEITAISYOUTUUTIKBN5;
                            urtutKbn = KZKTOUROKU_SAKUSEITAISYOUTUUTIKBN1;
                        }
                    }
                    else if (C_TrkKzkHnkKbn.HENKOU.eq(pTrkKzkHnkKbn)) {

                        if (C_KykdrtkykttdkKbn.TYUUTOHUKA.eq(pKykdrtkykttdkKbn) ||
                            C_KykdrtkykttdkKbn.HENKOU.eq(pKykdrtkykttdkKbn)) {

                            if (pAftKykdairinKbn.eq(pUktKbnTrkkzk)) {

                                omttutKbn = KZKTOUROKU_SAKUSEITAISYOUTUUTIKBN5;
                                urtutKbn = KZKTOUROKU_SAKUSEITAISYOUTUUTIKBN1;
                            }
                        }
                        else if (C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU.eq(pKykdrtkykttdkKbn)) {

                            if (pBfrKykdairinKbn.eq(pUktKbnTrkkzk)) {

                                omttutKbn = KZKTOUROKU_SAKUSEITAISYOUTUUTIKBN1;
                            }
                        }
                    }
                    else if (C_TrkKzkHnkKbn.SAKUJYO.eq(pTrkKzkHnkKbn)) {
                        if (pStdruktKbn.eq(pUktKbnTrkkzk) ||
                            pBfrKykdairinKbn.eq(pUktKbnTrkkzk)) {

                            omttutKbn = KZKTOUROKU_SAKUSEITAISYOUTUUTIKBN1;
                        }
                    }
                    else if (C_TrkKzkHnkKbn.BLNK.eq(pTrkKzkHnkKbn)) {

                        if (C_KykdrtkykttdkKbn.TYUUTOHUKA.eq(pKykdrtkykttdkKbn)) {

                            if (pAftKykdairinKbn.eq(pUktKbnTrkkzk)) {

                                omttutKbn = KZKTOUROKU_SAKUSEITAISYOUTUUTIKBN5;
                                urtutKbn = KZKTOUROKU_SAKUSEITAISYOUTUUTIKBN1;
                            }
                        }
                        else if (C_KykdrtkykttdkKbn.HENKOU.eq(pKykdrtkykttdkKbn)) {

                            if (pAftKykdairinKbn.eq(pUktKbnTrkkzk)) {

                                if (!BizUtil.isBlank(pKykdairinmkj)) {

                                    omttutKbn = KZKTOUROKU_SAKUSEITAISYOUTUUTIKBN5;
                                    urtutKbn = KZKTOUROKU_SAKUSEITAISYOUTUUTIKBN1;
                                }
                            }
                        }
                        else if (C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU.eq(pKykdrtkykttdkKbn)) {

                            if (pBfrKykdairinKbn.eq(pUktKbnTrkkzk)) {

                                omttutKbn = KZKTOUROKU_SAKUSEITAISYOUTUUTIKBN1;
                            }
                        }
                    }
                }

                if (C_KzkTrkServicettdkKbn.SYUURYOU.eq(pKzkTrkServicettdkKbn)) {

                    if (C_TrkkzkttdkKbn.SAKUJYO.eq(pTrkkzkttdkKbn)) {

                        omttutKbn = KZKTOUROKU_SAKUSEITAISYOUTUUTIKBN1;
                    }
                }

                if (C_KzkTrkServicettdkKbn.BLNK.eq(pKzkTrkServicettdkKbn)) {

                    if (C_KykdrtkykttdkKbn.TYUUTOHUKA.eq(pKykdrtkykttdkKbn)) {

                        if (pAftKykdairinKbn.eq(pUktKbnTrkkzk)) {

                            omttutKbn = KZKTOUROKU_SAKUSEITAISYOUTUUTIKBN5;
                            urtutKbn = KZKTOUROKU_SAKUSEITAISYOUTUUTIKBN1;
                        }
                    }
                    else if (C_KykdrtkykttdkKbn.HENKOU.eq(pKykdrtkykttdkKbn)) {

                        if (pAftKykdairinKbn.eq(pUktKbnTrkkzk)) {

                            if (!BizUtil.isBlank(pKykdairinmkj)) {

                                omttutKbn = KZKTOUROKU_SAKUSEITAISYOUTUUTIKBN5;
                                urtutKbn = KZKTOUROKU_SAKUSEITAISYOUTUUTIKBN1;
                            }
                        }
                    }
                    else if (C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU.eq(pKykdrtkykttdkKbn)) {

                        if (pBfrKykdairinKbn.eq(pUktKbnTrkkzk)) {

                            omttutKbn = KZKTOUROKU_SAKUSEITAISYOUTUUTIKBN1;
                        }
                    }
                }
            }
            else if (C_MousideninKbn.TRKKZK1.eq(pMousideninKbn) ||
                C_MousideninKbn.TRKKZK2.eq(pMousideninKbn)) {

                if (C_TrkkzkttdkKbn.HENKOU.eq(pTrkkzkttdkKbn)) {

                    omttutKbn = KZKTOUROKU_SAKUSEITAISYOUTUUTIKBN2;
                }
                else if (C_TrkkzkttdkKbn.SAKUJYO.eq(pTrkkzkttdkKbn)) {

                    omttutKbn = KZKTOUROKU_SAKUSEITAISYOUTUUTIKBN1;
                }
            }
        }
        else if (C_TetudukisyuKbn.MEIGIHNK.eq(pTetudukisyuKbn)) {

            if (C_StdrsktkyhnkKbn.HENKOU.eq(pStdrsktkyhnkKbn)) {

                omttutKbn = KZKTOUROKU_SAKUSEITAISYOUTUUTIKBN5;
                urtutKbn = KZKTOUROKU_SAKUSEITAISYOUTUUTIKBN1;
            }
            else if (C_StdrsktkyhnkKbn.KAIJYO.eq(pStdrsktkyhnkKbn)) {

                omttutKbn = KZKTOUROKU_SAKUSEITAISYOUTUUTIKBN1;
            }
        }

        tuutiKbnBean.setOmttutKbn(omttutKbn);
        tuutiKbnBean.setUrtutKbn(urtutKbn);

        return tuutiKbnBean;
    }

    private String getAistmsgKbn(
        C_TuutisakuseitaisyouKbn pTuutisakuseitaisyouKbn,
        C_TetudukisyuKbn pTetudukisyuKbn,
        C_MousideninKbn pMousideninKbn,
        C_KzkTrkServicettdkKbn pKzkTrkServicettdkKbn,
        C_TrkKzkHnkKbn pTrkKzkHnkKbn,
        C_KykdrtkykttdkKbn pKykdrtkykttdkKbn,
        C_UktKbn pBfrKykdairinKbn,
        C_UktKbn pAftKykdairinKbn,
        C_UktKbn pStdruktKbn,
        C_UktKbn pUktKbnTrkkzk,
        C_TrkkzkttdkKbn pTrkkzkttdkKbn,
        C_StdrsktkyhnkKbn pStdrsktkyhnkKbn,
        String pKykdairinmkj) {

        String aistmsgKbn = null;

        if (C_TetudukisyuKbn.KZKTRKKYKDRHNK.eq(pTetudukisyuKbn)) {

            if (C_MousideninKbn.KYKHONNIN.eq(pMousideninKbn)) {

                if (C_KzkTrkServicettdkKbn.TOUROKU.eq(pKzkTrkServicettdkKbn) ||
                    C_KzkTrkServicettdkKbn.HENKOU.eq(pKzkTrkServicettdkKbn)) {

                    if (C_TrkKzkHnkKbn.TOUROKU.eq(pTrkKzkHnkKbn)) {

                        if (C_KykdrtkykttdkKbn.TYUUTOHUKA.eq(pKykdrtkykttdkKbn) ||
                            C_KykdrtkykttdkKbn.HENKOU.eq(pKykdrtkykttdkKbn)) {

                            if (pAftKykdairinKbn.eq(pUktKbnTrkkzk)) {

                                aistmsgKbn = KZKTOUROKU_AISTMSGKBN7;
                            }
                            else {

                                aistmsgKbn = KZKTOUROKU_AISTMSGKBN8;
                            }
                        }
                        else if (C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU.eq(pKykdrtkykttdkKbn)) {

                            if (C_TuutisakuseitaisyouKbn.OLDKYKDRN.eq(pTuutisakuseitaisyouKbn)) {

                                aistmsgKbn = KZKTOUROKU_AISTMSGKBN29;
                            }
                            else {

                                aistmsgKbn = KZKTOUROKU_AISTMSGKBN8;
                            }
                        }
                        else {

                            if (pBfrKykdairinKbn.eq(pUktKbnTrkkzk)) {
                                aistmsgKbn = KZKTOUROKU_AISTMSGKBN7;
                            }
                            else {
                                aistmsgKbn = KZKTOUROKU_AISTMSGKBN8;
                            }
                        }
                    }
                    else {

                        if (C_TrkKzkHnkKbn.SAKUJYO.eq(pTrkKzkHnkKbn) &&
                            pStdruktKbn.eq(pUktKbnTrkkzk)) {

                            if (pBfrKykdairinKbn.eq(pUktKbnTrkkzk)) {

                                aistmsgKbn = KZKTOUROKU_AISTMSGKBN31;
                            }
                            else {

                                aistmsgKbn = KZKTOUROKU_AISTMSGKBN30;
                            }
                        }
                        else {
                            if (C_KykdrtkykttdkKbn.TYUUTOHUKA.eq(pKykdrtkykttdkKbn) ||
                                C_KykdrtkykttdkKbn.HENKOU.eq(pKykdrtkykttdkKbn)) {

                                if (pAftKykdairinKbn.eq(pUktKbnTrkkzk)) {

                                    aistmsgKbn = KZKTOUROKU_AISTMSGKBN9;
                                }
                            }
                            if (C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU.eq(pKykdrtkykttdkKbn)) {

                                if (pBfrKykdairinKbn.eq(pUktKbnTrkkzk)) {

                                    aistmsgKbn = KZKTOUROKU_AISTMSGKBN29;
                                }
                            }
                        }
                    }
                }

                if (C_KzkTrkServicettdkKbn.SYUURYOU.eq(pKzkTrkServicettdkKbn)) {

                    if (C_TrkKzkHnkKbn.SAKUJYO.eq(pTrkKzkHnkKbn)) {

                        if (pStdruktKbn.eq(pUktKbnTrkkzk)) {

                            if (pBfrKykdairinKbn.eq(pUktKbnTrkkzk)) {

                                aistmsgKbn = KZKTOUROKU_AISTMSGKBN28;
                            }
                            else {

                                aistmsgKbn = KZKTOUROKU_AISTMSGKBN27;
                            }
                        }
                        else {

                            if (pBfrKykdairinKbn.eq(pUktKbnTrkkzk)) {

                                aistmsgKbn = KZKTOUROKU_AISTMSGKBN22;
                            }
                            else {

                                aistmsgKbn = KZKTOUROKU_AISTMSGKBN23;
                            }
                        }
                    }
                }

                if (C_KzkTrkServicettdkKbn.BLNK.eq(pKzkTrkServicettdkKbn)) {

                    if (C_KykdrtkykttdkKbn.TYUUTOHUKA.eq(pKykdrtkykttdkKbn) ||
                        C_KykdrtkykttdkKbn.HENKOU.eq(pKykdrtkykttdkKbn)) {

                        if (pAftKykdairinKbn.eq(pUktKbnTrkkzk)) {

                            if (!BizUtil.isBlank(pKykdairinmkj)) {

                                aistmsgKbn = KZKTOUROKU_AISTMSGKBN9;
                            }
                        }
                    }
                    else if (C_KykdrtkykttdkKbn.TOKUYAKUKAIYAKU.eq(pKykdrtkykttdkKbn)) {

                        if (pBfrKykdairinKbn.eq(pUktKbnTrkkzk)) {

                            aistmsgKbn = KZKTOUROKU_AISTMSGKBN29;
                        }
                    }
                }
            }
            else if (C_MousideninKbn.TRKKZK1.eq(pMousideninKbn) ||
                C_MousideninKbn.TRKKZK2.eq(pMousideninKbn)) {

                if (C_TrkkzkttdkKbn.HENKOU.eq(pTrkkzkttdkKbn)) {

                    aistmsgKbn = KZKTOUROKU_AISTMSGKBN10;
                }
                else if (C_TrkkzkttdkKbn.SAKUJYO.eq(pTrkkzkttdkKbn)) {

                    aistmsgKbn = KZKTOUROKU_AISTMSGKBN11;
                }
            }
        }
        else if (C_TetudukisyuKbn.MEIGIHNK.eq(pTetudukisyuKbn)) {

            if (C_StdrsktkyhnkKbn.HENKOU.eq(pStdrsktkyhnkKbn)) {

                aistmsgKbn = KZKTOUROKU_AISTMSGKBN41;
            }
            else if (C_StdrsktkyhnkKbn.KAIJYO.eq(pStdrsktkyhnkKbn)) {

                aistmsgKbn = KZKTOUROKU_AISTMSGKBN42;
            }
        }

        return aistmsgKbn;
    }

    private String getMoshnkniymsgKbn(
        C_TuutisakuseitaisyouKbn pTuutisakuseitaisyouKbn,
        C_TetudukisyuKbn pTetudukisyuKbn,
        C_MousideninKbn pMousideninKbn,
        C_KzkTrkServicettdkKbn pKzkTrkServicettdkKbn,
        C_TrkKzkHnkKbn pTrkKzkHnkKbn,
        C_KykdrtkykttdkKbn pKykdrtkykttdkKbn,
        C_UktKbn pAftKykdairinKbn,
        C_UktKbn pUktKbnTrkkzk,
        C_TrkkzkttdkKbn pTrkkzkttdkKbn,
        C_StdrsktkyhnkKbn pStdrsktkyhnkKbn) {

        String moshnkniymsgKbn = null;

        if (C_TetudukisyuKbn.KZKTRKKYKDRHNK.eq(pTetudukisyuKbn)) {

            if (C_TuutisakuseitaisyouKbn.TRKKZK1.eq(pTuutisakuseitaisyouKbn) ||
                C_TuutisakuseitaisyouKbn.TRKKZK2.eq(pTuutisakuseitaisyouKbn)) {

                if (C_MousideninKbn.KYKHONNIN.eq(pMousideninKbn)) {

                    if (C_KzkTrkServicettdkKbn.TOUROKU.eq(pKzkTrkServicettdkKbn) ||
                        C_KzkTrkServicettdkKbn.HENKOU.eq(pKzkTrkServicettdkKbn)) {

                        if (C_TrkKzkHnkKbn.TOUROKU.eq(pTrkKzkHnkKbn)) {

                            if (pAftKykdairinKbn.eq(pUktKbnTrkkzk)) {

                                moshnkniymsgKbn = KZKTOUROKU_MOSHNKNIYMSGKBN11;
                            }
                            else {

                                moshnkniymsgKbn = KZKTOUROKU_MOSHNKNIYMSGKBN12;
                            }
                        }
                        else {

                            if (C_KykdrtkykttdkKbn.TYUUTOHUKA.eq(pKykdrtkykttdkKbn) ||
                                C_KykdrtkykttdkKbn.HENKOU.eq(pKykdrtkykttdkKbn)) {

                                if (pAftKykdairinKbn.eq(pUktKbnTrkkzk)) {

                                    moshnkniymsgKbn = KZKTOUROKU_MOSHNKNIYMSGKBN13;
                                }

                            }
                        }
                    }

                    if (C_KzkTrkServicettdkKbn.BLNK.eq(pKzkTrkServicettdkKbn)) {

                        if (C_KykdrtkykttdkKbn.TYUUTOHUKA.eq(pKykdrtkykttdkKbn) ||
                            C_KykdrtkykttdkKbn.HENKOU.eq(pKykdrtkykttdkKbn)) {

                            if (pAftKykdairinKbn.eq(pUktKbnTrkkzk)) {

                                moshnkniymsgKbn = KZKTOUROKU_MOSHNKNIYMSGKBN13;
                            }
                        }
                    }
                }
                else if (C_MousideninKbn.TRKKZK1.eq(pMousideninKbn) ||
                    C_MousideninKbn.TRKKZK2.eq(pMousideninKbn)) {

                    if (C_TrkkzkttdkKbn.HENKOU.eq(pTrkkzkttdkKbn)) {

                        moshnkniymsgKbn = KZKTOUROKU_MOSHNKNIYMSGKBN14;
                    }
                }
            }
        }
        else if (C_TetudukisyuKbn.MEIGIHNK.eq(pTetudukisyuKbn)) {

            if (C_StdrsktkyhnkKbn.HENKOU.eq(pStdrsktkyhnkKbn)) {

                moshnkniymsgKbn = KZKTOUROKU_MOSHNKNIYMSGKBN31;
            }
        }

        return moshnkniymsgKbn;
    }

    private String getHhkdrmsgKbn(
        C_TuutisakuseitaisyouKbn pTuutisakuseitaisyouKbn,
        C_TetudukisyuKbn pTetudukisyuKbn,
        C_UktKbn pStdruktKbn,
        C_UktKbn pUktKbnTrkkzk,
        String pStdrskNmKj) {

        String hhkdrmsgKbn = null;

        if (C_TetudukisyuKbn.KZKTRKKYKDRHNK.eq(pTetudukisyuKbn)) {

            if (C_TuutisakuseitaisyouKbn.TRKKZK1.eq(pTuutisakuseitaisyouKbn) ||
                C_TuutisakuseitaisyouKbn.TRKKZK2.eq(pTuutisakuseitaisyouKbn)) {

                if (pStdruktKbn.eq(pUktKbnTrkkzk)) {

                    if (!BizUtil.isBlank(pStdrskNmKj)) {

                        hhkdrmsgKbn = KZKTOUROKU_HHKDRMSG11;
                    }
                }
            }
        }
        return hhkdrmsgKbn;
    }

    private List<String> getKykigaiDuhubutumsgKbnList(
        C_TuutisakuseitaisyouKbn pTuutisakuseitaisyouKbn,
        C_TetudukisyuKbn pTetudukisyuKbn,
        C_TrkKzkHnkKbn pTrkKzkHnkKbn,
        C_KykdrtkykttdkKbn pKykdrtkykttdkKbn,
        C_UktKbn pBfrKykdairinKbn,
        C_UktKbn pAftKykdairinKbn,
        C_UktKbn pStdruktKbn,
        C_UktKbn pUktKbnTrkkzk,
        C_StdrsktkyhnkKbn pStdrsktkyhnkKbn) {

        List<String> kykigaidhbtmsgList = new ArrayList<>();

        if (C_TetudukisyuKbn.KZKTRKKYKDRHNK.eq(pTetudukisyuKbn)) {

            if (C_TuutisakuseitaisyouKbn.TRKKZK1.eq(pTuutisakuseitaisyouKbn) ||
                C_TuutisakuseitaisyouKbn.TRKKZK2.eq(pTuutisakuseitaisyouKbn)) {

                if (C_TrkKzkHnkKbn.TOUROKU.eq(pTrkKzkHnkKbn)) {

                    kykigaidhbtmsgList.add(KZKTOUROKU_DUHUBUTUMSG1);
                }

                if (C_KykdrtkykttdkKbn.TYUUTOHUKA.eq(pKykdrtkykttdkKbn) ||
                    C_KykdrtkykttdkKbn.HENKOU.eq(pKykdrtkykttdkKbn)) {

                    if (pAftKykdairinKbn.eq(pUktKbnTrkkzk)) {

                        kykigaidhbtmsgList.add(KZKTOUROKU_DUHUBUTUMSG2);
                    }
                }
                else if (C_KykdrtkykttdkKbn.BLNK.eq(pKykdrtkykttdkKbn)) {

                    if (C_TrkKzkHnkKbn.TOUROKU.eq(pTrkKzkHnkKbn)) {

                        if (pBfrKykdairinKbn.eq(pUktKbnTrkkzk)) {

                            kykigaidhbtmsgList.add(KZKTOUROKU_DUHUBUTUMSG2);
                        }
                    }
                }

                if (C_TrkKzkHnkKbn.TOUROKU.eq(pTrkKzkHnkKbn)) {

                    if (pStdruktKbn.eq(pUktKbnTrkkzk)) {

                        kykigaidhbtmsgList.add(KZKTOUROKU_DUHUBUTUMSG3);
                    }
                }
            }
        }
        else if (C_TetudukisyuKbn.MEIGIHNK.eq(pTetudukisyuKbn)) {

            if (C_StdrsktkyhnkKbn.HENKOU.eq(pStdrsktkyhnkKbn)) {

                kykigaidhbtmsgList.add(KZKTOUROKU_DUHUBUTUMSG3);
            }
        }

        return kykigaidhbtmsgList;
    }

    private String incrementHenkouSikibetukey(String pHenkousikibetuKey) {

        long henkousikibetuKeyKsy = Long.valueOf(pHenkousikibetuKey);
        henkousikibetuKeyKsy = henkousikibetuKeyKsy + 1;
        String incrementAfHenkouSikibetukey = String.valueOf(henkousikibetuKeyKsy);

        incrementAfHenkouSikibetukey = Strings.padStart(incrementAfHenkouSikibetukey, 18, '0');

        return incrementAfHenkouSikibetukey;
    }
}
