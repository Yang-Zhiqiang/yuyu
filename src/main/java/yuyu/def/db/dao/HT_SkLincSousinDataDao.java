package yuyu.def.db.dao;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.entity.HT_SkLincSousinData;

/**
 * 新契約ＬＩＮＣ送信データテーブル(HT_SkLincSousinDataDao) アクセス用の DAO クラスです。<br />
 */
public class HT_SkLincSousinDataDao extends AbstractDao<HT_SkLincSousinData> {

    public HT_SkLincSousinDataDao() {
        super(HT_SkLincSousinData.class);
    }

    public HT_SkLincSousinData getSkLincSousinData(String pMosno, BizDate pSyoriYmd, Integer pRenno) {
        HT_SkLincSousinData hT_SkLincSousinData =  new HT_SkLincSousinData();
        hT_SkLincSousinData.setMosno(pMosno);
        hT_SkLincSousinData.setSyoriYmd(pSyoriYmd);
        hT_SkLincSousinData.setRenno(pRenno);
        return this.selectOne(hT_SkLincSousinData);
    }
}
