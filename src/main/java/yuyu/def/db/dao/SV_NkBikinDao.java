package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.SV_NkBikin;
import java.util.List;

/**
 * 年金備金ビュー(SV_NkBikinDao) アクセス用の DAO クラスです。<br />
 */
public class SV_NkBikinDao extends AbstractDao<SV_NkBikin> {

    public SV_NkBikinDao() {
        super(SV_NkBikin.class);
    }

    @Deprecated
    public SV_NkBikin getNkBikin(Integer pRenno8keta) {
        SV_NkBikin sV_NkBikin =  new SV_NkBikin();
        sV_NkBikin.setRenno8keta(pRenno8keta);
        return this.selectOne(sV_NkBikin);
    }

    @Override
    @Deprecated
    public List<SV_NkBikin> selectAll() {
        return super.selectAll();
    }
}
