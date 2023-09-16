
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 自動支払口座変更事由 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Jshrkzhnkjiyuu</td><td colspan="3">自動支払口座変更事由</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SETTEI}</td><td>&quot;1&quot;</td><td>設定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENKOU}</td><td>&quot;2&quot;</td><td>変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIJYO}</td><td>&quot;3&quot;</td><td>解除</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_SELECT SELECT}<br />(ブランクなし)</td><td align="center">○</td><td>{@link #SETTEI}</td><td>&quot;1&quot;</td><td>設定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENKOU}</td><td>&quot;2&quot;</td><td>変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIJYO}</td><td>&quot;3&quot;</td><td>解除</td></tr>
 * </table>
 */
public class C_Jshrkzhnkjiyuu extends Classification<C_Jshrkzhnkjiyuu> {

    private static final long serialVersionUID = 1L;


    public static final C_Jshrkzhnkjiyuu BLNK = new C_Jshrkzhnkjiyuu("0");

    public static final C_Jshrkzhnkjiyuu SETTEI = new C_Jshrkzhnkjiyuu("1");

    public static final C_Jshrkzhnkjiyuu HENKOU = new C_Jshrkzhnkjiyuu("2");

    public static final C_Jshrkzhnkjiyuu KAIJYO = new C_Jshrkzhnkjiyuu("3");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SETTEI, "SETTEI", false);
        addPattern(PATTERN_DEFAULT, HENKOU, "HENKOU", false);
        addPattern(PATTERN_DEFAULT, KAIJYO, "KAIJYO", false);


        addPattern(PATTERN_SELECT, SETTEI, "SETTEI", true);
        addPattern(PATTERN_SELECT, HENKOU, "HENKOU", false);
        addPattern(PATTERN_SELECT, KAIJYO, "KAIJYO", false);


        lock(C_Jshrkzhnkjiyuu.class);
    }

    private C_Jshrkzhnkjiyuu(String value) {
        super(value);
    }

    public static C_Jshrkzhnkjiyuu valueOf(String value) {
        return valueOf(C_Jshrkzhnkjiyuu.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Jshrkzhnkjiyuu.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Jshrkzhnkjiyuu.class, patternId, value);
    }
}
