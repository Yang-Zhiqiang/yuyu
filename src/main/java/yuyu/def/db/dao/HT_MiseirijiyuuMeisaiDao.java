package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.HT_MiseirijiyuuMeisai;

/**
 * 未整理事由別明細テーブル(HT_MiseirijiyuuMeisaiDao) アクセス用の DAO クラスです。<br />
 */
public class HT_MiseirijiyuuMeisaiDao extends AbstractDao<HT_MiseirijiyuuMeisai> {

    public HT_MiseirijiyuuMeisaiDao() {
        super(HT_MiseirijiyuuMeisai.class);
    }

    public HT_MiseirijiyuuMeisai getMiseirijiyuuMeisai(String pMosno){
        HT_MiseirijiyuuMeisai hT_MiseirijiyuuMeisai =  new HT_MiseirijiyuuMeisai();
        hT_MiseirijiyuuMeisai.setMosno(pMosno);
        return this.selectOne(hT_MiseirijiyuuMeisai);
    }
}
