package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.classification.C_KinouKbn;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_TsrysyoriKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_BAK_KykKihon;
import yuyu.def.db.entity.IT_BAK_KykSyouhn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_Tesuuryou;
import yuyu.def.db.entity.IT_TesuuryouSyouhn;
import yuyu.def.db.entity.IT_TesuuryouSyouhnRireki;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.sorter.SortIT_Tesuuryou;

/**
 * 契約保全 契約保全共通 代理店手数料情報TBL編集クラス
 */
public class EditDairitenTesuuryouTbl {

    private BizDate batchSyoriYmd;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private static Logger logger;

    @Inject
    private AS_Kinou kinou;

    public EditDairitenTesuuryouTbl() {
        super();
    }

    public void setBatchSyoriYmd(BizDate pBatchSyoriYmd) {
        batchSyoriYmd = pBatchSyoriYmd;
    }

    public void exec(KhozenCommonParam pKhozenCommonParam, String pSyoNo, C_TsrysyoriKbn pTsrySyoriKbn,
        BizDateYM pKouryokuHasseiYM, int pNyknKaisuuY, int pNyknKaisuuM, BizCurrency pMikeikaP,
        BizCurrency pIktP, IT_BAK_KykKihon pBakKykKihon) {

        exec(pKhozenCommonParam, pSyoNo, pTsrySyoriKbn, pKouryokuHasseiYM, pNyknKaisuuY, pNyknKaisuuM,
            pMikeikaP, pIktP, null, pBakKykKihon);
    }

    public void exec(KhozenCommonParam pKhozenCommonParam, String pSyoNo, C_TsrysyoriKbn pTsrySyoriKbn,
        BizDateYM pKouryokuHasseiYM, int pNyknKaisuuY, int pNyknKaisuuM, BizCurrency pMikeikaP,
        BizCurrency pIktP, BizDate pNyknYMD, IT_BAK_KykKihon pBakKykKihon) {

        logger.debug("▽ 代理店手数料情報TBL編集 開始");

        C_KinouKbn kinouKbn = kinou.getKinouKbn();

        IT_KykKihon kykKihon = null;

        if (C_KinouKbn.ONLINE.eq(kinouKbn)) {

            kykKihon = hozenDomManager.getKykKihon(pSyoNo);
        }
        else {

            kykKihon = pKhozenCommonParam.getBatchKeiyakuKihon();
        }

        List<IT_KykSyouhn> kykSyouhnList = kykKihon.getKykSyouhns();

        if(kykSyouhnList.get(0).getYendthnkymd() != null){
            return;
        }

        List<IT_BAK_KykSyouhn> bakKykSyouhnList = new ArrayList<>();

        if (IKhozenCommonConstants.KINOUID_SEINENGAPPISEI.equals(pKhozenCommonParam.getFunctionId())
            || IKhozenCommonConstants.KINOUID_GENGAKU.equals(pKhozenCommonParam.getFunctionId())
            || IKhozenCommonConstants.KINOUID_HARAIKATAHENKOU.equals(pKhozenCommonParam.getFunctionId())) {

            IT_BAK_KykKihon bakKykKihon = null;

            if (C_KinouKbn.ONLINE.eq(kinouKbn)) {

                bakKykKihon = pBakKykKihon;
            }
            else {

                bakKykKihon = pKhozenCommonParam.getBatchBakKykKihon();
            }

            bakKykSyouhnList = bakKykKihon.getBAKKykSyouhns();
        }

        IT_AnsyuKihon ansyuKihon = null;

        if (C_KinouKbn.ONLINE.eq(kinouKbn)) {

            ansyuKihon = hozenDomManager.getAnsyuKihon(pSyoNo);
        }
        else {

            ansyuKihon = pKhozenCommonParam.getBatchAnsyuKihon();
        }

        IT_KykSya kykSya = kykKihon.getKykSya();

        BizDate syoriYmd;
        BizDate kwsRateKjYmd;

        if (batchSyoriYmd == null) {
            syoriYmd = BizDate.getSysDate();
        }
        else {
            syoriYmd = batchSyoriYmd;
        }

        if (C_TsrysyoriKbn.SINKEIYAKUSEIRITU.eq(pTsrySyoriKbn)) {
            List<IT_NyknJissekiRireki> nyknJissekiRirekiLst = kykKihon.getNyknJissekiRirekisByNykkeiro(C_Nykkeiro.SKEI);

            if (nyknJissekiRirekiLst == null || nyknJissekiRirekiLst.size() == 0) {
                throw new CommonBizAppException ("入金実績履歴情報取得に失敗しました。" + "証券番号：" + pSyoNo);
            }

            kwsRateKjYmd = nyknJissekiRirekiLst.get(0).getRyosyuymd();
        }
        else {
            kwsRateKjYmd = syoriYmd;
        }

        Integer renNoMAX = null;
        List<IT_Tesuuryou>  tesuuryouLst = kykKihon.getTesuuryous();
        if (!tesuuryouLst.isEmpty()) {
            SortIT_Tesuuryou tesuuryouForSort = SWAKInjector.getInstance(SortIT_Tesuuryou.class);
            List<IT_Tesuuryou>  tesuuryouLstSort  = tesuuryouForSort.OrderIT_TesuuryouByRennoDesc(tesuuryouLst);
            renNoMAX = tesuuryouLstSort.get(0).getRenno();
        }

        int renNo = 0;

        if (renNoMAX == null) {

            renNo = 1;
        }
        else {

            renNo = renNoMAX + 1;
        }

        String systemDateTime = BizDate.getSysDateTimeMilli();

        IT_Tesuuryou tesuuryou = kykKihon.createTesuuryou();

        tesuuryou.setTsrysyorikbn(pTsrySyoriKbn);

        tesuuryou.setRenno(renNo);

        tesuuryou.setSyoriYmd(syoriYmd);

        tesuuryou.setKouryokuhasseiym(pKouryokuHasseiYM);

        tesuuryou.setNyknkaisuuy(pNyknKaisuuY);

        tesuuryou.setNyknkaisuum(pNyknKaisuuM);

        if(pMikeikaP.compareTo(BizCurrency.valueOf(0,pMikeikaP.getType())) > 0){
            if(C_TsrysyoriKbn.KAIYAKU.eq(pTsrySyoriKbn)
                || C_TsrysyoriKbn.SEIRITUGOFSTPNYUUKIN.eq(pTsrySyoriKbn)
                || C_TsrysyoriKbn.PMEN.eq(pTsrySyoriKbn)
                || C_TsrysyoriKbn.SIBOU.eq(pTsrySyoriKbn)
                || C_TsrysyoriKbn.KOUDOSYOUGAI.eq(pTsrySyoriKbn)
                || C_TsrysyoriKbn.GENGAKU.eq(pTsrySyoriKbn)
                || C_TsrysyoriKbn.CLGOFF.eq(pTsrySyoriKbn)
                || C_TsrysyoriKbn.KEIYAKUTORIKESI.eq(pTsrySyoriKbn)
                || C_TsrysyoriKbn.MUKOU.eq(pTsrySyoriKbn)
                || C_TsrysyoriKbn.KAIJO.eq(pTsrySyoriKbn)){

                tesuuryou.setMikeikapariflg(C_UmuKbn.ARI);
            }else{

                tesuuryou.setMikeikapariflg(C_UmuKbn.NONE);
            }
        }else{
            tesuuryou.setMikeikapariflg(C_UmuKbn.NONE);
        }

        tesuuryou.setMisyuupariflg(C_UmuKbn.NONE);

        tesuuryou.setMikeikap(pMikeikaP);

        tesuuryou.setIktp(pIktP);

        tesuuryou.setSeisekiym(kykKihon.getSeisekiym());

        tesuuryou.setHrkkaisuu(kykKihon.getHrkkaisuu());

        tesuuryou.setHrkkeiro(kykKihon.getHrkkeiro());

        tesuuryou.setHrkp(kykKihon.getHrkp());

        if (ansyuKihon != null) {

            tesuuryou.setJkipjytym(ansyuKihon.getJkipjytym());
        }

        tesuuryou.setHaitounendo(kykKihon.getHaitounendo());

        tesuuryou.setCifcd(kykKihon.getCifcd());

        tesuuryou.setSmbckanriid(kykKihon.getSmbckanriid());

        tesuuryou.setBoskykjyoutai(kykKihon.getBoskykjyoutai());

        if (kykSya != null) {

            tesuuryou.setKyknmkj(kykSya.getKyknmkj());
        }

        tesuuryou.setBosyuuym(kykKihon.getBosyuuym());

        tesuuryou.setNyknymd(pNyknYMD);

        tesuuryou.setYenkansantkykwsrateymd(kwsRateKjYmd);

        tesuuryou.setTikiktbrisyuruikbn(kykKihon.getTikiktbrisyuruikbn());

        tesuuryou.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());

        tesuuryou.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());

        tesuuryou.setGyoumuKousinTime(systemDateTime);

        BizPropertyInitializer.initialize(tesuuryou);

        for (IT_KykSyouhn kykSyouhn : kykSyouhnList) {

            IT_TesuuryouSyouhn tesuuryouSyouhn = tesuuryou.createTesuuryouSyouhn();

            tesuuryouSyouhn.setSyutkkbn(kykSyouhn.getSyutkkbn());

            tesuuryouSyouhn.setSyouhncd(kykSyouhn.getSyouhncd());

            tesuuryouSyouhn.setSyouhnsdno(kykSyouhn.getSyouhnsdno());

            tesuuryouSyouhn.setKyksyouhnrenno(kykSyouhn.getKyksyouhnrenno());

            tesuuryouSyouhn.setHenkousikibetukey(pKhozenCommonParam.getSikibetuKey(pSyoNo));

            tesuuryouSyouhn.setYuukousyoumetukbn(kykSyouhn.getYuukousyoumetukbn());

            tesuuryouSyouhn.setKykjyoutai(kykSyouhn.getKykjyoutai());

            tesuuryouSyouhn.setSyoumetujiyuu(kykSyouhn.getSyoumetujiyuu());

            if (C_TsrysyoriKbn.KAIYAKU.eq(tesuuryou.getTsrysyorikbn()) &&
                kykSyouhn.getSyoumetuymd().compareTo(kykSyouhn.getKykymd()) < 0) {

                tesuuryouSyouhn.setSyoumetuymd(kykSyouhn.getKykymd());
            }
            else {

                tesuuryouSyouhn.setSyoumetuymd(kykSyouhn.getSyoumetuymd());
            }

            tesuuryouSyouhn.setKouryokuhasseiymd(kykSyouhn.getKouryokuhasseiymd());

            tesuuryouSyouhn.setKykymd(kykSyouhn.getKykymd());

            tesuuryouSyouhn.setSknnkaisiymd(kykSyouhn.getSknnkaisiymd());

            tesuuryouSyouhn.setHknkknsmnkbn(kykSyouhn.getHknkknsmnkbn());

            tesuuryouSyouhn.setHknkkn(kykSyouhn.getHknkkn());

            tesuuryouSyouhn.setHrkkknsmnkbn(kykSyouhn.getHrkkknsmnkbn());

            tesuuryouSyouhn.setHrkkkn(kykSyouhn.getHrkkkn());

            tesuuryouSyouhn.setKyknen(kykSyouhn.getKyknen());

            tesuuryouSyouhn.setHhknnen(kykSyouhn.getHhknnen());

            tesuuryouSyouhn.setHhknseiymd(kykSyouhn.getHhknseiymd());

            tesuuryouSyouhn.setHhknsei(kykSyouhn.getHhknsei());

            tesuuryouSyouhn.setHaraimanymd(kykSyouhn.getHaraimanymd());

            tesuuryouSyouhn.setHknkknmanryouymd(kykSyouhn.getHknkknmanryouymd());

            tesuuryouSyouhn.setKatakbn(kykSyouhn.getKatakbn());

            tesuuryouSyouhn.setKyhgndkatakbn(kykSyouhn.getKyhgndkatakbn());

            tesuuryouSyouhn.setSyukyhkinkatakbn(kykSyouhn.getSyukyhkinkatakbn());

            tesuuryouSyouhn.setKhnkyhkgbairitukbn(kykSyouhn.getKhnkyhkgbairitukbn());

            tesuuryouSyouhn.setRokudaildkbn(kykSyouhn.getRokudaildkbn());

            tesuuryouSyouhn.setPmnjtkkbn(kykSyouhn.getPmnjtkkbn());

            tesuuryouSyouhn.setKihons(kykSyouhn.getKihons());

            tesuuryouSyouhn.setHokenryou(kykSyouhn.getHokenryou());

            tesuuryouSyouhn.setKyktuukasyu(kykSyouhn.getKyktuukasyu());

            tesuuryouSyouhn.setRyouritusdno(kykSyouhn.getRyouritusdno());

            tesuuryouSyouhn.setYoteiriritu(kykSyouhn.getYoteiriritu());

            tesuuryouSyouhn.setYoteirrthendohosyurrt(kykSyouhn.getYoteirrthendohosyurrt());

            tesuuryouSyouhn.setYtirrthndmnskaisuu(kykSyouhn.getYtirrthndmnskaisuu());

            tesuuryouSyouhn.setKyksjkkktyouseiriritu(kykSyouhn.getKyksjkkktyouseiriritu());

            tesuuryouSyouhn.setNksyukbn(kykSyouhn.getNksyukbn());

            tesuuryouSyouhn.setNenkinkkn(kykSyouhn.getNenkinkkn());

            tesuuryouSyouhn.setNkgnshosyouritu(kykSyouhn.getNkgnshosyouritu());

            tesuuryouSyouhn.setNkgnshosyougk(kykSyouhn.getNkgnshosyougk());

            tesuuryouSyouhn.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());

            tesuuryouSyouhn.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());

            tesuuryouSyouhn.setGyoumuKousinTime(systemDateTime);

            BizPropertyInitializer.initialize(tesuuryouSyouhn);
        }

        for (IT_BAK_KykSyouhn bakKykSyouhn : bakKykSyouhnList) {

            IT_TesuuryouSyouhnRireki tesuuryouSyouhnRireki = tesuuryou.createTesuuryouSyouhnRireki();

            tesuuryouSyouhnRireki.setSyutkkbn(bakKykSyouhn.getSyutkkbn());

            tesuuryouSyouhnRireki.setSyouhncd(bakKykSyouhn.getSyouhncd());

            tesuuryouSyouhnRireki.setSyouhnsdno(bakKykSyouhn.getSyouhnsdno());

            tesuuryouSyouhnRireki.setKyksyouhnrenno(bakKykSyouhn.getKyksyouhnrenno());

            tesuuryouSyouhnRireki.setHenkousikibetukey(bakKykSyouhn.getHenkousikibetukey());

            tesuuryouSyouhnRireki.setYuukousyoumetukbn(bakKykSyouhn.getYuukousyoumetukbn());

            tesuuryouSyouhnRireki.setKykjyoutai(bakKykSyouhn.getKykjyoutai());

            tesuuryouSyouhnRireki.setSyoumetujiyuu(bakKykSyouhn.getSyoumetujiyuu());

            tesuuryouSyouhnRireki.setSyoumetuymd(bakKykSyouhn.getSyoumetuymd());

            tesuuryouSyouhnRireki.setKouryokuhasseiymd(bakKykSyouhn.getKouryokuhasseiymd());

            tesuuryouSyouhnRireki.setKykymd(bakKykSyouhn.getKykymd());

            tesuuryouSyouhnRireki.setSknnkaisiymd(bakKykSyouhn.getSknnkaisiymd());

            tesuuryouSyouhnRireki.setHknkknsmnkbn(bakKykSyouhn.getHknkknsmnkbn());

            tesuuryouSyouhnRireki.setHknkkn(bakKykSyouhn.getHknkkn());

            tesuuryouSyouhnRireki.setHrkkknsmnkbn(bakKykSyouhn.getHrkkknsmnkbn());

            tesuuryouSyouhnRireki.setHrkkkn(bakKykSyouhn.getHrkkkn());

            tesuuryouSyouhnRireki.setKyknen(bakKykSyouhn.getKyknen());

            tesuuryouSyouhnRireki.setHhknnen(bakKykSyouhn.getHhknnen());

            tesuuryouSyouhnRireki.setHhknseiymd(bakKykSyouhn.getHhknseiymd());

            tesuuryouSyouhnRireki.setHhknsei(bakKykSyouhn.getHhknsei());

            tesuuryouSyouhnRireki.setHaraimanymd(bakKykSyouhn.getHaraimanymd());

            tesuuryouSyouhnRireki.setHknkknmanryouymd(bakKykSyouhn.getHknkknmanryouymd());

            tesuuryouSyouhnRireki.setKatakbn(bakKykSyouhn.getKatakbn());

            tesuuryouSyouhnRireki.setKyhgndkatakbn(bakKykSyouhn.getKyhgndkatakbn());

            tesuuryouSyouhnRireki.setSyukyhkinkatakbn(bakKykSyouhn.getSyukyhkinkatakbn());

            tesuuryouSyouhnRireki.setKhnkyhkgbairitukbn(bakKykSyouhn.getKhnkyhkgbairitukbn());

            tesuuryouSyouhnRireki.setRokudaildkbn(bakKykSyouhn.getRokudaildkbn());

            tesuuryouSyouhnRireki.setPmnjtkkbn(bakKykSyouhn.getPmnjtkkbn());

            tesuuryouSyouhnRireki.setKihons(bakKykSyouhn.getKihons());

            tesuuryouSyouhnRireki.setHokenryou(bakKykSyouhn.getHokenryou());

            tesuuryouSyouhnRireki.setKyktuukasyu(bakKykSyouhn.getKyktuukasyu());

            tesuuryouSyouhnRireki.setRyouritusdno(bakKykSyouhn.getRyouritusdno());

            tesuuryouSyouhnRireki.setYoteiriritu(bakKykSyouhn.getYoteiriritu());

            tesuuryouSyouhnRireki.setYoteirrthendohosyurrt(bakKykSyouhn.getYoteirrthendohosyurrt());

            tesuuryouSyouhnRireki.setYtirrthndmnskaisuu(bakKykSyouhn.getYtirrthndmnskaisuu());

            tesuuryouSyouhnRireki.setKyksjkkktyouseiriritu(bakKykSyouhn.getKyksjkkktyouseiriritu());

            tesuuryouSyouhnRireki.setNksyukbn(bakKykSyouhn.getNksyukbn());

            tesuuryouSyouhnRireki.setNenkinkkn(bakKykSyouhn.getNenkinkkn());

            tesuuryouSyouhnRireki.setNkgnshosyouritu(bakKykSyouhn.getNkgnshosyouritu());

            tesuuryouSyouhnRireki.setNkgnshosyougk(bakKykSyouhn.getNkgnshosyougk());

            tesuuryouSyouhnRireki.setGyoumuKousinKinou(pKhozenCommonParam.getFunctionId());

            tesuuryouSyouhnRireki.setGyoumuKousinsyaId(pKhozenCommonParam.getUserID());

            tesuuryouSyouhnRireki.setGyoumuKousinTime(systemDateTime);

            BizPropertyInitializer.initialize(tesuuryouSyouhnRireki);
        }

        logger.debug("△ 代理店手数料情報TBL編集 終了");
    }
}
