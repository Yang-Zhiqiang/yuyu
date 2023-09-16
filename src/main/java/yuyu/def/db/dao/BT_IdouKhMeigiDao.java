package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BT_IdouKhMeigi;
import java.util.List;

/**
 * 異動契約保全名義管理テーブル(BT_IdouKhMeigiDao) アクセス用の DAO クラスです。<br />
 */
public class BT_IdouKhMeigiDao extends AbstractDao<BT_IdouKhMeigi> {

    public BT_IdouKhMeigiDao() {
        super(BT_IdouKhMeigi.class);
    }

    @Deprecated
    public BT_IdouKhMeigi getIdouKhMeigi(String pSyono, Integer pRenno3keta) {
        BT_IdouKhMeigi bT_IdouKhMeigi =  new BT_IdouKhMeigi();
        bT_IdouKhMeigi.setSyono(pSyono);
        bT_IdouKhMeigi.setRenno3keta(pRenno3keta);
        return this.selectOne(bT_IdouKhMeigi);
    }

    @Override
    @Deprecated
    public List<BT_IdouKhMeigi> selectAll() {
        return super.selectAll();
    }
}
