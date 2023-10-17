package yuyu.app.sinkeiyaku.skkettei.skimusatei;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_SateiketsyorinmKbn;
import yuyu.def.classification.C_SyorikekkaKbn;

/**
 * 医務査定 - ●申込点検履歴 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenMoushiTenkenRirekiDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizDate dispmostenkensyoriymd;

    public BizDate getDispmostenkensyoriymd() {
        return dispmostenkensyoriymd;
    }

    public void setDispmostenkensyoriymd(BizDate pDispmostenkensyoriymd) {
        dispmostenkensyoriymd = pDispmostenkensyoriymd;
    }


    private C_SateiketsyorinmKbn dispmostnknstktsyorinmkbn;

    public C_SateiketsyorinmKbn getDispmostnknstktsyorinmkbn() {
        return dispmostnknstktsyorinmkbn;
    }

    public void setDispmostnknstktsyorinmkbn(C_SateiketsyorinmKbn pDispmostnknstktsyorinmkbn) {
        dispmostnknstktsyorinmkbn = pDispmostnknstktsyorinmkbn;
    }


    private C_SyorikekkaKbn dispmostenkenkekkakbn;

    public C_SyorikekkaKbn getDispmostenkenkekkakbn() {
        return dispmostenkenkekkakbn;
    }

    public void setDispmostenkenkekkakbn(C_SyorikekkaKbn pDispmostenkenkekkakbn) {
        dispmostenkenkekkakbn = pDispmostenkenkekkakbn;
    }


    private String dispmostenkenktnm;

    public String getDispmostenkenktnm() {
        return dispmostenkenktnm;
    }

    public void setDispmostenkenktnm(String pDispmostenkenktnm) {
        dispmostenkenktnm = pDispmostenkenktnm;
    }


    private String dispmostenkencomment;

    public String getDispmostenkencomment() {
        return dispmostenkencomment;
    }

    public void setDispmostenkencomment(String pDispmostenkencomment) {
        dispmostenkencomment = pDispmostenkencomment;
    }

}
