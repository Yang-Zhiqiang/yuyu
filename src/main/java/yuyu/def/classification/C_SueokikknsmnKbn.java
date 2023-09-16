
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 据置期間歳満期区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SueokikknsmnKbn</td><td colspan="3">据置期間歳満期区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAIMANKI}</td><td>&quot;1&quot;</td><td>歳満期</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NENMANKI}</td><td>&quot;2&quot;</td><td>年満期</td></tr>
 * </table>
 */
public class C_SueokikknsmnKbn extends Classification<C_SueokikknsmnKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SueokikknsmnKbn BLNK = new C_SueokikknsmnKbn("0");

    public static final C_SueokikknsmnKbn SAIMANKI = new C_SueokikknsmnKbn("1");

    public static final C_SueokikknsmnKbn NENMANKI = new C_SueokikknsmnKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SAIMANKI, "SAIMANKI", false);
        addPattern(PATTERN_DEFAULT, NENMANKI, "NENMANKI", false);


        lock(C_SueokikknsmnKbn.class);
    }

    private C_SueokikknsmnKbn(String value) {
        super(value);
    }

    public static C_SueokikknsmnKbn valueOf(String value) {
        return valueOf(C_SueokikknsmnKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SueokikknsmnKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SueokikknsmnKbn.class, patternId, value);
    }
}
