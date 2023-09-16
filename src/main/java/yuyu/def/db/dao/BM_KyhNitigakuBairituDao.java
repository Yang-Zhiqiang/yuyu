package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_KataKbn;
import yuyu.def.db.entity.BM_KyhNitigakuBairitu;

/**
 * 給付日額倍率マスタ(BM_KyhNitigakuBairituDao) アクセス用の DAO クラスです。<br />
 */
public class BM_KyhNitigakuBairituDao extends AbstractDao<BM_KyhNitigakuBairitu> {

    public BM_KyhNitigakuBairituDao() {
        super(BM_KyhNitigakuBairitu.class);
    }

    public BM_KyhNitigakuBairitu getKyhNitigakuBairitu(String pSyouhncd,
        Integer pSyouhnsdno,
        C_KataKbn pKatakbn){
        BM_KyhNitigakuBairitu bM_KyhNitigakuBairitu =  new BM_KyhNitigakuBairitu();
        bM_KyhNitigakuBairitu.setSyouhncd(pSyouhncd);
        bM_KyhNitigakuBairitu.setSyouhnsdno(pSyouhnsdno);
        bM_KyhNitigakuBairitu.setKatakbn(pKatakbn);
        return this.selectOne(bM_KyhNitigakuBairitu);
    }

    @Override
    public List<BM_KyhNitigakuBairitu> selectAll() {
        return super.selectAll();
    }
}
