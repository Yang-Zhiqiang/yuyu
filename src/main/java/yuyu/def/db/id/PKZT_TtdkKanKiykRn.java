package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_TtdkKanKiykRn;
import yuyu.def.db.mapping.GenZT_TtdkKanKiykRn;
import yuyu.def.db.meta.GenQZT_TtdkKanKiykRn;
import yuyu.def.db.meta.QZT_TtdkKanKiykRn;

/**
 * 手続完了（解約）Ｆテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_TtdkKanKiykRn}</td><td colspan="3">手続完了（解約）Ｆテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>zrnsyoruicd</td><td>（連携用）書類コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrntyouhyouymd zrntyouhyouymd}</td><td>（連携用）帳票作成日</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhassoukbn</td><td>（連携用）発送区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyodouhuukbn</td><td>（連携用）証券同封区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv24</td><td>（連携用）予備項目Ｖ２４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyoruicd2</td><td>（連携用）書類コード２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntyouhyouymd2</td><td>（連携用）帳票作成日２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyono2</td><td>（連携用）証券番号２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhassoukbn2</td><td>（連携用）発送区分２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyodouhuukbn2</td><td>（連携用）証券同封区分２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsikibetuno zrnsikibetuno}</td><td>（連携用）識別番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv44</td><td>（連携用）予備項目Ｖ４４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnshskyno</td><td>（連携用）送付先郵便番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnshskadr1kj</td><td>（連携用）送付先住所１（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnshskadr2kj</td><td>（連携用）送付先住所２（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnshskadr3kj</td><td>（連携用）送付先住所３（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnshsnmkjttdk</td><td>（連携用）送付先名（漢字）（手続完了）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnyobiv43</td><td>（連携用）予備項目Ｖ４３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntawsosikikj</td><td>（連携用）問合せ先組織名（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntawyno</td><td>（連携用）問合せ先郵便番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntawadr1kj</td><td>（連携用）問合せ先住所１（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntawadr2kj</td><td>（連携用）問合せ先住所２（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntawadr3kj</td><td>（連携用）問合せ先住所３（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntawtelno</td><td>（連携用）問合せ先電話番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntawteluktkkanou1</td><td>（連携用）問合せ先電話受付可能時間１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntawteluktkkanou2</td><td>（連携用）問合せ先電話受付可能時間２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrndai2tawsosikinmkj</td><td>（連携用）第２問合せ先組織名（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrndai2tawtelno</td><td>（連携用）第２問合せ先電話番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsclatosyono</td><td>（連携用）スクランブル後証券番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsakunm</td><td>（連携用）作成番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv66</td><td>（連携用）予備項目Ｖ６６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyono3</td><td>（連携用）証券番号３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnshrymd</td><td>（連携用）支払年月日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkeisankijyunymd</td><td>（連携用）計算基準日</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknnmkj</td><td>（連携用）被保険者名（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkyknmkj</td><td>（連携用）契約者名（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnyobiv73</td><td>（連携用）予備項目Ｖ７３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntekiyou1</td><td>（連携用）摘要１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnshrgkmeisai1</td><td>（連携用）支払金額明細１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntekiyou2</td><td>（連携用）摘要２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnshrgkmeisai2</td><td>（連携用）支払金額明細２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntekiyou3</td><td>（連携用）摘要３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnshrgkmeisai3</td><td>（連携用）支払金額明細３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntekiyou4</td><td>（連携用）摘要４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnshrgkmeisai4</td><td>（連携用）支払金額明細４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntekiyou5</td><td>（連携用）摘要５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnshrgkmeisai5</td><td>（連携用）支払金額明細５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntekiyou6</td><td>（連携用）摘要６</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnshrgkmeisai6</td><td>（連携用）支払金額明細６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntekiyou7</td><td>（連携用）摘要７</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnshrgkmeisai7</td><td>（連携用）支払金額明細７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntekiyou8</td><td>（連携用）摘要８</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnshrgkmeisai8</td><td>（連携用）支払金額明細８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnshrgkgoukei</td><td>（連携用）支払額合計</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnshrgkkeiknsngo</td><td>（連携用）支払額合計（換算後）</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrntuukasyu</td><td>（連携用）通貨種類</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnnykntuukasyu</td><td>（連携用）入金通貨種類</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnshrtkykwsrate</td><td>（連携用）支払時適用為替レート</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrntkytuukasyuryk</td><td>（連携用）適用通貨種類略称</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnyobiv43x2</td><td>（連携用）予備項目Ｖ４３＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnbanknmkj</td><td>（連携用）銀行名（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsitennmkj</td><td>（連携用）支店名（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnyokinkbn</td><td>（連携用）預金種目区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkouzano12keta</td><td>（連携用）口座番号（１２桁）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzmeiginmkn</td><td>（連携用）口座名義人氏名（カナ）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkouzasyuruikbn</td><td>（連携用）口座種類区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyenshrtkumu</td><td>（連携用）円支払特約有無</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv55</td><td>（連携用）予備項目Ｖ５５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhtykeihi</td><td>（連携用）必要経費</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsaeki</td><td>（連携用）差益</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>zrnsynykngk</td><td>（連携用）収入金額</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon1</td><td>（連携用）お知らせ文言１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon2</td><td>（連携用）お知らせ文言２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon3</td><td>（連携用）お知らせ文言３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon4</td><td>（連携用）お知らせ文言４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon5</td><td>（連携用）お知らせ文言５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon6</td><td>（連携用）お知らせ文言６</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon7</td><td>（連携用）お知らせ文言７</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon8</td><td>（連携用）お知らせ文言８</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon9</td><td>（連携用）お知らせ文言９</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon10</td><td>（連携用）お知らせ文言１０</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon11</td><td>（連携用）お知らせ文言１１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon12</td><td>（連携用）お知らせ文言１２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon13</td><td>（連携用）お知らせ文言１３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon14</td><td>（連携用）お知らせ文言１４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnzeimumongon1</td><td>（連携用）税務文言１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnzeimumongon2</td><td>（連携用）税務文言２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnzeimumongon3</td><td>（連携用）税務文言３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnzeimumongon4</td><td>（連携用）税務文言４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnyobiv50</td><td>（連携用）予備項目Ｖ５０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_TtdkKanKiykRn
 * @see     GenZT_TtdkKanKiykRn
 * @see     QZT_TtdkKanKiykRn
 * @see     GenQZT_TtdkKanKiykRn
 */
public class PKZT_TtdkKanKiykRn extends AbstractExDBPrimaryKey<ZT_TtdkKanKiykRn, PKZT_TtdkKanKiykRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_TtdkKanKiykRn() {
    }

    public PKZT_TtdkKanKiykRn(
        String pZrntyouhyouymd,
        String pZrnsyono,
        String pZrnsikibetuno
    ) {
        zrntyouhyouymd = pZrntyouhyouymd;
        zrnsyono = pZrnsyono;
        zrnsikibetuno = pZrnsikibetuno;
    }

    @Transient
    @Override
    public Class<ZT_TtdkKanKiykRn> getEntityClass() {
        return ZT_TtdkKanKiykRn.class;
    }

    private String zrntyouhyouymd;

    public String getZrntyouhyouymd() {
        return zrntyouhyouymd;
    }

    public void setZrntyouhyouymd(String pZrntyouhyouymd) {
        zrntyouhyouymd = pZrntyouhyouymd;
    }
    private String zrnsyono;

    public String getZrnsyono() {
        return zrnsyono;
    }

    public void setZrnsyono(String pZrnsyono) {
        zrnsyono = pZrnsyono;
    }
    private String zrnsikibetuno;

    public String getZrnsikibetuno() {
        return zrnsikibetuno;
    }

    public void setZrnsikibetuno(String pZrnsikibetuno) {
        zrnsikibetuno = pZrnsikibetuno;
    }

}