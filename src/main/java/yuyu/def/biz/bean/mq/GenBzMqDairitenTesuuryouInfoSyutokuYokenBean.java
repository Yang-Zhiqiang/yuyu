package yuyu.def.biz.bean.mq;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;

/**
 * （共通）ＭＱ代理店手数料情報取得与件BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenBzMqDairitenTesuuryouInfoSyutokuYokenBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenBzMqDairitenTesuuryouInfoSyutokuYokenBean() {
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
    private String iwsTsrsisanhyouji;

    public String getIwsTsrsisanhyouji() {
        return iwsTsrsisanhyouji;
    }

    public void setIwsTsrsisanhyouji(String pIwsTsrsisanhyouji) {
        iwsTsrsisanhyouji = pIwsTsrsisanhyouji;
    }

    @Column(order = 4, length = 1)
    @NotNull
    private String iwsKeijyouymsyoukaihyouji;

    public String getIwsKeijyouymsyoukaihyouji() {
        return iwsKeijyouymsyoukaihyouji;
    }

    public void setIwsKeijyouymsyoukaihyouji(String pIwsKeijyouymsyoukaihyouji) {
        iwsKeijyouymsyoukaihyouji = pIwsKeijyouymsyoukaihyouji;
    }

    @Column(order = 5, length = 7)
    @NotNull
    @AlphaDigit
    @MaxLength(max=7)
    private String iwsDrtencd;

    public String getIwsDrtencd() {
        return iwsDrtencd;
    }

    public void setIwsDrtencd(String pIwsDrtencd) {
        iwsDrtencd = pIwsDrtencd;
    }

    @Column(order = 6, length = 3)
    @NotNull
    private String iwsAtkiwari;

    public String getIwsAtkiwari() {
        return iwsAtkiwari;
    }

    public void setIwsAtkiwari(String pIwsAtkiwari) {
        iwsAtkiwari = pIwsAtkiwari;
    }

    @Column(order = 7, length = 1)
    @NotNull
    private String iwsDairitenatkinin;

    public String getIwsDairitenatkinin() {
        return iwsDairitenatkinin;
    }

    public void setIwsDairitenatkinin(String pIwsDairitenatkinin) {
        iwsDairitenatkinin = pIwsDairitenatkinin;
    }

    @Column(order = 8, length = 2)
    @NotNull
    private String iwsHknsyukigoutesuuryou;

    public String getIwsHknsyukigoutesuuryou() {
        return iwsHknsyukigoutesuuryou;
    }

    public void setIwsHknsyukigoutesuuryou(String pIwsHknsyukigoutesuuryou) {
        iwsHknsyukigoutesuuryou = pIwsHknsyukigoutesuuryou;
    }

    @Column(order = 9, length = 1)
    @NotNull
    private String iwsHokensyuruikigousedaikbn;

    public String getIwsHokensyuruikigousedaikbn() {
        return iwsHokensyuruikigousedaikbn;
    }

    public void setIwsHokensyuruikigousedaikbn(String pIwsHokensyuruikigousedaikbn) {
        iwsHokensyuruikigousedaikbn = pIwsHokensyuruikigousedaikbn;
    }

    @Column(order = 10, length = 1)
    @NotNull
    private String iwsHknsykguybi1x1;

    public String getIwsHknsykguybi1x1() {
        return iwsHknsykguybi1x1;
    }

    public void setIwsHknsykguybi1x1(String pIwsHknsykguybi1x1) {
        iwsHknsykguybi1x1 = pIwsHknsykguybi1x1;
    }

    @Column(order = 11, length = 1)
    @NotNull
    private String iwsHknsykguybi1x2;

    public String getIwsHknsykguybi1x2() {
        return iwsHknsykguybi1x2;
    }

    public void setIwsHknsykguybi1x2(String pIwsHknsykguybi1x2) {
        iwsHknsykguybi1x2 = pIwsHknsykguybi1x2;
    }

    @Column(order = 12, length = 1)
    @NotNull
    private String iwsHknsykguybi1x3;

    public String getIwsHknsykguybi1x3() {
        return iwsHknsykguybi1x3;
    }

    public void setIwsHknsykguybi1x3(String pIwsHknsykguybi1x3) {
        iwsHknsykguybi1x3 = pIwsHknsykguybi1x3;
    }

    @Column(order = 13, length = 1)
    @NotNull
    private String iwsHknsykguybi1x4;

    public String getIwsHknsykguybi1x4() {
        return iwsHknsykguybi1x4;
    }

    public void setIwsHknsykguybi1x4(String pIwsHknsykguybi1x4) {
        iwsHknsykguybi1x4 = pIwsHknsykguybi1x4;
    }

    @Column(order = 14, length = 1)
    @NotNull
    private String iwsHknsykguybi1x5;

    public String getIwsHknsykguybi1x5() {
        return iwsHknsykguybi1x5;
    }

    public void setIwsHknsykguybi1x5(String pIwsHknsykguybi1x5) {
        iwsHknsykguybi1x5 = pIwsHknsykguybi1x5;
    }

    @Column(order = 15, length = 1)
    @NotNull
    private String iwsHknsykguybi1x6;

    public String getIwsHknsykguybi1x6() {
        return iwsHknsykguybi1x6;
    }

    public void setIwsHknsykguybi1x6(String pIwsHknsykguybi1x6) {
        iwsHknsykguybi1x6 = pIwsHknsykguybi1x6;
    }

    @Column(order = 16, length = 1)
    @NotNull
    private String iwsHknsykguybi1x7;

    public String getIwsHknsykguybi1x7() {
        return iwsHknsykguybi1x7;
    }

    public void setIwsHknsykguybi1x7(String pIwsHknsykguybi1x7) {
        iwsHknsykguybi1x7 = pIwsHknsykguybi1x7;
    }

    @Column(order = 17, length = 1)
    @NotNull
    private String iwsHknsykguybi1x8;

    public String getIwsHknsykguybi1x8() {
        return iwsHknsykguybi1x8;
    }

    public void setIwsHknsykguybi1x8(String pIwsHknsykguybi1x8) {
        iwsHknsykguybi1x8 = pIwsHknsykguybi1x8;
    }

    @Column(order = 18, length = 1)
    @NotNull
    private String iwsHknsykguybi1x9;

    public String getIwsHknsykguybi1x9() {
        return iwsHknsykguybi1x9;
    }

    public void setIwsHknsykguybi1x9(String pIwsHknsykguybi1x9) {
        iwsHknsykguybi1x9 = pIwsHknsykguybi1x9;
    }

    @Column(order = 19, length = 1)
    @NotNull
    private String iwsHknsykguybi1x10;

    public String getIwsHknsykguybi1x10() {
        return iwsHknsykguybi1x10;
    }

    public void setIwsHknsykguybi1x10(String pIwsHknsykguybi1x10) {
        iwsHknsykguybi1x10 = pIwsHknsykguybi1x10;
    }

    @Column(order = 20, length = 1)
    @NotNull
    private String iwsHknsykguybi1x11;

    public String getIwsHknsykguybi1x11() {
        return iwsHknsykguybi1x11;
    }

    public void setIwsHknsykguybi1x11(String pIwsHknsykguybi1x11) {
        iwsHknsykguybi1x11 = pIwsHknsykguybi1x11;
    }

    @Column(order = 21, length = 1)
    @NotNull
    private String iwsHknsykguybi1x12;

    public String getIwsHknsykguybi1x12() {
        return iwsHknsykguybi1x12;
    }

    public void setIwsHknsykguybi1x12(String pIwsHknsykguybi1x12) {
        iwsHknsykguybi1x12 = pIwsHknsykguybi1x12;
    }

    @Column(order = 22, length = 1)
    @NotNull
    private String iwsHknsykguybi1x13;

    public String getIwsHknsykguybi1x13() {
        return iwsHknsykguybi1x13;
    }

    public void setIwsHknsykguybi1x13(String pIwsHknsykguybi1x13) {
        iwsHknsykguybi1x13 = pIwsHknsykguybi1x13;
    }

    @Column(order = 23, length = 1)
    @NotNull
    private String iwsHknsykguybi1x14;

    public String getIwsHknsykguybi1x14() {
        return iwsHknsykguybi1x14;
    }

    public void setIwsHknsykguybi1x14(String pIwsHknsykguybi1x14) {
        iwsHknsykguybi1x14 = pIwsHknsykguybi1x14;
    }

    @Column(order = 24, length = 1)
    @NotNull
    private String iwsHknsykguybi1x15;

    public String getIwsHknsykguybi1x15() {
        return iwsHknsykguybi1x15;
    }

    public void setIwsHknsykguybi1x15(String pIwsHknsykguybi1x15) {
        iwsHknsykguybi1x15 = pIwsHknsykguybi1x15;
    }

    @Column(order = 25, length = 1)
    @NotNull
    private String iwsHknsykguybi2x1;

    public String getIwsHknsykguybi2x1() {
        return iwsHknsykguybi2x1;
    }

    public void setIwsHknsykguybi2x1(String pIwsHknsykguybi2x1) {
        iwsHknsykguybi2x1 = pIwsHknsykguybi2x1;
    }

    @Column(order = 26, length = 1)
    @NotNull
    private String iwsHknsykguybi2x2;

    public String getIwsHknsykguybi2x2() {
        return iwsHknsykguybi2x2;
    }

    public void setIwsHknsykguybi2x2(String pIwsHknsykguybi2x2) {
        iwsHknsykguybi2x2 = pIwsHknsykguybi2x2;
    }

    @Column(order = 27, length = 1)
    @NotNull
    private String iwsHknsykguybi2x3;

    public String getIwsHknsykguybi2x3() {
        return iwsHknsykguybi2x3;
    }

    public void setIwsHknsykguybi2x3(String pIwsHknsykguybi2x3) {
        iwsHknsykguybi2x3 = pIwsHknsykguybi2x3;
    }

    @Column(order = 28, length = 1)
    @NotNull
    private String iwsHknsykguybi2x4;

    public String getIwsHknsykguybi2x4() {
        return iwsHknsykguybi2x4;
    }

    public void setIwsHknsykguybi2x4(String pIwsHknsykguybi2x4) {
        iwsHknsykguybi2x4 = pIwsHknsykguybi2x4;
    }

    @Column(order = 29, length = 1)
    @NotNull
    private String iwsHknsykguybi2x5;

    public String getIwsHknsykguybi2x5() {
        return iwsHknsykguybi2x5;
    }

    public void setIwsHknsykguybi2x5(String pIwsHknsykguybi2x5) {
        iwsHknsykguybi2x5 = pIwsHknsykguybi2x5;
    }

    @Column(order = 30, length = 1)
    @NotNull
    private String iwsHknsykguybi2x6;

    public String getIwsHknsykguybi2x6() {
        return iwsHknsykguybi2x6;
    }

    public void setIwsHknsykguybi2x6(String pIwsHknsykguybi2x6) {
        iwsHknsykguybi2x6 = pIwsHknsykguybi2x6;
    }

    @Column(order = 31, length = 1)
    @NotNull
    private String iwsHknsykguybi2x7;

    public String getIwsHknsykguybi2x7() {
        return iwsHknsykguybi2x7;
    }

    public void setIwsHknsykguybi2x7(String pIwsHknsykguybi2x7) {
        iwsHknsykguybi2x7 = pIwsHknsykguybi2x7;
    }

    @Column(order = 32, length = 1)
    @NotNull
    private String iwsHknsykguybi2x8;

    public String getIwsHknsykguybi2x8() {
        return iwsHknsykguybi2x8;
    }

    public void setIwsHknsykguybi2x8(String pIwsHknsykguybi2x8) {
        iwsHknsykguybi2x8 = pIwsHknsykguybi2x8;
    }

    @Column(order = 33, length = 1)
    @NotNull
    private String iwsHknsykguybi2x9;

    public String getIwsHknsykguybi2x9() {
        return iwsHknsykguybi2x9;
    }

    public void setIwsHknsykguybi2x9(String pIwsHknsykguybi2x9) {
        iwsHknsykguybi2x9 = pIwsHknsykguybi2x9;
    }

    @Column(order = 34, length = 1)
    @NotNull
    private String iwsHknsykguybi2x10;

    public String getIwsHknsykguybi2x10() {
        return iwsHknsykguybi2x10;
    }

    public void setIwsHknsykguybi2x10(String pIwsHknsykguybi2x10) {
        iwsHknsykguybi2x10 = pIwsHknsykguybi2x10;
    }

    @Column(order = 35, length = 1)
    @NotNull
    private String iwsHknsykguybi3x1;

    public String getIwsHknsykguybi3x1() {
        return iwsHknsykguybi3x1;
    }

    public void setIwsHknsykguybi3x1(String pIwsHknsykguybi3x1) {
        iwsHknsykguybi3x1 = pIwsHknsykguybi3x1;
    }

    @Column(order = 36, length = 1)
    @NotNull
    private String iwsHknsykguybi3x2;

    public String getIwsHknsykguybi3x2() {
        return iwsHknsykguybi3x2;
    }

    public void setIwsHknsykguybi3x2(String pIwsHknsykguybi3x2) {
        iwsHknsykguybi3x2 = pIwsHknsykguybi3x2;
    }

    @Column(order = 37, length = 1)
    @NotNull
    private String iwsHknsykguybi3x3;

    public String getIwsHknsykguybi3x3() {
        return iwsHknsykguybi3x3;
    }

    public void setIwsHknsykguybi3x3(String pIwsHknsykguybi3x3) {
        iwsHknsykguybi3x3 = pIwsHknsykguybi3x3;
    }

    @Column(order = 38, length = 1)
    @NotNull
    private String iwsHknsykguybi3x4;

    public String getIwsHknsykguybi3x4() {
        return iwsHknsykguybi3x4;
    }

    public void setIwsHknsykguybi3x4(String pIwsHknsykguybi3x4) {
        iwsHknsykguybi3x4 = pIwsHknsykguybi3x4;
    }

    @Column(order = 39, length = 1)
    @NotNull
    private String iwsHknsykguybi3x5;

    public String getIwsHknsykguybi3x5() {
        return iwsHknsykguybi3x5;
    }

    public void setIwsHknsykguybi3x5(String pIwsHknsykguybi3x5) {
        iwsHknsykguybi3x5 = pIwsHknsykguybi3x5;
    }

    @Column(order = 40, length = 1)
    @NotNull
    private String iwsHknsykguybi3x6;

    public String getIwsHknsykguybi3x6() {
        return iwsHknsykguybi3x6;
    }

    public void setIwsHknsykguybi3x6(String pIwsHknsykguybi3x6) {
        iwsHknsykguybi3x6 = pIwsHknsykguybi3x6;
    }

    @Column(order = 41, length = 1)
    @NotNull
    private String iwsHknsykguybi3x7;

    public String getIwsHknsykguybi3x7() {
        return iwsHknsykguybi3x7;
    }

    public void setIwsHknsykguybi3x7(String pIwsHknsykguybi3x7) {
        iwsHknsykguybi3x7 = pIwsHknsykguybi3x7;
    }

    @Column(order = 42, length = 1)
    @NotNull
    private String iwsHknsykguybi3x8;

    public String getIwsHknsykguybi3x8() {
        return iwsHknsykguybi3x8;
    }

    public void setIwsHknsykguybi3x8(String pIwsHknsykguybi3x8) {
        iwsHknsykguybi3x8 = pIwsHknsykguybi3x8;
    }

    @Column(order = 43, length = 1)
    @NotNull
    private String iwsHknsykguybi3x9;

    public String getIwsHknsykguybi3x9() {
        return iwsHknsykguybi3x9;
    }

    public void setIwsHknsykguybi3x9(String pIwsHknsykguybi3x9) {
        iwsHknsykguybi3x9 = pIwsHknsykguybi3x9;
    }

    @Column(order = 44, length = 1)
    @NotNull
    private String iwsHknsykguybi3x10;

    public String getIwsHknsykguybi3x10() {
        return iwsHknsykguybi3x10;
    }

    public void setIwsHknsykguybi3x10(String pIwsHknsykguybi3x10) {
        iwsHknsykguybi3x10 = pIwsHknsykguybi3x10;
    }

    @Column(order = 45, length = 8)
    @NotNull
    private String iwsCalckijyunymd1;

    public String getIwsCalckijyunymd1() {
        return iwsCalckijyunymd1;
    }

    public void setIwsCalckijyunymd1(String pIwsCalckijyunymd1) {
        iwsCalckijyunymd1 = pIwsCalckijyunymd1;
    }

    @Column(order = 46, length = 8)
    @NotNull
    private String iwsCalckijyunymd2;

    public String getIwsCalckijyunymd2() {
        return iwsCalckijyunymd2;
    }

    public void setIwsCalckijyunymd2(String pIwsCalckijyunymd2) {
        iwsCalckijyunymd2 = pIwsCalckijyunymd2;
    }

    @Column(order = 47, length = 8)
    @NotNull
    private String iwsCalckijyunymd3;

    public String getIwsCalckijyunymd3() {
        return iwsCalckijyunymd3;
    }

    public void setIwsCalckijyunymd3(String pIwsCalckijyunymd3) {
        iwsCalckijyunymd3 = pIwsCalckijyunymd3;
    }

    @Column(order = 48, length = 1)
    @NotNull
    @MaxLength(max=1)
    @SingleByteStrings
    private String iwsHaraikomikaisuukbn;

    public String getIwsHaraikomikaisuukbn() {
        return iwsHaraikomikaisuukbn;
    }

    public void setIwsHaraikomikaisuukbn(String pIwsHaraikomikaisuukbn) {
        iwsHaraikomikaisuukbn = pIwsHaraikomikaisuukbn;
    }

    @Column(order = 49, length = 1)
    @NotNull
    private String iwsSaimankikeiyakuhyouji;

    public String getIwsSaimankikeiyakuhyouji() {
        return iwsSaimankikeiyakuhyouji;
    }

    public void setIwsSaimankikeiyakuhyouji(String pIwsSaimankikeiyakuhyouji) {
        iwsSaimankikeiyakuhyouji = pIwsSaimankikeiyakuhyouji;
    }

    @Column(order = 50, length = 2)
    @NotNull
    private String iwsHhknnen2keta;

    public String getIwsHhknnen2keta() {
        return iwsHhknnen2keta;
    }

    public void setIwsHhknnen2keta(String pIwsHhknnen2keta) {
        iwsHhknnen2keta = pIwsHhknnen2keta;
    }

    @Column(order = 51, length = 2)
    @NotNull
    @MaxLength(max=2)
    private String iwsHknkkn;

    public String getIwsHknkkn() {
        return iwsHknkkn;
    }

    public void setIwsHknkkn(String pIwsHknkkn) {
        iwsHknkkn = pIwsHknkkn;
    }

    @Column(order = 52, length = 2)
    @NotNull
    @MaxLength(max=2)
    private String iwsPharaikomikikan;

    public String getIwsPharaikomikikan() {
        return iwsPharaikomikikan;
    }

    public void setIwsPharaikomikikan(String pIwsPharaikomikikan) {
        iwsPharaikomikikan = pIwsPharaikomikikan;
    }

    @Column(order = 53, length = 11)
    @NotNull
    private String iwsSyup;

    public String getIwsSyup() {
        return iwsSyup;
    }

    public void setIwsSyup(String pIwsSyup) {
        iwsSyup = pIwsSyup;
    }

    @Column(order = 54, length = 1)
    @NotNull
    private String iwsDrtentsryhushrkykhyouji;

    public String getIwsDrtentsryhushrkykhyouji() {
        return iwsDrtentsryhushrkykhyouji;
    }

    public void setIwsDrtentsryhushrkykhyouji(String pIwsDrtentsryhushrkykhyouji) {
        iwsDrtentsryhushrkykhyouji = pIwsDrtentsryhushrkykhyouji;
    }

    @Column(order = 55, length = 6)
    @NotNull
    private String iwsTkykwsrate;

    public String getIwsTkykwsrate() {
        return iwsTkykwsrate;
    }

    public void setIwsTkykwsrate(String pIwsTkykwsrate) {
        iwsTkykwsrate = pIwsTkykwsrate;
    }

    @Column(order = 56, length = 1)
    @NotNull
    private String iwsTuukasyukbn;

    public String getIwsTuukasyukbn() {
        return iwsTuukasyukbn;
    }

    public void setIwsTuukasyukbn(String pIwsTuukasyukbn) {
        iwsTuukasyukbn = pIwsTuukasyukbn;
    }

    @Column(order = 57, length = 5)
    @NotNull
    private String iwsYoteiriritu;

    public String getIwsYoteiriritu() {
        return iwsYoteiriritu;
    }

    public void setIwsYoteiriritu(String pIwsYoteiriritu) {
        iwsYoteiriritu = pIwsYoteiriritu;
    }

    @Column(order = 58, length = 11)
    @NotNull
    private String iwsSyupHrktuuka;

    public String getIwsSyupHrktuuka() {
        return iwsSyupHrktuuka;
    }

    public void setIwsSyupHrktuuka(String pIwsSyupHrktuuka) {
        iwsSyupHrktuuka = pIwsSyupHrktuuka;
    }

    @Column(order = 59, length = 1)
    @NotNull
    private String iwsHrktuukasyu;

    public String getIwsHrktuukasyu() {
        return iwsHrktuukasyu;
    }

    public void setIwsHrktuukasyu(String pIwsHrktuukasyu) {
        iwsHrktuukasyu = pIwsHrktuukasyu;
    }

    @Column(order = 60, length = 1)
    @NotNull
    @Length(length=1)
    @SingleByteStrings
    private String iwsIkkatubaraikbn;

    public String getIwsIkkatubaraikbn() {
        return iwsIkkatubaraikbn;
    }

    public void setIwsIkkatubaraikbn(String pIwsIkkatubaraikbn) {
        iwsIkkatubaraikbn = pIwsIkkatubaraikbn;
    }

    @Column(order = 61, length = 2)
    @NotNull
    @Length(length=2)
    @SingleByteStrings
    private String iwsIkkatubaraikaisuu;

    public String getIwsIkkatubaraikaisuu() {
        return iwsIkkatubaraikaisuu;
    }

    public void setIwsIkkatubaraikaisuu(String pIwsIkkatubaraikaisuu) {
        iwsIkkatubaraikaisuu = pIwsIkkatubaraikaisuu;
    }

    @Column(order = 62, length = 11)
    @NotNull
    private String iwsKihons11keta;

    public String getIwsKihons11keta() {
        return iwsKihons11keta;
    }

    public void setIwsKihons11keta(String pIwsKihons11keta) {
        iwsKihons11keta = pIwsKihons11keta;
    }

    @Column(order = 63, length = 25)
    @NotNull
    private String iwsYobiv25;

    public String getIwsYobiv25() {
        return iwsYobiv25;
    }

    public void setIwsYobiv25(String pIwsYobiv25) {
        iwsYobiv25 = pIwsYobiv25;
    }

    @Column(order = 64, length = 7)
    @NotNull
    private String iwsBsydrtencd;

    public String getIwsBsydrtencd() {
        return iwsBsydrtencd;
    }

    public void setIwsBsydrtencd(String pIwsBsydrtencd) {
        iwsBsydrtencd = pIwsBsydrtencd;
    }

    @Column(order = 65, length = 2)
    @NotNull
    private String iwsHknsyukigoukeijyouym;

    public String getIwsHknsyukigoukeijyouym() {
        return iwsHknsyukigoukeijyouym;
    }

    public void setIwsHknsyukigoukeijyouym(String pIwsHknsyukigoukeijyouym) {
        iwsHknsyukigoukeijyouym = pIwsHknsyukigoukeijyouym;
    }

    @Column(order = 66, length = 8)
    @NotNull
    private String iwsKokutiymd;

    public String getIwsKokutiymd() {
        return iwsKokutiymd;
    }

    public void setIwsKokutiymd(String pIwsKokutiymd) {
        iwsKokutiymd = pIwsKokutiymd;
    }

    @Column(order = 67, length = 8)
    @NotNull
    private String iwsSyokaipryosyuuymd;

    public String getIwsSyokaipryosyuuymd() {
        return iwsSyokaipryosyuuymd;
    }

    public void setIwsSyokaipryosyuuymd(String pIwsSyokaipryosyuuymd) {
        iwsSyokaipryosyuuymd = pIwsSyokaipryosyuuymd;
    }

    @Column(order = 68, length = 8)
    @NotNull
    private String iwsMosymdstr;

    public String getIwsMosymdstr() {
        return iwsMosymdstr;
    }

    public void setIwsMosymdstr(String pIwsMosymdstr) {
        iwsMosymdstr = pIwsMosymdstr;
    }

    @Column(order = 69, length = 1)
    @NotNull
    private String iwsMossyoumetukbn;

    public String getIwsMossyoumetukbn() {
        return iwsMossyoumetukbn;
    }

    public void setIwsMossyoumetukbn(String pIwsMossyoumetukbn) {
        iwsMossyoumetukbn = pIwsMossyoumetukbn;
    }

    @Column(order = 70, length = 8)
    @NotNull
    private String iwsMossyoumetukktiymd;

    public String getIwsMossyoumetukktiymd() {
        return iwsMossyoumetukktiymd;
    }

    public void setIwsMossyoumetukktiymd(String pIwsMossyoumetukktiymd) {
        iwsMossyoumetukktiymd = pIwsMossyoumetukktiymd;
    }

    @Column(order = 71, length = 6)
    @NotNull
    private String iwsBosyuuymstr;

    public String getIwsBosyuuymstr() {
        return iwsBosyuuymstr;
    }

    public void setIwsBosyuuymstr(String pIwsBosyuuymstr) {
        iwsBosyuuymstr = pIwsBosyuuymstr;
    }

    @Column(order = 72, length = 39)
    @NotNull
    private String iwsYobiv39;

    public String getIwsYobiv39() {
        return iwsYobiv39;
    }

    public void setIwsYobiv39(String pIwsYobiv39) {
        iwsYobiv39 = pIwsYobiv39;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
