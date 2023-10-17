package yuyu.app.hozen.khozen.khkoujyosyoumeisaihakkou;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutaiExecUiBeanParam;
import yuyu.common.hozen.khview.viewbetukyk.ViewBetukykUiBeanParam;
import yuyu.common.hozen.khview.viewharaikomiinfo.ViewHaraikomiInfoUiBeanParam;
import yuyu.common.hozen.khview.viewhihokensya.ViewHihokensyaUiBeanParam;
import yuyu.common.hozen.khview.viewkariukekin.ViewKariukekinUiBeanParam;
import yuyu.common.hozen.khview.viewkeiyakusya.ViewKeiyakusyaUiBeanParam;
import yuyu.common.hozen.khview.viewkihon.ViewKihonUiBeanParam;
import yuyu.common.hozen.khview.viewtetudukityuui.ViewTetudukityuuiUiBeanParam;
import yuyu.common.hozen.khview.viewtuusinsaki.ViewTuusinsakiUiBeanParam;
import yuyu.common.hozen.setuibean.KariukekinInfoDataSourceBeanCommonParam;
import yuyu.common.hozen.setuibean.KikeiyakuInfoDataSourceBeanCommonParam;
import yuyu.common.hozen.setuibean.NenkinsiharaiInfoDataSourceBeanCommonParam;
import yuyu.common.hozen.setuibean.PalNenkinsiharaiInfoDataSourceBeanCommonParam;
import yuyu.common.hozen.setuibean.PalkikeiyakuInfoDataSourceBeanCommonParam;
import yuyu.common.hozen.setuibean.PalsueokiInfoDataSourceBeanCommonParam;
import yuyu.common.hozen.setuibean.SetBetukykExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetHaraikomiInfoExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetHihokensyaExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetKariukekinExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetKeiyakusyaExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetKihonExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetTetudukityuuiExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetToriatukaiTyuuiExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetTuusinsakiExecUiBeanParam;
import yuyu.common.hozen.setuibean.TtdktyuuikbnInfoDataSourceBeanCommonParam;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Kaiyakujiyuu;
import yuyu.def.classification.C_KoujyosyoumeimsgKbn;
import yuyu.def.classification.C_KyktrksKbn;
import yuyu.def.classification.C_Meigihnkjiyuu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KykKihon;

import com.google.common.collect.Lists;

/**
 * 控除証明書再発行 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class KhKoujyosyoumeiSaihakkouUiBean extends GenKhKoujyosyoumeiSaihakkouUiBean implements ViewKihonUiBeanParam,
ViewBetukykUiBeanParam, ViewTetudukityuuiUiBeanParam, ViewKeiyakusyaUiBeanParam, ViewTuusinsakiUiBeanParam,
ViewHihokensyaUiBeanParam, ViewHaraikomiInfoUiBeanParam, CheckYuukouJyoutaiExecUiBeanParam,
SetToriatukaiTyuuiExecUiBeanParam, SetKihonExecUiBeanParam, SetBetukykExecUiBeanParam,
SetTetudukityuuiExecUiBeanParam, SetKeiyakusyaExecUiBeanParam, SetTuusinsakiExecUiBeanParam,
SetHihokensyaExecUiBeanParam, SetHaraikomiInfoExecUiBeanParam, SetKariukekinExecUiBeanParam,
ViewKariukekinUiBeanParam {

    private static final long serialVersionUID = 1L;

    private int kjysyoumeinndhyjsuu;

    private C_Hrkkaisuu hrkkaisuu;

    @Inject
    private IT_KykKihon kykKihon;

    private BizDateYM lastsyoumeiendym;

    private C_UmuKbn tyouhyoumukbn;

    private String tyouhyoukey;

    private C_UmuKbn mosuktymdhkumu;

    private BizDate ttdktyuuisetymd;

    private String hhknyno;

    private String hhknadr1kj;

    private String hhknadr2kj;

    private String hhknadr3kj;

    private String hhknadr4kj;

    private String hhkntelno;

    private C_Meigihnkjiyuu meigihnkjiyuu;

    private C_Kaiyakujiyuu kaiyakujiyuu;

    private C_KyktrksKbn kyktrkskbn;

    private C_UmuKbn hrkkeirohnkumu;

    private C_UmuKbn hrkkaisuuhnkumu;

    private C_UmuKbn daisennintdkumukbn;

    private List<String> warningMessageIdList;

    private List<String> warningMessageList;

    private C_UmuKbn nextkosumu;

    private C_UmuKbn yennykntkhkumu;

    private C_Tuukasyu kyktuukasyu;

    private BizDateYM syoumeiendym;

    private C_UmuKbn koujyosyoumeitkbttaiouumu;

    private C_KoujyosyoumeimsgKbn koujyosyoumeimsgKbn;

    public KhKoujyosyoumeiSaihakkouUiBean() {
    }

    public int getKjysyoumeinndhyjsuu() {
        return kjysyoumeinndhyjsuu;
    }

    public void setKjysyoumeinndhyjsuu(int pKjysyoumeinndhyjsuu) {
        kjysyoumeinndhyjsuu = pKjysyoumeinndhyjsuu;
    }

    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        hrkkaisuu = pHrkkaisuu;
    }

    public IT_KykKihon getKykKihon() {
        return kykKihon;
    }

    public void setKykKihon(IT_KykKihon pKykKihon) {
        kykKihon = pKykKihon;
    }

    public BizDateYM getLastsyoumeiendym() {
        return lastsyoumeiendym;
    }

    public void setLastsyoumeiendym(BizDateYM pLastsyoumeiendym) {
        lastsyoumeiendym = pLastsyoumeiendym;
    }

    public C_UmuKbn getTyouhyoumukbn() {
        return tyouhyoumukbn;
    }

    public void setTyouhyoumukbn(C_UmuKbn pTyouhyoumukbn) {
        tyouhyoumukbn = pTyouhyoumukbn;
    }

    public String getTyouhyoukey() {
        return tyouhyoukey;
    }

    public void setTyouhyoukey(String pTyouhyoukey) {
        tyouhyoukey = pTyouhyoukey;
    }

    private String gmmsgid2;

    public String getGmmsgid2() {
        return gmmsgid2;
    }

    public void setGmmsgid2(String pGmmsgid2) {
        gmmsgid2 = pGmmsgid2;

    }

    private String gmmsg2;

    public String getGmmsg2() {
        return gmmsg2;
    }

    public void setGmmsg2(String pGmmsg2) {
        gmmsg2 = pGmmsg2;

    }


    public C_UmuKbn getMosuktymdhkumu() {
        return mosuktymdhkumu;
    }


    public void setMosuktymdhkumu(C_UmuKbn pMosuktymdhkumu) {
        mosuktymdhkumu = pMosuktymdhkumu;
    }



    public BizDate getTtdktyuuisetymd() {
        return ttdktyuuisetymd;
    }

    public void setTtdktyuuisetymd(BizDate pTtdktyuuisetymd) {
        ttdktyuuisetymd = pTtdktyuuisetymd;
    }


    public String getHhknyno() {
        return hhknyno;
    }

    public void setHhknyno(String pHhknyno) {
        hhknyno = pHhknyno;
    }

    public String getHhknadr1kj() {
        return hhknadr1kj;
    }

    public void setHhknadr1kj(String pHhknadr1kj) {
        hhknadr1kj = pHhknadr1kj;
    }

    public String getHhknadr2kj() {
        return hhknadr2kj;
    }

    public void setHhknadr2kj(String pHhknadr2kj) {
        hhknadr2kj = pHhknadr2kj;
    }

    public String getHhknadr3kj() {
        return hhknadr3kj;
    }

    public void setHhknadr3kj(String pHhknadr3kj) {
        hhknadr3kj = pHhknadr3kj;
    }

    public String getHhknadr4kj() {
        return hhknadr4kj;
    }

    public void setHhknadr4kj(String pHhknadr4kj) {
        hhknadr4kj = pHhknadr4kj;
    }

    public String getHhkntelno() {
        return hhkntelno;
    }

    public void setHhkntelno(String pHhkntelno) {
        hhkntelno = pHhkntelno;
    }

    public C_Meigihnkjiyuu getMeigihnkjiyuu() {
        return meigihnkjiyuu;
    }

    public void setMeigihnkjiyuu(C_Meigihnkjiyuu pMeigihnkjiyuu) {
        meigihnkjiyuu = pMeigihnkjiyuu;
    }

    public C_Kaiyakujiyuu getKaiyakujiyuu() {
        return kaiyakujiyuu;
    }

    public void setKaiyakujiyuu(C_Kaiyakujiyuu pKaiyakujiyuu) {
        kaiyakujiyuu = pKaiyakujiyuu;
    }

    public C_KyktrksKbn getKyktrkskbn() {
        return kyktrkskbn;
    }

    public void setKyktrkskbn(C_KyktrksKbn pKyktrkskbn) {
        kyktrkskbn = pKyktrkskbn;
    }

    public C_UmuKbn getHrkkeirohnkumu() {
        return hrkkeirohnkumu;
    }

    public void setHrkkeirohnkumu(C_UmuKbn pHrkkeirohnkumu) {
        hrkkeirohnkumu = pHrkkeirohnkumu;
    }

    public C_UmuKbn getHrkkaisuuhnkumu() {
        return hrkkaisuuhnkumu;
    }

    public void setHrkkaisuuhnkumu(C_UmuKbn pHrkkaisuuhnkumu) {
        hrkkaisuuhnkumu = pHrkkaisuuhnkumu;
    }

    public C_UmuKbn getDaisennintdkumukbn() {
        return daisennintdkumukbn;
    }

    public void setDaisennintdkumukbn(C_UmuKbn pDaisennintdkumukbn) {
        daisennintdkumukbn = pDaisennintdkumukbn;
    }

    public List<String> getWarningMessageIdList() {
        return warningMessageIdList;
    }

    @Override
    public void setWarningMessageIdList(List<String> pWarningMessageIdList) {
        warningMessageIdList = pWarningMessageIdList;
    }

    public List<String> getWarningMessageList() {
        return warningMessageList;
    }

    @Override
    public void setWarningMessageList(List<String> pWarningMessageList) {
        warningMessageList = pWarningMessageList;
    }

    @Override
    public void setSyono(String pSyono) {
        setVkihnsyono(pSyono);

    }

    @Override
    public String getSyono() {
        return getVkihnsyono();
    }

    @Override
    public C_UmuKbn getNextkosumu() {
        return nextkosumu;
    }

    @Override
    public void setNextkosumu(C_UmuKbn pNextkosumu) {
        nextkosumu = pNextkosumu;
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
    public TtdktyuuikbnInfoDataSourceBeanCommonParam createTtdktyuuikbnInfoDataSourceBean() {
        return new TtdktyuuikbnInfoDataSourceBean();
    }

    @Override
    public void convertTtdktyuuikbnInfoForCommonParam(List<TtdktyuuikbnInfoDataSourceBeanCommonParam> pTtdktyuuikbnInfo) {
        List<TtdktyuuikbnInfoDataSourceBean> ttdktyuuikbnInfo = Lists.newArrayList();
        for (TtdktyuuikbnInfoDataSourceBeanCommonParam beanPram : pTtdktyuuikbnInfo) {
            ttdktyuuikbnInfo.add((TtdktyuuikbnInfoDataSourceBean) beanPram);
        }
        super.setTtdktyuuikbnInfo(ttdktyuuikbnInfo);
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
    public void convertPalkikeiyakuInfoForCommonParam(List<PalkikeiyakuInfoDataSourceBeanCommonParam> pPalkikeiyakuInfo) {
        List<PalkikeiyakuInfoDataSourceBean> palkikeiyakuInfo = Lists.newArrayList();
        for (PalkikeiyakuInfoDataSourceBeanCommonParam beanParam : pPalkikeiyakuInfo) {
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
        List<PalsueokiInfoDataSourceBean> palsueokiInfo = Lists.newArrayList();
        for (PalsueokiInfoDataSourceBeanCommonParam beanParam : pPalsueokiInfo) {
            palsueokiInfo.add((PalsueokiInfoDataSourceBean) beanParam);
        }
        super.setPalsueokiInfo(palsueokiInfo);
    }

    @Override
    public C_Tuukasyu getKyktuukasyu() {
        return kyktuukasyu;
    }

    @Override
    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        kyktuukasyu = pKyktuukasyu;
    }

    @Override
    public KariukekinInfoDataSourceBeanCommonParam createKariukekinInfoDataSourceBean() {
        return new KariukekinInfoDataSourceBean();
    }

    @Override
    public void convertKariukekinInfoForCommonParam(List<KariukekinInfoDataSourceBeanCommonParam> pKariukekinInfo) {
        List<KariukekinInfoDataSourceBean> kariukekinInfo = Lists.newArrayList();
        for (KariukekinInfoDataSourceBeanCommonParam dataSourceBeanCommonParam :pKariukekinInfo) {
            kariukekinInfo.add((KariukekinInfoDataSourceBean)dataSourceBeanCommonParam);
        }
        super.setKariukekinInfo(kariukekinInfo);
    }

    public BizDateYM getSyoumeiendym() {
        return syoumeiendym;
    }

    public void setSyoumeiendym(BizDateYM pSyoumeiendym) {
        syoumeiendym = pSyoumeiendym;
    }

    public C_UmuKbn getKoujyosyoumeitkbttaiouumu() {
        return koujyosyoumeitkbttaiouumu;
    }

    public void setKoujyosyoumeitkbttaiouumu(C_UmuKbn pKoujyosyoumeitkbttaiouumu) {
        koujyosyoumeitkbttaiouumu = pKoujyosyoumeitkbttaiouumu;
    }

    public C_KoujyosyoumeimsgKbn getKoujyosyoumeimsgKbn() {
        return koujyosyoumeimsgKbn;
    }

    public void setKoujyosyoumeimsgKbn(C_KoujyosyoumeimsgKbn pKoujyosyoumeimsgKbn) {
        this.koujyosyoumeimsgKbn = pKoujyosyoumeimsgKbn;
    }
}
