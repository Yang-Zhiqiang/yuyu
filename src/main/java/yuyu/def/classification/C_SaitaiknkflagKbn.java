
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 災対環境フラグ区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SaitaiknkflagKbn</td><td colspan="3">災対環境フラグ区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #HONBANKNK}</td><td>&quot;0&quot;</td><td>本番環境</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAITAIKNK}</td><td>&quot;1&quot;</td><td>災対環境</td></tr>
 * </table>
 */
public class C_SaitaiknkflagKbn extends Classification<C_SaitaiknkflagKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SaitaiknkflagKbn HONBANKNK = new C_SaitaiknkflagKbn("0");

    public static final C_SaitaiknkflagKbn SAITAIKNK = new C_SaitaiknkflagKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, HONBANKNK, "HONBANKNK", true);
        addPattern(PATTERN_DEFAULT, SAITAIKNK, "SAITAIKNK", false);


        lock(C_SaitaiknkflagKbn.class);
    }

    private C_SaitaiknkflagKbn(String value) {
        super(value);
    }

    public static C_SaitaiknkflagKbn valueOf(String value) {
        return valueOf(C_SaitaiknkflagKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SaitaiknkflagKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SaitaiknkflagKbn.class, patternId, value);
    }
}
