package yuyu.app.hozen.khansyuu.khonlinenyuukin;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutaiExecUiBeanParam;
import yuyu.common.hozen.khview.viewbetukyk.ViewBetukykUiBeanParam;
import yuyu.common.hozen.khview.viewdattai.ViewDattaiUiBeanParam;
import yuyu.common.hozen.khview.viewharaikomiinfo.ViewHaraikomiInfoUiBeanParam;
import yuyu.common.hozen.khview.viewkeiyakusya.ViewKeiyakusyaUiBeanParam;
import yuyu.common.hozen.khview.viewkihon.ViewKihonUiBeanParam;
import yuyu.common.hozen.khview.viewtetudukityuui.ViewTetudukityuuiUiBeanParam;
import yuyu.common.hozen.khview.viewtokusin.ViewTokusinUiBeanParam;
import yuyu.common.hozen.setuibean.KikeiyakuInfoDataSourceBeanCommonParam;
import yuyu.common.hozen.setuibean.NenkinsiharaiInfoDataSourceBeanCommonParam;
import yuyu.common.hozen.setuibean.PalNenkinsiharaiInfoDataSourceBeanCommonParam;
import yuyu.common.hozen.setuibean.PalkikeiyakuInfoDataSourceBeanCommonParam;
import yuyu.common.hozen.setuibean.PalsueokiInfoDataSourceBeanCommonParam;
import yuyu.common.hozen.setuibean.SetBetukykExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetDattaiExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetHaraikomiInfoExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetKeiyakusyaExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetKihonExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetTetudukityuuiExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetTokusinExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetToriatukaiTyuuiExecUiBeanParam;
import yuyu.common.hozen.setuibean.TtdktyuuikbnInfoDataSourceBeanCommonParam;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KykKihon;

import com.google.common.collect.Lists;

/**
 * オンライン入金処理 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class KhOnlineNyuukinUiBean extends GenKhOnlineNyuukinUiBean implements SetToriatukaiTyuuiExecUiBeanParam,
CheckYuukouJyoutaiExecUiBeanParam, SetKihonExecUiBeanParam, SetBetukykExecUiBeanParam, SetTetudukityuuiExecUiBeanParam,
SetKeiyakusyaExecUiBeanParam, ViewKihonUiBeanParam, ViewBetukykUiBeanParam, ViewTetudukityuuiUiBeanParam, ViewKeiyakusyaUiBeanParam,
ViewHaraikomiInfoUiBeanParam,SetHaraikomiInfoExecUiBeanParam,SetTokusinExecUiBeanParam,ViewTokusinUiBeanParam,
SetDattaiExecUiBeanParam,ViewDattaiUiBeanParam{

    private static final long serialVersionUID = 1L;

    public KhOnlineNyuukinUiBean() {
    }

    @Inject
    private IT_KykKihon kykKihon;

    private C_UmuKbn nextkosumu;

    private C_UmuKbn tyouhyoumukbn;

    private String tyouhyoukey;

    private List<String>  warningMessageIdList;

    private List<String>  warningMessageList;

    private String syono;

    private String henkouSikibetuKey;

    private C_UmuKbn iktNyuukinnUmu;

    private C_Hrkkaisuu hrkkaisuuSyoriyou;

    private C_TkiktbrisyuruiKbn tikiktbrisyuruikbnSyoriyou;

    private C_Nykkeiro nykkeiroSyoriyou;

    private C_NyknaiyouKbn nyknaiyoukbnSyoriyou;

    private BizDateYM jyuutouymSyoriyou;

    private Integer jyutoukaisuuySyoriyou;

    private Integer jyutoukaisuumSyoriyou;

    private BizCurrency rsgakuSyoriyou;

    private BizDate ryosyuymdSyoriyou;

    private C_UmuKbn yennykntkhkumu;

    private C_Tuukasyu kyktuukasyu;

    private String creditkessaiyouno;

    public C_UmuKbn getTyouhyoumukbn() {
        return tyouhyoumukbn;
    }

    public void setTyouhyoumukbn(C_UmuKbn pTyouhyoumukbn) {
        this.tyouhyoumukbn = pTyouhyoumukbn;
    }

    public String getTyouhyoukey() {
        return tyouhyoukey;
    }

    public void setTyouhyoukey(String pTyouhyoukey) {
        tyouhyoukey = pTyouhyoukey;
    }

    public IT_KykKihon getKykKihon() {
        return kykKihon;
    }

    public void setKykKihon(IT_KykKihon pKykKihon) {
        kykKihon = pKykKihon;
    }

    @Override
    public TtdktyuuikbnInfoDataSourceBeanCommonParam createTtdktyuuikbnInfoDataSourceBean() {
        return new TtdktyuuikbnInfoDataSourceBean();
    }

    @Override
    public void convertTtdktyuuikbnInfoForCommonParam(List<TtdktyuuikbnInfoDataSourceBeanCommonParam> pTtdktyuuikbnInfo) {
        List<TtdktyuuikbnInfoDataSourceBean> ttdktyuuikbnInfo = Lists.newArrayList();
        for (TtdktyuuikbnInfoDataSourceBeanCommonParam beanParam : pTtdktyuuikbnInfo) {
            ttdktyuuikbnInfo.add((TtdktyuuikbnInfoDataSourceBean)beanParam);
        }
        super.setTtdktyuuikbnInfo(ttdktyuuikbnInfo);
    }

    @Override
    public C_UmuKbn getNextkosumu() {
        return nextkosumu;
    }

    @Override
    public void setNextkosumu(C_UmuKbn pNextkosumu) {
        nextkosumu = pNextkosumu;
    }

    public List<String>  getWarningMessageIdList() {
        return warningMessageIdList;
    }

    @Override
    public void setWarningMessageIdList(List<String>  pWarningMessageIdList) {
        warningMessageIdList = pWarningMessageIdList;
    }

    @Override
    public void setWarningMessageList(List<String>  pWarningMessageList) {
        warningMessageList = pWarningMessageList;
    }

    public List<String>  getWarningMessageList() {
        return warningMessageList;
    }

    @Override
    public KikeiyakuInfoDataSourceBeanCommonParam createKikeiyakuInfoDataSourceBean() {
        return new KikeiyakuInfoDataSourceBean();
    }

    @Override
    public void convertKikeiyakuInfoForCommonParam(List<KikeiyakuInfoDataSourceBeanCommonParam> pKikeiyakuInfo) {
        List<KikeiyakuInfoDataSourceBean> kikeiyakuInfo = Lists.newArrayList();
        for (KikeiyakuInfoDataSourceBeanCommonParam beanParam : pKikeiyakuInfo) {
            kikeiyakuInfo.add((KikeiyakuInfoDataSourceBean) beanParam);
        }
        super.setKikeiyakuInfo(kikeiyakuInfo);
    }

    @Override
    public NenkinsiharaiInfoDataSourceBeanCommonParam createNenkinsiharaiInfoDataSourceBean() {
        return new NenkinsiharaiInfoDataSourceBean();
    }

    @Override
    public void convertNenkinsiharaiInfoForCommonParam(
        List<NenkinsiharaiInfoDataSourceBeanCommonParam> pNenkinsiharaiInfo) {
        List<NenkinsiharaiInfoDataSourceBean> nenkinsiharaiInfo = Lists.newArrayList();
        for (NenkinsiharaiInfoDataSourceBeanCommonParam beanParam : pNenkinsiharaiInfo) {
            nenkinsiharaiInfo.add((NenkinsiharaiInfoDataSourceBean) beanParam);
        }
        super.setNenkinsiharaiInfo(nenkinsiharaiInfo);
    }

    @Override
    public PalkikeiyakuInfoDataSourceBeanCommonParam createPalkikeiyakuInfoDataSourceBean() {
        return new PalkikeiyakuInfoDataSourceBean();
    }

    @Override
    public void convertPalkikeiyakuInfoForCommonParam(
        List<PalkikeiyakuInfoDataSourceBeanCommonParam> pPalNenkinsiharaiInfo) {
        List<PalkikeiyakuInfoDataSourceBean> palkikeiyakuInfo = Lists.newArrayList();
        for (PalkikeiyakuInfoDataSourceBeanCommonParam beanParam : pPalNenkinsiharaiInfo) {
            palkikeiyakuInfo.add((PalkikeiyakuInfoDataSourceBean) beanParam);
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
        List<PalnenkinsiharaiInfoDataSourceBean> palnenkinsiharaiInfo = Lists.newArrayList();
        for (PalNenkinsiharaiInfoDataSourceBeanCommonParam beanParam : pPalNenkinsiharaiInfo) {
            palnenkinsiharaiInfo.add((PalnenkinsiharaiInfoDataSourceBean) beanParam);
        }
        super.setPalnenkinsiharaiInfo(palnenkinsiharaiInfo);
    }

    @Override
    public PalsueokiInfoDataSourceBeanCommonParam createPalsueokiInfoDataSourceBean() {
        return new PalsueokiInfoDataSourceBean();
    }

    @Override
    public void convertPalsueokiInfoForCommonParam(List<PalsueokiInfoDataSourceBeanCommonParam> pPalsueokiInfo) {
        List<PalsueokiInfoDataSourceBean> palnenkinsiharaiInfo = Lists.newArrayList();
        for (PalsueokiInfoDataSourceBeanCommonParam beanParam : pPalsueokiInfo) {
            palnenkinsiharaiInfo.add((PalsueokiInfoDataSourceBean) beanParam);
        }
        super.setPalsueokiInfo(palnenkinsiharaiInfo);
    }

    @Override
    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    @Override
    public String getSyono() {
        return syono;
    }

    public void setHenkouSikibetuKey(String pHenkouSikibetuKey) {
        henkouSikibetuKey = pHenkouSikibetuKey;
    }

    public String getHenkouSikibetuKey() {
        return henkouSikibetuKey;
    }

    public void setIktNyuukinnUmu(C_UmuKbn pIktNyuukinnUmu) {
        iktNyuukinnUmu = pIktNyuukinnUmu;
    }

    public C_UmuKbn getIktNyuukinnUmu() {
        return iktNyuukinnUmu;
    }

    public C_Hrkkaisuu getHrkkaisuuSyoriyou() {
        return hrkkaisuuSyoriyou;
    }

    public void setHrkkaisuuSyoriyou(C_Hrkkaisuu pHrkkaisuuSyoriyou) {
        this.hrkkaisuuSyoriyou = pHrkkaisuuSyoriyou;
    }

    public C_TkiktbrisyuruiKbn getTikiktbrisyuruikbnSyoriyou() {
        return tikiktbrisyuruikbnSyoriyou;
    }

    public void setTikiktbrisyuruikbnSyoriyou(C_TkiktbrisyuruiKbn pTikiktbrisyuruikbnSyoriyou) {
        this.tikiktbrisyuruikbnSyoriyou = pTikiktbrisyuruikbnSyoriyou;
    }

    public void setNykkeiroSyoriyou(C_Nykkeiro pNykkeiroSyoriyou) {
        nykkeiroSyoriyou = pNykkeiroSyoriyou;
    }

    public C_Nykkeiro getNykkeiroSyoriyou() {
        return nykkeiroSyoriyou;
    }

    public void setNyknaiyoukbnSyoriyou(C_NyknaiyouKbn pNyknaiyoukbnSyoriyou) {
        nyknaiyoukbnSyoriyou = pNyknaiyoukbnSyoriyou;
    }

    public C_NyknaiyouKbn getNyknaiyoukbnSyoriyou() {
        return nyknaiyoukbnSyoriyou;
    }

    public void setJyuutouymSyoriyou(BizDateYM pJyuutouymSyoriyou) {
        jyuutouymSyoriyou = pJyuutouymSyoriyou;
    }

    public BizDateYM getJyuutouymSyoriyou() {
        return jyuutouymSyoriyou;
    }

    public void setJyutoukaisuuySyoriyou(Integer pJyutoukaisuuySyoriyou) {
        jyutoukaisuuySyoriyou = pJyutoukaisuuySyoriyou;
    }

    public Integer getJyutoukaisuuySyoriyou() {
        return jyutoukaisuuySyoriyou;
    }

    public void setJyutoukaisuumSyoriyou(Integer pJyutoukaisuumSyoriyou) {
        jyutoukaisuumSyoriyou = pJyutoukaisuumSyoriyou;
    }

    public Integer getJyutoukaisuumSyoriyou() {
        return jyutoukaisuumSyoriyou;
    }

    public void setRsgakuSyoriyou(BizCurrency pRsgakuSyoriyou) {
        rsgakuSyoriyou = pRsgakuSyoriyou;
    }

    public BizCurrency getRsgakuSyoriyou() {
        return rsgakuSyoriyou;
    }

    public void setRyosyuymdSyoriyou(BizDate pRyosyuymdSyoriyou) {
        ryosyuymdSyoriyou = pRyosyuymdSyoriyou;
    }

    public BizDate getRyosyuymdSyoriyou() {
        return ryosyuymdSyoriyou;
    }

    @Override
    public C_UmuKbn getYennykntkhkumu() {
        return yennykntkhkumu;
    }

    @Override
    public void setYennykntkhkumu(C_UmuKbn pYennykntkhkumu) {
        yennykntkhkumu = pYennykntkhkumu;

    }

    @Override
    public C_Tuukasyu getKyktuukasyu() {
        return kyktuukasyu;
    }

    @Override
    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        this.kyktuukasyu = pKyktuukasyu;
    }

    public String getCreditkessaiyouno() {
        return creditkessaiyouno;
    }

    public void setCreditkessaiyouno(String pCreditkessaiyouno) {
        creditkessaiyouno = pCreditkessaiyouno;
    }
}
