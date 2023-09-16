package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.JM_TokusyuKyuHantei;

/**
 * 特定給付判定マスタ(JM_TokusyuKyuHanteiDao) アクセス用の DAO クラスです。<br />
 */
public class JM_TokusyuKyuHanteiDao extends AbstractDao<JM_TokusyuKyuHantei> {

    public JM_TokusyuKyuHanteiDao() {
        super(JM_TokusyuKyuHantei.class);
    }

    @Deprecated
    public JM_TokusyuKyuHantei getTokusyuKyuHantei(String pByoumeitourokuno,
         String pSyouhncd,
         Integer pSyouhnsdno,
         String pTekiyoukknfrom,
         String pTekiyoukknkto){
        JM_TokusyuKyuHantei jM_TokusyuKyuHantei =  new JM_TokusyuKyuHantei();
        jM_TokusyuKyuHantei.setByoumeitourokuno(pByoumeitourokuno);
        jM_TokusyuKyuHantei.setSyouhncd(pSyouhncd);
        jM_TokusyuKyuHantei.setSyouhnsdno(pSyouhnsdno);
        jM_TokusyuKyuHantei.setTekiyoukknfrom(pTekiyoukknfrom);
        jM_TokusyuKyuHantei.setTekiyoukknkto(pTekiyoukknkto);
        return this.selectOne(jM_TokusyuKyuHantei);
    }

    @Override
    @Deprecated
    public List<JM_TokusyuKyuHantei> selectAll() {
        return super.selectAll();
    }
}
