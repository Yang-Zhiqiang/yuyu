package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_SyouhnTokujouRireki;
import yuyu.def.db.meta.QIT_SyouhnTokujouRireki;

/**
 * 商品特条履歴テーブル(IT_SyouhnTokujouRirekiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_SyouhnTokujouRirekiDao extends AbstractDao<IT_SyouhnTokujouRireki> {

    public IT_SyouhnTokujouRirekiDao() {
        super(IT_SyouhnTokujouRireki.class);
    }

    @Deprecated
    public IT_SyouhnTokujouRireki getSyouhnTokujouRireki(String pSyono,
        C_SyutkKbn pSyutkkbn,
        String pSyouhncd,
        Integer pSyouhnsdno,
        Integer pKyksyouhnrenno,
        String pHenkousikibetukey){
        IT_SyouhnTokujouRireki iT_SyouhnTokujouRireki =  new IT_SyouhnTokujouRireki();
        iT_SyouhnTokujouRireki.setSyono(pSyono);
        iT_SyouhnTokujouRireki.setSyutkkbn(pSyutkkbn);
        iT_SyouhnTokujouRireki.setSyouhncd(pSyouhncd);
        iT_SyouhnTokujouRireki.setSyouhnsdno(pSyouhnsdno);
        iT_SyouhnTokujouRireki.setKyksyouhnrenno(pKyksyouhnrenno);
        iT_SyouhnTokujouRireki.setHenkousikibetukey(pHenkousikibetukey);
        return this.selectOne(iT_SyouhnTokujouRireki);
    }

    @Override
    @Deprecated
    public List<IT_SyouhnTokujouRireki> selectAll() {
        return super.selectAll();
    }

    public List<IT_SyouhnTokujouRireki> getSyouhnTokujouRirekisBySyonoMaxHenkousikibetukey(String pSyono) {

        QIT_SyouhnTokujouRireki qiT_SyouhnTokujouRireki=new QIT_SyouhnTokujouRireki();

        String subQuerry = $SELECT + $MAX(qiT_SyouhnTokujouRireki.henkousikibetukey) +
            $FROM + qiT_SyouhnTokujouRireki.IT_SyouhnTokujouRireki() +
            $WHERE + qiT_SyouhnTokujouRireki.syono.eq(pSyono);

        String mainQuerry = $SELECT + qiT_SyouhnTokujouRireki +
            $FROM + qiT_SyouhnTokujouRireki.IT_SyouhnTokujouRireki() +
            $WHERE + qiT_SyouhnTokujouRireki.syono.eq(pSyono) +
            $AND + qiT_SyouhnTokujouRireki.henkousikibetukey +
            $EQ + $(subQuerry) +
            $ORDER_BY(qiT_SyouhnTokujouRireki.kyksyouhnrenno.asc());


        return em.createJPQL(mainQuerry).bind(qiT_SyouhnTokujouRireki).getResultList();
    }
}
