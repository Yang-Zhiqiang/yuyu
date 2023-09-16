
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ブルーゲートステータス区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_BluegatestatusKbn</td><td colspan="3">ブルーゲートステータス区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #SEIJYOU}</td><td>&quot;0&quot;</td><td>正常完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ERROR}</td><td>&quot;1&quot;</td><td>オーソリエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TORIKESI}</td><td>&quot;2&quot;</td><td>オーソリ取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TORIKESIERROR}</td><td>&quot;3&quot;</td><td>オーソリ取消エラー</td></tr>
 * </table>
 */
public class C_BluegatestatusKbn extends Classification<C_BluegatestatusKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_BluegatestatusKbn SEIJYOU = new C_BluegatestatusKbn("0");

    public static final C_BluegatestatusKbn ERROR = new C_BluegatestatusKbn("1");

    public static final C_BluegatestatusKbn TORIKESI = new C_BluegatestatusKbn("2");

    public static final C_BluegatestatusKbn TORIKESIERROR = new C_BluegatestatusKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, SEIJYOU, "SEIJYOU", true);
        addPattern(PATTERN_DEFAULT, ERROR, "ERROR", false);
        addPattern(PATTERN_DEFAULT, TORIKESI, "TORIKESI", false);
        addPattern(PATTERN_DEFAULT, TORIKESIERROR, "TORIKESIERROR", false);


        lock(C_BluegatestatusKbn.class);
    }

    private C_BluegatestatusKbn(String value) {
        super(value);
    }

    public static C_BluegatestatusKbn valueOf(String value) {
        return valueOf(C_BluegatestatusKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_BluegatestatusKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_BluegatestatusKbn.class, patternId, value);
    }
}
