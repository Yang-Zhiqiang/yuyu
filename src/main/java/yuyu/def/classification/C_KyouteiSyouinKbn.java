
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 協定消因区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KyouteiSyouinKbn</td><td colspan="3">協定消因区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #MIKYOUTEI}</td><td>&quot;0&quot;</td><td>未協定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYOUTEI}</td><td>&quot;1&quot;</td><td>協定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIJYO}</td><td>&quot;2&quot;</td><td>解除</td></tr>
 * </table>
 */
public class C_KyouteiSyouinKbn extends Classification<C_KyouteiSyouinKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KyouteiSyouinKbn MIKYOUTEI = new C_KyouteiSyouinKbn("0");

    public static final C_KyouteiSyouinKbn KYOUTEI = new C_KyouteiSyouinKbn("1");

    public static final C_KyouteiSyouinKbn KAIJYO = new C_KyouteiSyouinKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, MIKYOUTEI, "MIKYOUTEI", true);
        addPattern(PATTERN_DEFAULT, KYOUTEI, "KYOUTEI", false);
        addPattern(PATTERN_DEFAULT, KAIJYO, "KAIJYO", false);


        lock(C_KyouteiSyouinKbn.class);
    }

    private C_KyouteiSyouinKbn(String value) {
        super(value);
    }

    public static C_KyouteiSyouinKbn valueOf(String value) {
        return valueOf(C_KyouteiSyouinKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KyouteiSyouinKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KyouteiSyouinKbn.class, patternId, value);
    }
}
