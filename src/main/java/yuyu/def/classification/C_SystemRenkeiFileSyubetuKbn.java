
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * システム間連携用ファイル種別区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SystemRenkeiFileSyubetuKbn</td><td colspan="3">システム間連携用ファイル種別区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CSV_VARIABLELENGTH}</td><td>&quot;1&quot;</td><td>CSV（可変長）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CSV_FIXEDLENGTH}</td><td>&quot;2&quot;</td><td>CSV（固定長）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TXT_FIXEDLENGTH}</td><td>&quot;3&quot;</td><td>TEXT（固定長）</td></tr>
 * </table>
 */
public class C_SystemRenkeiFileSyubetuKbn extends Classification<C_SystemRenkeiFileSyubetuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SystemRenkeiFileSyubetuKbn BLNK = new C_SystemRenkeiFileSyubetuKbn("0");

    public static final C_SystemRenkeiFileSyubetuKbn CSV_VARIABLELENGTH = new C_SystemRenkeiFileSyubetuKbn("1");

    public static final C_SystemRenkeiFileSyubetuKbn CSV_FIXEDLENGTH = new C_SystemRenkeiFileSyubetuKbn("2");

    public static final C_SystemRenkeiFileSyubetuKbn TXT_FIXEDLENGTH = new C_SystemRenkeiFileSyubetuKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, CSV_VARIABLELENGTH, "CSV_VARIABLELENGTH", false);
        addPattern(PATTERN_DEFAULT, CSV_FIXEDLENGTH, "CSV_FIXEDLENGTH", false);
        addPattern(PATTERN_DEFAULT, TXT_FIXEDLENGTH, "TXT_FIXEDLENGTH", false);


        lock(C_SystemRenkeiFileSyubetuKbn.class);
    }

    private C_SystemRenkeiFileSyubetuKbn(String value) {
        super(value);
    }

    public static C_SystemRenkeiFileSyubetuKbn valueOf(String value) {
        return valueOf(C_SystemRenkeiFileSyubetuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SystemRenkeiFileSyubetuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SystemRenkeiFileSyubetuKbn.class, patternId, value);
    }
}
