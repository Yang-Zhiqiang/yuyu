package yuyu.app.direct.dskokyakukanri.dskokyakuseibi;

import static yuyu.app.direct.dskokyakukanri.dskokyakuseibi.DsKokyakuSeibiConstants.*;
import static yuyu.app.direct.dskokyakukanri.dskokyakuseibi.GenDsKokyakuSeibiConstants.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.configuration.Item;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.bizinfr.exception.ErrorMessageCollector;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateConfig;
import jp.co.slcs.swak.date.BizDateFormat;
import jp.co.slcs.swak.date.BizDateFormat.FillStyle;
import jp.co.slcs.swak.date.SeirekiWarekiKbn;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;

import org.slf4j.Logger;

import yuyu.app.direct.dskokyakukanri.dskokyakuseibi.dba.DsKokyakuSeibiDao;
import yuyu.app.direct.dskokyakukanri.dskokyakuseibi.dba.TktiTrhkyuKzInfoBean;
import yuyu.common.base.BaseUserInfo;
import yuyu.common.base.CTIParamBean;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.BzGetBankData;
import yuyu.common.biz.bzcommon.BzGetBankDataBean;
import yuyu.common.biz.bzcommon.CheckMeigininNmKana;
import yuyu.common.biz.bzcommon.CheckMeigininNmKanji;
import yuyu.common.biz.bzcommon.GetBankSitenNm;
import yuyu.common.direct.dscommon.CheckDsTorihikiService;
import yuyu.common.direct.dscommon.CheckSoukinyoukzResultBean;
import yuyu.common.direct.dscommon.DsKanyuuYoukenCheck;
import yuyu.common.direct.dscommon.DsSaibanSyori;
import yuyu.common.direct.dscommon.DsTetudukiRirekiTableEdit;
import yuyu.common.direct.dscommon.DsTetudukiRirekiTableEditParamImpl;
import yuyu.common.direct.dscommon.TableMaintenanceUtil;
import yuyu.def.MessageId;
import yuyu.def.biz.configuration.YuyuBizConfig;
import yuyu.def.classification.C_BankmasterUmuKbn;
import yuyu.def.classification.C_DsKanyuuKeiroKbn;
import yuyu.def.classification.C_DsKinouModeIdKbn;
import yuyu.def.classification.C_DsKokyakuJtKbn;
import yuyu.def.classification.C_DsKrHnnKakCdSetKbn;
import yuyu.def.classification.C_DsKrHnnKakCdTtTydnJyKbn;
import yuyu.def.classification.C_DsKrHnnKakCdTtYhKbn;
import yuyu.def.classification.C_DsMailDbSyoriKbn;
import yuyu.def.classification.C_DsMailSousinJyoutaiKbn;
import yuyu.def.classification.C_DsMailSousinTeisiRiyuuKbn;
import yuyu.def.classification.C_DsMailTourokuJyoutaiKbn;
import yuyu.def.classification.C_DsRendouTaisyouKbn;
import yuyu.def.classification.C_DsSyoriKbn;
import yuyu.def.classification.C_DsTeisiRiyuuKbn;
import yuyu.def.classification.C_DsTrhkserviceKanyukeiroKbn;
import yuyu.def.classification.C_DsTrhkserviceRiyoujkKbn;
import yuyu.def.classification.C_DsTrhkserviceTeisiRiyuuKbn;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Kojinhjn;
import yuyu.def.classification.C_KouzasyuruiKbn;
import yuyu.def.classification.C_Kzdou;
import yuyu.def.classification.C_MukouHyj;
import yuyu.def.classification.C_PasswordJtKbn;
import yuyu.def.classification.C_SeibiRiyuuKbn;
import yuyu.def.classification.C_SoukinyoukzchkkekkaKbn;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.MT_BAK_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsHonninKakuninCd;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsKokyakuKeiyaku;
import yuyu.def.db.entity.MT_DsLoginKanri;
import yuyu.def.db.entity.MT_DsMailAddress;
import yuyu.def.db.entity.MT_DsMailAddressSpiralYyk;
import yuyu.def.db.entity.MT_DsSoukinyouKouza;
import yuyu.def.db.entity.MT_DsTorihikiServiceKanri;
import yuyu.def.db.entity.MT_DsTorihikiyouAnsyono;
import yuyu.def.direct.detacher.MT_DsKokyakuKanriDetacher;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.def.direct.result.bean.DsKokyakuKanrisByItemsBean;
import yuyu.def.direct.sorter.SortMT_DsKokyakuKanri;
import yuyu.def.hozen.detacher.IT_KykKihonDetacher;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.def.hozen.result.bean.KykKihonsByLastjyuuhenymdSyoriYmdFromSyoriYmdToDskykmukouhyjBean;
import yuyu.def.hozen.result.bean.KykKihonsBySyoriYmdFromSyoriYmdToDskykmukouhyjBean;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

/**
 * 顧客整備 のビジネスロジックです。
 */
public class DsKokyakuSeibiBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private DsKokyakuSeibiUiBean uiBean;

    @Inject
    private CTIParamBean cTIParamBean;

    @Inject
    private ErrorMessageCollector errorMessageCollector;

    @Inject
    private DirectDomManager directDomManager;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private MessageManager messageManager;

    @Inject
    private DsKokyakuSeibiDao dsKokyakuSeibiDao;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Inject
    private AS_Kinou kinou;

    void init() {
        clear();
    }

    void clear() {

         messageManager.clear();
    }

    void pushKokseibibtnBL() {

        BizPropertyInitializer.initialize(uiBean);
    }

    void fromCTIkokseibi() {
        uiBean.setSrchsyono(cTIParamBean.getSyono());
    }

    void pushSeibitssearchbtnBL() {

        BizPropertyInitializer.initialize(uiBean);

        uiBean.setSyoriYmdFrom(BizDate.getSysDate().addBusinessDays(INIT_SYORIYMD_FROM));

        uiBean.setSyoriYmdTo(BizDate.getSysDate().addBusinessDays(INIT_SYORIYMD_TO));
    }

    void pushSearchtktitrhkkzbtnBL() {

        BizPropertyInitializer.initialize(uiBean);

        messageManager.addConversationMessageId(KOKSEIBI_SEARCHTKTITRHKKZ,
            MessageId.IMF1025);

        messageManager.addConversationMessageId(KOKSEIBI_SEARCHTKTITRHKKZ,
            MessageId.IMF1026);

    }

    void pushSearchbtnbyinputkeyselectBL() {

        List<SearchResultInfoDataSourceBean> searchResultInfoDataSourceBeanList = Lists.newArrayList();

        uiBean.setSearchResultInfo(searchResultInfoDataSourceBeanList);

        if (BizUtil.isBlank(uiBean.getSrchdskokno()) && BizUtil.isBlank(uiBean.getSrchsyono())
            && BizUtil.isBlank(uiBean.getSrchdskokyakunmkj()) && BizUtil.isBlank(uiBean.getSrchdskokyakunmkn())
            && uiBean.getSrchdskokyakuseiymd() == null && BizUtil.isBlank(uiBean.getSrchdskokyakuyno())) {

            throw new BizLogicException(MessageId.EMC1005);
        }

        if (!BizUtil.isBlank(uiBean.getSrchdskokno())) {

            if (!BizUtil.isBlank(uiBean.getSrchsyono())) {

                throw new BizLogicException(MessageId.EMC1001,
                    new Item[]{DDID_SRCHSYONOINFO_SRCHSYONO},
                    MessageUtil.getMessage(DDID_SRCHDSKOKNOINFO_SRCHDSKOKNO.getErrorResourceKey()),
                    MessageUtil.getMessage(DDID_SRCHSYONOINFO_SRCHSYONO.getErrorResourceKey()));

            }
            else if (!BizUtil.isBlank(uiBean.getSrchdskokyakunmkj()) ||
                !BizUtil.isBlank(uiBean.getSrchdskokyakunmkn()) ||
                uiBean.getSrchdskokyakuseiymd() != null ||
                !BizUtil.isBlank(uiBean.getSrchdskokyakuyno())) {

                throw new BizLogicException(MessageId.EMC1001,
                    new Item[]{DDID_KOKINFO_SRCHDSKOKYAKUNMKJ, DDID_KOKINFO_SRCHDSKOKYAKUNMKN,
                    DDID_KOKINFO_SRCHDSKOKYAKUSEIYMD, DDID_KOKINFO_SRCHDSKOKYAKUYNO},
                    MessageUtil.getMessage(DDID_SRCHDSKOKNOINFO_SRCHDSKOKNO.getErrorResourceKey()), KOK_INFO);
            }
        }
        else if (!BizUtil.isBlank(uiBean.getSrchsyono())) {

            if (!BizUtil.isBlank(uiBean.getSrchdskokyakunmkj()) ||
                !BizUtil.isBlank(uiBean.getSrchdskokyakunmkn()) ||
                uiBean.getSrchdskokyakuseiymd() != null ||
                !BizUtil.isBlank(uiBean.getSrchdskokyakuyno())) {

                throw new BizLogicException(MessageId.EMC1001,
                    new Item[]{DDID_KOKINFO_SRCHDSKOKYAKUNMKJ, DDID_KOKINFO_SRCHDSKOKYAKUNMKN,
                    DDID_KOKINFO_SRCHDSKOKYAKUSEIYMD, DDID_KOKINFO_SRCHDSKOKYAKUYNO},
                    MessageUtil.getMessage(DDID_SRCHSYONOINFO_SRCHSYONO.getErrorResourceKey()), KOK_INFO);
            }
        }

        if (!BizUtil.isBlank(uiBean.getSrchdskokno())) {

            MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri(uiBean.getSrchdskokno());

            if (dsKokyakuKanri != null) {

                MT_DsHonninKakuninCd dsHonninKakuninCd = dsKokyakuKanri.getDsHonninKakuninCd();

                List<MT_DsKokyakuKeiyaku> dsKokyakuKeiyaku = dsKokyakuKanri.getDsKokyakuKeiyakus();

                for (int n = 0; n < dsKokyakuKeiyaku.size(); n++) {

                    SearchResultInfoDataSourceBean searchResultInfoDataSourceBean = SWAKInjector
                        .getInstance(SearchResultInfoDataSourceBean.class);

                    searchResultInfoDataSourceBean.setDskokno(dsKokyakuKanri.getDskokno());

                    searchResultInfoDataSourceBean.setSyono(dsKokyakuKeiyaku.get(n).getSyono());

                    searchResultInfoDataSourceBean.setDskokyakunmkj(dsKokyakuKanri.getDskokyakunmkj());

                    searchResultInfoDataSourceBean.setDskokyakunmkn(dsKokyakuKanri.getDskokyakunmkn());

                    searchResultInfoDataSourceBean.setDskokyakuseiymd(dsKokyakuKanri.getDskokyakuseiymd());

                    searchResultInfoDataSourceBean.setDskokyakuyno(dsKokyakuKanri.getDskokyakuyno());

                    searchResultInfoDataSourceBean.setDskokyakujtkbn(dsKokyakuKanri.getDskokyakujtkbn());

                    if (!BizUtil.isBlank(dsHonninKakuninCd.getDshnnkakcd())) {

                        searchResultInfoDataSourceBean.setPasswordjtkbn(C_PasswordJtKbn.HON);
                    }
                    else if (!BizUtil.isBlank(dsHonninKakuninCd.getDskrhnnkakcd())) {

                        searchResultInfoDataSourceBean.setPasswordjtkbn(C_PasswordJtKbn.KARI);
                    }
                    else {

                        searchResultInfoDataSourceBean.setPasswordjtkbn(C_PasswordJtKbn.BLANK);
                    }

                    searchResultInfoDataSourceBeanList.add(searchResultInfoDataSourceBean);
                }
            }
        }
        else if (!BizUtil.isBlank(uiBean.getSrchsyono())) {

            List<MT_DsKokyakuKanri> dsKokyakuKanri = directDomManager.getDsKokyakuKanrisBySyono(uiBean.getSrchsyono());

            dsKokyakuKanri =
                MT_DsKokyakuKanriDetacher.detachDsKokyakuKeiyakuDsHonninKakuninCdDsLoginKanritouched(dsKokyakuKanri);

            SortMT_DsKokyakuKanri sortMtDsKokyakuKanri = SWAKInjector.getInstance(SortMT_DsKokyakuKanri.class);

            dsKokyakuKanri = sortMtDsKokyakuKanri.OrderMT_DsKokyakuKanriByPkAsc(dsKokyakuKanri);

            for (int n = 0; n < dsKokyakuKanri.size(); n++) {

                MT_DsKokyakuKeiyaku dsKokyakuKeiyaku = dsKokyakuKanri.get(n)
                    .getDsKokyakuKeiyakuBySyono(uiBean.getSrchsyono());

                MT_DsHonninKakuninCd dsHonninKakuninCd = dsKokyakuKanri.get(n).getDsHonninKakuninCd();

                SearchResultInfoDataSourceBean searchResultInfoDataSourceBean = SWAKInjector
                    .getInstance(SearchResultInfoDataSourceBean.class);

                searchResultInfoDataSourceBean.setDskokno(dsKokyakuKanri.get(n).getDskokno());

                searchResultInfoDataSourceBean.setSyono(dsKokyakuKeiyaku.getSyono());

                searchResultInfoDataSourceBean.setDskokyakunmkj(dsKokyakuKanri.get(n).getDskokyakunmkj());

                searchResultInfoDataSourceBean.setDskokyakunmkn(dsKokyakuKanri.get(n).getDskokyakunmkn());

                searchResultInfoDataSourceBean.setDskokyakuseiymd(dsKokyakuKanri.get(n).getDskokyakuseiymd());

                searchResultInfoDataSourceBean.setDskokyakuyno(dsKokyakuKanri.get(n).getDskokyakuyno());

                searchResultInfoDataSourceBean.setDskokyakujtkbn(dsKokyakuKanri.get(n).getDskokyakujtkbn());

                if (!BizUtil.isBlank(dsHonninKakuninCd.getDshnnkakcd())) {

                    searchResultInfoDataSourceBean.setPasswordjtkbn(C_PasswordJtKbn.HON);
                }
                else if (!BizUtil.isBlank(dsHonninKakuninCd.getDskrhnnkakcd())) {

                    searchResultInfoDataSourceBean.setPasswordjtkbn(C_PasswordJtKbn.KARI);
                }
                else {

                    searchResultInfoDataSourceBean.setPasswordjtkbn(C_PasswordJtKbn.BLANK);
                }

                searchResultInfoDataSourceBeanList.add(searchResultInfoDataSourceBean);
            }
        }
        else {

            List<DsKokyakuKanrisByItemsBean> dsKokyakuInfoList = directDomManager.getDsKokyakuKanrisByItems(
                uiBean.getSrchdskokyakunmkn(), uiBean.getSrchdskokyakunmkj(),
                uiBean.getSrchdskokyakuseiymd(), uiBean.getSrchdskokyakuyno());

            for (int n = 0; n < dsKokyakuInfoList.size(); n++) {
                MT_DsKokyakuKanri dsKokyakuKanri = dsKokyakuInfoList.get(n).getMT_DsKokyakuKanri();

                MT_DsHonninKakuninCd dsHonninKakuninCd = dsKokyakuInfoList.get(n).getMT_DsHonninKakuninCd();

                MT_DsKokyakuKeiyaku dsKokyakuKeiyaku = dsKokyakuInfoList.get(n).getMT_DsKokyakuKeiyaku();

                SearchResultInfoDataSourceBean searchResultInfoDataSourceBean =
                    SWAKInjector.getInstance(SearchResultInfoDataSourceBean.class);

                searchResultInfoDataSourceBean.setDskokno(dsKokyakuKanri.getDskokno());

                searchResultInfoDataSourceBean.setSyono(dsKokyakuKeiyaku.getSyono());

                searchResultInfoDataSourceBean.setDskokyakunmkj(dsKokyakuKanri.getDskokyakunmkj());

                searchResultInfoDataSourceBean.setDskokyakunmkn(dsKokyakuKanri.getDskokyakunmkn());

                searchResultInfoDataSourceBean.setDskokyakuseiymd(dsKokyakuKanri.getDskokyakuseiymd());

                searchResultInfoDataSourceBean.setDskokyakuyno(dsKokyakuKanri.getDskokyakuyno());

                searchResultInfoDataSourceBean.setDskokyakujtkbn(dsKokyakuKanri.getDskokyakujtkbn());

                if (!BizUtil.isBlank(dsHonninKakuninCd.getDshnnkakcd())) {

                    searchResultInfoDataSourceBean.setPasswordjtkbn(C_PasswordJtKbn.HON);
                }
                else if (!BizUtil.isBlank(dsHonninKakuninCd.getDskrhnnkakcd())) {

                    searchResultInfoDataSourceBean.setPasswordjtkbn(C_PasswordJtKbn.KARI);
                }
                else {

                    searchResultInfoDataSourceBean.setPasswordjtkbn(C_PasswordJtKbn.BLANK);
                }

                searchResultInfoDataSourceBeanList.add(searchResultInfoDataSourceBean);
            }
        }

        if (searchResultInfoDataSourceBeanList.size() == 0) {

            messageManager.addMessageId(MessageId.IAC0023);
        }

        int searchResultMaxCnt = YuyuBizConfig.getInstance().getSearchResultMaxCnt();

        if (searchResultInfoDataSourceBeanList.size() > searchResultMaxCnt) {

            messageManager.addMessageId(MessageId.IBA0019, String.valueOf(searchResultMaxCnt));

            for (int n = searchResultInfoDataSourceBeanList.size(); n > searchResultMaxCnt; n--) {

                searchResultInfoDataSourceBeanList.remove(searchResultInfoDataSourceBeanList.get(n - 1));
            }
        }

        uiBean.setSearchResultInfo(searchResultInfoDataSourceBeanList);
    }

    void pushDskoknoLink() {

        setGamenData(uiBean.getSearchResultInfoDataSource().getSelectedBean().getDskokno()
            ,uiBean.getSearchResultInfoDataSource().getSelectedBean().getSyono());

        setInputGamenMessageSettei();

        if (uiBean.getPageNo() == PAGENO_INPUTKEYSELECT) {

            uiBean.setSenimotoKbnInput(FORWARDNAME_INPUTKEYSELECT);
        }
        else {

            uiBean.setSenimotoKbnInput(FORWARDNAME_SEIBITSSEARCH);
        }
    }

    void pushClearbtnbyinputkeyselectBL() {

        List<SearchResultInfoDataSourceBean> searchResultInfoDataSourceBeanList = Lists.newArrayList();

        uiBean.setSearchResultInfo(searchResultInfoDataSourceBeanList);

        uiBean.setSrchdskokno("");

        uiBean.setSrchsyono("");

        uiBean.setSrchdskokyakunmkj("");

        uiBean.setSrchdskokyakunmkn("");

        uiBean.setSrchdskokyakuseiymd(null);

        uiBean.setSrchdskokyakuyno("");
    }

    void pushSearchbtnbyseibitssearchBL() {

        List<SearchResultInfoDataSourceBean> searchResultInfoDataSourceBeanList = Lists.newArrayList();

        uiBean.setSearchResultInfo(searchResultInfoDataSourceBeanList);

        if (BizDateUtil.compareYmd(uiBean.getSyoriYmdFrom(), uiBean.getSyoriYmdTo()) == BizDateUtil.COMPARE_GREATER) {

            throw new BizLogicException(MessageId.EAC0005,
                new Item[]{DDID_SEARCHJYOUKENINFO_SYORIYMDFROM, DDID_SEARCHJYOUKENINFO_SYORIYMDTO});
        }

        if (BizDateUtil.compareYmd(uiBean.getSyoriYmdFrom(), BizDate.getSysDate()) == BizDateUtil.COMPARE_GREATER) {

            throw new BizLogicException(MessageId.EMA1007, DDID_SEARCHJYOUKENINFO_SYORIYMDFROM);
        }



        List<KykKihonsBySyoriYmdFromSyoriYmdToDskykmukouhyjBean> meihenInfoBeanList = hozenDomManager
            .getKykKihonsBySyoriYmdFromSyoriYmdToDskykmukouhyj(uiBean.getSyoriYmdFrom(), uiBean.getSyoriYmdTo());

        for (int n = 0; n < meihenInfoBeanList.size(); n++) {

            SearchResultInfoDataSourceBean searchResultInfoDataSourceBean =
                SWAKInjector.getInstance(SearchResultInfoDataSourceBean.class);

            BizDate syoriYmd = null;

            KykKihonsBySyoriYmdFromSyoriYmdToDskykmukouhyjBean meihenInfoBean = meihenInfoBeanList.get(n);

            if ((BizDateUtil.compareYmd(uiBean.getSyoriYmdFrom(), meihenInfoBean.getLastkyknmseiymdhenkouymd())
                == BizDateUtil.COMPARE_LESSER ||
                BizDateUtil.compareYmd(uiBean.getSyoriYmdFrom(), meihenInfoBean.getLastkyknmseiymdhenkouymd())
                == BizDateUtil.COMPARE_EQUAL) &&
                (BizDateUtil.compareYmd(uiBean.getSyoriYmdTo(), meihenInfoBean.getLastkyknmseiymdhenkouymd())
                    == BizDateUtil.COMPARE_GREATER ||
                    BizDateUtil.compareYmd(uiBean.getSyoriYmdTo(), meihenInfoBean.getLastkyknmseiymdhenkouymd())
                    == BizDateUtil.COMPARE_EQUAL) &&
                    (BizDateUtil.compareYmd(uiBean.getSyoriYmdFrom(), meihenInfoBean.getLastkyknmkanakjteiymd())
                        == BizDateUtil.COMPARE_LESSER ||
                        BizDateUtil.compareYmd(uiBean.getSyoriYmdFrom(), meihenInfoBean.getLastkyknmkanakjteiymd())
                        == BizDateUtil.COMPARE_EQUAL) &&
                        (BizDateUtil.compareYmd(uiBean.getSyoriYmdTo(), meihenInfoBean.getLastkyknmkanakjteiymd())
                            == BizDateUtil.COMPARE_GREATER ||
                            BizDateUtil.compareYmd(uiBean.getSyoriYmdTo(), meihenInfoBean.getLastkyknmkanakjteiymd())
                            == BizDateUtil.COMPARE_EQUAL)) {

                if (BizDateUtil.compareYmd(meihenInfoBean.getLastkyknmseiymdhenkouymd(),
                    meihenInfoBean.getLastkyknmkanakjteiymd()) == BizDateUtil.COMPARE_GREATER ||
                    BizDateUtil.compareYmd(meihenInfoBean.getLastkyknmseiymdhenkouymd(),
                        meihenInfoBean.getLastkyknmkanakjteiymd()) == BizDateUtil.COMPARE_EQUAL) {

                    syoriYmd = meihenInfoBean.getLastkyknmseiymdhenkouymd();
                } else {

                    syoriYmd = meihenInfoBean.getLastkyknmkanakjteiymd();
                }
            }
            else if ((BizDateUtil.compareYmd(uiBean.getSyoriYmdFrom(), meihenInfoBean.getLastkyknmseiymdhenkouymd())
                == BizDateUtil.COMPARE_LESSER ||
                BizDateUtil.compareYmd(uiBean.getSyoriYmdFrom(), meihenInfoBean.getLastkyknmseiymdhenkouymd())
                == BizDateUtil.COMPARE_EQUAL) &&
                (BizDateUtil.compareYmd(uiBean.getSyoriYmdTo(), meihenInfoBean.getLastkyknmseiymdhenkouymd())
                    == BizDateUtil.COMPARE_GREATER ||
                    BizDateUtil.compareYmd(uiBean.getSyoriYmdTo(), meihenInfoBean.getLastkyknmseiymdhenkouymd())
                    == BizDateUtil.COMPARE_EQUAL)) {

                syoriYmd = meihenInfoBean.getLastkyknmseiymdhenkouymd();
            }
            else if ((BizDateUtil.compareYmd(uiBean.getSyoriYmdFrom(), meihenInfoBean.getLastkyknmkanakjteiymd())
                == BizDateUtil.COMPARE_LESSER ||
                BizDateUtil.compareYmd(uiBean.getSyoriYmdFrom(), meihenInfoBean.getLastkyknmkanakjteiymd())
                == BizDateUtil.COMPARE_EQUAL) &&
                (BizDateUtil.compareYmd(uiBean.getSyoriYmdTo(), meihenInfoBean.getLastkyknmkanakjteiymd())
                    == BizDateUtil.COMPARE_GREATER ||
                    BizDateUtil.compareYmd(uiBean.getSyoriYmdTo(), meihenInfoBean.getLastkyknmkanakjteiymd())
                    == BizDateUtil.COMPARE_EQUAL)) {

                syoriYmd = meihenInfoBean.getLastkyknmkanakjteiymd();
            }

            searchResultInfoDataSourceBean.setDskokno(meihenInfoBean.getDskokno());

            searchResultInfoDataSourceBean.setSyono(meihenInfoBean.getSyono());

            searchResultInfoDataSourceBean.setDskokyakunmkj(meihenInfoBean.getDskokyakunmkj());

            searchResultInfoDataSourceBean.setDskokyakunmkn(meihenInfoBean.getDskokyakunmkn());

            searchResultInfoDataSourceBean.setDskokyakuseiymd(meihenInfoBean.getDskokyakuseiymd());

            searchResultInfoDataSourceBean.setDskokyakuyno(meihenInfoBean.getDskokyakuyno());

            searchResultInfoDataSourceBean.setDskokyakujtkbn(meihenInfoBean.getDskokyakujtkbn());

            searchResultInfoDataSourceBean.setSeibiriyuukbn(C_SeibiRiyuuKbn.MEIGI_HENKOU);

            searchResultInfoDataSourceBean.setSyoriYmd(syoriYmd);

            if (!BizUtil.isBlank(meihenInfoBean.getDshnnkakcd())) {

                searchResultInfoDataSourceBean.setPasswordjtkbn(C_PasswordJtKbn.HON);
            }
            else if (!BizUtil.isBlank(meihenInfoBean.getDskrhnnkakcd())) {

                searchResultInfoDataSourceBean.setPasswordjtkbn(C_PasswordJtKbn.KARI);
            }
            else {

                searchResultInfoDataSourceBean.setPasswordjtkbn(C_PasswordJtKbn.BLANK);
            }

            if (meihenInfoBean.getKyknmkn().equals(meihenInfoBean.getDskokyakunmkn())
                && meihenInfoBean.getKyknmkj().equals(meihenInfoBean.getDskokyakunmkj())
                && (BizDateUtil.compareYmd(meihenInfoBean.getKykseiymd(), meihenInfoBean.getDskokyakuseiymd())
                    == BizDateUtil.COMPARE_EQUAL)) {

                searchResultInfoDataSourceBean.setSyorizumiflg(C_Syorizumiflg.SYORIZUMI);
            }
            else {

                searchResultInfoDataSourceBean.setSyorizumiflg(C_Syorizumiflg.MISYORI);
            }

            searchResultInfoDataSourceBeanList.add(searchResultInfoDataSourceBean);

        }


        List<KykKihonsByLastjyuuhenymdSyoriYmdFromSyoriYmdToDskykmukouhyjBean> jyuuhenInfoBeanList = hozenDomManager.
            getKykKihonsByLastjyuuhenymdSyoriYmdFromSyoriYmdToDskykmukouhyj(
                uiBean.getSyoriYmdFrom(), uiBean.getSyoriYmdTo());

        for (int n = 0; n < jyuuhenInfoBeanList.size(); n++) {

            SearchResultInfoDataSourceBean searchResultInfoDataSourceBean =
                SWAKInjector.getInstance(SearchResultInfoDataSourceBean.class);

            KykKihonsByLastjyuuhenymdSyoriYmdFromSyoriYmdToDskykmukouhyjBean
            jyuuhenInfoBean = jyuuhenInfoBeanList.get(n);

            searchResultInfoDataSourceBean.setDskokno(jyuuhenInfoBean.getDskokno());

            searchResultInfoDataSourceBean.setSyono(jyuuhenInfoBean.getSyono());

            searchResultInfoDataSourceBean.setDskokyakunmkj(jyuuhenInfoBean.getDskokyakunmkj());

            searchResultInfoDataSourceBean.setDskokyakunmkn(jyuuhenInfoBean.getDskokyakunmkn());

            searchResultInfoDataSourceBean.setDskokyakuseiymd(jyuuhenInfoBean.getDskokyakuseiymd());

            searchResultInfoDataSourceBean.setDskokyakuyno(jyuuhenInfoBean.getDskokyakuyno());

            searchResultInfoDataSourceBean.setDskokyakujtkbn(jyuuhenInfoBean.getDskokyakujtkbn());

            searchResultInfoDataSourceBean.setSeibiriyuukbn(C_SeibiRiyuuKbn.JYUUSYO_HENKOU);

            searchResultInfoDataSourceBean.setSyoriYmd(jyuuhenInfoBean.getLasttsinynohenkouymd());

            if (!BizUtil.isBlank(jyuuhenInfoBean.getDshnnkakcd())) {

                searchResultInfoDataSourceBean.setPasswordjtkbn(C_PasswordJtKbn.HON);
            }
            else if (!BizUtil.isBlank(jyuuhenInfoBean.getDskrhnnkakcd())) {

                searchResultInfoDataSourceBean.setPasswordjtkbn(C_PasswordJtKbn.KARI);
            }
            else {

                searchResultInfoDataSourceBean.setPasswordjtkbn(C_PasswordJtKbn.BLANK);
            }

            if (jyuuhenInfoBean.getTsinyno().equals(jyuuhenInfoBean.getDskokyakuyno())) {

                searchResultInfoDataSourceBean.setSyorizumiflg(C_Syorizumiflg.SYORIZUMI);
            }
            else {

                searchResultInfoDataSourceBean.setSyorizumiflg(C_Syorizumiflg.MISYORI);
            }

            searchResultInfoDataSourceBeanList.add(searchResultInfoDataSourceBean);

        }

        if (searchResultInfoDataSourceBeanList.size() == 0) {

            messageManager.addMessageId(MessageId.IAC0023);
        }

        SearchResultInfoDataSourceBeanSortComparator searchResultInfoDataSourceBeanSortComparator =
            SWAKInjector.getInstance(SearchResultInfoDataSourceBeanSortComparator.class);

        Ordering<SearchResultInfoDataSourceBean> ordering = Ordering.from(searchResultInfoDataSourceBeanSortComparator);

        searchResultInfoDataSourceBeanList = ordering.sortedCopy(searchResultInfoDataSourceBeanList);

        uiBean.setSearchResultInfo(searchResultInfoDataSourceBeanList);

    }

    void pushClearbtnbyseibitssearchBL() {

        List<SearchResultInfoDataSourceBean> searchResultInfoDataSourceBeanList = Lists.newArrayList();

        uiBean.setSearchResultInfo(searchResultInfoDataSourceBeanList);

        uiBean.setSyoriYmdFrom(BizDate.getSysDate().addBusinessDays(INIT_SYORIYMD_FROM));

        uiBean.setSyoriYmdTo(BizDate.getSysDate().addBusinessDays(INIT_SYORIYMD_TO));
    }

    void pushSearchbtnbytktitrhkkzBL() {

        List<SrchRsltKzInfoDataSourceBean> srchRsltKzInfoDataSourceBeanList = Lists.newArrayList();

        uiBean.setSrchRsltKzInfo(srchRsltKzInfoDataSourceBeanList);

        int searchResultMaxCnt = YuyuBizConfig.getInstance().getSearchResultMaxCnt();

        if (BizUtil.isBlank(uiBean.getSrchtktitrhkkzbankcd()) && BizUtil.isBlank(uiBean.getSrchtktitrhkkzsitencd()) &&
            uiBean.getSrchhaisiymdfrom() == null && uiBean.getSrchhaisiymdto() == null) {

            throw new BizLogicException(MessageId.EMC1005);
        }

        if (BizUtil.isBlank(uiBean.getSrchtktitrhkkzbankcd()) && !BizUtil.isBlank(uiBean.getSrchtktitrhkkzsitencd())) {

            throw new BizLogicException(MessageId.EAC0027,
                  new Item[]{DDID_SEARCHJYOUKENKOUZAINFO_SRCHTKTITRHKKZSITENCD,
                  DDID_SEARCHJYOUKENKOUZAINFO_SRCHTKTITRHKKZBANKCD});
        }

        if (uiBean.getSrchhaisiymdfrom() != null && uiBean.getSrchhaisiymdto() != null && BizDateUtil.compareYmd(
            uiBean.getSrchhaisiymdfrom(), uiBean.getSrchhaisiymdto()) == BizDateUtil.COMPARE_GREATER) {

            throw new BizLogicException(MessageId.EAC0005,
                  new Item[]{DDID_SEARCHJYOUKENKOUZAINFO_SRCHHAISIYMDFROM,
                  DDID_SEARCHJYOUKENKOUZAINFO_SRCHHAISIYMDTO});
        }


        BizDate haisiYmdFrom = null;
        BizDate haisiYmdTo = null;

        if (uiBean.getSrchhaisiymdfrom() != null || uiBean.getSrchhaisiymdto() != null) {

            if (uiBean.getSrchhaisiymdfrom() == null) {

                haisiYmdFrom = HAISI_YMD_FROM;
            }
            else {

                haisiYmdFrom = uiBean.getSrchhaisiymdfrom();
            }
            if (uiBean.getSrchhaisiymdto() == null) {

                haisiYmdTo = HAISI_YMD_TO;
            }
            else {

                haisiYmdTo = uiBean.getSrchhaisiymdto();
            }
        }

        List<TktiTrhkyuKzInfoBean> tktiTrhkyuKzInfoBeanList =
             dsKokyakuSeibiDao.getTktiTrhkyuKzInfoBeanByBankcdSitencdHaisiymd(
                uiBean.getSrchtktitrhkkzbankcd(),
                uiBean.getSrchtktitrhkkzsitencd(),
                haisiYmdFrom,
                haisiYmdTo,
                searchResultMaxCnt + 1);

        List<SrchRsltKzInfoDataSourceBean> srchRsltKzInfoBeanList = Lists.newArrayList();

        for (TktiTrhkyuKzInfoBean tktiTrhkyuKzInfoBean : tktiTrhkyuKzInfoBeanList) {

            SrchRsltKzInfoDataSourceBean srchRsltKzInfoDataSourceBean =
            SWAKInjector.getInstance(SrchRsltKzInfoDataSourceBean.class);
            GetBankSitenNm getBankSitenNm = SWAKInjector.getInstance(GetBankSitenNm.class);
            String banknmkj = "";
            String sitennmkj = "";
            BizDate sinsetuymd = null;
            BizDate haisiymd = null;
            String hyojikzmgnmkn = "";
            int hyoujiyuusendo = 0;

            if(YUUTYO_BANK.equals(tktiTrhkyuKzInfoBean.getBankcd())) {

                getBankSitenNm.exec(YUUTYO_BANK, tktiTrhkyuKzInfoBean.getSitencd());

                banknmkj = getBankSitenNm.getBankNmKj();
                sitennmkj = getBankSitenNm.getSitenNmKj();

            }
            else if (!BizUtil.isBlank(tktiTrhkyuKzInfoBean.getBanknmkj())) {

                banknmkj = tktiTrhkyuKzInfoBean.getBanknmkj();
                sitennmkj = tktiTrhkyuKzInfoBean.getSitennmkj();
                sinsetuymd = tktiTrhkyuKzInfoBean.getSinsetuymd();
                haisiymd = tktiTrhkyuKzInfoBean.getHaisiymd();
            }
            else {

                banknmkj = GINKOMASTA_INFO_NONE;
                sitennmkj = "";
            }

            if (C_Kzdou.DOUITU.eq(tktiTrhkyuKzInfoBean.getKzdou())) {

                hyojikzmgnmkn = C_Kzdou.DOUITU.getContent();
            }
            else {

                hyojikzmgnmkn = tktiTrhkyuKzInfoBean.getKzmeiginmkn();
            }

            if (BizUtil.isBlank(tktiTrhkyuKzInfoBean.getBanknmkj()) && !YUUTYO_BANK.equals(tktiTrhkyuKzInfoBean.getBankcd())) {

                hyoujiyuusendo = 1;
            }
            else {

                hyoujiyuusendo = 2;
            }


            srchRsltKzInfoDataSourceBean.setDispbankcd(tktiTrhkyuKzInfoBean.getBankcd());
            srchRsltKzInfoDataSourceBean.setDispsitencd(tktiTrhkyuKzInfoBean.getSitencd());
            srchRsltKzInfoDataSourceBean.setDispbanknmkj(banknmkj);
            srchRsltKzInfoDataSourceBean.setDispsitennmkj(sitennmkj);
            srchRsltKzInfoDataSourceBean.setSinsetuymd(sinsetuymd);
            srchRsltKzInfoDataSourceBean.setHaisiymd(haisiymd);
            srchRsltKzInfoDataSourceBean.setDispkouzano(tktiTrhkyuKzInfoBean.getKouzano());
            srchRsltKzInfoDataSourceBean.setDispkyknmkn(tktiTrhkyuKzInfoBean.getKyknmkn());
            srchRsltKzInfoDataSourceBean.setDispkzmeiginmkn(hyojikzmgnmkn);
            srchRsltKzInfoDataSourceBean.setDskokno(tktiTrhkyuKzInfoBean.getDskokno());
            srchRsltKzInfoDataSourceBean.setSyono(tktiTrhkyuKzInfoBean.getSyono());
            srchRsltKzInfoDataSourceBean.setHyoujiyuusendo(hyoujiyuusendo);

            srchRsltKzInfoBeanList.add(srchRsltKzInfoDataSourceBean);
        }

       if (tktiTrhkyuKzInfoBeanList.size() == 0) {

            messageManager.addMessageId(MessageId.IAC0023);

            return;
       }

       if (tktiTrhkyuKzInfoBeanList.size() > searchResultMaxCnt) {

            messageManager.addMessageId(MessageId.IBA0019, String.valueOf(searchResultMaxCnt));
            srchRsltKzInfoBeanList.remove(searchResultMaxCnt);
       }

        SrchRsltKzInfoDataSourceBeanSortComparator srchRsltKzInfoDataSourceBeanSortComparator =
            SWAKInjector.getInstance(SrchRsltKzInfoDataSourceBeanSortComparator.class);

        Ordering<SrchRsltKzInfoDataSourceBean> ordering = Ordering.from(srchRsltKzInfoDataSourceBeanSortComparator);

        srchRsltKzInfoBeanList = ordering.sortedCopy(srchRsltKzInfoBeanList);

        uiBean.setSrchRsltKzInfo(srchRsltKzInfoBeanList);
    }

    void pushClearbtnbytktitrhkkzBL() {

        List<SrchRsltKzInfoDataSourceBean> srchRsltKzInfoDataSourceBeanList = Lists.newArrayList();

        uiBean.setSrchRsltKzInfo(srchRsltKzInfoDataSourceBeanList);

        uiBean.setSrchtktitrhkkzbankcd("");
        uiBean.setSrchtktitrhkkzsitencd("");
        uiBean.setSrchhaisiymdfrom(null);
        uiBean.setSrchhaisiymdto(null);
    }

    void pushKakuninBtnBL() {

        if (C_DsKokyakuJtKbn.KAIYAKU.eq(uiBean.getDskokyakujtkbn()) ||
            C_DsKokyakuJtKbn.SEISA_SYOUMETU.eq(uiBean.getDskokyakujtkbn())) {
            errorMessageCollector.addMessage(MessageId.EMC1008,
                MessageUtil.getMessage(DDID_DSKOKYAKUJTINFO_DSKOKYAKUJTKBN.getErrorResourceKey()),
                uiBean.getDskokyakujtkbn().getContent());
        }

        if (BizUtil.isBlank(uiBean.getInputdskokyakunmkj())) {

            errorMessageCollector.addMessage(MessageId.EAC0042, DDID_DRCTSERVICEINFO1_INPUTDSKOKYAKUNMKJ);
        }

        boolean  checkMeigininNmKanjiFlg = CheckMeigininNmKanji.isCheckOK(uiBean.getInputdskokyakunmkj(), C_Kojinhjn.KOJIN);

        if (!checkMeigininNmKanjiFlg) {
            errorMessageCollector.addMessage(MessageId.EBC0002, DDID_DRCTSERVICEINFO1_INPUTDSKOKYAKUNMKJ);
        }

        if (BizUtil.isBlank(uiBean.getInputdskokyakunmkn())) {

            errorMessageCollector.addMessage(MessageId.EAC0042, DDID_DRCTSERVICEINFO1_INPUTDSKOKYAKUNMKN);
        }


        boolean checkMeigininNmKanaFlg = CheckMeigininNmKana.isCheckOK(uiBean.getInputdskokyakunmkn(), C_Kojinhjn.KOJIN);

        if (!checkMeigininNmKanaFlg) {

            errorMessageCollector.addMessage(MessageId.EBC0002, DDID_DRCTSERVICEINFO1_INPUTDSKOKYAKUNMKN);
        }

        DsKanyuuYoukenCheck dsKanyuuYoukenCheck = SWAKInjector.getInstance(DsKanyuuYoukenCheck.class);

        if (uiBean.getInputdskokyakuseiymd() == null) {

            errorMessageCollector.addMessage(MessageId.EAC0042, DDID_DRCTSERVICEINFO1_INPUTDSKOKYAKUSEIYMD);

        }else if (C_ErrorKbn.ERROR.eq(dsKanyuuYoukenCheck.checkDsKanyuuNenrei(uiBean.getInputdskokyakuseiymd()))) {

            errorMessageCollector.addMessage(MessageId.EMF1054, new Item[]{DDID_DRCTSERVICEINFO1_INPUTDSKOKYAKUSEIYMD}, MessageUtil.getMessage(MessageId.WMF1005));

        }

        if (BizUtil.isBlank(uiBean.getInputdskokyakuyno())) {

            errorMessageCollector.addMessage(MessageId.EAC0042, DDID_DRCTSERVICEINFO1_INPUTDSKOKYAKUYNO);
        }

        if (C_DsKanyuuKeiroKbn.BLNK.eq(uiBean.getInputdskanyuukeirokbn())) {

            errorMessageCollector.addMessage(MessageId.EAC0042, DDID_DSKOKYAKUJTINFO_INPUTDSKANYUUKEIROKBN);
        }

        if (C_DsKokyakuJtKbn.ITIJI_TEISI.eq(uiBean.getDskokyakujtkbn())) {

            if (C_DsTeisiRiyuuKbn.BLANK.eq(uiBean.getInputdsteisiriyuukbn())) {

                errorMessageCollector.addMessage(MessageId.EMC1002,
                    new Item[]{DDID_DSKOKYAKUJTINFO_INPUTDSTEISIRIYUUKBN}, MessageUtil.getMessage(MessageId.EMW1001));
            }

            if (C_DsTeisiRiyuuKbn.OMOUSIDE.eq(uiBean.getDsteisiriyuukbn()) ||
                C_DsTeisiRiyuuKbn.SONOTA.eq(uiBean.getDsteisiriyuukbn())) {

                if (!C_DsTeisiRiyuuKbn.OMOUSIDE.eq(uiBean.getInputdsteisiriyuukbn()) &&
                    !C_DsTeisiRiyuuKbn.SONOTA.eq(uiBean.getInputdsteisiriyuukbn()) &&
                    !C_DsTeisiRiyuuKbn.BLANK.eq(uiBean.getInputdsteisiriyuukbn())) {

                    errorMessageCollector.addMessage(MessageId.EMC1009,
                        new Item[]{DDID_DSKOKYAKUJTINFO_INPUTDSTEISIRIYUUKBN},
                        uiBean.getInputdsteisiriyuukbn().getContent());
                }
            }
        }
        else {
            if (!C_DsTeisiRiyuuKbn.BLANK.eq(uiBean.getInputdsteisiriyuukbn())) {

                errorMessageCollector.addMessage(MessageId.EMC1003,
                    new Item[]{DDID_DSKOKYAKUJTINFO_INPUTDSTEISIRIYUUKBN}, MessageUtil.getMessage(MessageId.EMW1001));
            }
        }

        if (C_DsKrHnnKakCdTtYhKbn.BLNK.eq(uiBean.getDskrhnnkakcdttyhkbn())) {

            if (!C_DsKrHnnKakCdTtYhKbn.BLNK.eq(uiBean.getInputdskrhnnkakcdttyhkbn())) {
                errorMessageCollector.addMessage(MessageId.EMF1007,DDID_KRPASSWORDINFO_INPUTDSKRHNNKAKCDTTYHKBN);
            }
        }

        if (!C_DsKrHnnKakCdTtYhKbn.BLNK.eq(uiBean.getDskrhnnkakcdttyhkbn())) {

            if (C_DsKrHnnKakCdTtYhKbn.BLNK.eq(uiBean.getInputdskrhnnkakcdttyhkbn())) {
                errorMessageCollector.addMessage(MessageId.EMF1008,DDID_KRPASSWORDINFO_INPUTDSKRHNNKAKCDTTYHKBN);
            }
        }

        if (BizUtil.isBlank(uiBean.getInputdsmailaddress())) {

            if (!C_DsMailSousinJyoutaiKbn.BLNK.eq(uiBean.getInputdsmailsousinjtkbn())) {

                errorMessageCollector.addMessage(MessageId.EMC1004,
                    new Item[]{DDID_DSMAILADDRESSINFO_INPUTDSMAILSOUSINJTKBN},MessageUtil.getMessage(MessageId.EMW1014));
            }
        }

        if (!BizUtil.isBlank(uiBean.getInputdsmailaddress())) {

            if (C_DsMailSousinJyoutaiKbn.BLNK.eq(uiBean.getInputdsmailsousinjtkbn())) {

                errorMessageCollector.addMessage(MessageId.EMC1002,
                    new Item[]{DDID_DSMAILADDRESSINFO_INPUTDSMAILSOUSINJTKBN},MessageUtil.getMessage(MessageId.EMW1015));
            }
        }

        if (C_DsMailSousinJyoutaiKbn.BLNK.eq(uiBean.getInputdsmailsousinjtkbn()) ||
            C_DsMailSousinJyoutaiKbn.YUUKOU.eq(uiBean.getInputdsmailsousinjtkbn())) {

            if (!C_DsMailSousinTeisiRiyuuKbn.BLNK.eq(uiBean.getInputdsmailsousintisrykbn())) {

                errorMessageCollector.addMessage(MessageId.EMC1003,
                    new Item[]{DDID_DSMAILADDRESSINFO_INPUTDSMAILSOUSINTISRYKBN},MessageUtil.getMessage(MessageId.EMW1016));
            }
        }

        if (C_DsMailSousinJyoutaiKbn.TEISI.eq(uiBean.getInputdsmailsousinjtkbn())) {
            if (C_DsMailSousinTeisiRiyuuKbn.BLNK.eq(uiBean.getInputdsmailsousintisrykbn())) {
                errorMessageCollector.addMessage(MessageId.EMC1002,
                    new Item[]{DDID_DSMAILADDRESSINFO_INPUTDSMAILSOUSINTISRYKBN},MessageUtil.getMessage(MessageId.EMW1016));
            }
        }

        if (!uiBean.getDsmailsousintisrykbn().eq(uiBean.getInputdsmailsousintisrykbn())) {
            if (!C_DsMailSousinTeisiRiyuuKbn.BLNK.eq(uiBean.getInputdsmailsousintisrykbn()) &&
                !C_DsMailSousinTeisiRiyuuKbn.OKYAKUSAMAYOUBOU.eq(uiBean.getInputdsmailsousintisrykbn())) {

                errorMessageCollector.addMessage(MessageId.EMC1009,
                    new Item[]{DDID_DSMAILADDRESSINFO_INPUTDSMAILSOUSINTISRYKBN},uiBean.getInputdsmailsousintisrykbn().getContent());
            }
        }

        if (C_DsKokyakuJtKbn.ITIJI_TEISI.eq(uiBean.getDskokyakujtkbn())) {

            if (C_DsTeisiRiyuuKbn.OMOUSIDE.eq(uiBean.getDsteisiriyuukbn()) ||
                C_DsTeisiRiyuuKbn.SONOTA.eq(uiBean.getDsteisiriyuukbn())) {

                if (C_DsMailSousinJyoutaiKbn.YUUKOU.eq(uiBean.getInputdsmailsousinjtkbn())) {

                    errorMessageCollector.addMessage(MessageId.EMC1011,
                        new Item[]{DDID_DSMAILADDRESSINFO_INPUTDSMAILSOUSINJTKBN},
                        MessageUtil.getMessage(DDID_DSKOKYAKUJTINFO_DSTEISIRIYUUKBN.getErrorResourceKey()),
                        uiBean.getDsteisiriyuukbn().getContent(),
                        C_DsMailSousinJyoutaiKbn.YUUKOU.getContent());
                }
            }
        }

        if (errorMessageCollector.exists()) {

            throw new BizLogicException(errorMessageCollector);
        }

        uiBean.setSenimotoKbnConfirm(KAKUNIN_BTN);

        uiBean.setKakunindskokyakunmkj(uiBean.getInputdskokyakunmkj());

        uiBean.setKakunindskokyakunmkn(uiBean.getInputdskokyakunmkn());

        uiBean.setKakunindskokyakuseiymd(uiBean.getInputdskokyakuseiymd());

        uiBean.setKakunindskokyakuyno(uiBean.getInputdskokyakuyno());

        uiBean.setKakunindskokyakujtkbn(uiBean.getDskokyakujtkbn());

        uiBean.setKakunindskokyakumukouymd(uiBean.getDskokyakumukouymd());

        uiBean.setKakunindskanyuukeirokbn(uiBean.getInputdskanyuukeirokbn());

        uiBean.setKakuninkrpasswordumukbn(uiBean.getKrpasswordumukbn());

        uiBean.setKakunindskrhnnkakcdsetkbn(uiBean.getDskrhnnkakcdsetkbn());

        uiBean.setKakunindskrhnnkakcdsetymd(uiBean.getDskrhnnkakcdsetymd());

        uiBean.setKakunindskrhnnkakcdykymd(uiBean.getDskrhnnkakcdyuukouymd());

        uiBean.setKakuninhonpasswordumukbn(uiBean.getHonpasswordumukbn());

        uiBean.setKakunindshnnkakcdsetymd(uiBean.getDshnnkakcdsetymd());

        uiBean.setKakunindshnnkakcderrkaisuu(uiBean.getDshnnkakcderrorkaisuu());

        uiBean.setKakunindskoknmerrkaisuu(uiBean.getDskokyakunmerrorkaisuu());

        uiBean.setKakunindskokseiymderrkaisuu(uiBean.getDskokyakuseiymderrorkaisuu());

        uiBean.setKakunindskoktelnoerrkaisuu(uiBean.getDskokyakutelnoerrorkaisuu());

        uiBean.setKakunindsmailaddress(uiBean.getInputdsmailaddress());

        uiBean.setKakunindsmailsousinjtkbn(uiBean.getInputdsmailsousinjtkbn());

        uiBean.setKakunindsmailsousintisrykbn(uiBean.getInputdsmailsousintisrykbn());

        uiBean.setKakuninseisahuyouhyj(uiBean.getInputseisahuyouhyj());

        if (C_DsKokyakuJtKbn.YUUKOU.eq(uiBean.getDskokyakujtkbn()) ||
            (C_DsKokyakuJtKbn.ITIJI_TEISI.eq(uiBean.getDskokyakujtkbn()) &&
                (C_DsTeisiRiyuuKbn.OMOUSIDE.eq(uiBean.getDsteisiriyuukbn()) ||
                    C_DsTeisiRiyuuKbn.SONOTA.eq(uiBean.getDsteisiriyuukbn())))) {

            uiBean.setKakunindsteisiriyuukbn(uiBean.getInputdsteisiriyuukbn());
        }
        else {
            uiBean.setKakunindsteisiriyuukbn(uiBean.getDsteisiriyuukbn());
        }

        if (!uiBean.getDskrhnnkakcdttyhkbn().eq(uiBean.getInputdskrhnnkakcdttyhkbn())) {
            uiBean.setKakunindskrhnnkakcdttjyymd(BizDate.getSysDate());
        }
        else {
            uiBean.setKakunindskrhnnkakcdttjyymd(uiBean.getDskrhnnkakcdttshjyhsymd());
        }

        if (C_DsTeisiRiyuuKbn.PASSWORD_MITOUROKU.eq(uiBean.getDsteisiriyuukbn())) {
            uiBean.setKakunindskrhnnkakcdttyhkbn(uiBean.getInputdskrhnnkakcdttyhkbn());
        }
        else {
            uiBean.setKakunindskrhnnkakcdttyhkbn(uiBean.getDskrhnnkakcdttyhkbn());
        }

        if (!uiBean.getDsmailaddress().equals(uiBean.getInputdsmailaddress()) ||
            !uiBean.getDsmailsousinjyoutaikbn().eq(uiBean.getInputdsmailsousinjtkbn()) ||
            !uiBean.getDsmailsousintisrykbn().eq(uiBean.getInputdsmailsousintisrykbn())) {

            String dskousinymdtime = BizDate.getSysDateTimeMilli();

            uiBean.setKakunindskousinymdtime(editDateYmdHms(dskousinymdtime));

            uiBean.setUpdatedskousinymdtimemillihozi(dskousinymdtime);
        }
        else {

            uiBean.setKakunindskousinymdtime(uiBean.getDispdskousinymdtime());

            uiBean.setUpdatedskousinymdtimemillihozi(uiBean.getBeforedskousinymdtimemillihozi());
        }

        messageManager.addConversationMessageId(KOKSEIBI_CONFIRM,MessageId.QMA1001);

        if (!uiBean.getDskrhnnkakcdttyhkbn().eq(uiBean.getInputdskrhnnkakcdttyhkbn()) &&
            C_DsKrHnnKakCdTtYhKbn.YOU.eq(uiBean.getInputdskrhnnkakcdttyhkbn())) {

            messageManager.addConversationMessageId(KOKSEIBI_CONFIRM,MessageId.QMA1008,C_DsKrHnnKakCdTtYhKbn.YOU.getContent());

            uiBean.setKrpasswortuutihanteiFlg(true);
        }
        else {
            uiBean.setKrpasswortuutihanteiFlg(false);
        }

        if(! uiBean.getInputdskokyakunmkj().equals(uiBean.getKyknmkj()) ||
           ! uiBean.getInputdskokyakunmkn().equals(uiBean.getKyknmkn()) ||
           ! uiBean.getInputdskokyakuseiymd().equals(uiBean.getKykseiymd()) ||
           ! uiBean.getInputdskokyakuyno().equals(uiBean.getTsinyno())) {

            messageManager.addConversationMessageId(KOKSEIBI_CONFIRM, MessageId.WMF1004);

        }

        messageManager.removeConversationMessage(KOKSEIBI_INPUTCONTENTS);

        if (C_ErrorKbn.ERROR.eq(dsKanyuuYoukenCheck.checkDsKanyuuNenrei(uiBean.getKykseiymd()))) {

            messageManager.addConversationMessageId(KOKSEIBI_CONFIRM, MessageId.WMF1003);
        }

    }

    void pushSyonoLink() {

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(
            uiBean.getDskokkykInfoDataSource().getSelectedBean().getSyono());

        kykKihon = IT_KykKihonDetacher.detachKykSyatouched(kykKihon);

        IT_KykSya kykSya = kykKihon.getKykSya();

        uiBean.setKykbtdispsyono(uiBean.getDskokkykInfoDataSource().getSelectedBean().getSyono());
        uiBean.setKykbtdispdskokno(uiBean.getDskokno());
        uiBean.setKykbtdispsyouhnnm(uiBean.getDskokkykInfoDataSource().getSelectedBean().getSyusyouhnnm());
        uiBean.setKykbtdispkyknmkj(kykSya.getKyknmkj());
        uiBean.setKykbtdispkyknmkn(kykSya.getKyknmkn());
        uiBean.setKykbtdispkykseiymd(kykSya.getKykseiymd());

        MT_DsKokyakuKanri dsKokyakuKanriHctl = uiBean.getDsKokyakuKanriHctl();

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku = dsKokyakuKanriHctl.getDsKokyakuKeiyakuBySyono(
            uiBean.getDskokkykInfoDataSource().getSelectedBean().getSyono());

        MT_DsTorihikiServiceKanri dsTorihikiServiceKanri = dsKokyakuKeiyaku.getDsTorihikiServiceKanri();

        if (dsTorihikiServiceKanri != null) {

            MT_DsSoukinyouKouza dsSoukinyouKouza = dsTorihikiServiceKanri.getDsSoukinyouKouzas().get(0);

            MT_DsTorihikiyouAnsyono dsTorihikiyouAnsyono = dsTorihikiServiceKanri.getDsTorihikiyouAnsyono();

            String banknm = "";
            String sitennm = "";
            BzGetBankData bzGetBankData = SWAKInjector.getInstance(BzGetBankData.class);

            BzGetBankDataBean bzGetBankDataBean = bzGetBankData.exec(dsSoukinyouKouza.getBankcd(),
                dsSoukinyouKouza.getSitencd());

            if (C_BankmasterUmuKbn.ARI.eq(bzGetBankDataBean.getBankmasterUmuKbn())) {

                banknm = bzGetBankDataBean.getBankNmKj();
                sitennm = bzGetBankDataBean.getSitenNmKj();
            }

            uiBean.setDstrhkserviceriyoujkkbn(dsTorihikiServiceKanri.getDstrhkserviceriyoujkkbn());
            uiBean.setDstrhkserviceteisiriyuukbn(dsTorihikiServiceKanri.getDstrhkserviceteisiriyuukbn());
            uiBean.setDstrhkservicekanyukeirokbn(dsTorihikiServiceKanri.getDstrhkservicekanyukeirokbn());
            uiBean.setKzsyuruikbn(dsSoukinyouKouza.getKzsyuruikbn());
            uiBean.setBankcd(dsSoukinyouKouza.getBankcd());
            uiBean.setBanknmkj(banknm);
            uiBean.setSitencd(dsSoukinyouKouza.getSitencd());
            uiBean.setSitennmkj(sitennm);
            uiBean.setYokinkbn(dsSoukinyouKouza.getYokinkbn());
            uiBean.setKouzano(dsSoukinyouKouza.getKouzano());
            uiBean.setKzdoukbn(dsSoukinyouKouza.getKzdoukbn());
            uiBean.setTktrhkansyonoerrorkaisuu(dsTorihikiyouAnsyono.getTktrhkansyonoerrorkaisuu());
            uiBean.setTokuteitrhkansyonosetymd(dsTorihikiyouAnsyono.getSetymd());
            uiBean.setTrhkservicetourokuumuFlg(C_UmuKbn.ARI);

            if (C_Kzdou.DOUITU.eq(dsSoukinyouKouza.getKzdoukbn())) {
                uiBean.setKzmeiginmkn(uiBean.getKyknmkn());
            }
            else {
                uiBean.setKzmeiginmkn(dsSoukinyouKouza.getKzmeiginmkn());
            }

            if (!BizUtil.isBlank(dsTorihikiyouAnsyono.getTokuteitrhkansyono())) {
                uiBean.setDisptokuteitrhkansyono("****");
            }
            else {
                uiBean.setDisptokuteitrhkansyono("");
            }
        }
        else {
            uiBean.setTrhkservicetourokuumuFlg(C_UmuKbn.NONE);
        }

        setKykbtInputGamenMessageSettei();

        messageManager.removeConversationMessage(KOKSEIBI_INPUTCONTENTS);
    }

    void pushAccountlockkaijyobtnBL() {

        uiBean.setSenimotoKbnConfirm(ACCOUNT_LOCK_KAIJYO_BTN);

        setMpaccountjtHenkouGamenSettei();


        boolean accountlockFlg = false;
        if (C_DsKokyakuJtKbn.ITIJI_TEISI.eq(uiBean.getDskokyakujtkbn()) &&
            C_DsTeisiRiyuuKbn.LOCK_OUT.eq(uiBean.getDsteisiriyuukbn())) {

            accountlockFlg = true;

            messageManager.addConversationMessageId(KOKSEIBI_CONFIRM,MessageId.QMA1002);
        }

        else {

            messageManager.addConversationMessageId(KOKSEIBI_CONFIRM,MessageId.QMA1009);
        }

        uiBean.setAccountlockFlg(accountlockFlg);

        messageManager.removeConversationMessage(KOKSEIBI_INPUTCONTENTS);
    }

    void pushServiceteisibtnBL() {

        if (!C_DsTeisiRiyuuKbn.OMOUSIDE.eq(uiBean.getInputdsteisiriyuukbn()) &&
            !C_DsTeisiRiyuuKbn.SONOTA.eq(uiBean.getInputdsteisiriyuukbn())) {

            throw new BizLogicException(MessageId.EMC1010,
                new Item[] {DDID_DSKOKYAKUJTINFO_INPUTDSTEISIRIYUUKBN},
                MessageUtil.getMessage(MessageId.EMW1003),
                C_DsTeisiRiyuuKbn.OMOUSIDE.getContent(),
                C_DsTeisiRiyuuKbn.SONOTA.getContent());
        }

        uiBean.setSenimotoKbnConfirm(SERVICE_TEISI_BTN);
        uiBean.setKakunindsteisiriyuukbn(uiBean.getInputdsteisiriyuukbn());

        setMpaccountjtHenkouGamenSettei();

        messageManager.addConversationMessageId(KOKSEIBI_CONFIRM,MessageId.QMA1003);

        messageManager.removeConversationMessage(KOKSEIBI_INPUTCONTENTS);
    }

    void pushServicesaikaibtnBL() {

        uiBean.setSenimotoKbnConfirm(SERVICE_SAIKAI_BTN);

        setMpaccountjtHenkouGamenSettei();

        messageManager.addConversationMessageId(KOKSEIBI_CONFIRM,MessageId.QMA1004);

        messageManager.removeConversationMessage(KOKSEIBI_INPUTCONTENTS);
    }

    void pushDskaiyakubtnBL() {

        uiBean.setSenimotoKbnConfirm(DS_KAIYAKU_BTN);

        setMpaccountjtHenkouGamenSettei();

        messageManager.addConversationMessageId(KOKSEIBI_CONFIRM,MessageId.QMA1010);

        messageManager.removeConversationMessage(KOKSEIBI_INPUTCONTENTS);
    }


    String pushModoruBtnByInputContentsBL() {

        messageManager.removeConversationMessage(KOKSEIBI_INPUTCONTENTS);

        String rtnUrl = null;

        if (FORWARDNAME_INPUTKEYSELECT.equals(uiBean.getSenimotoKbnInput())) {

            rtnUrl =  FORWARDNAME_INPUTKEYSELECT;

        }
        else {

            rtnUrl =  FORWARDNAME_SEIBITSSEARCH;
        }

        return rtnUrl;
    }

    @Transactional
    void pushKakuteiBtnBL() {

        DsSaibanSyori dsSaibanSyori = SWAKInjector.getInstance(DsSaibanSyori.class);

        String dsHenkousikibetukey = dsSaibanSyori.saibanDsHenkouSikibetukey();

        TableMaintenanceUtil tableMaintenanceUtil = SWAKInjector.getInstance(TableMaintenanceUtil.class);

        MT_BAK_DsKokyakuKanri bakDsKokyakuKanri = tableMaintenanceUtil.exec(uiBean.getDskokno(), dsHenkousikibetukey);

        directDomManager.insert(bakDsKokyakuKanri);

        MT_DsKokyakuKanri dsKokyakuKanriHctl = uiBean.getDsKokyakuKanriHctl();

        String kinouId = kinou.getKinouId();

        String userId = baseUserInfo.getUserId();

        BizDate sysDate = BizDate.getSysDate();

        String sysDateTimeMilli = BizDate.getSysDateTimeMilli();

        C_DsSyoriKbn dsSyoriKbn = null;

        if (KAKUNIN_BTN.equals(uiBean.getSenimotoKbnConfirm())) {

            dsKokyakuKanriHctl.setDsteisiriyuukbn(uiBean.getKakunindsteisiriyuukbn());

            dsKokyakuKanriHctl.setSeisahuyouhyj(uiBean.getKakuninseisahuyouhyj());

            dsKokyakuKanriHctl.setDskokyakunmkn(uiBean.getKakunindskokyakunmkn());

            dsKokyakuKanriHctl.setDskokyakunmkj(uiBean.getKakunindskokyakunmkj());

            dsKokyakuKanriHctl.setDskokyakuseiymd(uiBean.getKakunindskokyakuseiymd());

            dsKokyakuKanriHctl.setDskokyakuyno(uiBean.getKakunindskokyakuyno());

            dsKokyakuKanriHctl.setDskanyuukeirokbn(uiBean.getKakunindskanyuukeirokbn());

            dsKokyakuKanriHctl.setGyoumuKousinKinou(kinouId);

            dsKokyakuKanriHctl.setGyoumuKousinsyaId(userId);

            dsKokyakuKanriHctl.setGyoumuKousinTime(sysDateTimeMilli);

            MT_DsHonninKakuninCd  dsHonninKakuninCd = dsKokyakuKanriHctl.getDsHonninKakuninCd();


            dsHonninKakuninCd.setDskrhnnkakcdttyhkbn(uiBean.getKakunindskrhnnkakcdttyhkbn());

            dsHonninKakuninCd.setDskrhnnkakcdttshjyhsymd(uiBean.getKakunindskrhnnkakcdttjyymd());

            if (!uiBean.getDskrhnnkakcdttyhkbn().eq(uiBean.getKakunindskrhnnkakcdttyhkbn())) {

                if (C_DsKrHnnKakCdTtYhKbn.YOU.eq(uiBean.getKakunindskrhnnkakcdttyhkbn())) {

                    dsHonninKakuninCd.setDskrhnnkakcdtttydnjykbn(C_DsKrHnnKakCdTtTydnJyKbn.BLNK);
                }
                else if (C_DsKrHnnKakCdTtYhKbn.TYUUDAN.eq(uiBean.getKakunindskrhnnkakcdttyhkbn())) {

                    dsHonninKakuninCd.setDskrhnnkakcdtttydnjykbn(C_DsKrHnnKakCdTtTydnJyKbn.KKKSBTY);
                }
            }

            dsHonninKakuninCd.setGyoumuKousinKinou(kinouId);

            dsHonninKakuninCd.setGyoumuKousinsyaId(userId);

            dsHonninKakuninCd.setGyoumuKousinTime(sysDateTimeMilli);

            if (!uiBean.getDsmailaddress().equals(uiBean.getKakunindsmailaddress()) ||
                !uiBean.getDsmailsousinjyoutaikbn().eq(uiBean.getKakunindsmailsousinjtkbn()) ||
                !uiBean.getDsmailsousintisrykbn().eq(uiBean.getKakunindsmailsousintisrykbn())) {

                C_DsMailTourokuJyoutaiKbn dsMailTourokuJyoutaiKbn  = C_DsMailTourokuJyoutaiKbn.MITOUROKU;
                C_DsMailDbSyoriKbn dsMailDbSyoriKbn = C_DsMailDbSyoriKbn .BLNK;
                String yuyuDbsyorikbn = YUYU_DB_SYORI_KBN_INIT;

                if (!uiBean.getDsmailaddress().equals(uiBean.getKakunindsmailaddress()) &&
                    BizUtil.isBlank(uiBean.getKakunindsmailaddress())) {
                    dsMailTourokuJyoutaiKbn  = C_DsMailTourokuJyoutaiKbn.SAKUJYO;
                }
                else {
                    dsMailTourokuJyoutaiKbn  = C_DsMailTourokuJyoutaiKbn.TOUROKU;
                }

                MT_DsMailAddress dsMailAddress =
                    dsKokyakuKanriHctl.getDsMailAddressByDsmailaddressrenban(uiBean.getDsmailaddressrenban());

                dsMailAddress.setDsmailtourokujyoutaikbn(dsMailTourokuJyoutaiKbn);
                dsMailAddress.setDsmailaddress(uiBean.getKakunindsmailaddress());
                dsMailAddress.setDsmailsousinjyoutaikbn(uiBean.getKakunindsmailsousinjtkbn());
                dsMailAddress.setDsmailsousintisrykbn(uiBean.getKakunindsmailsousintisrykbn());
                dsMailAddress.setDskousinymdtime(uiBean.getUpdatedskousinymdtimemillihozi());
                dsMailAddress.setGyoumuKousinKinou(kinouId);
                dsMailAddress.setGyoumuKousinsyaId(userId);
                dsMailAddress.setGyoumuKousinTime(sysDateTimeMilli);

                MT_DsMailAddressSpiralYyk dsMailAddressSpiralYyk =
                    dsKokyakuKanriHctl.getDsMailAddressSpiralYykByDsdatasakuseiymdDsmailaddressrenban(
                        sysDate, uiBean.getDsmailaddressrenban());

                if (dsMailAddressSpiralYyk == null) {
                    if (C_DsMailSousinJyoutaiKbn.YUUKOU.eq(uiBean.getKakunindsmailsousinjtkbn())) {
                        if (C_DsMailSousinJyoutaiKbn.YUUKOU.eq(uiBean.getDsmailsousinjyoutaikbn())) {
                            dsMailDbSyoriKbn = C_DsMailDbSyoriKbn.KOUSIN;

                            yuyuDbsyorikbn = YUYU_DB_SYORI_KBN_ADD;
                        }
                        else {
                            dsMailDbSyoriKbn = C_DsMailDbSyoriKbn.TOUROKU;

                            yuyuDbsyorikbn = YUYU_DB_SYORI_KBN_ADD;
                        }
                    }
                    else {
                        if (C_DsMailSousinJyoutaiKbn.YUUKOU.eq(uiBean.getDsmailsousinjyoutaikbn())) {
                            dsMailDbSyoriKbn = C_DsMailDbSyoriKbn.SAKUJYO;

                            yuyuDbsyorikbn = YUYU_DB_SYORI_KBN_ADD;
                        }
                    }

                    if (YUYU_DB_SYORI_KBN_ADD.equals(yuyuDbsyorikbn)) {

                        MT_DsMailAddressSpiralYyk newDsMailAddressSpiralYyk = dsKokyakuKanriHctl.createDsMailAddressSpiralYyk();
                        newDsMailAddressSpiralYyk.setDsdatasakuseiymd(sysDate);
                        newDsMailAddressSpiralYyk.setDsmailaddressrenban(uiBean.getDsmailaddressrenban());
                        newDsMailAddressSpiralYyk.setDsmailaddress(uiBean.getKakunindsmailaddress());
                        newDsMailAddressSpiralYyk.setDsrendoutaisyoukbn(C_DsRendouTaisyouKbn.RENDOUTAISYOU);
                        newDsMailAddressSpiralYyk.setDsmaildbsyorikbn(dsMailDbSyoriKbn);
                        newDsMailAddressSpiralYyk.setGyoumuKousinKinou(kinouId);
                        newDsMailAddressSpiralYyk.setGyoumuKousinsyaId(userId);
                        newDsMailAddressSpiralYyk.setGyoumuKousinTime(sysDateTimeMilli);
                        BizPropertyInitializer.initialize(newDsMailAddressSpiralYyk);
                    }
                }
                else {
                    dsMailDbSyoriKbn = dsMailAddressSpiralYyk.getDsmaildbsyorikbn();

                    if (C_DsMailDbSyoriKbn.KOUSIN.eq(dsMailDbSyoriKbn) ||
                        C_DsMailDbSyoriKbn.SAKUJYO.eq(dsMailDbSyoriKbn)) {

                        if (C_DsMailSousinJyoutaiKbn.YUUKOU.eq(uiBean.getKakunindsmailsousinjtkbn())) {
                            dsMailDbSyoriKbn = C_DsMailDbSyoriKbn.KOUSIN;
                        }
                        else {
                            dsMailDbSyoriKbn = C_DsMailDbSyoriKbn.SAKUJYO;
                        }

                        yuyuDbsyorikbn = YUYU_DB_SYORI_KBN_UP;
                    }
                    else {

                        if (C_DsMailSousinJyoutaiKbn.YUUKOU.eq(uiBean.getKakunindsmailsousinjtkbn())) {
                            yuyuDbsyorikbn = YUYU_DB_SYORI_KBN_UP;
                        }
                        else {
                            yuyuDbsyorikbn = YUYU_DB_SYORI_KBN_DEL;
                        }
                    }

                    if (YUYU_DB_SYORI_KBN_UP.equals(yuyuDbsyorikbn)) {
                        dsMailAddressSpiralYyk.setDsmailaddress(uiBean.getKakunindsmailaddress());
                        dsMailAddressSpiralYyk.setDsrendoutaisyoukbn(C_DsRendouTaisyouKbn.RENDOUTAISYOU);
                        dsMailAddressSpiralYyk.setDsmaildbsyorikbn(dsMailDbSyoriKbn);
                        dsMailAddressSpiralYyk.setGyoumuKousinKinou(kinouId);
                        dsMailAddressSpiralYyk.setGyoumuKousinsyaId(userId);
                        dsMailAddressSpiralYyk.setGyoumuKousinTime(sysDateTimeMilli);
                    }
                    if (YUYU_DB_SYORI_KBN_DEL.equals(yuyuDbsyorikbn)) {

                        List<MT_DsMailAddressSpiralYyk> dsMailAddressSpiralYykLst = dsKokyakuKanriHctl.getDsMailAddressSpiralYyks();
                        dsMailAddressSpiralYykLst.remove(dsMailAddressSpiralYyk);
                    }
                }
            }

            dsSyoriKbn = C_DsSyoriKbn.HAND_TEISEI;
        }
        else if (ACCOUNT_LOCK_KAIJYO_BTN.equals(uiBean.getSenimotoKbnConfirm())) {

            dsKokyakuKanriHctl.setDskokyakujtkbn(C_DsKokyakuJtKbn.ITIJI_TEISI);

            dsKokyakuKanriHctl.setDsteisiriyuukbn(C_DsTeisiRiyuuKbn.PASSWORD_MITOUROKU);

            dsKokyakuKanriHctl.setDskokyakumukouymd(null);

            dsKokyakuKanriHctl.setGyoumuKousinKinou(kinouId);

            dsKokyakuKanriHctl.setGyoumuKousinsyaId(userId);

            dsKokyakuKanriHctl.setGyoumuKousinTime(sysDateTimeMilli);

            MT_DsHonninKakuninCd  dsHonninKakuninCd = dsKokyakuKanriHctl.getDsHonninKakuninCd();

            dsHonninKakuninCd.setDskrhnnkakcd("");

            dsHonninKakuninCd.setDskrhnnkakcdsetkbn(C_DsKrHnnKakCdSetKbn.SAIHAKKOU);

            dsHonninKakuninCd.setDskrhnnkakcdsetymd(null);

            dsHonninKakuninCd.setDskrhnnkakcdyuukouymd(null);

            dsHonninKakuninCd.setDshnnkakcd("");

            dsHonninKakuninCd.setDshnnkakcdsetymd(null);

            dsHonninKakuninCd.setDskrhnnkakcdttshjyhsymd(uiBean.getKakunindskrhnnkakcdttjyymd());

            dsHonninKakuninCd.setDskrhnnkakcdttyhkbn(uiBean.getKakunindskrhnnkakcdttyhkbn());

            dsHonninKakuninCd.setDskrhnnkakcdtttydnjykbn(C_DsKrHnnKakCdTtTydnJyKbn.BLNK);

            dsHonninKakuninCd.setGyoumuKousinKinou(kinouId);

            dsHonninKakuninCd.setGyoumuKousinsyaId(userId);

            dsHonninKakuninCd.setGyoumuKousinTime(sysDateTimeMilli);

            MT_DsLoginKanri  dsLoginKanri = dsKokyakuKanriHctl.getDsLoginKanri();

            dsLoginKanri.setDshnnkakcderrorkaisuu(INIT_ERROR_KAISUU);

            dsLoginKanri.setDskokyakunmerrorkaisuu(INIT_ERROR_KAISUU);

            dsLoginKanri.setDskokyakuseiymderrorkaisuu(INIT_ERROR_KAISUU);

            dsLoginKanri.setDskokyakutelnoerrorkaisuu(INIT_ERROR_KAISUU);

            dsLoginKanri.setGyoumuKousinKinou(kinouId);

            dsLoginKanri.setGyoumuKousinsyaId(userId);

            dsLoginKanri.setGyoumuKousinTime(sysDateTimeMilli);

            if (uiBean.getAccountlockFlg()) {
                dsSyoriKbn = C_DsSyoriKbn.ACCOUNT_LOCK_KAIJYO;
            }
            else {
                dsSyoriKbn = C_DsSyoriKbn.PASSWORD_SAIHAKKOU;
            }
        }
        else if (SERVICE_TEISI_BTN.equals(uiBean.getSenimotoKbnConfirm())) {

            dsKokyakuKanriHctl.setDskokyakujtkbn(C_DsKokyakuJtKbn.ITIJI_TEISI);

            dsKokyakuKanriHctl.setDsteisiriyuukbn(uiBean.getKakunindsteisiriyuukbn());

            dsKokyakuKanriHctl.setDskokyakumukouymd(sysDate);

            dsKokyakuKanriHctl.setGyoumuKousinKinou(kinouId);

            dsKokyakuKanriHctl.setGyoumuKousinsyaId(userId);

            dsKokyakuKanriHctl.setGyoumuKousinTime(sysDateTimeMilli);

            if (!uiBean.getDsmailsousinjyoutaikbn().eq(uiBean.getKakunindsmailsousinjtkbn())) {

                MT_DsMailAddress dsMailAddress =
                    dsKokyakuKanriHctl.getDsMailAddressByDsmailaddressrenban(uiBean.getDsmailaddressrenban());

                dsMailAddress.setDsmailsousinjyoutaikbn(uiBean.getKakunindsmailsousinjtkbn());
                dsMailAddress.setDsmailsousintisrykbn(uiBean.getKakunindsmailsousintisrykbn());
                dsMailAddress.setDskousinymdtime(uiBean.getUpdatedskousinymdtimemillihozi());
                dsMailAddress.setGyoumuKousinKinou(kinouId);
                dsMailAddress.setGyoumuKousinsyaId(userId);
                dsMailAddress.setGyoumuKousinTime(sysDateTimeMilli);

                String yuyuDbsyorikbn = YUYU_DB_SYORI_KBN_INIT;

                MT_DsMailAddressSpiralYyk dsMailAddressSpiralYyk =
                    dsKokyakuKanriHctl.getDsMailAddressSpiralYykByDsdatasakuseiymdDsmailaddressrenban(
                        sysDate, uiBean.getDsmailaddressrenban());

                if (dsMailAddressSpiralYyk == null) {
                    if (C_DsMailSousinJyoutaiKbn.TEISI.eq(uiBean.getKakunindsmailsousinjtkbn())) {
                        MT_DsMailAddressSpiralYyk newDsMailAddressSpiralYyk = dsKokyakuKanriHctl.createDsMailAddressSpiralYyk();
                        newDsMailAddressSpiralYyk.setDsdatasakuseiymd(sysDate);
                        newDsMailAddressSpiralYyk.setDsmailaddressrenban(uiBean.getDsmailaddressrenban());
                        newDsMailAddressSpiralYyk.setDsmailaddress(uiBean.getKakunindsmailaddress());
                        newDsMailAddressSpiralYyk.setDsrendoutaisyoukbn(C_DsRendouTaisyouKbn.RENDOUTAISYOU);
                        newDsMailAddressSpiralYyk.setDsmaildbsyorikbn(C_DsMailDbSyoriKbn.SAKUJYO);
                        newDsMailAddressSpiralYyk.setGyoumuKousinKinou(kinouId);
                        newDsMailAddressSpiralYyk.setGyoumuKousinsyaId(userId);
                        newDsMailAddressSpiralYyk.setGyoumuKousinTime(sysDateTimeMilli);
                        BizPropertyInitializer.initialize(newDsMailAddressSpiralYyk);
                    }
                }
                else {
                    C_DsMailDbSyoriKbn dsMailDbSyoriKbn = dsMailAddressSpiralYyk.getDsmaildbsyorikbn();

                    if (C_DsMailDbSyoriKbn.TOUROKU.eq(dsMailDbSyoriKbn)) {
                        yuyuDbsyorikbn = YUYU_DB_SYORI_KBN_DEL;
                    }
                    if (C_DsMailDbSyoriKbn.KOUSIN.eq(dsMailDbSyoriKbn)) {
                        yuyuDbsyorikbn = YUYU_DB_SYORI_KBN_UP;
                    }

                    if (YUYU_DB_SYORI_KBN_UP.equals(yuyuDbsyorikbn)) {

                        dsMailAddressSpiralYyk.setDsrendoutaisyoukbn(C_DsRendouTaisyouKbn.RENDOUTAISYOU);
                        dsMailAddressSpiralYyk.setDsmaildbsyorikbn(C_DsMailDbSyoriKbn.SAKUJYO);
                        dsMailAddressSpiralYyk.setGyoumuKousinKinou(kinouId);
                        dsMailAddressSpiralYyk.setGyoumuKousinsyaId(userId);
                        dsMailAddressSpiralYyk.setGyoumuKousinTime(sysDateTimeMilli);
                    }

                    if (YUYU_DB_SYORI_KBN_DEL.equals(yuyuDbsyorikbn)) {
                        List<MT_DsMailAddressSpiralYyk> dsMailAddressSpiralYykLst = dsKokyakuKanriHctl.getDsMailAddressSpiralYyks();
                        dsMailAddressSpiralYykLst.remove(dsMailAddressSpiralYyk);
                    }
                }
            }
            dsSyoriKbn = C_DsSyoriKbn.SERVICE_TEISI;
        }
        else if (SERVICE_SAIKAI_BTN.equals(uiBean.getSenimotoKbnConfirm())) {

            dsKokyakuKanriHctl.setDskokyakujtkbn(C_DsKokyakuJtKbn.ITIJI_TEISI);

            dsKokyakuKanriHctl.setDsteisiriyuukbn(C_DsTeisiRiyuuKbn.PASSWORD_MITOUROKU);

            dsKokyakuKanriHctl.setDskokyakumukouymd(null);

            dsKokyakuKanriHctl.setGyoumuKousinKinou(kinouId);

            dsKokyakuKanriHctl.setGyoumuKousinsyaId(userId);

            dsKokyakuKanriHctl.setGyoumuKousinTime(sysDateTimeMilli);

            MT_DsHonninKakuninCd  dsHonninKakuninCd = dsKokyakuKanriHctl.getDsHonninKakuninCd();

            dsHonninKakuninCd.setDskrhnnkakcd("");

            dsHonninKakuninCd.setDskrhnnkakcdsetkbn(C_DsKrHnnKakCdSetKbn.SAIHAKKOU);

            dsHonninKakuninCd.setDskrhnnkakcdsetymd(null);

            dsHonninKakuninCd.setDskrhnnkakcdyuukouymd(null);

            dsHonninKakuninCd.setDshnnkakcd("");

            dsHonninKakuninCd.setDshnnkakcdsetymd(null);

            dsHonninKakuninCd.setDskrhnnkakcdttshjyhsymd(uiBean.getKakunindskrhnnkakcdttjyymd());

            dsHonninKakuninCd.setDskrhnnkakcdttyhkbn(uiBean.getKakunindskrhnnkakcdttyhkbn());

            dsHonninKakuninCd.setDskrhnnkakcdtttydnjykbn(C_DsKrHnnKakCdTtTydnJyKbn.BLNK);

            dsHonninKakuninCd.setGyoumuKousinKinou(kinouId);

            dsHonninKakuninCd.setGyoumuKousinsyaId(userId);

            dsHonninKakuninCd.setGyoumuKousinTime(sysDateTimeMilli);

            MT_DsLoginKanri  dsLoginKanri = dsKokyakuKanriHctl.getDsLoginKanri();

            dsLoginKanri.setDshnnkakcderrorkaisuu(INIT_ERROR_KAISUU);

            dsLoginKanri.setDskokyakunmerrorkaisuu(INIT_ERROR_KAISUU);

            dsLoginKanri.setDskokyakuseiymderrorkaisuu(INIT_ERROR_KAISUU);

            dsLoginKanri.setDskokyakutelnoerrorkaisuu(INIT_ERROR_KAISUU);

            dsLoginKanri.setGyoumuKousinKinou(kinouId);

            dsLoginKanri.setGyoumuKousinsyaId(userId);

            dsLoginKanri.setGyoumuKousinTime(sysDateTimeMilli);

            if (!uiBean.getDsmailsousinjyoutaikbn().eq(uiBean.getKakunindsmailsousinjtkbn())) {
                MT_DsMailAddress dsMailAddress =
                    dsKokyakuKanriHctl.getDsMailAddressByDsmailaddressrenban(uiBean.getDsmailaddressrenban());

                dsMailAddress.setDsmailsousinjyoutaikbn(uiBean.getKakunindsmailsousinjtkbn());
                dsMailAddress.setDsmailsousintisrykbn(uiBean.getKakunindsmailsousintisrykbn());
                dsMailAddress.setDskousinymdtime(uiBean.getUpdatedskousinymdtimemillihozi());
                dsMailAddress.setGyoumuKousinKinou(kinouId);
                dsMailAddress.setGyoumuKousinsyaId(userId);
                dsMailAddress.setGyoumuKousinTime(sysDateTimeMilli);

                MT_DsMailAddressSpiralYyk dsMailAddressSpiralYyk =
                    dsKokyakuKanriHctl.getDsMailAddressSpiralYykByDsdatasakuseiymdDsmailaddressrenban(
                        sysDate, uiBean.getDsmailaddressrenban());

                if (dsMailAddressSpiralYyk == null) {
                    if (C_DsMailSousinJyoutaiKbn.YUUKOU.eq(uiBean.getKakunindsmailsousinjtkbn())) {
                        C_DsMailDbSyoriKbn dsMailDbSyoriKbn = C_DsMailDbSyoriKbn.TOUROKU;

                        MT_DsMailAddressSpiralYyk newDsMailAddressSpiralYyk = dsKokyakuKanriHctl.createDsMailAddressSpiralYyk();
                        newDsMailAddressSpiralYyk.setDsdatasakuseiymd(sysDate);
                        newDsMailAddressSpiralYyk.setDsmailaddressrenban(uiBean.getDsmailaddressrenban());
                        newDsMailAddressSpiralYyk.setDsmailaddress(uiBean.getKakunindsmailaddress());
                        newDsMailAddressSpiralYyk.setDsrendoutaisyoukbn(C_DsRendouTaisyouKbn.RENDOUTAISYOU);
                        newDsMailAddressSpiralYyk.setDsmaildbsyorikbn(dsMailDbSyoriKbn);
                        newDsMailAddressSpiralYyk.setGyoumuKousinKinou(kinouId);
                        newDsMailAddressSpiralYyk.setGyoumuKousinsyaId(userId);
                        newDsMailAddressSpiralYyk.setGyoumuKousinTime(sysDateTimeMilli);
                        BizPropertyInitializer.initialize(newDsMailAddressSpiralYyk);
                    }
                }
                else {

                    C_DsMailDbSyoriKbn dsMailDbSyoriKbn = dsMailAddressSpiralYyk.getDsmaildbsyorikbn();

                    if (C_DsMailDbSyoriKbn.SAKUJYO.eq(dsMailDbSyoriKbn)) {

                        dsMailDbSyoriKbn = C_DsMailDbSyoriKbn.KOUSIN;
                        dsMailAddressSpiralYyk.setDsrendoutaisyoukbn(C_DsRendouTaisyouKbn.RENDOUTAISYOU);
                        dsMailAddressSpiralYyk.setDsmaildbsyorikbn(dsMailDbSyoriKbn);
                        dsMailAddressSpiralYyk.setGyoumuKousinKinou(kinouId);
                        dsMailAddressSpiralYyk.setGyoumuKousinsyaId(userId);
                        dsMailAddressSpiralYyk.setGyoumuKousinTime(sysDateTimeMilli);
                    }
                }
            }

            dsSyoriKbn = C_DsSyoriKbn.SERVICE_SAIKAI;
        }
        else {

            dsKokyakuKanriHctl.setDskokyakujtkbn(C_DsKokyakuJtKbn.KAIYAKU);

            dsKokyakuKanriHctl.setDsteisiriyuukbn(uiBean.getKakunindsteisiriyuukbn());

            dsKokyakuKanriHctl.setDskokyakumukouymd(sysDate);

            dsKokyakuKanriHctl.setGyoumuKousinKinou(kinouId);

            dsKokyakuKanriHctl.setGyoumuKousinsyaId(userId);

            dsKokyakuKanriHctl.setGyoumuKousinTime(sysDateTimeMilli);

            if (!uiBean.getDskrhnnkakcdttyhkbn().eq(uiBean.getKakunindskrhnnkakcdttyhkbn())) {
                MT_DsHonninKakuninCd  dsHonninKakuninCd = dsKokyakuKanriHctl.getDsHonninKakuninCd();

                dsHonninKakuninCd.setDskrhnnkakcdttyhkbn(uiBean.getKakunindskrhnnkakcdttyhkbn());

                dsHonninKakuninCd.setDskrhnnkakcdttshjyhsymd(uiBean.getKakunindskrhnnkakcdttjyymd());

                dsHonninKakuninCd.setDskrhnnkakcdtttydnjykbn(C_DsKrHnnKakCdTtTydnJyKbn.KKKSBTY);

                dsHonninKakuninCd.setGyoumuKousinKinou(kinouId);

                dsHonninKakuninCd.setGyoumuKousinsyaId(userId);

                dsHonninKakuninCd.setGyoumuKousinTime(sysDateTimeMilli);
            }

            if (uiBean.getYuukoukykhyuFlg()) {
                List<MT_DsKokyakuKeiyaku> dsKokyakuKeiyakuLst = dsKokyakuKanriHctl.getDsKokyakuKeiyakus();
                for (MT_DsKokyakuKeiyaku dsKokyakuKeiyaku : dsKokyakuKeiyakuLst) {
                    C_MukouHyj dskykmukouhyj = dsKokyakuKeiyaku.getDskykmukouhyj();

                    if (C_MukouHyj.BLANK.eq(dskykmukouhyj)) {
                        dsKokyakuKeiyaku.setDskykmukouhyj(C_MukouHyj.MUKOU);

                        dsKokyakuKeiyaku.setDskykmukouymd(sysDate);

                        dsKokyakuKeiyaku.setGyoumuKousinKinou(kinouId);

                        dsKokyakuKeiyaku.setGyoumuKousinsyaId(userId);

                        dsKokyakuKeiyaku.setGyoumuKousinTime(sysDateTimeMilli);
                    }

                    MT_DsTorihikiServiceKanri dsTorihikiServiceKanri = dsKokyakuKeiyaku.getDsTorihikiServiceKanri();

                    if (dsTorihikiServiceKanri != null &&
                        C_DsTrhkserviceRiyoujkKbn.RIYOU_KA.eq(dsTorihikiServiceKanri.getDstrhkserviceriyoujkkbn())) {

                        dsTorihikiServiceKanri.setDstrhkserviceriyoujkkbn(C_DsTrhkserviceRiyoujkKbn.RIYOU_HUKA);
                        dsTorihikiServiceKanri.setDstrhkserviceteisiriyuukbn(C_DsTrhkserviceTeisiRiyuuKbn.SYOUMETU);
                        dsTorihikiServiceKanri.setDstrhkservicemukouymd(sysDate);
                        dsTorihikiServiceKanri.setGyoumuKousinKinou(kinouId);
                        dsTorihikiServiceKanri.setGyoumuKousinsyaId(userId);
                        dsTorihikiServiceKanri.setGyoumuKousinTime(sysDateTimeMilli);
                    }
                }
            }

            if (!uiBean.getDsmailsousinjyoutaikbn().eq(uiBean.getKakunindsmailsousinjtkbn())) {
                MT_DsMailAddress dsMailAddress =
                    dsKokyakuKanriHctl.getDsMailAddressByDsmailaddressrenban(uiBean.getDsmailaddressrenban());

                dsMailAddress.setDsmailsousinjyoutaikbn(uiBean.getKakunindsmailsousinjtkbn());
                dsMailAddress.setDsmailsousintisrykbn(uiBean.getKakunindsmailsousintisrykbn());
                dsMailAddress.setDskousinymdtime(uiBean.getUpdatedskousinymdtimemillihozi());
                dsMailAddress.setGyoumuKousinKinou(kinouId);
                dsMailAddress.setGyoumuKousinsyaId(userId);
                dsMailAddress.setGyoumuKousinTime(sysDateTimeMilli);

                String yuyuDbsyorikbn = YUYU_DB_SYORI_KBN_INIT;

                MT_DsMailAddressSpiralYyk dsMailAddressSpiralYyk =
                    dsKokyakuKanriHctl.getDsMailAddressSpiralYykByDsdatasakuseiymdDsmailaddressrenban(
                        sysDate, uiBean.getDsmailaddressrenban());

                if (dsMailAddressSpiralYyk == null) {
                    if (C_DsMailSousinJyoutaiKbn.TEISI.eq(uiBean.getKakunindsmailsousinjtkbn())) {
                        MT_DsMailAddressSpiralYyk newDsMailAddressSpiralYyk = dsKokyakuKanriHctl.createDsMailAddressSpiralYyk();
                        newDsMailAddressSpiralYyk.setDsdatasakuseiymd(sysDate);
                        newDsMailAddressSpiralYyk.setDsmailaddressrenban(uiBean.getDsmailaddressrenban());
                        newDsMailAddressSpiralYyk.setDsmailaddress(uiBean.getKakunindsmailaddress());
                        newDsMailAddressSpiralYyk.setDsrendoutaisyoukbn(C_DsRendouTaisyouKbn.RENDOUTAISYOU);
                        newDsMailAddressSpiralYyk.setDsmaildbsyorikbn(C_DsMailDbSyoriKbn.SAKUJYO);
                        newDsMailAddressSpiralYyk.setGyoumuKousinKinou(kinouId);
                        newDsMailAddressSpiralYyk.setGyoumuKousinsyaId(userId);
                        newDsMailAddressSpiralYyk.setGyoumuKousinTime(sysDateTimeMilli);
                        BizPropertyInitializer.initialize(newDsMailAddressSpiralYyk);
                    }
                }
                else {
                    C_DsMailDbSyoriKbn dsMailDbSyoriKbn = dsMailAddressSpiralYyk.getDsmaildbsyorikbn();

                    if (C_DsMailDbSyoriKbn.TOUROKU.eq(dsMailDbSyoriKbn)) {
                        yuyuDbsyorikbn = YUYU_DB_SYORI_KBN_DEL;
                    }
                    if (C_DsMailDbSyoriKbn.KOUSIN.eq(dsMailDbSyoriKbn)) {
                        yuyuDbsyorikbn = YUYU_DB_SYORI_KBN_UP;
                    }

                    if (YUYU_DB_SYORI_KBN_UP.equals(yuyuDbsyorikbn)) {

                        dsMailAddressSpiralYyk.setDsrendoutaisyoukbn(C_DsRendouTaisyouKbn.RENDOUTAISYOU);
                        dsMailAddressSpiralYyk.setDsmaildbsyorikbn(C_DsMailDbSyoriKbn.SAKUJYO);
                        dsMailAddressSpiralYyk.setGyoumuKousinKinou(kinouId);
                        dsMailAddressSpiralYyk.setGyoumuKousinsyaId(userId);
                        dsMailAddressSpiralYyk.setGyoumuKousinTime(sysDateTimeMilli);
                    }

                    if (YUYU_DB_SYORI_KBN_DEL.equals(yuyuDbsyorikbn)) {
                        List<MT_DsMailAddressSpiralYyk> dsMailAddressSpiralYykLst = dsKokyakuKanriHctl.getDsMailAddressSpiralYyks();
                        dsMailAddressSpiralYykLst.remove(dsMailAddressSpiralYyk);
                    }
                }
            }
            dsSyoriKbn = C_DsSyoriKbn.DSKAIYAKU;
        }

        directDomManager.update(dsKokyakuKanriHctl);

        DsTetudukiRirekiTableEdit dsTetudukiRirekiTableEdit = SWAKInjector.getInstance(DsTetudukiRirekiTableEdit.class);

        DsTetudukiRirekiTableEditParamImpl dsTetudukiRirekiTableEditParamImpl =
            SWAKInjector.getInstance(DsTetudukiRirekiTableEditParamImpl.class);

        dsTetudukiRirekiTableEditParamImpl.setDskokno(uiBean.getDskokno());

        dsTetudukiRirekiTableEditParamImpl.setHenkousikibetukey(dsHenkousikibetukey);

        dsTetudukiRirekiTableEditParamImpl.setSyoriYmd(sysDate);

        dsTetudukiRirekiTableEditParamImpl.setDssyorikbn(dsSyoriKbn);

        dsTetudukiRirekiTableEditParamImpl.setHenkouRrkYouhi(C_YouhiKbn.YOU);

        dsTetudukiRirekiTableEdit.editDSTtdkRirekiTblOnline(dsTetudukiRirekiTableEditParamImpl);

        messageManager.removeConversationMessage(KOKSEIBI_CONFIRM);

        if (KAKUNIN_BTN.equals(uiBean.getSenimotoKbnConfirm())) {

            messageManager.addConversationMessageId(KOKSEIBI_RESULT, MessageId.IMA1001);

            if (uiBean.getKrpasswortuutihanteiFlg()) {
                messageManager.addConversationMessageId(KOKSEIBI_RESULT, MessageId.IMA1013);
            }
        }
        else if (ACCOUNT_LOCK_KAIJYO_BTN.equals(uiBean.getSenimotoKbnConfirm())) {

            if (uiBean.getAccountlockFlg()) {
                messageManager.addConversationMessageId(KOKSEIBI_RESULT, MessageId.IMA1002);
            }
            else {
                messageManager.addConversationMessageId(KOKSEIBI_RESULT, MessageId.IMA1010);
            }

        }
        else if (SERVICE_TEISI_BTN.equals(uiBean.getSenimotoKbnConfirm())) {

            messageManager.addConversationMessageId(KOKSEIBI_RESULT, MessageId.IMA1003);
        }
        else if (SERVICE_SAIKAI_BTN.equals(uiBean.getSenimotoKbnConfirm())) {

            messageManager.addConversationMessageId(KOKSEIBI_RESULT, MessageId.IMA1004);
        }
        else {
            messageManager.addConversationMessageId(KOKSEIBI_RESULT, MessageId.IMA1011);
        }
    }

    void pushModoruBtnByConfirmBL() {

        setInputGamenMessageSettei();

        messageManager.removeConversationMessage(KOKSEIBI_CONFIRM);
    }

    void pushModoruBtnByKykbticBL() {

        uiBean.setDstrhkserviceriyoujkkbn(C_DsTrhkserviceRiyoujkKbn.BLNK);
        uiBean.setDstrhkserviceteisiriyuukbn(C_DsTrhkserviceTeisiRiyuuKbn.BLNK);
        uiBean.setInputdstrhksvctisrykbn(C_DsTrhkserviceTeisiRiyuuKbn.BLNK);
        uiBean.setDstrhkservicekanyukeirokbn(C_DsTrhkserviceKanyukeiroKbn.BLNK);
        uiBean.setKzsyuruikbn(C_KouzasyuruiKbn.BLNK);
        uiBean.setBankcd("");
        uiBean.setBanknmkj("");
        uiBean.setSitencd("");
        uiBean.setSitennmkj("");
        uiBean.setYokinkbn(C_YokinKbn.BLNK);
        uiBean.setKouzano("");
        uiBean.setKzdoukbn(C_Kzdou.BLNK);
        uiBean.setKzmeiginmkn("");
        uiBean.setDisptokuteitrhkansyono("");
        uiBean.setTktrhkansyonoerrorkaisuu(Integer.valueOf(0));
        uiBean.setTokuteitrhkansyonosetymd(null);
        uiBean.setTrhkservicetourokuumuFlg(C_UmuKbn.NONE);

        setInputGamenMessageSettei();

        messageManager.removeConversationMessage(KOKSEIBI_KYKBTINPUTCONTENTS);
    }

    void pushTrhkserviceteisiBtnBL() {

        if (!C_DsTrhkserviceTeisiRiyuuKbn.OKYAKUSAMAYOUBOU.eq(uiBean.getInputdstrhksvctisrykbn()) &&
            !C_DsTrhkserviceTeisiRiyuuKbn.SONOTA.eq(uiBean.getInputdstrhksvctisrykbn())) {

            throw new BizLogicException(MessageId.EMC1016,
                new Item[]{DDID_TRHKSERVICETOUROKUJK_INPUTDSTRHKSVCTISRYKBN},
                C_DsTrhkserviceTeisiRiyuuKbn.OKYAKUSAMAYOUBOU.getContent(),
                C_DsTrhkserviceTeisiRiyuuKbn.SONOTA.getContent());
        }

        uiBean.setKakunindstrhkserviceryjkkbn(C_DsTrhkserviceRiyoujkKbn.RIYOU_HUKA);
        uiBean.setKakunindstrhksvctisrykbn(uiBean.getInputdstrhksvctisrykbn());

        messageManager.addConversationMessageId(KOKSEIBI_KYKBTCONFIRM, MessageId.QMF1001);

        messageManager.removeConversationMessage(KOKSEIBI_KYKBTINPUTCONTENTS);
    }

    void pushModoruBtnByKykconfirmBL() {

        uiBean.setKakunindstrhkserviceryjkkbn(C_DsTrhkserviceRiyoujkKbn.BLNK);
        uiBean.setKakunindstrhksvctisrykbn(C_DsTrhkserviceTeisiRiyuuKbn.BLNK);

        setKykbtInputGamenMessageSettei();

        messageManager.removeConversationMessage(KOKSEIBI_KYKBTCONFIRM);
    }

    @Transactional
    void pushKakuteiBtnByKykconfirmBL() {

        DsSaibanSyori dsSaibanSyori = SWAKInjector.getInstance(DsSaibanSyori.class);

        String dsHenkousikibetukey = dsSaibanSyori.saibanDsHenkouSikibetukey();

        TableMaintenanceUtil tableMaintenanceUtil = SWAKInjector.getInstance(TableMaintenanceUtil.class);

        MT_BAK_DsKokyakuKanri bakDsKokyakuKanri = tableMaintenanceUtil.exec(uiBean.getDskokno(), dsHenkousikibetukey);

        directDomManager.insert(bakDsKokyakuKanri);

        String kinouId = kinou.getKinouId();

        String userId = baseUserInfo.getUserId();

        BizDate sysDate = BizDate.getSysDate();

        String sysDateTimeMilli = BizDate.getSysDateTimeMilli();

        MT_DsKokyakuKanri dsKokyakuKanriHctl = uiBean.getDsKokyakuKanriHctl();

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku = dsKokyakuKanriHctl.getDsKokyakuKeiyakuBySyono(uiBean.getKykbtdispsyono());

        MT_DsTorihikiServiceKanri dsTorihikiServiceKanri = dsKokyakuKeiyaku.getDsTorihikiServiceKanri();

        dsTorihikiServiceKanri.setDstrhkserviceriyoujkkbn(C_DsTrhkserviceRiyoujkKbn.RIYOU_HUKA);
        dsTorihikiServiceKanri.setDstrhkserviceteisiriyuukbn(uiBean.getKakunindstrhksvctisrykbn());
        dsTorihikiServiceKanri.setDstrhkservicemukouymd(sysDate);
        dsTorihikiServiceKanri.setGyoumuKousinKinou(kinouId);
        dsTorihikiServiceKanri.setGyoumuKousinsyaId(userId);
        dsTorihikiServiceKanri.setGyoumuKousinTime(sysDateTimeMilli);

        directDomManager.update(dsKokyakuKanriHctl);

        DsTetudukiRirekiTableEdit dsTetudukiRirekiTableEdit = SWAKInjector.getInstance(DsTetudukiRirekiTableEdit.class);
        DsTetudukiRirekiTableEditParamImpl dsTetudukiRirekiTableEditParamImpl =
            SWAKInjector.getInstance(DsTetudukiRirekiTableEditParamImpl.class);

        dsTetudukiRirekiTableEditParamImpl.setDskokno(uiBean.getDskokno());
        dsTetudukiRirekiTableEditParamImpl.setHenkousikibetukey(dsHenkousikibetukey);
        dsTetudukiRirekiTableEditParamImpl.setSyoriYmd(sysDate);
        dsTetudukiRirekiTableEditParamImpl.setDssyorikbn(C_DsSyoriKbn.TORIHIKI_SERVICE_TEISI);
        dsTetudukiRirekiTableEditParamImpl.setHenkouRrkYouhi(C_YouhiKbn.YOU);

        dsTetudukiRirekiTableEdit.editDSTtdkRirekiTblOnline(dsTetudukiRirekiTableEditParamImpl);

        messageManager.addConversationMessageId(KOKSEIBI_KYKBTRESULT, MessageId.IMF1016);

        messageManager.removeConversationMessage(KOKSEIBI_KYKBTCONFIRM);
    }

    private void chkKinouModeHantei() {

        C_DsKinouModeIdKbn kinouMode = null;

        Boolean hasTeiseiKinouId = baseUserInfo.hasAuthenticatedFunctionMode(C_DsKinouModeIdKbn.TEISEI.getValue());

        if (hasTeiseiKinouId) {

            kinouMode = C_DsKinouModeIdKbn.TEISEI;
        }
        else {

            Boolean hasAccountJyoutaiHenkouKinouId =
                baseUserInfo.hasAuthenticatedFunctionMode(C_DsKinouModeIdKbn.ACCOUNTJYOUTAIHENKOU.getValue());

            if (hasAccountJyoutaiHenkouKinouId) {

                kinouMode = C_DsKinouModeIdKbn.ACCOUNTJYOUTAIHENKOU;
            }
            else {

                kinouMode = C_DsKinouModeIdKbn.SYOUKAI;
            }
        }

        uiBean.setKinouMode(kinouMode);
    }

    private void setGamenData(String pDskokno,String pSyono) {

        MT_DsKokyakuKanri dsKokyakuKanri =directDomManager.getDsKokyakuKanri(pDskokno);

        MT_DsHonninKakuninCd dsHonninKakuninCd = dsKokyakuKanri.getDsHonninKakuninCd();

        MT_DsLoginKanri dsLoginKanri = dsKokyakuKanri.getDsLoginKanri();

        List<MT_DsKokyakuKeiyaku> dsKokyakuKeiyaku = dsKokyakuKanri.getDsKokyakuKeiyakus();

        List<MT_DsMailAddress> dsMailAddressLst = dsKokyakuKanri.getDsMailAddresss();

        uiBean.setDsKokyakuKanriHctl(dsKokyakuKanri);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);

        kykKihon = IT_KykKihonDetacher.detachKykKihontouched(kykKihon);

        IT_KykKihon kykKihon1 = hozenDomManager.getKykKihon(pSyono);

        kykKihon1 = IT_KykKihonDetacher.detachKykSyatouched(kykKihon1);

        IT_KykSya kykSya = kykKihon1.getKykSya();

        chkKinouModeHantei();

        uiBean.setKyknmkj(kykSya.getKyknmkj());

        uiBean.setKyknmkn(kykSya.getKyknmkn());

        uiBean.setKykseiymd(kykSya.getKykseiymd());

        uiBean.setTsinyno(kykSya.getTsinyno());

        uiBean.setKyksei(kykSya.getKyksei());

        uiBean.setTsinadr1kj(kykSya.getTsinadr1kj());

        uiBean.setTsinadr2kj(kykSya.getTsinadr2kj());

        uiBean.setTsinadr3kj(kykSya.getTsinadr3kj());

        uiBean.setTsintelno(kykSya.getTsintelno());

        uiBean.setDai2tsintelno(kykSya.getDai2tsintelno());

        uiBean.setDskokno(dsKokyakuKanri.getDskokno());

        uiBean.setDshnnkakcderrorkaisuu(dsLoginKanri.getDshnnkakcderrorkaisuu());

        uiBean.setDskokyakunmerrorkaisuu(dsLoginKanri.getDskokyakunmerrorkaisuu());

        uiBean.setDskokyakuseiymderrorkaisuu(dsLoginKanri.getDskokyakuseiymderrorkaisuu());

        uiBean.setDskokyakutelnoerrorkaisuu(dsLoginKanri.getDskokyakutelnoerrorkaisuu());

        uiBean.setLastjyuuhenymd(kykKihon.getLastjyuuhenymd());

        uiBean.setLastkykmeighnkymd(kykKihon.getLastkykmeighnkymd());

        uiBean.setDskokyakunmkj(dsKokyakuKanri.getDskokyakunmkj());

        uiBean.setDskokyakunmkn(dsKokyakuKanri.getDskokyakunmkn());

        uiBean.setDskokyakuseiymd(dsKokyakuKanri.getDskokyakuseiymd());

        uiBean.setDskokyakuyno(dsKokyakuKanri.getDskokyakuyno());

        uiBean.setDskokyakujtkbn(dsKokyakuKanri.getDskokyakujtkbn());

        uiBean.setDskokyakusakuseiymd(dsKokyakuKanri.getDskokyakusakuseiymd());

        uiBean.setDsteisiriyuukbn(dsKokyakuKanri.getDsteisiriyuukbn());

        uiBean.setDskokyakumukouymd(dsKokyakuKanri.getDskokyakumukouymd());

        uiBean.setDskanyuukeirokbn(dsKokyakuKanri.getDskanyuukeirokbn());

        uiBean.setDskrhnnkakcdsetkbn(dsHonninKakuninCd.getDskrhnnkakcdsetkbn());

        uiBean.setDskrhnnkakcdsetymd(dsHonninKakuninCd.getDskrhnnkakcdsetymd());

        uiBean.setDskrhnnkakcdyuukouymd(dsHonninKakuninCd.getDskrhnnkakcdyuukouymd());

        uiBean.setDskrhnnkakcdttshjyhsymd(dsHonninKakuninCd.getDskrhnnkakcdttshjyhsymd());

        uiBean.setDskrhnnkakcdttyhkbn(dsHonninKakuninCd.getDskrhnnkakcdttyhkbn());

        uiBean.setDshnnkakcdsetymd(dsHonninKakuninCd.getDshnnkakcdsetymd());

        uiBean.setSyokailoginymd(dsLoginKanri.getSyokailoginymd());

        if (!BizUtil.isBlank(dsLoginKanri.getSyokailogintime())) {

            uiBean.setDispsyokailogintime(dsLoginKanri.getSyokailogintime().substring(0, 2) + ":" +
                dsLoginKanri.getSyokailogintime().substring(2, 4) + ":" +
                dsLoginKanri.getSyokailogintime().substring(4, 6));
        }
        else {
            uiBean.setDispsyokailogintime("");
        }

        uiBean.setSyokailoginbaitaikbn(dsLoginKanri.getSyokailoginbaitaikbn());

        uiBean.setSaisinloginymd(dsLoginKanri.getSaisinloginymd());

        if (!BizUtil.isBlank(dsLoginKanri.getSaisinlogintime())) {

            uiBean.setDispsaisinlogintime(dsLoginKanri.getSaisinlogintime().substring(0, 2) + ":" +
                dsLoginKanri.getSaisinlogintime().substring(2, 4) + ":" +
                dsLoginKanri.getSaisinlogintime().substring(4, 6));
        }
        else {
            uiBean.setDispsaisinlogintime("");
        }

        uiBean.setSaisinloginbaitaikbn(dsLoginKanri.getSaisinloginbaitaikbn());

        uiBean.setSeisahuyouhyj(dsKokyakuKanri.getSeisahuyouhyj());

        uiBean.setDsmailaddressrenban(dsMailAddressLst.get(0).getDsmailaddressrenban());

        uiBean.setDsmailaddress(dsMailAddressLst.get(0).getDsmailaddress());

        uiBean.setDsmailsousinjyoutaikbn(dsMailAddressLst.get(0).getDsmailsousinjyoutaikbn());

        uiBean.setDsmailsousintisrykbn(dsMailAddressLst.get(0).getDsmailsousintisrykbn());

        String dskousinymdtime = dsMailAddressLst.get(0).getDskousinymdtime();

        uiBean.setDispdskousinymdtime(editDateYmdHms(dskousinymdtime));

        uiBean.setBeforedskousinymdtimemillihozi(dskousinymdtime);

        uiBean.setUpdatedskousinymdtimemillihozi(dskousinymdtime);

        if (BizUtil.isBlank(dsHonninKakuninCd.getDskrhnnkakcd())) {

            uiBean.setKrpasswordumukbn(C_UmuKbn.NONE);
        }
        else {

            uiBean.setKrpasswordumukbn(C_UmuKbn.ARI);
        }

        if (BizUtil.isBlank(dsHonninKakuninCd.getDshnnkakcd())) {

            uiBean.setHonpasswordumukbn(C_UmuKbn.NONE);
        }
        else {

            uiBean.setHonpasswordumukbn(C_UmuKbn.ARI);
        }


        if (C_DsKinouModeIdKbn.TEISEI.equals(uiBean.getKinouMode())) {

            uiBean.setInputdskokyakunmkj(dsKokyakuKanri.getDskokyakunmkj());

            uiBean.setInputdskokyakunmkn(dsKokyakuKanri.getDskokyakunmkn());

            uiBean.setInputdskokyakuseiymd(dsKokyakuKanri.getDskokyakuseiymd());

            uiBean.setInputdskokyakuyno(dsKokyakuKanri.getDskokyakuyno());

            uiBean.setInputdsteisiriyuukbn(dsKokyakuKanri.getDsteisiriyuukbn());

            uiBean.setInputdskanyuukeirokbn(dsKokyakuKanri.getDskanyuukeirokbn());

            uiBean.setInputdskrhnnkakcdttyhkbn(dsHonninKakuninCd.getDskrhnnkakcdttyhkbn());

            uiBean.setInputseisahuyouhyj(dsKokyakuKanri.getSeisahuyouhyj());

            uiBean.setInputdsmailaddress(dsMailAddressLst.get(0).getDsmailaddress());

            uiBean.setInputdsmailsousinjtkbn(dsMailAddressLst.get(0).getDsmailsousinjyoutaikbn());

            uiBean.setInputdsmailsousintisrykbn(dsMailAddressLst.get(0).getDsmailsousintisrykbn());
        }

        if (C_DsKinouModeIdKbn.ACCOUNTJYOUTAIHENKOU.eq(uiBean.getKinouMode())) {

            uiBean.setInputdsteisiriyuukbn(dsKokyakuKanri.getDsteisiriyuukbn());
        }

        Boolean yuukouKykhyuFlg = false;

        List<DskokkykInfoDataSourceBean> dskokkykInfoDataSourceBeanList = Lists.newArrayList();

        for (int n = 0; n < dsKokyakuKeiyaku.size(); n++) {

            IT_KykKihon kykKihon2 = hozenDomManager.getKykKihon(dsKokyakuKeiyaku.get(n).getSyono());

            kykKihon2 = IT_KykKihonDetacher.detachKykSyouhntouched(kykKihon2);

            IT_KykSyouhn kykSyouhn = kykKihon2.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

            DskokkykInfoDataSourceBean dskokkykInfoDataSourceBean =
                SWAKInjector.getInstance(DskokkykInfoDataSourceBean.class);

            dskokkykInfoDataSourceBean.setSyono(dsKokyakuKeiyaku.get(n).getSyono());

            dskokkykInfoDataSourceBean.setSyusyouhnnm(kykSyouhn.getSyouhnZokusei().getSyouhnnm());

            dskokkykInfoDataSourceBean.setDskykkanyuuymd(dsKokyakuKeiyaku.get(n).getDskykkanyuuymd());

            dskokkykInfoDataSourceBean.setDskykhenkouymd(dsKokyakuKeiyaku.get(n).getDskykhenkouymd());

            dskokkykInfoDataSourceBean.setDskykmukouhyj(dsKokyakuKeiyaku.get(n).getDskykmukouhyj());

            dskokkykInfoDataSourceBean.setDskykmukouymd(dsKokyakuKeiyaku.get(n).getDskykmukouymd());

            if (C_MukouHyj.BLANK.eq(dsKokyakuKeiyaku.get(n).getDskykmukouhyj())) {

                yuukouKykhyuFlg = true;
            }

            dskokkykInfoDataSourceBeanList.add(dskokkykInfoDataSourceBean);
        }

        uiBean.setDskokkykInfo(dskokkykInfoDataSourceBeanList);

        uiBean.setYuukoukykhyuFlg(yuukouKykhyuFlg);
    }

    private void setInputGamenMessageSettei() {

        if (C_DsKinouModeIdKbn.TEISEI.equals(uiBean.getKinouMode())) {

            DsKanyuuYoukenCheck dsKanyuuYoukenCheck = SWAKInjector.getInstance(DsKanyuuYoukenCheck.class);
            if (C_ErrorKbn.ERROR.eq(dsKanyuuYoukenCheck.checkDsKanyuuNenrei(uiBean.getKykseiymd()))) {

                messageManager.addConversationMessageId(KOKSEIBI_INPUTCONTENTS, MessageId.WMF1003);
            }

            if (uiBean.getYuukoukykhyuFlg()) {

                messageManager.addConversationMessageId(KOKSEIBI_INPUTCONTENTS, MessageId.IMF1001);
            }

            if (C_DsKokyakuJtKbn.YUUKOU.eq(uiBean.getDskokyakujtkbn())) {

                messageManager.addConversationMessageId(KOKSEIBI_INPUTCONTENTS, MessageId.IMF1002);
            }
            if (C_DsKokyakuJtKbn.ITIJI_TEISI.eq(uiBean.getDskokyakujtkbn())
                && (C_DsTeisiRiyuuKbn.OMOUSIDE.eq(uiBean.getDsteisiriyuukbn())
                    || C_DsTeisiRiyuuKbn.SONOTA.eq(uiBean.getDsteisiriyuukbn())) && uiBean.getYuukoukykhyuFlg()) {

                messageManager.addConversationMessageId(KOKSEIBI_INPUTCONTENTS, MessageId.IMF1003);
            }

            if (C_DsKokyakuJtKbn.YUUKOU.eq(uiBean.getDskokyakujtkbn()) ||
                C_DsKokyakuJtKbn.ITIJI_TEISI.eq(uiBean.getDskokyakujtkbn())) {

                messageManager.addConversationMessageId(KOKSEIBI_INPUTCONTENTS, MessageId.IMF1004);
            }
        }
    }

    private void setKykbtInputGamenMessageSettei() {

        if (C_UmuKbn.ARI.eq(uiBean.getTrhkservicetourokuumuFlg())) {

            CheckDsTorihikiService checkDsTorihikiService = SWAKInjector.getInstance(CheckDsTorihikiService.class);

            CheckSoukinyoukzResultBean checkSoukinyoukzResultBean = checkDsTorihikiService.checkSoukinyoukz(
                C_Tuukasyu.JPY, uiBean.getBankcd(), uiBean.getSitencd(),
                uiBean.getKzmeiginmkn(), uiBean.getKzdoukbn(), uiBean.getKykbtdispkyknmkn());

            if (C_SoukinyoukzchkkekkaKbn.GINKOUMASTERSONZAI.eq(checkSoukinyoukzResultBean.getSoukinyoukzchkkekkaKbn())) {

                messageManager.addConversationMessageId(KOKSEIBI_KYKBTINPUTCONTENTS, MessageId.WMF1001);
            }
            else if (C_SoukinyoukzchkkekkaKbn.GINKOUYUUKOUHANTEI.eq(checkSoukinyoukzResultBean.getSoukinyoukzchkkekkaKbn())) {

                messageManager.addConversationMessageId(KOKSEIBI_KYKBTINPUTCONTENTS, MessageId.WMF1002);
            }
        }

        if (!C_DsKinouModeIdKbn.SYOUKAI.eq(uiBean.getKinouMode())) {

            messageManager.addConversationMessageId(KOKSEIBI_KYKBTINPUTCONTENTS, MessageId.IMF1014);
        }
    }

    private void setMpaccountjtHenkouGamenSettei() {

        uiBean.setKakunindskokyakunmkj(uiBean.getDskokyakunmkj());

        uiBean.setKakunindskokyakunmkn(uiBean.getDskokyakunmkn());

        uiBean.setKakunindskokyakuseiymd(uiBean.getDskokyakuseiymd());

        uiBean.setKakunindskokyakuyno(uiBean.getDskokyakuyno());

        uiBean.setKakunindskanyuukeirokbn(uiBean.getDskanyuukeirokbn());

        uiBean.setKakunindsmailaddress(uiBean.getDsmailaddress());

        uiBean.setKakuninseisahuyouhyj(uiBean.getSeisahuyouhyj());

        if (DS_KAIYAKU_BTN.equals(uiBean.getSenimotoKbnConfirm())) {
            uiBean.setKakunindskokyakujtkbn(C_DsKokyakuJtKbn.KAIYAKU);
        }
        else {
            uiBean.setKakunindskokyakujtkbn(C_DsKokyakuJtKbn.ITIJI_TEISI);
        }

        if (SERVICE_TEISI_BTN.equals(uiBean.getSenimotoKbnConfirm())) {
            uiBean.setKakunindsteisiriyuukbn(uiBean.getInputdsteisiriyuukbn());
        }
        if (ACCOUNT_LOCK_KAIJYO_BTN.equals(uiBean.getSenimotoKbnConfirm()) ||
            SERVICE_SAIKAI_BTN.equals(uiBean.getSenimotoKbnConfirm())) {
            uiBean.setKakunindsteisiriyuukbn(C_DsTeisiRiyuuKbn.PASSWORD_MITOUROKU);
        }
        if (DS_KAIYAKU_BTN.equals(uiBean.getSenimotoKbnConfirm())) {
            uiBean.setKakunindsteisiriyuukbn(C_DsTeisiRiyuuKbn.BLANK);
        }

        if (ACCOUNT_LOCK_KAIJYO_BTN.equals(uiBean.getSenimotoKbnConfirm()) ||
            SERVICE_SAIKAI_BTN.equals(uiBean.getSenimotoKbnConfirm())) {

            uiBean.setKakunindskokyakumukouymd(null);
            uiBean.setKakuninkrpasswordumukbn(C_UmuKbn.NONE);
            uiBean.setKakunindskrhnnkakcdsetkbn(C_DsKrHnnKakCdSetKbn.SAIHAKKOU);
            uiBean.setKakunindskrhnnkakcdsetymd(null);
            uiBean.setKakunindskrhnnkakcdykymd(null);
            uiBean.setKakuninhonpasswordumukbn(C_UmuKbn.NONE);
            uiBean.setKakunindshnnkakcdsetymd(null);
            uiBean.setKakunindshnnkakcderrkaisuu(0);
            uiBean.setKakunindskoknmerrkaisuu(0);
            uiBean.setKakunindskokseiymderrkaisuu(0);
            uiBean.setKakunindskoktelnoerrkaisuu(0);

        }
        if (SERVICE_TEISI_BTN.equals(uiBean.getSenimotoKbnConfirm()) ||
            DS_KAIYAKU_BTN.equals(uiBean.getSenimotoKbnConfirm())) {

            uiBean.setKakunindskokyakumukouymd(BizDate.getSysDate());
            uiBean.setKakuninkrpasswordumukbn(uiBean.getKrpasswordumukbn());
            uiBean.setKakunindskrhnnkakcdsetkbn(uiBean.getDskrhnnkakcdsetkbn());
            uiBean.setKakunindskrhnnkakcdsetymd(uiBean.getDskrhnnkakcdsetymd());
            uiBean.setKakunindskrhnnkakcdykymd(uiBean.getDskrhnnkakcdyuukouymd());
            uiBean.setKakuninhonpasswordumukbn(uiBean.getHonpasswordumukbn());
            uiBean.setKakunindshnnkakcdsetymd(uiBean.getDshnnkakcdsetymd());
            uiBean.setKakunindshnnkakcderrkaisuu(uiBean.getDshnnkakcderrorkaisuu());
            uiBean.setKakunindskoknmerrkaisuu(uiBean.getDskokyakunmerrorkaisuu());
            uiBean.setKakunindskokseiymderrkaisuu(uiBean.getDskokyakuseiymderrorkaisuu());
            uiBean.setKakunindskoktelnoerrkaisuu(uiBean.getDskokyakutelnoerrorkaisuu());

        }

        if (ACCOUNT_LOCK_KAIJYO_BTN.equals(uiBean.getSenimotoKbnConfirm()) ||
            SERVICE_SAIKAI_BTN.equals(uiBean.getSenimotoKbnConfirm())) {
            uiBean.setKakunindskrhnnkakcdttjyymd(BizDate.getSysDate());
            uiBean.setKakunindskrhnnkakcdttyhkbn(C_DsKrHnnKakCdTtYhKbn.YOU);
        }

        if (SERVICE_TEISI_BTN.equals(uiBean.getSenimotoKbnConfirm())) {
            uiBean.setKakunindskrhnnkakcdttjyymd(uiBean.getDskrhnnkakcdttshjyhsymd());
            uiBean.setKakunindskrhnnkakcdttyhkbn(uiBean.getDskrhnnkakcdttyhkbn());
        }

        if (DS_KAIYAKU_BTN.equals(uiBean.getSenimotoKbnConfirm())) {
            if (C_DsKrHnnKakCdTtYhKbn.YOU.eq(uiBean.getDskrhnnkakcdttyhkbn())) {
                uiBean.setKakunindskrhnnkakcdttjyymd(BizDate.getSysDate());
                uiBean.setKakunindskrhnnkakcdttyhkbn(C_DsKrHnnKakCdTtYhKbn.TYUUDAN);
            }
            else {
                uiBean.setKakunindskrhnnkakcdttjyymd(uiBean.getDskrhnnkakcdttshjyhsymd());
                uiBean.setKakunindskrhnnkakcdttyhkbn(uiBean.getDskrhnnkakcdttyhkbn());
            }
        }

        if (SERVICE_SAIKAI_BTN.equals(uiBean.getSenimotoKbnConfirm())) {
            if (C_DsMailSousinJyoutaiKbn.TEISI.eq(uiBean.getDsmailsousinjyoutaikbn()) &&
                C_DsMailSousinTeisiRiyuuKbn.SERVICETEISI.eq(uiBean.getDsmailsousintisrykbn())) {

                uiBean.setKakunindsmailsousinjtkbn(C_DsMailSousinJyoutaiKbn.YUUKOU);
            }
            else {
                uiBean.setKakunindsmailsousinjtkbn(uiBean.getDsmailsousinjyoutaikbn());
            }
        }
        if (SERVICE_TEISI_BTN.equals(uiBean.getSenimotoKbnConfirm()) ||
            DS_KAIYAKU_BTN.equals(uiBean.getSenimotoKbnConfirm())) {
            if (C_DsMailSousinJyoutaiKbn.YUUKOU.eq(uiBean.getDsmailsousinjyoutaikbn())) {
                uiBean.setKakunindsmailsousinjtkbn(C_DsMailSousinJyoutaiKbn.TEISI);
            }
            else {
                uiBean.setKakunindsmailsousinjtkbn(uiBean.getDsmailsousinjyoutaikbn());
            }
        }
        if (ACCOUNT_LOCK_KAIJYO_BTN.equals(uiBean.getSenimotoKbnConfirm())) {
            uiBean.setKakunindsmailsousinjtkbn(uiBean.getDsmailsousinjyoutaikbn());
        }

        if (SERVICE_SAIKAI_BTN.equals(uiBean.getSenimotoKbnConfirm())) {
            if (C_DsMailSousinJyoutaiKbn.TEISI.eq(uiBean.getDsmailsousinjyoutaikbn()) &&
                C_DsMailSousinTeisiRiyuuKbn.SERVICETEISI.eq(uiBean.getDsmailsousintisrykbn())) {
                uiBean.setKakunindsmailsousintisrykbn(C_DsMailSousinTeisiRiyuuKbn.BLNK);
            }
            else {
                uiBean.setKakunindsmailsousintisrykbn(uiBean.getDsmailsousintisrykbn());
            }
        }
        if (SERVICE_TEISI_BTN.equals(uiBean.getSenimotoKbnConfirm())) {
            if (C_DsMailSousinJyoutaiKbn.YUUKOU.eq(uiBean.getDsmailsousinjyoutaikbn())) {
                uiBean.setKakunindsmailsousintisrykbn(C_DsMailSousinTeisiRiyuuKbn.SERVICETEISI);
            }
            else {
                uiBean.setKakunindsmailsousintisrykbn(uiBean.getDsmailsousintisrykbn());
            }
        }
        if (DS_KAIYAKU_BTN.equals(uiBean.getSenimotoKbnConfirm())) {
            if (C_DsMailSousinJyoutaiKbn.YUUKOU.eq(uiBean.getDsmailsousinjyoutaikbn())) {
                uiBean.setKakunindsmailsousintisrykbn(C_DsMailSousinTeisiRiyuuKbn.DSKAIYAKU);
            }
            else {
                uiBean.setKakunindsmailsousintisrykbn(uiBean.getDsmailsousintisrykbn());
            }
        }
        if (ACCOUNT_LOCK_KAIJYO_BTN.equals(uiBean.getSenimotoKbnConfirm())) {
            uiBean.setKakunindsmailsousintisrykbn(uiBean.getDsmailsousintisrykbn());
        }

        if (!uiBean.getDsmailsousinjyoutaikbn().eq(uiBean.getKakunindsmailsousinjtkbn()) ||
            !uiBean.getDsmailsousintisrykbn().eq(uiBean.getKakunindsmailsousintisrykbn())) {

            String dskousinymdtime = BizDate.getSysDateTimeMilli();

            uiBean.setKakunindskousinymdtime(editDateYmdHms(dskousinymdtime));

            uiBean.setUpdatedskousinymdtimemillihozi(dskousinymdtime);
        }
        else {
            uiBean.setKakunindskousinymdtime(uiBean.getDispdskousinymdtime());

            uiBean.setUpdatedskousinymdtimemillihozi(uiBean.getBeforedskousinymdtimemillihozi());
        }
    }

    public String editDateYmdHms(String pSyorYmdHms) {

        StringBuffer syoriTime = new StringBuffer("");

        if (pSyorYmdHms != null && pSyorYmdHms.length() >= 14) {

            SeirekiWarekiKbn kbn = BizDateConfig.getInstance().getSeirekiWarekiKbn();
            switch (kbn) {
                case SEIREKI:
                    syoriTime.append(new BizDateFormat("yyyy/MM/dd", FillStyle.Zero).format(
                        BizDate.valueOf(pSyorYmdHms.substring(0, 8))));
                    break;
                case WAREKI_SYMBOL:
                case WAREKI_KANJI:
                case WAREKI_INPUT:
                default:
                    syoriTime.append(new BizDateFormat("Gyy/MM/dd", FillStyle.Zero).format(
                        BizDate.valueOf(pSyorYmdHms.substring(0, 8))));
            }

            syoriTime.append(HANKAKU_SPACE);
            syoriTime.append(pSyorYmdHms.substring(8, 10));
            syoriTime.append(COLON);
            syoriTime.append(pSyorYmdHms.substring(10, 12));
            syoriTime.append(COLON);
            syoriTime.append(pSyorYmdHms.substring(12, 14));
        }

        return syoriTime.toString();
    }
}
