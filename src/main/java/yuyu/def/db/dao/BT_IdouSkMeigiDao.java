package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BT_IdouSkMeigi;

/**
 * 異動新契約名義管理テーブル(BT_IdouSkMeigiDao) アクセス用の DAO クラスです。<br />
 */
public class BT_IdouSkMeigiDao extends AbstractDao<BT_IdouSkMeigi> {

    public BT_IdouSkMeigiDao() {
        super(BT_IdouSkMeigi.class);
    }

    @Deprecated
    public BT_IdouSkMeigi getIdouSkMeigi(String pMosno,
         Integer pRenno3keta){
        BT_IdouSkMeigi bT_IdouSkMeigi =  new BT_IdouSkMeigi();
        bT_IdouSkMeigi.setMosno(pMosno);
        bT_IdouSkMeigi.setRenno3keta(pRenno3keta);
        return this.selectOne(bT_IdouSkMeigi);
    }

    @Override
    @Deprecated
    public List<BT_IdouSkMeigi> selectAll() {
        return super.selectAll();
    }
}
