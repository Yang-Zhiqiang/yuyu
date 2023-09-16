package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_TsrysyoriKbn;
import yuyu.def.db.entity.IT_BAK_Tesuuryou;

/**
 * 手数料情報バックアップテーブル(IT_BAK_TesuuryouDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_TesuuryouDao extends AbstractDao<IT_BAK_Tesuuryou> {

    public IT_BAK_TesuuryouDao() {
        super(IT_BAK_Tesuuryou.class);
    }

    @Deprecated
    public IT_BAK_Tesuuryou getBAKTesuuryou(String pSyono,
         String pTrkssikibetukey,
         C_TsrysyoriKbn pTsrysyorikbn,
         Integer pRenno){
        IT_BAK_Tesuuryou iT_BAK_Tesuuryou =  new IT_BAK_Tesuuryou();
        iT_BAK_Tesuuryou.setSyono(pSyono);
        iT_BAK_Tesuuryou.setTrkssikibetukey(pTrkssikibetukey);
        iT_BAK_Tesuuryou.setTsrysyorikbn(pTsrysyorikbn);
        iT_BAK_Tesuuryou.setRenno(pRenno);
        return this.selectOne(iT_BAK_Tesuuryou);
    }

    @Override
    @Deprecated
    public List<IT_BAK_Tesuuryou> selectAll() {
        return super.selectAll();
    }
}
