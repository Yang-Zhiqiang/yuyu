package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.biz.result.bean.SyouhnZokuseiHaitoukbnSeg1cdByPKBean;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_Sknenkinsyu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.meta.QBM_SyouhnZokusei;
import yuyu.def.db.meta.QHT_MosSyouhn;

/**
 * 商品属性マスタ(BM_SyouhnZokuseiDao) アクセス用の DAO クラスです。<br />
 */
public class BM_SyouhnZokuseiDao extends AbstractDao<BM_SyouhnZokusei> {

    public BM_SyouhnZokuseiDao() {
        super(BM_SyouhnZokusei.class);
    }

    public BM_SyouhnZokusei getSyouhnZokusei(String pSyouhncd,
        Integer pSyouhnsdno){
        BM_SyouhnZokusei bM_SyouhnZokusei =  new BM_SyouhnZokusei();
        bM_SyouhnZokusei.setSyouhncd(pSyouhncd);
        bM_SyouhnZokusei.setSyouhnsdno(pSyouhnsdno);
        return this.selectOne(bM_SyouhnZokusei);
    }

    public List<BM_SyouhnZokusei> getSyouhnZokuseisBySyutkkbnHyoujiymd(C_SyutkKbn pSyutkkbn, BizDate pHyoujidate) {


        QBM_SyouhnZokusei qBM_SyouhnZokusei1 = new QBM_SyouhnZokusei("q1");

        QBM_SyouhnZokusei qBM_SyouhnZokusei2 = new QBM_SyouhnZokusei("q2");


        String subQuerry = $SELECT + qBM_SyouhnZokusei1.syouhncd +  "," +
            $MAX(qBM_SyouhnZokusei1.syouhnsdno) +
            $FROM + qBM_SyouhnZokusei1.BM_SyouhnZokusei() +
            $WHERE + qBM_SyouhnZokusei1.syouhncd.eq(qBM_SyouhnZokusei2.syouhncd)+
            $AND + qBM_SyouhnZokusei1.hyoujifromymd.le(pHyoujidate) +
            $AND + qBM_SyouhnZokusei1.hyoujitoymd.ge(pHyoujidate) +
            $GROUP_BY + qBM_SyouhnZokusei1.syouhncd +
            $HAVING + $MAX(qBM_SyouhnZokusei1.syouhnsdno) + $EQ + qBM_SyouhnZokusei2.syouhnsdno;


        String queryStr = $SELECT + qBM_SyouhnZokusei2 +
            $FROM + qBM_SyouhnZokusei2.BM_SyouhnZokusei() +
            $WHERE + qBM_SyouhnZokusei2.syutkkbn.eq(pSyutkkbn) +
            $AND + $EXISTS(subQuerry) +
            $ORDER_BY(qBM_SyouhnZokusei2.mossyohnsortno.asc());

        return em.createJPQL(queryStr).bind(qBM_SyouhnZokusei1, qBM_SyouhnZokusei2).getResultList();
    }

    public BM_SyouhnZokusei getSyouhnZokuseiBySyouhncdHyoujiymd(String pSyouhncd, BizDate pHiduke) {


        QBM_SyouhnZokusei qBM_SyouhnZokusei = new QBM_SyouhnZokusei();


        String subQuerry = $SELECT + $MAX(qBM_SyouhnZokusei.syouhnsdno) +
            $FROM + qBM_SyouhnZokusei.BM_SyouhnZokusei() +
            $WHERE + qBM_SyouhnZokusei.hyoujifromymd.le(pHiduke)+
            $AND + qBM_SyouhnZokusei.hyoujitoymd.ge(pHiduke) +
            $AND + qBM_SyouhnZokusei.syouhncd.eq(pSyouhncd);



        String queryStr = $SELECT + qBM_SyouhnZokusei +
            $FROM + qBM_SyouhnZokusei.BM_SyouhnZokusei() +
            $WHERE + qBM_SyouhnZokusei.syouhncd.eq(pSyouhncd) +
            $AND + qBM_SyouhnZokusei.syouhnsdno + $EQ + "(" + subQuerry + ")";

        return em.createJPQL(queryStr).bind(qBM_SyouhnZokusei).getSingleResult();
    }

    public Integer getSyouhnZokuseiMaxSyouhnsdnoBySyouhncdKykymd(String pSyouhncd, BizDate pKykymd) {


        QBM_SyouhnZokusei qBM_SyouhnZokusei = new QBM_SyouhnZokusei();

        String queryStr = $SELECT + $MAX(qBM_SyouhnZokusei.syouhnsdno) +
            $FROM + qBM_SyouhnZokusei.BM_SyouhnZokusei() +
            $WHERE + qBM_SyouhnZokusei.syouhncd.eq(pSyouhncd) +
            $AND + qBM_SyouhnZokusei.kykfromymd.le(pKykymd) +
            $AND + qBM_SyouhnZokusei.kyktoymd.ge(pKykymd) +
            $GROUP_BY + qBM_SyouhnZokusei.syouhncd;

        return em.createJPQL(queryStr).bind(qBM_SyouhnZokusei).getSingleResult();
    }

    public List<BM_SyouhnZokusei> getSyouhnZokuseisBySyouhncd(String pSyouhncd) {
        BM_SyouhnZokusei bM_SyouhnZokusei =  new BM_SyouhnZokusei();
        bM_SyouhnZokusei.setSyouhncd(pSyouhncd);
        return this.select(bM_SyouhnZokusei);
    }

    public BM_SyouhnZokusei getSyouhnZokuseiBySyouhncdMaxSyouhnsdno(String pSyouhncd) {


        QBM_SyouhnZokusei qBM_SyouhnZokusei1 = new QBM_SyouhnZokusei("qBM_SyouhnZokusei1");
        QBM_SyouhnZokusei qBM_SyouhnZokusei2 = new QBM_SyouhnZokusei("qBM_SyouhnZokusei2");


        String strSubSql = $SELECT + qBM_SyouhnZokusei1.syouhncd +
            $FROM + qBM_SyouhnZokusei1.BM_SyouhnZokusei() +
            $WHERE + qBM_SyouhnZokusei1.syouhncd.eq(qBM_SyouhnZokusei2.syouhncd) +
            $GROUP_BY + qBM_SyouhnZokusei1.syouhncd +
            $HAVING + $MAX(qBM_SyouhnZokusei1.syouhnsdno) +
            $EQ + qBM_SyouhnZokusei2.syouhnsdno;


        String strSql = $SELECT + qBM_SyouhnZokusei2 +
            $FROM + qBM_SyouhnZokusei2.BM_SyouhnZokusei() +
            $WHERE + qBM_SyouhnZokusei2.syouhncd.eq(pSyouhncd) +
            $AND + $EXISTS(strSubSql);


        return em.createJPQL(strSql).bind(qBM_SyouhnZokusei1, qBM_SyouhnZokusei2).getSingleResult();
    }

    public List<BM_SyouhnZokusei> getSyouhnZokuseisByMosnoSyutkkbnSyssyoriymd(String pMosno, C_SyutkKbn pSyutkkbn, BizDate pSyssyoriymd) {


        QBM_SyouhnZokusei qBM_SyouhnZokusei = new QBM_SyouhnZokusei();
        QHT_MosSyouhn qHT_MosSyouhn = new QHT_MosSyouhn();


        String strSql = $SELECT + qBM_SyouhnZokusei.BM_SyouhnZokusei() +
            $FROM + qBM_SyouhnZokusei.BM_SyouhnZokusei() + "," +
            qHT_MosSyouhn.HT_MosSyouhn() +
            $WHERE + qHT_MosSyouhn.syouhncd.eq(qBM_SyouhnZokusei.syouhncd) +
            $AND + qHT_MosSyouhn.mosno.eq(pMosno) +
            $AND + qHT_MosSyouhn.syutkkbn.eq(pSyutkkbn)+
            $AND + qBM_SyouhnZokusei.kykfromymd.le(pSyssyoriymd) +
            $AND + qBM_SyouhnZokusei.kyktoymd.ge(pSyssyoriymd);


        return em.createJPQL(strSql).bind(qBM_SyouhnZokusei, qHT_MosSyouhn).getResultList();
    }

    public List<BM_SyouhnZokusei> getSyouhnZokuseisByHyoujidateSyutkkbnHknsyuruinoNkgnshosyouritu(BizDate pHyoujidate, C_SyutkKbn pSyutkkbn, C_HknsyuruiNo pHknsyuruino, Integer pNkgnshosyouritu) {


        QBM_SyouhnZokusei qBM_SyouhnZokusei = new QBM_SyouhnZokusei();


        String strSql = $SELECT + qBM_SyouhnZokusei +
            $FROM + qBM_SyouhnZokusei.BM_SyouhnZokusei() +
            $WHERE + qBM_SyouhnZokusei.hyoujifromymd.le(pHyoujidate) +
            $AND + qBM_SyouhnZokusei.hyoujitoymd.ge(pHyoujidate) +
            $AND + qBM_SyouhnZokusei.syutkkbn.eq(pSyutkkbn) +
            $AND + qBM_SyouhnZokusei.hknsyuruino.eq(pHknsyuruino) +
            $AND + qBM_SyouhnZokusei.nkgnshosyouritu.eq(pNkgnshosyouritu);


        return em.createJPQL(strSql).bind(qBM_SyouhnZokusei).getResultList();
    }

    public List<BM_SyouhnZokusei> getSyouhnZokuseisBySyouhncdKykfromymdKyktoymd(String pSyouhncd, BizDate pKykymd) {


        QBM_SyouhnZokusei qBM_SyouhnZokusei = new QBM_SyouhnZokusei();

        String strSql = $SELECT + qBM_SyouhnZokusei +
            $FROM + qBM_SyouhnZokusei.BM_SyouhnZokusei() +
            $WHERE + qBM_SyouhnZokusei.syouhncd.eq(pSyouhncd) +
            $AND + qBM_SyouhnZokusei.kykfromymd.le(pKykymd) +
            $AND + qBM_SyouhnZokusei.kyktoymd.ge(pKykymd);

        return em.createJPQL(strSql).bind(qBM_SyouhnZokusei).getResultList();
    }

    public List<BM_SyouhnZokusei> getSyouhnZokuseisByHyoujidateItems(BizDate pHyoujidate, C_SyutkKbn pSyutkkbn,
        C_HknsyuruiNo pHknsyuruino, Integer pNkgnshosyouritu, Integer pDai1hknkkn) {


        QBM_SyouhnZokusei qBM_SyouhnZokusei = new QBM_SyouhnZokusei();

        String strSql = $SELECT + qBM_SyouhnZokusei +
            $FROM + qBM_SyouhnZokusei.BM_SyouhnZokusei() +
            $WHERE + qBM_SyouhnZokusei.hyoujifromymd.le(pHyoujidate) +
            $AND + qBM_SyouhnZokusei.hyoujitoymd.ge(pHyoujidate) +
            $AND + qBM_SyouhnZokusei.syutkkbn.eq(pSyutkkbn) +
            $AND + qBM_SyouhnZokusei.hknsyuruino.eq(pHknsyuruino) +
            $AND + qBM_SyouhnZokusei.nkgnshosyouritu.eq(pNkgnshosyouritu) +
            $AND + qBM_SyouhnZokusei.dai1hknkkn.eq(pDai1hknkkn);

        return em.createJPQL(strSql).bind(qBM_SyouhnZokusei).getResultList();
    }

    public List<BM_SyouhnZokusei> getSyouhnZokuseisBySyouhncdKijyunymd(
        String pSyouhncd, BizDate pKijyunymd) {

        QBM_SyouhnZokusei qBM_SyouhnZokusei = new QBM_SyouhnZokusei();

        String strSql = $SELECT + qBM_SyouhnZokusei +
            $FROM + qBM_SyouhnZokusei.BM_SyouhnZokusei() +
            $WHERE + qBM_SyouhnZokusei.syouhncd.eq(pSyouhncd) +
            $AND + qBM_SyouhnZokusei.kykfromymd.le(pKijyunymd) +
            $AND + qBM_SyouhnZokusei.kyktoymd.ge(pKijyunymd) ;

        return em.createJPQL(strSql).bind(qBM_SyouhnZokusei).getResultList();
    }

    public  List<BM_SyouhnZokusei> getSyouhnZokuseisByHknsyuruinoItems(BizDate pHyoujidate, C_SyutkKbn pSyutkkbn, C_HknsyuruiNo pHknsyuruino, Integer pNkgnshosyouritu, Integer pDai1hknkkn
        , C_Tuukasyu pTuukasyu, C_UmuKbn pSyksbyensitihsyutktekiumu, C_Sknenkinsyu pSknenkinsyu, C_UmuKbn pTeikisiharaikinumu) {

        QBM_SyouhnZokusei qBM_SyouhnZokusei = new QBM_SyouhnZokusei();

        String strSql = $SELECT + qBM_SyouhnZokusei +
            $FROM + qBM_SyouhnZokusei.BM_SyouhnZokusei() +
            $WHERE + qBM_SyouhnZokusei.hyoujifromymd.le(pHyoujidate) +
            $AND + qBM_SyouhnZokusei.hyoujitoymd.ge(pHyoujidate) +
            $AND + qBM_SyouhnZokusei.syutkkbn.eq(pSyutkkbn) +
            $AND + qBM_SyouhnZokusei.hknsyuruino.eq(pHknsyuruino) +
            $AND + qBM_SyouhnZokusei.nkgnshosyouritu.eq(pNkgnshosyouritu) +
            $AND + qBM_SyouhnZokusei.dai1hknkkn.eq(pDai1hknkkn) +
            $AND + qBM_SyouhnZokusei.tuukasyu.eq(pTuukasyu) +
            $AND + qBM_SyouhnZokusei.syksbyensitihsyutktekiumu.eq(pSyksbyensitihsyutktekiumu) +
            $AND + qBM_SyouhnZokusei.sknenkinsyu.eq(pSknenkinsyu) +
            $AND + qBM_SyouhnZokusei.teikisiharaikinumu.eq(pTeikisiharaikinumu);

        return em.createJPQL(strSql).bind(qBM_SyouhnZokusei).getResultList();
    }

    public  List<BM_SyouhnZokusei> getSyouhnZokuseisByKykymdItems(BizDate pKykymd, C_SyutkKbn pSyutkkbn, C_HknsyuruiNo pHknsyuruino, Integer pNkgnshosyouritu, Integer pDai1hknkkn
        , C_Tuukasyu pTuukasyu, C_UmuKbn pSyksbyensitihsyutktekiumu, C_Sknenkinsyu pSknenkinsyu, C_UmuKbn pTeikisiharaikinumu) {

        QBM_SyouhnZokusei qBM_SyouhnZokusei = new QBM_SyouhnZokusei();

        String strSql = $SELECT + qBM_SyouhnZokusei +
            $FROM + qBM_SyouhnZokusei.BM_SyouhnZokusei() +
            $WHERE + qBM_SyouhnZokusei.kykfromymd.le(pKykymd) +
            $AND + qBM_SyouhnZokusei.kyktoymd.ge(pKykymd) +
            $AND + qBM_SyouhnZokusei.syutkkbn.eq(pSyutkkbn) +
            $AND + qBM_SyouhnZokusei.hknsyuruino.eq(pHknsyuruino) +
            $AND + qBM_SyouhnZokusei.nkgnshosyouritu.eq(pNkgnshosyouritu) +
            $AND + qBM_SyouhnZokusei.dai1hknkkn.eq(pDai1hknkkn) +
            $AND + qBM_SyouhnZokusei.tuukasyu.eq(pTuukasyu) +
            $AND + qBM_SyouhnZokusei.syksbyensitihsyutktekiumu.eq(pSyksbyensitihsyutktekiumu) +
            $AND + qBM_SyouhnZokusei.sknenkinsyu.eq(pSknenkinsyu) +
            $AND + qBM_SyouhnZokusei.teikisiharaikinumu.eq(pTeikisiharaikinumu);

        return em.createJPQL(strSql).bind(qBM_SyouhnZokusei).getResultList();
    }

    public  List<BM_SyouhnZokusei> getSyouhnZokuseisByKykymdItems2(BizDate pKykymd, C_SyutkKbn pSyutkkbn, C_HknsyuruiNo pHknsyuruino, Integer pNkgnshosyouritu,
        C_UmuKbn pSyksbyensitihsyutktekiumu, C_Sknenkinsyu pSknenkinsyu, C_UmuKbn pTeikisiharaikinumu) {


        QBM_SyouhnZokusei qBM_SyouhnZokusei = new QBM_SyouhnZokusei("qBM_SyouhnZokusei");


        String strSql = $SELECT + qBM_SyouhnZokusei +
            $FROM(qBM_SyouhnZokusei) +
            $WHERE + qBM_SyouhnZokusei.kykfromymd.le(pKykymd) +
            $AND + qBM_SyouhnZokusei.kyktoymd.ge(pKykymd) +
            $AND + qBM_SyouhnZokusei.syutkkbn.eq(pSyutkkbn) +
            $AND + qBM_SyouhnZokusei.hknsyuruino.eq(pHknsyuruino) +
            $AND + qBM_SyouhnZokusei.nkgnshosyouritu.eq(pNkgnshosyouritu) +
            $AND + qBM_SyouhnZokusei.syksbyensitihsyutktekiumu.eq(pSyksbyensitihsyutktekiumu) +
            $AND + qBM_SyouhnZokusei.sknenkinsyu.eq(pSknenkinsyu) +
            $AND + qBM_SyouhnZokusei.teikisiharaikinumu.eq(pTeikisiharaikinumu);


        return em.createJPQL(strSql).bind(qBM_SyouhnZokusei).getResultList();
    }

    public SyouhnZokuseiHaitoukbnSeg1cdByPKBean getSyouhnZokuseiHaitoukbnSeg1cdByPK(String pSyouhncd,
        Integer pSyouhnsdno) {


        QBM_SyouhnZokusei qBM_SyouhnZokusei = new QBM_SyouhnZokusei();

        String strSql = $SELECT + $NEW(SyouhnZokuseiHaitoukbnSeg1cdByPKBean.class,
            qBM_SyouhnZokusei.haitoukbn,
            qBM_SyouhnZokusei.seg1cd) +
            $FROM(qBM_SyouhnZokusei) +
            $WHERE + qBM_SyouhnZokusei.syouhncd.eq(pSyouhncd) +
            $AND + qBM_SyouhnZokusei.syouhnsdno.eq(pSyouhnsdno);

        return em.createJPQL(strSql, SyouhnZokuseiHaitoukbnSeg1cdByPKBean.class).bind(qBM_SyouhnZokusei).getSingleResult();
    }

    public  List<BM_SyouhnZokusei> getSyouhnZokuseisByHknsyuruinoItems2(BizDate pHyoujidate, C_SyutkKbn pSyutkkbn, C_HknsyuruiNo pHknsyuruino, Integer pNkgnshosyouritu
        , C_UmuKbn pSyksbyensitihsyutktekiumu, C_Sknenkinsyu pSknenkinsyu, C_UmuKbn pTeikisiharaikinumu) {

        QBM_SyouhnZokusei qBM_SyouhnZokusei = new QBM_SyouhnZokusei("qBM_SyouhnZokusei");

        String strSql = $SELECT + qBM_SyouhnZokusei +
            $FROM (qBM_SyouhnZokusei) +
            $WHERE + qBM_SyouhnZokusei.hyoujifromymd.le(pHyoujidate) +
            $AND + qBM_SyouhnZokusei.hyoujitoymd.ge(pHyoujidate) +
            $AND + qBM_SyouhnZokusei.syutkkbn.eq(pSyutkkbn) +
            $AND + qBM_SyouhnZokusei.hknsyuruino.eq(pHknsyuruino) +
            $AND + qBM_SyouhnZokusei.nkgnshosyouritu.eq(pNkgnshosyouritu) +
            $AND + qBM_SyouhnZokusei.syksbyensitihsyutktekiumu.eq(pSyksbyensitihsyutktekiumu) +
            $AND + qBM_SyouhnZokusei.sknenkinsyu.eq(pSknenkinsyu) +
            $AND + qBM_SyouhnZokusei.teikisiharaikinumu.eq(pTeikisiharaikinumu);

        return em.createJPQL(strSql).bind(qBM_SyouhnZokusei).getResultList();
    }
}
