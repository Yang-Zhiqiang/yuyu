package yuyu.common.hozen.khcommon;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_UmuKbn;

/**
 * 契約保全 契約保全共通 未収Ｐ項目Bean
 */
public class MisyuuPBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizCurrency misyuuP;

    private BizCurrency misyuuPGaika;

    private C_UmuKbn msyPIkkatuNkUmu;

    private C_Hrkkaisuu msyPHrkKaisuu;

    private int msyPJytKaisuuY;

    private int msyPJytKaisuuM;

    private BizDateYM msyPJytYm;

    public MisyuuPBean() {
        super();
    }

    public BizCurrency getMisyuuP(){
        return misyuuP;
    }

    public void setMisyuuP(BizCurrency pMisyuuP){
        misyuuP = pMisyuuP;
    }

    public BizCurrency getMisyuuPGaika() {
        return misyuuPGaika;
    }

    public void setMisyuuPGaika(BizCurrency pMisyuuPGaika) {
        misyuuPGaika = pMisyuuPGaika;
    }

    public C_UmuKbn getMsyPIkkatuNkUmu(){
        return msyPIkkatuNkUmu;
    }

    public void setMsyPIkkatuNkUmu(C_UmuKbn pMsyPIkkatuNkUmu){
        msyPIkkatuNkUmu = pMsyPIkkatuNkUmu;
    }

    public C_Hrkkaisuu getMsyPHrkKaisuu(){
        return msyPHrkKaisuu;
    }

    public void setMsyPHrkKaisuu(C_Hrkkaisuu pMsyPHrkKaisuu){
        msyPHrkKaisuu = pMsyPHrkKaisuu;
    }

    public int getMsyPJytKaisuuY(){
        return msyPJytKaisuuY;
    }

    public void setMsyPJytKaisuuY(int pMsyPJytKaisuuY){
        msyPJytKaisuuY = pMsyPJytKaisuuY;
    }

    public int getMsyPJytKaisuuM(){
        return msyPJytKaisuuM;
    }

    public void setMsyPJytKaisuuM(int pMsyPJytKaisuuM){
        msyPJytKaisuuM = pMsyPJytKaisuuM;
    }

    public BizDateYM getMsyPJytYm(){
        return msyPJytYm;
    }

    public void setMsyPJytYm(BizDateYM pMsyPJytYm){
        msyPJytYm = pMsyPJytYm;
    }

}
