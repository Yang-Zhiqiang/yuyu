
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 帳票作成状態区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TyhysakuseiKbn</td><td colspan="3">帳票作成状態区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #MISAKUSEI}</td><td>&quot;0&quot;</td><td>未作成</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAKUSEIMATI}</td><td>&quot;1&quot;</td><td>作成待ち</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAKUSEIZUMII}</td><td>&quot;2&quot;</td><td>作成済み</td></tr>
 * </table>
 */
public class C_TyhysakuseiKbn extends Classification<C_TyhysakuseiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TyhysakuseiKbn MISAKUSEI = new C_TyhysakuseiKbn("0");

    public static final C_TyhysakuseiKbn SAKUSEIMATI = new C_TyhysakuseiKbn("1");

    public static final C_TyhysakuseiKbn SAKUSEIZUMII = new C_TyhysakuseiKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, MISAKUSEI, "MISAKUSEI", true);
        addPattern(PATTERN_DEFAULT, SAKUSEIMATI, "SAKUSEIMATI", false);
        addPattern(PATTERN_DEFAULT, SAKUSEIZUMII, "SAKUSEIZUMII", false);


        lock(C_TyhysakuseiKbn.class);
    }

    private C_TyhysakuseiKbn(String value) {
        super(value);
    }

    public static C_TyhysakuseiKbn valueOf(String value) {
        return valueOf(C_TyhysakuseiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TyhysakuseiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TyhysakuseiKbn.class, patternId, value);
    }
}
