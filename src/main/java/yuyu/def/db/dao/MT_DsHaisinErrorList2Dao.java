package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.MT_DsHaisinErrorList2;
import java.util.List;

/**
 * ＤＳ配信エラーリスト２テーブル(MT_DsHaisinErrorList2Dao) アクセス用の DAO クラスです。<br />
 */
public class MT_DsHaisinErrorList2Dao extends AbstractDao<MT_DsHaisinErrorList2> {

    public MT_DsHaisinErrorList2Dao() {
        super(MT_DsHaisinErrorList2.class);
    }

    @Deprecated
    public MT_DsHaisinErrorList2 getDsHaisinErrorList2(BizDate pDsdatasakuseiymd, Integer pDsmailhaisinrenban) {
        MT_DsHaisinErrorList2 mT_DsHaisinErrorList2 =  new MT_DsHaisinErrorList2();
        mT_DsHaisinErrorList2.setDsdatasakuseiymd(pDsdatasakuseiymd);
        mT_DsHaisinErrorList2.setDsmailhaisinrenban(pDsmailhaisinrenban);
        return this.selectOne(mT_DsHaisinErrorList2);
    }

    @Override
    @Deprecated
    public List<MT_DsHaisinErrorList2> selectAll() {
        return super.selectAll();
    }
}
