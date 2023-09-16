
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 勘定科目コード クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Kanjyoukmkcd</td><td colspan="3">勘定科目コード</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="85">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTAKARIBARAIKIN_GAIHO}</td><td>&quot;19223&quot;</td><td>仮払金／その他仮払金（外保）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOKENKEIYAKU_SYOKAI_GAIHO_JPY}</td><td>&quot;27229&quot;</td><td>仮受金／保険契約（初回）（外保：日本円）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOKENKEIYAKU_SYOKAI_GAIHO_USD}</td><td>&quot;27230&quot;</td><td>仮受金／保険契約（初回）（外保：米ドル）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOKENKEIYAKU_SYOKAI_GAIHO_AUD}</td><td>&quot;27231&quot;</td><td>仮受金／保険契約（初回）（外保：豪ドル）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOKENKEIYAKU_PKAKIN_GAIHO_JPY}</td><td>&quot;27232&quot;</td><td>仮受金／保険契約（Ｐ過金）（外保：日本円</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOKENKEIYAKU_PKAKIN_GAIHO_USD}</td><td>&quot;27233&quot;</td><td>仮受金／保険契約（Ｐ過金）（外保：米ドル</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOKENKEIYAKU_PKAKIN_GAIHO_AUD}</td><td>&quot;27234&quot;</td><td>仮受金／保険契約（Ｐ過金）（外保：豪ドル</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOKENKEIYAKU_KOBETU_GAIHO_JPY}</td><td>&quot;27235&quot;</td><td>仮受金／保険契約（個別）（外保：日本円）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOKENKEIYAKU_KOBETU_GAIHO_USD}</td><td>&quot;27236&quot;</td><td>仮受金／保険契約（個別）（外保：米ドル）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOKENKEIYAKU_KOBETU_GAIHO_AUD}</td><td>&quot;27237&quot;</td><td>仮受金／保険契約（個別）（外保：豪ドル）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOKENKEIYAKU_DAI1KAI_GAIHO_JPY}</td><td>&quot;27238&quot;</td><td>仮受金／保険契約（第１回）（外保：日本円</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOKENKEIYAKU_DAI1KAI_GAIHO_USD}</td><td>&quot;27239&quot;</td><td>仮受金／保険契約（第１回）（外保：米ドル</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOKENKEIYAKU_DAI1KAI_GAIHO_AUD}</td><td>&quot;27240&quot;</td><td>仮受金／保険契約（第１回）（外保：豪ドル</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTAKARIUKEKIN_FBSOUKIN}</td><td>&quot;27161&quot;</td><td>仮受金／その他仮受金（ＦＢ送金）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTAKARIUKEKIN_GAIKAFBSOUKIN}</td><td>&quot;27175&quot;</td><td>仮受金／その他仮受金（外貨ＦＢ送金）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTAKARIUKEKIN_GAIHO}</td><td>&quot;27242&quot;</td><td>仮受金／その他仮受金（外保）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINKEIYAKUFB_GAIHO_JPY}</td><td>&quot;27243&quot;</td><td>仮受金／新契約ＦＢ（外保：日本円）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINKEIYAKUFB_GAIHO_USD}</td><td>&quot;27244&quot;</td><td>仮受金／新契約ＦＢ（外保：米ドル）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINKEIYAKUFB_GAIHO_AUD}</td><td>&quot;27245&quot;</td><td>仮受金／新契約ＦＢ（外保：豪ドル）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTAKARIUKEKIN_AZUKARIKIN_GAIHO_JPY}</td><td>&quot;27247&quot;</td><td>仮受金／その他仮受金（預り金）（外保：日</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTAKARIUKEKIN_AZUKARIKIN_GAIHO_USD}</td><td>&quot;27248&quot;</td><td>仮受金／その他仮受金（預り金）（外保：米</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTAKARIUKEKIN_AZUKARIKIN_GAIHO_AUD}</td><td>&quot;27249&quot;</td><td>仮受金／その他仮受金（預り金）（外保：豪</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOKEN_KOBETUP_GAIHO_JPY}</td><td>&quot;27356&quot;</td><td>仮受金／保険（個別Ｐ）（外保：日本円）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOKEN_KOBETUP_GAIHO_USD}</td><td>&quot;27357&quot;</td><td>仮受金／保険（個別Ｐ）（外保：米ドル）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOKEN_KOBETUP_GAIHO_AUD}</td><td>&quot;27358&quot;</td><td>仮受金／保険（個別Ｐ）（外保：豪ドル）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOUHOKENKIN_HUTUU}</td><td>&quot;40101&quot;</td><td>保険金／死亡保険金（普通）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOUHOKENKIN_GAIHO_JPY}</td><td>&quot;40124&quot;</td><td>保険金／死亡保険金（外保：日本円）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOUHOKENKIN_GAIHO_USD}</td><td>&quot;40129&quot;</td><td>保険金／死亡保険金（外保：米ドル）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOUHOKENKIN_GAIHO_AUD}</td><td>&quot;40167&quot;</td><td>保険金／死亡保険金（外保：豪ドル）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOUKYUUHUKIN_GAIHO_JPY}</td><td>&quot;40437&quot;</td><td>給付金／死亡給付金（外保：日本円）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOUKYUUHUKIN_GAIHO_USD}</td><td>&quot;40438&quot;</td><td>給付金／死亡給付金（外保：米ドル）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOUKYUUHUKIN_GAIHO_AUD}</td><td>&quot;40439&quot;</td><td>給付金／死亡給付金（外保：豪ドル）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAIGAISIBOUHOKENKIN_GAIHO_JPY}</td><td>&quot;40169&quot;</td><td>保険金／災害死亡保険金（外保：日本円）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAIGAISIBOUHOKENKIN_GAIHO_USD}</td><td>&quot;40170&quot;</td><td>保険金／災害死亡保険金（外保：米ドル）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAIGAISIBOUHOKENKIN_GAIHO_AUD}</td><td>&quot;40389&quot;</td><td>保険金／災害死亡保険金（外保：豪ドル）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKUHENREIKIN_HUTUU}</td><td>&quot;40401&quot;</td><td>解約返戻金／解約返戻金（普通）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKUHENREIKIN_GAIHO_JPY}</td><td>&quot;40434&quot;</td><td>解約返戻金／解約返戻金（外保：日本円）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKUHENREIKIN_GAIHO_USD}</td><td>&quot;40435&quot;</td><td>解約返戻金／解約返戻金（外保：米ドル）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKUHENREIKIN_GAIHO_AUD}</td><td>&quot;40436&quot;</td><td>解約返戻金／解約返戻金（外保：豪ドル）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTAHENREIKIN_GAIHO_JPY}</td><td>&quot;40511&quot;</td><td>その他返戻金／その他（外保：日本円）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTAHENREIKIN_GAIHO_USD}</td><td>&quot;40512&quot;</td><td>その他返戻金／その他（外保：米ドル）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTAHENREIKIN_GAIHO_AUD}</td><td>&quot;40513&quot;</td><td>その他返戻金／その他（外保：豪ドル）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTAHENREIKIN_HUTUU}</td><td>&quot;40581&quot;</td><td>その他返戻金／その他（普通）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIGYOUHI}</td><td>&quot;41101&quot;</td><td>事業費／事業費</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOKENKEIYAKUSIHARAIRISOKU_HUTUU}</td><td>&quot;41503&quot;</td><td>支払利息／保険契約支払利息</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOKENKEIYAKUSIHARAIRISOKU_GAIHO_JPY}</td><td>&quot;41527&quot;</td><td>支払利息／保険契約支払利息（外保：日本円</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOKENKEIYAKUSIHARAIRISOKU_GAIHO_USD}</td><td>&quot;41528&quot;</td><td>支払利息／保険契約支払利息（外保：米ドル</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOKENKEIYAKUSIHARAIRISOKU_GAIHO_AUD}</td><td>&quot;41529&quot;</td><td>支払利息／保険契約支払利息（外保：豪ドル</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOKA_SEGMENT_SISYUTU_V}</td><td>&quot;48102&quot;</td><td>他セグメントへの支出（Ｖ）／保障・年金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYONENDOSYOKAIHOKENRYOU_GAIHO_JPY}</td><td>&quot;60547&quot;</td><td>保険料／初年度初回保険料（外保：日本円）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYONENDOSYOKAIHOKENRYOU_GAIHO_USD}</td><td>&quot;60548&quot;</td><td>保険料／初年度初回保険料（外保：米ドル）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYONENDOSYOKAIHOKENRYOU_GAIHO_AUD}</td><td>&quot;60549&quot;</td><td>保険料／初年度初回保険料（外保：豪ドル）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JINENDOIKOUHOKENRYOU_GAIHO_JPY}</td><td>&quot;60550&quot;</td><td>保険料／次年度以降保険料（外保：日本円）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JINENDOIKOUHOKENRYOU_GAIHO_USD}</td><td>&quot;60551&quot;</td><td>保険料／次年度以降保険料（外保：米ドル）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JINENDOIKOUHOKENRYOU_GAIHO_AUD}</td><td>&quot;60552&quot;</td><td>保険料／次年度以降保険料（外保：豪ドル）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOKENKEIYAKUZATUSYUUNYUU}</td><td>&quot;62101&quot;</td><td>雑収入／保険契約雑収入</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOKA_SEGMENT_SYUUNYUU_V}</td><td>&quot;65102&quot;</td><td>他セグメントからの収入（Ｖ）／保障・年金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYONENDO2KAIMEIKOU_GAIHO_JPY}</td><td>&quot;60559&quot;</td><td>保険料／初年度２回目以降（外保：日本円）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYONENDO2KAIMEIKOU_GAIHO_USD}</td><td>&quot;60560&quot;</td><td>保険料／初年度２回目以降（外保：米ドル）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYONENDO2KAIMEIKOU_GAIHO_AUD}</td><td>&quot;60561&quot;</td><td>保険料／初年度２回目以降（外保：豪ドル）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYAINHAITOUKIN_GAIHO_JPY}</td><td>&quot;40637&quot;</td><td>社員配当金／社員配当金（外保：日本円）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYAINHAITOUKIN_GAIHO_USD}</td><td>&quot;40638&quot;</td><td>社員配当金／社員配当金（外保：米ドル）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYAINHAITOUKIN_GAIHO_AUD}</td><td>&quot;40639&quot;</td><td>社員配当金／社員配当金（外保：豪ドル）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KARIUKEKIN_HUHOKOBETU_GAIHO_JPY}</td><td>&quot;27250&quot;</td><td>仮受金／保険契約（普保個別）（外保：日）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KARIUKEKIN_HUHOKOBETU_GAIHO_USD}</td><td>&quot;27251&quot;</td><td>仮受金／保険契約（普保個別）（外保：米）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KARIUKEKIN_HUHOKOBETU_GAIHO_AUD}</td><td>&quot;27252&quot;</td><td>仮受金／保険契約（普保個別）（外保：豪）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOKENKEIYAKUKARIUKEKIN_HUHO_HURIKAE}</td><td>&quot;27123&quot;</td><td>仮受金／保険契約仮受金（普保）（振替）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOKENKEIYAKUKARIBARAIKIN_HUHO_SYUUNOU}</td><td>&quot;19105&quot;</td><td>仮払金／保険契約仮払金（普保）（収納）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOKENKEIYAKUKARIUKEKIN_HUHO_YOHURI}</td><td>&quot;27124&quot;</td><td>仮受金／保険契約仮受金（普保）（預振）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTAKARIUKEKIN_SONOTA}</td><td>&quot;27169&quot;</td><td>仮受金／その他仮受金（その他）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYAINHAITOUKIN_HUTUU}</td><td>&quot;40601&quot;</td><td>社員配当金／社員配当金（普通）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTAKARIUKEKIN_AZUKARIKIN}</td><td>&quot;27166&quot;</td><td>仮受金／その他仮受金（預り金）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOUKYUUHUKIN_HUTUU}</td><td>&quot;40301&quot;</td><td>給付金／死亡給付金（普通）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOKENKEIYAKUKARIBARAIKIN_HUHO_KURE}</td><td>&quot;19109&quot;</td><td>仮払金／保険契約仮払金（普保）（クレ払）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTAMISYUUKIN}</td><td>&quot;15599&quot;</td><td>未収金／その他未収金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOKENKEIYAKUKARIUKEKIN_HUHO_SYOKAI}</td><td>&quot;27102&quot;</td><td>仮受金／保険契約仮受金（普保）（初回）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOKENKEIYAKUKARIUKEKIN_HUHO_PKAKIN}</td><td>&quot;27103&quot;</td><td>仮受金／保険契約仮受金（普保）（Ｐ過金）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOKENKEIYAKUKARIUKEKIN_HUHO_DAI1KAI}</td><td>&quot;27109&quot;</td><td>仮受金／保険契約仮受金（普保）（第１回）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTAKARIUKEKIN_SINKEIYAKUFB}</td><td>&quot;27209&quot;</td><td>仮受金／その他仮受金（新契約ＦＢ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOKENKEIYAKUKARIUKEKIN_HUHO_KOBETUP}</td><td>&quot;27355&quot;</td><td>仮受金／保険契約仮受金（普保）（個別Ｐ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYONENDOSYOKAIHOKENRYOU_HUTUU}</td><td>&quot;60101&quot;</td><td>保険料／初年度初回保険料（普通）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYONENDO2KAIMEIKOU_HUTUU}</td><td>&quot;60121&quot;</td><td>保険料／初年度２回目以降保険料（普通）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JINENDOIKOUHOKENRYOU_HUTUU}</td><td>&quot;60141&quot;</td><td>保険料／次年度以降保険料（普通）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOKENKEIYAKUKARIUKEKIN_HUHO_KOBETU}</td><td>&quot;27105&quot;</td><td>仮受金／保険契約仮受金（普保）（個別）</td></tr>
 * </table>
 */
public class C_Kanjyoukmkcd extends Classification<C_Kanjyoukmkcd> {

    private static final long serialVersionUID = 1L;


    public static final C_Kanjyoukmkcd BLNK = new C_Kanjyoukmkcd("0");

    public static final C_Kanjyoukmkcd SONOTAKARIBARAIKIN_GAIHO = new C_Kanjyoukmkcd("19223");

    public static final C_Kanjyoukmkcd HOKENKEIYAKU_SYOKAI_GAIHO_JPY = new C_Kanjyoukmkcd("27229");

    public static final C_Kanjyoukmkcd HOKENKEIYAKU_SYOKAI_GAIHO_USD = new C_Kanjyoukmkcd("27230");

    public static final C_Kanjyoukmkcd HOKENKEIYAKU_SYOKAI_GAIHO_AUD = new C_Kanjyoukmkcd("27231");

    public static final C_Kanjyoukmkcd HOKENKEIYAKU_PKAKIN_GAIHO_JPY = new C_Kanjyoukmkcd("27232");

    public static final C_Kanjyoukmkcd HOKENKEIYAKU_PKAKIN_GAIHO_USD = new C_Kanjyoukmkcd("27233");

    public static final C_Kanjyoukmkcd HOKENKEIYAKU_PKAKIN_GAIHO_AUD = new C_Kanjyoukmkcd("27234");

    public static final C_Kanjyoukmkcd HOKENKEIYAKU_KOBETU_GAIHO_JPY = new C_Kanjyoukmkcd("27235");

    public static final C_Kanjyoukmkcd HOKENKEIYAKU_KOBETU_GAIHO_USD = new C_Kanjyoukmkcd("27236");

    public static final C_Kanjyoukmkcd HOKENKEIYAKU_KOBETU_GAIHO_AUD = new C_Kanjyoukmkcd("27237");

    public static final C_Kanjyoukmkcd HOKENKEIYAKU_DAI1KAI_GAIHO_JPY = new C_Kanjyoukmkcd("27238");

    public static final C_Kanjyoukmkcd HOKENKEIYAKU_DAI1KAI_GAIHO_USD = new C_Kanjyoukmkcd("27239");

    public static final C_Kanjyoukmkcd HOKENKEIYAKU_DAI1KAI_GAIHO_AUD = new C_Kanjyoukmkcd("27240");

    public static final C_Kanjyoukmkcd SONOTAKARIUKEKIN_FBSOUKIN = new C_Kanjyoukmkcd("27161");

    public static final C_Kanjyoukmkcd SONOTAKARIUKEKIN_GAIKAFBSOUKIN = new C_Kanjyoukmkcd("27175");

    public static final C_Kanjyoukmkcd SONOTAKARIUKEKIN_GAIHO = new C_Kanjyoukmkcd("27242");

    public static final C_Kanjyoukmkcd SINKEIYAKUFB_GAIHO_JPY = new C_Kanjyoukmkcd("27243");

    public static final C_Kanjyoukmkcd SINKEIYAKUFB_GAIHO_USD = new C_Kanjyoukmkcd("27244");

    public static final C_Kanjyoukmkcd SINKEIYAKUFB_GAIHO_AUD = new C_Kanjyoukmkcd("27245");

    public static final C_Kanjyoukmkcd SONOTAKARIUKEKIN_AZUKARIKIN_GAIHO_JPY = new C_Kanjyoukmkcd("27247");

    public static final C_Kanjyoukmkcd SONOTAKARIUKEKIN_AZUKARIKIN_GAIHO_USD = new C_Kanjyoukmkcd("27248");

    public static final C_Kanjyoukmkcd SONOTAKARIUKEKIN_AZUKARIKIN_GAIHO_AUD = new C_Kanjyoukmkcd("27249");

    public static final C_Kanjyoukmkcd HOKEN_KOBETUP_GAIHO_JPY = new C_Kanjyoukmkcd("27356");

    public static final C_Kanjyoukmkcd HOKEN_KOBETUP_GAIHO_USD = new C_Kanjyoukmkcd("27357");

    public static final C_Kanjyoukmkcd HOKEN_KOBETUP_GAIHO_AUD = new C_Kanjyoukmkcd("27358");

    public static final C_Kanjyoukmkcd SIBOUHOKENKIN_HUTUU = new C_Kanjyoukmkcd("40101");

    public static final C_Kanjyoukmkcd SIBOUHOKENKIN_GAIHO_JPY = new C_Kanjyoukmkcd("40124");

    public static final C_Kanjyoukmkcd SIBOUHOKENKIN_GAIHO_USD = new C_Kanjyoukmkcd("40129");

    public static final C_Kanjyoukmkcd SIBOUHOKENKIN_GAIHO_AUD = new C_Kanjyoukmkcd("40167");

    public static final C_Kanjyoukmkcd SIBOUKYUUHUKIN_GAIHO_JPY = new C_Kanjyoukmkcd("40437");

    public static final C_Kanjyoukmkcd SIBOUKYUUHUKIN_GAIHO_USD = new C_Kanjyoukmkcd("40438");

    public static final C_Kanjyoukmkcd SIBOUKYUUHUKIN_GAIHO_AUD = new C_Kanjyoukmkcd("40439");

    public static final C_Kanjyoukmkcd SAIGAISIBOUHOKENKIN_GAIHO_JPY = new C_Kanjyoukmkcd("40169");

    public static final C_Kanjyoukmkcd SAIGAISIBOUHOKENKIN_GAIHO_USD = new C_Kanjyoukmkcd("40170");

    public static final C_Kanjyoukmkcd SAIGAISIBOUHOKENKIN_GAIHO_AUD = new C_Kanjyoukmkcd("40389");

    public static final C_Kanjyoukmkcd KAIYAKUHENREIKIN_HUTUU = new C_Kanjyoukmkcd("40401");

    public static final C_Kanjyoukmkcd KAIYAKUHENREIKIN_GAIHO_JPY = new C_Kanjyoukmkcd("40434");

    public static final C_Kanjyoukmkcd KAIYAKUHENREIKIN_GAIHO_USD = new C_Kanjyoukmkcd("40435");

    public static final C_Kanjyoukmkcd KAIYAKUHENREIKIN_GAIHO_AUD = new C_Kanjyoukmkcd("40436");

    public static final C_Kanjyoukmkcd SONOTAHENREIKIN_GAIHO_JPY = new C_Kanjyoukmkcd("40511");

    public static final C_Kanjyoukmkcd SONOTAHENREIKIN_GAIHO_USD = new C_Kanjyoukmkcd("40512");

    public static final C_Kanjyoukmkcd SONOTAHENREIKIN_GAIHO_AUD = new C_Kanjyoukmkcd("40513");

    public static final C_Kanjyoukmkcd SONOTAHENREIKIN_HUTUU = new C_Kanjyoukmkcd("40581");

    public static final C_Kanjyoukmkcd JIGYOUHI = new C_Kanjyoukmkcd("41101");

    public static final C_Kanjyoukmkcd HOKENKEIYAKUSIHARAIRISOKU_HUTUU = new C_Kanjyoukmkcd("41503");

    public static final C_Kanjyoukmkcd HOKENKEIYAKUSIHARAIRISOKU_GAIHO_JPY = new C_Kanjyoukmkcd("41527");

    public static final C_Kanjyoukmkcd HOKENKEIYAKUSIHARAIRISOKU_GAIHO_USD = new C_Kanjyoukmkcd("41528");

    public static final C_Kanjyoukmkcd HOKENKEIYAKUSIHARAIRISOKU_GAIHO_AUD = new C_Kanjyoukmkcd("41529");

    public static final C_Kanjyoukmkcd HOKA_SEGMENT_SISYUTU_V = new C_Kanjyoukmkcd("48102");

    public static final C_Kanjyoukmkcd SYONENDOSYOKAIHOKENRYOU_GAIHO_JPY = new C_Kanjyoukmkcd("60547");

    public static final C_Kanjyoukmkcd SYONENDOSYOKAIHOKENRYOU_GAIHO_USD = new C_Kanjyoukmkcd("60548");

    public static final C_Kanjyoukmkcd SYONENDOSYOKAIHOKENRYOU_GAIHO_AUD = new C_Kanjyoukmkcd("60549");

    public static final C_Kanjyoukmkcd JINENDOIKOUHOKENRYOU_GAIHO_JPY = new C_Kanjyoukmkcd("60550");

    public static final C_Kanjyoukmkcd JINENDOIKOUHOKENRYOU_GAIHO_USD = new C_Kanjyoukmkcd("60551");

    public static final C_Kanjyoukmkcd JINENDOIKOUHOKENRYOU_GAIHO_AUD = new C_Kanjyoukmkcd("60552");

    public static final C_Kanjyoukmkcd HOKENKEIYAKUZATUSYUUNYUU = new C_Kanjyoukmkcd("62101");

    public static final C_Kanjyoukmkcd HOKA_SEGMENT_SYUUNYUU_V = new C_Kanjyoukmkcd("65102");

    public static final C_Kanjyoukmkcd SYONENDO2KAIMEIKOU_GAIHO_JPY = new C_Kanjyoukmkcd("60559");

    public static final C_Kanjyoukmkcd SYONENDO2KAIMEIKOU_GAIHO_USD = new C_Kanjyoukmkcd("60560");

    public static final C_Kanjyoukmkcd SYONENDO2KAIMEIKOU_GAIHO_AUD = new C_Kanjyoukmkcd("60561");

    public static final C_Kanjyoukmkcd SYAINHAITOUKIN_GAIHO_JPY = new C_Kanjyoukmkcd("40637");

    public static final C_Kanjyoukmkcd SYAINHAITOUKIN_GAIHO_USD = new C_Kanjyoukmkcd("40638");

    public static final C_Kanjyoukmkcd SYAINHAITOUKIN_GAIHO_AUD = new C_Kanjyoukmkcd("40639");

    public static final C_Kanjyoukmkcd KARIUKEKIN_HUHOKOBETU_GAIHO_JPY = new C_Kanjyoukmkcd("27250");

    public static final C_Kanjyoukmkcd KARIUKEKIN_HUHOKOBETU_GAIHO_USD = new C_Kanjyoukmkcd("27251");

    public static final C_Kanjyoukmkcd KARIUKEKIN_HUHOKOBETU_GAIHO_AUD = new C_Kanjyoukmkcd("27252");

    public static final C_Kanjyoukmkcd HOKENKEIYAKUKARIUKEKIN_HUHO_HURIKAE = new C_Kanjyoukmkcd("27123");

    public static final C_Kanjyoukmkcd HOKENKEIYAKUKARIBARAIKIN_HUHO_SYUUNOU = new C_Kanjyoukmkcd("19105");

    public static final C_Kanjyoukmkcd HOKENKEIYAKUKARIUKEKIN_HUHO_YOHURI = new C_Kanjyoukmkcd("27124");

    public static final C_Kanjyoukmkcd SONOTAKARIUKEKIN_SONOTA = new C_Kanjyoukmkcd("27169");

    public static final C_Kanjyoukmkcd SYAINHAITOUKIN_HUTUU = new C_Kanjyoukmkcd("40601");

    public static final C_Kanjyoukmkcd SONOTAKARIUKEKIN_AZUKARIKIN = new C_Kanjyoukmkcd("27166");

    public static final C_Kanjyoukmkcd SIBOUKYUUHUKIN_HUTUU = new C_Kanjyoukmkcd("40301");

    public static final C_Kanjyoukmkcd HOKENKEIYAKUKARIBARAIKIN_HUHO_KURE = new C_Kanjyoukmkcd("19109");

    public static final C_Kanjyoukmkcd SONOTAMISYUUKIN = new C_Kanjyoukmkcd("15599");

    public static final C_Kanjyoukmkcd HOKENKEIYAKUKARIUKEKIN_HUHO_SYOKAI = new C_Kanjyoukmkcd("27102");

    public static final C_Kanjyoukmkcd HOKENKEIYAKUKARIUKEKIN_HUHO_PKAKIN = new C_Kanjyoukmkcd("27103");

    public static final C_Kanjyoukmkcd HOKENKEIYAKUKARIUKEKIN_HUHO_DAI1KAI = new C_Kanjyoukmkcd("27109");

    public static final C_Kanjyoukmkcd SONOTAKARIUKEKIN_SINKEIYAKUFB = new C_Kanjyoukmkcd("27209");

    public static final C_Kanjyoukmkcd HOKENKEIYAKUKARIUKEKIN_HUHO_KOBETUP = new C_Kanjyoukmkcd("27355");

    public static final C_Kanjyoukmkcd SYONENDOSYOKAIHOKENRYOU_HUTUU = new C_Kanjyoukmkcd("60101");

    public static final C_Kanjyoukmkcd SYONENDO2KAIMEIKOU_HUTUU = new C_Kanjyoukmkcd("60121");

    public static final C_Kanjyoukmkcd JINENDOIKOUHOKENRYOU_HUTUU = new C_Kanjyoukmkcd("60141");

    public static final C_Kanjyoukmkcd HOKENKEIYAKUKARIUKEKIN_HUHO_KOBETU = new C_Kanjyoukmkcd("27105");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SONOTAKARIBARAIKIN_GAIHO, "SONOTAKARIBARAIKIN_GAIHO", false);
        addPattern(PATTERN_DEFAULT, HOKENKEIYAKU_SYOKAI_GAIHO_JPY, "HOKENKEIYAKU_SYOKAI_GAIHO_JPY", false);
        addPattern(PATTERN_DEFAULT, HOKENKEIYAKU_SYOKAI_GAIHO_USD, "HOKENKEIYAKU_SYOKAI_GAIHO_USD", false);
        addPattern(PATTERN_DEFAULT, HOKENKEIYAKU_SYOKAI_GAIHO_AUD, "HOKENKEIYAKU_SYOKAI_GAIHO_AUD", false);
        addPattern(PATTERN_DEFAULT, HOKENKEIYAKU_PKAKIN_GAIHO_JPY, "HOKENKEIYAKU_PKAKIN_GAIHO_JPY", false);
        addPattern(PATTERN_DEFAULT, HOKENKEIYAKU_PKAKIN_GAIHO_USD, "HOKENKEIYAKU_PKAKIN_GAIHO_USD", false);
        addPattern(PATTERN_DEFAULT, HOKENKEIYAKU_PKAKIN_GAIHO_AUD, "HOKENKEIYAKU_PKAKIN_GAIHO_AUD", false);
        addPattern(PATTERN_DEFAULT, HOKENKEIYAKU_KOBETU_GAIHO_JPY, "HOKENKEIYAKU_KOBETU_GAIHO_JPY", false);
        addPattern(PATTERN_DEFAULT, HOKENKEIYAKU_KOBETU_GAIHO_USD, "HOKENKEIYAKU_KOBETU_GAIHO_USD", false);
        addPattern(PATTERN_DEFAULT, HOKENKEIYAKU_KOBETU_GAIHO_AUD, "HOKENKEIYAKU_KOBETU_GAIHO_AUD", false);
        addPattern(PATTERN_DEFAULT, HOKENKEIYAKU_DAI1KAI_GAIHO_JPY, "HOKENKEIYAKU_DAI1KAI_GAIHO_JPY", false);
        addPattern(PATTERN_DEFAULT, HOKENKEIYAKU_DAI1KAI_GAIHO_USD, "HOKENKEIYAKU_DAI1KAI_GAIHO_USD", false);
        addPattern(PATTERN_DEFAULT, HOKENKEIYAKU_DAI1KAI_GAIHO_AUD, "HOKENKEIYAKU_DAI1KAI_GAIHO_AUD", false);
        addPattern(PATTERN_DEFAULT, SONOTAKARIUKEKIN_FBSOUKIN, "SONOTAKARIUKEKIN_FBSOUKIN", false);
        addPattern(PATTERN_DEFAULT, SONOTAKARIUKEKIN_GAIKAFBSOUKIN, "SONOTAKARIUKEKIN_GAIKAFBSOUKIN", false);
        addPattern(PATTERN_DEFAULT, SONOTAKARIUKEKIN_GAIHO, "SONOTAKARIUKEKIN_GAIHO", false);
        addPattern(PATTERN_DEFAULT, SINKEIYAKUFB_GAIHO_JPY, "SINKEIYAKUFB_GAIHO_JPY", false);
        addPattern(PATTERN_DEFAULT, SINKEIYAKUFB_GAIHO_USD, "SINKEIYAKUFB_GAIHO_USD", false);
        addPattern(PATTERN_DEFAULT, SINKEIYAKUFB_GAIHO_AUD, "SINKEIYAKUFB_GAIHO_AUD", false);
        addPattern(PATTERN_DEFAULT, SONOTAKARIUKEKIN_AZUKARIKIN_GAIHO_JPY, "SONOTAKARIUKEKIN_AZUKARIKIN_GAIHO_JPY", false);
        addPattern(PATTERN_DEFAULT, SONOTAKARIUKEKIN_AZUKARIKIN_GAIHO_USD, "SONOTAKARIUKEKIN_AZUKARIKIN_GAIHO_USD", false);
        addPattern(PATTERN_DEFAULT, SONOTAKARIUKEKIN_AZUKARIKIN_GAIHO_AUD, "SONOTAKARIUKEKIN_AZUKARIKIN_GAIHO_AUD", false);
        addPattern(PATTERN_DEFAULT, HOKEN_KOBETUP_GAIHO_JPY, "HOKEN_KOBETUP_GAIHO_JPY", false);
        addPattern(PATTERN_DEFAULT, HOKEN_KOBETUP_GAIHO_USD, "HOKEN_KOBETUP_GAIHO_USD", false);
        addPattern(PATTERN_DEFAULT, HOKEN_KOBETUP_GAIHO_AUD, "HOKEN_KOBETUP_GAIHO_AUD", false);
        addPattern(PATTERN_DEFAULT, SIBOUHOKENKIN_HUTUU, "SIBOUHOKENKIN_HUTUU", false);
        addPattern(PATTERN_DEFAULT, SIBOUHOKENKIN_GAIHO_JPY, "SIBOUHOKENKIN_GAIHO_JPY", false);
        addPattern(PATTERN_DEFAULT, SIBOUHOKENKIN_GAIHO_USD, "SIBOUHOKENKIN_GAIHO_USD", false);
        addPattern(PATTERN_DEFAULT, SIBOUHOKENKIN_GAIHO_AUD, "SIBOUHOKENKIN_GAIHO_AUD", false);
        addPattern(PATTERN_DEFAULT, SIBOUKYUUHUKIN_GAIHO_JPY, "SIBOUKYUUHUKIN_GAIHO_JPY", false);
        addPattern(PATTERN_DEFAULT, SIBOUKYUUHUKIN_GAIHO_USD, "SIBOUKYUUHUKIN_GAIHO_USD", false);
        addPattern(PATTERN_DEFAULT, SIBOUKYUUHUKIN_GAIHO_AUD, "SIBOUKYUUHUKIN_GAIHO_AUD", false);
        addPattern(PATTERN_DEFAULT, SAIGAISIBOUHOKENKIN_GAIHO_JPY, "SAIGAISIBOUHOKENKIN_GAIHO_JPY", false);
        addPattern(PATTERN_DEFAULT, SAIGAISIBOUHOKENKIN_GAIHO_USD, "SAIGAISIBOUHOKENKIN_GAIHO_USD", false);
        addPattern(PATTERN_DEFAULT, SAIGAISIBOUHOKENKIN_GAIHO_AUD, "SAIGAISIBOUHOKENKIN_GAIHO_AUD", false);
        addPattern(PATTERN_DEFAULT, KAIYAKUHENREIKIN_HUTUU, "KAIYAKUHENREIKIN_HUTUU", false);
        addPattern(PATTERN_DEFAULT, KAIYAKUHENREIKIN_GAIHO_JPY, "KAIYAKUHENREIKIN_GAIHO_JPY", false);
        addPattern(PATTERN_DEFAULT, KAIYAKUHENREIKIN_GAIHO_USD, "KAIYAKUHENREIKIN_GAIHO_USD", false);
        addPattern(PATTERN_DEFAULT, KAIYAKUHENREIKIN_GAIHO_AUD, "KAIYAKUHENREIKIN_GAIHO_AUD", false);
        addPattern(PATTERN_DEFAULT, SONOTAHENREIKIN_GAIHO_JPY, "SONOTAHENREIKIN_GAIHO_JPY", false);
        addPattern(PATTERN_DEFAULT, SONOTAHENREIKIN_GAIHO_USD, "SONOTAHENREIKIN_GAIHO_USD", false);
        addPattern(PATTERN_DEFAULT, SONOTAHENREIKIN_GAIHO_AUD, "SONOTAHENREIKIN_GAIHO_AUD", false);
        addPattern(PATTERN_DEFAULT, SONOTAHENREIKIN_HUTUU, "SONOTAHENREIKIN_HUTUU", false);
        addPattern(PATTERN_DEFAULT, JIGYOUHI, "JIGYOUHI", false);
        addPattern(PATTERN_DEFAULT, HOKENKEIYAKUSIHARAIRISOKU_HUTUU, "HOKENKEIYAKUSIHARAIRISOKU_HUTUU", false);
        addPattern(PATTERN_DEFAULT, HOKENKEIYAKUSIHARAIRISOKU_GAIHO_JPY, "HOKENKEIYAKUSIHARAIRISOKU_GAIHO_JPY", false);
        addPattern(PATTERN_DEFAULT, HOKENKEIYAKUSIHARAIRISOKU_GAIHO_USD, "HOKENKEIYAKUSIHARAIRISOKU_GAIHO_USD", false);
        addPattern(PATTERN_DEFAULT, HOKENKEIYAKUSIHARAIRISOKU_GAIHO_AUD, "HOKENKEIYAKUSIHARAIRISOKU_GAIHO_AUD", false);
        addPattern(PATTERN_DEFAULT, HOKA_SEGMENT_SISYUTU_V, "HOKA_SEGMENT_SISYUTU_V", false);
        addPattern(PATTERN_DEFAULT, SYONENDOSYOKAIHOKENRYOU_GAIHO_JPY, "SYONENDOSYOKAIHOKENRYOU_GAIHO_JPY", false);
        addPattern(PATTERN_DEFAULT, SYONENDOSYOKAIHOKENRYOU_GAIHO_USD, "SYONENDOSYOKAIHOKENRYOU_GAIHO_USD", false);
        addPattern(PATTERN_DEFAULT, SYONENDOSYOKAIHOKENRYOU_GAIHO_AUD, "SYONENDOSYOKAIHOKENRYOU_GAIHO_AUD", false);
        addPattern(PATTERN_DEFAULT, JINENDOIKOUHOKENRYOU_GAIHO_JPY, "JINENDOIKOUHOKENRYOU_GAIHO_JPY", false);
        addPattern(PATTERN_DEFAULT, JINENDOIKOUHOKENRYOU_GAIHO_USD, "JINENDOIKOUHOKENRYOU_GAIHO_USD", false);
        addPattern(PATTERN_DEFAULT, JINENDOIKOUHOKENRYOU_GAIHO_AUD, "JINENDOIKOUHOKENRYOU_GAIHO_AUD", false);
        addPattern(PATTERN_DEFAULT, HOKENKEIYAKUZATUSYUUNYUU, "HOKENKEIYAKUZATUSYUUNYUU", false);
        addPattern(PATTERN_DEFAULT, HOKA_SEGMENT_SYUUNYUU_V, "HOKA_SEGMENT_SYUUNYUU_V", false);
        addPattern(PATTERN_DEFAULT, SYONENDO2KAIMEIKOU_GAIHO_JPY, "SYONENDO2KAIMEIKOU_GAIHO_JPY", false);
        addPattern(PATTERN_DEFAULT, SYONENDO2KAIMEIKOU_GAIHO_USD, "SYONENDO2KAIMEIKOU_GAIHO_USD", false);
        addPattern(PATTERN_DEFAULT, SYONENDO2KAIMEIKOU_GAIHO_AUD, "SYONENDO2KAIMEIKOU_GAIHO_AUD", false);
        addPattern(PATTERN_DEFAULT, SYAINHAITOUKIN_GAIHO_JPY, "SYAINHAITOUKIN_GAIHO_JPY", false);
        addPattern(PATTERN_DEFAULT, SYAINHAITOUKIN_GAIHO_USD, "SYAINHAITOUKIN_GAIHO_USD", false);
        addPattern(PATTERN_DEFAULT, SYAINHAITOUKIN_GAIHO_AUD, "SYAINHAITOUKIN_GAIHO_AUD", false);
        addPattern(PATTERN_DEFAULT, KARIUKEKIN_HUHOKOBETU_GAIHO_JPY, "KARIUKEKIN_HUHOKOBETU_GAIHO_JPY", false);
        addPattern(PATTERN_DEFAULT, KARIUKEKIN_HUHOKOBETU_GAIHO_USD, "KARIUKEKIN_HUHOKOBETU_GAIHO_USD", false);
        addPattern(PATTERN_DEFAULT, KARIUKEKIN_HUHOKOBETU_GAIHO_AUD, "KARIUKEKIN_HUHOKOBETU_GAIHO_AUD", false);
        addPattern(PATTERN_DEFAULT, HOKENKEIYAKUKARIUKEKIN_HUHO_HURIKAE, "HOKENKEIYAKUKARIUKEKIN_HUHO_HURIKAE", false);
        addPattern(PATTERN_DEFAULT, HOKENKEIYAKUKARIBARAIKIN_HUHO_SYUUNOU, "HOKENKEIYAKUKARIBARAIKIN_HUHO_SYUUNOU", false);
        addPattern(PATTERN_DEFAULT, HOKENKEIYAKUKARIUKEKIN_HUHO_YOHURI, "HOKENKEIYAKUKARIUKEKIN_HUHO_YOHURI", false);
        addPattern(PATTERN_DEFAULT, SONOTAKARIUKEKIN_SONOTA, "SONOTAKARIUKEKIN_SONOTA", false);
        addPattern(PATTERN_DEFAULT, SYAINHAITOUKIN_HUTUU, "SYAINHAITOUKIN_HUTUU", false);
        addPattern(PATTERN_DEFAULT, SONOTAKARIUKEKIN_AZUKARIKIN, "SONOTAKARIUKEKIN_AZUKARIKIN", false);
        addPattern(PATTERN_DEFAULT, SIBOUKYUUHUKIN_HUTUU, "SIBOUKYUUHUKIN_HUTUU", false);
        addPattern(PATTERN_DEFAULT, HOKENKEIYAKUKARIBARAIKIN_HUHO_KURE, "HOKENKEIYAKUKARIBARAIKIN_HUHO_KURE", false);
        addPattern(PATTERN_DEFAULT, SONOTAMISYUUKIN, "SONOTAMISYUUKIN", false);
        addPattern(PATTERN_DEFAULT, HOKENKEIYAKUKARIUKEKIN_HUHO_SYOKAI, "HOKENKEIYAKUKARIUKEKIN_HUHO_SYOKAI", false);
        addPattern(PATTERN_DEFAULT, HOKENKEIYAKUKARIUKEKIN_HUHO_PKAKIN, "HOKENKEIYAKUKARIUKEKIN_HUHO_PKAKIN", false);
        addPattern(PATTERN_DEFAULT, HOKENKEIYAKUKARIUKEKIN_HUHO_DAI1KAI, "HOKENKEIYAKUKARIUKEKIN_HUHO_DAI1KAI", false);
        addPattern(PATTERN_DEFAULT, SONOTAKARIUKEKIN_SINKEIYAKUFB, "SONOTAKARIUKEKIN_SINKEIYAKUFB", false);
        addPattern(PATTERN_DEFAULT, HOKENKEIYAKUKARIUKEKIN_HUHO_KOBETUP, "HOKENKEIYAKUKARIUKEKIN_HUHO_KOBETUP", false);
        addPattern(PATTERN_DEFAULT, SYONENDOSYOKAIHOKENRYOU_HUTUU, "SYONENDOSYOKAIHOKENRYOU_HUTUU", false);
        addPattern(PATTERN_DEFAULT, SYONENDO2KAIMEIKOU_HUTUU, "SYONENDO2KAIMEIKOU_HUTUU", false);
        addPattern(PATTERN_DEFAULT, JINENDOIKOUHOKENRYOU_HUTUU, "JINENDOIKOUHOKENRYOU_HUTUU", false);
        addPattern(PATTERN_DEFAULT, HOKENKEIYAKUKARIUKEKIN_HUHO_KOBETU, "HOKENKEIYAKUKARIUKEKIN_HUHO_KOBETU", false);


        lock(C_Kanjyoukmkcd.class);
    }

    private C_Kanjyoukmkcd(String value) {
        super(value);
    }

    public static C_Kanjyoukmkcd valueOf(String value) {
        return valueOf(C_Kanjyoukmkcd.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Kanjyoukmkcd.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Kanjyoukmkcd.class, patternId, value);
    }
}
