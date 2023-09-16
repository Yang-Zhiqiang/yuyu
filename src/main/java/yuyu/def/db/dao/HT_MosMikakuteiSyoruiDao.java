package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.HT_MosMikakuteiSyorui;

/**
 * 申込未確定書類テーブル(HT_MosMikakuteiSyoruiDao) アクセス用の DAO クラスです。<br />
 */
public class HT_MosMikakuteiSyoruiDao extends AbstractDao<HT_MosMikakuteiSyorui> {

    public HT_MosMikakuteiSyoruiDao() {
        super(HT_MosMikakuteiSyorui.class);
    }

    public HT_MosMikakuteiSyorui getMosMikakuteiSyorui(String pDocumentid){
        HT_MosMikakuteiSyorui hT_MosMikakuteiSyorui =  new HT_MosMikakuteiSyorui();
        hT_MosMikakuteiSyorui.setDocumentid(pDocumentid);
        return this.selectOne(hT_MosMikakuteiSyorui);
    }

    public List<HT_MosMikakuteiSyorui> getMosMikakuteiSyoruisByMosno(String pMosno) {


        HT_MosMikakuteiSyorui hT_MosMikakuteiSyorui = new HT_MosMikakuteiSyorui();

        hT_MosMikakuteiSyorui.setMosno(pMosno);


        return this.select(hT_MosMikakuteiSyorui);
    }

}
