package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import yuyu.def.db.entity.ZT_TtdkKanKiykTy;
import yuyu.def.db.id.PKZT_TtdkKanKiykTy;
import yuyu.def.db.meta.GenQZT_TtdkKanKiykTy;
import yuyu.def.db.meta.QZT_TtdkKanKiykTy;

/**
 * 手続完了（解約）Ｆテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_TtdkKanKiykTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_TtdkKanKiykTy}</td><td colspan="3">手続完了（解約）Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtysyoruicd ztysyoruicd}</td><td>（中継用）書類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyouhyouymd ztytyouhyouymd}</td><td>（中継用）帳票作成日</td><td align="center">{@link PKZT_TtdkKanKiykTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">{@link PKZT_TtdkKanKiykTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhassoukbn ztyhassoukbn}</td><td>（中継用）発送区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyodouhuukbn ztysyodouhuukbn}</td><td>（中継用）証券同封区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv24 ztyyobiv24}</td><td>（中継用）予備項目Ｖ２４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyoruicd2 ztysyoruicd2}</td><td>（中継用）書類コード２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytyouhyouymd2 ztytyouhyouymd2}</td><td>（中継用）帳票作成日２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono2 ztysyono2}</td><td>（中継用）証券番号２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhassoukbn2 ztyhassoukbn2}</td><td>（中継用）発送区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyodouhuukbn2 ztysyodouhuukbn2}</td><td>（中継用）証券同封区分２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysikibetuno ztysikibetuno}</td><td>（中継用）識別番号</td><td align="center">{@link PKZT_TtdkKanKiykTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv44 ztyyobiv44}</td><td>（中継用）予備項目Ｖ４４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshskyno ztyshskyno}</td><td>（中継用）送付先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshskadr1kj ztyshskadr1kj}</td><td>（中継用）送付先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshskadr2kj ztyshskadr2kj}</td><td>（中継用）送付先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshskadr3kj ztyshskadr3kj}</td><td>（中継用）送付先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshsnmkjttdk ztyshsnmkjttdk}</td><td>（中継用）送付先名（漢字）（手続完了）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv43 ztyyobiv43}</td><td>（中継用）予備項目Ｖ４３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawsosikikj ztytawsosikikj}</td><td>（中継用）問合せ先組織名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawyno ztytawyno}</td><td>（中継用）問合せ先郵便番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawadr1kj ztytawadr1kj}</td><td>（中継用）問合せ先住所１（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawadr2kj ztytawadr2kj}</td><td>（中継用）問合せ先住所２（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawadr3kj ztytawadr3kj}</td><td>（中継用）問合せ先住所３（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawtelno ztytawtelno}</td><td>（中継用）問合せ先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawteluktkkanou1 ztytawteluktkkanou1}</td><td>（中継用）問合せ先電話受付可能時間１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytawteluktkkanou2 ztytawteluktkkanou2}</td><td>（中継用）問合せ先電話受付可能時間２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2tawsosikinmkj ztydai2tawsosikinmkj}</td><td>（中継用）第２問合せ先組織名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtydai2tawtelno ztydai2tawtelno}</td><td>（中継用）第２問合せ先電話番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysclatosyono ztysclatosyono}</td><td>（中継用）スクランブル後証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysakunm ztysakunm}</td><td>（中継用）作成番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv66 ztyyobiv66}</td><td>（中継用）予備項目Ｖ６６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono3 ztysyono3}</td><td>（中継用）証券番号３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrymd ztyshrymd}</td><td>（中継用）支払年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeisankijyunymd ztykeisankijyunymd}</td><td>（中継用）計算基準日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknnmkj ztyhhknnmkj}</td><td>（中継用）被保険者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyknmkj ztykyknmkj}</td><td>（中継用）契約者名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv73 ztyyobiv73}</td><td>（中継用）予備項目Ｖ７３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytekiyou1 ztytekiyou1}</td><td>（中継用）摘要１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrgkmeisai1 ztyshrgkmeisai1}</td><td>（中継用）支払金額明細１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytekiyou2 ztytekiyou2}</td><td>（中継用）摘要２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrgkmeisai2 ztyshrgkmeisai2}</td><td>（中継用）支払金額明細２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytekiyou3 ztytekiyou3}</td><td>（中継用）摘要３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrgkmeisai3 ztyshrgkmeisai3}</td><td>（中継用）支払金額明細３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytekiyou4 ztytekiyou4}</td><td>（中継用）摘要４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrgkmeisai4 ztyshrgkmeisai4}</td><td>（中継用）支払金額明細４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytekiyou5 ztytekiyou5}</td><td>（中継用）摘要５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrgkmeisai5 ztyshrgkmeisai5}</td><td>（中継用）支払金額明細５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytekiyou6 ztytekiyou6}</td><td>（中継用）摘要６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrgkmeisai6 ztyshrgkmeisai6}</td><td>（中継用）支払金額明細６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytekiyou7 ztytekiyou7}</td><td>（中継用）摘要７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrgkmeisai7 ztyshrgkmeisai7}</td><td>（中継用）支払金額明細７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytekiyou8 ztytekiyou8}</td><td>（中継用）摘要８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrgkmeisai8 ztyshrgkmeisai8}</td><td>（中継用）支払金額明細８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrgkgoukei ztyshrgkgoukei}</td><td>（中継用）支払額合計</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrgkkeiknsngo ztyshrgkkeiknsngo}</td><td>（中継用）支払額合計（換算後）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtytuukasyu ztytuukasyu}</td><td>（中継用）通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynykntuukasyu ztynykntuukasyu}</td><td>（中継用）入金通貨種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyshrtkykwsrate ztyshrtkykwsrate}</td><td>（中継用）支払時適用為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>{@link #getZtytkytuukasyuryk ztytkytuukasyuryk}</td><td>（中継用）適用通貨種類略称</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv43x2 ztyyobiv43x2}</td><td>（中継用）予備項目Ｖ４３＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybanknmkj ztybanknmkj}</td><td>（中継用）銀行名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysitennmkj ztysitennmkj}</td><td>（中継用）支店名（漢字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyokinkbn ztyyokinkbn}</td><td>（中継用）預金種目区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykouzano12keta ztykouzano12keta}</td><td>（中継用）口座番号（１２桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzmeiginmkn ztykzmeiginmkn}</td><td>（中継用）口座名義人氏名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykouzasyuruikbn ztykouzasyuruikbn}</td><td>（中継用）口座種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyenshrtkumu ztyyenshrtkumu}</td><td>（中継用）円支払特約有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv55 ztyyobiv55}</td><td>（中継用）予備項目Ｖ５５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtykeihi ztyhtykeihi}</td><td>（中継用）必要経費</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysaeki ztysaeki}</td><td>（中継用）差益</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysynykngk ztysynykngk}</td><td>（中継用）収入金額</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon1 ztyosirasemongon1}</td><td>（中継用）お知らせ文言１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon2 ztyosirasemongon2}</td><td>（中継用）お知らせ文言２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon3 ztyosirasemongon3}</td><td>（中継用）お知らせ文言３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon4 ztyosirasemongon4}</td><td>（中継用）お知らせ文言４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon5 ztyosirasemongon5}</td><td>（中継用）お知らせ文言５</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon6 ztyosirasemongon6}</td><td>（中継用）お知らせ文言６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon7 ztyosirasemongon7}</td><td>（中継用）お知らせ文言７</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon8 ztyosirasemongon8}</td><td>（中継用）お知らせ文言８</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon9 ztyosirasemongon9}</td><td>（中継用）お知らせ文言９</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon10 ztyosirasemongon10}</td><td>（中継用）お知らせ文言１０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon11 ztyosirasemongon11}</td><td>（中継用）お知らせ文言１１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon12 ztyosirasemongon12}</td><td>（中継用）お知らせ文言１２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon13 ztyosirasemongon13}</td><td>（中継用）お知らせ文言１３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyosirasemongon14 ztyosirasemongon14}</td><td>（中継用）お知らせ文言１４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzeimumongon1 ztyzeimumongon1}</td><td>（中継用）税務文言１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzeimumongon2 ztyzeimumongon2}</td><td>（中継用）税務文言２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzeimumongon3 ztyzeimumongon3}</td><td>（中継用）税務文言３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzeimumongon4 ztyzeimumongon4}</td><td>（中継用）税務文言４</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv50 ztyyobiv50}</td><td>（中継用）予備項目Ｖ５０</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_TtdkKanKiykTy
 * @see     PKZT_TtdkKanKiykTy
 * @see     QZT_TtdkKanKiykTy
 * @see     GenQZT_TtdkKanKiykTy
 */
@MappedSuperclass
@Table(name=GenZT_TtdkKanKiykTy.TABLE_NAME)
@IdClass(value=PKZT_TtdkKanKiykTy.class)
public abstract class GenZT_TtdkKanKiykTy extends AbstractExDBEntity<ZT_TtdkKanKiykTy, PKZT_TtdkKanKiykTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_TtdkKanKiykTy";
    public static final String ZTYSYORUICD              = "ztysyoruicd";
    public static final String ZTYTYOUHYOUYMD           = "ztytyouhyouymd";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYHASSOUKBN             = "ztyhassoukbn";
    public static final String ZTYSYODOUHUUKBN          = "ztysyodouhuukbn";
    public static final String ZTYYOBIV24               = "ztyyobiv24";
    public static final String ZTYSYORUICD2             = "ztysyoruicd2";
    public static final String ZTYTYOUHYOUYMD2          = "ztytyouhyouymd2";
    public static final String ZTYSYONO2                = "ztysyono2";
    public static final String ZTYHASSOUKBN2            = "ztyhassoukbn2";
    public static final String ZTYSYODOUHUUKBN2         = "ztysyodouhuukbn2";
    public static final String ZTYSIKIBETUNO            = "ztysikibetuno";
    public static final String ZTYYOBIV44               = "ztyyobiv44";
    public static final String ZTYSHSKYNO               = "ztyshskyno";
    public static final String ZTYSHSKADR1KJ            = "ztyshskadr1kj";
    public static final String ZTYSHSKADR2KJ            = "ztyshskadr2kj";
    public static final String ZTYSHSKADR3KJ            = "ztyshskadr3kj";
    public static final String ZTYSHSNMKJTTDK           = "ztyshsnmkjttdk";
    public static final String ZTYYOBIV43               = "ztyyobiv43";
    public static final String ZTYTAWSOSIKIKJ           = "ztytawsosikikj";
    public static final String ZTYTAWYNO                = "ztytawyno";
    public static final String ZTYTAWADR1KJ             = "ztytawadr1kj";
    public static final String ZTYTAWADR2KJ             = "ztytawadr2kj";
    public static final String ZTYTAWADR3KJ             = "ztytawadr3kj";
    public static final String ZTYTAWTELNO              = "ztytawtelno";
    public static final String ZTYTAWTELUKTKKANOU1      = "ztytawteluktkkanou1";
    public static final String ZTYTAWTELUKTKKANOU2      = "ztytawteluktkkanou2";
    public static final String ZTYDAI2TAWSOSIKINMKJ     = "ztydai2tawsosikinmkj";
    public static final String ZTYDAI2TAWTELNO          = "ztydai2tawtelno";
    public static final String ZTYSCLATOSYONO           = "ztysclatosyono";
    public static final String ZTYSAKUNM                = "ztysakunm";
    public static final String ZTYYOBIV66               = "ztyyobiv66";
    public static final String ZTYSYONO3                = "ztysyono3";
    public static final String ZTYSHRYMD                = "ztyshrymd";
    public static final String ZTYKEISANKIJYUNYMD       = "ztykeisankijyunymd";
    public static final String ZTYHHKNNMKJ              = "ztyhhknnmkj";
    public static final String ZTYKYKNMKJ               = "ztykyknmkj";
    public static final String ZTYYOBIV73               = "ztyyobiv73";
    public static final String ZTYTEKIYOU1              = "ztytekiyou1";
    public static final String ZTYSHRGKMEISAI1          = "ztyshrgkmeisai1";
    public static final String ZTYTEKIYOU2              = "ztytekiyou2";
    public static final String ZTYSHRGKMEISAI2          = "ztyshrgkmeisai2";
    public static final String ZTYTEKIYOU3              = "ztytekiyou3";
    public static final String ZTYSHRGKMEISAI3          = "ztyshrgkmeisai3";
    public static final String ZTYTEKIYOU4              = "ztytekiyou4";
    public static final String ZTYSHRGKMEISAI4          = "ztyshrgkmeisai4";
    public static final String ZTYTEKIYOU5              = "ztytekiyou5";
    public static final String ZTYSHRGKMEISAI5          = "ztyshrgkmeisai5";
    public static final String ZTYTEKIYOU6              = "ztytekiyou6";
    public static final String ZTYSHRGKMEISAI6          = "ztyshrgkmeisai6";
    public static final String ZTYTEKIYOU7              = "ztytekiyou7";
    public static final String ZTYSHRGKMEISAI7          = "ztyshrgkmeisai7";
    public static final String ZTYTEKIYOU8              = "ztytekiyou8";
    public static final String ZTYSHRGKMEISAI8          = "ztyshrgkmeisai8";
    public static final String ZTYSHRGKGOUKEI           = "ztyshrgkgoukei";
    public static final String ZTYSHRGKKEIKNSNGO        = "ztyshrgkkeiknsngo";
    public static final String ZTYTUUKASYU              = "ztytuukasyu";
    public static final String ZTYNYKNTUUKASYU          = "ztynykntuukasyu";
    public static final String ZTYSHRTKYKWSRATE         = "ztyshrtkykwsrate";
    public static final String ZTYTKYTUUKASYURYK        = "ztytkytuukasyuryk";
    public static final String ZTYYOBIV43X2             = "ztyyobiv43x2";
    public static final String ZTYBANKNMKJ              = "ztybanknmkj";
    public static final String ZTYSITENNMKJ             = "ztysitennmkj";
    public static final String ZTYYOKINKBN              = "ztyyokinkbn";
    public static final String ZTYKOUZANO12KETA         = "ztykouzano12keta";
    public static final String ZTYKZMEIGINMKN           = "ztykzmeiginmkn";
    public static final String ZTYKOUZASYURUIKBN        = "ztykouzasyuruikbn";
    public static final String ZTYYENSHRTKUMU           = "ztyyenshrtkumu";
    public static final String ZTYYOBIV55               = "ztyyobiv55";
    public static final String ZTYHTYKEIHI              = "ztyhtykeihi";
    public static final String ZTYSAEKI                 = "ztysaeki";
    public static final String ZTYSYNYKNGK              = "ztysynykngk";
    public static final String ZTYOSIRASEMONGON1        = "ztyosirasemongon1";
    public static final String ZTYOSIRASEMONGON2        = "ztyosirasemongon2";
    public static final String ZTYOSIRASEMONGON3        = "ztyosirasemongon3";
    public static final String ZTYOSIRASEMONGON4        = "ztyosirasemongon4";
    public static final String ZTYOSIRASEMONGON5        = "ztyosirasemongon5";
    public static final String ZTYOSIRASEMONGON6        = "ztyosirasemongon6";
    public static final String ZTYOSIRASEMONGON7        = "ztyosirasemongon7";
    public static final String ZTYOSIRASEMONGON8        = "ztyosirasemongon8";
    public static final String ZTYOSIRASEMONGON9        = "ztyosirasemongon9";
    public static final String ZTYOSIRASEMONGON10       = "ztyosirasemongon10";
    public static final String ZTYOSIRASEMONGON11       = "ztyosirasemongon11";
    public static final String ZTYOSIRASEMONGON12       = "ztyosirasemongon12";
    public static final String ZTYOSIRASEMONGON13       = "ztyosirasemongon13";
    public static final String ZTYOSIRASEMONGON14       = "ztyosirasemongon14";
    public static final String ZTYZEIMUMONGON1          = "ztyzeimumongon1";
    public static final String ZTYZEIMUMONGON2          = "ztyzeimumongon2";
    public static final String ZTYZEIMUMONGON3          = "ztyzeimumongon3";
    public static final String ZTYZEIMUMONGON4          = "ztyzeimumongon4";
    public static final String ZTYYOBIV50               = "ztyyobiv50";

    private final PKZT_TtdkKanKiykTy primaryKey;

    public GenZT_TtdkKanKiykTy() {
        primaryKey = new PKZT_TtdkKanKiykTy();
    }

    public GenZT_TtdkKanKiykTy(
        String pZtytyouhyouymd,
        String pZtysyono,
        String pZtysikibetuno
    ) {
        primaryKey = new PKZT_TtdkKanKiykTy(
            pZtytyouhyouymd,
            pZtysyono,
            pZtysikibetuno
        );
    }

    @Transient
    @Override
    public PKZT_TtdkKanKiykTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_TtdkKanKiykTy> getMetaClass() {
        return QZT_TtdkKanKiykTy.class;
    }

    private String ztysyoruicd;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYSYORUICD)
    public String getZtysyoruicd() {
        return ztysyoruicd;
    }

    public void setZtysyoruicd(String pZtysyoruicd) {
        ztysyoruicd = pZtysyoruicd;
    }

    @Id
    @Column(name=GenZT_TtdkKanKiykTy.ZTYTYOUHYOUYMD)
    public String getZtytyouhyouymd() {
        return getPrimaryKey().getZtytyouhyouymd();
    }

    public void setZtytyouhyouymd(String pZtytyouhyouymd) {
        getPrimaryKey().setZtytyouhyouymd(pZtytyouhyouymd);
    }

    @Id
    @Column(name=GenZT_TtdkKanKiykTy.ZTYSYONO)
    public String getZtysyono() {
        return getPrimaryKey().getZtysyono();
    }

    public void setZtysyono(String pZtysyono) {
        getPrimaryKey().setZtysyono(pZtysyono);
    }

    private String ztyhassoukbn;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYHASSOUKBN)
    public String getZtyhassoukbn() {
        return ztyhassoukbn;
    }

    public void setZtyhassoukbn(String pZtyhassoukbn) {
        ztyhassoukbn = pZtyhassoukbn;
    }

    private String ztysyodouhuukbn;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYSYODOUHUUKBN)
    public String getZtysyodouhuukbn() {
        return ztysyodouhuukbn;
    }

    public void setZtysyodouhuukbn(String pZtysyodouhuukbn) {
        ztysyodouhuukbn = pZtysyodouhuukbn;
    }

    private String ztyyobiv24;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYYOBIV24)
    public String getZtyyobiv24() {
        return ztyyobiv24;
    }

    public void setZtyyobiv24(String pZtyyobiv24) {
        ztyyobiv24 = pZtyyobiv24;
    }

    private String ztysyoruicd2;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYSYORUICD2)
    public String getZtysyoruicd2() {
        return ztysyoruicd2;
    }

    public void setZtysyoruicd2(String pZtysyoruicd2) {
        ztysyoruicd2 = pZtysyoruicd2;
    }

    private String ztytyouhyouymd2;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYTYOUHYOUYMD2)
    public String getZtytyouhyouymd2() {
        return ztytyouhyouymd2;
    }

    public void setZtytyouhyouymd2(String pZtytyouhyouymd2) {
        ztytyouhyouymd2 = pZtytyouhyouymd2;
    }

    private String ztysyono2;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYSYONO2)
    public String getZtysyono2() {
        return ztysyono2;
    }

    public void setZtysyono2(String pZtysyono2) {
        ztysyono2 = pZtysyono2;
    }

    private String ztyhassoukbn2;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYHASSOUKBN2)
    public String getZtyhassoukbn2() {
        return ztyhassoukbn2;
    }

    public void setZtyhassoukbn2(String pZtyhassoukbn2) {
        ztyhassoukbn2 = pZtyhassoukbn2;
    }

    private String ztysyodouhuukbn2;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYSYODOUHUUKBN2)
    public String getZtysyodouhuukbn2() {
        return ztysyodouhuukbn2;
    }

    public void setZtysyodouhuukbn2(String pZtysyodouhuukbn2) {
        ztysyodouhuukbn2 = pZtysyodouhuukbn2;
    }

    @Id
    @Column(name=GenZT_TtdkKanKiykTy.ZTYSIKIBETUNO)
    public String getZtysikibetuno() {
        return getPrimaryKey().getZtysikibetuno();
    }

    public void setZtysikibetuno(String pZtysikibetuno) {
        getPrimaryKey().setZtysikibetuno(pZtysikibetuno);
    }

    private String ztyyobiv44;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYYOBIV44)
    public String getZtyyobiv44() {
        return ztyyobiv44;
    }

    public void setZtyyobiv44(String pZtyyobiv44) {
        ztyyobiv44 = pZtyyobiv44;
    }

    private String ztyshskyno;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYSHSKYNO)
    public String getZtyshskyno() {
        return ztyshskyno;
    }

    public void setZtyshskyno(String pZtyshskyno) {
        ztyshskyno = pZtyshskyno;
    }

    private String ztyshskadr1kj;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYSHSKADR1KJ)
    public String getZtyshskadr1kj() {
        return ztyshskadr1kj;
    }

    public void setZtyshskadr1kj(String pZtyshskadr1kj) {
        ztyshskadr1kj = pZtyshskadr1kj;
    }

    private String ztyshskadr2kj;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYSHSKADR2KJ)
    public String getZtyshskadr2kj() {
        return ztyshskadr2kj;
    }

    public void setZtyshskadr2kj(String pZtyshskadr2kj) {
        ztyshskadr2kj = pZtyshskadr2kj;
    }

    private String ztyshskadr3kj;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYSHSKADR3KJ)
    public String getZtyshskadr3kj() {
        return ztyshskadr3kj;
    }

    public void setZtyshskadr3kj(String pZtyshskadr3kj) {
        ztyshskadr3kj = pZtyshskadr3kj;
    }

    private String ztyshsnmkjttdk;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYSHSNMKJTTDK)
    public String getZtyshsnmkjttdk() {
        return ztyshsnmkjttdk;
    }

    public void setZtyshsnmkjttdk(String pZtyshsnmkjttdk) {
        ztyshsnmkjttdk = pZtyshsnmkjttdk;
    }

    private String ztyyobiv43;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYYOBIV43)
    public String getZtyyobiv43() {
        return ztyyobiv43;
    }

    public void setZtyyobiv43(String pZtyyobiv43) {
        ztyyobiv43 = pZtyyobiv43;
    }

    private String ztytawsosikikj;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYTAWSOSIKIKJ)
    public String getZtytawsosikikj() {
        return ztytawsosikikj;
    }

    public void setZtytawsosikikj(String pZtytawsosikikj) {
        ztytawsosikikj = pZtytawsosikikj;
    }

    private String ztytawyno;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYTAWYNO)
    public String getZtytawyno() {
        return ztytawyno;
    }

    public void setZtytawyno(String pZtytawyno) {
        ztytawyno = pZtytawyno;
    }

    private String ztytawadr1kj;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYTAWADR1KJ)
    public String getZtytawadr1kj() {
        return ztytawadr1kj;
    }

    public void setZtytawadr1kj(String pZtytawadr1kj) {
        ztytawadr1kj = pZtytawadr1kj;
    }

    private String ztytawadr2kj;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYTAWADR2KJ)
    public String getZtytawadr2kj() {
        return ztytawadr2kj;
    }

    public void setZtytawadr2kj(String pZtytawadr2kj) {
        ztytawadr2kj = pZtytawadr2kj;
    }

    private String ztytawadr3kj;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYTAWADR3KJ)
    public String getZtytawadr3kj() {
        return ztytawadr3kj;
    }

    public void setZtytawadr3kj(String pZtytawadr3kj) {
        ztytawadr3kj = pZtytawadr3kj;
    }

    private String ztytawtelno;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYTAWTELNO)
    public String getZtytawtelno() {
        return ztytawtelno;
    }

    public void setZtytawtelno(String pZtytawtelno) {
        ztytawtelno = pZtytawtelno;
    }

    private String ztytawteluktkkanou1;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYTAWTELUKTKKANOU1)
    public String getZtytawteluktkkanou1() {
        return ztytawteluktkkanou1;
    }

    public void setZtytawteluktkkanou1(String pZtytawteluktkkanou1) {
        ztytawteluktkkanou1 = pZtytawteluktkkanou1;
    }

    private String ztytawteluktkkanou2;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYTAWTELUKTKKANOU2)
    public String getZtytawteluktkkanou2() {
        return ztytawteluktkkanou2;
    }

    public void setZtytawteluktkkanou2(String pZtytawteluktkkanou2) {
        ztytawteluktkkanou2 = pZtytawteluktkkanou2;
    }

    private String ztydai2tawsosikinmkj;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYDAI2TAWSOSIKINMKJ)
    public String getZtydai2tawsosikinmkj() {
        return ztydai2tawsosikinmkj;
    }

    public void setZtydai2tawsosikinmkj(String pZtydai2tawsosikinmkj) {
        ztydai2tawsosikinmkj = pZtydai2tawsosikinmkj;
    }

    private String ztydai2tawtelno;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYDAI2TAWTELNO)
    public String getZtydai2tawtelno() {
        return ztydai2tawtelno;
    }

    public void setZtydai2tawtelno(String pZtydai2tawtelno) {
        ztydai2tawtelno = pZtydai2tawtelno;
    }

    private String ztysclatosyono;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYSCLATOSYONO)
    public String getZtysclatosyono() {
        return ztysclatosyono;
    }

    public void setZtysclatosyono(String pZtysclatosyono) {
        ztysclatosyono = pZtysclatosyono;
    }

    private String ztysakunm;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYSAKUNM)
    public String getZtysakunm() {
        return ztysakunm;
    }

    public void setZtysakunm(String pZtysakunm) {
        ztysakunm = pZtysakunm;
    }

    private String ztyyobiv66;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYYOBIV66)
    public String getZtyyobiv66() {
        return ztyyobiv66;
    }

    public void setZtyyobiv66(String pZtyyobiv66) {
        ztyyobiv66 = pZtyyobiv66;
    }

    private String ztysyono3;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYSYONO3)
    public String getZtysyono3() {
        return ztysyono3;
    }

    public void setZtysyono3(String pZtysyono3) {
        ztysyono3 = pZtysyono3;
    }

    private String ztyshrymd;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYSHRYMD)
    public String getZtyshrymd() {
        return ztyshrymd;
    }

    public void setZtyshrymd(String pZtyshrymd) {
        ztyshrymd = pZtyshrymd;
    }

    private String ztykeisankijyunymd;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYKEISANKIJYUNYMD)
    public String getZtykeisankijyunymd() {
        return ztykeisankijyunymd;
    }

    public void setZtykeisankijyunymd(String pZtykeisankijyunymd) {
        ztykeisankijyunymd = pZtykeisankijyunymd;
    }

    private String ztyhhknnmkj;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYHHKNNMKJ)
    public String getZtyhhknnmkj() {
        return ztyhhknnmkj;
    }

    public void setZtyhhknnmkj(String pZtyhhknnmkj) {
        ztyhhknnmkj = pZtyhhknnmkj;
    }

    private String ztykyknmkj;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYKYKNMKJ)
    public String getZtykyknmkj() {
        return ztykyknmkj;
    }

    public void setZtykyknmkj(String pZtykyknmkj) {
        ztykyknmkj = pZtykyknmkj;
    }

    private String ztyyobiv73;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYYOBIV73)
    public String getZtyyobiv73() {
        return ztyyobiv73;
    }

    public void setZtyyobiv73(String pZtyyobiv73) {
        ztyyobiv73 = pZtyyobiv73;
    }

    private String ztytekiyou1;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYTEKIYOU1)
    public String getZtytekiyou1() {
        return ztytekiyou1;
    }

    public void setZtytekiyou1(String pZtytekiyou1) {
        ztytekiyou1 = pZtytekiyou1;
    }

    private String ztyshrgkmeisai1;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYSHRGKMEISAI1)
    public String getZtyshrgkmeisai1() {
        return ztyshrgkmeisai1;
    }

    public void setZtyshrgkmeisai1(String pZtyshrgkmeisai1) {
        ztyshrgkmeisai1 = pZtyshrgkmeisai1;
    }

    private String ztytekiyou2;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYTEKIYOU2)
    public String getZtytekiyou2() {
        return ztytekiyou2;
    }

    public void setZtytekiyou2(String pZtytekiyou2) {
        ztytekiyou2 = pZtytekiyou2;
    }

    private String ztyshrgkmeisai2;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYSHRGKMEISAI2)
    public String getZtyshrgkmeisai2() {
        return ztyshrgkmeisai2;
    }

    public void setZtyshrgkmeisai2(String pZtyshrgkmeisai2) {
        ztyshrgkmeisai2 = pZtyshrgkmeisai2;
    }

    private String ztytekiyou3;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYTEKIYOU3)
    public String getZtytekiyou3() {
        return ztytekiyou3;
    }

    public void setZtytekiyou3(String pZtytekiyou3) {
        ztytekiyou3 = pZtytekiyou3;
    }

    private String ztyshrgkmeisai3;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYSHRGKMEISAI3)
    public String getZtyshrgkmeisai3() {
        return ztyshrgkmeisai3;
    }

    public void setZtyshrgkmeisai3(String pZtyshrgkmeisai3) {
        ztyshrgkmeisai3 = pZtyshrgkmeisai3;
    }

    private String ztytekiyou4;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYTEKIYOU4)
    public String getZtytekiyou4() {
        return ztytekiyou4;
    }

    public void setZtytekiyou4(String pZtytekiyou4) {
        ztytekiyou4 = pZtytekiyou4;
    }

    private String ztyshrgkmeisai4;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYSHRGKMEISAI4)
    public String getZtyshrgkmeisai4() {
        return ztyshrgkmeisai4;
    }

    public void setZtyshrgkmeisai4(String pZtyshrgkmeisai4) {
        ztyshrgkmeisai4 = pZtyshrgkmeisai4;
    }

    private String ztytekiyou5;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYTEKIYOU5)
    public String getZtytekiyou5() {
        return ztytekiyou5;
    }

    public void setZtytekiyou5(String pZtytekiyou5) {
        ztytekiyou5 = pZtytekiyou5;
    }

    private String ztyshrgkmeisai5;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYSHRGKMEISAI5)
    public String getZtyshrgkmeisai5() {
        return ztyshrgkmeisai5;
    }

    public void setZtyshrgkmeisai5(String pZtyshrgkmeisai5) {
        ztyshrgkmeisai5 = pZtyshrgkmeisai5;
    }

    private String ztytekiyou6;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYTEKIYOU6)
    public String getZtytekiyou6() {
        return ztytekiyou6;
    }

    public void setZtytekiyou6(String pZtytekiyou6) {
        ztytekiyou6 = pZtytekiyou6;
    }

    private String ztyshrgkmeisai6;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYSHRGKMEISAI6)
    public String getZtyshrgkmeisai6() {
        return ztyshrgkmeisai6;
    }

    public void setZtyshrgkmeisai6(String pZtyshrgkmeisai6) {
        ztyshrgkmeisai6 = pZtyshrgkmeisai6;
    }

    private String ztytekiyou7;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYTEKIYOU7)
    public String getZtytekiyou7() {
        return ztytekiyou7;
    }

    public void setZtytekiyou7(String pZtytekiyou7) {
        ztytekiyou7 = pZtytekiyou7;
    }

    private String ztyshrgkmeisai7;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYSHRGKMEISAI7)
    public String getZtyshrgkmeisai7() {
        return ztyshrgkmeisai7;
    }

    public void setZtyshrgkmeisai7(String pZtyshrgkmeisai7) {
        ztyshrgkmeisai7 = pZtyshrgkmeisai7;
    }

    private String ztytekiyou8;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYTEKIYOU8)
    public String getZtytekiyou8() {
        return ztytekiyou8;
    }

    public void setZtytekiyou8(String pZtytekiyou8) {
        ztytekiyou8 = pZtytekiyou8;
    }

    private String ztyshrgkmeisai8;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYSHRGKMEISAI8)
    public String getZtyshrgkmeisai8() {
        return ztyshrgkmeisai8;
    }

    public void setZtyshrgkmeisai8(String pZtyshrgkmeisai8) {
        ztyshrgkmeisai8 = pZtyshrgkmeisai8;
    }

    private String ztyshrgkgoukei;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYSHRGKGOUKEI)
    public String getZtyshrgkgoukei() {
        return ztyshrgkgoukei;
    }

    public void setZtyshrgkgoukei(String pZtyshrgkgoukei) {
        ztyshrgkgoukei = pZtyshrgkgoukei;
    }

    private Double ztyshrgkkeiknsngo;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYSHRGKKEIKNSNGO)
    public Double getZtyshrgkkeiknsngo() {
        return ztyshrgkkeiknsngo;
    }

    public void setZtyshrgkkeiknsngo(Double pZtyshrgkkeiknsngo) {
        ztyshrgkkeiknsngo = pZtyshrgkkeiknsngo;
    }

    private String ztytuukasyu;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYTUUKASYU)
    public String getZtytuukasyu() {
        return ztytuukasyu;
    }

    public void setZtytuukasyu(String pZtytuukasyu) {
        ztytuukasyu = pZtytuukasyu;
    }

    private String ztynykntuukasyu;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYNYKNTUUKASYU)
    public String getZtynykntuukasyu() {
        return ztynykntuukasyu;
    }

    public void setZtynykntuukasyu(String pZtynykntuukasyu) {
        ztynykntuukasyu = pZtynykntuukasyu;
    }

    private Double ztyshrtkykwsrate;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYSHRTKYKWSRATE)
    public Double getZtyshrtkykwsrate() {
        return ztyshrtkykwsrate;
    }

    public void setZtyshrtkykwsrate(Double pZtyshrtkykwsrate) {
        ztyshrtkykwsrate = pZtyshrtkykwsrate;
    }

    private String ztytkytuukasyuryk;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYTKYTUUKASYURYK)
    public String getZtytkytuukasyuryk() {
        return ztytkytuukasyuryk;
    }

    public void setZtytkytuukasyuryk(String pZtytkytuukasyuryk) {
        ztytkytuukasyuryk = pZtytkytuukasyuryk;
    }

    private String ztyyobiv43x2;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYYOBIV43X2)
    public String getZtyyobiv43x2() {
        return ztyyobiv43x2;
    }

    public void setZtyyobiv43x2(String pZtyyobiv43x2) {
        ztyyobiv43x2 = pZtyyobiv43x2;
    }

    private String ztybanknmkj;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYBANKNMKJ)
    public String getZtybanknmkj() {
        return ztybanknmkj;
    }

    public void setZtybanknmkj(String pZtybanknmkj) {
        ztybanknmkj = pZtybanknmkj;
    }

    private String ztysitennmkj;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYSITENNMKJ)
    public String getZtysitennmkj() {
        return ztysitennmkj;
    }

    public void setZtysitennmkj(String pZtysitennmkj) {
        ztysitennmkj = pZtysitennmkj;
    }

    private String ztyyokinkbn;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYYOKINKBN)
    public String getZtyyokinkbn() {
        return ztyyokinkbn;
    }

    public void setZtyyokinkbn(String pZtyyokinkbn) {
        ztyyokinkbn = pZtyyokinkbn;
    }

    private String ztykouzano12keta;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYKOUZANO12KETA)
    public String getZtykouzano12keta() {
        return ztykouzano12keta;
    }

    public void setZtykouzano12keta(String pZtykouzano12keta) {
        ztykouzano12keta = pZtykouzano12keta;
    }

    private String ztykzmeiginmkn;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYKZMEIGINMKN)
    public String getZtykzmeiginmkn() {
        return ztykzmeiginmkn;
    }

    @Trim("right")
    @DataConvert("toMultiByte")
    public void setZtykzmeiginmkn(String pZtykzmeiginmkn) {
        ztykzmeiginmkn = pZtykzmeiginmkn;
    }

    private String ztykouzasyuruikbn;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYKOUZASYURUIKBN)
    public String getZtykouzasyuruikbn() {
        return ztykouzasyuruikbn;
    }

    public void setZtykouzasyuruikbn(String pZtykouzasyuruikbn) {
        ztykouzasyuruikbn = pZtykouzasyuruikbn;
    }

    private String ztyyenshrtkumu;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYYENSHRTKUMU)
    public String getZtyyenshrtkumu() {
        return ztyyenshrtkumu;
    }

    public void setZtyyenshrtkumu(String pZtyyenshrtkumu) {
        ztyyenshrtkumu = pZtyyenshrtkumu;
    }

    private String ztyyobiv55;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYYOBIV55)
    public String getZtyyobiv55() {
        return ztyyobiv55;
    }

    public void setZtyyobiv55(String pZtyyobiv55) {
        ztyyobiv55 = pZtyyobiv55;
    }

    private String ztyhtykeihi;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYHTYKEIHI)
    public String getZtyhtykeihi() {
        return ztyhtykeihi;
    }

    public void setZtyhtykeihi(String pZtyhtykeihi) {
        ztyhtykeihi = pZtyhtykeihi;
    }

    private Long ztysaeki;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYSAEKI)
    public Long getZtysaeki() {
        return ztysaeki;
    }

    public void setZtysaeki(Long pZtysaeki) {
        ztysaeki = pZtysaeki;
    }

    private String ztysynykngk;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYSYNYKNGK)
    public String getZtysynykngk() {
        return ztysynykngk;
    }

    public void setZtysynykngk(String pZtysynykngk) {
        ztysynykngk = pZtysynykngk;
    }

    private String ztyosirasemongon1;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYOSIRASEMONGON1)
    public String getZtyosirasemongon1() {
        return ztyosirasemongon1;
    }

    public void setZtyosirasemongon1(String pZtyosirasemongon1) {
        ztyosirasemongon1 = pZtyosirasemongon1;
    }

    private String ztyosirasemongon2;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYOSIRASEMONGON2)
    public String getZtyosirasemongon2() {
        return ztyosirasemongon2;
    }

    public void setZtyosirasemongon2(String pZtyosirasemongon2) {
        ztyosirasemongon2 = pZtyosirasemongon2;
    }

    private String ztyosirasemongon3;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYOSIRASEMONGON3)
    public String getZtyosirasemongon3() {
        return ztyosirasemongon3;
    }

    public void setZtyosirasemongon3(String pZtyosirasemongon3) {
        ztyosirasemongon3 = pZtyosirasemongon3;
    }

    private String ztyosirasemongon4;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYOSIRASEMONGON4)
    public String getZtyosirasemongon4() {
        return ztyosirasemongon4;
    }

    public void setZtyosirasemongon4(String pZtyosirasemongon4) {
        ztyosirasemongon4 = pZtyosirasemongon4;
    }

    private String ztyosirasemongon5;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYOSIRASEMONGON5)
    public String getZtyosirasemongon5() {
        return ztyosirasemongon5;
    }

    public void setZtyosirasemongon5(String pZtyosirasemongon5) {
        ztyosirasemongon5 = pZtyosirasemongon5;
    }

    private String ztyosirasemongon6;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYOSIRASEMONGON6)
    public String getZtyosirasemongon6() {
        return ztyosirasemongon6;
    }

    public void setZtyosirasemongon6(String pZtyosirasemongon6) {
        ztyosirasemongon6 = pZtyosirasemongon6;
    }

    private String ztyosirasemongon7;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYOSIRASEMONGON7)
    public String getZtyosirasemongon7() {
        return ztyosirasemongon7;
    }

    public void setZtyosirasemongon7(String pZtyosirasemongon7) {
        ztyosirasemongon7 = pZtyosirasemongon7;
    }

    private String ztyosirasemongon8;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYOSIRASEMONGON8)
    public String getZtyosirasemongon8() {
        return ztyosirasemongon8;
    }

    public void setZtyosirasemongon8(String pZtyosirasemongon8) {
        ztyosirasemongon8 = pZtyosirasemongon8;
    }

    private String ztyosirasemongon9;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYOSIRASEMONGON9)
    public String getZtyosirasemongon9() {
        return ztyosirasemongon9;
    }

    public void setZtyosirasemongon9(String pZtyosirasemongon9) {
        ztyosirasemongon9 = pZtyosirasemongon9;
    }

    private String ztyosirasemongon10;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYOSIRASEMONGON10)
    public String getZtyosirasemongon10() {
        return ztyosirasemongon10;
    }

    public void setZtyosirasemongon10(String pZtyosirasemongon10) {
        ztyosirasemongon10 = pZtyosirasemongon10;
    }

    private String ztyosirasemongon11;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYOSIRASEMONGON11)
    public String getZtyosirasemongon11() {
        return ztyosirasemongon11;
    }

    public void setZtyosirasemongon11(String pZtyosirasemongon11) {
        ztyosirasemongon11 = pZtyosirasemongon11;
    }

    private String ztyosirasemongon12;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYOSIRASEMONGON12)
    public String getZtyosirasemongon12() {
        return ztyosirasemongon12;
    }

    public void setZtyosirasemongon12(String pZtyosirasemongon12) {
        ztyosirasemongon12 = pZtyosirasemongon12;
    }

    private String ztyosirasemongon13;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYOSIRASEMONGON13)
    public String getZtyosirasemongon13() {
        return ztyosirasemongon13;
    }

    public void setZtyosirasemongon13(String pZtyosirasemongon13) {
        ztyosirasemongon13 = pZtyosirasemongon13;
    }

    private String ztyosirasemongon14;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYOSIRASEMONGON14)
    public String getZtyosirasemongon14() {
        return ztyosirasemongon14;
    }

    public void setZtyosirasemongon14(String pZtyosirasemongon14) {
        ztyosirasemongon14 = pZtyosirasemongon14;
    }

    private String ztyzeimumongon1;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYZEIMUMONGON1)
    public String getZtyzeimumongon1() {
        return ztyzeimumongon1;
    }

    public void setZtyzeimumongon1(String pZtyzeimumongon1) {
        ztyzeimumongon1 = pZtyzeimumongon1;
    }

    private String ztyzeimumongon2;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYZEIMUMONGON2)
    public String getZtyzeimumongon2() {
        return ztyzeimumongon2;
    }

    public void setZtyzeimumongon2(String pZtyzeimumongon2) {
        ztyzeimumongon2 = pZtyzeimumongon2;
    }

    private String ztyzeimumongon3;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYZEIMUMONGON3)
    public String getZtyzeimumongon3() {
        return ztyzeimumongon3;
    }

    public void setZtyzeimumongon3(String pZtyzeimumongon3) {
        ztyzeimumongon3 = pZtyzeimumongon3;
    }

    private String ztyzeimumongon4;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYZEIMUMONGON4)
    public String getZtyzeimumongon4() {
        return ztyzeimumongon4;
    }

    public void setZtyzeimumongon4(String pZtyzeimumongon4) {
        ztyzeimumongon4 = pZtyzeimumongon4;
    }

    private String ztyyobiv50;

    @Column(name=GenZT_TtdkKanKiykTy.ZTYYOBIV50)
    public String getZtyyobiv50() {
        return ztyyobiv50;
    }

    public void setZtyyobiv50(String pZtyyobiv50) {
        ztyyobiv50 = pZtyyobiv50;
    }
}
