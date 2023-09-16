package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_MosnoSaibanKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.db.entity.HT_GaibuQrYoyaku2;
import yuyu.def.db.meta.QHT_GaibuQrYoyaku2;

/**
 * 外部用ＱＲ予約テーブル２(HT_GaibuQrYoyaku2Dao) アクセス用の DAO クラスです。<br />
 */
public class HT_GaibuQrYoyaku2Dao extends AbstractDao<HT_GaibuQrYoyaku2> {

    public HT_GaibuQrYoyaku2Dao() {
        super(HT_GaibuQrYoyaku2.class);
    }

    public HT_GaibuQrYoyaku2 getGaibuQrYoyaku2(BizDate pSyoriYmd, C_SkeijimuKbn pSkeijimukbn, C_HknsyuruiNo pHknsyuruino, C_MosnoSaibanKbn pMosnosaibankbn) {
        HT_GaibuQrYoyaku2 hT_GaibuQrYoyaku2 =  new HT_GaibuQrYoyaku2();
        hT_GaibuQrYoyaku2.setSyoriYmd(pSyoriYmd);
        hT_GaibuQrYoyaku2.setSkeijimukbn(pSkeijimukbn);
        hT_GaibuQrYoyaku2.setHknsyuruino(pHknsyuruino);
        hT_GaibuQrYoyaku2.setMosnosaibankbn(pMosnosaibankbn);
        return this.selectOne(hT_GaibuQrYoyaku2);
    }

    public List<HT_GaibuQrYoyaku2> getGaibuQrYoyaku2sByQrsakuseiymd(BizDate pQrsakuseiymd) {


        QHT_GaibuQrYoyaku2 qHT_GaibuQrYoyaku2 = new QHT_GaibuQrYoyaku2();


        String querySql1 = $SELECT + qHT_GaibuQrYoyaku2 +
            $FROM(qHT_GaibuQrYoyaku2);
        String querySql2;
        if (pQrsakuseiymd != null) {
            querySql2 = $WHERE + qHT_GaibuQrYoyaku2.qrsakuseiymd.eq(pQrsakuseiymd);
        }
        else {
            querySql2 = $WHERE + qHT_GaibuQrYoyaku2.qrsakuseiymd.isNull();
        }

        String querySql3 = querySql1 + querySql2 +
            $ORDER_BY(qHT_GaibuQrYoyaku2.syoriYmd.desc(),
                (qHT_GaibuQrYoyaku2.gyoumuKousinTime.substring(9, 4).desc()));


        return em.createJPQL(querySql3).bind(qHT_GaibuQrYoyaku2).getResultList();

    }

    public List<HT_GaibuQrYoyaku2> getGaibuQrYoyaku2sBySkeijimukbnHknsyuruinoMosnosaibankbnQrsakuseiymd(
        C_SkeijimuKbn pSkeijimukbn, C_HknsyuruiNo pHknsyuruino, C_MosnoSaibanKbn pMosnosaibankbn, BizDate pQrsakuseiymd) {


        QHT_GaibuQrYoyaku2 qHT_GaibuQrYoyaku2 = new QHT_GaibuQrYoyaku2();


        String strSpl = $SELECT + qHT_GaibuQrYoyaku2 +
            $FROM(qHT_GaibuQrYoyaku2) +
            $WHERE + qHT_GaibuQrYoyaku2.skeijimukbn.eq(pSkeijimukbn) +
            $AND+ qHT_GaibuQrYoyaku2.hknsyuruino.eq(pHknsyuruino) +
            $AND+ qHT_GaibuQrYoyaku2.mosnosaibankbn.eq(pMosnosaibankbn);

        if (pQrsakuseiymd != null) {
            strSpl = strSpl + $AND + qHT_GaibuQrYoyaku2.qrsakuseiymd.eq(pQrsakuseiymd);
        }
        else {
            strSpl = strSpl + $AND + qHT_GaibuQrYoyaku2.qrsakuseiymd.isNull();
        }


        return em.createJPQL(strSpl).bind(qHT_GaibuQrYoyaku2).getResultList();
    }

    public List<HT_GaibuQrYoyaku2> getGaibuQrYoyaku2sByQrsakuseiymdNull() {


        QHT_GaibuQrYoyaku2 qHT_GaibuQrYoyaku2 = new QHT_GaibuQrYoyaku2("qHT_GaibuQrYoyaku2");


        String querySql = $SELECT + qHT_GaibuQrYoyaku2 +
            $FROM(qHT_GaibuQrYoyaku2) +
            $WHERE + qHT_GaibuQrYoyaku2.qrsakuseiymd.isNull() +
            $ORDER_BY(qHT_GaibuQrYoyaku2.skeijimukbn.asc(),
                qHT_GaibuQrYoyaku2.hknsyuruino.asc(),
                qHT_GaibuQrYoyaku2.mosnosaibankbn.asc());

        return em.createJPQL(querySql).bind(qHT_GaibuQrYoyaku2).getResultList();

    }
}
