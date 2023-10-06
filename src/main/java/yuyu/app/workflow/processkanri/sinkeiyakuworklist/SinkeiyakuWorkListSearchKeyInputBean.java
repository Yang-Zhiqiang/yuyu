package yuyu.app.workflow.processkanri.sinkeiyakuworklist;

import java.util.List;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import jp.co.slcs.swak.web.ui.UserDefsList;
import yuyu.common.workflow.worklistbase.WorkListSearchKeyInputBaseBean;
import yuyu.def.classification.C_MosUketukeKbn;
import yuyu.def.classification.C_SkeijimuKbn;

/**
 * 新契約工程ワークリスト : 検索条件保持用クラスです。<br />
 */
@ConversationScoped
public class SinkeiyakuWorkListSearchKeyInputBean extends WorkListSearchKeyInputBaseBean {

    private static final long serialVersionUID = 1L;

    private C_SkeijimuKbn[] skeijimukbn;

    public C_SkeijimuKbn[] getSkeijimukbn() {
        return skeijimukbn;
    }

    public void setSkeijimukbn(C_SkeijimuKbn[] pSkeijimukbn) {
        skeijimukbn = pSkeijimukbn;
    }

    private C_MosUketukeKbn[] mosuketukekbn;

    public C_MosUketukeKbn[] getMosuketukekbn() {
        return mosuketukekbn;
    }

    public void setMosuketukekbn(C_MosUketukeKbn[] pMosuketukekbn) {
        mosuketukekbn = pMosuketukekbn;
    }

    private List<String> disphknsyuruiworklist;

    public List<String> getDisphknsyuruiworklist() {
        return disphknsyuruiworklist;
    }

    public void setDisphknsyuruiworklist(List<String> pDisphknsyuruiworklist) {
        disphknsyuruiworklist = pDisphknsyuruiworklist;
    }

    private String dairitencd1;

    public String getDairitencd1() {
        return dairitencd1;
    }

    public void setDairitencd1(String pDairitencd1) {
        dairitencd1 = pDairitencd1;
    }

    private Boolean koDairitenTaisyouKbn;

    public Boolean getKoDairitenTaisyouKbn() {
        return (koDairitenTaisyouKbn == null) ? Boolean.FALSE : koDairitenTaisyouKbn;
    }

    public void setKoDairitenTaisyouKbn(Boolean pKoDairitenTaisyouKbn) {
        koDairitenTaisyouKbn = (pKoDairitenTaisyouKbn == null) ? Boolean.FALSE : pKoDairitenTaisyouKbn;
    }

    private String dairitencd2;

    public String getDairitencd2() {
        return dairitencd2;
    }

    public void setDairitencd2(String pDairitencd2) {
        dairitencd2 = pDairitencd2;
    }

    private String drtencd3;

    public String getDrtencd3() {
        return drtencd3;
    }

    public void setDrtencd3(String pDrtencd3) {
        drtencd3 = pDrtencd3;
    }

    private String drtencd4;

    public String getDrtencd4() {
        return drtencd4;
    }

    public void setDrtencd4(String pDrtencd4) {
        drtencd4 = pDrtencd4;
    }

    private String drtencd5;

    public String getDrtencd5() {
        return drtencd5;
    }

    public void setDrtencd5(String pDrtencd5) {
        drtencd5 = pDrtencd5;
    }

    private Boolean djmskmKeiyakuKbn;

    public Boolean getDjmskmKeiyakuKbn() {
        return (djmskmKeiyakuKbn == null) ? Boolean.FALSE : djmskmKeiyakuKbn;
    }

    public void setDjmskmKeiyakuKbn(Boolean pDjmskmKeiyakuKbn) {
        djmskmKeiyakuKbn = (pDjmskmKeiyakuKbn == null) ? Boolean.FALSE : pDjmskmKeiyakuKbn;
    }

    private BizDate srchmosfromymd;

    public BizDate getSrchmosfromymd() {
        return srchmosfromymd;
    }

    public void setSrchmosfromymd(BizDate pSrchmosfromymd) {
        srchmosfromymd = pSrchmosfromymd;
    }

    private BizDate srchmostoymd;

    public BizDate getSrchmostoymd() {
        return srchmostoymd;
    }

    public void setSrchmostoymd(BizDate pSrchmostoymd) {
        srchmostoymd = pSrchmostoymd;
    }


    private String mosno;

    public String getMosno() {
        return mosno;
    }

    public void setMosno(String pMosno) {
        mosno = pMosno;
    }

    private final LoopChain<UserDefsList> disphknsyuruiworklistOptionBeanList = new LoopChain<>();
    public UserDefsList getDisphknsyuruiworklistOptionBeanList() {
        return disphknsyuruiworklistOptionBeanList.get();
    }

    public void setDisphknsyuruiworklistOptionBeanList(UserDefsList pDisphknsyuruiworklistOptionBeanList) {
        disphknsyuruiworklistOptionBeanList.add(pDisphknsyuruiworklistOptionBeanList);
    }

    public void clearDisphknsyuruiworklistOptionBeanList() {
        disphknsyuruiworklistOptionBeanList.clear();
    }
}
