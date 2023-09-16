package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.BM_CreditCardKaisya;
import yuyu.def.db.mapping.GenBM_CreditCardKaisya;
import yuyu.def.db.meta.GenQBM_CreditCardKaisya;
import yuyu.def.db.meta.QBM_CreditCardKaisya;

/**
 * クレジットカード会社マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_CreditCardKaisya}</td><td colspan="3">クレジットカード会社マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getCardkaisyacd cardkaisyacd}</td><td>カード会社コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hyoujijyun</td><td>表示順</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>prefixstart</td><td>プレフィックス（開始）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>prefixend</td><td>プレフィックス（終了）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>cardnolength</td><td>カード番号長</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>cardkaisyanm</td><td>カード会社名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>cardkaisyanmryk</td><td>カード会社名（略称）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditsyuudaikocd</td><td>クレカ収納代行社コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>torihikisakicd</td><td>取引先コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>authoriyuukoukikannissuu</td><td>オーソリ有効期間日数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>tesuuryouryouritu</td><td>手数料料率</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>tesuuryouhasuusyorikbn</td><td>手数料端数処理区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HasuusyoriKbn C_HasuusyoriKbn}</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_CreditCardKaisya
 * @see     GenBM_CreditCardKaisya
 * @see     QBM_CreditCardKaisya
 * @see     GenQBM_CreditCardKaisya
 */
public class PKBM_CreditCardKaisya extends AbstractExDBPrimaryKey<BM_CreditCardKaisya, PKBM_CreditCardKaisya> {

    private static final long serialVersionUID = 1L;

    public PKBM_CreditCardKaisya() {
    }

    public PKBM_CreditCardKaisya(String pCardkaisyacd) {
        cardkaisyacd = pCardkaisyacd;
    }

    @Transient
    @Override
    public Class<BM_CreditCardKaisya> getEntityClass() {
        return BM_CreditCardKaisya.class;
    }

    private String cardkaisyacd;

    public String getCardkaisyacd() {
        return cardkaisyacd;
    }

    public void setCardkaisyacd(String pCardkaisyacd) {
        cardkaisyacd = pCardkaisyacd;
    }

}