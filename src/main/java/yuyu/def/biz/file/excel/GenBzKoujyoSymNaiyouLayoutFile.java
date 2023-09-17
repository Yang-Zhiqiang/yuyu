package yuyu.def.biz.file.excel;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.excel.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）控除証明内容テーブルレイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzKoujyoSymNaiyouLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzKoujyoSymNaiyouLayoutFile() {
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

    @Column(order = 3, label = "syouhncd")
    private String ifeTssyouhncd;

    public String getIfeTssyouhncd() {
        return ifeTssyouhncd;
    }

    public void setIfeTssyouhncd(String pIfeTssyouhncd) {
        ifeTssyouhncd = pIfeTssyouhncd;
    }

    @Column(order = 4, label = "renno3keta")
    private String ifeTsrenno3keta;

    public String getIfeTsrenno3keta() {
        return ifeTsrenno3keta;
    }

    public void setIfeTsrenno3keta(String pIfeTsrenno3keta) {
        ifeTsrenno3keta = pIfeTsrenno3keta;
    }

    @Column(order = 5, label = "koujyosyoumeinnd")
    private String ifeTskoujyosyoumeinnd;

    public String getIfeTskoujyosyoumeinnd() {
        return ifeTskoujyosyoumeinnd;
    }

    public void setIfeTskoujyosyoumeinnd(String pIfeTskoujyosyoumeinnd) {
        ifeTskoujyosyoumeinnd = pIfeTskoujyosyoumeinnd;
    }

    @Column(order = 6, label = "syoumeistartym")
    private String ifeTssyoumeistartym;

    public String getIfeTssyoumeistartym() {
        return ifeTssyoumeistartym;
    }

    public void setIfeTssyoumeistartym(String pIfeTssyoumeistartym) {
        ifeTssyoumeistartym = pIfeTssyoumeistartym;
    }

    @Column(order = 7, label = "syoumeiendym")
    private String ifeTssyoumeiendym;

    public String getIfeTssyoumeiendym() {
        return ifeTssyoumeiendym;
    }

    public void setIfeTssyoumeiendym(String pIfeTssyoumeiendym) {
        ifeTssyoumeiendym = pIfeTssyoumeiendym;
    }

    @Column(order = 8, label = "koujyosyoumeipkbn")
    private String ifeTskoujyosyoumeipkbn;

    public String getIfeTskoujyosyoumeipkbn() {
        return ifeTskoujyosyoumeipkbn;
    }

    public void setIfeTskoujyosyoumeipkbn(String pIfeTskoujyosyoumeipkbn) {
        ifeTskoujyosyoumeipkbn = pIfeTskoujyosyoumeipkbn;
    }

    @Column(order = 9, label = "tekiyouseidokbn")
    private String ifeTstekiyouseidokbn;

    public String getIfeTstekiyouseidokbn() {
        return ifeTstekiyouseidokbn;
    }

    public void setIfeTstekiyouseidokbn(String pIfeTstekiyouseidokbn) {
        ifeTstekiyouseidokbn = pIfeTstekiyouseidokbn;
    }

    @Column(order = 10, label = "koujyosymnaiyoureckbn")
    private String ifeTskoujyosymnaiyoureckbn;

    public String getIfeTskoujyosymnaiyoureckbn() {
        return ifeTskoujyosymnaiyoureckbn;
    }

    public void setIfeTskoujyosymnaiyoureckbn(String pIfeTskoujyosymnaiyoureckbn) {
        ifeTskoujyosymnaiyoureckbn = pIfeTskoujyosymnaiyoureckbn;
    }

    @Column(order = 11, label = "koujyosyoumeigk")
    private String ifeTskoujyosyoumeigk;

    public String getIfeTskoujyosyoumeigk() {
        return ifeTskoujyosyoumeigk;
    }

    public void setIfeTskoujyosyoumeigk(String pIfeTskoujyosyoumeigk) {
        ifeTskoujyosyoumeigk = pIfeTskoujyosyoumeigk;
    }

    @Column(order = 12, label = "koujyosyoumeigk$")
    private String ifeTskoujyosyoumeigkt;

    public String getIfeTskoujyosyoumeigkt() {
        return ifeTskoujyosyoumeigkt;
    }

    public void setIfeTskoujyosyoumeigkt(String pIfeTskoujyosyoumeigkt) {
        ifeTskoujyosyoumeigkt = pIfeTskoujyosyoumeigkt;
    }

    @Column(order = 13, label = "jyutoustartym")
    private String ifeTsjyutoustartym;

    public String getIfeTsjyutoustartym() {
        return ifeTsjyutoustartym;
    }

    public void setIfeTsjyutoustartym(String pIfeTsjyutoustartym) {
        ifeTsjyutoustartym = pIfeTsjyutoustartym;
    }

    @Column(order = 14, label = "nyknjskrrkrenno")
    private String ifeTsnyknjskrrkrenno;

    public String getIfeTsnyknjskrrkrenno() {
        return ifeTsnyknjskrrkrenno;
    }

    public void setIfeTsnyknjskrrkrenno(String pIfeTsnyknjskrrkrenno) {
        ifeTsnyknjskrrkrenno = pIfeTsnyknjskrrkrenno;
    }

    @Column(order = 15, label = "kihrkpssrrkrenno")
    private String ifeTskihrkpssrrkrenno;

    public String getIfeTskihrkpssrrkrenno() {
        return ifeTskihrkpssrrkrenno;
    }

    public void setIfeTskihrkpssrrkrenno(String pIfeTskihrkpssrrkrenno) {
        ifeTskihrkpssrrkrenno = pIfeTskihrkpssrrkrenno;
    }

    @Column(order = 16, label = "kjsmhakkouzumiflg")
    private String ifeTskjsmhakkouzumiflg;

    public String getIfeTskjsmhakkouzumiflg() {
        return ifeTskjsmhakkouzumiflg;
    }

    public void setIfeTskjsmhakkouzumiflg(String pIfeTskjsmhakkouzumiflg) {
        ifeTskjsmhakkouzumiflg = pIfeTskjsmhakkouzumiflg;
    }

    @Column(order = 17, label = "gyoumuKousinKinou")
    private String ifeTsgyoumukousinkinou;

    public String getIfeTsgyoumukousinkinou() {
        return ifeTsgyoumukousinkinou;
    }

    public void setIfeTsgyoumukousinkinou(String pIfeTsgyoumukousinkinou) {
        ifeTsgyoumukousinkinou = pIfeTsgyoumukousinkinou;
    }

    @Column(order = 18, label = "gyoumuKousinsyaId")
    private String ifeTsgyoumukousinsyaid;

    public String getIfeTsgyoumukousinsyaid() {
        return ifeTsgyoumukousinsyaid;
    }

    public void setIfeTsgyoumukousinsyaid(String pIfeTsgyoumukousinsyaid) {
        ifeTsgyoumukousinsyaid = pIfeTsgyoumukousinsyaid;
    }

    @Column(order = 19, label = "gyoumuKousinTime")
    private String ifeTsgyoumukousintime;

    public String getIfeTsgyoumukousintime() {
        return ifeTsgyoumukousintime;
    }

    public void setIfeTsgyoumukousintime(String pIfeTsgyoumukousintime) {
        ifeTsgyoumukousintime = pIfeTsgyoumukousintime;
    }

    @Column(order = 20, label = "kousinsyaId")
    private String ifeTskousinsyaid;

    public String getIfeTskousinsyaid() {
        return ifeTskousinsyaid;
    }

    public void setIfeTskousinsyaid(String pIfeTskousinsyaid) {
        ifeTskousinsyaid = pIfeTskousinsyaid;
    }

    @Column(order = 21, label = "kousinTime")
    private String ifeTskousintime;

    public String getIfeTskousintime() {
        return ifeTskousintime;
    }

    public void setIfeTskousintime(String pIfeTskousintime) {
        ifeTskousintime = pIfeTskousintime;
    }

    @Column(order = 22, label = "kousinKinou")
    private String ifeTskousinkinou;

    public String getIfeTskousinkinou() {
        return ifeTskousinkinou;
    }

    public void setIfeTskousinkinou(String pIfeTskousinkinou) {
        ifeTskousinkinou = pIfeTskousinkinou;
    }

    @Column(order = 23, label = "version")
    private String ifeTsversion;

    public String getIfeTsversion() {
        return ifeTsversion;
    }

    public void setIfeTsversion(String pIfeTsversion) {
        ifeTsversion = pIfeTsversion;
    }

    @Column(order = 24, label = "sakujyoflg")
    private String ifeTssakujyoflg;

    public String getIfeTssakujyoflg() {
        return ifeTssakujyoflg;
    }

    public void setIfeTssakujyoflg(String pIfeTssakujyoflg) {
        ifeTssakujyoflg = pIfeTssakujyoflg;
    }

    @Column(order = 25, label = "zennoukaisiymd")
    private String ifeTszennoukaisiymd;

    public String getIfeTszennoukaisiymd() {
        return ifeTszennoukaisiymd;
    }

    public void setIfeTszennoukaisiymd(String pIfeTszennoukaisiymd) {
        ifeTszennoukaisiymd = pIfeTszennoukaisiymd;
    }

    @Column(order = 26, label = "zennourenno")
    private String ifeTszennourenno;

    public String getIfeTszennourenno() {
        return ifeTszennourenno;
    }

    public void setIfeTszennourenno(String pIfeTszennourenno) {
        ifeTszennourenno = pIfeTszennourenno;
    }

    @Column(order = 27, label = "keisanhukahyoujikbn")
    private String ifeTskeisanhukahyoujikbn;

    public String getIfeTskeisanhukahyoujikbn() {
        return ifeTskeisanhukahyoujikbn;
    }

    public void setIfeTskeisanhukahyoujikbn(String pIfeTskeisanhukahyoujikbn) {
        ifeTskeisanhukahyoujikbn = pIfeTskeisanhukahyoujikbn;
    }

    @Column(order = 28, label = "keisanhukariyuucd")
    private String ifeTskeisanhukariyuucd;

    public String getIfeTskeisanhukariyuucd() {
        return ifeTskeisanhukariyuucd;
    }

    public void setIfeTskeisanhukariyuucd(String pIfeTskeisanhukariyuucd) {
        ifeTskeisanhukariyuucd = pIfeTskeisanhukariyuucd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
