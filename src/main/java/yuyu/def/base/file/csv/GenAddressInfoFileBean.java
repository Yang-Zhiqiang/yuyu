package yuyu.def.base.file.csv;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.file.description.text.csv.annotations.Column;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import yuyu.def.classification.C_UmuKbn;

/**
 * 住所情報ファイル データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenAddressInfoFileBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenAddressInfoFileBean() {
    }

    @Column(order = 1, label = "全国地方公共団体コード")
    private String zenkokuChihouKoukyouDantaiCd;

    public String getZenkokuChihouKoukyouDantaiCd() {
        return zenkokuChihouKoukyouDantaiCd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setZenkokuChihouKoukyouDantaiCd(String pZenkokuChihouKoukyouDantaiCd) {
        zenkokuChihouKoukyouDantaiCd = pZenkokuChihouKoukyouDantaiCd;
    }

    @Column(order = 2, label = "（旧）郵便番号（５桁）")
    private String kyuuPostalCd;

    public String getKyuuPostalCd() {
        return kyuuPostalCd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKyuuPostalCd(String pKyuuPostalCd) {
        kyuuPostalCd = pKyuuPostalCd;
    }

    @Column(order = 3, label = "郵便番号")
    @Length(length=7)
    @Digit
    private String postalCd;

    public String getPostalCd() {
        return postalCd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setPostalCd(String pPostalCd) {
        postalCd = pPostalCd;
    }

    @Column(order = 4, label = "都道府県名（カナ）")
    @MaxLength(max=14)
    @MultiByteStrings
    private String todoufukenNmKana;

    public String getTodoufukenNmKana() {
        return todoufukenNmKana;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setTodoufukenNmKana(String pTodoufukenNmKana) {
        todoufukenNmKana = pTodoufukenNmKana;
    }

    @Column(order = 5, label = "市区町村名（カナ）")
    @MaxLength(max=60)
    @MultiByteStrings
    private String sikutyousonNmKana;

    public String getSikutyousonNmKana() {
        return sikutyousonNmKana;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setSikutyousonNmKana(String pSikutyousonNmKana) {
        sikutyousonNmKana = pSikutyousonNmKana;
    }

    @Column(order = 6, label = "町域名（カナ）")
    @MaxLength(max=160)
    @MultiByteStrings
    private String tyouikiNmKana;

    public String getTyouikiNmKana() {
        return tyouikiNmKana;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setTyouikiNmKana(String pTyouikiNmKana) {
        tyouikiNmKana = pTyouikiNmKana;
    }

    @Column(order = 7, label = "都道府県名（漢字）")
    @MaxLength(max=8)
    @MultiByteStrings
    private String todoufukenNm;

    public String getTodoufukenNm() {
        return todoufukenNm;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setTodoufukenNm(String pTodoufukenNm) {
        todoufukenNm = pTodoufukenNm;
    }

    @Column(order = 8, label = "市区町村名（漢字）")
    @MaxLength(max=24)
    @MultiByteStrings
    private String sikutyousonNm;

    public String getSikutyousonNm() {
        return sikutyousonNm;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setSikutyousonNm(String pSikutyousonNm) {
        sikutyousonNm = pSikutyousonNm;
    }

    @Column(order = 9, label = "町域名（漢字）")
    @MaxLength(max=80)
    @MultiByteStrings
    private String tyouikiNm;

    public String getTyouikiNm() {
        return tyouikiNm;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setTyouikiNm(String pTyouikiNm) {
        tyouikiNm = pTyouikiNm;
    }

    @Column(order = 10, label = "町域郵便番号分割区分")
    private String tyouikiPostalCdBunkatuKbn;

    public String getTyouikiPostalCdBunkatuKbn() {
        return tyouikiPostalCdBunkatuKbn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTyouikiPostalCdBunkatuKbn(String pTyouikiPostalCdBunkatuKbn) {
        tyouikiPostalCdBunkatuKbn = pTyouikiPostalCdBunkatuKbn;
    }

    @Column(order = 11, label = "町域小字毎番地区分")
    private String tyouikiKoazaMaibanchiKbn;

    public String getTyouikiKoazaMaibanchiKbn() {
        return tyouikiKoazaMaibanchiKbn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTyouikiKoazaMaibanchiKbn(String pTyouikiKoazaMaibanchiKbn) {
        tyouikiKoazaMaibanchiKbn = pTyouikiKoazaMaibanchiKbn;
    }

    @Column(order = 12, label = "町域丁目保有区分")
    private String tyoukiTyoumeHoyuuKbn;

    public String getTyoukiTyoumeHoyuuKbn() {
        return tyoukiTyoumeHoyuuKbn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTyoukiTyoumeHoyuuKbn(String pTyoukiTyoumeHoyuuKbn) {
        tyoukiTyoumeHoyuuKbn = pTyoukiTyoumeHoyuuKbn;
    }

    @Column(order = 13, label = "郵便番号町域複数区分")
    private C_UmuKbn postalCdTyoukiHukusuuKbn;

    public C_UmuKbn getPostalCdTyoukiHukusuuKbn() {
        return postalCdTyoukiHukusuuKbn;
    }

    public void setPostalCdTyoukiHukusuuKbn(C_UmuKbn pPostalCdTyoukiHukusuuKbn) {
        postalCdTyoukiHukusuuKbn = pPostalCdTyoukiHukusuuKbn;
    }

    @Column(order = 14, label = "郵便番号更新区分")
    private String postalCdKousinKbn;

    public String getPostalCdKousinKbn() {
        return postalCdKousinKbn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setPostalCdKousinKbn(String pPostalCdKousinKbn) {
        postalCdKousinKbn = pPostalCdKousinKbn;
    }

    @Column(order = 15, label = "郵便番号変更理由区分")
    private String postalCdKousinRiyuuKbn;

    public String getPostalCdKousinRiyuuKbn() {
        return postalCdKousinRiyuuKbn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setPostalCdKousinRiyuuKbn(String pPostalCdKousinRiyuuKbn) {
        postalCdKousinRiyuuKbn = pPostalCdKousinRiyuuKbn;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
