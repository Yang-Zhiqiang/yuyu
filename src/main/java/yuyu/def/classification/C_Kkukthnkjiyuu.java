
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 契約管理受取人変更事由 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Kkukthnkjiyuu</td><td colspan="3">契約管理受取人変更事由</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MEIGIHNK}</td><td>&quot;1&quot;</td><td>名義変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MEIGITEISEI}</td><td>&quot;2&quot;</td><td>名義訂正</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUROKU}</td><td>&quot;8&quot;</td><td>登録</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAKUJO}</td><td>&quot;9&quot;</td><td>削除</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_NENKIN NENKIN}<br />(年金)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MEIGIHNK}</td><td>&quot;1&quot;</td><td>名義変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MEIGITEISEI}</td><td>&quot;2&quot;</td><td>名義訂正</td></tr>
 * </table>
 */
public class C_Kkukthnkjiyuu extends Classification<C_Kkukthnkjiyuu> {

    private static final long serialVersionUID = 1L;


    public static final C_Kkukthnkjiyuu BLNK = new C_Kkukthnkjiyuu("0");

    public static final C_Kkukthnkjiyuu MEIGIHNK = new C_Kkukthnkjiyuu("1");

    public static final C_Kkukthnkjiyuu MEIGITEISEI = new C_Kkukthnkjiyuu("2");

    public static final C_Kkukthnkjiyuu TOUROKU = new C_Kkukthnkjiyuu("8");

    public static final C_Kkukthnkjiyuu SAKUJO = new C_Kkukthnkjiyuu("9");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_NENKIN = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, MEIGIHNK, "MEIGIHNK", false);
        addPattern(PATTERN_DEFAULT, MEIGITEISEI, "MEIGITEISEI", false);
        addPattern(PATTERN_DEFAULT, TOUROKU, "TOUROKU", false);
        addPattern(PATTERN_DEFAULT, SAKUJO, "SAKUJO", false);


        addPattern(PATTERN_NENKIN, BLNK, "BLNK", true);
        addPattern(PATTERN_NENKIN, MEIGIHNK, "MEIGIHNK", false);
        addPattern(PATTERN_NENKIN, MEIGITEISEI, "MEIGITEISEI", false);


        lock(C_Kkukthnkjiyuu.class);
    }

    private C_Kkukthnkjiyuu(String value) {
        super(value);
    }

    public static C_Kkukthnkjiyuu valueOf(String value) {
        return valueOf(C_Kkukthnkjiyuu.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Kkukthnkjiyuu.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Kkukthnkjiyuu.class, patternId, value);
    }
}
