package yuyu.app.sinkeiyaku.sksyoukai.skmossyoukai;

import java.io.Serializable;

import yuyu.def.classification.C_MsgSyubetu;

/**
 * 申込状況照会 - ●決定保留不備 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenKetteiHoryuuHubiDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_MsgSyubetu msgsyubetu;

    public C_MsgSyubetu getMsgsyubetu() {
        return msgsyubetu;
    }

    public void setMsgsyubetu(C_MsgSyubetu pMsgsyubetu) {
        msgsyubetu = pMsgsyubetu;
    }


    private String disphubimsgid;

    public String getDisphubimsgid() {
        return disphubimsgid;
    }

    public void setDisphubimsgid(String pDisphubimsgid) {
        disphubimsgid = pDisphubimsgid;
    }


    private String disphubimsg;

    public String getDisphubimsg() {
        return disphubimsg;
    }

    public void setDisphubimsg(String pDisphubimsg) {
        disphubimsg = pDisphubimsg;
    }

}
