package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BT_IdouKhBosyuudr;
import java.util.List;

/**
 * 異動契約保全募集代理店テーブル(BT_IdouKhBosyuudrDao) アクセス用の DAO クラスです。<br />
 */
public class BT_IdouKhBosyuudrDao extends AbstractDao<BT_IdouKhBosyuudr> {

    public BT_IdouKhBosyuudrDao() {
        super(BT_IdouKhBosyuudr.class);
    }

    @Deprecated
    public BT_IdouKhBosyuudr getIdouKhBosyuudr(String pSyono, Integer pRenno3keta) {
        BT_IdouKhBosyuudr bT_IdouKhBosyuudr =  new BT_IdouKhBosyuudr();
        bT_IdouKhBosyuudr.setSyono(pSyono);
        bT_IdouKhBosyuudr.setRenno3keta(pRenno3keta);
        return this.selectOne(bT_IdouKhBosyuudr);
    }

    @Override
    @Deprecated
    public List<BT_IdouKhBosyuudr> selectAll() {
        return super.selectAll();
    }
}
