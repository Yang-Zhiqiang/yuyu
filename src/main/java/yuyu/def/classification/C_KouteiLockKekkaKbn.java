
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 工程ロック結果区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KouteiLockKekkaKbn</td><td colspan="3">工程ロック結果区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #SUCCESS}</td><td>&quot;1&quot;</td><td>正常終了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FAILURE_SELF}</td><td>&quot;2&quot;</td><td>自工程ロック失敗</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FAILURE_CHILD}</td><td>&quot;3&quot;</td><td>子工程ロック失敗</td></tr>
 * </table>
 */
public class C_KouteiLockKekkaKbn extends Classification<C_KouteiLockKekkaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KouteiLockKekkaKbn SUCCESS = new C_KouteiLockKekkaKbn("1");

    public static final C_KouteiLockKekkaKbn FAILURE_SELF = new C_KouteiLockKekkaKbn("2");

    public static final C_KouteiLockKekkaKbn FAILURE_CHILD = new C_KouteiLockKekkaKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, SUCCESS, "SUCCESS", true);
        addPattern(PATTERN_DEFAULT, FAILURE_SELF, "FAILURE_SELF", false);
        addPattern(PATTERN_DEFAULT, FAILURE_CHILD, "FAILURE_CHILD", false);


        lock(C_KouteiLockKekkaKbn.class);
    }

    private C_KouteiLockKekkaKbn(String value) {
        super(value);
    }

    public static C_KouteiLockKekkaKbn valueOf(String value) {
        return valueOf(C_KouteiLockKekkaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KouteiLockKekkaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KouteiLockKekkaKbn.class, patternId, value);
    }
}
