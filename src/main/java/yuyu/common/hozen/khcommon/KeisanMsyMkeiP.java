package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_MisyuptsKbn;
import yuyu.def.classification.C_Nyktrksflg;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TykzentykgoKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.sorter.SortIT_NyknJissekiRireki;

/**
 * 契約保全 契約保全共通 未収Ｐ・未経過Ｐ計算
 */
public class KeisanMsyMkeiP {

    private BizCurrency misyuP;

    private BizCurrency misyuPGaika;

    private int misyuPJyutouKaisuuY;

    private int misyuPJyutouKaisuuM;

    private BizDateYM misyuPJyutouYM;

    private MisyuuPBean[] misyuuPBeans;

    private BizCurrency mikeikaP;

    private int mikeikaPJyutouKaisuuY;

    private int mikeikaPJyutouKaisuuM;

    private BizDateYM mikeikaPJyutouYM;

    private MiKeikaPBean[] miKeikaPBeans;

    @Inject
    private SetOutoubi setOutoubi;

    @Inject
    private JtKaisukeisan jtkaisukeisan;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private SortIT_NyknJissekiRireki sortNyknJissekiRireki;

    public KeisanMsyMkeiP() {
        super();
    }

    public BizCurrency getMisyuP() {
        return misyuP;
    }

    public BizCurrency getMisyuPGaika() {
        return misyuPGaika;
    }

    public int getMisyuPJyutouKaisuuY() {
        return misyuPJyutouKaisuuY;
    }

    public int getMisyuPJyutouKaisuuM() {
        return misyuPJyutouKaisuuM;
    }

    public BizDateYM getMisyuPJyutouYM() {
        return misyuPJyutouYM;
    }

    public MisyuuPBean[] getMisyuuPBeans() {
        return misyuuPBeans;
    }

    public BizCurrency getMikeikaP() {
        return mikeikaP;
    }

    public int getMikeikaPJyutouKaisuuY() {
        return mikeikaPJyutouKaisuuY;
    }

    public int getMikeikaPJyutouKaisuuM() {
        return mikeikaPJyutouKaisuuM;
    }

    public BizDateYM getMikeikaPJyutouYM() {
        return mikeikaPJyutouYM;
    }

    public MiKeikaPBean[] getMiKeikaPBeans() {
        return miKeikaPBeans;
    }

    public void exec(String pSyoNo, BizDate pKeisanYMD, BizDateYM pJkipjytYM, BizCurrency pHrkp,
        C_MisyuptsKbn pMisyuPTsKbn) {

        keisanMsyMkeiP(pSyoNo, pKeisanYMD, pJkipjytYM, pHrkp, pMisyuPTsKbn,
            BizCurrency.valueOf(0), 0, C_Hhknsei.BLNK, 0, false);

    }

    public void execKyknaiyouSitei(String pSyoNo, BizDate pKeisanYMD, BizDateYM pJkipjytYM, BizCurrency pHrkp,
        C_MisyuptsKbn pMisyuPTsKbn, BizCurrency pKihons, int pHhknnen, C_Hhknsei pHhknsei, int pHrkkkn) {

        keisanMsyMkeiP(pSyoNo, pKeisanYMD, pJkipjytYM, pHrkp, pMisyuPTsKbn,
            pKihons, pHhknnen, pHhknsei, pHrkkkn, true);

    }


    private void keisanMsyMkeiP(String pSyoNo, BizDate pKeisanYMD, BizDateYM pJkipjytYM, BizCurrency pHrkp,
        C_MisyuptsKbn pMisyuPTsKbn, BizCurrency pKihons, int pHhknnen, C_Hhknsei pHhknsei, int pHrkkkn,
        boolean pKykNaiyouSiteiFlg) {

        misyuP = BizCurrency.valueOf(0);
        misyuPJyutouKaisuuY = 0;
        misyuPJyutouKaisuuM = 0;
        misyuPJyutouYM = null;
        misyuuPBeans = null;
        mikeikaPJyutouKaisuuY = 0;
        mikeikaPJyutouKaisuuM = 0;
        mikeikaPJyutouYM = null;
        miKeikaPBeans = null;

        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(pSyoNo);
        if (ansyuKihon == null) {
            throw new CommonBizAppException("証券番号=" + pSyoNo);
        }

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyoNo);
        if (kykKihon == null) {
            throw new CommonBizAppException("証券番号=" + pSyoNo);
        }

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        if (syuKykSyouhnLst == null || syuKykSyouhnLst.size() == 0) {
            throw new CommonBizAppException("証券番号=" + pSyoNo);
        }

        C_Hrkkaisuu hrkKaisuu = kykKihon.getHrkkaisuu();
        BizDate kykYMD = syuKykSyouhnLst.get(0).getKykymd();
        BizDate haraimanYMD = syuKykSyouhnLst.get(0).getHaraimanymd();
        BizDateYM jkipJytYM = ansyuKihon.getJkipjytym();
        BizCurrency hrkP = kykKihon.getHrkp();
        C_Tuukasyu kykTuukasyu = syuKykSyouhnLst.get(0).getKyktuukasyu();
        BizDate fstPnyknYmd = kykKihon.getFstpnyknymd();

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        misyuPGaika = BizCurrency.valueOf(0,henkanTuuka.henkanTuukaKbnToType(kykTuukasyu));
        mikeikaP = BizCurrency.valueOf(0,hrkP.getType());

        if (C_Hrkkaisuu.ITIJI.eq(hrkKaisuu)) {
            return;
        }

        int keisanD = pKeisanYMD.getDay();
        int keiakuD = kykYMD.getDay();
        BizDate hanteiyouOutouYMD;

        if (keisanD >= keiakuD) {
            hanteiyouOutouYMD = pKeisanYMD;
        }
        else {
            BizDateYM hanteiyouOutouYM = pKeisanYMD.getBizDateYM().addMonths(-1);
            hanteiyouOutouYMD = BizDate.valueOf(hanteiyouOutouYM,keiakuD).getRekijyou();
        }

        BizDate kykOutouYMD = setOutoubi.exec(C_TykzentykgoKbn.TYKGO, kykYMD, hrkKaisuu, hanteiyouOutouYMD);

        BizDateYM kykOutouYM = kykOutouYMD.getBizDateYM();
        BizDateYM haraimanYM = haraimanYMD.getBizDateYM();

        BizDateYM sHrkKiYM;

        if (kykOutouYM.compareTo(haraimanYM) <= 0) {

            sHrkKiYM = kykOutouYM;
        }
        else {

            sHrkKiYM = haraimanYM;
        }

        int syohinHanteiKbn = SyouhinUtil.hantei(syuKykSyouhnLst.get(0).getSyouhncd());

        if (BizDateUtil.compareYm(pJkipjytYM, sHrkKiYM) == BizDateUtil.COMPARE_LESSER) {

            if (C_MisyuptsKbn.MITS.eq(pMisyuPTsKbn)) {

                return;
            }

            int misyuPJytGetusuu = sHrkKiYM.subtractMonths(pJkipjytYM);

            if (misyuPJytGetusuu > 0) {

                List<MisyuuPBean> misyuuPBeanLst = new ArrayList<>();
                List<MiKeikaPBean> miKeikaPBeanLst = new ArrayList<>();

                jtkaisukeisan.exec(0, misyuPJytGetusuu, hrkKaisuu);

                int jyutoukaisuu = jtkaisukeisan.getJyutoukaisuu();

                jkipJytYM = pJkipjytYM;

                KeisanGaikaP keisanGaikaP = SWAKInjector.getInstance(KeisanGaikaP.class);

                for (int i = 0; i < jyutoukaisuu; i++) {

                    MisyuuPBean misyuuPBean = new MisyuuPBean();

                    if (syohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
                        keisanGaikaP.exec(hrkP, kykTuukasyu, jkipJytYM, kykYMD, fstPnyknYmd);
                        misyuuPBean.setMisyuuP(hrkP);
                        misyuuPBean.setMisyuuPGaika(keisanGaikaP.getP());
                    }
                    else if (syohinHanteiKbn == SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN) {
                        if (C_Tuukasyu.JPY.eq(kykTuukasyu)) {

                            misyuuPBean.setMisyuuP(hrkP);
                            misyuuPBean.setMisyuuPGaika(BizCurrency.valueOf(0));
                        }
                        else {

                            misyuuPBean.setMisyuuP(BizCurrency.valueOf(0));
                            misyuuPBean.setMisyuuPGaika(hrkP);
                        }
                    }

                    misyuuPBean.setMsyPIkkatuNkUmu(C_UmuKbn.NONE);
                    misyuuPBean.setMsyPHrkKaisuu(hrkKaisuu);
                    if (C_Hrkkaisuu.NEN.eq(hrkKaisuu)) {

                        misyuuPBean.setMsyPJytKaisuuY(1);
                        misyuuPBean.setMsyPJytKaisuuM(0);
                    }
                    else {

                        misyuuPBean.setMsyPJytKaisuuY(0);
                        misyuuPBean.setMsyPJytKaisuuM(Integer.valueOf(hrkKaisuu.getValue()));
                    }
                    misyuuPBean.setMsyPJytYm(jkipJytYM);

                    jkipJytYM = jkipJytYM.addMonths(Integer.valueOf(hrkKaisuu.getValue()));

                    misyuuPBeanLst.add(misyuuPBean);
                }

                BizDateYM tukitanioutouYM = null;

                if (C_Hrkkaisuu.HALFY.eq(hrkKaisuu) || C_Hrkkaisuu.NEN.eq(hrkKaisuu)) {

                    BizDate tukitanioutouYmd = setOutoubi.exec(C_TykzentykgoKbn.TYKGO, kykYMD, C_Hrkkaisuu.TUKI, hanteiyouOutouYMD);
                    tukitanioutouYM = tukitanioutouYmd.getBizDateYM();

                    int jyuutoutukisuu = tukitanioutouYM.subtractMonths(pJkipjytYM);

                    jtkaisukeisan.exec(0, jyuutoutukisuu,hrkKaisuu);

                    int hasuugetu = jtkaisukeisan.getHasuutuki();

                    if (hasuugetu > 0) {

                        BizCurrency keikabunP = iktpcalcSyori(pSyoNo, BizCurrency.valueOf(0),
                            hrkKaisuu, hasuugetu, kykKihon.getTikiktbrisyuruikbn(),
                            pKihons, pHhknnen, pHhknsei, pHrkkkn, pKykNaiyouSiteiFlg);

                        MiKeikaPBean miKeikaPBean = new MiKeikaPBean();
                        miKeikaPBean.setMiKeikaP(hrkP.subtract(keikabunP));
                        miKeikaPBean.setMkeiPNykDenYmd(pKeisanYMD);
                        miKeikaPBean.setMkeiPHrkKaisuu(hrkKaisuu);
                        miKeikaPBean.setMkeiPJytKaisuuY(0);
                        miKeikaPBean.setMkeiPJytKaisuuM(Integer.valueOf(hrkKaisuu.getValue()) - hasuugetu);
                        miKeikaPBean.setMkeiPJytYm(jkipJytYM.addMonths(-1 * Integer.valueOf(hrkKaisuu.getValue())));

                        miKeikaPBeanLst.add(miKeikaPBean);
                    }
                }

                if (misyuuPBeanLst.size() != 0) {

                    misyuuPBeans = misyuuPBeanLst.toArray(new MisyuuPBean[misyuuPBeanLst.size()]);

                    for (int index = 0; index < misyuuPBeans.length; index++) {

                        misyuP = misyuP.add(misyuuPBeans[index].getMisyuuP());

                        misyuPGaika = misyuPGaika.add(misyuuPBeans[index].getMisyuuPGaika());

                        misyuPJyutouKaisuuY = misyuPJyutouKaisuuY + misyuuPBeans[index].getMsyPJytKaisuuY();

                        misyuPJyutouKaisuuM = misyuPJyutouKaisuuM + misyuuPBeans[index].getMsyPJytKaisuuM();
                    }

                    misyuPJyutouYM = pJkipjytYM;
                }

                if (miKeikaPBeanLst.size() != 0) {

                    miKeikaPBeans = miKeikaPBeanLst.toArray(new MiKeikaPBean[miKeikaPBeanLst.size()]);

                    mikeikaP = miKeikaPBeans[0].getMiKeikaP();
                    mikeikaPJyutouKaisuuY = 0;
                    mikeikaPJyutouKaisuuM = miKeikaPBeans[0].getMkeiPJytKaisuuM();
                    mikeikaPJyutouYM = tukitanioutouYM;
                }
            }
        }
        else {

            int mikeikaPJtKaisuuY = 0;
            int mikeikaPJtKaisuuM = 0;

            BizDate kykMtaniOutouYMD = setOutoubi.exec(
                C_TykzentykgoKbn.TYKGO, kykYMD, C_Hrkkaisuu.TUKI, hanteiyouOutouYMD);

            sHrkKiYM = kykMtaniOutouYMD.getBizDateYM();

            List<MiKeikaPBean> miKeikaPBeanLst = new ArrayList<>();

            List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = hozenDomManager.getKykKihon(pSyoNo)
                .getNyknJissekiRirekisByJyutouendymNyktrksflg(
                    sHrkKiYM, pJkipjytYM, C_Nyktrksflg.TORIKESI);

            nyknJissekiRirekiLst = sortNyknJissekiRireki.
                OrderIT_NyknJissekiRirekiByJyutoustartymAsc(nyknJissekiRirekiLst);

            for (IT_NyknJissekiRireki nyknJissekiRireki : nyknJissekiRirekiLst) {

                BizCurrency ryousyuuGk = BizCurrency.valueOf(0);

                C_Hrkkaisuu rrkHrkKaisuu = nyknJissekiRireki.getHrkkaisuu();
                C_UmuKbn rrkIktNyknUmu = nyknJissekiRireki.getIktnyuukinnumu();
                int rrkJytKaisuuM = nyknJissekiRireki.getJyutoukaisuum();
                int rrkJytKaisuuY = nyknJissekiRireki.getJyutoukaisuuy();
                BizDateYM rrkJytStartYM = nyknJissekiRireki.getJyutoustartym();
                BizDate rrkNykDenYMD = nyknJissekiRireki.getNykdenymd();
                C_TkiktbrisyuruiKbn tkiktbriSyuruiKbn = nyknJissekiRireki.getTikiktbrisyuruikbn();

                if (C_Hrkkaisuu.TUKI.eq(rrkHrkKaisuu)) {

                    if (C_UmuKbn.NONE.eq(rrkIktNyknUmu)) {

                        ryousyuuGk = pHrkp.multiply(rrkJytKaisuuM);
                    }

                    else {

                        ryousyuuGk = iktpcalcSyori(pSyoNo, pHrkp, C_Hrkkaisuu.TUKI, rrkJytKaisuuM, tkiktbriSyuruiKbn,
                            pKihons, pHhknnen, pHhknsei, pHrkkkn, pKykNaiyouSiteiFlg);

                    }
                }
                else if (C_Hrkkaisuu.HALFY.eq(rrkHrkKaisuu)) {

                    ryousyuuGk = pHrkp;
                }
                else if (C_Hrkkaisuu.NEN.eq(rrkHrkKaisuu)) {

                    ryousyuuGk = pHrkp;
                }

                mikeikaPJtKaisuuY = mikeikaPJtKaisuuY + rrkJytKaisuuY;
                mikeikaPJtKaisuuM = mikeikaPJtKaisuuM + rrkJytKaisuuM;

                if (BizDateUtil.compareYm(rrkJytStartYM, sHrkKiYM) == BizDateUtil.COMPARE_LESSER) {

                    int keikaGetusuu = sHrkKiYM.subtractMonths(rrkJytStartYM);

                    BizCurrency keikaRyousyuuGk = iktpcalcSyori(pSyoNo, pHrkp, rrkHrkKaisuu, keikaGetusuu, tkiktbriSyuruiKbn,
                        pKihons, pHhknnen, pHhknsei, pHrkkkn, pKykNaiyouSiteiFlg);

                    if (C_Hrkkaisuu.NEN.eq(rrkHrkKaisuu)) {

                        mikeikaPJtKaisuuY = mikeikaPJtKaisuuY - 1;

                        mikeikaPJtKaisuuM = mikeikaPJtKaisuuM + (12 - keikaGetusuu);
                    }
                    else {

                        mikeikaPJtKaisuuM = mikeikaPJtKaisuuM - keikaGetusuu;
                    }

                    MiKeikaPBean miKeikaPBean = new MiKeikaPBean();

                    miKeikaPBean.setMiKeikaP(ryousyuuGk.subtract(keikaRyousyuuGk));
                    miKeikaPBean.setMkeiPNykDenYmd(rrkNykDenYMD);
                    miKeikaPBean.setMkeiPHrkKaisuu(rrkHrkKaisuu);
                    miKeikaPBean.setMkeiPJytKaisuuY(0);
                    miKeikaPBean.setMkeiPJytKaisuuM(rrkJytKaisuuY * 12 + rrkJytKaisuuM - keikaGetusuu);

                    if (C_Hrkkaisuu.TUKI.eq(rrkHrkKaisuu)) {

                        miKeikaPBean.setMkeiPJytYm(rrkJytStartYM.addMonths(keikaGetusuu));
                    }
                    else {

                        miKeikaPBean.setMkeiPJytYm(rrkJytStartYM);
                    }

                    miKeikaPBeanLst.add(miKeikaPBean);
                }
                else {

                    MiKeikaPBean oMiKeikaPBean = new MiKeikaPBean();

                    oMiKeikaPBean.setMiKeikaP(ryousyuuGk);
                    oMiKeikaPBean.setMkeiPNykDenYmd(rrkNykDenYMD);
                    oMiKeikaPBean.setMkeiPHrkKaisuu(rrkHrkKaisuu);
                    oMiKeikaPBean.setMkeiPJytKaisuuY(rrkJytKaisuuY);
                    oMiKeikaPBean.setMkeiPJytKaisuuM(rrkJytKaisuuM);
                    oMiKeikaPBean.setMkeiPJytYm(rrkJytStartYM);

                    miKeikaPBeanLst.add(oMiKeikaPBean);
                }
            }

            if (miKeikaPBeanLst.size() != 0) {

                miKeikaPBeans = miKeikaPBeanLst.toArray(new MiKeikaPBean[miKeikaPBeanLst.size()]);

                for (int index = 0; index < miKeikaPBeans.length; index++) {

                    mikeikaP = mikeikaP.add(miKeikaPBeans[index].getMiKeikaP());
                }

                mikeikaPJyutouKaisuuY = mikeikaPJtKaisuuY;
                mikeikaPJyutouKaisuuM = mikeikaPJtKaisuuM;
                mikeikaPJyutouYM = sHrkKiYM;
            }
        }
    }

    private BizCurrency iktpcalcSyori(String pSyoNo, BizCurrency pHokenryou, C_Hrkkaisuu pHrkkaisuu,
        int pKeikamon, C_TkiktbrisyuruiKbn pTkiktbrisyuruiKbn, BizCurrency pKihons, int pHhknnen, C_Hhknsei pHhknsei,
        int pHrkkkn, boolean pKykNaiyouSiteiFlg) {

        BizCurrency iktp = BizCurrency.valueOf(0);

        List<Object[]> kykSyouhniLst = hozenDomManager
            .getKykSyouhnsBySyonoKykjyoutaiYuukousyoumetukbnSyoumetujiyuuHhknSya(pSyoNo);

        for (Object[] kykSyouhn : kykSyouhniLst) {
            int hhknnen = 0;
            C_Hhknsei hhknsei = null;
            int hrkkkn = 0;
            BizCurrency hokenkngk = null;

            if (!pKykNaiyouSiteiFlg) {
                hhknnen = (Integer)kykSyouhn[13];
                hhknsei = (C_Hhknsei)kykSyouhn[21];
                hrkkkn = (Integer)kykSyouhn[12];
                hokenkngk = (BizCurrency)kykSyouhn[0];
            }
            else {
                hhknnen = pHhknnen;
                hhknsei = pHhknsei;
                hrkkkn = pHrkkkn;
                hokenkngk = pKihons;
            }

            KeisanIkkatuPGkBean keisanIkkatuPGkBean = new KeisanIkkatuPGkBean();
            keisanIkkatuPGkBean.setSyouhnCd((String)kykSyouhn[1]);
            keisanIkkatuPGkBean.setSyouhnsdNo((Integer)kykSyouhn[2]);
            keisanIkkatuPGkBean.setRyouritusdNo((String)kykSyouhn[14]);
            keisanIkkatuPGkBean.setHokenryou(pHokenryou);
            keisanIkkatuPGkBean.setHrkkaisuu(pHrkkaisuu);
            keisanIkkatuPGkBean.setKeikamon(pKeikamon);
            keisanIkkatuPGkBean.setTkiktbrisyuruiKbn(pTkiktbrisyuruiKbn);
            keisanIkkatuPGkBean.setYoteiRiritu((BizNumber)kykSyouhn[15]);
            keisanIkkatuPGkBean.setHhknnen(hhknnen);
            keisanIkkatuPGkBean.setHhknsei(hhknsei);
            keisanIkkatuPGkBean.setHknkknsmnKbn((C_HknkknsmnKbn)kykSyouhn[9]);
            keisanIkkatuPGkBean.setHknkkn((Integer)kykSyouhn[10]);
            keisanIkkatuPGkBean.setHrkkkn(hrkkkn);
            keisanIkkatuPGkBean.setHokenkngk(hokenkngk);
            keisanIkkatuPGkBean.setKykTuukasyu((C_Tuukasyu)kykSyouhn[16]);
            keisanIkkatuPGkBean.setKykjyoutai((C_Kykjyoutai)kykSyouhn[17]);
            keisanIkkatuPGkBean.setDai1hknkkn((Integer)kykSyouhn[18]);
            keisanIkkatuPGkBean.setHrkkeiro((C_Hrkkeiro)kykSyouhn[19]);

            KeisanIkkatuPGk keisanIkkatuPGk = SWAKInjector.getInstance(KeisanIkkatuPGk.class);
            keisanIkkatuPGk.exec(keisanIkkatuPGkBean, false);

            if (iktp.compareTo(BizCurrency.valueOf(0, iktp.getType())) == 0) {

                iktp = BizCurrency.valueOf(0, keisanIkkatuPGk.getIkkatuP().getType());
            }

            iktp = iktp.add(keisanIkkatuPGk.getIkkatuP());
        }

        return iktp;

    }
}