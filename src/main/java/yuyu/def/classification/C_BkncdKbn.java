
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 備金コード区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_BkncdKbn</td><td colspan="3">備金コード区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="10">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GENGK}</td><td>&quot;PC02&quot;</td><td>減額備金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKU}</td><td>&quot;PC12&quot;</td><td>解約備金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOUUKETUKE}</td><td>&quot;PEC2&quot;</td><td>死亡受付</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOUKARIUKETUKE}</td><td>&quot;PEC4&quot;</td><td>死亡仮受付</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUDOSYOUGAIUKETUKE}</td><td>&quot;PED2&quot;</td><td>高度障害受付</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MENSEKI}</td><td>&quot;PECA&quot;</td><td>免責</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOUKAIJYO}</td><td>&quot;PECB&quot;</td><td>死亡解除</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YENDTHNKHR}</td><td>&quot;RBK2&quot;</td><td>円建変更時返戻金備金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PMINYUUSYOUMETU}</td><td>&quot;RDQ4&quot;</td><td>Ｐ未入消滅備金</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_HOZEN HOZEN}<br />(契約保全)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GENGK}</td><td>&quot;PC02&quot;</td><td>減額</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKU}</td><td>&quot;PC12&quot;</td><td>解約</td></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_SIHARAI SIHARAI}<br />(保険金)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOUUKETUKE}</td><td>&quot;PEC2&quot;</td><td>死亡受付</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOUKARIUKETUKE}</td><td>&quot;PEC4&quot;</td><td>死亡仮受付</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOUKAIJYO}</td><td>&quot;PECB&quot;</td><td>死亡解除</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MENSEKI}</td><td>&quot;PECA&quot;</td><td>免責</td></tr>
 * </table>
 */
public class C_BkncdKbn extends Classification<C_BkncdKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_BkncdKbn BLNK = new C_BkncdKbn("0");

    public static final C_BkncdKbn GENGK = new C_BkncdKbn("PC02");

    public static final C_BkncdKbn KAIYAKU = new C_BkncdKbn("PC12");

    public static final C_BkncdKbn SIBOUUKETUKE = new C_BkncdKbn("PEC2");

    public static final C_BkncdKbn SIBOUKARIUKETUKE = new C_BkncdKbn("PEC4");

    public static final C_BkncdKbn KOUDOSYOUGAIUKETUKE = new C_BkncdKbn("PED2");

    public static final C_BkncdKbn MENSEKI = new C_BkncdKbn("PECA");

    public static final C_BkncdKbn SIBOUKAIJYO = new C_BkncdKbn("PECB");

    public static final C_BkncdKbn YENDTHNKHR = new C_BkncdKbn("RBK2");

    public static final C_BkncdKbn PMINYUUSYOUMETU = new C_BkncdKbn("RDQ4");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_HOZEN = "2";

    public static final String PATTERN_SIHARAI = "3";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, GENGK, "GENGK", false);
        addPattern(PATTERN_DEFAULT, KAIYAKU, "KAIYAKU", false);
        addPattern(PATTERN_DEFAULT, SIBOUUKETUKE, "SIBOUUKETUKE", false);
        addPattern(PATTERN_DEFAULT, SIBOUKARIUKETUKE, "SIBOUKARIUKETUKE", false);
        addPattern(PATTERN_DEFAULT, KOUDOSYOUGAIUKETUKE, "KOUDOSYOUGAIUKETUKE", false);
        addPattern(PATTERN_DEFAULT, MENSEKI, "MENSEKI", false);
        addPattern(PATTERN_DEFAULT, SIBOUKAIJYO, "SIBOUKAIJYO", false);
        addPattern(PATTERN_DEFAULT, YENDTHNKHR, "YENDTHNKHR", false);
        addPattern(PATTERN_DEFAULT, PMINYUUSYOUMETU, "PMINYUUSYOUMETU", false);


        addPattern(PATTERN_HOZEN, BLNK, "BLNK", true);
        addPattern(PATTERN_HOZEN, GENGK, "GENGK", false);
        addPattern(PATTERN_HOZEN, KAIYAKU, "KAIYAKU", false);


        addPattern(PATTERN_SIHARAI, BLNK, "BLNK", true);
        addPattern(PATTERN_SIHARAI, SIBOUUKETUKE, "SIBOUUKETUKE", false);
        addPattern(PATTERN_SIHARAI, SIBOUKARIUKETUKE, "SIBOUKARIUKETUKE", false);
        addPattern(PATTERN_SIHARAI, SIBOUKAIJYO, "SIBOUKAIJYO", false);
        addPattern(PATTERN_SIHARAI, MENSEKI, "MENSEKI", false);


        lock(C_BkncdKbn.class);
    }

    private C_BkncdKbn(String value) {
        super(value);
    }

    public static C_BkncdKbn valueOf(String value) {
        return valueOf(C_BkncdKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_BkncdKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_BkncdKbn.class, patternId, value);
    }
}
