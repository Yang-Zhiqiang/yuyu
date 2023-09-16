package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_LincsoujyusinsysKbn;
import yuyu.def.db.entity.HT_SkLincJyusinInfo;

/**
 * 新契約ＬＩＮＣ受信情報テーブル(HT_SkLincJyusinInfoDao) アクセス用の DAO クラスです。<br />
 */
public class HT_SkLincJyusinInfoDao extends AbstractDao<HT_SkLincJyusinInfo> {

    public HT_SkLincJyusinInfoDao() {
        super(HT_SkLincJyusinInfo.class);
    }

    public HT_SkLincJyusinInfo getSkLincJyusinInfo(C_LincsoujyusinsysKbn pLincsoujyusinsyskbn,
            String pLinckyknaiykekdatarenno,
            BizDate pSyoriYmd,
            String pMosno,
            BizNumber pRenno2,
            BizDate pSousinymd){
        HT_SkLincJyusinInfo hT_SkLincJyusinInfo =  new HT_SkLincJyusinInfo();
        hT_SkLincJyusinInfo.setLincsoujyusinsyskbn(pLincsoujyusinsyskbn);
        hT_SkLincJyusinInfo.setLinckyknaiykekdatarenno(pLinckyknaiykekdatarenno);
        hT_SkLincJyusinInfo.setSyoriYmd(pSyoriYmd);
        hT_SkLincJyusinInfo.setMosno(pMosno);
        hT_SkLincJyusinInfo.setRenno2(pRenno2);
        hT_SkLincJyusinInfo.setSousinymd(pSousinymd);
        return this.selectOne(hT_SkLincJyusinInfo);
    }

    public List<HT_SkLincJyusinInfo> getSkLincJyusinInfosByMosno(String pMosno) {
        HT_SkLincJyusinInfo hT_SkLincJyusinInfo =  new HT_SkLincJyusinInfo();
        hT_SkLincJyusinInfo.setMosno(pMosno);
        return this.select(hT_SkLincJyusinInfo);
    }
}
