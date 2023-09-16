
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 年金支払発生事由 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Nkshrhsijiyuu</td><td colspan="3">年金支払発生事由</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOU}</td><td>&quot;1&quot;</td><td>死亡</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUDOSYOUGAI}</td><td>&quot;2&quot;</td><td>高度障害</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MANKI}</td><td>&quot;3&quot;</td><td>満期</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOJINNENKIN}</td><td>&quot;4&quot;</td><td>個人年金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIKOGOTOKUYAKU}</td><td>&quot;5&quot;</td><td>事故後特約</td></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_NOBLNK NOBLNK}<br />(ブランクなし)</td><td align="center">○</td><td>{@link #SIBOU}</td><td>&quot;1&quot;</td><td>死亡</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUDOSYOUGAI}</td><td>&quot;2&quot;</td><td>高度障害</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MANKI}</td><td>&quot;3&quot;</td><td>満期</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOJINNENKIN}</td><td>&quot;4&quot;</td><td>個人年金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIKOGOTOKUYAKU}</td><td>&quot;5&quot;</td><td>事故後特約</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_TORIKOMI TORIKOMI}<br />(取込)</td><td align="center">○</td><td>{@link #SIBOU}</td><td>&quot;1&quot;</td><td>死亡</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOJINNENKIN}</td><td>&quot;4&quot;</td><td>個人年金</td></tr>
 * </table>
 */
public class C_Nkshrhsijiyuu extends Classification<C_Nkshrhsijiyuu> {

    private static final long serialVersionUID = 1L;


    public static final C_Nkshrhsijiyuu BLNK = new C_Nkshrhsijiyuu("0");

    public static final C_Nkshrhsijiyuu SIBOU = new C_Nkshrhsijiyuu("1");

    public static final C_Nkshrhsijiyuu KOUDOSYOUGAI = new C_Nkshrhsijiyuu("2");

    public static final C_Nkshrhsijiyuu MANKI = new C_Nkshrhsijiyuu("3");

    public static final C_Nkshrhsijiyuu KOJINNENKIN = new C_Nkshrhsijiyuu("4");

    public static final C_Nkshrhsijiyuu JIKOGOTOKUYAKU = new C_Nkshrhsijiyuu("5");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_NOBLNK = "2";

    public static final String PATTERN_TORIKOMI = "3";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SIBOU, "SIBOU", false);
        addPattern(PATTERN_DEFAULT, KOUDOSYOUGAI, "KOUDOSYOUGAI", false);
        addPattern(PATTERN_DEFAULT, MANKI, "MANKI", false);
        addPattern(PATTERN_DEFAULT, KOJINNENKIN, "KOJINNENKIN", false);
        addPattern(PATTERN_DEFAULT, JIKOGOTOKUYAKU, "JIKOGOTOKUYAKU", false);


        addPattern(PATTERN_NOBLNK, SIBOU, "SIBOU", true);
        addPattern(PATTERN_NOBLNK, KOUDOSYOUGAI, "KOUDOSYOUGAI", false);
        addPattern(PATTERN_NOBLNK, MANKI, "MANKI", false);
        addPattern(PATTERN_NOBLNK, KOJINNENKIN, "KOJINNENKIN", false);
        addPattern(PATTERN_NOBLNK, JIKOGOTOKUYAKU, "JIKOGOTOKUYAKU", false);


        addPattern(PATTERN_TORIKOMI, SIBOU, "SIBOU", true);
        addPattern(PATTERN_TORIKOMI, KOJINNENKIN, "KOJINNENKIN", false);


        lock(C_Nkshrhsijiyuu.class);
    }

    private C_Nkshrhsijiyuu(String value) {
        super(value);
    }

    public static C_Nkshrhsijiyuu valueOf(String value) {
        return valueOf(C_Nkshrhsijiyuu.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Nkshrhsijiyuu.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Nkshrhsijiyuu.class, patternId, value);
    }
}
