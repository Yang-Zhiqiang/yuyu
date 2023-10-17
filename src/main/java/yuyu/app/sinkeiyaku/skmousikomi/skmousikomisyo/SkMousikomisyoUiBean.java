package yuyu.app.sinkeiyaku.skmousikomi.skmousikomisyo;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import jp.co.slcs.swak.web.ui.UserDefsList;
import yuyu.app.sinkeiyaku.skmousikomi.skmousikomisyo.SkMousikomisyoConstants.E_InsUpdKbn;
import yuyu.app.sinkeiyaku.skmousikomi.skmousikomisyo.SkMousikomisyoConstants.E_SyoriKbn;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.koutei.BzWorkflowInfo;
import yuyu.common.biz.koutei.SetKouteiInfoExecUiBeanParam;
import yuyu.common.biz.syoruiitiran.SetSyoruiInfoItiranExecUiBeanParam;
import yuyu.common.biz.syoruiitiran.SyoruiInfoItiranDataSourceBeanCommonParam;
import yuyu.common.biz.syoruiitiran.viewsyoruiinfoitiran.ViewSyoruiInfoItiranUiBeanParam;
import yuyu.common.sinkeiyaku.skcommon.GetSyouhnZokuseiCtrlOutBean;
import yuyu.common.sinkeiyaku.skcommon.SaiDataTourokuRegisterSaiDataMousikomisyoUiBeanParam;
import yuyu.common.sinkeiyaku.skcommon.SkIdounaiyouBeforeBean;
import yuyu.common.sinkeiyaku.skcommon.TsRrkInfoTourokuRgstrMousikomisyoUiBeanParam;
import yuyu.def.classification.C_BlnktkumuKbn;
import yuyu.def.classification.C_FstphrkkeiroKbn;
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_IkkatubaraiKaisuuKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_KouzaInfoInputHoryuuKbn;
import yuyu.def.classification.C_KykKbn;
import yuyu.def.classification.C_KzhuritourokuhouKbn;
import yuyu.def.classification.C_MobilebosyuuKbn;
import yuyu.def.classification.C_Sdpd;
import yuyu.def.classification.C_Sisuukbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_Sknenkinsyu;
import yuyu.def.classification.C_SntkhouKbn;
import yuyu.def.classification.C_TargetTkKbn;
import yuyu.def.classification.C_TargetTkMokuhyoutiKbn;
import yuyu.def.classification.C_Tdk;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_TkykTratkiKbn;
import yuyu.def.classification.C_TsindousiteiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.HT_BosKihon;
import yuyu.def.db.entity.HT_SyoriCTL;

import com.google.common.collect.Lists;

/**
 * 申込書入力 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class SkMousikomisyoUiBean extends GenSkMousikomisyoUiBean
implements TsRrkInfoTourokuRgstrMousikomisyoUiBeanParam, SaiDataTourokuRegisterSaiDataMousikomisyoUiBeanParam,
ViewSyoruiInfoItiranUiBeanParam, SetSyoruiInfoItiranExecUiBeanParam, SetKouteiInfoExecUiBeanParam {

    private static final long serialVersionUID = 1L;

    @Inject
    private HT_SyoriCTL syoriCTL;

    @Inject
    private BzWorkflowInfo bzWorkflowInfo;

    @Inject
    private SkIdounaiyouBeforeBean skIdounaiyouBeforeBean;

    private HT_BosKihon bosKihon;

    private BM_SyouhnZokusei syouhnZokusei;

    private E_SyoriKbn syoriKbn;

    private E_InsUpdKbn insUpdKbn;

    private String[] hubimsgData;

    private int nrksaiumu;

    private String[] imageids;

    private C_SkeijimuKbn skeijimuKbn;

    private Integer hknsyuruinosd;

    private C_SntkhouKbn sntkhoukbn;

    private C_HaitouKbn haitoukbn;

    private String daimosno;

    private C_KykKbn initKykkbn;

    private String initHhknnmkn;

    private BizDate initHhknseiymd;

    private String initHhknyno;

    private String initKyknmkn;

    private BizDate initKykseiymd;

    private String initTsinyno;

    private String initBsyujoyadrtencd;

    private C_Hrkkeiro initHrkkeiro;

    private C_FstphrkkeiroKbn initFstphrkkeirokbn;

    private C_KzhuritourokuhouKbn initKzhuritourokuhoukbn;

    private String patternKykhonninkakninsyoruikbn;

    private String patternSkskknhonninkakninsyoruikbn;

    private boolean drtInfo2HyoujiFlg;

    private C_UmuKbn ikokakninsyotokkijkumu;

    private C_UmuKbn trtkhoukokusyotokkijkumu;

    private C_UmuKbn hnnkakninhskjikouumukbn;

    private C_UmuKbn hnnkakninhsktkjikouumukbn;

    private C_UmuKbn skskakninhsktkjikouumukbn;

    private C_MobilebosyuuKbn mobilebosyuukbn;

    private BizDate moscalckijyunymd;

    private C_Tkhukaumu targettkhkkbn;

    private C_TargetTkKbn targettkkbn;

    private BizNumber taihisbuktbnwari1;

    private String taihisyudai1hknkkn;

    private BizNumber taihidairitenbuntanwariai1;

    private List<String> kakuninmessage;

    private BizCurrency mosfstpkei;

    private List<GetSyouhnZokuseiCtrlOutBean> syouhnzokuseiCtrlGetOutBeanLst;

    private C_UmuKbn itibuzennoutekiumu;

    private String nkukthyoujimongon;

    private String[] hubimsgData2;

    private C_Tuukasyu taihikyktuukasyu;

    private C_Tuukasyu taihihrktuukasyu;

    private C_Tuukasyu taihikyktuukasyu2;

    private C_Tuukasyu taihihrktuukasyu2;

    private C_UmuKbn mos2hyoujiumuKbn;

    private boolean taihyoumousikomiUmu;

    private boolean aiteimousikomiUmu;

    private BizCurrency mosfstpkei2;

    private String zouhabakouteikanriid;

    private List<BT_GyoumuKouteiInfo> gyoumuKouteiInfoLst;

    private String krkekouteikanriid;

    private C_Sdpd taihisdpdkbn;

    public SkMousikomisyoUiBean() {
    }

    public HT_SyoriCTL getSyoriCTL() {
        return syoriCTL;
    }

    public void setSyoriCTL(HT_SyoriCTL pSyoriCTL) {
        syoriCTL = pSyoriCTL;
    }

    @Override
    public BzWorkflowInfo getBzWorkflowInfo() {
        return bzWorkflowInfo;
    }

    public void setBzWorkflowInfo(BzWorkflowInfo pBzWorkflowInfo) {
        bzWorkflowInfo = pBzWorkflowInfo;
    }

    public SkIdounaiyouBeforeBean getSkIdounaiyouBeforeBean() {
        return skIdounaiyouBeforeBean;
    }

    public void setSkIdounaiyouBeforeBean(SkIdounaiyouBeforeBean pSkIdounaiyouBeforeBean) {
        this.skIdounaiyouBeforeBean = pSkIdounaiyouBeforeBean;
    }

    public HT_BosKihon getBosKihon() {
        return bosKihon;
    }

    public void setBosKihon(HT_BosKihon pBosKihon) {
        bosKihon = pBosKihon;
    }

    public BM_SyouhnZokusei getSyouhnZokusei() {
        return syouhnZokusei;
    }

    public void setSyouhnZokusei(BM_SyouhnZokusei pSyouhnZokusei) {
        syouhnZokusei = pSyouhnZokusei;
    }

    public E_SyoriKbn getSyoriKbn() {
        return syoriKbn;
    }

    public void setSyoriKbn(E_SyoriKbn pSyoriKbn) {
        syoriKbn = pSyoriKbn;
    }

    public E_InsUpdKbn getInsUpdKbn() {
        return insUpdKbn;
    }

    public void setInsUpdKbn(E_InsUpdKbn pInsUpdKbn) {
        insUpdKbn = pInsUpdKbn;
    }

    public String[] getHubimsgData() {
        return hubimsgData;
    }

    public void setHubimsgData(String[] pHubimsgData) {
        hubimsgData = pHubimsgData;
    }

    public int getNrksaiumu() {
        return nrksaiumu;
    }

    public void setNrksaiumu(int pNrksaiumu) {
        nrksaiumu = pNrksaiumu;
    }

    @Override
    public String[] getImageids() {
        return imageids;
    }

    @Override
    public void setImageids(String[] pImageids) {
        imageids = pImageids;
    }

    public C_SkeijimuKbn getSkeijimuKbn() {
        return skeijimuKbn;
    }

    public void setSkeijimuKbn(C_SkeijimuKbn pSkeijimuKbn) {
        skeijimuKbn = pSkeijimuKbn;
    }

    public Integer getHknsyuruinosd() {
        return hknsyuruinosd;
    }

    public void setHknsyuruinosd(Integer pHknsyuruinosd) {
        hknsyuruinosd = pHknsyuruinosd;
    }

    public C_SntkhouKbn getSntkhoukbn() {
        return sntkhoukbn;
    }

    public void setSntkhoukbn(C_SntkhouKbn pSntkhoukbn) {
        sntkhoukbn = pSntkhoukbn;
    }

    public C_HaitouKbn getHaitoukbn() {
        return haitoukbn;
    }

    public void setHaitoukbn(C_HaitouKbn pHaitoukbn) {
        haitoukbn = pHaitoukbn;
    }

    public String getDaimosno() {
        return daimosno;
    }

    public void setDaimosno(String pDaimosno) {
        daimosno = pDaimosno;
    }

    public C_KykKbn getInitKykkbn() {
        return initKykkbn;
    }

    public void setInitKykkbn(C_KykKbn pInitKykkbn) {
        initKykkbn = pInitKykkbn;
    }

    public String getInitHhknnmkn() {
        return initHhknnmkn;
    }

    public void setInitHhknnmkn(String pInitHhknnmkn) {
        initHhknnmkn = pInitHhknnmkn;
    }

    public BizDate getInitHhknseiymd() {
        return initHhknseiymd;
    }

    public void setInitHhknseiymd(BizDate pInitHhknseiymd) {
        initHhknseiymd = pInitHhknseiymd;
    }

    public String getInitHhknyno() {
        return initHhknyno;
    }

    public void setInitHhknyno(String pInitHhknyno) {
        this.initHhknyno = pInitHhknyno;
    }

    public String getInitKyknmkn() {
        return initKyknmkn;
    }

    public void setInitKyknmkn(String pInitKyknmkn) {
        initKyknmkn = pInitKyknmkn;
    }

    public BizDate getInitKykseiymd() {
        return initKykseiymd;
    }

    public void setInitKykseiymd(BizDate pInitKykseiymd) {
        initKykseiymd = pInitKykseiymd;
    }

    public String getInitTsinyno() {
        return initTsinyno;
    }

    public void setInitTsinyno(String pInitTsinyno) {
        this.initTsinyno = pInitTsinyno;
    }

    public String getInitBsyujoyadrtencd() {
        return initBsyujoyadrtencd;
    }

    public void setInitBsyujoyadrtencd(String pInitBsyujoyadrtencd) {
        initBsyujoyadrtencd = pInitBsyujoyadrtencd;
    }

    public C_Hrkkeiro getInitHrkkeiro() {
        return initHrkkeiro;
    }

    public void setInitHrkkeiro(C_Hrkkeiro pInitHrkkeiro) {
        initHrkkeiro = pInitHrkkeiro;
    }

    public C_FstphrkkeiroKbn getInitFstphrkkeirokbn() {
        return initFstphrkkeirokbn;
    }

    public void setInitFstphrkkeirokbn(C_FstphrkkeiroKbn pInitFstphrkkeirokbn) {
        initFstphrkkeirokbn = pInitFstphrkkeirokbn;
    }

    public C_KzhuritourokuhouKbn getInitKzhuritourokuhoukbn() {
        return initKzhuritourokuhoukbn;
    }

    public void setInitKzhuritourokuhoukbn(C_KzhuritourokuhouKbn pInitKzhuritourokuhoukbn) {
        initKzhuritourokuhoukbn = pInitKzhuritourokuhoukbn;
    }

    public String getPatternKykhonninkakninsyoruikbn() {
        return patternKykhonninkakninsyoruikbn;
    }

    public void setPatternKykhonninkakninsyoruikbn(String pPatternKykhonninkakninsyoruikbn) {
        this.patternKykhonninkakninsyoruikbn = pPatternKykhonninkakninsyoruikbn;
    }

    public String getPatternSkskknhonninkakninsyoruikbn() {
        return patternSkskknhonninkakninsyoruikbn;
    }

    public void setPatternSkskknhonninkakninsyoruikbn(String pPatternSkskknhonninkakninsyoruikbn) {
        this.patternSkskknhonninkakninsyoruikbn = pPatternSkskknhonninkakninsyoruikbn;
    }

    public boolean getDrtInfo2HyoujiFlg() {
        return drtInfo2HyoujiFlg;
    }

    public void setDrtInfo2HyoujiFlg(boolean pDrtInfo2HyoujiFlg) {
        this.drtInfo2HyoujiFlg = pDrtInfo2HyoujiFlg;
    }

    public C_UmuKbn getIkokakninsyotokkijkumu() {
        return ikokakninsyotokkijkumu;
    }

    public void setIkokakninsyotokkijkumu(C_UmuKbn pIkokakninsyotokkijkumu) {
        this.ikokakninsyotokkijkumu = pIkokakninsyotokkijkumu;
    }

    public C_UmuKbn getTrtkhoukokusyotokkijkumu() {
        return trtkhoukokusyotokkijkumu;
    }

    public void setTrtkhoukokusyotokkijkumu(C_UmuKbn pTrtkhoukokusyotokkijkumu) {
        this.trtkhoukokusyotokkijkumu = pTrtkhoukokusyotokkijkumu;
    }

    public C_UmuKbn getHnnkakninhskjikouumukbn() {
        return hnnkakninhskjikouumukbn;
    }

    public void setHnnkakninhskjikouumukbn(C_UmuKbn pHnnkakninhskjikouumukbn) {
        this.hnnkakninhskjikouumukbn = pHnnkakninhskjikouumukbn;
    }

    public C_UmuKbn getHnnkakninhsktkjikouumukbn() {
        return hnnkakninhsktkjikouumukbn;
    }

    public void setHnnkakninhsktkjikouumukbn(C_UmuKbn pHnnkakninhsktkjikouumukbn) {
        this.hnnkakninhsktkjikouumukbn = pHnnkakninhsktkjikouumukbn;
    }

    public C_UmuKbn getSkskakninhsktkjikouumukbn() {
        return skskakninhsktkjikouumukbn;
    }

    public void setSkskakninhsktkjikouumukbn(C_UmuKbn pSkskakninhsktkjikouumukbn) {
        this.skskakninhsktkjikouumukbn = pSkskakninhsktkjikouumukbn;
    }

    public C_MobilebosyuuKbn getMobilebosyuukbn() {
        return mobilebosyuukbn;
    }

    public void setMobilebosyuukbn(C_MobilebosyuuKbn pMobilebosyuukbn) {
        this.mobilebosyuukbn = pMobilebosyuukbn;
    }

    public BizDate getMoscalckijyunymd() {
        return moscalckijyunymd;
    }

    public void setMoscalckijyunymd(BizDate pMoscalckijyunymd) {
        moscalckijyunymd = pMoscalckijyunymd;
    }

    public C_Tkhukaumu getTargettkhkkbn() {
        return targettkhkkbn;
    }

    public void setTargettkhkkbn(C_Tkhukaumu pTargettkhkkbn) {
        targettkhkkbn = pTargettkhkkbn;
    }

    public C_TargetTkKbn getTargettkkbn() {
        return targettkkbn;
    }

    public void setTargettkkbn(C_TargetTkKbn pTargettkkbn) {
        targettkkbn = pTargettkkbn;
    }

    public BizNumber getTaihisbuktbnwari1() {
        return taihisbuktbnwari1;
    }

    public void setTaihisbuktbnwari1(BizNumber pTaihisbuktbnwari1) {
        taihisbuktbnwari1 = pTaihisbuktbnwari1;
    }

    public String getTaihisyudai1hknkkn() {
        return taihisyudai1hknkkn;
    }

    public void setTaihisyudai1hknkkn(String pTaihisyudai1hknkkn) {
        taihisyudai1hknkkn = pTaihisyudai1hknkkn;
    }

    public BizNumber getTaihidairitenbuntanwariai1() {
        return taihidairitenbuntanwariai1;
    }

    public void setTaihidairitenbuntanwariai1(BizNumber pTaihidairitenbuntanwariai1) {
        taihidairitenbuntanwariai1 = pTaihidairitenbuntanwariai1;
    }

    public List<String> getKakuninmessage() {
        return kakuninmessage;
    }

    public void setKakuninmessage(List<String> pKakuninmessage) {
        kakuninmessage = pKakuninmessage;
    }

    public BizCurrency getMosfstpkei() {
        return mosfstpkei;
    }

    public void setMosfstpkei(BizCurrency pMosfstpkei) {
        mosfstpkei = pMosfstpkei;
    }

    public List<GetSyouhnZokuseiCtrlOutBean> getSyouhnzokuseiCtrlGetOutBeanLst() {
        return syouhnzokuseiCtrlGetOutBeanLst;
    }

    public void setSyouhnzokuseiCtrlGetOutBeanLst(List<GetSyouhnZokuseiCtrlOutBean> pSyouhnzokuseiCtrlGetOutBeanLst) {
        this.syouhnzokuseiCtrlGetOutBeanLst = pSyouhnzokuseiCtrlGetOutBeanLst;
    }

    @Override
    public SyoruiInfoItiranDataSourceBeanCommonParam createSyoruiInfoItiranDataSourceBean() {
        return new SyoruiInfoListDataSourceBean();
    }

    @Override
    public void convertSyoruiInfoItiranForCommonParam(List<SyoruiInfoItiranDataSourceBeanCommonParam> pSyoruiInfoItiran) {
        List<SyoruiInfoListDataSourceBean> syoruiInfoList = Lists.newArrayList();

        for (SyoruiInfoItiranDataSourceBeanCommonParam beanPram : pSyoruiInfoItiran) {
            syoruiInfoList.add((SyoruiInfoListDataSourceBean) beanPram);
        }
        super.setSyoruiInfoList(syoruiInfoList);
    }

    @Override
    public BizCurrency getKihons() {
        return getSyukihons();
    }

    @Override
    public C_UktKbn getSibouuktkbn1() {
        return getSbuktkbn1();
    }

    @Override
    public String getSibouuktnmkana1() {
        return getSbuktnmkn1();
    }

    @Override
    public String getSibouuktnmkanji1() {
        return getSbuktnmkj1();
    }

    @Override
    public C_KjkhukaKbn getSibouuktnmkanjikahukakbn1() {
        return getSbuktnmkjhukakbn1();
    }

    @Override
    public BizDate getSibouuktseiymd1() {
        return getSbuktseiymd1();
    }

    @Override
    public C_Tdk getSibouukttdk1() {
        return getSbukttdk1();
    }

    @Override
    public BizNumber getSibouuktbnwari1() {
        return getSbuktbnwari1();
    }

    @Override
    public C_UktKbn getSibouuktkbn2() {
        return getSbuktkbn2();
    }

    @Override
    public String getSibouuktnmkana2() {
        return getSbuktnmkn2();
    }

    @Override
    public String getSibouuktnmkanji2() {
        return getSbuktnmkj2();
    }

    @Override
    public C_KjkhukaKbn getSibouuktnmkanjikahukakbn2() {
        return getSbuktnmkjhukakbn2();
    }

    @Override
    public BizDate getSibouuktseiymd2() {
        return getSbuktseiymd2();
    }

    @Override
    public C_Tdk getSibouukttdk2() {
        return getSbukttdk2();
    }

    @Override
    public BizNumber getSibouuktbnwari2() {
        return getSbuktbnwari2();
    }

    @Override
    public C_UktKbn getSibouuktkbn3() {
        return getSbuktkbn3();
    }

    @Override
    public String getSibouuktnmkana3() {
        return getSbuktnmkn3();
    }

    @Override
    public String getSibouuktnmkanji3() {
        return getSbuktnmkj3();
    }

    @Override
    public C_KjkhukaKbn getSibouuktnmkanjikahukakbn3() {
        return getSbuktnmkjhukakbn3();
    }

    @Override
    public BizDate getSibouuktseiymd3() {
        return getSbuktseiymd3();
    }

    @Override
    public C_Tdk getSibouukttdk3() {
        return getSbukttdk3();
    }

    @Override
    public BizNumber getSibouuktbnwari3() {
        return getSbuktbnwari3();
    }

    @Override
    public C_UktKbn getSibouuktkbn4() {
        return getSbuktkbn4();
    }

    @Override
    public String getSibouuktnmkana4() {
        return getSbuktnmkn4();
    }

    @Override
    public String getSibouuktnmkanji4() {
        return getSbuktnmkj4();
    }

    @Override
    public C_KjkhukaKbn getSibouuktnmkanjikahukakbn4() {
        return getSbuktnmkjhukakbn4();
    }

    @Override
    public BizDate getSibouuktseiymd4() {
        return getSbuktseiymd4();
    }

    @Override
    public C_Tdk getSibouukttdk4() {
        return getSbukttdk4();
    }

    @Override
    public BizNumber getSibouuktbnwari4() {
        return getSbuktbnwari4();
    }

    @Override
    public String getGyousekikeijyousakisosikicd1() {
        return getGyskkjsakisosikicd1();
    }

    @Override
    public String getGyousekikeijyousakisosikicd2() {
        return getGyskkjsakisosikicd2();
    }

    @Override
    public Boolean getKyknmkjkhuka() {
        return C_KjkhukaKbn.KJKHUKA.eq(super.getKyknmkjkhukakbn()) ? Boolean.TRUE : Boolean.FALSE;
    }

    @Override
    public void setKyknmkjkhuka(Boolean pKyknmkjkhuka) {
        super.setKyknmkjkhuka(pKyknmkjkhuka);
        C_KjkhukaKbn kjkhukaKbn = pKyknmkjkhuka ? C_KjkhukaKbn.KJKHUKA : C_KjkhukaKbn.BLNK;
        super.setKyknmkjkhukakbn(kjkhukaKbn);
    }

    @Override
    public Boolean getHhknnmkjkhuka() {
        return C_KjkhukaKbn.KJKHUKA.eq(super.getHhknnmkjkhukakbn()) ? Boolean.TRUE : Boolean.FALSE;
    }

    @Override
    public void setHhknnmkjkhuka(Boolean pHhknnmkjkhuka) {
        super.setHhknnmkjkhuka(pHhknnmkjkhuka);
        C_KjkhukaKbn kjkhukaKbn = pHhknnmkjkhuka ? C_KjkhukaKbn.KJKHUKA : C_KjkhukaKbn.BLNK;
        super.setHhknnmkjkhukakbn(kjkhukaKbn);
    }

    @Override
    public Boolean getTsindousitei() {
        return C_TsindousiteiKbn.ARI.eq(super.getTsindousiteikbn()) ? Boolean.TRUE : Boolean.FALSE;
    }

    @Override
    public void setTsindousitei(Boolean pTsindousitei) {
        super.setTsindousitei(pTsindousitei);
        C_TsindousiteiKbn tsindousiteiKbn = pTsindousitei ? C_TsindousiteiKbn.ARI : C_TsindousiteiKbn.BLNK;
        super.setTsindousiteikbn(tsindousiteiKbn);
    }

    @Override
    public Boolean getSbuktnmkjkhuka1() {
        return C_KjkhukaKbn.KJKHUKA.eq(super.getSbuktnmkjhukakbn1()) ? Boolean.TRUE : Boolean.FALSE;
    }

    @Override
    public void setSbuktnmkjkhuka1(Boolean pSbuktnmkjkhuka1) {
        super.setSbuktnmkjkhuka1(pSbuktnmkjkhuka1);
        C_KjkhukaKbn sbuktnmkjhukakbn1 = pSbuktnmkjkhuka1 ? C_KjkhukaKbn.KJKHUKA : C_KjkhukaKbn.BLNK;
        super.setSbuktnmkjhukakbn1(sbuktnmkjhukakbn1);
    }

    @Override
    public Boolean getSbuktnmkjkhuka2() {
        return C_KjkhukaKbn.KJKHUKA.eq(super.getSbuktnmkjhukakbn2()) ? Boolean.TRUE : Boolean.FALSE;
    }

    @Override
    public void setSbuktnmkjkhuka2(Boolean pSbuktnmkjkhuka2) {
        super.setSbuktnmkjkhuka2(pSbuktnmkjkhuka2);
        C_KjkhukaKbn sbuktnmkjhukakbn2 = pSbuktnmkjkhuka2 ? C_KjkhukaKbn.KJKHUKA : C_KjkhukaKbn.BLNK;
        super.setSbuktnmkjhukakbn2(sbuktnmkjhukakbn2);
    }

    @Override
    public Boolean getSbuktnmkjkhuka3() {
        return C_KjkhukaKbn.KJKHUKA.eq(super.getSbuktnmkjhukakbn3()) ? Boolean.TRUE : Boolean.FALSE;
    }

    @Override
    public void setSbuktnmkjkhuka3(Boolean pSbuktnmkjkhuka3) {
        super.setSbuktnmkjkhuka3(pSbuktnmkjkhuka3);
        C_KjkhukaKbn sbuktnmkjhukakbn3 = pSbuktnmkjkhuka3 ? C_KjkhukaKbn.KJKHUKA : C_KjkhukaKbn.BLNK;
        super.setSbuktnmkjhukakbn3(sbuktnmkjhukakbn3);
    }

    @Override
    public Boolean getSbuktnmkjkhuka4() {
        return C_KjkhukaKbn.KJKHUKA.eq(super.getSbuktnmkjhukakbn4()) ? Boolean.TRUE : Boolean.FALSE;
    }

    @Override
    public void setSbuktnmkjkhuka4(Boolean pSbuktnmkjkhuka4) {
        super.setSbuktnmkjkhuka4(pSbuktnmkjkhuka4);
        C_KjkhukaKbn sbuktnmkjhukakbn4 = pSbuktnmkjkhuka4 ? C_KjkhukaKbn.KJKHUKA : C_KjkhukaKbn.BLNK;
        super.setSbuktnmkjhukakbn4(sbuktnmkjhukakbn4);
    }

    @Override
    public Boolean getStdrsknmkjkhuka() {
        return C_KjkhukaKbn.KJKHUKA.eq(super.getStdrsknmkjhukakbn()) ? Boolean.TRUE : Boolean.FALSE;
    }

    @Override
    public void setStdrsknmkjkhuka(Boolean pStdrsknmkjkhuka) {
        super.setStdrsknmkjkhuka(pStdrsknmkjkhuka);
        C_KjkhukaKbn stdrsknmkjhukakbn = pStdrsknmkjkhuka ? C_KjkhukaKbn.KJKHUKA : C_KjkhukaKbn.BLNK;
        super.setStdrsknmkjhukakbn(stdrsknmkjhukakbn);
    }

    @Override
    public Boolean getTkhsyouryaku() {
        return C_UmuKbn.ARI.eq(super.getTkhsyouryakuumukbn()) ? Boolean.TRUE : Boolean.FALSE;
    }

    @Override
    public void setTkhsyouryaku(Boolean pTkhsyouryaku) {
        super.setTkhsyouryaku(pTkhsyouryaku);
        C_UmuKbn tkhsyouryakuumukbn = pTkhsyouryaku ? C_UmuKbn.ARI : C_UmuKbn.NONE;
        super.setTkhsyouryakuumukbn(tkhsyouryakuumukbn);
    }

    @Override
    public C_HknsyuruiNo getHknsyuruino() {
        return BizUtil.isBlank(super.getHknsyuruinomosinput()) ? C_HknsyuruiNo.BLNK : C_HknsyuruiNo.valueOf(super.getHknsyuruinomosinput());
    }

    private C_Tkhukaumu yennykntkhkkbn;

    public C_Tkhukaumu getYennykntkhkkbn() {
        return yennykntkhkkbn;
    }

    public void setYennykntkhkkbn(C_Tkhukaumu pYennykntkhkkbn) {
        yennykntkhkkbn = pYennykntkhkkbn;
    }

    private C_Tkhukaumu gaikanykntkhkkbn;

    public C_Tkhukaumu getGaikanykntkhkkbn() {
        return gaikanykntkhkkbn;
    }

    public void setGaikanykntkhkkbn(C_Tkhukaumu pGaikanykntkhkkbn) {
        gaikanykntkhkkbn = pGaikanykntkhkkbn;
    }

    private C_TargetTkMokuhyoutiKbn targettkmkhtkbn;

    @Override
    public C_TargetTkMokuhyoutiKbn getTargettkmkhtkbn() {
        return targettkmkhtkbn;
    }

    public void setTargettkmkhtkbn(C_TargetTkMokuhyoutiKbn pTargettkmkhtkbn) {
        targettkmkhtkbn = pTargettkmkhtkbn;
    }


    private C_TkykTratkiKbn tkyktratkikbn;

    public C_TkykTratkiKbn getTkyktratkikbn() {
        return tkyktratkikbn;
    }

    public void setTkyktratkikbn(C_TkykTratkiKbn pTkykTratkiKbn) {
        tkyktratkikbn = pTkykTratkiKbn;
    }

    private C_Sisuukbn sisuukbn;

    public C_Sisuukbn getSisuukbn() {
        return sisuukbn;
    }

    public void setSisuukbn(C_Sisuukbn pSisuukbn) {
        sisuukbn = pSisuukbn;
    }

    private C_HknsyuruiNo daihyouHknSyuruiNo;

    public C_HknsyuruiNo getDaihyouHknSyuruiNo() {
        return daihyouHknSyuruiNo;
    }

    public void setDaihyouHknSyuruiNo(C_HknsyuruiNo pDaihyouHknSyuruiNo) {
        daihyouHknSyuruiNo = pDaihyouHknSyuruiNo;
    }

    @Override
    public C_Sknenkinsyu getSknenkinsyu() {
        return BizUtil.isBlank(super.getNenkinsyumosinput()) ? C_Sknenkinsyu.BLNK : C_Sknenkinsyu.valueOf(super.getNenkinsyumosinput());
    }

    public C_HknsyuruiNo getInitHknsyuruino() {
        return InitHokenSyuruiNo;
    }

    private C_HknsyuruiNo InitHokenSyuruiNo;

    public void setInitHokenSyuruiNo(C_HknsyuruiNo pInitHokenSyuruiNo) {
        InitHokenSyuruiNo = pInitHokenSyuruiNo;

    }

    public Map<String, String>  getSisuunmSyutokuMap() {
        return sisuunmSyutokuMap;
    }

    private Map<String, String> sisuunmSyutokuMap;

    public void setSisuunmSyutokuMap(Map<String, String> pSisuunmSyutokuMap) {
        this.sisuunmSyutokuMap = pSisuunmSyutokuMap;
    }

    private String dispkzmeiginmkn ;

    public String getDispkzmeiginmkn() {
        return dispkzmeiginmkn;
    }

    public void setDispkzmeiginmkn(String pDispkzmeiginmkn) {
        this.dispkzmeiginmkn = pDispkzmeiginmkn;
    }

    private String newkzmeiginmkn ;

    public String getNewkzmeiginmkn() {
        return newkzmeiginmkn;
    }

    public void setNewkzmeiginmkn(String pNewkzmeiginmkn) {
        this.newkzmeiginmkn = pNewkzmeiginmkn;
    }

    private String syouhncd ;

    public String getSyouhncd() {
        return syouhncd;
    }

    public void setSyouhncd(String pSyouhncd) {
        this.syouhncd = pSyouhncd;
    }

    private Integer nkshrstartnen ;

    @Override
    public Integer getNkshrstartnen() {
        return nkshrstartnen;
    }

    public void setNkshrstartnen(Integer pnkshrstartnen) {
        this.nkshrstartnen = pnkshrstartnen;
    }

    private Integer phrkmnrynen ;

    @Override
    public Integer getPhrkmnrynen() {
        return phrkmnrynen;
    }

    public void setPhrkkknManryounen(Integer pPhrkmnrynen) {
        this.phrkmnrynen = pPhrkmnrynen;
    }

    public C_UmuKbn getItibuzennoutekiumu() {
        return itibuzennoutekiumu;
    }

    public void setItibuzennoutekiumu(C_UmuKbn pItibuzennoutekiumu) {
        itibuzennoutekiumu = pItibuzennoutekiumu;
    }

    public String getNkukthyoujimongon() {
        return nkukthyoujimongon;
    }

    public void setNkukthyoujimongon(String pNkukthyoujimongon) {
        nkukthyoujimongon = pNkukthyoujimongon;
    }

    public String[] getHubimsgData2() {
        return hubimsgData2;
    }

    public void setHubimsgData2(String[] pHubimsgData2) {
        hubimsgData2 = pHubimsgData2;
    }

    public C_Tuukasyu getTaihikyktuukasyu() {
        return taihikyktuukasyu;
    }

    public void setTaihikyktuukasyu(C_Tuukasyu pTaihikyktuukasyu) {
        this.taihikyktuukasyu = pTaihikyktuukasyu;
    }

    public C_Tuukasyu getTaihihrktuukasyu() {
        return taihihrktuukasyu;
    }

    public void setTaihihrktuukasyu(C_Tuukasyu pTaihihrktuukasyu) {
        this.taihihrktuukasyu = pTaihihrktuukasyu;
    }

    public C_Tuukasyu getTaihikyktuukasyu2() {
        return taihikyktuukasyu2;
    }

    public void setTaihikyktuukasyu2(C_Tuukasyu pTaihikyktuukasyu2) {
        this.taihikyktuukasyu2 = pTaihikyktuukasyu2;
    }

    public C_Tuukasyu getTaihihrktuukasyu2() {
        return taihihrktuukasyu2;
    }

    public void setTaihihrktuukasyu2(C_Tuukasyu pTaihihrktuukasyu2) {
        this.taihihrktuukasyu2 = pTaihihrktuukasyu2;
    }

    public C_UmuKbn  getMos2hyoujiumuKbn() {
        return mos2hyoujiumuKbn;
    }

    public void setMos2hyoujiumuKbn(C_UmuKbn  pMos2hyoujiumuKbn) {
        mos2hyoujiumuKbn = pMos2hyoujiumuKbn;
    }

    public boolean isTaihyoumousikomiUmu() {
        return taihyoumousikomiUmu;
    }

    public void setTaihyoumousikomiUmu(boolean pTaihyoumousikomiUmu) {
        this.taihyoumousikomiUmu = pTaihyoumousikomiUmu;
    }

    public boolean isAiteimousikomiUmu() {
        return aiteimousikomiUmu;
    }

    public void setAiteimousikomiUmu(boolean pAiteimousikomiUmu) {
        this.aiteimousikomiUmu = pAiteimousikomiUmu;
    }

    public BizCurrency getMosfstpkei2() {
        return mosfstpkei2;
    }

    public void setMosfstpkei2(BizCurrency pMosfstpkei2) {
        this.mosfstpkei2 = pMosfstpkei2;
    }

    public String getZouhabakouteikanriid() {
        return zouhabakouteikanriid;
    }

    public void setZouhabakouteikanriid(String pZouhabakouteikanriid) {
        this.zouhabakouteikanriid = pZouhabakouteikanriid;
    }

    public String getKrkekouteikanriid() {
        return krkekouteikanriid;
    }

    public void setKrkekouteikanriid(String pKrkekouteikanriid) {
        this.krkekouteikanriid = pKrkekouteikanriid;
    }

    public C_Sdpd getTaihisdpdkbn() {
        return taihisdpdkbn;
    }

    public void setTaihisdpdkbn(C_Sdpd pTaihisdpdkbn) {
        this.taihisdpdkbn = pTaihisdpdkbn;
    }

    public List<BT_GyoumuKouteiInfo> getGyoumuKouteiInfoLst() {
        return gyoumuKouteiInfoLst;
    }

    public void setGyoumuKouteiInfoLst(List<BT_GyoumuKouteiInfo> pGyoumuKouteiInfoLst) {
        this.gyoumuKouteiInfoLst = pGyoumuKouteiInfoLst;
    }

    @Override
    public void setKouzainfoinputhoryuu(Boolean pKouzainfoinputhoryuu) {

        super.setKouzainfoinputhoryuu(pKouzainfoinputhoryuu);

        C_KouzaInfoInputHoryuuKbn kbn = pKouzainfoinputhoryuu ? C_KouzaInfoInputHoryuuKbn.HORYUU:C_KouzaInfoInputHoryuuKbn.BLNK;

        super.setKouzainfoinputhoryuukbn(kbn);
    }

    private C_Tuukasyu kyktuukasyu;

    @Override
    public C_Tuukasyu getKyktuukasyu() {
        return kyktuukasyu;
    }

    public void setKyktuukasyu(C_Tuukasyu pKyktuukasyu) {
        this.kyktuukasyu = pKyktuukasyu;
    }

    private C_Tuukasyu hrktuukasyu;

    @Override
    public C_Tuukasyu getHrktuukasyu() {
        return hrktuukasyu;
    }

    public void setHrktuukasyu(C_Tuukasyu pHrktuukasyu) {
        this.hrktuukasyu = pHrktuukasyu;
    }

    private C_Tuukasyu kyktuukasyu2;

    @Override
    public C_Tuukasyu getKyktuukasyu2() {
        return kyktuukasyu2;
    }

    public void setKyktuukasyu2(C_Tuukasyu pKyktuukasyu2) {
        this.kyktuukasyu2 = pKyktuukasyu2;
    }

    private C_Tuukasyu hrktuukasyu2;

    @Override
    public C_Tuukasyu getHrktuukasyu2() {
        return hrktuukasyu2;
    }

    public void setHrktuukasyu2(C_Tuukasyu pHrktuukasyu2) {
        this.hrktuukasyu2 = pHrktuukasyu2;
    }

    private C_Hrkkaisuu hrkkaisuu;

    @Override
    public C_Hrkkaisuu getHrkkaisuu() {
        return hrkkaisuu;
    }

    public void setHrkkaisuu(C_Hrkkaisuu pHrkkaisuu) {
        this.hrkkaisuu = pHrkkaisuu;
    }

    private C_BlnktkumuKbn zenkizennouumu;

    @Override
    public C_BlnktkumuKbn getZenkizennouumu() {
        return zenkizennouumu;
    }

    public void setZenkizennouumu(C_BlnktkumuKbn pZenkizennouumu) {
        this.zenkizennouumu = pZenkizennouumu;
    }

    private C_IkkatubaraiKaisuuKbn ikkatubaraikaisuu;

    @Override
    public C_IkkatubaraiKaisuuKbn getIkkatubaraikaisuu() {
        return ikkatubaraikaisuu;
    }

    public void setIkkatubaraikaisuu(C_IkkatubaraiKaisuuKbn pIkkatubaraikaisuu) {
        this.ikkatubaraikaisuu = pIkkatubaraikaisuu;
    }

    @Override
    public void setTrkkzknmkjkhuka1(Boolean pTrkkzknmkjkhuka1) {
        super.setTrkkzknmkjkhuka1(pTrkkzknmkjkhuka1);
        C_KjkhukaKbn trkkzknmkjkhukakbn1 =  pTrkkzknmkjkhuka1 ? C_KjkhukaKbn.KJKHUKA:C_KjkhukaKbn.BLNK;
        super.setTrkkzknmkjkhukakbn1(trkkzknmkjkhukakbn1);
    }

    @Override
    public void setTrkkzknmkjkhuka2(Boolean pTrkkzknmkjkhuka2) {
        super.setTrkkzknmkjkhuka2(pTrkkzknmkjkhuka2);
        C_KjkhukaKbn trkkzknmkjkhukakbn2 =  pTrkkzknmkjkhuka2 ? C_KjkhukaKbn.KJKHUKA:C_KjkhukaKbn.BLNK;
        super.setTrkkzknmkjkhukakbn2(trkkzknmkjkhukakbn2);
    }

    @Override
    public void setTrkkzktsindousitei1(Boolean pTrkkzktsindousitei1) {
        super.setTrkkzktsindousitei1(pTrkkzktsindousitei1);
        C_TsindousiteiKbn trkkzktsindousiteikbn1 = pTrkkzktsindousitei1 ? C_TsindousiteiKbn.ARI : C_TsindousiteiKbn.BLNK;
        super.setTrkkzktsindousiteikbn1(trkkzktsindousiteikbn1);
    }

    @Override
    public void setTrkkzktsindousitei2(Boolean pTrkkzktsindousitei2) {
        super.setTrkkzktsindousitei2(pTrkkzktsindousitei2);
        C_TsindousiteiKbn trkkzktsindousiteikbn2 = pTrkkzktsindousitei2 ? C_TsindousiteiKbn.ARI : C_TsindousiteiKbn.BLNK;
        super.setTrkkzktsindousiteikbn2(trkkzktsindousiteikbn2);
    }

    @Override
    public void setTrkkzknmkjkhukakbn1(C_KjkhukaKbn pTrkkzknmkjkhukakbn1) {
        super.setTrkkzknmkjkhukakbn1(pTrkkzknmkjkhukakbn1);

        if (C_KjkhukaKbn.KJKHUKA.eq(pTrkkzknmkjkhukakbn1)) {
            super.setTrkkzknmkjkhuka1(true);
        }
        else {
            super.setTrkkzknmkjkhuka1(false);
        }
    }

    @Override
    public void setTrkkzknmkjkhukakbn2(C_KjkhukaKbn pTrkkzknmkjkhukakbn2) {
        super.setTrkkzknmkjkhukakbn2(pTrkkzknmkjkhukakbn2);

        if (C_KjkhukaKbn.KJKHUKA.eq(pTrkkzknmkjkhukakbn2)) {
            super.setTrkkzknmkjkhuka2(true);
        }
        else {
            super.setTrkkzknmkjkhuka2(false);
        }
    }

    @Override
    public void setTrkkzktsindousiteikbn1(C_TsindousiteiKbn pTrkkzktsindousiteikbn1) {
        super.setTrkkzktsindousiteikbn1(pTrkkzktsindousiteikbn1);
        if (C_TsindousiteiKbn.ARI.eq(pTrkkzktsindousiteikbn1)) {
            super.setTrkkzktsindousitei1(true);
        }
        else {
            super.setTrkkzktsindousitei1(false);
        }
    }

    @Override
    public void setTrkkzktsindousiteikbn2(C_TsindousiteiKbn pTrkkzktsindousiteikbn2) {
        super.setTrkkzktsindousiteikbn2(pTrkkzktsindousiteikbn2);
        if (C_TsindousiteiKbn.ARI.eq(pTrkkzktsindousiteikbn2)) {
            super.setTrkkzktsindousitei2(true);
        }
        else {
            super.setTrkkzktsindousitei2(false);
        }
    }

    private String shkstkzinfkzinfodispkzmeiginmkn ;

    public String getShkstkzinfkzinfoDispkzmeiginmkn() {
        return shkstkzinfkzinfodispkzmeiginmkn;
    }

    public void setShkstkzinfkzinfoDispkzmeiginmkn(String pShkstkzinfkzinfodispkzmeiginmkn) {
        this.shkstkzinfkzinfodispkzmeiginmkn = pShkstkzinfkzinfodispkzmeiginmkn;
    }

    private String shkstkzinfkzinfonewkzmeiginmkn ;

    public String getShkstkzinfkzinfoNewkzmeiginmkn() {
        return shkstkzinfkzinfonewkzmeiginmkn;
    }

    public void setShkstkzinfkzinfoNewkzmeiginmkn(String pShkstkzinfkzinfonewkzmeiginmkn) {
        this.shkstkzinfkzinfonewkzmeiginmkn = pShkstkzinfkzinfonewkzmeiginmkn;
    }

    @Override
    public void setShkstkzinfkzinfoinputhry(Boolean pShkstkzinfkzinfoinputhry) {
        super.setShkstkzinfkzinfoinputhry(pShkstkzinfkzinfoinputhry);
        C_KouzaInfoInputHoryuuKbn kouzaInfoInputHoryuuKbn = pShkstkzinfkzinfoinputhry ? C_KouzaInfoInputHoryuuKbn.HORYUU : C_KouzaInfoInputHoryuuKbn.BLNK;
        super.setShkstkzinfkzinfoinputhrykbn(kouzaInfoInputHoryuuKbn);
    }

    @Override
    public void setShkstkzinfkzinfoinputhrykbn(C_KouzaInfoInputHoryuuKbn pShkstkzinfkzinfoinputhrykbn) {
        super.setShkstkzinfkzinfoinputhrykbn(pShkstkzinfkzinfoinputhrykbn);
        if (C_KouzaInfoInputHoryuuKbn.HORYUU.eq(pShkstkzinfkzinfoinputhrykbn)) {
            super.setShkstkzinfkzinfoinputhry(true);
        }
        else {
            super.setShkstkzinfkzinfoinputhry(false);
        }
    }

    @Override
    public void setHknsyuruinomosinputOptionBeanList(UserDefsList pHknsyuruinomosinputOptionBeanList) {
        super.clearHknsyuruinomosinputOptionBeanList();
        super.setHknsyuruinomosinputOptionBeanList(pHknsyuruinomosinputOptionBeanList);
    }

}