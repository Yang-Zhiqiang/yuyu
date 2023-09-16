
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 数理前納区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SuuriZennouKbn</td><td colspan="3">数理前納区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #OTHER}</td><td>&quot;0&quot;</td><td>その他</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IPPAN_ZENNOU}</td><td>&quot;1&quot;</td><td>一般前納</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TKP_ZENNOU}</td><td>&quot;3&quot;</td><td>特約Ｐ前納</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TK_ZENNOU_PJYUUTOU}</td><td>&quot;4&quot;</td><td>特約前納Ｐ充当分</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZENNOU_TYUUSI}</td><td>&quot;5&quot;</td><td>前納中止</td></tr>
 * </table>
 */
public class C_SuuriZennouKbn extends Classification<C_SuuriZennouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SuuriZennouKbn OTHER = new C_SuuriZennouKbn("0");

    public static final C_SuuriZennouKbn IPPAN_ZENNOU = new C_SuuriZennouKbn("1");

    public static final C_SuuriZennouKbn TKP_ZENNOU = new C_SuuriZennouKbn("3");

    public static final C_SuuriZennouKbn TK_ZENNOU_PJYUUTOU = new C_SuuriZennouKbn("4");

    public static final C_SuuriZennouKbn ZENNOU_TYUUSI = new C_SuuriZennouKbn("5");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, OTHER, "OTHER", true);
        addPattern(PATTERN_DEFAULT, IPPAN_ZENNOU, "IPPAN_ZENNOU", false);
        addPattern(PATTERN_DEFAULT, TKP_ZENNOU, "TKP_ZENNOU", false);
        addPattern(PATTERN_DEFAULT, TK_ZENNOU_PJYUUTOU, "TK_ZENNOU_PJYUUTOU", false);
        addPattern(PATTERN_DEFAULT, ZENNOU_TYUUSI, "ZENNOU_TYUUSI", false);


        lock(C_SuuriZennouKbn.class);
    }

    private C_SuuriZennouKbn(String value) {
        super(value);
    }

    public static C_SuuriZennouKbn valueOf(String value) {
        return valueOf(C_SuuriZennouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SuuriZennouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SuuriZennouKbn.class, patternId, value);
    }
}
