package yuyu.app.sinkeiyaku.sksyoukai.skmossyoukai;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.app.sinkeiyaku.sksyoukai.skmossyoukai.SkMosSyoukaiConstants.E_SyoriKeiyu;
import yuyu.common.biz.koutei.BzWorkflowInfo;
import yuyu.common.biz.syoruiitiran.SetSyoruiInfoItiranExecUiBeanParam;
import yuyu.common.biz.syoruiitiran.SyoruiInfoItiranDataSourceBeanCommonParam;
import yuyu.common.biz.syoruiitiran.viewsyoruiinfoitiran.ViewSyoruiInfoItiranUiBeanParam;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_Nstkumu;
import yuyu.def.classification.C_PWaribikiKbn;
import yuyu.def.classification.C_PtratkituukasiteiKbn;
import yuyu.def.classification.C_TargetTkHukaKanouKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.sinkeiyaku.result.bean.SyoukaiIchiranInfosByMosymdBosyuuymItemsBean;

import com.google.common.collect.Lists;

/**
 * 申込状況照会 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class SkMosSyoukaiUiBean extends GenSkMosSyoukaiUiBean implements
ViewSyoruiInfoItiranUiBeanParam, SetSyoruiInfoItiranExecUiBeanParam{

    private static final long serialVersionUID = 1L;

    private C_UmuKbn kyksyoukaiKngnUmu;

    private C_UmuKbn mosuktYmdHkUmu;

    private List<SyoukaiIchiranInfosByMosymdBosyuuymItemsBean> kensakuKekkaLst;

    private String srchDaimosno;

    private BizDateYM srchBosyuuym;

    private String daimosno;

    private Integer sbuUktSyurenNo1;

    private Integer sbuUktSyurenNo2;

    private Integer sbuUktSyurenNo3;

    private Integer sbuUktSyurenNo4;

    private Integer mosDairitenRenno1;

    private Integer mosDairitenRenno2;

    private E_SyoriKeiyu gmSyoriKbn;

    private Integer mostenkenRirekiNo1;

    private Integer mostenkenRirekiNo2;

    private Integer mostenkenRirekiNo3;

    private Integer mostenkenRirekiNo4;

    private Integer mostenkenRirekiNo5;

    private Integer mostenkenRirekiNo6;

    private Integer mostenkenRirekiNo7;

    private Integer mostenkenRirekiNo8;

    private Integer mostenkenRirekiNo9;

    private Integer mostenkenRirekiNo10;

    private Integer mostenkenRirekiNo11;

    private Integer mostenkenRirekiNo12;

    private Integer mostenkenRirekiNo13;

    private Integer mostenkenRirekiNo14;

    private Integer mostenkenRirekiNo15;

    private Integer kankyouSateiRirekiNo1;

    private Integer kankyouSateiRirekiNo2;

    private Integer kankyouSateiRirekiNo3;

    private Integer kankyouSateiRirekiNo4;

    private Integer kankyouSateiRirekiNo5;

    private Integer kankyouSateiRirekiNo6;

    private Integer kankyouSateiRirekiNo7;

    private Integer kankyouSateiRirekiNo8;

    private Integer kankyouSateiRirekiNo9;

    private Integer kankyouSateiRirekiNo10;

    private Integer kankyouSateiRirekiNo11;

    private Integer kankyouSateiRirekiNo12;

    private Integer kankyouSateiRirekiNo13;

    private Integer kankyouSateiRirekiNo14;

    private Integer kankyouSateiRirekiNo15;

    private Integer imuSateiRenban1;

    private Integer imuSateiRenban2;

    private Integer imuSateiRenban3;

    private Integer imuSateiRenban4;

    private Integer imuSateiRenban5;

    private Integer imuSateiRenban6;

    private Integer imuSateiRenban7;

    private Integer imuSateiRenban8;

    private Integer imuSateiRenban9;

    private Integer imuSateiRenban10;

    private Integer imuSateiRenban11;

    private Integer imuSateiRenban12;

    private Integer imuSateiRenban13;

    private Integer imuSateiRenban14;

    private Integer imuSateiRenban15;

    private C_UmuKbn syokugyoukktumu;

    private C_UmuKbn  gaikatatkiumu;

    private C_UmuKbn  nkhknumu;

    private C_UmuKbn  hengakuumu;

    private C_Nstkumu  nstkumu;

    private C_TargetTkHukaKanouKbn targettkhukakanoukbn;

    private C_UmuKbn syksbyensitihsyutktekiumu;

    private C_UmuKbn jyudkaigomehrtktekiumu;

    private C_UmuKbn  syuusinhknumu;

    private C_UmuKbn  sbuktumu;

    private C_UmuKbn  teikisiharaikinumu;

    private String[] imageids;

    private C_UmuKbn keikokuMsgUmu;

    private C_UmuKbn mqErrMsgUmu;

    private C_UmuKbn palAteSyoukaiErrMsgUmu;

    private C_UmuKbn sknInfoSyoukaiErrMsgUmu;

    private boolean sknInfoKensakuFlag;

    private C_UmuKbn kykdrtentuusanumu;

    private C_UmuKbn tmttknhaibunwarisiteiumu;

    private C_UmuKbn nkuktumu;

    @Inject
    private BzWorkflowInfo bzWorkflowInfo;

    private C_UmuKbn zennoumousideumu;

    private C_UmuKbn zeiseitekikakuumu;

    private C_UmuKbn zennouumu;

    private C_UmuKbn kouzahurikaebaraitekiumu;

    private C_UmuKbn pyennykntktekiumu;

    private C_UmuKbn gaikanyuukintktekiumu;

    private C_UmuKbn heijyunbaraiumu;

    private C_UmuKbn teikiikkatubaraiumu;

    private C_PWaribikiKbn pwaribikikbn;

    private C_UmuKbn creditcardhrtekiumu;

    private C_HknsyuruiNo seigyoHknsyuruino;

    private C_PtratkituukasiteiKbn ptratkituukasiteikbn;

    private C_UmuKbn hokenkngkyakujyouumu;

    public SkMosSyoukaiUiBean() {
    }

    public C_UmuKbn getKyksyoukaiKngnUmu() {
        return kyksyoukaiKngnUmu;
    }

    public void setKyksyoukaiKngnUmu(C_UmuKbn pKyksyoukaiKngnUmu) {
        kyksyoukaiKngnUmu = pKyksyoukaiKngnUmu;
    }

    public C_UmuKbn getMosuktYmdHkUmu() {
        return mosuktYmdHkUmu;
    }

    public void setMosuktYmdHkUmu(C_UmuKbn pMosuktYmdHkUmu) {
        mosuktYmdHkUmu = pMosuktYmdHkUmu;
    }

    public List<SyoukaiIchiranInfosByMosymdBosyuuymItemsBean> getKensakuKekkaLst() {
        return kensakuKekkaLst;
    }

    public void setKensakuKekkaLst(List<SyoukaiIchiranInfosByMosymdBosyuuymItemsBean> pKensakuKekkaLst) {
        kensakuKekkaLst = pKensakuKekkaLst;
    }

    public String getSrchDaimosno() {
        return srchDaimosno;
    }

    public void setSrchDaimosno(String pSrchDaimosno) {
        srchDaimosno = pSrchDaimosno;
    }

    public BizDateYM getSrchBosyuuym() {
        return srchBosyuuym;
    }

    public void setSrchBosyuuym(BizDateYM pSrchBosyuuym) {
        srchBosyuuym = pSrchBosyuuym;
    }

    public String getDaimosno() {
        return daimosno;
    }

    public void setDaimosno(String pDaimosno) {
        daimosno = pDaimosno;
    }

    public Integer getSbuUktSyurenNo1() {
        return sbuUktSyurenNo1;
    }

    public void setSbuUktSyurenNo1(Integer pSbuUktSyurenNo1) {
        sbuUktSyurenNo1 = pSbuUktSyurenNo1;
    }

    public Integer getSbuUktSyurenNo2() {
        return sbuUktSyurenNo2;
    }

    public void setSbuUktSyurenNo2(Integer pSbuUktSyurenNo2) {
        sbuUktSyurenNo2 = pSbuUktSyurenNo2;
    }

    public Integer getSbuUktSyurenNo3() {
        return sbuUktSyurenNo3;
    }

    public void setSbuUktSyurenNo3(Integer pSbuUktSyurenNo3) {
        sbuUktSyurenNo3 = pSbuUktSyurenNo3;
    }

    public Integer getSbuUktSyurenNo4() {
        return sbuUktSyurenNo4;
    }

    public void setSbuUktSyurenNo4(Integer pSbuUktSyurenNo4) {
        sbuUktSyurenNo4 = pSbuUktSyurenNo4;
    }

    public Integer getMosDairitenRenno1() {
        return mosDairitenRenno1;
    }

    public void setMosDairitenRenno1(Integer pMosDairitenRenno1) {
        mosDairitenRenno1 = pMosDairitenRenno1;
    }

    public Integer getMosDairitenRenno2() {
        return mosDairitenRenno2;
    }

    public void setMosDairitenRenno2(Integer pMosDairitenRenno2) {
        mosDairitenRenno2 = pMosDairitenRenno2;
    }

    public E_SyoriKeiyu getGmSyoriKbn() {
        return gmSyoriKbn;
    }

    public void setGmSyoriKbn(E_SyoriKeiyu pGmSyoriKbn) {
        gmSyoriKbn = pGmSyoriKbn;
    }

    public Integer getMostenkenRirekiNo1() {
        return mostenkenRirekiNo1;
    }

    public void setMostenkenRirekiNo1(Integer pMostenkenRirekiNo1) {
        mostenkenRirekiNo1 = pMostenkenRirekiNo1;
    }

    public Integer getMostenkenRirekiNo2() {
        return mostenkenRirekiNo2;
    }

    public void setMostenkenRirekiNo2(Integer pMostenkenRirekiNo2) {
        mostenkenRirekiNo2 = pMostenkenRirekiNo2;
    }

    public Integer getMostenkenRirekiNo3() {
        return mostenkenRirekiNo3;
    }

    public void setMostenkenRirekiNo3(Integer pMostenkenRirekiNo3) {
        mostenkenRirekiNo3 = pMostenkenRirekiNo3;
    }

    public Integer getMostenkenRirekiNo4() {
        return mostenkenRirekiNo4;
    }

    public void setMostenkenRirekiNo4(Integer pMostenkenRirekiNo4) {
        mostenkenRirekiNo4 = pMostenkenRirekiNo4;
    }

    public Integer getMostenkenRirekiNo5() {
        return mostenkenRirekiNo5;
    }

    public void setMostenkenRirekiNo5(Integer pMostenkenRirekiNo5) {
        mostenkenRirekiNo5 = pMostenkenRirekiNo5;
    }

    public Integer getMostenkenRirekiNo6() {
        return mostenkenRirekiNo6;
    }

    public void setMostenkenRirekiNo6(Integer pMostenkenRirekiNo6) {
        mostenkenRirekiNo6 = pMostenkenRirekiNo6;
    }

    public Integer getMostenkenRirekiNo7() {
        return mostenkenRirekiNo7;
    }

    public void setMostenkenRirekiNo7(Integer pMostenkenRirekiNo7) {
        mostenkenRirekiNo7 = pMostenkenRirekiNo7;
    }

    public Integer getMostenkenRirekiNo8() {
        return mostenkenRirekiNo8;
    }

    public void setMostenkenRirekiNo8(Integer pMostenkenRirekiNo8) {
        mostenkenRirekiNo8 = pMostenkenRirekiNo8;
    }

    public Integer getMostenkenRirekiNo9() {
        return mostenkenRirekiNo9;
    }

    public void setMostenkenRirekiNo9(Integer pMostenkenRirekiNo9) {
        mostenkenRirekiNo9 = pMostenkenRirekiNo9;
    }

    public Integer getMostenkenRirekiNo10() {
        return mostenkenRirekiNo10;
    }

    public void setMostenkenRirekiNo10(Integer pMostenkenRirekiNo10) {
        mostenkenRirekiNo10 = pMostenkenRirekiNo10;
    }

    public Integer getMostenkenRirekiNo11() {
        return mostenkenRirekiNo11;
    }

    public void setMostenkenRirekiNo11(Integer pMostenkenRirekiNo11) {
        mostenkenRirekiNo11 = pMostenkenRirekiNo11;
    }

    public Integer getMostenkenRirekiNo12() {
        return mostenkenRirekiNo12;
    }

    public void setMostenkenRirekiNo12(Integer pMostenkenRirekiNo12) {
        mostenkenRirekiNo12 = pMostenkenRirekiNo12;
    }

    public Integer getMostenkenRirekiNo13() {
        return mostenkenRirekiNo13;
    }

    public void setMostenkenRirekiNo13(Integer pMostenkenRirekiNo13) {
        mostenkenRirekiNo13 = pMostenkenRirekiNo13;
    }

    public Integer getMostenkenRirekiNo14() {
        return mostenkenRirekiNo14;
    }

    public void setMostenkenRirekiNo14(Integer pMostenkenRirekiNo14) {
        mostenkenRirekiNo14 = pMostenkenRirekiNo14;
    }

    public Integer getMostenkenRirekiNo15() {
        return mostenkenRirekiNo15;
    }

    public void setMostenkenRirekiNo15(Integer pMostenkenRirekiNo15) {
        mostenkenRirekiNo15 = pMostenkenRirekiNo15;
    }

    public Integer getKankyouSateiRirekiNo1() {
        return kankyouSateiRirekiNo1;
    }

    public void setKankyouSateiRirekiNo1(Integer pKankyouSateiRirekiNo1) {
        kankyouSateiRirekiNo1 = pKankyouSateiRirekiNo1;
    }

    public Integer getKankyouSateiRirekiNo2() {
        return kankyouSateiRirekiNo2;
    }

    public void setKankyouSateiRirekiNo2(Integer pKankyouSateiRirekiNo2) {
        kankyouSateiRirekiNo2 = pKankyouSateiRirekiNo2;
    }

    public Integer getKankyouSateiRirekiNo3() {
        return kankyouSateiRirekiNo3;
    }

    public void setKankyouSateiRirekiNo3(Integer pKankyouSateiRirekiNo3) {
        kankyouSateiRirekiNo3 = pKankyouSateiRirekiNo3;
    }

    public Integer getKankyouSateiRirekiNo4() {
        return kankyouSateiRirekiNo4;
    }

    public void setKankyouSateiRirekiNo4(Integer pKankyouSateiRirekiNo4) {
        kankyouSateiRirekiNo4 = pKankyouSateiRirekiNo4;
    }

    public Integer getKankyouSateiRirekiNo5() {
        return kankyouSateiRirekiNo5;
    }

    public void setKankyouSateiRirekiNo5(Integer pKankyouSateiRirekiNo5) {
        kankyouSateiRirekiNo5 = pKankyouSateiRirekiNo5;
    }

    public Integer getKankyouSateiRirekiNo6() {
        return kankyouSateiRirekiNo6;
    }

    public void setKankyouSateiRirekiNo6(Integer pKankyouSateiRirekiNo6) {
        kankyouSateiRirekiNo6 = pKankyouSateiRirekiNo6;
    }

    public Integer getKankyouSateiRirekiNo7() {
        return kankyouSateiRirekiNo7;
    }

    public void setKankyouSateiRirekiNo7(Integer pKankyouSateiRirekiNo7) {
        kankyouSateiRirekiNo7 = pKankyouSateiRirekiNo7;
    }

    public Integer getKankyouSateiRirekiNo8() {
        return kankyouSateiRirekiNo8;
    }

    public void setKankyouSateiRirekiNo8(Integer pKankyouSateiRirekiNo8) {
        kankyouSateiRirekiNo8 = pKankyouSateiRirekiNo8;
    }

    public Integer getKankyouSateiRirekiNo9() {
        return kankyouSateiRirekiNo9;
    }

    public void setKankyouSateiRirekiNo9(Integer pKankyouSateiRirekiNo9) {
        kankyouSateiRirekiNo9 = pKankyouSateiRirekiNo9;
    }

    public Integer getKankyouSateiRirekiNo10() {
        return kankyouSateiRirekiNo10;
    }

    public void setKankyouSateiRirekiNo10(Integer pKankyouSateiRirekiNo10) {
        kankyouSateiRirekiNo10 = pKankyouSateiRirekiNo10;
    }

    public Integer getKankyouSateiRirekiNo11() {
        return kankyouSateiRirekiNo11;
    }

    public void setKankyouSateiRirekiNo11(Integer pKankyouSateiRirekiNo11) {
        kankyouSateiRirekiNo11 = pKankyouSateiRirekiNo11;
    }

    public Integer getKankyouSateiRirekiNo12() {
        return kankyouSateiRirekiNo12;
    }

    public void setKankyouSateiRirekiNo12(Integer pKankyouSateiRirekiNo12) {
        kankyouSateiRirekiNo12 = pKankyouSateiRirekiNo12;
    }

    public Integer getKankyouSateiRirekiNo13() {
        return kankyouSateiRirekiNo13;
    }

    public void setKankyouSateiRirekiNo13(Integer pKankyouSateiRirekiNo13) {
        kankyouSateiRirekiNo13 = pKankyouSateiRirekiNo13;
    }

    public Integer getKankyouSateiRirekiNo14() {
        return kankyouSateiRirekiNo14;
    }

    public void setKankyouSateiRirekiNo14(Integer pKankyouSateiRirekiNo14) {
        kankyouSateiRirekiNo14 = pKankyouSateiRirekiNo14;
    }

    public Integer getKankyouSateiRirekiNo15() {
        return kankyouSateiRirekiNo15;
    }

    public void setKankyouSateiRirekiNo15(Integer pKankyouSateiRirekiNo15) {
        kankyouSateiRirekiNo15 = pKankyouSateiRirekiNo15;
    }

    public Integer getImuSateiRenban1() {
        return imuSateiRenban1;
    }

    public void setImuSateiRenban1(Integer pImuSateiRenban1) {
        imuSateiRenban1 = pImuSateiRenban1;
    }

    public Integer getImuSateiRenban2() {
        return imuSateiRenban2;
    }

    public void setImuSateiRenban2(Integer pImuSateiRenban2) {
        imuSateiRenban2 = pImuSateiRenban2;
    }

    public Integer getImuSateiRenban3() {
        return imuSateiRenban3;
    }

    public void setImuSateiRenban3(Integer pImuSateiRenban3) {
        imuSateiRenban3 = pImuSateiRenban3;
    }

    public Integer getImuSateiRenban4() {
        return imuSateiRenban4;
    }

    public void setImuSateiRenban4(Integer pImuSateiRenban4) {
        imuSateiRenban4 = pImuSateiRenban4;
    }

    public Integer getImuSateiRenban5() {
        return imuSateiRenban5;
    }

    public void setImuSateiRenban5(Integer pImuSateiRenban5) {
        imuSateiRenban5 = pImuSateiRenban5;
    }

    public Integer getImuSateiRenban6() {
        return imuSateiRenban6;
    }

    public void setImuSateiRenban6(Integer pImuSateiRenban6) {
        imuSateiRenban6 = pImuSateiRenban6;
    }

    public Integer getImuSateiRenban7() {
        return imuSateiRenban7;
    }

    public void setImuSateiRenban7(Integer pImuSateiRenban7) {
        imuSateiRenban7 = pImuSateiRenban7;
    }

    public Integer getImuSateiRenban8() {
        return imuSateiRenban8;
    }

    public void setImuSateiRenban8(Integer pImuSateiRenban8) {
        imuSateiRenban8 = pImuSateiRenban8;
    }

    public Integer getImuSateiRenban9() {
        return imuSateiRenban9;
    }

    public void setImuSateiRenban9(Integer pImuSateiRenban9) {
        imuSateiRenban9 = pImuSateiRenban9;
    }

    public Integer getImuSateiRenban10() {
        return imuSateiRenban10;
    }

    public void setImuSateiRenban10(Integer pImuSateiRenban10) {
        imuSateiRenban10 = pImuSateiRenban10;
    }

    public Integer getImuSateiRenban11() {
        return imuSateiRenban11;
    }

    public void setImuSateiRenban11(Integer pImuSateiRenban11) {
        imuSateiRenban11 = pImuSateiRenban11;
    }

    public Integer getImuSateiRenban12() {
        return imuSateiRenban12;
    }

    public void setImuSateiRenban12(Integer pImuSateiRenban12) {
        imuSateiRenban12 = pImuSateiRenban12;
    }

    public Integer getImuSateiRenban13() {
        return imuSateiRenban13;
    }

    public void setImuSateiRenban13(Integer pImuSateiRenban13) {
        imuSateiRenban13 = pImuSateiRenban13;
    }

    public Integer getImuSateiRenban14() {
        return imuSateiRenban14;
    }

    public void setImuSateiRenban14(Integer pImuSateiRenban14) {
        imuSateiRenban14 = pImuSateiRenban14;
    }

    public Integer getImuSateiRenban15() {
        return imuSateiRenban15;
    }

    public void setImuSateiRenban15(Integer pImuSateiRenban15) {
        imuSateiRenban15 = pImuSateiRenban15;
    }

    public C_UmuKbn getSyokugyoukktumu() {
        return syokugyoukktumu;
    }

    public void setSyokugyoukktumu(C_UmuKbn pSyokugyoukktumu) {
        syokugyoukktumu = pSyokugyoukktumu;
    }

    public C_UmuKbn getGaikatatkiumu() {
        return gaikatatkiumu;
    }

    public void setGaikatatkiumu(C_UmuKbn pGaikatatkiumu) {
        gaikatatkiumu = pGaikatatkiumu;
    }

    public C_UmuKbn getNkhknumu() {
        return nkhknumu;
    }

    public void setNkhknumu(C_UmuKbn pNkhknumu) {
        nkhknumu = pNkhknumu;
    }

    public C_UmuKbn getHengakuumu() {
        return hengakuumu;
    }

    public void setHengakuumu(C_UmuKbn pHengakuumu) {
        hengakuumu = pHengakuumu;
    }

    public C_Nstkumu getNstkumu() {
        return nstkumu;
    }

    public void setNstkumu(C_Nstkumu pNstkumu) {
        nstkumu = pNstkumu;
    }

    public C_TargetTkHukaKanouKbn getTargettkhukakanoukbn() {
        return targettkhukakanoukbn;
    }

    public void setTargettkhukakanoukbn(C_TargetTkHukaKanouKbn pTargettkhukakanoukbn) {
        targettkhukakanoukbn = pTargettkhukakanoukbn;
    }

    public C_UmuKbn getSyksbyensitihsyutktekiumu() {
        return syksbyensitihsyutktekiumu;
    }

    public void setSyksbyensitihsyutktekiumu(C_UmuKbn pSyksbyensitihsyutktekiumu) {
        syksbyensitihsyutktekiumu = pSyksbyensitihsyutktekiumu;
    }

    public C_UmuKbn getJyudkaigomehrtktekiumu() {
        return jyudkaigomehrtktekiumu;
    }

    public void setJyudkaigomehrtktekiumu(C_UmuKbn pJyudkaigomehrtktekiumu) {
        jyudkaigomehrtktekiumu = pJyudkaigomehrtktekiumu;
    }

    public C_UmuKbn getSyuusinhknumu() {
        return syuusinhknumu;
    }

    public void setSyuusinhknumu(C_UmuKbn pSyuusinhknumu) {
        syuusinhknumu = pSyuusinhknumu;
    }

    public C_UmuKbn getSbuktumu() {
        return sbuktumu;
    }

    public void setSbuktumu(C_UmuKbn pSbuktumu) {
        sbuktumu = pSbuktumu;
    }

    public C_UmuKbn getTeikisiharaikinumu() {
        return teikisiharaikinumu;
    }

    public void setTeikisiharaikinumu(C_UmuKbn pTeikisiharaikinumu) {
        teikisiharaikinumu = pTeikisiharaikinumu;
    }

    @Override
    public String[] getImageids() {
        return imageids;
    }

    @Override
    public void setImageids(String[] pImageids) {
        imageids = pImageids;
    }

    public C_UmuKbn getKeikokuMsgUmu() {
        return keikokuMsgUmu;
    }

    public void setKeikokuMsgUmu(C_UmuKbn pkeikokuMsgUmu) {
        keikokuMsgUmu = pkeikokuMsgUmu;
    }

    public C_UmuKbn getMqErrMsgUmu() {
        return mqErrMsgUmu;
    }

    public void setMqErrMsgUmu(C_UmuKbn pMqErrMsgUmu) {
        mqErrMsgUmu = pMqErrMsgUmu;
    }

    public C_UmuKbn getPalAteSyoukaiErrMsgUmu() {
        return palAteSyoukaiErrMsgUmu;
    }

    public void setPalAteSyoukaiErrMsgUmu(C_UmuKbn pPalAteSyoukaiErrMsgUmu) {
        palAteSyoukaiErrMsgUmu = pPalAteSyoukaiErrMsgUmu;
    }

    public C_UmuKbn getSknInfoSyoukaiErrMsgUmu() {
        return sknInfoSyoukaiErrMsgUmu;
    }

    public void setSknInfoSyoukaiErrMsgUmu(C_UmuKbn pSknInfoSyoukaiErrMsgUmu) {
        sknInfoSyoukaiErrMsgUmu = pSknInfoSyoukaiErrMsgUmu;
    }

    public boolean getSknInfoKensakuFlag() {
        return sknInfoKensakuFlag;
    }

    public void setSknInfoKensakuFlag(boolean pSknInfoKensakuFlag) {
        sknInfoKensakuFlag = pSknInfoKensakuFlag;
    }

    public C_UmuKbn getKykdrtentuusanumu() {
        return kykdrtentuusanumu;
    }

    public void setKykdrtentuusanumu(C_UmuKbn pKykdrtentuusanumu) {
        kykdrtentuusanumu = pKykdrtentuusanumu;
    }

    public C_UmuKbn getTmttknhaibunwarisiteiumu() {
        return tmttknhaibunwarisiteiumu;
    }

    public void setTmttknhaibunwarisiteiumu(C_UmuKbn pTmttknhaibunwarisiteiumu) {
        tmttknhaibunwarisiteiumu = pTmttknhaibunwarisiteiumu;
    }

    public C_UmuKbn getNkuktumu() {
        return nkuktumu;
    }

    public void setNkuktumu(C_UmuKbn pNkuktumu) {
        nkuktumu = pNkuktumu;
    }

    @Override
    public BzWorkflowInfo getBzWorkflowInfo() {
        return bzWorkflowInfo;
    }

    public void setBzWorkflowInfo(BzWorkflowInfo pBzWorkflowInfo) {
        bzWorkflowInfo = pBzWorkflowInfo;
    }

    public C_UmuKbn getZennoumousideumu() {
        return zennoumousideumu;
    }

    public void setZennoumousideumu(C_UmuKbn pZennoumousideumu) {
        this.zennoumousideumu = pZennoumousideumu;
    }

    public C_UmuKbn getZeiseitekikakuumu() {
        return zeiseitekikakuumu;
    }

    public void setZeiseitekikakuumu(C_UmuKbn pZeiseitekikakuumu) {
        this.zeiseitekikakuumu = pZeiseitekikakuumu;
    }

    public C_UmuKbn getZennouumu() {
        return zennouumu;
    }

    public void setZennouumu(C_UmuKbn pZennouumu) {
        this.zennouumu = pZennouumu;
    }

    public C_UmuKbn getKouzahurikaebaraitekiumu() {
        return kouzahurikaebaraitekiumu;
    }

    public void setKouzahurikaebaraitekiumu(C_UmuKbn pKouzahurikaebaraitekiumu) {
        this.kouzahurikaebaraitekiumu = pKouzahurikaebaraitekiumu;
    }

    public C_UmuKbn getPyennykntktekiumu() {
        return pyennykntktekiumu;
    }

    public void setPyennykntktekiumu(C_UmuKbn pPyennykntktekiumu) {
        this.pyennykntktekiumu = pPyennykntktekiumu;
    }

    public C_UmuKbn getGaikanyuukintktekiumu() {
        return gaikanyuukintktekiumu;
    }

    public void setGaikanyuukintktekiumu(C_UmuKbn pGaikanyuukintktekiumu) {
        this.gaikanyuukintktekiumu = pGaikanyuukintktekiumu;
    }

    public C_UmuKbn getHeijyunbaraiumu() {
        return heijyunbaraiumu;
    }

    public void setHeijyunbaraiumu(C_UmuKbn pHeijyunbaraiumu) {
        this.heijyunbaraiumu = pHeijyunbaraiumu;
    }

    public C_UmuKbn getTeikiikkatubaraiumu() {
        return teikiikkatubaraiumu;
    }

    public void setTeikiikkatubaraiumu(C_UmuKbn pTeikiikkatubaraiumu) {
        this.teikiikkatubaraiumu = pTeikiikkatubaraiumu;
    }

    public C_PWaribikiKbn getPwaribikikbn() {
        return pwaribikikbn;
    }

    public void setPwaribikikbn(C_PWaribikiKbn pPwaribikikbn) {
        this.pwaribikikbn = pPwaribikikbn;
    }

    public C_UmuKbn getCreditcardhrtekiumu() {
        return creditcardhrtekiumu;
    }

    public void setCreditcardhrtekiumu(C_UmuKbn pCreditcardhrtekiumu) {
        this.creditcardhrtekiumu = pCreditcardhrtekiumu;
    }

    public C_HknsyuruiNo getSeigyoHknsyuruino() {
        return seigyoHknsyuruino;
    }

    public void setSeigyoHknsyuruino(C_HknsyuruiNo pSeigyoHknsyuruino) {
        this.seigyoHknsyuruino = pSeigyoHknsyuruino;
    }

    public C_PtratkituukasiteiKbn getPtratkituukasiteikbn() {
        return ptratkituukasiteikbn;
    }

    public void setPtratkituukasiteikbn(C_PtratkituukasiteiKbn pPtratkituukasiteikbn) {
        this.ptratkituukasiteikbn = pPtratkituukasiteikbn;
    }

    public C_UmuKbn getHokenkngkyakujyouumu() {
        return hokenkngkyakujyouumu;
    }

    public void setHokenkngkyakujyouumu(C_UmuKbn pHokenkngkyakujyouumu) {
        this.hokenkngkyakujyouumu = pHokenkngkyakujyouumu;
    }

    @Override
    public SyoruiInfoItiranDataSourceBeanCommonParam createSyoruiInfoItiranDataSourceBean() {
        SyoruiInfoListDataSourceBean syoruiInfoListDataSourceBean = SWAKInjector.getInstance(SyoruiInfoListDataSourceBean.class);
        return syoruiInfoListDataSourceBean;
    }

    @Override
    public void convertSyoruiInfoItiranForCommonParam(List<SyoruiInfoItiranDataSourceBeanCommonParam> pSyoruiInfoItiran) {
        List<SyoruiInfoListDataSourceBean>  syoruiInfoList = Lists.newArrayList();

        for (SyoruiInfoItiranDataSourceBeanCommonParam beanPram : pSyoruiInfoItiran) {
            syoruiInfoList.add((SyoruiInfoListDataSourceBean) beanPram);
        }
        super.setSyoruiInfoList(syoruiInfoList);
    }
}
