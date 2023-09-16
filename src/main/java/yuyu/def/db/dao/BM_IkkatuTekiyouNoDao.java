package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BM_IkkatuTekiyouNo;

/**
 * 一括払適用番号マスタ(BM_IkkatuTekiyouNoDao) アクセス用の DAO クラスです。<br />
 */
public class BM_IkkatuTekiyouNoDao extends AbstractDao<BM_IkkatuTekiyouNo> {

    public BM_IkkatuTekiyouNoDao() {
        super(BM_IkkatuTekiyouNo.class);
    }

    public BM_IkkatuTekiyouNo getIkkatuTekiyouNo(String pSyouhncd, String pRyouritusdno) {
        BM_IkkatuTekiyouNo bM_IkkatuTekiyouNo =  new BM_IkkatuTekiyouNo();
        bM_IkkatuTekiyouNo.setSyouhncd(pSyouhncd);
        bM_IkkatuTekiyouNo.setRyouritusdno(pRyouritusdno);
        return this.selectOne(bM_IkkatuTekiyouNo);
    }

}
