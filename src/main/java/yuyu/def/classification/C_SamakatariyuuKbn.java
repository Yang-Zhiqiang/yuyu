
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 様方理由区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SamakatariyuuKbn</td><td colspan="3">様方理由区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIKKA}</td><td>&quot;1&quot;</td><td>実家に在住</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HAIGUUSYA}</td><td>&quot;2&quot;</td><td>配偶者の実家に在住</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOMAGO}</td><td>&quot;3&quot;</td><td>子・孫の家に在住</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYOUDAISIMAI}</td><td>&quot;4&quot;</td><td>兄弟姉妹の家に在住</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;9&quot;</td><td>その他</td></tr>
 * </table>
 */
public class C_SamakatariyuuKbn extends Classification<C_SamakatariyuuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SamakatariyuuKbn BLNK = new C_SamakatariyuuKbn("0");

    public static final C_SamakatariyuuKbn JIKKA = new C_SamakatariyuuKbn("1");

    public static final C_SamakatariyuuKbn HAIGUUSYA = new C_SamakatariyuuKbn("2");

    public static final C_SamakatariyuuKbn KOMAGO = new C_SamakatariyuuKbn("3");

    public static final C_SamakatariyuuKbn KYOUDAISIMAI = new C_SamakatariyuuKbn("4");

    public static final C_SamakatariyuuKbn SONOTA = new C_SamakatariyuuKbn("9");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, JIKKA, "JIKKA", false);
        addPattern(PATTERN_DEFAULT, HAIGUUSYA, "HAIGUUSYA", false);
        addPattern(PATTERN_DEFAULT, KOMAGO, "KOMAGO", false);
        addPattern(PATTERN_DEFAULT, KYOUDAISIMAI, "KYOUDAISIMAI", false);
        addPattern(PATTERN_DEFAULT, SONOTA, "SONOTA", false);


        lock(C_SamakatariyuuKbn.class);
    }

    private C_SamakatariyuuKbn(String value) {
        super(value);
    }

    public static C_SamakatariyuuKbn valueOf(String value) {
        return valueOf(C_SamakatariyuuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SamakatariyuuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SamakatariyuuKbn.class, patternId, value);
    }
}
