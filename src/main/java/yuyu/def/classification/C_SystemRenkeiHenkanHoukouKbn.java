
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * システム間連携用変換方向区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SystemRenkeiHenkanHoukouKbn</td><td colspan="3">システム間連携用変換方向区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #RAY_TO_OTHER}</td><td>&quot;1&quot;</td><td>普保Ⅱ⇒他システム</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OTHER_TO_RAY}</td><td>&quot;2&quot;</td><td>他システム⇒普保Ⅱ</td></tr>
 * </table>
 */
public class C_SystemRenkeiHenkanHoukouKbn extends Classification<C_SystemRenkeiHenkanHoukouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SystemRenkeiHenkanHoukouKbn RAY_TO_OTHER = new C_SystemRenkeiHenkanHoukouKbn("1");

    public static final C_SystemRenkeiHenkanHoukouKbn OTHER_TO_RAY = new C_SystemRenkeiHenkanHoukouKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, RAY_TO_OTHER, "RAY_TO_OTHER", true);
        addPattern(PATTERN_DEFAULT, OTHER_TO_RAY, "OTHER_TO_RAY", false);


        lock(C_SystemRenkeiHenkanHoukouKbn.class);
    }

    private C_SystemRenkeiHenkanHoukouKbn(String value) {
        super(value);
    }

    public static C_SystemRenkeiHenkanHoukouKbn valueOf(String value) {
        return valueOf(C_SystemRenkeiHenkanHoukouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SystemRenkeiHenkanHoukouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SystemRenkeiHenkanHoukouKbn.class, patternId, value);
    }
}
