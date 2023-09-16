package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import yuyu.def.biz.result.bean.BzSkHonsyaDenpyousByDenymdTaisyakukbnBean;
import yuyu.def.biz.result.bean.ZengetubunDenpyouDatasByDenymdFromDenymdToBean;
import yuyu.def.classification.C_DensyoriKbn;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KessantyouseiKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.BT_DenpyoData;
import yuyu.def.db.meta.QBM_KanjyouKamoku;
import yuyu.def.db.meta.QBM_Syoritanto;
import yuyu.def.db.meta.QBM_TantouCd;
import yuyu.def.db.meta.QBT_DenpyoData;
import yuyu.def.db.meta.QHT_MosKihon;
import yuyu.def.db.meta.QIT_KykKihon;

/**
 * 経理伝票データテーブル(BT_DenpyoDataDao) アクセス用の DAO クラスです。<br />
 */
public class BT_DenpyoDataDao extends AbstractDao<BT_DenpyoData> {

    public BT_DenpyoDataDao() {
        super(BT_DenpyoData.class);
    }

    public BT_DenpyoData getDenpyoData(C_DensysKbn pDensyskbn,
        String pDenrenno,
        Integer pEdano){
        BT_DenpyoData bT_DenpyoData =  new BT_DenpyoData();
        bT_DenpyoData.setDensyskbn(pDensyskbn);
        bT_DenpyoData.setDenrenno(pDenrenno);
        bT_DenpyoData.setEdano(pEdano);
        return this.selectOne(bT_DenpyoData);
    }

    public ExDBResults<BT_DenpyoData> getDenpyoDatasByKakutyoujobcdSyoriYmdSeg1cdNeDensyskbns(BizDate pSyoriYmd) {


        QBM_KanjyouKamoku qBM_KanjyouKamoku = new QBM_KanjyouKamoku();


        QBT_DenpyoData qBT_DenpyoData = new QBT_DenpyoData();

        String queryStr = $SELECT + qBT_DenpyoData +
            $FROM + qBM_KanjyouKamoku.BM_KanjyouKamoku() + "," +
            qBT_DenpyoData.BT_DenpyoData() +
            $WHERE + qBT_DenpyoData.syoriYmd.eq(pSyoriYmd)  +
            $AND + qBT_DenpyoData.seg1cd.ne(C_Segcd.BLNK) +
            $AND + qBT_DenpyoData.densyskbn.in(C_DensysKbn.HOZEN, C_DensysKbn.NENKIN, C_DensysKbn.HKSIHARAI) +
            $AND + qBT_DenpyoData.kanjyoukmkcd.eq(qBM_KanjyouKamoku.kanjyoukmkcd) +
            $ORDER_BY (qBT_DenpyoData.denymd.asc() + "," +
                qBT_DenpyoData.taisyakukbn.asc() + "," +
                qBM_KanjyouKamoku.denkanjokamokucd.asc() + "," +
                qBT_DenpyoData.seg1cd.asc() + "," +
                qBT_DenpyoData.seg2cd.asc() + "," +
                qBT_DenpyoData.huridenatesakicd.asc());

        return em.createJPQL(queryStr).bind(qBM_KanjyouKamoku, qBT_DenpyoData).getResults();
    }

    public ExDBResults<BT_DenpyoData> getDenpyoDatasByDenymdSyoriYmdFstpryosyuymd(BizDate pDenymd, BizDate pSyoriYmd, BizDate pFstpryosyuymd) {


        QBT_DenpyoData qBT_DenpyoData1 = new QBT_DenpyoData("qBT_DenpyoData1");


        QBT_DenpyoData qBT_DenpyoData2 = new QBT_DenpyoData("qBT_DenpyoData2");


        String subQuerry = $SELECT + qBT_DenpyoData2.keirisyono +
            $FROM + qBT_DenpyoData2.BT_DenpyoData() +
            $WHERE + qBT_DenpyoData2.kessantyouseikbn.eq(C_KessantyouseiKbn.OIKOMITAISYOU) +
            $AND + qBT_DenpyoData2.densyskbn.eq(C_DensysKbn.SKEI) +
            $AND + qBT_DenpyoData2.densyorikbn.eq(C_DensyoriKbn.SEIRITU) +
            $AND + qBT_DenpyoData2.denymd.ge(pDenymd) +
            $AND + qBT_DenpyoData2.syoriYmd.le(pSyoriYmd) +
            $AND + qBT_DenpyoData2.keirisyono.eq(qBT_DenpyoData1.keirisyono);

        String mainQuerry = $SELECT + qBT_DenpyoData1 +
            $FROM + qBT_DenpyoData1.BT_DenpyoData() +
            $WHERE + "(" + $EXISTS(subQuerry) +
            $AND + qBT_DenpyoData1.denymd.ge(pDenymd) +
            $AND + qBT_DenpyoData1.syoriYmd.le(pSyoriYmd) +
            $AND + qBT_DenpyoData1.densyorikbn.notIn(C_DensyoriKbn.FP_GNKHRKM,
                C_DensyoriKbn.FP_ONLINENYKN, C_DensyoriKbn.FP_CREDITNYKN) + ")" +
                $OR + "("+ $EXISTS(subQuerry) +
                $AND + qBT_DenpyoData1.denymd.ge(pDenymd) +
                $AND + qBT_DenpyoData1.syoriYmd.le(pSyoriYmd) +
                $AND + qBT_DenpyoData1.fstpryosyuymd.le(pFstpryosyuymd) +
                $AND + qBT_DenpyoData1.densyorikbn.in(C_DensyoriKbn.FP_GNKHRKM,
                    C_DensyoriKbn.FP_ONLINENYKN, C_DensyoriKbn.FP_CREDITNYKN) + ")";

        return em.createJPQL(mainQuerry).bind(qBT_DenpyoData1, qBT_DenpyoData2).getResults();

    }

    public ExDBResults<BT_DenpyoData> getDenpyoDatasByKakutyoujobcdSyoriYmd(BizDate pSyoriYmd) {


        QBT_DenpyoData qBT_DenpyoData = new QBT_DenpyoData();


        String strSql = $SELECT + qBT_DenpyoData +
            $FROM + qBT_DenpyoData.BT_DenpyoData() +
            $WHERE + qBT_DenpyoData.syoriYmd.eq(pSyoriYmd) +
            $AND + qBT_DenpyoData.densyskbn.eq(C_DensysKbn.SKEI) +
            $ORDER_BY(qBT_DenpyoData.denymd.asc(),
                qBT_DenpyoData.huridenatesakicd.asc());


        return em.createJPQL(strSql).bind(qBT_DenpyoData).getResults();
    }

    public ExDBResults<BT_DenpyoData> getDenpyoDatasByKakutyoujobcdSyoriYmdDensyskbn(BizDate pSyoriYmd, C_DensysKbn... pDensyskbn) {


        QBT_DenpyoData qBT_DenpyoData = new QBT_DenpyoData();


        String strSql = $SELECT + qBT_DenpyoData +
            $FROM + qBT_DenpyoData.BT_DenpyoData() +
            $WHERE + qBT_DenpyoData.syoriYmd.eq(pSyoriYmd) +
            $AND + qBT_DenpyoData.densyskbn.in(pDensyskbn) +
            $AND + qBT_DenpyoData.seg2cd.eq(C_Segcd.BLNK)  +
            $ORDER_BY(qBT_DenpyoData.densyskbn.asc(),
                qBT_DenpyoData.denrenno.asc(),
                qBT_DenpyoData.edano.asc());


        return em.createJPQL(strSql).bind(qBT_DenpyoData).getResults();
    }

    public List<BT_DenpyoData> getDenpyoDatasByDenymdKanjyoukmkcds(BizDate pKensakuYmdFrom, BizDate pKensakuYmdTo) {


        QBT_DenpyoData qBT_DenpyoData = new QBT_DenpyoData();

        String strSql = $SELECT + qBT_DenpyoData +
            $FROM + qBT_DenpyoData.BT_DenpyoData() +
            $WHERE + qBT_DenpyoData.denymd.ge(pKensakuYmdFrom) +
            $AND + qBT_DenpyoData.denymd.le(pKensakuYmdTo) +
            $AND + "(" + qBT_DenpyoData.kanjyoukmkcd.eq(C_Kanjyoukmkcd.HOKENKEIYAKUSIHARAIRISOKU_GAIHO_JPY) +
            $OR + qBT_DenpyoData.kanjyoukmkcd.eq(C_Kanjyoukmkcd.HOKENKEIYAKUSIHARAIRISOKU_GAIHO_USD) +
            $OR + qBT_DenpyoData.kanjyoukmkcd.eq(C_Kanjyoukmkcd.HOKENKEIYAKUSIHARAIRISOKU_GAIHO_AUD) +
            $OR + qBT_DenpyoData.kanjyoukmkcd.eq(C_Kanjyoukmkcd.HOKENKEIYAKUSIHARAIRISOKU_HUTUU) + ")" +
            $ORDER_BY (qBT_DenpyoData.syoricd.asc(),
                qBT_DenpyoData.taisyakukbn.asc());

        return em.createJPQL(strSql).bind(qBT_DenpyoData).getResultList();
    }

    public List<BzSkHonsyaDenpyousByDenymdTaisyakukbnBean> getBzSkHonsyaDenpyousByDenymdTaisyakukbn(
        BizDate pDenymdFrom, BizDate pDenymdTo, C_TaisyakuKbn pTaisyakukbn) {


        QBT_DenpyoData qBT_DenpyoData = new QBT_DenpyoData("qBT_DenpyoData");
        QBM_KanjyouKamoku qBM_KanjyouKamoku = new QBM_KanjyouKamoku("qBM_KanjyouKamoku");


        String strSql = $SELECT + $NEW(BzSkHonsyaDenpyousByDenymdTaisyakukbnBean.class,
            qBM_KanjyouKamoku.kanjyoukmkgroupkbn,
            qBM_KanjyouKamoku.kanjyoukmknm,
            qBT_DenpyoData.kanjyoukmkcd,
            qBT_DenpyoData.naibukeiyakukbn,
            qBT_DenpyoData.tekiyoukbn,
            qBT_DenpyoData.taisyakukbn,
            qBT_DenpyoData.denyenkagk.getTypeFieldName(),
            $SUM + $(qBT_DenpyoData.denyenkagk.getValueFieldName()),
            $COUNT + "(*)") +
            $FROM + qBT_DenpyoData.BT_DenpyoData() + "," +
            qBM_KanjyouKamoku.BM_KanjyouKamoku() +
            $WHERE + qBT_DenpyoData.kanjyoukmkcd.eq(qBM_KanjyouKamoku.kanjyoukmkcd) +
            $AND + qBT_DenpyoData.densyskbn.eq(C_DensysKbn.SKEI) +
            $AND + qBT_DenpyoData.denyenkagk.eq(BizCurrencyTypes.YEN) +
            $AND + qBT_DenpyoData.denymd.ge(pDenymdFrom) +
            $AND + qBT_DenpyoData.denymd.le(pDenymdTo) +
            $AND + qBT_DenpyoData.taisyakukbn.eq(pTaisyakukbn) +
            $GROUP_BY + qBM_KanjyouKamoku.kanjyoukmkgroupkbn + ","+
            qBM_KanjyouKamoku.kanjyoukmknm + ","+
            qBT_DenpyoData.kanjyoukmkcd+ ","+
            qBT_DenpyoData.naibukeiyakukbn+ ","+
            qBT_DenpyoData.tekiyoukbn+ ","+
            qBT_DenpyoData.taisyakukbn + ","+
            qBT_DenpyoData.denyenkagk.getTypeFieldName()+
            $ORDER_BY(qBM_KanjyouKamoku.kanjyoukmkgroupkbn.asc(),
                qBT_DenpyoData.kanjyoukmkcd.asc(),
                qBT_DenpyoData.naibukeiyakukbn.asc(),
                qBT_DenpyoData.tekiyoukbn.asc());


        return em.createJPQL(strSql, BzSkHonsyaDenpyousByDenymdTaisyakukbnBean.class).bind(qBT_DenpyoData, qBM_KanjyouKamoku).getResultList();
    }

    public ExDBResults<BT_DenpyoData> getDenpyoDatasByKakutyoujobcdSyoriYmdKanjyoukmkcdTaisyakukbnDensyskbn(
        BizDate pSyoriYmd) {


        QBT_DenpyoData qBT_DenpyoData = new QBT_DenpyoData();


        String strSql = $SELECT + qBT_DenpyoData +
            $FROM + qBT_DenpyoData.BT_DenpyoData() +
            $WHERE + qBT_DenpyoData.syoriYmd.eq(pSyoriYmd) +
            $AND + $(qBT_DenpyoData.kanjyoukmkcd.eq(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIHO) +
                $OR +  qBT_DenpyoData.kanjyoukmkcd.eq(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_AZUKARIKIN_GAIHO_JPY) +
                $OR +  qBT_DenpyoData.kanjyoukmkcd.eq(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_AZUKARIKIN_GAIHO_USD) +
                $OR +  qBT_DenpyoData.kanjyoukmkcd.eq(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_AZUKARIKIN_GAIHO_AUD) +
                $OR +  qBT_DenpyoData.kanjyoukmkcd.eq(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_AZUKARIKIN) +
                $OR +  qBT_DenpyoData.kanjyoukmkcd.eq(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_SONOTA)) +
                $AND + qBT_DenpyoData.taisyakukbn.eq(C_TaisyakuKbn.KASIKATA) +
                $AND + qBT_DenpyoData.densyskbn.ne(C_DensysKbn.SKEI) +
                $ORDER_BY (qBT_DenpyoData.syorisosikicd.asc(),
                    qBT_DenpyoData.kanjyoukmkcd.asc(),
                    qBT_DenpyoData.syoricd.asc(),
                    qBT_DenpyoData.keirisyono.asc(),
                    qBT_DenpyoData.denrenno.asc(),
                    qBT_DenpyoData.edano.asc());


        return em.createJPQL(strSql).bind(qBT_DenpyoData).getResults();
    }

    public ExDBResults<BT_DenpyoData> getDenpyoDatasByKakutyoujobcdSyoriYmdKanjyoukmkcds(BizDate pSyoriYmd) {


        QBT_DenpyoData qBT_DenpyoData1 = new QBT_DenpyoData("qBT_DenpyoData1");


        QBT_DenpyoData qBT_DenpyoData2 = new QBT_DenpyoData("qBT_DenpyoData2");


        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");


        QHT_MosKihon qHT_MosKihon = new QHT_MosKihon("qHT_MosKihon");


        String subQuerry = $SELECT + qBT_DenpyoData2.densyskbn +
            $FROM + qBT_DenpyoData2.BT_DenpyoData() +
            $WHERE + qBT_DenpyoData2.densyskbn.eq(qBT_DenpyoData1.densyskbn) +
            $AND + qBT_DenpyoData2.denrenno.eq(qBT_DenpyoData1.denrenno) +
            $AND + qBT_DenpyoData2.taisyakukbn.eq(C_TaisyakuKbn.KASIKATA) +
            $AND + $(qBT_DenpyoData2.kanjyoukmkcd.eq(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_FBSOUKIN) +
                $OR + qBT_DenpyoData2.kanjyoukmkcd.eq(C_Kanjyoukmkcd.SONOTAKARIUKEKIN_GAIKAFBSOUKIN));


        String subQueryKyk = $SELECT + qIT_KykKihon.syono +
            $FROM + qIT_KykKihon.IT_KykKihon() +
            $WHERE + qIT_KykKihon.syono.eq(qBT_DenpyoData1.keirisyono) +
            $AND + qIT_KykKihon.hrkkaisuu.eq(C_Hrkkaisuu.ITIJI);


        String subQueryMos = $SELECT + qHT_MosKihon.mosno +
            $FROM + qHT_MosKihon.HT_MosKihon() +
            $WHERE + qHT_MosKihon.mosno.eq(qBT_DenpyoData1.keirisyono) +
            $AND + qHT_MosKihon.hrkkaisuu.eq(C_Hrkkaisuu.ITIJI);


        String mainQuerry = $SELECT + qBT_DenpyoData1 +
            $FROM (qBT_DenpyoData1) +
            $WHERE + qBT_DenpyoData1.syoriYmd.eq(pSyoriYmd) +
            $AND + qBT_DenpyoData1.kyktuukasyu.ne(C_Tuukasyu.JPY) +
            $AND + qBT_DenpyoData1.kyktuukasyu.ne(C_Tuukasyu.BLNK) +
            $AND + $EXISTS(subQuerry) +
            $AND + "(" + $EXISTS(subQueryKyk) +
            $OR + "(" + $NOT_EXISTS(subQueryKyk) +
            $AND + $EXISTS(subQueryMos) + "))" +
            $ORDER_BY(qBT_DenpyoData1.densyskbn.asc(),
                qBT_DenpyoData1.denrenno.asc(),
                qBT_DenpyoData1.edano.asc());

        return em.createJPQL(mainQuerry).bind(qBT_DenpyoData1, qBT_DenpyoData2, qIT_KykKihon, qHT_MosKihon).getResults();
    }
    public ExDBResults<BT_DenpyoData> getDenpyoDatasBySyoriYmdSeg1cdNeDensyskbn(BizDate pSyoriYmd) {


        QBM_KanjyouKamoku qBM_KanjyouKamoku = new QBM_KanjyouKamoku();


        QBT_DenpyoData qBT_DenpyoData = new QBT_DenpyoData();

        String queryStr = $SELECT + qBT_DenpyoData +
            $FROM + qBM_KanjyouKamoku.BM_KanjyouKamoku() + "," +
            qBT_DenpyoData.BT_DenpyoData() +
            $WHERE + qBT_DenpyoData.syoriYmd.eq(pSyoriYmd) +
            $AND + qBT_DenpyoData.seg1cd.ne(C_Segcd.BLNK) +
            $AND + qBT_DenpyoData.densyskbn.eq(C_DensysKbn.SKEI) +
            $AND + qBT_DenpyoData.kanjyoukmkcd.eq(qBM_KanjyouKamoku.kanjyoukmkcd) +
            $ORDER_BY (qBT_DenpyoData.denymd.asc(),
                qBT_DenpyoData.huridenatesakicd.asc(),
                qBT_DenpyoData.taisyakukbn.asc(),
                qBM_KanjyouKamoku.denkanjokamokucd.asc(),
                qBT_DenpyoData.seg1cd.asc(),
                qBT_DenpyoData.naibukeiyakukbn.asc(),
                qBT_DenpyoData.tekiyoukbn.asc());

        return em.createJPQL(queryStr).bind(qBM_KanjyouKamoku, qBT_DenpyoData).getResults();
    }

    public ExDBResults<BT_DenpyoData> getDenpyoDatasBySyoriYmdSeg1cdNeDensyskbns(BizDate pSyoriYmd) {


        QBM_KanjyouKamoku qBM_KanjyouKamoku = new QBM_KanjyouKamoku();


        QBT_DenpyoData qBT_DenpyoData = new QBT_DenpyoData();

        String queryStr = $SELECT + qBT_DenpyoData +
            $FROM + qBM_KanjyouKamoku.BM_KanjyouKamoku() + "," +
            qBT_DenpyoData.BT_DenpyoData() +
            $WHERE + qBT_DenpyoData.syoriYmd.eq(pSyoriYmd) +
            $AND + qBT_DenpyoData.seg1cd.ne(C_Segcd.BLNK) +
            $AND + "(" + qBT_DenpyoData.densyskbn.eq(C_DensysKbn.HOZEN) +
            $OR + qBT_DenpyoData.densyskbn.eq(C_DensysKbn.NENKIN) +
            $OR + qBT_DenpyoData.densyskbn.eq(C_DensysKbn.HKSIHARAI) + ")" +
            $AND + qBT_DenpyoData.kanjyoukmkcd.eq(qBM_KanjyouKamoku.kanjyoukmkcd) +
            $ORDER_BY (qBT_DenpyoData.denymd.asc(),
                qBT_DenpyoData.taisyakukbn.asc(),
                qBM_KanjyouKamoku.denkanjokamokucd.asc(),
                qBT_DenpyoData.seg1cd.asc(),
                qBT_DenpyoData.seg2cd.asc(),
                qBT_DenpyoData.huridenatesakicd.asc());

        return em.createJPQL(queryStr).bind(qBM_KanjyouKamoku, qBT_DenpyoData).getResults();
    }

    public ExDBResults<ZengetubunDenpyouDatasByDenymdFromDenymdToBean> getZengetubunDenpyouDatasByDenymdFromDenymdTo(
        BizDate pDenymdFrom, BizDate pDenymdTo) {


        QBT_DenpyoData qBT_DenpyoData = new QBT_DenpyoData("q1");


        QBM_KanjyouKamoku qBM_KanjyouKamoku = new QBM_KanjyouKamoku("q2");


        QBM_Syoritanto qBM_Syoritanto = new QBM_Syoritanto("q3");


        QBM_TantouCd qBM_TantouCd = new QBM_TantouCd("q4");


        String strSubSql1 = " CASE " +
            " WHEN " + qBT_DenpyoData.taisyakukbn.eq(C_TaisyakuKbn.KARIKATA) +
            " THEN " + qBT_DenpyoData.denyenkagk.getValueFieldName() +
            " ELSE 0 " +
            " END ";


        String strSubSql2 = " CASE " +
            " WHEN" + qBT_DenpyoData.taisyakukbn.eq(C_TaisyakuKbn.KASIKATA) +
            " THEN " + qBT_DenpyoData.denyenkagk.getValueFieldName() +
            " ELSE 0 " +
            " END ";


        String strSql = $SELECT + $NEW(ZengetubunDenpyouDatasByDenymdFromDenymdToBean.class,
            qBM_KanjyouKamoku.hjybtantositucd,
            qBT_DenpyoData.syorisosikicd,
            qBT_DenpyoData.kanjyoukmkcd,
            qBT_DenpyoData.denymd,
            qBT_DenpyoData.syoricd,
            qBT_DenpyoData.huridenatesakicd,
            qBM_TantouCd.busitucd,
            qBT_DenpyoData.denyenkagk.getTypeFieldName(),
            $SUM + $(strSubSql1),
            qBT_DenpyoData.denyenkagk.getTypeFieldName(),
            $SUM + $(strSubSql2)) +
            $FROM + qBT_DenpyoData.BT_DenpyoData() + "," +
            qBM_KanjyouKamoku.BM_KanjyouKamoku() + "," +
            qBM_Syoritanto.BM_Syoritanto() + "," +
            qBM_TantouCd.BM_TantouCd() +
            $WHERE + qBT_DenpyoData.denymd.ge(pDenymdFrom) +
            $AND + qBT_DenpyoData.denymd.le(pDenymdTo) +
            $AND + qBM_KanjyouKamoku.hjybyouhyj.eq(C_YouhiKbn.YOU) +
            $AND + qBM_KanjyouKamoku.kanjyoukmkcd.eq(qBT_DenpyoData.kanjyoukmkcd) +
            $AND + qBM_Syoritanto.syoricd.eq(qBT_DenpyoData.syoricd) +
            $AND + qBM_TantouCd.tantocd.eq(qBM_Syoritanto.tantocd) +
            $AND + qBT_DenpyoData.denyenkagk.eq(BizCurrencyTypes.YEN) +
            $GROUP_BY + qBM_KanjyouKamoku.hjybtantositucd + "," +
            qBT_DenpyoData.syorisosikicd + "," +
            qBT_DenpyoData.kanjyoukmkcd + "," +
            qBT_DenpyoData.denymd + "," +
            qBM_TantouCd.busitucd + "," +
            qBT_DenpyoData.syoricd + "," +
            qBT_DenpyoData.huridenatesakicd + "," +
            qBT_DenpyoData.denyenkagk.getTypeFieldName() +
            $ORDER_BY(qBM_KanjyouKamoku.hjybtantositucd.asc(),
                qBT_DenpyoData.syorisosikicd.asc(),
                qBT_DenpyoData.kanjyoukmkcd.asc(),
                qBT_DenpyoData.denymd.asc(),
                qBM_TantouCd.busitucd.asc(),
                qBT_DenpyoData.syoricd.asc(),
                qBT_DenpyoData.huridenatesakicd.asc());

        return em.createJPQL(strSql,ZengetubunDenpyouDatasByDenymdFromDenymdToBean.class).bind(qBT_DenpyoData, qBM_KanjyouKamoku, qBM_Syoritanto, qBM_TantouCd).getResults();
    }

    public List<BT_DenpyoData> getDenpyoDatasByDensyskbnKeirisyonoDensyorikbn(C_DensysKbn pDensyskbn,
        String pKeirisyono, C_DensyoriKbn pDensyorikbn) {

        BT_DenpyoData bT_DenpyoData = new BT_DenpyoData();
        bT_DenpyoData.setDensyskbn(pDensyskbn);
        bT_DenpyoData.setKeirisyono(pKeirisyono);
        bT_DenpyoData.setDensyorikbn(pDensyorikbn);

        return select(bT_DenpyoData);
    }

    public ExDBResults<BT_DenpyoData> getDenpyoDatasBySyoriYmdDensyskbn(BizDate pSyoriYmdFrom, BizDate pSyoriYmdTo,
        C_DensysKbn pDensyskbn) {


        QBT_DenpyoData qBT_DenpyoData = new QBT_DenpyoData();

        String queryStr = $SELECT + qBT_DenpyoData +
            $FROM + qBT_DenpyoData.BT_DenpyoData() +
            $WHERE + qBT_DenpyoData.syoriYmd.gt(pSyoriYmdFrom) +
            $AND + qBT_DenpyoData.syoriYmd.le(pSyoriYmdTo) +
            $AND + qBT_DenpyoData.densyskbn.eq(pDensyskbn) +
            $AND + $(qBT_DenpyoData.kanjyoukmkcd.eq(C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_JPY) +
                $OR + qBT_DenpyoData.kanjyoukmkcd.eq(C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_USD) +
                $OR + qBT_DenpyoData.kanjyoukmkcd.eq(C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_AUD));

        return em.createJPQL(queryStr).bind(qBT_DenpyoData).getResults();
    }


    public List<BT_DenpyoData> getDenpyoDatasByDensyskbnKeirisyonoDensyorikbn(C_DensysKbn pDensyskbn,
        String pKeirisyono, C_DensyoriKbn pDensyorikbn, BizDate pDenymd) {


        QBT_DenpyoData qBT_DenpyoData = new QBT_DenpyoData();


        String queryStr = $SELECT + qBT_DenpyoData +
            $FROM (qBT_DenpyoData) +
            $WHERE + qBT_DenpyoData.densyskbn.eq(pDensyskbn) +
            $AND + qBT_DenpyoData.keirisyono.eq(pKeirisyono) +
            $AND + qBT_DenpyoData.densyorikbn.eq(pDensyorikbn) +
            $AND + qBT_DenpyoData.denymd.ge(pDenymd) ;

        return em.createJPQL(queryStr).bind(qBT_DenpyoData).getResultList();
    }

}
