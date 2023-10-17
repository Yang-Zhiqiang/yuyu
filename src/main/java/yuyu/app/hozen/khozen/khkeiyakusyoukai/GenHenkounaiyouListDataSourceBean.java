package yuyu.app.hozen.khozen.khkeiyakusyoukai;

import java.io.Serializable;

import yuyu.def.classification.C_HnkSyuruiKbn;

/**
 * 契約内容照会 - ●変更内容 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenHenkounaiyouListDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_HnkSyuruiKbn disphnkkbn;

    public C_HnkSyuruiKbn getDisphnkkbn() {
        return disphnkkbn;
    }

    public void setDisphnkkbn(C_HnkSyuruiKbn pDisphnkkbn) {
        disphnkkbn = pDisphnkkbn;
    }


    private String disphanbetukoumokunm;

    public String getDisphanbetukoumokunm() {
        return disphanbetukoumokunm;
    }

    public void setDisphanbetukoumokunm(String pDisphanbetukoumokunm) {
        disphanbetukoumokunm = pDisphanbetukoumokunm;
    }


    private String disphenkoukoumokunm;

    public String getDisphenkoukoumokunm() {
        return disphenkoukoumokunm;
    }

    public void setDisphenkoukoumokunm(String pDisphenkoukoumokunm) {
        disphenkoukoumokunm = pDisphenkoukoumokunm;
    }


    private String dispbfrnaiyou;

    public String getDispbfrnaiyou() {
        return dispbfrnaiyou;
    }

    public void setDispbfrnaiyou(String pDispbfrnaiyou) {
        dispbfrnaiyou = pDispbfrnaiyou;
    }


    private String dispnewnaiyou;

    public String getDispnewnaiyou() {
        return dispnewnaiyou;
    }

    public void setDispnewnaiyou(String pDispnewnaiyou) {
        dispnewnaiyou = pDispnewnaiyou;
    }

}
