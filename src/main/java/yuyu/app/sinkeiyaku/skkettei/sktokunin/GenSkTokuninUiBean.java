package yuyu.app.sinkeiyaku.skkettei.sktokunin;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import yuyu.def.classification.C_IkkatuyouptknKbn;
import yuyu.def.classification.C_KakoymdkyytknKbn;
import yuyu.def.classification.C_KzmeigitknKbn;
import yuyu.def.classification.C_NenkkntknKbn;
import yuyu.def.classification.C_NenreiuptknKbn;
import yuyu.def.classification.C_SaiteiptknKbn;
import yuyu.def.classification.C_SentakuinfotknKbn;
import yuyu.def.classification.C_SignalkaihiKbn;
import yuyu.def.classification.C_SonotaTokuninKbn;
import yuyu.def.classification.C_SpgndtknKbn;
import yuyu.def.classification.C_TsngndtknKbn;
import yuyu.def.classification.C_YoteiriritutknKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 特認処理 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenSkTokuninUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    private String hubisyousaibtn;

    public String getHubisyousaibtn() {
        return hubisyousaibtn;
    }

    public void setHubisyousaibtn(String pHubisyousaibtn) {
        hubisyousaibtn = pHubisyousaibtn;
    }

    @MousikomiNo
    private String mosno;

    public String getMosno() {
        return mosno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno(String pMosno) {
        mosno = pMosno;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String hhknnmkj;

    public String getHhknnmkj() {
        return hhknnmkj;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setHhknnmkj(String pHhknnmkj) {
        hhknnmkj = pHhknnmkj;
    }

    private C_SpgndtknKbn spgndtknkbn;

    public C_SpgndtknKbn getSpgndtknkbn() {
        return spgndtknkbn;
    }

    public void setSpgndtknkbn(C_SpgndtknKbn pSpgndtknkbn) {
        spgndtknkbn = pSpgndtknkbn;
    }

    private C_NenkkntknKbn nenkkntknkbn;

    public C_NenkkntknKbn getNenkkntknkbn() {
        return nenkkntknkbn;
    }

    public void setNenkkntknkbn(C_NenkkntknKbn pNenkkntknkbn) {
        nenkkntknkbn = pNenkkntknkbn;
    }

    private C_TsngndtknKbn tsngndtknkbn;

    public C_TsngndtknKbn getTsngndtknkbn() {
        return tsngndtknkbn;
    }

    public void setTsngndtknkbn(C_TsngndtknKbn pTsngndtknkbn) {
        tsngndtknkbn = pTsngndtknkbn;
    }

    private C_SentakuinfotknKbn sentakuinfotknkbn;

    public C_SentakuinfotknKbn getSentakuinfotknkbn() {
        return sentakuinfotknkbn;
    }

    public void setSentakuinfotknkbn(C_SentakuinfotknKbn pSentakuinfotknkbn) {
        sentakuinfotknkbn = pSentakuinfotknkbn;
    }

    private C_SignalkaihiKbn signalkaihikbn;

    public C_SignalkaihiKbn getSignalkaihikbn() {
        return signalkaihikbn;
    }

    public void setSignalkaihikbn(C_SignalkaihiKbn pSignalkaihikbn) {
        signalkaihikbn = pSignalkaihikbn;
    }

    private C_KakoymdkyytknKbn kakoymdkyytknkbn;

    public C_KakoymdkyytknKbn getKakoymdkyytknkbn() {
        return kakoymdkyytknkbn;
    }

    public void setKakoymdkyytknkbn(C_KakoymdkyytknKbn pKakoymdkyytknkbn) {
        kakoymdkyytknkbn = pKakoymdkyytknkbn;
    }

    private C_SaiteiptknKbn saiteiptknkbn;

    public C_SaiteiptknKbn getSaiteiptknkbn() {
        return saiteiptknkbn;
    }

    public void setSaiteiptknkbn(C_SaiteiptknKbn pSaiteiptknkbn) {
        saiteiptknkbn = pSaiteiptknkbn;
    }

    private C_YoteiriritutknKbn yoteiriritutknkbn;

    public C_YoteiriritutknKbn getYoteiriritutknkbn() {
        return yoteiriritutknkbn;
    }

    public void setYoteiriritutknkbn(C_YoteiriritutknKbn pYoteiriritutknkbn) {
        yoteiriritutknkbn = pYoteiriritutknkbn;
    }

    private C_NenreiuptknKbn nenreiuptknkbn;

    public C_NenreiuptknKbn getNenreiuptknkbn() {
        return nenreiuptknkbn;
    }

    public void setNenreiuptknkbn(C_NenreiuptknKbn pNenreiuptknkbn) {
        nenreiuptknkbn = pNenreiuptknkbn;
    }

    private C_KzmeigitknKbn kzmeigitknkbn;

    public C_KzmeigitknKbn getKzmeigitknkbn() {
        return kzmeigitknkbn;
    }

    public void setKzmeigitknkbn(C_KzmeigitknKbn pKzmeigitknkbn) {
        kzmeigitknkbn = pKzmeigitknkbn;
    }

    private C_IkkatuyouptknKbn ikkatuyouptknkbn;

    public C_IkkatuyouptknKbn getIkkatuyouptknkbn() {
        return ikkatuyouptknkbn;
    }

    public void setIkkatuyouptknkbn(C_IkkatuyouptknKbn pIkkatuyouptknkbn) {
        ikkatuyouptknkbn = pIkkatuyouptknkbn;
    }

    private C_SonotaTokuninKbn sonotatknkbn;

    public C_SonotaTokuninKbn getSonotatknkbn() {
        return sonotatknkbn;
    }

    public void setSonotatknkbn(C_SonotaTokuninKbn pSonotatknkbn) {
        sonotatknkbn = pSonotatknkbn;
    }

    private String uniqueId;

    public String getUniqueId() {
        return uniqueId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setUniqueId(String pUniqueId) {
        uniqueId = pUniqueId;
    }
}
