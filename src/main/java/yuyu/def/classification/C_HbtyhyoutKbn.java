
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 不備帳票出力区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HbtyhyoutKbn</td><td colspan="3">不備帳票出力区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BATCH}</td><td>&quot;1&quot;</td><td>バッチ出力</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ONLINE}</td><td>&quot;2&quot;</td><td>オンライン</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_SKSELECT SKSELECT}<br />(新契約)</td><td align="center">○</td><td>{@link #BATCH}</td><td>&quot;1&quot;</td><td>バッチ出力</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ONLINE}</td><td>&quot;2&quot;</td><td>オンライン</td></tr>
 * </table>
 */
public class C_HbtyhyoutKbn extends Classification<C_HbtyhyoutKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HbtyhyoutKbn BLNK = new C_HbtyhyoutKbn("0");

    public static final C_HbtyhyoutKbn BATCH = new C_HbtyhyoutKbn("1");

    public static final C_HbtyhyoutKbn ONLINE = new C_HbtyhyoutKbn("2");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SKSELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, BATCH, "BATCH", false);
        addPattern(PATTERN_DEFAULT, ONLINE, "ONLINE", false);


        addPattern(PATTERN_SKSELECT, BATCH, "BATCH", true);
        addPattern(PATTERN_SKSELECT, ONLINE, "ONLINE", false);


        lock(C_HbtyhyoutKbn.class);
    }

    private C_HbtyhyoutKbn(String value) {
        super(value);
    }

    public static C_HbtyhyoutKbn valueOf(String value) {
        return valueOf(C_HbtyhyoutKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HbtyhyoutKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HbtyhyoutKbn.class, patternId, value);
    }
}
