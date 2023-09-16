package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BM_TestSyonokanri;

/**
 * テスト用証券番号管理マスタ(BM_TestSyonokanriDao) アクセス用の DAO クラスです。<br />
 */
public class BM_TestSyonokanriDao extends AbstractDao<BM_TestSyonokanri> {

    public BM_TestSyonokanriDao() {
        super(BM_TestSyonokanri.class);
    }

    public BM_TestSyonokanri getTestSyonokanri(String pSeirekinen2keta, String pBosyuusosikicd, Integer pSyonorenno) {
        BM_TestSyonokanri bM_TestSyonokanri =  new BM_TestSyonokanri();
        bM_TestSyonokanri.setSeirekinen2keta(pSeirekinen2keta);
        bM_TestSyonokanri.setBosyuusosikicd(pBosyuusosikicd);
        bM_TestSyonokanri.setSyonorenno(pSyonorenno);
        return this.selectOne(bM_TestSyonokanri);
    }
}
