
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 組織種別 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Sosikisyubetu</td><td colspan="3">組織種別</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HONSYA}</td><td>&quot;1&quot;</td><td>本社</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SISYA}</td><td>&quot;2&quot;</td><td>支社</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAIRITEN}</td><td>&quot;3&quot;</td><td>代理店</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_SELECT SELECT}<br />(組織登録用)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HONSYA}</td><td>&quot;1&quot;</td><td>本社</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAIRITEN}</td><td>&quot;3&quot;</td><td>代理店</td></tr>
 * </table>
 */
public class C_Sosikisyubetu extends Classification<C_Sosikisyubetu> {

    private static final long serialVersionUID = 1L;


    public static final C_Sosikisyubetu BLNK = new C_Sosikisyubetu("0");

    public static final C_Sosikisyubetu HONSYA = new C_Sosikisyubetu("1");

    public static final C_Sosikisyubetu SISYA = new C_Sosikisyubetu("2");

    public static final C_Sosikisyubetu DAIRITEN = new C_Sosikisyubetu("3");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HONSYA, "HONSYA", false);
        addPattern(PATTERN_DEFAULT, SISYA, "SISYA", false);
        addPattern(PATTERN_DEFAULT, DAIRITEN, "DAIRITEN", false);


        addPattern(PATTERN_SELECT, BLNK, "BLNK", true);
        addPattern(PATTERN_SELECT, HONSYA, "HONSYA", false);
        addPattern(PATTERN_SELECT, DAIRITEN, "DAIRITEN", false);


        lock(C_Sosikisyubetu.class);
    }

    private C_Sosikisyubetu(String value) {
        super(value);
    }

    public static C_Sosikisyubetu valueOf(String value) {
        return valueOf(C_Sosikisyubetu.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Sosikisyubetu.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Sosikisyubetu.class, patternId, value);
    }
}
