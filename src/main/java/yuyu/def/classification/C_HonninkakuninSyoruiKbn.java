
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 本人確認書類区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HonninkakuninSyoruiKbn</td><td colspan="3">本人確認書類区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="27">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UNTEN}</td><td>&quot;11&quot;</td><td>運転免許証・運転経歴証明書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PASSPORT}</td><td>&quot;12&quot;</td><td>パスポート</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZAIRYUUCARD}</td><td>&quot;13&quot;</td><td>在留カード・特別永住者証明書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOKUMINKENKOUHOKEN}</td><td>&quot;14&quot;</td><td>国民健康保険被保険者証</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KENKOUHOKEN}</td><td>&quot;15&quot;</td><td>健康保険被保険者証</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SENINHOKEN}</td><td>&quot;16&quot;</td><td>船員保険被保険者証</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIGOHOKEN}</td><td>&quot;17&quot;</td><td>介護保険被保険者証</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUKIKOUREISYAIRYOU}</td><td>&quot;18&quot;</td><td>後期高齢者医療被保険者証</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KENKOUHOKENHIYATOI}</td><td>&quot;19&quot;</td><td>健康保険日雇特例被保険者手帳</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOKKAKOUMUINKYOUSAI}</td><td>&quot;20&quot;</td><td>国家公務員共済組合の組合員証</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TIHOUKOUMUINKYOUSAI}</td><td>&quot;21&quot;</td><td>地方公務員共済組合の組合員証</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIRITUGAKKOUKYOUINKYOUSAI}</td><td>&quot;22&quot;</td><td>私立学校教職員共済制度の加入者証</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOKUMINNENKIN}</td><td>&quot;23&quot;</td><td>国民年金手帳</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIDOUHUYOUTEATE}</td><td>&quot;24&quot;</td><td>児童扶養手当証書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKUBETUJIDOUHUYOUTEATE}</td><td>&quot;25&quot;</td><td>特別児童扶養手当証書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BOSIKENKOU}</td><td>&quot;26&quot;</td><td>母子健康手帳</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINTAISYOUGAISYA}</td><td>&quot;27&quot;</td><td>身体障害者手帳</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEISINSYOUGAISYA}</td><td>&quot;28&quot;</td><td>精神障害者保健福祉手帳</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RYOUIKU}</td><td>&quot;29&quot;</td><td>療育手帳</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SENSYOUBYOUSYA}</td><td>&quot;30&quot;</td><td>戦傷病者手帳</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKOKUSEIHUKOKUSAIKIKAN}</td><td>&quot;31&quot;</td><td>日本国政府の承認した外国政府又は権限ある国際機関の発行した書類</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOJINNOCARD}</td><td>&quot;32&quot;</td><td>個人番号カード（顔写真が貼付されたもの）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JYUUMINKIHONDAITYOU}</td><td>&quot;33&quot;</td><td>住民基本台帳カード（顔写真が貼付されたもの）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANKOUTYOUHAKKOU}</td><td>&quot;34&quot;</td><td>官公庁から発行され又は発給された書類その他これに類するもので、当該官公庁が当該自然人の写真をはり付けたもの</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOJINKOUTEKISYOUMEIYUUSOU}</td><td>&quot;90&quot;</td><td>個人公的証明書写し・郵送提示</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;92&quot;</td><td>その他：写真なし２枚</td></tr>
 *  <tr><td rowspan="27">{@link #PATTERN_MOS MOS}<br />(申込書)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UNTEN}</td><td>&quot;11&quot;</td><td>11:運転免許証・運転経歴証明書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PASSPORT}</td><td>&quot;12&quot;</td><td>12:パスポート</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZAIRYUUCARD}</td><td>&quot;13&quot;</td><td>13:在留カード・特別永住者証明書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOKUMINKENKOUHOKEN}</td><td>&quot;14&quot;</td><td>14:国民健康保険被保険者証</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KENKOUHOKEN}</td><td>&quot;15&quot;</td><td>15:健康保険被保険者証</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SENINHOKEN}</td><td>&quot;16&quot;</td><td>16:船員保険被保険者証</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIGOHOKEN}</td><td>&quot;17&quot;</td><td>17:介護保険被保険者証</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUKIKOUREISYAIRYOU}</td><td>&quot;18&quot;</td><td>18:後期高齢者医療被保険者証</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KENKOUHOKENHIYATOI}</td><td>&quot;19&quot;</td><td>19:健康保険日雇特例被保険者手帳</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOKKAKOUMUINKYOUSAI}</td><td>&quot;20&quot;</td><td>20:国家公務員共済組合の組合員証</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TIHOUKOUMUINKYOUSAI}</td><td>&quot;21&quot;</td><td>21:地方公務員共済組合の組合員証</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIRITUGAKKOUKYOUINKYOUSAI}</td><td>&quot;22&quot;</td><td>22:私立学校教職員共済制度の加入者証</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOKUMINNENKIN}</td><td>&quot;23&quot;</td><td>23:国民年金手帳</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIDOUHUYOUTEATE}</td><td>&quot;24&quot;</td><td>24:児童扶養手当証書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKUBETUJIDOUHUYOUTEATE}</td><td>&quot;25&quot;</td><td>25:特別児童扶養手当証書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BOSIKENKOU}</td><td>&quot;26&quot;</td><td>26:母子健康手帳</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINTAISYOUGAISYA}</td><td>&quot;27&quot;</td><td>27:身体障害者手帳</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEISINSYOUGAISYA}</td><td>&quot;28&quot;</td><td>28:精神障害者保健福祉手帳</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RYOUIKU}</td><td>&quot;29&quot;</td><td>29:療育手帳</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SENSYOUBYOUSYA}</td><td>&quot;30&quot;</td><td>30:戦傷病者手帳</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GAIKOKUSEIHUKOKUSAIKIKAN}</td><td>&quot;31&quot;</td><td>31:日本国政府の承認した外国政府又は権限ある国際機関の発行した書類</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOJINNOCARD}</td><td>&quot;32&quot;</td><td>32:個人番号カード（顔写真が貼付されたもの）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JYUUMINKIHONDAITYOU}</td><td>&quot;33&quot;</td><td>33:住民基本台帳カード（顔写真が貼付されたもの）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANKOUTYOUHAKKOU}</td><td>&quot;34&quot;</td><td>34:官公庁から発行され又は発給された書類その他これに類するもので、当該官公庁が当該自然人の写真をはり付けたもの</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOJINKOUTEKISYOUMEIYUUSOU}</td><td>&quot;90&quot;</td><td>90:個人公的証明書写し・郵送提示</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;92&quot;</td><td>92:その他：写真なし２枚</td></tr>
 *  <tr><td rowspan="26">{@link #PATTERN_SMBCMOS SMBCMOS}<br />(SMBC申込書)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UNTEN}</td><td>&quot;11&quot;</td><td>1:運転免許証・運転経歴証明書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PASSPORT}</td><td>&quot;12&quot;</td><td>2:パスポート</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZAIRYUUCARD}</td><td>&quot;13&quot;</td><td>3:在留カード・特別永住者証明書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOKUMINKENKOUHOKEN}</td><td>&quot;14&quot;</td><td>4:国民健康保険被保険者証</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KENKOUHOKEN}</td><td>&quot;15&quot;</td><td>5:健康保険被保険者証</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SENINHOKEN}</td><td>&quot;16&quot;</td><td>6:船員保険被保険者証</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIGOHOKEN}</td><td>&quot;17&quot;</td><td>7:介護保険被保険者証</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUKIKOUREISYAIRYOU}</td><td>&quot;18&quot;</td><td>8:後期高齢者医療被保険者証</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KENKOUHOKENHIYATOI}</td><td>&quot;19&quot;</td><td>9:健康保険日雇特例被保険者手帳</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOKKAKOUMUINKYOUSAI}</td><td>&quot;20&quot;</td><td>10:国家公務員共済組合の組合員証</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TIHOUKOUMUINKYOUSAI}</td><td>&quot;21&quot;</td><td>11:地方公務員共済組合の組合員証</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIRITUGAKKOUKYOUINKYOUSAI}</td><td>&quot;22&quot;</td><td>12:私立学校教職員共済制度の加入者証</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOKUMINNENKIN}</td><td>&quot;23&quot;</td><td>13:国民年金手帳</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIDOUHUYOUTEATE}</td><td>&quot;24&quot;</td><td>14:児童扶養手当証書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKUBETUJIDOUHUYOUTEATE}</td><td>&quot;25&quot;</td><td>15:特別児童扶養手当証書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BOSIKENKOU}</td><td>&quot;26&quot;</td><td>16:母子健康手帳</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINTAISYOUGAISYA}</td><td>&quot;27&quot;</td><td>17:身体障害者手帳</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEISINSYOUGAISYA}</td><td>&quot;28&quot;</td><td>18:精神障害者保健福祉手帳</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RYOUIKU}</td><td>&quot;29&quot;</td><td>19:療育手帳</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SENSYOUBYOUSYA}</td><td>&quot;30&quot;</td><td>20:戦傷病者手帳</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANKOUTYOUHAKKOU}</td><td>&quot;34&quot;</td><td>21:官公庁から発行され又は発給された書類その他これに類するもので、当該官公庁が当該自然人の写真をはり付けたもの</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JYUUMINKIHONDAITYOU}</td><td>&quot;33&quot;</td><td>23:住民基本台帳カード（顔写真付のものに限ります＝Bタイプ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOJINNOCARD}</td><td>&quot;32&quot;</td><td>24:個人番号カード（顔写真付のものに限ります）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOJINKOUTEKISYOUMEIYUUSOU}</td><td>&quot;90&quot;</td><td>90:個人公的証明書写し・郵送提示</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;92&quot;</td><td>92:その他：写真なし２枚</td></tr>
 * </table>
 */
public class C_HonninkakuninSyoruiKbn extends Classification<C_HonninkakuninSyoruiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HonninkakuninSyoruiKbn BLNK = new C_HonninkakuninSyoruiKbn("0");

    public static final C_HonninkakuninSyoruiKbn UNTEN = new C_HonninkakuninSyoruiKbn("11");

    public static final C_HonninkakuninSyoruiKbn PASSPORT = new C_HonninkakuninSyoruiKbn("12");

    public static final C_HonninkakuninSyoruiKbn ZAIRYUUCARD = new C_HonninkakuninSyoruiKbn("13");

    public static final C_HonninkakuninSyoruiKbn KOKUMINKENKOUHOKEN = new C_HonninkakuninSyoruiKbn("14");

    public static final C_HonninkakuninSyoruiKbn KENKOUHOKEN = new C_HonninkakuninSyoruiKbn("15");

    public static final C_HonninkakuninSyoruiKbn SENINHOKEN = new C_HonninkakuninSyoruiKbn("16");

    public static final C_HonninkakuninSyoruiKbn KAIGOHOKEN = new C_HonninkakuninSyoruiKbn("17");

    public static final C_HonninkakuninSyoruiKbn KOUKIKOUREISYAIRYOU = new C_HonninkakuninSyoruiKbn("18");

    public static final C_HonninkakuninSyoruiKbn KENKOUHOKENHIYATOI = new C_HonninkakuninSyoruiKbn("19");

    public static final C_HonninkakuninSyoruiKbn KOKKAKOUMUINKYOUSAI = new C_HonninkakuninSyoruiKbn("20");

    public static final C_HonninkakuninSyoruiKbn TIHOUKOUMUINKYOUSAI = new C_HonninkakuninSyoruiKbn("21");

    public static final C_HonninkakuninSyoruiKbn SIRITUGAKKOUKYOUINKYOUSAI = new C_HonninkakuninSyoruiKbn("22");

    public static final C_HonninkakuninSyoruiKbn KOKUMINNENKIN = new C_HonninkakuninSyoruiKbn("23");

    public static final C_HonninkakuninSyoruiKbn JIDOUHUYOUTEATE = new C_HonninkakuninSyoruiKbn("24");

    public static final C_HonninkakuninSyoruiKbn TOKUBETUJIDOUHUYOUTEATE = new C_HonninkakuninSyoruiKbn("25");

    public static final C_HonninkakuninSyoruiKbn BOSIKENKOU = new C_HonninkakuninSyoruiKbn("26");

    public static final C_HonninkakuninSyoruiKbn SINTAISYOUGAISYA = new C_HonninkakuninSyoruiKbn("27");

    public static final C_HonninkakuninSyoruiKbn SEISINSYOUGAISYA = new C_HonninkakuninSyoruiKbn("28");

    public static final C_HonninkakuninSyoruiKbn RYOUIKU = new C_HonninkakuninSyoruiKbn("29");

    public static final C_HonninkakuninSyoruiKbn SENSYOUBYOUSYA = new C_HonninkakuninSyoruiKbn("30");

    public static final C_HonninkakuninSyoruiKbn GAIKOKUSEIHUKOKUSAIKIKAN = new C_HonninkakuninSyoruiKbn("31");

    public static final C_HonninkakuninSyoruiKbn KOJINNOCARD = new C_HonninkakuninSyoruiKbn("32");

    public static final C_HonninkakuninSyoruiKbn JYUUMINKIHONDAITYOU = new C_HonninkakuninSyoruiKbn("33");

    public static final C_HonninkakuninSyoruiKbn KANKOUTYOUHAKKOU = new C_HonninkakuninSyoruiKbn("34");

    public static final C_HonninkakuninSyoruiKbn KOJINKOUTEKISYOUMEIYUUSOU = new C_HonninkakuninSyoruiKbn("90");

    public static final C_HonninkakuninSyoruiKbn SONOTA = new C_HonninkakuninSyoruiKbn("92");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_MOS = "2";

    public static final String PATTERN_SMBCMOS = "3";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, UNTEN, "UNTEN", false);
        addPattern(PATTERN_DEFAULT, PASSPORT, "PASSPORT", false);
        addPattern(PATTERN_DEFAULT, ZAIRYUUCARD, "ZAIRYUUCARD", false);
        addPattern(PATTERN_DEFAULT, KOKUMINKENKOUHOKEN, "KOKUMINKENKOUHOKEN", false);
        addPattern(PATTERN_DEFAULT, KENKOUHOKEN, "KENKOUHOKEN", false);
        addPattern(PATTERN_DEFAULT, SENINHOKEN, "SENINHOKEN", false);
        addPattern(PATTERN_DEFAULT, KAIGOHOKEN, "KAIGOHOKEN", false);
        addPattern(PATTERN_DEFAULT, KOUKIKOUREISYAIRYOU, "KOUKIKOUREISYAIRYOU", false);
        addPattern(PATTERN_DEFAULT, KENKOUHOKENHIYATOI, "KENKOUHOKENHIYATOI", false);
        addPattern(PATTERN_DEFAULT, KOKKAKOUMUINKYOUSAI, "KOKKAKOUMUINKYOUSAI", false);
        addPattern(PATTERN_DEFAULT, TIHOUKOUMUINKYOUSAI, "TIHOUKOUMUINKYOUSAI", false);
        addPattern(PATTERN_DEFAULT, SIRITUGAKKOUKYOUINKYOUSAI, "SIRITUGAKKOUKYOUINKYOUSAI", false);
        addPattern(PATTERN_DEFAULT, KOKUMINNENKIN, "KOKUMINNENKIN", false);
        addPattern(PATTERN_DEFAULT, JIDOUHUYOUTEATE, "JIDOUHUYOUTEATE", false);
        addPattern(PATTERN_DEFAULT, TOKUBETUJIDOUHUYOUTEATE, "TOKUBETUJIDOUHUYOUTEATE", false);
        addPattern(PATTERN_DEFAULT, BOSIKENKOU, "BOSIKENKOU", false);
        addPattern(PATTERN_DEFAULT, SINTAISYOUGAISYA, "SINTAISYOUGAISYA", false);
        addPattern(PATTERN_DEFAULT, SEISINSYOUGAISYA, "SEISINSYOUGAISYA", false);
        addPattern(PATTERN_DEFAULT, RYOUIKU, "RYOUIKU", false);
        addPattern(PATTERN_DEFAULT, SENSYOUBYOUSYA, "SENSYOUBYOUSYA", false);
        addPattern(PATTERN_DEFAULT, GAIKOKUSEIHUKOKUSAIKIKAN, "GAIKOKUSEIHUKOKUSAIKIKAN", false);
        addPattern(PATTERN_DEFAULT, KOJINNOCARD, "KOJINNOCARD", false);
        addPattern(PATTERN_DEFAULT, JYUUMINKIHONDAITYOU, "JYUUMINKIHONDAITYOU", false);
        addPattern(PATTERN_DEFAULT, KANKOUTYOUHAKKOU, "KANKOUTYOUHAKKOU", false);
        addPattern(PATTERN_DEFAULT, KOJINKOUTEKISYOUMEIYUUSOU, "KOJINKOUTEKISYOUMEIYUUSOU", false);
        addPattern(PATTERN_DEFAULT, SONOTA, "SONOTA", false);


        addPattern(PATTERN_MOS, BLNK, "BLNK", true);
        addPattern(PATTERN_MOS, UNTEN, "UNTEN", false);
        addPattern(PATTERN_MOS, PASSPORT, "PASSPORT", false);
        addPattern(PATTERN_MOS, ZAIRYUUCARD, "ZAIRYUUCARD", false);
        addPattern(PATTERN_MOS, KOKUMINKENKOUHOKEN, "KOKUMINKENKOUHOKEN", false);
        addPattern(PATTERN_MOS, KENKOUHOKEN, "KENKOUHOKEN", false);
        addPattern(PATTERN_MOS, SENINHOKEN, "SENINHOKEN", false);
        addPattern(PATTERN_MOS, KAIGOHOKEN, "KAIGOHOKEN", false);
        addPattern(PATTERN_MOS, KOUKIKOUREISYAIRYOU, "KOUKIKOUREISYAIRYOU", false);
        addPattern(PATTERN_MOS, KENKOUHOKENHIYATOI, "KENKOUHOKENHIYATOI", false);
        addPattern(PATTERN_MOS, KOKKAKOUMUINKYOUSAI, "KOKKAKOUMUINKYOUSAI", false);
        addPattern(PATTERN_MOS, TIHOUKOUMUINKYOUSAI, "TIHOUKOUMUINKYOUSAI", false);
        addPattern(PATTERN_MOS, SIRITUGAKKOUKYOUINKYOUSAI, "SIRITUGAKKOUKYOUINKYOUSAI", false);
        addPattern(PATTERN_MOS, KOKUMINNENKIN, "KOKUMINNENKIN", false);
        addPattern(PATTERN_MOS, JIDOUHUYOUTEATE, "JIDOUHUYOUTEATE", false);
        addPattern(PATTERN_MOS, TOKUBETUJIDOUHUYOUTEATE, "TOKUBETUJIDOUHUYOUTEATE", false);
        addPattern(PATTERN_MOS, BOSIKENKOU, "BOSIKENKOU", false);
        addPattern(PATTERN_MOS, SINTAISYOUGAISYA, "SINTAISYOUGAISYA", false);
        addPattern(PATTERN_MOS, SEISINSYOUGAISYA, "SEISINSYOUGAISYA", false);
        addPattern(PATTERN_MOS, RYOUIKU, "RYOUIKU", false);
        addPattern(PATTERN_MOS, SENSYOUBYOUSYA, "SENSYOUBYOUSYA", false);
        addPattern(PATTERN_MOS, GAIKOKUSEIHUKOKUSAIKIKAN, "GAIKOKUSEIHUKOKUSAIKIKAN", false);
        addPattern(PATTERN_MOS, KOJINNOCARD, "KOJINNOCARD", false);
        addPattern(PATTERN_MOS, JYUUMINKIHONDAITYOU, "JYUUMINKIHONDAITYOU", false);
        addPattern(PATTERN_MOS, KANKOUTYOUHAKKOU, "KANKOUTYOUHAKKOU", false);
        addPattern(PATTERN_MOS, KOJINKOUTEKISYOUMEIYUUSOU, "KOJINKOUTEKISYOUMEIYUUSOU", false);
        addPattern(PATTERN_MOS, SONOTA, "SONOTA", false);


        addPattern(PATTERN_SMBCMOS, BLNK, "BLNK", true);
        addPattern(PATTERN_SMBCMOS, UNTEN, "UNTEN", false);
        addPattern(PATTERN_SMBCMOS, PASSPORT, "PASSPORT", false);
        addPattern(PATTERN_SMBCMOS, ZAIRYUUCARD, "ZAIRYUUCARD", false);
        addPattern(PATTERN_SMBCMOS, KOKUMINKENKOUHOKEN, "KOKUMINKENKOUHOKEN", false);
        addPattern(PATTERN_SMBCMOS, KENKOUHOKEN, "KENKOUHOKEN", false);
        addPattern(PATTERN_SMBCMOS, SENINHOKEN, "SENINHOKEN", false);
        addPattern(PATTERN_SMBCMOS, KAIGOHOKEN, "KAIGOHOKEN", false);
        addPattern(PATTERN_SMBCMOS, KOUKIKOUREISYAIRYOU, "KOUKIKOUREISYAIRYOU", false);
        addPattern(PATTERN_SMBCMOS, KENKOUHOKENHIYATOI, "KENKOUHOKENHIYATOI", false);
        addPattern(PATTERN_SMBCMOS, KOKKAKOUMUINKYOUSAI, "KOKKAKOUMUINKYOUSAI", false);
        addPattern(PATTERN_SMBCMOS, TIHOUKOUMUINKYOUSAI, "TIHOUKOUMUINKYOUSAI", false);
        addPattern(PATTERN_SMBCMOS, SIRITUGAKKOUKYOUINKYOUSAI, "SIRITUGAKKOUKYOUINKYOUSAI", false);
        addPattern(PATTERN_SMBCMOS, KOKUMINNENKIN, "KOKUMINNENKIN", false);
        addPattern(PATTERN_SMBCMOS, JIDOUHUYOUTEATE, "JIDOUHUYOUTEATE", false);
        addPattern(PATTERN_SMBCMOS, TOKUBETUJIDOUHUYOUTEATE, "TOKUBETUJIDOUHUYOUTEATE", false);
        addPattern(PATTERN_SMBCMOS, BOSIKENKOU, "BOSIKENKOU", false);
        addPattern(PATTERN_SMBCMOS, SINTAISYOUGAISYA, "SINTAISYOUGAISYA", false);
        addPattern(PATTERN_SMBCMOS, SEISINSYOUGAISYA, "SEISINSYOUGAISYA", false);
        addPattern(PATTERN_SMBCMOS, RYOUIKU, "RYOUIKU", false);
        addPattern(PATTERN_SMBCMOS, SENSYOUBYOUSYA, "SENSYOUBYOUSYA", false);
        addPattern(PATTERN_SMBCMOS, KANKOUTYOUHAKKOU, "KANKOUTYOUHAKKOU", false);
        addPattern(PATTERN_SMBCMOS, JYUUMINKIHONDAITYOU, "JYUUMINKIHONDAITYOU", false);
        addPattern(PATTERN_SMBCMOS, KOJINNOCARD, "KOJINNOCARD", false);
        addPattern(PATTERN_SMBCMOS, KOJINKOUTEKISYOUMEIYUUSOU, "KOJINKOUTEKISYOUMEIYUUSOU", false);
        addPattern(PATTERN_SMBCMOS, SONOTA, "SONOTA", false);


        lock(C_HonninkakuninSyoruiKbn.class);
    }

    private C_HonninkakuninSyoruiKbn(String value) {
        super(value);
    }

    public static C_HonninkakuninSyoruiKbn valueOf(String value) {
        return valueOf(C_HonninkakuninSyoruiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HonninkakuninSyoruiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HonninkakuninSyoruiKbn.class, patternId, value);
    }
}
