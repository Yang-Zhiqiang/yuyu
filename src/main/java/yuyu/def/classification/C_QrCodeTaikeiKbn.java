
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * QRコード体系区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_QrCodeTaikeiKbn</td><td colspan="3">QRコード体系区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #YUYU}</td><td>&quot;YUYU&quot;</td><td>デフォルト（ユニークキー）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOS}</td><td>&quot;MOS&quot;</td><td>申込書類</td></tr>
 * </table>
 */
public class C_QrCodeTaikeiKbn extends Classification<C_QrCodeTaikeiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_QrCodeTaikeiKbn YUYU = new C_QrCodeTaikeiKbn("YUYU");

    public static final C_QrCodeTaikeiKbn MOS = new C_QrCodeTaikeiKbn("MOS");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, YUYU, "YUYU", true);
        addPattern(PATTERN_DEFAULT, MOS, "MOS", false);


        lock(C_QrCodeTaikeiKbn.class);
    }

    private C_QrCodeTaikeiKbn(String value) {
        super(value);
    }

    public static C_QrCodeTaikeiKbn valueOf(String value) {
        return valueOf(C_QrCodeTaikeiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_QrCodeTaikeiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_QrCodeTaikeiKbn.class, patternId, value);
    }
}
