package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BT_IdouSkMeigiItjhzn;

/**
 * 異動新契約名義管理一時保存テーブル(BT_IdouSkMeigiItjhznDao) アクセス用の DAO クラスです。<br />
 */
public class BT_IdouSkMeigiItjhznDao extends AbstractDao<BT_IdouSkMeigiItjhzn> {

    public BT_IdouSkMeigiItjhznDao() {
        super(BT_IdouSkMeigiItjhzn.class);
    }

    @Deprecated
    public BT_IdouSkMeigiItjhzn getIdouSkMeigiItjhzn(String pMosno,
         Integer pRenno3keta){
        BT_IdouSkMeigiItjhzn bT_IdouSkMeigiItjhzn =  new BT_IdouSkMeigiItjhzn();
        bT_IdouSkMeigiItjhzn.setMosno(pMosno);
        bT_IdouSkMeigiItjhzn.setRenno3keta(pRenno3keta);
        return this.selectOne(bT_IdouSkMeigiItjhzn);
    }

    @Override
    @Deprecated
    public List<BT_IdouSkMeigiItjhzn> selectAll() {
        return super.selectAll();
    }
}
