
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 被保険者変更事由 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Hhknhnkjiyuu</td><td colspan="3">被保険者変更事由</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAISEIKAIMEI}</td><td>&quot;1&quot;</td><td>改姓・改名・字体訂正</td></tr>
 * </table>
 */
public class C_Hhknhnkjiyuu extends Classification<C_Hhknhnkjiyuu> {

    private static final long serialVersionUID = 1L;


    public static final C_Hhknhnkjiyuu BLNK = new C_Hhknhnkjiyuu("0");

    public static final C_Hhknhnkjiyuu KAISEIKAIMEI = new C_Hhknhnkjiyuu("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KAISEIKAIMEI, "KAISEIKAIMEI", false);


        lock(C_Hhknhnkjiyuu.class);
    }

    private C_Hhknhnkjiyuu(String value) {
        super(value);
    }

    public static C_Hhknhnkjiyuu valueOf(String value) {
        return valueOf(C_Hhknhnkjiyuu.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Hhknhnkjiyuu.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Hhknhnkjiyuu.class, patternId, value);
    }
}
