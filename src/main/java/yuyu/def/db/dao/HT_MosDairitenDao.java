package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_Kanryouflg;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.meta.QHT_MosDairiten;
import yuyu.def.db.meta.QHT_MosKihon;
import yuyu.def.db.meta.QHT_SmbcStyKanriSsRireki;
import yuyu.def.db.meta.QHT_SyoriCTL;

/**
 * 申込代理店テーブル(HT_MosDairitenDao) アクセス用の DAO クラスです。<br />
 */
public class HT_MosDairitenDao extends AbstractDao<HT_MosDairiten> {

    public HT_MosDairitenDao() {
        super(HT_MosDairiten.class);
    }

    @Deprecated
    public HT_MosDairiten getMosDairiten(String pMosno,
        Integer pRenno){
        HT_MosDairiten hT_MosDairiten =  new HT_MosDairiten();
        hT_MosDairiten.setMosno(pMosno);
        hT_MosDairiten.setRenno(pRenno);
        return this.selectOne(hT_MosDairiten);
    }

    @Override
    @Deprecated
    public List<HT_MosDairiten> selectAll() {
        return super.selectAll();
    }

    public ExDBResults<HT_SyoriCTL> getSmbcHnkSntKnrTsDatasByKakutyoujobcd() {


        QHT_MosDairiten qHT_MosDairiten = new QHT_MosDairiten();

        QHT_SyoriCTL qHT_SyoriCTL = new QHT_SyoriCTL();

        QHT_SmbcStyKanriSsRireki qHT_SmbcStyKanriSsRireki = new QHT_SmbcStyKanriSsRireki();

        QHT_MosKihon qHT_MosKihon = new QHT_MosKihon();


        String mainQuerry = $SELECT + qHT_SyoriCTL +
            $FROM + qHT_MosDairiten.HT_MosDairiten() + "," +
            qHT_SyoriCTL.HT_SyoriCTL() + "," +
            qHT_SmbcStyKanriSsRireki.HT_SmbcStyKanriSsRireki() + "," +
            qHT_MosKihon.HT_MosKihon() +
            $WHERE + qHT_SyoriCTL.syono.eq(qHT_SmbcStyKanriSsRireki.syono) +
            $AND + qHT_SyoriCTL.gyoumuKousinTime.gt(qHT_SmbcStyKanriSsRireki.syrctrltblkostime) +
            $AND + qHT_SyoriCTL.mosnrkumu.eq(C_UmuKbn.ARI) +
            $AND + qHT_SmbcStyKanriSsRireki.renkanryoflg.ne(Integer.valueOf(C_Kanryouflg.KANRYOU.getValue())) +
            $AND + qHT_SyoriCTL.mosno.eq(qHT_MosKihon.mosno) +
            $AND + qHT_SyoriCTL.mosno.eq(qHT_MosDairiten.mosno) +
            $AND + qHT_MosDairiten.renno.eq(1) +
            $AND + qHT_SyoriCTL.skeijimukbn.eq(C_SkeijimuKbn.SMBC);


        return em.createJPQL(mainQuerry).bind(qHT_MosDairiten, qHT_SyoriCTL, qHT_SmbcStyKanriSsRireki, qHT_MosKihon).getResults();
    }

    public ExDBResults<HT_SyoriCTL> getSmbcSnkSntKnrTsDatasByKakutyoujobcd() {


        QHT_SyoriCTL qHT_SyoriCTL = new QHT_SyoriCTL();
        QHT_MosKihon qHT_MosKihon = new QHT_MosKihon();
        QHT_MosDairiten qHT_MosDairiten = new QHT_MosDairiten();
        QHT_SmbcStyKanriSsRireki qHT_SmbcStyKanriSsRireki = new QHT_SmbcStyKanriSsRireki();


        String strSubSql = $SELECT + qHT_SmbcStyKanriSsRireki.syono +
            $FROM + qHT_SmbcStyKanriSsRireki.HT_SmbcStyKanriSsRireki() +
            $WHERE + qHT_SyoriCTL.syono.eq(qHT_SmbcStyKanriSsRireki.syono);


        String strSql = $SELECT + qHT_SyoriCTL +
            $FROM + qHT_SyoriCTL.HT_SyoriCTL() + "," +
            qHT_MosKihon.HT_MosKihon() + "," +
            qHT_MosDairiten.HT_MosDairiten() +
            $WHERE + qHT_SyoriCTL.mosno.eq(qHT_MosKihon.mosno) +
            $AND + qHT_SyoriCTL.mosno.eq(qHT_MosDairiten.mosno) +
            $AND + qHT_MosDairiten.renno.eq(new Integer(1)) +
            $AND + qHT_SyoriCTL.mosnrkumu.eq(C_UmuKbn.ARI) +
            $AND + qHT_SyoriCTL.skeijimukbn.eq(C_SkeijimuKbn.SMBC) +
            $AND + $NOT_EXISTS(strSubSql);


        return em.createJPQL(strSql).bind(qHT_SyoriCTL, qHT_MosKihon, qHT_MosDairiten, qHT_SmbcStyKanriSsRireki).getResults();
    }
}
