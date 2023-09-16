package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_KykSyouhnHnkmae;
import yuyu.def.db.meta.QIT_KykSyouhnHnkmae;

/**
 * 契約商品変更前内容テーブル(IT_KykSyouhnHnkmaeDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KykSyouhnHnkmaeDao extends AbstractDao<IT_KykSyouhnHnkmae> {

    public IT_KykSyouhnHnkmaeDao() {
        super(IT_KykSyouhnHnkmae.class);
    }

    public IT_KykSyouhnHnkmae getKykSyouhnHnkmae(String pSyono, C_SyutkKbn pSyutkkbn, String pSyouhncd,
        Integer pSyouhnsdno, Integer pKyksyouhnrenno, Integer pRenno) {
        IT_KykSyouhnHnkmae iT_KykSyouhnHnkmae = new IT_KykSyouhnHnkmae(pSyono, pSyutkkbn, pSyouhncd, pSyouhnsdno,
            pKyksyouhnrenno, pRenno);
        return this.selectOne(iT_KykSyouhnHnkmae);
    }

    public IT_KykSyouhnHnkmae getKykSyouhnHnkmaeBySyono(String pSyono) {


        QIT_KykSyouhnHnkmae qIT_KykSyouhnHnkmae = new QIT_KykSyouhnHnkmae();

        String mainStry = $SELECT + qIT_KykSyouhnHnkmae +
            $FROM (qIT_KykSyouhnHnkmae) +
            $WHERE + qIT_KykSyouhnHnkmae.syono.eq(pSyono) +
            $ORDER_BY (qIT_KykSyouhnHnkmae.syouhnsdno.desc(),
                qIT_KykSyouhnHnkmae.kyksyouhnrenno.desc(),
                qIT_KykSyouhnHnkmae.renno.desc());


        return em.createJPQL(mainStry).setFirstResult(0).setMaxResults(1).bind(qIT_KykSyouhnHnkmae).getSingleResult();
    }
}
