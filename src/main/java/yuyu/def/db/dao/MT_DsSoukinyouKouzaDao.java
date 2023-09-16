package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.db.entity.MT_DsSoukinyouKouza;
import java.util.List;

/**
 * ＤＳ送金用口座テーブル(MT_DsSoukinyouKouzaDao) アクセス用の DAO クラスです。<br />
 */
public class MT_DsSoukinyouKouzaDao extends AbstractDao<MT_DsSoukinyouKouza> {

    public MT_DsSoukinyouKouzaDao() {
        super(MT_DsSoukinyouKouza.class);
    }

    @Deprecated
    public MT_DsSoukinyouKouza getDsSoukinyouKouza(String pDskokno, String pSyono, C_KouzasyuruiKbn pKzsyuruikbn) {
        MT_DsSoukinyouKouza mT_DsSoukinyouKouza =  new MT_DsSoukinyouKouza();
        mT_DsSoukinyouKouza.setDskokno(pDskokno);
        mT_DsSoukinyouKouza.setSyono(pSyono);
        mT_DsSoukinyouKouza.setKzsyuruikbn(pKzsyuruikbn);
        return this.selectOne(mT_DsSoukinyouKouza);
    }

    @Override
    @Deprecated
    public List<MT_DsSoukinyouKouza> selectAll() {
        return super.selectAll();
    }
}
