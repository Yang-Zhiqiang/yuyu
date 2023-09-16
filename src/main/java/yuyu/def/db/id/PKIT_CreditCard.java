package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.IT_CreditCard;
import yuyu.def.db.mapping.GenIT_CreditCard;
import yuyu.def.db.meta.GenQIT_CreditCard;
import yuyu.def.db.meta.QIT_CreditCard;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * クレジットカードテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_CreditCard}</td><td colspan="3">クレジットカードテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kokno</td><td>顧客番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>cardkaisyacd</td><td>カード会社コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditcardno1</td><td>クレジットカード番号１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditcardno2</td><td>クレジットカード番号２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditcardno3</td><td>クレジットカード番号３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditcardno4</td><td>クレジットカード番号４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditcardykkigen</td><td>クレジットカード有効期限</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditmeiginmkn</td><td>クレジットカード名義人氏名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_CreditCard
 * @see     GenIT_CreditCard
 * @see     QIT_CreditCard
 * @see     GenQIT_CreditCard
 */
public class PKIT_CreditCard extends AbstractExDBPrimaryKey<IT_CreditCard, PKIT_CreditCard> {

    private static final long serialVersionUID = 1L;

    public PKIT_CreditCard() {
    }

    public PKIT_CreditCard(String pKbnkey, String pSyono) {
        kbnkey = pKbnkey;
        syono = pSyono;
    }

    @Transient
    @Override
    public Class<IT_CreditCard> getEntityClass() {
        return IT_CreditCard.class;
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