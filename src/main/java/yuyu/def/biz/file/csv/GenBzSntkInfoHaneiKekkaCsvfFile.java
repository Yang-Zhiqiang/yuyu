package yuyu.def.biz.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）普保Ⅱ選択情報反映結果ＣＳＶＦファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzSntkInfoHaneiKekkaCsvfFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzSntkInfoHaneiKekkaCsvfFile() {
    }

    @Column(order = 1, label = "（ＩＦｃ）選択情報番号")
    private String ifcSntkinfono;

    public String getIfcSntkinfono() {
        return ifcSntkinfono;
    }

    public void setIfcSntkinfono(String pIfcSntkinfono) {
        ifcSntkinfono = pIfcSntkinfono;
    }

    @Column(order = 2, label = "（ＩＦｃ）連番")
    private Integer ifcRenno;

    public Integer getIfcRenno() {
        return ifcRenno;
    }

    public void setIfcRenno(Integer pIfcRenno) {
        ifcRenno = pIfcRenno;
    }

    @Column(order = 3, label = "（ＩＦｃ）選択情報登録システム区分")
    private String ifcSntkinfotourokusyskbn;

    public String getIfcSntkinfotourokusyskbn() {
        return ifcSntkinfotourokusyskbn;
    }

    public void setIfcSntkinfotourokusyskbn(String pIfcSntkinfotourokusyskbn) {
        ifcSntkinfotourokusyskbn = pIfcSntkinfotourokusyskbn;
    }

    @Column(order = 4, label = "（ＩＦｃ）普保Ⅱ契約番号区分")
    private String ifcHuho2kyknokbn;

    public String getIfcHuho2kyknokbn() {
        return ifcHuho2kyknokbn;
    }

    public void setIfcHuho2kyknokbn(String pIfcHuho2kyknokbn) {
        ifcHuho2kyknokbn = pIfcHuho2kyknokbn;
    }

    @Column(order = 5, label = "（ＩＦｃ）普保Ⅱ契約番号")
    private String ifcHuho2kykno;

    public String getIfcHuho2kykno() {
        return ifcHuho2kykno;
    }

    public void setIfcHuho2kykno(String pIfcHuho2kykno) {
        ifcHuho2kykno = pIfcHuho2kykno;
    }

    @Column(order = 6, label = "（ＩＦｃ）選択情報関係者区分")
    private String ifcSntkinfokankeisyakbn;

    public String getIfcSntkinfokankeisyakbn() {
        return ifcSntkinfokankeisyakbn;
    }

    public void setIfcSntkinfokankeisyakbn(String pIfcSntkinfokankeisyakbn) {
        ifcSntkinfokankeisyakbn = pIfcSntkinfokankeisyakbn;
    }

    @Column(order = 7, label = "（ＩＦｃ）選択情報Ｆ個人区分")
    private String ifcSntkinfofkojinkbn;

    public String getIfcSntkinfofkojinkbn() {
        return ifcSntkinfofkojinkbn;
    }

    public void setIfcSntkinfofkojinkbn(String pIfcSntkinfofkojinkbn) {
        ifcSntkinfofkojinkbn = pIfcSntkinfofkojinkbn;
    }

    @Column(order = 8, label = "（ＩＦｃ）諾否決定内容有表示")
    private String ifcDakuhiketnaiyouarihyj;

    public String getIfcDakuhiketnaiyouarihyj() {
        return ifcDakuhiketnaiyouarihyj;
    }

    public void setIfcDakuhiketnaiyouarihyj(String pIfcDakuhiketnaiyouarihyj) {
        ifcDakuhiketnaiyouarihyj = pIfcDakuhiketnaiyouarihyj;
    }

    @Column(order = 9, label = "（ＩＦｃ）告知内容有表示")
    private String ifcKktnaiyouarihyj;

    public String getIfcKktnaiyouarihyj() {
        return ifcKktnaiyouarihyj;
    }

    public void setIfcKktnaiyouarihyj(String pIfcKktnaiyouarihyj) {
        ifcKktnaiyouarihyj = pIfcKktnaiyouarihyj;
    }

    @Column(order = 10, label = "（ＩＦｃ）記事内容有表示")
    private String ifcKijinaiyouarihyj;

    public String getIfcKijinaiyouarihyj() {
        return ifcKijinaiyouarihyj;
    }

    public void setIfcKijinaiyouarihyj(String pIfcKijinaiyouarihyj) {
        ifcKijinaiyouarihyj = pIfcKijinaiyouarihyj;
    }

    @Column(order = 11, label = "（ＩＦｃ）ＭＲ有表示")
    private String ifcMrarihyj;

    public String getIfcMrarihyj() {
        return ifcMrarihyj;
    }

    public void setIfcMrarihyj(String pIfcMrarihyj) {
        ifcMrarihyj = pIfcMrarihyj;
    }

    @Column(order = 12, label = "（ＩＦｃ）高度障害有表示")
    private String ifcKoudosyougaiarihyj;

    public String getIfcKoudosyougaiarihyj() {
        return ifcKoudosyougaiarihyj;
    }

    public void setIfcKoudosyougaiarihyj(String pIfcKoudosyougaiarihyj) {
        ifcKoudosyougaiarihyj = pIfcKoudosyougaiarihyj;
    }

    @Column(order = 13, label = "（ＩＦｃ）取消解除有表示")
    private String ifcTorikaijyoarihyj;

    public String getIfcTorikaijyoarihyj() {
        return ifcTorikaijyoarihyj;
    }

    public void setIfcTorikaijyoarihyj(String pIfcTorikaijyoarihyj) {
        ifcTorikaijyoarihyj = pIfcTorikaijyoarihyj;
    }

    @Column(order = 14, label = "（ＩＦｃ）選択情報登録エラー区分")
    private String ifcSntkinfotourokuerrkbn;

    public String getIfcSntkinfotourokuerrkbn() {
        return ifcSntkinfotourokuerrkbn;
    }

    public void setIfcSntkinfotourokuerrkbn(String pIfcSntkinfotourokuerrkbn) {
        ifcSntkinfotourokuerrkbn = pIfcSntkinfotourokuerrkbn;
    }

    @Column(order = 15, label = "（ＩＦｃ）名寄せ不明表示")
    private String ifcNayosehumeihyj;

    public String getIfcNayosehumeihyj() {
        return ifcNayosehumeihyj;
    }

    public void setIfcNayosehumeihyj(String pIfcNayosehumeihyj) {
        ifcNayosehumeihyj = pIfcNayosehumeihyj;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
