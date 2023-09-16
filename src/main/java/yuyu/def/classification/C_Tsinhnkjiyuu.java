
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 通信先変更事由 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Tsinhnkjiyuu</td><td colspan="3">通信先変更事由</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ADRTEL}</td><td>&quot;1&quot;</td><td>住所・電話番号変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ADR}</td><td>&quot;2&quot;</td><td>住所のみ変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEL}</td><td>&quot;3&quot;</td><td>電話番号のみ変更</td></tr>
 * </table>
 */
public class C_Tsinhnkjiyuu extends Classification<C_Tsinhnkjiyuu> {

    private static final long serialVersionUID = 1L;


    public static final C_Tsinhnkjiyuu BLNK = new C_Tsinhnkjiyuu("0");

    public static final C_Tsinhnkjiyuu ADRTEL = new C_Tsinhnkjiyuu("1");

    public static final C_Tsinhnkjiyuu ADR = new C_Tsinhnkjiyuu("2");

    public static final C_Tsinhnkjiyuu TEL = new C_Tsinhnkjiyuu("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, ADRTEL, "ADRTEL", false);
        addPattern(PATTERN_DEFAULT, ADR, "ADR", false);
        addPattern(PATTERN_DEFAULT, TEL, "TEL", false);


        lock(C_Tsinhnkjiyuu.class);
    }

    private C_Tsinhnkjiyuu(String value) {
        super(value);
    }

    public static C_Tsinhnkjiyuu valueOf(String value) {
        return valueOf(C_Tsinhnkjiyuu.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Tsinhnkjiyuu.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Tsinhnkjiyuu.class, patternId, value);
    }
}
