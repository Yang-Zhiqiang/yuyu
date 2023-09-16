package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.MT_DsHenkouRireki;
import java.util.List;

/**
 * ＤＳ変更履歴テーブル(MT_DsHenkouRirekiDao) アクセス用の DAO クラスです。<br />
 */
public class MT_DsHenkouRirekiDao extends AbstractDao<MT_DsHenkouRireki> {

    public MT_DsHenkouRirekiDao() {
        super(MT_DsHenkouRireki.class);
    }

    @Deprecated
    public MT_DsHenkouRireki getDsHenkouRireki(String pDskokno, String pHenkousikibetukey, Integer pRenno) {
        MT_DsHenkouRireki mT_DsHenkouRireki =  new MT_DsHenkouRireki();
        mT_DsHenkouRireki.setDskokno(pDskokno);
        mT_DsHenkouRireki.setHenkousikibetukey(pHenkousikibetukey);
        mT_DsHenkouRireki.setRenno(pRenno);
        return this.selectOne(mT_DsHenkouRireki);
    }

    @Override
    @Deprecated
    public List<MT_DsHenkouRireki> selectAll() {
        return super.selectAll();
    }
}
