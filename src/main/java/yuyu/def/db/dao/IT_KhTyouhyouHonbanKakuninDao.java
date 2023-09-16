package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TyouhyouBunruiKbn;
import yuyu.def.db.entity.IT_KhTyouhyouHonbanKakunin;
import yuyu.def.db.meta.QIT_KhTyouhyouHonbanKakunin;

/**
 * 契約保全帳票本番確認テーブル(IT_KhTyouhyouHonbanKakuninDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KhTyouhyouHonbanKakuninDao extends AbstractDao<IT_KhTyouhyouHonbanKakunin> {

    public IT_KhTyouhyouHonbanKakuninDao() {
        super(IT_KhTyouhyouHonbanKakunin.class);
    }

    public IT_KhTyouhyouHonbanKakunin getKhTyouhyouHonbanKakunin(C_TyouhyouBunruiKbn pTyouhyoubunrui, C_SyoruiCdKbn pSyoruiCd, String pJyoukenbunrui1, String pJyoukenbunrui2, String pJyoukenbunrui3) {
        IT_KhTyouhyouHonbanKakunin iT_KhTyouhyouHonbanKakunin =  new IT_KhTyouhyouHonbanKakunin();
        iT_KhTyouhyouHonbanKakunin.setTyouhyoubunrui(pTyouhyoubunrui);
        iT_KhTyouhyouHonbanKakunin.setSyoruiCd(pSyoruiCd);
        iT_KhTyouhyouHonbanKakunin.setJyoukenbunrui1(pJyoukenbunrui1);
        iT_KhTyouhyouHonbanKakunin.setJyoukenbunrui2(pJyoukenbunrui2);
        iT_KhTyouhyouHonbanKakunin.setJyoukenbunrui3(pJyoukenbunrui3);
        return this.selectOne(iT_KhTyouhyouHonbanKakunin);
    }

    public ExDBResults<IT_KhTyouhyouHonbanKakunin> selectAllKktNkGnsritu() {
        StringBuilder jpql = new StringBuilder();
        QIT_KhTyouhyouHonbanKakunin qIT_KhTyouhyouHonbanKakunin =  new QIT_KhTyouhyouHonbanKakunin();
        jpql.append($SELECT);
        jpql.append(qIT_KhTyouhyouHonbanKakunin);
        jpql.append($FROM);
        jpql.append(qIT_KhTyouhyouHonbanKakunin.IT_KhTyouhyouHonbanKakunin());
        jpql.append($ORDER_BY(qIT_KhTyouhyouHonbanKakunin.tyouhyoubunrui.asc(), qIT_KhTyouhyouHonbanKakunin.syoruiCd.asc(), qIT_KhTyouhyouHonbanKakunin.jyoukenbunrui1.asc(), qIT_KhTyouhyouHonbanKakunin.jyoukenbunrui2.asc(), qIT_KhTyouhyouHonbanKakunin.jyoukenbunrui3.asc()));
        return em.createJPQL(jpql.toString()).bind(qIT_KhTyouhyouHonbanKakunin).getResults();
    }
}
