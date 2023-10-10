package yuyu.app.hozen.khozen.khkeiyakusyoukai;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_Nyktrksflg;
import yuyu.def.classification.C_Tuukasyu;

/**
 * 契約内容照会 - nyuukinRirekiInfo の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenNyuukinRirekiInfoDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizDate dispryosyuymd;

    public BizDate getDispryosyuymd() {
        return dispryosyuymd;
    }

    public void setDispryosyuymd(BizDate pDispryosyuymd) {
        dispryosyuymd = pDispryosyuymd;
    }


    private C_Nykkeiro dispnykkeiro;

    public C_Nykkeiro getDispnykkeiro() {
        return dispnykkeiro;
    }

    public void setDispnykkeiro(C_Nykkeiro pDispnykkeiro) {
        dispnykkeiro = pDispnykkeiro;
    }


    private BizDateYM dispjyuutouym;

    public BizDateYM getDispjyuutouym() {
        return dispjyuutouym;
    }

    public void setDispjyuutouym(BizDateYM pDispjyuutouym) {
        dispjyuutouym = pDispjyuutouym;
    }


    private String dispjyutoukaisuu;

    public String getDispjyutoukaisuu() {
        return dispjyutoukaisuu;
    }

    public void setDispjyutoukaisuu(String pDispjyutoukaisuu) {
        dispjyutoukaisuu = pDispjyutoukaisuu;
    }


    private BizCurrency disphrkp;

    public BizCurrency getDisphrkp() {
        return disphrkp;
    }

    public void setDisphrkp(BizCurrency pDisphrkp) {
        disphrkp = pDisphrkp;
    }


    private BizCurrency disprskingaku;

    public BizCurrency getDisprskingaku() {
        return disprskingaku;
    }

    public void setDisprskingaku(BizCurrency pDisprskingaku) {
        disprskingaku = pDisprskingaku;
    }


    private BizNumber dispkawaserate;

    public BizNumber getDispkawaserate() {
        return dispkawaserate;
    }

    public void setDispkawaserate(BizNumber pDispkawaserate) {
        dispkawaserate = pDispkawaserate;
    }


    private C_Tuukasyu disprstuukasyu;

    public C_Tuukasyu getDisprstuukasyu() {
        return disprstuukasyu;
    }

    public void setDisprstuukasyu(C_Tuukasyu pDisprstuukasyu) {
        disprstuukasyu = pDisprstuukasyu;
    }


    private C_Tuukasyu dispkyktuukasyu;

    public C_Tuukasyu getDispkyktuukasyu() {
        return dispkyktuukasyu;
    }

    public void setDispkyktuukasyu(C_Tuukasyu pDispkyktuukasyu) {
        dispkyktuukasyu = pDispkyktuukasyu;
    }


    private C_Nyktrksflg dispnyktrks;

    public C_Nyktrksflg getDispnyktrks() {
        return dispnyktrks;
    }

    public void setDispnyktrks(C_Nyktrksflg pDispnyktrks) {
        dispnyktrks = pDispnyktrks;
    }

}
