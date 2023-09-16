
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 決算調整区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KessantyouseiKbn</td><td colspan="3">決算調整区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OIKOMITAISYOU}</td><td>&quot;1&quot;</td><td>追い込み対象契約</td></tr>
 * </table>
 */
public class C_KessantyouseiKbn extends Classification<C_KessantyouseiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KessantyouseiKbn BLNK = new C_KessantyouseiKbn("0");

    public static final C_KessantyouseiKbn OIKOMITAISYOU = new C_KessantyouseiKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, OIKOMITAISYOU, "OIKOMITAISYOU", false);


        lock(C_KessantyouseiKbn.class);
    }

    private C_KessantyouseiKbn(String value) {
        super(value);
    }

    public static C_KessantyouseiKbn valueOf(String value) {
        return valueOf(C_KessantyouseiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KessantyouseiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KessantyouseiKbn.class, patternId, value);
    }
}
