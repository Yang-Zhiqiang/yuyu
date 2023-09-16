package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_KykSyouhnRireki;
import yuyu.def.db.meta.QIT_KykSyouhnRireki;

/**
 * 契約商品履歴テーブル(IT_KykSyouhnRirekiDao) アクセス用の DAO クラスです。<br />
 */
public class IT_KykSyouhnRirekiDao extends AbstractDao<IT_KykSyouhnRireki> {

    public IT_KykSyouhnRirekiDao() {
        super(IT_KykSyouhnRireki.class);
    }

    @Deprecated
    public IT_KykSyouhnRireki getKykSyouhnRireki(String pSyono,
        C_SyutkKbn pSyutkkbn,
        String pSyouhncd,
        Integer pSyouhnsdno,
        Integer pKyksyouhnrenno,
        String pHenkousikibetukey){
        IT_KykSyouhnRireki iT_KykSyouhnRireki =  new IT_KykSyouhnRireki();
        iT_KykSyouhnRireki.setSyono(pSyono);
        iT_KykSyouhnRireki.setSyutkkbn(pSyutkkbn);
        iT_KykSyouhnRireki.setSyouhncd(pSyouhncd);
        iT_KykSyouhnRireki.setSyouhnsdno(pSyouhnsdno);
        iT_KykSyouhnRireki.setKyksyouhnrenno(pKyksyouhnrenno);
        iT_KykSyouhnRireki.setHenkousikibetukey(pHenkousikibetukey);
        return this.selectOne(iT_KykSyouhnRireki);
    }

    @Override
    @Deprecated
    public List<IT_KykSyouhnRireki> selectAll() {
        return super.selectAll();
    }

    public List<IT_KykSyouhnRireki> getKykSyouhnRirekisBySyonoKouryokuhasseiymdGt(String pSyono,
        BizDate pKouryokuhasseiymd) {

        QIT_KykSyouhnRireki qIT_KykSyouhnRireki = new QIT_KykSyouhnRireki();
        String querySql = $SELECT + qIT_KykSyouhnRireki +
            $FROM + qIT_KykSyouhnRireki.IT_KykSyouhnRireki() +
            $WHERE + qIT_KykSyouhnRireki.syono.eq(pSyono) +
            $AND + qIT_KykSyouhnRireki.kouryokuhasseiymd.gt(pKouryokuhasseiymd);
        return em.createJPQL(querySql).bind(qIT_KykSyouhnRireki).getResultList();
    }

    public List<IT_KykSyouhnRireki> getKykSyouhnRirekisBySyonoMaxHenkousikibetukey(String pSyono) {

        QIT_KykSyouhnRireki qIT_KykSyouhnRireki = new QIT_KykSyouhnRireki();

        String subQuerry = $SELECT + $MAX(qIT_KykSyouhnRireki.henkousikibetukey) +
            $FROM + qIT_KykSyouhnRireki.IT_KykSyouhnRireki() +
            $WHERE + qIT_KykSyouhnRireki.syono.eq(pSyono);

        String mainQuerry = $SELECT + qIT_KykSyouhnRireki +
            $FROM + qIT_KykSyouhnRireki.IT_KykSyouhnRireki() +
            $WHERE + qIT_KykSyouhnRireki.syono.eq(pSyono) +
            $AND + qIT_KykSyouhnRireki.henkousikibetukey +
            $EQ + $(subQuerry) +
            $ORDER_BY(qIT_KykSyouhnRireki.kyksyouhnrenno.asc());


        return em.createJPQL(mainQuerry).bind(qIT_KykSyouhnRireki).getResultList();
    }

    public BizDate getKykSyouhnRirekiMinKouryokuhasseiymdBySyonoSyouhncdSyouhnsdno(String pSyono, String pSyouhncd,
        Integer pSyouhnsdno) {


        QIT_KykSyouhnRireki qIT_KykSyouhnRireki = new QIT_KykSyouhnRireki();

        String querySql = $SELECT + $MIN(qIT_KykSyouhnRireki.kouryokuhasseiymd) +
            $FROM + qIT_KykSyouhnRireki.IT_KykSyouhnRireki() +
            $WHERE + qIT_KykSyouhnRireki.syono.eq(pSyono) +
            $AND + qIT_KykSyouhnRireki.syouhncd.eq(pSyouhncd) +
            $AND + qIT_KykSyouhnRireki.syouhnsdno.eq(pSyouhnsdno) +
            $AND + qIT_KykSyouhnRireki.kykjyoutai.eq(C_Kykjyoutai.PMEN);

        return em.createJPQL(querySql).bind(qIT_KykSyouhnRireki).getSingleResult();
    }

    public BizDate getKykSyouhnRirekiMinKouryokuhasseiymdBySyonoSyouhncdSyouhnsdnoKykjyoutai(String pSyono,
        String pSyouhncd, Integer pSyouhnsdno, C_Kykjyoutai pKykjyoutai) {


        QIT_KykSyouhnRireki qIT_KykSyouhnRireki = new QIT_KykSyouhnRireki();

        String querySql = $SELECT + $MIN(qIT_KykSyouhnRireki.kouryokuhasseiymd) +
            $FROM + qIT_KykSyouhnRireki.IT_KykSyouhnRireki() +
            $WHERE + qIT_KykSyouhnRireki.syono.eq(pSyono) +
            $AND + qIT_KykSyouhnRireki.syouhncd.eq(pSyouhncd) +
            $AND + qIT_KykSyouhnRireki.syouhnsdno.eq(pSyouhnsdno) +
            $AND + qIT_KykSyouhnRireki.kykjyoutai.eq(pKykjyoutai);

        return em.createJPQL(querySql).bind(qIT_KykSyouhnRireki).getSingleResult();
    }

    public List<IT_KykSyouhnRireki> getKykSyouhnRirekisBySyonoKouryokuhasseiymd(String pSyono,
        BizDate pKouryokuhasseiymd) {


        QIT_KykSyouhnRireki qIT_KykSyouhnRireki = new QIT_KykSyouhnRireki();

        String querySql = $SELECT + qIT_KykSyouhnRireki +
            $FROM + qIT_KykSyouhnRireki.IT_KykSyouhnRireki() +
            $WHERE + qIT_KykSyouhnRireki.syono.eq(pSyono) +
            $AND + qIT_KykSyouhnRireki.kouryokuhasseiymd.ne(qIT_KykSyouhnRireki.kykymd) +
            $AND + qIT_KykSyouhnRireki.kouryokuhasseiymd.gt(pKouryokuhasseiymd);

        return em.createJPQL(querySql).bind(qIT_KykSyouhnRireki).getResultList();
    }

    public List<IT_KykSyouhnRireki> getKykSyouhnRirekisByPk(String pSyono, C_SyutkKbn pSyutkkbn, String pSyouhncd,
        Integer pSyouhnsdno, Integer pKyksyouhnrenno) {


        QIT_KykSyouhnRireki qIT_KykSyouhnRireki = new QIT_KykSyouhnRireki();


        String querySql = $SELECT + qIT_KykSyouhnRireki +
            $FROM (qIT_KykSyouhnRireki) +
            $WHERE + qIT_KykSyouhnRireki.syono.eq(pSyono) +
            $AND + qIT_KykSyouhnRireki.syutkkbn.eq(pSyutkkbn) +
            $AND + qIT_KykSyouhnRireki.syouhncd.eq(pSyouhncd) +
            $AND + qIT_KykSyouhnRireki.syouhnsdno.eq(pSyouhnsdno) +
            $AND + qIT_KykSyouhnRireki.kyksyouhnrenno.eq(pKyksyouhnrenno) +
            $ORDER_BY(qIT_KykSyouhnRireki.henkousikibetukey.desc());


        return em.createJPQL(querySql).bind(qIT_KykSyouhnRireki).getResultList();
    }
}
