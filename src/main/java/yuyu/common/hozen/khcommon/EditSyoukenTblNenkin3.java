package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_DirectServiceMosKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_Nenkinsyu;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_TmttknhaibunjyoutaiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TykzentykgoKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SisuuKihon;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_HokenSyouken;
import yuyu.def.db.entity.IT_HokenSyoukenHukaInfo;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.result.bean.SisurendoTmttknInfoBean;

/**
 * 契約保全 契約保全共通 保険証券TBL編集（年金３）
 */
public class EditSyoukenTblNenkin3 {

    private static final int SINKEIYAKUHOKENSYOUKEN = 1;

    private static final int SONOTANAIYOULSTMAXCNT = 20;

    private static final int SYOUHNHUTAIMSGCDLSTMAXCNT = 2;

    private static final int WTYUUIJIKOUMSGCDMAXCNT = 7;

    private static final int HUTANHIYUSTMMSGCDUEMAXCNT = 4;

    private static final double HUTANHIYUSTMYTIJIHIRITU = 1.0;

    private static final BizNumber KAIYAKUKOUJYORITU_0001 = BizNumber.valueOf(0.001);

    private static final BizNumber KAIYAKUKOUJYORITU_0002 = BizNumber.valueOf(0.002);

    private static final BizNumber KAIYAKUKOUJYORITU_0004 = BizNumber.valueOf(0.004);

    private static final BizNumber KAIYAKUKOUJYORITU_0005 = BizNumber.valueOf(0.005);

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private static Logger logger;

    public EditSyoukenTblNenkin3() {
        super();
    }

    public void editTBL(
        IT_HokenSyouken pHokenSyouken,
        IT_KykKihon pKykKihon,
        EditHokenSyoukenParam pEditHokenSyoukenParam,
        List<IT_NyknJissekiRireki> pNyknJissekiRirekiLst,
        IT_KykSya pKykSya,
        List<IT_KykSyouhn> pSyuKykSyouhnLst,
        IT_KykSonotaTkyk pKykSonotaTkyk,
        List<IT_KykUkt> pSibouhokenLst,
        IT_KykUkt pSiteiDairi,
        int pSksyoukenskskbn,
        C_UmuKbn pGengakuExistsCheck,
        C_KjkhukaKbn pSbUktNmKjHukaKbn,
        C_SyoriKbn pYendthnkSyoriKbn) {

        logger.debug("▽ 保険証券TBL編集（年金３） 開始");

        BizNumber kykjisisuurendourate = pSyuKykSyouhnLst.get(0).getKykjisisuurendourate();

        C_Tuukasyu kyktuukasyu = pSyuKykSyouhnLst.get(0).getKyktuukasyu();

        C_TmttknhaibunjyoutaiKbn tmttknhaibunjyoutaiKbn = pSyuKykSyouhnLst.get(0).getTmttknhaibunjyoutai();

        BizDate yendthnkymd = pSyuKykSyouhnLst.get(0).getYendthnkymd();

        C_UmuKbn kzkTirasidouhuukbn1 = pHokenSyouken.getHokenSyoukenHukaInfo().getKzktirasidouhuukbn1();

        C_UmuKbn kzkTirasidouhuukbn2 = pHokenSyouken.getHokenSyoukenHukaInfo().getKzktirasidouhuukbn2();

        BM_SyouhnZokusei syouhnZokusei = pSyuKykSyouhnLst.get(0).getSyouhnZokusei();

        C_UmuKbn kykDrtkykhukaumu = pKykSonotaTkyk.getKykdrtkykhukaumu();

        C_UmuKbn teikishrtkykhukaumu = pKykSonotaTkyk.getTeikishrtkykhukaumu();

        C_UmuKbn yennykntkhkumu = pKykSonotaTkyk.getYennykntkhkumu();

        C_UmuKbn gaikanykntkhkumu = pKykSonotaTkyk.getGaikanykntkhkumu();

        C_UmuKbn stdrsktkyhkumu = pKykSonotaTkyk.getStdrsktkyhkumu();

        C_UmuKbn targettkhkumu = pKykSonotaTkyk.getTargettkhkumu();

        Integer targettkmokuhyouti = pKykSonotaTkyk.getTargettkmokuhyouti();

        List<IT_KykUkt> nenkinUketorininLst = pKykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.NKUKT);

        IT_KykUkt nenkinUketorinin = null;

        if (nenkinUketorininLst.size() > 0) {

            nenkinUketorinin = nenkinUketorininLst.get(0);
        }

        BM_SisuuKihon sisuuKihon = bizDomManager.getSisuuKihon(pSyuKykSyouhnLst.get(0).getSisuukbn());

        String sisuunm = "";

        if (sisuuKihon != null) {

            sisuunm = sisuuKihon.getSisuunm();
        }

        SisurendoTmttknInfoBean sisurendoTmttknInfoBean = hozenDomManager.getSisurendoTmttknInfoBean(
            pKykKihon.getSyono(), pEditHokenSyoukenParam.getCalckijyunYMD());

        KeisanSisuuRendouNkKykTmttkn keisanSisuuRendouNkKykTmttkn = SWAKInjector
            .getInstance(KeisanSisuuRendouNkKykTmttkn.class);

        keisanSisuuRendouNkKykTmttkn.exec(kyktuukasyu, pSyuKykSyouhnLst.get(0).getHokenryou(), kykjisisuurendourate);

        BizCurrency teirituTmttkngk = keisanSisuuRendouNkKykTmttkn.getTeiritutmttkngk();

        BizCurrency sisuurendouTmttkngk = keisanSisuuRendouNkKykTmttkn.getSisuurendoutmttkngk();

        BizCurrency kijyungaku = null;

        C_Tkhukaumu yennykntkhkKbn = C_Tkhukaumu.BLNK;

        if (C_UmuKbn.NONE.eq(pGengakuExistsCheck)) {

            if (C_UmuKbn.ARI.eq(pKykSonotaTkyk.getYennykntkhkumu())) {

                yennykntkhkKbn = C_Tkhukaumu.HUKA;
            }
            else {
                yennykntkhkKbn = C_Tkhukaumu.NONE;
            }

            if (!C_Tuukasyu.JPY.eq(kyktuukasyu)) {

                KeisanKijyungk keisanKijyungk = SWAKInjector.getInstance(KeisanKijyungk.class);

                C_ErrorKbn result = keisanKijyungk.exec(
                    pKykKihon.getFstpnyknymd(),
                    pNyknJissekiRirekiLst.get(0).getRsgaku(),
                    pKykKihon.getHrkp(),
                    kyktuukasyu,
                    yennykntkhkKbn
                    );

                if (C_ErrorKbn.ERROR.eq(result)) {
                    throw new CommonBizAppException("基準金額が取得できませんでした。");
                }

                kijyungaku = keisanKijyungk.getKijyungk();
            }
        }
        else {

            if (C_UmuKbn.ARI.eq(targettkhkumu)) {
                kijyungaku = pKykSonotaTkyk.getTargettkykkijyungk();
            }
        }

        int keikanensuu = 0;

        SetOutoubi setOutoubi = SWAKInjector.getInstance(SetOutoubi.class);

        BizDate calcKijyunYmd = setOutoubi.exec(
            C_TykzentykgoKbn.TYKGO,
            pSyuKykSyouhnLst.get(0).getKykymd(),
            C_Hrkkaisuu.NEN,
            pEditHokenSyoukenParam.getCalckijyunYMD()
            );

        if (pSksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {
            keikanensuu = 1;
        }
        else {
            keikanensuu = BizDateUtil.calcDifference(calcKijyunYmd, pSyuKykSyouhnLst.get(0).getKykymd()).getYears();
        }

        //        KeisanTeikishrkin keisanTeikishrkin = SWAKInjector.getInstance(KeisanTeikishrkin.class);
        //        BizCurrency teikishrkin = null;
        //
        //        C_ErrorKbn kekkaKbn = keisanTeikishrkin.exec(pSyuKykSyouhnLst.get(0).getHokenryou(),
        //            pSyuKykSyouhnLst.get(0).getTeikishrritu());
        //
        //        if (C_ErrorKbn.OK.eq(kekkaKbn)) {
        //
        //            teikishrkin = keisanTeikishrkin.getTeikishrkin();
        //        }

        List<String> hyoujiranleftmsgcdLst = new ArrayList<>();

        List<String> hyoujiranrightmsgcdLst = new ArrayList<>();

        BizNumber tumitateriritu = BizNumber.ZERO;

        BizNumber hyoujiransjkkktusirrt = null;

        hyoujiranleftmsgcdLst.add("02010");

        if (yendthnkymd == null) {

            if (C_UmuKbn.ARI.eq(teikishrtkykhukaumu)) {
                //                hyoujiranleftmsgcdLst.add("02028");
            }
            else {
                hyoujiranleftmsgcdLst.add("02025");
            }

            if (C_TmttknhaibunjyoutaiKbn.SISUU_ONLY.eq(tmttknhaibunjyoutaiKbn)) {

                hyoujiranleftmsgcdLst.add("02027");
            }

            if (C_UmuKbn.NONE.eq(teikishrtkykhukaumu)) {

                hyoujiranleftmsgcdLst.add("02029");
            }
        }

        BizDate sknnkaisiymd = pSyuKykSyouhnLst.get(0).getSknnkaisiymd();

        if (pSksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {

            hyoujiranleftmsgcdLst.add("02490");

            if (C_TmttknhaibunjyoutaiKbn.SISUU_ONLY.eq(tmttknhaibunjyoutaiKbn)) {

                hyoujiranrightmsgcdLst.add("02041");
            }
            else {

                hyoujiranrightmsgcdLst.add("02061");
            }

            hyoujiranrightmsgcdLst.add("02520");
        }
        else {

            hyoujiranleftmsgcdLst.add("02031");

            tumitateriritu = pSyuKykSyouhnLst.get(0).getTumitateriritu();

            if (yendthnkymd == null) {

                if (C_TmttknhaibunjyoutaiKbn.SISUU_ONLY.eq(tmttknhaibunjyoutaiKbn)) {

                    hyoujiranleftmsgcdLst.add("02071");
                }
                else {

                    hyoujiranleftmsgcdLst.add("02073");
                }

                hyoujiranleftmsgcdLst.add("02062");

                hyoujiransjkkktusirrt = pSyuKykSyouhnLst.get(0).getKyksjkkktyouseiriritu();
            }
        }

        BizCurrency hokenryou = null;

        C_Tuukasyu ptuukasyu = C_Tuukasyu.BLNK;

        String ptuukasyuNm = "";

        String pmsgcd1 = "";

        String pmsgcd2 = "";

        String ptokuyakumsgcd = "";

        if (pSksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {

            pmsgcd1 = "05012";

            hokenryou = pSyuKykSyouhnLst.get(0).getHokenryou();

            ptuukasyu = kyktuukasyu;

            if (C_UmuKbn.ARI.eq(yennykntkhkumu)) {

                ptokuyakumsgcd = "05021";
            }

            if (C_UmuKbn.ARI.eq(gaikanykntkhkumu)) {

                ptokuyakumsgcd = "05030";

                ptuukasyuNm = pNyknJissekiRirekiLst.get(0).getRstuukasyu().getContent();
            }
        }
        else {

            if (yendthnkymd == null) {

                if (C_UmuKbn.ARI.eq(pGengakuExistsCheck)) {

                    pmsgcd1 = "05012";

                    pmsgcd2 = "05022";
                }
                else {
                    pmsgcd1 = "05013";
                }

                hokenryou = pNyknJissekiRirekiLst.get(0).getHrkp();

                ptuukasyu = kyktuukasyu;

                if (C_UmuKbn.ARI.eq(yennykntkhkumu)) {

                    ptokuyakumsgcd = "05041";
                }

                if (C_UmuKbn.ARI.eq(gaikanykntkhkumu)) {

                    ptokuyakumsgcd = "05051";

                    ptuukasyuNm = pNyknJissekiRirekiLst.get(0).getRstuukasyu().getContent();
                }
            }
        }

        String syukyktkykmsgkbn1 = "";

        String syukyktkykhknkknmsgkbn1 = "";

        String syukyktkyksmsgkbn1 = "";

        BizCurrency syukyktkykhknkngk1 = null;

        C_Tuukasyu syukyktkykstuukatype1 = C_Tuukasyu.BLNK;

        if (pSksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {

            syukyktkykmsgkbn1 = "04";

            syukyktkyksmsgkbn1 = "06";

            syukyktkykhknkknmsgkbn1 = "04";

            syukyktkykstuukatype1 = kyktuukasyu;

            syukyktkykhknkngk1 = pSyuKykSyouhnLst.get(0).getKihons();
        }
        else {

            syukyktkykmsgkbn1 = "05";

            syukyktkykhknkknmsgkbn1 = "05";

            syukyktkykstuukatype1 = kyktuukasyu;

            syukyktkykhknkngk1 = pSyuKykSyouhnLst.get(0).getKihons();

            syukyktkyksmsgkbn1 = "08";
        }

        BizCurrency sonotanyransisuutmttkngk = null;

        BizNumber sonotanyrannenkinkkn = null;

        BizCurrency sonotanyranteiritutmttkngk = null;

        String sonotanyransisuunm = "";

        BizNumber sonotanyransetteibairitu = null;

        List<String> stNaiyouranMsgCdList = new ArrayList<>();

        C_Nenkinsyu nksyukbn = pSyuKykSyouhnLst.get(0).getNksyukbn();

        BizDate nkshrstartymd = pSyuKykSyouhnLst.get(0).getHknkknmanryouymd();

        stNaiyouranMsgCdList.add("09001");

        if (C_Nenkinsyu.KAKUTEINENKIN.eq(nksyukbn)) {
            stNaiyouranMsgCdList.add("09002");
            stNaiyouranMsgCdList.add("09006");
            sonotanyrannenkinkkn = BizNumber.valueOf(pSyuKykSyouhnLst.get(0).getNenkinkkn());
        }

        else if (C_Nenkinsyu.SGKHSYSYSNNENKIN.eq(nksyukbn)) {
            stNaiyouranMsgCdList.add("09003");
            stNaiyouranMsgCdList.add("09007");
        }

        if (C_UmuKbn.ARI.eq(syouhnZokusei.getKzktourokuserviceumu())) {

            if (C_UmuKbn.ARI.eq(kzkTirasidouhuukbn1) ||
                C_UmuKbn.ARI.eq(kzkTirasidouhuukbn2)) {

                stNaiyouranMsgCdList.add("09041");
            }
        }

        if (pSksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {
            if (C_UmuKbn.ARI.eq(kykDrtkykhukaumu)) {

                stNaiyouranMsgCdList.add("09047");
            }

            if (C_UmuKbn.ARI.eq(stdrsktkyhkumu)) {

                stNaiyouranMsgCdList.add("09051");
            }
        }
        else {
            if (C_UmuKbn.ARI.eq(kykDrtkykhukaumu)) {

                stNaiyouranMsgCdList.add("09048");
            }

            if (C_UmuKbn.ARI.eq(stdrsktkyhkumu)) {

                stNaiyouranMsgCdList.add("09052");
            }
        }

        if (pSksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {

            stNaiyouranMsgCdList.add("09010");

            if (C_UmuKbn.ARI.eq(yennykntkhkumu)) {

                stNaiyouranMsgCdList.add("09021");
            }

            if (C_UmuKbn.ARI.eq(gaikanykntkhkumu)) {

                stNaiyouranMsgCdList.add("09030");
            }

            if (C_TmttknhaibunjyoutaiKbn.SISUU_ONLY.eq(tmttknhaibunjyoutaiKbn)) {

                stNaiyouranMsgCdList.add("09042");
                stNaiyouranMsgCdList.add("09045");
                stNaiyouranMsgCdList.add("09048");
                sonotanyransisuutmttkngk = sisuurendouTmttkngk;
                sonotanyransisuunm = sisuunm;
            }
            else if (C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(tmttknhaibunjyoutaiKbn)) {

                stNaiyouranMsgCdList.add("09043");
                sonotanyranteiritutmttkngk = teirituTmttkngk;
            }

            stNaiyouranMsgCdList.add("09060");

            if (C_UmuKbn.ARI.eq(targettkhkumu)) {

                if (C_UmuKbn.ARI.eq(yennykntkhkumu)) {
                    stNaiyouranMsgCdList.add("09035");
                }
                else {
                    stNaiyouranMsgCdList.add("09036");
                }

                if (targettkmokuhyouti > 0) {

                    stNaiyouranMsgCdList.add("09085");
                }
                else {

                    stNaiyouranMsgCdList.add("09084");
                }
            }

            stNaiyouranMsgCdList.add("09110");

            stNaiyouranMsgCdList.add("09102");

            tumitateriritu = pSyuKykSyouhnLst.get(0).getTumitateriritu();
        }
        else {

            if (yendthnkymd == null) {

                stNaiyouranMsgCdList.add("09010");

                if (C_UmuKbn.ARI.eq(yennykntkhkumu)) {

                    stNaiyouranMsgCdList.add("09021");

                    if (C_UmuKbn.ARI.eq(pGengakuExistsCheck)) {
                        stNaiyouranMsgCdList.add("09026");
                    }

                    stNaiyouranMsgCdList.add("09024");
                }

                if (C_UmuKbn.ARI.eq(gaikanykntkhkumu)) {

                    stNaiyouranMsgCdList.add("09030");

                    if (C_UmuKbn.ARI.eq(pGengakuExistsCheck)) {
                        stNaiyouranMsgCdList.add("09031");
                    }

                    stNaiyouranMsgCdList.add("09034");
                }

                if (BizDateUtil.compareYmd(pSyuKykSyouhnLst.get(0).getKykymd(), pEditHokenSyoukenParam.getCalckijyunYMD()) == BizDateUtil.COMPARE_LESSER) {

                    if (C_TmttknhaibunjyoutaiKbn.SISUU_ONLY.eq(tmttknhaibunjyoutaiKbn)) {

                        stNaiyouranMsgCdList.add("09042");
                        stNaiyouranMsgCdList.add("09045");
                        stNaiyouranMsgCdList.add("09049");

                        sonotanyransisuutmttkngk = sisurendoTmttknInfoBean.getSisuuRendouTmttknGK();
                        sonotanyransisuunm = sisuunm;
                    }
                    else if (C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(tmttknhaibunjyoutaiKbn)) {

                        stNaiyouranMsgCdList.add("09043");
                        sonotanyranteiritutmttkngk = sisurendoTmttknInfoBean.getTeirituTmttknGK();
                    }
                }
                else {

                    if (C_TmttknhaibunjyoutaiKbn.SISUU_ONLY.eq(tmttknhaibunjyoutaiKbn)) {

                        stNaiyouranMsgCdList.add("09042");
                        stNaiyouranMsgCdList.add("09045");
                        stNaiyouranMsgCdList.add("09049");

                        sonotanyransisuutmttkngk = sisuurendouTmttkngk;
                        sonotanyransisuunm = sisuunm;
                    }
                    else if (C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(tmttknhaibunjyoutaiKbn)) {

                        stNaiyouranMsgCdList.add("09043");
                        sonotanyranteiritutmttkngk = teirituTmttkngk;
                    }
                }
            }

            stNaiyouranMsgCdList.add("09060");

            if (yendthnkymd == null) {

                if (C_UmuKbn.ARI.eq(targettkhkumu)) {

                    if (C_UmuKbn.ARI.eq(pGengakuExistsCheck)) {

                        if (C_UmuKbn.ARI.eq(yennykntkhkumu)) {

                            stNaiyouranMsgCdList.add("09035");
                        }
                        else {
                            stNaiyouranMsgCdList.add("09036");
                        }
                    }
                    else {
                        if (C_UmuKbn.ARI.eq(yennykntkhkumu)) {

                            stNaiyouranMsgCdList.add("09033");
                        }
                        else {
                            stNaiyouranMsgCdList.add("09037");
                        }
                    }

                    if (targettkmokuhyouti > 0) {
                        stNaiyouranMsgCdList.add("09090");
                    }
                    else {

                        stNaiyouranMsgCdList.add("09085");
                    }
                }
            }
        }
        int stNaiyouranMsgCdListCnt = stNaiyouranMsgCdList.size();

        for (int i = 0; i < SONOTANAIYOULSTMAXCNT - stNaiyouranMsgCdListCnt; i++) {

            stNaiyouranMsgCdList.add("");
        }

        List<String> nenkinmsgcdLst = new ArrayList<>();

        nenkinmsgcdLst.add("12201");

        if (C_Nenkinsyu.KAKUTEINENKIN.eq(nksyukbn)) {

            nenkinmsgcdLst.add("12203");

            if (C_Tdk.HONNIN.eq(pKykSya.getKkkyktdk()) ||
                (nenkinUketorinin != null && C_UktKbn.HHKN.eq(nenkinUketorinin.getUktkbn()))) {
                nenkinmsgcdLst.add("12207");
            }

            if (C_TmttknhaibunjyoutaiKbn.SISUU_ONLY.eq(tmttknhaibunjyoutaiKbn)) {

                if (C_UmuKbn.ARI.eq(targettkhkumu) &&
                    targettkmokuhyouti > 0 &&
                    C_UmuKbn.NONE.eq(teikishrtkykhukaumu)) {

                    if (pSksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {

                        if (C_UmuKbn.ARI.eq(yennykntkhkumu)) {

                            nenkinmsgcdLst.add("12209");
                        }
                        else {
                            nenkinmsgcdLst.add("12211");
                        }
                    }
                    else {

                        if (C_UmuKbn.NONE.eq(pGengakuExistsCheck)) {

                            if (C_UmuKbn.ARI.eq(yennykntkhkumu)) {

                                nenkinmsgcdLst.add("12209");
                            }
                            else {
                                nenkinmsgcdLst.add("12211");
                            }
                        }
                        else {
                            nenkinmsgcdLst.add("12210");
                        }
                    }
                }

                if (targettkmokuhyouti == 0) {

                    if (C_UmuKbn.NONE.eq(teikishrtkykhukaumu)) {
                        if (pSksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {

                            if (C_UmuKbn.ARI.eq(yennykntkhkumu)) {

                                nenkinmsgcdLst.add("12217");
                            }
                            else {
                                nenkinmsgcdLst.add("12219");
                            }
                        }
                        else {
                            if (C_UmuKbn.NONE.eq(pGengakuExistsCheck)) {

                                if (C_UmuKbn.ARI.eq(yennykntkhkumu)) {

                                    nenkinmsgcdLst.add("12217");
                                }
                                else {
                                    nenkinmsgcdLst.add("12219");
                                }
                            }
                            else {
                                nenkinmsgcdLst.add("12228");
                            }
                        }
                    }
                }

                if (C_UmuKbn.ARI.eq(targettkhkumu) &&
                    targettkmokuhyouti == 0 &&
                    C_UmuKbn.NONE.eq(teikishrtkykhukaumu)) {

                    nenkinmsgcdLst.add("12220");
                }
            }
            else if (C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(tmttknhaibunjyoutaiKbn)) {

                if (C_UmuKbn.ARI.eq(targettkhkumu) &&
                    targettkmokuhyouti > 0 &&
                    C_UmuKbn.NONE.eq(teikishrtkykhukaumu)) {

                    if (pSksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {

                        if (C_UmuKbn.ARI.eq(yennykntkhkumu)) {

                            nenkinmsgcdLst.add("12213");
                        }
                        else {
                            nenkinmsgcdLst.add("12215");
                        }
                    }
                    else {

                        if (C_UmuKbn.NONE.eq(pGengakuExistsCheck)) {

                            if (C_UmuKbn.ARI.eq(yennykntkhkumu)) {

                                nenkinmsgcdLst.add("12213");
                            }
                            else {
                                nenkinmsgcdLst.add("12215");
                            }
                        }
                        else {
                            nenkinmsgcdLst.add("12212");
                        }
                    }
                }

                if (targettkmokuhyouti == 0) {

                    if (pSksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {

                        if (C_UmuKbn.ARI.eq(yennykntkhkumu)) {

                            nenkinmsgcdLst.add("12221");
                        }
                        else {
                            nenkinmsgcdLst.add("12223");
                        }
                    }
                    else {
                        if (C_UmuKbn.NONE.eq(pGengakuExistsCheck)) {

                            if (C_UmuKbn.ARI.eq(yennykntkhkumu)) {

                                nenkinmsgcdLst.add("12221");
                            }
                            else {
                                nenkinmsgcdLst.add("12223");
                            }
                        }
                        else {
                            nenkinmsgcdLst.add("12229");
                        }
                    }
                }

                if (C_UmuKbn.ARI.eq(targettkhkumu) &&
                    targettkmokuhyouti == 0) {

                    if (C_UmuKbn.NONE.eq(teikishrtkykhukaumu)) {

                        nenkinmsgcdLst.add("12220");
                    }
                }
            }
        }
        else if (C_Nenkinsyu.SGKHSYSYSNNENKIN.eq(nksyukbn)) {

            nenkinmsgcdLst.add("12205");

            if (C_Tdk.HONNIN.eq(pKykSya.getKkkyktdk()) ||
                (nenkinUketorinin != null && C_UktKbn.HHKN.eq(nenkinUketorinin.getUktkbn()))) {
                nenkinmsgcdLst.add("12207");
            }

            if (C_TmttknhaibunjyoutaiKbn.SISUU_ONLY.eq(tmttknhaibunjyoutaiKbn)) {

                if (C_UmuKbn.ARI.eq(targettkhkumu) &&
                    targettkmokuhyouti > 0 &&
                    C_UmuKbn.NONE.eq(teikishrtkykhukaumu)) {

                    if (pSksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {

                        if (C_UmuKbn.ARI.eq(yennykntkhkumu)) {

                            nenkinmsgcdLst.add("12202");
                        }
                        else {
                            nenkinmsgcdLst.add("12204");
                        }
                    }
                    else {

                        if (C_UmuKbn.NONE.eq(pGengakuExistsCheck)) {

                            if (C_UmuKbn.ARI.eq(yennykntkhkumu)) {

                                nenkinmsgcdLst.add("12202");
                            }
                            else {
                                nenkinmsgcdLst.add("12204");
                            }
                        }
                        else {
                            nenkinmsgcdLst.add("12206");
                        }
                    }
                }

                if (targettkmokuhyouti == 0) {

                    if (C_UmuKbn.NONE.eq(teikishrtkykhukaumu)) {
                        if (pSksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {

                            if (C_UmuKbn.ARI.eq(yennykntkhkumu)) {

                                nenkinmsgcdLst.add("12206");
                            }
                            else {
                                nenkinmsgcdLst.add("12208");
                            }

                            if (C_UmuKbn.ARI.eq(targettkhkumu) &&
                                targettkmokuhyouti == 0 &&
                                C_UmuKbn.NONE.eq(teikishrtkykhukaumu)) {

                                nenkinmsgcdLst.add("12210");
                            }
                        }
                        else {
                            if (C_UmuKbn.NONE.eq(pGengakuExistsCheck)) {

                                if (C_UmuKbn.ARI.eq(yennykntkhkumu)) {

                                    nenkinmsgcdLst.add("12208");
                                }
                                else {
                                    nenkinmsgcdLst.add("12216");
                                }
                            }
                            else {
                                nenkinmsgcdLst.add("12218");
                            }

                            if (C_UmuKbn.ARI.eq(targettkhkumu) &&
                                targettkmokuhyouti == 0 &&
                                C_UmuKbn.NONE.eq(teikishrtkykhukaumu)) {

                                nenkinmsgcdLst.add("12222");
                            }
                        }
                    }
                }
            }
            else if (C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(tmttknhaibunjyoutaiKbn)) {

                if (C_UmuKbn.ARI.eq(targettkhkumu) &&
                    targettkmokuhyouti > 0 &&
                    C_UmuKbn.NONE.eq(teikishrtkykhukaumu)) {

                    if (pSksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {

                        if (C_UmuKbn.ARI.eq(yennykntkhkumu)) {

                            nenkinmsgcdLst.add("12212");
                        }
                        else {
                            nenkinmsgcdLst.add("12214");
                        }
                    }
                    else {

                        if (C_UmuKbn.NONE.eq(pGengakuExistsCheck)) {

                            if (C_UmuKbn.ARI.eq(yennykntkhkumu)) {

                                nenkinmsgcdLst.add("12231");
                            }
                            else {
                                nenkinmsgcdLst.add("12232");
                            }
                        }
                        else {
                            nenkinmsgcdLst.add("12233");
                        }
                    }
                }

                if (targettkmokuhyouti == 0) {

                    if (pSksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {

                        if (C_UmuKbn.ARI.eq(yennykntkhkumu)) {

                            nenkinmsgcdLst.add("12216");
                        }
                        else {
                            nenkinmsgcdLst.add("12218");
                        }

                        if (C_UmuKbn.ARI.eq(targettkhkumu) &&
                            targettkmokuhyouti == 0) {

                            if (C_UmuKbn.NONE.eq(teikishrtkykhukaumu)) {

                                nenkinmsgcdLst.add("12210");
                            }
                        }
                    }
                    else {
                        if (C_UmuKbn.NONE.eq(pGengakuExistsCheck)) {

                            if (C_UmuKbn.ARI.eq(yennykntkhkumu)) {

                                nenkinmsgcdLst.add("12234");
                            }
                            else {
                                nenkinmsgcdLst.add("12235");
                            }
                        }
                        else {
                            nenkinmsgcdLst.add("12236");
                        }

                        if (C_UmuKbn.ARI.eq(targettkhkumu) &&
                            targettkmokuhyouti == 0) {

                            if (C_UmuKbn.NONE.eq(teikishrtkykhukaumu)) {

                                nenkinmsgcdLst.add("12222");
                            }
                        }
                    }
                }
            }
        }

        List<String> siboukyhkmsgcdLst = new ArrayList<>();

        siboukyhkmsgcdLst.add("12331");

        if (yendthnkymd == null) {
            if (C_UmuKbn.ARI.eq(targettkhkumu) &&
                targettkmokuhyouti > 0 &&
                C_UmuKbn.NONE.eq(teikishrtkykhukaumu)) {

                if (pSksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {

                    if (C_UmuKbn.ARI.eq(yennykntkhkumu)) {

                        siboukyhkmsgcdLst.add("12333");
                    }
                    else {
                        siboukyhkmsgcdLst.add("12336");
                    }
                }
                else {

                    if (C_UmuKbn.NONE.eq(pGengakuExistsCheck)) {

                        if (C_UmuKbn.ARI.eq(yennykntkhkumu)) {

                            siboukyhkmsgcdLst.add("12333");
                        }
                        else {
                            siboukyhkmsgcdLst.add("12335");
                        }
                    }
                    else {
                        siboukyhkmsgcdLst.add("12332");
                    }
                }
            }

            if (targettkmokuhyouti == 0) {

                if (pSksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {

                    if (C_UmuKbn.ARI.eq(yennykntkhkumu)) {

                        siboukyhkmsgcdLst.add("12341");
                    }
                    else {
                        siboukyhkmsgcdLst.add("12344");
                    }
                }
                else {
                    if (C_UmuKbn.NONE.eq(pGengakuExistsCheck)) {

                        if (C_UmuKbn.ARI.eq(yennykntkhkumu)) {

                            siboukyhkmsgcdLst.add("12341");
                        }
                        else {
                            siboukyhkmsgcdLst.add("12343");
                        }
                    }
                    else {
                        siboukyhkmsgcdLst.add("12214");
                    }
                }

            }
            if (C_UmuKbn.ARI.eq(targettkhkumu) &&
                targettkmokuhyouti == 0) {

                siboukyhkmsgcdLst.add("12345");
            }
        }

        if (C_Nenkinsyu.KAKUTEINENKIN.eq(nksyukbn)) {
            if (C_Tdk.HONNIN.eq(pKykSya.getKkkyktdk()) ||
                (nenkinUketorinin != null && C_UktKbn.HHKN.eq(nenkinUketorinin.getUktkbn()))) {

                siboukyhkmsgcdLst.add("12349");
            }
            else {
                siboukyhkmsgcdLst.add("12351");
            }
        }

        else if (C_Nenkinsyu.SGKHSYSYSNNENKIN.eq(nksyukbn)) {

            if (C_Tdk.HONNIN.eq(pKykSya.getKkkyktdk()) ||
                (nenkinUketorinin != null && C_UktKbn.HHKN.eq(nenkinUketorinin.getUktkbn()))) {

                siboukyhkmsgcdLst.add("12353");
            }
            else {
                siboukyhkmsgcdLst.add("12355");
            }
        }

        List<String> hutanhiyustmmsgcdueLst = new ArrayList<>();

        String hutanhiyustmmsgcdst01 = "";

        String hutanhiyustmmsgcdst02 = "";

        String hutanhiyustmknsnhyuptn = "";

        if (yendthnkymd == null) {

            if (pSksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {

                hutanhiyustmmsgcdueLst.add("13076");

                if (C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(tmttknhaibunjyoutaiKbn)) {

                    hutanhiyustmmsgcdueLst.add("13085");
                }

                else if (C_TmttknhaibunjyoutaiKbn.SISUU_ONLY.eq(tmttknhaibunjyoutaiKbn)) {

                    hutanhiyustmmsgcdueLst.add("13087");
                }

                hutanhiyustmmsgcdueLst.add("13093");
            }
            else {

                int hknkkn = pSyuKykSyouhnLst.get(0).getHknkkn();

                if (keikanensuu < hknkkn - 1) {

                    if (C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(tmttknhaibunjyoutaiKbn)) {

                        hutanhiyustmmsgcdueLst.add("13081");
                    }
                    else if (C_TmttknhaibunjyoutaiKbn.SISUU_ONLY.eq(tmttknhaibunjyoutaiKbn)) {

                        hutanhiyustmmsgcdueLst.add("13088");
                    }
                }
                else {

                    if (C_TmttknhaibunjyoutaiKbn.SISUU_ONLY.eq(tmttknhaibunjyoutaiKbn)) {

                        if (hknkkn == 5) {
                            hutanhiyustmmsgcdueLst.add("13099");
                        }

                        else if (hknkkn == 10) {
                            hutanhiyustmmsgcdueLst.add("13069");
                        }
                    }
                    else if (C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(tmttknhaibunjyoutaiKbn)) {

                        if (hknkkn == 5) {
                            hutanhiyustmmsgcdueLst.add("13089");
                        }

                        else if (hknkkn == 10) {
                            hutanhiyustmmsgcdueLst.add("13097");
                        }
                    }
                }
                hutanhiyustmmsgcdueLst.add("13098");
            }

            hutanhiyustmmsgcdst01 = "13100";

            if (C_UmuKbn.ARI.eq(yennykntkhkumu)) {

                hutanhiyustmmsgcdst02 = "13128";

                hutanhiyustmknsnhyuptn = "08";
            }
            else if (C_UmuKbn.ARI.eq(gaikanykntkhkumu)){

                hutanhiyustmmsgcdst02 = "13130";

                hutanhiyustmknsnhyuptn = "09";
            }
            else {

                hutanhiyustmmsgcdst02 = "13126";

                hutanhiyustmknsnhyuptn = "07";
            }
        }

        int hutanhiyustmmsgcdueLstCnt = hutanhiyustmmsgcdueLst.size();

        for (int i = 0; i < HUTANHIYUSTMMSGCDUEMAXCNT - hutanhiyustmmsgcdueLstCnt; i++) {

            hutanhiyustmmsgcdueLst.add("");
        }

        List<String> syouhnhutaimsgcdLst = new ArrayList<>();

        C_Tuukasyu fstphrkpkngkkeituuktype = C_Tuukasyu.BLNK;

        BizCurrency fstphrkpkngkkei = null;

        String koujyosyoumeimsgcd1 = "";

        if (pSksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {

            fstphrkpkngkkeituuktype = pNyknJissekiRirekiLst.get(0).getRstuukasyu();

            fstphrkpkngkkei = pNyknJissekiRirekiLst.get(0).getRsgaku();

            if (C_DirectServiceMosKbn.ENTRY.eq(pKykKihon.getDrctservicemoskbn()) ||
                C_DirectServiceMosKbn.CHECK.eq(pKykKihon.getDrctservicemoskbn())) {

                if (C_UmuKbn.ARI.eq(targettkhkumu)) {

                    syouhnhutaimsgcdLst.add("13192");
                }
            }

            if (C_UmuKbn.ARI.eq(yennykntkhkumu)) {

                koujyosyoumeimsgcd1 = "15040";
            }
            else {
                if (C_UmuKbn.ARI.eq(targettkhkumu)) {

                    koujyosyoumeimsgcd1 = "15045";
                }
            }
        }

        int syouhnhutaimsgcdLstCnt = syouhnhutaimsgcdLst.size();

        for (int i = 0; i < SYOUHNHUTAIMSGCDLSTMAXCNT - syouhnhutaimsgcdLstCnt; i++) {

            syouhnhutaimsgcdLst.add("");
        }

        List<String> wtyuuijikoumsgcdLst = new ArrayList<>();

        C_Tuukasyu witijibrptuktype = C_Tuukasyu.BLNK;

        BizCurrency witijibrp = null;

        String wmsgcd1 = "";

        String wmsgcd2 = "";

        String wmsgcd3 = "";

        String wmsgcd2_1 = "";

        String wmsgcd2_2 = "";

        String wmsgcd3_1 = "";

        String wmsgcdst = "";

        C_Tuukasyu wyenhrkgktuktype = C_Tuukasyu.BLNK;

        BizCurrency wyenhrkgk = null;

        C_Tuukasyu wyenitijibrptuktype = C_Tuukasyu.BLNK;

        BizCurrency wyenitijibrp = null;

        BizNumber hutanhiyustmkyakkjrtmin = BizNumber.ZERO;

        if (pSksyoukenskskbn == SINKEIYAKUHOKENSYOUKEN) {

            witijibrptuktype = kyktuukasyu;

            witijibrp = hokenryou;

            if (C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(tmttknhaibunjyoutaiKbn)) {

                if (C_UmuKbn.NONE.eq(teikishrtkykhukaumu)) {

                    wtyuuijikoumsgcdLst.add("14021");
                }
            }
            else if (C_TmttknhaibunjyoutaiKbn.SISUU_ONLY.eq(tmttknhaibunjyoutaiKbn)) {

                wtyuuijikoumsgcdLst.add("14028");
            }

            if (C_UmuKbn.ARI.eq(yennykntkhkumu)) {

                wtyuuijikoumsgcdLst.add("14027");

                wyenhrkgktuktype = C_Tuukasyu.JPY;

                wyenhrkgk = pNyknJissekiRirekiLst.get(0).getRsgaku();
            }
            else {
                wtyuuijikoumsgcdLst.add("14032");

                wyenitijibrptuktype = C_Tuukasyu.JPY;

                wyenitijibrp = kijyungaku;
            }

            if (C_TmttknhaibunjyoutaiKbn.SISUU_ONLY.eq(tmttknhaibunjyoutaiKbn)) {

                wmsgcd1 = "14019";

                wmsgcd2_1 = "14023";

                wtyuuijikoumsgcdLst.add("14052");
            }
            else if (C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(tmttknhaibunjyoutaiKbn)) {

                wmsgcd1 = "14016";

                wtyuuijikoumsgcdLst.add("14055");
            }

            if (pSyuKykSyouhnLst.get(0).getHknkkn() == 5) {

                if (tumitateriritu.multiply(100).compareTo(BizNumber.valueOf(0.2)) < 0) {

                    wtyuuijikoumsgcdLst.add("14065");
                }
                else if (tumitateriritu.multiply(100).compareTo(BizNumber.valueOf(0.25)) < 0) {

                    wtyuuijikoumsgcdLst.add("14066");
                }
                else if (tumitateriritu.multiply(100).compareTo(BizNumber.valueOf(0.30)) < 0) {

                    wtyuuijikoumsgcdLst.add("14067");
                }
                else {

                    wtyuuijikoumsgcdLst.add("14068");
                }
            }
            else if (pSyuKykSyouhnLst.get(0).getHknkkn() == 10) {

                if (tumitateriritu.multiply(100).compareTo(BizNumber.valueOf(0.2)) < 0) {

                    wtyuuijikoumsgcdLst.add("14069");
                }
                else if (tumitateriritu.multiply(100).compareTo(BizNumber.valueOf(0.25)) < 0) {

                    wtyuuijikoumsgcdLst.add("14071");
                }
                else if (tumitateriritu.multiply(100).compareTo(BizNumber.valueOf(0.30)) < 0) {

                    wtyuuijikoumsgcdLst.add("14073");
                }
                else {

                    wtyuuijikoumsgcdLst.add("14074");
                }
            }

            if (C_UmuKbn.ARI.eq(targettkhkumu)) {

                if (targettkmokuhyouti > 0) {

                    wtyuuijikoumsgcdLst.add("14062");
                }
                else {
                    wtyuuijikoumsgcdLst.add("14072");
                }
            }
        }
        else {

            if (yendthnkymd == null) {

                if (pSyuKykSyouhnLst.get(0).getHknkkn() - keikanensuu > 0) {

                    if (C_TmttknhaibunjyoutaiKbn.SISUU_ONLY.eq(tmttknhaibunjyoutaiKbn)) {

                        if (pSyuKykSyouhnLst.get(0).getHknkkn() - keikanensuu > 3) {

                            wmsgcd1 = "14029";

                            wmsgcd2_1 = "14039";

                            wtyuuijikoumsgcdLst.add("14024");
                        }
                        else if (pSyuKykSyouhnLst.get(0).getHknkkn() - keikanensuu == 2 ||
                            pSyuKykSyouhnLst.get(0).getHknkkn() - keikanensuu == 3) {

                            wmsgcd1 = "14033";

                            wtyuuijikoumsgcdLst.add("14049");
                        }
                        else if (pSyuKykSyouhnLst.get(0).getHknkkn() - keikanensuu == 1) {

                            wmsgcd1 = "14047";

                            wmsgcd2_1 = "14048";

                            wtyuuijikoumsgcdLst.add("14049");
                        }
                    }
                    else if (C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(tmttknhaibunjyoutaiKbn)) {

                        wmsgcd1 = "14075";
                        wtyuuijikoumsgcdLst.add("14028");
                    }

                    if (C_UmuKbn.NONE.eq(pGengakuExistsCheck)) {

                        if (C_TmttknhaibunjyoutaiKbn.SISUU_ONLY.eq(tmttknhaibunjyoutaiKbn)) {

                            witijibrptuktype = kyktuukasyu;
                            witijibrp = hokenryou;

                            if (C_UmuKbn.ARI.eq(yennykntkhkumu)) {
                                wtyuuijikoumsgcdLst.add("14038");
                                wyenhrkgktuktype = C_Tuukasyu.JPY;
                                wyenhrkgk = pNyknJissekiRirekiLst.get(0).getRsgaku();

                            }
                            else {
                                wtyuuijikoumsgcdLst.add("14040");
                                wyenitijibrptuktype = C_Tuukasyu.JPY;
                                wyenitijibrp = kijyungaku;
                            }
                        }
                        else if (C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(tmttknhaibunjyoutaiKbn)) {

                            witijibrptuktype = kyktuukasyu;
                            witijibrp = hokenryou;

                            if (C_UmuKbn.ARI.eq(yennykntkhkumu)) {
                                wtyuuijikoumsgcdLst.add("14044");
                                wyenhrkgktuktype = C_Tuukasyu.JPY;
                                wyenhrkgk = pNyknJissekiRirekiLst.get(0).getRsgaku();

                            }
                            else {
                                wtyuuijikoumsgcdLst.add("14046");
                                wyenitijibrptuktype = C_Tuukasyu.JPY;
                                wyenitijibrp = kijyungaku;
                            }
                        }
                    }

                    if (C_TmttknhaibunjyoutaiKbn.SISUU_ONLY.eq(tmttknhaibunjyoutaiKbn)) {

                        if (pSyuKykSyouhnLst.get(0).getHknkkn() - keikanensuu > 3) {

                            wtyuuijikoumsgcdLst.add("14051");
                        }

                        else {

                            wtyuuijikoumsgcdLst.add("14052");
                        }

                    }
                    else if (C_TmttknhaibunjyoutaiKbn.TEIRITU_ONLY.eq(tmttknhaibunjyoutaiKbn)) {
                        wtyuuijikoumsgcdLst.add("14056");
                    }

                    if (pSyuKykSyouhnLst.get(0).getHknkkn() == 5) {

                        if (tumitateriritu.multiply(100).compareTo(BizNumber.valueOf(0.2)) < 0) {

                            wtyuuijikoumsgcdLst.add("14066");
                            hutanhiyustmkyakkjrtmin = KAIYAKUKOUJYORITU_0001;
                        }
                        else if (tumitateriritu.multiply(100).compareTo(BizNumber.valueOf(0.25)) < 0) {

                            wtyuuijikoumsgcdLst.add("14067");
                            hutanhiyustmkyakkjrtmin = KAIYAKUKOUJYORITU_0002;
                        }
                        else if (tumitateriritu.multiply(100).compareTo(BizNumber.valueOf(0.30)) < 0) {

                            wtyuuijikoumsgcdLst.add("14068");
                            hutanhiyustmkyakkjrtmin = KAIYAKUKOUJYORITU_0004;
                        }
                        else {

                            wtyuuijikoumsgcdLst.add("14069");
                            hutanhiyustmkyakkjrtmin = KAIYAKUKOUJYORITU_0005;
                        }
                    }
                    else if (pSyuKykSyouhnLst.get(0).getHknkkn() == 10) {

                        if (tumitateriritu.multiply(100).compareTo(BizNumber.valueOf(0.2)) < 0) {

                            wtyuuijikoumsgcdLst.add("14070");
                            hutanhiyustmkyakkjrtmin = KAIYAKUKOUJYORITU_0001;
                        }
                        else if (tumitateriritu.multiply(100).compareTo(BizNumber.valueOf(0.25)) < 0) {

                            wtyuuijikoumsgcdLst.add("14071");
                            hutanhiyustmkyakkjrtmin = KAIYAKUKOUJYORITU_0002;
                        }
                        else if (tumitateriritu.multiply(100).compareTo(BizNumber.valueOf(0.30)) < 0) {

                            wtyuuijikoumsgcdLst.add("14072");
                            hutanhiyustmkyakkjrtmin = KAIYAKUKOUJYORITU_0004;
                        }
                        else {

                            wtyuuijikoumsgcdLst.add("14073");
                            hutanhiyustmkyakkjrtmin = KAIYAKUKOUJYORITU_0005;
                        }
                    }

                    if (C_UmuKbn.ARI.eq(targettkhkumu)) {

                        if (targettkmokuhyouti > 0) {
                            wtyuuijikoumsgcdLst.add("14074");
                        }
                        else {
                            wtyuuijikoumsgcdLst.add("14076");
                        }
                    }
                }
            }
        }
        int wtyuuijikoumsgcdLstCnt = wtyuuijikoumsgcdLst.size();

        for (int i = 0; i < WTYUUIJIKOUMSGCDMAXCNT - wtyuuijikoumsgcdLstCnt; i++) {

            wtyuuijikoumsgcdLst.add("");
        }

        if (hyoujiranleftmsgcdLst.size() > 0) {
            pHokenSyouken.setHyoujiranhidarimsgcd1(hyoujiranleftmsgcdLst.get(0));
        }

        if (hyoujiranleftmsgcdLst.size() > 1) {
            pHokenSyouken.setHyoujiranhidarimsgcd2(hyoujiranleftmsgcdLst.get(1));
        }

        if (hyoujiranleftmsgcdLst.size() > 2) {
            pHokenSyouken.setHyoujiranhidarimsgcd3(hyoujiranleftmsgcdLst.get(2));
        }

        if (hyoujiranleftmsgcdLst.size() > 3) {
            pHokenSyouken.setHyoujiranhidarimsgcd4(hyoujiranleftmsgcdLst.get(3));
        }

        if (hyoujiranleftmsgcdLst.size() > 4) {
            pHokenSyouken.setHyoujiranhidarimsgcd5(hyoujiranleftmsgcdLst.get(4));
        }

        if (hyoujiranleftmsgcdLst.size() > 5) {
            pHokenSyouken.setHyoujiranhidarimsgcd6(hyoujiranleftmsgcdLst.get(5));
        }

        if (hyoujiranleftmsgcdLst.size() > 6) {
            pHokenSyouken.setHyoujiranhidarimsgcd7(hyoujiranleftmsgcdLst.get(6));
        }

        if (hyoujiranrightmsgcdLst.size() > 0) {
            pHokenSyouken.setHyoujiranmigiimsgcd1(hyoujiranrightmsgcdLst.get(0));
        }

        if (hyoujiranrightmsgcdLst.size() > 1) {
            pHokenSyouken.setHyoujiranmigiimsgcd2(hyoujiranrightmsgcdLst.get(1));
        }

        pHokenSyouken.setHyoujiransknnkaisiymd(sknnkaisiymd);

        pHokenSyouken.setHyoujiransjkkktusirrt(hyoujiransjkkktusirrt);

        pHokenSyouken.setPmsgcd1(pmsgcd1);

        pHokenSyouken.setPmsgcd2(pmsgcd2);

        pHokenSyouken.setPtuukatype(ptuukasyu);

        pHokenSyouken.setHokenryou(hokenryou);

        pHokenSyouken.setPtuuka(ptuukasyuNm);

        pHokenSyouken.setPtokuyakumsgcd(ptokuyakumsgcd);

        pHokenSyouken.setPhrkktuki("＊");

        pHokenSyouken.setHrkhouhoumsgkbn("00");

        pHokenSyouken.setSyukyktkykmsgkbn1(syukyktkykmsgkbn1);

        pHokenSyouken.setSyukyktkyksmsgkbn1(syukyktkyksmsgkbn1);

        pHokenSyouken.setSyukyktkykhknkknmsgkbn1(syukyktkykhknkknmsgkbn1);

        pHokenSyouken.setSyukyktkykstuukatype1(syukyktkykstuukatype1);

        pHokenSyouken.setSyukyktkykhknkngk1(syukyktkykhknkngk1);

        pHokenSyouken.setStnaiyouranmsgcd1(stNaiyouranMsgCdList.get(0));

        pHokenSyouken.setStnaiyouranmsgcd2(stNaiyouranMsgCdList.get(1));

        pHokenSyouken.setStnaiyouranmsgcd3(stNaiyouranMsgCdList.get(2));

        pHokenSyouken.setStnaiyouranmsgcd4(stNaiyouranMsgCdList.get(3));

        pHokenSyouken.setStnaiyouranmsgcd5(stNaiyouranMsgCdList.get(4));

        pHokenSyouken.setStnaiyouranmsgcd6(stNaiyouranMsgCdList.get(5));

        pHokenSyouken.setStnaiyouranmsgcd7(stNaiyouranMsgCdList.get(6));

        pHokenSyouken.setStnaiyouranmsgcd8(stNaiyouranMsgCdList.get(7));

        pHokenSyouken.setStnaiyouranmsgcd9(stNaiyouranMsgCdList.get(8));

        pHokenSyouken.setStnaiyouranmsgcd10(stNaiyouranMsgCdList.get(9));

        pHokenSyouken.setStnaiyouranmsgcd11(stNaiyouranMsgCdList.get(10));

        pHokenSyouken.setStnaiyouranmsgcd12(stNaiyouranMsgCdList.get(11));

        pHokenSyouken.setStnaiyouranmsgcd13(stNaiyouranMsgCdList.get(12));

        pHokenSyouken.setStnaiyouranmsgcd14(stNaiyouranMsgCdList.get(13));

        pHokenSyouken.setStnaiyouranmsgcd15(stNaiyouranMsgCdList.get(14));

        pHokenSyouken.setStnaiyouranmsgcd16(stNaiyouranMsgCdList.get(15));

        pHokenSyouken.setStnaiyouranmsgcd17(stNaiyouranMsgCdList.get(16));

        pHokenSyouken.setStnaiyouranmsgcd18(stNaiyouranMsgCdList.get(17));

        pHokenSyouken.setStnaiyouranmsgcd19(stNaiyouranMsgCdList.get(18));

        pHokenSyouken.setStnaiyouranmsgcd20(stNaiyouranMsgCdList.get(19));

        pHokenSyouken.setHutanhiyustmmsgcdue01(hutanhiyustmmsgcdueLst.get(0));

        pHokenSyouken.setHutanhiyustmmsgcdue02(hutanhiyustmmsgcdueLst.get(1));

        pHokenSyouken.setHutanhiyustmmsgcdue03(hutanhiyustmmsgcdueLst.get(2));

        pHokenSyouken.setHutanhiyustmmsgcdue04(hutanhiyustmmsgcdueLst.get(3));

        pHokenSyouken.setHutanhiyustmknsnhyuptn(hutanhiyustmknsnhyuptn);

        pHokenSyouken.setHutanhiyustmmsgcdst01(hutanhiyustmmsgcdst01);

        pHokenSyouken.setHutanhiyustmmsgcdst02(hutanhiyustmmsgcdst02);

        pHokenSyouken.setFstphrkpkngkkeituuktype(fstphrkpkngkkeituuktype);

        pHokenSyouken.setFstphrkpkngkkei(fstphrkpkngkkei);

        pHokenSyouken.setSyouhnhutaimsgcd1(syouhnhutaimsgcdLst.get(0));

        pHokenSyouken.setSyouhnhutaimsgcd2(syouhnhutaimsgcdLst.get(1));

        pHokenSyouken.setWmsgcd1(wmsgcd1);

        pHokenSyouken.setWmsgcd2(wmsgcd2);

        pHokenSyouken.setWmsgcd3(wmsgcd3);

        if (wtyuuijikoumsgcdLst.size() > 0) {
            pHokenSyouken.setWtyuuijikoumsgcd1(wtyuuijikoumsgcdLst.get(0));
        }

        if (wtyuuijikoumsgcdLst.size() > 1) {
            pHokenSyouken.setWtyuuijikoumsgcd2(wtyuuijikoumsgcdLst.get(1));
        }

        if (wtyuuijikoumsgcdLst.size() > 2) {
            pHokenSyouken.setWtyuuijikoumsgcd3(wtyuuijikoumsgcdLst.get(2));
        }

        if (wtyuuijikoumsgcdLst.size() > 3) {
            pHokenSyouken.setWtyuuijikoumsgcd4(wtyuuijikoumsgcdLst.get(3));
        }

        if (wtyuuijikoumsgcdLst.size() > 4) {
            pHokenSyouken.setWtyuuijikoumsgcd5(wtyuuijikoumsgcdLst.get(4));
        }

        pHokenSyouken.setWitijibrptuktype(witijibrptuktype);

        pHokenSyouken.setWitijibrp(witijibrp);

        pHokenSyouken.setWyenhrkgktuktype(wyenhrkgktuktype);

        pHokenSyouken.setWyenhrkgk(wyenhrkgk);

        pHokenSyouken.setWyenitijibrptuktype(wyenitijibrptuktype);

        pHokenSyouken.setWyenitijibrp(wyenitijibrp);

        pHokenSyouken.setKoujyosyoumeimsgcd1(koujyosyoumeimsgcd1);

        pHokenSyouken.setSonotanyrannkshrstartymd(nkshrstartymd);

        pHokenSyouken.setSonotanyrannenkinkkn(sonotanyrannenkinkkn);

        pHokenSyouken.setSonotanyrantumitateriritu(tumitateriritu);

        pHokenSyouken.setSonotanyransetteibairitu(sonotanyransetteibairitu);

        pHokenSyouken.setSonotanyrantmttkngktuktype(kyktuukasyu.getValue());

        pHokenSyouken.setSonotanyranteiritutmttkngk(sonotanyranteiritutmttkngk);

        pHokenSyouken.setSonotanyransisuutmttkngk(sonotanyransisuutmttkngk);

        pHokenSyouken.setSonotanyransisuunm(sonotanyransisuunm);

        if (pSksyoukenskskbn != SINKEIYAKUHOKENSYOUKEN &&
            yendthnkymd != null) {

            pHokenSyouken.setHosyounymsgcd("99001");
        }

        if (nenkinmsgcdLst.size() > 0) {
            pHokenSyouken.setNkmsgcd1(nenkinmsgcdLst.get(0));
        }

        if (nenkinmsgcdLst.size() > 1) {
            pHokenSyouken.setNkmsgcd2(nenkinmsgcdLst.get(1));
        }

        if (nenkinmsgcdLst.size() > 2) {
            pHokenSyouken.setNkmsgcd3(nenkinmsgcdLst.get(2));
        }

        if (nenkinmsgcdLst.size() > 3) {
            pHokenSyouken.setNkmsgcd4(nenkinmsgcdLst.get(3));
        }

        if (nenkinmsgcdLst.size() > 4) {
            pHokenSyouken.setNkmsgcd5(nenkinmsgcdLst.get(4));
        }

        if (nenkinmsgcdLst.size() > 5) {
            pHokenSyouken.setNkmsgcd6(nenkinmsgcdLst.get(5));
        }

        if (nenkinmsgcdLst.size() > 6) {
            pHokenSyouken.setNkmsgcd7(nenkinmsgcdLst.get(6));
        }

        if (nenkinmsgcdLst.size() > 7) {
            pHokenSyouken.setNkmsgcd8(nenkinmsgcdLst.get(7));
        }

        if (nenkinmsgcdLst.size() > 8) {
            pHokenSyouken.setNkmsgcd9(nenkinmsgcdLst.get(8));
        }

        if (nenkinmsgcdLst.size() > 9) {
            pHokenSyouken.setNkmsgcd10(nenkinmsgcdLst.get(9));
        }

        if (siboukyhkmsgcdLst.size() > 0) {
            pHokenSyouken.setSiboukyuuhukinmsgcd1(siboukyhkmsgcdLst.get(0));
        }

        if (siboukyhkmsgcdLst.size() > 1) {
            pHokenSyouken.setSiboukyuuhukinmsgcd2(siboukyhkmsgcdLst.get(1));
        }

        if (siboukyhkmsgcdLst.size() > 2) {
            pHokenSyouken.setSiboukyuuhukinmsgcd3(siboukyhkmsgcdLst.get(2));
        }

        if (siboukyhkmsgcdLst.size() > 3) {
            pHokenSyouken.setSiboukyuuhukinmsgcd4(siboukyhkmsgcdLst.get(3));
        }

        if (siboukyhkmsgcdLst.size() > 4) {
            pHokenSyouken.setSiboukyuuhukinmsgcd5(siboukyhkmsgcdLst.get(4));
        }

        if (siboukyhkmsgcdLst.size() > 5) {
            pHokenSyouken.setSiboukyuuhukinmsgcd6(siboukyhkmsgcdLst.get(5));
        }

        if (siboukyhkmsgcdLst.size() > 6) {
            pHokenSyouken.setSiboukyuuhukinmsgcd7(siboukyhkmsgcdLst.get(6));
        }

        if (siboukyhkmsgcdLst.size() > 7) {
            pHokenSyouken.setSiboukyuuhukinmsgcd8(siboukyhkmsgcdLst.get(7));
        }

        if (siboukyhkmsgcdLst.size() > 8) {
            pHokenSyouken.setSiboukyuuhukinmsgcd9(siboukyhkmsgcdLst.get(8));
        }

        if (siboukyhkmsgcdLst.size() > 9) {
            pHokenSyouken.setSiboukyuuhukinmsgcd10(siboukyhkmsgcdLst.get(9));
        }

        if (nkshrstartymd != null) {
            pHokenSyouken.setNkshrstartzenymd(String.valueOf(nkshrstartymd.getPreviousDay()));
        }

        pHokenSyouken.setTeiritutmtthbnwr(BizNumber.valueOf(100).subtract(kykjisisuurendourate));

        pHokenSyouken.setSisuutmtthbnwr(kykjisisuurendourate);

        pHokenSyouken.setHutanhiyustmytijihiritu(BizNumber.valueOf(HUTANHIYUSTMYTIJIHIRITU));

        pHokenSyouken.setWmsgcd21(wmsgcd2_1);

        pHokenSyouken.setWmsgcd22(wmsgcd2_2);

        pHokenSyouken.setWmsgcd31(wmsgcd3_1);
        pHokenSyouken.setWmsgcdst1(wmsgcdst);

        if (wtyuuijikoumsgcdLst.size() > 5) {
            pHokenSyouken.setWtyuuijikoumsgcd6(wtyuuijikoumsgcdLst.get(5));
        }

        if (wtyuuijikoumsgcdLst.size() > 6) {
            pHokenSyouken.setWtyuuijikoumsgcd7(wtyuuijikoumsgcdLst.get(6));
        }

        IT_HokenSyoukenHukaInfo pHokenSyoukenHukaInfo = pHokenSyouken.getHokenSyoukenHukaInfo();

        pHokenSyoukenHukaInfo.setHutanhiyustmkyakkjrtmin(hutanhiyustmkyakkjrtmin);

        logger.debug("△ 保険証券TBL編集（年金３） 終了");
    }
}
