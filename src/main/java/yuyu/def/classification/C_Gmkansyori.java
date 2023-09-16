
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 画面間処理区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Gmkansyori</td><td colspan="3">画面間処理区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="13">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #TRKKYK}</td><td>&quot;trkKyk&quot;</td><td>契約者登録</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TRKHHKN}</td><td>&quot;trkHhkn&quot;</td><td>被保険者登録</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TRKDAI}</td><td>&quot;trkDai&quot;</td><td>代表者登録</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UPDKYK}</td><td>&quot;updKyk&quot;</td><td>契約者修正</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UPDHHKN}</td><td>&quot;updHhkn&quot;</td><td>被保険者修正</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TRKKOK}</td><td>&quot;trkKok&quot;</td><td>顧客情報登録</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SRCHKYK}</td><td>&quot;srchKyk&quot;</td><td>契約者検索</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SRCHHHKN}</td><td>&quot;srchHhkn&quot;</td><td>被保険者検索</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SRCHDAIKZK}</td><td>&quot;srchDaiKzk&quot;</td><td>代表家族検索</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SRCHDAI}</td><td>&quot;srchDai&quot;</td><td>代表者検索</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SRCHSIMEKIRIBI}</td><td>&quot;srchSime&quot;</td><td>締切日検索</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HYOKYH}</td><td>&quot;hyoKyh&quot;</td><td>給付事例表示</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAKEMOS}</td><td>&quot;makeMos&quot;</td><td>申込書作成</td></tr>
 * </table>
 */
public class C_Gmkansyori extends Classification<C_Gmkansyori> {

    private static final long serialVersionUID = 1L;


    public static final C_Gmkansyori TRKKYK = new C_Gmkansyori("trkKyk");

    public static final C_Gmkansyori TRKHHKN = new C_Gmkansyori("trkHhkn");

    public static final C_Gmkansyori TRKDAI = new C_Gmkansyori("trkDai");

    public static final C_Gmkansyori UPDKYK = new C_Gmkansyori("updKyk");

    public static final C_Gmkansyori UPDHHKN = new C_Gmkansyori("updHhkn");

    public static final C_Gmkansyori TRKKOK = new C_Gmkansyori("trkKok");

    public static final C_Gmkansyori SRCHKYK = new C_Gmkansyori("srchKyk");

    public static final C_Gmkansyori SRCHHHKN = new C_Gmkansyori("srchHhkn");

    public static final C_Gmkansyori SRCHDAIKZK = new C_Gmkansyori("srchDaiKzk");

    public static final C_Gmkansyori SRCHDAI = new C_Gmkansyori("srchDai");

    public static final C_Gmkansyori SRCHSIMEKIRIBI = new C_Gmkansyori("srchSime");

    public static final C_Gmkansyori HYOKYH = new C_Gmkansyori("hyoKyh");

    public static final C_Gmkansyori MAKEMOS = new C_Gmkansyori("makeMos");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, TRKKYK, "TRKKYK", true);
        addPattern(PATTERN_DEFAULT, TRKHHKN, "TRKHHKN", false);
        addPattern(PATTERN_DEFAULT, TRKDAI, "TRKDAI", false);
        addPattern(PATTERN_DEFAULT, UPDKYK, "UPDKYK", false);
        addPattern(PATTERN_DEFAULT, UPDHHKN, "UPDHHKN", false);
        addPattern(PATTERN_DEFAULT, TRKKOK, "TRKKOK", false);
        addPattern(PATTERN_DEFAULT, SRCHKYK, "SRCHKYK", false);
        addPattern(PATTERN_DEFAULT, SRCHHHKN, "SRCHHHKN", false);
        addPattern(PATTERN_DEFAULT, SRCHDAIKZK, "SRCHDAIKZK", false);
        addPattern(PATTERN_DEFAULT, SRCHDAI, "SRCHDAI", false);
        addPattern(PATTERN_DEFAULT, SRCHSIMEKIRIBI, "SRCHSIMEKIRIBI", false);
        addPattern(PATTERN_DEFAULT, HYOKYH, "HYOKYH", false);
        addPattern(PATTERN_DEFAULT, MAKEMOS, "MAKEMOS", false);


        lock(C_Gmkansyori.class);
    }

    private C_Gmkansyori(String value) {
        super(value);
    }

    public static C_Gmkansyori valueOf(String value) {
        return valueOf(C_Gmkansyori.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Gmkansyori.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Gmkansyori.class, patternId, value);
    }
}
