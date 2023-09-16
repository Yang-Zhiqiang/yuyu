package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IW_KhMeigiHenkouWk;

/**
 * 名義変更ワークテーブル(IW_KhMeigiHenkouWkDao) アクセス用の DAO クラスです。<br />
 */
public class IW_KhMeigiHenkouWkDao extends AbstractDao<IW_KhMeigiHenkouWk> {

    public IW_KhMeigiHenkouWkDao() {
        super(IW_KhMeigiHenkouWk.class);
    }

    public IW_KhMeigiHenkouWk getKhMeigiHenkouWk(String pKouteikanriid){
        IW_KhMeigiHenkouWk iW_KhMeigiHenkouWk =  new IW_KhMeigiHenkouWk();
        iW_KhMeigiHenkouWk.setKouteikanriid(pKouteikanriid);
        return this.selectOne(iW_KhMeigiHenkouWk);
    }
}
