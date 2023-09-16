package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.AT_RinjiKadouTaisyoSosiki;

/**
 * 臨時稼働対象組織テーブル(AT_RinjiKadouTaisyoSosikiDao) アクセス用の DAO クラスです。<br />
 */
public class AT_RinjiKadouTaisyoSosikiDao extends AbstractDao<AT_RinjiKadouTaisyoSosiki> {

    public AT_RinjiKadouTaisyoSosikiDao() {
        super(AT_RinjiKadouTaisyoSosiki.class);
    }

    public AT_RinjiKadouTaisyoSosiki getRinjiKadouTaisyoSosiki(String pKadouSosikiCd) {
        AT_RinjiKadouTaisyoSosiki aT_RinjiKadouTaisyoSosiki =  new AT_RinjiKadouTaisyoSosiki();
        aT_RinjiKadouTaisyoSosiki.setKadouSosikiCd(pKadouSosikiCd);
        return this.selectOne(aT_RinjiKadouTaisyoSosiki);
    }
}
