
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 経理用円建変更区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KeiriyendthnkKbn</td><td colspan="3">経理用円建変更区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #HENKOU}</td><td>&quot;1&quot;</td><td>円建変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TORIKESI}</td><td>&quot;2&quot;</td><td>円建変更（取消）</td></tr>
 * </table>
 */
public class C_KeiriyendthnkKbn extends Classification<C_KeiriyendthnkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KeiriyendthnkKbn HENKOU = new C_KeiriyendthnkKbn("1");

    public static final C_KeiriyendthnkKbn TORIKESI = new C_KeiriyendthnkKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, HENKOU, "HENKOU", true);
        addPattern(PATTERN_DEFAULT, TORIKESI, "TORIKESI", false);


        lock(C_KeiriyendthnkKbn.class);
    }

    private C_KeiriyendthnkKbn(String value) {
        super(value);
    }

    public static C_KeiriyendthnkKbn valueOf(String value) {
        return valueOf(C_KeiriyendthnkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KeiriyendthnkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KeiriyendthnkKbn.class, patternId, value);
    }
}
