
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 新契約工程完了区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SkkouteikanryouKbn</td><td colspan="3">新契約工程完了区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYORITYUU}</td><td>&quot;1&quot;</td><td>処理中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANRYOU}</td><td>&quot;2&quot;</td><td>完了</td></tr>
 * </table>
 */
public class C_SkkouteikanryouKbn extends Classification<C_SkkouteikanryouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SkkouteikanryouKbn BLNK = new C_SkkouteikanryouKbn("0");

    public static final C_SkkouteikanryouKbn SYORITYUU = new C_SkkouteikanryouKbn("1");

    public static final C_SkkouteikanryouKbn KANRYOU = new C_SkkouteikanryouKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SYORITYUU, "SYORITYUU", false);
        addPattern(PATTERN_DEFAULT, KANRYOU, "KANRYOU", false);


        lock(C_SkkouteikanryouKbn.class);
    }

    private C_SkkouteikanryouKbn(String value) {
        super(value);
    }

    public static C_SkkouteikanryouKbn valueOf(String value) {
        return valueOf(C_SkkouteikanryouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SkkouteikanryouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SkkouteikanryouKbn.class, patternId, value);
    }
}
