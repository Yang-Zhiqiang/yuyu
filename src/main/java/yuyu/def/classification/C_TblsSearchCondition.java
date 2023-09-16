
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * テーブル照会検索条件区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TblsSearchCondition</td><td colspan="3">テーブル照会検索条件区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;1&quot;</td><td>指定なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #INPUT}</td><td>&quot;2&quot;</td><td>条件入力</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ISNULL}</td><td>&quot;3&quot;</td><td>isNull</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BLANK}</td><td>&quot;4&quot;</td><td>ブランク　</td></tr>
 * </table>
 */
public class C_TblsSearchCondition extends Classification<C_TblsSearchCondition> {

    private static final long serialVersionUID = 1L;


    public static final C_TblsSearchCondition NONE = new C_TblsSearchCondition("1");

    public static final C_TblsSearchCondition INPUT = new C_TblsSearchCondition("2");

    public static final C_TblsSearchCondition ISNULL = new C_TblsSearchCondition("3");

    public static final C_TblsSearchCondition BLANK = new C_TblsSearchCondition("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, INPUT, "INPUT", false);
        addPattern(PATTERN_DEFAULT, ISNULL, "ISNULL", false);
        addPattern(PATTERN_DEFAULT, BLANK, "BLANK", false);


        lock(C_TblsSearchCondition.class);
    }

    private C_TblsSearchCondition(String value) {
        super(value);
    }

    public static C_TblsSearchCondition valueOf(String value) {
        return valueOf(C_TblsSearchCondition.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TblsSearchCondition.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TblsSearchCondition.class, patternId, value);
    }
}
