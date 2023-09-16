
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＤＳ送信メール種別区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DsSousinMailSyubetuKbn</td><td colspan="3">ＤＳ送信メール種別区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="8">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">&nbsp;</td><td>{@link #BLNK}</td><td>&quot;00000&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">○</td><td>{@link #MAILADR_TOUROKUHENKOU}</td><td>&quot;00100&quot;</td><td>メールアドレス登録</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NEUGOKIMAIL}</td><td>&quot;00200&quot;</td><td>値動きメール</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CLEANINGMAIL}</td><td>&quot;00300&quot;</td><td>クリーニングメール</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOKENRYOUYENOSIRASEMAIL}</td><td>&quot;00400&quot;</td><td>円貨払込額お知らせメール</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DSKAIYAKU}</td><td>&quot;10200&quot;</td><td>ＤＳ解約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #LOGINERROR}</td><td>&quot;10300&quot;</td><td>ログインエラーのお知らせ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #LOGINERROR_ITIJITEISI}</td><td>&quot;10400&quot;</td><td>ログインエラーによる一時停止のお知らせ</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_HAISINYOYAKU HAISINYOYAKU}<br />(配信予約)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;00000&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CLEANINGMAIL}</td><td>&quot;00300&quot;</td><td>クリーニングメール</td></tr>
 *  <tr><td rowspan="7">{@link #PATTERN_HAGAKIKISAINAIYOU HAGAKIKISAINAIYOU}<br />(ハガキ記載内容)</td><td align="center">○</td><td>{@link #MAILADR_TOUROKUHENKOU}</td><td>&quot;00100&quot;</td><td>メールアドレス登録</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NEUGOKIMAIL}</td><td>&quot;00200&quot;</td><td>お知らせメール</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CLEANINGMAIL}</td><td>&quot;00300&quot;</td><td>メールアドレスのご確認</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOKENRYOUYENOSIRASEMAIL}</td><td>&quot;00400&quot;</td><td>円貨払込額お知らせメール</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DSKAIYAKU}</td><td>&quot;10200&quot;</td><td>解約お手続き受付完了のお知らせ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #LOGINERROR}</td><td>&quot;10300&quot;</td><td>ログインエラーのお知らせ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #LOGINERROR_ITIJITEISI}</td><td>&quot;10400&quot;</td><td>ログインエラーによる一時停止のお知らせ</td></tr>
 *  <tr><td rowspan="8">{@link #PATTERN_MAILSOUSINRIREKISYOUKAI MAILSOUSINRIREKISYOUKAI}<br />(メール送信履歴照会)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;00000&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILADR_TOUROKUHENKOU}</td><td>&quot;00100&quot;</td><td>メールアドレス登録</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NEUGOKIMAIL}</td><td>&quot;00200&quot;</td><td>値動きメール</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CLEANINGMAIL}</td><td>&quot;00300&quot;</td><td>クリーニングメール</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOKENRYOUYENOSIRASEMAIL}</td><td>&quot;00400&quot;</td><td>円貨払込額お知らせメール</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DSKAIYAKU}</td><td>&quot;10200&quot;</td><td>ＤＳ解約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #LOGINERROR}</td><td>&quot;10300&quot;</td><td>ログインエラーのお知らせ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #LOGINERROR_ITIJITEISI}</td><td>&quot;10400&quot;</td><td>ログインエラーによる一時停止のお知らせ</td></tr>
 * </table>
 */
public class C_DsSousinMailSyubetuKbn extends Classification<C_DsSousinMailSyubetuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DsSousinMailSyubetuKbn BLNK = new C_DsSousinMailSyubetuKbn("00000");

    public static final C_DsSousinMailSyubetuKbn MAILADR_TOUROKUHENKOU = new C_DsSousinMailSyubetuKbn("00100");

    public static final C_DsSousinMailSyubetuKbn NEUGOKIMAIL = new C_DsSousinMailSyubetuKbn("00200");

    public static final C_DsSousinMailSyubetuKbn CLEANINGMAIL = new C_DsSousinMailSyubetuKbn("00300");

    public static final C_DsSousinMailSyubetuKbn HOKENRYOUYENOSIRASEMAIL = new C_DsSousinMailSyubetuKbn("00400");

    public static final C_DsSousinMailSyubetuKbn DSKAIYAKU = new C_DsSousinMailSyubetuKbn("10200");

    public static final C_DsSousinMailSyubetuKbn LOGINERROR = new C_DsSousinMailSyubetuKbn("10300");

    public static final C_DsSousinMailSyubetuKbn LOGINERROR_ITIJITEISI = new C_DsSousinMailSyubetuKbn("10400");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_HAISINYOYAKU = "2";

    public static final String PATTERN_HAGAKIKISAINAIYOU = "3";

    public static final String PATTERN_MAILSOUSINRIREKISYOUKAI = "4";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", false);
        addPattern(PATTERN_DEFAULT, MAILADR_TOUROKUHENKOU, "MAILADR_TOUROKUHENKOU", true);
        addPattern(PATTERN_DEFAULT, NEUGOKIMAIL, "NEUGOKIMAIL", false);
        addPattern(PATTERN_DEFAULT, CLEANINGMAIL, "CLEANINGMAIL", false);
        addPattern(PATTERN_DEFAULT, HOKENRYOUYENOSIRASEMAIL, "HOKENRYOUYENOSIRASEMAIL", false);
        addPattern(PATTERN_DEFAULT, DSKAIYAKU, "DSKAIYAKU", false);
        addPattern(PATTERN_DEFAULT, LOGINERROR, "LOGINERROR", false);
        addPattern(PATTERN_DEFAULT, LOGINERROR_ITIJITEISI, "LOGINERROR_ITIJITEISI", false);


        addPattern(PATTERN_HAISINYOYAKU, BLNK, "BLNK", true);
        addPattern(PATTERN_HAISINYOYAKU, CLEANINGMAIL, "CLEANINGMAIL", false);


        addPattern(PATTERN_HAGAKIKISAINAIYOU, MAILADR_TOUROKUHENKOU, "MAILADR_TOUROKUHENKOU", true);
        addPattern(PATTERN_HAGAKIKISAINAIYOU, NEUGOKIMAIL, "NEUGOKIMAIL", false);
        addPattern(PATTERN_HAGAKIKISAINAIYOU, CLEANINGMAIL, "CLEANINGMAIL", false);
        addPattern(PATTERN_HAGAKIKISAINAIYOU, HOKENRYOUYENOSIRASEMAIL, "HOKENRYOUYENOSIRASEMAIL", false);
        addPattern(PATTERN_HAGAKIKISAINAIYOU, DSKAIYAKU, "DSKAIYAKU", false);
        addPattern(PATTERN_HAGAKIKISAINAIYOU, LOGINERROR, "LOGINERROR", false);
        addPattern(PATTERN_HAGAKIKISAINAIYOU, LOGINERROR_ITIJITEISI, "LOGINERROR_ITIJITEISI", false);


        addPattern(PATTERN_MAILSOUSINRIREKISYOUKAI, BLNK, "BLNK", true);
        addPattern(PATTERN_MAILSOUSINRIREKISYOUKAI, MAILADR_TOUROKUHENKOU, "MAILADR_TOUROKUHENKOU", false);
        addPattern(PATTERN_MAILSOUSINRIREKISYOUKAI, NEUGOKIMAIL, "NEUGOKIMAIL", false);
        addPattern(PATTERN_MAILSOUSINRIREKISYOUKAI, CLEANINGMAIL, "CLEANINGMAIL", false);
        addPattern(PATTERN_MAILSOUSINRIREKISYOUKAI, HOKENRYOUYENOSIRASEMAIL, "HOKENRYOUYENOSIRASEMAIL", false);
        addPattern(PATTERN_MAILSOUSINRIREKISYOUKAI, DSKAIYAKU, "DSKAIYAKU", false);
        addPattern(PATTERN_MAILSOUSINRIREKISYOUKAI, LOGINERROR, "LOGINERROR", false);
        addPattern(PATTERN_MAILSOUSINRIREKISYOUKAI, LOGINERROR_ITIJITEISI, "LOGINERROR_ITIJITEISI", false);


        lock(C_DsSousinMailSyubetuKbn.class);
    }

    private C_DsSousinMailSyubetuKbn(String value) {
        super(value);
    }

    public static C_DsSousinMailSyubetuKbn valueOf(String value) {
        return valueOf(C_DsSousinMailSyubetuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DsSousinMailSyubetuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DsSousinMailSyubetuKbn.class, patternId, value);
    }
}
