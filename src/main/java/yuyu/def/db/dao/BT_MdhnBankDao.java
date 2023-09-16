package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BT_MdhnBank;

/**
 * 窓販銀行テーブル(BT_MdhnBankDao) アクセス用の DAO クラスです。<br />
 */
public class BT_MdhnBankDao extends AbstractDao<BT_MdhnBank> {

    public BT_MdhnBankDao() {
        super(BT_MdhnBank.class);
    }

    public BT_MdhnBank getMdhnBank(String pDrtencd){
        BT_MdhnBank bT_MdhnBank =  new BT_MdhnBank();
        bT_MdhnBank.setDrtencd(pDrtencd);
        return this.selectOne(bT_MdhnBank);
    }
}
