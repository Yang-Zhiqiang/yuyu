
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 担当室コード クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Tantositucd</td><td colspan="3">担当室コード</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="62">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK0}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DIRECTSVKIKAKU}</td><td>&quot;415&quot;</td><td>ダイレクトサービス企画室</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GYOUMUSINSA}</td><td>&quot;460&quot;</td><td>コンプライアンス調査室</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOZENSIHARAISV}</td><td>&quot;516&quot;</td><td>保全支払サービス室</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIKINKOUBAIKANRI}</td><td>&quot;521&quot;</td><td>資金購買総務室（資金Ｇ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUKEI}</td><td>&quot;526&quot;</td><td>主計室</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUURI}</td><td>&quot;527&quot;</td><td>数理室</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIYAKUKANRI}</td><td>&quot;543&quot;</td><td>契約審査室</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUUNOUSV}</td><td>&quot;551&quot;</td><td>個別収納サービス室</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOKENKIN}</td><td>&quot;558&quot;</td><td>保険金室</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIHARAIGYOUMU}</td><td>&quot;564&quot;</td><td>支払業務室</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAIRITENKEIYAKU}</td><td>&quot;565&quot;</td><td>代理店契約室</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IMUSATEI}</td><td>&quot;580&quot;</td><td>医務査定室</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIHARAIKIKAKU}</td><td>&quot;587&quot;</td><td>支払企画室</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAIRITENJIMUSV}</td><td>&quot;590&quot;</td><td>代理店事務サービス室</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUMISEICALLCENTER}</td><td>&quot;662&quot;</td><td>スミセイコールセンター</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CARDHAKKOUCENTER}</td><td>&quot;709&quot;</td><td>スミセイカードサービス（株）のカード発行センター</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOZENHENKOUSV}</td><td>&quot;727&quot;</td><td>保全変更サービス室</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIYAKUKIKAKU}</td><td>&quot;750&quot;</td><td>契約企画室</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUUNOUHOZEN}</td><td>&quot;772&quot;</td><td>収納保全企画室</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAIRITENJIGYOUBU}</td><td>&quot;300&quot;</td><td>代理店事業部</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAIRITENGYOUMUSUPPORT}</td><td>&quot;308&quot;</td><td>代理店業務サポート室</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UNYOUKIKAKUBU}</td><td>&quot;337&quot;</td><td>運用企画部</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UNYOUSENRYAKU}</td><td>&quot;338&quot;</td><td>運用戦略室</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIMUSVKIKAKUBU}</td><td>&quot;345&quot;</td><td>事務サービス企画部</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KINYUUSIJYOUSUISIN}</td><td>&quot;346&quot;</td><td>金融市場推進室</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIMUSVKIKAKU}</td><td>&quot;347&quot;</td><td>事務サービス企画室</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAIRITENJIGYOUKANRIBU}</td><td>&quot;390&quot;</td><td>代理店事業管理部</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #VITALITYANNAISV}</td><td>&quot;413&quot;</td><td>Ｖｉｔａｌｉｔｙ案内サービス室</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIKINSAIKENUNYOU}</td><td>&quot;421&quot;</td><td>資金債券運用室</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUUEKIINFO}</td><td>&quot;443&quot;</td><td>収益情報室</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUMISEIHARMONYOSAKA}</td><td>&quot;477&quot;</td><td>スミセイハーモニー（大阪人事所管）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAIRITENGYOUMUSKILLKAIHATU}</td><td>&quot;483&quot;</td><td>代理店業務スキル開発室</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAPPOROCALLCENTER}</td><td>&quot;498&quot;</td><td>札幌コールセンター</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OSAKAJINJI}</td><td>&quot;501&quot;</td><td>大阪人事室</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOKENKINBU}</td><td>&quot;508&quot;</td><td>保険金部</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SOUMUBU}</td><td>&quot;510&quot;</td><td>総務部</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YAKUIN}</td><td>&quot;511&quot;</td><td>役員</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIKINKOUBAISOUMU}</td><td>&quot;514&quot;</td><td>資金購買総務室</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUKEIBU}</td><td>&quot;525&quot;</td><td>主計部　　</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIHARAIKANRI}</td><td>&quot;539&quot;</td><td>支払管理室</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIYAKUSINSABU}</td><td>&quot;540&quot;</td><td>契約審査部</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CALLCENTERKANRI}</td><td>&quot;550&quot;</td><td>コールセンター管理室</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAIRITENEIGYOUBU}</td><td>&quot;559&quot;</td><td>代理店営業部</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CUSTOMERANNAISV}</td><td>&quot;566&quot;</td><td>お客さま案内サービス室</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAIRITENSIJYOUSENRYAKU}</td><td>&quot;568&quot;</td><td>代理店開発室</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KINYUUSIJYOUKAIHATU}</td><td>&quot;574&quot;</td><td>金融市場開発室</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JYOUHOUSYSTEMBU}</td><td>&quot;600&quot;</td><td>情報システム部</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAIRITENKIKAKU}</td><td>&quot;664&quot;</td><td>代理店企画室</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAIRITENGYOUSEKI}</td><td>&quot;687&quot;</td><td>代理店業績室</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYSTEMGYOUMU}</td><td>&quot;707&quot;</td><td>システム業務室</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIKKOUYAKUIN}</td><td>&quot;714&quot;</td><td>執行役員</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAIRITENCUSTOMERSUPPORT}</td><td>&quot;717&quot;</td><td>代理店お客さまサポート室</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAIRITENJIMUSVKIKAKU}</td><td>&quot;719&quot;</td><td>代理店事務サービス企画室</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAIRITENANNAISV}</td><td>&quot;732&quot;</td><td>代理店案内サービス室</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CUSTOMERSVBU}</td><td>&quot;735&quot;</td><td>お客さまサービス部</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIYAKUSVBU}</td><td>&quot;765&quot;</td><td>契約サービス部</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAIRITENGYOUMUKANRI}</td><td>&quot;794&quot;</td><td>代理店業務管理室</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DAIRITENSENRYAKU}</td><td>&quot;507&quot;</td><td>代理店戦略室</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #COMPLIANCESUISIN}</td><td>&quot;429&quot;</td><td>コンプライアンス推進室</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #COMPLIANCETOUKATU}</td><td>&quot;611&quot;</td><td>コンプライアンス統括部</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DANTAISYUUNOUSV}</td><td>&quot;602&quot;</td><td>団体収納サービス室</td></tr>
 * </table>
 */
public class C_Tantositucd extends Classification<C_Tantositucd> {

    private static final long serialVersionUID = 1L;


    public static final C_Tantositucd BLNK0 = new C_Tantositucd("0");

    public static final C_Tantositucd DIRECTSVKIKAKU = new C_Tantositucd("415");

    public static final C_Tantositucd GYOUMUSINSA = new C_Tantositucd("460");

    public static final C_Tantositucd HOZENSIHARAISV = new C_Tantositucd("516");

    public static final C_Tantositucd SIKINKOUBAIKANRI = new C_Tantositucd("521");

    public static final C_Tantositucd SYUKEI = new C_Tantositucd("526");

    public static final C_Tantositucd SUURI = new C_Tantositucd("527");

    public static final C_Tantositucd KEIYAKUKANRI = new C_Tantositucd("543");

    public static final C_Tantositucd SYUUNOUSV = new C_Tantositucd("551");

    public static final C_Tantositucd HOKENKIN = new C_Tantositucd("558");

    public static final C_Tantositucd SIHARAIGYOUMU = new C_Tantositucd("564");

    public static final C_Tantositucd DAIRITENKEIYAKU = new C_Tantositucd("565");

    public static final C_Tantositucd IMUSATEI = new C_Tantositucd("580");

    public static final C_Tantositucd SIHARAIKIKAKU = new C_Tantositucd("587");

    public static final C_Tantositucd DAIRITENJIMUSV = new C_Tantositucd("590");

    public static final C_Tantositucd SUMISEICALLCENTER = new C_Tantositucd("662");

    public static final C_Tantositucd CARDHAKKOUCENTER = new C_Tantositucd("709");

    public static final C_Tantositucd HOZENHENKOUSV = new C_Tantositucd("727");

    public static final C_Tantositucd KEIYAKUKIKAKU = new C_Tantositucd("750");

    public static final C_Tantositucd SYUUNOUHOZEN = new C_Tantositucd("772");

    public static final C_Tantositucd DAIRITENJIGYOUBU = new C_Tantositucd("300");

    public static final C_Tantositucd DAIRITENGYOUMUSUPPORT = new C_Tantositucd("308");

    public static final C_Tantositucd UNYOUKIKAKUBU = new C_Tantositucd("337");

    public static final C_Tantositucd UNYOUSENRYAKU = new C_Tantositucd("338");

    public static final C_Tantositucd JIMUSVKIKAKUBU = new C_Tantositucd("345");

    public static final C_Tantositucd KINYUUSIJYOUSUISIN = new C_Tantositucd("346");

    public static final C_Tantositucd JIMUSVKIKAKU = new C_Tantositucd("347");

    public static final C_Tantositucd DAIRITENJIGYOUKANRIBU = new C_Tantositucd("390");

    public static final C_Tantositucd VITALITYANNAISV = new C_Tantositucd("413");

    public static final C_Tantositucd SIKINSAIKENUNYOU = new C_Tantositucd("421");

    public static final C_Tantositucd SYUUEKIINFO = new C_Tantositucd("443");

    public static final C_Tantositucd SUMISEIHARMONYOSAKA = new C_Tantositucd("477");

    public static final C_Tantositucd DAIRITENGYOUMUSKILLKAIHATU = new C_Tantositucd("483");

    public static final C_Tantositucd SAPPOROCALLCENTER = new C_Tantositucd("498");

    public static final C_Tantositucd OSAKAJINJI = new C_Tantositucd("501");

    public static final C_Tantositucd HOKENKINBU = new C_Tantositucd("508");

    public static final C_Tantositucd SOUMUBU = new C_Tantositucd("510");

    public static final C_Tantositucd YAKUIN = new C_Tantositucd("511");

    public static final C_Tantositucd SIKINKOUBAISOUMU = new C_Tantositucd("514");

    public static final C_Tantositucd SYUKEIBU = new C_Tantositucd("525");

    public static final C_Tantositucd SIHARAIKANRI = new C_Tantositucd("539");

    public static final C_Tantositucd KEIYAKUSINSABU = new C_Tantositucd("540");

    public static final C_Tantositucd CALLCENTERKANRI = new C_Tantositucd("550");

    public static final C_Tantositucd DAIRITENEIGYOUBU = new C_Tantositucd("559");

    public static final C_Tantositucd CUSTOMERANNAISV = new C_Tantositucd("566");

    public static final C_Tantositucd DAIRITENSIJYOUSENRYAKU = new C_Tantositucd("568");

    public static final C_Tantositucd KINYUUSIJYOUKAIHATU = new C_Tantositucd("574");

    public static final C_Tantositucd JYOUHOUSYSTEMBU = new C_Tantositucd("600");

    public static final C_Tantositucd DAIRITENKIKAKU = new C_Tantositucd("664");

    public static final C_Tantositucd DAIRITENGYOUSEKI = new C_Tantositucd("687");

    public static final C_Tantositucd SYSTEMGYOUMU = new C_Tantositucd("707");

    public static final C_Tantositucd SIKKOUYAKUIN = new C_Tantositucd("714");

    public static final C_Tantositucd DAIRITENCUSTOMERSUPPORT = new C_Tantositucd("717");

    public static final C_Tantositucd DAIRITENJIMUSVKIKAKU = new C_Tantositucd("719");

    public static final C_Tantositucd DAIRITENANNAISV = new C_Tantositucd("732");

    public static final C_Tantositucd CUSTOMERSVBU = new C_Tantositucd("735");

    public static final C_Tantositucd KEIYAKUSVBU = new C_Tantositucd("765");

    public static final C_Tantositucd DAIRITENGYOUMUKANRI = new C_Tantositucd("794");

    public static final C_Tantositucd DAIRITENSENRYAKU = new C_Tantositucd("507");

    public static final C_Tantositucd COMPLIANCESUISIN = new C_Tantositucd("429");

    public static final C_Tantositucd COMPLIANCETOUKATU = new C_Tantositucd("611");

    public static final C_Tantositucd DANTAISYUUNOUSV = new C_Tantositucd("602");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK0, "BLNK0", true);
        addPattern(PATTERN_DEFAULT, DIRECTSVKIKAKU, "DIRECTSVKIKAKU", false);
        addPattern(PATTERN_DEFAULT, GYOUMUSINSA, "GYOUMUSINSA", false);
        addPattern(PATTERN_DEFAULT, HOZENSIHARAISV, "HOZENSIHARAISV", false);
        addPattern(PATTERN_DEFAULT, SIKINKOUBAIKANRI, "SIKINKOUBAIKANRI", false);
        addPattern(PATTERN_DEFAULT, SYUKEI, "SYUKEI", false);
        addPattern(PATTERN_DEFAULT, SUURI, "SUURI", false);
        addPattern(PATTERN_DEFAULT, KEIYAKUKANRI, "KEIYAKUKANRI", false);
        addPattern(PATTERN_DEFAULT, SYUUNOUSV, "SYUUNOUSV", false);
        addPattern(PATTERN_DEFAULT, HOKENKIN, "HOKENKIN", false);
        addPattern(PATTERN_DEFAULT, SIHARAIGYOUMU, "SIHARAIGYOUMU", false);
        addPattern(PATTERN_DEFAULT, DAIRITENKEIYAKU, "DAIRITENKEIYAKU", false);
        addPattern(PATTERN_DEFAULT, IMUSATEI, "IMUSATEI", false);
        addPattern(PATTERN_DEFAULT, SIHARAIKIKAKU, "SIHARAIKIKAKU", false);
        addPattern(PATTERN_DEFAULT, DAIRITENJIMUSV, "DAIRITENJIMUSV", false);
        addPattern(PATTERN_DEFAULT, SUMISEICALLCENTER, "SUMISEICALLCENTER", false);
        addPattern(PATTERN_DEFAULT, CARDHAKKOUCENTER, "CARDHAKKOUCENTER", false);
        addPattern(PATTERN_DEFAULT, HOZENHENKOUSV, "HOZENHENKOUSV", false);
        addPattern(PATTERN_DEFAULT, KEIYAKUKIKAKU, "KEIYAKUKIKAKU", false);
        addPattern(PATTERN_DEFAULT, SYUUNOUHOZEN, "SYUUNOUHOZEN", false);
        addPattern(PATTERN_DEFAULT, DAIRITENJIGYOUBU, "DAIRITENJIGYOUBU", false);
        addPattern(PATTERN_DEFAULT, DAIRITENGYOUMUSUPPORT, "DAIRITENGYOUMUSUPPORT", false);
        addPattern(PATTERN_DEFAULT, UNYOUKIKAKUBU, "UNYOUKIKAKUBU", false);
        addPattern(PATTERN_DEFAULT, UNYOUSENRYAKU, "UNYOUSENRYAKU", false);
        addPattern(PATTERN_DEFAULT, JIMUSVKIKAKUBU, "JIMUSVKIKAKUBU", false);
        addPattern(PATTERN_DEFAULT, KINYUUSIJYOUSUISIN, "KINYUUSIJYOUSUISIN", false);
        addPattern(PATTERN_DEFAULT, JIMUSVKIKAKU, "JIMUSVKIKAKU", false);
        addPattern(PATTERN_DEFAULT, DAIRITENJIGYOUKANRIBU, "DAIRITENJIGYOUKANRIBU", false);
        addPattern(PATTERN_DEFAULT, VITALITYANNAISV, "VITALITYANNAISV", false);
        addPattern(PATTERN_DEFAULT, SIKINSAIKENUNYOU, "SIKINSAIKENUNYOU", false);
        addPattern(PATTERN_DEFAULT, SYUUEKIINFO, "SYUUEKIINFO", false);
        addPattern(PATTERN_DEFAULT, SUMISEIHARMONYOSAKA, "SUMISEIHARMONYOSAKA", false);
        addPattern(PATTERN_DEFAULT, DAIRITENGYOUMUSKILLKAIHATU, "DAIRITENGYOUMUSKILLKAIHATU", false);
        addPattern(PATTERN_DEFAULT, SAPPOROCALLCENTER, "SAPPOROCALLCENTER", false);
        addPattern(PATTERN_DEFAULT, OSAKAJINJI, "OSAKAJINJI", false);
        addPattern(PATTERN_DEFAULT, HOKENKINBU, "HOKENKINBU", false);
        addPattern(PATTERN_DEFAULT, SOUMUBU, "SOUMUBU", false);
        addPattern(PATTERN_DEFAULT, YAKUIN, "YAKUIN", false);
        addPattern(PATTERN_DEFAULT, SIKINKOUBAISOUMU, "SIKINKOUBAISOUMU", false);
        addPattern(PATTERN_DEFAULT, SYUKEIBU, "SYUKEIBU", false);
        addPattern(PATTERN_DEFAULT, SIHARAIKANRI, "SIHARAIKANRI", false);
        addPattern(PATTERN_DEFAULT, KEIYAKUSINSABU, "KEIYAKUSINSABU", false);
        addPattern(PATTERN_DEFAULT, CALLCENTERKANRI, "CALLCENTERKANRI", false);
        addPattern(PATTERN_DEFAULT, DAIRITENEIGYOUBU, "DAIRITENEIGYOUBU", false);
        addPattern(PATTERN_DEFAULT, CUSTOMERANNAISV, "CUSTOMERANNAISV", false);
        addPattern(PATTERN_DEFAULT, DAIRITENSIJYOUSENRYAKU, "DAIRITENSIJYOUSENRYAKU", false);
        addPattern(PATTERN_DEFAULT, KINYUUSIJYOUKAIHATU, "KINYUUSIJYOUKAIHATU", false);
        addPattern(PATTERN_DEFAULT, JYOUHOUSYSTEMBU, "JYOUHOUSYSTEMBU", false);
        addPattern(PATTERN_DEFAULT, DAIRITENKIKAKU, "DAIRITENKIKAKU", false);
        addPattern(PATTERN_DEFAULT, DAIRITENGYOUSEKI, "DAIRITENGYOUSEKI", false);
        addPattern(PATTERN_DEFAULT, SYSTEMGYOUMU, "SYSTEMGYOUMU", false);
        addPattern(PATTERN_DEFAULT, SIKKOUYAKUIN, "SIKKOUYAKUIN", false);
        addPattern(PATTERN_DEFAULT, DAIRITENCUSTOMERSUPPORT, "DAIRITENCUSTOMERSUPPORT", false);
        addPattern(PATTERN_DEFAULT, DAIRITENJIMUSVKIKAKU, "DAIRITENJIMUSVKIKAKU", false);
        addPattern(PATTERN_DEFAULT, DAIRITENANNAISV, "DAIRITENANNAISV", false);
        addPattern(PATTERN_DEFAULT, CUSTOMERSVBU, "CUSTOMERSVBU", false);
        addPattern(PATTERN_DEFAULT, KEIYAKUSVBU, "KEIYAKUSVBU", false);
        addPattern(PATTERN_DEFAULT, DAIRITENGYOUMUKANRI, "DAIRITENGYOUMUKANRI", false);
        addPattern(PATTERN_DEFAULT, DAIRITENSENRYAKU, "DAIRITENSENRYAKU", false);
        addPattern(PATTERN_DEFAULT, COMPLIANCESUISIN, "COMPLIANCESUISIN", false);
        addPattern(PATTERN_DEFAULT, COMPLIANCETOUKATU, "COMPLIANCETOUKATU", false);
        addPattern(PATTERN_DEFAULT, DANTAISYUUNOUSV, "DANTAISYUUNOUSV", false);


        lock(C_Tantositucd.class);
    }

    private C_Tantositucd(String value) {
        super(value);
    }

    public static C_Tantositucd valueOf(String value) {
        return valueOf(C_Tantositucd.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Tantositucd.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Tantositucd.class, patternId, value);
    }
}
