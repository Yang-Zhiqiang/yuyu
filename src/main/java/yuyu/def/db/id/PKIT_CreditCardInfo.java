package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.IT_CreditCardInfo;
import yuyu.def.db.mapping.GenIT_CreditCardInfo;
import yuyu.def.db.meta.GenQIT_CreditCardInfo;
import yuyu.def.db.meta.QIT_CreditCardInfo;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * クレカ情報テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_CreditCardInfo}</td><td colspan="3">クレカ情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditkessaiyouno</td><td>クレジットカード決済用番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>credityuukoukakym</td><td>クレジットカード有効確認年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>credityuukoukakkekka</td><td>クレジットカード有効確認結果</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Yuukoukakkekka C_Yuukoukakkekka}</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_CreditCardInfo
 * @see     GenIT_CreditCardInfo
 * @see     QIT_CreditCardInfo
 * @see     GenQIT_CreditCardInfo
 */
public class PKIT_CreditCardInfo extends AbstractExDBPrimaryKey<IT_CreditCardInfo, PKIT_CreditCardInfo> {

    private static final long serialVersionUID = 1L;

    public PKIT_CreditCardInfo() {
    }

    public PKIT_CreditCardInfo(String pKbnkey, String pSyono) {
        kbnkey = pKbnkey;
        syono = pSyono;
    }

    @Transient
    @Override
    public Class<IT_CreditCardInfo> getEntityClass() {
        return IT_CreditCardInfo.class;
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