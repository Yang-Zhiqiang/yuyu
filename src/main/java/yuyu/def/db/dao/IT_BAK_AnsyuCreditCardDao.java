package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_BAK_AnsyuCreditCard;

/**
 * 案内収納用クレジット払バックアップテーブル(IT_BAK_AnsyuCreditCardDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_AnsyuCreditCardDao extends AbstractDao<IT_BAK_AnsyuCreditCard> {

    public IT_BAK_AnsyuCreditCardDao() {
        super(IT_BAK_AnsyuCreditCard.class);
    }

    @Deprecated
    public IT_BAK_AnsyuCreditCard getBAKAnsyuCreditCard(String pSyono,
         String pTrkssikibetukey){
        IT_BAK_AnsyuCreditCard iT_BAK_AnsyuCreditCard =  new IT_BAK_AnsyuCreditCard();
        iT_BAK_AnsyuCreditCard.setSyono(pSyono);
        iT_BAK_AnsyuCreditCard.setTrkssikibetukey(pTrkssikibetukey);
        return this.selectOne(iT_BAK_AnsyuCreditCard);
    }

    @Override
    @Deprecated
    public List<IT_BAK_AnsyuCreditCard> selectAll() {
        return super.selectAll();
    }
}
