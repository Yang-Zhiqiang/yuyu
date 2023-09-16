package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TsrysyoriKbn;
import yuyu.def.db.entity.IT_BAK_TesuuryouSyouhn;

/**
 * 手数料情報商品バックアップテーブル(IT_BAK_TesuuryouSyouhnDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_TesuuryouSyouhnDao extends AbstractDao<IT_BAK_TesuuryouSyouhn> {

    public IT_BAK_TesuuryouSyouhnDao() {
        super(IT_BAK_TesuuryouSyouhn.class);
    }

    @Deprecated
    public IT_BAK_TesuuryouSyouhn getBAKTesuuryouSyouhn(String pSyono,
         String pTrkssikibetukey,
         C_TsrysyoriKbn pTsrysyorikbn,
         Integer pRenno,
         C_SyutkKbn pSyutkkbn,
         String pSyouhncd,
         Integer pSyouhnsdno,
         Integer pKyksyouhnrenno){
        IT_BAK_TesuuryouSyouhn iT_BAK_TesuuryouSyouhn =  new IT_BAK_TesuuryouSyouhn();
        iT_BAK_TesuuryouSyouhn.setSyono(pSyono);
        iT_BAK_TesuuryouSyouhn.setTrkssikibetukey(pTrkssikibetukey);
        iT_BAK_TesuuryouSyouhn.setTsrysyorikbn(pTsrysyorikbn);
        iT_BAK_TesuuryouSyouhn.setRenno(pRenno);
        iT_BAK_TesuuryouSyouhn.setSyutkkbn(pSyutkkbn);
        iT_BAK_TesuuryouSyouhn.setSyouhncd(pSyouhncd);
        iT_BAK_TesuuryouSyouhn.setSyouhnsdno(pSyouhnsdno);
        iT_BAK_TesuuryouSyouhn.setKyksyouhnrenno(pKyksyouhnrenno);
        return this.selectOne(iT_BAK_TesuuryouSyouhn);
    }

    @Override
    @Deprecated
    public List<IT_BAK_TesuuryouSyouhn> selectAll() {
        return super.selectAll();
    }
}
