
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 新設経緯区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SinsetukeiiKbn</td><td colspan="3">新設経緯区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ALLKEISYOU}</td><td>&quot;1&quot;</td><td>全部継承</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITIBUKEISYOU}</td><td>&quot;2&quot;</td><td>一部継承</td></tr>
 * </table>
 */
public class C_SinsetukeiiKbn extends Classification<C_SinsetukeiiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SinsetukeiiKbn BLNK = new C_SinsetukeiiKbn("0");

    public static final C_SinsetukeiiKbn ALLKEISYOU = new C_SinsetukeiiKbn("1");

    public static final C_SinsetukeiiKbn ITIBUKEISYOU = new C_SinsetukeiiKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, ALLKEISYOU, "ALLKEISYOU", false);
        addPattern(PATTERN_DEFAULT, ITIBUKEISYOU, "ITIBUKEISYOU", false);


        lock(C_SinsetukeiiKbn.class);
    }

    private C_SinsetukeiiKbn(String value) {
        super(value);
    }

    public static C_SinsetukeiiKbn valueOf(String value) {
        return valueOf(C_SinsetukeiiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SinsetukeiiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SinsetukeiiKbn.class, patternId, value);
    }
}
