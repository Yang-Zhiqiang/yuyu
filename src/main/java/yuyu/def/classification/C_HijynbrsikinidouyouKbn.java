
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 平準払資金移動要区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HijynbrsikinidouyouKbn</td><td colspan="3">平準払資金移動要区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YOU}</td><td>&quot;1&quot;</td><td>要</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YOUP}</td><td>&quot;2&quot;</td><td>要（保険料）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HI}</td><td>&quot;3&quot;</td><td>否</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HIP}</td><td>&quot;4&quot;</td><td>否（保険料）</td></tr>
 * </table>
 */
public class C_HijynbrsikinidouyouKbn extends Classification<C_HijynbrsikinidouyouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HijynbrsikinidouyouKbn BLNK = new C_HijynbrsikinidouyouKbn("0");

    public static final C_HijynbrsikinidouyouKbn YOU = new C_HijynbrsikinidouyouKbn("1");

    public static final C_HijynbrsikinidouyouKbn YOUP = new C_HijynbrsikinidouyouKbn("2");

    public static final C_HijynbrsikinidouyouKbn HI = new C_HijynbrsikinidouyouKbn("3");

    public static final C_HijynbrsikinidouyouKbn HIP = new C_HijynbrsikinidouyouKbn("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, YOU, "YOU", false);
        addPattern(PATTERN_DEFAULT, YOUP, "YOUP", false);
        addPattern(PATTERN_DEFAULT, HI, "HI", false);
        addPattern(PATTERN_DEFAULT, HIP, "HIP", false);


        lock(C_HijynbrsikinidouyouKbn.class);
    }

    private C_HijynbrsikinidouyouKbn(String value) {
        super(value);
    }

    public static C_HijynbrsikinidouyouKbn valueOf(String value) {
        return valueOf(C_HijynbrsikinidouyouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HijynbrsikinidouyouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HijynbrsikinidouyouKbn.class, patternId, value);
    }
}
