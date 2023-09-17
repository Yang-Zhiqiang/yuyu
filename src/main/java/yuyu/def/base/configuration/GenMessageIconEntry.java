package yuyu.def.base.configuration;

import java.io.Serializable;

import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.util.bean.BeanUtil;

/**
 * メッセージアイコンリソース定義BEAN データレイアウトのベースBeanクラスです。<br />
 * このソースはツールにより自動生成されたものです。データレイアウト定義に変更があると上書きされてしまいます。
 */
public class GenMessageIconEntry implements Serializable {

    private static final long serialVersionUID = 1L;

    public GenMessageIconEntry() {
    }

    private String key;

    public String getKey() {
        return key;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setKey(String pKey) {
        key = pKey;
    }

    private String value;

    public String getValue() {
        return value;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setValue(String pValue) {
        value = pValue;
    }

    @Override
    public String toString() {
        return BeanUtil.toString(this);
    }

}
