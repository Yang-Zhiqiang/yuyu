package yuyu.app.hozen.khozen.khcifcdikkatuhenkoutouroku;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import yuyu.infr.validation.constraints.HostInvalidCharacter;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * ＣＩＦコード一括変更登録 - ＣＩＦコード変更情報一覧 の 行データBean ベースクラスです。<br />
 * このソースはツールにより自動生成されたものです。
 * 画面項目定義に変更があると上書きされてしまうので、手で編集しないで下さい。
 */
public class GenCifCodeHenkouInfoDataSourceBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer disprenno3keta;

    public Integer getDisprenno3keta() {
        return disprenno3keta;
    }

    public void setDisprenno3keta(Integer pDisprenno3keta) {
        disprenno3keta = pDisprenno3keta;
    }


    @SyoukenNo
    private String syono;

    public String getSyono() {
        return syono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        syono = pSyono;
    }


    @MaxLength(max=15)
    @AlphaDigit
    @HostInvalidCharacter
    private String cifcd;

    public String getCifcd() {
        return cifcd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setCifcd(String pCifcd) {
        cifcd = pCifcd;
    }

}
