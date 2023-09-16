
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 法人形態区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HjnktaiKbn</td><td colspan="3">法人形態区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="14">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KABUSIKI}</td><td>&quot;1&quot;</td><td>株式会社</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUUGEN}</td><td>&quot;2&quot;</td><td>有限会社</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GOUMEI}</td><td>&quot;3&quot;</td><td>合名会社</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GOUSI}</td><td>&quot;4&quot;</td><td>合資会社</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IRYO_HJN}</td><td>&quot;5&quot;</td><td>医療法人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZAIDAN_HJN}</td><td>&quot;6&quot;</td><td>財団法人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYADAN_HJN}</td><td>&quot;7&quot;</td><td>社団法人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUUKYO_HJN}</td><td>&quot;8&quot;</td><td>宗教法人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAKKO_HJN}</td><td>&quot;9&quot;</td><td>学校法人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYAKAIHUKUSI_HJN}</td><td>&quot;10&quot;</td><td>社会福祉法人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOUGO}</td><td>&quot;11&quot;</td><td>相互会社</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #EIGYOUSYO}</td><td>&quot;12&quot;</td><td>営業所</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUTTYOUSYO}</td><td>&quot;13&quot;</td><td>出張所</td></tr>
 * </table>
 */
public class C_HjnktaiKbn extends Classification<C_HjnktaiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HjnktaiKbn BLNK = new C_HjnktaiKbn("0");

    public static final C_HjnktaiKbn KABUSIKI = new C_HjnktaiKbn("1");

    public static final C_HjnktaiKbn YUUGEN = new C_HjnktaiKbn("2");

    public static final C_HjnktaiKbn GOUMEI = new C_HjnktaiKbn("3");

    public static final C_HjnktaiKbn GOUSI = new C_HjnktaiKbn("4");

    public static final C_HjnktaiKbn IRYO_HJN = new C_HjnktaiKbn("5");

    public static final C_HjnktaiKbn ZAIDAN_HJN = new C_HjnktaiKbn("6");

    public static final C_HjnktaiKbn SYADAN_HJN = new C_HjnktaiKbn("7");

    public static final C_HjnktaiKbn SYUUKYO_HJN = new C_HjnktaiKbn("8");

    public static final C_HjnktaiKbn GAKKO_HJN = new C_HjnktaiKbn("9");

    public static final C_HjnktaiKbn SYAKAIHUKUSI_HJN = new C_HjnktaiKbn("10");

    public static final C_HjnktaiKbn SOUGO = new C_HjnktaiKbn("11");

    public static final C_HjnktaiKbn EIGYOUSYO = new C_HjnktaiKbn("12");

    public static final C_HjnktaiKbn SYUTTYOUSYO = new C_HjnktaiKbn("13");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KABUSIKI, "KABUSIKI", false);
        addPattern(PATTERN_DEFAULT, YUUGEN, "YUUGEN", false);
        addPattern(PATTERN_DEFAULT, GOUMEI, "GOUMEI", false);
        addPattern(PATTERN_DEFAULT, GOUSI, "GOUSI", false);
        addPattern(PATTERN_DEFAULT, IRYO_HJN, "IRYO_HJN", false);
        addPattern(PATTERN_DEFAULT, ZAIDAN_HJN, "ZAIDAN_HJN", false);
        addPattern(PATTERN_DEFAULT, SYADAN_HJN, "SYADAN_HJN", false);
        addPattern(PATTERN_DEFAULT, SYUUKYO_HJN, "SYUUKYO_HJN", false);
        addPattern(PATTERN_DEFAULT, GAKKO_HJN, "GAKKO_HJN", false);
        addPattern(PATTERN_DEFAULT, SYAKAIHUKUSI_HJN, "SYAKAIHUKUSI_HJN", false);
        addPattern(PATTERN_DEFAULT, SOUGO, "SOUGO", false);
        addPattern(PATTERN_DEFAULT, EIGYOUSYO, "EIGYOUSYO", false);
        addPattern(PATTERN_DEFAULT, SYUTTYOUSYO, "SYUTTYOUSYO", false);


        lock(C_HjnktaiKbn.class);
    }

    private C_HjnktaiKbn(String value) {
        super(value);
    }

    public static C_HjnktaiKbn valueOf(String value) {
        return valueOf(C_HjnktaiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HjnktaiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HjnktaiKbn.class, patternId, value);
    }
}
