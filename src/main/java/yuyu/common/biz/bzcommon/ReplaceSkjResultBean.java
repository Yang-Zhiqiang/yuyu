package yuyu.common.biz.bzcommon;

import java.io.Serializable;

/**
 * SKJ変換の結果返却用Beanです。<br />
 * フィールドに、変換有無（boolean）と変換後文字列（String）を持ちます。
 */
public class ReplaceSkjResultBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean replaced;

    private String replacedString;

    public boolean isReplaced() {
        return replaced;
    }

    void setReplaced(boolean repalaced) {
        this.replaced = repalaced;
    }

    public String getReplacedString() {
        return replacedString;
    }

    void setReplacedString(String replacedString) {
        this.replacedString = replacedString;
    }

}
