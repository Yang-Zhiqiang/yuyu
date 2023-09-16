
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 発生時金額種類区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HasseijikngksyuruiKbn</td><td colspan="3">発生時金額種類区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YENDTHNKHR}</td><td>&quot;1&quot;</td><td>円建変更時返戻金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKUHR}</td><td>&quot;2&quot;</td><td>解約返戻金</td></tr>
 * </table>
 */
public class C_HasseijikngksyuruiKbn extends Classification<C_HasseijikngksyuruiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HasseijikngksyuruiKbn BLNK = new C_HasseijikngksyuruiKbn("0");

    public static final C_HasseijikngksyuruiKbn YENDTHNKHR = new C_HasseijikngksyuruiKbn("1");

    public static final C_HasseijikngksyuruiKbn KAIYAKUHR = new C_HasseijikngksyuruiKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, YENDTHNKHR, "YENDTHNKHR", false);
        addPattern(PATTERN_DEFAULT, KAIYAKUHR, "KAIYAKUHR", false);


        lock(C_HasseijikngksyuruiKbn.class);
    }

    private C_HasseijikngksyuruiKbn(String value) {
        super(value);
    }

    public static C_HasseijikngksyuruiKbn valueOf(String value) {
        return valueOf(C_HasseijikngksyuruiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HasseijikngksyuruiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HasseijikngksyuruiKbn.class, patternId, value);
    }
}
