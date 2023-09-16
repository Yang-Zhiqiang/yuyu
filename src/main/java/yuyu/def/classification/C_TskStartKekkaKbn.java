
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * タスク開始結果区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TskStartKekkaKbn</td><td colspan="3">タスク開始結果区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #SEIJYOU}</td><td>&quot;1&quot;</td><td>正常終了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUKA_TATANTOUWARIATEZUMI}</td><td>&quot;2&quot;</td><td>タスク開始不可（他担当者割当済み）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUKA_STARTTSKNONE}</td><td>&quot;3&quot;</td><td>タスク開始不可（開始タスクなし）</td></tr>
 * </table>
 */
public class C_TskStartKekkaKbn extends Classification<C_TskStartKekkaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TskStartKekkaKbn SEIJYOU = new C_TskStartKekkaKbn("1");

    public static final C_TskStartKekkaKbn HUKA_TATANTOUWARIATEZUMI = new C_TskStartKekkaKbn("2");

    public static final C_TskStartKekkaKbn HUKA_STARTTSKNONE = new C_TskStartKekkaKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, SEIJYOU, "SEIJYOU", true);
        addPattern(PATTERN_DEFAULT, HUKA_TATANTOUWARIATEZUMI, "HUKA_TATANTOUWARIATEZUMI", false);
        addPattern(PATTERN_DEFAULT, HUKA_STARTTSKNONE, "HUKA_STARTTSKNONE", false);


        lock(C_TskStartKekkaKbn.class);
    }

    private C_TskStartKekkaKbn(String value) {
        super(value);
    }

    public static C_TskStartKekkaKbn valueOf(String value) {
        return valueOf(C_TskStartKekkaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TskStartKekkaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TskStartKekkaKbn.class, patternId, value);
    }
}
