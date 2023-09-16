
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 移管処理区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_IkansyoriKbn</td><td colspan="3">移管処理区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUKENTANI}</td><td>&quot;1&quot;</td><td>証券単位</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AGTANI}</td><td>&quot;2&quot;</td><td>代理店単位</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BOSYUUNINTANI}</td><td>&quot;3&quot;</td><td>募集人単位</td></tr>
 * </table>
 */
public class C_IkansyoriKbn extends Classification<C_IkansyoriKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_IkansyoriKbn BLNK = new C_IkansyoriKbn("0");

    public static final C_IkansyoriKbn SYOUKENTANI = new C_IkansyoriKbn("1");

    public static final C_IkansyoriKbn AGTANI = new C_IkansyoriKbn("2");

    public static final C_IkansyoriKbn BOSYUUNINTANI = new C_IkansyoriKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SYOUKENTANI, "SYOUKENTANI", false);
        addPattern(PATTERN_DEFAULT, AGTANI, "AGTANI", false);
        addPattern(PATTERN_DEFAULT, BOSYUUNINTANI, "BOSYUUNINTANI", false);


        lock(C_IkansyoriKbn.class);
    }

    private C_IkansyoriKbn(String value) {
        super(value);
    }

    public static C_IkansyoriKbn valueOf(String value) {
        return valueOf(C_IkansyoriKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_IkansyoriKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_IkansyoriKbn.class, patternId, value);
    }
}
