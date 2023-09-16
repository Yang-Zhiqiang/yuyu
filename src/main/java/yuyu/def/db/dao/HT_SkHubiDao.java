package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_HasinkyokaKbn;
import yuyu.def.classification.C_SeirituKbn;
import yuyu.def.db.entity.HT_SkHubi;
import yuyu.def.db.meta.QHT_MosDairiten;
import yuyu.def.db.meta.QHT_MosKihon;
import yuyu.def.db.meta.QHT_SkHubi;
import yuyu.def.db.meta.QHT_SkHubiDetail;
import yuyu.def.db.meta.QHT_SyoriCTL;
import yuyu.def.sinkeiyaku.result.bean.HubiInfosByKakutyoujobcdHasinkyokakbnHasinymdBean;
import yuyu.def.sinkeiyaku.result.bean.HubimikaishoInfosBean;

/**
 * 新契約不備テーブル(HT_SkHubiDao) アクセス用の DAO クラスです。<br />
 */
public class HT_SkHubiDao extends AbstractDao<HT_SkHubi> {

    public HT_SkHubiDao() {
        super(HT_SkHubi.class);
    }

    @Deprecated
    public HT_SkHubi getSkHubi(String pMosno,
        String pHubisikibetukey){
        HT_SkHubi hT_SkHubi =  new HT_SkHubi();
        hT_SkHubi.setMosno(pMosno);
        hT_SkHubi.setHubisikibetukey(pHubisikibetukey);
        return this.selectOne(hT_SkHubi);
    }

    @Override
    @Deprecated
    public List<HT_SkHubi> selectAll() {
        return super.selectAll();
    }

    public List<HT_SkHubi> getSkHubisByMosnoHasinymdKaisyouymd(String pMosno, BizDate pHasinymd, BizDate pKaisyouymd) {


        QHT_SkHubiDetail qHT_SkHubiDetail = new QHT_SkHubiDetail();


        QHT_SkHubi qHT_SkHubi = new QHT_SkHubi();


        String pSubQuery = $SELECT + qHT_SkHubiDetail.hubisikibetukey +
            $FROM  + qHT_SkHubiDetail.HT_SkHubiDetail() +
            $WHERE + qHT_SkHubi.mosno.eq(qHT_SkHubiDetail.mosno) +
            $AND + qHT_SkHubi.hubisikibetukey.eq(qHT_SkHubiDetail.hubisikibetukey) +
            $AND + qHT_SkHubiDetail.mosno.eq(pMosno) +
            $AND + qHT_SkHubiDetail.hasinymd.eq(pHasinymd) +
            $AND + qHT_SkHubiDetail.kaisyouymd.eq(pKaisyouymd);


        String querySql = $SELECT + qHT_SkHubi +
            $FROM + qHT_SkHubi.HT_SkHubi() +
            $WHERE + $EXISTS(pSubQuery) +
            $ORDER_BY(qHT_SkHubi.hubisikibetukey.asc());

        return em.createJPQL(querySql).bind(qHT_SkHubi, qHT_SkHubiDetail).getResultList();
    }

    public List<HT_SkHubi> getSkHubisByMosnoKaisyouymdHasinymd(String pMosno) {


        QHT_SkHubiDetail qHT_SkHubiDetail = new QHT_SkHubiDetail();


        QHT_SkHubi qHT_SkHubi = new QHT_SkHubi();


        String querySql = $SELECT_DISTINCT + qHT_SkHubi +
            $FROM + qHT_SkHubi.HT_SkHubi() +
            "," + qHT_SkHubiDetail.HT_SkHubiDetail() +
            $WHERE + qHT_SkHubi.mosno.eq(pMosno) +
            $AND + qHT_SkHubi.mosno.eq(qHT_SkHubiDetail.mosno) +
            $AND + qHT_SkHubi.hubisikibetukey.eq(qHT_SkHubiDetail.hubisikibetukey) +
            $AND + qHT_SkHubiDetail.kaisyouymd.isNull() +
            $AND + qHT_SkHubiDetail.hasinymd.isNotNull() +
            $ORDER_BY(qHT_SkHubi.hubisikibetukey.asc());

        return em.createJPQL(querySql).bind(qHT_SkHubi, qHT_SkHubiDetail).getResultList();
    }

    public ExDBResults<HubiInfosByKakutyoujobcdHasinkyokakbnHasinymdBean> getHubiInfosByKakutyoujobcdHasinkyokakbnHasinymd() {


        QHT_SkHubi qHT_SkHubi = new QHT_SkHubi("qHT_SkHubi");
        QHT_SkHubiDetail qHT_SkHubiDetail = new QHT_SkHubiDetail("qHT_SkHubiDetail");


        String strSql = $SELECT + $NEW(HubiInfosByKakutyoujobcdHasinkyokakbnHasinymdBean.class,
            qHT_SkHubiDetail.hubisikibetukey,
            qHT_SkHubi.mosno) +
            $FROM(qHT_SkHubiDetail, qHT_SkHubi) +
            $WHERE + qHT_SkHubiDetail.hasinkyokakbn.eq(C_HasinkyokaKbn.KY) +
            $AND + qHT_SkHubiDetail.hasinymd.isNull() +
            $AND + qHT_SkHubiDetail.hubisikibetukey.eq(qHT_SkHubi.hubisikibetukey) +
            $AND + qHT_SkHubiDetail.mosno.eq(qHT_SkHubi.mosno) +
            $GROUP_BY + qHT_SkHubi.mosno + ","+ qHT_SkHubiDetail.hubisikibetukey +
            $ORDER_BY(qHT_SkHubi.mosno.asc(),
                qHT_SkHubiDetail.hubisikibetukey.asc());


        return em.createJPQL(strSql, HubiInfosByKakutyoujobcdHasinkyokakbnHasinymdBean.class)
            .bind(qHT_SkHubi, qHT_SkHubiDetail).getResults();
    }


    public ExDBResults<HubimikaishoInfosBean> getHubimikaishoInfos() {


        QHT_SkHubiDetail qHT_SkHubiDetail = new QHT_SkHubiDetail("qHT_SkHubiDetail");


        QHT_SkHubi qHT_SkHubi = new QHT_SkHubi("qHT_SkHubi");


        QHT_SyoriCTL qHT_SyoriCTL = new QHT_SyoriCTL("qHT_SyoriCTL");


        QHT_MosKihon qHT_MosKihon = new QHT_MosKihon("qHT_MosKihon");


        QHT_MosDairiten qHT_MosDairiten = new QHT_MosDairiten("qHT_MosDairiten");


        String querySql = $SELECT_DISTINCT + $NEW(HubimikaishoInfosBean.class,
            qHT_SkHubi.mosno,
            qHT_SkHubi.hubisikibetukey,
            qHT_SkHubi.utdskknnm1kj,
            qHT_SyoriCTL.mosno,
            qHT_SyoriCTL.ketteikbn,
            qHT_SyoriCTL.mosnrkymd,
            qHT_MosKihon.kykkbn,
            qHT_MosKihon.hhknnmkj,
            qHT_MosKihon.kyknmkj,
            qHT_MosKihon.hknsyuruino,
            qHT_MosKihon.mosfstpkei.getTypeFieldName(),
            qHT_MosKihon.mosfstpkei.getValueFieldName(),
            qHT_MosKihon.hrktuukasyu,
            qHT_MosDairiten.oyadrtencd,
            qHT_MosDairiten.tratkiagcd)+
            $FROM + qHT_SkHubiDetail.HT_SkHubiDetail() + "," +
            qHT_SkHubi.HT_SkHubi() + "," +
            qHT_MosKihon.HT_MosKihon() + "," +
            qHT_SyoriCTL.HT_SyoriCTL() +
            $LEFT_OUTER_JOIN + qHT_SyoriCTL.HT_MosDairiten() +
            $AS + qHT_MosDairiten +
            $WHERE + qHT_SkHubiDetail.mosno.eq(qHT_SkHubi.mosno) +
            $AND + qHT_SkHubiDetail.hubisikibetukey.eq(qHT_SkHubi.hubisikibetukey) +
            $AND + qHT_SkHubiDetail.kaisyouymd.isNull() +
            $AND + qHT_SkHubiDetail.hasinymd.isNotNull() +
            $AND + qHT_SkHubi.mosno.eq(qHT_SyoriCTL.mosno) +
            $AND + qHT_SyoriCTL.seiritukbn.ne(C_SeirituKbn.HUSEIRITU) +
            $AND + qHT_SyoriCTL.mosno.eq(qHT_MosKihon.mosno) +
            $AND + "(" + qHT_MosDairiten.renno.eq(1) +
            $OR + qHT_MosDairiten.mosno.isNull()+ ")" +
            $ORDER_BY(qHT_MosDairiten.oyadrtencd.asc(),
                qHT_SyoriCTL.mosnrkymd.asc(),
                qHT_SkHubi.mosno.asc());

        return em.createJPQL(querySql, HubimikaishoInfosBean.class).bind(qHT_SkHubi, qHT_SkHubiDetail, qHT_SyoriCTL, qHT_MosKihon, qHT_MosDairiten).getResults();
    }
}
