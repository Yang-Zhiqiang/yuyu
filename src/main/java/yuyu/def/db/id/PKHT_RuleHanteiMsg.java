package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Rulehanteimsg;
import yuyu.def.db.entity.HT_RuleHanteiMsg;
import yuyu.def.db.mapping.GenHT_RuleHanteiMsg;
import yuyu.def.db.meta.GenQHT_RuleHanteiMsg;
import yuyu.def.db.meta.QHT_RuleHanteiMsg;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * ルール判定結果メッセージテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_RuleHanteiMsg}</td><td colspan="3">ルール判定結果メッセージテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRulehanteimsg rulehanteimsg}</td><td>ルール判定結果メッセージ区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_Rulehanteimsg}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno renno}</td><td>連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>rulehanteimsgid</td><td>ルール判定結果メッセージＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_RuleHanteiMsg
 * @see     GenHT_RuleHanteiMsg
 * @see     QHT_RuleHanteiMsg
 * @see     GenQHT_RuleHanteiMsg
 */
public class PKHT_RuleHanteiMsg extends AbstractExDBPrimaryKey<HT_RuleHanteiMsg, PKHT_RuleHanteiMsg> {

    private static final long serialVersionUID = 1L;

    public PKHT_RuleHanteiMsg() {
    }

    public PKHT_RuleHanteiMsg(
        String pMosno,
        C_Rulehanteimsg pRulehanteimsg,
        Integer pRenno
    ) {
        mosno = pMosno;
        rulehanteimsg = pRulehanteimsg;
        renno = pRenno;
    }

    @Transient
    @Override
    public Class<HT_RuleHanteiMsg> getEntityClass() {
        return HT_RuleHanteiMsg.class;
    }

    private String mosno;

    public String getMosno() {
        return mosno;
    }

    public void setMosno(String pMosno) {
        mosno = pMosno;
    }
    private C_Rulehanteimsg rulehanteimsg;

    @org.hibernate.annotations.Type(type="UserType_C_Rulehanteimsg")
    public C_Rulehanteimsg getRulehanteimsg() {
        return rulehanteimsg;
    }

    public void setRulehanteimsg(C_Rulehanteimsg pRulehanteimsg) {
        rulehanteimsg = pRulehanteimsg;
    }
    private Integer renno;

    public Integer getRenno() {
        return renno;
    }

    public void setRenno(Integer pRenno) {
        renno = pRenno;
    }

}