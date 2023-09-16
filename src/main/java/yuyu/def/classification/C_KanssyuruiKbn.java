
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 勧奨種類区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KanssyuruiKbn</td><td colspan="3">勧奨種類区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOKAIKANSYOU}</td><td>&quot;4&quot;</td><td>初回勧奨</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAIKANSYOU}</td><td>&quot;1&quot;</td><td>再勧奨</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NYUUINTYUUNYUUIN}</td><td>&quot;2&quot;</td><td>入院中入院</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TYOKYHMBR}</td><td>&quot;3&quot;</td><td>長期給付未払</td></tr>
 * </table>
 */
public class C_KanssyuruiKbn extends Classification<C_KanssyuruiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KanssyuruiKbn BLNK = new C_KanssyuruiKbn("0");

    public static final C_KanssyuruiKbn SYOKAIKANSYOU = new C_KanssyuruiKbn("4");

    public static final C_KanssyuruiKbn SAIKANSYOU = new C_KanssyuruiKbn("1");

    public static final C_KanssyuruiKbn NYUUINTYUUNYUUIN = new C_KanssyuruiKbn("2");

    public static final C_KanssyuruiKbn TYOKYHMBR = new C_KanssyuruiKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SYOKAIKANSYOU, "SYOKAIKANSYOU", false);
        addPattern(PATTERN_DEFAULT, SAIKANSYOU, "SAIKANSYOU", false);
        addPattern(PATTERN_DEFAULT, NYUUINTYUUNYUUIN, "NYUUINTYUUNYUUIN", false);
        addPattern(PATTERN_DEFAULT, TYOKYHMBR, "TYOKYHMBR", false);


        lock(C_KanssyuruiKbn.class);
    }

    private C_KanssyuruiKbn(String value) {
        super(value);
    }

    public static C_KanssyuruiKbn valueOf(String value) {
        return valueOf(C_KanssyuruiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KanssyuruiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KanssyuruiKbn.class, patternId, value);
    }
}
