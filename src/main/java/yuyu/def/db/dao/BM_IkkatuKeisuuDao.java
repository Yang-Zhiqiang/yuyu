package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BM_IkkatuKeisuu;

/**
 * 一括払係数マスタ(BM_IkkatuKeisuuDao) アクセス用の DAO クラスです。<br />
 */
public class BM_IkkatuKeisuuDao extends AbstractDao<BM_IkkatuKeisuu> {

    public BM_IkkatuKeisuuDao() {
        super(BM_IkkatuKeisuu.class);
    }

    public BM_IkkatuKeisuu getIkkatuKeisuu(Integer pIkttekiyouno, Integer pNen1nen2baraihyouji, Integer pKeikatukisuu) {
        BM_IkkatuKeisuu bM_IkkatuKeisuu =  new BM_IkkatuKeisuu();
        bM_IkkatuKeisuu.setIkttekiyouno(pIkttekiyouno);
        bM_IkkatuKeisuu.setNen1nen2baraihyouji(pNen1nen2baraihyouji);
        bM_IkkatuKeisuu.setKeikatukisuu(pKeikatukisuu);
        return this.selectOne(bM_IkkatuKeisuu);
    }

}
