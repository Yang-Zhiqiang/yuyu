package yuyu.def.nenkin.manager.impl;

import yuyu.def.base.manager.AbstractDomManager;
import yuyu.def.nenkin.manager.NenkinDomManager;



/**
 * 年金支払 DOM マネージャ 実装クラス<br />
 * {@link NenkinDomManager}で宣言したメソッドを実装します。<br />
 * カテゴリDomマネージャを業務機能から隠蔽するために、抽象クラスと実装クラスに分離して、<br />
 * 業務機能からは見えない実装クラスで、カテゴリDomマネージャを使用しています。 <br />
 */
public class NenkinDomManagerImpl extends AbstractDomManager implements NenkinDomManager {


//        @Inject
//        private KeiyakuDomManager keiyakuDomManager;
//
//
//        @Inject
//        private EtcDomManager etcDomManager;
//
//
//        @Inject
//        private TyouhyouDomManager tyouhyouDomManager;
//
//
//        @Inject
//        private GyomuDomManager gyomuDomManager;
//
//
//        @Inject
//        private CheckMstManager checkMstManager;
//
//
//        @Inject
//        private WorkflowDomManager workflowDomManager;
//
//
//        @Inject
//        private RirekiDomManager rirekiDomManager;
//
//
//
//        @Override
//        public List<KT_NenkinKihon> getAllNenkinKihon() {
//            return keiyakuDomManager.getAllNenkinKihon();
//        }
//
//
//        @Override
//        public KT_NenkinKihon getNenkinKihon(String pNksysyno) {
//            return keiyakuDomManager.getNenkinKihon(pNksysyno);
//        }
//
//
//        @Override
//        public List<KT_NenkinKihon> getNenkinKihonsByMotosyonoHhknnmknHhknseiymdUktnmknUktseiymd(String pMotosyono, String pHhknnmkn, BizDate pHhknseiymd, String pUktnmkn, BizDate pUktseiymd) {
//            return keiyakuDomManager.getNenkinKihonsByMotosyonoHhknnmknHhknseiymdUktnmknUktseiymd(pMotosyono, pHhknnmkn, pHhknseiymd, pUktnmkn, pUktseiymd);
//        }
//
//
//        @Override
//        public ExDBUpdatableResults<KT_NenkinKihon> getNenkinKihonsByKakutyoujobcdNkshrjkNextnkshrkjt(String pKakutyoujobcd, BizDate pNextnkshrkjt) {
//            return keiyakuDomManager.getNenkinKihonsByKakutyoujobcdNkshrjkNextnkshrkjt(pKakutyoujobcd, pNextnkshrkjt);
//        }
//
//
//        @Override
//        public List<KT_NenkinKihon> getNenkinKihonsByMisKyk() {
//            return keiyakuDomManager.getNenkinKihonsByMisKyk();
//        }
//
//
//        @Override
//        public Long getNenkinKihonCountByMotosyonoHhknnmknHhknseiymdUktnmknUktseiymd(String pMotosyono, String pHhknnmkn, BizDate pHhknseiymd, String pUktnmkn, BizDate pUktseiymd) {
//            return keiyakuDomManager.getNenkinKihonCountByMotosyonoHhknnmknHhknseiymdUktnmknUktseiymd(pMotosyono, pHhknnmkn, pHhknseiymd, pUktnmkn, pUktseiymd);
//        }
//
//
//        @Override
//        public ExDBResults<IchijikinShiharaiInfosByTaisyouymBean> getIchijikinShiharaiInfosByTaisyouym(BizDateYM pTaisyouym) {
//            return keiyakuDomManager.getIchijikinShiharaiInfosByTaisyouym(pTaisyouym);
//        }
//
//
//        @Override
//        public ExDBUpdatableResults<KT_NenkinKihon> getNenkinKihonsByKakutyoujobcdNkshrjkTaisyoukknto(String pKakutyoujobcd, BizDate pTaisyoukknto) {
//            return keiyakuDomManager.getNenkinKihonsByKakutyoujobcdNkshrjkTaisyoukknto(pKakutyoujobcd, pTaisyoukknto);
//        }
//
//
//        @Override
//        public List<KT_BAK_NenkinKihon> getAllBAKNenkinKihon() {
//            return keiyakuDomManager.getAllBAKNenkinKihon();
//        }
//
//
//        @Override
//        public KT_BAK_NenkinKihon getBAKNenkinKihon(String pNksysyno, String pNktjttrkskey) {
//            return keiyakuDomManager.getBAKNenkinKihon(pNksysyno, pNktjttrkskey);
//        }
//
//
//        @Override
//        public List<KT_NkHubi> getAllNkHubi() {
//            return keiyakuDomManager.getAllNkHubi();
//        }
//
//
//        @Override
//        public KT_NkHubi getNkHubi(String pHubisikibetukey) {
//            return keiyakuDomManager.getNkHubi(pHubisikibetukey);
//        }
//
//
//        @Override
//        public BizDate getNkSiharaiYoteiMaxShrymdByNksysyno(String pNksysyno) {
//            return keiyakuDomManager.getNkSiharaiYoteiMaxShrymdByNksysyno(pNksysyno);
//        }
//
//
//        @Override
//        public ExDBResults<UketorininSiharaiTyousyoInfosByTyakkinymTorikesiflgZeitratkikbnBean> getUketorininSiharaiTyousyoInfosByTyakkinymTorikesiflgZeitratkikbn(BizDateYM pTyakkinym) {
//            return keiyakuDomManager.getUketorininSiharaiTyousyoInfosByTyakkinymTorikesiflgZeitratkikbn(pTyakkinym);
//        }
//
//
//        @Override
//        public ExDBResults<UketorininInfosByJykyknhsijiyuuSyoriYmdJykyknhykgkTorikesiflgBean> getUketorininInfosByJykyknhsijiyuuSyoriYmdJykyknhykgkTorikesiflg(BizDateYM pTaisyouym) {
//            return keiyakuDomManager.getUketorininInfosByJykyknhsijiyuuSyoriYmdJykyknhykgkTorikesiflg(pTaisyouym);
//        }
//
//
//
//        @Override
//        public List<KT_NkDenpyoData> getAllNkDenpyoData() {
//            return etcDomManager.getAllNkDenpyoData();
//        }
//
//
//        @Override
//        public KT_NkDenpyoData getNkDenpyoData(String pDenrenno, Integer pEdano) {
//            return etcDomManager.getNkDenpyoData(pDenrenno, pEdano);
//        }
//
//
//        @Override
//        public ExDBUpdatableResults<KT_NkDenpyoData> getNkDenpyoDatasByKakutyoujobcdSyoriYmd(String pKakutyoujobcd, BizDate pSyoriYmd) {
//            return etcDomManager.getNkDenpyoDatasByKakutyoujobcdSyoriYmd(pKakutyoujobcd, pSyoriYmd);
//        }
//
//
//        @Override
//        public List<KT_NkFBSoukinData> getAllNkFBSoukinData() {
//            return etcDomManager.getAllNkFBSoukinData();
//        }
//
//
//        @Override
//        public KT_NkFBSoukinData getNkFBSoukinData(String pFbsoukindatasikibetukey) {
//            return etcDomManager.getNkFBSoukinData(pFbsoukindatasikibetukey);
//        }
//
//
//        @Override
//        public ExDBResults<KT_NkFBSoukinData> getNkFBSoukinDatasByKakutyoujobcdSyoriYmdGyoumucd(String pKakutyoujobcd, BizDate pSyoriYmd, C_Gyoumucd... pGyoumucd) {
//            return etcDomManager.getNkFBSoukinDatasByKakutyoujobcdSyoriYmdGyoumucd(pKakutyoujobcd, pSyoriYmd, pGyoumucd);
//        }
//
//
//        @Override
//        public List<KT_NkGaikaFBSoukinData> getAllNkGaikaFBSoukinData() {
//            return etcDomManager.getAllNkGaikaFBSoukinData();
//        }
//
//
//        @Override
//        public KT_NkGaikaFBSoukinData getNkGaikaFBSoukinData(String pFbsoukindatasikibetukey) {
//            return etcDomManager.getNkGaikaFBSoukinData(pFbsoukindatasikibetukey);
//        }
//
//
//        @Override
//        public ExDBResults<KT_NkGaikaFBSoukinData> getNkGaikaFBSoukinDatasByKakutyoujobcdSyoriYmdGkgyoumucds(String pKakutyoujobcd, BizDate pSyoriYmd, C_Gkgyoumucd... pGkgyoumucd) {
//            return etcDomManager.getNkGaikaFBSoukinDatasByKakutyoujobcdSyoriYmdGkgyoumucds(pKakutyoujobcd, pSyoriYmd, pGkgyoumucd);
//        }
//
//
//
//        @Override
//        public List<KT_NkSiharaiTuuti> getAllNkSiharaiTuuti() {
//            return tyouhyouDomManager.getAllNkSiharaiTuuti();
//        }
//
//
//        @Override
//        public KT_NkSiharaiTuuti getNkSiharaiTuuti(String pNksysyno, BizDate pTyouhyouymd, BizNumber pSeqno) {
//            return tyouhyouDomManager.getNkSiharaiTuuti(pNksysyno, pTyouhyouymd, pSeqno);
//        }
//
//
//        @Override
//        public List<KT_NkSiharaiTuuti> getNkSiharaiTuutisByNksysynoTyouhyouymd(String pNksysyno, BizDate pTyouhyouymd) {
//            return tyouhyouDomManager.getNkSiharaiTuutisByNksysynoTyouhyouymd(pNksysyno, pTyouhyouymd);
//        }
//
//
//        @Override
//        public Integer getNKSyousyoMaxSyousyorennoByNksysynoTyouhyouymdNe(String pNksysyno, BizDate pTyouhyouymd) {
//            return tyouhyouDomManager.getNKSyousyoMaxSyousyorennoByNksysynoTyouhyouymdNe(pNksysyno, pTyouhyouymd);
//        }
//
//
//        @Override
//        public List<KT_NkTyousyo> getAllNkTyousyo() {
//            return tyouhyouDomManager.getAllNkTyousyo();
//        }
//
//
//        @Override
//        public KT_NkTyousyo getNkTyousyo(String pNksysyno, BizDate pTyouhyouymd, Long pShrtysyrenno) {
//            return tyouhyouDomManager.getNkTyousyo(pNksysyno, pTyouhyouymd, pShrtysyrenno);
//        }
//
//
//        @Override
//        public List<KT_NkTyousyo> getNkTyousyosByTyouhyouymd(BizDate pTyouhyouymd) {
//            return tyouhyouDomManager.getNkTyousyosByTyouhyouymd(pTyouhyouymd);
//        }
//
//
//        @Override
//        public List<KT_NkHubiMikaisyouList> getAllNkHubiMikaisyouList() {
//            return tyouhyouDomManager.getAllNkHubiMikaisyouList();
//        }
//
//
//        @Override
//        public KT_NkHubiMikaisyouList getNkHubiMikaisyouList(String pJimutetuzukicd, String pNksysyno, C_HassinsakiKbn pHassinsakikbn) {
//            return tyouhyouDomManager.getNkHubiMikaisyouList(pJimutetuzukicd, pNksysyno, pHassinsakikbn);
//        }
//
//
//        @Override
//        public List<KT_NkHubiMikaisyouList> getNkHubiMikaisyouListsByJimutetuzukicdNksysyno(String pJimutetuzukicd, String pNksysyno) {
//            return tyouhyouDomManager.getNkHubiMikaisyouListsByJimutetuzukicdNksysyno(pJimutetuzukicd, pNksysyno);
//        }
//
//
//        @Override
//        public List<KT_TtdkKanTuutiNkIkou> getAllTtdkKanTuutiNkIkou() {
//            return tyouhyouDomManager.getAllTtdkKanTuutiNkIkou();
//        }
//
//
//        @Override
//        public KT_TtdkKanTuutiNkIkou getTtdkKanTuutiNkIkou(String pNksysyno, BizDate pTyouhyouymd, BizNumber pSeqno) {
//            return tyouhyouDomManager.getTtdkKanTuutiNkIkou(pNksysyno, pTyouhyouymd, pSeqno);
//        }
//
//
//        @Override
//        public List<KT_NkTyousyoNenkin> getAllNkTyousyoNenkin() {
//            return tyouhyouDomManager.getAllNkTyousyoNenkin();
//        }
//
//
//        @Override
//        public KT_NkTyousyoNenkin getNkTyousyoNenkin(String pNksysyno, BizDate pTyouhyouymd, Long pShrtysyrenno) {
//            return tyouhyouDomManager.getNkTyousyoNenkin(pNksysyno, pTyouhyouymd, pShrtysyrenno);
//        }
//
//
//        @Override
//        public List<KT_ZeimuTuuti> getAllZeimuTuuti() {
//            return tyouhyouDomManager.getAllZeimuTuuti();
//        }
//
//
//        @Override
//        public KT_ZeimuTuuti getZeimuTuuti(String pNksysyno, BizDate pTyouhyouymd, BizNumber pSeqno) {
//            return tyouhyouDomManager.getZeimuTuuti(pNksysyno, pTyouhyouymd, pSeqno);
//        }
//
//
//        @Override
//        public ExDBResults<NkHubiMikaisyouListInfosBean> getNkHubiMikaisyouListInfos() {
//            return tyouhyouDomManager.getNkHubiMikaisyouListInfos();
//        }
//
//
//
//        @Override
//        public List<KM_HituyouSyorui> getAllHituyouSyorui() {
//            return gyomuDomManager.getAllHituyouSyorui();
//        }
//
//
//        @Override
//        public KM_HituyouSyorui getHituyouSyorui(String pSyoricd, Integer pHanteikbn1, Integer pHanteikbn2, BizNumber pSeqno) {
//            return gyomuDomManager.getHituyouSyorui(pSyoricd, pHanteikbn1, pHanteikbn2, pSeqno);
//        }
//
//
//        @Override
//        public List<KM_HituyouSyorui> getHituyouSyoruisByKinouId(String pKinouId) {
//            return gyomuDomManager.getHituyouSyoruisByKinouId(pKinouId);
//        }
//
//
//        @Override
//        public List<KM_HituyouSyorui> getHituyouSyoruisByKinouIdHanteikbn1Hanteikbn2(String pKinouId, Integer pHanteikbn1, Integer pHanteikbn2) {
//            return gyomuDomManager.getHituyouSyoruisByKinouIdHanteikbn1Hanteikbn2(pKinouId, pHanteikbn1, pHanteikbn2);
//        }
//
//
//        @Override
//        public List<KM_TyouhyouMsg> getAllTyouhyouMsg() {
//            return gyomuDomManager.getAllTyouhyouMsg();
//        }
//
//
//        @Override
//        public KM_TyouhyouMsg getTyouhyouMsg(String pBunrui1, String pBunrui2) {
//            return gyomuDomManager.getTyouhyouMsg(pBunrui1, pBunrui2);
//        }
//
//
//        @Override
//        public List<KM_TyouhyouMsg> getTyouhyouMsgsByBunrui1(String pBunrui1) {
//            return gyomuDomManager.getTyouhyouMsgsByBunrui1(pBunrui1);
//        }
//
//
//        @Override
//        public List<KM_TyuuiToriatukaiKahi> getAllTyuuiToriatukaiKahi() {
//            return gyomuDomManager.getAllTyuuiToriatukaiKahi();
//        }
//
//
//        @Override
//        public KM_TyuuiToriatukaiKahi getTyuuiToriatukaiKahi(String pKinouId) {
//            return gyomuDomManager.getTyuuiToriatukaiKahi(pKinouId);
//        }
//
//
//        @Override
//        public List<KM_NkHubiNaiyou> getAllNkHubiNaiyou() {
//            return gyomuDomManager.getAllNkHubiNaiyou();
//        }
//
//
//        @Override
//        public KM_NkHubiNaiyou getNkHubiNaiyou(String pJimutetuzukicd, C_SyoruiCdKbn pSyoruiCd, String pHubinaiyoucd) {
//            return gyomuDomManager.getNkHubiNaiyou(pJimutetuzukicd, pSyoruiCd, pHubinaiyoucd);
//        }
//
//
//        @Override
//        public List<KM_NkHubiNaiyou> getNkHubiNaiyousByJimutetuzukicdSyoruiCd(String pJimutetuzukicd, C_SyoruiCdKbn pSyoruiCd) {
//            return gyomuDomManager.getNkHubiNaiyousByJimutetuzukicdSyoruiCd(pJimutetuzukicd, pSyoruiCd);
//        }
//
//
//        @Override
//        public List<C_SyoruiCdKbn> getNkHubiNaiyouSyoruiCdsByJimutetuzukicd(String pJimutetuzukicd) {
//            return gyomuDomManager.getNkHubiNaiyouSyoruiCdsByJimutetuzukicd(pJimutetuzukicd);
//        }
//
//
//        @Override
//        public List<KM_YomeiNensuu> getAllYomeiNensuu() {
//            return gyomuDomManager.getAllYomeiNensuu();
//        }
//
//
//        @Override
//        public KM_YomeiNensuu getYomeiNensuu(Integer pHhknnen) {
//            return gyomuDomManager.getYomeiNensuu(pHhknnen);
//        }
//
//
//        @Override
//        public List<KM_KanzenSeimeihyou> getAllKanzenSeimeihyou() {
//            return gyomuDomManager.getAllKanzenSeimeihyou();
//        }
//
//
//        @Override
//        public List<KM_KanzenSeimeihyou> getKanzenSeimeihyouByHhknnenCalckijyunymd(Integer pHhknnen, BizDate pCalckijyunymd) {
//            return gyomuDomManager.getKanzenSeimeihyouByHhknnenCalckijyunymd(pHhknnen, pCalckijyunymd);
//        }
//
//
//        @Override
//        public KM_KanzenSeimeihyou getKanzenSeimeihyou(Integer pHhknnen, BizDate pCalckijyunfromymd, BizDate pCalckijyuntoymd) {
//            return gyomuDomManager.getKanzenSeimeihyou(pHhknnen, pCalckijyunfromymd, pCalckijyuntoymd);
//        }
//
//
//        @Override
//        public List<KM_NenkinZokusei> getAllNenkinZokusei() {
//            return gyomuDomManager.getAllNenkinZokusei();
//        }
//
//
//        @Override
//        public KM_NenkinZokusei getNenkinZokusei(String pNenkinsyu, String pNksyuruiversion) {
//            return gyomuDomManager.getNenkinZokusei(pNenkinsyu, pNksyuruiversion);
//        }
//
//
//        @Override
//        public List<KM_BunkatuNkRiritu> getAllBunkatuNkRiritu() {
//            return gyomuDomManager.getAllBunkatuNkRiritu();
//        }
//
//
//        @Override
//        public KM_BunkatuNkRiritu getBunkatuNkRiritu(BizDate pCalckijyunfromymd) {
//            return gyomuDomManager.getBunkatuNkRiritu(pCalckijyunfromymd);
//        }
//
//
//        @Override
//        public List<KM_BunkatuNkRiritu> getBunkatuNkRiritusByCalckijyuntoymd(BizDate pCalckijyuntoymd) {
//            return gyomuDomManager.getBunkatuNkRiritusByCalckijyuntoymd(pCalckijyuntoymd);
//        }
//
//
//        @Override
//        public List<KM_BunkatuNkRiritu> getBunkatuNkRiritusByCalckijyunfromymd(BizDate pCalckijyunfromymd) {
//            return gyomuDomManager.getBunkatuNkRiritusByCalckijyunfromymd(pCalckijyunfromymd);
//        }
//
//
//
//        @Override
//        public List<KM_ChkTtdJoutai> getAllChkTtdJoutai() {
//            return checkMstManager.getAllChkTtdJoutai();
//        }
//
//
//        @Override
//        public KM_ChkTtdJoutai getChkTtdJoutai(String pKinouId, String pSyorijimuttdkcd) {
//            return checkMstManager.getChkTtdJoutai(pKinouId, pSyorijimuttdkcd);
//        }
//
//
//        @Override
//        public List<KM_ChkTtdJoutai> getChkTtdJoutaisByKinouIdSyorikahikbn(String pKinouId, C_SyorikahiKbn pSyorikahikbn) {
//            return checkMstManager.getChkTtdJoutaisByKinouIdSyorikahikbn(pKinouId, pSyorikahikbn);
//        }
//
//
//        @Override
//        public List<KM_ChkTtdJoutaiSksakusei> getAllChkTtdJoutaiSksakusei() {
//            return checkMstManager.getAllChkTtdJoutaiSksakusei();
//        }
//
//
//        @Override
//        public KM_ChkTtdJoutaiSksakusei getChkTtdJoutaiSksakusei(C_NkhkSeikyuuNaiyou pNkhkseikyuunaiyou, String pSyorijimuttdkcd) {
//            return checkMstManager.getChkTtdJoutaiSksakusei(pNkhkseikyuunaiyou, pSyorijimuttdkcd);
//        }
//
//
//        @Override
//        public List<KM_ChkTtdJoutaiTkhnk> getAllChkTtdJoutaiTkhnk() {
//            return checkMstManager.getAllChkTtdJoutaiTkhnk();
//        }
//
//
//        @Override
//        public KM_ChkTtdJoutaiTkhnk getChkTtdJoutaiTkhnk(C_Tkyksyurui pTkyksyurui, String pSyorijimuttdkcd) {
//            return checkMstManager.getChkTtdJoutaiTkhnk(pTkyksyurui, pSyorijimuttdkcd);
//        }
//
//
//
//        @Override
//        public List<KW_NkKouzaHenkouWk> getAllNkKouzaHenkouWk() {
//            return workflowDomManager.getAllNkKouzaHenkouWk();
//        }
//
//
//        @Override
//        public KW_NkKouzaHenkouWk getNkKouzaHenkouWk(String pKouteikanriid) {
//            return workflowDomManager.getNkKouzaHenkouWk(pKouteikanriid);
//        }
//
//
//        @Override
//        public List<KW_NkSiharaiWk> getAllNkSiharaiWk() {
//            return workflowDomManager.getAllNkSiharaiWk();
//        }
//
//
//        @Override
//        public KW_NkSiharaiWk getNkSiharaiWk(String pKouteikanriid) {
//            return workflowDomManager.getNkSiharaiWk(pKouteikanriid);
//        }
//
//
//        @Override
//        public List<KW_NkSibouWk> getAllNkSibouWk() {
//            return workflowDomManager.getAllNkSibouWk();
//        }
//
//
//        @Override
//        public KW_NkSibouWk getNkSibouWk(String pKouteikanriid) {
//            return workflowDomManager.getNkSibouWk(pKouteikanriid);
//        }
//
//
//        @Override
//        public List<KW_NkSaihakkouWk> getAllNkSaihakkouWk() {
//            return workflowDomManager.getAllNkSaihakkouWk();
//        }
//
//
//        @Override
//        public KW_NkSaihakkouWk getNkSaihakkouWk(String pKouteikanriid) {
//            return workflowDomManager.getNkSaihakkouWk(pKouteikanriid);
//        }
//
//
//        @Override
//        public List<KW_NkMeigiJyuusyoHenkouWk> getAllNkMeigiJyuusyoHenkouWk() {
//            return workflowDomManager.getAllNkMeigiJyuusyoHenkouWk();
//        }
//
//
//        @Override
//        public KW_NkMeigiJyuusyoHenkouWk getNkMeigiJyuusyoHenkouWk(String pKouteikanriid) {
//            return workflowDomManager.getNkMeigiJyuusyoHenkouWk(pKouteikanriid);
//        }
//
//
//        @Override
//        public List<KW_NkKaisuuHenkouWk> getAllNkKaisuuHenkouWk() {
//            return workflowDomManager.getAllNkKaisuuHenkouWk();
//        }
//
//
//        @Override
//        public KW_NkKaisuuHenkouWk getNkKaisuuHenkouWk(String pKouteikanriid) {
//            return workflowDomManager.getNkKaisuuHenkouWk(pKouteikanriid);
//        }
//
//
//        @Override
//        public List<KW_NkTokuyakuHenkouWk> getAllNkTokuyakuHenkouWk() {
//            return workflowDomManager.getAllNkTokuyakuHenkouWk();
//        }
//
//
//        @Override
//        public KW_NkTokuyakuHenkouWk getNkTokuyakuHenkouWk(String pKouteikanriid) {
//            return workflowDomManager.getNkTokuyakuHenkouWk(pKouteikanriid);
//        }
//
//
//        @Override
//        public List<KW_NkHubiWk> getAllNkHubiWk() {
//            return workflowDomManager.getAllNkHubiWk();
//        }
//
//
//        @Override
//        public KW_NkHubiWk getNkHubiWk(String pKouteikanriid) {
//            return workflowDomManager.getNkHubiWk(pKouteikanriid);
//        }
//
//
//        @Override
//        public List<KW_NkHubiKaisyouDetailWk> getAllNkHubiKaisyouDetailWk() {
//            return workflowDomManager.getAllNkHubiKaisyouDetailWk();
//        }
//
//
//        @Override
//        public KW_NkHubiKaisyouDetailWk getNkHubiKaisyouDetailWk(String pKouteikanriid, Integer pRenno3keta) {
//            return workflowDomManager.getNkHubiKaisyouDetailWk(pKouteikanriid, pRenno3keta);
//        }
//
//
//
//        @Override
//        public Long getNkTetudukiRirekiCountByNksysynoShrsyousaiumuSyoriYmdGe(String pNksysyno, C_UmuKbn pShrsyousaiumu, BizDate pSyoriYmd) {
//            return rirekiDomManager.getNkTetudukiRirekiCountByNksysynoShrsyousaiumuSyoriYmdGe(pNksysyno, pShrsyousaiumu, pSyoriYmd);
//        }
//
//
//        @Override
//        public Long getNkTetudukiRirekiCountByNksysynoTtdksyousaiumuSyoriYmdGe(String pNksysyno, C_UmuKbn pTtdksyousaiumu, BizDate pSyoriYmd) {
//            return rirekiDomManager.getNkTetudukiRirekiCountByNksysynoTtdksyousaiumuSyoriYmdGe(pNksysyno, pTtdksyousaiumu, pSyoriYmd);
//        }
//
//
//        @Override
//        public Long getNkTetudukiRirekiCountByNksysyno(String pNksysyno) {
//            return rirekiDomManager.getNkTetudukiRirekiCountByNksysyno(pNksysyno);
//        }
//
//
//        @Override
//        public String getNkSiharaiRirekiMaxNkshrsikibetukeyByNksysynoTorikesiflg(String pNksysyno, C_UmuKbn pTorikesiflg) {
//            return rirekiDomManager.getNkSiharaiRirekiMaxNkshrsikibetukeyByNksysynoTorikesiflg(pNksysyno, pTorikesiflg);
//        }
//
//
//        @Override
//        public ExDBResults<KT_NkSiharaiRireki> getNkSiharaiRirekisBySyoriYmd(BizDate pSyoriYmd) {
//            return rirekiDomManager.getNkSiharaiRirekisBySyoriYmd(pSyoriYmd);
//        }
//
//
//        @Override
//        public ExDBResults<KT_NkSiharaiRireki> getNkSiharaiRirekisByＮksysynoShrtynd(String pNksysyno, BizDateY pShrtynd) {
//            return rirekiDomManager.getNkSiharaiRirekisByＮksysynoShrtynd(pNksysyno, pShrtynd);
//        }
//
//
//        @Override
//        public List<Object[]> getNenkinOnlineBySyoriYmdSubSystemIdKensuuhyoujijyun(BizDate pSyoriYmd, String pSubSystemId) {
//            return rirekiDomManager.getNenkinOnlineBySyoriYmdSubSystemIdKensuuhyoujijyun(pSyoriYmd, pSubSystemId);
//        }
//
//
//        @Override
//        public Long getNkSiharaiRirekiCountByNksysynoTorikesiflg(String pNksysyno, C_UmuKbn pTorikesiflg) {
//            return rirekiDomManager.getNkSiharaiRirekiCountByNksysynoTorikesiflg(pNksysyno, pTorikesiflg);
//        }
//
//
//        @Override
//        public KT_NkSiharaiRireki getNkSiharaiRirekiByNksysynoTorikesiflgMaxNkshrsikibetukey(String pNksysyno, C_UmuKbn pTorikesiflg) {
//            return rirekiDomManager.getNkSiharaiRirekiByNksysynoTorikesiflgMaxNkshrsikibetukey(pNksysyno, pTorikesiflg);
//        }
//
//
//        @Override
//        public ExDBResults<NkSiharaiTyousyoSakuseisByShrtyndItemsBean> getNkSiharaiTyousyoSakuseisByShrtyndItems(BizDateY pShrtynd) {
//            return rirekiDomManager.getNkSiharaiTyousyoSakuseisByShrtyndItems(pShrtynd);
//        }
//
//
//        @Override
//        public KT_NkUketorininRireki getNkUketorininRirekiByNksysynoMaxSeqno(String pNksysyno) {
//            return rirekiDomManager.getNkUketorininRirekiByNksysynoMaxSeqno(pNksysyno);
//        }
//
//
//        @Override
//        public List<KT_NkTetudukiRireki> getNkTetudukiRirekisByGyoumuKousinKinou(String pSubSystemId, BizDate pSyorikknfromymd, BizDate pSyorikkntoymd, String... pGyoumuKousinKinou) {
//            return rirekiDomManager.getNkTetudukiRirekisByGyoumuKousinKinou(pSubSystemId, pSyorikknfromymd, pSyorikkntoymd, pGyoumuKousinKinou);
//        }
//
//
//        @Override
//        public Long getNkTetudukiRirekiCountByGyoumuKousinKinou(String pSubSystemId, BizDate pSyorikknfromymd, BizDate pSyorikkntoymd, String... pGyoumuKousinKinou) {
//            return rirekiDomManager.getNkTetudukiRirekiCountByGyoumuKousinKinou(pSubSystemId, pSyorikknfromymd, pSyorikkntoymd, pGyoumuKousinKinou);
//        }
//
//
//        @Override
//        public BizDate getNkUketorininRirekiMaxSibouymdByNksysynoSibouymdTorikesiflg(String pNksysyno, BizDate pSibouymd, C_UmuKbn pTorikesiflg) {
//            return rirekiDomManager.getNkUketorininRirekiMaxSibouymdByNksysynoSibouymdTorikesiflg(pNksysyno, pSibouymd, pTorikesiflg);
//        }

}
