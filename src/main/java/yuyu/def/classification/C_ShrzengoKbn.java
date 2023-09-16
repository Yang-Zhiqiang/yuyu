
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 支払前後区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_ShrzengoKbn</td><td colspan="3">支払前後区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZEN}</td><td>&quot;1&quot;</td><td>前</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GO}</td><td>&quot;2&quot;</td><td>後</td></tr>
 * </table>
 */
public class C_ShrzengoKbn extends Classification<C_ShrzengoKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_ShrzengoKbn BLNK = new C_ShrzengoKbn("0");

    public static final C_ShrzengoKbn ZEN = new C_ShrzengoKbn("1");

    public static final C_ShrzengoKbn GO = new C_ShrzengoKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, ZEN, "ZEN", false);
        addPattern(PATTERN_DEFAULT, GO, "GO", false);


        lock(C_ShrzengoKbn.class);
    }

    private C_ShrzengoKbn(String value) {
        super(value);
    }

    public static C_ShrzengoKbn valueOf(String value) {
        return valueOf(C_ShrzengoKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_ShrzengoKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_ShrzengoKbn.class, patternId, value);
    }
}
