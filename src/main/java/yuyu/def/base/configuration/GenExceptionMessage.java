package yuyu.def.base.configuration;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * 例外メッセージ定義BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenExceptionMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenExceptionMessage() {
    }

    private String exception;

    public String getException() {
        return exception;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setException(String pException) {
        exception = pException;
    }

    private String titleId;

    public String getTitleId() {
        return titleId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTitleId(String pTitleId) {
        titleId = pTitleId;
    }

    private String messageId;

    public String getMessageId() {
        return messageId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMessageId(String pMessageId) {
        messageId = pMessageId;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
