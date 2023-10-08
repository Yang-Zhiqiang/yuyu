package yuyu.app.siharai.sisatei.sisateisb;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.message.Message;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.web.conversation.annotations.ConversationScoped;
import yuyu.app.siharai.sisyoukai.sittzkrirekisyoukai.SiTtzkRirekiSyoukaiUiBean;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.koutei.BzWorkflowInfo;
import yuyu.common.biz.koutei.SetKouteiInfoExecUiBeanParam;
import yuyu.common.siharai.chksk.CheckSbSkNaiyouKekkaBean;
import yuyu.common.siharai.chksk.CheckSbSkNaiyouParam;
import yuyu.common.siharai.chksk.ChkKekkaBean;
import yuyu.common.siharai.edittbl.EditRrkTblParam;
import yuyu.common.siharai.edittbl.EditSateiRrkTblParam;
import yuyu.common.siharai.edittbl.EditSiharaiRirekiTblParam;
import yuyu.common.siharai.edittbl.EditSkTblParam;
import yuyu.common.siharai.edittbl.SiBetukutiSateiSbParam;
import yuyu.common.siharai.edittbl.SiByoumeiParam;
import yuyu.common.siharai.edittbl.SiKaijoKigenParam;
import yuyu.common.siharai.edittbl.SiKekkaInputParam;
import yuyu.common.siharai.edittbl.SiMeigihenkouSateiParam;
import yuyu.common.siharai.edittbl.SiMnmeigibangouParam;
import yuyu.common.siharai.edittbl.SiNenkinInfoBean;
import yuyu.common.siharai.edittbl.SiSaikenParam;
import yuyu.common.siharai.edittbl.SiSateiIppanHanteiParam;
import yuyu.common.siharai.edittbl.SiSateiJuukasituParam;
import yuyu.common.siharai.edittbl.SiSateiKakSbParam;
import yuyu.common.siharai.edittbl.SiSateiKokuhanCheckParam;
import yuyu.common.siharai.edittbl.SiSeikyuuNaiyouParam;
import yuyu.common.siharai.edittbl.SiSeikyuusyaParam;
import yuyu.common.siharai.edittbl.SiShrdtlsyoHassouParam;
import yuyu.common.siharai.edittbl.SiSiDetailParamBean;
import yuyu.common.siharai.edittbl.SiSiharaiSateiParam;
import yuyu.common.siharai.edittbl.SiSiinParam;
import yuyu.common.siharai.edittbl.SiSindansyoJyouhouSbParam;
import yuyu.common.siharai.edittbl.SiSinkensyaKoukenninParam;
import yuyu.common.siharai.edittbl.SiSonotaSateiSbParam;
import yuyu.common.siharai.edittbl.SiSouhusakiInfoParam;
import yuyu.common.siharai.edittbl.SiSouhusakiSindansyoParam;
import yuyu.common.siharai.edittbl.SiSoukinsakiParam;
import yuyu.common.siharai.edittbl.SiSyoriKekkaParam;
import yuyu.common.siharai.edittbl.SiSyoriKekkaSateiParam;
import yuyu.common.siharai.edittbl.SiSyoruiUketukeYmdSateiParam;
import yuyu.common.siharai.edittbl.SiToriatukaifuryouParam;
import yuyu.common.siharai.edittbl.SiharaiRirekiParam;
import yuyu.common.siharai.sicommon.SiDetailMikeikapBean;
import yuyu.common.siharai.sicommon.SiDetailMisyuupBean;
import yuyu.common.siharai.sicommon.SiHkkingakuSisanParamBean;
import yuyu.common.siharai.siview.HktshrMeisaisInfoDataSourceBeanCommonParam;
import yuyu.common.siharai.siview.SiSetUiBeanSetHKTShrMeisaiSiDetailUiBeanParam;
import yuyu.common.siharai.siview.ViewKeiyakusyaSouhusakiUiBeanParam;
import yuyu.common.siharai.siview.ViewKekkaInputUiBeanParam;
import yuyu.common.siharai.siview.ViewSiharaiInfoSateiUiBeanParam;
import yuyu.common.siharai.siview.ViewSindansyoInfo2DataSourceBeanCommonParam;
import yuyu.common.siharai.siview.ViewSindansyoInfo2DataSourceUiBeanParam;
import yuyu.common.siharai.siview.ViewTetudukiInputUiBeanParam;
import yuyu.common.siharai.siview.viewbetukutichecksibou.ViewBetukutiCheckSibouUiBeanParam;
import yuyu.common.siharai.siview.viewippanhantei.ViewIppanhanteiUiBeanParam;
import yuyu.common.siharai.siview.viewjyuukasituinfo.ViewJyuukasituInfoUiBeanParam;
import yuyu.common.siharai.siview.viewkaijokigenymdinput.ViewKaijokigenymdInputUiBeanParam;
import yuyu.common.siharai.siview.viewkakuninkoumoku.ViewKakuninkoumokuUiBeanParam;
import yuyu.common.siharai.siview.viewkingakuinfo.ViewKingakuInfoUiBeanParam;
import yuyu.common.siharai.siview.viewkokuhancheck.ViewKokuhanCheckUiBeanParam;
import yuyu.common.siharai.siview.viewmeigihenkousatei.ViewMeigihenkouSateiUiBeanParam;
import yuyu.common.siharai.siview.viewmnmeigibangou.ViewMnMeigiBangouUiBeanParam;
import yuyu.common.siharai.siview.viewsaikeninfo.ViewSaikenInfoUiBeanParam;
import yuyu.common.siharai.siview.viewsateikaisouyouhisibou.ViewSateikaisouyouhiSibouUiBeanParam;
import yuyu.common.siharai.siview.viewsateikekka.ViewSateiKekkaUiBeanParam;
import yuyu.common.siharai.siview.viewsateikoumoku.ViewSateikoumokuUiBeanParam;
import yuyu.common.siharai.siview.viewshrdtlsakuseikbn.ViewShrdtlSakuseiKbnUiBeanParam;
import yuyu.common.siharai.siview.viewshrgoukei.ViewShrGoukeiUiBeanParam;
import yuyu.common.siharai.siview.viewshrsyousais.ViewShrSyousaiSUiBeanParam;
import yuyu.common.siharai.siview.viewsiharaiinfo.ViewSiharaiInfoUiBeanParam;
import yuyu.common.siharai.siview.viewsiharaisatei.ViewSiharaiSateiUiBeanParam;
import yuyu.common.siharai.siview.viewsiininfo.ViewSiinInfoUiBeanParam;
import yuyu.common.siharai.siview.viewsindansyoinfosibou.ViewSindansyoinfoSibouUiBeanParam;
import yuyu.common.siharai.siview.viewsinkensya.ViewSinkensyaUiBeanParam;
import yuyu.common.siharai.siview.viewskjyouhou.ViewSkjyouhouUiBeanParam;
import yuyu.common.siharai.siview.viewskkihon.ViewSkKihonUiBeanParam;
import yuyu.common.siharai.siview.viewsknaiyou.ViewSknaiyouUiBeanParam;
import yuyu.common.siharai.siview.viewsonotachecksibou.ViewSonotaCheckSibouUiBeanParam;
import yuyu.common.siharai.siview.viewsouhusaki.ViewSouhusakiUiBeanParam;
import yuyu.common.siharai.siview.viewsoukinsaki.ViewSoukinsakiUiBeanParam;
import yuyu.common.siharai.siview.viewtratkihuryouhusyoujiken.ViewTratkihuryouHusyoujikenUiBeanParam;
import yuyu.common.siharai.siview.viewzeimuinfo.ViewZeimuInfoUiBeanParam;
import yuyu.common.suuri.srcommon.EditDshrTukiDKoumokuBean;
import yuyu.def.classification.C_Delflag;
import yuyu.def.classification.C_HigaitouRiyuuKbn;
import yuyu.def.classification.C_MeihenUktKbn;
import yuyu.def.classification.C_MeihenYuukouMukouKbn;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_SKNaiyouChkkekkaKbn;
import yuyu.def.classification.C_SUketoriHouhouKbn;
import yuyu.def.classification.C_SaisateiKbn;
import yuyu.def.classification.C_ShrhousiteiKbn;
import yuyu.def.classification.C_SikinouModeIdKbn;
import yuyu.def.classification.C_SindansyoRyouShrYouhiKbn;
import yuyu.def.classification.C_SkskknsyubetuKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktKyksyaTdk;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.JM_SiSyouhnZokusei;
import yuyu.def.db.entity.JT_BetukutiSateiInfo;
import yuyu.def.db.entity.JT_SateiIppanHanteiInfo;
import yuyu.def.db.entity.JT_SateiJyuukasituChkInfo;
import yuyu.def.db.entity.JT_SateiKaijyoInfo;
import yuyu.def.db.entity.JT_SateiKokuhanInfo;
import yuyu.def.db.entity.JT_SateiMeigihenkouInfo;
import yuyu.def.db.entity.JT_SateiSyouninRireki;
import yuyu.def.db.entity.JT_SiDetail;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_SiKykSyouhn;
import yuyu.def.db.entity.JT_SiUkt;
import yuyu.def.db.entity.JT_SibouSateiChkInfo;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.db.entity.JT_SkByoumei;
import yuyu.def.db.entity.JT_SkJiyuu;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.db.entity.JT_Toriatukaifuryouinfo;
import yuyu.def.db.entity.JT_TtdkRireki;
import yuyu.infr.kinoumode.KinouMode;

import com.google.common.collect.Lists;

/**
 * （死亡）査定 の画面UiBeanクラスです。<br />
 * このクラスは手書きのコード変更が行われる可能性があります。
 * ツールの自動生成ファイルを無条件で上書きしないよう注意して下さい。
 */
@ConversationScoped
public class SiSateiSbUiBean extends GenSiSateiSbUiBean implements EditSkTblParam,SiSateiKakSbParam,
SiSyoruiUketukeYmdSateiParam,SiSeikyuusyaParam,SiSinkensyaKoukenninParam,SiSouhusakiSindansyoParam,SiSeikyuuNaiyouParam,
SiSoukinsakiParam,SiSindansyoJyouhouSbParam,SiByoumeiParam,SiShrdtlsyoHassouParam,SiSateiKokuhanCheckParam,
SiKaijoKigenParam,SiMeigihenkouSateiParam,SiToriatukaifuryouParam,SiSonotaSateiSbParam,SiBetukutiSateiSbParam,
SiSiharaiSateiParam,EditSiharaiRirekiTblParam,SiharaiRirekiParam,EditSateiRrkTblParam,SiSyoriKekkaParam,EditRrkTblParam,
ViewKeiyakusyaSouhusakiUiBeanParam,SiSetUiBeanSetHKTShrMeisaiSiDetailUiBeanParam,ViewSiharaiInfoSateiUiBeanParam,
ViewTetudukiInputUiBeanParam,ViewKekkaInputUiBeanParam,ViewSindansyoInfo2DataSourceUiBeanParam,ViewSkKihonUiBeanParam,
ViewSateikaisouyouhiSibouUiBeanParam,ViewSkjyouhouUiBeanParam,ViewSinkensyaUiBeanParam,ViewSouhusakiUiBeanParam,
ViewSknaiyouUiBeanParam,ViewSoukinsakiUiBeanParam,ViewSindansyoinfoSibouUiBeanParam,ViewShrdtlSakuseiKbnUiBeanParam,
ViewShrSyousaiSUiBeanParam,ViewSiharaiInfoUiBeanParam,ViewShrGoukeiUiBeanParam,ViewKingakuInfoUiBeanParam,
ViewZeimuInfoUiBeanParam,ViewSateikoumokuUiBeanParam,ViewIppanhanteiUiBeanParam,ViewKokuhanCheckUiBeanParam,
ViewKaijokigenymdInputUiBeanParam,ViewMeigihenkouSateiUiBeanParam,ViewTratkihuryouHusyoujikenUiBeanParam,
ViewSonotaCheckSibouUiBeanParam,ViewBetukutiCheckSibouUiBeanParam,ViewSiharaiSateiUiBeanParam,ViewKakuninkoumokuUiBeanParam,
SetKouteiInfoExecUiBeanParam, CheckSbSkNaiyouParam ,ViewSateiKekkaUiBeanParam,SiSateiIppanHanteiParam,SiSouhusakiInfoParam,
SiSyoriKekkaSateiParam,SiKekkaInputParam,SiSaikenParam,SiSiinParam,SiMnmeigibangouParam,SiSateiJuukasituParam,
ViewSaikenInfoUiBeanParam,ViewSiinInfoUiBeanParam,ViewJyuukasituInfoUiBeanParam,ViewMnMeigiBangouUiBeanParam
{

    private static final long serialVersionUID = 1L;

    @Inject
    private BzWorkflowInfo bzWorkflowInfo;

    @Inject
    private JT_SkKihon skkihon ;

    @Inject
    private KinouMode kinouMode;

    @Inject
    private SiTtzkRirekiSyoukaiUiBean siTtzkRirekiSyoukaiUiBean;

    private JT_Sk sk = new JT_Sk();

    private List<JT_SkJiyuu> skJiyuuLst;

    private List<JT_SkByoumei> skByoumeiLst;

    private JT_SiKykKihon siKykKihon = new JT_SiKykKihon();

    private List<JT_SiUkt> siUktLst;

    private JT_SiKykSyouhn siKykSyouhn = new JT_SiKykSyouhn();

    private BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();

    private List<JM_SiSyouhnZokusei> shrSyouhnZokusei = new ArrayList <JM_SiSyouhnZokusei>();

    private List<JT_SiDetail> siDetailLst;

    private JT_TtdkRireki ttdkRireki;

    private JT_SateiIppanHanteiInfo sateiIppanHanteiInfo;

    private JT_SateiKokuhanInfo sateiKokuhanInfo;

    private JT_SateiJyuukasituChkInfo sateiJyuuKasituchkInfo;

    private JT_SibouSateiChkInfo sibouSateiChkInfo;

    private JT_Toriatukaifuryouinfo toriatukaifuryouinfo;

    private JT_SateiKaijyoInfo sateiKaijyoInfo;

    private JT_SateiMeigihenkouInfo sateiMeigihenkouInfo;

    private JT_BetukutiSateiInfo betukutiSateiInfo;

    private  C_UktKyksyaTdk uktKyksyaTdk ;

    private CheckSbSkNaiyouKekkaBean checkSbSkNaiyouKekkaBean = new CheckSbSkNaiyouKekkaBean();

    private List<SiSiDetailParamBean> siSiDetailParamBeanLst;

    private SiNenkinInfoBean siNenkinInfoBean;

    private SiHkkingakuSisanParamBean siHkkingakuSisanParamBean;

    private C_SKNaiyouChkkekkaKbn skNaiyouChkkekkaKbn;

    private String patternSyorikekkakbn;

    private String patternSateiSyorikekkakbn;

    private String patternInputshrhousiteikbn;

    private String kinouNm;

    private BizDate tyakkinymd;

    private BizCurrency shrgkkei;

    private String tyouhyouKey;

    private String resultTyouhyouKey;

    private  List<JT_SateiSyouninRireki> sateiSyouninRirekiLst;

    private C_YouhiKbn siTtzkRirekiSyoukaiYouhiKbn ;

    private boolean viewSkjyouhouInputDispFlg;

    private boolean viewSouhusakiInputDispFlg;

    private boolean viewSoukinsakiInputDispFlg;

    private boolean viewSindansyoinfoSibouInputDispFlg;

    private boolean viewShrdtlSakuseiKbnInputDispFlg;

    private boolean viewKokuhanCheckInputDispFlg;

    private boolean viewIppanhanteiInputDispFlg;

    private boolean viewSiharaiSateiInputDispFlg;

    private boolean viewBetukutiCheckSibouInputDispFlg;

    private boolean viewTratkihuryouHusyoujikenInputDispFlg;

    private boolean siSateiSougouSyoukaiFlg;

    private List<String> byoumeitourokunolist;

    private C_UmuKbn kokuhancheckkbn1;

    private C_UmuKbn kokuhancheckkbn2;

    private C_UmuKbn kokuhancheckkbn3;

    private C_UmuKbn kokuhancheckkbn4;

    private C_UmuKbn kokuhancheckkbn5;

    private C_UmuKbn kokuhancheckkbn6;

    private C_UmuKbn kokuhancheckkbn7;

    private C_UmuKbn kokuhancheckkbn8;

    private String tdkdtsinyno;

    private String tdkdtsinadr1kj;

    private String tdkdtsinadr2kj;

    private String tdkdtsinadr3kj;

    private String tdkdtsintelno1;

    private List<ViewSindansyoinfoSibouInfo1DataSourceBean> newDtaSourceBeanLst;

    private C_HigaitouRiyuuKbn higaitouriyuukbn;

    private String reportcomment;

    private C_SaisateiKbn saisateikbn;

    private C_SyorikekkaKbn satei1syorikekkakbn;

    private boolean viewShrdtlSakuseiKbnFlg;

    private boolean viewSaikenInfoDispFlg;

    private boolean viewSaikenInfoFlg;

    private List<Message> errmessagecollector;

    private C_UmuKbn juukasitucheckkbn1;

    private C_UmuKbn juukasitucheckkbn2;

    private C_UmuKbn juukasitucheckkbn3;

    private C_UmuKbn juukasitucheckkbn4;

    private boolean viewJyuukasituInfoInputDispFlg;

    private String patternSiharaiTuukaKbn;

    private C_UmuKbn saigaihosyouumukbn;

    private C_ShrhousiteiKbn shrhousiteikbn;

    private List<SiDetailMisyuupBean> siDetailMisyuupBeanLst;

    private List<SiDetailMikeikapBean> siDetailMikeikapBeanLst;

    private boolean shrGoukeiHaitoukinDispFlg;

    private boolean shrGoukeiSonotahaitoukinDispFlg;

    private boolean shrGoukeiMikeikapDispFlg;

    private boolean shrGoukeiMisyuupDispFlg;

    private boolean shrGoukeiZennouseisankgkDispFlg;

    private boolean shrGoukeiAzukarikingkDispFlg;

    private boolean shrGoukeiKrkgkDispFlg;

    private boolean viewSiharaiInfoGaikaknsnKijyunYmdFlg;

    private EditDshrTukiDKoumokuBean editDshrTukiDKoumokuBean;

    public SiSateiSbUiBean() {
    }

    @Override
    public BzWorkflowInfo getBzWorkflowInfo() {
        return bzWorkflowInfo;
    }

    public void setBzWorkflowInfo(BzWorkflowInfo pBzWorkflowInfo) {
        bzWorkflowInfo = pBzWorkflowInfo;
    }

    @Override
    public JT_SkKihon getSkkihon() {
        return skkihon;
    }

    @Override
    public void setSkkihon(JT_SkKihon pSkKihon) {
        skkihon = pSkKihon;
    }

    public KinouMode getKinouMode() {
        return kinouMode;
    }

    public void setKinouMode(KinouMode pKinouMode) {
        kinouMode = pKinouMode;
    }

    public SiTtzkRirekiSyoukaiUiBean getSiTtzkRirekiSyoukaiUiBean() {
        return siTtzkRirekiSyoukaiUiBean;
    }

    public void setSiTtzkRirekiSyoukaiUiBean(SiTtzkRirekiSyoukaiUiBean pSiTtzkRirekiSyoukaiUiBean) {
        siTtzkRirekiSyoukaiUiBean = pSiTtzkRirekiSyoukaiUiBean;
    }

    public JT_Sk getSk() {
        return sk;
    }

    public void setSk(JT_Sk pSk) {
        sk = pSk;
    }

    public List<JT_SkJiyuu> getSkJiyuuLst() {
        return skJiyuuLst;
    }

    public void setSkJiyuuLst(List<JT_SkJiyuu> pSkJiyuuLst) {
        skJiyuuLst = pSkJiyuuLst;
    }

    public List<JT_SkByoumei> getSkByoumeiLst() {
        return skByoumeiLst;
    }

    public void setSkByoumeiLst(List<JT_SkByoumei> pSkByoumeiLst) {
        skByoumeiLst = pSkByoumeiLst;
    }

    public JT_SiKykKihon getSiKykKihon() {
        return siKykKihon;
    }

    public void setSiKykKihon(JT_SiKykKihon pSiKykKihon) {
        siKykKihon = pSiKykKihon;
    }

    public List<JT_SiUkt> getSiUktLst() {
        return siUktLst;
    }

    public void setSiUktLst(List<JT_SiUkt> pSiUktLst) {
        siUktLst = pSiUktLst;
    }

    public JT_SiKykSyouhn getSiKykSyouhn() {
        return siKykSyouhn;
    }

    public void setSiKykSyouhn(JT_SiKykSyouhn pSiKykSyouhn) {
        siKykSyouhn = pSiKykSyouhn;
    }

    public BM_SyouhnZokusei getSyouhnZokusei() {
        return syouhnZokusei;
    }

    public void setSyouhnZokusei(BM_SyouhnZokusei pSyouhnZokusei) {
        syouhnZokusei = pSyouhnZokusei;
    }

    public List<JM_SiSyouhnZokusei> getShrSyouhnZokusei() {
        return shrSyouhnZokusei;
    }

    public void setShrSyouhnZokusei(List<JM_SiSyouhnZokusei> pShrSyouhnZokusei) {
        shrSyouhnZokusei = pShrSyouhnZokusei;
    }

    public List<JT_SiDetail> getSiDetailLst() {
        return siDetailLst;
    }

    public void setSiDetailLst(List<JT_SiDetail> pSiDetailLst) {
        siDetailLst = pSiDetailLst;
    }

    public JT_TtdkRireki getTtdkRireki() {
        return ttdkRireki;
    }

    public void setTtdkRireki(JT_TtdkRireki pTtdkRireki) {
        ttdkRireki = pTtdkRireki;
    }

    public JT_SateiIppanHanteiInfo getSateiIppanHanteiInfo() {
        return sateiIppanHanteiInfo;
    }

    public void setSateiIppanHanteiInfo(JT_SateiIppanHanteiInfo pSateiIppanHanteiInfo) {
        sateiIppanHanteiInfo = pSateiIppanHanteiInfo;
    }

    public JT_SateiKokuhanInfo getSateiKokuhanInfo() {
        return sateiKokuhanInfo;
    }

    public void setSateiKokuhanInfo(JT_SateiKokuhanInfo pSateiKokuhanInfo) {
        sateiKokuhanInfo = pSateiKokuhanInfo;
    }

    public JT_SateiJyuukasituChkInfo getSateiJyuukasituChkInfo() {
        return sateiJyuuKasituchkInfo;
    }

    public void setSateiJyuukasituChkInfo(JT_SateiJyuukasituChkInfo pSateiJyuuKasituchkInfo) {
        sateiJyuuKasituchkInfo = pSateiJyuuKasituchkInfo;
    }
    public JT_SibouSateiChkInfo getSibouSateiChkInfo() {
        return sibouSateiChkInfo;
    }

    public void setSibouSateiChkInfo(JT_SibouSateiChkInfo pSibouSateiChkInfo) {
        sibouSateiChkInfo = pSibouSateiChkInfo;
    }

    public JT_Toriatukaifuryouinfo getToriatukaifuryouinfo() {
        return toriatukaifuryouinfo;
    }

    public void setToriatukaifuryouinfo(JT_Toriatukaifuryouinfo pToriatukaifuryouinfo) {
        toriatukaifuryouinfo = pToriatukaifuryouinfo;
    }

    public JT_SateiKaijyoInfo getSateiKaijyoInfo() {
        return sateiKaijyoInfo;
    }

    public void setSateiKaijyoInfo(JT_SateiKaijyoInfo pSateiKaijyoInfo) {
        sateiKaijyoInfo = pSateiKaijyoInfo;
    }

    public JT_SateiMeigihenkouInfo getSateiMeigihenkouInfo() {
        return sateiMeigihenkouInfo;
    }

    public void setSateiMeigihenkouInfo(JT_SateiMeigihenkouInfo pSateiMeigihenkouInfo) {
        sateiMeigihenkouInfo = pSateiMeigihenkouInfo;
    }

    public JT_BetukutiSateiInfo getBetukutiSateiInfo() {
        return betukutiSateiInfo;
    }

    public void setBetukutiSateiInfo(JT_BetukutiSateiInfo pBetukutiSateiInfo) {
        betukutiSateiInfo = pBetukutiSateiInfo;
    }

    public C_UktKyksyaTdk  getUktKyksyaTdk () {
        return uktKyksyaTdk ;
    }

    public void setUktKyksyaTdk (C_UktKyksyaTdk  pUktKyksyaTdk ) {
        uktKyksyaTdk  = pUktKyksyaTdk ;
    }

    public CheckSbSkNaiyouKekkaBean getCheckSbSkNaiyouKekkaBean() {
        return checkSbSkNaiyouKekkaBean;
    }

    public void setCheckSbSkNaiyouKekkaBean(CheckSbSkNaiyouKekkaBean pCheckSbSkNaiyouKekkaBean) {
        checkSbSkNaiyouKekkaBean = pCheckSbSkNaiyouKekkaBean;
    }

    public List<SiSiDetailParamBean> getSiSiDetailParamBeanLst() {
        return siSiDetailParamBeanLst;
    }

    public void setSiSiDetailParamBeanLst(List<SiSiDetailParamBean> pSiSiDetailParamBeanLst) {
        siSiDetailParamBeanLst = pSiSiDetailParamBeanLst;
    }

    public SiNenkinInfoBean getSiNenkinInfoBean() {
        return siNenkinInfoBean;
    }

    public void setSiNenkinInfoBean(SiNenkinInfoBean pSiNenkinInfoBean) {
        siNenkinInfoBean = pSiNenkinInfoBean;
    }

    public SiHkkingakuSisanParamBean getSiHkkingakuSisanParamBean() {
        return siHkkingakuSisanParamBean;
    }

    public void setSiHkkingakuSisanParamBean(SiHkkingakuSisanParamBean pSiHkkingakuSisanParamBean) {
        siHkkingakuSisanParamBean = pSiHkkingakuSisanParamBean;
    }

    public C_SKNaiyouChkkekkaKbn getSkNaiyouChkkekkaKbn() {
        return skNaiyouChkkekkaKbn;
    }

    public void setSkNaiyouChkkekkaKbn(C_SKNaiyouChkkekkaKbn pSkNaiyouChkkekkaKbn) {
        skNaiyouChkkekkaKbn = pSkNaiyouChkkekkaKbn;
    }

    public String getPatternSyorikekkakbn() {
        return patternSyorikekkakbn;
    }

    public void setPatternSateiSyorikekkakbn(String pPatternSateiSyorikekkakbn) {
        patternSateiSyorikekkakbn = pPatternSateiSyorikekkakbn;
    }

    public String getPatternSateiSyorikekkakbn() {
        return patternSateiSyorikekkakbn;
    }

    public void setPatternSyorikekkakbn(String pPatternSyorikekkakbn) {
        patternSyorikekkakbn = pPatternSyorikekkakbn;
    }

    public String getPatternInputshrhousiteikbn() {
        return patternInputshrhousiteikbn;
    }

    public void setPatternInputshrhousiteikbn(String pPatternInputshrhousiteikbn) {
        patternInputshrhousiteikbn = pPatternInputshrhousiteikbn;
    }

    public String getKinouNm() {
        return kinouNm;
    }

    public void setKinouNm(String pKinouNm) {
        kinouNm = pKinouNm;
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

    public String getTyouhyouKey() {
        return tyouhyouKey;
    }

    public void setTyouhyouKey(String pTyouhyouKey) {
        tyouhyouKey = pTyouhyouKey;
    }

    public String getResultTyouhyouKey() {
        return resultTyouhyouKey;
    }

    public void setResultTyouhyouKey(String pResultTyouhyouKey) {
        this.resultTyouhyouKey = pResultTyouhyouKey;
    }

    public  List<JT_SateiSyouninRireki> getSateiSyouninRirekiLst() {
        return sateiSyouninRirekiLst;
    }

    public void setSateiSyouninRirekiLst( List<JT_SateiSyouninRireki> pSateiSyouninRirekiLst) {
        sateiSyouninRirekiLst = pSateiSyouninRirekiLst;
    }

    public C_YouhiKbn  getSiTtzkRirekiSyoukaiYouhiKbn() {
        return siTtzkRirekiSyoukaiYouhiKbn;
    }

    public void setSiTtzkRirekiSyoukaiYouhiKbn(C_YouhiKbn  pSiTtzkRirekiSyoukaiYouhiKbn) {
        siTtzkRirekiSyoukaiYouhiKbn = pSiTtzkRirekiSyoukaiYouhiKbn;
    }

    @Override
    public boolean isViewSkjyouhouInputDispFlg() {
        return viewSkjyouhouInputDispFlg;
    }

    public void setViewSkjyouhouInputDispFlg(boolean pViewSkjyouhouInputDispFlg) {
        viewSkjyouhouInputDispFlg = pViewSkjyouhouInputDispFlg;
    }

    @Override
    public boolean isViewSouhusakiInputDispFlg() {
        return viewSouhusakiInputDispFlg;
    }

    public void setViewSouhusakiInputDispFlg(boolean pViewSouhusakiInputDispFlg) {
        viewSouhusakiInputDispFlg = pViewSouhusakiInputDispFlg;
    }

    @Override
    public boolean isViewSoukinsakiInputDispFlg() {
        return viewSoukinsakiInputDispFlg;
    }

    public void setViewSoukinsakiInputDispFlg(boolean pViewSoukinsakiInputDispFlg) {
        viewSoukinsakiInputDispFlg = pViewSoukinsakiInputDispFlg;
    }

    @Override
    public boolean isViewSindansyoinfoSibouInputDispFlg() {
        return viewSindansyoinfoSibouInputDispFlg;
    }

    public void setViewSindansyoinfoSibouInputDispFlg(boolean pViewSindansyoinfoSibouInputDispFlg) {
        viewSindansyoinfoSibouInputDispFlg = pViewSindansyoinfoSibouInputDispFlg;
    }

    @Override
    public boolean isViewShrdtlSakuseiKbnInputDispFlg() {
        return viewShrdtlSakuseiKbnInputDispFlg;
    }

    public void setViewShrdtlSakuseiKbnInputDispFlg(boolean pViewShrdtlSakuseiKbnInputDispFlg) {
        viewShrdtlSakuseiKbnInputDispFlg = pViewShrdtlSakuseiKbnInputDispFlg;
    }

    @Override
    public boolean isViewKokuhanCheckInputDispFlg() {
        return viewKokuhanCheckInputDispFlg;
    }

    public void setViewKokuhanCheckInputDispFlg(boolean pViewKokuhanCheckInputDispFlg) {
        viewKokuhanCheckInputDispFlg = pViewKokuhanCheckInputDispFlg;
    }

    @Override
    public boolean isViewIppanhanteiInputDispFlg() {
        return viewIppanhanteiInputDispFlg;
    }

    public void setViewIppanhanteiInputDispFlg(boolean pViewIppanhanteiInputDispFlg) {
        viewIppanhanteiInputDispFlg = pViewIppanhanteiInputDispFlg;
    }

    @Override
    public boolean isViewSiharaiSateiInputDispFlg() {
        return viewSiharaiSateiInputDispFlg;
    }

    public void setViewSiharaiSateiInputDispFlg(boolean pViewSiharaiSateiInputDispFlg) {
        viewSiharaiSateiInputDispFlg = pViewSiharaiSateiInputDispFlg;
    }

    @Override
    public boolean isViewBetukutiCheckSibouInputDispFlg() {
        return viewBetukutiCheckSibouInputDispFlg;
    }

    public void setViewBetukutiCheckSibouInputDispFlg(boolean pViewBetukutiCheckSibouInputDispFlg) {
        viewBetukutiCheckSibouInputDispFlg = pViewBetukutiCheckSibouInputDispFlg;
    }

    @Override
    public boolean isViewTratkihuryouHusyoujikenInputDispFlg() {
        return viewTratkihuryouHusyoujikenInputDispFlg;
    }

    public void setViewTratkihuryouHusyoujikenInputDispFlg(boolean pViewTratkihuryouHusyoujikenInputDispFlg) {
        viewTratkihuryouHusyoujikenInputDispFlg = pViewTratkihuryouHusyoujikenInputDispFlg;
    }

    @Override
    public boolean isViewShrdtlSakuseiKbnFlg() {
        return viewShrdtlSakuseiKbnFlg;
    }

    public void setViewShrdtlSakuseiKbnFlg(boolean pViewShrdtlSakuseiKbnFlg) {
        this.viewShrdtlSakuseiKbnFlg = pViewShrdtlSakuseiKbnFlg;
    }

    @Override
    public boolean isViewSaikenInfoInputDispFlg() {
        return viewSaikenInfoDispFlg;
    }

    public void setViewSaikenInfoInputDispFlg(boolean pViewSaikenInfoInputDispFlg) {
        this.viewSaikenInfoDispFlg = pViewSaikenInfoInputDispFlg;
    }

    @Override
    public boolean isViewSaikenInfoFlg() {
        return viewSaikenInfoFlg;
    }

    public void setViewSaikenInfoFlg(boolean pViewSaikenInfoFlg) {
        this.viewSaikenInfoFlg = pViewSaikenInfoFlg;
    }

    @Override
    public List<String> getByoumeitourokunolist() {
        return byoumeitourokunolist;
    }

    @Override
    public void setByoumeitourokunolist(List<String> pByoumeitourokunolist) {
        byoumeitourokunolist = pByoumeitourokunolist;

    }
    public boolean isSiSateiSougouSyoukaiFlg() {
        return siSateiSougouSyoukaiFlg;
    }

    public void setSiSateiSougouSyoukaiFlg(boolean pSiSateiSougouSyoukaiFlg) {
        this.siSateiSougouSyoukaiFlg = pSiSateiSougouSyoukaiFlg;
    }

    @Override
    public C_UmuKbn getKokuhancheckkbn1() {
        return kokuhancheckkbn1;
    }

    @Override
    public void setKokuhancheckkbn1(C_UmuKbn pKokuhancheckkbn1) {
        kokuhancheckkbn1 = pKokuhancheckkbn1;
    }

    @Override
    public C_UmuKbn getKokuhancheckkbn2() {
        return kokuhancheckkbn2;
    }

    @Override
    public void setKokuhancheckkbn2(C_UmuKbn pKokuhancheckkbn2) {
        kokuhancheckkbn2 = pKokuhancheckkbn2;
    }

    @Override
    public C_UmuKbn getKokuhancheckkbn3() {
        return kokuhancheckkbn3;
    }

    @Override
    public void setKokuhancheckkbn3(C_UmuKbn pKokuhancheckkbn3) {
        kokuhancheckkbn3 = pKokuhancheckkbn3;
    }

    @Override
    public C_UmuKbn getKokuhancheckkbn4() {
        return kokuhancheckkbn4;
    }

    @Override
    public void setKokuhancheckkbn4(C_UmuKbn pKokuhancheckkbn4) {
        kokuhancheckkbn4 = pKokuhancheckkbn4;
    }

    @Override
    public C_UmuKbn getKokuhancheckkbn5() {
        return kokuhancheckkbn5;
    }

    @Override
    public void setKokuhancheckkbn5(C_UmuKbn pKokuhancheckkbn5) {
        kokuhancheckkbn5 = pKokuhancheckkbn5;
    }

    @Override
    public C_UmuKbn getKokuhancheckkbn6() {
        return kokuhancheckkbn6;
    }

    @Override
    public void setKokuhancheckkbn6(C_UmuKbn pKokuhancheckkbn6) {
        kokuhancheckkbn6 = pKokuhancheckkbn6;
    }

    @Override
    public C_UmuKbn getKokuhancheckkbn7() {
        return kokuhancheckkbn7;
    }

    @Override
    public void setKokuhancheckkbn7(C_UmuKbn pKokuhancheckkbn7) {
        kokuhancheckkbn7 = pKokuhancheckkbn7;
    }

    @Override
    public C_UmuKbn getKokuhancheckkbn8() {
        return kokuhancheckkbn8;
    }

    @Override
    public void setKokuhancheckkbn8(C_UmuKbn pKokuhancheckkbn8) {
        kokuhancheckkbn8 = pKokuhancheckkbn8;
    }

    @Override
    public C_UmuKbn getJuukasitucheckkbn1() {
        return juukasitucheckkbn1;
    }

    @Override
    public void setJuukasitucheckkbn1(C_UmuKbn pJuukasitucheckkbn1) {
        juukasitucheckkbn1 = pJuukasitucheckkbn1;
    }

    @Override
    public C_UmuKbn getJuukasitucheckkbn2() {
        return juukasitucheckkbn2;
    }

    @Override
    public void setJuukasitucheckkbn2(C_UmuKbn pJuukasitucheckkbn2) {
        juukasitucheckkbn2 = pJuukasitucheckkbn2;
    }

    @Override
    public C_UmuKbn getJuukasitucheckkbn3() {
        return juukasitucheckkbn3;
    }

    @Override
    public void setJuukasitucheckkbn3(C_UmuKbn pJuukasitucheckkbn3) {
        juukasitucheckkbn3 = pJuukasitucheckkbn3;
    }

    @Override
    public C_UmuKbn getJuukasitucheckkbn4() {
        return juukasitucheckkbn4;
    }

    @Override
    public void setJuukasitucheckkbn4(C_UmuKbn pJuukasitucheckkbn4) {
        juukasitucheckkbn4 = pJuukasitucheckkbn4;
    }

    @Override
    public String getTdkdtsinyno() {
        return tdkdtsinyno;
    }

    @Override
    public void setTdkdtsinyno(String pTdkdtsinyno) {
        tdkdtsinyno = pTdkdtsinyno;
    }

    @Override
    public String getTdkdtsinadr1kj() {
        return tdkdtsinadr1kj;
    }

    @Override
    public void setTdkdtsinadr1kj(String pTdkdtsinadr1kj){
        tdkdtsinadr1kj =pTdkdtsinadr1kj;
    }

    @Override
    public String getTdkdtsinadr2kj() {
        return tdkdtsinadr2kj;
    }

    @Override
    public void setTdkdtsinadr2kj(String pTdkdtsinadr2kj){
        tdkdtsinadr2kj =pTdkdtsinadr2kj;
    }

    @Override
    public String getTdkdtsinadr3kj() {
        return tdkdtsinadr3kj;
    }

    @Override
    public void setTdkdtsinadr3kj(String pTdkdtsinadr3kj) {
        tdkdtsinadr3kj = pTdkdtsinadr3kj;
    }

    @Override
    public String getTdkdtsintelno1(){
        return tdkdtsintelno1;
    }

    @Override
    public void setTdkdtsintelno1(String pTdkdtsintelno1) {
        tdkdtsintelno1 = pTdkdtsintelno1;
    }

    public List<ViewSindansyoinfoSibouInfo1DataSourceBean> getNewDtaSourceBeanLst() {
        return newDtaSourceBeanLst;
    }

    public void setNewDtaSourceBeanLst(List<ViewSindansyoinfoSibouInfo1DataSourceBean> pNewDtaSourceBeanLst) {
        this.newDtaSourceBeanLst = pNewDtaSourceBeanLst;
    }

    @Override
    public C_HigaitouRiyuuKbn getHigaitouriyuukbn() {
        return higaitouriyuukbn;
    }

    @Override
    public void setHigaitouriyuukbn(C_HigaitouRiyuuKbn pHigaitouriyuukbn) {
        higaitouriyuukbn = pHigaitouriyuukbn;

    }

    @Override
    public String getReportcomment() {
        return reportcomment;
    }
    @Override
    public void setReportcomment(String pReportcomment) {
        reportcomment = pReportcomment;

    }

    public boolean isSiTtzkRirekiSyoukaiHyojiSeigyo () {

        boolean siTtzkRirekiSyoukaiHyojiSeigyoFlg = false;

        if (C_YouhiKbn.YOU.eq(getSiTtzkRirekiSyoukaiYouhiKbn())) {
            siTtzkRirekiSyoukaiHyojiSeigyoFlg = true;
        }

        return siTtzkRirekiSyoukaiHyojiSeigyoFlg;
    }

    @Override
    public void setSindansyoryoushryouhi(Boolean pSindansyoryoushryouhi) {

        super.setSindansyoryoushryouhi(pSindansyoryoushryouhi);

        if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI1.getValue())) {
            C_SindansyoRyouShrYouhiKbn sindansyoRyouShrYouhiKbn = super.getSindansyoryoushryouhi() ?
                C_SindansyoRyouShrYouhiKbn.SDSSHRYH :C_SindansyoRyouShrYouhiKbn.BLNK;

            super.setSindansyoryoushryouhikbn(sindansyoRyouShrYouhiKbn);
        }

    }

    @Override
    public void setSindansyoryoushryouhikbn(C_SindansyoRyouShrYouhiKbn pSindansyoryoushryouhikbn) {

        super.setSindansyoryoushryouhikbn(pSindansyoryoushryouhikbn);

        if (C_SindansyoRyouShrYouhiKbn.SDSSHRYH.eq(pSindansyoryoushryouhikbn)) {
            super.setSindansyoryoushryouhi(true);
        }
        else {
            super.setSindansyoryoushryouhi(false);
        }
    }

    @Override
    public boolean isViewSateikaisouyouhiSibouSeigyo() {
        return true;
    }

    @Override
    public boolean isViewSateikaisouyouhiSibouDispFlg() {
        return false;
    }

    @Override
    public boolean isViewSknaiyouSeigyo() {
        return true;
    }

    @Override
    public boolean isViewSknaiyouDispFlg() {

        boolean viewSknaiyouDispFlg = false;

        if (!(kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU.getValue()))) {
            viewSknaiyouDispFlg = true;
        }

        return viewSknaiyouDispFlg;
    }

    @Override
    public boolean isViewSindansyoinfoSibouSeigyo() {
        return true;
    }

    @Override
    public boolean isViewSindansyoinfoSibouDispFlg() {

        boolean viewSindansyoinfoSibouDispFlg = false;

        if (!(kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU.getValue()))) {
            viewSindansyoinfoSibouDispFlg = true;
        }

        return viewSindansyoinfoSibouDispFlg;
    }

    @Override
    public boolean isViewShrdtlSakuseiKbnSeigyo() {
        return true;
    }

    @Override
    public boolean isViewShrdtlSakuseiKbnDispFlg() {
        return true;
    }

    @Override
    public boolean isViewShrSyousaiSSeigyo() {
        return true;
    }

    @Override
    public boolean isViewShrSyousaiSDispFlg() {

        boolean viewShrSyousaiSDispFlg = false;

        if (!(kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU.getValue()))) {
            viewShrSyousaiSDispFlg = true;
        }

        return viewShrSyousaiSDispFlg;
    }

    @Override
    public boolean isViewSiharaiInfoDispHantei() {

        boolean viewSiharaiInfoDispHanteiFlg = true;

        if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SESSYOU1.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SESSYOU2.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU.getValue())) {

            if (!(C_SyorikekkaKbn.SIBOUS_SAIGAIHIGAITOU.eq(this.getSatei1Syorikekkakbn()) &&
                C_SaisateiKbn.BLNK.eq(this.getSkkihon().getSaisateikbn()))){

                viewSiharaiInfoDispHanteiFlg = false;
            }
        }
        return viewSiharaiInfoDispHanteiFlg;
    }

    @Override
    public boolean isViewSiharaiInfoSeigyo() {
        return true;
    }

    @Override
    public boolean isViewSiharaiInfoDispFlg() {

        boolean viewSiharaiInfoDispFlg = false;

        if (!(kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU.getValue()))) {
            viewSiharaiInfoDispFlg = true;
        }

        return viewSiharaiInfoDispFlg;
    }

    @Override
    public boolean isViewShrGoukeiInfoUmuSeigyo() {

        boolean viewShrGoukeiInfoUmuSeigyo = false;

        if (!(C_SUketoriHouhouKbn.ZENGAKU_ITIJIKN.eq(this.getSk().getSuketorihouhoukbn()) &&
            C_UmuKbn.ARI.eq(this.getSiKykKihon().getNstkhkumu()))) {
            viewShrGoukeiInfoUmuSeigyo = true;
        }

        return viewShrGoukeiInfoUmuSeigyo;
    }

    @Override
    public boolean isViewShrGoukeiSeigyo() {
        return true;
    }

    @Override
    public boolean isViewShrGoukeiDispFlg() {

        boolean viewShrGoukeiDispFlg = false;

        if (!(kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU.getValue()))) {
            viewShrGoukeiDispFlg = true;
        }

        return viewShrGoukeiDispFlg;
    }

    @Override
    public boolean isYenGoukeiInfoUmuSeigyo() {

        if (C_Tuukasyu.JPY.eq(this.getSk().getKyktuukasyu())) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isYenGoukeiSeigyo() {

        return true;
    }

    @Override
    public boolean isYenShrGoukeiDispFlg() {

        if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU.getValue())) {

            return false;
        }
        return true;
    }

    @Override
    public boolean isViewKingakuInfoSeigyo() {
        return true;
    }

    @Override
    public boolean isViewKingakuInfoDispFlg() {

        boolean viewKingakuInfoDispFlg = false;

        if (!(kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU.getValue()))) {
            viewKingakuInfoDispFlg = true;
        }

        return viewKingakuInfoDispFlg;
    }

    @Override
    public boolean isViewZeimuInfoSeigyo() {
        return true;
    }

    @Override
    public boolean isViewZeimuInfoDispFlg() {

        boolean viewZeimuInfoDispFlg = true;

        if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI1.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI2.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI3.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI4.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU.getValue())) {
            viewZeimuInfoDispFlg = false;
        }

        return viewZeimuInfoDispFlg;
    }

    @Override
    public boolean isViewSateikoumokuSeigyo() {
        return true;
    }

    @Override
    public boolean isViewSateikoumokuDispFlg() {

        boolean viewSateikoumokuDispFlg = true;

        if ((kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SESSYOU1.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SESSYOU2.getValue())) &&
            this.getCheckSbSkNaiyouKekkaBean().getChkKekkaBeanList().size() ==0) {
            viewSateikoumokuDispFlg = false;
        }
        if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU.getValue())){
            viewSateikoumokuDispFlg = false;
        }

        return viewSateikoumokuDispFlg;
    }

    @Override
    public boolean isViewIppanhanteiFlg() {

        boolean viewViewIppanhanteiFlg = false;

        if (C_UmuKbn.ARI.eq(this.getSyouhnZokusei().getKktumu()) &&
            (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI1.getValue()) ||
                (!kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI1.getValue()) &&
                    isIppanHanteiInputUmuFlg()))) {
            viewViewIppanhanteiFlg = true;
        }

        return viewViewIppanhanteiFlg;
    }

    @Override
    public boolean isViewIppanhanteiSeigyo() {
        return true;
    }

    @Override
    public boolean isViewIppanhanteiDispFlg() {

        boolean viewIppanhanteiDispFlg = true;


        if ((kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU.getValue())) ||
            !isIppanHanteiInputUmuFlg()) {
            viewIppanhanteiDispFlg = false;
        }

        return viewIppanhanteiDispFlg;
    }
    @Override
    public boolean isViewKokuhanCheckFlg() {

        boolean viewKokuhanCheckFlg = false;

        if (C_UmuKbn.ARI.eq(this.getSyouhnZokusei().getKktumu()) &&
            (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI1.getValue()) ||
                (!kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI1.getValue()) &&
                    isKokuhanCheckInputUmuFlg()))) {
            viewKokuhanCheckFlg = true;
        }

        return viewKokuhanCheckFlg;
    }

    @Override
    public boolean isViewKokuhanCheckSeigyo() {
        return true;
    }

    @Override
    public boolean isViewKokuhanCheckDispFlg() {

        boolean viewKokuhanCheckDispFlg = true;


        if ((kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU.getValue())) ||
            !isKokuhanCheckInputUmuFlg()) {
            viewKokuhanCheckDispFlg = false;
        }

        return viewKokuhanCheckDispFlg;
    }

    @Override
    public boolean isViewKaijokigenymdInputFlg() {

        boolean viewKokuhanCheckFlg = false;

        if (C_UmuKbn.ARI.eq(this.getSyouhnZokusei().getKktumu()) &&
            (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI1.getValue()) ||
                (!kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI1.getValue()) &&
                    isKaijyoKigenymdInputUmuFlg()))) {
            viewKokuhanCheckFlg = true;
        }

        return viewKokuhanCheckFlg;
    }

    @Override
    public boolean isViewKaijokigenymdSeigyo() {
        return true;
    }

    @Override
    public boolean isViewKaijokigenymdDispFlg() {

        boolean viewKaijokigenymdDispFlg = false;

        if (!kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU.getValue())) {
            if (isKaijyoKigenymdInputUmuFlg()) {
                viewKaijokigenymdDispFlg = true;
            }
        }

        return viewKaijokigenymdDispFlg;
    }

    @Override
    public boolean isViewMeigihenkouSateiFlg() {

        boolean viewMeigihenkouSateiFlg = false;

        if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI1.getValue()) ||
            (!kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI1.getValue()) &&
                isMeigiHenkouSateiInputUmuFlg())) {
            viewMeigihenkouSateiFlg = true;
        }

        return viewMeigihenkouSateiFlg;
    }

    @Override
    public boolean isViewMeigihenkouSateiSeigyo() {
        return true;
    }

    @Override
    public boolean isViewMeigihenkouSateiDispFlg() {

        boolean viewMeigihenkouSateiDispFlg = false;

        if (!(kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU.getValue()))) {
            List<ChkKekkaBean>  chkKekkaBeanLst = getCheckSbSkNaiyouKekkaBean().getChkKekkaBeanList();
            boolean chkKekkaFlg = false;

            for (ChkKekkaBean chkKekkaBean : chkKekkaBeanLst) {
                if (C_SKNaiyouChkKbn.SATEICHK_MEIGIHN_AMONTH.eq(chkKekkaBean.getSKNaiyouChkKbn()) ||
                    C_SKNaiyouChkKbn.SATEICHK_MEIGIHN_KSYOUHI.eq(chkKekkaBean.getSKNaiyouChkKbn())||
                    C_SKNaiyouChkKbn.SATEICHK_MEIGIHN_SIBOUGO.eq(chkKekkaBean.getSKNaiyouChkKbn())) {
                    chkKekkaFlg = true;
                    break;
                }
            }
            if (chkKekkaFlg ||
                isMeigiHenkouSateiInputUmuFlg()) {
                viewMeigihenkouSateiDispFlg = true;
            }
        }

        return viewMeigihenkouSateiDispFlg;
    }

    @Override
    public boolean isViewTratkihuryouHusyoujikenFlg() {
        return true;
    }

    @Override
    public boolean isViewTratkihuryouHusyoujikenSeigyo() {
        return true;
    }

    @Override
    public boolean isViewTratkihuryouHusyoujikenDispFlg() {

        boolean viewTratkihuryouHusyoujikenDispFlg = true;

        if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU.getValue())) {
            viewTratkihuryouHusyoujikenDispFlg = false;
        }
        else if (!kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI1.getValue()) &&
            (getTratkihuryouumukbn() == null &&
            getGyousinkaisouyouhikbn() == null &&
            getAireqdaityoukisaikbn() == null &&
            (getTratkihuryoucomment() == null || getTratkihuryoucomment().length() == 0 ))) {
            viewTratkihuryouHusyoujikenDispFlg = false;
        }

        return viewTratkihuryouHusyoujikenDispFlg;
    }

    @Override
    public boolean isViewSonotaCheckSibouFlg() {
        return true;
    }

    @Override
    public boolean isViewSonotaCheckSibouSeigyo() {
        return true;
    }

    @Override
    public boolean isViewSonotaCheckSibouDispFlg() {

        boolean viewSonotaCheckSibouDispFlg =  true;

        if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU.getValue())) {
            viewSonotaCheckSibouDispFlg = false;
        }
        else if (!kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI1.getValue()) &&
            (getBengosikenkaiumukbn() == null &&
            getKujyouumukbn() == null &&
            getJimumissumukbn() == null &&
            getKyhgksitukaisouyouhikbn() == null )) {
            viewSonotaCheckSibouDispFlg = false;

        }
        return viewSonotaCheckSibouDispFlg;
    }

    @Override
    public boolean isViewBetukutiCheckSibouFlg() {

        boolean viewBetukutiCheckSibouFlg = false;

        if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI1.getValue()) ||
            (!kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI1.getValue()) &&
                isBetukutiChkSibouInputUmuFlg())) {
            viewBetukutiCheckSibouFlg = true;
        }

        return viewBetukutiCheckSibouFlg;
    }

    @Override
    public boolean isViewBetukutiCheckSibouSeigyo() {
        return true;
    }

    @Override
    public boolean isViewBetukutiCheckSibouDispFlg() {

        boolean viewBetukutiCheckSibouDispFlg = true;

        if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU.getValue())) {
            viewBetukutiCheckSibouDispFlg = false;
        }
        else if (!kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI1.getValue()) &&
            !isBetukutiChkSibouInputUmuFlg()) {
            viewBetukutiCheckSibouDispFlg = false;
        }

        return viewBetukutiCheckSibouDispFlg;
    }

    @Override
    public boolean isViewSiharaiSateiSeigyo() {
        return true;
    }

    @Override
    public boolean isViewSiharaiSateiDispFlg() {
        return true;
    }

    @Override
    public boolean isKinouModeSisateiitijiSeigyo() {

        if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI1.getValue())) {

            return true;
        }

        return false;
    }

    @Override
    public boolean isViewKakuninkoumokuSeigyo() {
        return true;
    }

    @Override
    public boolean isViewKakuninkoumokuDispFlg() {
        return true;
    }

    @Override
    public boolean isViewSkjyouhouSeigyo() {
        return true;
    }

    @Override
    public boolean isViewSkjyouhouDispFlg() {
        return true;
    }

    @Override
    public boolean isInputshrhousiteiSeigyo() {
        return true;
    }

    @Override
    public boolean isInputshrhousiteiDispFlg() {
        return true;
    }

    @Override
    public boolean isViewSoukinsakiSeigyo() {
        return true;
    }

    @Override
    public boolean isViewSoukinsakiDispFlg() {
        return true;
    }

    @Override
    public boolean isViewSinkensyaSeigyo() {
        return true;
    }

    @Override
    public boolean isViewSinkensyaDispFlg() {

        boolean viewSinkensyaDispFlg = false;

        if (!BizUtil.isBlank(super.getSkskknnmkn()) || !BizUtil.isBlank(super.getSkskknnmkj()) ||
            !C_SkskknsyubetuKbn.BLNK.eq(super.getSkskknsyubetu())) {

            viewSinkensyaDispFlg = true;
        }

        return viewSinkensyaDispFlg;
    }

    @Override
    public boolean isViewSinkensyaHyouji() {

        boolean viewSinkensyaDispFlg = false;

        if (!BizUtil.isBlank(super.getSkskknnmkn()) || !BizUtil.isBlank(super.getSkskknnmkn()) ||
            !C_SkskknsyubetuKbn.BLNK.eq(super.getSkskknsyubetu())) {

            viewSinkensyaDispFlg = true;
        }

        return viewSinkensyaDispFlg;
    }

    @Override
    public boolean isViewSkKihonSeigyo() {
        return true;
    }

    @Override
    public boolean isViewSkKihonDispFlg() {
        return true;
    }

    @Override
    public boolean isViewSouhusakiSeigyo() {
        return true;
    }

    @Override
    public boolean isViewSouhusakiDispFlg() {
        return true;
    }

    @Override
    public boolean isViewSateiKekkaSeigyo() {
        return true;
    }

    @Override
    public boolean isViewSateiKekkaDispFlg() {
        return true;
    }

    @Override
    public boolean isSyouninInputHanteiFlg() {

        boolean syouninInputHanteiFlg = false;

        if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SYOUNIN_SATEIHUYOU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SYOUNIN_SATEIYOU.getValue())) {
            syouninInputHanteiFlg = true;
        }

        return syouninInputHanteiFlg;
    }

    @Override
    public boolean isSessyouInputHanteiFlg() {

        boolean sessyouInputHanteiFlg = false;

        if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SESSYOU1.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SESSYOU2.getValue())) {
            sessyouInputHanteiFlg = true;
        }

        return sessyouInputHanteiFlg;
    }

    @Override
    public boolean isKaiketuInputHanteiFlg() {

        boolean sessyouInputHanteiFlg = false;

        if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU.getValue())) {
            sessyouInputHanteiFlg = true;
        }

        return sessyouInputHanteiFlg;
    }

    @Override
    public HktshrMeisaisInfoDataSourceBeanCommonParam createHktshrMeisaisInfoDataSourceBean() {
        return new HktshrMeisaisInfoDataSourceBean();
    }

    @Override
    public void convertHktshrMeisaisInfoForCommonParam( List<HktshrMeisaisInfoDataSourceBeanCommonParam> pHktshrMeisaisInfo) {

        List<HktshrMeisaisInfoDataSourceBean> dataSourceBeanInfo = Lists.newArrayList();

        for (HktshrMeisaisInfoDataSourceBeanCommonParam beanCommonParam : pHktshrMeisaisInfo) {

            HktshrMeisaisInfoDataSourceBean bataSourceBean = (HktshrMeisaisInfoDataSourceBean) beanCommonParam;

            dataSourceBeanInfo.add(bataSourceBean);
        }
        super.setHktshrMeisaisInfo(dataSourceBeanInfo);
    }

    @Override
    public ViewSindansyoInfo2DataSourceBeanCommonParam createSindansyoInfo2DataSourceBean() {
        return new ViewSindansyoinfoSibouInfo1DataSourceBean();
    }

    @Override
    public void convertSindansyoInfo2ForCommonParam(List<ViewSindansyoInfo2DataSourceBeanCommonParam> pSindansyoInfo) {

        List<ViewSindansyoinfoSibouInfo1DataSourceBean> dataSourceBeanInfo = Lists.newArrayList();

        for (ViewSindansyoInfo2DataSourceBeanCommonParam beanCommonParam : pSindansyoInfo) {

            ViewSindansyoinfoSibouInfo1DataSourceBean bataSourceBean = (ViewSindansyoinfoSibouInfo1DataSourceBean) beanCommonParam;

            dataSourceBeanInfo.add(bataSourceBean);
        }
        super.setViewSindansyoinfoSibouInfo1(dataSourceBeanInfo);
    }

    @Override
    public List<ViewSindansyoInfo2DataSourceBeanCommonParam> convertCommonParamForSindansyoInfo2() {

        List<ViewSindansyoInfo2DataSourceBeanCommonParam> beanCommonParamInfo = Lists.newArrayList();

        for (ViewSindansyoinfoSibouInfo1DataSourceBean dataSourceBean : super.getViewSindansyoinfoSibouInfo1DataSource().getAllData()) {
            if (C_Delflag.BLNK.eq(dataSourceBean.getSakujyoflg()) && !BizUtil.isBlank(dataSourceBean.getByoumeitourokuno())) {

                beanCommonParamInfo.add(dataSourceBean);
            }
        }
        return beanCommonParamInfo;
    }

    @Override
    public C_SaisateiKbn getSaisateikbn() {
        return saisateikbn;
    }

    @Override
    public void setSaisateikbn(C_SaisateiKbn pSaisateikbn) {
        saisateikbn = pSaisateikbn;
    }

    @Override
    public C_SyorikekkaKbn getSatei1Syorikekkakbn() {
        return satei1syorikekkakbn;
    }

    @Override
    public void setSatei1Syorikekkakbn(C_SyorikekkaKbn pSatei1syorikekkakbn) {
        satei1syorikekkakbn = pSatei1syorikekkakbn;
    }

    @Override
    public boolean isViewSiinInfoFlg() {

        boolean isViewSiinInfoFlg = false;

        if ((kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI1.getValue()) &&
            this.getPageNo() == SiSateiSbConstants.PAGENO_INPUTCORRECT) ||
            this.getPageNo() != SiSateiSbConstants.PAGENO_INPUTCORRECT ) {
            isViewSiinInfoFlg = true ;
        }
        return isViewSiinInfoFlg;
    }

    @Override
    public boolean isViewSiinInfoSeigyo() {

        if(this.getPageNo() == SiSateiSbConstants.PAGENO_INPUTCORRECT){
            return false;
        }
        return true;
    }

    @Override
    public boolean isViewSiinInfoDispFlg() {

        boolean viewSiinInfoDispFlg = true;

        if ((kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU.getValue()))) {
            viewSiinInfoDispFlg = false;
        }
        return viewSiinInfoDispFlg;
    }

    @Override
    public boolean isViewJyuukasituInfoFlg() {

        boolean isViewJyuukasituInfoFlg = false;

        if (kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI1.getValue()) ||
            (!kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.SATEI1.getValue()) &&
                isJyuukasituCheckInputUmuFlg())) {
            isViewJyuukasituInfoFlg = true ;
        }
        return isViewJyuukasituInfoFlg;
    }

    @Override
    public boolean isViewJyuukasituInfoSeigyo() {
        return true;
    }

    @Override
    public boolean isViewJyuukasituInfoDispFlg() {

        boolean viewJyuukasituInfoDispFlg = true;

        if ((kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUYOU.getValue()) ||
            kinouMode.getKinouMode().equals(C_SikinouModeIdKbn.KAIKETU_SESSYOUHUYOU.getValue())) ||
            !isJyuukasituCheckInputUmuFlg()) {
            viewJyuukasituInfoDispFlg = false;
        }

        return viewJyuukasituInfoDispFlg;
    }

    @Override
    public boolean isViewSaikenInfoSeigyo() {
        return true;
    }

    @Override
    public boolean isViewSaikenInfoDispFlg() {
        return true;
    }

    @Override
    public boolean isViewMnMeigiBangouSeigyo() {

        if(this.getPageNo() == SiSateiSbConstants.PAGENO_INPUTCORRECT){
            return false;
        }
        return true;
    }

    @Override
    public boolean isViewMnMeigiBangouDispFlg() {
        return true;
    }

    public List<Message> getErrmessagecollector() {
        return errmessagecollector;
    }

    public void setErrmessagecollector(List<Message> messageLst) {
        errmessagecollector = messageLst;
    }

    @Override
    public boolean isViewJyuukasituInfoInputDispFlg() {
        return viewJyuukasituInfoInputDispFlg;
    }

    public void setViewJyuukasituInfoInputDispFlg(boolean pViewJyuukasituInfoInputDispFlg) {
        viewJyuukasituInfoInputDispFlg = pViewJyuukasituInfoInputDispFlg;
    }

    public boolean isIppanHanteiInputUmuFlg() {

        boolean ippanHanteiInputUmuFlg = true;

        if ((getIppanhanteitensuu1() == null || this.getIppanhanteitensuu1().length() == 0) &&
            (getIppanhanteicomment1()== null || this.getIppanhanteicomment1().length() == 0) &&
            (getIppanhanteitensuu2() == null || this.getIppanhanteitensuu2().length() == 0) &&
            (getIppanhanteicomment2()== null || this.getIppanhanteicomment2().length() == 0) &&
            (getIppanhanteitensuu3() == null || this.getIppanhanteitensuu3().length() == 0) &&
            (getIppanhanteicomment3()== null || this.getIppanhanteicomment3().length() == 0) &&
            (getIppanhanteitensuu4() == null || this.getIppanhanteitensuu4().length() == 0) &&
            (getIppanhanteicomment4()== null || this.getIppanhanteicomment4().length() == 0) &&
            (getIppanhanteitensuu5() == null || this.getIppanhanteitensuu5().length() == 0) &&
            (getIppanhanteicomment5()== null || this.getIppanhanteicomment5().length() == 0) &&
            (getIppanhanteitensuu6() == null || this.getIppanhanteitensuu6().length() == 0) &&
            (getIppanhanteicomment6()== null || this.getIppanhanteicomment6().length() == 0) &&
            (getIppanhanteitensuugoukei() == null || this.getIppanhanteitensuugoukei().length() == 0) &&
            (getIppanhanteigoukeicomment() == null || this.getIppanhanteigoukeicomment().length() == 0)){
            ippanHanteiInputUmuFlg = false;
        }

        return ippanHanteiInputUmuFlg;
    }

    public boolean isKokuhanCheckInputUmuFlg() {

        boolean kokuhanCheckInputUmuFlg = true;

        if ((getKokuhancheck1() == false &&
            (getKokuhanchecomment1() == null || getKokuhanchecomment1().length() == 0)) &&
            (getKokuhancheck2() == false &&
            (getKokuhanchecomment2() == null || getKokuhanchecomment2().length() == 0)) &&
            (getKokuhancheck3() == false &&
            (getKokuhanchecomment3() == null || getKokuhanchecomment3().length() == 0)) &&
            (getKokuhancheck4() == false &&
            (getKokuhanchecomment4() == null || getKokuhanchecomment4().length() == 0)) &&
            (getKokuhancheck5() == false &&
            (getKokuhanchecomment5() == null || getKokuhanchecomment5().length() == 0)) &&
            (getKokuhancheck6() == false &&
            (getKokuhanchecomment6() == null || getKokuhanchecomment6().length() == 0)) &&
            (getKokuhancheck7() == false &&
            (getKokuhanchecomment7() == null || getKokuhanchecomment7().length() == 0)) &&
            (getKokuhancheck8() == false &&
            (getKokuhanchecomment8() == null || getKokuhanchecomment8().length() == 0))) {
            kokuhanCheckInputUmuFlg = false;
        }

        return kokuhanCheckInputUmuFlg;
    }

    public boolean isJyuukasituCheckInputUmuFlg() {

        boolean jyuukasituCheckInputUmuFlg = true;

        if ((getJuukasitucheck1() == false &&
            (getJuukasitucheckcomment1() == null || getJuukasitucheckcomment1().length() == 0)) &&
            (getJuukasitucheck2() == false &&
            (getJuukasitucheckcomment2() == null || getJuukasitucheckcomment2().length() == 0)) &&
            (getJuukasitucheck3() == false &&
            (getJuukasitucheckcomment3() == null || getJuukasitucheckcomment3().length() == 0)) &&
            (getJuukasitucheck4() == false &&
            (getJuukasitucheckcomment4() == null || getJuukasitucheckcomment4().length() == 0))) {
            jyuukasituCheckInputUmuFlg = false;
        }

        return jyuukasituCheckInputUmuFlg;
    }

    public boolean isKaijyoKigenymdInputUmuFlg() {

        boolean kaijyoKigenymdInputUmuFlg = true;

        if (getKaijokigenymd() == null) {
            kaijyoKigenymdInputUmuFlg = false;
        }

        return kaijyoKigenymdInputUmuFlg;
    }

    public boolean isMeigiHenkouSateiInputUmuFlg() {

        boolean meigiHenkouSateiInputUmuFlg = true;

        if ((getMeihenyuukoumukoukbn() == null || C_MeihenYuukouMukouKbn.BLNK.eq(getMeihenyuukoumukoukbn())) &&
            (getMeihenuktkbn() == null || C_MeihenUktKbn.BLNK.eq(getMeihenuktkbn())) &&
            (getMeihenuktnm() == null || getMeihenuktnm().length() == 0)) {
            meigiHenkouSateiInputUmuFlg = false;
        }

        return meigiHenkouSateiInputUmuFlg;
    }


    public boolean isBetukutiChkSibouInputUmuFlg() {

        boolean betukutiChkSibouInputUmuFlg = true;

        if (getBetusibouumukbn() == null &&
            (getBetusiboucomment() == null ||getBetusiboucomment().length() == 0) &&
            getBetusoukiumukbn() == null &&
            (getBetusoukicomment()  == null || getBetusoukicomment().length() == 0)) {
            betukutiChkSibouInputUmuFlg = false;
        }

        return betukutiChkSibouInputUmuFlg;
    }

    public String getPatternSiharaiTuukaKbn() {
        return patternSiharaiTuukaKbn;
    }

    public void setPatternSiharaiTuukaKbn(String pPatternSiharaiTuukaKbn) {
        patternSiharaiTuukaKbn = pPatternSiharaiTuukaKbn;
    }

    public C_UmuKbn getSaigaihosyouumukbn() {
        return saigaihosyouumukbn;
    }

    public void setSaigaihosyouumukbn(C_UmuKbn pSaigaihosyouumukbn) {
        saigaihosyouumukbn = pSaigaihosyouumukbn;
    }

    public C_ShrhousiteiKbn getShrhousiteikbn() {
        return shrhousiteikbn;
    }

    public void setShrhousiteikbn(C_ShrhousiteiKbn pShrhousiteikbn) {
        shrhousiteikbn = pShrhousiteikbn;
    }

    @Override
    public boolean isViewSiharaiInfoYenknsnKijyunYmdFlg() {

        boolean viewSiharaiInfoYenknsnKijyunYmdFlg = true;

        if (C_Tuukasyu.JPY.eq(sk.getKyktuukasyu())) {
            viewSiharaiInfoYenknsnKijyunYmdFlg = false;
        }

        return viewSiharaiInfoYenknsnKijyunYmdFlg;
    }

    @Override
    public boolean isViewKingakuInfoHokenryouStgkDispFlg() {

        boolean viewKingakuInfoHokenryouStgkDispFlg = true;

        if (shrSyouhnZokusei.size() > 0 &&
            C_UmuKbn.NONE.eq(shrSyouhnZokusei.get(0).getPsoutougkhyoujiumu())) {
            viewKingakuInfoHokenryouStgkDispFlg = false;
        }

        return viewKingakuInfoHokenryouStgkDispFlg;
    }

    @Override
    public boolean isViewKingakuInfoTutaKngkDispFlg() {

        boolean viewKingakuInfoTutaKngkDispFlg = true;

        if (shrSyouhnZokusei.size() > 0 &&
            C_UmuKbn.NONE.eq(shrSyouhnZokusei.get(0).getTmttkngkhyoujiumu())) {
            viewKingakuInfoTutaKngkDispFlg = false;
        }

        return viewKingakuInfoTutaKngkDispFlg;
    }

    @Override
    public boolean isViewKingakuInfoKaiyakuHrDispFlg() {

        boolean viewKingakuInfoKaiyakuHrDispFlg = true;

        if (shrSyouhnZokusei.size() > 0 &&
            C_UmuKbn.NONE.eq(shrSyouhnZokusei.get(0).getKaiyakuhrhyoujiumu())) {
            viewKingakuInfoKaiyakuHrDispFlg = false;
        }

        return viewKingakuInfoKaiyakuHrDispFlg;
    }

    @Override
    public boolean isViewKingakuInfoKihonHokenKngkDispFlg() {

        boolean viewKingakuInfoKihonHokenKngkDispFlg = true;

        if (shrSyouhnZokusei.size() > 0 &&
            C_UmuKbn.NONE.eq(shrSyouhnZokusei.get(0).getKihonshyoujiumu())) {
            viewKingakuInfoKihonHokenKngkDispFlg = false;
        }

        return viewKingakuInfoKihonHokenKngkDispFlg;
    }

    @Override
    public boolean isViewKingakuInfoSaigaiSDispFlg() {

        boolean viewKingakuInfoSaigaiSDispFlg = true;

        if (shrSyouhnZokusei.size() > 0 &&
            C_UmuKbn.NONE.eq(shrSyouhnZokusei.get(0).getSaigaishyoujiumu())) {
            viewKingakuInfoSaigaiSDispFlg = false;
        }

        return viewKingakuInfoSaigaiSDispFlg;
    }

    @Override
    public boolean isViewSiharaiSateiHokenkinSyuruiDispFlg() {

        boolean viewSiharaiSateiHokenkinSyuruiDispFlg = true;

        if (siKykSyouhn.getDai1hknkkn() != null &&
            siKykSyouhn.getDai1hknkkn().intValue() == 0) {
            viewSiharaiSateiHokenkinSyuruiDispFlg = false;
        }

        return viewSiharaiSateiHokenkinSyuruiDispFlg;
    }

    public List<SiDetailMisyuupBean> getSiDetailMisyuupBeanLst() {
        return siDetailMisyuupBeanLst;
    }

    public void setSiDetailMisyuupBeanLst(List<SiDetailMisyuupBean> siDetailMisyuupBeanLst) {
        this.siDetailMisyuupBeanLst = siDetailMisyuupBeanLst;
    }

    public List<SiDetailMikeikapBean> getSiDetailMikeikapBeanLst() {
        return siDetailMikeikapBeanLst;
    }

    public void setSiDetailMikeikapBeanLst(List<SiDetailMikeikapBean> siDetailMikeikapBeanLst) {
        this.siDetailMikeikapBeanLst = siDetailMikeikapBeanLst;
    }

    @Override
    public boolean isShrGoukeiHaitoukinDispFlg() {
        return shrGoukeiHaitoukinDispFlg;
    }

    public void setShrGoukeiHaitoukinDispFlg(boolean shrGoukeiHaitoukinDispFlg) {
        this.shrGoukeiHaitoukinDispFlg = shrGoukeiHaitoukinDispFlg;
    }

    @Override
    public boolean isShrGoukeiSonotahaitoukinDispFlg() {
        return shrGoukeiSonotahaitoukinDispFlg;
    }

    public void setShrGoukeiSonotahaitoukinDispFlg(boolean shrGoukeiSonotahaitoukinDispFlg) {
        this.shrGoukeiSonotahaitoukinDispFlg = shrGoukeiSonotahaitoukinDispFlg;
    }

    @Override
    public boolean isShrGoukeiMikeikapDispFlg() {
        return shrGoukeiMikeikapDispFlg;
    }

    public void setShrGoukeiMikeikapDispFlg(boolean shrGoukeiMikeikapDispFlg) {
        this.shrGoukeiMikeikapDispFlg = shrGoukeiMikeikapDispFlg;
    }

    @Override
    public boolean isShrGoukeiMisyuupDispFlg() {
        return shrGoukeiMisyuupDispFlg;
    }

    public void setShrGoukeiMisyuupDispFlg(boolean shrGoukeiMisyuupDispFlg) {
        this.shrGoukeiMisyuupDispFlg = shrGoukeiMisyuupDispFlg;
    }

    @Override
    public boolean isShrGoukeiZennouseisankgkDispFlg() {
        return shrGoukeiZennouseisankgkDispFlg;
    }

    public void setShrGoukeiZennouseisankgkDispFlg(boolean shrGoukeiZennouseisankgkDispFlg) {
        this.shrGoukeiZennouseisankgkDispFlg = shrGoukeiZennouseisankgkDispFlg;
    }

    @Override
    public boolean isShrGoukeiAzukarikingkDispFlg() {
        return shrGoukeiAzukarikingkDispFlg;
    }

    public void setShrGoukeiAzukarikingkDispFlg(boolean shrGoukeiAzukarikingkDispFlg) {
        this.shrGoukeiAzukarikingkDispFlg = shrGoukeiAzukarikingkDispFlg;
    }

    @Override
    public boolean isShrGoukeiKrkgkDispFlg() {
        return shrGoukeiKrkgkDispFlg;
    }

    public void setShrGoukeiKrkgkDispFlg(boolean shrGoukeiKrkgkDispFlg) {
        this.shrGoukeiKrkgkDispFlg = shrGoukeiKrkgkDispFlg;
    }

    @Override
    public boolean isViewSiharaiInfoGaikaknsnKijyunYmdFlg() {
        return viewSiharaiInfoGaikaknsnKijyunYmdFlg;
    }

    public void setViewSiharaiInfoGaikaknsnKijyunYmdFlg(boolean viewSiharaiInfoGaikaknsnKijyunYmdFlg) {
        this.viewSiharaiInfoGaikaknsnKijyunYmdFlg = viewSiharaiInfoGaikaknsnKijyunYmdFlg;
    }

    public EditDshrTukiDKoumokuBean getEditDshrTukiDKoumokuBean() {
        return editDshrTukiDKoumokuBean;
    }

    public void setEditDshrTukiDKoumokuBean(EditDshrTukiDKoumokuBean editDshrTukiDKoumokuBean) {
        this.editDshrTukiDKoumokuBean = editDshrTukiDKoumokuBean;
    }
}
