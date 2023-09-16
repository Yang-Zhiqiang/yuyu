
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 書類取込方法区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SyoruiTorikomiHouKbn</td><td colspan="3">書類取込方法区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #SCAN_QR}</td><td>&quot;1&quot;</td><td>スキャン(QR)</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PDF}</td><td>&quot;5&quot;</td><td>PDF連動</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TIFF}</td><td>&quot;6&quot;</td><td>TIFF連動</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAKUSEI_DOUJI}</td><td>&quot;9&quot;</td><td>帳票作成同時取込</td></tr>
 * </table>
 */
public class C_SyoruiTorikomiHouKbn extends Classification<C_SyoruiTorikomiHouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SyoruiTorikomiHouKbn SCAN_QR = new C_SyoruiTorikomiHouKbn("1");

    public static final C_SyoruiTorikomiHouKbn PDF = new C_SyoruiTorikomiHouKbn("5");

    public static final C_SyoruiTorikomiHouKbn TIFF = new C_SyoruiTorikomiHouKbn("6");

    public static final C_SyoruiTorikomiHouKbn SAKUSEI_DOUJI = new C_SyoruiTorikomiHouKbn("9");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, SCAN_QR, "SCAN_QR", true);
        addPattern(PATTERN_DEFAULT, PDF, "PDF", false);
        addPattern(PATTERN_DEFAULT, TIFF, "TIFF", false);
        addPattern(PATTERN_DEFAULT, SAKUSEI_DOUJI, "SAKUSEI_DOUJI", false);


        lock(C_SyoruiTorikomiHouKbn.class);
    }

    private C_SyoruiTorikomiHouKbn(String value) {
        super(value);
    }

    public static C_SyoruiTorikomiHouKbn valueOf(String value) {
        return valueOf(C_SyoruiTorikomiHouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SyoruiTorikomiHouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SyoruiTorikomiHouKbn.class, patternId, value);
    }
}
