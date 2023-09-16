
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＤＳ仮パスワード現況通知出力不能コード区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DsKrPswdGnkTtStrkHnCdKbn</td><td colspan="3">ＤＳ仮パスワード現況通知出力不能コード区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="10">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;00&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DSMIKANYUU}</td><td>&quot;01&quot;</td><td>ＤＳ未加入</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DSKAIYAKU}</td><td>&quot;02&quot;</td><td>ＤＳ解約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IDOUSYORITYUU}</td><td>&quot;03&quot;</td><td>異動処理中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HONPASSWORDTOUROKUZUMI}</td><td>&quot;04&quot;</td><td>本パスワード登録済</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #LOCKOUTTYUU}</td><td>&quot;05&quot;</td><td>ロックアウト中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SERVICETEISITYUU}</td><td>&quot;06&quot;</td><td>サービス停止中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAIHAKKOUSEIKYUUZUMI}</td><td>&quot;07&quot;</td><td>再発行請求済</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZANZONKIKANSUKUNAI}</td><td>&quot;08&quot;</td><td>残存期間が少ない</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KRPASSWORDMIHAKKOU}</td><td>&quot;09&quot;</td><td>仮パスワード未発行</td></tr>
 * </table>
 */
public class C_DsKrPswdGnkTtStrkHnCdKbn extends Classification<C_DsKrPswdGnkTtStrkHnCdKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DsKrPswdGnkTtStrkHnCdKbn BLNK = new C_DsKrPswdGnkTtStrkHnCdKbn("00");

    public static final C_DsKrPswdGnkTtStrkHnCdKbn DSMIKANYUU = new C_DsKrPswdGnkTtStrkHnCdKbn("01");

    public static final C_DsKrPswdGnkTtStrkHnCdKbn DSKAIYAKU = new C_DsKrPswdGnkTtStrkHnCdKbn("02");

    public static final C_DsKrPswdGnkTtStrkHnCdKbn IDOUSYORITYUU = new C_DsKrPswdGnkTtStrkHnCdKbn("03");

    public static final C_DsKrPswdGnkTtStrkHnCdKbn HONPASSWORDTOUROKUZUMI = new C_DsKrPswdGnkTtStrkHnCdKbn("04");

    public static final C_DsKrPswdGnkTtStrkHnCdKbn LOCKOUTTYUU = new C_DsKrPswdGnkTtStrkHnCdKbn("05");

    public static final C_DsKrPswdGnkTtStrkHnCdKbn SERVICETEISITYUU = new C_DsKrPswdGnkTtStrkHnCdKbn("06");

    public static final C_DsKrPswdGnkTtStrkHnCdKbn SAIHAKKOUSEIKYUUZUMI = new C_DsKrPswdGnkTtStrkHnCdKbn("07");

    public static final C_DsKrPswdGnkTtStrkHnCdKbn ZANZONKIKANSUKUNAI = new C_DsKrPswdGnkTtStrkHnCdKbn("08");

    public static final C_DsKrPswdGnkTtStrkHnCdKbn KRPASSWORDMIHAKKOU = new C_DsKrPswdGnkTtStrkHnCdKbn("09");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, DSMIKANYUU, "DSMIKANYUU", false);
        addPattern(PATTERN_DEFAULT, DSKAIYAKU, "DSKAIYAKU", false);
        addPattern(PATTERN_DEFAULT, IDOUSYORITYUU, "IDOUSYORITYUU", false);
        addPattern(PATTERN_DEFAULT, HONPASSWORDTOUROKUZUMI, "HONPASSWORDTOUROKUZUMI", false);
        addPattern(PATTERN_DEFAULT, LOCKOUTTYUU, "LOCKOUTTYUU", false);
        addPattern(PATTERN_DEFAULT, SERVICETEISITYUU, "SERVICETEISITYUU", false);
        addPattern(PATTERN_DEFAULT, SAIHAKKOUSEIKYUUZUMI, "SAIHAKKOUSEIKYUUZUMI", false);
        addPattern(PATTERN_DEFAULT, ZANZONKIKANSUKUNAI, "ZANZONKIKANSUKUNAI", false);
        addPattern(PATTERN_DEFAULT, KRPASSWORDMIHAKKOU, "KRPASSWORDMIHAKKOU", false);


        lock(C_DsKrPswdGnkTtStrkHnCdKbn.class);
    }

    private C_DsKrPswdGnkTtStrkHnCdKbn(String value) {
        super(value);
    }

    public static C_DsKrPswdGnkTtStrkHnCdKbn valueOf(String value) {
        return valueOf(C_DsKrPswdGnkTtStrkHnCdKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DsKrPswdGnkTtStrkHnCdKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DsKrPswdGnkTtStrkHnCdKbn.class, patternId, value);
    }
}
