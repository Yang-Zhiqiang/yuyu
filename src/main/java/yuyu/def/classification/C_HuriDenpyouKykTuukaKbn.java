
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 振替伝票用契約通貨区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HuriDenpyouKykTuukaKbn</td><td colspan="3">振替伝票用契約通貨区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #ENKA}</td><td>&quot;1&quot;</td><td>円貨</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKA}</td><td>&quot;2&quot;</td><td>外貨</td></tr>
 * </table>
 */
public class C_HuriDenpyouKykTuukaKbn extends Classification<C_HuriDenpyouKykTuukaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HuriDenpyouKykTuukaKbn ENKA = new C_HuriDenpyouKykTuukaKbn("1");

    public static final C_HuriDenpyouKykTuukaKbn GAIKA = new C_HuriDenpyouKykTuukaKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, ENKA, "ENKA", true);
        addPattern(PATTERN_DEFAULT, GAIKA, "GAIKA", false);


        lock(C_HuriDenpyouKykTuukaKbn.class);
    }

    private C_HuriDenpyouKykTuukaKbn(String value) {
        super(value);
    }

    public static C_HuriDenpyouKykTuukaKbn valueOf(String value) {
        return valueOf(C_HuriDenpyouKykTuukaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HuriDenpyouKykTuukaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HuriDenpyouKykTuukaKbn.class, patternId, value);
    }
}
