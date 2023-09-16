
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * IWF帳票種類区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_WftyouhyousyuruiKbn</td><td colspan="3">IWF帳票種類区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HYOUSI}</td><td>&quot;1&quot;</td><td>取込用表紙</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HBTTS}</td><td>&quot;2&quot;</td><td>不備通知書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HBKSSJS}</td><td>&quot;3&quot;</td><td>不備解消指示書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HBHASSIN}</td><td>&quot;4&quot;</td><td>不備発信リスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HNSKSYO}</td><td>&quot;5&quot;</td><td>汎用請求書</td></tr>
 * </table>
 */
public class C_WftyouhyousyuruiKbn extends Classification<C_WftyouhyousyuruiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_WftyouhyousyuruiKbn BLNK = new C_WftyouhyousyuruiKbn("0");

    public static final C_WftyouhyousyuruiKbn HYOUSI = new C_WftyouhyousyuruiKbn("1");

    public static final C_WftyouhyousyuruiKbn HBTTS = new C_WftyouhyousyuruiKbn("2");

    public static final C_WftyouhyousyuruiKbn HBKSSJS = new C_WftyouhyousyuruiKbn("3");

    public static final C_WftyouhyousyuruiKbn HBHASSIN = new C_WftyouhyousyuruiKbn("4");

    public static final C_WftyouhyousyuruiKbn HNSKSYO = new C_WftyouhyousyuruiKbn("5");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HYOUSI, "HYOUSI", false);
        addPattern(PATTERN_DEFAULT, HBTTS, "HBTTS", false);
        addPattern(PATTERN_DEFAULT, HBKSSJS, "HBKSSJS", false);
        addPattern(PATTERN_DEFAULT, HBHASSIN, "HBHASSIN", false);
        addPattern(PATTERN_DEFAULT, HNSKSYO, "HNSKSYO", false);


        lock(C_WftyouhyousyuruiKbn.class);
    }

    private C_WftyouhyousyuruiKbn(String value) {
        super(value);
    }

    public static C_WftyouhyousyuruiKbn valueOf(String value) {
        return valueOf(C_WftyouhyousyuruiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_WftyouhyousyuruiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_WftyouhyousyuruiKbn.class, patternId, value);
    }
}
