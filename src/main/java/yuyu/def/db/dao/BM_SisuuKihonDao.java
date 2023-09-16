package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_Sisuukbn;
import yuyu.def.db.entity.BM_SisuuKihon;
import java.util.List;

/**
 * 指数基本マスタ(BM_SisuuKihonDao) アクセス用の DAO クラスです。<br />
 */
public class BM_SisuuKihonDao extends AbstractDao<BM_SisuuKihon> {

    public BM_SisuuKihonDao() {
        super(BM_SisuuKihon.class);
    }

    @Deprecated
    public BM_SisuuKihon getSisuuKihon(C_Sisuukbn pSisuukbn) {
        BM_SisuuKihon bM_SisuuKihon =  new BM_SisuuKihon();
        bM_SisuuKihon.setSisuukbn(pSisuukbn);
        return this.selectOne(bM_SisuuKihon);
    }

    @Override
    @Deprecated
    public List<BM_SisuuKihon> selectAll() {
        return super.selectAll();
    }
}
