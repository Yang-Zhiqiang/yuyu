package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.MT_DsMailHaisinYoyaku;
import java.util.List;

/**
 * ＤＳメール配信予約テーブル(MT_DsMailHaisinYoyakuDao) アクセス用の DAO クラスです。<br />
 */
public class MT_DsMailHaisinYoyakuDao extends AbstractDao<MT_DsMailHaisinYoyaku> {

    public MT_DsMailHaisinYoyakuDao() {
        super(MT_DsMailHaisinYoyaku.class);
    }

    @Deprecated
    public MT_DsMailHaisinYoyaku getDsMailHaisinYoyaku(String pDsmailhaisinyoyakuskbtkey) {
        MT_DsMailHaisinYoyaku mT_DsMailHaisinYoyaku =  new MT_DsMailHaisinYoyaku();
        mT_DsMailHaisinYoyaku.setDsmailhaisinyoyakuskbtkey(pDsmailhaisinyoyakuskbtkey);
        return this.selectOne(mT_DsMailHaisinYoyaku);
    }

    @Override
    @Deprecated
    public List<MT_DsMailHaisinYoyaku> selectAll() {
        return super.selectAll();
    }
}
