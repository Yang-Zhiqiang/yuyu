package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IT_BAK_NyuukinKakusyouData;
import yuyu.def.db.meta.QIT_BAK_NyuukinKakusyouData;

/**
 * 入金確証データバックアップテーブル(IT_BAK_NyuukinKakusyouDataDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_NyuukinKakusyouDataDao extends AbstractDao<IT_BAK_NyuukinKakusyouData> {

    public IT_BAK_NyuukinKakusyouDataDao() {
        super(IT_BAK_NyuukinKakusyouData.class);
    }

    public IT_BAK_NyuukinKakusyouData getBAKNyuukinKakusyouData(String pNyuukinkakusyouno, String pSyono, String pTrkssikibetukey) {
        IT_BAK_NyuukinKakusyouData iT_BAK_NyuukinKakusyouData =  new IT_BAK_NyuukinKakusyouData( pNyuukinkakusyouno,  pSyono,  pTrkssikibetukey);
        return this.selectOne(iT_BAK_NyuukinKakusyouData);
    }

    public List<IT_BAK_NyuukinKakusyouData> getBAKNyuukinKakusyouDataBySyonoTrkssikibetukey(String pSyono,
        String pTrkssikibetukey) {


        QIT_BAK_NyuukinKakusyouData qIT_BAK_NyuukinKakusyouData = new QIT_BAK_NyuukinKakusyouData("qIT_BAK_NyuukinKakusyouData");

        String queryStr = $SELECT + qIT_BAK_NyuukinKakusyouData +
            $FROM(qIT_BAK_NyuukinKakusyouData) +
            $WHERE + qIT_BAK_NyuukinKakusyouData.syono.eq(pSyono) +
            $AND + qIT_BAK_NyuukinKakusyouData.trkssikibetukey.eq(pTrkssikibetukey);

        return em.createJPQL(queryStr).bind(qIT_BAK_NyuukinKakusyouData).getResultList();
    }

}
