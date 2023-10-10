package yuyu.app.siharai.sisatei.sisateisb;

import java.io.Serializable;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_SyorikekkaKbn;

/**
 * （死亡）査定 - ●確認項目 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenViewKakuninkoumokuInfoDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizDate dispsyoriymd;

    public BizDate getDispsyoriymd() {
        return dispsyoriymd;
    }

    public void setDispsyoriymd(BizDate pDispsyoriymd) {
        dispsyoriymd = pDispsyoriymd;
    }


    private String disptasknm;

    public String getDisptasknm() {
        return disptasknm;
    }

    public void setDisptasknm(String pDisptasknm) {
        disptasknm = pDisptasknm;
    }


    private C_SyorikekkaKbn dispsyorikekkakbn;

    public C_SyorikekkaKbn getDispsyorikekkakbn() {
        return dispsyorikekkakbn;
    }

    public void setDispsyorikekkakbn(C_SyorikekkaKbn pDispsyorikekkakbn) {
        dispsyorikekkakbn = pDispsyorikekkakbn;
    }


    private String dispsousasyanm;

    public String getDispsousasyanm() {
        return dispsousasyanm;
    }

    public void setDispsousasyanm(String pDispsousasyanm) {
        dispsousasyanm = pDispsousasyanm;
    }


    private String dispcomment;

    public String getDispcomment() {
        return dispcomment;
    }

    public void setDispcomment(String pDispcomment) {
        dispcomment = pDispcomment;
    }

}
