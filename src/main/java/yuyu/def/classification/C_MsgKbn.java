
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * メッセージ区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_MsgKbn</td><td colspan="3">メッセージ区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #ERROR}</td><td>&quot;0&quot;</td><td>エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #WARNING}</td><td>&quot;1&quot;</td><td>ワーニング</td></tr>
 * </table>
 */
public class C_MsgKbn extends Classification<C_MsgKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_MsgKbn ERROR = new C_MsgKbn("0");

    public static final C_MsgKbn WARNING = new C_MsgKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, ERROR, "ERROR", true);
        addPattern(PATTERN_DEFAULT, WARNING, "WARNING", false);


        lock(C_MsgKbn.class);
    }

    private C_MsgKbn(String value) {
        super(value);
    }

    public static C_MsgKbn valueOf(String value) {
        return valueOf(C_MsgKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_MsgKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_MsgKbn.class, patternId, value);
    }
}
