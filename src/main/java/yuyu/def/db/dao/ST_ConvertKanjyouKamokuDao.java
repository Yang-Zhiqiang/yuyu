package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.db.entity.ST_ConvertKanjyouKamoku;

/**
 * 勘定科目変換テーブル(ST_ConvertKanjyouKamokuDao) アクセス用の DAO クラスです。<br />
 */
public class ST_ConvertKanjyouKamokuDao extends AbstractDao<ST_ConvertKanjyouKamoku> {

    public ST_ConvertKanjyouKamokuDao() {
        super(ST_ConvertKanjyouKamoku.class);
    }

    public ST_ConvertKanjyouKamoku getConvertKanjyouKamoku(C_Kanjyoukmkcd pKanjyoukmkcd, C_TaisyakuKbn pTaisyakukbn) {
        ST_ConvertKanjyouKamoku sT_ConvertKanjyouKamoku =  new ST_ConvertKanjyouKamoku();
        sT_ConvertKanjyouKamoku.setKanjyoukmkcd(pKanjyoukmkcd);
        sT_ConvertKanjyouKamoku.setTaisyakukbn(pTaisyakukbn);
        return this.selectOne(sT_ConvertKanjyouKamoku);
    }
}
