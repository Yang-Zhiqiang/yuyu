package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_ChkJhSaikouSSTani;
import yuyu.def.db.meta.QBM_ChkJhSaikouSSTani;

/**
 * 最高ＳＳ単位事方書チェックマスタ(BM_ChkJhSaikouSSTaniDao) アクセス用の DAO クラスです。<br />
 */
public class BM_ChkJhSaikouSSTaniDao extends AbstractDao<BM_ChkJhSaikouSSTani> {

    public BM_ChkJhSaikouSSTaniDao() {
        super(BM_ChkJhSaikouSSTani.class);
    }

    public BM_ChkJhSaikouSSTani getChkJhSaikouSSTani(String pSyouhncd, Integer pSyusyouhnsdnofrom, Integer pSyusyouhnsdnoto, BizNumber pHhknfromnen, BizNumber pHhkntonen, Integer pMoskbnfrom, Integer pMoskbnto, C_Tuukasyu pTuukasyu) {
        BM_ChkJhSaikouSSTani bM_ChkJhSaikouSSTani =  new BM_ChkJhSaikouSSTani();
        bM_ChkJhSaikouSSTani.setSyouhncd(pSyouhncd);
        bM_ChkJhSaikouSSTani.setSyusyouhnsdnofrom(pSyusyouhnsdnofrom);
        bM_ChkJhSaikouSSTani.setSyusyouhnsdnoto(pSyusyouhnsdnoto);
        bM_ChkJhSaikouSSTani.setHhknfromnen(pHhknfromnen);
        bM_ChkJhSaikouSSTani.setHhkntonen(pHhkntonen);
        bM_ChkJhSaikouSSTani.setMoskbnfrom(pMoskbnfrom);
        bM_ChkJhSaikouSSTani.setMoskbnto(pMoskbnto);
        bM_ChkJhSaikouSSTani.setTuukasyu(pTuukasyu);
        return this.selectOne(bM_ChkJhSaikouSSTani);
    }

    public List<BM_ChkJhSaikouSSTani> getChkJhSaikouSSTanisByPk(String pSyouhncd, Integer pSyouhnsdno,
            BizNumber pHhknnen, Integer pMoskbn, C_Tuukasyu pTuukasyu) {


        QBM_ChkJhSaikouSSTani qBM_ChkJhSaikouSSTani = new QBM_ChkJhSaikouSSTani();


        String strSql = $SELECT + qBM_ChkJhSaikouSSTani +
                $FROM + qBM_ChkJhSaikouSSTani.BM_ChkJhSaikouSSTani() +
                $WHERE + qBM_ChkJhSaikouSSTani.syouhncd.eq(pSyouhncd) +
                $AND + qBM_ChkJhSaikouSSTani.syusyouhnsdnofrom.le(pSyouhnsdno) +
                $AND + qBM_ChkJhSaikouSSTani.syusyouhnsdnoto.ge(pSyouhnsdno) +
                $AND + qBM_ChkJhSaikouSSTani.hhknfromnen.le(pHhknnen) +
                $AND + qBM_ChkJhSaikouSSTani.hhkntonen.ge(pHhknnen) +
                $AND + qBM_ChkJhSaikouSSTani.moskbnfrom.le(pMoskbn) +
                $AND + qBM_ChkJhSaikouSSTani.moskbnto.ge(pMoskbn) +
                $AND + qBM_ChkJhSaikouSSTani.tuukasyu.eq(pTuukasyu);


        return em.createJPQL(strSql).bind(qBM_ChkJhSaikouSSTani).getResultList();
    }
}
