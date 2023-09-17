package yuyu.def.biz.file.csv;

import java.io.Serializable;
import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import yuyu.def.classification.C_HtsiryosyuKbn;
import yuyu.def.classification.C_YouhiKbn;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）支払調書（一時金）全件ファイルレイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzSiharaityousyoItjknzenkenLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzSiharaityousyoItjknzenkenLayoutFile() {
    }

    @Column(order = 1, label = "（ＩＦｃ）レコード出力要否区分")
    private C_YouhiKbn ifcRdsyuturyokuyouhikbn;

    public C_YouhiKbn getIfcRdsyuturyokuyouhikbn() {
        return ifcRdsyuturyokuyouhikbn;
    }

    public void setIfcRdsyuturyokuyouhikbn(C_YouhiKbn pIfcRdsyuturyokuyouhikbn) {
        ifcRdsyuturyokuyouhikbn = pIfcRdsyuturyokuyouhikbn;
    }

    @Column(order = 2, label = "（ＩＦｃ）法定資料種類区分")
    private C_HtsiryosyuKbn ifcHtsiryosyukbn;

    public C_HtsiryosyuKbn getIfcHtsiryosyukbn() {
        return ifcHtsiryosyukbn;
    }

    public void setIfcHtsiryosyukbn(C_HtsiryosyuKbn pIfcHtsiryosyukbn) {
        ifcHtsiryosyukbn = pIfcHtsiryosyukbn;
    }

    @Column(order = 3, label = "（ＩＦｃ）整理番号１")
    private String ifcSeirino1;

    public String getIfcSeirino1() {
        return ifcSeirino1;
    }

    public void setIfcSeirino1(String pIfcSeirino1) {
        ifcSeirino1 = pIfcSeirino1;
    }

    @Column(order = 4, label = "（ＩＦｃ）本支店等区分番号")
    private String ifcHnstnetckbnno;

    public String getIfcHnstnetckbnno() {
        return ifcHnstnetckbnno;
    }

    public void setIfcHnstnetckbnno(String pIfcHnstnetckbnno) {
        ifcHnstnetckbnno = pIfcHnstnetckbnno;
    }

    @Column(order = 5, label = "（ＩＦｃ）提出義務者の住所（居所）又は所在地")
    private String ifcTisyutgmsyaadrsyozaiti;

    public String getIfcTisyutgmsyaadrsyozaiti() {
        return ifcTisyutgmsyaadrsyozaiti;
    }

    public void setIfcTisyutgmsyaadrsyozaiti(String pIfcTisyutgmsyaadrsyozaiti) {
        ifcTisyutgmsyaadrsyozaiti = pIfcTisyutgmsyaadrsyozaiti;
    }

    @Column(order = 6, label = "（ＩＦｃ）提出義務者の氏名又は名称")
    private String ifcTisyutgmsyanm;

    public String getIfcTisyutgmsyanm() {
        return ifcTisyutgmsyanm;
    }

    public void setIfcTisyutgmsyanm(String pIfcTisyutgmsyanm) {
        ifcTisyutgmsyanm = pIfcTisyutgmsyanm;
    }

    @Column(order = 7, label = "（ＩＦｃ）提出義務者の電話番号")
    private String ifcTisyutgmsyatelno;

    public String getIfcTisyutgmsyatelno() {
        return ifcTisyutgmsyatelno;
    }

    public void setIfcTisyutgmsyatelno(String pIfcTisyutgmsyatelno) {
        ifcTisyutgmsyatelno = pIfcTisyutgmsyatelno;
    }

    @Column(order = 8, label = "（ＩＦｃ）整理番号２")
    private String ifcSeirino2;

    public String getIfcSeirino2() {
        return ifcSeirino2;
    }

    public void setIfcSeirino2(String pIfcSeirino2) {
        ifcSeirino2 = pIfcSeirino2;
    }

    @Column(order = 9, label = "（ＩＦｃ）提出者の住所（居所）又は所在地")
    private String ifcTisyutsyaadr;

    public String getIfcTisyutsyaadr() {
        return ifcTisyutsyaadr;
    }

    public void setIfcTisyutsyaadr(String pIfcTisyutsyaadr) {
        ifcTisyutsyaadr = pIfcTisyutsyaadr;
    }

    @Column(order = 10, label = "（ＩＦｃ）提出者の氏名又は名称")
    private String ifcTisyutsyanm;

    public String getIfcTisyutsyanm() {
        return ifcTisyutsyanm;
    }

    public void setIfcTisyutsyanm(String pIfcTisyutsyanm) {
        ifcTisyutsyanm = pIfcTisyutsyanm;
    }

    @Column(order = 11, label = "（ＩＦｃ）訂正表示")
    private String ifcTeiseihyouji;

    public String getIfcTeiseihyouji() {
        return ifcTeiseihyouji;
    }

    public void setIfcTeiseihyouji(String pIfcTeiseihyouji) {
        ifcTeiseihyouji = pIfcTeiseihyouji;
    }

    @Column(order = 12, label = "（ＩＦｃ）年分")
    private String ifcNenbun;

    public String getIfcNenbun() {
        return ifcNenbun;
    }

    public void setIfcNenbun(String pIfcNenbun) {
        ifcNenbun = pIfcNenbun;
    }

    @Column(order = 13, label = "（ＩＦｃ）保険金等受取人住所（居所）又は所在地")
    private String ifcHknknuktetcadrsyozaiti;

    public String getIfcHknknuktetcadrsyozaiti() {
        return ifcHknknuktetcadrsyozaiti;
    }

    public void setIfcHknknuktetcadrsyozaiti(String pIfcHknknuktetcadrsyozaiti) {
        ifcHknknuktetcadrsyozaiti = pIfcHknknuktetcadrsyozaiti;
    }

    @Column(order = 14, label = "（ＩＦｃ）保険金等受取人国外住所表示")
    private String ifcHknknuktkkgadrhyouji;

    public String getIfcHknknuktkkgadrhyouji() {
        return ifcHknknuktkkgadrhyouji;
    }

    public void setIfcHknknuktkkgadrhyouji(String pIfcHknknuktkkgadrhyouji) {
        ifcHknknuktkkgadrhyouji = pIfcHknknuktkkgadrhyouji;
    }

    @Column(order = 15, label = "（ＩＦｃ）保険金等受取人氏名又は名称")
    private String ifcHknknuktnm;

    public String getIfcHknknuktnm() {
        return ifcHknknuktnm;
    }

    public void setIfcHknknuktnm(String pIfcHknknuktnm) {
        ifcHknknuktnm = pIfcHknknuktnm;
    }

    @Column(order = 16, label = "（ＩＦｃ）契約者等住所（居所）又は所在地")
    private String ifcKyketcadrsyozaiti;

    public String getIfcKyketcadrsyozaiti() {
        return ifcKyketcadrsyozaiti;
    }

    public void setIfcKyketcadrsyozaiti(String pIfcKyketcadrsyozaiti) {
        ifcKyketcadrsyozaiti = pIfcKyketcadrsyozaiti;
    }

    @Column(order = 17, label = "（ＩＦｃ）契約者等国外住所表示")
    private String ifcKyketckkgadrhyouji;

    public String getIfcKyketckkgadrhyouji() {
        return ifcKyketckkgadrhyouji;
    }

    public void setIfcKyketckkgadrhyouji(String pIfcKyketckkgadrhyouji) {
        ifcKyketckkgadrhyouji = pIfcKyketckkgadrhyouji;
    }

    @Column(order = 18, label = "（ＩＦｃ）契約者等氏名又は名称")
    private String ifcKyknm;

    public String getIfcKyknm() {
        return ifcKyknm;
    }

    public void setIfcKyknm(String pIfcKyknm) {
        ifcKyknm = pIfcKyknm;
    }

    @Column(order = 19, label = "（ＩＦｃ）被保険者等住所（居所）又は所在地")
    private String ifcHhknetcadrsyozaiti;

    public String getIfcHhknetcadrsyozaiti() {
        return ifcHhknetcadrsyozaiti;
    }

    public void setIfcHhknetcadrsyozaiti(String pIfcHhknetcadrsyozaiti) {
        ifcHhknetcadrsyozaiti = pIfcHhknetcadrsyozaiti;
    }

    @Column(order = 20, label = "（ＩＦｃ）被保険者等国外住所表示")
    private String ifcHhknetckkgadrhyouji;

    public String getIfcHhknetckkgadrhyouji() {
        return ifcHhknetckkgadrhyouji;
    }

    public void setIfcHhknetckkgadrhyouji(String pIfcHhknetckkgadrhyouji) {
        ifcHhknetckkgadrhyouji = pIfcHhknetckkgadrhyouji;
    }

    @Column(order = 21, label = "（ＩＦｃ）被保険者等氏名又は名称")
    private String ifcHhknm;

    public String getIfcHhknm() {
        return ifcHhknm;
    }

    public void setIfcHhknm(String pIfcHhknm) {
        ifcHhknm = pIfcHhknm;
    }

    @Column(order = 22, label = "（ＩＦｃ）保険金額等")
    private String ifcSetc;

    public String getIfcSetc() {
        return ifcSetc;
    }

    public void setIfcSetc(String pIfcSetc) {
        ifcSetc = pIfcSetc;
    }

    @Column(order = 23, label = "（ＩＦｃ）増加又は割増保険金額等")
    private String ifcZoukaorwarimasi;

    public String getIfcZoukaorwarimasi() {
        return ifcZoukaorwarimasi;
    }

    public void setIfcZoukaorwarimasi(String pIfcZoukaorwarimasi) {
        ifcZoukaorwarimasi = pIfcZoukaorwarimasi;
    }

    @Column(order = 24, label = "（ＩＦｃ）未払利益配当金等")
    private String ifcMbrriekihaitou;

    public String getIfcMbrriekihaitou() {
        return ifcMbrriekihaitou;
    }

    public void setIfcMbrriekihaitou(String pIfcMbrriekihaitou) {
        ifcMbrriekihaitou = pIfcMbrriekihaitou;
    }

    @Column(order = 25, label = "（ＩＦｃ）貸付金額・同未収利息")
    private String ifcKstkgkmsyrisoku;

    public String getIfcKstkgkmsyrisoku() {
        return ifcKstkgkmsyrisoku;
    }

    public void setIfcKstkgkmsyrisoku(String pIfcKstkgkmsyrisoku) {
        ifcKstkgkmsyrisoku = pIfcKstkgkmsyrisoku;
    }

    @Column(order = 26, label = "（ＩＦｃ）未払込保険料等")
    private String ifcMihrkmpetc;

    public String getIfcMihrkmpetc() {
        return ifcMihrkmpetc;
    }

    public void setIfcMihrkmpetc(String pIfcMihrkmpetc) {
        ifcMihrkmpetc = pIfcMihrkmpetc;
    }

    @Column(order = 27, label = "（ＩＦｃ）前納保険料等払戻金")
    private String ifcZennouphrmdskn;

    public String getIfcZennouphrmdskn() {
        return ifcZennouphrmdskn;
    }

    public void setIfcZennouphrmdskn(String pIfcZennouphrmdskn) {
        ifcZennouphrmdskn = pIfcZennouphrmdskn;
    }

    @Column(order = 28, label = "（ＩＦｃ）差引支払保険金額等")
    private String ifcSshkshrgketc;

    public String getIfcSshkshrgketc() {
        return ifcSshkshrgketc;
    }

    public void setIfcSshkshrgketc(String pIfcSshkshrgketc) {
        ifcSshkshrgketc = pIfcSshkshrgketc;
    }

    @Column(order = 29, label = "（ＩＦｃ）既払込保険料等")
    private String ifcKihrkmpetc;

    public String getIfcKihrkmpetc() {
        return ifcKihrkmpetc;
    }

    public void setIfcKihrkmpetc(String pIfcKihrkmpetc) {
        ifcKihrkmpetc = pIfcKihrkmpetc;
    }

    @Column(order = 30, label = "（ＩＦｃ）保険事故等")
    private String ifcHkjketctyo;

    public String getIfcHkjketctyo() {
        return ifcHkjketctyo;
    }

    public void setIfcHkjketctyo(String pIfcHkjketctyo) {
        ifcHkjketctyo = pIfcHkjketctyo;
    }

    @Column(order = 31, label = "（ＩＦｃ）保険事故等発生年")
    private String ifcHkjketchsy;

    public String getIfcHkjketchsy() {
        return ifcHkjketchsy;
    }

    public void setIfcHkjketchsy(String pIfcHkjketchsy) {
        ifcHkjketchsy = pIfcHkjketchsy;
    }

    @Column(order = 32, label = "（ＩＦｃ）保険事故等発生月")
    private String ifcHkjketchsm;

    public String getIfcHkjketchsm() {
        return ifcHkjketchsm;
    }

    public void setIfcHkjketchsm(String pIfcHkjketchsm) {
        ifcHkjketchsm = pIfcHkjketchsm;
    }

    @Column(order = 33, label = "（ＩＦｃ）保険事故等発生日")
    private String ifcHkjketchsd;

    public String getIfcHkjketchsd() {
        return ifcHkjketchsd;
    }

    public void setIfcHkjketchsd(String pIfcHkjketchsd) {
        ifcHkjketchsd = pIfcHkjketchsd;
    }

    @Column(order = 34, label = "（ＩＦｃ）保険等の種類")
    private String ifcHkjketcsyutyo;

    public String getIfcHkjketcsyutyo() {
        return ifcHkjketcsyutyo;
    }

    public void setIfcHkjketcsyutyo(String pIfcHkjketcsyutyo) {
        ifcHkjketcsyutyo = pIfcHkjketcsyutyo;
    }

    @Column(order = 35, label = "（ＩＦｃ）保険金等支払年")
    private String ifcHknknetcshry;

    public String getIfcHknknetcshry() {
        return ifcHknknetcshry;
    }

    public void setIfcHknknetcshry(String pIfcHknknetcshry) {
        ifcHknknetcshry = pIfcHknknetcshry;
    }

    @Column(order = 36, label = "（ＩＦｃ）保険金等支払月")
    private String ifcHknknetcshrm;

    public String getIfcHknknetcshrm() {
        return ifcHknknetcshrm;
    }

    public void setIfcHknknetcshrm(String pIfcHknknetcshrm) {
        ifcHknknetcshrm = pIfcHknknetcshrm;
    }

    @Column(order = 37, label = "（ＩＦｃ）保険金等支払日")
    private String ifcHknknetcshrd;

    public String getIfcHknknetcshrd() {
        return ifcHknknetcshrd;
    }

    public void setIfcHknknetcshrd(String pIfcHknknetcshrd) {
        ifcHknknetcshrd = pIfcHknknetcshrd;
    }

    @Column(order = 38, label = "（ＩＦｃ）摘要")
    private String ifcTekiyou;

    public String getIfcTekiyou() {
        return ifcTekiyou;
    }

    public void setIfcTekiyou(String pIfcTekiyou) {
        ifcTekiyou = pIfcTekiyou;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
