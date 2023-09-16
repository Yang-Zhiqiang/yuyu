
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 特殊処理内容区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TokusyuSyoriNaiyouKbn</td><td colspan="3">特殊処理内容区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="21">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>特殊処理なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKNKANJIMEINASI}</td><td>&quot;01&quot;</td><td>被保険者漢字名なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKKANJIMEINASI}</td><td>&quot;02&quot;</td><td>契約者漢字名なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBUKKANJIMEINASI_FUKUSUU}</td><td>&quot;03&quot;</td><td>死亡受取人名漢字なし（複数）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBUKKANJIMEINASI}</td><td>&quot;04&quot;</td><td>死亡受取人名漢字なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #STDRNINKANJIMEINASI}</td><td>&quot;05&quot;</td><td>被保険者代理人漢字名なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANJIADRNASI}</td><td>&quot;06&quot;</td><td>漢字住所なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBUKFUKUSUU}</td><td>&quot;07&quot;</td><td>死亡受取人複数（５人以上）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBUKBNWARINASI}</td><td>&quot;08&quot;</td><td>死亡受取人分割割合なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TTDKTYUUI_DNGNMEMOARI}</td><td>&quot;09&quot;</td><td>本社回送あり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #STKNSETARI}</td><td>&quot;10&quot;</td><td>質権設定あり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TTDKTYUUI_ADRKAKUNINUKE}</td><td>&quot;11&quot;</td><td>住所確認受付中あり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TTDKTYUUI_ADRHUMEI}</td><td>&quot;12&quot;</td><td>住所不明あり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KARIUKEKEIJOARI}</td><td>&quot;13&quot;</td><td>仮受計上あり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DOUJITUSYOUKENFUKUSUUARI}</td><td>&quot;14&quot;</td><td>同日に証券作成処理複数あり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAIRITENMEIMOJISUUTYOUKA}</td><td>&quot;15&quot;</td><td>代理店名文字数超過</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BETUTTDKUKTKARI}</td><td>&quot;16&quot;</td><td>別手続受付あり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YENDTHNKHRARI}</td><td>&quot;17&quot;</td><td>円建変更時返戻金あり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HONBANKAKUNINTAISYO}</td><td>&quot;18&quot;</td><td>本番確認対象契約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YAKKANSASSIYUUSOU}</td><td>&quot;19&quot;</td><td>約款冊子郵送</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKDRNINKANJIMEINASI}</td><td>&quot;20&quot;</td><td>契約者代理人漢字名なし</td></tr>
 *  <tr><td rowspan="18">{@link #PATTERN_SINKI SINKI}<br />(新規)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>特殊処理なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKNKANJIMEINASI}</td><td>&quot;01&quot;</td><td>被保険者名漢字</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKKANJIMEINASI}</td><td>&quot;02&quot;</td><td>契約者名漢字</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBUKKANJIMEINASI_FUKUSUU}</td><td>&quot;03&quot;</td><td>死亡受取人漢字＠人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBUKKANJIMEINASI}</td><td>&quot;04&quot;</td><td>死亡受取人漢字</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #STDRNINKANJIMEINASI}</td><td>&quot;05&quot;</td><td>被保険者代理人漢字</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANJIADRNASI}</td><td>&quot;06&quot;</td><td>住所漢字</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBUKFUKUSUU}</td><td>&quot;07&quot;</td><td>死亡受取人＠人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBUKBNWARINASI}</td><td>&quot;08&quot;</td><td>死亡受取人分割割合</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TTDKTYUUI_DNGNMEMOARI}</td><td>&quot;09&quot;</td><td>本社回送指定あり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #STKNSETARI}</td><td>&quot;10&quot;</td><td>質権設定契約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TTDKTYUUI_ADRKAKUNINUKE}</td><td>&quot;11&quot;</td><td>住所確認受付中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TTDKTYUUI_ADRHUMEI}</td><td>&quot;12&quot;</td><td>住所不明</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KARIUKEKEIJOARI}</td><td>&quot;13&quot;</td><td>送金方法等を記入</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAIRITENMEIMOJISUUTYOUKA}</td><td>&quot;15&quot;</td><td>代理店名文字数超過</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HONBANKAKUNINTAISYO}</td><td>&quot;18&quot;</td><td>本社回送指定あり　※</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YAKKANSASSIYUUSOU}</td><td>&quot;19&quot;</td><td>約款冊子郵送</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKDRNINKANJIMEINASI}</td><td>&quot;20&quot;</td><td>契約者代理人漢字</td></tr>
 *  <tr><td rowspan="20">{@link #PATTERN_SAIHAKKOU SAIHAKKOU}<br />(再発行)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>特殊処理なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKNKANJIMEINASI}</td><td>&quot;01&quot;</td><td>被保険者漢字なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKKANJIMEINASI}</td><td>&quot;02&quot;</td><td>契約者漢字なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBUKKANJIMEINASI_FUKUSUU}</td><td>&quot;03&quot;</td><td>死亡受取人複数漢字なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBUKKANJIMEINASI}</td><td>&quot;04&quot;</td><td>死亡受取人漢字なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #STDRNINKANJIMEINASI}</td><td>&quot;05&quot;</td><td>被保険者代理人漢字なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANJIADRNASI}</td><td>&quot;06&quot;</td><td>住所漢字なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBUKFUKUSUU}</td><td>&quot;07&quot;</td><td>死亡受取人＠人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBUKBNWARINASI}</td><td>&quot;08&quot;</td><td>死亡受取人分割割合なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TTDKTYUUI_DNGNMEMOARI}</td><td>&quot;09&quot;</td><td>本社回送指定あり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #STKNSETARI}</td><td>&quot;10&quot;</td><td>質権設定契約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TTDKTYUUI_ADRKAKUNINUKE}</td><td>&quot;11&quot;</td><td>住所確認受付中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TTDKTYUUI_ADRHUMEI}</td><td>&quot;12&quot;</td><td>住所不明</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KARIUKEKEIJOARI}</td><td>&quot;13&quot;</td><td>送金方法等を記入</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DOUJITUSYOUKENFUKUSUUARI}</td><td>&quot;14&quot;</td><td>同日に証券作成処理複数あり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BETUTTDKUKTKARI}</td><td>&quot;16&quot;</td><td>別手続受付あり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YENDTHNKHRARI}</td><td>&quot;17&quot;</td><td>円建変更時返戻金あり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HONBANKAKUNINTAISYO}</td><td>&quot;18&quot;</td><td>本番確認対象契約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YAKKANSASSIYUUSOU}</td><td>&quot;19&quot;</td><td>約款冊子郵送</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKDRNINKANJIMEINASI}</td><td>&quot;20&quot;</td><td>契約者代理人漢字なし</td></tr>
 * </table>
 */
public class C_TokusyuSyoriNaiyouKbn extends Classification<C_TokusyuSyoriNaiyouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TokusyuSyoriNaiyouKbn BLNK = new C_TokusyuSyoriNaiyouKbn("0");

    public static final C_TokusyuSyoriNaiyouKbn HHKNKANJIMEINASI = new C_TokusyuSyoriNaiyouKbn("01");

    public static final C_TokusyuSyoriNaiyouKbn KYKKANJIMEINASI = new C_TokusyuSyoriNaiyouKbn("02");

    public static final C_TokusyuSyoriNaiyouKbn SBUKKANJIMEINASI_FUKUSUU = new C_TokusyuSyoriNaiyouKbn("03");

    public static final C_TokusyuSyoriNaiyouKbn SBUKKANJIMEINASI = new C_TokusyuSyoriNaiyouKbn("04");

    public static final C_TokusyuSyoriNaiyouKbn STDRNINKANJIMEINASI = new C_TokusyuSyoriNaiyouKbn("05");

    public static final C_TokusyuSyoriNaiyouKbn KANJIADRNASI = new C_TokusyuSyoriNaiyouKbn("06");

    public static final C_TokusyuSyoriNaiyouKbn SBUKFUKUSUU = new C_TokusyuSyoriNaiyouKbn("07");

    public static final C_TokusyuSyoriNaiyouKbn SBUKBNWARINASI = new C_TokusyuSyoriNaiyouKbn("08");

    public static final C_TokusyuSyoriNaiyouKbn TTDKTYUUI_DNGNMEMOARI = new C_TokusyuSyoriNaiyouKbn("09");

    public static final C_TokusyuSyoriNaiyouKbn STKNSETARI = new C_TokusyuSyoriNaiyouKbn("10");

    public static final C_TokusyuSyoriNaiyouKbn TTDKTYUUI_ADRKAKUNINUKE = new C_TokusyuSyoriNaiyouKbn("11");

    public static final C_TokusyuSyoriNaiyouKbn TTDKTYUUI_ADRHUMEI = new C_TokusyuSyoriNaiyouKbn("12");

    public static final C_TokusyuSyoriNaiyouKbn KARIUKEKEIJOARI = new C_TokusyuSyoriNaiyouKbn("13");

    public static final C_TokusyuSyoriNaiyouKbn DOUJITUSYOUKENFUKUSUUARI = new C_TokusyuSyoriNaiyouKbn("14");

    public static final C_TokusyuSyoriNaiyouKbn DAIRITENMEIMOJISUUTYOUKA = new C_TokusyuSyoriNaiyouKbn("15");

    public static final C_TokusyuSyoriNaiyouKbn BETUTTDKUKTKARI = new C_TokusyuSyoriNaiyouKbn("16");

    public static final C_TokusyuSyoriNaiyouKbn YENDTHNKHRARI = new C_TokusyuSyoriNaiyouKbn("17");

    public static final C_TokusyuSyoriNaiyouKbn HONBANKAKUNINTAISYO = new C_TokusyuSyoriNaiyouKbn("18");

    public static final C_TokusyuSyoriNaiyouKbn YAKKANSASSIYUUSOU = new C_TokusyuSyoriNaiyouKbn("19");

    public static final C_TokusyuSyoriNaiyouKbn KYKDRNINKANJIMEINASI = new C_TokusyuSyoriNaiyouKbn("20");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SINKI = "2";

    public static final String PATTERN_SAIHAKKOU = "3";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HHKNKANJIMEINASI, "HHKNKANJIMEINASI", false);
        addPattern(PATTERN_DEFAULT, KYKKANJIMEINASI, "KYKKANJIMEINASI", false);
        addPattern(PATTERN_DEFAULT, SBUKKANJIMEINASI_FUKUSUU, "SBUKKANJIMEINASI_FUKUSUU", false);
        addPattern(PATTERN_DEFAULT, SBUKKANJIMEINASI, "SBUKKANJIMEINASI", false);
        addPattern(PATTERN_DEFAULT, STDRNINKANJIMEINASI, "STDRNINKANJIMEINASI", false);
        addPattern(PATTERN_DEFAULT, KANJIADRNASI, "KANJIADRNASI", false);
        addPattern(PATTERN_DEFAULT, SBUKFUKUSUU, "SBUKFUKUSUU", false);
        addPattern(PATTERN_DEFAULT, SBUKBNWARINASI, "SBUKBNWARINASI", false);
        addPattern(PATTERN_DEFAULT, TTDKTYUUI_DNGNMEMOARI, "TTDKTYUUI_DNGNMEMOARI", false);
        addPattern(PATTERN_DEFAULT, STKNSETARI, "STKNSETARI", false);
        addPattern(PATTERN_DEFAULT, TTDKTYUUI_ADRKAKUNINUKE, "TTDKTYUUI_ADRKAKUNINUKE", false);
        addPattern(PATTERN_DEFAULT, TTDKTYUUI_ADRHUMEI, "TTDKTYUUI_ADRHUMEI", false);
        addPattern(PATTERN_DEFAULT, KARIUKEKEIJOARI, "KARIUKEKEIJOARI", false);
        addPattern(PATTERN_DEFAULT, DOUJITUSYOUKENFUKUSUUARI, "DOUJITUSYOUKENFUKUSUUARI", false);
        addPattern(PATTERN_DEFAULT, DAIRITENMEIMOJISUUTYOUKA, "DAIRITENMEIMOJISUUTYOUKA", false);
        addPattern(PATTERN_DEFAULT, BETUTTDKUKTKARI, "BETUTTDKUKTKARI", false);
        addPattern(PATTERN_DEFAULT, YENDTHNKHRARI, "YENDTHNKHRARI", false);
        addPattern(PATTERN_DEFAULT, HONBANKAKUNINTAISYO, "HONBANKAKUNINTAISYO", false);
        addPattern(PATTERN_DEFAULT, YAKKANSASSIYUUSOU, "YAKKANSASSIYUUSOU", false);
        addPattern(PATTERN_DEFAULT, KYKDRNINKANJIMEINASI, "KYKDRNINKANJIMEINASI", false);


        addPattern(PATTERN_SINKI, BLNK, "BLNK", true);
        addPattern(PATTERN_SINKI, HHKNKANJIMEINASI, "HHKNKANJIMEINASI", false);
        addPattern(PATTERN_SINKI, KYKKANJIMEINASI, "KYKKANJIMEINASI", false);
        addPattern(PATTERN_SINKI, SBUKKANJIMEINASI_FUKUSUU, "SBUKKANJIMEINASI_FUKUSUU", false);
        addPattern(PATTERN_SINKI, SBUKKANJIMEINASI, "SBUKKANJIMEINASI", false);
        addPattern(PATTERN_SINKI, STDRNINKANJIMEINASI, "STDRNINKANJIMEINASI", false);
        addPattern(PATTERN_SINKI, KANJIADRNASI, "KANJIADRNASI", false);
        addPattern(PATTERN_SINKI, SBUKFUKUSUU, "SBUKFUKUSUU", false);
        addPattern(PATTERN_SINKI, SBUKBNWARINASI, "SBUKBNWARINASI", false);
        addPattern(PATTERN_SINKI, TTDKTYUUI_DNGNMEMOARI, "TTDKTYUUI_DNGNMEMOARI", false);
        addPattern(PATTERN_SINKI, STKNSETARI, "STKNSETARI", false);
        addPattern(PATTERN_SINKI, TTDKTYUUI_ADRKAKUNINUKE, "TTDKTYUUI_ADRKAKUNINUKE", false);
        addPattern(PATTERN_SINKI, TTDKTYUUI_ADRHUMEI, "TTDKTYUUI_ADRHUMEI", false);
        addPattern(PATTERN_SINKI, KARIUKEKEIJOARI, "KARIUKEKEIJOARI", false);
        addPattern(PATTERN_SINKI, DAIRITENMEIMOJISUUTYOUKA, "DAIRITENMEIMOJISUUTYOUKA", false);
        addPattern(PATTERN_SINKI, HONBANKAKUNINTAISYO, "HONBANKAKUNINTAISYO", false);
        addPattern(PATTERN_SINKI, YAKKANSASSIYUUSOU, "YAKKANSASSIYUUSOU", false);
        addPattern(PATTERN_SINKI, KYKDRNINKANJIMEINASI, "KYKDRNINKANJIMEINASI", false);


        addPattern(PATTERN_SAIHAKKOU, BLNK, "BLNK", true);
        addPattern(PATTERN_SAIHAKKOU, HHKNKANJIMEINASI, "HHKNKANJIMEINASI", false);
        addPattern(PATTERN_SAIHAKKOU, KYKKANJIMEINASI, "KYKKANJIMEINASI", false);
        addPattern(PATTERN_SAIHAKKOU, SBUKKANJIMEINASI_FUKUSUU, "SBUKKANJIMEINASI_FUKUSUU", false);
        addPattern(PATTERN_SAIHAKKOU, SBUKKANJIMEINASI, "SBUKKANJIMEINASI", false);
        addPattern(PATTERN_SAIHAKKOU, STDRNINKANJIMEINASI, "STDRNINKANJIMEINASI", false);
        addPattern(PATTERN_SAIHAKKOU, KANJIADRNASI, "KANJIADRNASI", false);
        addPattern(PATTERN_SAIHAKKOU, SBUKFUKUSUU, "SBUKFUKUSUU", false);
        addPattern(PATTERN_SAIHAKKOU, SBUKBNWARINASI, "SBUKBNWARINASI", false);
        addPattern(PATTERN_SAIHAKKOU, TTDKTYUUI_DNGNMEMOARI, "TTDKTYUUI_DNGNMEMOARI", false);
        addPattern(PATTERN_SAIHAKKOU, STKNSETARI, "STKNSETARI", false);
        addPattern(PATTERN_SAIHAKKOU, TTDKTYUUI_ADRKAKUNINUKE, "TTDKTYUUI_ADRKAKUNINUKE", false);
        addPattern(PATTERN_SAIHAKKOU, TTDKTYUUI_ADRHUMEI, "TTDKTYUUI_ADRHUMEI", false);
        addPattern(PATTERN_SAIHAKKOU, KARIUKEKEIJOARI, "KARIUKEKEIJOARI", false);
        addPattern(PATTERN_SAIHAKKOU, DOUJITUSYOUKENFUKUSUUARI, "DOUJITUSYOUKENFUKUSUUARI", false);
        addPattern(PATTERN_SAIHAKKOU, BETUTTDKUKTKARI, "BETUTTDKUKTKARI", false);
        addPattern(PATTERN_SAIHAKKOU, YENDTHNKHRARI, "YENDTHNKHRARI", false);
        addPattern(PATTERN_SAIHAKKOU, HONBANKAKUNINTAISYO, "HONBANKAKUNINTAISYO", false);
        addPattern(PATTERN_SAIHAKKOU, YAKKANSASSIYUUSOU, "YAKKANSASSIYUUSOU", false);
        addPattern(PATTERN_SAIHAKKOU, KYKDRNINKANJIMEINASI, "KYKDRNINKANJIMEINASI", false);


        lock(C_TokusyuSyoriNaiyouKbn.class);
    }

    private C_TokusyuSyoriNaiyouKbn(String value) {
        super(value);
    }

    public static C_TokusyuSyoriNaiyouKbn valueOf(String value) {
        return valueOf(C_TokusyuSyoriNaiyouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TokusyuSyoriNaiyouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TokusyuSyoriNaiyouKbn.class, patternId, value);
    }
}
