package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Padding;
import yuyu.def.db.entity.ZT_TtdkKanKiykRn;
import yuyu.def.db.id.PKZT_TtdkKanKiykRn;
import yuyu.def.db.meta.GenQZT_TtdkKanKiykRn;
import yuyu.def.db.meta.QZT_TtdkKanKiykRn;

/**
 * 手続完了（解約）Ｆテーブル（連） テーブルのマッピング情報クラスで、 {@link ZT_TtdkKanKiykRn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_TtdkKanKiykRn}</td><td colspan="3">手続完了（解約）Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnsyoruicd zrnsyoruicd}</td><td>（連携用）書類コード</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyouhyouymd zrntyouhyouymd}</td><td>（連携用）帳票作成日</td><td align="center">{@link PKZT_TtdkKanKiykRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">{@link PKZT_TtdkKanKiykRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhassoukbn zrnhassoukbn}</td><td>（連携用）発送区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyodouhuukbn zrnsyodouhuukbn}</td><td>（連携用）証券同封区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv24 zrnyobiv24}</td><td>（連携用）予備項目Ｖ２４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyoruicd2 zrnsyoruicd2}</td><td>（連携用）書類コード２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntyouhyouymd2 zrntyouhyouymd2}</td><td>（連携用）帳票作成日２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono2 zrnsyono2}</td><td>（連携用）証券番号２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhassoukbn2 zrnhassoukbn2}</td><td>（連携用）発送区分２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyodouhuukbn2 zrnsyodouhuukbn2}</td><td>（連携用）証券同封区分２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsikibetuno zrnsikibetuno}</td><td>（連携用）識別番号</td><td align="center">{@link PKZT_TtdkKanKiykRn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv44 zrnyobiv44}</td><td>（連携用）予備項目Ｖ４４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshskyno zrnshskyno}</td><td>（連携用）送付先郵便番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshskadr1kj zrnshskadr1kj}</td><td>（連携用）送付先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshskadr2kj zrnshskadr2kj}</td><td>（連携用）送付先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshskadr3kj zrnshskadr3kj}</td><td>（連携用）送付先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshsnmkjttdk zrnshsnmkjttdk}</td><td>（連携用）送付先名（漢字）（手続完了）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv43 zrnyobiv43}</td><td>（連携用）予備項目Ｖ４３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawsosikikj zrntawsosikikj}</td><td>（連携用）問合せ先組織名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawyno zrntawyno}</td><td>（連携用）問合せ先郵便番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawadr1kj zrntawadr1kj}</td><td>（連携用）問合せ先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawadr2kj zrntawadr2kj}</td><td>（連携用）問合せ先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawadr3kj zrntawadr3kj}</td><td>（連携用）問合せ先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawtelno zrntawtelno}</td><td>（連携用）問合せ先電話番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawteluktkkanou1 zrntawteluktkkanou1}</td><td>（連携用）問合せ先電話受付可能時間１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntawteluktkkanou2 zrntawteluktkkanou2}</td><td>（連携用）問合せ先電話受付可能時間２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2tawsosikinmkj zrndai2tawsosikinmkj}</td><td>（連携用）第２問合せ先組織名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrndai2tawtelno zrndai2tawtelno}</td><td>（連携用）第２問合せ先電話番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsclatosyono zrnsclatosyono}</td><td>（連携用）スクランブル後証券番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsakunm zrnsakunm}</td><td>（連携用）作成番号</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv66 zrnyobiv66}</td><td>（連携用）予備項目Ｖ６６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsyono3 zrnsyono3}</td><td>（連携用）証券番号３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrymd zrnshrymd}</td><td>（連携用）支払年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeisankijyunymd zrnkeisankijyunymd}</td><td>（連携用）計算基準日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhhknnmkj zrnhhknnmkj}</td><td>（連携用）被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkyknmkj zrnkyknmkj}</td><td>（連携用）契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv73 zrnyobiv73}</td><td>（連携用）予備項目Ｖ７３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntekiyou1 zrntekiyou1}</td><td>（連携用）摘要１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrgkmeisai1 zrnshrgkmeisai1}</td><td>（連携用）支払金額明細１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntekiyou2 zrntekiyou2}</td><td>（連携用）摘要２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrgkmeisai2 zrnshrgkmeisai2}</td><td>（連携用）支払金額明細２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntekiyou3 zrntekiyou3}</td><td>（連携用）摘要３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrgkmeisai3 zrnshrgkmeisai3}</td><td>（連携用）支払金額明細３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntekiyou4 zrntekiyou4}</td><td>（連携用）摘要４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrgkmeisai4 zrnshrgkmeisai4}</td><td>（連携用）支払金額明細４</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntekiyou5 zrntekiyou5}</td><td>（連携用）摘要５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrgkmeisai5 zrnshrgkmeisai5}</td><td>（連携用）支払金額明細５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntekiyou6 zrntekiyou6}</td><td>（連携用）摘要６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrgkmeisai6 zrnshrgkmeisai6}</td><td>（連携用）支払金額明細６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntekiyou7 zrntekiyou7}</td><td>（連携用）摘要７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrgkmeisai7 zrnshrgkmeisai7}</td><td>（連携用）支払金額明細７</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntekiyou8 zrntekiyou8}</td><td>（連携用）摘要８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrgkmeisai8 zrnshrgkmeisai8}</td><td>（連携用）支払金額明細８</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrgkgoukei zrnshrgkgoukei}</td><td>（連携用）支払額合計</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrgkkeiknsngo zrnshrgkkeiknsngo}</td><td>（連携用）支払額合計（換算後）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrntuukasyu zrntuukasyu}</td><td>（連携用）通貨種類</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnnykntuukasyu zrnnykntuukasyu}</td><td>（連携用）入金通貨種類</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnshrtkykwsrate zrnshrtkykwsrate}</td><td>（連携用）支払時適用為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZrntkytuukasyuryk zrntkytuukasyuryk}</td><td>（連携用）適用通貨種類略称</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv43x2 zrnyobiv43x2}</td><td>（連携用）予備項目Ｖ４３＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnbanknmkj zrnbanknmkj}</td><td>（連携用）銀行名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsitennmkj zrnsitennmkj}</td><td>（連携用）支店名（漢字）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyokinkbn zrnyokinkbn}</td><td>（連携用）預金種目区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkouzano12keta zrnkouzano12keta}</td><td>（連携用）口座番号（１２桁）</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkzmeiginmkn zrnkzmeiginmkn}</td><td>（連携用）口座名義人氏名（カナ）</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkouzasyuruikbn zrnkouzasyuruikbn}</td><td>（連携用）口座種類区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyenshrtkumu zrnyenshrtkumu}</td><td>（連携用）円支払特約有無</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv55 zrnyobiv55}</td><td>（連携用）予備項目Ｖ５５</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtykeihi zrnhtykeihi}</td><td>（連携用）必要経費</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsaeki zrnsaeki}</td><td>（連携用）差益</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsynykngk zrnsynykngk}</td><td>（連携用）収入金額</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon1 zrnosirasemongon1}</td><td>（連携用）お知らせ文言１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon2 zrnosirasemongon2}</td><td>（連携用）お知らせ文言２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon3 zrnosirasemongon3}</td><td>（連携用）お知らせ文言３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon4 zrnosirasemongon4}</td><td>（連携用）お知らせ文言４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon5 zrnosirasemongon5}</td><td>（連携用）お知らせ文言５</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon6 zrnosirasemongon6}</td><td>（連携用）お知らせ文言６</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon7 zrnosirasemongon7}</td><td>（連携用）お知らせ文言７</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon8 zrnosirasemongon8}</td><td>（連携用）お知らせ文言８</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon9 zrnosirasemongon9}</td><td>（連携用）お知らせ文言９</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon10 zrnosirasemongon10}</td><td>（連携用）お知らせ文言１０</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon11 zrnosirasemongon11}</td><td>（連携用）お知らせ文言１１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon12 zrnosirasemongon12}</td><td>（連携用）お知らせ文言１２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon13 zrnosirasemongon13}</td><td>（連携用）お知らせ文言１３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnosirasemongon14 zrnosirasemongon14}</td><td>（連携用）お知らせ文言１４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzeimumongon1 zrnzeimumongon1}</td><td>（連携用）税務文言１</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzeimumongon2 zrnzeimumongon2}</td><td>（連携用）税務文言２</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzeimumongon3 zrnzeimumongon3}</td><td>（連携用）税務文言３</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnzeimumongon4 zrnzeimumongon4}</td><td>（連携用）税務文言４</td><td align="center">&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv50 zrnyobiv50}</td><td>（連携用）予備項目Ｖ５０</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_TtdkKanKiykRn
 * @see     PKZT_TtdkKanKiykRn
 * @see     QZT_TtdkKanKiykRn
 * @see     GenQZT_TtdkKanKiykRn
 */
@MappedSuperclass
@Table(name=GenZT_TtdkKanKiykRn.TABLE_NAME)
@IdClass(value=PKZT_TtdkKanKiykRn.class)
public abstract class GenZT_TtdkKanKiykRn extends AbstractExDBEntityForZDB<ZT_TtdkKanKiykRn, PKZT_TtdkKanKiykRn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_TtdkKanKiykRn";
    public static final String ZRNSYORUICD              = "zrnsyoruicd";
    public static final String ZRNTYOUHYOUYMD           = "zrntyouhyouymd";
    public static final String ZRNSYONO                 = "zrnsyono";
    public static final String ZRNHASSOUKBN             = "zrnhassoukbn";
    public static final String ZRNSYODOUHUUKBN          = "zrnsyodouhuukbn";
    public static final String ZRNYOBIV24               = "zrnyobiv24";
    public static final String ZRNSYORUICD2             = "zrnsyoruicd2";
    public static final String ZRNTYOUHYOUYMD2          = "zrntyouhyouymd2";
    public static final String ZRNSYONO2                = "zrnsyono2";
    public static final String ZRNHASSOUKBN2            = "zrnhassoukbn2";
    public static final String ZRNSYODOUHUUKBN2         = "zrnsyodouhuukbn2";
    public static final String ZRNSIKIBETUNO            = "zrnsikibetuno";
    public static final String ZRNYOBIV44               = "zrnyobiv44";
    public static final String ZRNSHSKYNO               = "zrnshskyno";
    public static final String ZRNSHSKADR1KJ            = "zrnshskadr1kj";
    public static final String ZRNSHSKADR2KJ            = "zrnshskadr2kj";
    public static final String ZRNSHSKADR3KJ            = "zrnshskadr3kj";
    public static final String ZRNSHSNMKJTTDK           = "zrnshsnmkjttdk";
    public static final String ZRNYOBIV43               = "zrnyobiv43";
    public static final String ZRNTAWSOSIKIKJ           = "zrntawsosikikj";
    public static final String ZRNTAWYNO                = "zrntawyno";
    public static final String ZRNTAWADR1KJ             = "zrntawadr1kj";
    public static final String ZRNTAWADR2KJ             = "zrntawadr2kj";
    public static final String ZRNTAWADR3KJ             = "zrntawadr3kj";
    public static final String ZRNTAWTELNO              = "zrntawtelno";
    public static final String ZRNTAWTELUKTKKANOU1      = "zrntawteluktkkanou1";
    public static final String ZRNTAWTELUKTKKANOU2      = "zrntawteluktkkanou2";
    public static final String ZRNDAI2TAWSOSIKINMKJ     = "zrndai2tawsosikinmkj";
    public static final String ZRNDAI2TAWTELNO          = "zrndai2tawtelno";
    public static final String ZRNSCLATOSYONO           = "zrnsclatosyono";
    public static final String ZRNSAKUNM                = "zrnsakunm";
    public static final String ZRNYOBIV66               = "zrnyobiv66";
    public static final String ZRNSYONO3                = "zrnsyono3";
    public static final String ZRNSHRYMD                = "zrnshrymd";
    public static final String ZRNKEISANKIJYUNYMD       = "zrnkeisankijyunymd";
    public static final String ZRNHHKNNMKJ              = "zrnhhknnmkj";
    public static final String ZRNKYKNMKJ               = "zrnkyknmkj";
    public static final String ZRNYOBIV73               = "zrnyobiv73";
    public static final String ZRNTEKIYOU1              = "zrntekiyou1";
    public static final String ZRNSHRGKMEISAI1          = "zrnshrgkmeisai1";
    public static final String ZRNTEKIYOU2              = "zrntekiyou2";
    public static final String ZRNSHRGKMEISAI2          = "zrnshrgkmeisai2";
    public static final String ZRNTEKIYOU3              = "zrntekiyou3";
    public static final String ZRNSHRGKMEISAI3          = "zrnshrgkmeisai3";
    public static final String ZRNTEKIYOU4              = "zrntekiyou4";
    public static final String ZRNSHRGKMEISAI4          = "zrnshrgkmeisai4";
    public static final String ZRNTEKIYOU5              = "zrntekiyou5";
    public static final String ZRNSHRGKMEISAI5          = "zrnshrgkmeisai5";
    public static final String ZRNTEKIYOU6              = "zrntekiyou6";
    public static final String ZRNSHRGKMEISAI6          = "zrnshrgkmeisai6";
    public static final String ZRNTEKIYOU7              = "zrntekiyou7";
    public static final String ZRNSHRGKMEISAI7          = "zrnshrgkmeisai7";
    public static final String ZRNTEKIYOU8              = "zrntekiyou8";
    public static final String ZRNSHRGKMEISAI8          = "zrnshrgkmeisai8";
    public static final String ZRNSHRGKGOUKEI           = "zrnshrgkgoukei";
    public static final String ZRNSHRGKKEIKNSNGO        = "zrnshrgkkeiknsngo";
    public static final String ZRNTUUKASYU              = "zrntuukasyu";
    public static final String ZRNNYKNTUUKASYU          = "zrnnykntuukasyu";
    public static final String ZRNSHRTKYKWSRATE         = "zrnshrtkykwsrate";
    public static final String ZRNTKYTUUKASYURYK        = "zrntkytuukasyuryk";
    public static final String ZRNYOBIV43X2             = "zrnyobiv43x2";
    public static final String ZRNBANKNMKJ              = "zrnbanknmkj";
    public static final String ZRNSITENNMKJ             = "zrnsitennmkj";
    public static final String ZRNYOKINKBN              = "zrnyokinkbn";
    public static final String ZRNKOUZANO12KETA         = "zrnkouzano12keta";
    public static final String ZRNKZMEIGINMKN           = "zrnkzmeiginmkn";
    public static final String ZRNKOUZASYURUIKBN        = "zrnkouzasyuruikbn";
    public static final String ZRNYENSHRTKUMU           = "zrnyenshrtkumu";
    public static final String ZRNYOBIV55               = "zrnyobiv55";
    public static final String ZRNHTYKEIHI              = "zrnhtykeihi";
    public static final String ZRNSAEKI                 = "zrnsaeki";
    public static final String ZRNSYNYKNGK              = "zrnsynykngk";
    public static final String ZRNOSIRASEMONGON1        = "zrnosirasemongon1";
    public static final String ZRNOSIRASEMONGON2        = "zrnosirasemongon2";
    public static final String ZRNOSIRASEMONGON3        = "zrnosirasemongon3";
    public static final String ZRNOSIRASEMONGON4        = "zrnosirasemongon4";
    public static final String ZRNOSIRASEMONGON5        = "zrnosirasemongon5";
    public static final String ZRNOSIRASEMONGON6        = "zrnosirasemongon6";
    public static final String ZRNOSIRASEMONGON7        = "zrnosirasemongon7";
    public static final String ZRNOSIRASEMONGON8        = "zrnosirasemongon8";
    public static final String ZRNOSIRASEMONGON9        = "zrnosirasemongon9";
    public static final String ZRNOSIRASEMONGON10       = "zrnosirasemongon10";
    public static final String ZRNOSIRASEMONGON11       = "zrnosirasemongon11";
    public static final String ZRNOSIRASEMONGON12       = "zrnosirasemongon12";
    public static final String ZRNOSIRASEMONGON13       = "zrnosirasemongon13";
    public static final String ZRNOSIRASEMONGON14       = "zrnosirasemongon14";
    public static final String ZRNZEIMUMONGON1          = "zrnzeimumongon1";
    public static final String ZRNZEIMUMONGON2          = "zrnzeimumongon2";
    public static final String ZRNZEIMUMONGON3          = "zrnzeimumongon3";
    public static final String ZRNZEIMUMONGON4          = "zrnzeimumongon4";
    public static final String ZRNYOBIV50               = "zrnyobiv50";

    private final PKZT_TtdkKanKiykRn primaryKey;

    public GenZT_TtdkKanKiykRn() {
        primaryKey = new PKZT_TtdkKanKiykRn();
    }

    public GenZT_TtdkKanKiykRn(
        String pZrntyouhyouymd,
        String pZrnsyono,
        String pZrnsikibetuno
    ) {
        primaryKey = new PKZT_TtdkKanKiykRn(
            pZrntyouhyouymd,
            pZrnsyono,
            pZrnsikibetuno
        );
    }

    @Transient
    @Override
    public PKZT_TtdkKanKiykRn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_TtdkKanKiykRn> getMetaClass() {
        return QZT_TtdkKanKiykRn.class;
    }

    private String zrnsyoruicd;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNSYORUICD)
    public String getZrnsyoruicd() {
        return zrnsyoruicd;
    }

    public void setZrnsyoruicd(String pZrnsyoruicd) {
        zrnsyoruicd = pZrnsyoruicd;
    }

    @Id
    @Column(name=GenZT_TtdkKanKiykRn.ZRNTYOUHYOUYMD)
    public String getZrntyouhyouymd() {
        return getPrimaryKey().getZrntyouhyouymd();
    }

    public void setZrntyouhyouymd(String pZrntyouhyouymd) {
        getPrimaryKey().setZrntyouhyouymd(pZrntyouhyouymd);
    }

    @Id
    @Column(name=GenZT_TtdkKanKiykRn.ZRNSYONO)
    public String getZrnsyono() {
        return getPrimaryKey().getZrnsyono();
    }

    public void setZrnsyono(String pZrnsyono) {
        getPrimaryKey().setZrnsyono(pZrnsyono);
    }

    private String zrnhassoukbn;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNHASSOUKBN)
    public String getZrnhassoukbn() {
        return zrnhassoukbn;
    }

    public void setZrnhassoukbn(String pZrnhassoukbn) {
        zrnhassoukbn = pZrnhassoukbn;
    }

    private String zrnsyodouhuukbn;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNSYODOUHUUKBN)
    public String getZrnsyodouhuukbn() {
        return zrnsyodouhuukbn;
    }

    public void setZrnsyodouhuukbn(String pZrnsyodouhuukbn) {
        zrnsyodouhuukbn = pZrnsyodouhuukbn;
    }

    private String zrnyobiv24;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNYOBIV24)
    public String getZrnyobiv24() {
        return zrnyobiv24;
    }

    public void setZrnyobiv24(String pZrnyobiv24) {
        zrnyobiv24 = pZrnyobiv24;
    }

    private String zrnsyoruicd2;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNSYORUICD2)
    public String getZrnsyoruicd2() {
        return zrnsyoruicd2;
    }

    public void setZrnsyoruicd2(String pZrnsyoruicd2) {
        zrnsyoruicd2 = pZrnsyoruicd2;
    }

    private String zrntyouhyouymd2;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNTYOUHYOUYMD2)
    public String getZrntyouhyouymd2() {
        return zrntyouhyouymd2;
    }

    public void setZrntyouhyouymd2(String pZrntyouhyouymd2) {
        zrntyouhyouymd2 = pZrntyouhyouymd2;
    }

    private String zrnsyono2;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNSYONO2)
    public String getZrnsyono2() {
        return zrnsyono2;
    }

    public void setZrnsyono2(String pZrnsyono2) {
        zrnsyono2 = pZrnsyono2;
    }

    private String zrnhassoukbn2;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNHASSOUKBN2)
    public String getZrnhassoukbn2() {
        return zrnhassoukbn2;
    }

    public void setZrnhassoukbn2(String pZrnhassoukbn2) {
        zrnhassoukbn2 = pZrnhassoukbn2;
    }

    private String zrnsyodouhuukbn2;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNSYODOUHUUKBN2)
    public String getZrnsyodouhuukbn2() {
        return zrnsyodouhuukbn2;
    }

    public void setZrnsyodouhuukbn2(String pZrnsyodouhuukbn2) {
        zrnsyodouhuukbn2 = pZrnsyodouhuukbn2;
    }

    @Id
    @Column(name=GenZT_TtdkKanKiykRn.ZRNSIKIBETUNO)
    public String getZrnsikibetuno() {
        return getPrimaryKey().getZrnsikibetuno();
    }

    public void setZrnsikibetuno(String pZrnsikibetuno) {
        getPrimaryKey().setZrnsikibetuno(pZrnsikibetuno);
    }

    private String zrnyobiv44;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNYOBIV44)
    public String getZrnyobiv44() {
        return zrnyobiv44;
    }

    public void setZrnyobiv44(String pZrnyobiv44) {
        zrnyobiv44 = pZrnyobiv44;
    }

    private String zrnshskyno;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNSHSKYNO)
    public String getZrnshskyno() {
        return zrnshskyno;
    }

    public void setZrnshskyno(String pZrnshskyno) {
        zrnshskyno = pZrnshskyno;
    }

    private String zrnshskadr1kj;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNSHSKADR1KJ)
    public String getZrnshskadr1kj() {
        return zrnshskadr1kj;
    }

    @DataConvert("toMultiByte")
    public void setZrnshskadr1kj(String pZrnshskadr1kj) {
        zrnshskadr1kj = pZrnshskadr1kj;
    }

    private String zrnshskadr2kj;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNSHSKADR2KJ)
    public String getZrnshskadr2kj() {
        return zrnshskadr2kj;
    }

    @DataConvert("toMultiByte")
    public void setZrnshskadr2kj(String pZrnshskadr2kj) {
        zrnshskadr2kj = pZrnshskadr2kj;
    }

    private String zrnshskadr3kj;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNSHSKADR3KJ)
    public String getZrnshskadr3kj() {
        return zrnshskadr3kj;
    }

    @DataConvert("toMultiByte")
    public void setZrnshskadr3kj(String pZrnshskadr3kj) {
        zrnshskadr3kj = pZrnshskadr3kj;
    }

    private String zrnshsnmkjttdk;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNSHSNMKJTTDK)
    public String getZrnshsnmkjttdk() {
        return zrnshsnmkjttdk;
    }

    @DataConvert("toMultiByte")
    public void setZrnshsnmkjttdk(String pZrnshsnmkjttdk) {
        zrnshsnmkjttdk = pZrnshsnmkjttdk;
    }

    private String zrnyobiv43;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNYOBIV43)
    public String getZrnyobiv43() {
        return zrnyobiv43;
    }

    public void setZrnyobiv43(String pZrnyobiv43) {
        zrnyobiv43 = pZrnyobiv43;
    }

    private String zrntawsosikikj;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNTAWSOSIKIKJ)
    public String getZrntawsosikikj() {
        return zrntawsosikikj;
    }

    @DataConvert("toMultiByte")
    public void setZrntawsosikikj(String pZrntawsosikikj) {
        zrntawsosikikj = pZrntawsosikikj;
    }

    private String zrntawyno;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNTAWYNO)
    public String getZrntawyno() {
        return zrntawyno;
    }

    public void setZrntawyno(String pZrntawyno) {
        zrntawyno = pZrntawyno;
    }

    private String zrntawadr1kj;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNTAWADR1KJ)
    public String getZrntawadr1kj() {
        return zrntawadr1kj;
    }

    @DataConvert("toMultiByte")
    public void setZrntawadr1kj(String pZrntawadr1kj) {
        zrntawadr1kj = pZrntawadr1kj;
    }

    private String zrntawadr2kj;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNTAWADR2KJ)
    public String getZrntawadr2kj() {
        return zrntawadr2kj;
    }

    @DataConvert("toMultiByte")
    public void setZrntawadr2kj(String pZrntawadr2kj) {
        zrntawadr2kj = pZrntawadr2kj;
    }

    private String zrntawadr3kj;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNTAWADR3KJ)
    public String getZrntawadr3kj() {
        return zrntawadr3kj;
    }

    @DataConvert("toMultiByte")
    public void setZrntawadr3kj(String pZrntawadr3kj) {
        zrntawadr3kj = pZrntawadr3kj;
    }

    private String zrntawtelno;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNTAWTELNO)
    public String getZrntawtelno() {
        return zrntawtelno;
    }

    public void setZrntawtelno(String pZrntawtelno) {
        zrntawtelno = pZrntawtelno;
    }

    private String zrntawteluktkkanou1;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNTAWTELUKTKKANOU1)
    public String getZrntawteluktkkanou1() {
        return zrntawteluktkkanou1;
    }

    @DataConvert("toMultiByte")
    public void setZrntawteluktkkanou1(String pZrntawteluktkkanou1) {
        zrntawteluktkkanou1 = pZrntawteluktkkanou1;
    }

    private String zrntawteluktkkanou2;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNTAWTELUKTKKANOU2)
    public String getZrntawteluktkkanou2() {
        return zrntawteluktkkanou2;
    }

    @DataConvert("toMultiByte")
    public void setZrntawteluktkkanou2(String pZrntawteluktkkanou2) {
        zrntawteluktkkanou2 = pZrntawteluktkkanou2;
    }

    private String zrndai2tawsosikinmkj;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNDAI2TAWSOSIKINMKJ)
    public String getZrndai2tawsosikinmkj() {
        return zrndai2tawsosikinmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrndai2tawsosikinmkj(String pZrndai2tawsosikinmkj) {
        zrndai2tawsosikinmkj = pZrndai2tawsosikinmkj;
    }

    private String zrndai2tawtelno;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNDAI2TAWTELNO)
    public String getZrndai2tawtelno() {
        return zrndai2tawtelno;
    }

    public void setZrndai2tawtelno(String pZrndai2tawtelno) {
        zrndai2tawtelno = pZrndai2tawtelno;
    }

    private String zrnsclatosyono;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNSCLATOSYONO)
    public String getZrnsclatosyono() {
        return zrnsclatosyono;
    }

    public void setZrnsclatosyono(String pZrnsclatosyono) {
        zrnsclatosyono = pZrnsclatosyono;
    }

    private String zrnsakunm;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNSAKUNM)
    public String getZrnsakunm() {
        return zrnsakunm;
    }

    public void setZrnsakunm(String pZrnsakunm) {
        zrnsakunm = pZrnsakunm;
    }

    private String zrnyobiv66;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNYOBIV66)
    public String getZrnyobiv66() {
        return zrnyobiv66;
    }

    public void setZrnyobiv66(String pZrnyobiv66) {
        zrnyobiv66 = pZrnyobiv66;
    }

    private String zrnsyono3;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNSYONO3)
    public String getZrnsyono3() {
        return zrnsyono3;
    }

    public void setZrnsyono3(String pZrnsyono3) {
        zrnsyono3 = pZrnsyono3;
    }

    private String zrnshrymd;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNSHRYMD)
    public String getZrnshrymd() {
        return zrnshrymd;
    }

    public void setZrnshrymd(String pZrnshrymd) {
        zrnshrymd = pZrnshrymd;
    }

    private String zrnkeisankijyunymd;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNKEISANKIJYUNYMD)
    public String getZrnkeisankijyunymd() {
        return zrnkeisankijyunymd;
    }

    public void setZrnkeisankijyunymd(String pZrnkeisankijyunymd) {
        zrnkeisankijyunymd = pZrnkeisankijyunymd;
    }

    private String zrnhhknnmkj;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNHHKNNMKJ)
    public String getZrnhhknnmkj() {
        return zrnhhknnmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrnhhknnmkj(String pZrnhhknnmkj) {
        zrnhhknnmkj = pZrnhhknnmkj;
    }

    private String zrnkyknmkj;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNKYKNMKJ)
    public String getZrnkyknmkj() {
        return zrnkyknmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrnkyknmkj(String pZrnkyknmkj) {
        zrnkyknmkj = pZrnkyknmkj;
    }

    private String zrnyobiv73;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNYOBIV73)
    public String getZrnyobiv73() {
        return zrnyobiv73;
    }

    public void setZrnyobiv73(String pZrnyobiv73) {
        zrnyobiv73 = pZrnyobiv73;
    }

    private String zrntekiyou1;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNTEKIYOU1)
    public String getZrntekiyou1() {
        return zrntekiyou1;
    }

    @DataConvert("toMultiByte")
    public void setZrntekiyou1(String pZrntekiyou1) {
        zrntekiyou1 = pZrntekiyou1;
    }

    private String zrnshrgkmeisai1;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNSHRGKMEISAI1)
    public String getZrnshrgkmeisai1() {
        return zrnshrgkmeisai1;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnshrgkmeisai1(String pZrnshrgkmeisai1) {
        zrnshrgkmeisai1 = pZrnshrgkmeisai1;
    }

    private String zrntekiyou2;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNTEKIYOU2)
    public String getZrntekiyou2() {
        return zrntekiyou2;
    }

    @DataConvert("toMultiByte")
    public void setZrntekiyou2(String pZrntekiyou2) {
        zrntekiyou2 = pZrntekiyou2;
    }

    private String zrnshrgkmeisai2;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNSHRGKMEISAI2)
    public String getZrnshrgkmeisai2() {
        return zrnshrgkmeisai2;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnshrgkmeisai2(String pZrnshrgkmeisai2) {
        zrnshrgkmeisai2 = pZrnshrgkmeisai2;
    }

    private String zrntekiyou3;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNTEKIYOU3)
    public String getZrntekiyou3() {
        return zrntekiyou3;
    }

    @DataConvert("toMultiByte")
    public void setZrntekiyou3(String pZrntekiyou3) {
        zrntekiyou3 = pZrntekiyou3;
    }

    private String zrnshrgkmeisai3;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNSHRGKMEISAI3)
    public String getZrnshrgkmeisai3() {
        return zrnshrgkmeisai3;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnshrgkmeisai3(String pZrnshrgkmeisai3) {
        zrnshrgkmeisai3 = pZrnshrgkmeisai3;
    }

    private String zrntekiyou4;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNTEKIYOU4)
    public String getZrntekiyou4() {
        return zrntekiyou4;
    }

    @DataConvert("toMultiByte")
    public void setZrntekiyou4(String pZrntekiyou4) {
        zrntekiyou4 = pZrntekiyou4;
    }

    private String zrnshrgkmeisai4;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNSHRGKMEISAI4)
    public String getZrnshrgkmeisai4() {
        return zrnshrgkmeisai4;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnshrgkmeisai4(String pZrnshrgkmeisai4) {
        zrnshrgkmeisai4 = pZrnshrgkmeisai4;
    }

    private String zrntekiyou5;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNTEKIYOU5)
    public String getZrntekiyou5() {
        return zrntekiyou5;
    }

    @DataConvert("toMultiByte")
    public void setZrntekiyou5(String pZrntekiyou5) {
        zrntekiyou5 = pZrntekiyou5;
    }

    private String zrnshrgkmeisai5;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNSHRGKMEISAI5)
    public String getZrnshrgkmeisai5() {
        return zrnshrgkmeisai5;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnshrgkmeisai5(String pZrnshrgkmeisai5) {
        zrnshrgkmeisai5 = pZrnshrgkmeisai5;
    }

    private String zrntekiyou6;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNTEKIYOU6)
    public String getZrntekiyou6() {
        return zrntekiyou6;
    }

    @DataConvert("toMultiByte")
    public void setZrntekiyou6(String pZrntekiyou6) {
        zrntekiyou6 = pZrntekiyou6;
    }

    private String zrnshrgkmeisai6;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNSHRGKMEISAI6)
    public String getZrnshrgkmeisai6() {
        return zrnshrgkmeisai6;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnshrgkmeisai6(String pZrnshrgkmeisai6) {
        zrnshrgkmeisai6 = pZrnshrgkmeisai6;
    }

    private String zrntekiyou7;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNTEKIYOU7)
    public String getZrntekiyou7() {
        return zrntekiyou7;
    }

    @DataConvert("toMultiByte")
    public void setZrntekiyou7(String pZrntekiyou7) {
        zrntekiyou7 = pZrntekiyou7;
    }

    private String zrnshrgkmeisai7;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNSHRGKMEISAI7)
    public String getZrnshrgkmeisai7() {
        return zrnshrgkmeisai7;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnshrgkmeisai7(String pZrnshrgkmeisai7) {
        zrnshrgkmeisai7 = pZrnshrgkmeisai7;
    }

    private String zrntekiyou8;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNTEKIYOU8)
    public String getZrntekiyou8() {
        return zrntekiyou8;
    }

    @DataConvert("toMultiByte")
    public void setZrntekiyou8(String pZrntekiyou8) {
        zrntekiyou8 = pZrntekiyou8;
    }

    private String zrnshrgkmeisai8;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNSHRGKMEISAI8)
    public String getZrnshrgkmeisai8() {
        return zrnshrgkmeisai8;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnshrgkmeisai8(String pZrnshrgkmeisai8) {
        zrnshrgkmeisai8 = pZrnshrgkmeisai8;
    }

    private String zrnshrgkgoukei;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNSHRGKGOUKEI)
    public String getZrnshrgkgoukei() {
        return zrnshrgkgoukei;
    }

    @Padding(mode = "left", padChar ='0', length =13)
    public void setZrnshrgkgoukei(String pZrnshrgkgoukei) {
        zrnshrgkgoukei = pZrnshrgkgoukei;
    }

    private Double zrnshrgkkeiknsngo;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNSHRGKKEIKNSNGO)
    public Double getZrnshrgkkeiknsngo() {
        return zrnshrgkkeiknsngo;
    }

    public void setZrnshrgkkeiknsngo(Double pZrnshrgkkeiknsngo) {
        zrnshrgkkeiknsngo = pZrnshrgkkeiknsngo;
    }

    private String zrntuukasyu;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNTUUKASYU)
    public String getZrntuukasyu() {
        return zrntuukasyu;
    }

    @DataConvert("toMultiByte")
    public void setZrntuukasyu(String pZrntuukasyu) {
        zrntuukasyu = pZrntuukasyu;
    }

    private String zrnnykntuukasyu;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNNYKNTUUKASYU)
    public String getZrnnykntuukasyu() {
        return zrnnykntuukasyu;
    }

    @DataConvert("toMultiByte")
    public void setZrnnykntuukasyu(String pZrnnykntuukasyu) {
        zrnnykntuukasyu = pZrnnykntuukasyu;
    }

    private Double zrnshrtkykwsrate;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNSHRTKYKWSRATE)
    public Double getZrnshrtkykwsrate() {
        return zrnshrtkykwsrate;
    }

    public void setZrnshrtkykwsrate(Double pZrnshrtkykwsrate) {
        zrnshrtkykwsrate = pZrnshrtkykwsrate;
    }

    private String zrntkytuukasyuryk;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNTKYTUUKASYURYK)
    public String getZrntkytuukasyuryk() {
        return zrntkytuukasyuryk;
    }

    @DataConvert("toMultiByte")
    public void setZrntkytuukasyuryk(String pZrntkytuukasyuryk) {
        zrntkytuukasyuryk = pZrntkytuukasyuryk;
    }

    private String zrnyobiv43x2;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNYOBIV43X2)
    public String getZrnyobiv43x2() {
        return zrnyobiv43x2;
    }

    public void setZrnyobiv43x2(String pZrnyobiv43x2) {
        zrnyobiv43x2 = pZrnyobiv43x2;
    }

    private String zrnbanknmkj;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNBANKNMKJ)
    public String getZrnbanknmkj() {
        return zrnbanknmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrnbanknmkj(String pZrnbanknmkj) {
        zrnbanknmkj = pZrnbanknmkj;
    }

    private String zrnsitennmkj;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNSITENNMKJ)
    public String getZrnsitennmkj() {
        return zrnsitennmkj;
    }

    @DataConvert("toMultiByte")
    public void setZrnsitennmkj(String pZrnsitennmkj) {
        zrnsitennmkj = pZrnsitennmkj;
    }

    private String zrnyokinkbn;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNYOKINKBN)
    public String getZrnyokinkbn() {
        return zrnyokinkbn;
    }

    public void setZrnyokinkbn(String pZrnyokinkbn) {
        zrnyokinkbn = pZrnyokinkbn;
    }

    private String zrnkouzano12keta;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNKOUZANO12KETA)
    public String getZrnkouzano12keta() {
        return zrnkouzano12keta;
    }

    public void setZrnkouzano12keta(String pZrnkouzano12keta) {
        zrnkouzano12keta = pZrnkouzano12keta;
    }

    private String zrnkzmeiginmkn;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNKZMEIGINMKN)
    public String getZrnkzmeiginmkn() {
        return zrnkzmeiginmkn;
    }

    @DataConvert("toMultiByte")
    public void setZrnkzmeiginmkn(String pZrnkzmeiginmkn) {
        zrnkzmeiginmkn = pZrnkzmeiginmkn;
    }

    private String zrnkouzasyuruikbn;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNKOUZASYURUIKBN)
    public String getZrnkouzasyuruikbn() {
        return zrnkouzasyuruikbn;
    }

    public void setZrnkouzasyuruikbn(String pZrnkouzasyuruikbn) {
        zrnkouzasyuruikbn = pZrnkouzasyuruikbn;
    }

    private String zrnyenshrtkumu;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNYENSHRTKUMU)
    public String getZrnyenshrtkumu() {
        return zrnyenshrtkumu;
    }

    public void setZrnyenshrtkumu(String pZrnyenshrtkumu) {
        zrnyenshrtkumu = pZrnyenshrtkumu;
    }

    private String zrnyobiv55;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNYOBIV55)
    public String getZrnyobiv55() {
        return zrnyobiv55;
    }

    public void setZrnyobiv55(String pZrnyobiv55) {
        zrnyobiv55 = pZrnyobiv55;
    }

    private String zrnhtykeihi;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNHTYKEIHI)
    public String getZrnhtykeihi() {
        return zrnhtykeihi;
    }

    @Padding(mode = "left", padChar ='0', length =10)
    public void setZrnhtykeihi(String pZrnhtykeihi) {
        zrnhtykeihi = pZrnhtykeihi;
    }

    private Long zrnsaeki;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNSAEKI)
    public Long getZrnsaeki() {
        return zrnsaeki;
    }

    public void setZrnsaeki(Long pZrnsaeki) {
        zrnsaeki = pZrnsaeki;
    }

    private String zrnsynykngk;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNSYNYKNGK)
    public String getZrnsynykngk() {
        return zrnsynykngk;
    }

    @Padding(mode = "left", padChar ='0', length =10)
    public void setZrnsynykngk(String pZrnsynykngk) {
        zrnsynykngk = pZrnsynykngk;
    }

    private String zrnosirasemongon1;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNOSIRASEMONGON1)
    public String getZrnosirasemongon1() {
        return zrnosirasemongon1;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon1(String pZrnosirasemongon1) {
        zrnosirasemongon1 = pZrnosirasemongon1;
    }

    private String zrnosirasemongon2;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNOSIRASEMONGON2)
    public String getZrnosirasemongon2() {
        return zrnosirasemongon2;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon2(String pZrnosirasemongon2) {
        zrnosirasemongon2 = pZrnosirasemongon2;
    }

    private String zrnosirasemongon3;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNOSIRASEMONGON3)
    public String getZrnosirasemongon3() {
        return zrnosirasemongon3;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon3(String pZrnosirasemongon3) {
        zrnosirasemongon3 = pZrnosirasemongon3;
    }

    private String zrnosirasemongon4;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNOSIRASEMONGON4)
    public String getZrnosirasemongon4() {
        return zrnosirasemongon4;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon4(String pZrnosirasemongon4) {
        zrnosirasemongon4 = pZrnosirasemongon4;
    }

    private String zrnosirasemongon5;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNOSIRASEMONGON5)
    public String getZrnosirasemongon5() {
        return zrnosirasemongon5;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon5(String pZrnosirasemongon5) {
        zrnosirasemongon5 = pZrnosirasemongon5;
    }

    private String zrnosirasemongon6;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNOSIRASEMONGON6)
    public String getZrnosirasemongon6() {
        return zrnosirasemongon6;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon6(String pZrnosirasemongon6) {
        zrnosirasemongon6 = pZrnosirasemongon6;
    }

    private String zrnosirasemongon7;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNOSIRASEMONGON7)
    public String getZrnosirasemongon7() {
        return zrnosirasemongon7;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon7(String pZrnosirasemongon7) {
        zrnosirasemongon7 = pZrnosirasemongon7;
    }

    private String zrnosirasemongon8;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNOSIRASEMONGON8)
    public String getZrnosirasemongon8() {
        return zrnosirasemongon8;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon8(String pZrnosirasemongon8) {
        zrnosirasemongon8 = pZrnosirasemongon8;
    }

    private String zrnosirasemongon9;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNOSIRASEMONGON9)
    public String getZrnosirasemongon9() {
        return zrnosirasemongon9;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon9(String pZrnosirasemongon9) {
        zrnosirasemongon9 = pZrnosirasemongon9;
    }

    private String zrnosirasemongon10;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNOSIRASEMONGON10)
    public String getZrnosirasemongon10() {
        return zrnosirasemongon10;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon10(String pZrnosirasemongon10) {
        zrnosirasemongon10 = pZrnosirasemongon10;
    }

    private String zrnosirasemongon11;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNOSIRASEMONGON11)
    public String getZrnosirasemongon11() {
        return zrnosirasemongon11;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon11(String pZrnosirasemongon11) {
        zrnosirasemongon11 = pZrnosirasemongon11;
    }

    private String zrnosirasemongon12;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNOSIRASEMONGON12)
    public String getZrnosirasemongon12() {
        return zrnosirasemongon12;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon12(String pZrnosirasemongon12) {
        zrnosirasemongon12 = pZrnosirasemongon12;
    }

    private String zrnosirasemongon13;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNOSIRASEMONGON13)
    public String getZrnosirasemongon13() {
        return zrnosirasemongon13;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon13(String pZrnosirasemongon13) {
        zrnosirasemongon13 = pZrnosirasemongon13;
    }

    private String zrnosirasemongon14;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNOSIRASEMONGON14)
    public String getZrnosirasemongon14() {
        return zrnosirasemongon14;
    }

    @DataConvert("toMultiByte")
    public void setZrnosirasemongon14(String pZrnosirasemongon14) {
        zrnosirasemongon14 = pZrnosirasemongon14;
    }

    private String zrnzeimumongon1;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNZEIMUMONGON1)
    public String getZrnzeimumongon1() {
        return zrnzeimumongon1;
    }

    @DataConvert("toMultiByte")
    public void setZrnzeimumongon1(String pZrnzeimumongon1) {
        zrnzeimumongon1 = pZrnzeimumongon1;
    }

    private String zrnzeimumongon2;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNZEIMUMONGON2)
    public String getZrnzeimumongon2() {
        return zrnzeimumongon2;
    }

    @DataConvert("toMultiByte")
    public void setZrnzeimumongon2(String pZrnzeimumongon2) {
        zrnzeimumongon2 = pZrnzeimumongon2;
    }

    private String zrnzeimumongon3;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNZEIMUMONGON3)
    public String getZrnzeimumongon3() {
        return zrnzeimumongon3;
    }

    @DataConvert("toMultiByte")
    public void setZrnzeimumongon3(String pZrnzeimumongon3) {
        zrnzeimumongon3 = pZrnzeimumongon3;
    }

    private String zrnzeimumongon4;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNZEIMUMONGON4)
    public String getZrnzeimumongon4() {
        return zrnzeimumongon4;
    }

    @DataConvert("toMultiByte")
    public void setZrnzeimumongon4(String pZrnzeimumongon4) {
        zrnzeimumongon4 = pZrnzeimumongon4;
    }

    private String zrnyobiv50;

    @Column(name=GenZT_TtdkKanKiykRn.ZRNYOBIV50)
    public String getZrnyobiv50() {
        return zrnyobiv50;
    }

    public void setZrnyobiv50(String pZrnyobiv50) {
        zrnyobiv50 = pZrnyobiv50;
    }
}