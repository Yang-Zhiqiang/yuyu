package yuyu.app.hozen.khozen.khsiharaikouzahenkou;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;

/**
 * 支払口座情報変更 - ●書類情報一覧 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenSyoruiInfoListDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizDate dispsyoruittykymd;

    public BizDate getDispsyoruittykymd() {
        return dispsyoruittykymd;
    }

    public void setDispsyoruittykymd(BizDate pDispsyoruittykymd) {
        dispsyoruittykymd = pDispsyoruittykymd;
    }


    private String dispsyoruinm;

    public String getDispsyoruinm() {
        return dispsyoruinm;
    }

    public void setDispsyoruinm(String pDispsyoruinm) {
        dispsyoruinm = pDispsyoruinm;
    }


    private String disphituyousyorui;

    public String getDisphituyousyorui() {
        return disphituyousyorui;
    }

    public void setDisphituyousyorui(String pDisphituyousyorui) {
        disphituyousyorui = pDisphituyousyorui;
    }


    private String hyoujilink;

    public String getHyoujilink() {
        return hyoujilink;
    }

    public void setHyoujilink(String pHyoujilink) {
        hyoujilink = pHyoujilink;
    }


    private String hyoujilinkflg;

    public String getHyoujilinkflg() {
        return hyoujilinkflg;
    }

    public void setHyoujilinkflg(String pHyoujilinkflg) {
        hyoujilinkflg = pHyoujilinkflg;
    }


    private String imageid;

    public String getImageid() {
        return imageid;
    }

    public void setImageid(String pImageid) {
        imageid = pImageid;
    }

}
