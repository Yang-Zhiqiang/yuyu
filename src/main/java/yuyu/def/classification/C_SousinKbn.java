
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 送信区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SousinKbn</td><td colspan="3">送信区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #MISOUSIN}</td><td>&quot;0&quot;</td><td>未送信</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOUSINMATI}</td><td>&quot;1&quot;</td><td>送信待ち</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOUSINZUMI}</td><td>&quot;2&quot;</td><td>送信済</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOUSINHUYOU}</td><td>&quot;3&quot;</td><td>送信不要</td></tr>
 * </table>
 */
public class C_SousinKbn extends Classification<C_SousinKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SousinKbn MISOUSIN = new C_SousinKbn("0");

    public static final C_SousinKbn SOUSINMATI = new C_SousinKbn("1");

    public static final C_SousinKbn SOUSINZUMI = new C_SousinKbn("2");

    public static final C_SousinKbn SOUSINHUYOU = new C_SousinKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, MISOUSIN, "MISOUSIN", true);
        addPattern(PATTERN_DEFAULT, SOUSINMATI, "SOUSINMATI", false);
        addPattern(PATTERN_DEFAULT, SOUSINZUMI, "SOUSINZUMI", false);
        addPattern(PATTERN_DEFAULT, SOUSINHUYOU, "SOUSINHUYOU", false);


        lock(C_SousinKbn.class);
    }

    private C_SousinKbn(String value) {
        super(value);
    }

    public static C_SousinKbn valueOf(String value) {
        return valueOf(C_SousinKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SousinKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SousinKbn.class, patternId, value);
    }
}
