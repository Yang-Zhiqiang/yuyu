package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_NyuukinKakusyouData;
import yuyu.def.db.meta.QIT_NyuukinKakusyouData;

/**
 * 入金確証データテーブル(IT_NyuukinKakusyouDataDao) アクセス用の DAO クラスです。<br />
 */
public class IT_NyuukinKakusyouDataDao extends AbstractDao<IT_NyuukinKakusyouData> {

    public IT_NyuukinKakusyouDataDao() {
        super(IT_NyuukinKakusyouData.class);
    }

    public IT_NyuukinKakusyouData getNyuukinKakusyouData(String pNyuukinkakusyouno, String pSyono) {
        IT_NyuukinKakusyouData iT_NyuukinKakusyouData =  new IT_NyuukinKakusyouData( pNyuukinkakusyouno,  pSyono);
        return this.selectOne(iT_NyuukinKakusyouData);
    }

    public List<IT_NyuukinKakusyouData> getNyuukinKakusyouDataBySyono(String pSyono) {


        QIT_NyuukinKakusyouData qIT_NyuukinKakusyouData = new QIT_NyuukinKakusyouData("qIT_NyuukinKakusyouData");

        String queryStr = $SELECT + qIT_NyuukinKakusyouData +
            $FROM(qIT_NyuukinKakusyouData) +
            $WHERE + qIT_NyuukinKakusyouData.syono.eq(pSyono);

        return em.createJPQL(queryStr).bind(qIT_NyuukinKakusyouData).getResultList();
    }

}
