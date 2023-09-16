
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 発送区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HassouKbn</td><td colspan="3">発送区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TYOKUSOU}</td><td>&quot;1&quot;</td><td>直送</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HONSYAKAISOU}</td><td>&quot;2&quot;</td><td>本社回送</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_SELECT SELECT}<br />(画面用)</td><td align="center">○</td><td>{@link #TYOKUSOU}</td><td>&quot;1&quot;</td><td>直送</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HONSYAKAISOU}</td><td>&quot;2&quot;</td><td>本社回送</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_MEIGIHENKOU MEIGIHENKOU}<br />(名義変更用)</td><td align="center">&nbsp;</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">○</td><td>{@link #TYOKUSOU}</td><td>&quot;1&quot;</td><td>直送</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HONSYAKAISOU}</td><td>&quot;2&quot;</td><td>本社回送</td></tr>
 * </table>
 */
public class C_HassouKbn extends Classification<C_HassouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HassouKbn BLNK = new C_HassouKbn("0");

    public static final C_HassouKbn TYOKUSOU = new C_HassouKbn("1");

    public static final C_HassouKbn HONSYAKAISOU = new C_HassouKbn("2");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";

    public static final String PATTERN_MEIGIHENKOU = "3";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TYOKUSOU, "TYOKUSOU", false);
        addPattern(PATTERN_DEFAULT, HONSYAKAISOU, "HONSYAKAISOU", false);


        addPattern(PATTERN_SELECT, TYOKUSOU, "TYOKUSOU", true);
        addPattern(PATTERN_SELECT, HONSYAKAISOU, "HONSYAKAISOU", false);


        addPattern(PATTERN_MEIGIHENKOU, BLNK, "BLNK", false);
        addPattern(PATTERN_MEIGIHENKOU, TYOKUSOU, "TYOKUSOU", true);
        addPattern(PATTERN_MEIGIHENKOU, HONSYAKAISOU, "HONSYAKAISOU", false);


        lock(C_HassouKbn.class);
    }

    private C_HassouKbn(String value) {
        super(value);
    }

    public static C_HassouKbn valueOf(String value) {
        return valueOf(C_HassouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HassouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HassouKbn.class, patternId, value);
    }
}
