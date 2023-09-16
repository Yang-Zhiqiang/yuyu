
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＤＳバッチ稼働環境区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DsBatchKadouKnkKbn</td><td colspan="3">ＤＳバッチ稼働環境区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUUJYOU_RAY1}</td><td>&quot;1&quot;</td><td>通常環境（ＲＡＹ１）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAI2MAINTE_RAY2}</td><td>&quot;2&quot;</td><td>第２メンテ環境（ＲＡＹ２）</td></tr>
 * </table>
 */
public class C_DsBatchKadouKnkKbn extends Classification<C_DsBatchKadouKnkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DsBatchKadouKnkKbn BLNK = new C_DsBatchKadouKnkKbn("0");

    public static final C_DsBatchKadouKnkKbn TUUJYOU_RAY1 = new C_DsBatchKadouKnkKbn("1");

    public static final C_DsBatchKadouKnkKbn DAI2MAINTE_RAY2 = new C_DsBatchKadouKnkKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TUUJYOU_RAY1, "TUUJYOU_RAY1", false);
        addPattern(PATTERN_DEFAULT, DAI2MAINTE_RAY2, "DAI2MAINTE_RAY2", false);


        lock(C_DsBatchKadouKnkKbn.class);
    }

    private C_DsBatchKadouKnkKbn(String value) {
        super(value);
    }

    public static C_DsBatchKadouKnkKbn valueOf(String value) {
        return valueOf(C_DsBatchKadouKnkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DsBatchKadouKnkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DsBatchKadouKnkKbn.class, patternId, value);
    }
}
