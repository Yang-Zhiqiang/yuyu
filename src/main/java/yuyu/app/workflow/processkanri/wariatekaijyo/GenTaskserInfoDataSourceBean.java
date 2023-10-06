package yuyu.app.workflow.processkanri.wariatekaijyo;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;

/**
 * 担当者割当解除 - taskserInfo の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenTaskserInfoDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizDate dispjimustartymd;

    public BizDate getDispjimustartymd() {
        return dispjimustartymd;
    }

    public void setDispjimustartymd(BizDate pDispjimustartymd) {
        dispjimustartymd = pDispjimustartymd;
    }


    private String disptasknm;

    public String getDisptasknm() {
        return disptasknm;
    }

    public void setDisptasknm(String pDisptasknm) {
        disptasknm = pDisptasknm;
    }


    private String disptantounm;

    public String getDisptantounm() {
        return disptantounm;
    }

    public void setDisptantounm(String pDisptantounm) {
        disptantounm = pDisptantounm;
    }


    private String dispGyoumuKey;

    public String getDispGyoumuKey() {
        return dispGyoumuKey;
    }

    public void setDispGyoumuKey(String pDispGyoumuKey) {
        dispGyoumuKey = pDispGyoumuKey;
    }


    private String wariateKaijyoLink;

    public String getWariateKaijyoLink() {
        return wariateKaijyoLink;
    }

    public void setWariateKaijyoLink(String pWariateKaijyoLink) {
        wariateKaijyoLink = pWariateKaijyoLink;
    }

}
