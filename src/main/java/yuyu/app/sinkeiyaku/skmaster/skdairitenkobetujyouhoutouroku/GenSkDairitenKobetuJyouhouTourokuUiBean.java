package yuyu.app.sinkeiyaku.skmaster.skdairitenkobetujyouhoutouroku;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import yuyu.def.classification.C_DrtenRnrkhouKbn;
import yuyu.def.classification.C_NykntratkiKbn;
import yuyu.def.classification.C_TrksskssouhuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YouhiblnkKbn;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 代理店個別情報登録 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenSkDairitenKobetuJyouhouTourokuUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    @MaxLength(max=7)
    @AlphaDigit
    private String drtencd;

    public String getDrtencd() {
        return drtencd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDrtencd(String pDrtencd) {
        drtencd = pDrtencd;
    }

    @Length(length=4)
    @Digit
    private String bankcd;

    public String getBankcd() {
        return bankcd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setBankcd(String pBankcd) {
        bankcd = pBankcd;
    }

    private String oyadrtennm;

    public String getOyadrtennm() {
        return oyadrtennm;
    }

    public void setOyadrtennm(String pOyadrtennm) {
        oyadrtennm = pOyadrtennm;
    }

    private C_DrtenRnrkhouKbn drtenRnrkhouKbn;

    public C_DrtenRnrkhouKbn getDrtenRnrkhouKbn() {
        return drtenRnrkhouKbn;
    }

    public void setDrtenRnrkhouKbn(C_DrtenRnrkhouKbn pDrtenRnrkhouKbn) {
        drtenRnrkhouKbn = pDrtenRnrkhouKbn;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String utdskknnm1kj;

    public String getUtdskknnm1kj() {
        return utdskknnm1kj;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setUtdskknnm1kj(String pUtdskknnm1kj) {
        utdskknnm1kj = pUtdskknnm1kj;
    }

    @MaxLength(max=15)
    @MultiByteStrings
    @InvalidCharacter
    private String utdskknnm2kj;

    public String getUtdskknnm2kj() {
        return utdskknnm2kj;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setUtdskknnm2kj(String pUtdskknnm2kj) {
        utdskknnm2kj = pUtdskknnm2kj;
    }

    private C_NykntratkiKbn nykntratkikbn;

    public C_NykntratkiKbn getNykntratkikbn() {
        return nykntratkikbn;
    }

    public void setNykntratkikbn(C_NykntratkiKbn pNykntratkikbn) {
        nykntratkikbn = pNykntratkikbn;
    }

    private C_TrksskssouhuKbn trksskssouhukbn;

    public C_TrksskssouhuKbn getTrksskssouhukbn() {
        return trksskssouhukbn;
    }

    public void setTrksskssouhukbn(C_TrksskssouhuKbn pTrksskssouhukbn) {
        trksskssouhukbn = pTrksskssouhukbn;
    }

    @AlphaDigit
    @MaxLength(max=4)
    private String tkhjnkinyuucd;

    public String getTkhjnkinyuucd() {
        return tkhjnkinyuucd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTkhjnkinyuucd(String pTkhjnkinyuucd) {
        tkhjnkinyuucd = pTkhjnkinyuucd;
    }

    private C_YouhiKbn cifcdcheckyouhi;

    public C_YouhiKbn getCifcdcheckyouhi() {
        return cifcdcheckyouhi;
    }

    public void setCifcdcheckyouhi(C_YouhiKbn pCifcdcheckyouhi) {
        cifcdcheckyouhi = pCifcdcheckyouhi;
    }

    @MaxLength(max=2)
    @SingleByteStrings
    @Digit
    private String cifcdsiteiketasuu;

    public String getCifcdsiteiketasuu() {
        return cifcdsiteiketasuu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCifcdsiteiketasuu(String pCifcdsiteiketasuu) {
        cifcdsiteiketasuu = pCifcdsiteiketasuu;
    }

    private C_YouhiblnkKbn cifcdmaezeroumeyouhi;

    public C_YouhiblnkKbn getCifcdmaezeroumeyouhi() {
        return cifcdmaezeroumeyouhi;
    }

    public void setCifcdmaezeroumeyouhi(C_YouhiblnkKbn pCifcdmaezeroumeyouhi) {
        cifcdmaezeroumeyouhi = pCifcdmaezeroumeyouhi;
    }
}
