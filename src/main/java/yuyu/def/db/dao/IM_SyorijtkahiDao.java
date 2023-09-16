package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_YuukoujyotaikahiKbn;
import yuyu.def.db.entity.IM_Syorijtkahi;
import yuyu.def.db.meta.QIM_Syorijtkahi;

/**
 * 処理状態処理可否マスタ(IM_SyorijtkahiDao) アクセス用の DAO クラスです。<br />
 */
public class IM_SyorijtkahiDao extends AbstractDao<IM_Syorijtkahi> {

    public IM_SyorijtkahiDao() {
        super(IM_Syorijtkahi.class);
    }

    public IM_Syorijtkahi getSyorijtkahi(String pKinouId,
        String pSyorijimuttdkcd,
        String pSyoritaskid){
        IM_Syorijtkahi iM_Syorijtkahi =  new IM_Syorijtkahi();
        iM_Syorijtkahi.setKinouId(pKinouId);
        iM_Syorijtkahi.setSyorijimuttdkcd(pSyorijimuttdkcd);
        iM_Syorijtkahi.setSyoritaskid(pSyoritaskid);
        return this.selectOne(iM_Syorijtkahi);
    }

    public List<IM_Syorijtkahi> getSyorijtkahiByKinouidYuukoujyotaikahikbn(String pKinouId,
        C_YuukoujyotaikahiKbn pYuukoujyotaikahikbn) {


        QIM_Syorijtkahi qIM_Syorijtkahi = new QIM_Syorijtkahi("qIM_Syorijtkahi");


        String querySql = $SELECT + qIM_Syorijtkahi +
            $FROM (qIM_Syorijtkahi) +
            $WHERE + qIM_Syorijtkahi.kinouId.eq(pKinouId) +
            $AND + qIM_Syorijtkahi.yuukoujyotaikahikbn.eq(pYuukoujyotaikahikbn);

        return em.createJPQL(querySql).bind(qIM_Syorijtkahi).getResultList();
    }
}
