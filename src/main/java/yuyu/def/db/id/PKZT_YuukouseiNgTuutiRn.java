package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_YuukouseiNgTuutiRn;
import yuyu.def.db.mapping.GenZT_YuukouseiNgTuutiRn;
import yuyu.def.db.meta.GenQZT_YuukouseiNgTuutiRn;
import yuyu.def.db.meta.QZT_YuukouseiNgTuutiRn;

/**
 * 有効性確認ＮＧ通知テーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_YuukouseiNgTuutiRn}</td><td colspan="3">有効性確認ＮＧ通知テーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>zrnsyoruicd</td><td>（連携用）書類コード</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhassoukbn</td><td>（連携用）発送区分</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrntyouhyouymd zrntyouhyouymd}</td><td>（連携用）帳票作成日</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntyouhyouymdkj</td><td>（連携用）帳票作成日（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsyono zrnsyono}</td><td>（連携用）証券番号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv9</td><td>（連携用）予備項目Ｖ９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnansyuyouyobin10</td><td>（連携用）案内収納用予備項目Ｎ１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnshskyno</td><td>（連携用）送付先郵便番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnshskadr1kj</td><td>（連携用）送付先住所１（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnshskadr2kj</td><td>（連携用）送付先住所２（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnshskadr3kj</td><td>（連携用）送付先住所３（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnshsnmkj</td><td>（連携用）送付先名（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnyobiv43</td><td>（連携用）予備項目Ｖ４３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnansyuyouyobin10x2</td><td>（連携用）案内収納用予備項目Ｎ１０＿２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntawsosikikj</td><td>（連携用）問合せ先組織名（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntawyno</td><td>（連携用）問合せ先郵便番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntawadr1kj</td><td>（連携用）問合せ先住所１（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntawadr2kj</td><td>（連携用）問合せ先住所２（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntawadr3kj</td><td>（連携用）問合せ先住所３（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntawtelnov14</td><td>（連携用）問合せ先電話番号Ｖ１４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntawteluktkkanou1</td><td>（連携用）問合せ先電話受付可能時間１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntawteluktkkanou2</td><td>（連携用）問合せ先電話受付可能時間２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrndai2tawsosikinmkj</td><td>（連携用）第２問合せ先組織名（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrndai2tawtelno</td><td>（連携用）第２問合せ先電話番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv62</td><td>（連携用）予備項目Ｖ６２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnansyuyouyobin10x3</td><td>（連携用）案内収納用予備項目Ｎ１０＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon46keta1</td><td>（連携用）お知らせ文言（４６桁）１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon46keta2</td><td>（連携用）お知らせ文言（４６桁）２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon46keta3</td><td>（連携用）お知らせ文言（４６桁）３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon46keta4</td><td>（連携用）お知らせ文言（４６桁）４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon46keta5</td><td>（連携用）お知らせ文言（４６桁）５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon46keta6</td><td>（連携用）お知らせ文言（４６桁）６</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon46keta7</td><td>（連携用）お知らせ文言（４６桁）７</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon46keta8</td><td>（連携用）お知らせ文言（４６桁）８</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon46keta9</td><td>（連携用）お知らせ文言（４６桁）９</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnosirasemongon46keta10</td><td>（連携用）お知らせ文言（４６桁）１０</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnyobiv184</td><td>（連携用）予備項目Ｖ１８４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnansyuyouyobin10x4</td><td>（連携用）案内収納用予備項目Ｎ１０＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkyknmkj</td><td>（連携用）契約者名（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnpkngk</td><td>（連携用）保険料金額</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrncreditcardinfo1</td><td>（連携用）クレジットカード情報１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrncreditcardinfo2</td><td>（連携用）クレジットカード情報２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrncreditcardinfo3</td><td>（連携用）クレジットカード情報３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrncreditcardmaskingmsg</td><td>（連携用）クレジットカードマスキングＭＳＧ</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrngoiraijikoutoumongon1</td><td>（連携用）ご依頼事項等文言１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrngoiraijikoutoumongon2</td><td>（連携用）ご依頼事項等文言２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrngoiraijikoutoumongon3</td><td>（連携用）ご依頼事項等文言３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnphrkmongon1</td><td>（連携用）保険料のお払込み文言１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnphrkmongon2</td><td>（連携用）保険料のお払込み文言２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnphrkmongon3</td><td>（連携用）保険料のお払込み文言３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnphrkmongon4</td><td>（連携用）保険料のお払込み文言４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnphrkmongon5</td><td>（連携用）保険料のお払込み文言５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnphrkmongon6</td><td>（連携用）保険料のお払込み文言６</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnphrkmongon7</td><td>（連携用）保険料のお払込み文言７</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnphrkmongon8</td><td>（連携用）保険料のお払込み文言８</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnphrkmongon9</td><td>（連携用）保険料のお払込み文言９</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnyobiv17</td><td>（連携用）予備項目Ｖ１７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv250</td><td>（連携用）予備項目Ｖ２５０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnansyuyouyobin10x5</td><td>（連携用）案内収納用予備項目Ｎ１０＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_YuukouseiNgTuutiRn
 * @see     GenZT_YuukouseiNgTuutiRn
 * @see     QZT_YuukouseiNgTuutiRn
 * @see     GenQZT_YuukouseiNgTuutiRn
 */
public class PKZT_YuukouseiNgTuutiRn extends AbstractExDBPrimaryKey<ZT_YuukouseiNgTuutiRn, PKZT_YuukouseiNgTuutiRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_YuukouseiNgTuutiRn() {
    }

    public PKZT_YuukouseiNgTuutiRn(String pZrntyouhyouymd, String pZrnsyono) {
        zrntyouhyouymd = pZrntyouhyouymd;
        zrnsyono = pZrnsyono;
    }

    @Transient
    @Override
    public Class<ZT_YuukouseiNgTuutiRn> getEntityClass() {
        return ZT_YuukouseiNgTuutiRn.class;
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

}