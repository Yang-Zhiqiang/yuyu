package yuyu.batch.hozen.khkessan.khazukarikinkessantyusyutu.dba;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.biz.result.impl.ExDBSkippedResultsFilter;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.classification.C_ShrsyoriKbn;
import yuyu.def.db.entity.IT_AzukarikinKessankanri;
import yuyu.def.db.entity.IT_KhBikinkanri;
import yuyu.def.db.entity.IT_KhShrRireki;
import yuyu.def.db.entity.JT_SiBikinkanri;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.db.meta.QIT_Azukarikin;
import yuyu.def.db.meta.QIT_AzukarikinKessankanri;
import yuyu.def.db.meta.QIT_KhBikinkanri;
import yuyu.def.db.meta.QIT_KhShrRireki;
import yuyu.def.db.meta.QIT_KykKihon;
import yuyu.def.db.meta.QIT_KykSyouhn;
import yuyu.def.db.meta.QJT_SiBikinkanri;
import yuyu.def.db.meta.QJT_SiRireki;
import yuyu.def.db.meta.QJT_Sk;
import yuyu.def.db.meta.QJT_SkKihon;

/**
 * 契約保全 決算 預り金決算情報抽出DAO
 */
public class KhAzukarikinKessanTyusyutuDao {

    @Inject
    private ExDBEntityManager exDBEntityManager;

    public List<IT_AzukarikinKessankanri> getKhAzukarikinKessanInfoByKessankijyunymd(BizDate pKessanYmd) {

        QIT_AzukarikinKessankanri qIT_AzukarikinKessankanri = new QIT_AzukarikinKessankanri("qIT_AzukarikinKessankanri");

        String strSql = $SELECT + qIT_AzukarikinKessankanri +
            $FROM (qIT_AzukarikinKessankanri) +
            $WHERE + qIT_AzukarikinKessankanri.kessankijyunymd.eq(pKessanYmd);

        return exDBEntityManager.createJPQL(strSql).bind(qIT_AzukarikinKessankanri).getResultList();
    }

    public ExDBResults<KhAzukarikinKessanInfosByKakutyoujobcdKsnbiymdBean> getKhAzukarikinKessanInfosByKakutyoujobcdKsnbiymd(
        String pKakutyoujobcd, BizDate pKessanYmd) {

        QIT_KykKihon qIT_KykKihon = new QIT_KykKihon("qIT_KykKihon");
        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn("qIT_KykSyouhn");
        QIT_Azukarikin qIT_Azukarikin = new QIT_Azukarikin("qIT_Azukarikin");

        String mainStry = $SELECT + qIT_KykKihon + "," +
            qIT_KykSyouhn + "," +
            qIT_Azukarikin +
            $FROM (qIT_KykKihon,
                qIT_KykSyouhn,
                qIT_Azukarikin)+
                $WHERE + qIT_KykKihon.syono.eq(qIT_KykSyouhn.syono) +
                $AND + qIT_KykKihon.syono.eq(qIT_Azukarikin.syono) +
                $AND + qIT_Azukarikin.azukarikingk.gtZero() +
                $AND + qIT_Azukarikin.azukarikinhsiymd.le(pKessanYmd);

        ExDBResults<KhAzukarikinKessanInfosByKakutyoujobcdKsnbiymdBean> exDBResults =
            exDBEntityManager.createJPQL(mainStry).bind(qIT_KykKihon, qIT_KykSyouhn, qIT_Azukarikin)
            .getResults(KhAzukarikinKessanInfosByKakutyoujobcdKsnbiymdBean.class);

        exDBResults.setFilter(new ExDBSkippedResultsFilter(pKakutyoujobcd));

        return exDBResults;
    }

    public IT_KhBikinkanri getKhBikinkanriBySyonoKsnbiymd(String pSyono, BizDate pKessanYmd) {

        QIT_KhBikinkanri qIT_KhBikinkanri = new QIT_KhBikinkanri("qIT_KhBikinkanri");

        String strSql = $SELECT + qIT_KhBikinkanri +
            $FROM (qIT_KhBikinkanri) +
            $WHERE + qIT_KhBikinkanri.syono.eq(pSyono) +
            $AND + qIT_KhBikinkanri.kessankijyunymd.eq(pKessanYmd) +
            $AND + qIT_KhBikinkanri.bkncdkbn.eq(C_BkncdKbn.KAIYAKU);

        return exDBEntityManager.createJPQL(strSql).bind(qIT_KhBikinkanri).getSingleResult();

    }

    public JT_SiBikinkanri getSiBikinkanriBySyonoKsnbiymd(String pSyono, BizDate pKessanYmd) {

        QJT_SiBikinkanri qJT_SiBikinkanri = new QJT_SiBikinkanri("qJT_SiBikinkanri");

        String strSql = $SELECT + qJT_SiBikinkanri +
            $FROM (qJT_SiBikinkanri) +
            $WHERE + qJT_SiBikinkanri.syono.eq(pSyono) +
            $AND + qJT_SiBikinkanri.kessankijyunymd.eq(pKessanYmd) +
            $AND + qJT_SiBikinkanri.shrkekkakbn.ne(C_ShrKekkaKbn.HSHR) +
            $AND + qJT_SiBikinkanri.bknrigikbn.ne(C_BknrigiKbn.DEL) +
            $AND + qJT_SiBikinkanri.bkncdkbn.in(C_BkncdKbn.SIBOUUKETUKE,
                C_BkncdKbn.SIBOUKARIUKETUKE,
                C_BkncdKbn.MENSEKI,
                C_BkncdKbn.SIBOUKAIJYO);

        return exDBEntityManager.createJPQL(strSql).bind(qJT_SiBikinkanri).getSingleResult();

    }

    public IT_KhShrRireki getKhShrRirekiBySyono(String pSyono) {

        QIT_KhShrRireki qIT_KhShrRireki = new QIT_KhShrRireki("qIT_KhShrRireki");

        String strSql = $SELECT + qIT_KhShrRireki +
            $FROM (qIT_KhShrRireki) +
            $WHERE + qIT_KhShrRireki.syono.eq(pSyono) +
            $AND + qIT_KhShrRireki.shrsyorikbn.in(C_ShrsyoriKbn.KAIJO,
                C_ShrsyoriKbn.SBKAIJO,
                C_ShrsyoriKbn.KAIYAKU,
                C_ShrsyoriKbn.SBMENSEKI) +
                $ORDER_BY(qIT_KhShrRireki.henkousikibetukey.desc());

        return exDBEntityManager.createJPQL(strSql).setFirstResult(0).setMaxResults(1).bind(qIT_KhShrRireki).getSingleResult();

    }

    public JT_Sk getSkBySyono(String pSyono) {

        QJT_Sk qJT_Sk = new QJT_Sk("qJT_Sk");
        QJT_SiRireki qJT_SiRireki = new QJT_SiRireki("qJT_SiRireki");
        QJT_SkKihon qJT_SkKihon = new QJT_SkKihon("qJT_SkKihon");

        String mainStry = $SELECT + qJT_Sk +
            $FROM (qJT_Sk,
                qJT_SiRireki,
                qJT_SkKihon)  +
                $WHERE + qJT_Sk.skno.eq(qJT_SiRireki.skno) +
                $AND + qJT_Sk.syono.eq(qJT_SiRireki.syono) +
                $AND + qJT_Sk.seikyuurirekino.eq(qJT_SiRireki.seikyuurirekino) +
                $AND + qJT_SiRireki.skno.eq(qJT_SkKihon.skno) +
                $AND + qJT_SiRireki.syono.eq(qJT_SkKihon.syono) +
                $AND + qJT_SiRireki.syono.eq(pSyono) +
                $AND + qJT_SiRireki.shrkekkakbn.eq(C_ShrKekkaKbn.SHR) +
                $AND + qJT_SkKihon.seikyuusyubetu.eq(C_SeikyuuSyubetu.SB);
        $ORDER_BY(qJT_Sk.seikyuurirekino.desc());

        return exDBEntityManager.createJPQL(mainStry).setFirstResult(0).setMaxResults(1).bind(qJT_Sk, qJT_SiRireki, qJT_SkKihon).getSingleResult();
    }
}