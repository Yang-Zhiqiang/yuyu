
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 発信許可区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HasinkyokaKbn</td><td colspan="3">発信許可区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KY}</td><td>&quot;1&quot;</td><td>許可</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;2&quot;</td><td>保留</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_RADIO RADIO}<br />(不備登録)</td><td align="center">&nbsp;</td><td>{@link #KY}</td><td>&quot;1&quot;</td><td>許可</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;2&quot;</td><td>保留</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_SKSELECT SKSELECT}<br />(新契約用)</td><td align="center">○</td><td>{@link #HORYUU}</td><td>&quot;2&quot;</td><td>保留</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KY}</td><td>&quot;1&quot;</td><td>許可</td></tr>
 * </table>
 */
public class C_HasinkyokaKbn extends Classification<C_HasinkyokaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HasinkyokaKbn BLNK = new C_HasinkyokaKbn("0");

    public static final C_HasinkyokaKbn KY = new C_HasinkyokaKbn("1");

    public static final C_HasinkyokaKbn HORYUU = new C_HasinkyokaKbn("2");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_RADIO = "2";

    public static final String PATTERN_SKSELECT = "3";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KY, "KY", false);
        addPattern(PATTERN_DEFAULT, HORYUU, "HORYUU", false);


        addPattern(PATTERN_RADIO, KY, "KY", false);
        addPattern(PATTERN_RADIO, HORYUU, "HORYUU", false);


        addPattern(PATTERN_SKSELECT, HORYUU, "HORYUU", true);
        addPattern(PATTERN_SKSELECT, KY, "KY", false);


        lock(C_HasinkyokaKbn.class);
    }

    private C_HasinkyokaKbn(String value) {
        super(value);
    }

    public static C_HasinkyokaKbn valueOf(String value) {
        return valueOf(C_HasinkyokaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HasinkyokaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HasinkyokaKbn.class, patternId, value);
    }
}
