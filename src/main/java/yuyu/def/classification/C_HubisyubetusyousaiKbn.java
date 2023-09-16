
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 不備種別詳細区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HubisyubetusyousaiKbn</td><td colspan="3">不備種別詳細区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="7">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;00&quot;</td><td>分類なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SPHUBI}</td><td>&quot;01&quot;</td><td>ＳＰ不備</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SSEIGENHUBI}</td><td>&quot;02&quot;</td><td>Ｓ制限不備</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUUSANGENDOOVER}</td><td>&quot;03&quot;</td><td>通算限度オーバー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEIYMDHUBI}</td><td>&quot;04&quot;</td><td>生年月日不備</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUHURIKZMEIGIKYKBETUHUBI}</td><td>&quot;05&quot;</td><td>口座振替口座名義人契約者別人不備</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DEBITNYKKZMEIGIKYKBETUHUBI}</td><td>&quot;06&quot;</td><td>デビット入金口座名義人契約者別人不備</td></tr>
 * </table>
 */
public class C_HubisyubetusyousaiKbn extends Classification<C_HubisyubetusyousaiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HubisyubetusyousaiKbn NONE = new C_HubisyubetusyousaiKbn("00");

    public static final C_HubisyubetusyousaiKbn SPHUBI = new C_HubisyubetusyousaiKbn("01");

    public static final C_HubisyubetusyousaiKbn SSEIGENHUBI = new C_HubisyubetusyousaiKbn("02");

    public static final C_HubisyubetusyousaiKbn TUUSANGENDOOVER = new C_HubisyubetusyousaiKbn("03");

    public static final C_HubisyubetusyousaiKbn SEIYMDHUBI = new C_HubisyubetusyousaiKbn("04");

    public static final C_HubisyubetusyousaiKbn KOUHURIKZMEIGIKYKBETUHUBI = new C_HubisyubetusyousaiKbn("05");

    public static final C_HubisyubetusyousaiKbn DEBITNYKKZMEIGIKYKBETUHUBI = new C_HubisyubetusyousaiKbn("06");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, SPHUBI, "SPHUBI", false);
        addPattern(PATTERN_DEFAULT, SSEIGENHUBI, "SSEIGENHUBI", false);
        addPattern(PATTERN_DEFAULT, TUUSANGENDOOVER, "TUUSANGENDOOVER", false);
        addPattern(PATTERN_DEFAULT, SEIYMDHUBI, "SEIYMDHUBI", false);
        addPattern(PATTERN_DEFAULT, KOUHURIKZMEIGIKYKBETUHUBI, "KOUHURIKZMEIGIKYKBETUHUBI", false);
        addPattern(PATTERN_DEFAULT, DEBITNYKKZMEIGIKYKBETUHUBI, "DEBITNYKKZMEIGIKYKBETUHUBI", false);


        lock(C_HubisyubetusyousaiKbn.class);
    }

    private C_HubisyubetusyousaiKbn(String value) {
        super(value);
    }

    public static C_HubisyubetusyousaiKbn valueOf(String value) {
        return valueOf(C_HubisyubetusyousaiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HubisyubetusyousaiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HubisyubetusyousaiKbn.class, patternId, value);
    }
}
