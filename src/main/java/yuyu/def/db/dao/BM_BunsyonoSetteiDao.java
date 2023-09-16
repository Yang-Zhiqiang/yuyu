package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_BunsyoSyubetuKbn;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.db.entity.BM_BunsyonoSettei;
import yuyu.def.db.meta.QBM_BunsyonoSettei;

/**
 * 文書番号設定マスタ(BM_BunsyonoSetteiDao) アクセス用の DAO クラスです。<br />
 */
public class BM_BunsyonoSetteiDao extends AbstractDao<BM_BunsyonoSettei> {

    public BM_BunsyonoSetteiDao() {
        super(BM_BunsyonoSettei.class);
    }

    public BM_BunsyonoSettei getBunsyonoSettei(C_BunsyoSyubetuKbn pBunsyosyubetukbn, C_AisyoumeiKbn pAisyoumeikbn, C_Channelcd pChannelcd, String pOyadrtencd, Integer pRenno) {
        BM_BunsyonoSettei bM_BunsyonoSettei =  new BM_BunsyonoSettei();
        bM_BunsyonoSettei.setBunsyosyubetukbn(pBunsyosyubetukbn);
        bM_BunsyonoSettei.setAisyoumeikbn(pAisyoumeikbn);
        bM_BunsyonoSettei.setChannelcd(pChannelcd);
        bM_BunsyonoSettei.setOyadrtencd(pOyadrtencd);
        bM_BunsyonoSettei.setRenno(pRenno);
        return this.selectOne(bM_BunsyonoSettei);
    }

    public List<BM_BunsyonoSettei> getBunsyonoSetteiByBnsysybtkbnAisyoumeikbnChannelcdTkyuymd(
        C_BunsyoSyubetuKbn pBunsyosyubetukbn, C_AisyoumeiKbn pAisyoumeikbn, C_Channelcd pChannelcd, BizDate pTekiyouYmd) {


        QBM_BunsyonoSettei qBM_BunsyonoSettei = new QBM_BunsyonoSettei("qBM_BunsyonoSettei");


        String strSql = $SELECT + qBM_BunsyonoSettei +
            $FROM(qBM_BunsyonoSettei) +
            $WHERE + qBM_BunsyonoSettei.bunsyosyubetukbn.eq(pBunsyosyubetukbn) +
            $AND + qBM_BunsyonoSettei.aisyoumeikbn.eq(pAisyoumeikbn) +
            $AND + qBM_BunsyonoSettei.channelcd.eq(pChannelcd) +
            $AND + qBM_BunsyonoSettei.tekiyouYmdFrom.le(pTekiyouYmd) +
            $AND + qBM_BunsyonoSettei.tekiyouYmdTo.ge(pTekiyouYmd);


        return em.createJPQL(strSql).bind(qBM_BunsyonoSettei).getResultList();
    }
}
