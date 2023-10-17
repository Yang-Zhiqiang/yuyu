package yuyu.app.siharai.sisyoukai.sibunkatusiharaikeisan;

import java.util.List;
import java.util.Map;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.siharai.edittbl.SiSiDetailParamBean;
import yuyu.common.siharai.sicommon.SiDetailMikeikapBean;
import yuyu.common.siharai.sicommon.SiDetailMisyuupBean;
import yuyu.common.siharai.sicommon.SiHkkingakuSisanParamBean;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_ZeitratkiKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.JM_SiSyouhnZokusei;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_SiKykSyouhn;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.db.entity.JT_SkKihon;

/**
 * 分割支払計算 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class SiBunkatuSiharaiKeisanUiBean extends GenSiBunkatuSiharaiKeisanUiBean {

    private static final long serialVersionUID = 1L;

    private String patternsiharaituukakbn;

    private JT_SiKykKihon siKykKihon;

    private JT_SiKykSyouhn siKykSyouhn;

    private JT_SkKihon skKihon;

    private JT_Sk skMax;

    private JT_Sk skBunkatugo;

    private JM_SiSyouhnZokusei siSyouhnZokusei;

    private Boolean kouteikanryouFlag;

    private BizDate zeimukwsratekjnymd;

    private BizNumber zeimukwsrate;

    private Map<Integer,UktrWariaiBean> uktrWariaiBeanMap;

    private List<SiSiDetailParamBean> siSiDetailParamBeanLst;

    private SiHkkingakuSisanParamBean siHkkingakuSisanParamBean;

    private List<SiDetailMikeikapBean> siDetailMikeikapBeanLst;

    private List<SiDetailMisyuupBean> siDetailMisyuupBeanLst;

    private BM_SyouhnZokusei syouhnZokusei;

    private String resultTyouhyouKey;

    private C_ZeitratkiKbn zeitratkikbn;

    private String sitaisyouuketorinmkj;

    private BizDate sibouymd;

    private C_UmuKbn sykSbYenSitiHsyuTkTekiUmu;

    private Boolean hasuuChk;

    private Map<Integer, Map<String, BizCurrency>> gaikaBunkatuKekka;

    private Map<Integer, Map<String, BizCurrency>> yenkaBunkatuKekka;

    private BizCurrency kztkgk;

    public SiBunkatuSiharaiKeisanUiBean() {
    }

    public String getPatternsiharaituukakbn() {
        return patternsiharaituukakbn;
    }

    public void setPatternsiharaituukakbn(String pPatternsiharaiTuukaKbn) {
        this.patternsiharaituukakbn = pPatternsiharaiTuukaKbn;
    }

    public JT_SiKykKihon getSiKykKihon() {
        return siKykKihon;
    }

    public void setSiKykKihon(JT_SiKykKihon pSiKykKihon) {
        this.siKykKihon = pSiKykKihon;
    }

    public JT_SkKihon getSkKihon() {
        return skKihon;
    }

    public void setSkKihon(JT_SkKihon pSkKihon) {
        this.skKihon = pSkKihon;
    }

    public JT_Sk getSkMax() {
        return skMax;
    }

    public void setSkMax(JT_Sk pSkMax) {
        this.skMax = pSkMax;
    }

    public Boolean getKouteikanryouFlag() {
        return kouteikanryouFlag;
    }

    public void setKouteikanryouFlag(Boolean pKouteikanryouFlag) {
        this.kouteikanryouFlag = pKouteikanryouFlag;
    }

    public JT_SiKykSyouhn getSiKykSyouhn() {
        return siKykSyouhn;
    }

    public void setSiKykSyouhn(JT_SiKykSyouhn pSiKykSyouhn) {
        this.siKykSyouhn = pSiKykSyouhn;
    }

    public BizDate getZeimukwsratekjnymd() {
        return zeimukwsratekjnymd;
    }

    public void setZeimukwsratekjnymd(BizDate pZeimukwsratekjnymd) {
        this.zeimukwsratekjnymd = pZeimukwsratekjnymd;
    }

    public BizNumber getZeimukwsrate() {
        return zeimukwsrate;
    }

    public void setZeimukwsrate(BizNumber pZeimukwsrate) {
        this.zeimukwsrate = pZeimukwsrate;
    }

    public Integer getSbuktninint() {
        if (!BizUtil.isBlank(getSbuktninmoji())) {
            return Integer.valueOf(getSbuktninmoji());
        }
        return 0;
    }

    public JT_Sk getSkBunkatugo() {
        return skBunkatugo;
    }

    public void setSkBunkatugo(JT_Sk pSkBunkatugo) {
        this.skBunkatugo = pSkBunkatugo;
    }

    public JM_SiSyouhnZokusei getSiSyouhnZokusei() {
        return siSyouhnZokusei;
    }

    public void setSiSyouhnZokusei(JM_SiSyouhnZokusei pSiSyouhnZokusei) {
        this.siSyouhnZokusei = pSiSyouhnZokusei;
    }

    public Map<Integer,UktrWariaiBean> getUktrWariaiBeanMap() {
        return uktrWariaiBeanMap;
    }

    public void setUktrWariaiBeanMap(Map<Integer,UktrWariaiBean> pUktrWariaiBeanMap) {
        this.uktrWariaiBeanMap = pUktrWariaiBeanMap;
    }

    public List<SiSiDetailParamBean> getSiSiDetailParamBeanLst() {
        return siSiDetailParamBeanLst;
    }

    public void setSiSiDetailParamBeanLst(List<SiSiDetailParamBean> pSiSiDetailParamBeanLst) {
        siSiDetailParamBeanLst = pSiSiDetailParamBeanLst;
    }

    public SiHkkingakuSisanParamBean getSiHkkingakuSisanParamBean() {
        return siHkkingakuSisanParamBean;
    }

    public void setSiHkkingakuSisanParamBean(SiHkkingakuSisanParamBean pSiHkkingakuSisanParamBean) {
        siHkkingakuSisanParamBean = pSiHkkingakuSisanParamBean;
    }

    public List<SiDetailMisyuupBean> getSiDetailMisyuupBeanLst() {
        return siDetailMisyuupBeanLst;
    }

    public void setSiDetailMisyuupBeanLst(List<SiDetailMisyuupBean> pSiDetailMisyuupBeanLst) {
        this.siDetailMisyuupBeanLst = pSiDetailMisyuupBeanLst;
    }

    public List<SiDetailMikeikapBean> getSiDetailMikeikapBeanLst() {
        return siDetailMikeikapBeanLst;
    }

    public void setSiDetailMikeikapBeanLst(List<SiDetailMikeikapBean> pSiDetailMikeikapBeanLst) {
        this.siDetailMikeikapBeanLst = pSiDetailMikeikapBeanLst;
    }

    public BM_SyouhnZokusei getSyouhnZokusei() {
        return syouhnZokusei;
    }

    public void setSyouhnZokusei(BM_SyouhnZokusei pSyouhnZokusei) {
        syouhnZokusei = pSyouhnZokusei;
    }

    public String getResultTyouhyouKey() {
        return resultTyouhyouKey;
    }

    public void setResultTyouhyouKey(String pResultTyouhyouKey) {
        this.resultTyouhyouKey = pResultTyouhyouKey;
    }

    public C_ZeitratkiKbn getZeitratkikbn() {
        return zeitratkikbn;
    }

    public void setZeitratkikbn(C_ZeitratkiKbn pZeitratkikbn) {
        zeitratkikbn = pZeitratkikbn;
    }

    public String getSitaisyouuketorinmkj() {
        return sitaisyouuketorinmkj;
    }

    public void setSitaisyouuketorinmkj(String pSitaisyouuketorinmkj) {
        sitaisyouuketorinmkj = pSitaisyouuketorinmkj;
    }

    public BizDate getSibouymd() {
        return sibouymd;
    }

    public void setSibouymd(BizDate pSibouymd) {
        sibouymd = pSibouymd;
    }

    public C_UmuKbn getSykSbYenSitiHsyuTkTekiUmu() {
        return sykSbYenSitiHsyuTkTekiUmu;
    }

    public void setSykSbYenSitiHsyuTkTekiUmu(C_UmuKbn pSykSbYenSitiHsyuTkTekiUmu) {
        this.sykSbYenSitiHsyuTkTekiUmu = pSykSbYenSitiHsyuTkTekiUmu;
    }

    public Boolean getHasuuChk() {
        return hasuuChk;
    }

    public void setHasuuChk(Boolean pHasuuChk) {
        this.hasuuChk = pHasuuChk;
    }

    public Map<Integer, Map<String, BizCurrency>> getGaikaBunkatuKekka() {
        return gaikaBunkatuKekka;
    }

    public void setGaikaBunkatuKekka(Map<Integer, Map<String, BizCurrency>> pGaikaBunkatuKekka) {
        this.gaikaBunkatuKekka = pGaikaBunkatuKekka;
    }

    public Map<Integer, Map<String, BizCurrency>> getYenkaBunkatuKekka() {
        return yenkaBunkatuKekka;
    }

    public void setYenkaBunkatuKekka(Map<Integer, Map<String, BizCurrency>> pYenkaBunkatuKekka) {
        this.yenkaBunkatuKekka = pYenkaBunkatuKekka;
    }

    public BizCurrency getKztkgk() {
        return kztkgk;
    }

    public void setKztkgk(BizCurrency pKztkgk) {
        this.kztkgk = pKztkgk;
    }

}
