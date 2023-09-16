package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.HT_Tokujyou;

/**
 * 特条テーブル(HT_TokujyouDao) アクセス用の DAO クラスです。<br />
 */
public class HT_TokujyouDao extends AbstractDao<HT_Tokujyou> {

    public HT_TokujyouDao() {
        super(HT_Tokujyou.class);
    }

    @Deprecated
    public HT_Tokujyou getTokujyou(String pMosno){
        HT_Tokujyou hT_Tokujyou =  new HT_Tokujyou();
        hT_Tokujyou.setMosno(pMosno);
        return this.selectOne(hT_Tokujyou);
    }

    @Override
    @Deprecated
    public List<HT_Tokujyou> selectAll() {
        return super.selectAll();
    }
}
