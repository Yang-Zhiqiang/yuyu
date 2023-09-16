
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 連動処理状態区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_RendousyorijtKbn</td><td colspan="3">連動処理状態区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">&nbsp;</td><td>{@link #SYORIYOTEI}</td><td>&quot;9&quot;</td><td>処理予定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYORITYUU}</td><td>&quot;A&quot;</td><td>処理中</td></tr>
 *  <tr><td align="center">○</td><td>{@link #SEIJOU}</td><td>&quot;0&quot;</td><td>正常終了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ERROR}</td><td>&quot;1&quot;</td><td>エラー終了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MIJIKKOU}</td><td>&quot;2&quot;</td><td>未実行終了</td></tr>
 * </table>
 */
public class C_RendousyorijtKbn extends Classification<C_RendousyorijtKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_RendousyorijtKbn SYORIYOTEI = new C_RendousyorijtKbn("9");

    public static final C_RendousyorijtKbn SYORITYUU = new C_RendousyorijtKbn("A");

    public static final C_RendousyorijtKbn SEIJOU = new C_RendousyorijtKbn("0");

    public static final C_RendousyorijtKbn ERROR = new C_RendousyorijtKbn("1");

    public static final C_RendousyorijtKbn MIJIKKOU = new C_RendousyorijtKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, SYORIYOTEI, "SYORIYOTEI", false);
        addPattern(PATTERN_DEFAULT, SYORITYUU, "SYORITYUU", false);
        addPattern(PATTERN_DEFAULT, SEIJOU, "SEIJOU", true);
        addPattern(PATTERN_DEFAULT, ERROR, "ERROR", false);
        addPattern(PATTERN_DEFAULT, MIJIKKOU, "MIJIKKOU", false);


        lock(C_RendousyorijtKbn.class);
    }

    private C_RendousyorijtKbn(String value) {
        super(value);
    }

    public static C_RendousyorijtKbn valueOf(String value) {
        return valueOf(C_RendousyorijtKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_RendousyorijtKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_RendousyorijtKbn.class, patternId, value);
    }
}
