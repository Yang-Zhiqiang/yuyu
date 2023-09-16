package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.ST_DshrTukiTyukeiyouItzHzn;

/**
 * Ｄ支払統計中継用一時保存テーブル(ST_DshrTukiTyukeiyouItzHznDao) アクセス用の DAO クラスです。<br />
 */
public class ST_DshrTukiTyukeiyouItzHznDao extends AbstractDao<ST_DshrTukiTyukeiyouItzHzn> {

    public ST_DshrTukiTyukeiyouItzHznDao() {
        super(ST_DshrTukiTyukeiyouItzHzn.class);
    }

    public ST_DshrTukiTyukeiyouItzHzn getDshrTukiTyukeiyouItzHzn(Integer pZtysequenceno) {
        ST_DshrTukiTyukeiyouItzHzn sT_DshrTukiTyukeiyouItzHzn =  new ST_DshrTukiTyukeiyouItzHzn();
        sT_DshrTukiTyukeiyouItzHzn.setZtysequenceno(pZtysequenceno);
        return this.selectOne(sT_DshrTukiTyukeiyouItzHzn);
    }
}
