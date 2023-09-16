package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_SkKsnHurikaeRn;
import yuyu.def.db.id.PKZT_SkKsnHurikaeRn;
import yuyu.def.db.meta.GenQZT_SkKsnHurikaeRn;
import yuyu.def.db.meta.QZT_SkKsnHurikaeRn;

/**
 * 新契約決算用振替伝票テーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_SkKsnHurikaeRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SkKsnHurikaeRn}</td><td colspan="3">新契約決算用振替伝票テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnkytkmksyoruicd zrnkytkmksyoruicd}</td><td>（連携用）共通項目書類コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkytkmktyouhyousksymd zrnkytkmktyouhyousksymd}</td><td>（連携用）共通項目帳票作成年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkytkmksystemkbn zrnkytkmksystemkbn}</td><td>（連携用）共通項目システム区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkytkmktorihikino zrnkytkmktorihikino}</td><td>（連携用）共通項目取引番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkytkmktorihikinoedano zrnkytkmktorihikinoedano}</td><td>（連携用）共通項目取引番号枝番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkytkmkseifukukbn zrnkytkmkseifukukbn}</td><td>（連携用）共通項目正副区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkytkmkfuridenhassoukbn zrnkytkmkfuridenhassoukbn}</td><td>（連携用）共通項目振替伝票用発送区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkytkmkyobi zrnkytkmkyobi}</td><td>（連携用）共通項目予備項目</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsystemkbn zrnsystemkbn}</td><td>（連携用）システム区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntorihikinoc8 zrntorihikinoc8}</td><td>（連携用）取引番号Ｃ８</td><td align="center">{@link PKZT_SkKsnHurikaeRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntorihikinoedano zrntorihikinoedano}</td><td>（連携用）取引番号枝番号</td><td align="center">{@link PKZT_SkKsnHurikaeRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjhikaeinjikm zrnkjhikaeinjikm}</td><td>（連携用）漢字控印字項目</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntorihikiymdgengokbn zrntorihikiymdgengokbn}</td><td>（連携用）取引年月日元号区分</td><td align="center">{@link PKZT_SkKsnHurikaeRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntorihikinen zrntorihikinen}</td><td>（連携用）取引年</td><td align="center">{@link PKZT_SkKsnHurikaeRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntorihikituki zrntorihikituki}</td><td>（連携用）取引月</td><td align="center">{@link PKZT_SkKsnHurikaeRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntorihikibi zrntorihikibi}</td><td>（連携用）取引日</td><td align="center">{@link PKZT_SkKsnHurikaeRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkanjyoukbn zrnkanjyoukbn}</td><td>（連携用）勘定区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkanjyoukbnnm zrnkanjyoukbnnm}</td><td>（連携用）勘定区分名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjtantoukanm zrnkjtantoukanm}</td><td>（連携用）漢字担当課名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjtantoucd zrnkjtantoucd}</td><td>（連携用）漢字担当コード</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjsystemnm zrnkjsystemnm}</td><td>（連携用）漢字システム名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkarikurikosikingaku zrnkarikurikosikingaku}</td><td>（連携用）借方繰越金額</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkasikurikosikingaku zrnkasikurikosikingaku}</td><td>（連携用）貸方繰越金額</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndenpyoukbnnm zrndenpyoukbnnm}</td><td>（連携用）伝票区分名</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjkarikurikosigkhyjkm zrnkjkarikurikosigkhyjkm}</td><td>（連携用）漢字借方繰越合計表示項目</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkarikurikosigkkingaku zrnkarikurikosigkkingaku}</td><td>（連携用）借方繰越合計金額</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjkasikurikosigkhyjkm zrnkjkasikurikosigkhyjkm}</td><td>（連携用）漢字貸方繰越合計表示項目</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkasikurikosigkkingaku zrnkasikurikosigkkingaku}</td><td>（連携用）貸方繰越合計金額</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjtekiyou1 zrnkjtekiyou1}</td><td>（連携用）漢字摘要１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjtekiyou2 zrnkjtekiyou2}</td><td>（連携用）漢字摘要２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjtekiyou3 zrnkjtekiyou3}</td><td>（連携用）漢字摘要３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjkarikanjyoukamokunm1 zrnkjkarikanjyoukamokunm1}</td><td>（連携用）漢字借方勘定科目名１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjkasikanjyoukamokunm1 zrnkjkasikanjyoukamokunm1}</td><td>（連携用）漢字貸方勘定科目名１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaritekiyoukm1 zrnkaritekiyoukm1}</td><td>（連携用）借方摘要項目１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkarikingaku1 zrnkarikingaku1}</td><td>（連携用）借方金額１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkasitekiyoukm1 zrnkasitekiyoukm1}</td><td>（連携用）貸方摘要項目１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkasikingaku1 zrnkasikingaku1}</td><td>（連携用）貸方金額１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjkaritekiyoukm1 zrnkjkaritekiyoukm1}</td><td>（連携用）漢字借方摘要項目１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjkasitekiyoukm1 zrnkjkasitekiyoukm1}</td><td>（連携用）漢字貸方摘要項目１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjkarikanjyoukamokunm2 zrnkjkarikanjyoukamokunm2}</td><td>（連携用）漢字借方勘定科目名２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjkasikanjyoukamokunm2 zrnkjkasikanjyoukamokunm2}</td><td>（連携用）漢字貸方勘定科目名２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaritekiyoukm2 zrnkaritekiyoukm2}</td><td>（連携用）借方摘要項目２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkarikingaku2 zrnkarikingaku2}</td><td>（連携用）借方金額２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkasitekiyoukm2 zrnkasitekiyoukm2}</td><td>（連携用）貸方摘要項目２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkasikingaku2 zrnkasikingaku2}</td><td>（連携用）貸方金額２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjkaritekiyoukm2 zrnkjkaritekiyoukm2}</td><td>（連携用）漢字借方摘要項目２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjkasitekiyoukm2 zrnkjkasitekiyoukm2}</td><td>（連携用）漢字貸方摘要項目２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjkarikanjyoukamokunm3 zrnkjkarikanjyoukamokunm3}</td><td>（連携用）漢字借方勘定科目名３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjkasikanjyoukamokunm3 zrnkjkasikanjyoukamokunm3}</td><td>（連携用）漢字貸方勘定科目名３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaritekiyoukm3 zrnkaritekiyoukm3}</td><td>（連携用）借方摘要項目３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkarikingaku3 zrnkarikingaku3}</td><td>（連携用）借方金額３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkasitekiyoukm3 zrnkasitekiyoukm3}</td><td>（連携用）貸方摘要項目３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkasikingaku3 zrnkasikingaku3}</td><td>（連携用）貸方金額３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjkaritekiyoukm3 zrnkjkaritekiyoukm3}</td><td>（連携用）漢字借方摘要項目３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjkasitekiyoukm3 zrnkjkasitekiyoukm3}</td><td>（連携用）漢字貸方摘要項目３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjkarikanjyoukamokunm4 zrnkjkarikanjyoukamokunm4}</td><td>（連携用）漢字借方勘定科目名４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjkasikanjyoukamokunm4 zrnkjkasikanjyoukamokunm4}</td><td>（連携用）漢字貸方勘定科目名４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkaritekiyoukm4 zrnkaritekiyoukm4}</td><td>（連携用）借方摘要項目４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkarikingaku4 zrnkarikingaku4}</td><td>（連携用）借方金額４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkasitekiyoukm4 zrnkasitekiyoukm4}</td><td>（連携用）貸方摘要項目４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkasikingaku4 zrnkasikingaku4}</td><td>（連携用）貸方金額４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjkaritekiyoukm4 zrnkjkaritekiyoukm4}</td><td>（連携用）漢字借方摘要項目４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkjkasitekiyoukm4 zrnkjkasitekiyoukm4}</td><td>（連携用）漢字貸方摘要項目４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 * </table>
 * @see     ZT_SkKsnHurikaeRn
 * @see     PKZT_SkKsnHurikaeRn
 * @see     QZT_SkKsnHurikaeRn
 * @see     GenQZT_SkKsnHurikaeRn
 */
@MappedSuperclass
@Table(name=GenZT_SkKsnHurikaeRn.TABLE_NAME)
@IdClass(value=PKZT_SkKsnHurikaeRn.class)
public abstract class GenZT_SkKsnHurikaeRn extends AbstractExDBEntityForZDB<ZT_SkKsnHurikaeRn, PKZT_SkKsnHurikaeRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SkKsnHurikaeRn";
    public static final String ZRNKYTKMKSYORUICD        = "zrnkytkmksyoruicd";
    public static final String ZRNKYTKMKTYOUHYOUSKSYMD  = "zrnkytkmktyouhyousksymd";
    public static final String ZRNKYTKMKSYSTEMKBN       = "zrnkytkmksystemkbn";
    public static final String ZRNKYTKMKTORIHIKINO      = "zrnkytkmktorihikino";
    public static final String ZRNKYTKMKTORIHIKINOEDANO = "zrnkytkmktorihikinoedano";
    public static final String ZRNKYTKMKSEIFUKUKBN      = "zrnkytkmkseifukukbn";
    public static final String ZRNKYTKMKFURIDENHASSOUKBN = "zrnkytkmkfuridenhassoukbn";
    public static final String ZRNKYTKMKYOBI            = "zrnkytkmkyobi";
    public static final String ZRNSYSTEMKBN             = "zrnsystemkbn";
    public static final String ZRNTORIHIKINOC8          = "zrntorihikinoc8";
    public static final String ZRNTORIHIKINOEDANO       = "zrntorihikinoedano";
    public static final String ZRNKJHIKAEINJIKM         = "zrnkjhikaeinjikm";
    public static final String ZRNTORIHIKIYMDGENGOKBN   = "zrntorihikiymdgengokbn";
    public static final String ZRNTORIHIKINEN           = "zrntorihikinen";
    public static final String ZRNTORIHIKITUKI          = "zrntorihikituki";
    public static final String ZRNTORIHIKIBI            = "zrntorihikibi";
    public static final String ZRNKANJYOUKBN            = "zrnkanjyoukbn";
    public static final String ZRNKANJYOUKBNNM          = "zrnkanjyoukbnnm";
    public static final String ZRNKJTANTOUKANM          = "zrnkjtantoukanm";
    public static final String ZRNKJTANTOUCD            = "zrnkjtantoucd";
    public static final String ZRNKJSYSTEMNM            = "zrnkjsystemnm";
    public static final String ZRNKARIKURIKOSIKINGAKU   = "zrnkarikurikosikingaku";
    public static final String ZRNKASIKURIKOSIKINGAKU   = "zrnkasikurikosikingaku";
    public static final String ZRNDENPYOUKBNNM          = "zrndenpyoukbnnm";
    public static final String ZRNKJKARIKURIKOSIGKHYJKM = "zrnkjkarikurikosigkhyjkm";
    public static final String ZRNKARIKURIKOSIGKKINGAKU = "zrnkarikurikosigkkingaku";
    public static final String ZRNKJKASIKURIKOSIGKHYJKM = "zrnkjkasikurikosigkhyjkm";
    public static final String ZRNKASIKURIKOSIGKKINGAKU = "zrnkasikurikosigkkingaku";
    public static final String ZRNKJTEKIYOU1            = "zrnkjtekiyou1";
    public static final String ZRNKJTEKIYOU2            = "zrnkjtekiyou2";
    public static final String ZRNKJTEKIYOU3            = "zrnkjtekiyou3";
    public static final String ZRNKJKARIKANJYOUKAMOKUNM1 = "zrnkjkarikanjyoukamokunm1";
    public static final String ZRNKJKASIKANJYOUKAMOKUNM1 = "zrnkjkasikanjyoukamokunm1";
    public static final String ZRNKARITEKIYOUKM1        = "zrnkaritekiyoukm1";
    public static final String ZRNKARIKINGAKU1          = "zrnkarikingaku1";
    public static final String ZRNKASITEKIYOUKM1        = "zrnkasitekiyoukm1";
    public static final String ZRNKASIKINGAKU1          = "zrnkasikingaku1";
    public static final String ZRNKJKARITEKIYOUKM1      = "zrnkjkaritekiyoukm1";
    public static final String ZRNKJKASITEKIYOUKM1      = "zrnkjkasitekiyoukm1";
    public static final String ZRNKJKARIKANJYOUKAMOKUNM2 = "zrnkjkarikanjyoukamokunm2";
    public static final String ZRNKJKASIKANJYOUKAMOKUNM2 = "zrnkjkasikanjyoukamokunm2";
    public static final String ZRNKARITEKIYOUKM2        = "zrnkaritekiyoukm2";
    public static final String ZRNKARIKINGAKU2          = "zrnkarikingaku2";
    public static final String ZRNKASITEKIYOUKM2        = "zrnkasitekiyoukm2";
    public static final String ZRNKASIKINGAKU2          = "zrnkasikingaku2";
    public static final String ZRNKJKARITEKIYOUKM2      = "zrnkjkaritekiyoukm2";
    public static final String ZRNKJKASITEKIYOUKM2      = "zrnkjkasitekiyoukm2";
    public static final String ZRNKJKARIKANJYOUKAMOKUNM3 = "zrnkjkarikanjyoukamokunm3";
    public static final String ZRNKJKASIKANJYOUKAMOKUNM3 = "zrnkjkasikanjyoukamokunm3";
    public static final String ZRNKARITEKIYOUKM3        = "zrnkaritekiyoukm3";
    public static final String ZRNKARIKINGAKU3          = "zrnkarikingaku3";
    public static final String ZRNKASITEKIYOUKM3        = "zrnkasitekiyoukm3";
    public static final String ZRNKASIKINGAKU3          = "zrnkasikingaku3";
    public static final String ZRNKJKARITEKIYOUKM3      = "zrnkjkaritekiyoukm3";
    public static final String ZRNKJKASITEKIYOUKM3      = "zrnkjkasitekiyoukm3";
    public static final String ZRNKJKARIKANJYOUKAMOKUNM4 = "zrnkjkarikanjyoukamokunm4";
    public static final String ZRNKJKASIKANJYOUKAMOKUNM4 = "zrnkjkasikanjyoukamokunm4";
    public static final String ZRNKARITEKIYOUKM4        = "zrnkaritekiyoukm4";
    public static final String ZRNKARIKINGAKU4          = "zrnkarikingaku4";
    public static final String ZRNKASITEKIYOUKM4        = "zrnkasitekiyoukm4";
    public static final String ZRNKASIKINGAKU4          = "zrnkasikingaku4";
    public static final String ZRNKJKARITEKIYOUKM4      = "zrnkjkaritekiyoukm4";
    public static final String ZRNKJKASITEKIYOUKM4      = "zrnkjkasitekiyoukm4";

    private final PKZT_SkKsnHurikaeRn primaryKey;

    public GenZT_SkKsnHurikaeRn() {
        primaryKey = new PKZT_SkKsnHurikaeRn();
    }

    public GenZT_SkKsnHurikaeRn(
        String pZrntorihikinoc8,
        String pZrntorihikinoedano,
        String pZrntorihikiymdgengokbn,
        String pZrntorihikinen,
        String pZrntorihikituki,
        String pZrntorihikibi
    ) {
        primaryKey = new PKZT_SkKsnHurikaeRn(
            pZrntorihikinoc8,
            pZrntorihikinoedano,
            pZrntorihikiymdgengokbn,
            pZrntorihikinen,
            pZrntorihikituki,
            pZrntorihikibi
        );
    }

    @Transient
    @Override
    public PKZT_SkKsnHurikaeRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SkKsnHurikaeRn> getMetaClass() {
        return QZT_SkKsnHurikaeRn.class;
    }

    private String zrnkytkmksyoruicd;

    @Column(name=GenZT_SkKsnHurikaeRn.ZRNKYTKMKSYORUICD)
    public String getZrnkytkmksyoruicd() {
        return zrnkytkmksyoruicd;
    }

    public void setZrnkytkmksyoruicd(String pZrnkytkmksyoruicd) {
        zrnkytkmksyoruicd = pZrnkytkmksyoruicd;
    }

    private String zrnkytkmktyouhyousksymd;

    @Column(name=GenZT_SkKsnHurikaeRn.ZRNKYTKMKTYOUHYOUSKSYMD)
    public String getZrnkytkmktyouhyousksymd() {
        return zrnkytkmktyouhyousksymd;
    }

    public void setZrnkytkmktyouhyousksymd(String pZrnkytkmktyouhyousksymd) {
        zrnkytkmktyouhyousksymd = pZrnkytkmktyouhyousksymd;
    }

    private String zrnkytkmksystemkbn;

    @Column(name=GenZT_SkKsnHurikaeRn.ZRNKYTKMKSYSTEMKBN)
    public String getZrnkytkmksystemkbn() {
        return zrnkytkmksystemkbn;
    }

    public void setZrnkytkmksystemkbn(String pZrnkytkmksystemkbn) {
        zrnkytkmksystemkbn = pZrnkytkmksystemkbn;
    }

    private String zrnkytkmktorihikino;

    @Column(name=GenZT_SkKsnHurikaeRn.ZRNKYTKMKTORIHIKINO)
    public String getZrnkytkmktorihikino() {
        return zrnkytkmktorihikino;
    }

    public void setZrnkytkmktorihikino(String pZrnkytkmktorihikino) {
        zrnkytkmktorihikino = pZrnkytkmktorihikino;
    }

    private String zrnkytkmktorihikinoedano;

    @Column(name=GenZT_SkKsnHurikaeRn.ZRNKYTKMKTORIHIKINOEDANO)
    public String getZrnkytkmktorihikinoedano() {
        return zrnkytkmktorihikinoedano;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnkytkmktorihikinoedano(String pZrnkytkmktorihikinoedano) {
        zrnkytkmktorihikinoedano = pZrnkytkmktorihikinoedano;
    }

    private String zrnkytkmkseifukukbn;

    @Column(name=GenZT_SkKsnHurikaeRn.ZRNKYTKMKSEIFUKUKBN)
    public String getZrnkytkmkseifukukbn() {
        return zrnkytkmkseifukukbn;
    }

    public void setZrnkytkmkseifukukbn(String pZrnkytkmkseifukukbn) {
        zrnkytkmkseifukukbn = pZrnkytkmkseifukukbn;
    }

    private String zrnkytkmkfuridenhassoukbn;

    @Column(name=GenZT_SkKsnHurikaeRn.ZRNKYTKMKFURIDENHASSOUKBN)
    public String getZrnkytkmkfuridenhassoukbn() {
        return zrnkytkmkfuridenhassoukbn;
    }

    public void setZrnkytkmkfuridenhassoukbn(String pZrnkytkmkfuridenhassoukbn) {
        zrnkytkmkfuridenhassoukbn = pZrnkytkmkfuridenhassoukbn;
    }

    private String zrnkytkmkyobi;

    @Column(name=GenZT_SkKsnHurikaeRn.ZRNKYTKMKYOBI)
    public String getZrnkytkmkyobi() {
        return zrnkytkmkyobi;
    }

    public void setZrnkytkmkyobi(String pZrnkytkmkyobi) {
        zrnkytkmkyobi = pZrnkytkmkyobi;
    }

    private String zrnsystemkbn;

    @Column(name=GenZT_SkKsnHurikaeRn.ZRNSYSTEMKBN)
    public String getZrnsystemkbn() {
        return zrnsystemkbn;
    }

    public void setZrnsystemkbn(String pZrnsystemkbn) {
        zrnsystemkbn = pZrnsystemkbn;
    }

    @Id
    @Column(name=GenZT_SkKsnHurikaeRn.ZRNTORIHIKINOC8)
    public String getZrntorihikinoc8() {
        return getPrimaryKey().getZrntorihikinoc8();
    }

    public void setZrntorihikinoc8(String pZrntorihikinoc8) {
        getPrimaryKey().setZrntorihikinoc8(pZrntorihikinoc8);
    }

    @Id
    @Column(name=GenZT_SkKsnHurikaeRn.ZRNTORIHIKINOEDANO)
    public String getZrntorihikinoedano() {
        return getPrimaryKey().getZrntorihikinoedano();
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrntorihikinoedano(String pZrntorihikinoedano) {
        getPrimaryKey().setZrntorihikinoedano(pZrntorihikinoedano);
    }

    private String zrnkjhikaeinjikm;

    @Column(name=GenZT_SkKsnHurikaeRn.ZRNKJHIKAEINJIKM)
    public String getZrnkjhikaeinjikm() {
        return zrnkjhikaeinjikm;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjhikaeinjikm(String pZrnkjhikaeinjikm) {
        zrnkjhikaeinjikm = pZrnkjhikaeinjikm;
    }

    @Id
    @Column(name=GenZT_SkKsnHurikaeRn.ZRNTORIHIKIYMDGENGOKBN)
    public String getZrntorihikiymdgengokbn() {
        return getPrimaryKey().getZrntorihikiymdgengokbn();
    }

    public void setZrntorihikiymdgengokbn(String pZrntorihikiymdgengokbn) {
        getPrimaryKey().setZrntorihikiymdgengokbn(pZrntorihikiymdgengokbn);
    }

    @Id
    @Column(name=GenZT_SkKsnHurikaeRn.ZRNTORIHIKINEN)
    public String getZrntorihikinen() {
        return getPrimaryKey().getZrntorihikinen();
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrntorihikinen(String pZrntorihikinen) {
        getPrimaryKey().setZrntorihikinen(pZrntorihikinen);
    }

    @Id
    @Column(name=GenZT_SkKsnHurikaeRn.ZRNTORIHIKITUKI)
    public String getZrntorihikituki() {
        return getPrimaryKey().getZrntorihikituki();
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrntorihikituki(String pZrntorihikituki) {
        getPrimaryKey().setZrntorihikituki(pZrntorihikituki);
    }

    @Id
    @Column(name=GenZT_SkKsnHurikaeRn.ZRNTORIHIKIBI)
    public String getZrntorihikibi() {
        return getPrimaryKey().getZrntorihikibi();
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrntorihikibi(String pZrntorihikibi) {
        getPrimaryKey().setZrntorihikibi(pZrntorihikibi);
    }

    private String zrnkanjyoukbn;

    @Column(name=GenZT_SkKsnHurikaeRn.ZRNKANJYOUKBN)
    public String getZrnkanjyoukbn() {
        return zrnkanjyoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 4)
    public void setZrnkanjyoukbn(String pZrnkanjyoukbn) {
        zrnkanjyoukbn = pZrnkanjyoukbn;
    }

    private String zrnkanjyoukbnnm;

    @Column(name=GenZT_SkKsnHurikaeRn.ZRNKANJYOUKBNNM)
    public String getZrnkanjyoukbnnm() {
        return zrnkanjyoukbnnm;
    }

    @DataConvert("toMultiByte")
    public void setZrnkanjyoukbnnm(String pZrnkanjyoukbnnm) {
        zrnkanjyoukbnnm = pZrnkanjyoukbnnm;
    }

    private String zrnkjtantoukanm;

    @Column(name=GenZT_SkKsnHurikaeRn.ZRNKJTANTOUKANM)
    public String getZrnkjtantoukanm() {
        return zrnkjtantoukanm;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjtantoukanm(String pZrnkjtantoukanm) {
        zrnkjtantoukanm = pZrnkjtantoukanm;
    }

    private String zrnkjtantoucd;

    @Column(name=GenZT_SkKsnHurikaeRn.ZRNKJTANTOUCD)
    public String getZrnkjtantoucd() {
        return zrnkjtantoucd;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjtantoucd(String pZrnkjtantoucd) {
        zrnkjtantoucd = pZrnkjtantoucd;
    }

    private String zrnkjsystemnm;

    @Column(name=GenZT_SkKsnHurikaeRn.ZRNKJSYSTEMNM)
    public String getZrnkjsystemnm() {
        return zrnkjsystemnm;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjsystemnm(String pZrnkjsystemnm) {
        zrnkjsystemnm = pZrnkjsystemnm;
    }

    private String zrnkarikurikosikingaku;

    @Column(name=GenZT_SkKsnHurikaeRn.ZRNKARIKURIKOSIKINGAKU)
    public String getZrnkarikurikosikingaku() {
        return zrnkarikurikosikingaku;
    }

    @Padding(mode = "left", padChar = '0', length = 12)
    public void setZrnkarikurikosikingaku(String pZrnkarikurikosikingaku) {
        zrnkarikurikosikingaku = pZrnkarikurikosikingaku;
    }

    private String zrnkasikurikosikingaku;

    @Column(name=GenZT_SkKsnHurikaeRn.ZRNKASIKURIKOSIKINGAKU)
    public String getZrnkasikurikosikingaku() {
        return zrnkasikurikosikingaku;
    }

    @Padding(mode = "left", padChar = '0', length = 12)
    public void setZrnkasikurikosikingaku(String pZrnkasikurikosikingaku) {
        zrnkasikurikosikingaku = pZrnkasikurikosikingaku;
    }

    private String zrndenpyoukbnnm;

    @Column(name=GenZT_SkKsnHurikaeRn.ZRNDENPYOUKBNNM)
    public String getZrndenpyoukbnnm() {
        return zrndenpyoukbnnm;
    }

    @DataConvert("toMultiByte")
    public void setZrndenpyoukbnnm(String pZrndenpyoukbnnm) {
        zrndenpyoukbnnm = pZrndenpyoukbnnm;
    }

    private String zrnkjkarikurikosigkhyjkm;

    @Column(name=GenZT_SkKsnHurikaeRn.ZRNKJKARIKURIKOSIGKHYJKM)
    public String getZrnkjkarikurikosigkhyjkm() {
        return zrnkjkarikurikosigkhyjkm;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjkarikurikosigkhyjkm(String pZrnkjkarikurikosigkhyjkm) {
        zrnkjkarikurikosigkhyjkm = pZrnkjkarikurikosigkhyjkm;
    }

    private String zrnkarikurikosigkkingaku;

    @Column(name=GenZT_SkKsnHurikaeRn.ZRNKARIKURIKOSIGKKINGAKU)
    public String getZrnkarikurikosigkkingaku() {
        return zrnkarikurikosigkkingaku;
    }

    public void setZrnkarikurikosigkkingaku(String pZrnkarikurikosigkkingaku) {
        zrnkarikurikosigkkingaku = pZrnkarikurikosigkkingaku;
    }

    private String zrnkjkasikurikosigkhyjkm;

    @Column(name=GenZT_SkKsnHurikaeRn.ZRNKJKASIKURIKOSIGKHYJKM)
    public String getZrnkjkasikurikosigkhyjkm() {
        return zrnkjkasikurikosigkhyjkm;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjkasikurikosigkhyjkm(String pZrnkjkasikurikosigkhyjkm) {
        zrnkjkasikurikosigkhyjkm = pZrnkjkasikurikosigkhyjkm;
    }

    private String zrnkasikurikosigkkingaku;

    @Column(name=GenZT_SkKsnHurikaeRn.ZRNKASIKURIKOSIGKKINGAKU)
    public String getZrnkasikurikosigkkingaku() {
        return zrnkasikurikosigkkingaku;
    }

    public void setZrnkasikurikosigkkingaku(String pZrnkasikurikosigkkingaku) {
        zrnkasikurikosigkkingaku = pZrnkasikurikosigkkingaku;
    }

    private String zrnkjtekiyou1;

    @Column(name=GenZT_SkKsnHurikaeRn.ZRNKJTEKIYOU1)
    public String getZrnkjtekiyou1() {
        return zrnkjtekiyou1;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjtekiyou1(String pZrnkjtekiyou1) {
        zrnkjtekiyou1 = pZrnkjtekiyou1;
    }

    private String zrnkjtekiyou2;

    @Column(name=GenZT_SkKsnHurikaeRn.ZRNKJTEKIYOU2)
    public String getZrnkjtekiyou2() {
        return zrnkjtekiyou2;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjtekiyou2(String pZrnkjtekiyou2) {
        zrnkjtekiyou2 = pZrnkjtekiyou2;
    }

    private String zrnkjtekiyou3;

    @Column(name=GenZT_SkKsnHurikaeRn.ZRNKJTEKIYOU3)
    public String getZrnkjtekiyou3() {
        return zrnkjtekiyou3;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjtekiyou3(String pZrnkjtekiyou3) {
        zrnkjtekiyou3 = pZrnkjtekiyou3;
    }

    private String zrnkjkarikanjyoukamokunm1;

    @Column(name=GenZT_SkKsnHurikaeRn.ZRNKJKARIKANJYOUKAMOKUNM1)
    public String getZrnkjkarikanjyoukamokunm1() {
        return zrnkjkarikanjyoukamokunm1;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjkarikanjyoukamokunm1(String pZrnkjkarikanjyoukamokunm1) {
        zrnkjkarikanjyoukamokunm1 = pZrnkjkarikanjyoukamokunm1;
    }

    private String zrnkjkasikanjyoukamokunm1;

    @Column(name=GenZT_SkKsnHurikaeRn.ZRNKJKASIKANJYOUKAMOKUNM1)
    public String getZrnkjkasikanjyoukamokunm1() {
        return zrnkjkasikanjyoukamokunm1;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjkasikanjyoukamokunm1(String pZrnkjkasikanjyoukamokunm1) {
        zrnkjkasikanjyoukamokunm1 = pZrnkjkasikanjyoukamokunm1;
    }

    private String zrnkaritekiyoukm1;

    @Column(name=GenZT_SkKsnHurikaeRn.ZRNKARITEKIYOUKM1)
    public String getZrnkaritekiyoukm1() {
        return zrnkaritekiyoukm1;
    }

    public void setZrnkaritekiyoukm1(String pZrnkaritekiyoukm1) {
        zrnkaritekiyoukm1 = pZrnkaritekiyoukm1;
    }

    private String zrnkarikingaku1;

    @Column(name=GenZT_SkKsnHurikaeRn.ZRNKARIKINGAKU1)
    public String getZrnkarikingaku1() {
        return zrnkarikingaku1;
    }

    @Padding(mode = "left", padChar = '0', length = 12)
    public void setZrnkarikingaku1(String pZrnkarikingaku1) {
        zrnkarikingaku1 = pZrnkarikingaku1;
    }

    private String zrnkasitekiyoukm1;

    @Column(name=GenZT_SkKsnHurikaeRn.ZRNKASITEKIYOUKM1)
    public String getZrnkasitekiyoukm1() {
        return zrnkasitekiyoukm1;
    }

    public void setZrnkasitekiyoukm1(String pZrnkasitekiyoukm1) {
        zrnkasitekiyoukm1 = pZrnkasitekiyoukm1;
    }

    private String zrnkasikingaku1;

    @Column(name=GenZT_SkKsnHurikaeRn.ZRNKASIKINGAKU1)
    public String getZrnkasikingaku1() {
        return zrnkasikingaku1;
    }

    @Padding(mode = "left", padChar = '0', length = 12)
    public void setZrnkasikingaku1(String pZrnkasikingaku1) {
        zrnkasikingaku1 = pZrnkasikingaku1;
    }

    private String zrnkjkaritekiyoukm1;

    @Column(name=GenZT_SkKsnHurikaeRn.ZRNKJKARITEKIYOUKM1)
    public String getZrnkjkaritekiyoukm1() {
        return zrnkjkaritekiyoukm1;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjkaritekiyoukm1(String pZrnkjkaritekiyoukm1) {
        zrnkjkaritekiyoukm1 = pZrnkjkaritekiyoukm1;
    }

    private String zrnkjkasitekiyoukm1;

    @Column(name=GenZT_SkKsnHurikaeRn.ZRNKJKASITEKIYOUKM1)
    public String getZrnkjkasitekiyoukm1() {
        return zrnkjkasitekiyoukm1;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjkasitekiyoukm1(String pZrnkjkasitekiyoukm1) {
        zrnkjkasitekiyoukm1 = pZrnkjkasitekiyoukm1;
    }

    private String zrnkjkarikanjyoukamokunm2;

    @Column(name=GenZT_SkKsnHurikaeRn.ZRNKJKARIKANJYOUKAMOKUNM2)
    public String getZrnkjkarikanjyoukamokunm2() {
        return zrnkjkarikanjyoukamokunm2;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjkarikanjyoukamokunm2(String pZrnkjkarikanjyoukamokunm2) {
        zrnkjkarikanjyoukamokunm2 = pZrnkjkarikanjyoukamokunm2;
    }

    private String zrnkjkasikanjyoukamokunm2;

    @Column(name=GenZT_SkKsnHurikaeRn.ZRNKJKASIKANJYOUKAMOKUNM2)
    public String getZrnkjkasikanjyoukamokunm2() {
        return zrnkjkasikanjyoukamokunm2;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjkasikanjyoukamokunm2(String pZrnkjkasikanjyoukamokunm2) {
        zrnkjkasikanjyoukamokunm2 = pZrnkjkasikanjyoukamokunm2;
    }

    private String zrnkaritekiyoukm2;

    @Column(name=GenZT_SkKsnHurikaeRn.ZRNKARITEKIYOUKM2)
    public String getZrnkaritekiyoukm2() {
        return zrnkaritekiyoukm2;
    }

    public void setZrnkaritekiyoukm2(String pZrnkaritekiyoukm2) {
        zrnkaritekiyoukm2 = pZrnkaritekiyoukm2;
    }

    private String zrnkarikingaku2;

    @Column(name=GenZT_SkKsnHurikaeRn.ZRNKARIKINGAKU2)
    public String getZrnkarikingaku2() {
        return zrnkarikingaku2;
    }

    @Padding(mode = "left", padChar = '0', length = 12)
    public void setZrnkarikingaku2(String pZrnkarikingaku2) {
        zrnkarikingaku2 = pZrnkarikingaku2;
    }

    private String zrnkasitekiyoukm2;

    @Column(name=GenZT_SkKsnHurikaeRn.ZRNKASITEKIYOUKM2)
    public String getZrnkasitekiyoukm2() {
        return zrnkasitekiyoukm2;
    }

    public void setZrnkasitekiyoukm2(String pZrnkasitekiyoukm2) {
        zrnkasitekiyoukm2 = pZrnkasitekiyoukm2;
    }

    private String zrnkasikingaku2;

    @Column(name=GenZT_SkKsnHurikaeRn.ZRNKASIKINGAKU2)
    public String getZrnkasikingaku2() {
        return zrnkasikingaku2;
    }

    @Padding(mode = "left", padChar = '0', length = 12)
    public void setZrnkasikingaku2(String pZrnkasikingaku2) {
        zrnkasikingaku2 = pZrnkasikingaku2;
    }

    private String zrnkjkaritekiyoukm2;

    @Column(name=GenZT_SkKsnHurikaeRn.ZRNKJKARITEKIYOUKM2)
    public String getZrnkjkaritekiyoukm2() {
        return zrnkjkaritekiyoukm2;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjkaritekiyoukm2(String pZrnkjkaritekiyoukm2) {
        zrnkjkaritekiyoukm2 = pZrnkjkaritekiyoukm2;
    }

    private String zrnkjkasitekiyoukm2;

    @Column(name=GenZT_SkKsnHurikaeRn.ZRNKJKASITEKIYOUKM2)
    public String getZrnkjkasitekiyoukm2() {
        return zrnkjkasitekiyoukm2;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjkasitekiyoukm2(String pZrnkjkasitekiyoukm2) {
        zrnkjkasitekiyoukm2 = pZrnkjkasitekiyoukm2;
    }

    private String zrnkjkarikanjyoukamokunm3;

    @Column(name=GenZT_SkKsnHurikaeRn.ZRNKJKARIKANJYOUKAMOKUNM3)
    public String getZrnkjkarikanjyoukamokunm3() {
        return zrnkjkarikanjyoukamokunm3;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjkarikanjyoukamokunm3(String pZrnkjkarikanjyoukamokunm3) {
        zrnkjkarikanjyoukamokunm3 = pZrnkjkarikanjyoukamokunm3;
    }

    private String zrnkjkasikanjyoukamokunm3;

    @Column(name=GenZT_SkKsnHurikaeRn.ZRNKJKASIKANJYOUKAMOKUNM3)
    public String getZrnkjkasikanjyoukamokunm3() {
        return zrnkjkasikanjyoukamokunm3;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjkasikanjyoukamokunm3(String pZrnkjkasikanjyoukamokunm3) {
        zrnkjkasikanjyoukamokunm3 = pZrnkjkasikanjyoukamokunm3;
    }

    private String zrnkaritekiyoukm3;

    @Column(name=GenZT_SkKsnHurikaeRn.ZRNKARITEKIYOUKM3)
    public String getZrnkaritekiyoukm3() {
        return zrnkaritekiyoukm3;
    }

    public void setZrnkaritekiyoukm3(String pZrnkaritekiyoukm3) {
        zrnkaritekiyoukm3 = pZrnkaritekiyoukm3;
    }

    private String zrnkarikingaku3;

    @Column(name=GenZT_SkKsnHurikaeRn.ZRNKARIKINGAKU3)
    public String getZrnkarikingaku3() {
        return zrnkarikingaku3;
    }

    @Padding(mode = "left", padChar = '0', length = 12)
    public void setZrnkarikingaku3(String pZrnkarikingaku3) {
        zrnkarikingaku3 = pZrnkarikingaku3;
    }

    private String zrnkasitekiyoukm3;

    @Column(name=GenZT_SkKsnHurikaeRn.ZRNKASITEKIYOUKM3)
    public String getZrnkasitekiyoukm3() {
        return zrnkasitekiyoukm3;
    }

    public void setZrnkasitekiyoukm3(String pZrnkasitekiyoukm3) {
        zrnkasitekiyoukm3 = pZrnkasitekiyoukm3;
    }

    private String zrnkasikingaku3;

    @Column(name=GenZT_SkKsnHurikaeRn.ZRNKASIKINGAKU3)
    public String getZrnkasikingaku3() {
        return zrnkasikingaku3;
    }

    @Padding(mode = "left", padChar = '0', length = 12)
    public void setZrnkasikingaku3(String pZrnkasikingaku3) {
        zrnkasikingaku3 = pZrnkasikingaku3;
    }

    private String zrnkjkaritekiyoukm3;

    @Column(name=GenZT_SkKsnHurikaeRn.ZRNKJKARITEKIYOUKM3)
    public String getZrnkjkaritekiyoukm3() {
        return zrnkjkaritekiyoukm3;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjkaritekiyoukm3(String pZrnkjkaritekiyoukm3) {
        zrnkjkaritekiyoukm3 = pZrnkjkaritekiyoukm3;
    }

    private String zrnkjkasitekiyoukm3;

    @Column(name=GenZT_SkKsnHurikaeRn.ZRNKJKASITEKIYOUKM3)
    public String getZrnkjkasitekiyoukm3() {
        return zrnkjkasitekiyoukm3;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjkasitekiyoukm3(String pZrnkjkasitekiyoukm3) {
        zrnkjkasitekiyoukm3 = pZrnkjkasitekiyoukm3;
    }

    private String zrnkjkarikanjyoukamokunm4;

    @Column(name=GenZT_SkKsnHurikaeRn.ZRNKJKARIKANJYOUKAMOKUNM4)
    public String getZrnkjkarikanjyoukamokunm4() {
        return zrnkjkarikanjyoukamokunm4;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjkarikanjyoukamokunm4(String pZrnkjkarikanjyoukamokunm4) {
        zrnkjkarikanjyoukamokunm4 = pZrnkjkarikanjyoukamokunm4;
    }

    private String zrnkjkasikanjyoukamokunm4;

    @Column(name=GenZT_SkKsnHurikaeRn.ZRNKJKASIKANJYOUKAMOKUNM4)
    public String getZrnkjkasikanjyoukamokunm4() {
        return zrnkjkasikanjyoukamokunm4;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjkasikanjyoukamokunm4(String pZrnkjkasikanjyoukamokunm4) {
        zrnkjkasikanjyoukamokunm4 = pZrnkjkasikanjyoukamokunm4;
    }

    private String zrnkaritekiyoukm4;

    @Column(name=GenZT_SkKsnHurikaeRn.ZRNKARITEKIYOUKM4)
    public String getZrnkaritekiyoukm4() {
        return zrnkaritekiyoukm4;
    }

    public void setZrnkaritekiyoukm4(String pZrnkaritekiyoukm4) {
        zrnkaritekiyoukm4 = pZrnkaritekiyoukm4;
    }

    private String zrnkarikingaku4;

    @Column(name=GenZT_SkKsnHurikaeRn.ZRNKARIKINGAKU4)
    public String getZrnkarikingaku4() {
        return zrnkarikingaku4;
    }

    @Padding(mode = "left", padChar = '0', length = 12)
    public void setZrnkarikingaku4(String pZrnkarikingaku4) {
        zrnkarikingaku4 = pZrnkarikingaku4;
    }

    private String zrnkasitekiyoukm4;

    @Column(name=GenZT_SkKsnHurikaeRn.ZRNKASITEKIYOUKM4)
    public String getZrnkasitekiyoukm4() {
        return zrnkasitekiyoukm4;
    }

    public void setZrnkasitekiyoukm4(String pZrnkasitekiyoukm4) {
        zrnkasitekiyoukm4 = pZrnkasitekiyoukm4;
    }

    private String zrnkasikingaku4;

    @Column(name=GenZT_SkKsnHurikaeRn.ZRNKASIKINGAKU4)
    public String getZrnkasikingaku4() {
        return zrnkasikingaku4;
    }

    @Padding(mode = "left", padChar = '0', length = 12)
    public void setZrnkasikingaku4(String pZrnkasikingaku4) {
        zrnkasikingaku4 = pZrnkasikingaku4;
    }

    private String zrnkjkaritekiyoukm4;

    @Column(name=GenZT_SkKsnHurikaeRn.ZRNKJKARITEKIYOUKM4)
    public String getZrnkjkaritekiyoukm4() {
        return zrnkjkaritekiyoukm4;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjkaritekiyoukm4(String pZrnkjkaritekiyoukm4) {
        zrnkjkaritekiyoukm4 = pZrnkjkaritekiyoukm4;
    }

    private String zrnkjkasitekiyoukm4;

    @Column(name=GenZT_SkKsnHurikaeRn.ZRNKJKASITEKIYOUKM4)
    public String getZrnkjkasitekiyoukm4() {
        return zrnkjkasitekiyoukm4;
    }

    @DataConvert("toMultiByte")
    public void setZrnkjkasitekiyoukm4(String pZrnkjkasitekiyoukm4) {
        zrnkjkasitekiyoukm4 = pZrnkjkasitekiyoukm4;
    }
}