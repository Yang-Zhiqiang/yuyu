
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 特殊取扱基準区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Tksytratkikjn</td><td colspan="3">特殊取扱基準区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAITEIP_KJNKANWA}</td><td>&quot;01&quot;</td><td>最低Ｐ基準緩和</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_SELECT SELECT}<br />(画面表示用)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAITEIP_KJNKANWA}</td><td>&quot;01&quot;</td><td>最低Ｐ条件：「既契約あり」または「同時申込」</td></tr>
 * </table>
 */
public class C_Tksytratkikjn extends Classification<C_Tksytratkikjn> {

    private static final long serialVersionUID = 1L;


    public static final C_Tksytratkikjn BLNK = new C_Tksytratkikjn("0");

    public static final C_Tksytratkikjn SAITEIP_KJNKANWA = new C_Tksytratkikjn("01");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SAITEIP_KJNKANWA, "SAITEIP_KJNKANWA", false);


        addPattern(PATTERN_SELECT, BLNK, "BLNK", true);
        addPattern(PATTERN_SELECT, SAITEIP_KJNKANWA, "SAITEIP_KJNKANWA", false);


        lock(C_Tksytratkikjn.class);
    }

    private C_Tksytratkikjn(String value) {
        super(value);
    }

    public static C_Tksytratkikjn valueOf(String value) {
        return valueOf(C_Tksytratkikjn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Tksytratkikjn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Tksytratkikjn.class, patternId, value);
    }
}
