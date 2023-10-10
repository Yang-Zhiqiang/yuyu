package yuyu.app.hozen.khozen.khdairiteninfosyuusei;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.common.hozen.khcommon.CheckYuukouJyoutaiExecUiBeanParam;
import yuyu.common.hozen.khview.viewkihon.ViewKihonUiBeanParam;
import yuyu.common.hozen.khview.viewtetudukityuui.ViewTetudukityuuiUiBeanParam;
import yuyu.common.hozen.setuibean.SetKihonExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetTetudukityuuiExecUiBeanParam;
import yuyu.common.hozen.setuibean.SetToriatukaiTyuuiExecUiBeanParam;
import yuyu.common.hozen.setuibean.TtdktyuuikbnInfoDataSourceBeanCommonParam;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KykKihon;

import com.google.common.collect.Lists;

/**
 * 代理店情報修正 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class KhDairitenInfoSyuuseiUiBean extends GenKhDairitenInfoSyuuseiUiBean implements SetKihonExecUiBeanParam,
SetTetudukityuuiExecUiBeanParam, CheckYuukouJyoutaiExecUiBeanParam, SetToriatukaiTyuuiExecUiBeanParam,
ViewKihonUiBeanParam,ViewTetudukityuuiUiBeanParam{

    private static final long serialVersionUID = 1L;

    public KhDairitenInfoSyuuseiUiBean() {
    }
    @Inject
    private IT_KykKihon kykKihon;

    private String syono;

    private String dairitenkanrisosikicdA;

    private String daibosyuucdA;

    private C_UmuKbn drtenbunumu;

    private String dairitenkanrisosikicdB;

    private String daibosyuucdB;

    private String bosyuucdA;

    private String bosyuucdB;

    private String kodrtencdA;

    private String bosyuunmA;

    private String oyadrtencdA;

    private String oyadrtennmA;

    private String kodrtennmA;

    private String kinyuucdA;

    private String kinyuusitencdA;

    private String drtenjimcdA;

    private String kinyuusiteioyadrtencdA;

    private String drtencdA;

    private String kodrtencdB;

    private String bosyuunmB;

    private String oyadrtencdB;

    private String oyadrtennmB;

    private String kodrtennmB;

    private String kinyuucdB;

    private String kinyuusitencdB;

    private String drtenjimcdB;

    private String kinyuusiteioyadrtencdB;

    private String drtencdB;

    private String bosyuuOyadrtCd;

    public IT_KykKihon getKykKihon() {
        return kykKihon;
    }

    public void setKykKihon(IT_KykKihon pKykKihon) {
        this.kykKihon = pKykKihon;
    }

    @Override
    public String getSyono() {
        return syono;
    }

    @Override
    public void setSyono(String pSyono) {
        this.syono = pSyono;
    }

    public String getDairitenkanrisosikicdA() {
        return dairitenkanrisosikicdA;
    }

    public void setDairitenkanrisosikicdA(String pDairitenkanrisosikicdA) {
        this.dairitenkanrisosikicdA = pDairitenkanrisosikicdA;
    }

    public String getDaibosyuucdA() {
        return daibosyuucdA;
    }

    public void setDaibosyuucdA(String pDaibosyuucdA) {
        this.daibosyuucdA = pDaibosyuucdA;
    }

    public C_UmuKbn getDrtenbunumu() {
        return drtenbunumu;
    }

    public void setDrtenbunumu(C_UmuKbn pDrtenbunumu) {
        this.drtenbunumu = pDrtenbunumu;
    }

    public String getDairitenkanrisosikicdB() {
        return dairitenkanrisosikicdB;
    }

    public void setDairitenkanrisosikicdB(String pDairitenkanrisosikicdB) {
        this.dairitenkanrisosikicdB = pDairitenkanrisosikicdB;
    }

    public String getDaibosyuucdB() {
        return daibosyuucdB;
    }

    public void setDaibosyuucdB(String pDaibosyuucdB) {
        this.daibosyuucdB = pDaibosyuucdB;
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

    public String getBosyuucdA() {
        return bosyuucdA;
    }

    public void setBosyuucdA(String pBosyuucdA) {
        this.bosyuucdA = pBosyuucdA;
    }

    public String getBosyuucdB() {
        return bosyuucdB;
    }

    public void setBosyuucdB(String pBosyuucdB) {
        this.bosyuucdB = pBosyuucdB;
    }

    public String getKodrtencdA() {
        return kodrtencdA;
    }

    public void setKodrtencdA(String pKodrtencdA) {
        this.kodrtencdA = pKodrtencdA;
    }

    public String getBosyuunmA() {
        return bosyuunmA;
    }

    public void setBosyuunmA(String pBosyuunmA) {
        this.bosyuunmA = pBosyuunmA;
    }

    public String getOyadrtencdA() {
        return oyadrtencdA;
    }

    public void setOyadrtencdA(String pOyadrtencdA) {
        this.oyadrtencdA = pOyadrtencdA;
    }

    public String getOyadrtennmA() {
        return oyadrtennmA;
    }

    public void setOyadrtennmA(String pOyadrtennmA) {
        this.oyadrtennmA = pOyadrtennmA;
    }

    public String getKodrtennmA() {
        return kodrtennmA;
    }

    public void setKodrtennmA(String pKodrtennmA) {
        this.kodrtennmA = pKodrtennmA;
    }

    public String getKinyuucdA() {
        return kinyuucdA;
    }

    public void setKinyuucdA(String pKinyuucdA) {
        this.kinyuucdA = pKinyuucdA;
    }

    public String getKinyuusitencdA() {
        return kinyuusitencdA;
    }

    public void setKinyuusitencdA(String pKinyuusitencdA) {
        this.kinyuusitencdA = pKinyuusitencdA;
    }

    public String getDrtenjimcdA() {
        return drtenjimcdA;
    }

    public void setDrtenjimcdA(String pDrtenjimcdA) {
        this.drtenjimcdA = pDrtenjimcdA;
    }

    public String getKinyuusiteioyadrtencdA() {
        return kinyuusiteioyadrtencdA;
    }

    public void setKinyuusiteioyadrtencdA(String pKinyuusiteioyadrtencdA) {
        this.kinyuusiteioyadrtencdA = pKinyuusiteioyadrtencdA;
    }

    public String getDrtencdA() {
        return drtencdA;
    }

    public void setDrtencdA(String pDrtencdA) {
        this.drtencdA = pDrtencdA;
    }

    public String getKodrtencdB() {
        return kodrtencdB;
    }

    public void setKodrtencdB(String pKodrtencdB) {
        this.kodrtencdB = pKodrtencdB;
    }

    public String getBosyuunmB() {
        return bosyuunmB;
    }

    public void setBosyuunmB(String pBosyuunmB) {
        this.bosyuunmB = pBosyuunmB;
    }

    public String getOyadrtencdB() {
        return oyadrtencdB;
    }

    public void setOyadrtencdB(String pOyadrtencdB) {
        this.oyadrtencdB = pOyadrtencdB;
    }

    public String getOyadrtennmB() {
        return oyadrtennmB;
    }

    public void setOyadrtennmB(String pOyadrtennmB) {
        this.oyadrtennmB = pOyadrtennmB;
    }

    public String getKodrtennmB() {
        return kodrtennmB;
    }

    public void setKodrtennmB(String pKodrtennmB) {
        this.kodrtennmB = pKodrtennmB;
    }

    public String getKinyuucdB() {
        return kinyuucdB;
    }

    public void setKinyuucdB(String pKinyuucdB) {
        this.kinyuucdB = pKinyuucdB;
    }

    public String getKinyuusitencdB() {
        return kinyuusitencdB;
    }

    public void setKinyuusitencdB(String pKinyuusitencdB) {
        this.kinyuusitencdB = pKinyuusitencdB;
    }

    public String getDrtenjimcdB() {
        return drtenjimcdB;
    }

    public void setDrtenjimcdB(String pDrtenjimcdB) {
        this.drtenjimcdB = pDrtenjimcdB;
    }

    public String getKinyuusiteioyadrtencdB() {
        return kinyuusiteioyadrtencdB;
    }

    public void setKinyuusiteioyadrtencdB(String pKinyuusiteioyadrtencdB) {
        this.kinyuusiteioyadrtencdB = pKinyuusiteioyadrtencdB;
    }

    public String getDrtencdB() {
        return drtencdB;
    }

    public void setDrtencdB(String pDrtencdB) {
        this.drtencdB = pDrtencdB;
    }

    public String getBosyuuOyadrtCd() {
        return bosyuuOyadrtCd;
    }

    public void setBosyuuOyadrtCd(String pBosyuuOyadrtCd) {
        this.bosyuuOyadrtCd = pBosyuuOyadrtCd;
    }
}
