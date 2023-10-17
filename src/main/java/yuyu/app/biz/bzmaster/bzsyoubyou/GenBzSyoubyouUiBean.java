package yuyu.app.biz.bzmaster.bzsyoubyou;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import yuyu.def.classification.C_SyoubyouCdTyuubunruiKbn;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 傷病登録 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenBzSyoubyouUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    @MaxLength(max=6)
    @AlphaDigit
    @HostInvalidCharacter
    private String syoubyoucd;

    public String getSyoubyoucd() {
        return syoubyoucd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyoubyoucd(String pSyoubyoucd) {
        syoubyoucd = pSyoubyoucd;
    }

    @MaxLength(max=30)
    @MultiByteStrings
    @InvalidCharacter
    private String syoubyounm;

    public String getSyoubyounm() {
        return syoubyounm;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setSyoubyounm(String pSyoubyounm) {
        syoubyounm = pSyoubyounm;
    }

    private C_SyoubyouCdTyuubunruiKbn syoubyoucdtyuubunruikbn;

    public C_SyoubyouCdTyuubunruiKbn getSyoubyoucdtyuubunruikbn() {
        return syoubyoucdtyuubunruikbn;
    }

    public void setSyoubyoucdtyuubunruikbn(C_SyoubyouCdTyuubunruiKbn pSyoubyoucdtyuubunruikbn) {
        syoubyoucdtyuubunruikbn = pSyoubyoucdtyuubunruikbn;
    }
}
