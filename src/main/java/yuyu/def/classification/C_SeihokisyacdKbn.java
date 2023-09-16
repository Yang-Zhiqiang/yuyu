
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 生保会社コード区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SeihokisyacdKbn</td><td colspan="3">生保会社コード区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="70">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;00&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NIHON}</td><td>&quot;DA&quot;</td><td>DA:日本</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AKUSAGROUPE}</td><td>&quot;DB&quot;</td><td>DB:アクサグループライフ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AOBA}</td><td>&quot;DC&quot;</td><td>DC:あおば</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MASMYU}</td><td>&quot;DD&quot;</td><td>DD:マスミューチュアル</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TDFIN}</td><td>&quot;DF&quot;</td><td>DF:Ｔ＆Ｄフィナンシャル</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AIGSTAR}</td><td>&quot;DG&quot;</td><td>DG:エイアイジー・スター</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TAIYOU}</td><td>&quot;DH&quot;</td><td>DH:太陽</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAIITI}</td><td>&quot;DJ&quot;</td><td>DJ:第一</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAIDOU}</td><td>&quot;DK&quot;</td><td>DK:大同</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAIWA}</td><td>&quot;DM&quot;</td><td>DM:大和</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYUYASUDA}</td><td>&quot;DN&quot;</td><td>DN:（旧）安田</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUKOKU}</td><td>&quot;DO&quot;</td><td>DO:富国</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ASAHI}</td><td>&quot;DP&quot;</td><td>DP:朝日</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIBURARUTA}</td><td>&quot;DQ&quot;</td><td>DQ:ジブラルタ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MEIJIYASUDA}</td><td>&quot;DR&quot;</td><td>DR:明治安田</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MITUI}</td><td>&quot;DS&quot;</td><td>DS:三井</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUMITOMO}</td><td>&quot;DT&quot;</td><td>DT:住友</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONY}</td><td>&quot;DU&quot;</td><td>DU:ソニー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYUSEZON}</td><td>&quot;DV&quot;</td><td>DV:（旧）セゾン</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONJHIMAWARI}</td><td>&quot;DW&quot;</td><td>DW:ＮＫＳＪひまわり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KUREDI}</td><td>&quot;DX&quot;</td><td>DX:クレディ・スイス</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PURUDEN}</td><td>&quot;DY&quot;</td><td>DY:プルデンシャル</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PCA}</td><td>&quot;DZ&quot;</td><td>DZ:ピーシーエー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ORIX}</td><td>&quot;EA&quot;</td><td>EA:オリックス</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AKUSA}</td><td>&quot;EB&quot;</td><td>EB:アクサ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ING}</td><td>&quot;EC&quot;</td><td>EC:アイエヌジー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUMIKAIAIOI}</td><td>&quot;ED&quot;</td><td>ED:三井住友海上あいおい</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FUKOSHIN}</td><td>&quot;EE&quot;</td><td>EE:フコクしんらい</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NIHONKOUA}</td><td>&quot;EF&quot;</td><td>EF:日本興亜</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AIOI}</td><td>&quot;EH&quot;</td><td>EH:あいおい</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUKAI}</td><td>&quot;EJ&quot;</td><td>EJ:東京海上日動あんしん</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYUNITIDOU}</td><td>&quot;EL&quot;</td><td>EL:（旧）日動</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AIGFUJI}</td><td>&quot;EN&quot;</td><td>EN:ＡＩＧ富士</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOUKAIF}</td><td>&quot;EO&quot;</td><td>EO:東京海上日動フィナンシャル</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AIGEGISON}</td><td>&quot;EP&quot;</td><td>EP:ＡＩＧエジソン</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MANYU}</td><td>&quot;EQ&quot;</td><td>EQ:マニュライフ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONJ}</td><td>&quot;ER&quot;</td><td>ER:損保ジャパン・ディー・アイ・ワイ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HEARTF}</td><td>&quot;ES&quot;</td><td>ES:ハートフォード</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PRUGIB}</td><td>&quot;ET&quot;</td><td>ET:プルデンシャルジブラルタファイナンシャル</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUMIKAIMET}</td><td>&quot;EU&quot;</td><td>EU:三井住友海上プライマリー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CREAGU}</td><td>&quot;EW&quot;</td><td>EW:クレディ・アグリコル</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAIITIF}</td><td>&quot;EX&quot;</td><td>EX:第一フロンティア</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANPO}</td><td>&quot;EY&quot;</td><td>EY:かんぽ生命</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ALLIANZ}</td><td>&quot;EZ&quot;</td><td>EZ:アリアンツ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PIONEER}</td><td>&quot;FA&quot;</td><td>FA:パイオニア・アメリカン</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #WORLD}</td><td>&quot;FB&quot;</td><td>FB:ワールド・サービス</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ALICOJAPAN}</td><td>&quot;FC&quot;</td><td>FC:メットライフ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TRANCEAMERICAN}</td><td>&quot;FD&quot;</td><td>FD:トランスアメリカ・オクシデンタル</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AMIKAPLE}</td><td>&quot;FE&quot;</td><td>FE:アメリカン・アミカプル</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NATIONAL}</td><td>&quot;FF&quot;</td><td>FF:ナショナル・トラベラーズ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UOO}</td><td>&quot;FG&quot;</td><td>FG:ユナイテッド・オブ・オマハ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MIDLAND}</td><td>&quot;FH&quot;</td><td>FH:ミッドランド・ナショナル</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AMERICANDEF}</td><td>&quot;FL&quot;</td><td>FL:アメリカン・ディフェンダー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AMERICANFE}</td><td>&quot;FM&quot;</td><td>FM:アメリカン・フイデリティ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FSTNATIONAL}</td><td>&quot;FN&quot;</td><td>FN:ファースト・ナショナル</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OLDREP}</td><td>&quot;FP&quot;</td><td>FP:オールド・リパブリック</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TRANCEWORLD}</td><td>&quot;FR&quot;</td><td>FR:トランス・ワールト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UNITED}</td><td>&quot;FS&quot;</td><td>FS:ユナイテッド・サービス</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AMERICANFAM}</td><td>&quot;FT&quot;</td><td>FT:アメリカンファミリー</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CONAMERICA}</td><td>&quot;FU&quot;</td><td>FU:コンバインド・オブ・アメリカ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NEDEL}</td><td>&quot;FV&quot;</td><td>FV:ナショナーレ・ネーデルランデン</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CHU}</td><td>&quot;FW&quot;</td><td>FW:チューリッヒ・ライフ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KADEF}</td><td>&quot;FX&quot;</td><td>FX:カーディフ・アシュアランス・ウ゛ィ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #LIFENET}</td><td>&quot;JA&quot;</td><td>JA:ライフネット</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AKUSADIRECT}</td><td>&quot;JB&quot;</td><td>JB:アクサダイレクト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MIDORI}</td><td>&quot;JC&quot;</td><td>JC:みどり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #RAKUTEN}</td><td>&quot;JD&quot;</td><td>JD:楽天</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AEGONSONY}</td><td>&quot;JE&quot;</td><td>JE:ソニーライフ・エイゴン</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MEDICARE}</td><td>&quot;JF&quot;</td><td>JF:メディケア</td></tr>
 * </table>
 */
public class C_SeihokisyacdKbn extends Classification<C_SeihokisyacdKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SeihokisyacdKbn BLNK = new C_SeihokisyacdKbn("00");

    public static final C_SeihokisyacdKbn NIHON = new C_SeihokisyacdKbn("DA");

    public static final C_SeihokisyacdKbn AKUSAGROUPE = new C_SeihokisyacdKbn("DB");

    public static final C_SeihokisyacdKbn AOBA = new C_SeihokisyacdKbn("DC");

    public static final C_SeihokisyacdKbn MASMYU = new C_SeihokisyacdKbn("DD");

    public static final C_SeihokisyacdKbn TDFIN = new C_SeihokisyacdKbn("DF");

    public static final C_SeihokisyacdKbn AIGSTAR = new C_SeihokisyacdKbn("DG");

    public static final C_SeihokisyacdKbn TAIYOU = new C_SeihokisyacdKbn("DH");

    public static final C_SeihokisyacdKbn DAIITI = new C_SeihokisyacdKbn("DJ");

    public static final C_SeihokisyacdKbn DAIDOU = new C_SeihokisyacdKbn("DK");

    public static final C_SeihokisyacdKbn DAIWA = new C_SeihokisyacdKbn("DM");

    public static final C_SeihokisyacdKbn KYUYASUDA = new C_SeihokisyacdKbn("DN");

    public static final C_SeihokisyacdKbn HUKOKU = new C_SeihokisyacdKbn("DO");

    public static final C_SeihokisyacdKbn ASAHI = new C_SeihokisyacdKbn("DP");

    public static final C_SeihokisyacdKbn JIBURARUTA = new C_SeihokisyacdKbn("DQ");

    public static final C_SeihokisyacdKbn MEIJIYASUDA = new C_SeihokisyacdKbn("DR");

    public static final C_SeihokisyacdKbn MITUI = new C_SeihokisyacdKbn("DS");

    public static final C_SeihokisyacdKbn SUMITOMO = new C_SeihokisyacdKbn("DT");

    public static final C_SeihokisyacdKbn SONY = new C_SeihokisyacdKbn("DU");

    public static final C_SeihokisyacdKbn KYUSEZON = new C_SeihokisyacdKbn("DV");

    public static final C_SeihokisyacdKbn SONJHIMAWARI = new C_SeihokisyacdKbn("DW");

    public static final C_SeihokisyacdKbn KUREDI = new C_SeihokisyacdKbn("DX");

    public static final C_SeihokisyacdKbn PURUDEN = new C_SeihokisyacdKbn("DY");

    public static final C_SeihokisyacdKbn PCA = new C_SeihokisyacdKbn("DZ");

    public static final C_SeihokisyacdKbn ORIX = new C_SeihokisyacdKbn("EA");

    public static final C_SeihokisyacdKbn AKUSA = new C_SeihokisyacdKbn("EB");

    public static final C_SeihokisyacdKbn ING = new C_SeihokisyacdKbn("EC");

    public static final C_SeihokisyacdKbn SUMIKAIAIOI = new C_SeihokisyacdKbn("ED");

    public static final C_SeihokisyacdKbn FUKOSHIN = new C_SeihokisyacdKbn("EE");

    public static final C_SeihokisyacdKbn NIHONKOUA = new C_SeihokisyacdKbn("EF");

    public static final C_SeihokisyacdKbn AIOI = new C_SeihokisyacdKbn("EH");

    public static final C_SeihokisyacdKbn TOUKAI = new C_SeihokisyacdKbn("EJ");

    public static final C_SeihokisyacdKbn KYUNITIDOU = new C_SeihokisyacdKbn("EL");

    public static final C_SeihokisyacdKbn AIGFUJI = new C_SeihokisyacdKbn("EN");

    public static final C_SeihokisyacdKbn TOUKAIF = new C_SeihokisyacdKbn("EO");

    public static final C_SeihokisyacdKbn AIGEGISON = new C_SeihokisyacdKbn("EP");

    public static final C_SeihokisyacdKbn MANYU = new C_SeihokisyacdKbn("EQ");

    public static final C_SeihokisyacdKbn SONJ = new C_SeihokisyacdKbn("ER");

    public static final C_SeihokisyacdKbn HEARTF = new C_SeihokisyacdKbn("ES");

    public static final C_SeihokisyacdKbn PRUGIB = new C_SeihokisyacdKbn("ET");

    public static final C_SeihokisyacdKbn SUMIKAIMET = new C_SeihokisyacdKbn("EU");

    public static final C_SeihokisyacdKbn CREAGU = new C_SeihokisyacdKbn("EW");

    public static final C_SeihokisyacdKbn DAIITIF = new C_SeihokisyacdKbn("EX");

    public static final C_SeihokisyacdKbn KANPO = new C_SeihokisyacdKbn("EY");

    public static final C_SeihokisyacdKbn ALLIANZ = new C_SeihokisyacdKbn("EZ");

    public static final C_SeihokisyacdKbn PIONEER = new C_SeihokisyacdKbn("FA");

    public static final C_SeihokisyacdKbn WORLD = new C_SeihokisyacdKbn("FB");

    public static final C_SeihokisyacdKbn ALICOJAPAN = new C_SeihokisyacdKbn("FC");

    public static final C_SeihokisyacdKbn TRANCEAMERICAN = new C_SeihokisyacdKbn("FD");

    public static final C_SeihokisyacdKbn AMIKAPLE = new C_SeihokisyacdKbn("FE");

    public static final C_SeihokisyacdKbn NATIONAL = new C_SeihokisyacdKbn("FF");

    public static final C_SeihokisyacdKbn UOO = new C_SeihokisyacdKbn("FG");

    public static final C_SeihokisyacdKbn MIDLAND = new C_SeihokisyacdKbn("FH");

    public static final C_SeihokisyacdKbn AMERICANDEF = new C_SeihokisyacdKbn("FL");

    public static final C_SeihokisyacdKbn AMERICANFE = new C_SeihokisyacdKbn("FM");

    public static final C_SeihokisyacdKbn FSTNATIONAL = new C_SeihokisyacdKbn("FN");

    public static final C_SeihokisyacdKbn OLDREP = new C_SeihokisyacdKbn("FP");

    public static final C_SeihokisyacdKbn TRANCEWORLD = new C_SeihokisyacdKbn("FR");

    public static final C_SeihokisyacdKbn UNITED = new C_SeihokisyacdKbn("FS");

    public static final C_SeihokisyacdKbn AMERICANFAM = new C_SeihokisyacdKbn("FT");

    public static final C_SeihokisyacdKbn CONAMERICA = new C_SeihokisyacdKbn("FU");

    public static final C_SeihokisyacdKbn NEDEL = new C_SeihokisyacdKbn("FV");

    public static final C_SeihokisyacdKbn CHU = new C_SeihokisyacdKbn("FW");

    public static final C_SeihokisyacdKbn KADEF = new C_SeihokisyacdKbn("FX");

    public static final C_SeihokisyacdKbn LIFENET = new C_SeihokisyacdKbn("JA");

    public static final C_SeihokisyacdKbn AKUSADIRECT = new C_SeihokisyacdKbn("JB");

    public static final C_SeihokisyacdKbn MIDORI = new C_SeihokisyacdKbn("JC");

    public static final C_SeihokisyacdKbn RAKUTEN = new C_SeihokisyacdKbn("JD");

    public static final C_SeihokisyacdKbn AEGONSONY = new C_SeihokisyacdKbn("JE");

    public static final C_SeihokisyacdKbn MEDICARE = new C_SeihokisyacdKbn("JF");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, NIHON, "NIHON", false);
        addPattern(PATTERN_DEFAULT, AKUSAGROUPE, "AKUSAGROUPE", false);
        addPattern(PATTERN_DEFAULT, AOBA, "AOBA", false);
        addPattern(PATTERN_DEFAULT, MASMYU, "MASMYU", false);
        addPattern(PATTERN_DEFAULT, TDFIN, "TDFIN", false);
        addPattern(PATTERN_DEFAULT, AIGSTAR, "AIGSTAR", false);
        addPattern(PATTERN_DEFAULT, TAIYOU, "TAIYOU", false);
        addPattern(PATTERN_DEFAULT, DAIITI, "DAIITI", false);
        addPattern(PATTERN_DEFAULT, DAIDOU, "DAIDOU", false);
        addPattern(PATTERN_DEFAULT, DAIWA, "DAIWA", false);
        addPattern(PATTERN_DEFAULT, KYUYASUDA, "KYUYASUDA", false);
        addPattern(PATTERN_DEFAULT, HUKOKU, "HUKOKU", false);
        addPattern(PATTERN_DEFAULT, ASAHI, "ASAHI", false);
        addPattern(PATTERN_DEFAULT, JIBURARUTA, "JIBURARUTA", false);
        addPattern(PATTERN_DEFAULT, MEIJIYASUDA, "MEIJIYASUDA", false);
        addPattern(PATTERN_DEFAULT, MITUI, "MITUI", false);
        addPattern(PATTERN_DEFAULT, SUMITOMO, "SUMITOMO", false);
        addPattern(PATTERN_DEFAULT, SONY, "SONY", false);
        addPattern(PATTERN_DEFAULT, KYUSEZON, "KYUSEZON", false);
        addPattern(PATTERN_DEFAULT, SONJHIMAWARI, "SONJHIMAWARI", false);
        addPattern(PATTERN_DEFAULT, KUREDI, "KUREDI", false);
        addPattern(PATTERN_DEFAULT, PURUDEN, "PURUDEN", false);
        addPattern(PATTERN_DEFAULT, PCA, "PCA", false);
        addPattern(PATTERN_DEFAULT, ORIX, "ORIX", false);
        addPattern(PATTERN_DEFAULT, AKUSA, "AKUSA", false);
        addPattern(PATTERN_DEFAULT, ING, "ING", false);
        addPattern(PATTERN_DEFAULT, SUMIKAIAIOI, "SUMIKAIAIOI", false);
        addPattern(PATTERN_DEFAULT, FUKOSHIN, "FUKOSHIN", false);
        addPattern(PATTERN_DEFAULT, NIHONKOUA, "NIHONKOUA", false);
        addPattern(PATTERN_DEFAULT, AIOI, "AIOI", false);
        addPattern(PATTERN_DEFAULT, TOUKAI, "TOUKAI", false);
        addPattern(PATTERN_DEFAULT, KYUNITIDOU, "KYUNITIDOU", false);
        addPattern(PATTERN_DEFAULT, AIGFUJI, "AIGFUJI", false);
        addPattern(PATTERN_DEFAULT, TOUKAIF, "TOUKAIF", false);
        addPattern(PATTERN_DEFAULT, AIGEGISON, "AIGEGISON", false);
        addPattern(PATTERN_DEFAULT, MANYU, "MANYU", false);
        addPattern(PATTERN_DEFAULT, SONJ, "SONJ", false);
        addPattern(PATTERN_DEFAULT, HEARTF, "HEARTF", false);
        addPattern(PATTERN_DEFAULT, PRUGIB, "PRUGIB", false);
        addPattern(PATTERN_DEFAULT, SUMIKAIMET, "SUMIKAIMET", false);
        addPattern(PATTERN_DEFAULT, CREAGU, "CREAGU", false);
        addPattern(PATTERN_DEFAULT, DAIITIF, "DAIITIF", false);
        addPattern(PATTERN_DEFAULT, KANPO, "KANPO", false);
        addPattern(PATTERN_DEFAULT, ALLIANZ, "ALLIANZ", false);
        addPattern(PATTERN_DEFAULT, PIONEER, "PIONEER", false);
        addPattern(PATTERN_DEFAULT, WORLD, "WORLD", false);
        addPattern(PATTERN_DEFAULT, ALICOJAPAN, "ALICOJAPAN", false);
        addPattern(PATTERN_DEFAULT, TRANCEAMERICAN, "TRANCEAMERICAN", false);
        addPattern(PATTERN_DEFAULT, AMIKAPLE, "AMIKAPLE", false);
        addPattern(PATTERN_DEFAULT, NATIONAL, "NATIONAL", false);
        addPattern(PATTERN_DEFAULT, UOO, "UOO", false);
        addPattern(PATTERN_DEFAULT, MIDLAND, "MIDLAND", false);
        addPattern(PATTERN_DEFAULT, AMERICANDEF, "AMERICANDEF", false);
        addPattern(PATTERN_DEFAULT, AMERICANFE, "AMERICANFE", false);
        addPattern(PATTERN_DEFAULT, FSTNATIONAL, "FSTNATIONAL", false);
        addPattern(PATTERN_DEFAULT, OLDREP, "OLDREP", false);
        addPattern(PATTERN_DEFAULT, TRANCEWORLD, "TRANCEWORLD", false);
        addPattern(PATTERN_DEFAULT, UNITED, "UNITED", false);
        addPattern(PATTERN_DEFAULT, AMERICANFAM, "AMERICANFAM", false);
        addPattern(PATTERN_DEFAULT, CONAMERICA, "CONAMERICA", false);
        addPattern(PATTERN_DEFAULT, NEDEL, "NEDEL", false);
        addPattern(PATTERN_DEFAULT, CHU, "CHU", false);
        addPattern(PATTERN_DEFAULT, KADEF, "KADEF", false);
        addPattern(PATTERN_DEFAULT, LIFENET, "LIFENET", false);
        addPattern(PATTERN_DEFAULT, AKUSADIRECT, "AKUSADIRECT", false);
        addPattern(PATTERN_DEFAULT, MIDORI, "MIDORI", false);
        addPattern(PATTERN_DEFAULT, RAKUTEN, "RAKUTEN", false);
        addPattern(PATTERN_DEFAULT, AEGONSONY, "AEGONSONY", false);
        addPattern(PATTERN_DEFAULT, MEDICARE, "MEDICARE", false);


        lock(C_SeihokisyacdKbn.class);
    }

    private C_SeihokisyacdKbn(String value) {
        super(value);
    }

    public static C_SeihokisyacdKbn valueOf(String value) {
        return valueOf(C_SeihokisyacdKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SeihokisyacdKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SeihokisyacdKbn.class, patternId, value);
    }
}
