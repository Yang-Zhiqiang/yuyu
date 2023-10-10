package yuyu.app.hozen.khozen.khkeiyakuhenkou;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_KakuninkekkaKbn;

/**
 * 契約変更 - ●確認履歴 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenKakuninKekkaInfoDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizDate dispnaiyoukakymd;

    public BizDate getDispnaiyoukakymd() {
        return dispnaiyoukakymd;
    }

    public void setDispnaiyoukakymd(BizDate pDispnaiyoukakymd) {
        dispnaiyoukakymd = pDispnaiyoukakymd;
    }


    private String dispsousasyanm;

    public String getDispsousasyanm() {
        return dispsousasyanm;
    }

    public void setDispsousasyanm(String pDispsousasyanm) {
        dispsousasyanm = pDispsousasyanm;
    }


    private String disptasknm;

    public String getDisptasknm() {
        return disptasknm;
    }

    public void setDisptasknm(String pDisptasknm) {
        disptasknm = pDisptasknm;
    }


    private C_KakuninkekkaKbn dispkakuninkekkakbn;

    public C_KakuninkekkaKbn getDispkakuninkekkakbn() {
        return dispkakuninkekkakbn;
    }

    public void setDispkakuninkekkakbn(C_KakuninkekkaKbn pDispkakuninkekkakbn) {
        dispkakuninkekkakbn = pDispkakuninkekkakbn;
    }


    private String dispcomment;

    public String getDispcomment() {
        return dispcomment;
    }

    public void setDispcomment(String pDispcomment) {
        dispcomment = pDispcomment;
    }

}
