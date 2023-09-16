
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 配当明細区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HaitoumeisaiKbn</td><td colspan="3">配当明細区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYU}</td><td>&quot;1&quot;</td><td>主契約</td></tr>
 * </table>
 */
public class C_HaitoumeisaiKbn extends Classification<C_HaitoumeisaiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HaitoumeisaiKbn BLNK = new C_HaitoumeisaiKbn("0");

    public static final C_HaitoumeisaiKbn SYU = new C_HaitoumeisaiKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SYU, "SYU", false);


        lock(C_HaitoumeisaiKbn.class);
    }

    private C_HaitoumeisaiKbn(String value) {
        super(value);
    }

    public static C_HaitoumeisaiKbn valueOf(String value) {
        return valueOf(C_HaitoumeisaiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HaitoumeisaiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HaitoumeisaiKbn.class, patternId, value);
    }
}
