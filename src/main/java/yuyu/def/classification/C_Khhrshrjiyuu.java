
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 契約保全返戻金支払事由 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Khhrshrjiyuu</td><td colspan="3">契約保全返戻金支払事由</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUUJYOU}</td><td>&quot;1&quot;</td><td>通常支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKSB}</td><td>&quot;2&quot;</td><td>契約者死亡による支払</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_SELECT SELECT}<br />(画面用)</td><td align="center">○</td><td>{@link #TUUJYOU}</td><td>&quot;1&quot;</td><td>通常支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKSB}</td><td>&quot;2&quot;</td><td>契約者死亡による支払</td></tr>
 * </table>
 */
public class C_Khhrshrjiyuu extends Classification<C_Khhrshrjiyuu> {

    private static final long serialVersionUID = 1L;


    public static final C_Khhrshrjiyuu BLNK = new C_Khhrshrjiyuu("0");

    public static final C_Khhrshrjiyuu TUUJYOU = new C_Khhrshrjiyuu("1");

    public static final C_Khhrshrjiyuu KYKSB = new C_Khhrshrjiyuu("2");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TUUJYOU, "TUUJYOU", false);
        addPattern(PATTERN_DEFAULT, KYKSB, "KYKSB", false);


        addPattern(PATTERN_SELECT, TUUJYOU, "TUUJYOU", true);
        addPattern(PATTERN_SELECT, KYKSB, "KYKSB", false);


        lock(C_Khhrshrjiyuu.class);
    }

    private C_Khhrshrjiyuu(String value) {
        super(value);
    }

    public static C_Khhrshrjiyuu valueOf(String value) {
        return valueOf(C_Khhrshrjiyuu.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Khhrshrjiyuu.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Khhrshrjiyuu.class, patternId, value);
    }
}
