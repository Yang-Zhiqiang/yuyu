
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 契約者住所変更事由 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Kykadrhnkjiyuu</td><td colspan="3">契約者住所変更事由</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ADRHNK}</td><td>&quot;1&quot;</td><td>住所変更</td></tr>
 * </table>
 */
public class C_Kykadrhnkjiyuu extends Classification<C_Kykadrhnkjiyuu> {

    private static final long serialVersionUID = 1L;


    public static final C_Kykadrhnkjiyuu BLNK = new C_Kykadrhnkjiyuu("0");

    public static final C_Kykadrhnkjiyuu ADRHNK = new C_Kykadrhnkjiyuu("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, ADRHNK, "ADRHNK", false);


        lock(C_Kykadrhnkjiyuu.class);
    }

    private C_Kykadrhnkjiyuu(String value) {
        super(value);
    }

    public static C_Kykadrhnkjiyuu valueOf(String value) {
        return valueOf(C_Kykadrhnkjiyuu.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Kykadrhnkjiyuu.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Kykadrhnkjiyuu.class, patternId, value);
    }
}
