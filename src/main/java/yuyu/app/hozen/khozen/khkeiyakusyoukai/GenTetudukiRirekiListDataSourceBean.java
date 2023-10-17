package yuyu.app.hozen.khozen.khkeiyakusyoukai;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;

/**
 * 契約内容照会 - tetudukiRirekiList の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenTetudukiRirekiListDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizDate dispsyoriymd;

    public BizDate getDispsyoriymd() {
        return dispsyoriymd;
    }

    public void setDispsyoriymd(BizDate pDispsyoriymd) {
        dispsyoriymd = pDispsyoriymd;
    }


    private String dispsyorinaiyou;

    public String getDispsyorinaiyou() {
        return dispsyorinaiyou;
    }

    public void setDispsyorinaiyou(String pDispsyorinaiyou) {
        dispsyorinaiyou = pDispsyorinaiyou;
    }


    private String dispsyorisosikinm;

    public String getDispsyorisosikinm() {
        return dispsyorisosikinm;
    }

    public void setDispsyorisosikinm(String pDispsyorisosikinm) {
        dispsyorisosikinm = pDispsyorisosikinm;
    }


    private String dispsyoritntnmkj;

    public String getDispsyoritntnmkj() {
        return dispsyoritntnmkj;
    }

    public void setDispsyoritntnmkj(String pDispsyoritntnmkj) {
        dispsyoritntnmkj = pDispsyoritntnmkj;
    }


    private String hyoujilink1;

    public String getHyoujilink1() {
        return hyoujilink1;
    }

    public void setHyoujilink1(String pHyoujilink1) {
        hyoujilink1 = pHyoujilink1;
    }

}
