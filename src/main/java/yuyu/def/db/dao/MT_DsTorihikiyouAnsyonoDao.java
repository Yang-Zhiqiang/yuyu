package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.MT_DsTorihikiyouAnsyono;
import java.util.List;

/**
 * ＤＳ特定取引用暗証番号テーブル(MT_DsTorihikiyouAnsyonoDao) アクセス用の DAO クラスです。<br />
 */
public class MT_DsTorihikiyouAnsyonoDao extends AbstractDao<MT_DsTorihikiyouAnsyono> {

    public MT_DsTorihikiyouAnsyonoDao() {
        super(MT_DsTorihikiyouAnsyono.class);
    }

    @Deprecated
    public MT_DsTorihikiyouAnsyono getDsTorihikiyouAnsyono(String pDskokno, String pSyono) {
        MT_DsTorihikiyouAnsyono mT_DsTorihikiyouAnsyono =  new MT_DsTorihikiyouAnsyono();
        mT_DsTorihikiyouAnsyono.setDskokno(pDskokno);
        mT_DsTorihikiyouAnsyono.setSyono(pSyono);
        return this.selectOne(mT_DsTorihikiyouAnsyono);
    }

    @Override
    @Deprecated
    public List<MT_DsTorihikiyouAnsyono> selectAll() {
        return super.selectAll();
    }
}
