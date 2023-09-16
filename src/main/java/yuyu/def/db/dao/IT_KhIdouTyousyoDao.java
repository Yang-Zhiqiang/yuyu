package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_KhIdouTyousyo;
import java.util.List;

/**
 * 契約保全異動調書テーブル(IT_KhIdouTyousyoDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KhIdouTyousyoDao extends AbstractDao<IT_KhIdouTyousyo> {

    public IT_KhIdouTyousyoDao() {
        super(IT_KhIdouTyousyo.class);
    }

    @Deprecated
    public IT_KhIdouTyousyo getKhIdouTyousyo(String pSyono, BizDate pTyouhyouymd, Long pShrtysyrenno) {
        IT_KhIdouTyousyo iT_KhIdouTyousyo =  new IT_KhIdouTyousyo();
        iT_KhIdouTyousyo.setSyono(pSyono);
        iT_KhIdouTyousyo.setTyouhyouymd(pTyouhyouymd);
        iT_KhIdouTyousyo.setShrtysyrenno(pShrtysyrenno);
        return this.selectOne(iT_KhIdouTyousyo);
    }

    @Override
    @Deprecated
    public List<IT_KhIdouTyousyo> selectAll() {
        return super.selectAll();
    }
}
