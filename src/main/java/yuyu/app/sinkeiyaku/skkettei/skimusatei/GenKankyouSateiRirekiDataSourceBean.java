package yuyu.app.sinkeiyaku.skkettei.skimusatei;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_SateiketsyorinmKbn;
import yuyu.def.classification.C_SyorikekkaKbn;

/**
 * 医務査定 - ●環境査定履歴 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenKankyouSateiRirekiDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizDate dispknksyoriymd;

    public BizDate getDispknksyoriymd() {
        return dispknksyoriymd;
    }

    public void setDispknksyoriymd(BizDate pDispknksyoriymd) {
        dispknksyoriymd = pDispknksyoriymd;
    }


    private C_SateiketsyorinmKbn dispknkstktsyorinmkbn;

    public C_SateiketsyorinmKbn getDispknkstktsyorinmkbn() {
        return dispknkstktsyorinmkbn;
    }

    public void setDispknkstktsyorinmkbn(C_SateiketsyorinmKbn pDispknkstktsyorinmkbn) {
        dispknkstktsyorinmkbn = pDispknkstktsyorinmkbn;
    }


    private C_SyorikekkaKbn dispknkkekkakbn;

    public C_SyorikekkaKbn getDispknkkekkakbn() {
        return dispknkkekkakbn;
    }

    public void setDispknkkekkakbn(C_SyorikekkaKbn pDispknkkekkakbn) {
        dispknkkekkakbn = pDispknkkekkakbn;
    }


    private String dispknkktnm;

    public String getDispknkktnm() {
        return dispknkktnm;
    }

    public void setDispknkktnm(String pDispknkktnm) {
        dispknkktnm = pDispknkktnm;
    }


    private String dispknkcomment;

    public String getDispknkcomment() {
        return dispknkcomment;
    }

    public void setDispknkcomment(String pDispknkcomment) {
        dispknkcomment = pDispknkcomment;
    }

}
