
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＧＷ手数料データ作成処理区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_GwtsrydatasakuseisyoriKbn</td><td colspan="3">ＧＷ手数料データ作成処理区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #KAKUHOU}</td><td>&quot;0&quot;</td><td>確報</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOKUHOU_SMBC}</td><td>&quot;1&quot;</td><td>ＳＭＢＣ速報</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOKUHOU_NTJ}</td><td>&quot;2&quot;</td><td>日次速報</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOKUHOU_KSN}</td><td>&quot;3&quot;</td><td>決算用速報</td></tr>
 * </table>
 */
public class C_GwtsrydatasakuseisyoriKbn extends Classification<C_GwtsrydatasakuseisyoriKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_GwtsrydatasakuseisyoriKbn KAKUHOU = new C_GwtsrydatasakuseisyoriKbn("0");

    public static final C_GwtsrydatasakuseisyoriKbn SOKUHOU_SMBC = new C_GwtsrydatasakuseisyoriKbn("1");

    public static final C_GwtsrydatasakuseisyoriKbn SOKUHOU_NTJ = new C_GwtsrydatasakuseisyoriKbn("2");

    public static final C_GwtsrydatasakuseisyoriKbn SOKUHOU_KSN = new C_GwtsrydatasakuseisyoriKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, KAKUHOU, "KAKUHOU", true);
        addPattern(PATTERN_DEFAULT, SOKUHOU_SMBC, "SOKUHOU_SMBC", false);
        addPattern(PATTERN_DEFAULT, SOKUHOU_NTJ, "SOKUHOU_NTJ", false);
        addPattern(PATTERN_DEFAULT, SOKUHOU_KSN, "SOKUHOU_KSN", false);


        lock(C_GwtsrydatasakuseisyoriKbn.class);
    }

    private C_GwtsrydatasakuseisyoriKbn(String value) {
        super(value);
    }

    public static C_GwtsrydatasakuseisyoriKbn valueOf(String value) {
        return valueOf(C_GwtsrydatasakuseisyoriKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_GwtsrydatasakuseisyoriKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_GwtsrydatasakuseisyoriKbn.class, patternId, value);
    }
}
