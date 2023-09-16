package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.def.classification.C_AnsyuusysKbn;
import yuyu.def.db.entity.HT_SkSyuunouKekkaData;

/**
 * 新契約収納結果データテーブル(HT_SkSyuunouKekkaDataDao) アクセス用の DAO クラスです。<br />
 */
public class HT_SkSyuunouKekkaDataDao extends AbstractDao<HT_SkSyuunouKekkaData> {

    public HT_SkSyuunouKekkaDataDao() {
        super(HT_SkSyuunouKekkaData.class);
    }

    public HT_SkSyuunouKekkaData getSkSyuunouKekkaData(C_AnsyuusysKbn pAnsyuusyskbn,
            BizDate pSyoriYmd,
            String pMosno,
            BizDateYM pJyuutouym){
        HT_SkSyuunouKekkaData hT_SkSyuunouKekkaData =  new HT_SkSyuunouKekkaData();
        hT_SkSyuunouKekkaData.setAnsyuusyskbn(pAnsyuusyskbn);
        hT_SkSyuunouKekkaData.setSyoriYmd(pSyoriYmd);
        hT_SkSyuunouKekkaData.setMosno(pMosno);
        hT_SkSyuunouKekkaData.setJyuutouym(pJyuutouym);
        return this.selectOne(hT_SkSyuunouKekkaData);
    }

    public List<HT_SkSyuunouKekkaData> getSkSyuunouKekkaDatasByMosno(String pMosno) {
        HT_SkSyuunouKekkaData hT_SkSyuunouKekkaData = new HT_SkSyuunouKekkaData();
        hT_SkSyuunouKekkaData.setMosno(pMosno);
        return this.select(hT_SkSyuunouKekkaData);
    }
}
