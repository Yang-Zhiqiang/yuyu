package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_PmnjtkKbn;
import yuyu.def.db.entity.BM_ChkTkykSyuNenreiHani;
import yuyu.def.db.meta.QBM_ChkTkykSyuNenreiHani;

/**
 * 特約種類年齢範囲チェックマスタ(BM_ChkTkykSyuNenreiHaniDao) アクセス用の DAO クラスです。<br />
 */
public class BM_ChkTkykSyuNenreiHaniDao extends AbstractDao<BM_ChkTkykSyuNenreiHani> {

    public BM_ChkTkykSyuNenreiHaniDao() {
        super(BM_ChkTkykSyuNenreiHani.class);
    }

    public BM_ChkTkykSyuNenreiHani getChkTkykSyuNenreiHani(C_PmnjtkKbn pPmnjtkkbn){
        BM_ChkTkykSyuNenreiHani bM_ChkTkykSyuNenreiHani =  new BM_ChkTkykSyuNenreiHani();
        bM_ChkTkykSyuNenreiHani.setPmnjtkkbn(pPmnjtkkbn);
        return this.selectOne(bM_ChkTkykSyuNenreiHani);
    }

    public Long getChkTkykSyuNenreiHaniCountByPmnjtkkbnHhknnen(C_PmnjtkKbn pPmnjtkkbn, Integer pHhknnen) {
        QBM_ChkTkykSyuNenreiHani chkTkykSyuNenreiHani = new QBM_ChkTkykSyuNenreiHani();

        String quertSql = $SELECT + $COUNT + "(*)" +
            $FROM + chkTkykSyuNenreiHani.BM_ChkTkykSyuNenreiHani() +
            $WHERE + chkTkykSyuNenreiHani.pmnjtkkbn.eq(pPmnjtkkbn) +
            $AND + chkTkykSyuNenreiHani.hhknfromnen.le(BizNumber.valueOf(pHhknnen)) +
            $AND + chkTkykSyuNenreiHani.hhkntonen.ge(BizNumber.valueOf(pHhknnen));

        return em.createJPQL(quertSql).bind(chkTkykSyuNenreiHani).getSingleResult();
    }
}
