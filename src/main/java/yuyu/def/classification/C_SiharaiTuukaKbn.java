
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 支払通貨区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SiharaiTuukaKbn</td><td colspan="3">支払通貨区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YENSIHARAI}</td><td>&quot;1&quot;</td><td>円支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKASIHARAI}</td><td>&quot;2&quot;</td><td>外貨支払</td></tr>
 *  <tr><td rowspan="1">{@link #PATTERN_YENDATE YENDATE}<br />(円建用)</td><td align="center">○</td><td>{@link #YENSIHARAI}</td><td>&quot;1&quot;</td><td>円支払</td></tr>
 * </table>
 */
public class C_SiharaiTuukaKbn extends Classification<C_SiharaiTuukaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SiharaiTuukaKbn BLNK = new C_SiharaiTuukaKbn("0");

    public static final C_SiharaiTuukaKbn YENSIHARAI = new C_SiharaiTuukaKbn("1");

    public static final C_SiharaiTuukaKbn GAIKASIHARAI = new C_SiharaiTuukaKbn("2");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_YENDATE = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, YENSIHARAI, "YENSIHARAI", false);
        addPattern(PATTERN_DEFAULT, GAIKASIHARAI, "GAIKASIHARAI", false);


        addPattern(PATTERN_YENDATE, YENSIHARAI, "YENSIHARAI", true);


        lock(C_SiharaiTuukaKbn.class);
    }

    private C_SiharaiTuukaKbn(String value) {
        super(value);
    }

    public static C_SiharaiTuukaKbn valueOf(String value) {
        return valueOf(C_SiharaiTuukaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SiharaiTuukaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SiharaiTuukaKbn.class, patternId, value);
    }
}
