
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 工程作成契機区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KouteiSakuseiKeikiKbn</td><td colspan="3">工程作成契機区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLANK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYORUI_SAKUSEIJI}</td><td>&quot;1&quot;</td><td>書類作成時</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYORUI_TORIKOMIJI}</td><td>&quot;2&quot;</td><td>書類取込時</td></tr>
 * </table>
 */
public class C_KouteiSakuseiKeikiKbn extends Classification<C_KouteiSakuseiKeikiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KouteiSakuseiKeikiKbn BLANK = new C_KouteiSakuseiKeikiKbn("0");

    public static final C_KouteiSakuseiKeikiKbn SYORUI_SAKUSEIJI = new C_KouteiSakuseiKeikiKbn("1");

    public static final C_KouteiSakuseiKeikiKbn SYORUI_TORIKOMIJI = new C_KouteiSakuseiKeikiKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLANK, "BLANK", true);
        addPattern(PATTERN_DEFAULT, SYORUI_SAKUSEIJI, "SYORUI_SAKUSEIJI", false);
        addPattern(PATTERN_DEFAULT, SYORUI_TORIKOMIJI, "SYORUI_TORIKOMIJI", false);


        lock(C_KouteiSakuseiKeikiKbn.class);
    }

    private C_KouteiSakuseiKeikiKbn(String value) {
        super(value);
    }

    public static C_KouteiSakuseiKeikiKbn valueOf(String value) {
        return valueOf(C_KouteiSakuseiKeikiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KouteiSakuseiKeikiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KouteiSakuseiKeikiKbn.class, patternId, value);
    }
}
