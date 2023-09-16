package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.BM_ChkTkykHukaSeigen;
import yuyu.def.db.meta.QBM_ChkTkykHukaSeigen;

/**
 * 特約付加制限チェックマスタ(BM_ChkTkykHukaSeigenDao) アクセス用の DAO クラスです。<br />
 */
public class BM_ChkTkykHukaSeigenDao extends AbstractDao<BM_ChkTkykHukaSeigen> {

    public BM_ChkTkykHukaSeigenDao() {
        super(BM_ChkTkykHukaSeigen.class);
    }

    public BM_ChkTkykHukaSeigen getChkTkykHukaSeigen(String pSyusyouhncd,
            Integer pSyusyouhnsdnofrom,
            Integer pSyusyouhnsdnoto,
            Integer pSntkhoukbnfrom,
            Integer pSntkhoukbnto,
            BizNumber pHhknfromnen,
            BizNumber pHhkntonen,
            String pTksyouhncd){
        BM_ChkTkykHukaSeigen bM_ChkTkykHukaSeigen =  new BM_ChkTkykHukaSeigen();
        bM_ChkTkykHukaSeigen.setSyusyouhncd(pSyusyouhncd);
        bM_ChkTkykHukaSeigen.setSyusyouhnsdnofrom(pSyusyouhnsdnofrom);
        bM_ChkTkykHukaSeigen.setSyusyouhnsdnoto(pSyusyouhnsdnoto);
        bM_ChkTkykHukaSeigen.setSntkhoukbnfrom(pSntkhoukbnfrom);
        bM_ChkTkykHukaSeigen.setSntkhoukbnto(pSntkhoukbnto);
        bM_ChkTkykHukaSeigen.setHhknfromnen(pHhknfromnen);
        bM_ChkTkykHukaSeigen.setHhkntonen(pHhkntonen);
        bM_ChkTkykHukaSeigen.setTksyouhncd(pTksyouhncd);
        return this.selectOne(bM_ChkTkykHukaSeigen);
    }

    public List<BM_ChkTkykHukaSeigen> getChkTkykHukaSeigensByPk(String pSyusyouhncd, Integer pSyouhnsdno,
            Integer pSntkhoukbn, BizNumber pHhknnen, String pTksyouhncd) {


        QBM_ChkTkykHukaSeigen qBM_ChkTkykHukaSeigen = new QBM_ChkTkykHukaSeigen();


        String strSql = $SELECT + qBM_ChkTkykHukaSeigen +
                $FROM + qBM_ChkTkykHukaSeigen.BM_ChkTkykHukaSeigen() +
                $WHERE + qBM_ChkTkykHukaSeigen.syusyouhncd.eq(pSyusyouhncd) +
                $AND + qBM_ChkTkykHukaSeigen.syusyouhnsdnofrom.le(pSyouhnsdno) +
                $AND + qBM_ChkTkykHukaSeigen.syusyouhnsdnoto.ge(pSyouhnsdno) +
                $AND + qBM_ChkTkykHukaSeigen.sntkhoukbnfrom.le(pSntkhoukbn) +
                $AND + qBM_ChkTkykHukaSeigen.sntkhoukbnto.ge(pSntkhoukbn) +
                $AND + qBM_ChkTkykHukaSeigen.hhknfromnen.le(pHhknnen) +
                $AND + qBM_ChkTkykHukaSeigen.hhkntonen.ge(pHhknnen) +
                $AND + qBM_ChkTkykHukaSeigen.tksyouhncd.eq(pTksyouhncd);


        return em.createJPQL(strSql).bind(qBM_ChkTkykHukaSeigen).getResultList();
    }
}
