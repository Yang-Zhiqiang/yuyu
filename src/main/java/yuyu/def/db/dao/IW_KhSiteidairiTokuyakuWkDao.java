package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IW_KhSiteidairiTokuyakuWk;

/**
 * 指定代理請求特約中途付加ワークテーブル(IW_KhSiteidairiTokuyakuWkDao) アクセス用の DAO クラスです。<br />
 */
public class IW_KhSiteidairiTokuyakuWkDao extends AbstractDao<IW_KhSiteidairiTokuyakuWk> {

    public IW_KhSiteidairiTokuyakuWkDao() {
        super(IW_KhSiteidairiTokuyakuWk.class);
    }

    public IW_KhSiteidairiTokuyakuWk getKhSiteidairiTokuyakuWk(String pKouteikanriid){
        IW_KhSiteidairiTokuyakuWk iW_KhSiteidairiTokuyakuWk =  new IW_KhSiteidairiTokuyakuWk();
        iW_KhSiteidairiTokuyakuWk.setKouteikanriid(pKouteikanriid);
        return this.selectOne(iW_KhSiteidairiTokuyakuWk);
    }
}
