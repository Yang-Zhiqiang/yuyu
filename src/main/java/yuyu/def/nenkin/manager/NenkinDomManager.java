package yuyu.def.nenkin.manager;

import yuyu.def.base.manager.DomManager;


/**
 * 年金支払 DOM マネージャ インターフェース<br />
 * カテゴリDomマネージャを業務機能から隠蔽するために、抽象クラスと実装クラスに分離して、<br />
 * 業務機能からは見えない実装クラスで、カテゴリDomマネージャを使用しています。 <br />
 */
public interface NenkinDomManager extends DomManager {


//        List<KT_NenkinKihon> getAllNenkinKihon();
//
//
//        KT_NenkinKihon getNenkinKihon(String pNksysyno);
//
//
//        List<KT_NenkinKihon> getNenkinKihonsByMotosyonoHhknnmknHhknseiymdUktnmknUktseiymd(String pMotosyono, String pHhknnmkn, BizDate pHhknseiymd, String pUktnmkn, BizDate pUktseiymd);
//
//
//        ExDBUpdatableResults<KT_NenkinKihon> getNenkinKihonsByKakutyoujobcdNkshrjkNextnkshrkjt(String pKakutyoujobcd, BizDate pNextnkshrkjt);
//
//
//        List<KT_NenkinKihon> getNenkinKihonsByMisKyk();
//
//
//        Long getNenkinKihonCountByMotosyonoHhknnmknHhknseiymdUktnmknUktseiymd(String pMotosyono, String pHhknnmkn, BizDate pHhknseiymd, String pUktnmkn, BizDate pUktseiymd);
//
//
//        ExDBResults<IchijikinShiharaiInfosByTaisyouymBean> getIchijikinShiharaiInfosByTaisyouym(BizDateYM pTaisyouym);
//
//
//        ExDBUpdatableResults<KT_NenkinKihon> getNenkinKihonsByKakutyoujobcdNkshrjkTaisyoukknto(String pKakutyoujobcd, BizDate pTaisyoukknto);
//
//
//        List<KT_BAK_NenkinKihon> getAllBAKNenkinKihon();
//
//
//        KT_BAK_NenkinKihon getBAKNenkinKihon(String pNksysyno, String pNktjttrkskey);
//
//
//        List<KT_NkHubi> getAllNkHubi();
//
//
//        KT_NkHubi getNkHubi(String pHubisikibetukey);
//
//
//        BizDate getNkSiharaiYoteiMaxShrymdByNksysyno(String pNksysyno);
//
//
//        ExDBResults<UketorininSiharaiTyousyoInfosByTyakkinymTorikesiflgZeitratkikbnBean> getUketorininSiharaiTyousyoInfosByTyakkinymTorikesiflgZeitratkikbn(BizDateYM pTyakkinym);
//
//
//        ExDBResults<UketorininInfosByJykyknhsijiyuuSyoriYmdJykyknhykgkTorikesiflgBean> getUketorininInfosByJykyknhsijiyuuSyoriYmdJykyknhykgkTorikesiflg(BizDateYM pTaisyouym);
//
//
//
//        List<KT_NkDenpyoData> getAllNkDenpyoData();
//
//
//        KT_NkDenpyoData getNkDenpyoData(String pDenrenno, Integer pEdano);
//
//
//        ExDBUpdatableResults<KT_NkDenpyoData> getNkDenpyoDatasByKakutyoujobcdSyoriYmd(String pKakutyoujobcd, BizDate pSyoriYmd);
//
//
//        List<KT_NkFBSoukinData> getAllNkFBSoukinData();
//
//
//        KT_NkFBSoukinData getNkFBSoukinData(String pFbsoukindatasikibetukey);
//
//
//        ExDBResults<KT_NkFBSoukinData> getNkFBSoukinDatasByKakutyoujobcdSyoriYmdGyoumucd(String pKakutyoujobcd, BizDate pSyoriYmd, C_Gyoumucd... pGyoumucd);
//
//
//        List<KT_NkGaikaFBSoukinData> getAllNkGaikaFBSoukinData();
//
//
//        KT_NkGaikaFBSoukinData getNkGaikaFBSoukinData(String pFbsoukindatasikibetukey);
//
//
//        ExDBResults<KT_NkGaikaFBSoukinData> getNkGaikaFBSoukinDatasByKakutyoujobcdSyoriYmdGkgyoumucds(String pKakutyoujobcd, BizDate pSyoriYmd, C_Gkgyoumucd... pGkgyoumucd);
//
//
//
//        List<KT_NkSiharaiTuuti> getAllNkSiharaiTuuti();
//
//
//        KT_NkSiharaiTuuti getNkSiharaiTuuti(String pNksysyno, BizDate pTyouhyouymd, BizNumber pSeqno);
//
//
//        List<KT_NkSiharaiTuuti> getNkSiharaiTuutisByNksysynoTyouhyouymd(String pNksysyno, BizDate pTyouhyouymd);
//
//
//        Integer getNKSyousyoMaxSyousyorennoByNksysynoTyouhyouymdNe(String pNksysyno, BizDate pTyouhyouymd);
//
//
//        List<KT_NkTyousyo> getAllNkTyousyo();
//
//
//        KT_NkTyousyo getNkTyousyo(String pNksysyno, BizDate pTyouhyouymd, Long pShrtysyrenno);
//
//
//        List<KT_NkTyousyo> getNkTyousyosByTyouhyouymd(BizDate pTyouhyouymd);
//
//
//        List<KT_NkHubiMikaisyouList> getAllNkHubiMikaisyouList();
//
//
//        KT_NkHubiMikaisyouList getNkHubiMikaisyouList(String pJimutetuzukicd, String pNksysyno, C_HassinsakiKbn pHassinsakikbn);
//
//
//        List<KT_NkHubiMikaisyouList> getNkHubiMikaisyouListsByJimutetuzukicdNksysyno(String pJimutetuzukicd, String pNksysyno);
//
//
//        List<KT_TtdkKanTuutiNkIkou> getAllTtdkKanTuutiNkIkou();
//
//
//        KT_TtdkKanTuutiNkIkou getTtdkKanTuutiNkIkou(String pNksysyno, BizDate pTyouhyouymd, BizNumber pSeqno);
//
//
//        List<KT_NkTyousyoNenkin> getAllNkTyousyoNenkin();
//
//
//        KT_NkTyousyoNenkin getNkTyousyoNenkin(String pNksysyno, BizDate pTyouhyouymd, Long pShrtysyrenno);
//
//
//        List<KT_ZeimuTuuti> getAllZeimuTuuti();
//
//
//        KT_ZeimuTuuti getZeimuTuuti(String pNksysyno, BizDate pTyouhyouymd, BizNumber pSeqno);
//
//
//        ExDBResults<NkHubiMikaisyouListInfosBean> getNkHubiMikaisyouListInfos();
//
//
//
//        List<KM_HituyouSyorui> getAllHituyouSyorui();
//
//
//        KM_HituyouSyorui getHituyouSyorui(String pSyoricd, Integer pHanteikbn1, Integer pHanteikbn2, BizNumber pSeqno);
//
//
//        List<KM_HituyouSyorui> getHituyouSyoruisByKinouId(String pKinouId);
//
//
//        List<KM_HituyouSyorui> getHituyouSyoruisByKinouIdHanteikbn1Hanteikbn2(String pKinouId, Integer pHanteikbn1, Integer pHanteikbn2);
//
//
//        List<KM_TyouhyouMsg> getAllTyouhyouMsg();
//
//
//        KM_TyouhyouMsg getTyouhyouMsg(String pBunrui1, String pBunrui2);
//
//
//        List<KM_TyouhyouMsg> getTyouhyouMsgsByBunrui1(String pBunrui1);
//
//
//        List<KM_TyuuiToriatukaiKahi> getAllTyuuiToriatukaiKahi();
//
//
//        KM_TyuuiToriatukaiKahi getTyuuiToriatukaiKahi(String pKinouId);
//
//
//        List<KM_NkHubiNaiyou> getAllNkHubiNaiyou();
//
//
//        KM_NkHubiNaiyou getNkHubiNaiyou(String pJimutetuzukicd, C_SyoruiCdKbn pSyoruiCd, String pHubinaiyoucd);
//
//
//        List<KM_NkHubiNaiyou> getNkHubiNaiyousByJimutetuzukicdSyoruiCd(String pJimutetuzukicd, C_SyoruiCdKbn pSyoruiCd);
//
//
//        List<C_SyoruiCdKbn> getNkHubiNaiyouSyoruiCdsByJimutetuzukicd(String pJimutetuzukicd);
//
//
//        List<KM_YomeiNensuu> getAllYomeiNensuu();
//
//
//        KM_YomeiNensuu getYomeiNensuu(Integer pHhknnen);
//
//
//        List<KM_KanzenSeimeihyou> getAllKanzenSeimeihyou();
//
//
//        List<KM_KanzenSeimeihyou> getKanzenSeimeihyouByHhknnenCalckijyunymd(Integer pHhknnen, BizDate pCalckijyunymd);
//
//
//        KM_KanzenSeimeihyou getKanzenSeimeihyou(Integer pHhknnen, BizDate pCalckijyunfromymd, BizDate pCalckijyuntoymd);
//
//
//        List<KM_NenkinZokusei> getAllNenkinZokusei();
//
//
//        KM_NenkinZokusei getNenkinZokusei(String pNenkinsyu, String pNksyuruiversion);
//
//
//        List<KM_BunkatuNkRiritu> getAllBunkatuNkRiritu();
//
//
//        KM_BunkatuNkRiritu getBunkatuNkRiritu(BizDate pCalckijyunfromymd);
//
//
//        List<KM_BunkatuNkRiritu> getBunkatuNkRiritusByCalckijyuntoymd(BizDate pCalckijyuntoymd);
//
//
//        List<KM_BunkatuNkRiritu> getBunkatuNkRiritusByCalckijyunfromymd(BizDate pCalckijyunfromymd);
//
//
//
//        List<KM_ChkTtdJoutai> getAllChkTtdJoutai();
//
//
//        KM_ChkTtdJoutai getChkTtdJoutai(String pKinouId, String pSyorijimuttdkcd);
//
//
//        List<KM_ChkTtdJoutai> getChkTtdJoutaisByKinouIdSyorikahikbn(String pKinouId, C_SyorikahiKbn pSyorikahikbn);
//
//
//        List<KM_ChkTtdJoutaiSksakusei> getAllChkTtdJoutaiSksakusei();
//
//
//        KM_ChkTtdJoutaiSksakusei getChkTtdJoutaiSksakusei(C_NkhkSeikyuuNaiyou pNkhkseikyuunaiyou, String pSyorijimuttdkcd);
//
//
//        List<KM_ChkTtdJoutaiTkhnk> getAllChkTtdJoutaiTkhnk();
//
//
//        KM_ChkTtdJoutaiTkhnk getChkTtdJoutaiTkhnk(C_Tkyksyurui pTkyksyurui, String pSyorijimuttdkcd);
//
//
//
//        List<KW_NkKouzaHenkouWk> getAllNkKouzaHenkouWk();
//
//
//        KW_NkKouzaHenkouWk getNkKouzaHenkouWk(String pKouteikanriid);
//
//
//        List<KW_NkSiharaiWk> getAllNkSiharaiWk();
//
//
//        KW_NkSiharaiWk getNkSiharaiWk(String pKouteikanriid);
//
//
//        List<KW_NkSibouWk> getAllNkSibouWk();
//
//
//        KW_NkSibouWk getNkSibouWk(String pKouteikanriid);
//
//
//        List<KW_NkSaihakkouWk> getAllNkSaihakkouWk();
//
//
//        KW_NkSaihakkouWk getNkSaihakkouWk(String pKouteikanriid);
//
//
//        List<KW_NkMeigiJyuusyoHenkouWk> getAllNkMeigiJyuusyoHenkouWk();
//
//
//        KW_NkMeigiJyuusyoHenkouWk getNkMeigiJyuusyoHenkouWk(String pKouteikanriid);
//
//
//        List<KW_NkKaisuuHenkouWk> getAllNkKaisuuHenkouWk();
//
//
//        KW_NkKaisuuHenkouWk getNkKaisuuHenkouWk(String pKouteikanriid);
//
//
//        List<KW_NkTokuyakuHenkouWk> getAllNkTokuyakuHenkouWk();
//
//
//        KW_NkTokuyakuHenkouWk getNkTokuyakuHenkouWk(String pKouteikanriid);
//
//
//        List<KW_NkHubiWk> getAllNkHubiWk();
//
//
//        KW_NkHubiWk getNkHubiWk(String pKouteikanriid);
//
//
//        List<KW_NkHubiKaisyouDetailWk> getAllNkHubiKaisyouDetailWk();
//
//
//        KW_NkHubiKaisyouDetailWk getNkHubiKaisyouDetailWk(String pKouteikanriid, Integer pRenno3keta);
//
//
//
//        Long getNkTetudukiRirekiCountByNksysynoShrsyousaiumuSyoriYmdGe(String pNksysyno, C_UmuKbn pShrsyousaiumu, BizDate pSyoriYmd);
//
//
//        Long getNkTetudukiRirekiCountByNksysynoTtdksyousaiumuSyoriYmdGe(String pNksysyno, C_UmuKbn pTtdksyousaiumu, BizDate pSyoriYmd);
//
//
//        Long getNkTetudukiRirekiCountByNksysyno(String pNksysyno);
//
//
//        String getNkSiharaiRirekiMaxNkshrsikibetukeyByNksysynoTorikesiflg(String pNksysyno, C_UmuKbn pTorikesiflg);
//
//
//        ExDBResults<KT_NkSiharaiRireki> getNkSiharaiRirekisBySyoriYmd(BizDate pSyoriYmd);
//
//
//        ExDBResults<KT_NkSiharaiRireki> getNkSiharaiRirekisByＮksysynoShrtynd(String pNksysyno, BizDateY pShrtynd);
//
//
//        List<Object[]> getNenkinOnlineBySyoriYmdSubSystemIdKensuuhyoujijyun(BizDate pSyoriYmd, String pSubSystemId);
//
//
//        Long getNkSiharaiRirekiCountByNksysynoTorikesiflg(String pNksysyno, C_UmuKbn pTorikesiflg);
//
//
//        KT_NkSiharaiRireki getNkSiharaiRirekiByNksysynoTorikesiflgMaxNkshrsikibetukey(String pNksysyno, C_UmuKbn pTorikesiflg);
//
//
//        ExDBResults<NkSiharaiTyousyoSakuseisByShrtyndItemsBean> getNkSiharaiTyousyoSakuseisByShrtyndItems(BizDateY pShrtynd);
//
//
//        KT_NkUketorininRireki getNkUketorininRirekiByNksysynoMaxSeqno(String pNksysyno);
//
//
//        List<KT_NkTetudukiRireki> getNkTetudukiRirekisByGyoumuKousinKinou(String pSubSystemId, BizDate pSyorikknfromymd, BizDate pSyorikkntoymd, String... pGyoumuKousinKinou);
//
//
//        Long getNkTetudukiRirekiCountByGyoumuKousinKinou(String pSubSystemId, BizDate pSyorikknfromymd, BizDate pSyorikkntoymd, String... pGyoumuKousinKinou);
//
//
//        BizDate getNkUketorininRirekiMaxSibouymdByNksysynoSibouymdTorikesiflg(String pNksysyno, BizDate pSibouymd, C_UmuKbn pTorikesiflg);

}
