package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TsrysyoriKbn;
import yuyu.def.db.entity.IT_TesuuryouSyouhnRireki;

/**
 * 手数料情報商品履歴テーブル(IT_TesuuryouSyouhnRirekiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_TesuuryouSyouhnRirekiDao extends AbstractDao<IT_TesuuryouSyouhnRireki> {

    public IT_TesuuryouSyouhnRirekiDao() {
        super(IT_TesuuryouSyouhnRireki.class);
    }

    @Deprecated
    public IT_TesuuryouSyouhnRireki getTesuuryouSyouhnRireki(String pSyono,
         C_TsrysyoriKbn pTsrysyorikbn,
         Integer pRenno,
         C_SyutkKbn pSyutkkbn,
         String pSyouhncd,
         Integer pSyouhnsdno,
         Integer pKyksyouhnrenno){
        IT_TesuuryouSyouhnRireki iT_TesuuryouSyouhnRireki =  new IT_TesuuryouSyouhnRireki();
        iT_TesuuryouSyouhnRireki.setSyono(pSyono);
        iT_TesuuryouSyouhnRireki.setTsrysyorikbn(pTsrysyorikbn);
        iT_TesuuryouSyouhnRireki.setRenno(pRenno);
        iT_TesuuryouSyouhnRireki.setSyutkkbn(pSyutkkbn);
        iT_TesuuryouSyouhnRireki.setSyouhncd(pSyouhncd);
        iT_TesuuryouSyouhnRireki.setSyouhnsdno(pSyouhnsdno);
        iT_TesuuryouSyouhnRireki.setKyksyouhnrenno(pKyksyouhnrenno);
        return this.selectOne(iT_TesuuryouSyouhnRireki);
    }

    @Override
    @Deprecated
    public List<IT_TesuuryouSyouhnRireki> selectAll() {
        return super.selectAll();
    }
}
