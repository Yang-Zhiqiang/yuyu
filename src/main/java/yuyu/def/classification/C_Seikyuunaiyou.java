
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 請求内容 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Seikyuunaiyou</td><td colspan="3">請求内容</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUUJYOU}</td><td>&quot;1&quot;</td><td>通常支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITJSHR}</td><td>&quot;2&quot;</td><td>一時金支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TK_IKKATU}</td><td>&quot;3&quot;</td><td>特約一括支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SB_ITIJI}</td><td>&quot;4&quot;</td><td>死亡一時金支払</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_SELECT SELECT}<br />(選択)</td><td align="center">○</td><td>{@link #TUUJYOU}</td><td>&quot;1&quot;</td><td>通常支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITJSHR}</td><td>&quot;2&quot;</td><td>一時金支払</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_TORIKOMI TORIKOMI}<br />(取込)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUUJYOU}</td><td>&quot;1&quot;</td><td>通常支払</td></tr>
 * </table>
 */
public class C_Seikyuunaiyou extends Classification<C_Seikyuunaiyou> {

    private static final long serialVersionUID = 1L;


    public static final C_Seikyuunaiyou BLNK = new C_Seikyuunaiyou("0");

    public static final C_Seikyuunaiyou TUUJYOU = new C_Seikyuunaiyou("1");

    public static final C_Seikyuunaiyou ITJSHR = new C_Seikyuunaiyou("2");

    public static final C_Seikyuunaiyou TK_IKKATU = new C_Seikyuunaiyou("3");

    public static final C_Seikyuunaiyou SB_ITIJI = new C_Seikyuunaiyou("4");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";

    public static final String PATTERN_TORIKOMI = "3";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TUUJYOU, "TUUJYOU", false);
        addPattern(PATTERN_DEFAULT, ITJSHR, "ITJSHR", false);
        addPattern(PATTERN_DEFAULT, TK_IKKATU, "TK_IKKATU", false);
        addPattern(PATTERN_DEFAULT, SB_ITIJI, "SB_ITIJI", false);


        addPattern(PATTERN_SELECT, TUUJYOU, "TUUJYOU", true);
        addPattern(PATTERN_SELECT, ITJSHR, "ITJSHR", false);


        addPattern(PATTERN_TORIKOMI, BLNK, "BLNK", true);
        addPattern(PATTERN_TORIKOMI, TUUJYOU, "TUUJYOU", false);


        lock(C_Seikyuunaiyou.class);
    }

    private C_Seikyuunaiyou(String value) {
        super(value);
    }

    public static C_Seikyuunaiyou valueOf(String value) {
        return valueOf(C_Seikyuunaiyou.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Seikyuunaiyou.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Seikyuunaiyou.class, patternId, value);
    }
}
