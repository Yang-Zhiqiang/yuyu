package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.IW_KhHubiKaisyouDetailWk;

/**
 * 契約保全不備解消詳細ワークテーブル(IW_KhHubiKaisyouDetailWkDao) アクセス用の DAO クラスです。<br />
 */
public class IW_KhHubiKaisyouDetailWkDao extends AbstractDao<IW_KhHubiKaisyouDetailWk> {

    public IW_KhHubiKaisyouDetailWkDao() {
        super(IW_KhHubiKaisyouDetailWk.class);
    }

    public IW_KhHubiKaisyouDetailWk getKhHubiKaisyouDetailWk(String pKouteikanriid,
        Integer pRenno3keta){
        IW_KhHubiKaisyouDetailWk iW_KhHubiKaisyouDetailWk =  new IW_KhHubiKaisyouDetailWk();
        iW_KhHubiKaisyouDetailWk.setKouteikanriid(pKouteikanriid);
        iW_KhHubiKaisyouDetailWk.setRenno3keta(pRenno3keta);
        return this.selectOne(iW_KhHubiKaisyouDetailWk);
    }

    public List<IW_KhHubiKaisyouDetailWk> getKhHubiKaisyouDetailWksByKouteikanriid(String pKouteikanriid){


        IW_KhHubiKaisyouDetailWk iW_KhHubiKaisyouDetailWk = new IW_KhHubiKaisyouDetailWk();
        iW_KhHubiKaisyouDetailWk.setKouteikanriid(pKouteikanriid);


        return select(iW_KhHubiKaisyouDetailWk);
    }
}
