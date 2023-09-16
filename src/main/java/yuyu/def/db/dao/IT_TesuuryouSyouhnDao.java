package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TsrysyoriKbn;
import yuyu.def.db.entity.IT_TesuuryouSyouhn;

/**
 * 手数料情報商品テーブル(IT_TesuuryouSyouhnDao) アクセス用の DAO クラスです。<br />
 */
public class IT_TesuuryouSyouhnDao extends AbstractDao<IT_TesuuryouSyouhn> {

    public IT_TesuuryouSyouhnDao() {
        super(IT_TesuuryouSyouhn.class);
    }

    @Deprecated
    public IT_TesuuryouSyouhn getTesuuryouSyouhn(String pSyono,
         C_TsrysyoriKbn pTsrysyorikbn,
         Integer pRenno,
         C_SyutkKbn pSyutkkbn,
         String pSyouhncd,
         Integer pSyouhnsdno,
         Integer pKyksyouhnrenno){
        IT_TesuuryouSyouhn iT_TesuuryouSyouhn =  new IT_TesuuryouSyouhn();
        iT_TesuuryouSyouhn.setSyono(pSyono);
        iT_TesuuryouSyouhn.setTsrysyorikbn(pTsrysyorikbn);
        iT_TesuuryouSyouhn.setRenno(pRenno);
        iT_TesuuryouSyouhn.setSyutkkbn(pSyutkkbn);
        iT_TesuuryouSyouhn.setSyouhncd(pSyouhncd);
        iT_TesuuryouSyouhn.setSyouhnsdno(pSyouhnsdno);
        iT_TesuuryouSyouhn.setKyksyouhnrenno(pKyksyouhnrenno);
        return this.selectOne(iT_TesuuryouSyouhn);
    }

    @Override
    @Deprecated
    public List<IT_TesuuryouSyouhn> selectAll() {
        return super.selectAll();
    }
}
