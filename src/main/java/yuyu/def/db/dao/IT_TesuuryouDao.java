package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TsrysyoriKbn;
import yuyu.def.db.entity.IT_Tesuuryou;
import yuyu.def.db.meta.QIT_HhknSya;
import yuyu.def.db.meta.QIT_KykDairiten;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSya;
import yuyu.def.db.meta.QIT_Tesuuryou;
import yuyu.def.db.meta.QIT_TesuuryouSyouhn;
import yuyu.def.db.meta.QIT_TesuuryouSyouhnRireki;
import yuyu.def.hozen.result.bean.TesuuryouInfosByKakutyoujobcdTsrysyorikbnBosyuuymSyutkkbnDrtenrennoBean;
import yuyu.def.hozen.result.bean.TesuuryouInfosByKakutyoujobcditemsBean;

/**
 * 手数料情報テーブル(IT_TesuuryouDao) アクセス用の DAO クラスです。<br />
 */
public class IT_TesuuryouDao extends AbstractDao<IT_Tesuuryou> {

    public IT_TesuuryouDao() {
        super(IT_Tesuuryou.class);
    }

    @Deprecated
    public IT_Tesuuryou getTesuuryou(String pSyono,
        C_TsrysyoriKbn pTsrysyorikbn,
        Integer pRenno){
        IT_Tesuuryou iT_Tesuuryou =  new IT_Tesuuryou();
        iT_Tesuuryou.setSyono(pSyono);
        iT_Tesuuryou.setTsrysyorikbn(pTsrysyorikbn);
        iT_Tesuuryou.setRenno(pRenno);
        return this.selectOne(iT_Tesuuryou);
    }

    @Override
    @Deprecated
    public List<IT_Tesuuryou> selectAll() {
        return super.selectAll();
    }

    public ExDBResults<TesuuryouInfosByKakutyoujobcdTsrysyorikbnBosyuuymSyutkkbnDrtenrennoBean> getTesuuryouInfosByKakutyoujobcdTsrysyorikbnBosyuuymSyutkkbnDrtenrenno(
        BizDateYM pBosyuuym, C_SyutkKbn pSyutkkbn) {

        QIT_Tesuuryou qIT_Tesuuryou = new QIT_Tesuuryou("qIT_Tesuuryou");
        QIT_TesuuryouSyouhn qIT_TesuuryouSyouhn = new QIT_TesuuryouSyouhn("qIT_TesuuryouSyouhn");

        QIT_TesuuryouSyouhnRireki qIT_TesuuryouSyouhnRireki = new QIT_TesuuryouSyouhnRireki("qIT_TesuuryouSyouhnRireki");
        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");
        QIT_KykSya qIT_KykSya = new QIT_KykSya("qIT_KykSya");
        QIT_HhknSya qIT_HhknSya = new QIT_HhknSya("qIT_HhknSya");
        QIT_KykDairiten qIT_KykDairiten = new QIT_KykDairiten("qIT_KykDairiten");


        String strSql =$SELECT + qIT_Tesuuryou + "," +
            qIT_TesuuryouSyouhn + "," +
            qIT_TesuuryouSyouhnRireki + "," +
            qIT_KykKihon + "," +
            qIT_KykSya + "," +
            qIT_HhknSya + "," +
            qIT_KykDairiten +
            $FROM + qIT_Tesuuryou.IT_Tesuuryou() + "," +
            qIT_TesuuryouSyouhn.IT_TesuuryouSyouhn() + "," +
            qIT_TesuuryouSyouhnRireki.IT_TesuuryouSyouhnRireki() + "," +
            qIT_KykKihon.IT_KykKihon() + "," +
            qIT_KykSya.IT_KykSya() + "," +
            qIT_HhknSya.IT_HhknSya() + "," +
            qIT_KykDairiten.IT_KykDairiten() +
            $WHERE + "(" + qIT_Tesuuryou.tsrysyorikbn.in(C_TsrysyoriKbn.SINKEIYAKUSEIRITU,
                C_TsrysyoriKbn.SEINENGAPPISEI,
                C_TsrysyoriKbn.GENGAKU,
                C_TsrysyoriKbn.KAIJO,
                C_TsrysyoriKbn.MUKOU,
                C_TsrysyoriKbn.KAIYAKU) +
                $OR + "(" + qIT_Tesuuryou.tsrysyorikbn.eq(C_TsrysyoriKbn.KEIYAKUTORIKESI) +
                $AND+ qIT_Tesuuryou.bosyuuym.ge(pBosyuuym) + ")" +
                $OR + "(" + qIT_Tesuuryou.tsrysyorikbn.eq(C_TsrysyoriKbn.CLGOFF) +
                $AND+ qIT_Tesuuryou.bosyuuym.ge(pBosyuuym) + "))" +
                $AND + qIT_TesuuryouSyouhn.syono.eq(qIT_Tesuuryou.syono) +
                $AND + qIT_TesuuryouSyouhn.tsrysyorikbn.eq(qIT_Tesuuryou.tsrysyorikbn) +
                $AND + qIT_TesuuryouSyouhn.renno.eq(qIT_Tesuuryou.renno) +
                $AND + qIT_TesuuryouSyouhn.syutkkbn.eq(pSyutkkbn) +
                $AND + qIT_TesuuryouSyouhnRireki.syono.eq(qIT_Tesuuryou.syono) +
                $AND + qIT_TesuuryouSyouhnRireki.tsrysyorikbn.eq(qIT_Tesuuryou.tsrysyorikbn) +
                $AND + qIT_TesuuryouSyouhnRireki.renno.eq(qIT_Tesuuryou.renno) +
                $AND + qIT_TesuuryouSyouhnRireki.syutkkbn.eq(pSyutkkbn) +
                $AND + qIT_KykKihon.syono.eq(qIT_Tesuuryou.syono) +
                $AND + qIT_KykSya.syono.eq(qIT_Tesuuryou.syono) +
                $AND + qIT_HhknSya.syono.eq(qIT_Tesuuryou.syono) +
                $AND + qIT_KykDairiten.syono.eq(qIT_Tesuuryou.syono) +
                $AND + qIT_KykDairiten.drtenrenno.eq(1) +
                $ORDER_BY(qIT_Tesuuryou.syono.asc(),
                    qIT_Tesuuryou.gyoumuKousinTime.asc());

        return em.createJPQL(strSql).bind(qIT_Tesuuryou, qIT_TesuuryouSyouhn, qIT_TesuuryouSyouhnRireki, qIT_KykKihon, qIT_KykSya, qIT_HhknSya,qIT_KykDairiten)
            .getResults(TesuuryouInfosByKakutyoujobcdTsrysyorikbnBosyuuymSyutkkbnDrtenrennoBean.class);
    }

    public ExDBResults<TesuuryouInfosByKakutyoujobcditemsBean> getTesuuryouInfosByKakutyoujobcditems(BizDate pSyoriYmd,
        BizDateYM pBosyuuym, C_SyutkKbn pSyutkkbn) {


        QIT_Tesuuryou qIT_Tesuuryou = new QIT_Tesuuryou("qIT_Tesuuryou");


        QIT_TesuuryouSyouhn qIT_TesuuryouSyouhn = new QIT_TesuuryouSyouhn("qIT_TesuuryouSyouhn");


        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");


        QIT_KykSya qIT_KykSya = new QIT_KykSya("qIT_KykSya");


        QIT_HhknSya qIT_HhknSya = new QIT_HhknSya("qIT_HhknSya");


        QIT_KykDairiten qIT_KykDairiten = new QIT_KykDairiten("qIT_KykDairiten");


        String strSql =$SELECT + qIT_Tesuuryou + "," +
            qIT_TesuuryouSyouhn + "," +
            qIT_KykKihon + "," +
            qIT_KykSya + "," +
            qIT_HhknSya + "," +
            qIT_KykDairiten +
            $FROM + qIT_Tesuuryou.IT_Tesuuryou() + "," +
            qIT_TesuuryouSyouhn.IT_TesuuryouSyouhn() + "," +
            qIT_KykKihon.IT_KykKihon() + "," +
            qIT_KykSya.IT_KykSya() + "," +
            qIT_HhknSya.IT_HhknSya() + "," +
            qIT_KykDairiten.IT_KykDairiten() +
            $WHERE + qIT_Tesuuryou.syoriYmd.eq(pSyoriYmd) +
            $AND + "(" + qIT_Tesuuryou.tsrysyorikbn.in(C_TsrysyoriKbn.SINKEIYAKUSEIRITU,
                C_TsrysyoriKbn.SEINENGAPPISEI,
                C_TsrysyoriKbn.GENGAKU,
                C_TsrysyoriKbn.KAIJO,
                C_TsrysyoriKbn.MUKOU,
                C_TsrysyoriKbn.KAIYAKU) +
                $OR + "(" + qIT_Tesuuryou.tsrysyorikbn.eq(C_TsrysyoriKbn.KEIYAKUTORIKESI) +
                $AND+ qIT_Tesuuryou.bosyuuym.ge(pBosyuuym) + ")" +
                $OR + "(" + qIT_Tesuuryou.tsrysyorikbn.eq(C_TsrysyoriKbn.CLGOFF) +
                $AND+ qIT_Tesuuryou.bosyuuym.ge(pBosyuuym) + "))" +
                $AND + qIT_TesuuryouSyouhn.syono.eq(qIT_Tesuuryou.syono) +
                $AND + qIT_TesuuryouSyouhn.tsrysyorikbn.eq(qIT_Tesuuryou.tsrysyorikbn) +
                $AND + qIT_TesuuryouSyouhn.renno.eq(qIT_Tesuuryou.renno) +
                $AND + qIT_TesuuryouSyouhn.syutkkbn.eq(pSyutkkbn) +
                $AND + qIT_KykKihon.syono.eq(qIT_Tesuuryou.syono) +
                $AND + qIT_KykSya.syono.eq(qIT_Tesuuryou.syono) +
                $AND + qIT_HhknSya.syono.eq(qIT_Tesuuryou.syono) +
                $AND + qIT_KykDairiten.syono.eq(qIT_Tesuuryou.syono) +
                $AND + qIT_KykDairiten.drtenrenno.eq(1) +
                $ORDER_BY(qIT_Tesuuryou.syono.asc(),
                    qIT_Tesuuryou.gyoumuKousinTime.asc());

        return em.createJPQL(strSql).bind(qIT_Tesuuryou, qIT_TesuuryouSyouhn, qIT_KykKihon, qIT_KykSya, qIT_HhknSya,qIT_KykDairiten)
            .getResults(TesuuryouInfosByKakutyoujobcditemsBean.class);
    }
}
