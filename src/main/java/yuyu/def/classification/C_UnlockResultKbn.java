
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * アンロック結果区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_UnlockResultKbn</td><td colspan="3">アンロック結果区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #OK}</td><td>&quot;0&quot;</td><td>アンロック成功</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NOLOCK}</td><td>&quot;1&quot;</td><td>アンロック失敗(ロックなし)</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEY_NOT_FOUND}</td><td>&quot;2&quot;</td><td>アンロック失敗(業務キーが存在しない)</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #LOCK_KEY_ERR}</td><td>&quot;3&quot;</td><td>アンロック失敗(ロックキーが合致しない)</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UNKNOWN_ERR}</td><td>&quot;4&quot;</td><td>アンロック失敗(原因不明)</td></tr>
 * </table>
 */
public class C_UnlockResultKbn extends Classification<C_UnlockResultKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_UnlockResultKbn OK = new C_UnlockResultKbn("0");

    public static final C_UnlockResultKbn NOLOCK = new C_UnlockResultKbn("1");

    public static final C_UnlockResultKbn KEY_NOT_FOUND = new C_UnlockResultKbn("2");

    public static final C_UnlockResultKbn LOCK_KEY_ERR = new C_UnlockResultKbn("3");

    public static final C_UnlockResultKbn UNKNOWN_ERR = new C_UnlockResultKbn("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, OK, "OK", true);
        addPattern(PATTERN_DEFAULT, NOLOCK, "NOLOCK", false);
        addPattern(PATTERN_DEFAULT, KEY_NOT_FOUND, "KEY_NOT_FOUND", false);
        addPattern(PATTERN_DEFAULT, LOCK_KEY_ERR, "LOCK_KEY_ERR", false);
        addPattern(PATTERN_DEFAULT, UNKNOWN_ERR, "UNKNOWN_ERR", false);


        lock(C_UnlockResultKbn.class);
    }

    private C_UnlockResultKbn(String value) {
        super(value);
    }

    public static C_UnlockResultKbn valueOf(String value) {
        return valueOf(C_UnlockResultKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_UnlockResultKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_UnlockResultKbn.class, patternId, value);
    }
}
