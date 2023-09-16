
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 手数料処理区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TsrysyoriKbn</td><td colspan="3">手数料処理区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="35">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;000&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINKEIYAKUSEIRITU}</td><td>&quot;001&quot;</td><td>新契約成立</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NYUUKINMAESEIRITU}</td><td>&quot;002&quot;</td><td>入金前成立</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEIRITUGOFSTPNYUUKIN}</td><td>&quot;010&quot;</td><td>成立後初回Ｐ入金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIZOKUPNYUUKIN}</td><td>&quot;011&quot;</td><td>継続P入金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IKKATUNYUUKIN}</td><td>&quot;012&quot;</td><td>一括入金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MISYUUPNYUUKIN}</td><td>&quot;013&quot;</td><td>未収P入金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUMETUGOKZPNYUUKIN}</td><td>&quot;014&quot;</td><td>消滅後継続Ｐ入金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NYUUKINTORIKESI}</td><td>&quot;021&quot;</td><td>入金取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IKKATUNYUUKINTYUUSI}</td><td>&quot;022&quot;</td><td>一括入金中止</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEINENGAPPISEI}</td><td>&quot;031&quot;</td><td>生年月日性訂正</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GENGAKU}</td><td>&quot;041&quot;</td><td>減額</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKUYAKUSYOUMETU}</td><td>&quot;042&quot;</td><td>特約消滅</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIKKOU}</td><td>&quot;051&quot;</td><td>失効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUKKATU}</td><td>&quot;061&quot;</td><td>復活</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITIBUHUKKATU}</td><td>&quot;062&quot;</td><td>一部復活</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKU}</td><td>&quot;081&quot;</td><td>解約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PMENGOKAIYAKU}</td><td>&quot;082&quot;</td><td>Ｐ免後解約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIYAKUTORIKESI}</td><td>&quot;091&quot;</td><td>契約取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOU}</td><td>&quot;101&quot;</td><td>死亡</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUDOSYOUGAI}</td><td>&quot;102&quot;</td><td>高度障害</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MIKEIKAPHENKIN}</td><td>&quot;111&quot;</td><td>未経過P返金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TYOUSEI}</td><td>&quot;121&quot;</td><td>調整</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CLGOFF}</td><td>&quot;131&quot;</td><td>クーリングオフ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIJO}</td><td>&quot;141&quot;</td><td>解除</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOUKAIJO}</td><td>&quot;142&quot;</td><td>死亡解除</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MUKOU}</td><td>&quot;151&quot;</td><td>無効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKUYAKUMUKOU}</td><td>&quot;152&quot;</td><td>特約無効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MUKOU_1PMINYUUKIN}</td><td>&quot;153&quot;</td><td>無効（第１回保険料未入金）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MENSEKI}</td><td>&quot;161&quot;</td><td>免責</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PMEN}</td><td>&quot;171&quot;</td><td>Ｐ免</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HARAIMAN}</td><td>&quot;181&quot;</td><td>払満</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IKAN}</td><td>&quot;191&quot;</td><td>移管</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MIJYUUTOU}</td><td>&quot;201&quot;</td><td>未充当調整</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HRIKAIHEN}</td><td>&quot;211&quot;</td><td>払込回数変更</td></tr>
 *  <tr><td rowspan="35">{@link #PATTERN_MEISAI MEISAI}<br />(手数料明細翻訳用)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;000&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINKEIYAKUSEIRITU}</td><td>&quot;001&quot;</td><td>新契約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NYUUKINMAESEIRITU}</td><td>&quot;002&quot;</td><td>入金前成</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEIRITUGOFSTPNYUUKIN}</td><td>&quot;010&quot;</td><td>成後入金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIZOKUPNYUUKIN}</td><td>&quot;011&quot;</td><td>入金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IKKATUNYUUKIN}</td><td>&quot;012&quot;</td><td>一括入金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MISYUUPNYUUKIN}</td><td>&quot;013&quot;</td><td>未収入金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUMETUGOKZPNYUUKIN}</td><td>&quot;014&quot;</td><td>入金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NYUUKINTORIKESI}</td><td>&quot;021&quot;</td><td>入金取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IKKATUNYUUKINTYUUSI}</td><td>&quot;022&quot;</td><td>一括取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEINENGAPPISEI}</td><td>&quot;031&quot;</td><td>契約変更</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GENGAKU}</td><td>&quot;041&quot;</td><td>減額</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKUYAKUSYOUMETU}</td><td>&quot;042&quot;</td><td>特約消滅</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIKKOU}</td><td>&quot;051&quot;</td><td>失効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUKKATU}</td><td>&quot;061&quot;</td><td>復活</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITIBUHUKKATU}</td><td>&quot;062&quot;</td><td>一部復活</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIYAKU}</td><td>&quot;081&quot;</td><td>解約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PMENGOKAIYAKU}</td><td>&quot;082&quot;</td><td>Ｐ免解約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIYAKUTORIKESI}</td><td>&quot;091&quot;</td><td>契約取消</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOU}</td><td>&quot;101&quot;</td><td>死亡</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUDOSYOUGAI}</td><td>&quot;102&quot;</td><td>高度障害</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MIKEIKAPHENKIN}</td><td>&quot;111&quot;</td><td>入金返還</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TYOUSEI}</td><td>&quot;121&quot;</td><td>調整</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CLGOFF}</td><td>&quot;131&quot;</td><td>ｸｰﾘﾝｸﾞｵﾌ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAIJO}</td><td>&quot;141&quot;</td><td>解除</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIBOUKAIJO}</td><td>&quot;142&quot;</td><td>死亡解除</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MUKOU}</td><td>&quot;151&quot;</td><td>無効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKUYAKUMUKOU}</td><td>&quot;152&quot;</td><td>特約無効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MUKOU_1PMINYUUKIN}</td><td>&quot;153&quot;</td><td>無効</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MENSEKI}</td><td>&quot;161&quot;</td><td>免責</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PMEN}</td><td>&quot;171&quot;</td><td>Ｐ免</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HARAIMAN}</td><td>&quot;181&quot;</td><td>払満</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IKAN}</td><td>&quot;191&quot;</td><td>移管</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MIJYUUTOU}</td><td>&quot;201&quot;</td><td>前払調整</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HRIKAIHEN}</td><td>&quot;211&quot;</td><td>払方変更</td></tr>
 * </table>
 */
public class C_TsrysyoriKbn extends Classification<C_TsrysyoriKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TsrysyoriKbn BLNK = new C_TsrysyoriKbn("000");

    public static final C_TsrysyoriKbn SINKEIYAKUSEIRITU = new C_TsrysyoriKbn("001");

    public static final C_TsrysyoriKbn NYUUKINMAESEIRITU = new C_TsrysyoriKbn("002");

    public static final C_TsrysyoriKbn SEIRITUGOFSTPNYUUKIN = new C_TsrysyoriKbn("010");

    public static final C_TsrysyoriKbn KEIZOKUPNYUUKIN = new C_TsrysyoriKbn("011");

    public static final C_TsrysyoriKbn IKKATUNYUUKIN = new C_TsrysyoriKbn("012");

    public static final C_TsrysyoriKbn MISYUUPNYUUKIN = new C_TsrysyoriKbn("013");

    public static final C_TsrysyoriKbn SYOUMETUGOKZPNYUUKIN = new C_TsrysyoriKbn("014");

    public static final C_TsrysyoriKbn NYUUKINTORIKESI = new C_TsrysyoriKbn("021");

    public static final C_TsrysyoriKbn IKKATUNYUUKINTYUUSI = new C_TsrysyoriKbn("022");

    public static final C_TsrysyoriKbn SEINENGAPPISEI = new C_TsrysyoriKbn("031");

    public static final C_TsrysyoriKbn GENGAKU = new C_TsrysyoriKbn("041");

    public static final C_TsrysyoriKbn TOKUYAKUSYOUMETU = new C_TsrysyoriKbn("042");

    public static final C_TsrysyoriKbn SIKKOU = new C_TsrysyoriKbn("051");

    public static final C_TsrysyoriKbn HUKKATU = new C_TsrysyoriKbn("061");

    public static final C_TsrysyoriKbn ITIBUHUKKATU = new C_TsrysyoriKbn("062");

    public static final C_TsrysyoriKbn KAIYAKU = new C_TsrysyoriKbn("081");

    public static final C_TsrysyoriKbn PMENGOKAIYAKU = new C_TsrysyoriKbn("082");

    public static final C_TsrysyoriKbn KEIYAKUTORIKESI = new C_TsrysyoriKbn("091");

    public static final C_TsrysyoriKbn SIBOU = new C_TsrysyoriKbn("101");

    public static final C_TsrysyoriKbn KOUDOSYOUGAI = new C_TsrysyoriKbn("102");

    public static final C_TsrysyoriKbn MIKEIKAPHENKIN = new C_TsrysyoriKbn("111");

    public static final C_TsrysyoriKbn TYOUSEI = new C_TsrysyoriKbn("121");

    public static final C_TsrysyoriKbn CLGOFF = new C_TsrysyoriKbn("131");

    public static final C_TsrysyoriKbn KAIJO = new C_TsrysyoriKbn("141");

    public static final C_TsrysyoriKbn SIBOUKAIJO = new C_TsrysyoriKbn("142");

    public static final C_TsrysyoriKbn MUKOU = new C_TsrysyoriKbn("151");

    public static final C_TsrysyoriKbn TOKUYAKUMUKOU = new C_TsrysyoriKbn("152");

    public static final C_TsrysyoriKbn MUKOU_1PMINYUUKIN = new C_TsrysyoriKbn("153");

    public static final C_TsrysyoriKbn MENSEKI = new C_TsrysyoriKbn("161");

    public static final C_TsrysyoriKbn PMEN = new C_TsrysyoriKbn("171");

    public static final C_TsrysyoriKbn HARAIMAN = new C_TsrysyoriKbn("181");

    public static final C_TsrysyoriKbn IKAN = new C_TsrysyoriKbn("191");

    public static final C_TsrysyoriKbn MIJYUUTOU = new C_TsrysyoriKbn("201");

    public static final C_TsrysyoriKbn HRIKAIHEN = new C_TsrysyoriKbn("211");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_MEISAI = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SINKEIYAKUSEIRITU, "SINKEIYAKUSEIRITU", false);
        addPattern(PATTERN_DEFAULT, NYUUKINMAESEIRITU, "NYUUKINMAESEIRITU", false);
        addPattern(PATTERN_DEFAULT, SEIRITUGOFSTPNYUUKIN, "SEIRITUGOFSTPNYUUKIN", false);
        addPattern(PATTERN_DEFAULT, KEIZOKUPNYUUKIN, "KEIZOKUPNYUUKIN", false);
        addPattern(PATTERN_DEFAULT, IKKATUNYUUKIN, "IKKATUNYUUKIN", false);
        addPattern(PATTERN_DEFAULT, MISYUUPNYUUKIN, "MISYUUPNYUUKIN", false);
        addPattern(PATTERN_DEFAULT, SYOUMETUGOKZPNYUUKIN, "SYOUMETUGOKZPNYUUKIN", false);
        addPattern(PATTERN_DEFAULT, NYUUKINTORIKESI, "NYUUKINTORIKESI", false);
        addPattern(PATTERN_DEFAULT, IKKATUNYUUKINTYUUSI, "IKKATUNYUUKINTYUUSI", false);
        addPattern(PATTERN_DEFAULT, SEINENGAPPISEI, "SEINENGAPPISEI", false);
        addPattern(PATTERN_DEFAULT, GENGAKU, "GENGAKU", false);
        addPattern(PATTERN_DEFAULT, TOKUYAKUSYOUMETU, "TOKUYAKUSYOUMETU", false);
        addPattern(PATTERN_DEFAULT, SIKKOU, "SIKKOU", false);
        addPattern(PATTERN_DEFAULT, HUKKATU, "HUKKATU", false);
        addPattern(PATTERN_DEFAULT, ITIBUHUKKATU, "ITIBUHUKKATU", false);
        addPattern(PATTERN_DEFAULT, KAIYAKU, "KAIYAKU", false);
        addPattern(PATTERN_DEFAULT, PMENGOKAIYAKU, "PMENGOKAIYAKU", false);
        addPattern(PATTERN_DEFAULT, KEIYAKUTORIKESI, "KEIYAKUTORIKESI", false);
        addPattern(PATTERN_DEFAULT, SIBOU, "SIBOU", false);
        addPattern(PATTERN_DEFAULT, KOUDOSYOUGAI, "KOUDOSYOUGAI", false);
        addPattern(PATTERN_DEFAULT, MIKEIKAPHENKIN, "MIKEIKAPHENKIN", false);
        addPattern(PATTERN_DEFAULT, TYOUSEI, "TYOUSEI", false);
        addPattern(PATTERN_DEFAULT, CLGOFF, "CLGOFF", false);
        addPattern(PATTERN_DEFAULT, KAIJO, "KAIJO", false);
        addPattern(PATTERN_DEFAULT, SIBOUKAIJO, "SIBOUKAIJO", false);
        addPattern(PATTERN_DEFAULT, MUKOU, "MUKOU", false);
        addPattern(PATTERN_DEFAULT, TOKUYAKUMUKOU, "TOKUYAKUMUKOU", false);
        addPattern(PATTERN_DEFAULT, MUKOU_1PMINYUUKIN, "MUKOU_1PMINYUUKIN", false);
        addPattern(PATTERN_DEFAULT, MENSEKI, "MENSEKI", false);
        addPattern(PATTERN_DEFAULT, PMEN, "PMEN", false);
        addPattern(PATTERN_DEFAULT, HARAIMAN, "HARAIMAN", false);
        addPattern(PATTERN_DEFAULT, IKAN, "IKAN", false);
        addPattern(PATTERN_DEFAULT, MIJYUUTOU, "MIJYUUTOU", false);
        addPattern(PATTERN_DEFAULT, HRIKAIHEN, "HRIKAIHEN", false);


        addPattern(PATTERN_MEISAI, BLNK, "BLNK", true);
        addPattern(PATTERN_MEISAI, SINKEIYAKUSEIRITU, "SINKEIYAKUSEIRITU", false);
        addPattern(PATTERN_MEISAI, NYUUKINMAESEIRITU, "NYUUKINMAESEIRITU", false);
        addPattern(PATTERN_MEISAI, SEIRITUGOFSTPNYUUKIN, "SEIRITUGOFSTPNYUUKIN", false);
        addPattern(PATTERN_MEISAI, KEIZOKUPNYUUKIN, "KEIZOKUPNYUUKIN", false);
        addPattern(PATTERN_MEISAI, IKKATUNYUUKIN, "IKKATUNYUUKIN", false);
        addPattern(PATTERN_MEISAI, MISYUUPNYUUKIN, "MISYUUPNYUUKIN", false);
        addPattern(PATTERN_MEISAI, SYOUMETUGOKZPNYUUKIN, "SYOUMETUGOKZPNYUUKIN", false);
        addPattern(PATTERN_MEISAI, NYUUKINTORIKESI, "NYUUKINTORIKESI", false);
        addPattern(PATTERN_MEISAI, IKKATUNYUUKINTYUUSI, "IKKATUNYUUKINTYUUSI", false);
        addPattern(PATTERN_MEISAI, SEINENGAPPISEI, "SEINENGAPPISEI", false);
        addPattern(PATTERN_MEISAI, GENGAKU, "GENGAKU", false);
        addPattern(PATTERN_MEISAI, TOKUYAKUSYOUMETU, "TOKUYAKUSYOUMETU", false);
        addPattern(PATTERN_MEISAI, SIKKOU, "SIKKOU", false);
        addPattern(PATTERN_MEISAI, HUKKATU, "HUKKATU", false);
        addPattern(PATTERN_MEISAI, ITIBUHUKKATU, "ITIBUHUKKATU", false);
        addPattern(PATTERN_MEISAI, KAIYAKU, "KAIYAKU", false);
        addPattern(PATTERN_MEISAI, PMENGOKAIYAKU, "PMENGOKAIYAKU", false);
        addPattern(PATTERN_MEISAI, KEIYAKUTORIKESI, "KEIYAKUTORIKESI", false);
        addPattern(PATTERN_MEISAI, SIBOU, "SIBOU", false);
        addPattern(PATTERN_MEISAI, KOUDOSYOUGAI, "KOUDOSYOUGAI", false);
        addPattern(PATTERN_MEISAI, MIKEIKAPHENKIN, "MIKEIKAPHENKIN", false);
        addPattern(PATTERN_MEISAI, TYOUSEI, "TYOUSEI", false);
        addPattern(PATTERN_MEISAI, CLGOFF, "CLGOFF", false);
        addPattern(PATTERN_MEISAI, KAIJO, "KAIJO", false);
        addPattern(PATTERN_MEISAI, SIBOUKAIJO, "SIBOUKAIJO", false);
        addPattern(PATTERN_MEISAI, MUKOU, "MUKOU", false);
        addPattern(PATTERN_MEISAI, TOKUYAKUMUKOU, "TOKUYAKUMUKOU", false);
        addPattern(PATTERN_MEISAI, MUKOU_1PMINYUUKIN, "MUKOU_1PMINYUUKIN", false);
        addPattern(PATTERN_MEISAI, MENSEKI, "MENSEKI", false);
        addPattern(PATTERN_MEISAI, PMEN, "PMEN", false);
        addPattern(PATTERN_MEISAI, HARAIMAN, "HARAIMAN", false);
        addPattern(PATTERN_MEISAI, IKAN, "IKAN", false);
        addPattern(PATTERN_MEISAI, MIJYUUTOU, "MIJYUUTOU", false);
        addPattern(PATTERN_MEISAI, HRIKAIHEN, "HRIKAIHEN", false);


        lock(C_TsrysyoriKbn.class);
    }

    private C_TsrysyoriKbn(String value) {
        super(value);
    }

    public static C_TsrysyoriKbn valueOf(String value) {
        return valueOf(C_TsrysyoriKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TsrysyoriKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TsrysyoriKbn.class, patternId, value);
    }
}
