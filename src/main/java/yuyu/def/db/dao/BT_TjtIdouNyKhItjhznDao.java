package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BT_TjtIdouNyKhItjhzn;

/**
 * 当日異動内容契約保全一時保存テーブル(BT_TjtIdouNyKhItjhznDao) アクセス用の DAO クラスです。<br />
 */
public class BT_TjtIdouNyKhItjhznDao extends AbstractDao<BT_TjtIdouNyKhItjhzn> {

    public BT_TjtIdouNyKhItjhznDao() {
        super(BT_TjtIdouNyKhItjhzn.class);
    }

    public BT_TjtIdouNyKhItjhzn getTjtIdouNyKhItjhzn(String pSyono, Integer pRenno3keta) {
        BT_TjtIdouNyKhItjhzn bT_TjtIdouNyKhItjhzn =  new BT_TjtIdouNyKhItjhzn();
        bT_TjtIdouNyKhItjhzn.setSyono(pSyono);
        bT_TjtIdouNyKhItjhzn.setRenno3keta(pRenno3keta);
        return this.selectOne(bT_TjtIdouNyKhItjhzn);
    }
}
