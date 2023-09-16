
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＤＳメール送信停止理由区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DsMailSousinTeisiRiyuuKbn</td><td colspan="3">ＤＳメール送信停止理由区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAILHAISINERROR}</td><td>&quot;1&quot;</td><td>メール配信エラー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OKYAKUSAMAYOUBOU}</td><td>&quot;2&quot;</td><td>お客様要望</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOKYAKUSYOUMETU}</td><td>&quot;3&quot;</td><td>顧客消滅</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SERVICETEISI}</td><td>&quot;4&quot;</td><td>サービス停止</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DSKAIYAKU}</td><td>&quot;5&quot;</td><td>ＤＳ解約</td></tr>
 * </table>
 */
public class C_DsMailSousinTeisiRiyuuKbn extends Classification<C_DsMailSousinTeisiRiyuuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DsMailSousinTeisiRiyuuKbn BLNK = new C_DsMailSousinTeisiRiyuuKbn("0");

    public static final C_DsMailSousinTeisiRiyuuKbn MAILHAISINERROR = new C_DsMailSousinTeisiRiyuuKbn("1");

    public static final C_DsMailSousinTeisiRiyuuKbn OKYAKUSAMAYOUBOU = new C_DsMailSousinTeisiRiyuuKbn("2");

    public static final C_DsMailSousinTeisiRiyuuKbn KOKYAKUSYOUMETU = new C_DsMailSousinTeisiRiyuuKbn("3");

    public static final C_DsMailSousinTeisiRiyuuKbn SERVICETEISI = new C_DsMailSousinTeisiRiyuuKbn("4");

    public static final C_DsMailSousinTeisiRiyuuKbn DSKAIYAKU = new C_DsMailSousinTeisiRiyuuKbn("5");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, MAILHAISINERROR, "MAILHAISINERROR", false);
        addPattern(PATTERN_DEFAULT, OKYAKUSAMAYOUBOU, "OKYAKUSAMAYOUBOU", false);
        addPattern(PATTERN_DEFAULT, KOKYAKUSYOUMETU, "KOKYAKUSYOUMETU", false);
        addPattern(PATTERN_DEFAULT, SERVICETEISI, "SERVICETEISI", false);
        addPattern(PATTERN_DEFAULT, DSKAIYAKU, "DSKAIYAKU", false);


        lock(C_DsMailSousinTeisiRiyuuKbn.class);
    }

    private C_DsMailSousinTeisiRiyuuKbn(String value) {
        super(value);
    }

    public static C_DsMailSousinTeisiRiyuuKbn valueOf(String value) {
        return valueOf(C_DsMailSousinTeisiRiyuuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DsMailSousinTeisiRiyuuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DsMailSousinTeisiRiyuuKbn.class, patternId, value);
    }
}
