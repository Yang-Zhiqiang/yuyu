package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_SkeittdkrenrakuKbn;
import yuyu.def.db.entity.HT_SkTtdkTyuui;

/**
 * 新契約手続注意テーブル(HT_SkTtdkTyuuiDao) アクセス用の DAO クラスです。<br />
 */
public class HT_SkTtdkTyuuiDao extends AbstractDao<HT_SkTtdkTyuui> {

    public HT_SkTtdkTyuuiDao() {
        super(HT_SkTtdkTyuui.class);
    }

    @Deprecated
    public HT_SkTtdkTyuui getSkTtdkTyuui(String pMosno,
         C_SkeittdkrenrakuKbn pSkeittdkrenrakukbn,
         Integer pDatarenno){
        HT_SkTtdkTyuui hT_SkTtdkTyuui =  new HT_SkTtdkTyuui();
        hT_SkTtdkTyuui.setMosno(pMosno);
        hT_SkTtdkTyuui.setSkeittdkrenrakukbn(pSkeittdkrenrakukbn);
        hT_SkTtdkTyuui.setDatarenno(pDatarenno);
        return this.selectOne(hT_SkTtdkTyuui);
    }

    @Override
    @Deprecated
    public List<HT_SkTtdkTyuui> selectAll() {
        return super.selectAll();
    }
}
