
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 重度介護前払特約変更区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_JyudkaigomaebaraiTkykhnkKbn</td><td colspan="3">重度介護前払特約変更区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TKYKHUKA}</td><td>&quot;1&quot;</td><td>特約中途付加</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKU}</td><td>&quot;2&quot;</td><td>解約</td></tr>
 * </table>
 */
public class C_JyudkaigomaebaraiTkykhnkKbn extends Classification<C_JyudkaigomaebaraiTkykhnkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_JyudkaigomaebaraiTkykhnkKbn BLNK = new C_JyudkaigomaebaraiTkykhnkKbn("0");

    public static final C_JyudkaigomaebaraiTkykhnkKbn TKYKHUKA = new C_JyudkaigomaebaraiTkykhnkKbn("1");

    public static final C_JyudkaigomaebaraiTkykhnkKbn KAIYAKU = new C_JyudkaigomaebaraiTkykhnkKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TKYKHUKA, "TKYKHUKA", false);
        addPattern(PATTERN_DEFAULT, KAIYAKU, "KAIYAKU", false);


        lock(C_JyudkaigomaebaraiTkykhnkKbn.class);
    }

    private C_JyudkaigomaebaraiTkykhnkKbn(String value) {
        super(value);
    }

    public static C_JyudkaigomaebaraiTkykhnkKbn valueOf(String value) {
        return valueOf(C_JyudkaigomaebaraiTkykhnkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_JyudkaigomaebaraiTkykhnkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_JyudkaigomaebaraiTkykhnkKbn.class, patternId, value);
    }
}
