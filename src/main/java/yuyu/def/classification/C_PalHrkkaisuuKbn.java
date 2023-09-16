
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＰＡＬ払込回数区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_PalHrkkaisuuKbn</td><td colspan="3">ＰＡＬ払込回数区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITIJI}</td><td>&quot;1&quot;</td><td>一時払い</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUKI}</td><td>&quot;2&quot;</td><td>月払</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_SELECT SELECT}<br />(選択)</td><td align="center">○</td><td>{@link #ITIJI}</td><td>&quot;1&quot;</td><td>０：一時払い</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUKI}</td><td>&quot;2&quot;</td><td>３：月払</td></tr>
 * </table>
 */
public class C_PalHrkkaisuuKbn extends Classification<C_PalHrkkaisuuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_PalHrkkaisuuKbn BLNK = new C_PalHrkkaisuuKbn("0");

    public static final C_PalHrkkaisuuKbn ITIJI = new C_PalHrkkaisuuKbn("1");

    public static final C_PalHrkkaisuuKbn TUKI = new C_PalHrkkaisuuKbn("2");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, ITIJI, "ITIJI", false);
        addPattern(PATTERN_DEFAULT, TUKI, "TUKI", false);


        addPattern(PATTERN_SELECT, ITIJI, "ITIJI", true);
        addPattern(PATTERN_SELECT, TUKI, "TUKI", false);


        lock(C_PalHrkkaisuuKbn.class);
    }

    private C_PalHrkkaisuuKbn(String value) {
        super(value);
    }

    public static C_PalHrkkaisuuKbn valueOf(String value) {
        return valueOf(C_PalHrkkaisuuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_PalHrkkaisuuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_PalHrkkaisuuKbn.class, patternId, value);
    }
}
