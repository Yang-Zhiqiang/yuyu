
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 保険料払込期間区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_PhrkkknKbn</td><td colspan="3">保険料払込期間区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYSN}</td><td>&quot;99&quot;</td><td>終身</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TO60}</td><td>&quot;60&quot;</td><td>60歳まで</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TO65}</td><td>&quot;65&quot;</td><td>65歳まで</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TO80}</td><td>&quot;80&quot;</td><td>80歳まで</td></tr>
 * </table>
 */
public class C_PhrkkknKbn extends Classification<C_PhrkkknKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_PhrkkknKbn BLNK = new C_PhrkkknKbn("0");

    public static final C_PhrkkknKbn SYSN = new C_PhrkkknKbn("99");

    public static final C_PhrkkknKbn TO60 = new C_PhrkkknKbn("60");

    public static final C_PhrkkknKbn TO65 = new C_PhrkkknKbn("65");

    public static final C_PhrkkknKbn TO80 = new C_PhrkkknKbn("80");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SYSN, "SYSN", false);
        addPattern(PATTERN_DEFAULT, TO60, "TO60", false);
        addPattern(PATTERN_DEFAULT, TO65, "TO65", false);
        addPattern(PATTERN_DEFAULT, TO80, "TO80", false);


        lock(C_PhrkkknKbn.class);
    }

    private C_PhrkkknKbn(String value) {
        super(value);
    }

    public static C_PhrkkknKbn valueOf(String value) {
        return valueOf(C_PhrkkknKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_PhrkkknKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_PhrkkknKbn.class, patternId, value);
    }
}
