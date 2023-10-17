package yuyu.app.hozen.khozen.khtetudukityuui;

import static yuyu.app.hozen.khozen.khtetudukityuui.KhTetudukiTyuuiConstants.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.exception.ForwardBizLogicException;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzGetSosikiData;
import yuyu.common.biz.bzcommon.BzGetSosikiDataBean;
import yuyu.common.biz.bzcommon.CheckKana;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutai;
import yuyu.common.hozen.khcommon.CheckYuuyokkngai;
import yuyu.common.hozen.khcommon.EditJimuRenrakuhyouParam;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTbl;
import yuyu.common.hozen.khcommon.EditTtdkRirekiTblParam;
import yuyu.common.hozen.khcommon.KhMessageGroupConstants;
import yuyu.common.hozen.khcommon.KhozenCommonParam;
import yuyu.common.hozen.khcommon.KhozenTyouhyouCtl;
import yuyu.common.hozen.khcommon.PALKykNaiyouKousin;
import yuyu.common.hozen.khcommon.TableMaintenanceUtil;
import yuyu.common.hozen.setuibean.SetBetukyk;
import yuyu.common.hozen.setuibean.SetHihokensya;
import yuyu.common.hozen.setuibean.SetKeiyakusya;
import yuyu.common.hozen.setuibean.SetKihon;
import yuyu.common.hozen.setuibean.SetKyksyadairi;
import yuyu.common.hozen.setuibean.SetToriatukaiTyuui;
import yuyu.common.hozen.setuibean.SetTrkKazoku;
import yuyu.def.MessageId;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_AeoiHoujinSyuruiKbn;
import yuyu.def.classification.C_AeoiKekkaKbn;
import yuyu.def.classification.C_AeoiSyoriKbn;
import yuyu.def.classification.C_AeoiTaisyousyaKbn;
import yuyu.def.classification.C_BikkjnssinfoKbn;
import yuyu.def.classification.C_FatcahankeiiKbn;
import yuyu.def.classification.C_FatcakekKbn;
import yuyu.def.classification.C_FatcasnsiKbn;
import yuyu.def.classification.C_FatcatgKbn;
import yuyu.def.classification.C_KktyuitaKbn;
import yuyu.def.classification.C_KykdrDouiYouhiKbn;
import yuyu.def.classification.C_KykdrknHtdjytKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_SosikimasterUmuKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_SysCdKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukoujyotaichkKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_AeoiInfo;
import yuyu.def.db.entity.IT_FatcaInfo;
import yuyu.def.db.entity.IT_KhTtdkRireki;
import yuyu.def.db.entity.IT_KhTtdkTyuui;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.infr.report.OutputReport;

/**
 * 契約保全手続注意設定 のビジネスロジックです。
 */
public class KhTetudukiTyuuiBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private KhTetudukiTyuuiUiBean uiBean;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private MessageManager messageManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    private int maxRenno;

    private int aeoiMaxRenno;

    void init() {
    }

    void clear() {
    }

    void pushSyoukaiBL() {

        uiBean.setSyono(uiBean.getVkihnsyono());

        isExist();

        checkJyoutai();

        checkYuuyokkngai();

        setTtdkTyuui();

        setSitiken();

        setUiBean();
        BizPropertyInitializer.initialize(uiBean);
    }

    void pushKakuninBtn() {
        C_KktyuitaKbn kktyuitakbn = uiBean.getKktyuitakbn();
        List<TtdkTyuui1DataSourceBean> ttdkTyuui1DataLst =
            uiBean.getTtdkTyuui1DataSource().getDatas();
        BizDate sysDate = BizDate.getSysDate();


        boolean fatcaHnkFlg = false;
        boolean aeoiHnkFlg = false;

        if (C_KktyuitaKbn.BLNK.eq(kktyuitakbn) && (!BizUtil.isBlank(uiBean.getTtdktyuuinaiyou1()) ||
            !BizUtil.isBlank(uiBean.getTtdktyuuinaiyou2()) || !BizUtil.isBlank(uiBean.getTtdktyuuinaiyou3()))) {

            throw new BizLogicException(MessageId.EIF1014);
        }

        for (int idx = 0; idx < uiBean.getRecordkensuu(); idx++) {

            if (idx == 0) {

                fatcaHnkFlg = fatcaHenkouCheck(
                    uiBean.getRenno1(), uiBean.getDispfatcasakujyo1(),
                    uiBean.getDispsyoriymd1(), uiBean.getBfrSyoriymd1(),
                    uiBean.getDispfatcasnsikbn1(), uiBean.getBfrfatcasnsikbn1(),
                    uiBean.getDispbikkjnssinfokbn1(), uiBean.getBfrbikkjnssinfokbn1(),
                    uiBean.getDispfatcakekkbn1(), uiBean.getBfrfatcakekkbn1(),
                    uiBean.getDispfatcahankeiikbn1(), uiBean.getBfrfatcahankeiikbn1(),
                    uiBean.getDispbikknzsyno1(), uiBean.getBfrbikknzsyno1(),
                    uiBean.getDispsyomeiymd1(), uiBean.getBfrsyomeiymd1(),
                    uiBean.getDispfatcatgkbn1(), uiBean.getBfrfatcatgkbn1(),
                    uiBean.getDispnmkn1(), uiBean.getBfrnmkn1(),
                    uiBean.getDispnmkj1(), uiBean.getBfrnmkj1(),
                    uiBean.getDispseiymd1(), uiBean.getBfrseiymd1(),
                    uiBean.getDispsei1(), uiBean.getBfrsei1(),
                    uiBean.getDispkouryokuendymd1(), uiBean.getBfrKouryokuendymd1());
                uiBean.setFatcaHnkFlg1(fatcaHnkFlg);

                if (fatcaHnkFlg) {

                    uiBean.setSyoriSosikicd1(baseUserInfo.getTmSosikiCd());
                    continue;
                }
            }
            else if (idx == 1) {

                fatcaHnkFlg = fatcaHenkouCheck(
                    uiBean.getRenno2(), uiBean.getDispfatcasakujyo2(),
                    uiBean.getDispsyoriymd2(), uiBean.getBfrSyoriymd2(),
                    uiBean.getDispfatcasnsikbn2(), uiBean.getBfrfatcasnsikbn2(),
                    uiBean.getDispbikkjnssinfokbn2(), uiBean.getBfrbikkjnssinfokbn2(),
                    uiBean.getDispfatcakekkbn2(), uiBean.getBfrfatcakekkbn2(),
                    uiBean.getDispfatcahankeiikbn2(), uiBean.getBfrfatcahankeiikbn2(),
                    uiBean.getDispbikknzsyno2(), uiBean.getBfrbikknzsyno2(),
                    uiBean.getDispsyomeiymd2(), uiBean.getBfrsyomeiymd2(),
                    uiBean.getDispfatcatgkbn2(), uiBean.getBfrfatcatgkbn2(),
                    uiBean.getDispnmkn2(), uiBean.getBfrnmkn2(),
                    uiBean.getDispnmkj2(), uiBean.getBfrnmkj2(),
                    uiBean.getDispseiymd2(), uiBean.getBfrseiymd2(),
                    uiBean.getDispsei2(), uiBean.getBfrsei2(),
                    uiBean.getDispkouryokuendymd2(), uiBean.getBfrKouryokuendymd2());
                uiBean.setFatcaHnkFlg2(fatcaHnkFlg);

                if (fatcaHnkFlg) {

                    uiBean.setSyoriSosikicd2(baseUserInfo.getTmSosikiCd());
                    continue;
                }
            }
            else if (idx == 2) {

                fatcaHnkFlg = fatcaHenkouCheck(
                    uiBean.getRenno3(), uiBean.getDispfatcasakujyo3(),
                    uiBean.getDispsyoriymd3(), uiBean.getBfrSyoriymd3(),
                    uiBean.getDispfatcasnsikbn3(), uiBean.getBfrfatcasnsikbn3(),
                    uiBean.getDispbikkjnssinfokbn3(), uiBean.getBfrbikkjnssinfokbn3(),
                    uiBean.getDispfatcakekkbn3(), uiBean.getBfrfatcakekkbn3(),
                    uiBean.getDispfatcahankeiikbn3(), uiBean.getBfrfatcahankeiikbn3(),
                    uiBean.getDispbikknzsyno3(), uiBean.getBfrbikknzsyno3(),
                    uiBean.getDispsyomeiymd3(), uiBean.getBfrsyomeiymd3(),
                    uiBean.getDispfatcatgkbn3(), uiBean.getBfrfatcatgkbn3(),
                    uiBean.getDispnmkn3(), uiBean.getBfrnmkn3(),
                    uiBean.getDispnmkj3(), uiBean.getBfrnmkj3(),
                    uiBean.getDispseiymd3(), uiBean.getBfrseiymd3(),
                    uiBean.getDispsei3(), uiBean.getBfrsei3(),
                    uiBean.getDispkouryokuendymd3(), uiBean.getBfrKouryokuendymd3());
                uiBean.setFatcaHnkFlg3(fatcaHnkFlg);

                if (fatcaHnkFlg) {

                    uiBean.setSyoriSosikicd3(baseUserInfo.getTmSosikiCd());
                    continue;
                }
            }
            else if (idx == 3) {

                fatcaHnkFlg = fatcaHenkouCheck(
                    uiBean.getRenno4(), uiBean.getDispfatcasakujyo4(),
                    uiBean.getDispsyoriymd4(), uiBean.getBfrSyoriymd4(),
                    uiBean.getDispfatcasnsikbn4(), uiBean.getBfrfatcasnsikbn4(),
                    uiBean.getDispbikkjnssinfokbn4(), uiBean.getBfrbikkjnssinfokbn4(),
                    uiBean.getDispfatcakekkbn4(), uiBean.getBfrfatcakekkbn4(),
                    uiBean.getDispfatcahankeiikbn4(), uiBean.getBfrfatcahankeiikbn4(),
                    uiBean.getDispbikknzsyno4(), uiBean.getBfrbikknzsyno4(),
                    uiBean.getDispsyomeiymd4(), uiBean.getBfrsyomeiymd4(),
                    uiBean.getDispfatcatgkbn4(), uiBean.getBfrfatcatgkbn4(),
                    uiBean.getDispnmkn4(), uiBean.getBfrnmkn4(),
                    uiBean.getDispnmkj4(), uiBean.getBfrnmkj4(),
                    uiBean.getDispseiymd4(), uiBean.getBfrseiymd4(),
                    uiBean.getDispsei4(), uiBean.getBfrsei4(),
                    uiBean.getDispkouryokuendymd4(), uiBean.getBfrKouryokuendymd4());
                uiBean.setFatcaHnkFlg4(fatcaHnkFlg);

                if (fatcaHnkFlg) {

                    uiBean.setSyoriSosikicd4(baseUserInfo.getTmSosikiCd());
                    continue;
                }
            }
            else if (idx == 4) {

                fatcaHnkFlg = fatcaHenkouCheck(
                    uiBean.getRenno5(), uiBean.getDispfatcasakujyo5(),
                    uiBean.getDispsyoriymd5(), uiBean.getBfrSyoriymd5(),
                    uiBean.getDispfatcasnsikbn5(), uiBean.getBfrfatcasnsikbn5(),
                    uiBean.getDispbikkjnssinfokbn5(), uiBean.getBfrbikkjnssinfokbn5(),
                    uiBean.getDispfatcakekkbn5(), uiBean.getBfrfatcakekkbn5(),
                    uiBean.getDispfatcahankeiikbn5(), uiBean.getBfrfatcahankeiikbn5(),
                    uiBean.getDispbikknzsyno5(), uiBean.getBfrbikknzsyno5(),
                    uiBean.getDispsyomeiymd5(), uiBean.getBfrsyomeiymd5(),
                    uiBean.getDispfatcatgkbn5(), uiBean.getBfrfatcatgkbn5(),
                    uiBean.getDispnmkn5(), uiBean.getBfrnmkn5(),
                    uiBean.getDispnmkj5(), uiBean.getBfrnmkj5(),
                    uiBean.getDispseiymd5(), uiBean.getBfrseiymd5(),
                    uiBean.getDispsei5(), uiBean.getBfrsei5(),
                    uiBean.getDispkouryokuendymd5(), uiBean.getBfrKouryokuendymd5());
                uiBean.setFatcaHnkFlg5(fatcaHnkFlg);

                if (fatcaHnkFlg) {

                    uiBean.setSyoriSosikicd5(baseUserInfo.getTmSosikiCd());
                    continue;
                }
            }
        }

        for (int idx = 0; idx < uiBean.getAeoirecordkensuu(); idx++) {
            if (idx == 0) {
                aeoiHnkFlg = aeoiHenkouCheck(uiBean.getAeoiRenno1(), uiBean.getDispaeoisakujyo1(),
                    uiBean.getDispaeoisyoriymd1(), uiBean.getBfrAeoiSyoriymd1(), uiBean.getDispaeoisyorisosikicd1(),
                    uiBean.getBfrAeoiSyorisosikicd1(), uiBean.getDispaeoikekkakbn1(), uiBean.getBfrAeoiKekkakbn1(),
                    uiBean.getDispaeoisyorikbn1(), uiBean.getBfrAeoiSyorikbn1(), uiBean.getDispaeoitaisyousyakbn1(),
                    uiBean.getBfrAeoiTaisyousyakbn1(), uiBean.getDispaeoihoujinsyuruikbn1(),
                    uiBean.getBfrAeoiHoujinsyuruikbn1(), uiBean.getDispaeoikouryokusttymd1(),
                    uiBean.getBfrAeoiKouryokusttymd1(), uiBean.getDispaeoikouryokuendymd1(),
                    uiBean.getBfrAeoiKouryokuendymd1());
                uiBean.setAeoiHnkFlg1(aeoiHnkFlg);

                if (aeoiHnkFlg) {

                    continue;
                }
            }
            else if (idx == 1) {

                aeoiHnkFlg = aeoiHenkouCheck(uiBean.getAeoiRenno2(), uiBean.getDispaeoisakujyo2(),
                    uiBean.getDispaeoisyoriymd2(), uiBean.getBfrAeoiSyoriymd2(), uiBean.getDispaeoisyorisosikicd2(),
                    uiBean.getBfrAeoiSyorisosikicd2(), uiBean.getDispaeoikekkakbn2(), uiBean.getBfrAeoiKekkakbn2(),
                    uiBean.getDispaeoisyorikbn2(), uiBean.getBfrAeoiSyorikbn2(), uiBean.getDispaeoitaisyousyakbn2(),
                    uiBean.getBfrAeoiTaisyousyakbn2(), uiBean.getDispaeoihoujinsyuruikbn2(),
                    uiBean.getBfrAeoiHoujinsyuruikbn2(), uiBean.getDispaeoikouryokusttymd2(),
                    uiBean.getBfrAeoiKouryokusttymd2(), uiBean.getDispaeoikouryokuendymd2(),
                    uiBean.getBfrAeoiKouryokuendymd2());
                uiBean.setAeoiHnkFlg2(aeoiHnkFlg);
                if (aeoiHnkFlg) {

                    continue;
                }
            }
            else if (idx == 2) {
                aeoiHnkFlg = aeoiHenkouCheck(uiBean.getAeoiRenno3(), uiBean.getDispaeoisakujyo3(),
                    uiBean.getDispaeoisyoriymd3(), uiBean.getBfrAeoiSyoriymd3(), uiBean.getDispaeoisyorisosikicd3(),
                    uiBean.getBfrAeoiSyorisosikicd3(), uiBean.getDispaeoikekkakbn3(), uiBean.getBfrAeoiKekkakbn3(),
                    uiBean.getDispaeoisyorikbn3(), uiBean.getBfrAeoiSyorikbn3(), uiBean.getDispaeoitaisyousyakbn3(),
                    uiBean.getBfrAeoiTaisyousyakbn3(), uiBean.getDispaeoihoujinsyuruikbn3(),
                    uiBean.getBfrAeoiHoujinsyuruikbn3(), uiBean.getDispaeoikouryokusttymd3(),
                    uiBean.getBfrAeoiKouryokusttymd3(), uiBean.getDispaeoikouryokuendymd3(),
                    uiBean.getBfrAeoiKouryokuendymd3());
                uiBean.setAeoiHnkFlg3(aeoiHnkFlg);
                if (aeoiHnkFlg) {

                    continue;
                }
            }
            else if (idx == 3) {
                aeoiHnkFlg = aeoiHenkouCheck(uiBean.getAeoiRenno4(), uiBean.getDispaeoisakujyo4(),
                    uiBean.getDispaeoisyoriymd4(), uiBean.getBfrAeoiSyoriymd4(), uiBean.getDispaeoisyorisosikicd4(),
                    uiBean.getBfrAeoiSyorisosikicd4(), uiBean.getDispaeoikekkakbn4(), uiBean.getBfrAeoiKekkakbn4(),
                    uiBean.getDispaeoisyorikbn4(), uiBean.getBfrAeoiSyorikbn4(), uiBean.getDispaeoitaisyousyakbn4(),
                    uiBean.getBfrAeoiTaisyousyakbn4(), uiBean.getDispaeoihoujinsyuruikbn4(),
                    uiBean.getBfrAeoiHoujinsyuruikbn4(), uiBean.getDispaeoikouryokusttymd4(),
                    uiBean.getBfrAeoiKouryokusttymd4(), uiBean.getDispaeoikouryokuendymd4(),
                    uiBean.getBfrAeoiKouryokuendymd4());
                uiBean.setAeoiHnkFlg4(aeoiHnkFlg);
                if (aeoiHnkFlg) {

                    continue;
                }
            }
            else if (idx == 4) {
                aeoiHnkFlg = aeoiHenkouCheck(uiBean.getAeoiRenno5(), uiBean.getDispaeoisakujyo5(),
                    uiBean.getDispaeoisyoriymd5(), uiBean.getBfrAeoiSyoriymd5(), uiBean.getDispaeoisyorisosikicd5(),
                    uiBean.getBfrAeoiSyorisosikicd5(), uiBean.getDispaeoikekkakbn5(), uiBean.getBfrAeoiKekkakbn5(),
                    uiBean.getDispaeoisyorikbn5(), uiBean.getBfrAeoiSyorikbn5(), uiBean.getDispaeoitaisyousyakbn5(),
                    uiBean.getBfrAeoiTaisyousyakbn5(), uiBean.getDispaeoihoujinsyuruikbn5(),
                    uiBean.getBfrAeoiHoujinsyuruikbn5(), uiBean.getDispaeoikouryokusttymd5(),
                    uiBean.getBfrAeoiKouryokusttymd5(), uiBean.getDispaeoikouryokuendymd5(),
                    uiBean.getBfrAeoiKouryokuendymd5());
                uiBean.setAeoiHnkFlg5(aeoiHnkFlg);
            }
        }

        ArrayList<TtdkTyuui1DataSourceBean> updateTtdkTyuui1DataLst = new ArrayList<>();


        C_TtdktyuuiKbn ttdktyuuikbn1 = C_TtdktyuuiKbn.BLNK;
        C_TtdktyuuiKbn ttdktyuuikbn2 = C_TtdktyuuiKbn.BLNK;
        C_TtdktyuuiKbn ttdktyuuikbn3 = C_TtdktyuuiKbn.BLNK;
        C_TtdktyuuiKbn ttdktyuuikbn4 = C_TtdktyuuiKbn.BLNK;
        C_TtdktyuuiKbn ttdktyuuikbn5 = C_TtdktyuuiKbn.BLNK;

        String ttdkTyuuiKbnHskNaiyou1 = null;
        String ttdkTyuuiKbnHskNaiyou2 = null;
        String ttdkTyuuiKbnHskNaiyou3 = null;
        String ttdkTyuuiKbnHskNaiyou4 = null;
        String ttdkTyuuiKbnHskNaiyou5 = null;

        BizDate ttdkTyuuiKbnSetYmd1 = null;
        BizDate ttdkTyuuiKbnSetYmd2 = null;
        BizDate ttdkTyuuiKbnSetYmd3 = null;
        BizDate ttdkTyuuiKbnSetYmd4 = null;
        BizDate ttdkTyuuiKbnSetYmd5 = null;

        C_TtdktyuuiKbn bfrTtdkTyuuiKbn1 = C_TtdktyuuiKbn.BLNK;
        C_TtdktyuuiKbn bfrTtdkTyuuiKbn2 = C_TtdktyuuiKbn.BLNK;
        C_TtdktyuuiKbn bfrTtdkTyuuiKbn3 = C_TtdktyuuiKbn.BLNK;
        C_TtdktyuuiKbn bfrTtdkTyuuiKbn4 = C_TtdktyuuiKbn.BLNK;
        C_TtdktyuuiKbn bfrTtdkTyuuiKbn5 = C_TtdktyuuiKbn.BLNK;

        String bfrTtdkTyuuiKbnHskNaiyou1 = "";
        String bfrTtdkTyuuiKbnHskNaiyou2 = "";
        String bfrTtdkTyuuiKbnHskNaiyou3 = "";
        String bfrTtdkTyuuiKbnHskNaiyou4 = "";
        String bfrTtdkTyuuiKbnHskNaiyou5 = "";

        BizDate bfrTtdkTyuuiKbnSetYmd1 = null;
        BizDate bfrTtdkTyuuiKbnSetYmd2 = null;
        BizDate bfrTtdkTyuuiKbnSetYmd3 = null;
        BizDate bfrTtdkTyuuiKbnSetYmd4 = null;
        BizDate bfrTtdkTyuuiKbnSetYmd5 = null;

        String bfrSetSosikicd1 = "";
        String bfrSetSosikicd2 = "";
        String bfrSetSosikicd3 = "";
        String bfrSetSosikicd4 = "";
        String bfrSetSosikicd5 = "";

        boolean ttdktyuuisakujyoKbn1 = false;
        boolean ttdktyuuisakujyoKbn2 = false;
        boolean ttdktyuuisakujyoKbn3 = false;
        boolean ttdktyuuisakujyoKbn4 = false;
        boolean ttdktyuuisakujyoKbn5 = false;

        TtdkTyuui1DataSourceBean ttdkTyuui1DataBean;
        boolean ttdkTyuuiSakujoCheckRet = true;
        boolean ttdkTyuuiMinyuryokuCheckRet = true;
        for (int idx = 0; idx < ttdkTyuui1DataLst.size(); idx++) {
            ttdkTyuui1DataBean = ttdkTyuui1DataLst.get(idx);

            if (idx == 0) {
                ttdktyuuikbn1 = ttdkTyuui1DataBean.getTtdktyuuikbn();
                ttdkTyuuiKbnHskNaiyou1 = ttdkTyuui1DataBean.getTtdktyuuikbnhsknaiyou();
                ttdkTyuuiKbnSetYmd1 = ttdkTyuui1DataBean.getTtdktyuuikbnsetymd();
                ttdktyuuisakujyoKbn1 = ttdkTyuui1DataBean.getTtdktyuuisakujyo();
                bfrTtdkTyuuiKbn1 = ttdkTyuui1DataBean.getBfrTtdktyuuikbn();
                bfrTtdkTyuuiKbnHskNaiyou1 = ttdkTyuui1DataBean.getBfrTtdktyuuikbnhsknaiyou();
                bfrTtdkTyuuiKbnSetYmd1 = ttdkTyuui1DataBean.getBfrTtdktyuuikbnsetymd();
                bfrSetSosikicd1 = ttdkTyuui1DataBean.getBfrSetsosikiCd();

                ttdkTyuuiSakujoCheckRet = ttdkTyuuiSakujoCheck(bfrTtdkTyuuiKbn1,
                    bfrTtdkTyuuiKbnHskNaiyou1,
                    bfrTtdkTyuuiKbnSetYmd1,
                    ttdktyuuisakujyoKbn1);

                if (!ttdkTyuuiSakujoCheckRet) {
                    break;
                }

                ttdkTyuuiMinyuryokuCheckRet = ttdkTyuuiMinyuryokuCheck(ttdktyuuikbn1,
                    ttdkTyuuiKbnHskNaiyou1,
                    ttdkTyuuiKbnSetYmd1,
                    ttdktyuuisakujyoKbn1);

                if (!ttdkTyuuiMinyuryokuCheckRet) {
                    break;
                }
            }
            else if (idx == 1) {
                ttdktyuuikbn2 = ttdkTyuui1DataBean.getTtdktyuuikbn();
                ttdkTyuuiKbnHskNaiyou2 = ttdkTyuui1DataBean.getTtdktyuuikbnhsknaiyou();
                ttdkTyuuiKbnSetYmd2 = ttdkTyuui1DataBean.getTtdktyuuikbnsetymd();
                ttdktyuuisakujyoKbn2 = ttdkTyuui1DataBean.getTtdktyuuisakujyo();
                bfrTtdkTyuuiKbn2 = ttdkTyuui1DataBean.getBfrTtdktyuuikbn();
                bfrTtdkTyuuiKbnHskNaiyou2 = ttdkTyuui1DataBean.getBfrTtdktyuuikbnhsknaiyou();
                bfrTtdkTyuuiKbnSetYmd2 = ttdkTyuui1DataBean.getBfrTtdktyuuikbnsetymd();
                bfrSetSosikicd2 = ttdkTyuui1DataBean.getBfrSetsosikiCd();

                ttdkTyuuiSakujoCheckRet = ttdkTyuuiSakujoCheck(bfrTtdkTyuuiKbn2,
                    bfrTtdkTyuuiKbnHskNaiyou2,
                    bfrTtdkTyuuiKbnSetYmd2,
                    ttdktyuuisakujyoKbn2);

                if (!ttdkTyuuiSakujoCheckRet) {
                    break;
                }

                ttdkTyuuiMinyuryokuCheckRet = ttdkTyuuiMinyuryokuCheck(ttdktyuuikbn2,
                    ttdkTyuuiKbnHskNaiyou2,
                    ttdkTyuuiKbnSetYmd2,
                    ttdktyuuisakujyoKbn2);

                if (!ttdkTyuuiMinyuryokuCheckRet) {
                    break;
                }
            }
            else if (idx == 2) {
                ttdktyuuikbn3 = ttdkTyuui1DataBean.getTtdktyuuikbn();
                ttdkTyuuiKbnHskNaiyou3 = ttdkTyuui1DataBean.getTtdktyuuikbnhsknaiyou();
                ttdkTyuuiKbnSetYmd3 = ttdkTyuui1DataBean.getTtdktyuuikbnsetymd();
                ttdktyuuisakujyoKbn3 = ttdkTyuui1DataBean.getTtdktyuuisakujyo();
                bfrTtdkTyuuiKbn3 = ttdkTyuui1DataBean.getBfrTtdktyuuikbn();
                bfrTtdkTyuuiKbnHskNaiyou3 = ttdkTyuui1DataBean.getBfrTtdktyuuikbnhsknaiyou();
                bfrTtdkTyuuiKbnSetYmd3 = ttdkTyuui1DataBean.getBfrTtdktyuuikbnsetymd();
                bfrSetSosikicd3 = ttdkTyuui1DataBean.getBfrSetsosikiCd();

                ttdkTyuuiSakujoCheckRet = ttdkTyuuiSakujoCheck(bfrTtdkTyuuiKbn3,
                    bfrTtdkTyuuiKbnHskNaiyou3,
                    bfrTtdkTyuuiKbnSetYmd3,
                    ttdktyuuisakujyoKbn3);

                if (!ttdkTyuuiSakujoCheckRet) {
                    break;
                }

                ttdkTyuuiMinyuryokuCheckRet = ttdkTyuuiMinyuryokuCheck(ttdktyuuikbn3,
                    ttdkTyuuiKbnHskNaiyou3,
                    ttdkTyuuiKbnSetYmd3,
                    ttdktyuuisakujyoKbn3);

                if (!ttdkTyuuiMinyuryokuCheckRet) {
                    break;
                }
            }
            else if (idx == 3) {
                ttdktyuuikbn4 = ttdkTyuui1DataBean.getTtdktyuuikbn();
                ttdkTyuuiKbnHskNaiyou4 = ttdkTyuui1DataBean.getTtdktyuuikbnhsknaiyou();
                ttdkTyuuiKbnSetYmd4 = ttdkTyuui1DataBean.getTtdktyuuikbnsetymd();
                ttdktyuuisakujyoKbn4 = ttdkTyuui1DataBean.getTtdktyuuisakujyo();
                bfrTtdkTyuuiKbn4 = ttdkTyuui1DataBean.getBfrTtdktyuuikbn();
                bfrTtdkTyuuiKbnHskNaiyou4 = ttdkTyuui1DataBean.getBfrTtdktyuuikbnhsknaiyou();
                bfrTtdkTyuuiKbnSetYmd4 = ttdkTyuui1DataBean.getBfrTtdktyuuikbnsetymd();
                bfrSetSosikicd4 = ttdkTyuui1DataBean.getBfrSetsosikiCd();

                ttdkTyuuiSakujoCheckRet = ttdkTyuuiSakujoCheck(bfrTtdkTyuuiKbn4,
                    bfrTtdkTyuuiKbnHskNaiyou4,
                    bfrTtdkTyuuiKbnSetYmd4,
                    ttdktyuuisakujyoKbn4);

                if (!ttdkTyuuiSakujoCheckRet) {
                    break;
                }

                ttdkTyuuiMinyuryokuCheckRet = ttdkTyuuiMinyuryokuCheck(ttdktyuuikbn4,
                    ttdkTyuuiKbnHskNaiyou4,
                    ttdkTyuuiKbnSetYmd4,
                    ttdktyuuisakujyoKbn4);

                if (!ttdkTyuuiMinyuryokuCheckRet) {
                    break;
                }
            }
            else if (idx == 4) {
                ttdktyuuikbn5 = ttdkTyuui1DataBean.getTtdktyuuikbn();
                ttdkTyuuiKbnHskNaiyou5 = ttdkTyuui1DataBean.getTtdktyuuikbnhsknaiyou();
                ttdkTyuuiKbnSetYmd5 = ttdkTyuui1DataBean.getTtdktyuuikbnsetymd();
                ttdktyuuisakujyoKbn5 = ttdkTyuui1DataBean.getTtdktyuuisakujyo();
                bfrTtdkTyuuiKbn5 = ttdkTyuui1DataBean.getBfrTtdktyuuikbn();
                bfrTtdkTyuuiKbnHskNaiyou5 = ttdkTyuui1DataBean.getBfrTtdktyuuikbnhsknaiyou();
                bfrTtdkTyuuiKbnSetYmd5 = ttdkTyuui1DataBean.getBfrTtdktyuuikbnsetymd();
                bfrSetSosikicd5 = ttdkTyuui1DataBean.getBfrSetsosikiCd();

                ttdkTyuuiSakujoCheckRet = ttdkTyuuiSakujoCheck(bfrTtdkTyuuiKbn5,
                    bfrTtdkTyuuiKbnHskNaiyou5,
                    bfrTtdkTyuuiKbnSetYmd5,
                    ttdktyuuisakujyoKbn5);

                if (!ttdkTyuuiSakujoCheckRet) {
                    break;
                }

                ttdkTyuuiMinyuryokuCheckRet = ttdkTyuuiMinyuryokuCheck(ttdktyuuikbn5,
                    ttdkTyuuiKbnHskNaiyou5,
                    ttdkTyuuiKbnSetYmd5,
                    ttdktyuuisakujyoKbn5);

                if (!ttdkTyuuiMinyuryokuCheckRet) {
                    break;
                }
            }
        }

        if (!ttdkTyuuiSakujoCheckRet) {

            throw new BizLogicException(MessageId.EIF1015);
        }

        if (!ttdkTyuuiMinyuryokuCheckRet) {

            throw new BizLogicException(MessageId.EBC0043, DISP_TTDKTYUUIKBN);
        }

        if (uiBean.getKykdrknhatudoujyoutai().eq(uiBean.getBrfKykdrknhatudoujyoutai())) {
            uiBean.setKykdrknhatudouHnkFlg(false);
        }
        else {
            uiBean.setKykdrknhatudouHnkFlg(true);
        }

        if (uiBean.getKykdrdouiyouhi().eq(uiBean.getBrfKykdrdouiyouhi())) {
            uiBean.setKykdrdouiyouhiHnkFlg(false);
        }
        else {
            uiBean.setKykdrdouiyouhiHnkFlg(true);
        }

        List<String> ttdktyuuiKbnNotDelLst = new ArrayList<String>();

        for (TtdkTyuui1DataSourceBean dataSourceBean :uiBean.getTtdkTyuui1DataSource().getAllData()) {
            if (!dataSourceBean.getTtdktyuuisakujyo()) {
                ttdktyuuiKbnNotDelLst.add(dataSourceBean.getTtdktyuuikbn().getValue());
            }
        }

        if (C_KykdrknHtdjytKbn.SETTEI.eq(uiBean.getKykdrknhatudoujyoutai())) {
            if (!ttdktyuuiKbnNotDelLst.contains(C_TtdktyuuiKbn.KYKSYAISINOURYOKUNASI.getValue())) {
                throw new BizLogicException(MessageId.EIF1131);
            }
        }
        else {
            if (C_KykdrDouiYouhiKbn.YOU.eq(uiBean.getKykdrdouiyouhi())) {
                if (ttdktyuuiKbnNotDelLst.contains(C_TtdktyuuiKbn.KYKSYAISINOURYOKUNASI.getValue())) {
                    throw new BizLogicException(MessageId.EIF1132);
                }
            }
        }


        TtdkTyuui1DataSourceBean updateTtdkTyuui1DataBean;
        int count = 0;

        BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);
        String setsosikiCd = "";

        if (C_TtdktyuuiKbn.BLNK.eq(bfrTtdkTyuuiKbn1) && BizUtil.isBlank(bfrTtdkTyuuiKbnHskNaiyou1) &&
            bfrTtdkTyuuiKbnSetYmd1 == null && BizUtil.isBlank(bfrSetSosikicd1)) {

            setsosikiCd = baseUserInfo.getTmSosikiCd();
        }
        else {

            if (!bfrSetSosikicd1.equals(baseUserInfo.getTmSosikiCd()) &&
                (!bfrTtdkTyuuiKbn1.eq(ttdktyuuikbn1) ||
                    !bfrTtdkTyuuiKbnHskNaiyou1.equals(ttdkTyuuiKbnHskNaiyou1) ||
                    BizDateUtil.compareYmd(bfrTtdkTyuuiKbnSetYmd1, ttdkTyuuiKbnSetYmd1) != BizDateUtil.COMPARE_EQUAL ||
                    ttdktyuuisakujyoKbn1)) {

                throw new BizLogicException(MessageId.EIF1030);
            }

            setsosikiCd = bfrSetSosikicd1;
        }

        if (!C_TtdktyuuiKbn.BLNK.eq(ttdktyuuikbn1)) {
            updateTtdkTyuui1DataBean = new TtdkTyuui1DataSourceBean();

            updateTtdkTyuui1DataBean.setTtdktyuuikbn(ttdktyuuikbn1);
            updateTtdkTyuui1DataBean.setTtdktyuuikbnhsknaiyou(ttdkTyuuiKbnHskNaiyou1);
            if (ttdkTyuuiKbnSetYmd1 == null) {
                updateTtdkTyuui1DataBean.setTtdktyuuikbnsetymd(sysDate);
            }
            else {
                updateTtdkTyuui1DataBean.setTtdktyuuikbnsetymd(ttdkTyuuiKbnSetYmd1);
            }

            updateTtdkTyuui1DataBean.setSetsosikiCd(setsosikiCd);

            BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(updateTtdkTyuui1DataBean.getSetsosikiCd());

            if (C_SosikimasterUmuKbn.ARI.eq(bzGetSosikiDataBean.getSosikimasterumukbn())) {

                updateTtdkTyuui1DataBean.setSetsosikinm(bzGetSosikiDataBean.getKanjisosikinm20());
            }

            updateTtdkTyuui1DataBean.setTtdktyuuisakujyo(ttdktyuuisakujyoKbn1);

            updateTtdkTyuui1DataBean.setBfrTtdktyuuikbn(bfrTtdkTyuuiKbn1);
            updateTtdkTyuui1DataBean.setBfrTtdktyuuikbnhsknaiyou(bfrTtdkTyuuiKbnHskNaiyou1);
            updateTtdkTyuui1DataBean.setBfrTtdktyuuikbnsetymd(bfrTtdkTyuuiKbnSetYmd1);
            updateTtdkTyuui1DataBean.setBfrSetsosikiCd(bfrSetSosikicd1);

            updateTtdkTyuui1DataLst.add(updateTtdkTyuui1DataBean);

            count++;
        }

        if (C_TtdktyuuiKbn.BLNK.eq(bfrTtdkTyuuiKbn2) && BizUtil.isBlank(bfrTtdkTyuuiKbnHskNaiyou2) &&
            bfrTtdkTyuuiKbnSetYmd2 == null && BizUtil.isBlank(bfrSetSosikicd2)) {

            setsosikiCd = baseUserInfo.getTmSosikiCd();
        }
        else {

            if (!bfrSetSosikicd2.equals(baseUserInfo.getTmSosikiCd()) &&
                (!bfrTtdkTyuuiKbn2.eq(ttdktyuuikbn2) ||
                    !bfrTtdkTyuuiKbnHskNaiyou2.equals(ttdkTyuuiKbnHskNaiyou2) ||
                    BizDateUtil.compareYmd(bfrTtdkTyuuiKbnSetYmd2, ttdkTyuuiKbnSetYmd2) != BizDateUtil.COMPARE_EQUAL ||
                    ttdktyuuisakujyoKbn2)) {

                throw new BizLogicException(MessageId.EIF1030);
            }

            setsosikiCd = bfrSetSosikicd2;
        }
        if (!C_TtdktyuuiKbn.BLNK.eq(ttdktyuuikbn2)) {

            updateTtdkTyuui1DataBean = new TtdkTyuui1DataSourceBean();

            updateTtdkTyuui1DataBean.setTtdktyuuikbn(ttdktyuuikbn2);
            updateTtdkTyuui1DataBean.setTtdktyuuikbnhsknaiyou(ttdkTyuuiKbnHskNaiyou2);
            if (ttdkTyuuiKbnSetYmd2 == null) {
                updateTtdkTyuui1DataBean.setTtdktyuuikbnsetymd(sysDate);
            }
            else {
                updateTtdkTyuui1DataBean.setTtdktyuuikbnsetymd(ttdkTyuuiKbnSetYmd2);
            }

            updateTtdkTyuui1DataBean.setSetsosikiCd(setsosikiCd);

            BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(updateTtdkTyuui1DataBean.getSetsosikiCd());

            if (C_SosikimasterUmuKbn.ARI.eq(bzGetSosikiDataBean.getSosikimasterumukbn())) {

                updateTtdkTyuui1DataBean.setSetsosikinm(bzGetSosikiDataBean.getKanjisosikinm20());
            }

            updateTtdkTyuui1DataBean.setTtdktyuuisakujyo(ttdktyuuisakujyoKbn2);

            updateTtdkTyuui1DataBean.setBfrTtdktyuuikbn(bfrTtdkTyuuiKbn2);
            updateTtdkTyuui1DataBean.setBfrTtdktyuuikbnhsknaiyou(bfrTtdkTyuuiKbnHskNaiyou2);
            updateTtdkTyuui1DataBean.setBfrTtdktyuuikbnsetymd(bfrTtdkTyuuiKbnSetYmd2);
            updateTtdkTyuui1DataBean.setBfrSetsosikiCd(bfrSetSosikicd2);

            updateTtdkTyuui1DataLst.add(updateTtdkTyuui1DataBean);

            count++;
        }

        if (C_TtdktyuuiKbn.BLNK.eq(bfrTtdkTyuuiKbn3) && BizUtil.isBlank(bfrTtdkTyuuiKbnHskNaiyou3) &&
            bfrTtdkTyuuiKbnSetYmd3 == null && BizUtil.isBlank(bfrSetSosikicd3)) {

            setsosikiCd = baseUserInfo.getTmSosikiCd();
        }
        else {

            if (!bfrSetSosikicd3.equals(baseUserInfo.getTmSosikiCd()) &&
                (!bfrTtdkTyuuiKbn3.eq(ttdktyuuikbn3) ||
                    !bfrTtdkTyuuiKbnHskNaiyou3.equals(ttdkTyuuiKbnHskNaiyou3) ||
                    BizDateUtil.compareYmd(bfrTtdkTyuuiKbnSetYmd3, ttdkTyuuiKbnSetYmd3) != BizDateUtil.COMPARE_EQUAL ||
                    ttdktyuuisakujyoKbn3)) {

                throw new BizLogicException(MessageId.EIF1030);
            }

            setsosikiCd = bfrSetSosikicd3;
        }
        if (!C_TtdktyuuiKbn.BLNK.eq(ttdktyuuikbn3)) {

            updateTtdkTyuui1DataBean = new TtdkTyuui1DataSourceBean();

            updateTtdkTyuui1DataBean.setTtdktyuuikbn(ttdktyuuikbn3);
            updateTtdkTyuui1DataBean.setTtdktyuuikbnhsknaiyou(ttdkTyuuiKbnHskNaiyou3);
            if (ttdkTyuuiKbnSetYmd3 == null) {
                updateTtdkTyuui1DataBean.setTtdktyuuikbnsetymd(sysDate);
            }
            else {
                updateTtdkTyuui1DataBean.setTtdktyuuikbnsetymd(ttdkTyuuiKbnSetYmd3);
            }

            updateTtdkTyuui1DataBean.setSetsosikiCd(setsosikiCd);

            BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(updateTtdkTyuui1DataBean.getSetsosikiCd());

            if (C_SosikimasterUmuKbn.ARI.eq(bzGetSosikiDataBean.getSosikimasterumukbn())) {

                updateTtdkTyuui1DataBean.setSetsosikinm(bzGetSosikiDataBean.getKanjisosikinm20());
            }

            updateTtdkTyuui1DataBean.setTtdktyuuisakujyo(ttdktyuuisakujyoKbn3);

            updateTtdkTyuui1DataBean.setBfrTtdktyuuikbn(bfrTtdkTyuuiKbn3);
            updateTtdkTyuui1DataBean.setBfrTtdktyuuikbnhsknaiyou(bfrTtdkTyuuiKbnHskNaiyou3);
            updateTtdkTyuui1DataBean.setBfrTtdktyuuikbnsetymd(bfrTtdkTyuuiKbnSetYmd3);
            updateTtdkTyuui1DataBean.setBfrSetsosikiCd(bfrSetSosikicd3);

            updateTtdkTyuui1DataLst.add(updateTtdkTyuui1DataBean);

            count++;
        }

        if (C_TtdktyuuiKbn.BLNK.eq(bfrTtdkTyuuiKbn4) && BizUtil.isBlank(bfrTtdkTyuuiKbnHskNaiyou4) &&
            bfrTtdkTyuuiKbnSetYmd4 == null && BizUtil.isBlank(bfrSetSosikicd4)) {

            setsosikiCd = baseUserInfo.getTmSosikiCd();
        }
        else {

            if (!bfrSetSosikicd4.equals(baseUserInfo.getTmSosikiCd()) &&
                (!bfrTtdkTyuuiKbn4.eq(ttdktyuuikbn4) ||
                    !bfrTtdkTyuuiKbnHskNaiyou4.equals(ttdkTyuuiKbnHskNaiyou4) ||
                    BizDateUtil.compareYmd(bfrTtdkTyuuiKbnSetYmd4, ttdkTyuuiKbnSetYmd4) != BizDateUtil.COMPARE_EQUAL ||
                    ttdktyuuisakujyoKbn4)) {

                throw new BizLogicException(MessageId.EIF1030);
            }

            setsosikiCd = bfrSetSosikicd4;
        }
        if (!C_TtdktyuuiKbn.BLNK.eq(ttdktyuuikbn4)) {

            updateTtdkTyuui1DataBean = new TtdkTyuui1DataSourceBean();

            updateTtdkTyuui1DataBean.setTtdktyuuikbn(ttdktyuuikbn4);
            updateTtdkTyuui1DataBean.setTtdktyuuikbnhsknaiyou(ttdkTyuuiKbnHskNaiyou4);
            if (ttdkTyuuiKbnSetYmd4 == null) {
                updateTtdkTyuui1DataBean.setTtdktyuuikbnsetymd(sysDate);
            }
            else {
                updateTtdkTyuui1DataBean.setTtdktyuuikbnsetymd(ttdkTyuuiKbnSetYmd4);
            }

            updateTtdkTyuui1DataBean.setSetsosikiCd(setsosikiCd);

            BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(updateTtdkTyuui1DataBean.getSetsosikiCd());

            if (C_SosikimasterUmuKbn.ARI.eq(bzGetSosikiDataBean.getSosikimasterumukbn())) {

                updateTtdkTyuui1DataBean.setSetsosikinm(bzGetSosikiDataBean.getKanjisosikinm20());
            }

            updateTtdkTyuui1DataBean.setTtdktyuuisakujyo(ttdktyuuisakujyoKbn4);

            updateTtdkTyuui1DataBean.setBfrTtdktyuuikbn(bfrTtdkTyuuiKbn4);
            updateTtdkTyuui1DataBean.setBfrTtdktyuuikbnhsknaiyou(bfrTtdkTyuuiKbnHskNaiyou4);
            updateTtdkTyuui1DataBean.setBfrTtdktyuuikbnsetymd(bfrTtdkTyuuiKbnSetYmd4);
            updateTtdkTyuui1DataBean.setBfrSetsosikiCd(bfrSetSosikicd4);

            updateTtdkTyuui1DataLst.add(updateTtdkTyuui1DataBean);

            count++;
        }

        if (C_TtdktyuuiKbn.BLNK.eq(bfrTtdkTyuuiKbn5) && BizUtil.isBlank(bfrTtdkTyuuiKbnHskNaiyou5) &&
            bfrTtdkTyuuiKbnSetYmd5 == null && BizUtil.isBlank(bfrSetSosikicd5)) {

            setsosikiCd = baseUserInfo.getTmSosikiCd();
        }
        else {

            if (!bfrSetSosikicd5.equals(baseUserInfo.getTmSosikiCd()) &&
                (!bfrTtdkTyuuiKbn5.eq(ttdktyuuikbn5) ||
                    !bfrTtdkTyuuiKbnHskNaiyou5.equals(ttdkTyuuiKbnHskNaiyou5) ||
                    BizDateUtil.compareYmd(bfrTtdkTyuuiKbnSetYmd5, ttdkTyuuiKbnSetYmd5) != BizDateUtil.COMPARE_EQUAL ||
                    ttdktyuuisakujyoKbn5)) {

                throw new BizLogicException(MessageId.EIF1030);
            }

            setsosikiCd = bfrSetSosikicd5;
        }
        if (!C_TtdktyuuiKbn.BLNK.eq(ttdktyuuikbn5)) {

            updateTtdkTyuui1DataBean = new TtdkTyuui1DataSourceBean();

            updateTtdkTyuui1DataBean.setTtdktyuuikbn(ttdktyuuikbn5);
            updateTtdkTyuui1DataBean.setTtdktyuuikbnhsknaiyou(ttdkTyuuiKbnHskNaiyou5);
            if (ttdkTyuuiKbnSetYmd5 == null) {
                updateTtdkTyuui1DataBean.setTtdktyuuikbnsetymd(sysDate);
            }
            else {
                updateTtdkTyuui1DataBean.setTtdktyuuikbnsetymd(ttdkTyuuiKbnSetYmd5);
            }

            updateTtdkTyuui1DataBean.setSetsosikiCd(setsosikiCd);

            BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(updateTtdkTyuui1DataBean.getSetsosikiCd());

            if (C_SosikimasterUmuKbn.ARI.eq(bzGetSosikiDataBean.getSosikimasterumukbn())) {

                updateTtdkTyuui1DataBean.setSetsosikinm(bzGetSosikiDataBean.getKanjisosikinm20());
            }

            updateTtdkTyuui1DataBean.setTtdktyuuisakujyo(ttdktyuuisakujyoKbn5);

            updateTtdkTyuui1DataBean.setBfrTtdktyuuikbn(bfrTtdkTyuuiKbn5);
            updateTtdkTyuui1DataBean.setBfrTtdktyuuikbnhsknaiyou(bfrTtdkTyuuiKbnHskNaiyou5);
            updateTtdkTyuui1DataBean.setBfrTtdktyuuikbnsetymd(bfrTtdkTyuuiKbnSetYmd5);
            updateTtdkTyuui1DataBean.setBfrSetsosikiCd(bfrSetSosikicd5);

            updateTtdkTyuui1DataLst.add(updateTtdkTyuui1DataBean);

            count++;
        }


        HashMap<String, String> hskNaiyouMap = new HashMap<>();
        HashMap<String, BizDate> setYmdMap = new HashMap<>();
        int bfrCount = 0;

        List<TtdkTyuui1DataSourceBean> bfrTtdkTyuui1DataLst =
            uiBean.getBfrTtdkTyuui1DataSource().getDatas();

        for (TtdkTyuui1DataSourceBean bfrTtdkTyuui1Data : bfrTtdkTyuui1DataLst) {
            if (!C_TtdktyuuiKbn.BLNK.eq(bfrTtdkTyuui1Data.getBfrTtdktyuuikbn())) {
                hskNaiyouMap.put(bfrTtdkTyuui1Data.getBfrTtdktyuuikbn().toString(), bfrTtdkTyuui1Data.getBfrTtdktyuuikbnhsknaiyou());
                setYmdMap.put(bfrTtdkTyuui1Data.getBfrTtdktyuuikbn().toString(), bfrTtdkTyuui1Data.getBfrTtdktyuuikbnsetymd());
                bfrCount++;
            }
        }

        boolean hikaku = true;

        if (count != bfrCount) {
            hikaku = false;
        }
        else {
            for (int idx = 0; idx < 5; idx++) {

                if (hikaku) {

                    C_TtdktyuuiKbn ttdktyuuikbn = C_TtdktyuuiKbn.BLNK;
                    String ttdkTyuuiKbnHskNaiyou = "";
                    BizDate ttdkTyuuiKbnSetYmd = null;
                    boolean blnTtdktyuuisakujyoKbn = false;

                    if (idx == 0) {
                        ttdktyuuikbn = ttdktyuuikbn1;
                        ttdkTyuuiKbnHskNaiyou = ttdkTyuuiKbnHskNaiyou1;
                        ttdkTyuuiKbnSetYmd = ttdkTyuuiKbnSetYmd1;
                        blnTtdktyuuisakujyoKbn = ttdktyuuisakujyoKbn1;
                    }
                    else if (idx == 1) {
                        ttdktyuuikbn = ttdktyuuikbn2;
                        ttdkTyuuiKbnHskNaiyou = ttdkTyuuiKbnHskNaiyou2;
                        ttdkTyuuiKbnSetYmd = ttdkTyuuiKbnSetYmd2;
                        blnTtdktyuuisakujyoKbn = ttdktyuuisakujyoKbn2;
                    }
                    else if (idx == 2) {
                        ttdktyuuikbn = ttdktyuuikbn3;
                        ttdkTyuuiKbnHskNaiyou = ttdkTyuuiKbnHskNaiyou3;
                        ttdkTyuuiKbnSetYmd = ttdkTyuuiKbnSetYmd3;
                        blnTtdktyuuisakujyoKbn = ttdktyuuisakujyoKbn3;
                    }
                    else if (idx == 3) {
                        ttdktyuuikbn = ttdktyuuikbn4;
                        ttdkTyuuiKbnHskNaiyou = ttdkTyuuiKbnHskNaiyou4;
                        ttdkTyuuiKbnSetYmd = ttdkTyuuiKbnSetYmd4;
                        blnTtdktyuuisakujyoKbn = ttdktyuuisakujyoKbn4;
                    }
                    else if (idx == 4) {
                        ttdktyuuikbn = ttdktyuuikbn5;
                        ttdkTyuuiKbnHskNaiyou = ttdkTyuuiKbnHskNaiyou5;
                        ttdkTyuuiKbnSetYmd = ttdkTyuuiKbnSetYmd5;
                        blnTtdktyuuisakujyoKbn = ttdktyuuisakujyoKbn5;
                    }

                    if (!C_TtdktyuuiKbn.BLNK.eq(ttdktyuuikbn)) {

                        if (hskNaiyouMap.containsKey(ttdktyuuikbn.toString())) {

                            String bfrTtdkTyuuiKbnHskNaiyou = hskNaiyouMap.get(ttdktyuuikbn.toString());
                            BizDate bfrTtdkTyuuiKbnSetYmd = setYmdMap.get(ttdktyuuikbn.toString());

                            if (ttdkTyuuiKbnSetYmd == null) {
                                ttdkTyuuiKbnSetYmd = sysDate;
                            }
                            if (blnTtdktyuuisakujyoKbn || !ttdkTyuuiKbnHskNaiyou.equals(bfrTtdkTyuuiKbnHskNaiyou) ||
                                BizDateUtil.compareYmd(bfrTtdkTyuuiKbnSetYmd, ttdkTyuuiKbnSetYmd) !=
                                BizDateUtil.COMPARE_EQUAL) {
                                hikaku = false;
                            }
                        }
                        else {
                            hikaku = false;
                        }
                    }
                }
            }
        }

        uiBean.setTtdktyuuiHnkUmu((!uiBean.getKktyuitakbn().eq(uiBean.getBfrKktyuitakbn()) ||
            !uiBean.getTtdktyuuinaiyou1().equals(uiBean.getBfrTtdktyuuinaiyou1()) ||
            !uiBean.getTtdktyuuinaiyou2().equals(uiBean.getBfrTtdktyuuinaiyou2()) ||
            !uiBean.getTtdktyuuinaiyou3().equals(uiBean.getBfrTtdktyuuinaiyou3()) ||
            !hikaku));

        if (!uiBean.isTtdktyuuiHnkUmu() &&
            uiBean.getStknsetkbn().eq(uiBean.getBfrStknsetKbn()) &&
            !uiBean.isKykdrknhatudouHnkFlg() &&
            !uiBean.isKykdrdouiyouhiHnkFlg() &&
            !uiBean.isFatcaHnkFlg1() &&
            !uiBean.isFatcaHnkFlg2() &&
            !uiBean.isFatcaHnkFlg3() &&
            !uiBean.isFatcaHnkFlg4() &&
            !uiBean.isFatcaHnkFlg5() &&
            !uiBean.isAeoiHnkFlg1() &&
            !uiBean.isAeoiHnkFlg2() &&
            !uiBean.isAeoiHnkFlg3() &&
            !uiBean.isAeoiHnkFlg4() &&
            !uiBean.isAeoiHnkFlg5()
            ) {
            throw new BizLogicException(MessageId.EIA0044, DISP_TTDKTYUUINAIYOU1);
        }


        int nameKeta = YuyuBizConfig.getInstance().getKzmeigiKanaNmKyoyou();

        for (int idx = 0; idx < 5; idx++) {

            if (idx == 0) {
                fatcaInputCheck(nameKeta,
                    uiBean.getRenno1(),
                    uiBean.getDispfatcasakujyo1(),
                    uiBean.getDispsyoriymd1(),
                    uiBean.getDispfatcasnsikbn1(),
                    uiBean.getDispbikkjnssinfokbn1(),
                    uiBean.getDispfatcakekkbn1(),
                    uiBean.getDispfatcahankeiikbn1(),
                    uiBean.getDispbikknzsyno1(),
                    uiBean.getDispsyomeiymd1(),
                    uiBean.getDispfatcatgkbn1(),
                    uiBean.getDispnmkn1(),
                    uiBean.getDispnmkj1(),
                    uiBean.getDispseiymd1(),
                    uiBean.getDispsei1(),
                    uiBean.getDispkouryokuendymd1());

                aeoiInputCheck(uiBean.getAeoiRenno1(),
                    uiBean.getDispaeoisakujyo1(),
                    uiBean.getDispaeoisyoriymd1(),
                    uiBean.getDispaeoisyorisosikicd1(),
                    uiBean.getDispaeoikekkakbn1(),
                    uiBean.getDispaeoisyorikbn1(),
                    uiBean.getDispaeoitaisyousyakbn1(),
                    uiBean.getDispaeoihoujinsyuruikbn1(),
                    uiBean.getDispaeoikouryokusttymd1(),
                    uiBean.getDispaeoikouryokuendymd1());
            }
            else if (idx == 1) {
                fatcaInputCheck(nameKeta,
                    uiBean.getRenno2(),
                    uiBean.getDispfatcasakujyo2(),
                    uiBean.getDispsyoriymd2(),
                    uiBean.getDispfatcasnsikbn2(),
                    uiBean.getDispbikkjnssinfokbn2(),
                    uiBean.getDispfatcakekkbn2(),
                    uiBean.getDispfatcahankeiikbn2(),
                    uiBean.getDispbikknzsyno2(),
                    uiBean.getDispsyomeiymd2(),
                    uiBean.getDispfatcatgkbn2(),
                    uiBean.getDispnmkn2(),
                    uiBean.getDispnmkj2(),
                    uiBean.getDispseiymd2(),
                    uiBean.getDispsei2(),
                    uiBean.getDispkouryokuendymd2());

                aeoiInputCheck(uiBean.getAeoiRenno2(),
                    uiBean.getDispaeoisakujyo2(),
                    uiBean.getDispaeoisyoriymd2(),
                    uiBean.getDispaeoisyorisosikicd2(),
                    uiBean.getDispaeoikekkakbn2(),
                    uiBean.getDispaeoisyorikbn2(),
                    uiBean.getDispaeoitaisyousyakbn2(),
                    uiBean.getDispaeoihoujinsyuruikbn2(),
                    uiBean.getDispaeoikouryokusttymd2(),
                    uiBean.getDispaeoikouryokuendymd2());
            }
            else if (idx == 2) {
                fatcaInputCheck(nameKeta,
                    uiBean.getRenno3(),
                    uiBean.getDispfatcasakujyo3(),
                    uiBean.getDispsyoriymd3(),
                    uiBean.getDispfatcasnsikbn3(),
                    uiBean.getDispbikkjnssinfokbn3(),
                    uiBean.getDispfatcakekkbn3(),
                    uiBean.getDispfatcahankeiikbn3(),
                    uiBean.getDispbikknzsyno3(),
                    uiBean.getDispsyomeiymd3(),
                    uiBean.getDispfatcatgkbn3(),
                    uiBean.getDispnmkn3(),
                    uiBean.getDispnmkj3(),
                    uiBean.getDispseiymd3(),
                    uiBean.getDispsei3(),
                    uiBean.getDispkouryokuendymd3());

                aeoiInputCheck(uiBean.getAeoiRenno3(),
                    uiBean.getDispaeoisakujyo3(),
                    uiBean.getDispaeoisyoriymd3(),
                    uiBean.getDispaeoisyorisosikicd3(),
                    uiBean.getDispaeoikekkakbn3(),
                    uiBean.getDispaeoisyorikbn3(),
                    uiBean.getDispaeoitaisyousyakbn3(),
                    uiBean.getDispaeoihoujinsyuruikbn3(),
                    uiBean.getDispaeoikouryokusttymd3(),
                    uiBean.getDispaeoikouryokuendymd3());
            }
            else if (idx == 3) {
                fatcaInputCheck(nameKeta,
                    uiBean.getRenno4(),
                    uiBean.getDispfatcasakujyo4(),
                    uiBean.getDispsyoriymd4(),
                    uiBean.getDispfatcasnsikbn4(),
                    uiBean.getDispbikkjnssinfokbn4(),
                    uiBean.getDispfatcakekkbn4(),
                    uiBean.getDispfatcahankeiikbn4(),
                    uiBean.getDispbikknzsyno4(),
                    uiBean.getDispsyomeiymd4(),
                    uiBean.getDispfatcatgkbn4(),
                    uiBean.getDispnmkn4(),
                    uiBean.getDispnmkj4(),
                    uiBean.getDispseiymd4(),
                    uiBean.getDispsei4(),
                    uiBean.getDispkouryokuendymd4());

                aeoiInputCheck(uiBean.getAeoiRenno4(),
                    uiBean.getDispaeoisakujyo4(),
                    uiBean.getDispaeoisyoriymd4(),
                    uiBean.getDispaeoisyorisosikicd4(),
                    uiBean.getDispaeoikekkakbn4(),
                    uiBean.getDispaeoisyorikbn4(),
                    uiBean.getDispaeoitaisyousyakbn4(),
                    uiBean.getDispaeoihoujinsyuruikbn4(),
                    uiBean.getDispaeoikouryokusttymd4(),
                    uiBean.getDispaeoikouryokuendymd4());
            }
            else if (idx == 4) {
                fatcaInputCheck(nameKeta,
                    uiBean.getRenno5(),
                    uiBean.getDispfatcasakujyo5(),
                    uiBean.getDispsyoriymd5(),
                    uiBean.getDispfatcasnsikbn5(),
                    uiBean.getDispbikkjnssinfokbn5(),
                    uiBean.getDispfatcakekkbn5(),
                    uiBean.getDispfatcahankeiikbn5(),
                    uiBean.getDispbikknzsyno5(),
                    uiBean.getDispsyomeiymd5(),
                    uiBean.getDispfatcatgkbn5(),
                    uiBean.getDispnmkn5(),
                    uiBean.getDispnmkj5(),
                    uiBean.getDispseiymd5(),
                    uiBean.getDispsei5(),
                    uiBean.getDispkouryokuendymd5());

                aeoiInputCheck(uiBean.getAeoiRenno5(),
                    uiBean.getDispaeoisakujyo5(),
                    uiBean.getDispaeoisyoriymd5(),
                    uiBean.getDispaeoisyorisosikicd5(),
                    uiBean.getDispaeoikekkakbn5(),
                    uiBean.getDispaeoisyorikbn5(),
                    uiBean.getDispaeoitaisyousyakbn5(),
                    uiBean.getDispaeoihoujinsyuruikbn5(),
                    uiBean.getDispaeoikouryokusttymd5(),
                    uiBean.getDispaeoikouryokuendymd5());
            }
        }

        uiBean.setTtdkTyuui1(updateTtdkTyuui1DataLst);

        messageManager.addMessageId(MessageId.QBA0001);
    }

    void pushmodoruByConfirmBL() {
        setTtdkTyuuiForModoru();
    }

    @Transactional
    void pushKakuteiBL() {

        String syoNo = uiBean.getSyono();
        IT_KykKihon kykKihon = uiBean.getKykKihon();

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        TableMaintenanceUtil tableMaintenanceUtil = SWAKInjector.getInstance(TableMaintenanceUtil.class);

        String sikibetuKey = khozenCommonParam.getSikibetuKey(syoNo);

        tableMaintenanceUtil.backUp(syoNo, sikibetuKey);

        BizDate sysDate = BizDate.getSysDate();
        String sysTime = BizDate.getSysDateTimeMilli();

        updateKTKykKihon(sysDate, sysTime);

        IT_KhTtdkRireki khTtdkRireki = kykKihon.createKhTtdkRireki();

        khTtdkRireki.setHenkousikibetukey(sikibetuKey);


        List<TtdkTyuui1DataSourceBean> ttdkTyuui1DataLst = uiBean.getTtdkTyuui1DataSource().getDatas();
        TtdkTyuui1DataSourceBean ttdkTyuui1DataBean;
        int dataSize = ttdkTyuui1DataLst.size();

        if (uiBean.isTtdktyuuiHnkUmu() || uiBean.isKykdrknhatudouHnkFlg() || uiBean.isKykdrdouiyouhiHnkFlg()) {

            IT_KhTtdkTyuui khTtdkTyuui;
            boolean khTtdkTyuuiFlag = false;
            boolean ttdkTyuuiUpdFlg = false;

            if (kykKihon.getKhTtdkTyuui() == null) {
                khTtdkTyuui = kykKihon.createKhTtdkTyuui();
            }
            else {
                khTtdkTyuui = kykKihon.getKhTtdkTyuui();
                khTtdkTyuuiFlag = true;
            }

            BizDate wkTtdkTyuuiSetDay = null;
            String wkTtdkTyuuiSetName = "";

            if (!uiBean.getKktyuitakbn().eq(C_KktyuitaKbn.BLNK)) {
                wkTtdkTyuuiSetDay = sysDate;
                wkTtdkTyuuiSetName = khozenCommonParam.getUserNm();
            }


            khTtdkTyuui.setTtdktyuuisetymd(wkTtdkTyuuiSetDay);
            khTtdkTyuui.setTtdktyuuisetnm(wkTtdkTyuuiSetName);
            khTtdkTyuui.setKktyuitakbn(uiBean.getKktyuitakbn());
            khTtdkTyuui.setTtdktyuuinaiyou1(uiBean.getTtdktyuuinaiyou1());
            khTtdkTyuui.setTtdktyuuinaiyou2(uiBean.getTtdktyuuinaiyou2());
            khTtdkTyuui.setTtdktyuuinaiyou3(uiBean.getTtdktyuuinaiyou3());


            for (int idx = 0; idx < 5; idx++) {
                if (idx == 0) {
                    if (idx < dataSize) {

                        ttdkTyuuiUpdFlg = true;

                        if (!ttdkTyuui1DataLst.get(idx).getTtdktyuuisakujyo()) {
                            ttdkTyuui1DataBean = ttdkTyuui1DataLst.get(idx);
                            khTtdkTyuui.setTtdktyuuikbn1(ttdkTyuui1DataBean.getTtdktyuuikbn());
                            khTtdkTyuui.setTtdktyuuikbnhsknaiyou1(ttdkTyuui1DataBean.getTtdktyuuikbnhsknaiyou());
                            khTtdkTyuui.setTtdktyuuikbnsetymd1(ttdkTyuui1DataBean.getTtdktyuuikbnsetymd());
                            khTtdkTyuui.setSetsosikicd1(ttdkTyuui1DataBean.getSetsosikiCd());
                        } else {
                            khTtdkTyuui.setTtdktyuuikbn1(C_TtdktyuuiKbn.BLNK);
                            khTtdkTyuui.setTtdktyuuikbnhsknaiyou1("");
                            khTtdkTyuui.setTtdktyuuikbnsetymd1(null);
                            khTtdkTyuui.setSetsosikicd1("");
                        }
                    }
                    else {
                        khTtdkTyuui.setTtdktyuuikbn1(C_TtdktyuuiKbn.BLNK);
                        khTtdkTyuui.setTtdktyuuikbnhsknaiyou1("");
                        khTtdkTyuui.setTtdktyuuikbnsetymd1(null);
                        khTtdkTyuui.setSetsosikicd1("");
                    }
                }
                else if (idx == 1) {
                    if (idx < dataSize) {

                        ttdkTyuuiUpdFlg = true;

                        if (!ttdkTyuui1DataLst.get(idx).getTtdktyuuisakujyo()) {
                            ttdkTyuui1DataBean = ttdkTyuui1DataLst.get(idx);
                            khTtdkTyuui.setTtdktyuuikbn2(ttdkTyuui1DataBean.getTtdktyuuikbn());
                            khTtdkTyuui.setTtdktyuuikbnhsknaiyou2(ttdkTyuui1DataBean.getTtdktyuuikbnhsknaiyou());
                            khTtdkTyuui.setTtdktyuuikbnsetymd2(ttdkTyuui1DataBean.getTtdktyuuikbnsetymd());
                            khTtdkTyuui.setSetsosikicd2(ttdkTyuui1DataBean.getSetsosikiCd());
                        } else {
                            khTtdkTyuui.setTtdktyuuikbn2(C_TtdktyuuiKbn.BLNK);
                            khTtdkTyuui.setTtdktyuuikbnhsknaiyou2("");
                            khTtdkTyuui.setTtdktyuuikbnsetymd2(null);
                            khTtdkTyuui.setSetsosikicd2("");
                        }
                    }
                    else {
                        khTtdkTyuui.setTtdktyuuikbn2(C_TtdktyuuiKbn.BLNK);
                        khTtdkTyuui.setTtdktyuuikbnhsknaiyou2("");
                        khTtdkTyuui.setTtdktyuuikbnsetymd2(null);
                        khTtdkTyuui.setSetsosikicd2("");
                    }
                }
                else if (idx == 2) {
                    if (idx < dataSize) {

                        ttdkTyuuiUpdFlg = true;

                        if (!ttdkTyuui1DataLst.get(idx).getTtdktyuuisakujyo()) {
                            ttdkTyuui1DataBean = ttdkTyuui1DataLst.get(idx);
                            khTtdkTyuui.setTtdktyuuikbn3(ttdkTyuui1DataBean.getTtdktyuuikbn());
                            khTtdkTyuui.setTtdktyuuikbnhsknaiyou3(ttdkTyuui1DataBean.getTtdktyuuikbnhsknaiyou());
                            khTtdkTyuui.setTtdktyuuikbnsetymd3(ttdkTyuui1DataBean.getTtdktyuuikbnsetymd());
                            khTtdkTyuui.setSetsosikicd3(ttdkTyuui1DataBean.getSetsosikiCd());
                        } else {
                            khTtdkTyuui.setTtdktyuuikbn3(C_TtdktyuuiKbn.BLNK);
                            khTtdkTyuui.setTtdktyuuikbnhsknaiyou3("");
                            khTtdkTyuui.setTtdktyuuikbnsetymd3(null);
                            khTtdkTyuui.setSetsosikicd3("");
                        }
                    }
                    else {
                        khTtdkTyuui.setTtdktyuuikbn3(C_TtdktyuuiKbn.BLNK);
                        khTtdkTyuui.setTtdktyuuikbnhsknaiyou3("");
                        khTtdkTyuui.setTtdktyuuikbnsetymd3(null);
                        khTtdkTyuui.setSetsosikicd3("");
                    }
                }
                else if (idx == 3) {
                    if (idx < dataSize) {

                        ttdkTyuuiUpdFlg = true;

                        if (!ttdkTyuui1DataLst.get(idx).getTtdktyuuisakujyo()) {
                            ttdkTyuui1DataBean = ttdkTyuui1DataLst.get(idx);
                            khTtdkTyuui.setTtdktyuuikbn4(ttdkTyuui1DataBean.getTtdktyuuikbn());
                            khTtdkTyuui.setTtdktyuuikbnhsknaiyou4(ttdkTyuui1DataBean.getTtdktyuuikbnhsknaiyou());
                            khTtdkTyuui.setTtdktyuuikbnsetymd4(ttdkTyuui1DataBean.getTtdktyuuikbnsetymd());
                            khTtdkTyuui.setSetsosikicd4(ttdkTyuui1DataBean.getSetsosikiCd());
                        } else {
                            khTtdkTyuui.setTtdktyuuikbn4(C_TtdktyuuiKbn.BLNK);
                            khTtdkTyuui.setTtdktyuuikbnhsknaiyou4("");
                            khTtdkTyuui.setTtdktyuuikbnsetymd4(null);
                            khTtdkTyuui.setSetsosikicd4("");
                        }
                    }
                    else {
                        khTtdkTyuui.setTtdktyuuikbn4(C_TtdktyuuiKbn.BLNK);
                        khTtdkTyuui.setTtdktyuuikbnhsknaiyou4("");
                        khTtdkTyuui.setTtdktyuuikbnsetymd4(null);
                        khTtdkTyuui.setSetsosikicd4("");
                    }
                }
                else if (idx == 4) {
                    if (idx < dataSize) {

                        ttdkTyuuiUpdFlg = true;

                        if (!ttdkTyuui1DataLst.get(idx).getTtdktyuuisakujyo()) {
                            ttdkTyuui1DataBean = ttdkTyuui1DataLst.get(idx);
                            khTtdkTyuui.setTtdktyuuikbn5(ttdkTyuui1DataBean.getTtdktyuuikbn());
                            khTtdkTyuui.setTtdktyuuikbnhsknaiyou5(ttdkTyuui1DataBean.getTtdktyuuikbnhsknaiyou());
                            khTtdkTyuui.setTtdktyuuikbnsetymd5(ttdkTyuui1DataBean.getTtdktyuuikbnsetymd());
                            khTtdkTyuui.setSetsosikicd5(ttdkTyuui1DataBean.getSetsosikiCd());
                        } else {
                            khTtdkTyuui.setTtdktyuuikbn5(C_TtdktyuuiKbn.BLNK);
                            khTtdkTyuui.setTtdktyuuikbnhsknaiyou5("");
                            khTtdkTyuui.setTtdktyuuikbnsetymd5(null);
                            khTtdkTyuui.setSetsosikicd5("");
                        }
                    }
                    else {
                        khTtdkTyuui.setTtdktyuuikbn5(C_TtdktyuuiKbn.BLNK);
                        khTtdkTyuui.setTtdktyuuikbnhsknaiyou5("");
                        khTtdkTyuui.setTtdktyuuikbnsetymd5(null);
                        khTtdkTyuui.setSetsosikicd5("");
                    }
                }
            }

            if (ttdkTyuuiUpdFlg) {
                khTtdkTyuui.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
                khTtdkTyuui.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
                khTtdkTyuui.setGyoumuKousinTime(sysTime);
            }

            khTtdkTyuui.setKykdrknhatudoujyoutai(uiBean.getKykdrknhatudoujyoutai());
            khTtdkTyuui.setKykdrdouiyouhi(uiBean.getKykdrdouiyouhi());

            if (!khTtdkTyuuiFlag) {
                BizPropertyInitializer.initialize(khTtdkTyuui);
            }
        }


        int bfrFatcatgkbnSize = uiBean.getBfrFatcatgkbnSize();

        switch (bfrFatcatgkbnSize) {
            case 1:
                maxRenno = uiBean.getBfrrenno1();
                break;
            case 2:
                maxRenno = uiBean.getBfrrenno2();
                break;
            case 3:
                maxRenno = uiBean.getBfrrenno3();
                break;
            case 4:
                maxRenno = uiBean.getBfrrenno4();
                break;
            case 5:
                maxRenno = uiBean.getBfrrenno5();
                break;
            default:
                break;
        }

        for (int idx = 0; idx < uiBean.getRecordkensuu(); idx++) {

            if (idx == 0 && uiBean.isFatcaHnkFlg1()) {
                fatcaInfoUpd(
                    uiBean.getRenno1(),
                    uiBean.getDispfatcasakujyo1(),
                    uiBean.getDispsyoriymd1(),
                    uiBean.getSyoriSosikicd1(),
                    uiBean.getDispfatcasnsikbn1(),
                    uiBean.getDispbikkjnssinfokbn1(),
                    uiBean.getDispfatcakekkbn1(),
                    uiBean.getDispfatcahankeiikbn1(),
                    uiBean.getDispbikknzsyno1(),
                    uiBean.getDispsyomeiymd1(),
                    uiBean.getDispfatcatgkbn1(),
                    uiBean.getDispnmkn1(),
                    uiBean.getDispnmkj1(),
                    uiBean.getDispseiymd1(),
                    uiBean.getDispsei1(),
                    uiBean.getDispkouryokuendymd1(),
                    uiBean.getBfrfatcatgkbn1(),
                    idx);
            }
            else if (idx == 1 && uiBean.isFatcaHnkFlg2()) {
                fatcaInfoUpd(
                    uiBean.getRenno2(),
                    uiBean.getDispfatcasakujyo2(),
                    uiBean.getDispsyoriymd2(),
                    uiBean.getSyoriSosikicd2(),
                    uiBean.getDispfatcasnsikbn2(),
                    uiBean.getDispbikkjnssinfokbn2(),
                    uiBean.getDispfatcakekkbn2(),
                    uiBean.getDispfatcahankeiikbn2(),
                    uiBean.getDispbikknzsyno2(),
                    uiBean.getDispsyomeiymd2(),
                    uiBean.getDispfatcatgkbn2(),
                    uiBean.getDispnmkn2(),
                    uiBean.getDispnmkj2(),
                    uiBean.getDispseiymd2(),
                    uiBean.getDispsei2(),
                    uiBean.getDispkouryokuendymd2(),
                    uiBean.getBfrfatcatgkbn2(),
                    idx);
            }
            else if (idx == 2 && uiBean.isFatcaHnkFlg3()) {
                fatcaInfoUpd(
                    uiBean.getRenno3(),
                    uiBean.getDispfatcasakujyo3(),
                    uiBean.getDispsyoriymd3(),
                    uiBean.getSyoriSosikicd3(),
                    uiBean.getDispfatcasnsikbn3(),
                    uiBean.getDispbikkjnssinfokbn3(),
                    uiBean.getDispfatcakekkbn3(),
                    uiBean.getDispfatcahankeiikbn3(),
                    uiBean.getDispbikknzsyno3(),
                    uiBean.getDispsyomeiymd3(),
                    uiBean.getDispfatcatgkbn3(),
                    uiBean.getDispnmkn3(),
                    uiBean.getDispnmkj3(),
                    uiBean.getDispseiymd3(),
                    uiBean.getDispsei3(),
                    uiBean.getDispkouryokuendymd3(),
                    uiBean.getBfrfatcatgkbn3(),
                    idx);
            }
            else if (idx == 3 && uiBean.isFatcaHnkFlg4()) {
                fatcaInfoUpd(
                    uiBean.getRenno4(),
                    uiBean.getDispfatcasakujyo4(),
                    uiBean.getDispsyoriymd4(),
                    uiBean.getSyoriSosikicd4(),
                    uiBean.getDispfatcasnsikbn4(),
                    uiBean.getDispbikkjnssinfokbn4(),
                    uiBean.getDispfatcakekkbn4(),
                    uiBean.getDispfatcahankeiikbn4(),
                    uiBean.getDispbikknzsyno4(),
                    uiBean.getDispsyomeiymd4(),
                    uiBean.getDispfatcatgkbn4(),
                    uiBean.getDispnmkn4(),
                    uiBean.getDispnmkj4(),
                    uiBean.getDispseiymd4(),
                    uiBean.getDispsei4(),
                    uiBean.getDispkouryokuendymd4(),
                    uiBean.getBfrfatcatgkbn4(),
                    idx);
            }
            else if (idx == 4 && uiBean.isFatcaHnkFlg5()) {
                fatcaInfoUpd(
                    uiBean.getRenno5(),
                    uiBean.getDispfatcasakujyo5(),
                    uiBean.getDispsyoriymd5(),
                    uiBean.getSyoriSosikicd5(),
                    uiBean.getDispfatcasnsikbn5(),
                    uiBean.getDispbikkjnssinfokbn5(),
                    uiBean.getDispfatcakekkbn5(),
                    uiBean.getDispfatcahankeiikbn5(),
                    uiBean.getDispbikknzsyno5(),
                    uiBean.getDispsyomeiymd5(),
                    uiBean.getDispfatcatgkbn5(),
                    uiBean.getDispnmkn5(),
                    uiBean.getDispnmkj5(),
                    uiBean.getDispseiymd5(),
                    uiBean.getDispsei5(),
                    uiBean.getDispkouryokuendymd5(),
                    uiBean.getBfrfatcatgkbn5(),
                    idx);
            }
        }

        int bfrAeoiRecordKensuu = uiBean.getBfrAeoiRecordKensuu();
        switch (bfrAeoiRecordKensuu) {
            case 1:
                aeoiMaxRenno = uiBean.getBfrAeoiRenno1();
                break;
            case 2:
                aeoiMaxRenno = uiBean.getBfrAeoiRenno2();
                break;
            case 3:
                aeoiMaxRenno = uiBean.getBfrAeoiRenno3();
                break;
            case 4:
                aeoiMaxRenno = uiBean.getBfrAeoiRenno4();
                break;
            case 5:
                aeoiMaxRenno = uiBean.getBfrAeoiRenno5();
                break;
            default:
                break;
        }

        for (int idx = 0; idx < uiBean.getAeoirecordkensuu(); idx++) {

            if (idx == 0 && uiBean.isAeoiHnkFlg1()) {
                aeoiInfoUpd(uiBean.getAeoiRenno1(),
                    uiBean.getDispaeoisakujyo1(),
                    uiBean.getDispaeoisyoriymd1(),
                    uiBean.getDispaeoisyorisosikicd1(),
                    uiBean.getDispaeoikekkakbn1(),
                    uiBean.getDispaeoisyorikbn1(),
                    uiBean.getDispaeoitaisyousyakbn1(),
                    uiBean.getDispaeoihoujinsyuruikbn1(),
                    uiBean.getDispaeoikouryokusttymd1(),
                    uiBean.getDispaeoikouryokuendymd1(),
                    idx);
            }
            else if(idx == 1 && uiBean.isAeoiHnkFlg2()){
                aeoiInfoUpd(uiBean.getAeoiRenno2(),
                    uiBean.getDispaeoisakujyo2(),
                    uiBean.getDispaeoisyoriymd2(),
                    uiBean.getDispaeoisyorisosikicd2(),
                    uiBean.getDispaeoikekkakbn2(),
                    uiBean.getDispaeoisyorikbn2(),
                    uiBean.getDispaeoitaisyousyakbn2(),
                    uiBean.getDispaeoihoujinsyuruikbn2(),
                    uiBean.getDispaeoikouryokusttymd2(),
                    uiBean.getDispaeoikouryokuendymd2(),
                    idx);
            }
            else if(idx == 2 && uiBean.isAeoiHnkFlg3()){
                aeoiInfoUpd(uiBean.getAeoiRenno3(),
                    uiBean.getDispaeoisakujyo3(),
                    uiBean.getDispaeoisyoriymd3(),
                    uiBean.getDispaeoisyorisosikicd3(),
                    uiBean.getDispaeoikekkakbn3(),
                    uiBean.getDispaeoisyorikbn3(),
                    uiBean.getDispaeoitaisyousyakbn3(),
                    uiBean.getDispaeoihoujinsyuruikbn3(),
                    uiBean.getDispaeoikouryokusttymd3(),
                    uiBean.getDispaeoikouryokuendymd3(),
                    idx);
            }
            else if(idx == 3 && uiBean.isAeoiHnkFlg4()){
                aeoiInfoUpd(uiBean.getAeoiRenno4(),
                    uiBean.getDispaeoisakujyo4(),
                    uiBean.getDispaeoisyoriymd4(),
                    uiBean.getDispaeoisyorisosikicd4(),
                    uiBean.getDispaeoikekkakbn4(),
                    uiBean.getDispaeoisyorikbn4(),
                    uiBean.getDispaeoitaisyousyakbn4(),
                    uiBean.getDispaeoihoujinsyuruikbn4(),
                    uiBean.getDispaeoikouryokusttymd4(),
                    uiBean.getDispaeoikouryokuendymd4(),
                    idx);
            }
            else if(idx == 4 && uiBean.isAeoiHnkFlg5()){
                aeoiInfoUpd(uiBean.getAeoiRenno5(),
                    uiBean.getDispaeoisakujyo5(),
                    uiBean.getDispaeoisyoriymd5(),
                    uiBean.getDispaeoisyorisosikicd5(),
                    uiBean.getDispaeoikekkakbn5(),
                    uiBean.getDispaeoisyorikbn5(),
                    uiBean.getDispaeoitaisyousyakbn5(),
                    uiBean.getDispaeoihoujinsyuruikbn5(),
                    uiBean.getDispaeoikouryokusttymd5(),
                    uiBean.getDispaeoikouryokuendymd5(),
                    idx);
            }
        }

        hozenDomManager.update(kykKihon);


        List<String> rayYuukouKykLst = new ArrayList<String>();
        for (KikeiyakuInfoDataSourceBean dataSourceBean : uiBean.getKikeiyakuInfoDataSource().getAllData()) {
            if (dataSourceBean.getVbtkkdispbtkyksyoumetuymd() == null) {
                rayYuukouKykLst.add(dataSourceBean.getVbtkkdispbtkyksyono());
            }
        }
        List<String> palYuukouKykLst = new ArrayList<String>();
        for (PalkikeiyakuInfoDataSourceBean dataSourceBean : uiBean.getPalkikeiyakuInfoDataSource().getAllData()) {
            if (dataSourceBean.getVbtkkdisppalbtkyksymtymd() == null) {
                palYuukouKykLst.add(dataSourceBean.getVbtkkdisppalbtkyksyono());
            }
        }

        if (uiBean.isKykdrknhatudouHnkFlg() &&
            ((rayYuukouKykLst.size() + palYuukouKykLst.size()) > 0 || uiBean.getWarningMessageList().size() > 0)) {
            List<String> jimuRenrakuMsgList = new ArrayList<String>();
            jimuRenrakuMsgList.add("上記契約の契約者代理状態が変更されました。");
            jimuRenrakuMsgList.add("別契約について、保険契約者代理特約の付加有無を確認し、契約者代理状態を変更してください。");

            if (uiBean.getWarningMessageList().size() > 0) {
                for (String message : uiBean.getWarningMessageList()) {
                    jimuRenrakuMsgList.add("※" + message);
                }
            }

            jimuRenrakuMsgList.add("");

            if ((rayYuukouKykLst.size() + palYuukouKykLst.size()) > 0) {
                jimuRenrakuMsgList.add("【証券番号】");

                if (palYuukouKykLst.size() > 0) {
                    jimuRenrakuMsgList.add(C_SysCdKbn.PAL.getContent());

                    for (String syono : palYuukouKykLst) {
                        jimuRenrakuMsgList.add(syono);
                    }

                    jimuRenrakuMsgList.add("");
                }

                if (rayYuukouKykLst.size() > 0) {
                    jimuRenrakuMsgList.add(C_SysCdKbn.RAY.getContent());

                    for (String syono : rayYuukouKykLst) {
                        jimuRenrakuMsgList.add(syono);
                    }

                    jimuRenrakuMsgList.add("");
                }
            }

            jimuRenrakuMsgList.add("【変更後内容】");
            jimuRenrakuMsgList.add(MessageUtil.getMessage(DDID_KYKDRJTINFO_KYKDRKNHATUDOUJYOUTAI.getErrorResourceKey())
                + "　" + uiBean.getKykdrknhatudoujyoutai().getContent(C_KykdrknHtdjytKbn.PATTERN_SELECT));

            EditJimuRenrakuhyouParam editJimuRenrakuhyouParam = SWAKInjector.getInstance(EditJimuRenrakuhyouParam.class);
            editJimuRenrakuhyouParam.setJimurenrakuMsgList(jimuRenrakuMsgList);

            KhozenTyouhyouCtl khozenTyouhyouCtl = SWAKInjector.getInstance(KhozenTyouhyouCtl.class);

            khozenTyouhyouCtl.setSyoriYmd(sysDate);
            khozenTyouhyouCtl.setEditJimuRenrakuhyouParam(editJimuRenrakuhyouParam);

            khozenTyouhyouCtl.createTyouhyouTBL(khozenCommonParam,
                uiBean.getSyono(),
                new C_SyoruiCdKbn[]{C_SyoruiCdKbn.KK_JIMURENRAKU_TETUDUKITYUUI},
                C_YouhiKbn.YOU);

            uiBean.setReportKey(khozenTyouhyouCtl.getTyouhyouKey());
            uiBean.setTyouhyoumukbn(khozenTyouhyouCtl.getTyouhyoumuKbn());
        }

        EditTtdkRirekiTbl editTtdkRirekiTbl = SWAKInjector.getInstance(EditTtdkRirekiTbl.class);
        EditTtdkRirekiTblParam editTtdkRirekiTblParam = SWAKInjector.getInstance(EditTtdkRirekiTblParam.class);

        PALKykNaiyouKousin pALKykNaiyouKousin = SWAKInjector.getInstance(PALKykNaiyouKousin.class);
        pALKykNaiyouKousin.exec(kykKihon);

        editTtdkRirekiTblParam.setCommonParam(khozenCommonParam);
        editTtdkRirekiTblParam.setSyoNo(syoNo);
        editTtdkRirekiTblParam.setSyoriYmd(sysDate);
        editTtdkRirekiTblParam.setSysTime(sysTime);
        editTtdkRirekiTblParam.setHenkouRrkYouhi(C_YouhiKbn.YOU);
        editTtdkRirekiTblParam.setYoukyuuNo(pALKykNaiyouKousin.getYoukyuuno());

        editTtdkRirekiTbl.exec(editTtdkRirekiTblParam);

        messageManager.addMessageId(MessageId.IAC0009);

    }

    String pushFunctionNameOnClickBL() {

        return FORWARDNAME_INIT;
    }

    void printOut() {

        OutputReport outputReport = SWAKInjector.getInstance(OutputReport.class);

        outputReport.outputPDFByJoinKey(uiBean.getReportKey());
    }


    private void isExist() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(uiBean.getSyono());

        if (kykKihon != null) {
            uiBean.setStknsetkbn(kykKihon.getStknsetkbn());

            uiBean.setBfrStknsetKbn(kykKihon.getStknsetkbn());

            uiBean.setKykKihon(kykKihon);

            uiBean.setKykdrtkykumu(kykKihon.getKykSonotaTkyk().getKykdrtkykhukaumu());

        }
        else {
            throw new BizLogicException(MessageId.EBA0090);
        }
    }

    private void checkJyoutai() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        CheckYuukouJyoutai checkYuukouJyoutai = SWAKInjector.getInstance(CheckYuukouJyoutai.class);

        C_YuukoujyotaichkKbn yuukoujyotaichkKbn = checkYuukouJyoutai.exec(khozenCommonParam, uiBean);

        if (C_YuukoujyotaichkKbn.HUKA.eq(yuukoujyotaichkKbn)) {
            throw new BizLogicException(MessageId.EIA0035, checkYuukouJyoutai.getErrorMessage());
        }
        else if (C_YuukoujyotaichkKbn.TYUUITRATKIKA.eq(yuukoujyotaichkKbn)) {

            for (int i = 0; i < checkYuukouJyoutai.getWarningMessageIDList().size(); i++) {

                messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1,
                    checkYuukouJyoutai.getWarningMessageIDList().get(i),
                    checkYuukouJyoutai.getWarningMessageList().get(i));
            }
        }
    }


    private void checkYuuyokkngai() {


        CheckYuuyokkngai checkYuuyokkngai = SWAKInjector.getInstance(CheckYuuyokkngai.class);

        boolean result = checkYuuyokkngai.exec(uiBean.getSyono(),BizDate.getSysDate());

        if (!result) {
            messageManager.addConversationMessageId(KhMessageGroupConstants.GROUP_WARNING1, MessageId.WIA0011);
        }
    }
    private void setTtdkTyuui() {

        IT_KhTtdkTyuui khTtdkTyuui = uiBean.getKykKihon().getKhTtdkTyuui();

        if (khTtdkTyuui == null) {

            uiBean.setKktyuitakbn(C_KktyuitaKbn.BLNK);
            uiBean.setKykdrknhatudoujyoutai(C_KykdrknHtdjytKbn.BLNK);
            uiBean.setKykdrdouiyouhi(C_KykdrDouiYouhiKbn.BLNK);
            uiBean.setBfrKktyuitakbn(C_KktyuitaKbn.BLNK);
            uiBean.setBrfKykdrknhatudoujyoutai(C_KykdrknHtdjytKbn.BLNK);
            uiBean.setBrfKykdrdouiyouhi(C_KykdrDouiYouhiKbn.BLNK);

            List<TtdkTyuui1DataSourceBean> ttdkTyuui1DataLst = new ArrayList<>();
            TtdkTyuui1DataSourceBean ttdkTyuui1DataBean;
            for (int i = 0; i < 5; i++) {
                ttdkTyuui1DataBean = new TtdkTyuui1DataSourceBean();
                ttdkTyuui1DataBean.setBfrTtdktyuuikbn(C_TtdktyuuiKbn.BLNK);
                ttdkTyuui1DataBean.setBfrTtdktyuuikbnhsknaiyou("");
                ttdkTyuui1DataBean.setBfrTtdktyuuikbnsetymd(null);
                ttdkTyuui1DataBean.setBfrSetsosikiCd("");
                ttdkTyuui1DataBean.setBfrSetsosikiNm("");
                ttdkTyuui1DataLst.add(ttdkTyuui1DataBean);
            }
            uiBean.setTtdkTyuui1(ttdkTyuui1DataLst);
            uiBean.setBfrTtdkTyuui1(ttdkTyuui1DataLst);
        }
        else {
            C_KktyuitaKbn tyuuiTaKbn = khTtdkTyuui.getKktyuitakbn();
            C_KykdrknHtdjytKbn kykdrknhatudoujyoutai = khTtdkTyuui.getKykdrknhatudoujyoutai();
            C_KykdrDouiYouhiKbn kykdrdouiyouhi = khTtdkTyuui.getKykdrdouiyouhi();
            String tyuuiNaiyou1 = khTtdkTyuui.getTtdktyuuinaiyou1();
            String tyuuiNaiyou2 = khTtdkTyuui.getTtdktyuuinaiyou2();
            String tyuuiNaiyou3 = khTtdkTyuui.getTtdktyuuinaiyou3();
            C_TtdktyuuiKbn ttdktyuuikbn1 = khTtdkTyuui.getTtdktyuuikbn1();
            C_TtdktyuuiKbn ttdktyuuikbn2 = khTtdkTyuui.getTtdktyuuikbn2();
            C_TtdktyuuiKbn ttdktyuuikbn3 = khTtdkTyuui.getTtdktyuuikbn3();
            C_TtdktyuuiKbn ttdktyuuikbn4 = khTtdkTyuui.getTtdktyuuikbn4();
            C_TtdktyuuiKbn ttdktyuuikbn5 = khTtdkTyuui.getTtdktyuuikbn5();
            String ttdktyuuikbnhsknaiyou1 = khTtdkTyuui.getTtdktyuuikbnhsknaiyou1();
            String ttdktyuuikbnhsknaiyou2 = khTtdkTyuui.getTtdktyuuikbnhsknaiyou2();
            String ttdktyuuikbnhsknaiyou3 = khTtdkTyuui.getTtdktyuuikbnhsknaiyou3();
            String ttdktyuuikbnhsknaiyou4 = khTtdkTyuui.getTtdktyuuikbnhsknaiyou4();
            String ttdktyuuikbnhsknaiyou5 = khTtdkTyuui.getTtdktyuuikbnhsknaiyou5();
            BizDate ttdktyuuikbnsetymd1 = khTtdkTyuui.getTtdktyuuikbnsetymd1();
            BizDate ttdktyuuikbnsetymd2 = khTtdkTyuui.getTtdktyuuikbnsetymd2();
            BizDate ttdktyuuikbnsetymd3 = khTtdkTyuui.getTtdktyuuikbnsetymd3();
            BizDate ttdktyuuikbnsetymd4 = khTtdkTyuui.getTtdktyuuikbnsetymd4();
            BizDate ttdktyuuikbnsetymd5 = khTtdkTyuui.getTtdktyuuikbnsetymd5();
            String setsosikicd1 = khTtdkTyuui.getSetsosikicd1();
            String setsosikicd2 = khTtdkTyuui.getSetsosikicd2();
            String setsosikicd3 = khTtdkTyuui.getSetsosikicd3();
            String setsosikicd4 = khTtdkTyuui.getSetsosikicd4();
            String setsosikicd5 = khTtdkTyuui.getSetsosikicd5();

            BzGetSosikiData bzGetSosikiData = SWAKInjector.getInstance(BzGetSosikiData.class);
            BzGetSosikiDataBean bzGetSosikiDataBean = bzGetSosikiData.exec(setsosikicd1);

            String kanjisosikiNm1 = "";
            if (C_SosikimasterUmuKbn.ARI.eq(bzGetSosikiDataBean.getSosikimasterumukbn())) {
                kanjisosikiNm1 = bzGetSosikiDataBean.getKanjisosikinm20();
            }

            bzGetSosikiDataBean = bzGetSosikiData.exec(setsosikicd2);
            String kanjisosikiNm2 = "";
            if (C_SosikimasterUmuKbn.ARI.eq(bzGetSosikiDataBean.getSosikimasterumukbn())) {
                kanjisosikiNm2 = bzGetSosikiDataBean.getKanjisosikinm20();
            }

            bzGetSosikiDataBean = bzGetSosikiData.exec(setsosikicd3);
            String kanjisosikiNm3 = "";
            if (C_SosikimasterUmuKbn.ARI.eq(bzGetSosikiDataBean.getSosikimasterumukbn())) {
                kanjisosikiNm3 = bzGetSosikiDataBean.getKanjisosikinm20();
            }

            bzGetSosikiDataBean = bzGetSosikiData.exec(setsosikicd4);
            String kanjisosikiNm4 = "";
            if (C_SosikimasterUmuKbn.ARI.eq(bzGetSosikiDataBean.getSosikimasterumukbn())) {
                kanjisosikiNm4 = bzGetSosikiDataBean.getKanjisosikinm20();
            }

            bzGetSosikiDataBean = bzGetSosikiData.exec(setsosikicd5);
            String kanjisosikiNm5 = "";
            if (C_SosikimasterUmuKbn.ARI.eq(bzGetSosikiDataBean.getSosikimasterumukbn())) {
                kanjisosikiNm5 = bzGetSosikiDataBean.getKanjisosikinm20();
            }

            uiBean.setKktyuitakbn(tyuuiTaKbn);
            uiBean.setKykdrknhatudoujyoutai(kykdrknhatudoujyoutai);
            uiBean.setKykdrdouiyouhi(kykdrdouiyouhi);
            uiBean.setTtdktyuuinaiyou1(tyuuiNaiyou1);
            uiBean.setTtdktyuuinaiyou2(tyuuiNaiyou2);
            uiBean.setTtdktyuuinaiyou3(tyuuiNaiyou3);
            uiBean.setBfrKktyuitakbn(tyuuiTaKbn);
            uiBean.setBrfKykdrknhatudoujyoutai(kykdrknhatudoujyoutai);
            uiBean.setBrfKykdrdouiyouhi(kykdrdouiyouhi);
            uiBean.setBfrTtdktyuuinaiyou1(tyuuiNaiyou1);
            uiBean.setBfrTtdktyuuinaiyou2(tyuuiNaiyou2);
            uiBean.setBfrTtdktyuuinaiyou3(tyuuiNaiyou3);

            List<TtdkTyuui1DataSourceBean> ttdkTyuui1DataLst = new ArrayList<>();
            TtdkTyuui1DataSourceBean ttdkTyuui1DataBean;
            for (int idx = 0; idx < 5; idx++) {
                ttdkTyuui1DataBean = new TtdkTyuui1DataSourceBean();

                if (idx == 0) {
                    ttdkTyuui1DataBean.setTtdktyuuikbn(ttdktyuuikbn1);
                    ttdkTyuui1DataBean.setTtdktyuuikbnhsknaiyou(ttdktyuuikbnhsknaiyou1);
                    ttdkTyuui1DataBean.setTtdktyuuikbnsetymd(ttdktyuuikbnsetymd1);
                    ttdkTyuui1DataBean.setSetsosikiCd(setsosikicd1);
                    ttdkTyuui1DataBean.setSetsosikinm(kanjisosikiNm1);
                    ttdkTyuui1DataBean.setBfrTtdktyuuikbn(ttdktyuuikbn1);
                    ttdkTyuui1DataBean.setBfrTtdktyuuikbnhsknaiyou(ttdktyuuikbnhsknaiyou1);
                    ttdkTyuui1DataBean.setBfrTtdktyuuikbnsetymd(ttdktyuuikbnsetymd1);
                    ttdkTyuui1DataBean.setBfrSetsosikiCd(setsosikicd1);
                    ttdkTyuui1DataBean.setBfrSetsosikiNm(kanjisosikiNm1);
                }
                else if (idx == 1) {
                    ttdkTyuui1DataBean.setTtdktyuuikbn(ttdktyuuikbn2);
                    ttdkTyuui1DataBean.setTtdktyuuikbnhsknaiyou(ttdktyuuikbnhsknaiyou2);
                    ttdkTyuui1DataBean.setTtdktyuuikbnsetymd(ttdktyuuikbnsetymd2);
                    ttdkTyuui1DataBean.setSetsosikiCd(setsosikicd2);
                    ttdkTyuui1DataBean.setSetsosikinm(kanjisosikiNm2);
                    ttdkTyuui1DataBean.setBfrTtdktyuuikbn(ttdktyuuikbn2);
                    ttdkTyuui1DataBean.setBfrTtdktyuuikbnhsknaiyou(ttdktyuuikbnhsknaiyou2);
                    ttdkTyuui1DataBean.setBfrTtdktyuuikbnsetymd(ttdktyuuikbnsetymd2);
                    ttdkTyuui1DataBean.setBfrSetsosikiCd(setsosikicd2);
                    ttdkTyuui1DataBean.setBfrSetsosikiNm(kanjisosikiNm2);
                }
                else if (idx == 2) {
                    ttdkTyuui1DataBean.setTtdktyuuikbn(ttdktyuuikbn3);
                    ttdkTyuui1DataBean.setTtdktyuuikbnhsknaiyou(ttdktyuuikbnhsknaiyou3);
                    ttdkTyuui1DataBean.setTtdktyuuikbnsetymd(ttdktyuuikbnsetymd3);
                    ttdkTyuui1DataBean.setSetsosikiCd(setsosikicd3);
                    ttdkTyuui1DataBean.setSetsosikinm(kanjisosikiNm3);
                    ttdkTyuui1DataBean.setBfrTtdktyuuikbn(ttdktyuuikbn3);
                    ttdkTyuui1DataBean.setBfrTtdktyuuikbnhsknaiyou(ttdktyuuikbnhsknaiyou3);
                    ttdkTyuui1DataBean.setBfrTtdktyuuikbnsetymd(ttdktyuuikbnsetymd3);
                    ttdkTyuui1DataBean.setBfrSetsosikiCd(setsosikicd3);
                    ttdkTyuui1DataBean.setBfrSetsosikiNm(kanjisosikiNm3);
                }
                else if (idx == 3) {
                    ttdkTyuui1DataBean.setTtdktyuuikbn(ttdktyuuikbn4);
                    ttdkTyuui1DataBean.setTtdktyuuikbnhsknaiyou(ttdktyuuikbnhsknaiyou4);
                    ttdkTyuui1DataBean.setTtdktyuuikbnsetymd(ttdktyuuikbnsetymd4);
                    ttdkTyuui1DataBean.setSetsosikiCd(setsosikicd4);
                    ttdkTyuui1DataBean.setSetsosikinm(kanjisosikiNm4);
                    ttdkTyuui1DataBean.setBfrTtdktyuuikbn(ttdktyuuikbn4);
                    ttdkTyuui1DataBean.setBfrTtdktyuuikbnhsknaiyou(ttdktyuuikbnhsknaiyou4);
                    ttdkTyuui1DataBean.setBfrTtdktyuuikbnsetymd(ttdktyuuikbnsetymd4);
                    ttdkTyuui1DataBean.setBfrSetsosikiCd(setsosikicd4);
                    ttdkTyuui1DataBean.setBfrSetsosikiNm(kanjisosikiNm4);
                }
                else if (idx == 4) {
                    ttdkTyuui1DataBean.setTtdktyuuikbn(ttdktyuuikbn5);
                    ttdkTyuui1DataBean.setTtdktyuuikbnhsknaiyou(ttdktyuuikbnhsknaiyou5);
                    ttdkTyuui1DataBean.setTtdktyuuikbnsetymd(ttdktyuuikbnsetymd5);
                    ttdkTyuui1DataBean.setSetsosikiCd(setsosikicd5);
                    ttdkTyuui1DataBean.setSetsosikinm(kanjisosikiNm5);
                    ttdkTyuui1DataBean.setBfrTtdktyuuikbn(ttdktyuuikbn5);
                    ttdkTyuui1DataBean.setBfrTtdktyuuikbnhsknaiyou(ttdktyuuikbnhsknaiyou5);
                    ttdkTyuui1DataBean.setBfrTtdktyuuikbnsetymd(ttdktyuuikbnsetymd5);
                    ttdkTyuui1DataBean.setBfrSetsosikiCd(setsosikicd5);
                    ttdkTyuui1DataBean.setBfrSetsosikiNm(kanjisosikiNm5);
                }

                ttdkTyuui1DataLst.add(ttdkTyuui1DataBean);
            }
            uiBean.setTtdkTyuui1(ttdkTyuui1DataLst);
            uiBean.setBfrTtdkTyuui1(ttdkTyuui1DataLst);
        }

        List<IT_FatcaInfo> fatcaInfoLst = uiBean.getKykKihon().getFatcaInfos();

        uiBean.setRenno1(RENNO_ZERO);
        uiBean.setSyoriSosikicd1(BLANK);
        uiBean.setDispsyoriymd1(null);
        uiBean.setDispfatcasnsikbn1(C_FatcasnsiKbn.BLNK);
        uiBean.setDispbikkjnssinfokbn1(C_BikkjnssinfoKbn.BLNK);
        uiBean.setDispfatcakekkbn1(C_FatcakekKbn.BLNK);
        uiBean.setDispfatcahankeiikbn1(C_FatcahankeiiKbn.BLNK);
        uiBean.setDispbikknzsyno1(BLANK);
        uiBean.setDispsyomeiymd1(null);
        uiBean.setDispfatcatgkbn1(C_FatcatgKbn.BLNK);
        uiBean.setDispnmkn1(BLANK);
        uiBean.setDispnmkj1(BLANK);
        uiBean.setDispseiymd1(null);
        uiBean.setDispsei1(C_Seibetu.BLNK);
        uiBean.setDispkouryokuendymd1(null);

        uiBean.setBfrrenno1(RENNO_ZERO);
        uiBean.setBfrSyoriymd1(null);
        uiBean.setBfrfatcasnsikbn1(C_FatcasnsiKbn.BLNK);
        uiBean.setBfrbikkjnssinfokbn1(C_BikkjnssinfoKbn.BLNK);
        uiBean.setBfrfatcakekkbn1(C_FatcakekKbn.BLNK);
        uiBean.setBfrfatcahankeiikbn1(C_FatcahankeiiKbn.BLNK);
        uiBean.setBfrbikknzsyno1(BLANK);
        uiBean.setBfrsyomeiymd1(null);
        uiBean.setBfrfatcatgkbn1(C_FatcatgKbn.BLNK);
        uiBean.setBfrnmkn1(BLANK);
        uiBean.setBfrnmkj1(BLANK);
        uiBean.setBfrseiymd1(null);
        uiBean.setBfrsei1(C_Seibetu.BLNK);
        uiBean.setBfrKouryokuendymd1(null);

        uiBean.setRenno2(RENNO_ZERO);
        uiBean.setSyoriSosikicd2(BLANK);
        uiBean.setDispsyoriymd2(null);
        uiBean.setDispfatcasnsikbn2(C_FatcasnsiKbn.BLNK);
        uiBean.setDispbikkjnssinfokbn2(C_BikkjnssinfoKbn.BLNK);
        uiBean.setDispfatcakekkbn2(C_FatcakekKbn.BLNK);
        uiBean.setDispfatcahankeiikbn2(C_FatcahankeiiKbn.BLNK);
        uiBean.setDispbikknzsyno2(BLANK);
        uiBean.setDispsyomeiymd2(null);
        uiBean.setDispfatcatgkbn2(C_FatcatgKbn.BLNK);
        uiBean.setDispnmkn2(BLANK);
        uiBean.setDispnmkj2(BLANK);
        uiBean.setDispseiymd2(null);
        uiBean.setDispsei2(C_Seibetu.BLNK);
        uiBean.setDispkouryokuendymd2(null);

        uiBean.setBfrrenno2(RENNO_ZERO);
        uiBean.setBfrSyoriymd2(null);
        uiBean.setBfrfatcasnsikbn2(C_FatcasnsiKbn.BLNK);
        uiBean.setBfrbikkjnssinfokbn2(C_BikkjnssinfoKbn.BLNK);
        uiBean.setBfrfatcakekkbn2(C_FatcakekKbn.BLNK);
        uiBean.setBfrfatcahankeiikbn2(C_FatcahankeiiKbn.BLNK);
        uiBean.setBfrbikknzsyno2(BLANK);
        uiBean.setBfrsyomeiymd2(null);
        uiBean.setBfrfatcatgkbn2(C_FatcatgKbn.BLNK);
        uiBean.setBfrnmkn2(BLANK);
        uiBean.setBfrnmkj2(BLANK);
        uiBean.setBfrseiymd2(null);
        uiBean.setBfrsei2(C_Seibetu.BLNK);
        uiBean.setBfrKouryokuendymd2(null);

        uiBean.setRenno3(RENNO_ZERO);
        uiBean.setSyoriSosikicd3(BLANK);
        uiBean.setDispsyoriymd3(null);
        uiBean.setDispfatcasnsikbn3(C_FatcasnsiKbn.BLNK);
        uiBean.setDispbikkjnssinfokbn3(C_BikkjnssinfoKbn.BLNK);
        uiBean.setDispfatcakekkbn3(C_FatcakekKbn.BLNK);
        uiBean.setDispfatcahankeiikbn3(C_FatcahankeiiKbn.BLNK);
        uiBean.setDispbikknzsyno3(BLANK);
        uiBean.setDispsyomeiymd3(null);
        uiBean.setDispfatcatgkbn3(C_FatcatgKbn.BLNK);
        uiBean.setDispnmkn3(BLANK);
        uiBean.setDispnmkj3(BLANK);
        uiBean.setDispseiymd3(null);
        uiBean.setDispsei3(C_Seibetu.BLNK);
        uiBean.setDispkouryokuendymd3(null);

        uiBean.setBfrrenno3(RENNO_ZERO);
        uiBean.setBfrSyoriymd3(null);
        uiBean.setBfrfatcasnsikbn3(C_FatcasnsiKbn.BLNK);
        uiBean.setBfrbikkjnssinfokbn3(C_BikkjnssinfoKbn.BLNK);
        uiBean.setBfrfatcakekkbn3(C_FatcakekKbn.BLNK);
        uiBean.setBfrfatcahankeiikbn3(C_FatcahankeiiKbn.BLNK);
        uiBean.setBfrbikknzsyno3(BLANK);
        uiBean.setBfrsyomeiymd3(null);
        uiBean.setBfrfatcatgkbn3(C_FatcatgKbn.BLNK);
        uiBean.setBfrnmkn3(BLANK);
        uiBean.setBfrnmkj3(BLANK);
        uiBean.setBfrseiymd3(null);
        uiBean.setBfrsei3(C_Seibetu.BLNK);
        uiBean.setBfrKouryokuendymd3(null);

        uiBean.setRenno4(RENNO_ZERO);
        uiBean.setSyoriSosikicd4(BLANK);
        uiBean.setDispsyoriymd4(null);
        uiBean.setDispfatcasnsikbn4(C_FatcasnsiKbn.BLNK);
        uiBean.setDispbikkjnssinfokbn4(C_BikkjnssinfoKbn.BLNK);
        uiBean.setDispfatcakekkbn4(C_FatcakekKbn.BLNK);
        uiBean.setDispfatcahankeiikbn4(C_FatcahankeiiKbn.BLNK);
        uiBean.setDispbikknzsyno4(BLANK);
        uiBean.setDispsyomeiymd4(null);
        uiBean.setDispfatcatgkbn4(C_FatcatgKbn.BLNK);
        uiBean.setDispnmkn4(BLANK);
        uiBean.setDispnmkj4(BLANK);
        uiBean.setDispseiymd4(null);
        uiBean.setDispsei4(C_Seibetu.BLNK);
        uiBean.setDispkouryokuendymd4(null);

        uiBean.setBfrrenno4(RENNO_ZERO);
        uiBean.setBfrSyoriymd4(null);
        uiBean.setBfrfatcasnsikbn4(C_FatcasnsiKbn.BLNK);
        uiBean.setBfrbikkjnssinfokbn4(C_BikkjnssinfoKbn.BLNK);
        uiBean.setBfrfatcakekkbn4(C_FatcakekKbn.BLNK);
        uiBean.setBfrfatcahankeiikbn4(C_FatcahankeiiKbn.BLNK);
        uiBean.setBfrbikknzsyno4(BLANK);
        uiBean.setBfrsyomeiymd4(null);
        uiBean.setBfrfatcatgkbn4(C_FatcatgKbn.BLNK);
        uiBean.setBfrnmkn4(BLANK);
        uiBean.setBfrnmkj4(BLANK);
        uiBean.setBfrseiymd4(null);
        uiBean.setBfrsei4(C_Seibetu.BLNK);
        uiBean.setBfrKouryokuendymd4(null);

        uiBean.setRenno5(RENNO_ZERO);
        uiBean.setSyoriSosikicd5(BLANK);
        uiBean.setDispsyoriymd5(null);
        uiBean.setDispfatcasnsikbn5(C_FatcasnsiKbn.BLNK);
        uiBean.setDispbikkjnssinfokbn5(C_BikkjnssinfoKbn.BLNK);
        uiBean.setDispfatcakekkbn5(C_FatcakekKbn.BLNK);
        uiBean.setDispfatcahankeiikbn5(C_FatcahankeiiKbn.BLNK);
        uiBean.setDispbikknzsyno5(BLANK);
        uiBean.setDispsyomeiymd5(null);
        uiBean.setDispfatcatgkbn5(C_FatcatgKbn.BLNK);
        uiBean.setDispnmkn5(BLANK);
        uiBean.setDispnmkj5(BLANK);
        uiBean.setDispseiymd5(null);
        uiBean.setDispsei5(C_Seibetu.BLNK);
        uiBean.setDispkouryokuendymd5(null);

        uiBean.setBfrrenno5(RENNO_ZERO);
        uiBean.setBfrSyoriymd5(null);
        uiBean.setBfrfatcasnsikbn5(C_FatcasnsiKbn.BLNK);
        uiBean.setBfrbikkjnssinfokbn5(C_BikkjnssinfoKbn.BLNK);
        uiBean.setBfrfatcakekkbn5(C_FatcakekKbn.BLNK);
        uiBean.setBfrfatcahankeiikbn5(C_FatcahankeiiKbn.BLNK);
        uiBean.setBfrbikknzsyno5(BLANK);
        uiBean.setBfrsyomeiymd5(null);
        uiBean.setBfrfatcatgkbn5(C_FatcatgKbn.BLNK);
        uiBean.setBfrnmkn5(BLANK);
        uiBean.setBfrnmkj5(BLANK);
        uiBean.setBfrseiymd5(null);
        uiBean.setBfrsei5(C_Seibetu.BLNK);
        uiBean.setBfrKouryokuendymd5(null);

        uiBean.setRecordkensuu(1);

        if (!fatcaInfoLst.isEmpty()) {

            IT_FatcaInfo fatcaInfo = new IT_FatcaInfo();
            Integer renno = null;
            BizDate syoriYmd = null;
            String syoriSosikiCd = null;
            C_FatcasnsiKbn fatcasnsikbn = null;
            C_BikkjnssinfoKbn bikkjnssinfokbn = null;
            C_FatcakekKbn fatcakekkbn = null;
            C_FatcahankeiiKbn fatcahankeiikbn = null;
            String bikknzsyno = null;
            BizDate syomeiymd = null;
            C_FatcatgKbn fatcatgkbn = null;
            String nmkn = null;
            String nmkj = null;
            BizDate seiymd = null;
            C_Seibetu sei = null;
            BizDate kouryokuendYmd = null;

            uiBean.setBfrFatcatgkbnSize(fatcaInfoLst.size());
            uiBean.setRecordkensuu(fatcaInfoLst.size());

            for (int idx = 0; idx < fatcaInfoLst.size(); idx++) {

                fatcaInfo = fatcaInfoLst.get(idx);

                renno = fatcaInfo.getRenno();
                syoriYmd = fatcaInfo.getSyoriYmd();
                syoriSosikiCd = fatcaInfo.getSyorisosikicd();
                fatcasnsikbn = fatcaInfo.getFatcasnsikbn();
                bikkjnssinfokbn = fatcaInfo.getBikkjnssinfokbn();
                fatcakekkbn = fatcaInfo.getFatcakekkbn();
                fatcahankeiikbn = fatcaInfo.getFatcahankeiikbn();
                bikknzsyno = fatcaInfo.getBikknzsyno();
                syomeiymd = fatcaInfo.getSyomeiymd();
                fatcatgkbn = fatcaInfo.getFatcatgkbn();
                nmkn = fatcaInfo.getNmkn();
                nmkj = fatcaInfo.getNmkj();
                seiymd = fatcaInfo.getSeiymd();
                sei = fatcaInfo.getSeibetu();
                kouryokuendYmd = fatcaInfo.getKouryokuendymd();

                if (idx == 0) {
                    uiBean.setRenno1(renno);
                    uiBean.setSyoriSosikicd1(syoriSosikiCd);
                    uiBean.setDispsyoriymd1(syoriYmd);
                    uiBean.setDispfatcasnsikbn1(fatcasnsikbn);
                    uiBean.setDispbikkjnssinfokbn1(bikkjnssinfokbn);
                    uiBean.setDispfatcakekkbn1(fatcakekkbn);
                    uiBean.setDispfatcahankeiikbn1(fatcahankeiikbn);
                    uiBean.setDispbikknzsyno1(bikknzsyno);
                    uiBean.setDispsyomeiymd1(syomeiymd);
                    uiBean.setDispfatcatgkbn1(fatcatgkbn);
                    uiBean.setDispnmkn1(nmkn);
                    uiBean.setDispnmkj1(nmkj);
                    uiBean.setDispseiymd1(seiymd);
                    uiBean.setDispsei1(sei);
                    uiBean.setDispkouryokuendymd1(kouryokuendYmd);

                    uiBean.setBfrrenno1(renno);
                    uiBean.setBfrSyoriymd1(syoriYmd);
                    uiBean.setBfrfatcasnsikbn1(fatcasnsikbn);
                    uiBean.setBfrbikkjnssinfokbn1(bikkjnssinfokbn);
                    uiBean.setBfrfatcakekkbn1(fatcakekkbn);
                    uiBean.setBfrfatcahankeiikbn1(fatcahankeiikbn);
                    uiBean.setBfrbikknzsyno1(bikknzsyno);
                    uiBean.setBfrsyomeiymd1(syomeiymd);
                    uiBean.setBfrfatcatgkbn1(fatcatgkbn);
                    uiBean.setBfrnmkn1(nmkn);
                    uiBean.setBfrnmkj1(nmkj);
                    uiBean.setBfrseiymd1(seiymd);
                    uiBean.setBfrsei1(sei);
                    uiBean.setBfrKouryokuendymd1(kouryokuendYmd);
                }
                else if (idx == 1) {
                    uiBean.setRenno2(renno);
                    uiBean.setSyoriSosikicd2(syoriSosikiCd);
                    uiBean.setDispsyoriymd2(syoriYmd);
                    uiBean.setDispfatcasnsikbn2(fatcasnsikbn);
                    uiBean.setDispbikkjnssinfokbn2(bikkjnssinfokbn);
                    uiBean.setDispfatcakekkbn2(fatcakekkbn);
                    uiBean.setDispfatcahankeiikbn2(fatcahankeiikbn);
                    uiBean.setDispbikknzsyno2(bikknzsyno);
                    uiBean.setDispsyomeiymd2(syomeiymd);
                    uiBean.setDispfatcatgkbn2(fatcatgkbn);
                    uiBean.setDispnmkn2(nmkn);
                    uiBean.setDispnmkj2(nmkj);
                    uiBean.setDispseiymd2(seiymd);
                    uiBean.setDispsei2(sei);
                    uiBean.setDispkouryokuendymd2(kouryokuendYmd);

                    uiBean.setBfrrenno2(renno);
                    uiBean.setBfrSyoriymd2(syoriYmd);
                    uiBean.setBfrfatcasnsikbn2(fatcasnsikbn);
                    uiBean.setBfrbikkjnssinfokbn2(bikkjnssinfokbn);
                    uiBean.setBfrfatcakekkbn2(fatcakekkbn);
                    uiBean.setBfrfatcahankeiikbn2(fatcahankeiikbn);
                    uiBean.setBfrbikknzsyno2(bikknzsyno);
                    uiBean.setBfrsyomeiymd2(syomeiymd);
                    uiBean.setBfrfatcatgkbn2(fatcatgkbn);
                    uiBean.setBfrnmkn2(nmkn);
                    uiBean.setBfrnmkj2(nmkj);
                    uiBean.setBfrseiymd2(seiymd);
                    uiBean.setBfrsei2(sei);
                    uiBean.setBfrKouryokuendymd2(kouryokuendYmd);
                }
                else if (idx == 2) {
                    uiBean.setRenno3(renno);
                    uiBean.setSyoriSosikicd3(syoriSosikiCd);
                    uiBean.setDispsyoriymd3(syoriYmd);
                    uiBean.setDispfatcasnsikbn3(fatcasnsikbn);
                    uiBean.setDispbikkjnssinfokbn3(bikkjnssinfokbn);
                    uiBean.setDispfatcakekkbn3(fatcakekkbn);
                    uiBean.setDispfatcahankeiikbn3(fatcahankeiikbn);
                    uiBean.setDispbikknzsyno3(bikknzsyno);
                    uiBean.setDispsyomeiymd3(syomeiymd);
                    uiBean.setDispfatcatgkbn3(fatcatgkbn);
                    uiBean.setDispnmkn3(nmkn);
                    uiBean.setDispnmkj3(nmkj);
                    uiBean.setDispseiymd3(seiymd);
                    uiBean.setDispsei3(sei);
                    uiBean.setDispkouryokuendymd3(kouryokuendYmd);

                    uiBean.setBfrrenno3(renno);
                    uiBean.setBfrSyoriymd3(syoriYmd);
                    uiBean.setBfrfatcasnsikbn3(fatcasnsikbn);
                    uiBean.setBfrbikkjnssinfokbn3(bikkjnssinfokbn);
                    uiBean.setBfrfatcakekkbn3(fatcakekkbn);
                    uiBean.setBfrfatcahankeiikbn3(fatcahankeiikbn);
                    uiBean.setBfrbikknzsyno3(bikknzsyno);
                    uiBean.setBfrsyomeiymd3(syomeiymd);
                    uiBean.setBfrfatcatgkbn3(fatcatgkbn);
                    uiBean.setBfrnmkn3(nmkn);
                    uiBean.setBfrnmkj3(nmkj);
                    uiBean.setBfrseiymd3(seiymd);
                    uiBean.setBfrsei3(sei);
                    uiBean.setBfrKouryokuendymd3(kouryokuendYmd);
                }
                else if (idx == 3) {
                    uiBean.setRenno4(renno);
                    uiBean.setSyoriSosikicd4(syoriSosikiCd);
                    uiBean.setDispsyoriymd4(syoriYmd);
                    uiBean.setDispfatcasnsikbn4(fatcasnsikbn);
                    uiBean.setDispbikkjnssinfokbn4(bikkjnssinfokbn);
                    uiBean.setDispfatcakekkbn4(fatcakekkbn);
                    uiBean.setDispfatcahankeiikbn4(fatcahankeiikbn);
                    uiBean.setDispbikknzsyno4(bikknzsyno);
                    uiBean.setDispsyomeiymd4(syomeiymd);
                    uiBean.setDispfatcatgkbn4(fatcatgkbn);
                    uiBean.setDispnmkn4(nmkn);
                    uiBean.setDispnmkj4(nmkj);
                    uiBean.setDispseiymd4(seiymd);
                    uiBean.setDispsei4(sei);
                    uiBean.setDispkouryokuendymd4(kouryokuendYmd);

                    uiBean.setBfrrenno4(renno);
                    uiBean.setBfrSyoriymd4(syoriYmd);
                    uiBean.setBfrfatcasnsikbn4(fatcasnsikbn);
                    uiBean.setBfrbikkjnssinfokbn4(bikkjnssinfokbn);
                    uiBean.setBfrfatcakekkbn4(fatcakekkbn);
                    uiBean.setBfrfatcahankeiikbn4(fatcahankeiikbn);
                    uiBean.setBfrbikknzsyno4(bikknzsyno);
                    uiBean.setBfrsyomeiymd4(syomeiymd);
                    uiBean.setBfrfatcatgkbn4(fatcatgkbn);
                    uiBean.setBfrnmkn4(nmkn);
                    uiBean.setBfrnmkj4(nmkj);
                    uiBean.setBfrseiymd4(seiymd);
                    uiBean.setBfrsei4(sei);
                    uiBean.setBfrKouryokuendymd4(kouryokuendYmd);
                }
                else if (idx == 4) {
                    uiBean.setRenno5(renno);
                    uiBean.setSyoriSosikicd5(syoriSosikiCd);
                    uiBean.setDispsyoriymd5(syoriYmd);
                    uiBean.setDispfatcasnsikbn5(fatcasnsikbn);
                    uiBean.setDispbikkjnssinfokbn5(bikkjnssinfokbn);
                    uiBean.setDispfatcakekkbn5(fatcakekkbn);
                    uiBean.setDispfatcahankeiikbn5(fatcahankeiikbn);
                    uiBean.setDispbikknzsyno5(bikknzsyno);
                    uiBean.setDispsyomeiymd5(syomeiymd);
                    uiBean.setDispfatcatgkbn5(fatcatgkbn);
                    uiBean.setDispnmkn5(nmkn);
                    uiBean.setDispnmkj5(nmkj);
                    uiBean.setDispseiymd5(seiymd);
                    uiBean.setDispsei5(sei);
                    uiBean.setDispkouryokuendymd5(kouryokuendYmd);

                    uiBean.setBfrrenno5(renno);
                    uiBean.setBfrSyoriymd5(syoriYmd);
                    uiBean.setBfrfatcasnsikbn5(fatcasnsikbn);
                    uiBean.setBfrbikkjnssinfokbn5(bikkjnssinfokbn);
                    uiBean.setBfrfatcakekkbn5(fatcakekkbn);
                    uiBean.setBfrfatcahankeiikbn5(fatcahankeiikbn);
                    uiBean.setBfrbikknzsyno5(bikknzsyno);
                    uiBean.setBfrsyomeiymd5(syomeiymd);
                    uiBean.setBfrfatcatgkbn5(fatcatgkbn);
                    uiBean.setBfrnmkn5(nmkn);
                    uiBean.setBfrnmkj5(nmkj);
                    uiBean.setBfrseiymd5(seiymd);
                    uiBean.setBfrsei5(sei);
                    uiBean.setBfrKouryokuendymd5(kouryokuendYmd);
                }
            }
        }


        List<IT_AeoiInfo> aeoiInfoLst = uiBean.getKykKihon().getAeoiInfos();

        uiBean.setAeoiRenno1(RENNO_ZERO);
        uiBean.setDispaeoisyoriymd1(null);
        uiBean.setDispaeoisyorisosikicd1(null);
        uiBean.setDispaeoikekkakbn1(C_AeoiKekkaKbn.BLNK);
        uiBean.setDispaeoisyorikbn1(C_AeoiSyoriKbn.BLNK);
        uiBean.setDispaeoitaisyousyakbn1(C_AeoiTaisyousyaKbn.BLNK);
        uiBean.setDispaeoihoujinsyuruikbn1(C_AeoiHoujinSyuruiKbn.BLNK);
        uiBean.setDispaeoikouryokusttymd1(null);
        uiBean.setDispaeoikouryokuendymd1(null);
        uiBean.setBfrAeoiRenno1(RENNO_ZERO);
        uiBean.setBfrAeoiSyoriymd1(null);
        uiBean.setBfrAeoiSyorisosikicd1(null);
        uiBean.setBfrAeoiKekkakbn1(C_AeoiKekkaKbn.BLNK);
        uiBean.setBfrAeoiSyorikbn1(C_AeoiSyoriKbn.BLNK);
        uiBean.setBfrAeoiTaisyousyakbn1(C_AeoiTaisyousyaKbn.BLNK);
        uiBean.setBfrAeoiHoujinsyuruikbn1(C_AeoiHoujinSyuruiKbn.BLNK);
        uiBean.setBfrAeoiKouryokusttymd1(null);
        uiBean.setBfrAeoiKouryokuendymd1(null);

        uiBean.setAeoiRenno2(RENNO_ZERO);
        uiBean.setDispaeoisyoriymd2(null);
        uiBean.setDispaeoisyorisosikicd2(null);
        uiBean.setDispaeoikekkakbn2(C_AeoiKekkaKbn.BLNK);
        uiBean.setDispaeoisyorikbn2(C_AeoiSyoriKbn.BLNK);
        uiBean.setDispaeoitaisyousyakbn2(C_AeoiTaisyousyaKbn.BLNK);
        uiBean.setDispaeoihoujinsyuruikbn2(C_AeoiHoujinSyuruiKbn.BLNK);
        uiBean.setDispaeoikouryokusttymd2(null);
        uiBean.setDispaeoikouryokuendymd2(null);
        uiBean.setBfrAeoiRenno2(RENNO_ZERO);
        uiBean.setBfrAeoiSyoriymd2(null);
        uiBean.setBfrAeoiSyorisosikicd2(null);
        uiBean.setBfrAeoiKekkakbn2(C_AeoiKekkaKbn.BLNK);
        uiBean.setBfrAeoiSyorikbn2(C_AeoiSyoriKbn.BLNK);
        uiBean.setBfrAeoiTaisyousyakbn2(C_AeoiTaisyousyaKbn.BLNK);
        uiBean.setBfrAeoiHoujinsyuruikbn2(C_AeoiHoujinSyuruiKbn.BLNK);
        uiBean.setBfrAeoiKouryokusttymd2(null);
        uiBean.setBfrAeoiKouryokuendymd2(null);

        uiBean.setAeoiRenno3(RENNO_ZERO);
        uiBean.setDispaeoisyoriymd3(null);
        uiBean.setDispaeoisyorisosikicd3(null);
        uiBean.setDispaeoikekkakbn3(C_AeoiKekkaKbn.BLNK);
        uiBean.setDispaeoisyorikbn3(C_AeoiSyoriKbn.BLNK);
        uiBean.setDispaeoitaisyousyakbn3(C_AeoiTaisyousyaKbn.BLNK);
        uiBean.setDispaeoihoujinsyuruikbn3(C_AeoiHoujinSyuruiKbn.BLNK);
        uiBean.setDispaeoikouryokusttymd3(null);
        uiBean.setDispaeoikouryokuendymd3(null);
        uiBean.setBfrAeoiRenno3(RENNO_ZERO);
        uiBean.setBfrAeoiSyoriymd3(null);
        uiBean.setBfrAeoiSyorisosikicd3(null);
        uiBean.setBfrAeoiKekkakbn3(C_AeoiKekkaKbn.BLNK);
        uiBean.setBfrAeoiSyorikbn3(C_AeoiSyoriKbn.BLNK);
        uiBean.setBfrAeoiTaisyousyakbn3(C_AeoiTaisyousyaKbn.BLNK);
        uiBean.setBfrAeoiHoujinsyuruikbn3(C_AeoiHoujinSyuruiKbn.BLNK);
        uiBean.setBfrAeoiKouryokusttymd3(null);
        uiBean.setBfrAeoiKouryokuendymd3(null);

        uiBean.setAeoiRenno4(RENNO_ZERO);
        uiBean.setDispaeoisyoriymd4(null);
        uiBean.setDispaeoisyorisosikicd4(null);
        uiBean.setDispaeoikekkakbn4(C_AeoiKekkaKbn.BLNK);
        uiBean.setDispaeoisyorikbn4(C_AeoiSyoriKbn.BLNK);
        uiBean.setDispaeoitaisyousyakbn4(C_AeoiTaisyousyaKbn.BLNK);
        uiBean.setDispaeoihoujinsyuruikbn4(C_AeoiHoujinSyuruiKbn.BLNK);
        uiBean.setDispaeoikouryokusttymd4(null);
        uiBean.setDispaeoikouryokuendymd4(null);
        uiBean.setBfrAeoiRenno4(RENNO_ZERO);
        uiBean.setBfrAeoiSyoriymd4(null);
        uiBean.setBfrAeoiSyorisosikicd4(null);
        uiBean.setBfrAeoiKekkakbn4(C_AeoiKekkaKbn.BLNK);
        uiBean.setBfrAeoiSyorikbn4(C_AeoiSyoriKbn.BLNK);
        uiBean.setBfrAeoiTaisyousyakbn4(C_AeoiTaisyousyaKbn.BLNK);
        uiBean.setBfrAeoiHoujinsyuruikbn4(C_AeoiHoujinSyuruiKbn.BLNK);
        uiBean.setBfrAeoiKouryokusttymd4(null);
        uiBean.setBfrAeoiKouryokuendymd4(null);

        uiBean.setAeoiRenno5(RENNO_ZERO);
        uiBean.setDispaeoisyoriymd5(null);
        uiBean.setDispaeoisyorisosikicd5(null);
        uiBean.setDispaeoikekkakbn5(C_AeoiKekkaKbn.BLNK);
        uiBean.setDispaeoisyorikbn5(C_AeoiSyoriKbn.BLNK);
        uiBean.setDispaeoitaisyousyakbn5(C_AeoiTaisyousyaKbn.BLNK);
        uiBean.setDispaeoihoujinsyuruikbn5(C_AeoiHoujinSyuruiKbn.BLNK);
        uiBean.setDispaeoikouryokusttymd5(null);
        uiBean.setDispaeoikouryokuendymd5(null);
        uiBean.setBfrAeoiRenno5(RENNO_ZERO);
        uiBean.setBfrAeoiSyoriymd5(null);
        uiBean.setBfrAeoiSyorisosikicd5(null);
        uiBean.setBfrAeoiKekkakbn5(C_AeoiKekkaKbn.BLNK);
        uiBean.setBfrAeoiSyorikbn5(C_AeoiSyoriKbn.BLNK);
        uiBean.setBfrAeoiTaisyousyakbn5(C_AeoiTaisyousyaKbn.BLNK);
        uiBean.setBfrAeoiHoujinsyuruikbn5(C_AeoiHoujinSyuruiKbn.BLNK);
        uiBean.setBfrAeoiKouryokusttymd5(null);
        uiBean.setBfrAeoiKouryokuendymd5(null);

        uiBean.setAeoirecordkensuu(1);

        if (!aeoiInfoLst.isEmpty()) {

            IT_AeoiInfo aeoiInfo = new IT_AeoiInfo();
            Integer aeoiRenno = null;
            BizDate aeoisyoriymd = null;
            String aeoiSyorisosikicd = null;
            C_AeoiKekkaKbn aeoiKekkakbn = null;
            C_AeoiSyoriKbn aeoiSyorikbn = null;
            C_AeoiTaisyousyaKbn aeoiTaisyousyakbn = null;
            C_AeoiHoujinSyuruiKbn aeoiHoujinsyuruikbn = null;
            BizDate aeoiKouryokusttymd = null;
            BizDate aeoiKouryokuendymd = null;
            uiBean.setBfrAeoiRecordKensuu(aeoiInfoLst.size());
            uiBean.setAeoirecordkensuu(aeoiInfoLst.size());

            for (int idx = 0; idx < aeoiInfoLst.size(); idx++) {
                aeoiInfo = aeoiInfoLst.get(idx);
                aeoiRenno = aeoiInfo.getRenno();
                aeoisyoriymd = aeoiInfo.getAeoisyoriymd();
                aeoiSyorisosikicd = aeoiInfo.getAeoisyorisosikicd();
                aeoiKekkakbn = aeoiInfo.getAeoikekkakbn();
                aeoiSyorikbn = aeoiInfo.getAeoisyorikbn();
                aeoiTaisyousyakbn = aeoiInfo.getAeoitaisyousyakbn();
                aeoiHoujinsyuruikbn = aeoiInfo.getAeoihoujinsyuruikbn();
                aeoiKouryokusttymd = aeoiInfo.getAeoikouryokusttymd();
                aeoiKouryokuendymd = aeoiInfo.getAeoikouryokuendymd();

                if (idx == 0) {

                    uiBean.setAeoiRenno1(aeoiRenno);
                    uiBean.setDispaeoisyoriymd1(aeoisyoriymd);
                    uiBean.setDispaeoisyorisosikicd1(aeoiSyorisosikicd);
                    uiBean.setDispaeoikekkakbn1(aeoiKekkakbn);
                    uiBean.setDispaeoisyorikbn1(aeoiSyorikbn);
                    uiBean.setDispaeoitaisyousyakbn1(aeoiTaisyousyakbn);
                    uiBean.setDispaeoihoujinsyuruikbn1(aeoiHoujinsyuruikbn);
                    uiBean.setDispaeoikouryokusttymd1(aeoiKouryokusttymd);
                    uiBean.setDispaeoikouryokuendymd1(aeoiKouryokuendymd);
                    uiBean.setBfrAeoiRenno1(aeoiRenno);
                    uiBean.setBfrAeoiSyoriymd1(aeoisyoriymd);
                    uiBean.setBfrAeoiSyorisosikicd1(aeoiSyorisosikicd);
                    uiBean.setBfrAeoiKekkakbn1(aeoiKekkakbn);
                    uiBean.setBfrAeoiSyorikbn1(aeoiSyorikbn);
                    uiBean.setBfrAeoiTaisyousyakbn1(aeoiTaisyousyakbn);
                    uiBean.setBfrAeoiHoujinsyuruikbn1(aeoiHoujinsyuruikbn);
                    uiBean.setBfrAeoiKouryokusttymd1(aeoiKouryokusttymd);
                    uiBean.setBfrAeoiKouryokuendymd1(aeoiKouryokuendymd);
                }
                else if (idx == 1) {

                    uiBean.setAeoiRenno2(aeoiRenno);
                    uiBean.setDispaeoisyoriymd2(aeoisyoriymd);
                    uiBean.setDispaeoisyorisosikicd2(aeoiSyorisosikicd);
                    uiBean.setDispaeoikekkakbn2(aeoiKekkakbn);
                    uiBean.setDispaeoisyorikbn2(aeoiSyorikbn);
                    uiBean.setDispaeoitaisyousyakbn2(aeoiTaisyousyakbn);
                    uiBean.setDispaeoihoujinsyuruikbn2(aeoiHoujinsyuruikbn);
                    uiBean.setDispaeoikouryokusttymd2(aeoiKouryokusttymd);
                    uiBean.setDispaeoikouryokuendymd2(aeoiKouryokuendymd);
                    uiBean.setBfrAeoiRenno2(aeoiRenno);
                    uiBean.setBfrAeoiSyoriymd2(aeoisyoriymd);
                    uiBean.setBfrAeoiSyorisosikicd2(aeoiSyorisosikicd);
                    uiBean.setBfrAeoiKekkakbn2(aeoiKekkakbn);
                    uiBean.setBfrAeoiSyorikbn2(aeoiSyorikbn);
                    uiBean.setBfrAeoiTaisyousyakbn2(aeoiTaisyousyakbn);
                    uiBean.setBfrAeoiHoujinsyuruikbn2(aeoiHoujinsyuruikbn);
                    uiBean.setBfrAeoiKouryokusttymd2(aeoiKouryokusttymd);
                    uiBean.setBfrAeoiKouryokuendymd2(aeoiKouryokuendymd);
                }
                else if (idx == 2) {

                    uiBean.setAeoiRenno3(aeoiRenno);
                    uiBean.setDispaeoisyoriymd3(aeoisyoriymd);
                    uiBean.setDispaeoisyorisosikicd3(aeoiSyorisosikicd);
                    uiBean.setDispaeoikekkakbn3(aeoiKekkakbn);
                    uiBean.setDispaeoisyorikbn3(aeoiSyorikbn);
                    uiBean.setDispaeoitaisyousyakbn3(aeoiTaisyousyakbn);
                    uiBean.setDispaeoihoujinsyuruikbn3(aeoiHoujinsyuruikbn);
                    uiBean.setDispaeoikouryokusttymd3(aeoiKouryokusttymd);
                    uiBean.setDispaeoikouryokuendymd3(aeoiKouryokuendymd);
                    uiBean.setBfrAeoiRenno3(aeoiRenno);
                    uiBean.setBfrAeoiSyoriymd3(aeoisyoriymd);
                    uiBean.setBfrAeoiSyorisosikicd3(aeoiSyorisosikicd);
                    uiBean.setBfrAeoiKekkakbn3(aeoiKekkakbn);
                    uiBean.setBfrAeoiSyorikbn3(aeoiSyorikbn);
                    uiBean.setBfrAeoiTaisyousyakbn3(aeoiTaisyousyakbn);
                    uiBean.setBfrAeoiHoujinsyuruikbn3(aeoiHoujinsyuruikbn);
                    uiBean.setBfrAeoiKouryokusttymd3(aeoiKouryokusttymd);
                    uiBean.setBfrAeoiKouryokuendymd3(aeoiKouryokuendymd);
                }
                else if (idx == 3) {

                    uiBean.setAeoiRenno4(aeoiRenno);
                    uiBean.setDispaeoisyoriymd4(aeoisyoriymd);
                    uiBean.setDispaeoisyorisosikicd4(aeoiSyorisosikicd);
                    uiBean.setDispaeoikekkakbn4(aeoiKekkakbn);
                    uiBean.setDispaeoisyorikbn4(aeoiSyorikbn);
                    uiBean.setDispaeoitaisyousyakbn4(aeoiTaisyousyakbn);
                    uiBean.setDispaeoihoujinsyuruikbn4(aeoiHoujinsyuruikbn);
                    uiBean.setDispaeoikouryokusttymd4(aeoiKouryokusttymd);
                    uiBean.setDispaeoikouryokuendymd4(aeoiKouryokuendymd);
                    uiBean.setBfrAeoiRenno4(aeoiRenno);
                    uiBean.setBfrAeoiSyoriymd4(aeoisyoriymd);
                    uiBean.setBfrAeoiSyorisosikicd4(aeoiSyorisosikicd);
                    uiBean.setBfrAeoiKekkakbn4(aeoiKekkakbn);
                    uiBean.setBfrAeoiSyorikbn4(aeoiSyorikbn);
                    uiBean.setBfrAeoiTaisyousyakbn4(aeoiTaisyousyakbn);
                    uiBean.setBfrAeoiHoujinsyuruikbn4(aeoiHoujinsyuruikbn);
                    uiBean.setBfrAeoiKouryokusttymd4(aeoiKouryokusttymd);
                    uiBean.setBfrAeoiKouryokuendymd4(aeoiKouryokuendymd);
                }
                else if (idx == 4) {

                    uiBean.setAeoiRenno5(aeoiRenno);
                    uiBean.setDispaeoisyoriymd5(aeoisyoriymd);
                    uiBean.setDispaeoisyorisosikicd5(aeoiSyorisosikicd);
                    uiBean.setDispaeoikekkakbn5(aeoiKekkakbn);
                    uiBean.setDispaeoisyorikbn5(aeoiSyorikbn);
                    uiBean.setDispaeoitaisyousyakbn5(aeoiTaisyousyakbn);
                    uiBean.setDispaeoihoujinsyuruikbn5(aeoiHoujinsyuruikbn);
                    uiBean.setDispaeoikouryokusttymd5(aeoiKouryokusttymd);
                    uiBean.setDispaeoikouryokuendymd5(aeoiKouryokuendymd);
                    uiBean.setBfrAeoiRenno5(aeoiRenno);
                    uiBean.setBfrAeoiSyoriymd5(aeoisyoriymd);
                    uiBean.setBfrAeoiSyorisosikicd5(aeoiSyorisosikicd);
                    uiBean.setBfrAeoiKekkakbn5(aeoiKekkakbn);
                    uiBean.setBfrAeoiSyorikbn5(aeoiSyorikbn);
                    uiBean.setBfrAeoiTaisyousyakbn5(aeoiTaisyousyakbn);
                    uiBean.setBfrAeoiHoujinsyuruikbn5(aeoiHoujinsyuruikbn);
                    uiBean.setBfrAeoiKouryokusttymd5(aeoiKouryokusttymd);
                    uiBean.setBfrAeoiKouryokuendymd5(aeoiKouryokuendymd);
                }
            }
        }
    }

    private void setSitiken() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(uiBean.getSyono());

        List<IT_KykSyouhn> kykSyouhnList = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        BM_SyouhnZokusei syouhnZokusei = kykSyouhnList.get(0).getSyouhnZokusei();

        if (syouhnZokusei != null) {

            uiBean.setStknUmu(syouhnZokusei.getStknumu());
        }
    }

    private void setTtdkTyuuiForModoru() {

        List<TtdkTyuui1DataSourceBean> ttdkTyuui1DataLst =
            uiBean.getTtdkTyuui1DataSource().getDatas();
        TtdkTyuui1DataSourceBean ttdkTyuui1DataBean;
        for (int i = ttdkTyuui1DataLst.size(); i < 5; i++) {
            ttdkTyuui1DataBean = new TtdkTyuui1DataSourceBean();
            ttdkTyuui1DataBean.setBfrTtdktyuuikbn(C_TtdktyuuiKbn.BLNK);
            ttdkTyuui1DataBean.setBfrTtdktyuuikbnhsknaiyou("");
            ttdkTyuui1DataBean.setBfrTtdktyuuikbnsetymd(null);
            ttdkTyuui1DataLst.add(ttdkTyuui1DataBean);
        }
        uiBean.setTtdkTyuui1(ttdkTyuui1DataLst);
    }

    private Boolean fatcaHenkouCheck(
        Integer pRenno,
        Boolean pDispfatcasakujyo,
        BizDate pDispSyoriymd,
        BizDate pDispBfrSyoriymd,
        C_FatcasnsiKbn pDispfatcasnsikbn,
        C_FatcasnsiKbn pBfrfatcasnsikbn,
        C_BikkjnssinfoKbn pDispbikkjnssinfokbn,
        C_BikkjnssinfoKbn pBfrbikkjnssinfokbn,
        C_FatcakekKbn pDispfatcakekkbn,
        C_FatcakekKbn pBfrfatcakekkbn,
        C_FatcahankeiiKbn pDispfatcahankeiikbn,
        C_FatcahankeiiKbn pBfrfatcahankeiikbn,
        String pDispbikknzsyno,
        String pBfrbikknzsyno,
        BizDate pDispsyomeiymd,
        BizDate pBfrsyomeiymd,
        C_FatcatgKbn pDispfatcatgkbn,
        C_FatcatgKbn pBfrfatcatgkbn,
        String pDispnmkn,
        String pBfrnmkn,
        String pDispnmkj,
        String pBfrnmkj,
        BizDate pDispseiymd,
        BizDate pBfrseiymd,
        C_Seibetu pDispsei,
        C_Seibetu pBfrsei,
        BizDate pDispKouryokuendymd,
        BizDate pBfrKouryokuendymd) {

        if (pRenno == RENNO_ZERO) {

            if (!pDispfatcasakujyo &&
                !C_FatcakekKbn.BLNK.eq(pDispfatcakekkbn)) {

                return true;
            }
        }
        else {

            if (!pDispfatcasakujyo) {

                if (BizDateUtil.compareYmd(pDispSyoriymd, pDispBfrSyoriymd) != BizDateUtil.COMPARE_EQUAL ||
                    !pDispfatcasnsikbn.eq(pBfrfatcasnsikbn) ||
                    !pDispbikkjnssinfokbn.eq(pBfrbikkjnssinfokbn) ||
                    !pDispfatcakekkbn.eq(pBfrfatcakekkbn) ||
                    !pDispfatcahankeiikbn.eq(pBfrfatcahankeiikbn) ||
                    !pDispbikknzsyno.equals(pBfrbikknzsyno) ||
                    BizDateUtil.compareYmd(pDispsyomeiymd, pBfrsyomeiymd) != BizDateUtil.COMPARE_EQUAL ||
                    !pDispfatcatgkbn.eq(pBfrfatcatgkbn) ||
                    !pDispnmkn.equals(pBfrnmkn) ||
                    !pDispnmkj.equals(pBfrnmkj) ||
                    BizDateUtil.compareYmd(pDispseiymd, pBfrseiymd) != BizDateUtil.COMPARE_EQUAL ||
                    !pDispsei.eq(pBfrsei) ||
                    BizDateUtil.compareYmd(pDispKouryokuendymd, pBfrKouryokuendymd) != BizDateUtil.COMPARE_EQUAL) {

                    return true;
                }
            }
            else {
                return true;
            }
        }

        return false;
    }

    private Boolean aeoiHenkouCheck(
        Integer pAeoiRenno,
        Boolean pDispAeoiSakujyo,
        BizDate pDispAeoiSyoriymd,
        BizDate pBfrAeoiSyoriymd,
        String pDispAeoiSyorisosikicd,
        String pBfrAeoiSyorisosikicd,
        C_AeoiKekkaKbn pDispAeoiKekkakbn,
        C_AeoiKekkaKbn pBfrAeoiKekkakbn,
        C_AeoiSyoriKbn pDispAeoiSyorikbn,
        C_AeoiSyoriKbn pBfrAeoiSyorikbn,
        C_AeoiTaisyousyaKbn pDispAeoiTaisyousyakbn,
        C_AeoiTaisyousyaKbn pBfrAeoiTaisyousyakbn,
        C_AeoiHoujinSyuruiKbn pDispAeoiHoujinsyuruikbn,
        C_AeoiHoujinSyuruiKbn pBfrAeoiHoujinsyuruikbn,
        BizDate pDispAeoiKouryokusttymd,
        BizDate pBfrAeoiKouryokusttymd,
        BizDate pDispAeoiKouryokuendymd,
        BizDate pBfrAeoiKouryokuendymd) {


        if (pAeoiRenno == RENNO_ZERO) {
            if (!pDispAeoiSakujyo && !C_AeoiKekkaKbn.BLNK.eq(pDispAeoiKekkakbn)) {
                return true;
            }
        }
        else{
            if (!pDispAeoiSakujyo) {
                if (BizDateUtil.compareYmd(pDispAeoiSyoriymd, pBfrAeoiSyoriymd) != BizDateUtil.COMPARE_EQUAL
                    || !pDispAeoiSyorisosikicd.equals(pBfrAeoiSyorisosikicd)
                    || !pDispAeoiKekkakbn.eq(pBfrAeoiKekkakbn)
                    || !pDispAeoiSyorikbn.eq(pBfrAeoiSyorikbn)
                    || !pDispAeoiTaisyousyakbn.eq(pBfrAeoiTaisyousyakbn)
                    || !pDispAeoiHoujinsyuruikbn.eq(pBfrAeoiHoujinsyuruikbn)
                    || BizDateUtil.compareYmd(pDispAeoiKouryokusttymd, pBfrAeoiKouryokusttymd) != BizDateUtil.COMPARE_EQUAL
                    || BizDateUtil.compareYmd(pDispAeoiKouryokuendymd, pBfrAeoiKouryokuendymd) != BizDateUtil.COMPARE_EQUAL) {
                    return true;
                }
            }
            else{
                return true;
            }
        }
        return false;
    }

    private Boolean ttdkTyuuiSakujoCheck(C_TtdktyuuiKbn pTtdkTyuuiKbn, String pTtdkTyuuiKbnHskNaiyou,
        BizDate pTtdkTyuuiKbnSetYmd, Boolean pttdktyuuisakujyoKbn) {

        if (C_TtdktyuuiKbn.BLNK.eq(pTtdkTyuuiKbn) && BizUtil.isBlank(pTtdkTyuuiKbnHskNaiyou) &&
            pTtdkTyuuiKbnSetYmd == null && pttdktyuuisakujyoKbn) {
            return false;
        }
        return true;
    }

    private Boolean ttdkTyuuiMinyuryokuCheck(C_TtdktyuuiKbn pTtdkTyuuiKbn, String pTtdkTyuuiKbnHskNaiyou,
        BizDate pTtdkTyuuiKbnSetYmd, Boolean pttdktyuuisakujyoKbn) {

        if (C_TtdktyuuiKbn.BLNK.eq(pTtdkTyuuiKbn) && (!BizUtil.isBlank(pTtdkTyuuiKbnHskNaiyou) ||
            pTtdkTyuuiKbnSetYmd != null) && !pttdktyuuisakujyoKbn) {
            return false;
        }
        return true;
    }

    private void fatcaInputCheck(
        int pNameKeta,
        Integer pRenno,
        Boolean pDispfatcasakujyo,
        BizDate pDispSyoriymd,
        C_FatcasnsiKbn pDispfatcasnsikbn,
        C_BikkjnssinfoKbn pDispbikkjnssinfokbn,
        C_FatcakekKbn pDispfatcakekkbn,
        C_FatcahankeiiKbn pDispfatcahankeiikbn,
        String pDispbikknzsyno,
        BizDate pDispsyomeiymd,
        C_FatcatgKbn pDispfatcatgkbn,
        String pDispnmkn,
        String pDispnmkj,
        BizDate pDispseiymd,
        C_Seibetu pDispsei,
        BizDate pDispKouryokuendymd) {

        validate(pDispnmkn, pNameKeta);

        if (pDispfatcasakujyo == true) {
            return;
        }

        if (pRenno == RENNO_ZERO &&
            pDispSyoriymd == null &&
            C_FatcasnsiKbn.BLNK.eq(pDispfatcasnsikbn) &&
            C_BikkjnssinfoKbn.BLNK.eq(pDispbikkjnssinfokbn) &&
            C_FatcakekKbn.BLNK.eq(pDispfatcakekkbn) &&
            C_FatcahankeiiKbn.BLNK.eq(pDispfatcahankeiikbn) &&
            BizUtil.isBlank(pDispbikknzsyno) &&
            pDispsyomeiymd == null &&
            C_FatcatgKbn.BLNK.eq(pDispfatcatgkbn) &&
            BizUtil.isBlank(pDispnmkn) &&
            BizUtil.isBlank(pDispnmkj) &&
            pDispseiymd == null &&
            C_Seibetu.BLNK.eq(pDispsei) &&
            pDispKouryokuendymd == null) {

            return;
        }

        if (pDispSyoriymd == null) {
            throw new BizLogicException(MessageId.EBC0043, DISP_FATCASYORIYMD);
        }

        if (C_FatcakekKbn.BLNK.eq(pDispfatcakekkbn)) {
            throw new BizLogicException(MessageId.EBC0043, DISP_FATCAKEKKBN);
        }

        if (C_FatcahankeiiKbn.BLNK.eq(pDispfatcahankeiikbn)) {
            throw new BizLogicException(MessageId.EBC0043, DISP_ATCAHANKEIIKBN);
        }

        if (C_FatcatgKbn.BLNK.eq(pDispfatcatgkbn)) {
            throw new BizLogicException(MessageId.EBC0043, DISP_FATCATGKBN);
        }


        if (!C_FatcakekKbn.TOKUTEIAMERICAN.eq(pDispfatcakekkbn) && !BizUtil.isBlank(pDispbikknzsyno)) {
            throw new BizLogicException(MessageId.EBC0012, DISP_BIKKNZSYNO);
        }

        if (pDispKouryokuendymd != null) {
            if (BizDateUtil.compareYmd(pDispKouryokuendymd, pDispSyoriymd) == BizDateUtil.COMPARE_LESSER) {
                throw new BizLogicException(MessageId.EIC1001, DISP_FATCAKOURYOKUENDYMD, DISP_FATCASYORIYMD);
            }
        }


        if (C_FatcatgKbn.KYK.eq(pDispfatcatgkbn)) {

            if (!BizUtil.isBlank(pDispnmkn) ||
                !BizUtil.isBlank(pDispnmkj) ||
                pDispseiymd != null ||
                !C_Seibetu.BLNK.eq(pDispsei)) {

                if (BizUtil.isBlank(pDispnmkn)) {
                    throw new BizLogicException(MessageId.EBC0043, DISP_NMKN);
                }

                if (BizUtil.isBlank(pDispnmkj)) {
                    throw new BizLogicException(MessageId.EBC0043, DISP_NMKJ);
                }

                if (pDispseiymd == null) {
                    throw new BizLogicException(MessageId.EBC0043, DISP_SEIYMD);
                }

                if (C_Seibetu.BLNK.eq(pDispsei)) {
                    throw new BizLogicException(MessageId.EBC0043, DISP_SEI);
                }
            }
        }
        else {
            if (BizUtil.isBlank(pDispnmkn)) {
                throw new BizLogicException(MessageId.EBC0043, DISP_NMKN);
            }

            if (BizUtil.isBlank(pDispnmkj)) {
                throw new BizLogicException(MessageId.EBC0043, DISP_NMKJ);
            }

            if (pDispseiymd == null) {
                throw new BizLogicException(MessageId.EBC0043, DISP_SEIYMD);
            }

            if (C_Seibetu.BLNK.eq(pDispsei)) {
                throw new BizLogicException(MessageId.EBC0043, DISP_SEI);
            }
        }

        return;
    }

    private void aeoiInputCheck(
        Integer pAeoiRenno,
        boolean pDispAeoiSakujyo,
        BizDate pDispAeoiSyoriymd,
        String pDispAeoiSyorisosikicd,
        C_AeoiKekkaKbn pDispAeoiKekkakbn,
        C_AeoiSyoriKbn pDispAeoiSyorikbn,
        C_AeoiTaisyousyaKbn pDispAeoiTaisyousyakbn,
        C_AeoiHoujinSyuruiKbn pDispAeoiHoujinsyuruikbn,
        BizDate pDispAeoiKouryokusttymd,
        BizDate pDispAeoiKouryokuendymd) {


        if (pDispAeoiSakujyo) {
            return;
        }


        if (pAeoiRenno == RENNO_ZERO && pDispAeoiSyoriymd == null && BizUtil.isBlank(pDispAeoiSyorisosikicd)
            && C_AeoiKekkaKbn.BLNK.eq(pDispAeoiKekkakbn) && C_AeoiSyoriKbn.BLNK.eq(pDispAeoiSyorikbn)
            && C_AeoiTaisyousyaKbn.BLNK.eq(pDispAeoiTaisyousyakbn)
            && C_AeoiHoujinSyuruiKbn.BLNK.eq(pDispAeoiHoujinsyuruikbn) && pDispAeoiKouryokusttymd == null
            && pDispAeoiKouryokuendymd == null) {
            return;
        }


        if (pDispAeoiSyoriymd == null) {
            throw new BizLogicException(MessageId.EBC0043, DISP_AEOISYORIYMD);
        }

        if (BizUtil.isBlank(pDispAeoiSyorisosikicd)) {
            throw new BizLogicException(MessageId.EBC0043, DISP_AEOISYORISOSIKICD);
        }

        if (C_AeoiKekkaKbn.BLNK.eq(pDispAeoiKekkakbn)) {
            throw new BizLogicException(MessageId.EBC0043, DISP_AEOIKEKKAKBN);
        }

        if (C_AeoiSyoriKbn.BLNK.eq(pDispAeoiSyorikbn)) {
            throw new BizLogicException(MessageId.EBC0043, DISP_AEOISYORIKBN);
        }

        if (C_AeoiTaisyousyaKbn.BLNK.eq(pDispAeoiTaisyousyakbn)) {
            throw new BizLogicException(MessageId.EBC0043, DISP_AEOITAISYOUSYAKBN);
        }

        if (pDispAeoiKouryokusttymd == null) {
            throw new BizLogicException(MessageId.EBC0043, DISP_AEOIKOURYOKUSTTYMD);
        }

        if(BizDateUtil.compareYmd(pDispAeoiKouryokusttymd, pDispAeoiSyoriymd) == BizDateUtil.COMPARE_LESSER ){
            throw new BizLogicException(MessageId.EIC1001, DISP_AEOIKOURYOKUSTTYMD, DISP_AEOISYORIYMD);
        }

        if (pDispAeoiKouryokuendymd != null) {
            if (BizDateUtil.compareYmd(pDispAeoiKouryokuendymd, pDispAeoiSyoriymd) == BizDateUtil.COMPARE_LESSER) {
                throw new BizLogicException(MessageId.EIC1001, DISP_AEOIKOURYOKUENDYMD, DISP_AEOISYORIYMD);
            }
        }
    }

    private void updateKTKykKihon(BizDate pDate, String pTime) {

        IT_KykKihon kykKihon = uiBean.getKykKihon();

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        kykKihon.setStknsetkbn(uiBean.getStknsetkbn());
        kykKihon.setSyhenkouymd(pDate);
        kykKihon.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
        kykKihon.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
        kykKihon.setGyoumuKousinTime(pTime);

        hozenDomManager.update(kykKihon);

        return;
    }

    private void fatcaInfoUpd(
        Integer pRenno,
        Boolean pDispfatcasakujyo,
        BizDate pDispSyoriymd,
        String pSyoriSosikicd,
        C_FatcasnsiKbn pDispfatcasnsikbn,
        C_BikkjnssinfoKbn pDispbikkjnssinfokbn,
        C_FatcakekKbn pDispfatcakekkbn,
        C_FatcahankeiiKbn pDispfatcahankeiikbn,
        String pDispbikknzsyno,
        BizDate pDispsyomeiymd,
        C_FatcatgKbn pDispfatcatgkbn,
        String pDispnmkn,
        String pDispnmkj,
        BizDate pDispseiymd,
        C_Seibetu pDispsei,
        BizDate pDispKouryokuendymd,
        C_FatcatgKbn pBfrfatcatgkbn,
        int pIdx) {

        BizDate sysDate = BizDate.getSysDate();
        String sysTime = BizDate.getSysDateTimeMilli();

        IT_KykKihon kykKihon = uiBean.getKykKihon();

        if (!pDispfatcasakujyo) {

            if (C_FatcakekKbn.BLNK.eq(pDispfatcakekkbn)) {
                return;
            }

            String wkNmkn;
            String wkNmkj;
            BizDate wkSeiymd;
            C_Seibetu wkSei;

            if (C_FatcatgKbn.KYK.eq(pDispfatcatgkbn) &&
                BizUtil.isBlank(pDispnmkn)) {

                wkNmkn = uiBean.getVkykskyknmkn();
                wkNmkj = uiBean.getVkykskyknmkj();
                wkSeiymd = uiBean.getVkykskykseiymd();
                wkSei = C_Seibetu.valueOf(uiBean.getVkykskyksei().toString());
            }
            else {
                wkNmkn = pDispnmkn;
                wkNmkj = pDispnmkj;
                wkSeiymd = pDispseiymd;
                wkSei = pDispsei;
            }

            String wkSeionnmkn = BizUtil.editKana(wkNmkn);

            IT_FatcaInfo fatcaInfo;

            if (pRenno == RENNO_ZERO) {

                if (maxRenno == RENNO_MAX) {

                    throw new ForwardBizLogicException(FORWARDNAME_REFERENCE, MessageId.EIA0178);
                }

                fatcaInfo = kykKihon.createFatcaInfo();

                maxRenno++;

                fatcaInfo.setRenno(maxRenno);
                fatcaInfo.setTrkymd(sysDate);
            }
            else {
                fatcaInfo = kykKihon.getFatcaInfoByRenno(pRenno);
            }

            KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

            fatcaInfo.setSyoriYmd(pDispSyoriymd);
            fatcaInfo.setSyorisosikicd(pSyoriSosikicd);
            fatcaInfo.setFatcasnsikbn(pDispfatcasnsikbn);
            fatcaInfo.setBikkjnssinfokbn(pDispbikkjnssinfokbn);
            fatcaInfo.setFatcakekkbn(pDispfatcakekkbn);
            fatcaInfo.setFatcahankeiikbn(pDispfatcahankeiikbn);
            fatcaInfo.setBikknzsyno(pDispbikknzsyno);
            fatcaInfo.setSyomeiymd(pDispsyomeiymd);
            fatcaInfo.setKokno("");
            fatcaInfo.setFatcatgkbn(pDispfatcatgkbn);
            fatcaInfo.setSeionnmkn(wkSeionnmkn);
            fatcaInfo.setNmkj(wkNmkj);
            fatcaInfo.setNmkn(wkNmkn);
            fatcaInfo.setSeiymd(wkSeiymd);
            fatcaInfo.setSeibetu(wkSei);
            fatcaInfo.setKouryokuendymd(pDispKouryokuendymd);
            fatcaInfo.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
            fatcaInfo.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
            fatcaInfo.setGyoumuKousinTime(sysTime);
        }
        else {
            if (pRenno != RENNO_ZERO) {
                List<IT_FatcaInfo> fatcaInfos = kykKihon.getFatcaInfos();
                fatcaInfos.remove(kykKihon.getFatcaInfoByRenno(pRenno));
            }
        }
    }

    private void aeoiInfoUpd(
        Integer pAeoiRenno,
        boolean pDispAeoiSakujyo,
        BizDate pDispAeoiSyoriymd,
        String pDispAeoiSyorisosikicd,
        C_AeoiKekkaKbn pDispAeoiKekkakbn,
        C_AeoiSyoriKbn pDispAeoiSyorikbn,
        C_AeoiTaisyousyaKbn pDispAeoiTaisyousyakbn,
        C_AeoiHoujinSyuruiKbn pDispAeoiHoujinsyuruikbn,
        BizDate pDispAeoiKouryokusttymd,
        BizDate pDispAeoiKouryokuendymd,
        int pIdx) {

        String sysTime = BizDate.getSysDateTimeMilli();
        IT_KykKihon kykKihon = uiBean.getKykKihon();


        if (!pDispAeoiSakujyo) {

            if (C_AeoiKekkaKbn.BLNK.eq(pDispAeoiKekkakbn)) {

                return;
            }

            IT_AeoiInfo aeoiInfo;


            if (pAeoiRenno == RENNO_ZERO) {

                if (aeoiMaxRenno == RENNO_MAX) {
                    throw new ForwardBizLogicException(FORWARDNAME_REFERENCE, MessageId.EIA1018);
                }
                aeoiInfo = kykKihon.createAeoiInfo();
                aeoiMaxRenno++;
                aeoiInfo.setRenno(aeoiMaxRenno);
            }
            else {

                aeoiInfo = kykKihon.getAeoiInfoByRenno(pAeoiRenno);
            }

            KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

            aeoiInfo.setAeoisyoriymd(pDispAeoiSyoriymd);
            aeoiInfo.setAeoisyorisosikicd(pDispAeoiSyorisosikicd);
            aeoiInfo.setAeoikekkakbn(pDispAeoiKekkakbn);
            aeoiInfo.setAeoisyorikbn(pDispAeoiSyorikbn);
            aeoiInfo.setAeoitaisyousyakbn(pDispAeoiTaisyousyakbn);
            aeoiInfo.setAeoihoujinsyuruikbn(pDispAeoiHoujinsyuruikbn);
            aeoiInfo.setAeoikouryokusttymd(pDispAeoiKouryokusttymd);
            aeoiInfo.setAeoikouryokuendymd(pDispAeoiKouryokuendymd);
            aeoiInfo.setGyoumuKousinKinou(khozenCommonParam.getFunctionId());
            aeoiInfo.setGyoumuKousinsyaId(khozenCommonParam.getUserID());
            aeoiInfo.setGyoumuKousinTime(sysTime);
        }
        else {

            if (pAeoiRenno != RENNO_ZERO) {

                List<IT_AeoiInfo> aeoiInfoLst = kykKihon.getAeoiInfos();
                IT_AeoiInfo aeoiInfo = kykKihon.getAeoiInfoByRenno(pAeoiRenno);
                aeoiInfoLst.remove(aeoiInfo);
            }
        }
    }

    private void validate(String pNmkn, int pNameKeta) {

        if (BizUtil.isBlank(pNmkn)) {
            return;
        }

        if (!CheckKana.isKyokaMoji(pNmkn)) {
            throw new BizLogicException(MessageId.EBC0046, DISP_NMKN);
        }

        if (!CheckKana.isKyoyouKetaHankaku(pNmkn, pNameKeta)) {
            throw new BizLogicException(MessageId.EIC0006, DISP_NMKN, String.valueOf(pNameKeta));
        }
    }

    private boolean setUiBean() {

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);

        SetToriatukaiTyuui setToriatukaiTyuui = SWAKInjector.getInstance(SetToriatukaiTyuui.class);

        SetBetukyk setBetukyk = SWAKInjector.getInstance(SetBetukyk.class);

        SetTrkKazoku.exec(khozenCommonParam, uiBean);

        SetKyksyadairi.exec(khozenCommonParam, uiBean);

        if (
            setToriatukaiTyuui.exec(khozenCommonParam, uiBean) &&
            SetKihon.exec(khozenCommonParam, uiBean) &&
            setBetukyk.exec(khozenCommonParam, uiBean) &&
            SetKeiyakusya.exec(khozenCommonParam, uiBean) &&
            SetHihokensya.exec(khozenCommonParam, uiBean)) {

            if (uiBean.getWarningMessageIdList() != null && uiBean.getWarningMessageIdList().size() > 0) {

                for (int n = 0; n < uiBean.getWarningMessageIdList().size(); n++) {

                    messageManager.addConversationMessageId(
                        KhMessageGroupConstants.GROUP_WARNING1,
                        uiBean.getWarningMessageIdList().get(n),
                        uiBean.getWarningMessageList().get(n));
                }
            }
            return true;
        }
        return false;
    }
}
