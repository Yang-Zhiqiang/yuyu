package yuyu.app.siharai.sisatei.sisateisougousyoukai;

import static yuyu.app.siharai.sisatei.sisateisougousyoukai.SiSateiSougouSyoukaiConstants.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzGetSosikiData;
import yuyu.common.biz.bzcommon.BzGetSosikiDataBean;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.biz.bzdairiten.BzGetBsInfo;
import yuyu.common.biz.bzdairiten.BzGetBsInfoBean;
import yuyu.common.biz.bznayose.BetukutiKeiyakuInfoBean;
import yuyu.common.biz.bznayose.BetukutiKeiyakuInfoGet;
import yuyu.common.biz.bznayose.BetukutiKeiyakuInfoGetParam;
import yuyu.common.biz.bznayose.BetukutiKeiyakuInfoResultBean;
import yuyu.common.biz.bznayose.BzSakuinTsnSyoukaiKekkaBean;
import yuyu.common.biz.bznayose.BzSakuinTsnSyoukaiMq;
import yuyu.common.biz.bznayose.BzSakuinTsnSyoukaiYokenBean;
import yuyu.common.biz.koutei.SetProgressHistory;
import yuyu.common.biz.syoruiitiran.CommonDispImage;
import yuyu.common.biz.syoruiitiran.SetSyoruiInfoItiran;
import yuyu.common.siharai.sicommon.SetteiDoujiSkInfo;
import yuyu.common.siharai.sicommon.SiSetUiBean;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_Huho2kyknoKbn;
import yuyu.def.classification.C_KktyuitaKbn;
import yuyu.def.classification.C_MQSyorikekkaKbn;
import yuyu.def.classification.C_MQSyoukaiErrorKbn;
import yuyu.def.classification.C_MrsignalhanteigyoumuKbn;
import yuyu.def.classification.C_PalSyoukaiJissiumuKbn;
import yuyu.def.classification.C_SakuintsnSyoukaiKbn;
import yuyu.def.classification.C_SakuintsnTaisyouKbn;
import yuyu.def.classification.C_StknsetKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TargetTkKbn;
import yuyu.def.classification.C_TokkoudosghtnpKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YennykntksyuruiKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.BM_HutanpoBui;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_FatcaInfo;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KhTtdkTyuui;
import yuyu.def.db.entity.IT_KykDairiten;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.db.entity.IT_SyouhnTokujou;
import yuyu.def.db.entity.JM_Byoumei;
import yuyu.def.db.entity.JT_Mouside;
import yuyu.def.db.entity.JT_SiHubi;
import yuyu.def.db.entity.JT_SiHubiDetail;
import yuyu.def.db.entity.JT_SinsaTyuui;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.def.siharai.sorter.SortJT_SiHubiDetail;

import com.google.common.base.Joiner;

/**
 * 査定総合照会 のビジネスロジックです。
 */
public class SiSateiSougouSyoukaiBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private SiSateiSougouSyoukaiUiBean uiBean;

    @Inject
    private MessageManager messageManager;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private BizDomManager bizDomManager;

    @Inject
    private BaseDomManager baseDomManager;

    @Inject
    private HozenDomManager hozenDomManager;

    void init() {
    }

    void clear() {
    }

    void requestToUiBean(){
        HttpServletRequest req = SWAKInjector.getInstance(HttpServletRequest.class);
        uiBean.setSyono(req.getParameter("syono"));
        uiBean.setSkno(req.getParameter("skno"));
        uiBean.setKouteikanriid(req.getParameter("kouteikanriid"));
    }

    @SuppressWarnings("null")
    void nkronriChkAndjyouhoSyutoku() {

        BizPropertyInitializer.initialize(uiBean);

        if (BizUtil.isBlank(uiBean.getSyono())) {
            messageManager.addMessageId(MessageId.EBA0072);
            return;
        }

        if (BizUtil.isBlank(uiBean.getSkno())) {
            messageManager.addMessageId(MessageId.EBA0072);
            return;
        }

        uiBean.setSeikyuuJyouhouFlag(true);
        uiBean.setMousidejinJyouhouFlag(true);

        uiBean.setSaikensyaJyouhouFlag(true);
        uiBean.setHubiitiranFlag(true);
        uiBean.setKeiyakuJyouhouFlag(true);
        uiBean.setSibouketoriNinzuFlag(true);
        uiBean.setUketoriJyouhou1Flag(true);
        uiBean.setUketoriJyouhou2Flag(true);
        uiBean.setUketoriJyouhou3Flag(true);
        uiBean.setUketoriJyouhou4Flag(true);
        uiBean.setSiteiDairiSeikyuFlag(true);
        uiBean.setJuuDairiFlag(true);
        uiBean.setUketsukeKanriIdFlag(true);
        uiBean.setBetsuKeiyakuJyouhouFlag(true);
        uiBean.setTtdktyuuikbnInfoFlag(true);
        uiBean.setSikenSetFlag(true);
        uiBean.setSinsaTyuiFlag(true);
        uiBean.setFatcaTaisyouFlag(true);
        uiBean.setFatcaTaisyou1Flag(true);
        uiBean.setFatcaTaisyou2Flag(true);
        uiBean.setFatcaTaisyou3Flag(true);
        uiBean.setFatcaTaisyou4Flag(true);
        uiBean.setFatcaTaisyou5Flag(true);

        uiBean.setTokuyaku1Flag(true);
        uiBean.setTokuyaku2Flag(true);
        uiBean.setTokuyaku3Flag(true);
        uiBean.setTokuyaku4Flag(true);
        uiBean.setTokuyaku5Flag(true);
        uiBean.setTokuyaku6Flag(true);
        uiBean.setTokuyaku7Flag(true);
        uiBean.setTokuyaku8Flag(true);
        uiBean.setTokuyaku9Flag(true);
        uiBean.setTokuyaku10Flag(true);

        if (!BizUtil.isBlank(uiBean.getKouteikanriid())) {

            uiBean.getBzWorkflowInfo().setKouteiKanriId(uiBean.getKouteikanriid());

            SetSyoruiInfoItiran setSyoruiInfoItiran = SWAKInjector.getInstance(SetSyoruiInfoItiran.class);
            setSyoruiInfoItiran.exec(uiBean);
        }

        SetteiDoujiSkInfo setteiDoujiSkInfo = SWAKInjector.getInstance(SetteiDoujiSkInfo.class);
        BizDate skyUktkymd = null;

        setteiDoujiSkInfo.exec(uiBean.getSkno(), uiBean.getSyono(), uiBean);

        JT_SkKihon skKihon = siharaiDomManager.getSkKihon(uiBean.getSkno(), uiBean.getSyono());

        if (skKihon == null) {
            uiBean.setSeikyuuJyouhouFlag(false);
            uiBean.setSaikensyaJyouhouFlag(false);
        }
        else {
            JT_Sk sk = siharaiDomManager.getSkBySknoSyonoMaxSeikyuurirekino(uiBean.getSkno(), uiBean.getSyono());

            if (sk == null) {
                uiBean.setSeikyuuJyouhouFlag(false);
                uiBean.setSaikensyaJyouhouFlag(false);
            }
            else {
                SiSetUiBean siSetUiBean = SWAKInjector.getInstance(SiSetUiBean.class);
                siSetUiBean.setSk(uiBean, sk);

                if (BizUtil.isBlank(sk.getSaikennmkj())) {
                    uiBean.setSaikensyaJyouhouFlag(false);
                }

                skyUktkymd = sk.getSyoruiukeymd();
            }
        }



        if (BizUtil.isBlank(uiBean.getKouteikanriid())) {
            uiBean.setHubiitiranFlag(false);
        }else{
            SetProgressHistory setProgressHistory = SWAKInjector.getInstance(SetProgressHistory.class);
            setProgressHistory.exec(uiBean);

            JT_SiHubi siHubi =siharaiDomManager.getSiHubi(uiBean.getKouteikanriid());
            if (siHubi == null){
                uiBean.setHubiitiranFlag(false);
            }else{
                List<JT_SiHubiDetail> siHubiDetailList = siHubi.getSiHubiDetails();
                SortJT_SiHubiDetail siHubiDetailSort = SWAKInjector.getInstance(SortJT_SiHubiDetail.class);
                siHubiDetailList = siHubiDetailSort.OrderJT_SiHubiDetailByKaisyouymdHasinymdRenno3ketaAsc(siHubiDetailList);

                if (siHubiDetailList.size() == 0) {
                    uiBean.setHubiitiranFlag(false);
                }else{
                    List<HubiListDataSourceBean> hubiListDataSourceBeanList = new ArrayList<HubiListDataSourceBean>();
                    for (JT_SiHubiDetail siHubisSiHubiBean : siHubiDetailList) {
                        String nyuuryokuTantouName = "";
                        if (!BizUtil.isBlank(siHubisSiHubiBean.getHubitourokuktntid())) {
                            AM_User user = baseDomManager.getUser(siHubisSiHubiBean.getHubitourokuktntid());
                            if(user!=null){
                                nyuuryokuTantouName = user.getUserNm();
                            }
                        }
                        String syouninTantouName = "";
                        if (!BizUtil.isBlank(siHubisSiHubiBean.getHubisyouninktntid())) {
                            AM_User user = baseDomManager.getUser(siHubisSiHubiBean.getHubisyouninktntid());
                            if(user!=null){
                                syouninTantouName = user.getUserNm();
                            }
                        }
                        HubiListDataSourceBean hubiListDataSourceBean = new HubiListDataSourceBean();
                        hubiListDataSourceBean.setTrkymd(siHubisSiHubiBean.getTrkymd());
                        hubiListDataSourceBean.setSyoruinm(siHubisSiHubiBean.getHubisyoruicd().getContent());
                        hubiListDataSourceBean.setGenponhnkykumu(siHubisSiHubiBean.getGenponhnkykumu());
                        hubiListDataSourceBean.setHasinymd(siHubisSiHubiBean.getHasinymd());
                        hubiListDataSourceBean.setHassinsakikbn(siHubisSiHubiBean.getHassinsakikbn());
                        hubiListDataSourceBean.setDispnyuryokutantounm(nyuuryokuTantouName);
                        hubiListDataSourceBean.setKaisyouymd(siHubisSiHubiBean.getKaisyouymd());
                        hubiListDataSourceBean.setHubisyoruimsg(siHubisSiHubiBean.getHubinaiyoumsg());
                        hubiListDataSourceBean.setHubisyouninktntnm(syouninTantouName);

                        hubiListDataSourceBeanList.add(hubiListDataSourceBean);
                    }
                    uiBean.setHubiList(hubiListDataSourceBeanList);
                }
            }
        }

        if (skKihon == null) {
            uiBean.setMousidejinJyouhouFlag(false);
        }
        else {
            JT_Mouside mouside = skKihon.getMouside();

            if (mouside != null) {
                uiBean.setMousideninkbn(mouside.getMousideninkbn());
                uiBean.setMousideninnmkj(mouside.getMousideninnmkj());
                uiBean.setUketorininsibouumukbn(mouside.getUketorininsibouumukbn());
                uiBean.setKyksyasibouumukbn(mouside.getKyksyasibouumukbn());
                uiBean.setSouhusakikbn(mouside.getSouhusakikbn());
                uiBean.setDisptsinyno(mouside.getTsinyno());
                uiBean.setDisptsinadr1kj(mouside.getTsinadr1kj());
                uiBean.setDisptsinadr2kj(mouside.getTsinadr2kj());
                uiBean.setDisptsinadr3kj(mouside.getTsinadr3kj());
                uiBean.setDisptsintelno(mouside.getTsintelno());
                uiBean.setSeikyuusyubetu(mouside.getSeikyuusyubetu());
                uiBean.setGeninkbn(mouside.getGeninkbn());
                uiBean.setSibouymd(mouside.getSibouymd());

                if (!BizUtil.isBlank(mouside.getByoumeitourokuno())) {
                    JM_Byoumei byoumei = siharaiDomManager.getByoumei(mouside.getByoumeitourokuno());

                    if (byoumei != null) {
                        uiBean.setSyoubyounmkjgamen(byoumei.getByoumeikj());
                    }
                    else {
                        uiBean.setSyoubyounmkjgamen("");
                    }
                }
                else {
                    uiBean.setSyoubyounmkjgamen("");

                }
            }
            else {
                uiBean.setMousidejinJyouhouFlag(false);
            }
        }



        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(uiBean.getSyono());

        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = null;
        IT_KykSyouhn kykSyouhnMain = null;
        List<IT_KykSyouhn> kykSyouhnTokuList = null;
        IT_KykSonotaTkyk kykSonotaTkyk = null;
        List<IT_KykDairiten> kykDairitenList = null;

        if (kykKihon != null) {
            kykSya = kykKihon.getKykSya();
            if (kykSya == null) {
                uiBean.setKeiyakuJyouhouFlag(false);
            }

            hhknSya = kykKihon.getHhknSya();
            if (hhknSya == null) {
                uiBean.setKeiyakuJyouhouFlag(false);
            }

            List<IT_KykSyouhn> kykSyouhnList = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
            if (kykSyouhnList.size() > 0) {
                kykSyouhnMain = kykSyouhnList.get(0);
            }
            else {
                uiBean.setKeiyakuJyouhouFlag(false);
            }

            kykSyouhnTokuList = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.TK);

            kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

            kykDairitenList = kykKihon.getKykDairitens();
        }
        else {
            uiBean.setKeiyakuJyouhouFlag(false);
        }


        if (uiBean.isKeiyakuJyouhouFlag()) {



            uiBean.setYuukousyoumetukbn(kykSyouhnMain.getYuukousyoumetukbn());
            uiBean.setKykjyoutai(kykSyouhnMain.getKykjyoutai());
            uiBean.setSyoumetujiyuu(kykSyouhnMain.getSyoumetujiyuu());
            uiBean.setSyoumetuymd(kykSyouhnMain.getSyoumetuymd());
            uiBean.setMosymd(kykKihon.getMosymd());
            uiBean.setKktymd(kykKihon.getKktymd());
            uiBean.setMosukeymd(kykKihon.getMosukeymd());


            SiSetUiBean siSetUiBean = SWAKInjector.getInstance(SiSetUiBean.class);

            String mskmjskjkykNen = siSetUiBean.setMskmjSkjNen(kykKihon.getMosymd(), skyUktkymd, kykSya.getKykseiymd());
            uiBean.setVkykskyknmkn(kykSya.getKyknmkn());
            uiBean.setVkykskyknmkj(kykSya.getKyknmkj());
            uiBean.setVkykskykseiymd(kykSya.getKykseiymd());
            uiBean.setDispmskmjskjkyknen(mskmjskjkykNen);
            uiBean.setVkykskyksei(kykSya.getKyksei());
            uiBean.setVtssktsinyno(kykSya.getTsinyno());
            uiBean.setVtssktsintelno(kykSya.getTsintelno());
            uiBean.setVtssktsinadr1kj(kykSya.getTsinadr1kj());
            uiBean.setVtssktsinadr2kj(kykSya.getTsinadr2kj());
            uiBean.setVtssktsinadr3kj(kykSya.getTsinadr3kj());



            mskmjskjkykNen = siSetUiBean.setMskmjSkjNen(kykKihon.getMosymd(), skyUktkymd, hhknSya.getHhknseiymd());
            uiBean.setVhhkshhknnmkn(hhknSya.getHhknnmkn());
            uiBean.setVhhkshhknnmkj(hhknSya.getHhknnmkj());
            uiBean.setVhhkshhknseiymd(hhknSya.getHhknseiymd());
            uiBean.setDispmskmjskjhhknnen(mskmjskjkykNen);
            uiBean.setVhhkshhknsei(hhknSya.getHhknsei());


            IT_SyouhnTokujou syouhnTokujouMain =
                kykKihon.getSyouhnTokujouBySyutkkbnSyouhncdSyouhnsdnoKyksyouhnrenno(
                    C_SyutkKbn.SYU,
                    kykSyouhnMain.getSyouhncd(),
                    kykSyouhnMain.getSyouhnsdno(),
                    kykSyouhnMain.getKyksyouhnrenno());

            String syouhinNameMain = "";

            BM_SyouhnZokusei syouhnZokusei = kykSyouhnMain.getSyouhnZokusei();
            if (syouhnZokusei != null) {
                syouhinNameMain = syouhnZokusei.getSyouhnnm();
            }

            uiBean.setVhsyusyusyouhnnm(syouhinNameMain);
            uiBean.setVhsyusyukyktuukasyu(kykSyouhnMain.getKyktuukasyu());
            uiBean.setVhsyusyuhknkkn(kykSyouhnMain.getHknkkn());
            uiBean.setVhsyusyuhknkknsmnkbn(kykSyouhnMain.getHknkknsmnkbn());
            uiBean.setVhsyusyuhrkkkn(kykSyouhnMain.getHrkkkn());
            uiBean.setVhsyusyuhrkkknsmnkbn(kykSyouhnMain.getHrkkknsmnkbn());
            uiBean.setVhsyudai1hknkkn(kykSyouhnMain.getDai1hknkkn());
            uiBean.setVhsyusyukykymd(kykSyouhnMain.getKykymd());
            uiBean.setVhsyusyusknnkaisiymd(kykSyouhnMain.getSknnkaisiymd());
            uiBean.setVhsyusyufktsknnkaisiymd(kykSyouhnMain.getHksknnkaisiymd());
            uiBean.setVhsyusyukihons(kykSyouhnMain.getKihons());
            uiBean.setVhsyusyup(kykSyouhnMain.getHokenryou());

            if (syouhnTokujouMain != null) {
                setHosyouHutanpo(syouhnTokujouMain);
            }


            setTokuyaku(kykKihon, kykSyouhnTokuList);


            if (kykSonotaTkyk != null) {
                ArrayList<String> sonotaTokuList = new ArrayList<String>();

                if (kykSonotaTkyk.getKykdrtkykhukaumu().eq(C_UmuKbn.ARI)) {
                    sonotaTokuList.add(TOKUYAKUNM_HOKENKYKDRTKYK);
                }

                if (kykSonotaTkyk.getStdrsktkyhkumu().eq(C_UmuKbn.ARI)) {
                    sonotaTokuList.add(TOKUYAKUNM_SITEIDAIRISEIKYUU);
                }

                if (kykSonotaTkyk.getYennykntkhkumu().eq(C_UmuKbn.ARI)) {
                    if (!C_YennykntksyuruiKbn.BLNK.eq(kykSonotaTkyk.getYennyknsyuruikbn())) {
                        sonotaTokuList.add(kykSonotaTkyk.getYennyknsyuruikbn().getContent());
                    }
                }

                if (kykSonotaTkyk.getGaikanykntkhkumu().eq(C_UmuKbn.ARI)) {
                    sonotaTokuList.add(TOKUYAKUNM_GAIKANYUUKIN);
                }

                if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getTargettkhkumu())) {
                    if (kykSonotaTkyk.getTargettkmokuhyouti() == 0) {
                        if (C_TargetTkKbn.SYUUSIN.eq(kykSonotaTkyk.getTargettkkbn())) {
                            sonotaTokuList.add(kykSonotaTkyk.getTargettkkbn().getContent() + TOKUYAKUHYJ_STR1 +
                                kykSonotaTkyk.getTargettkykkijyungk().toFormatString() + TOKUYAKUHYJ_STR2);
                        }
                        if (C_TargetTkKbn.NENKIN.eq(kykSonotaTkyk.getTargettkkbn())){
                            sonotaTokuList.add(kykSonotaTkyk.getTargettkkbn().getContent() + TOKUYAKUHYJ_STR3 +
                                kykSonotaTkyk.getTargettkykkijyungk().toFormatString() + TOKUYAKUHYJ_STR2);
                        }
                    } else {
                        if (C_TargetTkKbn.SYUUSIN.eq(kykSonotaTkyk.getTargettkkbn())) {
                            sonotaTokuList.add(kykSonotaTkyk.getTargettkkbn().getContent() + TOKUYAKUHYJ_STR1 +
                                kykSonotaTkyk.getTargettkykkijyungk().toFormatString() + TOKUYAKUHYJ_STR4 +
                                kykSonotaTkyk.getTargettkmokuhyouti() + TOKUYAKUHYJ_STR5);
                        }
                        if (C_TargetTkKbn.NENKIN.eq(kykSonotaTkyk.getTargettkkbn())) {
                            sonotaTokuList.add(kykSonotaTkyk.getTargettkkbn().getContent() + TOKUYAKUHYJ_STR3 +
                                kykSonotaTkyk.getTargettkykkijyungk().toFormatString() + TOKUYAKUHYJ_STR4 +
                                kykSonotaTkyk.getTargettkmokuhyouti() + TOKUYAKUHYJ_STR5);
                        }
                    }
                }

                if (C_UmuKbn.ARI.eq(kykSonotaTkyk.getInitsbjiyensitihsytkhukaumu())) {
                    sonotaTokuList.add(TOKUYAKUNM_INITSBJIYENSHRGKSITIHSYUTK + TOKUYAKUHYJ_STR1 +
                        kykSonotaTkyk.getInitsbjiyenkasaiteihsygk().toFormatString() + TOKUYAKUHYJ_STR6);
                }

                if (kykSonotaTkyk.getJyudkaigomeharaitkhukaumu().eq(C_UmuKbn.ARI)) {
                    sonotaTokuList.add(TOKUYAKUNM_JYUUDOKAIGOMAEBARAI);
                }

                if (kykSonotaTkyk.getZeiseitkkktkykhukaumu().eq(C_UmuKbn.ARI)) {
                    sonotaTokuList.add(TOKUYAKUNM_ZEISEITEKIKAKU);
                }

                if (sonotaTokuList.size() != 0) {
                    uiBean.setVsntkdisptkhukainfo(Joiner.on("\n").join(sonotaTokuList.toArray(new String[sonotaTokuList.size()])));
                }
                else {
                    uiBean.setVsntkdisptkhukainfo("");
                }
            }
            else {
                uiBean.setVsntkdisptkhukainfo("");
            }


            setSibouHokenkinUkt(kykKihon, skyUktkymd);


            if (kykSonotaTkyk != null) {
                if (kykSonotaTkyk.getStdrsktkyhkumu().eq(C_UmuKbn.ARI)) {
                    List<IT_KykUkt> kykUktList = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.STDRSK);
                    if (kykUktList.size() != 0) {
                        uiBean.setVstsksiteidruktkbn(kykUktList.get(0).getUktkbn());
                        uiBean.setVstskstdrsknmkn(kykUktList.get(0).getUktnmkn());
                        uiBean.setVstskstdrsknmkj(kykUktList.get(0).getUktnmkj());
                    }
                    else {
                        uiBean.setSiteiDairiSeikyuFlag(false);
                    }
                }
                else {
                    uiBean.setSiteiDairiSeikyuFlag(false);
                }
            }
            else {
                uiBean.setSiteiDairiSeikyuFlag(false);
            }


            uiBean.setJuuDairiFlag(false);

            if (kykDairitenList.size() != 0) {

                IT_KykDairiten kykDairitenSyu = kykDairitenList.get(0);

                if (kykDairitenSyu != null) {

                    String dispDrtencdSyu = kykDairitenSyu.getDrtencd();
                    String dispBosyuucdSyu = kykDairitenSyu.getBosyuucd();
                    BizNumber dispBunwariSyu = kykDairitenSyu.getBunwari();
                    String dispDrtennmSyu = "";
                    String dispBosyuunmSyu = "";

                    BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);
                    List<BzGetAgInfoBean> bzGetAgInfoBeanList = bzGetAgInfo.exec(dispDrtencdSyu);

                    if (bzGetAgInfoBeanList.size() != 0) {
                        dispDrtennmSyu = bzGetAgInfoBeanList.get(0).getKanjiDairitenNm();
                    }

                    BzGetBsInfo bzGetBsInfo = SWAKInjector.getInstance(BzGetBsInfo.class);
                    BzGetBsInfoBean bzGetBsInfoBean = bzGetBsInfo.exec(dispBosyuucdSyu);

                    if (bzGetBsInfoBean != null) {
                        dispBosyuunmSyu = bzGetBsInfoBean.getKanjiBosyuuninNm();
                    }

                    if (BizNumber.ZERO.equals(dispBunwariSyu)) {
                        dispBunwariSyu = BizNumber.optional();
                    }
                    uiBean.setDispdrtencd1(dispDrtencdSyu);
                    uiBean.setDispdrtennm1(dispDrtennmSyu);
                    uiBean.setDispbosyuucd1(dispBosyuucdSyu);
                    uiBean.setDispbosyuunm1(dispBosyuunmSyu);
                    uiBean.setDispbunwari1(dispBunwariSyu);
                }
                if (kykDairitenList.size() == 2) {
                    IT_KykDairiten kykDairitenJyu = kykDairitenList.get(1);

                    if (kykDairitenJyu != null) {

                        String dispDrtencdJyu = kykDairitenJyu.getDrtencd();
                        String dispBosyuucdJyu = kykDairitenJyu.getBosyuucd();
                        BizNumber dispBunwariJyu = kykDairitenJyu.getBunwari();
                        String dispDrtennmJyu = "";
                        String dispBosyuunmJyu = "";

                        BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);
                        List<BzGetAgInfoBean> bzGetAgInfoBeanList = bzGetAgInfo.exec(dispDrtencdJyu);

                        if (bzGetAgInfoBeanList.size() != 0) {
                            dispDrtennmJyu = bzGetAgInfoBeanList.get(0).getKanjiDairitenNm();
                        }

                        BzGetBsInfo bzGetBsInfo = SWAKInjector.getInstance(BzGetBsInfo.class);
                        BzGetBsInfoBean bzGetBsInfoBean = bzGetBsInfo.exec(dispBosyuucdJyu);

                        if (bzGetBsInfoBean != null) {
                            dispBosyuunmJyu = bzGetBsInfoBean.getKanjiBosyuuninNm();
                        }

                        if (BizNumber.ZERO.equals(dispBunwariJyu)) {
                            dispBunwariJyu = BizNumber.optional();
                        }
                        uiBean.setDispdrtencd2(dispDrtencdJyu);
                        uiBean.setDispdrtennm2(dispDrtennmJyu);
                        uiBean.setDispbosyuucd2(dispBosyuucdJyu);
                        uiBean.setDispbosyuunm2(dispBosyuunmJyu);
                        uiBean.setDispbunwari2(dispBunwariJyu);

                        uiBean.setJuuDairiFlag(true);
                    }

                }

                uiBean.setBosyuuym(kykKihon.getBosyuuym());
                uiBean.setDairitenseisekiym(kykKihon.getSeisekiym());
                uiBean.setCifcd(kykKihon.getCifcd());
                uiBean.setBoskykjyoutai(kykKihon.getBoskykjyoutai());
                uiBean.setSmbckanriid(kykKihon.getSmbckanriid());

            }

            if (BizUtil.isBlank(uiBean.getSmbckanriid())) {
                uiBean.setUketsukeKanriIdFlag(false);
            }
        }



        uiBean.setBetsuKeiyakuJyouhouFlag(false);

        BetukutiKeiyakuInfoGet betukutiKeiyakuInfoGet = SWAKInjector.getInstance(BetukutiKeiyakuInfoGet.class);
        BetukutiKeiyakuInfoGetParam betukutiKeiyakuInfoGetParam = SWAKInjector
            .getInstance(BetukutiKeiyakuInfoGetParam.class);

        betukutiKeiyakuInfoGetParam.setHuho2kyknokbn(C_Huho2kyknoKbn.SYONO);
        betukutiKeiyakuInfoGetParam.setHuho2kykno(uiBean.getSyono());
        betukutiKeiyakuInfoGetParam.setSkintsntaisyoukbn(C_SakuintsnTaisyouKbn.HHKN);

        BetukutiKeiyakuInfoResultBean betukutiKeiyakuInfoResultBean = betukutiKeiyakuInfoGet
            .exec(betukutiKeiyakuInfoGetParam);

        List<BetukykInfoDataSourceBean> betukykInfoDataSourceBeanList = new ArrayList<BetukykInfoDataSourceBean>();

        if(betukutiKeiyakuInfoResultBean.getMqsyorikekkakbn().eq(C_MQSyorikekkaKbn.ERROR)) {
            messageManager.addConversationMessageId(MQERR_GROUP_MESSAGE, MessageId.WJA1057, MessageUtil.getMessage(MessageId.IJW1084));
        }
        else if (betukutiKeiyakuInfoResultBean.getMqsyorikekkakbn().eq(C_MQSyorikekkaKbn.SEIJYOU)) {
            if(betukutiKeiyakuInfoResultBean.getPalsyoukaijissiumukbn().eq(C_PalSyoukaiJissiumuKbn.NONE)) {
                messageManager.addConversationMessageId(MQERR_GROUP_MESSAGE, MessageId.WJA1058, MessageUtil.getMessage(MessageId.IJW1084));
            }
            else if (betukutiKeiyakuInfoResultBean.getPalsyoukaijissiumukbn().eq(C_PalSyoukaiJissiumuKbn.ARI)) {
                if(betukutiKeiyakuInfoResultBean.getSakuininfosyoukaierrkbn().eq(C_MQSyoukaiErrorKbn.SYOUKAIERROR)) {
                    messageManager.addConversationMessageId(MQERR_GROUP_MESSAGE, MessageId.WJA1059, MessageUtil.getMessage(MessageId.IJW1084));
                }
                else if (betukutiKeiyakuInfoResultBean.getSakuininfosyoukaierrkbn().eq(C_MQSyoukaiErrorKbn.SYOUKAIOK)) {
                    List<BetukutiKeiyakuInfoBean> betukutiKeiyakuInfoBeanList = betukutiKeiyakuInfoResultBean
                        .getBetukutiKeiyakuInfoBeanLst();

                    if (betukutiKeiyakuInfoBeanList.size() != 0) {
                        uiBean.setBetsuKeiyakuJyouhouFlag(true);

                        for (BetukutiKeiyakuInfoBean betukutiKeiyakuInfoBean : betukutiKeiyakuInfoBeanList) {
                            BetukykInfoDataSourceBean betukykInfoDataSourceBean = new BetukykInfoDataSourceBean();

                            betukykInfoDataSourceBean.setBtkyksyono(betukutiKeiyakuInfoBean.getBtkyksyono());
                            betukykInfoDataSourceBean.setSyscdkbn(betukutiKeiyakuInfoBean.getSyscdkbn());
                            betukykInfoDataSourceBean.setBetukutikeiyakukbn(betukutiKeiyakuInfoBean.getBetukutikeiyakukbn());
                            betukykInfoDataSourceBean.setKankeisyakbnname(betukutiKeiyakuInfoBean.getKankeisyakbnname());
                            betukykInfoDataSourceBean.setSyoumetuymd(betukutiKeiyakuInfoBean.getSyoumetuymd());
                            betukykInfoDataSourceBean.setSyoumetujiyuuname(betukutiKeiyakuInfoBean.getSyoumetujiyuuname());
                            betukykInfoDataSourceBean.setSyouhnnm(betukutiKeiyakuInfoBean.getSyouhnnm());

                            betukykInfoDataSourceBeanList.add(betukykInfoDataSourceBean);
                        }
                    }
                }
            }
        }

        uiBean.setBetukykInfo(betukykInfoDataSourceBeanList);




        uiBean.setTtdktyuuikbnInfoFlag(false);

        IT_KhTtdkTyuui khTtdkTyuui = kykKihon.getKhTtdkTyuui();

        List<TtdktyuuikbnInfoDataSourceBean> ttdktyuuiInfoListDataSourceBeanList =
            new ArrayList<TtdktyuuikbnInfoDataSourceBean>();

        if (khTtdkTyuui != null) {

            uiBean.setVtdktkktyuitakbn(khTtdkTyuui.getKktyuitakbn());
            uiBean.setVtdktttdktyuuinaiyou1(khTtdkTyuui.getTtdktyuuinaiyou1());
            uiBean.setVtdktttdktyuuinaiyou2(khTtdkTyuui.getTtdktyuuinaiyou2());
            uiBean.setVtdktttdktyuuinaiyou3(khTtdkTyuui.getTtdktyuuinaiyou3());

            Class<?> khTtdkTyuuiClass = khTtdkTyuui.getClass().getSuperclass();

            for (int idx = 1; idx < 6; idx++) {
                try {
                    Field ttdktyuuikbnField = khTtdkTyuuiClass.getDeclaredField("ttdktyuuikbn" + idx);
                    Field ttdktyuuikbnhsknaiyouField = khTtdkTyuuiClass.getDeclaredField("ttdktyuuikbnhsknaiyou" + idx);
                    Field ttdktyuuikbnsetymdField = khTtdkTyuuiClass.getDeclaredField("ttdktyuuikbnsetymd" + idx);
                    Field setsosikicdField = khTtdkTyuuiClass.getDeclaredField("setsosikicd" + idx);
                    ttdktyuuikbnField.setAccessible(true);
                    ttdktyuuikbnhsknaiyouField.setAccessible(true);
                    ttdktyuuikbnsetymdField.setAccessible(true);
                    setsosikicdField.setAccessible(true);

                    if (!((C_TtdktyuuiKbn)ttdktyuuikbnField.get(khTtdkTyuui)).eq(C_TtdktyuuiKbn.BLNK)) {
                        TtdktyuuikbnInfoDataSourceBean ttdktyuuikbnInfoDataSourceBean =
                            new TtdktyuuikbnInfoDataSourceBean();

                        ttdktyuuikbnInfoDataSourceBean.setVtdktttdktyuuikbn((C_TtdktyuuiKbn)ttdktyuuikbnField.get(khTtdkTyuui));

                        if (null != ttdktyuuikbnhsknaiyouField.get(khTtdkTyuui)) {
                            ttdktyuuikbnInfoDataSourceBean.setVtdktttdktyikbnhsknaiyou(ttdktyuuikbnhsknaiyouField.get(khTtdkTyuui).toString());
                        }
                        ttdktyuuikbnInfoDataSourceBean.setVtdktttdktyuuikbnsetymd((BizDate)ttdktyuuikbnsetymdField.get(khTtdkTyuui));

                        if (null != setsosikicdField.get(khTtdkTyuui)) {
                            BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);
                            BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(setsosikicdField.get(khTtdkTyuui).toString());
                            ttdktyuuikbnInfoDataSourceBean.setVtdktsetsosikinm(bzGetSosikiDataBean.getKanjisosikinm20());
                        }
                        ttdktyuuiInfoListDataSourceBeanList.add(ttdktyuuikbnInfoDataSourceBean);

                        uiBean.setTtdktyuuikbnInfoFlag(true);

                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
            uiBean.setTtdktyuuikbnInfo(ttdktyuuiInfoListDataSourceBeanList);
        }
        else {
            uiBean.setVtdktkktyuitakbn(C_KktyuitaKbn.BLNK);
            uiBean.setVtdktttdktyuuinaiyou1("");
            uiBean.setVtdktttdktyuuinaiyou2("");
            uiBean.setVtdktttdktyuuinaiyou3("");
            uiBean.setTtdktyuuikbnInfo(ttdktyuuiInfoListDataSourceBeanList);
        }


        if (!kykKihon.getStknsetkbn().eq(C_StknsetKbn.BLNK)) {
            uiBean.setVtdktstknsetkbn(kykKihon.getStknsetkbn());
        }
        else {
            uiBean.setSikenSetFlag(false);
        }


        JT_SinsaTyuui sinsaTyuui = siharaiDomManager.getSinsaTyuui(uiBean.getSyono());

        if (sinsaTyuui != null) {
            AM_User userMaster = baseDomManager.getUser(sinsaTyuui.getGyoumuKousinsyaId());

            if (userMaster != null) {
                uiBean.setSinsatyuuisetnm(userMaster.getUserNm());
            }
            uiBean.setSosikinm(sinsaTyuui.getSosikinm());
            uiBean.setSinsatyuui(sinsaTyuui.getSinsatyuui());
        }
        else {
            uiBean.setSinsaTyuiFlag(false);
        }


        List<IT_FatcaInfo>  fatcaInfoList = kykKihon.getFatcaInfos();
        if (fatcaInfoList.size() != 0) {
            setFatcaTaisyousya(fatcaInfoList);
        }
        else {
            uiBean.setFatcaTaisyouFlag(false);
            uiBean.setFatcaTaisyou1Flag(false);
            uiBean.setFatcaTaisyou2Flag(false);
            uiBean.setFatcaTaisyou3Flag(false);
            uiBean.setFatcaTaisyou4Flag(false);
            uiBean.setFatcaTaisyou5Flag(false);
        }


        if (betukutiKeiyakuInfoResultBean.getMqsyorikekkakbn().eq(C_MQSyorikekkaKbn.SEIJYOU) &&
            betukutiKeiyakuInfoResultBean.getPalsyoukaijissiumukbn().eq(C_PalSyoukaiJissiumuKbn.ARI) &&
            betukutiKeiyakuInfoResultBean.getSakuininfosyoukaierrkbn().eq(C_MQSyoukaiErrorKbn.SYOUKAIOK)) {
            setMRHansyaInfo(uiBean.getSyono());
        }
        else {
            uiBean.setKykmrumu(C_UmuKbn.NONE);
            uiBean.setKykhnsyumu(C_UmuKbn.NONE);
            uiBean.setHhknmrumu(C_UmuKbn.NONE);
            uiBean.setHhknhnsyumu(C_UmuKbn.NONE);
        }

    }


    void printHyoujiOut() {
        CommonDispImage commonDispImage = SWAKInjector.getInstance(CommonDispImage.class);

        commonDispImage.execDispImage(uiBean.getImageid());
    }

    void printAllHyoujiOut() {
        CommonDispImage commonDispImage = SWAKInjector.getInstance(CommonDispImage.class);

        commonDispImage.execDispImageAll(uiBean.getImageids());

        uiBean.setAllPrintFlg(false);
    }

    void nkronriChkAndjyouhoSyutokuAndImage() {
        uiBean.setAllPrintFlg(true);

        nkronriChkAndjyouhoSyutoku();
    }

    private void setHosyouHutanpo(IT_SyouhnTokujou pSyouhnTokujou) {

        Class<?> syouhnTokujouClass = pSyouhnTokujou.getClass().getSuperclass();
        Class<?> uiBeanClass = uiBean.getClass().getSuperclass();

        for (int idx = 1; idx < 5; idx++) {
            try {
                Field htnpbuicdField = syouhnTokujouClass.getDeclaredField("htnpbuicd" + idx);
                Field htnpkknField = syouhnTokujouClass.getDeclaredField("htnpkkn" + idx);
                htnpbuicdField.setAccessible(true);
                htnpkknField.setAccessible(true);

                if ((null != htnpbuicdField.get(pSyouhnTokujou)) && (!BizUtil.isBlank(htnpbuicdField.get(pSyouhnTokujou).toString()))) {
                    BM_HutanpoBui hutanpoBui =
                        bizDomManager.getHutanpoBui(htnpbuicdField.get(pSyouhnTokujou).toString());

                    if (hutanpoBui != null) {
                        Field vhsyusyuhtnpbuicdField = uiBeanClass.getDeclaredField("vhsyusyuhtnpbuicd" + idx);
                        Field vhsyusyuhtnpbuinmField = uiBeanClass.getDeclaredField("vhsyusyuhtnpbuinm" + idx);
                        Field vhsyusyuhtnpkknField = uiBeanClass.getDeclaredField("vhsyusyuhtnpkkn" + idx);

                        vhsyusyuhtnpbuicdField.setAccessible(true);
                        vhsyusyuhtnpbuinmField.setAccessible(true);
                        vhsyusyuhtnpkknField.setAccessible(true);

                        vhsyusyuhtnpbuicdField.set(uiBean, htnpbuicdField.get(pSyouhnTokujou));
                        vhsyusyuhtnpbuinmField.set(uiBean,hutanpoBui.getHtnpbuinm());
                        vhsyusyuhtnpkknField.set(uiBean,htnpkknField.get(pSyouhnTokujou));
                    }
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }


        uiBean.setVhsyusyutokkdsghtnpkbn(pSyouhnTokujou.getTokkoudosghtnpkbn());

    }

    private void setTokuyaku(IT_KykKihon pKykKihon, List<IT_KykSyouhn> pKykSyouhnList) {
        Class<?> uiBeanSuperClass = uiBean.getClass().getSuperclass();

        for (int idx =1; idx < 11; idx++) {
            IT_KykSyouhn kykSyouhn = null;
            if (pKykSyouhnList.size() >= idx) {
                kykSyouhn = pKykSyouhnList.get(idx - 1);
            }

            if (kykSyouhn != null) {
                IT_SyouhnTokujou syouhnTokujou =
                    pKykKihon.getSyouhnTokujouBySyutkkbnSyouhncdSyouhnsdnoKyksyouhnrenno(
                        C_SyutkKbn.TK,
                        kykSyouhn.getSyouhncd(),
                        kykSyouhn.getSyouhnsdno(),
                        kykSyouhn.getKyksyouhnrenno());


                String syouhinNm = "";
                BM_SyouhnZokusei syouhnZokusei = kykSyouhn.getSyouhnZokusei();
                if (syouhnZokusei != null) {
                    syouhinNm = syouhnZokusei.getSyouhnnm();
                }

                try {

                    Field vhsyudisptksyouhnnmdField = uiBeanSuperClass.getDeclaredField("vhsyudisptksyouhnnm" + idx);
                    Field vhsyudisptkhknkknField = uiBeanSuperClass.getDeclaredField("vhsyudisptkhknkkn" + idx);
                    Field vhsyudisptkhknkknsmnkbnField = uiBeanSuperClass.getDeclaredField("vhsyudisptkhknkknsmnkbn" + idx);
                    Field vhsyudisptkhrkkknField = uiBeanSuperClass.getDeclaredField("vhsyudisptkhrkkkn" + idx);
                    Field vhsyudisptkhrkkknsmnkbnField = uiBeanSuperClass.getDeclaredField("vhsyudisptkhrkkknsmnkbn" + idx);
                    Field vhsyudisptkkykymdField = uiBeanSuperClass.getDeclaredField("vhsyudisptkkykymd" + idx);
                    Field vhsyudisptksknnkaisiymdField = uiBeanSuperClass.getDeclaredField("vhsyudisptksknnkaisiymd" + idx);
                    Field vhsyudisptkhkskkaisiymdField = uiBeanSuperClass.getDeclaredField("vhsyudisptkhkskkaisiymd" + idx);
                    Field vhsyudisptkkihonsField = uiBeanSuperClass.getDeclaredField("vhsyudisptkkihons" + idx);
                    Field vhsyudisptktkjypField = uiBeanSuperClass.getDeclaredField("vhsyudisptktkjyp" + idx);
                    Field vhsyudisptktkkdsghtpkbnField = uiBeanSuperClass.getDeclaredField("vhsyudisptktkkdsghtpkbn" + idx);

                    vhsyudisptksyouhnnmdField.setAccessible(true);
                    vhsyudisptkhknkknField.setAccessible(true);
                    vhsyudisptkhknkknsmnkbnField.setAccessible(true);
                    vhsyudisptkhrkkknField.setAccessible(true);
                    vhsyudisptkhrkkknsmnkbnField.setAccessible(true);
                    vhsyudisptkkykymdField.setAccessible(true);
                    vhsyudisptksknnkaisiymdField.setAccessible(true);
                    vhsyudisptkhkskkaisiymdField.setAccessible(true);
                    vhsyudisptkkihonsField.setAccessible(true);
                    vhsyudisptktkjypField.setAccessible(true);
                    vhsyudisptktkkdsghtpkbnField.setAccessible(true);

                    vhsyudisptksyouhnnmdField.set(uiBean, syouhinNm);
                    vhsyudisptkhknkknField.set(uiBean,kykSyouhn.getHknkkn());
                    vhsyudisptkhknkknsmnkbnField.set(uiBean,kykSyouhn.getHknkknsmnkbn());
                    vhsyudisptkhrkkknField.set(uiBean, kykSyouhn.getHrkkkn());
                    vhsyudisptkhrkkknsmnkbnField.set(uiBean, kykSyouhn.getHrkkknsmnkbn());
                    vhsyudisptkkykymdField.set(uiBean, kykSyouhn.getKykymd());
                    vhsyudisptksknnkaisiymdField.set(uiBean,kykSyouhn.getSknnkaisiymd());
                    vhsyudisptkhkskkaisiymdField.set(uiBean, kykSyouhn.getHksknnkaisiymd());
                    vhsyudisptkkihonsField.set(uiBean, kykSyouhn.getKihons());
                    vhsyudisptktkjypField.set(uiBean, kykSyouhn.getHokenryou());


                    if (syouhnTokujou != null) {
                        Class<?> syouhnTokujouClass = syouhnTokujou.getClass().getSuperclass();

                        for (int idy = 1; idy < 5; idy++) {
                            Field htnpbuicdField = syouhnTokujouClass.getDeclaredField("htnpbuicd" + idy);
                            Field htnpkknField = syouhnTokujouClass.getDeclaredField("htnpkkn" + idy);
                            htnpbuicdField.setAccessible(true);
                            htnpkknField.setAccessible(true);

                            if ((null != htnpbuicdField.get(syouhnTokujou)) && (!BizUtil.isBlank(htnpbuicdField.get(syouhnTokujou).toString()))) {
                                BM_HutanpoBui hutanpoBui =
                                    bizDomManager.getHutanpoBui(htnpbuicdField.get(syouhnTokujou).toString());

                                if (hutanpoBui != null) {
                                    Field vhsyudisptkhtnpbuicdField = uiBeanSuperClass.getDeclaredField("vhsyudisptkhtnpbuicd" + idy + idx);
                                    Field vhsyudisptkhtnpbuinmField = uiBeanSuperClass.getDeclaredField("vhsyudisptkhtnpbuinm" + idy + idx);
                                    Field vhsyudisptkhtnpkknField = uiBeanSuperClass.getDeclaredField("vhsyudisptkhtnpkkn" + idy + idx);
                                    vhsyudisptkhtnpbuicdField.setAccessible(true);
                                    vhsyudisptkhtnpbuinmField.setAccessible(true);
                                    vhsyudisptkhtnpkknField.setAccessible(true);

                                    vhsyudisptkhtnpbuicdField.set(uiBean, htnpbuicdField.get(syouhnTokujou));
                                    vhsyudisptkhtnpbuinmField.set(uiBean,hutanpoBui.getHtnpbuinm());
                                    vhsyudisptkhtnpkknField.set(uiBean,htnpkknField.get(syouhnTokujou));
                                }
                            }
                        }

                        if (!syouhnTokujou.getTokkoudosghtnpkbn().eq(C_TokkoudosghtnpKbn.BLNK)) {
                            vhsyudisptktkkdsghtpkbnField.set(uiBean,syouhnTokujou.getTokkoudosghtnpkbn());
                        }

                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else {
                try {
                    Class<?> uiBeanClass = uiBean.getClass();

                    Field tokuyakuFlagField = uiBeanClass.getDeclaredField("tokuyaku" + idx + "Flag");
                    tokuyakuFlagField.setAccessible(true);

                    tokuyakuFlagField.set(uiBean, false);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private void setSibouHokenkinUkt(IT_KykKihon pKykKihon, BizDate pSyrUketsukeymd) {


        if (pKykKihon.getSbuktnin() >= 5) {
            uiBean.setVshktsbuktnin(pKykKihon.getSbuktnin());

            uiBean.setUketoriJyouhou1Flag(false);
            uiBean.setUketoriJyouhou2Flag(false);
            uiBean.setUketoriJyouhou3Flag(false);
            uiBean.setUketoriJyouhou4Flag(false);
        }
        else {
            uiBean.setSibouketoriNinzuFlag(false);

            List<IT_KykUkt> kykUktList = pKykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

            if (kykUktList.size() != 0) {


                Class<?> uiBeanSuperClass = uiBean.getClass().getSuperclass();

                for (int idx = 1; idx < 5; idx++) {
                    IT_KykUkt kykUkt = null;
                    if (kykUktList.size() >= idx) {
                        kykUkt = kykUktList.get(idx - 1);
                    }

                    if (kykUkt != null) {
                        SiSetUiBean siSetUiBean = SWAKInjector.getInstance(SiSetUiBean.class);
                        String dispmskmjskjuktnen = siSetUiBean.setMskmjSkjNen(
                            pKykKihon.getMosymd(),
                            pSyrUketsukeymd,
                            kykUkt.getUktseiymd()
                            );

                        try {
                            Field vshktdispsbuktkbnField =null;
                            if (idx == 1) {
                                vshktdispsbuktkbnField = uiBeanSuperClass.getDeclaredField("vshktdispsbuktkbn" + idx);
                                vshktdispsbuktkbnField.setAccessible(true);
                                vshktdispsbuktkbnField.set(uiBean, kykUkt.getUktkbn());
                            }
                            Field vshktdispsbuktnmknField = uiBeanSuperClass.getDeclaredField("vshktdispsbuktnmkn" + idx);
                            Field vshktdispsbuktnmkjField = uiBeanSuperClass.getDeclaredField("vshktdispsbuktnmkj" + idx);
                            Field vshktdispsbuktseiymdField = uiBeanSuperClass.getDeclaredField("vshktdispsbuktseiymd" + idx);
                            Field dispmskmjskjuktnenField = uiBeanSuperClass.getDeclaredField("dispmskmjskjuktnen" + idx);
                            Field vshktdispsbuktbnwariField = uiBeanSuperClass.getDeclaredField("vshktdispsbuktbnwari" + idx);

                            vshktdispsbuktnmknField.setAccessible(true);
                            vshktdispsbuktnmkjField.setAccessible(true);
                            vshktdispsbuktseiymdField.setAccessible(true);
                            dispmskmjskjuktnenField.setAccessible(true);
                            vshktdispsbuktbnwariField.setAccessible(true);

                            vshktdispsbuktnmknField.set(uiBean, kykUkt.getUktnmkn());
                            vshktdispsbuktnmkjField.set(uiBean, kykUkt.getUktnmkj());
                            vshktdispsbuktseiymdField.set(uiBean, kykUkt.getUktseiymd());
                            dispmskmjskjuktnenField.set(uiBean, dispmskmjskjuktnen);
                            vshktdispsbuktbnwariField.set(uiBean, kykUkt.getUktbnwari());
                        }
                        catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    else {
                        try {
                            Class<?> uiBeanClass = uiBean.getClass();

                            Field uketoriJyouhouFlagField = uiBeanClass.getDeclaredField("uketoriJyouhou" + idx + "Flag");
                            uketoriJyouhouFlagField.setAccessible(true);

                            uketoriJyouhouFlagField.set(uiBean, false);
                        }
                        catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            else {
                uiBean.setUketoriJyouhou1Flag(false);
                uiBean.setUketoriJyouhou2Flag(false);
                uiBean.setUketoriJyouhou3Flag(false);
                uiBean.setUketoriJyouhou4Flag(false);
            }
        }
    }

    private void setFatcaTaisyousya(List<IT_FatcaInfo> pFatcaInfos) {

        Class<?> uiBeanSuperClass = uiBean.getClass().getSuperclass();

        for (int idx = 1; idx < 6; idx++) {
            IT_FatcaInfo fatcaInfo = null;
            if (pFatcaInfos.size() >= idx) {
                fatcaInfo = pFatcaInfos.get(idx - 1);
            }

            if (fatcaInfo != null) {
                try {
                    Field vtdktdispsyoriymdField = uiBeanSuperClass.getDeclaredField("vtdktdispsyoriymd" + idx);
                    Field vtdktdispfatcasnsikbnField = uiBeanSuperClass.getDeclaredField("vtdktdispfatcasnsikbn" + idx);
                    Field vtdktdispbikkjnssinfokbnField = uiBeanSuperClass.getDeclaredField("vtdktdispbikkjnssinfokbn" + idx);
                    Field vtdktdispfatcakekkbnField = uiBeanSuperClass.getDeclaredField("vtdktdispfatcakekkbn" + idx);
                    Field vtdktdispfatcahankeiikbnField = uiBeanSuperClass.getDeclaredField("vtdktdispfatcahankeiikbn" + idx);
                    Field vtdktdispbikknzsynoField = uiBeanSuperClass.getDeclaredField("vtdktdispbikknzsyno" + idx);
                    Field vtdktdispsyomeiymdField = uiBeanSuperClass.getDeclaredField("vtdktdispsyomeiymd" + idx);
                    Field vtdktdispfatcatgkbnField = uiBeanSuperClass.getDeclaredField("vtdktdispfatcatgkbn" + idx);
                    Field vtdktdispnmknField = uiBeanSuperClass.getDeclaredField("vtdktdispnmkn" + idx);
                    Field vvtdktdispnmkjField = uiBeanSuperClass.getDeclaredField("vtdktdispnmkj" + idx);
                    Field vtdktdispseiymdField = uiBeanSuperClass.getDeclaredField("vtdktdispseiymd" + idx);
                    Field vtdktdispseiField = uiBeanSuperClass.getDeclaredField("vtdktdispsei" + idx);
                    Field vtdktdispkouryokuendymdField = uiBeanSuperClass.getDeclaredField("vtdktdispkouryokuendymd" + idx);

                    vtdktdispsyoriymdField.setAccessible(true);
                    vtdktdispfatcasnsikbnField.setAccessible(true);
                    vtdktdispbikkjnssinfokbnField.setAccessible(true);
                    vtdktdispfatcakekkbnField.setAccessible(true);
                    vtdktdispfatcahankeiikbnField.setAccessible(true);
                    vtdktdispbikknzsynoField.setAccessible(true);
                    vtdktdispsyomeiymdField.setAccessible(true);
                    vtdktdispfatcatgkbnField.setAccessible(true);
                    vtdktdispnmknField.setAccessible(true);
                    vvtdktdispnmkjField.setAccessible(true);
                    vtdktdispseiymdField.setAccessible(true);
                    vtdktdispseiField.setAccessible(true);
                    vtdktdispkouryokuendymdField.setAccessible(true);

                    vtdktdispsyoriymdField.set(uiBean, fatcaInfo.getSyoriYmd());
                    vtdktdispfatcasnsikbnField.set(uiBean, fatcaInfo.getFatcasnsikbn());
                    vtdktdispbikkjnssinfokbnField.set(uiBean, fatcaInfo.getBikkjnssinfokbn());
                    vtdktdispfatcakekkbnField.set(uiBean, fatcaInfo.getFatcakekkbn());
                    vtdktdispfatcahankeiikbnField.set(uiBean, fatcaInfo.getFatcahankeiikbn());
                    vtdktdispbikknzsynoField.set(uiBean, fatcaInfo.getBikknzsyno());
                    vtdktdispsyomeiymdField.set(uiBean, fatcaInfo.getSyomeiymd());
                    vtdktdispfatcatgkbnField.set(uiBean, fatcaInfo.getFatcatgkbn());
                    vtdktdispnmknField.set(uiBean, fatcaInfo.getNmkn());
                    vvtdktdispnmkjField.set(uiBean, fatcaInfo.getNmkj());
                    vtdktdispseiymdField.set(uiBean, fatcaInfo.getSeiymd());
                    vtdktdispseiField.set(uiBean, fatcaInfo.getSeibetu());
                    vtdktdispkouryokuendymdField.set(uiBean, fatcaInfo.getKouryokuendymd());
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else {
                try {
                    Class<?> uiBeanClass = uiBean.getClass();
                    Field fatcaTaisyouFlagField = uiBeanClass.getDeclaredField("fatcaTaisyou" + idx + "Flag");
                    fatcaTaisyouFlagField.setAccessible(true);

                    fatcaTaisyouFlagField.set(uiBean, false);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    private void setMRHansyaInfo(String pSyono) {

        C_UmuKbn kykmrumu = C_UmuKbn.NONE;
        C_UmuKbn kykhnsyumu = C_UmuKbn.NONE;
        C_UmuKbn hhknmrumu = C_UmuKbn.NONE;
        C_UmuKbn hhknhnsyumu = C_UmuKbn.NONE;


        BzSakuinTsnSyoukaiYokenBean bzSakuinTsnSyoukaiYokenBean = SWAKInjector.getInstance(BzSakuinTsnSyoukaiYokenBean.class);
        BzSakuinTsnSyoukaiMq bzSakuinTsnSyoukaiMq = SWAKInjector.getInstance(BzSakuinTsnSyoukaiMq.class);


        bzSakuinTsnSyoukaiYokenBean.setSkintsnsyoukaikbn(C_SakuintsnSyoukaiKbn.KYKKEYSYOUKAI);
        bzSakuinTsnSyoukaiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.SYONO);
        bzSakuinTsnSyoukaiYokenBean.setHuho2kykno(pSyono);
        bzSakuinTsnSyoukaiYokenBean.setSkintsntaisyoukbn(C_SakuintsnTaisyouKbn.KYK);
        bzSakuinTsnSyoukaiYokenBean.setSkininfosyoukaiyhkbn(C_YouhiKbn.HUYOU);
        bzSakuinTsnSyoukaiYokenBean.setMrsignalsyoukaiyhkbn(C_YouhiKbn.YOU);
        bzSakuinTsnSyoukaiYokenBean.setMrsignalhanteigyoumukbn(C_MrsignalhanteigyoumuKbn.OTHER);
        bzSakuinTsnSyoukaiYokenBean.setTsngksyoukaiyhkbn(C_YouhiKbn.HUYOU);
        bzSakuinTsnSyoukaiYokenBean.setKykdrtentsnsssyoukaiyhkbn(C_YouhiKbn.HUYOU);
        bzSakuinTsnSyoukaiYokenBean.setMossakuseikahisyoukaiyhkbn(C_YouhiKbn.HUYOU);
        bzSakuinTsnSyoukaiYokenBean.setHndketyhsyoukaiyhkbn(C_YouhiKbn.HUYOU);

        BzSakuinTsnSyoukaiKekkaBean kykBzSakuinTsnSyoukaiKekkaBean = bzSakuinTsnSyoukaiMq.exec(bzSakuinTsnSyoukaiYokenBean);

        if (kykBzSakuinTsnSyoukaiKekkaBean.getMqsyorikekkakbn().eq(C_MQSyorikekkaKbn.ERROR)) {
            messageManager.addConversationMessageId(MQERR_GROUP_MESSAGE, MessageId.WJA1057, MessageUtil.getMessage(MessageId.IJW1087));
        }
        else if (kykBzSakuinTsnSyoukaiKekkaBean.getMqsyorikekkakbn().eq(C_MQSyorikekkaKbn.SEIJYOU)) {
            if (kykBzSakuinTsnSyoukaiKekkaBean.getPalsyoukaijissiumukbn().eq(C_PalSyoukaiJissiumuKbn.NONE)) {
                messageManager.addConversationMessageId(MQERR_GROUP_MESSAGE, MessageId.WJA1058, MessageUtil.getMessage(MessageId.IJW1087));
            }
            else if (kykBzSakuinTsnSyoukaiKekkaBean.getPalsyoukaijissiumukbn().eq(C_PalSyoukaiJissiumuKbn.ARI)) {


                bzSakuinTsnSyoukaiYokenBean = SWAKInjector.getInstance(BzSakuinTsnSyoukaiYokenBean.class);
                bzSakuinTsnSyoukaiMq = SWAKInjector.getInstance(BzSakuinTsnSyoukaiMq.class);


                bzSakuinTsnSyoukaiYokenBean.setSkintsnsyoukaikbn(C_SakuintsnSyoukaiKbn.KYKKEYSYOUKAI);
                bzSakuinTsnSyoukaiYokenBean.setHuho2kyknokbn(C_Huho2kyknoKbn.SYONO);
                bzSakuinTsnSyoukaiYokenBean.setHuho2kykno(pSyono);
                bzSakuinTsnSyoukaiYokenBean.setSkintsntaisyoukbn(C_SakuintsnTaisyouKbn.HHKN);
                bzSakuinTsnSyoukaiYokenBean.setSkininfosyoukaiyhkbn(C_YouhiKbn.HUYOU);
                bzSakuinTsnSyoukaiYokenBean.setMrsignalsyoukaiyhkbn(C_YouhiKbn.YOU);
                bzSakuinTsnSyoukaiYokenBean.setMrsignalhanteigyoumukbn(C_MrsignalhanteigyoumuKbn.OTHER);
                bzSakuinTsnSyoukaiYokenBean.setTsngksyoukaiyhkbn(C_YouhiKbn.HUYOU);
                bzSakuinTsnSyoukaiYokenBean.setKykdrtentsnsssyoukaiyhkbn(C_YouhiKbn.HUYOU);
                bzSakuinTsnSyoukaiYokenBean.setMossakuseikahisyoukaiyhkbn(C_YouhiKbn.HUYOU);
                bzSakuinTsnSyoukaiYokenBean.setHndketyhsyoukaiyhkbn(C_YouhiKbn.HUYOU);

                BzSakuinTsnSyoukaiKekkaBean hhknBzSakuinTsnSyoukaiKekkaBean = bzSakuinTsnSyoukaiMq.exec(bzSakuinTsnSyoukaiYokenBean);

                if (kykBzSakuinTsnSyoukaiKekkaBean.getMrsyoukaierrkbn().eq(C_MQSyoukaiErrorKbn.SYOUKAIOK) &&
                    hhknBzSakuinTsnSyoukaiKekkaBean.getMrsyoukaierrkbn().eq(C_MQSyoukaiErrorKbn.SYOUKAIOK)) {
                    if (kykBzSakuinTsnSyoukaiKekkaBean.getSntkinfomrumukbn().eq(C_BlnktkumuKbn.ARI)) {
                        kykmrumu = C_UmuKbn.ARI;
                    }
                    if (hhknBzSakuinTsnSyoukaiKekkaBean.getSntkinfomrumukbn().eq(C_BlnktkumuKbn.ARI)) {
                        hhknmrumu = C_UmuKbn.ARI;
                    }
                }
                else {
                    messageManager.addConversationMessageId(MQERR_GROUP_MESSAGE, MessageId.WJA1059, MessageUtil.getMessage(MessageId.IJW1086));
                }

                if (kykBzSakuinTsnSyoukaiKekkaBean.getSinsntkhnsysyoukaierrkbn().eq(C_MQSyoukaiErrorKbn.SYOUKAIOK) &&
                    hhknBzSakuinTsnSyoukaiKekkaBean.getSinsntkhnsysyoukaierrkbn().eq(C_MQSyoukaiErrorKbn.SYOUKAIOK)) {
                    if (kykBzSakuinTsnSyoukaiKekkaBean.getSinsntkhnsyumukbn().eq(C_BlnktkumuKbn.ARI)) {
                        kykhnsyumu = C_UmuKbn.ARI;
                    }
                    if (hhknBzSakuinTsnSyoukaiKekkaBean.getSinsntkhnsyumukbn().eq(C_BlnktkumuKbn.ARI)) {
                        hhknhnsyumu = C_UmuKbn.ARI;
                    }
                }
                else {
                    messageManager.addConversationMessageId(MQERR_GROUP_MESSAGE, MessageId.WJA1059, MessageUtil.getMessage(MessageId.IJW1085));
                }
            }
        }

        uiBean.setKykmrumu(kykmrumu);
        uiBean.setKykhnsyumu(kykhnsyumu);
        uiBean.setHhknmrumu(hhknmrumu);
        uiBean.setHhknhnsyumu(hhknhnsyumu);

    }

}
