package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.ascommon.KeisanRsgaku;
import yuyu.common.hozen.khcommon.dba4kykhenkoujiznnjyttrksksn.KykHenkoujiZnnJytTrksKsnDao;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KinouKbn;
import yuyu.def.classification.C_KjsymnytblhensyuusyoriKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_Nyktrksflg;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_ZennouSeisanSyoriKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 契約保全 契約保全共通 契約変更時前納充当取消および更新
 */
public class KykHenkoujiZnnJytTrksKsn {

    @Inject
    private static Logger logger;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private KykHenkoujiZnnJytTrksKsnDao kykHenkoujiZnnJytTrksKsnDao;

    @Inject
    private HozenDomManager hozenDomManager;

    public KykHenkoujiZnnJytTrksKsn() {
        super();
    }

    public void exec(KhozenCommonParam pKhozenCommonParam, String pSyoNo, BizDate pSyoriYmd,
        BizDateYM pZennouseisankgkStartYmd, C_ZennouSeisanSyoriKbn pZennouSeisanSyoriKbn) {

        logger.debug("▽ 契約変更時前納充当取消および更新 開始");

        IT_KykKihon kykKihon;

        IT_AnsyuKihon ansyuKihon;

        if (C_KinouKbn.ONLINE.eq(kinou.getKinouKbn())) {
            kykKihon = hozenDomManager.getKykKihon(pSyoNo);

            if (kykKihon == null) {
                throw new CommonBizAppException("契約基本テーブルが取得できませんでした。 証券番号 ＝" + pSyoNo);
            }

            ansyuKihon = hozenDomManager.getAnsyuKihon(pSyoNo);

            if (ansyuKihon == null) {
                throw new CommonBizAppException("案内収納基本テーブルが取得できませんでした。 証券番号 ＝" + pSyoNo);
            }
        }
        else {
            kykKihon = pKhozenCommonParam.getBatchKeiyakuKihon();

            ansyuKihon = pKhozenCommonParam.getBatchAnsyuKihon();
        }

        TorikesiZnnJytInfoOutBean torikesiZnnJytInfoOutBean = torikesiZnnJytInfo(pKhozenCommonParam,
            kykKihon, pSyoriYmd, pZennouseisankgkStartYmd);
        BizDateYM torikesigoJkipjytYm = torikesiZnnJytInfoOutBean.getTorikesigoJkipjytYm();
        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = torikesiZnnJytInfoOutBean.getTorikesigoNyknJissekiRireki();


        if (C_ZennouSeisanSyoriKbn.GENGAKU.eq(pZennouSeisanSyoriKbn)) {

            List<IT_KykSyouhn> kykSyouhnLst = kykKihon.getKykSyouhns();
            if (kykSyouhnLst.size() == 0) {
                throw new CommonBizAppException("契約商品テーブルリストが取得できませんでした。 証券番号 ＝ " + pSyoNo);
            }

            List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
            if (syuKykSyouhnLst.size() == 0) {
                throw new CommonBizAppException("契約商品テーブル（主契約）が取得できませんでした。 証券番号 ＝ " + pSyoNo);
            }
            IT_KykSyouhn kykSyouhn = syuKykSyouhnLst.get(0);

            List<IT_Zennou> zennouLst = ansyuKihon.getZennouMsisnsBySyono();
            if (zennouLst.size() == 0) {
                throw new CommonBizAppException("前納テーブルが取得できませんでした。 証券番号 ＝ " + pSyoNo);
            }
            IT_Zennou zennou = zennouLst.get(0);

            for (IT_NyknJissekiRireki nyknJissekiRireki : nyknJissekiRirekiLst) {
                Integer renno = kykHenkoujiZnnJytTrksKsnDao.getNyknJissekiRirekiMaxRenno(kykKihon,
                    nyknJissekiRireki.getJyutoustartym()) + 1;

                BizCurrency rsgaku;
                Integer jyuutouNensuu;
                Integer jyuutouTukisuu;
                BizCurrency iktWaribikikGk;
                BizDate ryosyuuymd = nyknJissekiRireki.getRyosyuymd().getRekijyou();

                HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
                C_Tuukasyu tuukasyu = henkanTuuka.henkanTuukaTypeToKbn(zennou.getZennoujihrkp().getType());

                if (zennou.getRstuukasyu() != null && !tuukasyu.eq(zennou.getRstuukasyu())) {

                    KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);

                    rsgaku = keisanGaikakanzan.exec(
                        zennou.getRstuukasyu(),
                        zennou.getZennoujihrkp(),
                        zennou.getRyosyukwsrate(),
                        C_HasuusyoriKbn.SUTE);
                }
                else {

                    rsgaku = zennou.getZennoujihrkp();
                }

                if (C_Hrkkaisuu.NEN.eq(kykKihon.getHrkkaisuu())) {

                    jyuutouNensuu = 1;
                    jyuutouTukisuu = 0;
                    iktWaribikikGk = BizCurrency.valueOf(0, rsgaku.getType());
                }
                else {

                    jyuutouNensuu = 0;
                    jyuutouTukisuu = 12;

                    KeisanRsgaku keisanRsgaku = SWAKInjector.getInstance(KeisanRsgaku.class);

                    C_ErrorKbn keisanRsgakuErrorKbn = keisanRsgaku.exec(
                        kykKihon,
                        C_Nykkeiro.ZENNOUJYUUTOU,
                        C_NyknaiyouKbn.ZENNOUP,
                        ryosyuuymd,
                        nyknJissekiRireki.getJyutoustartym(),
                        jyuutouNensuu,
                        jyuutouTukisuu);

                    if (C_ErrorKbn.ERROR.eq(keisanRsgakuErrorKbn)) {

                        throw new CommonBizAppException("領収金額計算でエラーが発生しました。証券番号＝" + pSyoNo);

                    }

                    iktWaribikikGk = keisanRsgaku.getKeisanRsgkOutBean().getIktwaribikikgkGoukei();
                }

                IT_NyknJissekiRireki itNyknJissekiRireki = kykKihon.createNyknJissekiRireki();

                itNyknJissekiRireki.setJyutoustartym(nyknJissekiRireki.getJyutoustartym());

                itNyknJissekiRireki.setRenno(renno);

                itNyknJissekiRireki.setJyutouendym(nyknJissekiRireki.getJyutouendym());

                itNyknJissekiRireki.setRsgaku(rsgaku);

                itNyknJissekiRireki.setRstuukasyu(nyknJissekiRireki.getRstuukasyu());

                itNyknJissekiRireki.setRyosyukwsratekjymd(nyknJissekiRireki.getRyosyukwsratekjymd());

                itNyknJissekiRireki.setRyosyukwsrate(nyknJissekiRireki.getRyosyukwsrate());

                itNyknJissekiRireki.setHrkp(kykKihon.getHrkp());

                itNyknJissekiRireki.setIktwaribikikgk(iktWaribikikGk);

                itNyknJissekiRireki.setNyksyoriymd(nyknJissekiRireki.getNyksyoriymd());

                itNyknJissekiRireki.setRyosyuymd(nyknJissekiRireki.getRyosyuymd());

                itNyknJissekiRireki.setNykdenno(nyknJissekiRireki.getNykdenno());

                itNyknJissekiRireki.setNykdenymd(nyknJissekiRireki.getNykdenymd());

                itNyknJissekiRireki.setNykkeiro(nyknJissekiRireki.getNykkeiro());

                itNyknJissekiRireki.setHrkkaisuu(nyknJissekiRireki.getHrkkaisuu());

                itNyknJissekiRireki.setJyutoukaisuuy(nyknJissekiRireki.getJyutoukaisuuy());

                itNyknJissekiRireki.setJyutoukaisuum(nyknJissekiRireki.getJyutoukaisuum());

                itNyknJissekiRireki.setNyknaiyoukbn(nyknJissekiRireki.getNyknaiyoukbn());

                itNyknJissekiRireki.setIktnyuukinnumu(nyknJissekiRireki.getIktnyuukinnumu());

                itNyknJissekiRireki.setYenkansantkykwsrateymd(nyknJissekiRireki.getYenkansantkykwsrateymd());

                itNyknJissekiRireki.setYenkansantkykwsrate(nyknJissekiRireki.getYenkansantkykwsrate());

                itNyknJissekiRireki.setHenkousikibetukey(kykSyouhn.getHenkousikibetukey());

                itNyknJissekiRireki.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());

                itNyknJissekiRireki.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());

                itNyknJissekiRireki.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

                itNyknJissekiRireki.setIkkatuyoupkaisuu(nyknJissekiRireki.getIkkatuyoupkaisuu());

                itNyknJissekiRireki.setTikiktbrisyuruikbn(nyknJissekiRireki.getTikiktbrisyuruikbn());

                itNyknJissekiRireki.setCreditkessaiyouno(nyknJissekiRireki.getCreditkessaiyouno());

                BizPropertyInitializer.initialize(itNyknJissekiRireki);

                EditKoujyonaiyouTbl editKoujyonaiyouTb = SWAKInjector.getInstance(EditKoujyonaiyouTbl.class);

                editKoujyonaiyouTb.setIkkatuNyknUmu(nyknJissekiRireki.getIktnyuukinnumu());

                editKoujyonaiyouTb.setNyknJskStartYm(nyknJissekiRireki.getJyutoustartym());

                editKoujyonaiyouTb.setNyknJskEndYm(nyknJissekiRireki.getJyutouendym());

                editKoujyonaiyouTb.setNyknJskRenno(renno);

                editKoujyonaiyouTb.setNyknJskRyosyuYmd(nyknJissekiRireki.getRyosyuymd());

                editKoujyonaiyouTb.setNyknJskJytKaisuuY(nyknJissekiRireki.getJyutoukaisuuy());

                editKoujyonaiyouTb.setNyknJskJytKaisuuM(nyknJissekiRireki.getJyutoukaisuum());

                editKoujyonaiyouTb.setNyknJskRysKwsrate(nyknJissekiRireki.getRyosyukwsrate());

                List<KykSyouhnCommonParam> kykSyouhnCommonParamLst = new ArrayList<>();
                kykSyouhnCommonParamLst.addAll(kykSyouhnLst);
                editKoujyonaiyouTb.setKykSyouhnLst(kykSyouhnCommonParamLst);

                ZennouKoujyogakuKeisanParam zennouKoujyogakuKeisanParam = SWAKInjector
                    .getInstance(ZennouKoujyogakuKeisanParam.class);

                zennouKoujyogakuKeisanParam.setKjsmyouzennoukaisiymd(zennou.getKjsmyouzennoukaisiymd());

                zennouKoujyogakuKeisanParam.setKjsmyouzennoukikanm(zennou.getKjsmyouzennoukikanm());

                zennouKoujyogakuKeisanParam.setKjsmyouzennounyuukinkgk(zennou.getKjsmyouzennounyuukinkgk());

                zennouKoujyogakuKeisanParam.setHrkp(kykKihon.getHrkp());

                zennouKoujyogakuKeisanParam.setHrkkaisuu(kykKihon.getHrkkaisuu());

                zennouKoujyogakuKeisanParam.setZennoukaisiymd(zennou.getZennoukaisiymd());

                zennouKoujyogakuKeisanParam.setZennourenno(zennou.getRenno());

                zennouKoujyogakuKeisanParam.setKjsmyouyenknsnkawaserate(zennou.getKjsmyouyenkansankwsrate());

                editKoujyonaiyouTb.setZennouKoujyogakuKeisanParam(zennouKoujyogakuKeisanParam);
                editKoujyonaiyouTb.exec(pKhozenCommonParam, pSyoNo, C_KjsymnytblhensyuusyoriKbn.NYUUKINHANEI, pSyoriYmd);

            }
        }
        else {
            if (torikesigoJkipjytYm != null) {
                ansyuKihon.setJkipjytym(torikesigoJkipjytYm);

                ansyuKihon.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());

                ansyuKihon.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());

                ansyuKihon.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());
            }
        }
        logger.debug("△ 契約変更時前納充当取消および更新 終了");
    }

    private TorikesiZnnJytInfoOutBean torikesiZnnJytInfo(KhozenCommonParam pKhozenCommonParam,
        IT_KykKihon pKykKihon, BizDate pSyoriYmd, BizDateYM pKaisiYm) {

        List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykHenkoujiZnnJytTrksKsnDao.getNyknJissekiRirekis(pKykKihon, pKaisiYm);

        BizDateYM torikesigoJkipjytYm = null;

        for (IT_NyknJissekiRireki nyknJissekiRireki : nyknJissekiRirekiLst) {

            nyknJissekiRireki.setNyktrksflg(C_Nyktrksflg.TORIKESI);

            nyknJissekiRireki.setNyktrksymd(pSyoriYmd);

            nyknJissekiRireki.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());

            nyknJissekiRireki.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());

            nyknJissekiRireki.setGyoumuKousinTime(BizDate.getSysDateTimeMilli());

            if (torikesigoJkipjytYm == null ||
                BizDateUtil.compareYm(torikesigoJkipjytYm, nyknJissekiRireki.getJyutoustartym()) == BizDateUtil.COMPARE_GREATER) {
                torikesigoJkipjytYm = nyknJissekiRireki.getJyutoustartym();
            }
        }

        TorikesiZnnJytInfoOutBean torikesiZnnJytInfoOutBean = SWAKInjector.getInstance(TorikesiZnnJytInfoOutBean.class);

        torikesiZnnJytInfoOutBean.setTorikesigoJkipjytYm(torikesigoJkipjytYm);

        torikesiZnnJytInfoOutBean.setTorikesigoNyknJissekiRireki(nyknJissekiRirekiLst);

        return torikesiZnnJytInfoOutBean;
    }
}
