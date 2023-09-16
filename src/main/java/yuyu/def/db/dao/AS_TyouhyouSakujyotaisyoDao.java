package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.AS_TyouhyouSakujyotaisyo;
import yuyu.def.db.meta.QAS_TyouhyouSakujyotaisyo;

/**
 * 帳票削除対象基幹テーブル(AS_TyouhyouSakujyotaisyoDao) アクセス用の DAO クラスです。<br />
 */
public class AS_TyouhyouSakujyotaisyoDao extends AbstractDao<AS_TyouhyouSakujyotaisyo> {

    public AS_TyouhyouSakujyotaisyoDao() {
        super(AS_TyouhyouSakujyotaisyo.class);
    }

    public AS_TyouhyouSakujyotaisyo getTyouhyouSakujyotaisyo(C_SyoruiCdKbn pSyoruiCd) {
        AS_TyouhyouSakujyotaisyo aS_TyouhyouSakujyotaisyo =  new AS_TyouhyouSakujyotaisyo();
        aS_TyouhyouSakujyotaisyo.setSyoruiCd(pSyoruiCd);
        return this.selectOne(aS_TyouhyouSakujyotaisyo);
    }

    public List<AS_TyouhyouSakujyotaisyo> getTyouhyouSakujyotaisyosByHozonKikanOut(Integer pHozonKikan) {


        QAS_TyouhyouSakujyotaisyo qAS_TyouhyouSakujyotaisyo = new QAS_TyouhyouSakujyotaisyo();


        String strSql = $SELECT + qAS_TyouhyouSakujyotaisyo +
                $FROM(qAS_TyouhyouSakujyotaisyo) +
                $WHERE + qAS_TyouhyouSakujyotaisyo.hozonKikan.ne(pHozonKikan);


        return em.createJPQL(strSql).bind(qAS_TyouhyouSakujyotaisyo).getResultList();
    }
}
