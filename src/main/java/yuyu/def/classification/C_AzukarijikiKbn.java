
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 預り時期区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_AzukarijikiKbn</td><td colspan="3">預り時期区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUNEND}</td><td>&quot;1&quot;</td><td>当年度</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZENJIGYOUNENDOIZEN}</td><td>&quot;2&quot;</td><td>前事業年度以前</td></tr>
 * </table>
 */
public class C_AzukarijikiKbn extends Classification<C_AzukarijikiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_AzukarijikiKbn BLNK = new C_AzukarijikiKbn("0");

    public static final C_AzukarijikiKbn TOUNEND = new C_AzukarijikiKbn("1");

    public static final C_AzukarijikiKbn ZENJIGYOUNENDOIZEN = new C_AzukarijikiKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TOUNEND, "TOUNEND", false);
        addPattern(PATTERN_DEFAULT, ZENJIGYOUNENDOIZEN, "ZENJIGYOUNENDOIZEN", false);


        lock(C_AzukarijikiKbn.class);
    }

    private C_AzukarijikiKbn(String value) {
        super(value);
    }

    public static C_AzukarijikiKbn valueOf(String value) {
        return valueOf(C_AzukarijikiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_AzukarijikiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_AzukarijikiKbn.class, patternId, value);
    }
}
