package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.db.entity.IT_HrkmNyknDataHzn;

/**
 * 振込入金データ（保全用）テーブル(IT_HrkmNyknDataHznDao) アクセス用の DAO クラスです。<br />
 */
public class IT_HrkmNyknDataHznDao extends AbstractDao<IT_HrkmNyknDataHzn> {

    public IT_HrkmNyknDataHznDao() {
        super(IT_HrkmNyknDataHzn.class);
    }

    public IT_HrkmNyknDataHzn getHrkmNyknDataHzn(C_DensysKbn pDensyskbn, BizDate pSyoriYmd, String pItirenno) {
        IT_HrkmNyknDataHzn iT_HrkmNyknDataHzn =  new IT_HrkmNyknDataHzn();
        iT_HrkmNyknDataHzn.setDensyskbn(pDensyskbn);
        iT_HrkmNyknDataHzn.setSyoriYmd(pSyoriYmd);
        iT_HrkmNyknDataHzn.setItirenno(pItirenno);
        return this.selectOne(iT_HrkmNyknDataHzn);
    }

}
