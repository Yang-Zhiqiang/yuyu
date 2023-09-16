
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ボーナスランク区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_BonusrankKbn</td><td colspan="3">ボーナスランク区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="14">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;00&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RANK1}</td><td>&quot;01&quot;</td><td>ランク１</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RANK2}</td><td>&quot;02&quot;</td><td>ランク２</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RANK3}</td><td>&quot;03&quot;</td><td>ランク３</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RANK4}</td><td>&quot;04&quot;</td><td>ランク４</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RANK5}</td><td>&quot;05&quot;</td><td>ランク５</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RANK6}</td><td>&quot;06&quot;</td><td>ランク６</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RANK7}</td><td>&quot;07&quot;</td><td>ランク７</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RANK8}</td><td>&quot;08&quot;</td><td>ランク８</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RANK9}</td><td>&quot;09&quot;</td><td>ランク９</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RANK10}</td><td>&quot;10&quot;</td><td>ランク１０</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RANK11}</td><td>&quot;11&quot;</td><td>ランク１１</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RANK12}</td><td>&quot;12&quot;</td><td>ランク１２</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RANK99}</td><td>&quot;99&quot;</td><td>ランク９９</td></tr>
 *  <tr><td rowspan="14">{@link #PATTERN_PATARN1 PATARN1}<br />(パターン１)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;00&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RANK1}</td><td>&quot;01&quot;</td><td>Ｓ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RANK2}</td><td>&quot;02&quot;</td><td>Ａ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RANK3}</td><td>&quot;03&quot;</td><td>Ｂ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RANK4}</td><td>&quot;04&quot;</td><td>Ｃ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RANK5}</td><td>&quot;05&quot;</td><td>Ｄ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RANK6}</td><td>&quot;06&quot;</td><td>Ｅ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RANK7}</td><td>&quot;07&quot;</td><td>Ｆ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RANK8}</td><td>&quot;08&quot;</td><td>Ｇ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RANK9}</td><td>&quot;09&quot;</td><td>Ｈ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RANK10}</td><td>&quot;10&quot;</td><td>Ｉ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RANK11}</td><td>&quot;11&quot;</td><td>Ｊ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RANK12}</td><td>&quot;12&quot;</td><td>Ｋ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RANK99}</td><td>&quot;99&quot;</td><td>－</td></tr>
 * </table>
 */
public class C_BonusrankKbn extends Classification<C_BonusrankKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_BonusrankKbn BLNK = new C_BonusrankKbn("00");

    public static final C_BonusrankKbn RANK1 = new C_BonusrankKbn("01");

    public static final C_BonusrankKbn RANK2 = new C_BonusrankKbn("02");

    public static final C_BonusrankKbn RANK3 = new C_BonusrankKbn("03");

    public static final C_BonusrankKbn RANK4 = new C_BonusrankKbn("04");

    public static final C_BonusrankKbn RANK5 = new C_BonusrankKbn("05");

    public static final C_BonusrankKbn RANK6 = new C_BonusrankKbn("06");

    public static final C_BonusrankKbn RANK7 = new C_BonusrankKbn("07");

    public static final C_BonusrankKbn RANK8 = new C_BonusrankKbn("08");

    public static final C_BonusrankKbn RANK9 = new C_BonusrankKbn("09");

    public static final C_BonusrankKbn RANK10 = new C_BonusrankKbn("10");

    public static final C_BonusrankKbn RANK11 = new C_BonusrankKbn("11");

    public static final C_BonusrankKbn RANK12 = new C_BonusrankKbn("12");

    public static final C_BonusrankKbn RANK99 = new C_BonusrankKbn("99");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_PATARN1 = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, RANK1, "RANK1", false);
        addPattern(PATTERN_DEFAULT, RANK2, "RANK2", false);
        addPattern(PATTERN_DEFAULT, RANK3, "RANK3", false);
        addPattern(PATTERN_DEFAULT, RANK4, "RANK4", false);
        addPattern(PATTERN_DEFAULT, RANK5, "RANK5", false);
        addPattern(PATTERN_DEFAULT, RANK6, "RANK6", false);
        addPattern(PATTERN_DEFAULT, RANK7, "RANK7", false);
        addPattern(PATTERN_DEFAULT, RANK8, "RANK8", false);
        addPattern(PATTERN_DEFAULT, RANK9, "RANK9", false);
        addPattern(PATTERN_DEFAULT, RANK10, "RANK10", false);
        addPattern(PATTERN_DEFAULT, RANK11, "RANK11", false);
        addPattern(PATTERN_DEFAULT, RANK12, "RANK12", false);
        addPattern(PATTERN_DEFAULT, RANK99, "RANK99", false);


        addPattern(PATTERN_PATARN1, BLNK, "BLNK", true);
        addPattern(PATTERN_PATARN1, RANK1, "RANK1", false);
        addPattern(PATTERN_PATARN1, RANK2, "RANK2", false);
        addPattern(PATTERN_PATARN1, RANK3, "RANK3", false);
        addPattern(PATTERN_PATARN1, RANK4, "RANK4", false);
        addPattern(PATTERN_PATARN1, RANK5, "RANK5", false);
        addPattern(PATTERN_PATARN1, RANK6, "RANK6", false);
        addPattern(PATTERN_PATARN1, RANK7, "RANK7", false);
        addPattern(PATTERN_PATARN1, RANK8, "RANK8", false);
        addPattern(PATTERN_PATARN1, RANK9, "RANK9", false);
        addPattern(PATTERN_PATARN1, RANK10, "RANK10", false);
        addPattern(PATTERN_PATARN1, RANK11, "RANK11", false);
        addPattern(PATTERN_PATARN1, RANK12, "RANK12", false);
        addPattern(PATTERN_PATARN1, RANK99, "RANK99", false);


        lock(C_BonusrankKbn.class);
    }

    private C_BonusrankKbn(String value) {
        super(value);
    }

    public static C_BonusrankKbn valueOf(String value) {
        return valueOf(C_BonusrankKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_BonusrankKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_BonusrankKbn.class, patternId, value);
    }
}
