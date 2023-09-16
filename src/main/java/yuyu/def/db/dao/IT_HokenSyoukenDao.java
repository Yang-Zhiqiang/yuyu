package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_InsizeiShryouhiKbn;
import yuyu.def.classification.C_SinsaihkKbn;
import yuyu.def.classification.C_SyoukensaihkKbn;
import yuyu.def.db.entity.IT_HokenSyouken;
import yuyu.def.db.meta.QIT_HokenSyouken;
import yuyu.def.db.meta.QIT_Suiihyou;
import yuyu.def.hozen.result.bean.SaihakkoshokenInfosByKakutyoujobcdTyouhyouymdBean;
import yuyu.def.hozen.result.bean.SinkeiyakuhokenshokenInfosByKakutyoujobcdTyouhyouymdBean;
/**
 * 保険証券テーブル(IT_HokenSyoukenDao) アクセス用の DAO クラスです。<br />
 */
public class IT_HokenSyoukenDao extends AbstractDao<IT_HokenSyouken> {

    public IT_HokenSyoukenDao() {
        super(IT_HokenSyouken.class);
    }

    @Deprecated
    public IT_HokenSyouken getHokenSyouken(String pSyono,
        BizDate pTyouhyouymd){
        IT_HokenSyouken iT_HokenSyouken =  new IT_HokenSyouken();
        iT_HokenSyouken.setSyono(pSyono);
        iT_HokenSyouken.setTyouhyouymd(pTyouhyouymd);
        return this.selectOne(iT_HokenSyouken);
    }

    @Override
    @Deprecated
    public List<IT_HokenSyouken> selectAll() {
        return super.selectAll();
    }

    public  Long getHokenSyoukenCountByTysytymdFromTysytymdToSinsaihkkbn(BizDate pTysytymdFrom,
        BizDate pTysytymdTo, C_SinsaihkKbn pSinsaihkkbn) {


        QIT_HokenSyouken qIT_HokenSyouken = new QIT_HokenSyouken();


        String strSql = $SELECT + $COUNT(qIT_HokenSyouken.syono) +
            $FROM + qIT_HokenSyouken.IT_HokenSyouken() +
            $WHERE + qIT_HokenSyouken.tyouhyouymd.ge(pTysytymdFrom) +
            $AND + qIT_HokenSyouken.tyouhyouymd.le(pTysytymdTo) +
            $AND + qIT_HokenSyouken.sinsaihkkbn.eq(pSinsaihkkbn);


        return em.createJPQL(strSql).bind(qIT_HokenSyouken).getSingleResult();
    }

    public Long getHokenSyoukenCountByTysytymdFromTysytymdToSinsaihkkbnSyoukensaihkkbnInsizeishryouhikbn(BizDate pTysytymdFrom, BizDate pTysytymdTo, C_SinsaihkKbn pSinsaihkkbn, C_SyoukensaihkKbn pSyoukensaihkkbn
        , C_InsizeiShryouhiKbn pInsizeishryouhikbn) {


        QIT_HokenSyouken qIT_HokenSyouken = new QIT_HokenSyouken();


        String  strSql = $SELECT + $COUNT(qIT_HokenSyouken.syono) +
            $FROM + qIT_HokenSyouken.IT_HokenSyouken() +
            $WHERE + qIT_HokenSyouken.tyouhyouymd.ge(pTysytymdFrom) +
            $AND + qIT_HokenSyouken.tyouhyouymd.le(pTysytymdTo) +
            $AND + qIT_HokenSyouken.sinsaihkkbn.eq(pSinsaihkkbn) +
            $AND + qIT_HokenSyouken.syoukensaihkkbn.eq(pSyoukensaihkkbn) +
            $AND + qIT_HokenSyouken.insizeishryouhikbn.eq(pInsizeishryouhikbn);


        return em.createJPQL(strSql).bind(qIT_HokenSyouken).getSingleResult();
    }

    public Long getHokenSyoukenCountByTysytymdFromTysytymdToSinsaihkkbnSyoukensaihkkbn(BizDate pTysytymdFrom, BizDate pTysytymdTo, C_SinsaihkKbn pSinsaihkkbn, C_SyoukensaihkKbn pSyoukensaihkkbn) {


        QIT_HokenSyouken qIT_HokenSyouken = new QIT_HokenSyouken();


        String strSql = $SELECT + $COUNT(qIT_HokenSyouken.syono) +
            $FROM + qIT_HokenSyouken.IT_HokenSyouken() +
            $WHERE + qIT_HokenSyouken.tyouhyouymd.ge(pTysytymdFrom) +
            $AND + qIT_HokenSyouken.tyouhyouymd.le(pTysytymdTo) +
            $AND + qIT_HokenSyouken.sinsaihkkbn.eq(pSinsaihkkbn) +
            $AND + qIT_HokenSyouken.syoukensaihkkbn.eq(pSyoukensaihkkbn);


        return em.createJPQL(strSql).bind(qIT_HokenSyouken).getSingleResult();
    }

    public ExDBResults<SaihakkoshokenInfosByKakutyoujobcdTyouhyouymdBean> getSaihakkoshokenInfosByKakutyoujobcdTyouhyouymd(BizDate pTyouhyouymd) {


        QIT_HokenSyouken qIT_HokenSyouken = new QIT_HokenSyouken();
        QIT_Suiihyou qIT_Suiihyou = new QIT_Suiihyou();


        String strSql = $SELECT + qIT_HokenSyouken + "," +
            qIT_Suiihyou.keikanensuu +
            $FROM +qIT_HokenSyouken.IT_HokenSyouken() + "," +
            qIT_Suiihyou.IT_Suiihyou() +
            $WHERE + qIT_HokenSyouken.syono.eq(qIT_Suiihyou.syono) +
            $AND + qIT_HokenSyouken.tyouhyouymd.eq(qIT_Suiihyou.tyouhyouymd) +
            $AND + qIT_HokenSyouken.tyouhyouymd.eq(pTyouhyouymd) +
            $AND + qIT_HokenSyouken.sinsaihkkbn.eq(C_SinsaihkKbn.SAI) +
            $AND + qIT_HokenSyouken.syoukensaihkkbn.eq(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU) +
            $ORDER_BY(qIT_Suiihyou.syono.asc(),
                qIT_Suiihyou.keikanensuu.asc());


        return em.createJPQL(strSql).bind(qIT_HokenSyouken, qIT_Suiihyou)
            .getResults(SaihakkoshokenInfosByKakutyoujobcdTyouhyouymdBean.class);
    }

    public ExDBResults<SinkeiyakuhokenshokenInfosByKakutyoujobcdTyouhyouymdBean> getSinkeiyakuhokenshokenInfosByKakutyoujobcdTyouhyouymd(BizDate pTyouhyouymd) {


        QIT_HokenSyouken qIT_HokenSyouken = new QIT_HokenSyouken();
        QIT_Suiihyou qIT_Suiihyou = new QIT_Suiihyou();


        String strSql = $SELECT + qIT_HokenSyouken + "," +
            qIT_Suiihyou.keikanensuu +
            $FROM +qIT_HokenSyouken.IT_HokenSyouken() + "," +
            qIT_Suiihyou.IT_Suiihyou() +
            $WHERE + qIT_HokenSyouken.syono.eq(qIT_Suiihyou.syono) +
            $AND + qIT_HokenSyouken.tyouhyouymd.eq(qIT_Suiihyou.tyouhyouymd) +
            $AND + qIT_HokenSyouken.tyouhyouymd.eq(pTyouhyouymd) +
            $AND + "(" + qIT_HokenSyouken.sinsaihkkbn.eq(C_SinsaihkKbn.SIN) +
            $OR +"(" + qIT_HokenSyouken.sinsaihkkbn.eq(C_SinsaihkKbn.SAI) +
            $AND + qIT_HokenSyouken.syoukensaihkkbn.eq(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI) + ")" + ")" +
            $ORDER_BY(qIT_Suiihyou.syono.asc(),
                qIT_Suiihyou.keikanensuu.asc());


        return em.createJPQL(strSql).bind(qIT_HokenSyouken, qIT_Suiihyou)
            .getResults(SinkeiyakuhokenshokenInfosByKakutyoujobcdTyouhyouymdBean.class);
    }
}
