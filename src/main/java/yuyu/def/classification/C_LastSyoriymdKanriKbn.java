
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 最終処理日管理区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_LastSyoriymdKanriKbn</td><td colspan="3">最終処理日管理区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #SENYOU}</td><td>&quot;1&quot;</td><td>専用帳票抽出</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SKHUBIITIRANSKS}</td><td>&quot;10&quot;</td><td>新契約不備一覧作成</td></tr>
 * </table>
 */
public class C_LastSyoriymdKanriKbn extends Classification<C_LastSyoriymdKanriKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_LastSyoriymdKanriKbn SENYOU = new C_LastSyoriymdKanriKbn("1");

    public static final C_LastSyoriymdKanriKbn SKHUBIITIRANSKS = new C_LastSyoriymdKanriKbn("10");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, SENYOU, "SENYOU", true);
        addPattern(PATTERN_DEFAULT, SKHUBIITIRANSKS, "SKHUBIITIRANSKS", false);


        lock(C_LastSyoriymdKanriKbn.class);
    }

    private C_LastSyoriymdKanriKbn(String value) {
        super(value);
    }

    public static C_LastSyoriymdKanriKbn valueOf(String value) {
        return valueOf(C_LastSyoriymdKanriKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_LastSyoriymdKanriKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_LastSyoriymdKanriKbn.class, patternId, value);
    }
}
