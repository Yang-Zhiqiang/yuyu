package yuyu.common.hozen.khcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.common.hozen.setuibean.SetHaraikomiInfoTest_exec;
import yuyu.common.hozen.setuibean.SetHosyouTest_exec;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_6daiLdKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_KataKbn;
import yuyu.def.classification.C_KhnkyhkgbairituKbn;
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_PmnjtkKbn;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_SyukyhkinkataKbn;

/**
 * {@link SyouhntaniKousingoPkeisan}のモッククラスです。<br />
 */
public class SyouhntaniKousingoPkeisanMock extends SyouhntaniKousingoPkeisan{

    public static final String TESTPATTERN3 = "3";

    public static final String TESTPATTERN4= "4";

    public static final String TESTPATTERN5= "5";

    public static final String TESTPATTERN6 = "6";

    public static String SYORIPTN = null;


    public static Class<?> caller = null;

    private String syouhnCd;

    private int syouhnSdNo;

    private BizDate keiyakuBi;

    private C_KataKbn kataKbn;

    private C_KyhgndkataKbn kyhgndKataKbn;

    private C_SyukyhkinkataKbn syukyhkinKataKbn;

    private C_KhnkyhkgbairituKbn khnkyhkgbairituKbn;

    private C_6daiLdKbn daisktsyknTuikakyhKataKbn;

    private C_PmnjtkKbn pmnjtkhukaKbn;

    private C_HknkknsmnKbn hknkknSmnKbn;

    private int hknKkn;

    private C_HrkkknsmnKbn hrkkknSmnKbn;

    private int hrkKkn;

    private int hhknNen;

    private C_Hhknsei hhknSei;

    private C_Hrkkaisuu hrkKaisuu;

    private C_Hrkkeiro hrkKeiro;

    private C_Sdpd sdPdKbn;

    private BizCurrency hosen;

    private KousinBean[] kosnaiyMeisKmks;

    private int kosKaisuu;

    @Inject
    private KeisanSP keisanSP;

    @Inject
    private SetManryoubi setManryoubi;

    @Inject
    private BizDomManager bizDomManager;

    @Override
    public void setSyouhncd(String pSyouhncd) {
        syouhnCd = pSyouhncd;
    }

    @Override
    public void setSyouhnSdno(int pSyouhnSdno) {
        syouhnSdNo = pSyouhnSdno;
    }

    @Override
    public void setKeiyakubi(BizDate pKeiyakubi) {
        keiyakuBi = pKeiyakubi;
    }

    @Override
    public void setKatakbn(C_KataKbn pKatakbn) {
        kataKbn = pKatakbn;
    }

    @Override
    public void setKyhgndKatakbn(C_KyhgndkataKbn pKyhgndKatakbn) {
        kyhgndKataKbn = pKyhgndKatakbn;
    }

    @Override
    public void setSyukyhkinKatakbn(C_SyukyhkinkataKbn pSyukyhkinKatakbn) {
        syukyhkinKataKbn = pSyukyhkinKatakbn;
    }

    @Override
    public void setKhnkyhkgbairituKbn(C_KhnkyhkgbairituKbn pKhnkyhkgbairituKbn) {
        khnkyhkgbairituKbn = pKhnkyhkgbairituKbn;
    }

    @Override
    public void set6DaisktsyknTuikakyhKatakbn(C_6daiLdKbn p6DaisktsyknTuikakyhKatakbn) {
        daisktsyknTuikakyhKataKbn = p6DaisktsyknTuikakyhKatakbn;
    }

    @Override
    public void setPmnjtkhukaKbn(C_PmnjtkKbn pPmnjtkhukaKbn) {
        pmnjtkhukaKbn = pPmnjtkhukaKbn;
    }

    @Override
    public void setHknkknSmnkbn(C_HknkknsmnKbn pHknkknSmnkbn) {
        hknkknSmnKbn = pHknkknSmnkbn;
    }

    @Override
    public void setHknkkn(int pHknkkn) {
        hknKkn = pHknkkn;
    }

    @Override
    public void setHrkkknSmnkbn(C_HrkkknsmnKbn pHrkkknSmnkbn) {
        hrkkknSmnKbn = pHrkkknSmnkbn;
    }

    @Override
    public void setHrkkkn(int pHrkkkn) {
        hrkKkn = pHrkkkn;
    }

    @Override
    public void setHhknNen(int pHhknNen) {
        hhknNen = pHhknNen;
    }

    @Override
    public void setHhknSei(C_Hhknsei pHhknSei) {
        hhknSei = pHhknSei;
    }

    @Override
    public void setHrkKaisuu(C_Hrkkaisuu pHrkKaisuu) {
        hrkKaisuu = pHrkKaisuu;
    }

    @Override
    public void setHrkKeiro(C_Hrkkeiro pHrkKeiro) {
        hrkKeiro = pHrkKeiro;
    }

    @Override
    public void setSdPdKbn(C_Sdpd pSdPdKbn) {
        sdPdKbn = pSdPdKbn;
    }

    @Override
    public void setS(BizCurrency pS) {
        hosen = pS;
    }

    @Override
    public KousinBean[] getKosnaiymeiskmk() {

        if(caller == SetHosyouTest_exec.class && TESTPATTERN4.equals(SYORIPTN)) {
            KousinBean kousinBean = new KousinBean();
            kosnaiyMeisKmks = new KousinBean[1];
            kousinBean.setHknry(BizCurrency.valueOf(0));
            kosnaiyMeisKmks[0] = kousinBean;
            return kosnaiyMeisKmks;
        }
        else if(caller == SetHosyouTest_exec.class && TESTPATTERN5.equals(SYORIPTN)) {
            KousinBean kousinBean = new KousinBean();
            kosnaiyMeisKmks = new KousinBean[1];
            kousinBean.setHknry(BizCurrency.valueOf(0));
            kosnaiyMeisKmks[0] = kousinBean;
            return kosnaiyMeisKmks;
        }
        else if(caller == SetHosyouTest_exec.class && TESTPATTERN6.equals(SYORIPTN)) {
            KousinBean kousinBean = new KousinBean();
            kosnaiyMeisKmks = new KousinBean[1];
            kousinBean.setHknry(BizCurrency.valueOf(50000));
            kosnaiyMeisKmks[0] = kousinBean;
            return kosnaiyMeisKmks;
        }
        return kosnaiyMeisKmks;
    }

    @Override
    public int getKoskaisu() {

        if(caller == SetHosyouTest_exec.class && TESTPATTERN3.equals(SYORIPTN)) {
            return 0;
        }
        if(caller == SetHosyouTest_exec.class && TESTPATTERN4.equals(SYORIPTN)) {
            return 1;
        }
        if(caller == SetHosyouTest_exec.class && TESTPATTERN5.equals(SYORIPTN)) {
            return 3;
        }
        if(caller == SetHosyouTest_exec.class && TESTPATTERN6.equals(SYORIPTN)) {
            return 5;
        }
        return kosKaisuu;
    }

    public String getSyouhnCd() {
        return syouhnCd;
    }

    public void setSyouhnCd(String syouhnCd) {
        this.syouhnCd = syouhnCd;
    }

    public int getSyouhnSdNo() {
        return syouhnSdNo;
    }

    public void setSyouhnSdNo(int syouhnSdNo) {
        this.syouhnSdNo = syouhnSdNo;
    }

    public BizDate getKeiyakuBi() {
        return keiyakuBi;
    }

    public void setKeiyakuBi(BizDate keiyakuBi) {
        this.keiyakuBi = keiyakuBi;
    }

    public C_KataKbn getKataKbn() {
        return kataKbn;
    }

    public void setKataKbn(C_KataKbn kataKbn) {
        this.kataKbn = kataKbn;
    }

    public C_KyhgndkataKbn getKyhgndKataKbn() {
        return kyhgndKataKbn;
    }

    public void setKyhgndKataKbn(C_KyhgndkataKbn kyhgndKataKbn) {
        this.kyhgndKataKbn = kyhgndKataKbn;
    }

    public C_SyukyhkinkataKbn getSyukyhkinKataKbn() {
        return syukyhkinKataKbn;
    }

    public void setSyukyhkinKataKbn(C_SyukyhkinkataKbn syukyhkinKataKbn) {
        this.syukyhkinKataKbn = syukyhkinKataKbn;
    }

    public C_6daiLdKbn getDaisktsyknTuikakyhKataKbn() {
        return daisktsyknTuikakyhKataKbn;
    }

    public void setDaisktsyknTuikakyhKataKbn(C_6daiLdKbn daisktsyknTuikakyhKataKbn) {
        this.daisktsyknTuikakyhKataKbn = daisktsyknTuikakyhKataKbn;
    }

    public C_HknkknsmnKbn getHknkknSmnKbn() {
        return hknkknSmnKbn;
    }

    public void setHknkknSmnKbn(C_HknkknsmnKbn hknkknSmnKbn) {
        this.hknkknSmnKbn = hknkknSmnKbn;
    }

    public int getHknKkn() {
        return hknKkn;
    }

    public void setHknKkn(int hknKkn) {
        this.hknKkn = hknKkn;
    }

    public C_HrkkknsmnKbn getHrkkknSmnKbn() {
        return hrkkknSmnKbn;
    }

    public void setHrkkknSmnKbn(C_HrkkknsmnKbn hrkkknSmnKbn) {
        this.hrkkknSmnKbn = hrkkknSmnKbn;
    }

    public int getHrkKkn() {
        return hrkKkn;
    }

    public void setHrkKkn(int hrkKkn) {
        this.hrkKkn = hrkKkn;
    }

    public BizCurrency getHosen() {
        return hosen;
    }

    public void setHosen(BizCurrency hosen) {
        this.hosen = hosen;
    }

    public KousinBean[] getKosnaiyMeisKmks() {
        return kosnaiyMeisKmks;
    }

    public void setKosnaiyMeisKmks(KousinBean[] kosnaiyMeisKmks) {
        this.kosnaiyMeisKmks = kosnaiyMeisKmks;
    }

    public int getKosKaisuu() {
        return kosKaisuu;
    }

    public void setKosKaisuu(int kosKaisuu) {
        this.kosKaisuu = kosKaisuu;
    }

    public KeisanSP getKeisanSP() {
        return keisanSP;
    }

    public void setKeisanSP(KeisanSP keisanSP) {
        this.keisanSP = keisanSP;
    }

    public SetManryoubi getSetManryoubi() {
        return setManryoubi;
    }

    public void setSetManryoubi(SetManryoubi setManryoubi) {
        this.setManryoubi = setManryoubi;
    }

    public C_KhnkyhkgbairituKbn getKhnkyhkgbairituKbn() {
        return khnkyhkgbairituKbn;
    }

    public C_PmnjtkKbn getPmnjtkhukaKbn() {
        return pmnjtkhukaKbn;
    }

    public int getHhknNen() {
        return hhknNen;
    }

    public C_Hhknsei getHhknSei() {
        return hhknSei;
    }

    public C_Hrkkaisuu getHrkKaisuu() {
        return hrkKaisuu;
    }

    public C_Hrkkeiro getHrkKeiro() {
        return hrkKeiro;
    }

    public C_Sdpd getSdPdKbn() {
        return sdPdKbn;
    }

    @Override
    public C_ErrorKbn exec() {
        if (caller == SetHaraikomiInfoTest_exec.class) {

            if ("1234".equals(getSyouhnCd())) {
                setKosKaisuu(0);
            } else if ("1001".equals(getSyouhnCd())) {
                setKosKaisuu(1);

                KousinBean[] kosnaiyMeisKmks = new KousinBean[1];

                KousinBean kousinBean = new KousinBean();
                kousinBean.setHknry(BizCurrency.valueOf(1));
                kosnaiyMeisKmks[0] =kousinBean;

                setKosnaiyMeisKmks(kosnaiyMeisKmks);

            } else if ("2345".equals(getSyouhnCd())) {
                setKosKaisuu(0);
            } else if ("1002".equals(getSyouhnCd())) {
                setKosKaisuu(0);
            } else if ("7890".equals(getSyouhnCd())) {
                setKosKaisuu(2);

                KousinBean[] kosnaiyMeisKmks = new KousinBean[2];

                KousinBean kousinBean1 = new KousinBean();
                kousinBean1.setHknry(BizCurrency.valueOf(2));
                kosnaiyMeisKmks[0] =kousinBean1;

                KousinBean kousinBean2 = new KousinBean();
                kousinBean2.setHknry(BizCurrency.valueOf(1));
                kosnaiyMeisKmks[1] =kousinBean2;

                setKosnaiyMeisKmks(kosnaiyMeisKmks);
            }
            return C_ErrorKbn.OK;
        }

        super.setSyouhncd(this.syouhnCd);
        super.setSyouhnSdno(this.syouhnSdNo);
        super.setHknkknSmnkbn(this.hknkknSmnKbn);
        super.setHhknNen(this.hhknNen);
        super.setHknkkn(this.hknKkn);
        super.setHrkkkn(this.hrkKkn);
        super.setKeiyakubi(this.keiyakuBi);

        super.setKatakbn(this.kataKbn);
        super.setKyhgndKatakbn(this.kyhgndKataKbn);
        super.setSyukyhkinKatakbn(this.syukyhkinKataKbn);
        super.setKhnkyhkgbairituKbn(this.khnkyhkgbairituKbn);
        super.set6DaisktsyknTuikakyhKatakbn(this.daisktsyknTuikakyhKataKbn);
        super.setPmnjtkhukaKbn(this.pmnjtkhukaKbn);
        super.setHrkkknSmnkbn(this.hrkkknSmnKbn);
        super.setHhknSei(this.hhknSei);
        super.setHrkKaisuu(this.hrkKaisuu);
        super.setHrkKeiro(this.hrkKeiro);
        super.setSdPdKbn(this.sdPdKbn);
        super.setS(this.hosen);

        C_ErrorKbn errorKbn = super.exec();

        this.kosKaisuu = super.getKoskaisu();
        this.kosnaiyMeisKmks = super.getKosnaiymeiskmk();

        return errorKbn;
    }
}
