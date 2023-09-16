package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_AnsyuCreditCard;

/**
 * 案内収納用クレジット払テーブル(IT_AnsyuCreditCardDao) アクセス用の DAO クラスです。<br />
 */
public class IT_AnsyuCreditCardDao extends AbstractDao<IT_AnsyuCreditCard> {

    public IT_AnsyuCreditCardDao() {
        super(IT_AnsyuCreditCard.class);
    }

    @Deprecated
    public IT_AnsyuCreditCard getAnsyuCreditCard(String pSyono){
        IT_AnsyuCreditCard iT_AnsyuCreditCard =  new IT_AnsyuCreditCard();
        iT_AnsyuCreditCard.setSyono(pSyono);
        return this.selectOne(iT_AnsyuCreditCard);
    }

    @Override
    @Deprecated
    public List<IT_AnsyuCreditCard> selectAll() {
        return super.selectAll();
    }
}
