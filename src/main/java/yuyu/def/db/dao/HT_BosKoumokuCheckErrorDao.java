package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.HT_BosKoumokuCheckError;
import java.util.List;

/**
 * 募集項目チェックエラーテーブル(HT_BosKoumokuCheckErrorDao) アクセス用の DAO クラスです。<br />
 */
public class HT_BosKoumokuCheckErrorDao extends AbstractDao<HT_BosKoumokuCheckError> {

    public HT_BosKoumokuCheckErrorDao() {
        super(HT_BosKoumokuCheckError.class);
    }

    @Deprecated
    public HT_BosKoumokuCheckError getBosKoumokuCheckError(String pMosno, Integer pRenno3keta) {
        HT_BosKoumokuCheckError hT_BosKoumokuCheckError =  new HT_BosKoumokuCheckError();
        hT_BosKoumokuCheckError.setMosno(pMosno);
        hT_BosKoumokuCheckError.setRenno3keta(pRenno3keta);
        return this.selectOne(hT_BosKoumokuCheckError);
    }

    @Override
    @Deprecated
    public List<HT_BosKoumokuCheckError> selectAll() {
        return super.selectAll();
    }
}
