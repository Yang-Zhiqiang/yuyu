package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.IT_KouzahuriStartAnnai;
import yuyu.def.db.mapping.GenIT_KouzahuriStartAnnai;
import yuyu.def.db.meta.GenQIT_KouzahuriStartAnnai;
import yuyu.def.db.meta.QIT_KouzahuriStartAnnai;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 口座振替開始案内テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KouzahuriStartAnnai}</td><td colspan="3">口座振替開始案内テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tyouhyouymd</td><td>帳票作成日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kyknmkj</td><td>契約者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinyno</td><td>通信先郵便番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinadr1kj</td><td>通信先住所１（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinadr2kj</td><td>通信先住所２（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tsinadr3kj</td><td>通信先住所３（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kykymd</td><td>契約日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hhknnmkj</td><td>被保険者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syouhnnm</td><td>商品名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tuutinm</td><td>通知名称</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>aisatumongon1</td><td>挨拶文言１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>aisatumongon2</td><td>挨拶文言２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>aisatumongon3</td><td>挨拶文言３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>aisatumongon4</td><td>挨拶文言４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>aisatumongon5</td><td>挨拶文言５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzhurikaeonegai1</td><td>口座振替についてのお願い１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzhurikaeonegai2</td><td>口座振替についてのお願い２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzhurikaeonegai3</td><td>口座振替についてのお願い３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzhurikaeonegai4</td><td>口座振替についてのお願い４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzhurikaeonegai5</td><td>口座振替についてのお願い５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzhurikaeonegai6</td><td>口座振替についてのお願い６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzhurikaeonegai7</td><td>口座振替についてのお願い７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzhurikaeonegai8</td><td>口座振替についてのお願い８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzhurikaeonegai9</td><td>口座振替についてのお願い９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzhurikaeonegai10</td><td>口座振替についてのお願い１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzhurikaeonegai11</td><td>口座振替についてのお願い１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzhurikaeonegai12</td><td>口座振替についてのお願い１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzhurikaeonegai13</td><td>口座振替についてのお願い１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzhurikaeonegai14</td><td>口座振替についてのお願い１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzhurikaeonegai15</td><td>口座振替についてのお願い１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tkbriphurikaeyoteigk</td><td>月払保険料（振替予定金額）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hurikaekzhosokumongon</td><td>振替口座補足文言</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hurikaekz1</td><td>振替口座１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hurikaekz2</td><td>振替口座２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hurikaekz3</td><td>振替口座３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hurikaekz4</td><td>振替口座４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hurikaekz5</td><td>振替口座５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
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
 *  <tr><td>syoruiCd</td><td>書類コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyoruiCdKbn C_SyoruiCdKbn}</td></tr>
 *  <tr><td>hassoukbn</td><td>発送区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HassouKbn C_HassouKbn}</td></tr>
 *  <tr><td>kzhuristartanfreearea1</td><td>口座振替開始案内フリーエリア１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzhuristartanfreearea2</td><td>口座振替開始案内フリーエリア２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzhuristartanfreearea3</td><td>口座振替開始案内フリーエリア３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzhuristartanfreearea4</td><td>口座振替開始案内フリーエリア４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzhuristartanfreearea5</td><td>口座振替開始案内フリーエリア５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzhuristartanfreearea6</td><td>口座振替開始案内フリーエリア６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzhuristartanfreearea7</td><td>口座振替開始案内フリーエリア７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzhuristartanfreearea8</td><td>口座振替開始案内フリーエリア８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzhuristartanfreearea9</td><td>口座振替開始案内フリーエリア９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzhuristartanfreearea10</td><td>口座振替開始案内フリーエリア１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_KouzahuriStartAnnai
 * @see     GenIT_KouzahuriStartAnnai
 * @see     QIT_KouzahuriStartAnnai
 * @see     GenQIT_KouzahuriStartAnnai
 */
public class PKIT_KouzahuriStartAnnai extends AbstractExDBPrimaryKey<IT_KouzahuriStartAnnai, PKIT_KouzahuriStartAnnai> {

    private static final long serialVersionUID = 1L;

    public PKIT_KouzahuriStartAnnai() {
    }

    public PKIT_KouzahuriStartAnnai(String pKbnkey, String pSyono) {
        kbnkey = pKbnkey;
        syono = pSyono;
    }

    @Transient
    @Override
    public Class<IT_KouzahuriStartAnnai> getEntityClass() {
        return IT_KouzahuriStartAnnai.class;
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

}