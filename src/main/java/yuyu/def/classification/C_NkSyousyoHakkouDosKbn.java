
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 年金証書発行ＤＯＳ区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_NkSyousyoHakkouDosKbn</td><td colspan="3">年金証書発行ＤＯＳ区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="12">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PR01}</td><td>&quot;1&quot;</td><td>直送・２５ｇ超（ＰＲ０１）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PR02}</td><td>&quot;2&quot;</td><td>直送・２５ｇ超（ＰＲ０２）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PR03}</td><td>&quot;3&quot;</td><td>直送・２５ｇ以下（ＰＲ０３）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PR04}</td><td>&quot;4&quot;</td><td>直送・２５ｇ以下（ＰＲ０４）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PR05}</td><td>&quot;5&quot;</td><td>直送・２５ｇ以下（ＰＲ０５）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PR06}</td><td>&quot;6&quot;</td><td>本社回送（ＰＲ０６）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PR07}</td><td>&quot;7&quot;</td><td>窓販直送・２５ｇ超（ＰＲ０７）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PR08}</td><td>&quot;8&quot;</td><td>窓販直送・２５ｇ超（ＰＲ０８）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PR09}</td><td>&quot;9&quot;</td><td>窓販直送・２５ｇ以下（ＰＲ０９）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PR10}</td><td>&quot;10&quot;</td><td>窓販直送・２５ｇ以下（ＰＲ１０）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PR11}</td><td>&quot;11&quot;</td><td>窓販本社回送（ＰＲ１１）</td></tr>
 * </table>
 */
public class C_NkSyousyoHakkouDosKbn extends Classification<C_NkSyousyoHakkouDosKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_NkSyousyoHakkouDosKbn BLNK = new C_NkSyousyoHakkouDosKbn("0");

    public static final C_NkSyousyoHakkouDosKbn PR01 = new C_NkSyousyoHakkouDosKbn("1");

    public static final C_NkSyousyoHakkouDosKbn PR02 = new C_NkSyousyoHakkouDosKbn("2");

    public static final C_NkSyousyoHakkouDosKbn PR03 = new C_NkSyousyoHakkouDosKbn("3");

    public static final C_NkSyousyoHakkouDosKbn PR04 = new C_NkSyousyoHakkouDosKbn("4");

    public static final C_NkSyousyoHakkouDosKbn PR05 = new C_NkSyousyoHakkouDosKbn("5");

    public static final C_NkSyousyoHakkouDosKbn PR06 = new C_NkSyousyoHakkouDosKbn("6");

    public static final C_NkSyousyoHakkouDosKbn PR07 = new C_NkSyousyoHakkouDosKbn("7");

    public static final C_NkSyousyoHakkouDosKbn PR08 = new C_NkSyousyoHakkouDosKbn("8");

    public static final C_NkSyousyoHakkouDosKbn PR09 = new C_NkSyousyoHakkouDosKbn("9");

    public static final C_NkSyousyoHakkouDosKbn PR10 = new C_NkSyousyoHakkouDosKbn("10");

    public static final C_NkSyousyoHakkouDosKbn PR11 = new C_NkSyousyoHakkouDosKbn("11");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, PR01, "PR01", false);
        addPattern(PATTERN_DEFAULT, PR02, "PR02", false);
        addPattern(PATTERN_DEFAULT, PR03, "PR03", false);
        addPattern(PATTERN_DEFAULT, PR04, "PR04", false);
        addPattern(PATTERN_DEFAULT, PR05, "PR05", false);
        addPattern(PATTERN_DEFAULT, PR06, "PR06", false);
        addPattern(PATTERN_DEFAULT, PR07, "PR07", false);
        addPattern(PATTERN_DEFAULT, PR08, "PR08", false);
        addPattern(PATTERN_DEFAULT, PR09, "PR09", false);
        addPattern(PATTERN_DEFAULT, PR10, "PR10", false);
        addPattern(PATTERN_DEFAULT, PR11, "PR11", false);


        lock(C_NkSyousyoHakkouDosKbn.class);
    }

    private C_NkSyousyoHakkouDosKbn(String value) {
        super(value);
    }

    public static C_NkSyousyoHakkouDosKbn valueOf(String value) {
        return valueOf(C_NkSyousyoHakkouDosKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_NkSyousyoHakkouDosKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_NkSyousyoHakkouDosKbn.class, patternId, value);
    }
}
