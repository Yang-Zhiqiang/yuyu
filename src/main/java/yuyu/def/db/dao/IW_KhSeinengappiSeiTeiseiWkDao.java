package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IW_KhSeinengappiSeiTeiseiWk;

/**
 * 被保険者生年月日・性訂正ワークテーブル(IW_KhSeinengappiSeiTeiseiWkDao) アクセス用の DAO クラスです。<br />
 */
public class IW_KhSeinengappiSeiTeiseiWkDao extends AbstractDao<IW_KhSeinengappiSeiTeiseiWk> {

    public IW_KhSeinengappiSeiTeiseiWkDao() {
        super(IW_KhSeinengappiSeiTeiseiWk.class);
    }

    public IW_KhSeinengappiSeiTeiseiWk getKhSeinengappiSeiTeiseiWk(String pKouteikanriid){
        IW_KhSeinengappiSeiTeiseiWk iW_KhSeinengappiSeiTeiseiWk =  new IW_KhSeinengappiSeiTeiseiWk();
        iW_KhSeinengappiSeiTeiseiWk.setKouteikanriid(pKouteikanriid);
        return this.selectOne(iW_KhSeinengappiSeiTeiseiWk);
    }
}
