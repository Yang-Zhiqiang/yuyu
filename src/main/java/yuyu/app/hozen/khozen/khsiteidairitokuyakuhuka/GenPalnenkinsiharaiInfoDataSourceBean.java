package yuyu.app.hozen.khozen.khsiteidairitokuyakuhuka;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;

/**
 * 被保険者代理特約中途付加 - ●別契約（ＰＡＬ年金支払契約） の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenPalnenkinsiharaiInfoDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String vbtkkdisppalbtkyknksysyno;

    public String getVbtkkdisppalbtkyknksysyno() {
        return vbtkkdisppalbtkyknksysyno;
    }

    public void setVbtkkdisppalbtkyknksysyno(String pVbtkkdisppalbtkyknksysyno) {
        vbtkkdisppalbtkyknksysyno = pVbtkkdisppalbtkyknksysyno;
    }


    private BizDate vbtkkdisppalbtkyknkshrymd;

    public BizDate getVbtkkdisppalbtkyknkshrymd() {
        return vbtkkdisppalbtkyknkshrymd;
    }

    public void setVbtkkdisppalbtkyknkshrymd(BizDate pVbtkkdisppalbtkyknkshrymd) {
        vbtkkdisppalbtkyknkshrymd = pVbtkkdisppalbtkyknkshrymd;
    }


    private String vbtkkdisppalbtkyknksymtcd;

    public String getVbtkkdisppalbtkyknksymtcd() {
        return vbtkkdisppalbtkyknksymtcd;
    }

    public void setVbtkkdisppalbtkyknksymtcd(String pVbtkkdisppalbtkyknksymtcd) {
        vbtkkdisppalbtkyknksymtcd = pVbtkkdisppalbtkyknksymtcd;
    }


    private BizDate vbtkkdisppalbtkyknksymtymd;

    public BizDate getVbtkkdisppalbtkyknksymtymd() {
        return vbtkkdisppalbtkyknksymtymd;
    }

    public void setVbtkkdisppalbtkyknksymtymd(BizDate pVbtkkdisppalbtkyknksymtymd) {
        vbtkkdisppalbtkyknksymtymd = pVbtkkdisppalbtkyknksymtymd;
    }

}
