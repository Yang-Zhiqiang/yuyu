package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_BAK_YykIdouAnsyuCreditCard;

/**
 * 予約異動案内収納用クレジット払バックアップテーブル(IT_BAK_YykIdouAnsyuCreditCardDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_YykIdouAnsyuCreditCardDao extends AbstractDao<IT_BAK_YykIdouAnsyuCreditCard> {

    public IT_BAK_YykIdouAnsyuCreditCardDao() {
        super(IT_BAK_YykIdouAnsyuCreditCard.class);
    }

    @Deprecated
    public IT_BAK_YykIdouAnsyuCreditCard getBAKYykIdouAnsyuCreditCard(String pSyono,
         String pTrkssikibetukey,
         String pHenkousikibetukey){
        IT_BAK_YykIdouAnsyuCreditCard iT_BAK_YykIdouAnsyuCreditCard =  new IT_BAK_YykIdouAnsyuCreditCard();
        iT_BAK_YykIdouAnsyuCreditCard.setSyono(pSyono);
        iT_BAK_YykIdouAnsyuCreditCard.setTrkssikibetukey(pTrkssikibetukey);
        iT_BAK_YykIdouAnsyuCreditCard.setHenkousikibetukey(pHenkousikibetukey);
        return this.selectOne(iT_BAK_YykIdouAnsyuCreditCard);
    }

    @Override
    @Deprecated
    public List<IT_BAK_YykIdouAnsyuCreditCard> selectAll() {
        return super.selectAll();
    }
}
