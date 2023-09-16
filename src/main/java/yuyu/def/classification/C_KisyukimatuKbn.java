
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 期首期末区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KisyukimatuKbn</td><td colspan="3">期首期末区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #KISYU}</td><td>&quot;1&quot;</td><td>期首</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KIMATU}</td><td>&quot;2&quot;</td><td>期末</td></tr>
 * </table>
 */
public class C_KisyukimatuKbn extends Classification<C_KisyukimatuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KisyukimatuKbn KISYU = new C_KisyukimatuKbn("1");

    public static final C_KisyukimatuKbn KIMATU = new C_KisyukimatuKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, KISYU, "KISYU", true);
        addPattern(PATTERN_DEFAULT, KIMATU, "KIMATU", false);


        lock(C_KisyukimatuKbn.class);
    }

    private C_KisyukimatuKbn(String value) {
        super(value);
    }

    public static C_KisyukimatuKbn valueOf(String value) {
        return valueOf(C_KisyukimatuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KisyukimatuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KisyukimatuKbn.class, patternId, value);
    }
}
