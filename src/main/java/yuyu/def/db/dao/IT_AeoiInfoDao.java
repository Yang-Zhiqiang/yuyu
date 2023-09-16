package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_AeoiInfo;
import java.util.List;

/**
 * ＡＥＯＩ情報テーブル(IT_AeoiInfoDao) アクセス用の DAO クラスです。<br />
 */
public class IT_AeoiInfoDao extends AbstractDao<IT_AeoiInfo> {

    public IT_AeoiInfoDao() {
        super(IT_AeoiInfo.class);
    }

    @Deprecated
    public IT_AeoiInfo getAeoiInfo(String pKbnkey, String pSyono, Integer pRenno) {
        IT_AeoiInfo iT_AeoiInfo =  new IT_AeoiInfo();
        iT_AeoiInfo.setKbnkey(pKbnkey);
        iT_AeoiInfo.setSyono(pSyono);
        iT_AeoiInfo.setRenno(pRenno);
        return this.selectOne(iT_AeoiInfo);
    }

    @Override
    @Deprecated
    public List<IT_AeoiInfo> selectAll() {
        return super.selectAll();
    }
}
