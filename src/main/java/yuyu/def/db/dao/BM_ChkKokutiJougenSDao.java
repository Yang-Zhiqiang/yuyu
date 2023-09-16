package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.BM_ChkKokutiJougenS;
import yuyu.def.db.meta.QBM_ChkKokutiJougenS;

/**
 * 告知上限Ｓチェックマスタ(BM_ChkKokutiJougenSDao) アクセス用の DAO クラスです。<br />
 */
public class BM_ChkKokutiJougenSDao extends AbstractDao<BM_ChkKokutiJougenS> {

    public BM_ChkKokutiJougenSDao() {
        super(BM_ChkKokutiJougenS.class);
    }

    public BM_ChkKokutiJougenS getChkKokutiJougenS(String pSyouhncd,
            Integer pSyusyouhnsdnofrom,
            Integer pSyusyouhnsdnoto,
            BizNumber pHhknfromnen,
            BizNumber pHhkntonen,
            Integer pMoskbnfrom,
            Integer pMoskbnto){
        BM_ChkKokutiJougenS bM_ChkKokutiJougenS =  new BM_ChkKokutiJougenS();
        bM_ChkKokutiJougenS.setSyouhncd(pSyouhncd);
        bM_ChkKokutiJougenS.setSyusyouhnsdnofrom(pSyusyouhnsdnofrom);
        bM_ChkKokutiJougenS.setSyusyouhnsdnoto(pSyusyouhnsdnoto);
        bM_ChkKokutiJougenS.setHhknfromnen(pHhknfromnen);
        bM_ChkKokutiJougenS.setHhkntonen(pHhkntonen);
        bM_ChkKokutiJougenS.setMoskbnfrom(pMoskbnfrom);
        bM_ChkKokutiJougenS.setMoskbnto(pMoskbnto);
        return this.selectOne(bM_ChkKokutiJougenS);
    }

    public List<BM_ChkKokutiJougenS> getChkKokutiJougenSsByPk(String pSyouhncd, Integer pSyouhnsdno,
            BizNumber pHhknnen, Integer pMoskbn) {


        QBM_ChkKokutiJougenS qBM_ChkKokutiJougenS = new QBM_ChkKokutiJougenS();


        String querySql = $SELECT + qBM_ChkKokutiJougenS +
                $FROM + qBM_ChkKokutiJougenS.BM_ChkKokutiJougenS() +
                $WHERE + qBM_ChkKokutiJougenS.syouhncd.eq(pSyouhncd) +
                $AND + qBM_ChkKokutiJougenS.syusyouhnsdnofrom.le(pSyouhnsdno) +
                $AND + qBM_ChkKokutiJougenS.syusyouhnsdnoto.ge(pSyouhnsdno) +
                $AND + qBM_ChkKokutiJougenS.hhknfromnen.le(pHhknnen) +
                $AND + qBM_ChkKokutiJougenS.hhkntonen.ge(pHhknnen) +
                $AND + qBM_ChkKokutiJougenS.moskbnfrom.le(pMoskbn) +
                $AND + qBM_ChkKokutiJougenS.moskbnto.ge(pMoskbn);


        return em.createJPQL(querySql).bind(qBM_ChkKokutiJougenS).getResultList();
    }
}
