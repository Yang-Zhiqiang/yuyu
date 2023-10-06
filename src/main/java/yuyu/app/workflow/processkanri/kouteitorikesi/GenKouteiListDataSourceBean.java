package yuyu.app.workflow.processkanri.kouteitorikesi;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;

/**
 * 工程取消 - kouteiList の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenKouteiListDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String dispjimutetuzukinm;

    public String getDispjimutetuzukinm() {
        return dispjimutetuzukinm;
    }

    public void setDispjimutetuzukinm(String pDispjimutetuzukinm) {
        dispjimutetuzukinm = pDispjimutetuzukinm;
    }


    private String dispGyoumuKey;

    public String getDispGyoumuKey() {
        return dispGyoumuKey;
    }

    public void setDispGyoumuKey(String pDispGyoumuKey) {
        dispGyoumuKey = pDispGyoumuKey;
    }


    private BizDate dispkouteikaisiymd;

    public BizDate getDispkouteikaisiymd() {
        return dispkouteikaisiymd;
    }

    public void setDispkouteikaisiymd(BizDate pDispkouteikaisiymd) {
        dispkouteikaisiymd = pDispkouteikaisiymd;
    }


    private String disptantounm;

    public String getDisptantounm() {
        return disptantounm;
    }

    public void setDisptantounm(String pDisptantounm) {
        disptantounm = pDisptantounm;
    }


    private String nyuuryokuLink;

    public String getNyuuryokuLink() {
        return nyuuryokuLink;
    }

    public void setNyuuryokuLink(String pNyuuryokuLink) {
        nyuuryokuLink = pNyuuryokuLink;
    }

}
