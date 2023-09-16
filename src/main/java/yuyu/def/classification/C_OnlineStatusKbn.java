
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * オンライン状態区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_OnlineStatusKbn</td><td colspan="3">オンライン状態区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #ONLINE_HUKA}</td><td>&quot;0&quot;</td><td>オンライン停止中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ONLINE_KA}</td><td>&quot;1&quot;</td><td>オンライン開始中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ONLINE_KA_SOSIKI}</td><td>&quot;2&quot;</td><td>オンライン開始中（組織限定）</td></tr>
 * </table>
 */
public class C_OnlineStatusKbn extends Classification<C_OnlineStatusKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_OnlineStatusKbn ONLINE_HUKA = new C_OnlineStatusKbn("0");

    public static final C_OnlineStatusKbn ONLINE_KA = new C_OnlineStatusKbn("1");

    public static final C_OnlineStatusKbn ONLINE_KA_SOSIKI = new C_OnlineStatusKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, ONLINE_HUKA, "ONLINE_HUKA", true);
        addPattern(PATTERN_DEFAULT, ONLINE_KA, "ONLINE_KA", false);
        addPattern(PATTERN_DEFAULT, ONLINE_KA_SOSIKI, "ONLINE_KA_SOSIKI", false);


        lock(C_OnlineStatusKbn.class);
    }

    private C_OnlineStatusKbn(String value) {
        super(value);
    }

    public static C_OnlineStatusKbn valueOf(String value) {
        return valueOf(C_OnlineStatusKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_OnlineStatusKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_OnlineStatusKbn.class, patternId, value);
    }
}
