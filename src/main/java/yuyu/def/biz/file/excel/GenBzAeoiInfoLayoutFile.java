package yuyu.def.biz.file.excel;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.excel.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）ＡＥＯＩ情報テーブルレイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzAeoiInfoLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzAeoiInfoLayoutFile() {
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

    @Column(order = 4, label = "aeoisyoriymd")
    private String ifeTsaeoisyoriymd;

    public String getIfeTsaeoisyoriymd() {
        return ifeTsaeoisyoriymd;
    }

    public void setIfeTsaeoisyoriymd(String pIfeTsaeoisyoriymd) {
        ifeTsaeoisyoriymd = pIfeTsaeoisyoriymd;
    }

    @Column(order = 5, label = "aeoisyorikbn")
    private String ifeTsaeoisyorikbn;

    public String getIfeTsaeoisyorikbn() {
        return ifeTsaeoisyorikbn;
    }

    public void setIfeTsaeoisyorikbn(String pIfeTsaeoisyorikbn) {
        ifeTsaeoisyorikbn = pIfeTsaeoisyorikbn;
    }

    @Column(order = 6, label = "aeoikouryokusttymd")
    private String ifeTsaeoikouryokusttymd;

    public String getIfeTsaeoikouryokusttymd() {
        return ifeTsaeoikouryokusttymd;
    }

    public void setIfeTsaeoikouryokusttymd(String pIfeTsaeoikouryokusttymd) {
        ifeTsaeoikouryokusttymd = pIfeTsaeoikouryokusttymd;
    }

    @Column(order = 7, label = "aeoisyorisosikicd")
    private String ifeTsaeoisyorisosikicd;

    public String getIfeTsaeoisyorisosikicd() {
        return ifeTsaeoisyorisosikicd;
    }

    public void setIfeTsaeoisyorisosikicd(String pIfeTsaeoisyorisosikicd) {
        ifeTsaeoisyorisosikicd = pIfeTsaeoisyorisosikicd;
    }

    @Column(order = 8, label = "aeoitaisyousyakbn")
    private String ifeTsaeoitaisyousyakbn;

    public String getIfeTsaeoitaisyousyakbn() {
        return ifeTsaeoitaisyousyakbn;
    }

    public void setIfeTsaeoitaisyousyakbn(String pIfeTsaeoitaisyousyakbn) {
        ifeTsaeoitaisyousyakbn = pIfeTsaeoitaisyousyakbn;
    }

    @Column(order = 9, label = "aeoikekkakbn")
    private String ifeTsaeoikekkakbn;

    public String getIfeTsaeoikekkakbn() {
        return ifeTsaeoikekkakbn;
    }

    public void setIfeTsaeoikekkakbn(String pIfeTsaeoikekkakbn) {
        ifeTsaeoikekkakbn = pIfeTsaeoikekkakbn;
    }

    @Column(order = 10, label = "aeoihoujinsyuruikbn")
    private String ifeTsaeoihoujinsyuruikbn;

    public String getIfeTsaeoihoujinsyuruikbn() {
        return ifeTsaeoihoujinsyuruikbn;
    }

    public void setIfeTsaeoihoujinsyuruikbn(String pIfeTsaeoihoujinsyuruikbn) {
        ifeTsaeoihoujinsyuruikbn = pIfeTsaeoihoujinsyuruikbn;
    }

    @Column(order = 11, label = "aeoikouryokuendymd")
    private String ifeTsaeoikouryokuendymd;

    public String getIfeTsaeoikouryokuendymd() {
        return ifeTsaeoikouryokuendymd;
    }

    public void setIfeTsaeoikouryokuendymd(String pIfeTsaeoikouryokuendymd) {
        ifeTsaeoikouryokuendymd = pIfeTsaeoikouryokuendymd;
    }

    @Column(order = 12, label = "gyoumuKousinKinou")
    private String ifeTsgyoumukousinkinou;

    public String getIfeTsgyoumukousinkinou() {
        return ifeTsgyoumukousinkinou;
    }

    public void setIfeTsgyoumukousinkinou(String pIfeTsgyoumukousinkinou) {
        ifeTsgyoumukousinkinou = pIfeTsgyoumukousinkinou;
    }

    @Column(order = 13, label = "gyoumuKousinsyaId")
    private String ifeTsgyoumukousinsyaid;

    public String getIfeTsgyoumukousinsyaid() {
        return ifeTsgyoumukousinsyaid;
    }

    public void setIfeTsgyoumukousinsyaid(String pIfeTsgyoumukousinsyaid) {
        ifeTsgyoumukousinsyaid = pIfeTsgyoumukousinsyaid;
    }

    @Column(order = 14, label = "gyoumuKousinTime")
    private String ifeTsgyoumukousintime;

    public String getIfeTsgyoumukousintime() {
        return ifeTsgyoumukousintime;
    }

    public void setIfeTsgyoumukousintime(String pIfeTsgyoumukousintime) {
        ifeTsgyoumukousintime = pIfeTsgyoumukousintime;
    }

    @Column(order = 15, label = "kousinsyaId")
    private String ifeTskousinsyaid;

    public String getIfeTskousinsyaid() {
        return ifeTskousinsyaid;
    }

    public void setIfeTskousinsyaid(String pIfeTskousinsyaid) {
        ifeTskousinsyaid = pIfeTskousinsyaid;
    }

    @Column(order = 16, label = "kousinTime")
    private String ifeTskousintime;

    public String getIfeTskousintime() {
        return ifeTskousintime;
    }

    public void setIfeTskousintime(String pIfeTskousintime) {
        ifeTskousintime = pIfeTskousintime;
    }

    @Column(order = 17, label = "kousinKinou")
    private String ifeTskousinkinou;

    public String getIfeTskousinkinou() {
        return ifeTskousinkinou;
    }

    public void setIfeTskousinkinou(String pIfeTskousinkinou) {
        ifeTskousinkinou = pIfeTskousinkinou;
    }

    @Column(order = 18, label = "version")
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
