package yuyu.def.biz.file.excel;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.excel.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）前納テーブルレイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzZennouLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzZennouLayoutFile() {
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

    @Column(order = 3, label = "zennoukaisiymd")
    private String ifeTszennoukaisiymd;

    public String getIfeTszennoukaisiymd() {
        return ifeTszennoukaisiymd;
    }

    public void setIfeTszennoukaisiymd(String pIfeTszennoukaisiymd) {
        ifeTszennoukaisiymd = pIfeTszennoukaisiymd;
    }

    @Column(order = 4, label = "renno")
    private String ifeTsrenno;

    public String getIfeTsrenno() {
        return ifeTsrenno;
    }

    public void setIfeTsrenno(String pIfeTsrenno) {
        ifeTsrenno = pIfeTsrenno;
    }

    @Column(order = 5, label = "zennounyuukinsyoriymd")
    private String ifeTszennounyuukinsyoriymd;

    public String getIfeTszennounyuukinsyoriymd() {
        return ifeTszennounyuukinsyoriymd;
    }

    public void setIfeTszennounyuukinsyoriymd(String pIfeTszennounyuukinsyoriymd) {
        ifeTszennounyuukinsyoriymd = pIfeTszennounyuukinsyoriymd;
    }

    @Column(order = 6, label = "zennounyuukindenno")
    private String ifeTszennounyuukindenno;

    public String getIfeTszennounyuukindenno() {
        return ifeTszennounyuukindenno;
    }

    public void setIfeTszennounyuukindenno(String pIfeTszennounyuukindenno) {
        ifeTszennounyuukindenno = pIfeTszennounyuukindenno;
    }

    @Column(order = 7, label = "zennounyuukindenymd")
    private String ifeTszennounyuukindenymd;

    public String getIfeTszennounyuukindenymd() {
        return ifeTszennounyuukindenymd;
    }

    public void setIfeTszennounyuukindenymd(String pIfeTszennounyuukindenymd) {
        ifeTszennounyuukindenymd = pIfeTszennounyuukindenymd;
    }

    @Column(order = 8, label = "ryosyuymd")
    private String ifeTsryosyuymd;

    public String getIfeTsryosyuymd() {
        return ifeTsryosyuymd;
    }

    public void setIfeTsryosyuymd(String pIfeTsryosyuymd) {
        ifeTsryosyuymd = pIfeTsryosyuymd;
    }

    @Column(order = 9, label = "zennoukikan")
    private String ifeTszennoukikan;

    public String getIfeTszennoukikan() {
        return ifeTszennoukikan;
    }

    public void setIfeTszennoukikan(String pIfeTszennoukikan) {
        ifeTszennoukikan = pIfeTszennoukikan;
    }

    @Column(order = 10, label = "zennounyuukinkgk")
    private String ifeTszennounyuukinkgk;

    public String getIfeTszennounyuukinkgk() {
        return ifeTszennounyuukinkgk;
    }

    public void setIfeTszennounyuukinkgk(String pIfeTszennounyuukinkgk) {
        ifeTszennounyuukinkgk = pIfeTszennounyuukinkgk;
    }

    @Column(order = 11, label = "zennounyuukinkgk$")
    private String ifeTszennounyuukinkgkt;

    public String getIfeTszennounyuukinkgkt() {
        return ifeTszennounyuukinkgkt;
    }

    public void setIfeTszennounyuukinkgkt(String pIfeTszennounyuukinkgkt) {
        ifeTszennounyuukinkgkt = pIfeTszennounyuukinkgkt;
    }

    @Column(order = 12, label = "zennoujihrkp")
    private String ifeTszennoujihrkp;

    public String getIfeTszennoujihrkp() {
        return ifeTszennoujihrkp;
    }

    public void setIfeTszennoujihrkp(String pIfeTszennoujihrkp) {
        ifeTszennoujihrkp = pIfeTszennoujihrkp;
    }

    @Column(order = 13, label = "zennoujihrkp$")
    private String ifeTszennoujihrkpt;

    public String getIfeTszennoujihrkpt() {
        return ifeTszennoujihrkpt;
    }

    public void setIfeTszennoujihrkpt(String pIfeTszennoujihrkpt) {
        ifeTszennoujihrkpt = pIfeTszennoujihrkpt;
    }

    @Column(order = 14, label = "zennouseisankbn")
    private String ifeTszennouseisankbn;

    public String getIfeTszennouseisankbn() {
        return ifeTszennouseisankbn;
    }

    public void setIfeTszennouseisankbn(String pIfeTszennouseisankbn) {
        ifeTszennouseisankbn = pIfeTszennouseisankbn;
    }

    @Column(order = 15, label = "zennouseisansyoriymd")
    private String ifeTszennouseisansyoriymd;

    public String getIfeTszennouseisansyoriymd() {
        return ifeTszennouseisansyoriymd;
    }

    public void setIfeTszennouseisansyoriymd(String pIfeTszennouseisansyoriymd) {
        ifeTszennouseisansyoriymd = pIfeTszennouseisansyoriymd;
    }

    @Column(order = 16, label = "zennouseisankgk")
    private String ifeTszennouseisankgk;

    public String getIfeTszennouseisankgk() {
        return ifeTszennouseisankgk;
    }

    public void setIfeTszennouseisankgk(String pIfeTszennouseisankgk) {
        ifeTszennouseisankgk = pIfeTszennouseisankgk;
    }

    @Column(order = 17, label = "zennouseisankgk$")
    private String ifeTszennouseisankgkt;

    public String getIfeTszennouseisankgkt() {
        return ifeTszennouseisankgkt;
    }

    public void setIfeTszennouseisankgkt(String pIfeTszennouseisankgkt) {
        ifeTszennouseisankgkt = pIfeTszennouseisankgkt;
    }

    @Column(order = 18, label = "zennouseisankijyunymd")
    private String ifeTszennouseisankijyunymd;

    public String getIfeTszennouseisankijyunymd() {
        return ifeTszennouseisankijyunymd;
    }

    public void setIfeTszennouseisankijyunymd(String pIfeTszennouseisankijyunymd) {
        ifeTszennouseisankijyunymd = pIfeTszennouseisankijyunymd;
    }

    @Column(order = 19, label = "zennouseisandenymd")
    private String ifeTszennouseisandenymd;

    public String getIfeTszennouseisandenymd() {
        return ifeTszennouseisandenymd;
    }

    public void setIfeTszennouseisandenymd(String pIfeTszennouseisandenymd) {
        ifeTszennouseisandenymd = pIfeTszennouseisandenymd;
    }

    @Column(order = 20, label = "annaisaikaiym")
    private String ifeTsannaisaikaiym;

    public String getIfeTsannaisaikaiym() {
        return ifeTsannaisaikaiym;
    }

    public void setIfeTsannaisaikaiym(String pIfeTsannaisaikaiym) {
        ifeTsannaisaikaiym = pIfeTsannaisaikaiym;
    }

    @Column(order = 21, label = "kjsmyouzennoukaisiymd")
    private String ifeTskjsmyouzennoukaisiymd;

    public String getIfeTskjsmyouzennoukaisiymd() {
        return ifeTskjsmyouzennoukaisiymd;
    }

    public void setIfeTskjsmyouzennoukaisiymd(String pIfeTskjsmyouzennoukaisiymd) {
        ifeTskjsmyouzennoukaisiymd = pIfeTskjsmyouzennoukaisiymd;
    }

    @Column(order = 22, label = "kjsmyouzennoukikanm")
    private String ifeTskjsmyouzennoukikanm;

    public String getIfeTskjsmyouzennoukikanm() {
        return ifeTskjsmyouzennoukikanm;
    }

    public void setIfeTskjsmyouzennoukikanm(String pIfeTskjsmyouzennoukikanm) {
        ifeTskjsmyouzennoukikanm = pIfeTskjsmyouzennoukikanm;
    }

    @Column(order = 23, label = "kjsmyouzennounyuukinkgk")
    private String ifeTskjsmyouzennounyukingk;

    public String getIfeTskjsmyouzennounyukingk() {
        return ifeTskjsmyouzennounyukingk;
    }

    public void setIfeTskjsmyouzennounyukingk(String pIfeTskjsmyouzennounyukingk) {
        ifeTskjsmyouzennounyukingk = pIfeTskjsmyouzennounyukingk;
    }

    @Column(order = 24, label = "kjsmyouzennounyuukinkgk$")
    private String ifeTskjsmyouzennounyukingkt;

    public String getIfeTskjsmyouzennounyukingkt() {
        return ifeTskjsmyouzennounyukingkt;
    }

    public void setIfeTskjsmyouzennounyukingkt(String pIfeTskjsmyouzennounyukingkt) {
        ifeTskjsmyouzennounyukingkt = pIfeTskjsmyouzennounyukingkt;
    }

    @Column(order = 25, label = "gyoumuKousinKinou")
    private String ifeTsgyoumukousinkinou;

    public String getIfeTsgyoumukousinkinou() {
        return ifeTsgyoumukousinkinou;
    }

    public void setIfeTsgyoumukousinkinou(String pIfeTsgyoumukousinkinou) {
        ifeTsgyoumukousinkinou = pIfeTsgyoumukousinkinou;
    }

    @Column(order = 26, label = "gyoumuKousinsyaId")
    private String ifeTsgyoumukousinsyaid;

    public String getIfeTsgyoumukousinsyaid() {
        return ifeTsgyoumukousinsyaid;
    }

    public void setIfeTsgyoumukousinsyaid(String pIfeTsgyoumukousinsyaid) {
        ifeTsgyoumukousinsyaid = pIfeTsgyoumukousinsyaid;
    }

    @Column(order = 27, label = "gyoumuKousinTime")
    private String ifeTsgyoumukousintime;

    public String getIfeTsgyoumukousintime() {
        return ifeTsgyoumukousintime;
    }

    public void setIfeTsgyoumukousintime(String pIfeTsgyoumukousintime) {
        ifeTsgyoumukousintime = pIfeTsgyoumukousintime;
    }

    @Column(order = 28, label = "kousinsyaId")
    private String ifeTskousinsyaid;

    public String getIfeTskousinsyaid() {
        return ifeTskousinsyaid;
    }

    public void setIfeTskousinsyaid(String pIfeTskousinsyaid) {
        ifeTskousinsyaid = pIfeTskousinsyaid;
    }

    @Column(order = 29, label = "kousinTime")
    private String ifeTskousintime;

    public String getIfeTskousintime() {
        return ifeTskousintime;
    }

    public void setIfeTskousintime(String pIfeTskousintime) {
        ifeTskousintime = pIfeTskousintime;
    }

    @Column(order = 30, label = "kousinKinou")
    private String ifeTskousinkinou;

    public String getIfeTskousinkinou() {
        return ifeTskousinkinou;
    }

    public void setIfeTskousinkinou(String pIfeTskousinkinou) {
        ifeTskousinkinou = pIfeTskousinkinou;
    }

    @Column(order = 31, label = "version")
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
