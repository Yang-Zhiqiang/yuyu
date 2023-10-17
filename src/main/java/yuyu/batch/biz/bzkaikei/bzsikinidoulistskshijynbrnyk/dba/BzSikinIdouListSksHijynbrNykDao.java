package yuyu.batch.biz.bzkaikei.bzsikinidoulistskshijynbrnyk.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_ShrsyoriKbn;
import yuyu.def.classification.C_SikinidouJtKbn;
import yuyu.def.classification.C_SikinidouPKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.meta.QBT_HijynNykSikinIdouListSks;
import yuyu.def.db.meta.QBT_HijynNykSiknIdouLstSksGk;
import yuyu.def.db.meta.QIT_KhShrRireki;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSyouhn;
import yuyu.def.db.meta.QJT_SiKekka;

/**
 * 業務共通 経理・会計 資金移動リスト作成(平準払入金用)機能DAOクラス
 */
public class BzSikinIdouListSksHijynbrNykDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public ExDBResults<HijynNykSikinIdouDataBean> getHijynbrNykDatasSk(String pKakutyoujobcd) {

        QBT_HijynNykSikinIdouListSks qBT_HijynNykSikinIdouListSks = new QBT_HijynNykSikinIdouListSks("qBT_HijynNykSikinIdouListSks");
        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");
        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");

        String querySql = $SELECT + $NEW(HijynNykSikinIdouDataBean.class,
            qBT_HijynNykSikinIdouListSks.syono,
            qBT_HijynNykSikinIdouListSks.sikinidoupjytym,
            qBT_HijynNykSikinIdouListSks.syoriYmd,
            qBT_HijynNykSikinIdouListSks.siteituuka,
            qBT_HijynNykSikinIdouListSks.siteituukagk.getTypeFieldName(),
            qBT_HijynNykSikinIdouListSks.siteituukagk.getValueFieldName(),
            qBT_HijynNykSikinIdouListSks.trhktuuka,
            qBT_HijynNykSikinIdouListSks.trhktuukagk.getTypeFieldName(),
            qBT_HijynNykSikinIdouListSks.trhktuukagk.getValueFieldName(),
            qBT_HijynNykSikinIdouListSks.seg1cd,
            qBT_HijynNykSikinIdouListSks.sikinidougroupkbn,
            qBT_HijynNykSikinIdouListSks.sikinidoumeisaikbn,
            qBT_HijynNykSikinIdouListSks.sikinidoujtkbn,
            qBT_HijynNykSikinIdouListSks.sikinidoukawaserate,
            qBT_HijynNykSikinIdouListSks.sikinidoupkbn,
            qIT_KykSyouhn.kykymd,
            qIT_KykKihon.fstpnyknymd,
            qIT_KykSyouhn.syoumetuymd) +
            $FROM(qBT_HijynNykSikinIdouListSks,
                qIT_KykSyouhn,
                qIT_KykKihon) +
                $WHERE + qBT_HijynNykSikinIdouListSks.syono.eq(qIT_KykSyouhn.syono) +
                $AND + qBT_HijynNykSikinIdouListSks.syono.eq(qIT_KykKihon.syono) +
                $AND + qBT_HijynNykSikinIdouListSks.sikinidoujtkbn.eq(C_SikinidouJtKbn.SIKINIDOUMIRYOU) +
                $AND + qBT_HijynNykSikinIdouListSks.sikinidoupkbn.eq(C_SikinidouPKbn.FSTP) +
                $AND + qIT_KykSyouhn.yuukousyoumetukbn.eq(C_YuukousyoumetuKbn.YUUKOU) +
                $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU);


        ExDBResults<HijynNykSikinIdouDataBean> exDBResults = exDBEntityManager
            .createJPQL(querySql, HijynNykSikinIdouDataBean.class).bind(qBT_HijynNykSikinIdouListSks, qIT_KykSyouhn, qIT_KykKihon)
            .getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    public ExDBResults<HijynNykSikinIdouDataBean> getHijynbrNykDatasKeizokup(String pKakutyoujobcd, BizDateYM pSyoriYM) {

        QBT_HijynNykSikinIdouListSks qBT_HijynNykSikinIdouListSks = new QBT_HijynNykSikinIdouListSks("qBT_HijynNykSikinIdouListSks");
        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");
        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");

        String querySql = $SELECT + $NEW(HijynNykSikinIdouDataBean.class,
            qBT_HijynNykSikinIdouListSks.syono,
            qBT_HijynNykSikinIdouListSks.sikinidoupjytym,
            qBT_HijynNykSikinIdouListSks.syoriYmd,
            qBT_HijynNykSikinIdouListSks.siteituuka,
            qBT_HijynNykSikinIdouListSks.siteituukagk.getTypeFieldName(),
            qBT_HijynNykSikinIdouListSks.siteituukagk.getValueFieldName(),
            qBT_HijynNykSikinIdouListSks.trhktuuka,
            qBT_HijynNykSikinIdouListSks.trhktuukagk.getTypeFieldName(),
            qBT_HijynNykSikinIdouListSks.trhktuukagk.getValueFieldName(),
            qBT_HijynNykSikinIdouListSks.seg1cd,
            qBT_HijynNykSikinIdouListSks.sikinidougroupkbn,
            qBT_HijynNykSikinIdouListSks.sikinidoumeisaikbn,
            qBT_HijynNykSikinIdouListSks.sikinidoujtkbn,
            qBT_HijynNykSikinIdouListSks.sikinidoukawaserate,
            qBT_HijynNykSikinIdouListSks.sikinidoupkbn,
            qIT_KykSyouhn.kykymd,
            qIT_KykKihon.fstpnyknymd,
            qIT_KykSyouhn.syoumetuymd) +
            $FROM(qBT_HijynNykSikinIdouListSks,
                qIT_KykSyouhn,
                qIT_KykKihon) +
                $WHERE + qBT_HijynNykSikinIdouListSks.syono.eq(qIT_KykSyouhn.syono) +
                $AND + qBT_HijynNykSikinIdouListSks.syono.eq(qIT_KykKihon.syono) +
                $AND + qBT_HijynNykSikinIdouListSks.sikinidoujtkbn.eq(C_SikinidouJtKbn.SIKINIDOUMIRYOU) +
                $AND + qBT_HijynNykSikinIdouListSks.sikinidoupkbn.eq(C_SikinidouPKbn.KEIZOKUP) +
                $AND + qBT_HijynNykSikinIdouListSks.sikinidoupjytym.le(pSyoriYM) +
                $AND + qIT_KykSyouhn.yuukousyoumetukbn.eq(C_YuukousyoumetuKbn.YUUKOU) +
                $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU);


        ExDBResults<HijynNykSikinIdouDataBean> exDBResults = exDBEntityManager
            .createJPQL(querySql, HijynNykSikinIdouDataBean.class).bind(qBT_HijynNykSikinIdouListSks, qIT_KykSyouhn, qIT_KykKihon)
            .getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    public ExDBResults<HijynNykSikinIdouDataBean> getHijynbrNyktrksDatas(String pKakutyoujobcd) {

        QBT_HijynNykSikinIdouListSks qBT_HijynNykSikinIdouListSks = new QBT_HijynNykSikinIdouListSks("qBT_HijynNykSikinIdouListSks");
        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");
        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");

        String querySql = $SELECT + $NEW(HijynNykSikinIdouDataBean.class,
            qBT_HijynNykSikinIdouListSks.syono,
            qBT_HijynNykSikinIdouListSks.sikinidoupjytym,
            qBT_HijynNykSikinIdouListSks.syoriYmd,
            qBT_HijynNykSikinIdouListSks.siteituuka,
            qBT_HijynNykSikinIdouListSks.siteituukagk.getTypeFieldName(),
            qBT_HijynNykSikinIdouListSks.siteituukagk.getValueFieldName(),
            qBT_HijynNykSikinIdouListSks.trhktuuka,
            qBT_HijynNykSikinIdouListSks.trhktuukagk.getTypeFieldName(),
            qBT_HijynNykSikinIdouListSks.trhktuukagk.getValueFieldName(),
            qBT_HijynNykSikinIdouListSks.seg1cd,
            qBT_HijynNykSikinIdouListSks.sikinidougroupkbn,
            qBT_HijynNykSikinIdouListSks.sikinidoumeisaikbn,
            qBT_HijynNykSikinIdouListSks.sikinidoujtkbn,
            qBT_HijynNykSikinIdouListSks.sikinidoukawaserate,
            qBT_HijynNykSikinIdouListSks.sikinidoupkbn,
            qIT_KykSyouhn.kykymd,
            qIT_KykKihon.fstpnyknymd,
            qIT_KykSyouhn.syoumetuymd) +
            $FROM(qBT_HijynNykSikinIdouListSks,
                qIT_KykSyouhn,
                qIT_KykKihon) +
                $WHERE + qBT_HijynNykSikinIdouListSks.sikinidoujtkbn.eq( C_SikinidouJtKbn.SIKINIDOUTORIKESI) +
                $AND + qBT_HijynNykSikinIdouListSks.syono.eq(qIT_KykSyouhn.syono) +
                $AND + qBT_HijynNykSikinIdouListSks.syono.eq(qIT_KykKihon.syono) ;

        ExDBResults<HijynNykSikinIdouDataBean> exDBResults = exDBEntityManager
            .createJPQL(querySql, HijynNykSikinIdouDataBean.class).bind(qBT_HijynNykSikinIdouListSks, qIT_KykSyouhn, qIT_KykKihon).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    public ExDBResults<HijynNykSikinIdouDataBean> getHijynbrNykDatasSyoumetu(String pKakutyoujobcd, BizDateYM pSyoriYM, BizDate pSyoriYMD) {

        QBT_HijynNykSikinIdouListSks qBT_HijynNykSikinIdouListSks = new QBT_HijynNykSikinIdouListSks("qBT_HijynNykSikinIdouListSks");
        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");
        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");
        QIT_KhShrRireki qIT_KhShrRireki = new QIT_KhShrRireki("qIT_KhShrRireki");
        QJT_SiKekka qJT_SiKekka = new QJT_SiKekka("qJT_SiKekka");

        String subQuery1 = $SELECT + qIT_KhShrRireki.syono +
            $FROM(qIT_KhShrRireki) +
            $WHERE + qIT_KhShrRireki.syono.eq(qBT_HijynNykSikinIdouListSks.syono) +
            $AND + qIT_KhShrRireki.shrsyoriymd.eq(pSyoriYMD) +
            $AND + "(" + qIT_KhShrRireki.shrsyorikbn.ne(C_ShrsyoriKbn.KYKTORIKESI) +
            $AND + qIT_KhShrRireki.shrsyorikbn.ne(C_ShrsyoriKbn.CLGOFF) +
            $AND + qIT_KhShrRireki.shrsyorikbn.ne(C_ShrsyoriKbn.SBMUKOU_KIHRKPSHR) + ")";

        String subQuery2 = $SELECT + qJT_SiKekka.syono +
            $FROM(qJT_SiKekka) +
            $WHERE + qJT_SiKekka.syono.eq(qBT_HijynNykSikinIdouListSks.syono) +
            $AND + qJT_SiKekka.syoriYmd.eq(pSyoriYMD);

        String querySql = $SELECT + $NEW(HijynNykSikinIdouDataBean.class,
            qBT_HijynNykSikinIdouListSks.syono,
            qBT_HijynNykSikinIdouListSks.sikinidoupjytym,
            qBT_HijynNykSikinIdouListSks.syoriYmd,
            qBT_HijynNykSikinIdouListSks.siteituuka,
            qBT_HijynNykSikinIdouListSks.siteituukagk.getTypeFieldName(),
            qBT_HijynNykSikinIdouListSks.siteituukagk.getValueFieldName(),
            qBT_HijynNykSikinIdouListSks.trhktuuka,
            qBT_HijynNykSikinIdouListSks.trhktuukagk.getTypeFieldName(),
            qBT_HijynNykSikinIdouListSks.trhktuukagk.getValueFieldName(),
            qBT_HijynNykSikinIdouListSks.seg1cd,
            qBT_HijynNykSikinIdouListSks.sikinidougroupkbn,
            qBT_HijynNykSikinIdouListSks.sikinidoumeisaikbn,
            qBT_HijynNykSikinIdouListSks.sikinidoujtkbn,
            qBT_HijynNykSikinIdouListSks.sikinidoukawaserate,
            qBT_HijynNykSikinIdouListSks.sikinidoupkbn,
            qIT_KykSyouhn.kykymd,
            qIT_KykKihon.fstpnyknymd,
            qIT_KykSyouhn.syoumetuymd) +
            $FROM(qBT_HijynNykSikinIdouListSks,
                qIT_KykSyouhn,
                qIT_KykKihon) +
                $WHERE + qBT_HijynNykSikinIdouListSks.syono.eq(qIT_KykSyouhn.syono) +
                $AND + qBT_HijynNykSikinIdouListSks.syono.eq(qIT_KykKihon.syono) +
                $AND + qBT_HijynNykSikinIdouListSks.sikinidoujtkbn.eq(C_SikinidouJtKbn.SIKINIDOUMIRYOU) +
                $AND + qBT_HijynNykSikinIdouListSks.sikinidoupkbn.eq(C_SikinidouPKbn.KEIZOKUP) +
                $AND + qBT_HijynNykSikinIdouListSks.sikinidoupjytym.le(pSyoriYM) +
                $AND + qIT_KykSyouhn.yuukousyoumetukbn.eq(C_YuukousyoumetuKbn.SYOUMETU) +
                $AND + qIT_KykSyouhn.syutkkbn.eq(C_SyutkKbn.SYU) +
                $AND + "(" + $EXISTS(subQuery1) +
                $OR + $EXISTS(subQuery2) + ")";


        ExDBResults<HijynNykSikinIdouDataBean> exDBResults = exDBEntityManager
            .createJPQL(querySql, HijynNykSikinIdouDataBean.class)
            .bind(qBT_HijynNykSikinIdouListSks, qIT_KykSyouhn, qIT_KykKihon, qIT_KhShrRireki, qJT_SiKekka)
            .getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    public ExDBResults<HijynNykGkSikinIdouDataBean> getHijynbrNykGkDatas(String pKakutyoujobcd, BizDate pSyoriYMD) {

        QBT_HijynNykSiknIdouLstSksGk qBT_HijynNykSiknIdouLstSksGk = new QBT_HijynNykSiknIdouLstSksGk("qBT_HijynNykSiknIdouLstSksGk");
        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");

        String querySql = $SELECT + $NEW(HijynNykGkSikinIdouDataBean.class,
            qBT_HijynNykSiknIdouLstSksGk.syoriYmd,
            qBT_HijynNykSiknIdouLstSksGk.sikinidoupkbn,
            qBT_HijynNykSiknIdouLstSksGk.syono,
            qBT_HijynNykSiknIdouLstSksGk.renno,
            qBT_HijynNykSiknIdouLstSksGk.siteituuka,
            qBT_HijynNykSiknIdouLstSksGk.siteituukagk.getTypeFieldName(),
            qBT_HijynNykSiknIdouLstSksGk.siteituukagk.getValueFieldName(),
            qBT_HijynNykSiknIdouLstSksGk.trhktuuka,
            qBT_HijynNykSiknIdouLstSksGk.trhktuukagk.getTypeFieldName(),
            qBT_HijynNykSiknIdouLstSksGk.trhktuukagk.getValueFieldName(),
            qBT_HijynNykSiknIdouLstSksGk.seg1cd,
            qBT_HijynNykSiknIdouLstSksGk.sikinidougroupkbn,
            qBT_HijynNykSiknIdouLstSksGk.sikinidoumeisaikbn,
            qBT_HijynNykSiknIdouLstSksGk.sikinidoujtkbn,
            qBT_HijynNykSiknIdouLstSksGk.sikinidoukawaserate) +
            $FROM(qBT_HijynNykSiknIdouLstSksGk,
                qIT_KykKihon) +
                $WHERE + qBT_HijynNykSiknIdouLstSksGk.syoriYmd.le(pSyoriYMD) +
                $AND + $(qBT_HijynNykSiknIdouLstSksGk.sikinidoujtkbn.eq( C_SikinidouJtKbn.SIKINIDOUMIRYOU) +
                    $OR + qBT_HijynNykSiknIdouLstSksGk.sikinidoujtkbn.eq( C_SikinidouJtKbn.SIKINIDOUTORIKESI))  +
                    $AND + qBT_HijynNykSiknIdouLstSksGk.syono.eq(qIT_KykKihon.syono) ;

        ExDBResults<HijynNykGkSikinIdouDataBean> exDBResults = exDBEntityManager
            .createJPQL(querySql, HijynNykGkSikinIdouDataBean.class).bind(qBT_HijynNykSiknIdouLstSksGk, qIT_KykKihon).getResults();

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }
}
