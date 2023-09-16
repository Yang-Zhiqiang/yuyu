package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BT_TjtIdouNyNkItjhzn;

/**
 * 当日異動内容年金支払一時保存テーブル(BT_TjtIdouNyNkItjhznDao) アクセス用の DAO クラスです。<br />
 */
public class BT_TjtIdouNyNkItjhznDao extends AbstractDao<BT_TjtIdouNyNkItjhzn> {

    public BT_TjtIdouNyNkItjhznDao() {
        super(BT_TjtIdouNyNkItjhzn.class);
    }

    public BT_TjtIdouNyNkItjhzn getTjtIdouNyNkItjhzn(String pNksysyno,
         Integer pRenno3keta){
        BT_TjtIdouNyNkItjhzn bT_TjtIdouNyNkItjhzn =  new BT_TjtIdouNyNkItjhzn();
        bT_TjtIdouNyNkItjhzn.setNksysyno(pNksysyno);
        bT_TjtIdouNyNkItjhzn.setRenno3keta(pRenno3keta);
        return this.selectOne(bT_TjtIdouNyNkItjhzn);
    }
}
