package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateSpan;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.ascommon.GetasPRsTuuka;
import yuyu.common.hozen.khcommon.dba4editkoujyonaiyoutbl.EditKoujyonaiyouTblDao;
import yuyu.common.hozen.khcommon.dba4editkoujyonaiyoutbl.NyknjiKoujyoSymNaiyouBean;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Delflag;
import yuyu.def.classification.C_DispKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KinouKbn;
import yuyu.def.classification.C_Kjsmhakkouzumiflg;
import yuyu.def.classification.C_KjsymnytblhensyuusyoriKbn;
import yuyu.def.classification.C_KoujyosymnaiyourecKbn;
import yuyu.def.classification.C_KoujyosyoumeipKbn;
import yuyu.def.classification.C_KykhnkKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_Nyktrksflg;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TekiyouseidoKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KoujyoSymNaiyou;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 契約保全 契約保全共通 控除証明内容TBL編集
 */
public class EditKoujyonaiyouTbl {

    private String kinouId = "";
    private String userId  = "";
    private String sysTime = "";
    private C_KoujyosymnaiyourecKbn koujyoSymNaiyouRecKbn = C_KoujyosymnaiyourecKbn.BLNK;
    private C_UmuKbn pmnjTkHnkUmu  = C_UmuKbn.NONE;
    private BizDate calcKjnYmd = null;
    private BizDateYM henmaeJkipJytYm = null;
    private String henmaeHenkousikibetukey = "";
    private C_Hrkkaisuu henmaeHrkKaisuu = C_Hrkkaisuu.BLNK;
    private C_UmuKbn ikkatuNyknUmu = C_UmuKbn.NONE;
    private BizDateYM nyknJskStartYm = null;
    private BizDateYM nyknJskEndYm = null;
    private int nyknJskRenno = 0;
    private BizDate nyknJskRyosyuYmd = null;
    private int nyknJskJytKaisuuY = 0;
    private int nyknJskJytKaisuuM = 0;
    private BizNumber nyknJskRysKwsrate = BizNumber.valueOf(0);
    private int kihrkpSeisanRenno = 0;
    private BizDateYM kihrkpSeisanJytYm = null;
    private int kihrkpSeisanJytKaisuuY = 0;
    private int kihrkpSeisanJytKaisuuM = 0;
    private BizCurrency mkkp = BizCurrency.valueOf(0);
    private BizNumber seisanjiYenkansanKwsrate = BizNumber.valueOf(0);
    private int koujyoSymNaiyouRenNo = 0;
    private List<KykSyouhnCommonParam> kykSyouhnLst = null;
    private ZennouKoujyogakuKeisanParam zennouKoujyogakuKeisanParam = null;
    private List<KykSyouhnCommonParam> henmaeKykSyouhnLst = null;
    private ZennouKoujyogakuKeisanParam henmaeZennouKoujyogakuKeisanParam = null;
    private BizDateYM youpJytStartYm = null;
    private C_Nykkeiro nykkeiro = C_Nykkeiro.BLNK;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private EditKoujyonaiyouTblDao editKoujyonaiyouTblDao;

    @Inject
    private BizDomManager bizDomManager;

    public EditKoujyonaiyouTbl() {
        super();
    }

    public void setCalcKjnYmd(BizDate pCalcKjnYmd) {
        calcKjnYmd = pCalcKjnYmd;
    }

    public void setHenmaeJkipJytYm(BizDateYM pHenmaeJkipJytYm) {
        henmaeJkipJytYm = pHenmaeJkipJytYm;
    }

    public void setHenmaeHenkousikibetukey(String pHenmaeHenkousikibetukey) {
        henmaeHenkousikibetukey = pHenmaeHenkousikibetukey;
    }

    public void setHenmaeHrkKaisuu(C_Hrkkaisuu pHenmaeHrkKaisuu) {
        henmaeHrkKaisuu = pHenmaeHrkKaisuu;
    }

    public void setIkkatuNyknUmu(C_UmuKbn pIkkatuNyknUmu) {
        ikkatuNyknUmu = pIkkatuNyknUmu;
    }

    public void setNyknJskStartYm(BizDateYM pNyknJskStartYm) {
        nyknJskStartYm = pNyknJskStartYm;
    }

    public void setNyknJskEndYm(BizDateYM pNyknJskEndYm) {
        nyknJskEndYm = pNyknJskEndYm;
    }

    public void setNyknJskRenno(int pNyknJskRenno) {
        nyknJskRenno = pNyknJskRenno;
    }

    public void setNyknJskRyosyuYmd(BizDate pNyknJskRyosyuYmd) {
        nyknJskRyosyuYmd = pNyknJskRyosyuYmd;
    }

    public void setNyknJskJytKaisuuY(int pNyknJskJytKaisuuY) {
        nyknJskJytKaisuuY = pNyknJskJytKaisuuY;
    }

    public void setNyknJskJytKaisuuM(int pNyknJskJytKaisuuM) {
        nyknJskJytKaisuuM = pNyknJskJytKaisuuM;
    }

    public void setNyknJskRysKwsrate(BizNumber pNyknJskRysKwsrate) {
        nyknJskRysKwsrate = pNyknJskRysKwsrate;
    }

    public void setKihrkpSeisanRenno(int pKihrkpSeisanRenno) {
        kihrkpSeisanRenno = pKihrkpSeisanRenno;
    }

    public void setKihrkpSeisanJytYm(BizDateYM pKihrkpSeisanJytYm) {
        kihrkpSeisanJytYm = pKihrkpSeisanJytYm;
    }

    public void setKihrkpSeisanJytKaisuuY(int pKihrkpSeisanJytKaisuuY) {
        kihrkpSeisanJytKaisuuY = pKihrkpSeisanJytKaisuuY;
    }

    public void setKihrkpSeisanJytKaisuuM(int pKihrkpSeisanJytKaisuuM) {
        kihrkpSeisanJytKaisuuM = pKihrkpSeisanJytKaisuuM;
    }

    public void setMkkp(BizCurrency pMkkp) {
        mkkp = pMkkp;
    }

    public void setSeisanjiYenkansanKwsrate(BizNumber pSeisanjiYenkansanKwsrate) {
        seisanjiYenkansanKwsrate = pSeisanjiYenkansanKwsrate;
    }

    public void setKykSyouhnLst(List<KykSyouhnCommonParam> pKykSyouhnLst) {
        kykSyouhnLst = pKykSyouhnLst;
    }

    public void setZennouKoujyogakuKeisanParam(ZennouKoujyogakuKeisanParam pZennouKoujyogakuKeisanParam) {
        zennouKoujyogakuKeisanParam = pZennouKoujyogakuKeisanParam;
    }

    public void setHenmaeKykSyouhnLst(List<KykSyouhnCommonParam> pHenmaeKykSyouhnLst) {
        henmaeKykSyouhnLst = pHenmaeKykSyouhnLst;
    }

    public void setHenmaeZennouKoujyogakuKeisanParam(ZennouKoujyogakuKeisanParam pHenmaeZennouKoujyogakuKeisanParam) {
        henmaeZennouKoujyogakuKeisanParam = pHenmaeZennouKoujyogakuKeisanParam;
    }

    public void setYoupJytStartYm(BizDateYM pYoupJytStartYm) {
        youpJytStartYm = pYoupJytStartYm;
    }

    public void setNykkeiro(C_Nykkeiro pNykkeiro) {
        nykkeiro = pNykkeiro;
    }

    public C_ErrorKbn exec(KhozenCommonParam pKCParam,
        String pSyono, C_KjsymnytblhensyuusyoriKbn pSyoriKbn, BizDate pSyoriYmd) {

        kinouId = pKCParam.getFunctionId();
        userId  = pKCParam.getUserID();
        sysTime = BizDate.getSysDateTimeMilli();

        C_KinouKbn kinouKbn = kinou.getKinouKbn();

        IT_KykKihon kykKihon = null;
        IT_AnsyuKihon ansyuKihon = null;

        if (C_KinouKbn.ONLINE.eq(kinouKbn)) {

            kykKihon = hozenDomManager.getKykKihon(pSyono);

            if (kykKihon == null) {
                throw new CommonBizAppException(
                    "契約基本テーブルが取得できませんでした。 証券番号 ＝ " + pSyono);
            }

            ansyuKihon = hozenDomManager.getAnsyuKihon(pSyono);

            if (ansyuKihon == null) {
                throw new CommonBizAppException(
                    "案内収納基本テーブルが取得できませんでした。 証券番号 ＝ " + pSyono);
            }
        }
        else {

            kykKihon = pKCParam.getBatchKeiyakuKihon();

            ansyuKihon = pKCParam.getBatchAnsyuKihon();
        }

        List<KykSyouhnCommonParam> kykSyouhnCommonParamList = getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU,
            kykSyouhnLst);

        if (kykSyouhnCommonParamList.size() == 0) {
            throw new CommonBizAppException(
                "契約商品テーブルが取得できませんでした。 証券番号 ＝ " + pSyono);
        }

        KykSyouhnCommonParam syuKykSyouhnInfo = kykSyouhnCommonParamList.get(0);

        BM_SyouhnZokusei syouhnZokusei = bizDomManager.getSyouhnZokusei(syuKykSyouhnInfo.getSyouhncd(),
            syuKykSyouhnInfo.getSyouhnsdno());
        if (syouhnZokusei == null) {
            throw new CommonBizAppException(
                "商品属性マスタが取得できませんでした。 証券番号 ＝ " + pSyono);
        }

        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        if (hhknSya == null) {
            throw new CommonBizAppException(
                "被保険者テーブルが取得できませんでした。 証券番号 ＝ " + pSyono);
        }

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        if (kykSonotaTkyk == null) {
            throw new CommonBizAppException("契約その他特約テーブルが取得できませんでした。 証券番号 ＝  " + pSyono);
        }

        KykSyouhnCommonParam syuKykSyouhnRirekiInfo = null;

        if (henmaeKykSyouhnLst != null && henmaeKykSyouhnLst.size() != 0) {

            List<KykSyouhnCommonParam> syuKykSyouhnRirekiLst = getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU,
                henmaeKykSyouhnLst);

            if (syuKykSyouhnRirekiLst.size() == 0) {
                throw new CommonBizAppException("変更前契約商品テーブルが取得できませんでした。 証券番号 ＝ " + pSyono);
            }

            syuKykSyouhnRirekiInfo = syuKykSyouhnRirekiLst.get(0);
        }
        else {

            if (
                C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_KYKHENKOU.eq(pSyoriKbn) ||
                (C_KjsymnytblhensyuusyoriKbn.YOUPHANEI.eq(pSyoriKbn) &&
                    (IKhozenCommonConstants.KINOUID_HARAIKATAHENKOU.equals(kinouId)
                        ))) {

                throw new CommonBizAppException(
                    "更新前の契約商品リストが設定されていません。 証券番号 ＝ " + pSyono);
            }
        }

        List<BizDateY> koujyoSymNendoLst      = new ArrayList<>();
        List<Integer> koujyoSymJytKaisuuLst   = new ArrayList<>();
        List<BizDateYM> syoumeiStartYmLst     = new ArrayList<>();
        List<BizDateYM> syoumeiEndYmLst       = new ArrayList<>();
        List<C_UmuKbn> zennouUmukbnLst       = new ArrayList<>();
        List<NyknjiKoujyoSymNaiyouBean> nyknjiKoujyoSymNaiyouBeanLst = new ArrayList<>();

        BizDateYM seisanStartYm = null;
        BizDateYM seisanEndYm = null;
        int kihrkpsisnkkn = 0;

        if (C_KjsymnytblhensyuusyoriKbn.NYUUKINHANEI.eq(pSyoriKbn)
            || C_KjsymnytblhensyuusyoriKbn.YOUPHANEI.eq(pSyoriKbn)
            || C_KjsymnytblhensyuusyoriKbn.NYUUKINTORIKESI.eq(pSyoriKbn)) {

            C_Hrkkaisuu hanteiHrkKaisuu = C_Hrkkaisuu.BLNK;
            C_UmuKbn zennouUmukbn = C_UmuKbn.NONE;

            if (C_Hrkkaisuu.BLNK.eq(henmaeHrkKaisuu)) {
                hanteiHrkKaisuu = kykKihon.getHrkkaisuu();
            }
            else {
                hanteiHrkKaisuu = henmaeHrkKaisuu;
            }

            if (zennouKoujyogakuKeisanParam != null) {

                zennouUmukbn = C_UmuKbn.ARI;
            }

            //            if (C_UmuKbn.ARI.eq(ikkatuNyknUmu)
            //                && kinouId.equals(IKhozenCommonConstants.KINOUID_SIHARAIKEKKATORIKOMI)) {
            //                koujyoSymJytKaisuuLst.add(nyknJskJytKaisuuY * 12 + nyknJskJytKaisuuM);
            //                syoumeiStartYmLst.add(nyknJskStartYm);
            //                syoumeiEndYmLst.add(nyknJskEndYm);
            //
            //                if (nyknJskStartYm.getBizDateY().compareTo(nyknJskRyosyuYmd.getBizDateY()) < 0) {
            //                    koujyoSymNendoLst.add(nyknJskRyosyuYmd.getBizDateY());
            //                }
            //                else {
            //                    koujyoSymNendoLst.add(nyknJskStartYm.getBizDateY());
            //                }
            //            }

            if (C_Hrkkaisuu.TUKI.eq(hanteiHrkKaisuu)
                && kinouId.equals(IKhozenCommonConstants.KINOUID_HARAIKATAHENKOU)) {
                koujyoSymJytKaisuuLst.add(nyknJskJytKaisuuY * 12 + nyknJskJytKaisuuM);
                syoumeiStartYmLst.add(nyknJskStartYm);
                syoumeiEndYmLst.add(nyknJskEndYm);
                zennouUmukbnLst.add(zennouUmukbn);

                if (youpJytStartYm.getBizDateY().compareTo(nyknJskRyosyuYmd.getBizDateY()) < 0) {
                    koujyoSymNendoLst.add(nyknJskRyosyuYmd.getBizDateY());
                }
                else {
                    koujyoSymNendoLst.add(youpJytStartYm.getBizDateY());
                }
            }

            else {
                if (C_Hrkkaisuu.ITIJI.eq(hanteiHrkKaisuu)) {

                    koujyoSymNendoLst.add(nyknJskStartYm.getBizDateY());
                    koujyoSymJytKaisuuLst.add(1);
                    syoumeiStartYmLst.add(nyknJskStartYm);
                    syoumeiEndYmLst.add(nyknJskEndYm);
                    zennouUmukbnLst.add(zennouUmukbn);
                }
                else if (C_Hrkkaisuu.HALFY.eq(hanteiHrkKaisuu) || C_Hrkkaisuu.NEN.eq(hanteiHrkKaisuu)) {

                    koujyoSymNendoLst.add(nyknJskRyosyuYmd.getBizDateY());

                    koujyoSymJytKaisuuLst.add((nyknJskJytKaisuuY * 12 + nyknJskJytKaisuuM) /
                        Integer.parseInt(hanteiHrkKaisuu.getValue()));
                    syoumeiStartYmLst.add(nyknJskStartYm);
                    syoumeiEndYmLst.add(nyknJskEndYm);
                    zennouUmukbnLst.add(zennouUmukbn);

                }
                else if (C_Hrkkaisuu.TUKI.eq(hanteiHrkKaisuu)) {
                    if (nyknJskEndYm.getBizDateY().compareTo(nyknJskRyosyuYmd.getBizDateY()) <= 0) {
                        koujyoSymNendoLst.add(nyknJskRyosyuYmd.getBizDateY());
                        koujyoSymJytKaisuuLst.add(nyknJskJytKaisuuY * 12 + nyknJskJytKaisuuM);
                        syoumeiStartYmLst.add(nyknJskStartYm);
                        syoumeiEndYmLst.add(nyknJskEndYm);
                        zennouUmukbnLst.add(zennouUmukbn);
                    }
                    else {
                        BizDate symStartYmd = BizDate.valueOf(nyknJskStartYm + "01");
                        BizDateY syoumeiY = null;
                        if (symStartYmd.getBizDateY().compareTo(nyknJskRyosyuYmd.getBizDateY()) > 0) {
                            syoumeiY = symStartYmd.getBizDateY();
                        }
                        else {
                            syoumeiY = nyknJskRyosyuYmd.getBizDateY();
                        }
                        BizDate symEndYmd = null;

                        while (syoumeiY.compareTo(nyknJskEndYm.getBizDateY()) <= 0) {
                            if (nyknJskEndYm.getBizDateY().compareTo(syoumeiY) > 0) {
                                symEndYmd = BizDate.valueOf(syoumeiY + "1201");
                            }
                            else {
                                symEndYmd = BizDate.valueOf(nyknJskEndYm + "01");
                            }

                            koujyoSymNendoLst.add(syoumeiY);
                            koujyoSymJytKaisuuLst.add(calcMonths(symStartYmd, symEndYmd) + 1);
                            syoumeiStartYmLst.add(symStartYmd.getBizDateYM());
                            syoumeiEndYmLst.add(symEndYmd.getBizDateYM());
                            zennouUmukbnLst.add(zennouUmukbn);

                            symStartYmd = BizDate.valueOf((symStartYmd.getYear() + 1) + "0101");
                            syoumeiY = syoumeiY.addYears(1);
                        }
                    }
                }
                else {
                    throw new CommonBizAppException("想定外の払込回数です。 証券番号 ＝ " + pSyono
                        + " 払込回数 ＝ " + hanteiHrkKaisuu);
                }
            }
        }
        else if (C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_SYOUMETU.eq(pSyoriKbn)
            || C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_KYKHENKOU.eq(pSyoriKbn)) {

            seisanStartYm = kihrkpSeisanJytYm;
            seisanEndYm = kihrkpSeisanJytYm.addMonths(kihrkpSeisanJytKaisuuY * 12 + kihrkpSeisanJytKaisuuM
                - 1);
            kihrkpsisnkkn = kihrkpSeisanJytKaisuuY * 12 + kihrkpSeisanJytKaisuuM;

            nyknjiKoujyoSymNaiyouBeanLst = editKoujyonaiyouTblDao.getNyknjiKoujyoSymNaiyou(pSyono, seisanStartYm,
                seisanEndYm, C_SyutkKbn.SYU);

            if (nyknjiKoujyoSymNaiyouBeanLst.size() == 0) {

                if (kinouId.equals(IKhozenCommonConstants.KINOUID_SIHARAIKEKKATORIKOMI)) {

                }
                else{
                    throw new CommonBizAppException("主契約控除証明内容テーブルが取得できませんでした。 証券番号 ＝ "
                        + pSyono + " " + seisanStartYm + " ≦ 証明終了年月 ≦ " + seisanEndYm);
                }
            }

            for (NyknjiKoujyoSymNaiyouBean nyknjiKoujyoSymNaiyouBean : nyknjiKoujyoSymNaiyouBeanLst) {

                C_UmuKbn zennouUmukbn = C_UmuKbn.NONE;
                BizDateYM syoumeiStartym = null;

                IT_Zennou zennou = editKoujyonaiyouTblDao.getZennou(ansyuKihon,
                    nyknjiKoujyoSymNaiyouBean.getZennoukaisiymd(), nyknjiKoujyoSymNaiyouBean.getZennourenno());

                if (zennou != null) {

                    zennouUmukbn = C_UmuKbn.ARI;
                }

                if (C_UmuKbn.ARI.eq(zennouUmukbn) && zennouKoujyogakuKeisanParam == null) {

                    throw new CommonBizAppException("前納用控除証明額計算パラメータが設定されていません。 証券番号 ＝ " + pSyono);
                }

                if (BizDateUtil.compareYm(nyknjiKoujyoSymNaiyouBean.getSyoumeistartym(), seisanStartYm) == BizDateUtil.COMPARE_LESSER) {

                    syoumeiStartym = seisanStartYm;
                }
                else {

                    syoumeiStartym = nyknjiKoujyoSymNaiyouBean.getSyoumeistartym();
                }

                int seisanTukisuu = calcMonths(BizDate.valueOf(syoumeiStartym, 1),
                    BizDate.valueOf(nyknjiKoujyoSymNaiyouBean.getSyoumeiendym() , 1)) + 1;

                JtKaisukeisan jtKaisukeisan = SWAKInjector.getInstance(JtKaisukeisan.class);

                jtKaisukeisan.exec(0, seisanTukisuu, nyknjiKoujyoSymNaiyouBean.getHrkkaisuu());

                koujyoSymNendoLst.add(BizDateY.valueOf(nyknjiKoujyoSymNaiyouBean.getKoujyosyoumeinnd()));
                koujyoSymJytKaisuuLst.add(jtKaisukeisan.getJyutoukaisuu());
                syoumeiStartYmLst.add(syoumeiStartym);
                syoumeiEndYmLst.add(nyknjiKoujyoSymNaiyouBean.getSyoumeiendym());
                zennouUmukbnLst.add(zennouUmukbn);
            }
        }
        else {
            throw new CommonBizAppException("想定外の控除証明内容TBL編集処理区分です。  証券番号＝"
                + pSyono + " 控除証明内容TBL編集処理区分 ＝ " + pSyoriKbn);
        }

        C_TekiyouseidoKbn seidoKbn = C_TekiyouseidoKbn.NEWSD;

        if (C_KjsymnytblhensyuusyoriKbn.NYUUKINHANEI.eq(pSyoriKbn)
            || C_KjsymnytblhensyuusyoriKbn.YOUPHANEI.eq(pSyoriKbn)) {
            koujyoSymNaiyouRecKbn = C_KoujyosymnaiyourecKbn.HKRNK;
        }
        else if (C_KjsymnytblhensyuusyoriKbn.NYUUKINTORIKESI.eq(pSyoriKbn)) {
            koujyoSymNaiyouRecKbn = C_KoujyosymnaiyourecKbn.NKTRKS;
        }
        else if (C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_SYOUMETU.eq(pSyoriKbn)) {
            koujyoSymNaiyouRecKbn = C_KoujyosymnaiyourecKbn.MKKHKR_SMT;
        }
        else if (C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_KYKHENKOU.eq(pSyoriKbn)) {
            koujyoSymNaiyouRecKbn = C_KoujyosymnaiyourecKbn.MKKHKR_KYKHK;
        }

        //                if (C_KjsymnytblhensyuusyoriKbn.ITIBUMUKOU.eq(pSyoriKbn)) {
        //
        //                    if (!kykSyouhnRireki.getPmnjtkkbn().eq(kykSyouhnSyu.getPmnjtkkbn())) {
        //                        pmnjTkHnkUmu = C_UmuKbn.ARI;
        //                    }
        //
        //                    JtKaisukeisan jtKaisukeisan = SWAKInjector.getInstance(JtKaisukeisan.class);
        //
        //                    jtKaisukeisan.exec(kihrkpSeisanJytKaisuuY, kihrkpSeisanJytKaisuuM,
        //                        kykKihon.getHrkkaisuu());
        //
        //                    koujyoSymJytKaisuuLst.add(jtKaisukeisan.getJyutoukaisuu());
        //                }

        C_KoujyosyoumeipKbn syuKoujyosyoumeipKbn = C_KoujyosyoumeipKbn.BLNK;

        if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getZeiseitkkktkykhukaumu())) {

            syuKoujyosyoumeipKbn = C_KoujyosyoumeipKbn.NENKIN;
        }
        else {
            syuKoujyosyoumeipKbn = syouhnZokusei.getKoujyosyoumeipkbn();
        }

        //        BizCurrency koujyogk    = BizCurrency.valueOf(0);
        //        int koujyoSymJytKaisuu  = 0;
        //        BizDateYM syoumeiStartYm = null;
        //        BizDateYM syoumeiEndYm = null;

        for (int index = 0; index < koujyoSymNendoLst.size(); index++) {

            NyknjiKoujyoSymNaiyouBean nyknjiKoujyoSymNaiyouBean = null;

            C_KoujyosyoumeipKbn syuKoujyosyoumeipKbnTemp = syuKoujyosyoumeipKbn;

            BizNumber kawaseRate = nyknJskRysKwsrate;

            BizDateYM kihrkpssKaisiYm = null;

            BizDateYM kihrkpssEndYm = null;

            if (nyknjiKoujyoSymNaiyouBeanLst.size() != 0) {

                nyknjiKoujyoSymNaiyouBean = nyknjiKoujyoSymNaiyouBeanLst.get(index);

                syuKoujyosyoumeipKbnTemp = nyknjiKoujyoSymNaiyouBean.getKoujyosyoumeipkbn();

                kawaseRate = seisanjiYenkansanKwsrate;

                kihrkpssKaisiYm = seisanStartYm;

                kihrkpssEndYm = seisanEndYm;
            }
            else {

                kihrkpsisnkkn = 0;
            }

            if (C_UmuKbn.ARI.eq(zennouUmukbnLst.get(index)) &&
                !(C_Hrkkaisuu.NEN.eq(kykKihon.getHrkkaisuu()) &&
                    (C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_SYOUMETU.eq(pSyoriKbn) ||
                        C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_KYKHENKOU.eq(pSyoriKbn)))) {

                KjsymgkKsnKekkaBean kjsymgkKsnKekkaBean = keisanZennouKoujyogk(
                    pSyono,
                    syoumeiStartYmLst.get(index),
                    syoumeiEndYmLst.get(index),
                    koujyoSymJytKaisuuLst.get(index),
                    pSyoriKbn,
                    nyknjiKoujyoSymNaiyouBean,
                    kykKihon);

                KeisanZennouKoujyogaku keisanZennouKoujyogaku = SWAKInjector.getInstance(KeisanZennouKoujyogaku.class);

                KhZennouKoujyogakuBean khZennouKoujyogakuBean = keisanZennouKoujyogaku.doHaibunZennouKoujyogaku(
                    kjsymgkKsnKekkaBean.getKoujyosyoumeigk(), syuKoujyosyoumeipKbnTemp, kykSyouhnLst);

                List<KhShgtZennouKoujyogakuBean> khShgtZennouKoujyogakuBeanLst = khZennouKoujyogakuBean
                    .getKhShgtZennouKoujyogakuBeanList();

                for (KhShgtZennouKoujyogakuBean khShgtZennouKoujyogakuBean : khShgtZennouKoujyogakuBeanLst) {

                    insertKoujyonaiyouTbl(pSyono,
                        khShgtZennouKoujyogakuBean.getSyouhncd(),
                        koujyoSymNendoLst.get(index),
                        syoumeiStartYmLst.get(index),
                        syoumeiEndYmLst.get(index),
                        khShgtZennouKoujyogakuBean.getKoujyosyoumeipkbn(),
                        seidoKbn,
                        khShgtZennouKoujyogakuBean.getKhShgtZennouKoujyogaku(),
                        kjsymgkKsnKekkaBean.getKeisanhukahyoujikbn(),
                        kjsymgkKsnKekkaBean.getKeisanhukariyuucd(),
                        kykKihon);
                }
            }
            else {
                KjsymgkKsnKekkaBean kjsymgkKsnKekkaBean = keisanSyuKoujyogk(pSyono,
                    pSyoriYmd,
                    kykKihon,
                    syuKykSyouhnInfo,
                    syuKykSyouhnRirekiInfo,
                    kykSonotaTkyk,
                    hhknSya,
                    pSyoriKbn,
                    koujyoSymJytKaisuuLst.get(index),
                    syoumeiStartYmLst.get(index),
                    syoumeiEndYmLst.get(index),
                    nyknjiKoujyoSymNaiyouBean,
                    kawaseRate,
                    mkkp,
                    kihrkpssKaisiYm,
                    kihrkpssEndYm,
                    kihrkpsisnkkn);

                insertKoujyonaiyouTbl(pSyono,
                    syuKykSyouhnInfo.getSyouhncd(),
                    koujyoSymNendoLst.get(index),
                    syoumeiStartYmLst.get(index),
                    syoumeiEndYmLst.get(index),
                    syuKoujyosyoumeipKbnTemp,
                    seidoKbn,
                    kjsymgkKsnKekkaBean.getKoujyosyoumeigk(),
                    kjsymgkKsnKekkaBean.getKeisanhukahyoujikbn(),
                    kjsymgkKsnKekkaBean.getKeisanhukariyuucd(),
                    kykKihon);
            }
        }

        //        List<KykSyouhnCommonParam> kykSyouhnCommonParamTkLst = new ArrayList<>();
        //
        //        if (BizUtil.isBlank(henmaeHenkousikibetukey)) {
        //            List<IT_KykSyouhn> kykSyouhnTkLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);
        //            if (kykSyouhnTkLst != null && kykSyouhnTkLst.size() != 0) {
        //                kykSyouhnCommonParamTkLst.addAll(kykSyouhnTkLst);
        //            }
        //
        //        }
        //        else {
        //            C_YuukousyoumetuKbn yuukousyoumetuKbn;
        //            if (kinouId.equals(IKhozenCommonConstants.KINOUID_HUKKATU)) {
        //                yuukousyoumetuKbn = null;
        //            }
        //            else {
        //                yuukousyoumetuKbn = C_YuukousyoumetuKbn.YUUKOU;
        //            }
        //            List<IT_KykSyouhnRireki> kykSyouhnRirekiTkLst = editKoujyonaiyouTblDao.getKykSyouhnRirekis(kykKihon,
        //                henmaeHenkousikibetukey,
        //                yuukousyoumetuKbn,
        //                C_SyutkKbn.TK);
        //            if (kykSyouhnRirekiTkLst != null && kykSyouhnRirekiTkLst.size() != 0) {
        //                kykSyouhnCommonParamTkLst.addAll(kykSyouhnRirekiTkLst);
        //            }
        //        }
        //
        //        for (KykSyouhnCommonParam kykSyouhnCommonParamTk : kykSyouhnCommonParamTkLst) {
        //
        //            for(int index = 0; index < koujyoSymNendoLst.size(); index++) {
        //
        //                if (koujyoSymJytKaisuuLst.size() == 0) {
        //                    koujyoSymJytKaisuu = 0;
        //                }
        //                else {
        //                    koujyoSymJytKaisuu = koujyoSymJytKaisuuLst.get(index);
        //                }
        //
        //                syoumeiStartYm = syoumeiStartYmLst.get(index);
        //                syoumeiEndYm   = syoumeiEndYmLst.get(index);
        //
        //                koujyogk = keisanTkykKoujyogk(pSyono,
        //                    pSyoriYmd,
        //                    kykKihon,
        //                    kykSyouhnCommonParamTk,
        //                    hhknSya,
        //                    pSyoriKbn,
        //                    koujyoSymJytKaisuu);
        //
        //                if (koujyogk.compareTo(BizCurrency.valueOf(0)) > 0) {
        //                    BM_SyouhnZokusei syouhnZokuseiTk;
        //                    if (kykSyouhnCommonParamTk instanceof IT_KykSyouhn ) {
        //                        syouhnZokuseiTk = ((IT_KykSyouhn)kykSyouhnCommonParamTk).getSyouhnZokusei();
        //                    }
        //                    else {
        //                        syouhnZokuseiTk = ((IT_KykSyouhnRireki)kykSyouhnCommonParamTk).getSyouhnZokusei();
        //                    }
        //
        //                    insertKoujyonaiyouTbl(pSyono,
        //                        kykSyouhnCommonParamTk.getSyouhncd(),
        //                        koujyoSymNendoLst.get(index),
        //                        syoumeiStartYm,
        //                        syoumeiEndYm,
        //                        syouhnZokuseiTk.getKoujyosyoumeipkbn(),
        //                        seidoKbn,
        //                        koujyogk,
        //                        kykKihon);
        //                }
        //            }
        //        }

        return C_ErrorKbn.OK;
    }

    private int getKoujyonaiyouRenno(IT_KykKihon pKykKihon, String pSyouhnCd) {

        Integer renNo = editKoujyonaiyouTblDao.getKoujyoSymNaiyouMaxRenno3ketaBySyouhncd(pKykKihon, pSyouhnCd);

        if (renNo == null) {
            renNo = 1;
        }
        else {
            renNo = renNo + 1;
        }

        return renNo;
    }

    private KjsymgkKsnKekkaBean keisanSyuKoujyogk(String pSyono,
        BizDate pSyoriYmd,
        IT_KykKihon pKykKihon,
        KykSyouhnCommonParam pKykSyouhnCommonParam,
        KykSyouhnCommonParam pHenmaeKykSyouhnCommonParam,
        IT_KykSonotaTkyk pKykSonotaTkyk,
        IT_HhknSya pHhknSya,
        C_KjsymnytblhensyuusyoriKbn pSyoriKbn,
        int pKjySymJytKaisuu,
        BizDateYM pSyoumeistartym,
        BizDateYM pSyoumeiendym,
        NyknjiKoujyoSymNaiyouBean pNyknjiKoujyoSymNaiyouBean,
        BizNumber pKawaseRate,
        BizCurrency pMkkp,
        BizDateYM pKihrkpssKaisiYm,
        BizDateYM pKihrkpssEndYm,
        int pKihrkpssKikann) {

        BizCurrency koujyoSyoumeiGk = BizCurrency.valueOf(0);
        C_DispKbn keisanHukaHyoujiKbn = C_DispKbn.HIHYOUJI;
        String keisanHukaRiyuuCd = "";
        BizCurrency hokenryou = BizCurrency.valueOf(0);
        C_Tuukasyu rstuukasyu = C_Tuukasyu.BLNK;


        if (C_KjsymnytblhensyuusyoriKbn.NYUUKINHANEI.eq(pSyoriKbn)
            || C_KjsymnytblhensyuusyoriKbn.YOUPHANEI.eq(pSyoriKbn)
            || C_KjsymnytblhensyuusyoriKbn.NYUUKINTORIKESI.eq(pSyoriKbn)) {

            if (C_Hrkkaisuu.ITIJI.eq(pKykKihon.getHrkkaisuu())) {

                List<IT_NyknJissekiRireki> nyknJissekiRirekiLst =
                    pKykKihon.getNyknJissekiRirekisByJyutoustartymNyktrksflg(nyknJskStartYm);

                if (nyknJissekiRirekiLst == null || nyknJissekiRirekiLst.size() == 0) {

                    throw new CommonBizAppException(
                        "入金実績履歴テーブルが取得できませんでした。 証券番号 ＝ " + pSyono +
                        " 充当開始年月 ＝ " + nyknJskStartYm +
                        " 入金取消フラグ ≠ " + C_Nyktrksflg.TORIKESI);
                }

                if (!C_Tuukasyu.JPY.eq(nyknJissekiRirekiLst.get(0).getRstuukasyu())) {

                    koujyoSyoumeiGk = nyknJissekiRirekiLst.get(0).getYenkansannyknkingk();

                } else {

                    koujyoSyoumeiGk = nyknJissekiRirekiLst.get(0).getRsgaku();
                }
            }
            else if (C_Nykkeiro.HKNKIN.eq(nykkeiro)) {
                koujyoSyoumeiGk = BizCurrency.valueOf(0);
                keisanHukaHyoujiKbn = C_DispKbn.HYOUJI;
                keisanHukaRiyuuCd = KeisanKoujyogakuConstants.KEISANHUKARIYUUCD_SIBOUMISYUUPNYKN;
            } else {

                //            if (C_UmuKbn.ARI.eq(ikkatuNyknUmu)
                //                && kinouId.equals(IKhozenCommonConstants.KINOUID_SIHARAIKEKKATORIKOMI)) {
                //
                //                KeisanIkkatuPGk keisanIkkatuPGk = SWAKInjector.getInstance(KeisanIkkatuPGk.class);
                //                KeisanIkkatuPGkBean keisanIkkatuPGkBean = SWAKInjector.getInstance(KeisanIkkatuPGkBean.class);
                //
                //                keisanIkkatuPGkBean.setSyouhnCd(pKykSyouhn.getSyouhncd());
                //                keisanIkkatuPGkBean.setSyouhnsdNo(pKykSyouhn.getSyouhnsdno());
                //                keisanIkkatuPGkBean.setRyouritusdNo(pKykSyouhn.getRyouritusdno());
                //                keisanIkkatuPGkBean.setHokenryou(pKykSyouhn.getHokenryou());
                //                keisanIkkatuPGkBean.setKeikamon(pKjySymJytKaisuu);
                //                keisanIkkatuPGkBean.setHrkkaisuu(pKykKihon.getHrkkaisuu());
                //                keisanIkkatuPGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
                //                keisanIkkatuPGk.exec(keisanIkkatuPGkBean, false);
                //
                //                koujyoSyoumeiGk = keisanIkkatuPGk.getIkkatuP();
                //            }
                if (kinouId.equals(IKhozenCommonConstants.KINOUID_HARAIKATAHENKOU) ) {

                    hokenryou = pHenmaeKykSyouhnCommonParam.getHokenryou();
                }
                else {
                    hokenryou = pKykSyouhnCommonParam.getHokenryou();
                }

                GetasPRsTuuka getasPRsTuuka = SWAKInjector.getInstance(GetasPRsTuuka.class);

                getasPRsTuuka.editRyousyuuTuukaSyuruiHantei(pKykSyouhnCommonParam.getKyktuukasyu(),
                    pKykSonotaTkyk.getYennykntkhkumu(), pKykSonotaTkyk.getGaikanykntkhkumu());

                rstuukasyu = getasPRsTuuka.getRstuukasyu();

                if (C_Tuukasyu.JPY.eq(rstuukasyu)) {

                    HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);

                    C_Tuukasyu tuukasyu = henkanTuuka.henkanTuukaTypeToKbn(hokenryou.getType());

                    if (!C_Tuukasyu.JPY.eq(tuukasyu)) {

                        if (pKawaseRate == null || pKawaseRate.compareTo(BizNumber.valueOf(0)) == 0) {

                            throw new CommonBizAppException("円換算レートが設定されていません。 証券番号 ＝ " + pSyono);

                        }

                        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
                        hokenryou = keisanGaikakanzan.exec(C_Tuukasyu.JPY, hokenryou, pKawaseRate, C_HasuusyoriKbn.SUTE);
                    }
                }
                else {
                    throw new CommonBizAppException("保険料を通貨換算できません。 証券番号 ＝ " + pSyono);
                }

                koujyoSyoumeiGk = hokenryou.multiply(pKjySymJytKaisuu);
            }
        }
        else {
            if (C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_SYOUMETU.eq(pSyoriKbn)) {

                HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
                C_Tuukasyu hknryTuukasyu = henkanTuuka.henkanTuukaTypeToKbn(pKykSyouhnCommonParam.getHokenryou().getType());
                KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);


                if (!C_Tuukasyu.JPY.eq(hknryTuukasyu) &&
                    (pKawaseRate == null || pKawaseRate.compareTo(BizNumber.ZERO) == 0)) {

                    throw new CommonBizAppException("精算時円換算レートが設定されていません。 証券番号 ＝ " + pSyono);
                }

                if (C_Hrkkaisuu.TUKI.eq(pNyknjiKoujyoSymNaiyouBean.getHrkkaisuu())) {

                    if (!C_Tuukasyu.JPY.eq(hknryTuukasyu)) {

                        koujyoSyoumeiGk = keisanGaikakanzan.exec(C_Tuukasyu.JPY, pKykSyouhnCommonParam.getHokenryou(),
                            pKawaseRate, C_HasuusyoriKbn.AGE).multiply(pKjySymJytKaisuu);
                    }
                    else {
                        koujyoSyoumeiGk = pKykSyouhnCommonParam.getHokenryou().multiply(pKjySymJytKaisuu);
                    }
                }
                else {

                    if (BizDateUtil.compareYm(pSyoumeistartym, pKihrkpssKaisiYm) == BizDateUtil.COMPARE_EQUAL &&
                        BizDateUtil.compareYm(pSyoumeiendym, pKihrkpssEndYm) == BizDateUtil.COMPARE_EQUAL) {

                        if (!C_Tuukasyu.JPY.eq(hknryTuukasyu)) {

                            koujyoSyoumeiGk = keisanGaikakanzan.exec(C_Tuukasyu.JPY, pMkkp, pKawaseRate, C_HasuusyoriKbn.AGE);
                        }
                        else {

                            koujyoSyoumeiGk = pMkkp;
                        }
                    }
                    else {

                        if (BizDateUtil.compareYm(pSyoumeistartym, pKihrkpssKaisiYm) == BizDateUtil.COMPARE_EQUAL) {

                            JtKaisukeisan jtKaisukeisan = SWAKInjector.getInstance(JtKaisukeisan.class);

                            jtKaisukeisan.exec(0, pKihrkpssKikann, pKykKihon.getHrkkaisuu());

                            int jyutoukaisuu = jtKaisukeisan.getJyutoukaisuu();

                            if (!C_Tuukasyu.JPY.eq(hknryTuukasyu)) {

                                koujyoSyoumeiGk = keisanGaikakanzan.exec(C_Tuukasyu.JPY, pMkkp, pKawaseRate, C_HasuusyoriKbn.AGE).subtract(
                                    keisanGaikakanzan.exec(C_Tuukasyu.JPY, pKykSyouhnCommonParam.getHokenryou(), pKawaseRate,
                                    C_HasuusyoriKbn.AGE).multiply(jyutoukaisuu));
                            }
                            else {

                                koujyoSyoumeiGk = pMkkp.subtract(pKykSyouhnCommonParam.getHokenryou().multiply(jyutoukaisuu));
                            }
                        }
                        else {

                            if (!C_Tuukasyu.JPY.eq(hknryTuukasyu)) {

                                koujyoSyoumeiGk = keisanGaikakanzan.exec(C_Tuukasyu.JPY, pKykSyouhnCommonParam.getHokenryou(),
                                    pKawaseRate, C_HasuusyoriKbn.AGE);
                            }
                            else {

                                koujyoSyoumeiGk = pKykSyouhnCommonParam.getHokenryou();
                            }
                        }
                    }
                }
            }
            else if (C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_KYKHENKOU.eq(pSyoriKbn)) {

                //                if (pKykSyouhn.getPmnjtkkbn().eq(C_PmnjtkKbn.NONE)
                //                    && !pKykSyouhnRireki.getPmnjtkkbn().eq(C_PmnjtkKbn.NONE)) {
                //                    pmnjTkHnkUmu = C_UmuKbn.ARI;
                //                }

                C_KykhnkKbn kykhnkKbn = null;
                if (kinouId.equals(IKhozenCommonConstants.KINOUID_GENGAKU)) {
                    kykhnkKbn = C_KykhnkKbn.GENGAKU;
                }
                else {
                    kykhnkKbn = C_KykhnkKbn.BLNK;
                }

                if (!C_UmuKbn.ARI.eq(pmnjTkHnkUmu)) {
                    if (C_KykhnkKbn.GENGAKU.eq(kykhnkKbn)) {

                        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
                        C_Tuukasyu hknryTuukasyua =  henkanTuuka.henkanTuukaTypeToKbn(pKykSyouhnCommonParam.getHokenryou().getType());
                        KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                        if (!C_Tuukasyu.JPY.eq(hknryTuukasyua) &&
                            (pKawaseRate == null || pKawaseRate.compareTo(BizNumber.ZERO) == 0)) {

                            throw new CommonBizAppException("精算時円換算レートが設定されていません。 証券番号 ＝ " + pSyono);
                        }

                        if (C_Hrkkaisuu.TUKI.eq(pNyknjiKoujyoSymNaiyouBean.getHrkkaisuu())) {

                            if (!C_Tuukasyu.JPY.eq(hknryTuukasyua)) {

                                BizCurrency psagk = pHenmaeKykSyouhnCommonParam.getHokenryou()
                                    .subtract(pKykSyouhnCommonParam.getHokenryou());

                                if (BizDateUtil.compareYm(pSyoumeistartym, pKihrkpssKaisiYm) == BizDateUtil.COMPARE_EQUAL &&
                                    BizDateUtil.compareYm(pSyoumeiendym, pKihrkpssEndYm) == BizDateUtil.COMPARE_EQUAL) {

                                    koujyoSyoumeiGk = keisanGaikakanzan.exec(C_Tuukasyu.JPY, pMkkp, pKawaseRate, C_HasuusyoriKbn.AGE);
                                }
                                else {

                                    if (BizDateUtil.compareYm(pSyoumeistartym, pKihrkpssKaisiYm) == BizDateUtil.COMPARE_EQUAL) {

                                        int jyutoukaisuu = pKihrkpssKikann - pKjySymJytKaisuu;

                                        koujyoSyoumeiGk = keisanGaikakanzan.exec(C_Tuukasyu.JPY, pMkkp, pKawaseRate, C_HasuusyoriKbn.AGE).subtract(
                                            keisanGaikakanzan.exec(C_Tuukasyu.JPY, psagk, pKawaseRate, C_HasuusyoriKbn.AGE).multiply(jyutoukaisuu));
                                    }
                                    else {

                                        koujyoSyoumeiGk = keisanGaikakanzan.exec(C_Tuukasyu.JPY, psagk, pKawaseRate,
                                            C_HasuusyoriKbn.AGE).multiply(pKjySymJytKaisuu);
                                    }
                                }
                            }
                            else {

                                koujyoSyoumeiGk = pHenmaeKykSyouhnCommonParam.getHokenryou().multiply(pKjySymJytKaisuu)
                                    .subtract(pKykSyouhnCommonParam.getHokenryou().multiply(pKjySymJytKaisuu));
                            }
                        }
                        else {

                            if (BizDateUtil.compareYm(pSyoumeistartym, pKihrkpssKaisiYm) == BizDateUtil.COMPARE_EQUAL &&
                                BizDateUtil.compareYm(pSyoumeiendym, pKihrkpssEndYm) == BizDateUtil.COMPARE_EQUAL) {

                                if (!C_Tuukasyu.JPY.eq(hknryTuukasyua)) {

                                    koujyoSyoumeiGk = keisanGaikakanzan.exec(C_Tuukasyu.JPY, pMkkp, pKawaseRate, C_HasuusyoriKbn.AGE);
                                }
                                else {

                                    koujyoSyoumeiGk = pMkkp;
                                }
                            }
                            else {

                                BizCurrency psagk = pHenmaeKykSyouhnCommonParam.getHokenryou().subtract(pKykSyouhnCommonParam.getHokenryou());

                                if (BizDateUtil.compareYm(pSyoumeistartym, pKihrkpssKaisiYm) == BizDateUtil.COMPARE_EQUAL) {

                                    JtKaisukeisan jtKaisukeisan = SWAKInjector.getInstance(JtKaisukeisan.class);

                                    jtKaisukeisan.exec(0, pKihrkpssKikann, pKykKihon.getHrkkaisuu());

                                    int jyutoukaisuu = jtKaisukeisan.getJyutoukaisuu();

                                    if (!C_Tuukasyu.JPY.eq(hknryTuukasyua)) {

                                        koujyoSyoumeiGk = keisanGaikakanzan.exec(C_Tuukasyu.JPY, pMkkp, pKawaseRate, C_HasuusyoriKbn.AGE).subtract(
                                            keisanGaikakanzan.exec(C_Tuukasyu.JPY, psagk, pKawaseRate, C_HasuusyoriKbn.AGE).multiply(jyutoukaisuu));
                                    }
                                    else {

                                        koujyoSyoumeiGk = pMkkp.subtract(psagk.multiply(jyutoukaisuu));
                                    }
                                }
                                else {

                                    if (!C_Tuukasyu.JPY.eq(hknryTuukasyua)) {

                                        koujyoSyoumeiGk = keisanGaikakanzan.exec(C_Tuukasyu.JPY, psagk, pKawaseRate, C_HasuusyoriKbn.AGE);
                                    }
                                    else {

                                        koujyoSyoumeiGk = psagk;
                                    }
                                }
                            }
                        }

                    }
                }
                //                else {
                //                    KeisanIkkatuPGk keisanIkkatuPGk = SWAKInjector.getInstance(KeisanIkkatuPGk.class);
                //                    KeisanIkkatuPGkBean keisanIkkatuPGkBean = SWAKInjector.getInstance(KeisanIkkatuPGkBean.class);
                //
                //                    keisanIkkatuPGkBean.setSyouhnCd(pKykSyouhn.getSyouhncd());
                //                    keisanIkkatuPGkBean.setSyouhnsdNo(pKykSyouhn.getSyouhnsdno());
                //                    keisanIkkatuPGkBean.setRyouritusdNo(pKykSyouhn.getRyouritusdno());
                //                    keisanIkkatuPGkBean.setHokenryou(pKykSyouhnRireki.getHokenryou());
                //                    keisanIkkatuPGkBean.setKeikamon(pKjySymJytKaisuu);
                //                    keisanIkkatuPGkBean.setHrkkaisuu(pKykKihon.getHrkkaisuu());
                //                    keisanIkkatuPGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
                //
                //                    keisanIkkatuPGk.exec(keisanIkkatuPGkBean, false);
                //                    BizCurrency henkoumaeMikeikaP = pKykSyouhnRireki.getHokenryou().subtract(
                //                        keisanIkkatuPGk.getIkkatuP());
                //
                //                    keisanIkkatuPGk = SWAKInjector.getInstance(KeisanIkkatuPGk.class);
                //                    keisanIkkatuPGkBean = SWAKInjector.getInstance(KeisanIkkatuPGkBean.class);
                //
                //                    keisanIkkatuPGkBean.setSyouhnCd(pKykSyouhn.getSyouhncd());
                //                    keisanIkkatuPGkBean.setSyouhnsdNo(pKykSyouhn.getSyouhnsdno());
                //                    keisanIkkatuPGkBean.setRyouritusdNo(pKykSyouhn.getRyouritusdno());
                //                    keisanIkkatuPGkBean.setHokenryou(pKykSyouhn.getHokenryou());
                //                    keisanIkkatuPGkBean.setKeikamon(pKjySymJytKaisuu);
                //                    keisanIkkatuPGkBean.setHrkkaisuu(pKykKihon.getHrkkaisuu());
                //                    keisanIkkatuPGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
                //
                //                    keisanIkkatuPGk.exec(keisanIkkatuPGkBean, false);
                //                    BizCurrency henkougoMikeikaP = pKykSyouhn.getHokenryou().subtract(
                //                        keisanIkkatuPGk.getIkkatuP());
                //
                //                    koujyoSyoumeiGk = henkoumaeMikeikaP.subtract(henkougoMikeikaP);
                //                }
            }
            //            else if (C_KjsymnytblhensyuusyoriKbn.ITIBUMUKOU.eq(pSyoriKbn)) {
            //
            //                BizCurrency kiharaP;
            //                if (C_UmuKbn.ARI.eq(pmnjTkHnkUmu)) {
            //                    kiharaP = pKykSyouhnRireki.getHokenryou().subtract(pKykSyouhn.getHokenryou());
            //                }
            //                else {
            //                    kiharaP = BizCurrency.valueOf(0);
            //                }
            //
            //                koujyoSyoumeiGk = kiharaP.multiply(pKjySymJytKaisuu);
            //            }
        }

        KjsymgkKsnKekkaBean kjsymgkKsnKekkaBean = SWAKInjector.getInstance(KjsymgkKsnKekkaBean.class);
        kjsymgkKsnKekkaBean.setKoujyosyoumeigk(koujyoSyoumeiGk);
        kjsymgkKsnKekkaBean.setKeisanhukahyoujikbn(keisanHukaHyoujiKbn);
        kjsymgkKsnKekkaBean.setKeisanhukariyuucd(keisanHukaRiyuuCd);

        return kjsymgkKsnKekkaBean;
    }

    //    private BizCurrency keisanTkykKoujyogk(String pSyono,
    //        BizDate pSyoriYmd,
    //        IT_KykKihon pKykKihon,
    //        KykSyouhnCommonParam pKykSyouhnCommonParam,
    //        IT_HhknSya pHhknSya,
    //        C_KjsymnytblhensyuusyoriKbn pSyoriKbn,
    //        int pKjySymJytKaisuu) {
    //
    //        BizCurrency koujyoSyoumeiGk = BizCurrency.valueOf(0);
    //
    //        if (C_KjsymnytblhensyuusyoriKbn.NYUUKINHANEI.eq(pSyoriKbn)
    //            || C_KjsymnytblhensyuusyoriKbn.YOUPHANEI.eq(pSyoriKbn)
    //            || C_KjsymnytblhensyuusyoriKbn.NYUUKINTORIKESI.eq(pSyoriKbn)) {
    //            if (C_UmuKbn.ARI.eq(ikkatuNyknUmu)
    //                && kinouId.equals(IKhozenCommonConstants.KINOUID_SIHARAIKEKKATORIKOMI)) {
    //
    //                KeisanIkkatuPGk keisanIkkatuPGk = SWAKInjector.getInstance(KeisanIkkatuPGk.class);
    //                KeisanIkkatuPGkBean keisanIkkatuPGkBean = SWAKInjector.getInstance(KeisanIkkatuPGkBean.class);
    //
    //                keisanIkkatuPGkBean.setSyouhnCd(pKykSyouhnCommonParam.getSyouhncd());
    //                keisanIkkatuPGkBean.setSyouhnsdNo(pKykSyouhnCommonParam.getSyouhnsdno());
    //                keisanIkkatuPGkBean.setRyouritusdNo(pKykSyouhnCommonParam.getRyouritusdno());
    //                keisanIkkatuPGkBean.setHokenryou(pKykSyouhnCommonParam.getHokenryou());
    //                keisanIkkatuPGkBean.setKeikamon(pKjySymJytKaisuu);
    //                keisanIkkatuPGkBean.setHrkkaisuu(pKykKihon.getHrkkaisuu());
    //                keisanIkkatuPGkBean.setTkiktbrisyuruiKbn(C_TkiktbrisyuruiKbn.NONE);
    //
    //                keisanIkkatuPGk.exec(keisanIkkatuPGkBean, false);
    //
    //                koujyoSyoumeiGk = keisanIkkatuPGk.getIkkatuP();
    //            }
    //            else {
    //                koujyoSyoumeiGk = pKykSyouhnCommonParam.getHokenryou().multiply(pKjySymJytKaisuu);
    //            }
    //        }
    //        else {
    //            IT_KykSyouhn kykSyouhn = null;
    //            if (C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_KYKHENKOU.eq(pSyoriKbn)
    //                || C_KjsymnytblhensyuusyoriKbn.ITIBUMUKOU.eq(pSyoriKbn)
    //                || C_KjsymnytblhensyuusyoriKbn.TUITYOUKIN_HENKANKIN.eq(pSyoriKbn)) {
    //
    //                List<IT_KykSyouhn> kykSyouhnLst = pKykKihon.getKykSyouhnsBySyouhncdSyouhnsdno(
    //                    pKykSyouhnCommonParam.getSyouhncd(), pKykSyouhnCommonParam.getSyouhnsdno());
    //
    //                if (kykSyouhnLst != null && kykSyouhnLst.size() != 0) {
    //                    kykSyouhn = kykSyouhnLst.get(0);
    //                }
    //                else {
    //                    if (C_KjsymnytblhensyuusyoriKbn.TUITYOUKIN_HENKANKIN.eq(pSyoriKbn)) {
    //                        throw new CommonBizAppException(
    //                            "契約商品TBLが取得できませんでした。 証券番号 ＝ " + pSyono +
    //                            " 商品コード ＝ " + pKykSyouhnCommonParam.getSyouhncd() +
    //                            " 商品世代番号 ＝ " + pKykSyouhnCommonParam.getSyouhnsdno());
    //                    }
    //                }
    //            }
    //
    //            if (C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_SYOUMETU.eq(pSyoriKbn)) {
    //
    //                SyouhnTaniKeisanMsyMkeiP syouhnTaniKeisanMsyMkeiP =
    //                    SWAKInjector.getInstance(SyouhnTaniKeisanMsyMkeiP.class);
    //
    //                syouhnTaniKeisanMsyMkeiP.setSyono(pSyono);
    //                syouhnTaniKeisanMsyMkeiP.setSyouhncd(pKykSyouhnCommonParam.getSyouhncd());
    //                syouhnTaniKeisanMsyMkeiP.setSyouhnSdno(pKykSyouhnCommonParam.getSyouhnsdno());
    //                syouhnTaniKeisanMsyMkeiP.setKeiyakubi(pKykSyouhnCommonParam.getKykymd());
    //                syouhnTaniKeisanMsyMkeiP.setHknkknSmnkbn(pKykSyouhnCommonParam.getHknkknsmnkbn());
    //                syouhnTaniKeisanMsyMkeiP.setHknkkn(pKykSyouhnCommonParam.getHknkkn());
    //                syouhnTaniKeisanMsyMkeiP.setHrkkkn(pKykSyouhnCommonParam.getHrkkkn());
    //                syouhnTaniKeisanMsyMkeiP.setHaraimanYMD(pKykSyouhnCommonParam.getHaraimanymd());
    //                syouhnTaniKeisanMsyMkeiP.setHhknNen(pKykSyouhnCommonParam.getHhknnen());
    //                syouhnTaniKeisanMsyMkeiP.setHhknSei(pHhknSya.getHhknsei());
    //                syouhnTaniKeisanMsyMkeiP.setHrkKaisuu(pKykKihon.getHrkkaisuu());
    //                syouhnTaniKeisanMsyMkeiP.setP(pKykSyouhnCommonParam.getHokenryou());
    //                syouhnTaniKeisanMsyMkeiP.setS(pKykSyouhnCommonParam.getKihons());
    //                syouhnTaniKeisanMsyMkeiP.setKykTuukaSyu(pKykSyouhnCommonParam.getKyktuukasyu());
    //                syouhnTaniKeisanMsyMkeiP.setYoteiRiritu(pKykSyouhnCommonParam.getYoteiriritu());
    //                syouhnTaniKeisanMsyMkeiP.setRyourituKbn(C_RyourituKbn.KOUHURI);
    //                syouhnTaniKeisanMsyMkeiP.setHaitouKbn(pKykKihon.getHaitoukbn());
    //                syouhnTaniKeisanMsyMkeiP.setKeisanYMD(calcKjnYmd);
    //                syouhnTaniKeisanMsyMkeiP.setDenymd(pSyoriYmd);
    //                syouhnTaniKeisanMsyMkeiP.setJkipJytYM(henmaeJkipJytYm);
    //                syouhnTaniKeisanMsyMkeiP.setJskJkipJytYM(henmaeJkipJytYm);
    //                syouhnTaniKeisanMsyMkeiP.setMsymkeipksnKbn(C_MsymkeipksnKbn.KOUJYOSYOUMEI);
    //                syouhnTaniKeisanMsyMkeiP.exec();
    //                koujyoSyoumeiGk = syouhnTaniKeisanMsyMkeiP.getMikeikaP();
    //            }
    //            else if (C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_KYKHENKOU.eq(pSyoriKbn)) {
    //
    //                C_KykhnkKbn kykhnkKbn = C_KykhnkKbn.BLNK;
    //
    //                if (kykSyouhn == null) {
    //                    kykhnkKbn = C_KykhnkKbn.KAIYAKU;
    //                }
    //                else {
    //                    if (pKykSyouhnCommonParam.getKihons().compareTo(kykSyouhn.getKihons()) > 0) {
    //                        kykhnkKbn = C_KykhnkKbn.GENGAKU;
    //                    }
    //                }
    //
    //                if (kinouId.equals(IKhozenCommonConstants.KINOUID_SIHARAIKEKKATORIKOMI)) {
    //
    //                    if (C_KykhnkKbn.KAIYAKU.eq(kykhnkKbn)) {
    //                        SyouhnTaniKeisanMsyMkeiP syouhnTaniKeisanMsyMkeiP =
    //                            SWAKInjector.getInstance(SyouhnTaniKeisanMsyMkeiP.class);
    //
    //                        syouhnTaniKeisanMsyMkeiP.setSyono(pSyono);
    //                        syouhnTaniKeisanMsyMkeiP.setSyouhncd(pKykSyouhnCommonParam.getSyouhncd());
    //                        syouhnTaniKeisanMsyMkeiP.setSyouhnSdno(pKykSyouhnCommonParam.getSyouhnsdno());
    //                        syouhnTaniKeisanMsyMkeiP.setKeiyakubi(pKykSyouhnCommonParam.getKykymd());
    //                        syouhnTaniKeisanMsyMkeiP.setHknkknSmnkbn(pKykSyouhnCommonParam.getHknkknsmnkbn());
    //                        syouhnTaniKeisanMsyMkeiP.setHknkkn(pKykSyouhnCommonParam.getHknkkn());
    //                        syouhnTaniKeisanMsyMkeiP.setHrkkkn(pKykSyouhnCommonParam.getHrkkkn());
    //                        syouhnTaniKeisanMsyMkeiP.setHaraimanYMD(pKykSyouhnCommonParam.getHaraimanymd());
    //                        syouhnTaniKeisanMsyMkeiP.setHhknNen(pKykSyouhnCommonParam.getHhknnen());
    //                        syouhnTaniKeisanMsyMkeiP.setHhknSei(pHhknSya.getHhknsei());
    //                        syouhnTaniKeisanMsyMkeiP.setHrkKaisuu(pKykKihon.getHrkkaisuu());
    //                        syouhnTaniKeisanMsyMkeiP.setP(pKykSyouhnCommonParam.getHokenryou());
    //                        syouhnTaniKeisanMsyMkeiP.setS(pKykSyouhnCommonParam.getKihons());
    //                        syouhnTaniKeisanMsyMkeiP.setKykTuukaSyu(pKykSyouhnCommonParam.getKyktuukasyu());
    //                        syouhnTaniKeisanMsyMkeiP.setYoteiRiritu(pKykSyouhnCommonParam.getYoteiriritu());
    //                        syouhnTaniKeisanMsyMkeiP.setRyourituKbn(C_RyourituKbn.KOUHURI);
    //                        syouhnTaniKeisanMsyMkeiP.setHaitouKbn(pKykKihon.getHaitoukbn());
    //                        syouhnTaniKeisanMsyMkeiP.setKeisanYMD(calcKjnYmd);
    //                        syouhnTaniKeisanMsyMkeiP.setDenymd(pSyoriYmd);
    //                        syouhnTaniKeisanMsyMkeiP.setJkipJytYM(henmaeJkipJytYm);
    //                        syouhnTaniKeisanMsyMkeiP.setJskJkipJytYM(henmaeJkipJytYm);
    //                        syouhnTaniKeisanMsyMkeiP.setMsymkeipksnKbn(C_MsymkeipksnKbn.KOUJYOSYOUMEI);
    //                        syouhnTaniKeisanMsyMkeiP.exec();
    //                        koujyoSyoumeiGk = syouhnTaniKeisanMsyMkeiP.getMikeikaP();
    //                    }
    //                }
    //            }
    //            else if (C_KjsymnytblhensyuusyoriKbn.ITIBUMUKOU.eq(pSyoriKbn)) {
    //                BizCurrency kiharaP;
    //                if (kykSyouhn == null) {
    //                    kiharaP = pKykSyouhnCommonParam.getHokenryou();
    //                }
    //                else {
    //                    if (C_UmuKbn.ARI.eq(pmnjTkHnkUmu)) {
    //                        kiharaP = pKykSyouhnCommonParam.getHokenryou().subtract(kykSyouhn.getHokenryou());
    //                    }
    //                    else {
    //                        kiharaP = BizCurrency.valueOf(0);
    //                    }
    //                }
    //
    //                koujyoSyoumeiGk = kiharaP.multiply(pKjySymJytKaisuu);
    //            }
    //            else {
    //                if (kykSyouhn.getHokenryou().compareTo(pKykSyouhnCommonParam.getHokenryou()) > 0) {
    //                    koujyoSyoumeiGk = kykSyouhn.getHokenryou().subtract(pKykSyouhnCommonParam.getHokenryou())
    //                        .multiply(pKjySymJytKaisuu);
    //                    koujyoSymNaiyouRecKbn = C_KoujyosymnaiyourecKbn.TUITYOUKIN;
    //                }
    //                else if (kykSyouhn.getHokenryou().compareTo(pKykSyouhnCommonParam.getHokenryou()) < 0) {
    //                    koujyoSyoumeiGk = pKykSyouhnCommonParam.getHokenryou().subtract(
    //                        kykSyouhn.getHokenryou()).multiply(pKjySymJytKaisuu);
    //                    koujyoSymNaiyouRecKbn = C_KoujyosymnaiyourecKbn.HENKANKIN;
    //                }
    //            }
    //        }
    //
    //        return koujyoSyoumeiGk;
    //    }

    private void insertKoujyonaiyouTbl(String pSyono,
        String pSyouhncd,
        BizDateY pNendo,
        BizDateYM pSyoumeiStartYm,
        BizDateYM pSyoumeiEndYm,
        C_KoujyosyoumeipKbn pKoujyoSyoumeiPKbn,
        C_TekiyouseidoKbn pSeidoKbn,
        BizCurrency pKoujyoSyoumeiGk,
        C_DispKbn pKeisanhukahyoujikbn,
        String pKeisanhukariyuucd,
        IT_KykKihon pKykKihon) {

        int renNo = 0;

        if (koujyoSymNaiyouRenNo == 0) {

            renNo = getKoujyonaiyouRenno(pKykKihon, pSyouhncd);
        }
        else {

            renNo = koujyoSymNaiyouRenNo + 1;
        }

        IT_KoujyoSymNaiyou koujyoSymNaiyo = pKykKihon.createKoujyoSymNaiyou();

        koujyoSymNaiyo.setSyouhncd(pSyouhncd);
        koujyoSymNaiyo.setRenno3keta(renNo);
        koujyoSymNaiyo.setKoujyosyoumeinnd(String.valueOf(pNendo));
        koujyoSymNaiyo.setSyoumeistartym(pSyoumeiStartYm);
        koujyoSymNaiyo.setSyoumeiendym(pSyoumeiEndYm);
        koujyoSymNaiyo.setKoujyosyoumeipkbn(pKoujyoSyoumeiPKbn);
        koujyoSymNaiyo.setTekiyouseidokbn(pSeidoKbn);
        koujyoSymNaiyo.setKoujyosymnaiyoureckbn(koujyoSymNaiyouRecKbn);
        koujyoSymNaiyo.setKoujyosyoumeigk(pKoujyoSyoumeiGk);
        koujyoSymNaiyo.setJyutoustartym(nyknJskStartYm);
        koujyoSymNaiyo.setNyknjskrrkrenno(nyknJskRenno);
        koujyoSymNaiyo.setKihrkpssrrkrenno(kihrkpSeisanRenno);
        koujyoSymNaiyo.setKjsmhakkouzumiflg(C_Kjsmhakkouzumiflg.BLNK);
        koujyoSymNaiyo.setGyoumuKousinKinou(kinouId);
        koujyoSymNaiyo.setGyoumuKousinsyaId(userId);
        koujyoSymNaiyo.setGyoumuKousinTime(sysTime);
        koujyoSymNaiyo.setSakujyoflg(C_Delflag.BLNK);
        if (zennouKoujyogakuKeisanParam != null) {

            koujyoSymNaiyo.setZennoukaisiymd(zennouKoujyogakuKeisanParam.getZennoukaisiymd());
            koujyoSymNaiyo.setZennourenno(zennouKoujyogakuKeisanParam.getZennourenno());
        }
        koujyoSymNaiyo.setKeisanhukahyoujikbn(pKeisanhukahyoujikbn);
        koujyoSymNaiyo.setKeisanhukariyuucd(pKeisanhukariyuucd);

        koujyoSymNaiyouRenNo = renNo;

        BizPropertyInitializer.initialize(koujyoSymNaiyo);
    }

    private int calcMonths(BizDate pStartYmd, BizDate pEndYmd) {

        BizDateSpan spanYmd = BizDateUtil.calcDifference(pEndYmd, pStartYmd);

        int months = spanYmd.getYears() * 12 + spanYmd.getMonths();

        return months;
    }

    private KjsymgkKsnKekkaBean keisanZennouKoujyogk(
        String pSyono,
        BizDateYM pSyoumeistartym,
        BizDateYM pSyoumeiendym,
        int pKoujyoSymJytKaisuu,
        C_KjsymnytblhensyuusyoriKbn pSyoriKbn,
        NyknjiKoujyoSymNaiyouBean pNyknjiKoujyoSymNaiyouBean,
        IT_KykKihon pKykKihon) {

        BizCurrency koujyoSyoumeiGk = BizCurrency.valueOf(0);
        C_DispKbn keisanHukaHyoujiKbn = C_DispKbn.HIHYOUJI;
        String keisanHukaRiyuuCd = "";
        KeisanZennouKoujyogaku keisanZennouKoujyogaku = SWAKInjector.getInstance(KeisanZennouKoujyogaku.class);
        KoujyoSyoumeiUtil koujyoSyoumeiUtil = SWAKInjector.getInstance(KoujyoSyoumeiUtil.class);
        int syomeiKaisuuY = 0;
        int syomeiKaisuuM = 0;

        if (C_KjsymnytblhensyuusyoriKbn.NYUUKINHANEI.eq(pSyoriKbn)
            || C_KjsymnytblhensyuusyoriKbn.YOUPHANEI.eq(pSyoriKbn)
            || C_KjsymnytblhensyuusyoriKbn.NYUUKINTORIKESI.eq(pSyoriKbn)) {

            if (C_Hrkkaisuu.TUKI.eq(zennouKoujyogakuKeisanParam.getHrkkaisuu())) {
                syomeiKaisuuM = pKoujyoSymJytKaisuu;
            }
            else {
                syomeiKaisuuY = pKoujyoSymJytKaisuu;
            }

            keisanZennouKoujyogaku.setKjsmyouYenKawaserate(zennouKoujyogakuKeisanParam.getKjsmyouyenknsnkawaserate());

            koujyoSyoumeiGk = keisanZennouKoujyogaku.getZennouKoujyogaku(
                zennouKoujyogakuKeisanParam.getKjsmyouzennounyuukinkgk(),
                zennouKoujyogakuKeisanParam.getKjsmyouzennoukikanm(),
                zennouKoujyogakuKeisanParam.getKjsmyouzennoukaisiymd(),
                zennouKoujyogakuKeisanParam.getHrkp(),
                zennouKoujyogakuKeisanParam.getHrkkaisuu(),
                pSyoumeistartym,
                syomeiKaisuuY,
                syomeiKaisuuM);
        }
        else if (C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_SYOUMETU.eq(pSyoriKbn)) {

            keisanHukaRiyuuCd = koujyoSyoumeiUtil.chkTkZennouStkkntySeisan(pKykKihon,
                pNyknjiKoujyoSymNaiyouBean.getSyoumeistartym(), pNyknjiKoujyoSymNaiyouBean.getSyoumeiendym(),
                kihrkpSeisanRenno, kihrkpSeisanJytYm);

            if (!BizUtil.isBlank(keisanHukaRiyuuCd)) {

                keisanHukaHyoujiKbn = C_DispKbn.HYOUJI;
            }
            else {

                koujyoSyoumeiGk = keisanZennouKoujyogaku.keisanTukiZennouSymt(
                    zennouKoujyogakuKeisanParam.getKjsmyouzennounyuukinkgk(),
                    zennouKoujyogakuKeisanParam.getHrkp(),
                    zennouKoujyogakuKeisanParam.getKjsmyouzennoukaisiymd(),
                    zennouKoujyogakuKeisanParam.getKjsmyouzennoukikanm(),
                    pNyknjiKoujyoSymNaiyouBean.getSyoumeistartym(),
                    pNyknjiKoujyoSymNaiyouBean.getSyoumeiendym(),
                    pSyoumeistartym);
            }
        }
        else if (C_KjsymnytblhensyuusyoriKbn.MIKEIKAP_KYKHENKOU.eq(pSyoriKbn)) {

            if (C_Hrkkaisuu.TUKI.eq(pNyknjiKoujyoSymNaiyouBean.getHrkkaisuu())) {
                if (henmaeZennouKoujyogakuKeisanParam == null) {

                    throw new CommonBizAppException("変更前の前納用控除証明額計算パラメータが設定されていません。 証券番号 ＝ "
                        + pSyono);
                }

                keisanHukaRiyuuCd = koujyoSyoumeiUtil.chkTkZennouStkkntySeisan(pKykKihon,
                    pNyknjiKoujyoSymNaiyouBean.getSyoumeistartym(), pNyknjiKoujyoSymNaiyouBean.getSyoumeiendym(),
                    kihrkpSeisanRenno, kihrkpSeisanJytYm);

                if (!BizUtil.isBlank(keisanHukaRiyuuCd)) {

                    keisanHukaHyoujiKbn = C_DispKbn.HYOUJI;
                }
                else {

                    koujyoSyoumeiGk = keisanZennouKoujyogaku.keisanTukiZennouGngk(
                        henmaeZennouKoujyogakuKeisanParam.getKjsmyouzennounyuukinkgk(),
                        zennouKoujyogakuKeisanParam.getKjsmyouzennounyuukinkgk(),
                        henmaeZennouKoujyogakuKeisanParam.getHrkp(),
                        zennouKoujyogakuKeisanParam.getHrkp(),
                        zennouKoujyogakuKeisanParam.getKjsmyouzennoukaisiymd(),
                        zennouKoujyogakuKeisanParam.getKjsmyouzennoukikanm(),
                        pNyknjiKoujyoSymNaiyouBean.getSyoumeistartym(),
                        pNyknjiKoujyoSymNaiyouBean.getSyoumeiendym(),
                        pSyoumeistartym);
                }
            }
        }

        KjsymgkKsnKekkaBean kjsymgkKsnKekkaBean = SWAKInjector.getInstance(KjsymgkKsnKekkaBean.class);
        kjsymgkKsnKekkaBean.setKoujyosyoumeigk(koujyoSyoumeiGk);
        kjsymgkKsnKekkaBean.setKeisanhukahyoujikbn(keisanHukaHyoujiKbn);
        kjsymgkKsnKekkaBean.setKeisanhukariyuucd(keisanHukaRiyuuCd);

        return kjsymgkKsnKekkaBean;
    }

    private List<KykSyouhnCommonParam> getKykSyouhnsBySyutkkbn(C_SyutkKbn pSyutkKbn,
        List<KykSyouhnCommonParam> pKykSyouhnCommonParamLst) {

        List<KykSyouhnCommonParam> KykSyouhnCommonParamList = new ArrayList<>();

        for (KykSyouhnCommonParam kykSyouhnCommonParam : pKykSyouhnCommonParamLst) {
            if (pSyutkKbn.eq(kykSyouhnCommonParam.getSyutkkbn())) {
                KykSyouhnCommonParamList.add(kykSyouhnCommonParam);
            }
        }
        return KykSyouhnCommonParamList;
    }
}
