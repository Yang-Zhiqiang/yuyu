
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 代理店コード検索区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DrtnCdKensakuKbn</td><td colspan="3">代理店コード検索区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">&nbsp;</td><td>{@link #OYADRTEN}</td><td>&quot;1&quot;</td><td>親代理店</td></tr>
 *  <tr><td align="center">○</td><td>{@link #TRATKIDRTEN}</td><td>&quot;2&quot;</td><td>取扱代理店（子）</td></tr>
 * </table>
 */
public class C_DrtnCdKensakuKbn extends Classification<C_DrtnCdKensakuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DrtnCdKensakuKbn OYADRTEN = new C_DrtnCdKensakuKbn("1");

    public static final C_DrtnCdKensakuKbn TRATKIDRTEN = new C_DrtnCdKensakuKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, OYADRTEN, "OYADRTEN", false);
        addPattern(PATTERN_DEFAULT, TRATKIDRTEN, "TRATKIDRTEN", true);


        lock(C_DrtnCdKensakuKbn.class);
    }

    private C_DrtnCdKensakuKbn(String value) {
        super(value);
    }

    public static C_DrtnCdKensakuKbn valueOf(String value) {
        return valueOf(C_DrtnCdKensakuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DrtnCdKensakuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DrtnCdKensakuKbn.class, patternId, value);
    }
}
