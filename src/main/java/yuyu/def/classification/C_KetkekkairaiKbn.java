
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 決定結果入力依頼区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KetkekkairaiKbn</td><td colspan="3">決定結果入力依頼区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NONE}</td><td>&quot;1&quot;</td><td>依頼しない</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IRAI}</td><td>&quot;2&quot;</td><td>依頼する</td></tr>
 * </table>
 */
public class C_KetkekkairaiKbn extends Classification<C_KetkekkairaiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KetkekkairaiKbn BLNK = new C_KetkekkairaiKbn("0");

    public static final C_KetkekkairaiKbn NONE = new C_KetkekkairaiKbn("1");

    public static final C_KetkekkairaiKbn IRAI = new C_KetkekkairaiKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, NONE, "NONE", false);
        addPattern(PATTERN_DEFAULT, IRAI, "IRAI", false);


        lock(C_KetkekkairaiKbn.class);
    }

    private C_KetkekkairaiKbn(String value) {
        super(value);
    }

    public static C_KetkekkairaiKbn valueOf(String value) {
        return valueOf(C_KetkekkairaiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KetkekkairaiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KetkekkairaiKbn.class, patternId, value);
    }
}
