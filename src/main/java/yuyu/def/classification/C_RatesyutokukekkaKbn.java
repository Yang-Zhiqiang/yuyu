
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 換算用為替レート取得結果区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_RatesyutokukekkaKbn</td><td colspan="3">換算用為替レート取得結果区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #SEIJYOU}</td><td>&quot;0&quot;</td><td>正常取得</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MINASHI}</td><td>&quot;1&quot;</td><td>みなし取得</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ERROR}</td><td>&quot;2&quot;</td><td>取得エラー</td></tr>
 * </table>
 */
public class C_RatesyutokukekkaKbn extends Classification<C_RatesyutokukekkaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_RatesyutokukekkaKbn SEIJYOU = new C_RatesyutokukekkaKbn("0");

    public static final C_RatesyutokukekkaKbn MINASHI = new C_RatesyutokukekkaKbn("1");

    public static final C_RatesyutokukekkaKbn ERROR = new C_RatesyutokukekkaKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, SEIJYOU, "SEIJYOU", true);
        addPattern(PATTERN_DEFAULT, MINASHI, "MINASHI", false);
        addPattern(PATTERN_DEFAULT, ERROR, "ERROR", false);


        lock(C_RatesyutokukekkaKbn.class);
    }

    private C_RatesyutokukekkaKbn(String value) {
        super(value);
    }

    public static C_RatesyutokukekkaKbn valueOf(String value) {
        return valueOf(C_RatesyutokukekkaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_RatesyutokukekkaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_RatesyutokukekkaKbn.class, patternId, value);
    }
}
