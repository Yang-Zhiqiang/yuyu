package yuyu.def.bosyuu.configuration;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;

/**
 * （保険募集）社内ユーザ特殊代理店ＢＥＡＮ データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenHbSyanaiuserTokusyudrtenBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenHbSyanaiuserTokusyudrtenBean() {
    }

    @SingleByteStrings
    @AlphaDigit
    private String syanaiuserdrtencd;

    public String getSyanaiuserdrtencd() {
        return syanaiuserdrtencd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyanaiuserdrtencd(String pSyanaiuserdrtencd) {
        syanaiuserdrtencd = pSyanaiuserdrtencd;
    }

    @SingleByteStrings
    @AlphaDigit
    private String oyadrtencd;

    public String getOyadrtencd() {
        return oyadrtencd;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setOyadrtencd(String pOyadrtencd) {
        oyadrtencd = pOyadrtencd;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
