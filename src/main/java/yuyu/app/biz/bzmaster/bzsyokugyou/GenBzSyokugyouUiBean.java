package yuyu.app.biz.bzmaster.bzsyokugyou;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.MultiByteStrings;
import jp.co.slcs.swak.web.ui.AbstractUiBean;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.InvalidCharacter;

/**
 * 職業登録 : 画面UiBeanの抽象親クラスです。<br />
 * このソースはツールによる自動生成で、画面項目定義の変更に連動して更新されます。
 * 手書きコードを加えないでください。
 */
public abstract class GenBzSyokugyouUiBean extends AbstractUiBean {

    private static final long serialVersionUID = 1L;

    @MaxLength(max=3)
    @AlphaDigit
    @HostInvalidCharacter
    private String syokugyoucd;

    public String getSyokugyoucd() {
        return syokugyoucd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyokugyoucd(String pSyokugyoucd) {
        syokugyoucd = pSyokugyoucd;
    }

    @MaxLength(max=20)
    @MultiByteStrings
    @InvalidCharacter
    private String syokugyounm;

    public String getSyokugyounm() {
        return syokugyounm;
    }

    @Trim("both")
    @DataConvert("toMultiByte")
    public void setSyokugyounm(String pSyokugyounm) {
        syokugyounm = pSyokugyounm;
    }
}
