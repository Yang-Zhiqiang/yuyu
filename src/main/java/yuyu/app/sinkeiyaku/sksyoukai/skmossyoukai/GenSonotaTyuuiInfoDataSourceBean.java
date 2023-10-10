package yuyu.app.sinkeiyaku.sksyoukai.skmossyoukai;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;

/**
 * 申込状況照会 - ●その他注意情報 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenSonotaTyuuiInfoDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizDate dispskeittdktyuisttrkymd;

    public BizDate getDispskeittdktyuisttrkymd() {
        return dispskeittdktyuisttrkymd;
    }

    public void setDispskeittdktyuisttrkymd(BizDate pDispskeittdktyuisttrkymd) {
        dispskeittdktyuisttrkymd = pDispskeittdktyuisttrkymd;
    }


    private String dispskeittdktyuistnaiyo;

    public String getDispskeittdktyuistnaiyo() {
        return dispskeittdktyuistnaiyo;
    }

    public void setDispskeittdktyuistnaiyo(String pDispskeittdktyuistnaiyo) {
        dispskeittdktyuistnaiyo = pDispskeittdktyuistnaiyo;
    }


    private String dispskeittdktyuisttantou;

    public String getDispskeittdktyuisttantou() {
        return dispskeittdktyuisttantou;
    }

    public void setDispskeittdktyuisttantou(String pDispskeittdktyuisttantou) {
        dispskeittdktyuisttantou = pDispskeittdktyuisttantou;
    }

}
