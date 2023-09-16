
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 変更前後区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HnkzengoKbn</td><td colspan="3">変更前後区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZEN}</td><td>&quot;1&quot;</td><td>前</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GO}</td><td>&quot;2&quot;</td><td>後</td></tr>
 * </table>
 */
public class C_HnkzengoKbn extends Classification<C_HnkzengoKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HnkzengoKbn BLNK = new C_HnkzengoKbn("0");

    public static final C_HnkzengoKbn ZEN = new C_HnkzengoKbn("1");

    public static final C_HnkzengoKbn GO = new C_HnkzengoKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, ZEN, "ZEN", false);
        addPattern(PATTERN_DEFAULT, GO, "GO", false);


        lock(C_HnkzengoKbn.class);
    }

    private C_HnkzengoKbn(String value) {
        super(value);
    }

    public static C_HnkzengoKbn valueOf(String value) {
        return valueOf(C_HnkzengoKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HnkzengoKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HnkzengoKbn.class, patternId, value);
    }
}
