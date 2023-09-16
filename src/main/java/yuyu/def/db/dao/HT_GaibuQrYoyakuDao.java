package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.db.entity.HT_GaibuQrYoyaku;
import yuyu.def.db.meta.QHT_GaibuQrYoyaku;

/**
 * 外部用ＱＲ予約テーブル(HT_GaibuQrYoyakuDao) アクセス用の DAO クラスです。<br />
 */
public class HT_GaibuQrYoyakuDao extends AbstractDao<HT_GaibuQrYoyaku> {

    public HT_GaibuQrYoyakuDao() {
        super(HT_GaibuQrYoyaku.class);
    }

    public HT_GaibuQrYoyaku getGaibuQrYoyaku(BizDate pSyoriYmd,
        C_SkeijimuKbn pSkeijimukbn,
        C_HknsyuruiNo pHknsyuruino){
        HT_GaibuQrYoyaku hT_GaibuQrYoyaku =  new HT_GaibuQrYoyaku();
        hT_GaibuQrYoyaku.setSyoriYmd(pSyoriYmd);
        hT_GaibuQrYoyaku.setSkeijimukbn(pSkeijimukbn);
        hT_GaibuQrYoyaku.setHknsyuruino(pHknsyuruino);
        return this.selectOne(hT_GaibuQrYoyaku);
    }

    public List<HT_GaibuQrYoyaku> getGaibuQrYoyakusByQrsakuseiymd(BizDate pQrsakuseiymd) {


        QHT_GaibuQrYoyaku qHT_GaibuQrYoyaku = new QHT_GaibuQrYoyaku();

        String querySql1 = $SELECT + qHT_GaibuQrYoyaku +
            $FROM + qHT_GaibuQrYoyaku.HT_GaibuQrYoyaku();
        String querySql2;
        if (pQrsakuseiymd != null) {
            querySql2 = $WHERE + qHT_GaibuQrYoyaku.qrsakuseiymd.eq(pQrsakuseiymd);
        }
        else {
            querySql2 = $WHERE + qHT_GaibuQrYoyaku.qrsakuseiymd.isNull();
        }

        String querySql3 = querySql1 + querySql2 +
            $ORDER_BY(qHT_GaibuQrYoyaku.syoriYmd.desc(),
                (qHT_GaibuQrYoyaku.gyoumuKousinTime.substring(9, 4).desc()));
        return em.createJPQL(querySql3).bind(qHT_GaibuQrYoyaku).getResultList();
    }

    public List<HT_GaibuQrYoyaku> getGaibuQrYoyakusBySkeijimukbnHknsyuruinoQrsakuseiymd(C_SkeijimuKbn pSkeijimukbn,
        C_HknsyuruiNo pHknsyuruino,
        BizDate pQrsakuseiymd) {
        QHT_GaibuQrYoyaku qHT_GaibuQrYoyaku = new QHT_GaibuQrYoyaku("qHT_GaibuQrYoyaku");
        String querySql = $SELECT + qHT_GaibuQrYoyaku +
            $FROM(qHT_GaibuQrYoyaku) +
            $WHERE + qHT_GaibuQrYoyaku.skeijimukbn.eq(pSkeijimukbn) +
            $AND + qHT_GaibuQrYoyaku.hknsyuruino.eq(pHknsyuruino) ;

        if (pQrsakuseiymd != null) {
            querySql = querySql + $AND + qHT_GaibuQrYoyaku.qrsakuseiymd.eq(pQrsakuseiymd);
        }
        else {
            querySql = querySql + $AND + qHT_GaibuQrYoyaku.qrsakuseiymd.isNull();
        }

        return em.createJPQL(querySql).bind(qHT_GaibuQrYoyaku).getResultList();
    }

    public List<HT_GaibuQrYoyaku> getGaibuQrYoyakusByQrsakuseiymdNull() {

        QHT_GaibuQrYoyaku qHT_GaibuQrYoyaku = new QHT_GaibuQrYoyaku("qHT_GaibuQrYoyaku");

        String querySql = $SELECT + qHT_GaibuQrYoyaku +
            $FROM(qHT_GaibuQrYoyaku) +
            $WHERE + qHT_GaibuQrYoyaku.qrsakuseiymd.isNull() +
            $ORDER_BY(qHT_GaibuQrYoyaku.skeijimukbn.asc(),
                qHT_GaibuQrYoyaku.hknsyuruino.asc());

        return em.createJPQL(querySql).bind(qHT_GaibuQrYoyaku).getResultList();
    }

}
