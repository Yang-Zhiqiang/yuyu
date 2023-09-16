package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.MT_DsTtdkRireki;
import java.util.List;

/**
 * ＤＳ手続履歴テーブル(MT_DsTtdkRirekiDao) アクセス用の DAO クラスです。<br />
 */
public class MT_DsTtdkRirekiDao extends AbstractDao<MT_DsTtdkRireki> {

    public MT_DsTtdkRirekiDao() {
        super(MT_DsTtdkRireki.class);
    }

    @Deprecated
    public MT_DsTtdkRireki getDsTtdkRireki(String pDskokno, String pHenkousikibetukey) {
        MT_DsTtdkRireki mT_DsTtdkRireki =  new MT_DsTtdkRireki();
        mT_DsTtdkRireki.setDskokno(pDskokno);
        mT_DsTtdkRireki.setHenkousikibetukey(pHenkousikibetukey);
        return this.selectOne(mT_DsTtdkRireki);
    }

    @Override
    @Deprecated
    public List<MT_DsTtdkRireki> selectAll() {
        return super.selectAll();
    }
}
