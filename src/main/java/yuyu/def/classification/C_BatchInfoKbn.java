
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * バッチ情報区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_BatchInfoKbn</td><td colspan="3">バッチ情報区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">&nbsp;</td><td>{@link #SYORI}</td><td>&quot;1&quot;</td><td>処理中</td></tr>
 *  <tr><td align="center">○</td><td>{@link #SEIJYOU}</td><td>&quot;2&quot;</td><td>正常</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIKOKU}</td><td>&quot;3&quot;</td><td>警告</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ERROR}</td><td>&quot;4&quot;</td><td>エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUURYOU_TYU}</td><td>&quot;5&quot;</td><td>終了中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUSEI_SYUURYOU}</td><td>&quot;6&quot;</td><td>強制終了</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_SYOUKAI SYOUKAI}<br />(照会)</td><td align="center">○</td><td>{@link #SYORI}</td><td>&quot;1&quot;</td><td>処理中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEIJYOU}</td><td>&quot;2&quot;</td><td>正常</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIKOKU}</td><td>&quot;3&quot;</td><td>警告</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ERROR}</td><td>&quot;4&quot;</td><td>エラー</td></tr>
 * </table>
 */
public class C_BatchInfoKbn extends Classification<C_BatchInfoKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_BatchInfoKbn SYORI = new C_BatchInfoKbn("1");

    public static final C_BatchInfoKbn SEIJYOU = new C_BatchInfoKbn("2");

    public static final C_BatchInfoKbn KEIKOKU = new C_BatchInfoKbn("3");

    public static final C_BatchInfoKbn ERROR = new C_BatchInfoKbn("4");

    public static final C_BatchInfoKbn SYUURYOU_TYU = new C_BatchInfoKbn("5");

    public static final C_BatchInfoKbn SYOUSEI_SYUURYOU = new C_BatchInfoKbn("6");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SYOUKAI = "2";


    static {

        addPattern(PATTERN_DEFAULT, SYORI, "SYORI", false);
        addPattern(PATTERN_DEFAULT, SEIJYOU, "SEIJYOU", true);
        addPattern(PATTERN_DEFAULT, KEIKOKU, "KEIKOKU", false);
        addPattern(PATTERN_DEFAULT, ERROR, "ERROR", false);
        addPattern(PATTERN_DEFAULT, SYUURYOU_TYU, "SYUURYOU_TYU", false);
        addPattern(PATTERN_DEFAULT, SYOUSEI_SYUURYOU, "SYOUSEI_SYUURYOU", false);


        addPattern(PATTERN_SYOUKAI, SYORI, "SYORI", true);
        addPattern(PATTERN_SYOUKAI, SEIJYOU, "SEIJYOU", false);
        addPattern(PATTERN_SYOUKAI, KEIKOKU, "KEIKOKU", false);
        addPattern(PATTERN_SYOUKAI, ERROR, "ERROR", false);


        lock(C_BatchInfoKbn.class);
    }

    private C_BatchInfoKbn(String value) {
        super(value);
    }

    public static C_BatchInfoKbn valueOf(String value) {
        return valueOf(C_BatchInfoKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_BatchInfoKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_BatchInfoKbn.class, patternId, value);
    }
}
