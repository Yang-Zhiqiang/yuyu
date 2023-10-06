package yuyu.app.workflow.imagekanri.torikomihyousisakusei;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_Kouteikanristatus;

/**
 * 取込用表紙作成 - ankenList の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenAnkenListDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String dispjimutetuzukinm;

    public String getDispjimutetuzukinm() {
        return dispjimutetuzukinm;
    }

    public void setDispjimutetuzukinm(String pDispjimutetuzukinm) {
        dispjimutetuzukinm = pDispjimutetuzukinm;
    }


    private C_Kouteikanristatus dispkouteikanristatus;

    public C_Kouteikanristatus getDispkouteikanristatus() {
        return dispkouteikanristatus;
    }

    public void setDispkouteikanristatus(C_Kouteikanristatus pDispkouteikanristatus) {
        dispkouteikanristatus = pDispkouteikanristatus;
    }


    private BizDate dispkouteikaisiymd;

    public BizDate getDispkouteikaisiymd() {
        return dispkouteikaisiymd;
    }

    public void setDispkouteikaisiymd(BizDate pDispkouteikaisiymd) {
        dispkouteikaisiymd = pDispkouteikaisiymd;
    }


    private BizDate dispjimustartymd;

    public BizDate getDispjimustartymd() {
        return dispjimustartymd;
    }

    public void setDispjimustartymd(BizDate pDispjimustartymd) {
        dispjimustartymd = pDispjimustartymd;
    }


    private BizDate dispkouteikanymd;

    public BizDate getDispkouteikanymd() {
        return dispkouteikanymd;
    }

    public void setDispkouteikanymd(BizDate pDispkouteikanymd) {
        dispkouteikanymd = pDispkouteikanymd;
    }


    private String sakuseiLink;

    public String getSakuseiLink() {
        return sakuseiLink;
    }

    public void setSakuseiLink(String pSakuseiLink) {
        sakuseiLink = pSakuseiLink;
    }

}
