package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.AM_IdCardYakusyoku;

/**
 * ＩＤカード役職マスタ(AM_IdCardYakusyokuDao) アクセス用の DAO クラスです。<br />
 */
public class AM_IdCardYakusyokuDao extends AbstractDao<AM_IdCardYakusyoku> {

    public AM_IdCardYakusyokuDao() {
        super(AM_IdCardYakusyoku.class);
    }

    public AM_IdCardYakusyoku getIdCardYakusyoku(String pIdkbn, String pIdcd, BizDate pYakusyokuhatureiymd, String pYakusyokuhatureino) {
        AM_IdCardYakusyoku aM_IdCardYakusyoku =  new AM_IdCardYakusyoku();
        aM_IdCardYakusyoku.setIdkbn(pIdkbn);
        aM_IdCardYakusyoku.setIdcd(pIdcd);
        aM_IdCardYakusyoku.setYakusyokuhatureiymd(pYakusyokuhatureiymd);
        aM_IdCardYakusyoku.setYakusyokuhatureino(pYakusyokuhatureino);
        return this.selectOne(aM_IdCardYakusyoku);
    }
}
