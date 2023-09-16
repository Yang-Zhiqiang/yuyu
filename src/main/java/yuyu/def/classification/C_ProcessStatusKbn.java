
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * プロセスステータス区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_ProcessStatusKbn</td><td colspan="3">プロセスステータス区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #WAITING}</td><td>&quot;0&quot;</td><td>開始待ち</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PROCESSING}</td><td>&quot;10&quot;</td><td>処理中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #COMPLETED}</td><td>&quot;90&quot;</td><td>完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CANCELED}</td><td>&quot;99&quot;</td><td>取消済み</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OTHERFLOW}</td><td>&quot;1000&quot;</td><td>他フロー継続</td></tr>
 * </table>
 */
public class C_ProcessStatusKbn extends Classification<C_ProcessStatusKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_ProcessStatusKbn WAITING = new C_ProcessStatusKbn("0");

    public static final C_ProcessStatusKbn PROCESSING = new C_ProcessStatusKbn("10");

    public static final C_ProcessStatusKbn COMPLETED = new C_ProcessStatusKbn("90");

    public static final C_ProcessStatusKbn CANCELED = new C_ProcessStatusKbn("99");

    public static final C_ProcessStatusKbn OTHERFLOW = new C_ProcessStatusKbn("1000");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, WAITING, "WAITING", true);
        addPattern(PATTERN_DEFAULT, PROCESSING, "PROCESSING", false);
        addPattern(PATTERN_DEFAULT, COMPLETED, "COMPLETED", false);
        addPattern(PATTERN_DEFAULT, CANCELED, "CANCELED", false);
        addPattern(PATTERN_DEFAULT, OTHERFLOW, "OTHERFLOW", false);


        lock(C_ProcessStatusKbn.class);
    }

    private C_ProcessStatusKbn(String value) {
        super(value);
    }

    public static C_ProcessStatusKbn valueOf(String value) {
        return valueOf(C_ProcessStatusKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_ProcessStatusKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_ProcessStatusKbn.class, patternId, value);
    }
}
