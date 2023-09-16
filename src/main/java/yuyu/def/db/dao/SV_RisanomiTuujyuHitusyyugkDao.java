package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.SV_RisanomiTuujyuHitusyyugk;
import yuyu.def.db.meta.QSV_RisanomiTuujyuHitusyyugk;

/**
 * 利差のみ通常配当所要額情報ビュー(SV_RisanomiTuujyuHitusyyugkDao) アクセス用の DAO クラスです。<br />
 */
public class SV_RisanomiTuujyuHitusyyugkDao extends AbstractDao<SV_RisanomiTuujyuHitusyyugk> {

    public SV_RisanomiTuujyuHitusyyugkDao() {
        super(SV_RisanomiTuujyuHitusyyugk.class);
    }

    public SV_RisanomiTuujyuHitusyyugk getRisanomiTuujyuHitusyyugk(String pSyono, C_SyutkKbn pSyutkkbn, String pSyouhncd, Integer pSyouhnsdno, Integer pKyksyouhnrenno) {
        SV_RisanomiTuujyuHitusyyugk sV_RisanomiTuujyuHitusyyugk =  new SV_RisanomiTuujyuHitusyyugk();
        sV_RisanomiTuujyuHitusyyugk.setSyono(pSyono);
        sV_RisanomiTuujyuHitusyyugk.setSyutkkbn(pSyutkkbn);
        sV_RisanomiTuujyuHitusyyugk.setSyouhncd(pSyouhncd);
        sV_RisanomiTuujyuHitusyyugk.setSyouhnsdno(pSyouhnsdno);
        sV_RisanomiTuujyuHitusyyugk.setKyksyouhnrenno(pKyksyouhnrenno);
        return this.selectOne(sV_RisanomiTuujyuHitusyyugk);
    }

    public ExDBResults<SV_RisanomiTuujyuHitusyyugk> getRisanomiTuujyuHitusyyugksBySyutkkbnHaitoukbn(
        C_SyutkKbn pSyutkkbn, C_HaitouKbn pHaitoukbn, String pKbnkey) {


        QSV_RisanomiTuujyuHitusyyugk qSV_RisanomiTuujyuHitusyyugk = new QSV_RisanomiTuujyuHitusyyugk();


        String where = "";
        if (!BizUtil.isBlank(pKbnkey)) {
            where = $AND + qSV_RisanomiTuujyuHitusyyugk.kbnkey.eq(pKbnkey);
        }

        String strSql = $SELECT + qSV_RisanomiTuujyuHitusyyugk +
            $FROM + qSV_RisanomiTuujyuHitusyyugk.SV_RisanomiTuujyuHitusyyugk() +
            $WHERE + qSV_RisanomiTuujyuHitusyyugk.syutkkbn.eq(pSyutkkbn) +
            $AND + qSV_RisanomiTuujyuHitusyyugk.haitoukbn.eq(pHaitoukbn) +
            where
            ;


        return em.createJPQL(strSql).bind(qSV_RisanomiTuujyuHitusyyugk).getResults();
    }
}
