package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.BW_IdCardYakusyokuWk;

/**
 * ＩＤカード役職マスタワークテーブル(BW_IdCardYakusyokuWkDao) アクセス用の DAO クラスです。<br />
 */
public class BW_IdCardYakusyokuWkDao extends AbstractDao<BW_IdCardYakusyokuWk> {

    public BW_IdCardYakusyokuWkDao() {
        super(BW_IdCardYakusyokuWk.class);
    }

    public BW_IdCardYakusyokuWk getIdCardYakusyokuWk(String pIdkbn, String pIdcd, BizDate pYakusyokuhatureiymd, String pYakusyokuhatureino) {
        BW_IdCardYakusyokuWk bW_IdCardYakusyokuWk =  new BW_IdCardYakusyokuWk();
        bW_IdCardYakusyokuWk.setIdkbn(pIdkbn);
        bW_IdCardYakusyokuWk.setIdcd(pIdcd);
        bW_IdCardYakusyokuWk.setYakusyokuhatureiymd(pYakusyokuhatureiymd);
        bW_IdCardYakusyokuWk.setYakusyokuhatureino(pYakusyokuhatureino);
        return this.selectOne(bW_IdCardYakusyokuWk);
    }
}
