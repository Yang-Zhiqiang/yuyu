package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_KouzahuriStartAnnaiRn;
import yuyu.def.db.mapping.GenZT_KouzahuriStartAnnaiRn;
import yuyu.def.db.meta.GenQZT_KouzahuriStartAnnaiRn;
import yuyu.def.db.meta.QZT_KouzahuriStartAnnaiRn;

/**
 * 口座振替開始案内テーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KouzahuriStartAnnaiRn}</td><td colspan="3">口座振替開始案内テーブル（連）</td></tr>
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
 *  <tr><td>zrnsclatosyono</td><td>（連携用）スクランブル後証券番号</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsakunm15keta</td><td>（連携用）作成番号（１５桁）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv61</td><td>（連携用）予備項目Ｖ６１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnansyuyouyobin10x3</td><td>（連携用）案内収納用予備項目Ｎ１０＿３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntuutinm</td><td>（連携用）通知名称</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnaisatumongon1</td><td>（連携用）挨拶文言１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnaisatumongon2</td><td>（連携用）挨拶文言２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnaisatumongon3</td><td>（連携用）挨拶文言３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnaisatumongon4</td><td>（連携用）挨拶文言４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnaisatumongon5</td><td>（連携用）挨拶文言５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnyobiv62</td><td>（連携用）予備項目Ｖ６２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnansyuyouyobin10x4</td><td>（連携用）案内収納用予備項目Ｎ１０＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzhurikaeonegai1</td><td>（連携用）口座振替についてのお願い１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkzhurikaeonegai2</td><td>（連携用）口座振替についてのお願い２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkzhurikaeonegai3</td><td>（連携用）口座振替についてのお願い３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkzhurikaeonegai4</td><td>（連携用）口座振替についてのお願い４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkzhurikaeonegai5</td><td>（連携用）口座振替についてのお願い５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkzhurikaeonegai6</td><td>（連携用）口座振替についてのお願い６</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkzhurikaeonegai7</td><td>（連携用）口座振替についてのお願い７</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkzhurikaeonegai8</td><td>（連携用）口座振替についてのお願い８</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkzhurikaeonegai9</td><td>（連携用）口座振替についてのお願い９</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkzhurikaeonegai10</td><td>（連携用）口座振替についてのお願い１０</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkzhurikaeonegai11</td><td>（連携用）口座振替についてのお願い１１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkzhurikaeonegai12</td><td>（連携用）口座振替についてのお願い１２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkzhurikaeonegai13</td><td>（連携用）口座振替についてのお願い１３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkzhurikaeonegai14</td><td>（連携用）口座振替についてのお願い１４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkzhurikaeonegai15</td><td>（連携用）口座振替についてのお願い１５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnyobiv210</td><td>（連携用）予備項目Ｖ２１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnansyuyouyobin10x5</td><td>（連携用）案内収納用予備項目Ｎ１０＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrntuutisakuseiymdseireki</td><td>（連携用）通知作成年月日（西暦）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsyono2</td><td>（連携用）証券番号２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnsyouhnnm</td><td>（連携用）商品名</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkykymdseireki</td><td>（連携用）契約年月日（西暦）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrntkbriphurikaeyoteigk</td><td>（連携用）月払保険料（振替予定金額）</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknnmkj</td><td>（連携用）被保険者名（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhurikaekzhosokumongon</td><td>（連携用）振替口座補足文言</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhurikaekz1</td><td>（連携用）振替口座１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhurikaekz2</td><td>（連携用）振替口座２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhurikaekz3</td><td>（連携用）振替口座３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhurikaekz4</td><td>（連携用）振替口座４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhurikaekz5</td><td>（連携用）振替口座５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnyobiv124</td><td>（連携用）予備項目Ｖ１２４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnansyuyouyobin10x7</td><td>（連携用）案内収納用予備項目Ｎ１０＿７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnkzhuristartanfreearea1</td><td>（連携用）口座振替開始案内フリーエリア１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkzhuristartanfreearea2</td><td>（連携用）口座振替開始案内フリーエリア２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkzhuristartanfreearea3</td><td>（連携用）口座振替開始案内フリーエリア３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkzhuristartanfreearea4</td><td>（連携用）口座振替開始案内フリーエリア４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkzhuristartanfreearea5</td><td>（連携用）口座振替開始案内フリーエリア５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkzhuristartanfreearea6</td><td>（連携用）口座振替開始案内フリーエリア６</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkzhuristartanfreearea7</td><td>（連携用）口座振替開始案内フリーエリア７</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkzhuristartanfreearea8</td><td>（連携用）口座振替開始案内フリーエリア８</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkzhuristartanfreearea9</td><td>（連携用）口座振替開始案内フリーエリア９</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnkzhuristartanfreearea10</td><td>（連携用）口座振替開始案内フリーエリア１０</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnyobiv140</td><td>（連携用）予備項目Ｖ１４０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnansyuyouyobin10x8</td><td>（連携用）案内収納用予備項目Ｎ１０＿８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_KouzahuriStartAnnaiRn
 * @see     GenZT_KouzahuriStartAnnaiRn
 * @see     QZT_KouzahuriStartAnnaiRn
 * @see     GenQZT_KouzahuriStartAnnaiRn
 */
public class PKZT_KouzahuriStartAnnaiRn extends AbstractExDBPrimaryKey<ZT_KouzahuriStartAnnaiRn, PKZT_KouzahuriStartAnnaiRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_KouzahuriStartAnnaiRn() {
    }

    public PKZT_KouzahuriStartAnnaiRn(String pZrntyouhyouymd, String pZrnsyono) {
        zrntyouhyouymd = pZrntyouhyouymd;
        zrnsyono = pZrnsyono;
    }

    @Transient
    @Override
    public Class<ZT_KouzahuriStartAnnaiRn> getEntityClass() {
        return ZT_KouzahuriStartAnnaiRn.class;
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