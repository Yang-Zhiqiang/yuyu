package yuyu.app.siharai.sisyoukai.sittzkrirekisyoukai;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;

/**
 * 手続履歴照会 - ttzkRrkList の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenTtzkRrkListDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizDate dispsyoriymd;

    public BizDate getDispsyoriymd() {
        return dispsyoriymd;
    }

    public void setDispsyoriymd(BizDate pDispsyoriymd) {
        dispsyoriymd = pDispsyoriymd;
    }


    private String dispsyorinm;

    public String getDispsyorinm() {
        return dispsyorinm;
    }

    public void setDispsyorinm(String pDispsyorinm) {
        dispsyorinm = pDispsyorinm;
    }


    private String syorikekka;

    public String getSyorikekka() {
        return syorikekka;
    }

    public void setSyorikekka(String pSyorikekka) {
        syorikekka = pSyorikekka;
    }


    private String disptantounm;

    public String getDisptantounm() {
        return disptantounm;
    }

    public void setDisptantounm(String pDisptantounm) {
        disptantounm = pDisptantounm;
    }


    private String dispcomment;

    public String getDispcomment() {
        return dispcomment;
    }

    public void setDispcomment(String pDispcomment) {
        dispcomment = pDispcomment;
    }


    private String syousaiLink;

    public String getSyousaiLink() {
        return syousaiLink;
    }

    public void setSyousaiLink(String pSyousaiLink) {
        syousaiLink = pSyousaiLink;
    }


    private String dispttdkrrkskbtkey;

    public String getDispttdkrrkskbtkey() {
        return dispttdkrrkskbtkey;
    }

    public void setDispttdkrrkskbtkey(String pDispttdkrrkskbtkey) {
        dispttdkrrkskbtkey = pDispttdkrrkskbtkey;
    }

}
