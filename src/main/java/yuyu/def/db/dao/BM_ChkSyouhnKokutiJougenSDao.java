package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.BM_ChkSyouhnKokutiJougenS;
import yuyu.def.db.meta.QBM_ChkSyouhnKokutiJougenS;

/**
 * 商品単位告知上限Ｓチェックマスタ(BM_ChkSyouhnKokutiJougenSDao) アクセス用の DAO クラスです。<br />
 */
public class BM_ChkSyouhnKokutiJougenSDao extends AbstractDao<BM_ChkSyouhnKokutiJougenS> {

    public BM_ChkSyouhnKokutiJougenSDao() {
        super(BM_ChkSyouhnKokutiJougenS.class);
    }

    public BM_ChkSyouhnKokutiJougenS getChkSyouhnKokutiJougenS(String pSyouhncd,
            Integer pSyusyouhnsdnofrom,
            Integer pSyusyouhnsdnoto,
            BizNumber pHhknfromnen,
            BizNumber pHhkntonen,
            Integer pMoskbnfrom,
            Integer pMoskbnto){
        BM_ChkSyouhnKokutiJougenS bM_ChkSyouhnKokutiJougenS =  new BM_ChkSyouhnKokutiJougenS();
        bM_ChkSyouhnKokutiJougenS.setSyouhncd(pSyouhncd);
        bM_ChkSyouhnKokutiJougenS.setSyusyouhnsdnofrom(pSyusyouhnsdnofrom);
        bM_ChkSyouhnKokutiJougenS.setSyusyouhnsdnoto(pSyusyouhnsdnoto);
        bM_ChkSyouhnKokutiJougenS.setHhknfromnen(pHhknfromnen);
        bM_ChkSyouhnKokutiJougenS.setHhkntonen(pHhkntonen);
        bM_ChkSyouhnKokutiJougenS.setMoskbnfrom(pMoskbnfrom);
        bM_ChkSyouhnKokutiJougenS.setMoskbnto(pMoskbnto);
        return this.selectOne(bM_ChkSyouhnKokutiJougenS);
    }

    public List<BM_ChkSyouhnKokutiJougenS> getChkSyouhnKokutiJougenSsByPk(String pSyouhncd, Integer pSyouhnsdno,
            BizNumber pHhknnen, Integer pMoskbn) {


        QBM_ChkSyouhnKokutiJougenS qBM_ChkSyouhnKokutiJougenS = new QBM_ChkSyouhnKokutiJougenS();


        String querySql = $SELECT + qBM_ChkSyouhnKokutiJougenS +
                $FROM + qBM_ChkSyouhnKokutiJougenS.BM_ChkSyouhnKokutiJougenS() +
                $WHERE + qBM_ChkSyouhnKokutiJougenS.syouhncd.eq(pSyouhncd) +
                $AND + qBM_ChkSyouhnKokutiJougenS.syusyouhnsdnofrom.le(pSyouhnsdno) +
                $AND + qBM_ChkSyouhnKokutiJougenS.syusyouhnsdnoto.ge(pSyouhnsdno) +
                $AND + qBM_ChkSyouhnKokutiJougenS.hhknfromnen.le(pHhknnen) +
                $AND + qBM_ChkSyouhnKokutiJougenS.hhkntonen.ge(pHhknnen) +
                $AND + qBM_ChkSyouhnKokutiJougenS.moskbnfrom.le(pMoskbn) +
                $AND + qBM_ChkSyouhnKokutiJougenS.moskbnto.ge(pMoskbn);


        return em.createJPQL(querySql).bind(qBM_ChkSyouhnKokutiJougenS).getResultList();
    }
}
