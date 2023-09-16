
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 販売状況区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HanbaiJyoukyouKbn</td><td colspan="3">販売状況区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HANBAITYUU}</td><td>&quot;1&quot;</td><td>販売中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HANBAIKYUUSI}</td><td>&quot;2&quot;</td><td>販売休止</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HANBAIKAISIMAE}</td><td>&quot;3&quot;</td><td>販売開始前</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TORIATUKAINASI}</td><td>&quot;4&quot;</td><td>取扱なし</td></tr>
 * </table>
 */
public class C_HanbaiJyoukyouKbn extends Classification<C_HanbaiJyoukyouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HanbaiJyoukyouKbn BLNK = new C_HanbaiJyoukyouKbn("0");

    public static final C_HanbaiJyoukyouKbn HANBAITYUU = new C_HanbaiJyoukyouKbn("1");

    public static final C_HanbaiJyoukyouKbn HANBAIKYUUSI = new C_HanbaiJyoukyouKbn("2");

    public static final C_HanbaiJyoukyouKbn HANBAIKAISIMAE = new C_HanbaiJyoukyouKbn("3");

    public static final C_HanbaiJyoukyouKbn TORIATUKAINASI = new C_HanbaiJyoukyouKbn("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HANBAITYUU, "HANBAITYUU", false);
        addPattern(PATTERN_DEFAULT, HANBAIKYUUSI, "HANBAIKYUUSI", false);
        addPattern(PATTERN_DEFAULT, HANBAIKAISIMAE, "HANBAIKAISIMAE", false);
        addPattern(PATTERN_DEFAULT, TORIATUKAINASI, "TORIATUKAINASI", false);


        lock(C_HanbaiJyoukyouKbn.class);
    }

    private C_HanbaiJyoukyouKbn(String value) {
        super(value);
    }

    public static C_HanbaiJyoukyouKbn valueOf(String value) {
        return valueOf(C_HanbaiJyoukyouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HanbaiJyoukyouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HanbaiJyoukyouKbn.class, patternId, value);
    }
}
