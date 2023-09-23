package yuyu.common.hozen.khcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_6daiLdKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_KataKbn;
import yuyu.def.classification.C_KhnkyhkgbairituKbn;
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_PmnjtkKbn;
import yuyu.def.classification.C_SyukyhkinkataKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 契約保全 契約保全共通 （商品単位）未収Ｐ・未経過Ｐ計算
 */
public class SyouhnTaniKeisanMsyMkeiP {

    private String syoNo;

    private String syouhnCd;

    private int syouhnSdno;

    private C_YuukousyoumetuKbn yuukouSyoumetuKbn;

    private C_Kykjyoutai kykJyoutai;

    private BizDate kykYmd;

    private C_KataKbn kataKbn;

    private C_SyukyhkinkataKbn syukyhkinKataKbn;

    private C_KhnkyhkgbairituKbn khnkyhkgBairituKbn;

    private C_6daiLdKbn rokuDaiLdKbn;

    private C_PmnjtkKbn pmnjtkKbn;

    private C_KyhgndkataKbn kyhgndKataKbn;

    private C_HknkknsmnKbn hknkknSmnKbn;

    private int hknkkn;

    private C_HrkkknsmnKbn hrkkknSmnKbn;

    private int hrkkkn;

    private BizDate haraimanYmd;

    private int hhknNen;

    private C_Hhknsei hhknSei;

    private C_Hrkkaisuu hrkKaisuu;

    private C_Hrkkeiro hrkKeiro;

    private BizCurrency hokenryou;

    private BizCurrency hokenKngk;

    private BizDate keisanYmd;

    private BizDate denYmd;

    private BizDateYM jkipJytYM;

    private BizDateYM jskJkipJytYM;

    private BizDateYM hoseiHrkkgt;

    private BizCurrency misyuP;

    private int misyuPJyutouKaisuuY;

    private int misyuPJyutouKaisuuM;

    private BizDateYM misyuPJyutouYM;

    private MisyuuPBean[] misyuuPBeans;

    private BizCurrency mikeikaP;

    private int mikeikaPJyutouKaisuuY;

    private int mikeikaPJyutouKaisuuM;

    private BizDateYM mikeikaPJyutouYM;

    private MiKeikaPBean[] mikeikaPBeans;

    @Inject
    private JtKaisukeisan jtKaisukeisan;

    @Inject
    private SetOutoubi setOutoubi;

    @Inject
    private IkkatuPGkCal ikkatuPGkCal;

    @Inject
    private HozenDomManager hozenDomManager;

    public SyouhnTaniKeisanMsyMkeiP() {
        super();
    }

    public void setSyono(String pSyono) {
        syoNo = pSyono;
    }

    public void setSyouhncd(String pSyouhncd) {
        syouhnCd = pSyouhncd;
    }

    public void setSyouhnSdno(int pSyouhnSdno) {
        syouhnSdno = pSyouhnSdno;
    }

    public void setYuukousyoumetukbn(C_YuukousyoumetuKbn pYuukousyoumetukbn) {
        yuukouSyoumetuKbn = pYuukousyoumetukbn;
    }

    public void setKykjyoutai(C_Kykjyoutai pKykjyoutai) {
        kykJyoutai = pKykjyoutai;
    }

    public void setKeiyakubi(BizDate pKeiyakubi) {
        kykYmd = pKeiyakubi;
    }

    public void setKatakbn(C_KataKbn pKatakbn) {
        kataKbn = pKatakbn;
    }

    public void setSyukyhkinKatakbn(C_SyukyhkinkataKbn pSyukyhkinKatakbn) {
        syukyhkinKataKbn = pSyukyhkinKatakbn;
    }

    public void setKhnkyhkgbairituKbn(C_KhnkyhkgbairituKbn pKhnkyhkgbairituKbn) {
        khnkyhkgBairituKbn = pKhnkyhkgbairituKbn;
    }

    public void setRokuDaisktsyknTuikakyhKatakbn(C_6daiLdKbn p6DaisktsyknTuikakyhKatakbn) {
        rokuDaiLdKbn = p6DaisktsyknTuikakyhKatakbn;
    }

    public void setPmnjtkhukaKbn(C_PmnjtkKbn pPmnjtkhukaKbn) {
        pmnjtkKbn = pPmnjtkhukaKbn;
    }

    public void setKyhgndKatakbn(C_KyhgndkataKbn pKyhgndKatakbn) {
        kyhgndKataKbn = pKyhgndKatakbn;
    }

    public void setHknkknSmnkbn(C_HknkknsmnKbn pHknkknSmnkbn) {
        hknkknSmnKbn = pHknkknSmnkbn;
    }

    public void setHknkkn(int pHknkkn) {
        hknkkn = pHknkkn;
    }

    public void setHrkkknSmnkbn(C_HrkkknsmnKbn pHrkkknSmnkbn) {
        hrkkknSmnKbn = pHrkkknSmnkbn;
    }

    public void setHrkkkn(int pHrkkkn) {
        hrkkkn = pHrkkkn;
    }

    public void setHaraimanYMD(BizDate pHaraimanYMD) {
        haraimanYmd = pHaraimanYMD;
    }

    public void setHhknNen(int pHhknNen) {
        hhknNen = pHhknNen;
    }

    public void setHhknSei(C_Hhknsei pHhknSei) {
        hhknSei = pHhknSei;
    }

    public void setHrkKaisuu(C_Hrkkaisuu pHrkKaisuu) {
        hrkKaisuu = pHrkKaisuu;
    }

    public void setHrkKeiro(C_Hrkkeiro pHrkKeiro) {
        hrkKeiro = pHrkKeiro;
    }

    public void setP(BizCurrency pP) {
        hokenryou = pP;
    }

    public void setS(BizCurrency pS) {
        hokenKngk = pS;
    }

    public void setKeisanYMD(BizDate pKeisanYMD) {
        keisanYmd = pKeisanYMD;
    }

    public void setDenymd(BizDate pDenymd) {
        denYmd = pDenymd;
    }

    public void setJkipJytYM(BizDateYM pJkipJytYM) {
        jkipJytYM = pJkipJytYM;
    }

    public void setJskJkipJytYM(BizDateYM pJskJkipJytYM) {
        jskJkipJytYM = pJskJkipJytYM;
    }

    public void setHoseihrkkgt(BizDateYM pHoseihrkkgt) {
        hoseiHrkkgt = pHoseihrkkgt;
    }

    public BizCurrency getMisyuP() {
        return misyuP;
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
        return mikeikaPBeans;
    }

    public void exec() {

        misyuP = BizCurrency.valueOf(0);
        misyuPJyutouKaisuuY = 0;
        misyuPJyutouKaisuuM = 0;
        misyuPJyutouYM = null;
        misyuuPBeans = null;
        mikeikaP = BizCurrency.valueOf(0);
        mikeikaPJyutouKaisuuY = 0;
        mikeikaPJyutouKaisuuM = 0;
        mikeikaPJyutouYM = null;
        mikeikaPBeans = null;

        /*
        if (C_Hrkkaisuu.ITIJI.eq(hrkKaisuu)) {

            return;
        }

        boolean nyknJskHs = false;

        if (hoseiHrkkgt != null) {
            nyknJskHs = true;
        }

        BizDateYM kykOutouYM;

        if (hoseiHrkkgt != null) {
            kykOutouYM = hoseiHrkkgt;
        }
        else {
            BizDate kykOutouYMD = setOutoubi.exec(C_TykzentykgoKbn.TYKGO, kykYmd, hrkKaisuu, keisanYmd);
            kykOutouYM = kykOutouYMD.getBizDateYM();
        }

        BizDateYM hrkKiYM;

        if (kykOutouYM.compareTo(haraimanYmd.getBizDateYM()) <= 0) {

            hrkKiYM = kykOutouYM;
        }
        else {
            hrkKiYM = haraimanYmd.getBizDateYM();
        }

        if (jkipJytYM.compareTo(hrkKiYM) < 0) {

            int msypJytM = hrkKiYM.subtractMonths(jkipJytYM);

            jtKaisukeisan.exec(0, msypJytM, hrkKaisuu);

            int jyutoukaisuu = jtKaisukeisan.getJyutoukaisuu();

            List<MisyuuPBean> misyuuPBeanLst = new ArrayList<>();

            if (jyutoukaisuu > 0) {
                MisyuuPBean misyuuPBean = new MisyuuPBean();

                misyuuPBean.setMisyuuP(hokenryou.multiply(BizNumber.valueOf(jyutoukaisuu)));
                misyuuPBean.setMsyPIkkatuNkUmu(C_UmuKbn.NONE);
                misyuuPBean.setMsyPHrkKaisuu(hrkKaisuu);
                if (C_Hrkkaisuu.TUKI.eq(hrkKaisuu)) {
                    misyuuPBean.setMsyPJytKaisuuY(0);
                    misyuuPBean.setMsyPJytKaisuuM(jyutoukaisuu);
                }
                else if (C_Hrkkaisuu.HALFY.eq(hrkKaisuu)) {
                    misyuuPBean.setMsyPJytKaisuuY(0);
                    misyuuPBean.setMsyPJytKaisuuM(jyutoukaisuu * 6);
                }
                else if (C_Hrkkaisuu.NEN.eq(hrkKaisuu)) {
                    misyuuPBean.setMsyPJytKaisuuY(jyutoukaisuu);
                    misyuuPBean.setMsyPJytKaisuuM(0);
                }
                misyuuPBean.setMsyPJytYm(jkipJytYM);

                misyuuPBeanLst.add(misyuuPBean);
            }

            int hasuuTuki = jtKaisukeisan.getHasuutuki();

            ikkatuPGkCal = SWAKInjector.getInstance(IkkatuPGkCal.class);

            if (hasuuTuki > 0) {
                BizCurrency msyPGaku = BizCurrency.valueOf(0);

                ikkatuPGkCal.setSyouhncd(syouhnCd);
                ikkatuPGkCal.setSyouhnSdno(syouhnSdno);
                ikkatuPGkCal.setKatakbn(kataKbn);
                ikkatuPGkCal.setSyukyhkinKatakbn(syukyhkinKataKbn);
                ikkatuPGkCal.setKhnkyhkgBairitukbn(khnkyhkgBairituKbn);
                ikkatuPGkCal.set6daisktsykntuikakyhKatakbn(rokuDaiLdKbn);
                ikkatuPGkCal.setPmnjTkkbn(pmnjtkKbn);
                ikkatuPGkCal.setKyhgndKatakbn(kyhgndKataKbn);
                ikkatuPGkCal.setHknkknSmnkbn(hknkknSmnKbn);
                ikkatuPGkCal.setHknkkn(hknkkn);
                ikkatuPGkCal.setHrkkknSmnkbn(hrkkknSmnKbn);
                ikkatuPGkCal.setHrkkkn(hrkkkn);
                ikkatuPGkCal.setHhknNen(hhknNen);
                ikkatuPGkCal.setHhknSei(hhknSei);
                ikkatuPGkCal.setHrkKaisuu(C_Hrkkaisuu.TUKI);
                ikkatuPGkCal.setHrkKeiro(C_Hrkkeiro.BLNK);
                ikkatuPGkCal.setS(hokenKngk);
                ikkatuPGkCal.setKeikatukisuu(hasuuTuki);

                ikkatuPGkCal.exec();

                msyPGaku = ikkatuPGkCal.getIkkatuP();

                BizDateYM msyPJytYm = jkipJytYM.addMonths(Integer.valueOf(hrkKaisuu.getValue()) * jyutoukaisuu);

                MisyuuPBean misyuuPBean = new MisyuuPBean();

                misyuuPBean.setMisyuuP(msyPGaku);
                misyuuPBean.setMsyPIkkatuNkUmu(C_UmuKbn.ARI);
                misyuuPBean.setMsyPHrkKaisuu(hrkKaisuu);
                misyuuPBean.setMsyPJytKaisuuY(0);
                misyuuPBean.setMsyPJytKaisuuM(hasuuTuki);
                misyuuPBean.setMsyPJytYm(msyPJytYm);

                misyuuPBeanLst.add(misyuuPBean);
            }

            if (misyuuPBeanLst.size() != 0) {

                misyuuPBeans = misyuuPBeanLst.toArray(new MisyuuPBean[misyuuPBeanLst.size()]);

                for (MisyuuPBean misyuuPBean : misyuuPBeans) {
                    misyuP = misyuP.add(misyuuPBean.getMisyuuP());
                    misyuPJyutouKaisuuY = misyuPJyutouKaisuuY + misyuuPBean.getMsyPJytKaisuuY();
                    misyuPJyutouKaisuuM = misyuPJyutouKaisuuM + misyuuPBean.getMsyPJytKaisuuM();
                }
            }

            misyuPJyutouYM = jkipJytYM;

            BizDate keisanbiTykgoOutouYMD = setOutoubi.exec(
                C_TykzentykgoKbn.TYKGO, kykYmd, C_Hrkkaisuu.TUKI, keisanYmd);

            BizDateYM keisanbiTykgoOutouYM = keisanbiTykgoOutouYMD.getBizDateYM();

            BizDate keisanbitykzenNextPJyutouYMD = setOutoubi.exec(
                C_TykzentykgoKbn.TYKZEN, kykYmd, hrkKaisuu, keisanbiTykgoOutouYMD);

            BizDateYM keisanbitykzenNextPJyutouYM = keisanbitykzenNextPJyutouYMD.getBizDateYM();

            if (keisanbiTykgoOutouYM.compareTo(hrkKiYM) < 0) {

                List<MiKeikaPBean> miKeikaPBeanLst = new ArrayList<>();

                int keikaGetusuu = keisanbiTykgoOutouYM.subtractMonths(keisanbitykzenNextPJyutouYM);

                ikkatuPGkCal = SWAKInjector.getInstance(IkkatuPGkCal.class);

                ikkatuPGkCal.setSyouhncd(syouhnCd);
                ikkatuPGkCal.setSyouhnSdno(syouhnSdno);
                ikkatuPGkCal.setKatakbn(kataKbn);
                ikkatuPGkCal.setSyukyhkinKatakbn(syukyhkinKataKbn);
                ikkatuPGkCal.setKhnkyhkgBairitukbn(khnkyhkgBairituKbn);
                ikkatuPGkCal.set6daisktsykntuikakyhKatakbn(rokuDaiLdKbn);
                ikkatuPGkCal.setPmnjTkkbn(pmnjtkKbn);
                ikkatuPGkCal.setKyhgndKatakbn(kyhgndKataKbn);
                ikkatuPGkCal.setHknkknSmnkbn(hknkknSmnKbn);
                ikkatuPGkCal.setHknkkn(hknkkn);
                ikkatuPGkCal.setHrkkknSmnkbn(hrkkknSmnKbn);
                ikkatuPGkCal.setHrkkkn(hrkkkn);
                ikkatuPGkCal.setHhknNen(hhknNen);
                ikkatuPGkCal.setHhknSei(hhknSei);
                ikkatuPGkCal.setHrkKaisuu(C_Hrkkaisuu.TUKI);
                ikkatuPGkCal.setHrkKeiro(C_Hrkkeiro.BLNK);
                ikkatuPGkCal.setS(hokenKngk);
                ikkatuPGkCal.setKeikatukisuu(keikaGetusuu);

                ikkatuPGkCal.exec();

                BizCurrency mikeikaPTemp = hokenryou.subtract(ikkatuPGkCal.getIkkatuP());
                int mikeikaM = Integer.valueOf(hrkKaisuu.getValue()) - keikaGetusuu;

                MiKeikaPBean miKeikaPBean = new MiKeikaPBean();

                miKeikaPBean.setMiKeikaP(mikeikaPTemp);
                miKeikaPBean.setMkeiPNykDenYmd(denYmd);
                miKeikaPBean.setMkeiPHrkKaisuu(hrkKaisuu);
                miKeikaPBean.setMkeiPJytKaisuuY(0);
                miKeikaPBean.setMkeiPJytKaisuuM(mikeikaM);
                miKeikaPBean.setMkeiPJytYm(keisanbitykzenNextPJyutouYM);

                miKeikaPBeanLst.add(miKeikaPBean);

                if (miKeikaPBeanLst.size() != 0) {

                    mikeikaPBeans = miKeikaPBeanLst.toArray(new MiKeikaPBean[miKeikaPBeanLst.size()]);
                }
                mikeikaP = mikeikaPTemp;
                mikeikaPJyutouKaisuuY = 0;
                mikeikaPJyutouKaisuuM = mikeikaM;
                mikeikaPJyutouYM = keisanbiTykgoOutouYM;
            }
        }
        else {

            int mikeikaPJyuutouKaisuuY = 0;
            int mikeikaPJyuutouKaisuuM = 0;

            List<MiKeikaPBean> miKeikaPBeanLst = new ArrayList<>();

            BizDate keiyakuOutouYMD = setOutoubi.exec(
                C_TykzentykgoKbn.TYKGO, kykYmd, C_Hrkkaisuu.TUKI, keisanYmd);

            hrkKiYM = keiyakuOutouYMD.getBizDateYM();

            if (hrkKiYM.compareTo(jskJkipJytYM) < 0) {

                List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = hozenDomManager.getKykKihon(syoNo)
                    .getNyknJissekiRirekisByJyutouendymJyutoustartymNyktrksflg(
                        hrkKiYM, jkipJytYM, C_Nyktrksflg.TORIKESI);

                BizDateYM jyutouEndYM = null;

                for (IT_NyknJissekiRireki nyknJissekiRireki : nyknJissekiRirekiLst) {

                    int jyutoukaisuuY = 0;
                    int jyutoukaisuuM = 0;
                    boolean jyutoukaisuuFlg = false;

                    BizDateYM jyuutouKaisiYM = nyknJissekiRireki.getJyutoustartym();

                    BizDateYM jyutoendYM = nyknJissekiRireki.getJyutouendym();

                    C_Hrkkaisuu hrkkaisuu = nyknJissekiRireki.getHrkkaisuu();

                    BizCurrency ryosyugaku = BizCurrency.valueOf(0);

                    if (nyknJskHs) {

                        if (jyutoendYM.compareTo(jskJkipJytYM) >= 0) {

                            jyutoukaisuuY = 0;
                            jyutoukaisuuM = jskJkipJytYM.subtractMonths(jyuutouKaisiYM);

                            jyutoukaisuuFlg = true;

                            ikkatuPGkCal = SWAKInjector.getInstance(IkkatuPGkCal.class);

                            ikkatuPGkCal.setSyouhncd(syouhnCd);
                            ikkatuPGkCal.setSyouhnSdno(syouhnSdno);
                            ikkatuPGkCal.setKatakbn(kataKbn);
                            ikkatuPGkCal.setSyukyhkinKatakbn(syukyhkinKataKbn);
                            ikkatuPGkCal.setKhnkyhkgBairitukbn(khnkyhkgBairituKbn);
                            ikkatuPGkCal.set6daisktsykntuikakyhKatakbn(rokuDaiLdKbn);
                            ikkatuPGkCal.setPmnjTkkbn(pmnjtkKbn);
                            ikkatuPGkCal.setKyhgndKatakbn(kyhgndKataKbn);
                            ikkatuPGkCal.setHknkknSmnkbn(hknkknSmnKbn);
                            ikkatuPGkCal.setHknkkn(hknkkn);
                            ikkatuPGkCal.setHrkkknSmnkbn(hrkkknSmnKbn);
                            ikkatuPGkCal.setHrkkkn(hrkkkn);
                            ikkatuPGkCal.setHhknNen(hhknNen);
                            ikkatuPGkCal.setHhknSei(hhknSei);
                            ikkatuPGkCal.setHrkKaisuu(C_Hrkkaisuu.TUKI);
                            ikkatuPGkCal.setHrkKeiro(C_Hrkkeiro.BLNK);
                            ikkatuPGkCal.setS(hokenKngk);
                            ikkatuPGkCal.setKeikatukisuu(jyutoukaisuuM);

                            ikkatuPGkCal.exec();

                            ryosyugaku = ikkatuPGkCal.getIkkatuP();
                        }
                        else {

                            jyutoukaisuuY = nyknJissekiRireki.getJyutoukaisuuy();
                            jyutoukaisuuM = nyknJissekiRireki.getJyutoukaisuum();

                            if (C_UmuKbn.ARI.eq(nyknJissekiRireki.getIktnyuukinnumu())) {

                                ikkatuPGkCal = SWAKInjector.getInstance(IkkatuPGkCal.class);

                                ikkatuPGkCal.setSyouhncd(syouhnCd);
                                ikkatuPGkCal.setSyouhnSdno(syouhnSdno);
                                ikkatuPGkCal.setKatakbn(kataKbn);
                                ikkatuPGkCal.setSyukyhkinKatakbn(syukyhkinKataKbn);
                                ikkatuPGkCal.setKhnkyhkgBairitukbn(khnkyhkgBairituKbn);
                                ikkatuPGkCal.set6daisktsykntuikakyhKatakbn(rokuDaiLdKbn);
                                ikkatuPGkCal.setPmnjTkkbn(pmnjtkKbn);
                                ikkatuPGkCal.setKyhgndKatakbn(kyhgndKataKbn);
                                ikkatuPGkCal.setHknkknSmnkbn(hknkknSmnKbn);
                                ikkatuPGkCal.setHknkkn(hknkkn);
                                ikkatuPGkCal.setHrkkknSmnkbn(hrkkknSmnKbn);
                                ikkatuPGkCal.setHrkkkn(hrkkkn);
                                ikkatuPGkCal.setHhknNen(hhknNen);
                                ikkatuPGkCal.setHhknSei(hhknSei);
                                ikkatuPGkCal.setHrkKaisuu(C_Hrkkaisuu.TUKI);
                                ikkatuPGkCal.setHrkKeiro(C_Hrkkeiro.BLNK);
                                ikkatuPGkCal.setS(hokenKngk);
                                ikkatuPGkCal.setKeikatukisuu(jyutoukaisuuM);

                                ikkatuPGkCal.exec();

                                ryosyugaku = ikkatuPGkCal.getIkkatuP();
                            }
                            else {
                                if (C_Hrkkaisuu.TUKI.eq(hrkkaisuu)) {
                                    ryosyugaku = hokenryou.multiply(BizNumber.valueOf(jyutoukaisuuM));
                                }
                                else if (C_Hrkkaisuu.HALFY.eq(hrkkaisuu)) {
                                    ryosyugaku = hokenryou.multiply(BizNumber.valueOf(jyutoukaisuuM).divide(
                                        BizNumber.valueOf(6)));
                                }
                                else if (C_Hrkkaisuu.NEN.eq(hrkkaisuu)) {
                                    ryosyugaku = hokenryou.multiply(BizNumber.valueOf(jyutoukaisuuY));
                                }
                            }
                        }
                    }
                    else {
                        jyutoukaisuuY = nyknJissekiRireki.getJyutoukaisuuy();
                        jyutoukaisuuM = nyknJissekiRireki.getJyutoukaisuum();

                        if (C_UmuKbn.ARI.eq(nyknJissekiRireki.getIktnyuukinnumu())) {

                            ikkatuPGkCal = SWAKInjector.getInstance(IkkatuPGkCal.class);

                            ikkatuPGkCal.setSyouhncd(syouhnCd);
                            ikkatuPGkCal.setSyouhnSdno(syouhnSdno);
                            ikkatuPGkCal.setKatakbn(kataKbn);
                            ikkatuPGkCal.setSyukyhkinKatakbn(syukyhkinKataKbn);
                            ikkatuPGkCal.setKhnkyhkgBairitukbn(khnkyhkgBairituKbn);
                            ikkatuPGkCal.set6daisktsykntuikakyhKatakbn(rokuDaiLdKbn);
                            ikkatuPGkCal.setPmnjTkkbn(pmnjtkKbn);
                            ikkatuPGkCal.setKyhgndKatakbn(kyhgndKataKbn);
                            ikkatuPGkCal.setHknkknSmnkbn(hknkknSmnKbn);
                            ikkatuPGkCal.setHknkkn(hknkkn);
                            ikkatuPGkCal.setHrkkknSmnkbn(hrkkknSmnKbn);
                            ikkatuPGkCal.setHrkkkn(hrkkkn);
                            ikkatuPGkCal.setHhknNen(hhknNen);
                            ikkatuPGkCal.setHhknSei(hhknSei);
                            ikkatuPGkCal.setHrkKaisuu(C_Hrkkaisuu.TUKI);
                            ikkatuPGkCal.setHrkKeiro(C_Hrkkeiro.BLNK);
                            ikkatuPGkCal.setS(hokenKngk);
                            ikkatuPGkCal.setKeikatukisuu(jyutoukaisuuM);

                            ikkatuPGkCal.exec();

                            ryosyugaku = ikkatuPGkCal.getIkkatuP();
                        }
                        else {
                            if (C_Hrkkaisuu.TUKI.eq(hrkkaisuu)) {
                                ryosyugaku = hokenryou.multiply(BizNumber.valueOf(jyutoukaisuuM));
                            }
                            else if (C_Hrkkaisuu.HALFY.eq(hrkkaisuu)) {
                                ryosyugaku = hokenryou.multiply(BizNumber.valueOf(jyutoukaisuuM)
                                    .divide(BizNumber.valueOf(6)));
                            }
                            else if (C_Hrkkaisuu.NEN.eq(hrkkaisuu)) {
                                ryosyugaku = hokenryou.multiply(BizNumber.valueOf(jyutoukaisuuY));
                            }
                        }
                    }

                    mikeikaPJyuutouKaisuuY += jyutoukaisuuY;
                    mikeikaPJyuutouKaisuuM += jyutoukaisuuM;

                    BizCurrency keikabunRyosyugaku = BizCurrency.valueOf(0);
                    int keikaGetusuu = 0;

                    if (jyuutouKaisiYM.compareTo(hrkKiYM) < 0) {

                        keikaGetusuu = hrkKiYM.subtractMonths(jyuutouKaisiYM);

                        ikkatuPGkCal = SWAKInjector.getInstance(IkkatuPGkCal.class);

                        ikkatuPGkCal.setSyouhncd(syouhnCd);
                        ikkatuPGkCal.setSyouhnSdno(syouhnSdno);
                        ikkatuPGkCal.setKatakbn(kataKbn);
                        ikkatuPGkCal.setSyukyhkinKatakbn(syukyhkinKataKbn);
                        ikkatuPGkCal.setKhnkyhkgBairitukbn(khnkyhkgBairituKbn);
                        ikkatuPGkCal.set6daisktsykntuikakyhKatakbn(rokuDaiLdKbn);
                        ikkatuPGkCal.setPmnjTkkbn(pmnjtkKbn);
                        ikkatuPGkCal.setKyhgndKatakbn(kyhgndKataKbn);
                        ikkatuPGkCal.setHknkknSmnkbn(hknkknSmnKbn);
                        ikkatuPGkCal.setHknkkn(hknkkn);
                        ikkatuPGkCal.setHrkkknSmnkbn(hrkkknSmnKbn);
                        ikkatuPGkCal.setHrkkkn(hrkkkn);
                        ikkatuPGkCal.setHhknNen(hhknNen);
                        ikkatuPGkCal.setHhknSei(hhknSei);
                        ikkatuPGkCal.setHrkKaisuu(C_Hrkkaisuu.TUKI);
                        ikkatuPGkCal.setHrkKeiro(C_Hrkkeiro.BLNK);
                        ikkatuPGkCal.setS(hokenKngk);
                        ikkatuPGkCal.setKeikatukisuu(keikaGetusuu);

                        ikkatuPGkCal.exec();

                        keikabunRyosyugaku = ikkatuPGkCal.getIkkatuP();

                        if (jyutoukaisuuFlg) {
                            mikeikaPJyuutouKaisuuM = mikeikaPJyuutouKaisuuM + (jyutoukaisuuM - keikaGetusuu);
                        }
                        else {
                            if (C_Hrkkaisuu.NEN.eq(hrkkaisuu)) {
                                mikeikaPJyuutouKaisuuY -= 1;
                                mikeikaPJyuutouKaisuuM = mikeikaPJyuutouKaisuuM + (12 - keikaGetusuu);
                            } else {
                                mikeikaPJyuutouKaisuuM -= keikaGetusuu;
                            }
                        }
                    }

                    MiKeikaPBean miKeikaPBean = new MiKeikaPBean();

                    miKeikaPBean.setMkeiPNykDenYmd(nyknJissekiRireki.getNykdenymd());
                    miKeikaPBean.setMkeiPHrkKaisuu(nyknJissekiRireki.getHrkkaisuu());

                    if (jyuutouKaisiYM.compareTo(hrkKiYM) < 0) {
                        miKeikaPBean.setMiKeikaP(ryosyugaku.subtract(keikabunRyosyugaku));
                        miKeikaPBean.setMkeiPJytKaisuuY(0);
                        miKeikaPBean.setMkeiPJytKaisuuM(jyutoukaisuuY * 12 + jyutoukaisuuM - keikaGetusuu);

                        if (C_Hrkkaisuu.TUKI.eq(nyknJissekiRireki.getHrkkaisuu())) {

                            BizDateYM jyuutouKaisiYmTemp = jyuutouKaisiYM.addMonths(keikaGetusuu);

                            miKeikaPBean.setMkeiPJytYm(jyuutouKaisiYmTemp);
                        }
                        else {
                            miKeikaPBean.setMkeiPJytYm(jyuutouKaisiYM);
                        }
                    }
                    else {
                        miKeikaPBean.setMiKeikaP(ryosyugaku);
                        miKeikaPBean.setMkeiPJytKaisuuY(jyutoukaisuuY);
                        miKeikaPBean.setMkeiPJytKaisuuM(jyutoukaisuuM);
                        miKeikaPBean.setMkeiPJytYm(jyuutouKaisiYM);
                    }
                    miKeikaPBeanLst.add(miKeikaPBean);

                    jyutouEndYM = jyutoendYM.getNextMonth();
                }

                if (jyutouEndYM.compareTo(jkipJytYM) < 0) {

                    int mikeikaM = jkipJytYM.subtractMonths(jyutouEndYM);

                    jtKaisukeisan.exec(0, mikeikaM, hrkKaisuu);

                    int jyutoukaisuu = jtKaisukeisan.getJyutoukaisuu();

                    if (jyutoukaisuu > 0) {
                        BizCurrency meisaiMikeikaP = hokenryou.multiply(jyutoukaisuu);

                        MiKeikaPBean miKeikaPBean = new MiKeikaPBean();

                        miKeikaPBean.setMiKeikaP(meisaiMikeikaP);
                        miKeikaPBean.setMkeiPNykDenYmd(denYmd);
                        miKeikaPBean.setMkeiPHrkKaisuu(hrkKaisuu);
                        miKeikaPBean.setMkeiPJytKaisuuY(0);
                        miKeikaPBean.setMkeiPJytKaisuuM(mikeikaM);
                        miKeikaPBean.setMkeiPJytYm(jyutouEndYM);

                        miKeikaPBeanLst.add(miKeikaPBean);
                    }
                }
            }
            else {

                int minasikeikaM = hrkKiYM.subtractMonths(jkipJytYM);

                jtKaisukeisan.exec(0, minasikeikaM, hrkKaisuu);

                int jyutouKaisuu = jtKaisukeisan.getJyutoukaisuu();

                int hasuutuki = jtKaisukeisan.getHasuutuki();

                BizDateYM hasuutukiSeisangoHaraikomiYM = null;

                if (hasuutuki > 0) {

                    BizDateYM keisanbiTykzenharaikatatanioutouYM = setOutoubi.exec(
                        C_TykzentykgoKbn.TYKZEN, kykYmd, hrkKaisuu, keisanYmd).getBizDateYM();

                    int keikaM = hrkKiYM.subtractMonths(keisanbiTykzenharaikatatanioutouYM);

                    ikkatuPGkCal = SWAKInjector.getInstance(IkkatuPGkCal.class);

                    ikkatuPGkCal.setSyouhncd(syouhnCd);
                    ikkatuPGkCal.setSyouhnSdno(syouhnSdno);
                    ikkatuPGkCal.setKatakbn(kataKbn);
                    ikkatuPGkCal.setSyukyhkinKatakbn(syukyhkinKataKbn);
                    ikkatuPGkCal.setKhnkyhkgBairitukbn(khnkyhkgBairituKbn);
                    ikkatuPGkCal.set6daisktsykntuikakyhKatakbn(rokuDaiLdKbn);
                    ikkatuPGkCal.setPmnjTkkbn(pmnjtkKbn);
                    ikkatuPGkCal.setKyhgndKatakbn(kyhgndKataKbn);
                    ikkatuPGkCal.setHknkknSmnkbn(hknkknSmnKbn);
                    ikkatuPGkCal.setHknkkn(hknkkn);
                    ikkatuPGkCal.setHrkkknSmnkbn(hrkkknSmnKbn);
                    ikkatuPGkCal.setHrkkkn(hrkkkn);
                    ikkatuPGkCal.setHhknNen(hhknNen);
                    ikkatuPGkCal.setHhknSei(hhknSei);
                    ikkatuPGkCal.setHrkKaisuu(C_Hrkkaisuu.TUKI);
                    ikkatuPGkCal.setHrkKeiro(C_Hrkkeiro.BLNK);
                    ikkatuPGkCal.setS(hokenKngk);
                    ikkatuPGkCal.setKeikatukisuu(keikaM);

                    ikkatuPGkCal.exec();

                    BizCurrency keikaP = ikkatuPGkCal.getIkkatuP();

                    MiKeikaPBean miKeikaPBean = new MiKeikaPBean();

                    miKeikaPBean.setMiKeikaP(hokenryou.subtract(keikaP));
                    miKeikaPBean.setMkeiPNykDenYmd(denYmd);
                    miKeikaPBean.setMkeiPHrkKaisuu(hrkKaisuu);
                    miKeikaPBean.setMkeiPJytKaisuuY(0);
                    miKeikaPBean.setMkeiPJytKaisuuM(hasuutuki);
                    miKeikaPBean.setMkeiPJytYm(hrkKiYM);

                    miKeikaPBeanLst.add(miKeikaPBean);

                    hasuutukiSeisangoHaraikomiYM = hrkKiYM.addMonths(hasuutuki);
                }

                if (jyutouKaisuu > 0) {
                    MiKeikaPBean miKeikaPBean = new MiKeikaPBean();

                    miKeikaPBean.setMiKeikaP(hokenryou.multiply(jyutouKaisuu));
                    miKeikaPBean.setMkeiPNykDenYmd(denYmd);
                    miKeikaPBean.setMkeiPHrkKaisuu(hrkKaisuu);
                    miKeikaPBean.setMkeiPJytKaisuuY(0);
                    miKeikaPBean.setMkeiPJytKaisuuM(Integer.valueOf(hrkKaisuu.getValue()) * jyutouKaisuu);

                    if (hasuutuki > 0) {
                        miKeikaPBean.setMkeiPJytYm(hasuutukiSeisangoHaraikomiYM);
                    } else {
                        miKeikaPBean.setMkeiPJytYm(hrkKiYM);
                    }
                    miKeikaPBeanLst.add(miKeikaPBean);
                }
            }

            if (miKeikaPBeanLst.size() != 0) {

                mikeikaPBeans = miKeikaPBeanLst.toArray(new MiKeikaPBean[miKeikaPBeanLst.size()]);

                for (MiKeikaPBean miKeikaPBean : mikeikaPBeans) {

                    mikeikaP = mikeikaP.add(miKeikaPBean.getMiKeikaP());
                    mikeikaPJyutouKaisuuM = mikeikaPJyutouKaisuuM + miKeikaPBean.getMkeiPJytKaisuuM();
                }
            }

            mikeikaPJyutouKaisuuY = mikeikaPJyuutouKaisuuY;
            mikeikaPJyutouYM = hrkKiYM;
        }*/
    }
}
