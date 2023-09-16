
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 既払込Ｐ精算内容区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KiharaiPseisanNaiyouKbn</td><td colspan="3">既払込Ｐ精算内容区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEISANP}</td><td>&quot;1&quot;</td><td>精算保険料</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENKANKIN}</td><td>&quot;2&quot;</td><td>返還金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUITYOUKIN}</td><td>&quot;3&quot;</td><td>追徴金</td></tr>
 * </table>
 */
public class C_KiharaiPseisanNaiyouKbn extends Classification<C_KiharaiPseisanNaiyouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KiharaiPseisanNaiyouKbn BLNK = new C_KiharaiPseisanNaiyouKbn("0");

    public static final C_KiharaiPseisanNaiyouKbn SEISANP = new C_KiharaiPseisanNaiyouKbn("1");

    public static final C_KiharaiPseisanNaiyouKbn HENKANKIN = new C_KiharaiPseisanNaiyouKbn("2");

    public static final C_KiharaiPseisanNaiyouKbn TUITYOUKIN = new C_KiharaiPseisanNaiyouKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SEISANP, "SEISANP", false);
        addPattern(PATTERN_DEFAULT, HENKANKIN, "HENKANKIN", false);
        addPattern(PATTERN_DEFAULT, TUITYOUKIN, "TUITYOUKIN", false);


        lock(C_KiharaiPseisanNaiyouKbn.class);
    }

    private C_KiharaiPseisanNaiyouKbn(String value) {
        super(value);
    }

    public static C_KiharaiPseisanNaiyouKbn valueOf(String value) {
        return valueOf(C_KiharaiPseisanNaiyouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KiharaiPseisanNaiyouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KiharaiPseisanNaiyouKbn.class, patternId, value);
    }
}
