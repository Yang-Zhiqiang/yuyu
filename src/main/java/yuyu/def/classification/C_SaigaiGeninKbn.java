
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 災害原因区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SaigaiGeninKbn</td><td colspan="3">災害原因区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="11">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CAR_JIKO}</td><td>&quot;1&quot;</td><td>自動車交通事故</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CAR_HIJIKO}</td><td>&quot;2&quot;</td><td>自動車非交通事故</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HICAR_JIKO}</td><td>&quot;3&quot;</td><td>自動車以外の交通機関による事故</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUIRAKU}</td><td>&quot;4&quot;</td><td>不慮の墜落</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DEKISI}</td><td>&quot;5&quot;</td><td>不慮の溺死および溺水</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DABOKU}</td><td>&quot;6&quot;</td><td>落下物による不慮の打撲</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KIKAI}</td><td>&quot;7&quot;</td><td>機械による不慮の事故</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KASAI}</td><td>&quot;8&quot;</td><td>火災</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENTOU}</td><td>&quot;9&quot;</td><td>転倒・転落</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;99&quot;</td><td>その他の不慮の事故</td></tr>
 *  <tr><td rowspan="9">{@link #PATTERN_KYUUFU KYUUFU}<br />(給付)</td><td align="center">&nbsp;</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CAR_JIKO}</td><td>&quot;1&quot;</td><td>自動車交通事故</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CAR_HIJIKO}</td><td>&quot;2&quot;</td><td>自動車非交通事故</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HICAR_JIKO}</td><td>&quot;3&quot;</td><td>自動車以外の交通機関による事故</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUIRAKU}</td><td>&quot;4&quot;</td><td>不慮の墜落</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DEKISI}</td><td>&quot;5&quot;</td><td>不慮の溺死および溺水</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DABOKU}</td><td>&quot;6&quot;</td><td>落下物による不慮の打撲</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KIKAI}</td><td>&quot;7&quot;</td><td>機械による不慮の事故</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;99&quot;</td><td>その他の不慮の事故</td></tr>
 *  <tr><td rowspan="11">{@link #PATTERN_SIBOU SIBOU}<br />(死亡)</td><td align="center">&nbsp;</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CAR_JIKO}</td><td>&quot;1&quot;</td><td>自動車交通事故</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CAR_HIJIKO}</td><td>&quot;2&quot;</td><td>自動車非交通事故</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HICAR_JIKO}</td><td>&quot;3&quot;</td><td>自動車以外の交通機関による事故</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUIRAKU}</td><td>&quot;4&quot;</td><td>不慮の墜落</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DEKISI}</td><td>&quot;5&quot;</td><td>不慮の溺死および溺水</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DABOKU}</td><td>&quot;6&quot;</td><td>落下物による不慮の打撲</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KIKAI}</td><td>&quot;7&quot;</td><td>機械による不慮の事故</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KASAI}</td><td>&quot;8&quot;</td><td>火災</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENTOU}</td><td>&quot;9&quot;</td><td>転倒・転落</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;99&quot;</td><td>その他の不慮の事故</td></tr>
 *  <tr><td rowspan="9">{@link #PATTERN_PM PM}<br />(Ｐ免)</td><td align="center">&nbsp;</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CAR_JIKO}</td><td>&quot;1&quot;</td><td>自動車交通事故</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CAR_HIJIKO}</td><td>&quot;2&quot;</td><td>自動車非交通事故</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HICAR_JIKO}</td><td>&quot;3&quot;</td><td>自動車以外の交通機関による事故</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUIRAKU}</td><td>&quot;4&quot;</td><td>不慮の墜落</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DEKISI}</td><td>&quot;5&quot;</td><td>不慮の溺死および溺水</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DABOKU}</td><td>&quot;6&quot;</td><td>落下物による不慮の打撲</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KIKAI}</td><td>&quot;7&quot;</td><td>機械による不慮の事故</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;99&quot;</td><td>その他の不慮の事故</td></tr>
 *  <tr><td rowspan="11">{@link #PATTERN_KOUSYOU KOUSYOU}<br />(高度障害)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CAR_JIKO}</td><td>&quot;1&quot;</td><td>自動車交通事故</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CAR_HIJIKO}</td><td>&quot;2&quot;</td><td>自動車非交通事故</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HICAR_JIKO}</td><td>&quot;3&quot;</td><td>自動車以外の交通機関による事故</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUIRAKU}</td><td>&quot;4&quot;</td><td>不慮の墜落</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DEKISI}</td><td>&quot;5&quot;</td><td>不慮の溺死および溺水</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DABOKU}</td><td>&quot;6&quot;</td><td>落下物による不慮の打撲</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KIKAI}</td><td>&quot;7&quot;</td><td>機械による不慮の事故</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KASAI}</td><td>&quot;8&quot;</td><td>火災</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENTOU}</td><td>&quot;9&quot;</td><td>転倒・転落</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;99&quot;</td><td>その他の不慮の事故</td></tr>
 * </table>
 */
public class C_SaigaiGeninKbn extends Classification<C_SaigaiGeninKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SaigaiGeninKbn BLNK = new C_SaigaiGeninKbn("0");

    public static final C_SaigaiGeninKbn CAR_JIKO = new C_SaigaiGeninKbn("1");

    public static final C_SaigaiGeninKbn CAR_HIJIKO = new C_SaigaiGeninKbn("2");

    public static final C_SaigaiGeninKbn HICAR_JIKO = new C_SaigaiGeninKbn("3");

    public static final C_SaigaiGeninKbn TUIRAKU = new C_SaigaiGeninKbn("4");

    public static final C_SaigaiGeninKbn DEKISI = new C_SaigaiGeninKbn("5");

    public static final C_SaigaiGeninKbn DABOKU = new C_SaigaiGeninKbn("6");

    public static final C_SaigaiGeninKbn KIKAI = new C_SaigaiGeninKbn("7");

    public static final C_SaigaiGeninKbn KASAI = new C_SaigaiGeninKbn("8");

    public static final C_SaigaiGeninKbn TENTOU = new C_SaigaiGeninKbn("9");

    public static final C_SaigaiGeninKbn SONOTA = new C_SaigaiGeninKbn("99");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_KYUUFU = "2";

    public static final String PATTERN_SIBOU = "3";

    public static final String PATTERN_PM = "4";

    public static final String PATTERN_KOUSYOU = "5";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, CAR_JIKO, "CAR_JIKO", false);
        addPattern(PATTERN_DEFAULT, CAR_HIJIKO, "CAR_HIJIKO", false);
        addPattern(PATTERN_DEFAULT, HICAR_JIKO, "HICAR_JIKO", false);
        addPattern(PATTERN_DEFAULT, TUIRAKU, "TUIRAKU", false);
        addPattern(PATTERN_DEFAULT, DEKISI, "DEKISI", false);
        addPattern(PATTERN_DEFAULT, DABOKU, "DABOKU", false);
        addPattern(PATTERN_DEFAULT, KIKAI, "KIKAI", false);
        addPattern(PATTERN_DEFAULT, KASAI, "KASAI", false);
        addPattern(PATTERN_DEFAULT, TENTOU, "TENTOU", false);
        addPattern(PATTERN_DEFAULT, SONOTA, "SONOTA", false);


        addPattern(PATTERN_KYUUFU, BLNK, "BLNK", false);
        addPattern(PATTERN_KYUUFU, CAR_JIKO, "CAR_JIKO", false);
        addPattern(PATTERN_KYUUFU, CAR_HIJIKO, "CAR_HIJIKO", false);
        addPattern(PATTERN_KYUUFU, HICAR_JIKO, "HICAR_JIKO", false);
        addPattern(PATTERN_KYUUFU, TUIRAKU, "TUIRAKU", false);
        addPattern(PATTERN_KYUUFU, DEKISI, "DEKISI", false);
        addPattern(PATTERN_KYUUFU, DABOKU, "DABOKU", false);
        addPattern(PATTERN_KYUUFU, KIKAI, "KIKAI", false);
        addPattern(PATTERN_KYUUFU, SONOTA, "SONOTA", false);


        addPattern(PATTERN_SIBOU, BLNK, "BLNK", false);
        addPattern(PATTERN_SIBOU, CAR_JIKO, "CAR_JIKO", false);
        addPattern(PATTERN_SIBOU, CAR_HIJIKO, "CAR_HIJIKO", false);
        addPattern(PATTERN_SIBOU, HICAR_JIKO, "HICAR_JIKO", false);
        addPattern(PATTERN_SIBOU, TUIRAKU, "TUIRAKU", false);
        addPattern(PATTERN_SIBOU, DEKISI, "DEKISI", false);
        addPattern(PATTERN_SIBOU, DABOKU, "DABOKU", false);
        addPattern(PATTERN_SIBOU, KIKAI, "KIKAI", false);
        addPattern(PATTERN_SIBOU, KASAI, "KASAI", false);
        addPattern(PATTERN_SIBOU, TENTOU, "TENTOU", false);
        addPattern(PATTERN_SIBOU, SONOTA, "SONOTA", false);


        addPattern(PATTERN_PM, BLNK, "BLNK", false);
        addPattern(PATTERN_PM, CAR_JIKO, "CAR_JIKO", false);
        addPattern(PATTERN_PM, CAR_HIJIKO, "CAR_HIJIKO", false);
        addPattern(PATTERN_PM, HICAR_JIKO, "HICAR_JIKO", false);
        addPattern(PATTERN_PM, TUIRAKU, "TUIRAKU", false);
        addPattern(PATTERN_PM, DEKISI, "DEKISI", false);
        addPattern(PATTERN_PM, DABOKU, "DABOKU", false);
        addPattern(PATTERN_PM, KIKAI, "KIKAI", false);
        addPattern(PATTERN_PM, SONOTA, "SONOTA", false);


        addPattern(PATTERN_KOUSYOU, BLNK, "BLNK", true);
        addPattern(PATTERN_KOUSYOU, CAR_JIKO, "CAR_JIKO", false);
        addPattern(PATTERN_KOUSYOU, CAR_HIJIKO, "CAR_HIJIKO", false);
        addPattern(PATTERN_KOUSYOU, HICAR_JIKO, "HICAR_JIKO", false);
        addPattern(PATTERN_KOUSYOU, TUIRAKU, "TUIRAKU", false);
        addPattern(PATTERN_KOUSYOU, DEKISI, "DEKISI", false);
        addPattern(PATTERN_KOUSYOU, DABOKU, "DABOKU", false);
        addPattern(PATTERN_KOUSYOU, KIKAI, "KIKAI", false);
        addPattern(PATTERN_KOUSYOU, KASAI, "KASAI", false);
        addPattern(PATTERN_KOUSYOU, TENTOU, "TENTOU", false);
        addPattern(PATTERN_KOUSYOU, SONOTA, "SONOTA", false);


        lock(C_SaigaiGeninKbn.class);
    }

    private C_SaigaiGeninKbn(String value) {
        super(value);
    }

    public static C_SaigaiGeninKbn valueOf(String value) {
        return valueOf(C_SaigaiGeninKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SaigaiGeninKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SaigaiGeninKbn.class, patternId, value);
    }
}
