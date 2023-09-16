package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import yuyu.def.classification.C_NyknsyubetuKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_ZenhnknKbn;
import yuyu.def.db.entity.HT_Nyuukin;
import yuyu.def.db.meta.QHT_Nyuukin;
import yuyu.def.db.meta.QHT_SkDenpyoData;
import yuyu.def.sinkeiyaku.result.bean.DengkByMosnoRstuukasyuBean;
import yuyu.def.sinkeiyaku.result.bean.NyuukinInfoByMosnoZenhnknkbnSrgonyknumuBean;

/**
 * 入金テーブル(HT_NyuukinDao) アクセス用の DAO クラスです。<br />
 */
public class HT_NyuukinDao extends AbstractDao<HT_Nyuukin> {

    public HT_NyuukinDao() {
        super(HT_Nyuukin.class);
    }

    @Deprecated
    public HT_Nyuukin getNyuukin(String pMosno,
        Integer pRenno){
        HT_Nyuukin hT_Nyuukin =  new HT_Nyuukin();
        hT_Nyuukin.setMosno(pMosno);
        hT_Nyuukin.setRenno(pRenno);
        return this.selectOne(hT_Nyuukin);
    }

    @Override
    @Deprecated
    public List<HT_Nyuukin> selectAll() {
        return super.selectAll();
    }

    public HT_Nyuukin getNyuukinByMosnoMaxRenno(String pMosno) {


        QHT_Nyuukin qHT_Nyuukin = new QHT_Nyuukin();


        String quertSubSql = $SELECT + $MAX(qHT_Nyuukin.renno) +
            $FROM + qHT_Nyuukin.HT_Nyuukin() +
            $WHERE + qHT_Nyuukin.mosno.eq(pMosno);

        String quertSql = $SELECT + qHT_Nyuukin +
            $FROM + qHT_Nyuukin.HT_Nyuukin() +
            $WHERE + qHT_Nyuukin.mosno.eq(pMosno) +
            $AND + qHT_Nyuukin.renno + $EQ + "(" +quertSubSql + ")";
        return em.createJPQL(quertSql).bind(qHT_Nyuukin).getSingleResult();
    }

    public Integer getNyuukinMaxRennoByMosno(String pMosno) {


        QHT_Nyuukin qHT_Nyuukin = new QHT_Nyuukin();


        String quertSql = $SELECT + $MAX(qHT_Nyuukin.renno) +
            $FROM + qHT_Nyuukin.HT_Nyuukin() +
            $WHERE + qHT_Nyuukin.mosno.eq(pMosno) ;

        return em.createJPQL(quertSql).bind(qHT_Nyuukin).getSingleResult();
    }

    public BizDate getNyuukinMinRyosyuymdByMosnoZenhnknkbn(String pMosno, C_ZenhnknKbn pZenhnknkbn) {


        QHT_Nyuukin qHT_Nyuukin = new QHT_Nyuukin();


        String quertSql = $SELECT + $MIN(qHT_Nyuukin.ryosyuymd) +
            $FROM + qHT_Nyuukin.HT_Nyuukin() +
            $WHERE + qHT_Nyuukin.mosno.eq(pMosno) +
            $AND + qHT_Nyuukin.zenhnknkbn.eq(pZenhnknkbn);

        return em.createJPQL(quertSql).bind(qHT_Nyuukin).getSingleResult();
    }

    public List<HT_Nyuukin>  getNyuukinSumRyosyugkByMosnoMaxRenno(String pMosno) {


        QHT_Nyuukin qHT_Nyuukin = new QHT_Nyuukin();


        String strSql = "(" +$SELECT + $MAX(qHT_Nyuukin.renno) +
            $FROM + qHT_Nyuukin.HT_Nyuukin() +
            $WHERE + qHT_Nyuukin.mosno.eq(pMosno) + ")";

        String mainSql = $SELECT + qHT_Nyuukin +
            $FROM + qHT_Nyuukin.HT_Nyuukin() +
            $WHERE + qHT_Nyuukin.mosno.eq(pMosno) +
            $AND + qHT_Nyuukin.renno + $NE + strSql;

        return em.createJPQL(mainSql).bind(qHT_Nyuukin).getResultList();
    }

    public HT_Nyuukin getNyuukinByMosnoMinRenno(String pMosno) {


        QHT_Nyuukin qHT_Nyuukin = new QHT_Nyuukin();


        String strSql = "(" +$SELECT + $MIN(qHT_Nyuukin.renno) +
            $FROM + qHT_Nyuukin.HT_Nyuukin() +
            $WHERE + qHT_Nyuukin.mosno.eq(pMosno) +
            $AND + qHT_Nyuukin.zenhnknkbn.ne(C_ZenhnknKbn.SUMI) + ")";

        String mainSql = $SELECT + qHT_Nyuukin +
            $FROM + qHT_Nyuukin.HT_Nyuukin() +
            $WHERE + qHT_Nyuukin.mosno.eq(pMosno) +
            $AND + qHT_Nyuukin.renno + $EQ + strSql;

        return em.createJPQL(mainSql).bind(qHT_Nyuukin).getSingleResult();
    }

    public Long getNyuukinCountByMosnoZenhnknkbnSrgonyknumuNyknsyubetu(String pMosno) {


        QHT_Nyuukin qHT_Nyuukin = new QHT_Nyuukin();


        String strSql = $SELECT + $COUNT(qHT_Nyuukin.mosno) +
            $FROM + qHT_Nyuukin.HT_Nyuukin() +
            $WHERE + qHT_Nyuukin.mosno.eq(pMosno) +
            $AND + qHT_Nyuukin.zenhnknkbn.eq(C_ZenhnknKbn.BLNK) +
            $AND + qHT_Nyuukin.srgonyknumu.eq(C_UmuKbn.NONE) +
            $AND + qHT_Nyuukin.nyknsyubetu.eq(C_NyknsyubetuKbn.KOUHURI);


        return em.createJPQL(strSql).bind(qHT_Nyuukin).getSingleResult();
    }

    public BizDate getNyuukinMinRyosyuymdByMosno(String pMosno) {


        QHT_Nyuukin qHT_Nyuukin = new QHT_Nyuukin();


        String quertSql = $SELECT + $MIN(qHT_Nyuukin.ryosyuymd) +
            $FROM + qHT_Nyuukin.HT_Nyuukin() +
            $WHERE + qHT_Nyuukin.mosno.eq(pMosno) +
            $AND + qHT_Nyuukin.zenhnknkbn.ne(C_ZenhnknKbn.SUMI);

        return em.createJPQL(quertSql).bind(qHT_Nyuukin).getSingleResult();
    }

    public BizDate getNyuukinMinNyksyoriymdByMosnoZenhnknkbn(String pMosno) {


        QHT_Nyuukin qHT_Nyuukin = new QHT_Nyuukin();


        String strSql = $SELECT + $MIN(qHT_Nyuukin.nyksyoriymd) +
            $FROM + qHT_Nyuukin.HT_Nyuukin() +
            $WHERE + qHT_Nyuukin.mosno.eq(pMosno) +
            $AND + qHT_Nyuukin.zenhnknkbn.ne(C_ZenhnknKbn.SUMI) +
            $GROUP_BY + qHT_Nyuukin.mosno;


        return em.createJPQL(strSql).bind(qHT_Nyuukin).getSingleResult();
    }

    public BizDate getNyuukinMaxRyosyuymdByMosno(String pMosno) {


        QHT_Nyuukin qHT_Nyuukin = new QHT_Nyuukin();


        String strSql = $SELECT + $MAX(qHT_Nyuukin.ryosyuymd) +
            $FROM + qHT_Nyuukin.HT_Nyuukin() +
            $WHERE + qHT_Nyuukin.mosno.eq(pMosno);


        return em.createJPQL(strSql).bind(qHT_Nyuukin).getSingleResult();
    }

    public DengkByMosnoRstuukasyuBean getDengkByMosnoRstuukasyuRyosyuymd(String pMosno,
        C_Tuukasyu pRstuukasyu, BizDate pRyosyuymd) {


        QHT_Nyuukin qHT_Nyuukin = new QHT_Nyuukin();
        QHT_SkDenpyoData qHT_SkDenpyoData = new QHT_SkDenpyoData();


        String strSql = $SELECT + $NEW(DengkByMosnoRstuukasyuBean.class
            , qHT_SkDenpyoData.denyenkagk.getTypeFieldName()
            ,$SUM + $(qHT_SkDenpyoData.denyenkagk.getValueFieldName())
            , qHT_SkDenpyoData.dengaikagk.getTypeFieldName()
            ,$SUM + $(qHT_SkDenpyoData.dengaikagk.getValueFieldName())) +
            $FROM + qHT_Nyuukin.HT_Nyuukin() + "," +
            qHT_SkDenpyoData.HT_SkDenpyoData() +
            $WHERE + qHT_Nyuukin.mosno.eq(pMosno) +
            $AND + qHT_Nyuukin.rstuukasyu.eq(pRstuukasyu) +
            $AND + qHT_Nyuukin.denrenno.eq(qHT_SkDenpyoData.denrenno) +
            $AND + qHT_Nyuukin.edano.eq(qHT_SkDenpyoData.edano) +
            $AND + qHT_Nyuukin.ryosyuymd.le(pRyosyuymd) +
            $GROUP_BY + qHT_SkDenpyoData.denyenkagk.getTypeFieldName() + ","+
            qHT_SkDenpyoData.dengaikagk.getTypeFieldName()  +
            $ORDER_BY (qHT_SkDenpyoData.denyenkagk.typeAsc(),
                qHT_SkDenpyoData.dengaikagk.typeAsc());


        return em.createJPQL(strSql,DengkByMosnoRstuukasyuBean.class).bind(qHT_Nyuukin, qHT_SkDenpyoData).getSingleResult();
    }

    public NyuukinInfoByMosnoZenhnknkbnSrgonyknumuBean getNyuukinInfoByMosnoZenhnknkbnSrgonyknumu(String pMosno) {


        QHT_Nyuukin qHT_Nyuukin = new QHT_Nyuukin();


        String strSql = $SELECT + $NEW(NyuukinInfoByMosnoZenhnknkbnSrgonyknumuBean.class,
            $MIN(qHT_Nyuukin.nyksyoriymd),
            $MIN(qHT_Nyuukin.ryosyuymd),
            $MAX(qHT_Nyuukin.ryosyuymd),
            $MIN(qHT_Nyuukin.tyakkinymd)) +
            $FROM + qHT_Nyuukin.HT_Nyuukin() +
            $WHERE + qHT_Nyuukin.mosno.eq(pMosno) +
            $AND + qHT_Nyuukin.zenhnknkbn.eq(C_ZenhnknKbn.BLNK) +
            $AND + qHT_Nyuukin.srgonyknumu.eq(C_UmuKbn.NONE) +
            $GROUP_BY + qHT_Nyuukin.mosno;


        return em.createJPQL(strSql,NyuukinInfoByMosnoZenhnknkbnSrgonyknumuBean.class).bind(qHT_Nyuukin).getSingleResult();
    }

    public HT_Nyuukin getNyuukinByMosnoRyosyuymdZenhnknkbn(String pMosno, BizDate pRyosyuymd) {


        QHT_Nyuukin qHT_Nyuukin = new QHT_Nyuukin();


        String strSql = "(" +$SELECT + $MIN(qHT_Nyuukin.renno) +
            $FROM(qHT_Nyuukin) +
            $WHERE + qHT_Nyuukin.mosno.eq(pMosno) +
            $AND + qHT_Nyuukin.ryosyuymd.eq(pRyosyuymd) +
            $AND + qHT_Nyuukin.zenhnknkbn.ne(C_ZenhnknKbn.SUMI) + ")";


        String mainSql = $SELECT + qHT_Nyuukin +
            $FROM(qHT_Nyuukin) +
            $WHERE + qHT_Nyuukin.mosno.eq(pMosno) +
            $AND + qHT_Nyuukin.renno + $EQ + strSql;

        return em.createJPQL(mainSql).bind(qHT_Nyuukin).getSingleResult();
    }

}
