package yuyu.app.sinkeiyaku.sknyuukin.sknyuukinhenkinkakunin;

import java.io.Serializable;
import jp.co.slcs.swak.number.BizCurrency;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 入金／返金状況確認 - ●合計 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenGoukeiInfoDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String dispgkdtendt;

    public String getDispgkdtendt() {
        return dispgkdtendt;
    }

    public void setDispgkdtendt(String pDispgkdtendt) {
        dispgkdtendt = pDispgkdtendt;
    }


    private C_Tuukasyu disprstuukasyu;

    public C_Tuukasyu getDisprstuukasyu() {
        return disprstuukasyu;
    }

    public void setDisprstuukasyu(C_Tuukasyu pDisprstuukasyu) {
        disprstuukasyu = pDisprstuukasyu;
    }


    private Integer dispkensuu;

    public Integer getDispkensuu() {
        return dispkensuu;
    }

    public void setDispkensuu(Integer pDispkensuu) {
        dispkensuu = pDispkensuu;
    }


    private BizCurrency disprskingaku;

    public BizCurrency getDisprskingaku() {
        return disprskingaku;
    }

    public void setDisprskingaku(BizCurrency pDisprskingaku) {
        disprskingaku = pDisprskingaku;
    }


    private BizCurrency disprsdengkyen;

    public BizCurrency getDisprsdengkyen() {
        return disprsdengkyen;
    }

    public void setDisprsdengkyen(BizCurrency pDisprsdengkyen) {
        disprsdengkyen = pDisprsdengkyen;
    }

}
