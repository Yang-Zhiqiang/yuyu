
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＤＳ処理区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DsSyoriKbn</td><td colspan="3">ＤＳ処理区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="24">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #LOGIN_SEIKOU}</td><td>&quot;1&quot;</td><td>ログイン成功</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #LOGIN_SIPPAI}</td><td>&quot;2&quot;</td><td>ログイン失敗</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PASSWORD_HENKOU}</td><td>&quot;3&quot;</td><td>パスワード変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOKYAKU_TOUROKU}</td><td>&quot;4&quot;</td><td>顧客登録</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOKYAKU_TOUGOU}</td><td>&quot;5&quot;</td><td>顧客統合</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOKYAKU_TOUGOU_KAIJYO}</td><td>&quot;6&quot;</td><td>顧客統合解除</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HAND_TEISEI}</td><td>&quot;7&quot;</td><td>ハンド訂正</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ACCOUNT_LOCK_KAIJYO}</td><td>&quot;8&quot;</td><td>アカウントロック解除</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SERVICE_TEISI}</td><td>&quot;9&quot;</td><td>サービス停止</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SERVICE_SAIKAI}</td><td>&quot;10&quot;</td><td>サービス再開</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEIRITU_KOKYAKU_SAKUSEI}</td><td>&quot;11&quot;</td><td>成立顧客作成</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KR_PASSWORD_TUUTI_SAKUSEI}</td><td>&quot;12&quot;</td><td>仮パスワード通知作成</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOKYAKU_KEIYAKU_SYOUMETU}</td><td>&quot;13&quot;</td><td>ＤＳ契約消滅</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOKYAKU_KANRI_SYOUMETU}</td><td>&quot;14&quot;</td><td>ＤＳ顧客消滅</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAIL_HENKOU}</td><td>&quot;15&quot;</td><td>メール変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PASSWORD_SAIHAKKOU}</td><td>&quot;16&quot;</td><td>パスワード再発行</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAIL_ERRORLIST_F_HANEI}</td><td>&quot;17&quot;</td><td>メールエラーリストＦ反映</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DSKAIYAKU}</td><td>&quot;18&quot;</td><td>ＤＳ解約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HONNIN_KAKUNIN_SEIKOU}</td><td>&quot;19&quot;</td><td>本人確認成功</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HONNIN_KAKUNIN_SIPPAI}</td><td>&quot;20&quot;</td><td>本人確認失敗</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAIL_ERRORLIST_F2_HANEI}</td><td>&quot;21&quot;</td><td>メールエラーリストＦ２反映</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TORIHIKI_SERVICE_TEISI}</td><td>&quot;22&quot;</td><td>取引サービス停止</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TORIHIKI_SERVICE_TOUROKU}</td><td>&quot;23&quot;</td><td>取引サービス登録</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TORIHIKI_SERVICE_TORIKOMI}</td><td>&quot;24&quot;</td><td>取引サービス取込</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_KOKYAKU_TOUROKU KOKYAKU_TOUROKU}<br />(顧客登録)</td><td align="center">○</td><td>{@link #KOKYAKU_TOUROKU}</td><td>&quot;4&quot;</td><td>顧客登録</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOKYAKU_TOUGOU}</td><td>&quot;5&quot;</td><td>顧客統合</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOKYAKU_TOUGOU_KAIJYO}</td><td>&quot;6&quot;</td><td>顧客統合解除</td></tr>
 * </table>
 */
public class C_DsSyoriKbn extends Classification<C_DsSyoriKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DsSyoriKbn LOGIN_SEIKOU = new C_DsSyoriKbn("1");

    public static final C_DsSyoriKbn LOGIN_SIPPAI = new C_DsSyoriKbn("2");

    public static final C_DsSyoriKbn PASSWORD_HENKOU = new C_DsSyoriKbn("3");

    public static final C_DsSyoriKbn KOKYAKU_TOUROKU = new C_DsSyoriKbn("4");

    public static final C_DsSyoriKbn KOKYAKU_TOUGOU = new C_DsSyoriKbn("5");

    public static final C_DsSyoriKbn KOKYAKU_TOUGOU_KAIJYO = new C_DsSyoriKbn("6");

    public static final C_DsSyoriKbn HAND_TEISEI = new C_DsSyoriKbn("7");

    public static final C_DsSyoriKbn ACCOUNT_LOCK_KAIJYO = new C_DsSyoriKbn("8");

    public static final C_DsSyoriKbn SERVICE_TEISI = new C_DsSyoriKbn("9");

    public static final C_DsSyoriKbn SERVICE_SAIKAI = new C_DsSyoriKbn("10");

    public static final C_DsSyoriKbn SEIRITU_KOKYAKU_SAKUSEI = new C_DsSyoriKbn("11");

    public static final C_DsSyoriKbn KR_PASSWORD_TUUTI_SAKUSEI = new C_DsSyoriKbn("12");

    public static final C_DsSyoriKbn KOKYAKU_KEIYAKU_SYOUMETU = new C_DsSyoriKbn("13");

    public static final C_DsSyoriKbn KOKYAKU_KANRI_SYOUMETU = new C_DsSyoriKbn("14");

    public static final C_DsSyoriKbn MAIL_HENKOU = new C_DsSyoriKbn("15");

    public static final C_DsSyoriKbn PASSWORD_SAIHAKKOU = new C_DsSyoriKbn("16");

    public static final C_DsSyoriKbn MAIL_ERRORLIST_F_HANEI = new C_DsSyoriKbn("17");

    public static final C_DsSyoriKbn DSKAIYAKU = new C_DsSyoriKbn("18");

    public static final C_DsSyoriKbn HONNIN_KAKUNIN_SEIKOU = new C_DsSyoriKbn("19");

    public static final C_DsSyoriKbn HONNIN_KAKUNIN_SIPPAI = new C_DsSyoriKbn("20");

    public static final C_DsSyoriKbn MAIL_ERRORLIST_F2_HANEI = new C_DsSyoriKbn("21");

    public static final C_DsSyoriKbn TORIHIKI_SERVICE_TEISI = new C_DsSyoriKbn("22");

    public static final C_DsSyoriKbn TORIHIKI_SERVICE_TOUROKU = new C_DsSyoriKbn("23");

    public static final C_DsSyoriKbn TORIHIKI_SERVICE_TORIKOMI = new C_DsSyoriKbn("24");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_KOKYAKU_TOUROKU = "2";


    static {

        addPattern(PATTERN_DEFAULT, LOGIN_SEIKOU, "LOGIN_SEIKOU", true);
        addPattern(PATTERN_DEFAULT, LOGIN_SIPPAI, "LOGIN_SIPPAI", false);
        addPattern(PATTERN_DEFAULT, PASSWORD_HENKOU, "PASSWORD_HENKOU", false);
        addPattern(PATTERN_DEFAULT, KOKYAKU_TOUROKU, "KOKYAKU_TOUROKU", false);
        addPattern(PATTERN_DEFAULT, KOKYAKU_TOUGOU, "KOKYAKU_TOUGOU", false);
        addPattern(PATTERN_DEFAULT, KOKYAKU_TOUGOU_KAIJYO, "KOKYAKU_TOUGOU_KAIJYO", false);
        addPattern(PATTERN_DEFAULT, HAND_TEISEI, "HAND_TEISEI", false);
        addPattern(PATTERN_DEFAULT, ACCOUNT_LOCK_KAIJYO, "ACCOUNT_LOCK_KAIJYO", false);
        addPattern(PATTERN_DEFAULT, SERVICE_TEISI, "SERVICE_TEISI", false);
        addPattern(PATTERN_DEFAULT, SERVICE_SAIKAI, "SERVICE_SAIKAI", false);
        addPattern(PATTERN_DEFAULT, SEIRITU_KOKYAKU_SAKUSEI, "SEIRITU_KOKYAKU_SAKUSEI", false);
        addPattern(PATTERN_DEFAULT, KR_PASSWORD_TUUTI_SAKUSEI, "KR_PASSWORD_TUUTI_SAKUSEI", false);
        addPattern(PATTERN_DEFAULT, KOKYAKU_KEIYAKU_SYOUMETU, "KOKYAKU_KEIYAKU_SYOUMETU", false);
        addPattern(PATTERN_DEFAULT, KOKYAKU_KANRI_SYOUMETU, "KOKYAKU_KANRI_SYOUMETU", false);
        addPattern(PATTERN_DEFAULT, MAIL_HENKOU, "MAIL_HENKOU", false);
        addPattern(PATTERN_DEFAULT, PASSWORD_SAIHAKKOU, "PASSWORD_SAIHAKKOU", false);
        addPattern(PATTERN_DEFAULT, MAIL_ERRORLIST_F_HANEI, "MAIL_ERRORLIST_F_HANEI", false);
        addPattern(PATTERN_DEFAULT, DSKAIYAKU, "DSKAIYAKU", false);
        addPattern(PATTERN_DEFAULT, HONNIN_KAKUNIN_SEIKOU, "HONNIN_KAKUNIN_SEIKOU", false);
        addPattern(PATTERN_DEFAULT, HONNIN_KAKUNIN_SIPPAI, "HONNIN_KAKUNIN_SIPPAI", false);
        addPattern(PATTERN_DEFAULT, MAIL_ERRORLIST_F2_HANEI, "MAIL_ERRORLIST_F2_HANEI", false);
        addPattern(PATTERN_DEFAULT, TORIHIKI_SERVICE_TEISI, "TORIHIKI_SERVICE_TEISI", false);
        addPattern(PATTERN_DEFAULT, TORIHIKI_SERVICE_TOUROKU, "TORIHIKI_SERVICE_TOUROKU", false);
        addPattern(PATTERN_DEFAULT, TORIHIKI_SERVICE_TORIKOMI, "TORIHIKI_SERVICE_TORIKOMI", false);


        addPattern(PATTERN_KOKYAKU_TOUROKU, KOKYAKU_TOUROKU, "KOKYAKU_TOUROKU", true);
        addPattern(PATTERN_KOKYAKU_TOUROKU, KOKYAKU_TOUGOU, "KOKYAKU_TOUGOU", false);
        addPattern(PATTERN_KOKYAKU_TOUROKU, KOKYAKU_TOUGOU_KAIJYO, "KOKYAKU_TOUGOU_KAIJYO", false);


        lock(C_DsSyoriKbn.class);
    }

    private C_DsSyoriKbn(String value) {
        super(value);
    }

    public static C_DsSyoriKbn valueOf(String value) {
        return valueOf(C_DsSyoriKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DsSyoriKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DsSyoriKbn.class, patternId, value);
    }
}
