
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 年金受取方法 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Nkukthou</td><td colspan="3">年金受取方法</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIDOU}</td><td>&quot;1&quot;</td><td>自動支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOUSIDE}</td><td>&quot;2&quot;</td><td>申出支払</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_NOBLNK NOBLNK}<br />(ブランクなし)</td><td align="center">○</td><td>{@link #JIDOU}</td><td>&quot;1&quot;</td><td>自動支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOUSIDE}</td><td>&quot;2&quot;</td><td>申出支払</td></tr>
 *  <tr><td rowspan="1">{@link #PATTERN_TORIKOMI TORIKOMI}<br />(取込)</td><td align="center">○</td><td>{@link #JIDOU}</td><td>&quot;1&quot;</td><td>自動支払</td></tr>
 * </table>
 */
public class C_Nkukthou extends Classification<C_Nkukthou> {

    private static final long serialVersionUID = 1L;


    public static final C_Nkukthou BLNK = new C_Nkukthou("0");

    public static final C_Nkukthou JIDOU = new C_Nkukthou("1");

    public static final C_Nkukthou MOUSIDE = new C_Nkukthou("2");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_NOBLNK = "2";

    public static final String PATTERN_TORIKOMI = "3";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, JIDOU, "JIDOU", false);
        addPattern(PATTERN_DEFAULT, MOUSIDE, "MOUSIDE", false);


        addPattern(PATTERN_NOBLNK, JIDOU, "JIDOU", true);
        addPattern(PATTERN_NOBLNK, MOUSIDE, "MOUSIDE", false);


        addPattern(PATTERN_TORIKOMI, JIDOU, "JIDOU", true);


        lock(C_Nkukthou.class);
    }

    private C_Nkukthou(String value) {
        super(value);
    }

    public static C_Nkukthou valueOf(String value) {
        return valueOf(C_Nkukthou.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Nkukthou.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Nkukthou.class, patternId, value);
    }
}
