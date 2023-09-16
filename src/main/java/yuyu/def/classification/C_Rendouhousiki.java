
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 連動方式 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Rendouhousiki</td><td colspan="3">連動方式</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZENKEN}</td><td>&quot;1&quot;</td><td>全件</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SABUNHENKOU}</td><td>&quot;2&quot;</td><td>差分（追加変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUIKA}</td><td>&quot;3&quot;</td><td>追加分</td></tr>
 * </table>
 */
public class C_Rendouhousiki extends Classification<C_Rendouhousiki> {

    private static final long serialVersionUID = 1L;


    public static final C_Rendouhousiki BLNK = new C_Rendouhousiki("0");

    public static final C_Rendouhousiki ZENKEN = new C_Rendouhousiki("1");

    public static final C_Rendouhousiki SABUNHENKOU = new C_Rendouhousiki("2");

    public static final C_Rendouhousiki TUIKA = new C_Rendouhousiki("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, ZENKEN, "ZENKEN", false);
        addPattern(PATTERN_DEFAULT, SABUNHENKOU, "SABUNHENKOU", false);
        addPattern(PATTERN_DEFAULT, TUIKA, "TUIKA", false);


        lock(C_Rendouhousiki.class);
    }

    private C_Rendouhousiki(String value) {
        super(value);
    }

    public static C_Rendouhousiki valueOf(String value) {
        return valueOf(C_Rendouhousiki.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Rendouhousiki.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Rendouhousiki.class, patternId, value);
    }
}
