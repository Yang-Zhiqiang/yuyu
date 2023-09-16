package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.SV_SnkiykGtjSirt;

/**
 * 新契約決算ベース月次成立情報ビュー(SV_SnkiykGtjSirtDao) アクセス用の DAO クラスです。<br />
 */
public class SV_SnkiykGtjSirtDao extends AbstractDao<SV_SnkiykGtjSirt> {

    public SV_SnkiykGtjSirtDao() {
        super(SV_SnkiykGtjSirt.class);
    }

    public SV_SnkiykGtjSirt getSnkiykGtjSirt(String pMosno) {
        SV_SnkiykGtjSirt sV_SnkiykGtjSirt =  new SV_SnkiykGtjSirt();
        sV_SnkiykGtjSirt.setMosno(pMosno);
        return this.selectOne(sV_SnkiykGtjSirt);
    }
}
