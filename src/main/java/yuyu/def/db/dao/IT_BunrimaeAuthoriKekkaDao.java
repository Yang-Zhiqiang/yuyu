package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_BunrimaeAuthoriKekka;

/**
 * 分離前オーソリ結果テーブル(IT_BunrimaeAuthoriKekkaDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BunrimaeAuthoriKekkaDao extends AbstractDao<IT_BunrimaeAuthoriKekka> {

    public IT_BunrimaeAuthoriKekkaDao() {
        super(IT_BunrimaeAuthoriKekka.class);
    }

    public IT_BunrimaeAuthoriKekka getBunrimaeAuthoriKekka(String pCreditkessaiyouno, String pDatajyusinymd) {
        IT_BunrimaeAuthoriKekka iT_BunrimaeAuthoriKekka =  new IT_BunrimaeAuthoriKekka();
        iT_BunrimaeAuthoriKekka.setCreditkessaiyouno(pCreditkessaiyouno);
        iT_BunrimaeAuthoriKekka.setDatajyusinymd(pDatajyusinymd);
        return this.selectOne(iT_BunrimaeAuthoriKekka);
    }
}
