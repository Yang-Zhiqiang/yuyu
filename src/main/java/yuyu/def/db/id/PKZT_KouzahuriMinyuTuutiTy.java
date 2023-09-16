package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_KouzahuriMinyuTuutiTy;
import yuyu.def.db.mapping.GenZT_KouzahuriMinyuTuutiTy;
import yuyu.def.db.meta.GenQZT_KouzahuriMinyuTuutiTy;
import yuyu.def.db.meta.QZT_KouzahuriMinyuTuutiTy;

/**
 * 口座振替未入通知テーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KouzahuriMinyuTuutiTy}</td><td colspan="3">口座振替未入通知テーブル（中）</td></tr>
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
 *  <tr><td>ztytuutinm30keta</td><td>（中継用）通知名称（３０桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyminyuttmsg1</td><td>（中継用）未入通知メッセージ１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyminyuttmsg2</td><td>（中継用）未入通知メッセージ２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyminyuttmsg3</td><td>（中継用）未入通知メッセージ３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyminyuttmsg4</td><td>（中継用）未入通知メッセージ４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyminyuttmsg5</td><td>（中継用）未入通知メッセージ５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyminyuttmsg6</td><td>（中継用）未入通知メッセージ６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyminyuttmsg7</td><td>（中継用）未入通知メッセージ７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyminyuttmsg8</td><td>（中継用）未入通知メッセージ８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyminyuttmsg9</td><td>（中継用）未入通知メッセージ９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyminyuttmsg10</td><td>（中継用）未入通知メッセージ１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyminyuttmsg11</td><td>（中継用）未入通知メッセージ１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyminyuttmsg12</td><td>（中継用）未入通知メッセージ１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv174</td><td>（中継用）予備項目Ｖ１７４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyansyuyouyobin10x4</td><td>（中継用）案内収納用予備項目Ｎ１０＿４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztypannainm</td><td>（中継用）保険料案内名称</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkhou12keta</td><td>（中継用）払込方法（１２桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyono2</td><td>（中継用）証券番号２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknnmkj</td><td>（中継用）被保険者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynextkzhrnaiyou1</td><td>（中継用）次回振替内容１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynextkzhrnaiyou2</td><td>（中継用）次回振替内容２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynextkzhrnaiyou3</td><td>（中継用）次回振替内容３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysaikokuyykk1</td><td>（中継用）催告月猶予期間１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysaikokuyykk2</td><td>（中継用）催告月猶予期間２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkmiraimsg1</td><td>（中継用）振込依頼メッセージ１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkmiraimsg2</td><td>（中継用）振込依頼メッセージ２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhrkmiraimsg3</td><td>（中継用）振込依頼メッセージ３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzenhurinaiyou1</td><td>（中継用）前回振替内容１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzenhurinaiyou2</td><td>（中継用）前回振替内容２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzenhurinaiyou3</td><td>（中継用）前回振替内容３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzenhurinaiyou4</td><td>（中継用）前回振替内容４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv196</td><td>（中継用）予備項目Ｖ１９６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyansyuyouyobin10x5</td><td>（中継用）案内収納用予備項目Ｎ１０＿５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhurikaekz37keta1</td><td>（中継用）振替口座（３７桁）１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhurikaekz37keta2</td><td>（中継用）振替口座（３７桁）２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhurikaekz37keta3</td><td>（中継用）振替口座（３７桁）３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhurikaekz37keta4</td><td>（中継用）振替口座（３７桁）４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhurikaekz37keta5</td><td>（中継用）振替口座（３７桁）５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhurikaekz37keta6</td><td>（中継用）振替口座（３７桁）６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv88</td><td>（中継用）予備項目Ｖ８８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyansyuyouyobin10x6</td><td>（中継用）案内収納用予備項目Ｎ１０＿６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyminyuttaddmsg1</td><td>（中継用）未入通知追加メッセージ１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyminyuttaddmsg2</td><td>（中継用）未入通知追加メッセージ２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyminyuttaddmsg3</td><td>（中継用）未入通知追加メッセージ３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyminyuttaddmsg4</td><td>（中継用）未入通知追加メッセージ４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyminyuttaddmsg5</td><td>（中継用）未入通知追加メッセージ５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyminyuttaddmsg6</td><td>（中継用）未入通知追加メッセージ６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyminyuttaddmsg7</td><td>（中継用）未入通知追加メッセージ７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyminyuttaddmsg8</td><td>（中継用）未入通知追加メッセージ８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyminyuttaddmsg9</td><td>（中継用）未入通知追加メッセージ９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyminyuttaddmsg10</td><td>（中継用）未入通知追加メッセージ１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyminyuttaddmsg11</td><td>（中継用）未入通知追加メッセージ１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyminyuttaddmsg12</td><td>（中継用）未入通知追加メッセージ１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyminyuttaddmsg13</td><td>（中継用）未入通知追加メッセージ１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyminyuttaddmsg14</td><td>（中継用）未入通知追加メッセージ１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyminyuttaddmsg15</td><td>（中継用）未入通知追加メッセージ１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyminyuttaddmsg16</td><td>（中継用）未入通知追加メッセージ１６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyminyuttaddmsg17</td><td>（中継用）未入通知追加メッセージ１７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyminyuttaddmsg18</td><td>（中継用）未入通知追加メッセージ１８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyminyuttaddmsg19</td><td>（中継用）未入通知追加メッセージ１９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyminyuttaddmsg20</td><td>（中継用）未入通知追加メッセージ２０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyminyuttaddmsg21</td><td>（中継用）未入通知追加メッセージ２１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv250</td><td>（中継用）予備項目Ｖ２５０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv60</td><td>（中継用）予備項目Ｖ６０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyansyuyouyobin10x7</td><td>（中継用）案内収納用予備項目Ｎ１０＿７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_KouzahuriMinyuTuutiTy
 * @see     GenZT_KouzahuriMinyuTuutiTy
 * @see     QZT_KouzahuriMinyuTuutiTy
 * @see     GenQZT_KouzahuriMinyuTuutiTy
 */
public class PKZT_KouzahuriMinyuTuutiTy extends AbstractExDBPrimaryKey<ZT_KouzahuriMinyuTuutiTy, PKZT_KouzahuriMinyuTuutiTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_KouzahuriMinyuTuutiTy() {
    }

    public PKZT_KouzahuriMinyuTuutiTy(String pZtytyouhyouymd, String pZtysyono) {
        ztytyouhyouymd = pZtytyouhyouymd;
        ztysyono = pZtysyono;
    }

    @Transient
    @Override
    public Class<ZT_KouzahuriMinyuTuutiTy> getEntityClass() {
        return ZT_KouzahuriMinyuTuutiTy.class;
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