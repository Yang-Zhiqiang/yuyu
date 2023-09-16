
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 手続注意区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TtdktyuuiKbn</td><td colspan="3">手続注意区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="36">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TTDKTYUUOUTAITYUUI}</td><td>&quot;01&quot;</td><td>手続中応対注意</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKSYASOUSASYOUKAI}</td><td>&quot;02&quot;</td><td>契約者に関する捜査照会</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HASANOYOBITOUSAN}</td><td>&quot;03&quot;</td><td>破産および倒産</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOKENKEIYAKUSASIOSAE}</td><td>&quot;04&quot;</td><td>保険契約差押え</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKSYAYUKUEHUMEI}</td><td>&quot;05&quot;</td><td>契約者行方不明</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAIRININTTDKHUKA}</td><td>&quot;06&quot;</td><td>代理人による手続不可</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MINJISAISEI}</td><td>&quot;07&quot;</td><td>民事再生</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKNSYASOUSASYOUKAI}</td><td>&quot;08&quot;</td><td>被保険者に関する捜査照会</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKSYAISINOURYOKUNASI}</td><td>&quot;09&quot;</td><td>契約者意思能力なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKNSYAISINOURYOKUNASI}</td><td>&quot;10&quot;</td><td>被保険者意思能力なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOZENSONOTA}</td><td>&quot;19&quot;</td><td>保全関係その他</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOKENKINUTKTYUUI}</td><td>&quot;21&quot;</td><td>保険金関係　受取人注意</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEIZENKYUUHUHIGAITOU}</td><td>&quot;31&quot;</td><td>生前給付非該当</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUMETUJISEISAN}</td><td>&quot;41&quot;</td><td>消滅時精算</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUMETUJIHAITOUTYOUSEIYOU}</td><td>&quot;42&quot;</td><td>消滅時μ配当調整要</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYUUHUKINKAKUNINYOU}</td><td>&quot;52&quot;</td><td>給付金・確認要</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYUUHUKINTOKUTEININHUTANPO}</td><td>&quot;53&quot;</td><td>給付金・特定人不担保</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PMENHIGAITOU}</td><td>&quot;54&quot;</td><td>P免非該当</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUMETUGOOUTAITYUUI}</td><td>&quot;61&quot;</td><td>消滅後応対注意</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KUJOUKEIIARI}</td><td>&quot;62&quot;</td><td>苦情経緯あり応対注意</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IKUEISIKINANNAITYUUI}</td><td>&quot;71&quot;</td><td>育英資金案内注意</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIDOUSOUKINKZHENKOU}</td><td>&quot;72&quot;</td><td>自動送金口座変更案内中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKNSYAZOKUSEIKAKUNINJIKOU}</td><td>&quot;73&quot;</td><td>被保険者属性確認事項あり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TORIHIKIJIKAKUNINRYUUIJIKOU}</td><td>&quot;74&quot;</td><td>取引時確認留意事項あり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HIHOKENSYAKAIJOSEIKYUU}</td><td>&quot;81&quot;</td><td>被保険者からの解除請求あり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIGAITOKOU}</td><td>&quot;Y1&quot;</td><td>海外渡航届受理</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHRTYOUSYOSKSTEISI}</td><td>&quot;Y2&quot;</td><td>支払調書作成停止</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAIKENSYAKAIYAKUMOUSIDE}</td><td>&quot;Y3&quot;</td><td>債権者解約申出</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ADRKAKUNINUKE}</td><td>&quot;Y4&quot;</td><td>住所確認受付中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ADRHUMEI}</td><td>&quot;Y5&quot;</td><td>住所不明</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOZENSONOTA_ETURANCTRLNASI}</td><td>&quot;Y6&quot;</td><td>保全関係その他（閲覧制御等なし）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ADRHUMEIKAZOKU1}</td><td>&quot;Y7&quot;</td><td>住所不明（登録家族１）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ADRHUMEIKAZOKU2}</td><td>&quot;Y8&quot;</td><td>住所不明（登録家族２）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKSYADAIRIKENHATUDOUZUMI}</td><td>&quot;Z1&quot;</td><td>契約者代理権発動済</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKSYADAIRININDOUIYOU}</td><td>&quot;Z2&quot;</td><td>契約者代理人同意要</td></tr>
 *  <tr><td rowspan="34">{@link #PATTERN_SELECT SELECT}<br />(選択用)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TTDKTYUUOUTAITYUUI}</td><td>&quot;01&quot;</td><td>手続中応対注意</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKSYASOUSASYOUKAI}</td><td>&quot;02&quot;</td><td>契約者に関する捜査照会</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HASANOYOBITOUSAN}</td><td>&quot;03&quot;</td><td>破産および倒産</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOKENKEIYAKUSASIOSAE}</td><td>&quot;04&quot;</td><td>保険契約差押え</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKSYAYUKUEHUMEI}</td><td>&quot;05&quot;</td><td>契約者行方不明</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAIRININTTDKHUKA}</td><td>&quot;06&quot;</td><td>代理人による手続不可</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MINJISAISEI}</td><td>&quot;07&quot;</td><td>民事再生</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKNSYASOUSASYOUKAI}</td><td>&quot;08&quot;</td><td>被保険者に関する捜査照会</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKSYAISINOURYOKUNASI}</td><td>&quot;09&quot;</td><td>契約者意思能力なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKNSYAISINOURYOKUNASI}</td><td>&quot;10&quot;</td><td>被保険者意思能力なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOZENSONOTA}</td><td>&quot;19&quot;</td><td>保全関係その他</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOKENKINUTKTYUUI}</td><td>&quot;21&quot;</td><td>保険金関係　受取人注意</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEIZENKYUUHUHIGAITOU}</td><td>&quot;31&quot;</td><td>生前給付非該当</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUMETUJISEISAN}</td><td>&quot;41&quot;</td><td>消滅時精算</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUMETUJIHAITOUTYOUSEIYOU}</td><td>&quot;42&quot;</td><td>消滅時μ配当調整要</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYUUHUKINKAKUNINYOU}</td><td>&quot;52&quot;</td><td>給付金・確認要</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYUUHUKINTOKUTEININHUTANPO}</td><td>&quot;53&quot;</td><td>給付金・特定人不担保</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PMENHIGAITOU}</td><td>&quot;54&quot;</td><td>P免非該当</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUMETUGOOUTAITYUUI}</td><td>&quot;61&quot;</td><td>消滅後応対注意</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KUJOUKEIIARI}</td><td>&quot;62&quot;</td><td>苦情経緯あり応対注意</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IKUEISIKINANNAITYUUI}</td><td>&quot;71&quot;</td><td>育英資金案内注意</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIDOUSOUKINKZHENKOU}</td><td>&quot;72&quot;</td><td>自動送金口座変更案内中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKNSYAZOKUSEIKAKUNINJIKOU}</td><td>&quot;73&quot;</td><td>被保険者属性確認事項あり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TORIHIKIJIKAKUNINRYUUIJIKOU}</td><td>&quot;74&quot;</td><td>取引時確認留意事項あり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HIHOKENSYAKAIJOSEIKYUU}</td><td>&quot;81&quot;</td><td>被保険者からの解除請求あり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIGAITOKOU}</td><td>&quot;Y1&quot;</td><td>海外渡航届受理</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SHRTYOUSYOSKSTEISI}</td><td>&quot;Y2&quot;</td><td>支払調書作成停止</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAIKENSYAKAIYAKUMOUSIDE}</td><td>&quot;Y3&quot;</td><td>債権者解約申出</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ADRKAKUNINUKE}</td><td>&quot;Y4&quot;</td><td>住所確認受付中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ADRHUMEI}</td><td>&quot;Y5&quot;</td><td>住所不明</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOZENSONOTA_ETURANCTRLNASI}</td><td>&quot;Y6&quot;</td><td>保全関係その他（閲覧制御等なし）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ADRHUMEIKAZOKU1}</td><td>&quot;Y7&quot;</td><td>住所不明（登録家族１）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ADRHUMEIKAZOKU2}</td><td>&quot;Y8&quot;</td><td>住所不明（登録家族２）</td></tr>
 * </table>
 */
public class C_TtdktyuuiKbn extends Classification<C_TtdktyuuiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TtdktyuuiKbn BLNK = new C_TtdktyuuiKbn("0");

    public static final C_TtdktyuuiKbn TTDKTYUUOUTAITYUUI = new C_TtdktyuuiKbn("01");

    public static final C_TtdktyuuiKbn KYKSYASOUSASYOUKAI = new C_TtdktyuuiKbn("02");

    public static final C_TtdktyuuiKbn HASANOYOBITOUSAN = new C_TtdktyuuiKbn("03");

    public static final C_TtdktyuuiKbn HOKENKEIYAKUSASIOSAE = new C_TtdktyuuiKbn("04");

    public static final C_TtdktyuuiKbn KYKSYAYUKUEHUMEI = new C_TtdktyuuiKbn("05");

    public static final C_TtdktyuuiKbn DAIRININTTDKHUKA = new C_TtdktyuuiKbn("06");

    public static final C_TtdktyuuiKbn MINJISAISEI = new C_TtdktyuuiKbn("07");

    public static final C_TtdktyuuiKbn HHKNSYASOUSASYOUKAI = new C_TtdktyuuiKbn("08");

    public static final C_TtdktyuuiKbn KYKSYAISINOURYOKUNASI = new C_TtdktyuuiKbn("09");

    public static final C_TtdktyuuiKbn HHKNSYAISINOURYOKUNASI = new C_TtdktyuuiKbn("10");

    public static final C_TtdktyuuiKbn HOZENSONOTA = new C_TtdktyuuiKbn("19");

    public static final C_TtdktyuuiKbn HOKENKINUTKTYUUI = new C_TtdktyuuiKbn("21");

    public static final C_TtdktyuuiKbn SEIZENKYUUHUHIGAITOU = new C_TtdktyuuiKbn("31");

    public static final C_TtdktyuuiKbn SYOUMETUJISEISAN = new C_TtdktyuuiKbn("41");

    public static final C_TtdktyuuiKbn SYOUMETUJIHAITOUTYOUSEIYOU = new C_TtdktyuuiKbn("42");

    public static final C_TtdktyuuiKbn KYUUHUKINKAKUNINYOU = new C_TtdktyuuiKbn("52");

    public static final C_TtdktyuuiKbn KYUUHUKINTOKUTEININHUTANPO = new C_TtdktyuuiKbn("53");

    public static final C_TtdktyuuiKbn PMENHIGAITOU = new C_TtdktyuuiKbn("54");

    public static final C_TtdktyuuiKbn SYOUMETUGOOUTAITYUUI = new C_TtdktyuuiKbn("61");

    public static final C_TtdktyuuiKbn KUJOUKEIIARI = new C_TtdktyuuiKbn("62");

    public static final C_TtdktyuuiKbn IKUEISIKINANNAITYUUI = new C_TtdktyuuiKbn("71");

    public static final C_TtdktyuuiKbn JIDOUSOUKINKZHENKOU = new C_TtdktyuuiKbn("72");

    public static final C_TtdktyuuiKbn HHKNSYAZOKUSEIKAKUNINJIKOU = new C_TtdktyuuiKbn("73");

    public static final C_TtdktyuuiKbn TORIHIKIJIKAKUNINRYUUIJIKOU = new C_TtdktyuuiKbn("74");

    public static final C_TtdktyuuiKbn HIHOKENSYAKAIJOSEIKYUU = new C_TtdktyuuiKbn("81");

    public static final C_TtdktyuuiKbn KAIGAITOKOU = new C_TtdktyuuiKbn("Y1");

    public static final C_TtdktyuuiKbn SHRTYOUSYOSKSTEISI = new C_TtdktyuuiKbn("Y2");

    public static final C_TtdktyuuiKbn SAIKENSYAKAIYAKUMOUSIDE = new C_TtdktyuuiKbn("Y3");

    public static final C_TtdktyuuiKbn ADRKAKUNINUKE = new C_TtdktyuuiKbn("Y4");

    public static final C_TtdktyuuiKbn ADRHUMEI = new C_TtdktyuuiKbn("Y5");

    public static final C_TtdktyuuiKbn HOZENSONOTA_ETURANCTRLNASI = new C_TtdktyuuiKbn("Y6");

    public static final C_TtdktyuuiKbn ADRHUMEIKAZOKU1 = new C_TtdktyuuiKbn("Y7");

    public static final C_TtdktyuuiKbn ADRHUMEIKAZOKU2 = new C_TtdktyuuiKbn("Y8");

    public static final C_TtdktyuuiKbn KYKSYADAIRIKENHATUDOUZUMI = new C_TtdktyuuiKbn("Z1");

    public static final C_TtdktyuuiKbn KYKSYADAIRININDOUIYOU = new C_TtdktyuuiKbn("Z2");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TTDKTYUUOUTAITYUUI, "TTDKTYUUOUTAITYUUI", false);
        addPattern(PATTERN_DEFAULT, KYKSYASOUSASYOUKAI, "KYKSYASOUSASYOUKAI", false);
        addPattern(PATTERN_DEFAULT, HASANOYOBITOUSAN, "HASANOYOBITOUSAN", false);
        addPattern(PATTERN_DEFAULT, HOKENKEIYAKUSASIOSAE, "HOKENKEIYAKUSASIOSAE", false);
        addPattern(PATTERN_DEFAULT, KYKSYAYUKUEHUMEI, "KYKSYAYUKUEHUMEI", false);
        addPattern(PATTERN_DEFAULT, DAIRININTTDKHUKA, "DAIRININTTDKHUKA", false);
        addPattern(PATTERN_DEFAULT, MINJISAISEI, "MINJISAISEI", false);
        addPattern(PATTERN_DEFAULT, HHKNSYASOUSASYOUKAI, "HHKNSYASOUSASYOUKAI", false);
        addPattern(PATTERN_DEFAULT, KYKSYAISINOURYOKUNASI, "KYKSYAISINOURYOKUNASI", false);
        addPattern(PATTERN_DEFAULT, HHKNSYAISINOURYOKUNASI, "HHKNSYAISINOURYOKUNASI", false);
        addPattern(PATTERN_DEFAULT, HOZENSONOTA, "HOZENSONOTA", false);
        addPattern(PATTERN_DEFAULT, HOKENKINUTKTYUUI, "HOKENKINUTKTYUUI", false);
        addPattern(PATTERN_DEFAULT, SEIZENKYUUHUHIGAITOU, "SEIZENKYUUHUHIGAITOU", false);
        addPattern(PATTERN_DEFAULT, SYOUMETUJISEISAN, "SYOUMETUJISEISAN", false);
        addPattern(PATTERN_DEFAULT, SYOUMETUJIHAITOUTYOUSEIYOU, "SYOUMETUJIHAITOUTYOUSEIYOU", false);
        addPattern(PATTERN_DEFAULT, KYUUHUKINKAKUNINYOU, "KYUUHUKINKAKUNINYOU", false);
        addPattern(PATTERN_DEFAULT, KYUUHUKINTOKUTEININHUTANPO, "KYUUHUKINTOKUTEININHUTANPO", false);
        addPattern(PATTERN_DEFAULT, PMENHIGAITOU, "PMENHIGAITOU", false);
        addPattern(PATTERN_DEFAULT, SYOUMETUGOOUTAITYUUI, "SYOUMETUGOOUTAITYUUI", false);
        addPattern(PATTERN_DEFAULT, KUJOUKEIIARI, "KUJOUKEIIARI", false);
        addPattern(PATTERN_DEFAULT, IKUEISIKINANNAITYUUI, "IKUEISIKINANNAITYUUI", false);
        addPattern(PATTERN_DEFAULT, JIDOUSOUKINKZHENKOU, "JIDOUSOUKINKZHENKOU", false);
        addPattern(PATTERN_DEFAULT, HHKNSYAZOKUSEIKAKUNINJIKOU, "HHKNSYAZOKUSEIKAKUNINJIKOU", false);
        addPattern(PATTERN_DEFAULT, TORIHIKIJIKAKUNINRYUUIJIKOU, "TORIHIKIJIKAKUNINRYUUIJIKOU", false);
        addPattern(PATTERN_DEFAULT, HIHOKENSYAKAIJOSEIKYUU, "HIHOKENSYAKAIJOSEIKYUU", false);
        addPattern(PATTERN_DEFAULT, KAIGAITOKOU, "KAIGAITOKOU", false);
        addPattern(PATTERN_DEFAULT, SHRTYOUSYOSKSTEISI, "SHRTYOUSYOSKSTEISI", false);
        addPattern(PATTERN_DEFAULT, SAIKENSYAKAIYAKUMOUSIDE, "SAIKENSYAKAIYAKUMOUSIDE", false);
        addPattern(PATTERN_DEFAULT, ADRKAKUNINUKE, "ADRKAKUNINUKE", false);
        addPattern(PATTERN_DEFAULT, ADRHUMEI, "ADRHUMEI", false);
        addPattern(PATTERN_DEFAULT, HOZENSONOTA_ETURANCTRLNASI, "HOZENSONOTA_ETURANCTRLNASI", false);
        addPattern(PATTERN_DEFAULT, ADRHUMEIKAZOKU1, "ADRHUMEIKAZOKU1", false);
        addPattern(PATTERN_DEFAULT, ADRHUMEIKAZOKU2, "ADRHUMEIKAZOKU2", false);
        addPattern(PATTERN_DEFAULT, KYKSYADAIRIKENHATUDOUZUMI, "KYKSYADAIRIKENHATUDOUZUMI", false);
        addPattern(PATTERN_DEFAULT, KYKSYADAIRININDOUIYOU, "KYKSYADAIRININDOUIYOU", false);


        addPattern(PATTERN_SELECT, BLNK, "BLNK", true);
        addPattern(PATTERN_SELECT, TTDKTYUUOUTAITYUUI, "TTDKTYUUOUTAITYUUI", false);
        addPattern(PATTERN_SELECT, KYKSYASOUSASYOUKAI, "KYKSYASOUSASYOUKAI", false);
        addPattern(PATTERN_SELECT, HASANOYOBITOUSAN, "HASANOYOBITOUSAN", false);
        addPattern(PATTERN_SELECT, HOKENKEIYAKUSASIOSAE, "HOKENKEIYAKUSASIOSAE", false);
        addPattern(PATTERN_SELECT, KYKSYAYUKUEHUMEI, "KYKSYAYUKUEHUMEI", false);
        addPattern(PATTERN_SELECT, DAIRININTTDKHUKA, "DAIRININTTDKHUKA", false);
        addPattern(PATTERN_SELECT, MINJISAISEI, "MINJISAISEI", false);
        addPattern(PATTERN_SELECT, HHKNSYASOUSASYOUKAI, "HHKNSYASOUSASYOUKAI", false);
        addPattern(PATTERN_SELECT, KYKSYAISINOURYOKUNASI, "KYKSYAISINOURYOKUNASI", false);
        addPattern(PATTERN_SELECT, HHKNSYAISINOURYOKUNASI, "HHKNSYAISINOURYOKUNASI", false);
        addPattern(PATTERN_SELECT, HOZENSONOTA, "HOZENSONOTA", false);
        addPattern(PATTERN_SELECT, HOKENKINUTKTYUUI, "HOKENKINUTKTYUUI", false);
        addPattern(PATTERN_SELECT, SEIZENKYUUHUHIGAITOU, "SEIZENKYUUHUHIGAITOU", false);
        addPattern(PATTERN_SELECT, SYOUMETUJISEISAN, "SYOUMETUJISEISAN", false);
        addPattern(PATTERN_SELECT, SYOUMETUJIHAITOUTYOUSEIYOU, "SYOUMETUJIHAITOUTYOUSEIYOU", false);
        addPattern(PATTERN_SELECT, KYUUHUKINKAKUNINYOU, "KYUUHUKINKAKUNINYOU", false);
        addPattern(PATTERN_SELECT, KYUUHUKINTOKUTEININHUTANPO, "KYUUHUKINTOKUTEININHUTANPO", false);
        addPattern(PATTERN_SELECT, PMENHIGAITOU, "PMENHIGAITOU", false);
        addPattern(PATTERN_SELECT, SYOUMETUGOOUTAITYUUI, "SYOUMETUGOOUTAITYUUI", false);
        addPattern(PATTERN_SELECT, KUJOUKEIIARI, "KUJOUKEIIARI", false);
        addPattern(PATTERN_SELECT, IKUEISIKINANNAITYUUI, "IKUEISIKINANNAITYUUI", false);
        addPattern(PATTERN_SELECT, JIDOUSOUKINKZHENKOU, "JIDOUSOUKINKZHENKOU", false);
        addPattern(PATTERN_SELECT, HHKNSYAZOKUSEIKAKUNINJIKOU, "HHKNSYAZOKUSEIKAKUNINJIKOU", false);
        addPattern(PATTERN_SELECT, TORIHIKIJIKAKUNINRYUUIJIKOU, "TORIHIKIJIKAKUNINRYUUIJIKOU", false);
        addPattern(PATTERN_SELECT, HIHOKENSYAKAIJOSEIKYUU, "HIHOKENSYAKAIJOSEIKYUU", false);
        addPattern(PATTERN_SELECT, KAIGAITOKOU, "KAIGAITOKOU", false);
        addPattern(PATTERN_SELECT, SHRTYOUSYOSKSTEISI, "SHRTYOUSYOSKSTEISI", false);
        addPattern(PATTERN_SELECT, SAIKENSYAKAIYAKUMOUSIDE, "SAIKENSYAKAIYAKUMOUSIDE", false);
        addPattern(PATTERN_SELECT, ADRKAKUNINUKE, "ADRKAKUNINUKE", false);
        addPattern(PATTERN_SELECT, ADRHUMEI, "ADRHUMEI", false);
        addPattern(PATTERN_SELECT, HOZENSONOTA_ETURANCTRLNASI, "HOZENSONOTA_ETURANCTRLNASI", false);
        addPattern(PATTERN_SELECT, ADRHUMEIKAZOKU1, "ADRHUMEIKAZOKU1", false);
        addPattern(PATTERN_SELECT, ADRHUMEIKAZOKU2, "ADRHUMEIKAZOKU2", false);


        lock(C_TtdktyuuiKbn.class);
    }

    private C_TtdktyuuiKbn(String value) {
        super(value);
    }

    public static C_TtdktyuuiKbn valueOf(String value) {
        return valueOf(C_TtdktyuuiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TtdktyuuiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TtdktyuuiKbn.class, patternId, value);
    }
}
