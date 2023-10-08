package yuyu.app.siharai.sihubikanri.sihubikaisyou;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_SyorikekkaKbn;

/**
 * 保険金給付金不備解消 - ●進捗履歴情報 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenProgresshistoryinfoDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BizDate vprghsdispsyoriymd;

    public BizDate getVprghsdispsyoriymd() {
        return vprghsdispsyoriymd;
    }

    public void setVprghsdispsyoriymd(BizDate pVprghsdispsyoriymd) {
        vprghsdispsyoriymd = pVprghsdispsyoriymd;
    }


    private String vprghsdisptasknm;

    public String getVprghsdisptasknm() {
        return vprghsdisptasknm;
    }

    public void setVprghsdisptasknm(String pVprghsdisptasknm) {
        vprghsdisptasknm = pVprghsdisptasknm;
    }


    private C_SyorikekkaKbn vprghsdispsyorikekkakbn;

    public C_SyorikekkaKbn getVprghsdispsyorikekkakbn() {
        return vprghsdispsyorikekkakbn;
    }

    public void setVprghsdispsyorikekkakbn(C_SyorikekkaKbn pVprghsdispsyorikekkakbn) {
        vprghsdispsyorikekkakbn = pVprghsdispsyorikekkakbn;
    }


    private String vprghsdispsousasyanm;

    public String getVprghsdispsousasyanm() {
        return vprghsdispsousasyanm;
    }

    public void setVprghsdispsousasyanm(String pVprghsdispsousasyanm) {
        vprghsdispsousasyanm = pVprghsdispsousasyanm;
    }


    private String vprghsdispcomment;

    public String getVprghsdispcomment() {
        return vprghsdispcomment;
    }

    public void setVprghsdispcomment(String pVprghsdispcomment) {
        vprghsdispcomment = pVprghsdispcomment;
    }

}
