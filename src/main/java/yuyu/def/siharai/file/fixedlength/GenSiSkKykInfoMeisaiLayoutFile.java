package yuyu.def.siharai.file.fixedlength;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import jp.co.slcs.swak.file.description.annotations.MultiByte;
import jp.co.slcs.swak.file.description.text.fixedlength.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * （支払）請求契約情報ファイル（明細レコード）レイアウトファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenSiSkKykInfoMeisaiLayoutFile implements Serializable {


    private static final long serialVersionUID = 1L;


    public GenSiSkKykInfoMeisaiLayoutFile() {
    }


    @Column(order = 1, length = 11)
    @NotNull
    private String iffSyono;


    public String getIffSyono() {
        return iffSyono;
    }


    public void setIffSyono(String pIffSyono) {
        iffSyono = pIffSyono;
    }


    @Column(order = 2, length = 18)
    @NotNull
    private String iffYuyuskankensikibetuno;


    public String getIffYuyuskankensikibetuno() {
        return iffYuyuskankensikibetuno;
    }


    public void setIffYuyuskankensikibetuno(String pIffYuyuskankensikibetuno) {
        iffYuyuskankensikibetuno = pIffYuyuskankensikibetuno;
    }


    @Column(order = 3, length = 2)
    @NotNull
    private String iffHokenkinsyuruikbn;


    public String getIffHokenkinsyuruikbn() {
        return iffHokenkinsyuruikbn;
    }


    public void setIffHokenkinsyuruikbn(String pIffHokenkinsyuruikbn) {
        iffHokenkinsyuruikbn = pIffHokenkinsyuruikbn;
    }


    @Column(order = 4, length = 69)
    private String iffYobiskkykinfomeisai01;


    public String getIffYobiskkykinfomeisai01() {
        return iffYobiskkykinfomeisai01;
    }


    public void setIffYobiskkykinfomeisai01(String pIffYobiskkykinfomeisai01) {
        iffYobiskkykinfomeisai01 = pIffYobiskkykinfomeisai01;
    }


    @Column(order = 5, length = 1)
    private String iffHhknhonninsaisikbn;


    public String getIffHhknhonninsaisikbn() {
        return iffHhknhonninsaisikbn;
    }


    public void setIffHhknhonninsaisikbn(String pIffHhknhonninsaisikbn) {
        iffHhknhonninsaisikbn = pIffHhknhonninsaisikbn;
    }


    @Column(order = 6, length = 18)
    private String iffHhknnmkn;


    public String getIffHhknnmkn() {
        return iffHhknnmkn;
    }


    public void setIffHhknnmkn(String pIffHhknnmkn) {
        iffHhknnmkn = pIffHhknnmkn;
    }


    @Column(order = 7, length = 17)
    @MultiByte
    private String iffHhknnmkj;


    public String getIffHhknnmkj() {
        return iffHhknnmkj;
    }


    public void setIffHhknnmkj(String pIffHhknnmkj) {
        iffHhknnmkj = pIffHhknnmkj;
    }


    @Column(order = 8, length = 8)
    private String iffHhknseiymd;


    public String getIffHhknseiymd() {
        return iffHhknseiymd;
    }


    public void setIffHhknseiymd(String pIffHhknseiymd) {
        iffHhknseiymd = pIffHhknseiymd;
    }


    @Column(order = 9, length = 2)
    private String iffHhknnen;


    public String getIffHhknnen() {
        return iffHhknnen;
    }


    public void setIffHhknnen(String pIffHhknnen) {
        iffHhknnen = pIffHhknnen;
    }


    @Column(order = 10, length = 1)
    private String iffShrhushrkbn;


    public String getIffShrhushrkbn() {
        return iffShrhushrkbn;
    }


    public void setIffShrhushrkbn(String pIffShrhushrkbn) {
        iffShrhushrkbn = pIffShrhushrkbn;
    }


    @Column(order = 11, length = 1)
    private String iffSaisateikbn;


    public String getIffSaisateikbn() {
        return iffSaisateikbn;
    }


    public void setIffSaisateikbn(String pIffSaisateikbn) {
        iffSaisateikbn = pIffSaisateikbn;
    }


    @Column(order = 12, length = 1)
    private String iffShrkekkakbn;


    public String getIffShrkekkakbn() {
        return iffShrkekkakbn;
    }


    public void setIffShrkekkakbn(String pIffShrkekkakbn) {
        iffShrkekkakbn = pIffShrkekkakbn;
    }


    @Column(order = 13, length = 8)
    private String iffShrhushrsyoriymd;


    public String getIffShrhushrsyoriymd() {
        return iffShrhushrsyoriymd;
    }


    public void setIffShrhushrsyoriymd(String pIffShrhushrsyoriymd) {
        iffShrhushrsyoriymd = pIffShrhushrsyoriymd;
    }


    @Column(order = 14, length = 8)
    private String iffSbymd;


    public String getIffSbymd() {
        return iffSbymd;
    }


    public void setIffSbymd(String pIffSbymd) {
        iffSbymd = pIffSbymd;
    }


    @Column(order = 15, length = 2)
    private String iffSiinsyuruikbn;


    public String getIffSiinsyuruikbn() {
        return iffSiinsyuruikbn;
    }


    public void setIffSiinsyuruikbn(String pIffSiinsyuruikbn) {
        iffSiinsyuruikbn = pIffSiinsyuruikbn;
    }


    @Column(order = 16, length = 4)
    private String iffByoumeicd1;


    public String getIffByoumeicd1() {
        return iffByoumeicd1;
    }


    public void setIffByoumeicd1(String pIffByoumeicd1) {
        iffByoumeicd1 = pIffByoumeicd1;
    }


    @Column(order = 17, length = 4)
    private String iffByoumeicd2;


    public String getIffByoumeicd2() {
        return iffByoumeicd2;
    }


    public void setIffByoumeicd2(String pIffByoumeicd2) {
        iffByoumeicd2 = pIffByoumeicd2;
    }


    @Column(order = 18, length = 4)
    private String iffByoumeicd3;


    public String getIffByoumeicd3() {
        return iffByoumeicd3;
    }


    public void setIffByoumeicd3(String pIffByoumeicd3) {
        iffByoumeicd3 = pIffByoumeicd3;
    }


    @Column(order = 19, length = 4)
    private String iffByoumeicd4;


    public String getIffByoumeicd4() {
        return iffByoumeicd4;
    }


    public void setIffByoumeicd4(String pIffByoumeicd4) {
        iffByoumeicd4 = pIffByoumeicd4;
    }


    @Column(order = 20, length = 4)
    private String iffByoumeicd5;


    public String getIffByoumeicd5() {
        return iffByoumeicd5;
    }


    public void setIffByoumeicd5(String pIffByoumeicd5) {
        iffByoumeicd5 = pIffByoumeicd5;
    }


    @Column(order = 21, length = 4)
    private String iffByoumeicd6;


    public String getIffByoumeicd6() {
        return iffByoumeicd6;
    }


    public void setIffByoumeicd6(String pIffByoumeicd6) {
        iffByoumeicd6 = pIffByoumeicd6;
    }


    @Column(order = 22, length = 4)
    private String iffByoumeicd7;


    public String getIffByoumeicd7() {
        return iffByoumeicd7;
    }


    public void setIffByoumeicd7(String pIffByoumeicd7) {
        iffByoumeicd7 = pIffByoumeicd7;
    }


    @Column(order = 23, length = 4)
    private String iffByoumeicd8;


    public String getIffByoumeicd8() {
        return iffByoumeicd8;
    }


    public void setIffByoumeicd8(String pIffByoumeicd8) {
        iffByoumeicd8 = pIffByoumeicd8;
    }


    @Column(order = 24, length = 4)
    private String iffByoumeicd9;


    public String getIffByoumeicd9() {
        return iffByoumeicd9;
    }


    public void setIffByoumeicd9(String pIffByoumeicd9) {
        iffByoumeicd9 = pIffByoumeicd9;
    }


    @Column(order = 25, length = 4)
    private String iffByoumeicd10;


    public String getIffByoumeicd10() {
        return iffByoumeicd10;
    }


    public void setIffByoumeicd10(String pIffByoumeicd10) {
        iffByoumeicd10 = pIffByoumeicd10;
    }


    @Column(order = 26, length = 276)
    private String iffYobiskkykinfomeisai02;


    public String getIffYobiskkykinfomeisai02() {
        return iffYobiskkykinfomeisai02;
    }


    public void setIffYobiskkykinfomeisai02(String pIffYobiskkykinfomeisai02) {
        iffYobiskkykinfomeisai02 = pIffYobiskkykinfomeisai02;
    }


    @Column(order = 27, length = 4)
    private String iffSyoruiimagerendousuu;


    public String getIffSyoruiimagerendousuu() {
        return iffSyoruiimagerendousuu;
    }


    public void setIffSyoruiimagerendousuu(String pIffSyoruiimagerendousuu) {
        iffSyoruiimagerendousuu = pIffSyoruiimagerendousuu;
    }


    @Column(order = 28, length = 1)
    private String iffAnkenimgjygntyoukahyj;


    public String getIffAnkenimgjygntyoukahyj() {
        return iffAnkenimgjygntyoukahyj;
    }


    public void setIffAnkenimgjygntyoukahyj(String pIffAnkenimgjygntyoukahyj) {
        iffAnkenimgjygntyoukahyj = pIffAnkenimgjygntyoukahyj;
    }


    @Column(order = 29, length = 1)
    private String iffTiffhenkankekkakbn;


    public String getIffTiffhenkankekkakbn() {
        return iffTiffhenkankekkakbn;
    }


    public void setIffTiffhenkankekkakbn(String pIffTiffhenkankekkakbn) {
        iffTiffhenkankekkakbn = pIffTiffhenkankekkakbn;
    }


    @Column(order = 30, length = 94)
    private String iffYobiskkykinfomeisai03;


    public String getIffYobiskkykinfomeisai03() {
        return iffYobiskkykinfomeisai03;
    }


    public void setIffYobiskkykinfomeisai03(String pIffYobiskkykinfomeisai03) {
        iffYobiskkykinfomeisai03 = pIffYobiskkykinfomeisai03;
    }


    @Column(order = 31, length = 50)
    @MultiByte
    private String iffHknsyuruinm;


    public String getIffHknsyuruinm() {
        return iffHknsyuruinm;
    }


    public void setIffHknsyuruinm(String pIffHknsyuruinm) {
        iffHknsyuruinm = pIffHknsyuruinm;
    }


    @Column(order = 32, length = 2)
    private String iffHknsyuruikigou;


    public String getIffHknsyuruikigou() {
        return iffHknsyuruikigou;
    }


    public void setIffHknsyuruikigou(String pIffHknsyuruikigou) {
        iffHknsyuruikigou = pIffHknsyuruikigou;
    }


    @Column(order = 33, length = 41)
    private String iffKyknmkn;


    public String getIffKyknmkn() {
        return iffKyknmkn;
    }


    public void setIffKyknmkn(String pIffKyknmkn) {
        iffKyknmkn = pIffKyknmkn;
    }


    @Column(order = 34, length = 37)
    @MultiByte
    private String iffKyknmkj;


    public String getIffKyknmkj() {
        return iffKyknmkj;
    }


    public void setIffKyknmkj(String pIffKyknmkj) {
        iffKyknmkj = pIffKyknmkj;
    }


    @Column(order = 35, length = 8)
    private String iffKykseiymd;


    public String getIffKykseiymd() {
        return iffKykseiymd;
    }


    public void setIffKykseiymd(String pIffKykseiymd) {
        iffKykseiymd = pIffKykseiymd;
    }


    @Column(order = 36, length = 2)
    private String iffKyknen;


    public String getIffKyknen() {
        return iffKyknen;
    }


    public void setIffKyknen(String pIffKyknen) {
        iffKyknen = pIffKyknen;
    }


    @Column(order = 37, length = 62)
    @MultiByte
    private String iffKykadr;


    public String getIffKykadr() {
        return iffKykadr;
    }


    public void setIffKykadr(String pIffKykadr) {
        iffKykadr = pIffKykadr;
    }


    @Column(order = 38, length = 15)
    private String iffKyktelno;


    public String getIffKyktelno() {
        return iffKyktelno;
    }


    public void setIffKyktelno(String pIffKyktelno) {
        iffKyktelno = pIffKyktelno;
    }


    @Column(order = 39, length = 8)
    private String iffSknnkaisiymd;


    public String getIffSknnkaisiymd() {
        return iffSknnkaisiymd;
    }


    public void setIffSknnkaisiymd(String pIffSknnkaisiymd) {
        iffSknnkaisiymd = pIffSknnkaisiymd;
    }


    @Column(order = 40, length = 1)
    private String iffSaigaihosyouarihyj;


    public String getIffSaigaihosyouarihyj() {
        return iffSaigaihosyouarihyj;
    }


    public void setIffSaigaihosyouarihyj(String pIffSaigaihosyouarihyj) {
        iffSaigaihosyouarihyj = pIffSaigaihosyouarihyj;
    }


    @Column(order = 41, length = 325)
    private String iffYobiskkykinfomeisai04;


    public String getIffYobiskkykinfomeisai04() {
        return iffYobiskkykinfomeisai04;
    }


    public void setIffYobiskkykinfomeisai04(String pIffYobiskkykinfomeisai04) {
        iffYobiskkykinfomeisai04 = pIffYobiskkykinfomeisai04;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
