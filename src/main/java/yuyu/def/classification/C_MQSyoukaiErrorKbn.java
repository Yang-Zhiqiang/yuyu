
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＭＱ照会エラー区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_MQSyoukaiErrorKbn</td><td colspan="3">ＭＱ照会エラー区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUKAIOK}</td><td>&quot;1&quot;</td><td>照会ＯＫ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUKAIERROR}</td><td>&quot;2&quot;</td><td>照会エラー</td></tr>
 * </table>
 */
public class C_MQSyoukaiErrorKbn extends Classification<C_MQSyoukaiErrorKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_MQSyoukaiErrorKbn BLNK = new C_MQSyoukaiErrorKbn("0");

    public static final C_MQSyoukaiErrorKbn SYOUKAIOK = new C_MQSyoukaiErrorKbn("1");

    public static final C_MQSyoukaiErrorKbn SYOUKAIERROR = new C_MQSyoukaiErrorKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SYOUKAIOK, "SYOUKAIOK", false);
        addPattern(PATTERN_DEFAULT, SYOUKAIERROR, "SYOUKAIERROR", false);


        lock(C_MQSyoukaiErrorKbn.class);
    }

    private C_MQSyoukaiErrorKbn(String value) {
        super(value);
    }

    public static C_MQSyoukaiErrorKbn valueOf(String value) {
        return valueOf(C_MQSyoukaiErrorKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_MQSyoukaiErrorKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_MQSyoukaiErrorKbn.class, patternId, value);
    }
}
