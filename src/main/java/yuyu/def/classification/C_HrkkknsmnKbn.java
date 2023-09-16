
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 払込期間歳満期区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HrkkknsmnKbn</td><td colspan="3">払込期間歳満期区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAIMANKI}</td><td>&quot;1&quot;</td><td>歳満期</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NENMANKI}</td><td>&quot;2&quot;</td><td>年満期</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_SELECT SELECT}<br />(選択)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAIMANKI}</td><td>&quot;1&quot;</td><td>歳</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NENMANKI}</td><td>&quot;2&quot;</td><td>年</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_TSEK TSEK}<br />(通常設計)</td><td align="center">○</td><td>{@link #SAIMANKI}</td><td>&quot;1&quot;</td><td>歳</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NENMANKI}</td><td>&quot;2&quot;</td><td>年</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_MOS MOS}<br />(申込書入力)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAIMANKI}</td><td>&quot;1&quot;</td><td>歳</td></tr>
 * </table>
 */
public class C_HrkkknsmnKbn extends Classification<C_HrkkknsmnKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HrkkknsmnKbn BLNK = new C_HrkkknsmnKbn("0");

    public static final C_HrkkknsmnKbn SAIMANKI = new C_HrkkknsmnKbn("1");

    public static final C_HrkkknsmnKbn NENMANKI = new C_HrkkknsmnKbn("2");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";

    public static final String PATTERN_TSEK = "3";

    public static final String PATTERN_MOS = "4";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SAIMANKI, "SAIMANKI", false);
        addPattern(PATTERN_DEFAULT, NENMANKI, "NENMANKI", false);


        addPattern(PATTERN_SELECT, BLNK, "BLNK", true);
        addPattern(PATTERN_SELECT, SAIMANKI, "SAIMANKI", false);
        addPattern(PATTERN_SELECT, NENMANKI, "NENMANKI", false);


        addPattern(PATTERN_TSEK, SAIMANKI, "SAIMANKI", true);
        addPattern(PATTERN_TSEK, NENMANKI, "NENMANKI", false);


        addPattern(PATTERN_MOS, BLNK, "BLNK", true);
        addPattern(PATTERN_MOS, SAIMANKI, "SAIMANKI", false);


        lock(C_HrkkknsmnKbn.class);
    }

    private C_HrkkknsmnKbn(String value) {
        super(value);
    }

    public static C_HrkkknsmnKbn valueOf(String value) {
        return valueOf(C_HrkkknsmnKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HrkkknsmnKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HrkkknsmnKbn.class, patternId, value);
    }
}
