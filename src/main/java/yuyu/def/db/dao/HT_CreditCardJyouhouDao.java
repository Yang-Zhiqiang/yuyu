package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.HT_CreditCardJyouhou;

/**
 * クレジットカード情報テーブル(HT_CreditCardJyouhouDao) アクセス用の DAO クラスです。<br />
 */
public class HT_CreditCardJyouhouDao extends AbstractDao<HT_CreditCardJyouhou> {

    public HT_CreditCardJyouhouDao() {
        super(HT_CreditCardJyouhou.class);
    }

    @Deprecated
    public HT_CreditCardJyouhou getCreditCardJyouhou(String pMosno){
        HT_CreditCardJyouhou hT_CreditCardJyouhou =  new HT_CreditCardJyouhou();
        hT_CreditCardJyouhou.setMosno(pMosno);
        return this.selectOne(hT_CreditCardJyouhou);
    }

    @Override
    @Deprecated
    public List<HT_CreditCardJyouhou> selectAll() {
        return super.selectAll();
    }
}
