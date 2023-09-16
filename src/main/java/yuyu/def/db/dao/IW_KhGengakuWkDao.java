package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IW_KhGengakuWk;

/**
 * 減額ワークテーブル(IW_KhGengakuWkDao) アクセス用の DAO クラスです。<br />
 */
public class IW_KhGengakuWkDao extends AbstractDao<IW_KhGengakuWk> {

    public IW_KhGengakuWkDao() {
        super(IW_KhGengakuWk.class);
    }

    public IW_KhGengakuWk getKhGengakuWk(String pKouteikanriid){
        IW_KhGengakuWk iW_KhGengakuWk =  new IW_KhGengakuWk();
        iW_KhGengakuWk.setKouteikanriid(pKouteikanriid);
        return this.selectOne(iW_KhGengakuWk);
    }
}
