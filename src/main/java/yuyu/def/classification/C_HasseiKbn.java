
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 発生区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HasseiKbn</td><td colspan="3">発生区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="1">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 * </table>
 */
public class C_HasseiKbn extends Classification<C_HasseiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HasseiKbn BLNK = new C_HasseiKbn("0");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);


        lock(C_HasseiKbn.class);
    }

    private C_HasseiKbn(String value) {
        super(value);
    }

    public static C_HasseiKbn valueOf(String value) {
        return valueOf(C_HasseiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HasseiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HasseiKbn.class, patternId, value);
    }
}
