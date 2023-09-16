
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 決定理由コード クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Ketriyuucd</td><td colspan="3">決定理由コード</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="29">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKN_TAIKAKU}</td><td>&quot;01&quot;</td><td>被保険者体格</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKN_GENSYOU}</td><td>&quot;04&quot;</td><td>被保険者現症</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKN_KIOUSYOU}</td><td>&quot;05&quot;</td><td>被保険者既往症</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKN_NINSIN}</td><td>&quot;06&quot;</td><td>被保険者妊娠</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKN_TOUSYAKIOUSYOU}</td><td>&quot;11&quot;</td><td>被保険者当社既往歴</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKN_BOSITETYOUSYOKEN}</td><td>&quot;13&quot;</td><td>被保険者母子手帳所見</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKN_DOUTOKUHUAN}</td><td>&quot;15&quot;</td><td>被保険者道徳不安</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKN_SYOKUGYOU}</td><td>&quot;16&quot;</td><td>被保険者職業</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKN_TOUSYAKYUUHUREKI}</td><td>&quot;19&quot;</td><td>被保険者当社給付歴</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYK_DOUTOKUHUAN}</td><td>&quot;35&quot;</td><td>契約者道徳不安</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYK_SYOKUGYOU}</td><td>&quot;36&quot;</td><td>契約者職業</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SSEIGEN}</td><td>&quot;70&quot;</td><td>Ｓ制限</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NENSYO}</td><td>&quot;81&quot;</td><td>念書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKKAKUNINISYOU}</td><td>&quot;82&quot;</td><td>契約確認医証</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ISYOU_KENSINKEKKA}</td><td>&quot;83&quot;</td><td>医証･健診結果</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TASYASYOUKEN}</td><td>&quot;84&quot;</td><td>他社証券(具申)</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JUUDAISIKKAN}</td><td>&quot;85&quot;</td><td>重大疾患</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JUUDAISIKKANUTAGAI}</td><td>&quot;86&quot;</td><td>重大疾患疑い</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DOUGAKUTOKUNIN}</td><td>&quot;90&quot;</td><td>同額特認</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TORIATUKAIJIJOU}</td><td>&quot;91&quot;</td><td>取扱事情</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SISYAKETTEIKEKKA}</td><td>&quot;92&quot;</td><td>支社決定結果</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOUJOUHANDAN}</td><td>&quot;93&quot;</td><td>報状判断</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SISYAHOUKOKU}</td><td>&quot;94&quot;</td><td>支社報告</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKKAKUNINKETTEI}</td><td>&quot;95&quot;</td><td>契約確認決定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZENINDOUTOKUHUAN}</td><td>&quot;96&quot;</td><td>全員道徳不安</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKKANKEI}</td><td>&quot;97&quot;</td><td>契約関係</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NAIKI}</td><td>&quot;98&quot;</td><td>内規</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOUGOU}</td><td>&quot;99&quot;</td><td>総合</td></tr>
 *  <tr><td rowspan="28">{@link #PATTERN_ITIRAN ITIRAN}<br />(一覧)</td><td align="center">&nbsp;</td><td>{@link #HHKN_TAIKAKU}</td><td>&quot;01&quot;</td><td>被保険者体格</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKN_GENSYOU}</td><td>&quot;04&quot;</td><td>被保険者現症</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKN_KIOUSYOU}</td><td>&quot;05&quot;</td><td>被保険者既往症</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKN_NINSIN}</td><td>&quot;06&quot;</td><td>被保険者妊娠</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKN_TOUSYAKIOUSYOU}</td><td>&quot;11&quot;</td><td>被保険者当社既往歴</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKN_BOSITETYOUSYOKEN}</td><td>&quot;13&quot;</td><td>被保険者母子手帳所見</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKN_DOUTOKUHUAN}</td><td>&quot;15&quot;</td><td>被保険者道徳不安</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKN_SYOKUGYOU}</td><td>&quot;16&quot;</td><td>被保険者職業</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKN_TOUSYAKYUUHUREKI}</td><td>&quot;19&quot;</td><td>被保険者当社給付歴</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYK_DOUTOKUHUAN}</td><td>&quot;35&quot;</td><td>契約者道徳不安</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYK_SYOKUGYOU}</td><td>&quot;36&quot;</td><td>契約者職業</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SSEIGEN}</td><td>&quot;70&quot;</td><td>Ｓ制限</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NENSYO}</td><td>&quot;81&quot;</td><td>念書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKKAKUNINISYOU}</td><td>&quot;82&quot;</td><td>契約確認医証</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ISYOU_KENSINKEKKA}</td><td>&quot;83&quot;</td><td>医証･健診結果</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TASYASYOUKEN}</td><td>&quot;84&quot;</td><td>他社証券(具申)</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JUUDAISIKKAN}</td><td>&quot;85&quot;</td><td>重大疾患</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JUUDAISIKKANUTAGAI}</td><td>&quot;86&quot;</td><td>重大疾患疑い</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DOUGAKUTOKUNIN}</td><td>&quot;90&quot;</td><td>同額特認</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TORIATUKAIJIJOU}</td><td>&quot;91&quot;</td><td>取扱事情</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SISYAKETTEIKEKKA}</td><td>&quot;92&quot;</td><td>支社決定結果</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOUJOUHANDAN}</td><td>&quot;93&quot;</td><td>報状判断</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SISYAHOUKOKU}</td><td>&quot;94&quot;</td><td>支社報告</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKKAKUNINKETTEI}</td><td>&quot;95&quot;</td><td>契約確認決定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZENINDOUTOKUHUAN}</td><td>&quot;96&quot;</td><td>全員道徳不安</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKKANKEI}</td><td>&quot;97&quot;</td><td>契約関係</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NAIKI}</td><td>&quot;98&quot;</td><td>内規</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOUGOU}</td><td>&quot;99&quot;</td><td>総合</td></tr>
 * </table>
 */
public class C_Ketriyuucd extends Classification<C_Ketriyuucd> {

    private static final long serialVersionUID = 1L;


    public static final C_Ketriyuucd BLNK = new C_Ketriyuucd("0");

    public static final C_Ketriyuucd HHKN_TAIKAKU = new C_Ketriyuucd("01");

    public static final C_Ketriyuucd HHKN_GENSYOU = new C_Ketriyuucd("04");

    public static final C_Ketriyuucd HHKN_KIOUSYOU = new C_Ketriyuucd("05");

    public static final C_Ketriyuucd HHKN_NINSIN = new C_Ketriyuucd("06");

    public static final C_Ketriyuucd HHKN_TOUSYAKIOUSYOU = new C_Ketriyuucd("11");

    public static final C_Ketriyuucd HHKN_BOSITETYOUSYOKEN = new C_Ketriyuucd("13");

    public static final C_Ketriyuucd HHKN_DOUTOKUHUAN = new C_Ketriyuucd("15");

    public static final C_Ketriyuucd HHKN_SYOKUGYOU = new C_Ketriyuucd("16");

    public static final C_Ketriyuucd HHKN_TOUSYAKYUUHUREKI = new C_Ketriyuucd("19");

    public static final C_Ketriyuucd KYK_DOUTOKUHUAN = new C_Ketriyuucd("35");

    public static final C_Ketriyuucd KYK_SYOKUGYOU = new C_Ketriyuucd("36");

    public static final C_Ketriyuucd SSEIGEN = new C_Ketriyuucd("70");

    public static final C_Ketriyuucd NENSYO = new C_Ketriyuucd("81");

    public static final C_Ketriyuucd KYKKAKUNINISYOU = new C_Ketriyuucd("82");

    public static final C_Ketriyuucd ISYOU_KENSINKEKKA = new C_Ketriyuucd("83");

    public static final C_Ketriyuucd TASYASYOUKEN = new C_Ketriyuucd("84");

    public static final C_Ketriyuucd JUUDAISIKKAN = new C_Ketriyuucd("85");

    public static final C_Ketriyuucd JUUDAISIKKANUTAGAI = new C_Ketriyuucd("86");

    public static final C_Ketriyuucd DOUGAKUTOKUNIN = new C_Ketriyuucd("90");

    public static final C_Ketriyuucd TORIATUKAIJIJOU = new C_Ketriyuucd("91");

    public static final C_Ketriyuucd SISYAKETTEIKEKKA = new C_Ketriyuucd("92");

    public static final C_Ketriyuucd HOUJOUHANDAN = new C_Ketriyuucd("93");

    public static final C_Ketriyuucd SISYAHOUKOKU = new C_Ketriyuucd("94");

    public static final C_Ketriyuucd KYKKAKUNINKETTEI = new C_Ketriyuucd("95");

    public static final C_Ketriyuucd ZENINDOUTOKUHUAN = new C_Ketriyuucd("96");

    public static final C_Ketriyuucd KYKKANKEI = new C_Ketriyuucd("97");

    public static final C_Ketriyuucd NAIKI = new C_Ketriyuucd("98");

    public static final C_Ketriyuucd SOUGOU = new C_Ketriyuucd("99");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_ITIRAN = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HHKN_TAIKAKU, "HHKN_TAIKAKU", false);
        addPattern(PATTERN_DEFAULT, HHKN_GENSYOU, "HHKN_GENSYOU", false);
        addPattern(PATTERN_DEFAULT, HHKN_KIOUSYOU, "HHKN_KIOUSYOU", false);
        addPattern(PATTERN_DEFAULT, HHKN_NINSIN, "HHKN_NINSIN", false);
        addPattern(PATTERN_DEFAULT, HHKN_TOUSYAKIOUSYOU, "HHKN_TOUSYAKIOUSYOU", false);
        addPattern(PATTERN_DEFAULT, HHKN_BOSITETYOUSYOKEN, "HHKN_BOSITETYOUSYOKEN", false);
        addPattern(PATTERN_DEFAULT, HHKN_DOUTOKUHUAN, "HHKN_DOUTOKUHUAN", false);
        addPattern(PATTERN_DEFAULT, HHKN_SYOKUGYOU, "HHKN_SYOKUGYOU", false);
        addPattern(PATTERN_DEFAULT, HHKN_TOUSYAKYUUHUREKI, "HHKN_TOUSYAKYUUHUREKI", false);
        addPattern(PATTERN_DEFAULT, KYK_DOUTOKUHUAN, "KYK_DOUTOKUHUAN", false);
        addPattern(PATTERN_DEFAULT, KYK_SYOKUGYOU, "KYK_SYOKUGYOU", false);
        addPattern(PATTERN_DEFAULT, SSEIGEN, "SSEIGEN", false);
        addPattern(PATTERN_DEFAULT, NENSYO, "NENSYO", false);
        addPattern(PATTERN_DEFAULT, KYKKAKUNINISYOU, "KYKKAKUNINISYOU", false);
        addPattern(PATTERN_DEFAULT, ISYOU_KENSINKEKKA, "ISYOU_KENSINKEKKA", false);
        addPattern(PATTERN_DEFAULT, TASYASYOUKEN, "TASYASYOUKEN", false);
        addPattern(PATTERN_DEFAULT, JUUDAISIKKAN, "JUUDAISIKKAN", false);
        addPattern(PATTERN_DEFAULT, JUUDAISIKKANUTAGAI, "JUUDAISIKKANUTAGAI", false);
        addPattern(PATTERN_DEFAULT, DOUGAKUTOKUNIN, "DOUGAKUTOKUNIN", false);
        addPattern(PATTERN_DEFAULT, TORIATUKAIJIJOU, "TORIATUKAIJIJOU", false);
        addPattern(PATTERN_DEFAULT, SISYAKETTEIKEKKA, "SISYAKETTEIKEKKA", false);
        addPattern(PATTERN_DEFAULT, HOUJOUHANDAN, "HOUJOUHANDAN", false);
        addPattern(PATTERN_DEFAULT, SISYAHOUKOKU, "SISYAHOUKOKU", false);
        addPattern(PATTERN_DEFAULT, KYKKAKUNINKETTEI, "KYKKAKUNINKETTEI", false);
        addPattern(PATTERN_DEFAULT, ZENINDOUTOKUHUAN, "ZENINDOUTOKUHUAN", false);
        addPattern(PATTERN_DEFAULT, KYKKANKEI, "KYKKANKEI", false);
        addPattern(PATTERN_DEFAULT, NAIKI, "NAIKI", false);
        addPattern(PATTERN_DEFAULT, SOUGOU, "SOUGOU", false);


        addPattern(PATTERN_ITIRAN, HHKN_TAIKAKU, "HHKN_TAIKAKU", false);
        addPattern(PATTERN_ITIRAN, HHKN_GENSYOU, "HHKN_GENSYOU", false);
        addPattern(PATTERN_ITIRAN, HHKN_KIOUSYOU, "HHKN_KIOUSYOU", false);
        addPattern(PATTERN_ITIRAN, HHKN_NINSIN, "HHKN_NINSIN", false);
        addPattern(PATTERN_ITIRAN, HHKN_TOUSYAKIOUSYOU, "HHKN_TOUSYAKIOUSYOU", false);
        addPattern(PATTERN_ITIRAN, HHKN_BOSITETYOUSYOKEN, "HHKN_BOSITETYOUSYOKEN", false);
        addPattern(PATTERN_ITIRAN, HHKN_DOUTOKUHUAN, "HHKN_DOUTOKUHUAN", false);
        addPattern(PATTERN_ITIRAN, HHKN_SYOKUGYOU, "HHKN_SYOKUGYOU", false);
        addPattern(PATTERN_ITIRAN, HHKN_TOUSYAKYUUHUREKI, "HHKN_TOUSYAKYUUHUREKI", false);
        addPattern(PATTERN_ITIRAN, KYK_DOUTOKUHUAN, "KYK_DOUTOKUHUAN", false);
        addPattern(PATTERN_ITIRAN, KYK_SYOKUGYOU, "KYK_SYOKUGYOU", false);
        addPattern(PATTERN_ITIRAN, SSEIGEN, "SSEIGEN", false);
        addPattern(PATTERN_ITIRAN, NENSYO, "NENSYO", false);
        addPattern(PATTERN_ITIRAN, KYKKAKUNINISYOU, "KYKKAKUNINISYOU", false);
        addPattern(PATTERN_ITIRAN, ISYOU_KENSINKEKKA, "ISYOU_KENSINKEKKA", false);
        addPattern(PATTERN_ITIRAN, TASYASYOUKEN, "TASYASYOUKEN", false);
        addPattern(PATTERN_ITIRAN, JUUDAISIKKAN, "JUUDAISIKKAN", false);
        addPattern(PATTERN_ITIRAN, JUUDAISIKKANUTAGAI, "JUUDAISIKKANUTAGAI", false);
        addPattern(PATTERN_ITIRAN, DOUGAKUTOKUNIN, "DOUGAKUTOKUNIN", false);
        addPattern(PATTERN_ITIRAN, TORIATUKAIJIJOU, "TORIATUKAIJIJOU", false);
        addPattern(PATTERN_ITIRAN, SISYAKETTEIKEKKA, "SISYAKETTEIKEKKA", false);
        addPattern(PATTERN_ITIRAN, HOUJOUHANDAN, "HOUJOUHANDAN", false);
        addPattern(PATTERN_ITIRAN, SISYAHOUKOKU, "SISYAHOUKOKU", false);
        addPattern(PATTERN_ITIRAN, KYKKAKUNINKETTEI, "KYKKAKUNINKETTEI", false);
        addPattern(PATTERN_ITIRAN, ZENINDOUTOKUHUAN, "ZENINDOUTOKUHUAN", false);
        addPattern(PATTERN_ITIRAN, KYKKANKEI, "KYKKANKEI", false);
        addPattern(PATTERN_ITIRAN, NAIKI, "NAIKI", false);
        addPattern(PATTERN_ITIRAN, SOUGOU, "SOUGOU", false);


        lock(C_Ketriyuucd.class);
    }

    private C_Ketriyuucd(String value) {
        super(value);
    }

    public static C_Ketriyuucd valueOf(String value) {
        return valueOf(C_Ketriyuucd.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Ketriyuucd.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Ketriyuucd.class, patternId, value);
    }
}
