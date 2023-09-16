
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 入力区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_NyuuryokuKbn</td><td colspan="3">入力区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="9">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #YUUTYO_MT}</td><td>&quot;0&quot;</td><td>郵貯ＭＴ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OCR}</td><td>&quot;1&quot;</td><td>ＯＣＲ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PANTI}</td><td>&quot;2&quot;</td><td>パンチ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OTHER}</td><td>&quot;3&quot;</td><td>その他</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ONLINENYUUKIN}</td><td>&quot;4&quot;</td><td>オンライン入金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CONVENI}</td><td>&quot;5&quot;</td><td>コンビニ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PAY_EASY_MQ}</td><td>&quot;6&quot;</td><td>ペイジー（ＭＱ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PAY_EASY_HULFT}</td><td>&quot;7&quot;</td><td>ペイジー（ＨＵＬＦＴ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HONSYAKOUZAHRKM}</td><td>&quot;9&quot;</td><td>本社口座振込分</td></tr>
 * </table>
 */
public class C_NyuuryokuKbn extends Classification<C_NyuuryokuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_NyuuryokuKbn YUUTYO_MT = new C_NyuuryokuKbn("0");

    public static final C_NyuuryokuKbn OCR = new C_NyuuryokuKbn("1");

    public static final C_NyuuryokuKbn PANTI = new C_NyuuryokuKbn("2");

    public static final C_NyuuryokuKbn OTHER = new C_NyuuryokuKbn("3");

    public static final C_NyuuryokuKbn ONLINENYUUKIN = new C_NyuuryokuKbn("4");

    public static final C_NyuuryokuKbn CONVENI = new C_NyuuryokuKbn("5");

    public static final C_NyuuryokuKbn PAY_EASY_MQ = new C_NyuuryokuKbn("6");

    public static final C_NyuuryokuKbn PAY_EASY_HULFT = new C_NyuuryokuKbn("7");

    public static final C_NyuuryokuKbn HONSYAKOUZAHRKM = new C_NyuuryokuKbn("9");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, YUUTYO_MT, "YUUTYO_MT", true);
        addPattern(PATTERN_DEFAULT, OCR, "OCR", false);
        addPattern(PATTERN_DEFAULT, PANTI, "PANTI", false);
        addPattern(PATTERN_DEFAULT, OTHER, "OTHER", false);
        addPattern(PATTERN_DEFAULT, ONLINENYUUKIN, "ONLINENYUUKIN", false);
        addPattern(PATTERN_DEFAULT, CONVENI, "CONVENI", false);
        addPattern(PATTERN_DEFAULT, PAY_EASY_MQ, "PAY_EASY_MQ", false);
        addPattern(PATTERN_DEFAULT, PAY_EASY_HULFT, "PAY_EASY_HULFT", false);
        addPattern(PATTERN_DEFAULT, HONSYAKOUZAHRKM, "HONSYAKOUZAHRKM", false);


        lock(C_NyuuryokuKbn.class);
    }

    private C_NyuuryokuKbn(String value) {
        super(value);
    }

    public static C_NyuuryokuKbn valueOf(String value) {
        return valueOf(C_NyuuryokuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_NyuuryokuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_NyuuryokuKbn.class, patternId, value);
    }
}
