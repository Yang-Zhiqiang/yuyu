package yuyu.def.bosyuu.bean.webservice;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.file.description.annotations.MultiByte;
import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * （保険募集）生保Ｗｅｂ契約内容照会出力BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenWsHbKeiyakuSyoukaiWebServiceOutputBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenWsHbKeiyakuSyoukaiWebServiceOutputBean() {
    }

    @Column(order = 1, length = 1)
    private String iwsErrkbn;

    public String getIwsErrkbn() {
        return iwsErrkbn;
    }

    public void setIwsErrkbn(String pIwsErrkbn) {
        iwsErrkbn = pIwsErrkbn;
    }

    @Column(order = 2, length = 40)
    @MultiByte
    private String iwsErrormsg;

    public String getIwsErrormsg() {
        return iwsErrormsg;
    }

    public void setIwsErrormsg(String pIwsErrormsg) {
        iwsErrormsg = pIwsErrormsg;
    }

    @Column(order = 3, length = 8)
    private String iwsTanmatutyouhyoucd;

    public String getIwsTanmatutyouhyoucd() {
        return iwsTanmatutyouhyoucd;
    }

    public void setIwsTanmatutyouhyoucd(String pIwsTanmatutyouhyoucd) {
        iwsTanmatutyouhyoucd = pIwsTanmatutyouhyoucd;
    }

    @Column(order = 4, length = 43)
    private String iwsKyknmkn43keta;

    public String getIwsKyknmkn43keta() {
        return iwsKyknmkn43keta;
    }

    public void setIwsKyknmkn43keta(String pIwsKyknmkn43keta) {
        iwsKyknmkn43keta = pIwsKyknmkn43keta;
    }

    @Column(order = 5, length = 38)
    @MultiByte
    private String iwsKyknmkj38keta;

    public String getIwsKyknmkj38keta() {
        return iwsKyknmkj38keta;
    }

    public void setIwsKyknmkj38keta(String pIwsKyknmkj38keta) {
        iwsKyknmkj38keta = pIwsKyknmkj38keta;
    }

    @Column(order = 6, length = 11)
    @MultiByte
    private String iwsKyksyaseiymdwareki;

    public String getIwsKyksyaseiymdwareki() {
        return iwsKyksyaseiymdwareki;
    }

    public void setIwsKyksyaseiymdwareki(String pIwsKyksyaseiymdwareki) {
        iwsKyksyaseiymdwareki = pIwsKyksyaseiymdwareki;
    }

    @Column(order = 7, length = 2)
    @MultiByte
    private String iwsKojinhjnkbn;

    public String getIwsKojinhjnkbn() {
        return iwsKojinhjnkbn;
    }

    public void setIwsKojinhjnkbn(String pIwsKojinhjnkbn) {
        iwsKojinhjnkbn = pIwsKojinhjnkbn;
    }

    @Column(order = 8, length = 15)
    private String iwsTsintelno15keta;

    public String getIwsTsintelno15keta() {
        return iwsTsintelno15keta;
    }

    public void setIwsTsintelno15keta(String pIwsTsintelno15keta) {
        iwsTsintelno15keta = pIwsTsintelno15keta;
    }

    @Column(order = 9, length = 8)
    @MultiByte
    private String iwsTsinynozenkaku;

    public String getIwsTsinynozenkaku() {
        return iwsTsinynozenkaku;
    }

    public void setIwsTsinynozenkaku(String pIwsTsinynozenkaku) {
        iwsTsinynozenkaku = pIwsTsinynozenkaku;
    }

    @Column(order = 10, length = 62)
    @MultiByte
    private String iwsTsinadr;

    public String getIwsTsinadr() {
        return iwsTsinadr;
    }

    @DataConvert("toMultiByte")
    public void setIwsTsinadr(String pIwsTsinadr) {
        iwsTsinadr = pIwsTsinadr;
    }

    @Column(order = 11, length = 80)
    private String iwsTsinadrkn;

    public String getIwsTsinadrkn() {
        return iwsTsinadrkn;
    }

    public void setIwsTsinadrkn(String pIwsTsinadrkn) {
        iwsTsinadrkn = pIwsTsinadrkn;
    }

    @Column(order = 12, length = 17)
    @MultiByte
    private String iwsHhknnm17keta;

    public String getIwsHhknnm17keta() {
        return iwsHhknnm17keta;
    }

    public void setIwsHhknnm17keta(String pIwsHhknnm17keta) {
        iwsHhknnm17keta = pIwsHhknnm17keta;
    }

    @Column(order = 13, length = 2)
    @MultiByte
    private String iwsHhknseikj;

    public String getIwsHhknseikj() {
        return iwsHhknseikj;
    }

    public void setIwsHhknseikj(String pIwsHhknseikj) {
        iwsHhknseikj = pIwsHhknseikj;
    }

    @Column(order = 14, length = 11)
    @MultiByte
    private String iwsHhknseiymdwareki;

    public String getIwsHhknseiymdwareki() {
        return iwsHhknseiymdwareki;
    }

    public void setIwsHhknseiymdwareki(String pIwsHhknseiymdwareki) {
        iwsHhknseiymdwareki = pIwsHhknseiymdwareki;
    }

    @Column(order = 15, length = 4)
    @MultiByte
    private String iwsHhknnenzenkaku;

    public String getIwsHhknnenzenkaku() {
        return iwsHhknnenzenkaku;
    }

    public void setIwsHhknnenzenkaku(String pIwsHhknnenzenkaku) {
        iwsHhknnenzenkaku = pIwsHhknnenzenkaku;
    }

    @Column(order = 16, length = 3)
    @MultiByte
    private String iwsHhknkyknen;

    public String getIwsHhknkyknen() {
        return iwsHhknkyknen;
    }

    public void setIwsHhknkyknen(String pIwsHhknkyknen) {
        iwsHhknkyknen = pIwsHhknkyknen;
    }

    @Column(order = 17, length = 61)
    @MultiByte
    private String iwsSyouhnnm61keta;

    public String getIwsSyouhnnm61keta() {
        return iwsSyouhnnm61keta;
    }

    public void setIwsSyouhnnm61keta(String pIwsSyouhnnm61keta) {
        iwsSyouhnnm61keta = pIwsSyouhnnm61keta;
    }

    @Column(order = 18, length = 10)
    @MultiByte
    private String iwsHokensyurui;

    public String getIwsHokensyurui() {
        return iwsHokensyurui;
    }

    public void setIwsHokensyurui(String pIwsHokensyurui) {
        iwsHokensyurui = pIwsHokensyurui;
    }

    @Column(order = 19, length = 11)
    @SyoukenNo
    private String iwsSyono11keta;

    public String getIwsSyono11keta() {
        return iwsSyono11keta;
    }

    public void setIwsSyono11keta(String pIwsSyono11keta) {
        iwsSyono11keta = pIwsSyono11keta;
    }

    @Column(order = 20, length = 15)
    private String iwsCifcd;

    public String getIwsCifcd() {
        return iwsCifcd;
    }

    public void setIwsCifcd(String pIwsCifcd) {
        iwsCifcd = pIwsCifcd;
    }

    @Column(order = 21, length = 11)
    @MultiByte
    private String iwsKykymd;

    public String getIwsKykymd() {
        return iwsKykymd;
    }

    public void setIwsKykymd(String pIwsKykymd) {
        iwsKykymd = pIwsKykymd;
    }

    @Column(order = 22, length = 31)
    @MultiByte
    private String iwsHaraikomihou;

    public String getIwsHaraikomihou() {
        return iwsHaraikomihou;
    }

    public void setIwsHaraikomihou(String pIwsHaraikomihou) {
        iwsHaraikomihou = pIwsHaraikomihou;
    }

    @Column(order = 23, length = 14)
    private String iwsSibouhknkn;

    public String getIwsSibouhknkn() {
        return iwsSibouhknkn;
    }

    public void setIwsSibouhknkn(String pIwsSibouhknkn) {
        iwsSibouhknkn = pIwsSibouhknkn;
    }

    @Column(order = 24, length = 1)
    private String iwsSibouhknkntuukasyu;

    public String getIwsSibouhknkntuukasyu() {
        return iwsSibouhknkntuukasyu;
    }

    public void setIwsSibouhknkntuukasyu(String pIwsSibouhknkntuukasyu) {
        iwsSibouhknkntuukasyu = pIwsSibouhknkntuukasyu;
    }

    @Column(order = 25, length = 14)
    private String iwsHrkp;

    public String getIwsHrkp() {
        return iwsHrkp;
    }

    public void setIwsHrkp(String pIwsHrkp) {
        iwsHrkp = pIwsHrkp;
    }

    @Column(order = 26, length = 1)
    private String iwsHrkptuukasyu;

    public String getIwsHrkptuukasyu() {
        return iwsHrkptuukasyu;
    }

    public void setIwsHrkptuukasyu(String pIwsHrkptuukasyu) {
        iwsHrkptuukasyu = pIwsHrkptuukasyu;
    }

    @Column(order = 27, length = 11)
    @MultiByte
    private String iwsNkshrstartymd;

    public String getIwsNkshrstartymd() {
        return iwsNkshrstartymd;
    }

    public void setIwsNkshrstartymd(String pIwsNkshrstartymd) {
        iwsNkshrstartymd = pIwsNkshrstartymd;
    }

    @Column(order = 28, length = 3)
    @MultiByte
    private String iwsNenkinhosyouy;

    public String getIwsNenkinhosyouy() {
        return iwsNenkinhosyouy;
    }

    public void setIwsNenkinhosyouy(String pIwsNenkinhosyouy) {
        iwsNenkinhosyouy = pIwsNenkinhosyouy;
    }

    @Column(order = 29, length = 10)
    @MultiByte
    private String iwsNenkinkbn;

    public String getIwsNenkinkbn() {
        return iwsNenkinkbn;
    }

    public void setIwsNenkinkbn(String pIwsNenkinkbn) {
        iwsNenkinkbn = pIwsNenkinkbn;
    }

    @Column(order = 30, length = 10)
    @MultiByte
    private String iwsHaitoukbn;

    public String getIwsHaitoukbn() {
        return iwsHaitoukbn;
    }

    public void setIwsHaitoukbn(String pIwsHaitoukbn) {
        iwsHaitoukbn = pIwsHaitoukbn;
    }

    @Column(order = 31, length = 22)
    @MultiByte
    private String iwsSinsakbn;

    public String getIwsSinsakbn() {
        return iwsSinsakbn;
    }

    public void setIwsSinsakbn(String pIwsSinsakbn) {
        iwsSinsakbn = pIwsSinsakbn;
    }

    @Column(order = 32, length = 2)
    private String iwsTkyksuu;

    public String getIwsTkyksuu() {
        return iwsTkyksuu;
    }

    public void setIwsTkyksuu(String pIwsTkyksuu) {
        iwsTkyksuu = pIwsTkyksuu;
    }

    @Column(order = 33, length = 4)
    @MultiByte
    private String iwsLivingneedstkykhyj;

    public String getIwsLivingneedstkykhyj() {
        return iwsLivingneedstkykhyj;
    }

    public void setIwsLivingneedstkykhyj(String pIwsLivingneedstkykhyj) {
        iwsLivingneedstkykhyj = pIwsLivingneedstkykhyj;
    }

    @Column(order = 34, length = 11)
    @MultiByte
    private String iwsHknmnkymd;

    public String getIwsHknmnkymd() {
        return iwsHknmnkymd;
    }

    public void setIwsHknmnkymd(String pIwsHknmnkymd) {
        iwsHknmnkymd = pIwsHknmnkymd;
    }

    @Column(order = 35, length = 20)
    @MultiByte
    private String iwsSyunm;

    public String getIwsSyunm() {
        return iwsSyunm;
    }

    public void setIwsSyunm(String pIwsSyunm) {
        iwsSyunm = pIwsSyunm;
    }

    @Column(order = 36, length = 14)
    private String iwsSyus;

    public String getIwsSyus() {
        return iwsSyus;
    }

    public void setIwsSyus(String pIwsSyus) {
        iwsSyus = pIwsSyus;
    }

    @Column(order = 37, length = 1)
    private String iwsSyustuukasyu;

    public String getIwsSyustuukasyu() {
        return iwsSyustuukasyu;
    }

    public void setIwsSyustuukasyu(String pIwsSyustuukasyu) {
        iwsSyustuukasyu = pIwsSyustuukasyu;
    }

    @Column(order = 38, length = 5)
    @MultiByte
    private String iwsSyuhknkkn;

    public String getIwsSyuhknkkn() {
        return iwsSyuhknkkn;
    }

    public void setIwsSyuhknkkn(String pIwsSyuhknkkn) {
        iwsSyuhknkkn = pIwsSyuhknkkn;
    }

    @Column(order = 39, length = 5)
    @MultiByte
    private String iwsSyuhrkkkn;

    public String getIwsSyuhrkkkn() {
        return iwsSyuhrkkkn;
    }

    public void setIwsSyuhrkkkn(String pIwsSyuhrkkkn) {
        iwsSyuhrkkkn = pIwsSyuhrkkkn;
    }

    @Column(order = 40, length = 2)
    private String iwsTkyknaiyoulinecnt;

    public String getIwsTkyknaiyoulinecnt() {
        return iwsTkyknaiyoulinecnt;
    }

    public void setIwsTkyknaiyoulinecnt(String pIwsTkyknaiyoulinecnt) {
        iwsTkyknaiyoulinecnt = pIwsTkyknaiyoulinecnt;
    }

    @Column(order = 41, length = 20)
    @MultiByte
    private String iwsTkykyknm1;

    public String getIwsTkykyknm1() {
        return iwsTkykyknm1;
    }

    public void setIwsTkykyknm1(String pIwsTkykyknm1) {
        iwsTkykyknm1 = pIwsTkykyknm1;
    }

    @Column(order = 42, length = 14)
    private String iwsTkykyks1;

    public String getIwsTkykyks1() {
        return iwsTkykyks1;
    }

    public void setIwsTkykyks1(String pIwsTkykyks1) {
        iwsTkykyks1 = pIwsTkykyks1;
    }

    @Column(order = 43, length = 1)
    private String iwsTkykstuukasyu1;

    public String getIwsTkykstuukasyu1() {
        return iwsTkykstuukasyu1;
    }

    public void setIwsTkykstuukasyu1(String pIwsTkykstuukasyu1) {
        iwsTkykstuukasyu1 = pIwsTkykstuukasyu1;
    }

    @Column(order = 44, length = 5)
    @MultiByte
    private String iwsTkykhknkkn1;

    public String getIwsTkykhknkkn1() {
        return iwsTkykhknkkn1;
    }

    public void setIwsTkykhknkkn1(String pIwsTkykhknkkn1) {
        iwsTkykhknkkn1 = pIwsTkykhknkkn1;
    }

    @Column(order = 45, length = 5)
    @MultiByte
    private String iwsTkykhrkkkn1;

    public String getIwsTkykhrkkkn1() {
        return iwsTkykhrkkkn1;
    }

    public void setIwsTkykhrkkkn1(String pIwsTkykhrkkkn1) {
        iwsTkykhrkkkn1 = pIwsTkykhrkkkn1;
    }

    @Column(order = 46, length = 20)
    @MultiByte
    private String iwsTkyknm2;

    public String getIwsTkyknm2() {
        return iwsTkyknm2;
    }

    public void setIwsTkyknm2(String pIwsTkyknm2) {
        iwsTkyknm2 = pIwsTkyknm2;
    }

    @Column(order = 47, length = 14)
    private String iwsTkyks2;

    public String getIwsTkyks2() {
        return iwsTkyks2;
    }

    public void setIwsTkyks2(String pIwsTkyks2) {
        iwsTkyks2 = pIwsTkyks2;
    }

    @Column(order = 48, length = 1)
    private String iwsTkykstuukasyu2;

    public String getIwsTkykstuukasyu2() {
        return iwsTkykstuukasyu2;
    }

    public void setIwsTkykstuukasyu2(String pIwsTkykstuukasyu2) {
        iwsTkykstuukasyu2 = pIwsTkykstuukasyu2;
    }

    @Column(order = 49, length = 5)
    @MultiByte
    private String iwsTkykhknkkn2;

    public String getIwsTkykhknkkn2() {
        return iwsTkykhknkkn2;
    }

    public void setIwsTkykhknkkn2(String pIwsTkykhknkkn2) {
        iwsTkykhknkkn2 = pIwsTkykhknkkn2;
    }

    @Column(order = 50, length = 5)
    @MultiByte
    private String iwsTkykhrkkkn2;

    public String getIwsTkykhrkkkn2() {
        return iwsTkykhrkkkn2;
    }

    public void setIwsTkykhrkkkn2(String pIwsTkykhrkkkn2) {
        iwsTkykhrkkkn2 = pIwsTkykhrkkkn2;
    }

    @Column(order = 51, length = 20)
    @MultiByte
    private String iwsTkyknm3;

    public String getIwsTkyknm3() {
        return iwsTkyknm3;
    }

    public void setIwsTkyknm3(String pIwsTkyknm3) {
        iwsTkyknm3 = pIwsTkyknm3;
    }

    @Column(order = 52, length = 14)
    private String iwsTkyks3;

    public String getIwsTkyks3() {
        return iwsTkyks3;
    }

    public void setIwsTkyks3(String pIwsTkyks3) {
        iwsTkyks3 = pIwsTkyks3;
    }

    @Column(order = 53, length = 1)
    private String iwsTkykstuukasyu3;

    public String getIwsTkykstuukasyu3() {
        return iwsTkykstuukasyu3;
    }

    public void setIwsTkykstuukasyu3(String pIwsTkykstuukasyu3) {
        iwsTkykstuukasyu3 = pIwsTkykstuukasyu3;
    }

    @Column(order = 54, length = 5)
    @MultiByte
    private String iwsTkykhknkkn3;

    public String getIwsTkykhknkkn3() {
        return iwsTkykhknkkn3;
    }

    public void setIwsTkykhknkkn3(String pIwsTkykhknkkn3) {
        iwsTkykhknkkn3 = pIwsTkykhknkkn3;
    }

    @Column(order = 55, length = 5)
    @MultiByte
    private String iwsTkykhrkkkn3;

    public String getIwsTkykhrkkkn3() {
        return iwsTkykhrkkkn3;
    }

    public void setIwsTkykhrkkkn3(String pIwsTkykhrkkkn3) {
        iwsTkykhrkkkn3 = pIwsTkykhrkkkn3;
    }

    @Column(order = 56, length = 20)
    @MultiByte
    private String iwsTkyknm4;

    public String getIwsTkyknm4() {
        return iwsTkyknm4;
    }

    public void setIwsTkyknm4(String pIwsTkyknm4) {
        iwsTkyknm4 = pIwsTkyknm4;
    }

    @Column(order = 57, length = 14)
    private String iwsTkyks4;

    public String getIwsTkyks4() {
        return iwsTkyks4;
    }

    public void setIwsTkyks4(String pIwsTkyks4) {
        iwsTkyks4 = pIwsTkyks4;
    }

    @Column(order = 58, length = 1)
    private String iwsTkykstuukasyu4;

    public String getIwsTkykstuukasyu4() {
        return iwsTkykstuukasyu4;
    }

    public void setIwsTkykstuukasyu4(String pIwsTkykstuukasyu4) {
        iwsTkykstuukasyu4 = pIwsTkykstuukasyu4;
    }

    @Column(order = 59, length = 5)
    @MultiByte
    private String iwsTkykhknkkn4;

    public String getIwsTkykhknkkn4() {
        return iwsTkykhknkkn4;
    }

    public void setIwsTkykhknkkn4(String pIwsTkykhknkkn4) {
        iwsTkykhknkkn4 = pIwsTkykhknkkn4;
    }

    @Column(order = 60, length = 5)
    @MultiByte
    private String iwsTkykhrkkkn4;

    public String getIwsTkykhrkkkn4() {
        return iwsTkykhrkkkn4;
    }

    public void setIwsTkykhrkkkn4(String pIwsTkykhrkkkn4) {
        iwsTkykhrkkkn4 = pIwsTkykhrkkkn4;
    }

    @Column(order = 61, length = 20)
    @MultiByte
    private String iwsTkyknm5;

    public String getIwsTkyknm5() {
        return iwsTkyknm5;
    }

    public void setIwsTkyknm5(String pIwsTkyknm5) {
        iwsTkyknm5 = pIwsTkyknm5;
    }

    @Column(order = 62, length = 14)
    private String iwsTkyks5;

    public String getIwsTkyks5() {
        return iwsTkyks5;
    }

    public void setIwsTkyks5(String pIwsTkyks5) {
        iwsTkyks5 = pIwsTkyks5;
    }

    @Column(order = 63, length = 1)
    private String iwsTkykstuukasyu5;

    public String getIwsTkykstuukasyu5() {
        return iwsTkykstuukasyu5;
    }

    public void setIwsTkykstuukasyu5(String pIwsTkykstuukasyu5) {
        iwsTkykstuukasyu5 = pIwsTkykstuukasyu5;
    }

    @Column(order = 64, length = 5)
    @MultiByte
    private String iwsTkykhknkkn5;

    public String getIwsTkykhknkkn5() {
        return iwsTkykhknkkn5;
    }

    public void setIwsTkykhknkkn5(String pIwsTkykhknkkn5) {
        iwsTkykhknkkn5 = pIwsTkykhknkkn5;
    }

    @Column(order = 65, length = 5)
    @MultiByte
    private String iwsTkykhrkkkn5;

    public String getIwsTkykhrkkkn5() {
        return iwsTkykhrkkkn5;
    }

    public void setIwsTkykhrkkkn5(String pIwsTkykhrkkkn5) {
        iwsTkykhrkkkn5 = pIwsTkykhrkkkn5;
    }

    @Column(order = 66, length = 20)
    @MultiByte
    private String iwsTkyknm6;

    public String getIwsTkyknm6() {
        return iwsTkyknm6;
    }

    public void setIwsTkyknm6(String pIwsTkyknm6) {
        iwsTkyknm6 = pIwsTkyknm6;
    }

    @Column(order = 67, length = 14)
    private String iwsTkyks6;

    public String getIwsTkyks6() {
        return iwsTkyks6;
    }

    public void setIwsTkyks6(String pIwsTkyks6) {
        iwsTkyks6 = pIwsTkyks6;
    }

    @Column(order = 68, length = 1)
    private String iwsTkykstuukasyu6;

    public String getIwsTkykstuukasyu6() {
        return iwsTkykstuukasyu6;
    }

    public void setIwsTkykstuukasyu6(String pIwsTkykstuukasyu6) {
        iwsTkykstuukasyu6 = pIwsTkykstuukasyu6;
    }

    @Column(order = 69, length = 5)
    @MultiByte
    private String iwsTkykhknkkn6;

    public String getIwsTkykhknkkn6() {
        return iwsTkykhknkkn6;
    }

    public void setIwsTkykhknkkn6(String pIwsTkykhknkkn6) {
        iwsTkykhknkkn6 = pIwsTkykhknkkn6;
    }

    @Column(order = 70, length = 5)
    @MultiByte
    private String iwsTkykhrkkkn6;

    public String getIwsTkykhrkkkn6() {
        return iwsTkykhrkkkn6;
    }

    public void setIwsTkykhrkkkn6(String pIwsTkykhrkkkn6) {
        iwsTkykhrkkkn6 = pIwsTkykhrkkkn6;
    }

    @Column(order = 71, length = 20)
    @MultiByte
    private String iwsTkyknm7;

    public String getIwsTkyknm7() {
        return iwsTkyknm7;
    }

    public void setIwsTkyknm7(String pIwsTkyknm7) {
        iwsTkyknm7 = pIwsTkyknm7;
    }

    @Column(order = 72, length = 14)
    private String iwsTkyks7;

    public String getIwsTkyks7() {
        return iwsTkyks7;
    }

    public void setIwsTkyks7(String pIwsTkyks7) {
        iwsTkyks7 = pIwsTkyks7;
    }

    @Column(order = 73, length = 1)
    private String iwsTkykstuukasyu7;

    public String getIwsTkykstuukasyu7() {
        return iwsTkykstuukasyu7;
    }

    public void setIwsTkykstuukasyu7(String pIwsTkykstuukasyu7) {
        iwsTkykstuukasyu7 = pIwsTkykstuukasyu7;
    }

    @Column(order = 74, length = 5)
    @MultiByte
    private String iwsTkykhknkkn7;

    public String getIwsTkykhknkkn7() {
        return iwsTkykhknkkn7;
    }

    public void setIwsTkykhknkkn7(String pIwsTkykhknkkn7) {
        iwsTkykhknkkn7 = pIwsTkykhknkkn7;
    }

    @Column(order = 75, length = 5)
    @MultiByte
    private String iwsTkykhrkkkn7;

    public String getIwsTkykhrkkkn7() {
        return iwsTkykhrkkkn7;
    }

    public void setIwsTkykhrkkkn7(String pIwsTkykhrkkkn7) {
        iwsTkykhrkkkn7 = pIwsTkykhrkkkn7;
    }

    @Column(order = 76, length = 20)
    @MultiByte
    private String iwsTkyknm8;

    public String getIwsTkyknm8() {
        return iwsTkyknm8;
    }

    public void setIwsTkyknm8(String pIwsTkyknm8) {
        iwsTkyknm8 = pIwsTkyknm8;
    }

    @Column(order = 77, length = 14)
    private String iwsTkyks8;

    public String getIwsTkyks8() {
        return iwsTkyks8;
    }

    public void setIwsTkyks8(String pIwsTkyks8) {
        iwsTkyks8 = pIwsTkyks8;
    }

    @Column(order = 78, length = 1)
    private String iwsTkykstuukasyu8;

    public String getIwsTkykstuukasyu8() {
        return iwsTkykstuukasyu8;
    }

    public void setIwsTkykstuukasyu8(String pIwsTkykstuukasyu8) {
        iwsTkykstuukasyu8 = pIwsTkykstuukasyu8;
    }

    @Column(order = 79, length = 5)
    @MultiByte
    private String iwsTkykhknkkn8;

    public String getIwsTkykhknkkn8() {
        return iwsTkykhknkkn8;
    }

    public void setIwsTkykhknkkn8(String pIwsTkykhknkkn8) {
        iwsTkykhknkkn8 = pIwsTkykhknkkn8;
    }

    @Column(order = 80, length = 5)
    @MultiByte
    private String iwsTkykhrkkkn8;

    public String getIwsTkykhrkkkn8() {
        return iwsTkykhrkkkn8;
    }

    public void setIwsTkykhrkkkn8(String pIwsTkykhrkkkn8) {
        iwsTkykhrkkkn8 = pIwsTkykhrkkkn8;
    }

    @Column(order = 81, length = 20)
    @MultiByte
    private String iwsTkyknm9;

    public String getIwsTkyknm9() {
        return iwsTkyknm9;
    }

    public void setIwsTkyknm9(String pIwsTkyknm9) {
        iwsTkyknm9 = pIwsTkyknm9;
    }

    @Column(order = 82, length = 14)
    private String iwsTkyks9;

    public String getIwsTkyks9() {
        return iwsTkyks9;
    }

    public void setIwsTkyks9(String pIwsTkyks9) {
        iwsTkyks9 = pIwsTkyks9;
    }

    @Column(order = 83, length = 1)
    private String iwsTkykstuukasyu9;

    public String getIwsTkykstuukasyu9() {
        return iwsTkykstuukasyu9;
    }

    public void setIwsTkykstuukasyu9(String pIwsTkykstuukasyu9) {
        iwsTkykstuukasyu9 = pIwsTkykstuukasyu9;
    }

    @Column(order = 84, length = 5)
    @MultiByte
    private String iwsTkykhknkkn9;

    public String getIwsTkykhknkkn9() {
        return iwsTkykhknkkn9;
    }

    public void setIwsTkykhknkkn9(String pIwsTkykhknkkn9) {
        iwsTkykhknkkn9 = pIwsTkykhknkkn9;
    }

    @Column(order = 85, length = 5)
    @MultiByte
    private String iwsTkykhrkkkn9;

    public String getIwsTkykhrkkkn9() {
        return iwsTkykhrkkkn9;
    }

    public void setIwsTkykhrkkkn9(String pIwsTkykhrkkkn9) {
        iwsTkykhrkkkn9 = pIwsTkykhrkkkn9;
    }

    @Column(order = 86, length = 20)
    @MultiByte
    private String iwsTkyknm10;

    public String getIwsTkyknm10() {
        return iwsTkyknm10;
    }

    public void setIwsTkyknm10(String pIwsTkyknm10) {
        iwsTkyknm10 = pIwsTkyknm10;
    }

    @Column(order = 87, length = 14)
    private String iwsTkyks10;

    public String getIwsTkyks10() {
        return iwsTkyks10;
    }

    public void setIwsTkyks10(String pIwsTkyks10) {
        iwsTkyks10 = pIwsTkyks10;
    }

    @Column(order = 88, length = 1)
    private String iwsTkykstuukasyu10;

    public String getIwsTkykstuukasyu10() {
        return iwsTkykstuukasyu10;
    }

    public void setIwsTkykstuukasyu10(String pIwsTkykstuukasyu10) {
        iwsTkykstuukasyu10 = pIwsTkykstuukasyu10;
    }

    @Column(order = 89, length = 5)
    @MultiByte
    private String iwsTkykhknkkn10;

    public String getIwsTkykhknkkn10() {
        return iwsTkykhknkkn10;
    }

    public void setIwsTkykhknkkn10(String pIwsTkykhknkkn10) {
        iwsTkykhknkkn10 = pIwsTkykhknkkn10;
    }

    @Column(order = 90, length = 5)
    @MultiByte
    private String iwsTkykhrkkkn10;

    public String getIwsTkykhrkkkn10() {
        return iwsTkykhrkkkn10;
    }

    public void setIwsTkykhrkkkn10(String pIwsTkykhrkkkn10) {
        iwsTkykhrkkkn10 = pIwsTkykhrkkkn10;
    }

    @Column(order = 91, length = 20)
    @MultiByte
    private String iwsTkyknm11;

    public String getIwsTkyknm11() {
        return iwsTkyknm11;
    }

    public void setIwsTkyknm11(String pIwsTkyknm11) {
        iwsTkyknm11 = pIwsTkyknm11;
    }

    @Column(order = 92, length = 14)
    private String iwsTkyks11;

    public String getIwsTkyks11() {
        return iwsTkyks11;
    }

    public void setIwsTkyks11(String pIwsTkyks11) {
        iwsTkyks11 = pIwsTkyks11;
    }

    @Column(order = 93, length = 1)
    private String iwsTkykstuukasyu11;

    public String getIwsTkykstuukasyu11() {
        return iwsTkykstuukasyu11;
    }

    public void setIwsTkykstuukasyu11(String pIwsTkykstuukasyu11) {
        iwsTkykstuukasyu11 = pIwsTkykstuukasyu11;
    }

    @Column(order = 94, length = 5)
    @MultiByte
    private String iwsTkykhknkkn11;

    public String getIwsTkykhknkkn11() {
        return iwsTkykhknkkn11;
    }

    public void setIwsTkykhknkkn11(String pIwsTkykhknkkn11) {
        iwsTkykhknkkn11 = pIwsTkykhknkkn11;
    }

    @Column(order = 95, length = 5)
    @MultiByte
    private String iwsTkykhrkkkn11;

    public String getIwsTkykhrkkkn11() {
        return iwsTkykhrkkkn11;
    }

    public void setIwsTkykhrkkkn11(String pIwsTkykhrkkkn11) {
        iwsTkykhrkkkn11 = pIwsTkykhrkkkn11;
    }

    @Column(order = 96, length = 20)
    @MultiByte
    private String iwsTkyknm12;

    public String getIwsTkyknm12() {
        return iwsTkyknm12;
    }

    public void setIwsTkyknm12(String pIwsTkyknm12) {
        iwsTkyknm12 = pIwsTkyknm12;
    }

    @Column(order = 97, length = 14)
    private String iwsTkyks12;

    public String getIwsTkyks12() {
        return iwsTkyks12;
    }

    public void setIwsTkyks12(String pIwsTkyks12) {
        iwsTkyks12 = pIwsTkyks12;
    }

    @Column(order = 98, length = 1)
    private String iwsTkykstuukasyu12;

    public String getIwsTkykstuukasyu12() {
        return iwsTkykstuukasyu12;
    }

    public void setIwsTkykstuukasyu12(String pIwsTkykstuukasyu12) {
        iwsTkykstuukasyu12 = pIwsTkykstuukasyu12;
    }

    @Column(order = 99, length = 5)
    @MultiByte
    private String iwsTkykhknkkn12;

    public String getIwsTkykhknkkn12() {
        return iwsTkykhknkkn12;
    }

    public void setIwsTkykhknkkn12(String pIwsTkykhknkkn12) {
        iwsTkykhknkkn12 = pIwsTkykhknkkn12;
    }

    @Column(order = 100, length = 5)
    @MultiByte
    private String iwsTkykhrkkkn12;

    public String getIwsTkykhrkkkn12() {
        return iwsTkykhrkkkn12;
    }

    public void setIwsTkykhrkkkn12(String pIwsTkykhrkkkn12) {
        iwsTkykhrkkkn12 = pIwsTkykhrkkkn12;
    }

    @Column(order = 101, length = 20)
    @MultiByte
    private String iwsTkyknm13;

    public String getIwsTkyknm13() {
        return iwsTkyknm13;
    }

    public void setIwsTkyknm13(String pIwsTkyknm13) {
        iwsTkyknm13 = pIwsTkyknm13;
    }

    @Column(order = 102, length = 14)
    private String iwsTkyks13;

    public String getIwsTkyks13() {
        return iwsTkyks13;
    }

    public void setIwsTkyks13(String pIwsTkyks13) {
        iwsTkyks13 = pIwsTkyks13;
    }

    @Column(order = 103, length = 1)
    private String iwsTkykstuukasyu13;

    public String getIwsTkykstuukasyu13() {
        return iwsTkykstuukasyu13;
    }

    public void setIwsTkykstuukasyu13(String pIwsTkykstuukasyu13) {
        iwsTkykstuukasyu13 = pIwsTkykstuukasyu13;
    }

    @Column(order = 104, length = 5)
    @MultiByte
    private String iwsTkykhknkkn13;

    public String getIwsTkykhknkkn13() {
        return iwsTkykhknkkn13;
    }

    public void setIwsTkykhknkkn13(String pIwsTkykhknkkn13) {
        iwsTkykhknkkn13 = pIwsTkykhknkkn13;
    }

    @Column(order = 105, length = 5)
    @MultiByte
    private String iwsTkykhrkkkn13;

    public String getIwsTkykhrkkkn13() {
        return iwsTkykhrkkkn13;
    }

    public void setIwsTkykhrkkkn13(String pIwsTkykhrkkkn13) {
        iwsTkykhrkkkn13 = pIwsTkykhrkkkn13;
    }

    @Column(order = 106, length = 20)
    @MultiByte
    private String iwsTkyknm14;

    public String getIwsTkyknm14() {
        return iwsTkyknm14;
    }

    public void setIwsTkyknm14(String pIwsTkyknm14) {
        iwsTkyknm14 = pIwsTkyknm14;
    }

    @Column(order = 107, length = 14)
    private String iwsTkyks14;

    public String getIwsTkyks14() {
        return iwsTkyks14;
    }

    public void setIwsTkyks14(String pIwsTkyks14) {
        iwsTkyks14 = pIwsTkyks14;
    }

    @Column(order = 108, length = 1)
    private String iwsTkykstuukasyu14;

    public String getIwsTkykstuukasyu14() {
        return iwsTkykstuukasyu14;
    }

    public void setIwsTkykstuukasyu14(String pIwsTkykstuukasyu14) {
        iwsTkykstuukasyu14 = pIwsTkykstuukasyu14;
    }

    @Column(order = 109, length = 5)
    @MultiByte
    private String iwsTkykhknkkn14;

    public String getIwsTkykhknkkn14() {
        return iwsTkykhknkkn14;
    }

    public void setIwsTkykhknkkn14(String pIwsTkykhknkkn14) {
        iwsTkykhknkkn14 = pIwsTkykhknkkn14;
    }

    @Column(order = 110, length = 5)
    @MultiByte
    private String iwsTkykhrkkkn14;

    public String getIwsTkykhrkkkn14() {
        return iwsTkykhrkkkn14;
    }

    public void setIwsTkykhrkkkn14(String pIwsTkykhrkkkn14) {
        iwsTkykhrkkkn14 = pIwsTkykhrkkkn14;
    }

    @Column(order = 111, length = 20)
    @MultiByte
    private String iwsTkyknm15;

    public String getIwsTkyknm15() {
        return iwsTkyknm15;
    }

    public void setIwsTkyknm15(String pIwsTkyknm15) {
        iwsTkyknm15 = pIwsTkyknm15;
    }

    @Column(order = 112, length = 14)
    private String iwsTkyks15;

    public String getIwsTkyks15() {
        return iwsTkyks15;
    }

    public void setIwsTkyks15(String pIwsTkyks15) {
        iwsTkyks15 = pIwsTkyks15;
    }

    @Column(order = 113, length = 1)
    private String iwsTkykstuukasyu15;

    public String getIwsTkykstuukasyu15() {
        return iwsTkykstuukasyu15;
    }

    public void setIwsTkykstuukasyu15(String pIwsTkykstuukasyu15) {
        iwsTkykstuukasyu15 = pIwsTkykstuukasyu15;
    }

    @Column(order = 114, length = 5)
    @MultiByte
    private String iwsTkykhknkkn15;

    public String getIwsTkykhknkkn15() {
        return iwsTkykhknkkn15;
    }

    public void setIwsTkykhknkkn15(String pIwsTkykhknkkn15) {
        iwsTkykhknkkn15 = pIwsTkykhknkkn15;
    }

    @Column(order = 115, length = 5)
    @MultiByte
    private String iwsTkykhrkkkn15;

    public String getIwsTkykhrkkkn15() {
        return iwsTkykhrkkkn15;
    }

    public void setIwsTkykhrkkkn15(String pIwsTkykhrkkkn15) {
        iwsTkykhrkkkn15 = pIwsTkykhrkkkn15;
    }

    @Column(order = 116, length = 2)
    private String iwsSyouhnnylinecnt;

    public String getIwsSyouhnnylinecnt() {
        return iwsSyouhnnylinecnt;
    }

    public void setIwsSyouhnnylinecnt(String pIwsSyouhnnylinecnt) {
        iwsSyouhnnylinecnt = pIwsSyouhnnylinecnt;
    }

    @Column(order = 117, length = 48)
    @MultiByte
    private String iwsSyouhnnaiyou1;

    public String getIwsSyouhnnaiyou1() {
        return iwsSyouhnnaiyou1;
    }

    public void setIwsSyouhnnaiyou1(String pIwsSyouhnnaiyou1) {
        iwsSyouhnnaiyou1 = pIwsSyouhnnaiyou1;
    }

    @Column(order = 118, length = 48)
    @MultiByte
    private String iwsSyouhnnaiyou2;

    public String getIwsSyouhnnaiyou2() {
        return iwsSyouhnnaiyou2;
    }

    public void setIwsSyouhnnaiyou2(String pIwsSyouhnnaiyou2) {
        iwsSyouhnnaiyou2 = pIwsSyouhnnaiyou2;
    }

    @Column(order = 119, length = 48)
    @MultiByte
    private String iwsSyouhnnaiyou3;

    public String getIwsSyouhnnaiyou3() {
        return iwsSyouhnnaiyou3;
    }

    public void setIwsSyouhnnaiyou3(String pIwsSyouhnnaiyou3) {
        iwsSyouhnnaiyou3 = pIwsSyouhnnaiyou3;
    }

    @Column(order = 120, length = 2)
    private String iwsHosyounaiyoulinecnt;

    public String getIwsHosyounaiyoulinecnt() {
        return iwsHosyounaiyoulinecnt;
    }

    public void setIwsHosyounaiyoulinecnt(String pIwsHosyounaiyoulinecnt) {
        iwsHosyounaiyoulinecnt = pIwsHosyounaiyoulinecnt;
    }

    @Column(order = 121, length = 48)
    @MultiByte
    private String iwsHosyounaiyou1;

    public String getIwsHosyounaiyou1() {
        return iwsHosyounaiyou1;
    }

    public void setIwsHosyounaiyou1(String pIwsHosyounaiyou1) {
        iwsHosyounaiyou1 = pIwsHosyounaiyou1;
    }

    @Column(order = 122, length = 48)
    @MultiByte
    private String iwsHosyounaiyou2;

    public String getIwsHosyounaiyou2() {
        return iwsHosyounaiyou2;
    }

    public void setIwsHosyounaiyou2(String pIwsHosyounaiyou2) {
        iwsHosyounaiyou2 = pIwsHosyounaiyou2;
    }

    @Column(order = 123, length = 48)
    @MultiByte
    private String iwsHosyounaiyou3;

    public String getIwsHosyounaiyou3() {
        return iwsHosyounaiyou3;
    }

    public void setIwsHosyounaiyou3(String pIwsHosyounaiyou3) {
        iwsHosyounaiyou3 = pIwsHosyounaiyou3;
    }

    @Column(order = 124, length = 48)
    @MultiByte
    private String iwsHosyounaiyou4;

    public String getIwsHosyounaiyou4() {
        return iwsHosyounaiyou4;
    }

    public void setIwsHosyounaiyou4(String pIwsHosyounaiyou4) {
        iwsHosyounaiyou4 = pIwsHosyounaiyou4;
    }

    @Column(order = 125, length = 48)
    @MultiByte
    private String iwsHosyounaiyou5;

    public String getIwsHosyounaiyou5() {
        return iwsHosyounaiyou5;
    }

    public void setIwsHosyounaiyou5(String pIwsHosyounaiyou5) {
        iwsHosyounaiyou5 = pIwsHosyounaiyou5;
    }

    @Column(order = 126, length = 48)
    @MultiByte
    private String iwsHosyounaiyou6;

    public String getIwsHosyounaiyou6() {
        return iwsHosyounaiyou6;
    }

    public void setIwsHosyounaiyou6(String pIwsHosyounaiyou6) {
        iwsHosyounaiyou6 = pIwsHosyounaiyou6;
    }

    @Column(order = 127, length = 48)
    @MultiByte
    private String iwsHosyounaiyou7;

    public String getIwsHosyounaiyou7() {
        return iwsHosyounaiyou7;
    }

    public void setIwsHosyounaiyou7(String pIwsHosyounaiyou7) {
        iwsHosyounaiyou7 = pIwsHosyounaiyou7;
    }

    @Column(order = 128, length = 48)
    @MultiByte
    private String iwsHosyounaiyou8;

    public String getIwsHosyounaiyou8() {
        return iwsHosyounaiyou8;
    }

    public void setIwsHosyounaiyou8(String pIwsHosyounaiyou8) {
        iwsHosyounaiyou8 = pIwsHosyounaiyou8;
    }

    @Column(order = 129, length = 48)
    @MultiByte
    private String iwsHosyounaiyou9;

    public String getIwsHosyounaiyou9() {
        return iwsHosyounaiyou9;
    }

    public void setIwsHosyounaiyou9(String pIwsHosyounaiyou9) {
        iwsHosyounaiyou9 = pIwsHosyounaiyou9;
    }

    @Column(order = 130, length = 48)
    @MultiByte
    private String iwsHosyounaiyou10;

    public String getIwsHosyounaiyou10() {
        return iwsHosyounaiyou10;
    }

    public void setIwsHosyounaiyou10(String pIwsHosyounaiyou10) {
        iwsHosyounaiyou10 = pIwsHosyounaiyou10;
    }

    @Column(order = 131, length = 8)
    private String iwsTanmatutyouhyoucd2;

    public String getIwsTanmatutyouhyoucd2() {
        return iwsTanmatutyouhyoucd2;
    }

    public void setIwsTanmatutyouhyoucd2(String pIwsTanmatutyouhyoucd2) {
        iwsTanmatutyouhyoucd2 = pIwsTanmatutyouhyoucd2;
    }

    @Column(order = 132, length = 48)
    @MultiByte
    private String iwsHosyounaiyou11;

    public String getIwsHosyounaiyou11() {
        return iwsHosyounaiyou11;
    }

    public void setIwsHosyounaiyou11(String pIwsHosyounaiyou11) {
        iwsHosyounaiyou11 = pIwsHosyounaiyou11;
    }

    @Column(order = 133, length = 48)
    @MultiByte
    private String iwsHosyounaiyou12;

    public String getIwsHosyounaiyou12() {
        return iwsHosyounaiyou12;
    }

    public void setIwsHosyounaiyou12(String pIwsHosyounaiyou12) {
        iwsHosyounaiyou12 = pIwsHosyounaiyou12;
    }

    @Column(order = 134, length = 48)
    @MultiByte
    private String iwsHosyounaiyou13;

    public String getIwsHosyounaiyou13() {
        return iwsHosyounaiyou13;
    }

    public void setIwsHosyounaiyou13(String pIwsHosyounaiyou13) {
        iwsHosyounaiyou13 = pIwsHosyounaiyou13;
    }

    @Column(order = 135, length = 48)
    @MultiByte
    private String iwsHosyounaiyou14;

    public String getIwsHosyounaiyou14() {
        return iwsHosyounaiyou14;
    }

    public void setIwsHosyounaiyou14(String pIwsHosyounaiyou14) {
        iwsHosyounaiyou14 = pIwsHosyounaiyou14;
    }

    @Column(order = 136, length = 48)
    @MultiByte
    private String iwsHosyounaiyou15;

    public String getIwsHosyounaiyou15() {
        return iwsHosyounaiyou15;
    }

    public void setIwsHosyounaiyou15(String pIwsHosyounaiyou15) {
        iwsHosyounaiyou15 = pIwsHosyounaiyou15;
    }

    @Column(order = 137, length = 48)
    @MultiByte
    private String iwsHosyounaiyou16;

    public String getIwsHosyounaiyou16() {
        return iwsHosyounaiyou16;
    }

    public void setIwsHosyounaiyou16(String pIwsHosyounaiyou16) {
        iwsHosyounaiyou16 = pIwsHosyounaiyou16;
    }

    @Column(order = 138, length = 48)
    @MultiByte
    private String iwsHosyounaiyou17;

    public String getIwsHosyounaiyou17() {
        return iwsHosyounaiyou17;
    }

    public void setIwsHosyounaiyou17(String pIwsHosyounaiyou17) {
        iwsHosyounaiyou17 = pIwsHosyounaiyou17;
    }

    @Column(order = 139, length = 48)
    @MultiByte
    private String iwsHosyounaiyou18;

    public String getIwsHosyounaiyou18() {
        return iwsHosyounaiyou18;
    }

    public void setIwsHosyounaiyou18(String pIwsHosyounaiyou18) {
        iwsHosyounaiyou18 = pIwsHosyounaiyou18;
    }

    @Column(order = 140, length = 48)
    @MultiByte
    private String iwsHosyounaiyou19;

    public String getIwsHosyounaiyou19() {
        return iwsHosyounaiyou19;
    }

    public void setIwsHosyounaiyou19(String pIwsHosyounaiyou19) {
        iwsHosyounaiyou19 = pIwsHosyounaiyou19;
    }

    @Column(order = 141, length = 48)
    @MultiByte
    private String iwsHosyounaiyou20;

    public String getIwsHosyounaiyou20() {
        return iwsHosyounaiyou20;
    }

    public void setIwsHosyounaiyou20(String pIwsHosyounaiyou20) {
        iwsHosyounaiyou20 = pIwsHosyounaiyou20;
    }

    @Column(order = 142, length = 48)
    @MultiByte
    private String iwsHosyounaiyou21;

    public String getIwsHosyounaiyou21() {
        return iwsHosyounaiyou21;
    }

    public void setIwsHosyounaiyou21(String pIwsHosyounaiyou21) {
        iwsHosyounaiyou21 = pIwsHosyounaiyou21;
    }

    @Column(order = 143, length = 48)
    @MultiByte
    private String iwsHosyounaiyou22;

    public String getIwsHosyounaiyou22() {
        return iwsHosyounaiyou22;
    }

    public void setIwsHosyounaiyou22(String pIwsHosyounaiyou22) {
        iwsHosyounaiyou22 = pIwsHosyounaiyou22;
    }

    @Column(order = 144, length = 48)
    @MultiByte
    private String iwsHosyounaiyou23;

    public String getIwsHosyounaiyou23() {
        return iwsHosyounaiyou23;
    }

    public void setIwsHosyounaiyou23(String pIwsHosyounaiyou23) {
        iwsHosyounaiyou23 = pIwsHosyounaiyou23;
    }

    @Column(order = 145, length = 48)
    @MultiByte
    private String iwsHosyounaiyou24;

    public String getIwsHosyounaiyou24() {
        return iwsHosyounaiyou24;
    }

    public void setIwsHosyounaiyou24(String pIwsHosyounaiyou24) {
        iwsHosyounaiyou24 = pIwsHosyounaiyou24;
    }

    @Column(order = 146, length = 48)
    @MultiByte
    private String iwsHosyounaiyou25;

    public String getIwsHosyounaiyou25() {
        return iwsHosyounaiyou25;
    }

    public void setIwsHosyounaiyou25(String pIwsHosyounaiyou25) {
        iwsHosyounaiyou25 = pIwsHosyounaiyou25;
    }

    @Column(order = 147, length = 2)
    private String iwsHenkoukeiilinecnt;

    public String getIwsHenkoukeiilinecnt() {
        return iwsHenkoukeiilinecnt;
    }

    public void setIwsHenkoukeiilinecnt(String pIwsHenkoukeiilinecnt) {
        iwsHenkoukeiilinecnt = pIwsHenkoukeiilinecnt;
    }

    @Column(order = 148, length = 22)
    @MultiByte
    private String iwsHenkoukeii1;

    public String getIwsHenkoukeii1() {
        return iwsHenkoukeii1;
    }

    public void setIwsHenkoukeii1(String pIwsHenkoukeii1) {
        iwsHenkoukeii1 = pIwsHenkoukeii1;
    }

    @Column(order = 149, length = 22)
    @MultiByte
    private String iwsHenkoukeii2;

    public String getIwsHenkoukeii2() {
        return iwsHenkoukeii2;
    }

    public void setIwsHenkoukeii2(String pIwsHenkoukeii2) {
        iwsHenkoukeii2 = pIwsHenkoukeii2;
    }

    @Column(order = 150, length = 22)
    @MultiByte
    private String iwsHenkoukeii3;

    public String getIwsHenkoukeii3() {
        return iwsHenkoukeii3;
    }

    public void setIwsHenkoukeii3(String pIwsHenkoukeii3) {
        iwsHenkoukeii3 = pIwsHenkoukeii3;
    }

    @Column(order = 151, length = 22)
    @MultiByte
    private String iwsHenkoukeii4;

    public String getIwsHenkoukeii4() {
        return iwsHenkoukeii4;
    }

    public void setIwsHenkoukeii4(String pIwsHenkoukeii4) {
        iwsHenkoukeii4 = pIwsHenkoukeii4;
    }

    @Column(order = 152, length = 22)
    @MultiByte
    private String iwsHenkoukeii5;

    public String getIwsHenkoukeii5() {
        return iwsHenkoukeii5;
    }

    public void setIwsHenkoukeii5(String pIwsHenkoukeii5) {
        iwsHenkoukeii5 = pIwsHenkoukeii5;
    }

    @Column(order = 153, length = 22)
    @MultiByte
    private String iwsHenkoukeii6;

    public String getIwsHenkoukeii6() {
        return iwsHenkoukeii6;
    }

    public void setIwsHenkoukeii6(String pIwsHenkoukeii6) {
        iwsHenkoukeii6 = pIwsHenkoukeii6;
    }

    @Column(order = 154, length = 22)
    @MultiByte
    private String iwsHenkoukeii7;

    public String getIwsHenkoukeii7() {
        return iwsHenkoukeii7;
    }

    public void setIwsHenkoukeii7(String pIwsHenkoukeii7) {
        iwsHenkoukeii7 = pIwsHenkoukeii7;
    }

    @Column(order = 155, length = 22)
    @MultiByte
    private String iwsHenkoukeii8;

    public String getIwsHenkoukeii8() {
        return iwsHenkoukeii8;
    }

    public void setIwsHenkoukeii8(String pIwsHenkoukeii8) {
        iwsHenkoukeii8 = pIwsHenkoukeii8;
    }

    @Column(order = 156, length = 22)
    @MultiByte
    private String iwsHenkoukeii9;

    public String getIwsHenkoukeii9() {
        return iwsHenkoukeii9;
    }

    public void setIwsHenkoukeii9(String pIwsHenkoukeii9) {
        iwsHenkoukeii9 = pIwsHenkoukeii9;
    }

    @Column(order = 157, length = 22)
    @MultiByte
    private String iwsHenkoukeii10;

    public String getIwsHenkoukeii10() {
        return iwsHenkoukeii10;
    }

    public void setIwsHenkoukeii10(String pIwsHenkoukeii10) {
        iwsHenkoukeii10 = pIwsHenkoukeii10;
    }

    @Column(order = 158, length = 2)
    private String iwsBsydairitenlinecnt;

    public String getIwsBsydairitenlinecnt() {
        return iwsBsydairitenlinecnt;
    }

    public void setIwsBsydairitenlinecnt(String pIwsBsydairitenlinecnt) {
        iwsBsydairitenlinecnt = pIwsBsydairitenlinecnt;
    }

    @Column(order = 159, length = 20)
    @MultiByte
    private String iwsBosyuudairitennm1;

    public String getIwsBosyuudairitennm1() {
        return iwsBosyuudairitennm1;
    }

    public void setIwsBosyuudairitennm1(String pIwsBosyuudairitennm1) {
        iwsBosyuudairitennm1 = pIwsBosyuudairitennm1;
    }

    @Column(order = 160, length = 4)
    private String iwsDairitenbnwari1;

    public String getIwsDairitenbnwari1() {
        return iwsDairitenbnwari1;
    }

    public void setIwsDairitenbnwari1(String pIwsDairitenbnwari1) {
        iwsDairitenbnwari1 = pIwsDairitenbnwari1;
    }

    @Column(order = 161, length = 20)
    @MultiByte
    private String iwsBosyuudairitennm2;

    public String getIwsBosyuudairitennm2() {
        return iwsBosyuudairitennm2;
    }

    public void setIwsBosyuudairitennm2(String pIwsBosyuudairitennm2) {
        iwsBosyuudairitennm2 = pIwsBosyuudairitennm2;
    }

    @Column(order = 162, length = 4)
    private String iwsDairitenbnwari2;

    public String getIwsDairitenbnwari2() {
        return iwsDairitenbnwari2;
    }

    public void setIwsDairitenbnwari2(String pIwsDairitenbnwari2) {
        iwsDairitenbnwari2 = pIwsDairitenbnwari2;
    }

    @Column(order = 163, length = 1)
    private String iwsmsgoutkbn;

    public String getIwsmsgoutkbn() {
        return iwsmsgoutkbn;
    }

    public void setIwsmsgoutkbn(String pIwsmsgoutkbn) {
        iwsmsgoutkbn = pIwsmsgoutkbn;
    }

    @Column(order = 164, length = 1)
    private String iwsHosyouiktmnoskykhyj;

    public String getIwsHosyouiktmnoskykhyj() {
        return iwsHosyouiktmnoskykhyj;
    }

    public void setIwsHosyouiktmnoskykhyj(String pIwsHosyouiktmnoskykhyj) {
        iwsHosyouiktmnoskykhyj = pIwsHosyouiktmnoskykhyj;
    }

    @Column(order = 165, length = 43)
    private String iwsHhknsyanmkn;

    public String getIwsHhknsyanmkn() {
        return iwsHhknsyanmkn;
    }

    public void setIwsHhknsyanmkn(String pIwsHhknsyanmkn) {
        iwsHhknsyanmkn = pIwsHhknsyanmkn;
    }

    @Column(order = 166, length = 20)
    @MultiByte
    private String iwsPsyuunoujk;

    public String getIwsPsyuunoujk() {
        return iwsPsyuunoujk;
    }

    public void setIwsPsyuunoujk(String pIwsPsyuunoujk) {
        iwsPsyuunoujk = pIwsPsyuunoujk;
    }

    @Column(order = 167, length = 11)
    @MultiByte
    private String iwsJkipjytym;

    public String getIwsJkipjytym() {
        return iwsJkipjytym;
    }

    public void setIwsJkipjytym(String pIwsJkipjytym) {
        iwsJkipjytym = pIwsJkipjytym;
    }

    @Column(order = 168, length = 2)
    private String iwsMdhnsyubetukbn;

    public String getIwsMdhnsyubetukbn() {
        return iwsMdhnsyubetukbn;
    }

    public void setIwsMdhnsyubetukbn(String pIwsMdhnsyubetukbn) {
        iwsMdhnsyubetukbn = pIwsMdhnsyubetukbn;
    }

    @Column(order = 169, length = 8)
    private String iwsTanmatutyouhyoucd3;

    public String getIwsTanmatutyouhyoucd3() {
        return iwsTanmatutyouhyoucd3;
    }

    public void setIwsTanmatutyouhyoucd3(String pIwsTanmatutyouhyoucd3) {
        iwsTanmatutyouhyoucd3 = pIwsTanmatutyouhyoucd3;
    }

    @Column(order = 170, length = 41)
    private String iwsNkuktnmkn;

    public String getIwsNkuktnmkn() {
        return iwsNkuktnmkn;
    }

    public void setIwsNkuktnmkn(String pIwsNkuktnmkn) {
        iwsNkuktnmkn = pIwsNkuktnmkn;
    }

    @Column(order = 171, length = 37)
    @MultiByte
    private String iwsNkuktnmkj;

    public String getIwsNkuktnmkj() {
        return iwsNkuktnmkj;
    }

    public void setIwsNkuktnmkj(String pIwsNkuktnmkj) {
        iwsNkuktnmkj = pIwsNkuktnmkj;
    }

    @Column(order = 172, length = 2)
    @MultiByte
    private String iwsNkukesei;

    public String getIwsNkukesei() {
        return iwsNkukesei;
    }

    public void setIwsNkukesei(String pIwsNkukesei) {
        iwsNkukesei = pIwsNkukesei;
    }

    @Column(order = 173, length = 11)
    @MultiByte
    private String iwsNkuktseiymdwareki;

    public String getIwsNkuktseiymdwareki() {
        return iwsNkuktseiymdwareki;
    }

    public void setIwsNkuktseiymdwareki(String pIwsNkuktseiymdwareki) {
        iwsNkuktseiymdwareki = pIwsNkuktseiymdwareki;
    }

    @Column(order = 174, length = 2)
    @MultiByte
    private String iwsKojinhjnkbn2;

    public String getIwsKojinhjnkbn2() {
        return iwsKojinhjnkbn2;
    }

    public void setIwsKojinhjnkbn2(String pIwsKojinhjnkbn2) {
        iwsKojinhjnkbn2 = pIwsKojinhjnkbn2;
    }

    @Column(order = 175, length = 15)
    private String iwsTsintelno15ketax2;

    public String getIwsTsintelno15ketax2() {
        return iwsTsintelno15ketax2;
    }

    public void setIwsTsintelno15ketax2(String pIwsTsintelno15ketax2) {
        iwsTsintelno15ketax2 = pIwsTsintelno15ketax2;
    }

    @Column(order = 176, length = 8)
    @MultiByte
    private String iwsTsinynozenkakux2;

    public String getIwsTsinynozenkakux2() {
        return iwsTsinynozenkakux2;
    }

    public void setIwsTsinynozenkakux2(String pIwsTsinynozenkakux2) {
        iwsTsinynozenkakux2 = pIwsTsinynozenkakux2;
    }

    @Column(order = 177, length = 80)
    private String iwsTsinadrknx2;

    public String getIwsTsinadrknx2() {
        return iwsTsinadrknx2;
    }

    public void setIwsTsinadrknx2(String pIwsTsinadrknx2) {
        iwsTsinadrknx2 = pIwsTsinadrknx2;
    }

    @Column(order = 178, length = 62)
    @MultiByte
    private String iwsTsinadrx2;

    public String getIwsTsinadrx2() {
        return iwsTsinadrx2;
    }

    public void setIwsTsinadrx2(String pIwsTsinadrx2) {
        iwsTsinadrx2 = pIwsTsinadrx2;
    }

    @Column(order = 179, length = 18)
    private String iwsHhknsyanmkn18keta;

    public String getIwsHhknsyanmkn18keta() {
        return iwsHhknsyanmkn18keta;
    }

    public void setIwsHhknsyanmkn18keta(String pIwsHhknsyanmkn18keta) {
        iwsHhknsyanmkn18keta = pIwsHhknsyanmkn18keta;
    }

    @Column(order = 180, length = 17)
    @MultiByte
    private String iwsHhknnmkj17keta;

    public String getIwsHhknnmkj17keta() {
        return iwsHhknnmkj17keta;
    }

    public void setIwsHhknnmkj17keta(String pIwsHhknnmkj17keta) {
        iwsHhknnmkj17keta = pIwsHhknnmkj17keta;
    }

    @Column(order = 181, length = 2)
    @MultiByte
    private String iwsHhknseikj2;

    public String getIwsHhknseikj2() {
        return iwsHhknseikj2;
    }

    public void setIwsHhknseikj2(String pIwsHhknseikj2) {
        iwsHhknseikj2 = pIwsHhknseikj2;
    }

    @Column(order = 182, length = 11)
    @MultiByte
    private String iwsHhknseiymdwareki2;

    public String getIwsHhknseiymdwareki2() {
        return iwsHhknseiymdwareki2;
    }

    public void setIwsHhknseiymdwareki2(String pIwsHhknseiymdwareki2) {
        iwsHhknseiymdwareki2 = pIwsHhknseiymdwareki2;
    }

    @Column(order = 183, length = 64)
    @MultiByte
    private String iwsNksyouhnnm;

    public String getIwsNksyouhnnm() {
        return iwsNksyouhnnm;
    }

    public void setIwsNksyouhnnm(String pIwsNksyouhnnm) {
        iwsNksyouhnnm = pIwsNksyouhnnm;
    }

    @Column(order = 184, length = 11)
    private String iwsNksysyno;

    public String getIwsNksysyno() {
        return iwsNksysyno;
    }

    public void setIwsNksysyno(String pIwsNksysyno) {
        iwsNksysyno = pIwsNksysyno;
    }

    @Column(order = 185, length = 11)
    @MultiByte
    private String iwsSyokainkshrymd;

    public String getIwsSyokainkshrymd() {
        return iwsSyokainkshrymd;
    }

    public void setIwsSyokainkshrymd(String pIwsSyokainkshrymd) {
        iwsSyokainkshrymd = pIwsSyokainkshrymd;
    }

    @Column(order = 186, length = 3)
    @MultiByte
    private String iwsSyokainkshrjk;

    public String getIwsSyokainkshrjk() {
        return iwsSyokainkshrjk;
    }

    public void setIwsSyokainkshrjk(String pIwsSyokainkshrjk) {
        iwsSyokainkshrjk = pIwsSyokainkshrjk;
    }

    @Column(order = 187, length = 11)
    @MultiByte
    private String iwsNextnkshrymd;

    public String getIwsNextnkshrymd() {
        return iwsNextnkshrymd;
    }

    public void setIwsNextnkshrymd(String pIwsNextnkshrymd) {
        iwsNextnkshrymd = pIwsNextnkshrymd;
    }

    @Column(order = 188, length = 11)
    @MultiByte
    private String iwsLastnkshrymd;

    public String getIwsLastnkshrymd() {
        return iwsLastnkshrymd;
    }

    public void setIwsLastnkshrymd(String pIwsLastnkshrymd) {
        iwsLastnkshrymd = pIwsLastnkshrymd;
    }

    @Column(order = 189, length = 14)
    private String iwsKhnnkgk;

    public String getIwsKhnnkgk() {
        return iwsKhnnkgk;
    }

    public void setIwsKhnnkgk(String pIwsKhnnkgk) {
        iwsKhnnkgk = pIwsKhnnkgk;
    }

    @Column(order = 190, length = 1)
    private String iwsKhnnkgktuukasyu;

    public String getIwsKhnnkgktuukasyu() {
        return iwsKhnnkgktuukasyu;
    }

    public void setIwsKhnnkgktuukasyu(String pIwsKhnnkgktuukasyu) {
        iwsKhnnkgktuukasyu = pIwsKhnnkgktuukasyu;
    }

    @Column(order = 191, length = 4)
    @MultiByte
    private String iwsBnkaisuu;

    public String getIwsBnkaisuu() {
        return iwsBnkaisuu;
    }

    public void setIwsBnkaisuu(String pIwsBnkaisuu) {
        iwsBnkaisuu = pIwsBnkaisuu;
    }

    @Column(order = 192, length = 15)
    @MultiByte
    private String iwsNenkinsyu;

    public String getIwsNenkinsyu() {
        return iwsNenkinsyu;
    }

    public void setIwsNenkinsyu(String pIwsNenkinsyu) {
        iwsNenkinsyu = pIwsNenkinsyu;
    }

    @Column(order = 193, length = 3)
    @MultiByte
    private String iwsNenkinsiharaikikan;

    public String getIwsNenkinsiharaikikan() {
        return iwsNenkinsiharaikikan;
    }

    public void setIwsNenkinsiharaikikan(String pIwsNenkinsiharaikikan) {
        iwsNenkinsiharaikikan = pIwsNenkinsiharaikikan;
    }

    @Column(order = 194, length = 3)
    @MultiByte
    private String iwsNenkinhosyoukikan;

    public String getIwsNenkinhosyoukikan() {
        return iwsNenkinhosyoukikan;
    }

    public void setIwsNenkinhosyoukikan(String pIwsNenkinhosyoukikan) {
        iwsNenkinhosyoukikan = pIwsNenkinhosyoukikan;
    }

    @Column(order = 195, length = 10)
    @MultiByte
    private String iwsHaitoukinuketorihou;

    public String getIwsHaitoukinuketorihou() {
        return iwsHaitoukinuketorihou;
    }

    public void setIwsHaitoukinuketorihou(String pIwsHaitoukinuketorihou) {
        iwsHaitoukinuketorihou = pIwsHaitoukinuketorihou;
    }

    @Column(order = 196, length = 2)
    private String iwsHenkoukeiilinecnt2;

    public String getIwsHenkoukeiilinecnt2() {
        return iwsHenkoukeiilinecnt2;
    }

    public void setIwsHenkoukeiilinecnt2(String pIwsHenkoukeiilinecnt2) {
        iwsHenkoukeiilinecnt2 = pIwsHenkoukeiilinecnt2;
    }

    @Column(order = 197, length = 22)
    @MultiByte
    private String iwsHenkoukeii1x2;

    public String getIwsHenkoukeii1x2() {
        return iwsHenkoukeii1x2;
    }

    public void setIwsHenkoukeii1x2(String pIwsHenkoukeii1x2) {
        iwsHenkoukeii1x2 = pIwsHenkoukeii1x2;
    }

    @Column(order = 198, length = 22)
    @MultiByte
    private String iwsHenkoukeii2x2;

    public String getIwsHenkoukeii2x2() {
        return iwsHenkoukeii2x2;
    }

    public void setIwsHenkoukeii2x2(String pIwsHenkoukeii2x2) {
        iwsHenkoukeii2x2 = pIwsHenkoukeii2x2;
    }

    @Column(order = 199, length = 22)
    @MultiByte
    private String iwsHenkoukeii3x2;

    public String getIwsHenkoukeii3x2() {
        return iwsHenkoukeii3x2;
    }

    public void setIwsHenkoukeii3x2(String pIwsHenkoukeii3x2) {
        iwsHenkoukeii3x2 = pIwsHenkoukeii3x2;
    }

    @Column(order = 200, length = 22)
    @MultiByte
    private String iwsHenkoukeii4x2;

    public String getIwsHenkoukeii4x2() {
        return iwsHenkoukeii4x2;
    }

    public void setIwsHenkoukeii4x2(String pIwsHenkoukeii4x2) {
        iwsHenkoukeii4x2 = pIwsHenkoukeii4x2;
    }

    @Column(order = 201, length = 22)
    @MultiByte
    private String iwsHenkoukeii5x2;

    public String getIwsHenkoukeii5x2() {
        return iwsHenkoukeii5x2;
    }

    public void setIwsHenkoukeii5x2(String pIwsHenkoukeii5x2) {
        iwsHenkoukeii5x2 = pIwsHenkoukeii5x2;
    }

    @Column(order = 202, length = 11)
    @MultiByte
    private String iwsKeiyakuymd;

    public String getIwsKeiyakuymd() {
        return iwsKeiyakuymd;
    }

    public void setIwsKeiyakuymd(String pIwsKeiyakuymd) {
        iwsKeiyakuymd = pIwsKeiyakuymd;
    }

    @Column(order = 203, length = 2)
    private String iwsBsydairitenlinecnt2;

    public String getIwsBsydairitenlinecnt2() {
        return iwsBsydairitenlinecnt2;
    }

    public void setIwsBsydairitenlinecnt2(String pIwsBsydairitenlinecnt2) {
        iwsBsydairitenlinecnt2 = pIwsBsydairitenlinecnt2;
    }

    @Column(order = 204, length = 20)
    @MultiByte
    private String iwsBosyuudairitennm1x2;

    public String getIwsBosyuudairitennm1x2() {
        return iwsBosyuudairitennm1x2;
    }

    public void setIwsBosyuudairitennm1x2(String pIwsBosyuudairitennm1x2) {
        iwsBosyuudairitennm1x2 = pIwsBosyuudairitennm1x2;
    }

    @Column(order = 205, length = 20)
    @MultiByte
    private String iwsBosyuudairitennm2x2;

    public String getIwsBosyuudairitennm2x2() {
        return iwsBosyuudairitennm2x2;
    }

    public void setIwsBosyuudairitennm2x2(String pIwsBosyuudairitennm2x2) {
        iwsBosyuudairitennm2x2 = pIwsBosyuudairitennm2x2;
    }

    @Column(order = 206, length = 15)
    private String iwsCifcd2;

    public String getIwsCifcd2() {
        return iwsCifcd2;
    }

    public void setIwsCifcd2(String pIwsCifcd2) {
        iwsCifcd2 = pIwsCifcd2;
    }

    @Column(order = 207, length = 2)
    private String iwsBikoulinecnt;

    public String getIwsBikoulinecnt() {
        return iwsBikoulinecnt;
    }

    public void setIwsBikoulinecnt(String pIwsBikoulinecnt) {
        iwsBikoulinecnt = pIwsBikoulinecnt;
    }

    @Column(order = 208, length = 40)
    @MultiByte
    private String iwsBikou1;

    public String getIwsBikou1() {
        return iwsBikou1;
    }

    public void setIwsBikou1(String pIwsBikou1) {
        iwsBikou1 = pIwsBikou1;
    }

    @Column(order = 209, length = 40)
    @MultiByte
    private String iwsBikou2;

    public String getIwsBikou2() {
        return iwsBikou2;
    }

    public void setIwsBikou2(String pIwsBikou2) {
        iwsBikou2 = pIwsBikou2;
    }

    @Column(order = 210, length = 40)
    @MultiByte
    private String iwsBikou3;

    public String getIwsBikou3() {
        return iwsBikou3;
    }

    public void setIwsBikou3(String pIwsBikou3) {
        iwsBikou3 = pIwsBikou3;
    }

    @Column(order = 211, length = 40)
    @MultiByte
    private String iwsBikou4;

    public String getIwsBikou4() {
        return iwsBikou4;
    }

    public void setIwsBikou4(String pIwsBikou4) {
        iwsBikou4 = pIwsBikou4;
    }

    @Column(order = 212, length = 40)
    @MultiByte
    private String iwsBikou5;

    public String getIwsBikou5() {
        return iwsBikou5;
    }

    public void setIwsBikou5(String pIwsBikou5) {
        iwsBikou5 = pIwsBikou5;
    }

    @Column(order = 213, length = 1)
    private String iwsNknaiyousyoukaihyj;

    public String getIwsNknaiyousyoukaihyj() {
        return iwsNknaiyousyoukaihyj;
    }

    public void setIwsNknaiyousyoukaihyj(String pIwsNknaiyousyoukaihyj) {
        iwsNknaiyousyoukaihyj = pIwsNknaiyousyoukaihyj;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
