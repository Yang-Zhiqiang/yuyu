package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_LincsoujyusinsysKbn;
import yuyu.def.db.entity.HT_SkLincSousinInfo;

/**
 * 新契約ＬＩＮＣ送信情報テーブル(HT_SkLincSousinInfoDao) アクセス用の DAO クラスです。<br />
 */
public class HT_SkLincSousinInfoDao extends AbstractDao<HT_SkLincSousinInfo> {

    public HT_SkLincSousinInfoDao() {
        super(HT_SkLincSousinInfo.class);
    }

    public HT_SkLincSousinInfo getSkLincSousinInfo(C_LincsoujyusinsysKbn pLincsoujyusinsyskbn,
            String pMosno,
            Integer pRenno){
        HT_SkLincSousinInfo hT_SkLincSousinInfo =  new HT_SkLincSousinInfo();
        hT_SkLincSousinInfo.setLincsoujyusinsyskbn(pLincsoujyusinsyskbn);
        hT_SkLincSousinInfo.setMosno(pMosno);
        hT_SkLincSousinInfo.setRenno(pRenno);
        return this.selectOne(hT_SkLincSousinInfo);
    }

    public List<HT_SkLincSousinInfo> getSkLincSousinInfosByMosno(String pMosno) {
        HT_SkLincSousinInfo hT_SkLincSousinInfo =  new HT_SkLincSousinInfo();
        hT_SkLincSousinInfo.setMosno(pMosno);
        return this.select(hT_SkLincSousinInfo);
    }
}
