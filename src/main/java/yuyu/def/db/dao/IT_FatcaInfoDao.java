package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_FatcakekKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.db.entity.IT_FatcaInfo;
import yuyu.def.db.meta.QIT_FatcaInfo;

/**
 * ＦＡＴＣＡ情報テーブル(IT_FatcaInfoDao) アクセス用の DAO クラスです。<br />
 */
public class IT_FatcaInfoDao extends AbstractDao<IT_FatcaInfo> {

    public IT_FatcaInfoDao() {
        super(IT_FatcaInfo.class);
    }

    @Deprecated
    public IT_FatcaInfo getFatcaInfo(String pSyono,
        Integer pRenno){
        IT_FatcaInfo iT_FatcaInfo =  new IT_FatcaInfo();
        iT_FatcaInfo.setSyono(pSyono);
        iT_FatcaInfo.setRenno(pRenno);
        return this.selectOne(iT_FatcaInfo);
    }

    @Override
    @Deprecated
    public List<IT_FatcaInfo> selectAll() {
        return super.selectAll();
    }

    public List<IT_FatcaInfo> getFatcaInfosByFatcakekkbnSeionnmkSseiymdSeibetu(C_FatcakekKbn pFatcakekkbn,
        String pSeionnmkn, BizDate pSeiymd, C_Seibetu pSeibetu) {


        QIT_FatcaInfo qIT_FatcaInfo = new QIT_FatcaInfo();


        String subquery1 = "";


        if (pSeiymd != null) {

            subquery1 = subquery1 + $AND + qIT_FatcaInfo.seiymd.eq(pSeiymd);
        }


        if (pSeibetu != null && !C_Seibetu.BLNK.eq(pSeibetu)) {

            subquery1 = subquery1 + $AND + $(qIT_FatcaInfo.seibetu.eq(pSeibetu) + $OR +  qIT_FatcaInfo.seibetu.eq(C_Seibetu.HUMEI));
        }

        String queryStr = $SELECT + qIT_FatcaInfo +
            $FROM + qIT_FatcaInfo.IT_FatcaInfo() +
            $WHERE + qIT_FatcaInfo.fatcakekkbn.ne(pFatcakekkbn) +
            $AND + qIT_FatcaInfo.seionnmkn.eq(pSeionnmkn) +
            subquery1 +
            $ORDER_BY(qIT_FatcaInfo.syono.asc());

        return em.createJPQL(queryStr).bind(qIT_FatcaInfo).getResultList();
    }
}
