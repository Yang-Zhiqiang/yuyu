
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * レート用通貨種類区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_RateTuukasyuKbn</td><td colspan="3">レート用通貨種類区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JPY}</td><td>&quot;1&quot;</td><td>円</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #USD}</td><td>&quot;2&quot;</td><td>米ドル</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #EUR}</td><td>&quot;3&quot;</td><td>ユーロ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AUD}</td><td>&quot;4&quot;</td><td>豪ドル</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_SELECT SELECT}<br />(選択)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JPY}</td><td>&quot;1&quot;</td><td>１：円</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #USD}</td><td>&quot;2&quot;</td><td>２：米ドル</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AUD}</td><td>&quot;4&quot;</td><td>４：豪ドル</td></tr>
 * </table>
 */
public class C_RateTuukasyuKbn extends Classification<C_RateTuukasyuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_RateTuukasyuKbn BLNK = new C_RateTuukasyuKbn("0");

    public static final C_RateTuukasyuKbn JPY = new C_RateTuukasyuKbn("1");

    public static final C_RateTuukasyuKbn USD = new C_RateTuukasyuKbn("2");

    public static final C_RateTuukasyuKbn EUR = new C_RateTuukasyuKbn("3");

    public static final C_RateTuukasyuKbn AUD = new C_RateTuukasyuKbn("4");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, JPY, "JPY", false);
        addPattern(PATTERN_DEFAULT, USD, "USD", false);
        addPattern(PATTERN_DEFAULT, EUR, "EUR", false);
        addPattern(PATTERN_DEFAULT, AUD, "AUD", false);


        addPattern(PATTERN_SELECT, BLNK, "BLNK", true);
        addPattern(PATTERN_SELECT, JPY, "JPY", false);
        addPattern(PATTERN_SELECT, USD, "USD", false);
        addPattern(PATTERN_SELECT, AUD, "AUD", false);


        lock(C_RateTuukasyuKbn.class);
    }

    private C_RateTuukasyuKbn(String value) {
        super(value);
    }

    public static C_RateTuukasyuKbn valueOf(String value) {
        return valueOf(C_RateTuukasyuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_RateTuukasyuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_RateTuukasyuKbn.class, patternId, value);
    }
}
