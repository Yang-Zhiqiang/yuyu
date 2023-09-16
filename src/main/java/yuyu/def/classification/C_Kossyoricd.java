
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 更新処理コード クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Kossyoricd</td><td colspan="3">更新処理コード</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="10">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOSUKE}</td><td>&quot;mosuke&quot;</td><td>申出受付</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SKUKE_K}</td><td>&quot;skuke_k&quot;</td><td>（給付）請求受付</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEI_K}</td><td>&quot;satei_k&quot;</td><td>（給付）査定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEI_SB}</td><td>&quot;satei_sb&quot;</td><td>（死亡）査定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIHARAI}</td><td>&quot;siharai&quot;</td><td>支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SKUKE_SB}</td><td>&quot;skuke_sb&quot;</td><td>（死亡）請求受付</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEI_KD}</td><td>&quot;satei_kd&quot;</td><td>（高度障害）査定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SKUKE_KD}</td><td>&quot;skuke_kd&quot;</td><td>（高度障害）請求受付</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKUSYUSIHARAI}</td><td>&quot;tokusyusiharai&quot;</td><td>特殊支払</td></tr>
 * </table>
 */
public class C_Kossyoricd extends Classification<C_Kossyoricd> {

    private static final long serialVersionUID = 1L;


    public static final C_Kossyoricd BLNK = new C_Kossyoricd("0");

    public static final C_Kossyoricd MOSUKE = new C_Kossyoricd("mosuke");

    public static final C_Kossyoricd SKUKE_K = new C_Kossyoricd("skuke_k");

    public static final C_Kossyoricd SATEI_K = new C_Kossyoricd("satei_k");

    public static final C_Kossyoricd SATEI_SB = new C_Kossyoricd("satei_sb");

    public static final C_Kossyoricd SIHARAI = new C_Kossyoricd("siharai");

    public static final C_Kossyoricd SKUKE_SB = new C_Kossyoricd("skuke_sb");

    public static final C_Kossyoricd SATEI_KD = new C_Kossyoricd("satei_kd");

    public static final C_Kossyoricd SKUKE_KD = new C_Kossyoricd("skuke_kd");

    public static final C_Kossyoricd TOKUSYUSIHARAI = new C_Kossyoricd("tokusyusiharai");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, MOSUKE, "MOSUKE", false);
        addPattern(PATTERN_DEFAULT, SKUKE_K, "SKUKE_K", false);
        addPattern(PATTERN_DEFAULT, SATEI_K, "SATEI_K", false);
        addPattern(PATTERN_DEFAULT, SATEI_SB, "SATEI_SB", false);
        addPattern(PATTERN_DEFAULT, SIHARAI, "SIHARAI", false);
        addPattern(PATTERN_DEFAULT, SKUKE_SB, "SKUKE_SB", false);
        addPattern(PATTERN_DEFAULT, SATEI_KD, "SATEI_KD", false);
        addPattern(PATTERN_DEFAULT, SKUKE_KD, "SKUKE_KD", false);
        addPattern(PATTERN_DEFAULT, TOKUSYUSIHARAI, "TOKUSYUSIHARAI", false);


        lock(C_Kossyoricd.class);
    }

    private C_Kossyoricd(String value) {
        super(value);
    }

    public static C_Kossyoricd valueOf(String value) {
        return valueOf(C_Kossyoricd.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Kossyoricd.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Kossyoricd.class, patternId, value);
    }
}
