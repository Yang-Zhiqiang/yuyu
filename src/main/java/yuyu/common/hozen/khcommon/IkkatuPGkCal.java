package yuyu.common.hozen.khcommon;

import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.def.classification.C_6daiLdKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_KataKbn;
import yuyu.def.classification.C_KhnkyhkgbairituKbn;
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_PmnjtkKbn;
import yuyu.def.classification.C_SyukyhkinkataKbn;

/**
 * 契約保全 契約保全共通 一括払P計算
 */
public class IkkatuPGkCal {

    private String syouhnCd;

    private int syouhnSdno;

    private C_KataKbn kataKbn;

    private C_KyhgndkataKbn kyhgndKataKbn;

    private C_SyukyhkinkataKbn syukyhkinKataKbn;

    private C_KhnkyhkgbairituKbn khnkyhkgBairituKbn;

    private C_6daiLdKbn rokudaiSktsyknTuikakyhKataKbn;

    private C_PmnjtkKbn pmnjTkKbn;

    private C_HknkknsmnKbn hknkknSmnKbn;

    private int hknKkn;

    private C_HrkkknsmnKbn hrKkknSmnKbn;

    private int hrkKkn;

    private int hhknNen;

    private C_Hhknsei hhknSei;

    private C_Hrkkaisuu hrkKaisuu;

    private C_Hrkkeiro hrkKeiro;

    private BizCurrency hknGk;

    private int keikaMon;

    private BizCurrency ikkatuP = null;

    private BizCurrency iktWaribikikGk = null;

    public IkkatuPGkCal() {
        super();
    }

    public void setSyouhncd(String pSyouhnCd) {
        syouhnCd = pSyouhnCd;
    }

    public void setSyouhnSdno(int pSyouhnSdno) {
        syouhnSdno = pSyouhnSdno;
    }

    public void setKatakbn(C_KataKbn pKataKbn) {
        kataKbn = pKataKbn;
    }

    public void setKyhgndKatakbn(C_KyhgndkataKbn pKyhgndKataKbn) {
        kyhgndKataKbn = pKyhgndKataKbn;
    }

    public void setSyukyhkinKatakbn(C_SyukyhkinkataKbn pSyukyhkinKataKbn) {
        syukyhkinKataKbn = pSyukyhkinKataKbn;
    }

    public void setKhnkyhkgBairitukbn(C_KhnkyhkgbairituKbn pKhnkyhkgBairituKbn) {
        khnkyhkgBairituKbn = pKhnkyhkgBairituKbn;
    }

    public void set6daisktsykntuikakyhKatakbn(C_6daiLdKbn p6daiSktsyknTuikakyhKataKbn) {
        rokudaiSktsyknTuikakyhKataKbn = p6daiSktsyknTuikakyhKataKbn;
    }

    public void setPmnjTkkbn(C_PmnjtkKbn pPmnjTkKbn) {
        pmnjTkKbn = pPmnjTkKbn;
    }

    public void setHknkknSmnkbn(C_HknkknsmnKbn pHhnkknSmnKbn) {
        hknkknSmnKbn = pHhnkknSmnKbn;
    }

    public void setHknkkn(int pHknKkn) {
        hknKkn = pHknKkn;
    }

    public void setHrkkknSmnkbn(C_HrkkknsmnKbn pHrKkknSmnKbn) {
        hrKkknSmnKbn = pHrKkknSmnKbn;
    }

    public void setHrkkkn(int pHrkKkn) {
        hrkKkn = pHrkKkn;
    }

    public void setHhknNen(Integer pHhknNen) {
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

    public void setS(BizCurrency pHknGk) {
        hknGk = pHknGk;
    }

    public void setKeikatukisuu(int pKeikaMon) {
        keikaMon = pKeikaMon;
    }

    public BizCurrency getIkkatuP() {
        return ikkatuP;
    }

    public BizCurrency getIktwaribikikgk() {
        return iktWaribikikGk;
    }

    public void exec() {

        /*
        BM_SyouhnZokusei syouhinZokusei = bizDomManager.getSyouhnZokusei(syouhnCd, syouhnSdno);
        if (syouhinZokusei == null) {
            throw new CommonBizAppException("一括払Ｐ計算が実行できませんでした。");
        }

        int rrVersion = syouhinZokusei.getRyourituversion();
        BizNumber prateTani = syouhinZokusei.getPratetani();
        int iktpCalcssKetasuu = syouhinZokusei.getIktpcalcssketasuu();

        if (iktpCalcssKetasuu > 0) {
            iktpCalcssKetasuu = iktpCalcssKetasuu - 1;
        }

        BM_RateP rateP = bizDomManager.getRateP(syouhnCd, rrVersion, kataKbn, kyhgndKataKbn,
                syukyhkinKataKbn, khnkyhkgBairituKbn, rokudaiSktsyknTuikakyhKataKbn, pmnjTkKbn,
                hknkknSmnKbn, hknKkn, hrKkknSmnKbn, hrkKkn, hhknNen, hhknSei, hrkKaisuu);
        if (rateP == null) {
            throw new CommonBizAppException("一括払Ｐ計算が実行できませんでした。");
        }
        BizNumber pRate = rateP.getPrate();

        BM_IkkatuKeisuu ikkatuKeisuu = bizDomManager.getIkkatuKeisuu(syouhnCd, rrVersion, keikaMon);
        if (ikkatuKeisuu == null) {
            throw new CommonBizAppException("一括払Ｐ計算が実行できませんでした。");
        }
        BizNumber iktKeisuu = ikkatuKeisuu.getIktkeisuu();

        BM_PfIkkatuKeisuu pfIkkatukeisuu = bizDomManager.getPfIkkatuKeisuu(syouhnCd, rrVersion, keikaMon);
        BizNumber pfIkkatuKeisuu = null;
        if (pfIkkatukeisuu == null) {
            pfIkkatuKeisuu = BizNumber.ZERO;
        }
        else {
            pfIkkatuKeisuu = pfIkkatukeisuu.getPfiktkeisuu();
        }


        BizNumber iktHrkP = pRate.multiply(iktKeisuu).round(iktpCalcssKetasuu, RoundingMode.HALF_UP);
        ikkatuP = hknGk.divide(prateTani).multiply(iktHrkP).round(0, RoundingMode.DOWN);
        hozenKeisanSP.setSyouhncd(syouhnCd);
        hozenKeisanSP.setSyouhnSdno(syouhnSdno);
        hozenKeisanSP.setKatakbn(kataKbn);
        hozenKeisanSP.setKyhgndKatakbn(kyhgndKataKbn);
        hozenKeisanSP.setSyukyhkinKatakbn(syukyhkinKataKbn);
        hozenKeisanSP.setKhnkyhkgbairituKbn(khnkyhkgBairituKbn);
        hozenKeisanSP.set6DaisktsyknTuikakyhKatakbn(rokudaiSktsyknTuikakyhKataKbn);
        hozenKeisanSP.setPmnjtkhukaKbn(pmnjTkKbn);
        hozenKeisanSP.setHknkknSmnkbn(hknkknSmnKbn);
        hozenKeisanSP.setHknkkn(hknKkn);
        hozenKeisanSP.setHrkkknSmnkbn(hrKkknSmnKbn);
        hozenKeisanSP.setHrkkkn(hrkKkn);
        hozenKeisanSP.setHhknNen(hhknNen);
        hozenKeisanSP.setHhknSei(hhknSei);
        hozenKeisanSP.setHrkKaisuu(hrkKaisuu);
        hozenKeisanSP.setHrkKeiro(hrkKeiro);
        hozenKeisanSP.setSdPdKbn(C_Sdpd.SD);
        hozenKeisanSP.setS(hknGk);

        C_ErrorKbn errorKbn = hozenKeisanSP.exec();
        if (!C_ErrorKbn.OK.eq(errorKbn)) {
            throw new BizLogicException(hozenKeisanSP.getMsgid(), hozenKeisanSP.getMsg());
        }

        BizCurrency pfIkkatubaraiGk = hozenKeisanSP.getPfGk().multiply(pfIkkatuKeisuu).round(0, RoundingMode.DOWN);

        ikkatuP = ikkatuP.add(pfIkkatubaraiGk);

        BizCurrency tukibaraiP = hozenKeisanSP.getP();

        iktWaribikikGk = tukibaraiP.multiply(keikaMon).subtract(ikkatuP);*/

        ikkatuP = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        iktWaribikikGk = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
    }
}
