
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 法定資料種類区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HtsiryosyuKbn</td><td colspan="3">法定資料種類区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITJKNSHRTYOUSYO}</td><td>&quot;310&quot;</td><td>生命保険契約等の一時金の支払調書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NNKNSHRTYOUSYO}</td><td>&quot;366&quot;</td><td>生命保険契約等の年金の支払調書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UKTRSHRTYOUSYO}</td><td>&quot;323&quot;</td><td>生命保険金・共済金受取人別支払調書</td></tr>
 * </table>
 */
public class C_HtsiryosyuKbn extends Classification<C_HtsiryosyuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HtsiryosyuKbn BLNK = new C_HtsiryosyuKbn("0");

    public static final C_HtsiryosyuKbn ITJKNSHRTYOUSYO = new C_HtsiryosyuKbn("310");

    public static final C_HtsiryosyuKbn NNKNSHRTYOUSYO = new C_HtsiryosyuKbn("366");

    public static final C_HtsiryosyuKbn UKTRSHRTYOUSYO = new C_HtsiryosyuKbn("323");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, ITJKNSHRTYOUSYO, "ITJKNSHRTYOUSYO", false);
        addPattern(PATTERN_DEFAULT, NNKNSHRTYOUSYO, "NNKNSHRTYOUSYO", false);
        addPattern(PATTERN_DEFAULT, UKTRSHRTYOUSYO, "UKTRSHRTYOUSYO", false);


        lock(C_HtsiryosyuKbn.class);
    }

    private C_HtsiryosyuKbn(String value) {
        super(value);
    }

    public static C_HtsiryosyuKbn valueOf(String value) {
        return valueOf(C_HtsiryosyuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HtsiryosyuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HtsiryosyuKbn.class, patternId, value);
    }
}
