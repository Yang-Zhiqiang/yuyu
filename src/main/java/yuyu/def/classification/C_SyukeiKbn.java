
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 集計区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SyukeiKbn</td><td colspan="3">集計区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANJO_DENPYO}</td><td>&quot;1&quot;</td><td>勘定科目・伝票日付単位</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANJO}</td><td>&quot;2&quot;</td><td>勘定科目単位</td></tr>
 * </table>
 */
public class C_SyukeiKbn extends Classification<C_SyukeiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SyukeiKbn BLNK = new C_SyukeiKbn("0");

    public static final C_SyukeiKbn KANJO_DENPYO = new C_SyukeiKbn("1");

    public static final C_SyukeiKbn KANJO = new C_SyukeiKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KANJO_DENPYO, "KANJO_DENPYO", false);
        addPattern(PATTERN_DEFAULT, KANJO, "KANJO", false);


        lock(C_SyukeiKbn.class);
    }

    private C_SyukeiKbn(String value) {
        super(value);
    }

    public static C_SyukeiKbn valueOf(String value) {
        return valueOf(C_SyukeiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SyukeiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SyukeiKbn.class, patternId, value);
    }
}
