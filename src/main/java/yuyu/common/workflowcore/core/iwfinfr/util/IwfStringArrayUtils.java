package yuyu.common.workflowcore.core.iwfinfr.util;

import org.apache.commons.lang.ArrayUtils;

/**
 * String配列の存在チェックを行うクラスです
 */
public class IwfStringArrayUtils {

    public static boolean containsEmpty(final String[] psTrgString) throws Exception {

        if (psTrgString == null || psTrgString.length <= 0) {
            return true;
        }
        return ArrayUtils.contains(psTrgString, "");
    }
}
