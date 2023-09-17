package yuyu.def.bosyuu.bean.webservice;

import java.io.Serializable;

import jp.co.slcs.swak.file.description.annotations.MultiByte;
import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * （保険募集）生保Ｗｅｂ申込状況照会出力BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenWsHbSeihoWebMosSyoukaiOutputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenWsHbSeihoWebMosSyoukaiOutputBean() {
    }

    @Column(order = 1, length = 9)
    @MousikomiNo
    private String iwsMosno;

    public String getIwsMosno() {
        return iwsMosno;
    }

    public void setIwsMosno(String pIwsMosno) {
        iwsMosno = pIwsMosno;
    }

    @Column(order = 2, length = 2)
    private String iwsMossyoukaierrkbn;

    public String getIwsMossyoukaierrkbn() {
        return iwsMossyoukaierrkbn;
    }

    public void setIwsMossyoukaierrkbn(String pIwsMossyoukaierrkbn) {
        iwsMossyoukaierrkbn = pIwsMossyoukaierrkbn;
    }

    @Column(order = 3, length = 40)
    @MultiByte
    private String iwsErrormsgv40;

    public String getIwsErrormsgv40() {
        return iwsErrormsgv40;
    }

    public void setIwsErrormsgv40(String pIwsErrormsgv40) {
        iwsErrormsgv40 = pIwsErrormsgv40;
    }

    @Column(order = 4, length = 6)
    @MultiByte
    private String iwsDispmd;

    public String getIwsDispmd() {
        return iwsDispmd;
    }

    public void setIwsDispmd(String pIwsDispmd) {
        iwsDispmd = pIwsDispmd;
    }

    @Column(order = 5, length = 9)
    private String iwsMosjksyoukaimosno;

    public String getIwsMosjksyoukaimosno() {
        return iwsMosjksyoukaimosno;
    }

    public void setIwsMosjksyoukaimosno(String pIwsMosjksyoukaimosno) {
        iwsMosjksyoukaimosno = pIwsMosjksyoukaimosno;
    }

    @Column(order = 6, length = 11)
    private String iwsSksyono;

    public String getIwsSksyono() {
        return iwsSksyono;
    }

    public void setIwsSksyono(String pIwsSksyono) {
        iwsSksyono = pIwsSksyono;
    }

    @Column(order = 7, length = 20)
    @MultiByte
    private String iwsDispbosyuudrtennm;

    public String getIwsDispbosyuudrtennm() {
        return iwsDispbosyuudrtennm;
    }

    public void setIwsDispbosyuudrtennm(String pIwsDispbosyuudrtennm) {
        iwsDispbosyuudrtennm = pIwsDispbosyuudrtennm;
    }

    @Column(order = 8, length = 18)
    @MultiByte
    private String iwsDispbosyuunm;

    public String getIwsDispbosyuunm() {
        return iwsDispbosyuunm;
    }

    public void setIwsDispbosyuunm(String pIwsDispbosyuunm) {
        iwsDispbosyuunm = pIwsDispbosyuunm;
    }

    @Column(order = 9, length = 7)
    @MultiByte
    private String iwsDispbosyuuninmds;

    public String getIwsDispbosyuuninmds() {
        return iwsDispbosyuuninmds;
    }

    public void setIwsDispbosyuuninmds(String pIwsDispbosyuuninmds) {
        iwsDispbosyuuninmds = pIwsDispbosyuuninmds;
    }

    @Column(order = 10, length = 20)
    private String iwsDispbosyuutrknokouincd;

    public String getIwsDispbosyuutrknokouincd() {
        return iwsDispbosyuutrknokouincd;
    }

    public void setIwsDispbosyuutrknokouincd(String pIwsDispbosyuutrknokouincd) {
        iwsDispbosyuutrknokouincd = pIwsDispbosyuutrknokouincd;
    }

    @Column(order = 11, length = 20)
    @MultiByte
    private String iwsDispkydatkidrtennm;

    public String getIwsDispkydatkidrtennm() {
        return iwsDispkydatkidrtennm;
    }

    public void setIwsDispkydatkidrtennm(String pIwsDispkydatkidrtennm) {
        iwsDispkydatkidrtennm = pIwsDispkydatkidrtennm;
    }

    @Column(order = 12, length = 18)
    @MultiByte
    private String iwsDispkydatkibosyuunm;

    public String getIwsDispkydatkibosyuunm() {
        return iwsDispkydatkibosyuunm;
    }

    public void setIwsDispkydatkibosyuunm(String pIwsDispkydatkibosyuunm) {
        iwsDispkydatkibosyuunm = pIwsDispkydatkibosyuunm;
    }

    @Column(order = 13, length = 13)
    private String iwsDispkydatkibosyuutrkno;

    public String getIwsDispkydatkibosyuutrkno() {
        return iwsDispkydatkibosyuutrkno;
    }

    public void setIwsDispkydatkibosyuutrkno(String pIwsDispkydatkibosyuutrkno) {
        iwsDispkydatkibosyuutrkno = pIwsDispkydatkibosyuutrkno;
    }

    @Column(order = 14, length = 6)
    @MultiByte
    private String iwsDispsonotainfomds;

    public String getIwsDispsonotainfomds() {
        return iwsDispsonotainfomds;
    }

    public void setIwsDispsonotainfomds(String pIwsDispsonotainfomds) {
        iwsDispsonotainfomds = pIwsDispsonotainfomds;
    }

    @Column(order = 15, length = 15)
    private String iwsDispcifcduktkid;

    public String getIwsDispcifcduktkid() {
        return iwsDispcifcduktkid;
    }

    public void setIwsDispcifcduktkid(String pIwsDispcifcduktkid) {
        iwsDispcifcduktkid = pIwsDispcifcduktkid;
    }

    @Column(order = 16, length = 11)
    private String iwsDispsekno;

    public String getIwsDispsekno() {
        return iwsDispsekno;
    }

    public void setIwsDispsekno(String pIwsDispsekno) {
        iwsDispsekno = pIwsDispsekno;
    }

    @Column(order = 17, length = 8)
    private String iwsDispykkigenymd;

    public String getIwsDispykkigenymd() {
        return iwsDispykkigenymd;
    }

    public void setIwsDispykkigenymd(String pIwsDispykkigenymd) {
        iwsDispykkigenymd = pIwsDispykkigenymd;
    }

    @Column(order = 18, length = 60)
    @MultiByte
    private String iwsDisphknnm01;

    public String getIwsDisphknnm01() {
        return iwsDisphknnm01;
    }

    public void setIwsDisphknnm01(String pIwsDisphknnm01) {
        iwsDisphknnm01 = pIwsDisphknnm01;
    }

    @Column(order = 19, length = 60)
    @MultiByte
    private String iwsDisphknnm02;

    public String getIwsDisphknnm02() {
        return iwsDisphknnm02;
    }

    public void setIwsDisphknnm02(String pIwsDisphknnm02) {
        iwsDisphknnm02 = pIwsDisphknnm02;
    }

    @Column(order = 20, length = 18)
    private String iwsDispkykknnm;

    public String getIwsDispkykknnm() {
        return iwsDispkykknnm;
    }

    public void setIwsDispkykknnm(String pIwsDispkykknnm) {
        iwsDispkykknnm = pIwsDispkykknnm;
    }

    @Column(order = 21, length = 37)
    @MultiByte
    private String iwsDispkykkjnm;

    public String getIwsDispkykkjnm() {
        return iwsDispkykkjnm;
    }

    public void setIwsDispkykkjnm(String pIwsDispkykkjnm) {
        iwsDispkykkjnm = pIwsDispkykkjnm;
    }

    @Column(order = 22, length = 8)
    @MaxLength(max=8)
    @SingleByteStrings
    private String iwsDispkykseiymd;

    public String getIwsDispkykseiymd() {
        return iwsDispkykseiymd;
    }

    public void setIwsDispkykseiymd(String pIwsDispkykseiymd) {
        iwsDispkykseiymd = pIwsDispkykseiymd;
    }

    @Column(order = 23, length = 2)
    private String iwsDispkyksyanen2keta;

    public String getIwsDispkyksyanen2keta() {
        return iwsDispkyksyanen2keta;
    }

    public void setIwsDispkyksyanen2keta(String pIwsDispkyksyanen2keta) {
        iwsDispkyksyanen2keta = pIwsDispkyksyanen2keta;
    }

    @Column(order = 24, length = 2)
    @MultiByte
    private String iwsDispkyksei;

    public String getIwsDispkyksei() {
        return iwsDispkyksei;
    }

    public void setIwsDispkyksei(String pIwsDispkyksei) {
        iwsDispkyksei = pIwsDispkyksei;
    }

    @Column(order = 25, length = 6)
    @MultiByte
    private String iwsDispkyktdk;

    public String getIwsDispkyktdk() {
        return iwsDispkyktdk;
    }

    public void setIwsDispkyktdk(String pIwsDispkyktdk) {
        iwsDispkyktdk = pIwsDispkyktdk;
    }

    @Column(order = 26, length = 14)
    private String iwsDispkyktelno;

    public String getIwsDispkyktelno() {
        return iwsDispkyktelno;
    }

    public void setIwsDispkyktelno(String pIwsDispkyktelno) {
        iwsDispkyktelno = pIwsDispkyktelno;
    }

    @Column(order = 27, length = 8)
    private String iwsDispkykyno;

    public String getIwsDispkykyno() {
        return iwsDispkykyno;
    }

    public void setIwsDispkykyno(String pIwsDispkykyno) {
        iwsDispkykyno = pIwsDispkykyno;
    }

    @Column(order = 28, length = 62)
    @MultiByte
    private String iwsDispkykadr01;

    public String getIwsDispkykadr01() {
        return iwsDispkykadr01;
    }

    public void setIwsDispkykadr01(String pIwsDispkykadr01) {
        iwsDispkykadr01 = pIwsDispkykadr01;
    }

    @Column(order = 29, length = 62)
    @MultiByte
    private String iwsDispkykadr02;

    public String getIwsDispkykadr02() {
        return iwsDispkykadr02;
    }

    public void setIwsDispkykadr02(String pIwsDispkykadr02) {
        iwsDispkykadr02 = pIwsDispkykadr02;
    }

    @Column(order = 30, length = 18)
    private String iwsDisphhknknnm;

    public String getIwsDisphhknknnm() {
        return iwsDisphhknknnm;
    }

    public void setIwsDisphhknknnm(String pIwsDisphhknknnm) {
        iwsDisphhknknnm = pIwsDisphhknknnm;
    }

    @Column(order = 31, length = 17)
    @MultiByte
    private String iwsDisphhknkjnm;

    public String getIwsDisphhknkjnm() {
        return iwsDisphhknkjnm;
    }

    public void setIwsDisphhknkjnm(String pIwsDisphhknkjnm) {
        iwsDisphhknkjnm = pIwsDisphhknkjnm;
    }

    @Column(order = 32, length = 8)
    @MaxLength(max=8)
    @SingleByteStrings
    private String iwsDisphhknseiymd;

    public String getIwsDisphhknseiymd() {
        return iwsDisphhknseiymd;
    }

    public void setIwsDisphhknseiymd(String pIwsDisphhknseiymd) {
        iwsDisphhknseiymd = pIwsDisphhknseiymd;
    }

    @Column(order = 33, length = 2)
    private String iwsDisphhknnen2keta;

    public String getIwsDisphhknnen2keta() {
        return iwsDisphhknnen2keta;
    }

    public void setIwsDisphhknnen2keta(String pIwsDisphhknnen2keta) {
        iwsDisphhknnen2keta = pIwsDisphhknnen2keta;
    }

    @Column(order = 34, length = 2)
    @MultiByte
    private String iwsDisphhknsei;

    public String getIwsDisphhknsei() {
        return iwsDisphhknsei;
    }

    public void setIwsDisphhknsei(String pIwsDisphhknsei) {
        iwsDisphhknsei = pIwsDisphhknsei;
    }

    @Column(order = 35, length = 8)
    private String iwsDisphhknyno;

    public String getIwsDisphhknyno() {
        return iwsDisphhknyno;
    }

    public void setIwsDisphhknyno(String pIwsDisphhknyno) {
        iwsDisphhknyno = pIwsDisphhknyno;
    }

    @Column(order = 36, length = 62)
    @MultiByte
    private String iwsDisphhknadr01;

    public String getIwsDisphhknadr01() {
        return iwsDisphhknadr01;
    }

    public void setIwsDisphhknadr01(String pIwsDisphhknadr01) {
        iwsDisphhknadr01 = pIwsDisphhknadr01;
    }

    @Column(order = 37, length = 62)
    @MultiByte
    private String iwsDisphhknadr02;

    public String getIwsDisphhknadr02() {
        return iwsDisphhknadr02;
    }

    public void setIwsDisphhknadr02(String pIwsDisphhknadr02) {
        iwsDisphhknadr02 = pIwsDisphhknadr02;
    }

    @Column(order = 38, length = 4)
    @MultiByte
    private String iwsDispmosjk;

    public String getIwsDispmosjk() {
        return iwsDispmosjk;
    }

    public void setIwsDispmosjk(String pIwsDispmosjk) {
        iwsDispmosjk = pIwsDispmosjk;
    }

    @Column(order = 39, length = 8)
    @MultiByte
    private String iwsDisphubijk;

    public String getIwsDisphubijk() {
        return iwsDisphubijk;
    }

    public void setIwsDisphubijk(String pIwsDisphubijk) {
        iwsDisphubijk = pIwsDisphubijk;
    }

    @Column(order = 40, length = 8)
    private String iwsDispmosymd;

    public String getIwsDispmosymd() {
        return iwsDispmosymd;
    }

    public void setIwsDispmosymd(String pIwsDispmosymd) {
        iwsDispmosymd = pIwsDispmosymd;
    }

    @Column(order = 41, length = 8)
    private String iwsDispkokutiymd;

    public String getIwsDispkokutiymd() {
        return iwsDispkokutiymd;
    }

    public void setIwsDispkokutiymd(String pIwsDispkokutiymd) {
        iwsDispkokutiymd = pIwsDispkokutiymd;
    }

    @Column(order = 42, length = 4)
    @MultiByte
    private String iwsDispsinsahouhou;

    public String getIwsDispsinsahouhou() {
        return iwsDispsinsahouhou;
    }

    public void setIwsDispsinsahouhou(String pIwsDispsinsahouhou) {
        iwsDispsinsahouhou = pIwsDispsinsahouhou;
    }

    @Column(order = 43, length = 8)
    private String iwsDispkeiyakuymd;

    public String getIwsDispkeiyakuymd() {
        return iwsDispkeiyakuymd;
    }

    public void setIwsDispkeiyakuymd(String pIwsDispkeiyakuymd) {
        iwsDispkeiyakuymd = pIwsDispkeiyakuymd;
    }

    @Column(order = 44, length = 8)
    private String iwsDispseirituymd;

    public String getIwsDispseirituymd() {
        return iwsDispseirituymd;
    }

    public void setIwsDispseirituymd(String pIwsDispseirituymd) {
        iwsDispseirituymd = pIwsDispseirituymd;
    }

    @Column(order = 45, length = 6)
    private String iwsDispkeijyouymstr;

    public String getIwsDispkeijyouymstr() {
        return iwsDispkeijyouymstr;
    }

    public void setIwsDispkeijyouymstr(String pIwsDispkeijyouymstr) {
        iwsDispkeijyouymstr = pIwsDispkeijyouymstr;
    }

    @Column(order = 46, length = 3)
    @MultiByte
    private String iwsDispsyoukenjk;

    public String getIwsDispsyoukenjk() {
        return iwsDispsyoukenjk;
    }

    public void setIwsDispsyoukenjk(String pIwsDispsyoukenjk) {
        iwsDispsyoukenjk = pIwsDispsyoukenjk;
    }

    @Column(order = 47, length = 8)
    private String iwsDispsyoukensakuseiymd;

    public String getIwsDispsyoukensakuseiymd() {
        return iwsDispsyoukensakuseiymd;
    }

    public void setIwsDispsyoukensakuseiymd(String pIwsDispsyoukensakuseiymd) {
        iwsDispsyoukensakuseiymd = pIwsDispsyoukensakuseiymd;
    }

    @Column(order = 48, length = 8)
    private String iwsDispsyoukenhakkouytiymd;

    public String getIwsDispsyoukenhakkouytiymd() {
        return iwsDispsyoukenhakkouytiymd;
    }

    public void setIwsDispsyoukenhakkouytiymd(String pIwsDispsyoukenhakkouytiymd) {
        iwsDispsyoukenhakkouytiymd = pIwsDispsyoukenhakkouytiymd;
    }

    @Column(order = 49, length = 12)
    @MultiByte
    private String iwsDispnkjk;

    public String getIwsDispnkjk() {
        return iwsDispnkjk;
    }

    public void setIwsDispnkjk(String pIwsDispnkjk) {
        iwsDispnkjk = pIwsDispnkjk;
    }

    @Column(order = 50, length = 1)
    private String iwsDispnkrirekidtlsuu;

    public String getIwsDispnkrirekidtlsuu() {
        return iwsDispnkrirekidtlsuu;
    }

    public void setIwsDispnkrirekidtlsuu(String pIwsDispnkrirekidtlsuu) {
        iwsDispnkrirekidtlsuu = pIwsDispnkrirekidtlsuu;
    }

    @Column(order = 51, length = 14)
    private String iwsDispprsgaku01;

    public String getIwsDispprsgaku01() {
        return iwsDispprsgaku01;
    }

    public void setIwsDispprsgaku01(String pIwsDispprsgaku01) {
        iwsDispprsgaku01 = pIwsDispprsgaku01;
    }

    @Column(order = 52, length = 8)
    private String iwsDispryousyuuymd01;

    public String getIwsDispryousyuuymd01() {
        return iwsDispryousyuuymd01;
    }

    public void setIwsDispryousyuuymd01(String pIwsDispryousyuuymd01) {
        iwsDispryousyuuymd01 = pIwsDispryousyuuymd01;
    }

    @Column(order = 53, length = 14)
    private String iwsDispprsgaku02;

    public String getIwsDispprsgaku02() {
        return iwsDispprsgaku02;
    }

    public void setIwsDispprsgaku02(String pIwsDispprsgaku02) {
        iwsDispprsgaku02 = pIwsDispprsgaku02;
    }

    @Column(order = 54, length = 8)
    private String iwsDispryousyuuymd02;

    public String getIwsDispryousyuuymd02() {
        return iwsDispryousyuuymd02;
    }

    public void setIwsDispryousyuuymd02(String pIwsDispryousyuuymd02) {
        iwsDispryousyuuymd02 = pIwsDispryousyuuymd02;
    }

    @Column(order = 55, length = 14)
    private String iwsDispprsgaku03;

    public String getIwsDispprsgaku03() {
        return iwsDispprsgaku03;
    }

    public void setIwsDispprsgaku03(String pIwsDispprsgaku03) {
        iwsDispprsgaku03 = pIwsDispprsgaku03;
    }

    @Column(order = 56, length = 8)
    private String iwsDispryousyuuymd03;

    public String getIwsDispryousyuuymd03() {
        return iwsDispryousyuuymd03;
    }

    public void setIwsDispryousyuuymd03(String pIwsDispryousyuuymd03) {
        iwsDispryousyuuymd03 = pIwsDispryousyuuymd03;
    }

    @Column(order = 57, length = 14)
    private String iwsDispprsgaku04;

    public String getIwsDispprsgaku04() {
        return iwsDispprsgaku04;
    }

    public void setIwsDispprsgaku04(String pIwsDispprsgaku04) {
        iwsDispprsgaku04 = pIwsDispprsgaku04;
    }

    @Column(order = 58, length = 8)
    private String iwsDispryousyuuymd04;

    public String getIwsDispryousyuuymd04() {
        return iwsDispryousyuuymd04;
    }

    public void setIwsDispryousyuuymd04(String pIwsDispryousyuuymd04) {
        iwsDispryousyuuymd04 = pIwsDispryousyuuymd04;
    }

    @Column(order = 59, length = 1)
    private String iwsDispnktyouseiniyudtlsuu;

    public String getIwsDispnktyouseiniyudtlsuu() {
        return iwsDispnktyouseiniyudtlsuu;
    }

    public void setIwsDispnktyouseiniyudtlsuu(String pIwsDispnktyouseiniyudtlsuu) {
        iwsDispnktyouseiniyudtlsuu = pIwsDispnktyouseiniyudtlsuu;
    }

    @Column(order = 60, length = 14)
    private String iwsDisphnkngk01;

    public String getIwsDisphnkngk01() {
        return iwsDisphnkngk01;
    }

    public void setIwsDisphnkngk01(String pIwsDisphnkngk01) {
        iwsDisphnkngk01 = pIwsDisphnkngk01;
    }

    @Column(order = 61, length = 3)
    @MultiByte
    private String iwsDispssnaiyou01;

    public String getIwsDispssnaiyou01() {
        return iwsDispssnaiyou01;
    }

    public void setIwsDispssnaiyou01(String pIwsDispssnaiyou01) {
        iwsDispssnaiyou01 = pIwsDispssnaiyou01;
    }

    @Column(order = 62, length = 14)
    private String iwsDisphnkngk02;

    public String getIwsDisphnkngk02() {
        return iwsDisphnkngk02;
    }

    public void setIwsDisphnkngk02(String pIwsDisphnkngk02) {
        iwsDisphnkngk02 = pIwsDisphnkngk02;
    }

    @Column(order = 63, length = 3)
    @MultiByte
    private String iwsDispssnaiyou02;

    public String getIwsDispssnaiyou02() {
        return iwsDispssnaiyou02;
    }

    public void setIwsDispssnaiyou02(String pIwsDispssnaiyou02) {
        iwsDispssnaiyou02 = pIwsDispssnaiyou02;
    }

    @Column(order = 64, length = 14)
    private String iwsDisphnkngk03;

    public String getIwsDisphnkngk03() {
        return iwsDisphnkngk03;
    }

    public void setIwsDisphnkngk03(String pIwsDisphnkngk03) {
        iwsDisphnkngk03 = pIwsDisphnkngk03;
    }

    @Column(order = 65, length = 3)
    @MultiByte
    private String iwsDispssnaiyou03;

    public String getIwsDispssnaiyou03() {
        return iwsDispssnaiyou03;
    }

    public void setIwsDispssnaiyou03(String pIwsDispssnaiyou03) {
        iwsDispssnaiyou03 = pIwsDispssnaiyou03;
    }

    @Column(order = 66, length = 14)
    private String iwsDisphnkngk04;

    public String getIwsDisphnkngk04() {
        return iwsDisphnkngk04;
    }

    public void setIwsDisphnkngk04(String pIwsDisphnkngk04) {
        iwsDisphnkngk04 = pIwsDisphnkngk04;
    }

    @Column(order = 67, length = 3)
    @MultiByte
    private String iwsDispssnaiyou04;

    public String getIwsDispssnaiyou04() {
        return iwsDispssnaiyou04;
    }

    public void setIwsDispssnaiyou04(String pIwsDispssnaiyou04) {
        iwsDispssnaiyou04 = pIwsDispssnaiyou04;
    }

    @Column(order = 68, length = 2)
    private String iwsDispiktkaisuu;

    public String getIwsDispiktkaisuu() {
        return iwsDispiktkaisuu;
    }

    public void setIwsDispiktkaisuu(String pIwsDispiktkaisuu) {
        iwsDispiktkaisuu = pIwsDispiktkaisuu;
    }

    @Column(order = 69, length = 2)
    private String iwsDispznnkai;

    public String getIwsDispznnkai() {
        return iwsDispznnkai;
    }

    public void setIwsDispznnkai(String pIwsDispznnkai) {
        iwsDispznnkai = pIwsDispznnkai;
    }

    @Column(order = 70, length = 12)
    @MultiByte
    private String iwsDispketteijk;

    public String getIwsDispketteijk() {
        return iwsDispketteijk;
    }

    public void setIwsDispketteijk(String pIwsDispketteijk) {
        iwsDispketteijk = pIwsDispketteijk;
    }

    @Column(order = 71, length = 1)
    private String iwsDispsinsatehaiinfokbn;

    public String getIwsDispsinsatehaiinfokbn() {
        return iwsDispsinsatehaiinfokbn;
    }

    public void setIwsDispsinsatehaiinfokbn(String pIwsDispsinsatehaiinfokbn) {
        iwsDispsinsatehaiinfokbn = pIwsDispsinsatehaiinfokbn;
    }

    @Column(order = 72, length = 2)
    private String iwsDispyoyakuukeno;

    public String getIwsDispyoyakuukeno() {
        return iwsDispyoyakuukeno;
    }

    public void setIwsDispyoyakuukeno(String pIwsDispyoyakuukeno) {
        iwsDispyoyakuukeno = pIwsDispyoyakuukeno;
    }

    @Column(order = 73, length = 4)
    @MultiByte
    private String iwsDispyoyakutehaijk;

    public String getIwsDispyoyakutehaijk() {
        return iwsDispyoyakutehaijk;
    }

    public void setIwsDispyoyakutehaijk(String pIwsDispyoyakutehaijk) {
        iwsDispyoyakutehaijk = pIwsDispyoyakutehaijk;
    }

    @Column(order = 74, length = 6)
    @MultiByte
    private String iwsDispyoyakusinsahouhou;

    public String getIwsDispyoyakusinsahouhou() {
        return iwsDispyoyakusinsahouhou;
    }

    public void setIwsDispyoyakusinsahouhou(String pIwsDispyoyakusinsahouhou) {
        iwsDispyoyakusinsahouhou = pIwsDispyoyakusinsahouhou;
    }

    @Column(order = 75, length = 4)
    @MultiByte
    private String iwsDispyoyakusindenzu;

    public String getIwsDispyoyakusindenzu() {
        return iwsDispyoyakusindenzu;
    }

    public void setIwsDispyoyakusindenzu(String pIwsDispyoyakusindenzu) {
        iwsDispyoyakusindenzu = pIwsDispyoyakusindenzu;
    }

    @Column(order = 76, length = 4)
    @MultiByte
    private String iwsDispyoyakuketuekikensa;

    public String getIwsDispyoyakuketuekikensa() {
        return iwsDispyoyakuketuekikensa;
    }

    public void setIwsDispyoyakuketuekikensa(String pIwsDispyoyakuketuekikensa) {
        iwsDispyoyakuketuekikensa = pIwsDispyoyakuketuekikensa;
    }

    @Column(order = 77, length = 6)
    @MultiByte
    private String iwsDispyoyakudai1kiboumd;

    public String getIwsDispyoyakudai1kiboumd() {
        return iwsDispyoyakudai1kiboumd;
    }

    public void setIwsDispyoyakudai1kiboumd(String pIwsDispyoyakudai1kiboumd) {
        iwsDispyoyakudai1kiboumd = pIwsDispyoyakudai1kiboumd;
    }

    @Column(order = 78, length = 11)
    @MultiByte
    private String iwsDispyoyakudai1kiboutime;

    public String getIwsDispyoyakudai1kiboutime() {
        return iwsDispyoyakudai1kiboutime;
    }

    public void setIwsDispyoyakudai1kiboutime(String pIwsDispyoyakudai1kiboutime) {
        iwsDispyoyakudai1kiboutime = pIwsDispyoyakudai1kiboutime;
    }

    @Column(order = 79, length = 8)
    @MultiByte
    private String iwsDispyoyakudai1kiboubasyo;

    public String getIwsDispyoyakudai1kiboubasyo() {
        return iwsDispyoyakudai1kiboubasyo;
    }

    public void setIwsDispyoyakudai1kiboubasyo(String pIwsDispyoyakudai1kiboubasyo) {
        iwsDispyoyakudai1kiboubasyo = pIwsDispyoyakudai1kiboubasyo;
    }

    @Column(order = 80, length = 62)
    @MultiByte
    private String iwsDispyoyakudai1kibouadr;

    public String getIwsDispyoyakudai1kibouadr() {
        return iwsDispyoyakudai1kibouadr;
    }

    public void setIwsDispyoyakudai1kibouadr(String pIwsDispyoyakudai1kibouadr) {
        iwsDispyoyakudai1kibouadr = pIwsDispyoyakudai1kibouadr;
    }

    @Column(order = 81, length = 6)
    @MultiByte
    private String iwsDispyoyakudai2kiboumd;

    public String getIwsDispyoyakudai2kiboumd() {
        return iwsDispyoyakudai2kiboumd;
    }

    public void setIwsDispyoyakudai2kiboumd(String pIwsDispyoyakudai2kiboumd) {
        iwsDispyoyakudai2kiboumd = pIwsDispyoyakudai2kiboumd;
    }

    @Column(order = 82, length = 11)
    @MultiByte
    private String iwsDispyoyakudai2kiboutime;

    public String getIwsDispyoyakudai2kiboutime() {
        return iwsDispyoyakudai2kiboutime;
    }

    public void setIwsDispyoyakudai2kiboutime(String pIwsDispyoyakudai2kiboutime) {
        iwsDispyoyakudai2kiboutime = pIwsDispyoyakudai2kiboutime;
    }

    @Column(order = 83, length = 8)
    @MultiByte
    private String iwsDispyoyakudai2kiboubasyo;

    public String getIwsDispyoyakudai2kiboubasyo() {
        return iwsDispyoyakudai2kiboubasyo;
    }

    public void setIwsDispyoyakudai2kiboubasyo(String pIwsDispyoyakudai2kiboubasyo) {
        iwsDispyoyakudai2kiboubasyo = pIwsDispyoyakudai2kiboubasyo;
    }

    @Column(order = 84, length = 62)
    @MultiByte
    private String iwsDispyoyakudai2kibouadr;

    public String getIwsDispyoyakudai2kibouadr() {
        return iwsDispyoyakudai2kibouadr;
    }

    public void setIwsDispyoyakudai2kibouadr(String pIwsDispyoyakudai2kibouadr) {
        iwsDispyoyakudai2kibouadr = pIwsDispyoyakudai2kibouadr;
    }

    @Column(order = 85, length = 6)
    @MultiByte
    private String iwsDispyoyakudai3kiboumd;

    public String getIwsDispyoyakudai3kiboumd() {
        return iwsDispyoyakudai3kiboumd;
    }

    public void setIwsDispyoyakudai3kiboumd(String pIwsDispyoyakudai3kiboumd) {
        iwsDispyoyakudai3kiboumd = pIwsDispyoyakudai3kiboumd;
    }

    @Column(order = 86, length = 11)
    @MultiByte
    private String iwsDispyoyakudai3kiboutime;

    public String getIwsDispyoyakudai3kiboutime() {
        return iwsDispyoyakudai3kiboutime;
    }

    public void setIwsDispyoyakudai3kiboutime(String pIwsDispyoyakudai3kiboutime) {
        iwsDispyoyakudai3kiboutime = pIwsDispyoyakudai3kiboutime;
    }

    @Column(order = 87, length = 8)
    @MultiByte
    private String iwsDispyoyakudai3kiboubasyo;

    public String getIwsDispyoyakudai3kiboubasyo() {
        return iwsDispyoyakudai3kiboubasyo;
    }

    public void setIwsDispyoyakudai3kiboubasyo(String pIwsDispyoyakudai3kiboubasyo) {
        iwsDispyoyakudai3kiboubasyo = pIwsDispyoyakudai3kiboubasyo;
    }

    @Column(order = 88, length = 62)
    @MultiByte
    private String iwsDispyoyakudai3kibouadr;

    public String getIwsDispyoyakudai3kibouadr() {
        return iwsDispyoyakudai3kibouadr;
    }

    public void setIwsDispyoyakudai3kibouadr(String pIwsDispyoyakudai3kibouadr) {
        iwsDispyoyakudai3kibouadr = pIwsDispyoyakudai3kibouadr;
    }

    @Column(order = 89, length = 14)
    private String iwsDispyoyakuokyksmrenraku;

    public String getIwsDispyoyakuokyksmrenraku() {
        return iwsDispyoyakuokyksmrenraku;
    }

    public void setIwsDispyoyakuokyksmrenraku(String pIwsDispyoyakuokyksmrenraku) {
        iwsDispyoyakuokyksmrenraku = pIwsDispyoyakuokyksmrenraku;
    }

    @Column(order = 90, length = 14)
    private String iwsDispyoyakubosyuutntrnrk;

    public String getIwsDispyoyakubosyuutntrnrk() {
        return iwsDispyoyakubosyuutntrnrk;
    }

    public void setIwsDispyoyakubosyuutntrnrk(String pIwsDispyoyakubosyuutntrnrk) {
        iwsDispyoyakubosyuutntrnrk = pIwsDispyoyakubosyuutntrnrk;
    }

    @Column(order = 91, length = 10)
    @MultiByte
    private String iwsDispyoyakudoukoukibouyh;

    public String getIwsDispyoyakudoukoukibouyh() {
        return iwsDispyoyakudoukoukibouyh;
    }

    public void setIwsDispyoyakudoukoukibouyh(String pIwsDispyoyakudoukoukibouyh) {
        iwsDispyoyakudoukoukibouyh = pIwsDispyoyakudoukoukibouyh;
    }

    @Column(order = 92, length = 2)
    private String iwsDisptehaiukeno;

    public String getIwsDisptehaiukeno() {
        return iwsDisptehaiukeno;
    }

    public void setIwsDisptehaiukeno(String pIwsDisptehaiukeno) {
        iwsDisptehaiukeno = pIwsDisptehaiukeno;
    }

    @Column(order = 93, length = 3)
    @MultiByte
    private String iwsDisptehaijk;

    public String getIwsDisptehaijk() {
        return iwsDisptehaijk;
    }

    public void setIwsDisptehaijk(String pIwsDisptehaijk) {
        iwsDisptehaijk = pIwsDisptehaijk;
    }

    @Column(order = 94, length = 8)
    @MultiByte
    private String iwsDisptehaikekka;

    public String getIwsDisptehaikekka() {
        return iwsDisptehaikekka;
    }

    public void setIwsDisptehaikekka(String pIwsDisptehaikekka) {
        iwsDisptehaikekka = pIwsDisptehaikekka;
    }

    @Column(order = 95, length = 5)
    @MultiByte
    private String iwsDisptehaisinsahouhou;

    public String getIwsDisptehaisinsahouhou() {
        return iwsDisptehaisinsahouhou;
    }

    public void setIwsDisptehaisinsahouhou(String pIwsDisptehaisinsahouhou) {
        iwsDisptehaisinsahouhou = pIwsDisptehaisinsahouhou;
    }

    @Column(order = 96, length = 4)
    @MultiByte
    private String iwsDisptehaisindenzu;

    public String getIwsDisptehaisindenzu() {
        return iwsDisptehaisindenzu;
    }

    public void setIwsDisptehaisindenzu(String pIwsDisptehaisindenzu) {
        iwsDisptehaisindenzu = pIwsDisptehaisindenzu;
    }

    @Column(order = 97, length = 4)
    @MultiByte
    private String iwsDisptehaiketuekikensa;

    public String getIwsDisptehaiketuekikensa() {
        return iwsDisptehaiketuekikensa;
    }

    public void setIwsDisptehaiketuekikensa(String pIwsDisptehaiketuekikensa) {
        iwsDisptehaiketuekikensa = pIwsDisptehaiketuekikensa;
    }

    @Column(order = 98, length = 1)
    private String iwsDisptehaisnssyadtlsuu;

    public String getIwsDisptehaisnssyadtlsuu() {
        return iwsDisptehaisnssyadtlsuu;
    }

    public void setIwsDisptehaisnssyadtlsuu(String pIwsDisptehaisnssyadtlsuu) {
        iwsDisptehaisnssyadtlsuu = pIwsDisptehaisnssyadtlsuu;
    }

    @Column(order = 99, length = 7)
    private String iwsDisptehaisnssyacd01;

    public String getIwsDisptehaisnssyacd01() {
        return iwsDisptehaisnssyacd01;
    }

    public void setIwsDisptehaisnssyacd01(String pIwsDisptehaisnssyacd01) {
        iwsDisptehaisnssyacd01 = pIwsDisptehaisnssyacd01;
    }

    @Column(order = 100, length = 10)
    @MultiByte
    private String iwsDisptehaisnssyanm01;

    public String getIwsDisptehaisnssyanm01() {
        return iwsDisptehaisnssyanm01;
    }

    public void setIwsDisptehaisnssyanm01(String pIwsDisptehaisnssyanm01) {
        iwsDisptehaisnssyanm01 = pIwsDisptehaisnssyanm01;
    }

    @Column(order = 101, length = 7)
    private String iwsDisptehaisnssyacd02;

    public String getIwsDisptehaisnssyacd02() {
        return iwsDisptehaisnssyacd02;
    }

    public void setIwsDisptehaisnssyacd02(String pIwsDisptehaisnssyacd02) {
        iwsDisptehaisnssyacd02 = pIwsDisptehaisnssyacd02;
    }

    @Column(order = 102, length = 10)
    @MultiByte
    private String iwsDisptehaisnssyanm02;

    public String getIwsDisptehaisnssyanm02() {
        return iwsDisptehaisnssyanm02;
    }

    public void setIwsDisptehaisnssyanm02(String pIwsDisptehaisnssyanm02) {
        iwsDisptehaisnssyanm02 = pIwsDisptehaisnssyanm02;
    }

    @Column(order = 103, length = 7)
    private String iwsDisptehaisnssyacd03;

    public String getIwsDisptehaisnssyacd03() {
        return iwsDisptehaisnssyacd03;
    }

    public void setIwsDisptehaisnssyacd03(String pIwsDisptehaisnssyacd03) {
        iwsDisptehaisnssyacd03 = pIwsDisptehaisnssyacd03;
    }

    @Column(order = 104, length = 10)
    @MultiByte
    private String iwsDisptehaisnssyanm03;

    public String getIwsDisptehaisnssyanm03() {
        return iwsDisptehaisnssyanm03;
    }

    public void setIwsDisptehaisnssyanm03(String pIwsDisptehaisnssyanm03) {
        iwsDisptehaisnssyanm03 = pIwsDisptehaisnssyanm03;
    }

    @Column(order = 105, length = 6)
    @MultiByte
    private String iwsDisptehaiyoteimd;

    public String getIwsDisptehaiyoteimd() {
        return iwsDisptehaiyoteimd;
    }

    public void setIwsDisptehaiyoteimd(String pIwsDisptehaiyoteimd) {
        iwsDisptehaiyoteimd = pIwsDisptehaiyoteimd;
    }

    @Column(order = 106, length = 5)
    @MultiByte
    private String iwsDisptehaiyoteitime;

    public String getIwsDisptehaiyoteitime() {
        return iwsDisptehaiyoteitime;
    }

    public void setIwsDisptehaiyoteitime(String pIwsDisptehaiyoteitime) {
        iwsDisptehaiyoteitime = pIwsDisptehaiyoteitime;
    }

    @Column(order = 107, length = 8)
    @MultiByte
    private String iwsDisptehaiyoteibasyo;

    public String getIwsDisptehaiyoteibasyo() {
        return iwsDisptehaiyoteibasyo;
    }

    public void setIwsDisptehaiyoteibasyo(String pIwsDisptehaiyoteibasyo) {
        iwsDisptehaiyoteibasyo = pIwsDisptehaiyoteibasyo;
    }

    @Column(order = 108, length = 8)
    private String iwsDisptehaiyoteipostalcd;

    public String getIwsDisptehaiyoteipostalcd() {
        return iwsDisptehaiyoteipostalcd;
    }

    public void setIwsDisptehaiyoteipostalcd(String pIwsDisptehaiyoteipostalcd) {
        iwsDisptehaiyoteipostalcd = pIwsDisptehaiyoteipostalcd;
    }

    @Column(order = 109, length = 62)
    @MultiByte
    private String iwsDisptehaiyoteiadr;

    public String getIwsDisptehaiyoteiadr() {
        return iwsDisptehaiyoteiadr;
    }

    public void setIwsDisptehaiyoteiadr(String pIwsDisptehaiyoteiadr) {
        iwsDisptehaiyoteiadr = pIwsDisptehaiyoteiadr;
    }

    @Column(order = 110, length = 5)
    @MultiByte
    private String iwsDisptehaidksyatehaikekka;

    public String getIwsDisptehaidksyatehaikekka() {
        return iwsDisptehaidksyatehaikekka;
    }

    public void setIwsDisptehaidksyatehaikekka(String pIwsDisptehaidksyatehaikekka) {
        iwsDisptehaidksyatehaikekka = pIwsDisptehaidksyatehaikekka;
    }

    @Column(order = 111, length = 20)
    @MultiByte
    private String iwsDisptehaidksyakjsosikinm;

    public String getIwsDisptehaidksyakjsosikinm() {
        return iwsDisptehaidksyakjsosikinm;
    }

    public void setIwsDisptehaidksyakjsosikinm(String pIwsDisptehaidksyakjsosikinm) {
        iwsDisptehaidksyakjsosikinm = pIwsDisptehaidksyakjsosikinm;
    }

    @Column(order = 112, length = 10)
    @MultiByte
    private String iwsDisptehaidksyakjnm;

    public String getIwsDisptehaidksyakjnm() {
        return iwsDisptehaidksyakjnm;
    }

    public void setIwsDisptehaidksyakjnm(String pIwsDisptehaidksyakjnm) {
        iwsDisptehaidksyakjnm = pIwsDisptehaidksyakjnm;
    }

    @Column(order = 113, length = 1)
    private String iwsDispsbuktdtlsuu;

    public String getIwsDispsbuktdtlsuu() {
        return iwsDispsbuktdtlsuu;
    }

    public void setIwsDispsbuktdtlsuu(String pIwsDispsbuktdtlsuu) {
        iwsDispsbuktdtlsuu = pIwsDispsbuktdtlsuu;
    }

    @Column(order = 114, length = 10)
    @MultiByte
    private String iwsDispsbuktmds;

    public String getIwsDispsbuktmds() {
        return iwsDispsbuktmds;
    }

    public void setIwsDispsbuktmds(String pIwsDispsbuktmds) {
        iwsDispsbuktmds = pIwsDispsbuktmds;
    }

    @Column(order = 115, length = 1)
    private String iwsDispsbuktnin;

    public String getIwsDispsbuktnin() {
        return iwsDispsbuktnin;
    }

    public void setIwsDispsbuktnin(String pIwsDispsbuktnin) {
        iwsDispsbuktnin = pIwsDispsbuktnin;
    }

    @Column(order = 116, length = 15)
    @MultiByte
    private String iwsDispsbuktnm01;

    public String getIwsDispsbuktnm01() {
        return iwsDispsbuktnm01;
    }

    public void setIwsDispsbuktnm01(String pIwsDispsbuktnm01) {
        iwsDispsbuktnm01 = pIwsDispsbuktnm01;
    }

    @Column(order = 117, length = 8)
    private String iwsDispsbuktseiymd01;

    public String getIwsDispsbuktseiymd01() {
        return iwsDispsbuktseiymd01;
    }

    public void setIwsDispsbuktseiymd01(String pIwsDispsbuktseiymd01) {
        iwsDispsbuktseiymd01 = pIwsDispsbuktseiymd01;
    }

    @Column(order = 118, length = 7)
    @MultiByte
    private String iwsDispsbukttdk01;

    public String getIwsDispsbukttdk01() {
        return iwsDispsbukttdk01;
    }

    public void setIwsDispsbukttdk01(String pIwsDispsbukttdk01) {
        iwsDispsbukttdk01 = pIwsDispsbukttdk01;
    }

    @Column(order = 119, length = 3)
    private String iwsDispsbuktbnwari01;

    public String getIwsDispsbuktbnwari01() {
        return iwsDispsbuktbnwari01;
    }

    public void setIwsDispsbuktbnwari01(String pIwsDispsbuktbnwari01) {
        iwsDispsbuktbnwari01 = pIwsDispsbuktbnwari01;
    }

    @Column(order = 120, length = 15)
    @MultiByte
    private String iwsDispsbuktnm02;

    public String getIwsDispsbuktnm02() {
        return iwsDispsbuktnm02;
    }

    public void setIwsDispsbuktnm02(String pIwsDispsbuktnm02) {
        iwsDispsbuktnm02 = pIwsDispsbuktnm02;
    }

    @Column(order = 121, length = 8)
    private String iwsDispsbuktseiymd02;

    public String getIwsDispsbuktseiymd02() {
        return iwsDispsbuktseiymd02;
    }

    public void setIwsDispsbuktseiymd02(String pIwsDispsbuktseiymd02) {
        iwsDispsbuktseiymd02 = pIwsDispsbuktseiymd02;
    }

    @Column(order = 122, length = 7)
    @MultiByte
    private String iwsDispsbukttdk02;

    public String getIwsDispsbukttdk02() {
        return iwsDispsbukttdk02;
    }

    public void setIwsDispsbukttdk02(String pIwsDispsbukttdk02) {
        iwsDispsbukttdk02 = pIwsDispsbukttdk02;
    }

    @Column(order = 123, length = 3)
    private String iwsDispsbuktbnwari02;

    public String getIwsDispsbuktbnwari02() {
        return iwsDispsbuktbnwari02;
    }

    public void setIwsDispsbuktbnwari02(String pIwsDispsbuktbnwari02) {
        iwsDispsbuktbnwari02 = pIwsDispsbuktbnwari02;
    }

    @Column(order = 124, length = 15)
    @MultiByte
    private String iwsDispsbuktnm03;

    public String getIwsDispsbuktnm03() {
        return iwsDispsbuktnm03;
    }

    public void setIwsDispsbuktnm03(String pIwsDispsbuktnm03) {
        iwsDispsbuktnm03 = pIwsDispsbuktnm03;
    }

    @Column(order = 125, length = 8)
    private String iwsDispsbuktseiymd03;

    public String getIwsDispsbuktseiymd03() {
        return iwsDispsbuktseiymd03;
    }

    public void setIwsDispsbuktseiymd03(String pIwsDispsbuktseiymd03) {
        iwsDispsbuktseiymd03 = pIwsDispsbuktseiymd03;
    }

    @Column(order = 126, length = 7)
    @MultiByte
    private String iwsDispsbukttdk03;

    public String getIwsDispsbukttdk03() {
        return iwsDispsbukttdk03;
    }

    public void setIwsDispsbukttdk03(String pIwsDispsbukttdk03) {
        iwsDispsbukttdk03 = pIwsDispsbukttdk03;
    }

    @Column(order = 127, length = 3)
    private String iwsDispsbuktbnwari03;

    public String getIwsDispsbuktbnwari03() {
        return iwsDispsbuktbnwari03;
    }

    public void setIwsDispsbuktbnwari03(String pIwsDispsbuktbnwari03) {
        iwsDispsbuktbnwari03 = pIwsDispsbuktbnwari03;
    }

    @Column(order = 128, length = 15)
    @MultiByte
    private String iwsDispsbuktnm04;

    public String getIwsDispsbuktnm04() {
        return iwsDispsbuktnm04;
    }

    public void setIwsDispsbuktnm04(String pIwsDispsbuktnm04) {
        iwsDispsbuktnm04 = pIwsDispsbuktnm04;
    }

    @Column(order = 129, length = 8)
    private String iwsDispsbuktseiymd04;

    public String getIwsDispsbuktseiymd04() {
        return iwsDispsbuktseiymd04;
    }

    public void setIwsDispsbuktseiymd04(String pIwsDispsbuktseiymd04) {
        iwsDispsbuktseiymd04 = pIwsDispsbuktseiymd04;
    }

    @Column(order = 130, length = 7)
    @MultiByte
    private String iwsDispsbukttdk04;

    public String getIwsDispsbukttdk04() {
        return iwsDispsbukttdk04;
    }

    public void setIwsDispsbukttdk04(String pIwsDispsbukttdk04) {
        iwsDispsbukttdk04 = pIwsDispsbukttdk04;
    }

    @Column(order = 131, length = 3)
    private String iwsDispsbuktbnwari04;

    public String getIwsDispsbuktbnwari04() {
        return iwsDispsbuktbnwari04;
    }

    public void setIwsDispsbuktbnwari04(String pIwsDispsbuktbnwari04) {
        iwsDispsbuktbnwari04 = pIwsDispsbuktbnwari04;
    }

    @Column(order = 132, length = 1)
    private String iwsDispmnkuktdtlsuu;

    public String getIwsDispmnkuktdtlsuu() {
        return iwsDispmnkuktdtlsuu;
    }

    public void setIwsDispmnkuktdtlsuu(String pIwsDispmnkuktdtlsuu) {
        iwsDispmnkuktdtlsuu = pIwsDispmnkuktdtlsuu;
    }

    @Column(order = 133, length = 8)
    @MultiByte
    private String iwsDispmnkuktmds;

    public String getIwsDispmnkuktmds() {
        return iwsDispmnkuktmds;
    }

    public void setIwsDispmnkuktmds(String pIwsDispmnkuktmds) {
        iwsDispmnkuktmds = pIwsDispmnkuktmds;
    }

    @Column(order = 134, length = 1)
    private String iwsDispmnkuktnin;

    public String getIwsDispmnkuktnin() {
        return iwsDispmnkuktnin;
    }

    public void setIwsDispmnkuktnin(String pIwsDispmnkuktnin) {
        iwsDispmnkuktnin = pIwsDispmnkuktnin;
    }

    @Column(order = 135, length = 15)
    @MultiByte
    private String iwsDispmnkuktnm01;

    public String getIwsDispmnkuktnm01() {
        return iwsDispmnkuktnm01;
    }

    public void setIwsDispmnkuktnm01(String pIwsDispmnkuktnm01) {
        iwsDispmnkuktnm01 = pIwsDispmnkuktnm01;
    }

    @Column(order = 136, length = 7)
    @MultiByte
    private String iwsDispmnkukttdk01;

    public String getIwsDispmnkukttdk01() {
        return iwsDispmnkukttdk01;
    }

    public void setIwsDispmnkukttdk01(String pIwsDispmnkukttdk01) {
        iwsDispmnkukttdk01 = pIwsDispmnkukttdk01;
    }

    @Column(order = 137, length = 3)
    private String iwsDispmnkuktbnwari01;

    public String getIwsDispmnkuktbnwari01() {
        return iwsDispmnkuktbnwari01;
    }

    public void setIwsDispmnkuktbnwari01(String pIwsDispmnkuktbnwari01) {
        iwsDispmnkuktbnwari01 = pIwsDispmnkuktbnwari01;
    }

    @Column(order = 138, length = 15)
    @MultiByte
    private String iwsDispmnkuktnm02;

    public String getIwsDispmnkuktnm02() {
        return iwsDispmnkuktnm02;
    }

    public void setIwsDispmnkuktnm02(String pIwsDispmnkuktnm02) {
        iwsDispmnkuktnm02 = pIwsDispmnkuktnm02;
    }

    @Column(order = 139, length = 7)
    @MultiByte
    private String iwsDispmnkukttdk02;

    public String getIwsDispmnkukttdk02() {
        return iwsDispmnkukttdk02;
    }

    public void setIwsDispmnkukttdk02(String pIwsDispmnkukttdk02) {
        iwsDispmnkukttdk02 = pIwsDispmnkukttdk02;
    }

    @Column(order = 140, length = 3)
    private String iwsDispmnkuktbnwari02;

    public String getIwsDispmnkuktbnwari02() {
        return iwsDispmnkuktbnwari02;
    }

    public void setIwsDispmnkuktbnwari02(String pIwsDispmnkuktbnwari02) {
        iwsDispmnkuktbnwari02 = pIwsDispmnkuktbnwari02;
    }

    @Column(order = 141, length = 15)
    @MultiByte
    private String iwsDispmnkuktnm03;

    public String getIwsDispmnkuktnm03() {
        return iwsDispmnkuktnm03;
    }

    public void setIwsDispmnkuktnm03(String pIwsDispmnkuktnm03) {
        iwsDispmnkuktnm03 = pIwsDispmnkuktnm03;
    }

    @Column(order = 142, length = 7)
    @MultiByte
    private String iwsDispmnkukttdk03;

    public String getIwsDispmnkukttdk03() {
        return iwsDispmnkukttdk03;
    }

    public void setIwsDispmnkukttdk03(String pIwsDispmnkukttdk03) {
        iwsDispmnkukttdk03 = pIwsDispmnkukttdk03;
    }

    @Column(order = 143, length = 3)
    private String iwsDispmnkuktbnwari03;

    public String getIwsDispmnkuktbnwari03() {
        return iwsDispmnkuktbnwari03;
    }

    public void setIwsDispmnkuktbnwari03(String pIwsDispmnkuktbnwari03) {
        iwsDispmnkuktbnwari03 = pIwsDispmnkuktbnwari03;
    }

    @Column(order = 144, length = 15)
    @MultiByte
    private String iwsDispmnkuktnm04;

    public String getIwsDispmnkuktnm04() {
        return iwsDispmnkuktnm04;
    }

    public void setIwsDispmnkuktnm04(String pIwsDispmnkuktnm04) {
        iwsDispmnkuktnm04 = pIwsDispmnkuktnm04;
    }

    @Column(order = 145, length = 7)
    @MultiByte
    private String iwsDispmnkukttdk04;

    public String getIwsDispmnkukttdk04() {
        return iwsDispmnkukttdk04;
    }

    public void setIwsDispmnkukttdk04(String pIwsDispmnkukttdk04) {
        iwsDispmnkukttdk04 = pIwsDispmnkukttdk04;
    }

    @Column(order = 146, length = 3)
    private String iwsDispmnkuktbnwari04;

    public String getIwsDispmnkuktbnwari04() {
        return iwsDispmnkuktbnwari04;
    }

    public void setIwsDispmnkuktbnwari04(String pIwsDispmnkuktbnwari04) {
        iwsDispmnkuktbnwari04 = pIwsDispmnkuktbnwari04;
    }

    @Column(order = 147, length = 15)
    @MultiByte
    private String iwsDisptoksiphokenkinuktnm;

    public String getIwsDisptoksiphokenkinuktnm() {
        return iwsDisptoksiphokenkinuktnm;
    }

    public void setIwsDisptoksiphokenkinuktnm(String pIwsDisptoksiphokenkinuktnm) {
        iwsDisptoksiphokenkinuktnm = pIwsDisptoksiphokenkinuktnm;
    }

    @Column(order = 148, length = 15)
    @MultiByte
    private String iwsDispjdmnsihokenkinuktnm;

    public String getIwsDispjdmnsihokenkinuktnm() {
        return iwsDispjdmnsihokenkinuktnm;
    }

    public void setIwsDispjdmnsihokenkinuktnm(String pIwsDispjdmnsihokenkinuktnm) {
        iwsDispjdmnsihokenkinuktnm = pIwsDispjdmnsihokenkinuktnm;
    }

    @Column(order = 149, length = 15)
    @MultiByte
    private String iwsDispstdrsknm;

    public String getIwsDispstdrsknm() {
        return iwsDispstdrsknm;
    }

    public void setIwsDispstdrsknm(String pIwsDispstdrsknm) {
        iwsDispstdrsknm = pIwsDispstdrsknm;
    }

    @Column(order = 150, length = 7)
    @MultiByte
    private String iwsDispstdrsktdk;

    public String getIwsDispstdrsktdk() {
        return iwsDispstdrsktdk;
    }

    public void setIwsDispstdrsktdk(String pIwsDispstdrsktdk) {
        iwsDispstdrsktdk = pIwsDispstdrsktdk;
    }

    @Column(order = 151, length = 9)
    @MultiByte
    private String iwsDispstkeisyouninmds;

    public String getIwsDispstkeisyouninmds() {
        return iwsDispstkeisyouninmds;
    }

    public void setIwsDispstkeisyouninmds(String pIwsDispstkeisyouninmds) {
        iwsDispstkeisyouninmds = pIwsDispstkeisyouninmds;
    }

    @Column(order = 152, length = 15)
    @MultiByte
    private String iwsDispstkeisyouninnm;

    public String getIwsDispstkeisyouninnm() {
        return iwsDispstkeisyouninnm;
    }

    public void setIwsDispstkeisyouninnm(String pIwsDispstkeisyouninnm) {
        iwsDispstkeisyouninnm = pIwsDispstkeisyouninnm;
    }

    @Column(order = 153, length = 7)
    @MultiByte
    private String iwsDispstkeisyounintdk;

    public String getIwsDispstkeisyounintdk() {
        return iwsDispstkeisyounintdk;
    }

    public void setIwsDispstkeisyounintdk(String pIwsDispstkeisyounintdk) {
        iwsDispstkeisyounintdk = pIwsDispstkeisyounintdk;
    }

    @Column(order = 154, length = 9)
    private String iwsDispsetaitemosno;

    public String getIwsDispsetaitemosno() {
        return iwsDispsetaitemosno;
    }

    public void setIwsDispsetaitemosno(String pIwsDispsetaitemosno) {
        iwsDispsetaitemosno = pIwsDispsetaitemosno;
    }

    @Column(order = 155, length = 41)
    private String iwsDispknhjnnm;

    public String getIwsDispknhjnnm() {
        return iwsDispknhjnnm;
    }

    public void setIwsDispknhjnnm(String pIwsDispknhjnnm) {
        iwsDispknhjnnm = pIwsDispknhjnnm;
    }

    @Column(order = 156, length = 37)
    @MultiByte
    private String iwsDispkjhjnnm;

    public String getIwsDispkjhjnnm() {
        return iwsDispkjhjnnm;
    }

    public void setIwsDispkjhjnnm(String pIwsDispkjhjnnm) {
        iwsDispkjhjnnm = pIwsDispkjhjnnm;
    }

    @Column(order = 157, length = 10)
    @MultiByte
    private String iwsDisphrkkaisuu;

    public String getIwsDisphrkkaisuu() {
        return iwsDisphrkkaisuu;
    }

    public void setIwsDisphrkkaisuu(String pIwsDisphrkkaisuu) {
        iwsDisphrkkaisuu = pIwsDisphrkkaisuu;
    }

    @Column(order = 158, length = 9)
    @MultiByte
    private String iwsDisphrkkeiro;

    public String getIwsDisphrkkeiro() {
        return iwsDisphrkkeiro;
    }

    public void setIwsDisphrkkeiro(String pIwsDisphrkkeiro) {
        iwsDisphrkkeiro = pIwsDisphrkkeiro;
    }

    @Column(order = 159, length = 2)
    @MultiByte
    private String iwsDisplivingneedstkyk;

    public String getIwsDisplivingneedstkyk() {
        return iwsDisplivingneedstkyk;
    }

    public void setIwsDisplivingneedstkyk(String pIwsDisplivingneedstkyk) {
        iwsDisplivingneedstkyk = pIwsDisplivingneedstkyk;
    }

    @Column(order = 160, length = 2)
    @MultiByte
    private String iwsDispstdrsktkyk;

    public String getIwsDispstdrsktkyk() {
        return iwsDispstdrsktkyk;
    }

    public void setIwsDispstdrsktkyk(String pIwsDispstdrsktkyk) {
        iwsDispstdrsktkyk = pIwsDispstdrsktkyk;
    }

    @Column(order = 161, length = 60)
    @MultiByte
    private String iwsDispnkshrtkyk;

    public String getIwsDispnkshrtkyk() {
        return iwsDispnkshrtkyk;
    }

    public void setIwsDispnkshrtkyk(String pIwsDispnkshrtkyk) {
        iwsDispnkshrtkyk = pIwsDispnkshrtkyk;
    }

    @Column(order = 162, length = 6)
    @MultiByte
    private String iwsDispdrctservicemosnai;

    public String getIwsDispdrctservicemosnai() {
        return iwsDispdrctservicemosnai;
    }

    public void setIwsDispdrctservicemosnai(String pIwsDispdrctservicemosnai) {
        iwsDispdrctservicemosnai = pIwsDispdrctservicemosnai;
    }

    @Column(order = 163, length = 6)
    @MultiByte
    private String iwsDispcardmosnai;

    public String getIwsDispcardmosnai() {
        return iwsDispcardmosnai;
    }

    public void setIwsDispcardmosnai(String pIwsDispcardmosnai) {
        iwsDispcardmosnai = pIwsDispcardmosnai;
    }

    @Column(order = 164, length = 9)
    @MultiByte
    private String iwsDisphokenkngkmds;

    public String getIwsDisphokenkngkmds() {
        return iwsDisphokenkngkmds;
    }

    public void setIwsDisphokenkngkmds(String pIwsDisphokenkngkmds) {
        iwsDisphokenkngkmds = pIwsDisphokenkngkmds;
    }

    @Column(order = 165, length = 6)
    @MultiByte
    private String iwsDisphknkknmds;

    public String getIwsDisphknkknmds() {
        return iwsDisphknkknmds;
    }

    public void setIwsDisphknkknmds(String pIwsDisphknkknmds) {
        iwsDisphknkknmds = pIwsDisphknkknmds;
    }

    @Column(order = 166, length = 14)
    private String iwsDisphokenkngk;

    public String getIwsDisphokenkngk() {
        return iwsDisphokenkngk;
    }

    public void setIwsDisphokenkngk(String pIwsDisphokenkngk) {
        iwsDisphokenkngk = pIwsDisphokenkngk;
    }

    @Column(order = 167, length = 3)
    @MultiByte
    private String iwsDisphknkkn;

    public String getIwsDisphknkkn() {
        return iwsDisphknkkn;
    }

    public void setIwsDisphknkkn(String pIwsDisphknkkn) {
        iwsDisphknkkn = pIwsDisphknkkn;
    }

    @Column(order = 168, length = 14)
    private String iwsDisphokenryou;

    public String getIwsDisphokenryou() {
        return iwsDisphokenryou;
    }

    public void setIwsDisphokenryou(String pIwsDisphokenryou) {
        iwsDisphokenryou = pIwsDisphokenryou;
    }

    @Column(order = 169, length = 2)
    private String iwsDisptkbtknjdtllinecnt;

    public String getIwsDisptkbtknjdtllinecnt() {
        return iwsDisptkbtknjdtllinecnt;
    }

    public void setIwsDisptkbtknjdtllinecnt(String pIwsDisptkbtknjdtllinecnt) {
        iwsDisptkbtknjdtllinecnt = pIwsDisptkbtknjdtllinecnt;
    }

    @Column(order = 170, length = 15)
    @MultiByte
    private String iwsDispfundnmhidari01;

    public String getIwsDispfundnmhidari01() {
        return iwsDispfundnmhidari01;
    }

    public void setIwsDispfundnmhidari01(String pIwsDispfundnmhidari01) {
        iwsDispfundnmhidari01 = pIwsDispfundnmhidari01;
    }

    @Column(order = 171, length = 3)
    private String iwsDispfundwarihidari01;

    public String getIwsDispfundwarihidari01() {
        return iwsDispfundwarihidari01;
    }

    public void setIwsDispfundwarihidari01(String pIwsDispfundwarihidari01) {
        iwsDispfundwarihidari01 = pIwsDispfundwarihidari01;
    }

    @Column(order = 172, length = 15)
    @MultiByte
    private String iwsDispfundnmmigi01;

    public String getIwsDispfundnmmigi01() {
        return iwsDispfundnmmigi01;
    }

    public void setIwsDispfundnmmigi01(String pIwsDispfundnmmigi01) {
        iwsDispfundnmmigi01 = pIwsDispfundnmmigi01;
    }

    @Column(order = 173, length = 3)
    private String iwsDispfundwarimigi01;

    public String getIwsDispfundwarimigi01() {
        return iwsDispfundwarimigi01;
    }

    public void setIwsDispfundwarimigi01(String pIwsDispfundwarimigi01) {
        iwsDispfundwarimigi01 = pIwsDispfundwarimigi01;
    }

    @Column(order = 174, length = 15)
    @MultiByte
    private String iwsDispfundnmhidari02;

    public String getIwsDispfundnmhidari02() {
        return iwsDispfundnmhidari02;
    }

    public void setIwsDispfundnmhidari02(String pIwsDispfundnmhidari02) {
        iwsDispfundnmhidari02 = pIwsDispfundnmhidari02;
    }

    @Column(order = 175, length = 3)
    private String iwsDispfundwarihidari02;

    public String getIwsDispfundwarihidari02() {
        return iwsDispfundwarihidari02;
    }

    public void setIwsDispfundwarihidari02(String pIwsDispfundwarihidari02) {
        iwsDispfundwarihidari02 = pIwsDispfundwarihidari02;
    }

    @Column(order = 176, length = 15)
    @MultiByte
    private String iwsDispfundnmmigi02;

    public String getIwsDispfundnmmigi02() {
        return iwsDispfundnmmigi02;
    }

    public void setIwsDispfundnmmigi02(String pIwsDispfundnmmigi02) {
        iwsDispfundnmmigi02 = pIwsDispfundnmmigi02;
    }

    @Column(order = 177, length = 3)
    private String iwsDispfundwarimigi02;

    public String getIwsDispfundwarimigi02() {
        return iwsDispfundwarimigi02;
    }

    public void setIwsDispfundwarimigi02(String pIwsDispfundwarimigi02) {
        iwsDispfundwarimigi02 = pIwsDispfundwarimigi02;
    }

    @Column(order = 178, length = 15)
    @MultiByte
    private String iwsDispfundnmhidari03;

    public String getIwsDispfundnmhidari03() {
        return iwsDispfundnmhidari03;
    }

    public void setIwsDispfundnmhidari03(String pIwsDispfundnmhidari03) {
        iwsDispfundnmhidari03 = pIwsDispfundnmhidari03;
    }

    @Column(order = 179, length = 3)
    private String iwsDispfundwarihidari03;

    public String getIwsDispfundwarihidari03() {
        return iwsDispfundwarihidari03;
    }

    public void setIwsDispfundwarihidari03(String pIwsDispfundwarihidari03) {
        iwsDispfundwarihidari03 = pIwsDispfundwarihidari03;
    }

    @Column(order = 180, length = 15)
    @MultiByte
    private String iwsDispfundnmmigi03;

    public String getIwsDispfundnmmigi03() {
        return iwsDispfundnmmigi03;
    }

    public void setIwsDispfundnmmigi03(String pIwsDispfundnmmigi03) {
        iwsDispfundnmmigi03 = pIwsDispfundnmmigi03;
    }

    @Column(order = 181, length = 3)
    private String iwsDispfundwarimigi03;

    public String getIwsDispfundwarimigi03() {
        return iwsDispfundwarimigi03;
    }

    public void setIwsDispfundwarimigi03(String pIwsDispfundwarimigi03) {
        iwsDispfundwarimigi03 = pIwsDispfundwarimigi03;
    }

    @Column(order = 182, length = 15)
    @MultiByte
    private String iwsDispfundnmhidari04;

    public String getIwsDispfundnmhidari04() {
        return iwsDispfundnmhidari04;
    }

    public void setIwsDispfundnmhidari04(String pIwsDispfundnmhidari04) {
        iwsDispfundnmhidari04 = pIwsDispfundnmhidari04;
    }

    @Column(order = 183, length = 3)
    private String iwsDispfundwarihidari04;

    public String getIwsDispfundwarihidari04() {
        return iwsDispfundwarihidari04;
    }

    public void setIwsDispfundwarihidari04(String pIwsDispfundwarihidari04) {
        iwsDispfundwarihidari04 = pIwsDispfundwarihidari04;
    }

    @Column(order = 184, length = 15)
    @MultiByte
    private String iwsDispfundnmmigi04;

    public String getIwsDispfundnmmigi04() {
        return iwsDispfundnmmigi04;
    }

    public void setIwsDispfundnmmigi04(String pIwsDispfundnmmigi04) {
        iwsDispfundnmmigi04 = pIwsDispfundnmmigi04;
    }

    @Column(order = 185, length = 3)
    private String iwsDispfundwarimigi04;

    public String getIwsDispfundwarimigi04() {
        return iwsDispfundwarimigi04;
    }

    public void setIwsDispfundwarimigi04(String pIwsDispfundwarimigi04) {
        iwsDispfundwarimigi04 = pIwsDispfundwarimigi04;
    }

    @Column(order = 186, length = 15)
    @MultiByte
    private String iwsDispfundnmhidari05;

    public String getIwsDispfundnmhidari05() {
        return iwsDispfundnmhidari05;
    }

    public void setIwsDispfundnmhidari05(String pIwsDispfundnmhidari05) {
        iwsDispfundnmhidari05 = pIwsDispfundnmhidari05;
    }

    @Column(order = 187, length = 3)
    private String iwsDispfundwarihidari05;

    public String getIwsDispfundwarihidari05() {
        return iwsDispfundwarihidari05;
    }

    public void setIwsDispfundwarihidari05(String pIwsDispfundwarihidari05) {
        iwsDispfundwarihidari05 = pIwsDispfundwarihidari05;
    }

    @Column(order = 188, length = 15)
    @MultiByte
    private String iwsDispfundnmmigi05;

    public String getIwsDispfundnmmigi05() {
        return iwsDispfundnmmigi05;
    }

    public void setIwsDispfundnmmigi05(String pIwsDispfundnmmigi05) {
        iwsDispfundnmmigi05 = pIwsDispfundnmmigi05;
    }

    @Column(order = 189, length = 3)
    private String iwsDispfundwarimigi05;

    public String getIwsDispfundwarimigi05() {
        return iwsDispfundwarimigi05;
    }

    public void setIwsDispfundwarimigi05(String pIwsDispfundwarimigi05) {
        iwsDispfundwarimigi05 = pIwsDispfundwarimigi05;
    }

    @Column(order = 190, length = 15)
    @MultiByte
    private String iwsDispfundnmhidari06;

    public String getIwsDispfundnmhidari06() {
        return iwsDispfundnmhidari06;
    }

    public void setIwsDispfundnmhidari06(String pIwsDispfundnmhidari06) {
        iwsDispfundnmhidari06 = pIwsDispfundnmhidari06;
    }

    @Column(order = 191, length = 3)
    private String iwsDispfundwarihidari06;

    public String getIwsDispfundwarihidari06() {
        return iwsDispfundwarihidari06;
    }

    public void setIwsDispfundwarihidari06(String pIwsDispfundwarihidari06) {
        iwsDispfundwarihidari06 = pIwsDispfundwarihidari06;
    }

    @Column(order = 192, length = 15)
    @MultiByte
    private String iwsDispfundnmmigi06;

    public String getIwsDispfundnmmigi06() {
        return iwsDispfundnmmigi06;
    }

    public void setIwsDispfundnmmigi06(String pIwsDispfundnmmigi06) {
        iwsDispfundnmmigi06 = pIwsDispfundnmmigi06;
    }

    @Column(order = 193, length = 3)
    private String iwsDispfundwarimigi06;

    public String getIwsDispfundwarimigi06() {
        return iwsDispfundwarimigi06;
    }

    public void setIwsDispfundwarimigi06(String pIwsDispfundwarimigi06) {
        iwsDispfundwarimigi06 = pIwsDispfundwarimigi06;
    }

    @Column(order = 194, length = 15)
    @MultiByte
    private String iwsDispfundnmhidari07;

    public String getIwsDispfundnmhidari07() {
        return iwsDispfundnmhidari07;
    }

    public void setIwsDispfundnmhidari07(String pIwsDispfundnmhidari07) {
        iwsDispfundnmhidari07 = pIwsDispfundnmhidari07;
    }

    @Column(order = 195, length = 3)
    private String iwsDispfundwarihidari07;

    public String getIwsDispfundwarihidari07() {
        return iwsDispfundwarihidari07;
    }

    public void setIwsDispfundwarihidari07(String pIwsDispfundwarihidari07) {
        iwsDispfundwarihidari07 = pIwsDispfundwarihidari07;
    }

    @Column(order = 196, length = 15)
    @MultiByte
    private String iwsDispfundnmmigi07;

    public String getIwsDispfundnmmigi07() {
        return iwsDispfundnmmigi07;
    }

    public void setIwsDispfundnmmigi07(String pIwsDispfundnmmigi07) {
        iwsDispfundnmmigi07 = pIwsDispfundnmmigi07;
    }

    @Column(order = 197, length = 3)
    private String iwsDispfundwarimigi07;

    public String getIwsDispfundwarimigi07() {
        return iwsDispfundwarimigi07;
    }

    public void setIwsDispfundwarimigi07(String pIwsDispfundwarimigi07) {
        iwsDispfundwarimigi07 = pIwsDispfundwarimigi07;
    }

    @Column(order = 198, length = 15)
    @MultiByte
    private String iwsDispfundnmhidari08;

    public String getIwsDispfundnmhidari08() {
        return iwsDispfundnmhidari08;
    }

    public void setIwsDispfundnmhidari08(String pIwsDispfundnmhidari08) {
        iwsDispfundnmhidari08 = pIwsDispfundnmhidari08;
    }

    @Column(order = 199, length = 3)
    private String iwsDispfundwarihidari08;

    public String getIwsDispfundwarihidari08() {
        return iwsDispfundwarihidari08;
    }

    public void setIwsDispfundwarihidari08(String pIwsDispfundwarihidari08) {
        iwsDispfundwarihidari08 = pIwsDispfundwarihidari08;
    }

    @Column(order = 200, length = 15)
    @MultiByte
    private String iwsDispfundnmmigi08;

    public String getIwsDispfundnmmigi08() {
        return iwsDispfundnmmigi08;
    }

    public void setIwsDispfundnmmigi08(String pIwsDispfundnmmigi08) {
        iwsDispfundnmmigi08 = pIwsDispfundnmmigi08;
    }

    @Column(order = 201, length = 3)
    private String iwsDispfundwarimigi08;

    public String getIwsDispfundwarimigi08() {
        return iwsDispfundwarimigi08;
    }

    public void setIwsDispfundwarimigi08(String pIwsDispfundwarimigi08) {
        iwsDispfundwarimigi08 = pIwsDispfundwarimigi08;
    }

    @Column(order = 202, length = 15)
    @MultiByte
    private String iwsDispfundnmhidari09;

    public String getIwsDispfundnmhidari09() {
        return iwsDispfundnmhidari09;
    }

    public void setIwsDispfundnmhidari09(String pIwsDispfundnmhidari09) {
        iwsDispfundnmhidari09 = pIwsDispfundnmhidari09;
    }

    @Column(order = 203, length = 3)
    private String iwsDispfundwarihidari09;

    public String getIwsDispfundwarihidari09() {
        return iwsDispfundwarihidari09;
    }

    public void setIwsDispfundwarihidari09(String pIwsDispfundwarihidari09) {
        iwsDispfundwarihidari09 = pIwsDispfundwarihidari09;
    }

    @Column(order = 204, length = 15)
    @MultiByte
    private String iwsDispfundnmmigi09;

    public String getIwsDispfundnmmigi09() {
        return iwsDispfundnmmigi09;
    }

    public void setIwsDispfundnmmigi09(String pIwsDispfundnmmigi09) {
        iwsDispfundnmmigi09 = pIwsDispfundnmmigi09;
    }

    @Column(order = 205, length = 3)
    private String iwsDispfundwarimigi09;

    public String getIwsDispfundwarimigi09() {
        return iwsDispfundwarimigi09;
    }

    public void setIwsDispfundwarimigi09(String pIwsDispfundwarimigi09) {
        iwsDispfundwarimigi09 = pIwsDispfundwarimigi09;
    }

    @Column(order = 206, length = 15)
    @MultiByte
    private String iwsDispfundnmhidari10;

    public String getIwsDispfundnmhidari10() {
        return iwsDispfundnmhidari10;
    }

    public void setIwsDispfundnmhidari10(String pIwsDispfundnmhidari10) {
        iwsDispfundnmhidari10 = pIwsDispfundnmhidari10;
    }

    @Column(order = 207, length = 3)
    private String iwsDispfundwarihidari10;

    public String getIwsDispfundwarihidari10() {
        return iwsDispfundwarihidari10;
    }

    public void setIwsDispfundwarihidari10(String pIwsDispfundwarihidari10) {
        iwsDispfundwarihidari10 = pIwsDispfundwarihidari10;
    }

    @Column(order = 208, length = 15)
    @MultiByte
    private String iwsDispfundnmmigi10;

    public String getIwsDispfundnmmigi10() {
        return iwsDispfundnmmigi10;
    }

    public void setIwsDispfundnmmigi10(String pIwsDispfundnmmigi10) {
        iwsDispfundnmmigi10 = pIwsDispfundnmmigi10;
    }

    @Column(order = 209, length = 3)
    private String iwsDispfundwarimigi10;

    public String getIwsDispfundwarimigi10() {
        return iwsDispfundwarimigi10;
    }

    public void setIwsDispfundwarimigi10(String pIwsDispfundwarimigi10) {
        iwsDispfundwarimigi10 = pIwsDispfundwarimigi10;
    }

    @Column(order = 210, length = 6)
    @MultiByte
    private String iwsDisphrkkknmds;

    public String getIwsDisphrkkknmds() {
        return iwsDisphrkkknmds;
    }

    public void setIwsDisphrkkknmds(String pIwsDisphrkkknmds) {
        iwsDisphrkkknmds = pIwsDisphrkkknmds;
    }

    @Column(order = 211, length = 4)
    @MultiByte
    private String iwsDisphrkkkn;

    public String getIwsDisphrkkkn() {
        return iwsDisphrkkkn;
    }

    public void setIwsDisphrkkkn(String pIwsDisphrkkkn) {
        iwsDisphrkkkn = pIwsDisphrkkkn;
    }

    @Column(order = 212, length = 4)
    @MultiByte
    private String iwsDispmkhyoututtosrsmosnai;

    public String getIwsDispmkhyoututtosrsmosnai() {
        return iwsDispmkhyoututtosrsmosnai;
    }

    public void setIwsDispmkhyoututtosrsmosnai(String pIwsDispmkhyoututtosrsmosnai) {
        iwsDispmkhyoututtosrsmosnai = pIwsDispmkhyoututtosrsmosnai;
    }

    @Column(order = 213, length = 4)
    @MultiByte
    private String iwsDispteikaiyakuhrkkn;

    public String getIwsDispteikaiyakuhrkkn() {
        return iwsDispteikaiyakuhrkkn;
    }

    public void setIwsDispteikaiyakuhrkkn(String pIwsDispteikaiyakuhrkkn) {
        iwsDispteikaiyakuhrkkn = pIwsDispteikaiyakuhrkkn;
    }

    @Column(order = 214, length = 1)
    private String iwsDispprskngkutuktnikbn01;

    public String getIwsDispprskngkutuktnikbn01() {
        return iwsDispprskngkutuktnikbn01;
    }

    public void setIwsDispprskngkutuktnikbn01(String pIwsDispprskngkutuktnikbn01) {
        iwsDispprskngkutuktnikbn01 = pIwsDispprskngkutuktnikbn01;
    }

    @Column(order = 215, length = 1)
    private String iwsDispprskngkutuktnikbn02;

    public String getIwsDispprskngkutuktnikbn02() {
        return iwsDispprskngkutuktnikbn02;
    }

    public void setIwsDispprskngkutuktnikbn02(String pIwsDispprskngkutuktnikbn02) {
        iwsDispprskngkutuktnikbn02 = pIwsDispprskngkutuktnikbn02;
    }

    @Column(order = 216, length = 1)
    private String iwsDispprskngkutuktnikbn03;

    public String getIwsDispprskngkutuktnikbn03() {
        return iwsDispprskngkutuktnikbn03;
    }

    public void setIwsDispprskngkutuktnikbn03(String pIwsDispprskngkutuktnikbn03) {
        iwsDispprskngkutuktnikbn03 = pIwsDispprskngkutuktnikbn03;
    }

    @Column(order = 217, length = 1)
    private String iwsDispprskngkutuktnikbn04;

    public String getIwsDispprskngkutuktnikbn04() {
        return iwsDispprskngkutuktnikbn04;
    }

    public void setIwsDispprskngkutuktnikbn04(String pIwsDispprskngkutuktnikbn04) {
        iwsDispprskngkutuktnikbn04 = pIwsDispprskngkutuktnikbn04;
    }

    @Column(order = 218, length = 1)
    private String iwsDisphnkngktuktnikbn01;

    public String getIwsDisphnkngktuktnikbn01() {
        return iwsDisphnkngktuktnikbn01;
    }

    public void setIwsDisphnkngktuktnikbn01(String pIwsDisphnkngktuktnikbn01) {
        iwsDisphnkngktuktnikbn01 = pIwsDisphnkngktuktnikbn01;
    }

    @Column(order = 219, length = 1)
    private String iwsDisphnkngktuktnikbn02;

    public String getIwsDisphnkngktuktnikbn02() {
        return iwsDisphnkngktuktnikbn02;
    }

    public void setIwsDisphnkngktuktnikbn02(String pIwsDisphnkngktuktnikbn02) {
        iwsDisphnkngktuktnikbn02 = pIwsDisphnkngktuktnikbn02;
    }

    @Column(order = 220, length = 1)
    private String iwsDisphnkngktuktnikbn03;

    public String getIwsDisphnkngktuktnikbn03() {
        return iwsDisphnkngktuktnikbn03;
    }

    public void setIwsDisphnkngktuktnikbn03(String pIwsDisphnkngktuktnikbn03) {
        iwsDisphnkngktuktnikbn03 = pIwsDisphnkngktuktnikbn03;
    }

    @Column(order = 221, length = 1)
    private String iwsDisphnkngktuktnikbn04;

    public String getIwsDisphnkngktuktnikbn04() {
        return iwsDisphnkngktuktnikbn04;
    }

    public void setIwsDisphnkngktuktnikbn04(String pIwsDisphnkngktuktnikbn04) {
        iwsDisphnkngktuktnikbn04 = pIwsDisphnkngktuktnikbn04;
    }

    @Column(order = 222, length = 1)
    private String iwsDisptkuktrknshrtuktnikbn;

    public String getIwsDisptkuktrknshrtuktnikbn() {
        return iwsDisptkuktrknshrtuktnikbn;
    }

    public void setIwsDisptkuktrknshrtuktnikbn(String pIwsDisptkuktrknshrtuktnikbn) {
        iwsDisptkuktrknshrtuktnikbn = pIwsDisptkuktrknshrtuktnikbn;
    }

    @Column(order = 223, length = 9)
    @MultiByte
    private String iwsDisptkuktrknshrtukmds;

    public String getIwsDisptkuktrknshrtukmds() {
        return iwsDisptkuktrknshrtukmds;
    }

    public void setIwsDisptkuktrknshrtukmds(String pIwsDisptkuktrknshrtukmds) {
        iwsDisptkuktrknshrtukmds = pIwsDisptkuktrknshrtukmds;
    }

    @Column(order = 224, length = 1)
    private String iwsDisphrktuktnikbn;

    public String getIwsDisphrktuktnikbn() {
        return iwsDisphrktuktnikbn;
    }

    public void setIwsDisphrktuktnikbn(String pIwsDisphrktuktnikbn) {
        iwsDisphrktuktnikbn = pIwsDisphrktuktnikbn;
    }

    @Column(order = 225, length = 25)
    @MultiByte
    private String iwsDisphrktkyknm;

    public String getIwsDisphrktkyknm() {
        return iwsDisphrktkyknm;
    }

    public void setIwsDisphrktkyknm(String pIwsDisphrktkyknm) {
        iwsDisphrktkyknm = pIwsDisphrktkyknm;
    }

    @Column(order = 226, length = 14)
    private String iwsDisphrkgk;

    public String getIwsDisphrkgk() {
        return iwsDisphrkgk;
    }

    public void setIwsDisphrkgk(String pIwsDisphrkgk) {
        iwsDisphrkgk = pIwsDisphrkgk;
    }

    @Column(order = 227, length = 1)
    private String iwsDispkyktuktnikbn;

    public String getIwsDispkyktuktnikbn() {
        return iwsDispkyktuktnikbn;
    }

    public void setIwsDispkyktuktnikbn(String pIwsDispkyktuktnikbn) {
        iwsDispkyktuktnikbn = pIwsDispkyktuktnikbn;
    }

    @Column(order = 228, length = 8)
    private String iwsDispkwsratetekiymd;

    public String getIwsDispkwsratetekiymd() {
        return iwsDispkwsratetekiymd;
    }

    public void setIwsDispkwsratetekiymd(String pIwsDispkwsratetekiymd) {
        iwsDispkwsratetekiymd = pIwsDispkwsratetekiymd;
    }

    @Column(order = 229, length = 1)
    private String iwsDispkwsratemdstuktnikbn;

    public String getIwsDispkwsratemdstuktnikbn() {
        return iwsDispkwsratemdstuktnikbn;
    }

    public void setIwsDispkwsratemdstuktnikbn(String pIwsDispkwsratemdstuktnikbn) {
        iwsDispkwsratemdstuktnikbn = pIwsDispkwsratemdstuktnikbn;
    }

    @Column(order = 230, length = 6)
    private String iwsDispkwsrate;

    public String getIwsDispkwsrate() {
        return iwsDispkwsrate;
    }

    public void setIwsDispkwsrate(String pIwsDispkwsrate) {
        iwsDispkwsrate = pIwsDispkwsrate;
    }

    @Column(order = 231, length = 1)
    private String iwsDisphokenkngktuktnikbn;

    public String getIwsDisphokenkngktuktnikbn() {
        return iwsDisphokenkngktuktnikbn;
    }

    public void setIwsDisphokenkngktuktnikbn(String pIwsDisphokenkngktuktnikbn) {
        iwsDisphokenkngktuktnikbn = pIwsDisphokenkngktuktnikbn;
    }

    @Column(order = 232, length = 1)
    private String iwsDispptuktnikbn;

    public String getIwsDispptuktnikbn() {
        return iwsDispptuktnikbn;
    }

    public void setIwsDispptuktnikbn(String pIwsDispptuktnikbn) {
        iwsDispptuktnikbn = pIwsDispptuktnikbn;
    }

    @Column(order = 233, length = 25)
    @MultiByte
    private String iwsDisptargettkyknm;

    public String getIwsDisptargettkyknm() {
        return iwsDisptargettkyknm;
    }

    public void setIwsDisptargettkyknm(String pIwsDisptargettkyknm) {
        iwsDisptargettkyknm = pIwsDisptargettkyknm;
    }

    @Column(order = 234, length = 3)
    @MaxLength(max=3)
    @SingleByteStrings
    private String iwsDisphokensyuruino;

    public String getIwsDisphokensyuruino() {
        return iwsDisphokensyuruino;
    }

    public void setIwsDisphokensyuruino(String pIwsDisphokensyuruino) {
        iwsDisphokensyuruino = pIwsDisphokensyuruino;
    }

    @Column(order = 235, length = 1)
    private String iwsDispstitukhrktukditkbn;

    public String getIwsDispstitukhrktukditkbn() {
        return iwsDispstitukhrktukditkbn;
    }

    public void setIwsDispstitukhrktukditkbn(String pIwsDispstitukhrktukditkbn) {
        iwsDispstitukhrktukditkbn = pIwsDispstitukhrktukditkbn;
    }

    @Column(order = 236, length = 1)
    private String iwsDispnyknzumihyouji;

    public String getIwsDispnyknzumihyouji() {
        return iwsDispnyknzumihyouji;
    }

    public void setIwsDispnyknzumihyouji(String pIwsDispnyknzumihyouji) {
        iwsDispnyknzumihyouji = pIwsDispnyknzumihyouji;
    }

    @Column(order = 237, length = 2)
    @MultiByte
    private String iwsDispSyksbyensitihsyutkyk;

    public String getIwsDispSyksbyensitihsyutkyk() {
        return iwsDispSyksbyensitihsyutkyk;
    }

    public void setIwsDispSyksbyensitihsyutkyk(String pIwsDispSyksbyensitihsyutkyk) {
        iwsDispSyksbyensitihsyutkyk = pIwsDispSyksbyensitihsyutkyk;
    }

    @Column(order = 238, length = 2)
    @MultiByte
    private String iwsDispJyudkaigomehrtkyk;

    public String getIwsDispJyudkaigomehrtkyk() {
        return iwsDispJyudkaigomehrtkyk;
    }

    public void setIwsDispJyudkaigomehrtkyk(String pIwsDispJyudkaigomehrtkyk) {
        iwsDispJyudkaigomehrtkyk = pIwsDispJyudkaigomehrtkyk;
    }

    @Column(order = 239, length = 14)
    private String iwsDispmkhgk;

    public String getIwsDispmkhgk() {
        return iwsDispmkhgk;
    }

    public void setIwsDispmkhgk(String pIwsDispmkhgk) {
        iwsDispmkhgk = pIwsDispmkhgk;
    }

    @Column(order = 240, length = 14)
    private String iwsDispkjnkngk;

    public String getIwsDispkjnkngk() {
        return iwsDispkjnkngk;
    }

    public void setIwsDispkjnkngk(String pIwsDispkjnkngk) {
        iwsDispkjnkngk = pIwsDispkjnkngk;
    }

    @Column(order = 241, length = 6)
    @MultiByte
    private String iwsDispkijyunkingakumds;

    public String getIwsDispkijyunkingakumds() {
        return iwsDispkijyunkingakumds;
    }

    public void setIwsDispkijyunkingakumds(String pIwsDispkijyunkingakumds) {
        iwsDispkijyunkingakumds = pIwsDispkijyunkingakumds;
    }

    @Column(order = 242, length = 3)
    @MultiByte
    private String iwsDispsueokikkn;

    public String getIwsDispsueokikkn() {
        return iwsDispsueokikkn;
    }

    public void setIwsDispsueokikkn(String pIwsDispsueokikkn) {
        iwsDispsueokikkn = pIwsDispsueokikkn;
    }

    @Column(order = 243, length = 15)
    @MultiByte
    private String iwsDispnenkinsyu;

    public String getIwsDispnenkinsyu() {
        return iwsDispnenkinsyu;
    }

    public void setIwsDispnenkinsyu(String pIwsDispnenkinsyu) {
        iwsDispnenkinsyu = pIwsDispnenkinsyu;
    }

    @Column(order = 244, length = 50)
    @MultiByte
    private String iwsDisptumitatekintypenm;

    public String getIwsDisptumitatekintypenm() {
        return iwsDisptumitatekintypenm;
    }

    public void setIwsDisptumitatekintypenm(String pIwsDisptumitatekintypenm) {
        iwsDisptumitatekintypenm = pIwsDisptumitatekintypenm;
    }

    @Column(order = 245, length = 50)
    @MultiByte
    private String iwsDispsisuunm;

    public String getIwsDispsisuunm() {
        return iwsDispsisuunm;
    }

    public void setIwsDispsisuunm(String pIwsDispsisuunm) {
        iwsDispsisuunm = pIwsDispsisuunm;
    }

    @Column(order = 246, length = 2)
    @MultiByte
    private String iwsDispkjnnkpzeitekitk;

    public String getIwsDispkjnnkpzeitekitk() {
        return iwsDispkjnnkpzeitekitk;
    }

    public void setIwsDispkjnnkpzeitekitk(String pIwsDispkjnnkpzeitekitk) {
        iwsDispkjnnkpzeitekitk = pIwsDispkjnnkpzeitekitk;
    }

    @Column(order = 247, length = 10)
    @MultiByte
    private String iwsDisppmds;

    public String getIwsDisppmds() {
        return iwsDisppmds;
    }

    public void setIwsDisppmds(String pIwsDisppmds) {
        iwsDisppmds = pIwsDisppmds;
    }

    @Column(order = 248, length = 14)
    private String iwsDisptikiktbriyenhrkgk;

    public String getIwsDisptikiktbriyenhrkgk() {
        return iwsDisptikiktbriyenhrkgk;
    }

    public void setIwsDisptikiktbriyenhrkgk(String pIwsDisptikiktbriyenhrkgk) {
        iwsDisptikiktbriyenhrkgk = pIwsDisptikiktbriyenhrkgk;
    }

    @Column(order = 249, length = 14)
    private String iwsDispznntikiktbriyenhrkgk;

    public String getIwsDispznntikiktbriyenhrkgk() {
        return iwsDispznntikiktbriyenhrkgk;
    }

    public void setIwsDispznntikiktbriyenhrkgk(String pIwsDispznntikiktbriyenhrkgk) {
        iwsDispznntikiktbriyenhrkgk = pIwsDispznntikiktbriyenhrkgk;
    }

    @Column(order = 250, length = 8)
    @MultiByte
    private String iwsDispstdrsktkymds;

    public String getIwsDispstdrsktkymds() {
        return iwsDispstdrsktkymds;
    }

    public void setIwsDispstdrsktkymds(String pIwsDispstdrsktkymds) {
        iwsDispstdrsktkymds = pIwsDispstdrsktkymds;
    }

    @Column(order = 251, length = 8)
    private String iwsDispstdrskseiymd;

    public String getIwsDispstdrskseiymd() {
        return iwsDispstdrskseiymd;
    }

    public void setIwsDispstdrskseiymd(String pIwsDispstdrskseiymd) {
        iwsDispstdrskseiymd = pIwsDispstdrskseiymd;
    }

    @Column(order = 252, length = 2)
    @MultiByte
    private String iwsDispkykdrtky;

    public String getIwsDispkykdrtky() {
        return iwsDispkykdrtky;
    }

    public void setIwsDispkykdrtky(String pIwsDispkykdrtky) {
        iwsDispkykdrtky = pIwsDispkykdrtky;
    }

    @Column(order = 253, length = 10)
    @MultiByte
    private String iwsDispkykdrtkynm;

    public String getIwsDispkykdrtkynm() {
        return iwsDispkykdrtkynm;
    }

    public void setIwsDispkykdrtkynm(String pIwsDispkykdrtkynm) {
        iwsDispkykdrtkynm = pIwsDispkykdrtkynm;
    }

    @Column(order = 254, length = 6)
    @MultiByte
    private String iwsDispkzktrkservice;

    public String getIwsDispkzktrkservice() {
        return iwsDispkzktrkservice;
    }

    public void setIwsDispkzktrkservice(String pIwsDispkzktrkservice) {
        iwsDispkzktrkservice = pIwsDispkzktrkservice;
    }

    @Column(order = 255, length = 3)
    @MultiByte
    private String iwsDisptrkkzk01;

    public String getIwsDisptrkkzk01() {
        return iwsDisptrkkzk01;
    }

    public void setIwsDisptrkkzk01(String pIwsDisptrkkzk01) {
        iwsDisptrkkzk01 = pIwsDisptrkkzk01;
    }

    @Column(order = 256, length = 18)
    private String iwsDisptrkkzkknnm01;

    public String getIwsDisptrkkzkknnm01() {
        return iwsDisptrkkzkknnm01;
    }

    public void setIwsDisptrkkzkknnm01(String pIwsDisptrkkzkknnm01) {
        iwsDisptrkkzkknnm01 = pIwsDisptrkkzkknnm01;
    }

    @Column(order = 257, length = 15)
    @MultiByte
    private String iwsDisptrkkzkkjnm01;

    public String getIwsDisptrkkzkkjnm01() {
        return iwsDisptrkkzkkjnm01;
    }

    public void setIwsDisptrkkzkkjnm01(String pIwsDisptrkkzkkjnm01) {
        iwsDisptrkkzkkjnm01 = pIwsDisptrkkzkkjnm01;
    }

    @Column(order = 258, length = 8)
    private String iwsDisptrkkzkseiymd01;

    public String getIwsDisptrkkzkseiymd01() {
        return iwsDisptrkkzkseiymd01;
    }

    public void setIwsDisptrkkzkseiymd01(String pIwsDisptrkkzkseiymd01) {
        iwsDisptrkkzkseiymd01 = pIwsDisptrkkzkseiymd01;
    }

    @Column(order = 259, length = 2)
    @MultiByte
    private String iwsDisptrkkzksei01;

    public String getIwsDisptrkkzksei01() {
        return iwsDisptrkkzksei01;
    }

    public void setIwsDisptrkkzksei01(String pIwsDisptrkkzksei01) {
        iwsDisptrkkzksei01 = pIwsDisptrkkzksei01;
    }

    @Column(order = 260, length = 8)
    private String iwsDisptrkkzkyno01;

    public String getIwsDisptrkkzkyno01() {
        return iwsDisptrkkzkyno01;
    }

    public void setIwsDisptrkkzkyno01(String pIwsDisptrkkzkyno01) {
        iwsDisptrkkzkyno01 = pIwsDisptrkkzkyno01;
    }

    @Column(order = 261, length = 62)
    @MultiByte
    private String iwsDisptrkkzkadr1x01;

    public String getIwsDisptrkkzkadr1x01() {
        return iwsDisptrkkzkadr1x01;
    }

    public void setIwsDisptrkkzkadr1x01(String pIwsDisptrkkzkadr1x01) {
        iwsDisptrkkzkadr1x01 = pIwsDisptrkkzkadr1x01;
    }

    @Column(order = 262, length = 62)
    @MultiByte
    private String iwsDisptrkkzkadr2x01;

    public String getIwsDisptrkkzkadr2x01() {
        return iwsDisptrkkzkadr2x01;
    }

    public void setIwsDisptrkkzkadr2x01(String pIwsDisptrkkzkadr2x01) {
        iwsDisptrkkzkadr2x01 = pIwsDisptrkkzkadr2x01;
    }

    @Column(order = 263, length = 14)
    private String iwsDisptrkkzktelno01;

    public String getIwsDisptrkkzktelno01() {
        return iwsDisptrkkzktelno01;
    }

    public void setIwsDisptrkkzktelno01(String pIwsDisptrkkzktelno01) {
        iwsDisptrkkzktelno01 = pIwsDisptrkkzktelno01;
    }

    @Column(order = 264, length = 7)
    @MultiByte
    private String iwsDisptrkkzktdk01;

    public String getIwsDisptrkkzktdk01() {
        return iwsDisptrkkzktdk01;
    }

    public void setIwsDisptrkkzktdk01(String pIwsDisptrkkzktdk01) {
        iwsDisptrkkzktdk01 = pIwsDisptrkkzktdk01;
    }

    @Column(order = 265, length = 3)
    @MultiByte
    private String iwsDisptrkkzk02;

    public String getIwsDisptrkkzk02() {
        return iwsDisptrkkzk02;
    }

    public void setIwsDisptrkkzk02(String pIwsDisptrkkzk02) {
        iwsDisptrkkzk02 = pIwsDisptrkkzk02;
    }

    @Column(order = 266, length = 18)
    private String iwsDisptrkkzkknnm02;

    public String getIwsDisptrkkzkknnm02() {
        return iwsDisptrkkzkknnm02;
    }

    public void setIwsDisptrkkzkknnm02(String pIwsDisptrkkzkknnm02) {
        iwsDisptrkkzkknnm02 = pIwsDisptrkkzkknnm02;
    }

    @Column(order = 267, length = 15)
    @MultiByte
    private String iwsDisptrkkzkkjnm02;

    public String getIwsDisptrkkzkkjnm02() {
        return iwsDisptrkkzkkjnm02;
    }

    public void setIwsDisptrkkzkkjnm02(String pIwsDisptrkkzkkjnm02) {
        iwsDisptrkkzkkjnm02 = pIwsDisptrkkzkkjnm02;
    }

    @Column(order = 268, length = 8)
    private String iwsDisptrkkzkseiymd02;

    public String getIwsDisptrkkzkseiymd02() {
        return iwsDisptrkkzkseiymd02;
    }

    public void setIwsDisptrkkzkseiymd02(String pIwsDisptrkkzkseiymd02) {
        iwsDisptrkkzkseiymd02 = pIwsDisptrkkzkseiymd02;
    }

    @Column(order = 269, length = 2)
    @MultiByte
    private String iwsDisptrkkzksei02;

    public String getIwsDisptrkkzksei02() {
        return iwsDisptrkkzksei02;
    }

    public void setIwsDisptrkkzksei02(String pIwsDisptrkkzksei02) {
        iwsDisptrkkzksei02 = pIwsDisptrkkzksei02;
    }

    @Column(order = 270, length = 8)
    private String iwsDisptrkkzkyno02;

    public String getIwsDisptrkkzkyno02() {
        return iwsDisptrkkzkyno02;
    }

    public void setIwsDisptrkkzkyno02(String pIwsDisptrkkzkyno02) {
        iwsDisptrkkzkyno02 = pIwsDisptrkkzkyno02;
    }

    @Column(order = 271, length = 62)
    @MultiByte
    private String iwsDisptrkkzkadr1x02;

    public String getIwsDisptrkkzkadr1x02() {
        return iwsDisptrkkzkadr1x02;
    }

    public void setIwsDisptrkkzkadr1x02(String pIwsDisptrkkzkadr1x02) {
        iwsDisptrkkzkadr1x02 = pIwsDisptrkkzkadr1x02;
    }

    @Column(order = 272, length = 62)
    @MultiByte
    private String iwsDisptrkkzkadr2x02;

    public String getIwsDisptrkkzkadr2x02() {
        return iwsDisptrkkzkadr2x02;
    }

    public void setIwsDisptrkkzkadr2x02(String pIwsDisptrkkzkadr2x02) {
        iwsDisptrkkzkadr2x02 = pIwsDisptrkkzkadr2x02;
    }

    @Column(order = 273, length = 14)
    private String iwsDisptrkkzktelno02;

    public String getIwsDisptrkkzktelno02() {
        return iwsDisptrkkzktelno02;
    }

    public void setIwsDisptrkkzktelno02(String pIwsDisptrkkzktelno02) {
        iwsDisptrkkzktelno02 = pIwsDisptrkkzktelno02;
    }

    @Column(order = 274, length = 7)
    @MultiByte
    private String iwsDisptrkkzktdk02;

    public String getIwsDisptrkkzktdk02() {
        return iwsDisptrkkzktdk02;
    }

    public void setIwsDisptrkkzktdk02(String pIwsDisptrkkzktdk02) {
        iwsDisptrkkzktdk02 = pIwsDisptrkkzktdk02;
    }

    @Column(order = 275, length = 10)
    private String iwsDispsioriyakkansearchcd;

    public String getIwsDispsioriyakkansearchcd() {
        return iwsDispsioriyakkansearchcd;
    }

    public void setIwsDispsioriyakkansearchcd(String pIwsDispsioriyakkansearchcd) {
        iwsDispsioriyakkansearchcd = pIwsDispsioriyakkansearchcd;
    }

    @Column(order = 276, length = 22)
    @MultiByte
    private String iwsDispyakkanjyuryouhou;

    public String getIwsDispyakkanjyuryouhou() {
        return iwsDispyakkanjyuryouhou;
    }

    public void setIwsDispyakkanjyuryouhou(String pIwsDispyakkanjyuryouhou) {
        iwsDispyakkanjyuryouhou = pIwsDispyakkanjyuryouhou;
    }

    @Column(order = 277, length = 9)
    @MultiByte
    private String iwsDispkyktuktnikbnmidasi;

    public String getIwsDispkyktuktnikbnmidasi() {
        return iwsDispkyktuktnikbnmidasi;
    }

    public void setIwsDispkyktuktnikbnmidasi(String pIwsDispkyktuktnikbnmidasi) {
        iwsDispkyktuktnikbnmidasi = pIwsDispkyktuktnikbnmidasi;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
