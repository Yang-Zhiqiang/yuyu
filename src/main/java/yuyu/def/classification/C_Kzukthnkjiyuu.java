
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 継続受取人変更事由 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Kzukthnkjiyuu</td><td colspan="3">継続受取人変更事由</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENKOU}</td><td>&quot;1&quot;</td><td>名義変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEISEI}</td><td>&quot;2&quot;</td><td>名義訂正</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUROKU}</td><td>&quot;3&quot;</td><td>登録</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAKUJYO}</td><td>&quot;4&quot;</td><td>削除</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_NODATA NODATA}<br />(データなし)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUROKU}</td><td>&quot;3&quot;</td><td>登録</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_NOTOUROKU NOTOUROKU}<br />(登録なし)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENKOU}</td><td>&quot;1&quot;</td><td>名義変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEISEI}</td><td>&quot;2&quot;</td><td>名義訂正</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAKUJYO}</td><td>&quot;4&quot;</td><td>削除</td></tr>
 * </table>
 */
public class C_Kzukthnkjiyuu extends Classification<C_Kzukthnkjiyuu> {

    private static final long serialVersionUID = 1L;


    public static final C_Kzukthnkjiyuu BLNK = new C_Kzukthnkjiyuu("0");

    public static final C_Kzukthnkjiyuu HENKOU = new C_Kzukthnkjiyuu("1");

    public static final C_Kzukthnkjiyuu TEISEI = new C_Kzukthnkjiyuu("2");

    public static final C_Kzukthnkjiyuu TOUROKU = new C_Kzukthnkjiyuu("3");

    public static final C_Kzukthnkjiyuu SAKUJYO = new C_Kzukthnkjiyuu("4");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_NODATA = "2";

    public static final String PATTERN_NOTOUROKU = "3";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HENKOU, "HENKOU", false);
        addPattern(PATTERN_DEFAULT, TEISEI, "TEISEI", false);
        addPattern(PATTERN_DEFAULT, TOUROKU, "TOUROKU", false);
        addPattern(PATTERN_DEFAULT, SAKUJYO, "SAKUJYO", false);


        addPattern(PATTERN_NODATA, BLNK, "BLNK", true);
        addPattern(PATTERN_NODATA, TOUROKU, "TOUROKU", false);


        addPattern(PATTERN_NOTOUROKU, BLNK, "BLNK", true);
        addPattern(PATTERN_NOTOUROKU, HENKOU, "HENKOU", false);
        addPattern(PATTERN_NOTOUROKU, TEISEI, "TEISEI", false);
        addPattern(PATTERN_NOTOUROKU, SAKUJYO, "SAKUJYO", false);


        lock(C_Kzukthnkjiyuu.class);
    }

    private C_Kzukthnkjiyuu(String value) {
        super(value);
    }

    public static C_Kzukthnkjiyuu valueOf(String value) {
        return valueOf(C_Kzukthnkjiyuu.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Kzukthnkjiyuu.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Kzukthnkjiyuu.class, patternId, value);
    }
}
