package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_PmnjtkKbn;
import yuyu.def.db.entity.HT_ImuSonotaTkykJktk;

/**
 * 医務査定その他特約条件付テーブル(HT_ImuSonotaTkykJktkDao) アクセス用の DAO クラスです。<br />
 */
public class HT_ImuSonotaTkykJktkDao extends AbstractDao<HT_ImuSonotaTkykJktk> {

    public HT_ImuSonotaTkykJktkDao() {
        super(HT_ImuSonotaTkykJktk.class);
    }

    @Deprecated
    public HT_ImuSonotaTkykJktk getImuSonotaTkykJktk(String pMosno,
         Integer pRenno,
         C_PmnjtkKbn pPmnjtkkbn){
        HT_ImuSonotaTkykJktk hT_ImuSonotaTkykJktk =  new HT_ImuSonotaTkykJktk();
        hT_ImuSonotaTkykJktk.setMosno(pMosno);
        hT_ImuSonotaTkykJktk.setRenno(pRenno);
        hT_ImuSonotaTkykJktk.setPmnjtkkbn(pPmnjtkkbn);
        return this.selectOne(hT_ImuSonotaTkykJktk);
    }

    @Override
    @Deprecated
    public List<HT_ImuSonotaTkykJktk> selectAll() {
        return super.selectAll();
    }
}
