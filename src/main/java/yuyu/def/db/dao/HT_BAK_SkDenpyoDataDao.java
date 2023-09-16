package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.db.entity.HT_BAK_SkDenpyoData;

/**
 * 新契約伝票データバックアップテーブル(HT_BAK_SkDenpyoDataDao) アクセス用の DAO クラスです。<br />
 */
public class HT_BAK_SkDenpyoDataDao extends AbstractDao<HT_BAK_SkDenpyoData> {

    public HT_BAK_SkDenpyoDataDao() {
        super(HT_BAK_SkDenpyoData.class);
    }

    public HT_BAK_SkDenpyoData getBAKSkDenpyoData(String pDenrenno,
        String pTrkssikibetukey,
        Integer pEdano){
        HT_BAK_SkDenpyoData hT_BAK_SkDenpyoData =  new HT_BAK_SkDenpyoData();
        hT_BAK_SkDenpyoData.setDenrenno(pDenrenno);
        hT_BAK_SkDenpyoData.setTrkssikibetukey(pTrkssikibetukey);
        hT_BAK_SkDenpyoData.setEdano(pEdano);
        return this.selectOne(hT_BAK_SkDenpyoData);
    }

    public List<HT_BAK_SkDenpyoData> getBAKSkDenpyoDatasBySyonoTrkssikibetukey(String pSyono, String pTrkssikibetukey) {

        HT_BAK_SkDenpyoData hT_BAK_SkDenpyoData =  new HT_BAK_SkDenpyoData();
        hT_BAK_SkDenpyoData.setSyono(pSyono);
        hT_BAK_SkDenpyoData.setTrkssikibetukey(pTrkssikibetukey);
        return this.select(hT_BAK_SkDenpyoData);
    }

    public List<HT_BAK_SkDenpyoData> getBAKSkDenpyoDatasByMosno(String pMosno) {

        HT_BAK_SkDenpyoData hT_BAK_SkDenpyoData =  new HT_BAK_SkDenpyoData();
        hT_BAK_SkDenpyoData.setMosno(pMosno);
        return this.select(hT_BAK_SkDenpyoData);
    }
}
