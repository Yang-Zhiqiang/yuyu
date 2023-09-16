package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Rulehanteimsg;
import yuyu.def.db.entity.HT_RuleHanteiMsg;
import yuyu.def.db.id.PKHT_RuleHanteiMsg;
import yuyu.def.db.meta.GenQHT_RuleHanteiMsg;
import yuyu.def.db.meta.QHT_RuleHanteiMsg;
import yuyu.def.db.type.UserType_C_Rulehanteimsg;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * ルール判定結果メッセージテーブル テーブルのマッピング情報クラスで、 {@link HT_RuleHanteiMsg} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_RuleHanteiMsg}</td><td colspan="3">ルール判定結果メッセージテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">{@link PKHT_RuleHanteiMsg ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRulehanteimsg rulehanteimsg}</td><td>ルール判定結果メッセージ区分</td><td align="center">{@link PKHT_RuleHanteiMsg ○}</td><td align="center">V</td><td>{@link C_Rulehanteimsg}</td></tr>
 *  <tr><td>{@link #getRenno renno}</td><td>連番</td><td align="center">{@link PKHT_RuleHanteiMsg ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getRulehanteimsgid rulehanteimsgid}</td><td>ルール判定結果メッセージＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_RuleHanteiMsg
 * @see     PKHT_RuleHanteiMsg
 * @see     QHT_RuleHanteiMsg
 * @see     GenQHT_RuleHanteiMsg
 */
@MappedSuperclass
@Table(name=GenHT_RuleHanteiMsg.TABLE_NAME)
@IdClass(value=PKHT_RuleHanteiMsg.class)
@TypeDefs({
    @TypeDef(name="UserType_C_Rulehanteimsg", typeClass=UserType_C_Rulehanteimsg.class)
})
public abstract class GenHT_RuleHanteiMsg extends AbstractExDBEntity<HT_RuleHanteiMsg, PKHT_RuleHanteiMsg> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_RuleHanteiMsg";
    public static final String MOSNO                    = "mosno";
    public static final String RULEHANTEIMSG            = "rulehanteimsg";
    public static final String RENNO                    = "renno";
    public static final String RULEHANTEIMSGID          = "rulehanteimsgid";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_RuleHanteiMsg primaryKey;

    public GenHT_RuleHanteiMsg() {
        primaryKey = new PKHT_RuleHanteiMsg();
    }

    public GenHT_RuleHanteiMsg(
        String pMosno,
        C_Rulehanteimsg pRulehanteimsg,
        Integer pRenno
    ) {
        primaryKey = new PKHT_RuleHanteiMsg(
            pMosno,
            pRulehanteimsg,
            pRenno
        );
    }

    @Transient
    @Override
    public PKHT_RuleHanteiMsg getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_RuleHanteiMsg> getMetaClass() {
        return QHT_RuleHanteiMsg.class;
    }

    @Id
    @Column(name=GenHT_RuleHanteiMsg.MOSNO)
    @MousikomiNo
    public String getMosno() {
        return getPrimaryKey().getMosno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno(String pMosno) {
        getPrimaryKey().setMosno(pMosno);
    }

    @Id
    @Type(type="UserType_C_Rulehanteimsg")
    @Column(name=GenHT_RuleHanteiMsg.RULEHANTEIMSG)
    public C_Rulehanteimsg getRulehanteimsg() {
        return getPrimaryKey().getRulehanteimsg();
    }

    public void setRulehanteimsg(C_Rulehanteimsg pRulehanteimsg) {
        getPrimaryKey().setRulehanteimsg(pRulehanteimsg);
    }

    @Id
    @Column(name=GenHT_RuleHanteiMsg.RENNO)
    public Integer getRenno() {
        return getPrimaryKey().getRenno();
    }

    @Trim("both")
    public void setRenno(Integer pRenno) {
        getPrimaryKey().setRenno(pRenno);
    }

    private String rulehanteimsgid;

    @Column(name=GenHT_RuleHanteiMsg.RULEHANTEIMSGID)
    public String getRulehanteimsgid() {
        return rulehanteimsgid;
    }

    public void setRulehanteimsgid(String pRulehanteimsgid) {
        rulehanteimsgid = pRulehanteimsgid;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_RuleHanteiMsg.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_RuleHanteiMsg.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}