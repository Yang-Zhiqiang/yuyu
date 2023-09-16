package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_KhTyousyo;

/**
 * 契約保全支払調書テーブル(IT_KhTyousyoDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KhTyousyoDao extends AbstractDao<IT_KhTyousyo> {

    public IT_KhTyousyoDao() {
        super(IT_KhTyousyo.class);
    }

    public IT_KhTyousyo getKhTyousyo(String pSyono,
        BizDate pTyouhyouymd,
        Long pShrtysyrenno){
        IT_KhTyousyo iT_KhTyousyo =  new IT_KhTyousyo();
        iT_KhTyousyo.setSyono(pSyono);
        iT_KhTyousyo.setTyouhyouymd(pTyouhyouymd);
        iT_KhTyousyo.setShrtysyrenno(pShrtysyrenno);
        return this.selectOne(iT_KhTyousyo);
    }
}
