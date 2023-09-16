package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BT_IdouNkMeigiItjhzn;

/**
 * 異動年金支払名義管理一時保存テーブル(BT_IdouNkMeigiItjhznDao) アクセス用の DAO クラスです。<br />
 */
public class BT_IdouNkMeigiItjhznDao extends AbstractDao<BT_IdouNkMeigiItjhzn> {

    public BT_IdouNkMeigiItjhznDao() {
        super(BT_IdouNkMeigiItjhzn.class);
    }

    @Deprecated
    public BT_IdouNkMeigiItjhzn getIdouNkMeigiItjhzn(String pNksysyno,
         Integer pRenno3keta){
        BT_IdouNkMeigiItjhzn bT_IdouNkMeigiItjhzn =  new BT_IdouNkMeigiItjhzn();
        bT_IdouNkMeigiItjhzn.setNksysyno(pNksysyno);
        bT_IdouNkMeigiItjhzn.setRenno3keta(pRenno3keta);
        return this.selectOne(bT_IdouNkMeigiItjhzn);
    }

    @Override
    @Deprecated
    public List<BT_IdouNkMeigiItjhzn> selectAll() {
        return super.selectAll();
    }
}
