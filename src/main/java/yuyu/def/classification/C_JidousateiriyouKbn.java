
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 自動査定利用区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_JidousateiriyouKbn</td><td colspan="3">自動査定利用区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #WEBMOS}</td><td>&quot;1&quot;</td><td>Ｗｅｂ申込</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PAPERLESS}</td><td>&quot;2&quot;</td><td>ペーパーレス</td></tr>
 * </table>
 */
public class C_JidousateiriyouKbn extends Classification<C_JidousateiriyouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_JidousateiriyouKbn BLNK = new C_JidousateiriyouKbn("0");

    public static final C_JidousateiriyouKbn WEBMOS = new C_JidousateiriyouKbn("1");

    public static final C_JidousateiriyouKbn PAPERLESS = new C_JidousateiriyouKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, WEBMOS, "WEBMOS", false);
        addPattern(PATTERN_DEFAULT, PAPERLESS, "PAPERLESS", false);


        lock(C_JidousateiriyouKbn.class);
    }

    private C_JidousateiriyouKbn(String value) {
        super(value);
    }

    public static C_JidousateiriyouKbn valueOf(String value) {
        return valueOf(C_JidousateiriyouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_JidousateiriyouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_JidousateiriyouKbn.class, patternId, value);
    }
}
