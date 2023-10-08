package yuyu.app.hozen.khansyuu.khonlinedattai;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;

/**
 * オンライン脱退処理 - ●別契約（ＰＡＬ保険金据置契約） の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenPalsueokiInfoDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String vbtkkdisppalbtkyksosysyno;

    public String getVbtkkdisppalbtkyksosysyno() {
        return vbtkkdisppalbtkyksosysyno;
    }

    public void setVbtkkdisppalbtkyksosysyno(String pVbtkkdisppalbtkyksosysyno) {
        vbtkkdisppalbtkyksosysyno = pVbtkkdisppalbtkyksosysyno;
    }


    private BizDate vbtkkdisppalbtkyksosymd;

    public BizDate getVbtkkdisppalbtkyksosymd() {
        return vbtkkdisppalbtkyksosymd;
    }

    public void setVbtkkdisppalbtkyksosymd(BizDate pVbtkkdisppalbtkyksosymd) {
        vbtkkdisppalbtkyksosymd = pVbtkkdisppalbtkyksosymd;
    }

}
