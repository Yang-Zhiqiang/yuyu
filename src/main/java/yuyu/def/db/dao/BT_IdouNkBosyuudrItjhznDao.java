package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BT_IdouNkBosyuudrItjhzn;

/**
 * 異動年金支払募集代理店一時保存テーブル(BT_IdouNkBosyuudrItjhznDao) アクセス用の DAO クラスです。<br />
 */
public class BT_IdouNkBosyuudrItjhznDao extends AbstractDao<BT_IdouNkBosyuudrItjhzn> {

    public BT_IdouNkBosyuudrItjhznDao() {
        super(BT_IdouNkBosyuudrItjhzn.class);
    }

    @Deprecated
    public BT_IdouNkBosyuudrItjhzn getIdouNkBosyuudrItjhzn(String pNksysyno,
         Integer pRenno3keta){
        BT_IdouNkBosyuudrItjhzn bT_IdouNkBosyuudrItjhzn =  new BT_IdouNkBosyuudrItjhzn();
        bT_IdouNkBosyuudrItjhzn.setNksysyno(pNksysyno);
        bT_IdouNkBosyuudrItjhzn.setRenno3keta(pRenno3keta);
        return this.selectOne(bT_IdouNkBosyuudrItjhzn);
    }

    @Override
    @Deprecated
    public List<BT_IdouNkBosyuudrItjhzn> selectAll() {
        return super.selectAll();
    }
}
