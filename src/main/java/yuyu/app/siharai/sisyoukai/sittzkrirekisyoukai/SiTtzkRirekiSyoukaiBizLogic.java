package yuyu.app.siharai.sisyoukai.sittzkrirekisyoukai;

import static yuyu.app.siharai.sisyoukai.sittzkrirekisyoukai.GenSiTtzkRirekiSyoukaiConstants.*;
import static yuyu.app.siharai.sisyoukai.sittzkrirekisyoukai.SiTtzkRirekiSyoukaiConstants.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.siharai.kyk.KeiyakuInfoSyutoku;
import yuyu.common.siharai.kyk.KeiyakuPrm;
import yuyu.common.siharai.sicommon.TeisuuSiharai;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_Hkuktsyu;
import yuyu.def.classification.C_NayoseYouhi;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_SibouKariUketukeSyoriKbn;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AS_KinouMode;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.JT_SateiSyouninRireki;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_SiUkt;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.db.entity.JT_TtdkRireki;
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.def.siharai.result.bean.SkKihonInfosBySyonoHhknnmknSeikyuusyubetuSyoruiukeymdSeikyuurirekinoMaxBean;
import yuyu.def.siharai.sorter.SortJT_TtdkRireki;

/**
 * 手続履歴照会 のビジネスロジックです。
 */
public class SiTtzkRirekiSyoukaiBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private SiTtzkRirekiSyoukaiUiBean uiBean;

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @Inject
    private BaseDomManager baseDomManager;

    @Inject
    private BizDomManager bizDomManager;

    void init() {
        BizPropertyInitializer.initialize(uiBean);
    }

    void clear() {
    }

    void pushSearchBL() {
        if (BizUtil.isBlank(uiBean.getSrchsyono()) &&
            BizUtil.isBlank(uiBean.getSrchhhknnmkn()) &&
            C_SeikyuuSyubetu.BLNK.eq(uiBean.getSrchsksyubetu()) &&
            uiBean.getSrchsyoruiukeymdfrom() == null &&
            uiBean.getSrchsyoruiukeymdto() == null)

        {
            throw new BizLogicException(MessageId.EBC0043, "全ての条件");
        }

        BizDate sysDate = BizDate.getSysDate();

        if (uiBean.getSrchsyoruiukeymdfrom() != null) {
            if (BizDateUtil.compareYmd(uiBean.getSrchsyoruiukeymdfrom(), sysDate) == BizDateUtil.COMPARE_GREATER) {
                throw new BizLogicException(MessageId.EBF0124,
                    MessageUtil.getMessage(DDID_HKTSKKIHONINFO_SYORUIUKEYMD.getErrorResourceKey()));
            }
        }

        if (uiBean.getSrchsyoruiukeymdfrom() != null
            && uiBean.getSrchsyoruiukeymdto() != null) {
            if (BizDateUtil.compareYmd(uiBean.getSrchsyoruiukeymdfrom(), uiBean.getSrchsyoruiukeymdto()) == BizDateUtil.COMPARE_GREATER) {
                throw new BizLogicException(MessageId.EJA0051,
                    MessageUtil.getMessage(DDID_HKTSKKIHONINFO_SYORUIUKEYMD.getErrorResourceKey()));
            }
        }

        List<SkKihonInfosBySyonoHhknnmknSeikyuusyubetuSyoruiukeymdSeikyuurirekinoMaxBean> skBeanList = siharaiDomManager.getSkKihonInfosBySyonoHhknnmknSeikyuusyubetuSyoruiukeymdSeikyuurirekinoMax(
            uiBean.getSrchsyono(),
            uiBean.getSrchhhknnmkn(),
            uiBean.getSrchsksyubetu(),
            uiBean.getSrchsyoruiukeymdfrom(),
            uiBean.getSrchsyoruiukeymdto());

        if (skBeanList.size() == 0) {
            throw new BizLogicException(MessageId.EBA0024, "手続履歴");
        }

        if (skBeanList.size() > DATA_LIMIT_COUNT) {
            throw new BizLogicException(MessageId.EBA0053, String.valueOf(DATA_LIMIT_COUNT));
        }

        List<SearchResultsDataSourceBean> searchResultsBeanList = new ArrayList<SearchResultsDataSourceBean>();

        for (SkKihonInfosBySyonoHhknnmknSeikyuusyubetuSyoruiukeymdSeikyuurirekinoMaxBean skKihonInfosBySyonoHhknnmknSeikyuusyubetuSyoruiukeymdSeikyuurirekinoMaxBean : skBeanList) {
            JT_SkKihon skKihon = skKihonInfosBySyonoHhknnmknSeikyuusyubetuSyoruiukeymdSeikyuurirekinoMaxBean.getSkKihon();
            BizDate wsyoruiukeymd = null;
            if (skKihon.getSks().size() != 0) {
                wsyoruiukeymd = skKihon.getSks().get(0).getSyoruiukeymd();
            }

            SearchResultsDataSourceBean searchResultsBean = new SearchResultsDataSourceBean();

            searchResultsBean.setDispskno(skKihon.getSkno());
            searchResultsBean.setDispsyono(skKihon.getSyono());
            searchResultsBean.setDisphhknnmkn(skKihon.getHhknnmkn());
            searchResultsBean.setDisphhknnmkj(skKihon.getHhknnmkj());
            searchResultsBean.setDispsksyubetu(skKihon.getSeikyuusyubetu());
            searchResultsBean.setDispsyoruiukeymd(wsyoruiukeymd);

            searchResultsBeanList.add(searchResultsBean);
        }

        uiBean.setSearchResults(searchResultsBeanList);
    }

    void pushSyoukenLink() {
        SearchResultsDataSourceBean searchResultsBean = uiBean.getSearchResultsDataSource().getSelectedBean();

        KeiyakuInfoSyutoku keiyakuInfoSyutoku = SWAKInjector.getInstance(KeiyakuInfoSyutoku.class);
        KeiyakuPrm keiyakuPrm = SWAKInjector.getInstance(KeiyakuPrm.class);
        keiyakuPrm.setINayoseyh(C_NayoseYouhi.HUYOU);
        keiyakuPrm.setSyono(searchResultsBean.getDispsyono());

        keiyakuInfoSyutoku.getInfos(keiyakuPrm);

        List<JT_SiKykKihon> siKykKihonLst = keiyakuInfoSyutoku.getKykKihons();

        String uktnmkn = "";
        String uktnmkj = "";

        if (siKykKihonLst.get(0) == null) {
            throw new BizAppException(MessageId.EBS0004, "JT_SiKykKihon", "syono", String.valueOf(searchResultsBean.getDispsyono()));
        }

        if (C_SeikyuuSyubetu.SB.eq(searchResultsBean.getDispsksyubetu())
            || C_SeikyuuSyubetu.SBKRUKTK.eq(searchResultsBean.getDispsksyubetu())) {
            int sbHkkUktuketorininCount = siKykKihonLst.get(0).getSbuktnin();

            if (sbHkkUktuketorininCount == 1) {
                for (JT_SiUkt jT_SiUkts : siKykKihonLst.get(0).getSiUkts()) {
                    if (C_Hkuktsyu.SBHKKUKT.eq(jT_SiUkts.getHkuktsyu())) {
                        uktnmkn = jT_SiUkts.getUktnmkn();
                        uktnmkj = jT_SiUkts.getUktnmkj();
                        break;
                    }
                }
            }

            if (sbHkkUktuketorininCount > 1) {
                uktnmkn = UKETORININFUKUSUUJIRETU;
            }
        }

        else {
            uktnmkn = "";
            uktnmkj = "";
        }

        uiBean.setSyono(searchResultsBean.getDispsyono());
        uiBean.setHhknnmkn(searchResultsBean.getDisphhknnmkn());
        uiBean.setHhknnmkj(searchResultsBean.getDisphhknnmkj());
        uiBean.setUktnmkn(uktnmkn);
        uiBean.setUktnmkj(uktnmkj);
        uiBean.setSeikyuusyubetu(searchResultsBean.getDispsksyubetu());
        uiBean.setSyoruiukeymd(searchResultsBean.getDispsyoruiukeymd());
        uiBean.setSkno(searchResultsBean.getDispskno());

        uiBean.setKouteikanriid("");

        String jimutetuzukicd = "";
        if (C_SeikyuuSyubetu.SB.eq(uiBean.getSeikyuusyubetu())) {
            jimutetuzukicd = TeisuuSiharai.JIMUTETUZUKICD_SISIBOU;
        }
        if (!"".equals(jimutetuzukicd)) {
            List<BT_GyoumuKouteiInfo> gyoumuKouteiInfoLst = bizDomManager
                .getGyoumuKouteiInfosByJimutetuzukicdSyonoSkno(jimutetuzukicd, uiBean.getSyono(), uiBean.getSkno());
            if (gyoumuKouteiInfoLst.size() != 0) {
                uiBean.setKouteikanriid(gyoumuKouteiInfoLst.get(0).getKouteikanriid());
            }
        }

        JT_SkKihon skKihon = siharaiDomManager.getSkKihon(uiBean.getSkno(), uiBean.getSyono());
        if (skKihon == null) {
            throw new BizLogicException(MessageId.EBA0024, "手続履歴");
        }

        List<JT_TtdkRireki> ttdkRirekiList = new SortJT_TtdkRireki().OrderJT_TtdkRirekiByGyoumuKousinTimeDesc(skKihon.getTtdkRirekis());

        if (ttdkRirekiList.size() == 0) {
            throw new BizLogicException(MessageId.EBA0024, "手続履歴");
        }

        List<TtzkRrkListDataSourceBean> ttzkRrkListBeanList = new ArrayList<TtzkRrkListDataSourceBean>();

        for (JT_TtdkRireki ttdkRireki : ttdkRirekiList) {
            TtzkRrkListDataSourceBean ttzkRrkListBean = new TtzkRrkListDataSourceBean();

            AS_KinouMode kinouMode = baseDomManager.getKinou(ttdkRireki.getKossyoricd()).
                getKinouMode(ttdkRireki.getKossyorisscd());

            if (kinouMode == null) {
                throw new CommonBizAppException("機能モード基幹テーブルの取得に失敗しました。");
            }

            ttzkRrkListBean.setDispsyorinm(kinouMode.getKinouModeNm());
            ttzkRrkListBean.setKinouId(ttdkRireki.getKossyoricd());
            ttzkRrkListBean.setKinouModeId(ttdkRireki.getKossyorisscd());
            ttzkRrkListBean.setSeiRrkNo(ttdkRireki.getSeikyuurirekino());

            if (!SIHARAI_HUSIHARAI.equals(kinouMode.getKinouId()) &&
                !DNPRENDOU.equals(kinouMode.getKinouId()) &&
                !JIKOUSYOUMETU.equals(kinouMode.getKinouId())) {
                ttzkRrkListBean.setSyousaiLink(MessageUtil.
                    getMessage(DDID_TTZKRRKLIST_SYOUSAILINK.getErrorResourceKey()));
            }

            AM_User user = baseDomManager.getUser(ttdkRireki.getGyoumuKousinsyaId());
            if (user != null) {
                ttzkRrkListBean.setDisptantounm(user.getUserNm());
            }

            if (!BizUtil.isBlank(ttdkRireki.getSateisyouninskbtkey())) {
                JT_SateiSyouninRireki sateiSyouninRireki = skKihon
                    .getSateiSyouninRirekiBySateisyouninskbtkey(ttdkRireki.getSateisyouninskbtkey());

                ttzkRrkListBean.setSyorikekka(sateiSyouninRireki.getSyorikekkakbn().getContent());
            }

            if (BizUtil.isBlank(ttdkRireki.getSateisyouninskbtkey())) {
                if (C_SeikyuuSyubetu.SBKRUKTK.eq(skKihon.getSeikyuusyubetu())) {
                    if (ttdkRirekiList.size() == 2) {
                        if (!(ttdkRireki.getKossyoricd().equals(SIBOUKARIUKETUKE))) {
                            ttzkRrkListBean.setSyorikekka(null);
                        }

                        else if (ttdkRireki.getTtdkrrkskbtkey().equals(ttdkRirekiList.get(0).getTtdkrrkskbtkey())) {
                            ttzkRrkListBean.setSyorikekka(SBKRUKTKTRIKESI);

                            ttzkRrkListBean.setSibouKariUketukeSyoriKbn(C_SibouKariUketukeSyoriKbn.TORIKESI);
                        }

                        else {
                            ttzkRrkListBean.setSyorikekka(SBKRUKTKTOUROKU);

                            ttzkRrkListBean.setSibouKariUketukeSyoriKbn(C_SibouKariUketukeSyoriKbn.TOUROKU);
                        }
                    }

                    else {
                        ttzkRrkListBean.setSyorikekka(SBKRUKTKTOUROKU);

                        ttzkRrkListBean.setSibouKariUketukeSyoriKbn(C_SibouKariUketukeSyoriKbn.TOUROKU);
                    }
                }
                else{
                    ttzkRrkListBean.setSyorikekka("");
                }
            }

            String syanaiComment = ttdkRireki.getSyanaicomment();

            if (syanaiComment != null && syanaiComment.length() > MOJISUU) {
                syanaiComment = syanaiComment.substring(0, MOJISUU);
            }
            ttzkRrkListBean.setDispcomment(syanaiComment);

            ttzkRrkListBean.setDispttdkrrkskbtkey(ttdkRireki.getTtdkrrkskbtkey());
            ttzkRrkListBean.setDispsyoriymd(ttdkRireki.getSyoriYmd());
            ttzkRrkListBeanList.add(ttzkRrkListBean);
        }

        uiBean.setTtzkRrkList(ttzkRrkListBeanList);
    }

    String pushSyousaiBL() {
        TtzkRrkListDataSourceBean ttzkRrkListBean = null;
        int count = 0;
        for (TtzkRrkListDataSourceBean ttzkRrkListDataSourceBean : uiBean.getTtzkRrkListDataSource().getAllData()) {
            if (uiBean.getDispttdkrrkskbtkey().equals(ttzkRrkListDataSourceBean.getDispttdkrrkskbtkey())) {
                ttzkRrkListBean = ttzkRrkListDataSourceBean;
                uiBean.setSntkgyouno(count);
                uiBean.setSibouKariUketukeSyoriKbn(ttzkRrkListDataSourceBean.getSibouKariUketukeSyoriKbn());
                break;
            }

            count++;
        }

        if (TeisuuSiharai.SISIBOUKARIUKETUKE.equals(ttzkRrkListBean.getKinouId())) {
            return FORWARDNAME_GOTOSIBOUKARIUKETUKEKAKUNNINGAMEN;
        }

        else if (TeisuuSiharai.SIMOUSIDEUKETUKE.equals(ttzkRrkListBean.getKinouId())) {
            return FORWARDNAME_GOTOSIMOUSIDEUKETUKEKAKUNNINGAMEN;
        }

        else if (TeisuuSiharai.SISEIKYUUUKETUKESB.equals(ttzkRrkListBean.getKinouId())) {
            return FORWARDNAME_GOTOSEIKYUUUKETUKESBKAKUNNINGAMEN;
        }

        else if (TeisuuSiharai.SISATEISB.equals(ttzkRrkListBean.getKinouId())) {
            return FORWARDNAME_GOTOSISATEISBKAKUNNINGAMEN;
        }
        else if (TeisuuSiharai.SISINDANSYORYOUSIHARAI.equals(ttzkRrkListBean.getKinouId())) {
            return FORWARDNAME_GOTOSISINDANSYORYOUSIHARAIKAKUNNINGAMEN;
        }

        else if (TeisuuSiharai.SISYOUNINTORIKESI.equals(ttzkRrkListBean.getKinouId())) {
            return FORWARDNAME_GOTOSISYOUNINTORIKESIKAKUNNINGAMEN;
        }

        else {
            return null;
        }
    }
}