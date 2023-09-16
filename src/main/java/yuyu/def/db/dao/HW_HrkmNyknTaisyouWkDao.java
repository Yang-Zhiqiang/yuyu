package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.HW_HrkmNyknTaisyouWk;
import yuyu.def.db.meta.QHW_HrkmNyknTaisyouWk;

/**
 * 振込入金対象ワークテーブル(HW_HrkmNyknTaisyouWkDao) アクセス用の DAO クラスです。<br />
 */
public class HW_HrkmNyknTaisyouWkDao extends AbstractDao<HW_HrkmNyknTaisyouWk> {

    public HW_HrkmNyknTaisyouWkDao() {
        super(HW_HrkmNyknTaisyouWk.class);
    }

    public HW_HrkmNyknTaisyouWk getHrkmNyknTaisyouWk(BizDate pSyoriYmd,
        String pMosno,
        Integer pRenno){
        HW_HrkmNyknTaisyouWk hW_HrkmNyknTaisyouWk =  new HW_HrkmNyknTaisyouWk();
        hW_HrkmNyknTaisyouWk.setSyoriYmd(pSyoriYmd);
        hW_HrkmNyknTaisyouWk.setMosno(pMosno);
        hW_HrkmNyknTaisyouWk.setRenno(pRenno);
        return this.selectOne(hW_HrkmNyknTaisyouWk);
    }

    public ExDBResults<HW_HrkmNyknTaisyouWk>  getHrkmNyknTaisyouWksByKakutyoujobcdSyoriYmd(BizDate pSyoriYmd) {


        QHW_HrkmNyknTaisyouWk qHW_HrkmNyknTaisyouWk = new QHW_HrkmNyknTaisyouWk();


        String strSql = $SELECT + qHW_HrkmNyknTaisyouWk +
            $FROM + qHW_HrkmNyknTaisyouWk.HW_HrkmNyknTaisyouWk() +
            $WHERE + qHW_HrkmNyknTaisyouWk.syoriYmd.eq(pSyoriYmd) +
            $ORDER_BY(qHW_HrkmNyknTaisyouWk.mosno.asc());


        return em.createJPQL(strSql).bind(qHW_HrkmNyknTaisyouWk).getResults();
    }
}
