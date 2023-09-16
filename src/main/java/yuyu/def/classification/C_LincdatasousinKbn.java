
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＬＩＮＣデータ送信区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_LincdatasousinKbn</td><td colspan="3">ＬＩＮＣデータ送信区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #MISETTEI}</td><td>&quot;0&quot;</td><td>未設定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUROKU}</td><td>&quot;1&quot;</td><td>登録</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAITOUROKU}</td><td>&quot;2&quot;</td><td>再登録</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENKOU}</td><td>&quot;3&quot;</td><td>変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAKUJO}</td><td>&quot;4&quot;</td><td>削除</td></tr>
 * </table>
 */
public class C_LincdatasousinKbn extends Classification<C_LincdatasousinKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_LincdatasousinKbn MISETTEI = new C_LincdatasousinKbn("0");

    public static final C_LincdatasousinKbn TOUROKU = new C_LincdatasousinKbn("1");

    public static final C_LincdatasousinKbn SAITOUROKU = new C_LincdatasousinKbn("2");

    public static final C_LincdatasousinKbn HENKOU = new C_LincdatasousinKbn("3");

    public static final C_LincdatasousinKbn SAKUJO = new C_LincdatasousinKbn("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, MISETTEI, "MISETTEI", true);
        addPattern(PATTERN_DEFAULT, TOUROKU, "TOUROKU", false);
        addPattern(PATTERN_DEFAULT, SAITOUROKU, "SAITOUROKU", false);
        addPattern(PATTERN_DEFAULT, HENKOU, "HENKOU", false);
        addPattern(PATTERN_DEFAULT, SAKUJO, "SAKUJO", false);


        lock(C_LincdatasousinKbn.class);
    }

    private C_LincdatasousinKbn(String value) {
        super(value);
    }

    public static C_LincdatasousinKbn valueOf(String value) {
        return valueOf(C_LincdatasousinKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_LincdatasousinKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_LincdatasousinKbn.class, patternId, value);
    }
}
