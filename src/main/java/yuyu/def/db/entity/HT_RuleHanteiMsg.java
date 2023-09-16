package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.classification.C_Rulehanteimsg;
import yuyu.def.db.mapping.GenHT_RuleHanteiMsg;


/**
 * ルール判定結果メッセージテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenHT_RuleHanteiMsg} の JavaDoc を参照してください。<br />
 * @see     GenHT_RuleHanteiMsg<br />
 * @see     PKHT_RuleHanteiMsg<br />
 * @see     QHT_RuleHanteiMsg<br />
 * @see     GenQHT_RuleHanteiMsg<br />
 */
@Entity
public class HT_RuleHanteiMsg extends GenHT_RuleHanteiMsg {

    private static final long serialVersionUID = 1L;

    public HT_RuleHanteiMsg() {
    }

    public HT_RuleHanteiMsg(String pMosno,C_Rulehanteimsg pRulehanteimsg,Integer pRenno) {
        super(pMosno,pRulehanteimsg,pRenno);
    }



    private HT_SyoriCTL hT_SyoriCTL ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=HT_RuleHanteiMsg.MOSNO  , referencedColumnName=HT_SyoriCTL.MOSNO, insertable=false, updatable=false)
    })
    public HT_SyoriCTL getSyoriCTL() {
        return hT_SyoriCTL;
    }

    public void setSyoriCTL(HT_SyoriCTL pHT_SyoriCTL) {
        this.hT_SyoriCTL = pHT_SyoriCTL;
    }

}

