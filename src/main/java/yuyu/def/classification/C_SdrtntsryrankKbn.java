
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 総代理店手数料ランク区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SdrtntsryrankKbn</td><td colspan="3">総代理店手数料ランク区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="12">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;00&quot;</td><td>ブランク</td></tr>
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
 *  <tr><td align="center">&nbsp;</td><td>{@link #RANK99}</td><td>&quot;99&quot;</td><td>ランク９９</td></tr>
 *  <tr><td rowspan="12">{@link #PATTERN_HYOUJI HYOUJI}<br />(表示)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;00&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RANK1}</td><td>&quot;01&quot;</td><td>S</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RANK2}</td><td>&quot;02&quot;</td><td>A</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RANK3}</td><td>&quot;03&quot;</td><td>B</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RANK4}</td><td>&quot;04&quot;</td><td>C</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RANK5}</td><td>&quot;05&quot;</td><td>D</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RANK6}</td><td>&quot;06&quot;</td><td>E</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RANK7}</td><td>&quot;07&quot;</td><td>F</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RANK8}</td><td>&quot;08&quot;</td><td>G</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RANK9}</td><td>&quot;09&quot;</td><td>H</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RANK10}</td><td>&quot;10&quot;</td><td>I</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RANK99}</td><td>&quot;99&quot;</td><td>－</td></tr>
 * </table>
 */
public class C_SdrtntsryrankKbn extends Classification<C_SdrtntsryrankKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SdrtntsryrankKbn BLNK = new C_SdrtntsryrankKbn("00");

    public static final C_SdrtntsryrankKbn RANK1 = new C_SdrtntsryrankKbn("01");

    public static final C_SdrtntsryrankKbn RANK2 = new C_SdrtntsryrankKbn("02");

    public static final C_SdrtntsryrankKbn RANK3 = new C_SdrtntsryrankKbn("03");

    public static final C_SdrtntsryrankKbn RANK4 = new C_SdrtntsryrankKbn("04");

    public static final C_SdrtntsryrankKbn RANK5 = new C_SdrtntsryrankKbn("05");

    public static final C_SdrtntsryrankKbn RANK6 = new C_SdrtntsryrankKbn("06");

    public static final C_SdrtntsryrankKbn RANK7 = new C_SdrtntsryrankKbn("07");

    public static final C_SdrtntsryrankKbn RANK8 = new C_SdrtntsryrankKbn("08");

    public static final C_SdrtntsryrankKbn RANK9 = new C_SdrtntsryrankKbn("09");

    public static final C_SdrtntsryrankKbn RANK10 = new C_SdrtntsryrankKbn("10");

    public static final C_SdrtntsryrankKbn RANK99 = new C_SdrtntsryrankKbn("99");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_HYOUJI = "2";


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
        addPattern(PATTERN_DEFAULT, RANK99, "RANK99", false);


        addPattern(PATTERN_HYOUJI, BLNK, "BLNK", true);
        addPattern(PATTERN_HYOUJI, RANK1, "RANK1", false);
        addPattern(PATTERN_HYOUJI, RANK2, "RANK2", false);
        addPattern(PATTERN_HYOUJI, RANK3, "RANK3", false);
        addPattern(PATTERN_HYOUJI, RANK4, "RANK4", false);
        addPattern(PATTERN_HYOUJI, RANK5, "RANK5", false);
        addPattern(PATTERN_HYOUJI, RANK6, "RANK6", false);
        addPattern(PATTERN_HYOUJI, RANK7, "RANK7", false);
        addPattern(PATTERN_HYOUJI, RANK8, "RANK8", false);
        addPattern(PATTERN_HYOUJI, RANK9, "RANK9", false);
        addPattern(PATTERN_HYOUJI, RANK10, "RANK10", false);
        addPattern(PATTERN_HYOUJI, RANK99, "RANK99", false);


        lock(C_SdrtntsryrankKbn.class);
    }

    private C_SdrtntsryrankKbn(String value) {
        super(value);
    }

    public static C_SdrtntsryrankKbn valueOf(String value) {
        return valueOf(C_SdrtntsryrankKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SdrtntsryrankKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SdrtntsryrankKbn.class, patternId, value);
    }
}
