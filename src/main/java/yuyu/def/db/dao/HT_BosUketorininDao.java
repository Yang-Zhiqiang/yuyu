package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.db.entity.HT_BosUketorinin;

/**
 * 募集受取人テーブル(HT_BosUketorininDao) アクセス用の DAO クラスです。<br />
 */
public class HT_BosUketorininDao extends AbstractDao<HT_BosUketorinin> {

    public HT_BosUketorininDao() {
        super(HT_BosUketorinin.class);
    }

    @Deprecated
    public HT_BosUketorinin getBosUketorinin(String pMosno,
         C_UktsyuKbn pUktsyukbn,
         Integer pUktsyurenno){
        HT_BosUketorinin hT_BosUketorinin =  new HT_BosUketorinin();
        hT_BosUketorinin.setMosno(pMosno);
        hT_BosUketorinin.setUktsyukbn(pUktsyukbn);
        hT_BosUketorinin.setUktsyurenno(pUktsyurenno);
        return this.selectOne(hT_BosUketorinin);
    }

    @Override
    @Deprecated
    public List<HT_BosUketorinin> selectAll() {
        return super.selectAll();
    }
}
