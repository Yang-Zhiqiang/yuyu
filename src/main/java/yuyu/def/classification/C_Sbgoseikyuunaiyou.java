
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 死亡後請求内容 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Sbgoseikyuunaiyou</td><td colspan="3">死亡後請求内容</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUURYOU}</td><td>&quot;1&quot;</td><td>年金終了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIZOKUJIDOU}</td><td>&quot;2&quot;</td><td>継続自動支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIZOKUMOUSIDE}</td><td>&quot;3&quot;</td><td>継続申出支払</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_KZKKA KZKKA}<br />(継続可)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUURYOU}</td><td>&quot;1&quot;</td><td>年金終了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIZOKUJIDOU}</td><td>&quot;2&quot;</td><td>継続自動支払</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_KZKHUMON KZKHUMON}<br />(継続不問)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIZOKUJIDOU}</td><td>&quot;2&quot;</td><td>継続自動支払</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_KZKHUKA KZKHUKA}<br />(継続不可)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUURYOU}</td><td>&quot;1&quot;</td><td>年金終了</td></tr>
 * </table>
 */
public class C_Sbgoseikyuunaiyou extends Classification<C_Sbgoseikyuunaiyou> {

    private static final long serialVersionUID = 1L;


    public static final C_Sbgoseikyuunaiyou BLNK = new C_Sbgoseikyuunaiyou("0");

    public static final C_Sbgoseikyuunaiyou SYUURYOU = new C_Sbgoseikyuunaiyou("1");

    public static final C_Sbgoseikyuunaiyou KEIZOKUJIDOU = new C_Sbgoseikyuunaiyou("2");

    public static final C_Sbgoseikyuunaiyou KEIZOKUMOUSIDE = new C_Sbgoseikyuunaiyou("3");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_KZKKA = "2";

    public static final String PATTERN_KZKHUMON = "3";

    public static final String PATTERN_KZKHUKA = "4";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SYUURYOU, "SYUURYOU", false);
        addPattern(PATTERN_DEFAULT, KEIZOKUJIDOU, "KEIZOKUJIDOU", false);
        addPattern(PATTERN_DEFAULT, KEIZOKUMOUSIDE, "KEIZOKUMOUSIDE", false);


        addPattern(PATTERN_KZKKA, BLNK, "BLNK", true);
        addPattern(PATTERN_KZKKA, SYUURYOU, "SYUURYOU", false);
        addPattern(PATTERN_KZKKA, KEIZOKUJIDOU, "KEIZOKUJIDOU", false);


        addPattern(PATTERN_KZKHUMON, BLNK, "BLNK", true);
        addPattern(PATTERN_KZKHUMON, KEIZOKUJIDOU, "KEIZOKUJIDOU", false);


        addPattern(PATTERN_KZKHUKA, BLNK, "BLNK", true);
        addPattern(PATTERN_KZKHUKA, SYUURYOU, "SYUURYOU", false);


        lock(C_Sbgoseikyuunaiyou.class);
    }

    private C_Sbgoseikyuunaiyou(String value) {
        super(value);
    }

    public static C_Sbgoseikyuunaiyou valueOf(String value) {
        return valueOf(C_Sbgoseikyuunaiyou.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Sbgoseikyuunaiyou.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Sbgoseikyuunaiyou.class, patternId, value);
    }
}
