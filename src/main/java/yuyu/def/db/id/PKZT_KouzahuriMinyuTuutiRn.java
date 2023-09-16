package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_KouzahuriMinyuTuutiRn;
import yuyu.def.db.mapping.GenZT_KouzahuriMinyuTuutiRn;
import yuyu.def.db.meta.GenQZT_KouzahuriMinyuTuutiRn;
import yuyu.def.db.meta.QZT_KouzahuriMinyuTuutiRn;

/**
 * 口座振替未入通知テーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_KouzahuriMinyuTuutiRn}</td><td colspan="3">口座振替未入通知テーブル（連）</td></tr>
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
 *  <tr><td>zrntuutinm30keta</td><td>（連携用）通知名称（３０桁）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnminyuttmsg1</td><td>（連携用）未入通知メッセージ１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnminyuttmsg2</td><td>（連携用）未入通知メッセージ２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnminyuttmsg3</td><td>（連携用）未入通知メッセージ３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnminyuttmsg4</td><td>（連携用）未入通知メッセージ４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnminyuttmsg5</td><td>（連携用）未入通知メッセージ５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnminyuttmsg6</td><td>（連携用）未入通知メッセージ６</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnminyuttmsg7</td><td>（連携用）未入通知メッセージ７</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnminyuttmsg8</td><td>（連携用）未入通知メッセージ８</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnminyuttmsg9</td><td>（連携用）未入通知メッセージ９</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnminyuttmsg10</td><td>（連携用）未入通知メッセージ１０</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnminyuttmsg11</td><td>（連携用）未入通知メッセージ１１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnminyuttmsg12</td><td>（連携用）未入通知メッセージ１２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnyobiv174</td><td>（連携用）予備項目Ｖ１７４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnansyuyouyobin10x4</td><td>（連携用）案内収納用予備項目Ｎ１０＿４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnpannainm</td><td>（連携用）保険料案内名称</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhrkhou12keta</td><td>（連携用）払込方法（１２桁）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsyono2</td><td>（連携用）証券番号２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhhknnmkj</td><td>（連携用）被保険者名（漢字）</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnnextkzhrnaiyou1</td><td>（連携用）次回振替内容１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnnextkzhrnaiyou2</td><td>（連携用）次回振替内容２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnnextkzhrnaiyou3</td><td>（連携用）次回振替内容３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsaikokuyykk1</td><td>（連携用）催告月猶予期間１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnsaikokuyykk2</td><td>（連携用）催告月猶予期間２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhrkmiraimsg1</td><td>（連携用）振込依頼メッセージ１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhrkmiraimsg2</td><td>（連携用）振込依頼メッセージ２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhrkmiraimsg3</td><td>（連携用）振込依頼メッセージ３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnzenhurinaiyou1</td><td>（連携用）前回振替内容１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnzenhurinaiyou2</td><td>（連携用）前回振替内容２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnzenhurinaiyou3</td><td>（連携用）前回振替内容３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnzenhurinaiyou4</td><td>（連携用）前回振替内容４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnyobiv196</td><td>（連携用）予備項目Ｖ１９６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnansyuyouyobin10x5</td><td>（連携用）案内収納用予備項目Ｎ１０＿５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnhurikaekz37keta1</td><td>（連携用）振替口座（３７桁）１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhurikaekz37keta2</td><td>（連携用）振替口座（３７桁）２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhurikaekz37keta3</td><td>（連携用）振替口座（３７桁）３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhurikaekz37keta4</td><td>（連携用）振替口座（３７桁）４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhurikaekz37keta5</td><td>（連携用）振替口座（３７桁）５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnhurikaekz37keta6</td><td>（連携用）振替口座（３７桁）６</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnyobiv88</td><td>（連携用）予備項目Ｖ８８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnansyuyouyobin10x6</td><td>（連携用）案内収納用予備項目Ｎ１０＿６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnminyuttaddmsg1</td><td>（連携用）未入通知追加メッセージ１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnminyuttaddmsg2</td><td>（連携用）未入通知追加メッセージ２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnminyuttaddmsg3</td><td>（連携用）未入通知追加メッセージ３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnminyuttaddmsg4</td><td>（連携用）未入通知追加メッセージ４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnminyuttaddmsg5</td><td>（連携用）未入通知追加メッセージ５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnminyuttaddmsg6</td><td>（連携用）未入通知追加メッセージ６</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnminyuttaddmsg7</td><td>（連携用）未入通知追加メッセージ７</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnminyuttaddmsg8</td><td>（連携用）未入通知追加メッセージ８</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnminyuttaddmsg9</td><td>（連携用）未入通知追加メッセージ９</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnminyuttaddmsg10</td><td>（連携用）未入通知追加メッセージ１０</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnminyuttaddmsg11</td><td>（連携用）未入通知追加メッセージ１１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnminyuttaddmsg12</td><td>（連携用）未入通知追加メッセージ１２</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnminyuttaddmsg13</td><td>（連携用）未入通知追加メッセージ１３</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnminyuttaddmsg14</td><td>（連携用）未入通知追加メッセージ１４</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnminyuttaddmsg15</td><td>（連携用）未入通知追加メッセージ１５</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnminyuttaddmsg16</td><td>（連携用）未入通知追加メッセージ１６</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnminyuttaddmsg17</td><td>（連携用）未入通知追加メッセージ１７</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnminyuttaddmsg18</td><td>（連携用）未入通知追加メッセージ１８</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnminyuttaddmsg19</td><td>（連携用）未入通知追加メッセージ１９</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnminyuttaddmsg20</td><td>（連携用）未入通知追加メッセージ２０</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnminyuttaddmsg21</td><td>（連携用）未入通知追加メッセージ２１</td><td>&nbsp;</td><td align="center">G</td><td>String</td></tr>
 *  <tr><td>zrnyobiv250</td><td>（連携用）予備項目Ｖ２５０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnyobiv60</td><td>（連携用）予備項目Ｖ６０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnansyuyouyobin10x7</td><td>（連携用）案内収納用予備項目Ｎ１０＿７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_KouzahuriMinyuTuutiRn
 * @see     GenZT_KouzahuriMinyuTuutiRn
 * @see     QZT_KouzahuriMinyuTuutiRn
 * @see     GenQZT_KouzahuriMinyuTuutiRn
 */
public class PKZT_KouzahuriMinyuTuutiRn extends AbstractExDBPrimaryKey<ZT_KouzahuriMinyuTuutiRn, PKZT_KouzahuriMinyuTuutiRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_KouzahuriMinyuTuutiRn() {
    }

    public PKZT_KouzahuriMinyuTuutiRn(String pZrntyouhyouymd, String pZrnsyono) {
        zrntyouhyouymd = pZrntyouhyouymd;
        zrnsyono = pZrnsyono;
    }

    @Transient
    @Override
    public Class<ZT_KouzahuriMinyuTuutiRn> getEntityClass() {
        return ZT_KouzahuriMinyuTuutiRn.class;
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