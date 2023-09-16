
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 積立金配分割合区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TumitatekinHaibunWariKbn</td><td colspan="3">積立金配分割合区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="12">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;999&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #WARIAI000}</td><td>&quot;000&quot;</td><td>０％</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #WARIAI010}</td><td>&quot;010&quot;</td><td>１０％</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #WARIAI020}</td><td>&quot;020&quot;</td><td>２０％</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #WARIAI030}</td><td>&quot;030&quot;</td><td>３０％</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #WARIAI040}</td><td>&quot;040&quot;</td><td>４０％</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #WARIAI050}</td><td>&quot;050&quot;</td><td>５０％</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #WARIAI060}</td><td>&quot;060&quot;</td><td>６０％</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #WARIAI070}</td><td>&quot;070&quot;</td><td>７０％</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #WARIAI080}</td><td>&quot;080&quot;</td><td>８０％</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #WARIAI090}</td><td>&quot;090&quot;</td><td>９０％</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #WARIAI100}</td><td>&quot;100&quot;</td><td>１００％</td></tr>
 * </table>
 */
public class C_TumitatekinHaibunWariKbn extends Classification<C_TumitatekinHaibunWariKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TumitatekinHaibunWariKbn BLNK = new C_TumitatekinHaibunWariKbn("999");

    public static final C_TumitatekinHaibunWariKbn WARIAI000 = new C_TumitatekinHaibunWariKbn("000");

    public static final C_TumitatekinHaibunWariKbn WARIAI010 = new C_TumitatekinHaibunWariKbn("010");

    public static final C_TumitatekinHaibunWariKbn WARIAI020 = new C_TumitatekinHaibunWariKbn("020");

    public static final C_TumitatekinHaibunWariKbn WARIAI030 = new C_TumitatekinHaibunWariKbn("030");

    public static final C_TumitatekinHaibunWariKbn WARIAI040 = new C_TumitatekinHaibunWariKbn("040");

    public static final C_TumitatekinHaibunWariKbn WARIAI050 = new C_TumitatekinHaibunWariKbn("050");

    public static final C_TumitatekinHaibunWariKbn WARIAI060 = new C_TumitatekinHaibunWariKbn("060");

    public static final C_TumitatekinHaibunWariKbn WARIAI070 = new C_TumitatekinHaibunWariKbn("070");

    public static final C_TumitatekinHaibunWariKbn WARIAI080 = new C_TumitatekinHaibunWariKbn("080");

    public static final C_TumitatekinHaibunWariKbn WARIAI090 = new C_TumitatekinHaibunWariKbn("090");

    public static final C_TumitatekinHaibunWariKbn WARIAI100 = new C_TumitatekinHaibunWariKbn("100");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, WARIAI000, "WARIAI000", false);
        addPattern(PATTERN_DEFAULT, WARIAI010, "WARIAI010", false);
        addPattern(PATTERN_DEFAULT, WARIAI020, "WARIAI020", false);
        addPattern(PATTERN_DEFAULT, WARIAI030, "WARIAI030", false);
        addPattern(PATTERN_DEFAULT, WARIAI040, "WARIAI040", false);
        addPattern(PATTERN_DEFAULT, WARIAI050, "WARIAI050", false);
        addPattern(PATTERN_DEFAULT, WARIAI060, "WARIAI060", false);
        addPattern(PATTERN_DEFAULT, WARIAI070, "WARIAI070", false);
        addPattern(PATTERN_DEFAULT, WARIAI080, "WARIAI080", false);
        addPattern(PATTERN_DEFAULT, WARIAI090, "WARIAI090", false);
        addPattern(PATTERN_DEFAULT, WARIAI100, "WARIAI100", false);


        lock(C_TumitatekinHaibunWariKbn.class);
    }

    private C_TumitatekinHaibunWariKbn(String value) {
        super(value);
    }

    public static C_TumitatekinHaibunWariKbn valueOf(String value) {
        return valueOf(C_TumitatekinHaibunWariKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TumitatekinHaibunWariKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TumitatekinHaibunWariKbn.class, patternId, value);
    }
}
