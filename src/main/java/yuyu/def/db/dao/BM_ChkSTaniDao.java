package yuyu.def.db.dao;
import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_ChkSTani;
import yuyu.def.db.meta.QBM_ChkSTani;

/**
 * Ｓ単位チェックマスタ(BM_ChkSTaniDao) アクセス用の DAO クラスです。<br />
 */
public class BM_ChkSTaniDao extends AbstractDao<BM_ChkSTani> {

    public BM_ChkSTaniDao() {
        super(BM_ChkSTani.class);
    }

    public BM_ChkSTani getChkSTani(String pSyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, BizNumber pHhknfromnen, BizNumber pHhkntonen, C_Tuukasyu pTuukasyu) {
        BM_ChkSTani bM_ChkSTani =  new BM_ChkSTani();
        bM_ChkSTani.setSyouhncd(pSyouhncd);
        bM_ChkSTani.setSyusyouhnsdnofrom(pSyusyouhnsdnofrom);
        bM_ChkSTani.setSyusyouhnsdnoto(pSyusyouhnsdnoto);
        bM_ChkSTani.setHhknfromnen(pHhknfromnen);
        bM_ChkSTani.setHhkntonen(pHhkntonen);
        bM_ChkSTani.setTuukasyu(pTuukasyu);
        return this.selectOne(bM_ChkSTani);
    }


    public List<BM_ChkSTani> getChkSTanisByPK(String pSyouhncd, Integer pSyouhnsdno, BizNumber pHhknnen, C_Tuukasyu pTuukasyu) {


        QBM_ChkSTani qBM_ChkSTani = new QBM_ChkSTani();


        String strSql = $SELECT + qBM_ChkSTani +
            $FROM + qBM_ChkSTani.BM_ChkSTani() +
            $WHERE + qBM_ChkSTani.syouhncd.eq(pSyouhncd) +
            $AND + qBM_ChkSTani.syusyouhnsdnofrom.le(pSyouhnsdno) +
            $AND + qBM_ChkSTani.syusyouhnsdnoto.ge(pSyouhnsdno) +
            $AND + qBM_ChkSTani.hhknfromnen.le(pHhknnen) +
            $AND + qBM_ChkSTani.hhkntonen.ge(pHhknnen) +
            $AND + qBM_ChkSTani.tuukasyu.eq(pTuukasyu);


        return em.createJPQL(strSql).bind(qBM_ChkSTani).getResultList();
    }
}
