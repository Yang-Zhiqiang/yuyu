package yuyu.def.suuri.manager;

import java.util.List;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBResults;
import yuyu.def.base.manager.DomManager;
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
import yuyu.def.suuri.result.bean.SkOikmKaikeiTyouseiDensByDenymdSyoriYmdBean;
import yuyu.def.suuri.result.bean.SkOikmTyouseiDenpyouHkrDnpsBean;
import yuyu.def.suuri.result.bean.SkOikmTyouseiDenpyouInfosBean;


/**
 * 数理統計 DOM マネージャ インターフェース<br />
 * カテゴリDomマネージャを業務機能から隠蔽するために、抽象クラスと実装クラスに分離して、<br />
 * 業務機能からは見えない実装クラスで、カテゴリDomマネージャを使用しています。 <br />
 */
public interface SuuriDomManager extends DomManager {


    List<ST_SkOikmTyouseiDenpyou> getAllSkOikmTyouseiDenpyou();


    ST_SkOikmTyouseiDenpyou getSkOikmTyouseiDenpyou(String pMosno, C_Kanjyoukmkcd pKanjyoukmkcd, C_TaisyakuKbn  pTaisyakukbn, C_NaibuKeiyakuKbn pNaibukeiyakukbn
        , C_TekiyouKbn pTekiyoukbn, C_Segcd pSeg1cd);


    ExDBResults<ST_SkOikmTyouseiDenpyou> getSkOikmTyouseiDenpyous();


    List<ST_SkOikmSyukeiPDenpyou> getAllSkOikmSyukeiPDenpyou();


    ST_SkOikmSyukeiPDenpyou getSkOikmSyukeiPDenpyou(C_DensysKbn pDensyskbn, String pDenrenno, Integer pEdano);


    ExDBResults<SkOikmTyouseiDenpyouHkrDnpsBean> getSkOikmTyouseiDenpyouHkrDnps();


    List<ST_SkOikmKaikei> getAllSkOikmKaikei();


    ST_SkOikmKaikei getSkOikmKaikei(C_DensysKbn pDensyskbn, String pDenrenno, Integer pEdano);


    ExDBResults<SkOikmKaikeiTyouseiDensByDenymdSyoriYmdBean> getSkOikmKaikeiTyouseiDensByDenymdSyoriYmd(BizDate pDenymd, BizDate pSyoriYmd);


    ExDBResults<ST_SkOikmKaikei> getSkOikmKaikeisByDensyorikbnDenymdSyoriYmd(BizDate pDenymd, BizDate pSyoriYmd);


    List<ST_SkKessanSyukei> getAllSkKessanSyukei();


    ST_SkKessanSyukei getSkKessanSyukei(String pMosno, BizDate pSuitouymd, C_Kanjyoukmkcd pKanjyoukmkcd, C_TaisyakuKbn pTaisyakukbn, C_NaibuKeiyakuKbn pNaibukeiyakukbn
        , C_TekiyouKbn pTekiyoukbn, C_Segcd pSeg1cd);


    List<ST_SkKessanSyukei> getSkKessanSyukeisByDenymd(BizDate pDenymd);


    List<ST_SkKessanSyukei> getSkKessanSyukeisBySeg1cdDenymd(BizDate pDenymd);


    List<ST_SkKessanSyukei> getSkKessanSyukeisKanjyouKamokuTantouCdByDenymd(BizDate pDenymd);


    List<ST_ConvertKanjyouKamoku> getAllConvertKanjyouKamoku();


    ST_ConvertKanjyouKamoku getConvertKanjyouKamoku(C_Kanjyoukmkcd pKanjyoukmkcd, C_TaisyakuKbn pTaisyakukbn);


    ExDBResults<SkOikmTyouseiDenpyouInfosBean> getSkOikmTyouseiDenpyouInfos();


    List<ST_SuuriyouErrJyouhou> getAllSuuriyouErrJyouhou();


    ST_SuuriyouErrJyouhou getSuuriyouErrJyouhou(BizDate pSyoriYmd, String pKakutyoujobcd, String pSyono, String pGyoumuKousinTime, String pSuuritoukeiyouerrnaiyou);


    List<ST_HoyuuMeisaiTyukeiyouItzHzn> getAllHoyuuMeisaiTyukeiyouItzHzn();


    ST_HoyuuMeisaiTyukeiyouItzHzn getHoyuuMeisaiTyukeiyouItzHzn(String pZtysrkijyunym, String pZtysrkakutyoujobcd, Integer pZtysequenceno);


    List<ST_IdouMeisaiTyukeiyouItzHzn> getAllIdouMeisaiTyukeiyouItzHzn();


    ST_IdouMeisaiTyukeiyouItzHzn getIdouMeisaiTyukeiyouItzHzn(String pZtysrkijyunym, String pZtysrkakutyoujobcd, Integer pZtysequenceno);


    List<ST_SynypTukiTugtTykiyuHozon> getAllSynypTukiTugtTykiyuHozon();


    ST_SynypTukiTugtTykiyuHozon getSynypTukiTugtTykiyuHozon(String pZtysrkijyunym, String pZtysrkakutyoujobcd, Integer pZtysequenceno);


    List<ST_SynypTukiYkgtIkouHozon> getAllSynypTukiYkgtIkouHozon();


    ST_SynypTukiYkgtIkouHozon getSynypTukiYkgtIkouHozon(String pSrkijyunym, Integer pSequenceno, String pSyono, BizDateYM pJyutoustartym, BizDateYM pJyutouendym
        , C_TaisyakuKbn pTaisyakukbn);


    List<ST_YuukoukykHtjynbknTmttd> getAllYuukoukykHtjynbknTmttd();


    ST_YuukoukykHtjynbknTmttd getYuukoukykHtjynbknTmttd(BizDate pSyoriYmd, String pKakutyoujobcd, String pSyono, String pSrkijyunym);


    List<ST_YuukoukykHtjynbknKarid> getAllYuukoukykHtjynbknKarid();


    ST_YuukoukykHtjynbknKarid getYuukoukykHtjynbknKarid(BizDate pSyoriYmd, String pKakutyoujobcd, String pSyono, String pSrkijyunym);


    List<ST_BknkykHtjynbkn> getAllBknkykHtjynbkn();


    ST_BknkykHtjynbkn getBknkykHtjynbkn(BizDate pSyoriYmd, String pKakutyoujobcd, String pSyono, String pSrkijyunym);


    List<ST_DshrTukiTyukeiyouItzHzn> getAllDshrTukiTyukeiyouItzHzn();


    ST_DshrTukiTyukeiyouItzHzn getDshrTukiTyukeiyouItzHzn(Integer pZtysequenceno);



    List<SV_SnkiykGtjSirt> getAllSnkiykGtjSirt();


    SV_SnkiykGtjSirt getSnkiykGtjSirt(String pMosno);


    List<SV_SnkiykSyunyup> getAllSnkiykSyunyup();


    SV_SnkiykSyunyup getSnkiykSyunyup(String pMosno);


    List<SV_HoyuuMeisai> getAllHoyuuMeisai();


    SV_HoyuuMeisai getHoyuuMeisai(String pSyono);


    List<SV_KiykHnriknSutugk> getAllKiykHnriknSutugk();


    SV_KiykHnriknSutugk getKiykHnriknSutugk(String pSyono);


    List<SV_KiykSyuhnData> getAllKiykSyuhnData();


    SV_KiykSyuhnData getKiykSyuhnData(String pSyono, C_SyutkKbn pSyutkkbn, String pSyouhncd, Integer pSyouhnsdno, Integer pKyksyouhnrenno, String pHenkousikibetukey);


    List<SV_IdouMeisai> getAllIdouMeisai();


    SV_IdouMeisai getIdouMeisai(String pSyono, String pGyoumuKousinKinou, String pGyoumuKousinTime);


    List<SV_BikinIdouMeisai> getAllBikinIdouMeisai();


    SV_BikinIdouMeisai getBikinIdouMeisai(String pSyono, String pGyoumuKousinKinou, String pGyoumuKousinTime);


    List<SV_SibourituToukeiSeibigo> getAllSibourituToukeiSeibigo();


    SV_SibourituToukeiSeibigo getSibourituToukeiSeibigo(String pSyono, String pGyoumuKousinKinou, String pGyoumuKousinTime);


    List<SV_Sp2RnduyuSouseiritu> getAllSp2RnduyuSouseiritu();


    SV_Sp2RnduyuSouseiritu getSp2RnduyuSouseiritu(String pMosno);


    ExDBResults<SV_TuujyuHitusyyugk> getTuujyuHitusyyugksBySyutkkbnHaitoukbn(C_SyutkKbn pSyutkkbn, C_HaitouKbn pHaitoukbn1, String pKbnkey);


    List<SV_KiykSyuhnData> getKiykSyuhnDatasBySyonoSyutkkbn(String pSyono, C_SyutkKbn pSyutkkbn);


    List<BizDate> getKiykSyuhnDataKouryokuhasseiymdsBySyonoHenkousikibetukey(String pSyono, String pHenkousikibetukey);


    ExDBResults<SV_RisanomiTuujyuHitusyyugk> getRisanomiTuujyuHitusyyugksBySyutkkbnHaitoukbn(C_SyutkKbn pSyutkkbn, C_HaitouKbn pHaitoukbn, String pKbnkey);


    List<SV_SibourituRendou> getAllSibourituRendou();


    SV_SibourituRendou getSibourituRendou(String pMosno);


    List<SV_TuujyuHitusyyugk> getAllTuujyuHitusyyugk();


    SV_TuujyuHitusyyugk getTuujyuHitusyyugk(String pSyono, C_SyutkKbn pSyutkkbn, String pSyouhncd, Integer pSyouhnsdno, Integer pKyksyouhnrenno);


    List<SV_RisanomiTuujyuHitusyyugk> getAllRisanomiTuujyuHitusyyugk();


    SV_RisanomiTuujyuHitusyyugk getRisanomiTuujyuHitusyyugk(String pSyono, C_SyutkKbn pSyutkkbn, String pSyouhncd, Integer pSyouhnsdno, Integer pKyksyouhnrenno);

}
