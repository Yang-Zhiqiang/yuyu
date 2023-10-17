package yuyu.app.siharai.sisyoukai.sishrrirekisyoukai;

import static yuyu.app.siharai.sisyoukai.sishrrirekisyoukai.GenSiShrRirekiSyoukaiConstants.*;
import static yuyu.app.siharai.sisyoukai.sishrrirekisyoukai.SiShrRirekiSyoukaiConstants.*;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.koutei.SetProgressHistory;
import yuyu.common.biz.syoruiitiran.CommonDispImage;
import yuyu.common.biz.syoruiitiran.SetSyoruiInfoItiran;
import yuyu.common.siharai.kyk.KeiyakuInfoSyutoku;
import yuyu.common.siharai.kyk.KeiyakuPrm;
import yuyu.common.siharai.sicommon.SiSetUiBean;
import yuyu.def.MessageId;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_HushrGeninKbn;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_SateiYouhiKbn;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_Syorikeiyu;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.JM_Kyuuhu;
import yuyu.def.db.entity.JM_SiSyouhnZokusei;
import yuyu.def.db.entity.JT_BetukutiSateiInfo;
import yuyu.def.db.entity.JT_SateiIppanHanteiInfo;
import yuyu.def.db.entity.JT_SateiJyuukasituChkInfo;
import yuyu.def.db.entity.JT_SateiKaijyoInfo;
import yuyu.def.db.entity.JT_SateiKokuhanInfo;
import yuyu.def.db.entity.JT_SateiMeigihenkouInfo;
import yuyu.def.db.entity.JT_SateiSyouninRireki;
import yuyu.def.db.entity.JT_SiDetail;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_SiRireki;
import yuyu.def.db.entity.JT_SibouSateiChkInfo;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.db.entity.JT_SkByoumei;
import yuyu.def.db.entity.JT_SkJiyuu;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.db.entity.JT_Toriatukaifuryouinfo;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.def.siharai.sorter.SortJT_SateiSyouninRireki;
import yuyu.def.siharai.sorter.SortJT_SiDetail;
import yuyu.def.siharai.sorter.SortJT_SiRireki;
import yuyu.def.siharai.sorter.SortJT_Sk;

import com.google.common.collect.Lists;

/**
 * 支払履歴照会 のビジネスロジックです。
 */
public class SiShrRirekiSyoukaiBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private SiShrRirekiSyoukaiUiBean uiBean;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private SiSetUiBean siSetUiBean;

    @Inject
    private SetProgressHistory setProgressHistory;

    @Inject
    private SetSyoruiInfoItiran setSyoruiInfoItiran;

    @Inject
    private CommonDispImage commonDispImage;

    @Inject
    private MessageManager messageManager;

    void init() {
        clear();
    }

    void clear() {

        uiBean.setSyono(null);
        uiBean.setSkno(null);
        uiBean.setHhknnmkj(null);
        uiBean.setHhknnmkn(null);
        uiBean.setSeikyuusyakbn(null);
        uiBean.setSihonninkakninkbn(null);
        uiBean.setSeikyuusyaseiymd(null);
        uiBean.setSeikyuusyasei(null);
        uiBean.setSeikyuusyanmkn(null);
        uiBean.setSeikyuusyanmkj(null);
        uiBean.setSaikennmkj(null);
        uiBean.setSaikennyno(null);
        uiBean.setSaikenadr1kj(null);
        uiBean.setSaikenadr2kj(null);
        uiBean.setSaikenadr3kj(null);
        uiBean.setSkskknnmkn(null);
        uiBean.setSkskknnmkj(null);
        uiBean.setSkskknsyubetu(null);
        uiBean.setSouhusakikbn(null);
        uiBean.setTsinyno(null);
        uiBean.setTsinadr1kj(null);
        uiBean.setTsinadr2kj(null);
        uiBean.setTsinadr3kj(null);
        uiBean.setTsintelno(null);
        uiBean.setInputshrhousiteikbn(null);
        uiBean.setBankcd(null);
        uiBean.setBanknmkj(null);
        uiBean.setSitencd(null);
        uiBean.setSitennmkj(null);
        uiBean.setYokinkbn(null);
        uiBean.setKouzano(null);
        uiBean.setKzdoukbn(null);
        uiBean.setKzmeiginmkn(null);
        uiBean.setSateikaksaigaikanouseikbn(null);
        uiBean.setSateikakmeigihnk(null);
        uiBean.setSateikakkaigaisb(null);
        uiBean.setSateikakhusyousikbn(null);
        uiBean.setSuketorihouhoukbn(null);
        uiBean.setSiharaituukakbn(null);
        uiBean.setGeninkbn(null);
        uiBean.setSibouymd(null);
        uiBean.setSiboubasyokbn(null);
        uiBean.setSiboubasyo(null);
        uiBean.setShrdtlsyooutkbn(null);
        uiBean.setHassoukbn(null);
        uiBean.setUktmnmeigibangou(null);
        uiBean.setKykmnmeigibangou(null);
        uiBean.setSiinkbn(null);
        uiBean.setShrtuukasyu(null);
        uiBean.setShrkwsratekjnymd(null);
        uiBean.setShrkwsrate(null);
        uiBean.setDispsyoruiukeymd(null);
        uiBean.setDisphubikanryouymd(null);
        uiBean.setShrymd(null);
        uiBean.setShrgk(null);
        uiBean.setHokenkngkgoukei(null);
        uiBean.setTienrisokukisanymd(null);
        uiBean.setTienrsknissuu(null);
        uiBean.setShrtienrsk(null);
        uiBean.setYenshrgk(null);
        uiBean.setYenhkgkgoukei(null);
        uiBean.setYenshrtienrsk(null);
        uiBean.setZeitratkikbn(null);
        uiBean.setGoukeihituyoukeihi(null);
        uiBean.setIppanhanteitensuu1(null);
        uiBean.setIppanhanteicomment1(null);
        uiBean.setIppanhanteitensuu2(null);
        uiBean.setIppanhanteicomment2(null);
        uiBean.setIppanhanteitensuu3(null);
        uiBean.setIppanhanteicomment3(null);
        uiBean.setIppanhanteitensuu4(null);
        uiBean.setIppanhanteicomment4(null);
        uiBean.setIppanhanteitensuu5(null);
        uiBean.setIppanhanteicomment5(null);
        uiBean.setIppanhanteitensuu6(null);
        uiBean.setIppanhanteicomment6(null);
        uiBean.setIppanhanteitensuugoukei(null);
        uiBean.setIppanhanteigoukeicomment(null);
        uiBean.setKokuhancheck1(null);
        uiBean.setKokuhanchecomment1(null);
        uiBean.setKokuhancheck2(null);
        uiBean.setKokuhanchecomment2(null);
        uiBean.setKokuhancheck3(null);
        uiBean.setKokuhanchecomment3(null);
        uiBean.setKokuhancheck4(null);
        uiBean.setKokuhanchecomment4(null);
        uiBean.setKokuhancheck5(null);
        uiBean.setKokuhanchecomment5(null);
        uiBean.setKokuhancheck6(null);
        uiBean.setKokuhanchecomment6(null);
        uiBean.setKokuhancheck7(null);
        uiBean.setKokuhanchecomment7(null);
        uiBean.setKokuhancheck8(null);
        uiBean.setKokuhanchecomment8(null);
        uiBean.setJuukasitucheck1(null);
        uiBean.setJuukasitucheckcomment1(null);
        uiBean.setJuukasitucheck2(null);
        uiBean.setJuukasitucheckcomment2(null);
        uiBean.setJuukasitucheck3(null);
        uiBean.setJuukasitucheckcomment3(null);
        uiBean.setJuukasitucheck4(null);
        uiBean.setJuukasitucheckcomment4(null);
        uiBean.setKaijokigenymd(null);
        uiBean.setMeihenyuukoumukoukbn(null);
        uiBean.setMeihenuktkbn(null);
        uiBean.setMeihenuktnm(null);
        uiBean.setTratkihuryouumukbn(null);
        uiBean.setGyousinkaisouyouhikbn(null);
        uiBean.setAireqdaityoukisaikbn(null);
        uiBean.setTratkihuryoucomment(null);
        uiBean.setBengosikenkaiumukbn(null);
        uiBean.setKujyouumukbn(null);
        uiBean.setJimumissumukbn(null);
        uiBean.setKyhgksitukaisouyouhikbn(null);
        uiBean.setBetusibouumukbn(null);
        uiBean.setBetusiboucomment(null);
        uiBean.setBetusoukiumukbn(null);
        uiBean.setBetusoukicomment(null);
        uiBean.setSyorikekkakbn(null);
        uiBean.setHushrgeninkbn(null);
        uiBean.setSessyouyhkbn(null);
        uiBean.setSessyousisyacd(null);
        uiBean.setSisyanm(null);
        uiBean.setSaigaimousideumukbn(null);
        uiBean.setSindansyoryoushryouhikbn(null);
        uiBean.setKaiketuymd(null);
        uiBean.setSindansyomaisuu(null);
        uiBean.setSindansyoshrgk(null);
        uiBean.setTyakkinymd(null);
        uiBean.setShrdtlsyooutkbn(null);
        uiBean.setHassoukbn(null);
        uiBean.setSearchResults(null);
        uiBean.setSiharaiRireki(null);
        uiBean.setProgresshistoryinfo(null);
        uiBean.setSyoruiInfoList(null);
        uiBean.setHktshrMeisaisInfo(null);
        uiBean.setSyoriKeiyuKbn(null);
        uiBean.setSeikyuuSyubetu(null);
        uiBean.setImageid(null);
        uiBean.setImageids(null);
        uiBean.setSk(null);
        uiBean.setSateiIppanHanteiInfo(null);
        uiBean.setSateiKokuhanInfo(null);
        uiBean.setSateiJyuukasituChkInfo(null);
        uiBean.setSateiKaijyoInfo(null);
        uiBean.setSateiMeigihenkouInfo(null);
        uiBean.setToriatukaifuryouinfo(null);
        uiBean.setSibouSateiChkInfo(null);
        uiBean.setBetukutiSateiInfo(null);
        uiBean.setSiKykKihon(null);
        uiBean.setSinsagendokknkbn(null);
        uiBean.setRikoukityuutuudannissuu(null);
        uiBean.setSateiyhkbn(null);
        uiBean.setSaisateiKbn(null);
    }

    void pushSyoukaiBL() {

        BizPropertyInitializer.initialize(uiBean);

        uiBean.setSyoriKeiyuKbn(C_Syorikeiyu.KEYINPUT);

        getRirekiList();
    }

    void pushSearchBL() {

        BizPropertyInitializer.initialize(uiBean);

        getKensakuKekka(uiBean.getHhknnmkn());
    }

    void pushDispSyoNoBL() {

        SearchResultsDataSourceBean searchResultsBean = uiBean.getSearchResultsDataSource().getSelectedBean();

        uiBean.setSyoriKeiyuKbn(C_Syorikeiyu.SRCH);
        uiBean.setSyono(searchResultsBean.getSyono());
        uiBean.setHhknnmkn(searchResultsBean.getHhknnmkn());
        uiBean.setHhknnmkj(searchResultsBean.getHhknnmkj());

        getRirekiList();
    }

    void pushSyousaiBL() {

        SiharaiRirekiDataSourceBean siharaiRirekiBean = uiBean.getSiharaiRirekiDataSource().getSelectedBean();

        String skno = siharaiRirekiBean.getDispskno();
        String syono = uiBean.getSyono();
        Integer skrrkno = siharaiRirekiBean.getDispskrrkno();
        C_SeikyuuSyubetu seikyuusyubetu = siharaiRirekiBean.getSeikyuusyubetu();

        JT_SkKihon skKihon = siharaiDomManager.getSkKihon(skno, syono);

        if (skKihon == null) {
            throw new BizAppException(MessageId.EBS0005, JT_SkKihon.TABLE_NAME, JT_SkKihon.SKNO, skno, JT_SkKihon.SYONO, syono);
        }

        uiBean.setSaisateiKbn(skKihon.getSaisateikbn());

        JT_Sk sk = skKihon.getSkBySeikyuurirekino(skrrkno);
        if (sk == null) {
            throw new BizAppException(MessageId.EBS0006, JT_Sk.TABLE_NAME, JT_Sk.SKNO, skno, JT_Sk.SYONO, syono,
                JT_Sk.SEIKYUURIREKINO, skrrkno.toString());
        }

        JT_Sk newSk = new JT_Sk();
        BeanUtil.copyProperties(newSk, sk);
        uiBean.setSk(newSk);

        List<JT_SkJiyuu> skJiyuuList = sk.getSkJiyuus();

        JT_SateiIppanHanteiInfo sateiIppanHanteiInfo = sk.getSateiIppanHanteiInfo();
        JT_SateiIppanHanteiInfo newSateiIppanHanteiInfo = new JT_SateiIppanHanteiInfo();
        if (sateiIppanHanteiInfo == null) {
            newSateiIppanHanteiInfo = null;
        } else {
            BeanUtil.copyProperties(newSateiIppanHanteiInfo, sateiIppanHanteiInfo);
        }
        uiBean.setSateiIppanHanteiInfo(newSateiIppanHanteiInfo);

        JT_SateiJyuukasituChkInfo sateiJyuukasituChkInfo = sk.getSateiJyuukasituChkInfo();
        JT_SateiJyuukasituChkInfo newSateiJyuukasituChkInfo = new JT_SateiJyuukasituChkInfo();
        if (sateiJyuukasituChkInfo == null) {
            newSateiJyuukasituChkInfo = null;
        } else {
            BeanUtil.copyProperties(newSateiJyuukasituChkInfo, sateiJyuukasituChkInfo);
        }
        uiBean.setSateiJyuukasituChkInfo(newSateiJyuukasituChkInfo);

        JT_SateiKokuhanInfo sateiKokuhanInfo = sk.getSateiKokuhanInfo();
        JT_SateiKokuhanInfo newSateiKokuhanInfo = new JT_SateiKokuhanInfo();
        if (sateiKokuhanInfo == null) {
            newSateiKokuhanInfo = null;
        } else {
            BeanUtil.copyProperties(newSateiKokuhanInfo, sateiKokuhanInfo);
        }
        uiBean.setSateiKokuhanInfo(newSateiKokuhanInfo);

        JT_SateiKaijyoInfo sateiKaijyoInfo = sk.getSateiKaijyoInfo();
        JT_SateiKaijyoInfo newSateiKaijyoInfo = new JT_SateiKaijyoInfo();
        if (sateiKaijyoInfo == null) {
            newSateiKaijyoInfo = null;
        } else {
            BeanUtil.copyProperties(newSateiKaijyoInfo,sateiKaijyoInfo);
        }
        uiBean.setSateiKaijyoInfo(newSateiKaijyoInfo);

        JT_SateiMeigihenkouInfo sateiMeigihenkouInfo = sk.getSateiMeigihenkouInfo();
        JT_SateiMeigihenkouInfo newSateiMeigihenkouInfo = new JT_SateiMeigihenkouInfo();
        if (sateiMeigihenkouInfo == null) {
            newSateiMeigihenkouInfo = null;
        } else {
            BeanUtil.copyProperties(newSateiMeigihenkouInfo, sateiMeigihenkouInfo);
        }
        uiBean.setSateiMeigihenkouInfo(newSateiMeigihenkouInfo);

        JT_Toriatukaifuryouinfo toriatukaifuryouinfo = sk.getToriatukaifuryouinfo();
        JT_Toriatukaifuryouinfo newToriatukaifuryouinfo = new JT_Toriatukaifuryouinfo();
        if (toriatukaifuryouinfo == null) {
            newToriatukaifuryouinfo = null;
        } else {
            BeanUtil.copyProperties(newToriatukaifuryouinfo, toriatukaifuryouinfo);
        }
        uiBean.setToriatukaifuryouinfo(newToriatukaifuryouinfo);

        JT_SibouSateiChkInfo sibouSateiChkInfo = sk.getSibouSateiChkInfo();
        JT_SibouSateiChkInfo newSibouSateiChkInfo = new JT_SibouSateiChkInfo();
        if (sibouSateiChkInfo == null) {
            newSibouSateiChkInfo = null;
        } else {
            BeanUtil.copyProperties(newSibouSateiChkInfo, sibouSateiChkInfo);
        }
        uiBean.setSibouSateiChkInfo(newSibouSateiChkInfo);

        JT_BetukutiSateiInfo betukutiSateiInfo = sk.getBetukutiSateiInfo();
        JT_BetukutiSateiInfo newBetukutiSateiInfo = new JT_BetukutiSateiInfo();
        if (betukutiSateiInfo == null) {
            newBetukutiSateiInfo = null;
        } else {
            BeanUtil.copyProperties(newBetukutiSateiInfo, betukutiSateiInfo);
        }
        uiBean.setBetukutiSateiInfo(newBetukutiSateiInfo);

        List<JT_SkByoumei> skByoumeiList = Lists.newArrayList();
        List<JT_SkByoumei> skByoumeiListResult = Lists.newArrayList();

        for (JT_SkJiyuu skJiyuu : skJiyuuList) {

            skByoumeiList = skJiyuu.getSkByoumeis();

            for (JT_SkByoumei skByoumei : skByoumeiList) {
                skByoumeiListResult.add(skByoumei);
            }
        }

        List<JT_SiDetail> siDetailList = Lists.newArrayList();
        List<JT_SiDetail> siDetailListResult = Lists.newArrayList();
        JM_Kyuuhu kyuuhu = null;
        JM_SiSyouhnZokusei siSyouhnZokusei = null;
        SortJT_SiDetail sortJTSiDetail = SWAKInjector.getInstance(SortJT_SiDetail.class);

        for (JT_SkJiyuu skJiyuu : skJiyuuList) {

            siDetailList.addAll(skJiyuu.getSiDetails());
        }

        siDetailList = sortJTSiDetail.OrderJT_SiDetailByUketukenoKyuuhukbnKyuuhucdRennoAsc(siDetailList);

        for (JT_SiDetail siDetail : siDetailList) {

            siSyouhnZokusei = siharaiDomManager.getSiSyouhnZokusei(siDetail.getSyouhncd(), siDetail.getKyhgndkatakbn(),
                siDetail.getSyouhnsdno(), siDetail.getKyuuhucd());

            if (siSyouhnZokusei != null) {

                kyuuhu = siSyouhnZokusei.getKyuuhu();

                if (kyuuhu != null) {

                    siDetailListResult.add(siDetail);
                }
            }
        }

        List<JT_SiRireki> siRirekiList = skKihon.getSiRirekis();

        if (siRirekiList.size() == 0) {
            throw new BizAppException(MessageId.EBS0005, JT_SiRireki.TABLE_NAME, JT_SiRireki.SKNO, skno,
                JT_SiRireki.SYONO, syono);
        }

        SortJT_SiRireki sortSiRireki = SWAKInjector.getInstance(SortJT_SiRireki.class);

        JT_SiRireki siRireki = sortSiRireki.OrderJT_SiRirekiByPkDesc(siRirekiList).get(0);

        JT_SateiSyouninRireki sateiSyouninRireki = getSateiSyouninRireki(skKihon);

        uiBean.setSiKykKihon(getKeiyakuInfo(syono));

        String kouteikanriid = bizDomManager.getGyoumuKouteiInfosBySyonoSkno(syono, skno).get(0).getSyukouteikanriid();

        uiBean.getBzWorkflowInfo().setKouteiKanriId(kouteikanriid);

        setProgressHistory.exec(uiBean);

        setSyoruiInfoItiran.exec(uiBean);

        uiBean.setSkno(skno);
        uiBean.setSeikyuuSyubetu(seikyuusyubetu);

        siSetUiBean.setSk(uiBean, sk);

        siSetUiBean.setSkJiyuu(uiBean, skJiyuuList, skByoumeiListResult);

        siSetUiBean.setHKTShrMeisai(uiBean, siDetailListResult);

        SiSetUiBean.setSiharai(uiBean, siRireki, sk);

        SiSetUiBean.setZeimu(uiBean, siRireki, sk);

        SiSetUiBean.setIppanhantei(uiBean, newSateiIppanHanteiInfo);

        SiSetUiBean.setKokuhanCheck(uiBean, newSateiKokuhanInfo);

        SiSetUiBean.setJyuukasituInfo(uiBean, newSateiJyuukasituChkInfo);

        SiSetUiBean.setKaijokigenymdInput(uiBean, newSateiKaijyoInfo);

        SiSetUiBean.setMeigihenkouSatei(uiBean, newSateiMeigihenkouInfo);

        SiSetUiBean.setTratkihuryouHusyoujiken(uiBean, newToriatukaifuryouinfo);

        SiSetUiBean.setSonotaCheckSibou(uiBean, newSibouSateiChkInfo);

        SiSetUiBean.setBetukutiCheck(uiBean, newBetukutiSateiInfo);

        uiBean.setSateiyhkbn(skKihon.getSateiyhkbn());

        if (C_SateiYouhiKbn.YOU.eq(skKihon.getSateiyhkbn())) {
            siSetUiBean.setSateiSiharaiSateiShrRireki(uiBean, sateiSyouninRireki, sk);
        }

        uiBean.setSindansyomaisuu(sk.getSindansyomaisuu());
        uiBean.setSindansyoshrgk(siRireki.getShrgkkei());
        uiBean.setTyakkinymd(siRireki.getTyakkinymd());

        if (C_Kzdou.DOUITU.eq(sk.getKzdoukbn())){
            uiBean.setKzmeiginmkn(sk.getKzmeiginmkn());
        }

        if (C_NaiteiKakuteiKbn.NAITEI.eq(uiBean.getSk().getVhtnaiteikakuteikbn())){
            messageManager.addMessageId(MessageId.WJA1082);
        }

        if (uiBean.getSk().getHaitoukin().equalsValue(BizCurrency.valueOf(0, uiBean.getSk().getHaitoukin().getType()))) {
            uiBean.setShrGoukeiHaitoukinDispFlg(false);
        } else {
            uiBean.setShrGoukeiHaitoukinDispFlg(true);
        }
        if (uiBean.getSk().getSonotahaitoukin()
            .equalsValue(BizCurrency.valueOf(0, uiBean.getSk().getSonotahaitoukin().getType()))) {
            uiBean.setShrGoukeiSonotahaitoukinDispFlg(false);
        } else {
            uiBean.setShrGoukeiSonotahaitoukinDispFlg(true);
        }
        if (uiBean.getSk().getMikeikap().equalsValue(BizCurrency.valueOf(0, uiBean.getSk().getMikeikap().getType()))) {
            uiBean.setShrGoukeiMikeikapDispFlg(false);
        } else {
            uiBean.setShrGoukeiMikeikapDispFlg(true);
        }
        if (uiBean.getSk().getMisyuup().equalsValue(BizCurrency.valueOf(0, uiBean.getSk().getMisyuup().getType()))) {
            uiBean.setShrGoukeiMisyuupDispFlg(false);
        } else {
            uiBean.setShrGoukeiMisyuupDispFlg(true);
        }
        if (uiBean.getSk().getZennouseisankgk()
            .equalsValue(BizCurrency.valueOf(0, uiBean.getSk().getZennouseisankgk().getType()))) {
            uiBean.setShrGoukeiZennouseisankgkDispFlg(false);
        } else {
            uiBean.setShrGoukeiZennouseisankgkDispFlg(true);
        }
        if (uiBean.getSk().getAzukarikingk()
            .equalsValue(BizCurrency.valueOf(0, uiBean.getSk().getAzukarikingk().getType()))) {
            uiBean.setShrGoukeiAzukarikingkDispFlg(false);
        } else {
            uiBean.setShrGoukeiAzukarikingkDispFlg(true);
        }
        if (uiBean.getSk().getKrkgk().equalsValue(BizCurrency.valueOf(0, uiBean.getSk().getKrkgk().getType()))) {
            uiBean.setShrGoukeiKrkgkDispFlg(false);
        } else {
            uiBean.setShrGoukeiKrkgkDispFlg(true);
        }
        if (C_Tuukasyu.JPY.equals(uiBean.getSk().getKyktuukasyu()) ||
            uiBean.isShrGoukeiHaitoukinDispFlg() == false && uiBean.isShrGoukeiSonotahaitoukinDispFlg() == false &&
            uiBean.isShrGoukeiMikeikapDispFlg() == false && uiBean.isShrGoukeiZennouseisankgkDispFlg() == false &&
            uiBean.isShrGoukeiAzukarikingkDispFlg() == false && uiBean.isShrGoukeiKrkgkDispFlg() == false) {
            uiBean.setViewSiharaiInfoGaikaknsnKijyunYmdFlg(false);
        } else {
            uiBean.setViewSiharaiInfoGaikaknsnKijyunYmdFlg(true);
        }
    }

    void printHyoujiOut() {

        commonDispImage.execDispImage(uiBean.getImageid());
    }


    void printAllHyoujiOut() {

        commonDispImage.execDispImageAll(uiBean.getImageids());
    }

    private void getRirekiList() {

        String syono = uiBean.getSyono();

        List<Object[]> objecstList = siharaiDomManager.getSiRirekiSkKihonSksBySyonoTorikesiflg(syono, C_UmuKbn.NONE);

        if (objecstList.size() == 0) {
            throw new BizLogicException(MessageId.EBA0024, MessageUtil.getMessage(MessageId.IJW1056));
        }

        Object[] item = objecstList.get(0);
        JT_SkKihon skKihon = (JT_SkKihon)item[1];
        uiBean.setHhknnmkn(skKihon.getHhknnmkn());
        uiBean.setHhknnmkj(skKihon.getHhknnmkj());

        setRirekiSkList(objecstList);

    }

    private void getKensakuKekka(String pHhknnmkn) {

        List<JT_SkKihon> skKihonList = siharaiDomManager.getSkKihonsByHhknnmknTorikesiflg(pHhknnmkn);

        if (skKihonList.size() == 0) {
            throw new BizLogicException(MessageId.EBA0024, MessageUtil.getMessage(MessageId.IJW1056));
        }

        if (skKihonList.size() > DATAGNDCOUNT) {
            throw new BizLogicException(MessageId.EBA0053, String.valueOf(DATAGNDCOUNT));
        }

        setKensakuList(skKihonList);
    }

    private void setRirekiSkList(List<Object[]> pObjectsList) {

        List<SiharaiRirekiDataSourceBean> siharaiRirekiDataSourceBeanList = Lists.newArrayList();
        SiharaiRirekiDataSourceBean dataSourceBean = null;

        for (Object[] items : pObjectsList) {

            dataSourceBean = SWAKInjector.getInstance(SiharaiRirekiDataSourceBean.class);

            JT_SiRireki siRireki = (JT_SiRireki)items[0];
            JT_SkKihon skKihon = (JT_SkKihon)items[1];
            JT_Sk sk = (JT_Sk)items[2];

            JT_SateiSyouninRireki sateiSyouninRireki = getSateiSyouninRireki(skKihon);

            C_HushrGeninKbn higaitougenin = C_HushrGeninKbn.BLNK;

            if (sateiSyouninRireki != null){
                higaitougenin = sateiSyouninRireki.getHushrgeninkbn();
            }

            dataSourceBean.setShrymd(siRireki.getTyakkinymd());
            dataSourceBean.setShrkekkakbn(siRireki.getShrkekkakbn());
            dataSourceBean.setHushrgeninkbn(higaitougenin);
            dataSourceBean.setSeikyuusyubetu(skKihon.getSeikyuusyubetu());
            dataSourceBean.setSeikyuusyanmkj(sk.getSeikyuusyanmkj());
            dataSourceBean.setSeikyuusyakbn(sk.getSeikyuusyakbn());
            dataSourceBean.setShrgkkei(siRireki.getShrgkkei());
            dataSourceBean.setDispskno(siRireki.getSkno());
            dataSourceBean.setDispskrrkno(siRireki.getSeikyuurirekino());
            dataSourceBean.setSyousaiLink(MessageUtil.getMessage(
                DDID_SIHARAIRIREKI_SYOUSAILINK.getErrorResourceKey()));

            siharaiRirekiDataSourceBeanList.add(dataSourceBean);
        }

        uiBean.setSiharaiRireki(siharaiRirekiDataSourceBeanList);
    }

    private void setKensakuList(List<JT_SkKihon> pSkKihonList) {

        List<SearchResultsDataSourceBean> searchResultsList= Lists.newArrayList();
        SearchResultsDataSourceBean searchResultsBean = null;

        for (JT_SkKihon skKihon : pSkKihonList) {

            searchResultsBean = SWAKInjector.getInstance(SearchResultsDataSourceBean.class);

            List<JT_Sk> skList = skKihon.getSks();
            SortJT_Sk sortSk = SWAKInjector.getInstance(SortJT_Sk.class);
            JT_Sk sk = sortSk.OrderJT_SkByPkDesc(skList).get(0);
            searchResultsBean.setSyono(skKihon.getSyono());
            searchResultsBean.setHhknnmkn(skKihon.getHhknnmkn());
            searchResultsBean.setHhknnmkj(skKihon.getHhknnmkj());
            searchResultsBean.setSeikyuusyanmkn(sk.getSeikyuusyanmkn());
            searchResultsBean.setSeikyuusyanmkj(sk.getSeikyuusyanmkj());

            searchResultsList.add(searchResultsBean);
        }

        uiBean.setSearchResults(searchResultsList);
    }

    private JT_SiKykKihon getKeiyakuInfo(String pSyono) {

        KeiyakuInfoSyutoku keiyakuInfoSyutoku = SWAKInjector.getInstance(KeiyakuInfoSyutoku.class);

        KeiyakuPrm keiyakuPrm = SWAKInjector.getInstance(KeiyakuPrm.class);
        keiyakuPrm.setSyono(pSyono);

        keiyakuInfoSyutoku.getInfos(keiyakuPrm);

        List<JT_SiKykKihon> siKykKihonLst = keiyakuInfoSyutoku.getKykKihons();

        if (siKykKihonLst.get(0) == null) {
            throw new BizLogicException(MessageId.EBA0024, "JT_SiKykKihon");
        }

        return siKykKihonLst.get(0);
    }

    private JT_SateiSyouninRireki getSateiSyouninRireki(JT_SkKihon pSkKihon) {

        SortJT_SateiSyouninRireki sortJTSateiSyouninRireki = SWAKInjector.getInstance(SortJT_SateiSyouninRireki.class);

        List<JT_SateiSyouninRireki> sateiSyouninRirekiList = pSkKihon.getSateiSyouninRirekis();

        if (sateiSyouninRirekiList.size() == 0) {
            throw new BizAppException(MessageId.EBS0005, JT_SateiSyouninRireki.TABLE_NAME, JT_SateiSyouninRireki.SKNO,
                pSkKihon.getSkno(), JT_SateiSyouninRireki.SYONO, pSkKihon.getSyono());
        }

        List<JT_SateiSyouninRireki> sateiSyouninRirekiListSort = sortJTSateiSyouninRireki.
            OrderJT_SateiSyouninRirekiByPkDesc(sateiSyouninRirekiList);

        JT_SateiSyouninRireki sateiSyouninRireki = null;
        BizDate kaiketuymd = null;

        for (JT_SateiSyouninRireki sateiSyouninRirekiIcnt : sateiSyouninRirekiListSort) {

            if (sateiSyouninRirekiIcnt.getKaiketuymd() != null && kaiketuymd == null) {
                kaiketuymd = sateiSyouninRirekiIcnt.getKaiketuymd();
            }

            if (C_SyorikekkaKbn.SIHARAI.eq(sateiSyouninRirekiIcnt.getSyorikekkakbn()) ||
                C_SyorikekkaKbn.HUSIHARAI.eq(sateiSyouninRirekiIcnt.getSyorikekkakbn()) ||
                C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU.eq(sateiSyouninRirekiIcnt.getSyorikekkakbn())) {

                sateiSyouninRireki = sateiSyouninRirekiIcnt;
                sateiSyouninRireki.setKaiketuymd(kaiketuymd);

                break;
            }
        }

        return sateiSyouninRireki;
    }
}
