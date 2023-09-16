
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 案内収納用帳票記号区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_AsTyouhyoukigouKbn</td><td colspan="3">案内収納用帳票記号区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="11">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_KOUHURIKAISIANNAI}</td><td>&quot;ﾕ01&quot;</td><td>口座振替開始案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_KIJITUTOURAIANNAI}</td><td>&quot;ﾕ02&quot;</td><td>期日到来案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_KZHENKINTUUTI}</td><td>&quot;ﾕ03&quot;</td><td>口座返金通知</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_KZHURIKOMITUUTI}</td><td>&quot;ﾕ04&quot;</td><td>口座振込通知</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_KOUHURIMINYUUTUUTI}</td><td>&quot;ﾕ05&quot;</td><td>未入通知（口座振替）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_HRHNKANRYOTUUTI_DNP}</td><td>&quot;ﾕ06&quot;</td><td>払変完了通知（ＤＮＰ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KOUJYOSYOUMEIS_GAIBU}</td><td>&quot;ﾕ07&quot;</td><td>控除証明書≪外部印刷≫</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_SAIKOKUTUUTI}</td><td>&quot;ﾕ08&quot;</td><td>催告通知</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_CREDITHENKINTUUTI}</td><td>&quot;ﾕ09&quot;</td><td>クレカ返金通知</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AS_SINKOKUYOKOKUTUUTI}</td><td>&quot;ﾕ10&quot;</td><td>申告予告通知</td></tr>
 * </table>
 */
public class C_AsTyouhyoukigouKbn extends Classification<C_AsTyouhyoukigouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_AsTyouhyoukigouKbn BLNK = new C_AsTyouhyoukigouKbn("0");

    public static final C_AsTyouhyoukigouKbn AS_KOUHURIKAISIANNAI = new C_AsTyouhyoukigouKbn("ﾕ01");

    public static final C_AsTyouhyoukigouKbn AS_KIJITUTOURAIANNAI = new C_AsTyouhyoukigouKbn("ﾕ02");

    public static final C_AsTyouhyoukigouKbn AS_KZHENKINTUUTI = new C_AsTyouhyoukigouKbn("ﾕ03");

    public static final C_AsTyouhyoukigouKbn AS_KZHURIKOMITUUTI = new C_AsTyouhyoukigouKbn("ﾕ04");

    public static final C_AsTyouhyoukigouKbn AS_KOUHURIMINYUUTUUTI = new C_AsTyouhyoukigouKbn("ﾕ05");

    public static final C_AsTyouhyoukigouKbn AS_HRHNKANRYOTUUTI_DNP = new C_AsTyouhyoukigouKbn("ﾕ06");

    public static final C_AsTyouhyoukigouKbn KK_KOUJYOSYOUMEIS_GAIBU = new C_AsTyouhyoukigouKbn("ﾕ07");

    public static final C_AsTyouhyoukigouKbn AS_SAIKOKUTUUTI = new C_AsTyouhyoukigouKbn("ﾕ08");

    public static final C_AsTyouhyoukigouKbn AS_CREDITHENKINTUUTI = new C_AsTyouhyoukigouKbn("ﾕ09");

    public static final C_AsTyouhyoukigouKbn AS_SINKOKUYOKOKUTUUTI = new C_AsTyouhyoukigouKbn("ﾕ10");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, AS_KOUHURIKAISIANNAI, "AS_KOUHURIKAISIANNAI", false);
        addPattern(PATTERN_DEFAULT, AS_KIJITUTOURAIANNAI, "AS_KIJITUTOURAIANNAI", false);
        addPattern(PATTERN_DEFAULT, AS_KZHENKINTUUTI, "AS_KZHENKINTUUTI", false);
        addPattern(PATTERN_DEFAULT, AS_KZHURIKOMITUUTI, "AS_KZHURIKOMITUUTI", false);
        addPattern(PATTERN_DEFAULT, AS_KOUHURIMINYUUTUUTI, "AS_KOUHURIMINYUUTUUTI", false);
        addPattern(PATTERN_DEFAULT, AS_HRHNKANRYOTUUTI_DNP, "AS_HRHNKANRYOTUUTI_DNP", false);
        addPattern(PATTERN_DEFAULT, KK_KOUJYOSYOUMEIS_GAIBU, "KK_KOUJYOSYOUMEIS_GAIBU", false);
        addPattern(PATTERN_DEFAULT, AS_SAIKOKUTUUTI, "AS_SAIKOKUTUUTI", false);
        addPattern(PATTERN_DEFAULT, AS_CREDITHENKINTUUTI, "AS_CREDITHENKINTUUTI", false);
        addPattern(PATTERN_DEFAULT, AS_SINKOKUYOKOKUTUUTI, "AS_SINKOKUYOKOKUTUUTI", false);


        lock(C_AsTyouhyoukigouKbn.class);
    }

    private C_AsTyouhyoukigouKbn(String value) {
        super(value);
    }

    public static C_AsTyouhyoukigouKbn valueOf(String value) {
        return valueOf(C_AsTyouhyoukigouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_AsTyouhyoukigouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_AsTyouhyoukigouKbn.class, patternId, value);
    }
}
