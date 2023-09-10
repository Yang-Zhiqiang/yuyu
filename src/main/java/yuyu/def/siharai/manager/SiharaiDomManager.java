package yuyu.def.siharai.manager;

import java.util.List;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import yuyu.def.base.manager.DomManager;
import yuyu.def.classification.C_BknJkuKbn;
import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_KyhgndkataKbn;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_SaigaiHigaitouKbn;
import yuyu.def.classification.C_SaisateiKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_SeikyuuSyubetu;
import yuyu.def.classification.C_ShiharaikekkadataKbn;
import yuyu.def.classification.C_ShrKekkaKbn;
import yuyu.def.classification.C_SyoriJyoutaiKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_Syorizumiflg;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YobidasimotoTaskKbn;
import yuyu.def.db.entity.JM_Byoumei;
import yuyu.def.db.entity.JM_ChkSiJimuttdk;
import yuyu.def.db.entity.JM_JyudkaigomebrtkWrbkkkn;
import yuyu.def.db.entity.JM_Kyuuhu;
import yuyu.def.db.entity.JM_SiHubiNaiyou;
import yuyu.def.db.entity.JM_SiSyouhnZokusei;
import yuyu.def.db.entity.JM_SiTyouhyoumsg;
import yuyu.def.db.entity.JM_SiinHantei;
import yuyu.def.db.entity.JM_SkNaiyouChk;
import yuyu.def.db.entity.JM_Syujyutu;
import yuyu.def.db.entity.JM_SyujyutuKyuuhu;
import yuyu.def.db.entity.JT_AksrendouzumiSkKykInfo;
import yuyu.def.db.entity.JT_AksrendouzumiSyoruiImg;
import yuyu.def.db.entity.JT_MisyuupRendo;
import yuyu.def.db.entity.JT_Outai;
import yuyu.def.db.entity.JT_SateiSyouninRireki;
import yuyu.def.db.entity.JT_SiBikinkanri;
import yuyu.def.db.entity.JT_SiDenpyoData;
import yuyu.def.db.entity.JT_SiDetail;
import yuyu.def.db.entity.JT_SiDshrTuki;
import yuyu.def.db.entity.JT_SiFBSoukinData;
import yuyu.def.db.entity.JT_SiGaikaFBSoukinData;
import yuyu.def.db.entity.JT_SiHubi;
import yuyu.def.db.entity.JT_SiJinsokuShrTtdkInfo;
import yuyu.def.db.entity.JT_SiKekka;
import yuyu.def.db.entity.JT_SiKykKihon;
import yuyu.def.db.entity.JT_SiRireki;
import yuyu.def.db.entity.JT_SiSentakuInfoTouroku;
import yuyu.def.db.entity.JT_SiTyousyo;
import yuyu.def.db.entity.JT_SinsaTyuui;
import yuyu.def.db.entity.JT_Sk;
import yuyu.def.db.entity.JT_SkKihon;
import yuyu.def.db.entity.JT_TtdkRireki;
import yuyu.def.db.entity.JW_HubiKaisyouDetailWk;
import yuyu.def.db.entity.JW_HubiWk;
import yuyu.def.siharai.result.bean.DoujiSeikyuuInfosBySknoSyonoNeBean;
import yuyu.def.siharai.result.bean.HubiTourokuInfosByHasinymdBean;
import yuyu.def.siharai.result.bean.SiBikinkanriItemsBySyonoBean;
import yuyu.def.siharai.result.bean.SiDetailInfosBySknoSyonoSeikyuurirekinoBean;
import yuyu.def.siharai.result.bean.SiHubisSiHubiDetailsBySyonoBean;
import yuyu.def.siharai.result.bean.SiKykKihonInfosBySeikyuusyubetuNeShrsyoriymdBean;
import yuyu.def.siharai.result.bean.SibouKariuketsukeInfosBySeikyuusyubetuSiboukaritrkymdTorikesiflgBean;
import yuyu.def.siharai.result.bean.SkKihonInfosBySyonoHhknnmknSeikyuusyubetuSyoruiukeymdSeikyuurirekinoMaxBean;


/**
 * 支払 DOM マネージャ インターフェース<br />
 * カテゴリDomマネージャを業務機能から隠蔽するために、抽象クラスと実装クラスに分離して、<br />
 * 業務機能からは見えない実装クラスで、カテゴリDomマネージャを使用しています。 <br />
 */
public interface SiharaiDomManager extends DomManager {


    List<JT_SiKykKihon> getAllSiKykKihon();


    JT_SiKykKihon getSiKykKihon(String pSyono);


    ExDBResults<SiKykKihonInfosBySeikyuusyubetuNeShrsyoriymdBean>  getSiKykKihonInfosBySeikyuusyubetuNeShrsyoriymd(C_SeikyuuSyubetu pSeikyuusyubetu, BizDate pSyoriYmdFrom, BizDate pSyoriYmdTo);


    List<JM_SiSyouhnZokusei> getAllSiSyouhnZokusei();


    JM_SiSyouhnZokusei getSiSyouhnZokusei(String pSyouhncd, C_KyhgndkataKbn pKyhgndkatakbn, Integer pSyouhnsdno, String pKyuuhucd);


    List<JM_SiSyouhnZokusei> getSiSyouhnZokuseisBySyouhncdSyouhnsdno(String pSyouhncd, Integer pSyouhnsdno);


    List<JM_SiSyouhnZokusei> getSiSyouhnZokuseisByKyuuhu(String pSyouhncd, C_KyhgndkataKbn pKyhgndkatakbn, Integer pSyouhnsdno);


    List<JM_Kyuuhu> getAllKyuuhu();


    JM_Kyuuhu getKyuuhu(String pKyuuhucd);


    List<JM_SiSyouhnZokusei> getSiSyouhnZokuseisBySyouhncdKyhgndkatakbnSyouhnsdno(String pSyouhncd, C_KyhgndkataKbn pKyhgndkatakbn, Integer pSyouhnsdno);



    List<JT_Outai> getAllOutai();


    JT_Outai getOutai(String pSyono, Integer pRenno);


    Integer getOutaiMaxRennoBySyono(String pSyono);



    List<JT_SkKihon> getAllSkKihon();


    JT_SkKihon getSkKihon(String pSkno, String pSyono);


    List<JT_SkKihon> getSkKihonsBySyono(String pSyono);


    List<JT_SkKihon> getSkKihonsBySyorijyoutaikbnLikeHhknnmkn(C_SyoriJyoutaiKbn pSyorijyoutaikbn, String pHhknnmkn);


    ExDBResults<JT_SkKihon>  getSkKihonsBySeikyuusyubetuSiboukaritrkymdShrkekkakbns(C_SeikyuuSyubetu pSeikyuusyubetu, BizDate pSiboukaritrkymd, C_ShrKekkaKbn... pShrkekkakbn);


    ExDBResults<JT_SkKihon>  getSkKihonsBySeikyuusyubetuSaisateikbnSiboukaritrkymdShrkekkakbns(C_SeikyuuSyubetu pSeikyuusyubetu, C_SaisateiKbn pSaisateikbn, BizDate pSiboukaritrkymd, BizDate pZennendoKsnbiymd, C_ShrKekkaKbn... pShrkekkakbn);


    ExDBResults<JT_SkKihon>  getSkKihonsByKakutyoujobcdSeikyuusyubetuItems(String pKakutyoujobcd, C_SeikyuuSyubetu pSeikyuusyubetu, BizDate pSiboukaritrkymd, BizDate pTyakkinymd
        , BizDate pShrsyoriymd);


    ExDBResults<JT_SkKihon>  getSkKihonsByKakutyoujobcdSeikyuusyubetuItemsSaisateikbn(String pKakutyoujobcd, C_SeikyuuSyubetu pSeikyuusyubetu, BizDate pSiboukaritrkymd, C_SaisateiKbn pSaisateikbn
        , BizDate pTyakkinymd, BizDate pShrsyoriymd);


    ExDBResults<JT_SkKihon>  getSkKihonsByKakutyoujobcdSeikyuusyubetusItem(String pKakutyoujobcd, C_SeikyuuSyubetu pSeikyuusyubetu1, C_SeikyuuSyubetu pSeikyuusyubetu2, BizDate pSiboukaritrkymd);


    List<JT_SkKihon> getSkKihonsBySyonoSeikyuusyubetuTorikesiflg(String pSyono, C_SeikyuuSyubetu pSeikyuusyubetu, C_UmuKbn pTorikesiflg);


    List<JT_SkKihon> getSkKihonsBySyonoSeikyuusyubetu(String pSyono, C_SeikyuuSyubetu pSeikyuusyubetu);


    ExDBUpdatableResults<JT_SkKihon> getSkKihonsByKakutyoujobcdSyorijyoutaikbnShrkekkakbnNe(String pKakutyoujobcd, C_SyoriJyoutaiKbn pSyorijyoutaikbn, C_ShrKekkaKbn pShrkekkakbn);


    ExDBResults<JT_SkKihon> getSkKihonsBySeikyuusyubetuNeShrsyoriymdShrkekkakbn(BizDate pShrsyoriymdFrom, BizDate pShrsyoriymdTo);


    ExDBResults<JT_SkKihon> getSkKihonsByShrsyoriymdShrkekkakbnSeikyuusyubetu(BizDate pShrsyoriymd, C_ShrKekkaKbn pShrkekkakbn, C_SeikyuuSyubetu pSeikyuusyubetu);


    ExDBResults<JT_SkKihon> getSkKihonsByKakutyoujobcdSeikyuusyubetuNe(String pKakutyoujobcd, BizDate pShrsyoriymd, C_ShrKekkaKbn pShrkekkakbn, C_SeikyuuSyubetu pSeikyuusyubetu);


    List<SkKihonInfosBySyonoHhknnmknSeikyuusyubetuSyoruiukeymdSeikyuurirekinoMaxBean> getSkKihonInfosBySyonoHhknnmknSeikyuusyubetuSyoruiukeymdSeikyuurirekinoMax(String pSyono, String pHhknnmkn, C_SeikyuuSyubetu pSeikyuusyubetu, BizDate pSyoruiukeymdFrom, BizDate pSyoruiukeymdTo);


    List<JT_SkKihon> getSkKihonsByHhknnmknTorikesiflg(String pHhknnmkn);


    List<JT_SkKihon> getSkKihonsBySyonoSeikyuusyubetuSaisateikbn(String pSyono, C_SeikyuuSyubetu pSeikyuusyubetu, C_SaisateiKbn pSaisateikbn);


    List<DoujiSeikyuuInfosBySknoSyonoNeBean> getDoujiSeikyuuInfosBySknoSyonoNe(String pSkno, String pSyono);


    JT_Sk getSkBySknoSyonoMaxSeikyuurirekino(String pSkno, String pSyono);


    Integer getSkMaxSeikyuurirekinoBySknoSyono(String pSkno, String pSyono);


    List<JT_Sk> getSksBySyonoItemsSeikyuurirekinoMax(String pSyono, C_SeikyuuSyubetu pSeikyuusyubetu, C_SaisateiKbn pSaisateikbn, C_SyoriJyoutaiKbn pSyorijyoutaikbn);


    List<JT_SiRireki> getSiRirekisBySyonoShrkekkakbnTorikesiflg(String pSyono, C_ShrKekkaKbn pShrkekkakbn, C_UmuKbn pTorikesiflg);


    List<JT_SiRireki> getSiRirekisBySyonoGyoumuKousinTime(String pSyono, String pGyoumuKousinTime);


    String getSiRirekiMaxShrsikibetukeyBySknoSyono(String pSkno, String pSyono);


    List<Object[]> getSiRirekiSkKihonSksBySyonoTorikesiflg(String pSyono, C_UmuKbn pTorikesiflg);


    ExDBResults<JT_SiRireki> getSiRirekisBySeikyuusyubetuShrsyoriymdShrkekkakbn(BizDate pShrsyoriymdFrom, BizDate pShrsyoriymdTo);


    ExDBResults<JT_SiRireki> getSiRirekisByShrkekkakbnShrsyoriymdFromShrsyoriymdTo(C_ShrKekkaKbn pShrkekkakbn, BizDate pShrsyoriymdFrom, BizDate pShrsyoriymdTo);


    List<JM_Byoumei> getAllByoumei();


    JM_Byoumei getByoumei(String pByoumeitourokuno);


    List<JM_Byoumei> getByoumeisByByoumeikjByoumeiknByoumeicd(String pByoumeikj, String pByoumeikn, String pByoumeicd);


    List<JM_Syujyutu> getAllSyujyutu();


    JM_Syujyutu getSyujyutu(String pSyujyututourokuno);


    List<JM_SyujyutuKyuuhu> getAllSyujyutuKyuuhu();


    JM_SyujyutuKyuuhu getSyujyutuKyuuhu(String pSyujyutubunruicd, String pSyouhncd, Integer pSyouhnsdno, String pKyuuhucd, BizDate pSyujyututekiyoukkanfrom
        , BizDate pSyujyututekiyoukkanto);


    List<JT_MisyuupRendo> getAllMisyuupRendo();


    JT_MisyuupRendo getMisyuupRendo(String pSyono, Integer pDatarenno);


    List<JT_SiDenpyoData> getAllSiDenpyoData();


    JT_SiDenpyoData getSiDenpyoData(String pDenrenno, Integer pEdano);


    List<JT_SiDenpyoData> getSiDenpyoDatasBySyonoSyoriYmdSyoricd(String pSyono, BizDate pSyoriYmd, String pSyoricd);


    ExDBUpdatableResults<JT_SiDenpyoData> getSiDenpyoDatasByKakutyoujobcdSyoriYmd(String pKakutyoujobcd, BizDate pSyoriYmd);


    List<JT_SiFBSoukinData> getAllSiFBSoukinData();


    List<JT_SiFBSoukinData> getSiFBSoukinDatasBySyonoSyoriYmdSyoricd(String pSyono, BizDate pSyoriYmd, String pSyoricd);


    ExDBResults<JT_SiFBSoukinData> getSiFBSoukinDatasByKakutyoujobcdSyoriYmd(String pKakutyoujobcd, BizDate pSyoriYmd);


    JT_SiFBSoukinData getSiFBSoukinData(String pFbsoukindatasikibetukey);


    List<JT_SiGaikaFBSoukinData> getAllSiGaikaFBSoukinData();


    List<JT_SiGaikaFBSoukinData> getSiGaikaFBSoukinDatasBySyonoSyoriYmdSyoricd(String pSyono, BizDate pSyoriYmd, String pSyoricd);


    JT_SiGaikaFBSoukinData getSiGaikaFBSoukinData(String pFbsoukindatasikibetukey);


    ExDBResults<JT_SiGaikaFBSoukinData> getSiGaikaFBSoukinDatasByKakutyoujobcdSyoriYmd(String pKakutyoujobcd, BizDate pSyoriYmd);


    List<JT_SiKekka> getAllSiKekka();


    JT_SiKekka getSiKekka(C_ShiharaikekkadataKbn pShiharaikekkadatakbn, String pSyono, String pSyouhncd, Integer pSyouhnsdno, Integer pKyksyouhnrenno
        , C_SyutkKbn pSyutkkbn);


    ExDBResults<JT_SiKekka> getSiKekkasByKakutyoujobcd(String pKakutyoujobcd);


    ExDBResults<JT_SiKekka> getSiKekkasByKakutyoujobcdSyoriYmd(String pKakutyoujobcd, BizDate pSyoriYmd);


    List<JT_SiKekka> getSiKekkasBySyono(String pSyono);


    List<JT_SiKekka> getSiKekkasBySyonoSyoumetujiyuuNe(String pSyono, C_Syoumetujiyuu  pSyoumetujiyuu);


    List<JT_SiTyousyo> getAllSiTyousyo();


    JT_SiTyousyo getSiTyousyo(String pSyono, BizDate pTyouhyouymd, Long pShrtysyrenno);


    List<JT_SkKihon> getSkKihonsBySyonoSibouKariuketsuke(String pSyono);


    String getTtdkRirekiMaxTtdkrrkskbtkeyBySknoSyono(String pSkno, String pSyono);


    ExDBResults<JT_TtdkRireki> getTtdkRirekisBySyoriYmdKossyorisscdSyorikekkakbnMaxTtdkrrkskbtkey(BizDate pSyoriYmd, String pKossyorisscd);


    JT_TtdkRireki getTtdkRirekisBySknoSyonoSyorikekkakbnKossyorisscds(String pSkno, String pSyono, C_SyorikekkaKbn pSyorikekkakbn, String[] pKossyorisscd);


    JT_TtdkRireki getTtdkRirekisBySknoSyonoSyorikekkakbnsKossyorisscds(String pSkno, String pSyono, String[] pKossyorisscd, C_SyorikekkaKbn... pSyorikekkakbn);


    ExDBResults<JT_SateiSyouninRireki> getSateiSyouninRirekisBySyorikekkakbnSyoriYmdKossyorisscds(C_SyorikekkaKbn pSyorikekkakbn, BizDate pSyoriYmdFrom, BizDate pSyoriYmdTo, String[] pKossyorisscd);


    ExDBResults<JT_SateiSyouninRireki> getSaishigaitoulistsBySyorikekkakbnItems(C_SyorikekkaKbn pSyorikekkakbn, String[] pKossyorisscd, BizDate pSyoriYmdFrom, BizDate pSyoriYmdTo, C_SaigaiHigaitouKbn pSaigaihigaitoukbn);


    String getSateiSyouninRirekiMaxSateisyouninskbtkeyBySknoSyono(String pSkno, String pSyono);


    ExDBResults<SibouKariuketsukeInfosBySeikyuusyubetuSiboukaritrkymdTorikesiflgBean> getSibouKariuketsukeInfosBySeikyuusyubetuSiboukaritrkymdTorikesiflg(BizDate pTaisyoukknfrom, BizDate pTaisyoukknto);


    List<JT_SkKihon> getSkKihonsBySyonoTorikesiflg(String pSyono, C_UmuKbn pTorikesiflg);


    List<SiDetailInfosBySknoSyonoSeikyuurirekinoBean> getSiDetailInfosBySknoSyonoSeikyuurirekino(String pSkno, String pSyono, Integer pSeikyuurirekino);


    ExDBResults<JT_SkKihon> getSkKihonsByKakutyoujobcdGaibuinsatuoutymd(String pKakutyoujobcd, BizDate pGaibuinsatuoutymd);


    List<JT_SiDetail> getSiDetailsBySknoSyonoSeikyuurirekino(String pSkno, String pSyono, Integer pSeikyuurirekino);


    ExDBResults<JT_SiRireki> getSiRirekisByShrkekkakbnTyakkinymdFromTyakkinymdTo(C_ShrKekkaKbn pShrkekkakbn, BizDate pTyakkinymdFrom, BizDate pTyakkinymdTo);


    Long getSibouKariuketsukeCountBySyono(String pSyono);


    List<JT_SiDshrTuki> getAllSiDshrTuki();


    JT_SiDshrTuki getSiDshrTuki(String pDshrtoukeisikibetukey);


    JT_SiDshrTuki getSiDshrTukiBySyonoSknoRirekino(String pSyono, String pSkno, Integer pSeikyuurirekino);



    List<JT_SiHubi> getAllSiHubi();


    JT_SiHubi getSiHubi(String pHubisikibetukey);


    JT_SiHubi getSiHubiByHubisikibetukeyHasinymd(String pHubisikibetukey, BizDate pHasinymd);


    List<JT_SiHubi> getSiHubisBySyono(String pSyono);


    List<SiHubisSiHubiDetailsBySyonoBean> getSiHubisSiHubiDetailsBySyono(String pSyono);


    ExDBResults<HubiTourokuInfosByHasinymdBean> getHubiTourokuInfosByHasinymd(BizDate pHasinymd);


    Integer getSiHubiDetailMaxRenno3ketaByHubisikibetukeyHasinymd(String pHubisikibetukey);



    List<JT_SiSentakuInfoTouroku> getAllSiSentakuInfoTouroku();


    JT_SiSentakuInfoTouroku getSiSentakuInfoTouroku(String pSyono, Integer pRenno);


    ExDBUpdatableResults<JT_SiSentakuInfoTouroku> getSiSentakuInfoTourokusByKakutyoujobcdSyorizumiflg(String pKakutyoujobcd, C_Syorizumiflg pSyorizumiflg);


    List<JT_SinsaTyuui> getAllSinsaTyuui();


    JT_SinsaTyuui getSinsaTyuui(String pSyono);


    List<JM_SiTyouhyoumsg> getAllSiTyouhyoumsg();


    JM_SiTyouhyoumsg getSiTyouhyoumsg(String pBunrui1, String pBunrui2, Integer pTyouhyoulineno);


    List<JM_SiTyouhyoumsg> getSiTyouhyoumsgsByBunrui1Bunrui2(String pBunrui1, String pBunrui2);


    List<JM_SkNaiyouChk> getAllSkNaiyouChk();


    JM_SkNaiyouChk getSkNaiyouChk(C_SKNaiyouChkKbn pSknaiyouchkkbn, C_YobidasimotoTaskKbn pYobidasimototaskkbn);


    List<JT_AksrendouzumiSyoruiImg> getAllAksrendouzumiSyoruiImg();


    JT_AksrendouzumiSyoruiImg getAksrendouzumiSyoruiImg(String pSkno, String pSyono, String pImageid);


    List<JT_AksrendouzumiSkKykInfo> getAllAksrendouzumiSkKykInfo();


    JT_AksrendouzumiSkKykInfo getAksrendouzumiSkKykInfo(String pSkno, String pSyono);


    List<JT_SiJinsokuShrTtdkInfo> getAllSiJinsokuShrTtdkInfo();


    JT_SiJinsokuShrTtdkInfo getSiJinsokuShrTtdkInfo(String pSyorisosikicd, String pSyoricd, String pHknknshrsntkno, BizDate pSyoruiukeymd, BizDate pSyoriYmd
        , BizDate pDenymd, String pSyono);


    ExDBResults<JT_SiJinsokuShrTtdkInfo> getSiJinsokuShrTtdkInfosBySyoriYmd(BizDate pSyoriYmdFrom, BizDate pSyoriYmdTo);


    List<JM_SiinHantei> getAllSiinHantei();


    JM_SiinHantei getSiinHantei(C_GeninKbn pSiboukariuketukejigeninkbn, C_GeninKbn pSeikyuuuketukejigeninkbn, C_UmuKbn pKansensyouumukbn
        , C_UmuKbn pSaigaikanouseiumukbn, C_UmuKbn pHusyounosiumukbn, C_UmuKbn pSateikaksaigaikanouseikbn, C_UmuKbn pSateikakhusyousikbn);


    List<JM_SiHubiNaiyou> getAllSiHubiNaiyou();


    List<JM_SiHubiNaiyou> getSiHubiNaiyousByJimutetuzukicdSyoruiCd(String pJimutetuzukicd, C_SyoruiCdKbn pSyoruiCd);


    JM_SiHubiNaiyou getSiHubiNaiyou(String pJimutetuzukicd, C_SyoruiCdKbn pSyoruiCd, String pHubinaiyoucd);


    List<JT_SiBikinkanri> getAllSiBikinkanri();


    JT_SiBikinkanri getSiBikinkanri(String pSkno, String pSyono, BizDate pKessankijyunymd, C_BkncdKbn pBkncdkbn, BizDate pBknkktymd, String pKyuuhucd);


    ExDBResults<JT_SiBikinkanri> getSiBikinkanrisByKakutyoujobcdItemsOrderBy4Items(String pKakutyoujobcd, BizDate pKessankijyunymd, C_BknrigiKbn pBknrigikbn);


    List<SiBikinkanriItemsBySyonoBean> getSiBikinkanriItemsBySyono(String pSyono);


    ExDBResults<JT_SiBikinkanri> getSiBikinkanrisByKakutyoujobcdItems(String pKakutyoujobcd, BizDate pKessankijyunymd, C_BknrigiKbn pBknrigikbn);


    List<JT_SiBikinkanri> getSiBikinkanrisBySyono(String pSyono);


    List<JT_SiBikinkanri> getSiBikinkanrisBySyonoBknjkukbn(String pSyono);


    List<JT_SiBikinkanri> getSiBikinkanrisBySyonoSkno(String pSyono, String pSkno);


    ExDBResults<JT_SiBikinkanri>  getSiBikinkanrisByBknkktymdCalckijyunymdKessankijyunymd(BizDate pBknkktymd, BizDate pCalckijyunymd, BizDate pKessankijyunymd);


    ExDBResults<JT_SiBikinkanri>  getSiBikinkanrisByBknkktymdItems(BizDate pBknkktymd, BizDate pCalckijyunymd, BizDate pKessankijyunymd, C_BknrigiKbn pBknrigikbn);


    List<JT_SiBikinkanri> getSiBikinkanrisByKessankijyunymdBknrigikbn(BizDate pKessankijyunymd, C_BknrigiKbn pBknrigikbn);


    List<JT_SiBikinkanri> getSiBikinkanrisByKessankijyunymdBknrigikbnNe(BizDate pKessankijyunymd, C_BknrigiKbn pBknrigikbn);


    List<JT_SiBikinkanri> getSiBikinkanrisBySknoSyonoKessankijyunymdBkncdkbn(String pSkno, String pSyono, BizDate pKessankijyunymd, C_BkncdKbn pBkncdkbn);


    List<JT_SiBikinkanri> getSiBikinkanrisBySyonoKessankijyunymdBkncdkbns(String pSyono, BizDate pKessankijyunymd, C_BkncdKbn... pBkncdkbn);


    ExDBResults<JT_SiBikinkanri> getSiBikinkanrisByKessankijyunymdBknrigikbnEx(BizDate pKessankijyunymd, C_BknrigiKbn pBknrigikbn);


    List<JT_SiBikinkanri> getSiBikinkanrisBySyonoKessankijyunymdBkncdkbn(String pSyono, BizDate pKessankijyunymd);


    List<JM_JyudkaigomebrtkWrbkkkn> getAllJyudkaigomebrtkWrbkkkn();


    JM_JyudkaigomebrtkWrbkkkn getJyudkaigomebrtkWrbkkkn(Integer pHhknnen, C_Seibetu pSeibetu);


    ExDBResults<JT_SiBikinkanri> getSiBikinkanrisByKessankijyunymdBknrigikbnOrderByBkntyousafsyorikbnSyono(BizDate pKessankijyunymd, C_BknrigiKbn pBknrigikbn);


    ExDBResults<JT_SiBikinkanri> getSiBikinkanrisByZennouseisankin(BizDate pKessankijyunymd, C_UmuKbn pZennouseisankinumukbn, C_ShrKekkaKbn pShrkekkakbn, C_BknrigiKbn pBknrigikbn);


    ExDBResults<JT_SiBikinkanri> getSiBikinkanrisByMikeikap(BizDate pKessankijyunymd, C_UmuKbn pMikeikapumukbn, C_ShrKekkaKbn pShrkekkakbn, C_BknrigiKbn pBknrigikbn);


    ExDBResults<JT_SiBikinkanri> getSiBikinkanrisByMisyup(BizDate pKessankijyunymd, C_UmuKbn pMisyuupumukbn, C_ShrKekkaKbn pShrkekkakbn, C_BknrigiKbn pBknrigikbn);


    List<JM_ChkSiJimuttdk> getAllChkSiJimuttdk();


    JM_ChkSiJimuttdk getChkSiJimuttdk(String pKinouId, String pSyorijimuttdkcd);


    ExDBResults<JT_SiBikinkanri> getSiBikinkanrisByKsnYmdBknJkuKbnBknrigikbnEx(BizDate pKessankijyunymd, C_BknJkuKbn pBknJkuKbn, C_BknrigiKbn pBknrigiKbn);



    List<JW_HubiWk> getAllHubiWk();


    JW_HubiWk getHubiWk(String pKouteikanriid);


    List<JW_HubiKaisyouDetailWk> getAllHubiKaisyouDetailWk();


    JW_HubiKaisyouDetailWk getHubiKaisyouDetailWk(String pKouteikanriid, Integer pRenno3keta);


    List<JW_HubiKaisyouDetailWk> getHubiKaisyouDetailWksByKouteikanriid(String pKouteikanriid);


    JM_SiSyouhnZokusei getSiSyouhnZokuseisBySyouhncd(String pSyouhncd);


    public List<JT_SiBikinkanri> getSiBikinkanrisBySyonoKsnYmdJkukbnRigikbnNe(String pSyono, BizDate pKessankijyunymd,
        C_BknJkuKbn pBknJkuKbn,C_BknrigiKbn pBknrigiKbn);

}
