package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_TtdkKanKiykTy;
import yuyu.def.db.mapping.GenZT_TtdkKanKiykTy;
import yuyu.def.db.meta.GenQZT_TtdkKanKiykTy;
import yuyu.def.db.meta.QZT_TtdkKanKiykTy;

/**
 * 手続完了（解約）Ｆテーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_TtdkKanKiykTy}</td><td colspan="3">手続完了（解約）Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>ztysyoruicd</td><td>（中継用）書類コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtytyouhyouymd ztytyouhyouymd}</td><td>（中継用）帳票作成日</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhassoukbn</td><td>（中継用）発送区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyodouhuukbn</td><td>（中継用）証券同封区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv24</td><td>（中継用）予備項目Ｖ２４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyoruicd2</td><td>（中継用）書類コード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytyouhyouymd2</td><td>（中継用）帳票作成日２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyono2</td><td>（中継用）証券番号２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhassoukbn2</td><td>（中継用）発送区分２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyodouhuukbn2</td><td>（中継用）証券同封区分２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysikibetuno ztysikibetuno}</td><td>（中継用）識別番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv44</td><td>（中継用）予備項目Ｖ４４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshskyno</td><td>（中継用）送付先郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshskadr1kj</td><td>（中継用）送付先住所１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshskadr2kj</td><td>（中継用）送付先住所２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshskadr3kj</td><td>（中継用）送付先住所３（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshsnmkjttdk</td><td>（中継用）送付先名（漢字）（手続完了）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv43</td><td>（中継用）予備項目Ｖ４３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytawsosikikj</td><td>（中継用）問合せ先組織名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytawyno</td><td>（中継用）問合せ先郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytawadr1kj</td><td>（中継用）問合せ先住所１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytawadr2kj</td><td>（中継用）問合せ先住所２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytawadr3kj</td><td>（中継用）問合せ先住所３（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytawtelno</td><td>（中継用）問合せ先電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytawteluktkkanou1</td><td>（中継用）問合せ先電話受付可能時間１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytawteluktkkanou2</td><td>（中継用）問合せ先電話受付可能時間２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydai2tawsosikinmkj</td><td>（中継用）第２問合せ先組織名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydai2tawtelno</td><td>（中継用）第２問合せ先電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysclatosyono</td><td>（中継用）スクランブル後証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysakunm</td><td>（中継用）作成番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv66</td><td>（中継用）予備項目Ｖ６６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyono3</td><td>（中継用）証券番号３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrymd</td><td>（中継用）支払年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykeisankijyunymd</td><td>（中継用）計算基準日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknnmkj</td><td>（中継用）被保険者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyknmkj</td><td>（中継用）契約者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv73</td><td>（中継用）予備項目Ｖ７３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytekiyou1</td><td>（中継用）摘要１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrgkmeisai1</td><td>（中継用）支払金額明細１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytekiyou2</td><td>（中継用）摘要２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrgkmeisai2</td><td>（中継用）支払金額明細２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytekiyou3</td><td>（中継用）摘要３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrgkmeisai3</td><td>（中継用）支払金額明細３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytekiyou4</td><td>（中継用）摘要４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrgkmeisai4</td><td>（中継用）支払金額明細４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytekiyou5</td><td>（中継用）摘要５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrgkmeisai5</td><td>（中継用）支払金額明細５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytekiyou6</td><td>（中継用）摘要６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrgkmeisai6</td><td>（中継用）支払金額明細６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytekiyou7</td><td>（中継用）摘要７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrgkmeisai7</td><td>（中継用）支払金額明細７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytekiyou8</td><td>（中継用）摘要８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrgkmeisai8</td><td>（中継用）支払金額明細８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrgkgoukei</td><td>（中継用）支払額合計</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrgkkeiknsngo</td><td>（中継用）支払額合計（換算後）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztytuukasyu</td><td>（中継用）通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynykntuukasyu</td><td>（中継用）入金通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshrtkykwsrate</td><td>（中継用）支払時適用為替レート</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>ztytkytuukasyuryk</td><td>（中継用）適用通貨種類略称</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv43x2</td><td>（中継用）予備項目Ｖ４３＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztybanknmkj</td><td>（中継用）銀行名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysitennmkj</td><td>（中継用）支店名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyokinkbn</td><td>（中継用）預金種目区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykouzano12keta</td><td>（中継用）口座番号（１２桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzmeiginmkn</td><td>（中継用）口座名義人氏名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykouzasyuruikbn</td><td>（中継用）口座種類区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyenshrtkumu</td><td>（中継用）円支払特約有無</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv55</td><td>（中継用）予備項目Ｖ５５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhtykeihi</td><td>（中継用）必要経費</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysaeki</td><td>（中継用）差益</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysynykngk</td><td>（中継用）収入金額</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon1</td><td>（中継用）お知らせ文言１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon2</td><td>（中継用）お知らせ文言２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon3</td><td>（中継用）お知らせ文言３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon4</td><td>（中継用）お知らせ文言４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon5</td><td>（中継用）お知らせ文言５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon6</td><td>（中継用）お知らせ文言６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon7</td><td>（中継用）お知らせ文言７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon8</td><td>（中継用）お知らせ文言８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon9</td><td>（中継用）お知らせ文言９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon10</td><td>（中継用）お知らせ文言１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon11</td><td>（中継用）お知らせ文言１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon12</td><td>（中継用）お知らせ文言１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon13</td><td>（中継用）お知らせ文言１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyosirasemongon14</td><td>（中継用）お知らせ文言１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzeimumongon1</td><td>（中継用）税務文言１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzeimumongon2</td><td>（中継用）税務文言２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzeimumongon3</td><td>（中継用）税務文言３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzeimumongon4</td><td>（中継用）税務文言４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv50</td><td>（中継用）予備項目Ｖ５０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_TtdkKanKiykTy
 * @see     GenZT_TtdkKanKiykTy
 * @see     QZT_TtdkKanKiykTy
 * @see     GenQZT_TtdkKanKiykTy
 */
public class PKZT_TtdkKanKiykTy extends AbstractExDBPrimaryKey<ZT_TtdkKanKiykTy, PKZT_TtdkKanKiykTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_TtdkKanKiykTy() {
    }

    public PKZT_TtdkKanKiykTy(
        String pZtytyouhyouymd,
        String pZtysyono,
        String pZtysikibetuno
    ) {
        ztytyouhyouymd = pZtytyouhyouymd;
        ztysyono = pZtysyono;
        ztysikibetuno = pZtysikibetuno;
    }

    @Transient
    @Override
    public Class<ZT_TtdkKanKiykTy> getEntityClass() {
        return ZT_TtdkKanKiykTy.class;
    }

    private String ztytyouhyouymd;

    public String getZtytyouhyouymd() {
        return ztytyouhyouymd;
    }

    public void setZtytyouhyouymd(String pZtytyouhyouymd) {
        ztytyouhyouymd = pZtytyouhyouymd;
    }
    private String ztysyono;

    public String getZtysyono() {
        return ztysyono;
    }

    public void setZtysyono(String pZtysyono) {
        ztysyono = pZtysyono;
    }
    private String ztysikibetuno;

    public String getZtysikibetuno() {
        return ztysikibetuno;
    }

    public void setZtysikibetuno(String pZtysikibetuno) {
        ztysikibetuno = pZtysikibetuno;
    }

}