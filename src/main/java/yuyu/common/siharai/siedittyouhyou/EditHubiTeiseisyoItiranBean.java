package yuyu.common.siharai.siedittyouhyou;

import java.io.Serializable;

import yuyu.def.classification.C_HassinsakiKbn;
import yuyu.def.classification.C_UmuKbn;


/**
 * 保険金給付金支払 保険金給付金支払帳票編集 不備訂正書一覧Bean
 */
public class EditHubiTeiseisyoItiranBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String hubinaiyouMsg;

    private C_UmuKbn genponhnkyKumu;

    private C_HassinsakiKbn hassinsakiKbn;

    public EditHubiTeiseisyoItiranBean() {
        super();
    }

    public String getHubinaiyoumsg() {
        return hubinaiyouMsg;
    }

    public void setHubinaiyoumsg(String pHubinaiyouMsg) {
        hubinaiyouMsg = pHubinaiyouMsg;
    }

    public C_UmuKbn getGenponhnkykumu() {
        return genponhnkyKumu;
    }

    public void setGenponhnkykumu(C_UmuKbn pGenponhnkyKumu) {
        genponhnkyKumu = pGenponhnkyKumu;
    }

    public C_HassinsakiKbn getHassinsakiKbn() {
        return hassinsakiKbn;
    }

    public void setHassinsakiKbn(C_HassinsakiKbn pHassinsakiKbn) {
        this.hassinsakiKbn = pHassinsakiKbn;
    }


}
