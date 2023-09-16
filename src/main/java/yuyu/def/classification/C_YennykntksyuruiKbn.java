
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 円入金特約種類区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_YennykntksyuruiKbn</td><td colspan="3">円入金特約種類区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PYENHRKM}</td><td>&quot;1&quot;</td><td>保険料円貨払込特約（一時払い）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PYENHRKM_GKSITEI}</td><td>&quot;2&quot;</td><td>保険料円貨払込特約（円貨払込額指定型）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PYENHRKM_GKHENDOU}</td><td>&quot;3&quot;</td><td>保険料円貨払込特約（円貨払込額変動型）</td></tr>
 * </table>
 */
public class C_YennykntksyuruiKbn extends Classification<C_YennykntksyuruiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_YennykntksyuruiKbn BLNK = new C_YennykntksyuruiKbn("0");

    public static final C_YennykntksyuruiKbn PYENHRKM = new C_YennykntksyuruiKbn("1");

    public static final C_YennykntksyuruiKbn PYENHRKM_GKSITEI = new C_YennykntksyuruiKbn("2");

    public static final C_YennykntksyuruiKbn PYENHRKM_GKHENDOU = new C_YennykntksyuruiKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, PYENHRKM, "PYENHRKM", false);
        addPattern(PATTERN_DEFAULT, PYENHRKM_GKSITEI, "PYENHRKM_GKSITEI", false);
        addPattern(PATTERN_DEFAULT, PYENHRKM_GKHENDOU, "PYENHRKM_GKHENDOU", false);


        lock(C_YennykntksyuruiKbn.class);
    }

    private C_YennykntksyuruiKbn(String value) {
        super(value);
    }

    public static C_YennykntksyuruiKbn valueOf(String value) {
        return valueOf(C_YennykntksyuruiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_YennykntksyuruiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_YennykntksyuruiKbn.class, patternId, value);
    }
}
