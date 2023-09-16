
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 契約保全試算種類区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KhSisanSyuruiKbn</td><td colspan="3">契約保全試算種類区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #JISSEKI}</td><td>&quot;0&quot;</td><td>実績</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JISSEKI_SISAN}</td><td>&quot;1&quot;</td><td>実績＋試算</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SISAN}</td><td>&quot;2&quot;</td><td>試算</td></tr>
 * </table>
 */
public class C_KhSisanSyuruiKbn extends Classification<C_KhSisanSyuruiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KhSisanSyuruiKbn JISSEKI = new C_KhSisanSyuruiKbn("0");

    public static final C_KhSisanSyuruiKbn JISSEKI_SISAN = new C_KhSisanSyuruiKbn("1");

    public static final C_KhSisanSyuruiKbn SISAN = new C_KhSisanSyuruiKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, JISSEKI, "JISSEKI", true);
        addPattern(PATTERN_DEFAULT, JISSEKI_SISAN, "JISSEKI_SISAN", false);
        addPattern(PATTERN_DEFAULT, SISAN, "SISAN", false);


        lock(C_KhSisanSyuruiKbn.class);
    }

    private C_KhSisanSyuruiKbn(String value) {
        super(value);
    }

    public static C_KhSisanSyuruiKbn valueOf(String value) {
        return valueOf(C_KhSisanSyuruiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KhSisanSyuruiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KhSisanSyuruiKbn.class, patternId, value);
    }
}
