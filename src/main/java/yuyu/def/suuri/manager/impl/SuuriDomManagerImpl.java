package yuyu.def.suuri.manager.impl;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.base.manager.AbstractDomManager;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_NaibuKeiyakuKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TekiyouKbn;
import yuyu.def.db.entity.ST_BknkykHtjynbkn;
import yuyu.def.db.entity.ST_ConvertKanjyouKamoku;
import yuyu.def.db.entity.ST_DshrTukiTyukeiyouItzHzn;
import yuyu.def.db.entity.ST_HoyuuMeisaiTyukeiyouItzHzn;
import yuyu.def.db.entity.ST_IdouMeisaiTyukeiyouItzHzn;
import yuyu.def.db.entity.ST_SkKessanSyukei;
import yuyu.def.db.entity.ST_SkOikmKaikei;
import yuyu.def.db.entity.ST_SkOikmSyukeiPDenpyou;
import yuyu.def.db.entity.ST_SkOikmTyouseiDenpyou;
import yuyu.def.db.entity.ST_SuuriyouErrJyouhou;
import yuyu.def.db.entity.ST_SynypTukiTugtTykiyuHozon;
import yuyu.def.db.entity.ST_SynypTukiYkgtIkouHozon;
import yuyu.def.db.entity.ST_YuukoukykHtjynbknKarid;
import yuyu.def.db.entity.ST_YuukoukykHtjynbknTmttd;
import yuyu.def.db.entity.SV_BikinIdouMeisai;
import yuyu.def.db.entity.SV_HoyuuMeisai;
import yuyu.def.db.entity.SV_IdouMeisai;
import yuyu.def.db.entity.SV_KiykHnriknSutugk;
import yuyu.def.db.entity.SV_KiykSyuhnData;
import yuyu.def.db.entity.SV_RisanomiTuujyuHitusyyugk;
import yuyu.def.db.entity.SV_SibourituRendou;
import yuyu.def.db.entity.SV_SibourituToukeiSeibigo;
import yuyu.def.db.entity.SV_SnkiykGtjSirt;
import yuyu.def.db.entity.SV_SnkiykSyunyup;
import yuyu.def.db.entity.SV_Sp2RnduyuSouseiritu;
import yuyu.def.db.entity.SV_TuujyuHitusyyugk;
import yuyu.def.suuri.manager.SuuriDomManager;
import yuyu.def.suuri.result.bean.SkOikmKaikeiTyouseiDensByDenymdSyoriYmdBean;
import yuyu.def.suuri.result.bean.SkOikmTyouseiDenpyouHkrDnpsBean;
import yuyu.def.suuri.result.bean.SkOikmTyouseiDenpyouInfosBean;


/**
 * 数理統計 DOM マネージャ 実装クラス<br />
 * {@link SuuriDomManager}で宣言したメソッドを実装します。<br />
 * カテゴリDomマネージャを業務機能から隠蔽するために、抽象クラスと実装クラスに分離して、<br />
 * 業務機能からは見えない実装クラスで、カテゴリDomマネージャを使用しています。 <br />
 */
public class SuuriDomManagerImpl extends AbstractDomManager implements SuuriDomManager {


    @Inject
    private KessanDomManager kessanDomManager;


    @Inject
    private ViewDomManager viewDomManager;



    @Override
    public List<ST_SkOikmTyouseiDenpyou> getAllSkOikmTyouseiDenpyou() {
        return kessanDomManager.getAllSkOikmTyouseiDenpyou();
    }


    @Override
    public ST_SkOikmTyouseiDenpyou getSkOikmTyouseiDenpyou(String pMosno, C_Kanjyoukmkcd pKanjyoukmkcd, C_TaisyakuKbn  pTaisyakukbn, C_NaibuKeiyakuKbn pNaibukeiyakukbn
        , C_TekiyouKbn pTekiyoukbn, C_Segcd pSeg1cd) {
        return kessanDomManager.getSkOikmTyouseiDenpyou(pMosno, pKanjyoukmkcd, pTaisyakukbn, pNaibukeiyakukbn
            , pTekiyoukbn, pSeg1cd);
    }


    @Override
    public ExDBResults<ST_SkOikmTyouseiDenpyou> getSkOikmTyouseiDenpyous() {
        return kessanDomManager.getSkOikmTyouseiDenpyous();
    }


    @Override
    public List<ST_SkOikmSyukeiPDenpyou> getAllSkOikmSyukeiPDenpyou() {
        return kessanDomManager.getAllSkOikmSyukeiPDenpyou();
    }


    @Override
    public ST_SkOikmSyukeiPDenpyou getSkOikmSyukeiPDenpyou(C_DensysKbn pDensyskbn, String pDenrenno, Integer pEdano) {
        return kessanDomManager.getSkOikmSyukeiPDenpyou(pDensyskbn, pDenrenno, pEdano);
    }


    @Override
    public ExDBResults<SkOikmTyouseiDenpyouHkrDnpsBean> getSkOikmTyouseiDenpyouHkrDnps() {
        return kessanDomManager.getSkOikmTyouseiDenpyouHkrDnps();
    }


    @Override
    public List<ST_SkOikmKaikei> getAllSkOikmKaikei() {
        return kessanDomManager.getAllSkOikmKaikei();
    }


    @Override
    public ST_SkOikmKaikei getSkOikmKaikei(C_DensysKbn pDensyskbn, String pDenrenno, Integer pEdano) {
        return kessanDomManager.getSkOikmKaikei(pDensyskbn, pDenrenno, pEdano);
    }


    @Override
    public ExDBResults<SkOikmKaikeiTyouseiDensByDenymdSyoriYmdBean> getSkOikmKaikeiTyouseiDensByDenymdSyoriYmd(BizDate pDenymd, BizDate pSyoriYmd) {
        return kessanDomManager.getSkOikmKaikeiTyouseiDensByDenymdSyoriYmd(pDenymd, pSyoriYmd);
    }


    @Override
    public ExDBResults<ST_SkOikmKaikei> getSkOikmKaikeisByDensyorikbnDenymdSyoriYmd(BizDate pDenymd, BizDate pSyoriYmd) {
        return kessanDomManager.getSkOikmKaikeisByDensyorikbnDenymdSyoriYmd(pDenymd, pSyoriYmd);
    }


    @Override
    public List<ST_SkKessanSyukei> getAllSkKessanSyukei() {
        return kessanDomManager.getAllSkKessanSyukei();
    }


    @Override
    public ST_SkKessanSyukei getSkKessanSyukei(String pMosno, BizDate pSuitouymd, C_Kanjyoukmkcd pKanjyoukmkcd, C_TaisyakuKbn pTaisyakukbn, C_NaibuKeiyakuKbn pNaibukeiyakukbn
        , C_TekiyouKbn pTekiyoukbn, C_Segcd pSeg1cd) {
        return kessanDomManager.getSkKessanSyukei(pMosno, pSuitouymd, pKanjyoukmkcd, pTaisyakukbn, pNaibukeiyakukbn
            , pTekiyoukbn, pSeg1cd);
    }


    @Override
    public List<ST_SkKessanSyukei> getSkKessanSyukeisByDenymd(BizDate pDenymd) {
        return kessanDomManager.getSkKessanSyukeisByDenymd(pDenymd);
    }


    @Override
    public List<ST_SkKessanSyukei> getSkKessanSyukeisBySeg1cdDenymd(BizDate pDenymd) {
        return kessanDomManager.getSkKessanSyukeisBySeg1cdDenymd(pDenymd);
    }


    @Override
    public List<ST_SkKessanSyukei> getSkKessanSyukeisKanjyouKamokuTantouCdByDenymd(BizDate pDenymd) {
        return kessanDomManager.getSkKessanSyukeisKanjyouKamokuTantouCdByDenymd(pDenymd);
    }


    @Override
    public List<ST_ConvertKanjyouKamoku> getAllConvertKanjyouKamoku() {
        return kessanDomManager.getAllConvertKanjyouKamoku();
    }


    @Override
    public ST_ConvertKanjyouKamoku getConvertKanjyouKamoku(C_Kanjyoukmkcd pKanjyoukmkcd, C_TaisyakuKbn pTaisyakukbn) {
        return kessanDomManager.getConvertKanjyouKamoku(pKanjyoukmkcd, pTaisyakukbn);
    }


    @Override
    public ExDBResults<SkOikmTyouseiDenpyouInfosBean> getSkOikmTyouseiDenpyouInfos() {
        return kessanDomManager.getSkOikmTyouseiDenpyouInfos();
    }


    @Override
    public List<ST_SuuriyouErrJyouhou> getAllSuuriyouErrJyouhou() {
        return kessanDomManager.getAllSuuriyouErrJyouhou();
    }


    @Override
    public ST_SuuriyouErrJyouhou getSuuriyouErrJyouhou(BizDate pSyoriYmd, String pKakutyoujobcd, String pSyono, String pGyoumuKousinTime, String pSuuritoukeiyouerrnaiyou) {
        return kessanDomManager.getSuuriyouErrJyouhou(pSyoriYmd, pKakutyoujobcd, pSyono, pGyoumuKousinTime, pSuuritoukeiyouerrnaiyou);
    }


    @Override
    public List<ST_HoyuuMeisaiTyukeiyouItzHzn> getAllHoyuuMeisaiTyukeiyouItzHzn() {
        return kessanDomManager.getAllHoyuuMeisaiTyukeiyouItzHzn();
    }


    @Override
    public ST_HoyuuMeisaiTyukeiyouItzHzn getHoyuuMeisaiTyukeiyouItzHzn(String pZtysrkijyunym, String pZtysrkakutyoujobcd, Integer pZtysequenceno) {
        return kessanDomManager.getHoyuuMeisaiTyukeiyouItzHzn(pZtysrkijyunym, pZtysrkakutyoujobcd, pZtysequenceno);
    }


    @Override
    public List<ST_IdouMeisaiTyukeiyouItzHzn> getAllIdouMeisaiTyukeiyouItzHzn() {
        return kessanDomManager.getAllIdouMeisaiTyukeiyouItzHzn();
    }


    @Override
    public ST_IdouMeisaiTyukeiyouItzHzn getIdouMeisaiTyukeiyouItzHzn(String pZtysrkijyunym, String pZtysrkakutyoujobcd, Integer pZtysequenceno) {
        return kessanDomManager.getIdouMeisaiTyukeiyouItzHzn(pZtysrkijyunym, pZtysrkakutyoujobcd, pZtysequenceno);
    }


    @Override
    public List<ST_SynypTukiTugtTykiyuHozon> getAllSynypTukiTugtTykiyuHozon() {
        return kessanDomManager.getAllSynypTukiTugtTykiyuHozon();
    }


    @Override
    public ST_SynypTukiTugtTykiyuHozon getSynypTukiTugtTykiyuHozon(String pZtysrkijyunym, String pZtysrkakutyoujobcd, Integer pZtysequenceno) {
        return kessanDomManager.getSynypTukiTugtTykiyuHozon(pZtysrkijyunym, pZtysrkakutyoujobcd, pZtysequenceno);
    }


    @Override
    public List<ST_SynypTukiYkgtIkouHozon> getAllSynypTukiYkgtIkouHozon() {
        return kessanDomManager.getAllSynypTukiYkgtIkouHozon();
    }


    @Override
    public ST_SynypTukiYkgtIkouHozon getSynypTukiYkgtIkouHozon(String pSrkijyunym, Integer pSequenceno, String pSyono, BizDateYM pJyutoustartym, BizDateYM pJyutouendym
        , C_TaisyakuKbn pTaisyakukbn) {
        return kessanDomManager.getSynypTukiYkgtIkouHozon(pSrkijyunym, pSequenceno, pSyono, pJyutoustartym, pJyutouendym
            , pTaisyakukbn);
    }


    @Override
    public List<ST_YuukoukykHtjynbknTmttd> getAllYuukoukykHtjynbknTmttd() {
        return kessanDomManager.getAllYuukoukykHtjynbknTmttd();
    }


    @Override
    public ST_YuukoukykHtjynbknTmttd getYuukoukykHtjynbknTmttd(BizDate pSyoriYmd, String pKakutyoujobcd, String pSyono, String pSrkijyunym) {
        return kessanDomManager.getYuukoukykHtjynbknTmttd(pSyoriYmd, pKakutyoujobcd, pSyono, pSrkijyunym);
    }


    @Override
    public List<ST_YuukoukykHtjynbknKarid> getAllYuukoukykHtjynbknKarid() {
        return kessanDomManager.getAllYuukoukykHtjynbknKarid();
    }


    @Override
    public ST_YuukoukykHtjynbknKarid getYuukoukykHtjynbknKarid(BizDate pSyoriYmd, String pKakutyoujobcd, String pSyono, String pSrkijyunym) {
        return kessanDomManager.getYuukoukykHtjynbknKarid(pSyoriYmd, pKakutyoujobcd, pSyono, pSrkijyunym);
    }


    @Override
    public List<ST_BknkykHtjynbkn> getAllBknkykHtjynbkn() {
        return kessanDomManager.getAllBknkykHtjynbkn();
    }


    @Override
    public ST_BknkykHtjynbkn getBknkykHtjynbkn(BizDate pSyoriYmd, String pKakutyoujobcd, String pSyono, String pSrkijyunym) {
        return kessanDomManager.getBknkykHtjynbkn(pSyoriYmd, pKakutyoujobcd, pSyono, pSrkijyunym);
    }


    @Override
    public List<ST_DshrTukiTyukeiyouItzHzn> getAllDshrTukiTyukeiyouItzHzn() {
        return kessanDomManager.getAllDshrTukiTyukeiyouItzHzn();
    }


    @Override
    public ST_DshrTukiTyukeiyouItzHzn getDshrTukiTyukeiyouItzHzn(Integer pZtysequenceno) {
        return kessanDomManager.getDshrTukiTyukeiyouItzHzn(pZtysequenceno);
    }



    @Override
    public List<SV_SnkiykGtjSirt> getAllSnkiykGtjSirt() {
        return viewDomManager.getAllSnkiykGtjSirt();
    }


    @Override
    public SV_SnkiykGtjSirt getSnkiykGtjSirt(String pMosno) {
        return viewDomManager.getSnkiykGtjSirt(pMosno);
    }


    @Override
    public List<SV_SnkiykSyunyup> getAllSnkiykSyunyup() {
        return viewDomManager.getAllSnkiykSyunyup();
    }


    @Override
    public SV_SnkiykSyunyup getSnkiykSyunyup(String pMosno) {
        return viewDomManager.getSnkiykSyunyup(pMosno);
    }


    @Override
    public List<SV_HoyuuMeisai> getAllHoyuuMeisai() {
        return viewDomManager.getAllHoyuuMeisai();
    }


    @Override
    public SV_HoyuuMeisai getHoyuuMeisai(String pSyono) {
        return viewDomManager.getHoyuuMeisai(pSyono);
    }


    @Override
    public List<SV_KiykHnriknSutugk> getAllKiykHnriknSutugk() {
        return viewDomManager.getAllKiykHnriknSutugk();
    }


    @Override
    public SV_KiykHnriknSutugk getKiykHnriknSutugk(String pSyono) {
        return viewDomManager.getKiykHnriknSutugk(pSyono);
    }


    @Override
    public List<SV_KiykSyuhnData> getAllKiykSyuhnData() {
        return viewDomManager.getAllKiykSyuhnData();
    }


    @Override
    public SV_KiykSyuhnData getKiykSyuhnData(String pSyono, C_SyutkKbn pSyutkkbn, String pSyouhncd, Integer pSyouhnsdno, Integer pKyksyouhnrenno, String pHenkousikibetukey) {
        return viewDomManager.getKiykSyuhnData(pSyono, pSyutkkbn, pSyouhncd, pSyouhnsdno, pKyksyouhnrenno, pHenkousikibetukey);
    }


    @Override
    public List<SV_IdouMeisai> getAllIdouMeisai() {
        return viewDomManager.getAllIdouMeisai();
    }


    @Override
    public SV_IdouMeisai getIdouMeisai(String pSyono, String pGyoumuKousinKinou, String pGyoumuKousinTime) {
        return viewDomManager.getIdouMeisai(pSyono, pGyoumuKousinKinou, pGyoumuKousinTime);
    }


    @Override
    public List<SV_BikinIdouMeisai> getAllBikinIdouMeisai() {
        return viewDomManager.getAllBikinIdouMeisai();
    }


    @Override
    public SV_BikinIdouMeisai getBikinIdouMeisai(String pSyono, String pGyoumuKousinKinou, String pGyoumuKousinTime) {
        return viewDomManager.getBikinIdouMeisai(pSyono, pGyoumuKousinKinou, pGyoumuKousinTime);
    }


    @Override
    public List<SV_SibourituToukeiSeibigo> getAllSibourituToukeiSeibigo() {
        return viewDomManager.getAllSibourituToukeiSeibigo();
    }


    @Override
    public SV_SibourituToukeiSeibigo getSibourituToukeiSeibigo(String pSyono, String pGyoumuKousinKinou, String pGyoumuKousinTime) {
        return viewDomManager.getSibourituToukeiSeibigo(pSyono, pGyoumuKousinKinou, pGyoumuKousinTime);
    }


    @Override
    public List<SV_Sp2RnduyuSouseiritu> getAllSp2RnduyuSouseiritu() {
        return viewDomManager.getAllSp2RnduyuSouseiritu();
    }


    @Override
    public SV_Sp2RnduyuSouseiritu getSp2RnduyuSouseiritu(String pMosno) {
        return viewDomManager.getSp2RnduyuSouseiritu(pMosno);
    }


    @Override
    public ExDBResults<SV_TuujyuHitusyyugk> getTuujyuHitusyyugksBySyutkkbnHaitoukbn(C_SyutkKbn pSyutkkbn, C_HaitouKbn pHaitoukbn1, String pKbnkey) {
        return viewDomManager.getTuujyuHitusyyugksBySyutkkbnHaitoukbn(pSyutkkbn, pHaitoukbn1, pKbnkey);
    }


    @Override
    public List<SV_KiykSyuhnData> getKiykSyuhnDatasBySyonoSyutkkbn(String pSyono, C_SyutkKbn pSyutkkbn) {
        return viewDomManager.getKiykSyuhnDatasBySyonoSyutkkbn(pSyono, pSyutkkbn);
    }


    @Override
    public List<BizDate> getKiykSyuhnDataKouryokuhasseiymdsBySyonoHenkousikibetukey(String pSyono, String pHenkousikibetukey) {
        return viewDomManager.getKiykSyuhnDataKouryokuhasseiymdsBySyonoHenkousikibetukey(pSyono, pHenkousikibetukey);
    }


    @Override
    public ExDBResults<SV_RisanomiTuujyuHitusyyugk> getRisanomiTuujyuHitusyyugksBySyutkkbnHaitoukbn(
        C_SyutkKbn pSyutkkbn, C_HaitouKbn pHaitoukbn, String pKbnkey) {
        return viewDomManager.getRisanomiTuujyuHitusyyugksBySyutkkbnHaitoukbn(pSyutkkbn, pHaitoukbn, pKbnkey);
    }


    @Override
    public List<SV_SibourituRendou> getAllSibourituRendou() {
        return viewDomManager.getAllSibourituRendou();
    }


    @Override
    public SV_SibourituRendou getSibourituRendou(String pMosno) {
        return viewDomManager.getSibourituRendou(pMosno);
    }


    @Override
    public List<SV_TuujyuHitusyyugk> getAllTuujyuHitusyyugk() {
        return viewDomManager.getAllTuujyuHitusyyugk();
    }


    @Override
    public SV_TuujyuHitusyyugk getTuujyuHitusyyugk(String pSyono, C_SyutkKbn pSyutkkbn, String pSyouhncd, Integer pSyouhnsdno, Integer pKyksyouhnrenno) {
        return viewDomManager.getTuujyuHitusyyugk(pSyono, pSyutkkbn, pSyouhncd, pSyouhnsdno, pKyksyouhnrenno);
    }


    @Override
    public List<SV_RisanomiTuujyuHitusyyugk> getAllRisanomiTuujyuHitusyyugk() {
        return viewDomManager.getAllRisanomiTuujyuHitusyyugk();
    }


    @Override
    public SV_RisanomiTuujyuHitusyyugk getRisanomiTuujyuHitusyyugk(String pSyono, C_SyutkKbn pSyutkkbn, String pSyouhncd, Integer pSyouhnsdno, Integer pKyksyouhnrenno) {
        return viewDomManager.getRisanomiTuujyuHitusyyugk(pSyono, pSyutkkbn, pSyouhncd, pSyouhnsdno, pKyksyouhnrenno);
    }

}
