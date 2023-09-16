package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.HM_HurikomiKouza;
import yuyu.def.db.mapping.GenHM_HurikomiKouza;
import yuyu.def.db.meta.GenQHM_HurikomiKouza;
import yuyu.def.db.meta.QHM_HurikomiKouza;
import yuyu.infr.validation.constraints.HostInvalidCharacter;

/**
 * 振込口座マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HM_HurikomiKouza}</td><td colspan="3">振込口座マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getBankcd bankcd}</td><td>銀行コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSitencd sitencd}</td><td>支店コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKouzano kouzano}</td><td>口座番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTuukasyu tuukasyu}</td><td>通貨種類</td><td align="center">○</td><td align="center">V</td><td>{@link C_Tuukasyu}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHrkmirnincd hrkmirnincd}</td><td>振込依頼人コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yokinkbn</td><td>預金種目区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YokinKbn C_YokinKbn}</td></tr>
 *  <tr><td>oyadrtencd</td><td>親代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nyuukinoyadrtennm</td><td>入金用親代理店名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>oyadrtensyoritarget</td><td>親代理店処理対象</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TaisyouKbn C_TaisyouKbn}</td></tr>
 *  <tr><td>jidonykntargethyouji</td><td>自動入金対象表示</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TaisyouKbn C_TaisyouKbn}</td></tr>
 *  <tr><td>hrkmirnineditptnkbn</td><td>振込依頼人編集パターン区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HrkmirninEditPtnKbn C_HrkmirninEditPtnKbn}</td></tr>
 *  <tr><td>siteituuka</td><td>指定通貨</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>honkouzacd</td><td>本口座コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nyktyhyoutkbn</td><td>入金帳票出力先区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NyktyhyoutKbn C_NyktyhyoutKbn}</td></tr>
 * </table>
 * @see     HM_HurikomiKouza
 * @see     GenHM_HurikomiKouza
 * @see     QHM_HurikomiKouza
 * @see     GenQHM_HurikomiKouza
 */
public class PKHM_HurikomiKouza extends AbstractExDBPrimaryKey<HM_HurikomiKouza, PKHM_HurikomiKouza> {

    private static final long serialVersionUID = 1L;

    public PKHM_HurikomiKouza() {
    }

    public PKHM_HurikomiKouza(
        String pBankcd,
        String pSitencd,
        String pKouzano,
        C_Tuukasyu pTuukasyu,
        String pHrkmirnincd
    ) {
        bankcd = pBankcd;
        sitencd = pSitencd;
        kouzano = pKouzano;
        tuukasyu = pTuukasyu;
        hrkmirnincd = pHrkmirnincd;
    }

    @Transient
    @Override
    public Class<HM_HurikomiKouza> getEntityClass() {
        return HM_HurikomiKouza.class;
    }

    private String bankcd;

    public String getBankcd() {
        return bankcd;
    }

    public void setBankcd(String pBankcd) {
        bankcd = pBankcd;
    }
    private String sitencd;

    public String getSitencd() {
        return sitencd;
    }

    public void setSitencd(String pSitencd) {
        sitencd = pSitencd;
    }
    private String kouzano;

    public String getKouzano() {
        return kouzano;
    }

    public void setKouzano(String pKouzano) {
        kouzano = pKouzano;
    }
    private C_Tuukasyu tuukasyu;

    @org.hibernate.annotations.Type(type="UserType_C_Tuukasyu")
    public C_Tuukasyu getTuukasyu() {
        return tuukasyu;
    }

    public void setTuukasyu(C_Tuukasyu pTuukasyu) {
        tuukasyu = pTuukasyu;
    }
    private String hrkmirnincd;

    public String getHrkmirnincd() {
        return hrkmirnincd;
    }

    public void setHrkmirnincd(String pHrkmirnincd) {
        hrkmirnincd = pHrkmirnincd;
    }

}