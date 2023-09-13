package yuyu.def.direct.manager.impl;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.db.ExDBUpdatableResults;
import yuyu.def.base.manager.AbstractDomManager;
import yuyu.def.classification.C_DsKrHnnKakCdTtYhKbn;
import yuyu.def.classification.C_DsKzkJmKknHsJyKbn;
import yuyu.def.classification.C_DsSousinMailSyubetuKbn;
import yuyu.def.classification.C_DsTtdksyubetuKbn;
import yuyu.def.db.entity.MT_BAK_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsHanyouKokyakuateTuuti;
import yuyu.def.db.entity.MT_DsHonninKakuninCd;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsKokyakuKeiyaku;
import yuyu.def.db.entity.MT_DsKouzokuJimuKakunin;
import yuyu.def.db.entity.MT_DsMailAddressSpiralYyk;
import yuyu.def.db.entity.MT_DsMailHaisin;
import yuyu.def.db.entity.MT_DsMailHaisinYoyaku;
import yuyu.def.db.entity.MT_DsNeugokiHanteiKekka;
import yuyu.def.db.entity.MT_DsTourokuUkKanri;
import yuyu.def.db.entity.MT_KhHenkouUktkYyk;
import yuyu.def.db.entity.MT_SousaRireki;
import yuyu.def.db.entity.MW_DsMailHaisinRirekiWk;
import yuyu.def.db.entity.MW_DsNeugokiHanteiKekkaWk;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.def.direct.result.bean.DsKokKnrInfosByDskrhnnkakcdttyhkbnSyoriYmdBean;
import yuyu.def.direct.result.bean.DsKokyakuInfoBySyonoDskykmukouhyjROWNUMBean;
import yuyu.def.direct.result.bean.DsKokyakuKanrisByItemsBean;


/**
 * ダイレクトサービス DOM マネージャ 実装クラス<br />
 * {@link DirectDomManager}で宣言したメソッドを実装します。<br />
 * カテゴリDomマネージャを業務機能から隠蔽するために、抽象クラスと実装クラスに分離して、<br />
 * 業務機能からは見えない実装クラスで、カテゴリDomマネージャを使用しています。 <br />
 */
public class DirectDomManagerImpl extends AbstractDomManager implements DirectDomManager {

    @Inject
    private DirectInfoDomManager directInfoDomManager;

    @Inject
    private SonotaRenndouInfoDomManager sonotaRenndouInfoDomManager;

    @Inject
    private DirectWkInfoDommanager directWkInfoDommanager;

    @Inject
    private TourokujyouknrInfoDomManager tourokujyouknrInfoDomManager;

    @Inject
    private HozenRenndouInfoDomManager hozenRenndouInfoDomManager;

    @Inject
    private SousaRirekiInfoDomManager sousaRirekiInfoDomManager;

    @Override
    public List<MT_DsKokyakuKanri> getAllDsKokyakuKanri() {
        return directInfoDomManager.getAllDsKokyakuKanri();
    }

    @Override
    public MT_DsKokyakuKanri getDsKokyakuKanri(String pDskokno) {
        return directInfoDomManager.getDsKokyakuKanri(pDskokno);
    }

    @Override
    public List<MT_DsKokyakuKeiyaku> getDsKokyakuKeiyakusBySyonoDskykmukouhyjBlank(String pSyono) {
        return directInfoDomManager.getDsKokyakuKeiyakusBySyonoDskykmukouhyjBlank(pSyono);
    }

    @Override
    public List<MT_DsKokyakuKeiyaku> getDsKokyakuKeiyakusBySyono(String pSyono) {
        return directInfoDomManager.getDsKokyakuKeiyakusBySyono(pSyono);
    }

    @Override
    public ExDBUpdatableResults<MT_DsKokyakuKanri>  getDsKokyakuKanrisByKakutyoujobcdDskokyakujtkbnSeisahuyouhyjDskykmukouhyj(String pKakutyoujobcd) {
        return directInfoDomManager.getDsKokyakuKanrisByKakutyoujobcdDskokyakujtkbnSeisahuyouhyjDskykmukouhyj(pKakutyoujobcd);
    }

    @Override
    public List<MT_BAK_DsKokyakuKanri> getAllBAKDsKokyakuKanri() {
        return directInfoDomManager.getAllBAKDsKokyakuKanri();
    }

    @Override
    public MT_BAK_DsKokyakuKanri getBAKDsKokyakuKanri(String pDskokno, String pTrkssikibetukey) {
        return directInfoDomManager.getBAKDsKokyakuKanri(pDskokno, pTrkssikibetukey);
    }

    @Override
    public ExDBUpdatableResults<MT_DsKokyakuKanri> getDsKokyakuKanrisByKakutyoujobcd(String pKakutyoujobcd) {
        return directInfoDomManager.getDsKokyakuKanrisByKakutyoujobcd(pKakutyoujobcd);
    }



    @Override
    public List<MT_DsKokyakuKeiyaku> getDsKokyakuKeiyakusByDskoknoDskykmukouhyjSyutkkbnYuukousyoumetukbn(String pDskokno) {
        return directInfoDomManager.getDsKokyakuKeiyakusByDskoknoDskykmukouhyjSyutkkbnYuukousyoumetukbn(pDskokno);
    }

    @Override
    public ExDBUpdatableResults<MT_DsKokyakuKanri> getDsKokyakuKanrisByDskokyakujtkbnDsteisiriyuukbnDskrhnnkakcdsetymd() {
        return directInfoDomManager.getDsKokyakuKanrisByDskokyakujtkbnDsteisiriyuukbnDskrhnnkakcdsetymd();
    }

    @Override
    public ExDBUpdatableResults<MT_DsKokyakuKanri> getDsKokyakuKanrisByDskrhnnkakcdttyhkbnDskrhnnkakcdttshjyhsymd(C_DsKrHnnKakCdTtYhKbn pDskrhnnkakcdttyhkbn, BizDate pDskrhnnkakcdttshjyhsymd) {
        return directInfoDomManager.getDsKokyakuKanrisByDskrhnnkakcdttyhkbnDskrhnnkakcdttshjyhsymd(pDskrhnnkakcdttyhkbn, pDskrhnnkakcdttshjyhsymd);
    }

    @Override
    public List<MT_DsKokyakuKanri> getDsKokyakuKanrisBySyono(String pSyono) {
        return directInfoDomManager.getDsKokyakuKanrisBySyono(pSyono);
    }

    @Override
    public List<DsKokyakuKanrisByItemsBean> getDsKokyakuKanrisByItems(String pDskokyakunmkn, String pDskokyakunmkj, BizDate pDskokyakuseiymd, String pDskokyakuyno) {
        return directInfoDomManager.getDsKokyakuKanrisByItems(pDskokyakunmkn, pDskokyakunmkj, pDskokyakuseiymd, pDskokyakuyno);
    }

    @Override
    public List<MT_DsKokyakuKanri> getDsKokyakuKanrisBySyonoDskykmukouhyj(String pSyono) {
        return directInfoDomManager.getDsKokyakuKanrisBySyonoDskykmukouhyj(pSyono);
    }

    @Override
    public DsKokyakuInfoBySyonoDskykmukouhyjROWNUMBean getDsKokyakuInfoBySyonoDskykmukouhyjROWNUM(String pSyono) {
        return directInfoDomManager.getDsKokyakuInfoBySyonoDskykmukouhyjROWNUM(pSyono);
    }

    @Override
    public List<MT_DsKokyakuKanri> getDsKokyakuKanrisByDskokyakujtkbnNe(String pDskokyakunmkn, String pDskokyakunmkj, BizDate pDskokyakuseiymd, String pDskokyakuyno) {
        return directInfoDomManager.getDsKokyakuKanrisByDskokyakujtkbnNe(pDskokyakunmkn, pDskokyakunmkj, pDskokyakuseiymd, pDskokyakuyno);
    }

    @Override
    public ExDBResults<MT_DsHanyouKokyakuateTuuti> getDsHanyouKokyakuateTuutisByDsdatasakuseiymd(BizDate pDsdatasakuseiymd) {
        return directInfoDomManager.getDsHanyouKokyakuateTuutisByDsdatasakuseiymd(pDsdatasakuseiymd);
    }

    @Override
    public ExDBResults<MT_DsHonninKakuninCd> getDsHonninKakuninCdsByDskrhnnkakcdttshjyhsymd(BizDate pDskrhnnkakcdttshjyhsymd) {
        return directInfoDomManager.getDsHonninKakuninCdsByDskrhnnkakcdttshjyhsymd(pDskrhnnkakcdttshjyhsymd);
    }

    @Override
    public ExDBResults<DsKokKnrInfosByDskrhnnkakcdttyhkbnSyoriYmdBean> getDsKokKnrInfosByDskrhnnkakcdttyhkbnSyoriYmd(BizDate pSyoriYmd) {
        return directInfoDomManager.getDsKokKnrInfosByDskrhnnkakcdttyhkbnSyoriYmd(pSyoriYmd);
    }

    @Override
    public ExDBResults<MT_DsMailAddressSpiralYyk> getDsMailAddressSpiralYyksByDsdatasakuseiymd(BizDate pDsdatasakuseiymd) {
        return directInfoDomManager.getDsMailAddressSpiralYyksByDsdatasakuseiymd(pDsdatasakuseiymd);
    }

    @Override
    public List<MT_DsNeugokiHanteiKekka> getAllDsNeugokiHanteiKekka() {
        return directInfoDomManager.getAllDsNeugokiHanteiKekka();
    }

    @Override
    public MT_DsNeugokiHanteiKekka getDsNeugokiHanteiKekka(BizDate pDsdatasakuseiymd, String pSyono) {
        return directInfoDomManager.getDsNeugokiHanteiKekka(pDsdatasakuseiymd, pSyono);
    }

    @Override
    public List<MT_DsMailHaisin> getAllDsMailHaisin() {
        return directInfoDomManager.getAllDsMailHaisin();
    }

    @Override
    public MT_DsMailHaisin getDsMailHaisin(BizDate pSousinymd, String pDskokmailaddressskbtkey, C_DsSousinMailSyubetuKbn pDssousinmailsyubetukbn
        , String pDssousinno) {
        return directInfoDomManager.getDsMailHaisin(pSousinymd, pDskokmailaddressskbtkey, pDssousinmailsyubetukbn
            , pDssousinno);
    }

    @Override
    public MT_DsMailHaisinYoyaku getDsMailHaisinYoyaku(String pDsmailhaisinyoyakuskbtkey) {
        return directInfoDomManager.getDsMailHaisinYoyaku(pDsmailhaisinyoyakuskbtkey);
    }

    @Override
    public List<MT_DsMailHaisinYoyaku> getAllDsMailHaisinYoyaku() {
        return directInfoDomManager.getAllDsMailHaisinYoyaku();
    }

    @Override
    public List<MT_DsKouzokuJimuKakunin> getAllDsKouzokuJimuKakunin() {
        return sonotaRenndouInfoDomManager.getAllDsKouzokuJimuKakunin();
    }

    @Override
    public MT_DsKouzokuJimuKakunin getDsKouzokuJimuKakunin(BizDate pHasseiymd, C_DsKzkJmKknHsJyKbn pDskzkjmkknhsjykbn, String pSyono) {
        return sonotaRenndouInfoDomManager.getDsKouzokuJimuKakunin(pHasseiymd, pDskzkjmkknhsjykbn, pSyono);
    }

    @Override
    public ExDBResults<MT_DsKouzokuJimuKakunin> getDsKouzokuJimuKakuninsByHasseiymd(BizDate pHasseiymd) {
        return sonotaRenndouInfoDomManager.getDsKouzokuJimuKakuninsByHasseiymd(pHasseiymd);
    }

    @Override
    public List<MW_DsNeugokiHanteiKekkaWk> getAllDsNeugokiHanteiKekkaWk() {
        return directWkInfoDommanager.getAllDsNeugokiHanteiKekkaWk();
    }

    @Override
    public MW_DsNeugokiHanteiKekkaWk getDsNeugokiHanteiKekkaWk(BizDate pDsdatasakuseiymd, String pSyono) {
        return directWkInfoDommanager.getDsNeugokiHanteiKekkaWk(pDsdatasakuseiymd, pSyono);
    }

    @Override
    public List<MW_DsMailHaisinRirekiWk> getAllDsMailHaisinRirekiWk() {
        return directWkInfoDommanager.getAllDsMailHaisinRirekiWk();
    }

    @Override
    public MW_DsMailHaisinRirekiWk getDsMailHaisinRirekiWk(BizDate pDsdatasakuseiymd, String pDskokno, Integer pDsmailhaisinrenban) {
        return directWkInfoDommanager.getDsMailHaisinRirekiWk(pDsdatasakuseiymd, pDskokno, pDsmailhaisinrenban);
    }

    @Override
    public List<MT_DsTourokuUkKanri> getAllDsTourokuUkKanri() {
        return tourokujyouknrInfoDomManager.getAllDsTourokuUkKanri();
    }

    @Override
    public MT_DsTourokuUkKanri getDsTourokuUkKanri(String pSyono, C_DsTtdksyubetuKbn pDsttdksyubetukbn, Integer pDatarenno) {
        return tourokujyouknrInfoDomManager.getDsTourokuUkKanri(pSyono, pDsttdksyubetukbn, pDatarenno);
    }

    @Override
    public List<MT_KhHenkouUktkYyk> getAllKhHenkouUktkYyk() {
        return hozenRenndouInfoDomManager.getAllKhHenkouUktkYyk();
    }

    @Override
    public MT_KhHenkouUktkYyk getKhHenkouUktkYyk(String pSyono, Integer pHozenhenkouuktkrenno) {
        return hozenRenndouInfoDomManager.getKhHenkouUktkYyk(pSyono, pHozenhenkouuktkrenno);
    }

    @Override
    public List<MT_SousaRireki> getAllSousaRireki() {
        return sousaRirekiInfoDomManager.getAllSousaRireki();
    }

    @Override
    public MT_SousaRireki getSousaRireki(String pTtdksikibetuid) {
        return sousaRirekiInfoDomManager.getSousaRireki(pTtdksikibetuid);
    }
}
