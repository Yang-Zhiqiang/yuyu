package yuyu.common.suuri.srcommon;

import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;

/**
 *  特定時点契約基本情報Beanクラス
 */
public class SrGetTokutejitenKykKihonInfoBean {

    private C_TkiktbrisyuruiKbn tikiktbrisyuruiKbnMae;

    private C_TkiktbrisyuruiKbn tikiktbrisyuruiKbnAto;

    private C_Hrkkeiro hrkkeiroMae;

    private C_Hrkkeiro hrkkeiroAto;

    private C_Hrkkaisuu hrkkaisuuMae;

    private C_Hrkkaisuu hrkkaisuuAto;

    SrGetTokutejitenKykKihonInfoBean() {
        super();

        tikiktbrisyuruiKbnMae = C_TkiktbrisyuruiKbn.BLNK;
        tikiktbrisyuruiKbnAto = C_TkiktbrisyuruiKbn.BLNK;
        hrkkeiroMae = C_Hrkkeiro.BLNK;
        hrkkeiroAto = C_Hrkkeiro.BLNK;
        hrkkaisuuMae = C_Hrkkaisuu.BLNK;
        hrkkaisuuAto = C_Hrkkaisuu.BLNK;
    }

    public C_TkiktbrisyuruiKbn getTikiktbrisyuruiKbnMae() {
        return tikiktbrisyuruiKbnMae;
    }

    public void setTikiktbrisyuruiKbnMae(C_TkiktbrisyuruiKbn pTikiktbrisyuruiKbnMae) {
        this.tikiktbrisyuruiKbnMae = pTikiktbrisyuruiKbnMae;
    }

    public C_TkiktbrisyuruiKbn getTikiktbrisyuruiKbnAto() {
        return tikiktbrisyuruiKbnAto;
    }

    public void setTikiktbrisyuruiKbnAto(C_TkiktbrisyuruiKbn pTikiktbrisyuruiKbnAto) {
        this.tikiktbrisyuruiKbnAto = pTikiktbrisyuruiKbnAto;
    }

    public C_Hrkkeiro getHrkkeiroMae() {
        return hrkkeiroMae;
    }

    public void setHrkkeiroMae(C_Hrkkeiro pHrkkeiroMae) {
        this.hrkkeiroMae = pHrkkeiroMae;
    }

    public C_Hrkkeiro getHrkkeiroAto() {
        return hrkkeiroAto;
    }

    public void setHrkkeiroAto(C_Hrkkeiro pHrkkeiroAto) {
        this.hrkkeiroAto = pHrkkeiroAto;
    }

    public C_Hrkkaisuu getHrkkaisuuMae() {
        return hrkkaisuuMae;
    }

    public void setHrkkaisuuMae(C_Hrkkaisuu pHrkkaisuuMae) {
        this.hrkkaisuuMae = pHrkkaisuuMae;
    }

    public C_Hrkkaisuu getHrkkaisuuAto() {
        return hrkkaisuuAto;
    }

    public void setHrkkaisuuAto(C_Hrkkaisuu pHrkkaisuuAto) {
        this.hrkkaisuuAto = pHrkkaisuuAto;
    }
}
