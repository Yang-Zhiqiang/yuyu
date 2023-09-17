package yuyu.def.biz.file.excel;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.excel.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）ＦＡＴＣＡ情報テーブルレイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzFatcaInfoLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzFatcaInfoLayoutFile() {
    }

    @Column(order = 1, label = "kbnkey")
    private String ifeTskbnkey;

    public String getIfeTskbnkey() {
        return ifeTskbnkey;
    }

    public void setIfeTskbnkey(String pIfeTskbnkey) {
        ifeTskbnkey = pIfeTskbnkey;
    }

    @Column(order = 2, label = "syono")
    private String ifeTssyono;

    public String getIfeTssyono() {
        return ifeTssyono;
    }

    public void setIfeTssyono(String pIfeTssyono) {
        ifeTssyono = pIfeTssyono;
    }

    @Column(order = 3, label = "renno")
    private String ifeTsrenno;

    public String getIfeTsrenno() {
        return ifeTsrenno;
    }

    public void setIfeTsrenno(String pIfeTsrenno) {
        ifeTsrenno = pIfeTsrenno;
    }

    @Column(order = 4, label = "syoriYmd")
    private String ifeTssyoriymd;

    public String getIfeTssyoriymd() {
        return ifeTssyoriymd;
    }

    public void setIfeTssyoriymd(String pIfeTssyoriymd) {
        ifeTssyoriymd = pIfeTssyoriymd;
    }

    @Column(order = 5, label = "syorisosikicd")
    private String ifeTssyorisosikicd;

    public String getIfeTssyorisosikicd() {
        return ifeTssyorisosikicd;
    }

    public void setIfeTssyorisosikicd(String pIfeTssyorisosikicd) {
        ifeTssyorisosikicd = pIfeTssyorisosikicd;
    }

    @Column(order = 6, label = "fatcasnsikbn")
    private String ifeTsfatcasnsikbn;

    public String getIfeTsfatcasnsikbn() {
        return ifeTsfatcasnsikbn;
    }

    public void setIfeTsfatcasnsikbn(String pIfeTsfatcasnsikbn) {
        ifeTsfatcasnsikbn = pIfeTsfatcasnsikbn;
    }

    @Column(order = 7, label = "bikkjnssinfokbn")
    private String ifeTsbikkjnssinfokbn;

    public String getIfeTsbikkjnssinfokbn() {
        return ifeTsbikkjnssinfokbn;
    }

    public void setIfeTsbikkjnssinfokbn(String pIfeTsbikkjnssinfokbn) {
        ifeTsbikkjnssinfokbn = pIfeTsbikkjnssinfokbn;
    }

    @Column(order = 8, label = "fatcakekkbn")
    private String ifeTsfatcakekkbn;

    public String getIfeTsfatcakekkbn() {
        return ifeTsfatcakekkbn;
    }

    public void setIfeTsfatcakekkbn(String pIfeTsfatcakekkbn) {
        ifeTsfatcakekkbn = pIfeTsfatcakekkbn;
    }

    @Column(order = 9, label = "fatcahankeiikbn")
    private String ifeTsfatcahankeiikbn;

    public String getIfeTsfatcahankeiikbn() {
        return ifeTsfatcahankeiikbn;
    }

    public void setIfeTsfatcahankeiikbn(String pIfeTsfatcahankeiikbn) {
        ifeTsfatcahankeiikbn = pIfeTsfatcahankeiikbn;
    }

    @Column(order = 10, label = "bikknzsyno")
    private String ifeTsbikknzsyno;

    public String getIfeTsbikknzsyno() {
        return ifeTsbikknzsyno;
    }

    public void setIfeTsbikknzsyno(String pIfeTsbikknzsyno) {
        ifeTsbikknzsyno = pIfeTsbikknzsyno;
    }

    @Column(order = 11, label = "syomeiymd")
    private String ifeTssyomeiymd;

    public String getIfeTssyomeiymd() {
        return ifeTssyomeiymd;
    }

    public void setIfeTssyomeiymd(String pIfeTssyomeiymd) {
        ifeTssyomeiymd = pIfeTssyomeiymd;
    }

    @Column(order = 12, label = "kokno")
    private String ifeTskokno;

    public String getIfeTskokno() {
        return ifeTskokno;
    }

    public void setIfeTskokno(String pIfeTskokno) {
        ifeTskokno = pIfeTskokno;
    }

    @Column(order = 13, label = "fatcatgkbn")
    private String ifeTsfatcatgkbn;

    public String getIfeTsfatcatgkbn() {
        return ifeTsfatcatgkbn;
    }

    public void setIfeTsfatcatgkbn(String pIfeTsfatcatgkbn) {
        ifeTsfatcatgkbn = pIfeTsfatcatgkbn;
    }

    @Column(order = 14, label = "seionnmkn")
    private String ifeTsseionnmkn;

    public String getIfeTsseionnmkn() {
        return ifeTsseionnmkn;
    }

    public void setIfeTsseionnmkn(String pIfeTsseionnmkn) {
        ifeTsseionnmkn = pIfeTsseionnmkn;
    }

    @Column(order = 15, label = "nmkn")
    private String ifeTsnmkn;

    public String getIfeTsnmkn() {
        return ifeTsnmkn;
    }

    public void setIfeTsnmkn(String pIfeTsnmkn) {
        ifeTsnmkn = pIfeTsnmkn;
    }

    @Column(order = 16, label = "nmkj")
    private String ifeTsnmkj;

    public String getIfeTsnmkj() {
        return ifeTsnmkj;
    }

    public void setIfeTsnmkj(String pIfeTsnmkj) {
        ifeTsnmkj = pIfeTsnmkj;
    }

    @Column(order = 17, label = "seiymd")
    private String ifeTsseiymd;

    public String getIfeTsseiymd() {
        return ifeTsseiymd;
    }

    public void setIfeTsseiymd(String pIfeTsseiymd) {
        ifeTsseiymd = pIfeTsseiymd;
    }

    @Column(order = 18, label = "seibetu")
    private String ifeTsseibetu;

    public String getIfeTsseibetu() {
        return ifeTsseibetu;
    }

    public void setIfeTsseibetu(String pIfeTsseibetu) {
        ifeTsseibetu = pIfeTsseibetu;
    }

    @Column(order = 19, label = "kouryokuendymd")
    private String ifeTskouryokuendymd;

    public String getIfeTskouryokuendymd() {
        return ifeTskouryokuendymd;
    }

    public void setIfeTskouryokuendymd(String pIfeTskouryokuendymd) {
        ifeTskouryokuendymd = pIfeTskouryokuendymd;
    }

    @Column(order = 20, label = "trkymd")
    private String ifeTstrkymd;

    public String getIfeTstrkymd() {
        return ifeTstrkymd;
    }

    public void setIfeTstrkymd(String pIfeTstrkymd) {
        ifeTstrkymd = pIfeTstrkymd;
    }

    @Column(order = 21, label = "gyoumuKousinKinou")
    private String ifeTsgyoumukousinkinou;

    public String getIfeTsgyoumukousinkinou() {
        return ifeTsgyoumukousinkinou;
    }

    public void setIfeTsgyoumukousinkinou(String pIfeTsgyoumukousinkinou) {
        ifeTsgyoumukousinkinou = pIfeTsgyoumukousinkinou;
    }

    @Column(order = 22, label = "gyoumuKousinsyaId")
    private String ifeTsgyoumukousinsyaid;

    public String getIfeTsgyoumukousinsyaid() {
        return ifeTsgyoumukousinsyaid;
    }

    public void setIfeTsgyoumukousinsyaid(String pIfeTsgyoumukousinsyaid) {
        ifeTsgyoumukousinsyaid = pIfeTsgyoumukousinsyaid;
    }

    @Column(order = 23, label = "gyoumuKousinTime")
    private String ifeTsgyoumukousintime;

    public String getIfeTsgyoumukousintime() {
        return ifeTsgyoumukousintime;
    }

    public void setIfeTsgyoumukousintime(String pIfeTsgyoumukousintime) {
        ifeTsgyoumukousintime = pIfeTsgyoumukousintime;
    }

    @Column(order = 24, label = "kousinsyaId")
    private String ifeTskousinsyaid;

    public String getIfeTskousinsyaid() {
        return ifeTskousinsyaid;
    }

    public void setIfeTskousinsyaid(String pIfeTskousinsyaid) {
        ifeTskousinsyaid = pIfeTskousinsyaid;
    }

    @Column(order = 25, label = "kousinTime")
    private String ifeTskousintime;

    public String getIfeTskousintime() {
        return ifeTskousintime;
    }

    public void setIfeTskousintime(String pIfeTskousintime) {
        ifeTskousintime = pIfeTskousintime;
    }

    @Column(order = 26, label = "kousinKinou")
    private String ifeTskousinkinou;

    public String getIfeTskousinkinou() {
        return ifeTskousinkinou;
    }

    public void setIfeTskousinkinou(String pIfeTskousinkinou) {
        ifeTskousinkinou = pIfeTskousinkinou;
    }

    @Column(order = 27, label = "version")
    private String ifeTsversion;

    public String getIfeTsversion() {
        return ifeTsversion;
    }

    public void setIfeTsversion(String pIfeTsversion) {
        ifeTsversion = pIfeTsversion;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
