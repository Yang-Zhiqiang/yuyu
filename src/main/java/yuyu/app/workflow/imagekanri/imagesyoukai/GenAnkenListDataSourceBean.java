package yuyu.app.workflow.imagekanri.imagesyoukai;

import java.io.Serializable;

import yuyu.def.classification.C_Kouteikanristatus;

/**
 * イメージ照会 - ankenList の 行データBean ベースクラスです。<br />
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


    private String dispGyoumuKey;

    public String getDispGyoumuKey() {
        return dispGyoumuKey;
    }

    public void setDispGyoumuKey(String pDispGyoumuKey) {
        dispGyoumuKey = pDispGyoumuKey;
    }


    private String dispsyoruinm;

    public String getDispsyoruinm() {
        return dispsyoruinm;
    }

    public void setDispsyoruinm(String pDispsyoruinm) {
        dispsyoruinm = pDispsyoruinm;
    }


    private C_Kouteikanristatus dispkouteikanristatus;

    public C_Kouteikanristatus getDispkouteikanristatus() {
        return dispkouteikanristatus;
    }

    public void setDispkouteikanristatus(C_Kouteikanristatus pDispkouteikanristatus) {
        dispkouteikanristatus = pDispkouteikanristatus;
    }


    private String syoruittykymdtime;

    public String getSyoruittykymdtime() {
        return syoruittykymdtime;
    }

    public void setSyoruittykymdtime(String pSyoruittykymdtime) {
        syoruittykymdtime = pSyoruittykymdtime;
    }


    private String hyoujilink;

    public String getHyoujilink() {
        return hyoujilink;
    }

    public void setHyoujilink(String pHyoujilink) {
        hyoujilink = pHyoujilink;
    }

}
