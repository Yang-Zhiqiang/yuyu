package yuyu.batch.sinkeiyaku.skjyouhoukei.sksouseiritudatasakusei;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.AppBatchExceptionTerminate;
import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.EntityInserter;
import jp.co.slcs.swak.db.EntityUpdater;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.common.biz.bzcommon.BizEntityUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BzBatchAbendCommonRecovery;
import yuyu.common.biz.bzcommon.BzBatchParam;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.BzRecoveryDatasikibetuBean;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.db.entity.HT_MosKihon;
import yuyu.def.db.entity.HT_MosSyouhn;
import yuyu.def.db.entity.HT_MosTrkKzk;
import yuyu.def.db.entity.HT_SouseirituDairiten;
import yuyu.def.db.entity.HT_SouseirituKihon;
import yuyu.def.db.entity.HT_SouseirituSyouhin;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

import com.google.common.collect.Lists;

/**
 * 新契約 情報系 総成立データ作成
 */
public class SkSouseirituDataSakuseiBatch implements Batch {

    private static final String TYSYTTAISYOUTABLEID = "HT_SyoriCTL";

    private static final String RECOVERYFILTERID = "Sk001";

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BzBatchParam bzBatchParam;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BzRecoveryDatasikibetuBean bzRecoveryDatasikibetuBean;

    @Override
    public BatchParam getParam() {
        return bzBatchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        BizDate syoriYmd = bzBatchParam.getSyoriYmd();

        String kakutyouJobCd = bzBatchParam.getIbKakutyoujobcd();

        long sousrkhAddKensuu = 0;

        long sousrkhUpdateKensuu = 0;

        batchLogger.info(MessageUtil.getMessage(MessageId.IBA0016, "処理年月日", String.valueOf(syoriYmd)));
        batchLogger.info(MessageUtil.getMessage(
            MessageId.IBA0016, MessageUtil.getMessage(MessageId.IBW1018), kakutyouJobCd));

        Integer bosyuuymKrkeDay = YuyuSinkeiyakuConfig.getInstance().getBosyuuymkrkeday();
        BizDateYM tysytTaisyouYm = null;

        int syoriDay = syoriYmd.getDay();

        if (syoriDay < bosyuuymKrkeDay) {

            BizDate tysytTaisyouYmd = syoriYmd.getPreviousMonth();
            tysytTaisyouYm = tysytTaisyouYmd.getBizDateYM();
        }
        else {

            tysytTaisyouYm = syoriYmd.getBizDateYM();
        }

        try (
            ExDBResults<HT_SyoriCTL> syoriCtlLst =
            sinkeiyakuDomManager.getSyoriCTLsByKakutyoujobcdSeisekiym(kakutyouJobCd, tysytTaisyouYm);
            EntityUpdater<HT_SouseirituKihon> souseirituKihonDataUpdLst = new EntityUpdater<>();
            EntityInserter<HT_SouseirituKihon> souseirituKihonDataInsLst = new EntityInserter<>()) {

            String mosNo = "";
            HT_MosKihon mosKihon = null;
            List<HT_MosDairiten> mosDairitenLst = null;
            List<HT_MosSyouhn> mosSyouhnLst = null;
            List<HT_SouseirituSyouhin> newSouseirituSyouhinLst = null;
            List<HT_SouseirituDairiten> newsouseirituDairitenLst = null;
            List<HT_MosTrkKzk> mosTrkKzkLst = null;
            HT_SouseirituKihon souseirituKihon = null;

            for (HT_SyoriCTL syoriCTL : syoriCtlLst) {

                newSouseirituSyouhinLst =  Lists.newArrayList();
                newsouseirituDairitenLst = Lists.newArrayList();

                mosNo = syoriCTL.getMosno();

                bzRecoveryDatasikibetuBean.setIbKakutyoujobcd(kakutyouJobCd);
                bzRecoveryDatasikibetuBean.setIbTableid(TYSYTTAISYOUTABLEID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterid(RECOVERYFILTERID);
                bzRecoveryDatasikibetuBean.setIbRecoveryfilterkey1(mosNo);

                mosKihon = syoriCTL.getMosKihon();

                mosDairitenLst = syoriCTL.getMosDairitens();

                mosSyouhnLst = syoriCTL.getMosSyouhns();

                mosTrkKzkLst = syoriCTL.getMosTrkKzks();

                for (HT_MosSyouhn mosSyouhn : mosSyouhnLst) {

                    HT_SouseirituSyouhin souseirituSyouhin =  new HT_SouseirituSyouhin();

                    souseirituSyouhin.setSyono(syoriCTL.getSyono());
                    souseirituSyouhin.setSyouhncd(mosSyouhn.getSyouhncd());
                    souseirituSyouhin.setSyouhnsdno(mosSyouhn.getSyouhnsdno());
                    souseirituSyouhin.setRyouritusdno(mosSyouhn.getRyouritusdno());
                    souseirituSyouhin.setMosno(mosSyouhn.getMosno());
                    souseirituSyouhin.setSyutkkbn(mosSyouhn.getSyutkkbn());
                    souseirituSyouhin.setYoteiriritu(mosSyouhn.getYoteiriritu());
                    souseirituSyouhin.setSknenkinsyu(mosSyouhn.getSknenkinsyu());
                    souseirituSyouhin.setKihons(mosSyouhn.getKihons());
                    souseirituSyouhin.setSeitoukihons(mosSyouhn.getSeitoukihons());
                    souseirituSyouhin.setSyutkp(mosSyouhn.getSyutkp());
                    souseirituSyouhin.setHrktuukasyutkp(mosSyouhn.getHrktuukasyutkp());
                    souseirituSyouhin.setTkjyp(mosSyouhn.getTkjyp());
                    souseirituSyouhin.setKatakbn(mosSyouhn.getKatakbn());
                    souseirituSyouhin.setKyhkatakbn(mosSyouhn.getKyhkatakbn());
                    souseirituSyouhin.setSyukyhkinkatakbn(mosSyouhn.getSyukyhkinkatakbn());
                    souseirituSyouhin.setKhnkyhkgbairitukbn(mosSyouhn.getKhnkyhkgbairitukbn());
                    souseirituSyouhin.setRokudaildkbn(mosSyouhn.getRokudaildkbn());
                    souseirituSyouhin.setHknkkn(mosSyouhn.getHknkkn());
                    souseirituSyouhin.setHrkkkn(mosSyouhn.getHrkkkn());
                    souseirituSyouhin.setHknkknsmnkbn(mosSyouhn.getHknkknsmnkbn());
                    souseirituSyouhin.setHrkkknsmnkbn(mosSyouhn.getHrkkknsmnkbn());
                    souseirituSyouhin.setDai1hknkkn(mosSyouhn.getDai1hknkkn());
                    souseirituSyouhin.setTumitateriritu(mosSyouhn.getTumitateriritu());
                    souseirituSyouhin.setTmttknzoukaritujygn(mosSyouhn.getTmttknzoukaritujygn());
                    souseirituSyouhin.setSetteibairitu(mosSyouhn.getSetteibairitu());
                    souseirituSyouhin.setRendouritu(mosSyouhn.getRendouritu());
                    souseirituSyouhin.setTeikisiharaikin(mosSyouhn.getTeikisiharaikin());
                    souseirituSyouhin.setGyoumuKousinsyaId(mosSyouhn.getGyoumuKousinsyaId());
                    souseirituSyouhin.setGyoumuKousinTime(mosSyouhn.getGyoumuKousinTime());

                    BizPropertyInitializer.initialize(souseirituSyouhin);

                    newSouseirituSyouhinLst.add(souseirituSyouhin);
                }

                for (HT_MosDairiten mosDairiten : mosDairitenLst) {

                    HT_SouseirituDairiten souseirituDairiten = new HT_SouseirituDairiten();

                    souseirituDairiten.setSyono(syoriCTL.getSyono());
                    souseirituDairiten.setRenno(mosDairiten.getRenno());
                    souseirituDairiten.setMosno(mosDairiten.getMosno());
                    souseirituDairiten.setBsyujoyadrtencd(mosDairiten.getBsyujoyadrtencd());
                    souseirituDairiten.setDrtensykbn(mosDairiten.getDrtensykbn());
                    souseirituDairiten.setKinyuucd(mosDairiten.getKinyuucd());
                    souseirituDairiten.setKinyuusitencd(mosDairiten.getKinyuusitencd());
                    souseirituDairiten.setTratkiagcd(mosDairiten.getTratkiagcd());
                    souseirituDairiten.setOyadrtencd(mosDairiten.getOyadrtencd());
                    souseirituDairiten.setJimusyocd(mosDairiten.getJimusyocd());
                    souseirituDairiten.setBosyuutrkno(mosDairiten.getBosyuutrkno());
                    souseirituDairiten.setCifcd(mosDairiten.getCifcd());
                    souseirituDairiten.setDrtencd(mosDairiten.getDrtencd());
                    souseirituDairiten.setBosyuucd(mosDairiten.getBosyuucd());
                    souseirituDairiten.setInputbosyuucd(mosDairiten.getInputbosyuucd());
                    souseirituDairiten.setDaibosyuucd(mosDairiten.getDaibosyuucd());
                    souseirituDairiten.setTratkikouinncd(mosDairiten.getTratkikouinncd());
                    souseirituDairiten.setYuuseikbn(mosDairiten.getYuuseikbn());
                    souseirituDairiten.setKyokusyocd(mosDairiten.getKyokusyocd());
                    souseirituDairiten.setYuuseisyainno(mosDairiten.getYuuseisyainno());
                    souseirituDairiten.setDrtenkanrisosikicd(mosDairiten.getDrtenkanrisosikicd());
                    souseirituDairiten.setGyousekikeijyousakisosikicd(mosDairiten.getGyousekikeijyousakisosikicd());
                    souseirituDairiten.setBunwari(mosDairiten.getBunwari());
                    souseirituDairiten.setGyoumuKousinsyaId(mosDairiten.getGyoumuKousinsyaId());
                    souseirituDairiten.setGyoumuKousinTime(mosDairiten.getGyoumuKousinTime());

                    BizPropertyInitializer.initialize(souseirituDairiten);

                    newsouseirituDairitenLst.add(souseirituDairiten);
                }

                souseirituKihon = sinkeiyakuDomManager.getSouseirituKihon(syoriCTL.getSyono());

                if (souseirituKihon == null) {

                    HT_SouseirituKihon newSouseirituKihon = new HT_SouseirituKihon();

                    newSouseirituKihon.setSyono(syoriCTL.getSyono());
                    newSouseirituKihon.setMosno(mosNo);
                    newSouseirituKihon.setAitemosno(mosKihon.getAitemosno());
                    newSouseirituKihon.setDoujikaiyakusyono(mosKihon.getDoujikaiyakusyono());
                    newSouseirituKihon.setSekno(mosKihon.getSekno());
                    newSouseirituKihon.setPykkigenymd(mosKihon.getPykkigenymd());
                    newSouseirituKihon.setSrsyoriymd(syoriCTL.getSrsyoriymd());
                    newSouseirituKihon.setRyosyuymd(syoriCTL.getRyosyuymd());
                    newSouseirituKihon.setMosymd(mosKihon.getMosymd());
                    newSouseirituKihon.setMossakuseiymd(mosKihon.getMossakuseiymd());
                    newSouseirituKihon.setMoscalckijyunymd(mosKihon.getMoscalckijyunymd());
                    newSouseirituKihon.setMosukeymd(mosKihon.getMosukeymd());
                    newSouseirituKihon.setMosjimosuktymd(mosKihon.getMosjimosuktymd());
                    newSouseirituKihon.setMosym(mosKihon.getMosym());
                    newSouseirituKihon.setSsyukeymd(mosKihon.getSsyukeymd());
                    newSouseirituKihon.setKktymd(syoriCTL.getKktymd());
                    newSouseirituKihon.setKykymd(mosKihon.getKykymd());
                    newSouseirituKihon.setKykymdtkrumu(mosKihon.getKykymdtkrumu());
                    newSouseirituKihon.setSkykymd(mosKihon.getSkykymd());
                    newSouseirituKihon.setSknnkaisiymd(mosKihon.getSknnkaisiymd());
                    newSouseirituKihon.setBosyuuym(mosKihon.getBosyuuym());
                    newSouseirituKihon.setSeisekiym(mosKihon.getSeisekiym());
                    newSouseirituKihon.setSkeikeijyouym(mosKihon.getSkeikeijyouym());
                    newSouseirituKihon.setKykkbn(mosKihon.getKykkbn());
                    newSouseirituKihon.setHknsyuruino(mosKihon.getHknsyuruino());
                    newSouseirituKihon.setHknsyuruinosd(mosKihon.getHknsyuruinosd());
                    newSouseirituKihon.setAisyoumeikbn(mosKihon.getAisyoumeikbn());
                    newSouseirituKihon.setNkgnshosyouritukbn(mosKihon.getNkgnshosyouritukbn());
                    newSouseirituKihon.setLivhukaumu(mosKihon.getLivhukaumu());
                    newSouseirituKihon.setPmnjtkhukakbn(mosKihon.getPmnjtkhukakbn());
                    newSouseirituKihon.setPmnjtkkbn(mosKihon.getPmnjtkkbn());
                    newSouseirituKihon.setSknnkaisikitkhukakbn(mosKihon.getSknnkaisikitkhukakbn());
                    newSouseirituKihon.setSknnkaisikitkkbn(mosKihon.getSknnkaisikitkkbn());
                    if (mosTrkKzkLst.size() == 0) {
                        newSouseirituKihon.setKzktrkservicekbn("0");
                    }
                    else if (mosTrkKzkLst.size() == 1) {
                        newSouseirituKihon.setKzktrkservicekbn("1");
                    }
                    else if (mosTrkKzkLst.size() == 2) {
                        newSouseirituKihon.setKzktrkservicekbn("2");
                    }
                    else {
                        newSouseirituKihon.setKzktrkservicekbn("0");
                    }
                    newSouseirituKihon.setKykdrtkykhukakbn(mosKihon.getKykdrtkykhukakbn());
                    newSouseirituKihon.setStdrsktkyhkkbn(mosKihon.getStdrsktkyhkkbn());
                    newSouseirituKihon.setSdpdkbn(mosKihon.getSdpdkbn());
                    newSouseirituKihon.setSntkhoukbn(mosKihon.getSntkhoukbn());
                    newSouseirituKihon.setHaitoukbn(mosKihon.getHaitoukbn());
                    newSouseirituKihon.setHaitoukinuketorihoukbn(mosKihon.getHaitoukinuketorihoukbn());
                    newSouseirituKihon.setKyktuukasyu(mosKihon.getKyktuukasyu());
                    newSouseirituKihon.setHrktuukasyu(mosKihon.getHrktuukasyu());
                    newSouseirituKihon.setYennykntkhkkbn(mosKihon.getYennykntkhkkbn());
                    newSouseirituKihon.setGaikanykntkhkkbn(mosKihon.getGaikanykntkhkkbn());
                    newSouseirituKihon.setYenshrtkhkkbn(mosKihon.getYenshrtkhkkbn());
                    newSouseirituKihon.setMosheijyunp(mosKihon.getMosheijyunp());
                    newSouseirituKihon.setHeijyunp(mosKihon.getHeijyunp());
                    newSouseirituKihon.setHeijyunpryoumasinasi(mosKihon.getHeijyunpryoumasinasi());
                    newSouseirituKihon.setIkkatubaraikbn(mosKihon.getIkkatubaraikbn());
                    newSouseirituKihon.setIkkatubaraikaisuu(mosKihon.getIkkatubaraikaisuu());
                    newSouseirituKihon.setMosikkatup(mosKihon.getMosikkatup());
                    newSouseirituKihon.setIkkatup(mosKihon.getIkkatup());
                    newSouseirituKihon.setZennoumousideumu(mosKihon.getZennoumousideumu());
                    newSouseirituKihon.setZenkizennouumu(mosKihon.getZenkizennouumu());
                    newSouseirituKihon.setZnnkai(mosKihon.getZnnkai());
                    newSouseirituKihon.setMoszennoupsyokaiari(mosKihon.getMoszennoupsyokaiari());
                    newSouseirituKihon.setZennoup(mosKihon.getZennoup());
                    newSouseirituKihon.setZennoujyuutoup(mosKihon.getZennoujyuutoup());
                    newSouseirituKihon.setZnnhrkkai(mosKihon.getZnnhrkkai());
                    newSouseirituKihon.setZnnhrkkeiro(mosKihon.getZnnhrkkeiro());
                    newSouseirituKihon.setMosfstpkei(mosKihon.getMosfstpkei());
                    newSouseirituKihon.setHyouteip(mosKihon.getHyouteip());
                    newSouseirituKihon.setSeitoufstpkei(mosKihon.getSeitoufstpkei());
                    newSouseirituKihon.setFstphrkgk(mosKihon.getFstphrkgk());
                    newSouseirituKihon.setPharaikomisougaku(mosKihon.getPharaikomisougaku());
                    newSouseirituKihon.setSibouskei(mosKihon.getSibouskei());
                    newSouseirituKihon.setHrkkaisuu(mosKihon.getHrkkaisuu());
                    newSouseirituKihon.setHrkkeiro(mosKihon.getHrkkeiro());
                    newSouseirituKihon.setFstphrkkeirokbn(mosKihon.getFstphrkkeirokbn());
                    newSouseirituKihon.setSkjpjyuutoukaisuu(mosKihon.getSkjpjyuutoukaisuu());
                    newSouseirituKihon.setIkkatuyoupumukbn(mosKihon.getIkkatuyoupumukbn());
                    newSouseirituKihon.setIkkatuyoupkaisuu(mosKihon.getIkkatuyoupkaisuu());
                    newSouseirituKihon.setPwaribikitekiyoukbn(mosKihon.getPwaribikitekiyoukbn());
                    newSouseirituKihon.setDntryouritukbn(mosKihon.getDntryouritukbn());
                    newSouseirituKihon.setAplkahikbn(mosKihon.getAplkahikbn());
                    newSouseirituKihon.setItipclriyoukbn(mosKihon.getItipclriyoukbn());
                    newSouseirituKihon.setItiprsymd(mosKihon.getItiprsymd());
                    newSouseirituKihon.setDntcd(mosKihon.getDntcd());
                    newSouseirituKihon.setMassiseiymd(mosKihon.getMassiseiymd());
                    newSouseirituKihon.setHhknnmkn(mosKihon.getHhknnmkn());
                    newSouseirituKihon.setHhknnmkj(mosKihon.getHhknnmkj());
                    newSouseirituKihon.setHhknnmkjkhukakbn(mosKihon.getHhknnmkjkhukakbn());
                    newSouseirituKihon.setHhknseiymd(mosKihon.getHhknseiymd());
                    newSouseirituKihon.setHhknnen(mosKihon.getHhknnen());
                    newSouseirituKihon.setHhknsei(mosKihon.getHhknsei());
                    newSouseirituKihon.setHhknsykgycd(mosKihon.getHhknsykgycd());
                    newSouseirituKihon.setHhknnensyuukbn(mosKihon.getHhknnensyuukbn());
                    newSouseirituKihon.setTsindousiteikbn(mosKihon.getTsindousiteikbn());
                    newSouseirituKihon.setHhknyno(mosKihon.getHhknyno());
                    newSouseirituKihon.setHhknadr1kn(mosKihon.getHhknadr1kn());
                    newSouseirituKihon.setHhknadr2kn(mosKihon.getHhknadr2kn());
                    newSouseirituKihon.setHhknadr3kn(mosKihon.getHhknadr3kn());
                    newSouseirituKihon.setHhknadr1kj(mosKihon.getHhknadr1kj());
                    newSouseirituKihon.setHhknadr2kj(mosKihon.getHhknadr2kj());
                    newSouseirituKihon.setHhknadr3kj(mosKihon.getHhknadr3kj());
                    newSouseirituKihon.setHhkntelno(mosKihon.getHhkntelno());
                    newSouseirituKihon.setHhknkinmusakinm(mosKihon.getHhknkinmusakinm());
                    newSouseirituKihon.setKyknmkn(mosKihon.getKyknmkn());
                    newSouseirituKihon.setKyknmkj(mosKihon.getKyknmkj());
                    newSouseirituKihon.setKyknmkjkhukakbn(mosKihon.getKyknmkjkhukakbn());
                    newSouseirituKihon.setKykseiymd(mosKihon.getKykseiymd());
                    newSouseirituKihon.setKyknen(mosKihon.getKyknen());
                    newSouseirituKihon.setKyksei(mosKihon.getKyksei());
                    newSouseirituKihon.setKyktdk(mosKihon.getKyktdk());
                    newSouseirituKihon.setKyknensyuukbn(mosKihon.getKyknensyuukbn());
                    newSouseirituKihon.setKykkinmusakinm(mosKihon.getKykkinmusakinm());
                    newSouseirituKihon.setHjndaiykkbn(mosKihon.getHjndaiykkbn());
                    newSouseirituKihon.setHjndainmkn(mosKihon.getHjndainmkn());
                    newSouseirituKihon.setHjndainmkj(mosKihon.getHjndainmkj());
                    newSouseirituKihon.setFatcasnsikbn(mosKihon.getFatcasnsikbn());
                    newSouseirituKihon.setBikkjnssinfokbn(mosKihon.getBikkjnssinfokbn());
                    newSouseirituKihon.setBikknzsyno(mosKihon.getBikknzsyno());
                    newSouseirituKihon.setSyomeiymd(mosKihon.getSyomeiymd());
                    newSouseirituKihon.setAeoisnsikbn(mosKihon.getAeoisnsikbn());
                    newSouseirituKihon.setTsinyno(mosKihon.getTsinyno());
                    newSouseirituKihon.setTsinadr1kj(mosKihon.getTsinadr1kj());
                    newSouseirituKihon.setTsinadr2kj(mosKihon.getTsinadr2kj());
                    newSouseirituKihon.setTsinadr3kj(mosKihon.getTsinadr3kj());
                    newSouseirituKihon.setTsinadr1kn(mosKihon.getTsinadr1kn());
                    newSouseirituKihon.setTsinadr2kn(mosKihon.getTsinadr2kn());
                    newSouseirituKihon.setTsinadr3kn(mosKihon.getTsinadr3kn());
                    newSouseirituKihon.setTsintelno(mosKihon.getTsintelno());
                    newSouseirituKihon.setDai2tsintelno(mosKihon.getDai2tsintelno());
                    newSouseirituKihon.setSyoshadr1kj(mosKihon.getSyoshadr1kj());
                    newSouseirituKihon.setSyoshadr2kj(mosKihon.getSyoshadr2kj());
                    newSouseirituKihon.setSyoshadr3kj(mosKihon.getSyoshadr3kj());
                    newSouseirituKihon.setSyoshtelno(mosKihon.getSyoshtelno());
                    newSouseirituKihon.setSyoshyno(mosKihon.getSyoshyno());
                    newSouseirituKihon.setTargettkhkkbn(mosKihon.getTargettkhkkbn());
                    newSouseirituKihon.setTargettkkbn(mosKihon.getTargettkkbn());
                    newSouseirituKihon.setTargettkmkhtkbn(mosKihon.getTargettkmkhtkbn());
                    newSouseirituKihon.setNstkhkkbn(mosKihon.getNstkhkkbn());
                    newSouseirituKihon.setNstkmnknsyu(mosKihon.getNstkmnknsyu());
                    newSouseirituKihon.setNstkmnknkkn(mosKihon.getNstkmnknkkn());
                    newSouseirituKihon.setNstksbnsyu(mosKihon.getNstksbnsyu());
                    newSouseirituKihon.setNstksbnkkn(mosKihon.getNstksbnkkn());
                    newSouseirituKihon.setSyksbyensitihsyutkhkkbn(mosKihon.getSyksbyensitihsyutkhkkbn());
                    newSouseirituKihon.setJyudkaigomehrtkhkkbn(mosKihon.getJyudkaigomehrtkhkkbn());
                    newSouseirituKihon.setKjnnkpzeitekitkhukakbn(mosKihon.getKjnnkpzeitekitkhukakbn());
                    newSouseirituKihon.setTeikisiharaitkykhkkbn(mosKihon.getTeikisiharaitkykhkkbn());
                    newSouseirituKihon.setSaihocd(mosKihon.getSaihocd());
                    newSouseirituKihon.setStknsetkbn(mosKihon.getStknsetkbn());
                    newSouseirituKihon.setSbuktnin(mosKihon.getSbuktnin());
                    newSouseirituKihon.setKykhonninkakninsyoruikbn(mosKihon.getKykhonninkakninsyoruikbn());
                    newSouseirituKihon.setSkskknhonninkakninsyoruikbn(mosKihon.getSkskknhonninkakninsyoruikbn());
                    newSouseirituKihon.setSyotnshuyoupostumukbn(mosKihon.getSyotnshuyoupostumukbn());
                    newSouseirituKihon.setUktkid(mosKihon.getUktkid());
                    newSouseirituKihon.setBoskykjyoutai(mosKihon.getBoskykjyoutai());
                    newSouseirituKihon.setTkkinyukkntkrumu(mosKihon.getTkkinyukkntkrumu());
                    newSouseirituKihon.setDrctservicemoskbn(mosKihon.getDrctservicemoskbn());
                    newSouseirituKihon.setHnsstjmmouumukbn(mosKihon.getHnsstjmmouumukbn());
                    newSouseirituKihon.setKjmeigihkhunouumukbn(mosKihon.getKjmeigihkhunouumukbn());
                    newSouseirituKihon.setTsryhshrkykumukbn(mosKihon.getTsryhshrkykumukbn());
                    newSouseirituKihon.setSyosisyatodokeumukbn(mosKihon.getSyosisyatodokeumukbn());
                    newSouseirituKihon.setKakukisyouryakukbumukbn(mosKihon.getKakukisyouryakukbumukbn());
                    newSouseirituKihon.setSeiymdmosseitouumukbn(mosKihon.getSeiymdmosseitouumukbn());
                    newSouseirituKihon.setKouseiinkyktkjkumukbn(mosKihon.getKouseiinkyktkjkumukbn());
                    newSouseirituKihon.setKoukankykkinmusakinm(mosKihon.getKoukankykkinmusakinm());
                    newSouseirituKihon.setKoukankyksyokumunaiyou(mosKihon.getKoukankyksyokumunaiyou());
                    newSouseirituKihon.setKoukankyktkjkumukbn(mosKihon.getKoukankyktkjkumukbn());
                    newSouseirituKihon.setKhnchkcmnt(mosKihon.getKhnchkcmnt());
                    newSouseirituKihon.setJimuyoucd(mosKihon.getJimuyoucd());
                    newSouseirituKihon.setTeirituhaibunwarikbn(mosKihon.getTeirituhaibunwarikbn());
                    newSouseirituKihon.setSisuukbn(mosKihon.getSisuukbn());
                    newSouseirituKihon.setSisuuhaibunwarikbn(mosKihon.getSisuuhaibunwarikbn());
                    newSouseirituKihon.setTrhkjikakkbn(mosKihon.getTrhkjikakkbn());
                    newSouseirituKihon.setKoureitaioukbn(mosKihon.getKoureitaioukbn());
                    newSouseirituKihon.setGyoumuKousinsyaId(syoriCTL.getGyoumuKousinsyaId());
                    newSouseirituKihon.setGyoumuKousinTime(syoriCTL.getGyoumuKousinTime());

                    BizPropertyInitializer.initialize(newSouseirituKihon);

                    for (HT_SouseirituSyouhin newsouseirituSyouhin : newSouseirituSyouhinLst) {

                        newsouseirituSyouhin.setSouseirituKihon(newSouseirituKihon);
                    }

                    newSouseirituKihon.setSouseirituSyouhins(newSouseirituSyouhinLst);

                    for (HT_SouseirituDairiten newSouseirituDairiten : newsouseirituDairitenLst) {

                        newSouseirituDairiten.setSouseirituKihon(newSouseirituKihon);
                    }

                    newSouseirituKihon.setSouseirituDairitens(newsouseirituDairitenLst);

                    souseirituKihonDataInsLst.add(newSouseirituKihon);

                    sousrkhAddKensuu++;
                }
                else {

                    souseirituKihon.setSyono(syoriCTL.getSyono());
                    souseirituKihon.setMosno(mosNo);
                    souseirituKihon.setAitemosno(mosKihon.getAitemosno());
                    souseirituKihon.setDoujikaiyakusyono(mosKihon.getDoujikaiyakusyono());
                    souseirituKihon.setSekno(mosKihon.getSekno());
                    souseirituKihon.setPykkigenymd(mosKihon.getPykkigenymd());
                    souseirituKihon.setSrsyoriymd(syoriCTL.getSrsyoriymd());
                    souseirituKihon.setRyosyuymd(syoriCTL.getRyosyuymd());
                    souseirituKihon.setMosymd(mosKihon.getMosymd());
                    souseirituKihon.setMossakuseiymd(mosKihon.getMossakuseiymd());
                    souseirituKihon.setMoscalckijyunymd(mosKihon.getMoscalckijyunymd());
                    souseirituKihon.setMosukeymd(mosKihon.getMosukeymd());
                    souseirituKihon.setMosjimosuktymd(mosKihon.getMosjimosuktymd());
                    souseirituKihon.setMosym(mosKihon.getMosym());
                    souseirituKihon.setSsyukeymd(mosKihon.getSsyukeymd());
                    souseirituKihon.setKktymd(syoriCTL.getKktymd());
                    souseirituKihon.setKykymd(mosKihon.getKykymd());
                    souseirituKihon.setKykymdtkrumu(mosKihon.getKykymdtkrumu());
                    souseirituKihon.setSkykymd(mosKihon.getSkykymd());
                    souseirituKihon.setSknnkaisiymd(mosKihon.getSknnkaisiymd());
                    souseirituKihon.setBosyuuym(mosKihon.getBosyuuym());
                    souseirituKihon.setSeisekiym(mosKihon.getSeisekiym());
                    souseirituKihon.setSkeikeijyouym(mosKihon.getSkeikeijyouym());
                    souseirituKihon.setKykkbn(mosKihon.getKykkbn());
                    souseirituKihon.setHknsyuruino(mosKihon.getHknsyuruino());
                    souseirituKihon.setHknsyuruinosd(mosKihon.getHknsyuruinosd());
                    souseirituKihon.setAisyoumeikbn(mosKihon.getAisyoumeikbn());
                    souseirituKihon.setNkgnshosyouritukbn(mosKihon.getNkgnshosyouritukbn());
                    souseirituKihon.setLivhukaumu(mosKihon.getLivhukaumu());
                    souseirituKihon.setPmnjtkhukakbn(mosKihon.getPmnjtkhukakbn());
                    souseirituKihon.setPmnjtkkbn(mosKihon.getPmnjtkkbn());
                    souseirituKihon.setSknnkaisikitkhukakbn(mosKihon.getSknnkaisikitkhukakbn());
                    souseirituKihon.setSknnkaisikitkkbn(mosKihon.getSknnkaisikitkkbn());
                    if(mosTrkKzkLst.size() == 0){
                        souseirituKihon.setKzktrkservicekbn("0");
                    }
                    else if(mosTrkKzkLst.size() == 1){
                        souseirituKihon.setKzktrkservicekbn("1");
                    }
                    else if(mosTrkKzkLst.size() == 2){
                        souseirituKihon.setKzktrkservicekbn("2");
                    }
                    else {
                        souseirituKihon.setKzktrkservicekbn("0");
                    }
                    souseirituKihon.setKykdrtkykhukakbn(mosKihon.getKykdrtkykhukakbn());
                    souseirituKihon.setStdrsktkyhkkbn(mosKihon.getStdrsktkyhkkbn());
                    souseirituKihon.setSdpdkbn(mosKihon.getSdpdkbn());
                    souseirituKihon.setSntkhoukbn(mosKihon.getSntkhoukbn());
                    souseirituKihon.setHaitoukbn(mosKihon.getHaitoukbn());
                    souseirituKihon.setHaitoukinuketorihoukbn(mosKihon.getHaitoukinuketorihoukbn());
                    souseirituKihon.setKyktuukasyu(mosKihon.getKyktuukasyu());
                    souseirituKihon.setHrktuukasyu(mosKihon.getHrktuukasyu());
                    souseirituKihon.setYennykntkhkkbn(mosKihon.getYennykntkhkkbn());
                    souseirituKihon.setGaikanykntkhkkbn(mosKihon.getGaikanykntkhkkbn());
                    souseirituKihon.setYenshrtkhkkbn(mosKihon.getYenshrtkhkkbn());
                    souseirituKihon.setMosheijyunp(mosKihon.getMosheijyunp());
                    souseirituKihon.setHeijyunp(mosKihon.getHeijyunp());
                    souseirituKihon.setHeijyunpryoumasinasi(mosKihon.getHeijyunpryoumasinasi());
                    souseirituKihon.setIkkatubaraikbn(mosKihon.getIkkatubaraikbn());
                    souseirituKihon.setIkkatubaraikaisuu(mosKihon.getIkkatubaraikaisuu());
                    souseirituKihon.setMosikkatup(mosKihon.getMosikkatup());
                    souseirituKihon.setIkkatup(mosKihon.getIkkatup());
                    souseirituKihon.setZennoumousideumu(mosKihon.getZennoumousideumu());
                    souseirituKihon.setZenkizennouumu(mosKihon.getZenkizennouumu());
                    souseirituKihon.setZnnkai(mosKihon.getZnnkai());
                    souseirituKihon.setMoszennoupsyokaiari(mosKihon.getMoszennoupsyokaiari());
                    souseirituKihon.setZennoup(mosKihon.getZennoup());
                    souseirituKihon.setZennoujyuutoup(mosKihon.getZennoujyuutoup());
                    souseirituKihon.setZnnhrkkai(mosKihon.getZnnhrkkai());
                    souseirituKihon.setZnnhrkkeiro(mosKihon.getZnnhrkkeiro());
                    souseirituKihon.setMosfstpkei(mosKihon.getMosfstpkei());
                    souseirituKihon.setHyouteip(mosKihon.getHyouteip());
                    souseirituKihon.setSeitoufstpkei(mosKihon.getSeitoufstpkei());
                    souseirituKihon.setFstphrkgk(mosKihon.getFstphrkgk());
                    souseirituKihon.setPharaikomisougaku(mosKihon.getPharaikomisougaku());
                    souseirituKihon.setSibouskei(mosKihon.getSibouskei());
                    souseirituKihon.setHrkkaisuu(mosKihon.getHrkkaisuu());
                    souseirituKihon.setHrkkeiro(mosKihon.getHrkkeiro());
                    souseirituKihon.setFstphrkkeirokbn(mosKihon.getFstphrkkeirokbn());
                    souseirituKihon.setSkjpjyuutoukaisuu(mosKihon.getSkjpjyuutoukaisuu());
                    souseirituKihon.setIkkatuyoupumukbn(mosKihon.getIkkatuyoupumukbn());
                    souseirituKihon.setIkkatuyoupkaisuu(mosKihon.getIkkatuyoupkaisuu());
                    souseirituKihon.setPwaribikitekiyoukbn(mosKihon.getPwaribikitekiyoukbn());
                    souseirituKihon.setDntryouritukbn(mosKihon.getDntryouritukbn());
                    souseirituKihon.setAplkahikbn(mosKihon.getAplkahikbn());
                    souseirituKihon.setItipclriyoukbn(mosKihon.getItipclriyoukbn());
                    souseirituKihon.setItiprsymd(mosKihon.getItiprsymd());
                    souseirituKihon.setDntcd(mosKihon.getDntcd());
                    souseirituKihon.setMassiseiymd(mosKihon.getMassiseiymd());
                    souseirituKihon.setHhknnmkn(mosKihon.getHhknnmkn());
                    souseirituKihon.setHhknnmkj(mosKihon.getHhknnmkj());
                    souseirituKihon.setHhknnmkjkhukakbn(mosKihon.getHhknnmkjkhukakbn());
                    souseirituKihon.setHhknseiymd(mosKihon.getHhknseiymd());
                    souseirituKihon.setHhknnen(mosKihon.getHhknnen());
                    souseirituKihon.setHhknsei(mosKihon.getHhknsei());
                    souseirituKihon.setHhknsykgycd(mosKihon.getHhknsykgycd());
                    souseirituKihon.setHhknnensyuukbn(mosKihon.getHhknnensyuukbn());
                    souseirituKihon.setTsindousiteikbn(mosKihon.getTsindousiteikbn());
                    souseirituKihon.setHhknyno(mosKihon.getHhknyno());
                    souseirituKihon.setHhknadr1kn(mosKihon.getHhknadr1kn());
                    souseirituKihon.setHhknadr2kn(mosKihon.getHhknadr2kn());
                    souseirituKihon.setHhknadr3kn(mosKihon.getHhknadr3kn());
                    souseirituKihon.setHhknadr1kj(mosKihon.getHhknadr1kj());
                    souseirituKihon.setHhknadr2kj(mosKihon.getHhknadr2kj());
                    souseirituKihon.setHhknadr3kj(mosKihon.getHhknadr3kj());
                    souseirituKihon.setHhkntelno(mosKihon.getHhkntelno());
                    souseirituKihon.setHhknkinmusakinm(mosKihon.getHhknkinmusakinm());
                    souseirituKihon.setKyknmkn(mosKihon.getKyknmkn());
                    souseirituKihon.setKyknmkj(mosKihon.getKyknmkj());
                    souseirituKihon.setKyknmkjkhukakbn(mosKihon.getKyknmkjkhukakbn());
                    souseirituKihon.setKykseiymd(mosKihon.getKykseiymd());
                    souseirituKihon.setKyknen(mosKihon.getKyknen());
                    souseirituKihon.setKyksei(mosKihon.getKyksei());
                    souseirituKihon.setKyktdk(mosKihon.getKyktdk());
                    souseirituKihon.setKyknensyuukbn(mosKihon.getKyknensyuukbn());
                    souseirituKihon.setKykkinmusakinm(mosKihon.getKykkinmusakinm());
                    souseirituKihon.setHjndaiykkbn(mosKihon.getHjndaiykkbn());
                    souseirituKihon.setHjndainmkn(mosKihon.getHjndainmkn());
                    souseirituKihon.setHjndainmkj(mosKihon.getHjndainmkj());
                    souseirituKihon.setFatcasnsikbn(mosKihon.getFatcasnsikbn());
                    souseirituKihon.setBikkjnssinfokbn(mosKihon.getBikkjnssinfokbn());
                    souseirituKihon.setBikknzsyno(mosKihon.getBikknzsyno());
                    souseirituKihon.setSyomeiymd(mosKihon.getSyomeiymd());
                    souseirituKihon.setAeoisnsikbn(mosKihon.getAeoisnsikbn());
                    souseirituKihon.setTsinyno(mosKihon.getTsinyno());
                    souseirituKihon.setTsinadr1kj(mosKihon.getTsinadr1kj());
                    souseirituKihon.setTsinadr2kj(mosKihon.getTsinadr2kj());
                    souseirituKihon.setTsinadr3kj(mosKihon.getTsinadr3kj());
                    souseirituKihon.setTsinadr1kn(mosKihon.getTsinadr1kn());
                    souseirituKihon.setTsinadr2kn(mosKihon.getTsinadr2kn());
                    souseirituKihon.setTsinadr3kn(mosKihon.getTsinadr3kn());
                    souseirituKihon.setTsintelno(mosKihon.getTsintelno());
                    souseirituKihon.setDai2tsintelno(mosKihon.getDai2tsintelno());
                    souseirituKihon.setSyoshadr1kj(mosKihon.getSyoshadr1kj());
                    souseirituKihon.setSyoshadr2kj(mosKihon.getSyoshadr2kj());
                    souseirituKihon.setSyoshadr3kj(mosKihon.getSyoshadr3kj());
                    souseirituKihon.setSyoshtelno(mosKihon.getSyoshtelno());
                    souseirituKihon.setSyoshyno(mosKihon.getSyoshyno());
                    souseirituKihon.setTargettkhkkbn(mosKihon.getTargettkhkkbn());
                    souseirituKihon.setTargettkkbn(mosKihon.getTargettkkbn());
                    souseirituKihon.setTargettkmkhtkbn(mosKihon.getTargettkmkhtkbn());
                    souseirituKihon.setNstkhkkbn(mosKihon.getNstkhkkbn());
                    souseirituKihon.setNstkmnknsyu(mosKihon.getNstkmnknsyu());
                    souseirituKihon.setNstkmnknkkn(mosKihon.getNstkmnknkkn());
                    souseirituKihon.setNstksbnsyu(mosKihon.getNstksbnsyu());
                    souseirituKihon.setNstksbnkkn(mosKihon.getNstksbnkkn());
                    souseirituKihon.setSyksbyensitihsyutkhkkbn(mosKihon.getSyksbyensitihsyutkhkkbn());
                    souseirituKihon.setJyudkaigomehrtkhkkbn(mosKihon.getJyudkaigomehrtkhkkbn());
                    souseirituKihon.setKjnnkpzeitekitkhukakbn(mosKihon.getKjnnkpzeitekitkhukakbn());
                    souseirituKihon.setTeikisiharaitkykhkkbn(mosKihon.getTeikisiharaitkykhkkbn());
                    souseirituKihon.setSaihocd(mosKihon.getSaihocd());
                    souseirituKihon.setStknsetkbn(mosKihon.getStknsetkbn());
                    souseirituKihon.setSbuktnin(mosKihon.getSbuktnin());
                    souseirituKihon.setKykhonninkakninsyoruikbn(mosKihon.getKykhonninkakninsyoruikbn());
                    souseirituKihon.setSkskknhonninkakninsyoruikbn(mosKihon.getSkskknhonninkakninsyoruikbn());
                    souseirituKihon.setSyotnshuyoupostumukbn(mosKihon.getSyotnshuyoupostumukbn());
                    souseirituKihon.setUktkid(mosKihon.getUktkid());
                    souseirituKihon.setBoskykjyoutai(mosKihon.getBoskykjyoutai());
                    souseirituKihon.setTkkinyukkntkrumu(mosKihon.getTkkinyukkntkrumu());
                    souseirituKihon.setDrctservicemoskbn(mosKihon.getDrctservicemoskbn());
                    souseirituKihon.setHnsstjmmouumukbn(mosKihon.getHnsstjmmouumukbn());
                    souseirituKihon.setKjmeigihkhunouumukbn(mosKihon.getKjmeigihkhunouumukbn());
                    souseirituKihon.setTsryhshrkykumukbn(mosKihon.getTsryhshrkykumukbn());
                    souseirituKihon.setSyosisyatodokeumukbn(mosKihon.getSyosisyatodokeumukbn());
                    souseirituKihon.setKakukisyouryakukbumukbn(mosKihon.getKakukisyouryakukbumukbn());
                    souseirituKihon.setSeiymdmosseitouumukbn(mosKihon.getSeiymdmosseitouumukbn());
                    souseirituKihon.setKouseiinkyktkjkumukbn(mosKihon.getKouseiinkyktkjkumukbn());
                    souseirituKihon.setKoukankykkinmusakinm(mosKihon.getKoukankykkinmusakinm());
                    souseirituKihon.setKoukankyksyokumunaiyou(mosKihon.getKoukankyksyokumunaiyou());
                    souseirituKihon.setKoukankyktkjkumukbn(mosKihon.getKoukankyktkjkumukbn());
                    souseirituKihon.setKhnchkcmnt(mosKihon.getKhnchkcmnt());
                    souseirituKihon.setJimuyoucd(mosKihon.getJimuyoucd());
                    souseirituKihon.setTeirituhaibunwarikbn(mosKihon.getTeirituhaibunwarikbn());
                    souseirituKihon.setSisuukbn(mosKihon.getSisuukbn());
                    souseirituKihon.setSisuuhaibunwarikbn(mosKihon.getSisuuhaibunwarikbn());
                    souseirituKihon.setTrhkjikakkbn(mosKihon.getTrhkjikakkbn());
                    souseirituKihon.setKoureitaioukbn(mosKihon.getKoureitaioukbn());
                    souseirituKihon.setGyoumuKousinsyaId(syoriCTL.getGyoumuKousinsyaId());
                    souseirituKihon.setGyoumuKousinTime(syoriCTL.getGyoumuKousinTime());

                    List<HT_SouseirituSyouhin> souseirituSyouhinUpdLst = souseirituKihon.getSouseirituSyouhins();

                    BizEntityUtil.exchange(souseirituSyouhinUpdLst, newSouseirituSyouhinLst);

                    for (HT_SouseirituSyouhin souseirituSyouhinUpd : souseirituSyouhinUpdLst) {

                        souseirituSyouhinUpd.setSouseirituKihon(souseirituKihon);
                    }

                    List<HT_SouseirituDairiten> souseirituDairitenLstUpd = souseirituKihon.getSouseirituDairitens();

                    BizEntityUtil.exchange(souseirituDairitenLstUpd, newsouseirituDairitenLst);

                    for (HT_SouseirituDairiten souseirituDairitenUpd : souseirituDairitenLstUpd) {

                        souseirituDairitenUpd.setSouseirituKihon(souseirituKihon);
                    }

                    souseirituKihonDataUpdLst.add(souseirituKihon);

                    sousrkhUpdateKensuu++;
                }
            }

            bzRecoveryDatasikibetuBean.initializeBlank();

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(sousrkhAddKensuu), "追加契約件数"));

            batchLogger.info(MessageUtil.getMessage(MessageId.IBF0002, String.valueOf(sousrkhUpdateKensuu), "更新契約件数"));
        }
    }

    @AppBatchExceptionTerminate
    private void appBatchExceptionTerminate() {

        BzBatchAbendCommonRecovery bzBatchAbendCommonRecovery =
            SWAKInjector.getInstance(BzBatchAbendCommonRecovery.class);

        bzBatchAbendCommonRecovery.exec();
    }
}
