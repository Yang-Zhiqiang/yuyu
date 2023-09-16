
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 支払先請求者区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_ShrsakiSeikyuusyaKbn</td><td colspan="3">支払先請求者区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKN}</td><td>&quot;1&quot;</td><td>被保険者</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SITEIDAIRI}</td><td>&quot;2&quot;</td><td>指定代理人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUKENNIN}</td><td>&quot;3&quot;</td><td>後見人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOUZOKUNIN}</td><td>&quot;4&quot;</td><td>相続人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;9&quot;</td><td>その他</td></tr>
 * </table>
 */
public class C_ShrsakiSeikyuusyaKbn extends Classification<C_ShrsakiSeikyuusyaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_ShrsakiSeikyuusyaKbn BLNK = new C_ShrsakiSeikyuusyaKbn("0");

    public static final C_ShrsakiSeikyuusyaKbn HHKN = new C_ShrsakiSeikyuusyaKbn("1");

    public static final C_ShrsakiSeikyuusyaKbn SITEIDAIRI = new C_ShrsakiSeikyuusyaKbn("2");

    public static final C_ShrsakiSeikyuusyaKbn KOUKENNIN = new C_ShrsakiSeikyuusyaKbn("3");

    public static final C_ShrsakiSeikyuusyaKbn SOUZOKUNIN = new C_ShrsakiSeikyuusyaKbn("4");

    public static final C_ShrsakiSeikyuusyaKbn SONOTA = new C_ShrsakiSeikyuusyaKbn("9");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HHKN, "HHKN", false);
        addPattern(PATTERN_DEFAULT, SITEIDAIRI, "SITEIDAIRI", false);
        addPattern(PATTERN_DEFAULT, KOUKENNIN, "KOUKENNIN", false);
        addPattern(PATTERN_DEFAULT, SOUZOKUNIN, "SOUZOKUNIN", false);
        addPattern(PATTERN_DEFAULT, SONOTA, "SONOTA", false);


        lock(C_ShrsakiSeikyuusyaKbn.class);
    }

    private C_ShrsakiSeikyuusyaKbn(String value) {
        super(value);
    }

    public static C_ShrsakiSeikyuusyaKbn valueOf(String value) {
        return valueOf(C_ShrsakiSeikyuusyaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_ShrsakiSeikyuusyaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_ShrsakiSeikyuusyaKbn.class, patternId, value);
    }
}
