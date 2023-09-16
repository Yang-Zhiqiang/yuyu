package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.ST_YuukoukykHtjynbknTmttd;

/**
 * 有効契約配当準備金（積立Ｄ）テーブル(ST_YuukoukykHtjynbknTmttdDao) アクセス用の DAO クラスです。<br />
 */
public class ST_YuukoukykHtjynbknTmttdDao extends AbstractDao<ST_YuukoukykHtjynbknTmttd> {

    public ST_YuukoukykHtjynbknTmttdDao() {
        super(ST_YuukoukykHtjynbknTmttd.class);
    }

    public ST_YuukoukykHtjynbknTmttd getYuukoukykHtjynbknTmttd(BizDate pSyoriYmd, String pKakutyoujobcd, String pSyono, String pSrkijyunym) {
        ST_YuukoukykHtjynbknTmttd sT_YuukoukykHtjynbknTmttd =  new ST_YuukoukykHtjynbknTmttd();
        sT_YuukoukykHtjynbknTmttd.setSyoriYmd(pSyoriYmd);
        sT_YuukoukykHtjynbknTmttd.setKakutyoujobcd(pKakutyoujobcd);
        sT_YuukoukykHtjynbknTmttd.setSyono(pSyono);
        sT_YuukoukykHtjynbknTmttd.setSrkijyunym(pSrkijyunym);
        return this.selectOne(sT_YuukoukykHtjynbknTmttd);
    }
}
