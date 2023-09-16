package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_KijituTouraiAnnaiTy;
import yuyu.def.db.mapping.GenZT_KijituTouraiAnnaiTy;
import yuyu.def.db.meta.GenQZT_KijituTouraiAnnaiTy;
import yuyu.def.db.meta.QZT_KijituTouraiAnnaiTy;

/**
 * 期日到来案内テーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KijituTouraiAnnaiTy}</td><td colspan="3">期日到来案内テーブル（中）</td></tr>
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
 *  <tr><td>ztyyobiv60</td><td>（中継用）予備項目Ｖ６０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyansyuyouyobin10x3</td><td>（中継用）案内収納用予備項目Ｎ１０＿３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytuutinm</td><td>（中継用）通知名称</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhurikaeyokokumsg32keta1</td><td>（中継用）振替予告メッセージ（３２桁）１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhurikaeyokokumsg32keta2</td><td>（中継用）振替予告メッセージ（３２桁）２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhurikaeyokokumsg32keta3</td><td>（中継用）振替予告メッセージ（３２桁）３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhurikaeyokokumsg32keta4</td><td>（中継用）振替予告メッセージ（３２桁）４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhurikaeyokokumsg32keta5</td><td>（中継用）振替予告メッセージ（３２桁）５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhurikaeyokokumsg32keta6</td><td>（中継用）振替予告メッセージ（３２桁）６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhurikaeyokokumsg32keta7</td><td>（中継用）振替予告メッセージ（３２桁）７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhurikaeyokokumsg32keta8</td><td>（中継用）振替予告メッセージ（３２桁）８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv110</td><td>（中継用）予備項目Ｖ１１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyansyuyouyobin10x4</td><td>（中継用）案内収納用予備項目Ｎ１０＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkkeiro</td><td>（中継用）払込経路</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyono2</td><td>（中継用）証券番号２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyouhnnm</td><td>（中継用）商品名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykymdseireki</td><td>（中継用）契約年月日（西暦）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknnmkj</td><td>（中継用）被保険者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv30</td><td>（中継用）予備項目Ｖ３０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyansyuyouyobin10x5</td><td>（中継用）案内収納用予備項目Ｎ１０＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjttrnnfreearea1</td><td>（中継用）期日到来案内フリーエリア１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjttrnnfreearea2</td><td>（中継用）期日到来案内フリーエリア２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjttrnnfreearea3</td><td>（中継用）期日到来案内フリーエリア３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjttrnnfreearea4</td><td>（中継用）期日到来案内フリーエリア４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjttrnnfreearea5</td><td>（中継用）期日到来案内フリーエリア５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjttrnnfreearea6</td><td>（中継用）期日到来案内フリーエリア６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjttrnnfreearea7</td><td>（中継用）期日到来案内フリーエリア７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv99</td><td>（中継用）予備項目Ｖ９９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyansyuyouyobin10x6</td><td>（中継用）案内収納用予備項目Ｎ１０＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytuutisakuseiymdseireki</td><td>（中継用）通知作成年月日（西暦）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzhurikaeymdseireki</td><td>（中継用）口座振替日（西暦）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzinfo1</td><td>（中継用）口座情報１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzinfo2</td><td>（中継用）口座情報２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzinfo3</td><td>（中継用）口座情報３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzinfo4</td><td>（中継用）口座情報４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzinfo5</td><td>（中継用）口座情報５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzinfo6</td><td>（中継用）口座情報６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzinfo7</td><td>（中継用）口座情報７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykzinfo8</td><td>（中継用）口座情報８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhknjytukikan</td><td>（中継用）保険料充当期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkgk1</td><td>（中継用）払込金額１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkgk2</td><td>（中継用）払込金額２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkgk3</td><td>（中継用）払込金額３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkgk4</td><td>（中継用）払込金額４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv146</td><td>（中継用）予備項目Ｖ１４６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyansyuyouyobin10x7</td><td>（中継用）案内収納用予備項目Ｎ１０＿７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjttrnnfreearea8</td><td>（中継用）期日到来案内フリーエリア８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjttrnnfreearea9</td><td>（中継用）期日到来案内フリーエリア９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjttrnnfreearea10</td><td>（中継用）期日到来案内フリーエリア１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjttrnnfreearea11</td><td>（中継用）期日到来案内フリーエリア１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjttrnnfreearea12</td><td>（中継用）期日到来案内フリーエリア１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjttrnnfreearea13</td><td>（中継用）期日到来案内フリーエリア１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv84</td><td>（中継用）予備項目Ｖ８４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyansyuyouyobin10x8</td><td>（中継用）案内収納用予備項目Ｎ１０＿８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_KijituTouraiAnnaiTy
 * @see     GenZT_KijituTouraiAnnaiTy
 * @see     QZT_KijituTouraiAnnaiTy
 * @see     GenQZT_KijituTouraiAnnaiTy
 */
public class PKZT_KijituTouraiAnnaiTy extends AbstractExDBPrimaryKey<ZT_KijituTouraiAnnaiTy, PKZT_KijituTouraiAnnaiTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_KijituTouraiAnnaiTy() {
    }

    public PKZT_KijituTouraiAnnaiTy(String pZtytyouhyouymd, String pZtysyono) {
        ztytyouhyouymd = pZtytyouhyouymd;
        ztysyono = pZtysyono;
    }

    @Transient
    @Override
    public Class<ZT_KijituTouraiAnnaiTy> getEntityClass() {
        return ZT_KijituTouraiAnnaiTy.class;
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