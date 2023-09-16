package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Rendouflg;
import yuyu.def.db.entity.HT_SmbcStyKanri;
import yuyu.def.db.meta.QHT_SmbcStyKanri;

/**
 * ＳＭＢＣ進捗管理テーブル(HT_SmbcStyKanriDao) アクセス用の DAO クラスです。<br />
 */
public class HT_SmbcStyKanriDao extends AbstractDao<HT_SmbcStyKanri> {

    public HT_SmbcStyKanriDao() {
        super(HT_SmbcStyKanri.class);
    }

    public HT_SmbcStyKanri getSmbcStyKanri(BizDate pDatarenymd,
        BizNumber pDatasakuseirenno){
        HT_SmbcStyKanri hT_SmbcStyKanri =  new HT_SmbcStyKanri();
        hT_SmbcStyKanri.setDatarenymd(pDatarenymd);
        hT_SmbcStyKanri.setDatasakuseirenno(pDatasakuseirenno);
        return this.selectOne(hT_SmbcStyKanri);
    }

    public List<HT_SmbcStyKanri> getSmbcStyKanrisBySyono(String pSyono) {

        HT_SmbcStyKanri hT_SmbcStyKanri = new HT_SmbcStyKanri();
        hT_SmbcStyKanri.setSyono(pSyono);
        return this.select(hT_SmbcStyKanri);
    }

    public List<HT_SmbcStyKanri> getSmbcStyKanrisBySyonoSmbcseihosyknhkkzmymd(String pSyono,
        String pSmbcseihosyknhkkzmymd) {


        QHT_SmbcStyKanri qHT_SmbcStyKanri = new QHT_SmbcStyKanri();

        String querySql = $SELECT + qHT_SmbcStyKanri +
            $FROM + qHT_SmbcStyKanri.HT_SmbcStyKanri() +
            $WHERE + qHT_SmbcStyKanri.syono.eq(pSyono) +
            $AND + qHT_SmbcStyKanri.smbcseihosyknhkkzmymd.ne(pSmbcseihosyknhkkzmymd);

        return em.createJPQL(querySql).bind(qHT_SmbcStyKanri).getResultList();
    }

    public BizNumber getSmbcStyKanriMaxDatasakuseirennoByDatarenymd(BizDate pDatarenymd) {


        QHT_SmbcStyKanri qHT_SmbcStyKanri = new QHT_SmbcStyKanri();

        String strSql = $SELECT + $MAX(qHT_SmbcStyKanri.datasakuseirenno) +
            $FROM + qHT_SmbcStyKanri.HT_SmbcStyKanri() +
            $WHERE + qHT_SmbcStyKanri.datarenymd.eq(pDatarenymd);

        return em.createJPQL(strSql).bind(qHT_SmbcStyKanri).getSingleResult();
    }

    public List<HT_SmbcStyKanri> getSmbcStyKanrisBySyonoSmbcseihosyknhkkzmymdSmbcseihotrksymd(String pSyono,
        String pSmbcseihosyknhkkzmymd, String pSmbcseihotrksymd) {


        QHT_SmbcStyKanri qHT_SmbcStyKanri = new QHT_SmbcStyKanri();

        String strSql = $SELECT + qHT_SmbcStyKanri +
            $FROM + qHT_SmbcStyKanri.HT_SmbcStyKanri() +
            $WHERE + qHT_SmbcStyKanri.syono.eq(pSyono) +
            $AND + qHT_SmbcStyKanri.smbcseihosyknhkkzmymd.ne(pSmbcseihosyknhkkzmymd) +
            $AND + qHT_SmbcStyKanri.smbcseihotrksymd.ne(pSmbcseihotrksymd);

        return em.createJPQL(strSql).bind(qHT_SmbcStyKanri).getResultList();
    }

    public List<HT_SmbcStyKanri> getSmbcStyKanrisByMosno(String pMosno) {
        HT_SmbcStyKanri hT_SmbcStyKanri = new HT_SmbcStyKanri();

        hT_SmbcStyKanri.setMosno(pMosno);

        return this.select(hT_SmbcStyKanri);
    }

    public ExDBResults<HT_SmbcStyKanri> getSmbcStyKanrisByKakutyoujobcd() {


        QHT_SmbcStyKanri qHT_SmbcStyKanri1 = new QHT_SmbcStyKanri("q1");


        QHT_SmbcStyKanri qHT_SmbcStyKanri2 = new QHT_SmbcStyKanri("q2");


        String subQuerry = $SELECT + qHT_SmbcStyKanri1.syono +
            $FROM + qHT_SmbcStyKanri1.HT_SmbcStyKanri() +
            $WHERE + qHT_SmbcStyKanri1.syono.eq(qHT_SmbcStyKanri2.syono) +
            $GROUP_BY + qHT_SmbcStyKanri1.syono +
            $HAVING + $MAX(qHT_SmbcStyKanri1.datasakuseirenno) +
            $EQ + qHT_SmbcStyKanri2.datasakuseirenno;


        String strSql = $SELECT + qHT_SmbcStyKanri2 +
            $FROM + qHT_SmbcStyKanri2.HT_SmbcStyKanri() +
            $WHERE + qHT_SmbcStyKanri2.rendouflg.eq(C_Rendouflg.MIRENDOU) +
            $AND + $EXISTS(subQuerry) +
            $ORDER_BY (qHT_SmbcStyKanri2.smbcuktkkanriid.asc(),
                qHT_SmbcStyKanri2.syono.asc());

        return em.createJPQL(strSql).bind(qHT_SmbcStyKanri1, qHT_SmbcStyKanri2).getResults();
    }

    public List<HT_SmbcStyKanri> getSmbcStyKanrisBySmbcsyono(String pSmbcsyono) {


        QHT_SmbcStyKanri qHT_SmbcStyKanri = new QHT_SmbcStyKanri();

        String strSql = $SELECT + qHT_SmbcStyKanri +
            $FROM + qHT_SmbcStyKanri.HT_SmbcStyKanri() +
            $WHERE + qHT_SmbcStyKanri.rendouflg.eq(C_Rendouflg.MIRENDOU) +
            $AND +  qHT_SmbcStyKanri.smbcsyono.eq(pSmbcsyono);

        return em.createJPQL(strSql).bind(qHT_SmbcStyKanri).getResultList();
    }

    public List<HT_SmbcStyKanri> getSmbcStyKanrisBySyonoRendouflg(String pSyono) {
        HT_SmbcStyKanri hT_SmbcStyKanri = new HT_SmbcStyKanri();

        hT_SmbcStyKanri.setRendouflg(C_Rendouflg.MIRENDOU);
        hT_SmbcStyKanri.setSyono(pSyono);

        return this.select(hT_SmbcStyKanri);
    }


    public ExDBResults<HT_SmbcStyKanri> getSmbcStyKanrisByKakutyoujobcdMaxDatasakuseirenno() {


        QHT_SmbcStyKanri qHT_SmbcStyKanri1 = new QHT_SmbcStyKanri("q1");


        QHT_SmbcStyKanri qHT_SmbcStyKanri2 = new QHT_SmbcStyKanri("q2");


        String subQuerry = $SELECT + qHT_SmbcStyKanri1.syono +
            $FROM + qHT_SmbcStyKanri1.HT_SmbcStyKanri() +
            $WHERE + qHT_SmbcStyKanri1.syono.eq(qHT_SmbcStyKanri2.syono) +
            $AND + qHT_SmbcStyKanri1.smbcuktkkanriid.eq(qHT_SmbcStyKanri2.smbcuktkkanriid) +
            $AND + qHT_SmbcStyKanri1.rendouflg.eq(C_Rendouflg.MIRENDOU) +
            $GROUP_BY + qHT_SmbcStyKanri1.syono + "," +
            qHT_SmbcStyKanri1.smbcuktkkanriid +
            $HAVING + $MAX(qHT_SmbcStyKanri1.datasakuseirenno) +
            $EQ + qHT_SmbcStyKanri2.datasakuseirenno;


        String strSql = $SELECT + qHT_SmbcStyKanri2 +
            $FROM + qHT_SmbcStyKanri2.HT_SmbcStyKanri() +
            $WHERE + qHT_SmbcStyKanri2.rendouflg.eq(C_Rendouflg.MIRENDOU) +
            $AND + $EXISTS(subQuerry) +
            $ORDER_BY (qHT_SmbcStyKanri2.smbcuktkkanriid.asc(),
                qHT_SmbcStyKanri2.syono.asc());

        return em.createJPQL(strSql).bind(qHT_SmbcStyKanri1, qHT_SmbcStyKanri2).getResults();
    }

    public ExDBResults<HT_SmbcStyKanri> getSmbcStyKanrisByKakutyoujobcdMaxDatarenymdMaxDatasakuseirenno() {


        QHT_SmbcStyKanri qHT_SmbcStyKanri = new QHT_SmbcStyKanri("q");


        QHT_SmbcStyKanri qHT_SmbcStyKanri1 = new QHT_SmbcStyKanri("q1");


        QHT_SmbcStyKanri qHT_SmbcStyKanri2 = new QHT_SmbcStyKanri("q2");


        String subQuerry1 = $SELECT + qHT_SmbcStyKanri2.datarenymd +
            $FROM(qHT_SmbcStyKanri2) +
            $WHERE + qHT_SmbcStyKanri1.datarenymd.lt(qHT_SmbcStyKanri2.datarenymd) +
            $AND + qHT_SmbcStyKanri1.syono.eq(qHT_SmbcStyKanri2.syono) +
            $AND + qHT_SmbcStyKanri2.rendouflg.eq(C_Rendouflg.MIRENDOU);


        String subQuerry2 = $SELECT + qHT_SmbcStyKanri1.datarenymd +
            $FROM(qHT_SmbcStyKanri1) +
            $WHERE + $NOT_EXISTS(subQuerry1) +
            $AND + qHT_SmbcStyKanri.datarenymd.eq(qHT_SmbcStyKanri1.datarenymd) +
            $AND + qHT_SmbcStyKanri1.rendouflg.eq(C_Rendouflg.MIRENDOU) +
            $GROUP_BY + qHT_SmbcStyKanri1.datarenymd + "," +
            qHT_SmbcStyKanri1.syono +
            $HAVING + $MAX(qHT_SmbcStyKanri1.datasakuseirenno) +
            $EQ + qHT_SmbcStyKanri.datasakuseirenno;


        String strSql = $SELECT + qHT_SmbcStyKanri +
            $FROM(qHT_SmbcStyKanri) +
            $WHERE + qHT_SmbcStyKanri.rendouflg.eq(C_Rendouflg.MIRENDOU) +
            $AND + $EXISTS(subQuerry2) +
            $ORDER_BY(qHT_SmbcStyKanri.smbcuktkkanriid.asc(),
                qHT_SmbcStyKanri.syono.asc());

        return em.createJPQL(strSql).bind(qHT_SmbcStyKanri, qHT_SmbcStyKanri1, qHT_SmbcStyKanri2).getResults();

    }

}
