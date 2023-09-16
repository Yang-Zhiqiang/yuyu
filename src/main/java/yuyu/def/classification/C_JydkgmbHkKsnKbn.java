
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 重度介護前払保険金計算区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_JydkgmbHkKsnKbn</td><td colspan="3">重度介護前払保険金計算区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #KIJUNBISITEI}</td><td>&quot;1&quot;</td><td>基準日指定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NENREISITEI}</td><td>&quot;2&quot;</td><td>年齢指定</td></tr>
 * </table>
 */
public class C_JydkgmbHkKsnKbn extends Classification<C_JydkgmbHkKsnKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_JydkgmbHkKsnKbn KIJUNBISITEI = new C_JydkgmbHkKsnKbn("1");

    public static final C_JydkgmbHkKsnKbn NENREISITEI = new C_JydkgmbHkKsnKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, KIJUNBISITEI, "KIJUNBISITEI", true);
        addPattern(PATTERN_DEFAULT, NENREISITEI, "NENREISITEI", false);


        lock(C_JydkgmbHkKsnKbn.class);
    }

    private C_JydkgmbHkKsnKbn(String value) {
        super(value);
    }

    public static C_JydkgmbHkKsnKbn valueOf(String value) {
        return valueOf(C_JydkgmbHkKsnKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_JydkgmbHkKsnKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_JydkgmbHkKsnKbn.class, patternId, value);
    }
}
