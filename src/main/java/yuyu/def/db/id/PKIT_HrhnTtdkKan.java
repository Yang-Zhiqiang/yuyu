package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.IT_HrhnTtdkKan;
import yuyu.def.db.mapping.GenIT_HrhnTtdkKan;
import yuyu.def.db.meta.GenQIT_HrhnTtdkKan;
import yuyu.def.db.meta.QIT_HrhnTtdkKan;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 手続完了（払方変更）テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_HrhnTtdkKan}</td><td colspan="3">手続完了（払方変更）テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHenkousikibetukey henkousikibetukey}</td><td>変更識別キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoruiCd</td><td>書類コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyoruiCdKbn C_SyoruiCdKbn}</td></tr>
 *  <tr><td>tyouhyouymd</td><td>帳票作成日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
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
 *  <tr><td>toiawasekaisyanmkj</td><td>問合せ先会社名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>toiawasetelno</td><td>問合せ先電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>toiawaseteluktkkanou1</td><td>問合せ先電話受付可能時間１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>toiawaseteluktkkanou2</td><td>問合せ先電話受付可能時間２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>toiawasesosikinmkj2</td><td>第２問合せ先組織名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>toiawasetelno2</td><td>第２問合せ先電話番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kyknmkj</td><td>契約者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhknnmkj</td><td>被保険者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kouzamaskingmsg</td><td>口座マスキングＭＳＧ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkkaisuutkiktbrisyu</td><td>払込回数・定期一括払種類</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkkeiro</td><td>払込経路</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hrkkeiro C_Hrkkeiro}</td></tr>
 *  <tr><td>hrkp</td><td>払込保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>kouryokuhasseiym</td><td>効力発生年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>msgarea34keta1</td><td>メッセージエリア（３４桁）１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>msgarea34keta2</td><td>メッセージエリア（３４桁）２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>msgarea34keta3</td><td>メッセージエリア（３４桁）３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>msgarea34keta4</td><td>メッセージエリア（３４桁）４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>msgarea34keta5</td><td>メッセージエリア（３４桁）５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>msgarea34keta6</td><td>メッセージエリア（３４桁）６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>msgarea34keta7</td><td>メッセージエリア（３４桁）７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkykkmsg34keta1</td><td>振替予告メッセージ（３４桁）１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkykkmsg34keta2</td><td>振替予告メッセージ（３４桁）２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkykkmsg34keta3</td><td>振替予告メッセージ（３４桁）３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkykkmsg34keta4</td><td>振替予告メッセージ（３４桁）４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkykkmsg34keta5</td><td>振替予告メッセージ（３４桁）５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkykkmsg34keta6</td><td>振替予告メッセージ（３４桁）６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkykkmsg34keta7</td><td>振替予告メッセージ（３４桁）７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkykkmsg34keta8</td><td>振替予告メッセージ（３４桁）８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkykkmsg34keta9</td><td>振替予告メッセージ（３４桁）９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkykkmsg34keta10</td><td>振替予告メッセージ（３４桁）１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkykkmsg34keta11</td><td>振替予告メッセージ（３４桁）１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkykkmsg34keta12</td><td>振替予告メッセージ（３４桁）１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkykkmsg34keta13</td><td>振替予告メッセージ（３４桁）１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkykkmsg34keta14</td><td>振替予告メッセージ（３４桁）１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkykkmsg34keta15</td><td>振替予告メッセージ（３４桁）１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkykkmsg34keta16</td><td>振替予告メッセージ（３４桁）１６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkykkmsg34keta17</td><td>振替予告メッセージ（３４桁）１７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkykkmsg34keta18</td><td>振替予告メッセージ（３４桁）１８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkykkmsg34keta19</td><td>振替予告メッセージ（３４桁）１９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkykkmsg34keta20</td><td>振替予告メッセージ（３４桁）２０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkykkmsg34keta21</td><td>振替予告メッセージ（３４桁）２１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkykkmsg34keta22</td><td>振替予告メッセージ（３４桁）２２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkykkmsg34keta23</td><td>振替予告メッセージ（３４桁）２３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkykkmsg34keta24</td><td>振替予告メッセージ（３４桁）２４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkykkmsg34keta25</td><td>振替予告メッセージ（３４桁）２５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkykkmsg34keta26</td><td>振替予告メッセージ（３４桁）２６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkykkmsg34keta27</td><td>振替予告メッセージ（３４桁）２７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hrkykkmsg34keta28</td><td>振替予告メッセージ（３４桁）２８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hassoukbn</td><td>発送区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HassouKbn C_HassouKbn}</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>honsyakaisouriyuu</td><td>本社回送理由</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_HrhnTtdkKan
 * @see     GenIT_HrhnTtdkKan
 * @see     QIT_HrhnTtdkKan
 * @see     GenQIT_HrhnTtdkKan
 */
public class PKIT_HrhnTtdkKan extends AbstractExDBPrimaryKey<IT_HrhnTtdkKan, PKIT_HrhnTtdkKan> {

    private static final long serialVersionUID = 1L;

    public PKIT_HrhnTtdkKan() {
    }

    public PKIT_HrhnTtdkKan(
        String pKbnkey,
        String pSyono,
        String pHenkousikibetukey
    ) {
        kbnkey = pKbnkey;
        syono = pSyono;
        henkousikibetukey = pHenkousikibetukey;
    }

    @Transient
    @Override
    public Class<IT_HrhnTtdkKan> getEntityClass() {
        return IT_HrhnTtdkKan.class;
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
    private String henkousikibetukey;

    public String getHenkousikibetukey() {
        return henkousikibetukey;
    }

    public void setHenkousikibetukey(String pHenkousikibetukey) {
        henkousikibetukey = pHenkousikibetukey;
    }

}