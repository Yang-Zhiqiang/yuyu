package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.base.format.DefaultDateFormatter;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.khcommon.dba4editkoujyonaiyoutblzeiteki.EditKoujyonaiyouTblZeitekiDao;
import yuyu.def.MessageId;
import yuyu.def.classification.C_ChkkekkaKbn;
import yuyu.def.classification.C_Delflag;
import yuyu.def.classification.C_DispKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Kjsmhakkouzumiflg;
import yuyu.def.classification.C_KoujyosymnaiyourecKbn;
import yuyu.def.classification.C_KoujyosyoumeipKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_ZeitekiHenkouSyoriKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_AnsyuKihon;
import yuyu.def.db.entity.IT_KihrkmpSeisanRireki;
import yuyu.def.db.entity.IT_KoujyoSymKanri;
import yuyu.def.db.entity.IT_KoujyoSymNaiyou;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykSyouhnRireki;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 契約保全 契約保全共通 税適特約変更時控除証明内容TBL編集
 *
 */
public class EditKoujyonaiyouTblZeiteki {

    private List<String> messageLst = null;

    private List<String> messageIdLst = null;

    @Inject
    private static Logger logger;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private EditKoujyonaiyouTblZeitekiDao editKoujyonaiyouTblZeitekiDao;

    @Inject
    private AS_Kinou kinou;

    @Inject
    private BaseUserInfo baseUserInfo;

    public List<String> getMessageLst() {
        return messageLst;
    }

    public List<String> getMessageIdLst() {
        return messageIdLst;
    }

    public C_ChkkekkaKbn exec(String pSyono, BizDate pZeitekihenkoYmd, C_ZeitekiHenkouSyoriKbn pZeitekiHenkouSyoriKbn) {

        logger.debug("▽ 税適特約変更時控除証明内容TBL編集 開始");

        messageLst = new ArrayList<>();
        messageIdLst = new ArrayList<>();
        C_ChkkekkaKbn chkkekkakbn = C_ChkkekkaKbn.SEIJYOU;
        String sysTime = BizDate.getSysDateTimeMilli();

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);
        if (kykKihon == null) {
            throw new CommonBizAppException("契約基本テーブルが取得できませんでした。 証券番号 ＝" + pSyono);
        }

        IT_AnsyuKihon ansyuKihon = hozenDomManager.getAnsyuKihon(pSyono);
        if (ansyuKihon == null) {
            throw new CommonBizAppException("案内収納基本テーブルが取得できませんでした。 証券番号 ＝" + pSyono);
        }

        List<IT_KykSyouhn> kykSyouhnList = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        if (kykSyouhnList.size() == 0) {
            throw new CommonBizAppException("契約商品テーブルが取得できませんでした。 証券番号 ＝ " + pSyono);
        }

        BM_SyouhnZokusei syouhnZokusei = kykSyouhnList.get(0).getSyouhnZokusei();
        if (syouhnZokusei == null) {
            throw new CommonBizAppException("商品属性マスタが取得できませんでした。 証券番号 ＝ " + pSyono);
        }

        if (!C_Hrkkaisuu.TUKI.eq(kykKihon.getHrkkaisuu())) {
            logger.debug("△ 税適特約変更時控除証明内容TBL編集 終了");

            return chkkekkakbn;
        }

        BizDateYM zeitekihenkoYm = pZeitekihenkoYmd.getBizDateYM();
        List<IT_KoujyoSymNaiyou> koujyoSymNaiyouList =
            editKoujyonaiyouTblZeitekiDao.getKoujyoSymNaiyouZtkSyori(zeitekihenkoYm, kykKihon);

        C_KoujyosyoumeipKbn koujyosyoumeipkbn = null;

        if (C_ZeitekiHenkouSyoriKbn.HUKA.eq(pZeitekiHenkouSyoriKbn)) {
            koujyosyoumeipkbn = C_KoujyosyoumeipKbn.NENKIN;
        }
        else {
            koujyosyoumeipkbn = syouhnZokusei.getKoujyosyoumeipkbn();
        }

        Map<String, Integer> rennoMap = new HashMap<>();
        Integer newRenno = 0;

        BizCurrency koujoshoumeigakuZen = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency koujoshoumeigakuAto = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        BizCurrency koujyosyoumeigkBkfy = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

        for (IT_KoujyoSymNaiyou koujyoSymNaiyou : koujyoSymNaiyouList) {

            IT_Zennou zennouEntity = editKoujyonaiyouTblZeitekiDao.getZennou(
                pSyono, koujyoSymNaiyou.getZennoukaisiymd(), koujyoSymNaiyou.getZennourenno());

            if (zennouEntity == null) {

                newRenno = getRenno(rennoMap, pSyono, koujyoSymNaiyou.getSyouhncd());

                if (BizDateUtil.compareYm(koujyoSymNaiyou.getSyoumeistartym(), zeitekihenkoYm) == BizDateUtil.COMPARE_LESSER) {

                    int jyutouTukisu = koujyoSymNaiyou.getSyoumeiendym().subtractMonths(koujyoSymNaiyou.getSyoumeistartym()) + 1;

                    int zeitekihenkozenTukisu = zeitekihenkoYm.subtractMonths(koujyoSymNaiyou.getSyoumeistartym());

                    BizCurrency hyoteiP = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);

                    if (koujyoSymNaiyou.getKoujyosyoumeigk().remainder(jyutouTukisu).equalsValue(
                        BizCurrency.valueOf(0, BizCurrencyTypes.YEN))) {
                        hyoteiP = koujyoSymNaiyou.getKoujyosyoumeigk().divide(jyutouTukisu);
                    }
                    else {
                        throw new CommonBizAppException("税適特約変更時控除証明内容TBL編集エラー　表定Ｐ計算不能");
                    }

                    koujoshoumeigakuZen = hyoteiP.multiply(zeitekihenkozenTukisu);

                    koujoshoumeigakuAto = koujyoSymNaiyou.getKoujyosyoumeigk().subtract(koujoshoumeigakuZen);

                    IT_KoujyoSymNaiyou koujyoSymNaiyouZenEntity = kykKihon.createKoujyoSymNaiyou();

                    koujyoSymNaiyouZenEntity.setSyouhncd(koujyoSymNaiyou.getSyouhncd());
                    koujyoSymNaiyouZenEntity.setRenno3keta(newRenno);
                    koujyoSymNaiyouZenEntity.setKoujyosyoumeinnd(koujyoSymNaiyou.getKoujyosyoumeinnd());
                    koujyoSymNaiyouZenEntity.setSyoumeistartym(koujyoSymNaiyou.getSyoumeistartym());
                    koujyoSymNaiyouZenEntity.setSyoumeiendym(zeitekihenkoYm.getPreviousMonth());
                    koujyoSymNaiyouZenEntity.setKoujyosyoumeipkbn(koujyoSymNaiyou.getKoujyosyoumeipkbn());
                    koujyoSymNaiyouZenEntity.setTekiyouseidokbn(koujyoSymNaiyou.getTekiyouseidokbn());
                    koujyoSymNaiyouZenEntity.setKoujyosymnaiyoureckbn(koujyoSymNaiyou.getKoujyosymnaiyoureckbn());
                    koujyoSymNaiyouZenEntity.setKoujyosyoumeigk(koujoshoumeigakuZen);
                    koujyoSymNaiyouZenEntity.setJyutoustartym(koujyoSymNaiyou.getJyutoustartym());
                    koujyoSymNaiyouZenEntity.setNyknjskrrkrenno(koujyoSymNaiyou.getNyknjskrrkrenno());
                    koujyoSymNaiyouZenEntity.setKihrkpssrrkrenno(koujyoSymNaiyou.getKihrkpssrrkrenno());
                    koujyoSymNaiyouZenEntity.setKjsmhakkouzumiflg(C_Kjsmhakkouzumiflg.BLNK);
                    koujyoSymNaiyouZenEntity.setGyoumuKousinKinou(kinou.getKinouId());
                    koujyoSymNaiyouZenEntity.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                    koujyoSymNaiyouZenEntity.setGyoumuKousinTime(sysTime);
                    koujyoSymNaiyouZenEntity.setSakujyoflg(C_Delflag.BLNK);
                    koujyoSymNaiyouZenEntity.setZennoukaisiymd(koujyoSymNaiyou.getZennoukaisiymd());
                    koujyoSymNaiyouZenEntity.setZennourenno(koujyoSymNaiyou.getZennourenno());
                    koujyoSymNaiyouZenEntity.setKeisanhukahyoujikbn(C_DispKbn.HIHYOUJI);
                    koujyoSymNaiyouZenEntity.setKeisanhukariyuucd("");

                    BizPropertyInitializer.initialize(koujyoSymNaiyouZenEntity);

                    IT_KoujyoSymNaiyou koujyoSymNyatoEntity = kykKihon.createKoujyoSymNaiyou();

                    koujyoSymNyatoEntity.setSyouhncd(koujyoSymNaiyou.getSyouhncd());
                    koujyoSymNyatoEntity.setRenno3keta(newRenno + 1);
                    koujyoSymNyatoEntity.setKoujyosyoumeinnd(koujyoSymNaiyou.getKoujyosyoumeinnd());
                    koujyoSymNyatoEntity.setSyoumeistartym(zeitekihenkoYm);
                    koujyoSymNyatoEntity.setSyoumeiendym(koujyoSymNaiyou.getSyoumeiendym());
                    koujyoSymNyatoEntity.setKoujyosyoumeipkbn(koujyosyoumeipkbn);
                    koujyoSymNyatoEntity.setTekiyouseidokbn(koujyoSymNaiyou.getTekiyouseidokbn());
                    koujyoSymNyatoEntity.setKoujyosymnaiyoureckbn(koujyoSymNaiyou.getKoujyosymnaiyoureckbn());
                    koujyoSymNyatoEntity.setKoujyosyoumeigk(koujoshoumeigakuAto);
                    koujyoSymNyatoEntity.setJyutoustartym(koujyoSymNaiyou.getJyutoustartym());
                    koujyoSymNyatoEntity.setNyknjskrrkrenno(koujyoSymNaiyou.getNyknjskrrkrenno());
                    koujyoSymNyatoEntity.setKihrkpssrrkrenno(koujyoSymNaiyou.getKihrkpssrrkrenno());
                    koujyoSymNyatoEntity.setKjsmhakkouzumiflg(C_Kjsmhakkouzumiflg.BLNK);
                    koujyoSymNyatoEntity.setGyoumuKousinKinou(kinou.getKinouId());
                    koujyoSymNyatoEntity.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                    koujyoSymNyatoEntity.setGyoumuKousinTime(sysTime);
                    koujyoSymNyatoEntity.setSakujyoflg(C_Delflag.BLNK);
                    koujyoSymNyatoEntity.setZennoukaisiymd(koujyoSymNaiyou.getZennoukaisiymd());
                    koujyoSymNyatoEntity.setZennourenno(koujyoSymNaiyou.getZennourenno());
                    koujyoSymNyatoEntity.setKeisanhukahyoujikbn(C_DispKbn.HIHYOUJI);
                    koujyoSymNyatoEntity.setKeisanhukariyuucd("");

                    BizPropertyInitializer.initialize(koujyoSymNyatoEntity);

                    rennoMap.put(koujyoSymNaiyou.getSyouhncd(), newRenno + 2);
                }
                else {

                    koujyosyoumeigkBkfy = koujyoSymNaiyou.getKoujyosyoumeigk();

                    IT_KoujyoSymNaiyou koujyoSymNaiyouBkfyEntity = kykKihon.createKoujyoSymNaiyou();
                    koujyoSymNaiyouBkfyEntity.setSyouhncd(koujyoSymNaiyou.getSyouhncd());
                    koujyoSymNaiyouBkfyEntity.setRenno3keta(newRenno);
                    koujyoSymNaiyouBkfyEntity.setKoujyosyoumeinnd(koujyoSymNaiyou.getKoujyosyoumeinnd());
                    koujyoSymNaiyouBkfyEntity.setSyoumeistartym(koujyoSymNaiyou.getSyoumeistartym());
                    koujyoSymNaiyouBkfyEntity.setSyoumeiendym(koujyoSymNaiyou.getSyoumeiendym());
                    koujyoSymNaiyouBkfyEntity.setKoujyosyoumeipkbn(koujyosyoumeipkbn);
                    koujyoSymNaiyouBkfyEntity.setTekiyouseidokbn(koujyoSymNaiyou.getTekiyouseidokbn());
                    koujyoSymNaiyouBkfyEntity.setKoujyosymnaiyoureckbn(koujyoSymNaiyou.getKoujyosymnaiyoureckbn());
                    koujyoSymNaiyouBkfyEntity.setKoujyosyoumeigk(koujyosyoumeigkBkfy);
                    koujyoSymNaiyouBkfyEntity.setJyutoustartym(koujyoSymNaiyou.getJyutoustartym());
                    koujyoSymNaiyouBkfyEntity.setNyknjskrrkrenno(koujyoSymNaiyou.getNyknjskrrkrenno());
                    koujyoSymNaiyouBkfyEntity.setKihrkpssrrkrenno(koujyoSymNaiyou.getKihrkpssrrkrenno());
                    koujyoSymNaiyouBkfyEntity.setKjsmhakkouzumiflg(C_Kjsmhakkouzumiflg.BLNK);
                    koujyoSymNaiyouBkfyEntity.setGyoumuKousinKinou(kinou.getKinouId());
                    koujyoSymNaiyouBkfyEntity.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                    koujyoSymNaiyouBkfyEntity.setGyoumuKousinTime(sysTime);
                    koujyoSymNaiyouBkfyEntity.setSakujyoflg(C_Delflag.BLNK);
                    koujyoSymNaiyouBkfyEntity.setZennoukaisiymd(koujyoSymNaiyou.getZennoukaisiymd());
                    koujyoSymNaiyouBkfyEntity.setZennourenno(koujyoSymNaiyou.getZennourenno());
                    koujyoSymNaiyouBkfyEntity.setKeisanhukahyoujikbn(C_DispKbn.HIHYOUJI);
                    koujyoSymNaiyouBkfyEntity.setKeisanhukariyuucd("");

                    BizPropertyInitializer.initialize(koujyoSymNaiyouBkfyEntity);

                    rennoMap.put(koujyoSymNaiyou.getSyouhncd(), newRenno + 1);
                }

                koujyoSymNaiyou.setGyoumuKousinKinou(kinou.getKinouId());
                koujyoSymNaiyou.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                koujyoSymNaiyou.setGyoumuKousinTime(sysTime);
                koujyoSymNaiyou.setSakujyoflg(C_Delflag.SAKUJYO);
            }
            else {
                List<IT_KoujyoSymNaiyou> haibunZennouKoujyoSymNaiyouList =
                    editKoujyonaiyouTblZeitekiDao.getHaibunZennouKoujyoSymNaiyou(kykKihon,
                        koujyoSymNaiyou.getSyoumeistartym(),
                        koujyoSymNaiyou.getSyoumeiendym(),
                        koujyoSymNaiyou.getJyutoustartym(),
                        koujyoSymNaiyou.getNyknjskrrkrenno(),
                        koujyoSymNaiyou.getKihrkpssrrkrenno());

                if (C_KoujyosymnaiyourecKbn.HKRNK.eq(koujyoSymNaiyou.getKoujyosymnaiyoureckbn())) {

                    IT_NyknJissekiRireki nyknJissekiRireki = editKoujyonaiyouTblZeitekiDao.getNyknJissekiRireki(pSyono,
                        koujyoSymNaiyou.getJyutoustartym(),
                        koujyoSymNaiyou.getNyknjskrrkrenno());

                    List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
                    List<IT_KykSyouhn> kykSyouhnLst = editKoujyonaiyouTblZeitekiDao.getKykSyouhns(pSyono, nyknJissekiRireki.getHenkousikibetukey());
                    if (kykSyouhnLst != null) {
                        kykSyouhnCommonParamList.addAll(kykSyouhnLst);
                    }
                    List<IT_KykSyouhnRireki> kykSyouhnRirekiLst = editKoujyonaiyouTblZeitekiDao.getKykSyouhnRirekis(pSyono, nyknJissekiRireki.getHenkousikibetukey());
                    if (kykSyouhnRirekiLst != null) {
                        kykSyouhnCommonParamList.addAll(kykSyouhnRirekiLst);
                    }
                    BizCurrency haraikomihkr = nyknJissekiRireki.getHrkp();

                    if (BizDateUtil.compareYm(koujyoSymNaiyou.getSyoumeistartym(), zeitekihenkoYm) == BizDateUtil.COMPARE_LESSER) {

                        KhZennouKoujyogakuBean khZennouKoujyogakuZenBean = getZennouKoujyogakuBean(
                            zennouEntity.getKjsmyouzennounyuukinkgk(),
                            zennouEntity.getKjsmyouzennoukikanm(),
                            zennouEntity.getKjsmyouzennoukaisiymd(),
                            haraikomihkr,
                            nyknJissekiRireki.getHrkkaisuu(),
                            koujyoSymNaiyou.getSyoumeistartym(),
                            0,
                            zeitekihenkoYm.subtractMonths(koujyoSymNaiyou.getSyoumeistartym()),
                            koujyoSymNaiyou.getKoujyosyoumeipkbn(),
                            kykSyouhnCommonParamList);

                        KhZennouKoujyogakuBean KhZennouKoujyogakuAtoBean = getZennouKoujyogakuBean(
                            zennouEntity.getKjsmyouzennounyuukinkgk(),
                            zennouEntity.getKjsmyouzennoukikanm(),
                            zennouEntity.getKjsmyouzennoukaisiymd(),
                            haraikomihkr,
                            nyknJissekiRireki.getHrkkaisuu(),
                            zeitekihenkoYm,
                            0,
                            koujyoSymNaiyou.getSyoumeiendym().subtractMonths(zeitekihenkoYm) + 1,
                            koujyosyoumeipkbn,
                            kykSyouhnCommonParamList);

                        for (IT_KoujyoSymNaiyou haibunZennouKoujyoSymNaiyou : haibunZennouKoujyoSymNaiyouList) {

                            koujoshoumeigakuZen =  getSyohnZennouKoujyogaku(khZennouKoujyogakuZenBean,
                                kykSyouhnCommonParamList, haibunZennouKoujyoSymNaiyou.getSyouhncd());

                            koujoshoumeigakuAto =  getSyohnZennouKoujyogaku(KhZennouKoujyogakuAtoBean,
                                kykSyouhnCommonParamList, haibunZennouKoujyoSymNaiyou.getSyouhncd());

                            newRenno = getRenno(rennoMap, pSyono, haibunZennouKoujyoSymNaiyou.getSyouhncd());

                            IT_KoujyoSymNaiyou zennoKoujyoSymNaiyouZenEntity = kykKihon.createKoujyoSymNaiyou();

                            zennoKoujyoSymNaiyouZenEntity.setSyouhncd(haibunZennouKoujyoSymNaiyou.getSyouhncd());
                            zennoKoujyoSymNaiyouZenEntity.setRenno3keta(newRenno);
                            zennoKoujyoSymNaiyouZenEntity.setKoujyosyoumeinnd(haibunZennouKoujyoSymNaiyou.getKoujyosyoumeinnd());
                            zennoKoujyoSymNaiyouZenEntity.setSyoumeistartym(haibunZennouKoujyoSymNaiyou.getSyoumeistartym());
                            zennoKoujyoSymNaiyouZenEntity.setSyoumeiendym(zeitekihenkoYm.getPreviousMonth());
                            zennoKoujyoSymNaiyouZenEntity.setKoujyosyoumeipkbn(haibunZennouKoujyoSymNaiyou.getKoujyosyoumeipkbn());
                            zennoKoujyoSymNaiyouZenEntity.setTekiyouseidokbn(haibunZennouKoujyoSymNaiyou.getTekiyouseidokbn());
                            zennoKoujyoSymNaiyouZenEntity.setKoujyosymnaiyoureckbn(haibunZennouKoujyoSymNaiyou.getKoujyosymnaiyoureckbn());
                            zennoKoujyoSymNaiyouZenEntity.setKoujyosyoumeigk(koujoshoumeigakuZen);
                            zennoKoujyoSymNaiyouZenEntity.setJyutoustartym(haibunZennouKoujyoSymNaiyou.getJyutoustartym());
                            zennoKoujyoSymNaiyouZenEntity.setNyknjskrrkrenno(haibunZennouKoujyoSymNaiyou.getNyknjskrrkrenno());
                            zennoKoujyoSymNaiyouZenEntity.setKihrkpssrrkrenno(haibunZennouKoujyoSymNaiyou.getKihrkpssrrkrenno());
                            zennoKoujyoSymNaiyouZenEntity.setKjsmhakkouzumiflg(C_Kjsmhakkouzumiflg.BLNK);
                            zennoKoujyoSymNaiyouZenEntity.setGyoumuKousinKinou(kinou.getKinouId());
                            zennoKoujyoSymNaiyouZenEntity.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                            zennoKoujyoSymNaiyouZenEntity.setGyoumuKousinTime(sysTime);
                            zennoKoujyoSymNaiyouZenEntity.setSakujyoflg(C_Delflag.BLNK);
                            zennoKoujyoSymNaiyouZenEntity.setZennoukaisiymd(haibunZennouKoujyoSymNaiyou.getZennoukaisiymd());
                            zennoKoujyoSymNaiyouZenEntity.setZennourenno(haibunZennouKoujyoSymNaiyou.getZennourenno());
                            zennoKoujyoSymNaiyouZenEntity.setKeisanhukahyoujikbn(C_DispKbn.HIHYOUJI);
                            zennoKoujyoSymNaiyouZenEntity.setKeisanhukariyuucd("");

                            BizPropertyInitializer.initialize(zennoKoujyoSymNaiyouZenEntity);

                            IT_KoujyoSymNaiyou zennoKoujyoSymNaiyouAtoEntity = kykKihon.createKoujyoSymNaiyou();

                            zennoKoujyoSymNaiyouAtoEntity.setSyouhncd(haibunZennouKoujyoSymNaiyou.getSyouhncd());
                            zennoKoujyoSymNaiyouAtoEntity.setRenno3keta(newRenno + 1);
                            zennoKoujyoSymNaiyouAtoEntity.setKoujyosyoumeinnd(haibunZennouKoujyoSymNaiyou.getKoujyosyoumeinnd());
                            zennoKoujyoSymNaiyouAtoEntity.setSyoumeistartym(zeitekihenkoYm);
                            zennoKoujyoSymNaiyouAtoEntity.setSyoumeiendym(haibunZennouKoujyoSymNaiyou.getSyoumeiendym());

                            if (haibunZennouKoujyoSymNaiyou.getSyouhncd().equals(kykSyouhnList.get(0).getSyouhncd())) {
                                zennoKoujyoSymNaiyouAtoEntity.setKoujyosyoumeipkbn(koujyosyoumeipkbn);
                            }
                            else {
                                zennoKoujyoSymNaiyouAtoEntity.setKoujyosyoumeipkbn(haibunZennouKoujyoSymNaiyou.getKoujyosyoumeipkbn());
                            }

                            zennoKoujyoSymNaiyouAtoEntity.setTekiyouseidokbn(haibunZennouKoujyoSymNaiyou.getTekiyouseidokbn());
                            zennoKoujyoSymNaiyouAtoEntity.setKoujyosymnaiyoureckbn(haibunZennouKoujyoSymNaiyou.getKoujyosymnaiyoureckbn());
                            zennoKoujyoSymNaiyouAtoEntity.setKoujyosyoumeigk(koujoshoumeigakuAto);
                            zennoKoujyoSymNaiyouAtoEntity.setJyutoustartym(haibunZennouKoujyoSymNaiyou.getJyutoustartym());
                            zennoKoujyoSymNaiyouAtoEntity.setNyknjskrrkrenno(haibunZennouKoujyoSymNaiyou.getNyknjskrrkrenno());
                            zennoKoujyoSymNaiyouAtoEntity.setKihrkpssrrkrenno(haibunZennouKoujyoSymNaiyou.getKihrkpssrrkrenno());
                            zennoKoujyoSymNaiyouAtoEntity.setKjsmhakkouzumiflg(C_Kjsmhakkouzumiflg.BLNK);
                            zennoKoujyoSymNaiyouAtoEntity.setGyoumuKousinKinou(kinou.getKinouId());
                            zennoKoujyoSymNaiyouAtoEntity.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                            zennoKoujyoSymNaiyouAtoEntity.setGyoumuKousinTime(sysTime);
                            zennoKoujyoSymNaiyouAtoEntity.setSakujyoflg(C_Delflag.BLNK);
                            zennoKoujyoSymNaiyouAtoEntity.setZennoukaisiymd(haibunZennouKoujyoSymNaiyou.getZennoukaisiymd());
                            zennoKoujyoSymNaiyouAtoEntity.setZennourenno(haibunZennouKoujyoSymNaiyou.getZennourenno());
                            zennoKoujyoSymNaiyouAtoEntity.setKeisanhukahyoujikbn(C_DispKbn.HIHYOUJI);
                            zennoKoujyoSymNaiyouAtoEntity.setKeisanhukariyuucd("");

                            BizPropertyInitializer.initialize(zennoKoujyoSymNaiyouAtoEntity);

                            rennoMap.put(haibunZennouKoujyoSymNaiyou.getSyouhncd(), newRenno + 2);

                            haibunZennouKoujyoSymNaiyou.setGyoumuKousinKinou(kinou.getKinouId());
                            haibunZennouKoujyoSymNaiyou.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                            haibunZennouKoujyoSymNaiyou.setGyoumuKousinTime(sysTime);
                            haibunZennouKoujyoSymNaiyou.setSakujyoflg(C_Delflag.SAKUJYO);
                        }
                    }
                    else {

                        KhZennouKoujyogakuBean khZennouKoujyogakuBeanBkfy = getZennouKoujyogakuBean(
                            zennouEntity.getKjsmyouzennounyuukinkgk(),
                            zennouEntity.getKjsmyouzennoukikanm(),
                            zennouEntity.getKjsmyouzennoukaisiymd(),
                            nyknJissekiRireki.getHrkp(),
                            nyknJissekiRireki.getHrkkaisuu(),
                            koujyoSymNaiyou.getSyoumeistartym(),
                            0,
                            koujyoSymNaiyou .getSyoumeiendym().subtractMonths(koujyoSymNaiyou.getSyoumeistartym()) + 1,
                            koujyosyoumeipkbn,
                            kykSyouhnCommonParamList);

                        for (IT_KoujyoSymNaiyou haibunZennouKoujyoSymNaiyou : haibunZennouKoujyoSymNaiyouList) {

                            koujyosyoumeigkBkfy = getSyohnZennouKoujyogaku(khZennouKoujyogakuBeanBkfy,
                                kykSyouhnCommonParamList, haibunZennouKoujyoSymNaiyou.getSyouhncd());


                            newRenno = getRenno(rennoMap, pSyono, haibunZennouKoujyoSymNaiyou.getSyouhncd());

                            IT_KoujyoSymNaiyou zennoKoujyoSymNaiyouBkfyEntity = kykKihon.createKoujyoSymNaiyou();
                            zennoKoujyoSymNaiyouBkfyEntity.setSyouhncd(haibunZennouKoujyoSymNaiyou.getSyouhncd());
                            zennoKoujyoSymNaiyouBkfyEntity.setRenno3keta(newRenno);
                            zennoKoujyoSymNaiyouBkfyEntity.setKoujyosyoumeinnd(haibunZennouKoujyoSymNaiyou.getKoujyosyoumeinnd());
                            zennoKoujyoSymNaiyouBkfyEntity.setSyoumeistartym(haibunZennouKoujyoSymNaiyou.getSyoumeistartym());
                            zennoKoujyoSymNaiyouBkfyEntity.setSyoumeiendym(haibunZennouKoujyoSymNaiyou.getSyoumeiendym());

                            if (haibunZennouKoujyoSymNaiyou.getSyouhncd().equals(kykSyouhnList.get(0).getSyouhncd())) {
                                zennoKoujyoSymNaiyouBkfyEntity.setKoujyosyoumeipkbn(koujyosyoumeipkbn);
                            }
                            else {
                                zennoKoujyoSymNaiyouBkfyEntity.setKoujyosyoumeipkbn(haibunZennouKoujyoSymNaiyou.getKoujyosyoumeipkbn());
                            }

                            zennoKoujyoSymNaiyouBkfyEntity.setTekiyouseidokbn(haibunZennouKoujyoSymNaiyou.getTekiyouseidokbn());
                            zennoKoujyoSymNaiyouBkfyEntity.setKoujyosymnaiyoureckbn(haibunZennouKoujyoSymNaiyou.getKoujyosymnaiyoureckbn());
                            zennoKoujyoSymNaiyouBkfyEntity.setKoujyosyoumeigk(koujyosyoumeigkBkfy);
                            zennoKoujyoSymNaiyouBkfyEntity.setJyutoustartym(haibunZennouKoujyoSymNaiyou.getJyutoustartym());
                            zennoKoujyoSymNaiyouBkfyEntity.setNyknjskrrkrenno(haibunZennouKoujyoSymNaiyou.getNyknjskrrkrenno());
                            zennoKoujyoSymNaiyouBkfyEntity.setKihrkpssrrkrenno(haibunZennouKoujyoSymNaiyou.getKihrkpssrrkrenno());
                            zennoKoujyoSymNaiyouBkfyEntity.setKjsmhakkouzumiflg(C_Kjsmhakkouzumiflg.BLNK);
                            zennoKoujyoSymNaiyouBkfyEntity.setGyoumuKousinKinou(kinou.getKinouId());
                            zennoKoujyoSymNaiyouBkfyEntity.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                            zennoKoujyoSymNaiyouBkfyEntity.setGyoumuKousinTime(sysTime);
                            zennoKoujyoSymNaiyouBkfyEntity.setSakujyoflg(C_Delflag.BLNK);
                            zennoKoujyoSymNaiyouBkfyEntity.setZennoukaisiymd(haibunZennouKoujyoSymNaiyou.getZennoukaisiymd());
                            zennoKoujyoSymNaiyouBkfyEntity.setZennourenno(haibunZennouKoujyoSymNaiyou.getZennourenno());
                            zennoKoujyoSymNaiyouBkfyEntity.setKeisanhukahyoujikbn(C_DispKbn.HIHYOUJI);
                            zennoKoujyoSymNaiyouBkfyEntity.setKeisanhukariyuucd("");

                            BizPropertyInitializer.initialize(zennoKoujyoSymNaiyouBkfyEntity);

                            rennoMap.put(haibunZennouKoujyoSymNaiyou.getSyouhncd(), newRenno + 1);

                            haibunZennouKoujyoSymNaiyou.setGyoumuKousinKinou(kinou.getKinouId());
                            haibunZennouKoujyoSymNaiyou.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                            haibunZennouKoujyoSymNaiyou.setGyoumuKousinTime(sysTime);
                            haibunZennouKoujyoSymNaiyou.setSakujyoflg(C_Delflag.SAKUJYO);
                        }
                    }
                }
                else if (C_KoujyosymnaiyourecKbn.MKKHKR_KYKHK.eq(koujyoSymNaiyou.getKoujyosymnaiyoureckbn())) {
                    IT_KihrkmpSeisanRireki kihrkmpSeisanRireki  = editKoujyonaiyouTblZeitekiDao.getKihrkmpSeisanRireki(pSyono,
                        koujyoSymNaiyou.getKihrkpssrrkrenno());

                    List<KykSyouhnCommonParam> kykSyouhnCommonParamList = new ArrayList<>();
                    List<IT_KykSyouhn> kykSyouhnLst = editKoujyonaiyouTblZeitekiDao.getKykSyouhns(pSyono, kihrkmpSeisanRireki.getHenkousikibetukey());
                    if (kykSyouhnLst != null) {
                        kykSyouhnCommonParamList.addAll(kykSyouhnLst);
                    }
                    List<IT_KykSyouhnRireki> kykSyouhnRirekiLst = editKoujyonaiyouTblZeitekiDao.getKykSyouhnRirekis(pSyono, kihrkmpSeisanRireki.getHenkousikibetukey());
                    if (kykSyouhnRirekiLst != null) {
                        kykSyouhnCommonParamList.addAll(kykSyouhnRirekiLst);
                    }

                    IT_KoujyoSymNaiyou seisanzenKoujyoSymNaiyou = editKoujyonaiyouTblZeitekiDao.getSeisanmaeKoujyoSymNaiyou(
                        pSyono, koujyoSymNaiyou.getSyoumeistartym()).get(0);

                    IT_Zennou seisanzenZennouEntity = editKoujyonaiyouTblZeitekiDao.getZennou(
                        pSyono, koujyoSymNaiyou.getZennoukaisiymd(), koujyoSymNaiyou.getZennourenno() - 1);

                    String seisanzenHenkousikibetukey = editKoujyonaiyouTblZeitekiDao.getBeforeHenkousikibetukey(pSyono,
                        kihrkmpSeisanRireki.getHenkousikibetukey());

                    List<KykSyouhnCommonParam> seisanzenKykSyouhnCommonParamTkLst = new ArrayList<KykSyouhnCommonParam>();

                    List<IT_KykSyouhn> seisanzenKykSyouhnLst = editKoujyonaiyouTblZeitekiDao.getKykSyouhns(pSyono, seisanzenHenkousikibetukey);
                    if (seisanzenKykSyouhnLst != null) {
                        seisanzenKykSyouhnCommonParamTkLst.addAll(seisanzenKykSyouhnLst);
                    }
                    List<IT_KykSyouhnRireki> seisanzenKykSyouhnRirekiLst = editKoujyonaiyouTblZeitekiDao.getKykSyouhnRirekis(pSyono, seisanzenHenkousikibetukey);
                    if (seisanzenKykSyouhnRirekiLst != null) {
                        seisanzenKykSyouhnCommonParamTkLst.addAll(seisanzenKykSyouhnRirekiLst);
                    }

                    KoujyoSyoumeiUtil koujyoSyoumeiUtil = SWAKInjector.getInstance(KoujyoSyoumeiUtil.class);
                    BizCurrency seisanzenHrkp = koujyoSyoumeiUtil.sumSyouhnp(seisanzenKykSyouhnCommonParamTkLst);

                    for (IT_KoujyoSymNaiyou haibunZennouKoujyoSymNaiyou : haibunZennouKoujyoSymNaiyouList) {

                        haibunZennouKoujyoSymNaiyou.setGyoumuKousinKinou(kinou.getKinouId());
                        haibunZennouKoujyoSymNaiyou.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                        haibunZennouKoujyoSymNaiyou.setGyoumuKousinTime(sysTime);
                        haibunZennouKoujyoSymNaiyou.setSakujyoflg(C_Delflag.SAKUJYO);
                    }

                    boolean kjsmgKeisanfukaFlg = false;
                    String keisanfukariyuCd  = koujyoSyoumeiUtil.chkTkZennouStkkntySeisan(kykKihon,
                        seisanzenKoujyoSymNaiyou.getSyoumeistartym(), seisanzenKoujyoSymNaiyou.getSyoumeiendym(),
                        kihrkmpSeisanRireki.getRenno(), kihrkmpSeisanRireki.getJyuutouym());

                    if (!BizUtil.isBlank(keisanfukariyuCd)) {
                        kjsmgKeisanfukaFlg = true;
                    }

                    BizCurrency haraikomihkr = koujyoSyoumeiUtil.sumSyouhnp(kykSyouhnCommonParamList);

                    if (BizDateUtil.compareYm(koujyoSymNaiyou.getSyoumeistartym(), zeitekihenkoYm ) == BizDateUtil.COMPARE_LESSER) {

                        KhZennouKoujyogakuBean seisanZennouKoujyogakuZenBean = getSeisanZennouKoujyogakuBean(
                            seisanzenZennouEntity.getKjsmyouzennounyuukinkgk(),
                            zennouEntity.getKjsmyouzennounyuukinkgk(),
                            seisanzenHrkp,
                            haraikomihkr,
                            zennouEntity.getKjsmyouzennoukaisiymd(),
                            zennouEntity.getKjsmyouzennoukikanm(),
                            seisanzenKoujyoSymNaiyou.getSyoumeistartym(),
                            zeitekihenkoYm.getPreviousMonth(),
                            koujyoSymNaiyou.getSyoumeistartym(),
                            koujyoSymNaiyou.getKoujyosyoumeipkbn(),
                            kykSyouhnCommonParamList,
                            kjsmgKeisanfukaFlg);

                        KhZennouKoujyogakuBean seisanZennouKoujyogakuAtoBean = getSeisanZennouKoujyogakuBean(
                            seisanzenZennouEntity.getKjsmyouzennounyuukinkgk(),
                            zennouEntity.getKjsmyouzennounyuukinkgk(),
                            seisanzenHrkp,
                            haraikomihkr,
                            zennouEntity.getKjsmyouzennoukaisiymd(),
                            zennouEntity.getKjsmyouzennoukikanm(),
                            zeitekihenkoYm,
                            seisanzenKoujyoSymNaiyou.getSyoumeiendym(),
                            zeitekihenkoYm,
                            koujyosyoumeipkbn,
                            kykSyouhnCommonParamList,
                            kjsmgKeisanfukaFlg);

                        for (IT_KoujyoSymNaiyou haibunKoujyoSymNaiyou : haibunZennouKoujyoSymNaiyouList) {

                            koujoshoumeigakuZen = getSyohnZennouKoujyogaku(seisanZennouKoujyogakuZenBean,
                                kykSyouhnCommonParamList, haibunKoujyoSymNaiyou.getSyouhncd());

                            koujoshoumeigakuAto = getSyohnZennouKoujyogaku(seisanZennouKoujyogakuAtoBean,
                                kykSyouhnCommonParamList, haibunKoujyoSymNaiyou.getSyouhncd());

                            newRenno = getRenno(rennoMap, pSyono, haibunKoujyoSymNaiyou.getSyouhncd());

                            IT_KoujyoSymNaiyou zennoKoujyoSymNaiyouZenEntity = kykKihon.createKoujyoSymNaiyou();

                            zennoKoujyoSymNaiyouZenEntity.setSyouhncd(haibunKoujyoSymNaiyou.getSyouhncd());
                            zennoKoujyoSymNaiyouZenEntity.setRenno3keta(newRenno);
                            zennoKoujyoSymNaiyouZenEntity.setKoujyosyoumeinnd(haibunKoujyoSymNaiyou.getKoujyosyoumeinnd());
                            zennoKoujyoSymNaiyouZenEntity.setSyoumeistartym(haibunKoujyoSymNaiyou.getSyoumeistartym());
                            zennoKoujyoSymNaiyouZenEntity.setSyoumeiendym(zeitekihenkoYm.getPreviousMonth());
                            zennoKoujyoSymNaiyouZenEntity.setKoujyosyoumeipkbn(haibunKoujyoSymNaiyou.getKoujyosyoumeipkbn());
                            zennoKoujyoSymNaiyouZenEntity.setTekiyouseidokbn(haibunKoujyoSymNaiyou.getTekiyouseidokbn());
                            zennoKoujyoSymNaiyouZenEntity.setKoujyosymnaiyoureckbn(haibunKoujyoSymNaiyou.getKoujyosymnaiyoureckbn());
                            zennoKoujyoSymNaiyouZenEntity.setKoujyosyoumeigk(koujoshoumeigakuZen);
                            zennoKoujyoSymNaiyouZenEntity.setJyutoustartym(haibunKoujyoSymNaiyou.getJyutoustartym());
                            zennoKoujyoSymNaiyouZenEntity.setNyknjskrrkrenno(haibunKoujyoSymNaiyou.getNyknjskrrkrenno());
                            zennoKoujyoSymNaiyouZenEntity.setKihrkpssrrkrenno(haibunKoujyoSymNaiyou.getKihrkpssrrkrenno());
                            zennoKoujyoSymNaiyouZenEntity.setKjsmhakkouzumiflg(C_Kjsmhakkouzumiflg.BLNK);
                            zennoKoujyoSymNaiyouZenEntity.setGyoumuKousinKinou(kinou.getKinouId());
                            zennoKoujyoSymNaiyouZenEntity.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                            zennoKoujyoSymNaiyouZenEntity.setGyoumuKousinTime(sysTime);
                            zennoKoujyoSymNaiyouZenEntity.setSakujyoflg(C_Delflag.BLNK);
                            zennoKoujyoSymNaiyouZenEntity.setZennoukaisiymd(haibunKoujyoSymNaiyou.getZennoukaisiymd());
                            zennoKoujyoSymNaiyouZenEntity.setZennourenno(haibunKoujyoSymNaiyou.getZennourenno());

                            if (kjsmgKeisanfukaFlg) {
                                zennoKoujyoSymNaiyouZenEntity.setKeisanhukahyoujikbn(C_DispKbn.HYOUJI);
                            }
                            else {
                                zennoKoujyoSymNaiyouZenEntity.setKeisanhukahyoujikbn(C_DispKbn.HIHYOUJI);
                            }

                            zennoKoujyoSymNaiyouZenEntity.setKeisanhukariyuucd(keisanfukariyuCd);

                            BizPropertyInitializer.initialize(zennoKoujyoSymNaiyouZenEntity);

                            IT_KoujyoSymNaiyou zennoKoujyoSymNaiyouAtoEntity = kykKihon.createKoujyoSymNaiyou();

                            zennoKoujyoSymNaiyouAtoEntity.setSyouhncd(haibunKoujyoSymNaiyou.getSyouhncd());
                            zennoKoujyoSymNaiyouAtoEntity.setRenno3keta(newRenno + 1);
                            zennoKoujyoSymNaiyouAtoEntity.setKoujyosyoumeinnd(haibunKoujyoSymNaiyou.getKoujyosyoumeinnd());
                            zennoKoujyoSymNaiyouAtoEntity.setSyoumeistartym(zeitekihenkoYm);
                            zennoKoujyoSymNaiyouAtoEntity.setSyoumeiendym(haibunKoujyoSymNaiyou.getSyoumeiendym());

                            if (haibunKoujyoSymNaiyou.getSyouhncd().equals(kykSyouhnList.get(0).getSyouhncd())) {
                                zennoKoujyoSymNaiyouAtoEntity.setKoujyosyoumeipkbn(koujyosyoumeipkbn);
                            }
                            else {
                                zennoKoujyoSymNaiyouAtoEntity.setKoujyosyoumeipkbn(haibunKoujyoSymNaiyou.getKoujyosyoumeipkbn());
                            }

                            zennoKoujyoSymNaiyouAtoEntity.setTekiyouseidokbn(haibunKoujyoSymNaiyou.getTekiyouseidokbn());
                            zennoKoujyoSymNaiyouAtoEntity.setKoujyosymnaiyoureckbn(haibunKoujyoSymNaiyou.getKoujyosymnaiyoureckbn());
                            zennoKoujyoSymNaiyouAtoEntity.setKoujyosyoumeigk(koujoshoumeigakuAto);
                            zennoKoujyoSymNaiyouAtoEntity.setJyutoustartym(haibunKoujyoSymNaiyou.getJyutoustartym());
                            zennoKoujyoSymNaiyouAtoEntity.setNyknjskrrkrenno(haibunKoujyoSymNaiyou.getNyknjskrrkrenno());
                            zennoKoujyoSymNaiyouAtoEntity.setKihrkpssrrkrenno(haibunKoujyoSymNaiyou.getKihrkpssrrkrenno());
                            zennoKoujyoSymNaiyouAtoEntity.setKjsmhakkouzumiflg(C_Kjsmhakkouzumiflg.BLNK);
                            zennoKoujyoSymNaiyouAtoEntity.setGyoumuKousinKinou(kinou.getKinouId());
                            zennoKoujyoSymNaiyouAtoEntity.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                            zennoKoujyoSymNaiyouAtoEntity.setGyoumuKousinTime(sysTime);
                            zennoKoujyoSymNaiyouAtoEntity.setSakujyoflg(C_Delflag.BLNK);
                            zennoKoujyoSymNaiyouAtoEntity.setZennoukaisiymd(haibunKoujyoSymNaiyou.getZennoukaisiymd());
                            zennoKoujyoSymNaiyouAtoEntity.setZennourenno(haibunKoujyoSymNaiyou.getZennourenno());

                            if (kjsmgKeisanfukaFlg) {
                                zennoKoujyoSymNaiyouAtoEntity.setKeisanhukahyoujikbn(C_DispKbn.HYOUJI);
                            }
                            else {
                                zennoKoujyoSymNaiyouAtoEntity.setKeisanhukahyoujikbn(C_DispKbn.HIHYOUJI);
                            }

                            zennoKoujyoSymNaiyouAtoEntity.setKeisanhukariyuucd(keisanfukariyuCd);

                            BizPropertyInitializer.initialize(zennoKoujyoSymNaiyouAtoEntity);

                            rennoMap.put(haibunKoujyoSymNaiyou.getSyouhncd(), newRenno + 2);
                        }
                    }
                    else {

                        KhZennouKoujyogakuBean khZennouKoujyogakuBeanBkfy = getSeisanZennouKoujyogakuBean(
                            seisanzenZennouEntity.getKjsmyouzennounyuukinkgk(),
                            zennouEntity.getKjsmyouzennounyuukinkgk(),
                            seisanzenHrkp,
                            haraikomihkr,
                            zennouEntity.getKjsmyouzennoukaisiymd(),
                            zennouEntity.getKjsmyouzennoukikanm(),
                            seisanzenKoujyoSymNaiyou.getSyoumeistartym(),
                            seisanzenKoujyoSymNaiyou.getSyoumeiendym(),
                            koujyoSymNaiyou.getSyoumeistartym(),
                            koujyosyoumeipkbn,
                            kykSyouhnCommonParamList,
                            kjsmgKeisanfukaFlg);

                        for (IT_KoujyoSymNaiyou koujyoSymNaiyoufuyo : haibunZennouKoujyoSymNaiyouList) {

                            koujyosyoumeigkBkfy = getSyohnZennouKoujyogaku(khZennouKoujyogakuBeanBkfy,
                                kykSyouhnCommonParamList, koujyoSymNaiyoufuyo.getSyouhncd());

                            newRenno = getRenno(rennoMap, pSyono, koujyoSymNaiyoufuyo.getSyouhncd());

                            IT_KoujyoSymNaiyou zennoKoujyoSymNaiyouBkfyEntity = kykKihon.createKoujyoSymNaiyou();

                            zennoKoujyoSymNaiyouBkfyEntity.setSyouhncd(koujyoSymNaiyoufuyo.getSyouhncd());
                            zennoKoujyoSymNaiyouBkfyEntity.setRenno3keta(newRenno);
                            zennoKoujyoSymNaiyouBkfyEntity.setKoujyosyoumeinnd(koujyoSymNaiyoufuyo.getKoujyosyoumeinnd());
                            zennoKoujyoSymNaiyouBkfyEntity.setSyoumeistartym(koujyoSymNaiyoufuyo.getSyoumeistartym());
                            zennoKoujyoSymNaiyouBkfyEntity.setSyoumeiendym(koujyoSymNaiyoufuyo.getSyoumeiendym());

                            if (koujyoSymNaiyoufuyo.getSyouhncd().equals(kykSyouhnList.get(0).getSyouhncd())) {
                                zennoKoujyoSymNaiyouBkfyEntity.setKoujyosyoumeipkbn(koujyosyoumeipkbn);

                            }
                            else {
                                zennoKoujyoSymNaiyouBkfyEntity.setKoujyosyoumeipkbn(koujyoSymNaiyoufuyo.getKoujyosyoumeipkbn());
                            }

                            zennoKoujyoSymNaiyouBkfyEntity.setTekiyouseidokbn(koujyoSymNaiyoufuyo.getTekiyouseidokbn());
                            zennoKoujyoSymNaiyouBkfyEntity.setKoujyosymnaiyoureckbn(koujyoSymNaiyoufuyo.getKoujyosymnaiyoureckbn());
                            zennoKoujyoSymNaiyouBkfyEntity.setKoujyosyoumeigk(koujyosyoumeigkBkfy);
                            zennoKoujyoSymNaiyouBkfyEntity.setJyutoustartym(koujyoSymNaiyoufuyo.getJyutoustartym());
                            zennoKoujyoSymNaiyouBkfyEntity.setNyknjskrrkrenno(koujyoSymNaiyoufuyo.getNyknjskrrkrenno());
                            zennoKoujyoSymNaiyouBkfyEntity.setKihrkpssrrkrenno(koujyoSymNaiyoufuyo.getKihrkpssrrkrenno());
                            zennoKoujyoSymNaiyouBkfyEntity.setKjsmhakkouzumiflg(C_Kjsmhakkouzumiflg.BLNK);
                            zennoKoujyoSymNaiyouBkfyEntity.setGyoumuKousinKinou(kinou.getKinouId());
                            zennoKoujyoSymNaiyouBkfyEntity.setGyoumuKousinsyaId(baseUserInfo.getUserId());
                            zennoKoujyoSymNaiyouBkfyEntity.setGyoumuKousinTime(sysTime);
                            zennoKoujyoSymNaiyouBkfyEntity.setSakujyoflg(C_Delflag.BLNK);
                            zennoKoujyoSymNaiyouBkfyEntity.setZennoukaisiymd(koujyoSymNaiyoufuyo.getZennoukaisiymd());
                            zennoKoujyoSymNaiyouBkfyEntity.setZennourenno(koujyoSymNaiyoufuyo.getZennourenno());

                            if (kjsmgKeisanfukaFlg) {
                                zennoKoujyoSymNaiyouBkfyEntity.setKeisanhukahyoujikbn(C_DispKbn.HYOUJI);
                            }
                            else {
                                zennoKoujyoSymNaiyouBkfyEntity.setKeisanhukahyoujikbn(C_DispKbn.HIHYOUJI);
                            }

                            zennoKoujyoSymNaiyouBkfyEntity.setKeisanhukariyuucd(keisanfukariyuCd);
                            BizPropertyInitializer.initialize(zennoKoujyoSymNaiyouBkfyEntity);

                            rennoMap.put(koujyoSymNaiyoufuyo.getSyouhncd(), newRenno + 1);
                        }
                    }
                }
            }
        }

        if (C_ZeitekiHenkouSyoriKbn.HUKA.eq(pZeitekiHenkouSyoriKbn)) {
            String nenkinstartym;
            if (BizDateUtil.compareYm(zeitekihenkoYm, ansyuKihon.getJkipjytym()) != BizDateUtil.COMPARE_LESSER) {
                nenkinstartym = ansyuKihon.getJkipjytym().toString();
            }
            else {
                nenkinstartym = zeitekihenkoYm.toString();
            }
            messageLst.add(MessageUtil.getMessage(MessageId.WIF3008, DefaultDateFormatter.formatYMKanji(nenkinstartym)));
            messageIdLst.add(MessageId.WIF3008);
            chkkekkakbn = C_ChkkekkaKbn.WARNING;
        }

        if (pZeitekihenkoYmd.getMonth() >= 9) {

            IT_KoujyoSymKanri koujyoSymKanri = kykKihon.getKoujyoSymKanriByNendo(pZeitekihenkoYmd.getBizDateY().toString());

            if (koujyoSymKanri != null &&
                BizDateUtil.compareYm(koujyoSymKanri.getLastsyoumeiendym(), zeitekihenkoYm) != BizDateUtil.COMPARE_LESSER) {
                messageLst.add(MessageUtil.getMessage(MessageId.WIF3009));
                messageIdLst.add(MessageId.WIF3009);
                chkkekkakbn = C_ChkkekkaKbn.WARNING;
            }
        }

        logger.debug("△ 税適特約変更時控除証明内容TBL編集 終了");

        return chkkekkakbn;
    }

    private KhZennouKoujyogakuBean getZennouKoujyogakuBean(
        BizCurrency pKjzennoKigaku,
        String pKjzennokikanm,
        BizDate pKjzennostartymd,
        BizCurrency pHrkp,
        C_Hrkkaisuu pHrkkaisuu,
        BizDateYM pSyoumeistartym,
        int pSyoumeikaisuy,
        int pSyoumeikaisum,
        C_KoujyosyoumeipKbn pKoujyosyoumeipKbn,
        List<KykSyouhnCommonParam> pKykSyouhnCommonParamList) {

        KeisanZennouKoujyogaku keisanZennouKoujyogaku = SWAKInjector.getInstance(KeisanZennouKoujyogaku.class);

        BizCurrency pZennouKoujsymgaku = keisanZennouKoujyogaku.getZennouKoujyogaku(
            pKjzennoKigaku,
            pKjzennokikanm,
            pKjzennostartymd,
            pHrkp,
            pHrkkaisuu,
            pSyoumeistartym,
            pSyoumeikaisuy,
            pSyoumeikaisum);

        return keisanZennouKoujyogaku.doHaibunZennouKoujyogaku(
            pZennouKoujsymgaku,
            pKoujyosyoumeipKbn,
            pKykSyouhnCommonParamList);
    }

    private KhZennouKoujyogakuBean getSeisanZennouKoujyogakuBean(
        BizCurrency pHenkozenkjsmyKingaku,
        BizCurrency pHenkoatokjsmyKingaku,
        BizCurrency pHenkozenHrkp,
        BizCurrency pHenkoatoHrkp,
        BizDate pKjsmyzennostartymd,
        String pKjsmyzennokikanm,
        BizDateYM pSyoumeistartym,
        BizDateYM pSyoumeiendym,
        BizDateYM pSeisanstartym,
        C_KoujyosyoumeipKbn pKoujyosyoumeipKbn,
        List<KykSyouhnCommonParam> pKykSyouhnCommonParamList,
        boolean pKjsmgakucalfukaFlg) {

        KeisanZennouKoujyogaku keisanZennouKoujyogaku = SWAKInjector.getInstance(KeisanZennouKoujyogaku.class);

        BizCurrency zennouKoujsymgaku = null;

        if (pKjsmgakucalfukaFlg) {
            zennouKoujsymgaku = BizCurrency.valueOf(0, BizCurrencyTypes.YEN);
        }
        else {
            zennouKoujsymgaku = keisanZennouKoujyogaku.keisanTukiZennouGngk(
                pHenkozenkjsmyKingaku,
                pHenkoatokjsmyKingaku,
                pHenkozenHrkp,
                pHenkoatoHrkp,
                pKjsmyzennostartymd,
                pKjsmyzennokikanm,
                pSyoumeistartym,
                pSyoumeiendym,
                pSeisanstartym);
        }

        return keisanZennouKoujyogaku.doHaibunZennouKoujyogaku(
            zennouKoujsymgaku,
            pKoujyosyoumeipKbn,
            pKykSyouhnCommonParamList);
    }

    private BizCurrency getSyohnZennouKoujyogaku(
        KhZennouKoujyogakuBean pKhZennouKoujyogakuBean,
        List<KykSyouhnCommonParam> pKykSyouhnCommonParamList,
        String pSyouhncd) {

        Integer syouhnsdno = 0;

        for (KykSyouhnCommonParam kykSyouhnCommonParam : pKykSyouhnCommonParamList) {
            if (kykSyouhnCommonParam.getSyouhncd().equals(pSyouhncd)) {
                syouhnsdno = kykSyouhnCommonParam.getSyouhnsdno();
                break;
            }
        }

        KeisanZennouKoujyogaku keisanZennouKoujyogaku = SWAKInjector.getInstance(KeisanZennouKoujyogaku.class);

        return keisanZennouKoujyogaku.getKhShgtZennouKoujyogakuBean(
            pSyouhncd,
            String.valueOf(syouhnsdno),
            pKhZennouKoujyogakuBean.getKhShgtZennouKoujyogakuBeanList()).getKhShgtZennouKoujyogaku();
    }


    private Integer getRenno(Map<String, Integer> pRennoMap, String pSyono, String pSyouhncd) {

        if (pRennoMap.containsKey(pSyouhncd)) {
            return pRennoMap.get(pSyouhncd);
        }

        return hozenDomManager.getKoujyoSymNaiyouMaxRenno3ketaBySyonoSyouhncd(pSyono, pSyouhncd) + 1;
    }
}
