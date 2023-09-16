package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.HT_TokujyouRireki;

/**
 * 特条履歴テーブル(HT_TokujyouRirekiDao) アクセス用の DAO クラスです。<br />
 */
public class HT_TokujyouRirekiDao extends AbstractDao<HT_TokujyouRireki> {

    public HT_TokujyouRirekiDao() {
        super(HT_TokujyouRireki.class);
    }

    @Deprecated
    public HT_TokujyouRireki getTokujyouRireki(String pMosno,
         Integer pDakuhiktrenno){
        HT_TokujyouRireki hT_TokujyouRireki =  new HT_TokujyouRireki();
        hT_TokujyouRireki.setMosno(pMosno);
        hT_TokujyouRireki.setDakuhiktrenno(pDakuhiktrenno);
        return this.selectOne(hT_TokujyouRireki);
    }

    @Override
    @Deprecated
    public List<HT_TokujyouRireki> selectAll() {
        return super.selectAll();
    }
}
