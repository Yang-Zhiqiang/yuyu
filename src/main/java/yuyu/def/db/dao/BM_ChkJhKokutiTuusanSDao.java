package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_KijiKbn;
import yuyu.def.db.entity.BM_ChkJhKokutiTuusanS;
import yuyu.def.db.meta.QBM_ChkJhKokutiTuusanS;

/**
 * 告知扱通算限度Ｓ事方書チェックマスタ(BM_ChkJhKokutiTuusanSDao) アクセス用の DAO クラスです。<br />
 */
public class BM_ChkJhKokutiTuusanSDao extends AbstractDao<BM_ChkJhKokutiTuusanS> {

    public BM_ChkJhKokutiTuusanSDao() {
        super(BM_ChkJhKokutiTuusanS.class);
    }

    public BM_ChkJhKokutiTuusanS getChkJhKokutiTuusanS(BizNumber pHhknfromnen,
        BizNumber pHhkntonen,
        C_KijiKbn pKijikbn,
        Integer pIktkktkbnfrom,
        Integer pIktkktkbnto){
        BM_ChkJhKokutiTuusanS bM_ChkJhKokutiTuusanS =  new BM_ChkJhKokutiTuusanS();
        bM_ChkJhKokutiTuusanS.setHhknfromnen(pHhknfromnen);
        bM_ChkJhKokutiTuusanS.setHhkntonen(pHhkntonen);
        bM_ChkJhKokutiTuusanS.setKijikbn(pKijikbn);
        bM_ChkJhKokutiTuusanS.setIktkktkbnfrom(pIktkktkbnfrom);
        bM_ChkJhKokutiTuusanS.setIktkktkbnto(pIktkktkbnto);
        return this.selectOne(bM_ChkJhKokutiTuusanS);
    }

    public List<BM_ChkJhKokutiTuusanS> getChkJhKokutiTuusanSsByHhknnen(BizNumber pHhknnen) {


        QBM_ChkJhKokutiTuusanS qBM_ChkJhKokutiTuusanS = new QBM_ChkJhKokutiTuusanS();


        String strSql = $SELECT + qBM_ChkJhKokutiTuusanS +
            $FROM + qBM_ChkJhKokutiTuusanS.BM_ChkJhKokutiTuusanS() +
            $WHERE + qBM_ChkJhKokutiTuusanS.hhknfromnen.le(pHhknnen) +
            $AND + qBM_ChkJhKokutiTuusanS.hhkntonen.ge(pHhknnen);


        return em.createJPQL(strSql).bind(qBM_ChkJhKokutiTuusanS).getResultList();
    }
}
