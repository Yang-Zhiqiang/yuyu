package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.BM_IkkatuTekiyouNo2;

/**
 * 一括払適用番号マスタ２(BM_IkkatuTekiyouNo2Dao) アクセス用の DAO クラスです。<br />
 */
public class BM_IkkatuTekiyouNo2Dao extends AbstractDao<BM_IkkatuTekiyouNo2> {

    public BM_IkkatuTekiyouNo2Dao() {
        super(BM_IkkatuTekiyouNo2.class);
    }

    public BM_IkkatuTekiyouNo2 getIkkatuTekiyouNo2(String pSyouhncd, String pRyouritusdno, BizNumber pYoteiriritu, String pIkttekiyoubr1, String pIkttekiyoubr2, String pIkttekiyoubr3) {
        BM_IkkatuTekiyouNo2 bM_IkkatuTekiyouNo2 =  new BM_IkkatuTekiyouNo2();
        bM_IkkatuTekiyouNo2.setSyouhncd(pSyouhncd);
        bM_IkkatuTekiyouNo2.setRyouritusdno(pRyouritusdno);
        bM_IkkatuTekiyouNo2.setYoteiriritu(pYoteiriritu);
        bM_IkkatuTekiyouNo2.setIkttekiyoubr1(pIkttekiyoubr1);
        bM_IkkatuTekiyouNo2.setIkttekiyoubr2(pIkttekiyoubr2);
        bM_IkkatuTekiyouNo2.setIkttekiyoubr3(pIkttekiyoubr3);
        return this.selectOne(bM_IkkatuTekiyouNo2);
    }
}
