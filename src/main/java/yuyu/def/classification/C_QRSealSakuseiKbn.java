
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * QRシール用紙作成区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_QRSealSakuseiKbn</td><td colspan="3">QRシール用紙作成区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KENSUU}</td><td>&quot;1&quot;</td><td>件数指定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOSNO}</td><td>&quot;2&quot;</td><td>申込番号指定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOSNOSYORUI}</td><td>&quot;3&quot;</td><td>申込番号・書類指定</td></tr>
 * </table>
 */
public class C_QRSealSakuseiKbn extends Classification<C_QRSealSakuseiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_QRSealSakuseiKbn BLNK = new C_QRSealSakuseiKbn("0");

    public static final C_QRSealSakuseiKbn KENSUU = new C_QRSealSakuseiKbn("1");

    public static final C_QRSealSakuseiKbn MOSNO = new C_QRSealSakuseiKbn("2");

    public static final C_QRSealSakuseiKbn MOSNOSYORUI = new C_QRSealSakuseiKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KENSUU, "KENSUU", false);
        addPattern(PATTERN_DEFAULT, MOSNO, "MOSNO", false);
        addPattern(PATTERN_DEFAULT, MOSNOSYORUI, "MOSNOSYORUI", false);


        lock(C_QRSealSakuseiKbn.class);
    }

    private C_QRSealSakuseiKbn(String value) {
        super(value);
    }

    public static C_QRSealSakuseiKbn valueOf(String value) {
        return valueOf(C_QRSealSakuseiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_QRSealSakuseiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_QRSealSakuseiKbn.class, patternId, value);
    }
}
