package yuyu.def.biz.bean.mq;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.file.description.annotations.MultiByte;
import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import yuyu.infr.validation.constraints.Tel;

/**
 * （共通）ＭＱ索引通算照会与件BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzMqSakuinTsnSyoukaiYokenBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzMqSakuinTsnSyoukaiYokenBean() {
    }

    @Column(order = 1, length = 4)
    @NotNull
    private String iwsSyoricd;

    public String getIwsSyoricd() {
        return iwsSyoricd;
    }

    public void setIwsSyoricd(String pIwsSyoricd) {
        iwsSyoricd = pIwsSyoricd;
    }

    @Column(order = 2, length = 1)
    @NotNull
    private String iwsKugirihugou;

    public String getIwsKugirihugou() {
        return iwsKugirihugou;
    }

    public void setIwsKugirihugou(String pIwsKugirihugou) {
        iwsKugirihugou = pIwsKugirihugou;
    }

    @Column(order = 3, length = 1)
    @NotNull
    private String iwsSkintsnsyoukaikbn;

    public String getIwsSkintsnsyoukaikbn() {
        return iwsSkintsnsyoukaikbn;
    }

    public void setIwsSkintsnsyoukaikbn(String pIwsSkintsnsyoukaikbn) {
        iwsSkintsnsyoukaikbn = pIwsSkintsnsyoukaikbn;
    }

    @Column(order = 4, length = 1)
    @NotNull
    private String iwsHuho2kyknokbn;

    public String getIwsHuho2kyknokbn() {
        return iwsHuho2kyknokbn;
    }

    public void setIwsHuho2kyknokbn(String pIwsHuho2kyknokbn) {
        iwsHuho2kyknokbn = pIwsHuho2kyknokbn;
    }

    @Column(order = 5, length = 11)
    @NotNull
    private String iwsHuho2kykno;

    public String getIwsHuho2kykno() {
        return iwsHuho2kykno;
    }

    public void setIwsHuho2kykno(String pIwsHuho2kykno) {
        iwsHuho2kykno = pIwsHuho2kykno;
    }

    @Column(order = 6, length = 1)
    @NotNull
    private String iwsTaisyoukbn;

    public String getIwsTaisyoukbn() {
        return iwsTaisyoukbn;
    }

    public void setIwsTaisyoukbn(String pIwsTaisyoukbn) {
        iwsTaisyoukbn = pIwsTaisyoukbn;
    }

    @Column(order = 7, length = 18)
    @NotNull
    private String iwsHankakutaisyounm;

    public String getIwsHankakutaisyounm() {
        return iwsHankakutaisyounm;
    }

    public void setIwsHankakutaisyounm(String pIwsHankakutaisyounm) {
        iwsHankakutaisyounm = pIwsHankakutaisyounm;
    }

    @Column(order = 8, length = 15)
    @MultiByte
    @NotNull
    private String iwsKjtaisyounm;

    public String getIwsKjtaisyounm() {
        return iwsKjtaisyounm;
    }

    @DataConvert("toMultiByte")
    public void setIwsKjtaisyounm(String pIwsKjtaisyounm) {
        iwsKjtaisyounm = pIwsKjtaisyounm;
    }

    @Column(order = 9, length = 8)
    @NotNull
    private BizDate iwsTaisyouseiymd;

    public BizDate getIwsTaisyouseiymd() {
        return iwsTaisyouseiymd;
    }

    public void setIwsTaisyouseiymd(BizDate pIwsTaisyouseiymd) {
        iwsTaisyouseiymd = pIwsTaisyouseiymd;
    }

    @Column(order = 10, length = 7)
    @NotNull
    private String iwsTaisyouyno;

    public String getIwsTaisyouyno() {
        return iwsTaisyouyno;
    }

    public void setIwsTaisyouyno(String pIwsTaisyouyno) {
        iwsTaisyouyno = pIwsTaisyouyno;
    }

    @Column(order = 11, length = 7)
    @NotNull
    private String iwsHhknnewyno;

    public String getIwsHhknnewyno() {
        return iwsHhknnewyno;
    }

    public void setIwsHhknnewyno(String pIwsHhknnewyno) {
        iwsHhknnewyno = pIwsHhknnewyno;
    }

    @Column(order = 12, length = 3)
    @NotNull
    private String iwsHhknsyokugyoucd;

    public String getIwsHhknsyokugyoucd() {
        return iwsHhknsyokugyoucd;
    }

    public void setIwsHhknsyokugyoucd(String pIwsHhknsyokugyoucd) {
        iwsHhknsyokugyoucd = pIwsHhknsyokugyoucd;
    }

    @Column(order = 13, length = 18)
    @NotNull
    private String iwsHankakukankeinm1;

    public String getIwsHankakukankeinm1() {
        return iwsHankakukankeinm1;
    }

    public void setIwsHankakukankeinm1(String pIwsHankakukankeinm1) {
        iwsHankakukankeinm1 = pIwsHankakukankeinm1;
    }

    @Column(order = 14, length = 15)
    @MultiByte
    @NotNull
    private String iwsKjkankeinm1;

    public String getIwsKjkankeinm1() {
        return iwsKjkankeinm1;
    }

    @DataConvert("toMultiByte")
    public void setIwsKjkankeinm1(String pIwsKjkankeinm1) {
        iwsKjkankeinm1 = pIwsKjkankeinm1;
    }

    @Column(order = 15, length = 18)
    @NotNull
    private String iwsHankakukankeinm2;

    public String getIwsHankakukankeinm2() {
        return iwsHankakukankeinm2;
    }

    public void setIwsHankakukankeinm2(String pIwsHankakukankeinm2) {
        iwsHankakukankeinm2 = pIwsHankakukankeinm2;
    }

    @Column(order = 16, length = 15)
    @MultiByte
    @NotNull
    private String iwsKjkankeinm2;

    public String getIwsKjkankeinm2() {
        return iwsKjkankeinm2;
    }

    @DataConvert("toMultiByte")
    public void setIwsKjkankeinm2(String pIwsKjkankeinm2) {
        iwsKjkankeinm2 = pIwsKjkankeinm2;
    }

    @Column(order = 17, length = 18)
    @NotNull
    private String iwsHankakukankeinm3;

    public String getIwsHankakukankeinm3() {
        return iwsHankakukankeinm3;
    }

    public void setIwsHankakukankeinm3(String pIwsHankakukankeinm3) {
        iwsHankakukankeinm3 = pIwsHankakukankeinm3;
    }

    @Column(order = 18, length = 15)
    @MultiByte
    @NotNull
    private String iwsKjkankeinm3;

    public String getIwsKjkankeinm3() {
        return iwsKjkankeinm3;
    }

    @DataConvert("toMultiByte")
    public void setIwsKjkankeinm3(String pIwsKjkankeinm3) {
        iwsKjkankeinm3 = pIwsKjkankeinm3;
    }

    @Column(order = 19, length = 18)
    @NotNull
    private String iwsHankakukankeinm4;

    public String getIwsHankakukankeinm4() {
        return iwsHankakukankeinm4;
    }

    public void setIwsHankakukankeinm4(String pIwsHankakukankeinm4) {
        iwsHankakukankeinm4 = pIwsHankakukankeinm4;
    }

    @Column(order = 20, length = 15)
    @MultiByte
    @NotNull
    private String iwsKjkankeinm4;

    public String getIwsKjkankeinm4() {
        return iwsKjkankeinm4;
    }

    @DataConvert("toMultiByte")
    public void setIwsKjkankeinm4(String pIwsKjkankeinm4) {
        iwsKjkankeinm4 = pIwsKjkankeinm4;
    }

    @Column(order = 21, length = 18)
    @NotNull
    private String iwsHankakukankeinm5;

    public String getIwsHankakukankeinm5() {
        return iwsHankakukankeinm5;
    }

    public void setIwsHankakukankeinm5(String pIwsHankakukankeinm5) {
        iwsHankakukankeinm5 = pIwsHankakukankeinm5;
    }

    @Column(order = 22, length = 15)
    @MultiByte
    @NotNull
    private String iwsKjkankeinm5;

    public String getIwsKjkankeinm5() {
        return iwsKjkankeinm5;
    }

    @DataConvert("toMultiByte")
    public void setIwsKjkankeinm5(String pIwsKjkankeinm5) {
        iwsKjkankeinm5 = pIwsKjkankeinm5;
    }

    @Column(order = 23, length = 7)
    @NotNull
    private String iwsAatukaisosikicd;

    public String getIwsAatukaisosikicd() {
        return iwsAatukaisosikicd;
    }

    public void setIwsAatukaisosikicd(String pIwsAatukaisosikicd) {
        iwsAatukaisosikicd = pIwsAatukaisosikicd;
    }

    @Column(order = 24, length = 7)
    @NotNull
    private String iwsBatukaisosikicd;

    public String getIwsBatukaisosikicd() {
        return iwsBatukaisosikicd;
    }

    public void setIwsBatukaisosikicd(String pIwsBatukaisosikicd) {
        iwsBatukaisosikicd = pIwsBatukaisosikicd;
    }

    @Column(order = 25, length = 14)
    @NotNull
    @MaxLength(max=14)
    @SingleByteStrings
    @Tel
    private String iwsTsintelno;

    public String getIwsTsintelno() {
        return iwsTsintelno;
    }

    public void setIwsTsintelno(String pIwsTsintelno) {
        iwsTsintelno = pIwsTsintelno;
    }

    @Column(order = 26, length = 1)
    @NotNull
    @MaxLength(max=1)
    @SingleByteStrings
    private String iwsHrkkeirokbn;

    public String getIwsHrkkeirokbn() {
        return iwsHrkkeirokbn;
    }

    public void setIwsHrkkeirokbn(String pIwsHrkkeirokbn) {
        iwsHrkkeirokbn = pIwsHrkkeirokbn;
    }

    @Column(order = 27, length = 4)
    @NotNull
    private String iwsBankcd;

    public String getIwsBankcd() {
        return iwsBankcd;
    }

    public void setIwsBankcd(String pIwsBankcd) {
        iwsBankcd = pIwsBankcd;
    }

    @Column(order = 28, length = 3)
    @NotNull
    private String iwsSitencd;

    public String getIwsSitencd() {
        return iwsSitencd;
    }

    public void setIwsSitencd(String pIwsSitencd) {
        iwsSitencd = pIwsSitencd;
    }

    @Column(order = 29, length = 1)
    @NotNull
    private String iwsYokinkbn;

    public String getIwsYokinkbn() {
        return iwsYokinkbn;
    }

    public void setIwsYokinkbn(String pIwsYokinkbn) {
        iwsYokinkbn = pIwsYokinkbn;
    }

    @Column(order = 30, length = 7)
    @NotNull
    private String iwsKouzano7keta;

    public String getIwsKouzano7keta() {
        return iwsKouzano7keta;
    }

    public void setIwsKouzano7keta(String pIwsKouzano7keta) {
        iwsKouzano7keta = pIwsKouzano7keta;
    }

    @Column(order = 31, length = 1)
    @NotNull
    private String iwsSkininfosyoukaihyj;

    public String getIwsSkininfosyoukaihyj() {
        return iwsSkininfosyoukaihyj;
    }

    public void setIwsSkininfosyoukaihyj(String pIwsSkininfosyoukaihyj) {
        iwsSkininfosyoukaihyj = pIwsSkininfosyoukaihyj;
    }

    @Column(order = 32, length = 1)
    @NotNull
    private String iwsSkintaisyoukykkbn;

    public String getIwsSkintaisyoukykkbn() {
        return iwsSkintaisyoukykkbn;
    }

    public void setIwsSkintaisyoukykkbn(String pIwsSkintaisyoukykkbn) {
        iwsSkintaisyoukykkbn = pIwsSkintaisyoukykkbn;
    }

    @Column(order = 33, length = 1)
    @NotNull
    private String iwsSkintsghuho2kyknokbn;

    public String getIwsSkintsghuho2kyknokbn() {
        return iwsSkintsghuho2kyknokbn;
    }

    public void setIwsSkintsghuho2kyknokbn(String pIwsSkintsghuho2kyknokbn) {
        iwsSkintsghuho2kyknokbn = pIwsSkintsghuho2kyknokbn;
    }

    @Column(order = 34, length = 11)
    @NotNull
    private String iwsSkintsghuho2kykno;

    public String getIwsSkintsghuho2kykno() {
        return iwsSkintsghuho2kykno;
    }

    public void setIwsSkintsghuho2kykno(String pIwsSkintsghuho2kykno) {
        iwsSkintsghuho2kykno = pIwsSkintsghuho2kykno;
    }

    @Column(order = 35, length = 8)
    @NotNull
    private BizDate iwsSkinkijyunymd;

    public BizDate getIwsSkinkijyunymd() {
        return iwsSkinkijyunymd;
    }

    public void setIwsSkinkijyunymd(BizDate pIwsSkinkijyunymd) {
        iwsSkinkijyunymd = pIwsSkinkijyunymd;
    }

    @Column(order = 36, length = 1)
    @NotNull
    private String iwsMrsignalsyoukaihyj;

    public String getIwsMrsignalsyoukaihyj() {
        return iwsMrsignalsyoukaihyj;
    }

    public void setIwsMrsignalsyoukaihyj(String pIwsMrsignalsyoukaihyj) {
        iwsMrsignalsyoukaihyj = pIwsMrsignalsyoukaihyj;
    }

    @Column(order = 37, length = 1)
    @NotNull
    private String iwsMrsignalhanteigyoumukbn;

    public String getIwsMrsignalhanteigyoumukbn() {
        return iwsMrsignalhanteigyoumukbn;
    }

    public void setIwsMrsignalhanteigyoumukbn(String pIwsMrsignalhanteigyoumukbn) {
        iwsMrsignalhanteigyoumukbn = pIwsMrsignalhanteigyoumukbn;
    }

    @Column(order = 38, length = 1)
    @NotNull
    private String iwsTsngksyoukaihyj;

    public String getIwsTsngksyoukaihyj() {
        return iwsTsngksyoukaihyj;
    }

    public void setIwsTsngksyoukaihyj(String pIwsTsngksyoukaihyj) {
        iwsTsngksyoukaihyj = pIwsTsngksyoukaihyj;
    }

    @Column(order = 39, length = 1)
    @NotNull
    private String iwsTsntsghuho2kyknokbn;

    public String getIwsTsntsghuho2kyknokbn() {
        return iwsTsntsghuho2kyknokbn;
    }

    public void setIwsTsntsghuho2kyknokbn(String pIwsTsntsghuho2kyknokbn) {
        iwsTsntsghuho2kyknokbn = pIwsTsntsghuho2kyknokbn;
    }

    @Column(order = 40, length = 11)
    @NotNull
    private String iwsTsntsghuho2kykno;

    public String getIwsTsntsghuho2kykno() {
        return iwsTsntsghuho2kykno;
    }

    public void setIwsTsntsghuho2kykno(String pIwsTsntsghuho2kykno) {
        iwsTsntsghuho2kykno = pIwsTsntsghuho2kykno;
    }

    @Column(order = 41, length = 8)
    @NotNull
    private BizDate iwsTsnkijyunymd;

    public BizDate getIwsTsnkijyunymd() {
        return iwsTsnkijyunymd;
    }

    public void setIwsTsnkijyunymd(BizDate pIwsTsnkijyunymd) {
        iwsTsnkijyunymd = pIwsTsnkijyunymd;
    }

    @Column(order = 42, length = 1)
    @NotNull
    private String iwsKykdrtentsnssyoukaihyj;

    public String getIwsKykdrtentsnssyoukaihyj() {
        return iwsKykdrtentsnssyoukaihyj;
    }

    public void setIwsKykdrtentsnssyoukaihyj(String pIwsKykdrtentsnssyoukaihyj) {
        iwsKykdrtentsnssyoukaihyj = pIwsKykdrtentsnssyoukaihyj;
    }

    @Column(order = 43, length = 1)
    @NotNull
    private String iwsDrtentsntsghuho2kyknokbn;

    public String getIwsDrtentsntsghuho2kyknokbn() {
        return iwsDrtentsntsghuho2kyknokbn;
    }

    public void setIwsDrtentsntsghuho2kyknokbn(String pIwsDrtentsntsghuho2kyknokbn) {
        iwsDrtentsntsghuho2kyknokbn = pIwsDrtentsntsghuho2kyknokbn;
    }

    @Column(order = 44, length = 11)
    @NotNull
    private String iwsDrtentsntsghuho2kykno;

    public String getIwsDrtentsntsghuho2kykno() {
        return iwsDrtentsntsghuho2kykno;
    }

    public void setIwsDrtentsntsghuho2kykno(String pIwsDrtentsntsghuho2kykno) {
        iwsDrtentsntsghuho2kykno = pIwsDrtentsntsghuho2kykno;
    }

    @Column(order = 45, length = 8)
    @NotNull
    private BizDate iwsKykdrtentsnkijyunymd;

    public BizDate getIwsKykdrtentsnkijyunymd() {
        return iwsKykdrtentsnkijyunymd;
    }

    public void setIwsKykdrtentsnkijyunymd(BizDate pIwsKykdrtentsnkijyunymd) {
        iwsKykdrtentsnkijyunymd = pIwsKykdrtentsnkijyunymd;
    }

    @Column(order = 46, length = 7)
    @NotNull
    private String iwsAatukaidrtencd;

    public String getIwsAatukaidrtencd() {
        return iwsAatukaidrtencd;
    }

    public void setIwsAatukaidrtencd(String pIwsAatukaidrtencd) {
        iwsAatukaidrtencd = pIwsAatukaidrtencd;
    }

    @Column(order = 47, length = 7)
    @NotNull
    private String iwsBatukaidrtencd;

    public String getIwsBatukaidrtencd() {
        return iwsBatukaidrtencd;
    }

    public void setIwsBatukaidrtencd(String pIwsBatukaidrtencd) {
        iwsBatukaidrtencd = pIwsBatukaidrtencd;
    }

    @Column(order = 48, length = 1)
    @NotNull
    private String iwsMossakuseisyoukaihyj;

    public String getIwsMossakuseisyoukaihyj() {
        return iwsMossakuseisyoukaihyj;
    }

    public void setIwsMossakuseisyoukaihyj(String pIwsMossakuseisyoukaihyj) {
        iwsMossakuseisyoukaihyj = pIwsMossakuseisyoukaihyj;
    }

    @Column(order = 49, length = 1)
    @NotNull
    private String iwsHndketyhsyoukaihyj;

    public String getIwsHndketyhsyoukaihyj() {
        return iwsHndketyhsyoukaihyj;
    }

    public void setIwsHndketyhsyoukaihyj(String pIwsHndketyhsyoukaihyj) {
        iwsHndketyhsyoukaihyj = pIwsHndketyhsyoukaihyj;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
