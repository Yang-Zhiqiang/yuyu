
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 組織名区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SosikiNmKbn</td><td colspan="3">組織名区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="54">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;00&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BU}</td><td>&quot;01&quot;</td><td>部</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SITU}</td><td>&quot;02&quot;</td><td>室</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KA}</td><td>&quot;03&quot;</td><td>課</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYOUIKUKENSYUUJO}</td><td>&quot;04&quot;</td><td>教育研修所</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYOUSITU}</td><td>&quot;05&quot;</td><td>教室</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TYUUZAIINJIMUSYO}</td><td>&quot;06&quot;</td><td>駐在員事務所</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SISYA}</td><td>&quot;07&quot;</td><td>支社</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KENSETUSISYA}</td><td>&quot;08&quot;</td><td>建設支社</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKUBETUSISYA}</td><td>&quot;09&quot;</td><td>特別支社</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUKIGAKESISYA}</td><td>&quot;10&quot;</td><td>月掛支社</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KENSETUTUKIGAKESISYA}</td><td>&quot;11&quot;</td><td>建設月掛支社</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BUNSITU}</td><td>&quot;12&quot;</td><td>分室</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUKATUBU}</td><td>&quot;13&quot;</td><td>統括部</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUKIGAKETOUKATUBU}</td><td>&quot;14&quot;</td><td>月掛統括部</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YOUSEIBU}</td><td>&quot;15&quot;</td><td>養成部</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #EIGYOUSYO}</td><td>&quot;16&quot;</td><td>営業所</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBUTUKIGAKEEIGYOUSYO}</td><td>&quot;17&quot;</td><td>支部月掛営業所</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBU}</td><td>&quot;18&quot;</td><td>支部</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIMUSYO}</td><td>&quot;19&quot;</td><td>事務所</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MARUZAISISYO}</td><td>&quot;20&quot;</td><td>マル財支所</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HAN}</td><td>&quot;21&quot;</td><td>班</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUTTYOUJYO}</td><td>&quot;22&quot;</td><td>出張所</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOUSIHAN}</td><td>&quot;23&quot;</td><td>奉仕班</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUKKOUGAISYA}</td><td>&quot;24&quot;</td><td>出向会社</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SERVICECENTER}</td><td>&quot;25&quot;</td><td>サービスセンター</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKUBETU_EIGYOU_HUTUUSISYO}</td><td>&quot;26&quot;</td><td>特別・営業・普通支所</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #EIGYOUBU}</td><td>&quot;27&quot;</td><td>営業部</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HJNSITU}</td><td>&quot;28&quot;</td><td>法人室</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIHATUSUISINBU}</td><td>&quot;29&quot;</td><td>開発推進部</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GROUP}</td><td>&quot;30&quot;</td><td>グループ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #EIGYOUKYOKU}</td><td>&quot;31&quot;</td><td>営業局</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #EIGYOUSOUKYOKU}</td><td>&quot;32&quot;</td><td>営業総局</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #EIGYOUKAIHATUSITU1}</td><td>&quot;33&quot;</td><td>営業開発室１</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BU_SITU_SISYAKIKOUARI}</td><td>&quot;34&quot;</td><td>部・室（傘下に支社機構あり）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #EIGYOUCENTER}</td><td>&quot;35&quot;</td><td>営業センター</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #EIGYOUKA}</td><td>&quot;36&quot;</td><td>営業課</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEAM}</td><td>&quot;37&quot;</td><td>チーム</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #EIGYOUHONBU}</td><td>&quot;38&quot;</td><td>営業本部</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #EIGYOUBU_SISYA}</td><td>&quot;39&quot;</td><td>営業部（支社レベル）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #EIGYOUCENTER_EIGYOUBU}</td><td>&quot;40&quot;</td><td>営業センター（営業部レベル）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #EIGYOUKAIHATUSITU2}</td><td>&quot;41&quot;</td><td>営業開発室２</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEAM_EIGYOUKAIHATUSITU}</td><td>&quot;42&quot;</td><td>チーム（営業開発室傘下）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOKUIKIKAIHATUCENTER}</td><td>&quot;43&quot;</td><td>職域開発センター</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AREAKAIHATUSITU}</td><td>&quot;44&quot;</td><td>エリア開発室</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUKKOUGAISYANAIBUSOSIKI}</td><td>&quot;45&quot;</td><td>出向会社内部組織</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #EIGYOUBU_DRTEN}</td><td>&quot;46&quot;</td><td>営業部（代理店）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #EIGYOUKA_DRTEN}</td><td>&quot;47&quot;</td><td>営業課（代理店）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANPOGYOUSEKIKA}</td><td>&quot;48&quot;</td><td>かんぽ業績課</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUUTYOGYOUSEKIKA}</td><td>&quot;49&quot;</td><td>ゆうちょ業績課</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUUBINKYOKUGYOUSEKIKA}</td><td>&quot;50&quot;</td><td>郵便局業績課</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANIKYOKUGYOUSEKIKA}</td><td>&quot;51&quot;</td><td>簡易局業績課</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #A1}</td><td>&quot;A1&quot;</td><td>Ａ１</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #A2}</td><td>&quot;A2&quot;</td><td>Ａ２</td></tr>
 * </table>
 */
public class C_SosikiNmKbn extends Classification<C_SosikiNmKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SosikiNmKbn BLNK = new C_SosikiNmKbn("00");

    public static final C_SosikiNmKbn BU = new C_SosikiNmKbn("01");

    public static final C_SosikiNmKbn SITU = new C_SosikiNmKbn("02");

    public static final C_SosikiNmKbn KA = new C_SosikiNmKbn("03");

    public static final C_SosikiNmKbn KYOUIKUKENSYUUJO = new C_SosikiNmKbn("04");

    public static final C_SosikiNmKbn KYOUSITU = new C_SosikiNmKbn("05");

    public static final C_SosikiNmKbn TYUUZAIINJIMUSYO = new C_SosikiNmKbn("06");

    public static final C_SosikiNmKbn SISYA = new C_SosikiNmKbn("07");

    public static final C_SosikiNmKbn KENSETUSISYA = new C_SosikiNmKbn("08");

    public static final C_SosikiNmKbn TOKUBETUSISYA = new C_SosikiNmKbn("09");

    public static final C_SosikiNmKbn TUKIGAKESISYA = new C_SosikiNmKbn("10");

    public static final C_SosikiNmKbn KENSETUTUKIGAKESISYA = new C_SosikiNmKbn("11");

    public static final C_SosikiNmKbn BUNSITU = new C_SosikiNmKbn("12");

    public static final C_SosikiNmKbn TOUKATUBU = new C_SosikiNmKbn("13");

    public static final C_SosikiNmKbn TUKIGAKETOUKATUBU = new C_SosikiNmKbn("14");

    public static final C_SosikiNmKbn YOUSEIBU = new C_SosikiNmKbn("15");

    public static final C_SosikiNmKbn EIGYOUSYO = new C_SosikiNmKbn("16");

    public static final C_SosikiNmKbn SIBUTUKIGAKEEIGYOUSYO = new C_SosikiNmKbn("17");

    public static final C_SosikiNmKbn SIBU = new C_SosikiNmKbn("18");

    public static final C_SosikiNmKbn JIMUSYO = new C_SosikiNmKbn("19");

    public static final C_SosikiNmKbn MARUZAISISYO = new C_SosikiNmKbn("20");

    public static final C_SosikiNmKbn HAN = new C_SosikiNmKbn("21");

    public static final C_SosikiNmKbn SYUTTYOUJYO = new C_SosikiNmKbn("22");

    public static final C_SosikiNmKbn HOUSIHAN = new C_SosikiNmKbn("23");

    public static final C_SosikiNmKbn SYUKKOUGAISYA = new C_SosikiNmKbn("24");

    public static final C_SosikiNmKbn SERVICECENTER = new C_SosikiNmKbn("25");

    public static final C_SosikiNmKbn TOKUBETU_EIGYOU_HUTUUSISYO = new C_SosikiNmKbn("26");

    public static final C_SosikiNmKbn EIGYOUBU = new C_SosikiNmKbn("27");

    public static final C_SosikiNmKbn HJNSITU = new C_SosikiNmKbn("28");

    public static final C_SosikiNmKbn KAIHATUSUISINBU = new C_SosikiNmKbn("29");

    public static final C_SosikiNmKbn GROUP = new C_SosikiNmKbn("30");

    public static final C_SosikiNmKbn EIGYOUKYOKU = new C_SosikiNmKbn("31");

    public static final C_SosikiNmKbn EIGYOUSOUKYOKU = new C_SosikiNmKbn("32");

    public static final C_SosikiNmKbn EIGYOUKAIHATUSITU1 = new C_SosikiNmKbn("33");

    public static final C_SosikiNmKbn BU_SITU_SISYAKIKOUARI = new C_SosikiNmKbn("34");

    public static final C_SosikiNmKbn EIGYOUCENTER = new C_SosikiNmKbn("35");

    public static final C_SosikiNmKbn EIGYOUKA = new C_SosikiNmKbn("36");

    public static final C_SosikiNmKbn TEAM = new C_SosikiNmKbn("37");

    public static final C_SosikiNmKbn EIGYOUHONBU = new C_SosikiNmKbn("38");

    public static final C_SosikiNmKbn EIGYOUBU_SISYA = new C_SosikiNmKbn("39");

    public static final C_SosikiNmKbn EIGYOUCENTER_EIGYOUBU = new C_SosikiNmKbn("40");

    public static final C_SosikiNmKbn EIGYOUKAIHATUSITU2 = new C_SosikiNmKbn("41");

    public static final C_SosikiNmKbn TEAM_EIGYOUKAIHATUSITU = new C_SosikiNmKbn("42");

    public static final C_SosikiNmKbn SYOKUIKIKAIHATUCENTER = new C_SosikiNmKbn("43");

    public static final C_SosikiNmKbn AREAKAIHATUSITU = new C_SosikiNmKbn("44");

    public static final C_SosikiNmKbn SYUKKOUGAISYANAIBUSOSIKI = new C_SosikiNmKbn("45");

    public static final C_SosikiNmKbn EIGYOUBU_DRTEN = new C_SosikiNmKbn("46");

    public static final C_SosikiNmKbn EIGYOUKA_DRTEN = new C_SosikiNmKbn("47");

    public static final C_SosikiNmKbn KANPOGYOUSEKIKA = new C_SosikiNmKbn("48");

    public static final C_SosikiNmKbn YUUTYOGYOUSEKIKA = new C_SosikiNmKbn("49");

    public static final C_SosikiNmKbn YUUBINKYOKUGYOUSEKIKA = new C_SosikiNmKbn("50");

    public static final C_SosikiNmKbn KANIKYOKUGYOUSEKIKA = new C_SosikiNmKbn("51");

    public static final C_SosikiNmKbn A1 = new C_SosikiNmKbn("A1");

    public static final C_SosikiNmKbn A2 = new C_SosikiNmKbn("A2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, BU, "BU", false);
        addPattern(PATTERN_DEFAULT, SITU, "SITU", false);
        addPattern(PATTERN_DEFAULT, KA, "KA", false);
        addPattern(PATTERN_DEFAULT, KYOUIKUKENSYUUJO, "KYOUIKUKENSYUUJO", false);
        addPattern(PATTERN_DEFAULT, KYOUSITU, "KYOUSITU", false);
        addPattern(PATTERN_DEFAULT, TYUUZAIINJIMUSYO, "TYUUZAIINJIMUSYO", false);
        addPattern(PATTERN_DEFAULT, SISYA, "SISYA", false);
        addPattern(PATTERN_DEFAULT, KENSETUSISYA, "KENSETUSISYA", false);
        addPattern(PATTERN_DEFAULT, TOKUBETUSISYA, "TOKUBETUSISYA", false);
        addPattern(PATTERN_DEFAULT, TUKIGAKESISYA, "TUKIGAKESISYA", false);
        addPattern(PATTERN_DEFAULT, KENSETUTUKIGAKESISYA, "KENSETUTUKIGAKESISYA", false);
        addPattern(PATTERN_DEFAULT, BUNSITU, "BUNSITU", false);
        addPattern(PATTERN_DEFAULT, TOUKATUBU, "TOUKATUBU", false);
        addPattern(PATTERN_DEFAULT, TUKIGAKETOUKATUBU, "TUKIGAKETOUKATUBU", false);
        addPattern(PATTERN_DEFAULT, YOUSEIBU, "YOUSEIBU", false);
        addPattern(PATTERN_DEFAULT, EIGYOUSYO, "EIGYOUSYO", false);
        addPattern(PATTERN_DEFAULT, SIBUTUKIGAKEEIGYOUSYO, "SIBUTUKIGAKEEIGYOUSYO", false);
        addPattern(PATTERN_DEFAULT, SIBU, "SIBU", false);
        addPattern(PATTERN_DEFAULT, JIMUSYO, "JIMUSYO", false);
        addPattern(PATTERN_DEFAULT, MARUZAISISYO, "MARUZAISISYO", false);
        addPattern(PATTERN_DEFAULT, HAN, "HAN", false);
        addPattern(PATTERN_DEFAULT, SYUTTYOUJYO, "SYUTTYOUJYO", false);
        addPattern(PATTERN_DEFAULT, HOUSIHAN, "HOUSIHAN", false);
        addPattern(PATTERN_DEFAULT, SYUKKOUGAISYA, "SYUKKOUGAISYA", false);
        addPattern(PATTERN_DEFAULT, SERVICECENTER, "SERVICECENTER", false);
        addPattern(PATTERN_DEFAULT, TOKUBETU_EIGYOU_HUTUUSISYO, "TOKUBETU_EIGYOU_HUTUUSISYO", false);
        addPattern(PATTERN_DEFAULT, EIGYOUBU, "EIGYOUBU", false);
        addPattern(PATTERN_DEFAULT, HJNSITU, "HJNSITU", false);
        addPattern(PATTERN_DEFAULT, KAIHATUSUISINBU, "KAIHATUSUISINBU", false);
        addPattern(PATTERN_DEFAULT, GROUP, "GROUP", false);
        addPattern(PATTERN_DEFAULT, EIGYOUKYOKU, "EIGYOUKYOKU", false);
        addPattern(PATTERN_DEFAULT, EIGYOUSOUKYOKU, "EIGYOUSOUKYOKU", false);
        addPattern(PATTERN_DEFAULT, EIGYOUKAIHATUSITU1, "EIGYOUKAIHATUSITU1", false);
        addPattern(PATTERN_DEFAULT, BU_SITU_SISYAKIKOUARI, "BU_SITU_SISYAKIKOUARI", false);
        addPattern(PATTERN_DEFAULT, EIGYOUCENTER, "EIGYOUCENTER", false);
        addPattern(PATTERN_DEFAULT, EIGYOUKA, "EIGYOUKA", false);
        addPattern(PATTERN_DEFAULT, TEAM, "TEAM", false);
        addPattern(PATTERN_DEFAULT, EIGYOUHONBU, "EIGYOUHONBU", false);
        addPattern(PATTERN_DEFAULT, EIGYOUBU_SISYA, "EIGYOUBU_SISYA", false);
        addPattern(PATTERN_DEFAULT, EIGYOUCENTER_EIGYOUBU, "EIGYOUCENTER_EIGYOUBU", false);
        addPattern(PATTERN_DEFAULT, EIGYOUKAIHATUSITU2, "EIGYOUKAIHATUSITU2", false);
        addPattern(PATTERN_DEFAULT, TEAM_EIGYOUKAIHATUSITU, "TEAM_EIGYOUKAIHATUSITU", false);
        addPattern(PATTERN_DEFAULT, SYOKUIKIKAIHATUCENTER, "SYOKUIKIKAIHATUCENTER", false);
        addPattern(PATTERN_DEFAULT, AREAKAIHATUSITU, "AREAKAIHATUSITU", false);
        addPattern(PATTERN_DEFAULT, SYUKKOUGAISYANAIBUSOSIKI, "SYUKKOUGAISYANAIBUSOSIKI", false);
        addPattern(PATTERN_DEFAULT, EIGYOUBU_DRTEN, "EIGYOUBU_DRTEN", false);
        addPattern(PATTERN_DEFAULT, EIGYOUKA_DRTEN, "EIGYOUKA_DRTEN", false);
        addPattern(PATTERN_DEFAULT, KANPOGYOUSEKIKA, "KANPOGYOUSEKIKA", false);
        addPattern(PATTERN_DEFAULT, YUUTYOGYOUSEKIKA, "YUUTYOGYOUSEKIKA", false);
        addPattern(PATTERN_DEFAULT, YUUBINKYOKUGYOUSEKIKA, "YUUBINKYOKUGYOUSEKIKA", false);
        addPattern(PATTERN_DEFAULT, KANIKYOKUGYOUSEKIKA, "KANIKYOKUGYOUSEKIKA", false);
        addPattern(PATTERN_DEFAULT, A1, "A1", false);
        addPattern(PATTERN_DEFAULT, A2, "A2", false);


        lock(C_SosikiNmKbn.class);
    }

    private C_SosikiNmKbn(String value) {
        super(value);
    }

    public static C_SosikiNmKbn valueOf(String value) {
        return valueOf(C_SosikiNmKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SosikiNmKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SosikiNmKbn.class, patternId, value);
    }
}
