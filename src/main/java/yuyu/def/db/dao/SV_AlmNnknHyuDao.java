package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.SV_AlmNnknHyu;
import java.util.List;

/**
 * ＡＬＭ用年金保有明細ビュー(SV_AlmNnknHyuDao) アクセス用の DAO クラスです。<br />
 */
public class SV_AlmNnknHyuDao extends AbstractDao<SV_AlmNnknHyu> {

    public SV_AlmNnknHyuDao() {
        super(SV_AlmNnknHyu.class);
    }

    @Deprecated
    public SV_AlmNnknHyu getAlmNnknHyu(Integer pRenno8keta) {
        SV_AlmNnknHyu sV_AlmNnknHyu =  new SV_AlmNnknHyu();
        sV_AlmNnknHyu.setRenno8keta(pRenno8keta);
        return this.selectOne(sV_AlmNnknHyu);
    }

    @Override
    @Deprecated
    public List<SV_AlmNnknHyu> selectAll() {
        return super.selectAll();
    }
}
