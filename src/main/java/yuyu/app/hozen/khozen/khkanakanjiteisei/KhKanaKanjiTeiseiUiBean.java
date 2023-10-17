package yuyu.app.hozen.khozen.khkanakanjiteisei;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutaiExecUiBeanParam;
import yuyu.common.hozen.khview.viewbetukyk.ViewBetukykUiBeanParam;
import yuyu.common.hozen.khview.viewkihon.ViewKihonUiBeanParam;
import yuyu.common.hozen.khview.viewtetudukityuui.ViewTetudukityuuiUiBeanParam;
import yuyu.common.hozen.khview.viewtrkkazoku.ViewTrkKazokuUiBeanParam;
import yuyu.common.hozen.setuibean.KikeiyakuInfoDataSourceBeanCommonParam;
import yuyu.common.hozen.setuibean.NenkinsiharaiInfoDataSourceBeanCommonParam;
import yuyu.common.hozen.setuibean.PalNenkinsiharaiInfoDataSourceBeanCommonParam;
import yuyu.common.hozen.setuibean.PalkikeiyakuInfoDataSourceBeanCommonParam;
import yuyu.common.hozen.setuibean.PalsueokiInfoDataSourceBeanCommonParam;
import yuyu.common.hozen.setuibean.SetBetukykExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetHihokensyaExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetKeiyakusyaExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetKihonExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetNkuktExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetSbHkuktExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetSiteiseikyuuExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetTetudukityuuiExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetToriatukaiTyuuiExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetTrkKazokuExecUiBeanParam;
import yuyu.common.hozen.setuibean.TtdktyuuikbnInfoDataSourceBeanCommonParam;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KykKihon;

import com.google.common.collect.Lists;

/**
 * 仮名漢字訂正 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class KhKanaKanjiTeiseiUiBean extends GenKhKanaKanjiTeiseiUiBean implements CheckYuukouJyoutaiExecUiBeanParam,
SetToriatukaiTyuuiExecUiBeanParam, SetKihonExecUiBeanParam, SetBetukykExecUiBeanParam, SetTetudukityuuiExecUiBeanParam,
SetKeiyakusyaExecUiBeanParam, SetHihokensyaExecUiBeanParam, SetNkuktExecUiBeanParam, SetSbHkuktExecUiBeanParam,
SetSiteiseikyuuExecUiBeanParam, SetTrkKazokuExecUiBeanParam, ViewKihonUiBeanParam, ViewBetukykUiBeanParam,
ViewTetudukityuuiUiBeanParam, ViewTrkKazokuUiBeanParam {

    private static final long serialVersionUID = 1L;

    public KhKanaKanjiTeiseiUiBean() {
    }

    private C_UmuKbn kykUmuKbn;

    public C_UmuKbn getKykUmuKbn() {
        return kykUmuKbn;
    }

    public void setKykUmuKbn(C_UmuKbn pKykUmuKbn) {
        kykUmuKbn = pKykUmuKbn;
    }

    private C_UmuKbn vhhkUmuKbn;

    public C_UmuKbn getVhhkUmuKbn() {
        return vhhkUmuKbn;
    }

    public void setVhhkUmuKbn(C_UmuKbn pVhhkUmuKbn) {
        vhhkUmuKbn = pVhhkUmuKbn;
    }

    private C_UmuKbn vnkuknenkinUmuKbn;

    public C_UmuKbn getVnkuknenkinUmuKbn() {
        return vnkuknenkinUmuKbn;
    }

    public void setVnkuknenkinUmuKbn(C_UmuKbn pVnkuknenkinUmuKbn) {
        vnkuknenkinUmuKbn = pVnkuknenkinUmuKbn;
    }

    private C_UmuKbn sbuktUmuKbn1;

    public C_UmuKbn getSbuktUmuKbn1() {
        return sbuktUmuKbn1;
    }

    public void setSbuktUmuKbn1(C_UmuKbn pSbuktUmuKbn1) {
        sbuktUmuKbn1 = pSbuktUmuKbn1;
    }

    private C_UmuKbn sbuktUmuKbn2;

    public C_UmuKbn getSbuktUmuKbn2() {
        return sbuktUmuKbn2;
    }

    public void setSbuktUmuKbn2(C_UmuKbn pSbuktUmuKbn2) {
        sbuktUmuKbn2 = pSbuktUmuKbn2;
    }

    private C_UmuKbn sbuktUmuKbn3;

    public C_UmuKbn getSbuktUmuKbn3() {
        return sbuktUmuKbn3;
    }

    public void setSbuktUmuKbn3(C_UmuKbn pSbuktUmuKbn3) {
        sbuktUmuKbn3 = pSbuktUmuKbn3;
    }

    private C_UmuKbn sbuktUmuKbn4;

    public C_UmuKbn getSbuktUmuKbn4() {
        return sbuktUmuKbn4;
    }

    public void setSbuktUmuKbn4(C_UmuKbn pSbuktUmuKbn4) {
        sbuktUmuKbn4 = pSbuktUmuKbn4;
    }

    private C_UmuKbn stdrskUmuKbn;

    public C_UmuKbn getStdrskUmuKbn() {
        return stdrskUmuKbn;
    }

    public void setStdrskUmuKbn(C_UmuKbn pStdrskUmuKbn) {
        stdrskUmuKbn = pStdrskUmuKbn;
    }

    private C_UmuKbn kzmeigiUmuKbn;

    public C_UmuKbn getKzmeigiUmuKbn() {
        return kzmeigiUmuKbn;
    }

    public void setKzmeigiUmuKbn(C_UmuKbn pKzmeigiUmuKbn) {
        kzmeigiUmuKbn = pKzmeigiUmuKbn;
    }

    private C_UmuKbn kzUmuKbn;

    public C_UmuKbn getKzUmuKbn() {
        return kzUmuKbn;
    }

    public void setKzUmuKbn(C_UmuKbn pKzUmuKbn) {
        kzUmuKbn = pKzUmuKbn;
    }

    private String syono;

    @Override
    public String getSyono() {
        return syono;
    }

    @Override
    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    private C_UmuKbn vshktsbhkuktumu;

    public C_UmuKbn getVshktsbhkuktumu() {
        return vshktsbhkuktumu;
    }

    @Override
    public void setVshktsbhkuktumu(C_UmuKbn pVshktsbhkuktumu) {
        vshktsbhkuktumu = pVshktsbhkuktumu;
    }

    private C_UmuKbn vshktsbkyuuhukinuktumu;

    public C_UmuKbn getVshktsbkyuuhukinuktumu() {
        return vshktsbkyuuhukinuktumu;
    }

    @Override
    public void setVshktsbkyuuhukinuktumu(C_UmuKbn pVshktsbkyuuhukinuktumu) {
        vshktsbkyuuhukinuktumu = pVshktsbkyuuhukinuktumu;
    }

    private List<String> warningMessageIdList;

    public List<String> getWarningMessageIdList() {
        return warningMessageIdList;
    }

    @Override
    public void setWarningMessageIdList(List<String> pWarningMessageIdList) {
        warningMessageIdList = pWarningMessageIdList;
    }

    private List<String> warningMessageList;

    public List<String> getWarningMessageList() {
        return warningMessageList;
    }

    @Override
    public void setWarningMessageList(List<String> pWarningMessageList) {
        warningMessageList = pWarningMessageList;
    }

    @Inject
    private IT_KykKihon kykKihon;

    public IT_KykKihon getKykKihon() {
        return kykKihon;
    }

    public void setKykKihon(IT_KykKihon pKykKihon) {
        kykKihon = pKykKihon;
    }

    private C_UktKbn vshktdispsbuktkbn2;

    public C_UktKbn getVshktdispsbuktkbn2() {
        return vshktdispsbuktkbn2;
    }

    @Override
    public void setVshktdispsbuktkbn2(C_UktKbn pVshktdispsbuktkbn2) {
        vshktdispsbuktkbn2 = pVshktdispsbuktkbn2;
    }

    private C_UktKbn vshktdispsbuktkbn3;

    public C_UktKbn getVshktdispsbuktkbn3() {
        return vshktdispsbuktkbn3;
    }

    @Override
    public void setVshktdispsbuktkbn3(C_UktKbn pVshktdispsbuktkbn3) {
        vshktdispsbuktkbn3 = pVshktdispsbuktkbn3;
    }

    private C_UktKbn vshktdispsbuktkbn4;

    public C_UktKbn getVshktdispsbuktkbn4() {
        return vshktdispsbuktkbn4;
    }

    @Override
    public void setVshktdispsbuktkbn4(C_UktKbn pVshktdispsbuktkbn4) {
        vshktdispsbuktkbn4 = pVshktdispsbuktkbn4;
    }

    private Integer vshktsbuktsyurenno1;

    public Integer getVshktsbuktsyurenno1() {
        return vshktsbuktsyurenno1;
    }

    @Override
    public void setVshktsbuktsyurenno1(Integer pVshktsbuktsyurenno1) {
        vshktsbuktsyurenno1 = pVshktsbuktsyurenno1;
    }

    private Integer vshktsbuktsyurenno2;

    public Integer getVshktsbuktsyurenno2() {
        return vshktsbuktsyurenno2;
    }

    @Override
    public void setVshktsbuktsyurenno2(Integer pVshktsbuktsyurenno2) {
        vshktsbuktsyurenno2 = pVshktsbuktsyurenno2;
    }

    private Integer vshktsbuktsyurenno3;

    public Integer getVshktsbuktsyurenno3() {
        return vshktsbuktsyurenno3;
    }

    @Override
    public void setVshktsbuktsyurenno3(Integer pVshktsbuktsyurenno3) {
        vshktsbuktsyurenno3 = pVshktsbuktsyurenno3;
    }

    private Integer vshktsbuktsyurenno4;

    public Integer getVshktsbuktsyurenno4() {
        return vshktsbuktsyurenno4;
    }

    @Override
    public void setVshktsbuktsyurenno4(Integer pVshktsbuktsyurenno4) {
        vshktsbuktsyurenno4 = pVshktsbuktsyurenno4;
    }

    @Override
    public KikeiyakuInfoDataSourceBeanCommonParam createKikeiyakuInfoDataSourceBean() {

        return new KikeiyakuInfoDataSourceBean();
    }

    @Override
    public void convertKikeiyakuInfoForCommonParam(List<KikeiyakuInfoDataSourceBeanCommonParam> pKikeiyakuInfo) {
        List<KikeiyakuInfoDataSourceBean> kikeiyakuInfo = Lists.newArrayList();

        for (KikeiyakuInfoDataSourceBeanCommonParam beanPram : pKikeiyakuInfo) {
            kikeiyakuInfo.add((KikeiyakuInfoDataSourceBean)beanPram);
        }

        super.setKikeiyakuInfo(kikeiyakuInfo);
    }

    @Override
    public NenkinsiharaiInfoDataSourceBeanCommonParam createNenkinsiharaiInfoDataSourceBean() {

        return new NenkinsiharaiInfoDataSourceBean();
    }

    @Override
    public void convertNenkinsiharaiInfoForCommonParam
    (List<NenkinsiharaiInfoDataSourceBeanCommonParam> pNenkinsiharaiInfo) {
        List<NenkinsiharaiInfoDataSourceBean> nenkinsiharaiInfo = Lists.newArrayList();

        for (NenkinsiharaiInfoDataSourceBeanCommonParam beanPram : pNenkinsiharaiInfo) {
            nenkinsiharaiInfo.add((NenkinsiharaiInfoDataSourceBean)beanPram);
        }

        super.setNenkinsiharaiInfo(nenkinsiharaiInfo);
    }

    @Override
    public PalkikeiyakuInfoDataSourceBeanCommonParam createPalkikeiyakuInfoDataSourceBean() {

        return new PalkikeiyakuInfoDataSourceBean();
    }

    @Override
    public void convertPalkikeiyakuInfoForCommonParam(
        List<PalkikeiyakuInfoDataSourceBeanCommonParam> pPalkikeiyakuInfo) {
        List<PalkikeiyakuInfoDataSourceBean> palkikeiyakuInfo = Lists.newArrayList();

        for (PalkikeiyakuInfoDataSourceBeanCommonParam beanPram : pPalkikeiyakuInfo) {
            palkikeiyakuInfo.add((PalkikeiyakuInfoDataSourceBean)beanPram);
        }

        super.setPalkikeiyakuInfo(palkikeiyakuInfo);
    }

    @Override
    public PalNenkinsiharaiInfoDataSourceBeanCommonParam createPalNenkinsiharaiInfoDataSourceBean() {

        return new PalnenkinsiharaiInfoDataSourceBean();
    }

    @Override
    public void convertPalNenkinsiharaiInfoForCommonParam(
        List<PalNenkinsiharaiInfoDataSourceBeanCommonParam> pPalNenkinsiharaiInfo) {
        List<PalnenkinsiharaiInfoDataSourceBean> palNenkinsiharaiInfo = Lists.newArrayList();

        for (PalNenkinsiharaiInfoDataSourceBeanCommonParam beanPram : pPalNenkinsiharaiInfo) {
            palNenkinsiharaiInfo.add((PalnenkinsiharaiInfoDataSourceBean)beanPram);
        }

        super.setPalnenkinsiharaiInfo(palNenkinsiharaiInfo);
    }

    @Override
    public PalsueokiInfoDataSourceBeanCommonParam createPalsueokiInfoDataSourceBean() {

        return new PalsueokiInfoDataSourceBean();
    }

    @Override
    public void convertPalsueokiInfoForCommonParam(
        List<PalsueokiInfoDataSourceBeanCommonParam> pPalsueokiInfo) {
        List<PalsueokiInfoDataSourceBean> palsueokiInfo = Lists.newArrayList();

        for (PalsueokiInfoDataSourceBeanCommonParam beanPram : pPalsueokiInfo) {
            palsueokiInfo.add((PalsueokiInfoDataSourceBean)beanPram);
        }

        super.setPalsueokiInfo(palsueokiInfo);
    }

    @Override
    public TtdktyuuikbnInfoDataSourceBeanCommonParam createTtdktyuuikbnInfoDataSourceBean() {

        return new TtdktyuuikbnInfoDataSourceBean();
    }

    @Override
    public void convertTtdktyuuikbnInfoForCommonParam(
        List<TtdktyuuikbnInfoDataSourceBeanCommonParam> pTtdktyuuikbnInfo) {
        List<TtdktyuuikbnInfoDataSourceBean> ttdktyuuikbnInfo = Lists.newArrayList();

        for (TtdktyuuikbnInfoDataSourceBeanCommonParam beanPram : pTtdktyuuikbnInfo) {
            ttdktyuuikbnInfo.add((TtdktyuuikbnInfoDataSourceBean)beanPram);
        }

        super.setTtdktyuuikbnInfo(ttdktyuuikbnInfo);
    }

}
