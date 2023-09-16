package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.BM_ChkKeiyakuTaniSaikouS;
import yuyu.def.db.meta.QBM_ChkKeiyakuTaniSaikouS;

/**
 * 契約単位最高Ｓチェックマスタ(BM_ChkKeiyakuTaniSaikouSDao) アクセス用の DAO クラスです。<br />
 */
public class BM_ChkKeiyakuTaniSaikouSDao extends AbstractDao<BM_ChkKeiyakuTaniSaikouS> {

    public BM_ChkKeiyakuTaniSaikouSDao() {
        super(BM_ChkKeiyakuTaniSaikouS.class);
    }

    public BM_ChkKeiyakuTaniSaikouS getChkKeiyakuTaniSaikouS(String pSyouhncd,
            Integer pSyusyouhnsdnofrom,
            Integer pSyusyouhnsdnoto){
        BM_ChkKeiyakuTaniSaikouS bM_ChkKeiyakuTaniSaikouS =  new BM_ChkKeiyakuTaniSaikouS();
        bM_ChkKeiyakuTaniSaikouS.setSyouhncd(pSyouhncd);
        bM_ChkKeiyakuTaniSaikouS.setSyusyouhnsdnofrom(pSyusyouhnsdnofrom);
        bM_ChkKeiyakuTaniSaikouS.setSyusyouhnsdnoto(pSyusyouhnsdnoto);
        return this.selectOne(bM_ChkKeiyakuTaniSaikouS);
    }

    public List<BM_ChkKeiyakuTaniSaikouS> getChkKeiyakuTaniSaikouSsByPk(String pSyouhncd, Integer pSyouhnsdno) {


        QBM_ChkKeiyakuTaniSaikouS qBM_ChkKeiyakuTaniSaikouS = new QBM_ChkKeiyakuTaniSaikouS();


        String querySql = $SELECT + qBM_ChkKeiyakuTaniSaikouS +
                $FROM + qBM_ChkKeiyakuTaniSaikouS.BM_ChkKeiyakuTaniSaikouS() +
                $WHERE + qBM_ChkKeiyakuTaniSaikouS.syouhncd.eq(pSyouhncd) +
                $AND + qBM_ChkKeiyakuTaniSaikouS.syusyouhnsdnofrom.le(pSyouhnsdno) +
                $AND + qBM_ChkKeiyakuTaniSaikouS.syusyouhnsdnoto.ge(pSyouhnsdno);


        return em.createJPQL(querySql).bind(qBM_ChkKeiyakuTaniSaikouS).getResultList();
    }
}
