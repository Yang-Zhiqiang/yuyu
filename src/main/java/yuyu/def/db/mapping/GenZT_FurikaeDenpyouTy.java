package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_FurikaeDenpyouTy;
import yuyu.def.db.id.PKZT_FurikaeDenpyouTy;
import yuyu.def.db.meta.GenQZT_FurikaeDenpyouTy;
import yuyu.def.db.meta.QZT_FurikaeDenpyouTy;

/**
 * 振替伝票テーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_FurikaeDenpyouTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_FurikaeDenpyouTy}</td><td colspan="3">振替伝票テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtykytkmksyoruicd ztykytkmksyoruicd}</td><td>（中継用）共通項目書類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykytkmktyouhyousksymd ztykytkmktyouhyousksymd}</td><td>（中継用）共通項目帳票作成年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykytkmksystemkbn ztykytkmksystemkbn}</td><td>（中継用）共通項目システム区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykytkmktorihikino ztykytkmktorihikino}</td><td>（中継用）共通項目取引番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykytkmktorihikinoedano ztykytkmktorihikinoedano}</td><td>（中継用）共通項目取引番号枝番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykytkmkseifukukbn ztykytkmkseifukukbn}</td><td>（中継用）共通項目正副区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykytkmkfuridenhassoukbn ztykytkmkfuridenhassoukbn}</td><td>（中継用）共通項目振替伝票用発送区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykytkmkyobi ztykytkmkyobi}</td><td>（中継用）共通項目予備項目</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysystemkbn ztysystemkbn}</td><td>（中継用）システム区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytorihikinoc8 ztytorihikinoc8}</td><td>（中継用）取引番号Ｃ８</td><td align="center">{@link PKZT_FurikaeDenpyouTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytorihikinoedano ztytorihikinoedano}</td><td>（中継用）取引番号枝番号</td><td align="center">{@link PKZT_FurikaeDenpyouTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjhikaeinjikm ztykjhikaeinjikm}</td><td>（中継用）漢字控印字項目</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytorihikiymdgengokbn ztytorihikiymdgengokbn}</td><td>（中継用）取引年月日元号区分</td><td align="center">{@link PKZT_FurikaeDenpyouTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytorihikinen ztytorihikinen}</td><td>（中継用）取引年</td><td align="center">{@link PKZT_FurikaeDenpyouTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytorihikituki ztytorihikituki}</td><td>（中継用）取引月</td><td align="center">{@link PKZT_FurikaeDenpyouTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytorihikibi ztytorihikibi}</td><td>（中継用）取引日</td><td align="center">{@link PKZT_FurikaeDenpyouTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykanjyoukbn ztykanjyoukbn}</td><td>（中継用）勘定区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykanjyoukbnnm ztykanjyoukbnnm}</td><td>（中継用）勘定区分名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjtantoukanm ztykjtantoukanm}</td><td>（中継用）漢字担当課名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjtantoucd ztykjtantoucd}</td><td>（中継用）漢字担当コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjsystemnm ztykjsystemnm}</td><td>（中継用）漢字システム名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykarikurikosikingaku ztykarikurikosikingaku}</td><td>（中継用）借方繰越金額</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykasikurikosikingaku ztykasikurikosikingaku}</td><td>（中継用）貸方繰越金額</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydenpyoukbnnm ztydenpyoukbnnm}</td><td>（中継用）伝票区分名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjkarikurikosigkhyjkm ztykjkarikurikosigkhyjkm}</td><td>（中継用）漢字借方繰越合計表示項目</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykarikurikosigkkingaku ztykarikurikosigkkingaku}</td><td>（中継用）借方繰越合計金額</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjkasikurikosigkhyjkm ztykjkasikurikosigkhyjkm}</td><td>（中継用）漢字貸方繰越合計表示項目</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykasikurikosigkkingaku ztykasikurikosigkkingaku}</td><td>（中継用）貸方繰越合計金額</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjtekiyou1 ztykjtekiyou1}</td><td>（中継用）漢字摘要１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjtekiyou2 ztykjtekiyou2}</td><td>（中継用）漢字摘要２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjtekiyou3 ztykjtekiyou3}</td><td>（中継用）漢字摘要３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjkarikanjyoukamokunm1 ztykjkarikanjyoukamokunm1}</td><td>（中継用）漢字借方勘定科目名１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjkasikanjyoukamokunm1 ztykjkasikanjyoukamokunm1}</td><td>（中継用）漢字貸方勘定科目名１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaritekiyoukm1 ztykaritekiyoukm1}</td><td>（中継用）借方摘要項目１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykarikingaku1 ztykarikingaku1}</td><td>（中継用）借方金額１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykasitekiyoukm1 ztykasitekiyoukm1}</td><td>（中継用）貸方摘要項目１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykasikingaku1 ztykasikingaku1}</td><td>（中継用）貸方金額１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjkaritekiyoukm1 ztykjkaritekiyoukm1}</td><td>（中継用）漢字借方摘要項目１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjkasitekiyoukm1 ztykjkasitekiyoukm1}</td><td>（中継用）漢字貸方摘要項目１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjkarikanjyoukamokunm2 ztykjkarikanjyoukamokunm2}</td><td>（中継用）漢字借方勘定科目名２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjkasikanjyoukamokunm2 ztykjkasikanjyoukamokunm2}</td><td>（中継用）漢字貸方勘定科目名２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaritekiyoukm2 ztykaritekiyoukm2}</td><td>（中継用）借方摘要項目２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykarikingaku2 ztykarikingaku2}</td><td>（中継用）借方金額２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykasitekiyoukm2 ztykasitekiyoukm2}</td><td>（中継用）貸方摘要項目２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykasikingaku2 ztykasikingaku2}</td><td>（中継用）貸方金額２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjkaritekiyoukm2 ztykjkaritekiyoukm2}</td><td>（中継用）漢字借方摘要項目２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjkasitekiyoukm2 ztykjkasitekiyoukm2}</td><td>（中継用）漢字貸方摘要項目２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjkarikanjyoukamokunm3 ztykjkarikanjyoukamokunm3}</td><td>（中継用）漢字借方勘定科目名３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjkasikanjyoukamokunm3 ztykjkasikanjyoukamokunm3}</td><td>（中継用）漢字貸方勘定科目名３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaritekiyoukm3 ztykaritekiyoukm3}</td><td>（中継用）借方摘要項目３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykarikingaku3 ztykarikingaku3}</td><td>（中継用）借方金額３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykasitekiyoukm3 ztykasitekiyoukm3}</td><td>（中継用）貸方摘要項目３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykasikingaku3 ztykasikingaku3}</td><td>（中継用）貸方金額３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjkaritekiyoukm3 ztykjkaritekiyoukm3}</td><td>（中継用）漢字借方摘要項目３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjkasitekiyoukm3 ztykjkasitekiyoukm3}</td><td>（中継用）漢字貸方摘要項目３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjkarikanjyoukamokunm4 ztykjkarikanjyoukamokunm4}</td><td>（中継用）漢字借方勘定科目名４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjkasikanjyoukamokunm4 ztykjkasikanjyoukamokunm4}</td><td>（中継用）漢字貸方勘定科目名４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykaritekiyoukm4 ztykaritekiyoukm4}</td><td>（中継用）借方摘要項目４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykarikingaku4 ztykarikingaku4}</td><td>（中継用）借方金額４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykasitekiyoukm4 ztykasitekiyoukm4}</td><td>（中継用）貸方摘要項目４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykasikingaku4 ztykasikingaku4}</td><td>（中継用）貸方金額４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjkaritekiyoukm4 ztykjkaritekiyoukm4}</td><td>（中継用）漢字借方摘要項目４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykjkasitekiyoukm4 ztykjkasitekiyoukm4}</td><td>（中継用）漢字貸方摘要項目４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_FurikaeDenpyouTy
 * @see     PKZT_FurikaeDenpyouTy
 * @see     QZT_FurikaeDenpyouTy
 * @see     GenQZT_FurikaeDenpyouTy
 */
@MappedSuperclass
@Table(name=GenZT_FurikaeDenpyouTy.TABLE_NAME)
@IdClass(value=PKZT_FurikaeDenpyouTy.class)
public abstract class GenZT_FurikaeDenpyouTy extends AbstractExDBEntity<ZT_FurikaeDenpyouTy, PKZT_FurikaeDenpyouTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_FurikaeDenpyouTy";
    public static final String ZTYKYTKMKSYORUICD        = "ztykytkmksyoruicd";
    public static final String ZTYKYTKMKTYOUHYOUSKSYMD  = "ztykytkmktyouhyousksymd";
    public static final String ZTYKYTKMKSYSTEMKBN       = "ztykytkmksystemkbn";
    public static final String ZTYKYTKMKTORIHIKINO      = "ztykytkmktorihikino";
    public static final String ZTYKYTKMKTORIHIKINOEDANO = "ztykytkmktorihikinoedano";
    public static final String ZTYKYTKMKSEIFUKUKBN      = "ztykytkmkseifukukbn";
    public static final String ZTYKYTKMKFURIDENHASSOUKBN = "ztykytkmkfuridenhassoukbn";
    public static final String ZTYKYTKMKYOBI            = "ztykytkmkyobi";
    public static final String ZTYSYSTEMKBN             = "ztysystemkbn";
    public static final String ZTYTORIHIKINOC8          = "ztytorihikinoc8";
    public static final String ZTYTORIHIKINOEDANO       = "ztytorihikinoedano";
    public static final String ZTYKJHIKAEINJIKM         = "ztykjhikaeinjikm";
    public static final String ZTYTORIHIKIYMDGENGOKBN   = "ztytorihikiymdgengokbn";
    public static final String ZTYTORIHIKINEN           = "ztytorihikinen";
    public static final String ZTYTORIHIKITUKI          = "ztytorihikituki";
    public static final String ZTYTORIHIKIBI            = "ztytorihikibi";
    public static final String ZTYKANJYOUKBN            = "ztykanjyoukbn";
    public static final String ZTYKANJYOUKBNNM          = "ztykanjyoukbnnm";
    public static final String ZTYKJTANTOUKANM          = "ztykjtantoukanm";
    public static final String ZTYKJTANTOUCD            = "ztykjtantoucd";
    public static final String ZTYKJSYSTEMNM            = "ztykjsystemnm";
    public static final String ZTYKARIKURIKOSIKINGAKU   = "ztykarikurikosikingaku";
    public static final String ZTYKASIKURIKOSIKINGAKU   = "ztykasikurikosikingaku";
    public static final String ZTYDENPYOUKBNNM          = "ztydenpyoukbnnm";
    public static final String ZTYKJKARIKURIKOSIGKHYJKM = "ztykjkarikurikosigkhyjkm";
    public static final String ZTYKARIKURIKOSIGKKINGAKU = "ztykarikurikosigkkingaku";
    public static final String ZTYKJKASIKURIKOSIGKHYJKM = "ztykjkasikurikosigkhyjkm";
    public static final String ZTYKASIKURIKOSIGKKINGAKU = "ztykasikurikosigkkingaku";
    public static final String ZTYKJTEKIYOU1            = "ztykjtekiyou1";
    public static final String ZTYKJTEKIYOU2            = "ztykjtekiyou2";
    public static final String ZTYKJTEKIYOU3            = "ztykjtekiyou3";
    public static final String ZTYKJKARIKANJYOUKAMOKUNM1 = "ztykjkarikanjyoukamokunm1";
    public static final String ZTYKJKASIKANJYOUKAMOKUNM1 = "ztykjkasikanjyoukamokunm1";
    public static final String ZTYKARITEKIYOUKM1        = "ztykaritekiyoukm1";
    public static final String ZTYKARIKINGAKU1          = "ztykarikingaku1";
    public static final String ZTYKASITEKIYOUKM1        = "ztykasitekiyoukm1";
    public static final String ZTYKASIKINGAKU1          = "ztykasikingaku1";
    public static final String ZTYKJKARITEKIYOUKM1      = "ztykjkaritekiyoukm1";
    public static final String ZTYKJKASITEKIYOUKM1      = "ztykjkasitekiyoukm1";
    public static final String ZTYKJKARIKANJYOUKAMOKUNM2 = "ztykjkarikanjyoukamokunm2";
    public static final String ZTYKJKASIKANJYOUKAMOKUNM2 = "ztykjkasikanjyoukamokunm2";
    public static final String ZTYKARITEKIYOUKM2        = "ztykaritekiyoukm2";
    public static final String ZTYKARIKINGAKU2          = "ztykarikingaku2";
    public static final String ZTYKASITEKIYOUKM2        = "ztykasitekiyoukm2";
    public static final String ZTYKASIKINGAKU2          = "ztykasikingaku2";
    public static final String ZTYKJKARITEKIYOUKM2      = "ztykjkaritekiyoukm2";
    public static final String ZTYKJKASITEKIYOUKM2      = "ztykjkasitekiyoukm2";
    public static final String ZTYKJKARIKANJYOUKAMOKUNM3 = "ztykjkarikanjyoukamokunm3";
    public static final String ZTYKJKASIKANJYOUKAMOKUNM3 = "ztykjkasikanjyoukamokunm3";
    public static final String ZTYKARITEKIYOUKM3        = "ztykaritekiyoukm3";
    public static final String ZTYKARIKINGAKU3          = "ztykarikingaku3";
    public static final String ZTYKASITEKIYOUKM3        = "ztykasitekiyoukm3";
    public static final String ZTYKASIKINGAKU3          = "ztykasikingaku3";
    public static final String ZTYKJKARITEKIYOUKM3      = "ztykjkaritekiyoukm3";
    public static final String ZTYKJKASITEKIYOUKM3      = "ztykjkasitekiyoukm3";
    public static final String ZTYKJKARIKANJYOUKAMOKUNM4 = "ztykjkarikanjyoukamokunm4";
    public static final String ZTYKJKASIKANJYOUKAMOKUNM4 = "ztykjkasikanjyoukamokunm4";
    public static final String ZTYKARITEKIYOUKM4        = "ztykaritekiyoukm4";
    public static final String ZTYKARIKINGAKU4          = "ztykarikingaku4";
    public static final String ZTYKASITEKIYOUKM4        = "ztykasitekiyoukm4";
    public static final String ZTYKASIKINGAKU4          = "ztykasikingaku4";
    public static final String ZTYKJKARITEKIYOUKM4      = "ztykjkaritekiyoukm4";
    public static final String ZTYKJKASITEKIYOUKM4      = "ztykjkasitekiyoukm4";

    private final PKZT_FurikaeDenpyouTy primaryKey;

    public GenZT_FurikaeDenpyouTy() {
        primaryKey = new PKZT_FurikaeDenpyouTy();
    }

    public GenZT_FurikaeDenpyouTy(
        String pZtytorihikinoc8,
        String pZtytorihikinoedano,
        String pZtytorihikiymdgengokbn,
        String pZtytorihikinen,
        String pZtytorihikituki,
        String pZtytorihikibi
    ) {
        primaryKey = new PKZT_FurikaeDenpyouTy(
            pZtytorihikinoc8,
            pZtytorihikinoedano,
            pZtytorihikiymdgengokbn,
            pZtytorihikinen,
            pZtytorihikituki,
            pZtytorihikibi
        );
    }

    @Transient
    @Override
    public PKZT_FurikaeDenpyouTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_FurikaeDenpyouTy> getMetaClass() {
        return QZT_FurikaeDenpyouTy.class;
    }

    private String ztykytkmksyoruicd;

    @Column(name=GenZT_FurikaeDenpyouTy.ZTYKYTKMKSYORUICD)
    public String getZtykytkmksyoruicd() {
        return ztykytkmksyoruicd;
    }

    public void setZtykytkmksyoruicd(String pZtykytkmksyoruicd) {
        ztykytkmksyoruicd = pZtykytkmksyoruicd;
    }

    private String ztykytkmktyouhyousksymd;

    @Column(name=GenZT_FurikaeDenpyouTy.ZTYKYTKMKTYOUHYOUSKSYMD)
    public String getZtykytkmktyouhyousksymd() {
        return ztykytkmktyouhyousksymd;
    }

    public void setZtykytkmktyouhyousksymd(String pZtykytkmktyouhyousksymd) {
        ztykytkmktyouhyousksymd = pZtykytkmktyouhyousksymd;
    }

    private String ztykytkmksystemkbn;

    @Column(name=GenZT_FurikaeDenpyouTy.ZTYKYTKMKSYSTEMKBN)
    public String getZtykytkmksystemkbn() {
        return ztykytkmksystemkbn;
    }

    public void setZtykytkmksystemkbn(String pZtykytkmksystemkbn) {
        ztykytkmksystemkbn = pZtykytkmksystemkbn;
    }

    private String ztykytkmktorihikino;

    @Column(name=GenZT_FurikaeDenpyouTy.ZTYKYTKMKTORIHIKINO)
    public String getZtykytkmktorihikino() {
        return ztykytkmktorihikino;
    }

    public void setZtykytkmktorihikino(String pZtykytkmktorihikino) {
        ztykytkmktorihikino = pZtykytkmktorihikino;
    }

    private String ztykytkmktorihikinoedano;

    @Column(name=GenZT_FurikaeDenpyouTy.ZTYKYTKMKTORIHIKINOEDANO)
    public String getZtykytkmktorihikinoedano() {
        return ztykytkmktorihikinoedano;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtykytkmktorihikinoedano(String pZtykytkmktorihikinoedano) {
        ztykytkmktorihikinoedano = pZtykytkmktorihikinoedano;
    }

    private String ztykytkmkseifukukbn;

    @Column(name=GenZT_FurikaeDenpyouTy.ZTYKYTKMKSEIFUKUKBN)
    public String getZtykytkmkseifukukbn() {
        return ztykytkmkseifukukbn;
    }

    public void setZtykytkmkseifukukbn(String pZtykytkmkseifukukbn) {
        ztykytkmkseifukukbn = pZtykytkmkseifukukbn;
    }

    private String ztykytkmkfuridenhassoukbn;

    @Column(name=GenZT_FurikaeDenpyouTy.ZTYKYTKMKFURIDENHASSOUKBN)
    public String getZtykytkmkfuridenhassoukbn() {
        return ztykytkmkfuridenhassoukbn;
    }

    public void setZtykytkmkfuridenhassoukbn(String pZtykytkmkfuridenhassoukbn) {
        ztykytkmkfuridenhassoukbn = pZtykytkmkfuridenhassoukbn;
    }

    private String ztykytkmkyobi;

    @Column(name=GenZT_FurikaeDenpyouTy.ZTYKYTKMKYOBI)
    public String getZtykytkmkyobi() {
        return ztykytkmkyobi;
    }

    public void setZtykytkmkyobi(String pZtykytkmkyobi) {
        ztykytkmkyobi = pZtykytkmkyobi;
    }

    private String ztysystemkbn;

    @Column(name=GenZT_FurikaeDenpyouTy.ZTYSYSTEMKBN)
    public String getZtysystemkbn() {
        return ztysystemkbn;
    }

    public void setZtysystemkbn(String pZtysystemkbn) {
        ztysystemkbn = pZtysystemkbn;
    }

    @Id
    @Column(name=GenZT_FurikaeDenpyouTy.ZTYTORIHIKINOC8)
    public String getZtytorihikinoc8() {
        return getPrimaryKey().getZtytorihikinoc8();
    }

    public void setZtytorihikinoc8(String pZtytorihikinoc8) {
        getPrimaryKey().setZtytorihikinoc8(pZtytorihikinoc8);
    }

    @Id
    @Column(name=GenZT_FurikaeDenpyouTy.ZTYTORIHIKINOEDANO)
    public String getZtytorihikinoedano() {
        return getPrimaryKey().getZtytorihikinoedano();
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtytorihikinoedano(String pZtytorihikinoedano) {
        getPrimaryKey().setZtytorihikinoedano(pZtytorihikinoedano);
    }

    private String ztykjhikaeinjikm;

    @Column(name=GenZT_FurikaeDenpyouTy.ZTYKJHIKAEINJIKM)
    public String getZtykjhikaeinjikm() {
        return ztykjhikaeinjikm;
    }

    public void setZtykjhikaeinjikm(String pZtykjhikaeinjikm) {
        ztykjhikaeinjikm = pZtykjhikaeinjikm;
    }

    @Id
    @Column(name=GenZT_FurikaeDenpyouTy.ZTYTORIHIKIYMDGENGOKBN)
    public String getZtytorihikiymdgengokbn() {
        return getPrimaryKey().getZtytorihikiymdgengokbn();
    }

    public void setZtytorihikiymdgengokbn(String pZtytorihikiymdgengokbn) {
        getPrimaryKey().setZtytorihikiymdgengokbn(pZtytorihikiymdgengokbn);
    }

    @Id
    @Column(name=GenZT_FurikaeDenpyouTy.ZTYTORIHIKINEN)
    public String getZtytorihikinen() {
        return getPrimaryKey().getZtytorihikinen();
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtytorihikinen(String pZtytorihikinen) {
        getPrimaryKey().setZtytorihikinen(pZtytorihikinen);
    }

    @Id
    @Column(name=GenZT_FurikaeDenpyouTy.ZTYTORIHIKITUKI)
    public String getZtytorihikituki() {
        return getPrimaryKey().getZtytorihikituki();
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtytorihikituki(String pZtytorihikituki) {
        getPrimaryKey().setZtytorihikituki(pZtytorihikituki);
    }

    @Id
    @Column(name=GenZT_FurikaeDenpyouTy.ZTYTORIHIKIBI)
    public String getZtytorihikibi() {
        return getPrimaryKey().getZtytorihikibi();
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZtytorihikibi(String pZtytorihikibi) {
        getPrimaryKey().setZtytorihikibi(pZtytorihikibi);
    }

    private String ztykanjyoukbn;

    @Column(name=GenZT_FurikaeDenpyouTy.ZTYKANJYOUKBN)
    public String getZtykanjyoukbn() {
        return ztykanjyoukbn;
    }

    public void setZtykanjyoukbn(String pZtykanjyoukbn) {
        ztykanjyoukbn = pZtykanjyoukbn;
    }

    private String ztykanjyoukbnnm;

    @Column(name=GenZT_FurikaeDenpyouTy.ZTYKANJYOUKBNNM)
    public String getZtykanjyoukbnnm() {
        return ztykanjyoukbnnm;
    }

    public void setZtykanjyoukbnnm(String pZtykanjyoukbnnm) {
        ztykanjyoukbnnm = pZtykanjyoukbnnm;
    }

    private String ztykjtantoukanm;

    @Column(name=GenZT_FurikaeDenpyouTy.ZTYKJTANTOUKANM)
    public String getZtykjtantoukanm() {
        return ztykjtantoukanm;
    }

    public void setZtykjtantoukanm(String pZtykjtantoukanm) {
        ztykjtantoukanm = pZtykjtantoukanm;
    }

    private String ztykjtantoucd;

    @Column(name=GenZT_FurikaeDenpyouTy.ZTYKJTANTOUCD)
    public String getZtykjtantoucd() {
        return ztykjtantoucd;
    }

    public void setZtykjtantoucd(String pZtykjtantoucd) {
        ztykjtantoucd = pZtykjtantoucd;
    }

    private String ztykjsystemnm;

    @Column(name=GenZT_FurikaeDenpyouTy.ZTYKJSYSTEMNM)
    public String getZtykjsystemnm() {
        return ztykjsystemnm;
    }

    public void setZtykjsystemnm(String pZtykjsystemnm) {
        ztykjsystemnm = pZtykjsystemnm;
    }

    private String ztykarikurikosikingaku;

    @Column(name=GenZT_FurikaeDenpyouTy.ZTYKARIKURIKOSIKINGAKU)
    public String getZtykarikurikosikingaku() {
        return ztykarikurikosikingaku;
    }

    @Padding(mode = "left", padChar = '0', length = 12)
    public void setZtykarikurikosikingaku(String pZtykarikurikosikingaku) {
        ztykarikurikosikingaku = pZtykarikurikosikingaku;
    }

    private String ztykasikurikosikingaku;

    @Column(name=GenZT_FurikaeDenpyouTy.ZTYKASIKURIKOSIKINGAKU)
    public String getZtykasikurikosikingaku() {
        return ztykasikurikosikingaku;
    }

    @Padding(mode = "left", padChar = '0', length = 12)
    public void setZtykasikurikosikingaku(String pZtykasikurikosikingaku) {
        ztykasikurikosikingaku = pZtykasikurikosikingaku;
    }

    private String ztydenpyoukbnnm;

    @Column(name=GenZT_FurikaeDenpyouTy.ZTYDENPYOUKBNNM)
    public String getZtydenpyoukbnnm() {
        return ztydenpyoukbnnm;
    }

    public void setZtydenpyoukbnnm(String pZtydenpyoukbnnm) {
        ztydenpyoukbnnm = pZtydenpyoukbnnm;
    }

    private String ztykjkarikurikosigkhyjkm;

    @Column(name=GenZT_FurikaeDenpyouTy.ZTYKJKARIKURIKOSIGKHYJKM)
    public String getZtykjkarikurikosigkhyjkm() {
        return ztykjkarikurikosigkhyjkm;
    }

    public void setZtykjkarikurikosigkhyjkm(String pZtykjkarikurikosigkhyjkm) {
        ztykjkarikurikosigkhyjkm = pZtykjkarikurikosigkhyjkm;
    }

    private String ztykarikurikosigkkingaku;

    @Column(name=GenZT_FurikaeDenpyouTy.ZTYKARIKURIKOSIGKKINGAKU)
    public String getZtykarikurikosigkkingaku() {
        return ztykarikurikosigkkingaku;
    }

    public void setZtykarikurikosigkkingaku(String pZtykarikurikosigkkingaku) {
        ztykarikurikosigkkingaku = pZtykarikurikosigkkingaku;
    }

    private String ztykjkasikurikosigkhyjkm;

    @Column(name=GenZT_FurikaeDenpyouTy.ZTYKJKASIKURIKOSIGKHYJKM)
    public String getZtykjkasikurikosigkhyjkm() {
        return ztykjkasikurikosigkhyjkm;
    }

    public void setZtykjkasikurikosigkhyjkm(String pZtykjkasikurikosigkhyjkm) {
        ztykjkasikurikosigkhyjkm = pZtykjkasikurikosigkhyjkm;
    }

    private String ztykasikurikosigkkingaku;

    @Column(name=GenZT_FurikaeDenpyouTy.ZTYKASIKURIKOSIGKKINGAKU)
    public String getZtykasikurikosigkkingaku() {
        return ztykasikurikosigkkingaku;
    }

    public void setZtykasikurikosigkkingaku(String pZtykasikurikosigkkingaku) {
        ztykasikurikosigkkingaku = pZtykasikurikosigkkingaku;
    }

    private String ztykjtekiyou1;

    @Column(name=GenZT_FurikaeDenpyouTy.ZTYKJTEKIYOU1)
    public String getZtykjtekiyou1() {
        return ztykjtekiyou1;
    }

    public void setZtykjtekiyou1(String pZtykjtekiyou1) {
        ztykjtekiyou1 = pZtykjtekiyou1;
    }

    private String ztykjtekiyou2;

    @Column(name=GenZT_FurikaeDenpyouTy.ZTYKJTEKIYOU2)
    public String getZtykjtekiyou2() {
        return ztykjtekiyou2;
    }

    public void setZtykjtekiyou2(String pZtykjtekiyou2) {
        ztykjtekiyou2 = pZtykjtekiyou2;
    }

    private String ztykjtekiyou3;

    @Column(name=GenZT_FurikaeDenpyouTy.ZTYKJTEKIYOU3)
    public String getZtykjtekiyou3() {
        return ztykjtekiyou3;
    }

    public void setZtykjtekiyou3(String pZtykjtekiyou3) {
        ztykjtekiyou3 = pZtykjtekiyou3;
    }

    private String ztykjkarikanjyoukamokunm1;

    @Column(name=GenZT_FurikaeDenpyouTy.ZTYKJKARIKANJYOUKAMOKUNM1)
    public String getZtykjkarikanjyoukamokunm1() {
        return ztykjkarikanjyoukamokunm1;
    }

    public void setZtykjkarikanjyoukamokunm1(String pZtykjkarikanjyoukamokunm1) {
        ztykjkarikanjyoukamokunm1 = pZtykjkarikanjyoukamokunm1;
    }

    private String ztykjkasikanjyoukamokunm1;

    @Column(name=GenZT_FurikaeDenpyouTy.ZTYKJKASIKANJYOUKAMOKUNM1)
    public String getZtykjkasikanjyoukamokunm1() {
        return ztykjkasikanjyoukamokunm1;
    }

    public void setZtykjkasikanjyoukamokunm1(String pZtykjkasikanjyoukamokunm1) {
        ztykjkasikanjyoukamokunm1 = pZtykjkasikanjyoukamokunm1;
    }

    private String ztykaritekiyoukm1;

    @Column(name=GenZT_FurikaeDenpyouTy.ZTYKARITEKIYOUKM1)
    public String getZtykaritekiyoukm1() {
        return ztykaritekiyoukm1;
    }

    public void setZtykaritekiyoukm1(String pZtykaritekiyoukm1) {
        ztykaritekiyoukm1 = pZtykaritekiyoukm1;
    }

    private String ztykarikingaku1;

    @Column(name=GenZT_FurikaeDenpyouTy.ZTYKARIKINGAKU1)
    public String getZtykarikingaku1() {
        return ztykarikingaku1;
    }

    @Padding(mode = "left", padChar = '0', length = 12)
    public void setZtykarikingaku1(String pZtykarikingaku1) {
        ztykarikingaku1 = pZtykarikingaku1;
    }

    private String ztykasitekiyoukm1;

    @Column(name=GenZT_FurikaeDenpyouTy.ZTYKASITEKIYOUKM1)
    public String getZtykasitekiyoukm1() {
        return ztykasitekiyoukm1;
    }

    public void setZtykasitekiyoukm1(String pZtykasitekiyoukm1) {
        ztykasitekiyoukm1 = pZtykasitekiyoukm1;
    }

    private String ztykasikingaku1;

    @Column(name=GenZT_FurikaeDenpyouTy.ZTYKASIKINGAKU1)
    public String getZtykasikingaku1() {
        return ztykasikingaku1;
    }

    @Padding(mode = "left", padChar = '0', length = 12)
    public void setZtykasikingaku1(String pZtykasikingaku1) {
        ztykasikingaku1 = pZtykasikingaku1;
    }

    private String ztykjkaritekiyoukm1;

    @Column(name=GenZT_FurikaeDenpyouTy.ZTYKJKARITEKIYOUKM1)
    public String getZtykjkaritekiyoukm1() {
        return ztykjkaritekiyoukm1;
    }

    public void setZtykjkaritekiyoukm1(String pZtykjkaritekiyoukm1) {
        ztykjkaritekiyoukm1 = pZtykjkaritekiyoukm1;
    }

    private String ztykjkasitekiyoukm1;

    @Column(name=GenZT_FurikaeDenpyouTy.ZTYKJKASITEKIYOUKM1)
    public String getZtykjkasitekiyoukm1() {
        return ztykjkasitekiyoukm1;
    }

    public void setZtykjkasitekiyoukm1(String pZtykjkasitekiyoukm1) {
        ztykjkasitekiyoukm1 = pZtykjkasitekiyoukm1;
    }

    private String ztykjkarikanjyoukamokunm2;

    @Column(name=GenZT_FurikaeDenpyouTy.ZTYKJKARIKANJYOUKAMOKUNM2)
    public String getZtykjkarikanjyoukamokunm2() {
        return ztykjkarikanjyoukamokunm2;
    }

    public void setZtykjkarikanjyoukamokunm2(String pZtykjkarikanjyoukamokunm2) {
        ztykjkarikanjyoukamokunm2 = pZtykjkarikanjyoukamokunm2;
    }

    private String ztykjkasikanjyoukamokunm2;

    @Column(name=GenZT_FurikaeDenpyouTy.ZTYKJKASIKANJYOUKAMOKUNM2)
    public String getZtykjkasikanjyoukamokunm2() {
        return ztykjkasikanjyoukamokunm2;
    }

    public void setZtykjkasikanjyoukamokunm2(String pZtykjkasikanjyoukamokunm2) {
        ztykjkasikanjyoukamokunm2 = pZtykjkasikanjyoukamokunm2;
    }

    private String ztykaritekiyoukm2;

    @Column(name=GenZT_FurikaeDenpyouTy.ZTYKARITEKIYOUKM2)
    public String getZtykaritekiyoukm2() {
        return ztykaritekiyoukm2;
    }

    public void setZtykaritekiyoukm2(String pZtykaritekiyoukm2) {
        ztykaritekiyoukm2 = pZtykaritekiyoukm2;
    }

    private String ztykarikingaku2;

    @Column(name=GenZT_FurikaeDenpyouTy.ZTYKARIKINGAKU2)
    public String getZtykarikingaku2() {
        return ztykarikingaku2;
    }

    @Padding(mode = "left", padChar = '0', length = 12)
    public void setZtykarikingaku2(String pZtykarikingaku2) {
        ztykarikingaku2 = pZtykarikingaku2;
    }

    private String ztykasitekiyoukm2;

    @Column(name=GenZT_FurikaeDenpyouTy.ZTYKASITEKIYOUKM2)
    public String getZtykasitekiyoukm2() {
        return ztykasitekiyoukm2;
    }

    public void setZtykasitekiyoukm2(String pZtykasitekiyoukm2) {
        ztykasitekiyoukm2 = pZtykasitekiyoukm2;
    }

    private String ztykasikingaku2;

    @Column(name=GenZT_FurikaeDenpyouTy.ZTYKASIKINGAKU2)
    public String getZtykasikingaku2() {
        return ztykasikingaku2;
    }

    @Padding(mode = "left", padChar = '0', length = 12)
    public void setZtykasikingaku2(String pZtykasikingaku2) {
        ztykasikingaku2 = pZtykasikingaku2;
    }

    private String ztykjkaritekiyoukm2;

    @Column(name=GenZT_FurikaeDenpyouTy.ZTYKJKARITEKIYOUKM2)
    public String getZtykjkaritekiyoukm2() {
        return ztykjkaritekiyoukm2;
    }

    public void setZtykjkaritekiyoukm2(String pZtykjkaritekiyoukm2) {
        ztykjkaritekiyoukm2 = pZtykjkaritekiyoukm2;
    }

    private String ztykjkasitekiyoukm2;

    @Column(name=GenZT_FurikaeDenpyouTy.ZTYKJKASITEKIYOUKM2)
    public String getZtykjkasitekiyoukm2() {
        return ztykjkasitekiyoukm2;
    }

    public void setZtykjkasitekiyoukm2(String pZtykjkasitekiyoukm2) {
        ztykjkasitekiyoukm2 = pZtykjkasitekiyoukm2;
    }

    private String ztykjkarikanjyoukamokunm3;

    @Column(name=GenZT_FurikaeDenpyouTy.ZTYKJKARIKANJYOUKAMOKUNM3)
    public String getZtykjkarikanjyoukamokunm3() {
        return ztykjkarikanjyoukamokunm3;
    }

    public void setZtykjkarikanjyoukamokunm3(String pZtykjkarikanjyoukamokunm3) {
        ztykjkarikanjyoukamokunm3 = pZtykjkarikanjyoukamokunm3;
    }

    private String ztykjkasikanjyoukamokunm3;

    @Column(name=GenZT_FurikaeDenpyouTy.ZTYKJKASIKANJYOUKAMOKUNM3)
    public String getZtykjkasikanjyoukamokunm3() {
        return ztykjkasikanjyoukamokunm3;
    }

    public void setZtykjkasikanjyoukamokunm3(String pZtykjkasikanjyoukamokunm3) {
        ztykjkasikanjyoukamokunm3 = pZtykjkasikanjyoukamokunm3;
    }

    private String ztykaritekiyoukm3;

    @Column(name=GenZT_FurikaeDenpyouTy.ZTYKARITEKIYOUKM3)
    public String getZtykaritekiyoukm3() {
        return ztykaritekiyoukm3;
    }

    public void setZtykaritekiyoukm3(String pZtykaritekiyoukm3) {
        ztykaritekiyoukm3 = pZtykaritekiyoukm3;
    }

    private String ztykarikingaku3;

    @Column(name=GenZT_FurikaeDenpyouTy.ZTYKARIKINGAKU3)
    public String getZtykarikingaku3() {
        return ztykarikingaku3;
    }

    @Padding(mode = "left", padChar = '0', length = 12)
    public void setZtykarikingaku3(String pZtykarikingaku3) {
        ztykarikingaku3 = pZtykarikingaku3;
    }

    private String ztykasitekiyoukm3;

    @Column(name=GenZT_FurikaeDenpyouTy.ZTYKASITEKIYOUKM3)
    public String getZtykasitekiyoukm3() {
        return ztykasitekiyoukm3;
    }

    public void setZtykasitekiyoukm3(String pZtykasitekiyoukm3) {
        ztykasitekiyoukm3 = pZtykasitekiyoukm3;
    }

    private String ztykasikingaku3;

    @Column(name=GenZT_FurikaeDenpyouTy.ZTYKASIKINGAKU3)
    public String getZtykasikingaku3() {
        return ztykasikingaku3;
    }

    @Padding(mode = "left", padChar = '0', length = 12)
    public void setZtykasikingaku3(String pZtykasikingaku3) {
        ztykasikingaku3 = pZtykasikingaku3;
    }

    private String ztykjkaritekiyoukm3;

    @Column(name=GenZT_FurikaeDenpyouTy.ZTYKJKARITEKIYOUKM3)
    public String getZtykjkaritekiyoukm3() {
        return ztykjkaritekiyoukm3;
    }

    public void setZtykjkaritekiyoukm3(String pZtykjkaritekiyoukm3) {
        ztykjkaritekiyoukm3 = pZtykjkaritekiyoukm3;
    }

    private String ztykjkasitekiyoukm3;

    @Column(name=GenZT_FurikaeDenpyouTy.ZTYKJKASITEKIYOUKM3)
    public String getZtykjkasitekiyoukm3() {
        return ztykjkasitekiyoukm3;
    }

    public void setZtykjkasitekiyoukm3(String pZtykjkasitekiyoukm3) {
        ztykjkasitekiyoukm3 = pZtykjkasitekiyoukm3;
    }

    private String ztykjkarikanjyoukamokunm4;

    @Column(name=GenZT_FurikaeDenpyouTy.ZTYKJKARIKANJYOUKAMOKUNM4)
    public String getZtykjkarikanjyoukamokunm4() {
        return ztykjkarikanjyoukamokunm4;
    }

    public void setZtykjkarikanjyoukamokunm4(String pZtykjkarikanjyoukamokunm4) {
        ztykjkarikanjyoukamokunm4 = pZtykjkarikanjyoukamokunm4;
    }

    private String ztykjkasikanjyoukamokunm4;

    @Column(name=GenZT_FurikaeDenpyouTy.ZTYKJKASIKANJYOUKAMOKUNM4)
    public String getZtykjkasikanjyoukamokunm4() {
        return ztykjkasikanjyoukamokunm4;
    }

    public void setZtykjkasikanjyoukamokunm4(String pZtykjkasikanjyoukamokunm4) {
        ztykjkasikanjyoukamokunm4 = pZtykjkasikanjyoukamokunm4;
    }

    private String ztykaritekiyoukm4;

    @Column(name=GenZT_FurikaeDenpyouTy.ZTYKARITEKIYOUKM4)
    public String getZtykaritekiyoukm4() {
        return ztykaritekiyoukm4;
    }

    public void setZtykaritekiyoukm4(String pZtykaritekiyoukm4) {
        ztykaritekiyoukm4 = pZtykaritekiyoukm4;
    }

    private String ztykarikingaku4;

    @Column(name=GenZT_FurikaeDenpyouTy.ZTYKARIKINGAKU4)
    public String getZtykarikingaku4() {
        return ztykarikingaku4;
    }

    @Padding(mode = "left", padChar = '0', length = 12)
    public void setZtykarikingaku4(String pZtykarikingaku4) {
        ztykarikingaku4 = pZtykarikingaku4;
    }

    private String ztykasitekiyoukm4;

    @Column(name=GenZT_FurikaeDenpyouTy.ZTYKASITEKIYOUKM4)
    public String getZtykasitekiyoukm4() {
        return ztykasitekiyoukm4;
    }

    public void setZtykasitekiyoukm4(String pZtykasitekiyoukm4) {
        ztykasitekiyoukm4 = pZtykasitekiyoukm4;
    }

    private String ztykasikingaku4;

    @Column(name=GenZT_FurikaeDenpyouTy.ZTYKASIKINGAKU4)
    public String getZtykasikingaku4() {
        return ztykasikingaku4;
    }

    @Padding(mode = "left", padChar = '0', length = 12)
    public void setZtykasikingaku4(String pZtykasikingaku4) {
        ztykasikingaku4 = pZtykasikingaku4;
    }

    private String ztykjkaritekiyoukm4;

    @Column(name=GenZT_FurikaeDenpyouTy.ZTYKJKARITEKIYOUKM4)
    public String getZtykjkaritekiyoukm4() {
        return ztykjkaritekiyoukm4;
    }

    public void setZtykjkaritekiyoukm4(String pZtykjkaritekiyoukm4) {
        ztykjkaritekiyoukm4 = pZtykjkaritekiyoukm4;
    }

    private String ztykjkasitekiyoukm4;

    @Column(name=GenZT_FurikaeDenpyouTy.ZTYKJKASITEKIYOUKM4)
    public String getZtykjkasitekiyoukm4() {
        return ztykjkasitekiyoukm4;
    }

    public void setZtykjkasitekiyoukm4(String pZtykjkasitekiyoukm4) {
        ztykjkasitekiyoukm4 = pZtykjkasitekiyoukm4;
    }
}
