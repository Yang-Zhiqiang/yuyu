package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.IT_KoujyoSymSougou;
import yuyu.def.db.meta.QIT_KoujyoSymSougou;

/**
 * 控除証明書（総合通知用）テーブル(IT_KoujyoSymSougouDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KoujyoSymSougouDao extends AbstractDao<IT_KoujyoSymSougou> {

    public IT_KoujyoSymSougouDao() {
        super(IT_KoujyoSymSougou.class);
    }

    public IT_KoujyoSymSougou getKoujyoSymSougou(String pSyono, String pNendo, BizDate pTyouhyouymd, Integer pRenno) {
        IT_KoujyoSymSougou iT_KoujyoSymSougou =  new IT_KoujyoSymSougou( pSyono,  pNendo,  pTyouhyouymd,  pRenno);
        return this.selectOne(iT_KoujyoSymSougou);
    }

    public Integer getKoujyoSymSougouMaxRennoBySyonoNendoTyouhyouymd(String pSyono, String pNendo, BizDate pTyouhyouymd) {


        QIT_KoujyoSymSougou qIT_KoujyoSymSougou = new QIT_KoujyoSymSougou();


        String querySql = $SELECT + $MAX(qIT_KoujyoSymSougou.renno) +
            $FROM + qIT_KoujyoSymSougou.IT_KoujyoSymSougou() +
            $WHERE + qIT_KoujyoSymSougou.syono.eq(pSyono) +
            $AND + qIT_KoujyoSymSougou.nendo.eq(pNendo) +
            $AND + qIT_KoujyoSymSougou.tyouhyouymd.eq(pTyouhyouymd);

        return em.createJPQL(querySql).bind(qIT_KoujyoSymSougou).getSingleResult();
    }
}
