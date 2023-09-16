
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 解約計算方式区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KaiyakuKeisanHousikiKbn</td><td colspan="3">解約計算方式区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RATE}</td><td>&quot;1&quot;</td><td>レート方式</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JITUGAKU}</td><td>&quot;2&quot;</td><td>実額方式</td></tr>
 * </table>
 */
public class C_KaiyakuKeisanHousikiKbn extends Classification<C_KaiyakuKeisanHousikiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KaiyakuKeisanHousikiKbn BLNK = new C_KaiyakuKeisanHousikiKbn("0");

    public static final C_KaiyakuKeisanHousikiKbn RATE = new C_KaiyakuKeisanHousikiKbn("1");

    public static final C_KaiyakuKeisanHousikiKbn JITUGAKU = new C_KaiyakuKeisanHousikiKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, RATE, "RATE", false);
        addPattern(PATTERN_DEFAULT, JITUGAKU, "JITUGAKU", false);


        lock(C_KaiyakuKeisanHousikiKbn.class);
    }

    private C_KaiyakuKeisanHousikiKbn(String value) {
        super(value);
    }

    public static C_KaiyakuKeisanHousikiKbn valueOf(String value) {
        return valueOf(C_KaiyakuKeisanHousikiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KaiyakuKeisanHousikiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KaiyakuKeisanHousikiKbn.class, patternId, value);
    }
}
