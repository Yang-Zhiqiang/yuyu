
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 消滅事由 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Syoumetujiyuu</td><td colspan="3">消滅事由</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="29">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
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
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOUSAIGAIHIGAITOU}</td><td>&quot;22&quot;</td><td>死亡災害非該当</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOUSAIGAIMENSEKI}</td><td>&quot;23&quot;</td><td>死亡災害免責</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUDOSYOUGAI}</td><td>&quot;25&quot;</td><td>高度障害</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #LN}</td><td>&quot;29&quot;</td><td>ＬＮ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MANKI}</td><td>&quot;30&quot;</td><td>満期</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MNRY}</td><td>&quot;31&quot;</td><td>満了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NKRENDOU}</td><td>&quot;32&quot;</td><td>年金連動</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKU}</td><td>&quot;40&quot;</td><td>解約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIKKOUKAIYAKU}</td><td>&quot;41&quot;</td><td>失効後解約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PMNYSYMET_JDSKN_SSNZM}</td><td>&quot;42&quot;</td><td>Ｐ未入消滅（自動送金精算済）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PMNYSYMET_JDSKNGAI_SSNZM}</td><td>&quot;43&quot;</td><td>Ｐ未入消滅（自動送金外精算済）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIKKOU}</td><td>&quot;50&quot;</td><td>失効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PMNYSYMET_MSSN}</td><td>&quot;51&quot;</td><td>Ｐ未入消滅（未精算）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TSNGNDTYOUKA}</td><td>&quot;60&quot;</td><td>通算限度超過</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SANDAISIP}</td><td>&quot;61&quot;</td><td>３大疾病</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOSMUKOU}</td><td>&quot;62&quot;</td><td>申出無効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIKOU}</td><td>&quot;90&quot;</td><td>時効</td></tr>
 * </table>
 */
public class C_Syoumetujiyuu extends Classification<C_Syoumetujiyuu> {

    private static final long serialVersionUID = 1L;


    public static final C_Syoumetujiyuu BLNK = new C_Syoumetujiyuu("0");

    public static final C_Syoumetujiyuu KYKTORIKESI = new C_Syoumetujiyuu("11");

    public static final C_Syoumetujiyuu CLGOFF = new C_Syoumetujiyuu("12");

    public static final C_Syoumetujiyuu KAIJO = new C_Syoumetujiyuu("13");

    public static final C_Syoumetujiyuu MENSEKI = new C_Syoumetujiyuu("14");

    public static final C_Syoumetujiyuu MUKOU = new C_Syoumetujiyuu("15");

    public static final C_Syoumetujiyuu SBMUKOU = new C_Syoumetujiyuu("16");

    public static final C_Syoumetujiyuu SBKAIJO = new C_Syoumetujiyuu("17");

    public static final C_Syoumetujiyuu MUKOU_1PMINYUUKIN = new C_Syoumetujiyuu("18");

    public static final C_Syoumetujiyuu GANMUKOU = new C_Syoumetujiyuu("19");

    public static final C_Syoumetujiyuu SIBOU = new C_Syoumetujiyuu("20");

    public static final C_Syoumetujiyuu SIBOUKYUUHUKINSHR = new C_Syoumetujiyuu("21");

    public static final C_Syoumetujiyuu SIBOUSAIGAIHIGAITOU = new C_Syoumetujiyuu("22");

    public static final C_Syoumetujiyuu SIBOUSAIGAIMENSEKI = new C_Syoumetujiyuu("23");

    public static final C_Syoumetujiyuu KOUDOSYOUGAI = new C_Syoumetujiyuu("25");

    public static final C_Syoumetujiyuu LN = new C_Syoumetujiyuu("29");

    public static final C_Syoumetujiyuu MANKI = new C_Syoumetujiyuu("30");

    public static final C_Syoumetujiyuu MNRY = new C_Syoumetujiyuu("31");

    public static final C_Syoumetujiyuu NKRENDOU = new C_Syoumetujiyuu("32");

    public static final C_Syoumetujiyuu KAIYAKU = new C_Syoumetujiyuu("40");

    public static final C_Syoumetujiyuu SIKKOUKAIYAKU = new C_Syoumetujiyuu("41");

    public static final C_Syoumetujiyuu PMNYSYMET_JDSKN_SSNZM = new C_Syoumetujiyuu("42");

    public static final C_Syoumetujiyuu PMNYSYMET_JDSKNGAI_SSNZM = new C_Syoumetujiyuu("43");

    public static final C_Syoumetujiyuu SIKKOU = new C_Syoumetujiyuu("50");

    public static final C_Syoumetujiyuu PMNYSYMET_MSSN = new C_Syoumetujiyuu("51");

    public static final C_Syoumetujiyuu TSNGNDTYOUKA = new C_Syoumetujiyuu("60");

    public static final C_Syoumetujiyuu SANDAISIP = new C_Syoumetujiyuu("61");

    public static final C_Syoumetujiyuu MOSMUKOU = new C_Syoumetujiyuu("62");

    public static final C_Syoumetujiyuu JIKOU = new C_Syoumetujiyuu("90");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
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
        addPattern(PATTERN_DEFAULT, SIBOUSAIGAIHIGAITOU, "SIBOUSAIGAIHIGAITOU", false);
        addPattern(PATTERN_DEFAULT, SIBOUSAIGAIMENSEKI, "SIBOUSAIGAIMENSEKI", false);
        addPattern(PATTERN_DEFAULT, KOUDOSYOUGAI, "KOUDOSYOUGAI", false);
        addPattern(PATTERN_DEFAULT, LN, "LN", false);
        addPattern(PATTERN_DEFAULT, MANKI, "MANKI", false);
        addPattern(PATTERN_DEFAULT, MNRY, "MNRY", false);
        addPattern(PATTERN_DEFAULT, NKRENDOU, "NKRENDOU", false);
        addPattern(PATTERN_DEFAULT, KAIYAKU, "KAIYAKU", false);
        addPattern(PATTERN_DEFAULT, SIKKOUKAIYAKU, "SIKKOUKAIYAKU", false);
        addPattern(PATTERN_DEFAULT, PMNYSYMET_JDSKN_SSNZM, "PMNYSYMET_JDSKN_SSNZM", false);
        addPattern(PATTERN_DEFAULT, PMNYSYMET_JDSKNGAI_SSNZM, "PMNYSYMET_JDSKNGAI_SSNZM", false);
        addPattern(PATTERN_DEFAULT, SIKKOU, "SIKKOU", false);
        addPattern(PATTERN_DEFAULT, PMNYSYMET_MSSN, "PMNYSYMET_MSSN", false);
        addPattern(PATTERN_DEFAULT, TSNGNDTYOUKA, "TSNGNDTYOUKA", false);
        addPattern(PATTERN_DEFAULT, SANDAISIP, "SANDAISIP", false);
        addPattern(PATTERN_DEFAULT, MOSMUKOU, "MOSMUKOU", false);
        addPattern(PATTERN_DEFAULT, JIKOU, "JIKOU", false);


        lock(C_Syoumetujiyuu.class);
    }

    private C_Syoumetujiyuu(String value) {
        super(value);
    }

    public static C_Syoumetujiyuu valueOf(String value) {
        return valueOf(C_Syoumetujiyuu.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Syoumetujiyuu.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Syoumetujiyuu.class, patternId, value);
    }
}
