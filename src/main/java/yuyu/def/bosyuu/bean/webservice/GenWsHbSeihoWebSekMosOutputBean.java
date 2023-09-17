package yuyu.def.bosyuu.bean.webservice;

import java.io.Serializable;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.file.description.annotations.MultiByte;
import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.validation.constraints.RangeBizCalcable;

/**
 * （保険募集）生保Ｗｅｂ設計書申込書作成出力BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenWsHbSeihoWebSekMosOutputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenWsHbSeihoWebSekMosOutputBean() {
    }

    @Column(order = 1, length = 1)
    private String iwsSekmossakuseierroutkbn;

    public String getIwsSekmossakuseierroutkbn() {
        return iwsSekmossakuseierroutkbn;
    }

    public void setIwsSekmossakuseierroutkbn(String pIwsSekmossakuseierroutkbn) {
        iwsSekmossakuseierroutkbn = pIwsSekmossakuseierroutkbn;
    }

    @Column(order = 2, length = 40)
    @MultiByte
    private String iwsSekmoserrormsg1;

    public String getIwsSekmoserrormsg1() {
        return iwsSekmoserrormsg1;
    }

    public void setIwsSekmoserrormsg1(String pIwsSekmoserrormsg1) {
        iwsSekmoserrormsg1 = pIwsSekmoserrormsg1;
    }

    @Column(order = 3, length = 40)
    @MultiByte
    private String iwsSekmoserrormsg2;

    public String getIwsSekmoserrormsg2() {
        return iwsSekmoserrormsg2;
    }

    public void setIwsSekmoserrormsg2(String pIwsSekmoserrormsg2) {
        iwsSekmoserrormsg2 = pIwsSekmoserrormsg2;
    }

    @Column(order = 4, length = 8)
    private BizDate iwsYoteikykymd;

    public BizDate getIwsYoteikykymd() {
        return iwsYoteikykymd;
    }

    public void setIwsYoteikykymd(BizDate pIwsYoteikykymd) {
        iwsYoteikykymd = pIwsYoteikykymd;
    }

    @Column(order = 5, length = 8)
    private BizDate iwsDairitensekykkigenymd;

    public BizDate getIwsDairitensekykkigenymd() {
        return iwsDairitensekykkigenymd;
    }

    public void setIwsDairitensekykkigenymd(BizDate pIwsDairitensekykkigenymd) {
        iwsDairitensekykkigenymd = pIwsDairitensekykkigenymd;
    }

    @Column(order = 6, length = 3)
    private BizNumber iwsHhknnen;

    public BizNumber getIwsHhknnen() {
        return iwsHhknnen;
    }

    public void setIwsHhknnen(BizNumber pIwsHhknnen) {
        iwsHhknnen = pIwsHhknnen;
    }

    @Column(order = 7, length = 9)
    @RangeBizCalcable(min="0", max="999999999")
    private BizNumber iwsSbs;

    public BizNumber getIwsSbs() {
        return iwsSbs;
    }

    public void setIwsSbs(BizNumber pIwsSbs) {
        iwsSbs = pIwsSbs;
    }

    @Column(order = 8, length = 13)
    @RangeBizCalcable(min="0", max="9999999999999")
    private BizNumber iwsGaikasbs;

    public BizNumber getIwsGaikasbs() {
        return iwsGaikasbs;
    }

    public void setIwsGaikasbs(BizNumber pIwsGaikasbs) {
        iwsGaikasbs = pIwsGaikasbs;
    }

    @Column(order = 9, length = 9)
    @RangeBizCalcable(min="0", max="999999999")
    private BizNumber iwsKihons;

    public BizNumber getIwsKihons() {
        return iwsKihons;
    }

    public void setIwsKihons(BizNumber pIwsKihons) {
        iwsKihons = pIwsKihons;
    }

    @Column(order = 10, length = 13)
    @RangeBizCalcable(min="0", max="9999999999999")
    private BizNumber iwsGaikakihons;

    public BizNumber getIwsGaikakihons() {
        return iwsGaikakihons;
    }

    public void setIwsGaikakihons(BizNumber pIwsGaikakihons) {
        iwsGaikakihons = pIwsGaikakihons;
    }

    @Column(order = 11, length = 10)
    @RangeBizCalcable(min="0", max="9999999999")
    private BizNumber iwsSyupn;

    public BizNumber getIwsSyupn() {
        return iwsSyupn;
    }

    public void setIwsSyupn(BizNumber pIwsSyupn) {
        iwsSyupn = pIwsSyupn;
    }

    @Column(order = 12, length = 13)
    @RangeBizCalcable(min="0", max="9999999999999")
    private BizNumber iwsGaikasyup;

    public BizNumber getIwsGaikasyup() {
        return iwsGaikasyup;
    }

    public void setIwsGaikasyup(BizNumber pIwsGaikasyup) {
        iwsGaikasyup = pIwsGaikasyup;
    }

    @Column(order = 13, length = 10)
    @RangeBizCalcable(min="0", max="9999999999")
    private BizNumber iwsSyokaiharaikomip;

    public BizNumber getIwsSyokaiharaikomip() {
        return iwsSyokaiharaikomip;
    }

    public void setIwsSyokaiharaikomip(BizNumber pIwsSyokaiharaikomip) {
        iwsSyokaiharaikomip = pIwsSyokaiharaikomip;
    }

    @Column(order = 14, length = 13)
    @RangeBizCalcable(min="0", max="9999999999999")
    private BizNumber iwsGaikasyokaiharaikomip;

    public BizNumber getIwsGaikasyokaiharaikomip() {
        return iwsGaikasyokaiharaikomip;
    }

    public void setIwsGaikasyokaiharaikomip(BizNumber pIwsGaikasyokaiharaikomip) {
        iwsGaikasyokaiharaikomip = pIwsGaikasyokaiharaikomip;
    }

    @Column(order = 15, length = 10)
    @RangeBizCalcable(min="0", max="9999999999")
    private BizNumber iwsNextharaikomip;

    public BizNumber getIwsNextharaikomip() {
        return iwsNextharaikomip;
    }

    public void setIwsNextharaikomip(BizNumber pIwsNextharaikomip) {
        iwsNextharaikomip = pIwsNextharaikomip;
    }

    @Column(order = 16, length = 13)
    @RangeBizCalcable(min="0", max="9999999999999")
    private BizNumber iwsGaikanextharaikomip;

    public BizNumber getIwsGaikanextharaikomip() {
        return iwsGaikanextharaikomip;
    }

    public void setIwsGaikanextharaikomip(BizNumber pIwsGaikanextharaikomip) {
        iwsGaikanextharaikomip = pIwsGaikanextharaikomip;
    }

    @Column(order = 17, length = 10)
    @RangeBizCalcable(min="0", max="9999999999")
    private BizNumber iwsHrktuukasyukykp;

    public BizNumber getIwsHrktuukasyukykp() {
        return iwsHrktuukasyukykp;
    }

    public void setIwsHrktuukasyukykp(BizNumber pIwsHrktuukasyukykp) {
        iwsHrktuukasyukykp = pIwsHrktuukasyukykp;
    }

    @Column(order = 18, length = 13)
    @RangeBizCalcable(min="0", max="9999999999999")
    private BizNumber iwsGaikahrktuukasyukykp;

    public BizNumber getIwsGaikahrktuukasyukykp() {
        return iwsGaikahrktuukasyukykp;
    }

    public void setIwsGaikahrktuukasyukykp(BizNumber pIwsGaikahrktuukasyukykp) {
        iwsGaikahrktuukasyukykp = pIwsGaikahrktuukasyukykp;
    }

    @Column(order = 19, length = 10)
    @RangeBizCalcable(min="0", max="9999999999")
    private BizNumber iwsHrktuukasyokaihrkp;

    public BizNumber getIwsHrktuukasyokaihrkp() {
        return iwsHrktuukasyokaihrkp;
    }

    public void setIwsHrktuukasyokaihrkp(BizNumber pIwsHrktuukasyokaihrkp) {
        iwsHrktuukasyokaihrkp = pIwsHrktuukasyokaihrkp;
    }

    @Column(order = 20, length = 13)
    @RangeBizCalcable(min="0", max="9999999999999")
    private BizNumber iwsGaikahrktuukasyokaihrkp;

    public BizNumber getIwsGaikahrktuukasyokaihrkp() {
        return iwsGaikahrktuukasyokaihrkp;
    }

    public void setIwsGaikahrktuukasyokaihrkp(BizNumber pIwsGaikahrktuukasyokaihrkp) {
        iwsGaikahrktuukasyokaihrkp = pIwsGaikahrktuukasyokaihrkp;
    }

    @Column(order = 21, length = 10)
    @RangeBizCalcable(min="0", max="9999999999")
    private BizNumber iwsHrktuukanexthrkp;

    public BizNumber getIwsHrktuukanexthrkp() {
        return iwsHrktuukanexthrkp;
    }

    public void setIwsHrktuukanexthrkp(BizNumber pIwsHrktuukanexthrkp) {
        iwsHrktuukanexthrkp = pIwsHrktuukanexthrkp;
    }

    @Column(order = 22, length = 13)
    @RangeBizCalcable(min="0", max="9999999999999")
    private BizNumber iwsGaikahrktuukanexthrkp;

    public BizNumber getIwsGaikahrktuukanexthrkp() {
        return iwsGaikahrktuukanexthrkp;
    }

    public void setIwsGaikahrktuukanexthrkp(BizNumber pIwsGaikahrktuukanexthrkp) {
        iwsGaikahrktuukanexthrkp = pIwsGaikahrktuukanexthrkp;
    }

    @Column(order = 23, length = 10)
    @RangeBizCalcable(min="0", max="9999999999")
    private BizNumber iwsikkatup;

    public BizNumber getIwsikkatup() {
        return iwsikkatup;
    }

    public void setIwsikkatup(BizNumber pIwsikkatup) {
        iwsikkatup = pIwsikkatup;
    }

    @Column(order = 24, length = 10)
    @RangeBizCalcable(min="0", max="9999999999")
    private BizNumber iwsZennoup;

    public BizNumber getIwsZennoup() {
        return iwsZennoup;
    }

    public void setIwsZennoup(BizNumber pIwsZennoup) {
        iwsZennoup = pIwsZennoup;
    }

    @Column(order = 25, length = 13)
    @RangeBizCalcable(min="0", max="9999999999999")
    private BizNumber iwsGaikazennoup;

    public BizNumber getIwsGaikazennoup() {
        return iwsGaikazennoup;
    }

    public void setIwsGaikazennoup(BizNumber pIwsGaikazennoup) {
        iwsGaikazennoup = pIwsGaikazennoup;
    }

    @Column(order = 26, length = 10)
    @RangeBizCalcable(min="0", max="9999999999")
    private BizNumber iwsTargetyenknsnp;

    public BizNumber getIwsTargetyenknsnp() {
        return iwsTargetyenknsnp;
    }

    public void setIwsTargetyenknsnp(BizNumber pIwsTargetyenknsnp) {
        iwsTargetyenknsnp = pIwsTargetyenknsnp;
    }

    @Column(order = 27, length = 10)
    @RangeBizCalcable(min="0", max="9999999999")
    private BizNumber iwsTargettokuyakumkhgk;

    public BizNumber getIwsTargettokuyakumkhgk() {
        return iwsTargettokuyakumkhgk;
    }

    public void setIwsTargettokuyakumkhgk(BizNumber pIwsTargettokuyakumkhgk) {
        iwsTargettokuyakumkhgk = pIwsTargettokuyakumkhgk;
    }

    @Column(order = 28, length = 4)
    private BizNumber iwsHendouknrtumitateriritu;

    public BizNumber getIwsHendouknrtumitateriritu() {
        return iwsHendouknrtumitateriritu;
    }

    public void setIwsHendouknrtumitateriritu(BizNumber pIwsHendouknrtumitateriritu) {
        iwsHendouknrtumitateriritu = pIwsHendouknrtumitateriritu;
    }

    @Column(order = 29, length = 1)
    private BizNumber iwsSjkkktyusirrtfgu;

    public BizNumber getIwsSjkkktyusirrtfgu() {
        return iwsSjkkktyusirrtfgu;
    }

    public void setIwsSjkkktyusirrtfgu(BizNumber pIwsSjkkktyusirrtfgu) {
        iwsSjkkktyusirrtfgu = pIwsSjkkktyusirrtfgu;
    }

    @Column(order = 30, length = 4)
    private BizNumber iwsSjkkktyouseiriritu;

    public BizNumber getIwsSjkkktyouseiriritu() {
        return iwsSjkkktyouseiriritu;
    }

    public void setIwsSjkkktyouseiriritu(BizNumber pIwsSjkkktyouseiriritu) {
        iwsSjkkktyouseiriritu = pIwsSjkkktyouseiriritu;
    }

    @Column(order = 31, length = 13)
    private String iwsBsyutrkno;

    public String getIwsBsyutrkno() {
        return iwsBsyutrkno;
    }

    public void setIwsBsyutrkno(String pIwsBsyutrkno) {
        iwsBsyutrkno = pIwsBsyutrkno;
    }

    @Column(order = 32, length = 15)
    @MultiByte
    private String iwsDirtnbosyuuninkanji;

    public String getIwsDirtnbosyuuninkanji() {
        return iwsDirtnbosyuuninkanji;
    }

    public void setIwsDirtnbosyuuninkanji(String pIwsDirtnbosyuuninkanji) {
        iwsDirtnbosyuuninkanji = pIwsDirtnbosyuuninkanji;
    }

    @Column(order = 33, length = 20)
    @MultiByte
    private String iwsBosyuudairitennm;

    public String getIwsBosyuudairitennm() {
        return iwsBosyuudairitennm;
    }

    public void setIwsBosyuudairitennm(String pIwsBosyuudairitennm) {
        iwsBosyuudairitennm = pIwsBosyuudairitennm;
    }

    @Column(order = 34, length = 4)
    private String iwsKinyuukikancd;

    public String getIwsKinyuukikancd() {
        return iwsKinyuukikancd;
    }

    public void setIwsKinyuukikancd(String pIwsKinyuukikancd) {
        iwsKinyuukikancd = pIwsKinyuukikancd;
    }

    @Column(order = 35, length = 7)
    private String iwsTsrycd;

    public String getIwsTsrycd() {
        return iwsTsrycd;
    }

    public void setIwsTsrycd(String pIwsTsrycd) {
        iwsTsrycd = pIwsTsrycd;
    }

    @Column(order = 36, length = 2)
    @RangeBizCalcable(min="0", max="99")
    private BizNumber iwsDrtentsryshrkaisuu;

    public BizNumber getIwsDrtentsryshrkaisuu() {
        return iwsDrtentsryshrkaisuu;
    }

    public void setIwsDrtentsryshrkaisuu(BizNumber pIwsDrtentsryshrkaisuu) {
        iwsDrtentsryshrkaisuu = pIwsDrtentsryshrkaisuu;
    }

    @Column(order = 37, length = 9)
    @RangeBizCalcable(min="0", max="999999999")
    private BizNumber iwsDrtenshrfsttsry;

    public BizNumber getIwsDrtenshrfsttsry() {
        return iwsDrtenshrfsttsry;
    }

    public void setIwsDrtenshrfsttsry(BizNumber pIwsDrtenshrfsttsry) {
        iwsDrtenshrfsttsry = pIwsDrtenshrfsttsry;
    }

    @Column(order = 38, length = 13)
    @RangeBizCalcable(min="0", max="9999999999999")
    private BizNumber iwsGaikadrtenshrfsttsry;

    public BizNumber getIwsGaikadrtenshrfsttsry() {
        return iwsGaikadrtenshrfsttsry;
    }

    public void setIwsGaikadrtenshrfsttsry(BizNumber pIwsGaikadrtenshrfsttsry) {
        iwsGaikadrtenshrfsttsry = pIwsGaikadrtenshrfsttsry;
    }

    @Column(order = 39, length = 1)
    private String iwsGkdrtenshrfsttsrytukkbn;

    public String getIwsGkdrtenshrfsttsrytukkbn() {
        return iwsGkdrtenshrfsttsrytukkbn;
    }

    public void setIwsGkdrtenshrfsttsrytukkbn(String pIwsGkdrtenshrfsttsrytukkbn) {
        iwsGkdrtenshrfsttsrytukkbn = pIwsGkdrtenshrfsttsrytukkbn;
    }

    @Column(order = 40, length = 9)
    @RangeBizCalcable(min="0", max="999999999")
    private BizNumber iwsDrtenshrkztsry;

    public BizNumber getIwsDrtenshrkztsry() {
        return iwsDrtenshrkztsry;
    }

    public void setIwsDrtenshrkztsry(BizNumber pIwsDrtenshrkztsry) {
        iwsDrtenshrkztsry = pIwsDrtenshrkztsry;
    }

    @Column(order = 41, length = 13)
    @RangeBizCalcable(min="0", max="9999999999999")
    private BizNumber iwsGaikadrtenshrkztsry;

    public BizNumber getIwsGaikadrtenshrkztsry() {
        return iwsGaikadrtenshrkztsry;
    }

    public void setIwsGaikadrtenshrkztsry(BizNumber pIwsGaikadrtenshrkztsry) {
        iwsGaikadrtenshrkztsry = pIwsGaikadrtenshrkztsry;
    }

    @Column(order = 42, length = 1)
    private String iwsGkdrtenshrkztsrytukkbn;

    public String getIwsGkdrtenshrkztsrytukkbn() {
        return iwsGkdrtenshrkztsrytukkbn;
    }

    public void setIwsGkdrtenshrkztsrytukkbn(String pIwsGkdrtenshrkztsrytukkbn) {
        iwsGkdrtenshrkztsrytukkbn = pIwsGkdrtenshrkztsrytukkbn;
    }

    @Column(order = 43, length = 11)
    @RangeBizCalcable(min="0", max="99999999999")
    private BizNumber iwsSyotsryruigkn;

    public BizNumber getIwsSyotsryruigkn() {
        return iwsSyotsryruigkn;
    }

    public void setIwsSyotsryruigkn(BizNumber pIwsSyotsryruigkn) {
        iwsSyotsryruigkn = pIwsSyotsryruigkn;
    }

    @Column(order = 44, length = 13)
    @RangeBizCalcable(min="0", max="9999999999999")
    private BizNumber iwsGaikasyotsryruigk;

    public BizNumber getIwsGaikasyotsryruigk() {
        return iwsGaikasyotsryruigk;
    }

    public void setIwsGaikasyotsryruigk(BizNumber pIwsGaikasyotsryruigk) {
        iwsGaikasyotsryruigk = pIwsGaikasyotsryruigk;
    }

    @Column(order = 45, length = 1)
    private String iwsGaikasyotsrytuukakbn;

    public String getIwsGaikasyotsrytuukakbn() {
        return iwsGaikasyotsrytuukakbn;
    }

    public void setIwsGaikasyotsrytuukakbn(String pIwsGaikasyotsrytuukakbn) {
        iwsGaikasyotsrytuukakbn = pIwsGaikasyotsrytuukakbn;
    }

    @Column(order = 46, length = 11)
    @RangeBizCalcable(min="0", max="99999999999")
    private BizNumber iwsNitsryruigkn;

    public BizNumber getIwsNitsryruigkn() {
        return iwsNitsryruigkn;
    }

    public void setIwsNitsryruigkn(BizNumber pIwsNitsryruigkn) {
        iwsNitsryruigkn = pIwsNitsryruigkn;
    }

    @Column(order = 47, length = 13)
    @RangeBizCalcable(min="0", max="9999999999999")
    private BizNumber iwsGaikanitsryruigkn;

    public BizNumber getIwsGaikanitsryruigkn() {
        return iwsGaikanitsryruigkn;
    }

    public void setIwsGaikanitsryruigkn(BizNumber pIwsGaikanitsryruigkn) {
        iwsGaikanitsryruigkn = pIwsGaikanitsryruigkn;
    }

    @Column(order = 48, length = 1)
    private String iwsGaikanitsrytuukakbn;

    public String getIwsGaikanitsrytuukakbn() {
        return iwsGaikanitsrytuukakbn;
    }

    public void setIwsGaikanitsrytuukakbn(String pIwsGaikanitsrytuukakbn) {
        iwsGaikanitsrytuukakbn = pIwsGaikanitsrytuukakbn;
    }

    @Column(order = 49, length = 11)
    @RangeBizCalcable(min="0", max="99999999999")
    private BizNumber iwsSougktsryn;

    public BizNumber getIwsSougktsryn() {
        return iwsSougktsryn;
    }

    public void setIwsSougktsryn(BizNumber pIwsSougktsryn) {
        iwsSougktsryn = pIwsSougktsryn;
    }

    @Column(order = 50, length = 13)
    @RangeBizCalcable(min="0", max="9999999999999")
    private BizNumber iwsGaikasougktsry;

    public BizNumber getIwsGaikasougktsry() {
        return iwsGaikasougktsry;
    }

    public void setIwsGaikasougktsry(BizNumber pIwsGaikasougktsry) {
        iwsGaikasougktsry = pIwsGaikasougktsry;
    }

    @Column(order = 51, length = 1)
    private String iwsGaikasougktsrytuukakbn;

    public String getIwsGaikasougktsrytuukakbn() {
        return iwsGaikasougktsrytuukakbn;
    }

    public void setIwsGaikasougktsrytuukakbn(String pIwsGaikasougktsrytuukakbn) {
        iwsGaikasougktsrytuukakbn = pIwsGaikasougktsrytuukakbn;
    }

    @Column(order = 52, length = 4)
    private String iwsHtysyoruicd01;

    public String getIwsHtysyoruicd01() {
        return iwsHtysyoruicd01;
    }

    public void setIwsHtysyoruicd01(String pIwsHtysyoruicd01) {
        iwsHtysyoruicd01 = pIwsHtysyoruicd01;
    }

    @Column(order = 53, length = 4)
    private String iwsHtysyoruicd02;

    public String getIwsHtysyoruicd02() {
        return iwsHtysyoruicd02;
    }

    public void setIwsHtysyoruicd02(String pIwsHtysyoruicd02) {
        iwsHtysyoruicd02 = pIwsHtysyoruicd02;
    }

    @Column(order = 54, length = 4)
    private String iwsHtysyoruicd03;

    public String getIwsHtysyoruicd03() {
        return iwsHtysyoruicd03;
    }

    public void setIwsHtysyoruicd03(String pIwsHtysyoruicd03) {
        iwsHtysyoruicd03 = pIwsHtysyoruicd03;
    }

    @Column(order = 55, length = 4)
    private String iwsHtysyoruicd04;

    public String getIwsHtysyoruicd04() {
        return iwsHtysyoruicd04;
    }

    public void setIwsHtysyoruicd04(String pIwsHtysyoruicd04) {
        iwsHtysyoruicd04 = pIwsHtysyoruicd04;
    }

    @Column(order = 56, length = 4)
    private String iwsHtysyoruicd05;

    public String getIwsHtysyoruicd05() {
        return iwsHtysyoruicd05;
    }

    public void setIwsHtysyoruicd05(String pIwsHtysyoruicd05) {
        iwsHtysyoruicd05 = pIwsHtysyoruicd05;
    }

    @Column(order = 57, length = 4)
    private String iwsHtysyoruicd06;

    public String getIwsHtysyoruicd06() {
        return iwsHtysyoruicd06;
    }

    public void setIwsHtysyoruicd06(String pIwsHtysyoruicd06) {
        iwsHtysyoruicd06 = pIwsHtysyoruicd06;
    }

    @Column(order = 58, length = 4)
    private String iwsHtysyoruicd07;

    public String getIwsHtysyoruicd07() {
        return iwsHtysyoruicd07;
    }

    public void setIwsHtysyoruicd07(String pIwsHtysyoruicd07) {
        iwsHtysyoruicd07 = pIwsHtysyoruicd07;
    }

    @Column(order = 59, length = 4)
    private String iwsHtysyoruicd08;

    public String getIwsHtysyoruicd08() {
        return iwsHtysyoruicd08;
    }

    public void setIwsHtysyoruicd08(String pIwsHtysyoruicd08) {
        iwsHtysyoruicd08 = pIwsHtysyoruicd08;
    }

    @Column(order = 60, length = 4)
    private String iwsHtysyoruicd09;

    public String getIwsHtysyoruicd09() {
        return iwsHtysyoruicd09;
    }

    public void setIwsHtysyoruicd09(String pIwsHtysyoruicd09) {
        iwsHtysyoruicd09 = pIwsHtysyoruicd09;
    }

    @Column(order = 61, length = 4)
    private String iwsHtysyoruicd10;

    public String getIwsHtysyoruicd10() {
        return iwsHtysyoruicd10;
    }

    public void setIwsHtysyoruicd10(String pIwsHtysyoruicd10) {
        iwsHtysyoruicd10 = pIwsHtysyoruicd10;
    }

    @Column(order = 62, length = 4)
    private String iwsHtysyoruicd11;

    public String getIwsHtysyoruicd11() {
        return iwsHtysyoruicd11;
    }

    public void setIwsHtysyoruicd11(String pIwsHtysyoruicd11) {
        iwsHtysyoruicd11 = pIwsHtysyoruicd11;
    }

    @Column(order = 63, length = 4)
    private String iwsHtysyoruicd12;

    public String getIwsHtysyoruicd12() {
        return iwsHtysyoruicd12;
    }

    public void setIwsHtysyoruicd12(String pIwsHtysyoruicd12) {
        iwsHtysyoruicd12 = pIwsHtysyoruicd12;
    }

    @Column(order = 64, length = 4)
    private String iwsHtysyoruicd13;

    public String getIwsHtysyoruicd13() {
        return iwsHtysyoruicd13;
    }

    public void setIwsHtysyoruicd13(String pIwsHtysyoruicd13) {
        iwsHtysyoruicd13 = pIwsHtysyoruicd13;
    }

    @Column(order = 65, length = 4)
    private String iwsHtysyoruicd14;

    public String getIwsHtysyoruicd14() {
        return iwsHtysyoruicd14;
    }

    public void setIwsHtysyoruicd14(String pIwsHtysyoruicd14) {
        iwsHtysyoruicd14 = pIwsHtysyoruicd14;
    }

    @Column(order = 66, length = 4)
    private String iwsHtysyoruicd15;

    public String getIwsHtysyoruicd15() {
        return iwsHtysyoruicd15;
    }

    public void setIwsHtysyoruicd15(String pIwsHtysyoruicd15) {
        iwsHtysyoruicd15 = pIwsHtysyoruicd15;
    }

    @Column(order = 67, length = 4)
    private String iwsHtysyoruicd16;

    public String getIwsHtysyoruicd16() {
        return iwsHtysyoruicd16;
    }

    public void setIwsHtysyoruicd16(String pIwsHtysyoruicd16) {
        iwsHtysyoruicd16 = pIwsHtysyoruicd16;
    }

    @Column(order = 68, length = 4)
    private String iwsHtysyoruicd17;

    public String getIwsHtysyoruicd17() {
        return iwsHtysyoruicd17;
    }

    public void setIwsHtysyoruicd17(String pIwsHtysyoruicd17) {
        iwsHtysyoruicd17 = pIwsHtysyoruicd17;
    }

    @Column(order = 69, length = 4)
    private String iwsHtysyoruicd18;

    public String getIwsHtysyoruicd18() {
        return iwsHtysyoruicd18;
    }

    public void setIwsHtysyoruicd18(String pIwsHtysyoruicd18) {
        iwsHtysyoruicd18 = pIwsHtysyoruicd18;
    }

    @Column(order = 70, length = 4)
    private String iwsHtysyoruicd19;

    public String getIwsHtysyoruicd19() {
        return iwsHtysyoruicd19;
    }

    public void setIwsHtysyoruicd19(String pIwsHtysyoruicd19) {
        iwsHtysyoruicd19 = pIwsHtysyoruicd19;
    }

    @Column(order = 71, length = 4)
    private String iwsHtysyoruicd20;

    public String getIwsHtysyoruicd20() {
        return iwsHtysyoruicd20;
    }

    public void setIwsHtysyoruicd20(String pIwsHtysyoruicd20) {
        iwsHtysyoruicd20 = pIwsHtysyoruicd20;
    }

    @Column(order = 72, length = 4)
    private String iwsHtysyoruicd21;

    public String getIwsHtysyoruicd21() {
        return iwsHtysyoruicd21;
    }

    public void setIwsHtysyoruicd21(String pIwsHtysyoruicd21) {
        iwsHtysyoruicd21 = pIwsHtysyoruicd21;
    }

    @Column(order = 73, length = 4)
    private String iwsHtysyoruicd22;

    public String getIwsHtysyoruicd22() {
        return iwsHtysyoruicd22;
    }

    public void setIwsHtysyoruicd22(String pIwsHtysyoruicd22) {
        iwsHtysyoruicd22 = pIwsHtysyoruicd22;
    }

    @Column(order = 74, length = 4)
    private String iwsHtysyoruicd23;

    public String getIwsHtysyoruicd23() {
        return iwsHtysyoruicd23;
    }

    public void setIwsHtysyoruicd23(String pIwsHtysyoruicd23) {
        iwsHtysyoruicd23 = pIwsHtysyoruicd23;
    }

    @Column(order = 75, length = 4)
    private String iwsHtysyoruicd24;

    public String getIwsHtysyoruicd24() {
        return iwsHtysyoruicd24;
    }

    public void setIwsHtysyoruicd24(String pIwsHtysyoruicd24) {
        iwsHtysyoruicd24 = pIwsHtysyoruicd24;
    }

    @Column(order = 76, length = 4)
    private String iwsHtysyoruicd25;

    public String getIwsHtysyoruicd25() {
        return iwsHtysyoruicd25;
    }

    public void setIwsHtysyoruicd25(String pIwsHtysyoruicd25) {
        iwsHtysyoruicd25 = pIwsHtysyoruicd25;
    }

    @Column(order = 77, length = 4)
    private String iwsHtysyoruicd26;

    public String getIwsHtysyoruicd26() {
        return iwsHtysyoruicd26;
    }

    public void setIwsHtysyoruicd26(String pIwsHtysyoruicd26) {
        iwsHtysyoruicd26 = pIwsHtysyoruicd26;
    }

    @Column(order = 78, length = 4)
    private String iwsHtysyoruicd27;

    public String getIwsHtysyoruicd27() {
        return iwsHtysyoruicd27;
    }

    public void setIwsHtysyoruicd27(String pIwsHtysyoruicd27) {
        iwsHtysyoruicd27 = pIwsHtysyoruicd27;
    }

    @Column(order = 79, length = 4)
    private String iwsHtysyoruicd28;

    public String getIwsHtysyoruicd28() {
        return iwsHtysyoruicd28;
    }

    public void setIwsHtysyoruicd28(String pIwsHtysyoruicd28) {
        iwsHtysyoruicd28 = pIwsHtysyoruicd28;
    }

    @Column(order = 80, length = 4)
    private String iwsHtysyoruicd29;

    public String getIwsHtysyoruicd29() {
        return iwsHtysyoruicd29;
    }

    public void setIwsHtysyoruicd29(String pIwsHtysyoruicd29) {
        iwsHtysyoruicd29 = pIwsHtysyoruicd29;
    }

    @Column(order = 81, length = 4)
    private String iwsHtysyoruicd30;

    public String getIwsHtysyoruicd30() {
        return iwsHtysyoruicd30;
    }

    public void setIwsHtysyoruicd30(String pIwsHtysyoruicd30) {
        iwsHtysyoruicd30 = pIwsHtysyoruicd30;
    }

    @Column(order = 82, length = 4)
    private String iwsHtysyoruicd31;

    public String getIwsHtysyoruicd31() {
        return iwsHtysyoruicd31;
    }

    public void setIwsHtysyoruicd31(String pIwsHtysyoruicd31) {
        iwsHtysyoruicd31 = pIwsHtysyoruicd31;
    }

    @Column(order = 83, length = 4)
    private String iwsHtysyoruicd32;

    public String getIwsHtysyoruicd32() {
        return iwsHtysyoruicd32;
    }

    public void setIwsHtysyoruicd32(String pIwsHtysyoruicd32) {
        iwsHtysyoruicd32 = pIwsHtysyoruicd32;
    }

    @Column(order = 84, length = 4)
    private String iwsHtysyoruicd33;

    public String getIwsHtysyoruicd33() {
        return iwsHtysyoruicd33;
    }

    public void setIwsHtysyoruicd33(String pIwsHtysyoruicd33) {
        iwsHtysyoruicd33 = pIwsHtysyoruicd33;
    }

    @Column(order = 85, length = 4)
    private String iwsHtysyoruicd34;

    public String getIwsHtysyoruicd34() {
        return iwsHtysyoruicd34;
    }

    public void setIwsHtysyoruicd34(String pIwsHtysyoruicd34) {
        iwsHtysyoruicd34 = pIwsHtysyoruicd34;
    }

    @Column(order = 86, length = 4)
    private String iwsHtysyoruicd35;

    public String getIwsHtysyoruicd35() {
        return iwsHtysyoruicd35;
    }

    public void setIwsHtysyoruicd35(String pIwsHtysyoruicd35) {
        iwsHtysyoruicd35 = pIwsHtysyoruicd35;
    }

    @Column(order = 87, length = 4)
    private String iwsHtysyoruicd36;

    public String getIwsHtysyoruicd36() {
        return iwsHtysyoruicd36;
    }

    public void setIwsHtysyoruicd36(String pIwsHtysyoruicd36) {
        iwsHtysyoruicd36 = pIwsHtysyoruicd36;
    }

    @Column(order = 88, length = 4)
    private String iwsHtysyoruicd37;

    public String getIwsHtysyoruicd37() {
        return iwsHtysyoruicd37;
    }

    public void setIwsHtysyoruicd37(String pIwsHtysyoruicd37) {
        iwsHtysyoruicd37 = pIwsHtysyoruicd37;
    }

    @Column(order = 89, length = 4)
    private String iwsHtysyoruicd38;

    public String getIwsHtysyoruicd38() {
        return iwsHtysyoruicd38;
    }

    public void setIwsHtysyoruicd38(String pIwsHtysyoruicd38) {
        iwsHtysyoruicd38 = pIwsHtysyoruicd38;
    }

    @Column(order = 90, length = 4)
    private String iwsHtysyoruicd39;

    public String getIwsHtysyoruicd39() {
        return iwsHtysyoruicd39;
    }

    public void setIwsHtysyoruicd39(String pIwsHtysyoruicd39) {
        iwsHtysyoruicd39 = pIwsHtysyoruicd39;
    }

    @Column(order = 91, length = 4)
    private String iwsHtysyoruicd40;

    public String getIwsHtysyoruicd40() {
        return iwsHtysyoruicd40;
    }

    public void setIwsHtysyoruicd40(String pIwsHtysyoruicd40) {
        iwsHtysyoruicd40 = pIwsHtysyoruicd40;
    }

    @Column(order = 92, length = 4)
    private String iwsHtysyoruicd41;

    public String getIwsHtysyoruicd41() {
        return iwsHtysyoruicd41;
    }

    public void setIwsHtysyoruicd41(String pIwsHtysyoruicd41) {
        iwsHtysyoruicd41 = pIwsHtysyoruicd41;
    }

    @Column(order = 93, length = 4)
    private String iwsHtysyoruicd42;

    public String getIwsHtysyoruicd42() {
        return iwsHtysyoruicd42;
    }

    public void setIwsHtysyoruicd42(String pIwsHtysyoruicd42) {
        iwsHtysyoruicd42 = pIwsHtysyoruicd42;
    }

    @Column(order = 94, length = 4)
    private String iwsHtysyoruicd43;

    public String getIwsHtysyoruicd43() {
        return iwsHtysyoruicd43;
    }

    public void setIwsHtysyoruicd43(String pIwsHtysyoruicd43) {
        iwsHtysyoruicd43 = pIwsHtysyoruicd43;
    }

    @Column(order = 95, length = 4)
    private String iwsHtysyoruicd44;

    public String getIwsHtysyoruicd44() {
        return iwsHtysyoruicd44;
    }

    public void setIwsHtysyoruicd44(String pIwsHtysyoruicd44) {
        iwsHtysyoruicd44 = pIwsHtysyoruicd44;
    }

    @Column(order = 96, length = 4)
    private String iwsHtysyoruicd45;

    public String getIwsHtysyoruicd45() {
        return iwsHtysyoruicd45;
    }

    public void setIwsHtysyoruicd45(String pIwsHtysyoruicd45) {
        iwsHtysyoruicd45 = pIwsHtysyoruicd45;
    }

    @Column(order = 97, length = 4)
    private String iwsHtysyoruicd46;

    public String getIwsHtysyoruicd46() {
        return iwsHtysyoruicd46;
    }

    public void setIwsHtysyoruicd46(String pIwsHtysyoruicd46) {
        iwsHtysyoruicd46 = pIwsHtysyoruicd46;
    }

    @Column(order = 98, length = 4)
    private String iwsHtysyoruicd47;

    public String getIwsHtysyoruicd47() {
        return iwsHtysyoruicd47;
    }

    public void setIwsHtysyoruicd47(String pIwsHtysyoruicd47) {
        iwsHtysyoruicd47 = pIwsHtysyoruicd47;
    }

    @Column(order = 99, length = 4)
    private String iwsHtysyoruicd48;

    public String getIwsHtysyoruicd48() {
        return iwsHtysyoruicd48;
    }

    public void setIwsHtysyoruicd48(String pIwsHtysyoruicd48) {
        iwsHtysyoruicd48 = pIwsHtysyoruicd48;
    }

    @Column(order = 100, length = 4)
    private String iwsHtysyoruicd49;

    public String getIwsHtysyoruicd49() {
        return iwsHtysyoruicd49;
    }

    public void setIwsHtysyoruicd49(String pIwsHtysyoruicd49) {
        iwsHtysyoruicd49 = pIwsHtysyoruicd49;
    }

    @Column(order = 101, length = 4)
    private String iwsHtysyoruicd50;

    public String getIwsHtysyoruicd50() {
        return iwsHtysyoruicd50;
    }

    public void setIwsHtysyoruicd50(String pIwsHtysyoruicd50) {
        iwsHtysyoruicd50 = pIwsHtysyoruicd50;
    }

    @Column(order = 102, length = 4)
    private String iwsHtysyoruicd51;

    public String getIwsHtysyoruicd51() {
        return iwsHtysyoruicd51;
    }

    public void setIwsHtysyoruicd51(String pIwsHtysyoruicd51) {
        iwsHtysyoruicd51 = pIwsHtysyoruicd51;
    }

    @Column(order = 103, length = 4)
    private String iwsHtysyoruicd52;

    public String getIwsHtysyoruicd52() {
        return iwsHtysyoruicd52;
    }

    public void setIwsHtysyoruicd52(String pIwsHtysyoruicd52) {
        iwsHtysyoruicd52 = pIwsHtysyoruicd52;
    }

    @Column(order = 104, length = 4)
    private String iwsHtysyoruicd53;

    public String getIwsHtysyoruicd53() {
        return iwsHtysyoruicd53;
    }

    public void setIwsHtysyoruicd53(String pIwsHtysyoruicd53) {
        iwsHtysyoruicd53 = pIwsHtysyoruicd53;
    }

    @Column(order = 105, length = 4)
    private String iwsHtysyoruicd54;

    public String getIwsHtysyoruicd54() {
        return iwsHtysyoruicd54;
    }

    public void setIwsHtysyoruicd54(String pIwsHtysyoruicd54) {
        iwsHtysyoruicd54 = pIwsHtysyoruicd54;
    }

    @Column(order = 106, length = 4)
    private String iwsHtysyoruicd55;

    public String getIwsHtysyoruicd55() {
        return iwsHtysyoruicd55;
    }

    public void setIwsHtysyoruicd55(String pIwsHtysyoruicd55) {
        iwsHtysyoruicd55 = pIwsHtysyoruicd55;
    }

    @Column(order = 107, length = 4)
    private String iwsHtysyoruicd56;

    public String getIwsHtysyoruicd56() {
        return iwsHtysyoruicd56;
    }

    public void setIwsHtysyoruicd56(String pIwsHtysyoruicd56) {
        iwsHtysyoruicd56 = pIwsHtysyoruicd56;
    }

    @Column(order = 108, length = 4)
    private String iwsHtysyoruicd57;

    public String getIwsHtysyoruicd57() {
        return iwsHtysyoruicd57;
    }

    public void setIwsHtysyoruicd57(String pIwsHtysyoruicd57) {
        iwsHtysyoruicd57 = pIwsHtysyoruicd57;
    }

    @Column(order = 109, length = 4)
    private String iwsHtysyoruicd58;

    public String getIwsHtysyoruicd58() {
        return iwsHtysyoruicd58;
    }

    public void setIwsHtysyoruicd58(String pIwsHtysyoruicd58) {
        iwsHtysyoruicd58 = pIwsHtysyoruicd58;
    }

    @Column(order = 110, length = 4)
    private String iwsHtysyoruicd59;

    public String getIwsHtysyoruicd59() {
        return iwsHtysyoruicd59;
    }

    public void setIwsHtysyoruicd59(String pIwsHtysyoruicd59) {
        iwsHtysyoruicd59 = pIwsHtysyoruicd59;
    }

    @Column(order = 111, length = 4)
    private String iwsHtysyoruicd60;

    public String getIwsHtysyoruicd60() {
        return iwsHtysyoruicd60;
    }

    public void setIwsHtysyoruicd60(String pIwsHtysyoruicd60) {
        iwsHtysyoruicd60 = pIwsHtysyoruicd60;
    }

    @Column(order = 112, length = 13)
    @RangeBizCalcable(min="0", max="9999999999999")
    private BizNumber iwsGaikasisankihons;

    public BizNumber getIwsGaikasisankihons() {
        return iwsGaikasisankihons;
    }

    public void setIwsGaikasisankihons(BizNumber pIwsGaikasisankihons) {
        iwsGaikasisankihons = pIwsGaikasisankihons;
    }

    @Column(order = 113, length = 1)
    private String iwsKnsnkanouhyj;

    public String getIwsKnsnkanouhyj() {
        return iwsKnsnkanouhyj;
    }

    public void setIwsKnsnkanouhyj(String pIwsKnsnkanouhyj) {
        iwsKnsnkanouhyj = pIwsKnsnkanouhyj;
    }

    @Column(order = 114, length = 1)
    private String iwsNngndkkkanouhyj;

    public String getIwsNngndkkkanouhyj() {
        return iwsNngndkkkanouhyj;
    }

    public void setIwsNngndkkkanouhyj(String pIwsNngndkkkanouhyj) {
        iwsNngndkkkanouhyj = pIwsNngndkkkanouhyj;
    }

    @Column(order = 115, length = 1)
    private String iwsMnstskanouhyj;

    public String getIwsMnstskanouhyj() {
        return iwsMnstskanouhyj;
    }

    public void setIwsMnstskanouhyj(String pIwsMnstskanouhyj) {
        iwsMnstskanouhyj = pIwsMnstskanouhyj;
    }

    @Column(order = 116, length = 1)
    private String iwsSyktkikanouhyj;

    public String getIwsSyktkikanouhyj() {
        return iwsSyktkikanouhyj;
    }

    public void setIwsSyktkikanouhyj(String pIwsSyktkikanouhyj) {
        iwsSyktkikanouhyj = pIwsSyktkikanouhyj;
    }

    @Column(order = 117, length = 1)
    private String iwsSyaikanouhyj;

    public String getIwsSyaikanouhyj() {
        return iwsSyaikanouhyj;
    }

    public void setIwsSyaikanouhyj(String pIwsSyaikanouhyj) {
        iwsSyaikanouhyj = pIwsSyaikanouhyj;
    }

    @Column(order = 118, length = 1)
    private String iwsSndnzknsyouhyj;

    public String getIwsSndnzknsyouhyj() {
        return iwsSndnzknsyouhyj;
    }

    public void setIwsSndnzknsyouhyj(String pIwsSndnzknsyouhyj) {
        iwsSndnzknsyouhyj = pIwsSndnzknsyouhyj;
    }

    @Column(order = 119, length = 1)
    private String iwsKtekknsyouhyj;

    public String getIwsKtekknsyouhyj() {
        return iwsKtekknsyouhyj;
    }

    public void setIwsKtekknsyouhyj(String pIwsKtekknsyouhyj) {
        iwsKtekknsyouhyj = pIwsKtekknsyouhyj;
    }

    @Column(order = 120, length = 1)
    private String iwsKnsnsysndnzyou;

    public String getIwsKnsnsysndnzyou() {
        return iwsKnsnsysndnzyou;
    }

    public void setIwsKnsnsysndnzyou(String pIwsKnsnsysndnzyou) {
        iwsKnsnsysndnzyou = pIwsKnsnsysndnzyou;
    }

    @Column(order = 121, length = 1)
    private String iwsKnsnketuekikensayouhyj;

    public String getIwsKnsnketuekikensayouhyj() {
        return iwsKnsnketuekikensayouhyj;
    }

    public void setIwsKnsnketuekikensayouhyj(String pIwsKnsnketuekikensayouhyj) {
        iwsKnsnketuekikensayouhyj = pIwsKnsnketuekikensayouhyj;
    }

    @Column(order = 122, length = 6)
    private BizNumber iwsYoteijigyouhiritu1;

    public BizNumber getIwsYoteijigyouhiritu1() {
        return iwsYoteijigyouhiritu1;
    }

    public void setIwsYoteijigyouhiritu1(BizNumber pIwsYoteijigyouhiritu1) {
        iwsYoteijigyouhiritu1 = pIwsYoteijigyouhiritu1;
    }

    @Column(order = 123, length = 6)
    private BizNumber iwsYoteijigyouhiritu2;

    public BizNumber getIwsYoteijigyouhiritu2() {
        return iwsYoteijigyouhiritu2;
    }

    public void setIwsYoteijigyouhiritu2(BizNumber pIwsYoteijigyouhiritu2) {
        iwsYoteijigyouhiritu2 = pIwsYoteijigyouhiritu2;
    }

    @Column(order = 124, length = 6)
    private BizNumber iwsYoteijigyouhiritu3;

    public BizNumber getIwsYoteijigyouhiritu3() {
        return iwsYoteijigyouhiritu3;
    }

    public void setIwsYoteijigyouhiritu3(BizNumber pIwsYoteijigyouhiritu3) {
        iwsYoteijigyouhiritu3 = pIwsYoteijigyouhiritu3;
    }

    @Column(order = 125, length = 6)
    private BizNumber iwsYoteijigyouhiritu4;

    public BizNumber getIwsYoteijigyouhiritu4() {
        return iwsYoteijigyouhiritu4;
    }

    public void setIwsYoteijigyouhiritu4(BizNumber pIwsYoteijigyouhiritu4) {
        iwsYoteijigyouhiritu4 = pIwsYoteijigyouhiritu4;
    }

    @Column(order = 126, length = 6)
    private BizNumber iwsYoteijigyouhiritu5;

    public BizNumber getIwsYoteijigyouhiritu5() {
        return iwsYoteijigyouhiritu5;
    }

    public void setIwsYoteijigyouhiritu5(BizNumber pIwsYoteijigyouhiritu5) {
        iwsYoteijigyouhiritu5 = pIwsYoteijigyouhiritu5;
    }

    @Column(order = 127, length = 4)
    private BizNumber iwsTumitateriritu;

    public BizNumber getIwsTumitateriritu() {
        return iwsTumitateriritu;
    }

    public void setIwsTumitateriritu(BizNumber pIwsTumitateriritu) {
        iwsTumitateriritu = pIwsTumitateriritu;
    }

    @Column(order = 128, length = 3)
    private BizNumber iwsSetteibairitu;

    public BizNumber getIwsSetteibairitu() {
        return iwsSetteibairitu;
    }

    public void setIwsSetteibairitu(BizNumber pIwsSetteibairitu) {
        iwsSetteibairitu = pIwsSetteibairitu;
    }

    @Column(order = 129, length = 5)
    private BizNumber iwsTmttknzkrtjygn;

    public BizNumber getIwsTmttknzkrtjygn() {
        return iwsTmttknzkrtjygn;
    }

    public void setIwsTmttknzkrtjygn(BizNumber pIwsTmttknzkrtjygn) {
        iwsTmttknzkrtjygn = pIwsTmttknzkrtjygn;
    }

    @Column(order = 130, length = 1)
    private String iwsNayosehumeikbn;

    public String getIwsNayosehumeikbn() {
        return iwsNayosehumeikbn;
    }

    public void setIwsNayosehumeikbn(String pIwsNayosehumeikbn) {
        iwsNayosehumeikbn = pIwsNayosehumeikbn;
    }

    @Column(order = 131, length = 13)
    @RangeBizCalcable(min="0", max="9999999999999")
    private BizNumber iwsSisuurendoup;

    public BizNumber getIwsSisuurendoup() {
        return iwsSisuurendoup;
    }

    public void setIwsSisuurendoup(BizNumber pIwsSisuurendoup) {
        iwsSisuurendoup = pIwsSisuurendoup;
    }

    @Column(order = 132, length = 13)
    @RangeBizCalcable(min="0", max="9999999999999")
    private BizNumber iwsTeiritutumitatep;

    public BizNumber getIwsTeiritutumitatep() {
        return iwsTeiritutumitatep;
    }

    public void setIwsTeiritutumitatep(BizNumber pIwsTeiritutumitatep) {
        iwsTeiritutumitatep = pIwsTeiritutumitatep;
    }

    @Column(order = 133, length = 1)
    private String iwsPwaribikirankkbn;

    public String getIwsPwaribikirankkbn() {
        return iwsPwaribikirankkbn;
    }

    public void setIwsPwaribikirankkbn(String pIwsPwaribikirankkbn) {
        iwsPwaribikirankkbn = pIwsPwaribikirankkbn;
    }

    @Column(order = 134, length = 4)
    private BizNumber iwsTumitateriritu2;

    public BizNumber getIwsTumitateriritu2() {
        return iwsTumitateriritu2;
    }

    public void setIwsTumitateriritu2(BizNumber pIwsTumitateriritu2) {
        iwsTumitateriritu2 = pIwsTumitateriritu2;
    }

    @Column(order = 135, length = 5)
    private BizNumber iwsRendouritu;

    public BizNumber getIwsRendouritu() {
        return iwsRendouritu;
    }

    public void setIwsRendouritu(BizNumber pIwsRendouritu) {
        iwsRendouritu = pIwsRendouritu;
    }

    @Column(order = 136, length = 13)
    @RangeBizCalcable(min="0", max="9999999999999")
    private BizNumber iwsGaikateikisiharaigk;

    public BizNumber getIwsGaikateikisiharaigk() {
        return iwsGaikateikisiharaigk;
    }

    public void setIwsGaikateikisiharaigk(BizNumber pIwsGaikateikisiharaigk) {
        iwsGaikateikisiharaigk = pIwsGaikateikisiharaigk;
    }

    @Column(order = 137, length = 3)
    private BizNumber iwsZennouwrbkrt;

    public BizNumber getIwsZennouwrbkrt() {
        return iwsZennouwrbkrt;
    }

    public void setIwsZennouwrbkrt(BizNumber pIwsZennouwrbkrt) {
        iwsZennouwrbkrt = pIwsZennouwrbkrt;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
