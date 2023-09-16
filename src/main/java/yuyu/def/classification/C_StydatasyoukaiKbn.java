
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 進捗データ照会区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_StydatasyoukaiKbn</td><td colspan="3">進捗データ照会区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #ALL}</td><td>&quot;0&quot;</td><td>すべて</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #STYJK}</td><td>&quot;1&quot;</td><td>進捗状況</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBIJK}</td><td>&quot;2&quot;</td><td>不備状況</td></tr>
 * </table>
 */
public class C_StydatasyoukaiKbn extends Classification<C_StydatasyoukaiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_StydatasyoukaiKbn ALL = new C_StydatasyoukaiKbn("0");

    public static final C_StydatasyoukaiKbn STYJK = new C_StydatasyoukaiKbn("1");

    public static final C_StydatasyoukaiKbn HUBIJK = new C_StydatasyoukaiKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, ALL, "ALL", true);
        addPattern(PATTERN_DEFAULT, STYJK, "STYJK", false);
        addPattern(PATTERN_DEFAULT, HUBIJK, "HUBIJK", false);


        lock(C_StydatasyoukaiKbn.class);
    }

    private C_StydatasyoukaiKbn(String value) {
        super(value);
    }

    public static C_StydatasyoukaiKbn valueOf(String value) {
        return valueOf(C_StydatasyoukaiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_StydatasyoukaiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_StydatasyoukaiKbn.class, patternId, value);
    }
}
