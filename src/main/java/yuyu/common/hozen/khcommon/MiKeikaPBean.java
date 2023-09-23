package yuyu.common.hozen.khcommon;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_Hrkkaisuu;

/**
 * 契約保全 契約保全共通 未経過Ｐ項目Bean
 */
public class MiKeikaPBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizCurrency miKeikaP;

    private BizDate mkeiPNykDenYmd;

    private C_Hrkkaisuu mkeiPHrkKaisuu;

    private int mkeiPJytKaisuuY;

    private int mkeiPJytKaisuuM;

    private BizDateYM mkeiPJytYm;

    public MiKeikaPBean() {
        super();
    }

    public BizCurrency getMiKeikaP(){
        return miKeikaP;
    }

    public void setMiKeikaP(BizCurrency pMiKeikaP){
        miKeikaP = pMiKeikaP;
    }

    public BizDate getMkeiPNykDenYmd(){
        return mkeiPNykDenYmd;
    }

    public void setMkeiPNykDenYmd(BizDate pMkeiPNykDenYmd){
        mkeiPNykDenYmd = pMkeiPNykDenYmd;
    }

    public C_Hrkkaisuu getMkeiPHrkKaisuu(){
        return mkeiPHrkKaisuu;
    }

    public void setMkeiPHrkKaisuu(C_Hrkkaisuu pMkeiPHrkKaisuu){
        mkeiPHrkKaisuu = pMkeiPHrkKaisuu;
    }

    public int getMkeiPJytKaisuuY(){
        return mkeiPJytKaisuuY;
    }

    public void setMkeiPJytKaisuuY(int pMkeiPJytKaisuuY){
        mkeiPJytKaisuuY = pMkeiPJytKaisuuY;
    }

    public int getMkeiPJytKaisuuM(){
        return mkeiPJytKaisuuM;
    }

    public void setMkeiPJytKaisuuM(int pMkeiPJytKaisuuM){
        mkeiPJytKaisuuM = pMkeiPJytKaisuuM;
    }

    public BizDateYM getMkeiPJytYm(){
        return mkeiPJytYm;
    }

    public void setMkeiPJytYm(BizDateYM pMkeiPJytYm){
        mkeiPJytYm = pMkeiPJytYm;
    }
}
