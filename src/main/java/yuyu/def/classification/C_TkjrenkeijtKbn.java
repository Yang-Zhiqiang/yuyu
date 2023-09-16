
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 特条連携状態区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TkjrenkeijtKbn</td><td colspan="3">特条連携状態区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #KAITOUMATI}</td><td>&quot;0&quot;</td><td>回答待ち</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RENKEIMATI}</td><td>&quot;1&quot;</td><td>連携待ち</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RENKEIZUMI}</td><td>&quot;2&quot;</td><td>連携済</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RENKEIHUYOU}</td><td>&quot;3&quot;</td><td>連携不要</td></tr>
 * </table>
 */
public class C_TkjrenkeijtKbn extends Classification<C_TkjrenkeijtKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TkjrenkeijtKbn KAITOUMATI = new C_TkjrenkeijtKbn("0");

    public static final C_TkjrenkeijtKbn RENKEIMATI = new C_TkjrenkeijtKbn("1");

    public static final C_TkjrenkeijtKbn RENKEIZUMI = new C_TkjrenkeijtKbn("2");

    public static final C_TkjrenkeijtKbn RENKEIHUYOU = new C_TkjrenkeijtKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, KAITOUMATI, "KAITOUMATI", true);
        addPattern(PATTERN_DEFAULT, RENKEIMATI, "RENKEIMATI", false);
        addPattern(PATTERN_DEFAULT, RENKEIZUMI, "RENKEIZUMI", false);
        addPattern(PATTERN_DEFAULT, RENKEIHUYOU, "RENKEIHUYOU", false);


        lock(C_TkjrenkeijtKbn.class);
    }

    private C_TkjrenkeijtKbn(String value) {
        super(value);
    }

    public static C_TkjrenkeijtKbn valueOf(String value) {
        return valueOf(C_TkjrenkeijtKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TkjrenkeijtKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TkjrenkeijtKbn.class, patternId, value);
    }
}
