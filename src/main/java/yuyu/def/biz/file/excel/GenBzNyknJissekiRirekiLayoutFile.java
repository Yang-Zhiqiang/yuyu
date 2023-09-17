package yuyu.def.biz.file.excel;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.excel.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）入金実績履歴テーブルレイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzNyknJissekiRirekiLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzNyknJissekiRirekiLayoutFile() {
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

    @Column(order = 3, label = "jyutoustartym")
    private String ifeTsjyutoustartym;

    public String getIfeTsjyutoustartym() {
        return ifeTsjyutoustartym;
    }

    public void setIfeTsjyutoustartym(String pIfeTsjyutoustartym) {
        ifeTsjyutoustartym = pIfeTsjyutoustartym;
    }

    @Column(order = 4, label = "renno")
    private String ifeTsrenno;

    public String getIfeTsrenno() {
        return ifeTsrenno;
    }

    public void setIfeTsrenno(String pIfeTsrenno) {
        ifeTsrenno = pIfeTsrenno;
    }

    @Column(order = 5, label = "jyutouendym")
    private String ifeTsjyutouendym;

    public String getIfeTsjyutouendym() {
        return ifeTsjyutouendym;
    }

    public void setIfeTsjyutouendym(String pIfeTsjyutouendym) {
        ifeTsjyutouendym = pIfeTsjyutouendym;
    }

    @Column(order = 6, label = "rsgaku")
    private String ifeTsrsgaku;

    public String getIfeTsrsgaku() {
        return ifeTsrsgaku;
    }

    public void setIfeTsrsgaku(String pIfeTsrsgaku) {
        ifeTsrsgaku = pIfeTsrsgaku;
    }

    @Column(order = 7, label = "rsgaku$")
    private String ifeTsrsgakut;

    public String getIfeTsrsgakut() {
        return ifeTsrsgakut;
    }

    public void setIfeTsrsgakut(String pIfeTsrsgakut) {
        ifeTsrsgakut = pIfeTsrsgakut;
    }

    @Column(order = 8, label = "rstuukasyu")
    private String ifeTsrstuukasyu;

    public String getIfeTsrstuukasyu() {
        return ifeTsrstuukasyu;
    }

    public void setIfeTsrstuukasyu(String pIfeTsrstuukasyu) {
        ifeTsrstuukasyu = pIfeTsrstuukasyu;
    }

    @Column(order = 9, label = "ryosyukwsratekjymd")
    private String ifeTsryosyukwsratekjymd;

    public String getIfeTsryosyukwsratekjymd() {
        return ifeTsryosyukwsratekjymd;
    }

    public void setIfeTsryosyukwsratekjymd(String pIfeTsryosyukwsratekjymd) {
        ifeTsryosyukwsratekjymd = pIfeTsryosyukwsratekjymd;
    }

    @Column(order = 10, label = "ryosyukwsrate")
    private String ifeTsryosyukwsrate;

    public String getIfeTsryosyukwsrate() {
        return ifeTsryosyukwsrate;
    }

    public void setIfeTsryosyukwsrate(String pIfeTsryosyukwsrate) {
        ifeTsryosyukwsrate = pIfeTsryosyukwsrate;
    }

    @Column(order = 11, label = "hrkp")
    private String ifeTshrkp;

    public String getIfeTshrkp() {
        return ifeTshrkp;
    }

    public void setIfeTshrkp(String pIfeTshrkp) {
        ifeTshrkp = pIfeTshrkp;
    }

    @Column(order = 12, label = "hrkp$")
    private String ifeTshrkpt;

    public String getIfeTshrkpt() {
        return ifeTshrkpt;
    }

    public void setIfeTshrkpt(String pIfeTshrkpt) {
        ifeTshrkpt = pIfeTshrkpt;
    }

    @Column(order = 13, label = "iktwaribikikgk")
    private String ifeTsiktwaribikikgk;

    public String getIfeTsiktwaribikikgk() {
        return ifeTsiktwaribikikgk;
    }

    public void setIfeTsiktwaribikikgk(String pIfeTsiktwaribikikgk) {
        ifeTsiktwaribikikgk = pIfeTsiktwaribikikgk;
    }

    @Column(order = 14, label = "iktwaribikikgk$")
    private String ifeTsiktwaribikikgkt;

    public String getIfeTsiktwaribikikgkt() {
        return ifeTsiktwaribikikgkt;
    }

    public void setIfeTsiktwaribikikgkt(String pIfeTsiktwaribikikgkt) {
        ifeTsiktwaribikikgkt = pIfeTsiktwaribikikgkt;
    }

    @Column(order = 15, label = "nyksyoriymd")
    private String ifeTsnyksyoriymd;

    public String getIfeTsnyksyoriymd() {
        return ifeTsnyksyoriymd;
    }

    public void setIfeTsnyksyoriymd(String pIfeTsnyksyoriymd) {
        ifeTsnyksyoriymd = pIfeTsnyksyoriymd;
    }

    @Column(order = 16, label = "ryosyuymd")
    private String ifeTsryosyuymd;

    public String getIfeTsryosyuymd() {
        return ifeTsryosyuymd;
    }

    public void setIfeTsryosyuymd(String pIfeTsryosyuymd) {
        ifeTsryosyuymd = pIfeTsryosyuymd;
    }

    @Column(order = 17, label = "nykdenno")
    private String ifeTsnykdenno;

    public String getIfeTsnykdenno() {
        return ifeTsnykdenno;
    }

    public void setIfeTsnykdenno(String pIfeTsnykdenno) {
        ifeTsnykdenno = pIfeTsnykdenno;
    }

    @Column(order = 18, label = "nykdenymd")
    private String ifeTsnykdenymd;

    public String getIfeTsnykdenymd() {
        return ifeTsnykdenymd;
    }

    public void setIfeTsnykdenymd(String pIfeTsnykdenymd) {
        ifeTsnykdenymd = pIfeTsnykdenymd;
    }

    @Column(order = 19, label = "nykkeiro")
    private String ifeTsnykkeiro;

    public String getIfeTsnykkeiro() {
        return ifeTsnykkeiro;
    }

    public void setIfeTsnykkeiro(String pIfeTsnykkeiro) {
        ifeTsnykkeiro = pIfeTsnykkeiro;
    }

    @Column(order = 20, label = "hrkkaisuu")
    private String ifeTshrkkaisuu;

    public String getIfeTshrkkaisuu() {
        return ifeTshrkkaisuu;
    }

    public void setIfeTshrkkaisuu(String pIfeTshrkkaisuu) {
        ifeTshrkkaisuu = pIfeTshrkkaisuu;
    }

    @Column(order = 21, label = "jyutoukaisuuy")
    private String ifeTsjyutoukaisuuy;

    public String getIfeTsjyutoukaisuuy() {
        return ifeTsjyutoukaisuuy;
    }

    public void setIfeTsjyutoukaisuuy(String pIfeTsjyutoukaisuuy) {
        ifeTsjyutoukaisuuy = pIfeTsjyutoukaisuuy;
    }

    @Column(order = 22, label = "jyutoukaisuum")
    private String ifeTsjyutoukaisuum;

    public String getIfeTsjyutoukaisuum() {
        return ifeTsjyutoukaisuum;
    }

    public void setIfeTsjyutoukaisuum(String pIfeTsjyutoukaisuum) {
        ifeTsjyutoukaisuum = pIfeTsjyutoukaisuum;
    }

    @Column(order = 23, label = "nyknaiyoukbn")
    private String ifeTsnyknaiyoukbn;

    public String getIfeTsnyknaiyoukbn() {
        return ifeTsnyknaiyoukbn;
    }

    public void setIfeTsnyknaiyoukbn(String pIfeTsnyknaiyoukbn) {
        ifeTsnyknaiyoukbn = pIfeTsnyknaiyoukbn;
    }

    @Column(order = 24, label = "iktnyuukinnumu")
    private String ifeTsiktnyuukinnumu;

    public String getIfeTsiktnyuukinnumu() {
        return ifeTsiktnyuukinnumu;
    }

    public void setIfeTsiktnyuukinnumu(String pIfeTsiktnyuukinnumu) {
        ifeTsiktnyuukinnumu = pIfeTsiktnyuukinnumu;
    }

    @Column(order = 25, label = "nyktrksflg")
    private String ifeTsnyktrksflg;

    public String getIfeTsnyktrksflg() {
        return ifeTsnyktrksflg;
    }

    public void setIfeTsnyktrksflg(String pIfeTsnyktrksflg) {
        ifeTsnyktrksflg = pIfeTsnyktrksflg;
    }

    @Column(order = 26, label = "nyktrksymd")
    private String ifeTsnyktrksymd;

    public String getIfeTsnyktrksymd() {
        return ifeTsnyktrksymd;
    }

    public void setIfeTsnyktrksymd(String pIfeTsnyktrksymd) {
        ifeTsnyktrksymd = pIfeTsnyktrksymd;
    }

    @Column(order = 27, label = "nyktrksdenno")
    private String ifeTsnyktrksdenno;

    public String getIfeTsnyktrksdenno() {
        return ifeTsnyktrksdenno;
    }

    public void setIfeTsnyktrksdenno(String pIfeTsnyktrksdenno) {
        ifeTsnyktrksdenno = pIfeTsnyktrksdenno;
    }

    @Column(order = 28, label = "nyktrksdenymd")
    private String ifeTsnyktrksdenymd;

    public String getIfeTsnyktrksdenymd() {
        return ifeTsnyktrksdenymd;
    }

    public void setIfeTsnyktrksdenymd(String pIfeTsnyktrksdenymd) {
        ifeTsnyktrksdenymd = pIfeTsnyktrksdenymd;
    }

    @Column(order = 29, label = "yenkansannyknkingk")
    private String ifeTsyenkansannyknkingk;

    public String getIfeTsyenkansannyknkingk() {
        return ifeTsyenkansannyknkingk;
    }

    public void setIfeTsyenkansannyknkingk(String pIfeTsyenkansannyknkingk) {
        ifeTsyenkansannyknkingk = pIfeTsyenkansannyknkingk;
    }

    @Column(order = 30, label = "yenkansannyknkingk$")
    private String ifeTsyenkansannyknkingkt;

    public String getIfeTsyenkansannyknkingkt() {
        return ifeTsyenkansannyknkingkt;
    }

    public void setIfeTsyenkansannyknkingkt(String pIfeTsyenkansannyknkingkt) {
        ifeTsyenkansannyknkingkt = pIfeTsyenkansannyknkingkt;
    }

    @Column(order = 31, label = "yenkansantkykwsrateymd")
    private String ifeTsyenkansantkykwsrateymd;

    public String getIfeTsyenkansantkykwsrateymd() {
        return ifeTsyenkansantkykwsrateymd;
    }

    public void setIfeTsyenkansantkykwsrateymd(String pIfeTsyenkansantkykwsrateymd) {
        ifeTsyenkansantkykwsrateymd = pIfeTsyenkansantkykwsrateymd;
    }

    @Column(order = 32, label = "yenkansantkykwsrate")
    private String ifeTsyenkansantkykwsrate;

    public String getIfeTsyenkansantkykwsrate() {
        return ifeTsyenkansantkykwsrate;
    }

    public void setIfeTsyenkansantkykwsrate(String pIfeTsyenkansantkykwsrate) {
        ifeTsyenkansantkykwsrate = pIfeTsyenkansantkykwsrate;
    }

    @Column(order = 33, label = "henkousikibetukey")
    private String ifeTshenkousikibetukey;

    public String getIfeTshenkousikibetukey() {
        return ifeTshenkousikibetukey;
    }

    public void setIfeTshenkousikibetukey(String pIfeTshenkousikibetukey) {
        ifeTshenkousikibetukey = pIfeTshenkousikibetukey;
    }

    @Column(order = 34, label = "gyoumuKousinKinou")
    private String ifeTsgyoumukousinkinou;

    public String getIfeTsgyoumukousinkinou() {
        return ifeTsgyoumukousinkinou;
    }

    public void setIfeTsgyoumukousinkinou(String pIfeTsgyoumukousinkinou) {
        ifeTsgyoumukousinkinou = pIfeTsgyoumukousinkinou;
    }

    @Column(order = 35, label = "gyoumuKousinsyaId")
    private String ifeTsgyoumukousinsyaid;

    public String getIfeTsgyoumukousinsyaid() {
        return ifeTsgyoumukousinsyaid;
    }

    public void setIfeTsgyoumukousinsyaid(String pIfeTsgyoumukousinsyaid) {
        ifeTsgyoumukousinsyaid = pIfeTsgyoumukousinsyaid;
    }

    @Column(order = 36, label = "gyoumuKousinTime")
    private String ifeTsgyoumukousintime;

    public String getIfeTsgyoumukousintime() {
        return ifeTsgyoumukousintime;
    }

    public void setIfeTsgyoumukousintime(String pIfeTsgyoumukousintime) {
        ifeTsgyoumukousintime = pIfeTsgyoumukousintime;
    }

    @Column(order = 37, label = "kousinsyaId")
    private String ifeTskousinsyaid;

    public String getIfeTskousinsyaid() {
        return ifeTskousinsyaid;
    }

    public void setIfeTskousinsyaid(String pIfeTskousinsyaid) {
        ifeTskousinsyaid = pIfeTskousinsyaid;
    }

    @Column(order = 38, label = "kousinTime")
    private String ifeTskousintime;

    public String getIfeTskousintime() {
        return ifeTskousintime;
    }

    public void setIfeTskousintime(String pIfeTskousintime) {
        ifeTskousintime = pIfeTskousintime;
    }

    @Column(order = 39, label = "kousinKinou")
    private String ifeTskousinkinou;

    public String getIfeTskousinkinou() {
        return ifeTskousinkinou;
    }

    public void setIfeTskousinkinou(String pIfeTskousinkinou) {
        ifeTskousinkinou = pIfeTskousinkinou;
    }

    @Column(order = 40, label = "version")
    private String ifeTsversion;

    public String getIfeTsversion() {
        return ifeTsversion;
    }

    public void setIfeTsversion(String pIfeTsversion) {
        ifeTsversion = pIfeTsversion;
    }

    @Column(order = 41, label = "ikkatuyoupkaisuu")
    private String ifeTsikkatuyoupkaisuu;

    public String getIfeTsikkatuyoupkaisuu() {
        return ifeTsikkatuyoupkaisuu;
    }

    public void setIfeTsikkatuyoupkaisuu(String pIfeTsikkatuyoupkaisuu) {
        ifeTsikkatuyoupkaisuu = pIfeTsikkatuyoupkaisuu;
    }

    @Column(order = 42, label = "tikiktbrisyuruikbn")
    private String ifeTstikiktbrisyuruikbn;

    public String getIfeTstikiktbrisyuruikbn() {
        return ifeTstikiktbrisyuruikbn;
    }

    public void setIfeTstikiktbrisyuruikbn(String pIfeTstikiktbrisyuruikbn) {
        ifeTstikiktbrisyuruikbn = pIfeTstikiktbrisyuruikbn;
    }

    @Column(order = 43, label = "creditkessaiyouno")
    private String ifeTscreditkessaiyouno;

    public String getIfeTscreditkessaiyouno() {
        return ifeTscreditkessaiyouno;
    }

    public void setIfeTscreditkessaiyouno(String pIfeTscreditkessaiyouno) {
        ifeTscreditkessaiyouno = pIfeTscreditkessaiyouno;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
