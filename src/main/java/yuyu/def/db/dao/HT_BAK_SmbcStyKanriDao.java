package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.HT_BAK_SmbcStyKanri;

/**
 * ＳＭＢＣ進捗管理バックアップテーブル(HT_BAK_SmbcStyKanriDao) アクセス用の DAO クラスです。<br />
 */
public class HT_BAK_SmbcStyKanriDao extends AbstractDao<HT_BAK_SmbcStyKanri> {

    public HT_BAK_SmbcStyKanriDao() {
        super(HT_BAK_SmbcStyKanri.class);
    }

    public HT_BAK_SmbcStyKanri getBAKSmbcStyKanri(BizDate pDatarenymd,
            String pTrkssikibetukey,
            BizNumber pDatasakuseirenno){
        HT_BAK_SmbcStyKanri hT_BAK_SmbcStyKanri =  new HT_BAK_SmbcStyKanri();
        hT_BAK_SmbcStyKanri.setDatarenymd(pDatarenymd);
        hT_BAK_SmbcStyKanri.setTrkssikibetukey(pTrkssikibetukey);
        hT_BAK_SmbcStyKanri.setDatasakuseirenno(pDatasakuseirenno);
        return this.selectOne(hT_BAK_SmbcStyKanri);
    }

    public List<HT_BAK_SmbcStyKanri> getBAKSmbcStyKanrisBySyonoTrkssikibetukey(String pSyono, String pTrkssikibetukey) {

        HT_BAK_SmbcStyKanri hT_BAK_SmbcStyKanri = new HT_BAK_SmbcStyKanri();
        hT_BAK_SmbcStyKanri.setSyono(pSyono);
        hT_BAK_SmbcStyKanri.setTrkssikibetukey(pTrkssikibetukey);
        return this.select(hT_BAK_SmbcStyKanri);
    }

    public List<HT_BAK_SmbcStyKanri> getBAKSmbcStyKanrisByMosno(String pMosno) {

        HT_BAK_SmbcStyKanri hT_BAK_SmbcStyKanri = new HT_BAK_SmbcStyKanri();
        hT_BAK_SmbcStyKanri.setMosno(pMosno);
        return this.select(hT_BAK_SmbcStyKanri);
    }
}
