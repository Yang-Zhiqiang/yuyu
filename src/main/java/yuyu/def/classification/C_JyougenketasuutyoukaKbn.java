
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 上限桁数超過区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_JyougenketasuutyoukaKbn</td><td colspan="3">上限桁数超過区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #JYOUGENNAI}</td><td>&quot;0&quot;</td><td>上限桁数内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CYOUKA}</td><td>&quot;1&quot;</td><td>上限桁数超過</td></tr>
 * </table>
 */
public class C_JyougenketasuutyoukaKbn extends Classification<C_JyougenketasuutyoukaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_JyougenketasuutyoukaKbn JYOUGENNAI = new C_JyougenketasuutyoukaKbn("0");

    public static final C_JyougenketasuutyoukaKbn CYOUKA = new C_JyougenketasuutyoukaKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, JYOUGENNAI, "JYOUGENNAI", true);
        addPattern(PATTERN_DEFAULT, CYOUKA, "CYOUKA", false);


        lock(C_JyougenketasuutyoukaKbn.class);
    }

    private C_JyougenketasuutyoukaKbn(String value) {
        super(value);
    }

    public static C_JyougenketasuutyoukaKbn valueOf(String value) {
        return valueOf(C_JyougenketasuutyoukaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_JyougenketasuutyoukaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_JyougenketasuutyoukaKbn.class, patternId, value);
    }
}
