
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * お知らせ種別コード クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Osirasesyubetucd</td><td colspan="3">お知らせ種別コード</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="15">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #DR_MPKARITOUROKU}</td><td>&quot;DR001&quot;</td><td>マイページ仮登録完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DR_MPHONTOUROKU}</td><td>&quot;DR002&quot;</td><td>マイページ本登録完了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DR_PWSAISETTEI}</td><td>&quot;DR003&quot;</td><td>パスワード再設定通知</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DR_MAILADRHENKOU}</td><td>&quot;DR004&quot;</td><td>メールアドレス変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DR_MOSKANRYOU}</td><td>&quot;DR005&quot;</td><td>申込完了通知</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DR_SIKKOUMAEYOKOKU}</td><td>&quot;DR006&quot;</td><td>アカウント失効前予告</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_HUBI_ONLINE}</td><td>&quot;SK001&quot;</td><td>お申込内容の確認（オンライン）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_HUBI_BATCH}</td><td>&quot;SK002&quot;</td><td>お申込内容の確認（バッチ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_TOKUJYOUSYOUDAKU}</td><td>&quot;SK003&quot;</td><td>特別条件付のご確認</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_KAIYAKUHRKAKUNIN}</td><td>&quot;SK004&quot;</td><td>解約返戻金確認書送付案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_YUUKOUKKNYOKOKU}</td><td>&quot;SK005&quot;</td><td>有効期間経過予告通知</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_KYKHUSEIRITU}</td><td>&quot;SK006&quot;</td><td>不成立通知</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_MPRENRAKU}</td><td>&quot;SK007&quot;</td><td>マイページ連絡（新契約）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_HKNSYKN}</td><td>&quot;KK001&quot;</td><td>保険証券送付案内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KK_KOUHURIKAISIANNAI}</td><td>&quot;KK002&quot;</td><td>口座振替開始案内</td></tr>
 * </table>
 */
public class C_Osirasesyubetucd extends Classification<C_Osirasesyubetucd> {

    private static final long serialVersionUID = 1L;


    public static final C_Osirasesyubetucd DR_MPKARITOUROKU = new C_Osirasesyubetucd("DR001");

    public static final C_Osirasesyubetucd DR_MPHONTOUROKU = new C_Osirasesyubetucd("DR002");

    public static final C_Osirasesyubetucd DR_PWSAISETTEI = new C_Osirasesyubetucd("DR003");

    public static final C_Osirasesyubetucd DR_MAILADRHENKOU = new C_Osirasesyubetucd("DR004");

    public static final C_Osirasesyubetucd DR_MOSKANRYOU = new C_Osirasesyubetucd("DR005");

    public static final C_Osirasesyubetucd DR_SIKKOUMAEYOKOKU = new C_Osirasesyubetucd("DR006");

    public static final C_Osirasesyubetucd SK_HUBI_ONLINE = new C_Osirasesyubetucd("SK001");

    public static final C_Osirasesyubetucd SK_HUBI_BATCH = new C_Osirasesyubetucd("SK002");

    public static final C_Osirasesyubetucd SK_TOKUJYOUSYOUDAKU = new C_Osirasesyubetucd("SK003");

    public static final C_Osirasesyubetucd SK_KAIYAKUHRKAKUNIN = new C_Osirasesyubetucd("SK004");

    public static final C_Osirasesyubetucd SK_YUUKOUKKNYOKOKU = new C_Osirasesyubetucd("SK005");

    public static final C_Osirasesyubetucd SK_KYKHUSEIRITU = new C_Osirasesyubetucd("SK006");

    public static final C_Osirasesyubetucd SK_MPRENRAKU = new C_Osirasesyubetucd("SK007");

    public static final C_Osirasesyubetucd KK_HKNSYKN = new C_Osirasesyubetucd("KK001");

    public static final C_Osirasesyubetucd KK_KOUHURIKAISIANNAI = new C_Osirasesyubetucd("KK002");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, DR_MPKARITOUROKU, "DR_MPKARITOUROKU", true);
        addPattern(PATTERN_DEFAULT, DR_MPHONTOUROKU, "DR_MPHONTOUROKU", false);
        addPattern(PATTERN_DEFAULT, DR_PWSAISETTEI, "DR_PWSAISETTEI", false);
        addPattern(PATTERN_DEFAULT, DR_MAILADRHENKOU, "DR_MAILADRHENKOU", false);
        addPattern(PATTERN_DEFAULT, DR_MOSKANRYOU, "DR_MOSKANRYOU", false);
        addPattern(PATTERN_DEFAULT, DR_SIKKOUMAEYOKOKU, "DR_SIKKOUMAEYOKOKU", false);
        addPattern(PATTERN_DEFAULT, SK_HUBI_ONLINE, "SK_HUBI_ONLINE", false);
        addPattern(PATTERN_DEFAULT, SK_HUBI_BATCH, "SK_HUBI_BATCH", false);
        addPattern(PATTERN_DEFAULT, SK_TOKUJYOUSYOUDAKU, "SK_TOKUJYOUSYOUDAKU", false);
        addPattern(PATTERN_DEFAULT, SK_KAIYAKUHRKAKUNIN, "SK_KAIYAKUHRKAKUNIN", false);
        addPattern(PATTERN_DEFAULT, SK_YUUKOUKKNYOKOKU, "SK_YUUKOUKKNYOKOKU", false);
        addPattern(PATTERN_DEFAULT, SK_KYKHUSEIRITU, "SK_KYKHUSEIRITU", false);
        addPattern(PATTERN_DEFAULT, SK_MPRENRAKU, "SK_MPRENRAKU", false);
        addPattern(PATTERN_DEFAULT, KK_HKNSYKN, "KK_HKNSYKN", false);
        addPattern(PATTERN_DEFAULT, KK_KOUHURIKAISIANNAI, "KK_KOUHURIKAISIANNAI", false);


        lock(C_Osirasesyubetucd.class);
    }

    private C_Osirasesyubetucd(String value) {
        super(value);
    }

    public static C_Osirasesyubetucd valueOf(String value) {
        return valueOf(C_Osirasesyubetucd.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Osirasesyubetucd.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Osirasesyubetucd.class, patternId, value);
    }
}
