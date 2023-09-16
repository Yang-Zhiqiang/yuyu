package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BT_TjtIdouNySkItjhzn;

/**
 * 当日異動内容新契約一時保存テーブル(BT_TjtIdouNySkItjhznDao) アクセス用の DAO クラスです。<br />
 */
public class BT_TjtIdouNySkItjhznDao extends AbstractDao<BT_TjtIdouNySkItjhzn> {

    public BT_TjtIdouNySkItjhznDao() {
        super(BT_TjtIdouNySkItjhzn.class);
    }

    public BT_TjtIdouNySkItjhzn getTjtIdouNySkItjhzn(String pMosno,
         Integer pRenno3keta){
        BT_TjtIdouNySkItjhzn bT_TjtIdouNySkItjhzn =  new BT_TjtIdouNySkItjhzn();
        bT_TjtIdouNySkItjhzn.setMosno(pMosno);
        bT_TjtIdouNySkItjhzn.setRenno3keta(pRenno3keta);
        return this.selectOne(bT_TjtIdouNySkItjhzn);
    }
}
