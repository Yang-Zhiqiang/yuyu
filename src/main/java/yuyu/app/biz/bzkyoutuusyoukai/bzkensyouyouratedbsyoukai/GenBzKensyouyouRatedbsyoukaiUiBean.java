package yuyu.app.biz.bzkyoutuusyoukai.bzkensyouyouratedbsyoukai;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.NaturalNumber;
import jp.co.slcs.swak.validation.constraints.Range;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import yuyu.def.classification.C_HokenSyuruiKigouSedaiKbn;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_PalAnnaiFuyouRiyuuKbn;
import yuyu.def.classification.C_PalHhknsei;
import yuyu.def.classification.C_PalHrkkaisuuKbn;
import yuyu.def.classification.C_PalPmenKbn;
import yuyu.def.classification.C_PalRyourituKbn;
import yuyu.def.classification.C_PalSaimankikykhyoujiKbn;
import yuyu.def.classification.C_RateSyoukaiKbn;
import yuyu.def.classification.C_RateTuukasyuKbn;

/**
 * 検証用レートＤＢ照会 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenBzKensyouyouRatedbsyoukaiUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private C_RateSyoukaiKbn ratesyoukaikbn;

    public C_RateSyoukaiKbn getRatesyoukaikbn() {
        return ratesyoukaikbn;
    }

    public void setRatesyoukaikbn(C_RateSyoukaiKbn pRatesyoukaikbn) {
        ratesyoukaikbn = pRatesyoukaikbn;
    }

    @Length(length=2)
    @SingleByteStrings
    private String disppalhokensyuruikigou;

    public String getDisppalhokensyuruikigou() {
        return disppalhokensyuruikigou;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDisppalhokensyuruikigou(String pDisppalhokensyuruikigou) {
        disppalhokensyuruikigou = pDisppalhokensyuruikigou;
    }

    @ValidDate
    private BizDate suurikykymd;

    public BizDate getSuurikykymd() {
        return suurikykymd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSuurikykymd(BizDate pSuurikykymd) {
        suurikykymd = pSuurikykymd;
    }

    private C_HokenSyuruiKigouSedaiKbn disphksyuruikigousedaikbn;

    public C_HokenSyuruiKigouSedaiKbn getDisphksyuruikigousedaikbn() {
        return disphksyuruikigousedaikbn;
    }

    public void setDisphksyuruikigousedaikbn(C_HokenSyuruiKigouSedaiKbn pDisphksyuruikigousedaikbn) {
        disphksyuruikigousedaikbn = pDisphksyuruikigousedaikbn;
    }

    @Range(min="0", max="999")
    private Integer dispyoteiriritu;

    public Integer getDispyoteiriritu() {
        return dispyoteiriritu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispyoteiriritu(Integer pDispyoteiriritu) {
        dispyoteiriritu = pDispyoteiriritu;
    }

    @NaturalNumber
    private Integer hhknnen;

    public Integer getHhknnen() {
        return hhknnen;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHhknnen(Integer pHhknnen) {
        hhknnen = pHhknnen;
    }

    private C_PalHhknsei suurihhknsei;

    public C_PalHhknsei getSuurihhknsei() {
        return suurihhknsei;
    }

    public void setSuurihhknsei(C_PalHhknsei pSuurihhknsei) {
        suurihhknsei = pSuurihhknsei;
    }

    private C_PalSaimankikykhyoujiKbn palsaimankikykhyoujikbn;

    public C_PalSaimankikykhyoujiKbn getPalsaimankikykhyoujikbn() {
        return palsaimankikykhyoujikbn;
    }

    public void setPalsaimankikykhyoujikbn(C_PalSaimankikykhyoujiKbn pPalsaimankikykhyoujikbn) {
        palsaimankikykhyoujikbn = pPalsaimankikykhyoujikbn;
    }

    @Range(min="0", max="99")
    private Integer hknkkn;

    public Integer getHknkkn() {
        return hknkkn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHknkkn(Integer pHknkkn) {
        hknkkn = pHknkkn;
    }

    @Range(min="0", max="99")
    private Integer hrkkkn;

    public Integer getHrkkkn() {
        return hrkkkn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHrkkkn(Integer pHrkkkn) {
        hrkkkn = pHrkkkn;
    }

    private C_PalHrkkaisuuKbn dispharaikomikaisuukbn;

    public C_PalHrkkaisuuKbn getDispharaikomikaisuukbn() {
        return dispharaikomikaisuukbn;
    }

    public void setDispharaikomikaisuukbn(C_PalHrkkaisuuKbn pDispharaikomikaisuukbn) {
        dispharaikomikaisuukbn = pDispharaikomikaisuukbn;
    }

    private C_PalPmenKbn disppalpmenkbn;

    public C_PalPmenKbn getDisppalpmenkbn() {
        return disppalpmenkbn;
    }

    public void setDisppalpmenkbn(C_PalPmenKbn pDisppalpmenkbn) {
        disppalpmenkbn = pDisppalpmenkbn;
    }

    private C_PalAnnaiFuyouRiyuuKbn disppalannaihuyouriyuukbn;

    public C_PalAnnaiFuyouRiyuuKbn getDisppalannaihuyouriyuukbn() {
        return disppalannaihuyouriyuukbn;
    }

    public void setDisppalannaihuyouriyuukbn(C_PalAnnaiFuyouRiyuuKbn pDisppalannaihuyouriyuukbn) {
        disppalannaihuyouriyuukbn = pDisppalannaihuyouriyuukbn;
    }

    private C_RateTuukasyuKbn dispratetuukasyukbn;

    public C_RateTuukasyuKbn getDispratetuukasyukbn() {
        return dispratetuukasyukbn;
    }

    public void setDispratetuukasyukbn(C_RateTuukasyuKbn pDispratetuukasyukbn) {
        dispratetuukasyukbn = pDispratetuukasyukbn;
    }

    @Range(min="0", max="99")
    private Integer dai1hknkkn;

    public Integer getDai1hknkkn() {
        return dai1hknkkn;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDai1hknkkn(Integer pDai1hknkkn) {
        dai1hknkkn = pDai1hknkkn;
    }

    private C_PalRyourituKbn disppalryouritukbn;

    public C_PalRyourituKbn getDisppalryouritukbn() {
        return disppalryouritukbn;
    }

    public void setDisppalryouritukbn(C_PalRyourituKbn pDisppalryouritukbn) {
        disppalryouritukbn = pDisppalryouritukbn;
    }

    @Range(min="0", max="9999")
    private Integer dispdnendo;

    public Integer getDispdnendo() {
        return dispdnendo;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDispdnendo(Integer pDispdnendo) {
        dispdnendo = pDispdnendo;
    }

    private C_NaiteiKakuteiKbn dispdratenaiteikakuteikbn;

    public C_NaiteiKakuteiKbn getDispdratenaiteikakuteikbn() {
        return dispdratenaiteikakuteikbn;
    }

    public void setDispdratenaiteikakuteikbn(C_NaiteiKakuteiKbn pDispdratenaiteikakuteikbn) {
        dispdratenaiteikakuteikbn = pDispdratenaiteikakuteikbn;
    }
}
