
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 業務コード クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Gyoumucd</td><td colspan="3">業務コード</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="15">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GK_YENSOUKIN_NK}</td><td>&quot;1000&quot;</td><td>（未使用）外貨保険（円送金）年金支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GK_YENSOUKIN_NK_JIDOU}</td><td>&quot;1001&quot;</td><td>（未使用）外貨保険（円送金）年金自動送金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SKFUSEIRITUPHENKIN}</td><td>&quot;9900&quot;</td><td>新契約不成立Ｐ返金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KHSISIHARAIYOKUEI}</td><td>&quot;9901&quot;</td><td>保全・保険金支払（翌営）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KHSISIHARAI2EIGO}</td><td>&quot;9902&quot;</td><td>保全・保険金支払（２営後）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NENKINJIDOUSOUKIN}</td><td>&quot;9903&quot;</td><td>年金自動送金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GK_YENSOUKIN_SK}</td><td>&quot;5650&quot;</td><td>（円送金）新契約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GK_YENSOUKIN_KH_SI}</td><td>&quot;9943&quot;</td><td>（円送金）保全・保険金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GK_YENSOUKIN_HAITOU_TUIBARAI_KH}</td><td>&quot;9944&quot;</td><td>（円送金）配当追払（保全）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GK_YENSOUKIN_HAITOU_TUIBARAI_SI}</td><td>&quot;9961&quot;</td><td>（円送金）配当追払（保険金）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GK_YENSOUKIN_DS}</td><td>&quot;7270&quot;</td><td>（円送金）ＤＳ解約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GK_YENSOUKIN_YHRSYMTGNYKN}</td><td>&quot;5536&quot;</td><td>（円送金）預振消滅後入金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GK_YENSOUKIN_NK_SHR}</td><td>&quot;9942&quot;</td><td>（円送金）年金支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SETTEI_HUKA}</td><td>&quot;0000&quot;</td><td>設定不可</td></tr>
 * </table>
 */
public class C_Gyoumucd extends Classification<C_Gyoumucd> {

    private static final long serialVersionUID = 1L;


    public static final C_Gyoumucd BLNK = new C_Gyoumucd("0");

    public static final C_Gyoumucd GK_YENSOUKIN_NK = new C_Gyoumucd("1000");

    public static final C_Gyoumucd GK_YENSOUKIN_NK_JIDOU = new C_Gyoumucd("1001");

    public static final C_Gyoumucd SKFUSEIRITUPHENKIN = new C_Gyoumucd("9900");

    public static final C_Gyoumucd KHSISIHARAIYOKUEI = new C_Gyoumucd("9901");

    public static final C_Gyoumucd KHSISIHARAI2EIGO = new C_Gyoumucd("9902");

    public static final C_Gyoumucd NENKINJIDOUSOUKIN = new C_Gyoumucd("9903");

    public static final C_Gyoumucd GK_YENSOUKIN_SK = new C_Gyoumucd("5650");

    public static final C_Gyoumucd GK_YENSOUKIN_KH_SI = new C_Gyoumucd("9943");

    public static final C_Gyoumucd GK_YENSOUKIN_HAITOU_TUIBARAI_KH = new C_Gyoumucd("9944");

    public static final C_Gyoumucd GK_YENSOUKIN_HAITOU_TUIBARAI_SI = new C_Gyoumucd("9961");

    public static final C_Gyoumucd GK_YENSOUKIN_DS = new C_Gyoumucd("7270");

    public static final C_Gyoumucd GK_YENSOUKIN_YHRSYMTGNYKN = new C_Gyoumucd("5536");

    public static final C_Gyoumucd GK_YENSOUKIN_NK_SHR = new C_Gyoumucd("9942");

    public static final C_Gyoumucd SETTEI_HUKA = new C_Gyoumucd("0000");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, GK_YENSOUKIN_NK, "GK_YENSOUKIN_NK", false);
        addPattern(PATTERN_DEFAULT, GK_YENSOUKIN_NK_JIDOU, "GK_YENSOUKIN_NK_JIDOU", false);
        addPattern(PATTERN_DEFAULT, SKFUSEIRITUPHENKIN, "SKFUSEIRITUPHENKIN", false);
        addPattern(PATTERN_DEFAULT, KHSISIHARAIYOKUEI, "KHSISIHARAIYOKUEI", false);
        addPattern(PATTERN_DEFAULT, KHSISIHARAI2EIGO, "KHSISIHARAI2EIGO", false);
        addPattern(PATTERN_DEFAULT, NENKINJIDOUSOUKIN, "NENKINJIDOUSOUKIN", false);
        addPattern(PATTERN_DEFAULT, GK_YENSOUKIN_SK, "GK_YENSOUKIN_SK", false);
        addPattern(PATTERN_DEFAULT, GK_YENSOUKIN_KH_SI, "GK_YENSOUKIN_KH_SI", false);
        addPattern(PATTERN_DEFAULT, GK_YENSOUKIN_HAITOU_TUIBARAI_KH, "GK_YENSOUKIN_HAITOU_TUIBARAI_KH", false);
        addPattern(PATTERN_DEFAULT, GK_YENSOUKIN_HAITOU_TUIBARAI_SI, "GK_YENSOUKIN_HAITOU_TUIBARAI_SI", false);
        addPattern(PATTERN_DEFAULT, GK_YENSOUKIN_DS, "GK_YENSOUKIN_DS", false);
        addPattern(PATTERN_DEFAULT, GK_YENSOUKIN_YHRSYMTGNYKN, "GK_YENSOUKIN_YHRSYMTGNYKN", false);
        addPattern(PATTERN_DEFAULT, GK_YENSOUKIN_NK_SHR, "GK_YENSOUKIN_NK_SHR", false);
        addPattern(PATTERN_DEFAULT, SETTEI_HUKA, "SETTEI_HUKA", false);


        lock(C_Gyoumucd.class);
    }

    private C_Gyoumucd(String value) {
        super(value);
    }

    public static C_Gyoumucd valueOf(String value) {
        return valueOf(C_Gyoumucd.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Gyoumucd.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Gyoumucd.class, patternId, value);
    }
}
