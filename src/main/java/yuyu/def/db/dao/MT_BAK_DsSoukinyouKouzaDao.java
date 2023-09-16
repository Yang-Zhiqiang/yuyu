package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.db.entity.MT_BAK_DsSoukinyouKouza;
import java.util.List;

/**
 * ＤＳ送金用口座バックアップテーブル(MT_BAK_DsSoukinyouKouzaDao) アクセス用の DAO クラスです。<br />
 */
public class MT_BAK_DsSoukinyouKouzaDao extends AbstractDao<MT_BAK_DsSoukinyouKouza> {

    public MT_BAK_DsSoukinyouKouzaDao() {
        super(MT_BAK_DsSoukinyouKouza.class);
    }

    @Deprecated
    public MT_BAK_DsSoukinyouKouza getBAKDsSoukinyouKouza(String pDskokno, String pSyono, C_KouzasyuruiKbn pKzsyuruikbn, String pTrkssikibetukey) {
        MT_BAK_DsSoukinyouKouza mT_BAK_DsSoukinyouKouza =  new MT_BAK_DsSoukinyouKouza();
        mT_BAK_DsSoukinyouKouza.setDskokno(pDskokno);
        mT_BAK_DsSoukinyouKouza.setSyono(pSyono);
        mT_BAK_DsSoukinyouKouza.setKzsyuruikbn(pKzsyuruikbn);
        mT_BAK_DsSoukinyouKouza.setTrkssikibetukey(pTrkssikibetukey);
        return this.selectOne(mT_BAK_DsSoukinyouKouza);
    }

    @Override
    @Deprecated
    public List<MT_BAK_DsSoukinyouKouza> selectAll() {
        return super.selectAll();
    }
}
