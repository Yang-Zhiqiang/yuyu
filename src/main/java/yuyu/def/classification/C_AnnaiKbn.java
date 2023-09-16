
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 案内区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_AnnaiKbn</td><td colspan="3">案内区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEIJYOU}</td><td>&quot;1&quot;</td><td>正常案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAI}</td><td>&quot;2&quot;</td><td>再案内</td></tr>
 * </table>
 */
public class C_AnnaiKbn extends Classification<C_AnnaiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_AnnaiKbn BLNK = new C_AnnaiKbn("0");

    public static final C_AnnaiKbn SEIJYOU = new C_AnnaiKbn("1");

    public static final C_AnnaiKbn SAI = new C_AnnaiKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SEIJYOU, "SEIJYOU", false);
        addPattern(PATTERN_DEFAULT, SAI, "SAI", false);


        lock(C_AnnaiKbn.class);
    }

    private C_AnnaiKbn(String value) {
        super(value);
    }

    public static C_AnnaiKbn valueOf(String value) {
        return valueOf(C_AnnaiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_AnnaiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_AnnaiKbn.class, patternId, value);
    }
}
