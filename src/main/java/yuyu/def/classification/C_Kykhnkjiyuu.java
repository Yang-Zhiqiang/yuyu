
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 契約者変更事由 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Kykhnkjiyuu</td><td colspan="3">契約者変更事由</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAISEIKAIMEI}</td><td>&quot;1&quot;</td><td>改姓・改名・字体訂正</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKHENKOU}</td><td>&quot;2&quot;</td><td>契約者変更</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_NKSELECT NKSELECT}<br />(年金用)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAISEIKAIMEI}</td><td>&quot;1&quot;</td><td>改姓・改名・字体訂正</td></tr>
 * </table>
 */
public class C_Kykhnkjiyuu extends Classification<C_Kykhnkjiyuu> {

    private static final long serialVersionUID = 1L;


    public static final C_Kykhnkjiyuu BLNK = new C_Kykhnkjiyuu("0");

    public static final C_Kykhnkjiyuu KAISEIKAIMEI = new C_Kykhnkjiyuu("1");

    public static final C_Kykhnkjiyuu KYKHENKOU = new C_Kykhnkjiyuu("2");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_NKSELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KAISEIKAIMEI, "KAISEIKAIMEI", false);
        addPattern(PATTERN_DEFAULT, KYKHENKOU, "KYKHENKOU", false);


        addPattern(PATTERN_NKSELECT, BLNK, "BLNK", true);
        addPattern(PATTERN_NKSELECT, KAISEIKAIMEI, "KAISEIKAIMEI", false);


        lock(C_Kykhnkjiyuu.class);
    }

    private C_Kykhnkjiyuu(String value) {
        super(value);
    }

    public static C_Kykhnkjiyuu valueOf(String value) {
        return valueOf(C_Kykhnkjiyuu.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Kykhnkjiyuu.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Kykhnkjiyuu.class, patternId, value);
    }
}
