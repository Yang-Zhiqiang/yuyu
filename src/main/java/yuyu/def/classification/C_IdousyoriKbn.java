
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 異動処理区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_IdousyoriKbn</td><td colspan="3">異動処理区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="42">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINKEI}</td><td>&quot;101&quot;</td><td>新契約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEINENGAPPISEI}</td><td>&quot;201&quot;</td><td>生年月日・性訂正</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIYAKUHENKOU}</td><td>&quot;202&quot;</td><td>契約変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HRIHN}</td><td>&quot;203&quot;</td><td>払方変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TSNGNDTYOUKA}</td><td>&quot;204&quot;</td><td>通算限度超過</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GANMUKOU}</td><td>&quot;205&quot;</td><td>がん無効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOUSIDEMUKOU}</td><td>&quot;206&quot;</td><td>申出無効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUKKATU}</td><td>&quot;301&quot;</td><td>復活</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKU}</td><td>&quot;401&quot;</td><td>解約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKTORIKESI}</td><td>&quot;402&quot;</td><td>契約取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CLGOFF}</td><td>&quot;403&quot;</td><td>クーリングオフ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIJO}</td><td>&quot;404&quot;</td><td>解除</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MUKOU}</td><td>&quot;405&quot;</td><td>無効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOU}</td><td>&quot;406&quot;</td><td>死亡</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MENSEKI}</td><td>&quot;407&quot;</td><td>免責</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIKKOU}</td><td>&quot;408&quot;</td><td>失効処理</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBKAIJO}</td><td>&quot;409&quot;</td><td>死亡解除</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MUKOU_1PMINYUUKIN}</td><td>&quot;410&quot;</td><td>無効（第１回保険料未入金）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PMEN}</td><td>&quot;501&quot;</td><td>Ｐ免</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HARAIMAN}</td><td>&quot;502&quot;</td><td>払満処理</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MEIGIHNK}</td><td>&quot;601&quot;</td><td>名義変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ADRHNK}</td><td>&quot;602&quot;</td><td>住所変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUZASEIBI}</td><td>&quot;603&quot;</td><td>口座整備処理</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GANSINDAN}</td><td>&quot;604&quot;</td><td>がん診断</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOSAIHK}</td><td>&quot;701&quot;</td><td>証券再発行</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUJYOSYOUMEI}</td><td>&quot;702&quot;</td><td>控除証明書再発行</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MISYUUPINFOTORIKOMI}</td><td>&quot;801&quot;</td><td>未収Ｐ情報取込</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ONLINENYKN}</td><td>&quot;802&quot;</td><td>オンライン入金処理</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NYUUKINTORIKESI}</td><td>&quot;803&quot;</td><td>入金取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KRUKTEISEI}</td><td>&quot;804&quot;</td><td>仮受訂正</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DATTAI}</td><td>&quot;805&quot;</td><td>脱退処理</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ONLINEDATTAI}</td><td>&quot;806&quot;</td><td>オンライン脱退処理</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DATTAITRKS}</td><td>&quot;807&quot;</td><td>脱退取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IKKATUNYUUKINTYUUSI}</td><td>&quot;808&quot;</td><td>一括入金中止</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TTDKTYUUI}</td><td>&quot;901&quot;</td><td>手続注意設定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUKKATUENKI}</td><td>&quot;902&quot;</td><td>復活延期</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUKKATUMIAWASE}</td><td>&quot;903&quot;</td><td>復活見合わせ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUYOKKNTOKUSIN}</td><td>&quot;904&quot;</td><td>猶予期間特伸処理</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUTANPOARIKEIZOKU}</td><td>&quot;905&quot;</td><td>不担保有り継続</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HRIHN_TORIKESIZUMI}</td><td>&quot;S01&quot;</td><td>払方変更（取消済）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HRIKAIHENTORIKESI_SESAGYOU}</td><td>&quot;S02&quot;</td><td>払込回数変更取消（ＳＥ作業）</td></tr>
 * </table>
 */
public class C_IdousyoriKbn extends Classification<C_IdousyoriKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_IdousyoriKbn BLNK = new C_IdousyoriKbn("0");

    public static final C_IdousyoriKbn SINKEI = new C_IdousyoriKbn("101");

    public static final C_IdousyoriKbn SEINENGAPPISEI = new C_IdousyoriKbn("201");

    public static final C_IdousyoriKbn KEIYAKUHENKOU = new C_IdousyoriKbn("202");

    public static final C_IdousyoriKbn HRIHN = new C_IdousyoriKbn("203");

    public static final C_IdousyoriKbn TSNGNDTYOUKA = new C_IdousyoriKbn("204");

    public static final C_IdousyoriKbn GANMUKOU = new C_IdousyoriKbn("205");

    public static final C_IdousyoriKbn MOUSIDEMUKOU = new C_IdousyoriKbn("206");

    public static final C_IdousyoriKbn HUKKATU = new C_IdousyoriKbn("301");

    public static final C_IdousyoriKbn KAIYAKU = new C_IdousyoriKbn("401");

    public static final C_IdousyoriKbn KYKTORIKESI = new C_IdousyoriKbn("402");

    public static final C_IdousyoriKbn CLGOFF = new C_IdousyoriKbn("403");

    public static final C_IdousyoriKbn KAIJO = new C_IdousyoriKbn("404");

    public static final C_IdousyoriKbn MUKOU = new C_IdousyoriKbn("405");

    public static final C_IdousyoriKbn SIBOU = new C_IdousyoriKbn("406");

    public static final C_IdousyoriKbn MENSEKI = new C_IdousyoriKbn("407");

    public static final C_IdousyoriKbn SIKKOU = new C_IdousyoriKbn("408");

    public static final C_IdousyoriKbn SBKAIJO = new C_IdousyoriKbn("409");

    public static final C_IdousyoriKbn MUKOU_1PMINYUUKIN = new C_IdousyoriKbn("410");

    public static final C_IdousyoriKbn PMEN = new C_IdousyoriKbn("501");

    public static final C_IdousyoriKbn HARAIMAN = new C_IdousyoriKbn("502");

    public static final C_IdousyoriKbn MEIGIHNK = new C_IdousyoriKbn("601");

    public static final C_IdousyoriKbn ADRHNK = new C_IdousyoriKbn("602");

    public static final C_IdousyoriKbn KOUZASEIBI = new C_IdousyoriKbn("603");

    public static final C_IdousyoriKbn GANSINDAN = new C_IdousyoriKbn("604");

    public static final C_IdousyoriKbn SYOSAIHK = new C_IdousyoriKbn("701");

    public static final C_IdousyoriKbn KOUJYOSYOUMEI = new C_IdousyoriKbn("702");

    public static final C_IdousyoriKbn MISYUUPINFOTORIKOMI = new C_IdousyoriKbn("801");

    public static final C_IdousyoriKbn ONLINENYKN = new C_IdousyoriKbn("802");

    public static final C_IdousyoriKbn NYUUKINTORIKESI = new C_IdousyoriKbn("803");

    public static final C_IdousyoriKbn KRUKTEISEI = new C_IdousyoriKbn("804");

    public static final C_IdousyoriKbn DATTAI = new C_IdousyoriKbn("805");

    public static final C_IdousyoriKbn ONLINEDATTAI = new C_IdousyoriKbn("806");

    public static final C_IdousyoriKbn DATTAITRKS = new C_IdousyoriKbn("807");

    public static final C_IdousyoriKbn IKKATUNYUUKINTYUUSI = new C_IdousyoriKbn("808");

    public static final C_IdousyoriKbn TTDKTYUUI = new C_IdousyoriKbn("901");

    public static final C_IdousyoriKbn HUKKATUENKI = new C_IdousyoriKbn("902");

    public static final C_IdousyoriKbn HUKKATUMIAWASE = new C_IdousyoriKbn("903");

    public static final C_IdousyoriKbn YUYOKKNTOKUSIN = new C_IdousyoriKbn("904");

    public static final C_IdousyoriKbn HUTANPOARIKEIZOKU = new C_IdousyoriKbn("905");

    public static final C_IdousyoriKbn HRIHN_TORIKESIZUMI = new C_IdousyoriKbn("S01");

    public static final C_IdousyoriKbn HRIKAIHENTORIKESI_SESAGYOU = new C_IdousyoriKbn("S02");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SINKEI, "SINKEI", false);
        addPattern(PATTERN_DEFAULT, SEINENGAPPISEI, "SEINENGAPPISEI", false);
        addPattern(PATTERN_DEFAULT, KEIYAKUHENKOU, "KEIYAKUHENKOU", false);
        addPattern(PATTERN_DEFAULT, HRIHN, "HRIHN", false);
        addPattern(PATTERN_DEFAULT, TSNGNDTYOUKA, "TSNGNDTYOUKA", false);
        addPattern(PATTERN_DEFAULT, GANMUKOU, "GANMUKOU", false);
        addPattern(PATTERN_DEFAULT, MOUSIDEMUKOU, "MOUSIDEMUKOU", false);
        addPattern(PATTERN_DEFAULT, HUKKATU, "HUKKATU", false);
        addPattern(PATTERN_DEFAULT, KAIYAKU, "KAIYAKU", false);
        addPattern(PATTERN_DEFAULT, KYKTORIKESI, "KYKTORIKESI", false);
        addPattern(PATTERN_DEFAULT, CLGOFF, "CLGOFF", false);
        addPattern(PATTERN_DEFAULT, KAIJO, "KAIJO", false);
        addPattern(PATTERN_DEFAULT, MUKOU, "MUKOU", false);
        addPattern(PATTERN_DEFAULT, SIBOU, "SIBOU", false);
        addPattern(PATTERN_DEFAULT, MENSEKI, "MENSEKI", false);
        addPattern(PATTERN_DEFAULT, SIKKOU, "SIKKOU", false);
        addPattern(PATTERN_DEFAULT, SBKAIJO, "SBKAIJO", false);
        addPattern(PATTERN_DEFAULT, MUKOU_1PMINYUUKIN, "MUKOU_1PMINYUUKIN", false);
        addPattern(PATTERN_DEFAULT, PMEN, "PMEN", false);
        addPattern(PATTERN_DEFAULT, HARAIMAN, "HARAIMAN", false);
        addPattern(PATTERN_DEFAULT, MEIGIHNK, "MEIGIHNK", false);
        addPattern(PATTERN_DEFAULT, ADRHNK, "ADRHNK", false);
        addPattern(PATTERN_DEFAULT, KOUZASEIBI, "KOUZASEIBI", false);
        addPattern(PATTERN_DEFAULT, GANSINDAN, "GANSINDAN", false);
        addPattern(PATTERN_DEFAULT, SYOSAIHK, "SYOSAIHK", false);
        addPattern(PATTERN_DEFAULT, KOUJYOSYOUMEI, "KOUJYOSYOUMEI", false);
        addPattern(PATTERN_DEFAULT, MISYUUPINFOTORIKOMI, "MISYUUPINFOTORIKOMI", false);
        addPattern(PATTERN_DEFAULT, ONLINENYKN, "ONLINENYKN", false);
        addPattern(PATTERN_DEFAULT, NYUUKINTORIKESI, "NYUUKINTORIKESI", false);
        addPattern(PATTERN_DEFAULT, KRUKTEISEI, "KRUKTEISEI", false);
        addPattern(PATTERN_DEFAULT, DATTAI, "DATTAI", false);
        addPattern(PATTERN_DEFAULT, ONLINEDATTAI, "ONLINEDATTAI", false);
        addPattern(PATTERN_DEFAULT, DATTAITRKS, "DATTAITRKS", false);
        addPattern(PATTERN_DEFAULT, IKKATUNYUUKINTYUUSI, "IKKATUNYUUKINTYUUSI", false);
        addPattern(PATTERN_DEFAULT, TTDKTYUUI, "TTDKTYUUI", false);
        addPattern(PATTERN_DEFAULT, HUKKATUENKI, "HUKKATUENKI", false);
        addPattern(PATTERN_DEFAULT, HUKKATUMIAWASE, "HUKKATUMIAWASE", false);
        addPattern(PATTERN_DEFAULT, YUYOKKNTOKUSIN, "YUYOKKNTOKUSIN", false);
        addPattern(PATTERN_DEFAULT, HUTANPOARIKEIZOKU, "HUTANPOARIKEIZOKU", false);
        addPattern(PATTERN_DEFAULT, HRIHN_TORIKESIZUMI, "HRIHN_TORIKESIZUMI", false);
        addPattern(PATTERN_DEFAULT, HRIKAIHENTORIKESI_SESAGYOU, "HRIKAIHENTORIKESI_SESAGYOU", false);


        lock(C_IdousyoriKbn.class);
    }

    private C_IdousyoriKbn(String value) {
        super(value);
    }

    public static C_IdousyoriKbn valueOf(String value) {
        return valueOf(C_IdousyoriKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_IdousyoriKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_IdousyoriKbn.class, patternId, value);
    }
}
