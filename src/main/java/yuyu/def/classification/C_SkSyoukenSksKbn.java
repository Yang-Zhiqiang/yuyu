
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 新契約証券作成区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SkSyoukenSksKbn</td><td colspan="3">新契約証券作成区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINKISAKUSEI}</td><td>&quot;1&quot;</td><td>新契約証券作成済</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAISAKUSEI}</td><td>&quot;2&quot;</td><td>新契約証券再作成済</td></tr>
 * </table>
 */
public class C_SkSyoukenSksKbn extends Classification<C_SkSyoukenSksKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SkSyoukenSksKbn BLNK = new C_SkSyoukenSksKbn("0");

    public static final C_SkSyoukenSksKbn SINKISAKUSEI = new C_SkSyoukenSksKbn("1");

    public static final C_SkSyoukenSksKbn SAISAKUSEI = new C_SkSyoukenSksKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SINKISAKUSEI, "SINKISAKUSEI", false);
        addPattern(PATTERN_DEFAULT, SAISAKUSEI, "SAISAKUSEI", false);


        lock(C_SkSyoukenSksKbn.class);
    }

    private C_SkSyoukenSksKbn(String value) {
        super(value);
    }

    public static C_SkSyoukenSksKbn valueOf(String value) {
        return valueOf(C_SkSyoukenSksKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SkSyoukenSksKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SkSyoukenSksKbn.class, patternId, value);
    }
}
