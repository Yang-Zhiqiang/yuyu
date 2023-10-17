package yuyu.app.hozen.khhubikanri.khhubitouroku;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.common.biz.koutei.BzWorkflowInfo;
import yuyu.common.biz.koutei.ProgressHistoryDataSourceBeanCommonParam;
import yuyu.common.biz.koutei.SetKouteiInfoExecUiBeanParam;
import yuyu.common.biz.koutei.SetProgressHistoryExecUiBeanParam;
import yuyu.common.biz.koutei.viewkouteiinfo.ViewKouteiInfoUiBeanParam;
import yuyu.common.biz.koutei.viewprogresshistory.ViewProgressHistoryUiBeanParam;
import yuyu.common.biz.syoruiitiran.SetSyoruiInfoItiranExecUiBeanParam;
import yuyu.common.biz.syoruiitiran.SyoruiInfoItiranDataSourceBeanCommonParam;
import yuyu.common.biz.syoruiitiran.viewsyoruiinfoitiran.ViewSyoruiInfoItiranUiBeanParam;
import yuyu.common.hozen.setuibean.SetKhKbnPatternUtilUiBeanParam;
import yuyu.def.classification.C_KhkinouModeIdKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KykKihon;

import com.google.common.collect.Lists;


/**
 * 契約保全不備登録 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class KhHubiTourokuUiBean extends GenKhHubiTourokuUiBean implements
SetSyoruiInfoItiranExecUiBeanParam, ViewSyoruiInfoItiranUiBeanParam,
SetKouteiInfoExecUiBeanParam, ViewKouteiInfoUiBeanParam,
SetProgressHistoryExecUiBeanParam, ViewProgressHistoryUiBeanParam,
SetKhKbnPatternUtilUiBeanParam {

    private static final long serialVersionUID = 1L;

    @Inject
    private IT_KykKihon kykKihon;

    private C_UmuKbn fsttourokuflg;

    private C_SyoruiCdKbn syoruicd;

    private C_UmuKbn itirankeiyuumukbn;

    private String tyouhyoukey;

    @Inject
    private BzWorkflowInfo bzWorkflowInfo;

    private List<String> gmwarningIdLst;

    private List<String> gmwarningLst;

    private String[] imageids;

    private C_UmuKbn hassinsakiUmuKbn;

    private C_UmuKbn kokHassinsakiUmuKbn;

    private BizDate sksreadymd;

    private C_KhkinouModeIdKbn khkinouModeIdKbn;

    private String patternSyorikekkakbn;

    public KhHubiTourokuUiBean() {
    }

    public IT_KykKihon getKykKihon() {
        return kykKihon;
    }

    public void setKykKihon(IT_KykKihon pKykKihon) {
        kykKihon = pKykKihon;
    }

    public C_UmuKbn getFsttourokuflg() {
        return fsttourokuflg;
    }

    public void setFsttourokuflg(C_UmuKbn pFsttourokuflg) {
        fsttourokuflg = pFsttourokuflg;
    }

    public C_SyoruiCdKbn getSyoruicd() {
        return syoruicd;
    }

    public void setSyoruicd(C_SyoruiCdKbn pSyoruicd) {
        syoruicd = pSyoruicd;
    }

    public C_UmuKbn getItirankeiyuumukbn() {
        return itirankeiyuumukbn;
    }

    public void setItirankeiyuumukbn(C_UmuKbn pItirankeiyuumukbn) {
        itirankeiyuumukbn = pItirankeiyuumukbn;
    }

    public String getTyouhyoukey() {
        return tyouhyoukey;
    }

    public void setTyouhyoukey(String pTyouhyoukey) {
        tyouhyoukey = pTyouhyoukey;
    }

    @Override
    public BzWorkflowInfo getBzWorkflowInfo() {
        return bzWorkflowInfo;
    }

    public void setBzWorkflowInfo(BzWorkflowInfo pBzWorkflowInfo) {
        this.bzWorkflowInfo = pBzWorkflowInfo;
    }

    public List<String> getGmwarningIdLst() {
        return gmwarningIdLst;
    }

    public void setGmwarningIdLst(List<String> pGmwarningIdLst) {
        gmwarningIdLst = pGmwarningIdLst;
    }

    public List<String> getGmwarningLst() {
        return gmwarningLst;
    }

    public void setGmwarningLst(List<String> pGmwarningLst) {
        gmwarningLst = pGmwarningLst;
    }

    @Override
    public String[] getImageids() {
        return imageids;
    }

    @Override
    public void setImageids(String[] pImageids) {
        imageids = pImageids;
    }

    @Override
    public SyoruiInfoItiranDataSourceBeanCommonParam createSyoruiInfoItiranDataSourceBean() {
        return new SyoruiInfoListDataSourceBean();
    }

    @Override
    public void convertSyoruiInfoItiranForCommonParam(List<SyoruiInfoItiranDataSourceBeanCommonParam> pSyoruiInfoItiran) {
        List<SyoruiInfoListDataSourceBean> syoruiInfoList = Lists.newArrayList();

        for (SyoruiInfoItiranDataSourceBeanCommonParam beanPram : pSyoruiInfoItiran) {
            syoruiInfoList.add((SyoruiInfoListDataSourceBean)beanPram);
        }

        super.setSyoruiInfoList(syoruiInfoList);
    }

    @Override
    public ProgressHistoryDataSourceBeanCommonParam createProgressHistoryDataSourceBean() {
        return new ProgresshistoryinfoDataSourceBean();
    }

    @Override
    public void convertProgressHistoryForCommonParam(
        List<ProgressHistoryDataSourceBeanCommonParam> pProgresshistoryinfo) {
        List<ProgresshistoryinfoDataSourceBean> progresshistoryinfo = Lists.newArrayList();

        for (ProgressHistoryDataSourceBeanCommonParam beanPram : pProgresshistoryinfo) {
            progresshistoryinfo.add((ProgresshistoryinfoDataSourceBean) beanPram);
        }

        super.setProgresshistoryinfo(progresshistoryinfo);
    }

    public C_UmuKbn getHassinsakiUmuKbn(){
        return hassinsakiUmuKbn;
    }

    public void setHassinsakiUmuKbn(C_UmuKbn pHassinsakiUmuKbn){
        hassinsakiUmuKbn = pHassinsakiUmuKbn;
    }

    public C_UmuKbn getKokHassinsakiUmuKbn(){
        return kokHassinsakiUmuKbn;
    }

    public void setKokHassinsakiUmuKbn(C_UmuKbn pKokHassinsakiUmuKbn){
        kokHassinsakiUmuKbn = pKokHassinsakiUmuKbn;
    }

    public BizDate getSksreadymd(){
        return sksreadymd;
    }

    public void setSksreadymd(BizDate pSksreadymd){
        sksreadymd = pSksreadymd;
    }

    @Override
    public C_KhkinouModeIdKbn getKhkinouModeIdKbn(){
        return khkinouModeIdKbn;
    }

    public void setKhkinouModeIdKbn(C_KhkinouModeIdKbn pKhkinouModeIdKbn){
        khkinouModeIdKbn = pKhkinouModeIdKbn;
    }

    public String getPatternSyorikekkakbn(){
        return patternSyorikekkakbn;
    }

    @Override
    public void setPatternSyorikekkakbn(String pPatternSyorikekkakbn){
        patternSyorikekkakbn = pPatternSyorikekkakbn;
    }
}
