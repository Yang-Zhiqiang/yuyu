
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 原因区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_GeninKbn</td><td colspan="3">原因区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="17">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SP}</td><td>&quot;1&quot;</td><td>疾病</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SG}</td><td>&quot;2&quot;</td><td>災害</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JS}</td><td>&quot;3&quot;</td><td>自殺</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GN}</td><td>&quot;4&quot;</td><td>がん</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SGSP}</td><td>&quot;5&quot;</td><td>災害疾病</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TST}</td><td>&quot;6&quot;</td><td>他殺</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TSK}</td><td>&quot;7&quot;</td><td>窒息</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TDK}</td><td>&quot;8&quot;</td><td>中毒</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTAFS}</td><td>&quot;9&quot;</td><td>その他及び不詳の外因</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BSSS}</td><td>&quot;10&quot;</td><td>病死及び自然死</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KTJK}</td><td>&quot;11&quot;</td><td>交通事故</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENTOU}</td><td>&quot;12&quot;</td><td>転倒・転落</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DKS}</td><td>&quot;13&quot;</td><td>溺水</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KKOKS}</td><td>&quot;14&quot;</td><td>煙、火災及び火焔による傷害</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTAFR}</td><td>&quot;15&quot;</td><td>その他（不慮の外因死）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FSS}</td><td>&quot;16&quot;</td><td>不詳の死</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_KYUUFU KYUUFU}<br />(給付用)</td><td align="center">&nbsp;</td><td>{@link #SP}</td><td>&quot;1&quot;</td><td>疾病</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SG}</td><td>&quot;2&quot;</td><td>災害</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_KOUSYOU KOUSYOU}<br />(高度障害用)</td><td align="center">○</td><td>{@link #SP}</td><td>&quot;1&quot;</td><td>疾病</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SG}</td><td>&quot;2&quot;</td><td>災害</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTAFS}</td><td>&quot;9&quot;</td><td>その他及び不詳の外因</td></tr>
 *  <tr><td rowspan="12">{@link #PATTERN_SIBOU SIBOU}<br />(死亡)</td><td align="center">○</td><td>{@link #BSSS}</td><td>&quot;10&quot;</td><td>病死及び自然死</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KTJK}</td><td>&quot;11&quot;</td><td>交通事故</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENTOU}</td><td>&quot;12&quot;</td><td>転倒・転落</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DKS}</td><td>&quot;13&quot;</td><td>溺水</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KKOKS}</td><td>&quot;14&quot;</td><td>煙、火災及び火焔による傷害</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TSK}</td><td>&quot;7&quot;</td><td>窒息</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TDK}</td><td>&quot;8&quot;</td><td>中毒</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTAFR}</td><td>&quot;15&quot;</td><td>その他（不慮の外因死）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JS}</td><td>&quot;3&quot;</td><td>自殺</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TST}</td><td>&quot;6&quot;</td><td>他殺</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTAFS}</td><td>&quot;9&quot;</td><td>その他及び不詳の外因</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FSS}</td><td>&quot;16&quot;</td><td>不詳の死</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_PM PM}<br />(Ｐ免)</td><td align="center">&nbsp;</td><td>{@link #SP}</td><td>&quot;1&quot;</td><td>疾病</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SG}</td><td>&quot;2&quot;</td><td>災害</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_SIBOU_MSD SIBOU_MSD}<br />(死亡申出用)</td><td align="center">○</td><td>{@link #SP}</td><td>&quot;1&quot;</td><td>疾病</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SG}</td><td>&quot;2&quot;</td><td>災害</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JS}</td><td>&quot;3&quot;</td><td>自殺</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_SISAN SISAN}<br />(試算用)</td><td align="center">○</td><td>{@link #SP}</td><td>&quot;1&quot;</td><td>疾病</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SG}</td><td>&quot;2&quot;</td><td>災害</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JS}</td><td>&quot;3&quot;</td><td>自殺</td></tr>
 * </table>
 */
public class C_GeninKbn extends Classification<C_GeninKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_GeninKbn BLNK = new C_GeninKbn("0");

    public static final C_GeninKbn SP = new C_GeninKbn("1");

    public static final C_GeninKbn SG = new C_GeninKbn("2");

    public static final C_GeninKbn JS = new C_GeninKbn("3");

    public static final C_GeninKbn GN = new C_GeninKbn("4");

    public static final C_GeninKbn SGSP = new C_GeninKbn("5");

    public static final C_GeninKbn TST = new C_GeninKbn("6");

    public static final C_GeninKbn TSK = new C_GeninKbn("7");

    public static final C_GeninKbn TDK = new C_GeninKbn("8");

    public static final C_GeninKbn SONOTAFS = new C_GeninKbn("9");

    public static final C_GeninKbn BSSS = new C_GeninKbn("10");

    public static final C_GeninKbn KTJK = new C_GeninKbn("11");

    public static final C_GeninKbn TENTOU = new C_GeninKbn("12");

    public static final C_GeninKbn DKS = new C_GeninKbn("13");

    public static final C_GeninKbn KKOKS = new C_GeninKbn("14");

    public static final C_GeninKbn SONOTAFR = new C_GeninKbn("15");

    public static final C_GeninKbn FSS = new C_GeninKbn("16");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_KYUUFU = "2";

    public static final String PATTERN_KOUSYOU = "3";

    public static final String PATTERN_SIBOU = "4";

    public static final String PATTERN_PM = "5";

    public static final String PATTERN_SIBOU_MSD = "6";

    public static final String PATTERN_SISAN = "7";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SP, "SP", false);
        addPattern(PATTERN_DEFAULT, SG, "SG", false);
        addPattern(PATTERN_DEFAULT, JS, "JS", false);
        addPattern(PATTERN_DEFAULT, GN, "GN", false);
        addPattern(PATTERN_DEFAULT, SGSP, "SGSP", false);
        addPattern(PATTERN_DEFAULT, TST, "TST", false);
        addPattern(PATTERN_DEFAULT, TSK, "TSK", false);
        addPattern(PATTERN_DEFAULT, TDK, "TDK", false);
        addPattern(PATTERN_DEFAULT, SONOTAFS, "SONOTAFS", false);
        addPattern(PATTERN_DEFAULT, BSSS, "BSSS", false);
        addPattern(PATTERN_DEFAULT, KTJK, "KTJK", false);
        addPattern(PATTERN_DEFAULT, TENTOU, "TENTOU", false);
        addPattern(PATTERN_DEFAULT, DKS, "DKS", false);
        addPattern(PATTERN_DEFAULT, KKOKS, "KKOKS", false);
        addPattern(PATTERN_DEFAULT, SONOTAFR, "SONOTAFR", false);
        addPattern(PATTERN_DEFAULT, FSS, "FSS", false);


        addPattern(PATTERN_KYUUFU, SP, "SP", false);
        addPattern(PATTERN_KYUUFU, SG, "SG", false);


        addPattern(PATTERN_KOUSYOU, SP, "SP", true);
        addPattern(PATTERN_KOUSYOU, SG, "SG", false);
        addPattern(PATTERN_KOUSYOU, SONOTAFS, "SONOTAFS", false);


        addPattern(PATTERN_SIBOU, BSSS, "BSSS", true);
        addPattern(PATTERN_SIBOU, KTJK, "KTJK", false);
        addPattern(PATTERN_SIBOU, TENTOU, "TENTOU", false);
        addPattern(PATTERN_SIBOU, DKS, "DKS", false);
        addPattern(PATTERN_SIBOU, KKOKS, "KKOKS", false);
        addPattern(PATTERN_SIBOU, TSK, "TSK", false);
        addPattern(PATTERN_SIBOU, TDK, "TDK", false);
        addPattern(PATTERN_SIBOU, SONOTAFR, "SONOTAFR", false);
        addPattern(PATTERN_SIBOU, JS, "JS", false);
        addPattern(PATTERN_SIBOU, TST, "TST", false);
        addPattern(PATTERN_SIBOU, SONOTAFS, "SONOTAFS", false);
        addPattern(PATTERN_SIBOU, FSS, "FSS", false);


        addPattern(PATTERN_PM, SP, "SP", false);
        addPattern(PATTERN_PM, SG, "SG", false);


        addPattern(PATTERN_SIBOU_MSD, SP, "SP", true);
        addPattern(PATTERN_SIBOU_MSD, SG, "SG", false);
        addPattern(PATTERN_SIBOU_MSD, JS, "JS", false);


        addPattern(PATTERN_SISAN, SP, "SP", true);
        addPattern(PATTERN_SISAN, SG, "SG", false);
        addPattern(PATTERN_SISAN, JS, "JS", false);


        lock(C_GeninKbn.class);
    }

    private C_GeninKbn(String value) {
        super(value);
    }

    public static C_GeninKbn valueOf(String value) {
        return valueOf(C_GeninKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_GeninKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_GeninKbn.class, patternId, value);
    }
}
