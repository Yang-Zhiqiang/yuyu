package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.MT_DsMailHaisinRireki;
import java.util.List;

/**
 * ＤＳメール配信履歴テーブル(MT_DsMailHaisinRirekiDao) アクセス用の DAO クラスです。<br />
 */
public class MT_DsMailHaisinRirekiDao extends AbstractDao<MT_DsMailHaisinRireki> {

    public MT_DsMailHaisinRirekiDao() {
        super(MT_DsMailHaisinRireki.class);
    }

    @Deprecated
    public MT_DsMailHaisinRireki getDsMailHaisinRireki(BizDate pDsdatasakuseiymd, String pDskokno, Integer pDsmailhaisinrenban) {
        MT_DsMailHaisinRireki mT_DsMailHaisinRireki =  new MT_DsMailHaisinRireki();
        mT_DsMailHaisinRireki.setDsdatasakuseiymd(pDsdatasakuseiymd);
        mT_DsMailHaisinRireki.setDskokno(pDskokno);
        mT_DsMailHaisinRireki.setDsmailhaisinrenban(pDsmailhaisinrenban);
        return this.selectOne(mT_DsMailHaisinRireki);
    }

    @Override
    @Deprecated
    public List<MT_DsMailHaisinRireki> selectAll() {
        return super.selectAll();
    }
}
