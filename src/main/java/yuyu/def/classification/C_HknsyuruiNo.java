
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 保険種類番号 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HknsyuruiNo</td><td colspan="3">保険種類番号</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="15">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;000&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU}</td><td>&quot;441&quot;</td><td>外貨建て一時払終身保険（即時保障型）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAITIJIBRISYUUSIN_MAITOSIUKT}</td><td>&quot;442&quot;</td><td>外貨建て一時払終身保険（毎年受取型）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAITIJIBRIHENGAKUNK_BLEND}</td><td>&quot;443&quot;</td><td>外貨建て一時払変額年金保険（ブレンド型）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAITIJIBRISYUUSIN_YOKUSEI}</td><td>&quot;444&quot;</td><td>５年ごと利差配当付指定通貨建終身保険（一時払い）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAITIJIBRISYUUSIN_19_SGARI}</td><td>&quot;445&quot;</td><td>５年ごと利差配当付指定通貨建終身保険（一時払い）（１９）Ⅱ型</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAITIJIBRISYUUSIN_19_SGNASI}</td><td>&quot;446&quot;</td><td>５年ごと利差配当付指定通貨建終身保険（一時払い）（１９）Ⅰ型</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEIKAIYAKUHRKNSYSN_YENDT}</td><td>&quot;357&quot;</td><td>低解約返戻金型５年ごと利差配当付選択通貨建特別終身保険</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEIKAIYAKUHRKNSYSN_USDDT}</td><td>&quot;358&quot;</td><td>低解約返戻金型５年ごと利差配当付選択通貨建特別終身保険</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK}</td><td>&quot;321&quot;</td><td>５年ごと利差配当付指定通貨建個人年金保険（一時払い）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_SISUU}</td><td>&quot;322&quot;</td><td>５年ごと利差配当付指定通貨建個人年金保険（一時払い）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_TEIRITU}</td><td>&quot;323&quot;</td><td>５年ごと利差配当付指定通貨建個人年金保険（一時払い）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_20_SISUU}</td><td>&quot;324&quot;</td><td>５年ごと利差配当付指定通貨建個人年金保険（一時払い）（２０）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_20_TEIRITUTEIKI}</td><td>&quot;325&quot;</td><td>５年ごと利差配当付指定通貨建個人年金保険（一時払い）（２０）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKARIRITUHENDOUNK}</td><td>&quot;331&quot;</td><td>予定利率変動型５年ごと利差配当付指定通貨建個人年金保険</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_NOBLNK NOBLNK}<br />(ブランクなし)</td><td align="center">&nbsp;</td><td>{@link #GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU}</td><td>&quot;441&quot;</td><td>外貨建て一時払終身保険（即時保障型）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAITIJIBRISYUUSIN_MAITOSIUKT}</td><td>&quot;442&quot;</td><td>外貨建て一時払終身保険（毎年受取型）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAITIJIBRIHENGAKUNK_BLEND}</td><td>&quot;443&quot;</td><td>外貨建て一時払変額年金保険（ブレンド型）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAITIJIBRISYUUSIN_YOKUSEI}</td><td>&quot;444&quot;</td><td>５年ごと利差配当付指定通貨建終身保険（一時払い）</td></tr>
 *  <tr><td rowspan="10">{@link #PATTERN_SKMOSSYOUKAI SKMOSSYOUKAI}<br />(申込状況照会)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;000&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAITIJIBRISYUUSIN_YOKUSEI}</td><td>&quot;444&quot;</td><td>ふるはーとＪロードグローバル</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAITIJIBRISYUUSIN_19_SGARI}</td><td>&quot;445&quot;</td><td>ふるはーとＪロードグローバルⅡ（Ⅱ型）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_SISUU}</td><td>&quot;322&quot;</td><td>たのしみグローバル（指数連動プラン）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_TEIRITU}</td><td>&quot;323&quot;</td><td>たのしみグローバル（定率増加プラン）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_20_SISUU}</td><td>&quot;324&quot;</td><td>たのしみグローバルⅡ（指数連動プラン）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_20_TEIRITUTEIKI}</td><td>&quot;325&quot;</td><td>たのしみグローバルⅡ（定率増加・定期支払プラン）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKARIRITUHENDOUNK}</td><td>&quot;331&quot;</td><td>たのしみ未来グローバル</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEIKAIYAKUHRKNSYSN_YENDT}</td><td>&quot;357&quot;</td><td>ふるはーとＦⅡ（円建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEIKAIYAKUHRKNSYSN_USDDT}</td><td>&quot;358&quot;</td><td>ふるはーとＦⅡ（米ドル建）</td></tr>
 *  <tr><td rowspan="10">{@link #PATTERN_QRSKSYOYAKU QRSKSYOYAKU}<br />(ＱＲ作成予約)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;000&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAITIJIBRISYUUSIN_YOKUSEI}</td><td>&quot;444&quot;</td><td>ふるはーとＪロードグローバル</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAITIJIBRISYUUSIN_19_SGARI}</td><td>&quot;445&quot;</td><td>ふるはーとＪロードグローバルⅡ（Ⅱ型）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEIKAIYAKUHRKNSYSN_YENDT}</td><td>&quot;357&quot;</td><td>ふるはーとＦⅡ（円建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEIKAIYAKUHRKNSYSN_USDDT}</td><td>&quot;358&quot;</td><td>ふるはーとＦⅡ（米ドル建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_SISUU}</td><td>&quot;322&quot;</td><td>たのしみグローバル（指数連動プラン）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_TEIRITU}</td><td>&quot;323&quot;</td><td>たのしみグローバル（定率増加プラン）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_20_SISUU}</td><td>&quot;324&quot;</td><td>たのしみグローバルⅡ（指数連動プラン）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_20_TEIRITUTEIKI}</td><td>&quot;325&quot;</td><td>たのしみグローバルⅡ（定率増加・定期支払プラン）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKARIRITUHENDOUNK}</td><td>&quot;331&quot;</td><td>たのしみ未来グローバル</td></tr>
 *  <tr><td rowspan="10">{@link #PATTERN_AISYOUMEI AISYOUMEI}<br />(愛称名)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;000&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAITIJIBRISYUUSIN_YOKUSEI}</td><td>&quot;444&quot;</td><td>ふるはーとＪロードグローバル</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAITIJIBRISYUUSIN_19_SGARI}</td><td>&quot;445&quot;</td><td>ふるはーとＪロードグローバルⅡ（Ⅱ型）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEIKAIYAKUHRKNSYSN_YENDT}</td><td>&quot;357&quot;</td><td>ふるはーとＦⅡ（円建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEIKAIYAKUHRKNSYSN_USDDT}</td><td>&quot;358&quot;</td><td>ふるはーとＦⅡ（米ドル建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_SISUU}</td><td>&quot;322&quot;</td><td>たのしみグローバル（指数連動プラン）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_TEIRITU}</td><td>&quot;323&quot;</td><td>たのしみグローバル（定率増加プラン）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_20_SISUU}</td><td>&quot;324&quot;</td><td>たのしみグローバルⅡ（指数連動）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_20_TEIRITUTEIKI}</td><td>&quot;325&quot;</td><td>たのしみグローバルⅡ（定率増加・定期支払）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKARIRITUHENDOUNK}</td><td>&quot;331&quot;</td><td>たのしみ未来グローバル</td></tr>
 *  <tr><td rowspan="10">{@link #PATTERN_SYANAIDISP SYANAIDISP}<br />(社内表示用)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;000&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAITIJIBRISYUUSIN_YOKUSEI}</td><td>&quot;444&quot;</td><td>５年ごと利差配当付指定通貨建終身保険（一時払い）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAITIJIBRISYUUSIN_19_SGARI}</td><td>&quot;445&quot;</td><td>５年ごと利差配当付指定通貨建終身保険（一時払い）（１９）Ⅱ型</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEIKAIYAKUHRKNSYSN_YENDT}</td><td>&quot;357&quot;</td><td>低解約返戻金型５年ごと利差配当付選択通貨建特別終身保険（円建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEIKAIYAKUHRKNSYSN_USDDT}</td><td>&quot;358&quot;</td><td>低解約返戻金型５年ごと利差配当付選択通貨建特別終身保険（米ドル建）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_SISUU}</td><td>&quot;322&quot;</td><td>５年ごと利差配当付指定通貨建個人年金保険（一時払い）（指数連動プラン）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_TEIRITU}</td><td>&quot;323&quot;</td><td>５年ごと利差配当付指定通貨建個人年金保険（一時払い）（定率増加プラン）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_20_SISUU}</td><td>&quot;324&quot;</td><td>５年ごと利差配当付指定通貨建個人年金保険（一時払い）２０（指数連動）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAINDEXNK_20_TEIRITUTEIKI}</td><td>&quot;325&quot;</td><td>５年ごと利差配当付指定通貨建個人年金保険（一時払い）２０（定率増加・定期支払）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKARIRITUHENDOUNK}</td><td>&quot;331&quot;</td><td>予定利率変動型５年ごと利差配当付指定通貨建個人年金保険</td></tr>
 * </table>
 */
public class C_HknsyuruiNo extends Classification<C_HknsyuruiNo> {

    private static final long serialVersionUID = 1L;


    public static final C_HknsyuruiNo BLNK = new C_HknsyuruiNo("000");

    public static final C_HknsyuruiNo GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU = new C_HknsyuruiNo("441");

    public static final C_HknsyuruiNo GAIKAITIJIBRISYUUSIN_MAITOSIUKT = new C_HknsyuruiNo("442");

    public static final C_HknsyuruiNo GAIKAITIJIBRIHENGAKUNK_BLEND = new C_HknsyuruiNo("443");

    public static final C_HknsyuruiNo GAIKAITIJIBRISYUUSIN_YOKUSEI = new C_HknsyuruiNo("444");

    public static final C_HknsyuruiNo GAIKAITIJIBRISYUUSIN_19_SGARI = new C_HknsyuruiNo("445");

    public static final C_HknsyuruiNo GAIKAITIJIBRISYUUSIN_19_SGNASI = new C_HknsyuruiNo("446");

    public static final C_HknsyuruiNo TEIKAIYAKUHRKNSYSN_YENDT = new C_HknsyuruiNo("357");

    public static final C_HknsyuruiNo TEIKAIYAKUHRKNSYSN_USDDT = new C_HknsyuruiNo("358");

    public static final C_HknsyuruiNo GAIKAINDEXNK = new C_HknsyuruiNo("321");

    public static final C_HknsyuruiNo GAIKAINDEXNK_SISUU = new C_HknsyuruiNo("322");

    public static final C_HknsyuruiNo GAIKAINDEXNK_TEIRITU = new C_HknsyuruiNo("323");

    public static final C_HknsyuruiNo GAIKAINDEXNK_20_SISUU = new C_HknsyuruiNo("324");

    public static final C_HknsyuruiNo GAIKAINDEXNK_20_TEIRITUTEIKI = new C_HknsyuruiNo("325");

    public static final C_HknsyuruiNo GAIKARIRITUHENDOUNK = new C_HknsyuruiNo("331");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_NOBLNK = "2";

    public static final String PATTERN_SKMOSSYOUKAI = "3";

    public static final String PATTERN_QRSKSYOYAKU = "4";

    public static final String PATTERN_AISYOUMEI = "5";

    public static final String PATTERN_SYANAIDISP = "6";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, "GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU", false);
        addPattern(PATTERN_DEFAULT, GAIKAITIJIBRISYUUSIN_MAITOSIUKT, "GAIKAITIJIBRISYUUSIN_MAITOSIUKT", false);
        addPattern(PATTERN_DEFAULT, GAIKAITIJIBRIHENGAKUNK_BLEND, "GAIKAITIJIBRIHENGAKUNK_BLEND", false);
        addPattern(PATTERN_DEFAULT, GAIKAITIJIBRISYUUSIN_YOKUSEI, "GAIKAITIJIBRISYUUSIN_YOKUSEI", false);
        addPattern(PATTERN_DEFAULT, GAIKAITIJIBRISYUUSIN_19_SGARI, "GAIKAITIJIBRISYUUSIN_19_SGARI", false);
        addPattern(PATTERN_DEFAULT, GAIKAITIJIBRISYUUSIN_19_SGNASI, "GAIKAITIJIBRISYUUSIN_19_SGNASI", false);
        addPattern(PATTERN_DEFAULT, TEIKAIYAKUHRKNSYSN_YENDT, "TEIKAIYAKUHRKNSYSN_YENDT", false);
        addPattern(PATTERN_DEFAULT, TEIKAIYAKUHRKNSYSN_USDDT, "TEIKAIYAKUHRKNSYSN_USDDT", false);
        addPattern(PATTERN_DEFAULT, GAIKAINDEXNK, "GAIKAINDEXNK", false);
        addPattern(PATTERN_DEFAULT, GAIKAINDEXNK_SISUU, "GAIKAINDEXNK_SISUU", false);
        addPattern(PATTERN_DEFAULT, GAIKAINDEXNK_TEIRITU, "GAIKAINDEXNK_TEIRITU", false);
        addPattern(PATTERN_DEFAULT, GAIKAINDEXNK_20_SISUU, "GAIKAINDEXNK_20_SISUU", false);
        addPattern(PATTERN_DEFAULT, GAIKAINDEXNK_20_TEIRITUTEIKI, "GAIKAINDEXNK_20_TEIRITUTEIKI", false);
        addPattern(PATTERN_DEFAULT, GAIKARIRITUHENDOUNK, "GAIKARIRITUHENDOUNK", false);


        addPattern(PATTERN_NOBLNK, GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU, "GAIKAITIJIBRISYUUSIN_SOKUJIHOSYOU", false);
        addPattern(PATTERN_NOBLNK, GAIKAITIJIBRISYUUSIN_MAITOSIUKT, "GAIKAITIJIBRISYUUSIN_MAITOSIUKT", false);
        addPattern(PATTERN_NOBLNK, GAIKAITIJIBRIHENGAKUNK_BLEND, "GAIKAITIJIBRIHENGAKUNK_BLEND", false);
        addPattern(PATTERN_NOBLNK, GAIKAITIJIBRISYUUSIN_YOKUSEI, "GAIKAITIJIBRISYUUSIN_YOKUSEI", false);


        addPattern(PATTERN_SKMOSSYOUKAI, BLNK, "BLNK", true);
        addPattern(PATTERN_SKMOSSYOUKAI, GAIKAITIJIBRISYUUSIN_YOKUSEI, "GAIKAITIJIBRISYUUSIN_YOKUSEI", false);
        addPattern(PATTERN_SKMOSSYOUKAI, GAIKAITIJIBRISYUUSIN_19_SGARI, "GAIKAITIJIBRISYUUSIN_19_SGARI", false);
        addPattern(PATTERN_SKMOSSYOUKAI, GAIKAINDEXNK_SISUU, "GAIKAINDEXNK_SISUU", false);
        addPattern(PATTERN_SKMOSSYOUKAI, GAIKAINDEXNK_TEIRITU, "GAIKAINDEXNK_TEIRITU", false);
        addPattern(PATTERN_SKMOSSYOUKAI, GAIKAINDEXNK_20_SISUU, "GAIKAINDEXNK_20_SISUU", false);
        addPattern(PATTERN_SKMOSSYOUKAI, GAIKAINDEXNK_20_TEIRITUTEIKI, "GAIKAINDEXNK_20_TEIRITUTEIKI", false);
        addPattern(PATTERN_SKMOSSYOUKAI, GAIKARIRITUHENDOUNK, "GAIKARIRITUHENDOUNK", false);
        addPattern(PATTERN_SKMOSSYOUKAI, TEIKAIYAKUHRKNSYSN_YENDT, "TEIKAIYAKUHRKNSYSN_YENDT", false);
        addPattern(PATTERN_SKMOSSYOUKAI, TEIKAIYAKUHRKNSYSN_USDDT, "TEIKAIYAKUHRKNSYSN_USDDT", false);


        addPattern(PATTERN_QRSKSYOYAKU, BLNK, "BLNK", true);
        addPattern(PATTERN_QRSKSYOYAKU, GAIKAITIJIBRISYUUSIN_YOKUSEI, "GAIKAITIJIBRISYUUSIN_YOKUSEI", false);
        addPattern(PATTERN_QRSKSYOYAKU, GAIKAITIJIBRISYUUSIN_19_SGARI, "GAIKAITIJIBRISYUUSIN_19_SGARI", false);
        addPattern(PATTERN_QRSKSYOYAKU, TEIKAIYAKUHRKNSYSN_YENDT, "TEIKAIYAKUHRKNSYSN_YENDT", false);
        addPattern(PATTERN_QRSKSYOYAKU, TEIKAIYAKUHRKNSYSN_USDDT, "TEIKAIYAKUHRKNSYSN_USDDT", false);
        addPattern(PATTERN_QRSKSYOYAKU, GAIKAINDEXNK_SISUU, "GAIKAINDEXNK_SISUU", false);
        addPattern(PATTERN_QRSKSYOYAKU, GAIKAINDEXNK_TEIRITU, "GAIKAINDEXNK_TEIRITU", false);
        addPattern(PATTERN_QRSKSYOYAKU, GAIKAINDEXNK_20_SISUU, "GAIKAINDEXNK_20_SISUU", false);
        addPattern(PATTERN_QRSKSYOYAKU, GAIKAINDEXNK_20_TEIRITUTEIKI, "GAIKAINDEXNK_20_TEIRITUTEIKI", false);
        addPattern(PATTERN_QRSKSYOYAKU, GAIKARIRITUHENDOUNK, "GAIKARIRITUHENDOUNK", false);


        addPattern(PATTERN_AISYOUMEI, BLNK, "BLNK", true);
        addPattern(PATTERN_AISYOUMEI, GAIKAITIJIBRISYUUSIN_YOKUSEI, "GAIKAITIJIBRISYUUSIN_YOKUSEI", false);
        addPattern(PATTERN_AISYOUMEI, GAIKAITIJIBRISYUUSIN_19_SGARI, "GAIKAITIJIBRISYUUSIN_19_SGARI", false);
        addPattern(PATTERN_AISYOUMEI, TEIKAIYAKUHRKNSYSN_YENDT, "TEIKAIYAKUHRKNSYSN_YENDT", false);
        addPattern(PATTERN_AISYOUMEI, TEIKAIYAKUHRKNSYSN_USDDT, "TEIKAIYAKUHRKNSYSN_USDDT", false);
        addPattern(PATTERN_AISYOUMEI, GAIKAINDEXNK_SISUU, "GAIKAINDEXNK_SISUU", false);
        addPattern(PATTERN_AISYOUMEI, GAIKAINDEXNK_TEIRITU, "GAIKAINDEXNK_TEIRITU", false);
        addPattern(PATTERN_AISYOUMEI, GAIKAINDEXNK_20_SISUU, "GAIKAINDEXNK_20_SISUU", false);
        addPattern(PATTERN_AISYOUMEI, GAIKAINDEXNK_20_TEIRITUTEIKI, "GAIKAINDEXNK_20_TEIRITUTEIKI", false);
        addPattern(PATTERN_AISYOUMEI, GAIKARIRITUHENDOUNK, "GAIKARIRITUHENDOUNK", false);


        addPattern(PATTERN_SYANAIDISP, BLNK, "BLNK", true);
        addPattern(PATTERN_SYANAIDISP, GAIKAITIJIBRISYUUSIN_YOKUSEI, "GAIKAITIJIBRISYUUSIN_YOKUSEI", false);
        addPattern(PATTERN_SYANAIDISP, GAIKAITIJIBRISYUUSIN_19_SGARI, "GAIKAITIJIBRISYUUSIN_19_SGARI", false);
        addPattern(PATTERN_SYANAIDISP, TEIKAIYAKUHRKNSYSN_YENDT, "TEIKAIYAKUHRKNSYSN_YENDT", false);
        addPattern(PATTERN_SYANAIDISP, TEIKAIYAKUHRKNSYSN_USDDT, "TEIKAIYAKUHRKNSYSN_USDDT", false);
        addPattern(PATTERN_SYANAIDISP, GAIKAINDEXNK_SISUU, "GAIKAINDEXNK_SISUU", false);
        addPattern(PATTERN_SYANAIDISP, GAIKAINDEXNK_TEIRITU, "GAIKAINDEXNK_TEIRITU", false);
        addPattern(PATTERN_SYANAIDISP, GAIKAINDEXNK_20_SISUU, "GAIKAINDEXNK_20_SISUU", false);
        addPattern(PATTERN_SYANAIDISP, GAIKAINDEXNK_20_TEIRITUTEIKI, "GAIKAINDEXNK_20_TEIRITUTEIKI", false);
        addPattern(PATTERN_SYANAIDISP, GAIKARIRITUHENDOUNK, "GAIKARIRITUHENDOUNK", false);


        lock(C_HknsyuruiNo.class);
    }

    private C_HknsyuruiNo(String value) {
        super(value);
    }

    public static C_HknsyuruiNo valueOf(String value) {
        return valueOf(C_HknsyuruiNo.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HknsyuruiNo.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HknsyuruiNo.class, patternId, value);
    }
}
