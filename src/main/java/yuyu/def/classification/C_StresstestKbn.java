
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ストレステスト区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_StresstestKbn</td><td colspan="3">ストレステスト区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="17">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NYINKBN}</td><td>&quot;1&quot;</td><td>入院保険区分</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TYONYINKBN}</td><td>&quot;2&quot;</td><td>長期入院保険区分</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IRYOUSYUUSINKBN}</td><td>&quot;3&quot;</td><td>医療終身保険(無解約返戻金型)区分</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GNTIKKTIRYOUSYUUSINKBN}</td><td>&quot;4&quot;</td><td>限定告知型医療終身保険(無解約返戻金型)区分</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JYOSEISIPNYINTKKBN}</td><td>&quot;51&quot;</td><td>女性疾病入院特約区分</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SKTSYUUKANNYINTKKBN}</td><td>&quot;52&quot;</td><td>生活習慣病入院特約区分</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUJYUTUTKKBN}</td><td>&quot;53&quot;</td><td>手術特約区分</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GANIRYOUTKKBN}</td><td>&quot;54&quot;</td><td>がん医療特約区分</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SENSINIRYOUTKKBN}</td><td>&quot;55&quot;</td><td>先進医療特約区分</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITIJIGANSENSINIRYOUTKKBN}</td><td>&quot;56&quot;</td><td>一時払がん先進医療終身特約区分</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GANSDNTKKBN}</td><td>&quot;57&quot;</td><td>がん診断特約区分</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KGANZTRYTKKBN}</td><td>&quot;58&quot;</td><td>抗がん剤（腫瘍用薬）治療特約区分</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NANADAISKTSYUUKANNYINTKKBN}</td><td>&quot;59&quot;</td><td>７大生活習慣病入院特約区分</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GANNYINTKKBN}</td><td>&quot;60&quot;</td><td>がん入院特約区分</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GNTIKKTSENSINIRYOUTKKBN}</td><td>&quot;61&quot;</td><td>限定告知型先進医療特約区分</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SANDAISIPPMNJTOKKBN}</td><td>&quot;91&quot;</td><td>３大疾病保険料払込免除特約区分</td></tr>
 * </table>
 */
public class C_StresstestKbn extends Classification<C_StresstestKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_StresstestKbn BLNK = new C_StresstestKbn("0");

    public static final C_StresstestKbn NYINKBN = new C_StresstestKbn("1");

    public static final C_StresstestKbn TYONYINKBN = new C_StresstestKbn("2");

    public static final C_StresstestKbn IRYOUSYUUSINKBN = new C_StresstestKbn("3");

    public static final C_StresstestKbn GNTIKKTIRYOUSYUUSINKBN = new C_StresstestKbn("4");

    public static final C_StresstestKbn JYOSEISIPNYINTKKBN = new C_StresstestKbn("51");

    public static final C_StresstestKbn SKTSYUUKANNYINTKKBN = new C_StresstestKbn("52");

    public static final C_StresstestKbn SYUJYUTUTKKBN = new C_StresstestKbn("53");

    public static final C_StresstestKbn GANIRYOUTKKBN = new C_StresstestKbn("54");

    public static final C_StresstestKbn SENSINIRYOUTKKBN = new C_StresstestKbn("55");

    public static final C_StresstestKbn ITIJIGANSENSINIRYOUTKKBN = new C_StresstestKbn("56");

    public static final C_StresstestKbn GANSDNTKKBN = new C_StresstestKbn("57");

    public static final C_StresstestKbn KGANZTRYTKKBN = new C_StresstestKbn("58");

    public static final C_StresstestKbn NANADAISKTSYUUKANNYINTKKBN = new C_StresstestKbn("59");

    public static final C_StresstestKbn GANNYINTKKBN = new C_StresstestKbn("60");

    public static final C_StresstestKbn GNTIKKTSENSINIRYOUTKKBN = new C_StresstestKbn("61");

    public static final C_StresstestKbn SANDAISIPPMNJTOKKBN = new C_StresstestKbn("91");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, NYINKBN, "NYINKBN", false);
        addPattern(PATTERN_DEFAULT, TYONYINKBN, "TYONYINKBN", false);
        addPattern(PATTERN_DEFAULT, IRYOUSYUUSINKBN, "IRYOUSYUUSINKBN", false);
        addPattern(PATTERN_DEFAULT, GNTIKKTIRYOUSYUUSINKBN, "GNTIKKTIRYOUSYUUSINKBN", false);
        addPattern(PATTERN_DEFAULT, JYOSEISIPNYINTKKBN, "JYOSEISIPNYINTKKBN", false);
        addPattern(PATTERN_DEFAULT, SKTSYUUKANNYINTKKBN, "SKTSYUUKANNYINTKKBN", false);
        addPattern(PATTERN_DEFAULT, SYUJYUTUTKKBN, "SYUJYUTUTKKBN", false);
        addPattern(PATTERN_DEFAULT, GANIRYOUTKKBN, "GANIRYOUTKKBN", false);
        addPattern(PATTERN_DEFAULT, SENSINIRYOUTKKBN, "SENSINIRYOUTKKBN", false);
        addPattern(PATTERN_DEFAULT, ITIJIGANSENSINIRYOUTKKBN, "ITIJIGANSENSINIRYOUTKKBN", false);
        addPattern(PATTERN_DEFAULT, GANSDNTKKBN, "GANSDNTKKBN", false);
        addPattern(PATTERN_DEFAULT, KGANZTRYTKKBN, "KGANZTRYTKKBN", false);
        addPattern(PATTERN_DEFAULT, NANADAISKTSYUUKANNYINTKKBN, "NANADAISKTSYUUKANNYINTKKBN", false);
        addPattern(PATTERN_DEFAULT, GANNYINTKKBN, "GANNYINTKKBN", false);
        addPattern(PATTERN_DEFAULT, GNTIKKTSENSINIRYOUTKKBN, "GNTIKKTSENSINIRYOUTKKBN", false);
        addPattern(PATTERN_DEFAULT, SANDAISIPPMNJTOKKBN, "SANDAISIPPMNJTOKKBN", false);


        lock(C_StresstestKbn.class);
    }

    private C_StresstestKbn(String value) {
        super(value);
    }

    public static C_StresstestKbn valueOf(String value) {
        return valueOf(C_StresstestKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_StresstestKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_StresstestKbn.class, patternId, value);
    }
}
