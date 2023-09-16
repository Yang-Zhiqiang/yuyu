
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 名義変更事由 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Meigihnkjiyuu</td><td colspan="3">名義変更事由</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYK}</td><td>&quot;1&quot;</td><td>別人への変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAISEIKAIMEI}</td><td>&quot;2&quot;</td><td>改姓・改名・字体訂正</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKSB}</td><td>&quot;3&quot;</td><td>契約者死亡</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;4&quot;</td><td>被保険者改姓・受取人変更</td></tr>
 * </table>
 */
public class C_Meigihnkjiyuu extends Classification<C_Meigihnkjiyuu> {

    private static final long serialVersionUID = 1L;


    public static final C_Meigihnkjiyuu BLNK = new C_Meigihnkjiyuu("0");

    public static final C_Meigihnkjiyuu KYK = new C_Meigihnkjiyuu("1");

    public static final C_Meigihnkjiyuu KAISEIKAIMEI = new C_Meigihnkjiyuu("2");

    public static final C_Meigihnkjiyuu KYKSB = new C_Meigihnkjiyuu("3");

    public static final C_Meigihnkjiyuu SONOTA = new C_Meigihnkjiyuu("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KYK, "KYK", false);
        addPattern(PATTERN_DEFAULT, KAISEIKAIMEI, "KAISEIKAIMEI", false);
        addPattern(PATTERN_DEFAULT, KYKSB, "KYKSB", false);
        addPattern(PATTERN_DEFAULT, SONOTA, "SONOTA", false);


        lock(C_Meigihnkjiyuu.class);
    }

    private C_Meigihnkjiyuu(String value) {
        super(value);
    }

    public static C_Meigihnkjiyuu valueOf(String value) {
        return valueOf(C_Meigihnkjiyuu.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Meigihnkjiyuu.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Meigihnkjiyuu.class, patternId, value);
    }
}
