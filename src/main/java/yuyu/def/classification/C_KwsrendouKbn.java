
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 為替レート連動区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KwsrendouKbn</td><td colspan="3">為替レート連動区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUJIKAWASERATE1}</td><td>&quot;1&quot;</td><td>公示為替レート１</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUJIKAWASERATE2}</td><td>&quot;2&quot;</td><td>公示為替レート２</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PM17JIKAWASERATE}</td><td>&quot;3&quot;</td><td>１７時為替レート</td></tr>
 * </table>
 */
public class C_KwsrendouKbn extends Classification<C_KwsrendouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KwsrendouKbn BLNK = new C_KwsrendouKbn("0");

    public static final C_KwsrendouKbn KOUJIKAWASERATE1 = new C_KwsrendouKbn("1");

    public static final C_KwsrendouKbn KOUJIKAWASERATE2 = new C_KwsrendouKbn("2");

    public static final C_KwsrendouKbn PM17JIKAWASERATE = new C_KwsrendouKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KOUJIKAWASERATE1, "KOUJIKAWASERATE1", false);
        addPattern(PATTERN_DEFAULT, KOUJIKAWASERATE2, "KOUJIKAWASERATE2", false);
        addPattern(PATTERN_DEFAULT, PM17JIKAWASERATE, "PM17JIKAWASERATE", false);


        lock(C_KwsrendouKbn.class);
    }

    private C_KwsrendouKbn(String value) {
        super(value);
    }

    public static C_KwsrendouKbn valueOf(String value) {
        return valueOf(C_KwsrendouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KwsrendouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KwsrendouKbn.class, patternId, value);
    }
}
