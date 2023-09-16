
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＤＳ機能ＩＤ区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DsKinouidKbn</td><td colspan="3">ＤＳ機能ＩＤ区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="13">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #LOGIN}</td><td>&quot;dwlogin&quot;</td><td>ログイン認証</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HONNINKAKUNIN}</td><td>&quot;dwhonninkakunin&quot;</td><td>本人確認処理</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PASSWORDHENKOU}</td><td>&quot;dwpasswordhenkou&quot;</td><td>パスワード変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOZENMENUSYUTOKU}</td><td>&quot;dwhozenmenusyutoku&quot;</td><td>保全メニュー内容取得</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOZENKEIYAKUSYUTOKU}</td><td>&quot;dwhozenkeiyakusyutoku&quot;</td><td>保全契約内容取得</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GETTUUSINSAKIINFO}</td><td>&quot;dwgettuusinsakiinfo&quot;</td><td>顧客通信先情報取得</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILHENKOU}</td><td>&quot;dwmailaddresshenkou&quot;</td><td>メール変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DSKAIYAKUUKETUKE}</td><td>&quot;dwkaiyakuuketuke&quot;</td><td>ＤＳ解約受付</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DSTUMITATEKINITENUKETUKE}</td><td>&quot;dwtumitatekinitenuketuke&quot;</td><td>ＤＳ積立金移転受付</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DSREALTIMEMAILSOUSIN}</td><td>&quot;dwrealtimemailsousin&quot;</td><td>ＤＳリアルタイムメール送信</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DENWAKAIYAKUUKETUKE}</td><td>&quot;dwdenwakaiyakuuketuke&quot;</td><td>電話解約受付</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MKHGKHENKOUUKETUKE}</td><td>&quot;dwmkhgkhenkouuketuke&quot;</td><td>ＤＳ目標額変更受付</td></tr>
 * </table>
 */
public class C_DsKinouidKbn extends Classification<C_DsKinouidKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DsKinouidKbn BLNK = new C_DsKinouidKbn("0");

    public static final C_DsKinouidKbn LOGIN = new C_DsKinouidKbn("dwlogin");

    public static final C_DsKinouidKbn HONNINKAKUNIN = new C_DsKinouidKbn("dwhonninkakunin");

    public static final C_DsKinouidKbn PASSWORDHENKOU = new C_DsKinouidKbn("dwpasswordhenkou");

    public static final C_DsKinouidKbn HOZENMENUSYUTOKU = new C_DsKinouidKbn("dwhozenmenusyutoku");

    public static final C_DsKinouidKbn HOZENKEIYAKUSYUTOKU = new C_DsKinouidKbn("dwhozenkeiyakusyutoku");

    public static final C_DsKinouidKbn GETTUUSINSAKIINFO = new C_DsKinouidKbn("dwgettuusinsakiinfo");

    public static final C_DsKinouidKbn MAILHENKOU = new C_DsKinouidKbn("dwmailaddresshenkou");

    public static final C_DsKinouidKbn DSKAIYAKUUKETUKE = new C_DsKinouidKbn("dwkaiyakuuketuke");

    public static final C_DsKinouidKbn DSTUMITATEKINITENUKETUKE = new C_DsKinouidKbn("dwtumitatekinitenuketuke");

    public static final C_DsKinouidKbn DSREALTIMEMAILSOUSIN = new C_DsKinouidKbn("dwrealtimemailsousin");

    public static final C_DsKinouidKbn DENWAKAIYAKUUKETUKE = new C_DsKinouidKbn("dwdenwakaiyakuuketuke");

    public static final C_DsKinouidKbn MKHGKHENKOUUKETUKE = new C_DsKinouidKbn("dwmkhgkhenkouuketuke");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, LOGIN, "LOGIN", false);
        addPattern(PATTERN_DEFAULT, HONNINKAKUNIN, "HONNINKAKUNIN", false);
        addPattern(PATTERN_DEFAULT, PASSWORDHENKOU, "PASSWORDHENKOU", false);
        addPattern(PATTERN_DEFAULT, HOZENMENUSYUTOKU, "HOZENMENUSYUTOKU", false);
        addPattern(PATTERN_DEFAULT, HOZENKEIYAKUSYUTOKU, "HOZENKEIYAKUSYUTOKU", false);
        addPattern(PATTERN_DEFAULT, GETTUUSINSAKIINFO, "GETTUUSINSAKIINFO", false);
        addPattern(PATTERN_DEFAULT, MAILHENKOU, "MAILHENKOU", false);
        addPattern(PATTERN_DEFAULT, DSKAIYAKUUKETUKE, "DSKAIYAKUUKETUKE", false);
        addPattern(PATTERN_DEFAULT, DSTUMITATEKINITENUKETUKE, "DSTUMITATEKINITENUKETUKE", false);
        addPattern(PATTERN_DEFAULT, DSREALTIMEMAILSOUSIN, "DSREALTIMEMAILSOUSIN", false);
        addPattern(PATTERN_DEFAULT, DENWAKAIYAKUUKETUKE, "DENWAKAIYAKUUKETUKE", false);
        addPattern(PATTERN_DEFAULT, MKHGKHENKOUUKETUKE, "MKHGKHENKOUUKETUKE", false);


        lock(C_DsKinouidKbn.class);
    }

    private C_DsKinouidKbn(String value) {
        super(value);
    }

    public static C_DsKinouidKbn valueOf(String value) {
        return valueOf(C_DsKinouidKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DsKinouidKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DsKinouidKbn.class, patternId, value);
    }
}
