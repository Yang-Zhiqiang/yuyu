package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.db.entity.ST_SynypTukiYkgtIkouHozon;

/**
 * 収入Ｐ統計翌月以降保存テーブル(ST_SynypTukiYkgtIkouHozonDao) アクセス用の DAO クラスです。<br />
 */
public class ST_SynypTukiYkgtIkouHozonDao extends AbstractDao<ST_SynypTukiYkgtIkouHozon> {

    public ST_SynypTukiYkgtIkouHozonDao() {
        super(ST_SynypTukiYkgtIkouHozon.class);
    }

    public ST_SynypTukiYkgtIkouHozon getSynypTukiYkgtIkouHozon(String pSrkijyunym, Integer pSequenceno, String pSyono, BizDateYM pJyutoustartym, BizDateYM pJyutouendym, C_TaisyakuKbn pTaisyakukbn) {
        ST_SynypTukiYkgtIkouHozon sT_SynypTukiYkgtIkouHozon =  new ST_SynypTukiYkgtIkouHozon();
        sT_SynypTukiYkgtIkouHozon.setSrkijyunym(pSrkijyunym);
        sT_SynypTukiYkgtIkouHozon.setSequenceno(pSequenceno);
        sT_SynypTukiYkgtIkouHozon.setSyono(pSyono);
        sT_SynypTukiYkgtIkouHozon.setJyutoustartym(pJyutoustartym);
        sT_SynypTukiYkgtIkouHozon.setJyutouendym(pJyutouendym);
        sT_SynypTukiYkgtIkouHozon.setTaisyakukbn(pTaisyakukbn);
        return this.selectOne(sT_SynypTukiYkgtIkouHozon);
    }
}
