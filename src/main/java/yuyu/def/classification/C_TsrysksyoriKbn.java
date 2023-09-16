
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 手数料集計処理区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TsrysksyoriKbn</td><td colspan="3">手数料集計処理区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #KARIJIME}</td><td>&quot;0&quot;</td><td>仮締め</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAKUTEI}</td><td>&quot;1&quot;</td><td>確定</td></tr>
 * </table>
 */
public class C_TsrysksyoriKbn extends Classification<C_TsrysksyoriKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TsrysksyoriKbn KARIJIME = new C_TsrysksyoriKbn("0");

    public static final C_TsrysksyoriKbn KAKUTEI = new C_TsrysksyoriKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, KARIJIME, "KARIJIME", true);
        addPattern(PATTERN_DEFAULT, KAKUTEI, "KAKUTEI", false);


        lock(C_TsrysksyoriKbn.class);
    }

    private C_TsrysksyoriKbn(String value) {
        super(value);
    }

    public static C_TsrysksyoriKbn valueOf(String value) {
        return valueOf(C_TsrysksyoriKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TsrysksyoriKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TsrysksyoriKbn.class, patternId, value);
    }
}
