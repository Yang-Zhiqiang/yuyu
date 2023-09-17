package yuyu.def.biz.file.excel;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.excel.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （共通）控除証明書テーブルレイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzKoujyoSymLayoutFile implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzKoujyoSymLayoutFile() {
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

    @Column(order = 3, label = "nendo")
    private String ifeTsnendo;

    public String getIfeTsnendo() {
        return ifeTsnendo;
    }

    public void setIfeTsnendo(String pIfeTsnendo) {
        ifeTsnendo = pIfeTsnendo;
    }

    @Column(order = 4, label = "tyouhyouymd")
    private String ifeTstyouhyouymd;

    public String getIfeTstyouhyouymd() {
        return ifeTstyouhyouymd;
    }

    public void setIfeTstyouhyouymd(String pIfeTstyouhyouymd) {
        ifeTstyouhyouymd = pIfeTstyouhyouymd;
    }

    @Column(order = 5, label = "renno")
    private String ifeTsrenno;

    public String getIfeTsrenno() {
        return ifeTsrenno;
    }

    public void setIfeTsrenno(String pIfeTsrenno) {
        ifeTsrenno = pIfeTsrenno;
    }

    @Column(order = 6, label = "kjsmsakuseisyorikbn")
    private String ifeTskjsmsakuseisyorikbn;

    public String getIfeTskjsmsakuseisyorikbn() {
        return ifeTskjsmsakuseisyorikbn;
    }

    public void setIfeTskjsmsakuseisyorikbn(String pIfeTskjsmsakuseisyorikbn) {
        ifeTskjsmsakuseisyorikbn = pIfeTskjsmsakuseisyorikbn;
    }

    @Column(order = 7, label = "tekiyouseidokbn")
    private String ifeTstekiyouseidokbn;

    public String getIfeTstekiyouseidokbn() {
        return ifeTstekiyouseidokbn;
    }

    public void setIfeTstekiyouseidokbn(String pIfeTstekiyouseidokbn) {
        ifeTstekiyouseidokbn = pIfeTstekiyouseidokbn;
    }

    @Column(order = 8, label = "syoumeiymd")
    private String ifeTssyoumeiymd;

    public String getIfeTssyoumeiymd() {
        return ifeTssyoumeiymd;
    }

    public void setIfeTssyoumeiymd(String pIfeTssyoumeiymd) {
        ifeTssyoumeiymd = pIfeTssyoumeiymd;
    }

    @Column(order = 9, label = "syoumeistartym")
    private String ifeTssyoumeistartym;

    public String getIfeTssyoumeistartym() {
        return ifeTssyoumeistartym;
    }

    public void setIfeTssyoumeistartym(String pIfeTssyoumeistartym) {
        ifeTssyoumeistartym = pIfeTssyoumeistartym;
    }

    @Column(order = 10, label = "syoumeiendym")
    private String ifeTssyoumeiendym;

    public String getIfeTssyoumeiendym() {
        return ifeTssyoumeiendym;
    }

    public void setIfeTssyoumeiendym(String pIfeTssyoumeiendym) {
        ifeTssyoumeiendym = pIfeTssyoumeiendym;
    }

    @Column(order = 11, label = "syoumeikkntukisuu")
    private String ifeTssyoumeikkntukisuu;

    public String getIfeTssyoumeikkntukisuu() {
        return ifeTssyoumeikkntukisuu;
    }

    public void setIfeTssyoumeikkntukisuu(String pIfeTssyoumeikkntukisuu) {
        ifeTssyoumeikkntukisuu = pIfeTssyoumeikkntukisuu;
    }

    @Column(order = 12, label = "syoumeikknnensuu")
    private String ifeTssyoumeikknnensuu;

    public String getIfeTssyoumeikknnensuu() {
        return ifeTssyoumeikknnensuu;
    }

    public void setIfeTssyoumeikknnensuu(String pIfeTssyoumeikknnensuu) {
        ifeTssyoumeikknnensuu = pIfeTssyoumeikknnensuu;
    }

    @Column(order = 13, label = "kyknmkj")
    private String ifeTskyknmkj;

    public String getIfeTskyknmkj() {
        return ifeTskyknmkj;
    }

    public void setIfeTskyknmkj(String pIfeTskyknmkj) {
        ifeTskyknmkj = pIfeTskyknmkj;
    }

    @Column(order = 14, label = "uktnmkjaddsama")
    private String ifeTsuktnmkjaddsama;

    public String getIfeTsuktnmkjaddsama() {
        return ifeTsuktnmkjaddsama;
    }

    public void setIfeTsuktnmkjaddsama(String pIfeTsuktnmkjaddsama) {
        ifeTsuktnmkjaddsama = pIfeTsuktnmkjaddsama;
    }

    @Column(order = 15, label = "nenkinuktseiymd")
    private String ifeTsnenkinuktseiymd;

    public String getIfeTsnenkinuktseiymd() {
        return ifeTsnenkinuktseiymd;
    }

    public void setIfeTsnenkinuktseiymd(String pIfeTsnenkinuktseiymd) {
        ifeTsnenkinuktseiymd = pIfeTsnenkinuktseiymd;
    }

    @Column(order = 16, label = "hknsyuruinmrykkj")
    private String ifeTshknsyuruinmrykkj;

    public String getIfeTshknsyuruinmrykkj() {
        return ifeTshknsyuruinmrykkj;
    }

    public void setIfeTshknsyuruinmrykkj(String pIfeTshknsyuruinmrykkj) {
        ifeTshknsyuruinmrykkj = pIfeTshknsyuruinmrykkj;
    }

    @Column(order = 17, label = "kykymd")
    private String ifeTskykymd;

    public String getIfeTskykymd() {
        return ifeTskykymd;
    }

    public void setIfeTskykymd(String pIfeTskykymd) {
        ifeTskykymd = pIfeTskykymd;
    }

    @Column(order = 18, label = "hknkknsmnkbnsyu")
    private String ifeTshknkknsmnkbnsyu;

    public String getIfeTshknkknsmnkbnsyu() {
        return ifeTshknkknsmnkbnsyu;
    }

    public void setIfeTshknkknsmnkbnsyu(String pIfeTshknkknsmnkbnsyu) {
        ifeTshknkknsmnkbnsyu = pIfeTshknkknsmnkbnsyu;
    }

    @Column(order = 19, label = "hknkknsyu")
    private String ifeTshknkknsyu;

    public String getIfeTshknkknsyu() {
        return ifeTshknkknsyu;
    }

    public void setIfeTshknkknsyu(String pIfeTshknkknsyu) {
        ifeTshknkknsyu = pIfeTshknkknsyu;
    }

    @Column(order = 20, label = "nenkanhrkkaisuu")
    private String ifeTsnenkanhrkkaisuu;

    public String getIfeTsnenkanhrkkaisuu() {
        return ifeTsnenkanhrkkaisuu;
    }

    public void setIfeTsnenkanhrkkaisuu(String pIfeTsnenkanhrkkaisuu) {
        ifeTsnenkanhrkkaisuu = pIfeTsnenkanhrkkaisuu;
    }

    @Column(order = 21, label = "phrkkkn")
    private String ifeTsphrkkkn;

    public String getIfeTsphrkkkn() {
        return ifeTsphrkkkn;
    }

    public void setIfeTsphrkkkn(String pIfeTsphrkkkn) {
        ifeTsphrkkkn = pIfeTsphrkkkn;
    }

    @Column(order = 22, label = "nkshrstartymd")
    private String ifeTsnkshrstartymd;

    public String getIfeTsnkshrstartymd() {
        return ifeTsnkshrstartymd;
    }

    public void setIfeTsnkshrstartymd(String pIfeTsnkshrstartymd) {
        ifeTsnkshrstartymd = pIfeTsnkshrstartymd;
    }

    @Column(order = 23, label = "nknshry")
    private String ifeTsnknshry;

    public String getIfeTsnknshry() {
        return ifeTsnknshry;
    }

    public void setIfeTsnknshry(String pIfeTsnknshry) {
        ifeTsnknshry = pIfeTsnknshry;
    }

    @Column(order = 24, label = "kykjyoutai")
    private String ifeTskykjyoutai;

    public String getIfeTskykjyoutai() {
        return ifeTskykjyoutai;
    }

    public void setIfeTskykjyoutai(String pIfeTskykjyoutai) {
        ifeTskykjyoutai = pIfeTskykjyoutai;
    }

    @Column(order = 25, label = "yuukousyoumetukbn")
    private String ifeTsyuukousyoumetukbn;

    public String getIfeTsyuukousyoumetukbn() {
        return ifeTsyuukousyoumetukbn;
    }

    public void setIfeTsyuukousyoumetukbn(String pIfeTsyuukousyoumetukbn) {
        ifeTsyuukousyoumetukbn = pIfeTsyuukousyoumetukbn;
    }

    @Column(order = 26, label = "haitoukinuketorihoukbn")
    private String ifeTshaitoukinuketorihoukbn;

    public String getIfeTshaitoukinuketorihoukbn() {
        return ifeTshaitoukinuketorihoukbn;
    }

    public void setIfeTshaitoukinuketorihoukbn(String pIfeTshaitoukinuketorihoukbn) {
        ifeTshaitoukinuketorihoukbn = pIfeTshaitoukinuketorihoukbn;
    }

    @Column(order = 27, label = "oldippanjissekip")
    private String ifeTsoldippanjissekip;

    public String getIfeTsoldippanjissekip() {
        return ifeTsoldippanjissekip;
    }

    public void setIfeTsoldippanjissekip(String pIfeTsoldippanjissekip) {
        ifeTsoldippanjissekip = pIfeTsoldippanjissekip;
    }

    @Column(order = 28, label = "oldippanjissekip$")
    private String ifeTsoldippanjissekipt;

    public String getIfeTsoldippanjissekipt() {
        return ifeTsoldippanjissekipt;
    }

    public void setIfeTsoldippanjissekipt(String pIfeTsoldippanjissekipt) {
        ifeTsoldippanjissekipt = pIfeTsoldippanjissekipt;
    }

    @Column(order = 29, label = "oldippannenkanp")
    private String ifeTsoldippannenkanp;

    public String getIfeTsoldippannenkanp() {
        return ifeTsoldippannenkanp;
    }

    public void setIfeTsoldippannenkanp(String pIfeTsoldippannenkanp) {
        ifeTsoldippannenkanp = pIfeTsoldippannenkanp;
    }

    @Column(order = 30, label = "oldippannenkanp$")
    private String ifeTsoldippannenkanpt;

    public String getIfeTsoldippannenkanpt() {
        return ifeTsoldippannenkanpt;
    }

    public void setIfeTsoldippannenkanpt(String pIfeTsoldippannenkanpt) {
        ifeTsoldippannenkanpt = pIfeTsoldippannenkanpt;
    }

    @Column(order = 31, label = "oldippanjissekihaitoukin")
    private String ifeTsoldippanjissekihtkin;

    public String getIfeTsoldippanjissekihtkin() {
        return ifeTsoldippanjissekihtkin;
    }

    public void setIfeTsoldippanjissekihtkin(String pIfeTsoldippanjissekihtkin) {
        ifeTsoldippanjissekihtkin = pIfeTsoldippanjissekihtkin;
    }

    @Column(order = 32, label = "oldippanjissekihaitoukin$")
    private String ifeTsoldippanjissekihtkint;

    public String getIfeTsoldippanjissekihtkint() {
        return ifeTsoldippanjissekihtkint;
    }

    public void setIfeTsoldippanjissekihtkint(String pIfeTsoldippanjissekihtkint) {
        ifeTsoldippanjissekihtkint = pIfeTsoldippanjissekihtkint;
    }

    @Column(order = 33, label = "oldippannenkanhaitoukin")
    private String ifeTsoldippannenkanhtkin;

    public String getIfeTsoldippannenkanhtkin() {
        return ifeTsoldippannenkanhtkin;
    }

    public void setIfeTsoldippannenkanhtkin(String pIfeTsoldippannenkanhtkin) {
        ifeTsoldippannenkanhtkin = pIfeTsoldippannenkanhtkin;
    }

    @Column(order = 34, label = "oldippannenkanhaitoukin$")
    private String ifeTsoldippannenkanhtkint;

    public String getIfeTsoldippannenkanhtkint() {
        return ifeTsoldippannenkanhtkint;
    }

    public void setIfeTsoldippannenkanhtkint(String pIfeTsoldippannenkanhtkint) {
        ifeTsoldippannenkanhtkint = pIfeTsoldippannenkanhtkint;
    }

    @Column(order = 35, label = "oldippanjissekisyoumeigk")
    private String ifeTsoldippanjissekisymgk;

    public String getIfeTsoldippanjissekisymgk() {
        return ifeTsoldippanjissekisymgk;
    }

    public void setIfeTsoldippanjissekisymgk(String pIfeTsoldippanjissekisymgk) {
        ifeTsoldippanjissekisymgk = pIfeTsoldippanjissekisymgk;
    }

    @Column(order = 36, label = "oldippanjissekisyoumeigk$")
    private String ifeTsoldippanjissekisymgkt;

    public String getIfeTsoldippanjissekisymgkt() {
        return ifeTsoldippanjissekisymgkt;
    }

    public void setIfeTsoldippanjissekisymgkt(String pIfeTsoldippanjissekisymgkt) {
        ifeTsoldippanjissekisymgkt = pIfeTsoldippanjissekisymgkt;
    }

    @Column(order = 37, label = "oldippannenkansyoumeigk")
    private String ifeTsoldippannenkansymgk;

    public String getIfeTsoldippannenkansymgk() {
        return ifeTsoldippannenkansymgk;
    }

    public void setIfeTsoldippannenkansymgk(String pIfeTsoldippannenkansymgk) {
        ifeTsoldippannenkansymgk = pIfeTsoldippannenkansymgk;
    }

    @Column(order = 38, label = "oldippannenkansyoumeigk$")
    private String ifeTsoldippannenkansymgkt;

    public String getIfeTsoldippannenkansymgkt() {
        return ifeTsoldippannenkansymgkt;
    }

    public void setIfeTsoldippannenkansymgkt(String pIfeTsoldippannenkansymgkt) {
        ifeTsoldippannenkansymgkt = pIfeTsoldippannenkansymgkt;
    }

    @Column(order = 39, label = "newippanjissekip")
    private String ifeTsnewippanjissekip;

    public String getIfeTsnewippanjissekip() {
        return ifeTsnewippanjissekip;
    }

    public void setIfeTsnewippanjissekip(String pIfeTsnewippanjissekip) {
        ifeTsnewippanjissekip = pIfeTsnewippanjissekip;
    }

    @Column(order = 40, label = "newippanjissekip$")
    private String ifeTsnewippanjissekipt;

    public String getIfeTsnewippanjissekipt() {
        return ifeTsnewippanjissekipt;
    }

    public void setIfeTsnewippanjissekipt(String pIfeTsnewippanjissekipt) {
        ifeTsnewippanjissekipt = pIfeTsnewippanjissekipt;
    }

    @Column(order = 41, label = "newippannenkanp")
    private String ifeTsnewippannenkanp;

    public String getIfeTsnewippannenkanp() {
        return ifeTsnewippannenkanp;
    }

    public void setIfeTsnewippannenkanp(String pIfeTsnewippannenkanp) {
        ifeTsnewippannenkanp = pIfeTsnewippannenkanp;
    }

    @Column(order = 42, label = "newippannenkanp$")
    private String ifeTsnewippannenkanpt;

    public String getIfeTsnewippannenkanpt() {
        return ifeTsnewippannenkanpt;
    }

    public void setIfeTsnewippannenkanpt(String pIfeTsnewippannenkanpt) {
        ifeTsnewippannenkanpt = pIfeTsnewippannenkanpt;
    }

    @Column(order = 43, label = "newippanjissekihaitoukin")
    private String ifeTsnewippanjissekihtkin;

    public String getIfeTsnewippanjissekihtkin() {
        return ifeTsnewippanjissekihtkin;
    }

    public void setIfeTsnewippanjissekihtkin(String pIfeTsnewippanjissekihtkin) {
        ifeTsnewippanjissekihtkin = pIfeTsnewippanjissekihtkin;
    }

    @Column(order = 44, label = "newippanjissekihaitoukin$")
    private String ifeTsnewippanjissekihtkint;

    public String getIfeTsnewippanjissekihtkint() {
        return ifeTsnewippanjissekihtkint;
    }

    public void setIfeTsnewippanjissekihtkint(String pIfeTsnewippanjissekihtkint) {
        ifeTsnewippanjissekihtkint = pIfeTsnewippanjissekihtkint;
    }

    @Column(order = 45, label = "newippannenkanhaitoukin")
    private String ifeTsnewippannenkanhtkin;

    public String getIfeTsnewippannenkanhtkin() {
        return ifeTsnewippannenkanhtkin;
    }

    public void setIfeTsnewippannenkanhtkin(String pIfeTsnewippannenkanhtkin) {
        ifeTsnewippannenkanhtkin = pIfeTsnewippannenkanhtkin;
    }

    @Column(order = 46, label = "newippannenkanhaitoukin$")
    private String ifeTsnewippannenkanhtkint;

    public String getIfeTsnewippannenkanhtkint() {
        return ifeTsnewippannenkanhtkint;
    }

    public void setIfeTsnewippannenkanhtkint(String pIfeTsnewippannenkanhtkint) {
        ifeTsnewippannenkanhtkint = pIfeTsnewippannenkanhtkint;
    }

    @Column(order = 47, label = "newippanjissekisyoumeigk")
    private String ifeTsnewippanjissekisymgk;

    public String getIfeTsnewippanjissekisymgk() {
        return ifeTsnewippanjissekisymgk;
    }

    public void setIfeTsnewippanjissekisymgk(String pIfeTsnewippanjissekisymgk) {
        ifeTsnewippanjissekisymgk = pIfeTsnewippanjissekisymgk;
    }

    @Column(order = 48, label = "newippanjissekisyoumeigk$")
    private String ifeTsnewippanjissekisymgkt;

    public String getIfeTsnewippanjissekisymgkt() {
        return ifeTsnewippanjissekisymgkt;
    }

    public void setIfeTsnewippanjissekisymgkt(String pIfeTsnewippanjissekisymgkt) {
        ifeTsnewippanjissekisymgkt = pIfeTsnewippanjissekisymgkt;
    }

    @Column(order = 49, label = "newippannenkansyoumeigk")
    private String ifeTsnewippannenkansymgk;

    public String getIfeTsnewippannenkansymgk() {
        return ifeTsnewippannenkansymgk;
    }

    public void setIfeTsnewippannenkansymgk(String pIfeTsnewippannenkansymgk) {
        ifeTsnewippannenkansymgk = pIfeTsnewippannenkansymgk;
    }

    @Column(order = 50, label = "newippannenkansyoumeigk$")
    private String ifeTsnewippannenkansymgkt;

    public String getIfeTsnewippannenkansymgkt() {
        return ifeTsnewippannenkansymgkt;
    }

    public void setIfeTsnewippannenkansymgkt(String pIfeTsnewippannenkansymgkt) {
        ifeTsnewippannenkansymgkt = pIfeTsnewippannenkansymgkt;
    }

    @Column(order = 51, label = "newiryoujissekip")
    private String ifeTsnewiryoujissekip;

    public String getIfeTsnewiryoujissekip() {
        return ifeTsnewiryoujissekip;
    }

    public void setIfeTsnewiryoujissekip(String pIfeTsnewiryoujissekip) {
        ifeTsnewiryoujissekip = pIfeTsnewiryoujissekip;
    }

    @Column(order = 52, label = "newiryoujissekip$")
    private String ifeTsnewiryoujissekipt;

    public String getIfeTsnewiryoujissekipt() {
        return ifeTsnewiryoujissekipt;
    }

    public void setIfeTsnewiryoujissekipt(String pIfeTsnewiryoujissekipt) {
        ifeTsnewiryoujissekipt = pIfeTsnewiryoujissekipt;
    }

    @Column(order = 53, label = "newiryounenkanp")
    private String ifeTsnewiryounenkanp;

    public String getIfeTsnewiryounenkanp() {
        return ifeTsnewiryounenkanp;
    }

    public void setIfeTsnewiryounenkanp(String pIfeTsnewiryounenkanp) {
        ifeTsnewiryounenkanp = pIfeTsnewiryounenkanp;
    }

    @Column(order = 54, label = "newiryounenkanp$")
    private String ifeTsnewiryounenkanpt;

    public String getIfeTsnewiryounenkanpt() {
        return ifeTsnewiryounenkanpt;
    }

    public void setIfeTsnewiryounenkanpt(String pIfeTsnewiryounenkanpt) {
        ifeTsnewiryounenkanpt = pIfeTsnewiryounenkanpt;
    }

    @Column(order = 55, label = "newiryoujissekihaitoukin")
    private String ifeTsnewiryoujissekihtkin;

    public String getIfeTsnewiryoujissekihtkin() {
        return ifeTsnewiryoujissekihtkin;
    }

    public void setIfeTsnewiryoujissekihtkin(String pIfeTsnewiryoujissekihtkin) {
        ifeTsnewiryoujissekihtkin = pIfeTsnewiryoujissekihtkin;
    }

    @Column(order = 56, label = "newiryoujissekihaitoukin$")
    private String ifeTsnewiryoujissekihtkint;

    public String getIfeTsnewiryoujissekihtkint() {
        return ifeTsnewiryoujissekihtkint;
    }

    public void setIfeTsnewiryoujissekihtkint(String pIfeTsnewiryoujissekihtkint) {
        ifeTsnewiryoujissekihtkint = pIfeTsnewiryoujissekihtkint;
    }

    @Column(order = 57, label = "newiryounenkanhaitoukin")
    private String ifeTsnewiryounenkanhtkin;

    public String getIfeTsnewiryounenkanhtkin() {
        return ifeTsnewiryounenkanhtkin;
    }

    public void setIfeTsnewiryounenkanhtkin(String pIfeTsnewiryounenkanhtkin) {
        ifeTsnewiryounenkanhtkin = pIfeTsnewiryounenkanhtkin;
    }

    @Column(order = 58, label = "newiryounenkanhaitoukin$")
    private String ifeTsnewiryounenkanhtkint;

    public String getIfeTsnewiryounenkanhtkint() {
        return ifeTsnewiryounenkanhtkint;
    }

    public void setIfeTsnewiryounenkanhtkint(String pIfeTsnewiryounenkanhtkint) {
        ifeTsnewiryounenkanhtkint = pIfeTsnewiryounenkanhtkint;
    }

    @Column(order = 59, label = "newiryoujissekisyoumeigk")
    private String ifeTsnewiryoujissekisymgk;

    public String getIfeTsnewiryoujissekisymgk() {
        return ifeTsnewiryoujissekisymgk;
    }

    public void setIfeTsnewiryoujissekisymgk(String pIfeTsnewiryoujissekisymgk) {
        ifeTsnewiryoujissekisymgk = pIfeTsnewiryoujissekisymgk;
    }

    @Column(order = 60, label = "newiryoujissekisyoumeigk$")
    private String ifeTsnewiryoujissekisymgkt;

    public String getIfeTsnewiryoujissekisymgkt() {
        return ifeTsnewiryoujissekisymgkt;
    }

    public void setIfeTsnewiryoujissekisymgkt(String pIfeTsnewiryoujissekisymgkt) {
        ifeTsnewiryoujissekisymgkt = pIfeTsnewiryoujissekisymgkt;
    }

    @Column(order = 61, label = "newiryounenkansyoumeigk")
    private String ifeTsnewiryounenkansymgk;

    public String getIfeTsnewiryounenkansymgk() {
        return ifeTsnewiryounenkansymgk;
    }

    public void setIfeTsnewiryounenkansymgk(String pIfeTsnewiryounenkansymgk) {
        ifeTsnewiryounenkansymgk = pIfeTsnewiryounenkansymgk;
    }

    @Column(order = 62, label = "newiryounenkansyoumeigk$")
    private String ifeTsnewiryounenkansymgkt;

    public String getIfeTsnewiryounenkansymgkt() {
        return ifeTsnewiryounenkansymgkt;
    }

    public void setIfeTsnewiryounenkansymgkt(String pIfeTsnewiryounenkansymgkt) {
        ifeTsnewiryounenkansymgkt = pIfeTsnewiryounenkansymgkt;
    }

    @Column(order = 63, label = "newnkjissekip")
    private String ifeTsnewnkjissekip;

    public String getIfeTsnewnkjissekip() {
        return ifeTsnewnkjissekip;
    }

    public void setIfeTsnewnkjissekip(String pIfeTsnewnkjissekip) {
        ifeTsnewnkjissekip = pIfeTsnewnkjissekip;
    }

    @Column(order = 64, label = "newnkjissekip$")
    private String ifeTsnewnkjissekipt;

    public String getIfeTsnewnkjissekipt() {
        return ifeTsnewnkjissekipt;
    }

    public void setIfeTsnewnkjissekipt(String pIfeTsnewnkjissekipt) {
        ifeTsnewnkjissekipt = pIfeTsnewnkjissekipt;
    }

    @Column(order = 65, label = "newnknenkanp")
    private String ifeTsnewnknenkanp;

    public String getIfeTsnewnknenkanp() {
        return ifeTsnewnknenkanp;
    }

    public void setIfeTsnewnknenkanp(String pIfeTsnewnknenkanp) {
        ifeTsnewnknenkanp = pIfeTsnewnknenkanp;
    }

    @Column(order = 66, label = "newnknenkanp$")
    private String ifeTsnewnknenkanpt;

    public String getIfeTsnewnknenkanpt() {
        return ifeTsnewnknenkanpt;
    }

    public void setIfeTsnewnknenkanpt(String pIfeTsnewnknenkanpt) {
        ifeTsnewnknenkanpt = pIfeTsnewnknenkanpt;
    }

    @Column(order = 67, label = "newnkjissekihaitoukin")
    private String ifeTsnewnkjissekihaitoukin;

    public String getIfeTsnewnkjissekihaitoukin() {
        return ifeTsnewnkjissekihaitoukin;
    }

    public void setIfeTsnewnkjissekihaitoukin(String pIfeTsnewnkjissekihaitoukin) {
        ifeTsnewnkjissekihaitoukin = pIfeTsnewnkjissekihaitoukin;
    }

    @Column(order = 68, label = "newnkjissekihaitoukin$")
    private String ifeTsnewnkjissekihaitoukint;

    public String getIfeTsnewnkjissekihaitoukint() {
        return ifeTsnewnkjissekihaitoukint;
    }

    public void setIfeTsnewnkjissekihaitoukint(String pIfeTsnewnkjissekihaitoukint) {
        ifeTsnewnkjissekihaitoukint = pIfeTsnewnkjissekihaitoukint;
    }

    @Column(order = 69, label = "newnknenkanhaitoukin")
    private String ifeTsnewnknenkanhaitoukin;

    public String getIfeTsnewnknenkanhaitoukin() {
        return ifeTsnewnknenkanhaitoukin;
    }

    public void setIfeTsnewnknenkanhaitoukin(String pIfeTsnewnknenkanhaitoukin) {
        ifeTsnewnknenkanhaitoukin = pIfeTsnewnknenkanhaitoukin;
    }

    @Column(order = 70, label = "newnknenkanhaitoukin$")
    private String ifeTsnewnknenkanhaitoukint;

    public String getIfeTsnewnknenkanhaitoukint() {
        return ifeTsnewnknenkanhaitoukint;
    }

    public void setIfeTsnewnknenkanhaitoukint(String pIfeTsnewnknenkanhaitoukint) {
        ifeTsnewnknenkanhaitoukint = pIfeTsnewnknenkanhaitoukint;
    }

    @Column(order = 71, label = "newnkjissekisyoumeigk")
    private String ifeTsnewnkjissekisyoumeigk;

    public String getIfeTsnewnkjissekisyoumeigk() {
        return ifeTsnewnkjissekisyoumeigk;
    }

    public void setIfeTsnewnkjissekisyoumeigk(String pIfeTsnewnkjissekisyoumeigk) {
        ifeTsnewnkjissekisyoumeigk = pIfeTsnewnkjissekisyoumeigk;
    }

    @Column(order = 72, label = "newnkjissekisyoumeigk$")
    private String ifeTsnewnkjissekisyoumeigkt;

    public String getIfeTsnewnkjissekisyoumeigkt() {
        return ifeTsnewnkjissekisyoumeigkt;
    }

    public void setIfeTsnewnkjissekisyoumeigkt(String pIfeTsnewnkjissekisyoumeigkt) {
        ifeTsnewnkjissekisyoumeigkt = pIfeTsnewnkjissekisyoumeigkt;
    }

    @Column(order = 73, label = "newnknenkansyoumeigk")
    private String ifeTsnewnknenkansyoumeigk;

    public String getIfeTsnewnknenkansyoumeigk() {
        return ifeTsnewnknenkansyoumeigk;
    }

    public void setIfeTsnewnknenkansyoumeigk(String pIfeTsnewnknenkansyoumeigk) {
        ifeTsnewnknenkansyoumeigk = pIfeTsnewnknenkansyoumeigk;
    }

    @Column(order = 74, label = "newnknenkansyoumeigk$")
    private String ifeTsnewnknenkansyoumeigkt;

    public String getIfeTsnewnknenkansyoumeigkt() {
        return ifeTsnewnknenkansyoumeigkt;
    }

    public void setIfeTsnewnknenkansyoumeigkt(String pIfeTsnewnknenkansyoumeigkt) {
        ifeTsnewnknenkansyoumeigkt = pIfeTsnewnknenkansyoumeigkt;
    }

    @Column(order = 75, label = "kjnnkkoujyum")
    private String ifeTskjnnkkoujyum;

    public String getIfeTskjnnkkoujyum() {
        return ifeTskjnnkkoujyum;
    }

    public void setIfeTskjnnkkoujyum(String pIfeTskjnnkkoujyum) {
        ifeTskjnnkkoujyum = pIfeTskjnnkkoujyum;
    }

    @Column(order = 76, label = "tsinyno")
    private String ifeTstsinyno;

    public String getIfeTstsinyno() {
        return ifeTstsinyno;
    }

    public void setIfeTstsinyno(String pIfeTstsinyno) {
        ifeTstsinyno = pIfeTstsinyno;
    }

    @Column(order = 77, label = "tsinadr1kj")
    private String ifeTstsinadr1kj;

    public String getIfeTstsinadr1kj() {
        return ifeTstsinadr1kj;
    }

    public void setIfeTstsinadr1kj(String pIfeTstsinadr1kj) {
        ifeTstsinadr1kj = pIfeTstsinadr1kj;
    }

    @Column(order = 78, label = "tsinadr2kj")
    private String ifeTstsinadr2kj;

    public String getIfeTstsinadr2kj() {
        return ifeTstsinadr2kj;
    }

    public void setIfeTstsinadr2kj(String pIfeTstsinadr2kj) {
        ifeTstsinadr2kj = pIfeTstsinadr2kj;
    }

    @Column(order = 79, label = "tsinadr3kj")
    private String ifeTstsinadr3kj;

    public String getIfeTstsinadr3kj() {
        return ifeTstsinadr3kj;
    }

    public void setIfeTstsinadr3kj(String pIfeTstsinadr3kj) {
        ifeTstsinadr3kj = pIfeTstsinadr3kj;
    }

    @Column(order = 80, label = "toiawasesosikinmkj")
    private String ifeTstoiawasesosikinmkj;

    public String getIfeTstoiawasesosikinmkj() {
        return ifeTstoiawasesosikinmkj;
    }

    public void setIfeTstoiawasesosikinmkj(String pIfeTstoiawasesosikinmkj) {
        ifeTstoiawasesosikinmkj = pIfeTstoiawasesosikinmkj;
    }

    @Column(order = 81, label = "toiawaseyno")
    private String ifeTstoiawaseyno;

    public String getIfeTstoiawaseyno() {
        return ifeTstoiawaseyno;
    }

    public void setIfeTstoiawaseyno(String pIfeTstoiawaseyno) {
        ifeTstoiawaseyno = pIfeTstoiawaseyno;
    }

    @Column(order = 82, label = "toiawaseadr1kj")
    private String ifeTstoiawaseadr1kj;

    public String getIfeTstoiawaseadr1kj() {
        return ifeTstoiawaseadr1kj;
    }

    public void setIfeTstoiawaseadr1kj(String pIfeTstoiawaseadr1kj) {
        ifeTstoiawaseadr1kj = pIfeTstoiawaseadr1kj;
    }

    @Column(order = 83, label = "toiawaseadr2kj")
    private String ifeTstoiawaseadr2kj;

    public String getIfeTstoiawaseadr2kj() {
        return ifeTstoiawaseadr2kj;
    }

    public void setIfeTstoiawaseadr2kj(String pIfeTstoiawaseadr2kj) {
        ifeTstoiawaseadr2kj = pIfeTstoiawaseadr2kj;
    }

    @Column(order = 84, label = "toiawaseadr3kj")
    private String ifeTstoiawaseadr3kj;

    public String getIfeTstoiawaseadr3kj() {
        return ifeTstoiawaseadr3kj;
    }

    public void setIfeTstoiawaseadr3kj(String pIfeTstoiawaseadr3kj) {
        ifeTstoiawaseadr3kj = pIfeTstoiawaseadr3kj;
    }

    @Column(order = 85, label = "toiawasetelno")
    private String ifeTstoiawasetelno;

    public String getIfeTstoiawasetelno() {
        return ifeTstoiawasetelno;
    }

    public void setIfeTstoiawasetelno(String pIfeTstoiawasetelno) {
        ifeTstoiawasetelno = pIfeTstoiawasetelno;
    }

    @Column(order = 86, label = "toiawaseteluktkkanou1")
    private String ifeTstoiawaseteluktkkanou1;

    public String getIfeTstoiawaseteluktkkanou1() {
        return ifeTstoiawaseteluktkkanou1;
    }

    public void setIfeTstoiawaseteluktkkanou1(String pIfeTstoiawaseteluktkkanou1) {
        ifeTstoiawaseteluktkkanou1 = pIfeTstoiawaseteluktkkanou1;
    }

    @Column(order = 87, label = "toiawaseteluktkkanou2")
    private String ifeTstoiawaseteluktkkanou2;

    public String getIfeTstoiawaseteluktkkanou2() {
        return ifeTstoiawaseteluktkkanou2;
    }

    public void setIfeTstoiawaseteluktkkanou2(String pIfeTstoiawaseteluktkkanou2) {
        ifeTstoiawaseteluktkkanou2 = pIfeTstoiawaseteluktkkanou2;
    }

    @Column(order = 88, label = "toiawasesosikinmkj2")
    private String ifeTstoiawasesosikinmkj2;

    public String getIfeTstoiawasesosikinmkj2() {
        return ifeTstoiawasesosikinmkj2;
    }

    public void setIfeTstoiawasesosikinmkj2(String pIfeTstoiawasesosikinmkj2) {
        ifeTstoiawasesosikinmkj2 = pIfeTstoiawasesosikinmkj2;
    }

    @Column(order = 89, label = "toiawasetelno2")
    private String ifeTstoiawasetelno2;

    public String getIfeTstoiawasetelno2() {
        return ifeTstoiawasetelno2;
    }

    public void setIfeTstoiawasetelno2(String pIfeTstoiawasetelno2) {
        ifeTstoiawasetelno2 = pIfeTstoiawasetelno2;
    }

    @Column(order = 90, label = "hassoukbn")
    private String ifeTshassoukbn;

    public String getIfeTshassoukbn() {
        return ifeTshassoukbn;
    }

    public void setIfeTshassoukbn(String pIfeTshassoukbn) {
        ifeTshassoukbn = pIfeTshassoukbn;
    }

    @Column(order = 91, label = "drtencd")
    private String ifeTsdrtencd;

    public String getIfeTsdrtencd() {
        return ifeTsdrtencd;
    }

    public void setIfeTsdrtencd(String pIfeTsdrtencd) {
        ifeTsdrtencd = pIfeTsdrtencd;
    }

    @Column(order = 92, label = "drtennmkj")
    private String ifeTsdrtennmkj;

    public String getIfeTsdrtennmkj() {
        return ifeTsdrtennmkj;
    }

    public void setIfeTsdrtennmkj(String pIfeTsdrtennmkj) {
        ifeTsdrtennmkj = pIfeTsdrtennmkj;
    }

    @Column(order = 93, label = "hengakuumu")
    private String ifeTshengakuumu;

    public String getIfeTshengakuumu() {
        return ifeTshengakuumu;
    }

    public void setIfeTshengakuumu(String pIfeTshengakuumu) {
        ifeTshengakuumu = pIfeTshengakuumu;
    }

    @Column(order = 94, label = "newsyoumeigkumukbn")
    private String ifeTsnewsyoumeigkumukbn;

    public String getIfeTsnewsyoumeigkumukbn() {
        return ifeTsnewsyoumeigkumukbn;
    }

    public void setIfeTsnewsyoumeigkumukbn(String pIfeTsnewsyoumeigkumukbn) {
        ifeTsnewsyoumeigkumukbn = pIfeTsnewsyoumeigkumukbn;
    }

    @Column(order = 95, label = "gyoumuKousinKinou")
    private String ifeTsgyoumukousinkinou;

    public String getIfeTsgyoumukousinkinou() {
        return ifeTsgyoumukousinkinou;
    }

    public void setIfeTsgyoumukousinkinou(String pIfeTsgyoumukousinkinou) {
        ifeTsgyoumukousinkinou = pIfeTsgyoumukousinkinou;
    }

    @Column(order = 96, label = "gyoumuKousinsyaId")
    private String ifeTsgyoumukousinsyaid;

    public String getIfeTsgyoumukousinsyaid() {
        return ifeTsgyoumukousinsyaid;
    }

    public void setIfeTsgyoumukousinsyaid(String pIfeTsgyoumukousinsyaid) {
        ifeTsgyoumukousinsyaid = pIfeTsgyoumukousinsyaid;
    }

    @Column(order = 97, label = "gyoumuKousinTime")
    private String ifeTsgyoumukousintime;

    public String getIfeTsgyoumukousintime() {
        return ifeTsgyoumukousintime;
    }

    public void setIfeTsgyoumukousintime(String pIfeTsgyoumukousintime) {
        ifeTsgyoumukousintime = pIfeTsgyoumukousintime;
    }

    @Column(order = 98, label = "kousinsyaId")
    private String ifeTskousinsyaid;

    public String getIfeTskousinsyaid() {
        return ifeTskousinsyaid;
    }

    public void setIfeTskousinsyaid(String pIfeTskousinsyaid) {
        ifeTskousinsyaid = pIfeTskousinsyaid;
    }

    @Column(order = 99, label = "kousinTime")
    private String ifeTskousintime;

    public String getIfeTskousintime() {
        return ifeTskousintime;
    }

    public void setIfeTskousintime(String pIfeTskousintime) {
        ifeTskousintime = pIfeTskousintime;
    }

    @Column(order = 100, label = "kousinKinou")
    private String ifeTskousinkinou;

    public String getIfeTskousinkinou() {
        return ifeTskousinkinou;
    }

    public void setIfeTskousinkinou(String pIfeTskousinkinou) {
        ifeTskousinkinou = pIfeTskousinkinou;
    }

    @Column(order = 101, label = "version")
    private String ifeTsversion;

    public String getIfeTsversion() {
        return ifeTsversion;
    }

    public void setIfeTsversion(String pIfeTsversion) {
        ifeTsversion = pIfeTsversion;
    }

    @Column(order = 102, label = "koujyosyoumeisentakukbn")
    private String ifeTskoujyosyoumeisentkkbn;

    public String getIfeTskoujyosyoumeisentkkbn() {
        return ifeTskoujyosyoumeisentkkbn;
    }

    public void setIfeTskoujyosyoumeisentkkbn(String pIfeTskoujyosyoumeisentkkbn) {
        ifeTskoujyosyoumeisentkkbn = pIfeTskoujyosyoumeisentkkbn;
    }

    @Column(order = 103, label = "kyknmkn")
    private String ifeTskyknmkn;

    public String getIfeTskyknmkn() {
        return ifeTskyknmkn;
    }

    public void setIfeTskyknmkn(String pIfeTskyknmkn) {
        ifeTskyknmkn = pIfeTskyknmkn;
    }

    @Column(order = 104, label = "uktnmkn")
    private String ifeTsuktnmkn;

    public String getIfeTsuktnmkn() {
        return ifeTsuktnmkn;
    }

    public void setIfeTsuktnmkn(String pIfeTsuktnmkn) {
        ifeTsuktnmkn = pIfeTsuktnmkn;
    }

    @Column(order = 105, label = "saihkhyjkbn")
    private String ifeTssaihkhyjkbn;

    public String getIfeTssaihkhyjkbn() {
        return ifeTssaihkhyjkbn;
    }

    public void setIfeTssaihkhyjkbn(String pIfeTssaihkhyjkbn) {
        ifeTssaihkhyjkbn = pIfeTssaihkhyjkbn;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
