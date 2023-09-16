
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 担当コード区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TantouCdKbn</td><td colspan="3">担当コード区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="76">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK0}</td><td>&quot;0&quot;</td><td>ブランク0</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IMUSATEI}</td><td>&quot;1&quot;</td><td>医務査定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KIKAKUIMU}</td><td>&quot;2&quot;</td><td>企画（医務）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IMUIMU}</td><td>&quot;3&quot;</td><td>医務（医務）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOUKATU1}</td><td>&quot;4&quot;</td><td>総括１</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SENTAKUINFO}</td><td>&quot;5&quot;</td><td>選択情報</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KETTEI}</td><td>&quot;6&quot;</td><td>決定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUKENTYOUSEI}</td><td>&quot;7&quot;</td><td>証券・調整</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIYAKUSYOUGAI}</td><td>&quot;8&quot;</td><td>契約渉外</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #WARIATENASI}</td><td>&quot;9&quot;</td><td>割当なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOUKATU}</td><td>&quot;A&quot;</td><td>総括</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YOHURI}</td><td>&quot;B&quot;</td><td>預振</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUUKIN}</td><td>&quot;C&quot;</td><td>集金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HURIKAE}</td><td>&quot;D&quot;</td><td>振替</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAIRITEN}</td><td>&quot;E&quot;</td><td>代理店</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NENHANDANTAI}</td><td>&quot;F&quot;</td><td>年半団体</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YOHURIDANTAI}</td><td>&quot;G&quot;</td><td>預振団体</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUKIBARAIDANTAIDAIHYOU}</td><td>&quot;H&quot;</td><td>月払団体(団体代表）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUUDANTEIKI}</td><td>&quot;I&quot;</td><td>集団定期</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUKKATU}</td><td>&quot;J&quot;</td><td>復活</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MFSEIBIHENKOU}</td><td>&quot;K&quot;</td><td>ＭＦ整備(変更）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RIYOURYOU_DEBIKURE}</td><td>&quot;L&quot;</td><td>利用料（デビ・クレ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JYUUSYOSEIBI}</td><td>&quot;M&quot;</td><td>住所整備</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKUYAKU}</td><td>&quot;N&quot;</td><td>特約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MEIGIHENKOU}</td><td>&quot;O&quot;</td><td>名義変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIYAKUHENKOU}</td><td>&quot;P&quot;</td><td>契約変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOZEN}</td><td>&quot;Q&quot;</td><td>保全</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKU}</td><td>&quot;R&quot;</td><td>解約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KASITUKEKINSIHARAI}</td><td>&quot;S&quot;</td><td>貸付金支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MANKI}</td><td>&quot;T&quot;</td><td>満期</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NENKIN}</td><td>&quot;U&quot;</td><td>年金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOUSINSA}</td><td>&quot;V&quot;</td><td>死亡審査</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOUTETUZUKI}</td><td>&quot;W&quot;</td><td>死亡手続</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYUUHUKINSINSA}</td><td>&quot;X&quot;</td><td>給付金審査</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYUUHUKINTETUZUKI}</td><td>&quot;Y&quot;</td><td>給付金手続</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BLNK1}</td><td>&quot;Z&quot;</td><td>ブランク1</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOUKATU2}</td><td>&quot;ｲ&quot;</td><td>総括２</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZAIKEI}</td><td>&quot;ﾛ&quot;</td><td>財形</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUUHOSP}</td><td>&quot;ﾊ&quot;</td><td>集保・ＳＰ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BLNK2}</td><td>&quot;ﾆ&quot;</td><td>ブランク2</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BLNK3}</td><td>&quot;ﾎ&quot;</td><td>ブランク3</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BLNK4}</td><td>&quot;ﾍ&quot;</td><td>ブランク4</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DS}</td><td>&quot;ﾄ&quot;</td><td>ＤＳ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CHIIKISIJYOU}</td><td>&quot;ﾁ&quot;</td><td>地域市場</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOSEKI}</td><td>&quot;ﾇ&quot;</td><td>保積</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZAIKEISIHARAI}</td><td>&quot;ﾙ&quot;</td><td>財形支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HAITOUKIN}</td><td>&quot;ﾜ&quot;</td><td>配当金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUSIN}</td><td>&quot;ｶ&quot;</td><td>更新</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BLNK5}</td><td>&quot;ﾖ&quot;</td><td>ブランク5</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BLNK6}</td><td>&quot;ﾚ&quot;</td><td>ブランク6</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONPONYUUKIN}</td><td>&quot;ｿ&quot;</td><td>損保入金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAIRITEN2}</td><td>&quot;ﾂ&quot;</td><td>代理店2</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOKUIKI}</td><td>&quot;ﾈ&quot;</td><td>職域</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KASITUKERISOKU}</td><td>&quot;ﾅ&quot;</td><td>貸付（利息の案内・収納・貸付返済）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKUYAKUPANNAI}</td><td>&quot;ﾗ&quot;</td><td>特約（払満後特約継続のＰ案内・収納）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BLNK7}</td><td>&quot;ﾑ&quot;</td><td>ブランク7</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BLNK8}</td><td>&quot;ｳ&quot;</td><td>ブランク8</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BLNK9}</td><td>&quot;ﾉ&quot;</td><td>ブランク9</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONPONYUUKIN2}</td><td>&quot;ｵ&quot;</td><td>損保入金2</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JISEDAIMARKETKAIHATUSITU}</td><td>&quot;ｸ&quot;</td><td>次世代マーケット開発室</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JYUURYOUNYUUKIN}</td><td>&quot;ﾔ&quot;</td><td>充領入金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKUBETUJINJI}</td><td>&quot;ﾏ&quot;</td><td>特別人事</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOKYAKU}</td><td>&quot;ｹ&quot;</td><td>顧客</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAIRITENJIMUKANRI}</td><td>&quot;ﾌ&quot;</td><td>代理店事務管理</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENGAKU}</td><td>&quot;ｺ&quot;</td><td>変額</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BLNK10}</td><td>&quot;ｴ&quot;</td><td>ブランク10</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIYAKUTORIKESI}</td><td>&quot;ﾃ&quot;</td><td>契約取消・無効、新契約訂正</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BLNK11}</td><td>&quot;ｱ&quot;</td><td>ブランク11</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RIYOURYOU_HURIKOMI}</td><td>&quot;ｻ&quot;</td><td>利用料（お客さま振込）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BLNK12}</td><td>&quot;ｷ&quot;</td><td>ブランク12</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAIRITENJIMUHOZEN}</td><td>&quot;ﾕ&quot;</td><td>代理店事務保全</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CBHUKAKANRENGYOUMU}</td><td>&quot;ﾒ&quot;</td><td>ＣＢ付加関連業務</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NENKINKURIAGESAGE}</td><td>&quot;ﾐ&quot;</td><td>年金繰上げ下げ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SELLECTACE}</td><td>&quot;ｼ&quot;</td><td>セレクトエース</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BLNK13}</td><td>&quot;ｾ&quot;</td><td>ブランク13</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RIYOURYOU_SONOTA}</td><td>&quot;ｽ&quot;</td><td>利用料（その他）</td></tr>
 * </table>
 */
public class C_TantouCdKbn extends Classification<C_TantouCdKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TantouCdKbn BLNK0 = new C_TantouCdKbn("0");

    public static final C_TantouCdKbn IMUSATEI = new C_TantouCdKbn("1");

    public static final C_TantouCdKbn KIKAKUIMU = new C_TantouCdKbn("2");

    public static final C_TantouCdKbn IMUIMU = new C_TantouCdKbn("3");

    public static final C_TantouCdKbn SOUKATU1 = new C_TantouCdKbn("4");

    public static final C_TantouCdKbn SENTAKUINFO = new C_TantouCdKbn("5");

    public static final C_TantouCdKbn KETTEI = new C_TantouCdKbn("6");

    public static final C_TantouCdKbn SYOUKENTYOUSEI = new C_TantouCdKbn("7");

    public static final C_TantouCdKbn KEIYAKUSYOUGAI = new C_TantouCdKbn("8");

    public static final C_TantouCdKbn WARIATENASI = new C_TantouCdKbn("9");

    public static final C_TantouCdKbn SOUKATU = new C_TantouCdKbn("A");

    public static final C_TantouCdKbn YOHURI = new C_TantouCdKbn("B");

    public static final C_TantouCdKbn SYUUKIN = new C_TantouCdKbn("C");

    public static final C_TantouCdKbn HURIKAE = new C_TantouCdKbn("D");

    public static final C_TantouCdKbn DAIRITEN = new C_TantouCdKbn("E");

    public static final C_TantouCdKbn NENHANDANTAI = new C_TantouCdKbn("F");

    public static final C_TantouCdKbn YOHURIDANTAI = new C_TantouCdKbn("G");

    public static final C_TantouCdKbn TUKIBARAIDANTAIDAIHYOU = new C_TantouCdKbn("H");

    public static final C_TantouCdKbn SYUUDANTEIKI = new C_TantouCdKbn("I");

    public static final C_TantouCdKbn HUKKATU = new C_TantouCdKbn("J");

    public static final C_TantouCdKbn MFSEIBIHENKOU = new C_TantouCdKbn("K");

    public static final C_TantouCdKbn RIYOURYOU_DEBIKURE = new C_TantouCdKbn("L");

    public static final C_TantouCdKbn JYUUSYOSEIBI = new C_TantouCdKbn("M");

    public static final C_TantouCdKbn TOKUYAKU = new C_TantouCdKbn("N");

    public static final C_TantouCdKbn MEIGIHENKOU = new C_TantouCdKbn("O");

    public static final C_TantouCdKbn KEIYAKUHENKOU = new C_TantouCdKbn("P");

    public static final C_TantouCdKbn HOZEN = new C_TantouCdKbn("Q");

    public static final C_TantouCdKbn KAIYAKU = new C_TantouCdKbn("R");

    public static final C_TantouCdKbn KASITUKEKINSIHARAI = new C_TantouCdKbn("S");

    public static final C_TantouCdKbn MANKI = new C_TantouCdKbn("T");

    public static final C_TantouCdKbn NENKIN = new C_TantouCdKbn("U");

    public static final C_TantouCdKbn SIBOUSINSA = new C_TantouCdKbn("V");

    public static final C_TantouCdKbn SIBOUTETUZUKI = new C_TantouCdKbn("W");

    public static final C_TantouCdKbn KYUUHUKINSINSA = new C_TantouCdKbn("X");

    public static final C_TantouCdKbn KYUUHUKINTETUZUKI = new C_TantouCdKbn("Y");

    public static final C_TantouCdKbn BLNK1 = new C_TantouCdKbn("Z");

    public static final C_TantouCdKbn SOUKATU2 = new C_TantouCdKbn("ｲ");

    public static final C_TantouCdKbn ZAIKEI = new C_TantouCdKbn("ﾛ");

    public static final C_TantouCdKbn SYUUHOSP = new C_TantouCdKbn("ﾊ");

    public static final C_TantouCdKbn BLNK2 = new C_TantouCdKbn("ﾆ");

    public static final C_TantouCdKbn BLNK3 = new C_TantouCdKbn("ﾎ");

    public static final C_TantouCdKbn BLNK4 = new C_TantouCdKbn("ﾍ");

    public static final C_TantouCdKbn DS = new C_TantouCdKbn("ﾄ");

    public static final C_TantouCdKbn CHIIKISIJYOU = new C_TantouCdKbn("ﾁ");

    public static final C_TantouCdKbn HOSEKI = new C_TantouCdKbn("ﾇ");

    public static final C_TantouCdKbn ZAIKEISIHARAI = new C_TantouCdKbn("ﾙ");

    public static final C_TantouCdKbn HAITOUKIN = new C_TantouCdKbn("ﾜ");

    public static final C_TantouCdKbn KOUSIN = new C_TantouCdKbn("ｶ");

    public static final C_TantouCdKbn BLNK5 = new C_TantouCdKbn("ﾖ");

    public static final C_TantouCdKbn BLNK6 = new C_TantouCdKbn("ﾚ");

    public static final C_TantouCdKbn SONPONYUUKIN = new C_TantouCdKbn("ｿ");

    public static final C_TantouCdKbn DAIRITEN2 = new C_TantouCdKbn("ﾂ");

    public static final C_TantouCdKbn SYOKUIKI = new C_TantouCdKbn("ﾈ");

    public static final C_TantouCdKbn KASITUKERISOKU = new C_TantouCdKbn("ﾅ");

    public static final C_TantouCdKbn TOKUYAKUPANNAI = new C_TantouCdKbn("ﾗ");

    public static final C_TantouCdKbn BLNK7 = new C_TantouCdKbn("ﾑ");

    public static final C_TantouCdKbn BLNK8 = new C_TantouCdKbn("ｳ");

    public static final C_TantouCdKbn BLNK9 = new C_TantouCdKbn("ﾉ");

    public static final C_TantouCdKbn SONPONYUUKIN2 = new C_TantouCdKbn("ｵ");

    public static final C_TantouCdKbn JISEDAIMARKETKAIHATUSITU = new C_TantouCdKbn("ｸ");

    public static final C_TantouCdKbn JYUURYOUNYUUKIN = new C_TantouCdKbn("ﾔ");

    public static final C_TantouCdKbn TOKUBETUJINJI = new C_TantouCdKbn("ﾏ");

    public static final C_TantouCdKbn KOKYAKU = new C_TantouCdKbn("ｹ");

    public static final C_TantouCdKbn DAIRITENJIMUKANRI = new C_TantouCdKbn("ﾌ");

    public static final C_TantouCdKbn HENGAKU = new C_TantouCdKbn("ｺ");

    public static final C_TantouCdKbn BLNK10 = new C_TantouCdKbn("ｴ");

    public static final C_TantouCdKbn KEIYAKUTORIKESI = new C_TantouCdKbn("ﾃ");

    public static final C_TantouCdKbn BLNK11 = new C_TantouCdKbn("ｱ");

    public static final C_TantouCdKbn RIYOURYOU_HURIKOMI = new C_TantouCdKbn("ｻ");

    public static final C_TantouCdKbn BLNK12 = new C_TantouCdKbn("ｷ");

    public static final C_TantouCdKbn DAIRITENJIMUHOZEN = new C_TantouCdKbn("ﾕ");

    public static final C_TantouCdKbn CBHUKAKANRENGYOUMU = new C_TantouCdKbn("ﾒ");

    public static final C_TantouCdKbn NENKINKURIAGESAGE = new C_TantouCdKbn("ﾐ");

    public static final C_TantouCdKbn SELLECTACE = new C_TantouCdKbn("ｼ");

    public static final C_TantouCdKbn BLNK13 = new C_TantouCdKbn("ｾ");

    public static final C_TantouCdKbn RIYOURYOU_SONOTA = new C_TantouCdKbn("ｽ");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK0, "BLNK0", true);
        addPattern(PATTERN_DEFAULT, IMUSATEI, "IMUSATEI", false);
        addPattern(PATTERN_DEFAULT, KIKAKUIMU, "KIKAKUIMU", false);
        addPattern(PATTERN_DEFAULT, IMUIMU, "IMUIMU", false);
        addPattern(PATTERN_DEFAULT, SOUKATU1, "SOUKATU1", false);
        addPattern(PATTERN_DEFAULT, SENTAKUINFO, "SENTAKUINFO", false);
        addPattern(PATTERN_DEFAULT, KETTEI, "KETTEI", false);
        addPattern(PATTERN_DEFAULT, SYOUKENTYOUSEI, "SYOUKENTYOUSEI", false);
        addPattern(PATTERN_DEFAULT, KEIYAKUSYOUGAI, "KEIYAKUSYOUGAI", false);
        addPattern(PATTERN_DEFAULT, WARIATENASI, "WARIATENASI", false);
        addPattern(PATTERN_DEFAULT, SOUKATU, "SOUKATU", false);
        addPattern(PATTERN_DEFAULT, YOHURI, "YOHURI", false);
        addPattern(PATTERN_DEFAULT, SYUUKIN, "SYUUKIN", false);
        addPattern(PATTERN_DEFAULT, HURIKAE, "HURIKAE", false);
        addPattern(PATTERN_DEFAULT, DAIRITEN, "DAIRITEN", false);
        addPattern(PATTERN_DEFAULT, NENHANDANTAI, "NENHANDANTAI", false);
        addPattern(PATTERN_DEFAULT, YOHURIDANTAI, "YOHURIDANTAI", false);
        addPattern(PATTERN_DEFAULT, TUKIBARAIDANTAIDAIHYOU, "TUKIBARAIDANTAIDAIHYOU", false);
        addPattern(PATTERN_DEFAULT, SYUUDANTEIKI, "SYUUDANTEIKI", false);
        addPattern(PATTERN_DEFAULT, HUKKATU, "HUKKATU", false);
        addPattern(PATTERN_DEFAULT, MFSEIBIHENKOU, "MFSEIBIHENKOU", false);
        addPattern(PATTERN_DEFAULT, RIYOURYOU_DEBIKURE, "RIYOURYOU_DEBIKURE", false);
        addPattern(PATTERN_DEFAULT, JYUUSYOSEIBI, "JYUUSYOSEIBI", false);
        addPattern(PATTERN_DEFAULT, TOKUYAKU, "TOKUYAKU", false);
        addPattern(PATTERN_DEFAULT, MEIGIHENKOU, "MEIGIHENKOU", false);
        addPattern(PATTERN_DEFAULT, KEIYAKUHENKOU, "KEIYAKUHENKOU", false);
        addPattern(PATTERN_DEFAULT, HOZEN, "HOZEN", false);
        addPattern(PATTERN_DEFAULT, KAIYAKU, "KAIYAKU", false);
        addPattern(PATTERN_DEFAULT, KASITUKEKINSIHARAI, "KASITUKEKINSIHARAI", false);
        addPattern(PATTERN_DEFAULT, MANKI, "MANKI", false);
        addPattern(PATTERN_DEFAULT, NENKIN, "NENKIN", false);
        addPattern(PATTERN_DEFAULT, SIBOUSINSA, "SIBOUSINSA", false);
        addPattern(PATTERN_DEFAULT, SIBOUTETUZUKI, "SIBOUTETUZUKI", false);
        addPattern(PATTERN_DEFAULT, KYUUHUKINSINSA, "KYUUHUKINSINSA", false);
        addPattern(PATTERN_DEFAULT, KYUUHUKINTETUZUKI, "KYUUHUKINTETUZUKI", false);
        addPattern(PATTERN_DEFAULT, BLNK1, "BLNK1", false);
        addPattern(PATTERN_DEFAULT, SOUKATU2, "SOUKATU2", false);
        addPattern(PATTERN_DEFAULT, ZAIKEI, "ZAIKEI", false);
        addPattern(PATTERN_DEFAULT, SYUUHOSP, "SYUUHOSP", false);
        addPattern(PATTERN_DEFAULT, BLNK2, "BLNK2", false);
        addPattern(PATTERN_DEFAULT, BLNK3, "BLNK3", false);
        addPattern(PATTERN_DEFAULT, BLNK4, "BLNK4", false);
        addPattern(PATTERN_DEFAULT, DS, "DS", false);
        addPattern(PATTERN_DEFAULT, CHIIKISIJYOU, "CHIIKISIJYOU", false);
        addPattern(PATTERN_DEFAULT, HOSEKI, "HOSEKI", false);
        addPattern(PATTERN_DEFAULT, ZAIKEISIHARAI, "ZAIKEISIHARAI", false);
        addPattern(PATTERN_DEFAULT, HAITOUKIN, "HAITOUKIN", false);
        addPattern(PATTERN_DEFAULT, KOUSIN, "KOUSIN", false);
        addPattern(PATTERN_DEFAULT, BLNK5, "BLNK5", false);
        addPattern(PATTERN_DEFAULT, BLNK6, "BLNK6", false);
        addPattern(PATTERN_DEFAULT, SONPONYUUKIN, "SONPONYUUKIN", false);
        addPattern(PATTERN_DEFAULT, DAIRITEN2, "DAIRITEN2", false);
        addPattern(PATTERN_DEFAULT, SYOKUIKI, "SYOKUIKI", false);
        addPattern(PATTERN_DEFAULT, KASITUKERISOKU, "KASITUKERISOKU", false);
        addPattern(PATTERN_DEFAULT, TOKUYAKUPANNAI, "TOKUYAKUPANNAI", false);
        addPattern(PATTERN_DEFAULT, BLNK7, "BLNK7", false);
        addPattern(PATTERN_DEFAULT, BLNK8, "BLNK8", false);
        addPattern(PATTERN_DEFAULT, BLNK9, "BLNK9", false);
        addPattern(PATTERN_DEFAULT, SONPONYUUKIN2, "SONPONYUUKIN2", false);
        addPattern(PATTERN_DEFAULT, JISEDAIMARKETKAIHATUSITU, "JISEDAIMARKETKAIHATUSITU", false);
        addPattern(PATTERN_DEFAULT, JYUURYOUNYUUKIN, "JYUURYOUNYUUKIN", false);
        addPattern(PATTERN_DEFAULT, TOKUBETUJINJI, "TOKUBETUJINJI", false);
        addPattern(PATTERN_DEFAULT, KOKYAKU, "KOKYAKU", false);
        addPattern(PATTERN_DEFAULT, DAIRITENJIMUKANRI, "DAIRITENJIMUKANRI", false);
        addPattern(PATTERN_DEFAULT, HENGAKU, "HENGAKU", false);
        addPattern(PATTERN_DEFAULT, BLNK10, "BLNK10", false);
        addPattern(PATTERN_DEFAULT, KEIYAKUTORIKESI, "KEIYAKUTORIKESI", false);
        addPattern(PATTERN_DEFAULT, BLNK11, "BLNK11", false);
        addPattern(PATTERN_DEFAULT, RIYOURYOU_HURIKOMI, "RIYOURYOU_HURIKOMI", false);
        addPattern(PATTERN_DEFAULT, BLNK12, "BLNK12", false);
        addPattern(PATTERN_DEFAULT, DAIRITENJIMUHOZEN, "DAIRITENJIMUHOZEN", false);
        addPattern(PATTERN_DEFAULT, CBHUKAKANRENGYOUMU, "CBHUKAKANRENGYOUMU", false);
        addPattern(PATTERN_DEFAULT, NENKINKURIAGESAGE, "NENKINKURIAGESAGE", false);
        addPattern(PATTERN_DEFAULT, SELLECTACE, "SELLECTACE", false);
        addPattern(PATTERN_DEFAULT, BLNK13, "BLNK13", false);
        addPattern(PATTERN_DEFAULT, RIYOURYOU_SONOTA, "RIYOURYOU_SONOTA", false);


        lock(C_TantouCdKbn.class);
    }

    private C_TantouCdKbn(String value) {
        super(value);
    }

    public static C_TantouCdKbn valueOf(String value) {
        return valueOf(C_TantouCdKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TantouCdKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TantouCdKbn.class, patternId, value);
    }
}
