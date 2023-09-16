package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BT_IdouKhBosyuudrItjhzn;
import java.util.List;

/**
 * 異動契約保全募集代理店一時保存テーブル(BT_IdouKhBosyuudrItjhznDao) アクセス用の DAO クラスです。<br />
 */
public class BT_IdouKhBosyuudrItjhznDao extends AbstractDao<BT_IdouKhBosyuudrItjhzn> {

    public BT_IdouKhBosyuudrItjhznDao() {
        super(BT_IdouKhBosyuudrItjhzn.class);
    }

    @Deprecated
    public BT_IdouKhBosyuudrItjhzn getIdouKhBosyuudrItjhzn(String pSyono, Integer pRenno3keta) {
        BT_IdouKhBosyuudrItjhzn bT_IdouKhBosyuudrItjhzn =  new BT_IdouKhBosyuudrItjhzn();
        bT_IdouKhBosyuudrItjhzn.setSyono(pSyono);
        bT_IdouKhBosyuudrItjhzn.setRenno3keta(pRenno3keta);
        return this.selectOne(bT_IdouKhBosyuudrItjhzn);
    }

    @Override
    @Deprecated
    public List<BT_IdouKhBosyuudrItjhzn> selectAll() {
        return super.selectAll();
    }
}
