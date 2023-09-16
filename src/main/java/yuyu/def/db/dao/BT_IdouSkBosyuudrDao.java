package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BT_IdouSkBosyuudr;

/**
 * 異動新契約募集代理店テーブル(BT_IdouSkBosyuudrDao) アクセス用の DAO クラスです。<br />
 */
public class BT_IdouSkBosyuudrDao extends AbstractDao<BT_IdouSkBosyuudr> {

    public BT_IdouSkBosyuudrDao() {
        super(BT_IdouSkBosyuudr.class);
    }

    @Deprecated
    public BT_IdouSkBosyuudr getIdouSkBosyuudr(String pMosno,
         Integer pRenno3keta){
        BT_IdouSkBosyuudr bT_IdouSkBosyuudr =  new BT_IdouSkBosyuudr();
        bT_IdouSkBosyuudr.setMosno(pMosno);
        bT_IdouSkBosyuudr.setRenno3keta(pRenno3keta);
        return this.selectOne(bT_IdouSkBosyuudr);
    }

    @Override
    @Deprecated
    public List<BT_IdouSkBosyuudr> selectAll() {
        return super.selectAll();
    }
}
