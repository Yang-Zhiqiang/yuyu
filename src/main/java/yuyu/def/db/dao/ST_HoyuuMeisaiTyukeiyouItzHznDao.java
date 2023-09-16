package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.ST_HoyuuMeisaiTyukeiyouItzHzn;

/**
 * 保有明細中継用一時保存テーブル(ST_HoyuuMeisaiTyukeiyouItzHznDao) アクセス用の DAO クラスです。<br />
 */
public class ST_HoyuuMeisaiTyukeiyouItzHznDao extends AbstractDao<ST_HoyuuMeisaiTyukeiyouItzHzn> {

    public ST_HoyuuMeisaiTyukeiyouItzHznDao() {
        super(ST_HoyuuMeisaiTyukeiyouItzHzn.class);
    }

    public ST_HoyuuMeisaiTyukeiyouItzHzn getHoyuuMeisaiTyukeiyouItzHzn(String pZtysrkijyunym, String pZtysrkakutyoujobcd, Integer pZtysequenceno) {
        ST_HoyuuMeisaiTyukeiyouItzHzn sT_HoyuuMeisaiTyukeiyouItzHzn =  new ST_HoyuuMeisaiTyukeiyouItzHzn();
        sT_HoyuuMeisaiTyukeiyouItzHzn.setZtysrkijyunym(pZtysrkijyunym);
        sT_HoyuuMeisaiTyukeiyouItzHzn.setZtysrkakutyoujobcd(pZtysrkakutyoujobcd);
        sT_HoyuuMeisaiTyukeiyouItzHzn.setZtysequenceno(pZtysequenceno);
        return this.selectOne(sT_HoyuuMeisaiTyukeiyouItzHzn);
    }

}
