package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BT_IdouKhMeigiItjhzn;
import java.util.List;

/**
 * 異動契約保全名義管理一時保存テーブル(BT_IdouKhMeigiItjhznDao) アクセス用の DAO クラスです。<br />
 */
public class BT_IdouKhMeigiItjhznDao extends AbstractDao<BT_IdouKhMeigiItjhzn> {

    public BT_IdouKhMeigiItjhznDao() {
        super(BT_IdouKhMeigiItjhzn.class);
    }

    @Deprecated
    public BT_IdouKhMeigiItjhzn getIdouKhMeigiItjhzn(String pSyono, Integer pRenno3keta) {
        BT_IdouKhMeigiItjhzn bT_IdouKhMeigiItjhzn =  new BT_IdouKhMeigiItjhzn();
        bT_IdouKhMeigiItjhzn.setSyono(pSyono);
        bT_IdouKhMeigiItjhzn.setRenno3keta(pRenno3keta);
        return this.selectOne(bT_IdouKhMeigiItjhzn);
    }

    @Override
    @Deprecated
    public List<BT_IdouKhMeigiItjhzn> selectAll() {
        return super.selectAll();
    }
}
