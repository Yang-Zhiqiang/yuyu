package yuyu.app.hozen.khozen.khkawaserateyoteirrtsyoukai;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 為替レート予定利率推移照会（平準払） - referenceList の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenReferenceListDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizDateYM dispym;

    public BizDateYM getDispym() {
        return dispym;
    }

    public void setDispym(BizDateYM pDispym) {
        dispym = pDispym;
    }


    private BizCurrency disphrkp;

    public BizCurrency getDisphrkp() {
        return disphrkp;
    }

    public void setDisphrkp(BizCurrency pDisphrkp) {
        disphrkp = pDisphrkp;
    }


    private BizDate dispgaikaknsnkwsratekjymd;

    public BizDate getDispgaikaknsnkwsratekjymd() {
        return dispgaikaknsnkwsratekjymd;
    }

    public void setDispgaikaknsnkwsratekjymd(BizDate pDispgaikaknsnkwsratekjymd) {
        dispgaikaknsnkwsratekjymd = pDispgaikaknsnkwsratekjymd;
    }


    private BizNumber dispgaikaknsnkwsrate;

    public BizNumber getDispgaikaknsnkwsrate() {
        return dispgaikaknsnkwsrate;
    }

    public void setDispgaikaknsnkwsrate(BizNumber pDispgaikaknsnkwsrate) {
        dispgaikaknsnkwsrate = pDispgaikaknsnkwsrate;
    }


    private C_Tuukasyu dispkyktuukasyu;

    public C_Tuukasyu getDispkyktuukasyu() {
        return dispkyktuukasyu;
    }

    public void setDispkyktuukasyu(C_Tuukasyu pDispkyktuukasyu) {
        dispkyktuukasyu = pDispkyktuukasyu;
    }


    private BizCurrency disppgaika;

    public BizCurrency getDisppgaika() {
        return disppgaika;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDisppgaika(BizCurrency pDisppgaika) {
        disppgaika = pDisppgaika;
    }


    private BizNumber dispytirrtcalckijyunrrt;

    public BizNumber getDispytirrtcalckijyunrrt() {
        return dispytirrtcalckijyunrrt;
    }

    public void setDispytirrtcalckijyunrrt(BizNumber pDispytirrtcalckijyunrrt) {
        dispytirrtcalckijyunrrt = pDispytirrtcalckijyunrrt;
    }

}
