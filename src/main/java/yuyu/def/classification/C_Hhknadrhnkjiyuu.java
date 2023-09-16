
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 被保険者住所変更事由 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Hhknadrhnkjiyuu</td><td colspan="3">被保険者住所変更事由</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ADRHNK}</td><td>&quot;1&quot;</td><td>住所変更</td></tr>
 * </table>
 */
public class C_Hhknadrhnkjiyuu extends Classification<C_Hhknadrhnkjiyuu> {

    private static final long serialVersionUID = 1L;


    public static final C_Hhknadrhnkjiyuu BLNK = new C_Hhknadrhnkjiyuu("0");

    public static final C_Hhknadrhnkjiyuu ADRHNK = new C_Hhknadrhnkjiyuu("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, ADRHNK, "ADRHNK", false);


        lock(C_Hhknadrhnkjiyuu.class);
    }

    private C_Hhknadrhnkjiyuu(String value) {
        super(value);
    }

    public static C_Hhknadrhnkjiyuu valueOf(String value) {
        return valueOf(C_Hhknadrhnkjiyuu.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Hhknadrhnkjiyuu.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Hhknadrhnkjiyuu.class, patternId, value);
    }
}
