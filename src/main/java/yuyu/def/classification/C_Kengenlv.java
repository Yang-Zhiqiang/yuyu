
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 権限レベル クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Kengenlv</td><td colspan="3">権限レベル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #SITEISOSIKI_IKA}</td><td>&quot;1&quot;</td><td>指定組織以下</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SITEISOSIKI_ONLY}</td><td>&quot;2&quot;</td><td>指定組織のみ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SITEIBOSYUUNIN_ONLY}</td><td>&quot;3&quot;</td><td>指定募集人のみ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYSTEM_KANRI}</td><td>&quot;9&quot;</td><td>システム管理者権限</td></tr>
 * </table>
 */
public class C_Kengenlv extends Classification<C_Kengenlv> {

    private static final long serialVersionUID = 1L;


    public static final C_Kengenlv SITEISOSIKI_IKA = new C_Kengenlv("1");

    public static final C_Kengenlv SITEISOSIKI_ONLY = new C_Kengenlv("2");

    public static final C_Kengenlv SITEIBOSYUUNIN_ONLY = new C_Kengenlv("3");

    public static final C_Kengenlv SYSTEM_KANRI = new C_Kengenlv("9");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, SITEISOSIKI_IKA, "SITEISOSIKI_IKA", true);
        addPattern(PATTERN_DEFAULT, SITEISOSIKI_ONLY, "SITEISOSIKI_ONLY", false);
        addPattern(PATTERN_DEFAULT, SITEIBOSYUUNIN_ONLY, "SITEIBOSYUUNIN_ONLY", false);
        addPattern(PATTERN_DEFAULT, SYSTEM_KANRI, "SYSTEM_KANRI", false);


        lock(C_Kengenlv.class);
    }

    private C_Kengenlv(String value) {
        super(value);
    }

    public static C_Kengenlv valueOf(String value) {
        return valueOf(C_Kengenlv.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Kengenlv.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Kengenlv.class, patternId, value);
    }
}
