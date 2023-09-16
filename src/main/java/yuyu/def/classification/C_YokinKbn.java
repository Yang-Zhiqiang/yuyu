
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 預金種目区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_YokinKbn</td><td colspan="3">預金種目区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="9">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUTUU}</td><td>&quot;1&quot;</td><td>普通</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUZA}</td><td>&quot;2&quot;</td><td>当座</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TTYOKIN}</td><td>&quot;3&quot;</td><td>通知預金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TYOTIKU}</td><td>&quot;4&quot;</td><td>貯蓄</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BETUDAN}</td><td>&quot;9&quot;</td><td>別段</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUTUUYUTYO}</td><td>&quot;5&quot;</td><td>普通・ゆうちょ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEIKI}</td><td>&quot;6&quot;</td><td>定期預金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUMITATE}</td><td>&quot;7&quot;</td><td>積立定期預金</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_HKSELECT HKSELECT}<br />(保険金)</td><td align="center">&nbsp;</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUTUU}</td><td>&quot;1&quot;</td><td>普通</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUZA}</td><td>&quot;2&quot;</td><td>当座</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_NOMRF NOMRF}<br />(MRFなし)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUTUU}</td><td>&quot;1&quot;</td><td>普通</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUZA}</td><td>&quot;2&quot;</td><td>当座</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_SELECT SELECT}<br />(選択)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUTUU}</td><td>&quot;1&quot;</td><td>普通</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUZA}</td><td>&quot;2&quot;</td><td>当座</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_SKSELECT SKSELECT}<br />(新契約)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUTUU}</td><td>&quot;1&quot;</td><td>普通</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUZA}</td><td>&quot;2&quot;</td><td>当座</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_SKSEL_KZ SKSEL_KZ}<br />(口座情報入力)</td><td align="center">○</td><td>{@link #HUTUU}</td><td>&quot;1&quot;</td><td>普通</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUZA}</td><td>&quot;2&quot;</td><td>当座</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_TYOUHYOU TYOUHYOU}<br />(帳票用)</td><td align="center">&nbsp;</td><td>{@link #HUTUU}</td><td>&quot;1&quot;</td><td>普通預金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUZA}</td><td>&quot;2&quot;</td><td>当座預金</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_HUHOYOFURIINFO HUHOYOFURIINFO}<br />(普保預振情報)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUTUU}</td><td>&quot;1&quot;</td><td>普通</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUZA}</td><td>&quot;2&quot;</td><td>当座</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BETUDAN}</td><td>&quot;9&quot;</td><td>その他</td></tr>
 * </table>
 */
public class C_YokinKbn extends Classification<C_YokinKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_YokinKbn BLNK = new C_YokinKbn("0");

    public static final C_YokinKbn HUTUU = new C_YokinKbn("1");

    public static final C_YokinKbn TOUZA = new C_YokinKbn("2");

    public static final C_YokinKbn TTYOKIN = new C_YokinKbn("3");

    public static final C_YokinKbn TYOTIKU = new C_YokinKbn("4");

    public static final C_YokinKbn BETUDAN = new C_YokinKbn("9");

    public static final C_YokinKbn HUTUUYUTYO = new C_YokinKbn("5");

    public static final C_YokinKbn TEIKI = new C_YokinKbn("6");

    public static final C_YokinKbn TUMITATE = new C_YokinKbn("7");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_HKSELECT = "2";

    public static final String PATTERN_NOMRF = "3";

    public static final String PATTERN_SELECT = "4";

    public static final String PATTERN_SKSELECT = "5";

    public static final String PATTERN_SKSEL_KZ = "6";

    public static final String PATTERN_TYOUHYOU = "7";

    public static final String PATTERN_HUHOYOFURIINFO = "8";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HUTUU, "HUTUU", false);
        addPattern(PATTERN_DEFAULT, TOUZA, "TOUZA", false);
        addPattern(PATTERN_DEFAULT, TTYOKIN, "TTYOKIN", false);
        addPattern(PATTERN_DEFAULT, TYOTIKU, "TYOTIKU", false);
        addPattern(PATTERN_DEFAULT, BETUDAN, "BETUDAN", false);
        addPattern(PATTERN_DEFAULT, HUTUUYUTYO, "HUTUUYUTYO", false);
        addPattern(PATTERN_DEFAULT, TEIKI, "TEIKI", false);
        addPattern(PATTERN_DEFAULT, TUMITATE, "TUMITATE", false);


        addPattern(PATTERN_HKSELECT, BLNK, "BLNK", false);
        addPattern(PATTERN_HKSELECT, HUTUU, "HUTUU", false);
        addPattern(PATTERN_HKSELECT, TOUZA, "TOUZA", false);


        addPattern(PATTERN_NOMRF, BLNK, "BLNK", true);
        addPattern(PATTERN_NOMRF, HUTUU, "HUTUU", false);
        addPattern(PATTERN_NOMRF, TOUZA, "TOUZA", false);


        addPattern(PATTERN_SELECT, BLNK, "BLNK", true);
        addPattern(PATTERN_SELECT, HUTUU, "HUTUU", false);
        addPattern(PATTERN_SELECT, TOUZA, "TOUZA", false);


        addPattern(PATTERN_SKSELECT, BLNK, "BLNK", true);
        addPattern(PATTERN_SKSELECT, HUTUU, "HUTUU", false);
        addPattern(PATTERN_SKSELECT, TOUZA, "TOUZA", false);


        addPattern(PATTERN_SKSEL_KZ, HUTUU, "HUTUU", true);
        addPattern(PATTERN_SKSEL_KZ, TOUZA, "TOUZA", false);


        addPattern(PATTERN_TYOUHYOU, HUTUU, "HUTUU", false);
        addPattern(PATTERN_TYOUHYOU, TOUZA, "TOUZA", false);


        addPattern(PATTERN_HUHOYOFURIINFO, BLNK, "BLNK", true);
        addPattern(PATTERN_HUHOYOFURIINFO, HUTUU, "HUTUU", false);
        addPattern(PATTERN_HUHOYOFURIINFO, TOUZA, "TOUZA", false);
        addPattern(PATTERN_HUHOYOFURIINFO, BETUDAN, "BETUDAN", false);


        lock(C_YokinKbn.class);
    }

    private C_YokinKbn(String value) {
        super(value);
    }

    public static C_YokinKbn valueOf(String value) {
        return valueOf(C_YokinKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_YokinKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_YokinKbn.class, patternId, value);
    }
}
