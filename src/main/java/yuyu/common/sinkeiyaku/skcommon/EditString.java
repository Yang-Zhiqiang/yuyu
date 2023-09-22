package yuyu.common.sinkeiyaku.skcommon;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.DateFormatUtil;

/**
 * 新契約 新契約共通 文字列編集
 */
public class EditString {

    public EditString() {
        super();
    }

    public static String editStringJoint(String[] pStrs) {
        StringBuffer out = new StringBuffer();
        boolean itiFlg = false;
        for (int index = 0; index < pStrs.length; index++) {
            if (!itiFlg) {
                out.append(pStrs[index]);
                itiFlg = true;
            }
            else {
                out.append("+");
                out.append(pStrs[index]);
            }
        }

        return out.toString();
    }

    public static String editYmdhms(String pDate) {

        StringBuffer str = new StringBuffer();

        if (!BizUtil.isBlank(pDate) && pDate.length() >= 14) {

            str.append(DateFormatUtil.dateDOT(pDate.substring(0, 8)));
            str.append(" ");
            str.append(pDate.substring(8, 10));
            str.append(":");
            str.append(pDate.substring(10, 12));
            str.append(":");
            str.append(pDate.substring(12, 14));
        }

        return str.toString();
    }

    public static String editYmdhm(String pDate) {
        StringBuffer str = new StringBuffer();

        if (!BizUtil.isBlank(pDate) && pDate.length() >= 12) {

            str.append(DateFormatUtil.dateDOT(pDate.substring(0, 8)));
            str.append(" ");
            str.append(pDate.substring(8, 10));
            str.append(":");
            str.append(pDate.substring(10, 12));
        }

        return str.toString();
    }
}