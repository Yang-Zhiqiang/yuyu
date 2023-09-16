package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import yuyu.def.db.entity.BM_Ginkou;
import yuyu.def.db.mapping.GenBM_Ginkou;
import yuyu.def.db.meta.GenQBM_Ginkou;
import yuyu.def.db.meta.QBM_Ginkou;

/**
 * 銀行マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_Ginkou}</td><td colspan="3">銀行マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getBankcd bankcd}</td><td>銀行コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSitencd sitencd}</td><td>支店コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kousinymd</td><td>更新年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>sinsetuymd</td><td>新設年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>haisiymd</td><td>廃止年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>banknmkn</td><td>銀行名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sitennmkn</td><td>支店名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>banknmkj</td><td>銀行名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sitennmkj</td><td>支店名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>banknmej</td><td>銀行名（英字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sitennmej</td><td>支店名（英字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>csskyouteikaisiymd</td><td>ＣＳＳ協定開始年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>csskyouteikaijyoymd</td><td>ＣＳＳ協定解除年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kokunaikwskameihyj</td><td>内国為替制度加盟表示</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Kokunaikwskameihyj C_Kokunaikwskameihyj}</td></tr>
 *  <tr><td>hrkmKanouihyj</td><td>振込可能支店表示</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HrkmKanouihyj C_HrkmKanouihyj}</td></tr>
 * </table>
 * @see     BM_Ginkou
 * @see     GenBM_Ginkou
 * @see     QBM_Ginkou
 * @see     GenQBM_Ginkou
 */
public class PKBM_Ginkou extends AbstractExDBPrimaryKey<BM_Ginkou, PKBM_Ginkou> {

    private static final long serialVersionUID = 1L;

    public PKBM_Ginkou() {
    }

    public PKBM_Ginkou(String pBankcd, String pSitencd) {
        bankcd = pBankcd;
        sitencd = pSitencd;
    }

    @Transient
    @Override
    public Class<BM_Ginkou> getEntityClass() {
        return BM_Ginkou.class;
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

}