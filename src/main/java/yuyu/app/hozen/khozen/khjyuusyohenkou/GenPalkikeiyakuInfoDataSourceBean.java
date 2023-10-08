package yuyu.app.hozen.khozen.khjyuusyohenkou;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;

/**
 * 住所変更 - ●別契約（ＰＡＬ既契約） の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenPalkikeiyakuInfoDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String vbtkkdisppalbtkyksyono;

    public String getVbtkkdisppalbtkyksyono() {
        return vbtkkdisppalbtkyksyono;
    }

    public void setVbtkkdisppalbtkyksyono(String pVbtkkdisppalbtkyksyono) {
        vbtkkdisppalbtkyksyono = pVbtkkdisppalbtkyksyono;
    }


    private BizDate vbtkkdisppalbtkykkykymd;

    public BizDate getVbtkkdisppalbtkykkykymd() {
        return vbtkkdisppalbtkykkykymd;
    }

    public void setVbtkkdisppalbtkykkykymd(BizDate pVbtkkdisppalbtkykkykymd) {
        vbtkkdisppalbtkykkykymd = pVbtkkdisppalbtkykkykymd;
    }


    private String vbtkkdisppalbtkyksymtcd;

    public String getVbtkkdisppalbtkyksymtcd() {
        return vbtkkdisppalbtkyksymtcd;
    }

    public void setVbtkkdisppalbtkyksymtcd(String pVbtkkdisppalbtkyksymtcd) {
        vbtkkdisppalbtkyksymtcd = pVbtkkdisppalbtkyksymtcd;
    }


    private BizDate vbtkkdisppalbtkyksymtymd;

    public BizDate getVbtkkdisppalbtkyksymtymd() {
        return vbtkkdisppalbtkyksymtymd;
    }

    public void setVbtkkdisppalbtkyksymtymd(BizDate pVbtkkdisppalbtkyksymtymd) {
        vbtkkdisppalbtkyksymtymd = pVbtkkdisppalbtkyksymtymd;
    }

}
