
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 更新契約区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KsnkykKbn</td><td colspan="3">更新契約区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BFR_KSNKYKINF}</td><td>&quot;1&quot;</td><td>更新前契約情報</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AFT_KSNKYKINF}</td><td>&quot;2&quot;</td><td>更新後契約情報</td></tr>
 * </table>
 */
public class C_KsnkykKbn extends Classification<C_KsnkykKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KsnkykKbn BLNK = new C_KsnkykKbn("0");

    public static final C_KsnkykKbn BFR_KSNKYKINF = new C_KsnkykKbn("1");

    public static final C_KsnkykKbn AFT_KSNKYKINF = new C_KsnkykKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, BFR_KSNKYKINF, "BFR_KSNKYKINF", false);
        addPattern(PATTERN_DEFAULT, AFT_KSNKYKINF, "AFT_KSNKYKINF", false);


        lock(C_KsnkykKbn.class);
    }

    private C_KsnkykKbn(String value) {
        super(value);
    }

    public static C_KsnkykKbn valueOf(String value) {
        return valueOf(C_KsnkykKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KsnkykKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KsnkykKbn.class, patternId, value);
    }
}
