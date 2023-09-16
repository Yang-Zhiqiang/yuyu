
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 数理異動区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SuuriIdoKbn</td><td colspan="3">数理異動区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="37">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINENGAPPISEITEISEI}</td><td>&quot;1&quot;</td><td>生年月日・性訂正</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GENGAKU}</td><td>&quot;2&quot;</td><td>減額</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOKUHYOURITUHENKOU}</td><td>&quot;3&quot;</td><td>目標率変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YENDTHENKOU}</td><td>&quot;4&quot;</td><td>円建変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YENDTHENKOUTRKS}</td><td>&quot;5&quot;</td><td>円建変更取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKTORIKESI}</td><td>&quot;11&quot;</td><td>契約取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CLGOFF}</td><td>&quot;12&quot;</td><td>クーリングオフ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIJO}</td><td>&quot;13&quot;</td><td>生存解除</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MENSEKI}</td><td>&quot;14&quot;</td><td>死亡免責</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MUKOU}</td><td>&quot;15&quot;</td><td>無効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBMUKOU}</td><td>&quot;16&quot;</td><td>死亡無効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBKAIJO}</td><td>&quot;17&quot;</td><td>死亡解除</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MUKOU_1PMINYUUKIN}</td><td>&quot;18&quot;</td><td>無効（第１回保険料未入金）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GANMUKOU}</td><td>&quot;19&quot;</td><td>がん無効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOU}</td><td>&quot;20&quot;</td><td>死亡</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOUKYUUHUKINSHR}</td><td>&quot;21&quot;</td><td>死亡給付金支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBMUKOU_KIHRKPSHR}</td><td>&quot;22&quot;</td><td>死亡無効（既払Ｐ支払）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBMUKOU_SHRNASI}</td><td>&quot;23&quot;</td><td>死亡無効（支払なし）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUDOSYOUGAI}</td><td>&quot;25&quot;</td><td>高度障害</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #LN}</td><td>&quot;29&quot;</td><td>ＬＮ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MANKI}</td><td>&quot;30&quot;</td><td>満期</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MNRY}</td><td>&quot;31&quot;</td><td>満了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NKRENDOU}</td><td>&quot;32&quot;</td><td>年金連動</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKU}</td><td>&quot;40&quot;</td><td>解約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIKKOUKAIYAKU}</td><td>&quot;41&quot;</td><td>失効後解約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIKKOU}</td><td>&quot;50&quot;</td><td>失効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TSNGNDTYOUKA}</td><td>&quot;60&quot;</td><td>通算限度超過</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SANDAISIP}</td><td>&quot;61&quot;</td><td>３大疾病</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOSMUKOU}</td><td>&quot;62&quot;</td><td>申出無効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIKOU}</td><td>&quot;90&quot;</td><td>時効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SISUUTUMIMASI}</td><td>&quot;101&quot;</td><td>指数積増</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SISUUTUMIMASITRKS}</td><td>&quot;102&quot;</td><td>指数積増取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEIRITUITEN}</td><td>&quot;103&quot;</td><td>定率移転</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEIRITUITENTRKS}</td><td>&quot;104&quot;</td><td>定率移転取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PMINYUUSYOUMETU}</td><td>&quot;105&quot;</td><td>Ｐ未入消滅</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HARAIKATAHNK}</td><td>&quot;106&quot;</td><td>払方変更</td></tr>
 * </table>
 */
public class C_SuuriIdoKbn extends Classification<C_SuuriIdoKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SuuriIdoKbn BLNK = new C_SuuriIdoKbn("0");

    public static final C_SuuriIdoKbn SINENGAPPISEITEISEI = new C_SuuriIdoKbn("1");

    public static final C_SuuriIdoKbn GENGAKU = new C_SuuriIdoKbn("2");

    public static final C_SuuriIdoKbn MOKUHYOURITUHENKOU = new C_SuuriIdoKbn("3");

    public static final C_SuuriIdoKbn YENDTHENKOU = new C_SuuriIdoKbn("4");

    public static final C_SuuriIdoKbn YENDTHENKOUTRKS = new C_SuuriIdoKbn("5");

    public static final C_SuuriIdoKbn KYKTORIKESI = new C_SuuriIdoKbn("11");

    public static final C_SuuriIdoKbn CLGOFF = new C_SuuriIdoKbn("12");

    public static final C_SuuriIdoKbn KAIJO = new C_SuuriIdoKbn("13");

    public static final C_SuuriIdoKbn MENSEKI = new C_SuuriIdoKbn("14");

    public static final C_SuuriIdoKbn MUKOU = new C_SuuriIdoKbn("15");

    public static final C_SuuriIdoKbn SBMUKOU = new C_SuuriIdoKbn("16");

    public static final C_SuuriIdoKbn SBKAIJO = new C_SuuriIdoKbn("17");

    public static final C_SuuriIdoKbn MUKOU_1PMINYUUKIN = new C_SuuriIdoKbn("18");

    public static final C_SuuriIdoKbn GANMUKOU = new C_SuuriIdoKbn("19");

    public static final C_SuuriIdoKbn SIBOU = new C_SuuriIdoKbn("20");

    public static final C_SuuriIdoKbn SIBOUKYUUHUKINSHR = new C_SuuriIdoKbn("21");

    public static final C_SuuriIdoKbn SBMUKOU_KIHRKPSHR = new C_SuuriIdoKbn("22");

    public static final C_SuuriIdoKbn SBMUKOU_SHRNASI = new C_SuuriIdoKbn("23");

    public static final C_SuuriIdoKbn KOUDOSYOUGAI = new C_SuuriIdoKbn("25");

    public static final C_SuuriIdoKbn LN = new C_SuuriIdoKbn("29");

    public static final C_SuuriIdoKbn MANKI = new C_SuuriIdoKbn("30");

    public static final C_SuuriIdoKbn MNRY = new C_SuuriIdoKbn("31");

    public static final C_SuuriIdoKbn NKRENDOU = new C_SuuriIdoKbn("32");

    public static final C_SuuriIdoKbn KAIYAKU = new C_SuuriIdoKbn("40");

    public static final C_SuuriIdoKbn SIKKOUKAIYAKU = new C_SuuriIdoKbn("41");

    public static final C_SuuriIdoKbn SIKKOU = new C_SuuriIdoKbn("50");

    public static final C_SuuriIdoKbn TSNGNDTYOUKA = new C_SuuriIdoKbn("60");

    public static final C_SuuriIdoKbn SANDAISIP = new C_SuuriIdoKbn("61");

    public static final C_SuuriIdoKbn MOSMUKOU = new C_SuuriIdoKbn("62");

    public static final C_SuuriIdoKbn JIKOU = new C_SuuriIdoKbn("90");

    public static final C_SuuriIdoKbn SISUUTUMIMASI = new C_SuuriIdoKbn("101");

    public static final C_SuuriIdoKbn SISUUTUMIMASITRKS = new C_SuuriIdoKbn("102");

    public static final C_SuuriIdoKbn TEIRITUITEN = new C_SuuriIdoKbn("103");

    public static final C_SuuriIdoKbn TEIRITUITENTRKS = new C_SuuriIdoKbn("104");

    public static final C_SuuriIdoKbn PMINYUUSYOUMETU = new C_SuuriIdoKbn("105");

    public static final C_SuuriIdoKbn HARAIKATAHNK = new C_SuuriIdoKbn("106");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SINENGAPPISEITEISEI, "SINENGAPPISEITEISEI", false);
        addPattern(PATTERN_DEFAULT, GENGAKU, "GENGAKU", false);
        addPattern(PATTERN_DEFAULT, MOKUHYOURITUHENKOU, "MOKUHYOURITUHENKOU", false);
        addPattern(PATTERN_DEFAULT, YENDTHENKOU, "YENDTHENKOU", false);
        addPattern(PATTERN_DEFAULT, YENDTHENKOUTRKS, "YENDTHENKOUTRKS", false);
        addPattern(PATTERN_DEFAULT, KYKTORIKESI, "KYKTORIKESI", false);
        addPattern(PATTERN_DEFAULT, CLGOFF, "CLGOFF", false);
        addPattern(PATTERN_DEFAULT, KAIJO, "KAIJO", false);
        addPattern(PATTERN_DEFAULT, MENSEKI, "MENSEKI", false);
        addPattern(PATTERN_DEFAULT, MUKOU, "MUKOU", false);
        addPattern(PATTERN_DEFAULT, SBMUKOU, "SBMUKOU", false);
        addPattern(PATTERN_DEFAULT, SBKAIJO, "SBKAIJO", false);
        addPattern(PATTERN_DEFAULT, MUKOU_1PMINYUUKIN, "MUKOU_1PMINYUUKIN", false);
        addPattern(PATTERN_DEFAULT, GANMUKOU, "GANMUKOU", false);
        addPattern(PATTERN_DEFAULT, SIBOU, "SIBOU", false);
        addPattern(PATTERN_DEFAULT, SIBOUKYUUHUKINSHR, "SIBOUKYUUHUKINSHR", false);
        addPattern(PATTERN_DEFAULT, SBMUKOU_KIHRKPSHR, "SBMUKOU_KIHRKPSHR", false);
        addPattern(PATTERN_DEFAULT, SBMUKOU_SHRNASI, "SBMUKOU_SHRNASI", false);
        addPattern(PATTERN_DEFAULT, KOUDOSYOUGAI, "KOUDOSYOUGAI", false);
        addPattern(PATTERN_DEFAULT, LN, "LN", false);
        addPattern(PATTERN_DEFAULT, MANKI, "MANKI", false);
        addPattern(PATTERN_DEFAULT, MNRY, "MNRY", false);
        addPattern(PATTERN_DEFAULT, NKRENDOU, "NKRENDOU", false);
        addPattern(PATTERN_DEFAULT, KAIYAKU, "KAIYAKU", false);
        addPattern(PATTERN_DEFAULT, SIKKOUKAIYAKU, "SIKKOUKAIYAKU", false);
        addPattern(PATTERN_DEFAULT, SIKKOU, "SIKKOU", false);
        addPattern(PATTERN_DEFAULT, TSNGNDTYOUKA, "TSNGNDTYOUKA", false);
        addPattern(PATTERN_DEFAULT, SANDAISIP, "SANDAISIP", false);
        addPattern(PATTERN_DEFAULT, MOSMUKOU, "MOSMUKOU", false);
        addPattern(PATTERN_DEFAULT, JIKOU, "JIKOU", false);
        addPattern(PATTERN_DEFAULT, SISUUTUMIMASI, "SISUUTUMIMASI", false);
        addPattern(PATTERN_DEFAULT, SISUUTUMIMASITRKS, "SISUUTUMIMASITRKS", false);
        addPattern(PATTERN_DEFAULT, TEIRITUITEN, "TEIRITUITEN", false);
        addPattern(PATTERN_DEFAULT, TEIRITUITENTRKS, "TEIRITUITENTRKS", false);
        addPattern(PATTERN_DEFAULT, PMINYUUSYOUMETU, "PMINYUUSYOUMETU", false);
        addPattern(PATTERN_DEFAULT, HARAIKATAHNK, "HARAIKATAHNK", false);


        lock(C_SuuriIdoKbn.class);
    }

    private C_SuuriIdoKbn(String value) {
        super(value);
    }

    public static C_SuuriIdoKbn valueOf(String value) {
        return valueOf(C_SuuriIdoKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SuuriIdoKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SuuriIdoKbn.class, patternId, value);
    }
}
