package yuyu.common.suuri.srcommon;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBEntityManager;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.def.classification.C_DensyoriKbn;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_HaitoumeisaiKbn;
import yuyu.def.classification.C_HnkSyuruiKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BT_DenpyoData;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_Azukarikin;
import yuyu.def.db.entity.IT_HokenryouTmttkn;
import yuyu.def.db.entity.IT_KhHaitouKanri;
import yuyu.def.db.entity.IT_KhHenkouRireki;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KhTumitateDKanri;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykSyouhnHnkmae;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_SeihowebIdouRireki;
import yuyu.def.db.entity.ST_HoyuuMeisaiTyukeiyouItzHzn;
import yuyu.def.db.entity.ST_IdouMeisaiTyukeiyouItzHzn;
import yuyu.def.db.meta.QBT_DenpyoData;
import yuyu.def.db.meta.QIT_Azukarikin;
import yuyu.def.db.meta.QIT_HokenryouTmttkn;
import yuyu.def.db.meta.QIT_KhHaitouKanri;
import yuyu.def.db.meta.QIT_KhHenkouRireki;
import yuyu.def.db.meta.QIT_KhSisuurendoTmttkn;
import yuyu.def.db.meta.QIT_KhTtdkRireki;
import yuyu.def.db.meta.QIT_KhTumitateDKanri;
import yuyu.def.db.meta.QIT_KykDairiten;
import yuyu.def.db.meta.QIT_KykSyouhn;
import yuyu.def.db.meta.QIT_KykSyouhnHnkmae;
import yuyu.def.db.meta.QIT_NyknJissekiRireki;
import yuyu.def.db.meta.QST_DshrTukiTyukeiyouItzHzn;
import yuyu.def.db.meta.QST_HoyuuMeisaiTyukeiyouItzHzn;
import yuyu.def.db.meta.QST_IdouMeisaiTyukeiyouItzHzn;
import yuyu.def.hozen.detacher.IT_KykKihonDetacher;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.result.bean.KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean;

/**
 * 数理 数理統計共通 アクセス用Daoクラス
 */
public class SrCommonKinouDao {

    @Inject
    ExDBEntityManager exDBEntityManager;

    @Inject
    private HozenDomManager hozenDomManager;

    public KykDairitenByPkBean getKykDairitenByPk(String pSyono, Integer pDrtenrenno) {

        QIT_KykDairiten qIT_KykDairiten = new QIT_KykDairiten();

        String queryStr = $SELECT +  $NEW(KykDairitenByPkBean.class,
            qIT_KykDairiten.drtenkanrisosikicd ) +
            $FROM + qIT_KykDairiten.IT_KykDairiten() +
            $WHERE + qIT_KykDairiten.syono.eq(pSyono) +
            $AND + qIT_KykDairiten.drtenrenno.eq(pDrtenrenno);

        return exDBEntityManager.createJPQL(queryStr, KykDairitenByPkBean.class).bind(qIT_KykDairiten).getSingleResult();
    }

    public List<IT_KhSisuurendoTmttkn> getKhSisuurendoTmttknBySyonoTmttknkouryokukaisiymdDesc(String pSyono,
        BizDate pKijyunymd) {

        QIT_KhSisuurendoTmttkn qIT_KhSisuurendoTmttkn = new QIT_KhSisuurendoTmttkn();

        String queryStr = $SELECT + qIT_KhSisuurendoTmttkn +
            $FROM + qIT_KhSisuurendoTmttkn.IT_KhSisuurendoTmttkn() +
            $WHERE + qIT_KhSisuurendoTmttkn.syono.eq(pSyono) +
            $AND + qIT_KhSisuurendoTmttkn.tmttknkouryokukaisiymd.le(pKijyunymd) +
            $ORDER_BY (qIT_KhSisuurendoTmttkn.tmttknkouryokukaisiymd.desc(),
                qIT_KhSisuurendoTmttkn.renno.desc());

        return exDBEntityManager.createJPQL(queryStr).bind(qIT_KhSisuurendoTmttkn).getResultList();
    }

    public List<IT_KhSisuurendoTmttkn> getKhSisuurendoTmttknBySyonoTmttknkouryokukaisiymdAsc(String pSyono,
        BizDate pKijyunymd) {

        QIT_KhSisuurendoTmttkn qIT_KhSisuurendoTmttkn = new QIT_KhSisuurendoTmttkn();

        String queryStr = $SELECT + qIT_KhSisuurendoTmttkn +
            $FROM + qIT_KhSisuurendoTmttkn.IT_KhSisuurendoTmttkn() +
            $WHERE + qIT_KhSisuurendoTmttkn.syono.eq(pSyono) +
            $AND + qIT_KhSisuurendoTmttkn.tmttknkouryokukaisiymd.le(pKijyunymd) +
            $ORDER_BY (qIT_KhSisuurendoTmttkn.tmttknkouryokukaisiymd.asc(),
                qIT_KhSisuurendoTmttkn.renno.asc());

        return exDBEntityManager.createJPQL(queryStr).bind(qIT_KhSisuurendoTmttkn).getResultList();
    }

    public List<IT_KykSyouhnHnkmae> getKykSyouhnHnkmaes(String pSyono) {

        QIT_KykSyouhnHnkmae qIT_KykSyouhnHnkmae = new QIT_KykSyouhnHnkmae();

        String queryStr = $SELECT + qIT_KykSyouhnHnkmae +
            $FROM + qIT_KykSyouhnHnkmae.IT_KykSyouhnHnkmae() +
            $WHERE + qIT_KykSyouhnHnkmae.syono.eq(pSyono) +
            $ORDER_BY(qIT_KykSyouhnHnkmae.henkousikibetukey.desc());

        return exDBEntityManager.createJPQL(queryStr).bind(qIT_KykSyouhnHnkmae).getResultList();
    }

    public List<KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean> getKhHenkouRirekis(String pSyono,
        String pHenkousikibetukey, String pTableid, String pHenkoukoumokuid) {

        QIT_KhHenkouRireki qIT_KhHenkouRireki = new QIT_KhHenkouRireki();

        String queryStr = $SELECT + $NEW(KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean.class,
            qIT_KhHenkouRireki.henkousikibetukey,
            qIT_KhHenkouRireki.bfrnaiyouoriginal,
            qIT_KhHenkouRireki.newnaiyouoriginal) +
            $FROM + qIT_KhHenkouRireki.IT_KhHenkouRireki() +
            $WHERE + qIT_KhHenkouRireki.syono.eq(pSyono) +
            $AND + qIT_KhHenkouRireki.henkousikibetukey.eq(pHenkousikibetukey) +
            $AND + qIT_KhHenkouRireki.tableid.eq(pTableid) +
            $AND + qIT_KhHenkouRireki.henkoukoumokuid.eq(pHenkoukoumokuid);

        return exDBEntityManager
            .createJPQL(queryStr, KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean.class)
            .bind(qIT_KhHenkouRireki).getResultList();
    }

    public ExDBResults<ST_HoyuuMeisaiTyukeiyouItzHzn> getHoyuuMeisaiTyukeiyouItzHzns(String pKijyunym,
        String pKakutyoujobcd, String... pHknsyukigou) {

        QST_HoyuuMeisaiTyukeiyouItzHzn qST_HoyuuMeisaiTyukeiyouItzHzn = new QST_HoyuuMeisaiTyukeiyouItzHzn();

        String queryStr = $SELECT + qST_HoyuuMeisaiTyukeiyouItzHzn +
            $FROM + qST_HoyuuMeisaiTyukeiyouItzHzn.ST_HoyuuMeisaiTyukeiyouItzHzn() +
            $WHERE + qST_HoyuuMeisaiTyukeiyouItzHzn.ztysrkijyunym.eq(pKijyunym) +
            $AND + qST_HoyuuMeisaiTyukeiyouItzHzn.ztysrkakutyoujobcd.eq(pKakutyoujobcd) +
            $AND + qST_HoyuuMeisaiTyukeiyouItzHzn.ztyhknsyukigou.in(pHknsyukigou);

        return exDBEntityManager.createJPQL(queryStr).bind(qST_HoyuuMeisaiTyukeiyouItzHzn).getResults();
    }

    public ExDBResults<ST_IdouMeisaiTyukeiyouItzHzn> getIdouMeisaiTyukeiyouItzHzns(String pKijyunym,
        String pKakutyoujobcd, String... pHknsyukigou) {

        QST_IdouMeisaiTyukeiyouItzHzn qST_IdouMeisaiTyukeiyouItzHzn = new QST_IdouMeisaiTyukeiyouItzHzn();

        String queryStr = $SELECT + qST_IdouMeisaiTyukeiyouItzHzn +
            $FROM + qST_IdouMeisaiTyukeiyouItzHzn.ST_IdouMeisaiTyukeiyouItzHzn() +
            $WHERE + qST_IdouMeisaiTyukeiyouItzHzn.ztysrkijyunym.eq(pKijyunym) +
            $AND + qST_IdouMeisaiTyukeiyouItzHzn.ztysrkakutyoujobcd.eq(pKakutyoujobcd) +
            $AND + qST_IdouMeisaiTyukeiyouItzHzn.ztyhknsyukigou.in(pHknsyukigou);

        return exDBEntityManager.createJPQL(queryStr).bind(qST_IdouMeisaiTyukeiyouItzHzn).getResults();

    }

    public List<KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean> getTargetTokuyakuBefaAftMokuhyoutiDescList(String pSyono) {

        QIT_KhHenkouRireki qIT_KhHenkouRireki = new QIT_KhHenkouRireki("qIT_KhHenkouRireki");

        String strSql = $SELECT + $NEW(KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean.class,
            qIT_KhHenkouRireki.henkousikibetukey,
            qIT_KhHenkouRireki.bfrnaiyouoriginal,
            qIT_KhHenkouRireki.newnaiyouoriginal) +
            $FROM(qIT_KhHenkouRireki) +
            $WHERE + qIT_KhHenkouRireki.syono.eq(pSyono) +
            $AND + qIT_KhHenkouRireki.tableid.eq(IT_KykSonotaTkyk.TABLE_NAME) +
            $AND + qIT_KhHenkouRireki.henkoukoumokuid.eq(IT_KykSonotaTkyk.TARGETTKMOKUHYOUTI)+
            $AND + $(qIT_KhHenkouRireki.gyoumuKousinKinou.eq(IKhozenCommonConstants.KINOUID_KHMKHGKHENKOU)+
                $OR + qIT_KhHenkouRireki.gyoumuKousinKinou.eq(IKhozenCommonConstants.KINOUID_KHBATCHMKHGKHENKOU))+
                $ORDER_BY (qIT_KhHenkouRireki.henkousikibetukey.desc());

        return exDBEntityManager.createJPQL(strSql,KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean.class).bind(qIT_KhHenkouRireki).getResultList();
    }

    public void deleteStHoyuuMeisaiTyukeiyouItzHzn() {

        QST_HoyuuMeisaiTyukeiyouItzHzn qST_HoyuuMeisaiTyukeiyouItzHzn = new QST_HoyuuMeisaiTyukeiyouItzHzn();

        String strSql = $DELETE_FROM(qST_HoyuuMeisaiTyukeiyouItzHzn);

        exDBEntityManager.createJPQL(strSql).bind(qST_HoyuuMeisaiTyukeiyouItzHzn).executeUpdate();
    }

    public void deleteStIdouMeisaiTyukeiyouItzHzn(String pZtysrkakutyoujobcd){
        QST_IdouMeisaiTyukeiyouItzHzn qST_IdouMeisaiTyukeiyouItzHzn = new QST_IdouMeisaiTyukeiyouItzHzn();

        String strSql = $DELETE_FROM(qST_IdouMeisaiTyukeiyouItzHzn) +
            $WHERE + qST_IdouMeisaiTyukeiyouItzHzn.ztysrkakutyoujobcd.like(pZtysrkakutyoujobcd + "%");

        exDBEntityManager.createJPQL(strSql).bind(qST_IdouMeisaiTyukeiyouItzHzn).executeUpdate();
    }

    public List<IT_KykSyouhn> getKykSyouhns(String pSyono, C_SyutkKbn pSyutkKbn) {

        IT_KykKihon itKykKihon = hozenDomManager.getKykKihon(pSyono);

        itKykKihon = IT_KykKihonDetacher.detachKykSyouhntouched(itKykKihon);

        List<IT_KykSyouhn> itKykSyouhnList = itKykKihon.getKykSyouhnsBySyutkkbn(pSyutkKbn);

        return itKykSyouhnList;
    }

    public ExDBResults<IT_KykSyouhn> getKykSyouhns(C_SyutkKbn pSyutkKbn, String pKbnkey) {

        QIT_KykSyouhn qIT_KykSyouhn = new QIT_KykSyouhn();

        String where = "";
        if (!BizUtil.isBlank(pKbnkey)) {
            where = $AND + qIT_KykSyouhn.kbnkey.eq(pKbnkey);
        }

        String strSql = $SELECT + qIT_KykSyouhn +
            $FROM + qIT_KykSyouhn.IT_KykSyouhn() +
            $WHERE + qIT_KykSyouhn.syutkkbn.eq(pSyutkKbn) +
            where
            ;

        return exDBEntityManager.createJPQL(strSql).bind(qIT_KykSyouhn).getResults();
    }

    public List<IT_HokenryouTmttkn> getHokenryouTmttkns(String pSyono,
        BizDateYM pTmttkntaisyouym) {

        QIT_HokenryouTmttkn qIT_HokenryouTmttkn = new QIT_HokenryouTmttkn();

        String strSql = $SELECT + qIT_HokenryouTmttkn +
            $FROM + qIT_HokenryouTmttkn.IT_HokenryouTmttkn() +
            $WHERE + qIT_HokenryouTmttkn.syono.eq(pSyono) +
            $AND + qIT_HokenryouTmttkn.tmttkntaisyouym.le(pTmttkntaisyouym) +
            $ORDER_BY (qIT_HokenryouTmttkn.tmttkntaisyouym.desc(),
                qIT_HokenryouTmttkn.renno.desc());

        return exDBEntityManager.createJPQL(strSql).bind(qIT_HokenryouTmttkn).getResultList();
    }

    public IT_KykKihon getKykKihon(String pSyono) {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);

        kykKihon = IT_KykKihonDetacher.detachKykKihontouched(kykKihon);

        return kykKihon;
    }

    public ExDBResults<IT_NyknJissekiRireki> getNyknJissekiRirekis(String pSyono,
        BizDate pKijyunymd) {

        QIT_NyknJissekiRireki qIT_NyknJissekiRireki = new QIT_NyknJissekiRireki();

        String strSql = $SELECT + qIT_NyknJissekiRireki +
            $FROM + qIT_NyknJissekiRireki.IT_NyknJissekiRireki() +
            $WHERE + qIT_NyknJissekiRireki.syono.eq(pSyono) +
            $AND + $(qIT_NyknJissekiRireki.ryosyuymd.ge(pKijyunymd)+
                $OR + qIT_NyknJissekiRireki.nyktrksymd.ge(pKijyunymd)) +
                $ORDER_BY (qIT_NyknJissekiRireki.gyoumuKousinTime.desc(),
                    qIT_NyknJissekiRireki.jyutoustartym.desc());

        return exDBEntityManager.createJPQL(strSql).bind(qIT_NyknJissekiRireki).getResults();
    }

    public IT_Azukarikin getAzukarikin(String pSyono,
        String pHenkousikibetukey, C_Tuukasyu pTuukasyu) {

        QIT_Azukarikin qIT_Azukarikin = new QIT_Azukarikin();

        String strSql = $SELECT + qIT_Azukarikin +
            $FROM + qIT_Azukarikin.IT_Azukarikin() +
            $WHERE + qIT_Azukarikin.syono.eq(pSyono) +
            $AND + qIT_Azukarikin.henkousikibetukey.eq(pHenkousikibetukey)+
            $AND + qIT_Azukarikin.tuukasyu.eq(pTuukasyu);

        return exDBEntityManager.createJPQL(strSql).bind(qIT_Azukarikin).getSingleResult();
    }

    public List<IT_NyknJissekiRireki> getNyknJissekiRirekisBySyonoNnykdenno(String pSyono,
        String pNykdenno) {

        QIT_NyknJissekiRireki qIT_NyknJissekiRireki = new QIT_NyknJissekiRireki();

        String strSql = $SELECT + qIT_NyknJissekiRireki +
            $FROM  + qIT_NyknJissekiRireki.IT_NyknJissekiRireki() +
            $WHERE + qIT_NyknJissekiRireki.syono.eq(pSyono) +
            $AND   + qIT_NyknJissekiRireki.nykdenno.eq(pNykdenno) +
            $ORDER_BY (qIT_NyknJissekiRireki.jyutoustartym.asc());

        return exDBEntityManager.createJPQL(strSql).bind(qIT_NyknJissekiRireki).getResultList();
    }

    public IT_AnsyuKihon getAnsyuKihon(String pSyono) {

        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(pSyono);
        return ansyuKihon;
    }

    public List<BT_DenpyoData> getDenpyoDatasByDensyskbnKeirisyonoDensyorikbn(C_DensysKbn pDensyskbn,
        String pMosno, C_DensyoriKbn pDensyoriKbn) {

        QBT_DenpyoData qBT_DenpyoData = new QBT_DenpyoData();

        String strSql = $SELECT + qBT_DenpyoData +
            $FROM + qBT_DenpyoData.BT_DenpyoData() +
            $WHERE + qBT_DenpyoData.densyskbn.eq(pDensyskbn) +
            $AND + qBT_DenpyoData.keirisyono.eq(pMosno)+
            $AND + qBT_DenpyoData.densyorikbn.eq(pDensyoriKbn) +
            $AND + $(qBT_DenpyoData.kanjyoukmkcd.eq(C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_JPY) +
                $OR + qBT_DenpyoData.kanjyoukmkcd.eq(C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_USD) +
                $OR + qBT_DenpyoData.kanjyoukmkcd.eq(C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_GAIHO_AUD) +
                $OR + qBT_DenpyoData.kanjyoukmkcd.eq(C_Kanjyoukmkcd.SYONENDOSYOKAIHOKENRYOU_HUTUU) +
                $OR + qBT_DenpyoData.kanjyoukmkcd.eq(C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_JPY) +
                $OR + qBT_DenpyoData.kanjyoukmkcd.eq(C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_USD) +
                $OR + qBT_DenpyoData.kanjyoukmkcd.eq(C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_GAIHO_AUD) +
                $OR + qBT_DenpyoData.kanjyoukmkcd.eq(C_Kanjyoukmkcd.SYONENDO2KAIMEIKOU_HUTUU) +
                $OR + qBT_DenpyoData.kanjyoukmkcd.eq(C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_JPY) +
                $OR + qBT_DenpyoData.kanjyoukmkcd.eq(C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_USD) +
                $OR + qBT_DenpyoData.kanjyoukmkcd.eq(C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_GAIHO_AUD) +
                $OR + qBT_DenpyoData.kanjyoukmkcd.eq(C_Kanjyoukmkcd.JINENDOIKOUHOKENRYOU_HUTUU) );

        return exDBEntityManager.createJPQL(strSql).bind(qBT_DenpyoData).getResultList();
    }

    public IT_SeihowebIdouRireki getSeihowebIdouRireki(String pSyono, String pHenkousikibetukey) {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);

        IT_KhTtdkRireki khTtdkRireki = kykKihon.getKhTtdkRirekiByHenkousikibetukey(pHenkousikibetukey);

        if(khTtdkRireki == null){

            return null;
        }

        IT_SeihowebIdouRireki seihowebIdouRireki = khTtdkRireki.getSeihowebIdouRireki();

        return seihowebIdouRireki;
    }

    public List<IT_KhTtdkRireki> getKhTtdkRirekiDatasBySyonoHenkousikibetukey(String pSyono, String pHenkousikibetukey) {

        QIT_KhTtdkRireki qIT_KhTtdkRireki = new QIT_KhTtdkRireki();

        String strSql = $SELECT + qIT_KhTtdkRireki +
            $FROM + qIT_KhTtdkRireki.IT_KhTtdkRireki() +
            $WHERE + qIT_KhTtdkRireki.syono.eq(pSyono) +
            $AND + qIT_KhTtdkRireki.henkousikibetukey.ge(pHenkousikibetukey) +
            $ORDER_BY (qIT_KhTtdkRireki.henkousikibetukey.desc());

        return exDBEntityManager.createJPQL(strSql).bind(qIT_KhTtdkRireki).getResultList();
    }

    public List<IT_KhTtdkRireki> getKhTtdkRirekiDatasBySyonoKijyunymd(String pSyono, BizDate pKijyunYmd) {

        QIT_KhTtdkRireki qIT_KhTtdkRireki = new QIT_KhTtdkRireki();

        String strSql = $SELECT + qIT_KhTtdkRireki +
            $FROM + qIT_KhTtdkRireki.IT_KhTtdkRireki() +
            $WHERE + qIT_KhTtdkRireki.syono.eq(pSyono) +
            $AND + qIT_KhTtdkRireki.syoriYmd.ge(pKijyunYmd) +
            $ORDER_BY (qIT_KhTtdkRireki.henkousikibetukey.desc());

        return exDBEntityManager.createJPQL(strSql).bind(qIT_KhTtdkRireki).getResultList();
    }

    public List<IT_KhSisuurendoTmttkn> getKhSisuurendoTmttknDatasBySyono(String pSyono) {

        QIT_KhSisuurendoTmttkn qIT_KhSisuurendoTmttkn = new QIT_KhSisuurendoTmttkn();

        String strSql = $SELECT + qIT_KhSisuurendoTmttkn +
            $FROM + qIT_KhSisuurendoTmttkn.IT_KhSisuurendoTmttkn() +
            $WHERE + qIT_KhSisuurendoTmttkn.syono.eq(pSyono) +
            $ORDER_BY (qIT_KhSisuurendoTmttkn.tmttknkouryokukaisiymd.desc(),
                qIT_KhSisuurendoTmttkn.renno.desc());

        return exDBEntityManager.createJPQL(strSql).bind(qIT_KhSisuurendoTmttkn).getResultList();
    }

    public IT_KhHenkouRireki getKhHenkouRirekiDataBySyonoHenkousikibetukey(String pSyono,
        String pHenkousikibetukey,
        String pTableid,
        C_HnkSyuruiKbn  pHnksyuruikbn) {

        QIT_KhHenkouRireki qIT_KhHenkouRireki = new QIT_KhHenkouRireki();

        String strSql = $SELECT + qIT_KhHenkouRireki +
            $FROM + qIT_KhHenkouRireki.IT_KhHenkouRireki() +
            $WHERE + qIT_KhHenkouRireki.syono.eq(pSyono) +
            $AND + qIT_KhHenkouRireki.henkousikibetukey.eq(pHenkousikibetukey) +
            $AND + qIT_KhHenkouRireki.tableid.eq(pTableid)+
            $AND + qIT_KhHenkouRireki.hnksyuruikbn.eq(pHnksyuruikbn);

        return exDBEntityManager.createJPQL(strSql).bind(qIT_KhHenkouRireki).getSingleResult();
    }

    public List<IT_KhHaitouKanri> getKhHaitouKanriKakutei(String pSyono, BizDateY pHaitounendo) {

        QIT_KhHaitouKanri qIT_KhHaitouKanri = new QIT_KhHaitouKanri();

        String strSql = $SELECT + qIT_KhHaitouKanri +
            $FROM + qIT_KhHaitouKanri.IT_KhHaitouKanri() +
            $WHERE + qIT_KhHaitouKanri.syono.eq(pSyono) +
            $AND + qIT_KhHaitouKanri.haitounendo.eq(pHaitounendo) +
            $AND + qIT_KhHaitouKanri.naiteikakuteikbn.eq(C_NaiteiKakuteiKbn.KAKUTEI) +
            $ORDER_BY(qIT_KhHaitouKanri.renno.desc());

        return exDBEntityManager.createJPQL(strSql).bind(qIT_KhHaitouKanri).getResultList();
    }

    public void deleteStDshrTukiTyukeiyouItzHzn() {

        QST_DshrTukiTyukeiyouItzHzn qST_DshrTukiTyukeiyouItzHzn = new QST_DshrTukiTyukeiyouItzHzn();

        String strSql = $DELETE_FROM(qST_DshrTukiTyukeiyouItzHzn);

        exDBEntityManager.createJPQL(strSql).bind(qST_DshrTukiTyukeiyouItzHzn).executeUpdate();
    }

    public List<IT_KhTumitateDKanri> getTumitateDKanris(String pSyono, BizDate pKijyunymd) {

        QIT_KhTumitateDKanri qIT_KhTumitateDKanri = new QIT_KhTumitateDKanri();

        String strSql = $SELECT + qIT_KhTumitateDKanri +
            $FROM(qIT_KhTumitateDKanri) +
            $WHERE + qIT_KhTumitateDKanri.syono.eq(pSyono) +
            $AND + qIT_KhTumitateDKanri.tumitatedtumitateymd.le(pKijyunymd) +
            $AND + qIT_KhTumitateDKanri.naiteikakuteikbn.ne(C_NaiteiKakuteiKbn.NAITEI) +
            $ORDER_BY(qIT_KhTumitateDKanri.tumitatedtumitateymd.desc(),
                qIT_KhTumitateDKanri.renno.desc());

        return exDBEntityManager.createJPQL(strSql).bind(qIT_KhTumitateDKanri).getResultList();
    }

    public List<IT_KhHaitouKanri> getHaitouKanris(
        String pSyono, C_HaitoumeisaiKbn pHaitoumeisaikbn, BizDate pKijyunymd) {

        QIT_KhHaitouKanri qIT_KhHaitouKanri = new QIT_KhHaitouKanri();

        String strSql = $SELECT + qIT_KhHaitouKanri +
            $FROM(qIT_KhHaitouKanri) +
            $WHERE + qIT_KhHaitouKanri.syono.eq(pSyono) +
            $AND + qIT_KhHaitouKanri.haitoumeisaikbn.eq(pHaitoumeisaikbn) +
            $AND + qIT_KhHaitouKanri.kariwariatedshrymd.le(pKijyunymd) +
            $ORDER_BY(qIT_KhHaitouKanri.haitounendo.desc(),
                qIT_KhHaitouKanri.renno.desc());

        return exDBEntityManager.createJPQL(strSql).bind(qIT_KhHaitouKanri).getResultList();
    }

    public List<KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean> getKhHenkouBfRirekis(
        String pSyono, String pTableid, String pHenkoukoumokuid) {

        QIT_KhHenkouRireki qIT_KhHenkouRireki = new QIT_KhHenkouRireki();

        String queryStr = $SELECT + $NEW(KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean.class,
            qIT_KhHenkouRireki.henkousikibetukey,
            qIT_KhHenkouRireki.bfrnaiyouoriginal,
            qIT_KhHenkouRireki.newnaiyouoriginal) +
            $FROM + qIT_KhHenkouRireki.IT_KhHenkouRireki() +
            $WHERE + qIT_KhHenkouRireki.syono.eq(pSyono) +
            $AND + qIT_KhHenkouRireki.tableid.eq(pTableid) +
            $AND + qIT_KhHenkouRireki.henkoukoumokuid.eq(pHenkoukoumokuid) +
            $ORDER_BY(qIT_KhHenkouRireki.henkousikibetukey.desc());

        return exDBEntityManager
            .createJPQL(queryStr, KhHenkouRirekiTargetHenkouSikibetuKeyBefaAftNaiyouOriginalBean.class)
            .bind(qIT_KhHenkouRireki).getResultList();
    }

    public List<IT_KhHenkouRireki> getKykdrTkykHenkouRirekis(String pSyono) {

        QIT_KhHenkouRireki qIT_KhHenkouRireki = new QIT_KhHenkouRireki();

        String strSql = $SELECT + qIT_KhHenkouRireki  +
            $FROM + qIT_KhHenkouRireki.IT_KhHenkouRireki() +
            $WHERE + qIT_KhHenkouRireki.syono.eq(pSyono) +
            $AND + qIT_KhHenkouRireki.tableid.eq(IT_KykSonotaTkyk.TABLE_NAME) +
            $AND + $(qIT_KhHenkouRireki.henkoukoumokuid.eq(IT_KykSonotaTkyk.KYKDRTKYKHUKAYMD)+
                $OR + qIT_KhHenkouRireki.henkoukoumokuid.eq(IT_KykSonotaTkyk.KYKDRTKYKKAIYAKUYMD))+
                $ORDER_BY(qIT_KhHenkouRireki.henkousikibetukey.desc());

        return exDBEntityManager.createJPQL(strSql).bind(qIT_KhHenkouRireki).getResultList();
    }
}
