package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import jp.co.slcs.swak.util.string.StringUtil;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_HnknhouKbn;
import yuyu.def.classification.C_JimusrhKbn;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_KetteiKbn;
import yuyu.def.classification.C_KoukankykKbn;
import yuyu.def.classification.C_KouseiinkykKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.classification.C_SntkInfoTaisyousyaKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.db.meta.QBM_Dairiten;
import yuyu.def.db.meta.QBM_SyouhnZokusei;
import yuyu.def.db.meta.QHM_SkHubiKoumoku;
import yuyu.def.db.meta.QHM_SkHubiNaiyou;
import yuyu.def.db.meta.QHM_SkSeibiSijiNaiyou;
import yuyu.def.db.meta.QHT_DakuhiKettei;
import yuyu.def.db.meta.QHT_Henkin;
import yuyu.def.db.meta.QHT_MosDairiten;
import yuyu.def.db.meta.QHT_MosKihon;
import yuyu.def.db.meta.QHT_MosSyouhn;
import yuyu.def.db.meta.QHT_MostenkenRireki;
import yuyu.def.db.meta.QHT_NayoseKekka;
import yuyu.def.db.meta.QHT_SkHubi;
import yuyu.def.db.meta.QHT_SkHubiDetail;
import yuyu.def.db.meta.QHT_SyoriCTL;
import yuyu.def.sinkeiyaku.result.bean.SkhubibunsekiInfosBean;
import yuyu.def.sinkeiyaku.result.bean.SyoukaiIchiranInfosByMosymdBosyuuymItemsBean;

/**
 * 処理コントロールテーブル(HT_SyoriCTLDao) アクセス用の DAO クラスです。<br />
 */
public class HT_SyoriCTLDao extends AbstractDao<HT_SyoriCTL> {

    public HT_SyoriCTLDao() {
        super(HT_SyoriCTL.class);
    }

    public HT_SyoriCTL getSyoriCTL(String pMosno){
        HT_SyoriCTL hT_SyoriCTL =  new HT_SyoriCTL();
        hT_SyoriCTL.setMosno(pMosno);
        return this.selectOne(hT_SyoriCTL);
    }

    public List<HT_MosDairiten> getKoseiinKeiyakuGaitouKeiyakusBySyoriym(BizDateYM pSyoriym) {


        QHT_SyoriCTL qHT_SyoriCTL = new QHT_SyoriCTL();

        QHT_MosKihon qHT_MosKihon = new QHT_MosKihon();

        QHT_MosDairiten qHT_MosDairiten = new QHT_MosDairiten();

        QHT_MostenkenRireki qHT_MostenkenRireki = new QHT_MostenkenRireki();


        String subQuerStr = $SELECT + $MAX(qHT_MostenkenRireki.syoriYmd.substring(1, 6)) +
            $FROM + qHT_MostenkenRireki.HT_MostenkenRireki() +
            $WHERE + qHT_MostenkenRireki.mosno.eq(qHT_SyoriCTL.mosno) +
            $AND + qHT_MostenkenRireki.mostenkenkekkakbn.eq(C_SyorikekkaKbn.KANRYOU);


        String queryStr = $SELECT  + qHT_MosDairiten +
            $FROM + qHT_SyoriCTL.HT_SyoriCTL() + "," +
            qHT_MosKihon.HT_MosKihon() + "," +
            qHT_MosDairiten.HT_MosDairiten() +
            $WHERE + qHT_SyoriCTL.mosno.eq(qHT_MosKihon.mosno) +
            $AND + qHT_SyoriCTL.mosno.eq(qHT_MosDairiten.mosno) +
            $AND + "(" + qHT_SyoriCTL.kouseiinkykkbn.eq(C_KouseiinkykKbn.HHKN_KOUSEIIN) +
            $OR + qHT_SyoriCTL.kouseiinkykkbn.eq(C_KouseiinkykKbn.SBUKT_KOUSEIIN) +
            $OR + qHT_SyoriCTL.kouseiinkykkbn.eq(C_KouseiinkykKbn.ANY_DAIRITENSYOKUIN) +
            $OR + qHT_SyoriCTL.kouseiinkykkbn.eq(C_KouseiinkykKbn.STDRSK_BOSYUU) +
            $OR + qHT_SyoriCTL.kouseiinkykkbn.eq(C_KouseiinkykKbn.SBUKT_STDRSK) + ")" +
            $AND + $(subQuerStr) + $EQ  + "'" + pSyoriym + "'" +
            $ORDER_BY(qHT_MosKihon.mosymd.asc(),
                qHT_SyoriCTL.mosno.asc());

        return em.createJPQL(queryStr).bind(qHT_SyoriCTL, qHT_MosKihon, qHT_MosDairiten, qHT_MostenkenRireki).getResultList();
    }

    public List<HT_MosDairiten> getKokanKeiyakuGaitouKeiyakusBySyoriym(BizDateYM pSyoriym) {


        QHT_SyoriCTL qHT_SyoriCTL = new QHT_SyoriCTL();

        QHT_MosKihon qHT_MosKihon = new QHT_MosKihon();

        QHT_MosDairiten qHT_MosDairiten = new QHT_MosDairiten();

        QHT_MostenkenRireki qHT_MostenkenRireki = new QHT_MostenkenRireki();


        String subQuerStr = $SELECT + $MAX(qHT_MostenkenRireki.syoriYmd.substring(1, 6)) +
            $FROM + qHT_MostenkenRireki.HT_MostenkenRireki() +
            $WHERE + qHT_MostenkenRireki.mosno.eq(qHT_SyoriCTL.mosno) +
            $AND + qHT_MostenkenRireki.mostenkenkekkakbn.eq(C_SyorikekkaKbn.KANRYOU);


        String queryStr = $SELECT  + qHT_MosDairiten +
            $FROM + qHT_SyoriCTL.HT_SyoriCTL() + "," +
            qHT_MosKihon.HT_MosKihon() + "," +
            qHT_MosDairiten.HT_MosDairiten() +
            $WHERE + qHT_SyoriCTL.mosno.eq(qHT_MosKihon.mosno) +
            $AND + qHT_SyoriCTL.mosno.eq(qHT_MosDairiten.mosno) +
            $AND +  qHT_SyoriCTL.koukankykkbn.eq(C_KoukankykKbn.GAITOUKENENARI) +
            $AND + $(subQuerStr) + $EQ  + "'" + pSyoriym + "'" +
            $ORDER_BY(qHT_MosKihon.mosymd.asc(),
                qHT_SyoriCTL.mosno.asc());

        return em.createJPQL(queryStr).bind(qHT_SyoriCTL, qHT_MosKihon, qHT_MosDairiten, qHT_MostenkenRireki).getResultList();
    }

    public ExDBResults<HT_SyoriCTL> getSyoriCTLsBySrsyoriymd(BizDate pSrsyoriymd) {


        QHT_SyoriCTL qHT_SyoriCTL =  new QHT_SyoriCTL();


        String queryStr = $SELECT  + qHT_SyoriCTL +
            $FROM + qHT_SyoriCTL.HT_SyoriCTL() +
            $WHERE + qHT_SyoriCTL.srsyoriymd.eq(pSrsyoriymd);
        return em.createJPQL(queryStr).bind(qHT_SyoriCTL).getResults();
    }

    public List<HT_SyoriCTL> getSyoriCTLsBySakuinnmnoMosnoNe(String pSakuinnmno, String pMosno) {


        QHT_SyoriCTL qHT_SyoriCTL =  new QHT_SyoriCTL();


        QHT_NayoseKekka qHT_NayoseKekka =  new QHT_NayoseKekka();


        String queryStr = $SELECT  + qHT_SyoriCTL +
            $FROM + qHT_SyoriCTL.HT_SyoriCTL() + "," +
            qHT_NayoseKekka.HT_NayoseKekka() +
            $WHERE + qHT_NayoseKekka.sakuinnmno.eq(pSakuinnmno) +
            $AND + qHT_NayoseKekka.mosno.eq(qHT_SyoriCTL.mosno) +
            $AND + qHT_NayoseKekka.mosno.ne(pMosno) +
            $AND + qHT_SyoriCTL.seiritukbn.ne(C_SeirituKbn.SEIRITU) +
            $AND + qHT_SyoriCTL.seiritukbn.ne(C_SeirituKbn.HUSEIRITU);

        return em.createJPQL(queryStr).bind(qHT_SyoriCTL,qHT_NayoseKekka).getResultList();
    }

    public List<HT_SyoriCTL> getSyoriCTLsByDaimosnoMosnoGeSeiritukbnGe(String pDaimosno, String pMosno) {


        QHT_SyoriCTL qHT_SyoriCTL =  new QHT_SyoriCTL();


        String queryStr = $SELECT  + qHT_SyoriCTL +
            $FROM + qHT_SyoriCTL.HT_SyoriCTL() +
            $WHERE + qHT_SyoriCTL.daimosno.eq(pDaimosno) +
            $AND + qHT_SyoriCTL.mosno.ne(pMosno) +
            $AND + qHT_SyoriCTL.seiritukbn.ne(C_SeirituKbn.SEIRITU) +
            $AND + qHT_SyoriCTL.seiritukbn.ne(C_SeirituKbn.HUSEIRITU);

        return em.createJPQL(queryStr).bind(qHT_SyoriCTL).getResultList();
    }

    public List<HT_SyoriCTL> getSyoriCTLsBySyono(String pSyono){


        HT_SyoriCTL hT_SyoriCTL = new HT_SyoriCTL();
        hT_SyoriCTL.setSyono(pSyono);


        return select(hT_SyoriCTL);
    }

    public List<SyoukaiIchiranInfosByMosymdBosyuuymItemsBean> getSyoukaiIchiranInfosByMosymdBosyuuymItems(BizDate pMosfromymd,
        BizDate pMostoymd, String pDaimosno, BizDateYM pBosyuuym, C_UmuKbn pNyknnrkumu, C_KetteiKbn pKetteikbn,
        C_SeirituKbn pSeiritukbn, C_UmuKbn pKthhbkbn, C_HknsyuruiNo pHknsyuruino, String pTratkiagcd,
        String pOyadrtencd, boolean pSrhumu, boolean pMkshb, String pKyknmkn, BizDate pKykseiymd) {


        QHT_SyoriCTL qHT_SyoriCTL = new QHT_SyoriCTL();


        QHT_MosKihon qHT_MosKihon = new QHT_MosKihon();


        QHT_SkHubi qHT_SkHubi = new QHT_SkHubi();


        QHT_SkHubiDetail qHT_SkHubiDetail = new QHT_SkHubiDetail();


        QHT_MosDairiten qHT_MosDairiten = new QHT_MosDairiten();

        String querySql = "";


        if (!StringUtil.isNullOrBlank(pTratkiagcd) || !StringUtil.isNullOrBlank(pOyadrtencd)) {
            querySql = querySql + $SELECT_DISTINCT + $NEW(SyoukaiIchiranInfosByMosymdBosyuuymItemsBean.class,
                qHT_SyoriCTL.mosno,
                qHT_MosKihon.kykkbn,
                qHT_MosKihon.kyknmkn,
                qHT_MosKihon.kyknmkj,
                qHT_MosKihon.hhknnmkn,
                qHT_MosKihon.hhknnmkj,
                qHT_MosKihon.kykseiymd,
                qHT_MosKihon.hhknseiymd,
                qHT_MosKihon.hknsyuruino,
                qHT_SyoriCTL.kktnrkumu,
                qHT_SyoriCTL.nyknnrkumu,
                qHT_SyoriCTL.kthhbkbn,
                qHT_SyoriCTL.srhhbkbn,
                qHT_SyoriCTL.khnhbkbn,
                qHT_SyoriCTL.ketteikbn,
                qHT_SyoriCTL.seiritukbn);
        }
        else {
            querySql = querySql + $SELECT  + $NEW(SyoukaiIchiranInfosByMosymdBosyuuymItemsBean.class,
                qHT_SyoriCTL.mosno,
                qHT_MosKihon.kykkbn,
                qHT_MosKihon.kyknmkn,
                qHT_MosKihon.kyknmkj,
                qHT_MosKihon.hhknnmkn,
                qHT_MosKihon.hhknnmkj,
                qHT_MosKihon.kykseiymd,
                qHT_MosKihon.hhknseiymd,
                qHT_MosKihon.hknsyuruino,
                qHT_SyoriCTL.kktnrkumu,
                qHT_SyoriCTL.nyknnrkumu,
                qHT_SyoriCTL.kthhbkbn,
                qHT_SyoriCTL.srhhbkbn,
                qHT_SyoriCTL.khnhbkbn,
                qHT_SyoriCTL.ketteikbn,
                qHT_SyoriCTL.seiritukbn);
        }

        querySql = querySql + $FROM + qHT_SyoriCTL.HT_SyoriCTL() + ","

            + qHT_MosKihon.HT_MosKihon();


        if (!StringUtil.isNullOrBlank(pTratkiagcd) || !StringUtil.isNullOrBlank(pOyadrtencd)) {

            querySql = querySql + "," + qHT_MosDairiten.HT_MosDairiten();
        }

        querySql = querySql +

            $WHERE + qHT_SyoriCTL.mosno.eq(qHT_MosKihon.mosno);


        if (!StringUtil.isNullOrBlank(pTratkiagcd) || !StringUtil.isNullOrBlank(pOyadrtencd)) {
            querySql = querySql +

                $AND + qHT_SyoriCTL.mosno.eq(qHT_MosDairiten.mosno);
        }


        if (pMkshb) {
            querySql = querySql +
                $AND + $EXISTS( $SELECT + "'X'" +
                    $FROM(qHT_SkHubi,qHT_SkHubiDetail) +
                    $WHERE + qHT_SkHubi.mosno.eq(qHT_SyoriCTL.mosno) +

                    $AND + qHT_SkHubi.hubisikibetukey.eq(qHT_SkHubiDetail.hubisikibetukey) +

                    $AND + qHT_SkHubiDetail.kaisyouymd.isNull());
        }


        if (pMosfromymd != null) {

            querySql = querySql + $AND + qHT_MosKihon.mosymd.ge(pMosfromymd);
        }


        if (pMostoymd != null) {

            querySql = querySql + $AND + qHT_MosKihon.mosymd.le(pMostoymd);
        }


        if (!StringUtil.isNullOrBlank(pDaimosno)) {

            querySql = querySql + $AND + qHT_SyoriCTL.daimosno.eq(pDaimosno);
        }


        if (pBosyuuym != null) {

            querySql = querySql + $AND + qHT_MosKihon.bosyuuym.eq(pBosyuuym);
        }


        if (pNyknnrkumu != null) {

            querySql = querySql + $AND + qHT_SyoriCTL.nyknnrkumu.eq(pNyknnrkumu);
        }


        if (pKetteikbn != null && !C_KetteiKbn.BLNK.eq(pKetteikbn)) {

            querySql = querySql + $AND + qHT_SyoriCTL.ketteikbn.eq(pKetteikbn);
        }


        if (pSeiritukbn != null && !C_SeirituKbn.BLNK.eq(pSeiritukbn) ) {

            querySql = querySql + $AND + qHT_SyoriCTL.seiritukbn.eq(pSeiritukbn);
        }


        if (pKthhbkbn != null && !C_UmuKbn.NONE.eq(pKthhbkbn)) {

            querySql = querySql + $AND + qHT_SyoriCTL.kthhbkbn.eq(pKthhbkbn);
        }


        if (pSrhumu) {

            querySql = querySql + $AND + $(qHT_SyoriCTL.srhhbkbn.eq(C_UmuKbn.ARI)

                + $OR + qHT_SyoriCTL.jimusrhkbn.eq(C_JimusrhKbn.HORYU));
        }


        if (!StringUtil.isNullOrBlank(pTratkiagcd)) {

            querySql = querySql + $AND + qHT_MosDairiten.tratkiagcd.eq(pTratkiagcd);
        }


        if (!StringUtil.isNullOrBlank(pOyadrtencd)) {

            querySql = querySql + $AND + qHT_MosDairiten.oyadrtencd.eq(pOyadrtencd);
        }


        if (pHknsyuruino != null) {

            querySql = querySql + $AND + qHT_MosKihon.hknsyuruino.eq(pHknsyuruino);
        }


        if (!StringUtil.isNullOrBlank(pKyknmkn)) {
            querySql = querySql + $AND + $(

                (qHT_MosKihon.kykkbn.eq(C_KykKbn.KEIHI_DOUITU) + $AND + qHT_MosKihon.hhknnmkn.like("%" + pKyknmkn + "%"))

                + $OR + (qHT_MosKihon.kykkbn.eq(C_KykKbn.KEIHI_BETU) + $AND + qHT_MosKihon.kyknmkn.like("%" + pKyknmkn + "%")));
        }


        if (pKykseiymd != null) {
            querySql = querySql + $AND + $(

                (qHT_MosKihon.kykkbn.eq(C_KykKbn.KEIHI_DOUITU) + $AND + qHT_MosKihon.hhknseiymd.eq(pKykseiymd))

                + $OR + (qHT_MosKihon.kykkbn.eq(C_KykKbn.KEIHI_BETU) + $AND + qHT_MosKihon.kykseiymd.eq(pKykseiymd)));
        }


        querySql = querySql + $ORDER_BY(qHT_SyoriCTL.mosno.asc());

        return em.createJPQL(querySql).bind(qHT_SyoriCTL, qHT_MosKihon, qHT_SkHubi, qHT_SkHubiDetail,qHT_MosDairiten).setFirstResult(0).setMaxResults(1001).getResultList();
    }

    public ExDBUpdatableResults<HT_SyoriCTL> getSyoriCTLsByKakutyoujobcdSeiritukbnSeisekiymBosyuuym(BizDateYM pSeisekiym, BizDateYM pBosyuuym) {


        QHT_SyoriCTL qHT_SyoriCTL = new QHT_SyoriCTL();
        QHT_MosKihon qHT_MosKihon = new QHT_MosKihon();


        String strSql = $SELECT + qHT_SyoriCTL +
            $FROM + qHT_SyoriCTL.HT_SyoriCTL() + "," +
            qHT_MosKihon.HT_MosKihon() +
            $WHERE + qHT_SyoriCTL.mosno.eq(qHT_MosKihon.mosno) +
            $AND + qHT_SyoriCTL.seiritukbn.in(C_SeirituKbn.NONE, C_SeirituKbn.ITIPMATI) +
            $AND + "(" + qHT_MosKihon.seisekiym.lt(pSeisekiym) +
            $OR + qHT_MosKihon.bosyuuym.lt(pBosyuuym) + ")";

        return em.createJPQL(strSql).bind(qHT_SyoriCTL, qHT_MosKihon).getUpdatableResults();
    }

    public ExDBResults<HT_SyoriCTL> getSyoriCTLsByKakutyoujobcdSeiritukbnSeisekiym(BizDateYM pSeisekiym) {


        QHT_SyoriCTL qHT_SyoriCTL = new QHT_SyoriCTL();


        QHT_MosKihon qHT_MosKihon = new QHT_MosKihon();


        String strSql = $SELECT + qHT_SyoriCTL +
            $FROM + qHT_SyoriCTL.HT_SyoriCTL() + "," +
            qHT_MosKihon.HT_MosKihon() +
            $WHERE + qHT_SyoriCTL.mosno.eq(qHT_MosKihon.mosno) +
            $AND + qHT_SyoriCTL.seiritukbn.eq(C_SeirituKbn.SEIRITU) +
            $AND + qHT_MosKihon.seisekiym.eq(pSeisekiym);

        return em.createJPQL(strSql).bind(qHT_SyoriCTL, qHT_MosKihon).getResults();
    }

    public ExDBResults<HT_SyoriCTL> getSyoriCTLsByKakutyoujobcdSeisekiym(BizDateYM pSeisekiym) {


        QHT_SyoriCTL qHT_SyoriCTL = new QHT_SyoriCTL();

        QHT_MosKihon qHT_MosKihon = new QHT_MosKihon();


        String strSql = $SELECT + qHT_SyoriCTL +
            $FROM + qHT_SyoriCTL.HT_SyoriCTL() + "," +
            qHT_MosKihon.HT_MosKihon() +
            $WHERE + qHT_SyoriCTL.seiritukbn.in(C_SeirituKbn.SEIRITU, C_SeirituKbn.HUSEIRITU) +
            $AND + qHT_SyoriCTL.mosno.eq(qHT_MosKihon.mosno) +
            $AND + qHT_MosKihon.seisekiym.eq(pSeisekiym) +
            $ORDER_BY(qHT_SyoriCTL.mosno.asc());

        return em.createJPQL(strSql).bind(qHT_SyoriCTL, qHT_MosKihon).getResults();
    }

    public ExDBResults<SkhubibunsekiInfosBean> getSkhubibunsekiInfos(BizDate pTysytTaisyouYmdFrom, BizDate pTysytTaisyouYmdTo) {


        QHT_SyoriCTL qHT_SyoriCTL = new QHT_SyoriCTL("qHT_SyoriCTL");
        QHT_MosKihon qHT_MosKihon = new QHT_MosKihon("qHT_MosKihon");
        QHT_MosDairiten qHT_MosDairiten = new QHT_MosDairiten("qHT_MosDairiten");
        QHT_SkHubi qHT_SkHubi = new QHT_SkHubi("qHT_SkHubi");
        QBM_Dairiten qBM_Dairiten = new QBM_Dairiten("qBM_Dairiten");
        QHT_SkHubiDetail qHT_SkHubiDetail = new QHT_SkHubiDetail("qHT_SkHubiDetail");
        QHM_SkHubiNaiyou qHM_SkHubiNaiyou = new QHM_SkHubiNaiyou("qHM_SkHubiNaiyou");
        QHM_SkHubiKoumoku qHM_SkHubiKoumoku = new QHM_SkHubiKoumoku("qHM_SkHubiKoumoku");
        QHM_SkSeibiSijiNaiyou qHM_SkSeibiSijiNaiyou = new QHM_SkSeibiSijiNaiyou("qHM_SkSeibiSijiNaiyou");
        QHT_MosSyouhn qHT_MosSyouhn = new QHT_MosSyouhn("qHT_MosSyouhn");
        QBM_SyouhnZokusei qBM_SyouhnZokusei = new QBM_SyouhnZokusei("qBM_SyouhnZokusei");


        String strSql = $SELECT + $NEW(SkhubibunsekiInfosBean.class,
            qHT_SyoriCTL,
            qHT_MosKihon,
            qHT_MosDairiten,
            qHT_SkHubi,
            qBM_Dairiten,
            qHT_SkHubiDetail,
            qHM_SkHubiNaiyou,
            qHM_SkHubiKoumoku,
            qHM_SkSeibiSijiNaiyou,
            qHT_MosSyouhn,
            qBM_SyouhnZokusei) +
            $FROM(qHT_SyoriCTL,
                qHT_MosKihon,
                qHT_MosDairiten,
                qHT_SkHubi,
                qBM_Dairiten,
                qHT_SkHubiDetail,
                qHM_SkHubiNaiyou,
                qHM_SkHubiKoumoku,
                qHM_SkSeibiSijiNaiyou,
                qHT_MosSyouhn,
                qBM_SyouhnZokusei) +
                $WHERE + qHT_SyoriCTL.mosno.eq(qHT_MosKihon.mosno) +
                $AND + qHT_SyoriCTL.mosno.eq(qHT_MosDairiten.mosno) +
                $AND + qHT_SyoriCTL.mosno.eq(qHT_SkHubi.mosno) +
                $AND + qHT_SkHubi.mosno.eq(qHT_SkHubiDetail.mosno) +
                $AND + qHT_SkHubi.hubisikibetukey.eq(qHT_SkHubiDetail.hubisikibetukey) +
                $AND + "(" + qHT_SkHubiDetail.skhubikoumokucd.eq(qHM_SkHubiNaiyou.skhubikoumokucd) +
                $AND + qHT_SkHubiDetail.skhubinaiyoucd.eq(qHM_SkHubiNaiyou.skhubinaiyoucd) + ")" +
                $AND + "(" + qHT_SkHubiDetail.syoruiCd.eq(qHM_SkHubiKoumoku.syoruiCd) +
                $AND + qHT_SkHubiDetail.skhubikoumokucd.eq(qHM_SkHubiKoumoku.skhubikoumokucd) + ")" +
                $AND + qHT_SkHubiDetail.skseibisijinaiyoucd.eq(qHM_SkSeibiSijiNaiyou.skseibisijinaiyoucd) +
                $AND + qHT_MosDairiten.tratkiagcd.eq(qBM_Dairiten.drtencd) +
                $AND + qHT_SyoriCTL.mosno.eq(qHT_MosSyouhn.mosno) +
                $AND + qHT_MosSyouhn.syouhncd.eq(qBM_SyouhnZokusei.syouhncd) +
                $AND + qHT_MosSyouhn.syouhnsdno.eq(qBM_SyouhnZokusei.syouhnsdno) +
                $AND + qHT_MosDairiten.renno.eq(1) +
                $AND + "(" + qHT_SyoriCTL.mosnrkymd.ge(pTysytTaisyouYmdFrom) +
                $AND + qHT_SyoriCTL.mosnrkymd.le(pTysytTaisyouYmdTo) + ")" +
                $AND + qHT_MosSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
                $AND + "(" + qHT_SkHubiDetail.hasinymd.ge(pTysytTaisyouYmdFrom) +
                $AND + qHT_SkHubiDetail.hasinymd.le(pTysytTaisyouYmdTo) + ")" +
                $ORDER_BY(qHT_SyoriCTL.mosnrkymd.asc(),
                    qHT_SyoriCTL.mosno.asc());


        return em.createJPQL(strSql, SkhubibunsekiInfosBean.class).bind(qHT_SyoriCTL, qHT_MosKihon, qHT_MosDairiten, qHT_SkHubi,
            qBM_Dairiten, qHT_SkHubiDetail, qHM_SkHubiNaiyou, qHM_SkHubiKoumoku, qHM_SkSeibiSijiNaiyou, qHT_MosSyouhn, qBM_SyouhnZokusei).getResults();
    }

    public ExDBUpdatableResults<HT_SyoriCTL> getSyoriCTLsByKakutyoujobcdSeiritukbnMosnrkumuMosymNyknnrkumu(
        BizDateYM pHanteikijyunymnyuukin, BizDateYM pHanteikijyunymminyuukin) {


        QHT_SyoriCTL qHT_SyoriCTL = new QHT_SyoriCTL();


        QHT_MosKihon qHT_MosKihon = new QHT_MosKihon();


        String strSql = $SELECT + qHT_SyoriCTL +
            $FROM + qHT_SyoriCTL.HT_SyoriCTL() + "," +
            qHT_MosKihon.HT_MosKihon() +
            $WHERE + qHT_SyoriCTL.seiritukbn.in(C_SeirituKbn.NONE, C_SeirituKbn.ITIPMATI) +
            $AND + qHT_SyoriCTL.mosnrkumu.eq(C_UmuKbn.ARI) +
            $AND + qHT_MosKihon.mosno.eq(qHT_SyoriCTL.mosno) +
            $AND + "(" + "(" + qHT_MosKihon.mosym.lt(pHanteikijyunymnyuukin) +
            $AND + qHT_SyoriCTL.nyknnrkumu.eq(C_UmuKbn.ARI) + ")" +
            $OR + "(" + qHT_MosKihon.mosym.lt(pHanteikijyunymminyuukin) +
            $AND + qHT_SyoriCTL.nyknnrkumu.eq(C_UmuKbn.NONE) + ")" + ")";

        return em.createJPQL(strSql).bind(qHT_SyoriCTL, qHT_MosKihon).getUpdatableResults();
    }

    public ExDBUpdatableResults<HT_SyoriCTL> getSyoriCTLsByKakutyoujobcdSeiritukbnMosnrkumuMosym(BizDateYM pHanteikijyunymdto,
        BizDateYM pHanteikijyunymdfrom) {


        QHT_SyoriCTL qHT_SyoriCTL = new QHT_SyoriCTL();


        QHT_MosKihon qHT_MosKihon = new QHT_MosKihon();


        String strSql = $SELECT + qHT_SyoriCTL +
            $FROM + qHT_SyoriCTL.HT_SyoriCTL() + "," +
            qHT_MosKihon.HT_MosKihon() +
            $WHERE + qHT_SyoriCTL.seiritukbn.in(C_SeirituKbn.NONE, C_SeirituKbn.ITIPMATI) +
            $AND + qHT_SyoriCTL.mosnrkumu.eq(C_UmuKbn.ARI) +
            $AND + qHT_MosKihon.mosno.eq(qHT_SyoriCTL.mosno) +
            $AND + qHT_MosKihon.mosym.lt(pHanteikijyunymdto) +
            $AND + qHT_MosKihon.mosym.ge(pHanteikijyunymdfrom);

        return em.createJPQL(strSql).bind(qHT_SyoriCTL, qHT_MosKihon).getUpdatableResults();
    }

    public ExDBUpdatableResults<HT_SyoriCTL> getSyoriCTLsByKakutyoujobcdSrsyoriymd(BizDate pSrsyoriymd) {


        QHT_SyoriCTL qHT_SyoriCTL = new QHT_SyoriCTL();


        String strSql = $SELECT + qHT_SyoriCTL +
            $FROM + qHT_SyoriCTL.HT_SyoriCTL() +
            $WHERE + qHT_SyoriCTL.seiritukbn.eq(C_SeirituKbn.SEIRITU) +
            $AND + qHT_SyoriCTL.srsyoriymd.eq(pSrsyoriymd) +
            $ORDER_BY(qHT_SyoriCTL.mosno.asc());

        return em.createJPQL(strSql).bind(qHT_SyoriCTL).getUpdatableResults();
    }

    public ExDBResults<HT_SyoriCTL> getSyoriCTLsByKakutyoujobcdMosymKetkekkacds(BizDateYM pMosym) {


        QHT_SyoriCTL qHT_SyoriCTL = new QHT_SyoriCTL();
        QHT_MosKihon qHT_MosKihon = new QHT_MosKihon();
        QHT_DakuhiKettei qHT_DakuhiKettei1 = new QHT_DakuhiKettei("qHT_DakuhiKettei1");
        QHT_DakuhiKettei qHT_DakuhiKettei2 = new QHT_DakuhiKettei("qHT_DakuhiKettei2");


        String strSubSql = $SELECT + qHT_DakuhiKettei2.mosno +
            $FROM + qHT_DakuhiKettei2.HT_DakuhiKettei() +
            $WHERE + qHT_DakuhiKettei1.mosno.eq(qHT_DakuhiKettei2.mosno) +
            $GROUP_BY + qHT_DakuhiKettei2.mosno +
            $HAVING + $MAX(qHT_DakuhiKettei2.dakuhiktrenno) + $EQ + qHT_DakuhiKettei1.dakuhiktrenno;


        String strMainSql = $SELECT + qHT_SyoriCTL +
            $FROM + qHT_SyoriCTL.HT_SyoriCTL() + "," +
            qHT_MosKihon.HT_MosKihon() + "," +
            qHT_DakuhiKettei1.HT_DakuhiKettei() +
            $WHERE + qHT_SyoriCTL.mosno.eq(qHT_MosKihon.mosno) +
            $AND + qHT_SyoriCTL.mosno.eq(qHT_DakuhiKettei1.mosno) +
            $AND + qHT_MosKihon.mosym.eq(pMosym) +
            $AND + $EXISTS(strSubSql) +
            $AND + qHT_DakuhiKettei1.ketkekkacd.in(C_Ketkekkacd.MUJYOUKEN
                , C_Ketkekkacd.GENKAITAI_SYOUDAKU
                , C_Ketkekkacd.MIAWASE
                , C_Ketkekkacd.ENKI_SIJINASI
                , C_Ketkekkacd.ENKI_SUUNENGOSAISIN)
                + $ORDER_BY(qHT_SyoriCTL.mosno.asc());


        return em.createJPQL(strMainSql).bind(qHT_SyoriCTL, qHT_MosKihon, qHT_DakuhiKettei1, qHT_DakuhiKettei2).getResults();
    }

    public ExDBResults<HT_SyoriCTL> getSyoriCTLsByKakutyoujobcdMosym(BizDateYM pMosymFrom, BizDateYM pMosymTo) {


        QHT_SyoriCTL qHT_SyoriCTL = new QHT_SyoriCTL();
        QHT_MosKihon qHT_MosKihon = new QHT_MosKihon();


        String strSql = $SELECT + qHT_SyoriCTL +
            $FROM + qHT_SyoriCTL.HT_SyoriCTL() + "," +
            qHT_MosKihon.HT_MosKihon() +
            $WHERE + qHT_SyoriCTL.mosno.eq(qHT_MosKihon.mosno) +
            $AND + qHT_SyoriCTL.mosnrkumu.eq(C_UmuKbn.ARI) +
            $AND + qHT_MosKihon.mosym.ge(pMosymFrom) +
            $AND + qHT_MosKihon.mosym.le(pMosymTo);


        return em.createJPQL(strSql).bind(qHT_SyoriCTL, qHT_MosKihon).getResults();
    }

    public ExDBResults<HT_SyoriCTL> getSyoriCTLsByKakutyoujobcdSeiritukbnBosyuuym(BizDateYM pBosyuuym) {


        QHT_SyoriCTL qHT_SyoriCTL = new QHT_SyoriCTL();
        QHT_MosKihon qHT_MosKihon = new QHT_MosKihon();


        String strSql = $SELECT + qHT_SyoriCTL +
            $FROM + qHT_SyoriCTL.HT_SyoriCTL() +
            "," +qHT_MosKihon.HT_MosKihon() +
            $WHERE + qHT_SyoriCTL.seiritukbn.eq(C_SeirituKbn.SEIRITU) +
            $AND + qHT_SyoriCTL.mosno.eq(qHT_MosKihon.mosno) +
            $AND + qHT_MosKihon.bosyuuym.eq(pBosyuuym);


        return em.createJPQL(strSql).bind(qHT_SyoriCTL, qHT_MosKihon).getResults();
    }

    public ExDBResults<HT_SyoriCTL> getSyoriCTLsByKakutyoujobcdMosnrkumuMosnrkymd(BizDate pMosnrkymd) {


        QHT_SyoriCTL qHT_SyoriCTL = new QHT_SyoriCTL();


        String strSql = $SELECT + qHT_SyoriCTL +
            $FROM + qHT_SyoriCTL.HT_SyoriCTL() +
            $WHERE + qHT_SyoriCTL.mosnrkumu.eq(C_UmuKbn.ARI) +
            $AND + qHT_SyoriCTL.mosnrkymd.ge(pMosnrkymd);


        return em.createJPQL(strSql).bind(qHT_SyoriCTL).getResults();
    }

    public ExDBResults<HT_SyoriCTL> getSyoriCTLsByKakutyoujobcdSeiritukbnSrsyoriymd(C_SeirituKbn pSeiritukbn, BizDate pSrsyoriymd) {


        QHT_SyoriCTL qHT_SyoriCTL = new QHT_SyoriCTL();


        String strSql = $SELECT + qHT_SyoriCTL +
            $FROM + qHT_SyoriCTL.HT_SyoriCTL() +
            $WHERE + qHT_SyoriCTL.seiritukbn.eq(pSeiritukbn) +
            $AND + qHT_SyoriCTL.srsyoriymd.eq(pSrsyoriymd);


        return em.createJPQL(strSql).bind(qHT_SyoriCTL).getResults();
    }

    public ExDBResults<HT_SyoriCTL> getSyoriCTLsByKakutyoujobcdSrsyoriymdSeiritukbns(BizDate pSrsyoriymd) {


        QHT_SyoriCTL qHT_SyoriCTL = new QHT_SyoriCTL();


        String strSql = $SELECT + qHT_SyoriCTL +
            $FROM + qHT_SyoriCTL.HT_SyoriCTL() +
            $WHERE +
            "(" +
            qHT_SyoriCTL.seiritukbn.eq(C_SeirituKbn.SEIRITU) +
            $OR + qHT_SyoriCTL.seiritukbn.eq(C_SeirituKbn.HUSEIRITU) +
            ")" +
            $AND + qHT_SyoriCTL.srsyoriymd.eq(pSrsyoriymd) +
            $ORDER_BY(qHT_SyoriCTL.mosno.asc());


        return em.createJPQL(strSql).bind(qHT_SyoriCTL).getResults();
    }

    public Long getSyoriCTLCountBySeiritukbnsKykkbn(String pKeiyakusyanm) {


        QHT_SyoriCTL qHT_SyoriCTL = new QHT_SyoriCTL();
        QHT_MosKihon qHT_MosKihon = new QHT_MosKihon();


        String strSql = $SELECT + $COUNT(qHT_SyoriCTL.mosno) +
            $FROM + qHT_SyoriCTL.HT_SyoriCTL() +
            "," + qHT_MosKihon.HT_MosKihon() +
            $WHERE + qHT_SyoriCTL.mosno.eq(qHT_MosKihon.mosno) +
            $AND + qHT_SyoriCTL.seiritukbn.ne(C_SeirituKbn.SEIRITU) +
            $AND + qHT_SyoriCTL.seiritukbn.ne(C_SeirituKbn.HUSEIRITU) +
            $AND +"((" + qHT_MosKihon.kykkbn.eq(C_KykKbn.KEIHI_BETU) +
            $AND + qHT_MosKihon.kyknmkn.eq(pKeiyakusyanm) +
            ")"  +$OR + "(" +
            qHT_MosKihon.kykkbn.eq(C_KykKbn.KEIHI_DOUITU) +
            $AND + qHT_MosKihon.hhknnmkn.eq(pKeiyakusyanm) + "))";


        return em.createJPQL(strSql).bind(qHT_SyoriCTL,qHT_MosKihon).getSingleResult();
    }

    public Long getSyoriCTLCountBySeiritukbnsBsyujoyadrtencdKykkbn(String pBsyujoyadrtencd, String pKeiyakusyanm) {


        QHT_SyoriCTL qHT_SyoriCTL = new QHT_SyoriCTL();
        QHT_MosKihon qHT_MosKihon = new QHT_MosKihon();
        QHT_MosDairiten qHT_MosDairiten = new QHT_MosDairiten();


        String strSql = $SELECT + $COUNT(qHT_SyoriCTL.mosno) +
            $FROM + qHT_SyoriCTL.HT_SyoriCTL() +
            "," + qHT_MosKihon.HT_MosKihon() +
            "," + qHT_MosDairiten.HT_MosDairiten() +
            $WHERE + qHT_SyoriCTL.mosno.eq(qHT_MosKihon.mosno) +
            $AND + qHT_SyoriCTL.mosno.eq(qHT_MosDairiten.mosno) +
            $AND + qHT_MosDairiten.renno.eq(1) +
            $AND + qHT_SyoriCTL.seiritukbn.ne(C_SeirituKbn.SEIRITU) +
            $AND + qHT_SyoriCTL.seiritukbn.ne(C_SeirituKbn.HUSEIRITU) +
            $AND + qHT_MosDairiten.bsyujoyadrtencd.eq(pBsyujoyadrtencd) +
            $AND + "(" + "(" + qHT_MosKihon.kykkbn.eq(C_KykKbn.KEIHI_BETU) +
            $AND + qHT_MosKihon.kyknmkn.eq(pKeiyakusyanm) + ")" +
            $OR + "(" + qHT_MosKihon.kykkbn.eq(C_KykKbn.KEIHI_DOUITU) +
            $AND + qHT_MosKihon.hhknnmkn.eq(pKeiyakusyanm) + ")" + ")";


        return em.createJPQL(strSql).bind(qHT_SyoriCTL, qHT_MosKihon, qHT_MosDairiten).getSingleResult();
    }

    public Long getSyoriCTLCountBySeiritukbnsBsyujoyadrtencd(String pBsyujoyadrtencd) {


        QHT_SyoriCTL qHT_SyoriCTL = new QHT_SyoriCTL();
        QHT_MosDairiten qHT_MosDairiten = new QHT_MosDairiten();


        String strSql = $SELECT + $COUNT(qHT_SyoriCTL.mosno) +
            $FROM + qHT_SyoriCTL.HT_SyoriCTL() +
            "," + qHT_MosDairiten.HT_MosDairiten() +
            $WHERE + qHT_SyoriCTL.mosno.eq(qHT_MosDairiten.mosno) +
            $AND + qHT_SyoriCTL.seiritukbn.ne(C_SeirituKbn.SEIRITU) +
            $AND + qHT_SyoriCTL.seiritukbn.ne(C_SeirituKbn.HUSEIRITU) +
            $AND + qHT_MosDairiten.renno.eq(1) +
            $AND + qHT_MosDairiten.bsyujoyadrtencd.eq(pBsyujoyadrtencd);


        return em.createJPQL(strSql).bind(qHT_SyoriCTL, qHT_MosDairiten).getSingleResult();
    }

    public ExDBResults<HT_SyoriCTL> getSyoriCTLsByHnknsyoriymd(BizDate pHnknsyoriymd) {


        QHT_SyoriCTL qHT_SyoriCTL = new QHT_SyoriCTL();


        QHT_Henkin qHT_Henkin = new QHT_Henkin();

        String strSql = $SELECT + qHT_SyoriCTL +
            $FROM + qHT_SyoriCTL.HT_SyoriCTL() +
            $WHERE + $EXISTS(
                $SELECT + qHT_Henkin.mosno +
                $FROM + qHT_Henkin.HT_Henkin() +
                $WHERE + qHT_Henkin.hnknsyoriymd.eq(pHnknsyoriymd) +
                $AND + qHT_Henkin.hnknhoukbn.ne(C_HnknhouKbn.KARIUKE) +
                $AND + qHT_Henkin.mosno.eq(qHT_SyoriCTL.mosno)) +
                $ORDER_BY(qHT_SyoriCTL.mosno.asc());

        return em.createJPQL(strSql).bind(qHT_SyoriCTL, qHT_Henkin).getResults();
    }

    public ExDBResults<HT_SyoriCTL> getSyoriCTLsBySrsyoriymdNull(BizDate pSrsyoriymd) {


        QHT_SyoriCTL qHT_SyoriCTL = new QHT_SyoriCTL();

        String strSql = $SELECT + qHT_SyoriCTL +
            $FROM + qHT_SyoriCTL.HT_SyoriCTL() +
            $WHERE + qHT_SyoriCTL.srsyoriymd.isNull() +
            $OR + qHT_SyoriCTL.srsyoriymd.gt(pSrsyoriymd);

        return em.createJPQL(strSql).bind(qHT_SyoriCTL).getResults();
    }

    public ExDBResults<HT_SyoriCTL> getSyoriCTLsByBosyuuymFromTo(BizDateYM pBosyuuymFrom, BizDateYM pBosyuuymTo) {


        QHT_SyoriCTL qHT_SyoriCTL = new QHT_SyoriCTL();


        QHT_MosKihon qHT_MosKihon = new QHT_MosKihon();

        String strSql = $SELECT + qHT_SyoriCTL +
            $FROM(qHT_SyoriCTL,
                qHT_MosKihon) +
                $WHERE + qHT_SyoriCTL.mosno.eq(qHT_MosKihon.mosno) +
                $AND + qHT_SyoriCTL.mosnrkumu.eq(C_UmuKbn.ARI) +
                $AND + qHT_MosKihon.bosyuuym.ge(pBosyuuymFrom) +
                $AND + qHT_MosKihon.bosyuuym.le(pBosyuuymTo);

        return em.createJPQL(strSql).bind(qHT_SyoriCTL, qHT_MosKihon).getResults();
    }


    public ExDBResults<HT_SyoriCTL> getSyoriCTLsBySeirituKbnBosyuuymFromTo(BizDateYM pBosyuuymFrom, BizDateYM pBosyuuymTo) {


        QHT_SyoriCTL qHT_SyoriCTL = new QHT_SyoriCTL();


        QHT_MosKihon qHT_MosKihon = new QHT_MosKihon();

        String strSql = $SELECT + qHT_SyoriCTL +
            $FROM ( qHT_SyoriCTL,
                qHT_MosKihon) +
                $WHERE + qHT_SyoriCTL.mosno.eq(qHT_MosKihon.mosno) +
                $AND + qHT_SyoriCTL.seiritukbn.eq(C_SeirituKbn.SEIRITU) +
                $AND + qHT_MosKihon.bosyuuym.ge(pBosyuuymFrom) +
                $AND + qHT_MosKihon.bosyuuym.le(pBosyuuymTo);

        return em.createJPQL(strSql).bind(qHT_SyoriCTL, qHT_MosKihon).getResults();
    }

    public List<HT_SyoriCTL> getSyoriCTLsBySakuinnmnoMosnoNeSntkInfoTaisyousyaKbn(String pSakuinnmno, String pMosno,
        C_SntkInfoTaisyousyaKbn pSntkinfotaisyousyakbn) {


        QHT_SyoriCTL qHT_SyoriCTL =  new QHT_SyoriCTL();


        QHT_NayoseKekka qHT_NayoseKekka = new QHT_NayoseKekka();


        String queryStr = $SELECT  + qHT_SyoriCTL +
            $FROM (qHT_SyoriCTL,
                qHT_NayoseKekka) +
                $WHERE + qHT_NayoseKekka.sakuinnmno.eq(pSakuinnmno) +
                $AND + qHT_NayoseKekka.mosno.eq(qHT_SyoriCTL.mosno) +
                $AND + qHT_NayoseKekka.mosno.ne(pMosno) +
                $AND + qHT_NayoseKekka.sntkinfotaisyousyakbn.eq(pSntkinfotaisyousyakbn) +
                $AND + qHT_SyoriCTL.seiritukbn.ne(C_SeirituKbn.SEIRITU) +
                $AND + qHT_SyoriCTL.seiritukbn.ne(C_SeirituKbn.HUSEIRITU);

        return em.createJPQL(queryStr).bind(qHT_SyoriCTL, qHT_NayoseKekka).getResultList();
    }

    public ExDBResults<HT_SyoriCTL> getSyoriCTLsBySeirituKbnBosyuuym(BizDateYM pBosyuuym) {


        QHT_SyoriCTL qHT_SyoriCTL = new QHT_SyoriCTL();


        QHT_MosKihon qHT_MosKihon = new QHT_MosKihon();

        String strSql = $SELECT + qHT_SyoriCTL +
            $FROM (qHT_SyoriCTL,
                qHT_MosKihon) +
                $WHERE + qHT_SyoriCTL.mosno.eq(qHT_MosKihon.mosno) +
                $AND + qHT_SyoriCTL.seiritukbn.eq(C_SeirituKbn.SEIRITU) +
                $AND + qHT_MosKihon.bosyuuym.eq(pBosyuuym) +
                $ORDER_BY(qHT_SyoriCTL.syono.asc());


        return em.createJPQL(strSql).bind(qHT_SyoriCTL, qHT_MosKihon).getResults();
    }
}
