
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＤＳ手続種別区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DsTtdksyubetuKbn</td><td colspan="3">ＤＳ手続種別区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TORIHIKITOUROKU}</td><td>&quot;1&quot;</td><td>取引サービス登録</td></tr>
 * </table>
 */
public class C_DsTtdksyubetuKbn extends Classification<C_DsTtdksyubetuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DsTtdksyubetuKbn BLNK = new C_DsTtdksyubetuKbn("0");

    public static final C_DsTtdksyubetuKbn TORIHIKITOUROKU = new C_DsTtdksyubetuKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TORIHIKITOUROKU, "TORIHIKITOUROKU", false);


        lock(C_DsTtdksyubetuKbn.class);
    }

    private C_DsTtdksyubetuKbn(String value) {
        super(value);
    }

    public static C_DsTtdksyubetuKbn valueOf(String value) {
        return valueOf(C_DsTtdksyubetuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DsTtdksyubetuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DsTtdksyubetuKbn.class, patternId, value);
    }
}
