package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.db.entity.HV_MosSyoruiMitoutyakuList;
import yuyu.def.db.meta.QHV_MosSyoruiMitoutyakuList;

/**
 * 申込書類未到着リスト情報ビュー(HV_MosSyoruiMitoutyakuListDao) アクセス用の DAO クラスです。<br />
 */
public class HV_MosSyoruiMitoutyakuListDao extends AbstractDao<HV_MosSyoruiMitoutyakuList> {

    public HV_MosSyoruiMitoutyakuListDao() {
        super(HV_MosSyoruiMitoutyakuList.class);
    }

    public HV_MosSyoruiMitoutyakuList getMosSyoruiMitoutyakuList(BizDate pSyoriYmd, String pItirenno) {
        HV_MosSyoruiMitoutyakuList hV_MosSyoruiMitoutyakuList =  new HV_MosSyoruiMitoutyakuList();
        hV_MosSyoruiMitoutyakuList.setSyoriYmd(pSyoriYmd);
        hV_MosSyoruiMitoutyakuList.setItirenno(pItirenno);
        return this.selectOne(hV_MosSyoruiMitoutyakuList);
    }

    public ExDBResults<HV_MosSyoruiMitoutyakuList> getMosSyoruiMitoutyakuListsBySyoriYmd(BizDate pKnjyymd) {


        QHV_MosSyoruiMitoutyakuList qHV_MosSyoruiMitoutyakuList = new QHV_MosSyoruiMitoutyakuList();


        String strSql = $SELECT + qHV_MosSyoruiMitoutyakuList +
            $FROM + qHV_MosSyoruiMitoutyakuList.HV_MosSyoruiMitoutyakuList() +
            $WHERE + qHV_MosSyoruiMitoutyakuList.knjyymd.le(pKnjyymd) +
            $ORDER_BY(qHV_MosSyoruiMitoutyakuList.oyadrtencd.asc(),
                qHV_MosSyoruiMitoutyakuList.knjyymd.asc());


        return em.createJPQL(strSql).bind(qHV_MosSyoruiMitoutyakuList).getResults();
    }

    public ExDBResults<HV_MosSyoruiMitoutyakuList> getMosSyoruiMitoutyakuListsByKnjyymdLe(BizDate pKnjyymd) {


        QHV_MosSyoruiMitoutyakuList qHV_MosSyoruiMitoutyakuList = new QHV_MosSyoruiMitoutyakuList("qHV_MosSyoruiMitoutyakuList");


        String strSql = $SELECT + qHV_MosSyoruiMitoutyakuList +
            $FROM + qHV_MosSyoruiMitoutyakuList.HV_MosSyoruiMitoutyakuList() +
            $WHERE + qHV_MosSyoruiMitoutyakuList.knjyymd.le(pKnjyymd)+
            $ORDER_BY(qHV_MosSyoruiMitoutyakuList.oyadrtencd.asc(),
                qHV_MosSyoruiMitoutyakuList.knjyymd.asc(),
                qHV_MosSyoruiMitoutyakuList.tuukasyu.asc(),
                qHV_MosSyoruiMitoutyakuList.nykmosno.asc());


        return em.createJPQL(strSql).bind(qHV_MosSyoruiMitoutyakuList).getResults();
    }
}
