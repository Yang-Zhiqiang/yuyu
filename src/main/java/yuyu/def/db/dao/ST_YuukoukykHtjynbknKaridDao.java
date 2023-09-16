package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.ST_YuukoukykHtjynbknKarid;

/**
 * 有効契約配当準備金（仮割当Ｄ）テーブル(ST_YuukoukykHtjynbknKaridDao) アクセス用の DAO クラスです。<br />
 */
public class ST_YuukoukykHtjynbknKaridDao extends AbstractDao<ST_YuukoukykHtjynbknKarid> {

    public ST_YuukoukykHtjynbknKaridDao() {
        super(ST_YuukoukykHtjynbknKarid.class);
    }

    public ST_YuukoukykHtjynbknKarid getYuukoukykHtjynbknKarid(BizDate pSyoriYmd, String pKakutyoujobcd, String pSyono, String pSrkijyunym) {
        ST_YuukoukykHtjynbknKarid sT_YuukoukykHtjynbknKarid =  new ST_YuukoukykHtjynbknKarid();
        sT_YuukoukykHtjynbknKarid.setSyoriYmd(pSyoriYmd);
        sT_YuukoukykHtjynbknKarid.setKakutyoujobcd(pKakutyoujobcd);
        sT_YuukoukykHtjynbknKarid.setSyono(pSyono);
        sT_YuukoukykHtjynbknKarid.setSrkijyunym(pSrkijyunym);
        return this.selectOne(sT_YuukoukykHtjynbknKarid);
    }
}
