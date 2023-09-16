package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDateYM;
import yuyu.def.classification.C_HasinkyokaKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.HT_SkHubiDetail;
import yuyu.def.db.meta.QBM_Dairiten;
import yuyu.def.db.meta.QHM_SkHubiKoumoku;
import yuyu.def.db.meta.QHM_SkHubiNaiyou;
import yuyu.def.db.meta.QHM_SkSeibiSijiNaiyou;
import yuyu.def.db.meta.QHT_MosDairiten;
import yuyu.def.db.meta.QHT_MosKihon;
import yuyu.def.db.meta.QHT_SkHubi;
import yuyu.def.db.meta.QHT_SkHubiDetail;
import yuyu.def.db.meta.QHT_SyoriCTL;

/**
 * 新契約不備詳細テーブル(HT_SkHubiDetailDao) アクセス用の DAO クラスです。<br />
 */
public class HT_SkHubiDetailDao extends AbstractDao<HT_SkHubiDetail> {

    public HT_SkHubiDetailDao() {
        super(HT_SkHubiDetail.class);
    }

    @Deprecated
    public HT_SkHubiDetail getSkHubiDetail(String pMosno,
        String pHubisikibetukey,
        Integer pRenno3keta){
        HT_SkHubiDetail hT_SkHubiDetail =  new HT_SkHubiDetail();
        hT_SkHubiDetail.setMosno(pMosno);
        hT_SkHubiDetail.setHubisikibetukey(pHubisikibetukey);
        hT_SkHubiDetail.setRenno3keta(pRenno3keta);
        return this.selectOne(hT_SkHubiDetail);
    }

    @Override
    @Deprecated
    public List<HT_SkHubiDetail> selectAll() {
        return super.selectAll();
    }

    public List<HT_SkHubiDetail> getSkHubiDetailsByMosym(BizDateYM pMosym) {


        QHT_SkHubiDetail qHT_SkHubiDetail = new QHT_SkHubiDetail();


        QHT_MosKihon qHT_MosKihon = new QHT_MosKihon();


        QHT_SyoriCTL qHT_SyoriCTL = new QHT_SyoriCTL();


        QHT_MosDairiten qHT_MosDairiten = new QHT_MosDairiten();


        QHT_SkHubi qHT_SkHubi = new QHT_SkHubi();


        QBM_Dairiten qBM_Dairiten = new QBM_Dairiten();


        QHM_SkHubiNaiyou qHM_SkHubiNaiyou = new QHM_SkHubiNaiyou();


        QHM_SkHubiKoumoku qHM_SkHubiKoumoku = new QHM_SkHubiKoumoku();


        QHM_SkSeibiSijiNaiyou qHM_SkSeibiSijiNaiyou = new QHM_SkSeibiSijiNaiyou();

        String querySql = $SELECT  + qHT_SkHubiDetail +
            $FROM + qHT_SkHubiDetail.HT_SkHubiDetail() + "," +
            qHT_MosKihon.HT_MosKihon() + "," +
            qHT_SyoriCTL.HT_SyoriCTL() + "," +
            qHT_MosDairiten.HT_MosDairiten() + "," +
            qHT_SkHubi.HT_SkHubi() + "," +
            qBM_Dairiten.BM_Dairiten() + "," +
            qHM_SkHubiNaiyou.HM_SkHubiNaiyou() + "," +
            qHM_SkHubiKoumoku.HM_SkHubiKoumoku() + "," +
            qHM_SkSeibiSijiNaiyou.HM_SkSeibiSijiNaiyou() +
            $WHERE + qHT_SyoriCTL.mosno.eq(qHT_MosKihon.mosno) +
            $AND + qHT_SyoriCTL.mosno.eq(qHT_MosDairiten.mosno) +
            $AND + qHT_SyoriCTL.mosno.eq(qHT_SkHubi.mosno) +
            $AND + qHT_SkHubi.mosno.eq(qHT_SkHubiDetail.mosno) +
            $AND + qHT_SkHubi.hubisikibetukey.eq(qHT_SkHubiDetail.hubisikibetukey) +
            $AND + "(" + qHT_SkHubiDetail.skhubikoumokucd.eq(qHM_SkHubiNaiyou.skhubikoumokucd) +
            $AND + qHT_SkHubiDetail.skhubinaiyoucd.eq(qHM_SkHubiNaiyou.skhubinaiyoucd) + ")" +
            $AND + "(" + qHT_SkHubiDetail.syoruiCd.eq(qHM_SkHubiKoumoku.syoruiCd) +
            $AND + qHT_SkHubiDetail.skhubikoumokucd.eq(qHM_SkHubiKoumoku.skhubikoumokucd)+ ")" +
            $AND + qHT_SkHubiDetail.skseibisijinaiyoucd.eq(qHM_SkSeibiSijiNaiyou.skseibisijinaiyoucd) +
            $AND + qHT_MosDairiten.tratkiagcd.eq(qBM_Dairiten.drtencd) +
            $AND + qHT_SyoriCTL.mosnrkymd.substring(1, 6).eq(pMosym.toString()) +
            $ORDER_BY(qHT_SyoriCTL.mosnrkymd.asc(),qHT_SyoriCTL.mosno.asc());

        return em.createJPQL(querySql).bind(qHT_SkHubiDetail, qHT_MosKihon, qHT_SyoriCTL, qHT_MosDairiten, qHT_SkHubi,
            qBM_Dairiten, qHM_SkHubiNaiyou, qHM_SkHubiKoumoku, qHM_SkSeibiSijiNaiyou).getResultList();
    }

    public Integer getSkHubiDetailMaxRenno3ketaByMosnoHubisikibetukey(String pMosno, String pHubisikibetukey) {


        QHT_SkHubiDetail qHT_SkHubiDetail = new QHT_SkHubiDetail();

        String quertSql = $SELECT + $MAX(qHT_SkHubiDetail.renno3keta) +
            $FROM + qHT_SkHubiDetail.HT_SkHubiDetail() +
            $WHERE + qHT_SkHubiDetail.mosno.eq(pMosno) +
            $AND + qHT_SkHubiDetail.hubisikibetukey.eq(pHubisikibetukey) +
            $AND + qHT_SkHubiDetail.hasinymd.isNotNull();

        return em.createJPQL(quertSql).bind(qHT_SkHubiDetail).getSingleResult();
    }


    public Long getSkHubiDetailCountByMosnoTrkymdHasinymd(String pMosno) {


        QHT_SkHubi qHT_SkHubi = new QHT_SkHubi();


        QHT_SkHubiDetail qHT_SkHubiDetail = new QHT_SkHubiDetail();

        String quertSql = $SELECT + $COUNT + "(*)" +
            $FROM + qHT_SkHubiDetail.HT_SkHubiDetail() + "," +
            qHT_SkHubi.HT_SkHubi() +
            $WHERE + qHT_SkHubi.mosno.eq(pMosno) +
            $AND + qHT_SkHubi.mosno.eq(qHT_SkHubiDetail.mosno) +
            $AND + qHT_SkHubi.hubisikibetukey.eq(qHT_SkHubiDetail.hubisikibetukey) +
            $AND + "(" + qHT_SkHubiDetail.trkymd.isNotNull() +
            $AND + qHT_SkHubiDetail.hasinymd.isNull() + ")";

        return em.createJPQL(quertSql).bind(qHT_SkHubi, qHT_SkHubiDetail).getSingleResult();
    }

    public Long getSkHubiDetailCountByMosnoTrkymdHasinymdKaisyouymd(String pMosno) {


        QHT_SkHubi qHT_SkHubi = new QHT_SkHubi();


        QHT_SkHubiDetail qHT_SkHubiDetail = new QHT_SkHubiDetail();

        String quertSql = $SELECT + $COUNT + "(*)" +
            $FROM + qHT_SkHubiDetail.HT_SkHubiDetail() + "," +
            qHT_SkHubi.HT_SkHubi() +
            $WHERE + qHT_SkHubi.mosno.eq(pMosno) +
            $AND + qHT_SkHubi.mosno.eq(qHT_SkHubiDetail.mosno) +
            $AND + qHT_SkHubi.hubisikibetukey.eq(qHT_SkHubiDetail.hubisikibetukey) +
            $AND + "(" + qHT_SkHubiDetail.trkymd.isNotNull() +
            $AND + qHT_SkHubiDetail.hasinymd.isNotNull() +
            $AND + qHT_SkHubiDetail.kaisyouymd.isNull() + ")";

        return em.createJPQL(quertSql).bind(qHT_SkHubi, qHT_SkHubiDetail).getSingleResult();
    }

    public Long getSkHubiDetailCountByMosnoKaisyouymd(String pMosno) {


        QHT_SkHubi qHT_SkHubi = new QHT_SkHubi();


        QHT_SkHubiDetail qHT_SkHubiDetail = new QHT_SkHubiDetail();

        String quertSql = $SELECT + $COUNT + "(*)" +
            $FROM + qHT_SkHubiDetail.HT_SkHubiDetail() + "," +
            qHT_SkHubi.HT_SkHubi() +
            $WHERE + qHT_SkHubi.mosno.eq(pMosno) +
            $AND + qHT_SkHubi.mosno.eq(qHT_SkHubiDetail.mosno) +
            $AND + qHT_SkHubi.hubisikibetukey.eq(qHT_SkHubiDetail.hubisikibetukey) +
            $AND + qHT_SkHubiDetail.kaisyouymd.isNull();

        return em.createJPQL(quertSql).bind(qHT_SkHubi, qHT_SkHubiDetail).getSingleResult();
    }

    public List<HT_SkHubiDetail> getSkHubiDetailsByHubisikibetukeyHasinkyokaKbnHasinymd(String pHubisikibetukey) {


        QHT_SkHubiDetail qHT_SkHubiDetail = new QHT_SkHubiDetail();
        QHM_SkHubiKoumoku qHM_SkHubiKoumoku = new QHM_SkHubiKoumoku();
        QHM_SkHubiNaiyou qHM_SkHubiNaiyou = new QHM_SkHubiNaiyou();
        QHM_SkSeibiSijiNaiyou qHM_SkSeibiSijiNaiyou = new QHM_SkSeibiSijiNaiyou();


        String strSql = $SELECT + qHT_SkHubiDetail +
            $FROM(qHT_SkHubiDetail ,
                qHM_SkHubiKoumoku,
                qHM_SkHubiNaiyou,
                qHM_SkSeibiSijiNaiyou) +
                $WHERE + qHT_SkHubiDetail.hubisikibetukey.eq(pHubisikibetukey) +
                $AND + qHT_SkHubiDetail.hasinkyokakbn.eq(C_HasinkyokaKbn.KY) +
                $AND + qHT_SkHubiDetail.hasinymd + $IS_NULL +
                $AND + qHT_SkHubiDetail.skhubikoumokucd.eq(qHM_SkHubiKoumoku.skhubikoumokucd) +
                $AND + qHT_SkHubiDetail.syoruiCd.eq(qHM_SkHubiKoumoku.syoruiCd) +
                $AND + qHT_SkHubiDetail.skhubikoumokucd.eq(qHM_SkHubiNaiyou.skhubikoumokucd) +
                $AND + qHT_SkHubiDetail.skhubinaiyoucd.eq(qHM_SkHubiNaiyou.skhubinaiyoucd) +
                $AND + qHT_SkHubiDetail.skseibisijinaiyoucd.eq(qHM_SkSeibiSijiNaiyou.skseibisijinaiyoucd) +
                $ORDER_BY(qHT_SkHubiDetail.tyoubunflg.desc(),
                    qHT_SkHubiDetail.renno3keta.asc());


        return em.createJPQL(strSql).bind(qHT_SkHubiDetail, qHM_SkHubiKoumoku, qHM_SkHubiNaiyou, qHM_SkSeibiSijiNaiyou)
            .getResultList();
    }

    public List<HT_SkHubiDetail> getSkHubiDetailsByHubisikibetukeyHasinkyokaKbnHasinymdNull(String pHubisikibetukey) {


        QHT_SkHubiDetail qHT_SkHubiDetail = new QHT_SkHubiDetail();


        String strSql = $SELECT + qHT_SkHubiDetail +
            $FROM + qHT_SkHubiDetail.HT_SkHubiDetail() +
            $WHERE + qHT_SkHubiDetail.hubisikibetukey.eq(pHubisikibetukey) +
            $AND + qHT_SkHubiDetail.hasinkyokakbn.eq(C_HasinkyokaKbn.KY) +
            $AND + qHT_SkHubiDetail.hasinymd + $IS_NULL;


        return em.createJPQL(strSql).bind(qHT_SkHubiDetail).getResultList();
    }

    public List<C_SyoruiCdKbn> getSkHubiDetailsByMosnoKaisyouymdNull(String pMosno) {


        QHT_SkHubi qHT_SkHubi = new QHT_SkHubi();


        QHT_SkHubiDetail qHT_SkHubiDetail = new QHT_SkHubiDetail();


        String strSql = $SELECT_DISTINCT + qHT_SkHubiDetail.syoruiCd +
            $FROM + qHT_SkHubiDetail.HT_SkHubiDetail() + "," +
            qHT_SkHubi.HT_SkHubi() +
            $WHERE + qHT_SkHubi.mosno.eq(pMosno) +
            $AND + qHT_SkHubi.mosno.eq(qHT_SkHubiDetail.mosno) +
            $AND + qHT_SkHubi.hubisikibetukey.eq(qHT_SkHubiDetail.hubisikibetukey) +
            $AND + qHT_SkHubiDetail.kaisyouymd.isNull() +
            $ORDER_BY (qHT_SkHubiDetail.syoruiCd.asc());

        return em.createJPQL(strSql).bind(qHT_SkHubi, qHT_SkHubiDetail).getResultList();
    }

    public Long getSkHubiDetailCountByPkHasinkyokakbn(String pMosno, String pHubisikibetukey) {

        QHT_SkHubiDetail qHT_SkHubiDetail = new QHT_SkHubiDetail();


        String quertSql =  $SELECT + $COUNT + "(*)" +
            $FROM + qHT_SkHubiDetail.HT_SkHubiDetail() +
            $WHERE + qHT_SkHubiDetail.mosno.eq(pMosno) +
            $AND + qHT_SkHubiDetail.hubisikibetukey.eq(pHubisikibetukey) +
            $AND + qHT_SkHubiDetail.hasinkyokakbn.eq(C_HasinkyokaKbn.HORYUU);


        return em.createJPQL(quertSql).bind(qHT_SkHubiDetail).getSingleResult();
    }

    public List<HT_SkHubiDetail> getSkHubiDetailsByMosnoSyoruicd(String pMosno, C_SyoruiCdKbn pSyoruiCdKbn) {


        QHT_SkHubiDetail qHT_SkHubiDetail = new QHT_SkHubiDetail();


        String quertSql =  $SELECT + qHT_SkHubiDetail +
            $FROM(qHT_SkHubiDetail) +
            $WHERE + qHT_SkHubiDetail.mosno.eq(pMosno) +
            $AND + qHT_SkHubiDetail.syoruiCd.eq(pSyoruiCdKbn);


        return em.createJPQL(quertSql).bind(qHT_SkHubiDetail).getResultList();
    }
}
