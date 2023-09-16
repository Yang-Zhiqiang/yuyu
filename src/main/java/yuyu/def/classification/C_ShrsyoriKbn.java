
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 支払処理区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_ShrsyoriKbn</td><td colspan="3">支払処理区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="15">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKTORIKESI}</td><td>&quot;11&quot;</td><td>契約取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CLGOFF}</td><td>&quot;12&quot;</td><td>クーリングオフ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIJO}</td><td>&quot;13&quot;</td><td>解除</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBKAIJO}</td><td>&quot;16&quot;</td><td>死亡解除</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKU}</td><td>&quot;21&quot;</td><td>解約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GENGAKU}</td><td>&quot;23&quot;</td><td>減額</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YENDTHNKHRSHR}</td><td>&quot;25&quot;</td><td>円建変更時返戻金支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DSHR}</td><td>&quot;26&quot;</td><td>配当金支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PMINYUUSYOUMETU}</td><td>&quot;27&quot;</td><td>Ｐ未入消滅</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DSEISANTUIBARAI}</td><td>&quot;28&quot;</td><td>Ｄ精算追払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEINENGAPPISEI}</td><td>&quot;31&quot;</td><td>生年月日・性訂正</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBMUKOU_KIHRKPSHR}</td><td>&quot;32&quot;</td><td>死亡無効（既払Ｐ支払）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBMENSEKI}</td><td>&quot;33&quot;</td><td>死亡免責</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;99&quot;</td><td>その他</td></tr>
 * </table>
 */
public class C_ShrsyoriKbn extends Classification<C_ShrsyoriKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_ShrsyoriKbn BLNK = new C_ShrsyoriKbn("0");

    public static final C_ShrsyoriKbn KYKTORIKESI = new C_ShrsyoriKbn("11");

    public static final C_ShrsyoriKbn CLGOFF = new C_ShrsyoriKbn("12");

    public static final C_ShrsyoriKbn KAIJO = new C_ShrsyoriKbn("13");

    public static final C_ShrsyoriKbn SBKAIJO = new C_ShrsyoriKbn("16");

    public static final C_ShrsyoriKbn KAIYAKU = new C_ShrsyoriKbn("21");

    public static final C_ShrsyoriKbn GENGAKU = new C_ShrsyoriKbn("23");

    public static final C_ShrsyoriKbn YENDTHNKHRSHR = new C_ShrsyoriKbn("25");

    public static final C_ShrsyoriKbn DSHR = new C_ShrsyoriKbn("26");

    public static final C_ShrsyoriKbn PMINYUUSYOUMETU = new C_ShrsyoriKbn("27");

    public static final C_ShrsyoriKbn DSEISANTUIBARAI = new C_ShrsyoriKbn("28");

    public static final C_ShrsyoriKbn SEINENGAPPISEI = new C_ShrsyoriKbn("31");

    public static final C_ShrsyoriKbn SBMUKOU_KIHRKPSHR = new C_ShrsyoriKbn("32");

    public static final C_ShrsyoriKbn SBMENSEKI = new C_ShrsyoriKbn("33");

    public static final C_ShrsyoriKbn SONOTA = new C_ShrsyoriKbn("99");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KYKTORIKESI, "KYKTORIKESI", false);
        addPattern(PATTERN_DEFAULT, CLGOFF, "CLGOFF", false);
        addPattern(PATTERN_DEFAULT, KAIJO, "KAIJO", false);
        addPattern(PATTERN_DEFAULT, SBKAIJO, "SBKAIJO", false);
        addPattern(PATTERN_DEFAULT, KAIYAKU, "KAIYAKU", false);
        addPattern(PATTERN_DEFAULT, GENGAKU, "GENGAKU", false);
        addPattern(PATTERN_DEFAULT, YENDTHNKHRSHR, "YENDTHNKHRSHR", false);
        addPattern(PATTERN_DEFAULT, DSHR, "DSHR", false);
        addPattern(PATTERN_DEFAULT, PMINYUUSYOUMETU, "PMINYUUSYOUMETU", false);
        addPattern(PATTERN_DEFAULT, DSEISANTUIBARAI, "DSEISANTUIBARAI", false);
        addPattern(PATTERN_DEFAULT, SEINENGAPPISEI, "SEINENGAPPISEI", false);
        addPattern(PATTERN_DEFAULT, SBMUKOU_KIHRKPSHR, "SBMUKOU_KIHRKPSHR", false);
        addPattern(PATTERN_DEFAULT, SBMENSEKI, "SBMENSEKI", false);
        addPattern(PATTERN_DEFAULT, SONOTA, "SONOTA", false);


        lock(C_ShrsyoriKbn.class);
    }

    private C_ShrsyoriKbn(String value) {
        super(value);
    }

    public static C_ShrsyoriKbn valueOf(String value) {
        return valueOf(C_ShrsyoriKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_ShrsyoriKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_ShrsyoriKbn.class, patternId, value);
    }
}
