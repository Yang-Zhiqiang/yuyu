package yuyu.app.base.system.kadoutimetouroku;

import java.io.Serializable;

import yuyu.def.classification.C_KadouTimeSiteiKbn;
import yuyu.def.classification.C_KadouTimeYoubiKbn;

/**
 * 稼働時間登録 - ●営業日 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenEigyoubiKadouTimeInfoDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_KadouTimeYoubiKbn eigyouKadouTimeYoubiKbn;

    public C_KadouTimeYoubiKbn getEigyouKadouTimeYoubiKbn() {
        return eigyouKadouTimeYoubiKbn;
    }

    public void setEigyouKadouTimeYoubiKbn(C_KadouTimeYoubiKbn pEigyouKadouTimeYoubiKbn) {
        eigyouKadouTimeYoubiKbn = pEigyouKadouTimeYoubiKbn;
    }


    private C_KadouTimeSiteiKbn kadouTimeSiteiKbn;

    public C_KadouTimeSiteiKbn getKadouTimeSiteiKbn() {
        return kadouTimeSiteiKbn;
    }

    public void setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn pKadouTimeSiteiKbn) {
        kadouTimeSiteiKbn = pKadouTimeSiteiKbn;
    }


    private String eigyouKadouTime;

    public String getEigyouKadouTime() {
        return eigyouKadouTime;
    }

    public void setEigyouKadouTime(String pEigyouKadouTime) {
        eigyouKadouTime = pEigyouKadouTime;
    }


    private String henkouEigyoubiLink;

    public String getHenkouEigyoubiLink() {
        return henkouEigyoubiLink;
    }

    public void setHenkouEigyoubiLink(String pHenkouEigyoubiLink) {
        henkouEigyoubiLink = pHenkouEigyoubiLink;
    }

}
