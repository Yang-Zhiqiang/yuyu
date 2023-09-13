package yuyu.def.direct.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （ダイレクト）ＳＰＩＲＡＬメール配信ファイル（データレコード）レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenDsSpiralMailHaisinDataRecordLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenDsSpiralMailHaisinDataRecordLayoutFile() {
    }

    @Column(order = 1, label = "（ＩＦｃ）ＤＳ顧客メールアドレス識別キー")
    private String ifcDskokmailaddressskbtkey;

    public String getIfcDskokmailaddressskbtkey() {
        return ifcDskokmailaddressskbtkey;
    }

    public void setIfcDskokmailaddressskbtkey(String pIfcDskokmailaddressskbtkey) {
        ifcDskokmailaddressskbtkey = pIfcDskokmailaddressskbtkey;
    }

    @Column(order = 2, label = "（ＩＦｃ）ＤＳ送信メール種別区分")
    private String ifcDssousinmailsyubetukbn;

    public String getIfcDssousinmailsyubetukbn() {
        return ifcDssousinmailsyubetukbn;
    }

    public void setIfcDssousinmailsyubetukbn(String pIfcDssousinmailsyubetukbn) {
        ifcDssousinmailsyubetukbn = pIfcDssousinmailsyubetukbn;
    }

    @Column(order = 3, label = "（ＩＦｃ）ＤＳ送信番号")
    private String ifcDssousinno;

    public String getIfcDssousinno() {
        return ifcDssousinno;
    }

    public void setIfcDssousinno(String pIfcDssousinno) {
        ifcDssousinno = pIfcDssousinno;
    }

    @Column(order = 4, label = "（ＩＦｃ）証券番号")
    private String ifcSyono;

    public String getIfcSyono() {
        return ifcSyono;
    }

    public void setIfcSyono(String pIfcSyono) {
        ifcSyono = pIfcSyono;
    }

    @Column(order = 5, label = "（ＩＦｃ）ＤＳメールアドレス")
    private String ifcDsmailaddress;

    public String getIfcDsmailaddress() {
        return ifcDsmailaddress;
    }

    public void setIfcDsmailaddress(String pIfcDsmailaddress) {
        ifcDsmailaddress = pIfcDsmailaddress;
    }

    @Column(order = 6, label = "（ＩＦｃ）送信日")
    private String ifcSousinymd;

    public String getIfcSousinymd() {
        return ifcSousinymd;
    }

    public void setIfcSousinymd(String pIfcSousinymd) {
        ifcSousinymd = pIfcSousinymd;
    }

    @Column(order = 7, label = "（ＩＦｃ）削除日")
    private String ifcSakujyoymd;

    public String getIfcSakujyoymd() {
        return ifcSakujyoymd;
    }

    public void setIfcSakujyoymd(String pIfcSakujyoymd) {
        ifcSakujyoymd = pIfcSakujyoymd;
    }

    @Column(order = 8, label = "（ＩＦｃ）差込項目（小）０１")
    private String ifcSasikomikoumokusyou01;

    public String getIfcSasikomikoumokusyou01() {
        return ifcSasikomikoumokusyou01;
    }

    public void setIfcSasikomikoumokusyou01(String pIfcSasikomikoumokusyou01) {
        ifcSasikomikoumokusyou01 = pIfcSasikomikoumokusyou01;
    }

    @Column(order = 9, label = "（ＩＦｃ）差込項目（小）０２")
    private String ifcSasikomikoumokusyou02;

    public String getIfcSasikomikoumokusyou02() {
        return ifcSasikomikoumokusyou02;
    }

    public void setIfcSasikomikoumokusyou02(String pIfcSasikomikoumokusyou02) {
        ifcSasikomikoumokusyou02 = pIfcSasikomikoumokusyou02;
    }

    @Column(order = 10, label = "（ＩＦｃ）差込項目（小）０３")
    private String ifcSasikomikoumokusyou03;

    public String getIfcSasikomikoumokusyou03() {
        return ifcSasikomikoumokusyou03;
    }

    public void setIfcSasikomikoumokusyou03(String pIfcSasikomikoumokusyou03) {
        ifcSasikomikoumokusyou03 = pIfcSasikomikoumokusyou03;
    }

    @Column(order = 11, label = "（ＩＦｃ）差込項目（小）０４")
    private String ifcSasikomikoumokusyou04;

    public String getIfcSasikomikoumokusyou04() {
        return ifcSasikomikoumokusyou04;
    }

    public void setIfcSasikomikoumokusyou04(String pIfcSasikomikoumokusyou04) {
        ifcSasikomikoumokusyou04 = pIfcSasikomikoumokusyou04;
    }

    @Column(order = 12, label = "（ＩＦｃ）差込項目（小）０５")
    private String ifcSasikomikoumokusyou05;

    public String getIfcSasikomikoumokusyou05() {
        return ifcSasikomikoumokusyou05;
    }

    public void setIfcSasikomikoumokusyou05(String pIfcSasikomikoumokusyou05) {
        ifcSasikomikoumokusyou05 = pIfcSasikomikoumokusyou05;
    }

    @Column(order = 13, label = "（ＩＦｃ）差込項目（小）０６")
    private String ifcSasikomikoumokusyou06;

    public String getIfcSasikomikoumokusyou06() {
        return ifcSasikomikoumokusyou06;
    }

    public void setIfcSasikomikoumokusyou06(String pIfcSasikomikoumokusyou06) {
        ifcSasikomikoumokusyou06 = pIfcSasikomikoumokusyou06;
    }

    @Column(order = 14, label = "（ＩＦｃ）差込項目（小）０７")
    private String ifcSasikomikoumokusyou07;

    public String getIfcSasikomikoumokusyou07() {
        return ifcSasikomikoumokusyou07;
    }

    public void setIfcSasikomikoumokusyou07(String pIfcSasikomikoumokusyou07) {
        ifcSasikomikoumokusyou07 = pIfcSasikomikoumokusyou07;
    }

    @Column(order = 15, label = "（ＩＦｃ）差込項目（小）０８")
    private String ifcSasikomikoumokusyou08;

    public String getIfcSasikomikoumokusyou08() {
        return ifcSasikomikoumokusyou08;
    }

    public void setIfcSasikomikoumokusyou08(String pIfcSasikomikoumokusyou08) {
        ifcSasikomikoumokusyou08 = pIfcSasikomikoumokusyou08;
    }

    @Column(order = 16, label = "（ＩＦｃ）差込項目（小）０９")
    private String ifcSasikomikoumokusyou09;

    public String getIfcSasikomikoumokusyou09() {
        return ifcSasikomikoumokusyou09;
    }

    public void setIfcSasikomikoumokusyou09(String pIfcSasikomikoumokusyou09) {
        ifcSasikomikoumokusyou09 = pIfcSasikomikoumokusyou09;
    }

    @Column(order = 17, label = "（ＩＦｃ）差込項目（小）１０")
    private String ifcSasikomikoumokusyou10;

    public String getIfcSasikomikoumokusyou10() {
        return ifcSasikomikoumokusyou10;
    }

    public void setIfcSasikomikoumokusyou10(String pIfcSasikomikoumokusyou10) {
        ifcSasikomikoumokusyou10 = pIfcSasikomikoumokusyou10;
    }

    @Column(order = 18, label = "（ＩＦｃ）差込項目（小）１１")
    private String ifcSasikomikoumokusyou11;

    public String getIfcSasikomikoumokusyou11() {
        return ifcSasikomikoumokusyou11;
    }

    public void setIfcSasikomikoumokusyou11(String pIfcSasikomikoumokusyou11) {
        ifcSasikomikoumokusyou11 = pIfcSasikomikoumokusyou11;
    }

    @Column(order = 19, label = "（ＩＦｃ）差込項目（小）１２")
    private String ifcSasikomikoumokusyou12;

    public String getIfcSasikomikoumokusyou12() {
        return ifcSasikomikoumokusyou12;
    }

    public void setIfcSasikomikoumokusyou12(String pIfcSasikomikoumokusyou12) {
        ifcSasikomikoumokusyou12 = pIfcSasikomikoumokusyou12;
    }

    @Column(order = 20, label = "（ＩＦｃ）差込項目（小）１３")
    private String ifcSasikomikoumokusyou13;

    public String getIfcSasikomikoumokusyou13() {
        return ifcSasikomikoumokusyou13;
    }

    public void setIfcSasikomikoumokusyou13(String pIfcSasikomikoumokusyou13) {
        ifcSasikomikoumokusyou13 = pIfcSasikomikoumokusyou13;
    }

    @Column(order = 21, label = "（ＩＦｃ）差込項目（小）１４")
    private String ifcSasikomikoumokusyou14;

    public String getIfcSasikomikoumokusyou14() {
        return ifcSasikomikoumokusyou14;
    }

    public void setIfcSasikomikoumokusyou14(String pIfcSasikomikoumokusyou14) {
        ifcSasikomikoumokusyou14 = pIfcSasikomikoumokusyou14;
    }

    @Column(order = 22, label = "（ＩＦｃ）差込項目（小）１５")
    private String ifcSasikomikoumokusyou15;

    public String getIfcSasikomikoumokusyou15() {
        return ifcSasikomikoumokusyou15;
    }

    public void setIfcSasikomikoumokusyou15(String pIfcSasikomikoumokusyou15) {
        ifcSasikomikoumokusyou15 = pIfcSasikomikoumokusyou15;
    }

    @Column(order = 23, label = "（ＩＦｃ）差込項目（小）１６")
    private String ifcSasikomikoumokusyou16;

    public String getIfcSasikomikoumokusyou16() {
        return ifcSasikomikoumokusyou16;
    }

    public void setIfcSasikomikoumokusyou16(String pIfcSasikomikoumokusyou16) {
        ifcSasikomikoumokusyou16 = pIfcSasikomikoumokusyou16;
    }

    @Column(order = 24, label = "（ＩＦｃ）差込項目（小）１７")
    private String ifcSasikomikoumokusyou17;

    public String getIfcSasikomikoumokusyou17() {
        return ifcSasikomikoumokusyou17;
    }

    public void setIfcSasikomikoumokusyou17(String pIfcSasikomikoumokusyou17) {
        ifcSasikomikoumokusyou17 = pIfcSasikomikoumokusyou17;
    }

    @Column(order = 25, label = "（ＩＦｃ）差込項目（小）１８")
    private String ifcSasikomikoumokusyou18;

    public String getIfcSasikomikoumokusyou18() {
        return ifcSasikomikoumokusyou18;
    }

    public void setIfcSasikomikoumokusyou18(String pIfcSasikomikoumokusyou18) {
        ifcSasikomikoumokusyou18 = pIfcSasikomikoumokusyou18;
    }

    @Column(order = 26, label = "（ＩＦｃ）差込項目（小）１９")
    private String ifcSasikomikoumokusyou19;

    public String getIfcSasikomikoumokusyou19() {
        return ifcSasikomikoumokusyou19;
    }

    public void setIfcSasikomikoumokusyou19(String pIfcSasikomikoumokusyou19) {
        ifcSasikomikoumokusyou19 = pIfcSasikomikoumokusyou19;
    }

    @Column(order = 27, label = "（ＩＦｃ）差込項目（小）２０")
    private String ifcSasikomikoumokusyou20;

    public String getIfcSasikomikoumokusyou20() {
        return ifcSasikomikoumokusyou20;
    }

    public void setIfcSasikomikoumokusyou20(String pIfcSasikomikoumokusyou20) {
        ifcSasikomikoumokusyou20 = pIfcSasikomikoumokusyou20;
    }

    @Column(order = 28, label = "（ＩＦｃ）差込項目（小）２１")
    private String ifcSasikomikoumokusyou21;

    public String getIfcSasikomikoumokusyou21() {
        return ifcSasikomikoumokusyou21;
    }

    public void setIfcSasikomikoumokusyou21(String pIfcSasikomikoumokusyou21) {
        ifcSasikomikoumokusyou21 = pIfcSasikomikoumokusyou21;
    }

    @Column(order = 29, label = "（ＩＦｃ）差込項目（小）２２")
    private String ifcSasikomikoumokusyou22;

    public String getIfcSasikomikoumokusyou22() {
        return ifcSasikomikoumokusyou22;
    }

    public void setIfcSasikomikoumokusyou22(String pIfcSasikomikoumokusyou22) {
        ifcSasikomikoumokusyou22 = pIfcSasikomikoumokusyou22;
    }

    @Column(order = 30, label = "（ＩＦｃ）差込項目（小）２３")
    private String ifcSasikomikoumokusyou23;

    public String getIfcSasikomikoumokusyou23() {
        return ifcSasikomikoumokusyou23;
    }

    public void setIfcSasikomikoumokusyou23(String pIfcSasikomikoumokusyou23) {
        ifcSasikomikoumokusyou23 = pIfcSasikomikoumokusyou23;
    }

    @Column(order = 31, label = "（ＩＦｃ）差込項目（小）２４")
    private String ifcSasikomikoumokusyou24;

    public String getIfcSasikomikoumokusyou24() {
        return ifcSasikomikoumokusyou24;
    }

    public void setIfcSasikomikoumokusyou24(String pIfcSasikomikoumokusyou24) {
        ifcSasikomikoumokusyou24 = pIfcSasikomikoumokusyou24;
    }

    @Column(order = 32, label = "（ＩＦｃ）差込項目（小）２５")
    private String ifcSasikomikoumokusyou25;

    public String getIfcSasikomikoumokusyou25() {
        return ifcSasikomikoumokusyou25;
    }

    public void setIfcSasikomikoumokusyou25(String pIfcSasikomikoumokusyou25) {
        ifcSasikomikoumokusyou25 = pIfcSasikomikoumokusyou25;
    }

    @Column(order = 33, label = "（ＩＦｃ）差込項目（小）２６")
    private String ifcSasikomikoumokusyou26;

    public String getIfcSasikomikoumokusyou26() {
        return ifcSasikomikoumokusyou26;
    }

    public void setIfcSasikomikoumokusyou26(String pIfcSasikomikoumokusyou26) {
        ifcSasikomikoumokusyou26 = pIfcSasikomikoumokusyou26;
    }

    @Column(order = 34, label = "（ＩＦｃ）差込項目（小）２７")
    private String ifcSasikomikoumokusyou27;

    public String getIfcSasikomikoumokusyou27() {
        return ifcSasikomikoumokusyou27;
    }

    public void setIfcSasikomikoumokusyou27(String pIfcSasikomikoumokusyou27) {
        ifcSasikomikoumokusyou27 = pIfcSasikomikoumokusyou27;
    }

    @Column(order = 35, label = "（ＩＦｃ）差込項目（小）２８")
    private String ifcSasikomikoumokusyou28;

    public String getIfcSasikomikoumokusyou28() {
        return ifcSasikomikoumokusyou28;
    }

    public void setIfcSasikomikoumokusyou28(String pIfcSasikomikoumokusyou28) {
        ifcSasikomikoumokusyou28 = pIfcSasikomikoumokusyou28;
    }

    @Column(order = 36, label = "（ＩＦｃ）差込項目（小）２９")
    private String ifcSasikomikoumokusyou29;

    public String getIfcSasikomikoumokusyou29() {
        return ifcSasikomikoumokusyou29;
    }

    public void setIfcSasikomikoumokusyou29(String pIfcSasikomikoumokusyou29) {
        ifcSasikomikoumokusyou29 = pIfcSasikomikoumokusyou29;
    }

    @Column(order = 37, label = "（ＩＦｃ）差込項目（小）３０")
    private String ifcSasikomikoumokusyou30;

    public String getIfcSasikomikoumokusyou30() {
        return ifcSasikomikoumokusyou30;
    }

    public void setIfcSasikomikoumokusyou30(String pIfcSasikomikoumokusyou30) {
        ifcSasikomikoumokusyou30 = pIfcSasikomikoumokusyou30;
    }

    @Column(order = 38, label = "（ＩＦｃ）差込項目（中）０１")
    private String ifcSasikomikoumokutyuu01;

    public String getIfcSasikomikoumokutyuu01() {
        return ifcSasikomikoumokutyuu01;
    }

    public void setIfcSasikomikoumokutyuu01(String pIfcSasikomikoumokutyuu01) {
        ifcSasikomikoumokutyuu01 = pIfcSasikomikoumokutyuu01;
    }

    @Column(order = 39, label = "（ＩＦｃ）差込項目（中）０２")
    private String ifcSasikomikoumokutyuu02;

    public String getIfcSasikomikoumokutyuu02() {
        return ifcSasikomikoumokutyuu02;
    }

    public void setIfcSasikomikoumokutyuu02(String pIfcSasikomikoumokutyuu02) {
        ifcSasikomikoumokutyuu02 = pIfcSasikomikoumokutyuu02;
    }

    @Column(order = 40, label = "（ＩＦｃ）差込項目（中）０３")
    private String ifcSasikomikoumokutyuu03;

    public String getIfcSasikomikoumokutyuu03() {
        return ifcSasikomikoumokutyuu03;
    }

    public void setIfcSasikomikoumokutyuu03(String pIfcSasikomikoumokutyuu03) {
        ifcSasikomikoumokutyuu03 = pIfcSasikomikoumokutyuu03;
    }

    @Column(order = 41, label = "（ＩＦｃ）差込項目（中）０４")
    private String ifcSasikomikoumokutyuu04;

    public String getIfcSasikomikoumokutyuu04() {
        return ifcSasikomikoumokutyuu04;
    }

    public void setIfcSasikomikoumokutyuu04(String pIfcSasikomikoumokutyuu04) {
        ifcSasikomikoumokutyuu04 = pIfcSasikomikoumokutyuu04;
    }

    @Column(order = 42, label = "（ＩＦｃ）差込項目（中）０５")
    private String ifcSasikomikoumokutyuu05;

    public String getIfcSasikomikoumokutyuu05() {
        return ifcSasikomikoumokutyuu05;
    }

    public void setIfcSasikomikoumokutyuu05(String pIfcSasikomikoumokutyuu05) {
        ifcSasikomikoumokutyuu05 = pIfcSasikomikoumokutyuu05;
    }

    @Column(order = 43, label = "（ＩＦｃ）差込項目（中）０６")
    private String ifcSasikomikoumokutyuu06;

    public String getIfcSasikomikoumokutyuu06() {
        return ifcSasikomikoumokutyuu06;
    }

    public void setIfcSasikomikoumokutyuu06(String pIfcSasikomikoumokutyuu06) {
        ifcSasikomikoumokutyuu06 = pIfcSasikomikoumokutyuu06;
    }

    @Column(order = 44, label = "（ＩＦｃ）差込項目（中）０７")
    private String ifcSasikomikoumokutyuu07;

    public String getIfcSasikomikoumokutyuu07() {
        return ifcSasikomikoumokutyuu07;
    }

    public void setIfcSasikomikoumokutyuu07(String pIfcSasikomikoumokutyuu07) {
        ifcSasikomikoumokutyuu07 = pIfcSasikomikoumokutyuu07;
    }

    @Column(order = 45, label = "（ＩＦｃ）差込項目（中）０８")
    private String ifcSasikomikoumokutyuu08;

    public String getIfcSasikomikoumokutyuu08() {
        return ifcSasikomikoumokutyuu08;
    }

    public void setIfcSasikomikoumokutyuu08(String pIfcSasikomikoumokutyuu08) {
        ifcSasikomikoumokutyuu08 = pIfcSasikomikoumokutyuu08;
    }

    @Column(order = 46, label = "（ＩＦｃ）差込項目（中）０９")
    private String ifcSasikomikoumokutyuu09;

    public String getIfcSasikomikoumokutyuu09() {
        return ifcSasikomikoumokutyuu09;
    }

    public void setIfcSasikomikoumokutyuu09(String pIfcSasikomikoumokutyuu09) {
        ifcSasikomikoumokutyuu09 = pIfcSasikomikoumokutyuu09;
    }

    @Column(order = 47, label = "（ＩＦｃ）差込項目（中）１０")
    private String ifcSasikomikoumokutyuu10;

    public String getIfcSasikomikoumokutyuu10() {
        return ifcSasikomikoumokutyuu10;
    }

    public void setIfcSasikomikoumokutyuu10(String pIfcSasikomikoumokutyuu10) {
        ifcSasikomikoumokutyuu10 = pIfcSasikomikoumokutyuu10;
    }

    @Column(order = 48, label = "（ＩＦｃ）差込項目（中）１１")
    private String ifcSasikomikoumokutyuu11;

    public String getIfcSasikomikoumokutyuu11() {
        return ifcSasikomikoumokutyuu11;
    }

    public void setIfcSasikomikoumokutyuu11(String pIfcSasikomikoumokutyuu11) {
        ifcSasikomikoumokutyuu11 = pIfcSasikomikoumokutyuu11;
    }

    @Column(order = 49, label = "（ＩＦｃ）差込項目（中）１２")
    private String ifcSasikomikoumokutyuu12;

    public String getIfcSasikomikoumokutyuu12() {
        return ifcSasikomikoumokutyuu12;
    }

    public void setIfcSasikomikoumokutyuu12(String pIfcSasikomikoumokutyuu12) {
        ifcSasikomikoumokutyuu12 = pIfcSasikomikoumokutyuu12;
    }

    @Column(order = 50, label = "（ＩＦｃ）差込項目（中）１３")
    private String ifcSasikomikoumokutyuu13;

    public String getIfcSasikomikoumokutyuu13() {
        return ifcSasikomikoumokutyuu13;
    }

    public void setIfcSasikomikoumokutyuu13(String pIfcSasikomikoumokutyuu13) {
        ifcSasikomikoumokutyuu13 = pIfcSasikomikoumokutyuu13;
    }

    @Column(order = 51, label = "（ＩＦｃ）差込項目（中）１４")
    private String ifcSasikomikoumokutyuu14;

    public String getIfcSasikomikoumokutyuu14() {
        return ifcSasikomikoumokutyuu14;
    }

    public void setIfcSasikomikoumokutyuu14(String pIfcSasikomikoumokutyuu14) {
        ifcSasikomikoumokutyuu14 = pIfcSasikomikoumokutyuu14;
    }

    @Column(order = 52, label = "（ＩＦｃ）差込項目（中）１５")
    private String ifcSasikomikoumokutyuu15;

    public String getIfcSasikomikoumokutyuu15() {
        return ifcSasikomikoumokutyuu15;
    }

    public void setIfcSasikomikoumokutyuu15(String pIfcSasikomikoumokutyuu15) {
        ifcSasikomikoumokutyuu15 = pIfcSasikomikoumokutyuu15;
    }

    @Column(order = 53, label = "（ＩＦｃ）差込項目（中）１６")
    private String ifcSasikomikoumokutyuu16;

    public String getIfcSasikomikoumokutyuu16() {
        return ifcSasikomikoumokutyuu16;
    }

    public void setIfcSasikomikoumokutyuu16(String pIfcSasikomikoumokutyuu16) {
        ifcSasikomikoumokutyuu16 = pIfcSasikomikoumokutyuu16;
    }

    @Column(order = 54, label = "（ＩＦｃ）差込項目（中）１７")
    private String ifcSasikomikoumokutyuu17;

    public String getIfcSasikomikoumokutyuu17() {
        return ifcSasikomikoumokutyuu17;
    }

    public void setIfcSasikomikoumokutyuu17(String pIfcSasikomikoumokutyuu17) {
        ifcSasikomikoumokutyuu17 = pIfcSasikomikoumokutyuu17;
    }

    @Column(order = 55, label = "（ＩＦｃ）差込項目（中）１８")
    private String ifcSasikomikoumokutyuu18;

    public String getIfcSasikomikoumokutyuu18() {
        return ifcSasikomikoumokutyuu18;
    }

    public void setIfcSasikomikoumokutyuu18(String pIfcSasikomikoumokutyuu18) {
        ifcSasikomikoumokutyuu18 = pIfcSasikomikoumokutyuu18;
    }

    @Column(order = 56, label = "（ＩＦｃ）差込項目（中）１９")
    private String ifcSasikomikoumokutyuu19;

    public String getIfcSasikomikoumokutyuu19() {
        return ifcSasikomikoumokutyuu19;
    }

    public void setIfcSasikomikoumokutyuu19(String pIfcSasikomikoumokutyuu19) {
        ifcSasikomikoumokutyuu19 = pIfcSasikomikoumokutyuu19;
    }

    @Column(order = 57, label = "（ＩＦｃ）差込項目（中）２０")
    private String ifcSasikomikoumokutyuu20;

    public String getIfcSasikomikoumokutyuu20() {
        return ifcSasikomikoumokutyuu20;
    }

    public void setIfcSasikomikoumokutyuu20(String pIfcSasikomikoumokutyuu20) {
        ifcSasikomikoumokutyuu20 = pIfcSasikomikoumokutyuu20;
    }

    @Column(order = 58, label = "（ＩＦｃ）差込項目（大）０１")
    private String ifcSasikomikoumokudai01;

    public String getIfcSasikomikoumokudai01() {
        return ifcSasikomikoumokudai01;
    }

    public void setIfcSasikomikoumokudai01(String pIfcSasikomikoumokudai01) {
        ifcSasikomikoumokudai01 = pIfcSasikomikoumokudai01;
    }

    @Column(order = 59, label = "（ＩＦｃ）差込項目（大）０２")
    private String ifcSasikomikoumokudai02;

    public String getIfcSasikomikoumokudai02() {
        return ifcSasikomikoumokudai02;
    }

    public void setIfcSasikomikoumokudai02(String pIfcSasikomikoumokudai02) {
        ifcSasikomikoumokudai02 = pIfcSasikomikoumokudai02;
    }

    @Column(order = 60, label = "（ＩＦｃ）差込項目（大）０３")
    private String ifcSasikomikoumokudai03;

    public String getIfcSasikomikoumokudai03() {
        return ifcSasikomikoumokudai03;
    }

    public void setIfcSasikomikoumokudai03(String pIfcSasikomikoumokudai03) {
        ifcSasikomikoumokudai03 = pIfcSasikomikoumokudai03;
    }

    @Column(order = 61, label = "（ＩＦｃ）差込項目（大）０４")
    private String ifcSasikomikoumokudai04;

    public String getIfcSasikomikoumokudai04() {
        return ifcSasikomikoumokudai04;
    }

    public void setIfcSasikomikoumokudai04(String pIfcSasikomikoumokudai04) {
        ifcSasikomikoumokudai04 = pIfcSasikomikoumokudai04;
    }

    @Column(order = 62, label = "（ＩＦｃ）差込項目（大）０５")
    private String ifcSasikomikoumokudai05;

    public String getIfcSasikomikoumokudai05() {
        return ifcSasikomikoumokudai05;
    }

    public void setIfcSasikomikoumokudai05(String pIfcSasikomikoumokudai05) {
        ifcSasikomikoumokudai05 = pIfcSasikomikoumokudai05;
    }

    @Column(order = 63, label = "（ＩＦｃ）差込項目（大）０６")
    private String ifcSasikomikoumokudai06;

    public String getIfcSasikomikoumokudai06() {
        return ifcSasikomikoumokudai06;
    }

    public void setIfcSasikomikoumokudai06(String pIfcSasikomikoumokudai06) {
        ifcSasikomikoumokudai06 = pIfcSasikomikoumokudai06;
    }

    @Column(order = 64, label = "（ＩＦｃ）差込項目（大）０７")
    private String ifcSasikomikoumokudai07;

    public String getIfcSasikomikoumokudai07() {
        return ifcSasikomikoumokudai07;
    }

    public void setIfcSasikomikoumokudai07(String pIfcSasikomikoumokudai07) {
        ifcSasikomikoumokudai07 = pIfcSasikomikoumokudai07;
    }

    @Column(order = 65, label = "（ＩＦｃ）差込項目（大）０８")
    private String ifcSasikomikoumokudai08;

    public String getIfcSasikomikoumokudai08() {
        return ifcSasikomikoumokudai08;
    }

    public void setIfcSasikomikoumokudai08(String pIfcSasikomikoumokudai08) {
        ifcSasikomikoumokudai08 = pIfcSasikomikoumokudai08;
    }

    @Column(order = 66, label = "（ＩＦｃ）差込項目（大）０９")
    private String ifcSasikomikoumokudai09;

    public String getIfcSasikomikoumokudai09() {
        return ifcSasikomikoumokudai09;
    }

    public void setIfcSasikomikoumokudai09(String pIfcSasikomikoumokudai09) {
        ifcSasikomikoumokudai09 = pIfcSasikomikoumokudai09;
    }

    @Column(order = 67, label = "（ＩＦｃ）差込項目（大）１０")
    private String ifcSasikomikoumokudai10;

    public String getIfcSasikomikoumokudai10() {
        return ifcSasikomikoumokudai10;
    }

    public void setIfcSasikomikoumokudai10(String pIfcSasikomikoumokudai10) {
        ifcSasikomikoumokudai10 = pIfcSasikomikoumokudai10;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
