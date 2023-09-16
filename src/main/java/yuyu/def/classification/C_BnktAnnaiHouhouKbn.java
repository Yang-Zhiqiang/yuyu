
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 分割案内方法区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_BnktAnnaiHouhouKbn</td><td colspan="3">分割案内方法区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #IKKATU}</td><td>&quot;00&quot;</td><td>一括払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BUNKATU1P}</td><td>&quot;01&quot;</td><td>１Ｐ分割払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BUNKATU2P}</td><td>&quot;02&quot;</td><td>２Ｐ分割払</td></tr>
 * </table>
 */
public class C_BnktAnnaiHouhouKbn extends Classification<C_BnktAnnaiHouhouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_BnktAnnaiHouhouKbn IKKATU = new C_BnktAnnaiHouhouKbn("00");

    public static final C_BnktAnnaiHouhouKbn BUNKATU1P = new C_BnktAnnaiHouhouKbn("01");

    public static final C_BnktAnnaiHouhouKbn BUNKATU2P = new C_BnktAnnaiHouhouKbn("02");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, IKKATU, "IKKATU", true);
        addPattern(PATTERN_DEFAULT, BUNKATU1P, "BUNKATU1P", false);
        addPattern(PATTERN_DEFAULT, BUNKATU2P, "BUNKATU2P", false);


        lock(C_BnktAnnaiHouhouKbn.class);
    }

    private C_BnktAnnaiHouhouKbn(String value) {
        super(value);
    }

    public static C_BnktAnnaiHouhouKbn valueOf(String value) {
        return valueOf(C_BnktAnnaiHouhouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_BnktAnnaiHouhouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_BnktAnnaiHouhouKbn.class, patternId, value);
    }
}
