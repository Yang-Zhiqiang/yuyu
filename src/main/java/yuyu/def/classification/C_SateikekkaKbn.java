
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 査定結果区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SateikekkaKbn</td><td colspan="3">査定結果区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="12">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHR}</td><td>&quot;1&quot;</td><td>支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHRKT}</td><td>&quot;2&quot;</td><td>支払決定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TSSHR}</td><td>&quot;3&quot;</td><td>特殊支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TSSHRKT}</td><td>&quot;4&quot;</td><td>特殊支払決定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HSHR}</td><td>&quot;5&quot;</td><td>不支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HSHRKT}</td><td>&quot;6&quot;</td><td>不支払決定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PMGAITOU}</td><td>&quot;7&quot;</td><td>Ｐ免該当</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PMHIGAITOU}</td><td>&quot;8&quot;</td><td>Ｐ免非該当</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUDOST}</td><td>&quot;97&quot;</td><td>高度査定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TS}</td><td>&quot;98&quot;</td><td>転送</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;99&quot;</td><td>保留</td></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_KANI KANI}<br />(簡易査定用)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHRKT}</td><td>&quot;2&quot;</td><td>支払決定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUDOST}</td><td>&quot;97&quot;</td><td>高度査定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TS}</td><td>&quot;98&quot;</td><td>転送</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;99&quot;</td><td>保留</td></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_KOUDO1 KOUDO1}<br />(高度査定（１次）)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHR}</td><td>&quot;1&quot;</td><td>支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HSHR}</td><td>&quot;5&quot;</td><td>不支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TS}</td><td>&quot;98&quot;</td><td>転送</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;99&quot;</td><td>保留</td></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_KOUDO2 KOUDO2}<br />(高度査定（２次）)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHRKT}</td><td>&quot;2&quot;</td><td>支払決定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HSHRKT}</td><td>&quot;6&quot;</td><td>不支払決定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TS}</td><td>&quot;98&quot;</td><td>転送</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;99&quot;</td><td>保留</td></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_KYHKOUDO1 KYHKOUDO1}<br />(（給付）高度査定（１次）)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHR}</td><td>&quot;1&quot;</td><td>支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TSSHR}</td><td>&quot;3&quot;</td><td>特殊支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HSHR}</td><td>&quot;5&quot;</td><td>不支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TS}</td><td>&quot;98&quot;</td><td>転送</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;99&quot;</td><td>保留</td></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_KYHKOUDO2 KYHKOUDO2}<br />(（給付）高度査定（２次）)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHRKT}</td><td>&quot;2&quot;</td><td>支払決定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TSSHRKT}</td><td>&quot;4&quot;</td><td>特殊支払決定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HSHRKT}</td><td>&quot;6&quot;</td><td>不支払決定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TS}</td><td>&quot;98&quot;</td><td>転送</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;99&quot;</td><td>保留</td></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_PM PM}<br />(Ｐ免)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PMGAITOU}</td><td>&quot;7&quot;</td><td>Ｐ免該当</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PMHIGAITOU}</td><td>&quot;8&quot;</td><td>Ｐ免非該当</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TS}</td><td>&quot;98&quot;</td><td>転送</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;99&quot;</td><td>保留</td></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_KYUUFU KYUUFU}<br />(給付)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHR}</td><td>&quot;1&quot;</td><td>支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TSSHR}</td><td>&quot;3&quot;</td><td>特殊支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HSHR}</td><td>&quot;5&quot;</td><td>不支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TS}</td><td>&quot;98&quot;</td><td>転送</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;99&quot;</td><td>保留</td></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_SIBOU SIBOU}<br />(死亡)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHR}</td><td>&quot;1&quot;</td><td>支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HSHR}</td><td>&quot;5&quot;</td><td>不支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TS}</td><td>&quot;98&quot;</td><td>転送</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;99&quot;</td><td>保留</td></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_KOUSYOU KOUSYOU}<br />(高度障害)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHR}</td><td>&quot;1&quot;</td><td>支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HSHR}</td><td>&quot;5&quot;</td><td>不支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TS}</td><td>&quot;98&quot;</td><td>転送</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HORYUU}</td><td>&quot;99&quot;</td><td>保留</td></tr>
 * </table>
 */
public class C_SateikekkaKbn extends Classification<C_SateikekkaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SateikekkaKbn BLNK = new C_SateikekkaKbn("0");

    public static final C_SateikekkaKbn SHR = new C_SateikekkaKbn("1");

    public static final C_SateikekkaKbn SHRKT = new C_SateikekkaKbn("2");

    public static final C_SateikekkaKbn TSSHR = new C_SateikekkaKbn("3");

    public static final C_SateikekkaKbn TSSHRKT = new C_SateikekkaKbn("4");

    public static final C_SateikekkaKbn HSHR = new C_SateikekkaKbn("5");

    public static final C_SateikekkaKbn HSHRKT = new C_SateikekkaKbn("6");

    public static final C_SateikekkaKbn PMGAITOU = new C_SateikekkaKbn("7");

    public static final C_SateikekkaKbn PMHIGAITOU = new C_SateikekkaKbn("8");

    public static final C_SateikekkaKbn KOUDOST = new C_SateikekkaKbn("97");

    public static final C_SateikekkaKbn TS = new C_SateikekkaKbn("98");

    public static final C_SateikekkaKbn HORYUU = new C_SateikekkaKbn("99");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_KANI = "2";

    public static final String PATTERN_KOUDO1 = "3";

    public static final String PATTERN_KOUDO2 = "4";

    public static final String PATTERN_KYHKOUDO1 = "5";

    public static final String PATTERN_KYHKOUDO2 = "6";

    public static final String PATTERN_PM = "7";

    public static final String PATTERN_KYUUFU = "8";

    public static final String PATTERN_SIBOU = "9";

    public static final String PATTERN_KOUSYOU = "10";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SHR, "SHR", false);
        addPattern(PATTERN_DEFAULT, SHRKT, "SHRKT", false);
        addPattern(PATTERN_DEFAULT, TSSHR, "TSSHR", false);
        addPattern(PATTERN_DEFAULT, TSSHRKT, "TSSHRKT", false);
        addPattern(PATTERN_DEFAULT, HSHR, "HSHR", false);
        addPattern(PATTERN_DEFAULT, HSHRKT, "HSHRKT", false);
        addPattern(PATTERN_DEFAULT, PMGAITOU, "PMGAITOU", false);
        addPattern(PATTERN_DEFAULT, PMHIGAITOU, "PMHIGAITOU", false);
        addPattern(PATTERN_DEFAULT, KOUDOST, "KOUDOST", false);
        addPattern(PATTERN_DEFAULT, TS, "TS", false);
        addPattern(PATTERN_DEFAULT, HORYUU, "HORYUU", false);


        addPattern(PATTERN_KANI, BLNK, "BLNK", true);
        addPattern(PATTERN_KANI, SHRKT, "SHRKT", false);
        addPattern(PATTERN_KANI, KOUDOST, "KOUDOST", false);
        addPattern(PATTERN_KANI, TS, "TS", false);
        addPattern(PATTERN_KANI, HORYUU, "HORYUU", false);


        addPattern(PATTERN_KOUDO1, BLNK, "BLNK", true);
        addPattern(PATTERN_KOUDO1, SHR, "SHR", false);
        addPattern(PATTERN_KOUDO1, HSHR, "HSHR", false);
        addPattern(PATTERN_KOUDO1, TS, "TS", false);
        addPattern(PATTERN_KOUDO1, HORYUU, "HORYUU", false);


        addPattern(PATTERN_KOUDO2, BLNK, "BLNK", true);
        addPattern(PATTERN_KOUDO2, SHRKT, "SHRKT", false);
        addPattern(PATTERN_KOUDO2, HSHRKT, "HSHRKT", false);
        addPattern(PATTERN_KOUDO2, TS, "TS", false);
        addPattern(PATTERN_KOUDO2, HORYUU, "HORYUU", false);


        addPattern(PATTERN_KYHKOUDO1, BLNK, "BLNK", true);
        addPattern(PATTERN_KYHKOUDO1, SHR, "SHR", false);
        addPattern(PATTERN_KYHKOUDO1, TSSHR, "TSSHR", false);
        addPattern(PATTERN_KYHKOUDO1, HSHR, "HSHR", false);
        addPattern(PATTERN_KYHKOUDO1, TS, "TS", false);
        addPattern(PATTERN_KYHKOUDO1, HORYUU, "HORYUU", false);


        addPattern(PATTERN_KYHKOUDO2, BLNK, "BLNK", true);
        addPattern(PATTERN_KYHKOUDO2, SHRKT, "SHRKT", false);
        addPattern(PATTERN_KYHKOUDO2, TSSHRKT, "TSSHRKT", false);
        addPattern(PATTERN_KYHKOUDO2, HSHRKT, "HSHRKT", false);
        addPattern(PATTERN_KYHKOUDO2, TS, "TS", false);
        addPattern(PATTERN_KYHKOUDO2, HORYUU, "HORYUU", false);


        addPattern(PATTERN_PM, BLNK, "BLNK", true);
        addPattern(PATTERN_PM, PMGAITOU, "PMGAITOU", false);
        addPattern(PATTERN_PM, PMHIGAITOU, "PMHIGAITOU", false);
        addPattern(PATTERN_PM, TS, "TS", false);
        addPattern(PATTERN_PM, HORYUU, "HORYUU", false);


        addPattern(PATTERN_KYUUFU, BLNK, "BLNK", true);
        addPattern(PATTERN_KYUUFU, SHR, "SHR", false);
        addPattern(PATTERN_KYUUFU, TSSHR, "TSSHR", false);
        addPattern(PATTERN_KYUUFU, HSHR, "HSHR", false);
        addPattern(PATTERN_KYUUFU, TS, "TS", false);
        addPattern(PATTERN_KYUUFU, HORYUU, "HORYUU", false);


        addPattern(PATTERN_SIBOU, BLNK, "BLNK", true);
        addPattern(PATTERN_SIBOU, SHR, "SHR", false);
        addPattern(PATTERN_SIBOU, HSHR, "HSHR", false);
        addPattern(PATTERN_SIBOU, TS, "TS", false);
        addPattern(PATTERN_SIBOU, HORYUU, "HORYUU", false);


        addPattern(PATTERN_KOUSYOU, BLNK, "BLNK", true);
        addPattern(PATTERN_KOUSYOU, SHR, "SHR", false);
        addPattern(PATTERN_KOUSYOU, HSHR, "HSHR", false);
        addPattern(PATTERN_KOUSYOU, TS, "TS", false);
        addPattern(PATTERN_KOUSYOU, HORYUU, "HORYUU", false);


        lock(C_SateikekkaKbn.class);
    }

    private C_SateikekkaKbn(String value) {
        super(value);
    }

    public static C_SateikekkaKbn valueOf(String value) {
        return valueOf(C_SateikekkaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SateikekkaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SateikekkaKbn.class, patternId, value);
    }
}
