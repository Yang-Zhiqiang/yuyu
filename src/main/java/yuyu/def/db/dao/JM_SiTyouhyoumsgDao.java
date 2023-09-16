package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.JM_SiTyouhyoumsg;
import yuyu.def.db.meta.QJM_SiTyouhyoumsg;

/**
 * 支払帳票メッセージマスタ(JM_SiTyouhyoumsgDao) アクセス用の DAO クラスです。<br />
 */
public class JM_SiTyouhyoumsgDao extends AbstractDao<JM_SiTyouhyoumsg> {

    public JM_SiTyouhyoumsgDao() {
        super(JM_SiTyouhyoumsg.class);
    }

    public JM_SiTyouhyoumsg getSiTyouhyoumsg(String pBunrui1,
        String pBunrui2,
        Integer pTyouhyoulineno){
        JM_SiTyouhyoumsg jM_SiTyouhyoumsg =  new JM_SiTyouhyoumsg();
        jM_SiTyouhyoumsg.setBunrui1(pBunrui1);
        jM_SiTyouhyoumsg.setBunrui2(pBunrui2);
        jM_SiTyouhyoumsg.setTyouhyoulineno(pTyouhyoulineno);
        return this.selectOne(jM_SiTyouhyoumsg);
    }

    public List<JM_SiTyouhyoumsg> getSiTyouhyoumsgsByBunrui1Bunrui2(String pBunrui1, String pBunrui2) {


        QJM_SiTyouhyoumsg qJM_SiTyouhyoumsg = new QJM_SiTyouhyoumsg();

        String mainQuerry = $SELECT + qJM_SiTyouhyoumsg +
            $FROM + qJM_SiTyouhyoumsg.JM_SiTyouhyoumsg() +
            $WHERE + qJM_SiTyouhyoumsg.bunrui1.eq(pBunrui1) +
            $AND + qJM_SiTyouhyoumsg.bunrui2.eq(pBunrui2) +
            $ORDER_BY(qJM_SiTyouhyoumsg.tyouhyoulineno.asc());


        return em.createJPQL(mainQuerry).bind(qJM_SiTyouhyoumsg).getResultList();
    }
}
