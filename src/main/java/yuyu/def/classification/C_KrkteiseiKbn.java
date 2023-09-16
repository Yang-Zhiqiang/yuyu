
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 仮受訂正区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KrkteiseiKbn</td><td colspan="3">仮受訂正区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #FBHENKIN}</td><td>&quot;1&quot;</td><td>ＦＢ返金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HANDKRK}</td><td>&quot;2&quot;</td><td>ハンド仮受に計上</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CREDITHENKIN}</td><td>&quot;3&quot;</td><td>クレカ返金</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_SELECT SELECT}<br />(案内収納利用)</td><td align="center">○</td><td>{@link #FBHENKIN}</td><td>&quot;1&quot;</td><td>ＦＢ返金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CREDITHENKIN}</td><td>&quot;3&quot;</td><td>クレカ返金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HANDKRK}</td><td>&quot;2&quot;</td><td>ハンド仮受に計上</td></tr>
 * </table>
 */
public class C_KrkteiseiKbn extends Classification<C_KrkteiseiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KrkteiseiKbn FBHENKIN = new C_KrkteiseiKbn("1");

    public static final C_KrkteiseiKbn HANDKRK = new C_KrkteiseiKbn("2");

    public static final C_KrkteiseiKbn CREDITHENKIN = new C_KrkteiseiKbn("3");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, FBHENKIN, "FBHENKIN", true);
        addPattern(PATTERN_DEFAULT, HANDKRK, "HANDKRK", false);
        addPattern(PATTERN_DEFAULT, CREDITHENKIN, "CREDITHENKIN", false);


        addPattern(PATTERN_SELECT, FBHENKIN, "FBHENKIN", true);
        addPattern(PATTERN_SELECT, CREDITHENKIN, "CREDITHENKIN", false);
        addPattern(PATTERN_SELECT, HANDKRK, "HANDKRK", false);


        lock(C_KrkteiseiKbn.class);
    }

    private C_KrkteiseiKbn(String value) {
        super(value);
    }

    public static C_KrkteiseiKbn valueOf(String value) {
        return valueOf(C_KrkteiseiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KrkteiseiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KrkteiseiKbn.class, patternId, value);
    }
}
