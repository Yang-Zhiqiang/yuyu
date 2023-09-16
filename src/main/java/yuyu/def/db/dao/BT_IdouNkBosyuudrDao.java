package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BT_IdouNkBosyuudr;

/**
 * 異動年金支払募集代理店テーブル(BT_IdouNkBosyuudrDao) アクセス用の DAO クラスです。<br />
 */
public class BT_IdouNkBosyuudrDao extends AbstractDao<BT_IdouNkBosyuudr> {

    public BT_IdouNkBosyuudrDao() {
        super(BT_IdouNkBosyuudr.class);
    }

    @Deprecated
    public BT_IdouNkBosyuudr getIdouNkBosyuudr(String pNksysyno,
         Integer pRenno3keta){
        BT_IdouNkBosyuudr bT_IdouNkBosyuudr =  new BT_IdouNkBosyuudr();
        bT_IdouNkBosyuudr.setNksysyno(pNksysyno);
        bT_IdouNkBosyuudr.setRenno3keta(pRenno3keta);
        return this.selectOne(bT_IdouNkBosyuudr);
    }

    @Override
    @Deprecated
    public List<BT_IdouNkBosyuudr> selectAll() {
        return super.selectAll();
    }
}
