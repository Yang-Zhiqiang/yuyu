package yuyu.app.siharai.sisatei.sisindansyoryousiharai;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.app.siharai.sisyoukai.sittzkrirekisyoukai.SiTtzkRirekiSyoukaiUiBean;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.koutei.BzWorkflowInfo;
import yuyu.common.biz.koutei.ProgressHistoryDataSourceBeanCommonParam;
import yuyu.common.biz.koutei.SetKouteiInfoExecUiBeanParam;
import yuyu.common.biz.koutei.SetProgressHistoryExecUiBeanParam;
import yuyu.common.biz.koutei.viewprogresshistory.ViewProgressHistoryUiBeanParam;
import yuyu.common.siharai.edittbl.EditRrkTblParam;
import yuyu.common.siharai.edittbl.EditSateiRrkTblParam;
import yuyu.common.siharai.edittbl.EditSiharaiRirekiTblParam;
import yuyu.common.siharai.edittbl.EditSkTblParam;
import yuyu.common.siharai.edittbl.SiKekkaInputParam;
import yuyu.common.siharai.edittbl.SiSeikyuusyaSindansyoParam;
import yuyu.common.siharai.edittbl.SiShrdtlsyoHassouParam;
import yuyu.common.siharai.edittbl.SiSindansyoryouShrParam;
import yuyu.common.siharai.edittbl.SiSouhusakiSindansyoParam;
import yuyu.common.siharai.edittbl.SiSoukinsakiParam;
import yuyu.common.siharai.edittbl.SiSyoriKekkaParam;
import yuyu.common.siharai.edittbl.SiharaiRirekiParam;
import yuyu.common.siharai.sicommon.TeisuuSiharai;
import yuyu.common.siharai.siview.ViewKeiyakusyaSouhusakiUiBeanParam;
import yuyu.common.siharai.siview.ViewKekkaInputUiBeanParam;
import yuyu.common.siharai.siview.ViewSindansyoryouShrUiBeanParam;
import yuyu.common.siharai.siview.ViewSiteidrUiBeanParam;
import yuyu.common.siharai.siview.ViewSkjyouhouSindansyoUiBeanParam;
import yuyu.common.siharai.siview.ViewSouhusakiSindansyoUiBeanParam;
import yuyu.common.siharai.siview.viewhihokensya.ViewHihokensyaUiBeanParam;
import yuyu.common.siharai.siview.viewshrdtlsakuseikbn.ViewShrdtlSakuseiKbnUiBeanParam;
import yuyu.common.siharai.siview.viewsoukinsaki.ViewSoukinsakiUiBeanParam;
import yuyu.def.classification.C_KidougmKbn;
import yuyu.def.classification.C_SiharaiTuukaKbn;
import yuyu.def.classification.C_SindansyoRyouShrYouhiKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_SiKykSyouhn;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.db.entity.JT_SkKihon;

import com.google.common.collect.Lists;

/**
 * 診断書料支払 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class SiSindansyoryouSiharaiUiBean extends GenSiSindansyoryouSiharaiUiBean
implements SetProgressHistoryExecUiBeanParam, EditSkTblParam, SiSeikyuusyaSindansyoParam, SiSouhusakiSindansyoParam,
SiSoukinsakiParam, SiSindansyoryouShrParam, SiShrdtlsyoHassouParam, EditSiharaiRirekiTblParam, SiharaiRirekiParam,
EditSateiRrkTblParam, SiSyoriKekkaParam, EditRrkTblParam, SiKekkaInputParam, ViewKeiyakusyaSouhusakiUiBeanParam,
ViewSkjyouhouSindansyoUiBeanParam, ViewSindansyoryouShrUiBeanParam, ViewProgressHistoryUiBeanParam,
ViewSouhusakiSindansyoUiBeanParam, ViewKekkaInputUiBeanParam, ViewHihokensyaUiBeanParam, ViewSoukinsakiUiBeanParam,
ViewShrdtlSakuseiKbnUiBeanParam, SetKouteiInfoExecUiBeanParam, ViewSiteidrUiBeanParam {

    private static final long serialVersionUID = 1L;

    @Inject
    private JT_SkKihon skKihon;

    @Inject
    private BzWorkflowInfo bzWorkflowInfo;

    @Inject
    private SiTtzkRirekiSyoukaiUiBean siTtzkRirekiSyoukaiUiBean;

    private JT_Sk sk;

    private JT_SiKykKihon siKykKihon = new JT_SiKykKihon();

    private C_KidougmKbn kidougmKbn;

    private String skno;

    private String seiRrkNo;

    private String tyouhyoukey;

    private boolean pdfFlg;

    private String patternSyorikekkaKbn;

    private JT_SiKykSyouhn siKykSyouhn;

    private C_YouhiKbn youhiKbn;

    private boolean viewSoukinsakiInputDispFlg;

    private boolean viewShrdtlSakuseiKbnInputDispFlg;

    private C_SiharaiTuukaKbn siharaituukakbn;

    private String kinouNm;

    private String seikyuusyanmkn;

    private BizDate tyakkinymd;

    private BizCurrency shrgkkei;

    private C_SindansyoRyouShrYouhiKbn sindansyoryoushryouhikbn;

    public SiSindansyoryouSiharaiUiBean() {
    }

    public JT_SkKihon getSkKihon() {
        return skKihon;
    }

    public void setSkKihon(JT_SkKihon pSkKihon) {
        this.skKihon = pSkKihon;
    }

    @Override
    public BzWorkflowInfo getBzWorkflowInfo() {
        return bzWorkflowInfo;
    }

    public void setBzWorkflowInfo(BzWorkflowInfo pBzWorkflowInfo) {
        this.bzWorkflowInfo = pBzWorkflowInfo;
    }

    public SiTtzkRirekiSyoukaiUiBean getSiTtzkRirekiSyoukaiUiBean() {
        return siTtzkRirekiSyoukaiUiBean;
    }

    public void setSiTtzkRirekiSyoukaiUiBean(SiTtzkRirekiSyoukaiUiBean pSiTtzkRirekiSyoukaiUiBean) {
        this.siTtzkRirekiSyoukaiUiBean = pSiTtzkRirekiSyoukaiUiBean;
    }

    public JT_Sk getSk() {
        return sk;
    }

    public void setSk(JT_Sk pSk) {
        this.sk = pSk;
    }

    public JT_SiKykKihon getSiKykKihon() {
        return siKykKihon;
    }

    public void setSiKykKihon(JT_SiKykKihon pSiKykKihon) {
        this.siKykKihon = pSiKykKihon;
    }

    public C_KidougmKbn getKidougmKbn() {
        return kidougmKbn;
    }

    public void setKidougmKbn(C_KidougmKbn pKidougmKbn) {
        this.kidougmKbn = pKidougmKbn;
    }

    public String getSkno() {
        return skno;
    }

    public void setSkno(String pSkno) {
        this.skno = pSkno;
    }

    public String getSeiRrkNo() {
        return seiRrkNo;
    }

    public void setSeiRrkNo(String pSeiRrkNo) {
        this.seiRrkNo = pSeiRrkNo;
    }

    public String getTyouhyoukey() {
        return tyouhyoukey;
    }

    public void setTyouhyoukey(String pTyouhyoukey) {
        this.tyouhyoukey = pTyouhyoukey;
    }

    public boolean isPdfFlg() {
        return pdfFlg;
    }

    public void setPdfFlg(boolean pPdfFlg) {
        this.pdfFlg = pPdfFlg;
    }

    public String getPatternSyorikekkaKbn() {
        return patternSyorikekkaKbn;
    }

    public void setPatternSyorikekkaKbn(String pPatternSyorikekkaKbn) {
        this.patternSyorikekkaKbn = pPatternSyorikekkaKbn;
    }

    public JT_SiKykSyouhn getSiKykSyouhn() {
        return siKykSyouhn;
    }

    public void setSiKykSyouhn(JT_SiKykSyouhn pSiKykSyouhn) {
        this.siKykSyouhn = pSiKykSyouhn;
    }

    public C_YouhiKbn getYouhiKbn() {
        return youhiKbn;
    }

    public void setYouhiKbn(C_YouhiKbn pYouhiKbn) {
        this.youhiKbn = pYouhiKbn;
    }

    @Override
    public boolean isViewSoukinsakiInputDispFlg() {
        return viewSoukinsakiInputDispFlg;
    }

    public void setViewSoukinsakiInputDispFlg(boolean pViewSoukinsakiInputDispFlg) {
        this.viewSoukinsakiInputDispFlg = pViewSoukinsakiInputDispFlg;
    }

    @Override
    public boolean isViewShrdtlSakuseiKbnInputDispFlg() {
        return viewShrdtlSakuseiKbnInputDispFlg;
    }

    public void setViewShrdtlSakuseiKbnInputDispFlg(boolean pViewShrdtlSakuseiKbnInputDispFlg) {
        this.viewShrdtlSakuseiKbnInputDispFlg = pViewShrdtlSakuseiKbnInputDispFlg;
    }

    public boolean isKidougmKbnWorkListSeigyo() {

        boolean kidougmKbnWorkListSeigyoFlg = false;
        if (C_KidougmKbn.WORKLIST.eq(this.getKidougmKbn())) {
            kidougmKbnWorkListSeigyoFlg = true;
        }
        return kidougmKbnWorkListSeigyoFlg;
    }

    public boolean isKinouModeTenkenSeigyo() {

        boolean kinouModoSeigyoFlg = false;
        if (TeisuuSiharai.NODEID_TENKEN.equals(this.getBzWorkflowInfo().getTaskId())) {
            kinouModoSeigyoFlg = true;
        }
        return kinouModoSeigyoFlg;
    }

    public boolean isStdrsktkyuSeigyo() {

        boolean siteiseikyuuFlg = false;
        String siteidruktnmkj = getSiKykKihon().getSiteidruktnmkj();
        if (!BizUtil.isBlank(siteidruktnmkj)) {
            siteiseikyuuFlg = true;
        }
        return siteiseikyuuFlg;
    }

    @Override
    public boolean isInputshrhousiteiSeigyo() {
        return false;
    }

    @Override
    public boolean isInputshrhousiteiDispFlg() {
        return false;
    }

    @Override
    public boolean isViewSoukinsakiSeigyo() {
        return false;
    }

    @Override
    public boolean isViewSoukinsakiDispFlg() {
        return false;
    }

    @Override
    public boolean isViewShrdtlSakuseiKbnSeigyo() {
        return false;
    }

    @Override
    public boolean isViewShrdtlSakuseiKbnDispFlg() {
        return false;
    }

    public boolean isSiTtzkRirekiSyoukaiHyojiSeigyo() {

        boolean blGamanHyoujiFlg = false;

        if (C_YouhiKbn.YOU.eq(getYouhiKbn())) {
            blGamanHyoujiFlg = true;
        }
        return blGamanHyoujiFlg;
    }

    @Override
    public ProgressHistoryDataSourceBeanCommonParam createProgressHistoryDataSourceBean() {
        return new ProgresshistoryinfoDataSourceBean();
    }

    @Override
    public void convertProgressHistoryForCommonParam(List<ProgressHistoryDataSourceBeanCommonParam> pDataSourceBeanLst) {
        List<ProgresshistoryinfoDataSourceBean> progresshistoryinfoList = Lists.newArrayList();

        for (ProgressHistoryDataSourceBeanCommonParam beanPram : pDataSourceBeanLst) {
            progresshistoryinfoList.add((ProgresshistoryinfoDataSourceBean)beanPram);
        }

        super.setProgresshistoryinfo(progresshistoryinfoList);
    }

    @Override
    public C_SiharaiTuukaKbn getSiharaituukakbn() {
        return siharaituukakbn;
    }

    @Override
    public void setSiharaituukakbn(C_SiharaiTuukaKbn pSiharaituukakbn) {
        siharaituukakbn = pSiharaituukakbn;
    }

    public String getKinouNm() {
        return kinouNm;
    }

    public void setKinouNm(String pKinouNm) {
        this.kinouNm = pKinouNm;
    }

    @Override
    public String getSeikyuusyanmkn() {
        return seikyuusyanmkn;
    }

    @Override
    public void setSeikyuusyanmkn(String pSeikyuusyanmkn) {
        seikyuusyanmkn = pSeikyuusyanmkn;
    }

    @Override
    public BizDate getTyakkinymd() {
        return tyakkinymd;
    }

    @Override
    public void setTyakkinymd(BizDate pTyakkinymd) {
        tyakkinymd = pTyakkinymd;
    }

    @Override
    public BizCurrency getShrgkkei() {
        return shrgkkei;
    }

    @Override
    public void setShrgkkei(BizCurrency pShrgkkei) {
        shrgkkei = pShrgkkei;
    }

    @Override
    public C_SindansyoRyouShrYouhiKbn getSindansyoryoushryouhikbn() {
        return sindansyoryoushryouhikbn;
    }

    @Override
    public void setSindansyoryoushryouhikbn(C_SindansyoRyouShrYouhiKbn pSindansyoryoushryouhikbn) {
        this.sindansyoryoushryouhikbn = pSindansyoryoushryouhikbn;
    }

    @Override
    public boolean isViewShrdtlSakuseiKbnFlg() {
        return true;
    }
}
