package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.SV_NkHit;
import java.util.List;

/**
 * 年金配当所要額ビュー(SV_NkHitDao) アクセス用の DAO クラスです。<br />
 */
public class SV_NkHitDao extends AbstractDao<SV_NkHit> {

    public SV_NkHitDao() {
        super(SV_NkHit.class);
    }

    @Deprecated
    public SV_NkHit getNkHit(Integer pRenno8keta) {
        SV_NkHit sV_NkHit =  new SV_NkHit();
        sV_NkHit.setRenno8keta(pRenno8keta);
        return this.selectOne(sV_NkHit);
    }

    @Override
    @Deprecated
    public List<SV_NkHit> selectAll() {
        return super.selectAll();
    }
}
