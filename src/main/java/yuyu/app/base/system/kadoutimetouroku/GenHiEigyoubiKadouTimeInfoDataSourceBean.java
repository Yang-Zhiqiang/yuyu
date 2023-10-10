package yuyu.app.base.system.kadoutimetouroku;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.Trim;
import yuyu.def.classification.C_KadouTimeSiteiKbn;
import yuyu.def.classification.C_KadouTimeYoubiKbn;

/**
 * 稼働時間登録 - ●非営業日 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenHiEigyoubiKadouTimeInfoDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private C_KadouTimeYoubiKbn hiEigyouKadouTimeYoubiKbn;

    public C_KadouTimeYoubiKbn getHiEigyouKadouTimeYoubiKbn() {
        return hiEigyouKadouTimeYoubiKbn;
    }

    public void setHiEigyouKadouTimeYoubiKbn(C_KadouTimeYoubiKbn pHiEigyouKadouTimeYoubiKbn) {
        hiEigyouKadouTimeYoubiKbn = pHiEigyouKadouTimeYoubiKbn;
    }


    private C_KadouTimeSiteiKbn kadouTimeSiteiKbn;

    public C_KadouTimeSiteiKbn getKadouTimeSiteiKbn() {
        return kadouTimeSiteiKbn;
    }

    public void setKadouTimeSiteiKbn(C_KadouTimeSiteiKbn pKadouTimeSiteiKbn) {
        kadouTimeSiteiKbn = pKadouTimeSiteiKbn;
    }


    private String hiEigyouKadouTime;

    public String getHiEigyouKadouTime() {
        return hiEigyouKadouTime;
    }

    @Trim("both")
    public void setHiEigyouKadouTime(String pHiEigyouKadouTime) {
        hiEigyouKadouTime = pHiEigyouKadouTime;
    }


    private String henkouHieigyoubiLink;

    public String getHenkouHieigyoubiLink() {
        return henkouHieigyoubiLink;
    }

    public void setHenkouHieigyoubiLink(String pHenkouHieigyoubiLink) {
        henkouHieigyoubiLink = pHenkouHieigyoubiLink;
    }

}
