package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BT_IdouNkMeigi;

/**
 * 異動年金支払名義管理テーブル(BT_IdouNkMeigiDao) アクセス用の DAO クラスです。<br />
 */
public class BT_IdouNkMeigiDao extends AbstractDao<BT_IdouNkMeigi> {

    public BT_IdouNkMeigiDao() {
        super(BT_IdouNkMeigi.class);
    }

    @Deprecated
    public BT_IdouNkMeigi getIdouNkMeigi(String pNksysyno,
         Integer pRenno3keta){
        BT_IdouNkMeigi bT_IdouNkMeigi =  new BT_IdouNkMeigi();
        bT_IdouNkMeigi.setNksysyno(pNksysyno);
        bT_IdouNkMeigi.setRenno3keta(pRenno3keta);
        return this.selectOne(bT_IdouNkMeigi);
    }

    @Override
    @Deprecated
    public List<BT_IdouNkMeigi> selectAll() {
        return super.selectAll();
    }
}
