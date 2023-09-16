
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 異動内容コード クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Idounaiyocd</td><td colspan="3">異動内容コード</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="37">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NENSI}</td><td>&quot;a&quot;</td><td>年始</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINKEI}</td><td>&quot;b&quot;</td><td>新契約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOS}</td><td>&quot;c&quot;</td><td>更新</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUKKATU}</td><td>&quot;d&quot;</td><td>復活</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HGAKUZOU}</td><td>&quot;e&quot;</td><td>保険金額の増加</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENKANZOU}</td><td>&quot;f&quot;</td><td>転換による増加</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTAZOU}</td><td>&quot;g&quot;</td><td>その他の増加</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOU}</td><td>&quot;h&quot;</td><td>死亡</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MANKI}</td><td>&quot;i&quot;</td><td>満期</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HGAKUGEN}</td><td>&quot;j&quot;</td><td>保険金額の減少</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENKANGEN}</td><td>&quot;k&quot;</td><td>転換による減少</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKU}</td><td>&quot;l&quot;</td><td>解約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIKKOU}</td><td>&quot;m&quot;</td><td>失効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTAGEN}</td><td>&quot;n&quot;</td><td>その他の減少</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GETUMATU}</td><td>&quot;o&quot;</td><td>月末（年末）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JYUNZOUKA}</td><td>&quot;p&quot;</td><td>純増加</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UTIWAKE_SONOTAZOU}</td><td>&quot;g1&quot;</td><td>（内訳）その他増</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UTIWAKE_SIBOUS_SIZENZOUP}</td><td>&quot;g2&quot;</td><td>（内訳）死亡Ｓ自然増(＋)</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UTIWAKE_SIBOUS_SIZENZOUM}</td><td>&quot;g3&quot;</td><td>（内訳）死亡Ｓ自然増(－)</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UTIWAKE_SIBOU}</td><td>&quot;h1&quot;</td><td>（内訳）死亡</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UTIWAKE_KOUDOSYOUGAI}</td><td>&quot;h2&quot;</td><td>（内訳）高度障害</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UTIWAKE_MENSEKI}</td><td>&quot;h3&quot;</td><td>（内訳）免責</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UTIWAKE_KAIYAKU}</td><td>&quot;l1&quot;</td><td>（内訳）解約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UTIWAKE_KAIJYO}</td><td>&quot;l2&quot;</td><td>（内訳）解除</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UTIWAKE_SONOTAGEN}</td><td>&quot;n1&quot;</td><td>（内訳）その他減</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UTIWAKE_PMENGEN}</td><td>&quot;n2&quot;</td><td>（内訳）Ｐ免による減少</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UTIWAKE_PMENZOU}</td><td>&quot;n3&quot;</td><td>（内訳）Ｐ免による増加</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UTIWAKE_3DAISIPPMENGEN}</td><td>&quot;n4&quot;</td><td>（内訳）３大疾病Ｐ免減</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UTIWAKE_3DAISIPPMENZOU}</td><td>&quot;n5&quot;</td><td>（内訳）３大疾病Ｐ免増</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UTIWAKE_3DAISIP}</td><td>&quot;n6&quot;</td><td>（内訳）３大疾病</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UTIWAKE_FSTPMINYUU}</td><td>&quot;n7&quot;</td><td>（内訳）初回Ｐ未入無効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UTIWAKE_OTHER}</td><td>&quot;n8&quot;</td><td>（内訳）上記以外</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UTIWAKE_HARAIKOMI}</td><td>&quot;o1&quot;</td><td>（内訳）払込中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UTIWAKE_PMEN}</td><td>&quot;o2&quot;</td><td>（内訳）Ｐ免</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UTIWAKE_HARAIMANGO}</td><td>&quot;o3&quot;</td><td>（内訳）払満後</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UTIWAKE_ITIJIBARAI}</td><td>&quot;o4&quot;</td><td>（内訳）一時払い</td></tr>
 *  <tr><td rowspan="36">{@link #PATTERN_HYOUJI HYOUJI}<br />(（事業成績）異動内容名表示用)</td><td align="center">&nbsp;</td><td>{@link #NENSI}</td><td>&quot;a&quot;</td><td>年始</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINKEI}</td><td>&quot;b&quot;</td><td>新契約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOS}</td><td>&quot;c&quot;</td><td>更新</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUKKATU}</td><td>&quot;d&quot;</td><td>復活</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HGAKUZOU}</td><td>&quot;e&quot;</td><td>保険金額の増加</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENKANZOU}</td><td>&quot;f&quot;</td><td>転換による増加</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTAZOU}</td><td>&quot;g&quot;</td><td>その他の増加</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOU}</td><td>&quot;h&quot;</td><td>死亡</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MANKI}</td><td>&quot;i&quot;</td><td>満期</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HGAKUGEN}</td><td>&quot;j&quot;</td><td>保険金額の減少</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENKANGEN}</td><td>&quot;k&quot;</td><td>転換による減少</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKU}</td><td>&quot;l&quot;</td><td>解約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIKKOU}</td><td>&quot;m&quot;</td><td>失効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTAGEN}</td><td>&quot;n&quot;</td><td>その他の減少</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GETUMATU}</td><td>&quot;o&quot;</td><td>月末（年末）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JYUNZOUKA}</td><td>&quot;p&quot;</td><td>純増加</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UTIWAKE_SONOTAZOU}</td><td>&quot;g1&quot;</td><td>その他増</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UTIWAKE_SIBOUS_SIZENZOUP}</td><td>&quot;g2&quot;</td><td>死亡Ｓ自然増(＋)</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UTIWAKE_SIBOUS_SIZENZOUM}</td><td>&quot;g3&quot;</td><td>死亡Ｓ自然増(－)</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UTIWAKE_SIBOU}</td><td>&quot;h1&quot;</td><td>死亡</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UTIWAKE_KOUDOSYOUGAI}</td><td>&quot;h2&quot;</td><td>高度障害</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UTIWAKE_MENSEKI}</td><td>&quot;h3&quot;</td><td>免責</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UTIWAKE_KAIYAKU}</td><td>&quot;l1&quot;</td><td>解約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UTIWAKE_KAIJYO}</td><td>&quot;l2&quot;</td><td>解除</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UTIWAKE_SONOTAGEN}</td><td>&quot;n1&quot;</td><td>その他減</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UTIWAKE_PMENGEN}</td><td>&quot;n2&quot;</td><td>Ｐ免による減少</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UTIWAKE_PMENZOU}</td><td>&quot;n3&quot;</td><td>Ｐ免による増加</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UTIWAKE_3DAISIPPMENGEN}</td><td>&quot;n4&quot;</td><td>３大疾病Ｐ免減</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UTIWAKE_3DAISIPPMENZOU}</td><td>&quot;n5&quot;</td><td>３大疾病Ｐ免増</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UTIWAKE_3DAISIP}</td><td>&quot;n6&quot;</td><td>３大疾病</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UTIWAKE_FSTPMINYUU}</td><td>&quot;n7&quot;</td><td>初回Ｐ未入無効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UTIWAKE_OTHER}</td><td>&quot;n8&quot;</td><td>上記以外</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UTIWAKE_HARAIKOMI}</td><td>&quot;o1&quot;</td><td>払込中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UTIWAKE_PMEN}</td><td>&quot;o2&quot;</td><td>Ｐ免</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UTIWAKE_HARAIMANGO}</td><td>&quot;o3&quot;</td><td>払満後</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #UTIWAKE_ITIJIBARAI}</td><td>&quot;o4&quot;</td><td>一時払い</td></tr>
 * </table>
 */
public class C_Idounaiyocd extends Classification<C_Idounaiyocd> {

    private static final long serialVersionUID = 1L;


    public static final C_Idounaiyocd BLNK = new C_Idounaiyocd("0");

    public static final C_Idounaiyocd NENSI = new C_Idounaiyocd("a");

    public static final C_Idounaiyocd SINKEI = new C_Idounaiyocd("b");

    public static final C_Idounaiyocd KOS = new C_Idounaiyocd("c");

    public static final C_Idounaiyocd HUKKATU = new C_Idounaiyocd("d");

    public static final C_Idounaiyocd HGAKUZOU = new C_Idounaiyocd("e");

    public static final C_Idounaiyocd TENKANZOU = new C_Idounaiyocd("f");

    public static final C_Idounaiyocd SONOTAZOU = new C_Idounaiyocd("g");

    public static final C_Idounaiyocd SIBOU = new C_Idounaiyocd("h");

    public static final C_Idounaiyocd MANKI = new C_Idounaiyocd("i");

    public static final C_Idounaiyocd HGAKUGEN = new C_Idounaiyocd("j");

    public static final C_Idounaiyocd TENKANGEN = new C_Idounaiyocd("k");

    public static final C_Idounaiyocd KAIYAKU = new C_Idounaiyocd("l");

    public static final C_Idounaiyocd SIKKOU = new C_Idounaiyocd("m");

    public static final C_Idounaiyocd SONOTAGEN = new C_Idounaiyocd("n");

    public static final C_Idounaiyocd GETUMATU = new C_Idounaiyocd("o");

    public static final C_Idounaiyocd JYUNZOUKA = new C_Idounaiyocd("p");

    public static final C_Idounaiyocd UTIWAKE_SONOTAZOU = new C_Idounaiyocd("g1");

    public static final C_Idounaiyocd UTIWAKE_SIBOUS_SIZENZOUP = new C_Idounaiyocd("g2");

    public static final C_Idounaiyocd UTIWAKE_SIBOUS_SIZENZOUM = new C_Idounaiyocd("g3");

    public static final C_Idounaiyocd UTIWAKE_SIBOU = new C_Idounaiyocd("h1");

    public static final C_Idounaiyocd UTIWAKE_KOUDOSYOUGAI = new C_Idounaiyocd("h2");

    public static final C_Idounaiyocd UTIWAKE_MENSEKI = new C_Idounaiyocd("h3");

    public static final C_Idounaiyocd UTIWAKE_KAIYAKU = new C_Idounaiyocd("l1");

    public static final C_Idounaiyocd UTIWAKE_KAIJYO = new C_Idounaiyocd("l2");

    public static final C_Idounaiyocd UTIWAKE_SONOTAGEN = new C_Idounaiyocd("n1");

    public static final C_Idounaiyocd UTIWAKE_PMENGEN = new C_Idounaiyocd("n2");

    public static final C_Idounaiyocd UTIWAKE_PMENZOU = new C_Idounaiyocd("n3");

    public static final C_Idounaiyocd UTIWAKE_3DAISIPPMENGEN = new C_Idounaiyocd("n4");

    public static final C_Idounaiyocd UTIWAKE_3DAISIPPMENZOU = new C_Idounaiyocd("n5");

    public static final C_Idounaiyocd UTIWAKE_3DAISIP = new C_Idounaiyocd("n6");

    public static final C_Idounaiyocd UTIWAKE_FSTPMINYUU = new C_Idounaiyocd("n7");

    public static final C_Idounaiyocd UTIWAKE_OTHER = new C_Idounaiyocd("n8");

    public static final C_Idounaiyocd UTIWAKE_HARAIKOMI = new C_Idounaiyocd("o1");

    public static final C_Idounaiyocd UTIWAKE_PMEN = new C_Idounaiyocd("o2");

    public static final C_Idounaiyocd UTIWAKE_HARAIMANGO = new C_Idounaiyocd("o3");

    public static final C_Idounaiyocd UTIWAKE_ITIJIBARAI = new C_Idounaiyocd("o4");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_HYOUJI = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, NENSI, "NENSI", false);
        addPattern(PATTERN_DEFAULT, SINKEI, "SINKEI", false);
        addPattern(PATTERN_DEFAULT, KOS, "KOS", false);
        addPattern(PATTERN_DEFAULT, HUKKATU, "HUKKATU", false);
        addPattern(PATTERN_DEFAULT, HGAKUZOU, "HGAKUZOU", false);
        addPattern(PATTERN_DEFAULT, TENKANZOU, "TENKANZOU", false);
        addPattern(PATTERN_DEFAULT, SONOTAZOU, "SONOTAZOU", false);
        addPattern(PATTERN_DEFAULT, SIBOU, "SIBOU", false);
        addPattern(PATTERN_DEFAULT, MANKI, "MANKI", false);
        addPattern(PATTERN_DEFAULT, HGAKUGEN, "HGAKUGEN", false);
        addPattern(PATTERN_DEFAULT, TENKANGEN, "TENKANGEN", false);
        addPattern(PATTERN_DEFAULT, KAIYAKU, "KAIYAKU", false);
        addPattern(PATTERN_DEFAULT, SIKKOU, "SIKKOU", false);
        addPattern(PATTERN_DEFAULT, SONOTAGEN, "SONOTAGEN", false);
        addPattern(PATTERN_DEFAULT, GETUMATU, "GETUMATU", false);
        addPattern(PATTERN_DEFAULT, JYUNZOUKA, "JYUNZOUKA", false);
        addPattern(PATTERN_DEFAULT, UTIWAKE_SONOTAZOU, "UTIWAKE_SONOTAZOU", false);
        addPattern(PATTERN_DEFAULT, UTIWAKE_SIBOUS_SIZENZOUP, "UTIWAKE_SIBOUS_SIZENZOUP", false);
        addPattern(PATTERN_DEFAULT, UTIWAKE_SIBOUS_SIZENZOUM, "UTIWAKE_SIBOUS_SIZENZOUM", false);
        addPattern(PATTERN_DEFAULT, UTIWAKE_SIBOU, "UTIWAKE_SIBOU", false);
        addPattern(PATTERN_DEFAULT, UTIWAKE_KOUDOSYOUGAI, "UTIWAKE_KOUDOSYOUGAI", false);
        addPattern(PATTERN_DEFAULT, UTIWAKE_MENSEKI, "UTIWAKE_MENSEKI", false);
        addPattern(PATTERN_DEFAULT, UTIWAKE_KAIYAKU, "UTIWAKE_KAIYAKU", false);
        addPattern(PATTERN_DEFAULT, UTIWAKE_KAIJYO, "UTIWAKE_KAIJYO", false);
        addPattern(PATTERN_DEFAULT, UTIWAKE_SONOTAGEN, "UTIWAKE_SONOTAGEN", false);
        addPattern(PATTERN_DEFAULT, UTIWAKE_PMENGEN, "UTIWAKE_PMENGEN", false);
        addPattern(PATTERN_DEFAULT, UTIWAKE_PMENZOU, "UTIWAKE_PMENZOU", false);
        addPattern(PATTERN_DEFAULT, UTIWAKE_3DAISIPPMENGEN, "UTIWAKE_3DAISIPPMENGEN", false);
        addPattern(PATTERN_DEFAULT, UTIWAKE_3DAISIPPMENZOU, "UTIWAKE_3DAISIPPMENZOU", false);
        addPattern(PATTERN_DEFAULT, UTIWAKE_3DAISIP, "UTIWAKE_3DAISIP", false);
        addPattern(PATTERN_DEFAULT, UTIWAKE_FSTPMINYUU, "UTIWAKE_FSTPMINYUU", false);
        addPattern(PATTERN_DEFAULT, UTIWAKE_OTHER, "UTIWAKE_OTHER", false);
        addPattern(PATTERN_DEFAULT, UTIWAKE_HARAIKOMI, "UTIWAKE_HARAIKOMI", false);
        addPattern(PATTERN_DEFAULT, UTIWAKE_PMEN, "UTIWAKE_PMEN", false);
        addPattern(PATTERN_DEFAULT, UTIWAKE_HARAIMANGO, "UTIWAKE_HARAIMANGO", false);
        addPattern(PATTERN_DEFAULT, UTIWAKE_ITIJIBARAI, "UTIWAKE_ITIJIBARAI", false);


        addPattern(PATTERN_HYOUJI, NENSI, "NENSI", false);
        addPattern(PATTERN_HYOUJI, SINKEI, "SINKEI", false);
        addPattern(PATTERN_HYOUJI, KOS, "KOS", false);
        addPattern(PATTERN_HYOUJI, HUKKATU, "HUKKATU", false);
        addPattern(PATTERN_HYOUJI, HGAKUZOU, "HGAKUZOU", false);
        addPattern(PATTERN_HYOUJI, TENKANZOU, "TENKANZOU", false);
        addPattern(PATTERN_HYOUJI, SONOTAZOU, "SONOTAZOU", false);
        addPattern(PATTERN_HYOUJI, SIBOU, "SIBOU", false);
        addPattern(PATTERN_HYOUJI, MANKI, "MANKI", false);
        addPattern(PATTERN_HYOUJI, HGAKUGEN, "HGAKUGEN", false);
        addPattern(PATTERN_HYOUJI, TENKANGEN, "TENKANGEN", false);
        addPattern(PATTERN_HYOUJI, KAIYAKU, "KAIYAKU", false);
        addPattern(PATTERN_HYOUJI, SIKKOU, "SIKKOU", false);
        addPattern(PATTERN_HYOUJI, SONOTAGEN, "SONOTAGEN", false);
        addPattern(PATTERN_HYOUJI, GETUMATU, "GETUMATU", false);
        addPattern(PATTERN_HYOUJI, JYUNZOUKA, "JYUNZOUKA", false);
        addPattern(PATTERN_HYOUJI, UTIWAKE_SONOTAZOU, "UTIWAKE_SONOTAZOU", false);
        addPattern(PATTERN_HYOUJI, UTIWAKE_SIBOUS_SIZENZOUP, "UTIWAKE_SIBOUS_SIZENZOUP", false);
        addPattern(PATTERN_HYOUJI, UTIWAKE_SIBOUS_SIZENZOUM, "UTIWAKE_SIBOUS_SIZENZOUM", false);
        addPattern(PATTERN_HYOUJI, UTIWAKE_SIBOU, "UTIWAKE_SIBOU", false);
        addPattern(PATTERN_HYOUJI, UTIWAKE_KOUDOSYOUGAI, "UTIWAKE_KOUDOSYOUGAI", false);
        addPattern(PATTERN_HYOUJI, UTIWAKE_MENSEKI, "UTIWAKE_MENSEKI", false);
        addPattern(PATTERN_HYOUJI, UTIWAKE_KAIYAKU, "UTIWAKE_KAIYAKU", false);
        addPattern(PATTERN_HYOUJI, UTIWAKE_KAIJYO, "UTIWAKE_KAIJYO", false);
        addPattern(PATTERN_HYOUJI, UTIWAKE_SONOTAGEN, "UTIWAKE_SONOTAGEN", false);
        addPattern(PATTERN_HYOUJI, UTIWAKE_PMENGEN, "UTIWAKE_PMENGEN", false);
        addPattern(PATTERN_HYOUJI, UTIWAKE_PMENZOU, "UTIWAKE_PMENZOU", false);
        addPattern(PATTERN_HYOUJI, UTIWAKE_3DAISIPPMENGEN, "UTIWAKE_3DAISIPPMENGEN", false);
        addPattern(PATTERN_HYOUJI, UTIWAKE_3DAISIPPMENZOU, "UTIWAKE_3DAISIPPMENZOU", false);
        addPattern(PATTERN_HYOUJI, UTIWAKE_3DAISIP, "UTIWAKE_3DAISIP", false);
        addPattern(PATTERN_HYOUJI, UTIWAKE_FSTPMINYUU, "UTIWAKE_FSTPMINYUU", false);
        addPattern(PATTERN_HYOUJI, UTIWAKE_OTHER, "UTIWAKE_OTHER", false);
        addPattern(PATTERN_HYOUJI, UTIWAKE_HARAIKOMI, "UTIWAKE_HARAIKOMI", false);
        addPattern(PATTERN_HYOUJI, UTIWAKE_PMEN, "UTIWAKE_PMEN", false);
        addPattern(PATTERN_HYOUJI, UTIWAKE_HARAIMANGO, "UTIWAKE_HARAIMANGO", false);
        addPattern(PATTERN_HYOUJI, UTIWAKE_ITIJIBARAI, "UTIWAKE_ITIJIBARAI", false);


        lock(C_Idounaiyocd.class);
    }

    private C_Idounaiyocd(String value) {
        super(value);
    }

    public static C_Idounaiyocd valueOf(String value) {
        return valueOf(C_Idounaiyocd.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Idounaiyocd.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Idounaiyocd.class, patternId, value);
    }
}
