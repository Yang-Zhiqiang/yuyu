package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.ST_IdouMeisaiTyukeiyouItzHzn;

/**
 * 異動明細中継用一時保存テーブル(ST_IdouMeisaiTyukeiyouItzHznDao) アクセス用の DAO クラスです。<br />
 */
public class ST_IdouMeisaiTyukeiyouItzHznDao extends AbstractDao<ST_IdouMeisaiTyukeiyouItzHzn> {

    public ST_IdouMeisaiTyukeiyouItzHznDao() {
        super(ST_IdouMeisaiTyukeiyouItzHzn.class);
    }

    public ST_IdouMeisaiTyukeiyouItzHzn getIdouMeisaiTyukeiyouItzHzn(String pZtysrkijyunym, String pZtysrkakutyoujobcd, Integer pZtysequenceno) {
        ST_IdouMeisaiTyukeiyouItzHzn sT_IdouMeisaiTyukeiyouItzHzn =  new ST_IdouMeisaiTyukeiyouItzHzn();
        sT_IdouMeisaiTyukeiyouItzHzn.setZtysrkijyunym(pZtysrkijyunym);
        sT_IdouMeisaiTyukeiyouItzHzn.setZtysrkakutyoujobcd(pZtysrkakutyoujobcd);
        sT_IdouMeisaiTyukeiyouItzHzn.setZtysequenceno(pZtysequenceno);
        return this.selectOne(sT_IdouMeisaiTyukeiyouItzHzn);
    }

}
