
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 解約受付チェック結果区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_CheckKaiyakuUketukeKekkaKbn</td><td colspan="3">解約受付チェック結果区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="30">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLANK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KADOUZIKANGAI}</td><td>&quot;01&quot;</td><td>稼動時間外</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DSMIKANYUUKEIYAKU}</td><td>&quot;02&quot;</td><td>ＤＳ未加入契約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DSITIZITEISITYUU}</td><td>&quot;03&quot;</td><td>ＤＳ一時停止中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DSIDOUTYUU}</td><td>&quot;04&quot;</td><td>ＤＳ異動中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKUTEIKOUZAMITOUROKU}</td><td>&quot;05&quot;</td><td>特定取引用口座未登録</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKUTEIKOUZAMUKOU}</td><td>&quot;06&quot;</td><td>特定取引用口座無効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAWASERATEMITOUTYAKU}</td><td>&quot;07&quot;</td><td>為替レート未到着</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GINKOUMASTERSONZAI}</td><td>&quot;08&quot;</td><td>銀行マスタ存在チェックエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOZENYUUKOUJYOUTAI}</td><td>&quot;09&quot;</td><td>保全有効状態チェックエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TETUDUKITYUUI}</td><td>&quot;10&quot;</td><td>手続注意チェックエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SITIKENSETTEI}</td><td>&quot;11&quot;</td><td>質権設定チェックエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YENDATEHENKOUMAE}</td><td>&quot;12&quot;</td><td>円建変更前チェックエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAKIYMDHENKOU}</td><td>&quot;13&quot;</td><td>先日付変更チェックエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIYAKUYMDMAE}</td><td>&quot;14&quot;</td><td>契約日前チェックエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOUKINJYOUGEN}</td><td>&quot;15&quot;</td><td>送金上限チェックエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GINKOUYUUKOUSEIHANTEI}</td><td>&quot;16&quot;</td><td>銀行有効性判定チェックエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUUTYOGINKOUSOUKINKAHI}</td><td>&quot;17&quot;</td><td>ゆうちょ銀行送金可否（内国為替制度加盟）チェックエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKAKOUZASOUKINKAHI}</td><td>&quot;18&quot;</td><td>外貨口座送金可否エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUZAMEIGININMEI}</td><td>&quot;19&quot;</td><td>口座名義人名チェックエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKUUKETUKEZUMI}</td><td>&quot;20&quot;</td><td>解約受付済</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MFHUSEIGOU}</td><td>&quot;21&quot;</td><td>ＭＦ不整合チェックエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MIHANEIHAITOUKIN}</td><td>&quot;22&quot;</td><td>未反映配当金チェックエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HAITOUKINHANEIYMDSONZAI}</td><td>&quot;23&quot;</td><td>効力発生日後配当金反映日存在チェックエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HARAIKOMIYUYOKIKAN}</td><td>&quot;24&quot;</td><td>払込猶予期間チェックエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HAITOUKIN}</td><td>&quot;25&quot;</td><td>配当金チェックエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MIHANEITUMITATEKIN}</td><td>&quot;26&quot;</td><td>未反映積立金チェックエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZENNOUMIJYUUTOU}</td><td>&quot;27&quot;</td><td>前納未充当チェックエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DSDATAMAINTENANCE}</td><td>&quot;28&quot;</td><td>ＤＳデータメンテナンス中チェックエラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYSTEMERROR}</td><td>&quot;99&quot;</td><td>システムエラー</td></tr>
 * </table>
 */
public class C_CheckKaiyakuUketukeKekkaKbn extends Classification<C_CheckKaiyakuUketukeKekkaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_CheckKaiyakuUketukeKekkaKbn BLANK = new C_CheckKaiyakuUketukeKekkaKbn("0");

    public static final C_CheckKaiyakuUketukeKekkaKbn KADOUZIKANGAI = new C_CheckKaiyakuUketukeKekkaKbn("01");

    public static final C_CheckKaiyakuUketukeKekkaKbn DSMIKANYUUKEIYAKU = new C_CheckKaiyakuUketukeKekkaKbn("02");

    public static final C_CheckKaiyakuUketukeKekkaKbn DSITIZITEISITYUU = new C_CheckKaiyakuUketukeKekkaKbn("03");

    public static final C_CheckKaiyakuUketukeKekkaKbn DSIDOUTYUU = new C_CheckKaiyakuUketukeKekkaKbn("04");

    public static final C_CheckKaiyakuUketukeKekkaKbn TOKUTEIKOUZAMITOUROKU = new C_CheckKaiyakuUketukeKekkaKbn("05");

    public static final C_CheckKaiyakuUketukeKekkaKbn TOKUTEIKOUZAMUKOU = new C_CheckKaiyakuUketukeKekkaKbn("06");

    public static final C_CheckKaiyakuUketukeKekkaKbn KAWASERATEMITOUTYAKU = new C_CheckKaiyakuUketukeKekkaKbn("07");

    public static final C_CheckKaiyakuUketukeKekkaKbn GINKOUMASTERSONZAI = new C_CheckKaiyakuUketukeKekkaKbn("08");

    public static final C_CheckKaiyakuUketukeKekkaKbn HOZENYUUKOUJYOUTAI = new C_CheckKaiyakuUketukeKekkaKbn("09");

    public static final C_CheckKaiyakuUketukeKekkaKbn TETUDUKITYUUI = new C_CheckKaiyakuUketukeKekkaKbn("10");

    public static final C_CheckKaiyakuUketukeKekkaKbn SITIKENSETTEI = new C_CheckKaiyakuUketukeKekkaKbn("11");

    public static final C_CheckKaiyakuUketukeKekkaKbn YENDATEHENKOUMAE = new C_CheckKaiyakuUketukeKekkaKbn("12");

    public static final C_CheckKaiyakuUketukeKekkaKbn SAKIYMDHENKOU = new C_CheckKaiyakuUketukeKekkaKbn("13");

    public static final C_CheckKaiyakuUketukeKekkaKbn KEIYAKUYMDMAE = new C_CheckKaiyakuUketukeKekkaKbn("14");

    public static final C_CheckKaiyakuUketukeKekkaKbn SOUKINJYOUGEN = new C_CheckKaiyakuUketukeKekkaKbn("15");

    public static final C_CheckKaiyakuUketukeKekkaKbn GINKOUYUUKOUSEIHANTEI = new C_CheckKaiyakuUketukeKekkaKbn("16");

    public static final C_CheckKaiyakuUketukeKekkaKbn YUUTYOGINKOUSOUKINKAHI = new C_CheckKaiyakuUketukeKekkaKbn("17");

    public static final C_CheckKaiyakuUketukeKekkaKbn GAIKAKOUZASOUKINKAHI = new C_CheckKaiyakuUketukeKekkaKbn("18");

    public static final C_CheckKaiyakuUketukeKekkaKbn KOUZAMEIGININMEI = new C_CheckKaiyakuUketukeKekkaKbn("19");

    public static final C_CheckKaiyakuUketukeKekkaKbn KAIYAKUUKETUKEZUMI = new C_CheckKaiyakuUketukeKekkaKbn("20");

    public static final C_CheckKaiyakuUketukeKekkaKbn MFHUSEIGOU = new C_CheckKaiyakuUketukeKekkaKbn("21");

    public static final C_CheckKaiyakuUketukeKekkaKbn MIHANEIHAITOUKIN = new C_CheckKaiyakuUketukeKekkaKbn("22");

    public static final C_CheckKaiyakuUketukeKekkaKbn HAITOUKINHANEIYMDSONZAI = new C_CheckKaiyakuUketukeKekkaKbn("23");

    public static final C_CheckKaiyakuUketukeKekkaKbn HARAIKOMIYUYOKIKAN = new C_CheckKaiyakuUketukeKekkaKbn("24");

    public static final C_CheckKaiyakuUketukeKekkaKbn HAITOUKIN = new C_CheckKaiyakuUketukeKekkaKbn("25");

    public static final C_CheckKaiyakuUketukeKekkaKbn MIHANEITUMITATEKIN = new C_CheckKaiyakuUketukeKekkaKbn("26");

    public static final C_CheckKaiyakuUketukeKekkaKbn ZENNOUMIJYUUTOU = new C_CheckKaiyakuUketukeKekkaKbn("27");

    public static final C_CheckKaiyakuUketukeKekkaKbn DSDATAMAINTENANCE = new C_CheckKaiyakuUketukeKekkaKbn("28");

    public static final C_CheckKaiyakuUketukeKekkaKbn SYSTEMERROR = new C_CheckKaiyakuUketukeKekkaKbn("99");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLANK, "BLANK", true);
        addPattern(PATTERN_DEFAULT, KADOUZIKANGAI, "KADOUZIKANGAI", false);
        addPattern(PATTERN_DEFAULT, DSMIKANYUUKEIYAKU, "DSMIKANYUUKEIYAKU", false);
        addPattern(PATTERN_DEFAULT, DSITIZITEISITYUU, "DSITIZITEISITYUU", false);
        addPattern(PATTERN_DEFAULT, DSIDOUTYUU, "DSIDOUTYUU", false);
        addPattern(PATTERN_DEFAULT, TOKUTEIKOUZAMITOUROKU, "TOKUTEIKOUZAMITOUROKU", false);
        addPattern(PATTERN_DEFAULT, TOKUTEIKOUZAMUKOU, "TOKUTEIKOUZAMUKOU", false);
        addPattern(PATTERN_DEFAULT, KAWASERATEMITOUTYAKU, "KAWASERATEMITOUTYAKU", false);
        addPattern(PATTERN_DEFAULT, GINKOUMASTERSONZAI, "GINKOUMASTERSONZAI", false);
        addPattern(PATTERN_DEFAULT, HOZENYUUKOUJYOUTAI, "HOZENYUUKOUJYOUTAI", false);
        addPattern(PATTERN_DEFAULT, TETUDUKITYUUI, "TETUDUKITYUUI", false);
        addPattern(PATTERN_DEFAULT, SITIKENSETTEI, "SITIKENSETTEI", false);
        addPattern(PATTERN_DEFAULT, YENDATEHENKOUMAE, "YENDATEHENKOUMAE", false);
        addPattern(PATTERN_DEFAULT, SAKIYMDHENKOU, "SAKIYMDHENKOU", false);
        addPattern(PATTERN_DEFAULT, KEIYAKUYMDMAE, "KEIYAKUYMDMAE", false);
        addPattern(PATTERN_DEFAULT, SOUKINJYOUGEN, "SOUKINJYOUGEN", false);
        addPattern(PATTERN_DEFAULT, GINKOUYUUKOUSEIHANTEI, "GINKOUYUUKOUSEIHANTEI", false);
        addPattern(PATTERN_DEFAULT, YUUTYOGINKOUSOUKINKAHI, "YUUTYOGINKOUSOUKINKAHI", false);
        addPattern(PATTERN_DEFAULT, GAIKAKOUZASOUKINKAHI, "GAIKAKOUZASOUKINKAHI", false);
        addPattern(PATTERN_DEFAULT, KOUZAMEIGININMEI, "KOUZAMEIGININMEI", false);
        addPattern(PATTERN_DEFAULT, KAIYAKUUKETUKEZUMI, "KAIYAKUUKETUKEZUMI", false);
        addPattern(PATTERN_DEFAULT, MFHUSEIGOU, "MFHUSEIGOU", false);
        addPattern(PATTERN_DEFAULT, MIHANEIHAITOUKIN, "MIHANEIHAITOUKIN", false);
        addPattern(PATTERN_DEFAULT, HAITOUKINHANEIYMDSONZAI, "HAITOUKINHANEIYMDSONZAI", false);
        addPattern(PATTERN_DEFAULT, HARAIKOMIYUYOKIKAN, "HARAIKOMIYUYOKIKAN", false);
        addPattern(PATTERN_DEFAULT, HAITOUKIN, "HAITOUKIN", false);
        addPattern(PATTERN_DEFAULT, MIHANEITUMITATEKIN, "MIHANEITUMITATEKIN", false);
        addPattern(PATTERN_DEFAULT, ZENNOUMIJYUUTOU, "ZENNOUMIJYUUTOU", false);
        addPattern(PATTERN_DEFAULT, DSDATAMAINTENANCE, "DSDATAMAINTENANCE", false);
        addPattern(PATTERN_DEFAULT, SYSTEMERROR, "SYSTEMERROR", false);


        lock(C_CheckKaiyakuUketukeKekkaKbn.class);
    }

    private C_CheckKaiyakuUketukeKekkaKbn(String value) {
        super(value);
    }

    public static C_CheckKaiyakuUketukeKekkaKbn valueOf(String value) {
        return valueOf(C_CheckKaiyakuUketukeKekkaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_CheckKaiyakuUketukeKekkaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_CheckKaiyakuUketukeKekkaKbn.class, patternId, value);
    }
}
