package yuyu.def.siharai.manager.impl;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import yuyu.def.base.manager.AbstractDomManager;
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
import yuyu.def.siharai.manager.SiharaiDomManager;
import yuyu.def.siharai.result.bean.DoujiSeikyuuInfosBySknoSyonoNeBean;
import yuyu.def.siharai.result.bean.HubiTourokuInfosByHasinymdBean;
import yuyu.def.siharai.result.bean.SiBikinkanriItemsBySyonoBean;
import yuyu.def.siharai.result.bean.SiDetailInfosBySknoSyonoSeikyuurirekinoBean;
import yuyu.def.siharai.result.bean.SiHubisSiHubiDetailsBySyonoBean;
import yuyu.def.siharai.result.bean.SiKykKihonInfosBySeikyuusyubetuNeShrsyoriymdBean;
import yuyu.def.siharai.result.bean.SibouKariuketsukeInfosBySeikyuusyubetuSiboukaritrkymdTorikesiflgBean;
import yuyu.def.siharai.result.bean.SkKihonInfosBySyonoHhknnmknSeikyuusyubetuSyoruiukeymdSeikyuurirekinoMaxBean;


/**
 * 支払 DOM マネージャ 実装クラス<br />
 * {@link SiharaiDomManager}で宣言したメソッドを実装します。<br />
 * カテゴリDomマネージャを業務機能から隠蔽するために、抽象クラスと実装クラスに分離して、<br />
 * 業務機能からは見えない実装クラスで、カテゴリDomマネージャを使用しています。 <br />
 */
public class SiharaiDomManagerImpl extends AbstractDomManager implements SiharaiDomManager {


    @Inject
    private KeiyakuDomManager keiyakuDomManager;


    @Inject
    private OutaiDomManager outaiDomManager;


    @Inject
    private SeikyuuDomManager seikyuuDomManager;


    @Inject
    private HubiDomManager hubiDomManager;


    @Inject
    private EtcDomManager etcDomManager;


    @Inject
    private WkDomManager wkDomManager;



    @Override
    public List<JT_SiKykKihon> getAllSiKykKihon() {
        return keiyakuDomManager.getAllSiKykKihon();
    }


    @Override
    public JT_SiKykKihon getSiKykKihon(String pSyono) {
        return keiyakuDomManager.getSiKykKihon(pSyono);
    }


    @Override
    public ExDBResults<SiKykKihonInfosBySeikyuusyubetuNeShrsyoriymdBean>  getSiKykKihonInfosBySeikyuusyubetuNeShrsyoriymd(C_SeikyuuSyubetu pSeikyuusyubetu, BizDate pSyoriYmdFrom, BizDate pSyoriYmdTo) {
        return keiyakuDomManager.getSiKykKihonInfosBySeikyuusyubetuNeShrsyoriymd(pSeikyuusyubetu, pSyoriYmdFrom, pSyoriYmdTo);
    }


    @Override
    public List<JM_SiSyouhnZokusei> getAllSiSyouhnZokusei() {
        return keiyakuDomManager.getAllSiSyouhnZokusei();
    }


    @Override
    public JM_SiSyouhnZokusei getSiSyouhnZokusei(String pSyouhncd, C_KyhgndkataKbn pKyhgndkatakbn, Integer pSyouhnsdno, String pKyuuhucd) {
        return keiyakuDomManager.getSiSyouhnZokusei(pSyouhncd, pKyhgndkatakbn, pSyouhnsdno, pKyuuhucd);
    }


    @Override
    public List<JM_SiSyouhnZokusei> getSiSyouhnZokuseisBySyouhncdSyouhnsdno(String pSyouhncd, Integer pSyouhnsdno) {
        return keiyakuDomManager.getSiSyouhnZokuseisBySyouhncdSyouhnsdno(pSyouhncd, pSyouhnsdno);
    }


    @Override
    public List<JM_SiSyouhnZokusei> getSiSyouhnZokuseisByKyuuhu(String pSyouhncd, C_KyhgndkataKbn pKyhgndkatakbn, Integer pSyouhnsdno) {
        return keiyakuDomManager.getSiSyouhnZokuseisByKyuuhu(pSyouhncd, pKyhgndkatakbn, pSyouhnsdno);
    }


    @Override
    public List<JM_Kyuuhu> getAllKyuuhu() {
        return keiyakuDomManager.getAllKyuuhu();
    }


    @Override
    public JM_Kyuuhu getKyuuhu(String pKyuuhucd) {
        return keiyakuDomManager.getKyuuhu(pKyuuhucd);
    }


    @Override
    public List<JM_SiSyouhnZokusei> getSiSyouhnZokuseisBySyouhncdKyhgndkatakbnSyouhnsdno(String pSyouhncd, C_KyhgndkataKbn pKyhgndkatakbn, Integer pSyouhnsdno) {
        return keiyakuDomManager.getSiSyouhnZokuseisBySyouhncdKyhgndkatakbnSyouhnsdno(pSyouhncd, pKyhgndkatakbn, pSyouhnsdno);
    }



    @Override
    public List<JT_Outai> getAllOutai() {
        return outaiDomManager.getAllOutai();
    }


    @Override
    public JT_Outai getOutai(String pSyono, Integer pRenno) {
        return outaiDomManager.getOutai(pSyono, pRenno);
    }


    @Override
    public Integer getOutaiMaxRennoBySyono(String pSyono) {
        return outaiDomManager.getOutaiMaxRennoBySyono(pSyono);
    }



    @Override
    public List<JT_SkKihon> getAllSkKihon() {
        return seikyuuDomManager.getAllSkKihon();
    }


    @Override
    public JT_SkKihon getSkKihon(String pSkno, String pSyono) {
        return seikyuuDomManager.getSkKihon(pSkno, pSyono);
    }


    @Override
    public List<JT_SkKihon> getSkKihonsBySyono(String pSyono) {
        return seikyuuDomManager.getSkKihonsBySyono(pSyono);
    }


    @Override
    public List<JT_SkKihon> getSkKihonsBySyorijyoutaikbnLikeHhknnmkn(C_SyoriJyoutaiKbn pSyorijyoutaikbn, String pHhknnmkn) {
        return seikyuuDomManager.getSkKihonsBySyorijyoutaikbnLikeHhknnmkn(pSyorijyoutaikbn, pHhknnmkn);
    }


    @Override
    public ExDBResults<JT_SkKihon>  getSkKihonsBySeikyuusyubetuSiboukaritrkymdShrkekkakbns(C_SeikyuuSyubetu pSeikyuusyubetu, BizDate pSiboukaritrkymd, C_ShrKekkaKbn... pShrkekkakbn) {
        return seikyuuDomManager.getSkKihonsBySeikyuusyubetuSiboukaritrkymdShrkekkakbns(pSeikyuusyubetu, pSiboukaritrkymd, pShrkekkakbn);
    }


    @Override
    public ExDBResults<JT_SkKihon>  getSkKihonsBySeikyuusyubetuSaisateikbnSiboukaritrkymdShrkekkakbns(C_SeikyuuSyubetu pSeikyuusyubetu, C_SaisateiKbn pSaisateikbn, BizDate pSiboukaritrkymd, BizDate pZennendoKsnbiymd,C_ShrKekkaKbn... pShrkekkakbn) {
        return seikyuuDomManager.getSkKihonsBySeikyuusyubetuSaisateikbnSiboukaritrkymdShrkekkakbns(pSeikyuusyubetu, pSaisateikbn, pSiboukaritrkymd, pZennendoKsnbiymd, pShrkekkakbn);
    }


    @Override
    public ExDBResults<JT_SkKihon>  getSkKihonsByKakutyoujobcdSeikyuusyubetuItems(String pKakutyoujobcd, C_SeikyuuSyubetu pSeikyuusyubetu, BizDate pSiboukaritrkymd, BizDate pTyakkinymd
        , BizDate pShrsyoriymd) {
        return seikyuuDomManager.getSkKihonsByKakutyoujobcdSeikyuusyubetuItems(pKakutyoujobcd, pSeikyuusyubetu, pSiboukaritrkymd, pTyakkinymd
            , pShrsyoriymd);
    }


    @Override
    public ExDBResults<JT_SkKihon>  getSkKihonsByKakutyoujobcdSeikyuusyubetuItemsSaisateikbn(String pKakutyoujobcd, C_SeikyuuSyubetu pSeikyuusyubetu, BizDate pSiboukaritrkymd, C_SaisateiKbn pSaisateikbn
        , BizDate pTyakkinymd, BizDate pShrsyoriymd) {
        return seikyuuDomManager.getSkKihonsByKakutyoujobcdSeikyuusyubetuItemsSaisateikbn(pKakutyoujobcd, pSeikyuusyubetu, pSiboukaritrkymd, pSaisateikbn
            , pTyakkinymd, pShrsyoriymd);
    }


    @Override
    public ExDBResults<JT_SkKihon>  getSkKihonsByKakutyoujobcdSeikyuusyubetusItem(String pKakutyoujobcd, C_SeikyuuSyubetu pSeikyuusyubetu1, C_SeikyuuSyubetu pSeikyuusyubetu2, BizDate pSiboukaritrkymd) {
        return seikyuuDomManager.getSkKihonsByKakutyoujobcdSeikyuusyubetusItem(pKakutyoujobcd, pSeikyuusyubetu1, pSeikyuusyubetu2, pSiboukaritrkymd);
    }


    @Override
    public List<JT_SkKihon> getSkKihonsBySyonoSeikyuusyubetuTorikesiflg(String pSyono, C_SeikyuuSyubetu pSeikyuusyubetu, C_UmuKbn pTorikesiflg) {
        return seikyuuDomManager.getSkKihonsBySyonoSeikyuusyubetuTorikesiflg(pSyono, pSeikyuusyubetu, pTorikesiflg);
    }


    @Override
    public List<JT_SkKihon> getSkKihonsBySyonoSeikyuusyubetu(String pSyono, C_SeikyuuSyubetu pSeikyuusyubetu) {
        return seikyuuDomManager.getSkKihonsBySyonoSeikyuusyubetu(pSyono, pSeikyuusyubetu);
    }


    @Override
    public ExDBUpdatableResults<JT_SkKihon> getSkKihonsByKakutyoujobcdSyorijyoutaikbnShrkekkakbnNe(String pKakutyoujobcd, C_SyoriJyoutaiKbn pSyorijyoutaikbn, C_ShrKekkaKbn pShrkekkakbn) {
        return seikyuuDomManager.getSkKihonsByKakutyoujobcdSyorijyoutaikbnShrkekkakbnNe(pKakutyoujobcd, pSyorijyoutaikbn, pShrkekkakbn);
    }


    @Override
    public ExDBResults<JT_SkKihon> getSkKihonsBySeikyuusyubetuNeShrsyoriymdShrkekkakbn(BizDate pShrsyoriymdFrom, BizDate pShrsyoriymdTo) {
        return seikyuuDomManager.getSkKihonsBySeikyuusyubetuNeShrsyoriymdShrkekkakbn(pShrsyoriymdFrom, pShrsyoriymdTo);
    }


    @Override
    public ExDBResults<JT_SkKihon> getSkKihonsByShrsyoriymdShrkekkakbnSeikyuusyubetu(BizDate pShrsyoriymd, C_ShrKekkaKbn pShrkekkakbn, C_SeikyuuSyubetu pSeikyuusyubetu) {
        return seikyuuDomManager.getSkKihonsByShrsyoriymdShrkekkakbnSeikyuusyubetu(pShrsyoriymd, pShrkekkakbn, pSeikyuusyubetu);
    }


    @Override
    public ExDBResults<JT_SkKihon> getSkKihonsByKakutyoujobcdSeikyuusyubetuNe(String pKakutyoujobcd, BizDate pShrsyoriymd, C_ShrKekkaKbn pShrkekkakbn, C_SeikyuuSyubetu pSeikyuusyubetu) {
        return seikyuuDomManager.getSkKihonsByKakutyoujobcdSeikyuusyubetuNe(pKakutyoujobcd, pShrsyoriymd, pShrkekkakbn, pSeikyuusyubetu);
    }


    @Override
    public List<SkKihonInfosBySyonoHhknnmknSeikyuusyubetuSyoruiukeymdSeikyuurirekinoMaxBean> getSkKihonInfosBySyonoHhknnmknSeikyuusyubetuSyoruiukeymdSeikyuurirekinoMax(String pSyono, String pHhknnmkn, C_SeikyuuSyubetu pSeikyuusyubetu, BizDate pSyoruiukeymdFrom, BizDate pSyoruiukeymdTo) {
        return seikyuuDomManager.getSkKihonInfosBySyonoHhknnmknSeikyuusyubetuSyoruiukeymdSeikyuurirekinoMax(pSyono, pHhknnmkn, pSeikyuusyubetu, pSyoruiukeymdFrom, pSyoruiukeymdTo);
    }


    @Override
    public List<JT_SkKihon> getSkKihonsByHhknnmknTorikesiflg(String pHhknnmkn) {
        return seikyuuDomManager.getSkKihonsByHhknnmknTorikesiflg(pHhknnmkn);
    }


    @Override
    public List<JT_SkKihon> getSkKihonsBySyonoSeikyuusyubetuSaisateikbn(String pSyono, C_SeikyuuSyubetu pSeikyuusyubetu, C_SaisateiKbn pSaisateikbn) {
        return seikyuuDomManager.getSkKihonsBySyonoSeikyuusyubetuSaisateikbn(pSyono, pSeikyuusyubetu, pSaisateikbn);
    }


    @Override
    public List<DoujiSeikyuuInfosBySknoSyonoNeBean> getDoujiSeikyuuInfosBySknoSyonoNe(String pSkno, String pSyono) {
        return seikyuuDomManager.getDoujiSeikyuuInfosBySknoSyonoNe(pSkno, pSyono);
    }


    @Override
    public JT_Sk getSkBySknoSyonoMaxSeikyuurirekino(String pSkno, String pSyono) {
        return seikyuuDomManager.getSkBySknoSyonoMaxSeikyuurirekino(pSkno, pSyono);
    }


    @Override
    public Integer getSkMaxSeikyuurirekinoBySknoSyono(String pSkno, String pSyono) {
        return seikyuuDomManager.getSkMaxSeikyuurirekinoBySknoSyono(pSkno, pSyono);
    }


    @Override
    public List<JT_Sk> getSksBySyonoItemsSeikyuurirekinoMax(String pSyono, C_SeikyuuSyubetu pSeikyuusyubetu, C_SaisateiKbn pSaisateikbn, C_SyoriJyoutaiKbn pSyorijyoutaikbn) {
        return seikyuuDomManager.getSksBySyonoItemsSeikyuurirekinoMax(pSyono, pSeikyuusyubetu, pSaisateikbn, pSyorijyoutaikbn);
    }


    @Override
    public List<JT_SiRireki> getSiRirekisBySyonoShrkekkakbnTorikesiflg(String pSyono, C_ShrKekkaKbn pShrkekkakbn, C_UmuKbn pTorikesiflg) {
        return seikyuuDomManager.getSiRirekisBySyonoShrkekkakbnTorikesiflg(pSyono, pShrkekkakbn, pTorikesiflg);
    }


    @Override
    public List<JT_SiRireki> getSiRirekisBySyonoGyoumuKousinTime(String pSyono, String pGyoumuKousinTime) {
        return seikyuuDomManager.getSiRirekisBySyonoGyoumuKousinTime(pSyono, pGyoumuKousinTime);
    }


    @Override
    public String getSiRirekiMaxShrsikibetukeyBySknoSyono(String pSkno, String pSyono) {
        return seikyuuDomManager.getSiRirekiMaxShrsikibetukeyBySknoSyono(pSkno, pSyono);
    }


    @Override
    public List<Object[]> getSiRirekiSkKihonSksBySyonoTorikesiflg(String pSyono, C_UmuKbn pTorikesiflg) {
        return seikyuuDomManager.getSiRirekiSkKihonSksBySyonoTorikesiflg(pSyono, pTorikesiflg);
    }


    @Override
    public ExDBResults<JT_SiRireki> getSiRirekisBySeikyuusyubetuShrsyoriymdShrkekkakbn(BizDate pShrsyoriymdFrom, BizDate pShrsyoriymdTo) {
        return seikyuuDomManager.getSiRirekisBySeikyuusyubetuShrsyoriymdShrkekkakbn(pShrsyoriymdFrom, pShrsyoriymdTo);
    }


    @Override
    public ExDBResults<JT_SiRireki> getSiRirekisByShrkekkakbnShrsyoriymdFromShrsyoriymdTo(C_ShrKekkaKbn pShrkekkakbn, BizDate pShrsyoriymdFrom, BizDate pShrsyoriymdTo) {
        return seikyuuDomManager.getSiRirekisByShrkekkakbnShrsyoriymdFromShrsyoriymdTo(pShrkekkakbn, pShrsyoriymdFrom, pShrsyoriymdTo);
    }


    @Override
    public List<JM_Byoumei> getAllByoumei() {
        return seikyuuDomManager.getAllByoumei();
    }


    @Override
    public JM_Byoumei getByoumei(String pByoumeitourokuno) {
        return seikyuuDomManager.getByoumei(pByoumeitourokuno);
    }


    @Override
    public List<JM_Byoumei> getByoumeisByByoumeikjByoumeiknByoumeicd(String pByoumeikj, String pByoumeikn, String pByoumeicd) {
        return seikyuuDomManager.getByoumeisByByoumeikjByoumeiknByoumeicd(pByoumeikj, pByoumeikn, pByoumeicd);
    }


    @Override
    public List<JM_Syujyutu> getAllSyujyutu() {
        return seikyuuDomManager.getAllSyujyutu();
    }


    @Override
    public JM_Syujyutu getSyujyutu(String pSyujyututourokuno) {
        return seikyuuDomManager.getSyujyutu(pSyujyututourokuno);
    }


    @Override
    public List<JM_SyujyutuKyuuhu> getAllSyujyutuKyuuhu() {
        return seikyuuDomManager.getAllSyujyutuKyuuhu();
    }


    @Override
    public JM_SyujyutuKyuuhu getSyujyutuKyuuhu(String pSyujyutubunruicd, String pSyouhncd, Integer pSyouhnsdno, String pKyuuhucd, BizDate pSyujyututekiyoukkanfrom
        , BizDate pSyujyututekiyoukkanto) {
        return seikyuuDomManager.getSyujyutuKyuuhu(pSyujyutubunruicd, pSyouhncd, pSyouhnsdno, pKyuuhucd, pSyujyututekiyoukkanfrom
            , pSyujyututekiyoukkanto);
    }


    @Override
    public List<JT_MisyuupRendo> getAllMisyuupRendo() {
        return seikyuuDomManager.getAllMisyuupRendo();
    }


    @Override
    public JT_MisyuupRendo getMisyuupRendo(String pSyono, Integer pDatarenno) {
        return seikyuuDomManager.getMisyuupRendo(pSyono, pDatarenno);
    }


    @Override
    public List<JT_SiDenpyoData> getAllSiDenpyoData() {
        return seikyuuDomManager.getAllSiDenpyoData();
    }


    @Override
    public JT_SiDenpyoData getSiDenpyoData(String pDenrenno, Integer pEdano) {
        return seikyuuDomManager.getSiDenpyoData(pDenrenno, pEdano);
    }


    @Override
    public List<JT_SiDenpyoData> getSiDenpyoDatasBySyonoSyoriYmdSyoricd(String pSyono, BizDate pSyoriYmd, String pSyoricd) {
        return seikyuuDomManager.getSiDenpyoDatasBySyonoSyoriYmdSyoricd(pSyono, pSyoriYmd, pSyoricd);
    }


    @Override
    public ExDBUpdatableResults<JT_SiDenpyoData> getSiDenpyoDatasByKakutyoujobcdSyoriYmd(String pKakutyoujobcd, BizDate pSyoriYmd) {
        return seikyuuDomManager.getSiDenpyoDatasByKakutyoujobcdSyoriYmd(pKakutyoujobcd, pSyoriYmd);
    }


    @Override
    public List<JT_SiFBSoukinData> getAllSiFBSoukinData() {
        return seikyuuDomManager.getAllSiFBSoukinData();
    }


    @Override
    public List<JT_SiFBSoukinData> getSiFBSoukinDatasBySyonoSyoriYmdSyoricd(String pSyono, BizDate pSyoriYmd, String pSyoricd) {
        return seikyuuDomManager.getSiFBSoukinDatasBySyonoSyoriYmdSyoricd(pSyono, pSyoriYmd, pSyoricd);
    }


    @Override
    public ExDBResults<JT_SiFBSoukinData> getSiFBSoukinDatasByKakutyoujobcdSyoriYmd(String pKakutyoujobcd, BizDate pSyoriYmd) {
        return seikyuuDomManager.getSiFBSoukinDatasByKakutyoujobcdSyoriYmd(pKakutyoujobcd, pSyoriYmd);
    }


    @Override
    public JT_SiFBSoukinData getSiFBSoukinData(String pFbsoukindatasikibetukey) {
        return seikyuuDomManager.getSiFBSoukinData(pFbsoukindatasikibetukey);
    }


    @Override
    public List<JT_SiGaikaFBSoukinData> getAllSiGaikaFBSoukinData() {
        return seikyuuDomManager.getAllSiGaikaFBSoukinData();
    }


    @Override
    public List<JT_SiGaikaFBSoukinData> getSiGaikaFBSoukinDatasBySyonoSyoriYmdSyoricd(String pSyono, BizDate pSyoriYmd, String pSyoricd) {
        return seikyuuDomManager.getSiGaikaFBSoukinDatasBySyonoSyoriYmdSyoricd(pSyono, pSyoriYmd, pSyoricd);
    }


    @Override
    public JT_SiGaikaFBSoukinData getSiGaikaFBSoukinData(String pFbsoukindatasikibetukey) {
        return seikyuuDomManager.getSiGaikaFBSoukinData(pFbsoukindatasikibetukey);
    }


    @Override
    public ExDBResults<JT_SiGaikaFBSoukinData> getSiGaikaFBSoukinDatasByKakutyoujobcdSyoriYmd(String pKakutyoujobcd, BizDate pSyoriYmd) {
        return seikyuuDomManager.getSiGaikaFBSoukinDatasByKakutyoujobcdSyoriYmd(pKakutyoujobcd, pSyoriYmd);
    }


    @Override
    public List<JT_SiKekka> getAllSiKekka() {
        return seikyuuDomManager.getAllSiKekka();
    }


    @Override
    public JT_SiKekka getSiKekka(C_ShiharaikekkadataKbn pShiharaikekkadatakbn, String pSyono, String pSyouhncd, Integer pSyouhnsdno, Integer pKyksyouhnrenno
        , C_SyutkKbn pSyutkkbn) {
        return seikyuuDomManager.getSiKekka(pShiharaikekkadatakbn, pSyono, pSyouhncd, pSyouhnsdno, pKyksyouhnrenno
            , pSyutkkbn);
    }


    @Override
    public ExDBResults<JT_SiKekka> getSiKekkasByKakutyoujobcd(String pKakutyoujobcd) {
        return seikyuuDomManager.getSiKekkasByKakutyoujobcd(pKakutyoujobcd);
    }


    @Override
    public ExDBResults<JT_SiKekka> getSiKekkasByKakutyoujobcdSyoriYmd(String pKakutyoujobcd, BizDate pSyoriYmd) {
        return seikyuuDomManager.getSiKekkasByKakutyoujobcdSyoriYmd(pKakutyoujobcd, pSyoriYmd);
    }


    @Override
    public List<JT_SiKekka> getSiKekkasBySyono(String pSyono) {
        return seikyuuDomManager.getSiKekkasBySyono(pSyono);
    }


    @Override
    public List<JT_SiKekka> getSiKekkasBySyonoSyoumetujiyuuNe(String pSyono, C_Syoumetujiyuu  pSyoumetujiyuu) {
        return seikyuuDomManager.getSiKekkasBySyonoSyoumetujiyuuNe(pSyono, pSyoumetujiyuu);
    }


    @Override
    public List<JT_SiTyousyo> getAllSiTyousyo() {
        return seikyuuDomManager.getAllSiTyousyo();
    }


    @Override
    public JT_SiTyousyo getSiTyousyo(String pSyono, BizDate pTyouhyouymd, Long pShrtysyrenno) {
        return seikyuuDomManager.getSiTyousyo(pSyono, pTyouhyouymd, pShrtysyrenno);
    }


    @Override
    public List<JT_SkKihon> getSkKihonsBySyonoSibouKariuketsuke(String pSyono) {
        return seikyuuDomManager.getSkKihonsBySyonoSibouKariuketsuke(pSyono);
    }


    @Override
    public String getTtdkRirekiMaxTtdkrrkskbtkeyBySknoSyono(String pSkno, String pSyono) {
        return seikyuuDomManager.getTtdkRirekiMaxTtdkrrkskbtkeyBySknoSyono(pSkno, pSyono);
    }


    @Override
    public ExDBResults<JT_TtdkRireki> getTtdkRirekisBySyoriYmdKossyorisscdSyorikekkakbnMaxTtdkrrkskbtkey(BizDate pSyoriYmd, String pKossyorisscd) {
        return seikyuuDomManager.getTtdkRirekisBySyoriYmdKossyorisscdSyorikekkakbnMaxTtdkrrkskbtkey(pSyoriYmd, pKossyorisscd);
    }


    @Override
    public JT_TtdkRireki getTtdkRirekisBySknoSyonoSyorikekkakbnKossyorisscds(String pSkno, String pSyono, C_SyorikekkaKbn pSyorikekkakbn, String[] pKossyorisscd) {
        return seikyuuDomManager.getTtdkRirekisBySknoSyonoSyorikekkakbnKossyorisscds(pSkno, pSyono, pSyorikekkakbn, pKossyorisscd);
    }


    @Override
    public JT_TtdkRireki getTtdkRirekisBySknoSyonoSyorikekkakbnsKossyorisscds(String pSkno, String pSyono, String[] pKossyorisscd, C_SyorikekkaKbn... pSyorikekkakbn) {
        return seikyuuDomManager.getTtdkRirekisBySknoSyonoSyorikekkakbnsKossyorisscds(pSkno, pSyono, pKossyorisscd, pSyorikekkakbn);
    }


    @Override
    public ExDBResults<JT_SateiSyouninRireki>  getSateiSyouninRirekisBySyorikekkakbnSyoriYmdKossyorisscds(C_SyorikekkaKbn pSyorikekkakbn, BizDate pSyoriYmdFrom, BizDate pSyoriYmdTo, String[] pKossyorisscd) {
        return seikyuuDomManager.getSateiSyouninRirekisBySyorikekkakbnSyoriYmdKossyorisscds(pSyorikekkakbn, pSyoriYmdFrom, pSyoriYmdTo, pKossyorisscd);
    }


    @Override
    public ExDBResults<JT_SateiSyouninRireki> getSaishigaitoulistsBySyorikekkakbnItems(C_SyorikekkaKbn pSyorikekkakbn, String[] pKossyorisscd, BizDate pSyoriYmdFrom, BizDate pSyoriYmdTo, C_SaigaiHigaitouKbn pSaigaihigaitoukbn) {
        return seikyuuDomManager.getSaishigaitoulistsBySyorikekkakbnItems(pSyorikekkakbn, pKossyorisscd, pSyoriYmdFrom, pSyoriYmdTo, pSaigaihigaitoukbn);
    }


    @Override
    public String getSateiSyouninRirekiMaxSateisyouninskbtkeyBySknoSyono(String pSkno, String pSyono) {
        return seikyuuDomManager.getSateiSyouninRirekiMaxSateisyouninskbtkeyBySknoSyono(pSkno, pSyono);
    }


    @Override
    public ExDBResults<SibouKariuketsukeInfosBySeikyuusyubetuSiboukaritrkymdTorikesiflgBean> getSibouKariuketsukeInfosBySeikyuusyubetuSiboukaritrkymdTorikesiflg(BizDate pTaisyoukknfrom, BizDate pTaisyoukknto) {
        return seikyuuDomManager.getSibouKariuketsukeInfosBySeikyuusyubetuSiboukaritrkymdTorikesiflg(pTaisyoukknfrom, pTaisyoukknto);
    }


    @Override
    public List<JT_SkKihon> getSkKihonsBySyonoTorikesiflg(String pSyono, C_UmuKbn pTorikesiflg) {
        return seikyuuDomManager.getSkKihonsBySyonoTorikesiflg(pSyono, pTorikesiflg);
    }


    @Override
    public List<SiDetailInfosBySknoSyonoSeikyuurirekinoBean> getSiDetailInfosBySknoSyonoSeikyuurirekino(String pSkno, String pSyono, Integer pSeikyuurirekino) {
        return seikyuuDomManager.getSiDetailInfosBySknoSyonoSeikyuurirekino(pSkno, pSyono, pSeikyuurirekino);
    }


    @Override
    public ExDBResults<JT_SkKihon> getSkKihonsByKakutyoujobcdGaibuinsatuoutymd(String pKakutyoujobcd, BizDate pGaibuinsatuoutymd) {
        return seikyuuDomManager.getSkKihonsByKakutyoujobcdGaibuinsatuoutymd(pKakutyoujobcd, pGaibuinsatuoutymd);
    }


    @Override
    public List<JT_SiDetail> getSiDetailsBySknoSyonoSeikyuurirekino(String pSkno, String pSyono, Integer pSeikyuurirekino) {
        return seikyuuDomManager.getSiDetailsBySknoSyonoSeikyuurirekino(pSkno, pSyono, pSeikyuurirekino);
    }


    @Override
    public ExDBResults<JT_SiRireki> getSiRirekisByShrkekkakbnTyakkinymdFromTyakkinymdTo(C_ShrKekkaKbn pShrkekkakbn, BizDate pTyakkinymdFrom, BizDate pTyakkinymdTo) {
        return seikyuuDomManager.getSiRirekisByShrkekkakbnTyakkinymdFromTyakkinymdTo(pShrkekkakbn, pTyakkinymdFrom, pTyakkinymdTo);
    }


    @Override
    public Long getSibouKariuketsukeCountBySyono(String pSyono) {
        return seikyuuDomManager.getSibouKariuketsukeCountBySyono(pSyono);
    }


    @Override
    public List<JT_SiDshrTuki> getAllSiDshrTuki() {
        return seikyuuDomManager.getAllSiDshrTuki();
    }


    @Override
    public JT_SiDshrTuki getSiDshrTuki(String pDshrtoukeisikibetukey) {
        return seikyuuDomManager.getSiDshrTuki(pDshrtoukeisikibetukey);
    }


    @Override
    public JT_SiDshrTuki getSiDshrTukiBySyonoSknoRirekino(String pSyono, String pSkno, Integer pSeikyuurirekino) {
        return seikyuuDomManager.getSiDshrTukiBySyonoSknoRirekino(pSyono, pSkno, pSeikyuurirekino);
    }



    @Override
    public List<JT_SiHubi> getAllSiHubi() {
        return hubiDomManager.getAllSiHubi();
    }


    @Override
    public JT_SiHubi getSiHubi(String pHubisikibetukey) {
        return hubiDomManager.getSiHubi(pHubisikibetukey);
    }


    @Override
    public JT_SiHubi getSiHubiByHubisikibetukeyHasinymd(String pHubisikibetukey, BizDate pHasinymd) {
        return hubiDomManager.getSiHubiByHubisikibetukeyHasinymd(pHubisikibetukey, pHasinymd);
    }


    @Override
    public List<JT_SiHubi> getSiHubisBySyono(String pSyono) {
        return hubiDomManager.getSiHubisBySyono(pSyono);
    }


    @Override
    public List<SiHubisSiHubiDetailsBySyonoBean> getSiHubisSiHubiDetailsBySyono(String pSyono) {
        return hubiDomManager.getSiHubisSiHubiDetailsBySyono(pSyono);
    }


    @Override
    public ExDBResults<HubiTourokuInfosByHasinymdBean> getHubiTourokuInfosByHasinymd(BizDate pHasinymd) {
        return hubiDomManager.getHubiTourokuInfosByHasinymd(pHasinymd);
    }


    @Override
    public Integer getSiHubiDetailMaxRenno3ketaByHubisikibetukeyHasinymd(String pHubisikibetukey) {
        return hubiDomManager.getSiHubiDetailMaxRenno3ketaByHubisikibetukeyHasinymd(pHubisikibetukey);
    }



    @Override
    public List<JT_SiSentakuInfoTouroku> getAllSiSentakuInfoTouroku() {
        return etcDomManager.getAllSiSentakuInfoTouroku();
    }


    @Override
    public JT_SiSentakuInfoTouroku getSiSentakuInfoTouroku(String pSyono, Integer pRenno) {
        return etcDomManager.getSiSentakuInfoTouroku(pSyono, pRenno);
    }


    @Override
    public ExDBUpdatableResults<JT_SiSentakuInfoTouroku> getSiSentakuInfoTourokusByKakutyoujobcdSyorizumiflg(String pKakutyoujobcd, C_Syorizumiflg pSyorizumiflg) {
        return etcDomManager.getSiSentakuInfoTourokusByKakutyoujobcdSyorizumiflg(pKakutyoujobcd, pSyorizumiflg);
    }


    @Override
    public List<JT_SinsaTyuui> getAllSinsaTyuui() {
        return etcDomManager.getAllSinsaTyuui();
    }


    @Override
    public JT_SinsaTyuui getSinsaTyuui(String pSyono) {
        return etcDomManager.getSinsaTyuui(pSyono);
    }


    @Override
    public List<JM_SiTyouhyoumsg> getAllSiTyouhyoumsg() {
        return etcDomManager.getAllSiTyouhyoumsg();
    }


    @Override
    public JM_SiTyouhyoumsg getSiTyouhyoumsg(String pBunrui1, String pBunrui2, Integer pTyouhyoulineno) {
        return etcDomManager.getSiTyouhyoumsg(pBunrui1, pBunrui2, pTyouhyoulineno);
    }


    @Override
    public List<JM_SiTyouhyoumsg> getSiTyouhyoumsgsByBunrui1Bunrui2(String pBunrui1, String pBunrui2) {
        return etcDomManager.getSiTyouhyoumsgsByBunrui1Bunrui2(pBunrui1, pBunrui2);
    }


    @Override
    public List<JM_SkNaiyouChk> getAllSkNaiyouChk() {
        return etcDomManager.getAllSkNaiyouChk();
    }


    @Override
    public JM_SkNaiyouChk getSkNaiyouChk(C_SKNaiyouChkKbn pSknaiyouchkkbn, C_YobidasimotoTaskKbn pYobidasimototaskkbn) {
        return etcDomManager.getSkNaiyouChk(pSknaiyouchkkbn, pYobidasimototaskkbn);
    }


    @Override
    public List<JT_AksrendouzumiSyoruiImg> getAllAksrendouzumiSyoruiImg() {
        return etcDomManager.getAllAksrendouzumiSyoruiImg();
    }


    @Override
    public JT_AksrendouzumiSyoruiImg getAksrendouzumiSyoruiImg(String pSkno, String pSyono, String pImageid) {
        return etcDomManager.getAksrendouzumiSyoruiImg(pSkno, pSyono, pImageid);
    }


    @Override
    public List<JT_AksrendouzumiSkKykInfo> getAllAksrendouzumiSkKykInfo() {
        return etcDomManager.getAllAksrendouzumiSkKykInfo();
    }


    @Override
    public JT_AksrendouzumiSkKykInfo getAksrendouzumiSkKykInfo(String pSkno, String pSyono) {
        return etcDomManager.getAksrendouzumiSkKykInfo(pSkno, pSyono);
    }


    @Override
    public List<JT_SiJinsokuShrTtdkInfo> getAllSiJinsokuShrTtdkInfo() {
        return etcDomManager.getAllSiJinsokuShrTtdkInfo();
    }


    @Override
    public JT_SiJinsokuShrTtdkInfo getSiJinsokuShrTtdkInfo(String pSyorisosikicd, String pSyoricd, String pHknknshrsntkno, BizDate pSyoruiukeymd, BizDate pSyoriYmd
        , BizDate pDenymd, String pSyono) {
        return etcDomManager.getSiJinsokuShrTtdkInfo(pSyorisosikicd, pSyoricd, pHknknshrsntkno, pSyoruiukeymd, pSyoriYmd
            , pDenymd, pSyono);
    }


    @Override
    public ExDBResults<JT_SiJinsokuShrTtdkInfo> getSiJinsokuShrTtdkInfosBySyoriYmd(BizDate pSyoriYmdFrom, BizDate pSyoriYmdTo) {
        return etcDomManager.getSiJinsokuShrTtdkInfosBySyoriYmd(pSyoriYmdFrom, pSyoriYmdTo);
    }


    @Override
    public List<JM_SiinHantei> getAllSiinHantei() {
        return etcDomManager.getAllSiinHantei();
    }


    @Override
    public JM_SiinHantei getSiinHantei(C_GeninKbn pSiboukariuketukejigeninkbn, C_GeninKbn pSeikyuuuketukejigeninkbn, C_UmuKbn pKansensyouumukbn
        , C_UmuKbn pSaigaikanouseiumukbn, C_UmuKbn pHusyounosiumukbn, C_UmuKbn pSateikaksaigaikanouseikbn, C_UmuKbn pSateikakhusyousikbn) {
        return etcDomManager.getSiinHantei(pSiboukariuketukejigeninkbn, pSeikyuuuketukejigeninkbn, pKansensyouumukbn
            , pSaigaikanouseiumukbn, pHusyounosiumukbn, pSateikaksaigaikanouseikbn, pSateikakhusyousikbn);
    }


    @Override
    public List<JM_SiHubiNaiyou> getAllSiHubiNaiyou() {
        return etcDomManager.getAllSiHubiNaiyou();
    }


    @Override
    public List<JM_SiHubiNaiyou> getSiHubiNaiyousByJimutetuzukicdSyoruiCd(String pJimutetuzukicd, C_SyoruiCdKbn pSyoruiCd) {
        return etcDomManager.getSiHubiNaiyousByJimutetuzukicdSyoruiCd(pJimutetuzukicd, pSyoruiCd);
    }


    @Override
    public JM_SiHubiNaiyou getSiHubiNaiyou(String pJimutetuzukicd, C_SyoruiCdKbn pSyoruiCd, String pHubinaiyoucd) {
        return etcDomManager.getSiHubiNaiyou(pJimutetuzukicd, pSyoruiCd, pHubinaiyoucd);
    }


    @Override
    public List<JT_SiBikinkanri> getAllSiBikinkanri() {
        return etcDomManager.getAllSiBikinkanri();
    }


    @Override
    public JT_SiBikinkanri getSiBikinkanri(String pSkno, String pSyono, BizDate pKessankijyunymd, C_BkncdKbn pBkncdkbn, BizDate pBknkktymd, String pKyuuhucd) {
        return etcDomManager.getSiBikinkanri(pSkno, pSyono, pKessankijyunymd, pBkncdkbn, pBknkktymd, pKyuuhucd);
    }


    @Override
    public ExDBResults<JT_SiBikinkanri> getSiBikinkanrisByKakutyoujobcdItemsOrderBy4Items(String pKakutyoujobcd, BizDate pKessankijyunymd, C_BknrigiKbn pBknrigikbn) {
        return etcDomManager.getSiBikinkanrisByKakutyoujobcdItemsOrderBy4Items(pKakutyoujobcd, pKessankijyunymd, pBknrigikbn);
    }


    @Override
    public List<SiBikinkanriItemsBySyonoBean> getSiBikinkanriItemsBySyono(String pSyono) {
        return etcDomManager.getSiBikinkanriItemsBySyono(pSyono);
    }


    @Override
    public ExDBResults<JT_SiBikinkanri> getSiBikinkanrisByKakutyoujobcdItems(String pKakutyoujobcd, BizDate pKessankijyunymd, C_BknrigiKbn pBknrigikbn) {
        return etcDomManager.getSiBikinkanrisByKakutyoujobcdItems(pKakutyoujobcd, pKessankijyunymd, pBknrigikbn);
    }


    @Override
    public List<JT_SiBikinkanri> getSiBikinkanrisBySyono(String pSyono) {
        return etcDomManager.getSiBikinkanrisBySyono(pSyono);
    }


    @Override
    public List<JT_SiBikinkanri> getSiBikinkanrisBySyonoBknjkukbn(String pSyono) {
        return etcDomManager.getSiBikinkanrisBySyonoBknjkukbn(pSyono);
    }


    @Override
    public List<JT_SiBikinkanri> getSiBikinkanrisBySyonoSkno(String pSyono, String pSkno) {
        return etcDomManager.getSiBikinkanrisBySyonoSkno(pSyono, pSkno);
    }


    @Override
    public ExDBResults<JT_SiBikinkanri>  getSiBikinkanrisByBknkktymdCalckijyunymdKessankijyunymd(BizDate pBknkktymd, BizDate pCalckijyunymd, BizDate pKessankijyunymd) {
        return etcDomManager.getSiBikinkanrisByBknkktymdCalckijyunymdKessankijyunymd(pBknkktymd, pCalckijyunymd, pKessankijyunymd);
    }


    @Override
    public ExDBResults<JT_SiBikinkanri>  getSiBikinkanrisByBknkktymdItems(BizDate pBknkktymd, BizDate pCalckijyunymd, BizDate pKessankijyunymd, C_BknrigiKbn pBknrigikbn) {
        return etcDomManager.getSiBikinkanrisByBknkktymdItems(pBknkktymd, pCalckijyunymd, pKessankijyunymd, pBknrigikbn);
    }


    @Override
    public List<JT_SiBikinkanri> getSiBikinkanrisByKessankijyunymdBknrigikbn(BizDate pKessankijyunymd, C_BknrigiKbn pBknrigikbn) {
        return etcDomManager.getSiBikinkanrisByKessankijyunymdBknrigikbn(pKessankijyunymd, pBknrigikbn);
    }


    @Override
    public List<JT_SiBikinkanri> getSiBikinkanrisByKessankijyunymdBknrigikbnNe(BizDate pKessankijyunymd, C_BknrigiKbn pBknrigikbn) {
        return etcDomManager.getSiBikinkanrisByKessankijyunymdBknrigikbnNe(pKessankijyunymd, pBknrigikbn);
    }


    @Override
    public  List<JT_SiBikinkanri> getSiBikinkanrisBySknoSyonoKessankijyunymdBkncdkbn(String pSkno, String pSyono, BizDate pKessankijyunymd, C_BkncdKbn pBkncdkbn) {
        return etcDomManager.getSiBikinkanrisBySknoSyonoKessankijyunymdBkncdkbn(pSkno, pSyono, pKessankijyunymd, pBkncdkbn);
    }


    @Override
    public List<JT_SiBikinkanri> getSiBikinkanrisBySyonoKessankijyunymdBkncdkbns(String pSyono, BizDate pKessankijyunymd, C_BkncdKbn... pBkncdkbn) {
        return etcDomManager.getSiBikinkanrisBySyonoKessankijyunymdBkncdkbns(pSyono, pKessankijyunymd, pBkncdkbn);
    }


    @Override
    public ExDBResults<JT_SiBikinkanri> getSiBikinkanrisByKessankijyunymdBknrigikbnEx(BizDate pKessankijyunymd, C_BknrigiKbn pBknrigikbn) {
        return etcDomManager.getSiBikinkanrisByKessankijyunymdBknrigikbnEx(pKessankijyunymd, pBknrigikbn);
    }


    @Override
    public List<JT_SiBikinkanri> getSiBikinkanrisBySyonoKessankijyunymdBkncdkbn(String pSyono, BizDate pKessankijyunymd) {
        return etcDomManager.getSiBikinkanrisBySyonoKessankijyunymdBkncdkbn(pSyono, pKessankijyunymd);
    }


    @Override
    public List<JM_JyudkaigomebrtkWrbkkkn> getAllJyudkaigomebrtkWrbkkkn() {
        return etcDomManager.getAllJyudkaigomebrtkWrbkkkn();
    }


    @Override
    public JM_JyudkaigomebrtkWrbkkkn getJyudkaigomebrtkWrbkkkn(Integer pHhknnen, C_Seibetu pSeibetu) {
        return etcDomManager.getJyudkaigomebrtkWrbkkkn(pHhknnen, pSeibetu);
    }


    @Override
    public ExDBResults<JT_SiBikinkanri> getSiBikinkanrisByKessankijyunymdBknrigikbnOrderByBkntyousafsyorikbnSyono(BizDate pKessankijyunymd, C_BknrigiKbn pBknrigikbn) {
        return etcDomManager.getSiBikinkanrisByKessankijyunymdBknrigikbnOrderByBkntyousafsyorikbnSyono(pKessankijyunymd, pBknrigikbn);
    }


    @Override
    public ExDBResults<JT_SiBikinkanri> getSiBikinkanrisByZennouseisankin(BizDate pKessankijyunymd, C_UmuKbn pZennouseisankinumukbn, C_ShrKekkaKbn pShrkekkakbn, C_BknrigiKbn pBknrigikbn) {
        return etcDomManager.getSiBikinkanrisByZennouseisankin(pKessankijyunymd, pZennouseisankinumukbn, pShrkekkakbn, pBknrigikbn);
    }


    @Override
    public ExDBResults<JT_SiBikinkanri> getSiBikinkanrisByMikeikap(BizDate pKessankijyunymd, C_UmuKbn pMikeikapumukbn, C_ShrKekkaKbn pShrkekkakbn, C_BknrigiKbn pBknrigikbn) {
        return etcDomManager.getSiBikinkanrisByMikeikap(pKessankijyunymd, pMikeikapumukbn, pShrkekkakbn, pBknrigikbn);
    }


    @Override
    public ExDBResults<JT_SiBikinkanri> getSiBikinkanrisByMisyup(BizDate pKessankijyunymd, C_UmuKbn pMisyuupumukbn, C_ShrKekkaKbn pShrkekkakbn, C_BknrigiKbn pBknrigikbn) {
        return etcDomManager.getSiBikinkanrisByMisyup(pKessankijyunymd, pMisyuupumukbn, pShrkekkakbn, pBknrigikbn);
    }


    @Override
    public ExDBResults<JT_SiBikinkanri> getSiBikinkanrisByKsnYmdBknJkuKbnBknrigikbnEx(BizDate pKessankijyunymd,C_BknJkuKbn pBknJkuKbn,C_BknrigiKbn pBknrigiKbn) {
        return etcDomManager.getSiBikinkanrisByKsnYmdBknJkuKbnBknrigikbnEx(pKessankijyunymd, pBknJkuKbn, pBknrigiKbn);
    }


    @Override
    public List<JT_SiBikinkanri> getSiBikinkanrisBySyonoKsnYmdJkukbnRigikbnNe(String pSyono, BizDate pKessankijyunymd,
        C_BknJkuKbn pBknJkuKbn, C_BknrigiKbn pBknrigiKbn) {
        return etcDomManager.getSiBikinkanrisBySyonoKsnYmdJkukbnRigikbnNe(pSyono, pKessankijyunymd, pBknJkuKbn, pBknrigiKbn);
    }


    @Override
    public List<JM_ChkSiJimuttdk> getAllChkSiJimuttdk() {
        return etcDomManager.getAllChkSiJimuttdk();
    }


    @Override
    public JM_ChkSiJimuttdk getChkSiJimuttdk(String pKinouId, String pSyorijimuttdkcd) {
        return etcDomManager.getChkSiJimuttdk(pKinouId, pSyorijimuttdkcd);
    }



    @Override
    public List<JW_HubiWk> getAllHubiWk() {
        return wkDomManager.getAllHubiWk();
    }


    @Override
    public JW_HubiWk getHubiWk(String pKouteikanriid) {
        return wkDomManager.getHubiWk(pKouteikanriid);
    }


    @Override
    public List<JW_HubiKaisyouDetailWk> getAllHubiKaisyouDetailWk() {
        return wkDomManager.getAllHubiKaisyouDetailWk();
    }


    @Override
    public JW_HubiKaisyouDetailWk getHubiKaisyouDetailWk(String pKouteikanriid, Integer pRenno3keta) {
        return wkDomManager.getHubiKaisyouDetailWk(pKouteikanriid, pRenno3keta);
    }


    @Override
    public List<JW_HubiKaisyouDetailWk> getHubiKaisyouDetailWksByKouteikanriid(String pKouteikanriid) {
        return wkDomManager.getHubiKaisyouDetailWksByKouteikanriid(pKouteikanriid);
    }


    @Override
    public JM_SiSyouhnZokusei getSiSyouhnZokuseisBySyouhncd(String pSyouhncd) {
        return keiyakuDomManager.getSiSyouhnZokuseisBySyouhncd(pSyouhncd);
    }

}
