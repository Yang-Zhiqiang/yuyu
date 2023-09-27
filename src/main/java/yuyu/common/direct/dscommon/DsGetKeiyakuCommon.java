package yuyu.common.direct.dscommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.HanteiHokenKikan;
import yuyu.common.biz.bzcommon.HanteiHokenKikanBean;
import yuyu.common.hozen.khcommon.GetKhKykdrInfo;
import yuyu.common.hozen.khcommon.GetKhKykdrInfoBean;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_GkdtKoktuutiUktKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_TrkKzkKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.db.entity.IT_TrkKzk;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * ダイレクトサービス ダイレクトサービス共通  ＤＳ契約共通情報取得
 */
public class DsGetKeiyakuCommon {

    private List<UketoriKouzaBean> uketoriKouzaBeanList;

    @Inject
    private static Logger logger;

    @Inject
    private HozenDomManager hozenDomManager;

    public DsGetKeiyakuCommon(){
        super();
    }

    public List<UketoriKouzaBean> getUketoriKouzaBeanList() {
        return uketoriKouzaBeanList;
    }

    public KeiyakuKihonBean getKykKihon(String pSyoNo) {
        logger.debug("▽ 契約基本情報取得 開始");

        KeiyakuKihonBean keiyakuKihonBean = SWAKInjector.getInstance(KeiyakuKihonBean.class);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyoNo);
        keiyakuKihonBean.setErrorKbn(C_ErrorKbn.OK);

        if (kykKihon == null) {
            keiyakuKihonBean.setErrorKbn(C_ErrorKbn.ERROR);
            logger.debug("△ 契約基本情報取得 終了");

            return keiyakuKihonBean;
        }

        List<IT_KykSyouhn> kykSyouhnList = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        IT_KykSyouhn kykSyouhn = null;
        BM_SyouhnZokusei syouhnZokusei = null;
        if (kykSyouhnList != null && kykSyouhnList.size() > 0) {
            kykSyouhn = kykSyouhnList.get(0);
            syouhnZokusei = kykSyouhn.getSyouhnZokusei();
        }

        if (kykSyouhn == null || syouhnZokusei == null) {
            keiyakuKihonBean.setErrorKbn(C_ErrorKbn.ERROR);
            logger.debug("△ 契約基本情報取得 終了");

            return keiyakuKihonBean;
        }

        keiyakuKihonBean.setAisyoumeiKbn(kykKihon.getAisyoumeikbn());
        keiyakuKihonBean.setKykYmd(kykSyouhn.getKykymd());
        keiyakuKihonBean.setKykTuukasyu(kykSyouhn.getKyktuukasyu());
        keiyakuKihonBean.setSyouhnNm(syouhnZokusei.getSyouhnnmsyouken());
        keiyakuKihonBean.setSakuseiKijyunYmd(BizDate.getSysDate());
        keiyakuKihonBean.setYakkanBunsyoNo(kykKihon.getYakkanbunsyono());

        logger.debug("△ 契約基本情報取得 終了");

        return keiyakuKihonBean;

    }

    public KeiyakusyaBean getKykSya(String pSyoNo) {
        logger.debug("▽ 契約者情報取得 開始");

        KeiyakusyaBean keiyakusyaBean = SWAKInjector.getInstance(KeiyakusyaBean.class);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyoNo);
        keiyakusyaBean.setErrorKbn(C_ErrorKbn.OK);

        if (kykKihon == null) {
            keiyakusyaBean.setErrorKbn(C_ErrorKbn.ERROR);
            logger.debug("△ 契約者情報取得 終了");

            return keiyakusyaBean;
        }

        IT_KykSya kykSya = null;
        try{
            kykSya = kykKihon.getKykSya();
        }
        catch (EntityNotFoundException e) {
        }
        if (kykSya == null) {
            keiyakusyaBean.setErrorKbn(C_ErrorKbn.ERROR);
            logger.debug("△ 契約者情報取得 終了");

            return keiyakusyaBean;
        }

        keiyakusyaBean.setKykNmKn(kykSya.getKyknmkn());
        keiyakusyaBean.setKykNmKj(kykSya.getKyknmkj());
        keiyakusyaBean.setKykseiYmd(kykSya.getKykseiymd());
        keiyakusyaBean.setKyksei(kykSya.getKyksei());

        logger.debug("△ 契約者情報取得 終了");

        return keiyakusyaBean;
    }

    public HihokensyaBean getHhknSya(String pSyoNo) {
        logger.debug("▽ 被保険者情報取得 開始");

        HihokensyaBean hihokensyaBean = SWAKInjector.getInstance(HihokensyaBean.class);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyoNo);
        hihokensyaBean.setErrorKbn(C_ErrorKbn.OK);

        if (kykKihon == null) {
            hihokensyaBean.setErrorKbn(C_ErrorKbn.ERROR);
            logger.debug("△ 被保険者情報取得 終了");

            return hihokensyaBean;
        }

        IT_HhknSya hhknSya =null;
        try{
            hhknSya = kykKihon.getHhknSya();
        }
        catch (EntityNotFoundException e) {
        }
        if (hhknSya == null) {
            hihokensyaBean.setErrorKbn(C_ErrorKbn.ERROR);
            logger.debug("△ 被保険者情報取得 終了");

            return hihokensyaBean;
        }

        hihokensyaBean.setHhknNmKn(hhknSya.getHhknnmkn());
        hihokensyaBean.setHhknseiYmd(hhknSya.getHhknseiymd());

        logger.debug("△ 被保険者情報取得 終了");

        return hihokensyaBean;
    }

    public KeiyakuUketorininBean getKykUkt(String pSyoNo) {
        logger.debug("▽ 契約受取人情報取得 開始");

        KeiyakuUketorininBean keiyakuUketorininBean = SWAKInjector.getInstance(KeiyakuUketorininBean.class);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyoNo);
        keiyakuUketorininBean.setErrorKbn(C_ErrorKbn.OK);

        if (kykKihon == null) {
            keiyakuUketorininBean.setErrorKbn(C_ErrorKbn.ERROR);
            logger.debug("△ 契約受取人情報取得 終了");

            return keiyakuUketorininBean;
        }

        IT_KykSya kykSya = null;
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        try{
            kykSya = kykKihon.getKykSya();
            kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        }
        catch (EntityNotFoundException e) {
        }
        List<IT_KykUkt> kykUktList = kykKihon.getKykUkts();
        if (kykSya == null || kykSonotaTkyk == null) {
            keiyakuUketorininBean.setErrorKbn(C_ErrorKbn.ERROR);
            logger.debug("△ 契約受取人情報取得 終了");

            return keiyakuUketorininBean;
        }


        List<C_UktsyuKbn> uktsyuKbnList = new ArrayList<>();
        List<C_GkdtKoktuutiUktKbn> gkdtKoktuutiUktKbnList = new ArrayList<>();
        List<String> uktNmList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            uktsyuKbnList.add(C_UktsyuKbn.BLNK);
            gkdtKoktuutiUktKbnList.add(C_GkdtKoktuutiUktKbn.BLNK);
            uktNmList.add("");
        }

        int count = 0;
        String uktNmKn = "";
        int renNo = 0;


        for (IT_KykUkt kykUkt : kykUktList) {
            if (C_UktsyuKbn.SBUKT.eq(kykUkt.getUktsyukbn())) {
                uktNmKn = kykUkt.getUktnmkn();
                renNo = kykUkt.getUktsyurenno();
                break;
            }
        }

        for (IT_KykUkt kykUkt : kykUktList) {
            if (C_UktsyuKbn.SBUKT.eq(kykUkt.getUktsyukbn()) && kykUkt.getUktsyurenno() < renNo) {
                uktNmKn = kykUkt.getUktnmkn();
                renNo = kykUkt.getUktsyurenno();
            }
        }


        if (kykKihon.getSbuktnin() > 2) {
            uktsyuKbnList.set(count, C_UktsyuKbn.SBUKT);
            gkdtKoktuutiUktKbnList.set(count, C_GkdtKoktuutiUktKbn.SYOUKENGORAN);
            uktNmList.set(count, "");
            count = count + 1;
        }
        else if (kykKihon.getSbuktnin() == 2) {
            for (IT_KykUkt kykUkt : kykUktList) {
                if (C_UktsyuKbn.SBUKT.eq(kykUkt.getUktsyukbn())) {

                    uktsyuKbnList.set(count, C_UktsyuKbn.SBUKT);

                    if (C_UktKbn.KYK.eq(kykUkt.getUktkbn())) {
                        gkdtKoktuutiUktKbnList.set(count, C_GkdtKoktuutiUktKbn.KYK);
                        uktNmList.set(count, "");
                    }
                    else if (C_UktKbn.TOKUTEIMEIGI.eq(kykUkt.getUktkbn())) {
                        gkdtKoktuutiUktKbnList.set(count, C_GkdtKoktuutiUktKbn.TOKUTEIMEIGI);
                        uktNmList.set(count, kykUkt.getUktnmkn());
                    }
                    count = count + 1;
                }
            }
        }
        else {
            for (IT_KykUkt kykUkt : kykUktList) {
                if (C_UktsyuKbn.SBUKT.eq(kykUkt.getUktsyukbn())) {
                    uktsyuKbnList.set(count, C_UktsyuKbn.SBUKT);

                    if (C_UktKbn.KYK.eq(kykUkt.getUktkbn())) {
                        gkdtKoktuutiUktKbnList.set(count, C_GkdtKoktuutiUktKbn.KYK);
                        uktNmList.set(count, "");
                    }
                    else if (C_UktKbn.HHKN.eq(kykUkt.getUktkbn())) {
                        gkdtKoktuutiUktKbnList.set(count, C_GkdtKoktuutiUktKbn.HHKN);
                        uktNmList.set(count, "");
                    }
                    else if (C_UktKbn.SOUZOKUNIN.eq(kykUkt.getUktkbn())) {
                        gkdtKoktuutiUktKbnList.set(count, C_GkdtKoktuutiUktKbn.SOUZOKU);
                        uktNmList.set(count, "");
                    }
                    else if (C_UktKbn.TOKUTEIMEIGI.eq(kykUkt.getUktkbn())) {
                        gkdtKoktuutiUktKbnList.set(count, C_GkdtKoktuutiUktKbn.TOKUTEIMEIGI);
                        uktNmList.set(count, kykUkt.getUktnmkn());
                    }
                    count = count + 1;
                }
            }
        }


        for (IT_KykUkt kykUkt : kykUktList) {
            if (C_UktsyuKbn.NKUKT.eq(kykUkt.getUktsyukbn())) {
                uktsyuKbnList.set(count, C_UktsyuKbn.NKUKT);

                if (C_UktKbn.KYK.eq(kykUkt.getUktkbn())) {
                    gkdtKoktuutiUktKbnList.set(count, C_GkdtKoktuutiUktKbn.KYK);
                    uktNmList.set(count, "");
                }
                else if (C_UktKbn.HHKN.eq(kykUkt.getUktkbn())) {
                    gkdtKoktuutiUktKbnList.set(count, C_GkdtKoktuutiUktKbn.HHKN);
                    uktNmList.set(count, "");
                }
                count = count + 1;
            }
        }


        if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getKykdrtkykhukaumu())) {

            for (IT_KykUkt kykUkt : kykUktList) {
                if (C_UktsyuKbn.KYKDRN.eq(kykUkt.getUktsyukbn())) {
                    uktsyuKbnList.set(count,C_UktsyuKbn.KYKDRN);

                    if (C_UktKbn.NASI.eq(kykUkt.getUktkbn())) {
                        gkdtKoktuutiUktKbnList.set(count, C_GkdtKoktuutiUktKbn.NASI);
                        uktNmList.set(count, "");
                    }
                    else {
                        GetKhKykdrInfo getKhKykdrInfo = SWAKInjector.getInstance(GetKhKykdrInfo.class);
                        GetKhKykdrInfoBean getKhKykdrInfoBean = getKhKykdrInfo.exec(kykKihon);
                        String kkdairinmkn = getKhKykdrInfoBean.getKkdairinmKn();
                        gkdtKoktuutiUktKbnList.set(count, C_GkdtKoktuutiUktKbn.TOKUTEIMEIGI);
                        uktNmList.set(count, kkdairinmkn);
                    }
                    count = count + 1;
                }
            }
        }
        else {
            uktsyuKbnList.set(count, C_UktsyuKbn.KYKDRN);
            gkdtKoktuutiUktKbnList.set(count, C_GkdtKoktuutiUktKbn.NASI);
            uktNmList.set(count, "");
            count = count + 1;
        }


        if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getStdrsktkyhkumu())) {

            for (IT_KykUkt kykUkt : kykUktList) {
                if (C_UktsyuKbn.STDRSK.eq(kykUkt.getUktsyukbn())) {
                    uktsyuKbnList.set(count,C_UktsyuKbn.STDRSK);

                    if (C_UktKbn.KYK.eq(kykUkt.getUktkbn())) {
                        gkdtKoktuutiUktKbnList.set(count,C_GkdtKoktuutiUktKbn.TOKUTEIMEIGI);
                        uktNmList.set(count, kykSya.getKyknmkn());
                    }
                    else if (C_UktKbn.SBUK.eq(kykUkt.getUktkbn())) {
                        gkdtKoktuutiUktKbnList.set(count, C_GkdtKoktuutiUktKbn.TOKUTEIMEIGI);
                        uktNmList.set(count, uktNmKn);
                    }
                    else if (C_UktKbn.TOKUTEIMEIGI.eq(kykUkt.getUktkbn())) {
                        gkdtKoktuutiUktKbnList.set(count, C_GkdtKoktuutiUktKbn.TOKUTEIMEIGI);
                        uktNmList.set(count, kykUkt.getUktnmkn());
                    }
                    else if (C_UktKbn.TOUROKUKAZOKU1.eq(kykUkt.getUktkbn())) {
                        IT_TrkKzk trkKzk = kykKihon.getTrkKzkByTrkKzkKbn(C_TrkKzkKbn.TRKKZK1);
                        gkdtKoktuutiUktKbnList.set(count, C_GkdtKoktuutiUktKbn.TOKUTEIMEIGI);
                        uktNmList.set(count, trkKzk.getTrkkzknmkn());
                    }
                    else if (C_UktKbn.TOUROKUKAZOKU2.eq(kykUkt.getUktkbn())) {
                        IT_TrkKzk trkKzk = kykKihon.getTrkKzkByTrkKzkKbn(C_TrkKzkKbn.TRKKZK2);
                        gkdtKoktuutiUktKbnList.set(count, C_GkdtKoktuutiUktKbn.TOKUTEIMEIGI);
                        uktNmList.set(count, trkKzk.getTrkkzknmkn());
                    }
                    else if (C_UktKbn.NASI.eq(kykUkt.getUktkbn())) {
                        gkdtKoktuutiUktKbnList.set(count, C_GkdtKoktuutiUktKbn.NASI);
                        uktNmList.set(count, "");
                    }
                    count = count + 1;
                }
            }
        }
        else {
            uktsyuKbnList.set(count, C_UktsyuKbn.STDRSK);
            gkdtKoktuutiUktKbnList.set(count, C_GkdtKoktuutiUktKbn.NASI);
            uktNmList.set(count, "");
        }


        keiyakuUketorininBean.setSbuktnin(kykKihon.getSbuktnin());
        keiyakuUketorininBean.setUktsyuKbn1(uktsyuKbnList.get(0));
        keiyakuUketorininBean.setGkdtKoktuutiUktKbn1(gkdtKoktuutiUktKbnList.get(0));
        keiyakuUketorininBean.setUktNm1(uktNmList.get(0));
        keiyakuUketorininBean.setUktsyuKbn2(uktsyuKbnList.get(1));
        keiyakuUketorininBean.setGkdtKoktuutiUktKbn2(gkdtKoktuutiUktKbnList.get(1));
        keiyakuUketorininBean.setUktNm2(uktNmList.get(1));
        keiyakuUketorininBean.setUktsyuKbn3(uktsyuKbnList.get(2));
        keiyakuUketorininBean.setGkdtKoktuutiUktKbn3(gkdtKoktuutiUktKbnList.get(2));
        keiyakuUketorininBean.setUktNm3(uktNmList.get(2));
        keiyakuUketorininBean.setUktsyuKbn4(uktsyuKbnList.get(3));
        keiyakuUketorininBean.setGkdtKoktuutiUktKbn4(gkdtKoktuutiUktKbnList.get(3));
        keiyakuUketorininBean.setUktNm4(uktNmList.get(3));
        keiyakuUketorininBean.setUktsyuKbn5(uktsyuKbnList.get(4));
        keiyakuUketorininBean.setGkdtKoktuutiUktKbn5(gkdtKoktuutiUktKbnList.get(4));
        keiyakuUketorininBean.setUktNm5(uktNmList.get(4));
        keiyakuUketorininBean.setUktsyuKbn6(uktsyuKbnList.get(5));
        keiyakuUketorininBean.setGkdtKoktuutiUktKbn6(gkdtKoktuutiUktKbnList.get(5));
        keiyakuUketorininBean.setUktNm6(uktNmList.get(5));
        keiyakuUketorininBean.setUktsyuKbn7(uktsyuKbnList.get(6));
        keiyakuUketorininBean.setGkdtKoktuutiUktKbn7(gkdtKoktuutiUktKbnList.get(6));
        keiyakuUketorininBean.setUktNm7(uktNmList.get(6));
        keiyakuUketorininBean.setUktsyuKbn8(uktsyuKbnList.get(7));
        keiyakuUketorininBean.setGkdtKoktuutiUktKbn8(gkdtKoktuutiUktKbnList.get(7));
        keiyakuUketorininBean.setUktNm8(uktNmList.get(7));
        keiyakuUketorininBean.setUktsyuKbn9(uktsyuKbnList.get(8));
        keiyakuUketorininBean.setGkdtKoktuutiUktKbn9(gkdtKoktuutiUktKbnList.get(8));
        keiyakuUketorininBean.setUktNm9(uktNmList.get(8));
        keiyakuUketorininBean.setUktsyuKbn10(uktsyuKbnList.get(9));
        keiyakuUketorininBean.setGkdtKoktuutiUktKbn10(gkdtKoktuutiUktKbnList.get(9));
        keiyakuUketorininBean.setUktNm10(uktNmList.get(9));

        logger.debug("△ 契約受取人情報取得 終了");

        return keiyakuUketorininBean;
    }

    public TrkKazokuBean getTrkKazoku(String pSyoNo) {
        logger.debug("▽ 登録家族情報取得 開始");

        TrkKazokuBean trkKazokuBean = SWAKInjector.getInstance(TrkKazokuBean.class);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyoNo);
        trkKazokuBean.setErrorKbn(C_ErrorKbn.OK);

        if (kykKihon == null) {
            trkKazokuBean.setErrorKbn(C_ErrorKbn.ERROR);
            logger.debug("△ 登録家族情報取得 終了");

            return trkKazokuBean;
        }

        List<IT_TrkKzk> trkKzkList = kykKihon.getTrkKzks();


        C_UmuKbn trkkzkumuKbn1 = C_UmuKbn.NONE;
        C_TrkKzkKbn trkkzkKbn1 = C_TrkKzkKbn.TRKKZK1;
        BizDate trkkzksetteiYmd1 = null;
        String trkkzknmKn1 = "";
        String trkkzknmKj1 = "";
        C_KjkhukaKbn trkkzknmkjkhukaKbn1 = C_KjkhukaKbn.BLNK;
        BizDate trkkzkseiYmd1 = null;
        C_Seibetu trkkzkSei1 = C_Seibetu.BLNK;
        C_Tdk trkkzkTdk1 = C_Tdk.BLNK;
        String trkkzkYno1 = "";
        String trkkzkadr1Kj1 = "";
        String trkkzkadr2Kj1 = "";
        String trkkzkadr3Kj1 = "";
        String trkkzkTelno1 = "";
        String gyoumuKousinTime1 = "";
        C_UmuKbn trkkzkumuKbn2 = C_UmuKbn.NONE;
        C_TrkKzkKbn trkkzkKbn2 = C_TrkKzkKbn.TRKKZK2;
        BizDate trkkzksetteiYmd2 = null;
        String trkkzknmKn2 = "";
        String trkkzknmKj2 = "";
        C_KjkhukaKbn trkkzknmkjkhukaKbn2 = C_KjkhukaKbn.BLNK;
        BizDate trkkzkseiYmd2 = null;
        C_Seibetu trkkzkSei2 = C_Seibetu.BLNK;
        C_Tdk trkkzkTdk2 = C_Tdk.BLNK;
        String trkkzkYno2 = "";
        String trkkzkadr1Kj2 = "";
        String trkkzkadr2Kj2 = "";
        String trkkzkadr3Kj2 = "";
        String trkkzkTelno2 = "";
        String gyoumuKousinTime2 = "";

        for (IT_TrkKzk trkKzk : trkKzkList) {
            if (C_TrkKzkKbn.TRKKZK1.eq(trkKzk.getTrkkzkkbn())) {
                trkkzkumuKbn1 = C_UmuKbn.ARI;
                trkkzkKbn1 = C_TrkKzkKbn.TRKKZK1;
                trkkzksetteiYmd1 = trkKzk.getTrkkzksetteiymd();
                trkkzknmKn1 = trkKzk.getTrkkzknmkn();
                trkkzknmKj1 = trkKzk.getTrkkzknmkj();
                trkkzknmkjkhukaKbn1 = trkKzk.getTrkkzknmkjkhukakbn();
                trkkzkseiYmd1 = trkKzk.getTrkkzkseiymd();
                trkkzkSei1 = trkKzk.getTrkkzksei();
                trkkzkTdk1 = trkKzk.getTrkkzktdk();
                trkkzkYno1 = trkKzk.getTrkkzkyno();
                trkkzkadr1Kj1 = trkKzk.getTrkkzkadr1kj();
                trkkzkadr2Kj1 = trkKzk.getTrkkzkadr2kj();
                trkkzkadr3Kj1 = trkKzk.getTrkkzkadr3kj();
                trkkzkTelno1 = trkKzk.getTrkkzktelno();
                gyoumuKousinTime1 = trkKzk.getGyoumuKousinTime();
            }
            else if (C_TrkKzkKbn.TRKKZK2.eq(trkKzk.getTrkkzkkbn())) {
                trkkzkumuKbn2 = C_UmuKbn.ARI;
                trkkzkKbn2 = C_TrkKzkKbn.TRKKZK2;
                trkkzksetteiYmd2 = trkKzk.getTrkkzksetteiymd();
                trkkzknmKn2 = trkKzk.getTrkkzknmkn();
                trkkzknmKj2 = trkKzk.getTrkkzknmkj();
                trkkzknmkjkhukaKbn2 = trkKzk.getTrkkzknmkjkhukakbn();
                trkkzkseiYmd2 = trkKzk.getTrkkzkseiymd();
                trkkzkSei2 = trkKzk.getTrkkzksei();
                trkkzkTdk2 = trkKzk.getTrkkzktdk();
                trkkzkYno2 = trkKzk.getTrkkzkyno();
                trkkzkadr1Kj2 = trkKzk.getTrkkzkadr1kj();
                trkkzkadr2Kj2 = trkKzk.getTrkkzkadr2kj();
                trkkzkadr3Kj2 = trkKzk.getTrkkzkadr3kj();
                trkkzkTelno2 = trkKzk.getTrkkzktelno();
                gyoumuKousinTime2 = trkKzk.getGyoumuKousinTime();
            }
        }


        trkKazokuBean.setTrkkzkumuKbn1(trkkzkumuKbn1);
        trkKazokuBean.setTrkkzkKbn1(trkkzkKbn1);
        trkKazokuBean.setTrkkzksetteiYmd1(trkkzksetteiYmd1);
        trkKazokuBean.setTrkkzknmKn1(trkkzknmKn1);
        trkKazokuBean.setTrkkzknmKj1(trkkzknmKj1);
        trkKazokuBean.setTrkkzknmkjkhukaKbn1(trkkzknmkjkhukaKbn1);
        trkKazokuBean.setTrkkzkseiYmd1(trkkzkseiYmd1);
        trkKazokuBean.setTrkkzkSei1(trkkzkSei1);
        trkKazokuBean.setTrkkzkTdk1(trkkzkTdk1);
        trkKazokuBean.setTrkkzkYno1(trkkzkYno1);
        trkKazokuBean.setTrkkzkadr1Kj1(trkkzkadr1Kj1);
        trkKazokuBean.setTrkkzkadr2Kj1(trkkzkadr2Kj1);
        trkKazokuBean.setTrkkzkadr3Kj1(trkkzkadr3Kj1);
        trkKazokuBean.setTrkkzkTelno1(trkkzkTelno1);
        trkKazokuBean.setGyoumuKousinTime1(gyoumuKousinTime1);
        trkKazokuBean.setTrkkzkumuKbn2(trkkzkumuKbn2);
        trkKazokuBean.setTrkkzkKbn2(trkkzkKbn2);
        trkKazokuBean.setTrkkzksetteiYmd2(trkkzksetteiYmd2);
        trkKazokuBean.setTrkkzknmKn2(trkkzknmKn2);
        trkKazokuBean.setTrkkzknmKj2(trkkzknmKj2);
        trkKazokuBean.setTrkkzknmkjkhukaKbn2(trkkzknmkjkhukaKbn2);
        trkKazokuBean.setTrkkzkseiYmd2(trkkzkseiYmd2);
        trkKazokuBean.setTrkkzkSei2(trkkzkSei2);
        trkKazokuBean.setTrkkzkTdk2(trkkzkTdk2);
        trkKazokuBean.setTrkkzkYno2(trkkzkYno2);
        trkKazokuBean.setTrkkzkadr1Kj2(trkkzkadr1Kj2);
        trkKazokuBean.setTrkkzkadr2Kj2(trkkzkadr2Kj2);
        trkKazokuBean.setTrkkzkadr3Kj2(trkkzkadr3Kj2);
        trkKazokuBean.setTrkkzkTelno2(trkkzkTelno2);
        trkKazokuBean.setGyoumuKousinTime2(gyoumuKousinTime2);

        logger.debug("△ 登録家族情報取得 終了");

        return trkKazokuBean;

    }

    public C_ErrorKbn getUketoriKouza(String pSyoNo) {

        logger.debug("▽ 受取口座情報取得 開始");

        C_ErrorKbn kekkaKbn = C_ErrorKbn.OK;
        uketoriKouzaBeanList = new ArrayList<UketoriKouzaBean>();

        //        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyoNo);
        //        kekkaKbn = C_ErrorKbn.OK;
        //
        //        if (kykKihon == null) {
        //            kekkaKbn = C_ErrorKbn.ERROR;
        //            logger.debug("△ 受取口座情報取得 終了");
        //
        //            return kekkaKbn;
        //        }
        //
        //        IT_KykSonotaTkyk kykSonotaTkyk = null;
        //        try{
        //            kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        //        }
        //        catch (EntityNotFoundException e) {
        //        }
        //
        //        List<IT_KykUkt> kykUktList = kykKihon.getKykUkts();
        //
        //        if (kykUktList.size() == 0 || kykSonotaTkyk == null) {
        //            kekkaKbn = C_ErrorKbn.ERROR;
        //            logger.debug("△ 受取口座情報取得 終了");
        //
        //            return kekkaKbn;
        //        }

        C_UktsyuKbn uktsyuKbn = C_UktsyuKbn.BLNK;
        C_KouzasyuruiKbn kzsyuruiKbn = C_KouzasyuruiKbn.BLNK;
        String bankCd = "";
        String sitenCd = "";
        String bankNmkj = "";
        String sitenNmkj = "";
        C_YokinKbn yokinKbn = C_YokinKbn.BLNK;
        String kouzaNo = "";
        String kzmeigiNmkn = "";

        UketoriKouzaBean uketoriKouzaBean = SWAKInjector.getInstance(UketoriKouzaBean.class);

        uketoriKouzaBean.setUktsyuKbn(uktsyuKbn);
        uketoriKouzaBean.setKzsyuruiKbn(kzsyuruiKbn);
        uketoriKouzaBean.setBankCd(bankCd);
        uketoriKouzaBean.setSitenCd(sitenCd);
        uketoriKouzaBean.setBankNmkj(bankNmkj);
        uketoriKouzaBean.setSitenNmkj(sitenNmkj);
        uketoriKouzaBean.setYokinKbn(yokinKbn);
        uketoriKouzaBean.setKouzaNo(kouzaNo);
        uketoriKouzaBean.setKzmeigiNmkn(kzmeigiNmkn);

        uketoriKouzaBeanList.add(uketoriKouzaBean);

        //        if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getTeikishrtkykhukaumu())) {
        //            for (IT_KykUkt kykUkt: kykUktList) {
        //                if (C_UktsyuKbn.TKSHKUKT.eq(kykUkt.getUktsyukbn())) {
        //
        //                    IT_UketoriKouza uketoriKouza = kykKihon.getKykUktsByUktsyukbnUktsyurenno(
        //                        kykUkt.getUktsyukbn(), kykUkt.getUktsyurenno()).getUketoriKouza();
        //
        //                    if (uketoriKouza != null) {
        //
        //                        BzGetBankData getBankData = SWAKInjector.getInstance(BzGetBankData.class);
        //                        BzGetBankDataBean bankDataBean = getBankData.exec(uketoriKouza.getBankcd(), uketoriKouza.getSitencd());
        //
        //                        if (C_BankmasterUmuKbn.ARI.eq(bankDataBean.getBankmasterUmuKbn())) {
        //                            bankNmkj = bankDataBean.getBankNmKj();
        //                            sitenNmkj = bankDataBean.getSitenNmKj();
        //                        }
        //                        else {
        //                            bankNmkj = "金融機関コード" + uketoriKouza.getBankcd();
        //                            sitenNmkj = "支店コード" + uketoriKouza.getSitencd();
        //                        }
        //
        //                        UketoriKouzaBean uketoriKouzaBean = SWAKInjector.getInstance(UketoriKouzaBean.class);
        //
        //                        uketoriKouzaBean.setUktsyuKbn(uketoriKouza.getUktsyukbn());
        //                        uketoriKouzaBean.setKzsyuruiKbn(uketoriKouza.getKzsyuruikbn());
        //                        uketoriKouzaBean.setBankCd(uketoriKouza.getBankcd());
        //                        uketoriKouzaBean.setSitenCd(uketoriKouza.getSitencd());
        //                        uketoriKouzaBean.setBankNmkj(bankNmkj);
        //                        uketoriKouzaBean.setSitenNmkj(sitenNmkj);
        //                        uketoriKouzaBean.setYokinKbn(uketoriKouza.getYokinkbn());
        //                        uketoriKouzaBean.setKouzaNo(uketoriKouza.getKouzano());
        //                        uketoriKouzaBean.setKzmeigiNmkn(uketoriKouza.getKzmeiginmkn());
        //
        //                        uketoriKouzaBeanList.add(uketoriKouzaBean);
        //                    }
        //                }
        //            }
        //        }

        logger.debug("△ 受取口座情報取得 終了");

        return kekkaKbn;
    }

    public HokenKikanBean getHokenKikan(String pSyoNo) {

        logger.debug("▽ 保険期間情報取得 開始");

        HokenKikanBean hokenKikanBean = SWAKInjector.getInstance(HokenKikanBean.class);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyoNo);

        if (kykKihon == null) {
            hokenKikanBean.setErrorKbn(C_ErrorKbn.ERROR);
            logger.debug("△ 保険期間情報取得 終了");

            return hokenKikanBean;
        }

        List<IT_KykSyouhn> kykSyouhnList = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        IT_KykSyouhn kykSyouhn = null;
        BM_SyouhnZokusei syouhnZokusei = null;
        if (kykSyouhnList != null && kykSyouhnList.size() > 0) {
            kykSyouhn = kykSyouhnList.get(0);
            syouhnZokusei = kykSyouhn.getSyouhnZokusei();
        }

        if (kykSyouhn == null || syouhnZokusei == null) {
            hokenKikanBean.setErrorKbn(C_ErrorKbn.ERROR);
            logger.debug("△ 保険期間情報取得 終了");

            return hokenKikanBean;
        }

        HanteiHokenKikan hanteiHokenKikan = SWAKInjector.getInstance(HanteiHokenKikan.class);
        HanteiHokenKikanBean hanteiHokenKikanBean = SWAKInjector.getInstance(HanteiHokenKikanBean.class);

        hanteiHokenKikanBean.setKykYmd(kykSyouhn.getKykymd());
        hanteiHokenKikanBean.setCalcKijyunYmd(BizDate.getSysDate());
        hanteiHokenKikanBean.setSyouhnZokusei(syouhnZokusei);
        hanteiHokenKikanBean.setDai1hknkkn(kykSyouhn.getDai1hknkkn());

        hanteiHokenKikan.exec(hanteiHokenKikanBean);

        BizDate hknkknKaisiymd2 = hanteiHokenKikan.getDai2HknkknStartYmd();

        BizDate hknkknmanryouymd1 = null;
        BizDate hknkknmanryouymd2 = null;

        if (hknkknKaisiymd2 != null) {
            hknkknmanryouymd1 = hknkknKaisiymd2.addDays(-1);

            hknkknmanryouymd2 = BizDate.valueOf("99991231");
        }

        hokenKikanBean.setErrorKbn(C_ErrorKbn.OK);
        hokenKikanBean.setHknkknkaisiymd1(kykSyouhn.getKykymd());
        hokenKikanBean.setHknkknmanryouymd1(hknkknmanryouymd1);
        hokenKikanBean.setDai1hknkkn(kykSyouhn.getDai1hknkkn());
        hokenKikanBean.setHknkknkaisiymd2(hknkknKaisiymd2);
        hokenKikanBean.setHknkknmanryouymd2(hknkknmanryouymd2);

        logger.debug("△ 保険期間情報取得 終了");

        return hokenKikanBean;
    }
}
