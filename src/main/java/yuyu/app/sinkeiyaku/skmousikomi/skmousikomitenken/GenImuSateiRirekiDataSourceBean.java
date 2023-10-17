package yuyu.app.sinkeiyaku.skmousikomi.skmousikomitenken;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_SateiketsyorinmKbn;
import yuyu.def.classification.C_SyorikekkaKbn;

/**
 * 申込点検 - ●医務査定履歴 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenImuSateiRirekiDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizDate dispimusyoriymd;

    public BizDate getDispimusyoriymd() {
        return dispimusyoriymd;
    }

    public void setDispimusyoriymd(BizDate pDispimusyoriymd) {
        dispimusyoriymd = pDispimusyoriymd;
    }


    private C_SateiketsyorinmKbn dispimustktsyorinmkbn;

    public C_SateiketsyorinmKbn getDispimustktsyorinmkbn() {
        return dispimustktsyorinmkbn;
    }

    public void setDispimustktsyorinmkbn(C_SateiketsyorinmKbn pDispimustktsyorinmkbn) {
        dispimustktsyorinmkbn = pDispimustktsyorinmkbn;
    }


    private C_SyorikekkaKbn dispimukekkakbn;

    public C_SyorikekkaKbn getDispimukekkakbn() {
        return dispimukekkakbn;
    }

    public void setDispimukekkakbn(C_SyorikekkaKbn pDispimukekkakbn) {
        dispimukekkakbn = pDispimukekkakbn;
    }


    private String dispimuktnm;

    public String getDispimuktnm() {
        return dispimuktnm;
    }

    public void setDispimuktnm(String pDispimuktnm) {
        dispimuktnm = pDispimuktnm;
    }


    private String dispimucomment;

    public String getDispimucomment() {
        return dispimucomment;
    }

    public void setDispimucomment(String pDispimucomment) {
        dispimucomment = pDispimucomment;
    }

}
