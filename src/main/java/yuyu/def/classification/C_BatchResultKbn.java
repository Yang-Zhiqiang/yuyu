
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * バッチ結果区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_BatchResultKbn</td><td colspan="3">バッチ結果区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NORMAL}</td><td>&quot;1&quot;</td><td>正常終了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #WARN}</td><td>&quot;2&quot;</td><td>警告終了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ERROR}</td><td>&quot;3&quot;</td><td>異常終了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #INTERRUPT}</td><td>&quot;4&quot;</td><td>強制終了</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_SYOUKAI SYOUKAI}<br />(照会)</td><td align="center">&nbsp;</td><td>{@link #NORMAL}</td><td>&quot;1&quot;</td><td>正常</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #WARN}</td><td>&quot;2&quot;</td><td>警告</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ERROR}</td><td>&quot;3&quot;</td><td>異常</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #INTERRUPT}</td><td>&quot;4&quot;</td><td>中断</td></tr>
 * </table>
 */
public class C_BatchResultKbn extends Classification<C_BatchResultKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_BatchResultKbn NORMAL = new C_BatchResultKbn("1");

    public static final C_BatchResultKbn WARN = new C_BatchResultKbn("2");

    public static final C_BatchResultKbn ERROR = new C_BatchResultKbn("3");

    public static final C_BatchResultKbn INTERRUPT = new C_BatchResultKbn("4");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SYOUKAI = "2";


    static {

        addPattern(PATTERN_DEFAULT, NORMAL, "NORMAL", true);
        addPattern(PATTERN_DEFAULT, WARN, "WARN", false);
        addPattern(PATTERN_DEFAULT, ERROR, "ERROR", false);
        addPattern(PATTERN_DEFAULT, INTERRUPT, "INTERRUPT", false);


        addPattern(PATTERN_SYOUKAI, NORMAL, "NORMAL", false);
        addPattern(PATTERN_SYOUKAI, WARN, "WARN", false);
        addPattern(PATTERN_SYOUKAI, ERROR, "ERROR", false);
        addPattern(PATTERN_SYOUKAI, INTERRUPT, "INTERRUPT", false);


        lock(C_BatchResultKbn.class);
    }

    private C_BatchResultKbn(String value) {
        super(value);
    }

    public static C_BatchResultKbn valueOf(String value) {
        return valueOf(C_BatchResultKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_BatchResultKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_BatchResultKbn.class, patternId, value);
    }
}
