package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_Tkjyskgnkkn;
import yuyu.def.db.entity.BM_TokujyouSakugenRate;

/**
 * 特条削減率マスタ(BM_TokujyouSakugenRateDao) アクセス用の DAO クラスです。<br />
 */
public class BM_TokujyouSakugenRateDao extends AbstractDao<BM_TokujyouSakugenRate> {

    public BM_TokujyouSakugenRateDao() {
        super(BM_TokujyouSakugenRate.class);
    }

    public BM_TokujyouSakugenRate getTokujyouSakugenRate(String pSyouhncd,
        Integer pSyouhnsdno,
        C_Tkjyskgnkkn pTkjyskgnkkn){
        BM_TokujyouSakugenRate bM_TokujyouSakugenRate =  new BM_TokujyouSakugenRate();
        bM_TokujyouSakugenRate.setSyouhncd(pSyouhncd);
        bM_TokujyouSakugenRate.setSyouhnsdno(pSyouhnsdno);
        bM_TokujyouSakugenRate.setTkjyskgnkkn(pTkjyskgnkkn);
        return this.selectOne(bM_TokujyouSakugenRate);
    }

    @Override
    public List<BM_TokujyouSakugenRate> selectAll() {
        return super.selectAll();
    }
}
