
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 機能区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KinouKbn</td><td colspan="3">機能区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ONLINE}</td><td>&quot;1&quot;</td><td>オンライン機能</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BATCH}</td><td>&quot;2&quot;</td><td>バッチ機能</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ONLINEBATCH}</td><td>&quot;3&quot;</td><td>オンライン起動バッチ機能</td></tr>
 * </table>
 */
public class C_KinouKbn extends Classification<C_KinouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KinouKbn BLNK = new C_KinouKbn("0");

    public static final C_KinouKbn ONLINE = new C_KinouKbn("1");

    public static final C_KinouKbn BATCH = new C_KinouKbn("2");

    public static final C_KinouKbn ONLINEBATCH = new C_KinouKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, ONLINE, "ONLINE", false);
        addPattern(PATTERN_DEFAULT, BATCH, "BATCH", false);
        addPattern(PATTERN_DEFAULT, ONLINEBATCH, "ONLINEBATCH", false);


        lock(C_KinouKbn.class);
    }

    private C_KinouKbn(String value) {
        super(value);
    }

    public static C_KinouKbn valueOf(String value) {
        return valueOf(C_KinouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KinouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KinouKbn.class, patternId, value);
    }
}
