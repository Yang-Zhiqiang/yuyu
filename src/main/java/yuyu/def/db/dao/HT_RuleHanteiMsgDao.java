package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_Rulehanteimsg;
import yuyu.def.db.entity.HT_RuleHanteiMsg;

/**
 * ルール判定結果メッセージテーブル(HT_RuleHanteiMsgDao) アクセス用の DAO クラスです。<br />
 */
public class HT_RuleHanteiMsgDao extends AbstractDao<HT_RuleHanteiMsg> {

    public HT_RuleHanteiMsgDao() {
        super(HT_RuleHanteiMsg.class);
    }

    @Deprecated
    public HT_RuleHanteiMsg getRuleHanteiMsg(String pMosno,
         C_Rulehanteimsg pRulehanteimsg,
         Integer pRenno){
        HT_RuleHanteiMsg hT_RuleHanteiMsg =  new HT_RuleHanteiMsg();
        hT_RuleHanteiMsg.setMosno(pMosno);
        hT_RuleHanteiMsg.setRulehanteimsg(pRulehanteimsg);
        hT_RuleHanteiMsg.setRenno(pRenno);
        return this.selectOne(hT_RuleHanteiMsg);
    }

    @Override
    @Deprecated
    public List<HT_RuleHanteiMsg> selectAll() {
        return super.selectAll();
    }
}
