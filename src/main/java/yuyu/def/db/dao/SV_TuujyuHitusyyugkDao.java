package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.SV_TuujyuHitusyyugk;
import yuyu.def.db.meta.QSV_TuujyuHitusyyugk;

/**
 * 通常配当所要額情報ビュー(SV_TuujyuHitusyyugkDao) アクセス用の DAO クラスです。<br />
 */
public class SV_TuujyuHitusyyugkDao extends AbstractDao<SV_TuujyuHitusyyugk> {

    public SV_TuujyuHitusyyugkDao() {
        super(SV_TuujyuHitusyyugk.class);
    }

    public SV_TuujyuHitusyyugk getTuujyuHitusyyugk(String pSyono, C_SyutkKbn pSyutkkbn, String pSyouhncd, Integer pSyouhnsdno, Integer pKyksyouhnrenno) {
        SV_TuujyuHitusyyugk sV_TuujyuHitusyyugk =  new SV_TuujyuHitusyyugk();
        sV_TuujyuHitusyyugk.setSyono(pSyono);
        sV_TuujyuHitusyyugk.setSyutkkbn(pSyutkkbn);
        sV_TuujyuHitusyyugk.setSyouhncd(pSyouhncd);
        sV_TuujyuHitusyyugk.setSyouhnsdno(pSyouhnsdno);
        sV_TuujyuHitusyyugk.setKyksyouhnrenno(pKyksyouhnrenno);
        return this.selectOne(sV_TuujyuHitusyyugk);
    }

    public ExDBResults<SV_TuujyuHitusyyugk> getTuujyuHitusyyugksBySyutkkbnHaitoukbn(C_SyutkKbn pSyutkkbn, C_HaitouKbn pHaitoukbn1, String pKbnkey) {


        QSV_TuujyuHitusyyugk qSV_TuujyuHitusyyugk = new QSV_TuujyuHitusyyugk();


        String where = "";
        if (!BizUtil.isBlank(pKbnkey)) {
            where = $AND + qSV_TuujyuHitusyyugk.kbnkey.eq(pKbnkey);
        }

        String strSql = $SELECT + qSV_TuujyuHitusyyugk +
            $FROM + qSV_TuujyuHitusyyugk.SV_TuujyuHitusyyugk() +
            $WHERE + qSV_TuujyuHitusyyugk.syutkkbn.eq(pSyutkkbn) +
            $AND + qSV_TuujyuHitusyyugk.haitoukbn.eq(pHaitoukbn1) +
            where
            ;


        return em.createJPQL(strSql).bind(qSV_TuujyuHitusyyugk).getResults();
    }
}
