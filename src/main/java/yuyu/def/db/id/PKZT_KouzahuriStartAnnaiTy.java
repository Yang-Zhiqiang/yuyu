package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_KouzahuriStartAnnaiTy;
import yuyu.def.db.mapping.GenZT_KouzahuriStartAnnaiTy;
import yuyu.def.db.meta.GenQZT_KouzahuriStartAnnaiTy;
import yuyu.def.db.meta.QZT_KouzahuriStartAnnaiTy;

/**
 * 口座振替開始案内テーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KouzahuriStartAnnaiTy}</td><td colspan="3">口座振替開始案内テーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>ztysyoruicd</td><td>（中継用）書類コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhassoukbn</td><td>（中継用）発送区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtytyouhyouymd ztytyouhyouymd}</td><td>（中継用）帳票作成日</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytyouhyouymdkj</td><td>（中継用）帳票作成日（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv9</td><td>（中継用）予備項目Ｖ９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyansyuyouyobin10</td><td>（中継用）案内収納用予備項目Ｎ１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshskyno</td><td>（中継用）送付先郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshskadr1kj</td><td>（中継用）送付先住所１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshskadr2kj</td><td>（中継用）送付先住所２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshskadr3kj</td><td>（中継用）送付先住所３（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyshsnmkj</td><td>（中継用）送付先名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv43</td><td>（中継用）予備項目Ｖ４３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyansyuyouyobin10x2</td><td>（中継用）案内収納用予備項目Ｎ１０＿２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytawsosikikj</td><td>（中継用）問合せ先組織名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytawyno</td><td>（中継用）問合せ先郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytawadr1kj</td><td>（中継用）問合せ先住所１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytawadr2kj</td><td>（中継用）問合せ先住所２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytawadr3kj</td><td>（中継用）問合せ先住所３（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytawtelnov14</td><td>（中継用）問合せ先電話番号Ｖ１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytawteluktkkanou1</td><td>（中継用）問合せ先電話受付可能時間１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytawteluktkkanou2</td><td>（中継用）問合せ先電話受付可能時間２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydai2tawsosikinmkj</td><td>（中継用）第２問合せ先組織名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydai2tawtelno</td><td>（中継用）第２問合せ先電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysclatosyono</td><td>（中継用）スクランブル後証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysakunm15keta</td><td>（中継用）作成番号（１５桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv61</td><td>（中継用）予備項目Ｖ６１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyansyuyouyobin10x3</td><td>（中継用）案内収納用予備項目Ｎ１０＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytuutinm</td><td>（中継用）通知名称</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyaisatumongon1</td><td>（中継用）挨拶文言１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyaisatumongon2</td><td>（中継用）挨拶文言２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyaisatumongon3</td><td>（中継用）挨拶文言３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyaisatumongon4</td><td>（中継用）挨拶文言４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyaisatumongon5</td><td>（中継用）挨拶文言５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv62</td><td>（中継用）予備項目Ｖ６２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyansyuyouyobin10x4</td><td>（中継用）案内収納用予備項目Ｎ１０＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhurikaeonegai1</td><td>（中継用）口座振替についてのお願い１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhurikaeonegai2</td><td>（中継用）口座振替についてのお願い２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhurikaeonegai3</td><td>（中継用）口座振替についてのお願い３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhurikaeonegai4</td><td>（中継用）口座振替についてのお願い４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhurikaeonegai5</td><td>（中継用）口座振替についてのお願い５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhurikaeonegai6</td><td>（中継用）口座振替についてのお願い６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhurikaeonegai7</td><td>（中継用）口座振替についてのお願い７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhurikaeonegai8</td><td>（中継用）口座振替についてのお願い８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhurikaeonegai9</td><td>（中継用）口座振替についてのお願い９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhurikaeonegai10</td><td>（中継用）口座振替についてのお願い１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhurikaeonegai11</td><td>（中継用）口座振替についてのお願い１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhurikaeonegai12</td><td>（中継用）口座振替についてのお願い１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhurikaeonegai13</td><td>（中継用）口座振替についてのお願い１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhurikaeonegai14</td><td>（中継用）口座振替についてのお願い１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhurikaeonegai15</td><td>（中継用）口座振替についてのお願い１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv210</td><td>（中継用）予備項目Ｖ２１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyansyuyouyobin10x5</td><td>（中継用）案内収納用予備項目Ｎ１０＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytuutisakuseiymdseireki</td><td>（中継用）通知作成年月日（西暦）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyono2</td><td>（中継用）証券番号２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyouhnnm</td><td>（中継用）商品名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykymdseireki</td><td>（中継用）契約年月日（西暦）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytkbriphurikaeyoteigk</td><td>（中継用）月払保険料（振替予定金額）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknnmkj</td><td>（中継用）被保険者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhurikaekzhosokumongon</td><td>（中継用）振替口座補足文言</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhurikaekz1</td><td>（中継用）振替口座１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhurikaekz2</td><td>（中継用）振替口座２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhurikaekz3</td><td>（中継用）振替口座３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhurikaekz4</td><td>（中継用）振替口座４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhurikaekz5</td><td>（中継用）振替口座５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv124</td><td>（中継用）予備項目Ｖ１２４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyansyuyouyobin10x7</td><td>（中継用）案内収納用予備項目Ｎ１０＿７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhuristartanfreearea1</td><td>（中継用）口座振替開始案内フリーエリア１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhuristartanfreearea2</td><td>（中継用）口座振替開始案内フリーエリア２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhuristartanfreearea3</td><td>（中継用）口座振替開始案内フリーエリア３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhuristartanfreearea4</td><td>（中継用）口座振替開始案内フリーエリア４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhuristartanfreearea5</td><td>（中継用）口座振替開始案内フリーエリア５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhuristartanfreearea6</td><td>（中継用）口座振替開始案内フリーエリア６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhuristartanfreearea7</td><td>（中継用）口座振替開始案内フリーエリア７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhuristartanfreearea8</td><td>（中継用）口座振替開始案内フリーエリア８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhuristartanfreearea9</td><td>（中継用）口座振替開始案内フリーエリア９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhuristartanfreearea10</td><td>（中継用）口座振替開始案内フリーエリア１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv140</td><td>（中継用）予備項目Ｖ１４０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyansyuyouyobin10x8</td><td>（中継用）案内収納用予備項目Ｎ１０＿８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_KouzahuriStartAnnaiTy
 * @see     GenZT_KouzahuriStartAnnaiTy
 * @see     QZT_KouzahuriStartAnnaiTy
 * @see     GenQZT_KouzahuriStartAnnaiTy
 */
public class PKZT_KouzahuriStartAnnaiTy extends AbstractExDBPrimaryKey<ZT_KouzahuriStartAnnaiTy, PKZT_KouzahuriStartAnnaiTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_KouzahuriStartAnnaiTy() {
    }

    public PKZT_KouzahuriStartAnnaiTy(String pZtytyouhyouymd, String pZtysyono) {
        ztytyouhyouymd = pZtytyouhyouymd;
        ztysyono = pZtysyono;
    }

    @Transient
    @Override
    public Class<ZT_KouzahuriStartAnnaiTy> getEntityClass() {
        return ZT_KouzahuriStartAnnaiTy.class;
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

}