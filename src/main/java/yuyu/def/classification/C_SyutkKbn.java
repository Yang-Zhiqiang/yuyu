
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 主契約特約区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SyutkKbn</td><td colspan="3">主契約特約区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYU}</td><td>&quot;1&quot;</td><td>主契約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TK}</td><td>&quot;2&quot;</td><td>特約</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_NOBLNK NOBLNK}<br />(ブランクなし)</td><td align="center">○</td><td>{@link #SYU}</td><td>&quot;1&quot;</td><td>主契約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TK}</td><td>&quot;2&quot;</td><td>特約</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_TORIKOMI TORIKOMI}<br />(取込)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYU}</td><td>&quot;1&quot;</td><td>主契約</td></tr>
 * </table>
 */
public class C_SyutkKbn extends Classification<C_SyutkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SyutkKbn NONE = new C_SyutkKbn("0");

    public static final C_SyutkKbn SYU = new C_SyutkKbn("1");

    public static final C_SyutkKbn TK = new C_SyutkKbn("2");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_NOBLNK = "2";

    public static final String PATTERN_TORIKOMI = "3";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, SYU, "SYU", false);
        addPattern(PATTERN_DEFAULT, TK, "TK", false);


        addPattern(PATTERN_NOBLNK, SYU, "SYU", true);
        addPattern(PATTERN_NOBLNK, TK, "TK", false);


        addPattern(PATTERN_TORIKOMI, NONE, "NONE", true);
        addPattern(PATTERN_TORIKOMI, SYU, "SYU", false);


        lock(C_SyutkKbn.class);
    }

    private C_SyutkKbn(String value) {
        super(value);
    }

    public static C_SyutkKbn valueOf(String value) {
        return valueOf(C_SyutkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SyutkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SyutkKbn.class, patternId, value);
    }
}
