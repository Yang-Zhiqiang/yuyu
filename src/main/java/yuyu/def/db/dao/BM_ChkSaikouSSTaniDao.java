package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_ChkSaikouSSTani;
import yuyu.def.db.meta.QBM_ChkSaikouSSTani;

/**
 * 最高ＳＳ単位チェックマスタ(BM_ChkSaikouSSTaniDao) アクセス用の DAO クラスです。<br />
 */
public class BM_ChkSaikouSSTaniDao extends AbstractDao<BM_ChkSaikouSSTani> {

    public BM_ChkSaikouSSTaniDao() {
        super(BM_ChkSaikouSSTani.class);
    }

    public BM_ChkSaikouSSTani getChkSaikouSSTani(String pSyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, BizNumber pHhknfromnen, BizNumber pHhkntonen, Integer pMoskbnfrom, Integer pMoskbnto, C_Tuukasyu pTuukasyu) {
        BM_ChkSaikouSSTani bM_ChkSaikouSSTani =  new BM_ChkSaikouSSTani();
        bM_ChkSaikouSSTani.setSyouhncd(pSyouhncd);
        bM_ChkSaikouSSTani.setSyusyouhnsdnofrom(pSyusyouhnsdnofrom);
        bM_ChkSaikouSSTani.setSyusyouhnsdnoto(pSyusyouhnsdnoto);
        bM_ChkSaikouSSTani.setHhknfromnen(pHhknfromnen);
        bM_ChkSaikouSSTani.setHhkntonen(pHhkntonen);
        bM_ChkSaikouSSTani.setMoskbnfrom(pMoskbnfrom);
        bM_ChkSaikouSSTani.setMoskbnto(pMoskbnto);
        bM_ChkSaikouSSTani.setTuukasyu(pTuukasyu);
        return this.selectOne(bM_ChkSaikouSSTani);
    }

    public List<BM_ChkSaikouSSTani> getChkSaikouSSTanisByPk(String pSyouhncd, Integer pSyouhnsdno, BizNumber pHhknnen,
            Integer pMoskbn, C_Tuukasyu pTuukasyu) {


        QBM_ChkSaikouSSTani qBM_ChkSaikouSSTani = new QBM_ChkSaikouSSTani();


        String strSql = $SELECT + qBM_ChkSaikouSSTani +
                $FROM + qBM_ChkSaikouSSTani.BM_ChkSaikouSSTani() +
                $WHERE + qBM_ChkSaikouSSTani.syouhncd.eq(pSyouhncd) +
                $AND + qBM_ChkSaikouSSTani.syusyouhnsdnofrom.le(pSyouhnsdno) +
                $AND + qBM_ChkSaikouSSTani.syusyouhnsdnoto.ge(pSyouhnsdno) +
                $AND + qBM_ChkSaikouSSTani.hhknfromnen.le(pHhknnen) +
                $AND + qBM_ChkSaikouSSTani.hhkntonen.ge(pHhknnen) +
                $AND + qBM_ChkSaikouSSTani.moskbnfrom.le(pMoskbn) +
                $AND + qBM_ChkSaikouSSTani.moskbnto.ge(pMoskbn) +
                $AND + qBM_ChkSaikouSSTani.tuukasyu.eq(pTuukasyu);


        return em.createJPQL(strSql).bind(qBM_ChkSaikouSSTani).getResultList();
    }
}
