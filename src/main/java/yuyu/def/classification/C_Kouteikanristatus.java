
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 工程管理状況 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Kouteikanristatus</td><td colspan="3">工程管理状況</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYORITYUU}</td><td>&quot;10&quot;</td><td>処理中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANRYOU}</td><td>&quot;90&quot;</td><td>完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TORIKESI}</td><td>&quot;99&quot;</td><td>取消</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_NOTORI NOTORI}<br />(取扱なし)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYORITYUU}</td><td>&quot;10&quot;</td><td>処理中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANRYOU}</td><td>&quot;90&quot;</td><td>完了</td></tr>
 * </table>
 */
public class C_Kouteikanristatus extends Classification<C_Kouteikanristatus> {

    private static final long serialVersionUID = 1L;


    public static final C_Kouteikanristatus BLNK = new C_Kouteikanristatus("0");

    public static final C_Kouteikanristatus SYORITYUU = new C_Kouteikanristatus("10");

    public static final C_Kouteikanristatus KANRYOU = new C_Kouteikanristatus("90");

    public static final C_Kouteikanristatus TORIKESI = new C_Kouteikanristatus("99");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_NOTORI = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SYORITYUU, "SYORITYUU", false);
        addPattern(PATTERN_DEFAULT, KANRYOU, "KANRYOU", false);
        addPattern(PATTERN_DEFAULT, TORIKESI, "TORIKESI", false);


        addPattern(PATTERN_NOTORI, BLNK, "BLNK", true);
        addPattern(PATTERN_NOTORI, SYORITYUU, "SYORITYUU", false);
        addPattern(PATTERN_NOTORI, KANRYOU, "KANRYOU", false);


        lock(C_Kouteikanristatus.class);
    }

    private C_Kouteikanristatus(String value) {
        super(value);
    }

    public static C_Kouteikanristatus valueOf(String value) {
        return valueOf(C_Kouteikanristatus.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Kouteikanristatus.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Kouteikanristatus.class, patternId, value);
    }
}
