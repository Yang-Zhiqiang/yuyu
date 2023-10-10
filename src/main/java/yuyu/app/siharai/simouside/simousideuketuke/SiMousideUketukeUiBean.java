package yuyu.app.siharai.simouside.simousideuketuke;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.app.siharai.sisyoukai.sittzkrirekisyoukai.SiTtzkRirekiSyoukaiUiBean;
import yuyu.common.biz.koutei.BzWorkflowInfo;
import yuyu.common.siharai.edittbl.EditRrkTblParam;
import yuyu.common.siharai.edittbl.SiKekkaInputParam;
import yuyu.common.siharai.siview.viewbetukyk.ViewBetukykUiBeanParam;
import yuyu.common.siharai.siview.viewhihokensya.ViewHihokensyaUiBeanParam;
import yuyu.common.siharai.siview.viewkeiyakusya.ViewKeiyakusyaUiBeanParam;
import yuyu.common.siharai.siview.viewuketorininsb.ViewUketorininSBUiBeanParam;
import yuyu.def.classification.C_KyksyaSibouUmuKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UketorininSibouUmuKbn;
import yuyu.def.classification.C_UktKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.classification.C_YuukousyoumetuKbn;
import yuyu.def.db.entity.JT_SiKykKihon;

/**
 * 申出受付 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class SiMousideUketukeUiBean extends GenSiMousideUketukeUiBean
implements ViewHihokensyaUiBeanParam, ViewKeiyakusyaUiBeanParam, EditRrkTblParam, ViewUketorininSBUiBeanParam,
ViewBetukykUiBeanParam, SiKekkaInputParam{

    private static final long serialVersionUID = 1L;

    @Inject
    private BzWorkflowInfo bzWorkflowInfo;

    @Inject
    private SiTtzkRirekiSyoukaiUiBean siTtzkRirekiSyoukaiUiBean;

    private String gamensyorikbn = "";

    private String siteidruktnmkj;

    private String siteidruktnmkn;

    private String kykdairinmkj;

    private String kykdryno;

    private String kykdradr1kj;

    private String kykdradr2kj;

    private String kykdradr3kj;

    private String kykdrtelno;

    private C_YuukousyoumetuKbn yuukousyoumetukbn;

    private BizDate sknnkaisiymd;

    private List<JT_SiKykKihon> taiSiKykKihonLst;

    private String skno;

    private HashMap<String, Integer> outaiRenNoMap;

    private Integer betukyksuu;

    private String reportKey;

    private String patternMousideninKbn;

    private String patternGeninKbn;

    private String gmMsgCheck;

    private C_YouhiKbn youhiKbn;

    private String kinouNm;

    private C_UmuKbn siboumensekiUmuKbn;

    private C_UktKbn uktKbn;

    private boolean keiyakushahihokenshadouituFlg = false;

    private HashMap<String, String> syoNoMnTyouhyouPtnMap;

    private Map<String, C_UmuKbn> sbMnskumMap;

    private Map<String, C_Tuukasyu> kykTuukaHntiMap;

    public SiMousideUketukeUiBean() {
    }

    public BzWorkflowInfo getBzWorkflowInfo() {
        return bzWorkflowInfo;
    }

    public void setBzWorkflowInfo(BzWorkflowInfo pBzWorkflowInfo) {
        bzWorkflowInfo = pBzWorkflowInfo;
    }

    public SiTtzkRirekiSyoukaiUiBean getSiTtzkRirekiSyoukaiUiBean() {
        return siTtzkRirekiSyoukaiUiBean;
    }

    public void setSiTtzkRirekiSyoukaiUiBean(SiTtzkRirekiSyoukaiUiBean pSiTtzkRirekiSyoukaiUiBean) {
        this.siTtzkRirekiSyoukaiUiBean = pSiTtzkRirekiSyoukaiUiBean;
    }

    public String getGamensyorikbn() {
        return gamensyorikbn;
    }

    public void setGamensyorikbn(String pGamensyorikbn) {
        gamensyorikbn = pGamensyorikbn;
    }

    public String getSiteidruktnmkj() {
        return siteidruktnmkj;
    }

    public void setSiteidruktnmkj(String pSiteidruktnmkj) {
        siteidruktnmkj = pSiteidruktnmkj;
    }

    public String getSiteidruktnmkn() {
        return siteidruktnmkn;
    }

    public void setSiteidruktnmkn(String pSiteidruktnmkn) {
        siteidruktnmkn = pSiteidruktnmkn;
    }

    public String getKykdairinmkj() {
        return kykdairinmkj;
    }

    public void setKykdairinmkj(String kykdairinmkj) {
        this.kykdairinmkj = kykdairinmkj;
    }

    public String getKykdryno() {
        return kykdryno;
    }

    public void setKykdryno(String kykdryno) {
        this.kykdryno = kykdryno;
    }

    public String getKykdradr1kj() {
        return kykdradr1kj;
    }

    public void setKykdradr1kj(String kykdradr1kj) {
        this.kykdradr1kj = kykdradr1kj;
    }

    public String getKykdradr2kj() {
        return kykdradr2kj;
    }

    public void setKykdradr2kj(String kykdradr2kj) {
        this.kykdradr2kj = kykdradr2kj;
    }

    public String getKykdradr3kj() {
        return kykdradr3kj;
    }

    public void setKykdradr3kj(String kykdradr3kj) {
        this.kykdradr3kj = kykdradr3kj;
    }

    public String getKykdrtelno() {
        return kykdrtelno;
    }

    public void setKykdrtelno(String kykdrtelno) {
        this.kykdrtelno = kykdrtelno;
    }

    public C_YuukousyoumetuKbn getYuukousyoumetukbn() {
        return yuukousyoumetukbn;
    }

    public void setYuukousyoumetukbn(C_YuukousyoumetuKbn pYuukousyoumetukbn) {
        yuukousyoumetukbn = pYuukousyoumetukbn;
    }

    public BizDate getSknnkaisiymd() {
        return sknnkaisiymd;
    }

    public void setSknnkaisiymd(BizDate pSknnkaisiymd) {
        sknnkaisiymd = pSknnkaisiymd;
    }

    public List<JT_SiKykKihon> getTaiSiKykKihonLst() {
        return taiSiKykKihonLst;
    }

    public void setTaiSiKykKihonLst(List<JT_SiKykKihon> pTaiSiKykKihonLst) {
        taiSiKykKihonLst = pTaiSiKykKihonLst;
    }

    public String getSkno() {
        return skno;
    }

    public void setSkno(String pSkno) {
        skno = pSkno;
    }

    public HashMap<String, Integer> getOutaiRenNoMap() {
        return outaiRenNoMap;
    }

    public void setOutaiRenNoMap(HashMap<String, Integer> pOutaiRenNoMap) {
        outaiRenNoMap = pOutaiRenNoMap;
    }

    public Integer getBetukyksuu() {
        return betukyksuu;
    }

    public void setBetukyksuu(Integer pBetukyksuu) {
        betukyksuu = pBetukyksuu;
    }

    public String getReportKey() {
        return reportKey;
    }

    public void setReportKey(String pReportKey) {
        reportKey = pReportKey;
    }

    public String getPatternMousideninKbn() {
        return patternMousideninKbn;
    }

    public void setPatternMousideninKbn(String pPatternMousideninKbn) {
        patternMousideninKbn = pPatternMousideninKbn;
    }

    public String getPatternGeninKbn() {
        return patternGeninKbn;
    }

    public void setPatternGeninKbn(String pPatternGeninKbn) {
        patternGeninKbn = pPatternGeninKbn;
    }

    public String getGmMsgCheck() {
        return gmMsgCheck;
    }

    public void setGmMsgCheck(String pGmMsgCheck) {
        gmMsgCheck = pGmMsgCheck;
    }

    public C_YouhiKbn getYouhiKbn() {
        return youhiKbn;
    }

    public void setYouhiKbn(C_YouhiKbn pYouhiKbn) {
        this.youhiKbn = pYouhiKbn;
    }

    public String getKinouNm() {
        return kinouNm;
    }

    public void setKinouNm(String pKinouNm) {
        this.kinouNm = pKinouNm;
    }

    public C_UmuKbn getSiboumensekiUmuKbn() {
        return siboumensekiUmuKbn;
    }

    public void setSiboumensekiUmuKbn(C_UmuKbn pUmuKbn) {
        this.siboumensekiUmuKbn = pUmuKbn;
    }

    public C_UktKbn getUktKbn() {
        return uktKbn;
    }

    public void setUktKbn(C_UktKbn pUktKbn) {
        this.uktKbn = pUktKbn;
    }

    public boolean isKeiyakushahihokenshadouituFlg() {
        return keiyakushahihokenshadouituFlg;
    }

    public void setKeiyakushahihokenshadouituFlg(boolean pKeiyakushahihokenshadouituFlg) {
        if (pKeiyakushahihokenshadouituFlg) {
            super.setKyksyasibouumu(true);
        }
        this.keiyakushahihokenshadouituFlg = pKeiyakushahihokenshadouituFlg;
    }

    public HashMap<String, String> getSyoNoMnTyouhyouPtnMap() {
        return syoNoMnTyouhyouPtnMap;
    }

    public void setSyoNoMnTyouhyouPtnMap(HashMap<String, String> pSyoNoMnTyouhyouPtnMap) {
        syoNoMnTyouhyouPtnMap = pSyoNoMnTyouhyouPtnMap;
    }

    public Map<String, C_UmuKbn> getSbMnskumMap() {
        return sbMnskumMap;
    }

    public void setSbMnskumMap(Map<String, C_UmuKbn> sbMnskumMap) {
        this.sbMnskumMap = sbMnskumMap;
    }

    public Map<String, C_Tuukasyu> getKykTuukaHntiMap() {
        return kykTuukaHntiMap;
    }

    public void setKykTuukaHntiMap(Map<String, C_Tuukasyu> kykTuukaHntiMap) {
        this.kykTuukaHntiMap = kykTuukaHntiMap;
    }

    @Override
    public void setKyksyasibouumu(Boolean pKyksyasibouumu) {
        super.setKyksyasibouumu(pKyksyasibouumu);
        C_KyksyaSibouUmuKbn kbn = pKyksyasibouumu ? C_KyksyaSibouUmuKbn.KYKSBARI : C_KyksyaSibouUmuKbn.BLNK;
        super.setKyksyasibouumukbn(kbn);
    }

    @Override
    public void setUketorininsibouumu(Boolean pUketorininsibouumu) {
        super.setUketorininsibouumu(pUketorininsibouumu);
        C_UketorininSibouUmuKbn kbn = pUketorininsibouumu ? C_UketorininSibouUmuKbn.UKTSBARI : C_UketorininSibouUmuKbn.BLNK;
        super.setUketorininsibouumukbn(kbn);
    }

    @Override
    public boolean isViewUketorininsbSeigyo() {

        boolean uketorininsbInfoHyoujiFlg = false;

        if (getSbuktnin() != null) {
            if (getSbuktnin() > 0) {

                uketorininsbInfoHyoujiFlg = true;
            }
        }

        return uketorininsbInfoHyoujiFlg;
    }

    @Override
    public boolean isSbuktninHyojiHantei() {

        boolean sbuktninHyoujiFlg = false;

        if (getSbuktnin() != null) {
            if (getSbuktnin() >= 5) {

                sbuktninHyoujiFlg = true;
            }
        }

        return sbuktninHyoujiFlg;
    }

    public boolean isSiTtzkRirekiSyoukaiHyoujiFlg() {

        boolean siTtzkRirekiSyoukaiHyoujiFlg = false;

        if (C_YouhiKbn.YOU.eq(getYouhiKbn())) {
            siTtzkRirekiSyoukaiHyoujiFlg = true;
        }
        return siTtzkRirekiSyoukaiHyoujiFlg;
    }
}
