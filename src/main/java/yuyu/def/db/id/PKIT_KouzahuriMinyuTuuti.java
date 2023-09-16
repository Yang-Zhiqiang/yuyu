package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.IT_KouzahuriMinyuTuuti;
import yuyu.def.db.mapping.GenIT_KouzahuriMinyuTuuti;
import yuyu.def.db.meta.GenQIT_KouzahuriMinyuTuuti;
import yuyu.def.db.meta.QIT_KouzahuriMinyuTuuti;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 口座振替未入通知テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KouzahuriMinyuTuuti}</td><td colspan="3">口座振替未入通知テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTyouhyouymd tyouhyouymd}</td><td>帳票作成日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syoruiCd</td><td>書類コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyoruiCdKbn C_SyoruiCdKbn}</td></tr>
 *  <tr><td>hassoukbn</td><td>発送区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HassouKbn C_HassouKbn}</td></tr>
 *  <tr><td>shskyno</td><td>送付先郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>shsadr1kj</td><td>送付先住所１（漢字）（３０桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>shsadr2kj</td><td>送付先住所２（漢字）（３０桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>shsadr3kj</td><td>送付先住所３（漢字）（３０桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>shsnmkj</td><td>送付先氏名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>toiawasesosikinmkj</td><td>問合せ先組織名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>toiawaseyno</td><td>問合せ先郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>toiawaseadr1kj</td><td>問合せ先住所１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>toiawaseadr2kj</td><td>問合せ先住所２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>toiawaseadr3kj</td><td>問合せ先住所３（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>toiawasetelno</td><td>問合せ先電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>toiawaseteluktkkanou1</td><td>問合せ先電話受付可能時間１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>toiawaseteluktkkanou2</td><td>問合せ先電話受付可能時間２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>toiawasesosikinmkj2</td><td>第２問合せ先組織名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>toiawasetelno2</td><td>第２問合せ先電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tuutinm30keta</td><td>通知名称（３０桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>minyuttmsg1</td><td>未入通知メッセージ１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>minyuttmsg2</td><td>未入通知メッセージ２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>minyuttmsg3</td><td>未入通知メッセージ３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>minyuttmsg4</td><td>未入通知メッセージ４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>minyuttmsg5</td><td>未入通知メッセージ５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>minyuttmsg6</td><td>未入通知メッセージ６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>minyuttmsg7</td><td>未入通知メッセージ７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>minyuttmsg8</td><td>未入通知メッセージ８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>minyuttmsg9</td><td>未入通知メッセージ９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>minyuttmsg10</td><td>未入通知メッセージ１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>minyuttmsg11</td><td>未入通知メッセージ１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>minyuttmsg12</td><td>未入通知メッセージ１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>pannainm</td><td>保険料案内名称</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkhou12keta</td><td>払込方法（１２桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhknnmkj</td><td>被保険者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nexthurikaenaiyou1</td><td>次回振替内容１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nexthurikaenaiyou2</td><td>次回振替内容２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nexthurikaenaiyou3</td><td>次回振替内容３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>saikokutukiyykkn1</td><td>催告月猶予期間１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>saikokutukiyykkn2</td><td>催告月猶予期間２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmirmsg1</td><td>振込依頼メッセージ１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmirmsg2</td><td>振込依頼メッセージ２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkmirmsg3</td><td>振込依頼メッセージ３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>zenhurikaenaiyou1</td><td>前回振替内容１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>zenhurikaenaiyou2</td><td>前回振替内容２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>zenhurikaenaiyou3</td><td>前回振替内容３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>zenhurikaenaiyou4</td><td>前回振替内容４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hurikaekz37keta1</td><td>振替口座（３７桁）１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hurikaekz37keta2</td><td>振替口座（３７桁）２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hurikaekz37keta3</td><td>振替口座（３７桁）３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hurikaekz37keta4</td><td>振替口座（３７桁）４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hurikaekz37keta5</td><td>振替口座（３７桁）５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hurikaekz37keta6</td><td>振替口座（３７桁）６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>minyuttaddmsg1</td><td>未入通知追加メッセージ１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>minyuttaddmsg2</td><td>未入通知追加メッセージ２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>minyuttaddmsg3</td><td>未入通知追加メッセージ３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>minyuttaddmsg4</td><td>未入通知追加メッセージ４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>minyuttaddmsg5</td><td>未入通知追加メッセージ５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>minyuttaddmsg6</td><td>未入通知追加メッセージ６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>minyuttaddmsg7</td><td>未入通知追加メッセージ７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>minyuttaddmsg8</td><td>未入通知追加メッセージ８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>minyuttaddmsg9</td><td>未入通知追加メッセージ９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>minyuttaddmsg10</td><td>未入通知追加メッセージ１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>minyuttaddmsg11</td><td>未入通知追加メッセージ１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>minyuttaddmsg12</td><td>未入通知追加メッセージ１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>minyuttaddmsg13</td><td>未入通知追加メッセージ１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>minyuttaddmsg14</td><td>未入通知追加メッセージ１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>minyuttaddmsg15</td><td>未入通知追加メッセージ１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>minyuttaddmsg16</td><td>未入通知追加メッセージ１６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>minyuttaddmsg17</td><td>未入通知追加メッセージ１７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>minyuttaddmsg18</td><td>未入通知追加メッセージ１８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>minyuttaddmsg19</td><td>未入通知追加メッセージ１９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>minyuttaddmsg20</td><td>未入通知追加メッセージ２０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>minyuttaddmsg21</td><td>未入通知追加メッセージ２１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tuutisyuruicd</td><td>通知種類コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>saikokutuutizumiflg</td><td>催告通知作成済フラグ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Skszumiflg C_Skszumiflg}</td></tr>
 *  <tr><td>tyouhyoukigoukbn</td><td>帳票記号区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_AsTyouhyoukigouKbn C_AsTyouhyoukigouKbn}</td></tr>
 *  <tr><td>hrkkeiro</td><td>払込経路</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hrkkeiro C_Hrkkeiro}</td></tr>
 *  <tr><td>jkipjytym</td><td>次回Ｐ充当年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_KouzahuriMinyuTuuti
 * @see     GenIT_KouzahuriMinyuTuuti
 * @see     QIT_KouzahuriMinyuTuuti
 * @see     GenQIT_KouzahuriMinyuTuuti
 */
public class PKIT_KouzahuriMinyuTuuti extends AbstractExDBPrimaryKey<IT_KouzahuriMinyuTuuti, PKIT_KouzahuriMinyuTuuti> {

    private static final long serialVersionUID = 1L;

    public PKIT_KouzahuriMinyuTuuti() {
    }

    public PKIT_KouzahuriMinyuTuuti(
        String pKbnkey,
        String pSyono,
        BizDate pTyouhyouymd
    ) {
        kbnkey = pKbnkey;
        syono = pSyono;
        tyouhyouymd = pTyouhyouymd;
    }

    @Transient
    @Override
    public Class<IT_KouzahuriMinyuTuuti> getEntityClass() {
        return IT_KouzahuriMinyuTuuti.class;
    }

    private String kbnkey;

    public String getKbnkey() {
        return kbnkey;
    }

    public void setKbnkey(String pKbnkey) {
        kbnkey = pKbnkey;
    }
    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private BizDate tyouhyouymd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getTyouhyouymd() {
        return tyouhyouymd;
    }

    public void setTyouhyouymd(BizDate pTyouhyouymd) {
        tyouhyouymd = pTyouhyouymd;
    }

}