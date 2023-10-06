package yuyu.batch.biz.boss.bzkykmeisairendoufsks;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.batch.biz.boss.bzkykmeisairendoufsks.dba.BzkykmeisaiRendouFSksDao;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.common.biz.bzcommon.BzGetAdrData;
import yuyu.common.biz.bzcommon.BzKbnHenkanUtil;
import yuyu.common.biz.bzcommon.GetKawaseRate;
import yuyu.common.biz.bzcommon.KbnInfoBean;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzcommon.SetNenrei;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.biz.interf.ConvBossRnkKoumoku;
import yuyu.common.biz.interf.ConvBossRnkKoumokuBean;
import yuyu.common.hozen.khcommon.HanteiKhSisuurendoTmttknJyoutai;
import yuyu.common.hozen.khcommon.HanteiTmttknJyoutaiBean;
import yuyu.common.hozen.khcommon.HanteiTyotikuseihokenBean;
import yuyu.common.hozen.khcommon.SetOutoubi;
import yuyu.common.hozen.khcommon.SetTyotikuseihokenhyouji;
import yuyu.common.siharai.sicommon.CalcHkShrKngk;
import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.MessageId;
import yuyu.def.classification.C_EigyoubiHoseiKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_KawaserateSyuruiKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_MukouHyj;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_StknsetKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SystemRenkeiHenkanHoukouKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TodouhukenKbn;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TykzentykgoKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KhSisuurendoTmttkn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykSyouhnHnkmae;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_TrkKzk;
import yuyu.def.db.entity.MT_DsKokyakuKeiyaku;
import yuyu.def.db.entity.ZT_KokyakuYuyuKykmeisaiFTy;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.result.bean.KokyakuYuyukykMeisaiFTaisyouDataBean;
import yuyu.def.hozen.result.bean.SisurendoTmttknInfoBean;
import yuyu.def.hozen.sorter.SortIT_NyknJissekiRireki;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.base.Strings;

/**
 * 業務共通 ＢＯＳＳ 普保Ⅱ契約明細連動Ｆ作成
 */
public class BzkykmeisaiRendouFSksBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam batchParam;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private DirectDomManager directDomManager;

    @Inject
    private BzkykmeisaiRendouFSksDao bzkykmeisaiRendouFSksDao;

    @Inject
    private AS_Kinou kinou;

    @Override
    public BatchParam getParam() {
        return batchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        int syoriKensuu = 0;
        BizDate syoriYMD = batchParam.getSyoriYmd();

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW0003),
            syoriYMD.toString()));

        try (
            ExDBResults<KokyakuYuyukykMeisaiFTaisyouDataBean> kokyakuYuyukykMeisaiFTaisyouDataBeanList = hozenDomManager
            .getKokyakuYuyukykMeisaiFTaisyouDataBean();

            EntityInserter<ZT_KokyakuYuyuKykmeisaiFTy> kokyakuYuyuKykmeisaiFTyInserter = new EntityInserter<>();) {

            SortIT_NyknJissekiRireki sortIT_NyknJissekiRireki = SWAKInjector
                .getInstance(SortIT_NyknJissekiRireki.class);
            GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
            KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
            SetNenrei setNenrei = SWAKInjector.getInstance(SetNenrei.class);
            BzGetAdrData bzGetAdrData = SWAKInjector.getInstance(BzGetAdrData.class);
            BzKbnHenkanUtil bzKbnHenkanUtil = SWAKInjector.getInstance(BzKbnHenkanUtil.class);
            CalcHkShrKngk calcHkShrKngk = SWAKInjector.getInstance(CalcHkShrKngk.class);

            for (KokyakuYuyukykMeisaiFTaisyouDataBean kokyakuYuyukykMeisaiFTaisyouDataBean : kokyakuYuyukykMeisaiFTaisyouDataBeanList) {
                IT_KykKihon kykKihon = kokyakuYuyukykMeisaiFTaisyouDataBean.getIT_KykKihon();
                IT_KykSyouhn kykSyouhn = kokyakuYuyukykMeisaiFTaisyouDataBean.getIT_KykSyouhn();
                IT_KykSonotaTkyk kykSonotaTkyk = kokyakuYuyukykMeisaiFTaisyouDataBean.getIT_KykSonotaTkyk();
                IT_HhknSya hhknSya = kokyakuYuyukykMeisaiFTaisyouDataBean.getIT_HhknSya();
                IT_KykSya kykSya = kokyakuYuyukykMeisaiFTaisyouDataBean.getIT_KykSya();

                syoriKensuu++;

                ZT_KokyakuYuyuKykmeisaiFTy kokyakuYuyuKykmeisaiFTy = new ZT_KokyakuYuyuKykmeisaiFTy();

                kokyakuYuyuKykmeisaiFTy.setZtysequenceno(syoriKensuu);
                kokyakuYuyuKykmeisaiFTy.setZtysyono(kykKihon.getSyono().substring(0, 11));
                kokyakuYuyuKykmeisaiFTy.setZtyhrkmnenkansanp(0L);

                int syohinHanteiKbn = SyouhinUtil.hantei(kykSyouhn.getSyouhncd());

                List<IT_NyknJissekiRireki> nyknJissekiRirekiList = kykKihon
                    .getNyknJissekiRirekisByNykkeiro(C_Nykkeiro.SKEI);
                nyknJissekiRirekiList = sortIT_NyknJissekiRireki
                    .OrderIT_NyknJissekiRirekiByPkAsc(nyknJissekiRirekiList);
                IT_NyknJissekiRireki nyknJissekiRireki = nyknJissekiRirekiList.get(0);

                if (C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu())) {
                    kokyakuYuyuKykmeisaiFTy.setZtyyengyousekihosyous(Long.valueOf(kykSyouhn.getKihons().toString()));
                }
                else {
                    if(SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN == syohinHanteiKbn){
                        C_ErrorKbn errorKbn = getKawaseRate.exec(syoriYMD,
                            C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                            kykSyouhn.getKyktuukasyu(),
                            C_Tuukasyu.JPY,
                            C_KawasetekiyoKbn.TTM,
                            C_KawasetsryKbn.SYUKKINRATE,
                            C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                            C_YouhiKbn.HUYOU);

                        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                            throw new CommonBizAppException("為替レート取得に失敗しました。" +
                                "基準日：" + syoriYMD +
                                "　種類区分：" + C_KawaserateSyuruiKbn.KOUJIKAWASERATE +
                                "　元通貨：" + kykSyouhn.getKyktuukasyu() +
                                "　換算通貨：" + C_Tuukasyu.JPY +
                                "　適用区分：" + C_KawasetekiyoKbn.TTM +
                                "　手数料区分：" + C_KawasetsryKbn.SYUKKINRATE +
                                "　営業日補正区分：" + C_EigyoubiHoseiKbn.YOKUEIGYOUBI +
                                "　前営業日為替レート取得要否：" + C_YouhiKbn.HUYOU);
                        }
                    }else{
                        C_ErrorKbn errorKbn = getKawaseRate.exec(nyknJissekiRireki.getRyosyuymd(),
                            C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
                            kykSyouhn.getKyktuukasyu(),
                            C_Tuukasyu.JPY,
                            C_KawasetekiyoKbn.TTM,
                            C_KawasetsryKbn.JISSEIRATE,
                            C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                            C_YouhiKbn.HUYOU);

                        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                            throw new CommonBizAppException("為替レート取得に失敗しました。" +
                                "基準日：" + nyknJissekiRireki.getRyosyuymd() +
                                "　種類区分：" + C_KawaserateSyuruiKbn.PM17JIKAWASERATE +
                                "　元通貨：" + kykSyouhn.getKyktuukasyu() +
                                "　換算通貨：" + C_Tuukasyu.JPY +
                                "　適用区分：" + C_KawasetekiyoKbn.TTM +
                                "　手数料区分：" + C_KawasetsryKbn.JISSEIRATE +
                                "　営業日補正区分：" + C_EigyoubiHoseiKbn.YOKUEIGYOUBI +
                                "　前営業日為替レート取得要否：" + C_YouhiKbn.HUYOU);
                        }
                    }
                    BizCurrency kanzanGaku = keisanGaikakanzan.exec(C_Tuukasyu.JPY, kykSyouhn.getKihons(),
                        getKawaseRate.getKawaserate(), C_HasuusyoriKbn.SSYGNY);

                    kokyakuYuyuKykmeisaiFTy.setZtyyengyousekihosyous(Long.valueOf(kanzanGaku.toString()));
                }

                if (C_UmuKbn.ARI.eq(kykSyouhn.getSyouhnZokusei().getNkhknumu())
                    && C_HknkknsmnKbn.NENMANKI.eq(kykSyouhn.getHknkknsmnkbn())) {

                    kokyakuYuyuKykmeisaiFTy.setZtyhknkkn(Strings.padStart(
                        String.valueOf(setNenrei.getNkshrStartNenrei(kykSyouhn.getHhknnen(), kykSyouhn.getHknkkn())),
                        2, '0'));
                }
                else {
                    kokyakuYuyuKykmeisaiFTy
                    .setZtyhknkkn(Strings.padStart(String.valueOf(kykSyouhn.getHknkkn()), 2, '0'));
                }

                if (C_Kykjyoutai.ITIJIBARAI.eq(kykSyouhn.getKykjyoutai())) {

                    kokyakuYuyuKykmeisaiFTy.setZtyphrkkikn("00");
                }
                else {
                    kokyakuYuyuKykmeisaiFTy
                    .setZtyphrkkikn(Strings.padStart(String.valueOf(kykSyouhn.getHrkkkn()), 2, '0'));
                }

                if (C_UmuKbn.ARI.eq(kykSyouhn.getSyouhnZokusei().getNkhknumu())) {
                    kokyakuYuyuKykmeisaiFTy.setZtysaimnkkykhyj("1");
                }
                else {
                    if (C_HknkknsmnKbn.SAIMANKI.eq(kykSyouhn.getHknkknsmnkbn())) {
                        kokyakuYuyuKykmeisaiFTy.setZtysaimnkkykhyj("1");
                    }
                    else {
                        kokyakuYuyuKykmeisaiFTy.setZtysaimnkkykhyj("0");
                    }
                }

                if (kykSyouhn.getSyoumetuymd() != null) {
                    kokyakuYuyuKykmeisaiFTy.setZtysymtymd(String.valueOf(kykSyouhn.getSyoumetuymd()));
                }
                else {
                    kokyakuYuyuKykmeisaiFTy.setZtysymtymd("00000000");
                }

                kokyakuYuyuKykmeisaiFTy.setZtysyukeiyakukigou(kykSyouhn.getSyouhncd().substring(0, 2));
                kokyakuYuyuKykmeisaiFTy.setZtysykykratesedaikbn(kykSyouhn.getRyouritusdno().substring(0, 1));
                kokyakuYuyuKykmeisaiFTy.setZtyjyudkaigomehrtkarihyj(kykSonotaTkyk.getJyudkaigomeharaitkhukaumu()
                    .getValue());
                kokyakuYuyuKykmeisaiFTy.setZtypmentokuyakukbn("9");
                kokyakuYuyuKykmeisaiFTy.setZtykykdrtkykarihyj(kykSonotaTkyk.getKykdrtkykhukaumu()
                    .getValue());
                kokyakuYuyuKykmeisaiFTy.setZtyyobiv158("");

                if (kykSyouhn.getKykymd() != null) {
                    kokyakuYuyuKykmeisaiFTy.setZtykykymd(String.valueOf(kykSyouhn.getKykymd()));
                }
                else {
                    kokyakuYuyuKykmeisaiFTy.setZtykykymd("00000000");
                }

                if (kykKihon.getBosyuuym() != null) {
                    kokyakuYuyuKykmeisaiFTy.setZtybsyym(String.valueOf(kykKihon.getBosyuuym()));
                }
                else {
                    kokyakuYuyuKykmeisaiFTy.setZtybsyym("000000");
                }

                kokyakuYuyuKykmeisaiFTy.setZtyknkyknm18(kykSya.getKyknmkn());
                kokyakuYuyuKykmeisaiFTy.setZtykjkyknm(kykSya.getKyknmkj());

                if (kykSya.getKykseiymd() != null) {
                    kokyakuYuyuKykmeisaiFTy.setZtykyksyaseiymd(String.valueOf(kykSya.getKykseiymd()));
                }
                else {
                    kokyakuYuyuKykmeisaiFTy.setZtykyksyaseiymd("00000000");
                }

                int ztykyksyanen3;
                if (C_YuukousyoumetuKbn.YUUKOU.eq(kykSyouhn.getYuukousyoumetukbn())) {
                    ztykyksyanen3 = setNenrei.exec(syoriYMD.getBizDateYM().getLastDay(),
                        BizDate.valueOf(kokyakuYuyuKykmeisaiFTy.getZtykyksyaseiymd()));
                }
                else {
                    ztykyksyanen3 = setNenrei.exec(BizDate.valueOf(kokyakuYuyuKykmeisaiFTy.getZtysymtymd()),
                        BizDate.valueOf(kokyakuYuyuKykmeisaiFTy.getZtykyksyaseiymd()));
                }
                kokyakuYuyuKykmeisaiFTy.setZtykyksyanen3(Strings.padStart(String.valueOf(ztykyksyanen3), 3, '0'));

                int ztykykjikyksyanen = setNenrei.exec(BizDate.valueOf(kokyakuYuyuKykmeisaiFTy.getZtykykymd()),
                    BizDate.valueOf(kokyakuYuyuKykmeisaiFTy.getZtykyksyaseiymd()));
                if (ztykykjikyksyanen >= 100) {
                    kokyakuYuyuKykmeisaiFTy.setZtykykjikyksyanen("99");
                }
                else {
                    kokyakuYuyuKykmeisaiFTy.setZtykykjikyksyanen(Strings.padStart(String.valueOf(ztykykjikyksyanen), 2,
                        '0'));
                }

                kokyakuYuyuKykmeisaiFTy.setZtytuusinsakihumeihyj("0");
                kokyakuYuyuKykmeisaiFTy.setZtykihontikucd("");

                bzGetAdrData.execTodouhukenCdByPostalcd(kykSya.getTsinyno());
                KbnInfoBean kbnInfoBean = bzKbnHenkanUtil.convKbn(bzGetAdrData.getTodouhukenCd().getValue(),
                    C_TodouhukenKbn.class, C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER);
                kokyakuYuyuKykmeisaiFTy.setZtytodouhukencd(kbnInfoBean.getKbnData());

                kokyakuYuyuKykmeisaiFTy.setZtysikutyousoncd5("00000");
                kokyakuYuyuKykmeisaiFTy.setZtykjadr62(kykSya.getTsinadr1kj() + kykSya.getTsinadr2kj()
                    + kykSya.getTsinadr3kj());
                kokyakuYuyuKykmeisaiFTy.setZtytelno(kykSya.getTsintelno());
                kokyakuYuyuKykmeisaiFTy.setZtydai2telno(kykSya.getDai2tsintelno());
                kokyakuYuyuKykmeisaiFTy.setZtyknhhknmei(hhknSya.getHhknnmkn());
                kokyakuYuyuKykmeisaiFTy.setZtyknjhhknmei(hhknSya.getHhknnmkj());

                if (hhknSya.getHhknseiymd() != null) {
                    kokyakuYuyuKykmeisaiFTy.setZtyhhknseiymd(String.valueOf(hhknSya.getHhknseiymd()));
                }
                else {
                    kokyakuYuyuKykmeisaiFTy.setZtyhhknseiymd("00000000");
                }

                int ztyhhknnen;
                if (C_YuukousyoumetuKbn.YUUKOU.eq(kykSyouhn.getYuukousyoumetukbn())) {
                    ztyhhknnen = setNenrei.exec(syoriYMD.getBizDateYM().getLastDay(),
                        BizDate.valueOf(kokyakuYuyuKykmeisaiFTy.getZtyhhknseiymd()));
                }
                else {
                    ztyhhknnen = setNenrei.exec(BizDate.valueOf(kokyakuYuyuKykmeisaiFTy.getZtysymtymd()),
                        BizDate.valueOf(kokyakuYuyuKykmeisaiFTy.getZtyhhknseiymd()));
                }
                kokyakuYuyuKykmeisaiFTy.setZtyhhknnen(Strings.padStart(String.valueOf(ztyhhknnen), 3, '0'));

                kokyakuYuyuKykmeisaiFTy.setZtyhhknseikbn(hhknSya.getHhknsei().getValue());

                if (kykSyouhn.getHhknnen() >= 100) {
                    kokyakuYuyuKykmeisaiFTy.setZtykykjihhknnen("99");
                }
                else {
                    kokyakuYuyuKykmeisaiFTy.setZtykykjihhknnen(Strings.padStart(String.valueOf(kykSyouhn.getHhknnen()),
                        2, '0'));
                }

                kokyakuYuyuKykmeisaiFTy.setZtymannenreikykhyj("1");

                if (C_Tdk.HONNIN.eq(kykSya.getKkkyktdk())) {
                    kokyakuYuyuKykmeisaiFTy.setZtykyksyhhknsydouituhyouji("1");
                }
                else {
                    kokyakuYuyuKykmeisaiFTy.setZtykyksyhhknsydouituhyouji("0");
                }

                if (C_YuukousyoumetuKbn.YUUKOU.eq(kykSyouhn.getYuukousyoumetukbn())) {
                    kokyakuYuyuKykmeisaiFTy.setZtykykjyutikbn("1");
                }
                else {
                    if (C_Syoumetujiyuu.KAIYAKU.eq(kykSyouhn.getSyoumetujiyuu())) {
                        kokyakuYuyuKykmeisaiFTy.setZtykykjyutikbn("3");
                    }
                    else if(C_Syoumetujiyuu.PMNYSYMET_JDSKN_SSNZM.eq(kykSyouhn.getSyoumetujiyuu()) ||
                        C_Syoumetujiyuu.PMNYSYMET_MSSN.eq(kykSyouhn.getSyoumetujiyuu()) ||
                        C_Syoumetujiyuu.PMNYSYMET_JDSKNGAI_SSNZM.eq(kykSyouhn.getSyoumetujiyuu()) ){
                        kokyakuYuyuKykmeisaiFTy.setZtykykjyutikbn("2");
                    }
                    else {
                        kokyakuYuyuKykmeisaiFTy.setZtykykjyutikbn("4");
                    }
                }

                if (C_Kykjyoutai.ITIJIBARAI.eq(kykSyouhn.getKykjyoutai())) {
                    kokyakuYuyuKykmeisaiFTy.setZtyannaifuyouriyuukbn("01");
                }
                else {
                    if (C_YuukousyoumetuKbn.YUUKOU.eq(kykSyouhn.getYuukousyoumetukbn())) {

                        kbnInfoBean = bzKbnHenkanUtil.convKbn(kykSyouhn.getKykjyoutai().getValue(),
                            C_Kykjyoutai.class, C_SystemRenkeiHenkanHoukouKbn.RAY_TO_OTHER);
                        kokyakuYuyuKykmeisaiFTy.setZtyannaifuyouriyuukbn(kbnInfoBean.getKbnData());
                    }
                    else {
                        kokyakuYuyuKykmeisaiFTy.setZtyannaifuyouriyuukbn("00");
                    }
                }

                if (C_YuukousyoumetuKbn.YUUKOU.eq(kykSyouhn.getYuukousyoumetukbn())) {
                    kokyakuYuyuKykmeisaiFTy.setZtysyoumetucd("0000");
                }
                else {
                    if (C_Syoumetujiyuu.KYKTORIKESI.eq(kykSyouhn.getSyoumetujiyuu())
                        || C_Syoumetujiyuu.CLGOFF.eq(kykSyouhn.getSyoumetujiyuu())
                        || C_Syoumetujiyuu.MUKOU.eq(kykSyouhn.getSyoumetujiyuu())) {
                        kokyakuYuyuKykmeisaiFTy.setZtysyoumetucd("0350");
                    }
                    else if (C_Syoumetujiyuu.KAIJO.eq(kykSyouhn.getSyoumetujiyuu())) {
                        kokyakuYuyuKykmeisaiFTy.setZtysyoumetucd("0351");
                    }
                    else if (C_Syoumetujiyuu.SIBOU.eq(kykSyouhn.getSyoumetujiyuu())) {
                        kokyakuYuyuKykmeisaiFTy.setZtysyoumetucd("3090");
                    }
                    else if (C_Syoumetujiyuu.SIBOUKYUUHUKINSHR.eq(kykSyouhn.getSyoumetujiyuu())) {
                        kokyakuYuyuKykmeisaiFTy.setZtysyoumetucd("3091");
                    }
                    else if (C_Syoumetujiyuu.SIBOUSAIGAIHIGAITOU.eq(kykSyouhn.getSyoumetujiyuu())) {
                        kokyakuYuyuKykmeisaiFTy.setZtysyoumetucd("3092");
                    }
                    else if (C_Syoumetujiyuu.SIBOUSAIGAIMENSEKI.eq(kykSyouhn.getSyoumetujiyuu())) {
                        kokyakuYuyuKykmeisaiFTy.setZtysyoumetucd("3093");
                    }
                    else if (C_Syoumetujiyuu.KOUDOSYOUGAI.eq(kykSyouhn.getSyoumetujiyuu())) {
                        kokyakuYuyuKykmeisaiFTy.setZtysyoumetucd("3120");
                    }
                    else if (C_Syoumetujiyuu.SBKAIJO.eq(kykSyouhn.getSyoumetujiyuu())) {
                        kokyakuYuyuKykmeisaiFTy.setZtysyoumetucd("3250");
                    }
                    else if (C_Syoumetujiyuu.MENSEKI.eq(kykSyouhn.getSyoumetujiyuu())) {
                        kokyakuYuyuKykmeisaiFTy.setZtysyoumetucd("3251");
                    }
                    else if (C_Syoumetujiyuu.SBMUKOU.eq(kykSyouhn.getSyoumetujiyuu())) {
                        kokyakuYuyuKykmeisaiFTy.setZtysyoumetucd("3252");
                    }
                    else if (C_Syoumetujiyuu.KAIYAKU.eq(kykSyouhn.getSyoumetujiyuu())) {
                        kokyakuYuyuKykmeisaiFTy.setZtysyoumetucd("5010");
                    }
                    else if (C_Syoumetujiyuu.PMNYSYMET_JDSKN_SSNZM.eq(kykSyouhn.getSyoumetujiyuu())
                        || C_Syoumetujiyuu.PMNYSYMET_JDSKNGAI_SSNZM.eq(kykSyouhn.getSyoumetujiyuu())) {
                        kokyakuYuyuKykmeisaiFTy.setZtysyoumetucd("5011");
                    }
                    else if (C_Syoumetujiyuu.PMNYSYMET_MSSN.eq(kykSyouhn.getSyoumetujiyuu())) {
                        kokyakuYuyuKykmeisaiFTy.setZtysyoumetucd("6020");
                    }
                    else if (C_Syoumetujiyuu.JIKOU.eq(kykSyouhn.getSyoumetujiyuu())) {
                        kokyakuYuyuKykmeisaiFTy.setZtysyoumetucd("0100");
                    }
                    else {
                        kokyakuYuyuKykmeisaiFTy.setZtysyoumetucd("");
                    }
                }

                if (kykSyouhn.getKykymd() != null) {
                    kokyakuYuyuKykmeisaiFTy.setZtytorihikikaisiymd(String.valueOf(kykSyouhn.getKykymd()));
                } else {
                    kokyakuYuyuKykmeisaiFTy.setZtytorihikikaisiymd("00000000");
                }

                kokyakuYuyuKykmeisaiFTy.setZtypowerfulhyj("0");
                kokyakuYuyuKykmeisaiFTy.setZtylargehyj("0");

                ConvBossRnkKoumoku convBossRnkKoumoku = SWAKInjector.getInstance(ConvBossRnkKoumoku.class);
                ConvBossRnkKoumokuBean convBossRnkKoumokuBean = convBossRnkKoumoku.execAll(
                    kykSyouhn.getSyouhnZokusei(),
                    kykKihon.getHrkkeiro(),
                    kykSyouhn.getKyktuukasyu());

                kokyakuYuyuKykmeisaiFTy.setZtysyouhinbunruikbn(convBossRnkKoumokuBean.getSyouhinBunruiKbn());
                if (BizUtil.isBlank(kokyakuYuyuKykmeisaiFTy.getZtysyouhinbunruikbn())){
                    kokyakuYuyuKykmeisaiFTy.setZtysyouhinbunruikbn("0");
                }

                kokyakuYuyuKykmeisaiFTy.setZtysyouhnnmkbn(convBossRnkKoumokuBean.getSyouhnNmKbn());
                if (BizUtil.isBlank(kokyakuYuyuKykmeisaiFTy.getZtysyouhnnmkbn())){
                    kokyakuYuyuKykmeisaiFTy.setZtysyouhnnmkbn("00");
                }

                kokyakuYuyuKykmeisaiFTy.setZtyhknnmcd(kykSyouhn.getSyouhncd().substring(0, 2));
                kokyakuYuyuKykmeisaiFTy.setZtytkbthsyukiknmanryouym("000000");
                kokyakuYuyuKykmeisaiFTy.setZtyldownym("000000");
                kokyakuYuyuKykmeisaiFTy.setZtyhrkmanryouym("000000");
                kokyakuYuyuKykmeisaiFTy.setZtymankiym("000000");

                IT_KykSyouhnHnkmae kykSyouhnHnkmae = bzkykmeisaiRendouFSksDao.getKykSyouhnHnkmaeBySyono(kykKihon
                    .getSyono());

                if (syohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
                    kokyakuYuyuKykmeisaiFTy.setZtysykykyoteiriritu(BizNumber.valueOf(0));

                }
                else {
                    if (kykSyouhn.getYendthnkymd() != null) {
                        kokyakuYuyuKykmeisaiFTy.setZtysykykyoteiriritu(BizNumber.valueOf(Double.valueOf(BizNumber.valueOf(100).
                            multiply(kykSyouhnHnkmae.getYoteiriritu()).toString())));
                    }
                    else {
                        kokyakuYuyuKykmeisaiFTy.setZtysykykyoteiriritu(BizNumber.valueOf(Double.valueOf(BizNumber.valueOf(100).
                            multiply(kykSyouhn.getYoteiriritu()).toString())));
                    }
                }

                kokyakuYuyuKykmeisaiFTy.setZtyrserieshyj("1");
                kokyakuYuyuKykmeisaiFTy.setZtyduketorihouhoukbn(kykKihon.getHaitoukinuketorihoukbn().getValue());
                kokyakuYuyuKykmeisaiFTy.setZtynaimitukykhyj("0");
                kokyakuYuyuKykmeisaiFTy.setZtymrarihyj("0");
                kokyakuYuyuKykmeisaiFTy.setZtykasitukenaimituhyj("0");

                List<C_TtdktyuuiKbn> ttdktyuuiKbnList = new ArrayList<>();
                int ttdktyuuiKbnYuukouSuu = 0;
                if (kykKihon.getKhTtdkTyuui() != null) {
                    ttdktyuuiKbnList.add(kykKihon.getKhTtdkTyuui().getTtdktyuuikbn1());
                    ttdktyuuiKbnList.add(kykKihon.getKhTtdkTyuui().getTtdktyuuikbn2());
                    ttdktyuuiKbnList.add(kykKihon.getKhTtdkTyuui().getTtdktyuuikbn3());
                    ttdktyuuiKbnList.add(kykKihon.getKhTtdkTyuui().getTtdktyuuikbn4());
                    ttdktyuuiKbnList.add(kykKihon.getKhTtdkTyuui().getTtdktyuuikbn5());
                }
                for (C_TtdktyuuiKbn ttdktyuuiKbn : ttdktyuuiKbnList) {
                    if (!C_TtdktyuuiKbn.BLNK.eq(ttdktyuuiKbn)) {
                        ttdktyuuiKbnYuukouSuu++;
                    }
                }
                if (ttdktyuuiKbnYuukouSuu > 0) {
                    kokyakuYuyuKykmeisaiFTy.setZtyttdktyuuiarihyj("1");
                }
                else {
                    kokyakuYuyuKykmeisaiFTy.setZtyttdktyuuiarihyj("0");
                }

                kokyakuYuyuKykmeisaiFTy.setZtyttdktyuuisetkacd1("000");
                kokyakuYuyuKykmeisaiFTy.setZtyttdktyuuisetymd1("00000000");
                kokyakuYuyuKykmeisaiFTy.setZtyttdktyuuisetkbn1("00");
                kokyakuYuyuKykmeisaiFTy.setZtyttdktyuuisetkacd2("000");
                kokyakuYuyuKykmeisaiFTy.setZtyttdktyuuisetymd2("00000000");
                kokyakuYuyuKykmeisaiFTy.setZtyttdktyuuisetkbn2("00");

                if (ttdktyuuiKbnYuukouSuu >= 3) {
                    kokyakuYuyuKykmeisaiFTy.setZtyttdktyuui3kenijyouhyj("1");
                }
                else {
                    kokyakuYuyuKykmeisaiFTy.setZtyttdktyuui3kenijyouhyj("0");
                }

                kokyakuYuyuKykmeisaiFTy.setZtysentakujyouhouarihyouji("0");

                if (C_StknsetKbn.ARI.eq(kykKihon.getStknsetkbn())) {
                    kokyakuYuyuKykmeisaiFTy.setZtystknsetkykhyj("1");
                }
                else {
                    kokyakuYuyuKykmeisaiFTy.setZtystknsetkykhyj("0");
                }

                if ("1".equals(kokyakuYuyuKykmeisaiFTy.getZtyjyudkaigomehrtkarihyj()) ||
                    "1".equals(kokyakuYuyuKykmeisaiFTy.getZtyttdktyuuiarihyj()) ||
                    "1".equals(kokyakuYuyuKykmeisaiFTy.getZtystknsetkykhyj())) {
                    kokyakuYuyuKykmeisaiFTy.setZtyinfoteikyoutsghyj("1");
                }
                else {
                    kokyakuYuyuKykmeisaiFTy.setZtyinfoteikyoutsghyj("0");
                }

                if (C_Tuukasyu.JPY.eq(nyknJissekiRireki.getRstuukasyu())) {
                    kokyakuYuyuKykmeisaiFTy.setZtyyenharaikomip(Long.valueOf(nyknJissekiRireki.getRsgaku().toString()));
                }
                else {
                    C_ErrorKbn errorKbn = getKawaseRate.exec(nyknJissekiRireki.getRyosyuymd(),
                        C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
                        nyknJissekiRireki.getRstuukasyu(),
                        C_Tuukasyu.JPY,
                        C_KawasetekiyoKbn.TTM,
                        C_KawasetsryKbn.JISSEIRATE,
                        C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                        C_YouhiKbn.HUYOU);

                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                        throw new CommonBizAppException("為替レート取得に失敗しました。" +
                            "基準日：" + nyknJissekiRireki.getRyosyuymd() +
                            "　種類区分：" + C_KawaserateSyuruiKbn.PM17JIKAWASERATE +
                            "　元通貨：" + nyknJissekiRireki.getRstuukasyu() +
                            "　換算通貨：" + C_Tuukasyu.JPY +
                            "　適用区分：" + C_KawasetekiyoKbn.TTM +
                            "　手数料区分：" + C_KawasetsryKbn.JISSEIRATE +
                            "　営業日補正区分：" + C_EigyoubiHoseiKbn.YOKUEIGYOUBI +
                            "　前営業日為替レート取得要否：" + C_YouhiKbn.HUYOU);
                    }

                    BizCurrency kanzanGaku = keisanGaikakanzan.exec(C_Tuukasyu.JPY, nyknJissekiRireki.getRsgaku(),
                        getKawaseRate.getKawaserate(), C_HasuusyoriKbn.SSYGNY);

                    kokyakuYuyuKykmeisaiFTy.setZtyyenharaikomip(Long.valueOf(kanzanGaku.toString()));
                }

                kokyakuYuyuKykmeisaiFTy.setZtyyenkihons(kokyakuYuyuKykmeisaiFTy.getZtyyengyousekihosyous());

                BizDate tmmsmhneiKiJyunYmd = null;

                C_UmuKbn tumimasiMihanei = C_UmuKbn.NONE;

                if (syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR ||
                    syohinHanteiKbn == SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20) {
                    if (kykSyouhn.getYendthnkymd() == null &&
                        (BizDateUtil.compareYmd(kykSyouhn.getKykymd(), syoriYMD) == BizDateUtil.COMPARE_LESSER ||
                        BizDateUtil.compareYmd(kykSyouhn.getKykymd(), syoriYMD) == BizDateUtil.COMPARE_EQUAL)) {

                        HanteiKhSisuurendoTmttknJyoutai hanteiKhSisuurendoTmttknJyoutai =
                            SWAKInjector.getInstance(HanteiKhSisuurendoTmttknJyoutai.class);

                        HanteiTmttknJyoutaiBean hanteiTmttknJyoutaiBean = SWAKInjector.getInstance(HanteiTmttknJyoutaiBean.class);
                        hanteiTmttknJyoutaiBean.setSyono(kykKihon.getSyono());
                        hanteiTmttknJyoutaiBean.setHanteiKijyunymd(syoriYMD);
                        hanteiTmttknJyoutaiBean.setKykymd(kykSyouhn.getKykymd());

                        boolean result = hanteiKhSisuurendoTmttknJyoutai.execChokuzenOutouymTmttknHantei(hanteiTmttknJyoutaiBean);

                        if (!result) {
                            tumimasiMihanei = C_UmuKbn.ARI;

                            SisurendoTmttknInfoBean sisurendoTmttknInfoBean = hozenDomManager.getSisurendoTmttknInfoBean(kykKihon.getSyono(), syoriYMD);

                            if (sisurendoTmttknInfoBean == null) {

                                throw new CommonBizAppException(MessageUtil.getMessage(MessageId.EIA1048,
                                    IT_KhSisuurendoTmttkn.TABLE_NAME, kykKihon.getSyono() + "　計算基準日：" + syoriYMD));
                            }

                            SetOutoubi setOutoubi = SWAKInjector.getInstance(SetOutoubi.class);

                            tmmsmhneiKiJyunYmd = setOutoubi.exec(
                                C_TykzentykgoKbn.TYKGO,
                                kykSyouhn.getKykymd(),
                                C_Hrkkaisuu.NEN,
                                BizDate.valueOf(sisurendoTmttknInfoBean.getTmttknTaisyouYM(), kykSyouhn.getKykymd().getDay()).getRekijyou()
                                ).getPreviousDay();

                        }
                    }
                }

                BizDate kijunYMD = syoriYMD;

                if(C_UmuKbn.ARI.eq(tumimasiMihanei)){

                    kijunYMD = tmmsmhneiKiJyunYmd;
                }
                else {
                    if (kykSyouhn.getYendthnkymd() != null) {
                        if (BizDateUtil.compareYmd(syoriYMD, kykSyouhn.getYendthnkymd()) == BizDateUtil.COMPARE_LESSER) {
                            kijunYMD = kykSyouhn.getYendthnkymd();
                        }
                    }
                    else {
                        if (kykSyouhn.getTmttknitenymd() != null && BizDateUtil.compareYmd(syoriYMD, kykSyouhn.getTmttknitenymd()) == BizDateUtil.COMPARE_LESSER) {
                            kijunYMD = kykSyouhn.getTmttknitenymd();
                        }
                    }
                }

                C_ErrorKbn calcHkErrorKbn = calcHkShrKngk.execByKeisanWExt(
                    kykKihon.getSyono(),
                    kijunYMD,
                    C_SiinKbn.SP,
                    C_HokenkinsyuruiKbn.SBHOKENKIN,
                    kykKihon.getSdpdkbn(),
                    kykKihon.getHrkkeiro());

                if (C_ErrorKbn.ERROR.eq(calcHkErrorKbn)) {
                    throw new CommonBizAppException("保険金額の取得に失敗しました。証券番号：" + kykKihon.getSyono());
                }

                if (!C_Tuukasyu.JPY.eq(kykSyouhn.getKyktuukasyu())) {

                    if (C_Kykjyoutai.ITIJIBARAI.eq(kykSyouhn.getKykjyoutai())) {

                        C_ErrorKbn errorKbn = getKawaseRate.exec(nyknJissekiRireki.getRyosyuymd(),
                            C_KawaserateSyuruiKbn.PM17JIKAWASERATE,
                            kykSyouhn.getKyktuukasyu(),
                            C_Tuukasyu.JPY,
                            C_KawasetekiyoKbn.TTM,
                            C_KawasetsryKbn.JISSEIRATE,
                            C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                            C_YouhiKbn.HUYOU);

                        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                            throw new CommonBizAppException("為替レート取得に失敗しました。" +
                                "基準日：" + nyknJissekiRireki.getRyosyuymd() +
                                "　種類区分：" + C_KawaserateSyuruiKbn.PM17JIKAWASERATE +
                                "　元通貨：" + kykSyouhn.getKyktuukasyu() +
                                "　換算通貨：" + C_Tuukasyu.JPY +
                                "　適用区分：" + C_KawasetekiyoKbn.TTM +
                                "　手数料区分：" + C_KawasetsryKbn.JISSEIRATE +
                                "　営業日補正区分：" + C_EigyoubiHoseiKbn.YOKUEIGYOUBI +
                                "　前営業日為替レート取得要否：" + C_YouhiKbn.HUYOU);
                        }

                    }
                    else {
                        C_ErrorKbn errorKbn = getKawaseRate.exec(syoriYMD,
                            C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                            kykSyouhn.getKyktuukasyu(),
                            C_Tuukasyu.JPY,
                            C_KawasetekiyoKbn.TTM,
                            C_KawasetsryKbn.SYUKKINRATE,
                            C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                            C_YouhiKbn.HUYOU);

                        if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                            throw new CommonBizAppException("為替レート取得に失敗しました。" +
                                "基準日：" + syoriYMD +
                                "　種類区分：" + C_KawaserateSyuruiKbn.KOUJIKAWASERATE +
                                "　元通貨：" + kykSyouhn.getKyktuukasyu() +
                                "　換算通貨：" + C_Tuukasyu.JPY +
                                "　適用区分：" + C_KawasetekiyoKbn.TTM +
                                "　手数料区分：" + C_KawasetsryKbn.SYUKKINRATE +
                                "　営業日補正区分：" + C_EigyoubiHoseiKbn.YOKUEIGYOUBI +
                                "　前営業日為替レート取得要否：" + C_YouhiKbn.HUYOU);
                        }
                    }

                    BizCurrency kanzanGaku = keisanGaikakanzan.exec(C_Tuukasyu.JPY,
                        calcHkShrKngk.getCalcHkShrKngkBean().getSibousGk(),
                        getKawaseRate.getKawaserate(),
                        C_HasuusyoriKbn.SSYGNY);

                    kokyakuYuyuKykmeisaiFTy.setZtyyensibous(Long.valueOf(kanzanGaku.toString()));
                }
                else {
                    kokyakuYuyuKykmeisaiFTy.setZtyyensibous(Long.valueOf(calcHkShrKngk.getCalcHkShrKngkBean()
                        .getSibousGk().toString()));
                }

                if (C_Hrkkaisuu.ITIJI.eq(kykKihon.getHrkkaisuu())) {
                    kokyakuYuyuKykmeisaiFTy.setZtyhrkhuhukbn("4");
                }
                else if(C_Hrkkaisuu.NEN.eq(kykKihon.getHrkkaisuu())){
                    kokyakuYuyuKykmeisaiFTy.setZtyhrkhuhukbn("1");
                }
                else if(C_Hrkkaisuu.HALFY.eq(kykKihon.getHrkkaisuu())){
                    kokyakuYuyuKykmeisaiFTy.setZtyhrkhuhukbn("2");
                }
                else {
                    kokyakuYuyuKykmeisaiFTy.setZtyhrkhuhukbn("3");
                }

                kokyakuYuyuKykmeisaiFTy.setZtysyuunoukeirokbn(convBossRnkKoumokuBean.getSyuunouKeiroKbn());

                kokyakuYuyuKykmeisaiFTy.setZtycalckijyunymd(syoriYMD.toString());
                kokyakuYuyuKykmeisaiFTy.setZtytumitatedzndk(0L);

                if (C_YuukousyoumetuKbn.SYOUMETU.eq(kykSyouhn.getYuukousyoumetukbn())) {
                    kokyakuYuyuKykmeisaiFTy.setZtytumitatedzndkhunouhyj("1");
                }
                else {
                    kokyakuYuyuKykmeisaiFTy.setZtytumitatedzndkhunouhyj("0");
                }

                kokyakuYuyuKykmeisaiFTy.setZtydairitenatkihyj("1");
                kokyakuYuyuKykmeisaiFTy.setZtytantou1sisyacd("0000000");
                kokyakuYuyuKykmeisaiFTy.setZtytantou1sibucd("0000000");
                kokyakuYuyuKykmeisaiFTy.setZtytantou1kojincd("000000");
                kokyakuYuyuKykmeisaiFTy.setZtytantou1tantoukaisiymd("000000");
                kokyakuYuyuKykmeisaiFTy.setZtytantou1tantousyakbn("");
                kokyakuYuyuKykmeisaiFTy.setZtytantou2sisyacd("0000000");
                kokyakuYuyuKykmeisaiFTy.setZtytantou2sibucd("0000000");
                kokyakuYuyuKykmeisaiFTy.setZtytantou2kojincd("000000");
                kokyakuYuyuKykmeisaiFTy.setZtytantou2tantoukaisiymd("000000");
                kokyakuYuyuKykmeisaiFTy.setZtytantou2tantousyakbn("");
                kokyakuYuyuKykmeisaiFTy.setZtysikijikbn("0");
                kokyakuYuyuKykmeisaiFTy.setZtyteikyou1sosikicd("0000000");
                kokyakuYuyuKykmeisaiFTy.setZtyteikyou1kojincd("000000");
                kokyakuYuyuKykmeisaiFTy.setZtyteikyou1tantoukbn("");
                kokyakuYuyuKykmeisaiFTy.setZtyteikyou2sosikicd("0000000");
                kokyakuYuyuKykmeisaiFTy.setZtyteikyou2kojincd("000000");
                kokyakuYuyuKykmeisaiFTy.setZtyteikyou2tantoukbn("");
                kokyakuYuyuKykmeisaiFTy.setZtyadrsyokansisyacd("0000000");
                kokyakuYuyuKykmeisaiFTy.setZtyhyukjsaki1sosikicd("0000000");
                kokyakuYuyuKykmeisaiFTy.setZtyhyukjsaki1kojincd("000000");
                kokyakuYuyuKykmeisaiFTy.setZtyhyukjsaki1tantoukbn("");
                kokyakuYuyuKykmeisaiFTy.setZtyhyukjsaki2sosikicd("0000000");
                kokyakuYuyuKykmeisaiFTy.setZtyhyukjsaki2kojincd("000000");
                kokyakuYuyuKykmeisaiFTy.setZtyhyukjsaki2tantoukbn("");
                kokyakuYuyuKykmeisaiFTy.setZtyinfotysytymd(syoriYMD.toString());
                kokyakuYuyuKykmeisaiFTy.setZtystdairiseikyuutkykarihyj(kykSonotaTkyk.getStdrsktkyhkumu().getValue());

                String wkZtyhouteityotikuhknhyj = "";
                HanteiTyotikuseihokenBean hanteiTyotikuseihokenBean = SWAKInjector.getInstance(HanteiTyotikuseihokenBean.class);
                hanteiTyotikuseihokenBean.setSyouhnCd(kykSyouhn.getSyouhncd());
                hanteiTyotikuseihokenBean.setSyouhnsdNo(kykSyouhn.getSyouhnsdno());
                hanteiTyotikuseihokenBean.setHrkkaisuu(kykKihon.getHrkkaisuu());
                hanteiTyotikuseihokenBean.setHrkkeiro(kykKihon.getHrkkeiro());

                SetTyotikuseihokenhyouji setTyotikuseihokenhyouji = SWAKInjector.getInstance(SetTyotikuseihokenhyouji.class);
                C_ErrorKbn errorKbn = setTyotikuseihokenhyouji.hanteiTyotikuseihoken(hanteiTyotikuseihokenBean);
                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                    throw new CommonBizAppException("貯蓄性保険判定結果の取得に失敗しました。証券番号：" + kykKihon.getSyono());
                }
                wkZtyhouteityotikuhknhyj = setTyotikuseihokenhyouji.getHouteityotkhknhyj().getValue();

                kokyakuYuyuKykmeisaiFTy.setZtyhouteityotikuhknhyj(wkZtyhouteityotikuhknhyj);

                List<MT_DsKokyakuKeiyaku> dsKokyakuKeiyakuList = directDomManager.getDsKokyakuKeiyakusBySyono(kykKihon
                    .getSyono());
                if (dsKokyakuKeiyakuList.size() > 0){
                    if (C_YuukousyoumetuKbn.YUUKOU.eq(kykSyouhn.getYuukousyoumetukbn()) &&
                        C_MukouHyj.BLANK.eq(dsKokyakuKeiyakuList.get(0).getDskykmukouhyj())) {
                        kokyakuYuyuKykmeisaiFTy.setZtydrctservicekbn("1");
                    }
                    else {
                        kokyakuYuyuKykmeisaiFTy.setZtydrctservicekbn("0");
                    }
                }
                else {
                    kokyakuYuyuKykmeisaiFTy.setZtydrctservicekbn("0");
                }

                kokyakuYuyuKykmeisaiFTy.setZtyhksuhngktkbtknjgnkbn("");

                if (kykSyouhn.getYendthnkymd() != null) {

                    if (C_Tuukasyu.USD.eq(kykSyouhnHnkmae.getKyktuukasyu())) {

                        kokyakuYuyuKykmeisaiFTy.setZtysiteituukakbn("1");
                    }
                    else if (C_Tuukasyu.AUD.eq(kykSyouhnHnkmae.getKyktuukasyu())) {

                        kokyakuYuyuKykmeisaiFTy.setZtysiteituukakbn("2");
                    }
                    else {
                        kokyakuYuyuKykmeisaiFTy.setZtysiteituukakbn("0");
                    }
                }
                else {
                    if (C_Tuukasyu.USD.eq(kykSyouhn.getKyktuukasyu())) {

                        kokyakuYuyuKykmeisaiFTy.setZtysiteituukakbn("1");
                    }
                    else if (C_Tuukasyu.AUD.eq(kykSyouhn.getKyktuukasyu())) {

                        kokyakuYuyuKykmeisaiFTy.setZtysiteituukakbn("2");
                    }
                    else {
                        kokyakuYuyuKykmeisaiFTy.setZtysiteituukakbn("0");
                    }
                }

                if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getTargettkhkumu())) {

                    kokyakuYuyuKykmeisaiFTy.setZtymkhyouyenhknhentkarihyj("1");
                }
                else {
                    kokyakuYuyuKykmeisaiFTy.setZtymkhyouyenhknhentkarihyj("0");
                }

                kokyakuYuyuKykmeisaiFTy.setZtyyenkhrikmtkarihyj(kykSonotaTkyk.getYennykntkhkumu().getValue());
                kokyakuYuyuKykmeisaiFTy.setZtystigihrikmtkarihyj(kykSonotaTkyk.getGaikanykntkhkumu().getValue());
                kokyakuYuyuKykmeisaiFTy.setZtyyenshrgksitihsyutkhyj(kykSonotaTkyk.getInitsbjiyensitihsytkhukaumu()
                    .getValue());

                if (syohinHanteiKbn == SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN) {
                    BizDate kwsratekjymd = syoriYMD.addMonths(-1).getRekijyou().getBizDateYM().getLastDay();

                    errorKbn = getKawaseRate.exec(kwsratekjymd,
                        C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
                        kykSyouhn.getKyktuukasyu(),
                        C_Tuukasyu.JPY,
                        C_KawasetekiyoKbn.TTM,
                        C_KawasetsryKbn.NYUKINRATE,
                        C_EigyoubiHoseiKbn.YOKUEIGYOUBI,
                        C_YouhiKbn.HUYOU);

                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                        throw new CommonBizAppException("為替レート取得に失敗しました。" +
                            "基準日：" + kwsratekjymd +
                            "　種類区分：" + C_KawaserateSyuruiKbn.KOUJIKAWASERATE +
                            "　元通貨：" + kykSyouhn.getKyktuukasyu() +
                            "　換算通貨：" + C_Tuukasyu.JPY +
                            "　適用区分：" + C_KawasetekiyoKbn.TTM +
                            "　手数料区分：" + C_KawasetsryKbn.NYUKINRATE +
                            "　営業日補正区分：" + C_EigyoubiHoseiKbn.YOKUEIGYOUBI +
                            "　前営業日為替レート取得要否：" + C_YouhiKbn.HUYOU);
                    }

                    BizCurrency kanzanGaku = keisanGaikakanzan.execDivide(
                        kykSyouhn.getKyktuukasyu(),
                        nyknJissekiRireki.getRsgaku(),
                        getKawaseRate.getKawaserate(),
                        C_HasuusyoriKbn.SSYGNY);

                    kokyakuYuyuKykmeisaiFTy.setZtysiteituukaharaikomip(BizNumber.valueOf(new BigDecimal(kanzanGaku.toString())));
                }
                else {
                    if (kykSyouhn.getYendthnkymd() != null) {

                        kokyakuYuyuKykmeisaiFTy.setZtysiteituukaharaikomip(
                            BizNumber.valueOf(new BigDecimal(kykSyouhnHnkmae.getHokenryou().toString())));
                    }
                    else {
                        kokyakuYuyuKykmeisaiFTy.setZtysiteituukaharaikomip(
                            BizNumber.valueOf(new BigDecimal(kykSyouhn.getHokenryou().toString())));
                    }
                }

                kokyakuYuyuKykmeisaiFTy.setZtyhrktuukaharaikomip(Long.valueOf(BizNumber.valueOf(
                    new BigDecimal(nyknJissekiRireki.getRsgaku().toString())).round(0, RoundingMode.DOWN).toString()));
                kokyakuYuyuKykmeisaiFTy.setZtysiteituukakihonsx2(
                    BizNumber.valueOf(new BigDecimal(kykSyouhn.getKihons().toString())));
                kokyakuYuyuKykmeisaiFTy.setZtysiteituukasibous(
                    BizNumber.valueOf(new BigDecimal(calcHkShrKngk.getCalcHkShrKngkBean().getSibousGk().toString())));
                kokyakuYuyuKykmeisaiFTy.setZtyteikisiharaiarihyj(kykSonotaTkyk.getTeikishrtkykhukaumu()
                    .getValue());
                kokyakuYuyuKykmeisaiFTy.setZtyyenteikishrkngk(0L);
                kokyakuYuyuKykmeisaiFTy.setZtysiteituukateikishrkngk(BizNumber.valueOf(0));
                kokyakuYuyuKykmeisaiFTy.setZtyyobiv98("");
                kokyakuYuyuKykmeisaiFTy.setZtyyenkihonhijynbris(0L);
                kokyakuYuyuKykmeisaiFTy.setZtyyenkihonitijibarais(0L);
                kokyakuYuyuKykmeisaiFTy.setZtyyenkihonhijynbrip(0L);
                kokyakuYuyuKykmeisaiFTy.setZtyyenkihonitijibaraip(0L);

                String wkZtytrkkzk1trkarihyj = "0";
                String wkZtytrkkzk2trkarihyj = "0";

                List<IT_TrkKzk> itTrkKzkList = kykKihon.getTrkKzks();

                for (IT_TrkKzk itTrkKzk : itTrkKzkList) {
                    if (C_TrkKzkKbn.TRKKZK1.eq(itTrkKzk.getTrkkzkkbn())){
                        wkZtytrkkzk1trkarihyj = "1";
                    }
                    if (C_TrkKzkKbn.TRKKZK2.eq(itTrkKzk.getTrkkzkkbn())){
                        wkZtytrkkzk2trkarihyj = "1";
                    }
                }

                kokyakuYuyuKykmeisaiFTy.setZtytrkkzk1trkarihyj(wkZtytrkkzk1trkarihyj);
                kokyakuYuyuKykmeisaiFTy.setZtytrkkzk2trkarihyj(wkZtytrkkzk2trkarihyj);

                kokyakuYuyuKykmeisaiFTy.setZtyyno7keta(kykSya.getTsinyno());
                kokyakuYuyuKykmeisaiFTy.setZtyyobiv241("");
                kokyakuYuyuKykmeisaiFTy.setZtyyobiv26("");
                kokyakuYuyuKykmeisaiFTy.setZtyyobiv250x2("");
                kokyakuYuyuKykmeisaiFTy.setZtyyobiv50("");

                BizPropertyInitializer.initialize(kokyakuYuyuKykmeisaiFTy);

                BzkykmeisaiRendouFSksConverter.convertPadding(kokyakuYuyuKykmeisaiFTy);

                kokyakuYuyuKykmeisaiFTyInserter.add(kokyakuYuyuKykmeisaiFTy);
            }
        }

        batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(syoriKensuu), kinou.getKinouNm()));
    }
}
