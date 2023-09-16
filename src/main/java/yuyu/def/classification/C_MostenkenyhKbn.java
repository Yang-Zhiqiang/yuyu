
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 申込点検要否区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_MostenkenyhKbn</td><td colspan="3">申込点検要否区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>未判定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUYOU}</td><td>&quot;1&quot;</td><td>実施不要</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YOU}</td><td>&quot;2&quot;</td><td>実施要</td></tr>
 * </table>
 */
public class C_MostenkenyhKbn extends Classification<C_MostenkenyhKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_MostenkenyhKbn NONE = new C_MostenkenyhKbn("0");

    public static final C_MostenkenyhKbn HUYOU = new C_MostenkenyhKbn("1");

    public static final C_MostenkenyhKbn YOU = new C_MostenkenyhKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, HUYOU, "HUYOU", false);
        addPattern(PATTERN_DEFAULT, YOU, "YOU", false);


        lock(C_MostenkenyhKbn.class);
    }

    private C_MostenkenyhKbn(String value) {
        super(value);
    }

    public static C_MostenkenyhKbn valueOf(String value) {
        return valueOf(C_MostenkenyhKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_MostenkenyhKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_MostenkenyhKbn.class, patternId, value);
    }
}
