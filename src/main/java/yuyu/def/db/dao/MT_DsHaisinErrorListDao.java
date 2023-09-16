package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.MT_DsHaisinErrorList;
import java.util.List;

/**
 * ＤＳ配信エラーリストテーブル(MT_DsHaisinErrorListDao) アクセス用の DAO クラスです。<br />
 */
public class MT_DsHaisinErrorListDao extends AbstractDao<MT_DsHaisinErrorList> {

    public MT_DsHaisinErrorListDao() {
        super(MT_DsHaisinErrorList.class);
    }

    @Deprecated
    public MT_DsHaisinErrorList getDsHaisinErrorList(BizDate pDsdatasakuseiymd, String pDskokno, Integer pDsmailaddressrenban) {
        MT_DsHaisinErrorList mT_DsHaisinErrorList =  new MT_DsHaisinErrorList();
        mT_DsHaisinErrorList.setDsdatasakuseiymd(pDsdatasakuseiymd);
        mT_DsHaisinErrorList.setDskokno(pDskokno);
        mT_DsHaisinErrorList.setDsmailaddressrenban(pDsmailaddressrenban);
        return this.selectOne(mT_DsHaisinErrorList);
    }

    @Override
    @Deprecated
    public List<MT_DsHaisinErrorList> selectAll() {
        return super.selectAll();
    }
}
