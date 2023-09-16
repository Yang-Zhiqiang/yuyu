package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.db.entity.JM_SiSyouhnZokusei;
import yuyu.def.db.meta.QJM_Kyuuhu;
import yuyu.def.db.meta.QJM_SiSyouhnZokusei;

/**
 * 支払商品属性マスタ(JM_SiSyouhnZokuseiDao) アクセス用の DAO クラスです。<br />
 */
public class JM_SiSyouhnZokuseiDao extends AbstractDao<JM_SiSyouhnZokusei> {

    public JM_SiSyouhnZokuseiDao() {
        super(JM_SiSyouhnZokusei.class);
    }

    public JM_SiSyouhnZokusei getSiSyouhnZokusei(String pSyouhncd,
        C_KyhgndkataKbn pKyhgndkatakbn,
        Integer pSyouhnsdno,
        String pKyuuhucd){
        JM_SiSyouhnZokusei jM_SiSyouhnZokusei =  new JM_SiSyouhnZokusei();
        jM_SiSyouhnZokusei.setSyouhncd(pSyouhncd);
        jM_SiSyouhnZokusei.setKyhgndkatakbn(pKyhgndkatakbn);
        jM_SiSyouhnZokusei.setSyouhnsdno(pSyouhnsdno);
        jM_SiSyouhnZokusei.setKyuuhucd(pKyuuhucd);
        return this.selectOne(jM_SiSyouhnZokusei);
    }

    public List<JM_SiSyouhnZokusei> getSiSyouhnZokuseisBySyouhncdKyhgndkatakbnSyouhnsdno(String pSyouhncd,
        C_KyhgndkataKbn pKyhgndkatakbn, Integer pSyouhnsdno) {
        JM_SiSyouhnZokusei jM_SiSyouhnZokusei =  new JM_SiSyouhnZokusei();
        jM_SiSyouhnZokusei.setSyouhncd(pSyouhncd);
        jM_SiSyouhnZokusei.setKyhgndkatakbn(pKyhgndkatakbn);
        jM_SiSyouhnZokusei.setSyouhnsdno(pSyouhnsdno);
        return this.select(jM_SiSyouhnZokusei);
    }

    public List<JM_SiSyouhnZokusei> getSiSyouhnZokuseisBySyouhncdSyouhnsdno(String pSyouhncd, Integer pSyouhnsdno) {


        JM_SiSyouhnZokusei jm_SiSyouhnZokusei = new JM_SiSyouhnZokusei();
        jm_SiSyouhnZokusei.setSyouhncd(pSyouhncd);
        jm_SiSyouhnZokusei.setSyouhnsdno(pSyouhnsdno);


        return select(jm_SiSyouhnZokusei);
    }


    public List<JM_SiSyouhnZokusei> getSiSyouhnZokuseisByKyuuhu(String pSyouhncd, C_KyhgndkataKbn pKyhgndkatakbn, Integer pSyouhnsdno) {


        QJM_SiSyouhnZokusei qJM_SiSyouhnZokusei = new QJM_SiSyouhnZokusei();
        QJM_Kyuuhu qJM_Kyuuhu = new QJM_Kyuuhu();


        String strSql = $SELECT + qJM_SiSyouhnZokusei +
            $FROM + qJM_SiSyouhnZokusei.JM_SiSyouhnZokusei() +"," +
            qJM_Kyuuhu.JM_Kyuuhu() +
            $WHERE + qJM_SiSyouhnZokusei.syouhncd.eq(pSyouhncd) +
            $AND + qJM_SiSyouhnZokusei.kyhgndkatakbn.eq(pKyhgndkatakbn) +
            $AND + qJM_SiSyouhnZokusei.syouhnsdno.eq(pSyouhnsdno) +
            $AND + qJM_Kyuuhu.kyuuhucd.eq(qJM_SiSyouhnZokusei.kyuuhucd);


        return em.createJPQL(strSql).bind(qJM_SiSyouhnZokusei, qJM_Kyuuhu).getResultList();
    }

    public JM_SiSyouhnZokusei getSiSyouhnZokuseisBySyouhncd(String pSyouhncd) {


        JM_SiSyouhnZokusei jm_SiSyouhnZokusei = new JM_SiSyouhnZokusei();
        jm_SiSyouhnZokusei.setSyouhncd(pSyouhncd);


        List<JM_SiSyouhnZokusei> siSyouhnZokuseiLst = select(jm_SiSyouhnZokusei);


        if (siSyouhnZokuseiLst.size() == 0) {


            return null;
        }


        return siSyouhnZokuseiLst.get(0);
    }
}
