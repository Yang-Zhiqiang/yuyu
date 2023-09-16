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
import yuyu.def.db.entity.IT_KijituTouraiAnnai;
import yuyu.def.db.mapping.GenIT_KijituTouraiAnnai;
import yuyu.def.db.meta.GenQIT_KijituTouraiAnnai;
import yuyu.def.db.meta.QIT_KijituTouraiAnnai;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 期日到来案内テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KijituTouraiAnnai}</td><td colspan="3">期日到来案内テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTyouhyouymd tyouhyouymd}</td><td>帳票作成日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
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
 *  <tr><td>tuutinm20keta</td><td>通知名称（２０桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkykkmsg32keta1</td><td>振替予告メッセージ（３２桁）１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkykkmsg32keta2</td><td>振替予告メッセージ（３２桁）２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkykkmsg32keta3</td><td>振替予告メッセージ（３２桁）３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkykkmsg32keta4</td><td>振替予告メッセージ（３２桁）４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkykkmsg32keta5</td><td>振替予告メッセージ（３２桁）５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkykkmsg32keta6</td><td>振替予告メッセージ（３２桁）６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkykkmsg32keta7</td><td>振替予告メッセージ（３２桁）７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkykkmsg32keta8</td><td>振替予告メッセージ（３２桁）８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkkeiro</td><td>払込経路</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hrkkeiro C_Hrkkeiro}</td></tr>
 *  <tr><td>syouhnnm</td><td>商品名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykymd</td><td>契約日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hhknnmkj</td><td>被保険者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kjttrnnfreearea1</td><td>期日到来案内フリーエリア１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kjttrnnfreearea2</td><td>期日到来案内フリーエリア２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kjttrnnfreearea3</td><td>期日到来案内フリーエリア３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kjttrnnfreearea4</td><td>期日到来案内フリーエリア４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kjttrnnfreearea5</td><td>期日到来案内フリーエリア５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kjttrnnfreearea6</td><td>期日到来案内フリーエリア６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kjttrnnfreearea7</td><td>期日到来案内フリーエリア７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hurikaeymd</td><td>振替日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kzinfo1</td><td>口座情報１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzinfo2</td><td>口座情報２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzinfo3</td><td>口座情報３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzinfo4</td><td>口座情報４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzinfo5</td><td>口座情報５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzinfo6</td><td>口座情報６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzinfo7</td><td>口座情報７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzinfo8</td><td>口座情報８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hknjytukikan</td><td>保険充当期間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkgk1</td><td>払込金額１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkgk2</td><td>払込金額２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkgk3</td><td>払込金額３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkgk4</td><td>払込金額４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kjttrnnfreearea8</td><td>期日到来案内フリーエリア８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kjttrnnfreearea9</td><td>期日到来案内フリーエリア９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kjttrnnfreearea10</td><td>期日到来案内フリーエリア１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kjttrnnfreearea11</td><td>期日到来案内フリーエリア１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kjttrnnfreearea12</td><td>期日到来案内フリーエリア１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kjttrnnfreearea13</td><td>期日到来案内フリーエリア１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoruiCd</td><td>書類コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyoruiCdKbn C_SyoruiCdKbn}</td></tr>
 *  <tr><td>hassoukbn</td><td>発送区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HassouKbn C_HassouKbn}</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_KijituTouraiAnnai
 * @see     GenIT_KijituTouraiAnnai
 * @see     QIT_KijituTouraiAnnai
 * @see     GenQIT_KijituTouraiAnnai
 */
public class PKIT_KijituTouraiAnnai extends AbstractExDBPrimaryKey<IT_KijituTouraiAnnai, PKIT_KijituTouraiAnnai> {

    private static final long serialVersionUID = 1L;

    public PKIT_KijituTouraiAnnai() {
    }

    public PKIT_KijituTouraiAnnai(
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
    public Class<IT_KijituTouraiAnnai> getEntityClass() {
        return IT_KijituTouraiAnnai.class;
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