package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_KijiKbn;
import yuyu.def.db.entity.BM_ChkKokutiTuusanS;
import yuyu.def.db.meta.QBM_ChkKokutiTuusanS;

/**
 * 告知扱通算限度Ｓチェックマスタ(BM_ChkKokutiTuusanSDao) アクセス用の DAO クラスです。<br />
 */
public class BM_ChkKokutiTuusanSDao extends AbstractDao<BM_ChkKokutiTuusanS> {

    public BM_ChkKokutiTuusanSDao() {
        super(BM_ChkKokutiTuusanS.class);
    }

    public BM_ChkKokutiTuusanS getChkKokutiTuusanS(BizNumber pHhknfromnen,
        BizNumber pHhkntonen,
        C_KijiKbn pKijikbn,
        Integer pIktkktkbnfrom,
        Integer pIktkktkbnto){
        BM_ChkKokutiTuusanS bM_ChkKokutiTuusanS =  new BM_ChkKokutiTuusanS();
        bM_ChkKokutiTuusanS.setHhknfromnen(pHhknfromnen);
        bM_ChkKokutiTuusanS.setHhkntonen(pHhkntonen);
        bM_ChkKokutiTuusanS.setKijikbn(pKijikbn);
        bM_ChkKokutiTuusanS.setIktkktkbnfrom(pIktkktkbnfrom);
        bM_ChkKokutiTuusanS.setIktkktkbnto(pIktkktkbnto);
        return this.selectOne(bM_ChkKokutiTuusanS);
    }

    public List<BM_ChkKokutiTuusanS> getChkKokutiTuusanSsByHhknnen(BizNumber pHhknnen) {


        QBM_ChkKokutiTuusanS qBM_ChkKokutiTuusanS = new QBM_ChkKokutiTuusanS();


        String strSql = $SELECT + qBM_ChkKokutiTuusanS +
            $FROM + qBM_ChkKokutiTuusanS.BM_ChkKokutiTuusanS() +
            $WHERE + qBM_ChkKokutiTuusanS.hhknfromnen.le(pHhknnen) +
            $AND + qBM_ChkKokutiTuusanS.hhkntonen.ge(pHhknnen);


        return em.createJPQL(strSql).bind(qBM_ChkKokutiTuusanS).getResultList();
    }
}
