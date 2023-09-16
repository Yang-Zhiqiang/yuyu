package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_BAK_AeoiInfo;
import java.util.List;

/**
 * ＡＥＯＩ情報バックアップテーブル(IT_BAK_AeoiInfoDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_AeoiInfoDao extends AbstractDao<IT_BAK_AeoiInfo> {

    public IT_BAK_AeoiInfoDao() {
        super(IT_BAK_AeoiInfo.class);
    }

    @Deprecated
    public IT_BAK_AeoiInfo getBAKAeoiInfo(String pKbnkey, String pSyono, String pTrkssikibetukey, Integer pRenno) {
        IT_BAK_AeoiInfo iT_BAK_AeoiInfo =  new IT_BAK_AeoiInfo();
        iT_BAK_AeoiInfo.setKbnkey(pKbnkey);
        iT_BAK_AeoiInfo.setSyono(pSyono);
        iT_BAK_AeoiInfo.setTrkssikibetukey(pTrkssikibetukey);
        iT_BAK_AeoiInfo.setRenno(pRenno);
        return this.selectOne(iT_BAK_AeoiInfo);
    }

    @Override
    @Deprecated
    public List<IT_BAK_AeoiInfo> selectAll() {
        return super.selectAll();
    }
}
