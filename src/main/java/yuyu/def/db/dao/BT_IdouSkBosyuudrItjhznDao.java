package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BT_IdouSkBosyuudrItjhzn;

/**
 * 異動新契約募集代理店一時保存テーブル(BT_IdouSkBosyuudrItjhznDao) アクセス用の DAO クラスです。<br />
 */
public class BT_IdouSkBosyuudrItjhznDao extends AbstractDao<BT_IdouSkBosyuudrItjhzn> {

    public BT_IdouSkBosyuudrItjhznDao() {
        super(BT_IdouSkBosyuudrItjhzn.class);
    }

    @Deprecated
    public BT_IdouSkBosyuudrItjhzn getIdouSkBosyuudrItjhzn(String pMosno,
         Integer pRenno3keta){
        BT_IdouSkBosyuudrItjhzn bT_IdouSkBosyuudrItjhzn =  new BT_IdouSkBosyuudrItjhzn();
        bT_IdouSkBosyuudrItjhzn.setMosno(pMosno);
        bT_IdouSkBosyuudrItjhzn.setRenno3keta(pRenno3keta);
        return this.selectOne(bT_IdouSkBosyuudrItjhzn);
    }

    @Override
    @Deprecated
    public List<BT_IdouSkBosyuudrItjhzn> selectAll() {
        return super.selectAll();
    }
}
