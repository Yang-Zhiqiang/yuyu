
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 経理システム区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KeirisysKbn</td><td colspan="3">経理システム区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FUHO}</td><td>&quot;64&quot;</td><td>ゆうゆう普保（一般）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINKEIYAKU}</td><td>&quot;65&quot;</td><td>ゆうゆう新契約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KESSANSINKEIYAKU}</td><td>&quot;66&quot;</td><td>ゆうゆう新契約決算</td></tr>
 * </table>
 */
public class C_KeirisysKbn extends Classification<C_KeirisysKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KeirisysKbn BLNK = new C_KeirisysKbn("0");

    public static final C_KeirisysKbn FUHO = new C_KeirisysKbn("64");

    public static final C_KeirisysKbn SINKEIYAKU = new C_KeirisysKbn("65");

    public static final C_KeirisysKbn KESSANSINKEIYAKU = new C_KeirisysKbn("66");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, FUHO, "FUHO", false);
        addPattern(PATTERN_DEFAULT, SINKEIYAKU, "SINKEIYAKU", false);
        addPattern(PATTERN_DEFAULT, KESSANSINKEIYAKU, "KESSANSINKEIYAKU", false);


        lock(C_KeirisysKbn.class);
    }

    private C_KeirisysKbn(String value) {
        super(value);
    }

    public static C_KeirisysKbn valueOf(String value) {
        return valueOf(C_KeirisysKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KeirisysKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KeirisysKbn.class, patternId, value);
    }
}
