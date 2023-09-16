
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * イメージ連携区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_ImagerenkeiKbn</td><td colspan="3">イメージ連携区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">&nbsp;</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">○</td><td>{@link #YUYUSEIHO}</td><td>&quot;1&quot;</td><td>ゆうゆう生保ＩＷＦ</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_YOBIDASI YOBIDASI}<br />(呼出)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUYUSEIHO}</td><td>&quot;1&quot;</td><td>ゆうゆう生保ＩＷＦ</td></tr>
 * </table>
 */
public class C_ImagerenkeiKbn extends Classification<C_ImagerenkeiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_ImagerenkeiKbn BLNK = new C_ImagerenkeiKbn("0");

    public static final C_ImagerenkeiKbn YUYUSEIHO = new C_ImagerenkeiKbn("1");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_YOBIDASI = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", false);
        addPattern(PATTERN_DEFAULT, YUYUSEIHO, "YUYUSEIHO", true);


        addPattern(PATTERN_YOBIDASI, BLNK, "BLNK", true);
        addPattern(PATTERN_YOBIDASI, YUYUSEIHO, "YUYUSEIHO", false);


        lock(C_ImagerenkeiKbn.class);
    }

    private C_ImagerenkeiKbn(String value) {
        super(value);
    }

    public static C_ImagerenkeiKbn valueOf(String value) {
        return valueOf(C_ImagerenkeiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_ImagerenkeiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_ImagerenkeiKbn.class, patternId, value);
    }
}
