
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 書類受付場所 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SyoruiUkebasyo</td><td colspan="3">書類受付場所</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HONSYA}</td><td>&quot;1&quot;</td><td>本社</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HANBAIGAISYA}</td><td>&quot;2&quot;</td><td>販売会社</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #WS}</td><td>&quot;3&quot;</td><td>ＷＳ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OTHER}</td><td>&quot;4&quot;</td><td>その他</td></tr>
 *  <tr><td rowspan="1">{@link #PATTERN_SELECT SELECT}<br />(画面用)</td><td align="center">○</td><td>{@link #HONSYA}</td><td>&quot;1&quot;</td><td>本社</td></tr>
 * </table>
 */
public class C_SyoruiUkebasyo extends Classification<C_SyoruiUkebasyo> {

    private static final long serialVersionUID = 1L;


    public static final C_SyoruiUkebasyo BLNK = new C_SyoruiUkebasyo("0");

    public static final C_SyoruiUkebasyo HONSYA = new C_SyoruiUkebasyo("1");

    public static final C_SyoruiUkebasyo HANBAIGAISYA = new C_SyoruiUkebasyo("2");

    public static final C_SyoruiUkebasyo WS = new C_SyoruiUkebasyo("3");

    public static final C_SyoruiUkebasyo OTHER = new C_SyoruiUkebasyo("4");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HONSYA, "HONSYA", false);
        addPattern(PATTERN_DEFAULT, HANBAIGAISYA, "HANBAIGAISYA", false);
        addPattern(PATTERN_DEFAULT, WS, "WS", false);
        addPattern(PATTERN_DEFAULT, OTHER, "OTHER", false);


        addPattern(PATTERN_SELECT, HONSYA, "HONSYA", true);


        lock(C_SyoruiUkebasyo.class);
    }

    private C_SyoruiUkebasyo(String value) {
        super(value);
    }

    public static C_SyoruiUkebasyo valueOf(String value) {
        return valueOf(C_SyoruiUkebasyo.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SyoruiUkebasyo.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SyoruiUkebasyo.class, patternId, value);
    }
}
