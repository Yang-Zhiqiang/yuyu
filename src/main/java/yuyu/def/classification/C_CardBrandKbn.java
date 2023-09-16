
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * カードブランド区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_CardBrandKbn</td><td colspan="3">カードブランド区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="7">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;00&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #VISA}</td><td>&quot;10&quot;</td><td>ＶＩＳＡ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MASTER}</td><td>&quot;20&quot;</td><td>Ｍａｓｔｅｒ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JCB}</td><td>&quot;30&quot;</td><td>ＪＣＢ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AMEX}</td><td>&quot;40&quot;</td><td>ＡＭＥＸ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DINERS}</td><td>&quot;50&quot;</td><td>Ｄｉｎｅｒｓ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;99&quot;</td><td>その他</td></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_SELECT SELECT}<br />(選択用)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;00&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #VISA}</td><td>&quot;10&quot;</td><td>ＶＩＳＡ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MASTER}</td><td>&quot;20&quot;</td><td>Ｍａｓｔｅｒ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JCB}</td><td>&quot;30&quot;</td><td>ＪＣＢ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AMEX}</td><td>&quot;40&quot;</td><td>ＡＭＥＸ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DINERS}</td><td>&quot;50&quot;</td><td>Ｄｉｎｅｒｓ</td></tr>
 * </table>
 */
public class C_CardBrandKbn extends Classification<C_CardBrandKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_CardBrandKbn BLNK = new C_CardBrandKbn("00");

    public static final C_CardBrandKbn VISA = new C_CardBrandKbn("10");

    public static final C_CardBrandKbn MASTER = new C_CardBrandKbn("20");

    public static final C_CardBrandKbn JCB = new C_CardBrandKbn("30");

    public static final C_CardBrandKbn AMEX = new C_CardBrandKbn("40");

    public static final C_CardBrandKbn DINERS = new C_CardBrandKbn("50");

    public static final C_CardBrandKbn SONOTA = new C_CardBrandKbn("99");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, VISA, "VISA", false);
        addPattern(PATTERN_DEFAULT, MASTER, "MASTER", false);
        addPattern(PATTERN_DEFAULT, JCB, "JCB", false);
        addPattern(PATTERN_DEFAULT, AMEX, "AMEX", false);
        addPattern(PATTERN_DEFAULT, DINERS, "DINERS", false);
        addPattern(PATTERN_DEFAULT, SONOTA, "SONOTA", false);


        addPattern(PATTERN_SELECT, BLNK, "BLNK", true);
        addPattern(PATTERN_SELECT, VISA, "VISA", false);
        addPattern(PATTERN_SELECT, MASTER, "MASTER", false);
        addPattern(PATTERN_SELECT, JCB, "JCB", false);
        addPattern(PATTERN_SELECT, AMEX, "AMEX", false);
        addPattern(PATTERN_SELECT, DINERS, "DINERS", false);


        lock(C_CardBrandKbn.class);
    }

    private C_CardBrandKbn(String value) {
        super(value);
    }

    public static C_CardBrandKbn valueOf(String value) {
        return valueOf(C_CardBrandKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_CardBrandKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_CardBrandKbn.class, patternId, value);
    }
}
