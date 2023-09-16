package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.HT_SkLincTourokuInfo;

/**
 * 新契約ＬＩＮＣ登録情報テーブル(HT_SkLincTourokuInfoDao) アクセス用の DAO クラスです。<br />
 */
public class HT_SkLincTourokuInfoDao extends AbstractDao<HT_SkLincTourokuInfo> {

    public HT_SkLincTourokuInfoDao() {
        super(HT_SkLincTourokuInfo.class);
    }

    @Deprecated
    public HT_SkLincTourokuInfo getSkLincTourokuInfo(String pMosno){
        HT_SkLincTourokuInfo hT_SkLincTourokuInfo =  new HT_SkLincTourokuInfo();
        hT_SkLincTourokuInfo.setMosno(pMosno);
        return this.selectOne(hT_SkLincTourokuInfo);
    }

    @Override
    @Deprecated
    public List<HT_SkLincTourokuInfo> selectAll() {
        return super.selectAll();
    }
}
