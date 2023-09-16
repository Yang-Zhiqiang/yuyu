
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 主たる支払額小計種類区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SyuShrgkSyoukeiKbn</td><td colspan="3">主たる支払額小計種類区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #W}</td><td>&quot;1&quot;</td><td>解約返戻金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #V}</td><td>&quot;2&quot;</td><td>保険料積立金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #D}</td><td>&quot;3&quot;</td><td>配当金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KIHARAIP}</td><td>&quot;8&quot;</td><td>既払込保険料</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENKANKIN}</td><td>&quot;9&quot;</td><td>返還金</td></tr>
 * </table>
 */
public class C_SyuShrgkSyoukeiKbn extends Classification<C_SyuShrgkSyoukeiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SyuShrgkSyoukeiKbn BLNK = new C_SyuShrgkSyoukeiKbn("0");

    public static final C_SyuShrgkSyoukeiKbn W = new C_SyuShrgkSyoukeiKbn("1");

    public static final C_SyuShrgkSyoukeiKbn V = new C_SyuShrgkSyoukeiKbn("2");

    public static final C_SyuShrgkSyoukeiKbn D = new C_SyuShrgkSyoukeiKbn("3");

    public static final C_SyuShrgkSyoukeiKbn KIHARAIP = new C_SyuShrgkSyoukeiKbn("8");

    public static final C_SyuShrgkSyoukeiKbn HENKANKIN = new C_SyuShrgkSyoukeiKbn("9");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, W, "W", false);
        addPattern(PATTERN_DEFAULT, V, "V", false);
        addPattern(PATTERN_DEFAULT, D, "D", false);
        addPattern(PATTERN_DEFAULT, KIHARAIP, "KIHARAIP", false);
        addPattern(PATTERN_DEFAULT, HENKANKIN, "HENKANKIN", false);


        lock(C_SyuShrgkSyoukeiKbn.class);
    }

    private C_SyuShrgkSyoukeiKbn(String value) {
        super(value);
    }

    public static C_SyuShrgkSyoukeiKbn valueOf(String value) {
        return valueOf(C_SyuShrgkSyoukeiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SyuShrgkSyoukeiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SyuShrgkSyoukeiKbn.class, patternId, value);
    }
}
