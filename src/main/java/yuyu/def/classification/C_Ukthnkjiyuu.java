
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 受取人変更事由 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Ukthnkjiyuu</td><td colspan="3">受取人変更事由</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MEIGIHNK}</td><td>&quot;1&quot;</td><td>受取人変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAISEIKAIMEI}</td><td>&quot;2&quot;</td><td>改姓・改名・字体訂正</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_SELECT SELECT}<br />(画面用)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAISEIKAIMEI}</td><td>&quot;2&quot;</td><td>改姓・改名・字体訂正</td></tr>
 * </table>
 */
public class C_Ukthnkjiyuu extends Classification<C_Ukthnkjiyuu> {

    private static final long serialVersionUID = 1L;


    public static final C_Ukthnkjiyuu BLNK = new C_Ukthnkjiyuu("0");

    public static final C_Ukthnkjiyuu MEIGIHNK = new C_Ukthnkjiyuu("1");

    public static final C_Ukthnkjiyuu KAISEIKAIMEI = new C_Ukthnkjiyuu("2");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, MEIGIHNK, "MEIGIHNK", false);
        addPattern(PATTERN_DEFAULT, KAISEIKAIMEI, "KAISEIKAIMEI", false);


        addPattern(PATTERN_SELECT, BLNK, "BLNK", true);
        addPattern(PATTERN_SELECT, KAISEIKAIMEI, "KAISEIKAIMEI", false);


        lock(C_Ukthnkjiyuu.class);
    }

    private C_Ukthnkjiyuu(String value) {
        super(value);
    }

    public static C_Ukthnkjiyuu valueOf(String value) {
        return valueOf(C_Ukthnkjiyuu.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Ukthnkjiyuu.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Ukthnkjiyuu.class, patternId, value);
    }
}
