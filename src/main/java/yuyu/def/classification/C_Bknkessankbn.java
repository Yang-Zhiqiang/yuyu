
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 備金決算区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Bknkessankbn</td><td colspan="3">備金決算区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KESSAN}</td><td>&quot;1&quot;</td><td>決算</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHNK}</td><td>&quot;2&quot;</td><td>四半期</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HNK}</td><td>&quot;3&quot;</td><td>半期</td></tr>
 * </table>
 */
public class C_Bknkessankbn extends Classification<C_Bknkessankbn> {

    private static final long serialVersionUID = 1L;


    public static final C_Bknkessankbn BLNK = new C_Bknkessankbn("0");

    public static final C_Bknkessankbn KESSAN = new C_Bknkessankbn("1");

    public static final C_Bknkessankbn SHNK = new C_Bknkessankbn("2");

    public static final C_Bknkessankbn HNK = new C_Bknkessankbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KESSAN, "KESSAN", false);
        addPattern(PATTERN_DEFAULT, SHNK, "SHNK", false);
        addPattern(PATTERN_DEFAULT, HNK, "HNK", false);


        lock(C_Bknkessankbn.class);
    }

    private C_Bknkessankbn(String value) {
        super(value);
    }

    public static C_Bknkessankbn valueOf(String value) {
        return valueOf(C_Bknkessankbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Bknkessankbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Bknkessankbn.class, patternId, value);
    }
}
