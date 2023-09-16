
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 高齢者対応区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KoureisyaTaiouKbn</td><td colspan="3">高齢者対応区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINZOKU}</td><td>&quot;101&quot;</td><td>親族同席</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUKUSUUKAI}</td><td>&quot;102&quot;</td><td>複数回説明</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUBI}</td><td>&quot;110&quot;</td><td>不備</td></tr>
 * </table>
 */
public class C_KoureisyaTaiouKbn extends Classification<C_KoureisyaTaiouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KoureisyaTaiouKbn BLNK = new C_KoureisyaTaiouKbn("0");

    public static final C_KoureisyaTaiouKbn SINZOKU = new C_KoureisyaTaiouKbn("101");

    public static final C_KoureisyaTaiouKbn HUKUSUUKAI = new C_KoureisyaTaiouKbn("102");

    public static final C_KoureisyaTaiouKbn HUBI = new C_KoureisyaTaiouKbn("110");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SINZOKU, "SINZOKU", false);
        addPattern(PATTERN_DEFAULT, HUKUSUUKAI, "HUKUSUUKAI", false);
        addPattern(PATTERN_DEFAULT, HUBI, "HUBI", false);


        lock(C_KoureisyaTaiouKbn.class);
    }

    private C_KoureisyaTaiouKbn(String value) {
        super(value);
    }

    public static C_KoureisyaTaiouKbn valueOf(String value) {
        return valueOf(C_KoureisyaTaiouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KoureisyaTaiouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KoureisyaTaiouKbn.class, patternId, value);
    }
}
