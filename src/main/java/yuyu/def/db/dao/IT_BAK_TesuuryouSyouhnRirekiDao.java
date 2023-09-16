package yuyu.def.db.dao;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TsrysyoriKbn;
import yuyu.def.db.entity.IT_BAK_TesuuryouSyouhnRireki;

/**
 * 手数料情報商品履歴バックアップテーブル(IT_BAK_TesuuryouSyouhnRirekiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_BAK_TesuuryouSyouhnRirekiDao extends AbstractDao<IT_BAK_TesuuryouSyouhnRireki> {

    public IT_BAK_TesuuryouSyouhnRirekiDao() {
        super(IT_BAK_TesuuryouSyouhnRireki.class);
    }

    @Deprecated
    public IT_BAK_TesuuryouSyouhnRireki getBAKTesuuryouSyouhnRireki(String pSyono,
         String pTrkssikibetukey,
         C_TsrysyoriKbn pTsrysyorikbn,
         Integer pRenno,
         C_SyutkKbn pSyutkkbn,
         String pSyouhncd,
         Integer pSyouhnsdno,
         Integer pKyksyouhnrenno){
        IT_BAK_TesuuryouSyouhnRireki iT_BAK_TesuuryouSyouhnRireki =  new IT_BAK_TesuuryouSyouhnRireki();
        iT_BAK_TesuuryouSyouhnRireki.setSyono(pSyono);
        iT_BAK_TesuuryouSyouhnRireki.setTrkssikibetukey(pTrkssikibetukey);
        iT_BAK_TesuuryouSyouhnRireki.setTsrysyorikbn(pTsrysyorikbn);
        iT_BAK_TesuuryouSyouhnRireki.setRenno(pRenno);
        iT_BAK_TesuuryouSyouhnRireki.setSyutkkbn(pSyutkkbn);
        iT_BAK_TesuuryouSyouhnRireki.setSyouhncd(pSyouhncd);
        iT_BAK_TesuuryouSyouhnRireki.setSyouhnsdno(pSyouhnsdno);
        iT_BAK_TesuuryouSyouhnRireki.setKyksyouhnrenno(pKyksyouhnrenno);
        return this.selectOne(iT_BAK_TesuuryouSyouhnRireki);
    }

    @Override
    @Deprecated
    public List<IT_BAK_TesuuryouSyouhnRireki> selectAll() {
        return super.selectAll();
    }
}
