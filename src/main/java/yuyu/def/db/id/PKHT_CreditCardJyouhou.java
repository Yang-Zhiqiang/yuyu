package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.HT_CreditCardJyouhou;
import yuyu.def.db.mapping.GenHT_CreditCardJyouhou;
import yuyu.def.db.meta.GenQHT_CreditCardJyouhou;
import yuyu.def.db.meta.QHT_CreditCardJyouhou;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * クレジットカード情報テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_CreditCardJyouhou}</td><td colspan="3">クレジットカード情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditkessaiyouno</td><td>クレジットカード決済用番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>cardbrandkbn</td><td>カードブランド区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_CardBrandKbn C_CardBrandKbn}</td></tr>
 *  <tr><td>credittrkhoukbn</td><td>クレジットカード登録方法区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_CreditTrkhouKbn C_CreditTrkhouKbn}</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_CreditCardJyouhou
 * @see     GenHT_CreditCardJyouhou
 * @see     QHT_CreditCardJyouhou
 * @see     GenQHT_CreditCardJyouhou
 */
public class PKHT_CreditCardJyouhou extends AbstractExDBPrimaryKey<HT_CreditCardJyouhou, PKHT_CreditCardJyouhou> {

    private static final long serialVersionUID = 1L;

    public PKHT_CreditCardJyouhou() {
    }

    public PKHT_CreditCardJyouhou(String pMosno) {
        mosno = pMosno;
    }

    @Transient
    @Override
    public Class<HT_CreditCardJyouhou> getEntityClass() {
        return HT_CreditCardJyouhou.class;
    }

    private String mosno;

    public String getMosno() {
        return mosno;
    }

    public void setMosno(String pMosno) {
        mosno = pMosno;
    }

}