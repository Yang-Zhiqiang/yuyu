
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 支払振替区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_ShrhurikaeKbn</td><td colspan="3">支払振替区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MBR}</td><td>&quot;1&quot;</td><td>未払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NNDNMBR}</td><td>&quot;2&quot;</td><td>年度内未払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZANHSY}</td><td>&quot;3&quot;</td><td>残保証</td></tr>
 * </table>
 */
public class C_ShrhurikaeKbn extends Classification<C_ShrhurikaeKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_ShrhurikaeKbn BLNK = new C_ShrhurikaeKbn("0");

    public static final C_ShrhurikaeKbn MBR = new C_ShrhurikaeKbn("1");

    public static final C_ShrhurikaeKbn NNDNMBR = new C_ShrhurikaeKbn("2");

    public static final C_ShrhurikaeKbn ZANHSY = new C_ShrhurikaeKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, MBR, "MBR", false);
        addPattern(PATTERN_DEFAULT, NNDNMBR, "NNDNMBR", false);
        addPattern(PATTERN_DEFAULT, ZANHSY, "ZANHSY", false);


        lock(C_ShrhurikaeKbn.class);
    }

    private C_ShrhurikaeKbn(String value) {
        super(value);
    }

    public static C_ShrhurikaeKbn valueOf(String value) {
        return valueOf(C_ShrhurikaeKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_ShrhurikaeKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_ShrhurikaeKbn.class, patternId, value);
    }
}
