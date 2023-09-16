
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 外貨業務コード クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Gkgyoumucd</td><td colspan="3">外貨業務コード</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="12">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GK_GKNSOUKIN_NK_JIDOU_2EIGO}</td><td>&quot;10000&quot;</td><td>（未使用）外貨保険（外貨送金）年金自動送金（２営後）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GK_GKNSOUKIN_NK_JIDOU_3EIGO}</td><td>&quot;10001&quot;</td><td>（未使用）外貨保険（外貨送金）年金自動送金（３営後）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SKFUSEIRITUPHENKIN}</td><td>&quot;99000&quot;</td><td>新契約不成立Ｐ返金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KHSISIHARAI}</td><td>&quot;99001&quot;</td><td>保全・保険金支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NENKINJIDOU2EIGO}</td><td>&quot;99002&quot;</td><td>年金自動送金（２営後）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NENKINJIDOU3EIDO}</td><td>&quot;99003&quot;</td><td>年金自動送金（３営後）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GK_GKSOUKIN_SK}</td><td>&quot;56500&quot;</td><td>外貨保険（外貨送金）新契約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GK_GKSOUKIN_KH_SI}</td><td>&quot;51600&quot;</td><td>外貨保険（外貨送金）保全・保険金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GK_GKSOUKIN_HAITOU_TUIBARAI_KH}</td><td>&quot;51601&quot;</td><td>外貨（外貨送金）配当追払（保全</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GK_GKSOUKIN_HAITOU_TUIBARAI_SI}</td><td>&quot;56400&quot;</td><td>外貨（外貨送金）配当追払（保険金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SETTEI_HUKA}</td><td>&quot;00000&quot;</td><td>設定不可</td></tr>
 * </table>
 */
public class C_Gkgyoumucd extends Classification<C_Gkgyoumucd> {

    private static final long serialVersionUID = 1L;


    public static final C_Gkgyoumucd BLNK = new C_Gkgyoumucd("0");

    public static final C_Gkgyoumucd GK_GKNSOUKIN_NK_JIDOU_2EIGO = new C_Gkgyoumucd("10000");

    public static final C_Gkgyoumucd GK_GKNSOUKIN_NK_JIDOU_3EIGO = new C_Gkgyoumucd("10001");

    public static final C_Gkgyoumucd SKFUSEIRITUPHENKIN = new C_Gkgyoumucd("99000");

    public static final C_Gkgyoumucd KHSISIHARAI = new C_Gkgyoumucd("99001");

    public static final C_Gkgyoumucd NENKINJIDOU2EIGO = new C_Gkgyoumucd("99002");

    public static final C_Gkgyoumucd NENKINJIDOU3EIDO = new C_Gkgyoumucd("99003");

    public static final C_Gkgyoumucd GK_GKSOUKIN_SK = new C_Gkgyoumucd("56500");

    public static final C_Gkgyoumucd GK_GKSOUKIN_KH_SI = new C_Gkgyoumucd("51600");

    public static final C_Gkgyoumucd GK_GKSOUKIN_HAITOU_TUIBARAI_KH = new C_Gkgyoumucd("51601");

    public static final C_Gkgyoumucd GK_GKSOUKIN_HAITOU_TUIBARAI_SI = new C_Gkgyoumucd("56400");

    public static final C_Gkgyoumucd SETTEI_HUKA = new C_Gkgyoumucd("00000");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, GK_GKNSOUKIN_NK_JIDOU_2EIGO, "GK_GKNSOUKIN_NK_JIDOU_2EIGO", false);
        addPattern(PATTERN_DEFAULT, GK_GKNSOUKIN_NK_JIDOU_3EIGO, "GK_GKNSOUKIN_NK_JIDOU_3EIGO", false);
        addPattern(PATTERN_DEFAULT, SKFUSEIRITUPHENKIN, "SKFUSEIRITUPHENKIN", false);
        addPattern(PATTERN_DEFAULT, KHSISIHARAI, "KHSISIHARAI", false);
        addPattern(PATTERN_DEFAULT, NENKINJIDOU2EIGO, "NENKINJIDOU2EIGO", false);
        addPattern(PATTERN_DEFAULT, NENKINJIDOU3EIDO, "NENKINJIDOU3EIDO", false);
        addPattern(PATTERN_DEFAULT, GK_GKSOUKIN_SK, "GK_GKSOUKIN_SK", false);
        addPattern(PATTERN_DEFAULT, GK_GKSOUKIN_KH_SI, "GK_GKSOUKIN_KH_SI", false);
        addPattern(PATTERN_DEFAULT, GK_GKSOUKIN_HAITOU_TUIBARAI_KH, "GK_GKSOUKIN_HAITOU_TUIBARAI_KH", false);
        addPattern(PATTERN_DEFAULT, GK_GKSOUKIN_HAITOU_TUIBARAI_SI, "GK_GKSOUKIN_HAITOU_TUIBARAI_SI", false);
        addPattern(PATTERN_DEFAULT, SETTEI_HUKA, "SETTEI_HUKA", false);


        lock(C_Gkgyoumucd.class);
    }

    private C_Gkgyoumucd(String value) {
        super(value);
    }

    public static C_Gkgyoumucd valueOf(String value) {
        return valueOf(C_Gkgyoumucd.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Gkgyoumucd.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Gkgyoumucd.class, patternId, value);
    }
}
