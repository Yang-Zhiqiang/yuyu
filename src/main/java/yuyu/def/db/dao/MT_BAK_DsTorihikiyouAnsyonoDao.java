package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.MT_BAK_DsTorihikiyouAnsyono;
import java.util.List;

/**
 * ＤＳ特定取引用暗証番号バックアップテーブル(MT_BAK_DsTorihikiyouAnsyonoDao) アクセス用の DAO クラスです。<br />
 */
public class MT_BAK_DsTorihikiyouAnsyonoDao extends AbstractDao<MT_BAK_DsTorihikiyouAnsyono> {

    public MT_BAK_DsTorihikiyouAnsyonoDao() {
        super(MT_BAK_DsTorihikiyouAnsyono.class);
    }

    @Deprecated
    public MT_BAK_DsTorihikiyouAnsyono getBAKDsTorihikiyouAnsyono(String pDskokno, String pSyono, String pTrkssikibetukey) {
        MT_BAK_DsTorihikiyouAnsyono mT_BAK_DsTorihikiyouAnsyono =  new MT_BAK_DsTorihikiyouAnsyono();
        mT_BAK_DsTorihikiyouAnsyono.setDskokno(pDskokno);
        mT_BAK_DsTorihikiyouAnsyono.setSyono(pSyono);
        mT_BAK_DsTorihikiyouAnsyono.setTrkssikibetukey(pTrkssikibetukey);
        return this.selectOne(mT_BAK_DsTorihikiyouAnsyono);
    }

    @Override
    @Deprecated
    public List<MT_BAK_DsTorihikiyouAnsyono> selectAll() {
        return super.selectAll();
    }
}
